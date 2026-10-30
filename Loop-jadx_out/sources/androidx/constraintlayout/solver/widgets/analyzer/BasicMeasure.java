package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    private Measure mMeasure = new Measure();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public enum MeasureType {
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public void updateHierarchy(ConstraintWidgetContainer layout) {
        this.mVariableDimensionsWidgets.clear();
        int childCount = layout.mChildren.size();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget widget = layout.mChildren.get(i);
            if (widget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || widget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(widget);
            }
        }
        layout.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private void measureChildren(ConstraintWidgetContainer layout) {
        int childCount = layout.mChildren.size();
        Measurer measurer = layout.getMeasurer();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget child = layout.mChildren.get(i);
            if (!(child instanceof Guideline) && (!child.horizontalRun.dimension.resolved || !child.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour widthBehavior = child.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour heightBehavior = child.getDimensionBehaviour(1);
                boolean skip = widthBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && child.mMatchConstraintDefaultWidth != 1 && heightBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && child.mMatchConstraintDefaultHeight != 1;
                if (!skip) {
                    measure(measurer, child, false);
                    if (layout.mMetrics != null) {
                        layout.mMetrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer layout, String reason, int w, int h) {
        int minWidth = layout.getMinWidth();
        int minHeight = layout.getMinHeight();
        layout.setMinWidth(0);
        layout.setMinHeight(0);
        layout.setWidth(w);
        layout.setHeight(h);
        layout.setMinWidth(minWidth);
        layout.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0171  */
    /* JADX WARN: Code duplicated, block: B:103:0x017c  */
    /* JADX WARN: Code duplicated, block: B:104:0x017e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0187  */
    /* JADX WARN: Code duplicated, block: B:108:0x018a  */
    /* JADX WARN: Code duplicated, block: B:111:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:113:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:114:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:116:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:117:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:120:0x0209  */
    /* JADX WARN: Code duplicated, block: B:122:0x020e  */
    /* JADX WARN: Code duplicated, block: B:125:0x022b  */
    /* JADX WARN: Code duplicated, block: B:127:0x022f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0233  */
    /* JADX WARN: Code duplicated, block: B:131:0x0238  */
    /* JADX WARN: Code duplicated, block: B:134:0x0255  */
    /* JADX WARN: Code duplicated, block: B:136:0x0259  */
    /* JADX WARN: Code duplicated, block: B:141:0x0284  */
    /* JADX WARN: Code duplicated, block: B:143:0x0287  */
    /* JADX WARN: Code duplicated, block: B:145:0x0293  */
    /* JADX WARN: Code duplicated, block: B:147:0x0297  */
    /* JADX WARN: Code duplicated, block: B:163:0x02de  */
    /* JADX WARN: Code duplicated, block: B:164:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:167:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:169:0x0302  */
    /* JADX WARN: Code duplicated, block: B:172:0x031e  */
    /* JADX WARN: Code duplicated, block: B:174:0x0324  */
    /* JADX WARN: Code duplicated, block: B:176:0x0328  */
    /* JADX WARN: Code duplicated, block: B:178:0x032d  */
    /* JADX WARN: Code duplicated, block: B:184:0x034f  */
    /* JADX WARN: Code duplicated, block: B:187:0x0358  */
    /* JADX WARN: Code duplicated, block: B:191:0x036e  */
    /* JADX WARN: Code duplicated, block: B:192:0x037b  */
    /* JADX WARN: Code duplicated, block: B:196:0x0399  */
    /* JADX WARN: Code duplicated, block: B:198:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:201:0x03af  */
    /* JADX WARN: Code duplicated, block: B:203:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:204:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x0107  */
    /* JADX WARN: Code duplicated, block: B:75:0x010d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0117  */
    /* JADX WARN: Code duplicated, block: B:78:0x011a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0127  */
    /* JADX WARN: Code duplicated, block: B:82:0x0129  */
    /* JADX WARN: Code duplicated, block: B:84:0x012c  */
    /* JADX WARN: Code duplicated, block: B:85:0x012e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0134  */
    /* JADX WARN: Code duplicated, block: B:94:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0156  */
    /* JADX WARN: Code duplicated, block: B:98:0x0165  */
    /* JADX WARN: Code duplicated, block: B:99:0x016d  */
    public long solverMeasure(ConstraintWidgetContainer layout, int optimizationLevel, int paddingX, int paddingY, int widthMode, int widthSize, int heightMode, int heightSize, int lastMeasureWidth, int lastMeasureHeight) {
        boolean optimize;
        boolean ratio;
        boolean allSolved;
        boolean optimize2;
        int computations;
        int widthSize2;
        int heightSize2;
        int optimizations;
        int sizeDependentWidgetsCount;
        int optimizations2;
        boolean containerWrapWidth;
        boolean z;
        boolean containerWrapHeight;
        int i;
        int minWidth;
        int childCount;
        boolean needSolverPass;
        int startingWidth;
        int startingHeight;
        int j;
        int startingWidth2;
        int sizeDependentWidgetsCount2;
        boolean needSolverPass2;
        int i2;
        int startingWidth3;
        int startingHeight2;
        ConstraintWidget widget;
        int preWidth;
        int preHeight;
        int sizeDependentWidgetsCount3;
        boolean needSolverPass3;
        int measuredWidth;
        int measuredHeight;
        ConstraintWidget widget2;
        int preWidth2;
        int preHeight2;
        boolean needSolverPass4;
        int measuredWidth2;
        int measuredHeight2;
        boolean z2;
        boolean z3;
        Measurer measurer = layout.getMeasurer();
        int childCount2 = layout.mChildren.size();
        int startingWidth4 = layout.getWidth();
        int startingHeight3 = layout.getHeight();
        boolean optimizeWrap = Optimizer.enabled(optimizationLevel, 128);
        boolean optimize3 = optimizeWrap || Optimizer.enabled(optimizationLevel, 64);
        if (!optimize3) {
            optimize = optimize3;
        } else {
            int i3 = 0;
            while (true) {
                if (i3 >= childCount2) {
                    optimize = optimize3;
                } else {
                    ConstraintWidget child = layout.mChildren.get(i3);
                    boolean matchWidth = child.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean optimize4 = optimize3;
                    boolean matchHeight = child.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean ratio2 = matchWidth && matchHeight && child.getDimensionRatio() > 0.0f;
                    if (child.isInHorizontalChain() && ratio2) {
                        ratio = false;
                        break;
                    }
                    if (child.isInVerticalChain() && ratio2) {
                        ratio = false;
                        break;
                    }
                    boolean matchWidth2 = child instanceof VirtualLayout;
                    if (matchWidth2) {
                        ratio = false;
                        break;
                    }
                    if (!child.isInHorizontalChain() && !child.isInVerticalChain()) {
                        i3++;
                        optimize3 = optimize4;
                    } else {
                        ratio = false;
                        break;
                    }
                }
            }
            if (!ratio && LinearSystem.sMetrics != null) {
                Metrics metrics = LinearSystem.sMetrics;
                long layoutTime = metrics.measures;
                metrics.measures = layoutTime + 1;
            }
            allSolved = false;
            optimize2 = ((widthMode != 1073741824 && heightMode == 1073741824) || optimizeWrap) & ratio;
            computations = 0;
            if (optimize2) {
                widthSize2 = widthSize;
                heightSize2 = heightSize;
            } else {
                widthSize2 = Math.min(layout.getMaxWidth(), widthSize);
                heightSize2 = Math.min(layout.getMaxHeight(), heightSize);
                if (widthMode == 1073741824 && layout.getWidth() != widthSize2) {
                    layout.setWidth(widthSize2);
                    layout.invalidateGraph();
                }
                if (heightMode == 1073741824 && layout.getHeight() != heightSize2) {
                    layout.setHeight(heightSize2);
                    layout.invalidateGraph();
                }
                if (widthMode != 1073741824 && heightMode == 1073741824) {
                    allSolved = layout.directMeasure(optimizeWrap);
                    computations = 2;
                } else {
                    allSolved = layout.directMeasureSetup(optimizeWrap);
                    if (widthMode == 1073741824) {
                        allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 0);
                        computations = 0 + 1;
                    }
                    if (heightMode == 1073741824) {
                        allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 1);
                        computations++;
                    }
                }
                if (allSolved) {
                    if (widthMode == 1073741824) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (heightMode == 1073741824) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    layout.updateFromRuns(z2, z3);
                }
            }
            if (allSolved || computations != 2) {
                if (childCount2 > 0) {
                    measureChildren(layout);
                }
                optimizations = layout.getOptimizationLevel();
                sizeDependentWidgetsCount = this.mVariableDimensionsWidgets.size();
                if (childCount2 > 0) {
                    solveLinearSystem(layout, "First pass", startingWidth4, startingHeight3);
                }
                if (sizeDependentWidgetsCount > 0) {
                    if (layout.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        containerWrapWidth = true;
                    } else {
                        containerWrapWidth = false;
                    }
                    if (layout.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        z = true;
                    } else {
                        z = false;
                    }
                    containerWrapHeight = z;
                    int minWidth2 = Math.max(layout.getWidth(), this.constraintWidgetContainer.getMinWidth());
                    int minHeight = Math.max(layout.getHeight(), this.constraintWidgetContainer.getMinHeight());
                    i = 0;
                    minWidth = minWidth2;
                    childCount = minHeight;
                    needSolverPass = false;
                    while (i < sizeDependentWidgetsCount) {
                        int widthSize3 = widthSize2;
                        widget2 = this.mVariableDimensionsWidgets.get(i);
                        int heightSize3 = heightSize2;
                        if (!(widget2 instanceof VirtualLayout)) {
                            startingWidth4 = startingWidth4;
                            startingHeight3 = startingHeight3;
                        } else {
                            preWidth2 = widget2.getWidth();
                            preHeight2 = widget2.getHeight();
                            needSolverPass4 = needSolverPass | measure(measurer, widget2, true);
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth2 = widget2.getWidth();
                            measuredHeight2 = widget2.getHeight();
                            if (measuredWidth2 != preWidth2) {
                                widget2.setWidth(measuredWidth2);
                                if (!containerWrapWidth && widget2.getRight() > minWidth) {
                                    int w = widget2.getRight() + widget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin();
                                    minWidth = Math.max(minWidth, w);
                                }
                                needSolverPass4 = true;
                            }
                            if (measuredHeight2 != preHeight2) {
                                widget2.setHeight(measuredHeight2);
                                if (!containerWrapHeight && widget2.getBottom() > childCount) {
                                    int h = widget2.getBottom() + widget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    childCount = Math.max(childCount, h);
                                }
                                needSolverPass4 = true;
                            }
                            VirtualLayout virtualLayout = (VirtualLayout) widget2;
                            needSolverPass = needSolverPass4 | virtualLayout.needSolverPass();
                        }
                        i++;
                        widthSize2 = widthSize3;
                        heightSize2 = heightSize3;
                        computations = computations;
                        optimizations = optimizations;
                        startingWidth4 = startingWidth4;
                        startingHeight3 = startingHeight3;
                    }
                    startingWidth = startingWidth4;
                    startingHeight = startingHeight3;
                    optimizations2 = optimizations;
                    j = 0;
                    while (j < 2) {
                        i2 = 0;
                        while (i2 < sizeDependentWidgetsCount) {
                            widget = this.mVariableDimensionsWidgets.get(i2);
                            if ((!(widget instanceof Helper) && !(widget instanceof VirtualLayout)) || (widget instanceof Guideline) || widget.getVisibility() == 8 || ((widget.horizontalRun.dimension.resolved && widget.verticalRun.dimension.resolved) || (widget instanceof VirtualLayout))) {
                                containerWrapWidth = containerWrapWidth;
                                measurer = measurer;
                                sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            } else {
                                preWidth = widget.getWidth();
                                preHeight = widget.getHeight();
                                int preBaselineDistance = widget.getBaselineDistance();
                                sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                                needSolverPass3 = needSolverPass | measure(measurer, widget, true);
                                if (layout.mMetrics != null) {
                                    layout.mMetrics.measuredMatchWidgets++;
                                }
                                measuredWidth = widget.getWidth();
                                measuredHeight = widget.getHeight();
                                if (measuredWidth == preWidth) {
                                    containerWrapWidth = containerWrapWidth;
                                } else {
                                    widget.setWidth(measuredWidth);
                                    if (!containerWrapWidth && widget.getRight() > minWidth) {
                                        int w2 = widget.getRight() + widget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin();
                                        minWidth = Math.max(minWidth, w2);
                                    }
                                    needSolverPass3 = true;
                                }
                                if (measuredHeight != preHeight) {
                                    widget.setHeight(measuredHeight);
                                    if (containerWrapHeight && widget.getBottom() > childCount) {
                                        int h2 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                        childCount = Math.max(childCount, h2);
                                    }
                                    needSolverPass3 = true;
                                }
                                if (widget.hasBaseline() || preBaselineDistance == widget.getBaselineDistance()) {
                                    needSolverPass = needSolverPass3;
                                } else {
                                    needSolverPass = true;
                                }
                            }
                            i2++;
                            sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                            measurer = measurer;
                            containerWrapWidth = containerWrapWidth;
                        }
                        boolean containerWrapWidth2 = containerWrapWidth;
                        Measurer measurer2 = measurer;
                        int sizeDependentWidgetsCount4 = sizeDependentWidgetsCount;
                        if (needSolverPass) {
                            startingWidth3 = startingWidth;
                            startingHeight2 = startingHeight;
                            solveLinearSystem(layout, "intermediate pass", startingWidth3, startingHeight2);
                            needSolverPass = false;
                        } else {
                            startingWidth3 = startingWidth;
                            startingHeight2 = startingHeight;
                        }
                        j++;
                        startingWidth = startingWidth3;
                        startingHeight = startingHeight2;
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount4;
                        measurer = measurer2;
                        containerWrapWidth = containerWrapWidth2;
                    }
                    startingWidth2 = startingWidth;
                    sizeDependentWidgetsCount2 = startingHeight;
                    if (needSolverPass) {
                        solveLinearSystem(layout, "2nd pass", startingWidth2, sizeDependentWidgetsCount2);
                        needSolverPass2 = false;
                        if (layout.getWidth() < minWidth) {
                            layout.setWidth(minWidth);
                            needSolverPass2 = true;
                        }
                        if (layout.getHeight() < childCount) {
                            layout.setHeight(childCount);
                            needSolverPass2 = true;
                        }
                        if (needSolverPass2) {
                            solveLinearSystem(layout, "3rd pass", startingWidth2, sizeDependentWidgetsCount2);
                        }
                    }
                } else {
                    optimizations2 = optimizations;
                }
                layout.setOptimizationLevel(optimizations2);
            }
            return 0;
        }
        ratio = optimize;
        if (!ratio) {
        }
        allSolved = false;
        optimize2 = ((widthMode != 1073741824 && heightMode == 1073741824) || optimizeWrap) & ratio;
        computations = 0;
        if (optimize2) {
            widthSize2 = widthSize;
            heightSize2 = heightSize;
        } else {
            widthSize2 = Math.min(layout.getMaxWidth(), widthSize);
            heightSize2 = Math.min(layout.getMaxHeight(), heightSize);
            if (widthMode == 1073741824) {
                layout.setWidth(widthSize2);
                layout.invalidateGraph();
            }
            if (heightMode == 1073741824) {
                layout.setHeight(heightSize2);
                layout.invalidateGraph();
            }
            if (widthMode != 1073741824) {
                allSolved = layout.directMeasureSetup(optimizeWrap);
                if (widthMode == 1073741824) {
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 0);
                    computations = 0 + 1;
                }
                if (heightMode == 1073741824) {
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 1);
                    computations++;
                }
            } else {
                allSolved = layout.directMeasureSetup(optimizeWrap);
                if (widthMode == 1073741824) {
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 0);
                    computations = 0 + 1;
                }
                if (heightMode == 1073741824) {
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 1);
                    computations++;
                }
            }
            if (allSolved) {
                if (widthMode == 1073741824) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (heightMode == 1073741824) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                layout.updateFromRuns(z2, z3);
            }
        }
        if (allSolved) {
            if (childCount2 > 0) {
                measureChildren(layout);
            }
            optimizations = layout.getOptimizationLevel();
            sizeDependentWidgetsCount = this.mVariableDimensionsWidgets.size();
            if (childCount2 > 0) {
                solveLinearSystem(layout, "First pass", startingWidth4, startingHeight3);
            }
            if (sizeDependentWidgetsCount > 0) {
                if (layout.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    containerWrapWidth = true;
                } else {
                    containerWrapWidth = false;
                }
                if (layout.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = true;
                } else {
                    z = false;
                }
                containerWrapHeight = z;
                int minWidth3 = Math.max(layout.getWidth(), this.constraintWidgetContainer.getMinWidth());
                int minHeight2 = Math.max(layout.getHeight(), this.constraintWidgetContainer.getMinHeight());
                i = 0;
                minWidth = minWidth3;
                childCount = minHeight2;
                needSolverPass = false;
                while (i < sizeDependentWidgetsCount) {
                    int widthSize4 = widthSize2;
                    widget2 = this.mVariableDimensionsWidgets.get(i);
                    int heightSize4 = heightSize2;
                    if (!(widget2 instanceof VirtualLayout)) {
                        startingWidth4 = startingWidth4;
                        startingHeight3 = startingHeight3;
                    } else {
                        preWidth2 = widget2.getWidth();
                        preHeight2 = widget2.getHeight();
                        needSolverPass4 = needSolverPass | measure(measurer, widget2, true);
                        if (layout.mMetrics != null) {
                            layout.mMetrics.measuredMatchWidgets++;
                        }
                        measuredWidth2 = widget2.getWidth();
                        measuredHeight2 = widget2.getHeight();
                        if (measuredWidth2 != preWidth2) {
                            widget2.setWidth(measuredWidth2);
                            if (!containerWrapWidth) {
                            }
                            needSolverPass4 = true;
                        }
                        if (measuredHeight2 != preHeight2) {
                            widget2.setHeight(measuredHeight2);
                            if (!containerWrapHeight) {
                            }
                            needSolverPass4 = true;
                        }
                        VirtualLayout virtualLayout2 = (VirtualLayout) widget2;
                        needSolverPass = needSolverPass4 | virtualLayout2.needSolverPass();
                    }
                    i++;
                    widthSize2 = widthSize4;
                    heightSize2 = heightSize4;
                    computations = computations;
                    optimizations = optimizations;
                    startingWidth4 = startingWidth4;
                    startingHeight3 = startingHeight3;
                }
                startingWidth = startingWidth4;
                startingHeight = startingHeight3;
                optimizations2 = optimizations;
                j = 0;
                while (j < 2) {
                    i2 = 0;
                    while (i2 < sizeDependentWidgetsCount) {
                        widget = this.mVariableDimensionsWidgets.get(i2);
                        if (!(widget instanceof Helper)) {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            int preBaselineDistance2 = widget.getBaselineDistance();
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            needSolverPass3 = needSolverPass | measure(measurer, widget, true);
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h3 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    childCount = Math.max(childCount, h3);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        } else {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            int preBaselineDistance3 = widget.getBaselineDistance();
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            needSolverPass3 = needSolverPass | measure(measurer, widget, true);
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h4 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    childCount = Math.max(childCount, h4);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        }
                        i2++;
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                        measurer = measurer;
                        containerWrapWidth = containerWrapWidth;
                    }
                    boolean containerWrapWidth3 = containerWrapWidth;
                    Measurer measurer3 = measurer;
                    int sizeDependentWidgetsCount5 = sizeDependentWidgetsCount;
                    if (needSolverPass) {
                        startingWidth3 = startingWidth;
                        startingHeight2 = startingHeight;
                        solveLinearSystem(layout, "intermediate pass", startingWidth3, startingHeight2);
                        needSolverPass = false;
                    } else {
                        startingWidth3 = startingWidth;
                        startingHeight2 = startingHeight;
                    }
                    j++;
                    startingWidth = startingWidth3;
                    startingHeight = startingHeight2;
                    sizeDependentWidgetsCount = sizeDependentWidgetsCount5;
                    measurer = measurer3;
                    containerWrapWidth = containerWrapWidth3;
                }
                startingWidth2 = startingWidth;
                sizeDependentWidgetsCount2 = startingHeight;
                if (needSolverPass) {
                    solveLinearSystem(layout, "2nd pass", startingWidth2, sizeDependentWidgetsCount2);
                    needSolverPass2 = false;
                    if (layout.getWidth() < minWidth) {
                        layout.setWidth(minWidth);
                        needSolverPass2 = true;
                    }
                    if (layout.getHeight() < childCount) {
                        layout.setHeight(childCount);
                        needSolverPass2 = true;
                    }
                    if (needSolverPass2) {
                        solveLinearSystem(layout, "3rd pass", startingWidth2, sizeDependentWidgetsCount2);
                    }
                }
            } else {
                optimizations2 = optimizations;
            }
            layout.setOptimizationLevel(optimizations2);
        } else {
            if (childCount2 > 0) {
                measureChildren(layout);
            }
            optimizations = layout.getOptimizationLevel();
            sizeDependentWidgetsCount = this.mVariableDimensionsWidgets.size();
            if (childCount2 > 0) {
                solveLinearSystem(layout, "First pass", startingWidth4, startingHeight3);
            }
            if (sizeDependentWidgetsCount > 0) {
                if (layout.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    containerWrapWidth = true;
                } else {
                    containerWrapWidth = false;
                }
                if (layout.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = true;
                } else {
                    z = false;
                }
                containerWrapHeight = z;
                int minWidth4 = Math.max(layout.getWidth(), this.constraintWidgetContainer.getMinWidth());
                int minHeight3 = Math.max(layout.getHeight(), this.constraintWidgetContainer.getMinHeight());
                i = 0;
                minWidth = minWidth4;
                childCount = minHeight3;
                needSolverPass = false;
                while (i < sizeDependentWidgetsCount) {
                    int widthSize5 = widthSize2;
                    widget2 = this.mVariableDimensionsWidgets.get(i);
                    int heightSize5 = heightSize2;
                    if (!(widget2 instanceof VirtualLayout)) {
                        startingWidth4 = startingWidth4;
                        startingHeight3 = startingHeight3;
                    } else {
                        preWidth2 = widget2.getWidth();
                        preHeight2 = widget2.getHeight();
                        needSolverPass4 = needSolverPass | measure(measurer, widget2, true);
                        if (layout.mMetrics != null) {
                            layout.mMetrics.measuredMatchWidgets++;
                        }
                        measuredWidth2 = widget2.getWidth();
                        measuredHeight2 = widget2.getHeight();
                        if (measuredWidth2 != preWidth2) {
                            widget2.setWidth(measuredWidth2);
                            if (!containerWrapWidth) {
                            }
                            needSolverPass4 = true;
                        }
                        if (measuredHeight2 != preHeight2) {
                            widget2.setHeight(measuredHeight2);
                            if (!containerWrapHeight) {
                            }
                            needSolverPass4 = true;
                        }
                        VirtualLayout virtualLayout3 = (VirtualLayout) widget2;
                        needSolverPass = needSolverPass4 | virtualLayout3.needSolverPass();
                    }
                    i++;
                    widthSize2 = widthSize5;
                    heightSize2 = heightSize5;
                    computations = computations;
                    optimizations = optimizations;
                    startingWidth4 = startingWidth4;
                    startingHeight3 = startingHeight3;
                }
                startingWidth = startingWidth4;
                startingHeight = startingHeight3;
                optimizations2 = optimizations;
                j = 0;
                while (j < 2) {
                    i2 = 0;
                    while (i2 < sizeDependentWidgetsCount) {
                        widget = this.mVariableDimensionsWidgets.get(i2);
                        if (!(widget instanceof Helper)) {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            int preBaselineDistance4 = widget.getBaselineDistance();
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            needSolverPass3 = needSolverPass | measure(measurer, widget, true);
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h5 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    childCount = Math.max(childCount, h5);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        } else {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            int preBaselineDistance5 = widget.getBaselineDistance();
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            needSolverPass3 = needSolverPass | measure(measurer, widget, true);
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h6 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    childCount = Math.max(childCount, h6);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        }
                        i2++;
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                        measurer = measurer;
                        containerWrapWidth = containerWrapWidth;
                    }
                    boolean containerWrapWidth4 = containerWrapWidth;
                    Measurer measurer4 = measurer;
                    int sizeDependentWidgetsCount6 = sizeDependentWidgetsCount;
                    if (needSolverPass) {
                        startingWidth3 = startingWidth;
                        startingHeight2 = startingHeight;
                        solveLinearSystem(layout, "intermediate pass", startingWidth3, startingHeight2);
                        needSolverPass = false;
                    } else {
                        startingWidth3 = startingWidth;
                        startingHeight2 = startingHeight;
                    }
                    j++;
                    startingWidth = startingWidth3;
                    startingHeight = startingHeight2;
                    sizeDependentWidgetsCount = sizeDependentWidgetsCount6;
                    measurer = measurer4;
                    containerWrapWidth = containerWrapWidth4;
                }
                startingWidth2 = startingWidth;
                sizeDependentWidgetsCount2 = startingHeight;
                if (needSolverPass) {
                    solveLinearSystem(layout, "2nd pass", startingWidth2, sizeDependentWidgetsCount2);
                    needSolverPass2 = false;
                    if (layout.getWidth() < minWidth) {
                        layout.setWidth(minWidth);
                        needSolverPass2 = true;
                    }
                    if (layout.getHeight() < childCount) {
                        layout.setHeight(childCount);
                        needSolverPass2 = true;
                    }
                    if (needSolverPass2) {
                        solveLinearSystem(layout, "3rd pass", startingWidth2, sizeDependentWidgetsCount2);
                    }
                }
            } else {
                optimizations2 = optimizations;
            }
            layout.setOptimizationLevel(optimizations2);
        }
        return 0;
    }

    private boolean measure(Measurer measurer, ConstraintWidget widget, boolean useCurrentDimensions) {
        this.mMeasure.horizontalBehavior = widget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = widget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = widget.getWidth();
        this.mMeasure.verticalDimension = widget.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.useCurrentDimensions = useCurrentDimensions;
        boolean horizontalMatchConstraints = this.mMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean verticalMatchConstraints = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean horizontalUseRatio = horizontalMatchConstraints && widget.mDimensionRatio > 0.0f;
        boolean verticalUseRatio = verticalMatchConstraints && widget.mDimensionRatio > 0.0f;
        if (horizontalUseRatio && widget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (verticalUseRatio && widget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(widget, this.mMeasure);
        widget.setWidth(this.mMeasure.measuredWidth);
        widget.setHeight(this.mMeasure.measuredHeight);
        widget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        widget.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.useCurrentDimensions = false;
        return this.mMeasure.measuredNeedsSolverPass;
    }
}
