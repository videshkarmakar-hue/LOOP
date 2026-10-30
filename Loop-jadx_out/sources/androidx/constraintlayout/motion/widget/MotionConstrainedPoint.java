package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    private float height;
    private Easing mKeyFrameEasing;
    private float position;
    int visibility;
    private float width;

    /* JADX INFO: renamed from: x */
    private float f186x;

    /* JADX INFO: renamed from: y */
    private float f187y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    private boolean diff(float a, float b) {
        if (Float.isNaN(a) || Float.isNaN(b)) {
            return Float.isNaN(a) != Float.isNaN(b);
        }
        return Math.abs(a - b) > 1.0E-6f;
    }

    void different(MotionConstrainedPoint points, HashSet<String> keySet) {
        if (diff(this.alpha, points.alpha)) {
            keySet.add("alpha");
        }
        if (diff(this.elevation, points.elevation)) {
            keySet.add("elevation");
        }
        if (this.visibility != points.visibility && this.mVisibilityMode == 0 && (this.visibility == 0 || points.visibility == 0)) {
            keySet.add("alpha");
        }
        if (diff(this.rotation, points.rotation)) {
            keySet.add("rotation");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(points.mPathRotate)) {
            keySet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(points.mProgress)) {
            keySet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (diff(this.rotationX, points.rotationX)) {
            keySet.add("rotationX");
        }
        if (diff(this.rotationY, points.rotationY)) {
            keySet.add("rotationY");
        }
        if (diff(this.mPivotX, points.mPivotX)) {
            keySet.add("transformPivotX");
        }
        if (diff(this.mPivotY, points.mPivotY)) {
            keySet.add("transformPivotY");
        }
        if (diff(this.scaleX, points.scaleX)) {
            keySet.add("scaleX");
        }
        if (diff(this.scaleY, points.scaleY)) {
            keySet.add("scaleY");
        }
        if (diff(this.translationX, points.translationX)) {
            keySet.add("translationX");
        }
        if (diff(this.translationY, points.translationY)) {
            keySet.add("translationY");
        }
        if (diff(this.translationZ, points.translationZ)) {
            keySet.add("translationZ");
        }
    }

    void different(MotionConstrainedPoint points, boolean[] mask, String[] custom) {
        int c = 0 + 1;
        mask[0] = mask[0] | diff(this.position, points.position);
        int c2 = c + 1;
        mask[c] = mask[c] | diff(this.f186x, points.f186x);
        int c3 = c2 + 1;
        mask[c2] = mask[c2] | diff(this.f187y, points.f187y);
        int c4 = c3 + 1;
        mask[c3] = mask[c3] | diff(this.width, points.width);
        int i = c4 + 1;
        mask[c4] = mask[c4] | diff(this.height, points.height);
    }

    void fillStandard(double[] data, int[] toUse) {
        float[] set = {this.position, this.f186x, this.f187y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int c = 0;
        for (int i = 0; i < toUse.length; i++) {
            if (toUse[i] < set.length) {
                data[c] = set[toUse[i]];
                c++;
            }
        }
    }

    boolean hasCustomData(String name) {
        return this.attributes.containsKey(name);
    }

    int getCustomDataCount(String name) {
        return this.attributes.get(name).noOfInterpValues();
    }

    int getCustomData(String name, double[] value, int offset) {
        ConstraintAttribute a = this.attributes.get(name);
        if (a.noOfInterpValues() == 1) {
            value[offset] = a.getValueToInterpolate();
            return 1;
        }
        int N = a.noOfInterpValues();
        float[] f = new float[N];
        a.getValuesToInterpolate(f);
        int i = 0;
        while (i < N) {
            value[offset] = f[i];
            i++;
            offset++;
        }
        return N;
    }

    void setBounds(float x, float y, float w, float h) {
        this.f186x = x;
        this.f187y = y;
        this.width = w;
        this.height = h;
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint o) {
        return Float.compare(this.position, o.position);
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
    }

    public void applyParameters(ConstraintSet.Constraint c) {
        this.mVisibilityMode = c.propertySet.mVisibilityMode;
        this.visibility = c.propertySet.visibility;
        this.alpha = (c.propertySet.visibility == 0 || this.mVisibilityMode != 0) ? c.propertySet.alpha : 0.0f;
        this.applyElevation = c.transform.applyElevation;
        this.elevation = c.transform.elevation;
        this.rotation = c.transform.rotation;
        this.rotationX = c.transform.rotationX;
        this.rotationY = c.transform.rotationY;
        this.scaleX = c.transform.scaleX;
        this.scaleY = c.transform.scaleY;
        this.mPivotX = c.transform.transformPivotX;
        this.mPivotY = c.transform.transformPivotY;
        this.translationX = c.transform.translationX;
        this.translationY = c.transform.translationY;
        this.translationZ = c.transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(c.motion.mTransitionEasing);
        this.mPathRotate = c.motion.mPathRotate;
        this.mDrawPath = c.motion.mDrawPath;
        this.mProgress = c.propertySet.mProgress;
        Set<String> at = c.mCustomConstraints.keySet();
        for (String s : at) {
            ConstraintAttribute attr = c.mCustomConstraints.get(s);
            if (attr.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(s, attr);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6  */
    public void addValues(HashMap<String, SplineSet> splines, int mFramePosition) {
        byte b;
        for (String s : splines.keySet()) {
            SplineSet splineSet = splines.get(s);
            switch (s) {
                case "rotationX":
                    b = 3;
                    break;
                case "rotationY":
                    b = 4;
                    break;
                case "translationX":
                    b = 11;
                    break;
                case "translationY":
                    b = 12;
                    break;
                case "translationZ":
                    b = 13;
                    break;
                case "progress":
                    b = 8;
                    break;
                case "scaleX":
                    b = 9;
                    break;
                case "scaleY":
                    b = 10;
                    break;
                case "transformPivotX":
                    b = 5;
                    break;
                case "transformPivotY":
                    b = 6;
                    break;
                case "rotation":
                    b = 2;
                    break;
                case "elevation":
                    b = 1;
                    break;
                case "transitionPathRotate":
                    b = 7;
                    break;
                case "alpha":
                    b = 0;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                    break;
                case 1:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.elevation) ? 0.0f : this.elevation);
                    break;
                case 2:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.rotation) ? 0.0f : this.rotation);
                    break;
                case 3:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.rotationX) ? 0.0f : this.rotationX);
                    break;
                case 4:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case 5:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                    break;
                case 6:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                    break;
                case 7:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                    break;
                case 8:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                    break;
                case 9:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                    break;
                case 10:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                    break;
                case 11:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.translationX) ? 0.0f : this.translationX);
                    break;
                case 12:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.translationY) ? 0.0f : this.translationY);
                    break;
                case 13:
                    splineSet.setPoint(mFramePosition, Float.isNaN(this.translationZ) ? 0.0f : this.translationZ);
                    break;
                default:
                    if (s.startsWith("CUSTOM")) {
                        String customName = s.split(",")[1];
                        if (this.attributes.containsKey(customName)) {
                            ConstraintAttribute custom = this.attributes.get(customName);
                            if (splineSet instanceof SplineSet.CustomSet) {
                                ((SplineSet.CustomSet) splineSet).setPoint(mFramePosition, custom);
                            } else {
                                Log.e("MotionPaths", s + " splineSet not a CustomSet frame = " + mFramePosition + ", value" + custom.getValueToInterpolate() + splineSet);
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN customName " + customName);
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + s);
                    }
                    break;
            }
        }
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    public void setState(ConstraintWidget cw, ConstraintSet constraintSet, int viewId) {
        setBounds(cw.getX(), cw.getY(), cw.getWidth(), cw.getHeight());
        applyParameters(constraintSet.getParameters(viewId));
    }
}
