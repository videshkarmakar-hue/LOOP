package com.videshkarmakar.loop.ui.page.videolist;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material.icons.outlined.FileDownloadKt;
import androidx.compose.material.icons.outlined.LinkKt;
import androidx.compose.material.icons.outlined.ShareKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.ModalBottomSheetM2Kt;
import com.videshkarmakar.loop.ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.FileUtil;
import com.videshkarmakar.loop.util.ToastUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: VideoDetailDrawer.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001aG\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r\u001a\u008f\u0001\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"DrawerPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "VideoDetailDrawer", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "info", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "isFileAvailable", "", "onDismissRequest", "Lkotlin/Function0;", "onDelete", "(Landroidx/compose/material/ModalBottomSheetState;Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VideoDetailDrawerImpl", "title", "", "author", "url", "onReDownload", "onOpenLink", "onShareFile", "(Landroidx/compose/material/ModalBottomSheetState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoDetailDrawerKt {
    public static final void VideoDetailDrawer(final ModalBottomSheetState sheetState, final DownloadedVideoInfo info, boolean isFileAvailable, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0<Unit> function2;
        final Function0<Unit> function3;
        boolean isFileAvailable2;
        Object value$iv;
        Object value$iv2;
        Function0<Unit> function4;
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Intrinsics.checkNotNullParameter(info, "info");
        Composer $composer2 = $composer.startRestartGroup(-752688204);
        ComposerKt.sourceInformation($composer2, "C(VideoDetailDrawer)P(4!2,3)63@2928L7,64@2961L7,65@3000L7,66@3053L7,67@3135L34,67@3065L104,72@3195L332,84@3550L35,*86@3611L928:VideoDetailDrawer.kt#861hqi");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(sheetState) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(info) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            z = isFileAvailable;
        } else if (($changed & 896) == 0) {
            z = isFileAvailable;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = isFileAvailable;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function2 = function0;
        } else if (($changed & 7168) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function0;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function3 = function1;
        } else if (($changed & 57344) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        } else {
            function3 = function1;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            isFileAvailable2 = z;
            function4 = function2;
        } else {
            isFileAvailable2 = i2 != 0 ? true : z;
            final Function0<Unit> function5 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawer.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            if (i4 != 0) {
                function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawer.2
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-752688204, $dirty2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawer (VideoDetailDrawer.kt:62)");
            }
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final UriHandler uriHandler = (UriHandler) objConsume;
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view = (View) objConsume2;
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) objConsume3;
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final HapticFeedback hapticFeedback = (HapticFeedback) objConsume4;
            boolean z2 = sheetState.getTargetValue() == ModalBottomSheetValue.Expanded;
            $composer2.startReplaceGroup(807862842);
            ComposerKt.sourceInformation($composer2, "CC(remember):VideoDetailDrawer.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawer$3$1
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
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            BackHandlerKt.BackHandler(z2, (Function0) value$iv, $composer2, 0, 0);
            $composer2.startReplaceGroup(807862902);
            ComposerKt.sourceInformation($composer2, "CC(remember):VideoDetailDrawer.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 112) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawer$onReDownload$1$1
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
                        Context context2 = context;
                        Intent $this$invoke_u24lambda_u240 = new Intent();
                        Context context3 = context;
                        DownloadedVideoInfo downloadedVideoInfo = info;
                        $this$invoke_u24lambda_u240.setAction("android.intent.action.SEND");
                        $this$invoke_u24lambda_u240.setPackage(context3.getPackageName());
                        $this$invoke_u24lambda_u240.setType("text/plain");
                        $this$invoke_u24lambda_u240.putExtra("android.intent.extra.TEXT", downloadedVideoInfo.getVideoUrl());
                        context2.startActivity($this$invoke_u24lambda_u240);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            Function0 onReDownload = (Function0) value$iv2;
            $composer2.endReplaceGroup();
            final String shareTitle = StringResources_androidKt.stringResource(R.string.share, $composer2, 0);
            function4 = function5;
            Function0<Unit> function6 = function3;
            VideoDetailDrawerImpl(sheetState, info.getVideoTitle(), info.getVideoAuthor(), info.getVideoUrl(), function5, isFileAvailable2, onReDownload, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawer$4$1
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
                    com.videshkarmakar.loop.ui.common.HapticFeedback.INSTANCE.slightHapticFeedback(view);
                    function5.invoke();
                    function3.invoke();
                }
            }, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawer$4$2
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
                    hapticFeedback.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
                    function5.invoke();
                    uriHandler.openUri(info.getVideoUrl());
                }
            }, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawer$4$3
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
                    Object objM7557constructorimpl;
                    com.videshkarmakar.loop.ui.common.HapticFeedback.INSTANCE.slightHapticFeedback(view);
                    Intent $this$invoke_u24lambda_u240 = FileUtil.INSTANCE.createIntentForSharingFile(info.getVideoPath());
                    if ($this$invoke_u24lambda_u240 != null) {
                        Context context2 = context;
                        String str = shareTitle;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            context2.startActivity(Intent.createChooser($this$invoke_u24lambda_u240, str));
                            objM7557constructorimpl = Result.m7557constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM7557constructorimpl = Result.m7557constructorimpl(ResultKt.createFailure(th));
                        }
                        Result.m7556boximpl(objM7557constructorimpl);
                    }
                }
            }, $composer2, ModalBottomSheetState.$stable | ($dirty2 & 14) | (($dirty2 << 3) & 57344) | (($dirty2 << 9) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = isFileAvailable2;
            final Function0<Unit> function7 = function4;
            final Function0<Unit> function8 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawer.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    VideoDetailDrawerKt.VideoDetailDrawer(sheetState, info, z3, function7, function8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DrawerPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1774920272);
        ComposerKt.sourceInformation($composer2, "C(DrawerPreview)117@4647L200:VideoDetailDrawer.kt#861hqi");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1774920272, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.DrawerPreview (VideoDetailDrawer.kt:116)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$VideoDetailDrawerKt.INSTANCE.m7495getLambda1$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.DrawerPreview.1
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
                    VideoDetailDrawerKt.DrawerPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void VideoDetailDrawerImpl(ModalBottomSheetState sheetState, String title, String author, String url, Function0<Unit> function0, boolean isFileAvailable, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        boolean z;
        Function0<Unit> function5;
        ModalBottomSheetState sheetState2;
        String title2;
        String author2;
        String url2;
        C10941 c10941;
        boolean isFileAvailable2;
        C10952 c10952;
        AnonymousClass3 anonymousClass3;
        C10965 c10965;
        int $dirty;
        Function0<Unit> function6;
        ModalBottomSheetState sheetState3;
        Function0<Unit> function7;
        ModalBottomSheetState sheetState4;
        Function0<Unit> function8;
        Function0<Unit> function9;
        String author3;
        String title3;
        String url3;
        boolean isFileAvailable3;
        Function0<Unit> function10;
        Function0<Unit> function11;
        Composer $composer2 = $composer.startRestartGroup(1325085835);
        ComposerKt.sourceInformation($composer2, "C(VideoDetailDrawerImpl)P(7,8!1,9,3!1,5)129@5046L7,130@5076L53,131@5152L55,140@5517L7,141@5556L7,144@5702L3466,142@5568L3601:VideoDetailDrawer.kt#861hqi");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            $dirty2 |= ((i & 1) == 0 && $composer2.changed(sheetState)) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= ((i & 2) == 0 && $composer2.changed(title)) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                str = author;
                int i2 = $composer2.changed(str) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                str = author;
            }
            $dirty2 |= i2;
        } else {
            str = author;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            str2 = url;
        } else if (($changed & 7168) == 0) {
            str2 = url;
            $dirty2 |= $composer2.changed(str2) ? 2048 : 1024;
        } else {
            str2 = url;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = isFileAvailable;
        } else if ((458752 & $changed) == 0) {
            z = isFileAvailable;
            $dirty2 |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = isFileAvailable;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 1572864;
            function5 = function1;
        } else if ((3670016 & $changed) == 0) {
            function5 = function1;
            $dirty2 |= $composer2.changedInstance(function5) ? 1048576 : 524288;
        } else {
            function5 = function1;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 536870912 : 268435456;
        }
        if (($dirty2 & 1533875931) == 306775186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            sheetState4 = sheetState;
            title3 = title;
            function7 = function0;
            function11 = function2;
            function8 = function3;
            function9 = function4;
            author3 = str;
            url3 = str2;
            isFileAvailable3 = z;
            function10 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    sheetState2 = new ModalBottomSheetState(modalBottomSheetValue, (Density) objConsume, null, null, false, 28, null);
                    $dirty2 &= -15;
                } else {
                    sheetState2 = sheetState;
                }
                if ((i & 2) != 0) {
                    title2 = StringResources_androidKt.stringResource(R.string.video_title_sample_text, $composer2, 0);
                    $dirty2 &= -113;
                } else {
                    title2 = title;
                }
                if ((i & 4) != 0) {
                    author2 = StringResources_androidKt.stringResource(R.string.video_creator_sample_text, $composer2, 0);
                    $dirty2 &= -897;
                } else {
                    author2 = author;
                }
                url2 = i3 != 0 ? "https://www.example.com" : url;
                c10941 = (i & 16) != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawerImpl.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function0;
                isFileAvailable2 = i4 != 0 ? true : z;
                c10952 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawerImpl.2
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function5;
                anonymousClass3 = i6 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawerImpl.3
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function2;
                AnonymousClass4 anonymousClass4 = i7 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawerImpl.4
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function3;
                if (i8 != 0) {
                    c10965 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawerImpl.5
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                    $dirty = $dirty2;
                    function6 = anonymousClass4;
                    sheetState3 = sheetState2;
                } else {
                    c10965 = function4;
                    $dirty = $dirty2;
                    function6 = anonymousClass4;
                    sheetState3 = sheetState2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    int i9 = $dirty2 & (-897);
                    title2 = title;
                    author2 = author;
                    anonymousClass3 = function2;
                    function6 = function3;
                    c10965 = function4;
                    url2 = str2;
                    isFileAvailable2 = z;
                    c10952 = function5;
                    c10941 = function0;
                    $dirty = i9;
                    sheetState3 = sheetState;
                } else {
                    sheetState3 = sheetState;
                    title2 = title;
                    author2 = author;
                    anonymousClass3 = function2;
                    c10965 = function4;
                    url2 = str2;
                    isFileAvailable2 = z;
                    c10952 = function5;
                    c10941 = function0;
                    $dirty = $dirty2;
                    function6 = function3;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1325085835, $dirty, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerImpl (VideoDetailDrawer.kt:139)");
            }
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ClipboardManager clipboardManager = (ClipboardManager) objConsume2;
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) objConsume3;
            ModalBottomSheetState sheetState5 = sheetState3;
            final String str3 = author2;
            final String str4 = title2;
            final Function0<Unit> function12 = function6;
            final String str5 = url2;
            final Function0<Unit> function13 = anonymousClass3;
            final boolean z2 = isFileAvailable2;
            final Function0<Unit> function14 = c10965;
            final Function0<Unit> function15 = c10952;
            Function0<Unit> function16 = function6;
            ModalBottomSheetM2Kt.LoopModalBottomSheetM2(null, sheetState5, ComposableLambdaKt.rememberComposableLambda(437556154, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawerImpl.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope LoopModalBottomSheetM2, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function17;
                    Function0<ComposeUiNode> function18;
                    Function0<ComposeUiNode> function19;
                    Intrinsics.checkNotNullParameter(LoopModalBottomSheetM2, "$this$LoopModalBottomSheetM2");
                    ComposerKt.sourceInformation($composer3, "C145@5716L1041,171@6770L962,198@7862L21,195@7747L1411:VideoDetailDrawer.kt#861hqi");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(437556154, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerImpl.<anonymous> (VideoDetailDrawer.kt:145)");
                        }
                        Modifier modifier$iv = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(8), 0.0f, 2, null);
                        final String str6 = str3;
                        final String str7 = str4;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv = (6 << 3) & 112;
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
                            function17 = constructor;
                            $composer3.createNode(function17);
                        } else {
                            function17 = constructor;
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
                        int i10 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i11 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1166531855, "C150@5895L317,150@5876L336:VideoDetailDrawer.kt#861hqi");
                        SelectionContainerKt.SelectionContainer(null, ComposableLambdaKt.rememberComposableLambda(-91253485, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawerImpl$6$1$1
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
                                ComposerKt.sourceInformation($composer4, "C156@6150L10,151@5917L277:VideoDetailDrawer.kt#861hqi");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-91253485, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerImpl.<anonymous>.<anonymous>.<anonymous> (VideoDetailDrawer.kt:151)");
                                    }
                                    TextKt.m2569Text4IGK_g(str7, PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6553constructorimpl(6), 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleLarge(), $composer4, 48, 0, 65532);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 48, 1);
                        $composer3.startReplaceGroup(708578353);
                        ComposerKt.sourceInformation($composer3, "160@6314L429,160@6295L448");
                        if (!Intrinsics.areEqual(str6, "playlist") && !Intrinsics.areEqual(str6, AbstractJsonLexerKt.NULL)) {
                            SelectionContainerKt.SelectionContainer(null, ComposableLambdaKt.rememberComposableLambda(491917934, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawerImpl$6$1$2
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
                                    ComposerKt.sourceInformation($composer4, "C166@6594L10,167@6666L11,161@6340L381:VideoDetailDrawer.kt#861hqi");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(491917934, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerImpl.<anonymous>.<anonymous>.<anonymous> (VideoDetailDrawer.kt:161)");
                                        }
                                        TextKt.m2569Text4IGK_g(str6, PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6553constructorimpl(6), 1, null), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 48, 0, 65528);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }, $composer3, 54), $composer3, 48, 1);
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 1, null), 0.0f, 1, null);
                        Function0<Unit> function20 = function12;
                        final ClipboardManager clipboardManager2 = clipboardManager;
                        final String str8 = str5;
                        final Context context2 = context;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
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
                            function18 = constructor2;
                            $composer3.createNode(function18);
                        } else {
                            function18 = constructor2;
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
                        int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i13 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1166530806, "C181@7190L39,183@7316L33,184@7368L350,176@6925L793:VideoDetailDrawer.kt#861hqi");
                        ButtonsKt.LongTapTextButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawerImpl$6$2$1
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
                                clipboardManager2.setText(new AnnotatedString(str8, null, null, 6, null));
                                ToastUtil toastUtil = ToastUtil.INSTANCE;
                                String string = context2.getString(R.string.link_copied);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                toastUtil.makeToast(string);
                            }
                        }, StringResources_androidKt.stringResource(R.string.copy_link, $composer3, 0), function20, StringResources_androidKt.stringResource(R.string.open_url, $composer3, 0), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1614211159, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt$VideoDetailDrawerImpl$6$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope LongTapTextButton, Composer $composer4, int $changed3) {
                                Intrinsics.checkNotNullParameter(LongTapTextButton, "$this$LongTapTextButton");
                                ComposerKt.sourceInformation($composer4, "C185@7416L34,185@7390L61,186@7472L228:VideoDetailDrawer.kt#861hqi");
                                if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1614211159, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerImpl.<anonymous>.<anonymous>.<anonymous> (VideoDetailDrawer.kt:185)");
                                }
                                IconKt.m2044Iconww6aTOc(LinkKt.getLink(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.video_url, $composer4, 0), (Modifier) null, 0L, $composer4, 0, 12);
                                TextKt.m2569Text4IGK_g(str8, PaddingKt.m621paddingVpY3zN4(Modifier.INSTANCE, Dp.m6553constructorimpl(8), Dp.m6553constructorimpl(6)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 48, 3120, 120828);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, 100663296, 240);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv3 = PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null), 0.0f, Dp.m6553constructorimpl(24), 0.0f, 0.0f, 13, null), Dp.m6553constructorimpl(8), 0.0f, 2, null);
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getEnd();
                        Function0<Unit> function21 = function13;
                        boolean z3 = z2;
                        Function0<Unit> function22 = function14;
                        Function0<Unit> function23 = function15;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function19 = constructor3;
                            $composer3.createNode(function19);
                        } else {
                            function19 = constructor3;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i14 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        int i15 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1166529682, "C207@8259L31,203@8049L259:VideoDetailDrawer.kt#861hqi");
                        ButtonsKt.m7103OutlinedButtonWithIconyrwZFoE(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null), function21, DeleteKt.getDelete(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.remove, $composer3, 0), 0L, $composer3, 6, 16);
                        if (z3) {
                            $composer3.startReplaceGroup(-1166529363);
                            ComposerKt.sourceInformation($composer3, "213@8526L30,210@8368L210");
                            ButtonsKt.FilledTonalButtonWithIcon(null, function22, ShareKt.getShare(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.share, $composer3, 0), null, $composer3, 0, 17);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(-1166529107);
                            ComposerKt.sourceInformation($composer3, "219@8790L35,221@8959L11,222@9047L11,220@8875L229,216@8624L502");
                            ButtonsKt.FilledTonalButtonWithIcon(null, function23, FileDownloadKt.getFileDownload(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.redownload, $composer3, 0), ButtonDefaults.INSTANCE.m1715filledTonalButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getTertiaryContainer(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnTertiaryContainer(), 0L, 0L, $composer3, ButtonDefaults.$stable << 12, 12), $composer3, 0, 1);
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
            }, $composer2, 54), PaddingKt.m615PaddingValuesYgX7TsA$default(Dp.m6553constructorimpl(20), 0.0f, 2, null), $composer2, (ModalBottomSheetState.$stable << 3) | 3456 | (($dirty << 3) & 112), 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = c10941;
            sheetState4 = sheetState5;
            function8 = function16;
            function9 = c10965;
            author3 = author2;
            title3 = title2;
            url3 = url2;
            isFileAvailable3 = isFileAvailable2;
            function10 = c10952;
            function11 = anonymousClass3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ModalBottomSheetState modalBottomSheetState = sheetState4;
            final String str6 = title3;
            final String str7 = author3;
            final String str8 = url3;
            final Function0<Unit> function17 = function7;
            final boolean z3 = isFileAvailable3;
            final Function0<Unit> function18 = function10;
            final Function0<Unit> function19 = function11;
            final Function0<Unit> function20 = function8;
            final Function0<Unit> function21 = function9;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoDetailDrawerKt.VideoDetailDrawerImpl.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    VideoDetailDrawerKt.VideoDetailDrawerImpl(modalBottomSheetState, str6, str7, str8, function17, z3, function18, function19, function20, function21, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
