package androidx.compose.foundation;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.p001ui.graphics.Matrix;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AndroidExternalSurface.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a]\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m195d2 = {"AndroidEmbeddedExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "transform", "Landroidx/compose/ui/graphics/Matrix;", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AndroidExternalSurface", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidExternalSurface_androidKt {
    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -873615933, "C(rememberAndroidExternalSurfaceState)190@7150L24,191@7186L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, $changed, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:189)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, -723523240, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CoroutineScope scope = wrapper$iv.getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -905839205, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new AndroidExternalSurfaceState(scope);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return androidExternalSurfaceState;
    }

    /* JADX INFO: renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    public static final void m452AndroidExternalSurface58FFMhA(Modifier modifier, boolean isOpaque, long surfaceSize, int zOrder, boolean isSecure, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean isOpaque2;
        long surfaceSize2;
        int zOrder2;
        boolean z;
        int $dirty;
        boolean isSecure2;
        int zOrder3;
        Modifier modifier3;
        long surfaceSize3;
        boolean isOpaque3;
        Object value$iv;
        Object value$iv2;
        int zOrder4;
        long surfaceSize4;
        boolean isOpaque4;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(640888974);
        ComposerKt.sourceInformation($composer2, "C(AndroidExternalSurface)P(2!1,4:c#ui.unit.IntSize,5:c#foundation.AndroidExternalSurfaceZOrder)288@12167L37,291@12241L150,299@12462L774,290@12210L1032:AndroidExternalSurface.android.kt#71ulvw");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            isOpaque2 = isOpaque;
        } else if (($changed & 48) == 0) {
            isOpaque2 = isOpaque;
            $dirty2 |= $composer2.changed(isOpaque2) ? 32 : 16;
        } else {
            isOpaque2 = isOpaque;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                surfaceSize2 = surfaceSize;
                int i4 = $composer2.changed(surfaceSize2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                surfaceSize2 = surfaceSize;
            }
            $dirty2 |= i4;
        } else {
            surfaceSize2 = surfaceSize;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            zOrder2 = zOrder;
        } else if (($changed & 3072) == 0) {
            zOrder2 = zOrder;
            $dirty2 |= $composer2.changed(zOrder2) ? 2048 : 1024;
        } else {
            zOrder2 = zOrder;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            z = isSecure;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            z = isSecure;
            $dirty2 |= $composer2.changed(z) ? 16384 : 8192;
        } else {
            z = isSecure;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 131072 : 65536;
        }
        if (($dirty2 & 74899) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            isSecure2 = z;
            zOrder4 = zOrder2;
            surfaceSize4 = surfaceSize2;
            modifier4 = modifier2;
            isOpaque4 = isOpaque2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    isOpaque2 = true;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    surfaceSize2 = IntSize.INSTANCE.m6980getZeroYbymL2g();
                }
                if (i5 != 0) {
                    zOrder2 = AndroidExternalSurfaceZOrder.INSTANCE.m448getBehindB_4ceCc();
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    isSecure2 = false;
                    zOrder3 = zOrder2;
                    surfaceSize3 = surfaceSize2;
                    isOpaque3 = isOpaque2;
                } else {
                    $dirty = $dirty2;
                    isSecure2 = z;
                    zOrder3 = zOrder2;
                    modifier3 = modifier5;
                    surfaceSize3 = surfaceSize2;
                    isOpaque3 = isOpaque2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                isSecure2 = z;
                zOrder3 = zOrder2;
                modifier3 = modifier2;
                surfaceSize3 = surfaceSize2;
                isOpaque3 = isOpaque2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(640888974, $dirty, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:287)");
            }
            final AndroidExternalSurfaceState state = rememberAndroidExternalSurfaceState($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341727460, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            boolean invalid$iv = ((458752 & $dirty) == 131072) | $composer2.changedInstance(state);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1<Context, SurfaceView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final SurfaceView invoke(Context context) {
                        SurfaceView $this$invoke_u24lambda_u240 = new SurfaceView(context);
                        Function1<AndroidExternalSurfaceScope, Unit> function2 = function1;
                        AndroidExternalSurfaceState androidExternalSurfaceState = state;
                        function2.invoke(androidExternalSurfaceState);
                        $this$invoke_u24lambda_u240.getHolder().addCallback(androidExternalSurfaceState);
                        return $this$invoke_u24lambda_u240;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            Function1 function2 = (Function1) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidExternalSurface_androidKt$AndroidExternalSurface$2 androidExternalSurface_androidKt$AndroidExternalSurface$2 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                    invoke2(surfaceView);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SurfaceView it) {
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 1341727681, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            boolean invalid$iv2 = (((($dirty & 896) ^ 384) > 256 && $composer2.changed(surfaceSize3)) || ($dirty & 384) == 256) | (($dirty & 112) == 32) | (($dirty & 7168) == 2048) | ((57344 & $dirty) == 16384);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                final long j = surfaceSize3;
                final boolean z2 = isOpaque3;
                final int i7 = zOrder3;
                final boolean z3 = isSecure2;
                value$iv2 = new Function1<SurfaceView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SurfaceView surfaceView) {
                        invoke2(surfaceView);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SurfaceView view) {
                        int i8;
                        if (!IntSize.m6973equalsimpl0(j, IntSize.INSTANCE.m6980getZeroYbymL2g())) {
                            view.getHolder().setFixedSize(IntSize.m6975getWidthimpl(j), IntSize.m6974getHeightimpl(j));
                        } else {
                            view.getHolder().setSizeFromLayout();
                        }
                        SurfaceHolder holder = view.getHolder();
                        if (z2) {
                            i8 = -1;
                        } else {
                            i8 = -3;
                        }
                        holder.setFormat(i8);
                        int i9 = i7;
                        if (AndroidExternalSurfaceZOrder.m444equalsimpl0(i9, AndroidExternalSurfaceZOrder.INSTANCE.m448getBehindB_4ceCc())) {
                            view.setZOrderOnTop(false);
                        } else if (AndroidExternalSurfaceZOrder.m444equalsimpl0(i9, AndroidExternalSurfaceZOrder.INSTANCE.m449getMediaOverlayB_4ceCc())) {
                            view.setZOrderMediaOverlay(true);
                        } else if (AndroidExternalSurfaceZOrder.m444equalsimpl0(i9, AndroidExternalSurfaceZOrder.INSTANCE.m450getOnTopB_4ceCc())) {
                            view.setZOrderOnTop(true);
                        }
                        view.setSecure(z3);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidView_androidKt.AndroidView(function2, modifier3, androidExternalSurface_androidKt$AndroidExternalSurface$2, null, (Function1) value$iv2, $composer2, (($dirty << 3) & 112) | 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            zOrder4 = zOrder3;
            surfaceSize4 = surfaceSize3;
            isOpaque4 = isOpaque3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z4 = isOpaque4;
            final long j2 = surfaceSize4;
            final int i8 = zOrder4;
            final boolean z5 = isSecure2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidExternalSurface$4
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
                    AndroidExternalSurface_androidKt.m452AndroidExternalSurface58FFMhA(modifier6, z4, j2, i8, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1057437053, "C(rememberAndroidEmbeddedExternalSurfaceState)384@15036L24,385@15072L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, $changed, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:383)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, -723523240, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CoroutineScope scope = wrapper$iv.getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1006679039, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new AndroidEmbeddedExternalSurfaceState(scope);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return androidEmbeddedExternalSurfaceState;
    }

    /* JADX INFO: renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    public static final void m451AndroidEmbeddedExternalSurfacesv6N_fY(Modifier modifier, boolean isOpaque, long surfaceSize, float[] transform, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        long surfaceSize2;
        float[] transform2;
        int $dirty;
        final long surfaceSize3;
        Modifier modifier3;
        boolean isOpaque2;
        Composer $composer2 = $composer.startRestartGroup(217541314);
        ComposerKt.sourceInformation($composer2, "C(AndroidEmbeddedExternalSurface)P(1!1,3:c#ui.unit.IntSize,4:c#ui.graphics.Matrix)455@18917L45,458@18999L203,467@19273L485,457@18968L796:AndroidExternalSurface.android.kt#71ulvw");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            z = isOpaque;
        } else if (($changed & 48) == 0) {
            z = isOpaque;
            $dirty2 |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = isOpaque;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                surfaceSize2 = surfaceSize;
                int i4 = $composer2.changed(surfaceSize2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                surfaceSize2 = surfaceSize;
            }
            $dirty2 |= i4;
        } else {
            surfaceSize2 = surfaceSize;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(transform != null ? Matrix.m4527boximpl(transform) : null) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            transform2 = transform;
            surfaceSize3 = surfaceSize2;
            modifier3 = modifier2;
            isOpaque2 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean isOpaque3 = i3 != 0 ? true : z;
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    surfaceSize2 = IntSize.INSTANCE.m6980getZeroYbymL2g();
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    transform2 = null;
                    surfaceSize3 = surfaceSize2;
                    modifier3 = modifier4;
                    isOpaque2 = isOpaque3;
                } else {
                    transform2 = transform;
                    $dirty = $dirty2;
                    surfaceSize3 = surfaceSize2;
                    modifier3 = modifier4;
                    isOpaque2 = isOpaque3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                transform2 = transform;
                $dirty = $dirty2;
                long j = surfaceSize2;
                modifier3 = modifier2;
                isOpaque2 = z;
                surfaceSize3 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(217541314, $dirty, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:454)");
            }
            final AndroidEmbeddedExternalSurfaceState state = rememberAndroidEmbeddedExternalSurfaceState($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -686800140, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(state) | (((($dirty & 896) ^ 384) > 256 && $composer2.changed(surfaceSize3)) || ($dirty & 384) == 256) | ((57344 & $dirty) == 16384);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<Context, TextureView>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TextureView invoke(Context context) {
                        TextureView $this$invoke_u24lambda_u240 = new TextureView(context);
                        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = state;
                        long j2 = surfaceSize3;
                        Function1<AndroidExternalSurfaceScope, Unit> function2 = function1;
                        androidEmbeddedExternalSurfaceState.m440setSurfaceSizeozmzZPI(j2);
                        function2.invoke(androidEmbeddedExternalSurfaceState);
                        $this$invoke_u24lambda_u240.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
                        return $this$invoke_u24lambda_u240;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            }
            Function1 function2 = (Function1) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            C0281x1320780f c0281x1320780f = new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                    invoke2(textureView);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextureView it) {
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -686799866, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            boolean invalid$iv2 = (((($dirty & 896) ^ 384) > 256 && $composer2.changed(surfaceSize3)) || ($dirty & 384) == 256) | $composer2.changedInstance(state) | (($dirty & 112) == 32) | $composer2.changedInstance(transform2 != null ? Matrix.m4527boximpl(transform2) : null);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.INSTANCE.getEmpty()) {
                final long j2 = surfaceSize3;
                final boolean z2 = isOpaque2;
                final float[] fArr = transform2;
                value$iv2 = new Function1<TextureView, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextureView textureView) {
                        invoke2(textureView);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextureView view) {
                        android.graphics.Matrix $this$invoke_u24lambda_u241_u24lambda_u240;
                        SurfaceTexture surfaceTexture;
                        if (!IntSize.m6973equalsimpl0(j2, IntSize.INSTANCE.m6980getZeroYbymL2g()) && (surfaceTexture = view.getSurfaceTexture()) != null) {
                            surfaceTexture.setDefaultBufferSize(IntSize.m6975getWidthimpl(j2), IntSize.m6974getHeightimpl(j2));
                        }
                        state.m440setSurfaceSizeozmzZPI(j2);
                        view.setOpaque(z2);
                        if (fArr != null) {
                            AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = state;
                            float[] fArr2 = fArr;
                            $this$invoke_u24lambda_u241_u24lambda_u240 = androidEmbeddedExternalSurfaceState.getMatrix();
                            AndroidMatrixConversions_androidKt.m4161setFromEL8BTi8($this$invoke_u24lambda_u241_u24lambda_u240, fArr2);
                        } else {
                            $this$invoke_u24lambda_u241_u24lambda_u240 = null;
                        }
                        view.setTransform($this$invoke_u24lambda_u241_u24lambda_u240);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidView_androidKt.AndroidView(function2, modifier3, c0281x1320780f, null, (Function1) value$iv2, $composer2, (($dirty << 3) & 112) | 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = isOpaque2;
            final long j3 = surfaceSize3;
            final float[] fArr2 = transform2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$AndroidEmbeddedExternalSurface$4
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

                public final void invoke(Composer composer, int i6) {
                    AndroidExternalSurface_androidKt.m451AndroidEmbeddedExternalSurfacesv6N_fY(modifier5, z3, j3, fArr2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
