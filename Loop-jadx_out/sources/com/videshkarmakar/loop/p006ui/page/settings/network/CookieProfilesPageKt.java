package com.videshkarmakar.loop.p006ui.page.settings.network;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.CookieManager;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.C0056R;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.GeneratingTokensKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.hapticfeedback.HapticFeedback;
import androidx.compose.p001ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.PlatformImeOptions;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.LineBreak;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.objects.CookieProfile;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.DialogItemsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import com.videshkarmakar.loop.p006ui.component.DividerKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.p006ui.theme.ColorSchemeKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.FileUtil;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: CookieProfilesPage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\n\u001as\u0010\r\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000fX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002"}, m195d2 = {"ClearCookiesDialog", "", "onDismissRequest", "Lkotlin/Function0;", "onConfirm", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CookieGeneratorDialog", "cookiesViewModel", "Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;", "navigateToCookieGeneratorPage", "(Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CookieProfilePage", "onNavigateBack", "CookiesQuickSettingsDialog", "cookieProfiles", "", "Lcom/videshkarmakar/loop/database/objects/CookieProfile;", "onCookieProfileClicked", "Lkotlin/Function1;", "isCookiesEnabled", "", "onCookiesToggled", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/util/List;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "CookiesQuickSettingsDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "DeleteCookieDialog", "(Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "state", "Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel$ViewState;", "showClearCookieDialog", "isCookieEnabled", "showHelpDialog", "cookieList", "Lcom/videshkarmakar/loop/ui/page/settings/network/Cookie;", "shouldUpdateCookies", "expanded", "userAgent"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CookieProfilesPageKt {
    public static final void CookieProfilePage(CookiesViewModel cookiesViewModel, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function2;
        Function0<Unit> function3;
        final CookiesViewModel cookiesViewModel2;
        C39131 c39131;
        C39162 c39162;
        Object value$iv$iv;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        final MutableState shouldUpdateCookies$delegate;
        int i2;
        String str;
        CookiesViewModel cookiesViewModel3;
        Function0<Unit> function4;
        Object value$iv6;
        Object value$iv7;
        Composer $composer2 = $composer.startRestartGroup(1022630176);
        ComposerKt.sourceInformation($composer2, "C(CookieProfilePage)108@5449L11,113@5639L24,112@5597L97,115@5742L27,116@5792L24,117@5862L7,118@5901L7,119@5958L7,120@6010L29,121@6073L34,122@6135L61,124@6275L34,125@6335L7,127@6366L57,131@6456L46,135@6508L379,149@6923L396,163@7473L3197,235@10682L2347,159@7325L5704,308@13699L33,308@13661L326:CookieProfilesPage.kt#sffru");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            function2 = function0;
        } else if (($changed & 112) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = function0;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            function3 = function1;
        } else if (($changed & 896) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        if (i3 == 1 && ($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            cookiesViewModel3 = cookiesViewModel;
            function4 = function2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i3 != 0) {
                    $composer2.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation($composer2, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
                    ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
                    if (viewModelStoreOwner$iv == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    CreationExtras extras$iv = viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(CookiesViewModel.class), viewModelStoreOwner$iv, (String) null, (ViewModelProvider.Factory) null, extras$iv, $composer2, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344), 0);
                    $composer2.endReplaceableGroup();
                    cookiesViewModel2 = (CookiesViewModel) viewModel;
                    $dirty &= -15;
                } else {
                    cookiesViewModel2 = cookiesViewModel;
                }
                c39131 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function2;
                c39162 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.2
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function1;
            } else {
                $composer2.skipToGroupEnd();
                if (i3 != 0) {
                    $dirty &= -15;
                }
                cookiesViewModel2 = cookiesViewModel;
                c39131 = function2;
                c39162 = function3;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1022630176, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage (CookieProfilesPage.kt:111)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer2, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer2, (TopAppBarDefaults.$stable << 12) | 48, 12);
            final List cookies = (List) SnapshotStateKt.collectAsState(cookiesViewModel2.getCookiesFlow(), CollectionsKt.emptyList(), null, $composer2, 56, 2).getValue();
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
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final HapticFeedback hapticFeedback = (HapticFeedback) objConsume;
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) objConsume2;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State state$delegate = FlowExtKt.collectAsStateWithLifecycle(cookiesViewModel2.getStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            $composer2.startReplaceGroup(508667917);
            ComposerKt.sourceInformation($composer2, "CC(remember):CookieProfilesPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showClearCookieDialog$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(508667979);
            ComposerKt.sourceInformation($composer2, "CC(remember):CookieProfilesPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.COOKIES)), null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState isCookieEnabled$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            final CookieManager cookieManager = CookieManager.getInstance();
            $composer2.startReplaceGroup(508668119);
            ComposerKt.sourceInformation($composer2, "CC(remember):CookieProfilesPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState showHelpDialog$delegate = (MutableState) value$iv3;
            $composer2.endReplaceGroup();
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view = (View) objConsume4;
            $composer2.startReplaceGroup(508668210);
            ComposerKt.sourceInformation($composer2, "CC(remember):CookieProfilesPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final MutableState cookieList$delegate = (MutableState) value$iv4;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(508668300);
            ComposerKt.sourceInformation($composer2, "CC(remember):CookieProfilesPage.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableState shouldUpdateCookies$delegate2 = (MutableState) value$iv5;
            $composer2.endReplaceGroup();
            EffectsKt.DisposableEffect(Boolean.valueOf(CookieProfilePage$lambda$14(shouldUpdateCookies$delegate2)), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$3$1, reason: invalid class name */
                /* JADX INFO: compiled from: CookieProfilesPage.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$3$1", m210f = "CookieProfilesPage.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Context $context;
                    final /* synthetic */ MutableState<List<Cookie>> $cookieList$delegate;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(Context context, MutableState<List<Cookie>> mutableState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$context = context;
                        this.$cookieList$delegate = mutableState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$context, this.$cookieList$delegate, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                Object objM7673getCookieListFromDatabased1pmJ48 = DownloadUtil.INSTANCE.m7673getCookieListFromDatabased1pmJ48();
                                if (Result.m7699isFailureimpl(objM7673getCookieListFromDatabased1pmJ48)) {
                                    objM7673getCookieListFromDatabased1pmJ48 = null;
                                }
                                List<Cookie> list = (List) objM7673getCookieListFromDatabased1pmJ48;
                                if (list != null) {
                                    Context context = this.$context;
                                    CookieProfilesPageKt.CookieProfilePage$lambda$12(this.$cookieList$delegate, list);
                                    FileUtil.INSTANCE.writeContentToFile(DownloadUtil.INSTANCE.toCookiesFileContent(list), FileUtil.INSTANCE.getCookiesFile(context));
                                }
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new AnonymousClass1(context, cookieList$delegate, null), 2, null);
                    final MutableState<Boolean> mutableState = shouldUpdateCookies$delegate2;
                    return new DisposableEffectResult() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$3$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            CookieProfilesPageKt.CookieProfilePage$lambda$15(mutableState, false);
                        }
                    };
                }
            }, $composer2, 0);
            final ManagedActivityResultLauncher exportLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.CreateDocument("text/plain"), new Function1<Uri, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$exportLauncher$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                    invoke2(uri);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Uri uri) {
                    if (uri != null) {
                        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new CookieProfilesPageKt$CookieProfilePage$exportLauncher$1$1$1(context, uri, cookieList$delegate, null), 2, null);
                    }
                }
            }, $composer2, 8);
            final Function0<Unit> function5 = c39162;
            Function0<Unit> function6 = c39162;
            final CookiesViewModel cookiesViewModel4 = cookiesViewModel2;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(897107684, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.4
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
                    ComposerKt.sourceInformation($composer3, "C169@7691L99,173@7802L2824,164@7487L3173:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(897107684, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous> (CookieProfilesPage.kt:164)");
                        }
                        Function2<Composer, Integer, Unit> function2M7572getLambda1$app_debug = ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7572getLambda1$app_debug();
                        final Function0<Unit> function7 = function5;
                        TopAppBarKt.LargeTopAppBar(function2M7572getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-1860144225, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.4.1
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
                                Object value$iv8;
                                ComposerKt.sourceInformation($composer4, "C170@7720L56,170@7709L67:CookieProfilesPage.kt#sffru");
                                if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1860144225, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous>.<anonymous> (CookieProfilesPage.kt:170)");
                                }
                                $composer4.startReplaceGroup(-2099655362);
                                ComposerKt.sourceInformation($composer4, "CC(remember):CookieProfilesPage.kt#9igjgp");
                                boolean invalid$iv = $composer4.changed(function7);
                                final Function0<Unit> function8 = function7;
                                Object it$iv6 = $composer4.rememberedValue();
                                if (invalid$iv || it$iv6 == Composer.INSTANCE.getEmpty()) {
                                    value$iv8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$4$1$1$1
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
                                            function8.invoke();
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv8);
                                } else {
                                    value$iv8 = it$iv6;
                                }
                                $composer4.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv8, $composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-1749337208, true, new AnonymousClass2(showHelpDialog$delegate, cookieList$delegate, exportLauncher, hapticFeedback, showClearCookieDialog$delegate), $composer3, 54), scrollBehavior, $composer3, 3462, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$4$2, reason: invalid class name */
                /* JADX INFO: compiled from: CookieProfilesPage.kt */
                @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                static final class AnonymousClass2 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ MutableState<List<Cookie>> $cookieList$delegate;
                    final /* synthetic */ ManagedActivityResultLauncher<String, Uri> $exportLauncher;
                    final /* synthetic */ HapticFeedback $hapticFeedback;
                    final /* synthetic */ MutableState<Boolean> $showClearCookieDialog$delegate;
                    final /* synthetic */ MutableState<Boolean> $showHelpDialog$delegate;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(MutableState<Boolean> mutableState, MutableState<List<Cookie>> mutableState2, ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher, HapticFeedback hapticFeedback, MutableState<Boolean> mutableState3) {
                        super(3);
                        this.$showHelpDialog$delegate = mutableState;
                        this.$cookieList$delegate = mutableState2;
                        this.$exportLauncher = managedActivityResultLauncher;
                        this.$hapticFeedback = hapticFeedback;
                        this.$showClearCookieDialog$delegate = mutableState3;
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
                        Object value$iv2;
                        Object value$iv3;
                        Object value$iv4;
                        Intrinsics.checkNotNullParameter(LargeTopAppBar, "$this$LargeTopAppBar");
                        ComposerKt.sourceInformation($composer, "C174@7836L34,175@7908L25,175@7887L268,181@8193L19,181@8172L300,189@8542L20,189@8564L2048,189@8489L2123:CookieProfilesPage.kt#sffru");
                        if (($changed & 81) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1749337208, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous>.<anonymous> (CookieProfilesPage.kt:174)");
                        }
                        $composer.startReplaceGroup(-2099655246);
                        ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
                        Object it$iv = $composer.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final MutableState expanded$delegate = (MutableState) value$iv;
                        $composer.endReplaceGroup();
                        $composer.startReplaceGroup(-2099655174);
                        ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
                        final MutableState<Boolean> mutableState = this.$showHelpDialog$delegate;
                        Object it$iv2 = $composer.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$4$2$1$1
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
                                    CookieProfilesPageKt.CookieProfilePage$lambda$9(mutableState, true);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7583getLambda2$app_debug(), $composer, 196614, 30);
                        $composer.startReplaceGroup(-2099654889);
                        ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
                        Object it$iv3 = $composer.rememberedValue();
                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$4$2$2$1
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
                                    CookieProfilesPageKt.C39194.AnonymousClass2.invoke$lambda$2(expanded$delegate, true);
                                }
                            };
                            $composer.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv3, null, false, null, null, ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7584getLambda3$app_debug(), $composer, 196614, 30);
                        boolean zInvoke$lambda$1 = invoke$lambda$1(expanded$delegate);
                        $composer.startReplaceGroup(-2099654540);
                        ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
                        Object it$iv4 = $composer.rememberedValue();
                        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$4$2$3$1
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
                                    CookieProfilesPageKt.C39194.AnonymousClass2.invoke$lambda$2(expanded$delegate, false);
                                }
                            };
                            $composer.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        $composer.endReplaceGroup();
                        AndroidMenu_androidKt.m1914DropdownMenuIlH_yew(zInvoke$lambda$1, (Function0) value$iv4, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-533422077, true, new AnonymousClass4(expanded$delegate, this.$cookieList$delegate, this.$exportLauncher, this.$hapticFeedback, this.$showClearCookieDialog$delegate), $composer, 54), $composer, 48, 48, 2044);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$4$2$4, reason: invalid class name */
                    /* JADX INFO: compiled from: CookieProfilesPage.kt */
                    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/ColumnScope;", "invoke", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    static final class AnonymousClass4 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {
                        final /* synthetic */ MutableState<List<Cookie>> $cookieList$delegate;
                        final /* synthetic */ MutableState<Boolean> $expanded$delegate;
                        final /* synthetic */ ManagedActivityResultLauncher<String, Uri> $exportLauncher;
                        final /* synthetic */ HapticFeedback $hapticFeedback;
                        final /* synthetic */ MutableState<Boolean> $showClearCookieDialog$delegate;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass4(MutableState<Boolean> mutableState, MutableState<List<Cookie>> mutableState2, ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher, HapticFeedback hapticFeedback, MutableState<Boolean> mutableState3) {
                            super(3);
                            this.$expanded$delegate = mutableState;
                            this.$cookieList$delegate = mutableState2;
                            this.$exportLauncher = managedActivityResultLauncher;
                            this.$hapticFeedback = hapticFeedback;
                            this.$showClearCookieDialog$delegate = mutableState3;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                            invoke(columnScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final boolean invoke$lambda$0(MutableState<Boolean> mutableState) {
                            MutableState<Boolean> $this$getValue$iv = mutableState;
                            return $this$getValue$iv.getValue().booleanValue();
                        }

                        private static final void invoke$lambda$1(MutableState<Boolean> mutableState, boolean value) {
                            mutableState.setValue(Boolean.valueOf(value));
                        }

                        public final void invoke(ColumnScope DropdownMenu, Composer $composer, int $changed) {
                            Object value$iv$iv;
                            Object value$iv;
                            Object value$iv2;
                            Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                            ComposerKt.sourceInformation($composer, "C190@8614L12,199@9050L17,208@9503L17,201@9133L252,196@8885L658,210@9564L505,220@10090L503:CookieProfilesPage.kt#sffru");
                            if (($changed & 81) == 16 && $composer.getSkipping()) {
                                $composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-533422077, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous>.<anonymous>.<anonymous> (CookieProfilesPage.kt:190)");
                            }
                            $composer.startReplaceGroup(-2044908879);
                            ComposerKt.sourceInformation($composer, "CC12@469L46:Ext.kt#x6o9ax");
                            $composer.startReplaceGroup(-204592788);
                            ComposerKt.sourceInformation($composer, "CC(remember):Ext.kt#9igjgp");
                            Object it$iv$iv = $composer.rememberedValue();
                            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.USER_AGENT, false, 1, null)), null, 2, null);
                                $composer.updateRememberedValue(value$iv$iv);
                            } else {
                                value$iv$iv = it$iv$iv;
                            }
                            final MutableState userAgent$delegate = (MutableState) value$iv$iv;
                            $composer.endReplaceGroup();
                            $composer.endReplaceGroup();
                            Modifier.Companion companion = Modifier.INSTANCE;
                            boolean zInvoke$lambda$0 = invoke$lambda$0(userAgent$delegate);
                            $composer.startReplaceGroup(-821763183);
                            ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
                            boolean invalid$iv = $composer.changed(userAgent$delegate);
                            MutableState<Boolean> mutableState = this.$expanded$delegate;
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = new CookieProfilesPageKt$CookieProfilePage$4$2$4$1$1(userAgent$delegate, mutableState);
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            $composer.endReplaceGroup();
                            Modifier modifierM1122toggleableXHw0xAI$default = ToggleableKt.m1122toggleableXHw0xAI$default(companion, zInvoke$lambda$0, false, null, (Function1) ((KFunction) value$iv), 6, null);
                            $composer.startReplaceGroup(-821762730);
                            ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
                            boolean invalid$iv2 = $composer.changed(userAgent$delegate);
                            MutableState<Boolean> mutableState2 = this.$expanded$delegate;
                            Object it$iv2 = $composer.rememberedValue();
                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new CookieProfilesPageKt$CookieProfilePage$4$2$4$2$1(userAgent$delegate, mutableState2);
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            AndroidMenu_androidKt.DropdownMenuItem(ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7585getLambda4$app_debug(), (Function0) value$iv2, modifierM1122toggleableXHw0xAI$default, ComposableLambdaKt.rememberComposableLambda(1688905302, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.4.2.4.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer2, int $changed2) {
                                    ComposerKt.sourceInformation($composer2, "C202@9163L196:CookieProfilesPage.kt#sffru");
                                    if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1688905302, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CookieProfilesPage.kt:202)");
                                        }
                                        CheckboxKt.Checkbox(AnonymousClass4.invoke$lambda$0(userAgent$delegate), null, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.4.2.4.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                                Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                            }
                                        }), false, null, null, $composer2, 48, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }, $composer, 54), null, false, null, null, null, $composer, 3078, 496);
                            boolean z = !CookieProfilesPageKt.CookieProfilePage$lambda$11(this.$cookieList$delegate).isEmpty();
                            Function2<Composer, Integer, Unit> function2M7586getLambda5$app_debug = ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7586getLambda5$app_debug();
                            final ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher = this.$exportLauncher;
                            final MutableState<Boolean> mutableState3 = this.$expanded$delegate;
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7586getLambda5$app_debug, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.4.2.4.4
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
                                    AnonymousClass2.invoke$lambda$2(mutableState3, false);
                                    managedActivityResultLauncher.launch("cookies_exported" + System.currentTimeMillis() + ".txt");
                                }
                            }, null, ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7587getLambda6$app_debug(), null, z, null, null, null, $composer, 3078, 468);
                            Function2<Composer, Integer, Unit> function2M7588getLambda7$app_debug = ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7588getLambda7$app_debug();
                            final HapticFeedback hapticFeedback = this.$hapticFeedback;
                            final MutableState<Boolean> mutableState4 = this.$expanded$delegate;
                            final MutableState<Boolean> mutableState5 = this.$showClearCookieDialog$delegate;
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7588getLambda7$app_debug, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.4.2.4.5
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
                                    AnonymousClass2.invoke$lambda$2(mutableState4, false);
                                    hapticFeedback.mo5032performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5040getLongPress5zf0vsI());
                                    CookieProfilesPageKt.CookieProfilePage$lambda$3(mutableState5, true);
                                }
                            }, null, ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7589getLambda8$app_debug(), null, false, null, null, null, $composer, 3078, 500);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }

                        static /* synthetic */ void invoke$toggleUserAgent$default(MutableState mutableState, MutableState mutableState2, boolean z, int i, Object obj) {
                            if ((i & 4) != 0) {
                                z = !invoke$lambda$0(mutableState);
                            }
                            invoke$toggleUserAgent(mutableState, mutableState2, z);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void invoke$toggleUserAgent(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, boolean z) {
                            AnonymousClass2.invoke$lambda$2(mutableState2, false);
                            invoke$lambda$1(mutableState, z);
                            PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.USER_AGENT, z);
                        }
                    }
                }
            }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(128214639, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddingValues, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                    ComposerKt.sourceInformation($composer3, "C236@10709L2313:CookieProfilesPage.kt#sffru");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer3.changed(paddingValues) ? 4 : 2;
                    }
                    int $dirty3 = $dirty2;
                    if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(128214639, $dirty3, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous> (CookieProfilesPage.kt:236)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
                        final List<CookieProfile> list = cookies;
                        final MutableState<Boolean> mutableState = isCookieEnabled$delegate;
                        final CookieManager cookieManager2 = cookieManager;
                        final MutableState<Boolean> mutableState2 = showHelpDialog$delegate;
                        final HapticFeedback hapticFeedback2 = hapticFeedback;
                        final CookiesViewModel cookiesViewModel5 = cookiesViewModel4;
                        final MutableState<List<Cookie>> mutableState3 = cookieList$delegate;
                        LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.5.1
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
                                final MutableState<Boolean> mutableState4 = mutableState;
                                final List<CookieProfile> list2 = list;
                                final CookieManager cookieManager3 = cookieManager2;
                                final MutableState<Boolean> mutableState5 = mutableState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1106747813, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.5.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer4, "C239@10860L36,238@10801L714:CookieProfilesPage.kt#sffru");
                                        if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1106747813, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous>.<anonymous>.<anonymous> (CookieProfilesPage.kt:238)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.use_cookies, $composer4, 0);
                                            boolean zCookieProfilePage$lambda$5 = CookieProfilesPageKt.CookieProfilePage$lambda$5(mutableState4);
                                            final List<CookieProfile> list3 = list2;
                                            final CookieManager cookieManager4 = cookieManager3;
                                            final MutableState<Boolean> mutableState6 = mutableState4;
                                            final MutableState<Boolean> mutableState7 = mutableState5;
                                            PreferenceItemsKt.PreferenceSwitchWithContainer(strStringResource, null, zCookieProfilePage$lambda$5, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.5.1.1.1
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
                                                    if (CookieProfilesPageKt.CookieProfilePage$lambda$5(mutableState6)) {
                                                        CookieProfilesPageKt.CookieProfilePage$lambda$6(mutableState6, false);
                                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.COOKIES, false);
                                                    } else if ((list3.isEmpty() || !cookieManager4.hasCookies()) && !CookieProfilesPageKt.CookieProfilePage$lambda$5(mutableState6)) {
                                                        CookieProfilesPageKt.CookieProfilePage$lambda$9(mutableState7, true);
                                                    } else {
                                                        CookieProfilesPageKt.CookieProfilePage$lambda$6(mutableState6, true);
                                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.COOKIES, true);
                                                    }
                                                }
                                            }, $composer4, 48, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final List<CookieProfile> list3 = list;
                                final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                final CookiesViewModel cookiesViewModel6 = cookiesViewModel5;
                                LazyColumn.items(list3.size(), null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$5$1$invoke$$inlined$itemsIndexed$default$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        list3.get(index);
                                        return null;
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$5$1$invoke$$inlined$itemsIndexed$default$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope $this$items, int it, Composer $composer4, int $changed3) {
                                        ComposerKt.sourceInformation($composer4, "C188@8866L26:LazyDsl.kt#428nma");
                                        int $dirty4 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty4 |= $composer4.changed($this$items) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty4 |= $composer4.changed(it) ? 32 : 16;
                                        }
                                        if (($dirty4 & 147) == 146 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1091073711, $dirty4, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                                        }
                                        int i6 = ($dirty4 & 14) | ($dirty4 & 112);
                                        final CookieProfile item = (CookieProfile) list3.get(it);
                                        $composer4.startReplaceGroup(-821760640);
                                        ComposerKt.sourceInformation($composer4, "C*259@11834L80,264@12135L31,255@11593L591:CookieProfilesPage.kt#sffru");
                                        Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(4), 1, null);
                                        String url = item.getUrl();
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.edit, $composer4, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.remove, $composer4, 0);
                                        final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                        final CookiesViewModel cookiesViewModel7 = cookiesViewModel6;
                                        Function0<Unit> function7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$5$1$2$1
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
                                                hapticFeedback4.mo5032performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5040getLongPress5zf0vsI());
                                                cookiesViewModel7.showDeleteCookieDialog(item);
                                            }
                                        };
                                        final CookiesViewModel cookiesViewModel8 = cookiesViewModel6;
                                        PreferenceItemsKt.PreferenceItemVariant(modifierM870paddingVpY3zN4$default, url, null, null, false, strStringResource2, function7, strStringResource, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$5$1$2$2
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
                                                cookiesViewModel8.showEditCookieDialog(item);
                                            }
                                        }, $composer4, 6, 28);
                                        $composer4.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                final CookiesViewModel cookiesViewModel7 = cookiesViewModel5;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(557058564, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.5.1.3
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer4, "C270@12286L50,269@12235L210:CookieProfilesPage.kt#sffru");
                                        if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(557058564, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous>.<anonymous>.<anonymous> (CookieProfilesPage.kt:269)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.generate_new_cookies, $composer4, 0);
                                            ImageVector add = AddKt.getAdd(Icons.Outlined.INSTANCE);
                                            final CookiesViewModel cookiesViewModel8 = cookiesViewModel7;
                                            PreferenceItemsKt.PreferenceItemVariant(null, strStringResource, null, add, false, null, null, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.5.1.3.1
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
                                                    CookiesViewModel.showEditCookieDialog$default(cookiesViewModel8, null, 1, null);
                                                }
                                            }, $composer4, 0, 245);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableState<List<Cookie>> mutableState6 = mutableState3;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1215441443, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.5.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer4, "C275@12495L19,279@12688L69,280@12801L10,282@12952L11,278@12655L343:CookieProfilesPage.kt#sffru");
                                        if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1215441443, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilePage.<anonymous>.<anonymous>.<anonymous> (CookieProfilesPage.kt:275)");
                                        }
                                        DividerKt.m7300HorizontalDivideriJQMabo(null, 0L, $composer4, 0, 3);
                                        int cookiesCount = CookieProfilesPageKt.CookieProfilePage$lambda$11(mutableState6).size();
                                        Iterable $this$distinctBy$iv = CookieProfilesPageKt.CookieProfilePage$lambda$11(mutableState6);
                                        HashSet set$iv = new HashSet();
                                        ArrayList list$iv = new ArrayList();
                                        for (Object e$iv : $this$distinctBy$iv) {
                                            Cookie it = (Cookie) e$iv;
                                            if (set$iv.add(it.getDomain())) {
                                                list$iv.add(e$iv);
                                            }
                                        }
                                        int siteCount = list$iv.size();
                                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.cookies_in_database, new Object[]{Integer.valueOf(cookiesCount), Integer.valueOf(siteCount)}, $composer4, 64), PaddingKt.m869paddingVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(16)), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), $composer4, 48, 0, 65528);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 3, null);
                            }
                        }, $composer3, 0, 254);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 805306416, 508);
            $composer2.startReplaceGroup(508674878);
            ComposerKt.sourceInformation($composer2, "289@13070L248");
            if (CookieProfilePage$lambda$0(state$delegate).getShowEditDialog()) {
                shouldUpdateCookies$delegate = shouldUpdateCookies$delegate2;
                CookieGeneratorDialog(cookiesViewModel2, c39131, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.6
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
                        cookiesViewModel2.hideDialog();
                        CookieProfilesPageKt.CookieProfilePage$lambda$15(shouldUpdateCookies$delegate, true);
                    }
                }, $composer2, ($dirty & 112) | 8, 0);
            } else {
                shouldUpdateCookies$delegate = shouldUpdateCookies$delegate2;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(508675174);
            ComposerKt.sourceInformation($composer2, "299@13368L70");
            if (CookieProfilePage$lambda$0(state$delegate).getShowDeleteDialog()) {
                i2 = 0;
                DeleteCookieDialog(cookiesViewModel2, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.7
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
                        cookiesViewModel2.hideDialog();
                    }
                }, $composer2, 8, 0);
            } else {
                i2 = 0;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(508675294);
            ComposerKt.sourceInformation($composer2, "303@13498L47,303@13566L46,303@13480L133");
            if (CookieProfilePage$lambda$8(showHelpDialog$delegate)) {
                String strStringResource = StringResources_androidKt.stringResource(C3070R.string.cookies_usage_msg, $composer2, i2);
                $composer2.startReplaceGroup(508675410);
                str = "CC(remember):CookieProfilesPage.kt#9igjgp";
                ComposerKt.sourceInformation($composer2, str);
                Object it$iv6 = $composer2.rememberedValue();
                if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$8$1
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
                            CookieProfilesPageKt.CookieProfilePage$lambda$9(showHelpDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv6;
                }
                $composer2.endReplaceGroup();
                DialogsKt.HelpDialog(strStringResource, (Function0) value$iv7, null, null, $composer2, 48, 12);
            } else {
                str = "CC(remember):CookieProfilesPage.kt#9igjgp";
            }
            $composer2.endReplaceGroup();
            if (CookieProfilePage$lambda$2(showClearCookieDialog$delegate)) {
                $composer2.startReplaceGroup(508675543);
                ComposerKt.sourceInformation($composer2, str);
                Object it$iv7 = $composer2.rememberedValue();
                if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$9$1
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
                            CookieProfilesPageKt.CookieProfilePage$lambda$3(showClearCookieDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                } else {
                    value$iv6 = it$iv7;
                }
                $composer2.endReplaceGroup();
                ClearCookiesDialog((Function0) value$iv6, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$10$1, reason: invalid class name */
                    /* JADX INFO: compiled from: CookieProfilesPage.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieProfilePage$10$1", m210f = "CookieProfilesPage.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;

                        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure(obj);
                                    CookieManager.getInstance().removeAllCookies(null);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        com.videshkarmakar.loop.p006ui.common.HapticFeedback.INSTANCE.slightHapticFeedback(view);
                        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
                        final MutableState<Boolean> mutableState = shouldUpdateCookies$delegate;
                        jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.10.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                CookieProfilesPageKt.CookieProfilePage$lambda$15(mutableState, true);
                            }
                        });
                    }
                }, $composer2, 6, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cookiesViewModel3 = cookiesViewModel2;
            function4 = c39131;
            function3 = function6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final CookiesViewModel cookiesViewModel5 = cookiesViewModel3;
            final Function0<Unit> function7 = function4;
            final Function0<Unit> function8 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieProfilePage.11
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
                    CookieProfilesPageKt.CookieProfilePage(cookiesViewModel5, function7, function8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final CookiesViewModel.ViewState CookieProfilePage$lambda$0(State<CookiesViewModel.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (CookiesViewModel.ViewState) thisObj$iv;
    }

    private static final boolean CookieProfilePage$lambda$2(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CookieProfilePage$lambda$3(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CookieProfilePage$lambda$5(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CookieProfilePage$lambda$6(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean CookieProfilePage$lambda$8(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CookieProfilePage$lambda$9(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Cookie> CookieProfilePage$lambda$11(MutableState<List<Cookie>> mutableState) {
        MutableState<List<Cookie>> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CookieProfilePage$lambda$12(MutableState<List<Cookie>> mutableState, List<Cookie> list) {
        mutableState.setValue(list);
    }

    private static final boolean CookieProfilePage$lambda$14(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CookieProfilePage$lambda$15(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void CookieGeneratorDialog(CookiesViewModel cookiesViewModel, Function0<Unit> function0, final Function0<Unit> onDismissRequest, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function1;
        CookiesViewModel cookiesViewModel2;
        final Function0<Unit> function2;
        int $dirty;
        final CookiesViewModel cookiesViewModel3;
        Function0<Unit> function3;
        CookiesViewModel cookiesViewModel4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-1359643005);
        ComposerKt.sourceInformation($composer3, "C(CookieGeneratorDialog)324@14123L11,329@14270L29,333@14376L124,368@15716L151,364@15626L72,340@14671L937,338@14505L1363:CookieProfilesPage.kt#sffru");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            function1 = function0;
        } else if (($changed & 112) == 0) {
            function1 = function0;
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changedInstance(onDismissRequest) ? 256 : 128;
        }
        int $dirty3 = $dirty2;
        if (i2 == 1 && ($dirty3 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            cookiesViewModel4 = cookiesViewModel;
            function3 = function1;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    $composer3.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation($composer3, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
                    ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer3, 6);
                    if (viewModelStoreOwner$iv == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    CreationExtras extras$iv = viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(CookiesViewModel.class), viewModelStoreOwner$iv, (String) null, (ViewModelProvider.Factory) null, extras$iv, $composer3, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | (57344 & (0 << 3)), 0);
                    $composer3.endReplaceableGroup();
                    cookiesViewModel2 = (CookiesViewModel) viewModel;
                    $dirty3 &= -15;
                } else {
                    cookiesViewModel2 = cookiesViewModel;
                }
                if (i3 != 0) {
                    function2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieGeneratorDialog.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                    $dirty = $dirty3;
                    cookiesViewModel3 = cookiesViewModel2;
                } else {
                    function2 = function1;
                    $dirty = $dirty3;
                    cookiesViewModel3 = cookiesViewModel2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if (i2 != 0) {
                    $dirty3 &= -15;
                }
                function2 = function1;
                $dirty = $dirty3;
                cookiesViewModel3 = cookiesViewModel;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1359643005, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieGeneratorDialog (CookieProfilesPage.kt:327)");
            }
            State state$delegate = FlowExtKt.collectAsStateWithLifecycle(cookiesViewModel3.getStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 8, 7);
            CookieProfile profile = CookieGeneratorDialog$lambda$18(state$delegate).getEditingCookieProfile();
            final String url = profile.getUrl();
            EffectsKt.LaunchedEffect(Unit.INSTANCE, new C39072(null), $composer3, 70);
            function3 = function2;
            cookiesViewModel4 = cookiesViewModel3;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-372925125, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieGeneratorDialog.3
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
                    ComposerKt.sourceInformation($composer4, "C369@15726L135:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-372925125, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieGeneratorDialog.<anonymous> (CookieProfilesPage.kt:369)");
                        }
                        boolean z = url.length() > 0;
                        final CookiesViewModel cookiesViewModel5 = cookiesViewModel3;
                        final Function0<Unit> function4 = onDismissRequest;
                        ButtonsKt.ConfirmButton(null, z, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieGeneratorDialog.3.1
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
                                cookiesViewModel5.updateCookieProfile();
                                function4.invoke();
                            }
                        }, $composer4, 0, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(135853689, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieGeneratorDialog.4
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C365@15650L42,365@15636L56:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(135853689, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieGeneratorDialog.<anonymous> (CookieProfilesPage.kt:365)");
                    }
                    $composer4.startReplaceGroup(766400084);
                    ComposerKt.sourceInformation($composer4, "CC(remember):CookieProfilesPage.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function4 = onDismissRequest;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$4$1$1
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
                                function4.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7590getLambda9$app_debug(), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7573getLambda10$app_debug(), ComposableLambdaKt.rememberComposableLambda(899021910, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieGeneratorDialog.5
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
                    Function0<ComposeUiNode> function4;
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C341@14712L21,341@14681L921:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(899021910, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieGeneratorDialog.<anonymous> (CookieProfilesPage.kt:341)");
                    }
                    Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                    String str = url;
                    final Function0<Unit> function5 = function2;
                    final CookiesViewModel cookiesViewModel5 = cookiesViewModel3;
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
                        function4 = constructor;
                        $composer4.createNode(function4);
                    } else {
                        function4 = constructor;
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
                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i5 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 853481969, "C347@15024L220,342@14750L601,360@15527L50,358@15411L35,357@15365L226:CookieProfilesPage.kt#sffru");
                    OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$5$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                            invoke2(str2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            cookiesViewModel5.updateUrl(it);
                        }
                    }, PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7574getLambda11$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-615079095, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$5$1$2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer5, int $changed3) {
                            ComposerKt.sourceInformation($composer5, "C348@15046L180:CookieProfilesPage.kt#sffru");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-615079095, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookieGeneratorDialog.<anonymous>.<anonymous>.<anonymous> (CookieProfilesPage.kt:348)");
                                }
                                final CookiesViewModel cookiesViewModel6 = cookiesViewModel5;
                                IconButtonsKt.PasteFromClipBoardButton(new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$5$1$2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                        invoke2(str2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        cookiesViewModel6.updateUrl(TextUtilKt.matchUrlFromClipboard$default(it, false, 2, null));
                                    }
                                }, $composer5, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), (KeyboardActions) null, false, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 806879616, 100859904, 0, 8093112);
                    ImageVector generatingTokens = GeneratingTokensKt.getGeneratingTokens(Icons.Outlined.INSTANCE);
                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.generate_new_cookies, $composer4, 0);
                    $composer4.startReplaceGroup(853482630);
                    ComposerKt.sourceInformation($composer4, "CC(remember):CookieProfilesPage.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function5);
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$5$1$3$1
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
                                function5.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.m7240TextButtonWithIconuDo3WH8(null, generatingTokens, strStringResource, 0L, (Function0) value$iv, $composer4, 0, 9);
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
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 6) & 14) | 1797168, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final CookiesViewModel cookiesViewModel5 = cookiesViewModel4;
            final Function0<Unit> function4 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookieGeneratorDialog.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    CookieProfilesPageKt.CookieGeneratorDialog(cookiesViewModel5, function4, onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final CookiesViewModel.ViewState CookieGeneratorDialog$lambda$18(State<CookiesViewModel.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (CookiesViewModel.ViewState) thisObj$iv;
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$2 */
    /* JADX INFO: compiled from: CookieProfilesPage.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$2", m210f = "CookieProfilesPage.kt", m211i = {}, m212l = {335}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C39072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C39072(Continuation<? super C39072> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C39072(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C39072) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CookieProfilesPage.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookieGeneratorDialog$2$1", m210f = "CookieProfilesPage.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        CookieManager.getInstance().flush();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(null), this) == coroutine_suspended) {
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

    public static final void DeleteCookieDialog(CookiesViewModel cookiesViewModel, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        final CookiesViewModel cookiesViewModel2;
        int $dirty;
        final Function0<Unit> function2;
        Composer $composer2;
        final CookiesViewModel cookiesViewModel3;
        Composer $composer3 = $composer.startRestartGroup(-1394879541);
        ComposerKt.sourceInformation($composer3, "C(DeleteCookieDialog)379@15950L11,382@16049L16,396@16570L143,392@16464L88,386@16202L236,383@16070L690:CookieProfilesPage.kt#sffru");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            function1 = function0;
        } else if (($changed & 112) == 0) {
            function1 = function0;
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int $dirty3 = $dirty2;
        if (i2 == 1 && ($dirty3 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            cookiesViewModel3 = cookiesViewModel;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    $composer3.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation($composer3, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
                    ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer3, 6);
                    if (viewModelStoreOwner$iv == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    CreationExtras extras$iv = viewModelStoreOwner$iv instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner$iv).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(CookiesViewModel.class), viewModelStoreOwner$iv, (String) null, (ViewModelProvider.Factory) null, extras$iv, $composer3, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | (57344 & (0 << 3)), 0);
                    $composer3.endReplaceableGroup();
                    cookiesViewModel2 = (CookiesViewModel) viewModel;
                    $dirty3 &= -15;
                } else {
                    cookiesViewModel2 = cookiesViewModel;
                }
                if (i3 != 0) {
                    $dirty = $dirty3;
                    function2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.DeleteCookieDialog.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                } else {
                    $dirty = $dirty3;
                    function2 = function1;
                }
            } else {
                $composer3.skipToGroupEnd();
                if (i2 != 0) {
                    $dirty3 &= -15;
                }
                cookiesViewModel2 = cookiesViewModel;
                $dirty = $dirty3;
                function2 = function1;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1394879541, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.network.DeleteCookieDialog (CookieProfilesPage.kt:381)");
            }
            final State state$delegate = SnapshotStateKt.collectAsState(cookiesViewModel2.getStateFlow(), null, $composer3, 8, 1);
            Function0<Unit> function3 = function2;
            $composer2 = $composer3;
            CookiesViewModel cookiesViewModel4 = cookiesViewModel2;
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(function3, ComposableLambdaKt.rememberComposableLambda(631777811, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.DeleteCookieDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C397@16584L119:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(631777811, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.DeleteCookieDialog.<anonymous> (CookieProfilesPage.kt:397)");
                        }
                        final CookiesViewModel cookiesViewModel5 = cookiesViewModel2;
                        final Function0<Unit> function4 = function2;
                        ButtonsKt.ConfirmButton(null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.DeleteCookieDialog.2.1
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
                                CookiesViewModel.deleteCookieProfile$default(cookiesViewModel5, null, 1, null);
                                function4.invoke();
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
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-773413867, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.DeleteCookieDialog.3
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C393@16492L50,393@16478L64:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-773413867, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.DeleteCookieDialog.<anonymous> (CookieProfilesPage.kt:393)");
                    }
                    $composer4.startReplaceGroup(-2098391506);
                    ComposerKt.sourceInformation($composer4, "CC(remember):CookieProfilesPage.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function2);
                    final Function0<Unit> function4 = function2;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$DeleteCookieDialog$3$1$1
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
                                function4.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7575getLambda12$app_debug(), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7576getLambda13$app_debug(), ComposableLambdaKt.rememberComposableLambda(1413765912, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.DeleteCookieDialog.4
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
                    ComposerKt.sourceInformation($composer4, "C*388@16238L51,389@16369L7,387@16216L212:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1413765912, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.DeleteCookieDialog.<anonymous> (CookieProfilesPage.kt:387)");
                        }
                        String str = String.format(StringResources_androidKt.stringResource(C3070R.string.remove_cookie_profile_desc, $composer4, 0), Arrays.copyOf(new Object[]{CookieProfilesPageKt.DeleteCookieDialog$lambda$19(state$delegate).getEditingCookieProfile().getUrl()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer4.consume(localTextStyle);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        TextStyle textStyle = (TextStyle) objConsume;
                        TextKt.m2817Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle.m6277copyp1EtxEg((16777213 & 1) != 0 ? textStyle.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyle.platformStyle : null, (16777213 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : LineBreak.INSTANCE.m6589getParagraphrAG3T2k(), (16777213 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null), $composer4, 0, 0, 65534);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 3) & 14) | 1797168, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function3;
            cookiesViewModel3 = cookiesViewModel4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.DeleteCookieDialog.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    CookieProfilesPageKt.DeleteCookieDialog(cookiesViewModel3, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CookiesViewModel.ViewState DeleteCookieDialog$lambda$19(State<CookiesViewModel.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (CookiesViewModel.ViewState) thisObj$iv;
    }

    public static final void ClearCookiesDialog(Function0<Unit> function0, final Function0<Unit> onConfirm, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer $composer3 = $composer.startRestartGroup(-735568773);
        ComposerKt.sourceInformation($composer3, "C(ClearCookiesDialog)P(1)421@17311L116,417@17205L88,408@16869L612:CookieProfilesPage.kt#sffru");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function1 = function0;
        } else if (($changed & 14) == 0) {
            function1 = function0;
            $dirty |= $composer3.changedInstance(function1) ? 4 : 2;
        } else {
            function1 = function0;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onConfirm) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.ClearCookiesDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-735568773, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ClearCookiesDialog (CookieProfilesPage.kt:407)");
            }
            Function0<Unit> function3 = function2;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(function3, ComposableLambdaKt.rememberComposableLambda(-905918669, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.ClearCookiesDialog.2
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C422@17339L78,422@17325L92:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-905918669, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ClearCookiesDialog.<anonymous> (CookieProfilesPage.kt:422)");
                    }
                    $composer4.startReplaceGroup(-675561718);
                    ComposerKt.sourceInformation($composer4, "CC(remember):CookieProfilesPage.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onConfirm) | $composer4.changed(function2);
                    final Function0<Unit> function4 = onConfirm;
                    final Function0<Unit> function5 = function2;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$ClearCookiesDialog$2$1$1
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
                                function4.invoke();
                                function5.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(2065869681, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.ClearCookiesDialog.3
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C418@17233L50,418@17219L64:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2065869681, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ClearCookiesDialog.<anonymous> (CookieProfilesPage.kt:418)");
                    }
                    $composer4.startReplaceGroup(-675561824);
                    ComposerKt.sourceInformation($composer4, "CC(remember):CookieProfilesPage.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function2);
                    final Function0<Unit> function4 = function2;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$ClearCookiesDialog$3$1$1
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
                                function4.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7577getLambda14$app_debug(), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7578getLambda15$app_debug(), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7579getLambda16$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty2 & 14) | 1797168, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.ClearCookiesDialog.4
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
                    CookieProfilesPageKt.ClearCookiesDialog(function1, onConfirm, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void CookiesQuickSettingsDialog(Function0<Unit> function0, Function0<Unit> function1, List<CookieProfile> list, Function1<? super CookieProfile, Unit> function2, boolean isCookiesEnabled, Function1<? super Boolean, Unit> function3, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function4;
        Function0<Unit> function5;
        Function1<? super CookieProfile, Unit> function6;
        boolean z;
        Function1<? super Boolean, Unit> function7;
        Function0<Unit> function8;
        Function0<Unit> function9;
        List<CookieProfile> list2;
        Function1<? super CookieProfile, Unit> function10;
        boolean isCookiesEnabled2;
        Composer $composer2 = $composer.startRestartGroup(-1231793246);
        ComposerKt.sourceInformation($composer2, "C(CookiesQuickSettingsDialog)P(5,2!1,3)438@17870L174,449@18302L2196,438@17806L2693:CookieProfilesPage.kt#sffru");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function4 = function0;
        } else if (($changed & 14) == 0) {
            function4 = function0;
            $dirty |= $composer2.changedInstance(function4) ? 4 : 2;
        } else {
            function4 = function0;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            function5 = function1;
        } else if (($changed & 112) == 0) {
            function5 = function1;
            $dirty |= $composer2.changedInstance(function5) ? 32 : 16;
        } else {
            function5 = function1;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            function6 = function2;
        } else if (($changed & 7168) == 0) {
            function6 = function2;
            $dirty |= $composer2.changedInstance(function6) ? 2048 : 1024;
        } else {
            function6 = function2;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            z = isCookiesEnabled;
        } else if ((57344 & $changed) == 0) {
            z = isCookiesEnabled;
            $dirty |= $composer2.changed(z) ? 16384 : 8192;
        } else {
            z = isCookiesEnabled;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function7 = function3;
        } else if ((458752 & $changed) == 0) {
            function7 = function3;
            $dirty |= $composer2.changedInstance(function7) ? 131072 : 65536;
        } else {
            function7 = function3;
        }
        if (i4 == 4 && (374491 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            list2 = list;
            function8 = function4;
            isCookiesEnabled2 = z;
            function10 = function6;
            function9 = function5;
        } else {
            final C39261 c39261 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function4;
            final C39272 c39272 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialog.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function5;
            final List<CookieProfile> listEmptyList = i4 != 0 ? CollectionsKt.emptyList() : list;
            final C39283 c39283 = i5 != 0 ? new Function1<CookieProfile, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialog.3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CookieProfile cookieProfile) {
                    invoke2(cookieProfile);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CookieProfile it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : function6;
            final boolean isCookiesEnabled3 = i6 != 0 ? false : z;
            final C39294 c39294 = i7 != 0 ? new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialog.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                }
            } : function7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1231793246, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookiesQuickSettingsDialog (CookieProfilesPage.kt:437)");
            }
            DialogsKt.m7298LoopDialogOix01E0(null, c39261, ComposableLambdaKt.rememberComposableLambda(1005578343, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialog.5
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C439@17901L69,439@17972L66,439@17880L158:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1005578343, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookiesQuickSettingsDialog.<anonymous> (CookieProfilesPage.kt:439)");
                    }
                    String strStringResource = StringResources_androidKt.stringResource(C0056R.string.abc_action_mode_done, $composer3, 0);
                    $composer3.startReplaceGroup(-1563122748);
                    ComposerKt.sourceInformation($composer3, "CC(remember):CookieProfilesPage.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c39261) | $composer3.changed(c39272);
                    final Function0<Unit> function11 = c39261;
                    final Function0<Unit> function12 = c39272;
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookiesQuickSettingsDialog$5$1$1
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
                                function11.invoke();
                                function12.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.ConfirmButton(strStringResource, false, (Function0) value$iv, $composer3, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7580getLambda17$app_debug(), ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7581getLambda18$app_debug(), ComposableLambdaKt.rememberComposableLambda(509641955, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialog.6
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
                    Function0<ComposeUiNode> function11;
                    ComposerKt.sourceInformation($composer3, "C450@18316L2172:CookieProfilesPage.kt#sffru");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(509641955, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookiesQuickSettingsDialog.<anonymous> (CookieProfilesPage.kt:450)");
                        }
                        boolean z2 = isCookiesEnabled3;
                        Function1<Boolean, Unit> function12 = c39294;
                        final List<CookieProfile> list3 = listEmptyList;
                        final Function1<CookieProfile, Unit> function13 = c39283;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
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
                            function11 = constructor;
                            $composer3.createNode(function11);
                        } else {
                            function11 = constructor;
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
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i9 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -2133078186, "C452@18374L50,451@18341L238,456@18596L41,457@18654L55,458@18726L40,459@18783L1341,487@20141L40,488@20198L55,490@20315L41,489@20270L204:CookieProfilesPage.kt#sffru");
                        TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.refresh_cookies_desc, $composer3, 0), PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12)), $composer3, 6);
                        DividerKt.m7300HorizontalDivideriJQMabo(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0L, $composer3, 6, 2);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), $composer3, 6);
                        LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookiesQuickSettingsDialog$6$1$1
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
                                final List<CookieProfile> list4 = list3;
                                final Function1<CookieProfile, Unit> function14 = function13;
                                final Function1 contentType$iv = new Function1() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookiesQuickSettingsDialog$6$1$1$invoke$$inlined$items$default$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        return invoke((CookieProfile) p1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Void invoke(CookieProfile cookieProfile) {
                                        return null;
                                    }
                                };
                                LazyColumn.items(list4.size(), null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookiesQuickSettingsDialog$6$1$1$invoke$$inlined$items$default$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        return contentType$iv.invoke(list4.get(index));
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookiesQuickSettingsDialog$6$1$1$invoke$$inlined$items$default$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope $this$items, int it, Composer $composer4, int $changed3) {
                                        Object value$iv;
                                        Function0<ComposeUiNode> function15;
                                        Function0<ComposeUiNode> function16;
                                        ComposerKt.sourceInformation($composer4, "C152@7074L22:LazyDsl.kt#428nma");
                                        int $dirty2 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty2 |= $composer4.changed($this$items) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty2 |= $composer4.changed(it) ? 32 : 16;
                                        }
                                        if (($dirty2 & 147) == 146 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-632812321, $dirty2, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                                        }
                                        int $changed4 = $dirty2 & 14;
                                        final CookieProfile it2 = (CookieProfile) list4.get(it);
                                        $composer4.startReplaceGroup(-1170544339);
                                        ComposerKt.sourceInformation($composer4, "C*464@19018L30,461@18874L1210:CookieProfilesPage.kt#sffru");
                                        boolean z3 = true;
                                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        $composer4.startReplaceGroup(-1170544195);
                                        ComposerKt.sourceInformation($composer4, "CC(remember):CookieProfilesPage.kt#9igjgp");
                                        boolean zChanged = $composer4.changed(function14);
                                        if (((($changed4 & 112) ^ 48) <= 32 || !$composer4.changed(it2)) && ($changed4 & 48) != 32) {
                                            z3 = false;
                                        }
                                        boolean invalid$iv = zChanged | z3;
                                        Object it$iv = $composer4.rememberedValue();
                                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                            final Function1 function17 = function14;
                                            value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookiesQuickSettingsDialog$6$1$1$1$1$1
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
                                                    function17.invoke(it2);
                                                }
                                            };
                                            $composer4.updateRememberedValue(value$iv);
                                        } else {
                                            value$iv = it$iv;
                                        }
                                        $composer4.endReplaceGroup();
                                        Modifier modifier$iv2 = PaddingKt.m869paddingVpY3zN4(ClickableKt.m487clickableXHw0xAI$default(modifierFillMaxWidth$default, false, null, null, (Function0) value$iv, 7, null), C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(12));
                                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                        int $changed$iv$iv2 = (384 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function15 = constructor2;
                                            $composer4.createNode(function15);
                                        } else {
                                            function15 = constructor2;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                        }
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                        int i11 = ((384 >> 6) & 112) | 6;
                                        RowScope $this$invoke_u24lambda_u243_u24lambda_u242 = RowScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1914132560, "C475@19629L20,468@19260L543,479@19832L226:CookieProfilesPage.kt#sffru");
                                        Modifier modifier$iv3 = SemanticsModifierKt.clearAndSetSemantics(BackgroundKt.m453backgroundbw27NRU(SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 11, null), C1979Dp.m6801constructorimpl(16)), ColorSchemeKt.generateLabelColor(it2.getUrl().hashCode(), $composer4, 0), RoundedCornerShapeKt.getCircleShape()), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt$CookiesQuickSettingsDialog$6$1$1$1$2$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                                Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                            }
                                        });
                                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                        int $changed$iv$iv3 = (0 << 3) & 112;
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
                                            function16 = constructor3;
                                            $composer4.createNode(function16);
                                        } else {
                                            function16 = constructor3;
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
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i13 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 169827983, "C:CookieProfilesPage.kt#sffru");
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        TextKt.m2817Text4IGK_g(it2.getUrl(), RowScope.CC.weight$default($this$invoke_u24lambda_u243_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                        }, $composer3, 0, 255);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), $composer3, 6);
                        DividerKt.m7300HorizontalDivideriJQMabo(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0L, $composer3, 6, 2);
                        DialogItemsKt.DialogSwitchItem(null, StringResources_androidKt.stringResource(C3070R.string.use_cookies, $composer3, 0), z2, function12, $composer3, 0, 1);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty << 3) & 112) | 1794432, 0, 16265);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = c39261;
            function9 = c39272;
            list2 = listEmptyList;
            function10 = c39283;
            isCookiesEnabled2 = isCookiesEnabled3;
            function7 = c39294;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function11 = function8;
            final Function0<Unit> function12 = function9;
            final List<CookieProfile> list3 = list2;
            final Function1<? super CookieProfile, Unit> function13 = function10;
            final boolean z2 = isCookiesEnabled2;
            final Function1<? super Boolean, Unit> function14 = function7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialog.7
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
                    CookieProfilesPageKt.CookiesQuickSettingsDialog(function11, function12, list3, function13, z2, function14, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CookiesQuickSettingsDialogPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(2087734360);
        ComposerKt.sourceInformation($composer2, "C(CookiesQuickSettingsDialogPreview)502@20649L615:CookieProfilesPage.kt#sffru");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2087734360, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.network.CookiesQuickSettingsDialogPreview (CookieProfilesPage.kt:501)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$CookieProfilesPageKt.INSTANCE.m7582getLambda19$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.CookieProfilesPageKt.CookiesQuickSettingsDialogPreview.1
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
                    CookieProfilesPageKt.CookiesQuickSettingsDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
