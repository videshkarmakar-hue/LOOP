package com.videshkarmakar.loop.ui.page.download;

import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
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
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridSpanKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.RangeSliderState;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.Route;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.ChipsKt;
import com.videshkarmakar.loop.ui.component.DialogsKt;
import com.videshkarmakar.loop.ui.component.DividerKt;
import com.videshkarmakar.loop.ui.component.FormatItemKt;
import com.videshkarmakar.loop.ui.component.IconButtonsKt;
import com.videshkarmakar.loop.ui.component.SearchBarKt;
import com.videshkarmakar.loop.ui.page.settings.general.GeneralDownloadPreferencesKt;
import com.videshkarmakar.loop.ui.theme.ColorSchemeKt;
import com.videshkarmakar.loop.ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.Chapter;
import com.videshkarmakar.loop.util.Format;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.RequestedDownload;
import com.videshkarmakar.loop.util.SubtitleFormat;
import com.videshkarmakar.loop.util.TextUtilKt;
import com.videshkarmakar.loop.util.VideoClip;
import com.videshkarmakar.loop.util.VideoInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: FormatPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0003¢\u0006\u0002\u0010\r\u001a%\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0093\u0001\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\f2>\b\u0002\u0010\u001b\u001a8\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d\u0012\u0004\u0012\u00020\u00050\u001cH\u0007¢\u0006\u0002\u0010 \u001a\r\u0010!\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\"\u001a7\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050'H\u0003¢\u0006\u0002\u0010(\u001a{\u0010)\u001a\u00020\u00052\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d0+2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d0+2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u001a\b\u0002\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d\u0012\u0004\u0012\u00020\u00050'H\u0003¢\u0006\u0002\u0010.\u001a\r\u0010/\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\"\u001aG\u00100\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0007¢\u0006\u0002\u00102\u001a8\u00103\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d042\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d04H\u0002\u001a-\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\"\u000e\b\u0000\u00107*\b\u0012\u0004\u0012\u00020\u000308*\u0002H72\u0006\u00109\u001a\u00020\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d0+*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d0+2\u0006\u0010<\u001a\u00020\u0003H\u0002\u001a\u0014\u0010=\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020,0\u001dH\u0002\u001a>\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d0+*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001d0+2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006@²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010A\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\u0010\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aX\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010G\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\u0010\u0010N\u001a\b\u0012\u0004\u0012\u00020P0OX\u008a\u008e\u0002²\u0006\n\u0010Q\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\u0010\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u008a\u0084\u0002²\u0006\n\u0010S\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010T\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"NOT_SELECTED", "", "TAG", "", "ClickableTextAction", "", "visible", "", "text", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function0;", "(ZLjava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", FormatPageKt.TAG, "downloadViewModel", "Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;", "onNavigateBack", "(Lcom/videshkarmakar/loop/ui/page/download/DownloadViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FormatPageImpl", "videoInfo", "Lcom/videshkarmakar/loop/util/VideoInfo;", "audioOnly", "mergeAudioStream", "isClippingAvailable", "selectedSubtitleCodes", "", "onDownloadPressed", "Lkotlin/Function5;", "", "Lcom/videshkarmakar/loop/util/Format;", "Lcom/videshkarmakar/loop/util/VideoClip;", "(Lcom/videshkarmakar/loop/util/VideoInfo;ZZZLjava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "FormatPagePreview", "(Landroidx/compose/runtime/Composer;I)V", "RenameDialog", "initialValue", "onDismissRequest", "onConfirm", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SubtitleSelectionDialog", "suggestedSubtitles", "", "Lcom/videshkarmakar/loop/util/SubtitleFormat;", "autoCaptions", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SubtitleSelectionDialogPreview", "UpdateSubtitleLanguageDialog", Route.LANGUAGES, "(Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "compareTo", "Lkotlin/Pair;", "other", "filterWithRegex", ExifInterface.GPS_DIRECTION_TRUE, "", "subtitleLanguageRegex", "(Ljava/util/Collection;Ljava/lang/String;)Ljava/util/Set;", "filterWithSearchText", "searchText", "getSubtitleName", "sortedWithSelection", "selectedKeys", "app_debug", "showUpdateSubtitleDialog", "diffSubtitleLanguages", "videoOnlyItemLimit", "audioOnlyItemLimit", "videoAudioItemLimit", "isSuggestedFormatSelected", "selectedVideoAudioFormat", "selectedVideoOnlyFormat", "isClippingVideo", "isSplittingVideo", "showVideoClipDialog", "showRenameDialog", "showSubtitleSelectionDialog", "videoClipDuration", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "videoTitle", "formatList", "shouldUpdateClipDuration", "filename"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FormatPageKt {
    private static final int NOT_SELECTED = -1;
    private static final String TAG = "FormatPage";

    /* JADX WARN: Code duplicated, block: B:50:0x0178  */
    public static final void FormatPage(final DownloadViewModel downloadViewModel, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Set<String> setEmptySet;
        Object value$iv;
        Object value$iv2;
        boolean z;
        Object value$iv3;
        final MutableState showUpdateSubtitleDialog$delegate;
        Object value$iv4;
        Object value$iv5;
        Intrinsics.checkNotNullParameter(downloadViewModel, "downloadViewModel");
        Composer $composer2 = $composer.startRestartGroup(-67011251);
        ComposerKt.sourceInformation($composer2, "C(FormatPage)113@5563L29,126@6118L34,128@6187L47,137@6571L678,130@6240L1009,163@7436L97,167@7559L298,160@7295L572:FormatPage.kt#y3famj");
        final Function0<Unit> function1 = (i & 2) != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPage.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-67011251, $changed, -1, "com.videshkarmakar.loop.ui.page.download.FormatPage (FormatPage.kt:112)");
        }
        final State videoInfo$delegate = FlowExtKt.collectAsStateWithLifecycle(downloadViewModel.getVideoInfoFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
        List<Format> formats = FormatPage$lambda$0(videoInfo$delegate).getFormats();
        if (formats == null || formats.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPage.2
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
                        FormatPageKt.FormatPage(downloadViewModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
                return;
            }
            return;
        }
        boolean audioOnly = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EXTRACT_AUDIO, false, 1, null);
        boolean mergeAudioStream = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.MERGE_MULTI_AUDIO_STREAM, false, 1, null);
        final String subtitleLanguageRegex = PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE_LANGUAGE, null, 1, null);
        boolean downloadSubtitle = PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE, false, 1, null);
        if (downloadSubtitle) {
            VideoInfo $this$FormatPage_u24lambda_u241 = FormatPage$lambda$0(videoInfo$delegate);
            setEmptySet = filterWithRegex(SetsKt.plus((Set) $this$FormatPage_u24lambda_u241.getSubtitles().keySet(), (Iterable) $this$FormatPage_u24lambda_u241.getAutomaticCaptions().keySet()), subtitleLanguageRegex);
        } else {
            setEmptySet = SetsKt.emptySet();
        }
        $composer2.startReplaceGroup(2072704637);
        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv = $composer2.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState showUpdateSubtitleDialog$delegate2 = (MutableState) value$iv;
        $composer2.endReplaceGroup();
        $composer2.startReplaceGroup(2072704706);
        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv2 = $composer2.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SetsKt.emptySet(), null, 2, null);
            $composer2.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final MutableState diffSubtitleLanguages$delegate = (MutableState) value$iv2;
        $composer2.endReplaceGroup();
        VideoInfo videoInfoFormatPage$lambda$0 = FormatPage$lambda$0(videoInfo$delegate);
        boolean z2 = !audioOnly && mergeAudioStream;
        Set<String> set = setEmptySet;
        if (PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.VIDEO_CLIP, false, 1, null)) {
            Double duration = FormatPage$lambda$0(videoInfo$delegate).getDuration();
            if ((duration != null ? duration.doubleValue() : 0.0d) >= 0.0d) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        $composer2.startReplaceGroup(2072705090);
        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
        boolean invalid$iv = $composer2.changed(subtitleLanguageRegex) | $composer2.changed(videoInfo$delegate) | (((($changed & 112) ^ 48) > 32 && $composer2.changed(function1)) || ($changed & 48) == 32);
        Object it$iv3 = $composer2.rememberedValue();
        if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
            final Function0<Unit> function2 = function1;
            value$iv3 = new Function5<List<? extends Format>, List<? extends VideoClip>, Boolean, String, List<? extends String>, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPage$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(5);
                }

                @Override // kotlin.jvm.functions.Function5
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Format> list, List<? extends VideoClip> list2, Boolean bool, String str, List<? extends String> list3) {
                    invoke((List<Format>) list, (List<VideoClip>) list2, bool.booleanValue(), str, (List<String>) list3);
                    return Unit.INSTANCE;
                }

                public final void invoke(List<Format> formatList, List<VideoClip> videoClips, boolean splitByChapter, String title, List<String> selectedSubtitleCodes) {
                    Intrinsics.checkNotNullParameter(formatList, "formatList");
                    Intrinsics.checkNotNullParameter(videoClips, "videoClips");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(selectedSubtitleCodes, "selectedSubtitleCodes");
                    diffSubtitleLanguages$delegate.setValue(CollectionsKt.toSet(CollectionsKt.minus((Iterable) selectedSubtitleCodes, (Iterable) FormatPageKt.filterWithRegex(selectedSubtitleCodes, subtitleLanguageRegex))));
                    Downloader.INSTANCE.downloadVideoWithConfigurations(FormatPageKt.FormatPage$lambda$0(videoInfo$delegate), formatList, videoClips, splitByChapter, title, selectedSubtitleCodes);
                    if (!FormatPageKt.FormatPage$lambda$6(diffSubtitleLanguages$delegate).isEmpty()) {
                        FormatPageKt.FormatPage$lambda$4(showUpdateSubtitleDialog$delegate2, true);
                    } else {
                        function2.invoke();
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        $composer2.endReplaceGroup();
        final Function0<Unit> function3 = function1;
        FormatPageImpl(videoInfoFormatPage$lambda$0, audioOnly, z2, z, set, function1, (Function5) value$iv3, $composer2, (($changed << 12) & 458752) | 32776, 0);
        if (FormatPage$lambda$3(showUpdateSubtitleDialog$delegate2)) {
            Modifier.Companion companion = Modifier.INSTANCE;
            Set<String> setFormatPage$lambda$6 = FormatPage$lambda$6(diffSubtitleLanguages$delegate);
            $composer2.startReplaceGroup(2072705955);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
            boolean invalid$iv2 = ((($changed & 112) ^ 48) > 32 && $composer2.changed(function3)) || ($changed & 48) == 32;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                showUpdateSubtitleDialog$delegate = showUpdateSubtitleDialog$delegate2;
                value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPage$4$1
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
                        FormatPageKt.FormatPage$lambda$4(showUpdateSubtitleDialog$delegate, false);
                        function3.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
                showUpdateSubtitleDialog$delegate = showUpdateSubtitleDialog$delegate2;
            }
            Function0 function4 = (Function0) value$iv4;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(2072706078);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(subtitleLanguageRegex) | (((($changed & 112) ^ 48) > 32 && $composer2.changed(function3)) || ($changed & 48) == 32);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPage$5$1
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
                        PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.SUBTITLE_LANGUAGE, CollectionsKt.joinToString$default(SetsKt.plus((Set<? extends String>) FormatPageKt.FormatPage$lambda$6(diffSubtitleLanguages$delegate), subtitleLanguageRegex), ",", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPage$5$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final CharSequence invoke(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return it;
                            }
                        }, 30, null));
                        FormatPageKt.FormatPage$lambda$4(showUpdateSubtitleDialog$delegate, false);
                        function3.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            $composer2.endReplaceGroup();
            UpdateSubtitleLanguageDialog(companion, setFormatPage$lambda$6, function4, (Function0) value$iv5, $composer2, 70, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPage.6
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
                    FormatPageKt.FormatPage(downloadViewModel, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoInfo FormatPage$lambda$0(State<VideoInfo> state) {
        Object thisObj$iv = state.getValue();
        return (VideoInfo) thisObj$iv;
    }

    private static final boolean FormatPage$lambda$3(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPage$lambda$4(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<String> FormatPage$lambda$6(MutableState<Set<String>> mutableState) {
        MutableState<Set<String>> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPagePreview(Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(-261664275);
        ComposerKt.sourceInformation($composer2, "C(FormatPagePreview)270@10621L210,270@10611L220:FormatPage.kt#y3famj");
        if ($changed == 0 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-261664275, $changed, -1, "com.videshkarmakar.loop.ui.page.download.FormatPagePreview (FormatPage.kt:185)");
            }
            Map captionsMap = MapsKt.mapOf(TuplesKt.to("en-en", CollectionsKt.listOf(new SubtitleFormat("", "", "English from English", (String) null, 8, (DefaultConstructorMarker) null))), TuplesKt.to("ja-en", CollectionsKt.listOf(new SubtitleFormat("", "", "Japanese from English", (String) null, 8, (DefaultConstructorMarker) null))), TuplesKt.to("zh-Hans-en", CollectionsKt.listOf(new SubtitleFormat("", "", "Chinese (Simplified) from English", (String) null, 8, (DefaultConstructorMarker) null))), TuplesKt.to("zh-Hant-en", CollectionsKt.listOf(new SubtitleFormat("", "", "Chinese (Traditional) from English", (String) null, 8, (DefaultConstructorMarker) null))));
            Map $this$FormatPagePreview_u24lambda_u2411 = MapsKt.createMapBuilder();
            $this$FormatPagePreview_u24lambda_u2411.put("en", CollectionsKt.listOf(new SubtitleFormat("ass", "", "English", (String) null, 8, (DefaultConstructorMarker) null)));
            $this$FormatPagePreview_u24lambda_u2411.put("ja", CollectionsKt.listOf(new SubtitleFormat("ass", "", "Japanese", (String) null, 8, (DefaultConstructorMarker) null)));
            Map subMap = MapsKt.build($this$FormatPagePreview_u24lambda_u2411);
            List $this$FormatPagePreview_u24lambda_u2415 = CollectionsKt.createListBuilder();
            int i2 = 0;
            while (true) {
                if (i2 >= 7) {
                    break;
                }
                int it = i2;
                $this$FormatPagePreview_u24lambda_u2415.add(new Format(String.valueOf(it), (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, 262142, (DefaultConstructorMarker) null));
                i2++;
            }
            for (int i3 = 0; i3 < 7; i3++) {
                int it2 = i3;
                $this$FormatPagePreview_u24lambda_u2415.add(new Format(String.valueOf(it2), (String) null, (String) null, "none", "avc1", (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, 262118, (DefaultConstructorMarker) null));
            }
            int i4 = 0;
            for (i = 7; i4 < i; i = 7) {
                int it3 = i4;
                $this$FormatPagePreview_u24lambda_u2415.add(new Format(String.valueOf(it3), (String) null, (String) null, "aac", "none", (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, "251 - audio only (medium)", (String) null, (Double) null, (Double) null, Double.valueOf(128.0d), (Double) null, Double.valueOf(2000000.0d), 96230, (DefaultConstructorMarker) null));
                i4++;
            }
            List listBuild = CollectionsKt.build($this$FormatPagePreview_u24lambda_u2415);
            List $this$FormatPagePreview_u24lambda_u2416 = CollectionsKt.createListBuilder();
            $this$FormatPagePreview_u24lambda_u2416.add(new Format("616", (String) null, "webm", "none", "vp09.00.40.08", (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, "616 - 1920x1080 (Premium)", (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, 260066, (DefaultConstructorMarker) null));
            $this$FormatPagePreview_u24lambda_u2416.add(new Format("251", (String) null, "webm", "opus", "none", (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, "251 - audio only (medium)", (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, 260066, (DefaultConstructorMarker) null));
            List listBuild2 = CollectionsKt.build($this$FormatPagePreview_u24lambda_u2416);
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            final VideoInfo videoInfo = new VideoInfo(str, str2, listBuild, str3, str4, (String) null, str5, subMap, captionsMap, Double.valueOf(180.0d), (Long) null, (String) null, (List) null, (String) null, (Integer) null, (List) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (Double) null, (String) null, (Double) null, (Integer) null, (Integer) null, (List) null, listBuild2, (String) null, (String) null, -901, 3670015, (DefaultConstructorMarker) null);
            ThemeKt.LoopTheme(false, false, false, ComposableLambdaKt.rememberComposableLambda(-1448237980, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPagePreview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C271@10631L194:FormatPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1448237980, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.FormatPagePreview.<anonymous> (FormatPage.kt:271)");
                        }
                        FormatPageKt.FormatPageImpl(videoInfo, false, true, true, SetsKt.setOf((Object[]) new String[]{"en", "ja-en"}), null, null, $composer3, 28040, 98);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPagePreview.2
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
                    FormatPageKt.FormatPagePreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x02dc  */
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
    public static final void FormatPageImpl(VideoInfo videoInfo, boolean audioOnly, boolean mergeAudioStream, boolean isClippingAvailable, final Set<String> selectedSubtitleCodes, Function0<Unit> function0, Function5<? super List<Format>, ? super List<VideoClip>, ? super Boolean, ? super String, ? super List<String>, Unit> function5, Composer $composer, final int $changed, final int i) {
        VideoInfo videoInfo2;
        int $dirty;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        final boolean isSuggestedFormatAvailable;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Object value$iv8;
        Object value$iv9;
        Object value$iv10;
        Object value$iv11;
        Object value$iv12;
        Object value$iv13;
        Object value$iv14;
        int $dirty2;
        final Map<String, List<SubtitleFormat>> map;
        FormatPageKt$FormatPageImpl$4$1 value$iv15;
        Object value$iv16;
        Object value$iv17;
        Composer $composer2;
        final MutableState showSubtitleSelectionDialog$delegate;
        Object value$iv18;
        Object value$iv19;
        Object value$iv20;
        Object value$iv21;
        Object value$iv22;
        Object value$iv23;
        Intrinsics.checkNotNullParameter(selectedSubtitleCodes, "selectedSubtitleCodes");
        Composer $composer3 = $composer.startRestartGroup(472916965);
        ComposerKt.sourceInformation($composer3, "C(FormatPageImpl)P(6!1,2!1,5,4)291@11301L22,303@11807L33,304@11871L33,305@11936L33,310@12147L55,313@12241L44,314@12321L44,315@12401L38,316@12471L7,318@12517L7,319@12570L7,330@12934L34,331@12997L34,335@13207L34,336@13270L34,337@13344L34,339@13409L47,340@13479L31,349@13898L73,349@13866L105,354@14009L419,369@14470L81,374@14688L1037,397@15727L15683,371@14557L16853,754@32058L39,755@32119L164,750@31860L429:FormatPage.kt#y3famj");
        if ((i & 1) != 0) {
            VideoInfo videoInfo3 = new VideoInfo((String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (Double) null, (Long) null, (String) null, (List) null, (String) null, (Integer) null, (List) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (Double) null, (String) null, (Double) null, (Integer) null, (Integer) null, (List) null, (List) null, (String) null, (String) null, -1, 4194303, (DefaultConstructorMarker) null);
            int $dirty3 = $changed & (-15);
            $dirty = $dirty3;
            videoInfo2 = videoInfo3;
        } else {
            videoInfo2 = videoInfo;
            $dirty = $changed;
        }
        int $dirty4 = i & 2;
        boolean audioOnly2 = $dirty4 != 0 ? false : audioOnly;
        boolean mergeAudioStream2 = (i & 4) != 0 ? false : mergeAudioStream;
        boolean isClippingAvailable2 = (i & 8) != 0 ? false : isClippingAvailable;
        Function0<Unit> function1 = (i & 32) != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0;
        Function5<? super List<Format>, ? super List<VideoClip>, ? super Boolean, ? super String, ? super List<String>, Unit> function6 = (i & 64) != 0 ? new Function5<List<? extends Format>, List<? extends VideoClip>, Boolean, String, List<? extends String>, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.2
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Format> list, List<? extends VideoClip> list2, Boolean bool, String str, List<? extends String> list3) {
                invoke((List<Format>) list, (List<VideoClip>) list2, bool.booleanValue(), str, (List<String>) list3);
                return Unit.INSTANCE;
            }

            public final void invoke(List<Format> list, List<VideoClip> list2, boolean z, String str, List<String> list3) {
                Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(list2, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 3>");
                Intrinsics.checkNotNullParameter(list3, "<anonymous parameter 4>");
            }
        } : function5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(472916965, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl (FormatPage.kt:290)");
        }
        final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
        List<Format> formats = videoInfo2.getFormats();
        if (formats == null || formats.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final VideoInfo videoInfo4 = videoInfo2;
                final boolean z = audioOnly2;
                final boolean z2 = mergeAudioStream2;
                final boolean z3 = isClippingAvailable2;
                final Function0<Unit> function2 = function1;
                final Function5<? super List<Format>, ? super List<VideoClip>, ? super Boolean, ? super String, ? super List<String>, Unit> function7 = function6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.3
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
                        FormatPageKt.FormatPageImpl(videoInfo4, z, z2, z3, selectedSubtitleCodes, function2, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
                return;
            }
            return;
        }
        Iterable $this$filter$iv = videoInfo2.getFormats();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Format it = (Format) element$iv$iv;
            if (!Intrinsics.areEqual(it.getVcodec(), "none") && Intrinsics.areEqual(it.getAcodec(), "none")) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        final List videoOnlyFormats = CollectionsKt.reversed((List) destination$iv$iv);
        Iterable $this$filter$iv2 = videoInfo2.getFormats();
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            Format it2 = (Format) element$iv$iv2;
            if (!Intrinsics.areEqual(it2.getAcodec(), "none") && Intrinsics.areEqual(it2.getVcodec(), "none")) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        final List audioOnlyFormats = CollectionsKt.reversed((List) destination$iv$iv2);
        Iterable $this$filter$iv3 = videoInfo2.getFormats();
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv3 : $this$filter$iv3) {
            Format it3 = (Format) element$iv$iv3;
            if ((Intrinsics.areEqual(it3.getAcodec(), "none") || Intrinsics.areEqual(it3.getVcodec(), "none")) ? false : true) {
                destination$iv$iv3.add(element$iv$iv3);
            }
        }
        final List videoAudioFormats = CollectionsKt.reversed((List) destination$iv$iv3);
        Double duration = videoInfo2.getDuration();
        final double duration2 = duration != null ? duration.doubleValue() : 0.0d;
        $composer3.startReplaceGroup(-344728842);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv = $composer3.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotIntStateKt.mutableIntStateOf(6);
            $composer3.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableIntState videoOnlyItemLimit$delegate = (MutableIntState) value$iv;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344728778);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv2 = $composer3.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotIntStateKt.mutableIntStateOf(6);
            $composer3.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final MutableIntState audioOnlyItemLimit$delegate = (MutableIntState) value$iv2;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344728713);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv3 = $composer3.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = SnapshotIntStateKt.mutableIntStateOf(6);
            $composer3.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        final MutableIntState videoAudioItemLimit$delegate = (MutableIntState) value$iv3;
        $composer3.endReplaceGroup();
        List<Format> requestedFormats = videoInfo2.getRequestedFormats();
        if (requestedFormats == null || requestedFormats.isEmpty()) {
            List<RequestedDownload> requestedDownloads = videoInfo2.getRequestedDownloads();
            if (requestedDownloads == null || requestedDownloads.isEmpty()) {
                isSuggestedFormatAvailable = false;
            } else {
                isSuggestedFormatAvailable = true;
            }
        } else {
            isSuggestedFormatAvailable = true;
        }
        $composer3.startReplaceGroup(-344728502);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv4 = $composer3.rememberedValue();
        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isSuggestedFormatAvailable), null, 2, null);
            $composer3.updateRememberedValue(value$iv4);
        } else {
            value$iv4 = it$iv4;
        }
        final MutableState isSuggestedFormatSelected$delegate = (MutableState) value$iv4;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344728408);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv5 = $composer3.rememberedValue();
        if (it$iv5 == Composer.INSTANCE.getEmpty()) {
            value$iv5 = SnapshotIntStateKt.mutableIntStateOf(-1);
            $composer3.updateRememberedValue(value$iv5);
        } else {
            value$iv5 = it$iv5;
        }
        final MutableIntState selectedVideoAudioFormat$delegate = (MutableIntState) value$iv5;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344728328);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv6 = $composer3.rememberedValue();
        if (it$iv6 == Composer.INSTANCE.getEmpty()) {
            value$iv6 = SnapshotIntStateKt.mutableIntStateOf(-1);
            $composer3.updateRememberedValue(value$iv6);
        } else {
            value$iv6 = it$iv6;
        }
        final MutableIntState selectedVideoOnlyFormat$delegate = (MutableIntState) value$iv6;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344728248);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv7 = $composer3.rememberedValue();
        if (it$iv7 == Composer.INSTANCE.getEmpty()) {
            value$iv7 = SnapshotStateKt.mutableStateListOf();
            $composer3.updateRememberedValue(value$iv7);
        } else {
            value$iv7 = it$iv7;
        }
        final SnapshotStateList selectedAudioOnlyFormats = (SnapshotStateList) value$iv7;
        $composer3.endReplaceGroup();
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer3.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        final Context context = (Context) objConsume;
        ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer3.consume(localUriHandler);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        final UriHandler uriHandler = (UriHandler) objConsume2;
        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume3 = $composer3.consume(localHapticFeedback);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        final HapticFeedback hapticFeedback = (HapticFeedback) objConsume3;
        $composer3.startReplaceGroup(-344727715);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv8 = $composer3.rememberedValue();
        if (it$iv8 == Composer.INSTANCE.getEmpty()) {
            value$iv8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer3.updateRememberedValue(value$iv8);
        } else {
            value$iv8 = it$iv8;
        }
        final MutableState isClippingVideo$delegate = (MutableState) value$iv8;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344727652);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv9 = $composer3.rememberedValue();
        if (it$iv9 == Composer.INSTANCE.getEmpty()) {
            value$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer3.updateRememberedValue(value$iv9);
        } else {
            value$iv9 = it$iv9;
        }
        final MutableState isSplittingVideo$delegate = (MutableState) value$iv9;
        $composer3.endReplaceGroup();
        List<Chapter> chapters = videoInfo2.getChapters();
        final boolean isSplitByChapterAvailable = !(chapters == null || chapters.isEmpty());
        Double duration3 = videoInfo2.getDuration();
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, duration3 != null ? (float) duration3.doubleValue() : 0.0f);
        $composer3.startReplaceGroup(-344727442);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv10 = $composer3.rememberedValue();
        if (it$iv10 == Composer.INSTANCE.getEmpty()) {
            value$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer3.updateRememberedValue(value$iv10);
        } else {
            value$iv10 = it$iv10;
        }
        final MutableState showVideoClipDialog$delegate = (MutableState) value$iv10;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344727379);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv11 = $composer3.rememberedValue();
        if (it$iv11 == Composer.INSTANCE.getEmpty()) {
            value$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer3.updateRememberedValue(value$iv11);
        } else {
            value$iv11 = it$iv11;
        }
        final MutableState showRenameDialog$delegate = (MutableState) value$iv11;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344727305);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv12 = $composer3.rememberedValue();
        if (it$iv12 == Composer.INSTANCE.getEmpty()) {
            value$iv12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer3.updateRememberedValue(value$iv12);
        } else {
            value$iv12 = it$iv12;
        }
        final MutableState showSubtitleSelectionDialog$delegate2 = (MutableState) value$iv12;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344727240);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv13 = $composer3.rememberedValue();
        if (it$iv13 == Composer.INSTANCE.getEmpty()) {
            value$iv13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(closedFloatingPointRangeRangeTo, null, 2, null);
            $composer3.updateRememberedValue(value$iv13);
        } else {
            value$iv13 = it$iv13;
        }
        final MutableState videoClipDuration$delegate = (MutableState) value$iv13;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344727170);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv14 = $composer3.rememberedValue();
        if (it$iv14 == Composer.INSTANCE.getEmpty()) {
            value$iv14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
            $composer3.updateRememberedValue(value$iv14);
        } else {
            value$iv14 = it$iv14;
        }
        final MutableState videoTitle$delegate = (MutableState) value$iv14;
        $composer3.endReplaceGroup();
        Map<String, List<SubtitleFormat>> subtitles = videoInfo2.getSubtitles();
        if (!(!subtitles.isEmpty())) {
            subtitles = null;
        }
        if (subtitles == null) {
            Map<String, List<SubtitleFormat>> automaticCaptions = videoInfo2.getAutomaticCaptions();
            int $i$f$filterKeys = 0;
            LinkedHashMap result$iv = new LinkedHashMap();
            Iterator<Map.Entry<String, List<SubtitleFormat>>> it4 = automaticCaptions.entrySet().iterator();
            while (it4.hasNext()) {
                Map.Entry<String, List<SubtitleFormat>> next = it4.next();
                automaticCaptions = automaticCaptions;
                $i$f$filterKeys = $i$f$filterKeys;
                it4 = it4;
                $dirty = $dirty;
                if (StringsKt.endsWith$default(next.getKey(), "-orig", false, 2, (Object) null)) {
                    result$iv.put(next.getKey(), next.getValue());
                }
            }
            $dirty2 = $dirty;
            map = result$iv;
        } else {
            $dirty2 = $dirty;
            map = subtitles;
        }
        Map otherSubtitleMap = MapsKt.minus(MapsKt.plus(videoInfo2.getSubtitles(), videoInfo2.getAutomaticCaptions()), (Iterable) map.keySet());
        Boolean boolValueOf = Boolean.valueOf(FormatPageImpl$lambda$42(isClippingVideo$delegate));
        $composer3.startReplaceGroup(-344726751);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        boolean invalid$iv = $composer3.changed(closedFloatingPointRangeRangeTo);
        Object it$iv15 = $composer3.rememberedValue();
        if (invalid$iv || it$iv15 == Composer.INSTANCE.getEmpty()) {
            value$iv15 = new FormatPageKt$FormatPageImpl$4$1(closedFloatingPointRangeRangeTo, videoClipDuration$delegate, null);
            $composer3.updateRememberedValue(value$iv15);
        } else {
            value$iv15 = it$iv15;
        }
        $composer3.endReplaceGroup();
        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv15, $composer3, 64);
        $composer3.startReplaceGroup(-344726640);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv16 = $composer3.rememberedValue();
        if (it$iv16 == Composer.INSTANCE.getEmpty()) {
            value$iv16 = SnapshotStateKt.derivedStateOf(new Function0<List<Format>>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$formatList$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<Format> invoke() {
                    List $this$invoke_u24lambda_u243 = new ArrayList();
                    Iterable iterable = selectedAudioOnlyFormats;
                    List<Format> list = videoAudioFormats;
                    List<Format> list2 = videoOnlyFormats;
                    List<Format> list3 = audioOnlyFormats;
                    MutableIntState mutableIntState = selectedVideoAudioFormat$delegate;
                    MutableIntState mutableIntState2 = selectedVideoOnlyFormat$delegate;
                    Iterable $this$forEach$iv = iterable;
                    for (Object element$iv : $this$forEach$iv) {
                        int index = ((Number) element$iv).intValue();
                        $this$invoke_u24lambda_u243.add(list3.get(index));
                    }
                    Format it5 = (Format) CollectionsKt.getOrNull(list, FormatPageKt.FormatPageImpl$lambda$33(mutableIntState));
                    if (it5 != null) {
                        $this$invoke_u24lambda_u243.add(it5);
                    }
                    Format it6 = (Format) CollectionsKt.getOrNull(list2, FormatPageKt.FormatPageImpl$lambda$36(mutableIntState2));
                    if (it6 != null) {
                        $this$invoke_u24lambda_u243.add(it6);
                    }
                    return $this$invoke_u24lambda_u243;
                }
            });
            $composer3.updateRememberedValue(value$iv16);
        } else {
            value$iv16 = it$iv16;
        }
        final State formatList$delegate = (State) value$iv16;
        $composer3.endReplaceGroup();
        $composer3.startReplaceGroup(-344726179);
        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv17 = $composer3.rememberedValue();
        if (it$iv17 == Composer.INSTANCE.getEmpty()) {
            SnapshotStateList $this$FormatPageImpl_u24lambda_u2468_u24lambda_u2467 = SnapshotStateKt.mutableStateListOf();
            $this$FormatPageImpl_u24lambda_u2468_u24lambda_u2467.addAll(selectedSubtitleCodes);
            value$iv17 = $this$FormatPageImpl_u24lambda_u2468_u24lambda_u2467;
            $composer3.updateRememberedValue(value$iv17);
        } else {
            value$iv17 = it$iv17;
        }
        final SnapshotStateList selectedLanguageList = (SnapshotStateList) value$iv17;
        $composer3.endReplaceGroup();
        final Function0<Unit> function3 = function1;
        final Function5<? super List<Format>, ? super List<VideoClip>, ? super Boolean, ? super String, ? super List<String>, Unit> function8 = function6;
        final VideoInfo videoInfo5 = videoInfo2;
        final boolean z4 = audioOnly2;
        final boolean z5 = isClippingAvailable2;
        final boolean z6 = mergeAudioStream2;
        ScaffoldKt.m2282ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(104886441, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.5
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
                ComposerKt.sourceInformation($composer4, "C380@14985L173,384@15170L544,375@14702L1013:FormatPage.kt#y3famj");
                if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(104886441, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous> (FormatPage.kt:375)");
                    }
                    Function2<Composer, Integer, Unit> function2M7222getLambda1$app_debug = ComposableSingletons$FormatPageKt.INSTANCE.m7222getLambda1$app_debug();
                    final Function0<Unit> function4 = function3;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1096261923, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.5.1
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
                            Object value$iv24;
                            ComposerKt.sourceInformation($composer5, "C381@15024L20,381@15003L141:FormatPage.kt#y3famj");
                            if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1096261923, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous> (FormatPage.kt:381)");
                            }
                            $composer5.startReplaceGroup(1998548297);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                            boolean invalid$iv2 = $composer5.changed(function4);
                            final Function0<Unit> function9 = function4;
                            Object it$iv18 = $composer5.rememberedValue();
                            if (invalid$iv2 || it$iv18 == Composer.INSTANCE.getEmpty()) {
                                value$iv24 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$5$1$1$1
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
                                        function9.invoke();
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv24);
                            } else {
                                value$iv24 = it$iv18;
                            }
                            $composer5.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv24, null, false, null, null, ComposableSingletons$FormatPageKt.INSTANCE.m7231getLambda2$app_debug(), $composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54);
                    final Function5<List<Format>, List<VideoClip>, Boolean, String, List<String>, Unit> function9 = function8;
                    final SnapshotStateList<String> snapshotStateList = selectedLanguageList;
                    final State<List<Format>> state = formatList$delegate;
                    final MutableState<Boolean> mutableState = isClippingVideo$delegate;
                    final MutableState<ClosedFloatingPointRange<Float>> mutableState2 = videoClipDuration$delegate;
                    final MutableState<Boolean> mutableState3 = isSplittingVideo$delegate;
                    final MutableState<String> mutableState4 = videoTitle$delegate;
                    final MutableState<Boolean> mutableState5 = isSuggestedFormatSelected$delegate;
                    AppBarKt.m1675TopAppBarGHTll3U(function2M7222getLambda1$app_debug, null, composableLambdaRememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(-1309210150, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.5.2
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

                        public final void invoke(RowScope TopAppBar, Composer $composer5, int $changed3) {
                            Object value$iv24;
                            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                            ComposerKt.sourceInformation($composer5, "C385@15209L339,385@15188L512:FormatPage.kt#y3famj");
                            if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1309210150, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous> (FormatPage.kt:385)");
                            }
                            $composer5.startReplaceGroup(1998548482);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                            boolean invalid$iv2 = $composer5.changed(function9);
                            final Function5<List<Format>, List<VideoClip>, Boolean, String, List<String>, Unit> function10 = function9;
                            final SnapshotStateList<String> snapshotStateList2 = snapshotStateList;
                            final State<List<Format>> state2 = state;
                            final MutableState<Boolean> mutableState6 = mutableState;
                            final MutableState<ClosedFloatingPointRange<Float>> mutableState7 = mutableState2;
                            final MutableState<Boolean> mutableState8 = mutableState3;
                            final MutableState<String> mutableState9 = mutableState4;
                            Object it$iv18 = $composer5.rememberedValue();
                            if (invalid$iv2 || it$iv18 == Composer.INSTANCE.getEmpty()) {
                                value$iv24 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$5$2$1$1
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
                                        function10.invoke(FormatPageKt.FormatPageImpl$lambda$66(state2), FormatPageKt.FormatPageImpl$lambda$42(mutableState6) ? CollectionsKt.listOf(new VideoClip(FormatPageKt.FormatPageImpl$lambda$57(mutableState7))) : CollectionsKt.emptyList(), Boolean.valueOf(FormatPageKt.FormatPageImpl$lambda$45(mutableState8)), FormatPageKt.FormatPageImpl$lambda$60(mutableState9), snapshotStateList2);
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv24);
                            } else {
                                value$iv24 = it$iv18;
                            }
                            Function0 function11 = (Function0) value$iv24;
                            $composer5.endReplaceGroup();
                            boolean z7 = true;
                            if (!FormatPageKt.FormatPageImpl$lambda$30(mutableState5) && !(!FormatPageKt.FormatPageImpl$lambda$66(state).isEmpty())) {
                                z7 = false;
                            }
                            ButtonKt.TextButton(function11, null, z7, null, null, null, null, null, null, ComposableSingletons$FormatPageKt.INSTANCE.m7232getLambda3$app_debug(), $composer5, 805306368, HttpStatusCodesKt.HTTP_VARIANT_ALSO_NEGOTIATES);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), 0.0f, null, null, scrollBehavior, $composer4, 3462, 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer4.skipToGroupEnd();
            }
        }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-66954892, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6
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

            public final void invoke(PaddingValues paddingValues, Composer $composer4, int $changed2) {
                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                ComposerKt.sourceInformation($composer4, "C399@15755L15649:FormatPage.kt#y3famj");
                int $dirty5 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty5 |= $composer4.changed(paddingValues) ? 4 : 2;
                }
                int $dirty6 = $dirty5;
                if (($dirty6 & 91) != 18 || !$composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-66954892, $dirty6, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous> (FormatPage.kt:399)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM496spacedBy0680j_4 = Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(8));
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM496spacedBy0680j_5 = Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(8));
                    GridCells.Adaptive adaptive = new GridCells.Adaptive(Dp.m6553constructorimpl(150), null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical = horizontalOrVerticalM496spacedBy0680j_5;
                    final VideoInfo videoInfo6 = videoInfo5;
                    final Map<String, List<SubtitleFormat>> map2 = map;
                    final boolean z7 = isSuggestedFormatAvailable;
                    final List<Format> list = audioOnlyFormats;
                    final boolean z8 = z4;
                    final List<Format> list2 = videoOnlyFormats;
                    final List<Format> list3 = videoAudioFormats;
                    final double d = duration2;
                    final boolean z9 = z5;
                    final boolean z10 = isSplitByChapterAvailable;
                    final MutableState<String> mutableState = videoTitle$delegate;
                    final MutableState<Boolean> mutableState2 = isClippingVideo$delegate;
                    final MutableState<Boolean> mutableState3 = isSplittingVideo$delegate;
                    final MutableState<Boolean> mutableState4 = showRenameDialog$delegate;
                    final UriHandler uriHandler2 = uriHandler;
                    final MutableState<Boolean> mutableState5 = showVideoClipDialog$delegate;
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange = closedFloatingPointRangeRangeTo;
                    final MutableState<ClosedFloatingPointRange<Float>> mutableState6 = videoClipDuration$delegate;
                    final MutableState<Boolean> mutableState7 = showSubtitleSelectionDialog$delegate2;
                    final SnapshotStateList<String> snapshotStateList = selectedLanguageList;
                    final SnapshotStateList<Integer> snapshotStateList2 = selectedAudioOnlyFormats;
                    final MutableState<Boolean> mutableState8 = isSuggestedFormatSelected$delegate;
                    final MutableIntState mutableIntState = selectedVideoAudioFormat$delegate;
                    final MutableIntState mutableIntState2 = selectedVideoOnlyFormat$delegate;
                    final MutableIntState mutableIntState3 = audioOnlyItemLimit$delegate;
                    final HapticFeedback hapticFeedback2 = hapticFeedback;
                    final boolean z11 = z6;
                    final Context context2 = context;
                    final MutableIntState mutableIntState4 = videoOnlyItemLimit$delegate;
                    final MutableIntState mutableIntState5 = videoAudioItemLimit$delegate;
                    LazyGridDslKt.LazyVerticalGrid(adaptive, modifierPadding, null, PaddingKt.m613PaddingValues0680j_4(Dp.m6553constructorimpl(8)), false, horizontalOrVerticalM496spacedBy0680j_4, horizontalOrVertical, null, false, new Function1<LazyGridScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyGridScope lazyGridScope) {
                            invoke2(lazyGridScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyGridScope LazyVerticalGrid) {
                            Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
                            final VideoInfo $this$invoke_u24lambda_u240 = videoInfo6;
                            final double d2 = d;
                            final boolean z12 = z9;
                            final boolean z13 = z10;
                            final MutableState<String> mutableState9 = mutableState;
                            final MutableState<Boolean> mutableState10 = mutableState2;
                            final MutableState<Boolean> mutableState11 = mutableState3;
                            final MutableState<Boolean> mutableState12 = mutableState4;
                            final UriHandler uriHandler3 = uriHandler2;
                            LazyGridScope.CC.item$default(LazyVerticalGrid, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$1$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                    return GridItemSpan.m734boximpl(m7257invokeBHJflc(lazyGridItemSpanScope));
                                }

                                /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                public final long m7257invokeBHJflc(LazyGridItemSpanScope item) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                }
                            }, null, ComposableLambdaKt.composableLambdaInstance(156298649, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$1$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                                    invoke(lazyGridItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyGridItemScope item, Composer $composer5, int $changed3) {
                                    Object value$iv24;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer5, "C420@17001L79,418@16839L38,419@16924L40,408@16175L1070:FormatPage.kt#y3famj");
                                    if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                        $composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(156298649, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:408)");
                                    }
                                    Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 2, null);
                                    String strFormatPageImpl$lambda$60 = FormatPageKt.FormatPageImpl$lambda$60(mutableState9);
                                    VideoInfo videoInfo7 = $this$invoke_u24lambda_u240;
                                    if (strFormatPageImpl$lambda$60.length() == 0) {
                                        strFormatPageImpl$lambda$60 = videoInfo7.getTitle();
                                    }
                                    String str = strFormatPageImpl$lambda$60;
                                    String uploader = $this$invoke_u24lambda_u240.getUploader();
                                    if (uploader == null && (uploader = $this$invoke_u24lambda_u240.getChannel()) == null) {
                                        uploader = String.valueOf($this$invoke_u24lambda_u240.getUploaderId());
                                    }
                                    String httpsUrl = TextUtilKt.toHttpsUrl($this$invoke_u24lambda_u240.getThumbnail());
                                    int iRoundToInt = MathKt.roundToInt(d2);
                                    boolean zFormatPageImpl$lambda$42 = FormatPageKt.FormatPageImpl$lambda$42(mutableState10);
                                    boolean zFormatPageImpl$lambda$45 = FormatPageKt.FormatPageImpl$lambda$45(mutableState11);
                                    boolean z14 = z12;
                                    boolean z15 = z13;
                                    $composer5.startReplaceGroup(-1234807612);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                    final MutableState<Boolean> mutableState13 = mutableState12;
                                    Object value$iv25 = $composer5.rememberedValue();
                                    if (value$iv25 == Composer.INSTANCE.getEmpty()) {
                                        value$iv25 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$1$2$2$1
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
                                                FormatPageKt.FormatPageImpl$lambda$52(mutableState13, true);
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv25);
                                    }
                                    Function0 function4 = (Function0) value$iv25;
                                    $composer5.endReplaceGroup();
                                    final UriHandler uriHandler4 = uriHandler3;
                                    final VideoInfo videoInfo8 = $this$invoke_u24lambda_u240;
                                    Function0<Unit> function9 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$1$2.3
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
                                            uriHandler4.openUri(TextUtilKt.toHttpsUrl(videoInfo8.getThumbnail()));
                                        }
                                    };
                                    $composer5.startReplaceGroup(-1234807774);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                    final MutableState<Boolean> mutableState14 = mutableState10;
                                    Object it$iv18 = $composer5.rememberedValue();
                                    if (it$iv18 == Composer.INSTANCE.getEmpty()) {
                                        value$iv24 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$1$2$4$1
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
                                                FormatPageKt.FormatPageImpl$lambda$43(mutableState14, !FormatPageKt.FormatPageImpl$lambda$42(mutableState14));
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv24);
                                    } else {
                                        value$iv24 = it$iv18;
                                    }
                                    Function0 function10 = (Function0) value$iv24;
                                    $composer5.endReplaceGroup();
                                    $composer5.startReplaceGroup(-1234807689);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                    final MutableState<Boolean> mutableState15 = mutableState11;
                                    Object value$iv26 = $composer5.rememberedValue();
                                    if (value$iv26 == Composer.INSTANCE.getEmpty()) {
                                        value$iv26 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$1$2$5$1
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
                                                FormatPageKt.FormatPageImpl$lambda$46(mutableState15, !FormatPageKt.FormatPageImpl$lambda$45(mutableState15));
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv26);
                                    }
                                    $composer5.endReplaceGroup();
                                    FormatItemKt.FormatVideoPreview(modifierM622paddingVpY3zN4$default, str, uploader, httpsUrl, iRoundToInt, zFormatPageImpl$lambda$45, zFormatPageImpl$lambda$42, z14, z15, function4, function9, function10, (Function0) value$iv26, $composer5, 805306374, 432, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 5, null);
                            LazyGridScope.CC.item$default(LazyVerticalGrid, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                    return GridItemSpan.m734boximpl(m7261invokeBHJflc(lazyGridItemSpanScope));
                                }

                                /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                public final long m7261invokeBHJflc(LazyGridItemSpanScope item) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                }
                            }, null, ComposableLambdaKt.composableLambdaInstance(1199533734, true, new AnonymousClass3(mutableState2, mutableState5, closedFloatingPointRange, mutableState6, mutableState3, videoInfo6)), 5, null);
                            if (!map2.isEmpty()) {
                                AnonymousClass4 anonymousClass4 = new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                        return GridItemSpan.m734boximpl(m7262invokeBHJflc(lazyGridItemSpanScope));
                                    }

                                    /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                    public final long m7262invokeBHJflc(LazyGridItemSpanScope item) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                    }
                                };
                                final MutableState<Boolean> mutableState13 = mutableState7;
                                final Map<String, List<SubtitleFormat>> map3 = map2;
                                final SnapshotStateList<String> snapshotStateList3 = snapshotStateList;
                                LazyGridScope.CC.item$default(LazyVerticalGrid, null, anonymousClass4, null, ComposableLambdaKt.composableLambdaInstance(-1254806165, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                                        invoke(lazyGridItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyGridItemScope item, Composer $composer5, int $changed3) {
                                        Function0<ComposeUiNode> function4;
                                        Function0<ComposeUiNode> function9;
                                        Object value$iv24;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C494@20460L2075:FormatPage.kt#y3famj");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1254806165, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:494)");
                                            }
                                            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            final MutableState<Boolean> mutableState14 = mutableState13;
                                            final Map<String, List<SubtitleFormat>> map4 = map3;
                                            final SnapshotStateList<String> snapshotStateList4 = snapshotStateList3;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                            int $changed$iv$iv = (6 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                            if (!($composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer5.startReusableNode();
                                            if ($composer5.getInserting()) {
                                                function4 = constructor;
                                                $composer5.createNode(function4);
                                            } else {
                                                function4 = constructor;
                                                $composer5.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                            int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            int i3 = ((6 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -1234804084, "C495@20529L986,516@21541L971:FormatPage.kt#y3famj");
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 0.0f, 0.0f, 13, null), Dp.m6553constructorimpl(12), 0.0f, 2, null);
                                            ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, centerVertically, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                            int $changed$iv$iv2 = (390 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifierM622paddingVpY3zN4$default);
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                            if (!($composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer5.startReusableNode();
                                            if ($composer5.getInserting()) {
                                                function9 = constructor2;
                                                $composer5.createNode(function9);
                                            } else {
                                                function9 = constructor2;
                                                $composer5.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer5);
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                            }
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                            int i5 = ((390 >> 6) & 112) | 6;
                                            RowScope $this$invoke_u24lambda_u242_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart($composer5, 90551613, "C501@20846L47,502@20949L11,503@21024L10,500@20801L338,509@21277L82,510@21390L98,507@21169L319:FormatPage.kt#y3famj");
                                            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.subtitle_language, $composer5, 0), RowScope.CC.weight$default($this$invoke_u24lambda_u242_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null), MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getTitleSmall(), $composer5, 0, 0, 65528);
                                            String strStringResource = StringResources_androidKt.stringResource(androidx.appcompat.R.string.abc_activity_chooser_view_see_all, $composer5, 0);
                                            $composer5.startReplaceGroup(90552202);
                                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                            Object it$iv18 = $composer5.rememberedValue();
                                            if (it$iv18 == Composer.INSTANCE.getEmpty()) {
                                                value$iv24 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$5$1$1$1$1
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
                                                        FormatPageKt.FormatPageImpl$lambda$55(mutableState14, true);
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv24);
                                            } else {
                                                value$iv24 = it$iv18;
                                            }
                                            $composer5.endReplaceGroup();
                                            FormatPageKt.ClickableTextAction(true, strStringResource, null, (Function0) value$iv24, $composer5, 3078, 4);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            $composer5.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            LazyDslKt.LazyRow(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$5$1$2
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
                                                public final void invoke2(LazyListScope LazyRow) {
                                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                                    for (Map.Entry<String, List<SubtitleFormat>> entry : map4.entrySet()) {
                                                        final String code = entry.getKey();
                                                        final List<SubtitleFormat> value = entry.getValue();
                                                        final SnapshotStateList<String> snapshotStateList5 = snapshotStateList4;
                                                        LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1046051126, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$5$1$2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                                                invoke(lazyItemScope, composer, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(LazyItemScope item2, Composer $composer6, int $changed4) {
                                                                Object value$iv25;
                                                                Intrinsics.checkNotNullParameter(item2, "$this$item");
                                                                ComposerKt.sourceInformation($composer6, "C521@21888L390,519@21733L689:FormatPage.kt#y3famj");
                                                                if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1693195598, $changed4, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:519)");
                                                                    }
                                                                    boolean zContains = snapshotStateList5.contains(code);
                                                                    $composer6.startReplaceGroup(1130013085);
                                                                    ComposerKt.sourceInformation($composer6, "CC(remember):FormatPage.kt#9igjgp");
                                                                    boolean invalid$iv2 = $composer6.changed(code);
                                                                    final SnapshotStateList<String> snapshotStateList6 = snapshotStateList5;
                                                                    final String str = code;
                                                                    Object it$iv19 = $composer6.rememberedValue();
                                                                    if (invalid$iv2 || it$iv19 == Composer.INSTANCE.getEmpty()) {
                                                                        value$iv25 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$5$1$2$1$1$1
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
                                                                                if (snapshotStateList6.contains(str)) {
                                                                                    snapshotStateList6.remove(str);
                                                                                } else {
                                                                                    snapshotStateList6.add(str);
                                                                                }
                                                                            }
                                                                        };
                                                                        $composer6.updateRememberedValue(value$iv25);
                                                                    } else {
                                                                        value$iv25 = it$iv19;
                                                                    }
                                                                    Function0 function10 = (Function0) value$iv25;
                                                                    $composer6.endReplaceGroup();
                                                                    Object objFirst = CollectionsKt.first((List<? extends Object>) value);
                                                                    String str2 = code;
                                                                    SubtitleFormat $this$invoke_u24lambda_u241 = (SubtitleFormat) objFirst;
                                                                    String name = $this$invoke_u24lambda_u241.getName();
                                                                    ChipsKt.VideoFilterChip(null, zContains, false, function10, (name == null && (name = $this$invoke_u24lambda_u241.getProtocol()) == null) ? str2 : name, null, $composer6, 0, 37);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                $composer6.skipToGroupEnd();
                                                            }
                                                        }), 3, null);
                                                    }
                                                }
                                            }, $composer5, 6, 254);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            $composer5.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 5, null);
                            }
                            if (z7) {
                                LazyGridScope.CC.item$default(LazyVerticalGrid, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.6
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                        return GridItemSpan.m734boximpl(m7263invokeBHJflc(lazyGridItemSpanScope));
                                    }

                                    /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                    public final long m7263invokeBHJflc(LazyGridItemSpanScope item) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                    }
                                }, null, ComposableSingletons$FormatPageKt.INSTANCE.m7233getLambda4$app_debug(), 5, null);
                                AnonymousClass7 anonymousClass7 = new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.7
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                        return GridItemSpan.m734boximpl(m7264invokeBHJflc(lazyGridItemSpanScope));
                                    }

                                    /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                    public final long m7264invokeBHJflc(LazyGridItemSpanScope item) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                    }
                                };
                                final SnapshotStateList<Integer> snapshotStateList4 = snapshotStateList2;
                                final MutableState<Boolean> mutableState14 = mutableState8;
                                final MutableIntState mutableIntState6 = mutableIntState;
                                final MutableIntState mutableIntState7 = mutableIntState2;
                                final VideoInfo videoInfo7 = videoInfo6;
                                LazyGridScope.CC.item$default(LazyVerticalGrid, null, anonymousClass7, null, ComposableLambdaKt.composableLambdaInstance(1474946429, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.8
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                                        invoke(lazyGridItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyGridItemScope item, Composer $composer5, int $changed3) {
                                        Object value$iv24;
                                        Function0<ComposeUiNode> function4;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C550@23157L264,557@23443L491:FormatPage.kt#y3famj");
                                        if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1474946429, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:550)");
                                        }
                                        $composer5.startReplaceGroup(-1658162769);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                        final SnapshotStateList<Integer> snapshotStateList5 = snapshotStateList4;
                                        final MutableState<Boolean> mutableState15 = mutableState14;
                                        final MutableIntState mutableIntState8 = mutableIntState6;
                                        final MutableIntState mutableIntState9 = mutableIntState7;
                                        Object it$iv18 = $composer5.rememberedValue();
                                        if (it$iv18 == Composer.INSTANCE.getEmpty()) {
                                            value$iv24 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$8$onClick$1$1
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
                                                    FormatPageKt.FormatPageImpl$lambda$31(mutableState15, true);
                                                    snapshotStateList5.clear();
                                                    mutableIntState8.setIntValue(-1);
                                                    mutableIntState9.setIntValue(-1);
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv24);
                                        } else {
                                            value$iv24 = it$iv18;
                                        }
                                        Function0 onClick = (Function0) value$iv24;
                                        $composer5.endReplaceGroup();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Arrangement.HorizontalOrVertical horizontalOrVerticalM496spacedBy0680j_6 = Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(8));
                                        VideoInfo videoInfo8 = videoInfo7;
                                        MutableState<Boolean> mutableState16 = mutableState14;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                        Modifier modifier$iv = Modifier.INSTANCE;
                                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM496spacedBy0680j_6, centerVertically, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                        int $changed$iv$iv = (432 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer5.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer5.startReusableNode();
                                        if ($composer5.getInserting()) {
                                            function4 = constructor;
                                            $composer5.createNode(function4);
                                        } else {
                                            function4 = constructor;
                                            $composer5.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                        int i3 = ((432 >> 6) & 112) | 6;
                                        RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -1234800970, "C561@23643L269:FormatPage.kt#y3famj");
                                        FormatItemKt.SuggestedFormatItem(RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null), videoInfo8, FormatPageKt.FormatPageImpl$lambda$30(mutableState16), onClick, $composer5, 3136, 0);
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
                                }), 5, null);
                            }
                            if (!list.isEmpty()) {
                                AnonymousClass9 anonymousClass9 = new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.9
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                        return GridItemSpan.m734boximpl(m7265invokeBHJflc(lazyGridItemSpanScope));
                                    }

                                    /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                    public final long m7265invokeBHJflc(LazyGridItemSpanScope item) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                    }
                                };
                                final List<Format> list4 = list;
                                final MutableIntState mutableIntState8 = mutableIntState3;
                                final HapticFeedback hapticFeedback3 = hapticFeedback2;
                                LazyGridScope.CC.item$default(LazyVerticalGrid, null, anonymousClass9, null, ComposableLambdaKt.composableLambdaInstance(70891187, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.10
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                                        invoke(lazyGridItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyGridItemScope item, Composer $composer5, int $changed3) {
                                        Function0<ComposeUiNode> function4;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C573@24077L968:FormatPage.kt#y3famj");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(70891187, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:573)");
                                            }
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(16), 0.0f, 0.0f, 13, null), Dp.m6553constructorimpl(12), 0.0f, 2, null);
                                            List<Format> list5 = list4;
                                            final MutableIntState mutableIntState9 = mutableIntState8;
                                            final HapticFeedback hapticFeedback4 = hapticFeedback3;
                                            ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, centerVertically, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                            int $changed$iv$iv = (390 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifierM622paddingVpY3zN4$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                            if (!($composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer5.startReusableNode();
                                            if ($composer5.getInserting()) {
                                                function4 = constructor;
                                                $composer5.createNode(function4);
                                            } else {
                                                function4 = constructor;
                                                $composer5.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                            int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                            int i3 = ((390 >> 6) & 112) | 6;
                                            RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -1234800304, "C579@24356L30,580@24434L11,578@24309L307,588@24768L62,586@24638L389:FormatPage.kt#y3famj");
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.audio, $composer5, 0);
                                            long secondary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getSecondary();
                                            Modifier materialized$iv$iv2 = RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null);
                                            FormatItemKt.m7167FormatSubtitleFNF3uiM(PaddingKt.m622paddingVpY3zN4$default(materialized$iv$iv2, 0.0f, Dp.m6553constructorimpl(4), 1, null), strStringResource, secondary, $composer5, 0, 0);
                                            FormatPageKt.ClickableTextAction(FormatPageKt.FormatPageImpl$lambda$24(mutableIntState9) < list5.size(), StringResources_androidKt.stringResource(R.string.show_all_items, new Object[]{Integer.valueOf(list5.size())}, $composer5, 64), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$10$1$1
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
                                                    hapticFeedback4.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
                                                    mutableIntState9.setIntValue(Integer.MAX_VALUE);
                                                }
                                            }, $composer5, 0, 4);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            $composer5.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 5, null);
                            }
                            final List<Format> listSubList = list.subList(0, Math.min(FormatPageKt.FormatPageImpl$lambda$24(mutableIntState3), list.size()));
                            final SnapshotStateList<Integer> snapshotStateList5 = snapshotStateList2;
                            final double d3 = d;
                            final boolean z14 = z11;
                            final HapticFeedback hapticFeedback4 = hapticFeedback2;
                            final Context context3 = context2;
                            final MutableState<Boolean> mutableState15 = mutableState8;
                            final MutableIntState mutableIntState9 = mutableIntState2;
                            LazyVerticalGrid.items(listSubList.size(), null, null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$invoke$$inlined$itemsIndexed$default$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                public final Object invoke(int index) {
                                    listSubList.get(index);
                                    return null;
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(1229287273, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$invoke$$inlined$itemsIndexed$default$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyGridItemScope $this$items, final int it5, Composer $composer5, int $changed3) {
                                    ComposerKt.sourceInformation($composer5, "C494@21216L26:LazyGridDsl.kt#7791vq");
                                    int $dirty7 = $changed3;
                                    if (($changed3 & 6) == 0) {
                                        $dirty7 |= $composer5.changed($this$items) ? 4 : 2;
                                    }
                                    if (($changed3 & 48) == 0) {
                                        $dirty7 |= $composer5.changed(it5) ? 32 : 16;
                                    }
                                    if (($dirty7 & 147) == 146 && $composer5.getSkipping()) {
                                        $composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1229287273, $dirty7, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:494)");
                                    }
                                    int $changed4 = ($dirty7 & 14) | ($dirty7 & 112);
                                    final Format formatInfo = (Format) listSubList.get(it5);
                                    $composer5.startReplaceGroup(-1658160612);
                                    ComposerKt.sourceInformation($composer5, "CP(1)*608@25536L11,609@25617L11,611@25719L518,604@25314L923:FormatPage.kt#y3famj");
                                    boolean zContains = snapshotStateList5.contains(Integer.valueOf(it5));
                                    long secondaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getSecondaryContainer();
                                    long secondary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getSecondary();
                                    double d4 = d3;
                                    final HapticFeedback hapticFeedback5 = hapticFeedback4;
                                    final Context context4 = context3;
                                    Function0<Unit> function4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$11$1
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
                                            FormatPageKt.FormatPageImpl$share(formatInfo.getUrl(), hapticFeedback5, context4);
                                        }
                                    };
                                    $composer5.startReplaceGroup(-1658160207);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                    boolean invalid$iv2 = (((($changed4 & 112) ^ 48) > 32 && $composer5.changed(it5)) || ($changed4 & 48) == 32) | $composer5.changed(z14);
                                    Object value$iv24 = $composer5.rememberedValue();
                                    if (invalid$iv2 || value$iv24 == Composer.INSTANCE.getEmpty()) {
                                        final SnapshotStateList snapshotStateList6 = snapshotStateList5;
                                        final boolean z15 = z14;
                                        final MutableState mutableState16 = mutableState15;
                                        final MutableIntState mutableIntState10 = mutableIntState9;
                                        value$iv24 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$11$2$1
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
                                                if (snapshotStateList6.contains(Integer.valueOf(it5))) {
                                                    snapshotStateList6.remove(Integer.valueOf(it5));
                                                    return;
                                                }
                                                if (!z15) {
                                                    snapshotStateList6.clear();
                                                }
                                                FormatPageKt.FormatPageImpl$lambda$31(mutableState16, false);
                                                snapshotStateList6.add(Integer.valueOf(it5));
                                                mutableIntState10.setIntValue(-1);
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv24);
                                    }
                                    $composer5.endReplaceGroup();
                                    FormatItemKt.m7165FormatItembogVsAg(null, formatInfo, d4, zContains, secondary, secondaryContainer, function4, (Function0) value$iv24, $composer5, ($changed4 >> 3) & 112, 1);
                                    $composer5.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }));
                            if (!z8) {
                                if (!list2.isEmpty()) {
                                    AnonymousClass12 anonymousClass12 = new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.12
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                            return GridItemSpan.m734boximpl(m7258invokeBHJflc(lazyGridItemSpanScope));
                                        }

                                        /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                        public final long m7258invokeBHJflc(LazyGridItemSpanScope item) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                        }
                                    };
                                    final List<Format> list5 = list2;
                                    final MutableIntState mutableIntState10 = mutableIntState4;
                                    final HapticFeedback hapticFeedback5 = hapticFeedback2;
                                    LazyGridScope.CC.item$default(LazyVerticalGrid, null, anonymousClass12, null, ComposableLambdaKt.composableLambdaInstance(-545388777, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.13
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                                            invoke(lazyGridItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyGridItemScope item, Composer $composer5, int $changed3) {
                                            Function0<ComposeUiNode> function4;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C628@26400L1142:FormatPage.kt#y3famj");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-545388777, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:628)");
                                                }
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(16), 0.0f, 0.0f, 13, null), Dp.m6553constructorimpl(12), 0.0f, 2, null);
                                                List<Format> list6 = list5;
                                                final MutableIntState mutableIntState11 = mutableIntState10;
                                                final HapticFeedback hapticFeedback6 = hapticFeedback5;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, centerVertically, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                                int $changed$iv$iv = (390 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifierM622paddingVpY3zN4$default);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer5.startReusableNode();
                                                if ($composer5.getInserting()) {
                                                    function4 = constructor;
                                                    $composer5.createNode(function4);
                                                } else {
                                                    function4 = constructor;
                                                    $composer5.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                                int i3 = ((390 >> 6) & 112) | 6;
                                                RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1234797961, "C634@26703L35,635@26790L11,633@26652L335,643@27151L156,641@27013L507:FormatPage.kt#y3famj");
                                                String strStringResource = StringResources_androidKt.stringResource(R.string.video_only, $composer5, 0);
                                                long tertiary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getTertiary();
                                                Modifier materialized$iv$iv2 = RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                FormatItemKt.m7167FormatSubtitleFNF3uiM(PaddingKt.m622paddingVpY3zN4$default(materialized$iv$iv2, 0.0f, Dp.m6553constructorimpl(4), 1, null), strStringResource, tertiary, $composer5, 0, 0);
                                                FormatPageKt.ClickableTextAction(FormatPageKt.FormatPageImpl$lambda$21(mutableIntState11) < list6.size(), StringResources_androidKt.stringResource(R.string.show_all_items, new Object[]{Integer.valueOf(list6.size())}, $composer5, 64), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$13$1$1
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
                                                        hapticFeedback6.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
                                                        mutableIntState11.setIntValue(Integer.MAX_VALUE);
                                                    }
                                                }, $composer5, 0, 4);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                $composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 5, null);
                                }
                                final List<Format> listSubList2 = list2.subList(0, Math.min(FormatPageKt.FormatPageImpl$lambda$21(mutableIntState4), list2.size()));
                                final double d4 = d;
                                final MutableIntState mutableIntState11 = mutableIntState2;
                                final HapticFeedback hapticFeedback6 = hapticFeedback2;
                                final Context context4 = context2;
                                final MutableIntState mutableIntState12 = mutableIntState;
                                final MutableState<Boolean> mutableState16 = mutableState8;
                                LazyVerticalGrid.items(listSubList2.size(), null, null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$invoke$$inlined$itemsIndexed$default$7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        listSubList2.get(index);
                                        return null;
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(1229287273, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$invoke$$inlined$itemsIndexed$default$8
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyGridItemScope $this$items, final int it5, Composer $composer5, int $changed3) {
                                        Object value$iv24;
                                        ComposerKt.sourceInformation($composer5, "C494@21216L26:LazyGridDsl.kt#7791vq");
                                        int $dirty7 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty7 |= $composer5.changed($this$items) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty7 |= $composer5.changed(it5) ? 32 : 16;
                                        }
                                        if (($dirty7 & 147) == 146 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1229287273, $dirty7, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:494)");
                                        }
                                        int $changed4 = ($dirty7 & 14) | ($dirty7 & 112);
                                        final Format formatInfo = (Format) listSubList2.get(it5);
                                        $composer5.startReplaceGroup(-1658158108);
                                        ComposerKt.sourceInformation($composer5, "CP(1)*663@28048L11,664@28132L11,667@28272L365,659@27818L819:FormatPage.kt#y3famj");
                                        boolean z15 = FormatPageKt.FormatPageImpl$lambda$36(mutableIntState11) == it5;
                                        long tertiaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getTertiaryContainer();
                                        long tertiary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getTertiary();
                                        double d5 = d4;
                                        final HapticFeedback hapticFeedback7 = hapticFeedback6;
                                        final Context context5 = context4;
                                        Function0<Unit> function4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$14$1
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
                                                FormatPageKt.FormatPageImpl$share(formatInfo.getUrl(), hapticFeedback7, context5);
                                            }
                                        };
                                        $composer5.startReplaceGroup(-1658157654);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                        boolean invalid$iv2 = ((($changed4 & 112) ^ 48) > 32 && $composer5.changed(it5)) || ($changed4 & 48) == 32;
                                        Object it$iv18 = $composer5.rememberedValue();
                                        if (invalid$iv2 || it$iv18 == Composer.INSTANCE.getEmpty()) {
                                            final MutableIntState mutableIntState13 = mutableIntState11;
                                            final MutableIntState mutableIntState14 = mutableIntState12;
                                            final MutableState mutableState17 = mutableState16;
                                            value$iv24 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$14$2$1
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
                                                    MutableIntState mutableIntState15 = mutableIntState13;
                                                    int i2 = -1;
                                                    if (FormatPageKt.FormatPageImpl$lambda$36(mutableIntState13) != it5) {
                                                        mutableIntState14.setIntValue(-1);
                                                        FormatPageKt.FormatPageImpl$lambda$31(mutableState17, false);
                                                        i2 = it5;
                                                    }
                                                    mutableIntState15.setIntValue(i2);
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv24);
                                        } else {
                                            value$iv24 = it$iv18;
                                        }
                                        $composer5.endReplaceGroup();
                                        FormatItemKt.m7165FormatItembogVsAg(null, formatInfo, d5, z15, tertiary, tertiaryContainer, function4, (Function0) value$iv24, $composer5, ($changed4 >> 3) & 112, 1);
                                        $composer5.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                            if (!list3.isEmpty()) {
                                AnonymousClass15 anonymousClass15 = new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.15
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                        return GridItemSpan.m734boximpl(m7259invokeBHJflc(lazyGridItemSpanScope));
                                    }

                                    /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                    public final long m7259invokeBHJflc(LazyGridItemSpanScope item) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                    }
                                };
                                final List<Format> list6 = list3;
                                final MutableIntState mutableIntState13 = mutableIntState5;
                                final HapticFeedback hapticFeedback7 = hapticFeedback2;
                                LazyGridScope.CC.item$default(LazyVerticalGrid, null, anonymousClass15, null, ComposableLambdaKt.composableLambdaInstance(453564657, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.16
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                                        invoke(lazyGridItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyGridItemScope item, Composer $composer5, int $changed3) {
                                        Function0<ComposeUiNode> function4;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C679@28801L1068:FormatPage.kt#y3famj");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(453564657, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:679)");
                                            }
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(16), 0.0f, 0.0f, 13, null), Dp.m6553constructorimpl(12), 0.0f, 2, null);
                                            List<Format> list7 = list6;
                                            final MutableIntState mutableIntState14 = mutableIntState13;
                                            final HapticFeedback hapticFeedback8 = hapticFeedback7;
                                            ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, centerVertically, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                            int $changed$iv$iv = (390 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifierM622paddingVpY3zN4$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                            if (!($composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer5.startReusableNode();
                                            if ($composer5.getInserting()) {
                                                function4 = constructor;
                                                $composer5.createNode(function4);
                                            } else {
                                                function4 = constructor;
                                                $composer5.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                            int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                            int i3 = ((390 >> 6) & 112) | 6;
                                            RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -1234795560, "C685@29104L30,684@29053L258,692@29476L157,690@29336L511:FormatPage.kt#y3famj");
                                            FormatItemKt.m7167FormatSubtitleFNF3uiM(PaddingKt.m622paddingVpY3zN4$default(RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, Dp.m6553constructorimpl(4), 1, null), StringResources_androidKt.stringResource(R.string.video, $composer5, 0), 0L, $composer5, 0, 4);
                                            FormatPageKt.ClickableTextAction(FormatPageKt.FormatPageImpl$lambda$27(mutableIntState14) < list7.size(), StringResources_androidKt.stringResource(R.string.show_all_items, new Object[]{Integer.valueOf(list7.size())}, $composer5, 64), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$16$1$1
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
                                                    hapticFeedback8.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
                                                    mutableIntState14.setIntValue(Integer.MAX_VALUE);
                                                }
                                            }, $composer5, 0, 4);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            $composer5.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 5, null);
                                final List<Format> listSubList3 = list3.subList(0, Math.min(FormatPageKt.FormatPageImpl$lambda$27(mutableIntState5), list3.size()));
                                final double d5 = d;
                                final MutableIntState mutableIntState14 = mutableIntState;
                                final HapticFeedback hapticFeedback8 = hapticFeedback2;
                                final Context context5 = context2;
                                final SnapshotStateList<Integer> snapshotStateList6 = snapshotStateList2;
                                final MutableIntState mutableIntState15 = mutableIntState2;
                                final MutableState<Boolean> mutableState17 = mutableState8;
                                LazyVerticalGrid.items(listSubList3.size(), null, null, new Function1<Integer, Object>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$invoke$$inlined$itemsIndexed$default$11
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int index) {
                                        listSubList3.get(index);
                                        return null;
                                    }
                                }, ComposableLambdaKt.composableLambdaInstance(1229287273, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$invoke$$inlined$itemsIndexed$default$12
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyGridItemScope $this$items, final int it5, Composer $composer5, int $changed3) {
                                        ComposerKt.sourceInformation($composer5, "C494@21216L26:LazyGridDsl.kt#7791vq");
                                        int $dirty7 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty7 |= $composer5.changed($this$items) ? 4 : 2;
                                        }
                                        if (($changed3 & 48) == 0) {
                                            $dirty7 |= $composer5.changed(it5) ? 32 : 16;
                                        }
                                        if (($dirty7 & 147) == 146 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1229287273, $dirty7, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:494)");
                                        }
                                        int $changed4 = ($dirty7 & 14) | ($dirty7 & 112);
                                        final Format formatInfo = (Format) listSubList3.get(it5);
                                        $composer5.startReplaceGroup(-1658155777);
                                        ComposerKt.sourceInformation($composer5, "CP(1)*713@30391L431,709@30149L673:FormatPage.kt#y3famj");
                                        double d6 = d5;
                                        boolean z15 = FormatPageKt.FormatPageImpl$lambda$33(mutableIntState14) == it5;
                                        final HapticFeedback hapticFeedback9 = hapticFeedback8;
                                        final Context context6 = context5;
                                        Function0<Unit> function4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$17$1
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
                                                FormatPageKt.FormatPageImpl$share(formatInfo.getUrl(), hapticFeedback9, context6);
                                            }
                                        };
                                        $composer5.startReplaceGroup(-1658155535);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                        boolean invalid$iv2 = ((($changed4 & 112) ^ 48) > 32 && $composer5.changed(it5)) || ($changed4 & 48) == 32;
                                        Object value$iv24 = $composer5.rememberedValue();
                                        if (invalid$iv2 || value$iv24 == Composer.INSTANCE.getEmpty()) {
                                            final SnapshotStateList snapshotStateList7 = snapshotStateList6;
                                            final MutableIntState mutableIntState16 = mutableIntState14;
                                            final MutableIntState mutableIntState17 = mutableIntState15;
                                            final MutableState mutableState18 = mutableState17;
                                            value$iv24 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$17$2$1
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
                                                    MutableIntState mutableIntState18 = mutableIntState16;
                                                    int i2 = -1;
                                                    if (FormatPageKt.FormatPageImpl$lambda$33(mutableIntState16) != it5) {
                                                        snapshotStateList7.clear();
                                                        mutableIntState17.setIntValue(-1);
                                                        FormatPageKt.FormatPageImpl$lambda$31(mutableState18, false);
                                                        i2 = it5;
                                                    }
                                                    mutableIntState18.setIntValue(i2);
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv24);
                                        }
                                        $composer5.endReplaceGroup();
                                        FormatItemKt.m7165FormatItembogVsAg(null, formatInfo, d6, z15, 0L, 0L, function4, (Function0) value$iv24, $composer5, ($changed4 >> 3) & 112, 49);
                                        $composer5.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                            }
                            if (!z8 && (!list.isEmpty()) && (!list2.isEmpty())) {
                                LazyGridScope.CC.item$default(LazyVerticalGrid, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.6.1.18
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                        return GridItemSpan.m734boximpl(m7260invokeBHJflc(lazyGridItemSpanScope));
                                    }

                                    /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                    public final long m7260invokeBHJflc(LazyGridItemSpanScope item) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
                                    }
                                }, null, ComposableSingletons$FormatPageKt.INSTANCE.m7234getLambda5$app_debug(), 5, null);
                            }
                            LazyGridScope.CC.item$default(LazyVerticalGrid, null, null, null, ComposableSingletons$FormatPageKt.INSTANCE.m7235getLambda6$app_debug(), 7, null);
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3, reason: invalid class name */
                        /* JADX INFO: compiled from: FormatPage.kt */
                        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        static final class AnonymousClass3 extends Lambda implements Function3<LazyGridItemScope, Composer, Integer, Unit> {
                            final /* synthetic */ MutableState<Boolean> $isClippingVideo$delegate;
                            final /* synthetic */ MutableState<Boolean> $isSplittingVideo$delegate;
                            final /* synthetic */ MutableState<Boolean> $showVideoClipDialog$delegate;
                            final /* synthetic */ MutableState<ClosedFloatingPointRange<Float>> $videoClipDuration$delegate;
                            final /* synthetic */ ClosedFloatingPointRange<Float> $videoDurationRange;
                            final /* synthetic */ VideoInfo $videoInfo;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass3(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, ClosedFloatingPointRange<Float> closedFloatingPointRange, MutableState<ClosedFloatingPointRange<Float>> mutableState3, MutableState<Boolean> mutableState4, VideoInfo videoInfo) {
                                super(3);
                                this.$isClippingVideo$delegate = mutableState;
                                this.$showVideoClipDialog$delegate = mutableState2;
                                this.$videoDurationRange = closedFloatingPointRange;
                                this.$videoClipDuration$delegate = mutableState3;
                                this.$isSplittingVideo$delegate = mutableState4;
                                this.$videoInfo = videoInfo;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                                invoke(lazyGridItemScope, composer, num.intValue());
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

                            public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
                                Object value$iv;
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                ComposerKt.sourceInformation($composer, "C431@17384L34,433@17436L2872:FormatPage.kt#y3famj");
                                if (($changed & 81) == 16 && $composer.getSkipping()) {
                                    $composer.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1199533734, $changed, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:431)");
                                }
                                $composer.startReplaceGroup(-1658168542);
                                ComposerKt.sourceInformation($composer, "CC(remember):FormatPage.kt#9igjgp");
                                Object it$iv = $composer.rememberedValue();
                                if (it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                    $composer.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = it$iv;
                                }
                                final MutableState shouldUpdateClipDuration$delegate = (MutableState) value$iv;
                                $composer.endReplaceGroup();
                                final MutableState<Boolean> mutableState = this.$isClippingVideo$delegate;
                                final MutableState<Boolean> mutableState2 = this.$showVideoClipDialog$delegate;
                                final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$videoDurationRange;
                                final MutableState<ClosedFloatingPointRange<Float>> mutableState3 = this.$videoClipDuration$delegate;
                                final MutableState<Boolean> mutableState4 = this.$isSplittingVideo$delegate;
                                final VideoInfo videoInfo = this.$videoInfo;
                                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Modifier modifier$iv = Modifier.INSTANCE;
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv = (0 << 3) & 112;
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
                                    $composer.createNode(constructor);
                                } else {
                                    $composer.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                }
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                int i = ($changed$iv$iv$iv >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                int $changed2 = ((0 >> 6) & 112) | 6;
                                ColumnScope $this$invoke_u24lambda_u243 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, -1234807148, "C434@17511L1437,434@17465L1483,463@19017L1273,463@18970L1320:FormatPage.kt#y3famj");
                                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u243, FormatPageKt.FormatPageImpl$lambda$42(mutableState), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-467158888, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                        invoke(animatedVisibilityScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer2, int $changed3) {
                                        Object value$iv2;
                                        Object value$iv3;
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation($composer2, "C435@17537L1389:FormatPage.kt#y3famj");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-467158888, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:435)");
                                        }
                                        final MutableState<Boolean> mutableState5 = mutableState;
                                        final MutableState<Boolean> mutableState6 = mutableState2;
                                        ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                                        final MutableState<ClosedFloatingPointRange<Float>> mutableState7 = mutableState3;
                                        final MutableState<Boolean> mutableState8 = shouldUpdateClipDuration$delegate;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        Modifier modifier$iv2 = Modifier.INSTANCE;
                                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv2 = (0 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                                        CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer2.startReusableNode();
                                        if ($composer2.getInserting()) {
                                            $composer2.createNode(constructor2);
                                        } else {
                                            $composer2.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                        }
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        int i3 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer2, 1130008771, "C436@17586L568,446@18183L318,457@18791L30,456@18712L27,453@18531L321,459@18881L19:FormatPage.kt#y3famj");
                                        boolean zFormatPageImpl$lambda$42 = FormatPageKt.FormatPageImpl$lambda$42(mutableState5);
                                        boolean zFormatPageImpl$lambda$48 = FormatPageKt.FormatPageImpl$lambda$48(mutableState6);
                                        $composer2.startReplaceGroup(1130008783);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
                                        boolean invalid$iv = $composer2.changed(zFormatPageImpl$lambda$42) | $composer2.changed(zFormatPageImpl$lambda$48);
                                        Object value$iv4 = $composer2.rememberedValue();
                                        if (invalid$iv || value$iv4 == Composer.INSTANCE.getEmpty()) {
                                            value$iv4 = new RangeSliderState(((Number) FormatPageKt.FormatPageImpl$lambda$57(mutableState7).getStart()).floatValue(), ((Number) FormatPageKt.FormatPageImpl$lambda$57(mutableState7).getEndInclusive()).floatValue(), 0, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$1$1$state$1$1
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
                                                    FormatPageKt.C09226.AnonymousClass1.AnonymousClass3.invoke$lambda$2(mutableState8, true);
                                                }
                                            }, closedFloatingPointRange2, 4, null);
                                            $composer2.updateRememberedValue(value$iv4);
                                        }
                                        final RangeSliderState state = (RangeSliderState) value$iv4;
                                        r27.endReplaceGroup();
                                        EffectsKt.DisposableEffect(Boolean.valueOf(FormatPageKt.C09226.AnonymousClass1.AnonymousClass3.invoke$lambda$1(mutableState8)), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                                mutableState7.setValue(RangesKt.rangeTo(state.getActiveRangeStart(), state.getActiveRangeEnd()));
                                                final MutableState<Boolean> mutableState9 = mutableState8;
                                                return new DisposableEffectResult() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$1$1$1$invoke$$inlined$onDispose$1
                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                    public void dispose() {
                                                        FormatPageKt.C09226.AnonymousClass1.AnonymousClass3.invoke$lambda$2(mutableState9, false);
                                                    }
                                                };
                                            }
                                        }, $composer2, 0);
                                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        $composer2.startReplaceGroup(1130009988);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$1$1$2$1
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
                                                    FormatPageKt.FormatPageImpl$lambda$49(mutableState6, true);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        Function0 function0 = (Function0) value$iv2;
                                        $composer2.endReplaceGroup();
                                        $composer2.startReplaceGroup(1130009909);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$1$1$3$1
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
                                                    FormatPageKt.FormatPageImpl$lambda$43(mutableState5, false);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        VideoSectionSliderKt.VideoSelectionSlider(modifierFillMaxWidth$default, state, function0, (Function0) value$iv3, $composer2, (RangeSliderState.$stable << 3) | 3462, 0);
                                        DividerKt.m7164HorizontalDivideriJQMabo(null, 0L, $composer2, 0, 3);
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
                                }, $composer, 54), $composer, ($changed2 & 14) | 1572864, 30);
                                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u243, FormatPageKt.FormatPageImpl$lambda$45(mutableState4), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1174412415, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                        invoke(animatedVisibilityScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer2, int $changed3) {
                                        Function0<ComposeUiNode> function0;
                                        Function0<ComposeUiNode> function1;
                                        Object value$iv2;
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation($composer2, "C464@19043L1225:FormatPage.kt#y3famj");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1174412415, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.FormatPageImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:464)");
                                        }
                                        VideoInfo videoInfo2 = videoInfo;
                                        final MutableState<Boolean> mutableState5 = mutableState4;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        Modifier modifier$iv2 = Modifier.INSTANCE;
                                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv2 = (0 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                                        CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer2.startReusableNode();
                                        if ($composer2.getInserting()) {
                                            function0 = constructor2;
                                            $composer2.createNode(function0);
                                        } else {
                                            function0 = constructor2;
                                            $composer2.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                        }
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        int i3 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer2, 1130010277, "C465@19080L1114,484@20223L19:FormatPage.kt#y3famj");
                                        Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                        ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                        int $changed$iv$iv3 = (390 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                                        CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer2.startReusableNode();
                                        if ($composer2.getInserting()) {
                                            function1 = constructor3;
                                            $composer2.createNode(function1);
                                        } else {
                                            function1 = constructor3;
                                            $composer2.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer2);
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                        }
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i4 = ($changed$iv$iv$iv3 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                        int i5 = ((390 >> 6) & 112) | 6;
                                        RowScope $this$invoke_u24lambda_u242_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart($composer2, -1340647906, "C470@19345L154,473@19559L10,469@19296L404,476@19733L38,480@20009L37,481@20113L11,478@19870L28,477@19804L360:FormatPage.kt#y3famj");
                                        int i6 = R.string.split_video_msg;
                                        List<Chapter> chapters = videoInfo2.getChapters();
                                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(i6, new Object[]{Integer.valueOf(chapters != null ? chapters.size() : 0)}, $composer2, 64), PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelMedium(), $composer2, 48, 0, 65532);
                                        SpacerKt.Spacer(RowScope.CC.weight$default($this$invoke_u24lambda_u242_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null), $composer2, 0);
                                        ImageVector delete = DeleteKt.getDelete(Icons.Outlined.INSTANCE);
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.discard, $composer2, 0);
                                        long error = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getError();
                                        $composer2.startReplaceGroup(-1340647332);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
                                        Object it$iv2 = $composer2.rememberedValue();
                                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$6$1$3$1$2$1$1$1$1
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
                                                    FormatPageKt.FormatPageImpl$lambda$46(mutableState5, false);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer2.endReplaceGroup();
                                        ButtonsKt.m7104TextButtonWithIconuDo3WH8(null, delete, strStringResource, error, (Function0) value$iv2, $composer2, CpioConstants.C_ISBLK, 1);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        $composer2.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        DividerKt.m7164HorizontalDivideriJQMabo(null, 0L, $composer2, 0, 3);
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
                                }, $composer, 54), $composer, ($changed2 & 14) | 1572864, 30);
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
                        }
                    }, $composer4, 1772544, HttpStatusCodesKt.HTTP_NOT_FOUND);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer4.skipToGroupEnd();
            }
        }, $composer3, 54), $composer3, 805306416, 508);
        $composer3.startReplaceGroup(-344709234);
        ComposerKt.sourceInformation($composer3, "741@31475L31,744@31611L26,741@31440L198");
        if (FormatPageImpl$lambda$48(showVideoClipDialog$delegate)) {
            $composer3.startReplaceGroup(-344709174);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
            Object it$iv18 = $composer3.rememberedValue();
            if (it$iv18 == Composer.INSTANCE.getEmpty()) {
                value$iv22 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$7$1
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
                        FormatPageKt.FormatPageImpl$lambda$49(showVideoClipDialog$delegate, false);
                    }
                };
                $composer3.updateRememberedValue(value$iv22);
            } else {
                value$iv22 = it$iv18;
            }
            Function0 function4 = (Function0) value$iv22;
            $composer3.endReplaceGroup();
            ClosedFloatingPointRange<Float> closedFloatingPointRangeFormatPageImpl$lambda$57 = FormatPageImpl$lambda$57(videoClipDuration$delegate);
            $composer3.startReplaceGroup(-344709038);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
            Object it$iv19 = $composer3.rememberedValue();
            if (it$iv19 == Composer.INSTANCE.getEmpty()) {
                value$iv23 = (Function1) new Function1<ClosedFloatingPointRange<Float>, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$8$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
                        invoke2(closedFloatingPointRange);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ClosedFloatingPointRange<Float> it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        videoClipDuration$delegate.setValue(it5);
                    }
                };
                $composer3.updateRememberedValue(value$iv23);
            } else {
                value$iv23 = it$iv19;
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            showSubtitleSelectionDialog$delegate = showSubtitleSelectionDialog$delegate2;
            VideoSectionSliderKt.VideoClipDialog(function4, closedFloatingPointRangeFormatPageImpl$lambda$57, closedFloatingPointRangeRangeTo, (Function1) value$iv23, $composer2, 3078);
        } else {
            $composer2 = $composer3;
            showSubtitleSelectionDialog$delegate = showSubtitleSelectionDialog$delegate2;
        }
        $composer2.endReplaceGroup();
        $composer2.startReplaceGroup(-344709005);
        ComposerKt.sourceInformation($composer2, "747@31761L28,747@31791L31,746@31666L156");
        if (FormatPageImpl$lambda$51(showRenameDialog$delegate)) {
            String strFormatPageImpl$lambda$60 = FormatPageImpl$lambda$60(videoTitle$delegate);
            if (strFormatPageImpl$lambda$60.length() == 0) {
                strFormatPageImpl$lambda$60 = videoInfo2.getTitle();
            }
            String str = strFormatPageImpl$lambda$60;
            $composer2.startReplaceGroup(-344708888);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
            Composer $this$cache$iv = $composer2;
            Object it$iv20 = $this$cache$iv.rememberedValue();
            if (it$iv20 == Composer.INSTANCE.getEmpty()) {
                value$iv20 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$10$1
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
                        FormatPageKt.FormatPageImpl$lambda$52(showRenameDialog$delegate, false);
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv20);
            } else {
                value$iv20 = it$iv20;
            }
            Function0 function9 = (Function0) value$iv20;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-344708858);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
            Composer $this$cache$iv2 = $composer2;
            Object it$iv21 = $this$cache$iv2.rememberedValue();
            if (it$iv21 == Composer.INSTANCE.getEmpty()) {
                value$iv21 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$11$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        videoTitle$delegate.setValue(it5);
                    }
                };
                $this$cache$iv2.updateRememberedValue(value$iv21);
            } else {
                value$iv21 = it$iv21;
            }
            $composer2.endReplaceGroup();
            RenameDialog(str, function9, (Function1) value$iv21, $composer2, 432);
        }
        $composer2.endReplaceGroup();
        if (FormatPageImpl$lambda$54(showSubtitleSelectionDialog$delegate)) {
            SnapshotStateList snapshotStateList = selectedLanguageList;
            $composer2.startReplaceGroup(-344708591);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
            Composer $this$cache$iv3 = $composer2;
            Object it$iv22 = $this$cache$iv3.rememberedValue();
            if (it$iv22 == Composer.INSTANCE.getEmpty()) {
                value$iv18 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$12$1
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
                        FormatPageKt.FormatPageImpl$lambda$55(showSubtitleSelectionDialog$delegate, false);
                    }
                };
                $this$cache$iv3.updateRememberedValue(value$iv18);
            } else {
                value$iv18 = it$iv22;
            }
            Function0 function10 = (Function0) value$iv18;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-344708530);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
            Composer $this$cache$iv4 = $composer2;
            Object it$iv23 = $this$cache$iv4.rememberedValue();
            if (it$iv23 == Composer.INSTANCE.getEmpty()) {
                value$iv19 = new Function1<List<? extends String>, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$13$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                        invoke2((List<String>) list);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<String> it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        SnapshotStateList<String> snapshotStateList2 = selectedLanguageList;
                        snapshotStateList2.clear();
                        snapshotStateList2.addAll(it5);
                        FormatPageKt.FormatPageImpl$lambda$55(showSubtitleSelectionDialog$delegate, false);
                    }
                };
                $this$cache$iv4.updateRememberedValue(value$iv19);
            } else {
                value$iv19 = it$iv23;
            }
            $composer2.endReplaceGroup();
            SubtitleSelectionDialog(map, otherSubtitleMap, snapshotStateList, function10, (Function1) value$iv19, $composer2, 28104, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            final VideoInfo videoInfo6 = videoInfo2;
            final boolean z7 = audioOnly2;
            final boolean z8 = mergeAudioStream2;
            final boolean z9 = isClippingAvailable2;
            final Function0<Unit> function11 = function1;
            final Function5<? super List<Format>, ? super List<VideoClip>, ? super Boolean, ? super String, ? super List<String>, Unit> function12 = function6;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.FormatPageImpl.14
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
                    FormatPageKt.FormatPageImpl(videoInfo6, z7, z8, z9, selectedSubtitleCodes, function11, function12, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FormatPageImpl$lambda$21(MutableIntState $videoOnlyItemLimit$delegate) {
        MutableIntState $this$getValue$iv = $videoOnlyItemLimit$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FormatPageImpl$lambda$24(MutableIntState $audioOnlyItemLimit$delegate) {
        MutableIntState $this$getValue$iv = $audioOnlyItemLimit$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FormatPageImpl$lambda$27(MutableIntState $videoAudioItemLimit$delegate) {
        MutableIntState $this$getValue$iv = $videoAudioItemLimit$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FormatPageImpl$lambda$30(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPageImpl$lambda$31(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FormatPageImpl$lambda$33(MutableIntState $selectedVideoAudioFormat$delegate) {
        MutableIntState $this$getValue$iv = $selectedVideoAudioFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FormatPageImpl$lambda$36(MutableIntState $selectedVideoOnlyFormat$delegate) {
        MutableIntState $this$getValue$iv = $selectedVideoOnlyFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FormatPageImpl$share(String $this$FormatPageImpl_u24share, HapticFeedback hapticFeedback, Context context) {
        if ($this$FormatPageImpl_u24share == null) {
            return null;
        }
        hapticFeedback.mo4784performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4792getLongPress5zf0vsI());
        Intent $this$FormatPageImpl_u24share_u24lambda_u2440_u24lambda_u2439 = new Intent();
        $this$FormatPageImpl_u24share_u24lambda_u2440_u24lambda_u2439.setAction("android.intent.action.SEND");
        $this$FormatPageImpl_u24share_u24lambda_u2440_u24lambda_u2439.setType("text/plain");
        $this$FormatPageImpl_u24share_u24lambda_u2440_u24lambda_u2439.putExtra("android.intent.extra.TEXT", $this$FormatPageImpl_u24share);
        context.startActivity(Intent.createChooser($this$FormatPageImpl_u24share_u24lambda_u2440_u24lambda_u2439, null), null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FormatPageImpl$lambda$42(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPageImpl$lambda$43(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FormatPageImpl$lambda$45(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPageImpl$lambda$46(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FormatPageImpl$lambda$48(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPageImpl$lambda$49(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean FormatPageImpl$lambda$51(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPageImpl$lambda$52(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean FormatPageImpl$lambda$54(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatPageImpl$lambda$55(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> FormatPageImpl$lambda$57(MutableState<ClosedFloatingPointRange<Float>> mutableState) {
        MutableState<ClosedFloatingPointRange<Float>> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String FormatPageImpl$lambda$60(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Format> FormatPageImpl$lambda$66(State<? extends List<Format>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RenameDialog(final String initialValue, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1141068701);
        ComposerKt.sourceInformation($composer3, "C(RenameDialog)P(!1,2)772@32447L41,773@32557L104,778@32679L52,784@32916L372,773@32493L796:FormatPage.kt#y3famj");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(initialValue) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1141068701, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.RenameDialog (FormatPage.kt:771)");
            }
            $composer3.startReplaceGroup(1309520662);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialValue, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState filename$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, function0, ComposableLambdaKt.rememberComposableLambda(-1416735704, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.RenameDialog.1
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
                    ComposerKt.sourceInformation($composer4, "C774@32581L74,774@32567L88:FormatPage.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1416735704, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.RenameDialog.<anonymous> (FormatPage.kt:774)");
                    }
                    $composer4.startReplaceGroup(123595581);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatPage.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function1) | $composer4.changed(function0);
                    final Function1<String, Unit> function2 = function1;
                    final Function0<Unit> function3 = function0;
                    final MutableState<String> mutableState = filename$delegate;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$RenameDialog$1$1$1
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
                                function2.invoke(FormatPageKt.RenameDialog$lambda$77(mutableState));
                                function3.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv2, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(1068328007, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.RenameDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C779@32703L22,779@32689L36:FormatPage.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1068328007, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.RenameDialog.<anonymous> (FormatPage.kt:779)");
                    }
                    $composer4.startReplaceGroup(123595703);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatPage.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function0);
                    final Function0<Unit> function2 = function0;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$RenameDialog$2$1$1
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
                                function2.invoke();
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
            }, $composer3, 54), ComposableSingletons$FormatPageKt.INSTANCE.m7236getLambda7$app_debug(), ComposableSingletons$FormatPageKt.INSTANCE.m7237getLambda8$app_debug(), ComposableLambdaKt.rememberComposableLambda(-66415452, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.RenameDialog.3
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
                    Function0<ComposeUiNode> function2;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C785@32926L356:FormatPage.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-66415452, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.RenameDialog.<anonymous> (FormatPage.kt:785)");
                    }
                    final MutableState<String> mutableState = filename$delegate;
                    final String str = initialValue;
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
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
                        function2 = constructor;
                        $composer4.createNode(function2);
                    } else {
                        function2 = constructor;
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
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i2 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1870314188, "C788@33080L17,790@33208L63,786@32947L325:FormatPage.kt#y3famj");
                    Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(24), 0.0f, 2, null);
                    String strRenameDialog$lambda$77 = FormatPageKt.RenameDialog$lambda$77(mutableState);
                    $composer4.startReplaceGroup(1870314321);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatPage.kt#9igjgp");
                    Object it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$RenameDialog$3$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                mutableState.setValue(it);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    OutlinedTextFieldKt.OutlinedTextField(strRenameDialog$lambda$77, (Function1<? super String, Unit>) value$iv2, modifierM622paddingVpY3zN4$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FormatPageKt.INSTANCE.m7238getLambda9$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-521586409, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$RenameDialog$3$1$2
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
                            Object value$iv3;
                            ComposerKt.sourceInformation($composer5, "C790@33252L17,790@33240L29:FormatPage.kt#y3famj");
                            if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-521586409, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.RenameDialog.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:790)");
                            }
                            if (Intrinsics.areEqual(FormatPageKt.RenameDialog$lambda$77(mutableState), str)) {
                                $composer5.startReplaceGroup(-1145675618);
                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatPage.kt#9igjgp");
                                final MutableState<String> mutableState2 = mutableState;
                                Object it$iv3 = $composer5.rememberedValue();
                                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$RenameDialog$3$1$2$1$1
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
                                            mutableState2.setValue("");
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv3;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.ClearButton((Function0) value$iv3, $composer5, 6);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 806879664, 0, 0, 8388024);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.RenameDialog.4
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
                    FormatPageKt.RenameDialog(initialValue, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RenameDialog$lambda$77(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    private static final Map<String, List<SubtitleFormat>> filterWithSearchText(Map<String, ? extends List<SubtitleFormat>> map, String searchText) {
        boolean z;
        Map<String, ? extends List<SubtitleFormat>> map2 = map;
        Map destination$iv$iv = new LinkedHashMap();
        for (Map.Entry<String, ? extends List<SubtitleFormat>> entry : map2.entrySet()) {
            boolean z2 = true;
            if (StringsKt.isBlank(searchText) || StringsKt.contains((CharSequence) entry.getKey(), (CharSequence) searchText, true)) {
                map2 = map2;
            } else {
                Iterable $this$any$iv = entry.getValue();
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            SubtitleFormat format = (SubtitleFormat) element$iv;
                            String name = format.getName();
                            if (name != null ? StringsKt.contains((CharSequence) name, (CharSequence) searchText, true) : false) {
                                z = true;
                                break;
                            }
                            map2 = map2;
                        } else {
                            map2 = map2;
                            z = false;
                            break;
                        }
                    }
                } else {
                    map2 = map2;
                    z = false;
                }
                if (!z) {
                    z2 = false;
                }
            }
            if (z2) {
                destination$iv$iv.put(entry.getKey(), entry.getValue());
            }
        }
        return destination$iv$iv;
    }

    private static final Map<String, List<SubtitleFormat>> sortedWithSelection(Map<String, ? extends List<SubtitleFormat>> map, final List<String> list) {
        List list2 = MapsKt.toList(map);
        final Function2<Pair<? extends String, ? extends List<? extends SubtitleFormat>>, Pair<? extends String, ? extends List<? extends SubtitleFormat>>, Integer> function2 = new Function2<Pair<? extends String, ? extends List<? extends SubtitleFormat>>, Pair<? extends String, ? extends List<? extends SubtitleFormat>>, Integer>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.sortedWithSelection.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Pair<? extends String, ? extends List<? extends SubtitleFormat>> pair, Pair<? extends String, ? extends List<? extends SubtitleFormat>> pair2) {
                return invoke2((Pair<String, ? extends List<SubtitleFormat>>) pair, (Pair<String, ? extends List<SubtitleFormat>>) pair2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Integer invoke2(Pair<String, ? extends List<SubtitleFormat>> pair, Pair<String, ? extends List<SubtitleFormat>> pair2) {
                int iCompareTo;
                if (list.contains(pair.getFirst()) && list.contains(pair2.getFirst())) {
                    Intrinsics.checkNotNull(pair);
                    Intrinsics.checkNotNull(pair2);
                    iCompareTo = FormatPageKt.compareTo(pair, pair2);
                } else if (list.contains(pair.getFirst())) {
                    iCompareTo = -1;
                } else if (list.contains(pair2.getFirst())) {
                    iCompareTo = 1;
                } else {
                    Intrinsics.checkNotNull(pair);
                    Intrinsics.checkNotNull(pair2);
                    iCompareTo = FormatPageKt.compareTo(pair, pair2);
                }
                return Integer.valueOf(iCompareTo);
            }
        };
        return MapsKt.toMap(CollectionsKt.sortedWith(list2, new Comparator() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return FormatPageKt.sortedWithSelection$lambda$82(function2, obj, obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortedWithSelection$lambda$82(Function2 tmp0, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(p0, p1)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int compareTo(Pair<String, ? extends List<SubtitleFormat>> pair, Pair<String, ? extends List<SubtitleFormat>> pair2) {
        String key = pair.component1();
        List<SubtitleFormat> listComponent2 = pair.component2();
        String otherKey = pair2.component1();
        List<SubtitleFormat> listComponent3 = pair2.component2();
        String name = getSubtitleName(listComponent2);
        String otherName = getSubtitleName(listComponent3);
        if (name != null && otherName != null) {
            return name.compareTo(otherName);
        }
        return key.compareTo(otherKey);
    }

    private static final String getSubtitleName(List<SubtitleFormat> list) {
        SubtitleFormat subtitleFormat = (SubtitleFormat) CollectionsKt.firstOrNull((List) list);
        if (subtitleFormat != null) {
            return subtitleFormat.getName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SubtitleSelectionDialog(final Map<String, ? extends List<SubtitleFormat>> map, final Map<String, ? extends List<SubtitleFormat>> map2, final List<String> list, Function0<Unit> function0, Function1<? super List<String>, Unit> function1, Composer $composer, final int $changed, final int i) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1292342384);
        ComposerKt.sourceInformation($composer2, "C(SubtitleSelectionDialog)P(4!1,3,2)851@35355L31,853@35423L81,862@35852L98,866@35968L88,873@36247L3449,860@35771L3926:FormatPage.kt#y3famj");
        final Function0<Unit> function2 = (i & 8) != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialog.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0;
        final Function1<? super List<String>, Unit> function3 = (i & 16) != 0 ? new Function1<List<? extends String>, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialog.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list2) {
                invoke2((List<String>) list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }
        } : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1292342384, $changed, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialog (FormatPage.kt:850)");
        }
        $composer2.startReplaceGroup(901281026);
        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv = $composer2.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState searchText$delegate = (MutableState) value$iv;
        $composer2.endReplaceGroup();
        $composer2.startReplaceGroup(901281094);
        ComposerKt.sourceInformation($composer2, "CC(remember):FormatPage.kt#9igjgp");
        Object it$iv2 = $composer2.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            SnapshotStateList $this$SubtitleSelectionDialog_u24lambda_u2487_u24lambda_u2486 = SnapshotStateKt.mutableStateListOf();
            $this$SubtitleSelectionDialog_u24lambda_u2487_u24lambda_u2486.addAll(list);
            value$iv2 = $this$SubtitleSelectionDialog_u24lambda_u2487_u24lambda_u2486;
            $composer2.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final SnapshotStateList selectedSubtitles = (SnapshotStateList) value$iv2;
        $composer2.endReplaceGroup();
        final Map<String, List<SubtitleFormat>> mapSortedWithSelection = sortedWithSelection(filterWithSearchText(map, SubtitleSelectionDialog$lambda$84(searchText$delegate)), selectedSubtitles);
        final Map<String, List<SubtitleFormat>> mapSortedWithSelection2 = sortedWithSelection(filterWithSearchText(map2, SubtitleSelectionDialog$lambda$84(searchText$delegate)), selectedSubtitles);
        final Function0<Unit> function4 = function2;
        final Function1<? super List<String>, Unit> function5 = function3;
        DialogsKt.m7162LoopDialogOix01E0(null, function4, ComposableLambdaKt.rememberComposableLambda(642557547, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialog.3
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
                Object value$iv3;
                ComposerKt.sourceInformation($composer3, "C863@35880L60,863@35866L74:FormatPage.kt#y3famj");
                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(642557547, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialog.<anonymous> (FormatPage.kt:863)");
                }
                $composer3.startReplaceGroup(274421424);
                ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
                boolean invalid$iv = $composer3.changed(function3);
                final Function1<List<String>, Unit> function6 = function3;
                final SnapshotStateList<String> snapshotStateList = selectedSubtitles;
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$3$1$1
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
                            function6.invoke(snapshotStateList);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                $composer3.endReplaceGroup();
                ButtonsKt.ConfirmButton(null, false, (Function0) value$iv3, $composer3, 0, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(1608120364, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialog.4
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
                Object value$iv3;
                ComposerKt.sourceInformation($composer3, "C867@35996L50,867@35982L64:FormatPage.kt#y3famj");
                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1608120364, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialog.<anonymous> (FormatPage.kt:867)");
                }
                $composer3.startReplaceGroup(274421540);
                ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
                boolean invalid$iv = $composer3.changed(function2);
                final Function0<Unit> function6 = function2;
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$4$1$1
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
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                $composer3.endReplaceGroup();
                ButtonsKt.DismissButton(null, (Function0) value$iv3, $composer3, 0, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer2, 54), ComposableSingletons$FormatPageKt.INSTANCE.m7223getLambda10$app_debug(), ComposableSingletons$FormatPageKt.INSTANCE.m7224getLambda11$app_debug(), ComposableLambdaKt.rememberComposableLambda(209841519, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialog.5
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
                Function0<ComposeUiNode> function6;
                Object value$iv3;
                ComposerKt.sourceInformation($composer3, "C874@36261L3425:FormatPage.kt#y3famj");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(209841519, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialog.<anonymous> (FormatPage.kt:874)");
                    }
                    Map<String, List<SubtitleFormat>> map3 = map2;
                    Map<String, List<SubtitleFormat>> map4 = map;
                    final MutableState<String> mutableState = searchText$delegate;
                    final Map<String, List<SubtitleFormat>> map5 = mapSortedWithSelection;
                    final Map<String, List<SubtitleFormat>> map6 = mapSortedWithSelection2;
                    final SnapshotStateList<String> snapshotStateList = selectedSubtitles;
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
                    int $i$f$Column = $changed$iv$iv << 6;
                    int $changed$iv$iv$iv = ($i$f$Column & 896) | 6;
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
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i3 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 722390631, "C883@36656L2980,939@39653L19:FormatPage.kt#y3famj");
                    $composer3.startReplaceGroup(722390631);
                    ComposerKt.sourceInformation($composer3, "878@36461L44,880@36601L19,876@36361L259");
                    if (map3.size() + map4.size() > 5) {
                        String strSubtitleSelectionDialog$lambda$84 = FormatPageKt.SubtitleSelectionDialog$lambda$84(mutableState);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.search_in_subtitles, $composer3, 0);
                        Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(16), 0.0f, 2, null);
                        $composer3.startReplaceGroup(722390946);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FormatPage.kt#9igjgp");
                        Object it$iv3 = $composer3.rememberedValue();
                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$5$1$1$1
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
                                public final void invoke2(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState.setValue(it);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer3.endReplaceGroup();
                        SearchBarKt.LoopSearchBar(modifierM622paddingVpY3zN4$default, strSubtitleSelectionDialog$lambda$84, strStringResource, (Function1) value$iv3, $composer3, 3078, 0);
                    }
                    $composer3.endReplaceGroup();
                    LazyDslKt.LazyColumn(null, null, PaddingKt.m615PaddingValuesYgX7TsA$default(0.0f, Dp.m6553constructorimpl(12), 1, null), false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$5$1$2
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
                            if (!map5.isEmpty()) {
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$FormatPageKt.INSTANCE.m7225getLambda12$app_debug(), 3, null);
                            }
                            for (Map.Entry<String, List<SubtitleFormat>> entry : map5.entrySet()) {
                                final String code = entry.getKey();
                                final List<SubtitleFormat> value = entry.getValue();
                                final SnapshotStateList<String> snapshotStateList2 = snapshotStateList;
                                LazyListScope.CC.item$default(LazyColumn, code, null, ComposableLambdaKt.composableLambdaInstance(-876532220, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$5$1$2.1
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
                                        Object value$iv4;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer4, "C899@37617L333,896@37403L637:FormatPage.kt#y3famj");
                                        int $dirty = $changed3;
                                        if (($changed3 & 14) == 0) {
                                            $dirty |= $composer4.changed(item) ? 4 : 2;
                                        }
                                        int $dirty2 = $dirty;
                                        if (($dirty2 & 91) == 18 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1833056128, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:896)");
                                        }
                                        Modifier modifierAnimateItemPlacement$default = LazyItemScope.CC.animateItemPlacement$default(item, Modifier.INSTANCE, null, 1, null);
                                        boolean zContains = snapshotStateList2.contains(code);
                                        Object objFirst = CollectionsKt.first((List<? extends Object>) value);
                                        String str = code;
                                        SubtitleFormat $this$invoke_u24lambda_u240 = (SubtitleFormat) objFirst;
                                        String name = $this$invoke_u24lambda_u240.getName();
                                        String str2 = (name == null && (name = $this$invoke_u24lambda_u240.getProtocol()) == null) ? str : name;
                                        $composer4.startReplaceGroup(881886044);
                                        ComposerKt.sourceInformation($composer4, "CC(remember):FormatPage.kt#9igjgp");
                                        boolean invalid$iv = $composer4.changed(code);
                                        final SnapshotStateList<String> snapshotStateList3 = snapshotStateList2;
                                        final String str3 = code;
                                        Object it$iv4 = $composer4.rememberedValue();
                                        if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$5$1$2$1$2$1
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
                                                    if (snapshotStateList3.contains(str3)) {
                                                        snapshotStateList3.remove(str3);
                                                    } else {
                                                        snapshotStateList3.add(str3);
                                                    }
                                                }
                                            };
                                            $composer4.updateRememberedValue(value$iv4);
                                        } else {
                                            value$iv4 = it$iv4;
                                        }
                                        $composer4.endReplaceGroup();
                                        GeneralDownloadPreferencesKt.DialogCheckBoxItem(modifierAnimateItemPlacement$default, str2, zContains, (Function0) value$iv4, $composer4, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 2, null);
                            }
                            if (!map6.isEmpty()) {
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$FormatPageKt.INSTANCE.m7226getLambda13$app_debug(), 3, null);
                                for (Map.Entry<String, List<SubtitleFormat>> entry2 : map6.entrySet()) {
                                    final String code2 = entry2.getKey();
                                    final List<SubtitleFormat> value2 = entry2.getValue();
                                    final SnapshotStateList<String> snapshotStateList3 = snapshotStateList;
                                    LazyListScope.CC.item$default(LazyColumn, code2, null, ComposableLambdaKt.composableLambdaInstance(-876532220, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$5$1$2.2
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
                                            Object value$iv4;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C927@39089L357,924@38863L677:FormatPage.kt#y3famj");
                                            int $dirty = $changed3;
                                            if (($changed3 & 14) == 0) {
                                                $dirty |= $composer4.changed(item) ? 4 : 2;
                                            }
                                            int $dirty2 = $dirty;
                                            if (($dirty2 & 91) == 18 && $composer4.getSkipping()) {
                                                $composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1833056128, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:924)");
                                            }
                                            Modifier modifierAnimateItemPlacement$default = LazyItemScope.CC.animateItemPlacement$default(item, Modifier.INSTANCE, null, 1, null);
                                            boolean zContains = snapshotStateList3.contains(code2);
                                            Object objFirst = CollectionsKt.first((List<? extends Object>) value2);
                                            String str = code2;
                                            SubtitleFormat $this$invoke_u24lambda_u240 = (SubtitleFormat) objFirst;
                                            String name = $this$invoke_u24lambda_u240.getName();
                                            String str2 = (name == null && (name = $this$invoke_u24lambda_u240.getProtocol()) == null) ? str : name;
                                            $composer4.startReplaceGroup(881887516);
                                            ComposerKt.sourceInformation($composer4, "CC(remember):FormatPage.kt#9igjgp");
                                            boolean invalid$iv = $composer4.changed(code2);
                                            final SnapshotStateList<String> snapshotStateList4 = snapshotStateList3;
                                            final String str3 = code2;
                                            Object it$iv4 = $composer4.rememberedValue();
                                            if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$SubtitleSelectionDialog$5$1$2$2$2$1
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
                                                        if (snapshotStateList4.contains(str3)) {
                                                            snapshotStateList4.remove(str3);
                                                        } else {
                                                            snapshotStateList4.add(str3);
                                                        }
                                                    }
                                                };
                                                $composer4.updateRememberedValue(value$iv4);
                                            } else {
                                                value$iv4 = it$iv4;
                                            }
                                            $composer4.endReplaceGroup();
                                            GeneralDownloadPreferencesKt.DialogCheckBoxItem(modifierAnimateItemPlacement$default, str2, zContains, (Function0) value$iv4, $composer4, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), 2, null);
                                }
                            }
                        }
                    }, $composer3, 384, 251);
                    DividerKt.m7164HorizontalDivideriJQMabo(null, 0L, $composer3, 0, 3);
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
        }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($changed >> 6) & 112) | 1797504, 0, 16257);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialog.6
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
                    FormatPageKt.SubtitleSelectionDialog(map, map2, list, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SubtitleSelectionDialog$lambda$84(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SubtitleSelectionDialogPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(439195699);
        ComposerKt.sourceInformation($composer2, "C(SubtitleSelectionDialogPreview)987@40863L176,987@40853L186:FormatPage.kt#y3famj");
        if ($changed == 0 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(439195699, $changed, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialogPreview (FormatPage.kt:946)");
            }
            final Map captionsMap = MapsKt.mapOf(TuplesKt.to("en-en", CollectionsKt.listOf(new SubtitleFormat("", "", "English from English", (String) null, 8, (DefaultConstructorMarker) null))), TuplesKt.to("ja-en", CollectionsKt.listOf(new SubtitleFormat("", "", "Japanese from English", (String) null, 8, (DefaultConstructorMarker) null))), TuplesKt.to("zh-Hans-en", CollectionsKt.listOf(new SubtitleFormat("", "", "Chinese (Simplified) from English", (String) null, 8, (DefaultConstructorMarker) null))), TuplesKt.to("zh-Hant-en", CollectionsKt.listOf(new SubtitleFormat("", "", "Chinese (Traditional) from English", (String) null, 8, (DefaultConstructorMarker) null))));
            Map $this$SubtitleSelectionDialogPreview_u24lambda_u2488 = MapsKt.createMapBuilder();
            $this$SubtitleSelectionDialogPreview_u24lambda_u2488.put("en", CollectionsKt.listOf(new SubtitleFormat("ass", "", "English", (String) null, 8, (DefaultConstructorMarker) null)));
            $this$SubtitleSelectionDialogPreview_u24lambda_u2488.put("ja", CollectionsKt.listOf(new SubtitleFormat("ass", "", "Japanese", (String) null, 8, (DefaultConstructorMarker) null)));
            final Map subMap = MapsKt.build($this$SubtitleSelectionDialogPreview_u24lambda_u2488);
            ThemeKt.LoopTheme(false, false, false, ComposableLambdaKt.rememberComposableLambda(727007004, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialogPreview.1
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
                    ComposerKt.sourceInformation($composer3, "C988@40873L160:FormatPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(727007004, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.SubtitleSelectionDialogPreview.<anonymous> (FormatPage.kt:988)");
                        }
                        FormatPageKt.SubtitleSelectionDialog(subMap, captionsMap, CollectionsKt.emptyList(), null, null, $composer3, 456, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.SubtitleSelectionDialogPreview.2
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
                    FormatPageKt.SubtitleSelectionDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClickableTextAction(final boolean visible, final String text, Modifier modifier, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1586493064);
        ComposerKt.sourceInformation($composer2, "C(ClickableTextAction)P(3,2)1007@41298L343,1004@41196L445:FormatPage.kt#y3famj");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(visible) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            final Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586493064, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.ClickableTextAction (FormatPage.kt:1003)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(visible, (Modifier) null, (EnterTransition) null, EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1210526816, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.ClickableTextAction.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                    invoke(animatedVisibilityScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation($composer3, "C1010@41373L11,1011@41428L10,1008@41308L327:FormatPage.kt#y3famj");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1210526816, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.ClickableTextAction.<anonymous> (FormatPage.kt:1008)");
                    }
                    TextKt.m2569Text4IGK_g(text, PaddingKt.m621paddingVpY3zN4(ClickableKt.m239clickableXHw0xAI$default(ClipKt.clip(modifier4, RoundedCornerShapeKt.getCircleShape()), false, null, null, function0, 7, null), Dp.m6553constructorimpl(12), Dp.m6553constructorimpl(4)), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 0, 65528);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | 199680, 22);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.ClickableTextAction.2
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
                    FormatPageKt.ClickableTextAction(visible, text, modifier5, function0, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final <T extends Collection<? extends String>> Set<String> filterWithRegex(T t, String subtitleLanguageRegex) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(subtitleLanguageRegex, "subtitleLanguageRegex");
        boolean z = false;
        Iterable regexGroup = StringsKt.split$default((CharSequence) subtitleLanguageRegex, new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null);
        T $this$filter$iv = t;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String language = (String) element$iv$iv;
            Iterable $this$any$iv = regexGroup;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        String it2 = (String) element$iv;
                        if (new Regex(it2).matchEntire(language) != null) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
            z = false;
        }
        return CollectionsKt.toSet((List) destination$iv$iv);
    }

    public static final void UpdateSubtitleLanguageDialog(Modifier modifier, Set<String> set, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function2;
        Function0<Unit> function3;
        Modifier modifier2;
        Set<String> set2;
        Function0<Unit> function4;
        Function0<Unit> function5;
        Composer $composer2 = $composer.startRestartGroup(238116131);
        ComposerKt.sourceInformation($composer2, "C(UpdateSubtitleLanguageDialog)P(1!1,3)1088@44123L131,1093@44280L151,1051@42582L1515,1038@42181L2251:FormatPage.kt#y3famj");
        int $dirty = $changed;
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function2 = function0;
        } else if (($changed & 896) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function3 = function1;
        } else if (($changed & 7168) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function1;
        }
        if (i2 == 2 && ($dirty & 5841) == 1168 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            function4 = function2;
            function5 = function3;
            set2 = set;
        } else {
            modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
            final Set<String> of = i2 != 0 ? SetsKt.setOf((Object[]) new String[]{"en", "ja"}) : set;
            final C09361 c09361 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.UpdateSubtitleLanguageDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            final C09372 c09372 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.UpdateSubtitleLanguageDialog.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238116131, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.UpdateSubtitleLanguageDialog (FormatPage.kt:1037)");
            }
            AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0(c09361, ComposableLambdaKt.rememberComposableLambda(-2030193813, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.UpdateSubtitleLanguageDialog.3
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
                    ComposerKt.sourceInformation($composer3, "C1089@44137L107:FormatPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2030193813, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.UpdateSubtitleLanguageDialog.<anonymous> (FormatPage.kt:1089)");
                        }
                        ButtonKt.Button(c09372, null, false, null, null, null, null, null, null, ComposableSingletons$FormatPageKt.INSTANCE.m7227getLambda14$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(859581805, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.UpdateSubtitleLanguageDialog.4
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
                    ComposerKt.sourceInformation($composer3, "C1094@44294L127:FormatPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(859581805, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.UpdateSubtitleLanguageDialog.<anonymous> (FormatPage.kt:1094)");
                        }
                        ButtonKt.OutlinedButton(c09361, null, false, null, null, null, null, null, null, ComposableSingletons$FormatPageKt.INSTANCE.m7228getLambda15$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableSingletons$FormatPageKt.INSTANCE.m7229getLambda16$app_debug(), ComposableSingletons$FormatPageKt.INSTANCE.m7230getLambda17$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1248205712, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.UpdateSubtitleLanguageDialog.5
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
                    ComposerKt.sourceInformation($composer3, "C1052@42596L1491:FormatPage.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1248205712, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.UpdateSubtitleLanguageDialog.<anonymous> (FormatPage.kt:1052)");
                        }
                        final Set<String> set3 = of;
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
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i6 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 913530875, "C1053@42633L44,1053@42621L57,1055@42696L41,1060@42925L1091,1057@42755L1261,1085@44033L40:FormatPage.kt#y3famj");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.update_language_msg, $composer3, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(24)), $composer3, 6);
                        FlowLayoutKt.FlowRow(null, Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(20)), Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(12)), 0, 0, null, ComposableLambdaKt.rememberComposableLambda(1043428235, true, new Function3<FlowRowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$UpdateSubtitleLanguageDialog$5$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer, Integer num) {
                                invoke(flowRowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(FlowRowScope FlowRow, Composer $composer4, int $changed3) {
                                Function0<ComposeUiNode> function7;
                                Modifier modifier$iv2;
                                Composer composer = $composer4;
                                Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                                ComposerKt.sourceInformation(composer, "C*1062@42991L985:FormatPage.kt#y3famj");
                                if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1043428235, $changed3, -1, "com.videshkarmakar.loop.ui.page.download.UpdateSubtitleLanguageDialog.<anonymous>.<anonymous>.<anonymous> (FormatPage.kt:1061)");
                                    }
                                    Iterable $this$forEach$iv = set3;
                                    int $i$f$forEach = 0;
                                    Iterator it = $this$forEach$iv.iterator();
                                    while (it.hasNext()) {
                                        Object element$iv = it.next();
                                        String it2 = (String) element$iv;
                                        Modifier modifier$iv3 = Modifier.INSTANCE;
                                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                        ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                        int $changed$iv$iv2 = (390 << 3) & 112;
                                        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier(composer, modifier$iv3);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            composer.createNode(constructor2);
                                        } else {
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                        }
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                        int i8 = ((390 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1158595850, "C1073@43541L20,1066@43177L538,1080@43900L10,1077@43744L206:FormatPage.kt#y3famj");
                                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                                        int $i$f$forEach2 = $i$f$forEach;
                                        Iterator it3 = it;
                                        Modifier modifier$iv4 = SemanticsModifierKt.clearAndSetSemantics(BackgroundKt.m205backgroundbw27NRU(SizeKt.m665size3ABfNKs(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null), Dp.m6553constructorimpl(16)), ColorSchemeKt.generateLabelColor(it2.hashCode(), $composer4, 0), RoundedCornerShapeKt.getCircleShape()), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt$UpdateSubtitleLanguageDialog$5$1$1$1$1$1
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
                                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function7 = constructor3;
                                            $composer4.createNode(function7);
                                        } else {
                                            function7 = constructor3;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                                            modifier$iv2 = modifier$iv3;
                                        } else {
                                            modifier$iv2 = modifier$iv3;
                                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                            }
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                            int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i10 = ((0 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1923006524, "C:FormatPage.kt#y3famj");
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            TextKt.m2569Text4IGK_g(it2, (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), $composer4, 48, 0, 65532);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endNode();
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            composer = $composer4;
                                            $this$forEach$iv = $this$forEach$iv2;
                                            $i$f$forEach = $i$f$forEach2;
                                            it = it3;
                                        }
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                        int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        int i12 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1923006524, "C:FormatPage.kt#y3famj");
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        TextKt.m2569Text4IGK_g(it2, (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), $composer4, 48, 0, 65532);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        composer = $composer4;
                                        $this$forEach$iv = $this$forEach$iv2;
                                        $i$f$forEach = $i$f$forEach2;
                                        it = it3;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 1573296, 57);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), $composer3, 6);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 6) & 14) | 1797168, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            set2 = of;
            function4 = c09361;
            function5 = c09372;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Set<String> set3 = set2;
            final Function0<Unit> function6 = function4;
            final Function0<Unit> function7 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.FormatPageKt.UpdateSubtitleLanguageDialog.6
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
                    FormatPageKt.UpdateSubtitleLanguageDialog(modifier3, set3, function6, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
