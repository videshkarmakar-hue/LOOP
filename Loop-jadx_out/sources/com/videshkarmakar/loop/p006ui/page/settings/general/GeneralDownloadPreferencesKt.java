package com.videshkarmakar.loop.p006ui.page.settings.general;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
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
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ArchiveKt;
import androidx.compose.material.icons.outlined.HistoryKt;
import androidx.compose.material.icons.outlined.HistoryToggleOffKt;
import androidx.compose.material.icons.outlined.ImageKt;
import androidx.compose.material.icons.outlined.MoneyOffKt;
import androidx.compose.material.icons.outlined.NotificationsActiveKt;
import androidx.compose.material.icons.outlined.NotificationsKt;
import androidx.compose.material.icons.outlined.NotificationsOffKt;
import androidx.compose.material.icons.outlined.PlaylistAddCheckKt;
import androidx.compose.material.icons.outlined.PrintDisabledKt;
import androidx.compose.material.icons.outlined.PrintKt;
import androidx.compose.material.icons.outlined.UpdateKt;
import androidx.compose.material.icons.outlined.VisibilityKt;
import androidx.compose.material.icons.outlined.VisibilityOffKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.google.accompanist.permissions.PermissionState;
import com.google.accompanist.permissions.PermissionStateKt;
import com.google.accompanist.permissions.PermissionStatus;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.p006ui.component.TopAppBarKt;
import com.videshkarmakar.loop.p006ui.page.download.NotificationPermissionDialogKt;
import com.videshkarmakar.loop.util.FileUtil;
import com.videshkarmakar.loop.util.NotificationUtil;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import com.videshkarmakar.loop.util.UpdateUtil;
import com.yausername.youtubedl_android.YoutubeDL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.Lambda;
import kotlin.p007io.FilesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001aL\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019\u001a)\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u000202X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0005X\u008a\u008e\u0002"}, m195d2 = {"DialogCheckBoxItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "checked", "", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DialogSingleChoiceItem", "selected", "label", "labelContainerColor", "Landroidx/compose/ui/graphics/Color;", "DialogSingleChoiceItem-FHprtrg", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLjava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DownloadArchiveDialog", "archiveFileContent", "onDismissRequest", "onSaveChangesCallback", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DownloadArchiveDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "GeneralDownloadPreferences", "onNavigateBack", "navigateToTemplate", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "UpdateProgressIndicator", "app_debug", "showSponsorBlockDialog", "showYtdlpDialog", "isUpdating", "downloadSubtitle", "displayErrorReport", "downloadPlaylist", "isSponsorBlockEnabled", "downloadNotification", "isPrivateModeEnabled", "isPreviewDisabled", "isNotificationPermissionGranted", "useDownloadArchive", "showClearArchiveDialog", "showNotificationDialog", "isCustomCommandEnabled", "ytdlpVersion", "thumbnailSwitch", "ytdlpUpdateChannel", "", "ytdlpAutoUpdate", "updateInterval", "", "expanded", "editContent"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GeneralDownloadPreferencesKt {
    public static final void GeneralDownloadPreferences(final Function0<Unit> onNavigateBack, final Function0<Unit> navigateToTemplate, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Object value$iv8;
        Object value$iv9;
        Object value$iv$iv4;
        Object value$iv10;
        Object value$iv11;
        Object value$iv12;
        final MutableState showSponsorBlockDialog$delegate;
        String str;
        Composer $composer2;
        Composer $composer3;
        String str2;
        final MutableState showNotificationDialog$delegate;
        Object value$iv13;
        Object value$iv14;
        Object value$iv15;
        boolean z;
        Object value$iv$iv5;
        Object value$iv$iv6;
        Object value$iv16;
        final MutableState showYtdlpDialog$delegate;
        Object value$iv17;
        Object value$iv18;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(navigateToTemplate, "navigateToTemplate");
        Composer $composer4 = $composer.startRestartGroup(-412493992);
        ComposerKt.sourceInformation($composer4, "C(GeneralDownloadPreferences)P(1)132@6595L7,133@6619L24,134@6689L7,136@6732L34,137@6794L34,138@6851L34,140@6924L12,142@6974L12,143@7015L62,144@7111L66,145@7210L78,149@7322L78,153@7431L69,154@7544L83,164@8008L12,165@8055L34,166@8124L34,167@8189L43,172@8270L80,178@8559L24,177@8517L97,183@8750L333,192@9103L11610,180@8619L12095,558@26849L54,560@26927L201,558@26801L328:GeneralDownloadPreferences.kt#wlpkv4");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer4.changedInstance(onNavigateBack) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) == 2 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            $composer3 = $composer4;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-412493992, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences (GeneralDownloadPreferences.kt:131)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer4.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer4.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4));
                $composer4.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer4.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.startReplaceGroup(323404822);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState showSponsorBlockDialog$delegate2 = (MutableState) value$iv;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323404884);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableState showYtdlpDialog$delegate2 = (MutableState) value$iv2;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323404941);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv3 = $composer4.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            MutableState isUpdating$delegate = (MutableState) value$iv3;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv2 = $composer4.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            MutableState downloadSubtitle$delegate = (MutableState) value$iv$iv2;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv3 = $composer4.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.DEBUG, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            MutableState displayErrorReport$delegate = (MutableState) value$iv$iv3;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323405105);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv4 = $composer4.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue("playlist")), null, 2, null);
                $composer4.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            MutableState downloadPlaylist$delegate = (MutableState) value$iv4;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323405201);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv5 = $composer4.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.SPONSORBLOCK)), null, 2, null);
                $composer4.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            MutableState isSponsorBlockEnabled$delegate = (MutableState) value$iv5;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323405300);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv6 = $composer4.rememberedValue();
            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.NOTIFICATION)), null, 2, null);
                $composer4.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            final MutableState downloadNotification$delegate = (MutableState) value$iv6;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323405412);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv7 = $composer4.rememberedValue();
            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.PRIVATE_MODE)), null, 2, null);
                $composer4.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            MutableState isPrivateModeEnabled$delegate = (MutableState) value$iv7;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323405521);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv8 = $composer4.rememberedValue();
            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.DISABLE_PREVIEW)), null, 2, null);
                $composer4.updateRememberedValue(value$iv8);
            } else {
                value$iv8 = it$iv8;
            }
            MutableState isPreviewDisabled$delegate = (MutableState) value$iv8;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323405634);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv9 = $composer4.rememberedValue();
            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(NotificationUtil.INSTANCE.areNotificationsEnabled()), null, 2, null);
                $composer4.updateRememberedValue(value$iv9);
            } else {
                value$iv9 = it$iv9;
            }
            final MutableState isNotificationPermissionGranted$delegate = (MutableState) value$iv9;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323405760);
            ComposerKt.sourceInformation($composer4, "159@7703L246");
            PermissionState permissionStateRememberPermissionState = Build.VERSION.SDK_INT >= 33 ? PermissionStateKt.rememberPermissionState("android.permission.POST_NOTIFICATIONS", new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$notificationPermission$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean status) {
                    if (status) {
                        GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$29(isNotificationPermissionGranted$delegate, true);
                        return;
                    }
                    ToastUtil toastUtil = ToastUtil.INSTANCE;
                    String string = context.getString(C3070R.string.permission_denied);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    toastUtil.makeToast(string);
                }
            }, $composer4, 6, 0) : null;
            $composer4.endReplaceGroup();
            final PermissionState notificationPermission = permissionStateRememberPermissionState;
            $composer4.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
            $composer4.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv4 = $composer4.rememberedValue();
            if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.DOWNLOAD_ARCHIVE, false, 1, null)), null, 2, null);
                $composer4.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv4;
            }
            MutableState useDownloadArchive$delegate = (MutableState) value$iv$iv4;
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323406145);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv10 = $composer4.rememberedValue();
            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                value$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv10);
            } else {
                value$iv10 = it$iv10;
            }
            final MutableState showClearArchiveDialog$delegate = (MutableState) value$iv10;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323406214);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv11 = $composer4.rememberedValue();
            if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv11);
            } else {
                value$iv11 = it$iv11;
            }
            MutableState showNotificationDialog$delegate2 = (MutableState) value$iv11;
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323406279);
            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            Object it$iv12 = $composer4.rememberedValue();
            if (it$iv12 == Composer.INSTANCE.getEmpty()) {
                value$iv12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer4.updateRememberedValue(value$iv12);
            } else {
                value$iv12 = it$iv12;
            }
            MutableState archiveFileContent$delegate = (MutableState) value$iv12;
            $composer4.endReplaceGroup();
            PermissionState storagePermission = PermissionStateKt.rememberPermissionState("android.permission.WRITE_EXTERNAL_STORAGE", null, $composer4, 6, 2);
            boolean isPermissionGranted = Build.VERSION.SDK_INT > 29 || Intrinsics.areEqual(storagePermission.getStatus(), PermissionStatus.Granted.INSTANCE);
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer4, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer4, (TopAppBarDefaults.$stable << 12) | 48, 12);
            boolean z2 = false;
            ScaffoldKt.m2530ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(-538016484, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer5, int $changed2) {
                    ComposerKt.sourceInformation($composer5, "C186@8939L71,184@8801L272:GeneralDownloadPreferences.kt#wlpkv4");
                    if (($changed2 & 11) != 2 || !$composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-538016484, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous> (GeneralDownloadPreferences.kt:184)");
                        }
                        Function2<Composer, Integer, Unit> function2M7551getLambda1$app_debug = ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7551getLambda1$app_debug();
                        final Function0<Unit> function0 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7551getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(999698903, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer6, int $changed3) {
                                Object value$iv19;
                                ComposerKt.sourceInformation($composer6, "C187@8972L20,187@8961L31:GeneralDownloadPreferences.kt#wlpkv4");
                                if (($changed3 & 11) == 2 && $composer6.getSkipping()) {
                                    $composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(999698903, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:187)");
                                }
                                $composer6.startReplaceGroup(-828937832);
                                ComposerKt.sourceInformation($composer6, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                boolean invalid$iv = $composer6.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv13 = $composer6.rememberedValue();
                                if (invalid$iv || it$iv13 == Composer.INSTANCE.getEmpty()) {
                                    value$iv19 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$1$1$1$1
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
                                    $composer6.updateRememberedValue(value$iv19);
                                } else {
                                    value$iv19 = it$iv13;
                                }
                                $composer6.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv19, $composer6, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer5, 54), null, scrollBehavior, $composer5, 390, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer5.skipToGroupEnd();
                }
            }, $composer4, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1306909529, true, new C38622(context, isUpdating$delegate, showYtdlpDialog$delegate2, scope, notificationPermission, isNotificationPermissionGranted$delegate, downloadNotification$delegate, showNotificationDialog$delegate2, displayErrorReport$delegate, isPrivateModeEnabled$delegate, isPreviewDisabled$delegate, downloadPlaylist$delegate, isPermissionGranted, useDownloadArchive$delegate, archiveFileContent$delegate, showClearArchiveDialog$delegate, isSponsorBlockEnabled$delegate, showSponsorBlockDialog$delegate2, downloadSubtitle$delegate), $composer4, 54), $composer4, 805306416, 508);
            $composer4.startReplaceGroup(323418809);
            ComposerKt.sourceInformation($composer4, "428@20776L54,428@20757L73");
            if (GeneralDownloadPreferences$lambda$1(showSponsorBlockDialog$delegate2)) {
                $composer4.startReplaceGroup(323418866);
                str = "CC(remember):GeneralDownloadPreferences.kt#9igjgp";
                ComposerKt.sourceInformation($composer4, str);
                Object it$iv13 = $composer4.rememberedValue();
                if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                    showSponsorBlockDialog$delegate = showSponsorBlockDialog$delegate2;
                    value$iv18 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$3$1
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
                            GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$2(showSponsorBlockDialog$delegate, false);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv18);
                } else {
                    showSponsorBlockDialog$delegate = showSponsorBlockDialog$delegate2;
                    value$iv18 = it$iv13;
                }
                $composer4.endReplaceGroup();
                AdvancedSettingDialogsKt.SponsorBlockDialog((Function0) value$iv18, $composer4, 6);
            } else {
                showSponsorBlockDialog$delegate = showSponsorBlockDialog$delegate2;
                str = "CC(remember):GeneralDownloadPreferences.kt#9igjgp";
            }
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(323418931);
            ComposerKt.sourceInformation($composer4, "433@20920L8,434@20979L12,435@21022L65,438@21140L27,439@21197L321,447@21548L109,454@21812L4535,437@21097L5261");
            if (GeneralDownloadPreferences$lambda$4(showYtdlpDialog$delegate2)) {
                $composer4.startReplaceGroup(1963460724);
                ComposerKt.sourceInformation($composer4, "CC19@677L57:Ext.kt#x6o9ax");
                $composer4.startReplaceGroup(302245525);
                ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
                Object it$iv$iv5 = $composer4.rememberedValue();
                if (it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                    z = false;
                    value$iv$iv5 = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_UPDATE_CHANNEL, 0, 1, null));
                    $composer4.updateRememberedValue(value$iv$iv5);
                } else {
                    z = false;
                    value$iv$iv5 = it$iv$iv5;
                }
                final MutableIntState ytdlpUpdateChannel$delegate = (MutableIntState) value$iv$iv5;
                $composer4.endReplaceGroup();
                $composer4.endReplaceGroup();
                $composer4.startReplaceGroup(-2044908879);
                ComposerKt.sourceInformation($composer4, "CC12@469L46:Ext.kt#x6o9ax");
                $composer4.startReplaceGroup(-204592788);
                ComposerKt.sourceInformation($composer4, "CC(remember):Ext.kt#9igjgp");
                Object it$iv$iv6 = $composer4.rememberedValue();
                if (it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_AUTO_UPDATE, z, 1, null)), null, 2, null);
                    $composer4.updateRememberedValue(value$iv$iv6);
                } else {
                    value$iv$iv6 = it$iv$iv6;
                }
                final MutableState ytdlpAutoUpdate$delegate = (MutableState) value$iv$iv6;
                $composer4.endReplaceGroup();
                $composer4.endReplaceGroup();
                $composer4.startReplaceGroup(323419112);
                ComposerKt.sourceInformation($composer4, str);
                Object it$iv14 = $composer4.rememberedValue();
                if (it$iv14 == Composer.INSTANCE.getEmpty()) {
                    value$iv16 = SnapshotLongStateKt.mutableLongStateOf(PreferenceUtil.getLong$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_UPDATE_INTERVAL, 0L, 1, null));
                    $composer4.updateRememberedValue(value$iv16);
                } else {
                    value$iv16 = it$iv14;
                }
                final MutableLongState updateInterval$delegate = (MutableLongState) value$iv16;
                $composer4.endReplaceGroup();
                $composer4.startReplaceGroup(323419230);
                ComposerKt.sourceInformation($composer4, str);
                Object it$iv15 = $composer4.rememberedValue();
                if (it$iv15 == Composer.INSTANCE.getEmpty()) {
                    showYtdlpDialog$delegate = showYtdlpDialog$delegate2;
                    value$iv17 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$4$1
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
                            GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$5(showYtdlpDialog$delegate, false);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv17);
                } else {
                    showYtdlpDialog$delegate = showYtdlpDialog$delegate2;
                    value$iv17 = it$iv15;
                }
                $composer4.endReplaceGroup();
                z2 = false;
                $composer2 = $composer4;
                DialogsKt.m7298LoopDialogOix01E0(null, (Function0) value$iv17, ComposableLambdaKt.rememberComposableLambda(-1588117051, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer5, int $changed2) {
                        Object value$iv19;
                        ComposerKt.sourceInformation($composer5, "C440@21229L275,440@21215L289:GeneralDownloadPreferences.kt#wlpkv4");
                        if (($changed2 & 11) == 2 && $composer5.getSkipping()) {
                            $composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1588117051, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous> (GeneralDownloadPreferences.kt:440)");
                        }
                        $composer5.startReplaceGroup(-974413864);
                        ComposerKt.sourceInformation($composer5, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                        boolean invalid$iv = $composer5.changed(ytdlpAutoUpdate$delegate) | $composer5.changed(ytdlpUpdateChannel$delegate);
                        final MutableState<Boolean> mutableState = ytdlpAutoUpdate$delegate;
                        final MutableIntState mutableIntState = ytdlpUpdateChannel$delegate;
                        final MutableLongState mutableLongState = updateInterval$delegate;
                        final MutableState<Boolean> mutableState2 = showYtdlpDialog$delegate;
                        Object it$iv16 = $composer5.rememberedValue();
                        if (invalid$iv || it$iv16 == Composer.INSTANCE.getEmpty()) {
                            value$iv19 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$5$1$1
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
                                    PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.YT_DLP_AUTO_UPDATE, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$44(mutableState));
                                    PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.YT_DLP_UPDATE_CHANNEL, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$42(mutableIntState));
                                    PreferenceUtil.INSTANCE.updateLong(PreferenceUtilKt.YT_DLP_UPDATE_INTERVAL, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$47(mutableLongState));
                                    GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$5(mutableState2, false);
                                }
                            };
                            $composer5.updateRememberedValue(value$iv19);
                        } else {
                            value$iv19 = it$iv16;
                        }
                        $composer5.endReplaceGroup();
                        ButtonsKt.ConfirmButton(null, false, (Function0) value$iv19, $composer5, 0, 3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1324420026, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer5, int $changed2) {
                        Object value$iv19;
                        ComposerKt.sourceInformation($composer5, "C448@21580L63,448@21566L77:GeneralDownloadPreferences.kt#wlpkv4");
                        if (($changed2 & 11) == 2 && $composer5.getSkipping()) {
                            $composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1324420026, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous> (GeneralDownloadPreferences.kt:448)");
                        }
                        $composer5.startReplaceGroup(-974413513);
                        ComposerKt.sourceInformation($composer5, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                        final MutableState<Boolean> mutableState = showYtdlpDialog$delegate;
                        Object it$iv16 = $composer5.rememberedValue();
                        if (it$iv16 == Composer.INSTANCE.getEmpty()) {
                            value$iv19 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$6$1$1
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
                                    GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$5(mutableState, false);
                                }
                            };
                            $composer5.updateRememberedValue(value$iv19);
                        } else {
                            value$iv19 = it$iv16;
                        }
                        $composer5.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv19, $composer5, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer4, 54), ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7565getLambda8$app_debug(), ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7566getLambda9$app_debug(), ComposableLambdaKt.rememberComposableLambda(-533328951, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer5, int $changed2) {
                        Object value$iv19;
                        ComposerKt.sourceInformation($composer5, "C455@21843L4490,455@21830L4503:GeneralDownloadPreferences.kt#wlpkv4");
                        if (($changed2 & 11) == 2 && $composer5.getSkipping()) {
                            $composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-533328951, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous> (GeneralDownloadPreferences.kt:455)");
                        }
                        $composer5.startReplaceGroup(-974413250);
                        ComposerKt.sourceInformation($composer5, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                        boolean invalid$iv = $composer5.changed(ytdlpUpdateChannel$delegate) | $composer5.changed(ytdlpAutoUpdate$delegate);
                        final MutableIntState mutableIntState = ytdlpUpdateChannel$delegate;
                        final MutableState<Boolean> mutableState = ytdlpAutoUpdate$delegate;
                        final MutableLongState mutableLongState = updateInterval$delegate;
                        Object it$iv16 = $composer5.rememberedValue();
                        if (invalid$iv || it$iv16 == Composer.INSTANCE.getEmpty()) {
                            value$iv19 = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1
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
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7552getLambda10$app_debug(), 3, null);
                                    final MutableIntState mutableIntState2 = mutableIntState;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-124069164, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                            Object value$iv20;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer6, "C472@22668L90,468@22452L306:GeneralDownloadPreferences.kt#wlpkv4");
                                            if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-124069164, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:468)");
                                                }
                                                boolean z3 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$42(mutableIntState2) == 0;
                                                $composer6.startReplaceGroup(896439770);
                                                ComposerKt.sourceInformation($composer6, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                                boolean invalid$iv2 = $composer6.changed(mutableIntState2);
                                                final MutableIntState mutableIntState3 = mutableIntState2;
                                                Object it$iv17 = $composer6.rememberedValue();
                                                if (invalid$iv2 || it$iv17 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv20 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1$1$1$1
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
                                                            mutableIntState3.setIntValue(0);
                                                        }
                                                    };
                                                    $composer6.updateRememberedValue(value$iv20);
                                                } else {
                                                    value$iv20 = it$iv17;
                                                }
                                                $composer6.endReplaceGroup();
                                                GeneralDownloadPreferencesKt.m7567DialogSingleChoiceItemFHprtrg(null, "yt-dlp", z3, "Stable", 0L, (Function0) value$iv20, $composer6, 3120, 17);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableIntState mutableIntState3 = mutableIntState;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1189036395, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1.2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer6, int $changed3) {
                                            Object value$iv20;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer6, "C481@23104L11,482@23151L91,477@22832L410:GeneralDownloadPreferences.kt#wlpkv4");
                                            if (($changed3 & 81) != 16 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1189036395, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:477)");
                                                }
                                                boolean z3 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$42(mutableIntState3) == 1;
                                                long tertiary = MaterialTheme.INSTANCE.getColorScheme($composer6, MaterialTheme.$stable).getTertiary();
                                                $composer6.startReplaceGroup(896440253);
                                                ComposerKt.sourceInformation($composer6, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                                boolean invalid$iv2 = $composer6.changed(mutableIntState3);
                                                final MutableIntState mutableIntState4 = mutableIntState3;
                                                Object it$iv17 = $composer6.rememberedValue();
                                                if (invalid$iv2 || it$iv17 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv20 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1$2$1$1
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
                                                            mutableIntState4.setIntValue(1);
                                                        }
                                                    };
                                                    $composer6.updateRememberedValue(value$iv20);
                                                } else {
                                                    value$iv20 = it$iv17;
                                                }
                                                $composer6.endReplaceGroup();
                                                GeneralDownloadPreferencesKt.m7567DialogSingleChoiceItemFHprtrg(null, "yt-dlp-nightly-builds", z3, "Nightly", tertiary, (Function0) value$iv20, $composer6, 3120, 1);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7553getLambda11$app_debug(), 3, null);
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(975996439, true, new C38803(mutableState, mutableLongState)), 3, null);
                                }

                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1$3 */
                                /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
                                @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                static final class C38803 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
                                    final /* synthetic */ MutableLongState $updateInterval$delegate;
                                    final /* synthetic */ MutableState<Boolean> $ytdlpAutoUpdate$delegate;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C38803(MutableState<Boolean> mutableState, MutableLongState mutableLongState) {
                                        super(3);
                                        this.$ytdlpAutoUpdate$delegate = mutableState;
                                        this.$updateInterval$delegate = mutableLongState;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                                        MutableState<Boolean> $this$getValue$iv = mutableState;
                                        return $this$getValue$iv.getValue().booleanValue();
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                                        mutableState.setValue(Boolean.valueOf(value));
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                                        Object value$iv;
                                        Object value$iv2;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer, "C498@23894L34,503@24151L17,503@24170L2123,500@23954L2339:GeneralDownloadPreferences.kt#wlpkv4");
                                        if (($changed & 81) == 16 && $composer.getSkipping()) {
                                            $composer.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(975996439, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:498)");
                                        }
                                        $composer.startReplaceGroup(896440996);
                                        ComposerKt.sourceInformation($composer, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                        Object it$iv = $composer.rememberedValue();
                                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                            $composer.updateRememberedValue(value$iv);
                                        } else {
                                            value$iv = it$iv;
                                        }
                                        final MutableState expanded$delegate = (MutableState) value$iv;
                                        $composer.endReplaceGroup();
                                        Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(20), 0.0f, 2, null);
                                        boolean zInvoke$lambda$1 = invoke$lambda$1(expanded$delegate);
                                        $composer.startReplaceGroup(896441253);
                                        ComposerKt.sourceInformation($composer, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                        Object it$iv2 = $composer.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a0: CONSTRUCTOR (r11v6 'value$iv2' java.lang.Object A[D('$i$a$-cache-GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1$3$1' int)]) = 
                                                  (r14v1 'expanded$delegate' androidx.compose.runtime.MutableState A[D('expanded$delegate' androidx.compose.runtime.MutableState), DONT_INLINE])
                                                 A[MD:(androidx.compose.runtime.MutableState<java.lang.Boolean>):void (m)] (LINE:504) call: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1$3$1$1.<init>(androidx.compose.runtime.MutableState):void type: CONSTRUCTOR in method: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1.3.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void, file: classes9.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1$3$1$1, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	... 25 more
                                                */
                                            /*
                                                Method dump skipped, instruction units count: 219
                                                To view this dump add '--comments-level debug' option
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.p006ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$7$1$1.C38803.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void");
                                        }
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv19);
                            } else {
                                value$iv19 = it$iv16;
                            }
                            $composer5.endReplaceGroup();
                            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, (Function1) value$iv19, $composer5, 0, 255);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797552, 0, 16257);
                } else {
                    $composer2 = $composer4;
                }
                $composer2.endReplaceGroup();
                $composer3 = $composer2;
                $composer3.startReplaceGroup(323424459);
                ComposerKt.sourceInformation($composer3, "547@26514L34,545@26407L344");
                if (GeneralDownloadPreferences$lambda$33(showClearArchiveDialog$delegate)) {
                    String strGeneralDownloadPreferences$lambda$39 = GeneralDownloadPreferences$lambda$39(archiveFileContent$delegate);
                    $composer3.startReplaceGroup(323424604);
                    str2 = str;
                    ComposerKt.sourceInformation($composer3, str2);
                    Object it$iv16 = $composer3.rememberedValue();
                    if (it$iv16 == Composer.INSTANCE.getEmpty()) {
                        value$iv15 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$8$1
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
                                GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$34(showClearArchiveDialog$delegate, false);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv15);
                    } else {
                        value$iv15 = it$iv16;
                    }
                    $composer3.endReplaceGroup();
                    DownloadArchiveDialog(strGeneralDownloadPreferences$lambda$39, (Function0) value$iv15, new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.9
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                            invoke2(str3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$9$1, reason: invalid class name */
                        /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
                        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$9$1", m210f = "GeneralDownloadPreferences.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ String $content;
                            final /* synthetic */ Context $context;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Context context, String str, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$context = context;
                                this.$content = str;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$content, continuation);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
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
                                        Context context = this.$context;
                                        String str = this.$content;
                                        try {
                                            Result.Companion companion = Result.INSTANCE;
                                            FilesKt.writeText$default(FileUtil.INSTANCE.getArchiveFile(context), str, null, 2, null);
                                            Result.m7693constructorimpl(Unit.INSTANCE);
                                            break;
                                        } catch (Throwable th) {
                                            Result.Companion companion2 = Result.INSTANCE;
                                            Result.m7693constructorimpl(ResultKt.createFailure(th));
                                        }
                                        return Unit.INSTANCE;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String content) {
                            Intrinsics.checkNotNullParameter(content, "content");
                            BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new AnonymousClass1(context, content, null), 2, null);
                        }
                    }, $composer3, 48);
                } else {
                    str2 = str;
                }
                $composer3.endReplaceGroup();
                if (GeneralDownloadPreferences$lambda$36(showNotificationDialog$delegate2)) {
                    $composer3.startReplaceGroup(323424939);
                    ComposerKt.sourceInformation($composer3, str2);
                    Object it$iv17 = $composer3.rememberedValue();
                    if (it$iv17 == Composer.INSTANCE.getEmpty()) {
                        showNotificationDialog$delegate = showNotificationDialog$delegate2;
                        value$iv13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$10$1
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
                                GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$37(showNotificationDialog$delegate, false);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv13);
                    } else {
                        showNotificationDialog$delegate = showNotificationDialog$delegate2;
                        value$iv13 = it$iv17;
                    }
                    Function0 function0 = (Function0) value$iv13;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(323425017);
                    ComposerKt.sourceInformation($composer3, str2);
                    boolean invalid$iv = $composer3.changed(notificationPermission);
                    Object it$iv18 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv18 == Composer.INSTANCE.getEmpty()) {
                        value$iv14 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$11$1
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
                                PermissionState permissionState = notificationPermission;
                                if (permissionState != null) {
                                    permissionState.launchPermissionRequest();
                                }
                                PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.NOTIFICATION, true);
                                GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$20(downloadNotification$delegate, true);
                                GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$37(showNotificationDialog$delegate, false);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv14);
                    } else {
                        value$iv14 = it$iv18;
                    }
                    $composer3.endReplaceGroup();
                    NotificationPermissionDialogKt.NotificationPermissionDialog(function0, (Function0) value$iv14, $composer3, 6, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.12
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
                        GeneralDownloadPreferencesKt.GeneralDownloadPreferences(onNavigateBack, navigateToTemplate, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                    }
                });
            }
        }

        private static final boolean GeneralDownloadPreferences$lambda$1(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$2(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        private static final boolean GeneralDownloadPreferences$lambda$4(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$5(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$7(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$8(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$9(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$10(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$11(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$13(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$14(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$16(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$17(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$19(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$20(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$22(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$23(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$25(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$26(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$28(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$29(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$30(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$31(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        private static final boolean GeneralDownloadPreferences$lambda$33(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$34(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        private static final boolean GeneralDownloadPreferences$lambda$36(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$37(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        private static final String GeneralDownloadPreferences$lambda$39(MutableState<String> mutableState) {
            MutableState<String> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$40(MutableState<String> mutableState, String value) {
            mutableState.setValue(value);
        }

        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2 */
        /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
        @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, m195d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/layout/PaddingValues;", "invoke", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        static final class C38622 extends Lambda implements Function3<PaddingValues, Composer, Integer, Unit> {
            final /* synthetic */ MutableState<String> $archiveFileContent$delegate;
            final /* synthetic */ Context $context;
            final /* synthetic */ MutableState<Boolean> $displayErrorReport$delegate;
            final /* synthetic */ MutableState<Boolean> $downloadNotification$delegate;
            final /* synthetic */ MutableState<Boolean> $downloadPlaylist$delegate;
            final /* synthetic */ MutableState<Boolean> $downloadSubtitle$delegate;
            final /* synthetic */ MutableState<Boolean> $isNotificationPermissionGranted$delegate;
            final /* synthetic */ boolean $isPermissionGranted;
            final /* synthetic */ MutableState<Boolean> $isPreviewDisabled$delegate;
            final /* synthetic */ MutableState<Boolean> $isPrivateModeEnabled$delegate;
            final /* synthetic */ MutableState<Boolean> $isSponsorBlockEnabled$delegate;
            final /* synthetic */ MutableState<Boolean> $isUpdating$delegate;
            final /* synthetic */ PermissionState $notificationPermission;
            final /* synthetic */ CoroutineScope $scope;
            final /* synthetic */ MutableState<Boolean> $showClearArchiveDialog$delegate;
            final /* synthetic */ MutableState<Boolean> $showNotificationDialog$delegate;
            final /* synthetic */ MutableState<Boolean> $showSponsorBlockDialog$delegate;
            final /* synthetic */ MutableState<Boolean> $showYtdlpDialog$delegate;
            final /* synthetic */ MutableState<Boolean> $useDownloadArchive$delegate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C38622(Context context, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, CoroutineScope coroutineScope, PermissionState permissionState, MutableState<Boolean> mutableState3, MutableState<Boolean> mutableState4, MutableState<Boolean> mutableState5, MutableState<Boolean> mutableState6, MutableState<Boolean> mutableState7, MutableState<Boolean> mutableState8, MutableState<Boolean> mutableState9, boolean z, MutableState<Boolean> mutableState10, MutableState<String> mutableState11, MutableState<Boolean> mutableState12, MutableState<Boolean> mutableState13, MutableState<Boolean> mutableState14, MutableState<Boolean> mutableState15) {
                super(3);
                this.$context = context;
                this.$isUpdating$delegate = mutableState;
                this.$showYtdlpDialog$delegate = mutableState2;
                this.$scope = coroutineScope;
                this.$notificationPermission = permissionState;
                this.$isNotificationPermissionGranted$delegate = mutableState3;
                this.$downloadNotification$delegate = mutableState4;
                this.$showNotificationDialog$delegate = mutableState5;
                this.$displayErrorReport$delegate = mutableState6;
                this.$isPrivateModeEnabled$delegate = mutableState7;
                this.$isPreviewDisabled$delegate = mutableState8;
                this.$downloadPlaylist$delegate = mutableState9;
                this.$isPermissionGranted = z;
                this.$useDownloadArchive$delegate = mutableState10;
                this.$archiveFileContent$delegate = mutableState11;
                this.$showClearArchiveDialog$delegate = mutableState12;
                this.$isSponsorBlockEnabled$delegate = mutableState13;
                this.$showSponsorBlockDialog$delegate = mutableState14;
                this.$downloadSubtitle$delegate = mutableState15;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                invoke(paddingValues, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            public final void invoke(PaddingValues it, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(it, "it");
                ComposerKt.sourceInformation($composer, "C193@9147L134,198@9294L11409:GeneralDownloadPreferences.kt#wlpkv4");
                int $dirty = $changed;
                if (($changed & 14) == 0) {
                    $dirty |= $composer.changed(it) ? 4 : 2;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1306909529, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous> (GeneralDownloadPreferences.kt:193)");
                    }
                    $composer.startReplaceGroup(-974425946);
                    ComposerKt.sourceInformation($composer, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                    Object it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CUSTOM_COMMAND)), null, 2, null);
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    final MutableState isCustomCommandEnabled$delegate = (MutableState) value$iv;
                    $composer.endReplaceGroup();
                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                    final Context context = this.$context;
                    final MutableState<Boolean> mutableState = this.$isUpdating$delegate;
                    final MutableState<Boolean> mutableState2 = this.$showYtdlpDialog$delegate;
                    final CoroutineScope coroutineScope = this.$scope;
                    final PermissionState permissionState = this.$notificationPermission;
                    final MutableState<Boolean> mutableState3 = this.$isNotificationPermissionGranted$delegate;
                    final MutableState<Boolean> mutableState4 = this.$downloadNotification$delegate;
                    final MutableState<Boolean> mutableState5 = this.$showNotificationDialog$delegate;
                    final MutableState<Boolean> mutableState6 = this.$displayErrorReport$delegate;
                    final MutableState<Boolean> mutableState7 = this.$isPrivateModeEnabled$delegate;
                    final MutableState<Boolean> mutableState8 = this.$isPreviewDisabled$delegate;
                    final MutableState<Boolean> mutableState9 = this.$downloadPlaylist$delegate;
                    final boolean z = this.$isPermissionGranted;
                    final MutableState<Boolean> mutableState10 = this.$useDownloadArchive$delegate;
                    final MutableState<String> mutableState11 = this.$archiveFileContent$delegate;
                    final MutableState<Boolean> mutableState12 = this.$showClearArchiveDialog$delegate;
                    final MutableState<Boolean> mutableState13 = this.$isSponsorBlockEnabled$delegate;
                    final MutableState<Boolean> mutableState14 = this.$showSponsorBlockDialog$delegate;
                    final MutableState<Boolean> mutableState15 = this.$downloadSubtitle$delegate;
                    LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1
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
                            if (C38622.invoke$lambda$1(isCustomCommandEnabled$delegate)) {
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7559getLambda2$app_debug(), 3, null);
                            }
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1753095315, true, new C46171(context, mutableState, mutableState2, coroutineScope)), 3, null);
                            final PermissionState permissionState2 = permissionState;
                            final MutableState<Boolean> mutableState16 = mutableState3;
                            final MutableState<Boolean> mutableState17 = mutableState4;
                            final MutableState<Boolean> mutableState18 = mutableState5;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-878065604, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    ImageVector notifications;
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C257@12370L51,258@12461L207,266@13048L664,257@12345L1368:GeneralDownloadPreferences.kt#wlpkv4");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-878065604, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:257)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.download_notification, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$28(mutableState16) ? C3070R.string.download_notification_desc : C3070R.string.permission_denied, $composer2, 0);
                                        if (GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$28(mutableState16)) {
                                            notifications = !GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$19(mutableState17) ? NotificationsKt.getNotifications(Icons.Outlined.INSTANCE) : NotificationsActiveKt.getNotificationsActive(Icons.Outlined.INSTANCE);
                                        } else {
                                            notifications = NotificationsOffKt.getNotificationsOff(Icons.Outlined.INSTANCE);
                                        }
                                        boolean z2 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$19(mutableState17) && GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$28(mutableState16);
                                        $composer2.startReplaceGroup(-1602418267);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                        boolean invalid$iv = $composer2.changed(permissionState2);
                                        final PermissionState permissionState3 = permissionState2;
                                        final MutableState<Boolean> mutableState19 = mutableState18;
                                        final MutableState<Boolean> mutableState20 = mutableState16;
                                        final MutableState<Boolean> mutableState21 = mutableState17;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$2$1$1
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
                                                    PermissionState permissionState4 = permissionState3;
                                                    if ((permissionState4 != null ? permissionState4.getStatus() : null) instanceof PermissionStatus.Denied) {
                                                        GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$37(mutableState19, true);
                                                    } else if (GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$28(mutableState20)) {
                                                        if (GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$19(mutableState21)) {
                                                            NotificationUtil.INSTANCE.cancelAllNotifications();
                                                        }
                                                        GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$20(mutableState21, true ^ GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$19(mutableState21));
                                                        PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.NOTIFICATION, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$19(mutableState21));
                                                    }
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, notifications, false, z2, null, (Function0) value$iv2, $composer2, 0, 40);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7561getLambda4$app_debug(), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(438700154, true, new AnonymousClass3(isCustomCommandEnabled$delegate)), 3, null);
                            final MutableState<Boolean> mutableState19 = mutableState6;
                            final MutableState<Boolean> mutableState20 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1097083033, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C317@15529L38,318@15607L43,321@15856L178,316@15479L633:GeneralDownloadPreferences.kt#wlpkv4");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1097083033, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:316)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.print_details, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.print_details_desc, $composer2, 0);
                                        ImageVector print = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$10(mutableState19) ? PrintKt.getPrint(Icons.Outlined.INSTANCE) : PrintDisabledKt.getPrintDisabled(Icons.Outlined.INSTANCE);
                                        boolean z2 = !C38622.invoke$lambda$1(mutableState20);
                                        boolean zGeneralDownloadPreferences$lambda$10 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$10(mutableState19);
                                        $composer2.startReplaceGroup(-1602415459);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                        boolean invalid$iv = $composer2.changed(mutableState19);
                                        final MutableState<Boolean> mutableState21 = mutableState19;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$4$1$1
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
                                                    GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$11(mutableState21, !GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$10(mutableState21));
                                                    PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.DEBUG, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$10(mutableState21));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, print, z2, zGeneralDownloadPreferences$lambda$10, null, (Function0) value$iv2, $composer2, 0, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7562getLambda5$app_debug(), 3, null);
                            final MutableState<Boolean> mutableState21 = mutableState7;
                            final MutableState<Boolean> mutableState22 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1881118505, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C335@16352L37,336@16429L42,340@16742L285,334@16302L747:GeneralDownloadPreferences.kt#wlpkv4");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1881118505, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:334)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.private_mode, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.private_mode_desc, $composer2, 0);
                                        ImageVector historyToggleOff = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$22(mutableState21) ? HistoryToggleOffKt.getHistoryToggleOff(Icons.Outlined.INSTANCE) : HistoryKt.getHistory(Icons.Outlined.INSTANCE);
                                        boolean zGeneralDownloadPreferences$lambda$22 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$22(mutableState21);
                                        boolean z2 = !C38622.invoke$lambda$1(mutableState22);
                                        $composer2.startReplaceGroup(-1602414573);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                        final MutableState<Boolean> mutableState23 = mutableState21;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$5$1$1
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
                                                    GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$23(mutableState23, !GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$22(mutableState23));
                                                    PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.PRIVATE_MODE, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$22(mutableState23));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, historyToggleOff, z2, zGeneralDownloadPreferences$lambda$22, null, (Function0) value$iv2, $composer2, 1572864, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState23 = mutableState8;
                            final MutableState<Boolean> mutableState24 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1222735626, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C351@17161L40,352@17241L45,356@17551L279,350@17111L741:GeneralDownloadPreferences.kt#wlpkv4");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1222735626, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:350)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.disable_preview, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.disable_preview_desc, $composer2, 0);
                                        ImageVector visibilityOff = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$25(mutableState23) ? VisibilityOffKt.getVisibilityOff(Icons.Outlined.INSTANCE) : VisibilityKt.getVisibility(Icons.Outlined.INSTANCE);
                                        boolean zGeneralDownloadPreferences$lambda$25 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$25(mutableState23);
                                        boolean z2 = !C38622.invoke$lambda$1(mutableState24);
                                        $composer2.startReplaceGroup(-1602413764);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                        final MutableState<Boolean> mutableState25 = mutableState23;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$6$1$1
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
                                                    GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$26(mutableState25, !GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$25(mutableState25));
                                                    PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.DISABLE_PREVIEW, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$25(mutableState25));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, visibilityOff, z2, zGeneralDownloadPreferences$lambda$25, null, (Function0) value$iv2, $composer2, 1572864, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7563getLambda6$app_debug(), 3, null);
                            final MutableState<Boolean> mutableState25 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState26 = mutableState9;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(94030132, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C371@18096L47,380@18579L47,372@18179L237,370@18046L656:GeneralDownloadPreferences.kt#wlpkv4");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(94030132, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:370)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.download_playlist, $composer2, 0);
                                        ImageVector playlistAddCheck = PlaylistAddCheckKt.getPlaylistAddCheck(Icons.Outlined.INSTANCE);
                                        boolean z2 = !C38622.invoke$lambda$1(mutableState25);
                                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.download_playlist_desc, $composer2, 0);
                                        boolean zGeneralDownloadPreferences$lambda$13 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$13(mutableState26);
                                        $composer2.startReplaceGroup(-1602413136);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                        final MutableState<Boolean> mutableState27 = mutableState26;
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$7$1$1
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
                                                    GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$14(mutableState27, !GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$13(mutableState27));
                                                    PreferenceUtil.INSTANCE.updateValue("playlist", GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$13(mutableState27));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, playlistAddCheck, z2, zGeneralDownloadPreferences$lambda$13, null, (Function0) value$iv2, $composer2, 1572864, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final boolean z2 = z;
                            final MutableState<Boolean> mutableState27 = mutableState10;
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            final Context context2 = context;
                            final MutableState<String> mutableState28 = mutableState11;
                            final MutableState<Boolean> mutableState29 = mutableState12;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-260211910, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C387@18826L46,397@19372L46,399@19512L175,386@18765L999:GeneralDownloadPreferences.kt#wlpkv4");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-260211910, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:386)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.download_archive, $composer2, 0);
                                    ImageVector archive = ArchiveKt.getArchive(Icons.Outlined.INSTANCE);
                                    String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.download_archive_desc, $composer2, 0);
                                    boolean zGeneralDownloadPreferences$lambda$30 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$30(mutableState27);
                                    boolean z3 = z2;
                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                    final Context context3 = context2;
                                    final MutableState<String> mutableState30 = mutableState28;
                                    final MutableState<Boolean> mutableState31 = mutableState29;
                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.8.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$8$1$1, reason: invalid class name and collision with other inner class name */
                                        /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
                                        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                        @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$8$1$1", m210f = "GeneralDownloadPreferences.kt", m211i = {}, m212l = {392}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                        static final class C46211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ MutableState<String> $archiveFileContent$delegate;
                                            final /* synthetic */ Context $context;
                                            final /* synthetic */ MutableState<Boolean> $showClearArchiveDialog$delegate;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C46211(Context context, MutableState<String> mutableState, MutableState<Boolean> mutableState2, Continuation<? super C46211> continuation) {
                                                super(2, continuation);
                                                this.$context = context;
                                                this.$archiveFileContent$delegate = mutableState;
                                                this.$showClearArchiveDialog$delegate = mutableState2;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C46211(this.$context, this.$archiveFileContent$delegate, this.$showClearArchiveDialog$delegate, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C46211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object $result) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0:
                                                        ResultKt.throwOnFailure($result);
                                                        GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$40(this.$archiveFileContent$delegate, FilesKt.readText$default(FileUtil.INSTANCE.getArchiveFile(this.$context), null, 1, null));
                                                        this.label = 1;
                                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C46221(this.$showClearArchiveDialog$delegate, null), this) == coroutine_suspended) {
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

                                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$8$1$1$1, reason: invalid class name and collision with other inner class name */
                                            /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
                                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$8$1$1$1", m210f = "GeneralDownloadPreferences.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                            static final class C46221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ MutableState<Boolean> $showClearArchiveDialog$delegate;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C46221(MutableState<Boolean> mutableState, Continuation<? super C46221> continuation) {
                                                    super(2, continuation);
                                                    this.$showClearArchiveDialog$delegate = mutableState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C46221(this.$showClearArchiveDialog$delegate, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C46221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0:
                                                            ResultKt.throwOnFailure(obj);
                                                            GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$34(this.$showClearArchiveDialog$delegate, true);
                                                            return Unit.INSTANCE;
                                                        default:
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                }
                                            }
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, Dispatchers.getIO(), null, new C46211(context3, mutableState30, mutableState31, null), 2, null);
                                        }
                                    };
                                    $composer2.startReplaceGroup(-1602411803);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                    boolean invalid$iv = $composer2.changed(mutableState27);
                                    final MutableState<Boolean> mutableState32 = mutableState27;
                                    Object it$iv2 = $composer2.rememberedValue();
                                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$8$2$1
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
                                                GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$31(mutableState32, !GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$30(mutableState32));
                                                PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.DOWNLOAD_ARCHIVE, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$30(mutableState32));
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv2);
                                    } else {
                                        value$iv2 = it$iv2;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSwitchWithDivider(strStringResource, strStringResource2, archive, z3, false, zGeneralDownloadPreferences$lambda$30, null, function0, (Function0) value$iv2, $composer2, 0, 80);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState30 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState31 = mutableState13;
                            final MutableState<Boolean> mutableState32 = mutableState14;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(398170969, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.9
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv2;
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C408@19863L37,409@19940L96,419@20478L33,415@20248L194,408@19827L685:GeneralDownloadPreferences.kt#wlpkv4");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(398170969, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:408)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.sponsorblock, $composer2, 0);
                                    String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.sponsorblock_desc, $composer2, 0);
                                    ImageVector moneyOff = MoneyOffKt.getMoneyOff(Icons.Outlined.INSTANCE);
                                    boolean z3 = !C38622.invoke$lambda$1(mutableState30);
                                    boolean zGeneralDownloadPreferences$lambda$16 = GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$16(mutableState31);
                                    $composer2.startReplaceGroup(-1602410837);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState33 = mutableState32;
                                    Object it$iv2 = $composer2.rememberedValue();
                                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$9$1$1
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
                                                GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$2(mutableState33, true);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv2);
                                    } else {
                                        value$iv2 = it$iv2;
                                    }
                                    Function0 function0 = (Function0) value$iv2;
                                    $composer2.endReplaceGroup();
                                    $composer2.startReplaceGroup(-1602411067);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState34 = mutableState31;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$9$2$1
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
                                                GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$17(mutableState34, !GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$16(mutableState34));
                                                PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.SPONSORBLOCK, GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$16(mutableState34));
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSwitchWithDivider(strStringResource, strStringResource2, moneyOff, z3, false, zGeneralDownloadPreferences$lambda$16, null, function0, (Function0) value$iv3, $composer2, 113246208, 80);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            if (GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$9(mutableState15)) {
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7564getLambda7$app_debug(), 3, null);
                            }
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
                        @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        static final class C46171 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
                            final /* synthetic */ Context $context;
                            final /* synthetic */ MutableState<Boolean> $isUpdating$delegate;
                            final /* synthetic */ CoroutineScope $scope;
                            final /* synthetic */ MutableState<Boolean> $showYtdlpDialog$delegate;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C46171(Context context, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, CoroutineScope coroutineScope) {
                                super(3);
                                this.$context = context;
                                this.$isUpdating$delegate = mutableState;
                                this.$showYtdlpDialog$delegate = mutableState2;
                                this.$scope = coroutineScope;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            private static final String invoke$lambda$1(MutableState<String> mutableState) {
                                MutableState<String> $this$getValue$iv = mutableState;
                                return $this$getValue$iv.getValue();
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$2(MutableState<String> mutableState, String value) {
                                mutableState.setValue(value);
                            }

                            public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                                Object value$iv;
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer, "C209@9766L262,216@10097L49,243@11722L36,218@10238L614,244@11799L462,215@10049L2234:GeneralDownloadPreferences.kt#wlpkv4");
                                if (($changed & 81) != 16 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1753095315, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:209)");
                                    }
                                    $composer.startReplaceGroup(-1602421549);
                                    ComposerKt.sourceInformation($composer, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                    Context context = this.$context;
                                    Object it$iv = $composer.rememberedValue();
                                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                                        String strVersion = YoutubeDL.getInstance().version(context.getApplicationContext());
                                        if (strVersion == null) {
                                            strVersion = context.getString(C3070R.string.ytdlp_update);
                                            Intrinsics.checkNotNullExpressionValue(strVersion, "getString(...)");
                                        }
                                        value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(strVersion, null, 2, null);
                                        $composer.updateRememberedValue(value$iv);
                                    } else {
                                        value$iv = it$iv;
                                    }
                                    final MutableState ytdlpVersion$delegate = (MutableState) value$iv;
                                    $composer.endReplaceGroup();
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.ytdlp_update_action, $composer, 0);
                                    String strInvoke$lambda$1 = invoke$lambda$1(ytdlpVersion$delegate);
                                    String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.update, $composer, 0);
                                    final MutableState<Boolean> mutableState = this.$isUpdating$delegate;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-3700175, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.1.1
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
                                            ComposerKt.sourceInformation($composer2, "C:GeneralDownloadPreferences.kt#wlpkv4");
                                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-3700175, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:219)");
                                                }
                                                if (GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$7(mutableState)) {
                                                    $composer2.startReplaceGroup(896427386);
                                                    ComposerKt.sourceInformation($composer2, "219@10284L25");
                                                    GeneralDownloadPreferencesKt.UpdateProgressIndicator($composer2, 0);
                                                } else {
                                                    $composer2.startReplaceGroup(896427451);
                                                    ComposerKt.sourceInformation($composer2, "226@10734L11,220@10349L447");
                                                    IconKt.m2292Iconww6aTOc(UpdateKt.getUpdate(Icons.Outlined.INSTANCE), (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), $composer2, 432, 0);
                                                }
                                                $composer2.endReplaceGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer2.skipToGroupEnd();
                                        }
                                    }, $composer, 54);
                                    final MutableState<Boolean> mutableState2 = this.$showYtdlpDialog$delegate;
                                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1336499376, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.1.2
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
                                            Object value$iv2;
                                            ComposerKt.sourceInformation($composer2, "C245@11850L26,245@11829L406:GeneralDownloadPreferences.kt#wlpkv4");
                                            if (($changed2 & 11) == 2 && $composer2.getSkipping()) {
                                                $composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1336499376, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:245)");
                                            }
                                            $composer2.startReplaceGroup(896428952);
                                            ComposerKt.sourceInformation($composer2, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                            final MutableState<Boolean> mutableState3 = mutableState2;
                                            Object it$iv2 = $composer2.rememberedValue();
                                            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$1$2$1$1
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
                                                        GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$5(mutableState3, true);
                                                    }
                                                };
                                                $composer2.updateRememberedValue(value$iv2);
                                            } else {
                                                value$iv2 = it$iv2;
                                            }
                                            $composer2.endReplaceGroup();
                                            IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7560getLambda3$app_debug(), $composer2, 196614, 30);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, $composer, 54);
                                    final CoroutineScope coroutineScope = this.$scope;
                                    final MutableState<Boolean> mutableState3 = this.$isUpdating$delegate;
                                    final Context context2 = this.$context;
                                    PreferenceItemsKt.PreferenceItem(strStringResource, strInvoke$lambda$1, null, false, null, null, strStringResource2, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.GeneralDownloadPreferences.2.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$1$3$1, reason: invalid class name and collision with other inner class name */
                                        /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
                                        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                        @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$1$3$1", m210f = "GeneralDownloadPreferences.kt", m211i = {}, m212l = {234}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                                        static final class C46191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ Context $context;
                                            final /* synthetic */ MutableState<Boolean> $isUpdating$delegate;
                                            final /* synthetic */ MutableState<String> $ytdlpVersion$delegate;
                                            private /* synthetic */ Object L$0;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C46191(MutableState<Boolean> mutableState, MutableState<String> mutableState2, Context context, Continuation<? super C46191> continuation) {
                                                super(2, continuation);
                                                this.$isUpdating$delegate = mutableState;
                                                this.$ytdlpVersion$delegate = mutableState2;
                                                this.$context = context;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                C46191 c46191 = new C46191(this.$isUpdating$delegate, this.$ytdlpVersion$delegate, this.$context, continuation);
                                                c46191.L$0 = obj;
                                                return c46191;
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C46191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            /* JADX WARN: Code duplicated, block: B:23:0x0068  */
                                            /* JADX WARN: Code duplicated, block: B:26:0x008c  */
                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object $result) {
                                                Throwable th;
                                                C46191 c46191;
                                                MutableState<String> mutableState;
                                                Object objM7693constructorimpl;
                                                Throwable th2;
                                                Context context;
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0:
                                                        ResultKt.throwOnFailure($result);
                                                        MutableState<Boolean> mutableState2 = this.$isUpdating$delegate;
                                                        MutableState<String> mutableState3 = this.$ytdlpVersion$delegate;
                                                        try {
                                                            Result.Companion companion = Result.INSTANCE;
                                                            GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$8(mutableState2, true);
                                                            UpdateUtil updateUtil = UpdateUtil.INSTANCE;
                                                            this.L$0 = mutableState3;
                                                            this.label = 1;
                                                            if (updateUtil.updateYtDlp(this) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            c46191 = this;
                                                            mutableState = mutableState3;
                                                            C46171.invoke$lambda$2(mutableState, PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_VERSION, null, 1, null));
                                                            objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
                                                            th2 = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
                                                            if (th2 != null) {
                                                                th2.printStackTrace();
                                                                ToastUtil toastUtil = ToastUtil.INSTANCE;
                                                                String string = App.INSTANCE.getContext().getString(C3070R.string.yt_dlp_update_fail);
                                                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                                toastUtil.makeToastSuspend(string);
                                                            }
                                                            context = c46191.$context;
                                                            if (Result.m7700isSuccessimpl(objM7693constructorimpl)) {
                                                                ToastUtil.INSTANCE.makeToastSuspend(context.getString(C3070R.string.yt_dlp_up_to_date) + " (" + PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_VERSION, null, 1, null) + ")");
                                                            }
                                                            GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$8(c46191.$isUpdating$delegate, false);
                                                            return Unit.INSTANCE;
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            c46191 = this;
                                                            Result.Companion companion2 = Result.INSTANCE;
                                                            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
                                                        }
                                                        break;
                                                    case 1:
                                                        c46191 = this;
                                                        mutableState = (MutableState) c46191.L$0;
                                                        try {
                                                            ResultKt.throwOnFailure($result);
                                                            C46171.invoke$lambda$2(mutableState, PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_VERSION, null, 1, null));
                                                            objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
                                                            break;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            Result.Companion companion3 = Result.INSTANCE;
                                                            objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
                                                        }
                                                        th2 = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
                                                        if (th2 != null) {
                                                            th2.printStackTrace();
                                                            ToastUtil toastUtil2 = ToastUtil.INSTANCE;
                                                            String string2 = App.INSTANCE.getContext().getString(C3070R.string.yt_dlp_update_fail);
                                                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                                            toastUtil2.makeToastSuspend(string2);
                                                        }
                                                        context = c46191.$context;
                                                        if (Result.m7700isSuccessimpl(objM7693constructorimpl)) {
                                                            ToastUtil.INSTANCE.makeToastSuspend(context.getString(C3070R.string.yt_dlp_up_to_date) + " (" + PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_VERSION, null, 1, null) + ")");
                                                        }
                                                        GeneralDownloadPreferencesKt.GeneralDownloadPreferences$lambda$8(c46191.$isUpdating$delegate, false);
                                                        return Unit.INSTANCE;
                                                    default:
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                            }
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C46191(mutableState3, ytdlpVersion$delegate, context2, null), 3, null);
                                        }
                                    }, $composer, 113246208, 60);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer.skipToGroupEnd();
                            }
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$3, reason: invalid class name */
                        /* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
                        @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        static final class AnonymousClass3 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
                            final /* synthetic */ MutableState<Boolean> $isCustomCommandEnabled$delegate;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass3(MutableState<Boolean> mutableState) {
                                super(3);
                                this.$isCustomCommandEnabled$delegate = mutableState;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                                MutableState<Boolean> $this$getValue$iv = mutableState;
                                return $this$getValue$iv.getValue().booleanValue();
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                                mutableState.setValue(Boolean.valueOf(value));
                            }

                            public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                                Object value$iv;
                                Object value$iv2;
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer, "C298@14641L161,303@14848L46,304@14934L108,310@15243L173,303@14823L594:GeneralDownloadPreferences.kt#wlpkv4");
                                if (($changed & 81) != 16 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(438700154, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferences.<anonymous>.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:298)");
                                    }
                                    $composer.startReplaceGroup(-1602416674);
                                    ComposerKt.sourceInformation($composer, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                    Object it$iv = $composer.rememberedValue();
                                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                                        value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.THUMBNAIL)), null, 2, null);
                                        $composer.updateRememberedValue(value$iv);
                                    } else {
                                        value$iv = it$iv;
                                    }
                                    final MutableState thumbnailSwitch$delegate = (MutableState) value$iv;
                                    $composer.endReplaceGroup();
                                    String strStringResource = StringResources_androidKt.stringResource(C3070R.string.create_thumbnail, $composer, 0);
                                    String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.create_thumbnail_summary, $composer, 0);
                                    boolean z = !C38622.invoke$lambda$1(this.$isCustomCommandEnabled$delegate);
                                    ImageVector image = ImageKt.getImage(Icons.Outlined.INSTANCE);
                                    boolean zInvoke$lambda$1 = invoke$lambda$1(thumbnailSwitch$delegate);
                                    $composer.startReplaceGroup(-1602416072);
                                    ComposerKt.sourceInformation($composer, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                                    Object it$iv2 = $composer.rememberedValue();
                                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$GeneralDownloadPreferences$2$1$3$1$1
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
                                                GeneralDownloadPreferencesKt.C38622.AnonymousClass1.AnonymousClass3.invoke$lambda$2(thumbnailSwitch$delegate, !GeneralDownloadPreferencesKt.C38622.AnonymousClass1.AnonymousClass3.invoke$lambda$1(thumbnailSwitch$delegate));
                                                PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.THUMBNAIL, GeneralDownloadPreferencesKt.C38622.AnonymousClass1.AnonymousClass3.invoke$lambda$1(thumbnailSwitch$delegate));
                                            }
                                        };
                                        $composer.updateRememberedValue(value$iv2);
                                    } else {
                                        value$iv2 = it$iv2;
                                    }
                                    $composer.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, image, z, zInvoke$lambda$1, null, (Function0) value$iv2, $composer, 1572864, 32);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer.skipToGroupEnd();
                            }
                        }
                    }, $composer, 0, 254);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int GeneralDownloadPreferences$lambda$42(MutableIntState $ytdlpUpdateChannel$delegate) {
            MutableIntState $this$getValue$iv = $ytdlpUpdateChannel$delegate;
            return $this$getValue$iv.getIntValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean GeneralDownloadPreferences$lambda$44(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void GeneralDownloadPreferences$lambda$45(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long GeneralDownloadPreferences$lambda$47(MutableLongState $updateInterval$delegate) {
            MutableLongState $this$getValue$iv = $updateInterval$delegate;
            return $this$getValue$iv.getLongValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: DialogSingleChoiceItem-FHprtrg, reason: not valid java name */
        public static final void m7567DialogSingleChoiceItemFHprtrg(Modifier modifier, final String text, final boolean selected, final String label, long labelContainerColor, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
            Modifier modifier2;
            final long labelContainerColor2;
            Modifier.Companion modifier3;
            Modifier modifier4;
            long labelContainerColor3;
            Composer $composer2 = $composer.startRestartGroup(2089219190);
            ComposerKt.sourceInformation($composer2, "C(DialogSingleChoiceItem)P(2,5,4!1,1:c#ui.graphics.Color)576@27330L11,579@27384L1027:GeneralDownloadPreferences.kt#wlpkv4");
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
            if ((i & 2) != 0) {
                $dirty |= 48;
            } else if (($changed & 112) == 0) {
                $dirty |= $composer2.changed(text) ? 32 : 16;
            }
            if ((i & 4) != 0) {
                $dirty |= 384;
            } else if (($changed & 896) == 0) {
                $dirty |= $composer2.changed(selected) ? 256 : 128;
            }
            if ((i & 8) != 0) {
                $dirty |= 3072;
            } else if (($changed & 7168) == 0) {
                $dirty |= $composer2.changed(label) ? 2048 : 1024;
            }
            if ((57344 & $changed) == 0) {
                if ((i & 16) == 0) {
                    labelContainerColor2 = labelContainerColor;
                    int i3 = $composer2.changed(labelContainerColor2) ? 16384 : 8192;
                    $dirty |= i3;
                } else {
                    labelContainerColor2 = labelContainerColor;
                }
                $dirty |= i3;
            } else {
                labelContainerColor2 = labelContainerColor;
            }
            if ((i & 32) != 0) {
                $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            } else if ((458752 & $changed) == 0) {
                $dirty |= $composer2.changedInstance(function0) ? 131072 : 65536;
            }
            if ((374491 & $dirty) == 74898 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
                modifier4 = modifier2;
                labelContainerColor3 = labelContainerColor2;
            } else {
                $composer2.startDefaults();
                if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                    modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i & 16) != 0) {
                        $dirty &= -57345;
                        labelContainerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 16) != 0) {
                        $dirty &= -57345;
                    }
                    modifier3 = modifier2;
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2089219190, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.general.DialogSingleChoiceItem (GeneralDownloadPreferences.kt:578)");
                }
                Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(SelectableKt.m1117selectableXHw0xAI$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), selected, true, null, function0, 4, null), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(start, centerVertically, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierM870paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(constructor);
                } else {
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i5 = ((432 >> 6) & 112) | 6;
                RowScope $this$DialogSingleChoiceItem_FHprtrg_u24lambda_u2453 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1504021239, "C591@27752L119,595@27921L10,595@27881L61,596@27951L38,601@28133L272,597@27998L407:GeneralDownloadPreferences.kt#wlpkv4");
                RadioButtonKt.RadioButton(selected, function0, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogSingleChoiceItem$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                    }
                }), false, null, null, $composer2, (($dirty >> 6) & 14) | (($dirty >> 12) & 112), 56);
                TextKt.m2817Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodyLarge(), $composer2, ($dirty >> 3) & 14, 0, 65534);
                SpacerKt.Spacer(RowScope.CC.weight$default($this$DialogSingleChoiceItem_FHprtrg_u24lambda_u2453, Modifier.INSTANCE, 1.0f, false, 2, null), $composer2, 0);
                modifier4 = modifier3;
                SurfaceKt.m2666SurfaceT9BRK9s(PaddingKt.m872paddingqDBjuR0$default(modifier3, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 11, null), RoundedCornerShapeKt.getCircleShape(), labelContainerColor2, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1115148137, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogSingleChoiceItem$1$2
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
                        ComposerKt.sourceInformation($composer3, "C605@28272L11,606@28360L10,602@28147L248:GeneralDownloadPreferences.kt#wlpkv4");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1115148137, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.DialogSingleChoiceItem.<anonymous>.<anonymous> (GeneralDownloadPreferences.kt:602)");
                            }
                            TextKt.m2817Text4IGK_g(label, PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), ColorSchemeKt.m2081contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable), labelContainerColor2), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 48, 0, 65528);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, (($dirty >> 6) & 896) | 12582912, 120);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                labelContainerColor3 = labelContainerColor2;
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier4;
                final long j = labelContainerColor3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogSingleChoiceItem$2
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
                        GeneralDownloadPreferencesKt.m7567DialogSingleChoiceItemFHprtrg(modifier5, text, selected, label, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }

        /* JADX WARN: Code duplicated, block: B:84:0x0239  */
        /* JADX WARN: Code duplicated, block: B:85:0x023c  */
        /* JADX WARN: Code duplicated, block: B:96:0x0302  */
        public static final void DialogCheckBoxItem(Modifier modifier, final String text, final boolean checked, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
            Modifier modifier2;
            Object value$iv;
            Function0<ComposeUiNode> function0;
            boolean z;
            boolean invalid$iv;
            Object value$iv2;
            Modifier modifier3;
            Composer $composer2;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Composer $composer3 = $composer.startRestartGroup(-825836872);
            ComposerKt.sourceInformation($composer3, "C(DialogCheckBoxItem)P(1,3)625@28742L13,619@28559L622:GeneralDownloadPreferences.kt#wlpkv4");
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
                $dirty |= $composer3.changed(text) ? 32 : 16;
            }
            if ((i & 4) != 0) {
                $dirty |= 384;
            } else if (($changed & 896) == 0) {
                $dirty |= $composer3.changed(checked) ? 256 : 128;
            }
            if ((i & 8) != 0) {
                $dirty |= 3072;
            } else if (($changed & 7168) == 0) {
                $dirty |= $composer3.changedInstance(onClick) ? 2048 : 1024;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                modifier3 = modifier2;
                $composer2 = $composer3;
            } else {
                Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-825836872, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.general.DialogCheckBoxItem (GeneralDownloadPreferences.kt:618)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                $composer3.startReplaceGroup(692530010);
                ComposerKt.sourceInformation($composer3, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 7168) == 2048;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogCheckBoxItem$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean it) {
                            onClick.invoke();
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer3.endReplaceGroup();
                Modifier modifier$iv = PaddingKt.m870paddingVpY3zN4$default(ToggleableKt.m1122toggleableXHw0xAI$default(modifierFillMaxWidth$default, checked, true, null, (Function1) value$iv, 4, null), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null);
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv = (384 << 3) & 112;
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
                    $composer3.createNode(constructor);
                } else {
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    function0 = constructor;
                } else {
                    function0 = constructor;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i4 = ((384 >> 6) & 112) | 6;
                    RowScope $this$DialogCheckBoxItem_u24lambda_u2456 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -2126893047, "C632@29001L13,630@28884L141,637@29143L10,634@29034L141:GeneralDownloadPreferences.kt#wlpkv4");
                    Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogCheckBoxItem$2$1
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
                    $composer3.startReplaceGroup(-2126892930);
                    ComposerKt.sourceInformation($composer3, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                    if (($dirty2 & 7168) == 2048) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv = z;
                    value$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogCheckBoxItem$2$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean it) {
                                onClick.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceGroup();
                    CheckboxKt.Checkbox(checked, (Function1) value$iv2, modifierClearAndSetSemantics, false, null, null, $composer3, ($dirty2 >> 6) & 14, 56);
                    modifier3 = modifier4;
                    $composer2 = $composer3;
                    TextKt.m2817Text4IGK_g(text, RowScope.CC.weight$default($this$DialogCheckBoxItem_u24lambda_u2456, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty2 >> 3) & 14, 0, 65532);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i6 = ((384 >> 6) & 112) | 6;
                RowScope $this$DialogCheckBoxItem_u24lambda_u2457 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -2126893047, "C632@29001L13,630@28884L141,637@29143L10,634@29034L141:GeneralDownloadPreferences.kt#wlpkv4");
                Modifier modifierClearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogCheckBoxItem$2$1
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
                $composer3.startReplaceGroup(-2126892930);
                ComposerKt.sourceInformation($composer3, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                if (($dirty2 & 7168) == 2048) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv = z;
                value$iv2 = $composer3.rememberedValue();
                if (!invalid$iv) {
                }
                value$iv2 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DialogCheckBoxItem$2$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean it) {
                        onClick.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                $composer3.endReplaceGroup();
                CheckboxKt.Checkbox(checked, (Function1) value$iv2, modifierClearAndSetSemantics2, false, null, null, $composer3, ($dirty2 >> 6) & 14, 56);
                modifier3 = modifier4;
                $composer2 = $composer3;
                TextKt.m2817Text4IGK_g(text, RowScope.CC.weight$default($this$DialogCheckBoxItem_u24lambda_u2457, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty2 >> 3) & 14, 0, 65532);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
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
                final Modifier modifier5 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DialogCheckBoxItem.3
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
                        GeneralDownloadPreferencesKt.DialogCheckBoxItem(modifier5, text, checked, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void UpdateProgressIndicator(Composer $composer, final int $changed) {
            Composer $composer2 = $composer.startRestartGroup(845922797);
            ComposerKt.sourceInformation($composer2, "C(UpdateProgressIndicator)644@29241L160:GeneralDownloadPreferences.kt#wlpkv4");
            if ($changed != 0 || !$composer2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(845922797, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.UpdateProgressIndicator (GeneralDownloadPreferences.kt:643)");
                }
                ProgressIndicatorKt.m2488CircularProgressIndicatorLxG7B9w(PaddingKt.m868padding3ABfNKs(SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), C1979Dp.m6801constructorimpl(2)), 0L, 0.0f, 0L, 0, $composer2, 6, 30);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.UpdateProgressIndicator.1
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
                        GeneralDownloadPreferencesKt.UpdateProgressIndicator(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                    }
                });
            }
        }

        public static final void DownloadArchiveDialog(final String archiveFileContent, final Function0<Unit> onDismissRequest, final Function1<? super String, Unit> onSaveChangesCallback, Composer $composer, final int $changed) {
            Object value$iv;
            Composer $composer2;
            Intrinsics.checkNotNullParameter(archiveFileContent, "archiveFileContent");
            Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
            Intrinsics.checkNotNullParameter(onSaveChangesCallback, "onSaveChangesCallback");
            Composer $composer3 = $composer.startRestartGroup(-288969076);
            ComposerKt.sourceInformation($composer3, "C(DownloadArchiveDialog)659@29582L59,664@29720L182,669@29920L88,681@30252L588,663@29647L1199:GeneralDownloadPreferences.kt#wlpkv4");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer3.changed(archiveFileContent) ? 4 : 2;
            }
            if (($changed & 112) == 0) {
                $dirty |= $composer3.changedInstance(onDismissRequest) ? 32 : 16;
            }
            if (($changed & 896) == 0) {
                $dirty |= $composer3.changedInstance(onSaveChangesCallback) ? 256 : 128;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-288969076, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.general.DownloadArchiveDialog (GeneralDownloadPreferences.kt:658)");
                }
                $composer3.startReplaceGroup(344931194);
                ComposerKt.sourceInformation($composer3, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(archiveFileContent, null, 2, null);
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                final MutableState editContent$delegate = (MutableState) value$iv;
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
                DialogsKt.m7298LoopDialogOix01E0(null, onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-1212689561, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DownloadArchiveDialog.1
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
                        Object value$iv2;
                        ComposerKt.sourceInformation($composer4, "C665@29755L34,665@29791L101,665@29734L158:GeneralDownloadPreferences.kt#wlpkv4");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1212689561, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.DownloadArchiveDialog.<anonymous> (GeneralDownloadPreferences.kt:665)");
                        }
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.save, $composer4, 0);
                        $composer4.startReplaceGroup(593345644);
                        ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(onSaveChangesCallback) | $composer4.changed(onDismissRequest);
                        final Function1<String, Unit> function1 = onSaveChangesCallback;
                        final Function0<Unit> function0 = onDismissRequest;
                        final MutableState<String> mutableState = editContent$delegate;
                        Object it$iv2 = $composer4.rememberedValue();
                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DownloadArchiveDialog$1$1$1
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
                                    function1.invoke(GeneralDownloadPreferencesKt.DownloadArchiveDialog$lambda$58(mutableState));
                                    function0.invoke();
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.ConfirmButton(strStringResource, false, (Function0) value$iv2, $composer4, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-963411160, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DownloadArchiveDialog.2
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
                        Object value$iv2;
                        ComposerKt.sourceInformation($composer4, "C670@29948L50,670@29934L64:GeneralDownloadPreferences.kt#wlpkv4");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-963411160, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.DownloadArchiveDialog.<anonymous> (GeneralDownloadPreferences.kt:670)");
                        }
                        $composer4.startReplaceGroup(593345801);
                        ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(onDismissRequest);
                        final Function0<Unit> function0 = onDismissRequest;
                        Object it$iv2 = $composer4.rememberedValue();
                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DownloadArchiveDialog$2$1$1
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
                                    function0.invoke();
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv2, $composer4, 0, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7556getLambda14$app_debug(), ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7557getLambda15$app_debug(), ComposableLambdaKt.rememberComposableLambda(-215575957, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DownloadArchiveDialog.3
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
                        Function0<ComposeUiNode> function0;
                        ComposerKt.sourceInformation($composer4, "C682@30266L564:GeneralDownloadPreferences.kt#wlpkv4");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-215575957, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.DownloadArchiveDialog.<anonymous> (GeneralDownloadPreferences.kt:682)");
                            }
                            Modifier modifier$iv = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null);
                            final MutableState<String> mutableState = editContent$delegate;
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv = (6 << 3) & 112;
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
                            int i = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i2 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1353706160, "C686@30420L10,691@30655L28,688@30499L315:GeneralDownloadPreferences.kt#wlpkv4");
                            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyMedium();
                            TextStyle textStyle = bodyMedium.m6277copyp1EtxEg((16777213 & 1) != 0 ? bodyMedium.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodyMedium.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodyMedium.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodyMedium.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodyMedium.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodyMedium.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodyMedium.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodyMedium.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodyMedium.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodyMedium.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodyMedium.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodyMedium.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodyMedium.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodyMedium.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodyMedium.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodyMedium.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodyMedium.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodyMedium.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodyMedium.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodyMedium.platformStyle : null, (16777213 & 1048576) != 0 ? bodyMedium.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodyMedium.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodyMedium.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodyMedium.paragraphStyle.getTextMotion() : null);
                            String strDownloadArchiveDialog$lambda$58 = GeneralDownloadPreferencesKt.DownloadArchiveDialog$lambda$58(mutableState);
                            $composer4.startReplaceGroup(-1353705875);
                            ComposerKt.sourceInformation($composer4, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
                            Object value$iv2 = $composer4.rememberedValue();
                            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt$DownloadArchiveDialog$3$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String str) {
                                        Intrinsics.checkNotNullParameter(str, "str");
                                        mutableState.setValue(str);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv2);
                            }
                            $composer4.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strDownloadArchiveDialog$lambda$58, (Function1<? super String, Unit>) value$iv2, (Modifier) null, false, false, textStyle, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$GeneralDownloadPreferencesKt.INSTANCE.m7558getLambda16$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 10, 10, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1572912, 905969664, 0, 7602076);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
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
                }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty2 & 112) | 1797504, 0, 16257);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                $composer2 = $composer3;
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DownloadArchiveDialog.4
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
                        GeneralDownloadPreferencesKt.DownloadArchiveDialog(archiveFileContent, onDismissRequest, onSaveChangesCallback, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String DownloadArchiveDialog$lambda$58(MutableState<String> mutableState) {
            MutableState<String> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue();
        }

        public static final void DownloadArchiveDialogPreview(Composer $composer, final int $changed) {
            Composer $composer2 = $composer.startRestartGroup(734030870);
            ComposerKt.sourceInformation($composer2, "C(DownloadArchiveDialogPreview)709@31057L91:GeneralDownloadPreferences.kt#wlpkv4");
            if ($changed != 0 || !$composer2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(734030870, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.DownloadArchiveDialogPreview (GeneralDownloadPreferences.kt:706)");
                }
                List $this$DownloadArchiveDialogPreview_u24lambda_u2461 = CollectionsKt.createListBuilder();
                for (int i = 0; i < 20; i++) {
                    $this$DownloadArchiveDialogPreview_u24lambda_u2461.add("youtube IPf4AxotvNU");
                }
                Iterable strs = CollectionsKt.build($this$DownloadArchiveDialogPreview_u24lambda_u2461);
                Iterable $this$fold$iv = strs;
                String str = "";
                for (Object element$iv : $this$fold$iv) {
                    String text = (String) element$iv;
                    String acc = str;
                    str = acc + text + IOUtils.LINE_SEPARATOR_UNIX;
                }
                String str2 = str;
                DownloadArchiveDialog(str2, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DownloadArchiveDialogPreview.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                }, new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DownloadArchiveDialogPreview.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                        invoke2(str3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                }, $composer2, 432);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt.DownloadArchiveDialogPreview.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i2) {
                        GeneralDownloadPreferencesKt.DownloadArchiveDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                    }
                });
            }
        }
    }
