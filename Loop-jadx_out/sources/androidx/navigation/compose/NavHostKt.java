package androidx.navigation.compose;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NavHost.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0011\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0013\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aÚ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0011\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0013\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00102\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u00102\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000f*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010 \u001a\u0004\u0018\u00010\u0012*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010!\u001a\u0004\u0018\u00010\u000f*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010\"\u001a\u0004\u0018\u00010\u0012*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¨\u0006#²\u0006\u0010\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%X\u008a\u0084\u0002²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0%X\u008a\u0084\u0002²\u0006\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0%X\u008a\u0084\u0002"}, m195d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/ExtensionFunctionType;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "startDestination", "", "route", "builder", "Landroidx/navigation/NavGraphBuilder;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createEnterTransition", "Landroidx/navigation/NavDestination;", "scope", "createExitTransition", "createPopEnterTransition", "createPopExitTransition", "navigation-compose_release", "currentBackStack", "", "allVisibleEntries", "visibleEntries"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NavHostKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    public static final /* synthetic */ void NavHost(final NavHostController navController, final String startDestination, Modifier modifier, String route, final Function1 builder, Composer $composer, final int $changed, final int i) throws Throwable {
        Modifier modifier2;
        String route2;
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(141827520);
        ComposerKt.sourceInformation($composer2, "C(NavHost)P(2,4,1,3)83@3291L126,81@3251L190:NavHost.kt#opm8kd");
        if ((i & 4) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) == 0) {
            route2 = route;
        } else {
            route2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(141827520, $changed, -1, "androidx.navigation.compose.NavHost (NavHost.kt:80)");
        }
        int i2 = (($changed >> 9) & 14) | ($changed & 112) | (($changed >> 6) & 896);
        $composer2.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(route2) | $composer2.changed(startDestination) | $composer2.changed(builder);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            NavHostController $this$createGraph$iv = navController;
            NavigatorProvider $this$navigation$iv$iv = $this$createGraph$iv.get_navigatorProvider();
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder($this$navigation$iv$iv, startDestination, route2);
            builder.invoke(navGraphBuilder);
            value$iv$iv = navGraphBuilder.build();
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        NavHost(navController, (NavGraph) value$iv$iv, modifier2, null, null, null, null, null, $composer2, ($changed & 896) | 72, 248);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final String str = route2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) throws Throwable {
                NavHostKt.NavHost(navController, startDestination, modifier3, str, builder, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void NavHost(final NavHostController navController, final String startDestination, Modifier modifier, Alignment contentAlignment, String route, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function2, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function3, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function4, final Function1<? super NavGraphBuilder, Unit> function5, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Alignment contentAlignment2;
        String route2;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function6;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function7;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function8;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function9;
        int $dirty;
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(410432995);
        ComposerKt.sourceInformation($composer2, "C(NavHost)P(5,9,4,1,8,2,3,6,7)129@5380L126,127@5340L320:NavHost.kt#opm8kd");
        int $dirty2 = $changed;
        if ((i & 4) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) == 0) {
            contentAlignment2 = contentAlignment;
        } else {
            contentAlignment2 = Alignment.INSTANCE.getCenter();
        }
        if ((i & 16) == 0) {
            route2 = route;
        } else {
            route2 = null;
        }
        if ((i & 32) == 0) {
            function6 = function1;
        } else {
            function6 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.3
                @Override // kotlin.jvm.functions.Function1
                public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                    return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
                }
            };
        }
        if ((i & 64) == 0) {
            function7 = function2;
        } else {
            function7 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.4
                @Override // kotlin.jvm.functions.Function1
                public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                    return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
                }
            };
        }
        if ((i & 128) == 0) {
            function8 = function3;
        } else {
            $dirty2 &= -29360129;
            function8 = function6;
        }
        if ((i & 256) == 0) {
            function9 = function4;
            $dirty = $dirty2;
        } else {
            $dirty = $dirty2 & (-234881025);
            function9 = function7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(410432995, $dirty, -1, "androidx.navigation.compose.NavHost (NavHost.kt:126)");
        }
        int i2 = (($dirty >> 12) & 14) | ($dirty & 112) | (($dirty >> 21) & 896);
        $composer2.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(route2) | $composer2.changed(startDestination) | $composer2.changed(function5);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            NavHostController $this$createGraph$iv = navController;
            NavigatorProvider $this$navigation$iv$iv = $this$createGraph$iv.get_navigatorProvider();
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder($this$navigation$iv$iv, startDestination, route2);
            function5.invoke(navGraphBuilder);
            value$iv$iv = navGraphBuilder.build();
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        final String route3 = route2;
        NavHost(navController, (NavGraph) value$iv$iv, modifier2, contentAlignment2, function6, function7, function8, function9, $composer2, ($dirty & 896) | 72 | ($dirty & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016) | (29360128 & ($dirty >> 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final Alignment alignment = contentAlignment2;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function10 = function6;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function11 = function7;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function12 = function8;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function13 = function9;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.6
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
                NavHostKt.NavHost(navController, startDestination, modifier3, alignment, route3, function10, function11, function12, function13, function5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    public static final /* synthetic */ void NavHost(final NavHostController navController, final NavGraph graph, Modifier modifier, Composer $composer, final int $changed, final int i) throws Throwable {
        Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(-957014592);
        ComposerKt.sourceInformation($composer2, "C(NavHost)P(2)163@6434L39:NavHost.kt#opm8kd");
        if ((i & 4) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-957014592, $changed, -1, "androidx.navigation.compose.NavHost (NavHost.kt:163)");
        }
        NavHost(navController, graph, modifier2, null, null, null, null, null, $composer2, ($changed & 896) | 72, 248);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) throws Throwable {
                NavHostKt.NavHost(navController, graph, modifier3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void NavHost(final NavHostController navController, final NavGraph graph, Modifier modifier, Alignment contentAlignment, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function1, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function2, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function3, Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function4, Composer $composer, final int $changed, final int i) throws Throwable {
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function5;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function6;
        int $dirty;
        Object value$iv$iv;
        Object value$iv$iv2;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function7;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function8;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function9;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function10;
        DialogNavigator dialogNavigator;
        Object value$iv$iv3;
        Composer $composer2 = $composer.startRestartGroup(-1818191915);
        ComposerKt.sourceInformation($composer2, "C(NavHost)P(5,3,4)197@8123L7,*198@8199L7,213@8790L16,215@8812L83,219@8901L172,225@9105L29,227@9194L16,230@9299L186,240@9580L42,334@14081L27:NavHost.kt#opm8kd");
        int $dirty2 = $changed;
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment contentAlignment2 = (i & 8) != 0 ? Alignment.INSTANCE.getCenter() : contentAlignment;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function11 = (i & 16) != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.8
            @Override // kotlin.jvm.functions.Function1
            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
            }
        } : function1;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function12 = (i & 32) != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.9
            @Override // kotlin.jvm.functions.Function1
            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
            }
        } : function2;
        if ((i & 64) != 0) {
            $dirty2 &= -3670017;
            function5 = function11;
        } else {
            function5 = function3;
        }
        if ((i & 128) != 0) {
            $dirty = $dirty2 & (-29360129);
            function6 = function12;
        } else {
            function6 = function4;
            $dirty = $dirty2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1818191915, $dirty, -1, "androidx.navigation.compose.NavHost (NavHost.kt:195)");
        }
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer2.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        final LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume;
        ViewModelStoreOwner viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, LocalViewModelStoreOwner.$stable);
        if (viewModelStoreOwner == null) {
            throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner".toString());
        }
        navController.setViewModelStore(viewModelStoreOwner.getViewModelStore());
        navController.setGraph(graph);
        NavigatorProvider $this$get$iv = navController.get_navigatorProvider();
        Navigator navigator = $this$get$iv.getNavigator(ComposeNavigator.NAME);
        ComposeNavigator composeNavigator = navigator instanceof ComposeNavigator ? (ComposeNavigator) navigator : null;
        if (composeNavigator == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final Modifier modifier3 = modifier2;
            final Alignment alignment = contentAlignment2;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function13 = function11;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function14 = function12;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function15 = function6;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function16 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i2) throws Throwable {
                    NavHostKt.NavHost(navController, graph, modifier3, alignment, function13, function14, function16, function15, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
            return;
        }
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function17 = function6;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function18 = function5;
        Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function19 = function12;
        final Modifier modifier4 = modifier2;
        final Alignment contentAlignment3 = contentAlignment2;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function20 = function11;
        int $dirty3 = $dirty;
        final ComposeNavigator composeNavigator2 = composeNavigator;
        State currentBackStack$delegate = SnapshotStateKt.collectAsState(composeNavigator2.getBackStack(), null, $composer2, 8, 1);
        BackHandlerKt.BackHandler(NavHost$lambda$3(currentBackStack$delegate).size() > 1, new Function0<Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.10
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                navController.popBackStack();
            }
        }, $composer2, 0, 0);
        EffectsKt.DisposableEffect(lifecycleOwner, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                navController.setLifecycleOwner(lifecycleOwner);
                return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$11$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, $composer2, 8);
        final SaveableStateHolder saveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder($composer2, 0);
        final State allVisibleEntries$delegate = SnapshotStateKt.collectAsState(navController.getVisibleEntries(), null, $composer2, 8, 1);
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer2.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt.derivedStateOf(new Function0<List<? extends NavBackStackEntry>>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$visibleEntries$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends NavBackStackEntry> invoke() {
                    Iterable $this$filter$iv = NavHostKt.NavHost$lambda$4(allVisibleEntries$delegate);
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        NavBackStackEntry entry = (NavBackStackEntry) element$iv$iv;
                        if (Intrinsics.areEqual(entry.getDestination().getNavigatorName(), ComposeNavigator.NAME)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    return (List) destination$iv$iv;
                }
            });
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        final State visibleEntries$delegate = (State) value$iv$iv;
        NavBackStackEntry backStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) NavHost$lambda$6(visibleEntries$delegate));
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer2.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new LinkedHashMap();
            $composer2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer2.endReplaceableGroup();
        final Map zIndices = (Map) value$iv$iv2;
        $composer2.startReplaceableGroup(1822177954);
        ComposerKt.sourceInformation($composer2, "243@9756L577,257@10431L577,271@11035L49,272@11104L2105,310@13218L441,320@13691L182,320@13668L205");
        if (backStackEntry != null) {
            int i2 = (($dirty3 >> 15) & 112) | (($dirty3 >> 6) & 896);
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(composeNavigator2) | $composer2.changed(function18) | $composer2.changed(function20);
            Object value$iv$iv4 = $composer2.rememberedValue();
            if (invalid$iv$iv || value$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = (Function1) new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$finalEnter$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                        NavDestination destination = animatedContentTransitionScope.getTargetState().getDestination();
                        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                        ComposeNavigator.Destination targetDestination = (ComposeNavigator.Destination) destination;
                        EnterTransition enterTransition = null;
                        if (composeNavigator2.isPop$navigation_compose_release().getValue().booleanValue()) {
                            for (NavDestination destination2 : NavDestination.INSTANCE.getHierarchy(targetDestination)) {
                                EnterTransition enterTransitionCreatePopEnterTransition = NavHostKt.createPopEnterTransition(destination2, animatedContentTransitionScope);
                                if (enterTransitionCreatePopEnterTransition != null) {
                                    enterTransition = enterTransitionCreatePopEnterTransition;
                                    break;
                                }
                            }
                            if (enterTransition != null) {
                                return enterTransition;
                            }
                            return function18.invoke(animatedContentTransitionScope);
                        }
                        for (NavDestination destination3 : NavDestination.INSTANCE.getHierarchy(targetDestination)) {
                            EnterTransition enterTransitionCreateEnterTransition = NavHostKt.createEnterTransition(destination3, animatedContentTransitionScope);
                            if (enterTransitionCreateEnterTransition != null) {
                                enterTransition = enterTransitionCreateEnterTransition;
                                break;
                            }
                        }
                        if (enterTransition != null) {
                            return enterTransition;
                        }
                        return function20.invoke(animatedContentTransitionScope);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv4);
            }
            $composer2.endReplaceableGroup();
            final Function1 finalEnter = (Function1) value$iv$iv4;
            int i3 = (($dirty3 >> 18) & 112) | (($dirty3 >> 9) & 896);
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            function10 = function19;
            boolean invalid$iv$iv2 = $composer2.changed(composeNavigator2) | $composer2.changed(function17) | $composer2.changed(function10);
            Object value$iv$iv5 = $composer2.rememberedValue();
            if (invalid$iv$iv2 || value$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv5 = (Function1) new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$finalExit$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                        NavDestination destination = animatedContentTransitionScope.getInitialState().getDestination();
                        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                        ComposeNavigator.Destination initialDestination = (ComposeNavigator.Destination) destination;
                        ExitTransition exitTransition = null;
                        if (composeNavigator2.isPop$navigation_compose_release().getValue().booleanValue()) {
                            for (NavDestination destination2 : NavDestination.INSTANCE.getHierarchy(initialDestination)) {
                                ExitTransition exitTransitionCreatePopExitTransition = NavHostKt.createPopExitTransition(destination2, animatedContentTransitionScope);
                                if (exitTransitionCreatePopExitTransition != null) {
                                    exitTransition = exitTransitionCreatePopExitTransition;
                                    break;
                                }
                            }
                            if (exitTransition != null) {
                                return exitTransition;
                            }
                            return function17.invoke(animatedContentTransitionScope);
                        }
                        for (NavDestination destination3 : NavDestination.INSTANCE.getHierarchy(initialDestination)) {
                            ExitTransition exitTransitionCreateExitTransition = NavHostKt.createExitTransition(destination3, animatedContentTransitionScope);
                            if (exitTransitionCreateExitTransition != null) {
                                exitTransition = exitTransitionCreateExitTransition;
                                break;
                            }
                        }
                        if (exitTransition != null) {
                            return exitTransition;
                        }
                        return function10.invoke(animatedContentTransitionScope);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv5);
            }
            $composer2.endReplaceableGroup();
            final Function1 finalExit = (Function1) value$iv$iv5;
            Transition transition = TransitionKt.updateTransition(backStackEntry, "entry", $composer2, 56, 0);
            function7 = function20;
            dialogNavigator = null;
            function8 = function17;
            function9 = function18;
            AnimatedContentKt.AnimatedContent(transition, modifier4, new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ContentTransform>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ContentTransform invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                    float initialZIndex;
                    float targetZIndex;
                    if (NavHostKt.NavHost$lambda$6(visibleEntries$delegate).contains(animatedContentTransitionScope.getInitialState())) {
                        Float f = zIndices.get(animatedContentTransitionScope.getInitialState().getId());
                        if (f != null) {
                            initialZIndex = f.floatValue();
                        } else {
                            zIndices.put(animatedContentTransitionScope.getInitialState().getId(), Float.valueOf(0.0f));
                            initialZIndex = 0.0f;
                        }
                        if (Intrinsics.areEqual(animatedContentTransitionScope.getTargetState().getId(), animatedContentTransitionScope.getInitialState().getId())) {
                            targetZIndex = initialZIndex;
                        } else {
                            targetZIndex = composeNavigator2.isPop$navigation_compose_release().getValue().booleanValue() ? initialZIndex - 1.0f : initialZIndex + 1.0f;
                        }
                        float it = targetZIndex;
                        zIndices.put(animatedContentTransitionScope.getTargetState().getId(), Float.valueOf(it));
                        return new ContentTransform(finalEnter.invoke(animatedContentTransitionScope), finalExit.invoke(animatedContentTransitionScope), targetZIndex, null, 8, null);
                    }
                    return AnimatedContentKt.togetherWith(EnterTransition.INSTANCE.getNone(), ExitTransition.INSTANCE.getNone());
                }
            }, contentAlignment3, new Function1<NavBackStackEntry, Object>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(NavBackStackEntry it) {
                    return it.getId();
                }
            }, ComposableLambdaKt.composableLambda($composer2, -1440061047, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.14
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                    invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final AnimatedContentScope $this$AnimatedContent, NavBackStackEntry it, Composer $composer3, int $changed2) {
                    Object element$iv;
                    NavBackStackEntry entry;
                    ComposerKt.sourceInformation($composer3, "C305@13019L180:NavHost.kt#opm8kd");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1440061047, $changed2, -1, "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:301)");
                    }
                    List $this$lastOrNull$iv = NavHostKt.NavHost$lambda$6(visibleEntries$delegate);
                    ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
                    do {
                        if (iterator$iv.hasPrevious()) {
                            element$iv = iterator$iv.previous();
                            entry = (NavBackStackEntry) element$iv;
                        } else {
                            element$iv = null;
                            break;
                        }
                    } while (!Intrinsics.areEqual(it, entry));
                    final NavBackStackEntry currentEntry = (NavBackStackEntry) element$iv;
                    if (currentEntry != null) {
                        NavBackStackEntryProviderKt.LocalOwnersProvider(currentEntry, saveableStateHolder, ComposableLambdaKt.composableLambda($composer3, -1425390790, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.14.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C307@13158L27:NavHost.kt#opm8kd");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1425390790, $changed3, -1, "androidx.navigation.compose.NavHost.<anonymous>.<anonymous> (NavHost.kt:306)");
                                    }
                                    NavDestination destination = currentEntry.getDestination();
                                    Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                    ((ComposeNavigator.Destination) destination).getContent$navigation_compose_release().invoke($this$AnimatedContent, currentEntry, $composer4, 72);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }), $composer3, 456);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, (($dirty3 >> 3) & 112) | 221184 | ($dirty3 & 7168), 0);
            EffectsKt.LaunchedEffect(transition.getCurrentState(), transition.getTargetState(), new C237315(transition, zIndices, visibleEntries$delegate, composeNavigator2, null), $composer2, 584);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            visibleEntries$delegate = visibleEntries$delegate;
            boolean invalid$iv$iv3 = $composer2.changed(visibleEntries$delegate) | $composer2.changed(composeNavigator2);
            Object it$iv$iv3 = $composer2.rememberedValue();
            if (invalid$iv$iv3 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$16$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final State<List<NavBackStackEntry>> state = visibleEntries$delegate;
                        final ComposeNavigator composeNavigator3 = composeNavigator2;
                        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$16$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                Iterable $this$forEach$iv = NavHostKt.NavHost$lambda$6(state);
                                for (Object element$iv : $this$forEach$iv) {
                                    NavBackStackEntry entry = (NavBackStackEntry) element$iv;
                                    composeNavigator3.onTransitionComplete(entry);
                                }
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.DisposableEffect((Object) true, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv3, $composer2, 6);
        } else {
            function7 = function20;
            function8 = function17;
            function9 = function18;
            function10 = function19;
            dialogNavigator = null;
        }
        $composer2.endReplaceableGroup();
        NavigatorProvider $this$get$iv2 = navController.get_navigatorProvider();
        Navigator navigator2 = $this$get$iv2.getNavigator(DialogNavigator.NAME);
        DialogNavigator dialogNavigator2 = navigator2 instanceof DialogNavigator ? (DialogNavigator) navigator2 : dialogNavigator;
        if (dialogNavigator2 == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 == null) {
                return;
            }
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function21 = function7;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function22 = function10;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function23 = function9;
            final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function24 = function8;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) throws Throwable {
                    NavHostKt.NavHost(navController, graph, modifier4, contentAlignment3, function21, function22, function23, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
            return;
        }
        DialogNavigator dialogNavigator3 = dialogNavigator2;
        DialogHostKt.DialogHost(dialogNavigator3, $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup3 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup3 == null) {
            return;
        }
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function25 = function7;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function26 = function10;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends EnterTransition> function27 = function9;
        final Function1<? super AnimatedContentTransitionScope<NavBackStackEntry>, ? extends ExitTransition> function28 = function8;
        scopeUpdateScopeEndRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) throws Throwable {
                NavHostKt.NavHost(navController, graph, modifier4, contentAlignment3, function25, function26, function27, function28, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    private static final List<NavBackStackEntry> NavHost$lambda$3(State<? extends List<NavBackStackEntry>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$4(State<? extends List<NavBackStackEntry>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$6(State<? extends List<NavBackStackEntry>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: renamed from: androidx.navigation.compose.NavHostKt$NavHost$15 */
    /* JADX INFO: compiled from: NavHost.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.navigation.compose.NavHostKt$NavHost$15", m210f = "NavHost.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C237315 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ComposeNavigator $composeNavigator;
        final /* synthetic */ Transition<NavBackStackEntry> $transition;
        final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;
        final /* synthetic */ Map<String, Float> $zIndices;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C237315(Transition<NavBackStackEntry> transition, Map<String, Float> map, State<? extends List<NavBackStackEntry>> state, ComposeNavigator composeNavigator, Continuation<? super C237315> continuation) {
            super(2, continuation);
            this.$transition = transition;
            this.$zIndices = map;
            this.$visibleEntries$delegate = state;
            this.$composeNavigator = composeNavigator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C237315(this.$transition, this.$zIndices, this.$visibleEntries$delegate, this.$composeNavigator, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C237315) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (Intrinsics.areEqual(this.$transition.getCurrentState(), this.$transition.getTargetState())) {
                        Iterable $this$forEach$iv = NavHostKt.NavHost$lambda$6(this.$visibleEntries$delegate);
                        ComposeNavigator composeNavigator = this.$composeNavigator;
                        for (Object element$iv : $this$forEach$iv) {
                            NavBackStackEntry entry = (NavBackStackEntry) element$iv;
                            composeNavigator.onTransitionComplete(entry);
                        }
                        Map<String, Float> map = this.$zIndices;
                        Transition<NavBackStackEntry> transition = this.$transition;
                        Map destination$iv$iv = new LinkedHashMap();
                        for (Map.Entry<String, Float> entry2 : map.entrySet()) {
                            if (!Intrinsics.areEqual(entry2.getKey(), transition.getTargetState().getId())) {
                                destination$iv$iv.put(entry2.getKey(), entry2.getValue());
                            }
                        }
                        Map<String, Float> map2 = this.$zIndices;
                        for (Map.Entry element$iv2 : destination$iv$iv.entrySet()) {
                            map2.remove(element$iv2.getKey());
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createEnterTransition(NavDestination $this$createEnterTransition, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if ($this$createEnterTransition instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) $this$createEnterTransition).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!($this$createEnterTransition instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) $this$createEnterTransition).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createExitTransition(NavDestination $this$createExitTransition, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if ($this$createExitTransition instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) $this$createExitTransition).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!($this$createExitTransition instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) $this$createExitTransition).getExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createPopEnterTransition(NavDestination $this$createPopEnterTransition, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if ($this$createPopEnterTransition instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) $this$createPopEnterTransition).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!($this$createPopEnterTransition instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) $this$createPopEnterTransition).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createPopExitTransition(NavDestination $this$createPopExitTransition, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if ($this$createPopExitTransition instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) $this$createPopExitTransition).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!($this$createPopExitTransition instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) $this$createPopExitTransition).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }
}
