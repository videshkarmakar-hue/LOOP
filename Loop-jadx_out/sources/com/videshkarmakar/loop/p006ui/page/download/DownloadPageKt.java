package com.videshkarmakar.loop.p006ui.page.download;

import android.os.Build;
import android.view.View;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material.icons.outlined.ErrorKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CaretScope;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipDefaults;
import androidx.compose.material3.TooltipKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.SoftwareKeyboardController;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.PlatformImeOptions;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.p001ui.window.PopupPositionProvider;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt__ViewModel_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.accompanist.permissions.PermissionState;
import com.google.accompanist.permissions.PermissionStateKt;
import com.google.accompanist.permissions.PermissionStatus;
import com.google.accompanist.permissions.PermissionsUtilKt;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.p006ui.common.HapticFeedback;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.CommonComponentsKt;
import com.videshkarmakar.loop.p006ui.component.IconButtonsKt;
import com.videshkarmakar.loop.p006ui.component.VideoCardKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.p006ui.theme.TypeKt;
import com.videshkarmakar.loop.util.Entries;
import com.videshkarmakar.loop.util.Format;
import com.videshkarmakar.loop.util.PlaylistResult;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import com.videshkarmakar.loop.util.VideoInfo;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: DownloadPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m194d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a}\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001aø\u0001\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\"\u001a\u00020\u00182\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b$H\u0007¢\u0006\u0002\u0010%\u001a7\u0010&\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010,\u001a\u0017\u0010-\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020(H\u0003¢\u0006\u0002\u0010.\u001ag\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u00105\u001a\u00020\u00182\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010:\u001aI\u0010;\u001a\u00020\u00012\b\b\u0002\u0010<\u001a\u00020\u00182\b\b\u0002\u0010=\u001a\u00020\u00182\b\b\u0002\u0010>\u001a\u00020\u00182\b\b\u0002\u0010?\u001a\u00020\u001c2\b\b\u0002\u0010@\u001a\u00020\u001c2\b\b\u0002\u0010A\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010B\u001a\u0011\u0010C\u001a\u00020\u0001*\u00020DH\u0003¢\u0006\u0002\u0010E¨\u0006F²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010G\u001a\u00020HX\u008a\u0084\u0002²\u0006\n\u0010I\u001a\u00020JX\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010N\u001a\u000203X\u008a\u0084\u0002"}, m195d2 = {"DownloadPage", "", "navigateToSettings", "Lkotlin/Function0;", "navigateToDownloads", "navigateToPlaylistPage", "navigateToFormatPage", "onNavigateToTaskList", "onNavigateToCookieGeneratorPage", "Lkotlin/Function1;", "", "downloadViewModel", "Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;Landroidx/compose/runtime/Composer;II)V", "DownloadPageImpl", "downloaderState", "Lcom/videshkarmakar/loop/Downloader$State;", "taskState", "Lcom/videshkarmakar/loop/Downloader$DownloadTaskItem;", "viewState", "Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel$ViewState;", "errorState", "Lcom/videshkarmakar/loop/Downloader$ErrorState;", "showVideoCard", "", "showOutput", "showDownloadProgress", "processCount", "", "downloadCallback", "pasteCallback", "cancelCallback", "onVideoCardClicked", "onUrlChanged", "isPreview", "content", "Landroidx/compose/runtime/Composable;", "(Lcom/videshkarmakar/loop/Downloader$State;Lcom/videshkarmakar/loop/Downloader$DownloadTaskItem;Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel$ViewState;Lcom/videshkarmakar/loop/Downloader$ErrorState;ZZZILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "ErrorMessage", "modifier", "Landroidx/compose/ui/Modifier;", "title", "errorReport", "onButtonClicked", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FooterSignature", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InputUrl", "url", "error", NotificationCompat.CATEGORY_PROGRESS, "", "onDone", "showCancelButton", "onCancel", "onValueChange", "(Ljava/lang/String;ZZFLkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PreviewDownloadPage", "(Landroidx/compose/runtime/Composer;I)V", "TitleWithProgressIndicator", "showProgressIndicator", "showDownloadText", "isDownloadingPlaylist", "currentIndex", "downloadItemCount", "isCentered", "(ZZZIIZLandroidx/compose/runtime/Composer;II)V", "Hairline", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V", "app_debug", "playlistInfo", "Lcom/videshkarmakar/loop/util/PlaylistResult;", "videoInfo", "Lcom/videshkarmakar/loop/util/VideoInfo;", "showNotificationDialog", "showDownloadDialog", "showMeteredNetworkDialog", "progressAnimationValue"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadPageKt {
    public static final void DownloadPage(Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4, Function1<? super String, Unit> function5, DownloadViewModel downloadViewModel, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function6;
        Function0<Unit> function7;
        Function0<Unit> function8;
        Function0<Unit> function9;
        Function1<? super String, Unit> function10;
        Function0<Unit> function11;
        final DownloadViewModel downloadViewModel2;
        int $dirty;
        Function1<? super String, Unit> function12;
        Function0<Unit> function13;
        Object value$iv;
        PermissionState permissionStateRememberPermissionState;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        final Function0<Unit> function14;
        DownloadPageKt$DownloadPage$14$1 value$iv5;
        Object value$iv6;
        Function0<ComposeUiNode> function15;
        DownloadViewModel downloadViewModel3;
        Object value$iv7;
        Object value$iv8;
        Object value$iv9;
        Composer $composer2 = $composer.startRestartGroup(2049823374);
        ComposerKt.sourceInformation($composer2, "C(DownloadPage)P(4,1,3,2,6,5)136@6542L15,139@6580L24,140@6659L29,141@6731L29,142@6814L29,143@6894L29,144@6977L29,145@7051L29,146@7129L29,148@7194L34,158@7659L7,159@7728L7,160@7778L7,161@7843L7,162@7881L42,163@7960L34,175@8346L162,173@8251L257,183@8546L225,229@9990L241,234@10237L250,240@10510L59,243@10606L104,243@10574L136,251@10863L121,260@11088L11,257@10990L1583:DownloadPage.kt#y3famj");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            function6 = function1;
        } else if (($changed & 112) == 0) {
            function6 = function1;
            $dirty2 |= $composer2.changedInstance(function6) ? 32 : 16;
        } else {
            function6 = function1;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            function7 = function2;
        } else if (($changed & 896) == 0) {
            function7 = function2;
            $dirty2 |= $composer2.changedInstance(function7) ? 256 : 128;
        } else {
            function7 = function2;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            function8 = function3;
        } else if (($changed & 7168) == 0) {
            function8 = function3;
            $dirty2 |= $composer2.changedInstance(function8) ? 2048 : 1024;
        } else {
            function8 = function3;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function9 = function4;
        } else if ((57344 & $changed) == 0) {
            function9 = function4;
            $dirty2 |= $composer2.changedInstance(function9) ? 16384 : 8192;
        } else {
            function9 = function4;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function10 = function5;
        } else if (($changed & 458752) == 0) {
            function10 = function5;
            $dirty2 |= $composer2.changedInstance(function10) ? 131072 : 65536;
        } else {
            function10 = function5;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 524288;
        }
        int $dirty3 = $dirty2;
        if (i8 == 64 && ($dirty3 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function11 = function0;
            downloadViewModel3 = downloadViewModel;
            function6 = function6;
            function14 = function7;
            function12 = function10;
            function13 = function9;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                function11 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function0;
                Function0<Unit> function16 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.2
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function6;
                Function0<Unit> function17 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.3
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function7;
                if (i5 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.4
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                }
                if (i6 != 0) {
                    function9 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.5
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                }
                if (i7 != 0) {
                    function10 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.6
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    };
                }
                if (i8 != 0) {
                    $composer2.startReplaceableGroup(-550968255);
                    ComposerKt.sourceInformation($composer2, "C(hiltViewModel)*42@1777L7,46@1895L47,47@1954L49:HiltViewModel.kt#9mcars");
                    ViewModelStoreOwner viewModelStoreOwner$iv = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 8);
                    if (viewModelStoreOwner$iv == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factory$iv = HiltViewModelKt.createHiltViewModelFactory(viewModelStoreOwner$iv, $composer2, 8);
                    $composer2.startReplaceableGroup(564614654);
                    ComposerKt.sourceInformation($composer2, "C(viewModel)P(2,1)*41@1904L7,46@2077L60:ViewModel.kt#3tja67");
                    ViewModel viewModel = ViewModelKt__ViewModel_androidKt.viewModel(DownloadViewModel.class, viewModelStoreOwner$iv, null, factory$iv, $composer2, ((520 << 3) & 896) | 4168, 0);
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    downloadViewModel2 = (DownloadViewModel) viewModel;
                    $dirty = $dirty3 & (-3670017);
                    function6 = function16;
                    function7 = function17;
                } else {
                    downloadViewModel2 = downloadViewModel;
                    $dirty = $dirty3;
                    function6 = function16;
                    function7 = function17;
                }
            } else {
                $composer2.skipToGroupEnd();
                if (i8 != 0) {
                    $dirty3 &= -3670017;
                }
                function11 = function0;
                downloadViewModel2 = downloadViewModel;
                $dirty = $dirty3;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2049823374, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPage (DownloadPage.kt:137)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State downloaderState$delegate = FlowExtKt.collectAsStateWithLifecycle(Downloader.INSTANCE.getDownloaderState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            State taskState$delegate = FlowExtKt.collectAsStateWithLifecycle(Downloader.INSTANCE.getTaskState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            final State viewState$delegate = FlowExtKt.collectAsStateWithLifecycle(downloadViewModel2.getViewStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            final State playlistInfo$delegate = FlowExtKt.collectAsStateWithLifecycle(Downloader.INSTANCE.getPlaylistResult(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            final State videoInfo$delegate = FlowExtKt.collectAsStateWithLifecycle(downloadViewModel2.getVideoInfoFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            State errorState$delegate = FlowExtKt.collectAsStateWithLifecycle(Downloader.INSTANCE.getErrorState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            State processCount$delegate = FlowExtKt.collectAsStateWithLifecycle(Downloader.INSTANCE.getProcessCount(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            $composer2.startReplaceGroup(-1565027968);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            function12 = function10;
            function13 = function9;
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showNotificationDialog$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-1565027900);
            ComposerKt.sourceInformation($composer2, "150@7408L184,150@7331L261");
            if (Build.VERSION.SDK_INT >= 33) {
                $composer2.startReplaceGroup(-1565027754);
                ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv9 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$notificationPermission$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean isGranted) {
                            DownloadPageKt.DownloadPage$lambda$9(showNotificationDialog$delegate, false);
                            if (!isGranted) {
                                ToastUtil.INSTANCE.makeToast(C3070R.string.permission_denied);
                            }
                        }
                    };
                    $composer2.updateRememberedValue(value$iv9);
                } else {
                    value$iv9 = it$iv2;
                }
                $composer2.endReplaceGroup();
                permissionStateRememberPermissionState = PermissionStateKt.rememberPermissionState("android.permission.POST_NOTIFICATIONS", (Function1) value$iv9, $composer2, 54, 0);
            } else {
                permissionStateRememberPermissionState = null;
            }
            $composer2.endReplaceGroup();
            final PermissionState notificationPermission = permissionStateRememberPermissionState;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ClipboardManager clipboardManager = (ClipboardManager) objConsume;
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) objConsume2;
            ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = com.videshkarmakar.loop.p006ui.common.CompositionLocalsKt.getLocalWindowWidthState();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localWindowWidthState);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean useDialog = !WindowWidthSizeClass.m3739equalsimpl0(((WindowWidthSizeClass) objConsume3).getValue(), WindowWidthSizeClass.INSTANCE.m3747getCompactY0FxcvE());
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view = (View) objConsume4;
            final MutableState showDownloadDialog$delegate = (MutableState) RememberSaveableKt.m3889rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$showDownloadDialog$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MutableState<Boolean> invoke() {
                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                }
            }, $composer2, 3080, 6);
            $composer2.startReplaceGroup(-1565027202);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv3;
            }
            final MutableState showMeteredNetworkDialog$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            final Function0<Unit> function18 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$checkNetworkOrDownload$1
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
                    if (!PreferenceUtil.INSTANCE.isNetworkAvailableForDownload()) {
                        DownloadPageKt.DownloadPage$lambda$15(showMeteredNetworkDialog$delegate, true);
                    } else {
                        downloadViewModel2.startDownloadVideo();
                    }
                }
            };
            $composer2.startReplaceGroup(-1565026816);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(function18);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$storagePermission$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean b) {
                        if (b) {
                            function18.invoke();
                        } else {
                            ToastUtil.INSTANCE.makeToast(C3070R.string.permission_denied);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv4;
            }
            $composer2.endReplaceGroup();
            Function0<Unit> function19 = function7;
            final PermissionState storagePermission = PermissionStateKt.rememberPermissionState("android.permission.WRITE_EXTERNAL_STORAGE", (Function1) value$iv3, $composer2, 6, 0);
            $composer2.startReplaceGroup(-1565026616);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(storagePermission) | $composer2.changed(function18);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$checkPermissionOrDownload$1$1
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
                        if (Build.VERSION.SDK_INT > 29 || Intrinsics.areEqual(storagePermission.getStatus(), PermissionStatus.Granted.INSTANCE)) {
                            function18.invoke();
                        } else {
                            storagePermission.launchPermissionRequest();
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv5;
            }
            final Function0 checkPermissionOrDownload = (Function0) value$iv4;
            $composer2.endReplaceGroup();
            Function0<Unit> function20 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$downloadCallback$1
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
                    PermissionStatus status;
                    HapticFeedback.INSTANCE.slightHapticFeedback(view);
                    SoftwareKeyboardController softwareKeyboardController = keyboardController;
                    if (softwareKeyboardController != null) {
                        softwareKeyboardController.hide();
                    }
                    if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.NOTIFICATION, false, 1, null)) {
                        PermissionState permissionState = notificationPermission;
                        if ((permissionState == null || (status = permissionState.getStatus()) == null || PermissionsUtilKt.isGranted(status)) ? false : true) {
                            DownloadPageKt.DownloadPage$lambda$9(showNotificationDialog$delegate, true);
                        }
                    }
                    if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CONFIGURE, false, 1, null)) {
                        DownloadPageKt.DownloadPage$lambda$12(showDownloadDialog$delegate, true);
                    } else {
                        checkPermissionOrDownload.invoke();
                    }
                }
            };
            $composer2.startReplaceGroup(-1565025975);
            ComposerKt.sourceInformation($composer2, "206@9273L100,209@9397L73,206@9225L246");
            if (DownloadPage$lambda$8(showNotificationDialog$delegate)) {
                $composer2.startReplaceGroup(-1565025889);
                ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
                Object value$iv10 = $composer2.rememberedValue();
                if (value$iv10 == Composer.INSTANCE.getEmpty()) {
                    value$iv10 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$7$1
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
                            DownloadPageKt.DownloadPage$lambda$9(showNotificationDialog$delegate, false);
                            PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.NOTIFICATION, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv10);
                }
                Function0 function21 = (Function0) value$iv10;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(-1565025765);
                ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changed(notificationPermission);
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv8 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$8$1
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
                        }
                    };
                    $composer2.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = it$iv6;
                }
                $composer2.endReplaceGroup();
                NotificationPermissionDialogKt.NotificationPermissionDialog(function21, (Function0) value$iv8, $composer2, 6, 0);
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-1565025679);
            ComposerKt.sourceInformation($composer2, "216@9576L36,215@9523L454");
            if (DownloadPage$lambda$14(showMeteredNetworkDialog$delegate)) {
                $composer2.startReplaceGroup(-1565025586);
                ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
                Object it$iv7 = $composer2.rememberedValue();
                if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$9$1
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
                            DownloadPageKt.DownloadPage$lambda$15(showMeteredNetworkDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv7;
                }
                $composer2.endReplaceGroup();
                MeteredNetworkDialogKt.MeteredNetworkDialog((Function0) value$iv7, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.10
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
                        downloadViewModel2.startDownloadVideo();
                        DownloadPageKt.DownloadPage$lambda$15(showMeteredNetworkDialog$delegate, false);
                    }
                }, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.11
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
                        downloadViewModel2.startDownloadVideo();
                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.CELLULAR_DOWNLOAD, true);
                        DownloadPageKt.DownloadPage$lambda$15(showMeteredNetworkDialog$delegate, false);
                    }
                }, $composer2, 6, 0);
            }
            $composer2.endReplaceGroup();
            function14 = function19;
            EffectsKt.DisposableEffect(Boolean.valueOf(DownloadPage$lambda$2(viewState$delegate).getShowPlaylistSelectionDialog()), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    List<Entries> entries = DownloadPageKt.DownloadPage$lambda$3(playlistInfo$delegate).getEntries();
                    if (!(entries == null || entries.isEmpty()) && DownloadPageKt.DownloadPage$lambda$2(viewState$delegate).getShowPlaylistSelectionDialog()) {
                        function14.invoke();
                    }
                    final DownloadViewModel downloadViewModel4 = downloadViewModel2;
                    return new DisposableEffectResult() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$12$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            downloadViewModel4.hidePlaylistDialog();
                        }
                    };
                }
            }, $composer2, 0);
            final Function0<Unit> function22 = function8;
            EffectsKt.DisposableEffect(Boolean.valueOf(DownloadPage$lambda$2(viewState$delegate).getShowFormatSelectionPage()), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    if (DownloadPageKt.DownloadPage$lambda$2(viewState$delegate).getShowFormatSelectionPage()) {
                        List<Format> formats = DownloadPageKt.DownloadPage$lambda$4(videoInfo$delegate).getFormats();
                        if (!(formats == null || formats.isEmpty())) {
                            function22.invoke();
                        }
                    }
                    final DownloadViewModel downloadViewModel4 = downloadViewModel2;
                    return new DisposableEffectResult() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$13$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            downloadViewModel4.hideFormatPage();
                        }
                    };
                }
            }, $composer2, 0);
            $composer2.startReplaceGroup(-1565024652);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            Object value$iv11 = $composer2.rememberedValue();
            if (value$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.DEBUG, false, 1, null)), null, 2, null);
                $composer2.updateRememberedValue(value$iv11);
            }
            MutableState showOutput$delegate = (MutableState) value$iv11;
            $composer2.endReplaceGroup();
            Downloader.State stateDownloadPage$lambda$0 = DownloadPage$lambda$0(downloaderState$delegate);
            $composer2.startReplaceGroup(-1565024556);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(downloaderState$delegate);
            Object it$iv8 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new DownloadPageKt$DownloadPage$14$1(downloaderState$delegate, showOutput$delegate, null);
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv8;
            }
            $composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(stateDownloadPage$lambda$0, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv5, $composer2, 64);
            if (DownloadPage$lambda$2(viewState$delegate).isUrlSharingTriggered()) {
                downloadViewModel2.onShareIntentConsumed();
                function20.invoke();
            }
            Downloader.State stateDownloadPage$lambda$1 = DownloadPage$lambda$0(downloaderState$delegate);
            $composer2.startReplaceGroup(-1565024299);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changed(stateDownloadPage$lambda$1);
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.DISABLE_PREVIEW)), null, 2, null);
                $composer2.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv9;
            }
            MutableState showVideoCard$delegate = (MutableState) value$iv6;
            $composer2.endReplaceGroup();
            Modifier modifier$iv = BackgroundKt.m454backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function15 = constructor;
                $composer2.createNode(function15);
            } else {
                function15 = constructor;
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
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -346310144, "C262@11129L1095,290@12435L31,291@12499L58,287@12234L333:DownloadPage.kt#y3famj");
            DownloadPageImpl(DownloadPage$lambda$0(downloaderState$delegate), DownloadPage$lambda$1(taskState$delegate), DownloadPage$lambda$2(viewState$delegate), DownloadPage$lambda$5(errorState$delegate), DownloadPage$lambda$26(showVideoCard$delegate), DownloadPage$lambda$22(showOutput$delegate), DownloadPage$lambda$1(taskState$delegate).getTaskId().length() > 0, DownloadPage$lambda$6(processCount$delegate), function20, function11, function6, function13, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$15$1
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
                    String it = TextUtilKt.matchUrlFromClipboard(String.valueOf(clipboardManager.getText()), PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CUSTOM_COMMAND, false, 1, null));
                    DownloadViewModel.updateUrl$default(downloadViewModel2, it, false, 2, null);
                }
            }, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$15$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Downloader.INSTANCE.cancelDownload();
                }
            }, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$15$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Downloader.INSTANCE.openDownloadResult();
                }
            }, new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$15$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    DownloadViewModel.updateUrl$default(downloadViewModel2, url, false, 2, null);
                }
            }, false, ComposableSingletons$DownloadPageKt.INSTANCE.m7336getLambda1$app_debug(), $composer2, ($dirty << 27) & 1879048192, (($dirty >> 3) & 14) | 12610560 | (($dirty >> 9) & 112), 65536);
            boolean zDownloadPage$lambda$11 = DownloadPage$lambda$11(showDownloadDialog$delegate);
            $composer2.startReplaceGroup(-346308838);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            downloadViewModel3 = downloadViewModel2;
            boolean invalid$iv6 = $composer2.changed(checkPermissionOrDownload);
            Object value$iv12 = $composer2.rememberedValue();
            if (invalid$iv6 || value$iv12 == Composer.INSTANCE.getEmpty()) {
                value$iv12 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$15$5$1
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
                        checkPermissionOrDownload.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv12);
            }
            Function0 function23 = (Function0) value$iv12;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-346308774);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPage.kt#9igjgp");
            boolean invalid$iv7 = $composer2.changed(showDownloadDialog$delegate);
            Object value$iv13 = $composer2.rememberedValue();
            if (invalid$iv7 || value$iv13 == Composer.INSTANCE.getEmpty()) {
                value$iv13 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPage$15$6$1
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
                        DownloadPageKt.DownloadPage$lambda$12(showDownloadDialog$delegate, false);
                    }
                };
                $composer2.updateRememberedValue(value$iv13);
            }
            $composer2.endReplaceGroup();
            DownloadSettingsDialogKt.DownloadSettingDialog(useDialog, zDownloadPage$lambda$11, false, function12, function23, (Function0) value$iv13, $composer2, ($dirty >> 6) & 7168, 4);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = function22;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function24 = function11;
            final Function0<Unit> function25 = function6;
            final Function0<Unit> function26 = function14;
            final Function0<Unit> function27 = function8;
            final Function0<Unit> function28 = function13;
            final Function1<? super String, Unit> function29 = function12;
            final DownloadViewModel downloadViewModel4 = downloadViewModel3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPage.16
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

                public final void invoke(Composer composer, int i11) {
                    DownloadPageKt.DownloadPage(function24, function25, function26, function27, function28, function29, downloadViewModel4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Downloader.State DownloadPage$lambda$0(State<? extends Downloader.State> state) {
        Object thisObj$iv = state.getValue();
        return (Downloader.State) thisObj$iv;
    }

    private static final Downloader.DownloadTaskItem DownloadPage$lambda$1(State<Downloader.DownloadTaskItem> state) {
        Object thisObj$iv = state.getValue();
        return (Downloader.DownloadTaskItem) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadViewModel.ViewState DownloadPage$lambda$2(State<DownloadViewModel.ViewState> state) {
        Object thisObj$iv = state.getValue();
        return (DownloadViewModel.ViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaylistResult DownloadPage$lambda$3(State<PlaylistResult> state) {
        Object thisObj$iv = state.getValue();
        return (PlaylistResult) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoInfo DownloadPage$lambda$4(State<VideoInfo> state) {
        Object thisObj$iv = state.getValue();
        return (VideoInfo) thisObj$iv;
    }

    private static final Downloader.ErrorState DownloadPage$lambda$5(State<? extends Downloader.ErrorState> state) {
        Object thisObj$iv = state.getValue();
        return (Downloader.ErrorState) thisObj$iv;
    }

    private static final int DownloadPage$lambda$6(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    private static final boolean DownloadPage$lambda$8(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadPage$lambda$9(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadPage$lambda$11(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadPage$lambda$12(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadPage$lambda$14(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadPage$lambda$15(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadPage$lambda$22(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadPage$lambda$23(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadPage$lambda$26(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:192:0x028e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x0290  */
    /* JADX WARN: Code duplicated, block: B:194:0x0294  */
    /* JADX WARN: Code duplicated, block: B:196:0x0298  */
    /* JADX WARN: Code duplicated, block: B:197:0x029c  */
    /* JADX WARN: Code duplicated, block: B:199:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:200:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:202:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:203:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:205:0x02af  */
    /* JADX WARN: Code duplicated, block: B:206:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:208:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:209:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:211:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:212:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:214:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:215:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:218:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:219:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:221:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:222:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:224:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:225:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:227:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:228:0x0304  */
    /* JADX WARN: Code duplicated, block: B:230:0x0308  */
    /* JADX WARN: Code duplicated, block: B:231:0x030c  */
    /* JADX WARN: Code duplicated, block: B:234:0x0314  */
    /* JADX WARN: Code duplicated, block: B:237:0x0357  */
    /* JADX WARN: Code duplicated, block: B:241:0x035e  */
    /* JADX WARN: Code duplicated, block: B:244:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:248:0x0416  */
    /* JADX WARN: Code duplicated, block: B:249:0x0455  */
    public static final void DownloadPageImpl(final Downloader.State downloaderState, final Downloader.DownloadTaskItem taskState, final DownloadViewModel.ViewState viewState, final Downloader.ErrorState errorState, boolean showVideoCard, boolean showOutput, boolean showDownloadProgress, int processCount, Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4, Function0<Unit> function5, Function0<Unit> function6, Function1<? super String, Unit> function7, boolean isPreview, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        int i2;
        boolean showVideoCard2;
        boolean showOutput2;
        final boolean showDownloadProgress2;
        int processCount2;
        final Function0<Unit> function8;
        Function0<Unit> function9;
        Function0<Unit> function10;
        Function0<Unit> function11;
        Function0<Unit> function12;
        Function0<Unit> function13;
        Function0<Unit> function14;
        Function1<? super String, Unit> function15;
        boolean isPreview2;
        boolean z2;
        Function0<Unit> function16;
        boolean showDownloadProgress3;
        Composer $composer2;
        Function0<Unit> function17;
        Function0<Unit> function18;
        Function1<? super String, Unit> function19;
        boolean isPreview3;
        int processCount3;
        Function0<Unit> function20;
        Function0<Unit> function21;
        Function0<Unit> function22;
        boolean showVideoCard3;
        boolean showOutput3;
        Function0<Unit> function23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(downloaderState, "downloaderState");
        Intrinsics.checkNotNullParameter(taskState, "taskState");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(errorState, "errorState");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-408180775);
        ComposerKt.sourceInformation($composer3, "C(DownloadPageImpl)P(3,16,17,4,15,14,13,12,2,7,6,8,11!1,10,9,5)324@13381L7,325@13438L7,329@13651L2992,405@16668L1223,433@17893L4583,329@13598L8878:DownloadPage.kt#y3famj");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(downloaderState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(taskState) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(viewState) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(errorState) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(showVideoCard) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(showOutput) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(showDownloadProgress) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(processCount) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        int i11 = i & 8192;
        if (i11 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changedInstance(function5) ? 2048 : 1024;
        }
        int i12 = i & 16384;
        if (i12 != 0) {
            $dirty1 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changedInstance(function6) ? 16384 : 8192;
        }
        int i13 = i & 32768;
        if (i13 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & 458752) == 0) {
            $dirty1 |= $composer3.changedInstance(function7) ? 131072 : 65536;
        }
        int i14 = i & 65536;
        if (i14 != 0) {
            $dirty1 |= 1572864;
            z = isPreview;
        } else if (($changed1 & 3670016) == 0) {
            z = isPreview;
            $dirty1 |= $composer3.changed(z) ? 1048576 : 524288;
        } else {
            z = isPreview;
        }
        if ((i & 131072) == 0) {
            if (($changed1 & 29360128) == 0) {
                i2 = $composer3.changedInstance(content) ? 8388608 : 4194304;
            }
            if (($dirty & 1533916891) != 306783378 && (23966811 & $dirty1) == 4793362 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                showVideoCard3 = showVideoCard;
                showOutput3 = showOutput;
                showDownloadProgress3 = showDownloadProgress;
                processCount3 = processCount;
                function16 = function0;
                function23 = function1;
                function20 = function2;
                function21 = function3;
                function17 = function4;
                function22 = function5;
                function18 = function6;
                function19 = function7;
                $composer2 = $composer3;
                isPreview3 = z;
            } else {
                if (i3 != 0) {
                    showVideoCard2 = false;
                } else {
                    showVideoCard2 = showVideoCard;
                }
                if (i4 != 0) {
                    showOutput2 = false;
                } else {
                    showOutput2 = showOutput;
                }
                if (i5 != 0) {
                    showDownloadProgress2 = false;
                } else {
                    showDownloadProgress2 = showDownloadProgress;
                }
                if (i6 != 0) {
                    processCount2 = 0;
                } else {
                    processCount2 = processCount;
                }
                if (i7 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.1
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
                    function8 = function0;
                }
                if (i8 != 0) {
                    function9 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.2
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
                    function9 = function1;
                }
                if (i9 != 0) {
                    function10 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.3
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
                    function10 = function2;
                }
                if (i10 != 0) {
                    function11 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.4
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
                    function11 = function3;
                }
                if ((i & 4096) != 0) {
                    function12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.5
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
                    function12 = function4;
                }
                if (i11 != 0) {
                    function13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.6
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
                    function13 = function5;
                }
                if (i12 != 0) {
                    function14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.7
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
                    function14 = function6;
                }
                if (i13 != 0) {
                    function15 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.8
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    };
                } else {
                    function15 = function7;
                }
                if (i14 != 0) {
                    isPreview2 = false;
                } else {
                    isPreview2 = z;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-408180775, $dirty, $dirty1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl (DownloadPage.kt:323)");
                }
                ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localView);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final View view = (View) objConsume;
                ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localClipboardManager);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final ClipboardManager clipboardManager = (ClipboardManager) objConsume2;
                if (!(downloaderState instanceof Downloader.State.DownloadingPlaylist) || (downloaderState instanceof Downloader.State.DownloadingVideo)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                final boolean showCancelButton = z2;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                final Function0<Unit> function24 = function9;
                final int i15 = processCount2;
                final Function0<Unit> function25 = function11;
                final Function0<Unit> function26 = function10;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-748307811, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9
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
                        ComposerKt.sourceInformation($composer4, "C330@13748L824,353@14584L2052,330@13661L2976:DownloadPage.kt#y3famj");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-748307811, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:330)");
                        }
                        Function2<Composer, Integer, Unit> function2M7345getLambda2$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7345getLambda2$app_debug();
                        Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, 2, null);
                        final View view2 = view;
                        final Function0<Unit> function27 = function24;
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(2076488215, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1
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
                                ComposerKt.sourceInformation($composer5, "C332@13798L22,333@13873L38,338@14093L468,331@13762L799:DownloadPage.kt#y3famj");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2076488215, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous> (DownloadPage.kt:331)");
                                    }
                                    TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                    PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                    Function3<CaretScope, Composer, Integer, Unit> function3M7347getLambda4$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7347getLambda4$app_debug();
                                    final View view3 = view2;
                                    final Function0<Unit> function28 = function27;
                                    TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7347getLambda4$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(593452508, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer6, int $changed4) {
                                            ComposerKt.sourceInformation($composer6, "C339@14111L436:DownloadPage.kt#y3famj");
                                            if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(593452508, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:339)");
                                                }
                                                final View view4 = view3;
                                                final Function0<Unit> function29 = function28;
                                                IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1.1.1
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
                                                        HapticFeedback.INSTANCE.slightHapticFeedback(view4);
                                                        function29.invoke();
                                                    }
                                                }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7348getLambda5$app_debug(), $composer6, 196656, 28);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }, $composer5, 54), $composer5, 1572912, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54);
                        final int i16 = i15;
                        final View view3 = view;
                        final Function0<Unit> function28 = function25;
                        final Function0<Unit> function29 = function26;
                        AppBarKt.m1923TopAppBarGHTll3U(function2M7345getLambda2$app_debug, modifierM870paddingVpY3zN4$default, composableLambdaRememberComposableLambda2, ComposableLambdaKt.rememberComposableLambda(1145029966, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TopAppBar, Composer $composer5, int $changed3) {
                                Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                                ComposerKt.sourceInformation($composer5, "C354@14616L287,362@14905L902,354@14598L1209,384@15839L22,385@15914L38,390@16143L483,384@15820L806:DownloadPage.kt#y3famj");
                                if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1145029966, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous> (DownloadPage.kt:354)");
                                    }
                                    final int i17 = i16;
                                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(173801430, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                            invoke(boxScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(BoxScope BadgedBox, Composer $composer6, int $changed4) {
                                            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                            ComposerKt.sourceInformation($composer6, "C361@14864L25,356@14676L213:DownloadPage.kt#y3famj");
                                            if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(173801430, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:355)");
                                                }
                                                if (i17 > 0) {
                                                    Modifier modifierM828offsetVpY3zN4 = OffsetKt.m828offsetVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(-16), C1979Dp.m6801constructorimpl(8));
                                                    final int i18 = i17;
                                                    BadgeKt.m1939BadgeeopBjH0(modifierM828offsetVpY3zN4, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-2068628706, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                                            invoke(rowScope, composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(RowScope Badge, Composer $composer7, int $changed5) {
                                                            Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                            ComposerKt.sourceInformation($composer7, "C361@14866L21:DownloadPage.kt#y3famj");
                                                            if (($changed5 & 81) == 16 && $composer7.getSkipping()) {
                                                                $composer7.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-2068628706, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:361)");
                                                            }
                                                            TextKt.m2817Text4IGK_g(String.valueOf(i18), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer7, 0, 0, 131070);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, $composer6, 54), $composer6, 3078, 6);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }, $composer5, 54);
                                    final View view4 = view3;
                                    final Function0<Unit> function30 = function28;
                                    BadgeKt.BadgedBox(composableLambdaRememberComposableLambda3, null, ComposableLambdaKt.rememberComposableLambda(1937015956, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                            invoke(boxScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(BoxScope BadgedBox, Composer $composer6, int $changed4) {
                                            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                            ComposerKt.sourceInformation($composer6, "C363@14942L22,364@15021L38,369@15266L527,363@14923L870:DownloadPage.kt#y3famj");
                                            if (($changed4 & 81) == 16 && $composer6.getSkipping()) {
                                                $composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1937015956, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:363)");
                                            }
                                            TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer6, 0, 7);
                                            PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer6, TooltipDefaults.$stable << 3, 1);
                                            Function3<CaretScope, Composer, Integer, Unit> function3M7350getLambda7$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7350getLambda7$app_debug();
                                            final View view5 = view4;
                                            final Function0<Unit> function31 = function30;
                                            TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7350getLambda7$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(448110319, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                    invoke(composer, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer $composer7, int $changed5) {
                                                    ComposerKt.sourceInformation($composer7, "C370@15288L487:DownloadPage.kt#y3famj");
                                                    if (($changed5 & 11) != 2 || !$composer7.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(448110319, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:370)");
                                                        }
                                                        final View view6 = view5;
                                                        final Function0<Unit> function32 = function31;
                                                        IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2.1.1
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
                                                                HapticFeedback.INSTANCE.slightHapticFeedback(view6);
                                                                function32.invoke();
                                                            }
                                                        }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7351getLambda8$app_debug(), $composer7, 196656, 28);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    $composer7.skipToGroupEnd();
                                                }
                                            }, $composer6, 54), $composer6, 1572912, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, $composer5, 54), $composer5, 390, 2);
                                    TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                    PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                    Function3<CaretScope, Composer, Integer, Unit> function3M7337getLambda10$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7337getLambda10$app_debug();
                                    final View view5 = view3;
                                    final Function0<Unit> function31 = function29;
                                    TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7337getLambda10$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(-1795586263, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer6, int $changed4) {
                                            ComposerKt.sourceInformation($composer6, "C391@16161L451:DownloadPage.kt#y3famj");
                                            if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1795586263, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:391)");
                                                }
                                                final View view6 = view5;
                                                final Function0<Unit> function32 = function31;
                                                IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.3.1
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
                                                        HapticFeedback.INSTANCE.slightHapticFeedback(view6);
                                                        function32.invoke();
                                                    }
                                                }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7338getLambda11$app_debug(), $composer6, 196656, 28);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }, $composer5, 54), $composer5, 1572912, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), 0.0f, null, null, null, $composer4, 3510, 240);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-711312608, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.10
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
                        ComposerKt.sourceInformation($composer4, "C409@16882L6,410@16939L11,411@17010L11,406@16678L1207:DownloadPage.kt#y3famj");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-711312608, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:406)");
                            }
                            Function0<Unit> function27 = function8;
                            Modifier.Companion $this$invoke_u24lambda_u240 = Modifier.INSTANCE;
                            FloatingActionButtonKt.m2267FloatingActionButtonXz6DiA(function27, showDownloadProgress2 ? $this$invoke_u24lambda_u240 : WindowInsetsPadding_androidKt.imePadding($this$invoke_u24lambda_u240), MaterialTheme.INSTANCE.getShapes($composer4, MaterialTheme.$stable).getLarge(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnPrimaryContainer(), null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7339getLambda12$app_debug(), $composer4, 12582912, 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54);
                final boolean z3 = showDownloadProgress2;
                final boolean z4 = showVideoCard2;
                final Function0<Unit> function27 = function8;
                function16 = function8;
                final Function0<Unit> function28 = function13;
                final Function1<? super String, Unit> function29 = function15;
                showDownloadProgress3 = showDownloadProgress2;
                final boolean z5 = showOutput2;
                final Function0<Unit> function30 = function14;
                final boolean z6 = isPreview2;
                $composer2 = $composer3;
                ScaffoldKt.m2530ScaffoldTvnljyQ(modifierFillMaxSize$default, composableLambdaRememberComposableLambda, null, null, composableLambdaRememberComposableLambda2, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(912165864, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.11
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

                    /* JADX WARN: Code duplicated, block: B:35:0x01bd  */
                    /* JADX WARN: Code duplicated, block: B:36:0x01c6  */
                    /* JADX WARN: Code duplicated, block: B:39:0x01d0  */
                    /* JADX WARN: Code duplicated, block: B:40:0x01da  */
                    /* JADX WARN: Code duplicated, block: B:43:0x0292  */
                    /* JADX WARN: Code duplicated, block: B:46:0x029e  */
                    /* JADX WARN: Code duplicated, block: B:47:0x02a4  */
                    /* JADX WARN: Code duplicated, block: B:60:0x0345  */
                    /* JADX WARN: Code duplicated, block: B:65:0x0357  */
                    /* JADX WARN: Code duplicated, block: B:78:0x03c0  */
                    /* JADX WARN: Code duplicated, block: B:81:0x0438  */
                    /* JADX WARN: Code duplicated, block: B:82:0x043a  */
                    /* JADX WARN: Code duplicated, block: B:86:0x0442  */
                    /* JADX WARN: Code duplicated, block: B:89:0x04fe  */
                    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
                    public final void invoke(PaddingValues it, Composer $composer4, int $changed2) {
                        Function0<ComposeUiNode> function31;
                        MeasurePolicy measurePolicy$iv;
                        int currentItem;
                        int itemCount;
                        int compositeKeyHash$iv$iv;
                        Function0<ComposeUiNode> constructor;
                        Function0<ComposeUiNode> function32;
                        Composer $this$Layout_u24lambda_u240$iv$iv;
                        boolean z7;
                        boolean z8;
                        boolean invalid$iv;
                        Object value$iv;
                        boolean z9;
                        boolean z10;
                        boolean z11;
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation($composer4, "C438@18035L21,434@17903L4567:DownloadPage.kt#y3famj");
                        int $dirty2 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty2 |= $composer4.changed(it) ? 4 : 2;
                        }
                        if (($dirty2 & 91) != 18 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(912165864, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:434)");
                            }
                            Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, it), 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                            final Downloader.State $this$invoke_u24lambda_u245_u24lambda_u240 = downloaderState;
                            boolean z12 = showCancelButton;
                            DownloadViewModel.ViewState viewState2 = viewState;
                            final Downloader.DownloadTaskItem $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243 = taskState;
                            boolean z13 = z3;
                            boolean z14 = z4;
                            final Downloader.ErrorState errorState2 = errorState;
                            Function0<Unit> function33 = function27;
                            final Function0<Unit> function34 = function28;
                            final Function1<String, Unit> function35 = function29;
                            Function2<Composer, Integer, Unit> function36 = content;
                            boolean z15 = z5;
                            final Function0<Unit> function37 = function30;
                            final boolean z16 = z6;
                            final View view2 = view;
                            final ClipboardManager clipboardManager2 = clipboardManager;
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function31 = constructor2;
                                $composer4.createNode(function31);
                            } else {
                                function31 = constructor2;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                                measurePolicy$iv = measurePolicy$iv2;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                int i16 = ($changed$iv$iv$iv >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int i17 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1681337462, "C440@18082L569,450@18666L3794:DownloadPage.kt#y3famj");
                                boolean z17 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.FetchingInfo;
                                boolean z18 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist;
                                if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                    currentItem = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getCurrentItem();
                                } else {
                                    currentItem = 0;
                                }
                                if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                    itemCount = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getItemCount();
                                } else {
                                    itemCount = 0;
                                }
                                DownloadPageKt.TitleWithProgressIndicator(z17, z12, z18, currentItem, itemCount, true, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0);
                                Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0.0f, C1979Dp.m6801constructorimpl(32), 0.0f, 0.0f, 13, null);
                                ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                int $changed$iv$iv2 = (6 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                                constructor = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    function32 = constructor;
                                    $composer4.createNode(function32);
                                } else {
                                    function32 = constructor;
                                    $composer4.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i18 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                int $changed3 = ((6 >> 6) & 112) | 6;
                                ColumnScope $this$invoke_u24lambda_u245_u24lambda_u244 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1223967517, "C464@19348L28,456@18906L470,502@21225L468,502@21154L539,512@21710L9,527@22332L17,528@22366L21,529@22404L42:DownloadPage.kt#y3famj");
                                String url = viewState2.getUrl();
                                float progress = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgress();
                                if (z13 || z14) {
                                    z7 = false;
                                } else {
                                    z7 = true;
                                }
                                boolean z19 = !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE);
                                if (z12 || z14) {
                                    z8 = false;
                                } else {
                                    z8 = true;
                                }
                                $composer4.startReplaceGroup(-1223967075);
                                ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                                invalid$iv = $composer4.changed(function35);
                                Object it$iv = $composer4.rememberedValue();
                                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                            invoke2(str);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String url2) {
                                            Intrinsics.checkNotNullParameter(url2, "url");
                                            function35.invoke(url2);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = it$iv;
                                }
                                $composer4.endReplaceGroup();
                                DownloadPageKt.InputUrl(url, z19, z7, progress, function33, z8, function34, (Function1) value$iv, $composer4, 0, 0);
                                $composer4.startReplaceGroup(-1223967029);
                                ComposerKt.sourceInformation($composer4, "*469@19546L873,467@19432L987,492@20742L377,487@20440L679");
                                if (z13 || !z14) {
                                    z9 = false;
                                } else {
                                    z9 = true;
                                }
                                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u244, z9, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-788117710, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                        invoke(animatedVisibilityScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed4) {
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation($composer5, "C470@19572L825:DownloadPage.kt#y3famj");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-788117710, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:470)");
                                        }
                                        Downloader.DownloadTaskItem downloadTaskItem = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243;
                                        Downloader.State state = $this$invoke_u24lambda_u245_u24lambda_u240;
                                        Function0<Unit> function38 = function34;
                                        Function0<Unit> function39 = function37;
                                        boolean z20 = z16;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        Modifier modifier$iv3 = Modifier.INSTANCE;
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                        int $changed$iv$iv3 = (0 << 3) & 112;
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
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                        }
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i19 = ($changed$iv$iv$iv3 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i20 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 1302231300, "C471@19608L762:DownloadPage.kt#y3famj");
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        String title = downloadTaskItem.getTitle();
                                        String uploader = downloadTaskItem.getUploader();
                                        String thumbnailUrl = downloadTaskItem.getThumbnailUrl();
                                        float progress2 = downloadTaskItem.getProgress();
                                        boolean propagateMinConstraints$iv = (state instanceof Downloader.State.DownloadingPlaylist) || (state instanceof Downloader.State.DownloadingVideo);
                                        VideoCardKt.VideoCard(companion, title, uploader, thumbnailUrl, propagateMinConstraints$iv, function38, function39, progress2, downloadTaskItem.getFileSizeApprox(), downloadTaskItem.getDuration(), z20, $composer5, 6, 0, 0);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        $composer5.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer4, 54), $composer4, ($changed3 & 14) | 1572864, 30);
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                EnterTransition enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                                ExitTransition exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                                if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText().length() > 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (z10 || !z15) {
                                    z11 = false;
                                } else {
                                    z11 = true;
                                }
                                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u244, z11, modifierFillMaxWidth$default, enterTransitionPlus, exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(19914793, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                        invoke(animatedVisibilityScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed4) {
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation($composer5, "C498@21050L10,493@20768L329:DownloadPage.kt#y3famj");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(19914793, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:493)");
                                        }
                                        TextKt.m2817Text4IGK_g($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText(), PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium(), $composer5, 48, 3120, 55292);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer4, 54), $composer4, ($changed3 & 14) | 1600896, 16);
                                Unit unit = Unit.INSTANCE;
                                $composer4.endReplaceGroup();
                                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u244, !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1884572836, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                        invoke(animatedVisibilityScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed4) {
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation($composer5, "C504@21304L5,503@21247L428:DownloadPage.kt#y3famj");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1884572836, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:503)");
                                        }
                                        String title = errorState2.getTitle($composer5, 0);
                                        String report = errorState2.getReport();
                                        final View view3 = view2;
                                        final ClipboardManager clipboardManager3 = clipboardManager2;
                                        final Downloader.ErrorState errorState3 = errorState2;
                                        DownloadPageKt.ErrorMessage(null, title, report, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3.1
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
                                                HapticFeedback.INSTANCE.longPressHapticFeedback(view3);
                                                clipboardManager3.setText(new AnnotatedString(App.INSTANCE.getVersionReport() + "\nURL: " + errorState3.getUrl() + IOUtils.LINE_SEPARATOR_UNIX + errorState3.getReport(), null, null, 6, null));
                                                ToastUtil.INSTANCE.makeToast(C3070R.string.error_copied);
                                            }
                                        }, $composer5, 0, 1);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer4, 54), $composer4, ($changed3 & 14) | 1572864, 30);
                                function36.invoke($composer4, 0);
                                DownloadPageKt.FooterSignature(null, $composer4, 0, 1);
                                CommonComponentsKt.NavigationBarSpacer(null, $composer4, 0, 1);
                                SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(160)), $composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
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
                            measurePolicy$iv = measurePolicy$iv2;
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i19 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i110 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1681337462, "C440@18082L569,450@18666L3794:DownloadPage.kt#y3famj");
                            boolean z110 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.FetchingInfo;
                            boolean z111 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist;
                            if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                currentItem = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getCurrentItem();
                            } else {
                                currentItem = 0;
                            }
                            if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                itemCount = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getItemCount();
                            } else {
                                itemCount = 0;
                            }
                            DownloadPageKt.TitleWithProgressIndicator(z110, z12, z111, currentItem, itemCount, true, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0);
                            Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0.0f, C1979Dp.m6801constructorimpl(32), 0.0f, 0.0f, 13, null);
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv3 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function32 = constructor;
                                $composer4.createNode(function32);
                            } else {
                                function32 = constructor;
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                            int i111 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            int $changed4 = ((6 >> 6) & 112) | 6;
                            ColumnScope $this$invoke_u24lambda_u245_u24lambda_u245 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1223967517, "C464@19348L28,456@18906L470,502@21225L468,502@21154L539,512@21710L9,527@22332L17,528@22366L21,529@22404L42:DownloadPage.kt#y3famj");
                            String url2 = viewState2.getUrl();
                            float progress2 = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgress();
                            if (z13) {
                                z7 = false;
                            } else {
                                z7 = false;
                            }
                            boolean z112 = !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE);
                            if (z12) {
                                z8 = false;
                            } else {
                                z8 = false;
                            }
                            $composer4.startReplaceGroup(-1223967075);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                            invalid$iv = $composer4.changed(function35);
                            Object it$iv2 = $composer4.rememberedValue();
                            if (!invalid$iv) {
                            }
                            value$iv = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                    invoke2(str);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String url3) {
                                    Intrinsics.checkNotNullParameter(url3, "url");
                                    function35.invoke(url3);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                            $composer4.endReplaceGroup();
                            DownloadPageKt.InputUrl(url2, z112, z7, progress2, function33, z8, function34, (Function1) value$iv, $composer4, 0, 0);
                            $composer4.startReplaceGroup(-1223967029);
                            ComposerKt.sourceInformation($composer4, "*469@19546L873,467@19432L987,492@20742L377,487@20440L679");
                            if (z13) {
                                z9 = false;
                            } else {
                                z9 = false;
                            }
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u245, z9, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-788117710, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed5) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C470@19572L825:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-788117710, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:470)");
                                    }
                                    Downloader.DownloadTaskItem downloadTaskItem = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243;
                                    Downloader.State state = $this$invoke_u24lambda_u245_u24lambda_u240;
                                    Function0<Unit> function38 = function34;
                                    Function0<Unit> function39 = function37;
                                    boolean z20 = z16;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    Modifier modifier$iv4 = Modifier.INSTANCE;
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv4 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv4 = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv4);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
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
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i112 = ($changed$iv$iv$iv4 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i20 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 1302231300, "C471@19608L762:DownloadPage.kt#y3famj");
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    String title = downloadTaskItem.getTitle();
                                    String uploader = downloadTaskItem.getUploader();
                                    String thumbnailUrl = downloadTaskItem.getThumbnailUrl();
                                    float progress3 = downloadTaskItem.getProgress();
                                    boolean propagateMinConstraints$iv = (state instanceof Downloader.State.DownloadingPlaylist) || (state instanceof Downloader.State.DownloadingVideo);
                                    VideoCardKt.VideoCard(companion, title, uploader, thumbnailUrl, propagateMinConstraints$iv, function38, function39, progress3, downloadTaskItem.getFileSizeApprox(), downloadTaskItem.getDuration(), z20, $composer5, 6, 0, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed4 & 14) | 1572864, 30);
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            EnterTransition enterTransitionPlus2 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            ExitTransition exitTransitionPlus2 = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText().length() > 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                z11 = false;
                            } else {
                                z11 = false;
                            }
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u245, z11, modifierFillMaxWidth$default2, enterTransitionPlus2, exitTransitionPlus2, (String) null, ComposableLambdaKt.rememberComposableLambda(19914793, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$2
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed5) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C498@21050L10,493@20768L329:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(19914793, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:493)");
                                    }
                                    TextKt.m2817Text4IGK_g($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText(), PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium(), $composer5, 48, 3120, 55292);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed4 & 14) | 1600896, 16);
                            Unit unit2 = Unit.INSTANCE;
                            $composer4.endReplaceGroup();
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u245, !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1884572836, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed5) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C504@21304L5,503@21247L428:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1884572836, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:503)");
                                    }
                                    String title = errorState2.getTitle($composer5, 0);
                                    String report = errorState2.getReport();
                                    final View view3 = view2;
                                    final ClipboardManager clipboardManager3 = clipboardManager2;
                                    final Downloader.ErrorState errorState3 = errorState2;
                                    DownloadPageKt.ErrorMessage(null, title, report, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3.1
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
                                            HapticFeedback.INSTANCE.longPressHapticFeedback(view3);
                                            clipboardManager3.setText(new AnnotatedString(App.INSTANCE.getVersionReport() + "\nURL: " + errorState3.getUrl() + IOUtils.LINE_SEPARATOR_UNIX + errorState3.getReport(), null, null, 6, null));
                                            ToastUtil.INSTANCE.makeToast(C3070R.string.error_copied);
                                        }
                                    }, $composer5, 0, 1);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed4 & 14) | 1572864, 30);
                            function36.invoke($composer4, 0);
                            DownloadPageKt.FooterSignature(null, $composer4, 0, 1);
                            CommonComponentsKt.NavigationBarSpacer(null, $composer4, 0, 1);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(160)), $composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
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
                }, $composer2, 54), $composer2, 805330998, 492);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function17 = function12;
                function18 = function14;
                function19 = function15;
                isPreview3 = isPreview2;
                processCount3 = processCount2;
                function20 = function10;
                function21 = function11;
                function22 = function13;
                showVideoCard3 = showVideoCard2;
                showOutput3 = showOutput2;
                function23 = function9;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z7 = showVideoCard3;
                final boolean z8 = showOutput3;
                final boolean z9 = showDownloadProgress3;
                final int i16 = processCount3;
                final Function0<Unit> function31 = function16;
                final Function0<Unit> function32 = function23;
                final Function0<Unit> function33 = function20;
                final Function0<Unit> function34 = function21;
                final Function0<Unit> function35 = function17;
                final Function0<Unit> function36 = function22;
                final Function0<Unit> function37 = function18;
                final Function1<? super String, Unit> function38 = function19;
                final boolean z10 = isPreview3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.12
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

                    public final void invoke(Composer composer, int i17) {
                        DownloadPageKt.DownloadPageImpl(downloaderState, taskState, viewState, errorState, z7, z8, z9, i16, function31, function32, function33, function34, function35, function36, function37, function38, z10, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                    }
                });
            }
        }
        i2 = 12582912;
        $dirty1 |= i2;
        if (($dirty & 1533916891) != 306783378) {
            if (i3 != 0) {
                showVideoCard2 = false;
            } else {
                showVideoCard2 = showVideoCard;
            }
            if (i4 != 0) {
                showOutput2 = false;
            } else {
                showOutput2 = showOutput;
            }
            if (i5 != 0) {
                showDownloadProgress2 = false;
            } else {
                showDownloadProgress2 = showDownloadProgress;
            }
            if (i6 != 0) {
                processCount2 = 0;
            } else {
                processCount2 = processCount;
            }
            if (i7 != 0) {
                function8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.1
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
                function8 = function0;
            }
            if (i8 != 0) {
                function9 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.2
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
                function9 = function1;
            }
            if (i9 != 0) {
                function10 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.3
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
                function10 = function2;
            }
            if (i10 != 0) {
                function11 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.4
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
                function11 = function3;
            }
            if ((i & 4096) != 0) {
                function12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.5
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
                function12 = function4;
            }
            if (i11 != 0) {
                function13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.6
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
                function13 = function5;
            }
            if (i12 != 0) {
                function14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.7
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
                function14 = function6;
            }
            if (i13 != 0) {
                function15 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.8
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                };
            } else {
                function15 = function7;
            }
            if (i14 != 0) {
                isPreview2 = false;
            } else {
                isPreview2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-408180775, $dirty, $dirty1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl (DownloadPage.kt:323)");
            }
            ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localView2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final View view2 = (View) objConsume3;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager2 = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer3.consume(localClipboardManager2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final ClipboardManager clipboardManager2 = (ClipboardManager) objConsume4;
            if (downloaderState instanceof Downloader.State.DownloadingPlaylist) {
                z2 = true;
            } else {
                z2 = true;
            }
            final boolean showCancelButton2 = z2;
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            final Function0<Unit> function210 = function9;
            final int i17 = processCount2;
            final Function0<Unit> function211 = function11;
            final Function0<Unit> function212 = function10;
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-748307811, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9
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
                    ComposerKt.sourceInformation($composer4, "C330@13748L824,353@14584L2052,330@13661L2976:DownloadPage.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-748307811, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:330)");
                    }
                    Function2<Composer, Integer, Unit> function2M7345getLambda2$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7345getLambda2$app_debug();
                    Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, 2, null);
                    final View view3 = view2;
                    final Function0<Unit> function213 = function210;
                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(2076488215, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1
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
                            ComposerKt.sourceInformation($composer5, "C332@13798L22,333@13873L38,338@14093L468,331@13762L799:DownloadPage.kt#y3famj");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2076488215, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous> (DownloadPage.kt:331)");
                                }
                                TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                Function3<CaretScope, Composer, Integer, Unit> function3M7347getLambda4$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7347getLambda4$app_debug();
                                final View view4 = view3;
                                final Function0<Unit> function214 = function213;
                                TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7347getLambda4$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(593452508, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer6, int $changed4) {
                                        ComposerKt.sourceInformation($composer6, "C339@14111L436:DownloadPage.kt#y3famj");
                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(593452508, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:339)");
                                            }
                                            final View view5 = view4;
                                            final Function0<Unit> function215 = function214;
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1.1.1
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
                                                    HapticFeedback.INSTANCE.slightHapticFeedback(view5);
                                                    function215.invoke();
                                                }
                                            }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7348getLambda5$app_debug(), $composer6, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }, $composer5, 54), $composer5, 1572912, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54);
                    final int i18 = i17;
                    final View view4 = view2;
                    final Function0<Unit> function214 = function211;
                    final Function0<Unit> function215 = function212;
                    AppBarKt.m1923TopAppBarGHTll3U(function2M7345getLambda2$app_debug, modifierM870paddingVpY3zN4$default, composableLambdaRememberComposableLambda4, ComposableLambdaKt.rememberComposableLambda(1145029966, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TopAppBar, Composer $composer5, int $changed3) {
                            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                            ComposerKt.sourceInformation($composer5, "C354@14616L287,362@14905L902,354@14598L1209,384@15839L22,385@15914L38,390@16143L483,384@15820L806:DownloadPage.kt#y3famj");
                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1145029966, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous> (DownloadPage.kt:354)");
                                }
                                final int i19 = i18;
                                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(173801430, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                        invoke(boxScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer $composer6, int $changed4) {
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        ComposerKt.sourceInformation($composer6, "C361@14864L25,356@14676L213:DownloadPage.kt#y3famj");
                                        if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(173801430, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:355)");
                                            }
                                            if (i19 > 0) {
                                                Modifier modifierM828offsetVpY3zN4 = OffsetKt.m828offsetVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(-16), C1979Dp.m6801constructorimpl(8));
                                                final int i110 = i19;
                                                BadgeKt.m1939BadgeeopBjH0(modifierM828offsetVpY3zN4, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-2068628706, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                                        invoke(rowScope, composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(RowScope Badge, Composer $composer7, int $changed5) {
                                                        Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                        ComposerKt.sourceInformation($composer7, "C361@14866L21:DownloadPage.kt#y3famj");
                                                        if (($changed5 & 81) == 16 && $composer7.getSkipping()) {
                                                            $composer7.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2068628706, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:361)");
                                                        }
                                                        TextKt.m2817Text4IGK_g(String.valueOf(i110), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer7, 0, 0, 131070);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, $composer6, 54), $composer6, 3078, 6);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }, $composer5, 54);
                                final View view5 = view4;
                                final Function0<Unit> function39 = function214;
                                BadgeKt.BadgedBox(composableLambdaRememberComposableLambda5, null, ComposableLambdaKt.rememberComposableLambda(1937015956, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                        invoke(boxScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer $composer6, int $changed4) {
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        ComposerKt.sourceInformation($composer6, "C363@14942L22,364@15021L38,369@15266L527,363@14923L870:DownloadPage.kt#y3famj");
                                        if (($changed4 & 81) == 16 && $composer6.getSkipping()) {
                                            $composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1937015956, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:363)");
                                        }
                                        TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer6, 0, 7);
                                        PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer6, TooltipDefaults.$stable << 3, 1);
                                        Function3<CaretScope, Composer, Integer, Unit> function3M7350getLambda7$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7350getLambda7$app_debug();
                                        final View view6 = view5;
                                        final Function0<Unit> function310 = function39;
                                        TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7350getLambda7$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(448110319, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer7, int $changed5) {
                                                ComposerKt.sourceInformation($composer7, "C370@15288L487:DownloadPage.kt#y3famj");
                                                if (($changed5 & 11) != 2 || !$composer7.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(448110319, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:370)");
                                                    }
                                                    final View view7 = view6;
                                                    final Function0<Unit> function311 = function310;
                                                    IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2.1.1
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
                                                            HapticFeedback.INSTANCE.slightHapticFeedback(view7);
                                                            function311.invoke();
                                                        }
                                                    }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7351getLambda8$app_debug(), $composer7, 196656, 28);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer7.skipToGroupEnd();
                                            }
                                        }, $composer6, 54), $composer6, 1572912, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer5, 54), $composer5, 390, 2);
                                TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                Function3<CaretScope, Composer, Integer, Unit> function3M7337getLambda10$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7337getLambda10$app_debug();
                                final View view6 = view4;
                                final Function0<Unit> function310 = function215;
                                TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7337getLambda10$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(-1795586263, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer6, int $changed4) {
                                        ComposerKt.sourceInformation($composer6, "C391@16161L451:DownloadPage.kt#y3famj");
                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1795586263, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:391)");
                                            }
                                            final View view7 = view6;
                                            final Function0<Unit> function311 = function310;
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.3.1
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
                                                    HapticFeedback.INSTANCE.slightHapticFeedback(view7);
                                                    function311.invoke();
                                                }
                                            }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7338getLambda11$app_debug(), $composer6, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }, $composer5, 54), $composer5, 1572912, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54), 0.0f, null, null, null, $composer4, 3510, 240);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-711312608, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.10
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
                    ComposerKt.sourceInformation($composer4, "C409@16882L6,410@16939L11,411@17010L11,406@16678L1207:DownloadPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-711312608, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:406)");
                        }
                        Function0<Unit> function213 = function8;
                        Modifier.Companion $this$invoke_u24lambda_u240 = Modifier.INSTANCE;
                        FloatingActionButtonKt.m2267FloatingActionButtonXz6DiA(function213, showDownloadProgress2 ? $this$invoke_u24lambda_u240 : WindowInsetsPadding_androidKt.imePadding($this$invoke_u24lambda_u240), MaterialTheme.INSTANCE.getShapes($composer4, MaterialTheme.$stable).getLarge(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnPrimaryContainer(), null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7339getLambda12$app_debug(), $composer4, 12582912, 96);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54);
            final boolean z11 = showDownloadProgress2;
            final boolean z12 = showVideoCard2;
            final Function0<Unit> function213 = function8;
            function16 = function8;
            final Function0<Unit> function214 = function13;
            final Function1<? super String, Unit> function215 = function15;
            showDownloadProgress3 = showDownloadProgress2;
            final boolean z13 = showOutput2;
            final Function0<Unit> function39 = function14;
            final boolean z14 = isPreview2;
            $composer2 = $composer3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(modifierFillMaxSize$default2, composableLambdaRememberComposableLambda3, null, null, composableLambdaRememberComposableLambda4, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(912165864, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.11
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

                /* JADX WARN: Code duplicated, block: B:35:0x01bd  */
                /* JADX WARN: Code duplicated, block: B:36:0x01c6  */
                /* JADX WARN: Code duplicated, block: B:39:0x01d0  */
                /* JADX WARN: Code duplicated, block: B:40:0x01da  */
                /* JADX WARN: Code duplicated, block: B:43:0x0292  */
                /* JADX WARN: Code duplicated, block: B:46:0x029e  */
                /* JADX WARN: Code duplicated, block: B:47:0x02a4  */
                /* JADX WARN: Code duplicated, block: B:60:0x0345  */
                /* JADX WARN: Code duplicated, block: B:65:0x0357  */
                /* JADX WARN: Code duplicated, block: B:78:0x03c0  */
                /* JADX WARN: Code duplicated, block: B:81:0x0438  */
                /* JADX WARN: Code duplicated, block: B:82:0x043a  */
                /* JADX WARN: Code duplicated, block: B:86:0x0442  */
                /* JADX WARN: Code duplicated, block: B:89:0x04fe  */
                /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
                public final void invoke(PaddingValues it, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function310;
                    MeasurePolicy measurePolicy$iv;
                    int currentItem;
                    int itemCount;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function311;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    boolean z15;
                    boolean z16;
                    boolean invalid$iv;
                    Object value$iv;
                    boolean z17;
                    boolean z18;
                    boolean z19;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C438@18035L21,434@17903L4567:DownloadPage.kt#y3famj");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer4.changed(it) ? 4 : 2;
                    }
                    if (($dirty2 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(912165864, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:434)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, it), 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                        final Downloader.State $this$invoke_u24lambda_u245_u24lambda_u240 = downloaderState;
                        boolean z110 = showCancelButton2;
                        DownloadViewModel.ViewState viewState2 = viewState;
                        final Downloader.DownloadTaskItem $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243 = taskState;
                        boolean z111 = z11;
                        boolean z112 = z12;
                        final Downloader.ErrorState errorState2 = errorState;
                        Function0<Unit> function312 = function213;
                        final Function0<Unit> function313 = function214;
                        final Function1<? super String, Unit> function314 = function215;
                        Function2<Composer, Integer, Unit> function315 = content;
                        boolean z113 = z13;
                        final Function0<Unit> function316 = function39;
                        final boolean z114 = z14;
                        final View view3 = view2;
                        final ClipboardManager clipboardManager3 = clipboardManager2;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function310 = constructor2;
                            $composer4.createNode(function310);
                        } else {
                            function310 = constructor2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                            measurePolicy$iv = measurePolicy$iv2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i19 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i110 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1681337462, "C440@18082L569,450@18666L3794:DownloadPage.kt#y3famj");
                            boolean z115 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.FetchingInfo;
                            boolean z116 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist;
                            if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                currentItem = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getCurrentItem();
                            } else {
                                currentItem = 0;
                            }
                            if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                itemCount = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getItemCount();
                            } else {
                                itemCount = 0;
                            }
                            DownloadPageKt.TitleWithProgressIndicator(z115, z110, z116, currentItem, itemCount, true, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0);
                            Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0.0f, C1979Dp.m6801constructorimpl(32), 0.0f, 0.0f, 13, null);
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv3 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function311 = constructor;
                                $composer4.createNode(function311);
                            } else {
                                function311 = constructor;
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                            int i111 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            int $changed4 = ((6 >> 6) & 112) | 6;
                            ColumnScope $this$invoke_u24lambda_u245_u24lambda_u245 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1223967517, "C464@19348L28,456@18906L470,502@21225L468,502@21154L539,512@21710L9,527@22332L17,528@22366L21,529@22404L42:DownloadPage.kt#y3famj");
                            String url2 = viewState2.getUrl();
                            float progress2 = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgress();
                            if (z111 || z112) {
                                z15 = false;
                            } else {
                                z15 = true;
                            }
                            boolean z117 = !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE);
                            if (z110 || z112) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            $composer4.startReplaceGroup(-1223967075);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                            invalid$iv = $composer4.changed(function314);
                            Object it$iv2 = $composer4.rememberedValue();
                            if (!invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String url3) {
                                        Intrinsics.checkNotNullParameter(url3, "url");
                                        function314.invoke(url3);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv2;
                            }
                            $composer4.endReplaceGroup();
                            DownloadPageKt.InputUrl(url2, z117, z15, progress2, function312, z16, function313, (Function1) value$iv, $composer4, 0, 0);
                            $composer4.startReplaceGroup(-1223967029);
                            ComposerKt.sourceInformation($composer4, "*469@19546L873,467@19432L987,492@20742L377,487@20440L679");
                            if (z111 || !z112) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u245, z17, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-788117710, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed5) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C470@19572L825:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-788117710, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:470)");
                                    }
                                    Downloader.DownloadTaskItem downloadTaskItem = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243;
                                    Downloader.State state = $this$invoke_u24lambda_u245_u24lambda_u240;
                                    Function0<Unit> function317 = function313;
                                    Function0<Unit> function318 = function316;
                                    boolean z20 = z114;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    Modifier modifier$iv4 = Modifier.INSTANCE;
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv4 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv4 = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv4);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
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
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i112 = ($changed$iv$iv$iv4 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i20 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 1302231300, "C471@19608L762:DownloadPage.kt#y3famj");
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    String title = downloadTaskItem.getTitle();
                                    String uploader = downloadTaskItem.getUploader();
                                    String thumbnailUrl = downloadTaskItem.getThumbnailUrl();
                                    float progress3 = downloadTaskItem.getProgress();
                                    boolean propagateMinConstraints$iv = (state instanceof Downloader.State.DownloadingPlaylist) || (state instanceof Downloader.State.DownloadingVideo);
                                    VideoCardKt.VideoCard(companion, title, uploader, thumbnailUrl, propagateMinConstraints$iv, function317, function318, progress3, downloadTaskItem.getFileSizeApprox(), downloadTaskItem.getDuration(), z20, $composer5, 6, 0, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed4 & 14) | 1572864, 30);
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            EnterTransition enterTransitionPlus2 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            ExitTransition exitTransitionPlus2 = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText().length() > 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18 || !z113) {
                                z19 = false;
                            } else {
                                z19 = true;
                            }
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u245, z19, modifierFillMaxWidth$default2, enterTransitionPlus2, exitTransitionPlus2, (String) null, ComposableLambdaKt.rememberComposableLambda(19914793, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$2
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed5) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C498@21050L10,493@20768L329:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(19914793, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:493)");
                                    }
                                    TextKt.m2817Text4IGK_g($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText(), PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium(), $composer5, 48, 3120, 55292);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed4 & 14) | 1600896, 16);
                            Unit unit2 = Unit.INSTANCE;
                            $composer4.endReplaceGroup();
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u245, !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1884572836, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed5) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C504@21304L5,503@21247L428:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1884572836, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:503)");
                                    }
                                    String title = errorState2.getTitle($composer5, 0);
                                    String report = errorState2.getReport();
                                    final View view4 = view3;
                                    final ClipboardManager clipboardManager4 = clipboardManager3;
                                    final Downloader.ErrorState errorState3 = errorState2;
                                    DownloadPageKt.ErrorMessage(null, title, report, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3.1
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
                                            HapticFeedback.INSTANCE.longPressHapticFeedback(view4);
                                            clipboardManager4.setText(new AnnotatedString(App.INSTANCE.getVersionReport() + "\nURL: " + errorState3.getUrl() + IOUtils.LINE_SEPARATOR_UNIX + errorState3.getReport(), null, null, 6, null));
                                            ToastUtil.INSTANCE.makeToast(C3070R.string.error_copied);
                                        }
                                    }, $composer5, 0, 1);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed4 & 14) | 1572864, 30);
                            function315.invoke($composer4, 0);
                            DownloadPageKt.FooterSignature(null, $composer4, 0, 1);
                            CommonComponentsKt.NavigationBarSpacer(null, $composer4, 0, 1);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(160)), $composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
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
                        measurePolicy$iv = measurePolicy$iv2;
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i112 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                        int i113 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1681337462, "C440@18082L569,450@18666L3794:DownloadPage.kt#y3famj");
                        boolean z118 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.FetchingInfo;
                        boolean z119 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist;
                        if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                            currentItem = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getCurrentItem();
                        } else {
                            currentItem = 0;
                        }
                        if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                            itemCount = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getItemCount();
                        } else {
                            itemCount = 0;
                        }
                        DownloadPageKt.TitleWithProgressIndicator(z118, z110, z119, currentItem, itemCount, true, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0);
                        Modifier modifier$iv4 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0.0f, C1979Dp.m6801constructorimpl(32), 0.0f, 0.0f, 13, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv4 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function311 = constructor;
                            $composer4.createNode(function311);
                        } else {
                            function311 = constructor;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                        int i114 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        int $changed5 = ((6 >> 6) & 112) | 6;
                        ColumnScope $this$invoke_u24lambda_u245_u24lambda_u246 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1223967517, "C464@19348L28,456@18906L470,502@21225L468,502@21154L539,512@21710L9,527@22332L17,528@22366L21,529@22404L42:DownloadPage.kt#y3famj");
                        String url3 = viewState2.getUrl();
                        float progress3 = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgress();
                        if (z111) {
                            z15 = false;
                        } else {
                            z15 = false;
                        }
                        boolean z1110 = !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE);
                        if (z110) {
                            z16 = false;
                        } else {
                            z16 = false;
                        }
                        $composer4.startReplaceGroup(-1223967075);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                        invalid$iv = $composer4.changed(function314);
                        Object it$iv3 = $composer4.rememberedValue();
                        if (!invalid$iv) {
                        }
                        value$iv = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String url4) {
                                Intrinsics.checkNotNullParameter(url4, "url");
                                function314.invoke(url4);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                        $composer4.endReplaceGroup();
                        DownloadPageKt.InputUrl(url3, z1110, z15, progress3, function312, z16, function313, (Function1) value$iv, $composer4, 0, 0);
                        $composer4.startReplaceGroup(-1223967029);
                        ComposerKt.sourceInformation($composer4, "*469@19546L873,467@19432L987,492@20742L377,487@20440L679");
                        if (z111) {
                            z17 = false;
                        } else {
                            z17 = false;
                        }
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u246, z17, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-788117710, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed6) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C470@19572L825:DownloadPage.kt#y3famj");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-788117710, $changed6, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:470)");
                                }
                                Downloader.DownloadTaskItem downloadTaskItem = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243;
                                Downloader.State state = $this$invoke_u24lambda_u245_u24lambda_u240;
                                Function0<Unit> function317 = function313;
                                Function0<Unit> function318 = function316;
                                boolean z20 = z114;
                                ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                Modifier modifier$iv5 = Modifier.INSTANCE;
                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                int $changed$iv$iv5 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                CompositionLocalMap localMap$iv$iv5 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer5, modifier$iv5);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
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
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash5);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                                int i115 = ($changed$iv$iv$iv5 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int i20 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1302231300, "C471@19608L762:DownloadPage.kt#y3famj");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                String title = downloadTaskItem.getTitle();
                                String uploader = downloadTaskItem.getUploader();
                                String thumbnailUrl = downloadTaskItem.getThumbnailUrl();
                                float progress4 = downloadTaskItem.getProgress();
                                boolean propagateMinConstraints$iv = (state instanceof Downloader.State.DownloadingPlaylist) || (state instanceof Downloader.State.DownloadingVideo);
                                VideoCardKt.VideoCard(companion, title, uploader, thumbnailUrl, propagateMinConstraints$iv, function317, function318, progress4, downloadTaskItem.getFileSizeApprox(), downloadTaskItem.getDuration(), z20, $composer5, 6, 0, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ($changed5 & 14) | 1572864, 30);
                        Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        EnterTransition enterTransitionPlus3 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        ExitTransition exitTransitionPlus3 = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText().length() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            z19 = false;
                        } else {
                            z19 = false;
                        }
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u246, z19, modifierFillMaxWidth$default3, enterTransitionPlus3, exitTransitionPlus3, (String) null, ComposableLambdaKt.rememberComposableLambda(19914793, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed6) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C498@21050L10,493@20768L329:DownloadPage.kt#y3famj");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(19914793, $changed6, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:493)");
                                }
                                TextKt.m2817Text4IGK_g($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText(), PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium(), $composer5, 48, 3120, 55292);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ($changed5 & 14) | 1600896, 16);
                        Unit unit3 = Unit.INSTANCE;
                        $composer4.endReplaceGroup();
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u246, !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1884572836, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed6) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C504@21304L5,503@21247L428:DownloadPage.kt#y3famj");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1884572836, $changed6, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:503)");
                                }
                                String title = errorState2.getTitle($composer5, 0);
                                String report = errorState2.getReport();
                                final View view4 = view3;
                                final ClipboardManager clipboardManager4 = clipboardManager3;
                                final Downloader.ErrorState errorState3 = errorState2;
                                DownloadPageKt.ErrorMessage(null, title, report, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3.1
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
                                        HapticFeedback.INSTANCE.longPressHapticFeedback(view4);
                                        clipboardManager4.setText(new AnnotatedString(App.INSTANCE.getVersionReport() + "\nURL: " + errorState3.getUrl() + IOUtils.LINE_SEPARATOR_UNIX + errorState3.getReport(), null, null, 6, null));
                                        ToastUtil.INSTANCE.makeToast(C3070R.string.error_copied);
                                    }
                                }, $composer5, 0, 1);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ($changed5 & 14) | 1572864, 30);
                        function315.invoke($composer4, 0);
                        DownloadPageKt.FooterSignature(null, $composer4, 0, 1);
                        CommonComponentsKt.NavigationBarSpacer(null, $composer4, 0, 1);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(160)), $composer4, 6);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
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
            }, $composer2, 54), $composer2, 805330998, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function17 = function12;
            function18 = function14;
            function19 = function15;
            isPreview3 = isPreview2;
            processCount3 = processCount2;
            function20 = function10;
            function21 = function11;
            function22 = function13;
            showVideoCard3 = showVideoCard2;
            showOutput3 = showOutput2;
            function23 = function9;
        } else {
            if (i3 != 0) {
                showVideoCard2 = false;
            } else {
                showVideoCard2 = showVideoCard;
            }
            if (i4 != 0) {
                showOutput2 = false;
            } else {
                showOutput2 = showOutput;
            }
            if (i5 != 0) {
                showDownloadProgress2 = false;
            } else {
                showDownloadProgress2 = showDownloadProgress;
            }
            if (i6 != 0) {
                processCount2 = 0;
            } else {
                processCount2 = processCount;
            }
            if (i7 != 0) {
                function8 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.1
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
                function8 = function0;
            }
            if (i8 != 0) {
                function9 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.2
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
                function9 = function1;
            }
            if (i9 != 0) {
                function10 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.3
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
                function10 = function2;
            }
            if (i10 != 0) {
                function11 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.4
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
                function11 = function3;
            }
            if ((i & 4096) != 0) {
                function12 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.5
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
                function12 = function4;
            }
            if (i11 != 0) {
                function13 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.6
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
                function13 = function5;
            }
            if (i12 != 0) {
                function14 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.7
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
                function14 = function6;
            }
            if (i13 != 0) {
                function15 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.8
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                };
            } else {
                function15 = function7;
            }
            if (i14 != 0) {
                isPreview2 = false;
            } else {
                isPreview2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-408180775, $dirty, $dirty1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl (DownloadPage.kt:323)");
            }
            ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume5 = $composer3.consume(localView3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final View view3 = (View) objConsume5;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager3 = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = $composer3.consume(localClipboardManager3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final ClipboardManager clipboardManager3 = (ClipboardManager) objConsume6;
            if (downloaderState instanceof Downloader.State.DownloadingPlaylist) {
                z2 = true;
            } else {
                z2 = true;
            }
            final boolean showCancelButton3 = z2;
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            final Function0<Unit> function216 = function9;
            final int i18 = processCount2;
            final Function0<Unit> function217 = function11;
            final Function0<Unit> function218 = function10;
            ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-748307811, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9
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
                    ComposerKt.sourceInformation($composer4, "C330@13748L824,353@14584L2052,330@13661L2976:DownloadPage.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-748307811, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:330)");
                    }
                    Function2<Composer, Integer, Unit> function2M7345getLambda2$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7345getLambda2$app_debug();
                    Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, 2, null);
                    final View view4 = view3;
                    final Function0<Unit> function219 = function216;
                    ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(2076488215, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1
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
                            ComposerKt.sourceInformation($composer5, "C332@13798L22,333@13873L38,338@14093L468,331@13762L799:DownloadPage.kt#y3famj");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2076488215, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous> (DownloadPage.kt:331)");
                                }
                                TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                Function3<CaretScope, Composer, Integer, Unit> function3M7347getLambda4$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7347getLambda4$app_debug();
                                final View view5 = view4;
                                final Function0<Unit> function2110 = function219;
                                TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7347getLambda4$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(593452508, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer6, int $changed4) {
                                        ComposerKt.sourceInformation($composer6, "C339@14111L436:DownloadPage.kt#y3famj");
                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(593452508, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:339)");
                                            }
                                            final View view6 = view5;
                                            final Function0<Unit> function2111 = function2110;
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.1.1.1
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
                                                    HapticFeedback.INSTANCE.slightHapticFeedback(view6);
                                                    function2111.invoke();
                                                }
                                            }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7348getLambda5$app_debug(), $composer6, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }, $composer5, 54), $composer5, 1572912, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54);
                    final int i19 = i18;
                    final View view5 = view3;
                    final Function0<Unit> function2110 = function217;
                    final Function0<Unit> function2111 = function218;
                    AppBarKt.m1923TopAppBarGHTll3U(function2M7345getLambda2$app_debug, modifierM870paddingVpY3zN4$default, composableLambdaRememberComposableLambda6, ComposableLambdaKt.rememberComposableLambda(1145029966, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TopAppBar, Composer $composer5, int $changed3) {
                            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                            ComposerKt.sourceInformation($composer5, "C354@14616L287,362@14905L902,354@14598L1209,384@15839L22,385@15914L38,390@16143L483,384@15820L806:DownloadPage.kt#y3famj");
                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1145029966, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous> (DownloadPage.kt:354)");
                                }
                                final int i110 = i19;
                                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(173801430, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                        invoke(boxScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer $composer6, int $changed4) {
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        ComposerKt.sourceInformation($composer6, "C361@14864L25,356@14676L213:DownloadPage.kt#y3famj");
                                        if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(173801430, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:355)");
                                            }
                                            if (i110 > 0) {
                                                Modifier modifierM828offsetVpY3zN4 = OffsetKt.m828offsetVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(-16), C1979Dp.m6801constructorimpl(8));
                                                final int i111 = i110;
                                                BadgeKt.m1939BadgeeopBjH0(modifierM828offsetVpY3zN4, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-2068628706, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                                        invoke(rowScope, composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(RowScope Badge, Composer $composer7, int $changed5) {
                                                        Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                        ComposerKt.sourceInformation($composer7, "C361@14866L21:DownloadPage.kt#y3famj");
                                                        if (($changed5 & 81) == 16 && $composer7.getSkipping()) {
                                                            $composer7.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2068628706, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:361)");
                                                        }
                                                        TextKt.m2817Text4IGK_g(String.valueOf(i111), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer7, 0, 0, 131070);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, $composer6, 54), $composer6, 3078, 6);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }, $composer5, 54);
                                final View view6 = view5;
                                final Function0<Unit> function310 = function2110;
                                BadgeKt.BadgedBox(composableLambdaRememberComposableLambda7, null, ComposableLambdaKt.rememberComposableLambda(1937015956, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                        invoke(boxScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer $composer6, int $changed4) {
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        ComposerKt.sourceInformation($composer6, "C363@14942L22,364@15021L38,369@15266L527,363@14923L870:DownloadPage.kt#y3famj");
                                        if (($changed4 & 81) == 16 && $composer6.getSkipping()) {
                                            $composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1937015956, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:363)");
                                        }
                                        TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer6, 0, 7);
                                        PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer6, TooltipDefaults.$stable << 3, 1);
                                        Function3<CaretScope, Composer, Integer, Unit> function3M7350getLambda7$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7350getLambda7$app_debug();
                                        final View view7 = view6;
                                        final Function0<Unit> function311 = function310;
                                        TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7350getLambda7$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(448110319, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer7, int $changed5) {
                                                ComposerKt.sourceInformation($composer7, "C370@15288L487:DownloadPage.kt#y3famj");
                                                if (($changed5 & 11) != 2 || !$composer7.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(448110319, $changed5, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:370)");
                                                    }
                                                    final View view8 = view7;
                                                    final Function0<Unit> function312 = function311;
                                                    IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.2.1.1
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
                                                            HapticFeedback.INSTANCE.slightHapticFeedback(view8);
                                                            function312.invoke();
                                                        }
                                                    }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7351getLambda8$app_debug(), $composer7, 196656, 28);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer7.skipToGroupEnd();
                                            }
                                        }, $composer6, 54), $composer6, 1572912, 56);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer5, 54), $composer5, 390, 2);
                                TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                PopupPositionProvider popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                Function3<CaretScope, Composer, Integer, Unit> function3M7337getLambda10$app_debug = ComposableSingletons$DownloadPageKt.INSTANCE.m7337getLambda10$app_debug();
                                final View view7 = view5;
                                final Function0<Unit> function311 = function2111;
                                TooltipKt.TooltipBox(popupPositionProviderM2957rememberPlainTooltipPositionProviderkHDZbjc, function3M7337getLambda10$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(-1795586263, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer6, int $changed4) {
                                        ComposerKt.sourceInformation($composer6, "C391@16161L451:DownloadPage.kt#y3famj");
                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1795586263, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:391)");
                                            }
                                            final View view8 = view7;
                                            final Function0<Unit> function312 = function311;
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.9.2.3.1
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
                                                    HapticFeedback.INSTANCE.slightHapticFeedback(view8);
                                                    function312.invoke();
                                                }
                                            }, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7338getLambda11$app_debug(), $composer6, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }, $composer5, 54), $composer5, 1572912, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54), 0.0f, null, null, null, $composer4, 3510, 240);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54);
            ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-711312608, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.10
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
                    ComposerKt.sourceInformation($composer4, "C409@16882L6,410@16939L11,411@17010L11,406@16678L1207:DownloadPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-711312608, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:406)");
                        }
                        Function0<Unit> function219 = function8;
                        Modifier.Companion $this$invoke_u24lambda_u240 = Modifier.INSTANCE;
                        FloatingActionButtonKt.m2267FloatingActionButtonXz6DiA(function219, showDownloadProgress2 ? $this$invoke_u24lambda_u240 : WindowInsetsPadding_androidKt.imePadding($this$invoke_u24lambda_u240), MaterialTheme.INSTANCE.getShapes($composer4, MaterialTheme.$stable).getLarge(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnPrimaryContainer(), null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7339getLambda12$app_debug(), $composer4, 12582912, 96);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54);
            final boolean z15 = showDownloadProgress2;
            final boolean z16 = showVideoCard2;
            final Function0<Unit> function219 = function8;
            function16 = function8;
            final Function0<Unit> function2110 = function13;
            final Function1<? super String, Unit> function2111 = function15;
            showDownloadProgress3 = showDownloadProgress2;
            final boolean z17 = showOutput2;
            final Function0<Unit> function310 = function14;
            final boolean z18 = isPreview2;
            $composer2 = $composer3;
            ScaffoldKt.m2530ScaffoldTvnljyQ(modifierFillMaxSize$default3, composableLambdaRememberComposableLambda5, null, null, composableLambdaRememberComposableLambda6, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(912165864, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.11
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

                /* JADX WARN: Code duplicated, block: B:35:0x01bd  */
                /* JADX WARN: Code duplicated, block: B:36:0x01c6  */
                /* JADX WARN: Code duplicated, block: B:39:0x01d0  */
                /* JADX WARN: Code duplicated, block: B:40:0x01da  */
                /* JADX WARN: Code duplicated, block: B:43:0x0292  */
                /* JADX WARN: Code duplicated, block: B:46:0x029e  */
                /* JADX WARN: Code duplicated, block: B:47:0x02a4  */
                /* JADX WARN: Code duplicated, block: B:60:0x0345  */
                /* JADX WARN: Code duplicated, block: B:65:0x0357  */
                /* JADX WARN: Code duplicated, block: B:78:0x03c0  */
                /* JADX WARN: Code duplicated, block: B:81:0x0438  */
                /* JADX WARN: Code duplicated, block: B:82:0x043a  */
                /* JADX WARN: Code duplicated, block: B:86:0x0442  */
                /* JADX WARN: Code duplicated, block: B:89:0x04fe  */
                /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
                public final void invoke(PaddingValues it, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function311;
                    MeasurePolicy measurePolicy$iv;
                    int currentItem;
                    int itemCount;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function312;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    boolean z19;
                    boolean z110;
                    boolean invalid$iv;
                    Object value$iv;
                    boolean z111;
                    boolean z112;
                    boolean z113;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C438@18035L21,434@17903L4567:DownloadPage.kt#y3famj");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer4.changed(it) ? 4 : 2;
                    }
                    if (($dirty2 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(912165864, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous> (DownloadPage.kt:434)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, it), 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                        final Downloader.State $this$invoke_u24lambda_u245_u24lambda_u240 = downloaderState;
                        boolean z114 = showCancelButton3;
                        DownloadViewModel.ViewState viewState2 = viewState;
                        final Downloader.DownloadTaskItem $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243 = taskState;
                        boolean z115 = z15;
                        boolean z116 = z16;
                        final Downloader.ErrorState errorState2 = errorState;
                        Function0<Unit> function313 = function219;
                        final Function0<Unit> function314 = function2110;
                        final Function1<? super String, Unit> function315 = function2111;
                        Function2<Composer, Integer, Unit> function316 = content;
                        boolean z117 = z17;
                        final Function0<Unit> function317 = function310;
                        final boolean z118 = z18;
                        final View view4 = view3;
                        final ClipboardManager clipboardManager4 = clipboardManager3;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function311 = constructor2;
                            $composer4.createNode(function311);
                        } else {
                            function311 = constructor2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                            measurePolicy$iv = measurePolicy$iv2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i112 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                            int i113 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1681337462, "C440@18082L569,450@18666L3794:DownloadPage.kt#y3famj");
                            boolean z119 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.FetchingInfo;
                            boolean z1110 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist;
                            if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                currentItem = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getCurrentItem();
                            } else {
                                currentItem = 0;
                            }
                            if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                                itemCount = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getItemCount();
                            } else {
                                itemCount = 0;
                            }
                            DownloadPageKt.TitleWithProgressIndicator(z119, z114, z1110, currentItem, itemCount, true, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0);
                            Modifier modifier$iv4 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0.0f, C1979Dp.m6801constructorimpl(32), 0.0f, 0.0f, 13, null);
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv4 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function312 = constructor;
                                $composer4.createNode(function312);
                            } else {
                                function312 = constructor;
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                            int i114 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            int $changed5 = ((6 >> 6) & 112) | 6;
                            ColumnScope $this$invoke_u24lambda_u245_u24lambda_u246 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1223967517, "C464@19348L28,456@18906L470,502@21225L468,502@21154L539,512@21710L9,527@22332L17,528@22366L21,529@22404L42:DownloadPage.kt#y3famj");
                            String url3 = viewState2.getUrl();
                            float progress3 = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgress();
                            if (z115 || z116) {
                                z19 = false;
                            } else {
                                z19 = true;
                            }
                            boolean z1111 = !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE);
                            if (z114 || z116) {
                                z110 = false;
                            } else {
                                z110 = true;
                            }
                            $composer4.startReplaceGroup(-1223967075);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                            invalid$iv = $composer4.changed(function315);
                            Object it$iv3 = $composer4.rememberedValue();
                            if (!invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String url4) {
                                        Intrinsics.checkNotNullParameter(url4, "url");
                                        function315.invoke(url4);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv3;
                            }
                            $composer4.endReplaceGroup();
                            DownloadPageKt.InputUrl(url3, z1111, z19, progress3, function313, z110, function314, (Function1) value$iv, $composer4, 0, 0);
                            $composer4.startReplaceGroup(-1223967029);
                            ComposerKt.sourceInformation($composer4, "*469@19546L873,467@19432L987,492@20742L377,487@20440L679");
                            if (z115 || !z116) {
                                z111 = false;
                            } else {
                                z111 = true;
                            }
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u246, z111, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-788117710, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed6) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C470@19572L825:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-788117710, $changed6, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:470)");
                                    }
                                    Downloader.DownloadTaskItem downloadTaskItem = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243;
                                    Downloader.State state = $this$invoke_u24lambda_u245_u24lambda_u240;
                                    Function0<Unit> function318 = function314;
                                    Function0<Unit> function319 = function317;
                                    boolean z20 = z118;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    Modifier modifier$iv5 = Modifier.INSTANCE;
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv5 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv5 = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer5, modifier$iv5);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
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
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash5);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i115 = ($changed$iv$iv$iv5 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i20 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 1302231300, "C471@19608L762:DownloadPage.kt#y3famj");
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    String title = downloadTaskItem.getTitle();
                                    String uploader = downloadTaskItem.getUploader();
                                    String thumbnailUrl = downloadTaskItem.getThumbnailUrl();
                                    float progress4 = downloadTaskItem.getProgress();
                                    boolean propagateMinConstraints$iv = (state instanceof Downloader.State.DownloadingPlaylist) || (state instanceof Downloader.State.DownloadingVideo);
                                    VideoCardKt.VideoCard(companion, title, uploader, thumbnailUrl, propagateMinConstraints$iv, function318, function319, progress4, downloadTaskItem.getFileSizeApprox(), downloadTaskItem.getDuration(), z20, $composer5, 6, 0, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed5 & 14) | 1572864, 30);
                            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            EnterTransition enterTransitionPlus3 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            ExitTransition exitTransitionPlus3 = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText().length() > 0) {
                                z112 = true;
                            } else {
                                z112 = false;
                            }
                            if (z112 || !z117) {
                                z113 = false;
                            } else {
                                z113 = true;
                            }
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u246, z113, modifierFillMaxWidth$default3, enterTransitionPlus3, exitTransitionPlus3, (String) null, ComposableLambdaKt.rememberComposableLambda(19914793, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$2
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed6) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C498@21050L10,493@20768L329:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(19914793, $changed6, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:493)");
                                    }
                                    TextKt.m2817Text4IGK_g($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText(), PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium(), $composer5, 48, 3120, 55292);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed5 & 14) | 1600896, 16);
                            Unit unit3 = Unit.INSTANCE;
                            $composer4.endReplaceGroup();
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u246, !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1884572836, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed6) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    ComposerKt.sourceInformation($composer5, "C504@21304L5,503@21247L428:DownloadPage.kt#y3famj");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1884572836, $changed6, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:503)");
                                    }
                                    String title = errorState2.getTitle($composer5, 0);
                                    String report = errorState2.getReport();
                                    final View view5 = view4;
                                    final ClipboardManager clipboardManager5 = clipboardManager4;
                                    final Downloader.ErrorState errorState3 = errorState2;
                                    DownloadPageKt.ErrorMessage(null, title, report, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3.1
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
                                            HapticFeedback.INSTANCE.longPressHapticFeedback(view5);
                                            clipboardManager5.setText(new AnnotatedString(App.INSTANCE.getVersionReport() + "\nURL: " + errorState3.getUrl() + IOUtils.LINE_SEPARATOR_UNIX + errorState3.getReport(), null, null, 6, null));
                                            ToastUtil.INSTANCE.makeToast(C3070R.string.error_copied);
                                        }
                                    }, $composer5, 0, 1);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ($changed5 & 14) | 1572864, 30);
                            function316.invoke($composer4, 0);
                            DownloadPageKt.FooterSignature(null, $composer4, 0, 1);
                            CommonComponentsKt.NavigationBarSpacer(null, $composer4, 0, 1);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(160)), $composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
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
                        measurePolicy$iv = measurePolicy$iv2;
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i115 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                        int i116 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1681337462, "C440@18082L569,450@18666L3794:DownloadPage.kt#y3famj");
                        boolean z1112 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.FetchingInfo;
                        boolean z1113 = $this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist;
                        if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                            currentItem = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getCurrentItem();
                        } else {
                            currentItem = 0;
                        }
                        if ($this$invoke_u24lambda_u245_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist) {
                            itemCount = ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u245_u24lambda_u240).getItemCount();
                        } else {
                            itemCount = 0;
                        }
                        DownloadPageKt.TitleWithProgressIndicator(z1112, z114, z1113, currentItem, itemCount, true, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0);
                        Modifier modifier$iv5 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24), 0.0f, 2, null), 0.0f, C1979Dp.m6801constructorimpl(32), 0.0f, 0.0f, 13, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv5 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv5 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv5, horizontalAlignment$iv5, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv5 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function312 = constructor;
                            $composer4.createNode(function312);
                        } else {
                            function312 = constructor;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash5);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                        int i117 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        int $changed6 = ((6 >> 6) & 112) | 6;
                        ColumnScope $this$invoke_u24lambda_u245_u24lambda_u247 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1223967517, "C464@19348L28,456@18906L470,502@21225L468,502@21154L539,512@21710L9,527@22332L17,528@22366L21,529@22404L42:DownloadPage.kt#y3famj");
                        String url4 = viewState2.getUrl();
                        float progress4 = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgress();
                        if (z115) {
                            z19 = false;
                        } else {
                            z19 = false;
                        }
                        boolean z1114 = !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE);
                        if (z114) {
                            z110 = false;
                        } else {
                            z110 = false;
                        }
                        $composer4.startReplaceGroup(-1223967075);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                        invalid$iv = $composer4.changed(function315);
                        Object it$iv4 = $composer4.rememberedValue();
                        if (!invalid$iv) {
                        }
                        value$iv = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String url5) {
                                Intrinsics.checkNotNullParameter(url5, "url");
                                function315.invoke(url5);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                        $composer4.endReplaceGroup();
                        DownloadPageKt.InputUrl(url4, z1114, z19, progress4, function313, z110, function314, (Function1) value$iv, $composer4, 0, 0);
                        $composer4.startReplaceGroup(-1223967029);
                        ComposerKt.sourceInformation($composer4, "*469@19546L873,467@19432L987,492@20742L377,487@20440L679");
                        if (z115) {
                            z111 = false;
                        } else {
                            z111 = false;
                        }
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u247, z111, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-788117710, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed7) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C470@19572L825:DownloadPage.kt#y3famj");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-788117710, $changed7, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:470)");
                                }
                                Downloader.DownloadTaskItem downloadTaskItem = $this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243;
                                Downloader.State state = $this$invoke_u24lambda_u245_u24lambda_u240;
                                Function0<Unit> function318 = function314;
                                Function0<Unit> function319 = function317;
                                boolean z20 = z118;
                                ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                Modifier modifier$iv6 = Modifier.INSTANCE;
                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                int $changed$iv$iv6 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                CompositionLocalMap localMap$iv$iv6 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer5, modifier$iv6);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
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
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash6);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                                int i118 = ($changed$iv$iv$iv6 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int i20 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1302231300, "C471@19608L762:DownloadPage.kt#y3famj");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                String title = downloadTaskItem.getTitle();
                                String uploader = downloadTaskItem.getUploader();
                                String thumbnailUrl = downloadTaskItem.getThumbnailUrl();
                                float progress5 = downloadTaskItem.getProgress();
                                boolean propagateMinConstraints$iv = (state instanceof Downloader.State.DownloadingPlaylist) || (state instanceof Downloader.State.DownloadingVideo);
                                VideoCardKt.VideoCard(companion, title, uploader, thumbnailUrl, propagateMinConstraints$iv, function318, function319, progress5, downloadTaskItem.getFileSizeApprox(), downloadTaskItem.getDuration(), z20, $composer5, 6, 0, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ($changed6 & 14) | 1572864, 30);
                        Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        EnterTransition enterTransitionPlus4 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        ExitTransition exitTransitionPlus4 = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        if ($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText().length() > 0) {
                            z112 = true;
                        } else {
                            z112 = false;
                        }
                        if (z112) {
                            z113 = false;
                        } else {
                            z113 = false;
                        }
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u247, z113, modifierFillMaxWidth$default4, enterTransitionPlus4, exitTransitionPlus4, (String) null, ComposableLambdaKt.rememberComposableLambda(19914793, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$2$2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed7) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C498@21050L10,493@20768L329:DownloadPage.kt#y3famj");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(19914793, $changed7, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:493)");
                                }
                                TextKt.m2817Text4IGK_g($this$invoke_u24lambda_u245_u24lambda_u244_u24lambda_u243.getProgressText(), PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium(), $composer5, 48, 3120, 55292);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ($changed6 & 14) | 1600896, 16);
                        Unit unit4 = Unit.INSTANCE;
                        $composer4.endReplaceGroup();
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u247, !Intrinsics.areEqual(errorState2, Downloader.ErrorState.None.INSTANCE), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1884572836, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed7) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C504@21304L5,503@21247L428:DownloadPage.kt#y3famj");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1884572836, $changed7, -1, "com.videshkarmakar.loop.ui.page.download.DownloadPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPage.kt:503)");
                                }
                                String title = errorState2.getTitle($composer5, 0);
                                String report = errorState2.getReport();
                                final View view5 = view4;
                                final ClipboardManager clipboardManager5 = clipboardManager4;
                                final Downloader.ErrorState errorState3 = errorState2;
                                DownloadPageKt.ErrorMessage(null, title, report, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$DownloadPageImpl$11$1$3$3.1
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
                                        HapticFeedback.INSTANCE.longPressHapticFeedback(view5);
                                        clipboardManager5.setText(new AnnotatedString(App.INSTANCE.getVersionReport() + "\nURL: " + errorState3.getUrl() + IOUtils.LINE_SEPARATOR_UNIX + errorState3.getReport(), null, null, 6, null));
                                        ToastUtil.INSTANCE.makeToast(C3070R.string.error_copied);
                                    }
                                }, $composer5, 0, 1);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ($changed6 & 14) | 1572864, 30);
                        function316.invoke($composer4, 0);
                        DownloadPageKt.FooterSignature(null, $composer4, 0, 1);
                        CommonComponentsKt.NavigationBarSpacer(null, $composer4, 0, 1);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(160)), $composer4, 6);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
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
            }, $composer2, 54), $composer2, 805330998, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function17 = function12;
            function18 = function14;
            function19 = function15;
            isPreview3 = isPreview2;
            processCount3 = processCount2;
            function20 = function10;
            function21 = function11;
            function22 = function13;
            showVideoCard3 = showVideoCard2;
            showOutput3 = showOutput2;
            function23 = function9;
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z19 = showVideoCard3;
            final boolean z20 = showOutput3;
            final boolean z21 = showDownloadProgress3;
            final int i19 = processCount3;
            final Function0<Unit> function311 = function16;
            final Function0<Unit> function312 = function23;
            final Function0<Unit> function313 = function20;
            final Function0<Unit> function314 = function21;
            final Function0<Unit> function315 = function17;
            final Function0<Unit> function316 = function22;
            final Function0<Unit> function317 = function18;
            final Function1<? super String, Unit> function318 = function19;
            final boolean z110 = isPreview3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.DownloadPageImpl.12
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

                public final void invoke(Composer composer, int i110) {
                    DownloadPageKt.DownloadPageImpl(downloaderState, taskState, viewState, errorState, z19, z20, z21, i19, function311, function312, function313, function314, function315, function316, function317, function318, z110, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void TitleWithProgressIndicator(boolean showProgressIndicator, boolean showDownloadText, boolean isDownloadingPlaylist, int currentIndex, int downloadItemCount, boolean isCentered, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean z2;
        boolean isDownloadingPlaylist2;
        final int currentIndex2;
        final int downloadItemCount2;
        Function0<ComposeUiNode> function0;
        final boolean isDownloadingPlaylist3;
        boolean showProgressIndicator2;
        boolean showDownloadText2;
        boolean isCentered2;
        Composer $composer2 = $composer.startRestartGroup(-143384732);
        ComposerKt.sourceInformation($composer2, "C(TitleWithProgressIndicator)P(5,4,3)549@22930L2564:DownloadPage.kt#y3famj");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            z = showProgressIndicator;
        } else if (($changed & 14) == 0) {
            z = showProgressIndicator;
            $dirty |= $composer2.changed(z) ? 4 : 2;
        } else {
            z = showProgressIndicator;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            z2 = showDownloadText;
        } else if (($changed & 112) == 0) {
            z2 = showDownloadText;
            $dirty |= $composer2.changed(z2) ? 32 : 16;
        } else {
            z2 = showDownloadText;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            isDownloadingPlaylist2 = isDownloadingPlaylist;
        } else if (($changed & 896) == 0) {
            isDownloadingPlaylist2 = isDownloadingPlaylist;
            $dirty |= $composer2.changed(isDownloadingPlaylist2) ? 256 : 128;
        } else {
            isDownloadingPlaylist2 = isDownloadingPlaylist;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            currentIndex2 = currentIndex;
        } else if (($changed & 7168) == 0) {
            currentIndex2 = currentIndex;
            $dirty |= $composer2.changed(currentIndex2) ? 2048 : 1024;
        } else {
            currentIndex2 = currentIndex;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            downloadItemCount2 = downloadItemCount;
        } else if ((57344 & $changed) == 0) {
            downloadItemCount2 = downloadItemCount;
            $dirty |= $composer2.changed(downloadItemCount2) ? 16384 : 8192;
        } else {
            downloadItemCount2 = downloadItemCount;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(isCentered) ? 131072 : 65536;
        }
        if (($dirty & 374491) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            isCentered2 = isCentered;
            showProgressIndicator2 = z;
            showDownloadText2 = z2;
            isDownloadingPlaylist3 = isDownloadingPlaylist2;
        } else {
            boolean showProgressIndicator3 = i2 != 0 ? true : z;
            boolean showDownloadText3 = i3 != 0 ? true : z2;
            if (i4 != 0) {
                isDownloadingPlaylist2 = true;
            }
            if (i5 != 0) {
                currentIndex2 = 1;
            }
            if (i6 != 0) {
                downloadItemCount2 = 4;
            }
            final boolean isCentered3 = i7 != 0 ? false : isCentered;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-143384732, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.TitleWithProgressIndicator (DownloadPage.kt:545)");
            }
            TextAlign.Companion companion = TextAlign.INSTANCE;
            final int textAlign = isCentered3 ? companion.m6658getCentere0LSkKk() : companion.m6663getStarte0LSkKk();
            float horizontalPadding = isCentered3 ? C1979Dp.m6801constructorimpl(24) : C1979Dp.m6801constructorimpl(12);
            Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), horizontalPadding, 0.0f, 2, null), 0.0f, isCentered3 ? C1979Dp.m6801constructorimpl(40) : C1979Dp.m6801constructorimpl(24), 0.0f, 0.0f, 13, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Horizontal horizontalAlignment$iv = isCentered3 ? companion2.getCenterHorizontally() : companion2.getStart();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            boolean isDownloadingPlaylist4 = isDownloadingPlaylist2;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
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
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$TitleWithProgressIndicator_u24lambda_u2430 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1619426394, "C558@23321L33,561@23490L11,557@23296L432,573@23935L11,570@23774L430,582@24323L523,582@24271L575,598@24958L530,598@24896L592:DownloadPage.kt#y3famj");
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.app_name, $composer2, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(isCentered3 ? 72 : 36), (FontStyle) null, FontWeight.INSTANCE.getBold(), TypeKt.getMilkerFontFamily(), isCentered3 ? TextUnitKt.getSp(2) : TextUnitKt.getSp(0), (TextDecoration) null, TextAlign.m6651boximpl(textAlign), 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 1769472, 3120, 120082);
            TextKt.m2817Text4IGK_g("Every Day, Every Download, Every Content.", PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, isCentered3 ? C1979Dp.m6801constructorimpl(12) : C1979Dp.m6801constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(isCentered3 ? 13 : 12), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(textAlign), 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 196614, 3120, 120272);
            AnimatedVisibilityKt.AnimatedVisibility($this$TitleWithProgressIndicator_u24lambda_u2430, showProgressIndicator3, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-19439950, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$TitleWithProgressIndicator$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                    invoke(animatedVisibilityScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer3, int $changed3) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation($composer3, "C583@24337L499:DownloadPage.kt#y3famj");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-19439950, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.TitleWithProgressIndicator.<anonymous>.<anonymous> (DownloadPage.kt:583)");
                    }
                    Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, isCentered3 ? C1979Dp.m6801constructorimpl(24) : C1979Dp.m6801constructorimpl(12), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
                    Alignment.Horizontal horizontalAlignment$iv2 = isCentered3 ? Alignment.INSTANCE.getCenterHorizontally() : Alignment.INSTANCE.getStart();
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
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
                    int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i10 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -573739445, "C592@24785L11,589@24623L199:DownloadPage.kt#y3famj");
                    ProgressIndicatorKt.m2488CircularProgressIndicatorLxG7B9w(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), C1979Dp.m6801constructorimpl(3), 0L, 0, $composer3, 390, 24);
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
            }, $composer2, 54), $composer2, ($changed2 & 14) | 1572864 | (($dirty << 3) & 112), 30);
            isDownloadingPlaylist3 = isDownloadingPlaylist4;
            showProgressIndicator2 = showProgressIndicator3;
            AnimatedVisibilityKt.AnimatedVisibility($this$TitleWithProgressIndicator_u24lambda_u2430, showDownloadText3 && !isCentered3, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1971035753, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$TitleWithProgressIndicator$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                    invoke(animatedVisibilityScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer3, int $changed3) {
                    String str;
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation($composer3, "C606@25337L10,607@25397L11,599@24972L506:DownloadPage.kt#y3famj");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1971035753, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.TitleWithProgressIndicator.<anonymous>.<anonymous> (DownloadPage.kt:599)");
                    }
                    if (isDownloadingPlaylist3) {
                        $composer3.startReplaceGroup(1046761065);
                        ComposerKt.sourceInformation($composer3, "*600@25021L48");
                        String str2 = String.format(StringResources_androidKt.stringResource(C3070R.string.playlist_indicator_text, $composer3, 0), Arrays.copyOf(new Object[]{Integer.valueOf(currentIndex2), Integer.valueOf(downloadItemCount2)}, 2));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        $composer3.endReplaceGroup();
                        str = str2;
                    } else {
                        $composer3.startReplaceGroup(1046761184);
                        ComposerKt.sourceInformation($composer3, "604@25189L51");
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.downloading_indicator_text, $composer3, 0);
                        $composer3.endReplaceGroup();
                        str = strStringResource;
                    }
                    TextKt.m2817Text4IGK_g(str, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(textAlign), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, 48, 0, 65016);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, ($changed2 & 14) | 1572864, 30);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            showDownloadText2 = showDownloadText3;
            isCentered2 = isCentered3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = showProgressIndicator2;
            final boolean z4 = showDownloadText2;
            final boolean z5 = isDownloadingPlaylist3;
            final int i9 = currentIndex2;
            final int i10 = downloadItemCount2;
            final boolean z6 = isCentered2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.TitleWithProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i11) {
                    DownloadPageKt.TitleWithProgressIndicator(z3, z4, z5, i9, i10, z6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void ErrorMessage(Modifier modifier, final String title, final String errorReport, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0<Unit> function1;
        Modifier modifier3;
        Function0<Unit> function2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(errorReport, "errorReport");
        Composer $composer2 = $composer.startRestartGroup(1108915378);
        ComposerKt.sourceInformation($composer2, "C(ErrorMessage)P(1,3)621@25673L7,623@25724L11,624@25782L6,627@25869L1836,622@25685L2020:DownloadPage.kt#y3famj");
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
            $dirty |= $composer2.changed(title) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(errorReport) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function1 = function0;
        } else if (($changed & 7168) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function2 = function1;
        } else {
            final Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            final C34121 c34121 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.ErrorMessage.1
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
                ComposerKt.traceEventStart(1108915378, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.ErrorMessage (DownloadPage.kt:620)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SurfaceKt.m2666SurfaceT9BRK9s(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(16), 1, null), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getLarge(), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getErrorContainer(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(593397815, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.ErrorMessage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:42:0x0402  */
                /* JADX WARN: Code duplicated, block: B:45:0x040e  */
                /* JADX WARN: Code duplicated, block: B:46:0x0412  */
                /* JADX WARN: Code duplicated, block: B:57:0x0559  */
                /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function3;
                    MeasurePolicy measurePolicy$iv;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C628@25879L1820:DownloadPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(593397815, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.ErrorMessage.<anonymous> (DownloadPage.kt:628)");
                        }
                        Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, null, null, 3, null), C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(16));
                        Modifier modifier5 = modifier4;
                        String str = errorReport;
                        String str2 = title;
                        Function0<Unit> function4 = c34121;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
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
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i5 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1948467004, "C633@26044L699,651@26756L40,654@26889L10,655@26950L11,652@26809L183,657@27005L41,658@27059L630:DownloadPage.kt#y3famj");
                        Modifier modifier$iv2 = PaddingKt.m870paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null), C1979Dp.m6801constructorimpl(4), 0.0f, 2, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv2 = (384 << 3) & 112;
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
                            function3 = constructor3;
                            $composer3.createNode(function3);
                        } else {
                            function3 = constructor3;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                            measurePolicy$iv = measurePolicy$iv3;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            int i7 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1545601594, "C642@26415L11,639@26265L196,644@26478L40,647@26617L10,648@26683L11,645@26535L194:DownloadPage.kt#y3famj");
                            IconKt.m2292Iconww6aTOc(ErrorKt.getError(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 48, 4);
                            SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12)), $composer3, 6);
                            TextKt.m2817Text4IGK_g(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 0, 65530);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer3, 6);
                            TextKt.m2817Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 0, 65530);
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16)), $composer3, 6);
                            Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getEnd();
                            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv3 = (54 << 3) & 112;
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
                                $composer3.createNode(constructor);
                            } else {
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            int i9 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1545602533, "C662@27204L228,668@27449L226:DownloadPage.kt#y3famj");
                            ButtonKt.TextButton(function4, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null), false, null, null, null, null, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7340getLambda13$app_debug(), $composer3, 805306416, 508);
                            ButtonKt.TextButton(function4, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null), false, null, null, null, null, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7341getLambda14$app_debug(), $composer3, 805306416, 508);
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
                                return;
                            }
                            return;
                        }
                        measurePolicy$iv = measurePolicy$iv3;
                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash2);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                        int i11 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1545601594, "C642@26415L11,639@26265L196,644@26478L40,647@26617L10,648@26683L11,645@26535L194:DownloadPage.kt#y3famj");
                        IconKt.m2292Iconww6aTOc(ErrorKt.getError(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 48, 4);
                        SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12)), $composer3, 6);
                        TextKt.m2817Text4IGK_g(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 0, 65530);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer3, 6);
                        TextKt.m2817Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 0, 65530);
                        SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16)), $composer3, 6);
                        Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                        int $changed$iv$iv4 = (54 << 3) & 112;
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
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                        int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                        int i13 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1545602533, "C662@27204L228,668@27449L226:DownloadPage.kt#y3famj");
                        ButtonKt.TextButton(function4, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null), false, null, null, null, null, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7340getLambda13$app_debug(), $composer3, 805306416, 508);
                        ButtonKt.TextButton(function4, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null), false, null, null, null, null, null, null, ComposableSingletons$DownloadPageKt.INSTANCE.m7341getLambda14$app_debug(), $composer3, 805306416, 508);
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
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 12582918, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            function2 = c34121;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0<Unit> function3 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.ErrorMessage.3
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
                    DownloadPageKt.ErrorMessage(modifier5, title, errorReport, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x023c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0248  */
    /* JADX WARN: Code duplicated, block: B:107:0x0253  */
    /* JADX WARN: Code duplicated, block: B:110:0x0397  */
    /* JADX WARN: Code duplicated, block: B:113:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:114:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:117:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:121:0x03e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:125:0x0484  */
    /* JADX WARN: Code duplicated, block: B:128:0x048d  */
    /* JADX WARN: Code duplicated, block: B:129:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:91:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0124  */
    /* JADX WARN: Code duplicated, block: B:93:0x0128  */
    /* JADX WARN: Code duplicated, block: B:96:0x0130  */
    /* JADX WARN: Code duplicated, block: B:99:0x023a  */
    public static final void InputUrl(final String url, final boolean error, boolean showDownloadProgress, final float progress, final Function0<Unit> onDone, final boolean showCancelButton, final Function0<Unit> onCancel, final Function1<? super String, Unit> onValueChange, Composer $composer, final int $changed, final int i) {
        boolean z;
        int i2;
        boolean showDownloadProgress2;
        boolean invalid$iv;
        Object value$iv;
        Composer $composer2;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1135683743);
        ComposerKt.sourceInformation($composer3, "C(InputUrl)P(7!1,6,4,2,5)691@28099L7,700@28404L10,703@28573L11,704@28643L11,705@28710L11,706@28771L11,707@28842L11,708@28915L11,702@28518L427,712@29094L12,710@28970L79,692@28111L1073,715@29240L998,715@29189L1049,742@30243L384:DownloadPage.kt#y3famj");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(url) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(error) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = showDownloadProgress;
        } else if (($changed & 896) == 0) {
            z = showDownloadProgress;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = showDownloadProgress;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(progress) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changedInstance(onDone) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changed(showCancelButton) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if ((3670016 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onCancel) ? 1048576 : 524288;
        }
        if ((i & 128) == 0) {
            if ((29360128 & $changed) == 0) {
                i2 = $composer3.changedInstance(onValueChange) ? 8388608 : 4194304;
            }
            if ((23967451 & $dirty) == 4793490 || !$composer3.getSkipping()) {
                if (i3 != 0) {
                    showDownloadProgress2 = false;
                } else {
                    showDownloadProgress2 = z;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1135683743, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl (DownloadPage.kt:690)");
                }
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localSoftwareKeyboardController);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier.Companion companion = Modifier.INSTANCE;
                float $this$dp$iv = C1979Dp.m6801constructorimpl(0.0f);
                float $this$dp$iv2 = C1979Dp.m6801constructorimpl(16.0f);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m869paddingVpY3zN4(companion, $this$dp$iv, $this$dp$iv2), 0.0f, 1, null);
                TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge();
                TextFieldColors textFieldColorsM2464colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m2464colors0hiis_0(0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutline(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, 2139088591, UnixStat.PERM_MASK);
                $composer3.startReplaceGroup(-1957117634);
                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadPage.kt#9igjgp");
                if (($dirty & 57344) == 16384) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                Object it$iv = $composer3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                            invoke2(keyboardActionScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KeyboardActionScope $receiver) {
                            Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                            onDone.invoke();
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer3.endReplaceGroup();
                int $dirty2 = $dirty;
                OutlinedTextFieldKt.OutlinedTextField(url, onValueChange, modifierFillMaxWidth$default, false, false, bodyLarge, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DownloadPageKt.INSTANCE.m7342getLambda15$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(866350666, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.InputUrl.2
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
                        ComposerKt.sourceInformation($composer4, "C711@29018L21,711@29006L33:DownloadPage.kt#y3famj");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(866350666, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl.<anonymous> (DownloadPage.kt:711)");
                        }
                        if (url.length() > 0) {
                            $composer4.startReplaceGroup(220012307);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                            boolean invalid$iv2 = $composer4.changed(onValueChange);
                            final Function1<String, Unit> function1 = onValueChange;
                            Object it$iv2 = $composer4.rememberedValue();
                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$2$1$1
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
                                        function1.invoke("");
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv2;
                            }
                            $composer4.endReplaceGroup();
                            IconButtonsKt.ClearButton((Function0) value$iv2, $composer4, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, error, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), new KeyboardActions((Function1) value$iv, null, null, null, null, null, 62, null), false, 3, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM2464colors0hiis_0, $composer3, ($dirty & 14) | 806879616 | (($dirty >> 18) & 112), (($dirty << 6) & 7168) | 100859904, 0, 3825048);
                $composer2 = $composer3;
                AnimatedVisibilityKt.AnimatedVisibility(showDownloadProgress2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-553277047, true, new C34183(progress), $composer2, 54), $composer2, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
                Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope $this$InputUrl_u24lambda_u2432 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 220013585, "C743@30343L278,743@30296L325:DownloadPage.kt#y3famj");
                AnimatedVisibilityKt.AnimatedVisibility($this$InputUrl_u24lambda_u2432, showCancelButton, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-712839213, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                        invoke(animatedVisibilityScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed2) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation($composer4, "C747@30486L36,748@30569L11,744@30357L254:DownloadPage.kt#y3famj");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-712839213, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl.<anonymous>.<anonymous> (DownloadPage.kt:744)");
                        }
                        ButtonsKt.m7239OutlinedButtonWithIconyrwZFoE(null, onCancel, CancelKt.getCancel(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.cancel, $composer4, 0), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), $composer4, 0, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), $composer2, ((((6 >> 6) & 112) | 6) & 14) | 1572864 | (($dirty2 >> 12) & 112), 30);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                showDownloadProgress2 = z;
                $composer2 = $composer3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z2 = showDownloadProgress2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.InputUrl.5
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

                    public final void invoke(Composer composer, int i5) {
                        DownloadPageKt.InputUrl(url, error, z2, progress, onDone, showCancelButton, onCancel, onValueChange, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 12582912;
        $dirty |= i2;
        if ((23967451 & $dirty) == 4793490) {
            if (i3 != 0) {
                showDownloadProgress2 = false;
            } else {
                showDownloadProgress2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1135683743, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl (DownloadPage.kt:690)");
            }
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localSoftwareKeyboardController2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float $this$dp$iv3 = C1979Dp.m6801constructorimpl(0.0f);
            float $this$dp$iv4 = C1979Dp.m6801constructorimpl(16.0f);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m869paddingVpY3zN4(companion2, $this$dp$iv3, $this$dp$iv4), 0.0f, 1, null);
            TextStyle bodyLarge2 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge();
            TextFieldColors textFieldColorsM2464colors0hiis_1 = OutlinedTextFieldDefaults.INSTANCE.m2464colors0hiis_0(0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutline(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, 2139088591, UnixStat.PERM_MASK);
            $composer3.startReplaceGroup(-1957117634);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadPage.kt#9igjgp");
            if (($dirty & 57344) == 16384) {
                invalid$iv = true;
            } else {
                invalid$iv = false;
            }
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
                value$iv = new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        onDone.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        onDone.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            $composer3.endReplaceGroup();
            int $dirty3 = $dirty;
            OutlinedTextFieldKt.OutlinedTextField(url, onValueChange, modifierFillMaxWidth$default2, false, false, bodyLarge2, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DownloadPageKt.INSTANCE.m7342getLambda15$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(866350666, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.InputUrl.2
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
                    ComposerKt.sourceInformation($composer4, "C711@29018L21,711@29006L33:DownloadPage.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(866350666, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl.<anonymous> (DownloadPage.kt:711)");
                    }
                    if (url.length() > 0) {
                        $composer4.startReplaceGroup(220012307);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(onValueChange);
                        final Function1<? super String, Unit> function1 = onValueChange;
                        Object it$iv3 = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$2$1$1
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
                                    function1.invoke("");
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv3;
                        }
                        $composer4.endReplaceGroup();
                        IconButtonsKt.ClearButton((Function0) value$iv2, $composer4, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, error, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), new KeyboardActions((Function1) value$iv, null, null, null, null, null, 62, null), false, 3, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM2464colors0hiis_1, $composer3, ($dirty & 14) | 806879616 | (($dirty >> 18) & 112), (($dirty << 6) & 7168) | 100859904, 0, 3825048);
            $composer2 = $composer3;
            AnimatedVisibilityKt.AnimatedVisibility(showDownloadProgress2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-553277047, true, new C34183(progress), $composer2, 54), $composer2, (($dirty3 >> 6) & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope $this$InputUrl_u24lambda_u2433 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 220013585, "C743@30343L278,743@30296L325:DownloadPage.kt#y3famj");
            AnimatedVisibilityKt.AnimatedVisibility($this$InputUrl_u24lambda_u2433, showCancelButton, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-712839213, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                    invoke(animatedVisibilityScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation($composer4, "C747@30486L36,748@30569L11,744@30357L254:DownloadPage.kt#y3famj");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-712839213, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl.<anonymous>.<anonymous> (DownloadPage.kt:744)");
                    }
                    ButtonsKt.m7239OutlinedButtonWithIconyrwZFoE(null, onCancel, CancelKt.getCancel(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.cancel, $composer4, 0), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, ((((6 >> 6) & 112) | 6) & 14) | 1572864 | (($dirty3 >> 12) & 112), 30);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i3 != 0) {
                showDownloadProgress2 = false;
            } else {
                showDownloadProgress2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1135683743, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl (DownloadPage.kt:690)");
            }
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController3 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localSoftwareKeyboardController3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            float $this$dp$iv5 = C1979Dp.m6801constructorimpl(0.0f);
            float $this$dp$iv6 = C1979Dp.m6801constructorimpl(16.0f);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(PaddingKt.m869paddingVpY3zN4(companion3, $this$dp$iv5, $this$dp$iv6), 0.0f, 1, null);
            TextStyle bodyLarge3 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge();
            TextFieldColors textFieldColorsM2464colors0hiis_2 = OutlinedTextFieldDefaults.INSTANCE.m2464colors0hiis_0(0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutline(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, 0, 0, 3072, 2139088591, UnixStat.PERM_MASK);
            $composer3.startReplaceGroup(-1957117634);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadPage.kt#9igjgp");
            if (($dirty & 57344) == 16384) {
                invalid$iv = true;
            } else {
                invalid$iv = false;
            }
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv) {
                value$iv = new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        onDone.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        onDone.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            $composer3.endReplaceGroup();
            int $dirty4 = $dirty;
            OutlinedTextFieldKt.OutlinedTextField(url, onValueChange, modifierFillMaxWidth$default3, false, false, bodyLarge3, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DownloadPageKt.INSTANCE.m7342getLambda15$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(866350666, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.InputUrl.2
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
                    ComposerKt.sourceInformation($composer4, "C711@29018L21,711@29006L33:DownloadPage.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(866350666, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl.<anonymous> (DownloadPage.kt:711)");
                    }
                    if (url.length() > 0) {
                        $composer4.startReplaceGroup(220012307);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPage.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(onValueChange);
                        final Function1<? super String, Unit> function1 = onValueChange;
                        Object it$iv4 = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$2$1$1
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
                                    function1.invoke("");
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv4;
                        }
                        $composer4.endReplaceGroup();
                        IconButtonsKt.ClearButton((Function0) value$iv2, $composer4, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, error, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), new KeyboardActions((Function1) value$iv, null, null, null, null, null, 62, null), false, 3, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM2464colors0hiis_2, $composer3, ($dirty & 14) | 806879616 | (($dirty >> 18) & 112), (($dirty << 6) & 7168) | 100859904, 0, 3825048);
            $composer2 = $composer3;
            AnimatedVisibilityKt.AnimatedVisibility(showDownloadProgress2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-553277047, true, new C34183(progress), $composer2, 54), $composer2, (($dirty4 >> 6) & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
            Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope $this$InputUrl_u24lambda_u2434 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 220013585, "C743@30343L278,743@30296L325:DownloadPage.kt#y3famj");
            AnimatedVisibilityKt.AnimatedVisibility($this$InputUrl_u24lambda_u2434, showCancelButton, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-712839213, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                    invoke(animatedVisibilityScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation($composer4, "C747@30486L36,748@30569L11,744@30357L254:DownloadPage.kt#y3famj");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-712839213, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl.<anonymous>.<anonymous> (DownloadPage.kt:744)");
                    }
                    ButtonsKt.m7239OutlinedButtonWithIconyrwZFoE(null, onCancel, CancelKt.getCancel(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.cancel, $composer4, 0), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, ((((6 >> 6) & 112) | 6) & 14) | 1572864 | (($dirty4 >> 12) & 112), 30);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = showDownloadProgress2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.InputUrl.5
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
                    DownloadPageKt.InputUrl(url, error, z3, progress, onDone, showCancelButton, onCancel, onValueChange, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$3 */
    /* JADX INFO: compiled from: DownloadPage.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedVisibilityScope;", "invoke", "(Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C34183 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
        final /* synthetic */ float $progress;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C34183(float f) {
            super(3);
            this.$progress = f;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Object value$iv;
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            ComposerKt.sourceInformation($composer, "C716@29250L982:DownloadPage.kt#y3famj");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-553277047, $changed, -1, "com.videshkarmakar.loop.ui.page.download.InputUrl.<anonymous> (DownloadPage.kt:716)");
            }
            Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(0), C1979Dp.m6801constructorimpl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            float f = this.$progress;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i2 = ((390 >> 6) & 112) | 6;
            RowScope $this$invoke_u24lambda_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -467118816, "C720@29412L171,735@30042L180:DownloadPage.kt#y3famj");
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f / 100.0f, AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, null, null, $composer, 0, 28);
            if (invoke$lambda$2$lambda$0(stateAnimateFloatAsState) < 0.0f) {
                $composer.startReplaceGroup(-467118570);
                ComposerKt.sourceInformation($composer, "727@29764L6,724@29628L164");
                ProgressIndicatorKt.m2497LinearProgressIndicatorrIrjwxo(ClipKt.clip(RowScope.CC.weight$default($this$invoke_u24lambda_u242, Modifier.INSTANCE, 0.75f, false, 2, null), MaterialTheme.INSTANCE.getShapes($composer, MaterialTheme.$stable).getLarge()), 0L, 0L, 0, 0.0f, $composer, 0, 30);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-467118388);
                ComposerKt.sourceInformation($composer, "730@29862L26,733@30001L6,729@29810L219");
                $composer.startReplaceGroup(-467118336);
                ComposerKt.sourceInformation($composer, "CC(remember):DownloadPage.kt#9igjgp");
                boolean invalid$iv = $composer.changed(stateAnimateFloatAsState);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function0) new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt$InputUrl$3$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(DownloadPageKt.C34183.invoke$lambda$2$lambda$0(stateAnimateFloatAsState));
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                ProgressIndicatorKt.m2492LinearProgressIndicatorGJbTh5U((Function0) value$iv, ClipKt.clip(RowScope.CC.weight$default($this$invoke_u24lambda_u242, Modifier.INSTANCE, 0.75f, false, 2, null), MaterialTheme.INSTANCE.getShapes($composer, MaterialTheme.$stable).getLarge()), 0L, 0L, 0, 0.0f, null, $composer, 0, 124);
                $composer.endReplaceGroup();
            }
            TextKt.m2817Text4IGK_g(f < 0.0f ? "0%" : f + "%", RowScope.CC.weight$default($this$invoke_u24lambda_u242, Modifier.INSTANCE, 0.25f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(TextAlign.INSTANCE.m6658getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 130556);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$2$lambda$0(State<Float> state) {
            Object thisObj$iv = state.getValue();
            return ((Number) thisObj$iv).floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FooterSignature(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(1469621376);
        ComposerKt.sourceInformation($composer2, "C(FooterSignature)765@31102L582:DownloadPage.kt#y3famj");
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
        if (($dirty & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1469621376, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.FooterSignature (DownloadPage.kt:764)");
            }
            Modifier modifierM871paddingqDBjuR0 = PaddingKt.m871paddingqDBjuR0(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), C1979Dp.m6801constructorimpl(28), C1979Dp.m6801constructorimpl(32), C1979Dp.m6801constructorimpl(28), C1979Dp.m6801constructorimpl(20));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_4 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM744spacedBy0680j_4, centerVertically, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierM871paddingqDBjuR0);
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
            Modifier modifier4 = modifier3;
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int $changed2 = ((432 >> 6) & 112) | 6;
            RowScope $this$FooterSignature_u24lambda_u2433 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1571798805, "C772@31374L10,774@31418L48,775@31502L10,776@31559L11,773@31393L266,780@31668L10:DownloadPage.kt#y3famj");
            Hairline($this$FooterSignature_u24lambda_u2433, $composer2, $changed2 & 14);
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.home_footer_credit, $composer2, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, TextUnitKt.getSp(1.4d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, 12582912, 3072, 57210);
            Hairline($this$FooterSignature_u24lambda_u2433, $composer2, $changed2 & 14);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.FooterSignature.2
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
                    DownloadPageKt.FooterSignature(modifier2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hairline(final RowScope $this$Hairline, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-283311804);
        ComposerKt.sourceInformation($composer2, "C(Hairline)790@31859L11,786@31738L154:DownloadPage.kt#y3famj");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$Hairline) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-283311804, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.Hairline (DownloadPage.kt:785)");
            }
            BoxKt.Box(BackgroundKt.m454backgroundbw27NRU$default(SizeKt.m899height3ABfNKs(RowScope.CC.weight$default($this$Hairline, Modifier.INSTANCE, 1.0f, false, 2, null), C1979Dp.m6801constructorimpl(1)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOutlineVariant(), null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.Hairline.1
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
                    DownloadPageKt.Hairline($this$Hairline, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void PreviewDownloadPage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1163901209);
        ComposerKt.sourceInformation($composer2, "C(PreviewDownloadPage)798@31989L82:DownloadPage.kt#y3famj");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1163901209, $changed, -1, "com.videshkarmakar.loop.ui.page.download.PreviewDownloadPage (DownloadPage.kt:797)");
            }
            ThemeKt.PreviewThemeLight(ComposableSingletons$DownloadPageKt.INSTANCE.m7344getLambda17$app_debug(), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.DownloadPageKt.PreviewDownloadPage.1
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
                    DownloadPageKt.PreviewDownloadPage(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
