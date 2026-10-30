package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u008a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u008e\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u008d\u0001\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a!\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u00020(2\b\b\u0002\u00106\u001a\u00020\u001bH\u0007¢\u0006\u0002\u00107\u001a7\u00108\u001a\u00020(2\b\b\u0002\u00109\u001a\u00020:2\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010<\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010=\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, m195d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-2E65NiM", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BottomSheetScaffoldKt {
    /* JADX INFO: renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    public static final void m1945BottomSheetScaffoldsdMYb0k(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState scaffoldState, float sheetPeekHeight, float sheetMaxWidth, Shape sheetShape, long sheetContainerColor, long sheetContentColor, float sheetTonalElevation, float sheetShadowElevation, Function2<? super Composer, ? super Integer, Unit> function2, boolean sheetSwipeEnabled, Function2<? super Composer, ? super Integer, Unit> function4, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function5, long containerColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function6, Composer $composer, final int $changed, final int $changed1, final int i) {
        BottomSheetScaffoldState scaffoldState2;
        Shape sheetShape2;
        long sheetContainerColor2;
        float sheetMaxWidth2;
        long sheetContentColor2;
        Function2<? super Composer, ? super Integer, Unit> function2M2110getLambda1$material3_release;
        long containerColor2;
        Modifier modifier2;
        int $dirty;
        long contentColor2;
        int $dirty1;
        long containerColor3;
        final BottomSheetScaffoldState scaffoldState3;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        float sheetShadowElevation2;
        boolean sheetSwipeEnabled2;
        float sheetTonalElevation2;
        long sheetContainerColor3;
        final float sheetPeekHeight2;
        Object value$iv;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Modifier modifier3;
        long sheetContainerColor4;
        BottomSheetScaffoldState scaffoldState4;
        float sheetTonalElevation3;
        float sheetShadowElevation3;
        boolean sheetSwipeEnabled3;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function11;
        Shape sheetShape3;
        float sheetMaxWidth3;
        long containerColor4;
        long sheetContentColor3;
        long contentColor3;
        float sheetPeekHeight3;
        Composer $composer2 = $composer.startRestartGroup(-1523924135);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffold)P(6,3,4,10:c#ui.unit.Dp,9:c#ui.unit.Dp,12,5:c#ui.graphics.Color,7:c#ui.graphics.Color,14:c#ui.unit.Dp,11:c#ui.unit.Dp,8,13,16,15,0:c#ui.graphics.Color,2:c#ui.graphics.Color)111@5963L34,114@6165L13,115@6233L14,116@6280L36,123@6712L11,124@6759L31,130@6945L52,138@7320L597,131@7022L69,134@7115L50,127@6849L1074:BottomSheetScaffold.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty3 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ((i & 4) == 0 && $composer2.changed(scaffoldState)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(sheetPeekHeight) ? 2048 : 1024;
        }
        int i4 = i & 16;
        int i5 = 8192;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(sheetMaxWidth) ? 16384 : 8192;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(sheetShape)) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(sheetContainerColor)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(sheetContentColor)) ? 8388608 : 4194304;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(sheetTonalElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changed(sheetShadowElevation) ? 536870912 : 268435456;
        }
        int i8 = i & 1024;
        if (i8 != 0) {
            $dirty3 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i9 = i & 2048;
        if (i9 != 0) {
            $dirty3 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty3 |= $composer2.changed(sheetSwipeEnabled) ? 32 : 16;
        }
        int i10 = i & 4096;
        if (i10 != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? 256 : 128;
        }
        int i11 = i & 8192;
        if (i11 != 0) {
            $dirty3 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty3 |= $composer2.changedInstance(function5) ? 2048 : 1024;
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16384) == 0 && $composer2.changed(containerColor)) {
                i5 = 16384;
            }
            $dirty3 |= i5;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= ((i & 32768) == 0 && $composer2.changed(contentColor)) ? 131072 : 65536;
        }
        if ((i & 65536) != 0) {
            $dirty3 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty3 |= $composer2.changedInstance(function6) ? 1048576 : 524288;
        }
        if (($dirty2 & 306783379) == 306783378 && (599187 & $dirty3) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            scaffoldState4 = scaffoldState;
            sheetPeekHeight3 = sheetPeekHeight;
            sheetMaxWidth3 = sheetMaxWidth;
            sheetShape3 = sheetShape;
            sheetContainerColor4 = sheetContainerColor;
            sheetContentColor3 = sheetContentColor;
            sheetTonalElevation3 = sheetTonalElevation;
            sheetShadowElevation3 = sheetShadowElevation;
            function10 = function2;
            sheetSwipeEnabled3 = sheetSwipeEnabled;
            function9 = function4;
            function11 = function5;
            containerColor4 = containerColor;
            contentColor3 = contentColor;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    scaffoldState2 = rememberBottomSheetScaffoldState(null, null, $composer2, 0, 3);
                    $dirty2 &= -897;
                } else {
                    scaffoldState2 = scaffoldState;
                }
                float sheetPeekHeight4 = i3 != 0 ? BottomSheetDefaults.INSTANCE.m1944getSheetPeekHeightD9Ej5fM() : sheetPeekHeight;
                float sheetMaxWidth4 = i4 != 0 ? BottomSheetDefaults.INSTANCE.m1943getSheetMaxWidthD9Ej5fM() : sheetMaxWidth;
                BottomSheetScaffoldState scaffoldState5 = scaffoldState2;
                if ((i & 32) != 0) {
                    sheetShape2 = BottomSheetDefaults.INSTANCE.getExpandedShape($composer2, 6);
                    $dirty2 &= -458753;
                } else {
                    sheetShape2 = sheetShape;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                    sheetContainerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor($composer2, 6);
                } else {
                    sheetContainerColor2 = sheetContainerColor;
                }
                sheetMaxWidth2 = sheetMaxWidth4;
                if ((i & 128) != 0) {
                    sheetContentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(sheetContainerColor2, $composer2, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                } else {
                    sheetContentColor2 = sheetContentColor;
                }
                float sheetTonalElevation4 = i6 != 0 ? C1979Dp.m6801constructorimpl(0) : sheetTonalElevation;
                float sheetShadowElevation4 = i7 != 0 ? BottomSheetDefaults.INSTANCE.m1942getElevationD9Ej5fM() : sheetShadowElevation;
                function2M2110getLambda1$material3_release = i8 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2110getLambda1$material3_release() : function2;
                boolean sheetSwipeEnabled4 = i9 != 0 ? true : sheetSwipeEnabled;
                Function2<? super Composer, ? super Integer, Unit> function12 = i10 != 0 ? null : function4;
                Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M2111getLambda2$material3_release = i11 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2111getLambda2$material3_release() : function5;
                if ((i & 16384) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, 6).getSurface();
                    $dirty3 &= -57345;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 32768) != 0) {
                    float sheetTonalElevation5 = sheetTonalElevation4;
                    long contentColor4 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty3 >> 12) & 14);
                    int i12 = (-458753) & $dirty3;
                    scaffoldState3 = scaffoldState5;
                    $dirty = $dirty2;
                    $dirty1 = i12;
                    contentColor2 = contentColor4;
                    modifier2 = modifier4;
                    containerColor3 = containerColor2;
                    function7 = function3M2111getLambda2$material3_release;
                    function8 = function12;
                    sheetShadowElevation2 = sheetShadowElevation4;
                    sheetSwipeEnabled2 = sheetSwipeEnabled4;
                    sheetTonalElevation2 = sheetTonalElevation5;
                    sheetContainerColor3 = sheetContainerColor2;
                    sheetPeekHeight2 = sheetPeekHeight4;
                } else {
                    float sheetTonalElevation6 = sheetTonalElevation4;
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    contentColor2 = contentColor;
                    $dirty1 = $dirty3;
                    containerColor3 = containerColor2;
                    scaffoldState3 = scaffoldState5;
                    function7 = function3M2111getLambda2$material3_release;
                    function8 = function12;
                    sheetShadowElevation2 = sheetShadowElevation4;
                    sheetSwipeEnabled2 = sheetSwipeEnabled4;
                    sheetTonalElevation2 = sheetTonalElevation6;
                    sheetContainerColor3 = sheetContainerColor2;
                    sheetPeekHeight2 = sheetPeekHeight4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 16384) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32768) != 0) {
                    $dirty3 &= -458753;
                }
                sheetPeekHeight2 = sheetPeekHeight;
                sheetMaxWidth2 = sheetMaxWidth;
                sheetShape2 = sheetShape;
                sheetContainerColor3 = sheetContainerColor;
                sheetContentColor2 = sheetContentColor;
                sheetTonalElevation2 = sheetTonalElevation;
                sheetShadowElevation2 = sheetShadowElevation;
                function2M2110getLambda1$material3_release = function2;
                sheetSwipeEnabled2 = sheetSwipeEnabled;
                function8 = function4;
                function7 = function5;
                containerColor3 = containerColor;
                contentColor2 = contentColor;
                $dirty = $dirty2;
                $dirty1 = $dirty3;
                modifier2 = modifier;
                scaffoldState3 = scaffoldState;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1523924135, $dirty, $dirty1, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:126)");
            }
            SheetState bottomSheetState = scaffoldState3.getBottomSheetState();
            int $dirty4 = $dirty1;
            int $dirty5 = 1;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-459880832, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
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
                    ComposerKt.sourceInformation($composer3, "C130@6947L48:BottomSheetScaffold.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-459880832, $changed2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:130)");
                    }
                    function6.invoke(PaddingKt.m865PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, sheetPeekHeight2, 7, null), $composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54);
            final BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState3;
            final float f = sheetPeekHeight2;
            final float f2 = sheetMaxWidth2;
            final boolean z = sheetSwipeEnabled2;
            final Shape shape = sheetShape2;
            final long j = sheetContainerColor3;
            final long j2 = sheetContentColor2;
            final float f3 = sheetTonalElevation2;
            final float f4 = sheetShadowElevation2;
            final Function2<? super Composer, ? super Integer, Unit> function13 = function2M2110getLambda1$material3_release;
            float sheetPeekHeight5 = sheetPeekHeight2;
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1961872927, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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
                    ComposerKt.sourceInformation($composer3, "C139@7334L573:BottomSheetScaffold.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1961872927, $changed2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:139)");
                        }
                        BottomSheetScaffoldKt.m1947StandardBottomSheetw7I5h1o(bottomSheetScaffoldState.getBottomSheetState(), f, f2, z, shape, j, j2, f3, f4, function13, function3, $composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            long sheetContainerColor5 = sheetContainerColor3;
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3
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
                    ComposerKt.sourceInformation($composer3, "C132@7036L45:BottomSheetScaffold.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(88659390, $changed2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:132)");
                    }
                    function7.invoke(scaffoldState3.getSnackbarHostState(), $composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54);
            ComposerKt.sourceInformationMarkerStart($composer2, -1567543964, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            if (((($dirty & 896) ^ 384) <= 256 || !$composer2.changed(scaffoldState3)) && ($dirty & 384) != 256) {
                $dirty5 = 0;
            }
            int i13 = $dirty5;
            Object it$iv = $composer2.rememberedValue();
            if (i13 != 0 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(scaffoldState3.getBottomSheetState().requireOffset());
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m1946BottomSheetScaffoldLayout2E65NiM(modifier2, function8, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, (Function0) value$iv, bottomSheetState, containerColor3, contentColor2, $composer2, (($dirty >> 3) & 14) | 28032 | (($dirty4 >> 3) & 112) | (($dirty4 << 9) & 29360128) | (($dirty4 << 9) & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function9 = function8;
            modifier3 = modifier2;
            sheetContainerColor4 = sheetContainerColor5;
            scaffoldState4 = scaffoldState3;
            sheetTonalElevation3 = sheetTonalElevation2;
            sheetShadowElevation3 = sheetShadowElevation2;
            sheetSwipeEnabled3 = sheetSwipeEnabled2;
            function10 = function2M2110getLambda1$material3_release;
            function11 = function7;
            sheetShape3 = sheetShape2;
            sheetMaxWidth3 = sheetMaxWidth2;
            containerColor4 = containerColor3;
            sheetContentColor3 = sheetContentColor2;
            contentColor3 = contentColor2;
            sheetPeekHeight3 = sheetPeekHeight5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final BottomSheetScaffoldState bottomSheetScaffoldState2 = scaffoldState4;
            final float f5 = sheetPeekHeight3;
            final float f6 = sheetMaxWidth3;
            final Shape shape2 = sheetShape3;
            final long j3 = sheetContainerColor4;
            final long j4 = sheetContentColor3;
            final float f7 = sheetTonalElevation3;
            final float f8 = sheetShadowElevation3;
            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
            final boolean z2 = sheetSwipeEnabled3;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function9;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function16 = function11;
            final long j5 = containerColor4;
            final long j6 = contentColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$5
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

                public final void invoke(Composer composer, int i14) {
                    BottomSheetScaffoldKt.m1945BottomSheetScaffoldsdMYb0k(function3, modifier5, bottomSheetScaffoldState2, f5, f6, shape2, j3, j4, f7, f8, function14, z2, function15, function16, j5, j6, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, -1474606134, "C(rememberBottomSheetScaffoldState)179@8684L34,180@8763L32,182@8837L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            bottomSheetState = rememberStandardBottomSheetState(null, null, false, $composer, 0, 7);
        }
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, 667326212, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            snackbarHostState = (SnackbarHostState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, $changed, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:181)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 667326286, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(bottomSheetState)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(snackbarHostState)) || ($changed & 48) == 32);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv2;
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue initialValue, Function1<? super SheetValue, Boolean> function1, boolean skipHiddenState, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 678511581, "C(rememberStandardBottomSheetState)P(1)204@9663L138:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialValue = SheetValue.PartiallyExpanded;
        }
        if ((i & 2) != 0) {
            Function1 confirmValueChange = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt.rememberStandardBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    return true;
                }
            };
            function1 = confirmValueChange;
        }
        if ((i & 4) != 0) {
            skipHiddenState = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, $changed, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:204)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(false, function1, initialValue, skipHiddenState, $composer, ($changed & 112) | (($changed << 6) & 896) | (($changed << 3) & 7168), 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return sheetStateRememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: StandardBottomSheet-w7I5h1o, reason: not valid java name */
    public static final void m1947StandardBottomSheetw7I5h1o(final SheetState state, final float peekHeight, final float sheetMaxWidth, final boolean sheetSwipeEnabled, final Shape shape, final long containerColor, final long contentColor, final float tonalElevation, final float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1) {
        Object value$iv$iv;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(721467526);
        ComposerKt.sourceInformation($composer2, "C(StandardBottomSheet)P(9,4:c#ui.unit.Dp,7:c#ui.unit.Dp,8,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.unit.Dp,5:c#ui.unit.Dp,3)225@10216L24,*227@10325L7,234@10558L326,242@10972L1594,283@12937L2422,228@10360L4999:BottomSheetScaffold.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(peekHeight) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(sheetMaxWidth) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(sheetSwipeEnabled) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(containerColor) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(tonalElevation) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(shadowElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        if (($dirty & 306783379) != 306783378 || ($dirty1 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(721467526, $dirty, $dirty1, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:224)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Orientation orientation = Orientation.Vertical;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$StandardBottomSheet_w7I5h1o_u24lambda_u243 = (Density) objConsume;
            final float peekHeightPx = $this$StandardBottomSheet_w7I5h1o_u24lambda_u243.mo567toPx0680j_4(peekHeight);
            Modifier modifierM904requiredHeightInVpY3zN4$default = SizeKt.m904requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m920widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, sheetMaxWidth, 1, null), 0.0f, 1, null), peekHeight, 0.0f, 2, null);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = state.getAnchoredDraggableState$material3_release();
            ComposerKt.sourceInformationMarkerStart($composer2, 1603483530, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(anchoredDraggableState$material3_release);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(state, orientation, new Function1<Float, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1 */
                    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1", m210f = "BottomSheetScaffold.kt", m211i = {}, m212l = {239}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C12281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C12281(SheetState sheetState, float f, Continuation<? super C12281> continuation) {
                            super(2, continuation);
                            this.$state = sheetState;
                            this.$it = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C12281(this.$state, this.$it, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C12281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$state.settle$material3_release(this.$it, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    break;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public final void invoke(float it) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C12281(state, it, null), 3, null);
                    }
                });
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierM904requiredHeightInVpY3zN4$default, (NestedScrollConnection) value$iv, null, 2, null);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release2 = state.getAnchoredDraggableState$material3_release();
            ComposerKt.sourceInformationMarkerStart($composer2, 1603483944, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 14) == 4) | $composer2.changed(peekHeightPx);
            int $dirty2 = $dirty;
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SheetValue>, ? extends SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1

                    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 3;
                            } catch (NoSuchFieldError e3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SheetValue>, ? extends SheetValue> invoke(IntSize intSize, Constraints constraints) {
                        return m1950invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
                    public final Pair<DraggableAnchors<SheetValue>, SheetValue> m1950invokeGpV2Q24(long sheetSize, long constraints) {
                        final float layoutHeight = Constraints.m6743getMaxHeightimpl(constraints);
                        final float sheetHeight = IntSize.m6974getHeightimpl(sheetSize);
                        final SheetState sheetState = state;
                        final float f = peekHeightPx;
                        DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$newAnchors$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                invoke2(draggableAnchorsConfig);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                if (!sheetState.getSkipPartiallyExpanded()) {
                                    draggableAnchorsConfig.m24at(SheetValue.PartiallyExpanded, layoutHeight - f);
                                }
                                if (!(sheetHeight == f)) {
                                    draggableAnchorsConfig.m24at(SheetValue.Expanded, Math.max(layoutHeight - sheetHeight, 0.0f));
                                }
                                if (!sheetState.getSkipHiddenState()) {
                                    draggableAnchorsConfig.m24at(SheetValue.Hidden, layoutHeight);
                                }
                            }
                        });
                        SheetValue oldTarget = state.getAnchoredDraggableState$material3_release().getTargetValue();
                        switch (WhenMappings.$EnumSwitchMapping$0[oldTarget.ordinal()]) {
                            case 1:
                                if (newAnchors.hasAnchorFor(SheetValue.Hidden)) {
                                    oldTarget = SheetValue.Hidden;
                                }
                                break;
                            case 2:
                                if (newAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                                    oldTarget = SheetValue.PartiallyExpanded;
                                } else if (newAnchors.hasAnchorFor(SheetValue.Expanded)) {
                                    oldTarget = SheetValue.Expanded;
                                } else if (newAnchors.hasAnchorFor(SheetValue.Hidden)) {
                                    oldTarget = SheetValue.Hidden;
                                }
                                break;
                            case 3:
                                if (newAnchors.hasAnchorFor(SheetValue.Expanded)) {
                                    oldTarget = SheetValue.Expanded;
                                } else if (newAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                                    oldTarget = SheetValue.PartiallyExpanded;
                                } else if (newAnchors.hasAnchorFor(SheetValue.Hidden)) {
                                    oldTarget = SheetValue.Hidden;
                                }
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        return TuplesKt.m202to(newAnchors, oldTarget);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SurfaceKt.m2666SurfaceT9BRK9s(AnchoredDraggableKt.anchoredDraggable(AnchoredDraggableKt.draggableAnchors(modifierNestedScroll$default, anchoredDraggableState$material3_release2, orientation, (Function2) value$iv2), state.getAnchoredDraggableState$material3_release(), orientation, (16 & 4) != 0 ? true : sheetSwipeEnabled, (16 & 8) != 0 ? false : false, (16 & 16) != 0 ? null : null), shape, containerColor, contentColor, tonalElevation, shadowElevation, null, ComposableLambdaKt.rememberComposableLambda(390720907, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
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

                /* JADX WARN: Code duplicated, block: B:38:0x0267  */
                /* JADX WARN: Code duplicated, block: B:41:0x0273  */
                /* JADX WARN: Code duplicated, block: B:42:0x0279  */
                public final void invoke(Composer composer, int i) {
                    Function0<ComposeUiNode> function0;
                    Composer composer2;
                    Composer composer3;
                    int i2;
                    int currentCompositeKeyHash;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function1;
                    Composer composerM3795constructorimpl;
                    ComposerKt.sourceInformation(composer, "C284@12947L2406:BottomSheetScaffold.kt#uh7d8r");
                    if ((i & 3) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(390720907, i, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:284)");
                        }
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function4 = function2;
                        final SheetState sheetState = state;
                        final boolean z = sheetSwipeEnabled;
                        final CoroutineScope coroutineScope = scope;
                        Function3<ColumnScope, Composer, Integer, Unit> function5 = function3;
                        ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int i3 = ((((6 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            function0 = constructor2;
                            composer.createNode(function0);
                        } else {
                            function0 = constructor2;
                            composer.useNode();
                        }
                        Composer composerM3795constructorimpl2 = Updater.m3795constructorimpl(composer);
                        Updater.m3802setimpl(composerM3795constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl(composerM3795constructorimpl2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM3795constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3795constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM3795constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM3795constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl(composerM3795constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = (i3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart(composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        int i5 = ((6 >> 6) & 112) | 6;
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer, -176228401, "C327@15334L9:BottomSheetScaffold.kt#uh7d8r");
                        composer.startReplaceGroup(-176228401);
                        ComposerKt.sourceInformation(composer, "287@13086L54,288@13182L48,289@13271L47,293@13480L1755,290@13335L1972");
                        if (function4 != null) {
                            Strings.Companion companion = Strings.INSTANCE;
                            final String strM3086getString2EP1pXo = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_bottom_sheet_collapse_description), composer, 0);
                            Strings.Companion companion2 = Strings.INSTANCE;
                            final String strM3086getString2EP1pXo2 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_bottom_sheet_dismiss_description), composer, 0);
                            Strings.Companion companion3 = Strings.INSTANCE;
                            final String strM3086getString2EP1pXo3 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_bottom_sheet_expand_description), composer, 0);
                            Modifier modifierAlign = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                            ComposerKt.sourceInformationMarkerStart(composer, -176227914, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                            boolean zChanged = composer.changed(sheetState) | composer.changed(z) | composer.changed(strM3086getString2EP1pXo3) | composer.changedInstance(coroutineScope) | composer.changed(strM3086getString2EP1pXo) | composer.changed(strM3086getString2EP1pXo2);
                            Object objRememberedValue = composer.rememberedValue();
                            if (!zChanged) {
                                composer3 = composer;
                                if (objRememberedValue != Composer.INSTANCE.getEmpty()) {
                                    i2 = -1323940314;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierAlign, true, (Function1) objRememberedValue);
                                composer2 = composer3;
                                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer2, i2, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierSemantics);
                                constructor = ComposeUiNode.INSTANCE.getConstructor();
                                int i6 = ((((0 << 3) & 112) << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    function1 = constructor;
                                    composer2.createNode(function1);
                                } else {
                                    function1 = constructor;
                                    composer2.useNode();
                                }
                                composerM3795constructorimpl = Updater.m3795constructorimpl(composer2);
                                Updater.m3802setimpl(composerM3795constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl(composerM3795constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!composerM3795constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3795constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM3795constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM3795constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                                }
                                Updater.m3802setimpl(composerM3795constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i7 = (i6 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int i8 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1084284380, "C324@15277L12:BottomSheetScaffold.kt#uh7d8r");
                                function4.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                            } else {
                                composer3 = composer;
                            }
                            i2 = -1323940314;
                            objRememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1
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
                                    final SheetState $this$invoke_u24lambda_u240 = sheetState;
                                    boolean z2 = z;
                                    String str = strM3086getString2EP1pXo3;
                                    String str2 = strM3086getString2EP1pXo;
                                    SheetState sheetState2 = sheetState;
                                    String str3 = strM3086getString2EP1pXo2;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    if ($this$invoke_u24lambda_u240.getAnchoredDraggableState$material3_release().getAnchors().getSize() > 1 && z2) {
                                        if ($this$invoke_u24lambda_u240.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                            if ($this$invoke_u24lambda_u240.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                SemanticsPropertiesKt.expand($this$semantics, str, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1$1 */
                                                    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                                                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                    @DebugMetadata(m209c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1$1", m210f = "BottomSheetScaffold.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_MOVED_TEMP}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                    static final class C12291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ SheetState $this_with;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        C12291(SheetState sheetState, Continuation<? super C12291> continuation) {
                                                            super(2, continuation);
                                                            this.$this_with = sheetState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new C12291(this.$this_with, continuation);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                            return ((C12291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object $result) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            switch (this.label) {
                                                                case 0:
                                                                    ResultKt.throwOnFailure($result);
                                                                    this.label = 1;
                                                                    if (this.$this_with.expand(this) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    break;
                                                                case 1:
                                                                    ResultKt.throwOnFailure($result);
                                                                    break;
                                                                default:
                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C12291($this$invoke_u24lambda_u240, null), 3, null);
                                                        return true;
                                                    }
                                                });
                                            }
                                        } else if ($this$invoke_u24lambda_u240.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                            SemanticsPropertiesKt.collapse($this$semantics, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2$1 */
                                                /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                @DebugMetadata(m209c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2$1", m210f = "BottomSheetScaffold.kt", m211i = {}, m212l = {311}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                static final class C12301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ SheetState $this_with;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C12301(SheetState sheetState, Continuation<? super C12301> continuation) {
                                                        super(2, continuation);
                                                        this.$this_with = sheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C12301(this.$this_with, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C12301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object $result) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure($result);
                                                                this.label = 1;
                                                                if (this.$this_with.partialExpand(this) == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                break;
                                                            case 1:
                                                                ResultKt.throwOnFailure($result);
                                                                break;
                                                            default:
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C12301($this$invoke_u24lambda_u240, null), 3, null);
                                                    return true;
                                                }
                                            });
                                        }
                                        if (!sheetState2.getSkipHiddenState()) {
                                            SemanticsPropertiesKt.dismiss($this$semantics, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3$1 */
                                                /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                @DebugMetadata(m209c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3$1", m210f = "BottomSheetScaffold.kt", m211i = {}, m212l = {317}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                static final class C12311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ SheetState $this_with;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C12311(SheetState sheetState, Continuation<? super C12311> continuation) {
                                                        super(2, continuation);
                                                        this.$this_with = sheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C12311(this.$this_with, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C12311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object $result) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure($result);
                                                                this.label = 1;
                                                                if (this.$this_with.hide(this) == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                break;
                                                            case 1:
                                                                ResultKt.throwOnFailure($result);
                                                                break;
                                                            default:
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C12311($this$invoke_u24lambda_u240, null), 3, null);
                                                    return true;
                                                }
                                            });
                                        }
                                    }
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifierAlign, true, (Function1) objRememberedValue);
                            composer2 = composer3;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer2, i2, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierSemantics2);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int i9 = ((((0 << 3) & 112) << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                function1 = constructor;
                                composer2.createNode(function1);
                            } else {
                                function1 = constructor;
                                composer2.useNode();
                            }
                            composerM3795constructorimpl = Updater.m3795constructorimpl(composer2);
                            Updater.m3802setimpl(composerM3795constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl(composerM3795constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM3795constructorimpl.getInserting()) {
                            }
                            composerM3795constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM3795constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                            Updater.m3802setimpl(composerM3795constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                            int i10 = (i9 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            int i11 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1084284380, "C324@15277L12:BottomSheetScaffold.kt#uh7d8r");
                            function4.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                        } else {
                            composer2 = composer;
                        }
                        composer2.endReplaceGroup();
                        function5.invoke(columnScopeInstance, composer2, Integer.valueOf(i5 & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 9) & 112) | 12582912 | (($dirty2 >> 9) & 896) | (($dirty2 >> 9) & 7168) | (($dirty2 >> 9) & 57344) | (458752 & ($dirty2 >> 9)), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$4
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

                public final void invoke(Composer composer, int i) {
                    BottomSheetScaffoldKt.m1947StandardBottomSheetw7I5h1o(state, peekHeight, sheetMaxWidth, sheetSwipeEnabled, shape, containerColor, contentColor, tonalElevation, shadowElevation, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-2E65NiM, reason: not valid java name */
    public static final void m1946BottomSheetScaffoldLayout2E65NiM(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function0<Float> function0, final SheetState sheetState, final long containerColor, final long contentColor, Composer $composer, final int $changed) {
        MultiContentMeasurePolicy value$iv;
        Object value$iv$iv;
        int $dirty;
        Function0<ComposeUiNode> function1;
        Composer $composer2 = $composer.startRestartGroup(-1651214892);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(4,8!2,7,5,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color)348@15850L227,359@16145L1919,345@15752L2312:BottomSheetScaffold.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changedInstance(function5) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer2.changed(sheetState) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer2.changed(containerColor) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(contentColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty3 = $dirty2;
        if ((38347923 & $dirty3) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            $dirty = $dirty3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651214892, $dirty3, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:344)");
            }
            Function2[] function2Arr = new Function2[4];
            function2Arr[0] = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2112getLambda3$material3_release() : function2;
            function2Arr[1] = ComposableLambdaKt.rememberComposableLambda(398963586, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1
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
                    ComposerKt.sourceInformation($composer3, "C349@15868L195:BottomSheetScaffold.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(398963586, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous> (BottomSheetScaffold.kt:349)");
                        }
                        SurfaceKt.m2666SurfaceT9BRK9s(modifier, null, containerColor, contentColor, 0.0f, 0.0f, null, function3, $composer3, 0, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            function2Arr[2] = function4;
            function2Arr[3] = function5;
            List contents$iv = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart($composer2, -99157024, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = ((3670016 & $dirty3) == 1048576) | ((458752 & $dirty3) == 131072);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1
                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MultiContentMeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo816measure3p2s80s(MeasureScope $this$Layout, List<? extends List<? extends Measurable>> list, long constraints) {
                        Integer numValueOf;
                        List<? extends Measurable> list2 = list.get(0);
                        List<? extends Measurable> list3 = list.get(1);
                        List<? extends Measurable> list4 = list.get(2);
                        List<? extends Measurable> list5 = list.get(3);
                        final int layoutWidth = Constraints.m6744getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6743getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
                        List target$iv = new ArrayList(list4.size());
                        int index$iv$iv = 0;
                        int size = list4.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = list4.get(index$iv$iv);
                            List<? extends Measurable> list6 = list4;
                            Measurable it = (Measurable) item$iv$iv;
                            target$iv.add(it.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv++;
                            list4 = list6;
                        }
                        final List sheetPlaceables = target$iv;
                        List<? extends Measurable> list7 = list2;
                        List target$iv2 = new ArrayList(list7.size());
                        int index$iv$iv2 = 0;
                        int size2 = list7.size();
                        while (index$iv$iv2 < size2) {
                            Object item$iv$iv2 = list7.get(index$iv$iv2);
                            List<? extends Measurable> list8 = list2;
                            Measurable it2 = (Measurable) item$iv$iv2;
                            target$iv2.add(it2.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv2++;
                            list7 = list7;
                            list2 = list8;
                        }
                        final List topBarPlaceables = target$iv2;
                        if (!topBarPlaceables.isEmpty()) {
                            Placeable it3 = (Placeable) topBarPlaceables.get(0);
                            numValueOf = Integer.valueOf(it3.getHeight());
                            int i$iv = 1;
                            int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Placeable it4 = (Placeable) topBarPlaceables.get(i$iv);
                                    Integer numValueOf2 = Integer.valueOf(it4.getHeight());
                                    if (numValueOf2.compareTo(numValueOf) > 0) {
                                        numValueOf = numValueOf2;
                                    }
                                    if (i$iv == lastIndex) {
                                        break;
                                    }
                                    i$iv++;
                                }
                            }
                        } else {
                            numValueOf = null;
                        }
                        Integer num = numValueOf;
                        int topBarHeight = num != null ? num.intValue() : 0;
                        long bodyConstraints = Constraints.m6734copyZbe2FdA(looseConstraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(looseConstraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(looseConstraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(looseConstraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(looseConstraints) : layoutHeight - topBarHeight);
                        List target$iv3 = new ArrayList(list3.size());
                        int index$iv$iv3 = 0;
                        int size3 = list3.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = list3.get(index$iv$iv3);
                            List<? extends Measurable> list9 = list3;
                            Measurable it5 = (Measurable) item$iv$iv3;
                            target$iv3.add(it5.mo5644measureBRTryo0(bodyConstraints));
                            index$iv$iv3++;
                            size3 = size3;
                            list3 = list9;
                        }
                        final List bodyPlaceables = target$iv3;
                        List<? extends Measurable> list10 = list5;
                        List target$iv4 = new ArrayList(list10.size());
                        int index$iv$iv4 = 0;
                        int size4 = list10.size();
                        while (index$iv$iv4 < size4) {
                            Object item$iv$iv4 = list10.get(index$iv$iv4);
                            List<? extends Measurable> list11 = list10;
                            Measurable it6 = (Measurable) item$iv$iv4;
                            target$iv4.add(it6.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv4++;
                            size4 = size4;
                            list10 = list11;
                        }
                        final List snackbarPlaceables = target$iv4;
                        final SheetState sheetState2 = sheetState;
                        final Function0<Float> function6 = function0;
                        final int i = topBarHeight;
                        return MeasureScope.CC.layout$default($this$Layout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.1

                            /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
                            /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                            @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[SheetValue.values().length];
                                    try {
                                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                                    } catch (NoSuchFieldError e) {
                                    }
                                    try {
                                        iArr[SheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError e2) {
                                    }
                                    try {
                                        iArr[SheetValue.Hidden.ordinal()] = 3;
                                    } catch (NoSuchFieldError e3) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                Integer numValueOf3;
                                Integer numValueOf4;
                                int snackbarOffsetY;
                                List<Placeable> list12 = sheetPlaceables;
                                Integer numValueOf5 = null;
                                if (!list12.isEmpty()) {
                                    Placeable it7 = list12.get(0);
                                    numValueOf3 = Integer.valueOf(it7.getWidth());
                                    int i$iv2 = 1;
                                    int lastIndex2 = CollectionsKt.getLastIndex(list12);
                                    if (1 <= lastIndex2) {
                                        while (true) {
                                            Placeable it8 = list12.get(i$iv2);
                                            Integer numValueOf6 = Integer.valueOf(it8.getWidth());
                                            if (numValueOf6.compareTo(numValueOf3) > 0) {
                                                numValueOf3 = numValueOf6;
                                            }
                                            if (i$iv2 == lastIndex2) {
                                                break;
                                            } else {
                                                i$iv2++;
                                            }
                                        }
                                    }
                                } else {
                                    numValueOf3 = null;
                                }
                                Integer num2 = numValueOf3;
                                int sheetWidth = num2 != null ? num2.intValue() : 0;
                                int sheetOffsetX = Math.max(0, (layoutWidth - sheetWidth) / 2);
                                List<Placeable> list13 = snackbarPlaceables;
                                if (!list13.isEmpty()) {
                                    Placeable it9 = list13.get(0);
                                    numValueOf4 = Integer.valueOf(it9.getWidth());
                                    int i$iv3 = 1;
                                    int lastIndex3 = CollectionsKt.getLastIndex(list13);
                                    if (1 <= lastIndex3) {
                                        while (true) {
                                            Placeable it10 = list13.get(i$iv3);
                                            Integer numValueOf7 = Integer.valueOf(it10.getWidth());
                                            if (numValueOf7.compareTo(numValueOf4) > 0) {
                                                numValueOf4 = numValueOf7;
                                            }
                                            if (i$iv3 == lastIndex3) {
                                                break;
                                            } else {
                                                i$iv3++;
                                            }
                                        }
                                    }
                                } else {
                                    numValueOf4 = null;
                                }
                                Integer num3 = numValueOf4;
                                int snackbarWidth = num3 != null ? num3.intValue() : 0;
                                List<Placeable> list14 = snackbarPlaceables;
                                if (!list14.isEmpty()) {
                                    Placeable it11 = list14.get(0);
                                    numValueOf5 = Integer.valueOf(it11.getHeight());
                                    int i$iv4 = 1;
                                    int lastIndex4 = CollectionsKt.getLastIndex(list14);
                                    if (1 <= lastIndex4) {
                                        while (true) {
                                            Placeable it12 = list14.get(i$iv4);
                                            Integer numValueOf8 = Integer.valueOf(it12.getHeight());
                                            if (numValueOf8.compareTo(numValueOf5) > 0) {
                                                numValueOf5 = numValueOf8;
                                            }
                                            if (i$iv4 == lastIndex4) {
                                                break;
                                            } else {
                                                i$iv4++;
                                            }
                                        }
                                    }
                                }
                                Integer num4 = numValueOf5;
                                int snackbarHeight = num4 != null ? num4.intValue() : 0;
                                int snackbarOffsetX = (layoutWidth - snackbarWidth) / 2;
                                switch (WhenMappings.$EnumSwitchMapping$0[sheetState2.getCurrentValue().ordinal()]) {
                                    case 1:
                                        snackbarOffsetY = MathKt.roundToInt(function6.invoke().floatValue()) - snackbarHeight;
                                        break;
                                    case 2:
                                    case 3:
                                        snackbarOffsetY = layoutHeight - snackbarHeight;
                                        break;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                                List<Placeable> list15 = bodyPlaceables;
                                int i2 = i;
                                int index$iv = 0;
                                for (int size5 = list15.size(); index$iv < size5; size5 = size5) {
                                    Object item$iv = list15.get(index$iv);
                                    Placeable it13 = (Placeable) item$iv;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it13, 0, i2, 0.0f, 4, null);
                                    index$iv++;
                                }
                                List<Placeable> list16 = topBarPlaceables;
                                int size6 = list16.size();
                                for (int index$iv2 = 0; index$iv2 < size6; index$iv2++) {
                                    Object item$iv2 = list16.get(index$iv2);
                                    Placeable it14 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it14, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list17 = sheetPlaceables;
                                int size7 = list17.size();
                                for (int index$iv3 = 0; index$iv3 < size7; index$iv3++) {
                                    Object item$iv3 = list17.get(index$iv3);
                                    Placeable it15 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it15, sheetOffsetX, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list18 = snackbarPlaceables;
                                int size8 = list18.size();
                                for (int index$iv4 = 0; index$iv4 < size8; index$iv4++) {
                                    Object item$iv4 = list18.get(index$iv4);
                                    Placeable it16 = (Placeable) item$iv4;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it16, snackbarOffsetX, snackbarOffsetY, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MultiContentMeasurePolicy measurePolicy$iv = (MultiContentMeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(contents$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, 1376093675, "CC(remember):Layout.kt#9igjgp");
            boolean invalid$iv$iv = (((0 & 896) ^ 384) > 256 && $composer2.changed(measurePolicy$iv)) || (0 & 384) == 256;
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy$iv);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv = 0 & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $dirty = $dirty3;
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke($composer2, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3
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

                public final void invoke(Composer composer, int i) {
                    BottomSheetScaffoldKt.m1946BottomSheetScaffoldLayout2E65NiM(modifier, function2, function3, function4, function5, function0, sheetState, containerColor, contentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
