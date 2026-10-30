package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.RectangleShapeKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
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
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aj\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001av\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001an\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u008c\u0001\u0010$\u001a\u00020\f2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\f0&¢\u0006\u0002\b\u001a2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010&¢\u0006\u0002\b\u001a2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0084\u0001\u0010$\u001a\u00020\f2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\f0&¢\u0006\u0002\b\u001a2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010&¢\u0006\u0002\b\u001a2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aj\u0010$\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001ab\u0010$\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0080\b\u001a,\u00105\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202062\u0006\u00107\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00108\u001a\u000202H\u0000\u001a\u0011\u00109\u001a\u0002022\u0006\u0010:\u001a\u000202H\u0082\b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, m195d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "windowInsets", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-HkEspTQ", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-DanWW-k", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-Rx1qByU", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AppBarKt {
    private static final float AppBarHeight = C1979Dp.m6801constructorimpl(56);
    private static final float AppBarHorizontalPadding = C1979Dp.m6801constructorimpl(4);
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;
    private static final WindowInsets ZeroInsets;

    /* JADX INFO: renamed from: TopAppBar-Rx1qByU, reason: not valid java name */
    public static final void m1557TopAppBarRx1qByU(final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, long backgroundColor, long contentColor, float elevation, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1651getLambda1$material_release;
        long backgroundColor2;
        int $dirty;
        long contentColor2;
        float elevation2;
        int $dirty2;
        long contentColor3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        long contentColor4;
        float elevation3;
        Modifier modifier3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        long backgroundColor3;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(-763778507);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(6,7,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)90@4376L6,91@4425L32,102@4704L1128,94@4522L1310:AppBar.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changed(windowInsets) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 3072;
            function5 = function3;
        } else if (($changed & 3072) == 0) {
            function5 = function3;
            $dirty4 |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            function3M1651getLambda1$material_release = function4;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function3M1651getLambda1$material_release = function4;
            $dirty4 |= $composer2.changedInstance(function3M1651getLambda1$material_release) ? 16384 : 8192;
        } else {
            function3M1651getLambda1$material_release = function4;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer2.changed(backgroundColor2) ? 131072 : 65536;
                $dirty4 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty4 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                int i6 = $composer2.changed(contentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i6;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i6;
        } else {
            $dirty = $dirty4;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(elevation) ? 8388608 : 4194304;
        }
        if (($dirty & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentColor4 = contentColor;
            elevation3 = elevation;
            modifier3 = modifier2;
            function7 = function3M1651getLambda1$material_release;
            backgroundColor3 = backgroundColor2;
            function6 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    function5 = null;
                }
                if (i4 != 0) {
                    function3M1651getLambda1$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1651getLambda1$material_release();
                }
                if ((i & 32) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                if (i7 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1552getTopAppBarElevationD9Ej5fM();
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                } else {
                    elevation2 = elevation;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    elevation2 = elevation;
                    $dirty2 = $dirty & (-3670017);
                    contentColor3 = contentColor;
                } else {
                    contentColor3 = contentColor;
                    elevation2 = elevation;
                    $dirty2 = $dirty;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-763778507, $dirty2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:93)");
            }
            Function2<? super Composer, ? super Integer, Unit> function8 = function5;
            m1553AppBarHkEspTQ(backgroundColor2, contentColor3, elevation2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets, modifier2, ComposableLambdaKt.rememberComposableLambda(1849684359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope $this$AppBar, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C114@5092L412,128@5579L6,128@5587L239,128@5514L312:AppBar.kt#jmzs0o");
                    int $dirty5 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty5 |= $composer3.changed($this$AppBar) ? 4 : 2;
                    }
                    if (($dirty5 & 19) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1849684359, $dirty5, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:103)");
                        }
                        if (function5 == null) {
                            $composer3.startReplaceGroup(-512812140);
                            ComposerKt.sourceInformation($composer3, "104@4756L29");
                            SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, $composer3, 6);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(-512812081);
                            ComposerKt.sourceInformation($composer3, "106@4815L257");
                            Modifier modifier$iv = AppBarKt.TitleIconModifier;
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function9 = function5;
                            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                            int $changed$iv$iv = (390 << 3) & 112;
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
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            int i9 = ((390 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -2027905463, "C108@4990L4,107@4904L154:AppBar.kt#jmzs0o");
                            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer3, 6))), function9, $composer3, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceGroup();
                        }
                        Modifier modifier$iv2 = RowScope.CC.weight$default($this$AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                        final Function2<Composer, Integer, Unit> function10 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv2 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor2);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        int i11 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -2027905104, "C120@5302L10,120@5317L177,120@5263L231:AppBar.kt#jmzs0o");
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography($composer3, 6).getH6(), ComposableLambdaKt.rememberComposableLambda(-1654084516, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C122@5421L4,121@5335L145:AppBar.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1654084516, $changed3, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:121)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer4, 6))), function10, $composer4, ProvidedValue.$stable);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 48);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer3, 6)));
                        final Function3<RowScope, Composer, Integer, Unit> function11 = function3M1651getLambda1$material_release;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(2129753671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C129@5601L215:AppBar.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2129753671, $changed3, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:129)");
                                    }
                                    Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function12 = function11;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                                    int $changed$iv$iv3 = (438 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        $composer4.createNode(constructor3);
                                    } else {
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer4);
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    function12.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf(((438 >> 6) & 112) | 6));
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 15) & 14) | 12610560 | (($dirty2 >> 15) & 112) | (($dirty2 >> 15) & 896) | (($dirty2 << 12) & 458752) | (3670016 & ($dirty2 << 12)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function8;
            contentColor4 = contentColor3;
            elevation3 = elevation2;
            modifier3 = modifier2;
            function7 = function3M1651getLambda1$material_release;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function7;
            final long j = backgroundColor3;
            final long j2 = contentColor4;
            final float f = elevation3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
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
                    AppBarKt.m1557TopAppBarRx1qByU(function2, windowInsets, modifier4, function9, function10, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    public static final void m1559TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, long backgroundColor, long contentColor, float elevation, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M1652getLambda2$material_release;
        long backgroundColor2;
        long contentColor2;
        Modifier.Companion modifier2;
        float elevation2;
        int $dirty;
        long contentColor3;
        Modifier modifier3;
        long contentColor4;
        float elevation3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        long backgroundColor3;
        Composer $composer2 = $composer.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)172@7722L6,173@7771L32,176@7867L175:AppBar.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
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
            function5 = function3;
        } else if (($changed & 384) == 0) {
            function5 = function3;
            $dirty2 |= $composer2.changedInstance(function5) ? 256 : 128;
        } else {
            function5 = function3;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M1652getLambda2$material_release = function4;
        } else if (($changed & 3072) == 0) {
            function3M1652getLambda2$material_release = function4;
            $dirty2 |= $composer2.changedInstance(function3M1652getLambda2$material_release) ? 2048 : 1024;
        } else {
            function3M1652getLambda2$material_release = function4;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer2.changed(backgroundColor2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer2.changed(contentColor2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(elevation) ? 1048576 : 524288;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            elevation3 = elevation;
            function7 = function3M1652getLambda2$material_release;
            backgroundColor3 = backgroundColor2;
            contentColor4 = contentColor2;
            modifier3 = modifier;
            function6 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    function5 = null;
                }
                if (i4 != 0) {
                    function3M1652getLambda2$material_release = ComposableSingletons$AppBarKt.INSTANCE.m1652getLambda2$material_release();
                }
                if ((i & 16) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 12) & 14);
                    $dirty2 &= -458753;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    elevation2 = AppBarDefaults.INSTANCE.m1552getTopAppBarElevationD9Ej5fM();
                    contentColor3 = contentColor2;
                } else {
                    elevation2 = elevation;
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    elevation2 = elevation;
                    $dirty = $dirty2 & (-458753);
                    contentColor3 = contentColor2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    elevation2 = elevation;
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087748139, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:175)");
            }
            m1557TopAppBarRx1qByU(function2, ZeroInsets, modifier2, function5, function3M1652getLambda2$material_release, backgroundColor2, contentColor3, elevation2, $composer2, ($dirty & 14) | 48 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (29360128 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            contentColor4 = contentColor3;
            elevation3 = elevation2;
            function6 = function5;
            function7 = function3M1652getLambda2$material_release;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function9 = function7;
            final long j = backgroundColor3;
            final long j2 = contentColor4;
            final float f = elevation3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
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
                    AppBarKt.m1559TopAppBarxWeB9s(function2, modifier4, function8, function9, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: TopAppBar-afqeVBk, reason: not valid java name */
    public static final void m1558TopAppBarafqeVBk(final WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        float elevation2;
        PaddingValues paddingValues;
        Modifier.Companion modifier2;
        PaddingValues contentPadding2;
        Modifier modifier3;
        PaddingValues contentPadding3;
        long backgroundColor3;
        long contentColor3;
        float elevation3;
        Composer $composer2 = $composer.startRestartGroup(883764366);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(6,5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)222@9964L6,223@10013L32,228@10222L204:AppBar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(windowInsets) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                int i3 = $composer2.changed(backgroundColor2) ? 256 : 128;
                $dirty |= i3;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            elevation2 = elevation;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            elevation2 = elevation;
            $dirty |= $composer2.changed(elevation2) ? 16384 : 8192;
        } else {
            elevation2 = elevation;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            paddingValues = contentPadding;
        } else if ((196608 & $changed) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer2.changed(paddingValues) ? 131072 : 65536;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            contentColor3 = contentColor2;
            elevation3 = elevation2;
            contentPadding3 = paddingValues;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                }
                if ((i & 8) != 0) {
                    long contentColor4 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1552getTopAppBarElevationD9Ej5fM();
                }
                contentPadding2 = i6 != 0 ? AppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    contentPadding2 = paddingValues;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    contentPadding2 = paddingValues;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(883764366, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:227)");
            }
            m1553AppBarHkEspTQ(backgroundColor2, contentColor2, elevation2, contentPadding2, RectangleShapeKt.getRectangleShape(), windowInsets, modifier2, function3, $composer2, (($dirty >> 6) & 14) | CpioConstants.C_ISBLK | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty << 15) & 458752) | (3670016 & ($dirty << 15)) | (($dirty << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            contentPadding3 = contentPadding2;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            final float f = elevation3;
            final PaddingValues paddingValues2 = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$4
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
                    AppBarKt.m1558TopAppBarafqeVBk(windowInsets, modifier4, j, j2, f, paddingValues2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    public static final void m1556TopAppBarHsRjFd4(Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        float elevation2;
        PaddingValues paddingValues;
        Modifier.Companion modifier3;
        long backgroundColor2;
        PaddingValues contentPadding2;
        Modifier modifier4;
        long backgroundColor3;
        PaddingValues contentPadding3;
        long contentColor3;
        float elevation3;
        Composer $composer2 = $composer.startRestartGroup(1897058582);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)269@12098L6,270@12147L32,275@12356L202:AppBar.kt#jmzs0o");
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
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j = backgroundColor;
                int i3 = $composer2.changed(j) ? 32 : 16;
                $dirty |= i3;
            } else {
                j = backgroundColor;
            }
            $dirty |= i3;
        } else {
            j = backgroundColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            elevation2 = elevation;
        } else if (($changed & 3072) == 0) {
            elevation2 = elevation;
            $dirty |= $composer2.changed(elevation2) ? 2048 : 1024;
        } else {
            elevation2 = elevation;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            paddingValues = contentPadding;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer2.changed(paddingValues) ? 16384 : 8192;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            contentColor3 = contentColor2;
            elevation3 = elevation2;
            contentPadding3 = paddingValues;
            backgroundColor3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                    $dirty &= -113;
                } else {
                    backgroundColor2 = j;
                }
                if ((i & 4) != 0) {
                    long contentColor4 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty >> 3) & 14);
                    $dirty &= -897;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1552getTopAppBarElevationD9Ej5fM();
                }
                contentPadding2 = i6 != 0 ? AppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    modifier3 = modifier2;
                    backgroundColor2 = j;
                    contentPadding2 = paddingValues;
                } else {
                    modifier3 = modifier2;
                    backgroundColor2 = j;
                    contentPadding2 = paddingValues;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897058582, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:274)");
            }
            m1553AppBarHkEspTQ(backgroundColor2, contentColor2, elevation2, contentPadding2, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier3, function3, $composer2, (($dirty >> 3) & 14) | 221184 | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 18) & 3670016) | (($dirty << 6) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            backgroundColor3 = backgroundColor2;
            contentPadding3 = contentPadding2;
            contentColor3 = contentColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j2 = backgroundColor3;
            final long j3 = contentColor3;
            final float f = elevation3;
            final PaddingValues paddingValues2 = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$5
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
                    AppBarKt.m1556TopAppBarHsRjFd4(modifier5, j2, j3, f, paddingValues2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:0x01dd  */
    /* JADX INFO: renamed from: BottomAppBar-DanWW-k, reason: not valid java name */
    public static final void m1554BottomAppBarDanWWk(final WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, Shape cutoutShape, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        Shape cutoutShape2;
        float elevation2;
        Modifier.Companion modifier2;
        PaddingValues contentPadding2;
        int $dirty;
        float elevation3;
        Shape shape;
        Modifier modifier3;
        float elevation4;
        PaddingValues contentPadding3;
        long backgroundColor3;
        long contentColor3;
        Shape cutoutShape3;
        Composer $composer2 = $composer.startRestartGroup(382658343);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)335@15300L6,336@15349L32,342@15630L7,348@15820L174:AppBar.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(windowInsets) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                int i3 = $composer2.changed(backgroundColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            cutoutShape2 = cutoutShape;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            cutoutShape2 = cutoutShape;
            $dirty2 |= $composer2.changed(cutoutShape2) ? 16384 : 8192;
        } else {
            cutoutShape2 = cutoutShape;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            elevation2 = elevation;
        } else if ((196608 & $changed) == 0) {
            elevation2 = elevation;
            $dirty2 |= $composer2.changed(elevation2) ? 131072 : 65536;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(contentPadding) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            contentPadding3 = contentPadding;
            contentColor3 = contentColor2;
            cutoutShape3 = cutoutShape2;
            elevation4 = elevation2;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                }
                if ((i & 8) != 0) {
                    long contentColor4 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 6) & 14);
                    $dirty2 &= -7169;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    cutoutShape2 = null;
                }
                if (i6 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1551getBottomAppBarElevationD9Ej5fM();
                }
                if (i7 != 0) {
                    contentPadding2 = AppBarDefaults.INSTANCE.getContentPadding();
                    $dirty = $dirty2;
                    elevation3 = elevation2;
                } else {
                    contentPadding2 = contentPadding;
                    $dirty = $dirty2;
                    elevation3 = elevation2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    contentPadding2 = contentPadding;
                    $dirty = $dirty2 & (-7169);
                    elevation3 = elevation2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    contentPadding2 = contentPadding;
                    $dirty = $dirty2;
                    elevation3 = elevation2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(382658343, $dirty, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:341)");
            }
            ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localFabPlacement);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FabPlacement fabPlacement = (FabPlacement) objConsume;
            if (cutoutShape2 != null) {
                boolean z = false;
                if (fabPlacement != null && fabPlacement.getIsDocked()) {
                    z = true;
                }
                if (z) {
                    shape = new BottomAppBarCutoutShape(cutoutShape2, fabPlacement);
                } else {
                    shape = RectangleShapeKt.getRectangleShape();
                }
            } else {
                shape = RectangleShapeKt.getRectangleShape();
            }
            m1553AppBarHkEspTQ(backgroundColor2, contentColor2, elevation3, contentPadding2, shape, windowInsets, modifier2, function3, $composer2, (($dirty >> 6) & 14) | (($dirty >> 6) & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 7168) | (($dirty << 15) & 458752) | (3670016 & ($dirty << 15)) | (29360128 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            elevation4 = elevation3;
            contentPadding3 = contentPadding2;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            cutoutShape3 = cutoutShape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            final Shape shape2 = cutoutShape3;
            final float f = elevation4;
            final PaddingValues paddingValues = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
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
                    AppBarKt.m1554BottomAppBarDanWWk(windowInsets, modifier4, j, j2, shape2, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x01b8  */
    /* JADX INFO: renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    public static final void m1555BottomAppBarY1yfwus(Modifier modifier, long backgroundColor, long contentColor, Shape cutoutShape, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        Shape cutoutShape2;
        float elevation2;
        PaddingValues paddingValues;
        Modifier.Companion modifier2;
        int $dirty;
        float elevation3;
        PaddingValues contentPadding2;
        Shape shape;
        Modifier modifier3;
        float elevation4;
        PaddingValues contentPadding3;
        long backgroundColor3;
        long contentColor3;
        Shape cutoutShape3;
        Composer $composer2 = $composer.startRestartGroup(-1651948973);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)403@18483L6,404@18532L32,410@18813L7,416@19003L172:AppBar.kt#jmzs0o");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                backgroundColor2 = backgroundColor;
                int i3 = $composer2.changed(backgroundColor2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            cutoutShape2 = cutoutShape;
        } else if (($changed & 3072) == 0) {
            cutoutShape2 = cutoutShape;
            $dirty2 |= $composer2.changed(cutoutShape2) ? 2048 : 1024;
        } else {
            cutoutShape2 = cutoutShape;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            elevation2 = elevation;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            elevation2 = elevation;
            $dirty2 |= $composer2.changed(elevation2) ? 16384 : 8192;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            paddingValues = contentPadding;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            paddingValues = contentPadding;
            $dirty2 |= $composer2.changed(paddingValues) ? 131072 : 65536;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentColor3 = contentColor2;
            cutoutShape3 = cutoutShape2;
            elevation4 = elevation2;
            contentPadding3 = paddingValues;
            modifier3 = modifier;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                }
                if ((i & 4) != 0) {
                    long contentColor4 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 3) & 14);
                    $dirty2 &= -897;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    cutoutShape2 = null;
                }
                if (i6 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1551getBottomAppBarElevationD9Ej5fM();
                }
                if (i7 != 0) {
                    contentPadding2 = AppBarDefaults.INSTANCE.getContentPadding();
                    $dirty = $dirty2;
                    elevation3 = elevation2;
                } else {
                    $dirty = $dirty2;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651948973, $dirty, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:409)");
            }
            ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localFabPlacement);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FabPlacement fabPlacement = (FabPlacement) objConsume;
            if (cutoutShape2 != null) {
                boolean z = false;
                if (fabPlacement != null && fabPlacement.getIsDocked()) {
                    z = true;
                }
                if (z) {
                    shape = new BottomAppBarCutoutShape(cutoutShape2, fabPlacement);
                } else {
                    shape = RectangleShapeKt.getRectangleShape();
                }
            } else {
                shape = RectangleShapeKt.getRectangleShape();
            }
            m1553AppBarHkEspTQ(backgroundColor2, contentColor2, elevation3, contentPadding2, shape, ZeroInsets, modifier2, function3, $composer2, (($dirty >> 3) & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21 | (($dirty >> 3) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty << 18) & 3670016) | (29360128 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            elevation4 = elevation3;
            contentPadding3 = contentPadding2;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            cutoutShape3 = cutoutShape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            final Shape shape2 = cutoutShape3;
            final float f = elevation4;
            final PaddingValues paddingValues2 = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$2
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
                    AppBarKt.m1555BottomAppBarY1yfwus(modifier4, j, j2, shape2, f, paddingValues2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final float square(float x) {
        return x * x;
    }

    public static final float calculateCutoutCircleYIntercept(float cutoutRadius, float verticalOffset) {
        return -((float) Math.sqrt((cutoutRadius * cutoutRadius) - (verticalOffset * verticalOffset)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float controlPointX, float verticalOffset, float radius) {
        Float fValueOf;
        Float fValueOf2;
        Pair pairM202to;
        Float fValueOf3;
        Float fValueOf4;
        float discriminant = verticalOffset * verticalOffset * radius * radius * (((controlPointX * controlPointX) + (verticalOffset * verticalOffset)) - (radius * radius));
        float divisor = (controlPointX * controlPointX) + (verticalOffset * verticalOffset);
        float bCoefficient = radius * radius * controlPointX;
        float xSolutionA = (bCoefficient - ((float) Math.sqrt(discriminant))) / divisor;
        float xSolutionB = (((float) Math.sqrt(discriminant)) + bCoefficient) / divisor;
        float ySolutionA = (float) Math.sqrt((radius * radius) - (xSolutionA * xSolutionA));
        float ySolutionB = (float) Math.sqrt((radius * radius) - (xSolutionB * xSolutionB));
        if (verticalOffset > 0.0f) {
            if (ySolutionA > ySolutionB) {
                fValueOf3 = Float.valueOf(xSolutionA);
                fValueOf4 = Float.valueOf(ySolutionA);
            } else {
                fValueOf3 = Float.valueOf(xSolutionB);
                fValueOf4 = Float.valueOf(ySolutionB);
            }
            pairM202to = TuplesKt.m202to(fValueOf3, fValueOf4);
        } else {
            if (ySolutionA < ySolutionB) {
                fValueOf = Float.valueOf(xSolutionA);
                fValueOf2 = Float.valueOf(ySolutionA);
            } else {
                fValueOf = Float.valueOf(xSolutionB);
                fValueOf2 = Float.valueOf(ySolutionB);
            }
            pairM202to = TuplesKt.m202to(fValueOf, fValueOf2);
        }
        float xSolution = ((Number) pairM202to.component1()).floatValue();
        float ySolution = ((Number) pairM202to.component2()).floatValue();
        float adjustedYSolution = xSolution < controlPointX ? -ySolution : ySolution;
        return TuplesKt.m202to(Float.valueOf(xSolution), Float.valueOf(adjustedYSolution));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: AppBar-HkEspTQ, reason: not valid java name */
    public static final void m1553AppBarHkEspTQ(final long backgroundColor, final long contentColor, final float elevation, final PaddingValues contentPadding, final Shape shape, final WindowInsets windowInsets, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-712505634);
        ComposerKt.sourceInformation($composer2, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,7,5)726@31738L492,720@31571L659:AppBar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(backgroundColor) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(elevation) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(contentPadding) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(shape) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(windowInsets) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty |= 1572864;
            modifier2 = modifier;
        } else if (($changed & 1572864) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty) != 4793490 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712505634, $dirty, -1, "androidx.compose.material.AppBar (AppBar.kt:719)");
            }
            SurfaceKt.m1809SurfaceFjzlyU(modifier2, shape, backgroundColor, contentColor, null, elevation, ComposableLambdaKt.rememberComposableLambda(213273114, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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
                    ComposerKt.sourceInformation($composer3, "C727@31813L6,727@31821L403,727@31748L476:AppBar.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(213273114, $changed2, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:727)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer3, 6)));
                        final WindowInsets windowInsets2 = windowInsets;
                        final PaddingValues paddingValues = contentPadding;
                        final Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(600325466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C728@31835L379:AppBar.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(600325466, $changed3, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:728)");
                                    }
                                    Modifier modifier$iv = SizeKt.m899height3ABfNKs(PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets2), paddingValues), AppBarKt.AppBarHeight);
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                    int $changed$iv$iv = (432 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        $composer4.createNode(constructor);
                                    } else {
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    function5.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 18) & 14) | 1572864 | (($dirty >> 9) & 112) | (($dirty << 6) & 896) | (($dirty << 6) & 7168) | (458752 & ($dirty << 9)), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
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

                public final void invoke(Composer composer, int i3) {
                    AppBarKt.m1553AppBarHkEspTQ(backgroundColor, contentColor, elevation, contentPadding, shape, windowInsets, modifier4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    static {
        Modifier.Companion companion = Modifier.INSTANCE;
        float arg0$iv = C1979Dp.m6801constructorimpl(16);
        float other$iv = AppBarHorizontalPadding;
        TitleInsetWithoutIcon = SizeKt.m918width3ABfNKs(companion, C1979Dp.m6801constructorimpl(arg0$iv - other$iv));
        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(72);
        float other$iv2 = AppBarHorizontalPadding;
        TitleIconModifier = SizeKt.m918width3ABfNKs(modifierFillMaxHeight$default, C1979Dp.m6801constructorimpl(arg0$iv2 - other$iv2));
        BottomAppBarCutoutOffset = C1979Dp.m6801constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = C1979Dp.m6801constructorimpl(4);
        ZeroInsets = WindowInsetsKt.m938WindowInsetsa9UjIt4$default(C1979Dp.m6801constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null);
    }
}
