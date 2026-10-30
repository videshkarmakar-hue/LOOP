package com.videshkarmakar.loop.p006ui.page.settings.command;

import android.content.Context;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.BookmarkAddKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.hapticfeedback.HapticFeedback;
import androidx.compose.p001ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.UriHandler;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.state.ToggleableState;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.backup.BackupUtil;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.DatabaseUtil;
import com.videshkarmakar.loop.util.LinksKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: TemplateListPage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(m194d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a/\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n²\u0006\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u000fX\u008a\u008e\u0002"}, m195d2 = {"TAG", "", TemplateListPageKt.TAG, "", "onNavigateBack", "Lkotlin/Function0;", "onNavigateToEditPage", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_debug", "templates", "", "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "showHelpDialog", "", "isMultiSelectEnabled", "showDeleteDialog", "showShortcutsDialog", "isCustomCommandEnabled", "selectedTemplateId", "expanded"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TemplateListPageKt {
    private static final String TAG = "TemplateListPage";

    public static final void TemplateListPage(final Function0<Unit> onNavigateBack, final Function1<? super Integer, Unit> onNavigateToEditPage, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        TemplateListPageKt$TemplateListPage$1$1 value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Composer $composer2;
        final MutableState isMultiSelectEnabled$delegate;
        final CoroutineScope scope;
        int i;
        final MutableState showShortcutsDialog$delegate;
        TemplateListPageKt$TemplateListPage$14$1 value$iv8;
        final MutableState showShortcutsDialog$delegate2;
        Object value$iv9;
        Object value$iv10;
        final MutableState showDeleteDialog$delegate;
        Object value$iv11;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(onNavigateToEditPage, "onNavigateToEditPage");
        Composer $composer3 = $composer.startRestartGroup(662066678);
        ComposerKt.sourceInformation($composer3, "C(TemplateListPage)94@4614L24,93@4572L97,96@4728L29,97@4774L24,98@4844L7,99@4877L7,100@4934L7,101@4973L7,102@5007L34,104@5075L34,107@5140L62,110@5244L115,110@5207L152,117@5389L34,118@5455L34,119@5524L80,123@5648L8,124@5685L32,126@5757L44,126@5723L78,138@6081L4045,225@10148L3804,133@5944L118,308@13954L2504,130@5807L10651,401@17740L7,416@18233L237,416@18202L268:TemplateListPage.kt#fk5gu5");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateToEditPage) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(662066678, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage (TemplateListPage.kt:92)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer3, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer3, (TopAppBarDefaults.$stable << 12) | 48, 12);
            final State templates$delegate = FlowExtKt.collectAsStateWithLifecycle(PreferenceUtil.INSTANCE.getTemplateListStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 8, 7);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final CoroutineScope scope2 = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final HapticFeedback hapticFeedback = (HapticFeedback) objConsume;
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final View view = (View) objConsume2;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final ClipboardManager clipboardManager = (ClipboardManager) objConsume3;
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer3.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Context context = (Context) objConsume4;
            $composer3.startReplaceGroup(-723721283);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showHelpDialog$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-723721215);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState isMultiSelectEnabled$delegate2 = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-723721150);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt.mutableStateListOf();
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final SnapshotStateList selectedTemplates = (SnapshotStateList) value$iv3;
            $composer3.endReplaceGroup();
            Boolean boolValueOf = Boolean.valueOf(TemplateListPage$lambda$5(isMultiSelectEnabled$delegate2));
            $composer3.startReplaceGroup(-723721046);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new TemplateListPageKt$TemplateListPage$1$1(selectedTemplates, isMultiSelectEnabled$delegate2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, 64);
            $composer3.startReplaceGroup(-723720901);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableState showDeleteDialog$delegate2 = (MutableState) value$iv5;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-723720835);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            final MutableState showShortcutsDialog$delegate3 = (MutableState) value$iv6;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-723720766);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object value$iv12 = $composer3.rememberedValue();
            if (value$iv12 == Composer.INSTANCE.getEmpty()) {
                value$iv12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CUSTOM_COMMAND)), null, 2, null);
                $composer3.updateRememberedValue(value$iv12);
            }
            final MutableState isCustomCommandEnabled$delegate = (MutableState) value$iv12;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object value$iv$iv2 = $composer3.rememberedValue();
            if (value$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, "template_id", 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv2);
            }
            final MutableIntState selectedTemplateId$delegate = (MutableIntState) value$iv$iv2;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-723720605);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = new SnackbarHostState();
                $composer3.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) value$iv7;
            $composer3.endReplaceGroup();
            boolean zTemplateListPage$lambda$5 = TemplateListPage$lambda$5(isMultiSelectEnabled$delegate2);
            $composer3.startReplaceGroup(-723720533);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateListPage.kt#9igjgp");
            Object value$iv13 = $composer3.rememberedValue();
            if (value$iv13 == Composer.INSTANCE.getEmpty()) {
                value$iv13 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$2$1
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
                        TemplateListPageKt.TemplateListPage$lambda$6(isMultiSelectEnabled$delegate2, false);
                    }
                };
                $composer3.updateRememberedValue(value$iv13);
            }
            $composer3.endReplaceGroup();
            BackHandlerKt.BackHandler(zTemplateListPage$lambda$5, (Function0) value$iv13, $composer3, 48, 0);
            $composer2 = $composer3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(388009402, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.3
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C139@6118L361,147@6498L99,151@6609L3460,139@6095L4021:TemplateListPage.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(388009402, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:139)");
                        }
                        final MutableState<Boolean> mutableState = isMultiSelectEnabled$delegate2;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1311911027, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.3.1
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
                                String str;
                                ComposerKt.sourceInformation($composer5, "C140@6136L329:TemplateListPage.kt#fk5gu5");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1311911027, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous> (TemplateListPage.kt:140)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    if (TemplateListPageKt.TemplateListPage$lambda$5(mutableState)) {
                                        $composer5.startReplaceGroup(2088343884);
                                        ComposerKt.sourceInformation($composer5, "142@6236L53");
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.custom_command_template, $composer5, 0);
                                        $composer5.endReplaceGroup();
                                        str = strStringResource;
                                    } else {
                                        $composer5.startReplaceGroup(2088343963);
                                        ComposerKt.sourceInformation($composer5, "143@6315L44");
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.custom_command, $composer5, 0);
                                        $composer5.endReplaceGroup();
                                        str = strStringResource2;
                                    }
                                    String str2 = str;
                                    TextKt.m2817Text4IGK_g(str2, (Modifier) companion, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 48, 3120, 120828);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54);
                        final Function0<Unit> function0 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(composableLambdaRememberComposableLambda, null, ComposableLambdaKt.rememberComposableLambda(-2080135691, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.3.2
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
                                Object value$iv14;
                                ComposerKt.sourceInformation($composer5, "C148@6527L56,148@6516L67:TemplateListPage.kt#fk5gu5");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2080135691, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous> (TemplateListPage.kt:148)");
                                }
                                $composer5.startReplaceGroup(2088344175);
                                ComposerKt.sourceInformation($composer5, "CC(remember):TemplateListPage.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv8 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                    value$iv14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$2$1$1
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
                                            function1.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv14);
                                } else {
                                    value$iv14 = it$iv8;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv14, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1891058594, true, new AnonymousClass3(view, showHelpDialog$delegate, isMultiSelectEnabled$delegate2, scope2, snackbarHostState, context, templates$delegate, clipboardManager), $composer4, 54), scrollBehavior, $composer4, 3462, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3, reason: invalid class name */
                /* JADX INFO: compiled from: TemplateListPage.kt */
                @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                static final class AnonymousClass3 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ ClipboardManager $clipboardManager;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ MutableState<Boolean> $isMultiSelectEnabled$delegate;
                    final /* synthetic */ CoroutineScope $scope;
                    final /* synthetic */ MutableState<Boolean> $showHelpDialog$delegate;
                    final /* synthetic */ SnackbarHostState $snackbarHostState;
                    final /* synthetic */ State<List<CommandTemplate>> $templates$delegate;
                    final /* synthetic */ View $view;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass3(View view, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, CoroutineScope coroutineScope, SnackbarHostState snackbarHostState, Context context, State<? extends List<CommandTemplate>> state, ClipboardManager clipboardManager) {
                        super(3);
                        this.$view = view;
                        this.$showHelpDialog$delegate = mutableState;
                        this.$isMultiSelectEnabled$delegate = mutableState2;
                        this.$scope = coroutineScope;
                        this.$snackbarHostState = snackbarHostState;
                        this.$context = context;
                        this.$templates$delegate = state;
                        this.$clipboardManager = clipboardManager;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                        MutableState<Boolean> $this$getValue$iv = mutableState;
                        return $this$getValue$iv.getValue().booleanValue();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                        mutableState.setValue(Boolean.valueOf(value));
                    }

                    public final void invoke(RowScope LargeTopAppBar, Composer $composer, int $changed) {
                        Object value$iv;
                        Function0<ComposeUiNode> function0;
                        final MutableState expanded$delegate;
                        Intrinsics.checkNotNullParameter(LargeTopAppBar, "$this$LargeTopAppBar");
                        ComposerKt.sourceInformation($composer, "C152@6643L34,153@6694L411,165@7171L2866:TemplateListPage.kt#fk5gu5");
                        if (($changed & 81) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1891058594, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous> (TemplateListPage.kt:152)");
                        }
                        $composer.startReplaceGroup(2088344291);
                        ComposerKt.sourceInformation($composer, "CC(remember):TemplateListPage.kt#9igjgp");
                        Object it$iv = $composer.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        MutableState expanded$delegate2 = (MutableState) value$iv;
                        $composer.endReplaceGroup();
                        final View view = this.$view;
                        final MutableState<Boolean> mutableState = this.$showHelpDialog$delegate;
                        IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.3.3.1
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
                                com.videshkarmakar.loop.p006ui.common.HapticFeedback.INSTANCE.slightHapticFeedback(view);
                                TemplateListPageKt.TemplateListPage$lambda$3(mutableState, true);
                            }
                        }, null, false, null, null, ComposableSingletons$TemplateListPageKt.INSTANCE.m7458getLambda1$app_debug(), $composer, ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
                        if (!TemplateListPageKt.TemplateListPage$lambda$5(this.$isMultiSelectEnabled$delegate)) {
                            Modifier modifier$iv = SizeKt.wrapContentSize$default(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd(), false, 2, null);
                            final CoroutineScope coroutineScope = this.$scope;
                            final SnackbarHostState snackbarHostState = this.$snackbarHostState;
                            final Context context = this.$context;
                            final State<List<CommandTemplate>> state = this.$templates$delegate;
                            final ClipboardManager clipboardManager = this.$clipboardManager;
                            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                function0 = constructor;
                                $composer.createNode(function0);
                            } else {
                                function0 = constructor;
                                $composer.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i2 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, 1711716248, "C169@7324L19,169@7303L324,178@7762L20,178@7784L2231,176@7652L2363:TemplateListPage.kt#fk5gu5");
                            $composer.startReplaceGroup(1711716269);
                            ComposerKt.sourceInformation($composer, "CC(remember):TemplateListPage.kt#9igjgp");
                            Object value$iv2 = $composer.rememberedValue();
                            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                                expanded$delegate = expanded$delegate2;
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$1$1
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
                                        TemplateListPageKt.C36453.AnonymousClass3.invoke$lambda$2(expanded$delegate, true);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                expanded$delegate = expanded$delegate2;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$TemplateListPageKt.INSTANCE.m7461getLambda2$app_debug(), $composer, 196614, 30);
                            boolean zInvoke$lambda$1 = invoke$lambda$1(expanded$delegate);
                            $composer.startReplaceGroup(1711716707);
                            ComposerKt.sourceInformation($composer, "CC(remember):TemplateListPage.kt#9igjgp");
                            Object value$iv3 = $composer.rememberedValue();
                            if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$2$1
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
                                        TemplateListPageKt.C36453.AnonymousClass3.invoke$lambda$2(expanded$delegate, false);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            }
                            $composer.endReplaceGroup();
                            final MutableState mutableState2 = expanded$delegate;
                            AndroidMenu_androidKt.m1914DropdownMenuIlH_yew(zInvoke$lambda$1, (Function0) value$iv3, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(912707480, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                    invoke(columnScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ColumnScope DropdownMenu, Composer $composer2, int $changed2) {
                                    Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                    ComposerKt.sourceInformation($composer2, "C179@7814L1040,199@8883L1106:TemplateListPage.kt#fk5gu5");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(912707480, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TemplateListPage.kt:179)");
                                        }
                                        Function2<Composer, Integer, Unit> function2M7462getLambda3$app_debug = ComposableSingletons$TemplateListPageKt.INSTANCE.m7462getLambda3$app_debug();
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final SnackbarHostState snackbarHostState2 = snackbarHostState;
                                        final Context context2 = context;
                                        final State<List<CommandTemplate>> state2 = state;
                                        final ClipboardManager clipboardManager2 = clipboardManager;
                                        final MutableState<Boolean> mutableState3 = mutableState2;
                                        AndroidMenu_androidKt.DropdownMenuItem(function2M7462getLambda3$app_debug, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3.1
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

                                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3$1$1, reason: invalid class name */
                                            /* JADX INFO: compiled from: TemplateListPage.kt */
                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3$1$1", m210f = "TemplateListPage.kt", m211i = {}, m212l = {188}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ Context $context;
                                                final /* synthetic */ SnackbarHostState $snackbarHostState;
                                                final /* synthetic */ State<List<CommandTemplate>> $templates$delegate;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                AnonymousClass1(SnackbarHostState snackbarHostState, Context context, State<? extends List<CommandTemplate>> state, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$snackbarHostState = snackbarHostState;
                                                    this.$context = context;
                                                    this.$templates$delegate = state;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$snackbarHostState, this.$context, this.$templates$delegate, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object $result) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            SnackbarHostState snackbarHostState = this.$snackbarHostState;
                                                            String string = this.$context.getString(C3070R.string.template_exported);
                                                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                            String str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(TemplateListPageKt.TemplateListPage$lambda$0(this.$templates$delegate).size())}, 1));
                                                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                                            this.label = 1;
                                                            if (SnackbarHostState.showSnackbar$default(snackbarHostState, str, null, false, null, this, 14, null) == coroutine_suspended) {
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

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(snackbarHostState2, context2, state2, null), 3, null);
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass2(clipboardManager2, mutableState3, null), 3, null);
                                            }

                                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3$1$2, reason: invalid class name */
                                            /* JADX INFO: compiled from: TemplateListPage.kt */
                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3$1$2", m210f = "TemplateListPage.kt", m211i = {}, m212l = {195}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ClipboardManager $clipboardManager;
                                                final /* synthetic */ MutableState<Boolean> $expanded$delegate;
                                                Object L$0;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass2(ClipboardManager clipboardManager, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass2> continuation) {
                                                    super(2, continuation);
                                                    this.$clipboardManager = clipboardManager;
                                                    this.$expanded$delegate = mutableState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass2(this.$clipboardManager, this.$expanded$delegate, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object $result) {
                                                    AnonymousClass2 anonymousClass2;
                                                    ClipboardManager clipboardManager;
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            anonymousClass2 = this;
                                                            clipboardManager = anonymousClass2.$clipboardManager;
                                                            anonymousClass2.L$0 = clipboardManager;
                                                            anonymousClass2.label = 1;
                                                            Object objExportTemplatesToJson = BackupUtil.INSTANCE.exportTemplatesToJson(anonymousClass2);
                                                            if (objExportTemplatesToJson == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            $result = objExportTemplatesToJson;
                                                            break;
                                                        case 1:
                                                            ClipboardManager clipboardManager2 = (ClipboardManager) this.L$0;
                                                            ResultKt.throwOnFailure($result);
                                                            clipboardManager = clipboardManager2;
                                                            anonymousClass2 = this;
                                                            break;
                                                        default:
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    clipboardManager.setText(new AnnotatedString((String) $result, null, null, 6, null));
                                                    TemplateListPageKt.C36453.AnonymousClass3.invoke$lambda$2(anonymousClass2.$expanded$delegate, false);
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                        }, null, ComposableSingletons$TemplateListPageKt.INSTANCE.m7463getLambda4$app_debug(), null, false, null, null, null, $composer2, 3078, 500);
                                        Function2<Composer, Integer, Unit> function2M7464getLambda5$app_debug = ComposableSingletons$TemplateListPageKt.INSTANCE.m7464getLambda5$app_debug();
                                        final CoroutineScope coroutineScope3 = coroutineScope;
                                        final ClipboardManager clipboardManager3 = clipboardManager;
                                        final MutableState<Boolean> mutableState4 = mutableState2;
                                        final SnackbarHostState snackbarHostState3 = snackbarHostState;
                                        final Context context3 = context;
                                        AndroidMenu_androidKt.DropdownMenuItem(function2M7464getLambda5$app_debug, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3$2$1, reason: invalid class name */
                                            /* JADX INFO: compiled from: TemplateListPage.kt */
                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$3$3$2$3$2$1", m210f = "TemplateListPage.kt", m211i = {}, m212l = {211, 212}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ClipboardManager $clipboardManager;
                                                final /* synthetic */ Context $context;
                                                final /* synthetic */ MutableState<Boolean> $expanded$delegate;
                                                final /* synthetic */ SnackbarHostState $snackbarHostState;
                                                Object L$0;
                                                Object L$1;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(ClipboardManager clipboardManager, MutableState<Boolean> mutableState, SnackbarHostState snackbarHostState, Context context, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$clipboardManager = clipboardManager;
                                                    this.$expanded$delegate = mutableState;
                                                    this.$snackbarHostState = snackbarHostState;
                                                    this.$context = context;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$clipboardManager, this.$expanded$delegate, this.$snackbarHostState, this.$context, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                /* JADX WARN: Code duplicated, block: B:23:0x00a6 A[RETURN] */
                                                /* JADX WARN: Code duplicated, block: B:24:0x00a7  */
                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object $result) {
                                                    String it;
                                                    Context context;
                                                    AnonymousClass1 anonymousClass1;
                                                    int i;
                                                    SnackbarHostState snackbarHostState;
                                                    String str;
                                                    AnonymousClass1 anonymousClass2;
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure($result);
                                                            TemplateListPageKt.C36453.AnonymousClass3.invoke$lambda$2(this.$expanded$delegate, false);
                                                            AnnotatedString text = this.$clipboardManager.getText();
                                                            if (text != null && (it = text.getText()) != null) {
                                                                SnackbarHostState snackbarHostState2 = this.$snackbarHostState;
                                                                context = this.$context;
                                                                if (it.length() > 0) {
                                                                    DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                                                                    this.L$0 = snackbarHostState2;
                                                                    this.L$1 = context;
                                                                    this.label = 1;
                                                                    Object objImportTemplatesFromJson = databaseUtil.importTemplatesFromJson(it, this);
                                                                    if (objImportTemplatesFromJson == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    anonymousClass1 = this;
                                                                    i = 0;
                                                                    $result = objImportTemplatesFromJson;
                                                                    snackbarHostState = snackbarHostState2;
                                                                    int res = ((Number) $result).intValue();
                                                                    String string = context.getString(C3070R.string.template_imported);
                                                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                                    str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(res)}, 1));
                                                                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                                                    anonymousClass1.L$0 = null;
                                                                    anonymousClass1.L$1 = null;
                                                                    anonymousClass1.label = 2;
                                                                    if (SnackbarHostState.showSnackbar$default(snackbarHostState, str, null, false, null, anonymousClass1, 14, null) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    anonymousClass2 = anonymousClass1;
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        case 1:
                                                            context = (Context) this.L$1;
                                                            SnackbarHostState snackbarHostState3 = (SnackbarHostState) this.L$0;
                                                            ResultKt.throwOnFailure($result);
                                                            anonymousClass1 = this;
                                                            i = 0;
                                                            snackbarHostState = snackbarHostState3;
                                                            int res2 = ((Number) $result).intValue();
                                                            String string2 = context.getString(C3070R.string.template_imported);
                                                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                                            str = String.format(string2, Arrays.copyOf(new Object[]{Boxing.boxInt(res2)}, 1));
                                                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                                            anonymousClass1.L$0 = null;
                                                            anonymousClass1.L$1 = null;
                                                            anonymousClass1.label = 2;
                                                            if (SnackbarHostState.showSnackbar$default(snackbarHostState, str, null, false, null, anonymousClass1, 14, null) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            anonymousClass2 = anonymousClass1;
                                                            return Unit.INSTANCE;
                                                        case 2:
                                                            anonymousClass2 = this;
                                                            ResultKt.throwOnFailure($result);
                                                            return Unit.INSTANCE;
                                                        default:
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                }
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(clipboardManager3, mutableState4, snackbarHostState3, context3, null), 3, null);
                                            }
                                        }, null, ComposableSingletons$TemplateListPageKt.INSTANCE.m7465getLambda6$app_debug(), null, false, null, null, null, $composer2, 3078, 500);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }, $composer, 54), $composer, 48, 48, 2044);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-505925509, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.4
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv14;
                    ComposerKt.sourceInformation($composer4, "C226@10182L320,237@10696L3246,233@10515L3427:TemplateListPage.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-505925509, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:226)");
                        }
                        boolean zTemplateListPage$lambda$6 = TemplateListPageKt.TemplateListPage$lambda$5(isMultiSelectEnabled$delegate2);
                        int size = selectedTemplates.size();
                        $composer4.startReplaceGroup(1957111061);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TemplateListPage.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(zTemplateListPage$lambda$6) | $composer4.changed(size);
                        SnapshotStateList<CommandTemplate> snapshotStateList = selectedTemplates;
                        State<List<CommandTemplate>> state = templates$delegate;
                        Object it$iv8 = $composer4.rememberedValue();
                        if (invalid$iv || it$iv8 == Composer.INSTANCE.getEmpty()) {
                            int size2 = snapshotStateList.size();
                            if (size2 == TemplateListPageKt.TemplateListPage$lambda$0(state).size()) {
                                value$iv14 = ToggleableState.On;
                            } else {
                                boolean z = false;
                                if (1 <= size2 && size2 < TemplateListPageKt.TemplateListPage$lambda$0(state).size()) {
                                    z = true;
                                }
                                value$iv14 = z ? ToggleableState.Indeterminate : ToggleableState.Off;
                            }
                            $composer4.updateRememberedValue(value$iv14);
                        } else {
                            value$iv14 = it$iv8;
                        }
                        final ToggleableState checkBoxState = (ToggleableState) value$iv14;
                        $composer4.endReplaceGroup();
                        boolean zTemplateListPage$lambda$7 = TemplateListPageKt.TemplateListPage$lambda$5(isMultiSelectEnabled$delegate2);
                        EnterTransition enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        ExitTransition exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        final SnapshotStateList<CommandTemplate> snapshotStateList2 = selectedTemplates;
                        final View view2 = view;
                        final State<List<CommandTemplate>> state2 = templates$delegate;
                        final CoroutineScope coroutineScope = scope2;
                        final SnackbarHostState snackbarHostState2 = snackbarHostState;
                        final Context context2 = context;
                        final ClipboardManager clipboardManager2 = clipboardManager;
                        final MutableState<Boolean> mutableState = showDeleteDialog$delegate2;
                        AnimatedVisibilityKt.AnimatedVisibility(zTemplateListPage$lambda$7, (Modifier) null, enterTransitionPlus, exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(590203219, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed3) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C239@10728L3199,239@10715L3212:TemplateListPage.kt#fk5gu5");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(590203219, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous> (TemplateListPage.kt:239)");
                                }
                                final ToggleableState toggleableState = checkBoxState;
                                final SnapshotStateList<CommandTemplate> snapshotStateList3 = snapshotStateList2;
                                final View view3 = view2;
                                final State<List<CommandTemplate>> state3 = state2;
                                final CoroutineScope coroutineScope2 = coroutineScope;
                                final SnackbarHostState snackbarHostState3 = snackbarHostState2;
                                final Context context3 = context2;
                                final ClipboardManager clipboardManager3 = clipboardManager2;
                                final MutableState<Boolean> mutableState2 = mutableState;
                                AppBarKt.m1915BottomAppBar1oL4kX8(null, 0L, 0L, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(-1061873333, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.4.1.1
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

                                    public final void invoke(RowScope BottomAppBar, Composer $composer6, int $changed4) {
                                        Intrinsics.checkNotNullParameter(BottomAppBar, "$this$BottomAppBar");
                                        ComposerKt.sourceInformation($composer6, "C240@10750L3158:TemplateListPage.kt#fk5gu5");
                                        if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1061873333, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous>.<anonymous> (TemplateListPage.kt:240)");
                                            }
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            final ToggleableState toggleableState2 = toggleableState;
                                            final SnapshotStateList<CommandTemplate> snapshotStateList4 = snapshotStateList3;
                                            final View view4 = view3;
                                            final State<List<CommandTemplate>> state4 = state3;
                                            final CoroutineScope coroutineScope3 = coroutineScope2;
                                            final SnackbarHostState snackbarHostState4 = snackbarHostState3;
                                            final Context context4 = context3;
                                            final ClipboardManager clipboardManager4 = clipboardManager3;
                                            final MutableState<Boolean> mutableState3 = mutableState2;
                                            ComposerKt.sourceInformationMarkerStart($composer6, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, centerVertically, $composer6, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                            int $changed$iv$iv = (390 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifierFillMaxWidth$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                            if (!($composer6.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer6.startReusableNode();
                                            if ($composer6.getInserting()) {
                                                $composer6.createNode(constructor);
                                            } else {
                                                $composer6.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer6);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                            int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer6, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                            int i3 = ((390 >> 6) & 112) | 6;
                                            RowScope $this$invoke_u24lambda_u240 = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart($composer6, 1906357864, "C244@10934L535,256@11536L135,259@11723L10,255@11495L336,263@11857L1455,291@13337L549:TemplateListPage.kt#fk5gu5");
                                            CheckboxKt.TriStateCheckbox(toggleableState2, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$4$1$1$1$1

                                                /* JADX INFO: compiled from: TemplateListPage.kt */
                                                @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                public /* synthetic */ class WhenMappings {
                                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                    static {
                                                        int[] iArr = new int[ToggleableState.values().length];
                                                        try {
                                                            iArr[ToggleableState.On.ordinal()] = 1;
                                                        } catch (NoSuchFieldError e) {
                                                        }
                                                        $EnumSwitchMapping$0 = iArr;
                                                    }
                                                }

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
                                                    com.videshkarmakar.loop.p006ui.common.HapticFeedback.INSTANCE.slightHapticFeedback(view4);
                                                    if (WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()] != 1) {
                                                        SnapshotStateList<CommandTemplate> snapshotStateList5 = snapshotStateList4;
                                                        State<List<CommandTemplate>> state5 = state4;
                                                        snapshotStateList5.clear();
                                                        snapshotStateList5.addAll(TemplateListPageKt.TemplateListPage$lambda$0(state5));
                                                        return;
                                                    }
                                                    snapshotStateList4.clear();
                                                }
                                            }, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), false, null, null, $composer6, 384, 56);
                                            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.selected_item_count, new Object[]{Integer.valueOf(snapshotStateList4.size())}, $composer6, 64), RowScope.CC.weight$default($this$invoke_u24lambda_u240, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer6, MaterialTheme.$stable).getLabelLarge(), $composer6, 0, 0, 65532);
                                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$4$1$1$1$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$4$1$1$1$2$1 */
                                                /* JADX INFO: compiled from: TemplateListPage.kt */
                                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$4$1$1$1$2$1", m210f = "TemplateListPage.kt", m211i = {}, m212l = {268}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                static final class C36491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ Context $context;
                                                    final /* synthetic */ SnapshotStateList<CommandTemplate> $selectedTemplates;
                                                    final /* synthetic */ SnackbarHostState $snackbarHostState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C36491(SnackbarHostState snackbarHostState, Context context, SnapshotStateList<CommandTemplate> snapshotStateList, Continuation<? super C36491> continuation) {
                                                        super(2, continuation);
                                                        this.$snackbarHostState = snackbarHostState;
                                                        this.$context = context;
                                                        this.$selectedTemplates = snapshotStateList;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C36491(this.$snackbarHostState, this.$context, this.$selectedTemplates, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C36491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object $result) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure($result);
                                                                SnackbarHostState snackbarHostState = this.$snackbarHostState;
                                                                String string = this.$context.getString(C3070R.string.template_exported);
                                                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                                String str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$selectedTemplates.size())}, 1));
                                                                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                                                this.label = 1;
                                                                if (SnackbarHostState.showSnackbar$default(snackbarHostState, str, null, false, null, this, 14, null) == coroutine_suspended) {
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

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                    com.videshkarmakar.loop.p006ui.common.HapticFeedback.INSTANCE.slightHapticFeedback(view4);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C36491(snackbarHostState4, context4, snapshotStateList4, null), 3, null);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C36502(clipboardManager4, snapshotStateList4, null), 3, null);
                                                }

                                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$4$1$1$1$2$2 */
                                                /* JADX INFO: compiled from: TemplateListPage.kt */
                                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$4$1$1$1$2$2", m210f = "TemplateListPage.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                                static final class C36502 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ClipboardManager $clipboardManager;
                                                    final /* synthetic */ SnapshotStateList<CommandTemplate> $selectedTemplates;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C36502(ClipboardManager clipboardManager, SnapshotStateList<CommandTemplate> snapshotStateList, Continuation<? super C36502> continuation) {
                                                        super(2, continuation);
                                                        this.$clipboardManager = clipboardManager;
                                                        this.$selectedTemplates = snapshotStateList;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C36502(this.$clipboardManager, this.$selectedTemplates, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C36502) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure(obj);
                                                                this.$clipboardManager.setText(new AnnotatedString(BackupUtil.INSTANCE.exportTemplatesToJson(this.$selectedTemplates, CollectionsKt.emptyList()), null, null, 6, null));
                                                                return Unit.INSTANCE;
                                                            default:
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                    }
                                                }
                                            };
                                            SnapshotStateList<CommandTemplate> snapshotStateList5 = snapshotStateList4;
                                            IconButtonKt.IconButton(function0, null, !snapshotStateList5.isEmpty(), null, null, ComposableSingletons$TemplateListPageKt.INSTANCE.m7466getLambda7$app_debug(), $composer6, ProfileVerifier.CompilationStatus.f245xf2722a21, 26);
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$4$1$1$1$3
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
                                                    com.videshkarmakar.loop.p006ui.common.HapticFeedback.INSTANCE.slightHapticFeedback(view4);
                                                    TemplateListPageKt.TemplateListPage$lambda$11(mutableState3, true);
                                                }
                                            }, null, !snapshotStateList5.isEmpty(), null, null, ComposableSingletons$TemplateListPageKt.INSTANCE.m7467getLambda8$app_debug(), $composer6, ProfileVerifier.CompilationStatus.f245xf2722a21, 26);
                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                            $composer6.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                            ComposerKt.sourceInformationMarkerEnd($composer6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }, $composer5, 54), $composer5, 1572864, 63);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, 200064, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-1399860420, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C134@5958L94:TemplateListPage.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1399860420, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:134)");
                        }
                        SnackbarHostKt.SnackbarHost(snackbarHostState, Modifier.INSTANCE, null, $composer4, 54, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(432087237, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.6
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
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C309@13964L2488:TemplateListPage.kt#fk5gu5");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(it) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(432087237, $dirty4, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:309)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                        final MutableState<Boolean> mutableState = isCustomCommandEnabled$delegate;
                        final State<List<CommandTemplate>> state = templates$delegate;
                        final SnapshotStateList<CommandTemplate> snapshotStateList = selectedTemplates;
                        final Function1<Integer, Unit> function1 = onNavigateToEditPage;
                        final MutableIntState mutableIntState = selectedTemplateId$delegate;
                        final MutableState<Boolean> mutableState2 = isMultiSelectEnabled$delegate2;
                        final HapticFeedback hapticFeedback2 = hapticFeedback;
                        final MutableState<Boolean> mutableState3 = showShortcutsDialog$delegate3;
                        LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.6.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                final MutableState<Boolean> mutableState4 = mutableState;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2035857743, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.6.1.1
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
                                        Object value$iv14;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C311@14083L43,314@14247L241,311@14045L444:TemplateListPage.kt#fk5gu5");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2035857743, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous>.<anonymous> (TemplateListPage.kt:311)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.use_custom_command, $composer5, 0);
                                            boolean zTemplateListPage$lambda$16 = TemplateListPageKt.TemplateListPage$lambda$16(mutableState4);
                                            $composer5.startReplaceGroup(1711723192);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):TemplateListPage.kt#9igjgp");
                                            final MutableState<Boolean> mutableState5 = mutableState4;
                                            Object it$iv8 = $composer5.rememberedValue();
                                            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                value$iv14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$1$1$1
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
                                                        TemplateListPageKt.TemplateListPage$lambda$17(mutableState5, !TemplateListPageKt.TemplateListPage$lambda$16(mutableState5));
                                                        PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.CUSTOM_COMMAND, TemplateListPageKt.TemplateListPage$lambda$16(mutableState5));
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv14);
                                            } else {
                                                value$iv14 = it$iv8;
                                            }
                                            $composer5.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceSwitchWithContainer(strStringResource, null, zTemplateListPage$lambda$16, (Function0) value$iv14, $composer5, 3120, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final List items$iv = TemplateListPageKt.TemplateListPage$lambda$0(state);
                                final SnapshotStateList<CommandTemplate> snapshotStateList2 = snapshotStateList;
                                final Function1<Integer, Unit> function2 = function1;
                                final MutableIntState mutableIntState2 = mutableIntState;
                                final MutableState<Boolean> mutableState5 = mutableState2;
                                final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                final Function1 contentType$iv = new Function1() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$invoke$$inlined$items$default$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        return invoke((CommandTemplate) p1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Void invoke(CommandTemplate commandTemplate) {
                                        return null;
                                    }
                                };
                                LazyColumn.items(items$iv.size(), null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$invoke$$inlined$items$default$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        return contentType$iv.invoke(items$iv.get(index));
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$invoke$$inlined$items$default$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope $this$items, int it2, Composer $composer5, int $changed3) {
                                        Object value$iv14;
                                        Object value$iv15;
                                        Object value$iv16;
                                        ComposerKt.sourceInformation($composer5, "C152@7074L22:LazyDsl.kt#428nma");
                                        int $dirty5 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty5 |= $composer5.changed($this$items) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty5 |= $composer5.changed(it2) ? 32 : 16;
                                        }
                                        if (($dirty5 & 147) == 146 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-632812321, $dirty5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                                        }
                                        int $changed4 = $dirty5 & 14;
                                        final CommandTemplate commandTemplate = (CommandTemplate) items$iv.get(it2);
                                        $composer5.startReplaceGroup(1711723515);
                                        ComposerKt.sourceInformation($composer5, "C*333@15213L88,336@15334L169,326@14846L260,322@14570L1179:TemplateListPage.kt#fk5gu5");
                                        String name = commandTemplate.getName();
                                        String template = commandTemplate.getTemplate();
                                        boolean z = TemplateListPageKt.TemplateListPage$lambda$18(mutableIntState2) == commandTemplate.getId();
                                        boolean zTemplateListPage$lambda$6 = TemplateListPageKt.TemplateListPage$lambda$5(mutableState5);
                                        boolean zContains = snapshotStateList2.contains(commandTemplate);
                                        $composer5.startReplaceGroup(1711724158);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):TemplateListPage.kt#9igjgp");
                                        boolean invalid$iv = (((($changed4 & 112) ^ 48) > 32 && $composer5.changed(commandTemplate)) || ($changed4 & 48) == 32) | $composer5.changed(function2);
                                        Object it$iv8 = $composer5.rememberedValue();
                                        if (invalid$iv || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                            final Function1 function3 = function2;
                                            value$iv14 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$2$1$1
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
                                                    function3.invoke(Integer.valueOf(commandTemplate.getId()));
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv14);
                                        } else {
                                            value$iv14 = it$iv8;
                                        }
                                        Function0 function0 = (Function0) value$iv14;
                                        $composer5.endReplaceGroup();
                                        $composer5.startReplaceGroup(1711724279);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):TemplateListPage.kt#9igjgp");
                                        boolean invalid$iv2 = $composer5.changed(mutableIntState2) | (((($changed4 & 112) ^ 48) > 32 && $composer5.changed(commandTemplate)) || ($changed4 & 48) == 32);
                                        Object it$iv9 = $composer5.rememberedValue();
                                        if (invalid$iv2 || it$iv9 == Composer.INSTANCE.getEmpty()) {
                                            final MutableIntState mutableIntState3 = mutableIntState2;
                                            value$iv15 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$2$2$1
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
                                                    mutableIntState3.setIntValue(commandTemplate.getId());
                                                    PreferenceUtil.INSTANCE.encodeInt("template_id", TemplateListPageKt.TemplateListPage$lambda$18(mutableIntState3));
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv15);
                                        } else {
                                            value$iv15 = it$iv9;
                                        }
                                        Function0 function4 = (Function0) value$iv15;
                                        $composer5.endReplaceGroup();
                                        $composer5.startReplaceGroup(1711723791);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):TemplateListPage.kt#9igjgp");
                                        boolean invalid$iv3 = ((($changed4 & 112) ^ 48) > 32 && $composer5.changed(commandTemplate)) || ($changed4 & 48) == 32;
                                        Object it$iv10 = $composer5.rememberedValue();
                                        if (invalid$iv3 || it$iv10 == Composer.INSTANCE.getEmpty()) {
                                            final SnapshotStateList snapshotStateList3 = snapshotStateList2;
                                            value$iv16 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$2$3$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) throws Throwable {
                                                    invoke(bool.booleanValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(boolean it3) throws Throwable {
                                                    if (snapshotStateList3.contains(commandTemplate)) {
                                                        snapshotStateList3.remove(commandTemplate);
                                                    } else {
                                                        snapshotStateList3.add(commandTemplate);
                                                    }
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv16);
                                        } else {
                                            value$iv16 = it$iv10;
                                        }
                                        Function1 function5 = (Function1) value$iv16;
                                        $composer5.endReplaceGroup();
                                        final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                        final SnapshotStateList snapshotStateList4 = snapshotStateList2;
                                        final MutableState mutableState6 = mutableState5;
                                        PreferenceItemsKt.TemplateItem(name, template, z, zTemplateListPage$lambda$6, zContains, function0, function4, function5, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$2$4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() throws Throwable {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() throws Throwable {
                                                hapticFeedback4.mo5032performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5040getLongPress5zf0vsI());
                                                TemplateListPageKt.TemplateListPage$lambda$6(mutableState6, true);
                                                snapshotStateList4.add(commandTemplate);
                                            }
                                        }, $composer5, 0, 0);
                                        $composer5.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                if (!TemplateListPageKt.TemplateListPage$lambda$5(mutableState2)) {
                                    final Function1<Integer, Unit> function3 = function1;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1516568886, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.6.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                            Object value$iv14;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C348@15903L42,350@16019L72,347@15848L243:TemplateListPage.kt#fk5gu5");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1516568886, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous>.<anonymous> (TemplateListPage.kt:347)");
                                                }
                                                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.new_template, $composer5, 0);
                                                ImageVector add = AddKt.getAdd(Icons.Outlined.INSTANCE);
                                                $composer5.startReplaceGroup(1711724964);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):TemplateListPage.kt#9igjgp");
                                                boolean invalid$iv = $composer5.changed(function3);
                                                final Function1<Integer, Unit> function4 = function3;
                                                Object it$iv8 = $composer5.rememberedValue();
                                                if (invalid$iv || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$3$1$1
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
                                                            function4.invoke(-1);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv14);
                                                } else {
                                                    value$iv14 = it$iv8;
                                                }
                                                $composer5.endReplaceGroup();
                                                PreferenceItemsKt.PreferenceItemVariant(null, strStringResource, null, add, false, null, null, null, (Function0) value$iv14, $composer5, 0, 245);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableState<Boolean> mutableState6 = mutableState3;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1837466593, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.6.1.4
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
                                            Object value$iv14;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C356@16208L44,358@16335L74,355@16153L256:TemplateListPage.kt#fk5gu5");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1837466593, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous>.<anonymous>.<anonymous> (TemplateListPage.kt:355)");
                                                }
                                                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.edit_shortcuts, $composer5, 0);
                                                ImageVector bookmarkAdd = BookmarkAddKt.getBookmarkAdd(Icons.Outlined.INSTANCE);
                                                $composer5.startReplaceGroup(1711725280);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):TemplateListPage.kt#9igjgp");
                                                final MutableState<Boolean> mutableState7 = mutableState6;
                                                Object it$iv8 = $composer5.rememberedValue();
                                                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$6$1$4$1$1
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
                                                            TemplateListPageKt.TemplateListPage$lambda$14(mutableState7, true);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv14);
                                                } else {
                                                    value$iv14 = it$iv8;
                                                }
                                                $composer5.endReplaceGroup();
                                                PreferenceItemsKt.PreferenceItemVariant(null, strStringResource, null, bookmarkAdd, false, null, null, null, (Function0) value$iv14, $composer5, 100663296, 245);
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
                            }
                        }, $composer4, 0, 254);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, 805309872, 496);
            $composer2.startReplaceGroup(-723709827);
            ComposerKt.sourceInformation($composer2, "367@16526L28,382@17202L376,381@17126L46,370@16705L391,367@16495L1084");
            if (TemplateListPage$lambda$10(showDeleteDialog$delegate2)) {
                $composer2.startReplaceGroup(-723709764);
                ComposerKt.sourceInformation($composer2, "CC(remember):TemplateListPage.kt#9igjgp");
                Object it$iv8 = $composer2.rememberedValue();
                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                    showDeleteDialog$delegate = showDeleteDialog$delegate2;
                    value$iv11 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$7$1
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
                            TemplateListPageKt.TemplateListPage$lambda$11(showDeleteDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv11);
                } else {
                    showDeleteDialog$delegate = showDeleteDialog$delegate2;
                    value$iv11 = it$iv8;
                }
                Function0 function0 = (Function0) value$iv11;
                $composer2.endReplaceGroup();
                isMultiSelectEnabled$delegate = isMultiSelectEnabled$delegate2;
                scope = scope2;
                AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1694353097, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.8
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
                        ComposerKt.sourceInformation($composer4, "C383@17220L344:TemplateListPage.kt#fk5gu5");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1694353097, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:383)");
                            }
                            final CoroutineScope coroutineScope = scope;
                            final SnapshotStateList<CommandTemplate> snapshotStateList = selectedTemplates;
                            final MutableState<Boolean> mutableState = isMultiSelectEnabled$delegate;
                            final MutableState<Boolean> mutableState2 = showDeleteDialog$delegate;
                            ButtonsKt.ConfirmButton(null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.8.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$8$1$1, reason: invalid class name and collision with other inner class name */
                                /* JADX INFO: compiled from: TemplateListPage.kt */
                                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$8$1$1", m210f = "TemplateListPage.kt", m211i = {}, m212l = {386}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                static final class C46091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $isMultiSelectEnabled$delegate;
                                    final /* synthetic */ SnapshotStateList<CommandTemplate> $selectedTemplates;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C46091(SnapshotStateList<CommandTemplate> snapshotStateList, MutableState<Boolean> mutableState, Continuation<? super C46091> continuation) {
                                        super(2, continuation);
                                        this.$selectedTemplates = snapshotStateList;
                                        this.$isMultiSelectEnabled$delegate = mutableState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C46091(this.$selectedTemplates, this.$isMultiSelectEnabled$delegate, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C46091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$8$1$1$1, reason: invalid class name and collision with other inner class name */
                                    /* JADX INFO: compiled from: TemplateListPage.kt */
                                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$8$1$1$1", m210f = "TemplateListPage.kt", m211i = {}, m212l = {387}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                    static final class C46101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ SnapshotStateList<CommandTemplate> $selectedTemplates;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C46101(SnapshotStateList<CommandTemplate> snapshotStateList, Continuation<? super C46101> continuation) {
                                            super(2, continuation);
                                            this.$selectedTemplates = snapshotStateList;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C46101(this.$selectedTemplates, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C46101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object $result) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    this.label = 1;
                                                    if (DatabaseUtil.INSTANCE.deleteTemplates(this.$selectedTemplates, this) == coroutine_suspended) {
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

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        C46091 c46091;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (BuildersKt.withContext(Dispatchers.getIO(), new C46101(this.$selectedTemplates, null), this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                c46091 = this;
                                                break;
                                                break;
                                            case 1:
                                                c46091 = this;
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        TemplateListPageKt.TemplateListPage$lambda$6(c46091.$isMultiSelectEnabled$delegate, false);
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C46091(snapshotStateList, mutableState, null), 3, null);
                                    TemplateListPageKt.TemplateListPage$lambda$11(mutableState2, false);
                                }
                            }, $composer4, 0, 3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(-706280313, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.9
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
                        Object value$iv14;
                        ComposerKt.sourceInformation($composer4, "C381@17142L28,381@17128L42:TemplateListPage.kt#fk5gu5");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-706280313, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:381)");
                        }
                        $composer4.startReplaceGroup(1957118021);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TemplateListPage.kt#9igjgp");
                        final MutableState<Boolean> mutableState = showDeleteDialog$delegate;
                        Object it$iv9 = $composer4.rememberedValue();
                        if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                            value$iv14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$9$1$1
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
                                    TemplateListPageKt.TemplateListPage$lambda$11(mutableState, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv14);
                        } else {
                            value$iv14 = it$iv9;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv14, $composer4, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), ComposableSingletons$TemplateListPageKt.INSTANCE.m7468getLambda9$app_debug(), ComposableSingletons$TemplateListPageKt.INSTANCE.m7459getLambda10$app_debug(), ComposableLambdaKt.rememberComposableLambda(2135220516, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.10
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
                        ComposerKt.sourceInformation($composer4, "C373@16829L213,372@16749L315,371@16723L359:TemplateListPage.kt#fk5gu5");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2135220516, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:371)");
                            }
                            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.remove_multiple_templates_msg, new Object[]{StringResources_androidKt.pluralStringResource(C3070R.plurals.item_count, selectedTemplates.size(), new Object[]{Integer.valueOf(selectedTemplates.size())}, $composer4, 512)}, $composer4, 64), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
            } else {
                isMultiSelectEnabled$delegate = isMultiSelectEnabled$delegate2;
                scope = scope2;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-723708698);
            ComposerKt.sourceInformation($composer2, "397@17645L51,397@17627L69");
            if (TemplateListPage$lambda$13(showShortcutsDialog$delegate3)) {
                $composer2.startReplaceGroup(-723708645);
                ComposerKt.sourceInformation($composer2, "CC(remember):TemplateListPage.kt#9igjgp");
                Object it$iv9 = $composer2.rememberedValue();
                if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                    showShortcutsDialog$delegate = showShortcutsDialog$delegate3;
                    value$iv10 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$11$1
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
                            TemplateListPageKt.TemplateListPage$lambda$14(showShortcutsDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv10);
                } else {
                    showShortcutsDialog$delegate = showShortcutsDialog$delegate3;
                    value$iv10 = it$iv9;
                }
                $composer2.endReplaceGroup();
                i = 0;
                CommandTemplateDialogKt.OptionChipsDialog((Function0) value$iv10, $composer2, 6, 0);
            } else {
                scope = scope;
                i = 0;
                showShortcutsDialog$delegate = showShortcutsDialog$delegate3;
            }
            $composer2.endReplaceGroup();
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume5 = $composer2.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final UriHandler uriHandler = (UriHandler) objConsume5;
            $composer2.startReplaceGroup(-723708538);
            ComposerKt.sourceInformation($composer2, "404@17813L54,405@17900L26,406@17959L231,403@17782L408");
            if (TemplateListPage$lambda$2(showHelpDialog$delegate)) {
                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.custom_command_usage_msg, $composer2, i);
                $composer2.startReplaceGroup(-723708390);
                ComposerKt.sourceInformation($composer2, "CC(remember):TemplateListPage.kt#9igjgp");
                Object it$iv10 = $composer2.rememberedValue();
                if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                    showShortcutsDialog$delegate2 = showHelpDialog$delegate;
                    value$iv9 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt$TemplateListPage$12$1
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
                            TemplateListPageKt.TemplateListPage$lambda$3(showShortcutsDialog$delegate2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv9);
                } else {
                    showShortcutsDialog$delegate2 = showHelpDialog$delegate;
                    value$iv9 = it$iv10;
                }
                $composer2.endReplaceGroup();
                DialogsKt.HelpDialog(strStringResource, (Function0) value$iv9, null, ComposableLambdaKt.rememberComposableLambda(870527042, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.13
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
                        ComposerKt.sourceInformation($composer4, "C407@17973L207:TemplateListPage.kt#fk5gu5");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(870527042, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateListPage.<anonymous> (TemplateListPage.kt:407)");
                            }
                            final UriHandler uriHandler2 = uriHandler;
                            final MutableState<Boolean> mutableState = showShortcutsDialog$delegate2;
                            ButtonKt.TextButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.13.1
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
                                    TemplateListPageKt.TemplateListPage$lambda$3(mutableState, false);
                                    uriHandler2.openUri(LinksKt.ytdlpUrl);
                                }
                            }, null, false, null, null, null, null, null, null, ComposableSingletons$TemplateListPageKt.INSTANCE.m7460getLambda11$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 3504, 0);
            }
            $composer2.endReplaceGroup();
            Integer numValueOf = Integer.valueOf(TemplateListPage$lambda$0(templates$delegate).size());
            $composer2.startReplaceGroup(-723708057);
            ComposerKt.sourceInformation($composer2, "CC(remember):TemplateListPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(templates$delegate) | $composer2.changed(selectedTemplateId$delegate);
            Object it$iv11 = $composer2.rememberedValue();
            if (invalid$iv || it$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv8 = new TemplateListPageKt$TemplateListPage$14$1(templates$delegate, selectedTemplateId$delegate, null);
                $composer2.updateRememberedValue(value$iv8);
            } else {
                value$iv8 = it$iv11;
            }
            $composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv8, $composer2, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateListPageKt.TemplateListPage.15
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

                public final void invoke(Composer composer, int i2) {
                    TemplateListPageKt.TemplateListPage(onNavigateBack, onNavigateToEditPage, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CommandTemplate> TemplateListPage$lambda$0(State<? extends List<CommandTemplate>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    private static final boolean TemplateListPage$lambda$2(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplateListPage$lambda$3(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TemplateListPage$lambda$5(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplateListPage$lambda$6(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean TemplateListPage$lambda$10(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplateListPage$lambda$11(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean TemplateListPage$lambda$13(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplateListPage$lambda$14(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TemplateListPage$lambda$16(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplateListPage$lambda$17(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TemplateListPage$lambda$18(MutableIntState $selectedTemplateId$delegate) {
        MutableIntState $this$getValue$iv = $selectedTemplateId$delegate;
        return $this$getValue$iv.getIntValue();
    }
}
