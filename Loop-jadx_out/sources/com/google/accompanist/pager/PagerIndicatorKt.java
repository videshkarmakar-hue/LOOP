package com.google.accompanist.pager;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PagerIndicator.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0080\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0016\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0018\u001a~\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0014\u001a\u0080\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016\u001a~\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m195d2 = {"HorizontalPagerIndicator", "", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pageCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "pageIndexMapping", "Lkotlin/Function1;", "activeColor", "Landroidx/compose/ui/graphics/Color;", "inactiveColor", "indicatorWidth", "Landroidx/compose/ui/unit/Dp;", "indicatorHeight", "spacing", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "HorizontalPagerIndicator-K_mkGiw", "(Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;JJFFFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "Lcom/google/accompanist/pager/PagerState;", "(Lcom/google/accompanist/pager/PagerState;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;JJFFFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "Lcom/google/accompanist/pager/PagerStateBridge;", "(Lcom/google/accompanist/pager/PagerStateBridge;ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;JJFFFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "VerticalPagerIndicator", "VerticalPagerIndicator-K_mkGiw", "pager-indicators_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerIndicatorKt {
    @Deprecated(message = "\n   HorizontalPagerIndicator for accompanist Pagers are deprecated, please use the version that takes \n   androidx.compose.foundation.pager.PagerState instead\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
    /* JADX INFO: renamed from: HorizontalPagerIndicator-K_mkGiw, reason: not valid java name */
    public static final void m7180HorizontalPagerIndicatorK_mkGiw(final PagerState pagerState, Modifier modifier, int pageCount, Function1<? super Integer, Integer> function1, long activeColor, long inactiveColor, float indicatorWidth, float indicatorHeight, float spacing, Shape indicatorShape, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int pageCount2;
        Function1<? super Integer, Integer> function2;
        long inactiveColor2;
        float indicatorWidth2;
        long activeColor2;
        float indicatorHeight2;
        float spacing2;
        RoundedCornerShape indicatorShape2;
        Object value$iv;
        Shape indicatorShape3;
        float indicatorHeight3;
        long activeColor3;
        Modifier modifier3;
        int pageCount3;
        float spacing3;
        Function1<? super Integer, Integer> function3;
        long inactiveColor3;
        float indicatorWidth3;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer $composer2 = $composer.startRestartGroup(1678773673);
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(pagerState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                pageCount2 = pageCount;
                int i3 = $composer2.changed(pageCount2) ? 256 : 128;
                $dirty |= i3;
            } else {
                pageCount2 = pageCount;
            }
            $dirty |= i3;
        } else {
            pageCount2 = pageCount;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function2 = function1;
        } else if (($changed & 7168) == 0) {
            function2 = function1;
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if (($changed & 57344) == 0) {
            $dirty |= ((i & 16) == 0 && $composer2.changed(activeColor)) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                inactiveColor2 = inactiveColor;
                int i5 = $composer2.changed(inactiveColor2) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                inactiveColor2 = inactiveColor;
            }
            $dirty |= i5;
        } else {
            inactiveColor2 = inactiveColor;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
            indicatorWidth2 = indicatorWidth;
        } else if (($changed & 3670016) == 0) {
            indicatorWidth2 = indicatorWidth;
            $dirty |= $composer2.changed(indicatorWidth2) ? 1048576 : 524288;
        } else {
            indicatorWidth2 = indicatorWidth;
        }
        if (($changed & 29360128) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(indicatorHeight)) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(spacing)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty |= ((i & 512) == 0 && $composer2.changed(indicatorShape)) ? 536870912 : 268435456;
        }
        if (($dirty & 1533916891) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            activeColor3 = activeColor;
            indicatorHeight3 = indicatorHeight;
            spacing3 = spacing;
            indicatorShape3 = indicatorShape;
            modifier3 = modifier2;
            pageCount3 = pageCount2;
            function3 = function2;
            inactiveColor3 = inactiveColor2;
            indicatorWidth3 = indicatorWidth2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    pageCount2 = pagerState.getPageCount();
                }
                if (i4 != 0) {
                    function2 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$1
                        public final Integer invoke(int it) {
                            return Integer.valueOf(it);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                            return invoke(num.intValue());
                        }
                    };
                }
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    activeColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
                    $dirty &= -57345;
                } else {
                    activeColor2 = activeColor;
                }
                if ((i & 32) != 0) {
                    long j = activeColor2;
                    inactiveColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : ContentAlpha.INSTANCE.getDisabled($composer2, ContentAlpha.$stable), (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
                    $dirty &= -458753;
                }
                if (i6 != 0) {
                    indicatorWidth2 = C1979Dp.m6801constructorimpl(8);
                }
                int $this$dp$iv = i & 128;
                if ($this$dp$iv != 0) {
                    indicatorHeight2 = indicatorWidth2;
                    $dirty &= -29360129;
                } else {
                    indicatorHeight2 = indicatorHeight;
                }
                if ((i & 256) != 0) {
                    spacing2 = indicatorWidth2;
                    $dirty &= -234881025;
                } else {
                    spacing2 = spacing;
                }
                if ((i & 512) != 0) {
                    indicatorShape2 = RoundedCornerShapeKt.getCircleShape();
                    $dirty &= -1879048193;
                } else {
                    indicatorShape2 = indicatorShape;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 512) != 0) {
                    activeColor2 = activeColor;
                    spacing2 = spacing;
                    indicatorShape2 = indicatorShape;
                    $dirty = (-1879048193) & $dirty;
                    indicatorHeight2 = indicatorHeight;
                } else {
                    activeColor2 = activeColor;
                    indicatorHeight2 = indicatorHeight;
                    spacing2 = spacing;
                    indicatorShape2 = indicatorShape;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1678773673, $dirty, -1, "com.google.accompanist.pager.HorizontalPagerIndicator (PagerIndicator.kt:87)");
            }
            $composer2.startReplaceableGroup(-1521406528);
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$1$1
                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public int getCurrentPage() {
                        return pagerState.getCurrentPage();
                    }

                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public float getCurrentPageOffset() {
                        return pagerState.getCurrentPageOffset();
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$1$1 stateBridge = (PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$1$1) value$iv;
            $composer2.endReplaceableGroup();
            m7181HorizontalPagerIndicatorK_mkGiw(stateBridge, pageCount2, modifier2, function2, activeColor2, inactiveColor2, indicatorWidth2, indicatorHeight2, spacing2, indicatorShape2, $composer2, (($dirty << 3) & 896) | (($dirty >> 3) & 112) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016) | ($dirty & 29360128) | ($dirty & 234881024) | ($dirty & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicatorShape3 = indicatorShape2;
            indicatorHeight3 = indicatorHeight2;
            activeColor3 = activeColor2;
            modifier3 = modifier2;
            pageCount3 = pageCount2;
            spacing3 = spacing2;
            function3 = function2;
            inactiveColor3 = inactiveColor2;
            indicatorWidth3 = indicatorWidth2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final int i7 = pageCount3;
            final Function1<? super Integer, Integer> function4 = function3;
            final long j2 = activeColor3;
            final long j3 = inactiveColor3;
            final float f = indicatorWidth3;
            final float f2 = indicatorHeight3;
            final float f3 = spacing3;
            final Shape shape = indicatorShape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    PagerIndicatorKt.m7180HorizontalPagerIndicatorK_mkGiw(pagerState, modifier4, i7, function4, j2, j3, f, f2, f3, shape, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "\n   PagerIndicator for is deprecated, we recommend forking this implementation and\n   customising for your needs.\nFor more migration information, please visit https://google.github.io/accompanist/pager/\n")
    /* JADX INFO: renamed from: HorizontalPagerIndicator-K_mkGiw, reason: not valid java name */
    public static final void m7179HorizontalPagerIndicatorK_mkGiw(final androidx.compose.foundation.pager.PagerState pagerState, final int pageCount, Modifier modifier, Function1<? super Integer, Integer> function1, long activeColor, long inactiveColor, float indicatorWidth, float indicatorHeight, float spacing, Shape indicatorShape, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1<? super Integer, Integer> function2;
        long j;
        long j2;
        float indicatorWidth2;
        long activeColor2;
        long inactiveColor2;
        float indicatorHeight2;
        float spacing2;
        RoundedCornerShape indicatorShape2;
        Object value$iv;
        float indicatorHeight3;
        long activeColor3;
        Modifier modifier3;
        float spacing3;
        Function1<? super Integer, Integer> function3;
        float indicatorWidth3;
        long inactiveColor3;
        Shape indicatorShape3;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer $composer2 = $composer.startRestartGroup(870455235);
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(pagerState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(pageCount) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function2 = function1;
        } else if (($changed & 7168) == 0) {
            function2 = function1;
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                j = activeColor;
                int i4 = $composer2.changed(j) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                j = activeColor;
            }
            $dirty |= i4;
        } else {
            j = activeColor;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                j2 = inactiveColor;
                int i5 = $composer2.changed(j2) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                j2 = inactiveColor;
            }
            $dirty |= i5;
        } else {
            j2 = inactiveColor;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
            indicatorWidth2 = indicatorWidth;
        } else if (($changed & 3670016) == 0) {
            indicatorWidth2 = indicatorWidth;
            $dirty |= $composer2.changed(indicatorWidth2) ? 1048576 : 524288;
        } else {
            indicatorWidth2 = indicatorWidth;
        }
        if (($changed & 29360128) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(indicatorHeight)) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(spacing)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty |= ((i & 512) == 0 && $composer2.changed(indicatorShape)) ? 536870912 : 268435456;
        }
        if (($dirty & 1533916891) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            indicatorHeight3 = indicatorHeight;
            spacing3 = spacing;
            indicatorShape3 = indicatorShape;
            modifier3 = modifier2;
            function3 = function2;
            indicatorWidth3 = indicatorWidth2;
            activeColor3 = j;
            inactiveColor3 = j2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    function2 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$3
                        public final Integer invoke(int it) {
                            return Integer.valueOf(it);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                            return invoke(num.intValue());
                        }
                    };
                }
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    activeColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
                    $dirty &= -57345;
                } else {
                    activeColor2 = j;
                }
                if ((i & 32) != 0) {
                    long j3 = activeColor2;
                    inactiveColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : ContentAlpha.INSTANCE.getDisabled($composer2, ContentAlpha.$stable), (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
                    $dirty &= -458753;
                } else {
                    inactiveColor2 = j2;
                }
                if (i6 != 0) {
                    indicatorWidth2 = C1979Dp.m6801constructorimpl(8);
                }
                int $this$dp$iv = i & 128;
                if ($this$dp$iv != 0) {
                    indicatorHeight2 = indicatorWidth2;
                    $dirty &= -29360129;
                } else {
                    indicatorHeight2 = indicatorHeight;
                }
                if ((i & 256) != 0) {
                    spacing2 = indicatorWidth2;
                    $dirty &= -234881025;
                } else {
                    spacing2 = spacing;
                }
                if ((i & 512) != 0) {
                    indicatorShape2 = RoundedCornerShapeKt.getCircleShape();
                    $dirty &= -1879048193;
                } else {
                    indicatorShape2 = indicatorShape;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 512) != 0) {
                    spacing2 = spacing;
                    $dirty = (-1879048193) & $dirty;
                    activeColor2 = j;
                    inactiveColor2 = j2;
                    indicatorHeight2 = indicatorHeight;
                    indicatorShape2 = indicatorShape;
                } else {
                    indicatorHeight2 = indicatorHeight;
                    spacing2 = spacing;
                    activeColor2 = j;
                    inactiveColor2 = j2;
                    indicatorShape2 = indicatorShape;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(870455235, $dirty, -1, "com.google.accompanist.pager.HorizontalPagerIndicator (PagerIndicator.kt:158)");
            }
            $composer2.startReplaceableGroup(-1521403359);
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1
                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public int getCurrentPage() {
                        return pagerState.getCurrentPage();
                    }

                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public float getCurrentPageOffset() {
                        return pagerState.getCurrentPageOffsetFraction();
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1 stateBridge = (PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1) value$iv;
            $composer2.endReplaceableGroup();
            m7181HorizontalPagerIndicatorK_mkGiw(stateBridge, pageCount, modifier2, function2, activeColor2, inactiveColor2, indicatorWidth2, indicatorHeight2, spacing2, indicatorShape2, $composer2, ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016) | ($dirty & 29360128) | ($dirty & 234881024) | ($dirty & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicatorHeight3 = indicatorHeight2;
            activeColor3 = activeColor2;
            modifier3 = modifier2;
            spacing3 = spacing2;
            function3 = function2;
            indicatorWidth3 = indicatorWidth2;
            inactiveColor3 = inactiveColor2;
            indicatorShape3 = indicatorShape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function1<? super Integer, Integer> function4 = function3;
            final long j4 = activeColor3;
            final long j5 = inactiveColor3;
            final float f = indicatorWidth3;
            final float f2 = indicatorHeight3;
            final float f3 = spacing3;
            final Shape shape = indicatorShape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    PagerIndicatorKt.m7179HorizontalPagerIndicatorK_mkGiw(pagerState, pageCount, modifier4, function4, j4, j5, f, f2, f3, shape, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: HorizontalPagerIndicator-K_mkGiw, reason: not valid java name */
    public static final void m7181HorizontalPagerIndicatorK_mkGiw(final PagerStateBridge pagerState, final int pageCount, Modifier modifier, Function1<? super Integer, Integer> function1, long activeColor, long inactiveColor, float indicatorWidth, float indicatorHeight, float spacing, Shape indicatorShape, Composer $composer, final int $changed, final int i) {
        Function1<? super Integer, Integer> function2;
        long activeColor2;
        long j;
        PagerIndicatorKt$HorizontalPagerIndicator$5 pagerIndicatorKt$HorizontalPagerIndicator$5;
        long inactiveColor2;
        float indicatorWidth2;
        float indicatorHeight2;
        float spacing2;
        Modifier modifier2;
        int $dirty;
        Shape indicatorShape2;
        Function0<ComposeUiNode> function0;
        float spacing3;
        Function0<ComposeUiNode> function3;
        long inactiveColor3;
        long activeColor3;
        Modifier.Companion companionM453backgroundbw27NRU;
        Shape indicatorShape3;
        Function1<? super Integer, Integer> function4;
        long activeColor4;
        float indicatorWidth3;
        float indicatorHeight3;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1605247238);
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(pagerState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(pageCount) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            function2 = function1;
        } else if (($changed & 7168) == 0) {
            function2 = function1;
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                activeColor2 = activeColor;
                int i4 = $composer2.changed(activeColor2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                activeColor2 = activeColor;
            }
            $dirty2 |= i4;
        } else {
            activeColor2 = activeColor;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                j = inactiveColor;
                int i5 = $composer2.changed(j) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                j = inactiveColor;
            }
            $dirty2 |= i5;
        } else {
            j = inactiveColor;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer2.changed(indicatorWidth) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(indicatorHeight)) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty2 |= ((i & 256) == 0 && $composer2.changed(spacing)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty2 |= ((i & 512) == 0 && $composer2.changed(indicatorShape)) ? 536870912 : 268435456;
        }
        if (($dirty2 & 1533916891) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            indicatorWidth3 = indicatorWidth;
            indicatorHeight3 = indicatorHeight;
            spacing3 = spacing;
            indicatorShape3 = indicatorShape;
            function4 = function2;
            activeColor4 = activeColor2;
            inactiveColor3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                pagerIndicatorKt$HorizontalPagerIndicator$5 = i3 != 0 ? new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$5
                    public final Integer invoke(int it) {
                        return Integer.valueOf(it);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                } : function1;
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    activeColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    long j2 = activeColor2;
                    inactiveColor2 = Color.m4289copywmQWz5c(j2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j2) : ContentAlpha.INSTANCE.getDisabled($composer2, ContentAlpha.$stable), (14 & 2) != 0 ? Color.m4297getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j2) : 0.0f);
                    $dirty2 &= -458753;
                } else {
                    inactiveColor2 = j;
                }
                indicatorWidth2 = i6 != 0 ? C1979Dp.m6801constructorimpl(8) : indicatorWidth;
                if ((i & 128) != 0) {
                    indicatorHeight2 = indicatorWidth2;
                    $dirty2 &= -29360129;
                } else {
                    indicatorHeight2 = indicatorHeight;
                }
                if ((i & 256) != 0) {
                    spacing2 = indicatorWidth2;
                    $dirty2 &= -234881025;
                } else {
                    spacing2 = spacing;
                }
                Modifier modifier5 = modifier4;
                if ((i & 512) != 0) {
                    $dirty = $dirty2 & (-1879048193);
                    indicatorShape2 = RoundedCornerShapeKt.getCircleShape();
                    modifier2 = modifier5;
                } else {
                    modifier2 = modifier5;
                    $dirty = $dirty2;
                    indicatorShape2 = indicatorShape;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i & 512) != 0) {
                    int i7 = (-1879048193) & $dirty2;
                    pagerIndicatorKt$HorizontalPagerIndicator$5 = function1;
                    spacing2 = spacing;
                    indicatorShape2 = indicatorShape;
                    $dirty = i7;
                    inactiveColor2 = j;
                    modifier2 = modifier;
                    indicatorWidth2 = indicatorWidth;
                    indicatorHeight2 = indicatorHeight;
                } else {
                    modifier2 = modifier;
                    pagerIndicatorKt$HorizontalPagerIndicator$5 = function1;
                    spacing2 = spacing;
                    $dirty = $dirty2;
                    inactiveColor2 = j;
                    indicatorWidth2 = indicatorWidth;
                    indicatorHeight2 = indicatorHeight;
                    indicatorShape2 = indicatorShape;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1605247238, $dirty, -1, "com.google.accompanist.pager.HorizontalPagerIndicator (PagerIndicator.kt:194)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$HorizontalPagerIndicator_K_mkGiw_u24lambda_u242 = (Density) objConsume3;
            final int indicatorWidthPx = $this$HorizontalPagerIndicator_K_mkGiw_u24lambda_u242.mo561roundToPx0680j_4(indicatorWidth2);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$HorizontalPagerIndicator_K_mkGiw_u24lambda_u243 = (Density) objConsume4;
            final int spacingPx = $this$HorizontalPagerIndicator_K_mkGiw_u24lambda_u243.mo561roundToPx0680j_4(spacing2);
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenterStart();
            int $changed$iv = (($dirty >> 6) & 14) | 48;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            int $i$f$Box = (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112);
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, $i$f$Box);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
            Modifier modifier6 = modifier2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i8 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i9 = (($changed$iv >> 6) & 112) | 6;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m744spacedBy0680j_4(spacing2);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            spacing3 = spacing2;
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier$iv);
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function3 = constructor2;
                $composer2.createNode(function3);
            } else {
                function3 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i10 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int $changed2 = ((384 >> 6) & 112) | 6;
            Modifier indicatorModifier = BackgroundKt.m453backgroundbw27NRU(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, indicatorWidth2, indicatorHeight2), inactiveColor2, indicatorShape2);
            inactiveColor3 = inactiveColor2;
            $composer2.startReplaceableGroup(-29719881);
            int i11 = 0;
            while (i11 < pageCount) {
                BoxKt.Box(indicatorModifier, $composer2, 0);
                i11++;
                $changed2 = $changed2;
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            final Function1<? super Integer, Integer> function5 = pagerIndicatorKt$HorizontalPagerIndicator$5;
            Modifier modifierM915sizeVpY3zN4 = SizeKt.m915sizeVpY3zN4(OffsetKt.offset(Modifier.INSTANCE, new Function1<Density, IntOffset>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$6$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                    return IntOffset.m6924boximpl(m7187invokeBjo55l4(density));
                }

                /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m7187invokeBjo55l4(Density offset) {
                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                    int position = function5.invoke(Integer.valueOf(pagerState.getCurrentPage())).intValue();
                    float offset2 = pagerState.getCurrentPageOffset();
                    int next = function5.invoke(Integer.valueOf(pagerState.getCurrentPage() + ((int) Math.signum(offset2)))).intValue();
                    float scrollPosition = RangesKt.coerceIn(((next - position) * Math.abs(offset2)) + position, 0.0f, RangesKt.coerceAtLeast(pageCount - 1, 0));
                    return IntOffsetKt.IntOffset((int) ((spacingPx + indicatorWidthPx) * scrollPosition), 0);
                }
            }), indicatorWidth2, indicatorHeight2);
            if (pageCount > 0) {
                activeColor3 = activeColor2;
                companionM453backgroundbw27NRU = BackgroundKt.m453backgroundbw27NRU(Modifier.INSTANCE, activeColor3, indicatorShape2);
            } else {
                activeColor3 = activeColor2;
                companionM453backgroundbw27NRU = Modifier.INSTANCE;
            }
            BoxKt.Box(modifierM915sizeVpY3zN4.then(companionM453backgroundbw27NRU), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicatorShape3 = indicatorShape2;
            function4 = pagerIndicatorKt$HorizontalPagerIndicator$5;
            activeColor4 = activeColor3;
            indicatorWidth3 = indicatorWidth2;
            indicatorHeight3 = indicatorHeight2;
            modifier3 = modifier6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function1<? super Integer, Integer> function6 = function4;
            final long j3 = activeColor4;
            final long j4 = inactiveColor3;
            final float f = indicatorWidth3;
            final float f2 = indicatorHeight3;
            final float f3 = spacing3;
            final Shape shape = indicatorShape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    PagerIndicatorKt.m7181HorizontalPagerIndicatorK_mkGiw(pagerState, pageCount, modifier7, (Function1<? super Integer, Integer>) function6, j3, j4, f, f2, f3, shape, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "\n   VerticalPagerIndicator for accompanist Pagers are deprecated, please use the version that takes \n   androidx.compose.foundation.pager.PagerState instead\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
    /* JADX INFO: renamed from: VerticalPagerIndicator-K_mkGiw, reason: not valid java name */
    public static final void m7183VerticalPagerIndicatorK_mkGiw(final PagerState pagerState, Modifier modifier, int pageCount, Function1<? super Integer, Integer> function1, long activeColor, long inactiveColor, float indicatorHeight, float indicatorWidth, float spacing, Shape indicatorShape, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int pageCount2;
        Function1<? super Integer, Integer> function2;
        long inactiveColor2;
        float indicatorHeight2;
        long activeColor2;
        float indicatorWidth2;
        float spacing2;
        RoundedCornerShape indicatorShape2;
        Object value$iv;
        Shape indicatorShape3;
        float indicatorWidth3;
        long activeColor3;
        Modifier modifier3;
        int pageCount3;
        float spacing3;
        Function1<? super Integer, Integer> function3;
        long inactiveColor3;
        float indicatorHeight3;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer $composer2 = $composer.startRestartGroup(51399291);
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(pagerState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                pageCount2 = pageCount;
                int i3 = $composer2.changed(pageCount2) ? 256 : 128;
                $dirty |= i3;
            } else {
                pageCount2 = pageCount;
            }
            $dirty |= i3;
        } else {
            pageCount2 = pageCount;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function2 = function1;
        } else if (($changed & 7168) == 0) {
            function2 = function1;
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if (($changed & 57344) == 0) {
            $dirty |= ((i & 16) == 0 && $composer2.changed(activeColor)) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                inactiveColor2 = inactiveColor;
                int i5 = $composer2.changed(inactiveColor2) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                inactiveColor2 = inactiveColor;
            }
            $dirty |= i5;
        } else {
            inactiveColor2 = inactiveColor;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
            indicatorHeight2 = indicatorHeight;
        } else if (($changed & 3670016) == 0) {
            indicatorHeight2 = indicatorHeight;
            $dirty |= $composer2.changed(indicatorHeight2) ? 1048576 : 524288;
        } else {
            indicatorHeight2 = indicatorHeight;
        }
        if (($changed & 29360128) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(indicatorWidth)) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(spacing)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty |= ((i & 512) == 0 && $composer2.changed(indicatorShape)) ? 536870912 : 268435456;
        }
        if (($dirty & 1533916891) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            activeColor3 = activeColor;
            indicatorWidth3 = indicatorWidth;
            spacing3 = spacing;
            indicatorShape3 = indicatorShape;
            modifier3 = modifier2;
            pageCount3 = pageCount2;
            function3 = function2;
            inactiveColor3 = inactiveColor2;
            indicatorHeight3 = indicatorHeight2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    pageCount2 = pagerState.getPageCount();
                }
                if (i4 != 0) {
                    function2 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$1
                        public final Integer invoke(int it) {
                            return Integer.valueOf(it);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                            return invoke(num.intValue());
                        }
                    };
                }
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    activeColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
                    $dirty &= -57345;
                } else {
                    activeColor2 = activeColor;
                }
                if ((i & 32) != 0) {
                    long j = activeColor2;
                    inactiveColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : ContentAlpha.INSTANCE.getDisabled($composer2, ContentAlpha.$stable), (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
                    $dirty &= -458753;
                }
                if (i6 != 0) {
                    indicatorHeight2 = C1979Dp.m6801constructorimpl(8);
                }
                int $this$dp$iv = i & 128;
                if ($this$dp$iv != 0) {
                    indicatorWidth2 = indicatorHeight2;
                    $dirty &= -29360129;
                } else {
                    indicatorWidth2 = indicatorWidth;
                }
                if ((i & 256) != 0) {
                    spacing2 = indicatorHeight2;
                    $dirty &= -234881025;
                } else {
                    spacing2 = spacing;
                }
                if ((i & 512) != 0) {
                    indicatorShape2 = RoundedCornerShapeKt.getCircleShape();
                    $dirty &= -1879048193;
                } else {
                    indicatorShape2 = indicatorShape;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 512) != 0) {
                    activeColor2 = activeColor;
                    spacing2 = spacing;
                    indicatorShape2 = indicatorShape;
                    $dirty = (-1879048193) & $dirty;
                    indicatorWidth2 = indicatorWidth;
                } else {
                    activeColor2 = activeColor;
                    indicatorWidth2 = indicatorWidth;
                    spacing2 = spacing;
                    indicatorShape2 = indicatorShape;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(51399291, $dirty, -1, "com.google.accompanist.pager.VerticalPagerIndicator (PagerIndicator.kt:290)");
            }
            $composer2.startReplaceableGroup(-1599583166);
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$stateBridge$1$1
                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public int getCurrentPage() {
                        return pagerState.getCurrentPage();
                    }

                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public float getCurrentPageOffset() {
                        return pagerState.getCurrentPageOffset();
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            PagerIndicatorKt$VerticalPagerIndicator$stateBridge$1$1 stateBridge = (PagerIndicatorKt$VerticalPagerIndicator$stateBridge$1$1) value$iv;
            $composer2.endReplaceableGroup();
            m7184VerticalPagerIndicatorK_mkGiw(stateBridge, pageCount2, modifier2, function2, activeColor2, inactiveColor2, indicatorHeight2, indicatorWidth2, spacing2, indicatorShape2, $composer2, (($dirty << 3) & 896) | (($dirty >> 3) & 112) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016) | ($dirty & 29360128) | ($dirty & 234881024) | ($dirty & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicatorShape3 = indicatorShape2;
            indicatorWidth3 = indicatorWidth2;
            activeColor3 = activeColor2;
            modifier3 = modifier2;
            pageCount3 = pageCount2;
            spacing3 = spacing2;
            function3 = function2;
            inactiveColor3 = inactiveColor2;
            indicatorHeight3 = indicatorHeight2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final int i7 = pageCount3;
            final Function1<? super Integer, Integer> function4 = function3;
            final long j2 = activeColor3;
            final long j3 = inactiveColor3;
            final float f = indicatorHeight3;
            final float f2 = indicatorWidth3;
            final float f3 = spacing3;
            final Shape shape = indicatorShape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    PagerIndicatorKt.m7183VerticalPagerIndicatorK_mkGiw(pagerState, modifier4, i7, function4, j2, j3, f, f2, f3, shape, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "\n   PagerIndicator for is deprecated, we recommend forking this implementation and\n   customising for your needs.\nFor more migration information, please visit https://google.github.io/accompanist/pager/\n")
    /* JADX INFO: renamed from: VerticalPagerIndicator-K_mkGiw, reason: not valid java name */
    public static final void m7182VerticalPagerIndicatorK_mkGiw(final androidx.compose.foundation.pager.PagerState pagerState, final int pageCount, Modifier modifier, Function1<? super Integer, Integer> function1, long activeColor, long inactiveColor, float indicatorHeight, float indicatorWidth, float spacing, Shape indicatorShape, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1<? super Integer, Integer> function2;
        long j;
        long j2;
        float indicatorHeight2;
        long activeColor2;
        long inactiveColor2;
        float indicatorWidth2;
        float spacing2;
        RoundedCornerShape indicatorShape2;
        Object value$iv;
        float indicatorWidth3;
        long activeColor3;
        Modifier modifier3;
        float spacing3;
        Function1<? super Integer, Integer> function3;
        float indicatorHeight3;
        long inactiveColor3;
        Shape indicatorShape3;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer $composer2 = $composer.startRestartGroup(-756919147);
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(pagerState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(pageCount) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function2 = function1;
        } else if (($changed & 7168) == 0) {
            function2 = function1;
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                j = activeColor;
                int i4 = $composer2.changed(j) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                j = activeColor;
            }
            $dirty |= i4;
        } else {
            j = activeColor;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                j2 = inactiveColor;
                int i5 = $composer2.changed(j2) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                j2 = inactiveColor;
            }
            $dirty |= i5;
        } else {
            j2 = inactiveColor;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
            indicatorHeight2 = indicatorHeight;
        } else if (($changed & 3670016) == 0) {
            indicatorHeight2 = indicatorHeight;
            $dirty |= $composer2.changed(indicatorHeight2) ? 1048576 : 524288;
        } else {
            indicatorHeight2 = indicatorHeight;
        }
        if (($changed & 29360128) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(indicatorWidth)) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(spacing)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty |= ((i & 512) == 0 && $composer2.changed(indicatorShape)) ? 536870912 : 268435456;
        }
        if (($dirty & 1533916891) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            indicatorWidth3 = indicatorWidth;
            spacing3 = spacing;
            indicatorShape3 = indicatorShape;
            modifier3 = modifier2;
            function3 = function2;
            indicatorHeight3 = indicatorHeight2;
            activeColor3 = j;
            inactiveColor3 = j2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    function2 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$3
                        public final Integer invoke(int it) {
                            return Integer.valueOf(it);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                            return invoke(num.intValue());
                        }
                    };
                }
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    activeColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
                    $dirty &= -57345;
                } else {
                    activeColor2 = j;
                }
                if ((i & 32) != 0) {
                    long j3 = activeColor2;
                    inactiveColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : ContentAlpha.INSTANCE.getDisabled($composer2, ContentAlpha.$stable), (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
                    $dirty &= -458753;
                } else {
                    inactiveColor2 = j2;
                }
                if (i6 != 0) {
                    indicatorHeight2 = C1979Dp.m6801constructorimpl(8);
                }
                int $this$dp$iv = i & 128;
                if ($this$dp$iv != 0) {
                    indicatorWidth2 = indicatorHeight2;
                    $dirty &= -29360129;
                } else {
                    indicatorWidth2 = indicatorWidth;
                }
                if ((i & 256) != 0) {
                    spacing2 = indicatorHeight2;
                    $dirty &= -234881025;
                } else {
                    spacing2 = spacing;
                }
                if ((i & 512) != 0) {
                    indicatorShape2 = RoundedCornerShapeKt.getCircleShape();
                    $dirty &= -1879048193;
                } else {
                    indicatorShape2 = indicatorShape;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 512) != 0) {
                    spacing2 = spacing;
                    $dirty = (-1879048193) & $dirty;
                    activeColor2 = j;
                    inactiveColor2 = j2;
                    indicatorWidth2 = indicatorWidth;
                    indicatorShape2 = indicatorShape;
                } else {
                    indicatorWidth2 = indicatorWidth;
                    spacing2 = spacing;
                    activeColor2 = j;
                    inactiveColor2 = j2;
                    indicatorShape2 = indicatorShape;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-756919147, $dirty, -1, "com.google.accompanist.pager.VerticalPagerIndicator (PagerIndicator.kt:359)");
            }
            $composer2.startReplaceableGroup(-1599580081);
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$stateBridge$2$1
                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public int getCurrentPage() {
                        return pagerState.getCurrentPage();
                    }

                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public float getCurrentPageOffset() {
                        return pagerState.getCurrentPageOffsetFraction();
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            PagerIndicatorKt$VerticalPagerIndicator$stateBridge$2$1 stateBridge = (PagerIndicatorKt$VerticalPagerIndicator$stateBridge$2$1) value$iv;
            $composer2.endReplaceableGroup();
            m7184VerticalPagerIndicatorK_mkGiw(stateBridge, pageCount, modifier2, function2, activeColor2, inactiveColor2, indicatorHeight2, indicatorWidth2, spacing2, indicatorShape2, $composer2, ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016) | ($dirty & 29360128) | ($dirty & 234881024) | ($dirty & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicatorWidth3 = indicatorWidth2;
            activeColor3 = activeColor2;
            modifier3 = modifier2;
            spacing3 = spacing2;
            function3 = function2;
            indicatorHeight3 = indicatorHeight2;
            inactiveColor3 = inactiveColor2;
            indicatorShape3 = indicatorShape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function1<? super Integer, Integer> function4 = function3;
            final long j4 = activeColor3;
            final long j5 = inactiveColor3;
            final float f = indicatorHeight3;
            final float f2 = indicatorWidth3;
            final float f3 = spacing3;
            final Shape shape = indicatorShape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    PagerIndicatorKt.m7182VerticalPagerIndicatorK_mkGiw(pagerState, pageCount, modifier4, function4, j4, j5, f, f2, f3, shape, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: VerticalPagerIndicator-K_mkGiw, reason: not valid java name */
    public static final void m7184VerticalPagerIndicatorK_mkGiw(final PagerStateBridge pagerState, final int pageCount, Modifier modifier, Function1<? super Integer, Integer> function1, long activeColor, long inactiveColor, float indicatorHeight, float indicatorWidth, float spacing, Shape indicatorShape, Composer $composer, final int $changed, final int i) {
        Function1<? super Integer, Integer> function2;
        long activeColor2;
        long j;
        PagerIndicatorKt$VerticalPagerIndicator$5 pagerIndicatorKt$VerticalPagerIndicator$5;
        long inactiveColor2;
        float indicatorHeight2;
        float indicatorWidth2;
        float spacing2;
        Modifier modifier2;
        int $dirty;
        Shape indicatorShape2;
        Function0<ComposeUiNode> function0;
        float spacing3;
        Function0<ComposeUiNode> function3;
        long inactiveColor3;
        long activeColor3;
        Modifier.Companion companionM453backgroundbw27NRU;
        Shape indicatorShape3;
        Function1<? super Integer, Integer> function4;
        long activeColor4;
        float indicatorHeight3;
        float indicatorWidth3;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1511110220);
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(pagerState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(pageCount) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            function2 = function1;
        } else if (($changed & 7168) == 0) {
            function2 = function1;
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                activeColor2 = activeColor;
                int i4 = $composer2.changed(activeColor2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                activeColor2 = activeColor;
            }
            $dirty2 |= i4;
        } else {
            activeColor2 = activeColor;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                j = inactiveColor;
                int i5 = $composer2.changed(j) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                j = inactiveColor;
            }
            $dirty2 |= i5;
        } else {
            j = inactiveColor;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer2.changed(indicatorHeight) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(indicatorWidth)) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty2 |= ((i & 256) == 0 && $composer2.changed(spacing)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty2 |= ((i & 512) == 0 && $composer2.changed(indicatorShape)) ? 536870912 : 268435456;
        }
        if (($dirty2 & 1533916891) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            indicatorHeight3 = indicatorHeight;
            indicatorWidth3 = indicatorWidth;
            spacing3 = spacing;
            indicatorShape3 = indicatorShape;
            function4 = function2;
            activeColor4 = activeColor2;
            inactiveColor3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                pagerIndicatorKt$VerticalPagerIndicator$5 = i3 != 0 ? new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$5
                    public final Integer invoke(int it) {
                        return Integer.valueOf(it);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                } : function1;
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localContentAlpha);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    activeColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    long j2 = activeColor2;
                    inactiveColor2 = Color.m4289copywmQWz5c(j2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j2) : ContentAlpha.INSTANCE.getDisabled($composer2, ContentAlpha.$stable), (14 & 2) != 0 ? Color.m4297getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j2) : 0.0f);
                    $dirty2 &= -458753;
                } else {
                    inactiveColor2 = j;
                }
                indicatorHeight2 = i6 != 0 ? C1979Dp.m6801constructorimpl(8) : indicatorHeight;
                if ((i & 128) != 0) {
                    indicatorWidth2 = indicatorHeight2;
                    $dirty2 &= -29360129;
                } else {
                    indicatorWidth2 = indicatorWidth;
                }
                if ((i & 256) != 0) {
                    spacing2 = indicatorHeight2;
                    $dirty2 &= -234881025;
                } else {
                    spacing2 = spacing;
                }
                Modifier modifier5 = modifier4;
                if ((i & 512) != 0) {
                    $dirty = $dirty2 & (-1879048193);
                    indicatorShape2 = RoundedCornerShapeKt.getCircleShape();
                    modifier2 = modifier5;
                } else {
                    modifier2 = modifier5;
                    $dirty = $dirty2;
                    indicatorShape2 = indicatorShape;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i & 512) != 0) {
                    int i7 = (-1879048193) & $dirty2;
                    pagerIndicatorKt$VerticalPagerIndicator$5 = function1;
                    spacing2 = spacing;
                    indicatorShape2 = indicatorShape;
                    $dirty = i7;
                    inactiveColor2 = j;
                    modifier2 = modifier;
                    indicatorHeight2 = indicatorHeight;
                    indicatorWidth2 = indicatorWidth;
                } else {
                    modifier2 = modifier;
                    pagerIndicatorKt$VerticalPagerIndicator$5 = function1;
                    spacing2 = spacing;
                    $dirty = $dirty2;
                    inactiveColor2 = j;
                    indicatorHeight2 = indicatorHeight;
                    indicatorWidth2 = indicatorWidth;
                    indicatorShape2 = indicatorShape;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1511110220, $dirty, -1, "com.google.accompanist.pager.VerticalPagerIndicator (PagerIndicator.kt:395)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$VerticalPagerIndicator_K_mkGiw_u24lambda_u249 = (Density) objConsume3;
            final int indicatorHeightPx = $this$VerticalPagerIndicator_K_mkGiw_u24lambda_u249.mo561roundToPx0680j_4(indicatorHeight2);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$VerticalPagerIndicator_K_mkGiw_u24lambda_u2410 = (Density) objConsume4;
            final int spacingPx = $this$VerticalPagerIndicator_K_mkGiw_u24lambda_u2410.mo561roundToPx0680j_4(spacing2);
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopCenter();
            int $changed$iv = (($dirty >> 6) & 14) | 48;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            int $i$f$Box = (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112);
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, $i$f$Box);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
            Modifier modifier6 = modifier2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i8 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i9 = (($changed$iv >> 6) & 112) | 6;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m744spacedBy0680j_4(spacing2);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
            spacing3 = spacing2;
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier$iv);
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function3 = constructor2;
                $composer2.createNode(function3);
            } else {
                function3 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i10 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int $changed2 = ((384 >> 6) & 112) | 6;
            Modifier indicatorModifier = BackgroundKt.m453backgroundbw27NRU(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, indicatorWidth2, indicatorHeight2), inactiveColor2, indicatorShape2);
            inactiveColor3 = inactiveColor2;
            $composer2.startReplaceableGroup(25775080);
            int i11 = 0;
            while (i11 < pageCount) {
                BoxKt.Box(indicatorModifier, $composer2, 0);
                i11++;
                $changed2 = $changed2;
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            final Function1<? super Integer, Integer> function5 = pagerIndicatorKt$VerticalPagerIndicator$5;
            Modifier modifierM915sizeVpY3zN4 = SizeKt.m915sizeVpY3zN4(OffsetKt.offset(Modifier.INSTANCE, new Function1<Density, IntOffset>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$6$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                    return IntOffset.m6924boximpl(m7188invokeBjo55l4(density));
                }

                /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m7188invokeBjo55l4(Density offset) {
                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                    int position = function5.invoke(Integer.valueOf(pagerState.getCurrentPage())).intValue();
                    float offset2 = pagerState.getCurrentPageOffset();
                    int next = function5.invoke(Integer.valueOf(pagerState.getCurrentPage() + ((int) Math.signum(offset2)))).intValue();
                    float scrollPosition = RangesKt.coerceIn(((next - position) * Math.abs(offset2)) + position, 0.0f, RangesKt.coerceAtLeast(pageCount - 1, 0));
                    return IntOffsetKt.IntOffset(0, (int) ((spacingPx + indicatorHeightPx) * scrollPosition));
                }
            }), indicatorWidth2, indicatorHeight2);
            if (pageCount > 0) {
                activeColor3 = activeColor2;
                companionM453backgroundbw27NRU = BackgroundKt.m453backgroundbw27NRU(Modifier.INSTANCE, activeColor3, indicatorShape2);
            } else {
                activeColor3 = activeColor2;
                companionM453backgroundbw27NRU = Modifier.INSTANCE;
            }
            BoxKt.Box(modifierM915sizeVpY3zN4.then(companionM453backgroundbw27NRU), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicatorShape3 = indicatorShape2;
            function4 = pagerIndicatorKt$VerticalPagerIndicator$5;
            activeColor4 = activeColor3;
            indicatorHeight3 = indicatorHeight2;
            indicatorWidth3 = indicatorWidth2;
            modifier3 = modifier6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function1<? super Integer, Integer> function6 = function4;
            final long j3 = activeColor4;
            final long j4 = inactiveColor3;
            final float f = indicatorHeight3;
            final float f2 = indicatorWidth3;
            final float f3 = spacing3;
            final Shape shape = indicatorShape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$VerticalPagerIndicator$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    PagerIndicatorKt.m7184VerticalPagerIndicatorK_mkGiw(pagerState, pageCount, modifier7, (Function1<? super Integer, Integer>) function6, j3, j4, f, f2, f3, shape, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
