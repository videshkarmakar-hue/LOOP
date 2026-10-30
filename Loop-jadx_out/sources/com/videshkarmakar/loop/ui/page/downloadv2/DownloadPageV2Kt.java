package com.videshkarmakar.loop.ui.page.downloadv2;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ErrorKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CaretScope;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorDefaults;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipDefaults;
import androidx.compose.material3.TooltipKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.AsyncImageImplKt;
import com.videshkarmakar.loop.ui.component.CommonComponentsKt;
import com.videshkarmakar.loop.ui.component.IconButtonsKt;
import com.videshkarmakar.loop.ui.page.download.DownloadViewModel;
import com.videshkarmakar.loop.ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: DownloadPageV2.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u001aè\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001f\u001a1\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010&\u001a'\u0010'\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010(\u001aQ\u0010)\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018H\u0007¢\u0006\u0002\u0010/\u001a\r\u00100\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001f\u001a_\u00101\u001a\u00020\u00012\b\b\u0002\u00102\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u00109\u001am\u0010:\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010;\u001a\u00020\u00192\b\b\u0002\u0010<\u001a\u00020\u00192\b\b\u0002\u0010=\u001a\u00020>2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010B¨\u0006C²\u0006\n\u0010D\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u0010D\u001a\u00020,X\u008a\u0084\u0002"}, d2 = {"DownloadPageImplV2", "", "downloaderState", "Lcom/videshkarmakar/loop/Downloader$State;", "taskState", "Lcom/videshkarmakar/loop/Downloader$DownloadTaskItem;", "viewState", "Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel$ViewState;", "errorState", "Lcom/videshkarmakar/loop/Downloader$ErrorState;", "showVideoCard", "", "showOutput", "showDownloadProgress", "processCount", "", "downloadCallback", "Lkotlin/Function0;", "navigateToSettings", "navigateToDownloads", "onNavigateToTaskList", "cancelCallback", "onVideoCardClicked", "onUrlChanged", "Lkotlin/Function1;", "", "isPreview", "content", "Landroidx/compose/runtime/Composable;", "(Lcom/videshkarmakar/loop/Downloader$State;Lcom/videshkarmakar/loop/Downloader$DownloadTaskItem;Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel$ViewState;Lcom/videshkarmakar/loop/Downloader$ErrorState;ZZZILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "DownloadPagePreview", "(Landroidx/compose/runtime/Composer;I)V", "ErrorMessage", "modifier", "Landroidx/compose/ui/Modifier;", "url", "errorReport", "errorMessageResId", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ILandroidx/compose/runtime/Composer;II)V", "FABs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "InputUrl", "error", NotificationCompat.CATEGORY_PROGRESS, "", "onDone", "onValueChange", "(Ljava/lang/String;ZZFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "NextTask", "TitleWithProgressIndicator", "showProgressIndicator", "showCancelOperation", "isDownloadingPlaylist", "currentIndex", "downloadItemCount", "onClick", "onLongClick", "(ZZZIILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VideoCardV2", "title", "author", "thumbnailUrl", "", "fileSizeApprox", "", "duration", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;FDIZLandroidx/compose/runtime/Composer;II)V", "app_debug", "progressAnimationValue"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadPageV2Kt {
    public static final void DownloadPageImplV2(final Downloader.State downloaderState, final Downloader.DownloadTaskItem taskState, final DownloadViewModel.ViewState viewState, final Downloader.ErrorState errorState, boolean showVideoCard, boolean showOutput, boolean showDownloadProgress, int processCount, Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4, Function0<Unit> function5, Function1<? super String, Unit> function6, boolean isPreview, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function0<Unit> function7;
        boolean showVideoCard2;
        Function0<Unit> function8;
        Function0<Unit> function9;
        Function0<Unit> function10;
        int processCount2;
        Function0<Unit> function11;
        Function0<Unit> function12;
        boolean showOutput2;
        boolean showDownloadProgress2;
        boolean isPreview2;
        Function1<? super String, Unit> function13;
        Intrinsics.checkNotNullParameter(downloaderState, "downloaderState");
        Intrinsics.checkNotNullParameter(taskState, "taskState");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(errorState, "errorState");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-1375302095);
        ComposerKt.sourceInformation($composer2, "C(DownloadPageImplV2)P(3,15,16,4,14,13,12,11,2,7,6,8!1,10,9,5)122@5560L7,124@5626L2418,181@8069L188,186@8259L3837,124@5573L6523:DownloadPageV2.kt#k6dflz");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(downloaderState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(taskState) ? 32 : 16;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(showVideoCard) ? 16384 : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(showOutput) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(showDownloadProgress) ? 1048576 : 524288;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(processCount) ? 8388608 : 4194304;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 536870912 : 268435456;
        }
        int i8 = i & 1024;
        if (i8 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i9 = i & 2048;
        if (i9 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        int i10 = i & 4096;
        if (i10 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer2.changedInstance(function4) ? 256 : 128;
        }
        int i11 = i & 8192;
        if (i11 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer2.changedInstance(function5) ? 2048 : 1024;
        }
        int i12 = i & 32768;
        if (i12 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = isPreview;
        } else if (($changed1 & 458752) == 0) {
            z = isPreview;
            $dirty1 |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = isPreview;
        }
        if ((i & 65536) != 0) {
            $dirty1 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty1 |= $composer2.changedInstance(content) ? 1048576 : 524288;
        }
        if (($dirty & 1533911131) == 306782226 && (2954971 & $dirty1) == 590994 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            showVideoCard2 = showVideoCard;
            showOutput2 = showOutput;
            showDownloadProgress2 = showDownloadProgress;
            processCount2 = processCount;
            function7 = function0;
            function8 = function1;
            function9 = function2;
            function10 = function3;
            function11 = function4;
            function12 = function5;
            function13 = function6;
            isPreview2 = z;
        } else {
            boolean showVideoCard3 = i2 != 0 ? false : showVideoCard;
            boolean showOutput3 = i3 != 0 ? false : showOutput;
            final boolean showDownloadProgress3 = i4 != 0 ? false : showDownloadProgress;
            final int processCount3 = i5 != 0 ? 0 : processCount;
            final AnonymousClass1 anonymousClass1 = i6 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function0;
            final AnonymousClass2 anonymousClass2 = i7 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            final AnonymousClass3 anonymousClass3 = i8 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            final AnonymousClass4 anonymousClass4 = i9 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.4
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            AnonymousClass5 anonymousClass5 = i10 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.5
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function4;
            AnonymousClass6 anonymousClass6 = i11 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.6
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function5;
            AnonymousClass7 anonymousClass7 = (i & 16384) != 0 ? new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.7
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : function6;
            boolean isPreview3 = i12 != 0 ? false : isPreview;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1375302095, $dirty, $dirty1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2 (DownloadPageV2.kt:121)");
            }
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final HapticFeedback hapticFeedback = (HapticFeedback) objConsume;
            final Function0<Unit> function14 = anonymousClass5;
            final boolean z2 = showDownloadProgress3;
            final boolean z3 = showVideoCard3;
            final boolean z4 = showOutput3;
            final Function0<Unit> function15 = anonymousClass6;
            final boolean z5 = isPreview3;
            ScaffoldKt.m2282ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(304128757, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8
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
                    ComposerKt.sourceInformation($composer3, "C125@5723L691,143@6426L1611,125@5636L2402:DownloadPageV2.kt#k6dflz");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(304128757, $changed2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous> (DownloadPageV2.kt:125)");
                    }
                    Function2<Composer, Integer, Unit> function2M7270getLambda1$app_debug = ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7270getLambda1$app_debug();
                    Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 2, null);
                    final Function0<Unit> function16 = anonymousClass2;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(642410351, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.1
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
                            ComposerKt.sourceInformation($composer4, "C126@5756L22,127@5831L38,132@6051L352,126@5737L666:DownloadPageV2.kt#k6dflz");
                            if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(642410351, $changed3, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous> (DownloadPageV2.kt:126)");
                            }
                            TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer4, 0, 7);
                            PopupPositionProvider popupPositionProviderM2709rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2709rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer4, TooltipDefaults.$stable << 3, 1);
                            Function3<CaretScope, Composer, Integer, Unit> function3M7277getLambda3$app_debug = ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7277getLambda3$app_debug();
                            final Function0<Unit> function17 = function16;
                            TooltipKt.TooltipBox(popupPositionProviderM2709rememberPlainTooltipPositionProviderkHDZbjc, function3M7277getLambda3$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(1790164404, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer5, int $changed4) {
                                    Object value$iv;
                                    ComposerKt.sourceInformation($composer5, "C134@6111L24,133@6069L320:DownloadPageV2.kt#k6dflz");
                                    if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1790164404, $changed4, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:133)");
                                        }
                                        $composer5.startReplaceGroup(194491400);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):DownloadPageV2.kt#9igjgp");
                                        boolean invalid$iv = $composer5.changed(function17);
                                        final Function0<Unit> function18 = function17;
                                        Object it$iv = $composer5.rememberedValue();
                                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$DownloadPageImplV2$8$1$1$1$1
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
                                                    function18.invoke();
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv);
                                        } else {
                                            value$iv = it$iv;
                                        }
                                        $composer5.endReplaceGroup();
                                        IconButtonKt.IconButton((Function0) value$iv, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7278getLambda4$app_debug(), $composer5, 196656, 28);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54), $composer4, 1572912, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                    final int i13 = processCount3;
                    final Function0<Unit> function17 = anonymousClass4;
                    final Function0<Unit> function18 = anonymousClass3;
                    AppBarKt.m1675TopAppBarGHTll3U(function2M7270getLambda1$app_debug, modifierM622paddingVpY3zN4$default, composableLambdaRememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(1069919782, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TopAppBar, Composer $composer4, int $changed3) {
                            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                            ComposerKt.sourceInformation($composer4, "C144@6458L224,150@6684L701,144@6440L945,166@7417L22,167@7492L38,170@7660L367,166@7398L629:DownloadPageV2.kt#k6dflz");
                            if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1069919782, $changed3, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous> (DownloadPageV2.kt:144)");
                                }
                                final int i14 = i13;
                                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1341418670, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                        invoke(boxScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer $composer5, int $changed4) {
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        ComposerKt.sourceInformation($composer5, "C149@6643L25,145@6498L170:DownloadPageV2.kt#k6dflz");
                                        if (($changed4 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1341418670, $changed4, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:145)");
                                            }
                                            if (i14 > 0) {
                                                Modifier modifierM580offsetVpY3zN4 = OffsetKt.m580offsetVpY3zN4(Modifier.INSTANCE, Dp.m6553constructorimpl(-16), Dp.m6553constructorimpl(16));
                                                final int i15 = i14;
                                                BadgeKt.m1691BadgeeopBjH0(modifierM580offsetVpY3zN4, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(360483830, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                                        invoke(rowScope, composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(RowScope Badge, Composer $composer6, int $changed5) {
                                                        Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                        ComposerKt.sourceInformation($composer6, "C149@6645L21:DownloadPageV2.kt#k6dflz");
                                                        if (($changed5 & 81) == 16 && $composer6.getSkipping()) {
                                                            $composer6.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(360483830, $changed5, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:149)");
                                                        }
                                                        TextKt.m2569Text4IGK_g(String.valueOf(i15), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer6, 0, 0, 131070);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, $composer5, 54), $composer5, 3078, 6);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }, $composer4, 54);
                                final Function0<Unit> function19 = function17;
                                BadgeKt.BadgedBox(composableLambdaRememberComposableLambda2, null, ComposableLambdaKt.rememberComposableLambda(-921108372, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                        invoke(boxScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer $composer5, int $changed4) {
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        ComposerKt.sourceInformation($composer5, "C151@6721L22,152@6800L38,155@6976L395,151@6702L669:DownloadPageV2.kt#k6dflz");
                                        if (($changed4 & 81) == 16 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-921108372, $changed4, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:151)");
                                        }
                                        TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer5, 0, 7);
                                        PopupPositionProvider popupPositionProviderM2709rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2709rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer5, TooltipDefaults.$stable << 3, 1);
                                        Function3<CaretScope, Composer, Integer, Unit> function3M7279getLambda5$app_debug = ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7279getLambda5$app_debug();
                                        final Function0<Unit> function20 = function19;
                                        TooltipKt.TooltipBox(popupPositionProviderM2709rememberPlainTooltipPositionProviderkHDZbjc, function3M7279getLambda5$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(-1146912697, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer6, int $changed5) {
                                                Object value$iv;
                                                ComposerKt.sourceInformation($composer6, "C157@7044L26,156@6998L355:DownloadPageV2.kt#k6dflz");
                                                if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1146912697, $changed5, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:156)");
                                                    }
                                                    $composer6.startReplaceGroup(620807246);
                                                    ComposerKt.sourceInformation($composer6, "CC(remember):DownloadPageV2.kt#9igjgp");
                                                    boolean invalid$iv = $composer6.changed(function20);
                                                    final Function0<Unit> function21 = function20;
                                                    Object it$iv = $composer6.rememberedValue();
                                                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$DownloadPageImplV2$8$2$2$1$1$1
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
                                                                function21.invoke();
                                                            }
                                                        };
                                                        $composer6.updateRememberedValue(value$iv);
                                                    } else {
                                                        value$iv = it$iv;
                                                    }
                                                    $composer6.endReplaceGroup();
                                                    IconButtonKt.IconButton((Function0) value$iv, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7280getLambda6$app_debug(), $composer6, 196656, 28);
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
                                        }
                                    }
                                }, $composer4, 54), $composer4, 390, 2);
                                TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, false, null, $composer4, 0, 7);
                                PopupPositionProvider popupPositionProviderM2709rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2709rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer4, TooltipDefaults.$stable << 3, 1);
                                Function3<CaretScope, Composer, Integer, Unit> function3M7281getLambda7$app_debug = ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7281getLambda7$app_debug();
                                final Function0<Unit> function20 = function18;
                                TooltipKt.TooltipBox(popupPositionProviderM2709rememberPlainTooltipPositionProviderkHDZbjc, function3M7281getLambda7$app_debug, tooltipStateRememberTooltipState, null, false, false, ComposableLambdaKt.rememberComposableLambda(1699255681, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.8.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer5, int $changed4) {
                                        Object value$iv;
                                        ComposerKt.sourceInformation($composer5, "C172@7720L25,171@7678L335:DownloadPageV2.kt#k6dflz");
                                        if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1699255681, $changed4, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:171)");
                                            }
                                            $composer5.startReplaceGroup(194493009);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadPageV2.kt#9igjgp");
                                            boolean invalid$iv = $composer5.changed(function20);
                                            final Function0<Unit> function21 = function20;
                                            Object it$iv = $composer5.rememberedValue();
                                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$DownloadPageImplV2$8$2$3$1$1
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
                                                        function21.invoke();
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv);
                                            } else {
                                                value$iv = it$iv;
                                            }
                                            $composer5.endReplaceGroup();
                                            IconButtonKt.IconButton((Function0) value$iv, Modifier.INSTANCE, false, null, null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7282getLambda8$app_debug(), $composer5, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }, $composer4, 54), $composer4, 1572912, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54), 0.0f, null, null, null, $composer3, 3510, 240);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-698884872, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.9
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
                    ComposerKt.sourceInformation($composer3, "C182@8079L172:DownloadPageV2.kt#k6dflz");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-698884872, $changed2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous> (DownloadPageV2.kt:182)");
                        }
                        Modifier.Companion $this$invoke_u24lambda_u240 = Modifier.INSTANCE;
                        DownloadPageV2Kt.FABs(showDownloadProgress3 ? $this$invoke_u24lambda_u240 : WindowInsetsPadding_androidKt.imePadding($this$invoke_u24lambda_u240), anonymousClass1, $composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1556885056, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.10
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

                public final void invoke(PaddingValues it, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function16;
                    Function0<ComposeUiNode> function17;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer3, "C191@8401L21,187@8269L3821:DownloadPageV2.kt#k6dflz");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer3.changed(it) ? 4 : 2;
                    }
                    if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556885056, $dirty2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous> (DownloadPageV2.kt:187)");
                    }
                    Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, it), 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                    Downloader.State $this$invoke_u24lambda_u244_u24lambda_u240 = downloaderState;
                    final Function0<Unit> function18 = function14;
                    final HapticFeedback hapticFeedback2 = hapticFeedback;
                    final Downloader.DownloadTaskItem $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242 = taskState;
                    Function2<Composer, Integer, Unit> function19 = content;
                    boolean z6 = z2;
                    boolean z7 = z3;
                    boolean z8 = z4;
                    final Function0<Unit> function20 = function15;
                    final boolean z9 = z5;
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
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
                        function16 = constructor;
                        $composer3.createNode(function16);
                    } else {
                        function16 = constructor;
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
                    int i13 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i14 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1265731336, "C193@8448L974,208@9437L2643:DownloadPageV2.kt#k6dflz");
                    boolean z10 = $this$invoke_u24lambda_u244_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist;
                    DownloadPageV2Kt.TitleWithProgressIndicator($this$invoke_u24lambda_u244_u24lambda_u240 instanceof Downloader.State.FetchingInfo, z10 || ($this$invoke_u24lambda_u244_u24lambda_u240 instanceof Downloader.State.DownloadingVideo), z10, $this$invoke_u24lambda_u244_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist ? ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u244_u24lambda_u240).getCurrentItem() : 0, $this$invoke_u24lambda_u244_u24lambda_u240 instanceof Downloader.State.DownloadingPlaylist ? ((Downloader.State.DownloadingPlaylist) $this$invoke_u24lambda_u244_u24lambda_u240).getItemCount() : 0, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$DownloadPageImplV2$10$1$3
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
                            function18.invoke();
                            hapticFeedback2.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
                        }
                    }, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$DownloadPageImplV2$10$1$4
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
                            PreferenceUtil.INSTANCE.encodeInt(PreferenceUtilKt.WELCOME_DIALOG, 1);
                            hapticFeedback2.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
                        }
                    }, $composer3, 0, 0);
                    Modifier modifier$iv2 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(24), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(24), 0.0f, 0.0f, 13, null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv2 = (6 << 3) & 112;
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
                        function17 = constructor2;
                        $composer3.createNode(function17);
                    } else {
                        function17 = constructor2;
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
                    int i15 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    int $changed3 = ((6 >> 6) & 112) | 6;
                    ColumnScope $this$invoke_u24lambda_u244_u24lambda_u243 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 194494882, "C251@11364L9,266@11986L21,267@12024L42:DownloadPageV2.kt#k6dflz");
                    $composer3.startReplaceGroup(194494882);
                    ComposerKt.sourceInformation($composer3, "*216@9745L549,214@9631L663,234@10617L377,229@10315L679");
                    AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u244_u24lambda_u243, z6 && z7, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(700498442, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$DownloadPageImplV2$10$1$5$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                            invoke(animatedVisibilityScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed4) {
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            ComposerKt.sourceInformation($composer4, "C217@9771L501:DownloadPageV2.kt#k6dflz");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(700498442, $changed4, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:217)");
                            }
                            DownloadPageV2Kt.VideoCardV2(Modifier.INSTANCE, $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getTitle(), $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getUploader(), $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getThumbnailUrl(), function20, $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getProgress(), $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getFileSizeApprox(), $this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getDuration(), z9, $composer4, 6, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54), $composer3, ($changed3 & 14) | 1572864, 30);
                    AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u244_u24lambda_u243, ($this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getProgressText().length() > 0) && z8, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-1802277247, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$DownloadPageImplV2$10$1$5$1$2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                            invoke(animatedVisibilityScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed4) {
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            ComposerKt.sourceInformation($composer4, "C240@10925L10,235@10643L329:DownloadPageV2.kt#k6dflz");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1802277247, $changed4, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageImplV2.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:235)");
                            }
                            TextKt.m2569Text4IGK_g($this$invoke_u24lambda_u244_u24lambda_u243_u24lambda_u242.getProgressText(), PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyMedium(), $composer4, 48, 3120, 55292);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54), $composer3, ($changed3 & 14) | 1600896, 16);
                    $composer3.endReplaceGroup();
                    function19.invoke($composer3, 0);
                    CommonComponentsKt.NavigationBarSpacer(null, $composer3, 0, 1);
                    SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(160)), $composer3, 6);
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
            }, $composer2, 54), $composer2, 805330998, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = anonymousClass1;
            showVideoCard2 = showVideoCard3;
            function8 = anonymousClass2;
            function9 = anonymousClass3;
            function10 = anonymousClass4;
            processCount2 = processCount3;
            function11 = anonymousClass5;
            function12 = anonymousClass6;
            showOutput2 = showOutput3;
            showDownloadProgress2 = showDownloadProgress3;
            isPreview2 = isPreview3;
            function13 = anonymousClass7;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z6 = showVideoCard2;
            final boolean z7 = showOutput2;
            final boolean z8 = showDownloadProgress2;
            final int i13 = processCount2;
            final Function0<Unit> function16 = function7;
            final Function0<Unit> function17 = function8;
            final Function0<Unit> function18 = function9;
            final Function0<Unit> function19 = function10;
            final Function0<Unit> function20 = function11;
            final Function0<Unit> function21 = function12;
            final Function1<? super String, Unit> function22 = function13;
            final boolean z9 = isPreview2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPageImplV2.11
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

                public final void invoke(Composer composer, int i14) {
                    DownloadPageV2Kt.DownloadPageImplV2(downloaderState, taskState, viewState, errorState, z6, z7, z8, i13, function16, function17, function18, function19, function20, function21, function22, z9, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void InputUrl(final String url, final boolean error, boolean showDownloadProgress, final float progress, final Function0<Unit> onDone, final Function1<? super String, Unit> onValueChange, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean showDownloadProgress2;
        Object value$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-725753231);
        ComposerKt.sourceInformation($composer3, "C(InputUrl)P(5!1,4,3)284@12390L29,285@12461L7,286@12538L7,296@12887L10,298@12954L127,287@12550L797,309@13403L994,309@13352L1045:DownloadPageV2.kt#k6dflz");
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
        int i2 = i & 4;
        if (i2 != 0) {
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
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onDone) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            showDownloadProgress2 = z;
            $composer2 = $composer3;
        } else {
            showDownloadProgress2 = i2 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-725753231, $dirty2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.InputUrl (DownloadPageV2.kt:283)");
            }
            $composer3.startReplaceGroup(-1022255942);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadPageV2.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new FocusRequester();
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            FocusRequester focusRequester = (FocusRequester) value$iv;
            $composer3.endReplaceGroup();
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final FocusManager focusManager = (FocusManager) objConsume;
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume2;
            Modifier.Companion companion = Modifier.INSTANCE;
            float $this$dp$iv = Dp.m6553constructorimpl(0.0f);
            float $this$dp$iv2 = Dp.m6553constructorimpl(16.0f);
            OutlinedTextFieldKt.OutlinedTextField(url, onValueChange, FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(PaddingKt.m621paddingVpY3zN4(companion, $this$dp$iv, $this$dp$iv2), 0.0f, 1, null), focusRequester), false, false, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7283getLambda9$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(376888602, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.InputUrl.2
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
                    ComposerKt.sourceInformation($composer4, "C299@13002L21,299@12990L33:DownloadPageV2.kt#k6dflz");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(376888602, $changed2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.InputUrl.<anonymous> (DownloadPageV2.kt:299)");
                    }
                    if (url.length() > 0) {
                        $composer4.startReplaceGroup(-196820161);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadPageV2.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(onValueChange);
                        final Function1<String, Unit> function1 = onValueChange;
                        Object it$iv2 = $composer4.rememberedValue();
                        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$InputUrl$2$1$1
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
            }, $composer3, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, error, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.InputUrl.1
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
                    SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                    if (softwareKeyboardController2 != null) {
                        softwareKeyboardController2.hide();
                    }
                    focusManager.mo3728moveFocus3ESFkO8(FocusDirection.INSTANCE.m3719getDowndhqQ8s());
                    onDone.invoke();
                }
            }, null, null, null, null, null, 62, null), false, 3, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer3, ($dirty2 & 14) | 806879232 | (($dirty2 >> 12) & 112), (($dirty2 << 6) & 7168) | 100859904, 0, 8019352);
            $composer2 = $composer3;
            AnimatedVisibilityKt.AnimatedVisibility(showDownloadProgress2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1041360231, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.InputUrl.3
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
                    Function0<ComposeUiNode> function0;
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation($composer4, "C310@13413L978:DownloadPageV2.kt#k6dflz");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1041360231, $changed2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.InputUrl.<anonymous> (DownloadPageV2.kt:310)");
                    }
                    Modifier modifier$iv = PaddingKt.m621paddingVpY3zN4(Modifier.INSTANCE, Dp.m6553constructorimpl(0), Dp.m6553constructorimpl(12));
                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                    float f = progress;
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv = (390 << 3) & 112;
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
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i4 = ((390 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, 482721791, "C314@13575L171,329@14201L180:DownloadPageV2.kt#k6dflz");
                    State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f / 100.0f, AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, null, null, $composer4, 0, 28);
                    if (invoke$lambda$1$lambda$0(stateAnimateFloatAsState) < 0.0f) {
                        $composer4.startReplaceGroup(482722037);
                        ComposerKt.sourceInformation($composer4, "321@13927L6,318@13791L164");
                        ProgressIndicatorKt.m2249LinearProgressIndicatorrIrjwxo(ClipKt.clip(RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 0.75f, false, 2, null), MaterialTheme.INSTANCE.getShapes($composer4, MaterialTheme.$stable).getLarge()), 0L, 0L, 0, 0.0f, $composer4, 0, 30);
                        $composer4.endReplaceGroup();
                    } else {
                        $composer4.startReplaceGroup(482722219);
                        ComposerKt.sourceInformation($composer4, "327@14160L6,323@13973L215");
                        ProgressIndicatorKt.m2246LinearProgressIndicator_5eSRE(invoke$lambda$1$lambda$0(stateAnimateFloatAsState), ClipKt.clip(RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 0.75f, false, 2, null), MaterialTheme.INSTANCE.getShapes($composer4, MaterialTheme.$stable).getLarge()), 0L, 0L, 0, $composer4, 0, 28);
                        $composer4.endReplaceGroup();
                    }
                    TextKt.m2569Text4IGK_g(f < 0.0f ? "0%" : f + "%", RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 0.25f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6403boximpl(TextAlign.INSTANCE.m6410getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 130556);
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

                private static final float invoke$lambda$1$lambda$0(State<Float> state) {
                    Object thisObj$iv = state.getValue();
                    return ((Number) thisObj$iv).floatValue();
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = showDownloadProgress2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.InputUrl.4
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
                    DownloadPageV2Kt.InputUrl(url, error, z2, progress, onDone, onValueChange, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0368  */
    /* JADX WARN: Code duplicated, block: B:108:0x0374  */
    /* JADX WARN: Code duplicated, block: B:109:0x037a  */
    /* JADX WARN: Code duplicated, block: B:120:0x04b7  */
    public static final void TitleWithProgressIndicator(boolean showProgressIndicator, boolean showCancelOperation, boolean isDownloadingPlaylist, int currentIndex, int downloadItemCount, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean showCancelOperation2;
        Function0<Unit> function2;
        boolean isDownloadingPlaylist2;
        Modifier modifier$iv;
        int currentIndex2;
        int downloadItemCount2;
        Function0<ComposeUiNode> function3;
        boolean showCancelOperation3;
        Function0<Unit> function4;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function5;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        boolean isDownloadingPlaylist3;
        Function0<Unit> function6;
        boolean showProgressIndicator2;
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(-372455600);
        ComposerKt.sourceInformation($composer2, "C(TitleWithProgressIndicator)P(6,5,2)349@14744L1674:DownloadPageV2.kt#k6dflz");
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
            showCancelOperation2 = showCancelOperation;
        } else if (($changed & 112) == 0) {
            showCancelOperation2 = showCancelOperation;
            $dirty |= $composer2.changed(showCancelOperation2) ? 32 : 16;
        } else {
            showCancelOperation2 = showCancelOperation;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = function0;
        } else if (($changed & 458752) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 131072 : 65536;
        } else {
            function2 = function0;
        }
        int $dirty2 = $dirty;
        if ((327771 & $dirty2) == 65554 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            isDownloadingPlaylist3 = isDownloadingPlaylist;
            currentIndex2 = currentIndex;
            downloadItemCount2 = downloadItemCount;
            function6 = function1;
            showCancelOperation3 = showCancelOperation2;
            function4 = function2;
            showProgressIndicator2 = z;
        } else {
            boolean showProgressIndicator3 = i2 != 0 ? true : z;
            if (i3 != 0) {
                showCancelOperation2 = true;
            }
            boolean isDownloadingPlaylist4 = (i & 4) != 0 ? true : isDownloadingPlaylist;
            int currentIndex3 = (i & 8) != 0 ? 1 : currentIndex;
            int downloadItemCount3 = (i & 16) != 0 ? 4 : downloadItemCount;
            final C09591 c09591 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.TitleWithProgressIndicator.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            C09602 c09602 = (i & 64) != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.TitleWithProgressIndicator.2
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
                ComposerKt.traceEventStart(-372455600, $dirty2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.TitleWithProgressIndicator (DownloadPageV2.kt:348)");
            }
            $composer2.startReplaceGroup(887852063);
            ComposerKt.sourceInformation($composer2, "");
            Modifier $this$TitleWithProgressIndicator_u24lambda_u243 = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), Dp.m6553constructorimpl(24), 0.0f, 0.0f, 12, null);
            $composer2.startReplaceGroup(887852124);
            ComposerKt.sourceInformation($composer2, "351@14896L39,352@14965L13");
            if (showCancelOperation2) {
                $composer2.startReplaceGroup(-547780794);
                ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPageV2.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) value$iv;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(-547780725);
                ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPageV2.kt#9igjgp");
                boolean invalid$iv = ($dirty2 & 458752) == 131072;
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                    isDownloadingPlaylist2 = isDownloadingPlaylist4;
                } else {
                    isDownloadingPlaylist2 = isDownloadingPlaylist4;
                    if (it$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv2 = it$iv2;
                    }
                    $composer2.endReplaceGroup();
                    modifier$iv = ClickableKt.m236clickableO2vRcR0($this$TitleWithProgressIndicator_u24lambda_u243, mutableInteractionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2);
                }
                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$TitleWithProgressIndicator$3$2$1
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
                        c09591.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                $composer2.endReplaceGroup();
                modifier$iv = ClickableKt.m236clickableO2vRcR0($this$TitleWithProgressIndicator_u24lambda_u243, mutableInteractionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2);
            } else {
                isDownloadingPlaylist2 = isDownloadingPlaylist4;
                modifier$iv = $this$TitleWithProgressIndicator_u24lambda_u243;
            }
            $composer2.endReplaceGroup();
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            currentIndex2 = currentIndex3;
            downloadItemCount2 = downloadItemCount3;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function3 = constructor2;
                $composer2.createNode(function3);
            } else {
                function3 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
            showCancelOperation3 = showCancelOperation2;
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                function4 = c09591;
            } else {
                function4 = c09591;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -547780684, "C356@15079L6,354@15006L750:DownloadPageV2.kt#k6dflz");
                Modifier modifier$iv2 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(ClipKt.clip(Modifier.INSTANCE, MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getExtraLarge()), Dp.m6553constructorimpl(12), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(12), 0.0f, Dp.m6553constructorimpl(3), 5, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                int $i$f$Row = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, $i$f$Row);
                int $changed$iv$iv2 = (0 << 3) & 112;
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
                    function5 = constructor;
                    $composer2.createNode(function5);
                } else {
                    function5 = constructor;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScope $this$TitleWithProgressIndicator_u24lambda_u245_u24lambda_u244 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1124571563, "C362@15286L33,363@15359L10,360@15220L176,365@15409L337:DownloadPageV2.kt#k6dflz");
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.app_name, $composer2, 0), (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getDisplaySmall(), $composer2, 48, 0, 65532);
                AnimatedVisibilityKt.AnimatedVisibility($this$TitleWithProgressIndicator_u24lambda_u245_u24lambda_u244, showProgressIndicator3, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7271getLambda10$app_debug(), $composer2, ((((0 >> 6) & 112) | 6) & 14) | 1572864 | (($dirty2 << 3) & 112), 30);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                isDownloadingPlaylist3 = isDownloadingPlaylist2;
                function6 = c09602;
                showProgressIndicator2 = showProgressIndicator3;
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -547780684, "C356@15079L6,354@15006L750:DownloadPageV2.kt#k6dflz");
            Modifier modifier$iv3 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(ClipKt.clip(Modifier.INSTANCE, MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getExtraLarge()), Dp.m6553constructorimpl(12), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(12), 0.0f, Dp.m6553constructorimpl(3), 5, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
            int $i$f$Row2 = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, $i$f$Row2);
            int $changed$iv$iv3 = (0 << 3) & 112;
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
                function5 = constructor;
                $composer2.createNode(function5);
            } else {
                function5 = constructor;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScope $this$TitleWithProgressIndicator_u24lambda_u245_u24lambda_u245 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1124571563, "C362@15286L33,363@15359L10,360@15220L176,365@15409L337:DownloadPageV2.kt#k6dflz");
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.app_name, $composer2, 0), (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getDisplaySmall(), $composer2, 48, 0, 65532);
            AnimatedVisibilityKt.AnimatedVisibility($this$TitleWithProgressIndicator_u24lambda_u245_u24lambda_u245, showProgressIndicator3, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7271getLambda10$app_debug(), $composer2, ((((0 >> 6) & 112) | 6) & 14) | 1572864 | (($dirty2 << 3) & 112), 30);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isDownloadingPlaylist3 = isDownloadingPlaylist2;
            function6 = c09602;
            showProgressIndicator2 = showProgressIndicator3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = showProgressIndicator2;
            final boolean z3 = showCancelOperation3;
            final boolean z4 = isDownloadingPlaylist3;
            final int i11 = currentIndex2;
            final int i12 = downloadItemCount2;
            final Function0<Unit> function7 = function4;
            final Function0<Unit> function8 = function6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.TitleWithProgressIndicator.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i13) {
                    DownloadPageV2Kt.TitleWithProgressIndicator(z2, z3, z4, i11, i12, function7, function8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void ErrorMessage(Modifier modifier, final String url, String errorReport, final int errorMessageResId, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Modifier modifier3;
        Function0<ComposeUiNode> function0;
        String errorReport2;
        Intrinsics.checkNotNullParameter(url, "url");
        Composer $composer2 = $composer.startRestartGroup(-235280029);
        ComposerKt.sourceInformation($composer2, "C(ErrorMessage)P(2,3,1)396@16615L7,397@16654L7,398@16666L926:DownloadPageV2.kt#k6dflz");
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
            $dirty |= $composer2.changed(url) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            str = errorReport;
        } else if (($changed & 896) == 0) {
            str = errorReport;
            $dirty |= $composer2.changed(str) ? 256 : 128;
        } else {
            str = errorReport;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(errorMessageResId) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            errorReport2 = str;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            final String errorReport3 = i3 != 0 ? "" : str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-235280029, $dirty2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.ErrorMessage (DownloadPageV2.kt:395)");
            }
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ClipboardManager clipboardManager = (ClipboardManager) objConsume;
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) objConsume2;
            $composer2.startReplaceGroup(-1726514966);
            ComposerKt.sourceInformation($composer2, "");
            Modifier $this$ErrorMessage_u24lambda_u246 = SizeKt.fillMaxWidth$default(PaddingKt.m624paddingqDBjuR0$default(modifier4, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            $composer2.startReplaceGroup(-1726514948);
            ComposerKt.sourceInformation($composer2, "403@16837L6");
            Modifier modifierM239clickableXHw0xAI$default = errorReport3.length() > 0 ? ClickableKt.m239clickableXHw0xAI$default(ClipKt.clip($this$ErrorMessage_u24lambda_u246, MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getLarge()), false, null, null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$ErrorMessage$1$1
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
                    clipboardManager.setText(new AnnotatedString(App.INSTANCE.getVersionReport() + "\nURL: " + url + IOUtils.LINE_SEPARATOR_UNIX + errorReport3, null, null, 6, null));
                    ToastUtil toastUtil = ToastUtil.INSTANCE;
                    String string = context.getString(R.string.error_copied);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    toastUtil.makeToastSuspend(string);
                }
            }, 7, null) : $this$ErrorMessage_u24lambda_u246;
            $composer2.endReplaceGroup();
            $composer2.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.m621paddingVpY3zN4(modifierM239clickableXHw0xAI$default, Dp.m6553constructorimpl(8), Dp.m6553constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 946148795, "C411@17272L11,410@17184L115,418@17559L11,413@17308L278:DownloadPageV2.kt#k6dflz");
            IconKt.m2044Iconww6aTOc(ErrorKt.getError(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getError(), $composer2, 48, 4);
            int iM6460getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8();
            Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 0.0f, 14, null);
            $composer2.startReplaceGroup(946149084);
            ComposerKt.sourceInformation($composer2, "*417@17483L38");
            String strStringResource = errorReport3;
            if (strStringResource.length() == 0) {
                strStringResource = StringResources_androidKt.stringResource(errorMessageResId, $composer2, ($dirty2 >> 9) & 14);
            }
            $composer2.endReplaceGroup();
            TextKt.m2569Text4IGK_g(strStringResource, modifierM624paddingqDBjuR0$default, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, iM6460getEllipsisgIe3tQ8, false, 10, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 48, 3120, 120824);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            errorReport2 = errorReport3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str2 = errorReport2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.ErrorMessage.3
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
                    DownloadPageV2Kt.ErrorMessage(modifier5, url, str2, errorMessageResId, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x01fa  */
    public static final void FABs(Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final Function0<Unit> function1;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(931949415);
        ComposerKt.sourceInformation($composer2, "C(FABs)P(1)429@17701L442:DownloadPageV2.kt#k6dflz");
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
            function1 = function0;
        } else if (($changed & 112) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if (($dirty & 91) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            C09521 c09521 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.FABs.1
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
                ComposerKt.traceEventStart(931949415, $dirty, -1, "com.videshkarmakar.loop.ui.page.downloadv2.FABs (DownloadPageV2.kt:428)");
            }
            Modifier modifier$iv = PaddingKt.m620padding3ABfNKs(modifier4, Dp.m6553constructorimpl(6));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                modifier3 = modifier4;
            } else {
                modifier3 = modifier4;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i5 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -531059494, "C432@17804L333:DownloadPageV2.kt#k6dflz");
                FloatingActionButtonKt.m2019FloatingActionButtonXz6DiA(c09521, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 1, null), null, 0L, 0L, null, null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7272getLambda11$app_debug(), $composer2, (($dirty >> 3) & 14) | 12582960, 124);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function1 = c09521;
                modifier2 = modifier3;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -531059494, "C432@17804L333:DownloadPageV2.kt#k6dflz");
            FloatingActionButtonKt.m2019FloatingActionButtonXz6DiA(c09521, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 1, null), null, 0L, 0L, null, null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7272getLambda11$app_debug(), $composer2, (($dirty >> 3) & 14) | 12582960, 124);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = c09521;
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.FABs.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    DownloadPageV2Kt.FABs(modifier2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadPagePreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(525884979);
        ComposerKt.sourceInformation($composer2, "C(DownloadPagePreview)450@18333L726:DownloadPageV2.kt#k6dflz");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(525884979, $changed, -1, "com.videshkarmakar.loop.ui.page.downloadv2.DownloadPagePreview (DownloadPageV2.kt:449)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7274getLambda13$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.DownloadPagePreview.1
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
                    DownloadPageV2Kt.DownloadPagePreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void NextTask(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1318425174);
        ComposerKt.sourceInformation($composer2, "C(NextTask)475@19096L1624:DownloadPageV2.kt#k6dflz");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1318425174, $changed, -1, "com.videshkarmakar.loop.ui.page.downloadv2.NextTask (DownloadPageV2.kt:474)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1393913812, "C477@19114L41,480@19245L10,478@19164L167,483@19340L41,486@19431L6,487@19521L11,487@19479L74,485@19391L1323:DownloadPageV2.kt#k6dflz");
            SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer2, 6);
            TextKt.m2569Text4IGK_g("Next download task", PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelLarge(), $composer2, 54, 0, 65532);
            SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer2, 6);
            CardKt.Card(null, MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getSmall(), CardDefaults.INSTANCE.m1731cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, null, ComposableSingletons$DownloadPageV2Kt.INSTANCE.m7275getLambda14$app_debug(), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 25);
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
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.NextTask.2
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
                    DownloadPageV2Kt.NextTask(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:158:0x02c1  */
    public static final void VideoCardV2(Modifier modifier, String title, String author, Object thumbnailUrl, Function0<Unit> function0, float progress, double fileSizeApprox, int duration, boolean isPreview, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function1;
        float f;
        double fileSizeApprox2;
        String title2;
        String author2;
        Object thumbnailUrl2;
        final C09621 c09621;
        float progress2;
        boolean isPreview2;
        int $dirty;
        int $dirty2;
        Modifier modifier2;
        int $dirty3;
        int duration2;
        Modifier modifier3;
        String author3;
        boolean isPreview3;
        String title3;
        Object thumbnailUrl3;
        Function0<Unit> function2;
        double fileSizeApprox3;
        float progress3;
        Composer $composer2 = $composer.startRestartGroup(149575774);
        ComposerKt.sourceInformation($composer2, "C(VideoCardV2)P(4,8!1,7,5,6,2)525@20849L48,526@20920L50,537@21284L6,538@21370L11,538@21328L74,536@21239L13,539@21409L2619,534@21171L2857:DownloadPageV2.kt#k6dflz");
        int $dirty4 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty4 |= ((i & 2) == 0 && $composer2.changed(title)) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty4 |= ((i & 4) == 0 && $composer2.changed(author)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            function1 = function0;
        } else if (($changed & 57344) == 0) {
            function1 = function0;
            $dirty4 |= $composer2.changedInstance(function1) ? 16384 : 8192;
        } else {
            function1 = function0;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f = progress;
        } else if ((458752 & $changed) == 0) {
            f = progress;
            $dirty4 |= $composer2.changed(f) ? 131072 : 65536;
        } else {
            f = progress;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty4 |= 1572864;
            fileSizeApprox2 = fileSizeApprox;
        } else if (($changed & 3670016) == 0) {
            fileSizeApprox2 = fileSizeApprox;
            $dirty4 |= $composer2.changed(fileSizeApprox2) ? 1048576 : 524288;
        } else {
            fileSizeApprox2 = fileSizeApprox;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty4 |= $composer2.changed(duration) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty4 |= $composer2.changed(isPreview) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (i3 == 8 && (191739611 & $dirty4) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            title3 = title;
            thumbnailUrl3 = thumbnailUrl;
            duration2 = duration;
            isPreview3 = isPreview;
            fileSizeApprox3 = fileSizeApprox2;
            function2 = function1;
            progress3 = f;
            author3 = author;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    title2 = StringResources_androidKt.stringResource(R.string.video_title_sample_text, $composer2, 0);
                    $dirty4 &= -113;
                } else {
                    title2 = title;
                }
                if ((i & 4) != 0) {
                    author2 = StringResources_androidKt.stringResource(R.string.video_creator_sample_text, $composer2, 0);
                    $dirty4 &= -897;
                } else {
                    author2 = author;
                }
                thumbnailUrl2 = i3 != 0 ? "" : thumbnailUrl;
                c09621 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.VideoCardV2.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function1;
                progress2 = i5 != 0 ? 100.0f : f;
                if (i6 != 0) {
                    fileSizeApprox2 = 7.2351744E7d;
                }
                int duration3 = i7 != 0 ? 359 : duration;
                if (i8 != 0) {
                    isPreview2 = false;
                    $dirty = $dirty4;
                    $dirty2 = duration3;
                    modifier2 = modifier4;
                } else {
                    isPreview2 = isPreview;
                    $dirty = $dirty4;
                    $dirty2 = duration3;
                    modifier2 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty4 &= -113;
                }
                if ((i & 4) != 0) {
                    int i9 = $dirty4 & (-897);
                    title2 = title;
                    author2 = author;
                    thumbnailUrl2 = thumbnailUrl;
                    $dirty2 = duration;
                    isPreview2 = isPreview;
                    c09621 = function1;
                    progress2 = f;
                    $dirty = i9;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    title2 = title;
                    author2 = author;
                    thumbnailUrl2 = thumbnailUrl;
                    isPreview2 = isPreview;
                    c09621 = function1;
                    progress2 = f;
                    $dirty = $dirty4;
                    $dirty2 = duration;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(149575774, $dirty, -1, "com.videshkarmakar.loop.ui.page.downloadv2.VideoCardV2 (DownloadPageV2.kt:533)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null);
            CornerBasedShape small = MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getSmall();
            Modifier modifier5 = modifier2;
            int $dirty5 = $dirty;
            CardColors cardColorsM1731cardColorsro_MJ88 = CardDefaults.INSTANCE.m1731cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerLow(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14);
            $composer2.startReplaceGroup(810425911);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadPageV2.kt#9igjgp");
            boolean invalid$iv = (57344 & $dirty5) == 16384;
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv) {
                $dirty3 = $dirty5;
            } else {
                $dirty3 = $dirty5;
                if (value$iv == Composer.INSTANCE.getEmpty()) {
                }
                $composer2.endReplaceGroup();
                final float f2 = progress2;
                final Object obj = thumbnailUrl2;
                final boolean z = isPreview2;
                final double d = fileSizeApprox2;
                final int i10 = $dirty2;
                final String str = title2;
                final String str2 = author2;
                int duration4 = $dirty2;
                CardKt.Card((Function0) value$iv, modifierFillMaxWidth$default, false, small, cardColorsM1731cardColorsro_MJ88, null, null, null, ComposableLambdaKt.rememberComposableLambda(-289785911, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.VideoCardV2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code duplicated, block: B:42:0x03ef  */
                    /* JADX WARN: Code duplicated, block: B:45:0x03fb  */
                    /* JADX WARN: Code duplicated, block: B:46:0x0401  */
                    /* JADX WARN: Code duplicated, block: B:57:0x056f  */
                    /* JADX WARN: Code duplicated, block: B:58:0x0599  */
                    /* JADX WARN: Code duplicated, block: B:61:0x05e7  */
                    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
                    public final void invoke(ColumnScope Card, Composer $composer3, int $changed2) {
                        Function0<ComposeUiNode> function3;
                        boolean propagateMinConstraints$iv;
                        int compositeKeyHash$iv$iv;
                        Function0<ComposeUiNode> constructor;
                        Function0<ComposeUiNode> function4;
                        Composer $this$Layout_u24lambda_u240$iv$iv;
                        State<Float> stateAnimateFloatAsState;
                        Intrinsics.checkNotNullParameter(Card, "$this$Card");
                        ComposerKt.sourceInformation($composer3, "C540@21419L2603:DownloadPageV2.kt#k6dflz");
                        if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-289785911, $changed2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.VideoCardV2.<anonymous> (DownloadPageV2.kt:540)");
                            }
                            float f3 = f2;
                            Object obj2 = obj;
                            boolean z2 = z;
                            final double d2 = d;
                            final int i11 = i10;
                            String str3 = str;
                            String str4 = str2;
                            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i12 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i13 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 785332674, "C541@21440L1286,572@22740L787,593@23570L154:DownloadPageV2.kt#k6dflz");
                            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv2 = (6 << 3) & 112;
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
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                                propagateMinConstraints$iv = false;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                }
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i14 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                int i15 = ((6 >> 6) & 112) | 6;
                                BoxScope $this$invoke_u24lambda_u243_u24lambda_u240 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1214035694, "C547@21745L6,542@21487L475,558@22223L6,559@22259L452,553@21979L732:DownloadPageV2.kt#k6dflz");
                                AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(obj2, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z2, $composer3, 1572920, 0, 952);
                                Modifier modifierAlign = $this$invoke_u24lambda_u243_u24lambda_u240.align(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                                long jM4069getBlack0d7_KjU = Color.INSTANCE.m4069getBlack0d7_KjU();
                                SurfaceKt.m2418SurfaceT9BRK9s(modifierAlign, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraSmall(), Color.m4041copywmQWz5c(jM4069getBlack0d7_KjU, (14 & 1) != 0 ? Color.m4045getAlphaimpl(jM4069getBlack0d7_KjU) : 0.68f, (14 & 2) != 0 ? Color.m4049getRedimpl(jM4069getBlack0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(jM4069getBlack0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(jM4069getBlack0d7_KjU) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1051198766, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$VideoCardV2$3$1$1$1
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
                                        ComposerKt.sourceInformation($composer4, "C560@22315L16,565@22605L10,562@22417L276:DownloadPageV2.kt#k6dflz");
                                        if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1051198766, $changed3, -1, "com.videshkarmakar.loop.ui.page.downloadv2.VideoCardV2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:560)");
                                            }
                                            String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d2), $composer4, 0);
                                            String durationText = TextUtilKt.toDurationText(i11);
                                            TextKt.m2569Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4080getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 432, 0, 65528);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }, $composer3, 54), $composer3, 12583296, 120);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifier$iv3 = PaddingKt.m620padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12));
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                int $changed$iv$iv3 = (390 << 3) & 112;
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
                                    function4 = constructor;
                                    $composer3.createNode(function4);
                                } else {
                                    function4 = constructor;
                                    $composer3.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                                }
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i16 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                int i17 = ((390 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1214034238, "C580@23025L10,578@22943L210,587@23314L10,588@23379L11,584@23170L343:DownloadPageV2.kt#k6dflz");
                                TextKt.m2569Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 3120, 55294);
                                TextKt.m2569Text4IGK_g(str4, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 48, 3120, 55288);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                                if (f3 < 0.0f) {
                                    $composer3.startReplaceGroup(785334990);
                                    ComposerKt.sourceInformation($composer3, "597@23756L90");
                                    ProgressIndicatorKt.m2249LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer3, 6, 30);
                                    $composer3.endReplaceGroup();
                                } else {
                                    $composer3.startReplaceGroup(785335159);
                                    ComposerKt.sourceInformation($composer3, "600@23864L148");
                                    ProgressIndicatorKt.m2246LinearProgressIndicator_5eSRE(invoke$lambda$3$lambda$2(stateAnimateFloatAsState) / 100.0f, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, $composer3, 48, 28);
                                    $composer3.endReplaceGroup();
                                }
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
                            propagateMinConstraints$iv = false;
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash2);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i18 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            int i19 = ((6 >> 6) & 112) | 6;
                            BoxScope $this$invoke_u24lambda_u243_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1214035694, "C547@21745L6,542@21487L475,558@22223L6,559@22259L452,553@21979L732:DownloadPageV2.kt#k6dflz");
                            AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(obj2, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z2, $composer3, 1572920, 0, 952);
                            Modifier modifierAlign2 = $this$invoke_u24lambda_u243_u24lambda_u241.align(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                            long jM4069getBlack0d7_KjU2 = Color.INSTANCE.m4069getBlack0d7_KjU();
                            SurfaceKt.m2418SurfaceT9BRK9s(modifierAlign2, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraSmall(), Color.m4041copywmQWz5c(jM4069getBlack0d7_KjU2, (14 & 1) != 0 ? Color.m4045getAlphaimpl(jM4069getBlack0d7_KjU2) : 0.68f, (14 & 2) != 0 ? Color.m4049getRedimpl(jM4069getBlack0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(jM4069getBlack0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(jM4069getBlack0d7_KjU2) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1051198766, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$VideoCardV2$3$1$1$1
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
                                    ComposerKt.sourceInformation($composer4, "C560@22315L16,565@22605L10,562@22417L276:DownloadPageV2.kt#k6dflz");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1051198766, $changed3, -1, "com.videshkarmakar.loop.ui.page.downloadv2.VideoCardV2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:560)");
                                        }
                                        String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d2), $composer4, 0);
                                        String durationText = TextUtilKt.toDurationText(i11);
                                        TextKt.m2569Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4080getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 432, 0, 65528);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }, $composer3, 54), $composer3, 12583296, 120);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifier$iv4 = PaddingKt.m620padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12));
                            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                            int $changed$iv$iv4 = (390 << 3) & 112;
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
                                function4 = constructor;
                                $composer3.createNode(function4);
                            } else {
                                function4 = constructor;
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                            int i110 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                            int i111 = ((390 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1214034238, "C580@23025L10,578@22943L210,587@23314L10,588@23379L11,584@23170L343:DownloadPageV2.kt#k6dflz");
                            TextKt.m2569Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 3120, 55294);
                            TextKt.m2569Text4IGK_g(str4, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 48, 3120, 55288);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                            if (f3 < 0.0f) {
                                $composer3.startReplaceGroup(785334990);
                                ComposerKt.sourceInformation($composer3, "597@23756L90");
                                ProgressIndicatorKt.m2249LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer3, 6, 30);
                                $composer3.endReplaceGroup();
                            } else {
                                $composer3.startReplaceGroup(785335159);
                                ComposerKt.sourceInformation($composer3, "600@23864L148");
                                ProgressIndicatorKt.m2246LinearProgressIndicator_5eSRE(invoke$lambda$3$lambda$2(stateAnimateFloatAsState) / 100.0f, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, $composer3, 48, 28);
                                $composer3.endReplaceGroup();
                            }
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

                    private static final float invoke$lambda$3$lambda$2(State<Float> state) {
                        Object thisObj$iv = state.getValue();
                        return ((Number) thisObj$iv).floatValue();
                    }
                }, $composer2, 54), $composer2, 100663296, 228);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                duration2 = duration4;
                modifier3 = modifier5;
                author3 = author2;
                isPreview3 = isPreview2;
                title3 = title2;
                thumbnailUrl3 = thumbnailUrl2;
                function2 = c09621;
                fileSizeApprox3 = fileSizeApprox2;
                progress3 = progress2;
            }
            value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$VideoCardV2$2$1
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
                    c09621.invoke();
                }
            };
            $composer2.updateRememberedValue(value$iv);
            $composer2.endReplaceGroup();
            final float f3 = progress2;
            final Object obj2 = thumbnailUrl2;
            final boolean z2 = isPreview2;
            final double d2 = fileSizeApprox2;
            final int i11 = $dirty2;
            final String str3 = title2;
            final String str4 = author2;
            int duration5 = $dirty2;
            CardKt.Card((Function0) value$iv, modifierFillMaxWidth$default, false, small, cardColorsM1731cardColorsro_MJ88, null, null, null, ComposableLambdaKt.rememberComposableLambda(-289785911, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.VideoCardV2.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:42:0x03ef  */
                /* JADX WARN: Code duplicated, block: B:45:0x03fb  */
                /* JADX WARN: Code duplicated, block: B:46:0x0401  */
                /* JADX WARN: Code duplicated, block: B:57:0x056f  */
                /* JADX WARN: Code duplicated, block: B:58:0x0599  */
                /* JADX WARN: Code duplicated, block: B:61:0x05e7  */
                /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
                public final void invoke(ColumnScope Card, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function3;
                    boolean propagateMinConstraints$iv;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function4;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    State<Float> stateAnimateFloatAsState;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer3, "C540@21419L2603:DownloadPageV2.kt#k6dflz");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-289785911, $changed2, -1, "com.videshkarmakar.loop.ui.page.downloadv2.VideoCardV2.<anonymous> (DownloadPageV2.kt:540)");
                        }
                        float f4 = f3;
                        Object obj3 = obj2;
                        boolean z3 = z2;
                        final double d3 = d2;
                        final int i12 = i11;
                        String str5 = str3;
                        String str6 = str4;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i13 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i14 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 785332674, "C541@21440L1286,572@22740L787,593@23570L154:DownloadPageV2.kt#k6dflz");
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (6 << 3) & 112;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                            propagateMinConstraints$iv = false;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i18 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            int i19 = ((6 >> 6) & 112) | 6;
                            BoxScope $this$invoke_u24lambda_u243_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1214035694, "C547@21745L6,542@21487L475,558@22223L6,559@22259L452,553@21979L732:DownloadPageV2.kt#k6dflz");
                            AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(obj3, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z3, $composer3, 1572920, 0, 952);
                            Modifier modifierAlign2 = $this$invoke_u24lambda_u243_u24lambda_u241.align(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                            long jM4069getBlack0d7_KjU2 = Color.INSTANCE.m4069getBlack0d7_KjU();
                            SurfaceKt.m2418SurfaceT9BRK9s(modifierAlign2, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraSmall(), Color.m4041copywmQWz5c(jM4069getBlack0d7_KjU2, (14 & 1) != 0 ? Color.m4045getAlphaimpl(jM4069getBlack0d7_KjU2) : 0.68f, (14 & 2) != 0 ? Color.m4049getRedimpl(jM4069getBlack0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(jM4069getBlack0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(jM4069getBlack0d7_KjU2) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1051198766, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$VideoCardV2$3$1$1$1
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
                                    ComposerKt.sourceInformation($composer4, "C560@22315L16,565@22605L10,562@22417L276:DownloadPageV2.kt#k6dflz");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1051198766, $changed3, -1, "com.videshkarmakar.loop.ui.page.downloadv2.VideoCardV2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:560)");
                                        }
                                        String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d3), $composer4, 0);
                                        String durationText = TextUtilKt.toDurationText(i12);
                                        TextKt.m2569Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4080getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 432, 0, 65528);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }, $composer3, 54), $composer3, 12583296, 120);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifier$iv4 = PaddingKt.m620padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12));
                            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                            int $changed$iv$iv4 = (390 << 3) & 112;
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
                                function4 = constructor;
                                $composer3.createNode(function4);
                            } else {
                                function4 = constructor;
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                            int i110 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                            int i111 = ((390 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1214034238, "C580@23025L10,578@22943L210,587@23314L10,588@23379L11,584@23170L343:DownloadPageV2.kt#k6dflz");
                            TextKt.m2569Text4IGK_g(str5, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 3120, 55294);
                            TextKt.m2569Text4IGK_g(str6, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 48, 3120, 55288);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f4, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                            if (f4 < 0.0f) {
                                $composer3.startReplaceGroup(785334990);
                                ComposerKt.sourceInformation($composer3, "597@23756L90");
                                ProgressIndicatorKt.m2249LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer3, 6, 30);
                                $composer3.endReplaceGroup();
                            } else {
                                $composer3.startReplaceGroup(785335159);
                                ComposerKt.sourceInformation($composer3, "600@23864L148");
                                ProgressIndicatorKt.m2246LinearProgressIndicator_5eSRE(invoke$lambda$3$lambda$2(stateAnimateFloatAsState) / 100.0f, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, $composer3, 48, 28);
                                $composer3.endReplaceGroup();
                            }
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
                        propagateMinConstraints$iv = false;
                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash2);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i112 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        int i113 = ((6 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u243_u24lambda_u242 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1214035694, "C547@21745L6,542@21487L475,558@22223L6,559@22259L452,553@21979L732:DownloadPageV2.kt#k6dflz");
                        AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(obj3, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z3, $composer3, 1572920, 0, 952);
                        Modifier modifierAlign3 = $this$invoke_u24lambda_u243_u24lambda_u242.align(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                        long jM4069getBlack0d7_KjU3 = Color.INSTANCE.m4069getBlack0d7_KjU();
                        SurfaceKt.m2418SurfaceT9BRK9s(modifierAlign3, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraSmall(), Color.m4041copywmQWz5c(jM4069getBlack0d7_KjU3, (14 & 1) != 0 ? Color.m4045getAlphaimpl(jM4069getBlack0d7_KjU3) : 0.68f, (14 & 2) != 0 ? Color.m4049getRedimpl(jM4069getBlack0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(jM4069getBlack0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(jM4069getBlack0d7_KjU3) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1051198766, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt$VideoCardV2$3$1$1$1
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
                                ComposerKt.sourceInformation($composer4, "C560@22315L16,565@22605L10,562@22417L276:DownloadPageV2.kt#k6dflz");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1051198766, $changed3, -1, "com.videshkarmakar.loop.ui.page.downloadv2.VideoCardV2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadPageV2.kt:560)");
                                    }
                                    String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d3), $composer4, 0);
                                    String durationText = TextUtilKt.toDurationText(i12);
                                    TextKt.m2569Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4080getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 432, 0, 65528);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 12583296, 120);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv5 = PaddingKt.m620padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12));
                        Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv5 = (390 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function4 = constructor;
                            $composer3.createNode(function4);
                        } else {
                            function4 = constructor;
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash5);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                        int i114 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                        int i115 = ((390 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1214034238, "C580@23025L10,578@22943L210,587@23314L10,588@23379L11,584@23170L343:DownloadPageV2.kt#k6dflz");
                        TextKt.m2569Text4IGK_g(str5, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 3120, 55294);
                        TextKt.m2569Text4IGK_g(str6, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 48, 3120, 55288);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f4, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                        if (f4 < 0.0f) {
                            $composer3.startReplaceGroup(785334990);
                            ComposerKt.sourceInformation($composer3, "597@23756L90");
                            ProgressIndicatorKt.m2249LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer3, 6, 30);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(785335159);
                            ComposerKt.sourceInformation($composer3, "600@23864L148");
                            ProgressIndicatorKt.m2246LinearProgressIndicator_5eSRE(invoke$lambda$3$lambda$2(stateAnimateFloatAsState) / 100.0f, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, $composer3, 48, 28);
                            $composer3.endReplaceGroup();
                        }
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

                private static final float invoke$lambda$3$lambda$2(State<Float> state) {
                    Object thisObj$iv = state.getValue();
                    return ((Number) thisObj$iv).floatValue();
                }
            }, $composer2, 54), $composer2, 100663296, 228);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            duration2 = duration5;
            modifier3 = modifier5;
            author3 = author2;
            isPreview3 = isPreview2;
            title3 = title2;
            thumbnailUrl3 = thumbnailUrl2;
            function2 = c09621;
            fileSizeApprox3 = fileSizeApprox2;
            progress3 = progress2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final String str5 = title3;
            final String str6 = author3;
            final Object obj3 = thumbnailUrl3;
            final Function0<Unit> function3 = function2;
            final float f4 = progress3;
            final double d3 = fileSizeApprox3;
            final int i12 = duration2;
            final boolean z3 = isPreview3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.downloadv2.DownloadPageV2Kt.VideoCardV2.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i13) {
                    DownloadPageV2Kt.VideoCardV2(modifier6, str5, str6, obj3, function3, f4, d3, i12, z3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
