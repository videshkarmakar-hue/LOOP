package com.videshkarmakar.loop.ui.page.settings.directory;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.OpenInNewKt;
import androidx.compose.material.icons.filled.SdCardAlertKt;
import androidx.compose.material.icons.outlined.FolderDeleteKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.FolderOpenKt;
import androidx.compose.material.icons.outlined.FolderSpecialKt;
import androidx.compose.material.icons.outlined.LibraryMusicKt;
import androidx.compose.material.icons.outlined.SdCardKt;
import androidx.compose.material.icons.outlined.SnippetFolderKt;
import androidx.compose.material.icons.outlined.TabUnselectedKt;
import androidx.compose.material.icons.outlined.VideoLibraryKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.google.accompanist.permissions.PermissionState;
import com.google.accompanist.permissions.PermissionStateKt;
import com.google.accompanist.permissions.PermissionStatus;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.ChipsKt;
import com.videshkarmakar.loop.ui.component.DialogItemsKt;
import com.videshkarmakar.loop.ui.component.DialogsKt;
import com.videshkarmakar.loop.ui.component.IconButtonsKt;
import com.videshkarmakar.loop.ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.FileUtil;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: DownloadDirectoryPreferences.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0007¢\u0006\u0002\u0010\b\u001aM\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020#X\u008a\u008e\u0002"}, d2 = {"validDirectoryRegex", "", "ytdlpFilesystemReference", "ytdlpOutputTemplateReference", "DownloadDirectoryPreferences", "", "onNavigateBack", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "OutputTemplateDialog", "selectedTemplate", "customTemplate", "onDismissRequest", "onConfirm", "Lkotlin/Function2;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "isValidDirectory", "", "app_debug", "showSubdirectoryDialog", "isPrivateDirectoryEnabled", "videoDirectoryText", "audioDirectoryText", "sdcardUri", "customCommandDirectory", "sdcardDownload", "showClearTempDialog", "showCustomCommandDirectoryDialog", "editingDirectory", "Lcom/videshkarmakar/loop/ui/page/settings/directory/Directory;", "isCustomCommandEnabled", "showOutputTemplateDialog", "outputTemplate", "editingTemplate", "selectedItem", "", "error"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadDirectoryPreferencesKt {
    private static final String validDirectoryRegex = "/storage/emulated/0/(Download|Documents)";
    private static final String ytdlpFilesystemReference = "https://github.com/yt-dlp/yt-dlp#filesystem-options";
    private static final String ytdlpOutputTemplateReference = "https://github.com/yt-dlp/yt-dlp#output-template";

    private static final boolean isValidDirectory(String $this$isValidDirectory) {
        if ($this$isValidDirectory.length() == 0) {
            return true;
        }
        return new Regex(validDirectoryRegex).containsMatchIn($this$isValidDirectory);
    }

    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object, java.lang.String] */
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
    public static final void DownloadDirectoryPreferences(final Function0<Unit> onNavigateBack, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv$iv2;
        Object value$iv7;
        Object value$iv8;
        Object value$iv9;
        Object value$iv10;
        Object value$iv11;
        Object value$iv12;
        Composer $composer2;
        String str;
        ?? r11;
        int i;
        int i2;
        Object value$iv13;
        Object value$iv14;
        final MutableState showOutputTemplateDialog$delegate;
        Composer $composer3;
        Composer $composer4;
        Object value$iv15;
        Object value$iv16;
        Object value$iv17;
        Object value$iv18;
        final MutableState showClearTempDialog$delegate;
        Object value$iv19;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer $composer5 = $composer.startRestartGroup(-1947063063);
        ComposerKt.sourceInformation($composer5, "C(DownloadDirectoryPreferences)135@6534L7,136@6591L7,137@6615L24,139@6725L24,138@6683L102,142@6817L7,143@6853L32,145@6921L34,148@6995L83,152@7110L148,155@7289L148,158@7459L63,161@7575L11,163@7614L81,167@7728L34,168@7807L34,171@7872L44,173@7952L102,179@8092L34,182@8164L80,196@9019L836,188@8529L1326,239@10490L438,233@10317L154,252@10930L6527,229@10163L7294,435@19034L94,438@19155L101,514@22482L34,513@22424L493:DownloadDirectoryPreferences.kt#rl3ivv");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer5.changedInstance(onNavigateBack) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer5.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1947063063, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences (DownloadDirectoryPreferences.kt:133)");
            }
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer5.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final UriHandler uriHandler = (UriHandler) objConsume;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer5.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer5, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer5.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5));
                $composer5.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer5, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer5, (TopAppBarDefaults.$stable << 12) | 48, 12);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer5.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final Context context = (Context) objConsume3;
            $composer5.startReplaceGroup(1881035401);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SnackbarHostState();
                $composer5.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) value$iv;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881035469);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer5.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState showSubdirectoryDialog$delegate = (MutableState) value$iv2;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881035543);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv3 = $composer5.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.PRIVATE_DIRECTORY)), null, 2, null);
                $composer5.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState isPrivateDirectoryEnabled$delegate = (MutableState) value$iv3;
            $composer5.endReplaceGroup();
            boolean zDownloadDirectoryPreferences$lambda$5 = DownloadDirectoryPreferences$lambda$5(isPrivateDirectoryEnabled$delegate);
            $composer5.startReplaceGroup(1881035658);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            boolean invalid$iv = $composer5.changed(zDownloadDirectoryPreferences$lambda$5);
            Object it$iv4 = $composer5.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(!DownloadDirectoryPreferences$lambda$5(isPrivateDirectoryEnabled$delegate) ? App.INSTANCE.getVideoDownloadDir() : App.INSTANCE.getPrivateDownloadDir(), null, 2, null);
                $composer5.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final MutableState videoDirectoryText$delegate = (MutableState) value$iv4;
            $composer5.endReplaceGroup();
            boolean zDownloadDirectoryPreferences$lambda$6 = DownloadDirectoryPreferences$lambda$5(isPrivateDirectoryEnabled$delegate);
            $composer5.startReplaceGroup(1881035837);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            boolean invalid$iv2 = $composer5.changed(zDownloadDirectoryPreferences$lambda$6);
            Object it$iv5 = $composer5.rememberedValue();
            if (invalid$iv2 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(!DownloadDirectoryPreferences$lambda$5(isPrivateDirectoryEnabled$delegate) ? App.INSTANCE.getAudioDownloadDir() : App.INSTANCE.getPrivateDownloadDir(), null, 2, null);
                $composer5.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableState audioDirectoryText$delegate = (MutableState) value$iv5;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881036007);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv6 = $composer5.rememberedValue();
            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SDCARD_URI, null, 1, null), null, 2, null);
                $composer5.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            final MutableState sdcardUri$delegate = (MutableState) value$iv6;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(275724887);
            ComposerKt.sourceInformation($composer5, "CC16@579L45:Ext.kt#x6o9ax");
            $composer5.startReplaceGroup(105103929);
            ComposerKt.sourceInformation($composer5, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv2 = $composer5.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.COMMAND_DIRECTORY, null, 1, null), null, 2, null);
                $composer5.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            final MutableState customCommandDirectory$delegate = (MutableState) value$iv$iv2;
            $composer5.endReplaceGroup();
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881036162);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv7 = $composer5.rememberedValue();
            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.SDCARD_DOWNLOAD)), null, 2, null);
                $composer5.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            final MutableState sdcardDownload$delegate = (MutableState) value$iv7;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881036276);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv8 = $composer5.rememberedValue();
            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer5.updateRememberedValue(value$iv8);
            } else {
                value$iv8 = it$iv8;
            }
            final MutableState showClearTempDialog$delegate2 = (MutableState) value$iv8;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881036355);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv9 = $composer5.rememberedValue();
            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer5.updateRememberedValue(value$iv9);
            } else {
                value$iv9 = it$iv9;
            }
            final MutableState showCustomCommandDirectoryDialog$delegate = (MutableState) value$iv9;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881036420);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv10 = $composer5.rememberedValue();
            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                value$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Directory.VIDEO, null, 2, null);
                $composer5.updateRememberedValue(value$iv10);
            } else {
                value$iv10 = it$iv10;
            }
            final MutableState editingDirectory$delegate = (MutableState) value$iv10;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881036500);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object value$iv20 = $composer5.rememberedValue();
            if (value$iv20 == Composer.INSTANCE.getEmpty()) {
                value$iv20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CUSTOM_COMMAND)), null, 2, null);
                $composer5.updateRememberedValue(value$iv20);
            }
            final MutableState isCustomCommandEnabled$delegate = (MutableState) value$iv20;
            $composer5.endReplaceGroup();
            $composer5.startReplaceGroup(1881036640);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv11 = $composer5.rememberedValue();
            if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer5.updateRememberedValue(value$iv11);
            } else {
                value$iv11 = it$iv11;
            }
            final MutableState showOutputTemplateDialog$delegate2 = (MutableState) value$iv11;
            $composer5.endReplaceGroup();
            final PermissionState storagePermission = PermissionStateKt.rememberPermissionState("android.permission.WRITE_EXTERNAL_STORAGE", null, $composer5, 6, 2);
            final boolean showDirectoryAlert = (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager() || (isValidDirectory(DownloadDirectoryPreferences$lambda$11(audioDirectoryText$delegate)) && isValidDirectory(DownloadDirectoryPreferences$lambda$8(videoDirectoryText$delegate)) && isValidDirectory(DownloadDirectoryPreferences$lambda$16(customCommandDirectory$delegate)))) ? false : true;
            ActivityResultContracts.OpenDocumentTree openDocumentTree = new ActivityResultContracts.OpenDocumentTree() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$launcher$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.activity.result.contract.ActivityResultContracts.OpenDocumentTree, androidx.activity.result.contract.ActivityResultContract
                public Intent createIntent(Context context2, Uri input) {
                    Intrinsics.checkNotNullParameter(context2, "context");
                    Intent $this$createIntent_u24lambda_u240 = super.createIntent(context2, input);
                    $this$createIntent_u24lambda_u240.setFlags(67);
                    return $this$createIntent_u24lambda_u240;
                }
            };
            $composer5.startReplaceGroup(1881037567);
            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            boolean invalid$iv3 = $composer5.changed(audioDirectoryText$delegate) | $composer5.changed(videoDirectoryText$delegate) | $composer5.changed(customCommandDirectory$delegate);
            Object it$iv12 = $composer5.rememberedValue();
            if (invalid$iv3 || it$iv12 == Composer.INSTANCE.getEmpty()) {
                value$iv12 = new Function1<Uri, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$launcher$2$1

                    /* JADX INFO: compiled from: DownloadDirectoryPreferences.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[Directory.values().length];
                            try {
                                iArr[Directory.AUDIO.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[Directory.VIDEO.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                iArr[Directory.SDCARD.ordinal()] = 3;
                            } catch (NoSuchFieldError e3) {
                            }
                            try {
                                iArr[Directory.CUSTOM_COMMAND.ordinal()] = 4;
                            } catch (NoSuchFieldError e4) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

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
                    public final void invoke2(Uri it) {
                        if (it != null) {
                            MutableState<Directory> mutableState = editingDirectory$delegate;
                            MutableState<String> mutableState2 = audioDirectoryText$delegate;
                            MutableState<String> mutableState3 = videoDirectoryText$delegate;
                            MutableState<String> mutableState4 = sdcardUri$delegate;
                            MutableState<String> mutableState5 = customCommandDirectory$delegate;
                            App.INSTANCE.updateDownloadDir(it, DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$28(mutableState));
                            if (DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$28(mutableState) != Directory.SDCARD) {
                                String path = FileUtil.INSTANCE.getRealPath(it);
                                switch (WhenMappings.$EnumSwitchMapping$0[DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$28(mutableState).ordinal()]) {
                                    case 1:
                                        mutableState2.setValue(path);
                                        break;
                                    case 2:
                                        mutableState3.setValue(path);
                                        break;
                                    case 3:
                                        String string = it.toString();
                                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                        mutableState4.setValue(string);
                                        break;
                                    case 4:
                                        mutableState5.setValue(path);
                                        break;
                                }
                            }
                        }
                    }
                };
                $composer5.updateRememberedValue(value$iv12);
            } else {
                value$iv12 = it$iv12;
            }
            $composer5.endReplaceGroup();
            final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(openDocumentTree, (Function1) value$iv12, $composer5, 0);
            ScaffoldKt.m2282ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(677141677, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer6, int $changed2) {
                    ComposerKt.sourceInformation($composer6, "C246@10756L115,240@10504L414:DownloadDirectoryPreferences.kt#rl3ivv");
                    if (($changed2 & 11) != 2 || !$composer6.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(677141677, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:240)");
                        }
                        Function2<Composer, Integer, Unit> function2M7335getLambda1$app_debug = ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7335getLambda1$app_debug();
                        final Function0<Unit> function0 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7335getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-214589720, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer7, int $changed3) {
                                Object value$iv21;
                                ComposerKt.sourceInformation($composer7, "C247@10789L64,247@10778L75:DownloadDirectoryPreferences.kt#rl3ivv");
                                if (($changed3 & 11) == 2 && $composer7.getSkipping()) {
                                    $composer7.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-214589720, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:247)");
                                }
                                $composer7.startReplaceGroup(-2013056853);
                                ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                boolean invalid$iv4 = $composer7.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv13 = $composer7.rememberedValue();
                                if (invalid$iv4 || it$iv13 == Composer.INSTANCE.getEmpty()) {
                                    value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$1$1$1$1
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
                                    $composer7.updateRememberedValue(value$iv21);
                                } else {
                                    value$iv21 = it$iv13;
                                }
                                $composer7.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv21, $composer7, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer6, 54), null, scrollBehavior, $composer6, 390, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer6.skipToGroupEnd();
                }
            }, $composer5, 54), null, ComposableLambdaKt.rememberComposableLambda(-1092329937, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer6, int $changed2) {
                    ComposerKt.sourceInformation($composer6, "C234@10331L130:DownloadDirectoryPreferences.kt#rl3ivv");
                    if (($changed2 & 11) != 2 || !$composer6.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1092329937, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:234)");
                        }
                        SnackbarHostKt.SnackbarHost(snackbarHostState, WindowInsetsPadding_androidKt.systemBarsPadding(Modifier.INSTANCE), null, $composer6, 6, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer6.skipToGroupEnd();
                }
            }, $composer5, 54), null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-322733640, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer $composer6, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer6, "C253@10940L6511:DownloadDirectoryPreferences.kt#rl3ivv");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer6.changed(it) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) != 18 || !$composer6.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-322733640, $dirty4, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:253)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                        final boolean z = showDirectoryAlert;
                        final MutableState<Boolean> mutableState = isCustomCommandEnabled$delegate;
                        final Context context2 = context;
                        final MutableState<String> mutableState2 = videoDirectoryText$delegate;
                        final MutableState<Boolean> mutableState3 = isPrivateDirectoryEnabled$delegate;
                        final MutableState<Boolean> mutableState4 = sdcardDownload$delegate;
                        final PermissionState permissionState = storagePermission;
                        final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher = launcher;
                        final MutableState<Directory> mutableState5 = editingDirectory$delegate;
                        final MutableState<String> mutableState6 = audioDirectoryText$delegate;
                        final MutableState<String> mutableState7 = customCommandDirectory$delegate;
                        final MutableState<Boolean> mutableState8 = showCustomCommandDirectoryDialog$delegate;
                        final MutableState<String> mutableState9 = sdcardUri$delegate;
                        final MutableState<Boolean> mutableState10 = showSubdirectoryDialog$delegate;
                        final MutableState<Boolean> mutableState11 = showOutputTemplateDialog$delegate2;
                        final MutableState<Boolean> mutableState12 = showClearTempDialog$delegate2;
                        LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1
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
                                if (DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$31(mutableState)) {
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7343getLambda2$app_debug(), 3, null);
                                }
                                if (z) {
                                    final Context context3 = context2;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1937886446, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer7, "C263@11302L41,264@11383L46,262@11249L843:DownloadDirectoryPreferences.kt#rl3ivv");
                                            if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1937886446, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:262)");
                                                }
                                                String strStringResource = StringResources_androidKt.stringResource(R.string.permission_issue, $composer7, 0);
                                                String strStringResource2 = StringResources_androidKt.stringResource(R.string.permission_issue_desc, $composer7, 0);
                                                ImageVector sdCardAlert = SdCardAlertKt.getSdCardAlert(Icons.Filled.INSTANCE);
                                                final Context context4 = context3;
                                                PreferenceItemsKt.m7177PreferencesHintCardjB83MbM(strStringResource, strStringResource2, sdCardAlert, 0L, 0L, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.1.1
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
                                                        if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
                                                            Intent $this$invoke_u24lambda_u240 = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                                                            Context context5 = context4;
                                                            $this$invoke_u24lambda_u240.setFlags(268435456);
                                                            $this$invoke_u24lambda_u240.setData(Uri.parse("package:" + context5.getPackageName()));
                                                            if ($this$invoke_u24lambda_u240.resolveActivity(context5.getPackageManager()) != null) {
                                                                context5.startActivity($this$invoke_u24lambda_u240);
                                                            }
                                                        }
                                                    }
                                                }, $composer7, 0, 24);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer7.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7344getLambda3$app_debug(), 3, null);
                                if (!DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$31(mutableState)) {
                                    final MutableState<String> mutableState13 = mutableState2;
                                    final MutableState<Boolean> mutableState14 = mutableState3;
                                    final MutableState<Boolean> mutableState15 = mutableState4;
                                    final PermissionState permissionState2 = permissionState;
                                    final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher2 = managedActivityResultLauncher;
                                    final MutableState<Directory> mutableState16 = mutableState5;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(483867313, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer7, "C283@12363L45,282@12315L412:DownloadDirectoryPreferences.kt#rl3ivv");
                                            if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(483867313, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:282)");
                                                }
                                                String strStringResource = StringResources_androidKt.stringResource(R.string.video_directory, $composer7, 0);
                                                String strDownloadDirectoryPreferences$lambda$8 = DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$8(mutableState13);
                                                boolean z2 = (DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$5(mutableState14) || DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState15)) ? false : true;
                                                ImageVector videoLibrary = VideoLibraryKt.getVideoLibrary(Icons.Outlined.INSTANCE);
                                                final PermissionState permissionState3 = permissionState2;
                                                final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher3 = managedActivityResultLauncher2;
                                                final MutableState<Directory> mutableState17 = mutableState16;
                                                PreferenceItemsKt.PreferenceItem(strStringResource, strDownloadDirectoryPreferences$lambda$8, videoLibrary, z2, null, null, null, null, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.2.1
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
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$openDirectoryChooser(permissionState3, managedActivityResultLauncher3, mutableState17, Directory.VIDEO);
                                                    }
                                                }, $composer7, 0, 496);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer7.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableState<String> mutableState17 = mutableState6;
                                    final MutableState<Boolean> mutableState18 = mutableState3;
                                    final MutableState<Boolean> mutableState19 = mutableState4;
                                    final PermissionState permissionState3 = permissionState;
                                    final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher3 = managedActivityResultLauncher;
                                    final MutableState<Directory> mutableState20 = mutableState5;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1135268518, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer7, "C293@12837L45,292@12789L412:DownloadDirectoryPreferences.kt#rl3ivv");
                                            if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1135268518, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:292)");
                                                }
                                                String strStringResource = StringResources_androidKt.stringResource(R.string.audio_directory, $composer7, 0);
                                                String strDownloadDirectoryPreferences$lambda$11 = DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$11(mutableState17);
                                                boolean z2 = (DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$5(mutableState18) || DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState19)) ? false : true;
                                                ImageVector libraryMusic = LibraryMusicKt.getLibraryMusic(Icons.Outlined.INSTANCE);
                                                final PermissionState permissionState4 = permissionState3;
                                                final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher4 = managedActivityResultLauncher3;
                                                final MutableState<Directory> mutableState21 = mutableState20;
                                                PreferenceItemsKt.PreferenceItem(strStringResource, strDownloadDirectoryPreferences$lambda$11, libraryMusic, z2, null, null, null, null, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.3.1
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
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$openDirectoryChooser(permissionState4, managedActivityResultLauncher4, mutableState21, Directory.AUDIO);
                                                    }
                                                }, $composer7, 0, 496);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer7.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                                final MutableState<String> mutableState21 = mutableState7;
                                final MutableState<Boolean> mutableState22 = mutableState8;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1451872307, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                        Object value$iv21;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer7, "C304@13313L54,307@13555L79,303@13269L365:DownloadDirectoryPreferences.kt#rl3ivv");
                                        if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1451872307, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:303)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.custom_command_directory, $composer7, 0);
                                            $composer7.startReplaceGroup(1060545561);
                                            ComposerKt.sourceInformation($composer7, "*305@13436L48");
                                            String strDownloadDirectoryPreferences$lambda$16 = DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$16(mutableState21);
                                            if (strDownloadDirectoryPreferences$lambda$16.length() == 0) {
                                                strDownloadDirectoryPreferences$lambda$16 = StringResources_androidKt.stringResource(R.string.set_directory_desc, $composer7, 0);
                                            }
                                            String str2 = strDownloadDirectoryPreferences$lambda$16;
                                            $composer7.endReplaceGroup();
                                            ImageVector folder = FolderKt.getFolder(Icons.Outlined.INSTANCE);
                                            $composer7.startReplaceGroup(1060545690);
                                            ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                            final MutableState<Boolean> mutableState23 = mutableState22;
                                            Object it$iv13 = $composer7.rememberedValue();
                                            if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                                                value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$3$1$4$2$1
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
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$26(mutableState23, true);
                                                    }
                                                };
                                                $composer7.updateRememberedValue(value$iv21);
                                            } else {
                                                value$iv21 = it$iv13;
                                            }
                                            $composer7.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceItem(strStringResource, str2, folder, false, null, null, null, null, null, (Function0) value$iv21, $composer7, 805306368, 504);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer7.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableState<String> mutableState23 = mutableState9;
                                final MutableState<Boolean> mutableState24 = mutableState4;
                                final MutableState<Boolean> mutableState25 = mutableState;
                                final PermissionState permissionState4 = permissionState;
                                final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher4 = managedActivityResultLauncher;
                                final MutableState<Directory> mutableState26 = mutableState5;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(969881452, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer7, "C313@13741L46,312@13684L947:DownloadDirectoryPreferences.kt#rl3ivv");
                                        if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(969881452, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:312)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.sdcard_directory, $composer7, 0);
                                            $composer7.startReplaceGroup(1060545968);
                                            ComposerKt.sourceInformation($composer7, "*314@13843L48");
                                            String strDownloadDirectoryPreferences$lambda$14 = DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$14(mutableState23);
                                            if (strDownloadDirectoryPreferences$lambda$14.length() == 0) {
                                                strDownloadDirectoryPreferences$lambda$14 = StringResources_androidKt.stringResource(R.string.set_directory_desc, $composer7, 0);
                                            }
                                            String str2 = strDownloadDirectoryPreferences$lambda$14;
                                            $composer7.endReplaceGroup();
                                            boolean zDownloadDirectoryPreferences$lambda$19 = DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState24);
                                            boolean z2 = !DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$31(mutableState25);
                                            boolean zDownloadDirectoryPreferences$lambda$31 = true ^ DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$31(mutableState25);
                                            ImageVector sdCard = SdCardKt.getSdCard(Icons.Outlined.INSTANCE);
                                            final PermissionState permissionState5 = permissionState4;
                                            final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher5 = managedActivityResultLauncher4;
                                            final MutableState<Directory> mutableState27 = mutableState26;
                                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.5.2
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
                                                    DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$openDirectoryChooser(permissionState5, managedActivityResultLauncher5, mutableState27, Directory.SDCARD);
                                                }
                                            };
                                            final MutableState<String> mutableState28 = mutableState23;
                                            final MutableState<Boolean> mutableState29 = mutableState24;
                                            final PermissionState permissionState6 = permissionState4;
                                            final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher6 = managedActivityResultLauncher4;
                                            final MutableState<Directory> mutableState30 = mutableState26;
                                            PreferenceItemsKt.PreferenceSwitchWithDivider(strStringResource, str2, sdCard, z2, zDownloadDirectoryPreferences$lambda$31, zDownloadDirectoryPreferences$lambda$19, null, function0, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.5.3
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
                                                    if (DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$14(mutableState28).length() > 0) {
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$20(mutableState29, true ^ DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState29));
                                                        PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.SDCARD_DOWNLOAD, DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState29));
                                                    } else {
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$openDirectoryChooser(permissionState6, managedActivityResultLauncher6, mutableState30, Directory.SDCARD);
                                                    }
                                                }
                                            }, $composer7, 0, 64);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer7.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableState<Boolean> mutableState27 = mutableState;
                                final MutableState<Boolean> mutableState28 = mutableState4;
                                final MutableState<Boolean> mutableState29 = mutableState10;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-903332085, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                        Object value$iv21;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer7, "C334@14725L42,335@14803L47,338@15001L69,333@14681L389:DownloadDirectoryPreferences.kt#rl3ivv");
                                        if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-903332085, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:333)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.subdirectory, $composer7, 0);
                                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.subdirectory_desc, $composer7, 0);
                                            ImageVector snippetFolder = SnippetFolderKt.getSnippetFolder(Icons.Outlined.INSTANCE);
                                            boolean z2 = (DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$31(mutableState27) || DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState28)) ? false : true;
                                            $composer7.startReplaceGroup(1060547136);
                                            ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                            final MutableState<Boolean> mutableState30 = mutableState29;
                                            Object it$iv13 = $composer7.rememberedValue();
                                            if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                                                value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$3$1$6$1$1
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
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$3(mutableState30, true);
                                                    }
                                                };
                                                $composer7.updateRememberedValue(value$iv21);
                                            } else {
                                                value$iv21 = it$iv13;
                                            }
                                            $composer7.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceItem(strStringResource, strStringResource2, snippetFolder, z2, null, null, null, null, null, (Function0) value$iv21, $composer7, 805306368, 496);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer7.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7345getLambda4$app_debug(), 3, null);
                                final boolean z2 = z;
                                final MutableState<Boolean> mutableState30 = mutableState4;
                                final MutableState<Boolean> mutableState31 = mutableState;
                                final MutableState<Boolean> mutableState32 = mutableState3;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-354791863, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                        Object value$iv21;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer7, "C347@15275L47,348@15358L93,354@15696L199,346@15229L684:DownloadDirectoryPreferences.kt#rl3ivv");
                                        if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-354791863, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:346)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.private_directory, $composer7, 0);
                                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.private_directory_desc, $composer7, 0);
                                            ImageVector tabUnselected = TabUnselectedKt.getTabUnselected(Icons.Outlined.INSTANCE);
                                            boolean z3 = (z2 || DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState30) || DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$31(mutableState31)) ? false : true;
                                            boolean zDownloadDirectoryPreferences$lambda$7 = DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$5(mutableState32);
                                            $composer7.startReplaceGroup(1060547831);
                                            ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                            final MutableState<Boolean> mutableState33 = mutableState32;
                                            Object it$iv13 = $composer7.rememberedValue();
                                            if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                                                value$iv21 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$3$1$7$1$1
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
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$6(mutableState33, !DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$5(mutableState33));
                                                        PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.PRIVATE_DIRECTORY, DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$5(mutableState33));
                                                    }
                                                };
                                                $composer7.updateRememberedValue(value$iv21);
                                            } else {
                                                value$iv21 = it$iv13;
                                            }
                                            $composer7.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, tabUnselected, z3, zDownloadDirectoryPreferences$lambda$7, null, (Function0) value$iv21, $composer7, 1572864, 32);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer7.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7346getLambda5$app_debug(), 3, null);
                                final MutableState<Boolean> mutableState33 = mutableState;
                                final MutableState<Boolean> mutableState34 = mutableState4;
                                final MutableState<Boolean> mutableState35 = mutableState11;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(193748359, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.8
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                        Object value$iv21;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer7, "C364@16105L40,365@16181L50,368@16394L35,364@16082L365:DownloadDirectoryPreferences.kt#rl3ivv");
                                        if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(193748359, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:364)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.output_template, $composer7, 0);
                                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.output_template_desc, $composer7, 0);
                                            ImageVector folderSpecial = FolderSpecialKt.getFolderSpecial(Icons.Outlined.INSTANCE);
                                            boolean z3 = (DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$31(mutableState33) || DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$19(mutableState34)) ? false : true;
                                            $composer7.startReplaceGroup(1060548529);
                                            ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                            final MutableState<Boolean> mutableState36 = mutableState35;
                                            Object it$iv13 = $composer7.rememberedValue();
                                            if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                                                value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$3$1$8$1$1
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
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$34(mutableState36, true);
                                                    }
                                                };
                                                $composer7.updateRememberedValue(value$iv21);
                                            } else {
                                                value$iv21 = it$iv13;
                                            }
                                            $composer7.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceItem(strStringResource, strStringResource2, folderSpecial, z3, null, null, null, null, null, (Function0) value$iv21, $composer7, 805306368, 496);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer7.skipToGroupEnd();
                                    }
                                }), 3, null);
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7347getLambda6$app_debug(), 3, null);
                                final MutableState<Boolean> mutableState36 = mutableState12;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(742288581, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.3.1.9
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer7, int $changed3) {
                                        Object value$iv21;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer7, "C385@17121L41,386@17198L92,390@17378L30,384@17077L350:DownloadDirectoryPreferences.kt#rl3ivv");
                                        if (($changed3 & 81) != 16 || !$composer7.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(742288581, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:384)");
                                            }
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.clear_temp_files, $composer7, 0);
                                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.clear_temp_files_desc, $composer7, 0);
                                            ImageVector folderDelete = FolderDeleteKt.getFolderDelete(Icons.Outlined.INSTANCE);
                                            $composer7.startReplaceGroup(1060549513);
                                            ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                            final MutableState<Boolean> mutableState37 = mutableState36;
                                            Object it$iv13 = $composer7.rememberedValue();
                                            if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                                                value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$3$1$9$1$1
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
                                                        DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$23(mutableState37, true);
                                                    }
                                                };
                                                $composer7.updateRememberedValue(value$iv21);
                                            } else {
                                                value$iv21 = it$iv13;
                                            }
                                            $composer7.endReplaceGroup();
                                            PreferenceItemsKt.PreferenceItem(strStringResource, strStringResource2, folderDelete, false, null, null, null, null, null, (Function0) value$iv21, $composer7, 805306368, 504);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer7.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }
                        }, $composer6, 0, 254);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer6.skipToGroupEnd();
                }
            }, $composer5, 54), $composer5, 805309488, 500);
            $composer5.startReplaceGroup(1881046012);
            ComposerKt.sourceInformation($composer5, "399@17543L31,414@18165L835,402@17746L77,398@17499L1502");
            if (!DownloadDirectoryPreferences$lambda$22(showClearTempDialog$delegate2)) {
                $composer2 = $composer5;
                str = "CC(remember):DownloadDirectoryPreferences.kt#9igjgp";
            } else {
                $composer5.startReplaceGroup(1881046091);
                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                Object it$iv13 = $composer5.rememberedValue();
                if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                    showClearTempDialog$delegate = showClearTempDialog$delegate2;
                    value$iv19 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$4$1
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
                            DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$23(showClearTempDialog$delegate, false);
                        }
                    };
                    $composer5.updateRememberedValue(value$iv19);
                } else {
                    showClearTempDialog$delegate = showClearTempDialog$delegate2;
                    value$iv19 = it$iv13;
                }
                $composer5.endReplaceGroup();
                str = "CC(remember):DownloadDirectoryPreferences.kt#9igjgp";
                $composer2 = $composer5;
                AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0((Function0) value$iv19, ComposableLambdaKt.rememberComposableLambda(-1466198084, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer6, int $changed2) {
                        ComposerKt.sourceInformation($composer6, "C415@18183L803:DownloadDirectoryPreferences.kt#rl3ivv");
                        if (($changed2 & 11) != 2 || !$composer6.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1466198084, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:415)");
                            }
                            final CoroutineScope coroutineScope = scope;
                            final MutableState<Boolean> mutableState = showClearTempDialog$delegate;
                            final Context context2 = context;
                            final SnackbarHostState snackbarHostState2 = snackbarHostState;
                            ButtonsKt.ConfirmButton(null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$5$1$1, reason: invalid class name and collision with other inner class name */
                                /* JADX INFO: compiled from: DownloadDirectoryPreferences.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$5$1$1", f = "DownloadDirectoryPreferences.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
                                static final class C02271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ Context $context;
                                    final /* synthetic */ SnackbarHostState $snackbarHostState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C02271(Context context, SnackbarHostState snackbarHostState, Continuation<? super C02271> continuation) {
                                        super(2, continuation);
                                        this.$context = context;
                                        this.$snackbarHostState = snackbarHostState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C02271(this.$context, this.$snackbarHostState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C02271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                FileUtil.INSTANCE.clearTempFiles(FileUtil.INSTANCE.getConfigDirectory(this.$context));
                                                FileUtil $this$invokeSuspend_u24lambda_u240 = FileUtil.INSTANCE;
                                                Context context = this.$context;
                                                int count = $this$invokeSuspend_u24lambda_u240.clearTempFiles($this$invokeSuspend_u24lambda_u240.getExternalTempDir()) + $this$invokeSuspend_u24lambda_u240.clearTempFiles($this$invokeSuspend_u24lambda_u240.getSdcardTempDir(context, null)) + $this$invokeSuspend_u24lambda_u240.clearTempFiles($this$invokeSuspend_u24lambda_u240.getInternalTempDir(context));
                                                this.label = 1;
                                                if (BuildersKt.withContext(Dispatchers.getMain(), new C02281(this.$snackbarHostState, this.$context, count, null), this) == coroutine_suspended) {
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

                                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$5$1$1$1, reason: invalid class name and collision with other inner class name */
                                    /* JADX INFO: compiled from: DownloadDirectoryPreferences.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$5$1$1$1", f = "DownloadDirectoryPreferences.kt", i = {}, l = {HttpStatusCodesKt.HTTP_PRECONDITION_REQUIRED}, m = "invokeSuspend", n = {}, s = {})
                                    static final class C02281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ Context $context;
                                        final /* synthetic */ int $count;
                                        final /* synthetic */ SnackbarHostState $snackbarHostState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C02281(SnackbarHostState snackbarHostState, Context context, int i, Continuation<? super C02281> continuation) {
                                            super(2, continuation);
                                            this.$snackbarHostState = snackbarHostState;
                                            this.$context = context;
                                            this.$count = i;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C02281(this.$snackbarHostState, this.$context, this.$count, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C02281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object $result) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    SnackbarHostState snackbarHostState = this.$snackbarHostState;
                                                    String string = this.$context.getString(R.string.clear_temp_files_count);
                                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                    String str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$count)}, 1));
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
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$23(mutableState, false);
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new C02271(context2, snackbarHostState2, null), 2, null);
                                }
                            }, $composer6, 0, 3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer6.skipToGroupEnd();
                    }
                }, $composer5, 54), null, ComposableLambdaKt.rememberComposableLambda(2138937722, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer6, int $changed2) {
                        Object value$iv21;
                        ComposerKt.sourceInformation($composer6, "C403@17778L31,403@17764L45:DownloadDirectoryPreferences.kt#rl3ivv");
                        if (($changed2 & 11) == 2 && $composer6.getSkipping()) {
                            $composer6.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2138937722, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:403)");
                        }
                        $composer6.startReplaceGroup(-1362364073);
                        ComposerKt.sourceInformation($composer6, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                        final MutableState<Boolean> mutableState = showClearTempDialog$delegate;
                        Object it$iv14 = $composer6.rememberedValue();
                        if (it$iv14 == Composer.INSTANCE.getEmpty()) {
                            value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$6$1$1
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
                                    DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$23(mutableState, false);
                                }
                            };
                            $composer6.updateRememberedValue(value$iv21);
                        } else {
                            value$iv21 = it$iv14;
                        }
                        $composer6.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv21, $composer6, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer5, 54), ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7348getLambda7$app_debug(), ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7349getLambda8$app_debug(), ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7350getLambda9$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
            }
            $composer2.endReplaceGroup();
            boolean zDownloadDirectoryPreferences$lambda$33 = DownloadDirectoryPreferences$lambda$33(showOutputTemplateDialog$delegate2);
            Composer $composer6 = $composer2;
            $composer6.startReplaceGroup(1881047582);
            String str2 = str;
            ComposerKt.sourceInformation($composer6, str2);
            boolean invalid$iv4 = $composer6.changed(zDownloadDirectoryPreferences$lambda$33);
            Object it$iv14 = $composer6.rememberedValue();
            if (invalid$iv4 || it$iv14 == Composer.INSTANCE.getEmpty()) {
                r11 = 0;
                i = 1;
                i2 = 2;
                value$iv13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.OUTPUT_TEMPLATE, null, 1, null), null, 2, null);
                $composer6.updateRememberedValue(value$iv13);
            } else {
                value$iv13 = it$iv14;
                i2 = 2;
                r11 = 0;
                i = 1;
            }
            MutableState outputTemplate$delegate = (MutableState) value$iv13;
            $composer6.endReplaceGroup();
            boolean zDownloadDirectoryPreferences$lambda$34 = DownloadDirectoryPreferences$lambda$33(showOutputTemplateDialog$delegate2);
            $composer6.startReplaceGroup(1881047703);
            ComposerKt.sourceInformation($composer6, str2);
            boolean invalid$iv5 = $composer6.changed(zDownloadDirectoryPreferences$lambda$34);
            Object it$iv15 = $composer6.rememberedValue();
            if (invalid$iv5 || it$iv15 == Composer.INSTANCE.getEmpty()) {
                value$iv14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CUSTOM_OUTPUT_TEMPLATE, r11, i, r11), r11, i2, r11);
                $composer6.updateRememberedValue(value$iv14);
            } else {
                value$iv14 = it$iv15;
            }
            MutableState customTemplate$delegate = (MutableState) value$iv14;
            $composer6.endReplaceGroup();
            $composer6.startReplaceGroup(1881047809);
            ComposerKt.sourceInformation($composer6, "445@19446L36,446@19508L199,442@19301L407");
            if (!DownloadDirectoryPreferences$lambda$33(showOutputTemplateDialog$delegate2)) {
                showOutputTemplateDialog$delegate = showOutputTemplateDialog$delegate2;
            } else {
                String strDownloadDirectoryPreferences$lambda$38 = DownloadDirectoryPreferences$lambda$38(outputTemplate$delegate);
                String strDownloadDirectoryPreferences$lambda$40 = DownloadDirectoryPreferences$lambda$40(customTemplate$delegate);
                $composer6.startReplaceGroup(1881047994);
                ComposerKt.sourceInformation($composer6, str2);
                Object it$iv16 = $composer6.rememberedValue();
                if (it$iv16 == Composer.INSTANCE.getEmpty()) {
                    showOutputTemplateDialog$delegate = showOutputTemplateDialog$delegate2;
                    value$iv17 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$7$1
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
                            DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$34(showOutputTemplateDialog$delegate, false);
                        }
                    };
                    $composer6.updateRememberedValue(value$iv17);
                } else {
                    showOutputTemplateDialog$delegate = showOutputTemplateDialog$delegate2;
                    value$iv17 = it$iv16;
                }
                Function0 function0 = (Function0) value$iv17;
                $composer6.endReplaceGroup();
                $composer6.startReplaceGroup(1881048056);
                ComposerKt.sourceInformation($composer6, str2);
                Object it$iv17 = $composer6.rememberedValue();
                if (it$iv17 == Composer.INSTANCE.getEmpty()) {
                    value$iv18 = new Function2<String, String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str3, String str4) {
                            invoke2(str3, str4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String selected, String custom) {
                            Intrinsics.checkNotNullParameter(selected, "selected");
                            Intrinsics.checkNotNullParameter(custom, "custom");
                            PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.OUTPUT_TEMPLATE, selected);
                            PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.CUSTOM_OUTPUT_TEMPLATE, custom);
                            DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$34(showOutputTemplateDialog$delegate, false);
                        }
                    };
                    $composer6.updateRememberedValue(value$iv18);
                } else {
                    value$iv18 = it$iv17;
                }
                $composer6.endReplaceGroup();
                OutputTemplateDialog(strDownloadDirectoryPreferences$lambda$38, strDownloadDirectoryPreferences$lambda$40, function0, (Function2) value$iv18, $composer6, 3456, 0);
            }
            $composer6.endReplaceGroup();
            $composer6.startReplaceGroup(1881048267);
            ComposerKt.sourceInformation($composer6, "454@19811L44,462@20187L201,505@22238L126,468@20409L1799,453@19767L2608");
            if (DownloadDirectoryPreferences$lambda$25(showCustomCommandDirectoryDialog$delegate)) {
                $composer6.startReplaceGroup(1881048359);
                ComposerKt.sourceInformation($composer6, str2);
                Object it$iv18 = $composer6.rememberedValue();
                if (it$iv18 == Composer.INSTANCE.getEmpty()) {
                    value$iv16 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$9$1
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
                            DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$26(showCustomCommandDirectoryDialog$delegate, false);
                        }
                    };
                    $composer6.updateRememberedValue(value$iv16);
                } else {
                    value$iv16 = it$iv18;
                }
                $composer6.endReplaceGroup();
                $composer3 = $composer6;
                AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0((Function0) value$iv16, ComposableLambdaKt.rememberComposableLambda(-914818444, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer7, int $changed2) {
                        Object value$iv21;
                        ComposerKt.sourceInformation($composer7, "C463@20219L155,463@20205L169:DownloadDirectoryPreferences.kt#rl3ivv");
                        if (($changed2 & 11) == 2 && $composer7.getSkipping()) {
                            $composer7.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-914818444, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:463)");
                        }
                        $composer7.startReplaceGroup(-1362361632);
                        ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                        boolean invalid$iv6 = $composer7.changed(customCommandDirectory$delegate);
                        final MutableState<String> mutableState = customCommandDirectory$delegate;
                        final MutableState<Boolean> mutableState2 = showCustomCommandDirectoryDialog$delegate;
                        Object it$iv19 = $composer7.rememberedValue();
                        if (invalid$iv6 || it$iv19 == Composer.INSTANCE.getEmpty()) {
                            value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$10$1$1
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
                                    PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.COMMAND_DIRECTORY, DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$16(mutableState));
                                    DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$26(mutableState2, false);
                                }
                            };
                            $composer7.updateRememberedValue(value$iv21);
                        } else {
                            value$iv21 = it$iv19;
                        }
                        $composer7.endReplaceGroup();
                        ButtonsKt.ConfirmButton(null, false, (Function0) value$iv21, $composer7, 0, 3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer6, 54), null, ComposableLambdaKt.rememberComposableLambda(1877050546, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer7, int $changed2) {
                        Object value$iv21;
                        ComposerKt.sourceInformation($composer7, "C506@22270L80,506@22256L94:DownloadDirectoryPreferences.kt#rl3ivv");
                        if (($changed2 & 11) == 2 && $composer7.getSkipping()) {
                            $composer7.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1877050546, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:506)");
                        }
                        $composer7.startReplaceGroup(-1362359581);
                        ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                        final MutableState<Boolean> mutableState = showCustomCommandDirectoryDialog$delegate;
                        Object it$iv19 = $composer7.rememberedValue();
                        if (it$iv19 == Composer.INSTANCE.getEmpty()) {
                            value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$11$1$1
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
                                    DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$26(mutableState, false);
                                }
                            };
                            $composer7.updateRememberedValue(value$iv21);
                        } else {
                            value$iv21 = it$iv19;
                        }
                        $composer7.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv21, $composer7, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer6, 54), ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7336getLambda10$app_debug(), ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7337getLambda11$app_debug(), ComposableLambdaKt.rememberComposableLambda(-377596913, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer7, int $changed2) {
                        Function0<ComposeUiNode> function1;
                        Object value$iv21;
                        Function0<ComposeUiNode> function2;
                        ComposerKt.sourceInformation($composer7, "C470@20490L21,469@20427L1767:DownloadDirectoryPreferences.kt#rl3ivv");
                        if (($changed2 & 11) != 2 || !$composer7.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-377596913, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferences.<anonymous> (DownloadDirectoryPreferences.kt:469)");
                            }
                            Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer7, 0, 1), false, null, false, 14, null);
                            final MutableState<String> mutableState = customCommandDirectory$delegate;
                            final PermissionState permissionState = storagePermission;
                            final ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher = launcher;
                            final MutableState<Directory> mutableState2 = editingDirectory$delegate;
                            final UriHandler uriHandler2 = uriHandler;
                            ComposerKt.sourceInformationMarkerStart($composer7, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer7, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer7, 0);
                            CompositionLocalMap localMap$iv$iv = $composer7.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer7, modifier$iv);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer7, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer7.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer7.startReusableNode();
                            if ($composer7.getInserting()) {
                                function1 = constructor;
                                $composer7.createNode(function1);
                            } else {
                                function1 = constructor;
                                $composer7.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer7);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i3 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer7, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i4 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer7, -2013047089, "C476@20732L54,477@20834L10,472@20553L323,482@21082L31,479@20897L422,487@21406L21,486@21340L836:DownloadDirectoryPreferences.kt#rl3ivv");
                            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.custom_command_directory_desc, $composer7, 0), PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer7, MaterialTheme.$stable).getBodyLarge(), $composer7, 48, 0, 65532);
                            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(8), 1, null);
                            String strDownloadDirectoryPreferences$lambda$16 = DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$16(mutableState);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                            $composer7.startReplaceGroup(-2013046560);
                            ComposerKt.sourceInformation($composer7, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                            boolean invalid$iv6 = $composer7.changed(mutableState);
                            Object it$iv19 = $composer7.rememberedValue();
                            if (invalid$iv6 || it$iv19 == Composer.INSTANCE.getEmpty()) {
                                value$iv21 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$12$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                        invoke2(str3);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        mutableState.setValue(it);
                                    }
                                };
                                $composer7.updateRememberedValue(value$iv21);
                            } else {
                                value$iv21 = it$iv19;
                            }
                            $composer7.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strDownloadDirectoryPreferences$lambda$16, (Function1<? super String, Unit>) value$iv21, modifierM622paddingVpY3zN4$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7338getLambda12$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer7, 100663680, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 8355576);
                            Modifier modifier$iv2 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer7, 0, 1), false, null, false, 14, null);
                            ComposerKt.sourceInformationMarkerStart($composer7, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv2 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer7, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer7, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer7.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer7, modifier$iv2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer7, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer7.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer7.startReusableNode();
                            if ($composer7.getInserting()) {
                                function2 = constructor2;
                                $composer7.createNode(function2);
                            } else {
                                function2 = constructor2;
                                $composer7.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer7);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer7, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            int i6 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer7, 1060553612, "C491@21602L43,489@21477L359,497@21917L36,496@21861L293:DownloadDirectoryPreferences.kt#rl3ivv");
                            ChipsKt.OutlinedButtonChip(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null), FolderOpenKt.getFolderOpen(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.folder_picker, $composer7, 0), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$12$1$2$1
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
                                    DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$openDirectoryChooser(permissionState, managedActivityResultLauncher, mutableState2, Directory.CUSTOM_COMMAND);
                                }
                            }, $composer7, 6, 8);
                            ChipsKt.OutlinedButtonChip(null, OpenInNewKt.getOpenInNew(Icons.AutoMirrored.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.yt_dlp_docs, $composer7, 0), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$12$1$2$2
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
                                    uriHandler2.openUri("https://github.com/yt-dlp/yt-dlp#filesystem-options");
                                }
                            }, $composer7, 0, 9);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            $composer7.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            $composer7.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer7.skipToGroupEnd();
                    }
                }, $composer6, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer3, 1797174, 0, 16260);
            } else {
                $composer3 = $composer6;
            }
            $composer3.endReplaceGroup();
            if (!DownloadDirectoryPreferences$lambda$2(showSubdirectoryDialog$delegate)) {
                $composer4 = $composer3;
            } else {
                $composer4 = $composer3;
                $composer4.startReplaceGroup(1881051030);
                ComposerKt.sourceInformation($composer4, str2);
                Object it$iv19 = $composer4.rememberedValue();
                if (it$iv19 == Composer.INSTANCE.getEmpty()) {
                    value$iv15 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$DownloadDirectoryPreferences$13$1
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
                            DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences$lambda$3(showSubdirectoryDialog$delegate, false);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv15);
                } else {
                    value$iv15 = it$iv19;
                }
                $composer4.endReplaceGroup();
                DirectoryPreferenceDialogKt.DirectoryPreferenceDialog((Function0) value$iv15, PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBDIRECTORY_EXTRACTOR, false, 1, null), PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBDIRECTORY_PLAYLIST_TITLE, false, 1, null), new Function2<Boolean, Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.14
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                        invoke(bool.booleanValue(), bool2.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean isWebsiteSelected, boolean isPlaylistTitleSelected) {
                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.SUBDIRECTORY_EXTRACTOR, isWebsiteSelected);
                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.SUBDIRECTORY_PLAYLIST_TITLE, isPlaylistTitleSelected);
                    }
                }, $composer4, 3078, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer5.skipToGroupEnd();
            $composer4 = $composer5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences.15
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
                    DownloadDirectoryPreferencesKt.DownloadDirectoryPreferences(onNavigateBack, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final boolean DownloadDirectoryPreferences$lambda$2(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadDirectoryPreferences$lambda$3(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadDirectoryPreferences$lambda$5(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadDirectoryPreferences$lambda$6(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadDirectoryPreferences$lambda$8(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadDirectoryPreferences$lambda$11(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadDirectoryPreferences$lambda$14(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadDirectoryPreferences$lambda$16(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadDirectoryPreferences$lambda$19(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadDirectoryPreferences$lambda$20(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadDirectoryPreferences$lambda$22(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadDirectoryPreferences$lambda$23(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadDirectoryPreferences$lambda$25(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadDirectoryPreferences$lambda$26(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Directory DownloadDirectoryPreferences$lambda$28(MutableState<Directory> mutableState) {
        MutableState<Directory> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadDirectoryPreferences$lambda$31(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    private static final boolean DownloadDirectoryPreferences$lambda$33(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadDirectoryPreferences$lambda$34(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    static /* synthetic */ void DownloadDirectoryPreferences$openDirectoryChooser$default(PermissionState permissionState, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, Directory directory, int i, Object obj) {
        if ((i & 8) != 0) {
            directory = Directory.VIDEO;
        }
        DownloadDirectoryPreferences$openDirectoryChooser(permissionState, managedActivityResultLauncher, mutableState, directory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadDirectoryPreferences$openDirectoryChooser(PermissionState storagePermission, ManagedActivityResultLauncher<Uri, Uri> managedActivityResultLauncher, MutableState<Directory> mutableState, Directory directory) {
        mutableState.setValue(directory);
        if (Build.VERSION.SDK_INT > 29 || Intrinsics.areEqual(storagePermission.getStatus(), PermissionStatus.Granted.INSTANCE)) {
            managedActivityResultLauncher.launch(null);
        } else {
            storagePermission.launchPermissionRequest();
        }
    }

    private static final String DownloadDirectoryPreferences$lambda$38(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    private static final String DownloadDirectoryPreferences$lambda$40(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void OutputTemplateDialog(String selectedTemplate, String customTemplate, Function0<Unit> function0, Function2<? super String, ? super String, Unit> function2, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        Function0<Unit> function1;
        Function2<? super String, ? super String, Unit> function3;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        String selectedTemplate2;
        String customTemplate2;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(1368167403);
        ComposerKt.sourceInformation($composer2, "C(OutputTemplateDialog)P(3!1,2)533@23230L43,535@23299L242,545@23560L33,549@23680L396,560@24094L88,567@24375L3327,547@23599L4104:DownloadDirectoryPreferences.kt#rl3ivv");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            str = selectedTemplate;
        } else if (($changed & 14) == 0) {
            str = selectedTemplate;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = selectedTemplate;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            str2 = customTemplate;
        } else if (($changed & 112) == 0) {
            str2 = customTemplate;
            $dirty |= $composer2.changed(str2) ? 32 : 16;
        } else {
            str2 = customTemplate;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            function1 = function0;
        } else if (($changed & 896) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            function3 = function2;
        } else if (($changed & 7168) == 0) {
            function3 = function2;
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function2;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            customTemplate2 = str2;
            selectedTemplate2 = str;
        } else {
            String selectedTemplate3 = i3 != 0 ? DownloadUtil.OUTPUT_TEMPLATE_DEFAULT : str;
            String customTemplate3 = i4 != 0 ? DownloadUtil.OUTPUT_TEMPLATE_ID : str2;
            final C09801 c09801 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.OutputTemplateDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            final Function2<? super String, ? super String, Unit> function4 = i6 != 0 ? new Function2<String, String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.OutputTemplateDialog.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str3, String str4) {
                    invoke2(str3, str4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String s, String s1) {
                    Intrinsics.checkNotNullParameter(s, "s");
                    Intrinsics.checkNotNullParameter(s1, "s1");
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1368167403, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.directory.OutputTemplateDialog (DownloadDirectoryPreferences.kt:532)");
            }
            $composer2.startReplaceGroup(1193520306);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(customTemplate3, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState editingTemplate$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1193520375);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                if (Intrinsics.areEqual(selectedTemplate3, DownloadUtil.OUTPUT_TEMPLATE_DEFAULT)) {
                    i2 = 1;
                } else {
                    i2 = Intrinsics.areEqual(selectedTemplate3, DownloadUtil.OUTPUT_TEMPLATE_ID) ? 2 : 3;
                }
                value$iv2 = SnapshotIntStateKt.mutableIntStateOf(i2);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableIntState selectedItem$delegate = (MutableIntState) value$iv2;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1193520636);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableIntState error$delegate = (MutableIntState) value$iv3;
            $composer2.endReplaceGroup();
            String selectedTemplate4 = selectedTemplate3;
            Function2<? super String, ? super String, Unit> function5 = function4;
            DialogsKt.m7162LoopDialogOix01E0(null, c09801, ComposableLambdaKt.rememberComposableLambda(-368729338, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.OutputTemplateDialog.3
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
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer3, "C550@23730L336,550@23694L372:DownloadDirectoryPreferences.kt#rl3ivv");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368729338, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.OutputTemplateDialog.<anonymous> (DownloadDirectoryPreferences.kt:550)");
                    }
                    boolean z = DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$52(error$delegate) == 0;
                    $composer3.startReplaceGroup(764109511);
                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(function4);
                    final Function2<String, String, Unit> function6 = function4;
                    final MutableIntState mutableIntState = selectedItem$delegate;
                    final MutableState<String> mutableState = editingTemplate$delegate;
                    Object it$iv4 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$3$1$1
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
                                String strOutputTemplateDialog$lambda$46;
                                Function2<String, String, Unit> function7 = function6;
                                switch (DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$49(mutableIntState)) {
                                    case 1:
                                        strOutputTemplateDialog$lambda$46 = DownloadUtil.OUTPUT_TEMPLATE_DEFAULT;
                                        break;
                                    case 2:
                                        strOutputTemplateDialog$lambda$46 = DownloadUtil.OUTPUT_TEMPLATE_ID;
                                        break;
                                    default:
                                        strOutputTemplateDialog$lambda$46 = DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$46(mutableState);
                                        break;
                                }
                                function7.invoke(strOutputTemplateDialog$lambda$46, DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$46(mutableState));
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, z, (Function0) value$iv4, $composer3, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-105032313, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.OutputTemplateDialog.4
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
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer3, "C561@24122L50,561@24108L64:DownloadDirectoryPreferences.kt#rl3ivv");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-105032313, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.OutputTemplateDialog.<anonymous> (DownloadDirectoryPreferences.kt:561)");
                    }
                    $composer3.startReplaceGroup(764109903);
                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c09801);
                    final Function0<Unit> function6 = c09801;
                    Object it$iv4 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$4$1$1
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
                                function6.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv4, $composer3, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7339getLambda13$app_debug(), ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7340getLambda14$app_debug(), ComposableLambdaKt.rememberComposableLambda(686058762, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.OutputTemplateDialog.5
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
                    Function0<ComposeUiNode> function6;
                    Function0<ComposeUiNode> function7;
                    ComposerKt.sourceInformation($composer3, "C569@24390L3302:DownloadDirectoryPreferences.kt#rl3ivv");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(686058762, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.directory.OutputTemplateDialog.<anonymous> (DownloadDirectoryPreferences.kt:569)");
                        }
                        final MutableIntState mutableIntState = selectedItem$delegate;
                        final MutableState<String> mutableState = editingTemplate$delegate;
                        final MutableIntState mutableIntState2 = error$delegate;
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
                            function6 = constructor;
                            $composer3.createNode(function6);
                        } else {
                            function6 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i8 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1863782379, "C571@24448L50,575@24685L10,570@24415L308,578@24783L21,578@24741L2765,634@27524L154:DownloadDirectoryPreferences.kt#rl3ivv");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.output_template_desc, $composer3, 0), PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(24), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge(), $composer3, 48, 0, 65532);
                        Modifier modifier$iv2 = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv2 = (0 << 3) & 112;
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
                            function7 = constructor2;
                            $composer3.createNode(function7);
                        } else {
                            function7 = constructor2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        int i10 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1924043476, "C580@24918L7,583@25043L2445,579@24829L2659:DownloadDirectoryPreferences.kt#rl3ivv");
                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                        ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer3.consume(localTextStyle2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        TextStyle textStyle = (TextStyle) objConsume;
                        CompositionLocalKt.CompositionLocalProvider(localTextStyle.provides(textStyle.m6029copyp1EtxEg((16777213 & 1) != 0 ? textStyle.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyle.platformStyle : null, (16777213 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null)), ComposableLambdaKt.rememberComposableLambda(808016054, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$5$1$1$1
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
                                Object value$iv4;
                                Object value$iv5;
                                Function0<ComposeUiNode> function8;
                                Object value$iv6;
                                ComposerKt.sourceInformation($composer4, "C587@25249L72,584@25069L252,593@25521L72,590@25346L247,596@25618L1848:DownloadDirectoryPreferences.kt#rl3ivv");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(808016054, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.directory.OutputTemplateDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadDirectoryPreferences.kt:584)");
                                    }
                                    boolean z = DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$49(mutableIntState) == 1;
                                    $composer4.startReplaceGroup(-85029863);
                                    ComposerKt.sourceInformation($composer4, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                    final MutableIntState mutableIntState3 = mutableIntState;
                                    Object it$iv4 = $composer4.rememberedValue();
                                    if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                        value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$5$1$1$1$1$1
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
                                                mutableIntState3.setIntValue(1);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv4);
                                    } else {
                                        value$iv4 = it$iv4;
                                    }
                                    $composer4.endReplaceGroup();
                                    DialogItemsKt.DialogSingleChoiceItem(null, DownloadUtil.OUTPUT_TEMPLATE_DEFAULT, z, (Function0) value$iv4, $composer4, 3120, 1);
                                    boolean z2 = DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$49(mutableIntState) == 2;
                                    $composer4.startReplaceGroup(-85029591);
                                    ComposerKt.sourceInformation($composer4, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                    final MutableIntState mutableIntState4 = mutableIntState;
                                    Object it$iv5 = $composer4.rememberedValue();
                                    if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                                        value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$5$1$1$1$2$1
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
                                                mutableIntState4.setIntValue(2);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv5);
                                    } else {
                                        value$iv5 = it$iv5;
                                    }
                                    $composer4.endReplaceGroup();
                                    DialogItemsKt.DialogSingleChoiceItem(null, DownloadUtil.OUTPUT_TEMPLATE_ID, z2, (Function0) value$iv5, $composer4, 3120, 1);
                                    Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(12), 1, null);
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    final MutableIntState mutableIntState5 = mutableIntState;
                                    final MutableState<String> mutableState2 = mutableState;
                                    final MutableIntState mutableIntState6 = mutableIntState2;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(start, centerVertically, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                                    int $changed$iv$iv3 = (438 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifierM622paddingVpY3zN4$default);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function8 = constructor3;
                                        $composer4.createNode(function8);
                                    } else {
                                        function8 = constructor3;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    int i12 = ((438 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -2007294637, "C607@26237L20,604@26042L245,611@26440L475,609@26316L1124:DownloadDirectoryPreferences.kt#rl3ivv");
                                    Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$5$1$1$1$3$1
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
                                    boolean z3 = DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$49(mutableIntState5) == 3;
                                    $composer4.startReplaceGroup(-2007294442);
                                    ComposerKt.sourceInformation($composer4, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                    Object value$iv7 = $composer4.rememberedValue();
                                    if (value$iv7 == Composer.INSTANCE.getEmpty()) {
                                        value$iv7 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$5$1$1$1$3$2$1
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
                                                mutableIntState5.setIntValue(3);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv7);
                                    }
                                    $composer4.endReplaceGroup();
                                    RadioButtonKt.RadioButton(z3, (Function0) value$iv7, modifierClearAndSetSemantics, false, null, null, $composer4, 48, 56);
                                    String strOutputTemplateDialog$lambda$46 = DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$46(mutableState2);
                                    boolean z4 = DownloadDirectoryPreferencesKt.OutputTemplateDialog$lambda$52(mutableIntState6) != 0;
                                    $composer4.startReplaceGroup(-2007294239);
                                    ComposerKt.sourceInformation($composer4, "CC(remember):DownloadDirectoryPreferences.kt#9igjgp");
                                    Object it$iv6 = $composer4.rememberedValue();
                                    if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                                        value$iv6 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt$OutputTemplateDialog$5$1$1$1$3$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                                invoke2(str3);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(String it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                MutableIntState mutableIntState7 = mutableIntState6;
                                                int i13 = 0;
                                                if (!StringsKt.contains$default((CharSequence) it, (CharSequence) DownloadUtil.BASENAME, false, 2, (Object) null)) {
                                                    i13 = 1;
                                                } else if (!StringsKt.endsWith$default(it, DownloadUtil.EXTENSION, false, 2, (Object) null)) {
                                                    i13 = 2;
                                                }
                                                mutableIntState7.setIntValue(i13);
                                                mutableState2.setValue(it);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv6);
                                    } else {
                                        value$iv6 = it$iv6;
                                    }
                                    $composer4.endReplaceGroup();
                                    OutlinedTextFieldKt.OutlinedTextField(strOutputTemplateDialog$lambda$46, (Function1<? super String, Unit>) value$iv6, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7341getLambda15$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DownloadDirectoryPreferencesKt.INSTANCE.m7342getLambda16$app_debug(), z4, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1572912, 384, 0, 8376252);
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
                        }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ButtonsKt.LinkButton(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(16), 0.0f, 2, null), null, null, DownloadDirectoryPreferencesKt.ytdlpOutputTemplateReference, $composer3, 3078, 6);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selectedTemplate2 = selectedTemplate4;
            function3 = function5;
            customTemplate2 = customTemplate3;
            function1 = c09801;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str3 = selectedTemplate2;
            final String str4 = customTemplate2;
            final Function0<Unit> function6 = function1;
            final Function2<? super String, ? super String, Unit> function7 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.directory.DownloadDirectoryPreferencesKt.OutputTemplateDialog.6
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
                    DownloadDirectoryPreferencesKt.OutputTemplateDialog(str3, str4, function6, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String OutputTemplateDialog$lambda$46(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OutputTemplateDialog$lambda$49(MutableIntState $selectedItem$delegate) {
        MutableIntState $this$getValue$iv = $selectedItem$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OutputTemplateDialog$lambda$52(MutableIntState $error$delegate) {
        MutableIntState $this$getValue$iv = $error$delegate;
        return $this$getValue$iv.getIntValue();
    }
}
