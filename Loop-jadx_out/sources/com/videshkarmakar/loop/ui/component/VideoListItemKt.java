package com.videshkarmakar.loop.ui.component;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.AsyncImageImplKt;
import com.videshkarmakar.loop.ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: VideoListItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a5\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\n\u001a³\u0001\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0007¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"AUDIO_REGEX", "", "MediaImage", "", "modifier", "Landroidx/compose/ui/Modifier;", "imageModel", "isAudio", "", "contentDescription", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "MediaListItem", "title", "author", "thumbnailUrl", "videoPath", "videoUrl", "videoFileSize", "", "isSelectEnabled", "Lkotlin/Function0;", "isSelected", "onSelect", "onClick", "onLongClick", "onShowContextMenu", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "MediaListItemPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoListItemKt {
    private static final String AUDIO_REGEX = "\\.(mp3|aac|opus|m4a|flac|wav)";

    public static final void MediaListItemPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-2130791688);
        ComposerKt.sourceInformation($composer2, "C(MediaListItemPreview)49@2158L331:VideoListItem.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2130791688, $changed, -1, "com.videshkarmakar.loop.ui.component.MediaListItemPreview (VideoListItem.kt:48)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$VideoListItemKt.INSTANCE.m7159getLambda2$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItemPreview.1
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
                    VideoListItemKt.MediaListItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void MediaListItem(Modifier modifier, String title, String author, String thumbnailUrl, String videoPath, String videoUrl, long videoFileSize, Function0<Boolean> function0, Function0<Boolean> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4, Function0<Unit> function5, Composer $composer, final int $changed, final int $changed1, final int i) {
        final AnonymousClass5 anonymousClass5;
        float imageWeight;
        String title2;
        Modifier modifier2;
        Modifier modifierM869selectableXHw0xAI$default;
        Function0<Unit> function6;
        Function0<ComposeUiNode> function7;
        Composer $composer2;
        Function0<ComposeUiNode> function8;
        Function0<Boolean> function9;
        Function0<ComposeUiNode> function10;
        String thumbnailUrl2;
        Function0<Unit> function11;
        String videoPath2;
        Function0<Boolean> function12;
        Function0<Unit> function13;
        String videoUrl2;
        long videoFileSize2;
        String author2;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(-763756100);
        ComposerKt.sourceInformation($composer3, "C(MediaListItem)P(3,9!1,8,11,12,10!2,6)79@3102L7,92@3416L7,93@3455L7,95@3546L16,97@3568L3301:VideoListItem.kt#g7nzpb");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(title) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(author) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(thumbnailUrl) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(videoPath) ? 16384 : 8192;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(videoFileSize) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(function3) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(function4) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changedInstance(function5) ? 256 : 128;
        }
        if (($dirty & 1533589211) == 306717842 && ($dirty1 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            title2 = title;
            author2 = author;
            thumbnailUrl2 = thumbnailUrl;
            videoPath2 = videoPath;
            videoUrl2 = videoUrl;
            videoFileSize2 = videoFileSize;
            function12 = function0;
            function9 = function1;
            function11 = function2;
            function6 = function3;
            anonymousClass5 = function4;
            function13 = function5;
            $dirty1 = $dirty1;
            $composer2 = $composer3;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            String title3 = i3 != 0 ? "" : title;
            String author3 = i4 != 0 ? "" : author;
            String thumbnailUrl3 = i5 != 0 ? "" : thumbnailUrl;
            String videoPath3 = i6 != 0 ? "" : videoPath;
            String videoUrl3 = (i & 32) != 0 ? "" : videoUrl;
            long videoFileSize3 = i7 != 0 ? 0L : videoFileSize;
            C08801 c08801 = i8 != 0 ? new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItem.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return false;
                }
            } : function0;
            final AnonymousClass2 anonymousClass2 = i9 != 0 ? new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItem.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return false;
                }
            } : function1;
            AnonymousClass3 anonymousClass3 = i10 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItem.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            final AnonymousClass4 anonymousClass4 = i11 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItem.4
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            anonymousClass5 = i12 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItem.5
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function4;
            AnonymousClass6 anonymousClass6 = i13 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItem.6
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-763756100, $dirty, $dirty1, "com.videshkarmakar.loop.ui.component.MediaListItem (VideoListItem.kt:77)");
            }
            String videoPath4 = videoPath3;
            boolean isAudio = new Regex(AUDIO_REGEX).containsMatchIn(videoPath3);
            ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = CompositionLocalsKt.getLocalWindowWidthState();
            final Function0<Unit> function14 = anonymousClass6;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localWindowWidthState);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int value = ((WindowWidthSizeClass) objConsume).getValue();
            if (WindowWidthSizeClass.m3491equalsimpl0(value, WindowWidthSizeClass.INSTANCE.m3500getExpandedY0FxcvE())) {
                imageWeight = isAudio ? 0.3f : 0.4f;
            } else if (WindowWidthSizeClass.m3491equalsimpl0(value, WindowWidthSizeClass.INSTANCE.m3501getMediumY0FxcvE())) {
                imageWeight = isAudio ? 0.2f : 0.3f;
            } else {
                imageWeight = isAudio ? 0.25f : 0.45f;
            }
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback();
            String author4 = author3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final HapticFeedback haptic = (HapticFeedback) objConsume2;
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            title2 = title3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean isFileAvailable = videoFileSize3 != 0;
            String fileSizeText = TextUtilKt.toFileSizeText(Long.valueOf(videoFileSize3), $composer3, ($dirty >> 18) & 14);
            $composer3.startReplaceGroup(-1361099520);
            ComposerKt.sourceInformation($composer3, "");
            Modifier $this$MediaListItem_u24lambda_u241 = modifier3;
            modifier2 = modifier3;
            $composer3.startReplaceGroup(-1361099491);
            ComposerKt.sourceInformation($composer3, "102@3768L34,107@4003L41,101@3722L13");
            if (c08801.invoke().booleanValue()) {
                modifierM869selectableXHw0xAI$default = SelectableKt.m869selectableXHw0xAI$default($this$MediaListItem_u24lambda_u241, anonymousClass2.invoke().booleanValue(), false, null, anonymousClass3, 6, null);
            } else {
                String strStringResource = StringResources_androidKt.stringResource(R.string.open_file, $composer3, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.multiselect_mode, $composer3, 0);
                Function0<Unit> function15 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt$MediaListItem$7$1
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
                        anonymousClass5.invoke();
                        haptic.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
                    }
                };
                $composer3.startReplaceGroup(-1012690013);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListItem.kt#9igjgp");
                boolean invalid$iv = ($dirty1 & 14) == 4;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt$MediaListItem$7$2$1
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
                            anonymousClass4.invoke();
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer3.endReplaceGroup();
                modifierM869selectableXHw0xAI$default = ClickableKt.m242combinedClickablecJG_KMw($this$MediaListItem_u24lambda_u241, (36 & 1) != 0 ? true : true, (36 & 2) != 0 ? null : strStringResource, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : strStringResource2, (36 & 16) != 0 ? null : function15, (36 & 32) != 0 ? null : null, (Function0) value$iv);
            }
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifierM869selectableXHw0xAI$default, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            Function0<Unit> function16 = anonymousClass3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            function6 = anonymousClass4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i14 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i15 = ((0 >> 6) & 112) | 6;
            BoxScope $this$MediaListItem_u24lambda_u245 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1012689561, "C112@4174L2073,171@6467L396,166@6256L607:VideoListItem.kt#g7nzpb");
            Modifier modifier$iv2 = PaddingKt.m620padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            $composer2 = $composer3;
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
                function8 = constructor2;
                $composer3.createNode(function8);
            } else {
                function8 = constructor2;
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
            int i16 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScope $this$MediaListItem_u24lambda_u245_u24lambda_u244 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 2101787269, "C120@4449L222,117@4299L372,127@4684L159,132@4856L1381:VideoListItem.kt#g7nzpb");
            function9 = anonymousClass2;
            AnimatedVisibilityKt.AnimatedVisibility($this$MediaListItem_u24lambda_u245_u24lambda_u244, c08801.invoke().booleanValue(), $this$MediaListItem_u24lambda_u245_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1817658554, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt$MediaListItem$8$1$1
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
                    ComposerKt.sourceInformation($composer4, "C121@4467L190:VideoListItem.kt#g7nzpb");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1817658554, $changed2, -1, "com.videshkarmakar.loop.ui.component.MediaListItem.<anonymous>.<anonymous>.<anonymous> (VideoListItem.kt:121)");
                    }
                    CheckboxKt.Checkbox(anonymousClass2.invoke().booleanValue(), null, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, Dp.m6553constructorimpl(16), 0.0f, 10, null), false, null, null, $composer4, 432, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, ((((6 >> 6) & 112) | 6) & 14) | 1572864, 28);
            MediaImage(RowScope.CC.weight$default($this$MediaListItem_u24lambda_u245_u24lambda_u244, Modifier.INSTANCE, imageWeight, false, 2, null), thumbnailUrl3, isAudio, null, $composer3, ($dirty >> 6) & 112, 8);
            Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(PaddingKt.m622paddingVpY3zN4$default(RowScope.CC.weight$default($this$MediaListItem_u24lambda_u245_u24lambda_u244, Modifier.INSTANCE, 1.0f - imageWeight, false, 2, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), 0.0f, 1, null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            String thumbnailUrl4 = thumbnailUrl3;
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
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
                function10 = constructor3;
                $composer3.createNode(function10);
            } else {
                function10 = constructor3;
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
            int i17 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i18 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1203435721, "C140@5184L10,141@5249L11,138@5102L274,158@6033L10,*159@6103L11,153@5774L447:VideoListItem.kt#g7nzpb");
            TextKt.m2569Text4IGK_g(title2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 3120, 55290);
            $composer3.startReplaceGroup(1203436012);
            ComposerKt.sourceInformation($composer3, "148@5559L10,149@5623L11,145@5415L342");
            if (!Intrinsics.areEqual(author4, AbstractJsonLexerKt.NULL)) {
                TextKt.m2569Text4IGK_g(author4, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, (($dirty >> 6) & 14) | 48, 3120, 55288);
            }
            $composer3.endReplaceGroup();
            Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(3), 0.0f, 0.0f, 13, null);
            $composer3.startReplaceGroup(1203436487);
            ComposerKt.sourceInformation($composer3, "155@5907L82");
            String strStringResource3 = isFileAvailable ? fileSizeText : StringResources_androidKt.stringResource(R.string.unavailable, $composer3, 0);
            $composer3.endReplaceGroup();
            TextStyle labelSmall = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall();
            ColorScheme $this$MediaListItem_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable);
            TextKt.m2569Text4IGK_g(strStringResource3, modifierM624paddingqDBjuR0$default, isFileAvailable ? $this$MediaListItem_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242.getOnSurfaceVariant() : $this$MediaListItem_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242.getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, labelSmall, $composer3, 48, 3072, 57336);
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
            AnimatedVisibilityKt.AnimatedVisibility(!c08801.invoke().booleanValue(), $this$MediaListItem_u24lambda_u245.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(281691038, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt$MediaListItem$8$2
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
                    ComposerKt.sourceInformation($composer4, "C172@6481L372:VideoListItem.kt#g7nzpb");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(281691038, $changed2, -1, "com.videshkarmakar.loop.ui.component.MediaListItem.<anonymous>.<anonymous> (VideoListItem.kt:172)");
                    }
                    IconButtonKt.IconButton(function14, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt$MediaListItem$8$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }
                    }), false, null, null, ComposableSingletons$VideoListItemKt.INSTANCE.m7160getLambda3$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, 200064, 16);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            thumbnailUrl2 = thumbnailUrl4;
            function11 = function16;
            videoPath2 = videoPath4;
            function12 = c08801;
            function13 = function14;
            videoUrl2 = videoUrl3;
            videoFileSize2 = videoFileSize3;
            author2 = author4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final String str = title2;
            final String str2 = author2;
            final String str3 = thumbnailUrl2;
            final String str4 = videoPath2;
            final String str5 = videoUrl2;
            final long j = videoFileSize2;
            final Function0<Boolean> function17 = function12;
            final Function0<Boolean> function18 = function9;
            final Function0<Unit> function19 = function11;
            final Function0<Unit> function20 = function6;
            final Function0<Unit> function21 = anonymousClass5;
            final Function0<Unit> function22 = function13;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaListItem.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i19) {
                    VideoListItemKt.MediaListItem(modifier4, str, str2, str3, str4, str5, j, function17, function18, function19, function20, function21, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void MediaImage(Modifier modifier, final String imageModel, boolean isAudio, String contentDescription, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        String str;
        boolean isAudio2;
        String contentDescription2;
        Modifier modifier3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(imageModel, "imageModel");
        Composer $composer3 = $composer.startRestartGroup(-438718257);
        ComposerKt.sourceInformation($composer3, "C(MediaImage)P(3,1,2)197@7236L6,192@7037L343:VideoListItem.kt#g7nzpb");
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
            $dirty |= $composer3.changed(imageModel) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = isAudio;
        } else if (($changed & 896) == 0) {
            z = isAudio;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = isAudio;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            str = contentDescription;
        } else if (($changed & 7168) == 0) {
            str = contentDescription;
            $dirty |= $composer3.changed(str) ? 2048 : 1024;
        } else {
            str = contentDescription;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            isAudio2 = z;
            contentDescription2 = str;
            $composer2 = $composer3;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            isAudio2 = i3 != 0 ? false : z;
            contentDescription2 = i4 != 0 ? null : str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-438718257, $dirty2, -1, "com.videshkarmakar.loop.ui.component.MediaImage (VideoListItem.kt:191)");
            }
            modifier3 = modifier4;
            $composer2 = $composer3;
            AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(imageModel, contentDescription2, ClipKt.clip(AspectRatioKt.aspectRatio(modifier4, !isAudio2 ? 1.7777778f : 1.0f, true), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, $composer3, (($dirty2 >> 3) & 14) | 1572864 | (($dirty2 >> 6) & 112), 0, 1976);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = isAudio2;
            final String str2 = contentDescription2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoListItemKt.MediaImage.1
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
                    VideoListItemKt.MediaImage(modifier5, imageModel, z2, str2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
