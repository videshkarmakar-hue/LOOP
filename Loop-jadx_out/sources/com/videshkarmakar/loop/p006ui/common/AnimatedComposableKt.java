package com.videshkarmakar.loop.p006ui.common;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.runtime.Composer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.videshkarmakar.loop.p006ui.common.motion.AnimationSpecsKt;
import com.videshkarmakar.loop.p006ui.common.motion.MaterialSharedAxisKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedComposable.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(m194d1 = {"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a[\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f¢\u0006\u0002\u0010 \u001a[\u0010!\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f¢\u0006\u0002\u0010 \u001a[\u0010\"\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f¢\u0006\u0002\u0010 \u001a[\u0010#\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f¢\u0006\u0002\u0010 \u001a[\u0010$\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001f¢\u0006\u0002\u0010 \"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, m195d2 = {"DURATION_ENTER", "", "DURATION_EXIT", "enterTween", "Landroidx/compose/animation/core/TweenSpec;", "Landroidx/compose/ui/unit/IntOffset;", "exitTween", "fadeSpec", "", "fadeSpring", "Landroidx/compose/animation/core/SpringSpec;", "fadeTween", "initialOffset", "springSpec", "getSpringSpec", "()Landroidx/compose/animation/core/SpringSpec;", "animatedComposable", "", "Landroidx/navigation/NavGraphBuilder;", "route", "", "arguments", "", "Landroidx/navigation/NamedNavArgument;", "deepLinks", "Landroidx/navigation/NavDeepLink;", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "animatedComposableLegacy", "animatedComposableVariant", "fadeThroughComposable", "slideInVerticallyComposable", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnimatedComposableKt {
    public static final int DURATION_ENTER = 400;
    public static final int DURATION_EXIT = 200;
    public static final float initialOffset = 0.1f;
    private static final TweenSpec<IntOffset> enterTween = AnimationSpecKt.tween$default(400, 0, AnimationSpecsKt.getEmphasizeEasing(), 2, null);
    private static final TweenSpec<IntOffset> exitTween = AnimationSpecKt.tween$default(200, 0, AnimationSpecsKt.getEmphasizeEasing(), 2, null);
    private static final SpringSpec<Float> fadeSpring = AnimationSpecKt.spring$default(1.0f, 1500.0f, null, 4, null);
    private static final TweenSpec<Float> fadeTween = AnimationSpecKt.tween$default(200, 0, null, 6, null);
    private static final TweenSpec<Float> fadeSpec = fadeTween;
    private static final SpringSpec<IntOffset> springSpec = AnimationSpecKt.spring$default(0.0f, 1500.0f, IntOffset.m6924boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);

    public static /* synthetic */ void fadeThroughComposable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        fadeThroughComposable(navGraphBuilder, str, list, list2, function4);
    }

    public static final void fadeThroughComposable(NavGraphBuilder $this$fadeThroughComposable, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function4<? super AnimatedVisibilityScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$fadeThroughComposable, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(content, "content");
        NavGraphBuilderKt.composable($this$fadeThroughComposable, route, arguments, deepLinks, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.fadeThroughComposable.1
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m320scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null));
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.fadeThroughComposable.2
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.fadeThroughComposable.3
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m320scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null));
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.fadeThroughComposable.4
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null);
            }
        }, content);
    }

    public static /* synthetic */ void animatedComposable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        animatedComposable(navGraphBuilder, str, list, list2, function4);
    }

    public static final void animatedComposable(NavGraphBuilder $this$animatedComposable, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function4<? super AnimatedVisibilityScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$animatedComposable, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(content, "content");
        NavGraphBuilderKt.composable($this$animatedComposable, route, arguments, deepLinks, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.1
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return MaterialSharedAxisKt.materialSharedAxisXIn$default(new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.1.1
                    public final Integer invoke(int it) {
                        return Integer.valueOf((int) (it * 0.1f));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                }, 0, 2, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.2
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return MaterialSharedAxisKt.materialSharedAxisXOut$default(new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.2.1
                    public final Integer invoke(int it) {
                        return Integer.valueOf(-((int) (it * 0.1f)));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                }, 0, 2, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.3
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return MaterialSharedAxisKt.materialSharedAxisXIn$default(new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.3.1
                    public final Integer invoke(int it) {
                        return Integer.valueOf(-((int) (it * 0.1f)));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                }, 0, 2, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.4
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return MaterialSharedAxisKt.materialSharedAxisXOut$default(new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposable.4.1
                    public final Integer invoke(int it) {
                        return Integer.valueOf((int) (it * 0.1f));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                }, 0, 2, null);
            }
        }, content);
    }

    public static /* synthetic */ void animatedComposableLegacy$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        animatedComposableLegacy(navGraphBuilder, str, list, list2, function4);
    }

    public static final void animatedComposableLegacy(NavGraphBuilder $this$animatedComposableLegacy, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function4<? super AnimatedVisibilityScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$animatedComposableLegacy, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(content, "content");
        NavGraphBuilderKt.composable($this$animatedComposableLegacy, route, arguments, deepLinks, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.1
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideInHorizontally(AnimatedComposableKt.enterTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf((int) (it * 0.1f));
                    }
                }).plus(EnterExitTransitionKt.fadeIn$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null));
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.2
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideOutHorizontally(AnimatedComposableKt.exitTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf(-((int) (it * 0.1f)));
                    }
                }).plus(EnterExitTransitionKt.fadeOut$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null));
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.3
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideInHorizontally(AnimatedComposableKt.enterTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.3.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf(-((int) (it * 0.1f)));
                    }
                }).plus(EnterExitTransitionKt.fadeIn$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null));
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.4
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideOutHorizontally(AnimatedComposableKt.exitTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableLegacy.4.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf((int) (it * 0.1f));
                    }
                }).plus(EnterExitTransitionKt.fadeOut$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null));
            }
        }, content);
    }

    public static /* synthetic */ void animatedComposableVariant$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        animatedComposableVariant(navGraphBuilder, str, list, list2, function4);
    }

    public static final void animatedComposableVariant(NavGraphBuilder $this$animatedComposableVariant, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function4<? super AnimatedVisibilityScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$animatedComposableVariant, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(content, "content");
        NavGraphBuilderKt.composable($this$animatedComposableVariant, route, arguments, deepLinks, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableVariant.1
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideInHorizontally(AnimatedComposableKt.enterTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableVariant.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf((int) (it * 0.1f));
                    }
                }).plus(EnterExitTransitionKt.fadeIn$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null));
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableVariant.2
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.fadeOut$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableVariant.3
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.fadeIn$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableVariant.4
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideOutHorizontally(AnimatedComposableKt.exitTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.animatedComposableVariant.4.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf((int) (it * 0.1f));
                    }
                }).plus(EnterExitTransitionKt.fadeOut$default(AnimatedComposableKt.fadeSpec, 0.0f, 2, null));
            }
        }, content);
    }

    public static final SpringSpec<IntOffset> getSpringSpec() {
        return springSpec;
    }

    public static /* synthetic */ void slideInVerticallyComposable$default(NavGraphBuilder navGraphBuilder, String str, List list, List list2, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        slideInVerticallyComposable(navGraphBuilder, str, list, list2, function4);
    }

    public static final void slideInVerticallyComposable(NavGraphBuilder $this$slideInVerticallyComposable, String route, List<NamedNavArgument> arguments, List<NavDeepLink> deepLinks, Function4<? super AnimatedVisibilityScope, ? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$slideInVerticallyComposable, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        Intrinsics.checkNotNullParameter(content, "content");
        NavGraphBuilderKt.composable($this$slideInVerticallyComposable, route, arguments, deepLinks, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.slideInVerticallyComposable.1
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideInVertically(AnimatedComposableKt.enterTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.slideInVerticallyComposable.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf(it);
                    }
                }).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.slideInVerticallyComposable.2
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideOutVertically$default(null, null, 3, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.slideInVerticallyComposable.3
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideInVertically$default(null, null, 3, null);
            }
        }, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.slideInVerticallyComposable.4
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> composable) {
                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                return EnterExitTransitionKt.slideOutVertically(AnimatedComposableKt.enterTween, new Function1<Integer, Integer>() { // from class: com.videshkarmakar.loop.ui.common.AnimatedComposableKt.slideInVerticallyComposable.4.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int it) {
                        return Integer.valueOf(it);
                    }
                }).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            }
        }, content);
    }
}
