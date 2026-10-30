package com.videshkarmakar.loop.ui.component;

import android.graphics.Path;
import android.view.animation.PathInterpolator;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TopAppBar.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001ak\u0010\u0007\u001a\u00020\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u000b2\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001au\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u000b2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b\u000b2\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0018\"\u001d\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"fraction", "Lkotlin/Function1;", "", "getFraction", "()Lkotlin/jvm/functions/Function1;", DownloadUtil.CookieScheme.PATH, "Landroid/graphics/Path;", "LargeTopAppBar", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", "actions", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "titleText", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/material3/TopAppBarScrollBehavior;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TopAppBarKt {
    private static final Function1<Float, Float> fraction;
    private static final Path path;

    public static final void LargeTopAppBar(final Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5;
        TopAppBarScrollBehavior scrollBehavior2;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function2M7152getLambda1$app_debug;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M7153getLambda2$app_debug;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(1099339842);
        ComposerKt.sourceInformation($composer2, "C(LargeTopAppBar)P(4,1,2)27@1076L182:TopAppBar.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(title) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function4 = function2;
        } else if (($changed & 896) == 0) {
            function4 = function2;
            $dirty |= $composer2.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function5 = function3;
        } else if (($changed & 7168) == 0) {
            function5 = function3;
            $dirty |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            scrollBehavior2 = scrollBehavior;
        } else if ((57344 & $changed) == 0) {
            scrollBehavior2 = scrollBehavior;
            $dirty |= $composer2.changed(scrollBehavior2) ? 16384 : 8192;
        } else {
            scrollBehavior2 = scrollBehavior;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function2M7152getLambda1$app_debug = function4;
            function3M7153getLambda2$app_debug = function5;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            function2M7152getLambda1$app_debug = i3 != 0 ? ComposableSingletons$TopAppBarKt.INSTANCE.m7152getLambda1$app_debug() : function4;
            function3M7153getLambda2$app_debug = i4 != 0 ? ComposableSingletons$TopAppBarKt.INSTANCE.m7153getLambda2$app_debug() : function5;
            TopAppBarScrollBehavior scrollBehavior3 = i5 != 0 ? null : scrollBehavior2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1099339842, $dirty2, -1, "com.videshkarmakar.loop.ui.component.LargeTopAppBar (TopAppBar.kt:26)");
            }
            AppBarKt.m1672LargeTopAppBaroKE7A98(title, modifier3, function2M7152getLambda1$app_debug, function3M7153getLambda2$app_debug, 0.0f, 0.0f, null, null, scrollBehavior3, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (($dirty2 << 12) & 234881024), 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scrollBehavior2 = scrollBehavior3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function6 = function2M7152getLambda1$app_debug;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7 = function3M7153getLambda2$app_debug;
            final TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TopAppBarKt.LargeTopAppBar.1
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
                    TopAppBarKt.LargeTopAppBar(title, modifier4, function6, function7, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    static {
        Path $this$path_u24lambda_u240 = new Path();
        $this$path_u24lambda_u240.moveTo(0.0f, 0.0f);
        $this$path_u24lambda_u240.lineTo(0.7f, 0.1f);
        $this$path_u24lambda_u240.cubicTo(0.7f, 0.1f, 0.95f, 0.5f, 1.0f, 1.0f);
        $this$path_u24lambda_u240.moveTo(1.0f, 1.0f);
        path = $this$path_u24lambda_u240;
        fraction = new Function1<Float, Float>() { // from class: com.videshkarmakar.loop.ui.component.TopAppBarKt$fraction$1
            public final Float invoke(float it) {
                return Float.valueOf(new PathInterpolator(TopAppBarKt.path).getInterpolation(it));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        };
    }

    public static final Function1<Float, Float> getFraction() {
        return fraction;
    }

    public static final void SmallTopAppBar(Modifier modifier, String titleText, TopAppBarScrollBehavior scrollBehavior, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String titleText2;
        final TopAppBarScrollBehavior scrollBehavior2;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function2M7154getLambda3$app_debug;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5;
        final String titleText3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M7155getLambda4$app_debug;
        Function2<? super Composer, ? super Integer, Unit> function8;
        String titleText4;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Modifier modifier3;
        TopAppBarScrollBehavior scrollBehavior3;
        Composer $composer2 = $composer.startRestartGroup(626662209);
        ComposerKt.sourceInformation($composer2, "C(SmallTopAppBar)P(1,5,3,4,2)51@1683L22,52@1743L207,62@2060L176:TopAppBar.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            titleText2 = titleText;
        } else if (($changed & 112) == 0) {
            titleText2 = titleText;
            $dirty |= $composer2.changed(titleText2) ? 32 : 16;
        } else {
            titleText2 = titleText;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                scrollBehavior2 = scrollBehavior;
                int i4 = $composer2.changed(scrollBehavior2) ? 256 : 128;
                $dirty |= i4;
            } else {
                scrollBehavior2 = scrollBehavior;
            }
            $dirty |= i4;
        } else {
            scrollBehavior2 = scrollBehavior;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            function2RememberComposableLambda = function2;
        } else if (($changed & 7168) == 0) {
            function2RememberComposableLambda = function2;
            $dirty |= $composer2.changedInstance(function2RememberComposableLambda) ? 2048 : 1024;
        } else {
            function2RememberComposableLambda = function2;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function2M7154getLambda3$app_debug = function3;
        } else if ((57344 & $changed) == 0) {
            function2M7154getLambda3$app_debug = function3;
            $dirty |= $composer2.changedInstance(function2M7154getLambda3$app_debug) ? 16384 : 8192;
        } else {
            function2M7154getLambda3$app_debug = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function4;
        } else if ((458752 & $changed) == 0) {
            function5 = function4;
            $dirty |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function4;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            scrollBehavior3 = scrollBehavior2;
            function9 = function2M7154getLambda3$app_debug;
            function8 = function2RememberComposableLambda;
            titleText4 = titleText2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    titleText2 = "";
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    scrollBehavior2 = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer2, TopAppBarDefaults.$stable << 6, 3);
                }
                if (i5 != 0) {
                    titleText3 = titleText2;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2131334837, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TopAppBarKt.SmallTopAppBar.1
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
                            ComposerKt.sourceInformation($composer3, "C55@1823L11,53@1753L191:TopAppBar.kt#g7nzpb");
                            if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2131334837, $changed2, -1, "com.videshkarmakar.loop.ui.component.SmallTopAppBar.<anonymous> (TopAppBar.kt:53)");
                                }
                                String str = titleText3;
                                long onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
                                TextKt.m2569Text4IGK_g(str, (Modifier) null, Color.m4041copywmQWz5c(onSurface, (14 & 1) != 0 ? Color.m4045getAlphaimpl(onSurface) : TopAppBarKt.getFraction().invoke(Float.valueOf(scrollBehavior2.getState().getOverlappedFraction())).floatValue(), (14 & 2) != 0 ? Color.m4049getRedimpl(onSurface) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(onSurface) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(onSurface) : 0.0f), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 3072, 122874);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }, $composer2, 54);
                } else {
                    titleText3 = titleText2;
                }
                if (i6 != 0) {
                    function2M7154getLambda3$app_debug = ComposableSingletons$TopAppBarKt.INSTANCE.m7154getLambda3$app_debug();
                }
                if (i7 != 0) {
                    modifier2 = modifier4;
                    function3M7155getLambda4$app_debug = ComposableSingletons$TopAppBarKt.INSTANCE.m7155getLambda4$app_debug();
                    function6 = function2RememberComposableLambda;
                    function7 = function2M7154getLambda3$app_debug;
                } else {
                    modifier2 = modifier4;
                    function6 = function2RememberComposableLambda;
                    function7 = function2M7154getLambda3$app_debug;
                    function3M7155getLambda4$app_debug = function5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    titleText3 = titleText2;
                    function6 = function2RememberComposableLambda;
                    function7 = function2M7154getLambda3$app_debug;
                    function3M7155getLambda4$app_debug = function5;
                } else {
                    titleText3 = titleText2;
                    function6 = function2RememberComposableLambda;
                    function7 = function2M7154getLambda3$app_debug;
                    function3M7155getLambda4$app_debug = function5;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626662209, $dirty2, -1, "com.videshkarmakar.loop.ui.component.SmallTopAppBar (TopAppBar.kt:61)");
            }
            AppBarKt.m1675TopAppBarGHTll3U(function6, modifier2, function7, function3M7155getLambda4$app_debug, 0.0f, null, null, scrollBehavior2, $composer2, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 6) & 896) | (($dirty2 >> 6) & 7168) | (($dirty2 << 15) & 29360128), 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = function6;
            titleText4 = titleText3;
            function9 = function7;
            modifier3 = modifier2;
            function5 = function3M7155getLambda4$app_debug;
            scrollBehavior3 = scrollBehavior2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str = titleText4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior3;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function12 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TopAppBarKt.SmallTopAppBar.2
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
                    TopAppBarKt.SmallTopAppBar(modifier5, str, topAppBarScrollBehavior, function10, function11, function12, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
