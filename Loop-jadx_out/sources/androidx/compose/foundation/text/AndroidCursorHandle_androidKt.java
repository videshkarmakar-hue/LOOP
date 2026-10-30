package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.ImageBitmap;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawTransform;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.DpSize;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidCursorHandle.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0015\u001a\u00020\u000e*\u00020\u000eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m195d2 = {"CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "Sqrt2", "", "CursorHandle", "", "handlePosition", "Landroidx/compose/ui/geometry/Offset;", "modifier", "Landroidx/compose/ui/Modifier;", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "CursorHandle-wy32l68", "(JLandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawCursorHandle", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight = C1979Dp.m6801constructorimpl(25);
    private static final float CursorHandleWidth;
    private static final float Sqrt2 = 1.4142135f;

    static {
        float arg0$iv = CursorHandleHeight;
        CursorHandleWidth = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv * 2.0f) / 2.4142137f);
    }

    public static final float getCursorHandleHeight() {
        return CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return CursorHandleWidth;
    }

    /* JADX INFO: renamed from: CursorHandle-wy32l68, reason: not valid java name */
    public static final void m1149CursorHandlewy32l68(final long handlePosition, final Modifier modifier, long minTouchTargetSize, Composer $composer, final int $changed, final int i) {
        final long minTouchTargetSize2;
        Object value$iv;
        long minTouchTargetSize3;
        Composer $composer2 = $composer.startRestartGroup(2146386554);
        ComposerKt.sourceInformation($composer2, "C(CursorHandle)P(0:c#ui.geometry.Offset,2,1:c#ui.unit.DpSize)48@1858L18,50@1935L448,47@1818L565:AndroidCursorHandle.android.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(handlePosition) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                minTouchTargetSize2 = minTouchTargetSize;
                int i2 = $composer2.changed(minTouchTargetSize2) ? 256 : 128;
                $dirty |= i2;
            } else {
                minTouchTargetSize2 = minTouchTargetSize;
            }
            $dirty |= i2;
        } else {
            minTouchTargetSize2 = minTouchTargetSize;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            minTouchTargetSize3 = minTouchTargetSize2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
            } else if ((i & 4) != 0) {
                minTouchTargetSize2 = DpSize.INSTANCE.m6908getUnspecifiedMYxV2XQ();
                $dirty &= -897;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2146386554, $dirty, -1, "androidx.compose.foundation.text.CursorHandle (AndroidCursorHandle.android.kt:46)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -155752899, "CC(remember):AndroidCursorHandle.android.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new OffsetProvider() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    /* JADX INFO: renamed from: provide-F1C5BW0, reason: not valid java name */
                    public final long mo1150provideF1C5BW0() {
                        return handlePosition;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidSelectionHandles_androidKt.HandlePopup((OffsetProvider) value$iv, Alignment.INSTANCE.getTopCenter(), ComposableLambdaKt.rememberComposableLambda(119596465, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C:AndroidCursorHandle.android.kt#423gt5");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(119596465, $changed2, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:51)");
                    }
                    long $this$isSpecified$iv = minTouchTargetSize2;
                    if ($this$isSpecified$iv != 9205357640488583168L) {
                        $composer3.startReplaceGroup(1275644007);
                        ComposerKt.sourceInformation($composer3, "52@1995L313");
                        Modifier modifier$iv = SizeKt.m909requiredSizeInqDBjuR0$default(modifier, DpSize.m6899getWidthD9Ej5fM(minTouchTargetSize2), DpSize.m6897getHeightD9Ej5fM(minTouchTargetSize2), 0.0f, 0.0f, 12, null);
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (48 << 3) & 112;
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
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i4 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -709377634, "C59@2273L21:AndroidCursorHandle.android.kt#423gt5");
                        AndroidCursorHandle_androidKt.DefaultCursorHandle(null, $composer3, 0, 1);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(1275644350);
                        ComposerKt.sourceInformation($composer3, "62@2338L29");
                        AndroidCursorHandle_androidKt.DefaultCursorHandle(modifier, $composer3, 0, 0);
                        $composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            minTouchTargetSize3 = minTouchTargetSize2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j = minTouchTargetSize3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    AndroidCursorHandle_androidKt.m1149CursorHandlewy32l68(handlePosition, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultCursorHandle(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(694251107);
        ComposerKt.sourceInformation($composer2, "C(DefaultCursorHandle)70@2491L79:AndroidCursorHandle.android.kt#423gt5");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($dirty & 3) != 2 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(694251107, $dirty, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:69)");
            }
            SpacerKt.Spacer(drawCursorHandle(SizeKt.m915sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight)), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt.DefaultCursorHandle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    AndroidCursorHandle_androidKt.DefaultCursorHandle(modifier, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final Modifier drawCursorHandle(Modifier $this$drawCursorHandle) {
        return ComposedModifierKt.composed$default($this$drawCursorHandle, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt.drawCursorHandle.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                Object value$iv;
                $composer.startReplaceGroup(-2126899193);
                ComposerKt.sourceInformation($composer, "C74@2674L7,76@2740L602:AndroidCursorHandle.android.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2126899193, $changed, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:74)");
                }
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final long handleColor = ((SelectionColors) objConsume).getSelectionHandleColor();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -216257012, "CC(remember):AndroidCursorHandle.android.kt#9igjgp");
                boolean invalid$iv = $composer.changed(handleColor);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                            final float radius = Size.m4118getWidthimpl($this$drawWithCache.m3940getSizeNHjbRc()) / 2.0f;
                            final ImageBitmap imageBitmap = AndroidSelectionHandles_androidKt.createHandleImage($this$drawWithCache, radius);
                            final ColorFilter colorFilter = ColorFilter.Companion.m4332tintxETnrds$default(ColorFilter.INSTANCE, handleColor, 0, 2, null);
                            return $this$drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) throws Throwable {
                                    invoke2(contentDrawScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ContentDrawScope $this$onDrawWithContent) throws Throwable {
                                    long previousSize$iv;
                                    $this$onDrawWithContent.drawContent();
                                    ContentDrawScope $this$withTransform$iv = $this$onDrawWithContent;
                                    float f = radius;
                                    ImageBitmap imageBitmap2 = imageBitmap;
                                    ColorFilter colorFilter2 = colorFilter;
                                    DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
                                    long previousSize$iv2 = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
                                    $this$withTransform_u24lambda_u246$iv.getCanvas().save();
                                    try {
                                        DrawTransform $this$invoke_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
                                        DrawTransform.CC.translate$default($this$invoke_u24lambda_u240, f, 0.0f, 2, null);
                                        $this$invoke_u24lambda_u240.mo4785rotateUv8p0NA(45.0f, Offset.INSTANCE.m4065getZeroF1C5BW0());
                                        try {
                                            DrawScope.CC.m4848drawImagegbVJVH8$default($this$withTransform$iv, imageBitmap2, 0L, 0.0f, null, colorFilter2, 0, 46, null);
                                            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                                            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv2);
                                        } catch (Throwable th) {
                                            th = th;
                                            previousSize$iv = previousSize$iv2;
                                            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                                            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        previousSize$iv = previousSize$iv2;
                                    }
                                }
                            });
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifierThen = $this$composed.then(DrawModifierKt.drawWithCache(companion, (Function1) value$iv));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return modifierThen;
            }
        }, 1, null);
    }
}
