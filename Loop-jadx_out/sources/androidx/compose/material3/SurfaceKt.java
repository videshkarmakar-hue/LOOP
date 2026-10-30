package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.RectangleShapeKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0091\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001am\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0099\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u009f\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a\"\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a8\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020+H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, m195d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<C1979Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0<C1979Dp>() { // from class: androidx.compose.material3.SurfaceKt$LocalAbsoluteTonalElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ C1979Dp invoke() {
            return C1979Dp.m6799boximpl(m2674invokeD9Ej5fM());
        }

        /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m2674invokeD9Ej5fM() {
            return C1979Dp.m6801constructorimpl(0);
        }
    }, 1, null);

    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m2666SurfaceT9BRK9s(Modifier modifier, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -513881741, "C(Surface)P(4,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)102@5105L11,103@5152L22,*109@5369L7,113@5542L723,110@5398L867:Surface.kt#uh7d8r");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        Shape shape2 = (i & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 8) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(color2, $composer, ($changed >> 6) & 14) : contentColor;
        float tonalElevation2 = (i & 16) != 0 ? C1979Dp.m6801constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 32) != 0 ? C1979Dp.m6801constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 64) != 0 ? null : border;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, $changed, -1, "androidx.compose.material3.Surface (Surface.kt:108)");
        }
        ProvidableCompositionLocal<C1979Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final float arg0$iv = C1979Dp.m6801constructorimpl(((C1979Dp) objConsume).m6815unboximpl() + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final float f = shadowElevation2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(C1979Dp.m6799boximpl(arg0$iv))}, ComposableLambdaKt.rememberComposableLambda(-70914509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1
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

            public final void invoke(Composer $composer2, int $changed2) {
                Function0<ComposeUiNode> function0;
                ComposerKt.sourceInformation($composer2, "C118@5688L139,*123@5922L7,114@5552L707:Surface.kt#uh7d8r");
                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-70914509, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:114)");
                    }
                    Modifier modifier4 = modifier3;
                    Shape shape4 = shape3;
                    long jM2673surfaceColorAtElevationCLU3JFs = SurfaceKt.m2673surfaceColorAtElevationCLU3JFs(j, arg0$iv, $composer2, 0);
                    BorderStroke borderStroke2 = borderStroke;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density $this$invoke_u24lambda_u240 = (Density) objConsume2;
                    Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(SurfaceKt.m2672surfaceXOJAsU(modifier4, shape4, jM2673surfaceColorAtElevationCLU3JFs, borderStroke2, $this$invoke_u24lambda_u240.mo567toPx0680j_4(f)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                            SemanticsPropertiesKt.setContainer($this$semantics, true);
                        }
                    }), Unit.INSTANCE, new C15353(null));
                    Function2<Composer, Integer, Unit> function3 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
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
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i3 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301758728, "C132@6240L9:Surface.kt#uh7d8r");
                    function3.invoke($composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }

            /* JADX INFO: renamed from: androidx.compose.material3.SurfaceKt$Surface$1$3 */
            /* JADX INFO: compiled from: Surface.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.material3.SurfaceKt$Surface$1$3", m210f = "Surface.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C15353 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                C15353(Continuation<? super C15353> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C15353(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C15353) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }, $composer, 54), $composer, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX INFO: renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m2669Surfaceo_FOJdg(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -789752804, "C(Surface)P(7,6,4,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp!1,5)207@10552L11,208@10599L22,*215@10873L7,219@11046L827,216@10902L971:Surface.kt#uh7d8r");
        Modifier.Companion modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 4) != 0 ? true : enabled;
        Shape shape2 = (i & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 32) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(color2, $composer, ($changed >> 12) & 14) : contentColor;
        float tonalElevation2 = (i & 64) != 0 ? C1979Dp.m6801constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 128) != 0 ? C1979Dp.m6801constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 256) != 0 ? null : border;
        MutableInteractionSource interactionSource2 = (i & 512) != 0 ? null : interactionSource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:214)");
        }
        ProvidableCompositionLocal<C1979Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
        final float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final boolean z = enabled2;
        final float f = shadowElevation2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(C1979Dp.m6799boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(1279702876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$2
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

            public final void invoke(Composer $composer2, int $changed2) {
                Function0<ComposeUiNode> function1;
                ComposerKt.sourceInformation($composer2, "C225@11243L139,*230@11477L7,234@11651L32,220@11056L811:Surface.kt#uh7d8r");
                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1279702876, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:220)");
                    }
                    Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    Shape shape4 = shape3;
                    long jM2673surfaceColorAtElevationCLU3JFs = SurfaceKt.m2673surfaceColorAtElevationCLU3JFs(j, absoluteElevation, $composer2, 0);
                    BorderStroke borderStroke2 = borderStroke;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density $this$invoke_u24lambda_u240 = (Density) objConsume2;
                    Modifier modifier$iv = ClickableKt.m484clickableO2vRcR0(SurfaceKt.m2672surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape4, jM2673surfaceColorAtElevationCLU3JFs, borderStroke2, $this$invoke_u24lambda_u240.mo567toPx0680j_4(f)), mutableInteractionSource, RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7), (8 & 4) != 0 ? true : z, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, function0);
                    Function2<Composer, Integer, Unit> function3 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        function1 = constructor;
                        $composer2.createNode(function1);
                    } else {
                        function1 = constructor;
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
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i3 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301753120, "C240@11848L9:Surface.kt#uh7d8r");
                    function3.invoke($composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }
        }, $composer, 54), $composer, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m2667Surfaced85dljk(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 540296512, "C(Surface)P(8,7,6,4,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,5)316@16105L11,317@16152L22,*324@16426L7,328@16599L869,325@16455L1013:Surface.kt#uh7d8r");
        Modifier.Companion modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 8) != 0 ? true : enabled;
        Shape shape2 = (i & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 64) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(color2, $composer, ($changed >> 15) & 14) : contentColor;
        float tonalElevation2 = (i & 128) != 0 ? C1979Dp.m6801constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 256) != 0 ? C1979Dp.m6801constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 512) != 0 ? null : border;
        MutableInteractionSource interactionSource2 = (i & 1024) != 0 ? null : interactionSource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:323)");
        }
        ProvidableCompositionLocal<C1979Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
        final float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final boolean z = enabled2;
        final float f = shadowElevation2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(C1979Dp.m6799boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(-1164547968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$3
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

            public final void invoke(Composer $composer2, int $changed2) {
                Function0<ComposeUiNode> function1;
                ComposerKt.sourceInformation($composer2, "C334@16796L139,*339@17030L7,344@17246L32,329@16609L853:Surface.kt#uh7d8r");
                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164547968, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:329)");
                    }
                    Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    Shape shape4 = shape3;
                    long jM2673surfaceColorAtElevationCLU3JFs = SurfaceKt.m2673surfaceColorAtElevationCLU3JFs(j, absoluteElevation, $composer2, 0);
                    BorderStroke borderStroke2 = borderStroke;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density $this$invoke_u24lambda_u240 = (Density) objConsume2;
                    Modifier modifier$iv = SelectableKt.m1115selectableO2vRcR0$default(SurfaceKt.m2672surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape4, jM2673surfaceColorAtElevationCLU3JFs, borderStroke2, $this$invoke_u24lambda_u240.mo567toPx0680j_4(f)), selected, mutableInteractionSource, RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7), z, null, function0, 16, null);
                    Function2<Composer, Integer, Unit> function3 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        function1 = constructor;
                        $composer2.createNode(function1);
                    } else {
                        function1 = constructor;
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
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i3 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301747525, "C350@17443L9:Surface.kt#uh7d8r");
                    function3.invoke($composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }
        }, $composer, 54), $composer, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m2668Surfaced85dljk(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1877401889, "C(Surface)P(1,8,7,5,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,6)426@21768L11,427@21815L22,*434@22089L7,438@22262L879,435@22118L1023:Surface.kt#uh7d8r");
        Modifier.Companion modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 8) != 0 ? true : enabled;
        Shape shape2 = (i & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 64) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(color2, $composer, ($changed >> 15) & 14) : contentColor;
        float tonalElevation2 = (i & 128) != 0 ? C1979Dp.m6801constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 256) != 0 ? C1979Dp.m6801constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 512) != 0 ? null : border;
        MutableInteractionSource interactionSource2 = (i & 1024) != 0 ? null : interactionSource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877401889, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:433)");
        }
        ProvidableCompositionLocal<C1979Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
        final float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final boolean z = enabled2;
        final float f = shadowElevation2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(C1979Dp.m6799boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(712720927, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$4
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

            public final void invoke(Composer $composer2, int $changed2) {
                Function0<ComposeUiNode> function0;
                ComposerKt.sourceInformation($composer2, "C444@22459L139,*449@22693L7,454@22905L32,439@22272L863:Surface.kt#uh7d8r");
                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(712720927, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:439)");
                    }
                    Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                    Shape shape4 = shape3;
                    long jM2673surfaceColorAtElevationCLU3JFs = SurfaceKt.m2673surfaceColorAtElevationCLU3JFs(j, absoluteElevation, $composer2, 0);
                    BorderStroke borderStroke2 = borderStroke;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density $this$invoke_u24lambda_u240 = (Density) objConsume2;
                    Modifier modifier$iv = ToggleableKt.m1120toggleableO2vRcR0$default(SurfaceKt.m2672surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape4, jM2673surfaceColorAtElevationCLU3JFs, borderStroke2, $this$invoke_u24lambda_u240.mo567toPx0680j_4(f)), checked, mutableInteractionSource, RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7), z, null, function1, 16, null);
                    Function2<Composer, Integer, Unit> function3 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
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
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i3 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301741852, "C460@23116L9:Surface.kt#uh7d8r");
                    function3.invoke($composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }
        }, $composer, 54), $composer, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-XO-JAsU, reason: not valid java name */
    public static final Modifier m2672surfaceXOJAsU(Modifier $this$surface_u2dXO_u2dJAsU, Shape shape, long backgroundColor, BorderStroke border, float shadowElevation) {
        Shape shape2;
        Modifier.Companion companionBorder;
        Modifier modifierM4452graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default($this$surface_u2dXO_u2dJAsU, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, shadowElevation, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape, false, null, 0L, 0L, 0, 124895, null);
        if (border != null) {
            shape2 = shape;
            companionBorder = BorderKt.border(Modifier.INSTANCE, border, shape2);
        } else {
            shape2 = shape;
            companionBorder = Modifier.INSTANCE;
        }
        return ClipKt.clip(BackgroundKt.m453backgroundbw27NRU(modifierM4452graphicsLayerAp8cVGQ$default.then(companionBorder), backgroundColor, shape2), shape2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m2673surfaceColorAtElevationCLU3JFs(long color, float elevation, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -2079918090, "C(surfaceColorAtElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)479@23630L11,479@23642L37:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, $changed, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:479)");
        }
        long jM2080applyTonalElevationRFCenO8 = ColorSchemeKt.m2080applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme($composer, 6), color, elevation, $composer, (($changed << 3) & 112) | (($changed << 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return jM2080applyTonalElevationRFCenO8;
    }

    public static final ProvidableCompositionLocal<C1979Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }
}
