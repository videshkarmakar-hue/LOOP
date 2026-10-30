package com.videshkarmakar.loop.p006ui.page.settings.appearance;

import android.os.Build;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material.icons.outlined.ColorizeKt;
import androidx.compose.material.icons.outlined.DarkModeKt;
import androidx.compose.material.icons.outlined.LanguageKt;
import androidx.compose.material.icons.outlined.LightModeKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.accompanist.pager.PagerIndicatorKt;
import com.google.android.material.color.DynamicColors;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.p006ui.component.VideoCardKt;
import com.videshkarmakar.loop.util.DarkThemePreference;
import com.videshkarmakar.loop.util.LanguageSettingsKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import io.material.hct.Hct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okhttp3.internal.p009ws.WebSocketProtocol;

/* JADX INFO: compiled from: AppearancePreferences.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m194d1 = {"\u0000F\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\f\u001a4\u0010\r\u001a\u00020\u0006*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a^\u0010\u0015\u001a\u00020\u0006*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001d\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 ²\u0006\n\u0010\u0012\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020#X\u008a\u0084\u0002"}, m195d2 = {"ColorList", "", "Landroidx/compose/ui/graphics/Color;", "DrawableList", "", "AppearancePreferences", "", "onNavigateBack", "Lkotlin/Function0;", "onNavigateTo", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ColorButton", "Landroidx/compose/foundation/layout/RowScope;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "index", "ColorButton-cf5BqRc", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/ui/Modifier;JILandroidx/compose/runtime/Composer;II)V", "ColorButtonImpl", "isSelected", "", "cardColor", "containerColor", "onClick", "ColorButtonImpl-ZFgQbEw", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function0;JJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ColorButtons", "ColorButtons-RPmYEkk", "(Landroidx/compose/foundation/layout/RowScope;JLandroidx/compose/runtime/Composer;I)V", "app_debug", "image", "containerSize", "Landroidx/compose/ui/unit/Dp;", "iconSize"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AppearancePreferencesKt {
    private static final List<Color> ColorList;
    private static final List<Integer> DrawableList;

    static {
        Iterable $this$map$iv = CollectionsKt.plus((Iterable) new IntRange(4, 10), (Iterable) new IntRange(1, 3));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            int it = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(Double.valueOf(((double) it) * 35.0d));
        }
        Iterable $this$map$iv2 = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            double it2 = ((Number) item$iv$iv2).doubleValue();
            destination$iv$iv2.add(Color.m4281boximpl(ColorKt.Color(Hct.INSTANCE.from(it2, 40.0d, 40.0d).toInt())));
        }
        ColorList = (List) destination$iv$iv2;
        DrawableList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C3070R.drawable.sample), Integer.valueOf(C3070R.drawable.sample1), Integer.valueOf(C3070R.drawable.sample2), Integer.valueOf(C3070R.drawable.sample3)});
    }

    public static final void AppearancePreferences(final Function0<Unit> onNavigateBack, final Function1<? super String, Unit> onNavigateTo, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(onNavigateTo, "onNavigateTo");
        Composer $composer3 = $composer.startRestartGroup(1547986123);
        ComposerKt.sourceInformation($composer3, "C(AppearancePreferences)101@4561L24,101@4528L92,104@4639L73,108@4731L92,118@4977L339,129@5336L4344,114@4829L4857:AppearancePreferences.kt#n7ajos");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateTo) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1547986123, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferences (AppearancePreferences.kt:99)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer3, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer3, (TopAppBarDefaults.$stable << 12) | 48, 12);
            $composer3.startReplaceGroup(707144653);
            ComposerKt.sourceInformation($composer3, "CC(remember):AppearancePreferences.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotIntStateKt.mutableIntStateOf(RangesKt.random(CollectionsKt.getIndices(DrawableList), Random.INSTANCE));
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableIntState index$delegate = (MutableIntState) value$iv;
            $composer3.endReplaceGroup();
            int iAppearancePreferences$lambda$3 = AppearancePreferences$lambda$3(index$delegate);
            $composer3.startReplaceGroup(707144745);
            ComposerKt.sourceInformation($composer3, "CC(remember):AppearancePreferences.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(iAppearancePreferences$lambda$3);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotIntStateKt.mutableIntStateOf(DrawableList.get(AppearancePreferences$lambda$3(index$delegate)).intValue());
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableIntState image$delegate = (MutableIntState) value$iv2;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(1157229447, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt.AppearancePreferences.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C124@5201L58,119@4991L315:AppearancePreferences.kt#n7ajos");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1157229447, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferences.<anonymous> (AppearancePreferences.kt:119)");
                        }
                        Function2<Composer, Integer, Unit> function2M7443getLambda1$app_debug = ComposableSingletons$AppearancePreferencesKt.INSTANCE.m7443getLambda1$app_debug();
                        final Function0<Unit> function0 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7443getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-100971732, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt.AppearancePreferences.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C125@5219L26:AppearancePreferences.kt#n7ajos");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-100971732, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferences.<anonymous>.<anonymous> (AppearancePreferences.kt:125)");
                                }
                                IconButtonsKt.BackButton(function0, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), null, scrollBehavior, $composer4, 390, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1784159652, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt.AppearancePreferences.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    int i;
                    Object value$iv3;
                    Object value$iv4;
                    Object value$iv5;
                    Object value$iv6;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C133@5452L21,130@5350L4320:AppearancePreferences.kt#n7ajos");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(it) ? 4 : 2;
                    }
                    if (($dirty3 & 91) == 18 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1784159652, $dirty3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferences.<anonymous> (AppearancePreferences.kt:130)");
                    }
                    Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.padding(Modifier.INSTANCE, it), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                    final Function1<String, Unit> function1 = onNavigateTo;
                    MutableIntState mutableIntState = image$delegate;
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
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
                        function0 = constructor;
                        $composer4.createNode(function0);
                    } else {
                        function0 = constructor;
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
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    int i3 = ((0 >> 6) & 112) | 6;
                    ColumnScope $this$invoke_u24lambda_u245 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1528930316, "C136@5508L105,144@5955L57,142@5719L293,154@6307L1319,148@6030L1596,187@7988L11,188@8059L11,181@7644L529,202@8788L7,202@8796L13,203@8862L40,206@9097L7,206@9105L18,208@9263L34,207@9157L74,203@8826L472:AppearancePreferences.kt#n7ajos");
                    VideoCardKt.VideoCard(PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), null, null, Integer.valueOf(AppearancePreferencesKt.AppearancePreferences$lambda$5(mutableIntState)), false, null, null, 0.0f, 0.0d, 0, false, $composer4, 6, 0, 2038);
                    final int pageCount = AppearancePreferencesKt.ColorList.size() + 1;
                    $composer4.startReplaceGroup(-1528930072);
                    ComposerKt.sourceInformation($composer4, "142@5779L7,*143@5887L7");
                    ProvidableCompositionLocal<Integer> localPaletteStyleIndex = CompositionLocalsKt.getLocalPaletteStyleIndex();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer4.consume(localPaletteStyleIndex);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (((Number) objConsume).intValue() == 4) {
                        i = pageCount;
                    } else {
                        List list = AppearancePreferencesKt.ColorList;
                        ProvidableCompositionLocal<Long> localSeedColor = CompositionLocalsKt.getLocalSeedColor();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer4.consume(localSeedColor);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        int $this$invoke_u24lambda_u245_u24lambda_u240 = list.indexOf(Color.m4281boximpl(ColorKt.Color(((Number) objConsume2).longValue())));
                        if ($this$invoke_u24lambda_u245_u24lambda_u240 == -1) {
                            $this$invoke_u24lambda_u245_u24lambda_u240 = 0;
                        }
                        i = $this$invoke_u24lambda_u245_u24lambda_u240;
                    }
                    $composer4.endReplaceGroup();
                    $composer4.startReplaceGroup(-1528929869);
                    ComposerKt.sourceInformation($composer4, "CC(remember):AppearancePreferences.kt#9igjgp");
                    boolean invalid$iv2 = $composer4.changed(pageCount);
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function0) new Function0<Integer>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$pagerState$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Integer invoke() {
                                return Integer.valueOf(pageCount);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer4.endReplaceGroup();
                    PagerState pagerState = PagerStateKt.rememberPagerState(i, 0.0f, (Function0) value$iv3, $composer4, 0, 2);
                    PagerKt.m1101HorizontalPageroI3XNZo(pagerState, SemanticsModifierKt.clearAndSetSemantics(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }
                    }), PaddingKt.m863PaddingValuesYgX7TsA$default(C1979Dp.m6801constructorimpl(12), 0.0f, 2, null), null, 0, 0.0f, null, null, false, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1239114380, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer, Integer num2) {
                            invoke(pagerScope, num.intValue(), composer, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code duplicated, block: B:29:0x01cb  */
                        public final void invoke(PagerScope HorizontalPager, int page, Composer $composer5, int $changed3) {
                            final boolean isSelected;
                            Object value$iv7;
                            Function0<ComposeUiNode> function2;
                            Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
                            ComposerKt.sourceInformation($composer5, "C:AppearancePreferences.kt#n7ajos");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1239114380, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferences.<anonymous>.<anonymous>.<anonymous> (AppearancePreferences.kt:155)");
                            }
                            if (page < pageCount - 1) {
                                $composer5.startReplaceGroup(973684102);
                                ComposerKt.sourceInformation($composer5, "156@6389L199");
                                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv2 = (54 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    function2 = constructor2;
                                    $composer5.createNode(function2);
                                } else {
                                    function2 = constructor2;
                                    $composer5.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer5);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                int $changed4 = ((54 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u240 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1298075953, "C159@6557L29:AppearancePreferences.kt#n7ajos");
                                AppearancePreferencesKt.m7442ColorButtonsRPmYEkk($this$invoke_u24lambda_u240, ((Color) AppearancePreferencesKt.ColorList.get(page)).m4301unboximpl(), $composer5, $changed4 & 14);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endReplaceGroup();
                            } else {
                                $composer5.startReplaceGroup(973684419);
                                ComposerKt.sourceInformation($composer5, "164@6858L728");
                                $composer5.startReplaceGroup(973684460);
                                ComposerKt.sourceInformation($composer5, "163@6770L7,163@6826L7");
                                ProvidableCompositionLocal<Integer> localPaletteStyleIndex2 = CompositionLocalsKt.getLocalPaletteStyleIndex();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume3 = $composer5.consume(localPaletteStyleIndex2);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                if (((Number) objConsume3).intValue() == 4) {
                                    ProvidableCompositionLocal<Boolean> localDynamicColorSwitch = CompositionLocalsKt.getLocalDynamicColorSwitch();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume4 = $composer5.consume(localDynamicColorSwitch);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (((Boolean) objConsume4).booleanValue()) {
                                        isSelected = false;
                                    } else {
                                        isSelected = true;
                                    }
                                } else {
                                    isSelected = false;
                                }
                                $composer5.endReplaceGroup();
                                Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer5, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv3 = (54 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    $composer5.createNode(constructor3);
                                } else {
                                    $composer5.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer5);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                int $changed5 = ((54 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u242 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1298075456, "C170@7189L14,168@7054L506:AppearancePreferences.kt#n7ajos");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                long jM4317getBlack0d7_KjU = Color.INSTANCE.m4317getBlack0d7_KjU();
                                $composer5.startReplaceGroup(-1298075321);
                                ComposerKt.sourceInformation($composer5, "CC(remember):AppearancePreferences.kt#9igjgp");
                                boolean invalid$iv3 = $composer5.changed(isSelected);
                                Object it$iv4 = $composer5.rememberedValue();
                                if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                    value$iv7 = (Function0) new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            return Boolean.valueOf(isSelected);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv7);
                                } else {
                                    value$iv7 = it$iv4;
                                }
                                $composer5.endReplaceGroup();
                                AppearancePreferencesKt.m7441ColorButtonImplZFgQbEw($this$invoke_u24lambda_u242, companion, jM4317getBlack0d7_KjU, (Function0) value$iv7, 0L, 0L, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$2$2$2
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        PreferenceUtil.INSTANCE.switchDynamicColor(false);
                                        PreferenceUtil.INSTANCE.modifyThemeSeedColor(ColorKt.m4345toArgb8_81llA(Color.INSTANCE.m4317getBlack0d7_KjU()), 4);
                                    }
                                }, $composer5, ($changed5 & 14) | 1573296, 24);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), $composer4, 384, 3072, 8184);
                    PagerIndicatorKt.m7179HorizontalPagerIndicatorK_mkGiw(pagerState, pageCount, PaddingKt.m870paddingVpY3zN4$default($this$invoke_u24lambda_u245.align(SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$3
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }
                    }), Alignment.INSTANCE.getCenterHorizontally()), 0.0f, C1979Dp.m6801constructorimpl(12), 1, null), (Function1<? super Integer, Integer>) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOutlineVariant(), C1979Dp.m6801constructorimpl(6), C1979Dp.m6801constructorimpl(6), 0.0f, (Shape) null, $composer4, 14155776, 776);
                    $composer4.startReplaceGroup(-1528927634);
                    ComposerKt.sourceInformation($composer4, "192@8282L43,193@8365L102,197@8585L7,192@8257L463");
                    if (DynamicColors.isDynamicColorAvailable()) {
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.dynamic_color, $composer4, 0);
                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.dynamic_color_desc, $composer4, 0);
                        ImageVector colorize = ColorizeKt.getColorize(Icons.Outlined.INSTANCE);
                        ProvidableCompositionLocal<Boolean> localDynamicColorSwitch = CompositionLocalsKt.getLocalDynamicColorSwitch();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = $composer4.consume(localDynamicColorSwitch);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, colorize, false, ((Boolean) objConsume3).booleanValue(), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$4
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                PreferenceUtil.switchDynamicColor$default(PreferenceUtil.INSTANCE, false, 1, null);
                            }
                        }, $composer4, 1572864, 40);
                    }
                    $composer4.endReplaceGroup();
                    ProvidableCompositionLocal<DarkThemePreference> localDarkTheme = CompositionLocalsKt.getLocalDarkTheme();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = $composer4.consume(localDarkTheme);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    final boolean isDarkTheme = ((DarkThemePreference) objConsume4).isDarkTheme($composer4, 0);
                    String strStringResource3 = StringResources_androidKt.stringResource(C3070R.string.dark_theme, $composer4, 0);
                    Icons.Outlined outlined = Icons.Outlined.INSTANCE;
                    ImageVector darkMode = isDarkTheme ? DarkModeKt.getDarkMode(outlined) : LightModeKt.getLightMode(outlined);
                    ProvidableCompositionLocal<DarkThemePreference> localDarkTheme2 = CompositionLocalsKt.getLocalDarkTheme();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = $composer4.consume(localDarkTheme2);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    String darkThemeDesc = ((DarkThemePreference) objConsume5).getDarkThemeDesc($composer4, 0);
                    $composer4.startReplaceGroup(-1528926561);
                    ComposerKt.sourceInformation($composer4, "CC(remember):AppearancePreferences.kt#9igjgp");
                    boolean invalid$iv3 = $composer4.changed(function1);
                    Object it$iv4 = $composer4.rememberedValue();
                    if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                function1.invoke(Route.DARK_THEME);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    Function0 function2 = (Function0) value$iv4;
                    $composer4.endReplaceGroup();
                    $composer4.startReplaceGroup(-1528926667);
                    ComposerKt.sourceInformation($composer4, "CC(remember):AppearancePreferences.kt#9igjgp");
                    boolean invalid$iv4 = $composer4.changed(isDarkTheme);
                    Object it$iv5 = $composer4.rememberedValue();
                    if (invalid$iv4 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                        value$iv5 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$6$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                PreferenceUtil.modifyDarkThemePreference$default(PreferenceUtil.INSTANCE, isDarkTheme ? 3 : 2, false, 2, null);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv5);
                    } else {
                        value$iv5 = it$iv5;
                    }
                    $composer4.endReplaceGroup();
                    PreferenceItemsKt.PreferenceSwitchWithDivider(strStringResource3, darkThemeDesc, darkMode, false, false, isDarkTheme, null, function2, (Function0) value$iv5, $composer4, 0, 88);
                    $composer4.startReplaceGroup(-1026675918);
                    ComposerKt.sourceInformation($composer4, "211@9418L33,213@9567L15,214@9605L33,210@9370L268");
                    if (Build.VERSION.SDK_INT >= 24) {
                        String strStringResource4 = StringResources_androidKt.stringResource(C3070R.string.language, $composer4, 0);
                        ImageVector language = LanguageKt.getLanguage(Icons.Outlined.INSTANCE);
                        String displayName = LanguageSettingsKt.toDisplayName(Locale.getDefault(), $composer4, 8);
                        $composer4.startReplaceGroup(-1528926219);
                        ComposerKt.sourceInformation($composer4, "CC(remember):AppearancePreferences.kt#9igjgp");
                        boolean invalid$iv5 = $composer4.changed(function1);
                        Object it$iv6 = $composer4.rememberedValue();
                        if (invalid$iv5 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                            value$iv6 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$AppearancePreferences$2$1$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    function1.invoke(Route.LANGUAGES);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv6);
                        } else {
                            value$iv6 = it$iv6;
                        }
                        $composer4.endReplaceGroup();
                        PreferenceItemsKt.PreferenceItem(strStringResource4, displayName, language, false, null, null, null, null, null, (Function0) value$iv6, $composer4, 0, 504);
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer2, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt.AppearancePreferences.3
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
                    AppearancePreferencesKt.AppearancePreferences(onNavigateBack, onNavigateTo, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final int AppearancePreferences$lambda$3(MutableIntState $index$delegate) {
        MutableIntState $this$getValue$iv = $index$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AppearancePreferences$lambda$5(MutableIntState $image$delegate) {
        MutableIntState $this$getValue$iv = $image$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: renamed from: ColorButtons-RPmYEkk, reason: not valid java name */
    public static final void m7442ColorButtonsRPmYEkk(final RowScope ColorButtons, final long color, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(ColorButtons, "$this$ColorButtons");
        Composer $composer2 = $composer.startRestartGroup(-1473551313);
        ComposerKt.sourceInformation($composer2, "C(ColorButtons)P(0:c#ui.graphics.Color)*225@9848L41:AppearancePreferences.kt#n7ajos");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(ColorButtons) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(color) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473551313, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.ColorButtons (AppearancePreferences.kt:223)");
            }
            Iterable $this$forEachIndexed$iv = PreferenceUtilKt.getPaletteStyles().subList(0, 4);
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int index = index$iv;
                m7440ColorButtoncf5BqRc(ColorButtons, null, color, index, $composer2, ($dirty2 & 14) | (($dirty2 << 3) & 896), 1);
                index$iv = index$iv2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtons$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    AppearancePreferencesKt.m7442ColorButtonsRPmYEkk(ColorButtons, color, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0116  */
    /* JADX WARN: Code duplicated, block: B:72:0x0135  */
    /* JADX INFO: renamed from: ColorButton-cf5BqRc, reason: not valid java name */
    public static final void m7440ColorButtoncf5BqRc(final RowScope ColorButton, Modifier modifier, long color, int index, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final long color2;
        int index2;
        Modifier modifier3;
        boolean z;
        boolean z2;
        Object value$iv;
        Object value$iv2;
        long color3;
        Intrinsics.checkNotNullParameter(ColorButton, "$this$ColorButton");
        Composer $composer2 = $composer.startRestartGroup(751956356);
        ComposerKt.sourceInformation($composer2, "C(ColorButton)P(2,0:c#ui.graphics.Color)237@10247L12,237@10261L133,237@10197L197:AppearancePreferences.kt#n7ajos");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(ColorButton) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 384;
            color2 = color;
        } else if (($changed & 896) == 0) {
            color2 = color;
            $dirty |= $composer2.changed(color2) ? 256 : 128;
        } else {
            color2 = color;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 3072;
            index2 = index;
        } else if (($changed & 7168) == 0) {
            index2 = index;
            $dirty |= $composer2.changed(index2) ? 2048 : 1024;
        } else {
            index2 = index;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            color3 = color2;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                color2 = Color.INSTANCE.m4322getGreen0d7_KjU();
            }
            final int index3 = i4 != 0 ? 0 : index2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(751956356, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.ColorButton (AppearancePreferences.kt:234)");
            }
            $composer2.startReplaceGroup(110062356);
            ComposerKt.sourceInformation($composer2, "236@10080L7,236@10106L7,236@10176L7");
            ProvidableCompositionLocal<Boolean> localDynamicColorSwitch = CompositionLocalsKt.getLocalDynamicColorSwitch();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDynamicColorSwitch);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (((Boolean) objConsume).booleanValue()) {
                z = false;
            } else {
                ProvidableCompositionLocal<Long> localSeedColor = CompositionLocalsKt.getLocalSeedColor();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer2.consume(localSeedColor);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (((Number) objConsume2).longValue() == ColorKt.m4345toArgb8_81llA(color2)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                ProvidableCompositionLocal<Integer> localPaletteStyleIndex = CompositionLocalsKt.getLocalPaletteStyleIndex();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer2.consume(localPaletteStyleIndex);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (((Number) objConsume3).intValue() == index3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            $composer2.endReplaceGroup();
            final boolean isSelect = z2;
            $composer2.startReplaceGroup(110062548);
            ComposerKt.sourceInformation($composer2, "CC(remember):AppearancePreferences.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(isSelect);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButton$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(isSelect);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            Function0 function0 = (Function0) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(110062562);
            ComposerKt.sourceInformation($composer2, "CC(remember):AppearancePreferences.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 896) == 256) | (($dirty2 & 7168) == 2048);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButton$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        PreferenceUtil.INSTANCE.switchDynamicColor(false);
                        PreferenceUtil.INSTANCE.modifyThemeSeedColor(ColorKt.m4345toArgb8_81llA(color2), index3);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            color3 = color2;
            int index4 = index3;
            m7441ColorButtonImplZFgQbEw(ColorButton, modifier3, 0L, function0, 0L, 0L, (Function0) value$iv2, $composer2, ($dirty2 & 14) | ($dirty2 & 112), 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            index2 = index4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j = color3;
            final int i5 = index2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AppearancePreferencesKt.m7440ColorButtoncf5BqRc(ColorButton, modifier4, j, i5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: ColorButtonImpl-ZFgQbEw, reason: not valid java name */
    public static final void m7441ColorButtonImplZFgQbEw(final RowScope ColorButtonImpl, Modifier modifier, long color, Function0<Boolean> function0, long cardColor, long containerColor, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        long j;
        Function0<Boolean> function2;
        long j2;
        Function0<Unit> function3;
        Modifier.Companion modifier2;
        long color2;
        long cardColor2;
        long containerColor2;
        AppearancePreferencesKt$ColorButtonImpl$2 appearancePreferencesKt$ColorButtonImpl$2;
        long cardColor3;
        Function0<Unit> function4;
        Function0<Boolean> function5;
        Modifier modifier3;
        long color3;
        long containerColor3;
        Intrinsics.checkNotNullParameter(ColorButtonImpl, "$this$ColorButtonImpl");
        Composer $composer2 = $composer.startRestartGroup(-1639725951);
        ComposerKt.sourceInformation($composer2, "C(ColorButtonImpl)P(4,1:c#ui.graphics.Color,3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)249@10588L11,250@10660L11,254@10749L72,255@10842L72,266@11241L1409,257@10920L1730:AppearancePreferences.kt#n7ajos");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(ColorButtonImpl) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 384;
            j = color;
        } else if (($changed & 896) == 0) {
            j = color;
            $dirty |= $composer2.changed(j) ? 256 : 128;
        } else {
            j = color;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 3072;
            function2 = function0;
        } else if (($changed & 7168) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function0;
        }
        if (($changed & 57344) == 0) {
            if ((i & 8) == 0) {
                j2 = cardColor;
                int i5 = $composer2.changed(j2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                j2 = cardColor;
            }
            $dirty |= i5;
        } else {
            j2 = cardColor;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= ((i & 16) == 0 && $composer2.changed(containerColor)) ? 131072 : 65536;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 1572864;
            function3 = function1;
        } else if (($changed & 3670016) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        } else {
            function3 = function1;
        }
        if (($dirty & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            containerColor3 = containerColor;
            function5 = function2;
            cardColor3 = j2;
            function4 = function3;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                color2 = i3 != 0 ? Color.INSTANCE.m4322getGreen0d7_KjU() : j;
                if (i4 != 0) {
                    function2 = new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return false;
                        }
                    };
                }
                if ((i & 8) != 0) {
                    cardColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainer();
                    $dirty &= -57345;
                } else {
                    cardColor2 = j2;
                }
                if ((i & 16) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimaryContainer();
                    $dirty &= -458753;
                } else {
                    containerColor2 = containerColor;
                }
                appearancePreferencesKt$ColorButtonImpl$2 = i6 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$2
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function3;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 16) != 0) {
                    $dirty &= -458753;
                    color2 = j;
                    cardColor2 = j2;
                    appearancePreferencesKt$ColorButtonImpl$2 = function3;
                    modifier2 = modifier;
                    containerColor2 = containerColor;
                } else {
                    modifier2 = modifier;
                    color2 = j;
                    cardColor2 = j2;
                    appearancePreferencesKt$ColorButtonImpl$2 = function3;
                    containerColor2 = containerColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1639725951, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.ColorButtonImpl (AppearancePreferences.kt:252)");
            }
            final State<C1979Dp> stateM363animateDpAsStateAjpBEmI = AnimateAsStateKt.m363animateDpAsStateAjpBEmI(function2.invoke().booleanValue() ? C1979Dp.m6801constructorimpl(28) : C1979Dp.m6801constructorimpl(0), null, null, null, $composer2, 0, 14);
            final State<C1979Dp> stateM363animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m363animateDpAsStateAjpBEmI(function2.invoke().booleanValue() ? C1979Dp.m6801constructorimpl(16) : C1979Dp.m6801constructorimpl(0), null, null, null, $composer2, 0, 14);
            cardColor3 = cardColor2;
            function4 = appearancePreferencesKt$ColorButtonImpl$2;
            final Modifier modifier4 = modifier2;
            final long j3 = color2;
            final long j4 = containerColor2;
            SurfaceKt.m2669Surfaceo_FOJdg(function4, AspectRatioKt.aspectRatio$default(ColorButtonImpl.weight(SizeKt.m916sizeInqDBjuR0(PaddingKt.m868padding3ABfNKs(modifier2, C1979Dp.m6801constructorimpl(4)), C1979Dp.m6801constructorimpl(64), C1979Dp.m6801constructorimpl(64), C1979Dp.m6801constructorimpl(80), C1979Dp.m6801constructorimpl(80)), 1.0f, false), 1.0f, false, 2, null), false, RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(16)), cardColor3, 0L, 0.0f, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(2062659478, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:55:0x0392  */
                /* JADX WARN: Code duplicated, block: B:58:0x0404  */
                /* JADX WARN: Code duplicated, block: B:61:0x0410  */
                /* JADX WARN: Code duplicated, block: B:62:0x0416  */
                /* JADX WARN: Code duplicated, block: B:73:0x052d  */
                /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    Function0<ComposeUiNode> function6;
                    String str;
                    boolean invalid$iv;
                    Object value$iv2;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function7;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C267@11251L1389:AppearancePreferences.kt#n7ajos");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2062659478, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.appearance.ColorButtonImpl.<anonymous> (AppearancePreferences.kt:267)");
                    }
                    Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Modifier modifier5 = modifier4;
                    final long j5 = j3;
                    final long j6 = j4;
                    State<C1979Dp> state = stateM363animateDpAsStateAjpBEmI;
                    State<C1979Dp> state2 = stateM363animateDpAsStateAjpBEmI2;
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i7 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    int i8 = ((6 >> 6) & 112) | 6;
                    BoxScope $this$invoke_u24lambda_u244 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1344567020, "C271@11409L21,268@11293L1333:AppearancePreferences.kt#n7ajos");
                    Modifier modifierClip = ClipKt.clip(SizeKt.m913size3ABfNKs(modifier5, C1979Dp.m6801constructorimpl(48)), RoundedCornerShapeKt.getCircleShape());
                    $composer3.startReplaceGroup(1344567136);
                    ComposerKt.sourceInformation($composer3, "CC(remember):AppearancePreferences.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(j5);
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$3$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawBehind) {
                                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                                DrawScope.CC.m4845drawCircleVaOC9Bg$default(drawBehind, j5, 0.0f, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifier$iv2 = $this$invoke_u24lambda_u244.align(DrawModifierKt.drawBehind(modifierClip, (Function1) value$iv), Alignment.INSTANCE.getCenter());
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv2 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function6 = constructor3;
                        $composer3.createNode(function6);
                    } else {
                        function6 = constructor3;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                        str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        int i10 = ((0 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u244_u24lambda_u243 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1360086189, "C273@11491L184,278@11692L182,288@12121L30,283@11891L716:AppearancePreferences.kt#n7ajos");
                        String str2 = str;
                        SurfaceKt.m2666SurfaceT9BRK9s(SizeKt.m913size3ABfNKs($this$invoke_u24lambda_u244_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomStart()), C1979Dp.m6801constructorimpl(24)), null, j6, 0L, 0.0f, 0.0f, null, ComposableSingletons$AppearancePreferencesKt.INSTANCE.m7444getLambda2$app_debug(), $composer3, 12582912, 122);
                        SurfaceKt.m2666SurfaceT9BRK9s(SizeKt.m913size3ABfNKs($this$invoke_u24lambda_u244_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), C1979Dp.m6801constructorimpl(24)), null, j6, 0L, 0.0f, 0.0f, null, ComposableSingletons$AppearancePreferencesKt.INSTANCE.m7445getLambda3$app_debug(), $composer3, 12582912, 122);
                        Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(ClipKt.clip($this$invoke_u24lambda_u244_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), RoundedCornerShapeKt.getCircleShape()), AppearancePreferencesKt.ColorButtonImpl_ZFgQbEw$lambda$9(state));
                        $composer3.startReplaceGroup(-1360085559);
                        ComposerKt.sourceInformation($composer3, "CC(remember):AppearancePreferences.kt#9igjgp");
                        invalid$iv = $composer3.changed(j6);
                        Object it$iv2 = $composer3.rememberedValue();
                        if (!invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function1) new Function1<DrawScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$3$1$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                    invoke2(drawScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DrawScope drawBehind) {
                                    Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                                    DrawScope.CC.m4845drawCircleVaOC9Bg$default(drawBehind, j6, 0.0f, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifier$iv3 = DrawModifierKt.drawBehind(modifierM913size3ABfNKs, (Function1) value$iv2);
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, str2);
                        Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function7 = constructor;
                            $composer3.createNode(function7);
                        } else {
                            function7 = constructor;
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        int i12 = ((0 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 2043910202, "C296@12529L11,290@12201L384:AppearancePreferences.kt#n7ajos");
                        IconKt.m2292Iconww6aTOc(CheckKt.getCheck(Icons.Outlined.INSTANCE), (String) null, $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.align(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, AppearancePreferencesKt.ColorButtonImpl_ZFgQbEw$lambda$10(state2)), Alignment.INSTANCE.getCenter()), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimaryContainer(), $composer3, 48, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i13 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    int i14 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$invoke_u24lambda_u244_u24lambda_u244 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1360086189, "C273@11491L184,278@11692L182,288@12121L30,283@11891L716:AppearancePreferences.kt#n7ajos");
                    String str3 = str;
                    SurfaceKt.m2666SurfaceT9BRK9s(SizeKt.m913size3ABfNKs($this$invoke_u24lambda_u244_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomStart()), C1979Dp.m6801constructorimpl(24)), null, j6, 0L, 0.0f, 0.0f, null, ComposableSingletons$AppearancePreferencesKt.INSTANCE.m7444getLambda2$app_debug(), $composer3, 12582912, 122);
                    SurfaceKt.m2666SurfaceT9BRK9s(SizeKt.m913size3ABfNKs($this$invoke_u24lambda_u244_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), C1979Dp.m6801constructorimpl(24)), null, j6, 0L, 0.0f, 0.0f, null, ComposableSingletons$AppearancePreferencesKt.INSTANCE.m7445getLambda3$app_debug(), $composer3, 12582912, 122);
                    Modifier modifierM913size3ABfNKs2 = SizeKt.m913size3ABfNKs(ClipKt.clip($this$invoke_u24lambda_u244_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), RoundedCornerShapeKt.getCircleShape()), AppearancePreferencesKt.ColorButtonImpl_ZFgQbEw$lambda$9(state));
                    $composer3.startReplaceGroup(-1360085559);
                    ComposerKt.sourceInformation($composer3, "CC(remember):AppearancePreferences.kt#9igjgp");
                    invalid$iv = $composer3.changed(j6);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv) {
                        value$iv2 = (Function1) new Function1<DrawScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$3$1$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawBehind) {
                                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                                DrawScope.CC.m4845drawCircleVaOC9Bg$default(drawBehind, j6, 0.0f, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = (Function1) new Function1<DrawScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$3$1$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawBehind) {
                                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                                DrawScope.CC.m4845drawCircleVaOC9Bg$default(drawBehind, j6, 0.0f, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifier$iv4 = DrawModifierKt.drawBehind(modifierM913size3ABfNKs2, (Function1) value$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, str3);
                    Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                    int $changed$iv$iv4 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function7 = constructor;
                        $composer3.createNode(function7);
                    } else {
                        function7 = constructor;
                        $composer3.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i15 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    int i16 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u243 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2043910202, "C296@12529L11,290@12201L384:AppearancePreferences.kt#n7ajos");
                    IconKt.m2292Iconww6aTOc(CheckKt.getCheck(Icons.Outlined.INSTANCE), (String) null, $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u243.align(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, AppearancePreferencesKt.ColorButtonImpl_ZFgQbEw$lambda$10(state2)), Alignment.INSTANCE.getCenter()), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimaryContainer(), $composer3, 48, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($dirty >> 18) & 14) | (57344 & $dirty), 6, 996);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function2;
            modifier3 = modifier2;
            color3 = color2;
            containerColor3 = containerColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j5 = color3;
            final Function0<Boolean> function6 = function5;
            final long j6 = cardColor3;
            final long j7 = containerColor3;
            final Function0<Unit> function7 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.appearance.AppearancePreferencesKt$ColorButtonImpl$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    AppearancePreferencesKt.m7441ColorButtonImplZFgQbEw(ColorButtonImpl, modifier5, j5, function6, j6, j7, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ColorButtonImpl_ZFgQbEw$lambda$9(State<C1979Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((C1979Dp) thisObj$iv).m6815unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ColorButtonImpl_ZFgQbEw$lambda$10(State<C1979Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((C1979Dp) thisObj$iv).m6815unboximpl();
    }
}
