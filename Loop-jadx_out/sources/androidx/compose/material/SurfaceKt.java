package androidx.compose.material;

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
import androidx.compose.p001ui.draw.ShadowKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.RectangleShapeKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
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
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001ac\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00072\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001f\u001a,\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a8\u0010&\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m195d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SurfaceKt {
    /* JADX INFO: renamed from: Surface-F-jzlyU, reason: not valid java name */
    public static final void m1809SurfaceFjzlyU(Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        float elevation3;
        Shape shape3;
        long color3;
        long contentColor3;
        BorderStroke border3;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1412203386);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)103@5115L6,104@5157L22,*109@5332L7,113@5495L755,110@5356L894:Surface.kt#jmzs0o");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            shape2 = shape;
        } else if (($changed & 48) == 0) {
            shape2 = shape;
            $dirty |= $composer2.changed(shape2) ? 32 : 16;
        } else {
            shape2 = shape;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                int i4 = $composer2.changed(color2) ? 256 : 128;
                $dirty |= i4;
            } else {
                color2 = color;
            }
            $dirty |= i4;
        } else {
            color2 = color;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            border2 = border;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            border2 = border;
            $dirty |= $composer2.changed(border2) ? 16384 : 8192;
        } else {
            border2 = border;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(elevation) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            elevation3 = elevation;
            shape3 = shape2;
            color3 = color2;
            contentColor3 = contentColor2;
            border3 = border2;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                }
                if ((i & 8) != 0) {
                    long contentColor4 = ColorsKt.m1645contentColorForek8zF_U(color2, $composer2, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                    contentColor2 = contentColor4;
                }
                if (i6 != 0) {
                    border2 = null;
                }
                elevation2 = i7 != 0 ? C1979Dp.m6801constructorimpl(0) : elevation;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    elevation2 = elevation;
                } else {
                    elevation2 = elevation;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412203386, $dirty, -1, "androidx.compose.material.Surface (Surface.kt:108)");
            }
            ProvidableCompositionLocal<C1979Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
            final float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + elevation2);
            final Modifier modifier4 = modifier2;
            final Shape shape4 = shape2;
            final long j = color2;
            final BorderStroke borderStroke = border2;
            final float f = elevation2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1979Dp.m6799boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(-1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C120@5770L7,118@5641L221,114@5505L739:Surface.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1822160838, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:114)");
                        }
                        Modifier modifier5 = modifier4;
                        Shape shape5 = shape4;
                        long j2 = j;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer3.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(SurfaceKt.m1815surface8ww4TTg(modifier5, shape5, SurfaceKt.m1816surfaceColorAtElevationcq6XJ1M(j2, (ElevationOverlay) objConsume2, absoluteElevation, $composer3, 0), borderStroke, f), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                SemanticsPropertiesKt.setContainer($this$semantics, true);
                            }
                        }), Unit.INSTANCE, new C11172(null));
                        Function2<Composer, Integer, Unit> function3 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                        int $changed$iv$iv = (384 << 3) & 112;
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
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i9 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1505969900, "C133@6225L9:Surface.kt#jmzs0o");
                        function3.invoke($composer3, 0);
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

                /* JADX INFO: renamed from: androidx.compose.material.SurfaceKt$Surface$1$2 */
                /* JADX INFO: compiled from: Surface.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.material.SurfaceKt$Surface$1$2", m210f = "Surface.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class C11172 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                    int label;

                    C11172(Continuation<? super C11172> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C11172(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return ((C11172) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            elevation3 = elevation2;
            shape3 = shape2;
            color3 = color2;
            contentColor3 = contentColor2;
            border3 = border2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Shape shape5 = shape3;
            final long j2 = color3;
            final long j3 = contentColor3;
            final BorderStroke borderStroke2 = border3;
            final float f2 = elevation3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$2
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
                    SurfaceKt.m1809SurfaceFjzlyU(modifier5, shape5, j2, j3, borderStroke2, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Surface-LPr_se0, reason: not valid java name */
    public static final void m1810SurfaceLPr_se0(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        long j;
        Modifier.Companion modifier2;
        boolean enabled2;
        Shape shape3;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        int $dirty;
        MutableInteractionSource interactionSource2;
        float elevation3;
        MutableInteractionSource interactionSource3;
        Modifier modifier3;
        boolean enabled3;
        Shape shape4;
        BorderStroke border3;
        long color3;
        long contentColor3;
        Composer $composer2 = $composer.startRestartGroup(1560876237);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)212@10592L6,213@10634L22,*219@10866L7,223@11029L859,220@10890L998:Surface.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            shape2 = shape;
        } else if (($changed & 3072) == 0) {
            shape2 = shape;
            $dirty2 |= $composer2.changed(shape2) ? 2048 : 1024;
        } else {
            shape2 = shape;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                j = color;
                int i5 = $composer2.changed(j) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                j = color;
            }
            $dirty2 |= i5;
        } else {
            j = color;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(contentColor)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(border) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(elevation) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            contentColor3 = contentColor;
            border3 = border;
            elevation3 = elevation;
            interactionSource3 = interactionSource;
            shape4 = shape2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                shape3 = i4 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                if ((i & 16) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                    $dirty2 &= -57345;
                } else {
                    color2 = j;
                }
                if ((i & 32) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(color2, $composer2, ($dirty2 >> 12) & 14);
                    $dirty2 &= -458753;
                } else {
                    contentColor2 = contentColor;
                }
                border2 = i6 != 0 ? null : border;
                elevation2 = i7 != 0 ? C1979Dp.m6801constructorimpl(0) : elevation;
                if (i8 != 0) {
                    interactionSource2 = null;
                    $dirty = $dirty2;
                } else {
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    int i9 = $dirty2 & (-458753);
                    modifier2 = modifier;
                    enabled2 = enabled;
                    border2 = border;
                    interactionSource2 = interactionSource;
                    $dirty = i9;
                    shape3 = shape2;
                    color2 = j;
                    contentColor2 = contentColor;
                    elevation2 = elevation;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    border2 = border;
                    elevation2 = elevation;
                    $dirty = $dirty2;
                    shape3 = shape2;
                    color2 = j;
                    contentColor2 = contentColor;
                    interactionSource2 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560876237, $dirty, -1, "androidx.compose.material.Surface (Surface.kt:218)");
            }
            ProvidableCompositionLocal<C1979Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
            final float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + elevation2);
            final Modifier modifier4 = modifier2;
            final Shape shape5 = shape3;
            final long j2 = color2;
            final BorderStroke borderStroke = border2;
            final float f = elevation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z = enabled2;
            float elevation4 = elevation2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1979Dp.m6799boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$3
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
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C231@11355L7,229@11226L221,239@11666L32,224@11039L843:Surface.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2031491085, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                        }
                        Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier4);
                        Shape shape6 = shape5;
                        long j3 = j2;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer3.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = ClickableKt.m484clickableO2vRcR0(SurfaceKt.m1815surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape6, SurfaceKt.m1816surfaceColorAtElevationcq6XJ1M(j3, (ElevationOverlay) objConsume2, absoluteElevation, $composer3, 0), borderStroke, f), mutableInteractionSource, RippleKt.m1779rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer3, 0, 7), (8 & 4) != 0 ? true : z, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, function0);
                        Function2<Composer, Integer, Unit> function3 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                        int $changed$iv$iv = (384 << 3) & 112;
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
                            function1 = constructor;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor;
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
                        int i10 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i11 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1505975538, "C245@11863L9:Surface.kt#jmzs0o");
                        function3.invoke($composer3, 0);
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
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            elevation3 = elevation4;
            interactionSource3 = interactionSource2;
            modifier3 = modifier2;
            enabled3 = enabled2;
            shape4 = shape3;
            border3 = border2;
            color3 = color2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled3;
            final Shape shape6 = shape4;
            final long j3 = color3;
            final long j4 = contentColor3;
            final BorderStroke borderStroke2 = border3;
            final float f2 = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
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

                public final void invoke(Composer composer, int i10) {
                    SurfaceKt.m1810SurfaceLPr_se0(function0, modifier5, z2, shape6, j3, j4, borderStroke2, f2, mutableInteractionSource2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1811SurfaceNy5ogXk(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Shape shape2;
        int $dirty;
        Modifier.Companion modifier2;
        boolean enabled2;
        Shape shape3;
        long color2;
        long contentColor2;
        MutableInteractionSource interactionSource2;
        BorderStroke border2;
        float elevation2;
        int $dirty2;
        long contentColor3;
        long contentColor4;
        Modifier modifier3;
        boolean enabled3;
        BorderStroke border3;
        float elevation3;
        Shape shape4;
        long color3;
        MutableInteractionSource interactionSource3;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(262027249);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)326@16318L6,327@16360L22,*333@16592L7,337@16755L901,334@16616L1040:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty4 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            shape2 = shape;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            shape2 = shape;
            $dirty4 |= $composer2.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer2.changed(color)) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                int i5 = $composer2.changed(contentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i5;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i5;
        } else {
            $dirty = $dirty4;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changed(border) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            color3 = color;
            contentColor4 = contentColor;
            border3 = border;
            elevation3 = elevation;
            interactionSource3 = interactionSource;
            shape4 = shape2;
            enabled3 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : z;
                shape3 = i4 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                if ((i & 32) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                    $dirty &= -458753;
                } else {
                    color2 = color;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(color2, $composer2, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i6 != 0 ? null : border;
                float elevation4 = i7 != 0 ? C1979Dp.m6801constructorimpl(0) : elevation;
                if (i8 != 0) {
                    elevation2 = elevation4;
                    interactionSource2 = null;
                    $dirty2 = $dirty;
                    border2 = border4;
                    contentColor3 = contentColor2;
                } else {
                    interactionSource2 = interactionSource;
                    border2 = border4;
                    elevation2 = elevation4;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    border2 = border;
                    elevation2 = elevation;
                    $dirty2 = $dirty & (-3670017);
                    enabled2 = z;
                    shape3 = shape2;
                    color2 = color;
                    contentColor3 = contentColor;
                    interactionSource2 = interactionSource;
                } else {
                    modifier2 = modifier;
                    contentColor3 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    enabled2 = z;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    color2 = color;
                    interactionSource2 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(262027249, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:332)");
            }
            ProvidableCompositionLocal<C1979Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
            final float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + elevation2);
            final Modifier modifier4 = modifier2;
            final Shape shape5 = shape3;
            final long j = color2;
            final BorderStroke borderStroke = border2;
            final float f = elevation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z2 = enabled2;
            long contentColor5 = contentColor3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1979Dp.m6799boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(-1391199439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$5
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
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C345@17081L7,343@16952L221,354@17434L32,338@16765L885:Surface.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1391199439, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:338)");
                        }
                        Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier4);
                        Shape shape6 = shape5;
                        long j2 = j;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer3.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = SelectableKt.m1115selectableO2vRcR0$default(SurfaceKt.m1815surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape6, SurfaceKt.m1816surfaceColorAtElevationcq6XJ1M(j2, (ElevationOverlay) objConsume2, absoluteElevation, $composer3, 0), borderStroke, f), selected, mutableInteractionSource, RippleKt.m1779rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer3, 0, 7), z2, null, function0, 16, null);
                        Function2<Composer, Integer, Unit> function3 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                        int $changed$iv$iv = (384 << 3) & 112;
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
                            function1 = constructor;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor;
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
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i10 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1505981306, "C360@17631L9:Surface.kt#jmzs0o");
                        function3.invoke($composer3, 0);
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
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor4 = contentColor5;
            modifier3 = modifier2;
            enabled3 = enabled2;
            border3 = border2;
            elevation3 = elevation2;
            shape4 = shape3;
            color3 = color2;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = enabled3;
            final Shape shape6 = shape4;
            final long j2 = color3;
            final long j3 = contentColor4;
            final BorderStroke borderStroke2 = border3;
            final float f2 = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$6
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

                public final void invoke(Composer composer, int i9) {
                    SurfaceKt.m1811SurfaceNy5ogXk(selected, function0, modifier5, z3, shape6, j2, j3, borderStroke2, f2, mutableInteractionSource2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1812SurfaceNy5ogXk(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Shape shape2;
        int $dirty;
        Modifier.Companion modifier2;
        boolean enabled2;
        Shape shape3;
        long color2;
        long contentColor2;
        MutableInteractionSource interactionSource2;
        BorderStroke border2;
        float elevation2;
        int $dirty2;
        long contentColor3;
        long contentColor4;
        Modifier modifier3;
        boolean enabled3;
        BorderStroke border3;
        float elevation3;
        Shape shape4;
        long color3;
        MutableInteractionSource interactionSource3;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(1341569296);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)441@22161L6,442@22203L22,*448@22435L7,452@22598L911,449@22459L1050:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty4 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            shape2 = shape;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            shape2 = shape;
            $dirty4 |= $composer2.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer2.changed(color)) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                int i5 = $composer2.changed(contentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i5;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i5;
        } else {
            $dirty = $dirty4;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changed(border) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            color3 = color;
            contentColor4 = contentColor;
            border3 = border;
            elevation3 = elevation;
            interactionSource3 = interactionSource;
            shape4 = shape2;
            enabled3 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : z;
                shape3 = i4 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                if ((i & 32) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                    $dirty &= -458753;
                } else {
                    color2 = color;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(color2, $composer2, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i6 != 0 ? null : border;
                float elevation4 = i7 != 0 ? C1979Dp.m6801constructorimpl(0) : elevation;
                if (i8 != 0) {
                    elevation2 = elevation4;
                    interactionSource2 = null;
                    $dirty2 = $dirty;
                    border2 = border4;
                    contentColor3 = contentColor2;
                } else {
                    interactionSource2 = interactionSource;
                    border2 = border4;
                    elevation2 = elevation4;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    border2 = border;
                    elevation2 = elevation;
                    $dirty2 = $dirty & (-3670017);
                    enabled2 = z;
                    shape3 = shape2;
                    color2 = color;
                    contentColor3 = contentColor;
                    interactionSource2 = interactionSource;
                } else {
                    modifier2 = modifier;
                    contentColor3 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    enabled2 = z;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    color2 = color;
                    interactionSource2 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341569296, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:447)");
            }
            ProvidableCompositionLocal<C1979Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
            final float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + elevation2);
            final Modifier modifier4 = modifier2;
            final Shape shape5 = shape3;
            final long j = color2;
            final BorderStroke borderStroke = border2;
            final float f = elevation2;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z2 = enabled2;
            long contentColor5 = contentColor3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1979Dp.m6799boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(-311657392, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C460@22924L7,458@22795L221,469@23273L32,453@22608L895:Surface.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-311657392, $changed2, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:453)");
                        }
                        Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier4);
                        Shape shape6 = shape5;
                        long j2 = j;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer3.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = ToggleableKt.m1120toggleableO2vRcR0$default(SurfaceKt.m1815surface8ww4TTg(modifierMinimumInteractiveComponentSize, shape6, SurfaceKt.m1816surfaceColorAtElevationcq6XJ1M(j2, (ElevationOverlay) objConsume2, absoluteElevation, $composer3, 0), borderStroke, f), checked, mutableInteractionSource, RippleKt.m1779rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer3, 0, 7), z2, null, function1, 16, null);
                        Function2<Composer, Integer, Unit> function3 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                        int $changed$iv$iv = (384 << 3) & 112;
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
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i10 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1505987159, "C475@23484L9:Surface.kt#jmzs0o");
                        function3.invoke($composer3, 0);
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
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor4 = contentColor5;
            modifier3 = modifier2;
            enabled3 = enabled2;
            border3 = border2;
            elevation3 = elevation2;
            shape4 = shape3;
            color3 = color2;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = enabled3;
            final Shape shape6 = shape4;
            final long j2 = color3;
            final long j3 = contentColor4;
            final BorderStroke borderStroke2 = border3;
            final float f2 = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$8
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

                public final void invoke(Composer composer, int i9) {
                    SurfaceKt.m1812SurfaceNy5ogXk(checked, function1, modifier5, z3, shape6, j2, j3, borderStroke2, f2, mutableInteractionSource2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1815surface8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float elevation) {
        Modifier modifierM3954shadows4CzXII$default = ShadowKt.m3954shadows4CzXII$default($this$surface_u2d8ww4TTg, elevation, shape, false, 0L, 0L, 24, null);
        Modifier.Companion companionBorder = Modifier.INSTANCE;
        if (border != null) {
            companionBorder = BorderKt.border(companionBorder, border, shape);
        }
        return ClipKt.clip(BackgroundKt.m453backgroundbw27NRU(modifierM3954shadows4CzXII$default.then(companionBorder), backgroundColor, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m1816surfaceColorAtElevationcq6XJ1M(long color, ElevationOverlay elevationOverlay, float absoluteElevation, Composer $composer, int $changed) {
        long jMo1669apply7g2Lkgo;
        ComposerKt.sourceInformationMarkerStart($composer, 1561611256, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp):Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, $changed, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:495)");
        }
        $composer.startReplaceGroup(-1227923674);
        ComposerKt.sourceInformation($composer, "496@24015L6,497@24086L31");
        if (Color.m4292equalsimpl0(color, MaterialTheme.INSTANCE.getColors($composer, 6).m1631getSurface0d7_KjU()) && elevationOverlay != null) {
            jMo1669apply7g2Lkgo = elevationOverlay.mo1669apply7g2Lkgo(color, absoluteElevation, $composer, ($changed & 14) | (($changed >> 3) & 112) | (($changed << 3) & 896));
        } else {
            jMo1669apply7g2Lkgo = color;
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return jMo1669apply7g2Lkgo;
    }
}
