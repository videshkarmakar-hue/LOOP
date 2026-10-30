package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    View mView;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[this.MAX_DIMENSION];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private int mPathMotionArc = Key.UNSET;

    MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    MotionController(View view) {
        setView(view);
    }

    float getStartX() {
        return this.mStartMotionPath.f190x;
    }

    float getStartY() {
        return this.mStartMotionPath.f191y;
    }

    float getFinalX() {
        return this.mEndMotionPath.f190x;
    }

    float getFinalY() {
        return this.mEndMotionPath.f191y;
    }

    void buildPath(float[] points, int pointCount) {
        MotionController motionController = this;
        int i = pointCount;
        float f = 1.0f;
        float mils = 1.0f / (i - 1);
        SplineSet trans_x = motionController.mAttributesMap == null ? null : motionController.mAttributesMap.get("translationX");
        SplineSet trans_y = motionController.mAttributesMap == null ? null : motionController.mAttributesMap.get("translationY");
        KeyCycleOscillator osc_x = motionController.mCycleMap == null ? null : motionController.mCycleMap.get("translationX");
        KeyCycleOscillator osc_y = motionController.mCycleMap != null ? motionController.mCycleMap.get("translationY") : null;
        int i2 = 0;
        while (i2 < i) {
            float position = i2 * mils;
            if (motionController.mStaggerScale != f) {
                if (position < motionController.mStaggerOffset) {
                    position = 0.0f;
                }
                if (position > motionController.mStaggerOffset && position < 1.0d) {
                    position = (position - motionController.mStaggerOffset) * motionController.mStaggerScale;
                }
            }
            double p = position;
            Easing easing = motionController.mStartMotionPath.mKeyFrameEasing;
            float start = 0.0f;
            float end = Float.NaN;
            for (MotionPaths frame : motionController.mMotionPaths) {
                float mils2 = mils;
                if (frame.mKeyFrameEasing != null) {
                    if (frame.time < position) {
                        Easing easing2 = frame.mKeyFrameEasing;
                        start = frame.time;
                        easing = easing2;
                    } else if (Float.isNaN(end)) {
                        end = frame.time;
                    }
                }
                mils = mils2;
            }
            float mils3 = mils;
            if (easing != null) {
                if (Float.isNaN(end)) {
                    end = 1.0f;
                }
                float offset = (position - start) / (end - start);
                p = ((end - start) * ((float) easing.get(offset))) + start;
            }
            motionController.mSpline[0].getPos(p, motionController.mInterpolateData);
            if (motionController.mArcSpline != null && motionController.mInterpolateData.length > 0) {
                motionController.mArcSpline.getPos(p, motionController.mInterpolateData);
            }
            motionController.mStartMotionPath.getCenter(motionController.mInterpolateVariables, motionController.mInterpolateData, points, i2 * 2);
            if (osc_x != null) {
                int i3 = i2 * 2;
                points[i3] = points[i3] + osc_x.get(position);
            } else if (trans_x != null) {
                int i4 = i2 * 2;
                points[i4] = points[i4] + trans_x.get(position);
            }
            if (osc_y != null) {
                int i5 = (i2 * 2) + 1;
                points[i5] = points[i5] + osc_y.get(position);
            } else if (trans_y != null) {
                int i6 = (i2 * 2) + 1;
                points[i6] = points[i6] + trans_y.get(position);
            }
            i2++;
            motionController = this;
            i = pointCount;
            mils = mils3;
            f = 1.0f;
        }
    }

    void buildBounds(float[] bounds, int pointCount) {
        MotionController motionController = this;
        int i = pointCount;
        float f = 1.0f;
        float mils = 1.0f / (i - 1);
        SplineSet trans_x = motionController.mAttributesMap == null ? null : motionController.mAttributesMap.get("translationX");
        if (motionController.mAttributesMap != null) {
            motionController.mAttributesMap.get("translationY");
        }
        if (motionController.mCycleMap != null) {
            motionController.mCycleMap.get("translationX");
        }
        if (motionController.mCycleMap != null) {
            motionController.mCycleMap.get("translationY");
        }
        int i2 = 0;
        while (i2 < i) {
            float position = i2 * mils;
            if (motionController.mStaggerScale != f) {
                if (position < motionController.mStaggerOffset) {
                    position = 0.0f;
                }
                if (position > motionController.mStaggerOffset && position < 1.0d) {
                    position = (position - motionController.mStaggerOffset) * motionController.mStaggerScale;
                }
            }
            double p = position;
            Easing easing = motionController.mStartMotionPath.mKeyFrameEasing;
            float start = 0.0f;
            float end = Float.NaN;
            for (MotionPaths frame : motionController.mMotionPaths) {
                if (frame.mKeyFrameEasing != null) {
                    if (frame.time < position) {
                        Easing easing2 = frame.mKeyFrameEasing;
                        start = frame.time;
                        easing = easing2;
                    } else if (Float.isNaN(end)) {
                        end = frame.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(end)) {
                    end = 1.0f;
                }
                float offset = (position - start) / (end - start);
                p = ((end - start) * ((float) easing.get(offset))) + start;
            }
            motionController.mSpline[0].getPos(p, motionController.mInterpolateData);
            if (motionController.mArcSpline != null && motionController.mInterpolateData.length > 0) {
                motionController.mArcSpline.getPos(p, motionController.mInterpolateData);
            }
            motionController.mStartMotionPath.getBounds(motionController.mInterpolateVariables, motionController.mInterpolateData, bounds, i2 * 2);
            i2++;
            motionController = this;
            i = pointCount;
            mils = mils;
            trans_x = trans_x;
            f = 1.0f;
        }
    }

    private float getPreCycleDistance() {
        int pointCount = 100;
        float[] points = new float[2];
        float sum = 0.0f;
        float mils = 1.0f / (100 - 1);
        double x = 0.0d;
        double y = 0.0d;
        int i = 0;
        while (i < pointCount) {
            float position = i * mils;
            double p = position;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float start = 0.0f;
            float end = Float.NaN;
            int pointCount2 = pointCount;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                Iterator<MotionPaths> it2 = it;
                MotionPaths frame = it.next();
                float mils2 = mils;
                if (frame.mKeyFrameEasing != null) {
                    if (frame.time < position) {
                        Easing easing2 = frame.mKeyFrameEasing;
                        start = frame.time;
                        easing = easing2;
                    } else if (Float.isNaN(end)) {
                        end = frame.time;
                    }
                }
                mils = mils2;
                it = it2;
            }
            float mils3 = mils;
            if (easing != null) {
                if (Float.isNaN(end)) {
                    end = 1.0f;
                }
                float offset = (position - start) / (end - start);
                p = ((end - start) * ((float) easing.get(offset))) + start;
            }
            this.mSpline[0].getPos(p, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, points, 0);
            if (i > 0) {
                sum = (float) (((double) sum) + Math.hypot(y - ((double) points[1]), x - ((double) points[0])));
            }
            x = points[0];
            y = points[1];
            i++;
            pointCount = pointCount2;
            mils = mils3;
        }
        return sum;
    }

    KeyPositionBase getPositionKeyframe(int layoutWidth, int layoutHeight, float x, float y) {
        RectF start = new RectF();
        start.left = this.mStartMotionPath.f190x;
        start.top = this.mStartMotionPath.f191y;
        start.right = start.left + this.mStartMotionPath.width;
        start.bottom = start.top + this.mStartMotionPath.height;
        RectF end = new RectF();
        end.left = this.mEndMotionPath.f190x;
        end.top = this.mEndMotionPath.f191y;
        end.right = end.left + this.mEndMotionPath.width;
        end.bottom = end.top + this.mEndMotionPath.height;
        for (Key key : this.mKeyList) {
            if ((key instanceof KeyPositionBase) && ((KeyPositionBase) key).intersects(layoutWidth, layoutHeight, start, end, x, y)) {
                return (KeyPositionBase) key;
            }
        }
        return null;
    }

    int buildKeyFrames(float[] keyFrames, int[] mode) {
        if (keyFrames == null) {
            return 0;
        }
        int count = 0;
        double[] time = this.mSpline[0].getTimePoints();
        if (mode != null) {
            for (MotionPaths keyFrame : this.mMotionPaths) {
                mode[count] = keyFrame.mMode;
                count++;
            }
            count = 0;
        }
        for (double d : time) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, keyFrames, count);
            count += 2;
        }
        return count / 2;
    }

    int buildKeyBounds(float[] keyBounds, int[] mode) {
        if (keyBounds == null) {
            return 0;
        }
        int count = 0;
        double[] time = this.mSpline[0].getTimePoints();
        if (mode != null) {
            for (MotionPaths keyFrame : this.mMotionPaths) {
                mode[count] = keyFrame.mMode;
                count++;
            }
            count = 0;
        }
        for (double d : time) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, keyBounds, count);
            count += 2;
        }
        return count / 2;
    }

    int getAttributeValues(String attributeType, float[] points, int pointCount) {
        float f = 1.0f / (pointCount - 1);
        SplineSet spline = this.mAttributesMap.get(attributeType);
        if (spline == null) {
            return -1;
        }
        for (int j = 0; j < points.length; j++) {
            points[j] = spline.get(j / (points.length - 1));
        }
        int j2 = points.length;
        return j2;
    }

    void buildRect(float p, float[] path, int offset) {
        this.mSpline[0].getPos(getAdjustedPosition(p, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, path, offset);
    }

    void buildRectangles(float[] path, int pointCount) {
        float mils = 1.0f / (pointCount - 1);
        for (int i = 0; i < pointCount; i++) {
            float position = i * mils;
            this.mSpline[0].getPos(getAdjustedPosition(position, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, path, i * 8);
        }
    }

    float getKeyFrameParameter(int type, float x, float y) {
        float dx = this.mEndMotionPath.f190x - this.mStartMotionPath.f190x;
        float dy = this.mEndMotionPath.f191y - this.mStartMotionPath.f191y;
        float startCenterX = this.mStartMotionPath.f190x + (this.mStartMotionPath.width / 2.0f);
        float startCenterY = this.mStartMotionPath.f191y + (this.mStartMotionPath.height / 2.0f);
        float hypot = (float) Math.hypot(dx, dy);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float vx = x - startCenterX;
        float vy = y - startCenterY;
        float distFromStart = (float) Math.hypot(vx, vy);
        if (distFromStart == 0.0f) {
            return 0.0f;
        }
        float pathDistance = (vx * dx) + (vy * dy);
        switch (type) {
            case 0:
                return pathDistance / hypot;
            case 1:
                return (float) Math.sqrt((hypot * hypot) - (pathDistance * pathDistance));
            case 2:
                return vx / dx;
            case 3:
                return vy / dx;
            case 4:
                return vx / dy;
            case 5:
                return vy / dy;
            default:
                return 0.0f;
        }
    }

    private void insertKey(MotionPaths point) {
        int pos = Collections.binarySearch(this.mMotionPaths, point);
        if (pos == 0) {
            Log.e(TAG, " KeyPath positon \"" + point.position + "\" outside of range");
        }
        this.mMotionPaths.add((-pos) - 1, point);
    }

    void addKeys(ArrayList<Key> list) {
        this.mKeyList.addAll(list);
    }

    void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void setPathMotionArc(int arc) {
        this.mPathMotionArc = arc;
    }

    public void setup(int parentWidth, int parentHeight, float transitionDuration, long currentTime) {
        boolean[] mask;
        Iterator<String> it;
        TimeCycleSplineSet splineSets;
        SplineSet splineSets2;
        HashSet<String> springAttributes;
        HashSet<String> springAttributes2 = new HashSet<>();
        HashSet<String> timeCycleAttributes = new HashSet<>();
        HashSet<String> splineAttributes = new HashSet<>();
        HashSet<String> cycleAttributes = new HashSet<>();
        HashMap<String, Integer> interpolation = new HashMap<>();
        ArrayList<KeyTrigger> triggerList = null;
        if (this.mPathMotionArc != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
        }
        this.mStartPoint.different(this.mEndPoint, splineAttributes);
        if (this.mKeyList != null) {
            for (Key key : this.mKeyList) {
                if (key instanceof KeyPosition) {
                    KeyPosition keyPath = (KeyPosition) key;
                    springAttributes = springAttributes2;
                    insertKey(new MotionPaths(parentWidth, parentHeight, keyPath, this.mStartMotionPath, this.mEndMotionPath));
                    if (keyPath.mCurveFit != Key.UNSET) {
                        this.mCurveFitType = keyPath.mCurveFit;
                    }
                } else {
                    springAttributes = springAttributes2;
                    if (key instanceof KeyCycle) {
                        key.getAttributeNames(cycleAttributes);
                    } else if (key instanceof KeyTimeCycle) {
                        key.getAttributeNames(timeCycleAttributes);
                    } else if (key instanceof KeyTrigger) {
                        if (triggerList == null) {
                            triggerList = new ArrayList<>();
                        }
                        triggerList.add((KeyTrigger) key);
                    } else {
                        key.setInterpolation(interpolation);
                        key.getAttributeNames(splineAttributes);
                    }
                }
                springAttributes2 = springAttributes;
            }
        }
        if (triggerList != null) {
            this.mKeyTriggers = (KeyTrigger[]) triggerList.toArray(new KeyTrigger[0]);
        }
        char c = 1;
        if (!splineAttributes.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            for (String attribute : splineAttributes) {
                if (attribute.startsWith("CUSTOM,")) {
                    SparseArray<ConstraintAttribute> attrList = new SparseArray<>();
                    String customAttributeName = attribute.split(",")[c];
                    for (Key key2 : this.mKeyList) {
                        if (key2.mCustomConstraints != null) {
                            ConstraintAttribute customAttribute = key2.mCustomConstraints.get(customAttributeName);
                            if (customAttribute != null) {
                                attrList.append(key2.mFramePosition, customAttribute);
                            }
                        }
                    }
                    splineSets2 = SplineSet.makeCustomSpline(attribute, attrList);
                } else {
                    splineSets2 = SplineSet.makeSpline(attribute);
                }
                if (splineSets2 == null) {
                    c = 1;
                } else {
                    splineSets2.setType(attribute);
                    this.mAttributesMap.put(attribute, splineSets2);
                    c = 1;
                }
            }
            if (this.mKeyList != null) {
                for (Key key3 : this.mKeyList) {
                    if (key3 instanceof KeyAttributes) {
                        key3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String spline : this.mAttributesMap.keySet()) {
                int curve = 0;
                if (interpolation.containsKey(spline)) {
                    curve = interpolation.get(spline).intValue();
                }
                this.mAttributesMap.get(spline).setup(curve);
            }
        }
        if (!timeCycleAttributes.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it2 = timeCycleAttributes.iterator();
            while (it2.hasNext()) {
                String attribute2 = it2.next();
                if (!this.mTimeCycleAttributesMap.containsKey(attribute2)) {
                    if (attribute2.startsWith("CUSTOM,")) {
                        SparseArray<ConstraintAttribute> attrList2 = new SparseArray<>();
                        String customAttributeName2 = attribute2.split(",")[1];
                        for (Key key4 : this.mKeyList) {
                            if (key4.mCustomConstraints != null) {
                                ConstraintAttribute customAttribute2 = key4.mCustomConstraints.get(customAttributeName2);
                                if (customAttribute2 != null) {
                                    attrList2.append(key4.mFramePosition, customAttribute2);
                                }
                                it2 = it2;
                            }
                        }
                        it = it2;
                        splineSets = TimeCycleSplineSet.makeCustomSpline(attribute2, attrList2);
                    } else {
                        it = it2;
                        splineSets = TimeCycleSplineSet.makeSpline(attribute2, currentTime);
                    }
                    if (splineSets == null) {
                        it2 = it;
                    } else {
                        splineSets.setType(attribute2);
                        this.mTimeCycleAttributesMap.put(attribute2, splineSets);
                        it2 = it;
                    }
                }
            }
            if (this.mKeyList != null) {
                for (Key key5 : this.mKeyList) {
                    if (key5 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key5).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String spline2 : this.mTimeCycleAttributesMap.keySet()) {
                int curve2 = 0;
                if (interpolation.containsKey(spline2)) {
                    curve2 = interpolation.get(spline2).intValue();
                }
                this.mTimeCycleAttributesMap.get(spline2).setup(curve2);
            }
        }
        MotionPaths[] points = new MotionPaths[this.mMotionPaths.size() + 2];
        int count = 1;
        points[0] = this.mStartMotionPath;
        points[points.length - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        for (MotionPaths point : this.mMotionPaths) {
            points[count] = point;
            count++;
        }
        int variables = 18;
        HashSet<String> attributeNameSet = new HashSet<>();
        for (String s : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(s) && !splineAttributes.contains("CUSTOM," + s)) {
                attributeNameSet.add(s);
            }
        }
        this.mAttributeNames = (String[]) attributeNameSet.toArray(new String[0]);
        this.mAttributeInterpCount = new int[this.mAttributeNames.length];
        int i = 0;
        while (i < this.mAttributeNames.length) {
            String attributeName = this.mAttributeNames[i];
            this.mAttributeInterpCount[i] = 0;
            for (int j = 0; j < points.length; j++) {
                if (points[j].attributes.containsKey(attributeName)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i] = iArr[i] + points[j].attributes.get(attributeName).noOfInterpValues();
                    break;
                }
            }
            i++;
            timeCycleAttributes = timeCycleAttributes;
        }
        boolean arcMode = points[0].mPathMotionArc != Key.UNSET;
        boolean[] mask2 = new boolean[this.mAttributeNames.length + 18];
        int i2 = 1;
        while (i2 < points.length) {
            points[i2].different(points[i2 - 1], mask2, this.mAttributeNames, arcMode);
            i2++;
            splineAttributes = splineAttributes;
        }
        int count2 = 0;
        for (int i3 = 1; i3 < mask2.length; i3++) {
            if (mask2[i3]) {
                count2++;
            }
        }
        this.mInterpolateVariables = new int[count2];
        this.mInterpolateData = new double[this.mInterpolateVariables.length];
        this.mInterpolateVelocity = new double[this.mInterpolateVariables.length];
        int count3 = 0;
        for (int i4 = 1; i4 < mask2.length; i4++) {
            if (mask2[i4]) {
                this.mInterpolateVariables[count3] = i4;
                count3++;
            }
        }
        int i5 = points.length;
        double[][] splineData = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, this.mInterpolateVariables.length);
        double[] timePoint = new double[points.length];
        int i6 = 0;
        while (i6 < points.length) {
            points[i6].fillStandard(splineData[i6], this.mInterpolateVariables);
            timePoint[i6] = points[i6].time;
            i6++;
            arcMode = arcMode;
            count3 = count3;
        }
        int j2 = 0;
        while (j2 < this.mInterpolateVariables.length) {
            int interpolateVariable = this.mInterpolateVariables[j2];
            if (interpolateVariable < MotionPaths.names.length) {
                String s2 = MotionPaths.names[this.mInterpolateVariables[j2]] + " [";
                int i7 = 0;
                while (i7 < points.length) {
                    s2 = s2 + splineData[i7][j2];
                    i7++;
                    interpolation = interpolation;
                    triggerList = triggerList;
                }
            }
            j2++;
            interpolation = interpolation;
            triggerList = triggerList;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i8 = 0;
        while (i8 < this.mAttributeNames.length) {
            int pointCount = 0;
            double[][] splinePoints = (double[][]) null;
            double[] timePoints = null;
            String name = this.mAttributeNames[i8];
            int j3 = 0;
            while (true) {
                mask = mask2;
                if (j3 < points.length) {
                    if (!points[j3].hasCustomData(name)) {
                        variables = variables;
                    } else {
                        if (splinePoints == null) {
                            double[] timePoints2 = new double[points.length];
                            splinePoints = (double[][]) Array.newInstance((Class<?>) Double.TYPE, points.length, points[j3].getCustomDataCount(name));
                            timePoints = timePoints2;
                        }
                        timePoints[pointCount] = points[j3].time;
                        points[j3].getCustomData(name, splinePoints[pointCount], 0);
                        pointCount++;
                    }
                    j3++;
                    mask2 = mask;
                    variables = variables;
                }
            }
            this.mSpline[i8 + 1] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(timePoints, pointCount), (double[][]) Arrays.copyOf(splinePoints, pointCount));
            i8++;
            mask2 = mask;
            variables = variables;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, timePoint, splineData);
        if (points[0].mPathMotionArc != Key.UNSET) {
            int size = points.length;
            int[] mode = new int[size];
            double[] time = new double[size];
            double[][] values = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 2);
            for (int i9 = 0; i9 < size; i9++) {
                mode[i9] = points[i9].mPathMotionArc;
                time[i9] = points[i9].time;
                values[i9][0] = points[i9].f190x;
                values[i9][1] = points[i9].f191y;
            }
            this.mArcSpline = CurveFit.getArc(mode, time, values);
        }
        float distance = Float.NaN;
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            for (String attribute3 : cycleAttributes) {
                KeyCycleOscillator cycle = KeyCycleOscillator.makeSpline(attribute3);
                if (cycle != null) {
                    if (cycle.variesByPath() && Float.isNaN(distance)) {
                        distance = getPreCycleDistance();
                    }
                    cycle.setType(attribute3);
                    this.mCycleMap.put(attribute3, cycle);
                }
            }
            for (Key key6 : this.mKeyList) {
                if (key6 instanceof KeyCycle) {
                    ((KeyCycle) key6).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it3 = this.mCycleMap.values().iterator();
            while (it3.hasNext()) {
                it3.next().setup(distance);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f190x + " y: " + this.mStartMotionPath.f191y + " end: x: " + this.mEndMotionPath.f190x + " y: " + this.mEndMotionPath.f191y;
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) lp).getConstraintTag();
        }
    }

    void setStartCurrentState(View v) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(v.getX(), v.getY(), v.getWidth(), v.getHeight());
        this.mStartPoint.setState(v);
    }

    void setStartState(ConstraintWidget cw, ConstraintSet constraintSet) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds(cw.getX(), cw.getY(), cw.getWidth(), cw.getHeight());
        ConstraintSet.Constraint constraint = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(constraint);
        this.mMotionStagger = constraint.motion.mMotionStagger;
        this.mStartPoint.setState(cw, constraintSet, this.mId);
    }

    void setEndState(ConstraintWidget cw, ConstraintSet constraintSet) {
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(cw.getX(), cw.getY(), cw.getWidth(), cw.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(cw, constraintSet, this.mId);
    }

    private float getAdjustedPosition(float position, float[] velocity) {
        if (velocity != null) {
            velocity[0] = 1.0f;
        } else if (this.mStaggerScale != 1.0d) {
            if (position < this.mStaggerOffset) {
                position = 0.0f;
            }
            if (position > this.mStaggerOffset && position < 1.0d) {
                position = (position - this.mStaggerOffset) * this.mStaggerScale;
            }
        }
        float adjusted = position;
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float start = 0.0f;
        float end = Float.NaN;
        for (MotionPaths frame : this.mMotionPaths) {
            if (frame.mKeyFrameEasing != null) {
                if (frame.time < position) {
                    easing = frame.mKeyFrameEasing;
                    start = frame.time;
                } else if (Float.isNaN(end)) {
                    end = frame.time;
                }
            }
        }
        if (easing != null) {
            if (Float.isNaN(end)) {
                end = 1.0f;
            }
            float offset = (position - start) / (end - start);
            float new_offset = (float) easing.get(offset);
            adjusted = ((end - start) * new_offset) + start;
            if (velocity != null) {
                velocity[0] = (float) easing.getDiff(offset);
            }
        }
        return adjusted;
    }

    boolean interpolate(View child, float global_position, long time, KeyCache keyCache) {
        boolean timeAnimation;
        TimeCycleSplineSet.PathRotate timePathRotate;
        int i;
        float position = getAdjustedPosition(global_position, null);
        if (this.mAttributesMap != null) {
            Iterator<SplineSet> it = this.mAttributesMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(child, position);
            }
        }
        if (this.mTimeCycleAttributesMap == null) {
            timeAnimation = false;
            timePathRotate = null;
        } else {
            Iterator<TimeCycleSplineSet> it2 = this.mTimeCycleAttributesMap.values().iterator();
            boolean timeAnimation2 = false;
            TimeCycleSplineSet.PathRotate timePathRotate2 = null;
            while (timeAnimation) {
                TimeCycleSplineSet aSpline = it2.next();
                if (aSpline instanceof TimeCycleSplineSet.PathRotate) {
                    timePathRotate2 = (TimeCycleSplineSet.PathRotate) aSpline;
                } else {
                    timeAnimation2 |= aSpline.setProperty(child, position, time, keyCache);
                }
            }
            timeAnimation = timeAnimation2;
            timePathRotate = timePathRotate2;
        }
        if (this.mSpline != null) {
            this.mSpline[0].getPos(position, this.mInterpolateData);
            this.mSpline[0].getSlope(position, this.mInterpolateVelocity);
            if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos(position, this.mInterpolateData);
                this.mArcSpline.getSlope(position, this.mInterpolateVelocity);
            }
            this.mStartMotionPath.setView(child, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            if (this.mAttributesMap != null) {
                for (SplineSet aSpline2 : this.mAttributesMap.values()) {
                    if (aSpline2 instanceof SplineSet.PathRotate) {
                        ((SplineSet.PathRotate) aSpline2).setPathRotate(child, position, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]);
                    }
                }
            }
            if (timePathRotate == null) {
                i = 0;
            } else {
                i = 0;
                timeAnimation = timePathRotate.setPathRotate(child, keyCache, position, time, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]) | timeAnimation;
            }
            for (int i2 = 1; i2 < this.mSpline.length; i2++) {
                CurveFit spline = this.mSpline[i2];
                spline.getPos(position, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[i2 - 1]).setInterpolatedValue(child, this.mValuesBuff);
            }
            if (this.mStartPoint.mVisibilityMode == 0) {
                if (position <= 0.0f) {
                    child.setVisibility(this.mStartPoint.visibility);
                } else if (position < 1.0f) {
                    if (this.mEndPoint.visibility != this.mStartPoint.visibility) {
                        child.setVisibility(i);
                    }
                } else {
                    child.setVisibility(this.mEndPoint.visibility);
                }
            }
            if (this.mKeyTriggers != null) {
                for (int i3 = 0; i3 < this.mKeyTriggers.length; i3++) {
                    this.mKeyTriggers[i3].conditionallyFire(position, child);
                }
            }
        } else {
            float float_l = this.mStartMotionPath.f190x + ((this.mEndMotionPath.f190x - this.mStartMotionPath.f190x) * position);
            float float_t = this.mStartMotionPath.f191y + ((this.mEndMotionPath.f191y - this.mStartMotionPath.f191y) * position);
            float float_width = this.mStartMotionPath.width + ((this.mEndMotionPath.width - this.mStartMotionPath.width) * position);
            float float_height = this.mStartMotionPath.height + ((this.mEndMotionPath.height - this.mStartMotionPath.height) * position);
            int l = (int) (float_l + 0.5f);
            int t = (int) (float_t + 0.5f);
            int r = (int) (float_l + 0.5f + float_width);
            int b = (int) (0.5f + float_t + float_height);
            int width = r - l;
            int height = b - t;
            if (this.mEndMotionPath.width != this.mStartMotionPath.width || this.mEndMotionPath.height != this.mStartMotionPath.height) {
                int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, BasicMeasure.EXACTLY);
                int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, BasicMeasure.EXACTLY);
                child.measure(widthMeasureSpec, heightMeasureSpec);
            }
            child.layout(l, t, r, b);
        }
        if (this.mCycleMap != null) {
            for (KeyCycleOscillator osc : this.mCycleMap.values()) {
                if (osc instanceof KeyCycleOscillator.PathRotateSet) {
                    ((KeyCycleOscillator.PathRotateSet) osc).setPathRotate(child, position, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]);
                } else {
                    osc.setProperty(child, position);
                }
            }
        }
        return timeAnimation;
    }

    void getDpDt(float position, float locationX, float locationY, float[] mAnchorDpDt) {
        float position2 = getAdjustedPosition(position, this.mVelocity);
        if (this.mSpline != null) {
            this.mSpline[0].getSlope(position2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(position2, this.mInterpolateData);
            float v = this.mVelocity[0];
            for (int i = 0; i < this.mInterpolateVelocity.length; i++) {
                double[] dArr = this.mInterpolateVelocity;
                dArr[i] = dArr[i] * ((double) v);
            }
            if (this.mArcSpline == null) {
                this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                return;
            } else {
                if (this.mInterpolateData.length > 0) {
                    this.mArcSpline.getPos(position2, this.mInterpolateData);
                    this.mArcSpline.getSlope(position2, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
        }
        float dleft = this.mEndMotionPath.f190x - this.mStartMotionPath.f190x;
        float dTop = this.mEndMotionPath.f191y - this.mStartMotionPath.f191y;
        float dWidth = this.mEndMotionPath.width - this.mStartMotionPath.width;
        float dHeight = this.mEndMotionPath.height - this.mStartMotionPath.height;
        float dRight = dleft + dWidth;
        float dBottom = dTop + dHeight;
        mAnchorDpDt[0] = ((1.0f - locationX) * dleft) + (dRight * locationX);
        mAnchorDpDt[1] = ((1.0f - locationY) * dTop) + (dBottom * locationY);
    }

    void getPostLayoutDvDp(float position, int width, int height, float locationX, float locationY, float[] mAnchorDpDt) {
        VelocityMatrix vmat;
        float position2 = getAdjustedPosition(position, this.mVelocity);
        SplineSet trans_x = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationX");
        SplineSet trans_y = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationY");
        SplineSet rotation = this.mAttributesMap == null ? null : this.mAttributesMap.get("rotation");
        SplineSet scale_x = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleX");
        SplineSet scale_y = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleY");
        KeyCycleOscillator osc_x = this.mCycleMap == null ? null : this.mCycleMap.get("translationX");
        KeyCycleOscillator osc_y = this.mCycleMap == null ? null : this.mCycleMap.get("translationY");
        KeyCycleOscillator osc_r = this.mCycleMap == null ? null : this.mCycleMap.get("rotation");
        KeyCycleOscillator osc_sx = this.mCycleMap == null ? null : this.mCycleMap.get("scaleX");
        KeyCycleOscillator osc_sy = this.mCycleMap != null ? this.mCycleMap.get("scaleY") : null;
        VelocityMatrix vmat2 = new VelocityMatrix();
        vmat2.clear();
        vmat2.setRotationVelocity(rotation, position2);
        vmat2.setTranslationVelocity(trans_x, trans_y, position2);
        vmat2.setScaleVelocity(scale_x, scale_y, position2);
        vmat2.setRotationVelocity(osc_r, position2);
        vmat2.setTranslationVelocity(osc_x, osc_y, position2);
        vmat2.setScaleVelocity(osc_sx, osc_sy, position2);
        if (this.mArcSpline == null) {
            if (this.mSpline != null) {
                float position3 = getAdjustedPosition(position2, this.mVelocity);
                this.mSpline[0].getSlope(position3, this.mInterpolateVelocity);
                this.mSpline[0].getPos(position3, this.mInterpolateData);
                float v = this.mVelocity[0];
                for (int i = 0; i < this.mInterpolateVelocity.length; i++) {
                    double[] dArr = this.mInterpolateVelocity;
                    dArr[i] = dArr[i] * ((double) v);
                }
                this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                vmat2.applyTransform(locationX, locationY, width, height, mAnchorDpDt);
                return;
            }
            float dleft = this.mEndMotionPath.f190x - this.mStartMotionPath.f190x;
            float dTop = this.mEndMotionPath.f191y - this.mStartMotionPath.f191y;
            float dWidth = this.mEndMotionPath.width - this.mStartMotionPath.width;
            float dHeight = this.mEndMotionPath.height - this.mStartMotionPath.height;
            float dRight = dleft + dWidth;
            float dBottom = dTop + dHeight;
            mAnchorDpDt[0] = ((1.0f - locationX) * dleft) + (dRight * locationX);
            mAnchorDpDt[1] = ((1.0f - locationY) * dTop) + (dBottom * locationY);
            vmat2.clear();
            vmat2.setRotationVelocity(rotation, position2);
            vmat2.setTranslationVelocity(trans_x, trans_y, position2);
            vmat2.setScaleVelocity(scale_x, scale_y, position2);
            vmat2.setRotationVelocity(osc_r, position2);
            vmat2.setTranslationVelocity(osc_x, osc_y, position2);
            vmat2.setScaleVelocity(osc_sx, osc_sy, position2);
            vmat2.applyTransform(locationX, locationY, width, height, mAnchorDpDt);
            return;
        }
        if (this.mInterpolateData.length > 0) {
            this.mArcSpline.getPos(position2, this.mInterpolateData);
            this.mArcSpline.getSlope(position2, this.mInterpolateVelocity);
            vmat = vmat2;
            this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        } else {
            vmat = vmat2;
        }
        vmat.applyTransform(locationX, locationY, width, height, mAnchorDpDt);
    }

    public int getDrawPath() {
        int mode = this.mStartMotionPath.mDrawPath;
        for (MotionPaths keyFrame : this.mMotionPaths) {
            mode = Math.max(mode, keyFrame.mDrawPath);
        }
        return Math.max(mode, this.mEndMotionPath.mDrawPath);
    }

    public void setDrawPath(int debugMode) {
        this.mStartMotionPath.mDrawPath = debugMode;
    }

    String name() {
        Context context = this.mView.getContext();
        return context.getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View view, KeyPositionBase key, float x, float y, String[] attribute, float[] value) {
        RectF start = new RectF();
        start.left = this.mStartMotionPath.f190x;
        start.top = this.mStartMotionPath.f191y;
        start.right = start.left + this.mStartMotionPath.width;
        start.bottom = start.top + this.mStartMotionPath.height;
        RectF end = new RectF();
        end.left = this.mEndMotionPath.f190x;
        end.top = this.mEndMotionPath.f191y;
        end.right = end.left + this.mEndMotionPath.width;
        end.bottom = end.top + this.mEndMotionPath.height;
        key.positionAttributes(view, start, end, x, y, attribute, value);
    }

    public int getkeyFramePositions(int[] type, float[] pos) {
        int i = 0;
        int count = 0;
        for (Key key : this.mKeyList) {
            int i2 = i + 1;
            type[i] = key.mFramePosition + (key.mType * 1000);
            float time = key.mFramePosition / 100.0f;
            this.mSpline[0].getPos(time, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, pos, count);
            count += 2;
            i = i2;
        }
        return i;
    }

    public int getKeyFrameInfo(int type, int[] info) {
        int count = 0;
        int cursor = 0;
        float[] pos = new float[2];
        for (Key key : this.mKeyList) {
            if (key.mType == type || type != -1) {
                int len = cursor;
                info[cursor] = 0;
                int cursor2 = cursor + 1;
                info[cursor2] = key.mType;
                int cursor3 = cursor2 + 1;
                info[cursor3] = key.mFramePosition;
                float time = key.mFramePosition / 100.0f;
                this.mSpline[0].getPos(time, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, pos, 0);
                int cursor4 = cursor3 + 1;
                info[cursor4] = Float.floatToIntBits(pos[0]);
                int cursor5 = cursor4 + 1;
                info[cursor5] = Float.floatToIntBits(pos[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition kp = (KeyPosition) key;
                    int cursor6 = cursor5 + 1;
                    info[cursor6] = kp.mPositionType;
                    int cursor7 = cursor6 + 1;
                    info[cursor7] = Float.floatToIntBits(kp.mPercentX);
                    cursor5 = cursor7 + 1;
                    info[cursor5] = Float.floatToIntBits(kp.mPercentY);
                }
                cursor = cursor5 + 1;
                info[len] = cursor - len;
                count++;
            }
        }
        return count;
    }
}
