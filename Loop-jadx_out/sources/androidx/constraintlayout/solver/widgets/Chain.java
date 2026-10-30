package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem system, int orientation) {
        int offset;
        int chainsSize;
        ChainHead[] chainsArray;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.mHorizontalChainsSize;
            chainsArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.mVerticalChainsSize;
            chainsArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < chainsSize; i++) {
            ChainHead first = chainsArray[i];
            first.define();
            applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
        }
    }

    static void applyChainConstraints(ConstraintWidgetContainer container, LinearSystem system, int orientation, int offset, ChainHead chainHead) {
        boolean isChainSpread;
        boolean isChainPacked;
        boolean isChainSpreadInside;
        ConstraintWidget widget;
        ArrayList<ConstraintWidget> listMatchConstraints;
        SolverVariable endTarget;
        ConstraintAnchor end;
        int endPointsStrength;
        ConstraintWidget next;
        ConstraintWidget next2;
        ConstraintAnchor beginNextAnchor;
        SolverVariable beginNextTarget;
        SolverVariable beginNext;
        int strength;
        SolverVariable beginTarget;
        ConstraintAnchor beginNextAnchor2;
        SolverVariable beginNext2;
        SolverVariable beginNextTarget2;
        int nextMargin;
        int margin1;
        int margin2;
        int strength2;
        float bias;
        int count;
        int margin;
        ConstraintWidget next3;
        int strength3;
        ConstraintWidget first = chainHead.mFirst;
        ConstraintWidget last = chainHead.mLast;
        ConstraintWidget firstVisibleWidget = chainHead.mFirstVisibleWidget;
        ConstraintWidget lastVisibleWidget = chainHead.mLastVisibleWidget;
        ConstraintWidget head = chainHead.mHead;
        boolean done = false;
        float totalWeights = chainHead.mTotalWeight;
        ConstraintWidget firstMatchConstraintsWidget = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget previousMatchConstraintsWidget = chainHead.mLastMatchConstraintWidget;
        ConstraintWidget widget2 = first;
        boolean isWrapContent = container.mListDimensionBehaviors[orientation] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (orientation == 0) {
            boolean isChainSpread2 = head.mHorizontalChainStyle == 0;
            isChainSpread = isChainSpread2;
            boolean isChainSpreadInside2 = head.mHorizontalChainStyle == 1;
            isChainPacked = head.mHorizontalChainStyle == 2;
            isChainSpreadInside = isChainSpreadInside2;
        } else {
            boolean isChainSpread3 = head.mVerticalChainStyle == 0;
            isChainSpread = isChainSpread3;
            boolean isChainSpreadInside3 = head.mVerticalChainStyle == 1;
            isChainPacked = head.mVerticalChainStyle == 2;
            isChainSpreadInside = isChainSpreadInside3;
        }
        while (!done) {
            ConstraintAnchor begin = widget2.mListAnchors[offset];
            int strength4 = 4;
            if (isChainPacked) {
                strength4 = 1;
            }
            int margin3 = begin.getMargin();
            boolean isSpreadOnly = widget2.mListDimensionBehaviors[orientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widget2.mResolvedMatchConstraintDefault[orientation] == 0;
            if (begin.mTarget != null && widget2 != first) {
                margin = margin3 + begin.mTarget.getMargin();
            } else {
                margin = margin3;
            }
            if (isChainPacked && widget2 != first && widget2 != firstVisibleWidget) {
                strength4 = 5;
            }
            if (begin.mTarget == null) {
                totalWeights = totalWeights;
                previousMatchConstraintsWidget = previousMatchConstraintsWidget;
            } else {
                if (widget2 == firstVisibleWidget) {
                    system.addGreaterThan(begin.mSolverVariable, begin.mTarget.mSolverVariable, margin, 6);
                } else {
                    system.addGreaterThan(begin.mSolverVariable, begin.mTarget.mSolverVariable, margin, 8);
                }
                if (isSpreadOnly && !isChainPacked) {
                    strength3 = 5;
                } else {
                    strength3 = strength4;
                }
                system.addEquality(begin.mSolverVariable, begin.mTarget.mSolverVariable, margin, strength3);
            }
            if (isWrapContent) {
                if (widget2.getVisibility() != 8 && widget2.mListDimensionBehaviors[orientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    system.addGreaterThan(widget2.mListAnchors[offset + 1].mSolverVariable, widget2.mListAnchors[offset].mSolverVariable, 0, 5);
                }
                system.addGreaterThan(widget2.mListAnchors[offset].mSolverVariable, container.mListAnchors[offset].mSolverVariable, 0, 8);
            }
            ConstraintAnchor nextAnchor = widget2.mListAnchors[offset + 1].mTarget;
            if (nextAnchor != null) {
                ConstraintWidget next4 = nextAnchor.mOwner;
                next3 = (next4.mListAnchors[offset].mTarget == null || next4.mListAnchors[offset].mTarget.mOwner != widget2) ? null : next4;
            } else {
                next3 = null;
            }
            if (next3 != null) {
                widget2 = next3;
            } else {
                done = true;
            }
            totalWeights = totalWeights;
            previousMatchConstraintsWidget = previousMatchConstraintsWidget;
        }
        float totalWeights2 = totalWeights;
        if (lastVisibleWidget != null && last.mListAnchors[offset + 1].mTarget != null) {
            ConstraintAnchor end2 = lastVisibleWidget.mListAnchors[offset + 1];
            boolean isSpreadOnly2 = lastVisibleWidget.mListDimensionBehaviors[orientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && lastVisibleWidget.mResolvedMatchConstraintDefault[orientation] == 0;
            if (isSpreadOnly2 && !isChainPacked && end2.mTarget.mOwner == container) {
                system.addEquality(end2.mSolverVariable, end2.mTarget.mSolverVariable, -end2.getMargin(), 5);
            } else if (isChainPacked && end2.mTarget.mOwner == container) {
                system.addEquality(end2.mSolverVariable, end2.mTarget.mSolverVariable, -end2.getMargin(), 4);
            }
            system.addLowerThan(end2.mSolverVariable, last.mListAnchors[offset + 1].mTarget.mSolverVariable, -end2.getMargin(), 6);
        }
        if (isWrapContent) {
            system.addGreaterThan(container.mListAnchors[offset + 1].mSolverVariable, last.mListAnchors[offset + 1].mSolverVariable, last.mListAnchors[offset + 1].getMargin(), 8);
        }
        ArrayList<ConstraintWidget> listMatchConstraints2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (listMatchConstraints2 == null || (count = listMatchConstraints2.size()) <= 1) {
            widget = widget2;
            listMatchConstraints = listMatchConstraints2;
        } else {
            ConstraintWidget lastMatch = null;
            float lastWeight = 0.0f;
            if (chainHead.mHasUndefinedWeights && !chainHead.mHasComplexMatchWeights) {
                totalWeights2 = chainHead.mWidgetsMatchCount;
            }
            int i = 0;
            while (i < count) {
                ConstraintWidget match = listMatchConstraints2.get(i);
                float currentWeight = match.mWeight[orientation];
                if (currentWeight < 0.0f) {
                    if (chainHead.mHasComplexMatchWeights) {
                        count = count;
                        widget2 = widget2;
                        listMatchConstraints2 = listMatchConstraints2;
                        system.addEquality(match.mListAnchors[offset + 1].mSolverVariable, match.mListAnchors[offset].mSolverVariable, 0, 4);
                    } else {
                        currentWeight = 1.0f;
                    }
                    i++;
                    firstMatchConstraintsWidget = firstMatchConstraintsWidget;
                    listMatchConstraints2 = listMatchConstraints2;
                    count = count;
                    widget2 = widget2;
                }
                if (currentWeight == 0.0f) {
                    system.addEquality(match.mListAnchors[offset + 1].mSolverVariable, match.mListAnchors[offset].mSolverVariable, 0, 8);
                } else {
                    if (lastMatch != null) {
                        SolverVariable begin2 = lastMatch.mListAnchors[offset].mSolverVariable;
                        SolverVariable end3 = lastMatch.mListAnchors[offset + 1].mSolverVariable;
                        SolverVariable nextBegin = match.mListAnchors[offset].mSolverVariable;
                        SolverVariable nextEnd = match.mListAnchors[offset + 1].mSolverVariable;
                        ArrayRow row = system.createRow();
                        row.createRowEqualMatchDimensions(lastWeight, totalWeights2, currentWeight, begin2, end3, nextBegin, nextEnd);
                        system.addConstraint(row);
                    }
                    lastWeight = currentWeight;
                    lastMatch = match;
                }
                i++;
                firstMatchConstraintsWidget = firstMatchConstraintsWidget;
                listMatchConstraints2 = listMatchConstraints2;
                count = count;
                widget2 = widget2;
            }
            widget = widget2;
            listMatchConstraints = listMatchConstraints2;
        }
        if (firstVisibleWidget != null && (firstVisibleWidget == lastVisibleWidget || isChainPacked)) {
            ConstraintAnchor begin3 = first.mListAnchors[offset];
            ConstraintAnchor end4 = last.mListAnchors[offset + 1];
            SolverVariable beginTarget2 = begin3.mTarget != null ? begin3.mTarget.mSolverVariable : null;
            SolverVariable endTarget2 = end4.mTarget != null ? end4.mTarget.mSolverVariable : null;
            ConstraintAnchor begin4 = firstVisibleWidget.mListAnchors[offset];
            ConstraintAnchor end5 = lastVisibleWidget.mListAnchors[offset + 1];
            if (beginTarget2 != null && endTarget2 != null) {
                if (orientation == 0) {
                    float bias2 = head.mHorizontalBiasPercent;
                    bias = bias2;
                } else {
                    float bias3 = head.mVerticalBiasPercent;
                    bias = bias3;
                }
                int beginMargin = begin4.getMargin();
                int endMargin = end5.getMargin();
                system.addCentering(begin4.mSolverVariable, beginTarget2, beginMargin, bias, endTarget2, end5.mSolverVariable, endMargin, 7);
            }
        } else if (!isChainSpread || firstVisibleWidget == null) {
            int i2 = 8;
            if (isChainSpreadInside && firstVisibleWidget != null) {
                boolean applyFixedEquality = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                ConstraintWidget widget3 = firstVisibleWidget;
                ConstraintWidget previousVisibleWidget = firstVisibleWidget;
                while (widget3 != null) {
                    ConstraintWidget next5 = widget3.mNextChainWidget[orientation];
                    while (next5 != null && next5.getVisibility() == i2) {
                        next5 = next5.mNextChainWidget[orientation];
                    }
                    if (widget3 == firstVisibleWidget || widget3 == lastVisibleWidget || next5 == null) {
                        widget3 = widget3;
                        previousVisibleWidget = previousVisibleWidget;
                        next = next5;
                    } else {
                        if (next5 != lastVisibleWidget) {
                            next2 = next5;
                        } else {
                            next2 = null;
                        }
                        ConstraintAnchor beginAnchor = widget3.mListAnchors[offset];
                        SolverVariable begin5 = beginAnchor.mSolverVariable;
                        if (beginAnchor.mTarget != null) {
                            SolverVariable solverVariable = beginAnchor.mTarget.mSolverVariable;
                        }
                        SolverVariable beginTarget3 = previousVisibleWidget.mListAnchors[offset + 1].mSolverVariable;
                        SolverVariable beginNext3 = null;
                        int beginMargin2 = beginAnchor.getMargin();
                        int nextMargin2 = widget3.mListAnchors[offset + 1].getMargin();
                        if (next2 != null) {
                            ConstraintAnchor beginNextAnchor3 = next2.mListAnchors[offset];
                            SolverVariable beginNext4 = beginNextAnchor3.mSolverVariable;
                            beginNextTarget = beginNextAnchor3.mTarget != null ? beginNextAnchor3.mTarget.mSolverVariable : null;
                            beginNext = beginNext4;
                            beginNextAnchor = beginNextAnchor3;
                        } else {
                            ConstraintAnchor beginNextAnchor4 = lastVisibleWidget.mListAnchors[offset];
                            if (beginNextAnchor4 != null) {
                                beginNext3 = beginNextAnchor4.mSolverVariable;
                            }
                            beginNextAnchor = beginNextAnchor4;
                            beginNextTarget = widget3.mListAnchors[offset + 1].mSolverVariable;
                            beginNext = beginNext3;
                        }
                        if (beginNextAnchor != null) {
                            nextMargin2 += beginNextAnchor.getMargin();
                        }
                        if (previousVisibleWidget != null) {
                            beginMargin2 += previousVisibleWidget.mListAnchors[offset + 1].getMargin();
                        }
                        if (!applyFixedEquality) {
                            strength = 4;
                        } else {
                            strength = 8;
                        }
                        if (begin5 != null && beginTarget3 != null && beginNext != null && beginNextTarget != null) {
                            system.addCentering(begin5, beginTarget3, beginMargin2, 0.5f, beginNext, beginNextTarget, nextMargin2, strength);
                        }
                        next = next2;
                    }
                    if (widget3.getVisibility() == 8) {
                        previousVisibleWidget = previousVisibleWidget;
                    } else {
                        previousVisibleWidget = widget3;
                    }
                    widget3 = next;
                    i2 = 8;
                }
                ConstraintAnchor begin6 = firstVisibleWidget.mListAnchors[offset];
                ConstraintAnchor beginTarget4 = first.mListAnchors[offset].mTarget;
                ConstraintAnchor end6 = lastVisibleWidget.mListAnchors[offset + 1];
                ConstraintAnchor endTarget3 = last.mListAnchors[offset + 1].mTarget;
                if (beginTarget4 == null) {
                    endPointsStrength = 5;
                } else if (firstVisibleWidget != lastVisibleWidget) {
                    system.addEquality(begin6.mSolverVariable, beginTarget4.mSolverVariable, begin6.getMargin(), 5);
                    endPointsStrength = 5;
                } else if (endTarget3 != null) {
                    endPointsStrength = 5;
                    system.addCentering(begin6.mSolverVariable, beginTarget4.mSolverVariable, begin6.getMargin(), 0.5f, end6.mSolverVariable, endTarget3.mSolverVariable, end6.getMargin(), 5);
                } else {
                    endPointsStrength = 5;
                }
                if (endTarget3 != null && firstVisibleWidget != lastVisibleWidget) {
                    system.addEquality(end6.mSolverVariable, endTarget3.mSolverVariable, -end6.getMargin(), endPointsStrength);
                }
            }
        } else {
            boolean applyFixedEquality2 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
            ConstraintWidget widget4 = firstVisibleWidget;
            ConstraintWidget previousVisibleWidget2 = firstVisibleWidget;
            while (widget4 != null) {
                ConstraintWidget next6 = widget4.mNextChainWidget[orientation];
                while (next6 != null && next6.getVisibility() == 8) {
                    next6 = next6.mNextChainWidget[orientation];
                }
                if (next6 != null || widget4 == lastVisibleWidget) {
                    ConstraintAnchor beginAnchor2 = widget4.mListAnchors[offset];
                    SolverVariable begin7 = beginAnchor2.mSolverVariable;
                    SolverVariable beginTarget5 = beginAnchor2.mTarget != null ? beginAnchor2.mTarget.mSolverVariable : null;
                    if (previousVisibleWidget2 != widget4) {
                        beginTarget = previousVisibleWidget2.mListAnchors[offset + 1].mSolverVariable;
                    } else if (widget4 == firstVisibleWidget && previousVisibleWidget2 == widget4) {
                        beginTarget = first.mListAnchors[offset].mTarget != null ? first.mListAnchors[offset].mTarget.mSolverVariable : null;
                    } else {
                        beginTarget = beginTarget5;
                    }
                    SolverVariable beginNext5 = null;
                    int beginMargin3 = beginAnchor2.getMargin();
                    int nextMargin3 = widget4.mListAnchors[offset + 1].getMargin();
                    if (next6 != null) {
                        ConstraintAnchor beginNextAnchor5 = next6.mListAnchors[offset];
                        SolverVariable beginNext6 = beginNextAnchor5.mSolverVariable;
                        SolverVariable beginNextTarget3 = widget4.mListAnchors[offset + 1].mSolverVariable;
                        beginNextAnchor2 = beginNextAnchor5;
                        beginNext2 = beginNext6;
                        beginNextTarget2 = beginNextTarget3;
                    } else {
                        ConstraintAnchor beginNextAnchor6 = last.mListAnchors[offset + 1].mTarget;
                        if (beginNextAnchor6 != null) {
                            beginNext5 = beginNextAnchor6.mSolverVariable;
                        }
                        SolverVariable beginNextTarget4 = widget4.mListAnchors[offset + 1].mSolverVariable;
                        beginNextAnchor2 = beginNextAnchor6;
                        beginNext2 = beginNext5;
                        beginNextTarget2 = beginNextTarget4;
                    }
                    if (beginNextAnchor2 != null) {
                        nextMargin3 += beginNextAnchor2.getMargin();
                    }
                    if (previousVisibleWidget2 != null) {
                        beginMargin3 += previousVisibleWidget2.mListAnchors[offset + 1].getMargin();
                    }
                    if (begin7 == null || beginTarget == null || beginNext2 == null || beginNextTarget2 == null) {
                        nextMargin = 8;
                    } else {
                        int margin4 = beginMargin3;
                        if (widget4 != firstVisibleWidget) {
                            margin1 = margin4;
                        } else {
                            int margin5 = firstVisibleWidget.mListAnchors[offset].getMargin();
                            margin1 = margin5;
                        }
                        int margin6 = nextMargin3;
                        if (widget4 != lastVisibleWidget) {
                            margin2 = margin6;
                        } else {
                            int margin7 = lastVisibleWidget.mListAnchors[offset + 1].getMargin();
                            margin2 = margin7;
                        }
                        if (!applyFixedEquality2) {
                            strength2 = 5;
                        } else {
                            strength2 = 8;
                        }
                        nextMargin = 8;
                        system.addCentering(begin7, beginTarget, margin1, 0.5f, beginNext2, beginNextTarget2, margin2, strength2);
                    }
                } else {
                    nextMargin = 8;
                }
                if (widget4.getVisibility() == nextMargin) {
                    previousVisibleWidget2 = previousVisibleWidget2;
                } else {
                    previousVisibleWidget2 = widget4;
                }
                widget4 = next6;
            }
        }
        if ((isChainSpread || isChainSpreadInside) && firstVisibleWidget != null && firstVisibleWidget != lastVisibleWidget) {
            ConstraintAnchor begin8 = firstVisibleWidget.mListAnchors[offset];
            ConstraintAnchor end7 = lastVisibleWidget.mListAnchors[offset + 1];
            SolverVariable beginTarget6 = begin8.mTarget != null ? begin8.mTarget.mSolverVariable : null;
            SolverVariable endTarget4 = end7.mTarget != null ? end7.mTarget.mSolverVariable : null;
            if (last == lastVisibleWidget) {
                endTarget = endTarget4;
            } else {
                ConstraintAnchor realEnd = last.mListAnchors[offset + 1];
                SolverVariable endTarget5 = realEnd.mTarget != null ? realEnd.mTarget.mSolverVariable : null;
                endTarget = endTarget5;
            }
            if (firstVisibleWidget != lastVisibleWidget) {
                end = end7;
            } else {
                begin8 = firstVisibleWidget.mListAnchors[offset];
                end = firstVisibleWidget.mListAnchors[offset + 1];
            }
            if (beginTarget6 != null && endTarget != null) {
                int beginMargin4 = begin8.getMargin();
                if (lastVisibleWidget == null) {
                    lastVisibleWidget = last;
                }
                int endMargin2 = lastVisibleWidget.mListAnchors[offset + 1].getMargin();
                system.addCentering(begin8.mSolverVariable, beginTarget6, beginMargin4, 0.5f, endTarget, end.mSolverVariable, endMargin2, 5);
            }
        }
    }
}
