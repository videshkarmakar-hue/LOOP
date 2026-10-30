package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.semantics.SemanticsPropertyKey;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Magnifier.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001\u001a\u0094\u0001\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u001b\b\u0002\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a¬\u0001\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u001b\b\u0002\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\" \u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m195d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "isPlatformMagnifierSupported", "", "sdkVersion", "", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Magnifier_androidKt {
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", null, 2, null);

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    /* JADX INFO: renamed from: magnifier-UpNRX3w, reason: not valid java name */
    public static final Modifier m521magnifierUpNRX3w(Modifier $this$magnifier_u2dUpNRX3w, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function2, Function1<? super DpSize, Unit> function3, float zoom, long size, float cornerRadius, float elevation, boolean clip) {
        return m524magnifierjPUL71Q$default($this$magnifier_u2dUpNRX3w, function1, function2, function3, zoom, false, size, cornerRadius, elevation, clip, null, 512, null);
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static /* synthetic */ Modifier m524magnifierjPUL71Q$default(Modifier modifier, Function1 function1, Function1 function2, Function1 function3, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, Object obj) {
        return m523magnifierjPUL71Q(modifier, function1, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? Float.NaN : f, (i & 16) != 0 ? false : z, (i & 32) != 0 ? DpSize.INSTANCE.m6908getUnspecifiedMYxV2XQ() : j, (i & 64) != 0 ? C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM() : f2, (i & 128) != 0 ? C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM() : f3, (i & 256) != 0 ? true : z2, (i & 512) == 0 ? platformMagnifierFactory : null);
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m523magnifierjPUL71Q(Modifier $this$magnifier_u2djPUL71Q, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function2, Function1<? super DpSize, Unit> function3, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, PlatformMagnifierFactory platformMagnifierFactory) {
        PlatformMagnifierFactory forCurrentPlatform;
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            if (platformMagnifierFactory != null) {
                forCurrentPlatform = platformMagnifierFactory;
            } else {
                forCurrentPlatform = PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform();
            }
            return $this$magnifier_u2djPUL71Q.then(new MagnifierElement(function1, function2, function3, zoom, useTextDefault, size, cornerRadius, elevation, clippingEnabled, forCurrentPlatform, null));
        }
        return $this$magnifier_u2djPUL71Q;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    public static final boolean isPlatformMagnifierSupported(int sdkVersion) {
        return sdkVersion >= 28;
    }
}
