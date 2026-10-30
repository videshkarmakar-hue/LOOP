package com.videshkarmakar.loop.p006ui.page.settings.interaction;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InteractionPreferencePage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(m194d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, m195d2 = {"InteractionPreferencePage", "", "modifier", "Landroidx/compose/ui/Modifier;", "onBack", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "showDownloadTypeDialog", "", "initialType", ""}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InteractionPreferencePageKt {
    public static final void InteractionPreferencePage(Modifier modifier, final Function0<Unit> onBack, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        final MutableState showDownloadTypeDialog$delegate;
        Object value$iv3;
        Object value$iv4;
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer $composer3 = $composer.startRestartGroup(-654603353);
        ComposerKt.sourceInformation($composer3, "C(InteractionPreferencePage)30@1451L34,32@1521L34,33@1579L127,40@1804L358,52@2164L676,40@1713L1127,74@2948L34,76@3033L109,73@2884L258:InteractionPreferencePage.kt#tb24dy");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onBack) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            Modifier modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-654603353, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePage (InteractionPreferencePage.kt:29)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(null, null, null, null, $composer3, TopAppBarDefaults.$stable << 12, 15);
            $composer3.startReplaceGroup(427482873);
            ComposerKt.sourceInformation($composer3, "CC(remember):InteractionPreferencePage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showDownloadTypeDialog$delegate2 = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            boolean zInteractionPreferencePage$lambda$1 = InteractionPreferencePage$lambda$1(showDownloadTypeDialog$delegate2);
            $composer3.startReplaceGroup(427482931);
            ComposerKt.sourceInformation($composer3, "CC(remember):InteractionPreferencePage.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(zInteractionPreferencePage$lambda$1);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.DOWNLOAD_TYPE_INITIALIZATION, 0, 1, null));
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableIntState initialType$delegate = (MutableIntState) value$iv2;
            $composer3.endReplaceGroup();
            Modifier modifier4 = modifier3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(modifier3, scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(-250833309, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt.InteractionPreferencePage.1
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
                    ComposerKt.sourceInformation($composer4, "C48@2086L60,41@1814L342:InteractionPreferencePage.kt#tb24dy");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-250833309, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePage.<anonymous> (InteractionPreferencePage.kt:41)");
                        }
                        Function2<Composer, Integer, Unit> function2M7569getLambda1$app_debug = ComposableSingletons$InteractionPreferencePageKt.INSTANCE.m7569getLambda1$app_debug();
                        final Function0<Unit> function0 = onBack;
                        TopAppBarKt.LargeTopAppBar(function2M7569getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(173703432, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt.InteractionPreferencePage.1.1
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
                                ComposerKt.sourceInformation($composer5, "C49@2104L28:InteractionPreferencePage.kt#tb24dy");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(173703432, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePage.<anonymous>.<anonymous> (InteractionPreferencePage.kt:49)");
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
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1683286072, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt.InteractionPreferencePage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer4, int $changed2) {
                    Object value$iv5;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C53@2218L616,53@2174L660:InteractionPreferencePage.kt#tb24dy");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(it) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) == 18 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1683286072, $dirty4, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePage.<anonymous> (InteractionPreferencePage.kt:53)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                    $composer4.startReplaceGroup(-267610157);
                    ComposerKt.sourceInformation($composer4, "CC(remember):InteractionPreferencePage.kt#9igjgp");
                    boolean invalid$iv2 = $composer4.changed(initialType$delegate);
                    final MutableIntState mutableIntState = initialType$delegate;
                    final MutableState<Boolean> mutableState = showDownloadTypeDialog$delegate2;
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv5 = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt$InteractionPreferencePage$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$InteractionPreferencePageKt.INSTANCE.m7570getLambda2$app_debug(), 3, null);
                                final MutableIntState mutableIntState2 = mutableIntState;
                                final MutableState<Boolean> mutableState2 = mutableState;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2092545859, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt$InteractionPreferencePage$2$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        String strStringResource;
                                        Object value$iv6;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C60@2431L43,65@2741L69,59@2387L423:InteractionPreferencePage.kt#tb24dy");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2092545859, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InteractionPreferencePage.kt:59)");
                                            }
                                            String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.download_type, $composer5, 0);
                                            if (InteractionPreferencePageKt.InteractionPreferencePage$lambda$4(mutableIntState2) == 1) {
                                                $composer5.startReplaceGroup(-1438924127);
                                                ComposerKt.sourceInformation($composer5, "62@2581L52");
                                                strStringResource = StringResources_androidKt.stringResource(C3070R.string.use_previous_selection, $composer5, 0);
                                                $composer5.endReplaceGroup();
                                            } else {
                                                $composer5.startReplaceGroup(-1438924042);
                                                ComposerKt.sourceInformation($composer5, "63@2666L34");
                                                strStringResource = StringResources_androidKt.stringResource(C3070R.string.none, $composer5, 0);
                                                $composer5.endReplaceGroup();
                                            }
                                            $composer5.startReplaceGroup(-1438923967);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):InteractionPreferencePage.kt#9igjgp");
                                            final MutableState<Boolean> mutableState3 = mutableState2;
                                            Object it$iv4 = $composer5.rememberedValue();
                                            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                                value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt$InteractionPreferencePage$2$1$1$1$1$1
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
                                                        InteractionPreferencePageKt.InteractionPreferencePage$lambda$2(mutableState3, true);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv6);
                                            } else {
                                                value$iv6 = it$iv4;
                                            }
                                            $composer5.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceItem(strStringResource2, strStringResource, null, false, null, null, null, null, null, (Function0) value$iv6, $composer5, 805306368, 508);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv5);
                    } else {
                        value$iv5 = it$iv3;
                    }
                    $composer4.endReplaceGroup();
                    LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, (Function1) value$iv5, $composer4, 0, 254);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, 805306416, 508);
            if (InteractionPreferencePage$lambda$1(showDownloadTypeDialog$delegate2)) {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(427484300);
                ComposerKt.sourceInformation($composer2, "CC(remember):InteractionPreferencePage.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                    showDownloadTypeDialog$delegate = showDownloadTypeDialog$delegate2;
                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt$InteractionPreferencePage$3$1
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
                            InteractionPreferencePageKt.InteractionPreferencePage$lambda$2(showDownloadTypeDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    showDownloadTypeDialog$delegate = showDownloadTypeDialog$delegate2;
                    value$iv3 = it$iv3;
                }
                Function0 function0 = (Function0) value$iv3;
                $composer2.endReplaceGroup();
                int iInteractionPreferencePage$lambda$4 = InteractionPreferencePage$lambda$4(initialType$delegate);
                $composer2.startReplaceGroup(427484385);
                ComposerKt.sourceInformation($composer2, "CC(remember):InteractionPreferencePage.kt#9igjgp");
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt$InteractionPreferencePage$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int it) {
                            PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.DOWNLOAD_TYPE_INITIALIZATION, it);
                            InteractionPreferencePageKt.InteractionPreferencePage$lambda$2(showDownloadTypeDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                $composer2.endReplaceGroup();
                InterfaceCustomizationDialogsKt.DownloadTypeCustomizationDialog(null, function0, iInteractionPreferencePage$lambda$4, (Function1) value$iv4, $composer2, 3120, 1);
            } else {
                $composer2 = $composer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.InteractionPreferencePageKt.InteractionPreferencePage.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    InteractionPreferencePageKt.InteractionPreferencePage(modifier2, onBack, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean InteractionPreferencePage$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InteractionPreferencePage$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InteractionPreferencePage$lambda$4(MutableIntState $initialType$delegate) {
        MutableIntState $this$getValue$iv = $initialType$delegate;
        return $this$getValue$iv.getIntValue();
    }
}
