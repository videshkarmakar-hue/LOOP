package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ShadowKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.RectKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.AndroidPath_androidKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.PathFillType;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawTransform;
import androidx.compose.p001ui.graphics.drawscope.Stroke;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.ProgressBarRangeInfo;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a(\u0010\u0018\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a]\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010*\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a*\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u0002002\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007\u001a,\u00102\u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u00042\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aF\u00106\u001a\u00020\u0019*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a>\u0010A\u001a\u00020\u0019*\u0002072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010B\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\u0011\"\u0010\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E²\u0006\n\u0010F\u001a\u00020\u0002X\u008a\u0084\u0002"}, m195d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "Elevation", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", NotificationCompat.CATEGORY_PROGRESS, "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshContainer", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "PullToRefreshContainer-wBJOh4Y", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "positionalThresholdPx", "initialRefreshing", "", "enabled", "rememberPullToRefreshState", "positionalThreshold", "rememberPullToRefreshState--orJrPs", "(FLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "material3_release", "targetAlpha"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PullToRefreshKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = C1979Dp.m6801constructorimpl((float) 2.5d);
    private static final float ArcRadius = C1979Dp.m6801constructorimpl((float) 5.5d);
    private static final float SpinnerSize = C1979Dp.m6801constructorimpl(16);
    private static final float SpinnerContainerSize = C1979Dp.m6801constructorimpl(40);
    private static final float Elevation = ElevationTokens.INSTANCE.m3275getLevel2D9Ej5fM();
    private static final float ArrowWidth = C1979Dp.m6801constructorimpl(10);
    private static final float ArrowHeight = C1979Dp.m6801constructorimpl(5);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    /* JADX INFO: renamed from: PullToRefreshContainer-wBJOh4Y, reason: not valid java name */
    public static final void m3096PullToRefreshContainerwBJOh4Y(final PullToRefreshState state, Modifier modifier, Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function3, Shape shape, long containerColor, long contentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function3M3092getLambda1$material3_release;
        Shape shape2;
        long containerColor2;
        long contentColor2;
        Modifier.Companion modifier3;
        Object value$iv;
        Shape shape3;
        long contentColor3;
        Modifier modifier4;
        Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function4;
        long containerColor3;
        Composer $composer2 = $composer.startRestartGroup(-801976958);
        ComposerKt.sourceInformation($composer2, "C(PullToRefreshContainer)P(5,3,2,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color)113@4939L14,114@5003L12,118@5222L91,121@5384L584,121@5318L650:PullToRefresh.kt#djiw08");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function3M3092getLambda1$material3_release = function3;
        } else if (($changed & 384) == 0) {
            function3M3092getLambda1$material3_release = function3;
            $dirty |= $composer2.changedInstance(function3M3092getLambda1$material3_release) ? 256 : 128;
        } else {
            function3M3092getLambda1$material3_release = function3;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            shape2 = shape;
        } else if (($changed & 3072) == 0) {
            shape2 = shape;
            $dirty |= $composer2.changed(shape2) ? 2048 : 1024;
        } else {
            shape2 = shape;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer2.changed(containerColor2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer2.changed(contentColor2) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i6;
        } else {
            contentColor2 = contentColor;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape3 = shape2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            modifier4 = modifier2;
            function4 = function3M3092getLambda1$material3_release;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    function3M3092getLambda1$material3_release = ComposableSingletons$PullToRefreshKt.INSTANCE.m3092getLambda1$material3_release();
                }
                if (i4 != 0) {
                    shape2 = PullToRefreshDefaults.INSTANCE.getShape();
                }
                if ((i & 16) != 0) {
                    containerColor2 = PullToRefreshDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    contentColor2 = PullToRefreshDefaults.INSTANCE.getContentColor($composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    modifier3 = modifier2;
                } else {
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-801976958, $dirty, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer (PullToRefresh.kt:115)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 751291370, "CC(remember):PullToRefresh.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$showElevation$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(state.getVerticalOffset() > 1.0f || state.isRefreshing());
                    }
                });
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final State showElevation = (State) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Modifier modifier5 = modifier3;
            final Shape shape4 = shape2;
            final long j = containerColor2;
            final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function5 = function3M3092getLambda1$material3_release;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor2)), ComposableLambdaKt.rememberComposableLambda(935555266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv2;
                    float fM6801constructorimpl;
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C125@5506L89,122@5394L568:PullToRefresh.kt#djiw08");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(935555266, $changed2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer.<anonymous> (PullToRefresh.kt:122)");
                        }
                        Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(modifier5, PullToRefreshKt.getSpinnerContainerSize());
                        ComposerKt.sourceInformationMarkerStart($composer3, -1737250521, "CC(remember):PullToRefresh.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(state);
                        final PullToRefreshState pullToRefreshState = state;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                    invoke2(graphicsLayerScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                                    $this$graphicsLayer.setTranslationY(pullToRefreshState.getVerticalOffset() - Size.m4115getHeightimpl($this$graphicsLayer.getSize()));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierM913size3ABfNKs, (Function1) value$iv2);
                        if (showElevation.getValue().booleanValue()) {
                            fM6801constructorimpl = PullToRefreshKt.Elevation;
                        } else {
                            fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                        }
                        Modifier modifier$iv = BackgroundKt.m453backgroundbw27NRU(ShadowKt.m3954shadows4CzXII$default(modifierGraphicsLayer, fM6801constructorimpl, shape4, true, 0L, 0L, 24, null), j, shape4);
                        Function3<PullToRefreshState, Composer, Integer, Unit> function6 = function5;
                        PullToRefreshState pullToRefreshState2 = state;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i8 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 874077558, "C136@5936L16:PullToRefresh.kt#djiw08");
                        function6.invoke(pullToRefreshState2, $composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape2;
            contentColor3 = contentColor2;
            modifier4 = modifier3;
            function4 = function3M3092getLambda1$material3_release;
            containerColor3 = containerColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function6 = function4;
            final Shape shape5 = shape3;
            final long j2 = containerColor3;
            final long j3 = contentColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$2
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
                    PullToRefreshKt.m3096PullToRefreshContainerwBJOh4Y(state, modifier6, function6, shape5, j2, j3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: rememberPullToRefreshState--orJrPs, reason: not valid java name */
    public static final PullToRefreshState m3102rememberPullToRefreshStateorJrPs(float positionalThreshold, final Function0<Boolean> function0, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1935213334, "C(rememberPullToRefreshState)P(1:c#ui.unit.Dp)253@9584L7,261@9888L176,255@9680L384:PullToRefresh.kt#djiw08");
        if ((i & 1) != 0) {
            positionalThreshold = PullToRefreshDefaults.INSTANCE.m3094getPositionalThresholdD9Ej5fM();
        }
        if ((i & 2) != 0) {
            Function0 enabled = new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            };
            function0 = enabled;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1935213334, $changed, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:252)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) objConsume;
        final float positionalThresholdPx = density.mo567toPx0680j_4(positionalThreshold);
        Object[] objArr = {Float.valueOf(positionalThresholdPx), function0};
        Saver<PullToRefreshState, Boolean> Saver = PullToRefreshStateImpl.INSTANCE.Saver(positionalThresholdPx, function0);
        ComposerKt.sourceInformationMarkerStart($composer, 804873447, "CC(remember):PullToRefresh.kt#9igjgp");
        boolean invalid$iv = (((($changed & 112) ^ 48) > 32 && $composer.changed(function0)) || ($changed & 48) == 32) | $composer.changed(positionalThresholdPx);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<PullToRefreshState>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PullToRefreshState invoke() {
                    return new PullToRefreshStateImpl(false, positionalThresholdPx, function0);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        PullToRefreshState pullToRefreshState = (PullToRefreshState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return pullToRefreshState;
    }

    public static /* synthetic */ PullToRefreshState PullToRefreshState$default(float f, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshState.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            };
        }
        return PullToRefreshState(f, z, function0);
    }

    public static final PullToRefreshState PullToRefreshState(float positionalThresholdPx, boolean initialRefreshing, Function0<Boolean> function0) {
        return new PullToRefreshStateImpl(initialRefreshing, positionalThresholdPx, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m3095CircularArrowProgressIndicatorRPmYEkk(final Function0<Float> function0, final long color, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-569718810);
        ComposerKt.sourceInformation($composer3, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)428@15876L61,430@16038L88,433@16148L74,436@16300L118,441@16456L443,434@16227L672:PullToRefresh.kt#djiw08");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(color) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, $dirty2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:427)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -656076138, "CC(remember):PullToRefresh.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                Path $this$CircularArrowProgressIndicator_RPmYEkk_u24lambda_u244_u24lambda_u243 = AndroidPath_androidKt.Path();
                $this$CircularArrowProgressIndicator_RPmYEkk_u24lambda_u244_u24lambda_u243.mo4184setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4581getEvenOddRgk1Os());
                value$iv = $this$CircularArrowProgressIndicator_RPmYEkk_u24lambda_u244_u24lambda_u243;
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Path path = (Path) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -656075976, "CC(remember):PullToRefresh.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(function0.invoke().floatValue() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            State targetAlpha$delegate = (State) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$6(targetAlpha$delegate), AlphaTween, 0.0f, null, null, $composer3, 48, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -656075714, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo($this$semantics, new ProgressBarRangeInfo(function0.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0));
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(SemanticsModifierKt.semantics(companion, true, (Function1) value$iv3), SpinnerSize);
            ComposerKt.sourceInformationMarkerStart($composer3, -656075558, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | $composer3.changed(stateAnimateFloatAsState) | (($dirty2 & 112) == 32) | $composer3.changedInstance(path);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) throws Throwable {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) throws Throwable {
                        long previousSize$iv$iv;
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv;
                        ArrowValues values = PullToRefreshKt.ArrowValues(function0.invoke().floatValue());
                        float alpha = stateAnimateFloatAsState.getValue().floatValue();
                        float degrees$iv = values.getRotation();
                        long j = color;
                        Path path2 = path;
                        long pivot$iv = $this$Canvas.mo4772getCenterF1C5BW0();
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$Canvas.getDrawContext();
                        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.mo4779getSizeNHjbRc();
                        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
                        try {
                            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
                            $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4785rotateUv8p0NA(degrees$iv, pivot$iv);
                            float arcRadius = $this$Canvas.mo567toPx0680j_4(PullToRefreshKt.ArcRadius) + ($this$Canvas.mo567toPx0680j_4(PullToRefreshKt.StrokeWidth) / 2.0f);
                            Rect arcBounds = RectKt.m4088Rect3MmeM6k(androidx.compose.p001ui.geometry.SizeKt.m4128getCenteruvyYCjk($this$Canvas.mo4773getSizeNHjbRc()), arcRadius);
                            try {
                                PullToRefreshKt.m3101drawCircularIndicatorKzyDr3Q($this$Canvas, j, alpha, values, arcBounds, PullToRefreshKt.StrokeWidth);
                                $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                try {
                                    PullToRefreshKt.m3100drawArrowuDrxG_w($this$Canvas, path2, arcBounds, j, alpha, values, PullToRefreshKt.StrokeWidth);
                                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                    $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv2);
                                } catch (Throwable th) {
                                    th = th;
                                    previousSize$iv$iv = previousSize$iv$iv2;
                                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                    $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                previousSize$iv$iv = previousSize$iv$iv2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            previousSize$iv$iv = previousSize$iv$iv2;
                            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            CanvasKt.Canvas(modifierM913size3ABfNKs, (Function1) value$iv4, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    PullToRefreshKt.m3095CircularArrowProgressIndicatorRPmYEkk(function0, color, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    public static final void m3101drawCircularIndicatorKzyDr3Q(DrawScope $this$drawCircularIndicator_u2dKzyDr3Q, long color, float alpha, ArrowValues values, Rect arcBounds, float strokeWidth) {
        DrawScope.CC.m4843drawArcyD3GUKo$default($this$drawCircularIndicator_u2dKzyDr3Q, color, values.getStartAngle(), values.getEndAngle() - values.getStartAngle(), false, arcBounds.m4084getTopLeftF1C5BW0(), arcBounds.m4082getSizeNHjbRc(), alpha, new Stroke($this$drawCircularIndicator_u2dKzyDr3Q.mo567toPx0680j_4(strokeWidth), 0.0f, StrokeCap.INSTANCE.m4652getButtKaPHkGw(), 0, null, 26, null), null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * 5) / 3;
        float overshootPercent = Math.abs(progress) - 1.0f;
        float linearTension = RangesKt.coerceIn(overshootPercent, 0.0f, 2.0f);
        float tensionPercent = linearTension - (((float) Math.pow(linearTension, 2)) / 4);
        float endTrim = MaxProgressArc * adjustedPercent;
        float rotation = (((0.4f * adjustedPercent) - 0.25f) + tensionPercent) * 0.5f;
        float f = 360;
        float startAngle = rotation * f;
        float endAngle = (rotation + endTrim) * f;
        float scale = Math.min(1.0f, adjustedPercent);
        return new ArrowValues(rotation, startAngle, endAngle, scale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    public static final void m3100drawArrowuDrxG_w(DrawScope $this$drawArrow_u2duDrxG_w, Path arrow, Rect bounds, long color, float alpha, ArrowValues values, float strokeWidth) throws Throwable {
        long previousSize$iv$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv;
        arrow.reset();
        arrow.moveTo(0.0f, 0.0f);
        arrow.lineTo(($this$drawArrow_u2duDrxG_w.mo567toPx0680j_4(ArrowWidth) * values.getScale()) / 2, $this$drawArrow_u2duDrxG_w.mo567toPx0680j_4(ArrowHeight) * values.getScale());
        arrow.lineTo($this$drawArrow_u2duDrxG_w.mo567toPx0680j_4(ArrowWidth) * values.getScale(), 0.0f);
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        float inset = ($this$drawArrow_u2duDrxG_w.mo567toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f;
        arrow.mo4186translatek4lQ0M(OffsetKt.Offset((Offset.m4049getXimpl(bounds.m4079getCenterF1C5BW0()) + radius) - inset, Offset.m4050getYimpl(bounds.m4079getCenterF1C5BW0()) - $this$drawArrow_u2duDrxG_w.mo567toPx0680j_4(strokeWidth)));
        float degrees$iv = values.getEndAngle() - $this$drawArrow_u2duDrxG_w.mo567toPx0680j_4(strokeWidth);
        long pivot$iv = $this$drawArrow_u2duDrxG_w.mo4772getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$drawArrow_u2duDrxG_w.getDrawContext();
        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
        try {
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
            $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4785rotateUv8p0NA(degrees$iv, pivot$iv);
            try {
                DrawScope.CC.m4854drawPathLG529CI$default($this$drawArrow_u2duDrxG_w, arrow, color, alpha, new Stroke($this$drawArrow_u2duDrxG_w.mo567toPx0680j_4(strokeWidth), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
                $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv$iv2.mo4780setSizeuvyYCjk(previousSize$iv$iv2);
            } catch (Throwable th) {
                th = th;
                $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                previousSize$iv$iv = previousSize$iv$iv2;
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            previousSize$iv$iv = previousSize$iv$iv2;
            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
        }
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }
}
