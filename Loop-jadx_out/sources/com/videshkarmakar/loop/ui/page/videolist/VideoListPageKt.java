package com.videshkarmakar.loop.ui.page.videolist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridSpanKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
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
import com.caverock.androidsvg.SVGParseException;
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.database.backup.BackupUtil;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.ui.common.AsyncImageImplKt;
import com.videshkarmakar.loop.ui.common.HapticFeedback;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.ChipsKt;
import com.videshkarmakar.loop.ui.component.DialogItemsKt;
import com.videshkarmakar.loop.ui.component.DialogsKt;
import com.videshkarmakar.loop.ui.component.IconButtonsKt;
import com.videshkarmakar.loop.ui.component.SearchBarKt;
import com.videshkarmakar.loop.ui.component.TopAppBarKt;
import com.videshkarmakar.loop.ui.component.VideoListItemKt;
import com.videshkarmakar.loop.util.FileUtil;
import com.videshkarmakar.loop.util.FileUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import com.videshkarmakar.loop.util.ToastUtil;
import defpackage.VideoStreamSVG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: VideoListPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001a\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0011\u001a\u00020\u000f*\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u001a \u0010\u0014\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u008a\u0084\u0002²\u0006\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cX\u008a\u0084\u0002²\u0006\u0016\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0001X\u008a\u008e\u0002"}, d2 = {"TAG", "", VideoListPageKt.TAG, "", "viewModel", "Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel;", "onNavigateBack", "Lkotlin/Function0;", "(Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "backupToString", "", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lcom/videshkarmakar/loop/database/backup/BackupUtil$BackupType;", "filterByExtractor", "", "extractor", "filterByType", "videoFilter", "audioFilter", "filterSort", "viewState", "Lcom/videshkarmakar/loop/ui/page/videolist/VideoListViewModel$VideoListViewState;", "filterSet", "", "app_debug", "fullVideoList", "searchedVideoList", "", "fileSizeMap", "", "", "", "currentVideoInfo", "isSelectEnabled", "showRemoveMultipleItemsDialog", "showExportDialog", "showImportDialog", "selectedFileSizeSum", "checkBoxState", "Landroidx/compose/ui/state/ToggleableState;", "showRemoveDialog", "showBottomSheet", "expanded", "deleteFile", "backupString"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoListPageKt {
    private static final String TAG = "VideoListPage";

    /* JADX INFO: compiled from: VideoListPage.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackupUtil.BackupType.values().length];
            try {
                iArr[BackupUtil.BackupType.DownloadHistory.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BackupUtil.BackupType.URLList.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ boolean filterByType$default(DownloadedVideoInfo downloadedVideoInfo, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return filterByType(downloadedVideoInfo, z, z2);
    }

    public static final boolean filterByType(DownloadedVideoInfo $this$filterByType, boolean videoFilter, boolean audioFilter) {
        Intrinsics.checkNotNullParameter($this$filterByType, "<this>");
        if (!videoFilter && !audioFilter) {
            return true;
        }
        if (audioFilter) {
            return new Regex(FileUtilKt.AUDIO_REGEX).containsMatchIn($this$filterByType.getVideoPath());
        }
        return !new Regex(FileUtilKt.AUDIO_REGEX).containsMatchIn($this$filterByType.getVideoPath());
    }

    public static final boolean filterSort(DownloadedVideoInfo $this$filterSort, VideoListViewModel.VideoListViewState viewState, Set<String> filterSet) {
        Intrinsics.checkNotNullParameter($this$filterSort, "<this>");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(filterSet, "filterSet");
        return filterByType($this$filterSort, viewState.getVideoFilter(), viewState.getAudioFilter()) && filterByExtractor($this$filterSort, (String) CollectionsKt.elementAtOrNull(filterSet, viewState.getActiveFilterIndex()));
    }

    public static final boolean filterByExtractor(DownloadedVideoInfo $this$filterByExtractor, String extractor) {
        Intrinsics.checkNotNullParameter($this$filterByExtractor, "<this>");
        String str = extractor;
        return (str == null || str.length() == 0) || Intrinsics.areEqual($this$filterByExtractor.getExtractor(), extractor);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:112:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:114:0x0511  */
    /* JADX WARN: Code duplicated, block: B:117:0x051b  */
    /* JADX WARN: Code duplicated, block: B:121:0x0522  */
    /* JADX WARN: Code duplicated, block: B:138:0x0598  */
    /* JADX WARN: Code duplicated, block: B:141:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:143:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:145:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:146:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:151:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:176:0x069a  */
    /* JADX WARN: Code duplicated, block: B:179:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:183:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:198:0x0753  */
    /* JADX WARN: Code duplicated, block: B:199:0x076c  */
    /* JADX WARN: Code duplicated, block: B:202:0x0796  */
    /* JADX WARN: Code duplicated, block: B:203:0x07af  */
    /* JADX WARN: Code duplicated, block: B:210:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:221:0x0923  */
    /* JADX WARN: Code duplicated, block: B:226:0x0946  */
    /* JADX WARN: Code duplicated, block: B:230:0x097a  */
    /* JADX WARN: Code duplicated, block: B:231:0x098e  */
    /* JADX WARN: Code duplicated, block: B:233:0x09ac  */
    /* JADX WARN: Code duplicated, block: B:236:0x09d3  */
    /* JADX WARN: Code duplicated, block: B:237:0x09e4  */
    /* JADX WARN: Code duplicated, block: B:240:0x09fe  */
    /* JADX WARN: Code duplicated, block: B:242:0x0a20  */
    /* JADX WARN: Code duplicated, block: B:243:0x0a30  */
    /* JADX WARN: Code duplicated, block: B:246:0x0a67  */
    /* JADX WARN: Code duplicated, block: B:247:0x0a77  */
    /* JADX WARN: Code duplicated, block: B:249:0x0a90  */
    /* JADX WARN: Code duplicated, block: B:252:0x0aa8  */
    /* JADX WARN: Code duplicated, block: B:254:0x0ac2  */
    /* JADX WARN: Code duplicated, block: B:255:0x0ad2  */
    /* JADX WARN: Code duplicated, block: B:257:0x0b51  */
    /* JADX WARN: Code duplicated, block: B:260:0x0b7a  */
    /* JADX WARN: Code duplicated, block: B:261:0x0b8f  */
    /* JADX WARN: Code duplicated, block: B:264:0x0bcb  */
    /* JADX WARN: Code duplicated, block: B:266:0x0bd6  */
    /* JADX WARN: Code duplicated, block: B:269:0x0bf2  */
    /* JADX WARN: Code duplicated, block: B:271:0x0c0c  */
    /* JADX WARN: Code duplicated, block: B:272:0x0c12  */
    /* JADX WARN: Code duplicated, block: B:275:0x0c26  */
    /* JADX WARN: Code duplicated, block: B:278:0x0c40  */
    /* JADX WARN: Code duplicated, block: B:280:0x0c5f  */
    /* JADX WARN: Code duplicated, block: B:285:0x0c9a  */
    /* JADX WARN: Code duplicated, block: B:286:0x0caa  */
    /* JADX WARN: Code duplicated, block: B:288:0x0cdd  */
    /* JADX WARN: Code duplicated, block: B:291:0x0d05  */
    /* JADX WARN: Code duplicated, block: B:293:0x0d1f  */
    /* JADX WARN: Code duplicated, block: B:294:0x0d31  */
    /* JADX WARN: Code duplicated, block: B:296:0x0d60  */
    /* JADX WARN: Code duplicated, block: B:299:0x0d68  */
    /* JADX WARN: Code duplicated, block: B:311:0x0c62 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x06d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:314:0x06c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:319:0x05e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:320:0x05d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:325:0x052c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:326:0x051e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:47:0x012c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0131  */
    /* JADX WARN: Code duplicated, block: B:51:0x0156  */
    /* JADX WARN: Code duplicated, block: B:52:0x0188  */
    /* JADX WARN: Code duplicated, block: B:55:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x029a  */
    /* JADX WARN: Code duplicated, block: B:60:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:64:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:67:0x030b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0324  */
    /* JADX WARN: Code duplicated, block: B:71:0x034e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0367  */
    /* JADX WARN: Code duplicated, block: B:75:0x0394  */
    /* JADX WARN: Code duplicated, block: B:76:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:79:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x03f1  */
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
    public static final void VideoListPage(VideoListViewModel viewModel, final Function0<Unit> onNavigateBack, Composer $composer, final int $changed, final int i) {
        int $dirty;
        VideoListViewModel viewModel2;
        final State viewState$delegate;
        final State fullVideoList$delegate;
        State searchedVideoList$delegate;
        List<DownloadedVideoInfo> listVideoListPage$lambda$1;
        final State filterSet$delegate;
        final TopAppBarScrollBehavior scrollBehavior;
        Object it$iv$iv;
        Object value$iv$iv;
        final View view;
        final Context context;
        final ClipboardManager clipboardManager;
        final VideoListViewModel viewModel3;
        final State fileSizeMap$delegate;
        final ModalBottomSheetState sheetState;
        Object it$iv;
        Object value$iv;
        SnackbarHostState hostState;
        Object it$iv2;
        Object value$iv2;
        final MutableState currentVideoInfo$delegate;
        Object it$iv3;
        Object value$iv3;
        final MutableState isSelectEnabled$delegate;
        Object it$iv4;
        Object value$iv4;
        final MutableState showRemoveMultipleItemsDialog$delegate;
        Object value$iv5;
        final MutableState showExportDialog$delegate;
        Object value$iv6;
        final MutableState showImportDialog$delegate;
        boolean invalid$iv;
        Object value$iv7;
        final SnapshotStateList selectedItemIds;
        boolean invalid$iv2;
        VideoListPageKt$VideoListPage$1$1 value$iv8;
        boolean invalid$iv3;
        Iterable $this$count$iv;
        int count$iv;
        SnackbarHostState hostState2;
        DownloadedVideoInfo info;
        boolean z;
        Object value$iv9;
        MutableIntState selectedVideoCount;
        boolean invalid$iv4;
        Object it$iv5;
        Iterable $this$count$iv2;
        int count$iv2;
        MutableIntState selectedVideoCount2;
        DownloadedVideoInfo info2;
        boolean z2;
        Object value$iv10;
        boolean invalid$iv5;
        Object value$iv11;
        State selectedFileSizeSum$delegate;
        boolean invalid$iv6;
        Object it$iv6;
        Iterable $this$count$iv3;
        int count$iv3;
        State selectedFileSizeSum$delegate2;
        DownloadedVideoInfo it;
        Object value$iv12;
        boolean invalid$iv7;
        Object value$iv13;
        Object it$iv7;
        Object value$iv14;
        MutableState showRemoveDialog$delegate;
        Object it$iv8;
        Object value$iv15;
        final MutableState showBottomSheet$delegate;
        boolean z3;
        boolean invalid$iv8;
        VideoListPageKt$VideoListPage$3$1 value$iv16;
        final List<DownloadedVideoInfo> list;
        final SnackbarHostState hostState3;
        State selectedFileSizeSum$delegate3;
        final CoroutineScope scope;
        Composer $composer2;
        MutableState showBottomSheet$delegate2;
        final MutableState showRemoveDialog$delegate2;
        String str;
        ModalBottomSheetState sheetState2;
        Object it$iv9;
        Object value$iv17;
        final MutableState deleteFile$delegate;
        final VideoListViewModel viewModel4;
        final State selectedFileSizeSum$delegate4;
        final SnapshotStateList selectedItemIds2;
        Object it$iv10;
        Object value$iv18;
        final MutableState backupString$delegate;
        final ManagedActivityResultLauncher exportLauncher;
        Context context2;
        CoroutineScope scope2;
        final Context context3;
        final ManagedActivityResultLauncher importLauncher;
        Object it$iv11;
        final MutableState showImportDialog$delegate2;
        Object value$iv19;
        List<DownloadedVideoInfo> $this$filter$iv;
        int $i$f$filter;
        Collection destination$iv$iv;
        CoroutineScope scope3;
        State selectedFileSizeSum$delegate5;
        final List list2;
        DownloadedVideoInfo it2;
        Object it$iv12;
        Object value$iv20;
        List<DownloadedVideoInfo> destination$iv$iv2;
        Collection destination$iv$iv3;
        DownloadedVideoInfo it3;
        Object it$iv13;
        final MutableState showRemoveMultipleItemsDialog$delegate2;
        Object value$iv21;
        Object it$iv14;
        Object value$iv22;
        Object value$iv23;
        Long l;
        boolean isFileAvailable;
        Object it$iv15;
        Object value$iv24;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Composer $composer3 = $composer.startRestartGroup(-1892356385);
        ComposerKt.sourceInformation($composer3, "C(VideoListPage)P(1)139@6491L11,142@6580L29,143@6659L40,144@6761L54,149@6946L30,157@7239L24,158@7329L7,159@7362L7,160@7401L7,161@7458L7,163@7516L54,164@7592L74,165@7687L32,168@7750L62,172@7841L34,173@7917L34,175@7981L34,176@8044L34,178@8104L23,221@9746L60,223@9844L108,223@9812L140,231@9984L288,240@10302L288,250@10623L203,258@10855L123,262@11005L367,273@11402L34,274@11464L34,276@11504L197,285@11764L110,285@11708L166,293@11988L4030,375@16032L2370,429@18427L59,432@18493L4715,291@11880L11328,555@23718L34,611@25843L31,614@25909L498,654@27336L315,666@27722L28,666@27690L711:VideoListPage.kt#861hqi");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onNavigateBack) ? 32 : 16;
        }
        int $dirty3 = $dirty2;
        if (i2 == 1 && ($dirty3 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            viewModel4 = viewModel;
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
                    ViewModel viewModel5 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(VideoListViewModel.class), viewModelStoreOwner$iv, (String) null, (ViewModelProvider.Factory) null, extras$iv, $composer3, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344), 0);
                    $composer3.endReplaceableGroup();
                    $dirty = $dirty3 & (-15);
                    viewModel2 = (VideoListViewModel) viewModel5;
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1892356385, $dirty, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage (VideoListPage.kt:141)");
                }
                viewState$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 8, 7);
                fullVideoList$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getVideoListFlow(), CollectionsKt.emptyList(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 56, 14);
                searchedVideoList$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getSearchedVideoListFlow(), CollectionsKt.emptyList(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 56, 14);
                if (VideoListPage$lambda$0(viewState$delegate).isSearching()) {
                    listVideoListPage$lambda$1 = VideoListPage$lambda$2(searchedVideoList$delegate);
                } else {
                    listVideoListPage$lambda$1 = VideoListPage$lambda$1(fullVideoList$delegate);
                }
                filterSet$delegate = SnapshotStateKt.collectAsState(viewModel2.getFilterSetFlow(), new LinkedHashSet(), null, $composer3, 72, 2);
                if (!VideoListPage$lambda$1(fullVideoList$delegate).isEmpty()) {
                    $composer3.startReplaceGroup(1093398981);
                    ComposerKt.sourceInformation($composer3, "153@7107L24,152@7061L114");
                    scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer3, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$scrollBehavior$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return true;
                        }
                    }, null, null, $composer3, (TopAppBarDefaults.$stable << 12) | 48, 12);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1093399119);
                    ComposerKt.sourceInformation($composer3, "155@7199L22");
                    scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
                    $composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
                it$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                    $composer3.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final CoroutineScope scope4 = wrapper$iv.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localSoftwareKeyboardController);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SoftwareKeyboardController softKeyboardController = (SoftwareKeyboardController) objConsume;
                ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localView);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                view = (View) objConsume2;
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer3.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                context = (Context) objConsume3;
                ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = $composer3.consume(localClipboardManager);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                clipboardManager = (ClipboardManager) objConsume4;
                viewModel3 = viewModel2;
                fileSizeMap$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getFileSizeMapFlow(), MapsKt.emptyMap(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 56, 14);
                sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, $composer3, 6, 14);
                $composer3.startReplaceGroup(1093399607);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new SnackbarHostState();
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                hostState = (SnackbarHostState) value$iv;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093399670);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new DownloadedVideoInfo(), null, 2, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                currentVideoInfo$delegate = (MutableState) value$iv2;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093399761);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                isSelectEnabled$delegate = (MutableState) value$iv3;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093399837);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                it$iv4 = $composer3.rememberedValue();
                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer3.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                showRemoveMultipleItemsDialog$delegate = (MutableState) value$iv4;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093399901);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                value$iv5 = $composer3.rememberedValue();
                if (value$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer3.updateRememberedValue(value$iv5);
                }
                showExportDialog$delegate = (MutableState) value$iv5;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093399964);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                value$iv6 = $composer3.rememberedValue();
                if (value$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer3.updateRememberedValue(value$iv6);
                }
                showImportDialog$delegate = (MutableState) value$iv6;
                $composer3.endReplaceGroup();
                final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
                VideoListViewModel.VideoListViewState videoListViewStateVideoListPage$lambda$0 = VideoListPage$lambda$0(viewState$delegate);
                $composer3.startReplaceGroup(1093401666);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv = $composer3.changed(videoListViewStateVideoListPage$lambda$0) | $composer3.changed(listVideoListPage$lambda$1);
                Object it$iv16 = $composer3.rememberedValue();
                if (!invalid$iv || it$iv16 == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = SnapshotStateKt.mutableStateListOf();
                    $composer3.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv16;
                }
                selectedItemIds = (SnapshotStateList) value$iv7;
                $composer3.endReplaceGroup();
                Boolean boolValueOf = Boolean.valueOf(VideoListPage$lambda$10(isSelectEnabled$delegate));
                $composer3.startReplaceGroup(1093401764);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv2 = $composer3.changed(selectedItemIds);
                Object it$iv17 = $composer3.rememberedValue();
                if (!invalid$iv2 || it$iv17 == Composer.INSTANCE.getEmpty()) {
                    value$iv8 = new VideoListPageKt$VideoListPage$1$1(selectedItemIds, isSelectEnabled$delegate, null);
                    $composer3.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = it$iv17;
                }
                $composer3.endReplaceGroup();
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv8, $composer3, 64);
                int size = selectedItemIds.size();
                $composer3.startReplaceGroup(1093401904);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv3 = $composer3.changed(size);
                Object it$iv18 = $composer3.rememberedValue();
                if (!invalid$iv3 || it$iv18 == Composer.INSTANCE.getEmpty()) {
                    $this$count$iv = listVideoListPage$lambda$1;
                    if (($this$count$iv instanceof Collection) || !((Collection) $this$count$iv).isEmpty()) {
                        count$iv = 0;
                        for (Object element$iv : $this$count$iv) {
                            $this$count$iv = $this$count$iv;
                            info = (DownloadedVideoInfo) element$iv;
                            hostState = hostState;
                            if (selectedItemIds.contains(Integer.valueOf(info.getId())) || !filterByType(info, true, false)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                count$iv++;
                                if (count$iv < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                        }
                        hostState2 = hostState;
                    } else {
                        hostState2 = hostState;
                        count$iv = 0;
                    }
                    value$iv9 = SnapshotIntStateKt.mutableIntStateOf(count$iv);
                    $composer3.updateRememberedValue(value$iv9);
                } else {
                    value$iv9 = it$iv18;
                    hostState2 = hostState;
                }
                selectedVideoCount = (MutableIntState) value$iv9;
                $composer3.endReplaceGroup();
                int size2 = selectedItemIds.size();
                $composer3.startReplaceGroup(1093402222);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv4 = $composer3.changed(size2);
                it$iv5 = $composer3.rememberedValue();
                if (!invalid$iv4 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                    $this$count$iv2 = listVideoListPage$lambda$1;
                    if (($this$count$iv2 instanceof Collection) || !((Collection) $this$count$iv2).isEmpty()) {
                        count$iv2 = 0;
                        for (Object element$iv2 : $this$count$iv2) {
                            $this$count$iv2 = $this$count$iv2;
                            info2 = (DownloadedVideoInfo) element$iv2;
                            it$iv5 = it$iv5;
                            if (selectedItemIds.contains(Integer.valueOf(info2.getId()))) {
                                selectedVideoCount = selectedVideoCount;
                                z2 = filterByType(info2, false, true);
                                if (!z2) {
                                    count$iv2++;
                                    if (count$iv2 < 0) {
                                        CollectionsKt.throwCountOverflow();
                                    }
                                }
                            } else {
                                selectedVideoCount = selectedVideoCount;
                            }
                            if (!z2) {
                                count$iv2++;
                                if (count$iv2 < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                        }
                        selectedVideoCount2 = selectedVideoCount;
                    } else {
                        selectedVideoCount2 = selectedVideoCount;
                        count$iv2 = 0;
                    }
                    value$iv10 = SnapshotIntStateKt.mutableIntStateOf(count$iv2);
                    $composer3.updateRememberedValue(value$iv10);
                } else {
                    value$iv10 = it$iv5;
                    selectedVideoCount2 = selectedVideoCount;
                }
                final MutableIntState selectedAudioCount = (MutableIntState) value$iv10;
                $composer3.endReplaceGroup();
                int size3 = selectedItemIds.size();
                $composer3.startReplaceGroup(1093402543);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv5 = $composer3.changed(size3);
                Object it$iv19 = $composer3.rememberedValue();
                if (!invalid$iv5 || it$iv19 == Composer.INSTANCE.getEmpty()) {
                    value$iv11 = SnapshotStateKt.derivedStateOf(new Function0<Long>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$selectedFileSizeSum$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            Iterable $this$fold$iv = selectedItemIds;
                            State<Map<Integer, Long>> state = fileSizeMap$delegate;
                            Long lValueOf = 0L;
                            for (Object element$iv3 : $this$fold$iv) {
                                int id = ((Number) element$iv3).intValue();
                                long acc = lValueOf.longValue();
                                Object obj = VideoListPageKt.VideoListPage$lambda$4(state).get(Integer.valueOf(id));
                                if (obj == null) {
                                    obj = 0L;
                                }
                                lValueOf = Long.valueOf(acc + ((Number) obj).longValue());
                            }
                            return lValueOf;
                        }
                    });
                    $composer3.updateRememberedValue(value$iv11);
                } else {
                    value$iv11 = it$iv19;
                }
                selectedFileSizeSum$delegate = (State) value$iv11;
                $composer3.endReplaceGroup();
                VideoListViewModel.VideoListViewState videoListViewStateVideoListPage$lambda$1 = VideoListPage$lambda$0(viewState$delegate);
                $composer3.startReplaceGroup(1093402775);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv6 = $composer3.changed(videoListViewStateVideoListPage$lambda$1) | $composer3.changed(listVideoListPage$lambda$1);
                it$iv6 = $composer3.rememberedValue();
                if (!invalid$iv6 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                    $this$count$iv3 = listVideoListPage$lambda$1;
                    if (($this$count$iv3 instanceof Collection) || !((Collection) $this$count$iv3).isEmpty()) {
                        count$iv3 = 0;
                        for (Object element$iv3 : $this$count$iv3) {
                            $this$count$iv3 = $this$count$iv3;
                            it = (DownloadedVideoInfo) element$iv3;
                            it$iv6 = it$iv6;
                            selectedFileSizeSum$delegate = selectedFileSizeSum$delegate;
                            if (filterSort(it, VideoListPage$lambda$0(viewState$delegate), VideoListPage$lambda$3(filterSet$delegate))) {
                                count$iv3++;
                                if (count$iv3 < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                        }
                        selectedFileSizeSum$delegate2 = selectedFileSizeSum$delegate;
                    } else {
                        selectedFileSizeSum$delegate2 = selectedFileSizeSum$delegate;
                        count$iv3 = 0;
                    }
                    value$iv12 = SnapshotIntStateKt.mutableIntStateOf(count$iv3);
                    $composer3.updateRememberedValue(value$iv12);
                } else {
                    value$iv12 = it$iv6;
                    selectedFileSizeSum$delegate2 = selectedFileSizeSum$delegate;
                }
                final MutableIntState visibleItemCount = (MutableIntState) value$iv12;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093402925);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv7 = $composer3.changed(selectedItemIds) | $composer3.changed(visibleItemCount);
                Object it$iv20 = $composer3.rememberedValue();
                if (!invalid$iv7 || it$iv20 == Composer.INSTANCE.getEmpty()) {
                    value$iv13 = SnapshotStateKt.derivedStateOf(new Function0<ToggleableState>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$checkBoxState$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ToggleableState invoke() {
                            if (selectedItemIds.isEmpty()) {
                                return ToggleableState.Off;
                            }
                            if (selectedItemIds.size() == visibleItemCount.getIntValue() && (!selectedItemIds.isEmpty())) {
                                return ToggleableState.On;
                            }
                            return ToggleableState.Indeterminate;
                        }
                    });
                    $composer3.updateRememberedValue(value$iv13);
                } else {
                    value$iv13 = it$iv20;
                }
                final State checkBoxState$delegate = (State) value$iv13;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093403322);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                it$iv7 = $composer3.rememberedValue();
                if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer3.updateRememberedValue(value$iv14);
                } else {
                    value$iv14 = it$iv7;
                }
                showRemoveDialog$delegate = (MutableState) value$iv14;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1093403384);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                it$iv8 = $composer3.rememberedValue();
                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                    value$iv15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer3.updateRememberedValue(value$iv15);
                } else {
                    value$iv15 = it$iv8;
                }
                showBottomSheet$delegate = (MutableState) value$iv15;
                $composer3.endReplaceGroup();
                if (!VideoListPage$lambda$10(isSelectEnabled$delegate) || VideoListPage$lambda$0(viewState$delegate).isSearching()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                BackHandlerKt.BackHandler(z3, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.2
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
                        if (VideoListPageKt.VideoListPage$lambda$10(isSelectEnabled$delegate)) {
                            VideoListPageKt.VideoListPage$lambda$11(isSelectEnabled$delegate, false);
                        } else {
                            viewModel3.toggleSearch(false);
                        }
                    }
                }, $composer3, 0, 0);
                ModalBottomSheetValue targetValue = sheetState.getTargetValue();
                Boolean boolValueOf2 = Boolean.valueOf(VideoListPage$lambda$10(isSelectEnabled$delegate));
                $composer3.startReplaceGroup(1093403684);
                ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
                invalid$iv8 = $composer3.changed(softKeyboardController);
                Object it$iv21 = $composer3.rememberedValue();
                if (!invalid$iv8 || it$iv21 == Composer.INSTANCE.getEmpty()) {
                    value$iv16 = new VideoListPageKt$VideoListPage$3$1(softKeyboardController, showBottomSheet$delegate, isSelectEnabled$delegate, null);
                    $composer3.updateRememberedValue(value$iv16);
                } else {
                    value$iv16 = it$iv21;
                }
                $composer3.endReplaceGroup();
                EffectsKt.LaunchedEffect(targetValue, boolValueOf2, (Function2) value$iv16, $composer3, 512);
                list = listVideoListPage$lambda$1;
                hostState3 = hostState2;
                selectedFileSizeSum$delegate3 = selectedFileSizeSum$delegate2;
                scope = scope4;
                final MutableIntState mutableIntState = selectedVideoCount2;
                $composer2 = $composer3;
                ScaffoldKt.m2282ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(-686184285, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.4
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
                        ComposerKt.sourceInformation($composer4, "C301@12263L115,305@12390L3571,294@12002L4006:VideoListPage.kt#861hqi");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-686184285, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:294)");
                            }
                            Function2<Composer, Integer, Unit> function2M7496getLambda1$app_debug = ComposableSingletons$VideoListPageKt.INSTANCE.m7496getLambda1$app_debug();
                            final Function0<Unit> function0 = onNavigateBack;
                            TopAppBarKt.LargeTopAppBar(function2M7496getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-189786530, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.4.1
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
                                    Object value$iv25;
                                    ComposerKt.sourceInformation($composer5, "C302@12296L64,302@12285L75:VideoListPage.kt#861hqi");
                                    if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                        $composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-189786530, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous> (VideoListPage.kt:302)");
                                    }
                                    $composer5.startReplaceGroup(-705212166);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):VideoListPage.kt#9igjgp");
                                    boolean invalid$iv9 = $composer5.changed(function0);
                                    final Function0<Unit> function1 = function0;
                                    Object it$iv22 = $composer5.rememberedValue();
                                    if (invalid$iv9 || it$iv22 == Composer.INSTANCE.getEmpty()) {
                                        value$iv25 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$1$1$1
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
                                        $composer5.updateRememberedValue(value$iv25);
                                    } else {
                                        value$iv25 = it$iv22;
                                    }
                                    $composer5.endReplaceGroup();
                                    IconButtonsKt.BackButton((Function0) value$iv25, $composer5, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(1137363271, true, new AnonymousClass2(fullVideoList$delegate, viewState$delegate, view, viewModel3, scope4, lazyListState, visibleItemCount, showExportDialog$delegate, showImportDialog$delegate), $composer4, 54), scrollBehavior, $composer4, 3462, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2, reason: invalid class name */
                    /* JADX INFO: compiled from: VideoListPage.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    static final class AnonymousClass2 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
                        final /* synthetic */ State<List<DownloadedVideoInfo>> $fullVideoList$delegate;
                        final /* synthetic */ LazyListState $lazyListState;
                        final /* synthetic */ CoroutineScope $scope;
                        final /* synthetic */ MutableState<Boolean> $showExportDialog$delegate;
                        final /* synthetic */ MutableState<Boolean> $showImportDialog$delegate;
                        final /* synthetic */ View $view;
                        final /* synthetic */ VideoListViewModel $viewModel;
                        final /* synthetic */ State<VideoListViewModel.VideoListViewState> $viewState$delegate;
                        final /* synthetic */ MutableIntState $visibleItemCount;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        AnonymousClass2(State<? extends List<DownloadedVideoInfo>> state, State<VideoListViewModel.VideoListViewState> state2, View view, VideoListViewModel videoListViewModel, CoroutineScope coroutineScope, LazyListState lazyListState, MutableIntState mutableIntState, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
                            super(3);
                            this.$fullVideoList$delegate = state;
                            this.$viewState$delegate = state2;
                            this.$view = view;
                            this.$viewModel = videoListViewModel;
                            this.$scope = coroutineScope;
                            this.$lazyListState = lazyListState;
                            this.$visibleItemCount = mutableIntState;
                            this.$showExportDialog$delegate = mutableState;
                            this.$showImportDialog$delegate = mutableState2;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope LargeTopAppBar, Composer $composer, int $changed) {
                            Function0<ComposeUiNode> function0;
                            Object value$iv;
                            Function0<ComposeUiNode> function1;
                            Object value$iv2;
                            Intrinsics.checkNotNullParameter(LargeTopAppBar, "$this$LargeTopAppBar");
                            ComposerKt.sourceInformation($composer, "C306@12412L3531:VideoListPage.kt#861hqi");
                            if (($changed & 81) == 16 && $composer.getSkipping()) {
                                $composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1137363271, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous> (VideoListPage.kt:306)");
                            }
                            State<List<DownloadedVideoInfo>> state = this.$fullVideoList$delegate;
                            State<VideoListViewModel.VideoListViewState> state2 = this.$viewState$delegate;
                            final View view = this.$view;
                            final VideoListViewModel videoListViewModel = this.$viewModel;
                            final CoroutineScope coroutineScope = this.$scope;
                            final LazyListState lazyListState = this.$lazyListState;
                            final MutableIntState mutableIntState = this.$visibleItemCount;
                            final MutableState<Boolean> mutableState = this.$showExportDialog$delegate;
                            final MutableState<Boolean> mutableState2 = this.$showImportDialog$delegate;
                            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                                function0 = constructor;
                                $composer.createNode(function0);
                            } else {
                                function0 = constructor;
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
                            ComposerKt.sourceInformationMarkerStart($composer, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            int i2 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, 756709549, "C328@13531L34,329@13590L2331:VideoListPage.kt#861hqi");
                            $composer.startReplaceGroup(756709549);
                            ComposerKt.sourceInformation($composer, "308@12504L960");
                            if (!VideoListPageKt.VideoListPage$lambda$1(state).isEmpty()) {
                                IconButtonKt.IconToggleButton(VideoListPageKt.VideoListPage$lambda$0(state2).isSearching(), new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$1
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
                                        HapticFeedback.INSTANCE.slightHapticFeedback(view);
                                        videoListViewModel.toggleSearch(it);
                                        if (it) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(lazyListState, null), 3, null);
                                        }
                                    }

                                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$1$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: VideoListPage.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$1$1", f = "VideoListPage.kt", i = {}, l = {316, 317}, m = "invokeSuspend", n = {}, s = {})
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ LazyListState $lazyListState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$lazyListState = lazyListState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$lazyListState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        /* JADX WARN: Code duplicated, block: B:13:0x0040 A[RETURN] */
                                        /* JADX WARN: Code duplicated, block: B:14:0x0041  */
                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object $result) {
                                            AnonymousClass1 anonymousClass1;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    anonymousClass1 = this;
                                                    anonymousClass1.label = 1;
                                                    if (DelayKt.delay(50L, anonymousClass1) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    anonymousClass1.label = 2;
                                                    if (LazyListState.animateScrollToItem$default(anonymousClass1.$lazyListState, 0, 0, anonymousClass1, 2, null) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    return Unit.INSTANCE;
                                                case 1:
                                                    anonymousClass1 = this;
                                                    ResultKt.throwOnFailure($result);
                                                    anonymousClass1.label = 2;
                                                    if (LazyListState.animateScrollToItem$default(anonymousClass1.$lazyListState, 0, 0, anonymousClass1, 2, null) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    return Unit.INSTANCE;
                                                case 2:
                                                    ResultKt.throwOnFailure($result);
                                                    return Unit.INSTANCE;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }
                                    }
                                }, Modifier.INSTANCE, false, null, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7498getLambda2$app_debug(), $composer, 1573248, 56);
                            }
                            $composer.endReplaceGroup();
                            $composer.startReplaceGroup(756710638);
                            ComposerKt.sourceInformation($composer, "CC(remember):VideoListPage.kt#9igjgp");
                            Object it$iv = $composer.rememberedValue();
                            if (it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            final MutableState expanded$delegate = (MutableState) value$iv;
                            $composer.endReplaceGroup();
                            Modifier modifier$iv2 = SizeKt.wrapContentSize$default(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd(), false, 2, null);
                            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv2 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                function1 = constructor2;
                                $composer.createNode(function1);
                            } else {
                                function1 = constructor2;
                                $composer.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i4 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -1667302567, "C332@13754L19,332@13733L403,342@14283L20,342@14305L1589,340@14165L1729:VideoListPage.kt#861hqi");
                            $composer.startReplaceGroup(-1667302546);
                            ComposerKt.sourceInformation($composer, "CC(remember):VideoListPage.kt#9igjgp");
                            Object value$iv3 = $composer.rememberedValue();
                            if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$1$1
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
                                        VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(expanded$delegate, true);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv3, null, false, null, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7499getLambda3$app_debug(), $composer, 196614, 30);
                            boolean zInvoke$lambda$6$lambda$1 = invoke$lambda$6$lambda$1(expanded$delegate);
                            $composer.startReplaceGroup(-1667302017);
                            ComposerKt.sourceInformation($composer, "CC(remember):VideoListPage.kt#9igjgp");
                            Object it$iv2 = $composer.rememberedValue();
                            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$2$1
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
                                        VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(expanded$delegate, false);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            AndroidMenu_androidKt.m1666DropdownMenuIlH_yew(zInvoke$lambda$6$lambda$1, (Function0) value$iv2, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1754886808, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                    invoke(columnScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ColumnScope DropdownMenu, Composer $composer2, int $changed2) {
                                    Object value$iv4;
                                    Object value$iv5;
                                    Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                    ComposerKt.sourceInformation($composer2, "C365@15703L160,357@15203L661:VideoListPage.kt#861hqi");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1754886808, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:343)");
                                        }
                                        $composer2.startReplaceGroup(-524873256);
                                        ComposerKt.sourceInformation($composer2, "352@14963L172,344@14412L724");
                                        if (mutableIntState.getIntValue() > 0) {
                                            Function2<Composer, Integer, Unit> function2M7500getLambda4$app_debug = ComposableSingletons$VideoListPageKt.INSTANCE.m7500getLambda4$app_debug();
                                            $composer2.startReplaceGroup(-524872632);
                                            ComposerKt.sourceInformation($composer2, "CC(remember):VideoListPage.kt#9igjgp");
                                            final MutableState<Boolean> mutableState3 = mutableState;
                                            final MutableState<Boolean> mutableState4 = expanded$delegate;
                                            Object it$iv3 = $composer2.rememberedValue();
                                            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$3$1$1
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
                                                        VideoListPageKt.VideoListPage$lambda$17(mutableState3, true);
                                                        VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(mutableState4, false);
                                                    }
                                                };
                                                $composer2.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv3;
                                            }
                                            $composer2.endReplaceGroup();
                                            AndroidMenu_androidKt.DropdownMenuItem(function2M7500getLambda4$app_debug, (Function0) value$iv5, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7501getLambda5$app_debug(), null, false, null, null, null, $composer2, 3126, 500);
                                        }
                                        $composer2.endReplaceGroup();
                                        Function2<Composer, Integer, Unit> function2M7502getLambda6$app_debug = ComposableSingletons$VideoListPageKt.INSTANCE.m7502getLambda6$app_debug();
                                        $composer2.startReplaceGroup(-524871892);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):VideoListPage.kt#9igjgp");
                                        final MutableState<Boolean> mutableState5 = mutableState2;
                                        final MutableState<Boolean> mutableState6 = expanded$delegate;
                                        Object it$iv4 = $composer2.rememberedValue();
                                        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$3$2$1
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
                                                    VideoListPageKt.VideoListPage$lambda$20(mutableState5, true);
                                                    VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(mutableState6, false);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv4);
                                        } else {
                                            value$iv4 = it$iv4;
                                        }
                                        $composer2.endReplaceGroup();
                                        AndroidMenu_androidKt.DropdownMenuItem(function2M7502getLambda6$app_debug, (Function0) value$iv4, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7503getLambda7$app_debug(), null, false, null, null, null, $composer2, 3126, 500);
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

                        private static final boolean invoke$lambda$6$lambda$1(MutableState<Boolean> mutableState) {
                            MutableState<Boolean> $this$getValue$iv = mutableState;
                            return $this$getValue$iv.getValue().booleanValue();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void invoke$lambda$6$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                            mutableState.setValue(Boolean.valueOf(value));
                        }
                    }
                }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-2134191132, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5
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
                        ComposerKt.sourceInformation($composer4, "C380@16222L2170,376@16046L2346:VideoListPage.kt#861hqi");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2134191132, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:376)");
                            }
                            boolean zVideoListPage$lambda$10 = VideoListPageKt.VideoListPage$lambda$10(isSelectEnabled$delegate);
                            EnterTransition enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            ExitTransition exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            final MutableIntState mutableIntState2 = mutableIntState;
                            final MutableIntState mutableIntState3 = selectedAudioCount;
                            final SnapshotStateList<Integer> snapshotStateList = selectedItemIds;
                            final State<ToggleableState> state = checkBoxState$delegate;
                            final View view2 = view;
                            final List<DownloadedVideoInfo> list3 = list;
                            final State<VideoListViewModel.VideoListViewState> state2 = viewState$delegate;
                            final State<Set<String>> state3 = filterSet$delegate;
                            final MutableState<Boolean> mutableState = showRemoveMultipleItemsDialog$delegate;
                            AnimatedVisibilityKt.AnimatedVisibility(zVideoListPage$lambda$10, (Modifier) null, enterTransitionPlus, exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(-1648453444, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1
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
                                    ComposerKt.sourceInformation($composer5, "C383@16312L2066,381@16240L2138:VideoListPage.kt#861hqi");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1648453444, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous> (VideoListPage.kt:381)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    final MutableIntState mutableIntState4 = mutableIntState2;
                                    final MutableIntState mutableIntState5 = mutableIntState3;
                                    final SnapshotStateList<Integer> snapshotStateList2 = snapshotStateList;
                                    final State<ToggleableState> state4 = state;
                                    final View view3 = view2;
                                    final List<DownloadedVideoInfo> list4 = list3;
                                    final State<VideoListViewModel.VideoListViewState> state5 = state2;
                                    final State<Set<String>> state6 = state3;
                                    final MutableState<Boolean> mutableState2 = mutableState;
                                    AppBarKt.m1667BottomAppBar1oL4kX8(companion, 0L, 0L, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(-1315134284, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1.1
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
                                            Object value$iv25;
                                            Intrinsics.checkNotNullParameter(BottomAppBar, "$this$BottomAppBar");
                                            ComposerKt.sourceInformation($composer6, "C384@16354L35,386@16482L95,385@16410L1014,*408@17538L47,412@17780L10,406@17445L378,414@17844L516:VideoListPage.kt#861hqi");
                                            int $dirty4 = $changed4;
                                            if (($changed4 & 14) == 0) {
                                                $dirty4 |= $composer6.changed(BottomAppBar) ? 4 : 2;
                                            }
                                            int $dirty5 = $dirty4;
                                            if (($dirty5 & 91) == 18 && $composer6.getSkipping()) {
                                                $composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1315134284, $dirty5, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:384)");
                                            }
                                            final String selectAllText = StringResources_androidKt.stringResource(R.string.select_all, $composer6, 0);
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            $composer6.startReplaceGroup(756713589);
                                            ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                            boolean invalid$iv9 = $composer6.changed(selectAllText);
                                            Object it$iv22 = $composer6.rememberedValue();
                                            if (invalid$iv9 || it$iv22 == Composer.INSTANCE.getEmpty()) {
                                                value$iv25 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$5$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                        invoke2(semanticsPropertyReceiver);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                        SemanticsPropertiesKt.setContentDescription(semantics, selectAllText);
                                                    }
                                                };
                                                $composer6.updateRememberedValue(value$iv25);
                                            } else {
                                                value$iv25 = it$iv22;
                                            }
                                            $composer6.endReplaceGroup();
                                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv25, 1, null);
                                            ToggleableState toggleableStateVideoListPage$lambda$34 = VideoListPageKt.VideoListPage$lambda$34(state4);
                                            final View view4 = view3;
                                            final SnapshotStateList<Integer> snapshotStateList3 = snapshotStateList2;
                                            final List<DownloadedVideoInfo> list5 = list4;
                                            final State<ToggleableState> state7 = state4;
                                            final State<VideoListViewModel.VideoListViewState> state8 = state5;
                                            final State<Set<String>> state9 = state6;
                                            CheckboxKt.TriStateCheckbox(toggleableStateVideoListPage$lambda$34, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1.1.2

                                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$5$1$1$2$WhenMappings */
                                                /* JADX INFO: compiled from: VideoListPage.kt */
                                                @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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
                                                public /* bridge */ /* synthetic */ Unit invoke() throws Throwable {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() throws Throwable {
                                                    HapticFeedback.INSTANCE.slightHapticFeedback(view4);
                                                    if (WhenMappings.$EnumSwitchMapping$0[VideoListPageKt.VideoListPage$lambda$34(state7).ordinal()] != 1) {
                                                        for (DownloadedVideoInfo item : list5) {
                                                            if (!snapshotStateList3.contains(Integer.valueOf(item.getId())) && VideoListPageKt.filterSort(item, VideoListPageKt.VideoListPage$lambda$0(state8), VideoListPageKt.VideoListPage$lambda$3(state9))) {
                                                                snapshotStateList3.add(Integer.valueOf(item.getId()));
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    snapshotStateList3.clear();
                                                }
                                            }, modifierSemantics$default, false, null, null, $composer6, 0, 56);
                                            Modifier modifierWeight$default = RowScope.CC.weight$default(BottomAppBar, Modifier.INSTANCE, 1.0f, false, 2, null);
                                            String str2 = String.format(StringResources_androidKt.stringResource(R.string.multiselect_item_count, $composer6, 0), Arrays.copyOf(new Object[]{Integer.valueOf(mutableIntState4.getIntValue()), Integer.valueOf(mutableIntState5.getIntValue())}, 2));
                                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                                            TextKt.m2569Text4IGK_g(str2, modifierWeight$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer6, MaterialTheme.$stable).getLabelLarge(), $composer6, 0, 0, 65532);
                                            final View view5 = view3;
                                            final MutableState<Boolean> mutableState3 = mutableState2;
                                            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1.1.3
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
                                                    VideoListPageKt.VideoListPage$lambda$14(mutableState3, true);
                                                }
                                            }, null, !snapshotStateList2.isEmpty(), null, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7504getLambda8$app_debug(), $composer6, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, $composer5, 54), $composer5, 1572870, 62);
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
                }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(712769317, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.6
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C430@18441L35:VideoListPage.kt#861hqi");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(712769317, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:430)");
                        }
                        SnackbarHostKt.SnackbarHost(hostState3, null, null, $composer4, 6, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2004580654, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) throws SVGParseException {
                        invoke(paddingValues, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PaddingValues innerPadding, Composer $composer4, int $changed2) throws SVGParseException {
                        Object value$iv25;
                        Function0<ComposeUiNode> function0;
                        Function0<ComposeUiNode> function1;
                        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
                        ComposerKt.sourceInformation($composer4, "C454@19411L7,458@19561L27,459@19597L3603:VideoListPage.kt#861hqi");
                        int $dirty4 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty4 |= $composer4.changed(innerPadding) ? 4 : 2;
                        }
                        int $dirty5 = $dirty4;
                        if (($dirty5 & 91) != 18 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2004580654, $dirty5, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:433)");
                            }
                            $composer4.startReplaceGroup(-777824088);
                            ComposerKt.sourceInformation($composer4, "434@18560L797");
                            if (VideoListPageKt.VideoListPage$lambda$1(fullVideoList$delegate).isEmpty()) {
                                Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                int i4 = ((6 >> 6) & 112) | 6;
                                BoxScope $this$invoke_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer4, -705205814, "C437@18648L695:VideoListPage.kt#861hqi");
                                Modifier modifier$iv2 = $this$invoke_u24lambda_u241.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
                                ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
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
                                    function1 = constructor2;
                                    $composer4.createNode(function1);
                                } else {
                                    function1 = constructor2;
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
                                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int i6 = ((384 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, 756715939, "C441@18832L224,447@19114L44,448@19206L10,449@19275L11,446@19077L248:VideoListPage.kt#861hqi");
                                AsyncImageImplKt.m7098SVGImagegl8XCv8(VideoStreamSVG.VideoStreamSVG, null, PaddingKt.m621paddingVpY3zN4(Modifier.INSTANCE, Dp.m6553constructorimpl(72), Dp.m6553constructorimpl(20)), null, null, null, null, 0.0f, null, 0, null, false, $composer4, 438, 0, 4088);
                                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.no_downloaded_media, $composer4, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 0, 0, 65530);
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
                            }
                            $composer4.endReplaceGroup();
                            ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = com.videshkarmakar.loop.ui.common.CompositionLocalsKt.getLocalWindowWidthState();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume5 = $composer4.consume(localWindowWidthState);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            final int cellCount = WindowWidthSizeClass.m3491equalsimpl0(((WindowWidthSizeClass) objConsume5).getValue(), WindowWidthSizeClass.INSTANCE.m3500getExpandedY0FxcvE()) ? 2 : 1;
                            $composer4.startReplaceGroup(-777823046);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoListPage.kt#9igjgp");
                            boolean invalid$iv9 = $composer4.changed(cellCount);
                            Object it$iv22 = $composer4.rememberedValue();
                            if (invalid$iv9 || it$iv22 == Composer.INSTANCE.getEmpty()) {
                                value$iv25 = new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$span$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                        return GridItemSpan.m734boximpl(m7506invokeBHJflc(lazyGridItemSpanScope));
                                    }

                                    /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                    public final long m7506invokeBHJflc(LazyGridItemSpanScope it4) {
                                        Intrinsics.checkNotNullParameter(it4, "it");
                                        return LazyGridSpanKt.GridItemSpan(cellCount);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv25);
                            } else {
                                value$iv25 = it$iv22;
                            }
                            $composer4.endReplaceGroup();
                            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, innerPadding);
                            LazyListState lazyListState2 = lazyListState;
                            final List<DownloadedVideoInfo> list3 = list;
                            final State<List<DownloadedVideoInfo>> state = fullVideoList$delegate;
                            final State<VideoListViewModel.VideoListViewState> state2 = viewState$delegate;
                            final VideoListViewModel videoListViewModel = viewModel3;
                            final State<Set<String>> state3 = filterSet$delegate;
                            final SnapshotStateList<Integer> snapshotStateList = selectedItemIds;
                            final State<Map<Integer, Long>> state4 = fileSizeMap$delegate;
                            final MutableState<Boolean> mutableState = isSelectEnabled$delegate;
                            final View view2 = view;
                            final CoroutineScope coroutineScope = scope;
                            final MutableState<DownloadedVideoInfo> mutableState2 = currentVideoInfo$delegate;
                            final ModalBottomSheetState modalBottomSheetState = sheetState;
                            final MutableState<Boolean> mutableState3 = showBottomSheet$delegate;
                            LazyDslKt.LazyColumn(modifierPadding, lazyListState2, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2
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
                                    if (!VideoListPageKt.VideoListPage$lambda$1(state).isEmpty()) {
                                        final State<VideoListViewModel.VideoListViewState> state5 = state2;
                                        final VideoListViewModel videoListViewModel2 = videoListViewModel;
                                        final State<Set<String>> state6 = state3;
                                        LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-793036257, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2.1
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
                                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                                ComposerKt.sourceInformation($composer5, "C465@19799L837:VideoListPage.kt#861hqi");
                                                if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-793036257, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:465)");
                                                    }
                                                    final State<VideoListViewModel.VideoListViewState> state7 = state5;
                                                    final VideoListViewModel videoListViewModel3 = videoListViewModel2;
                                                    State<Set<String>> state8 = state6;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                    Modifier modifier$iv3 = Modifier.INSTANCE;
                                                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                                    MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                                                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer5);
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                                    }
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                                    int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                                    ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -1667296468, "C466@19884L513,466@19832L565,476@20422L192:VideoListPage.kt#861hqi");
                                                    AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u240, VideoListPageKt.VideoListPage$lambda$0(state7).isSearching(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1037365615, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                                            invoke(animatedVisibilityScope, composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer6, int $changed4) {
                                                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                            ComposerKt.sourceInformation($composer6, "C472@20220L44,467@19914L457:VideoListPage.kt#861hqi");
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1037365615, $changed4, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:467)");
                                                            }
                                                            SearchBarKt.LoopSearchBar(PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(8), 1, null), VideoListPageKt.VideoListPage$lambda$0(state7).getSearchText(), StringResources_androidKt.stringResource(R.string.search_in_downloads, $composer6, 0), new AnonymousClass1(videoListViewModel3), $composer6, 6, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }

                                                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$1$1$1$1, reason: invalid class name */
                                                        /* JADX INFO: compiled from: VideoListPage.kt */
                                                        @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
                                                            AnonymousClass1(Object obj) {
                                                                super(1, obj, VideoListViewModel.class, "updateSearchText", "updateSearchText(Ljava/lang/String;)V", 0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                                                invoke2(str);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(String p0) {
                                                                Intrinsics.checkNotNullParameter(p0, "p0");
                                                                ((VideoListViewModel) this.receiver).updateSearchText(p0);
                                                            }
                                                        }
                                                    }, $composer5, 54), $composer5, ((((0 >> 6) & 112) | 6) & 14) | 1572864, 30);
                                                    Modifier materialized$iv$iv4 = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6553constructorimpl(8), 1, null);
                                                    VideoListPageKt.VideoListPage$FilterChips(state7, videoListViewModel3, state8, materialized$iv$iv4, $composer5, 6, 0);
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
                                        }), 3, null);
                                    }
                                    Iterator<DownloadedVideoInfo> it4 = list3.iterator();
                                    while (it4.hasNext()) {
                                        final DownloadedVideoInfo info3 = it4.next();
                                        Integer numValueOf = Integer.valueOf(info3.getId());
                                        Function0<Boolean> function2 = new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2.2
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                return Boolean.valueOf(StringsKt.contains$default((CharSequence) info3.getVideoPath(), (CharSequence) FileUtilKt.AUDIO_REGEX, false, 2, (Object) null));
                                            }
                                        };
                                        final State<VideoListViewModel.VideoListViewState> state7 = state2;
                                        final State<Set<String>> state8 = state3;
                                        final SnapshotStateList<Integer> snapshotStateList2 = snapshotStateList;
                                        final State<Map<Integer, Long>> state9 = state4;
                                        final MutableState<Boolean> mutableState4 = mutableState;
                                        final View view3 = view2;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final MutableState<DownloadedVideoInfo> mutableState5 = mutableState2;
                                        final ModalBottomSheetState modalBottomSheetState2 = modalBottomSheetState;
                                        Iterator<DownloadedVideoInfo> it5 = it4;
                                        final MutableState<Boolean> mutableState6 = mutableState3;
                                        LazyColumn.item(numValueOf, function2, ComposableLambdaKt.composableLambdaInstance(-1214027848, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2.3
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
                                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                                ComposerKt.sourceInformation($composer5, "C*495@21205L1930,490@20900L2235:VideoListPage.kt#861hqi");
                                                if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1214027848, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:489)");
                                                    }
                                                    final DownloadedVideoInfo $this$invoke_u24lambda_u240 = info3;
                                                    final DownloadedVideoInfo downloadedVideoInfo = info3;
                                                    State<VideoListViewModel.VideoListViewState> state10 = state7;
                                                    State<Set<String>> state11 = state8;
                                                    final SnapshotStateList<Integer> snapshotStateList3 = snapshotStateList2;
                                                    final State<Map<Integer, Long>> state12 = state9;
                                                    final MutableState<Boolean> mutableState7 = mutableState4;
                                                    final View view4 = view3;
                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                    final MutableState<DownloadedVideoInfo> mutableState8 = mutableState5;
                                                    final ModalBottomSheetState modalBottomSheetState3 = modalBottomSheetState2;
                                                    final MutableState<Boolean> mutableState9 = mutableState6;
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    boolean zFilterSort = VideoListPageKt.filterSort(downloadedVideoInfo, VideoListPageKt.VideoListPage$lambda$0(state10), VideoListPageKt.VideoListPage$lambda$3(state11));
                                                    ExitTransition exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                                                    AnimatedVisibilityKt.AnimatedVisibility(zFilterSort, companion, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)), exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(-972331624, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1
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

                                                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer6, int $changed4) {
                                                            Object value$iv26;
                                                            Object value$iv27;
                                                            Object value$iv28;
                                                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                            ComposerKt.sourceInformation($composer6, "C504@21710L19,505@21776L32,506@21853L275,512@22172L264,516@22452L154,496@21235L1874:VideoListPage.kt#861hqi");
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-972331624, $changed4, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:496)");
                                                            }
                                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                                            String videoTitle = $this$invoke_u24lambda_u240.getVideoTitle();
                                                            String videoAuthor = $this$invoke_u24lambda_u240.getVideoAuthor();
                                                            String thumbnailUrl = $this$invoke_u24lambda_u240.getThumbnailUrl();
                                                            String videoPath = $this$invoke_u24lambda_u240.getVideoPath();
                                                            Object obj = VideoListPageKt.VideoListPage$lambda$4(state12).get(Integer.valueOf($this$invoke_u24lambda_u240.getId()));
                                                            if (obj == null) {
                                                                obj = 0L;
                                                            }
                                                            long jLongValue = ((Number) obj).longValue();
                                                            String videoUrl = $this$invoke_u24lambda_u240.getVideoUrl();
                                                            Modifier.Companion companion3 = companion2;
                                                            $composer6.startReplaceGroup(-524865885);
                                                            ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                            final MutableState<Boolean> mutableState10 = mutableState7;
                                                            Object it$iv23 = $composer6.rememberedValue();
                                                            if (it$iv23 == Composer.INSTANCE.getEmpty()) {
                                                                value$iv26 = new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$2$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        return Boolean.valueOf(VideoListPageKt.VideoListPage$lambda$10(mutableState10));
                                                                    }
                                                                };
                                                                $composer6.updateRememberedValue(value$iv26);
                                                            } else {
                                                                value$iv26 = it$iv23;
                                                            }
                                                            Function0 function3 = (Function0) value$iv26;
                                                            $composer6.endReplaceGroup();
                                                            $composer6.startReplaceGroup(-524865819);
                                                            ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                            boolean invalid$iv10 = $composer6.changed(snapshotStateList3) | $composer6.changed($this$invoke_u24lambda_u240);
                                                            final SnapshotStateList<Integer> snapshotStateList4 = snapshotStateList3;
                                                            final DownloadedVideoInfo downloadedVideoInfo2 = $this$invoke_u24lambda_u240;
                                                            Object value$iv29 = $composer6.rememberedValue();
                                                            if (invalid$iv10 || value$iv29 == Composer.INSTANCE.getEmpty()) {
                                                                value$iv29 = (Function0) new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$3$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        return Boolean.valueOf(snapshotStateList4.contains(Integer.valueOf(downloadedVideoInfo2.getId())));
                                                                    }
                                                                };
                                                                $composer6.updateRememberedValue(value$iv29);
                                                            }
                                                            Function0 function4 = (Function0) value$iv29;
                                                            $composer6.endReplaceGroup();
                                                            $composer6.startReplaceGroup(-524865742);
                                                            ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                            boolean invalid$iv11 = $composer6.changed(snapshotStateList3) | $composer6.changed($this$invoke_u24lambda_u240);
                                                            final SnapshotStateList<Integer> snapshotStateList5 = snapshotStateList3;
                                                            final DownloadedVideoInfo downloadedVideoInfo3 = $this$invoke_u24lambda_u240;
                                                            Object value$iv30 = $composer6.rememberedValue();
                                                            if (invalid$iv11 || value$iv30 == Composer.INSTANCE.getEmpty()) {
                                                                value$iv30 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$4$1
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
                                                                        if (snapshotStateList5.contains(Integer.valueOf(downloadedVideoInfo3.getId()))) {
                                                                            snapshotStateList5.remove(Integer.valueOf(downloadedVideoInfo3.getId()));
                                                                        } else {
                                                                            snapshotStateList5.add(Integer.valueOf(downloadedVideoInfo3.getId()));
                                                                        }
                                                                    }
                                                                };
                                                                $composer6.updateRememberedValue(value$iv30);
                                                            }
                                                            Function0 function5 = (Function0) value$iv30;
                                                            $composer6.endReplaceGroup();
                                                            $composer6.startReplaceGroup(-524865423);
                                                            ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                            boolean invalid$iv12 = $composer6.changed($this$invoke_u24lambda_u240);
                                                            final DownloadedVideoInfo downloadedVideoInfo4 = $this$invoke_u24lambda_u240;
                                                            Object it$iv24 = $composer6.rememberedValue();
                                                            if (invalid$iv12 || it$iv24 == Composer.INSTANCE.getEmpty()) {
                                                                value$iv27 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$5$1
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
                                                                        Unit unit;
                                                                        FileUtil fileUtil = FileUtil.INSTANCE;
                                                                        String path$iv = downloadedVideoInfo4.getVideoPath();
                                                                        try {
                                                                            Result.Companion companion4 = Result.INSTANCE;
                                                                            Intent $this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv = FileUtil.INSTANCE.createIntentForOpeningFile(path$iv);
                                                                            if ($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv != null) {
                                                                                App.INSTANCE.getContext().startActivity($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv);
                                                                                unit = Unit.INSTANCE;
                                                                            } else {
                                                                                unit = null;
                                                                            }
                                                                            if (unit != null) {
                                                                                objM7557constructorimpl = Result.m7557constructorimpl(Unit.INSTANCE);
                                                                                if (Result.m7560exceptionOrNullimpl(objM7557constructorimpl) != null) {
                                                                                    ToastUtil toastUtil = ToastUtil.INSTANCE;
                                                                                    String string = App.INSTANCE.getContext().getString(R.string.file_unavailable);
                                                                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                                                    toastUtil.makeToastSuspend(string);
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            throw new Exception();
                                                                        } catch (Throwable th) {
                                                                            Result.Companion companion5 = Result.INSTANCE;
                                                                            objM7557constructorimpl = Result.m7557constructorimpl(ResultKt.createFailure(th));
                                                                        }
                                                                    }
                                                                };
                                                                $composer6.updateRememberedValue(value$iv27);
                                                            } else {
                                                                value$iv27 = it$iv24;
                                                            }
                                                            Function0 function6 = (Function0) value$iv27;
                                                            $composer6.endReplaceGroup();
                                                            $composer6.startReplaceGroup(-524865143);
                                                            ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                            boolean invalid$iv13 = $composer6.changed(snapshotStateList3) | $composer6.changed($this$invoke_u24lambda_u240);
                                                            final SnapshotStateList<Integer> snapshotStateList6 = snapshotStateList3;
                                                            final DownloadedVideoInfo downloadedVideoInfo5 = $this$invoke_u24lambda_u240;
                                                            final MutableState<Boolean> mutableState11 = mutableState7;
                                                            Object it$iv25 = $composer6.rememberedValue();
                                                            if (invalid$iv13 || it$iv25 == Composer.INSTANCE.getEmpty()) {
                                                                value$iv28 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$6$1
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
                                                                        VideoListPageKt.VideoListPage$lambda$11(mutableState11, true);
                                                                        snapshotStateList6.add(Integer.valueOf(downloadedVideoInfo5.getId()));
                                                                    }
                                                                };
                                                                $composer6.updateRememberedValue(value$iv28);
                                                            } else {
                                                                value$iv28 = it$iv25;
                                                            }
                                                            $composer6.endReplaceGroup();
                                                            final View view5 = view4;
                                                            final DownloadedVideoInfo downloadedVideoInfo6 = downloadedVideoInfo;
                                                            final CoroutineScope coroutineScope4 = coroutineScope3;
                                                            final MutableState<DownloadedVideoInfo> mutableState12 = mutableState8;
                                                            final ModalBottomSheetState modalBottomSheetState4 = modalBottomSheetState3;
                                                            final MutableState<Boolean> mutableState13 = mutableState9;
                                                            VideoListItemKt.MediaListItem(companion3, videoTitle, videoAuthor, thumbnailUrl, videoPath, videoUrl, jLongValue, function3, function4, function5, function6, (Function0) value$iv28, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1.7
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
                                                                    mutableState12.setValue(downloadedVideoInfo6);
                                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(modalBottomSheetState4, mutableState13, null), 3, null);
                                                                }

                                                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$7$1, reason: invalid class name */
                                                                /* JADX INFO: compiled from: VideoListPage.kt */
                                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                                @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$7$1", f = "VideoListPage.kt", i = {}, l = {526, 527}, m = "invokeSuspend", n = {}, s = {})
                                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                                    final /* synthetic */ MutableState<Boolean> $showBottomSheet$delegate;
                                                                    int label;

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    AnonymousClass1(ModalBottomSheetState modalBottomSheetState, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                                                                        super(2, continuation);
                                                                        this.$sheetState = modalBottomSheetState;
                                                                        this.$showBottomSheet$delegate = mutableState;
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                        return new AnonymousClass1(this.$sheetState, this.$showBottomSheet$delegate, continuation);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                    }

                                                                    /* JADX WARN: Code duplicated, block: B:13:0x0041 A[RETURN] */
                                                                    /* JADX WARN: Code duplicated, block: B:14:0x0042  */
                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Object invokeSuspend(Object $result) {
                                                                        AnonymousClass1 anonymousClass1;
                                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                        switch (this.label) {
                                                                            case 0:
                                                                                ResultKt.throwOnFailure($result);
                                                                                anonymousClass1 = this;
                                                                                VideoListPageKt.VideoListPage$lambda$40(anonymousClass1.$showBottomSheet$delegate, true);
                                                                                anonymousClass1.label = 1;
                                                                                if (DelayKt.delay(50L, anonymousClass1) == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                                anonymousClass1.label = 2;
                                                                                if (anonymousClass1.$sheetState.show(anonymousClass1) == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case 1:
                                                                                anonymousClass1 = this;
                                                                                ResultKt.throwOnFailure($result);
                                                                                anonymousClass1.label = 2;
                                                                                if (anonymousClass1.$sheetState.show(anonymousClass1) == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case 2:
                                                                                ResultKt.throwOnFailure($result);
                                                                                return Unit.INSTANCE;
                                                                            default:
                                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                        }
                                                                    }
                                                                }
                                                            }, $composer6, 12582918, 0, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, $composer5, 54), $composer5, 200112, 16);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }));
                                        it4 = it5;
                                    }
                                }
                            }, $composer4, 0, 252);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54), $composer2, 805309872, 496);
                $composer2.startReplaceGroup(1093415135);
                ComposerKt.sourceInformation($composer2, "552@23660L27,543@23315L373");
                if (VideoListPage$lambda$39(showBottomSheet$delegate)) {
                    l = VideoListPage$lambda$4(fileSizeMap$delegate).get(Integer.valueOf(VideoListPage$lambda$7(currentVideoInfo$delegate).getId()));
                    if (l == null && l.longValue() == 0) {
                        isFileAvailable = false;
                    } else {
                        isFileAvailable = true;
                    }
                    DownloadedVideoInfo downloadedVideoInfoVideoListPage$lambda$7 = VideoListPage$lambda$7(currentVideoInfo$delegate);
                    scope = scope;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$8$1, reason: invalid class name */
                        /* JADX INFO: compiled from: VideoListPage.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$8$1", f = "VideoListPage.kt", i = {}, l = {549}, m = "invokeSuspend", n = {}, s = {})
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ModalBottomSheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$sheetState = modalBottomSheetState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$sheetState, continuation);
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
                                        this.label = 1;
                                        if (this.$sheetState.hide(this) == coroutine_suspended) {
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
                            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(sheetState, null), 3, null);
                            final MutableState<Boolean> mutableState = showBottomSheet$delegate;
                            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.8.2
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
                                public final void invoke2(Throwable it4) {
                                    VideoListPageKt.VideoListPage$lambda$40(mutableState, false);
                                }
                            });
                        }
                    };
                    $composer2.startReplaceGroup(1093415580);
                    str = "CC(remember):VideoListPage.kt#9igjgp";
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv15 = $composer2.rememberedValue();
                    if (it$iv15 == Composer.INSTANCE.getEmpty()) {
                        showRemoveDialog$delegate2 = showRemoveDialog$delegate;
                        value$iv24 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$9$1
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
                                VideoListPageKt.VideoListPage$lambda$37(showRemoveDialog$delegate2, true);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv24);
                    } else {
                        showRemoveDialog$delegate2 = showRemoveDialog$delegate;
                        value$iv24 = it$iv15;
                    }
                    $composer2.endReplaceGroup();
                    showBottomSheet$delegate2 = showBottomSheet$delegate;
                    sheetState2 = sheetState;
                    VideoDetailDrawerKt.VideoDetailDrawer(sheetState, downloadedVideoInfoVideoListPage$lambda$7, isFileAvailable, function0, (Function0) value$iv24, $composer2, ModalBottomSheetState.$stable | CpioConstants.C_ISBLK, 0);
                } else {
                    showBottomSheet$delegate2 = showBottomSheet$delegate;
                    showRemoveDialog$delegate2 = showRemoveDialog$delegate;
                    str = "CC(remember):VideoListPage.kt#9igjgp";
                    sheetState2 = sheetState;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(1093415638);
                ComposerKt.sourceInformation($composer2, str);
                it$iv9 = $composer2.rememberedValue();
                if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                    value$iv17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer2.updateRememberedValue(value$iv17);
                } else {
                    value$iv17 = it$iv9;
                }
                deleteFile$delegate = (MutableState) value$iv17;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(1093415678);
                ComposerKt.sourceInformation($composer2, "561@23916L19,567@24160L56,558@23790L427");
                if (VideoListPage$lambda$36(showRemoveDialog$delegate2)) {
                    DownloadedVideoInfo downloadedVideoInfoVideoListPage$lambda$8 = VideoListPage$lambda$7(currentVideoInfo$delegate);
                    boolean zVideoListPage$lambda$44 = VideoListPage$lambda$44(deleteFile$delegate);
                    $composer2.startReplaceGroup(1093415836);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv14 = $composer2.rememberedValue();
                    if (it$iv14 == Composer.INSTANCE.getEmpty()) {
                        value$iv22 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$10$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean it4) {
                                VideoListPageKt.VideoListPage$lambda$45(deleteFile$delegate, it4);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv22);
                    } else {
                        value$iv22 = it$iv14;
                    }
                    Function1 function1 = (Function1) value$iv22;
                    $composer2.endReplaceGroup();
                    Function1<Boolean, Unit> function2 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.11
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean it4) {
                            viewModel3.deleteDownloadHistory(CollectionsKt.listOf(VideoListPageKt.VideoListPage$lambda$7(currentVideoInfo$delegate)), VideoListPageKt.VideoListPage$lambda$44(deleteFile$delegate));
                        }
                    };
                    $composer2.startReplaceGroup(1093416080);
                    ComposerKt.sourceInformation($composer2, str);
                    value$iv23 = $composer2.rememberedValue();
                    if (value$iv23 == Composer.INSTANCE.getEmpty()) {
                        value$iv23 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$12$1
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
                                VideoListPageKt.VideoListPage$lambda$37(showRemoveDialog$delegate2, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv23);
                    }
                    Function0 function3 = (Function0) value$iv23;
                    $composer2.endReplaceGroup();
                    viewModel4 = viewModel3;
                    RemoveItemDialogKt.RemoveItemDialog(zVideoListPage$lambda$44, function1, downloadedVideoInfoVideoListPage$lambda$8, function2, function3, $composer2, 24624, 0);
                } else {
                    viewModel4 = viewModel3;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(1093416149);
                ComposerKt.sourceInformation($composer2, "574@24317L41,592@25252L408,603@25678L123,576@24498L736,573@24274L1537");
                if (VideoListPage$lambda$13(showRemoveMultipleItemsDialog$delegate)) {
                    $composer2.startReplaceGroup(1093416237);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv13 = $composer2.rememberedValue();
                    if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                        showRemoveMultipleItemsDialog$delegate2 = showRemoveMultipleItemsDialog$delegate;
                        value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$13$1
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
                                VideoListPageKt.VideoListPage$lambda$14(showRemoveMultipleItemsDialog$delegate2, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv21);
                    } else {
                        showRemoveMultipleItemsDialog$delegate2 = showRemoveMultipleItemsDialog$delegate;
                        value$iv21 = it$iv13;
                    }
                    Function0 function4 = (Function0) value$iv21;
                    $composer2.endReplaceGroup();
                    final VideoListViewModel videoListViewModel = viewModel4;
                    final MutableState mutableState = showRemoveMultipleItemsDialog$delegate2;
                    selectedItemIds2 = selectedItemIds;
                    selectedFileSizeSum$delegate4 = selectedFileSizeSum$delegate3;
                    DialogsKt.m7162LoopDialogOix01E0(null, function4, ComposableLambdaKt.rememberComposableLambda(1269829965, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.14
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
                            ComposerKt.sourceInformation($composer4, "C593@25270L376:VideoListPage.kt#861hqi");
                            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1269829965, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:593)");
                                }
                                final VideoListViewModel videoListViewModel2 = videoListViewModel;
                                final List<DownloadedVideoInfo> list3 = list;
                                final SnapshotStateList<Integer> snapshotStateList = selectedItemIds;
                                final MutableState<Boolean> mutableState2 = deleteFile$delegate;
                                final MutableState<Boolean> mutableState3 = mutableState;
                                final MutableState<Boolean> mutableState4 = isSelectEnabled$delegate;
                                ButtonsKt.ConfirmButton(null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.14.1
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
                                        VideoListViewModel videoListViewModel3 = videoListViewModel2;
                                        Iterable $this$filter$iv2 = list3;
                                        SnapshotStateList<Integer> snapshotStateList2 = snapshotStateList;
                                        Collection destination$iv$iv4 = new ArrayList();
                                        for (Object element$iv$iv : $this$filter$iv2) {
                                            DownloadedVideoInfo it4 = (DownloadedVideoInfo) element$iv$iv;
                                            if (snapshotStateList2.contains(Integer.valueOf(it4.getId()))) {
                                                destination$iv$iv4.add(element$iv$iv);
                                            }
                                        }
                                        videoListViewModel3.deleteDownloadHistory((List) destination$iv$iv4, VideoListPageKt.VideoListPage$lambda$44(mutableState2));
                                        VideoListPageKt.VideoListPage$lambda$14(mutableState3, false);
                                        VideoListPageKt.VideoListPage$lambda$11(mutableState4, false);
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
                    }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(1462761166, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.15
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
                            Object value$iv25;
                            ComposerKt.sourceInformation($composer4, "C604@25710L77,604@25696L91:VideoListPage.kt#861hqi");
                            if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1462761166, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:604)");
                            }
                            $composer4.startReplaceGroup(-777816897);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoListPage.kt#9igjgp");
                            final MutableState<Boolean> mutableState2 = showRemoveMultipleItemsDialog$delegate2;
                            Object it$iv22 = $composer4.rememberedValue();
                            if (it$iv22 == Composer.INSTANCE.getEmpty()) {
                                value$iv25 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$15$1$1
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
                                        VideoListPageKt.VideoListPage$lambda$14(mutableState2, false);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv25);
                            } else {
                                value$iv25 = it$iv22;
                            }
                            $composer4.endReplaceGroup();
                            ButtonsKt.DismissButton(null, (Function0) value$iv25, $composer4, 48, 1);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54), ComposableSingletons$VideoListPageKt.INSTANCE.m7505getLambda9$app_debug(), ComposableSingletons$VideoListPageKt.INSTANCE.m7497getLambda10$app_debug(), ComposableLambdaKt.rememberComposableLambda(2041554769, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.16
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
                            Function0<ComposeUiNode> function5;
                            Object value$iv25;
                            ComposerKt.sourceInformation($composer4, "C577@24516L704:VideoListPage.kt#861hqi");
                            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2041554769, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:577)");
                                }
                                SnapshotStateList<Integer> snapshotStateList = selectedItemIds2;
                                State<Long> state = selectedFileSizeSum$delegate4;
                                final MutableState<Boolean> mutableState2 = deleteFile$delegate;
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
                                    function5 = constructor;
                                    $composer4.createNode(function5);
                                } else {
                                    function5 = constructor;
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
                                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int i4 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -705199917, "C*582@24728L50,578@24545L338,588@25022L36,588@25086L16,590@25174L28,586@24904L298:VideoListPage.kt#861hqi");
                                Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, 2, null);
                                String str2 = String.format(StringResources_androidKt.stringResource(R.string.delete_multiple_items_msg, $composer4, 0), Arrays.copyOf(new Object[]{Integer.valueOf(snapshotStateList.size())}, 1));
                                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                                TextKt.m2569Text4IGK_g(str2, modifierM622paddingVpY3zN4$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 48, 0, 131068);
                                Modifier modifierM622paddingVpY3zN4$default2 = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null);
                                String str3 = StringResources_androidKt.stringResource(R.string.delete_file, $composer4, 0) + " (" + TextUtilKt.toFileSizeText(Long.valueOf(VideoListPageKt.VideoListPage$lambda$30(state)), $composer4, 0) + ")";
                                boolean zVideoListPage$lambda$45 = VideoListPageKt.VideoListPage$lambda$44(mutableState2);
                                $composer4.startReplaceGroup(-705199288);
                                ComposerKt.sourceInformation($composer4, "CC(remember):VideoListPage.kt#9igjgp");
                                Object it$iv22 = $composer4.rememberedValue();
                                if (it$iv22 == Composer.INSTANCE.getEmpty()) {
                                    value$iv25 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$16$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean it4) {
                                            VideoListPageKt.VideoListPage$lambda$45(mutableState2, !VideoListPageKt.VideoListPage$lambda$44(mutableState2));
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv25);
                                } else {
                                    value$iv25 = it$iv22;
                                }
                                $composer4.endReplaceGroup();
                                DialogItemsKt.CheckBoxItem(modifierM622paddingVpY3zN4$default2, str3, zVideoListPage$lambda$45, (Function1) value$iv25, $composer4, 3078, 0);
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
                    }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797552, 0, 16257);
                } else {
                    selectedFileSizeSum$delegate4 = selectedFileSizeSum$delegate3;
                    selectedItemIds2 = selectedItemIds;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(1093417763);
                ComposerKt.sourceInformation($composer2, str);
                it$iv10 = $composer2.rememberedValue();
                if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                    value$iv18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    $composer2.updateRememberedValue(value$iv18);
                } else {
                    value$iv18 = it$iv10;
                }
                backupString$delegate = (MutableState) value$iv18;
                $composer2.endReplaceGroup();
                exportLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.CreateDocument("text/plain"), new Function1<Uri, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$exportLauncher$1
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
                            BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new VideoListPageKt$VideoListPage$exportLauncher$1$1$1(context, uri, backupString$delegate, showExportDialog$delegate, null), 2, null);
                        }
                    }
                }, $composer2, 8);
                $composer2.startReplaceGroup(1093418334);
                ComposerKt.sourceInformation($composer2, "636@26708L28,635@26663L632");
                if (VideoListPage$lambda$16(showExportDialog$delegate)) {
                    if (!selectedItemIds2.isEmpty()) {
                        destination$iv$iv2 = list;
                        destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv : destination$iv$iv2) {
                            it3 = (DownloadedVideoInfo) element$iv$iv;
                            Collection $this$filter$iv2 = destination$iv$iv2;
                            if (selectedItemIds2.contains(Integer.valueOf(it3.getId()))) {
                                destination$iv$iv3.add(element$iv$iv);
                            }
                            destination$iv$iv2 = $this$filter$iv2;
                        }
                        list2 = (List) destination$iv$iv3;
                        scope3 = scope;
                        selectedFileSizeSum$delegate5 = selectedFileSizeSum$delegate4;
                    } else {
                        $this$filter$iv = list;
                        $i$f$filter = 0;
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv2 : $this$filter$iv) {
                            Iterable $this$filter$iv3 = $this$filter$iv;
                            int $i$f$filter2 = $i$f$filter;
                            it2 = (DownloadedVideoInfo) element$iv$iv2;
                            CoroutineScope scope5 = scope;
                            State selectedFileSizeSum$delegate6 = selectedFileSizeSum$delegate4;
                            if (filterSort(it2, VideoListPage$lambda$0(viewState$delegate), VideoListPage$lambda$3(filterSet$delegate))) {
                                destination$iv$iv.add(element$iv$iv2);
                            }
                            $this$filter$iv = $this$filter$iv3;
                            $i$f$filter = $i$f$filter2;
                            selectedFileSizeSum$delegate4 = selectedFileSizeSum$delegate6;
                            scope = scope5;
                        }
                        scope3 = scope;
                        selectedFileSizeSum$delegate5 = selectedFileSizeSum$delegate4;
                        list2 = (List) destination$iv$iv;
                    }
                    int size4 = list2.size();
                    $composer2.startReplaceGroup(1093418628);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv12 = $composer2.rememberedValue();
                    if (it$iv12 == Composer.INSTANCE.getEmpty()) {
                        value$iv20 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$17$1
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
                                VideoListPageKt.VideoListPage$lambda$17(showExportDialog$delegate, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv20);
                    } else {
                        value$iv20 = it$iv12;
                    }
                    $composer2.endReplaceGroup();
                    context2 = context;
                    scope2 = scope3;
                    ExportImportDialogKt.ExportDialog(null, size4, (Function0) value$iv20, new Function2<BackupUtil.BackupType, BackupUtil.BackupDestination, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.18

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$18$WhenMappings */
                        /* JADX INFO: compiled from: VideoListPage.kt */
                        @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[BackupUtil.BackupDestination.values().length];
                                try {
                                    iArr[BackupUtil.BackupDestination.Clipboard.ordinal()] = 1;
                                } catch (NoSuchFieldError e) {
                                }
                                try {
                                    iArr[BackupUtil.BackupDestination.File.ordinal()] = 2;
                                } catch (NoSuchFieldError e2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(BackupUtil.BackupType backupType, BackupUtil.BackupDestination backupDestination) {
                            invoke2(backupType, backupDestination);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(BackupUtil.BackupType type, BackupUtil.BackupDestination destination) {
                            Intrinsics.checkNotNullParameter(type, "type");
                            Intrinsics.checkNotNullParameter(destination, "destination");
                            String it4 = VideoListPageKt.backupToString(list2, type);
                            ClipboardManager clipboardManager2 = clipboardManager;
                            ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher = exportLauncher;
                            Context context4 = context;
                            View view2 = view;
                            MutableState<String> mutableState2 = backupString$delegate;
                            MutableState<Boolean> mutableState3 = showExportDialog$delegate;
                            switch (WhenMappings.$EnumSwitchMapping$0[destination.ordinal()]) {
                                case 1:
                                    clipboardManager2.setText(new AnnotatedString(it4, null, null, 6, null));
                                    break;
                                case 2:
                                    VideoListPageKt.VideoListPage$lambda$51(mutableState2, it4);
                                    managedActivityResultLauncher.launch(BackupUtil.INSTANCE.getDownloadHistoryExportFilename(context4));
                                    break;
                            }
                            HapticFeedback.INSTANCE.slightHapticFeedback(view2);
                            VideoListPageKt.VideoListPage$lambda$17(mutableState3, false);
                        }
                    }, $composer2, 384, 1);
                } else {
                    context2 = context;
                    scope2 = scope;
                }
                $composer2.endReplaceGroup();
                context3 = context2;
                importLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.GetContent(), new Function1<Uri, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$importLauncher$1
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
                            VideoListViewModel videoListViewModel2 = viewModel4;
                            Context context4 = context3;
                            videoListViewModel2.importBackupFromUri(context4, uri, new VideoListPageKt$VideoListPage$importLauncher$1$1$1(videoListViewModel2, hostState3, context4, null));
                        }
                    }
                }, $composer2, 8);
                if (VideoListPage$lambda$19(showImportDialog$delegate)) {
                    $composer2.startReplaceGroup(1093419642);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv11 = $composer2.rememberedValue();
                    if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                        showImportDialog$delegate2 = showImportDialog$delegate;
                        value$iv19 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$19$1
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
                                VideoListPageKt.VideoListPage$lambda$20(showImportDialog$delegate2, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv19);
                    } else {
                        showImportDialog$delegate2 = showImportDialog$delegate;
                        value$iv19 = it$iv11;
                    }
                    $composer2.endReplaceGroup();
                    final CoroutineScope coroutineScope = scope2;
                    final VideoListViewModel videoListViewModel2 = viewModel4;
                    final MutableState mutableState2 = showImportDialog$delegate2;
                    ExportImportDialogKt.ImportDialog(null, (Function0) value$iv19, new Function1<BackupUtil.BackupDestination, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.20
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$20$1, reason: invalid class name */
                        /* JADX INFO: compiled from: VideoListPage.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$20$1", f = "VideoListPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ClipboardManager $clipboardManager;
                            final /* synthetic */ Context $context;
                            final /* synthetic */ BackupUtil.BackupDestination $destination;
                            final /* synthetic */ SnackbarHostState $hostState;
                            final /* synthetic */ ManagedActivityResultLauncher<String, Uri> $importLauncher;
                            final /* synthetic */ VideoListViewModel $viewModel;
                            int label;

                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$20$1$WhenMappings */
                            /* JADX INFO: compiled from: VideoListPage.kt */
                            @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[BackupUtil.BackupDestination.values().length];
                                    try {
                                        iArr[BackupUtil.BackupDestination.Clipboard.ordinal()] = 1;
                                    } catch (NoSuchFieldError e) {
                                    }
                                    try {
                                        iArr[BackupUtil.BackupDestination.File.ordinal()] = 2;
                                    } catch (NoSuchFieldError e2) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(BackupUtil.BackupDestination backupDestination, ClipboardManager clipboardManager, ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher, VideoListViewModel videoListViewModel, SnackbarHostState snackbarHostState, Context context, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$destination = backupDestination;
                                this.$clipboardManager = clipboardManager;
                                this.$importLauncher = managedActivityResultLauncher;
                                this.$viewModel = videoListViewModel;
                                this.$hostState = snackbarHostState;
                                this.$context = context;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$destination, this.$clipboardManager, this.$importLauncher, this.$viewModel, this.$hostState, this.$context, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                String str;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure(obj);
                                        switch (WhenMappings.$EnumSwitchMapping$0[this.$destination.ordinal()]) {
                                            case 1:
                                                AnnotatedString text = this.$clipboardManager.getText();
                                                if (text != null && (str = text.getText()) != null) {
                                                    VideoListViewModel videoListViewModel = this.$viewModel;
                                                    videoListViewModel.importBackupFromText(str, (Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object>) new VideoListPageKt$VideoListPage$20$1$1$1(videoListViewModel, this.$hostState, this.$context, null));
                                                }
                                                break;
                                            case 2:
                                                this.$importLauncher.launch("text/plain");
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(BackupUtil.BackupDestination backupDestination) {
                            invoke2(backupDestination);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(BackupUtil.BackupDestination destination) {
                            Intrinsics.checkNotNullParameter(destination, "destination");
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(destination, clipboardManager, importLauncher, videoListViewModel2, hostState3, context3, null), 3, null);
                            HapticFeedback.INSTANCE.slightHapticFeedback(view);
                            VideoListPageKt.VideoListPage$lambda$20(mutableState2, false);
                        }
                    }, $composer2, 48, 1);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                if (i2 != 0) {
                    $dirty3 &= -15;
                }
            }
            $dirty = $dirty3;
            viewModel2 = viewModel;
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1892356385, $dirty, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage (VideoListPage.kt:141)");
            }
            viewState$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getStateFlow(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 8, 7);
            fullVideoList$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getVideoListFlow(), CollectionsKt.emptyList(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 56, 14);
            searchedVideoList$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getSearchedVideoListFlow(), CollectionsKt.emptyList(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 56, 14);
            if (VideoListPage$lambda$0(viewState$delegate).isSearching()) {
                listVideoListPage$lambda$1 = VideoListPage$lambda$2(searchedVideoList$delegate);
            } else {
                listVideoListPage$lambda$1 = VideoListPage$lambda$1(fullVideoList$delegate);
            }
            filterSet$delegate = SnapshotStateKt.collectAsState(viewModel2.getFilterSetFlow(), new LinkedHashSet(), null, $composer3, 72, 2);
            if (!VideoListPage$lambda$1(fullVideoList$delegate).isEmpty()) {
                $composer3.startReplaceGroup(1093398981);
                ComposerKt.sourceInformation($composer3, "153@7107L24,152@7061L114");
                scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer3, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$scrollBehavior$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return true;
                    }
                }, null, null, $composer3, (TopAppBarDefaults.$stable << 12) | 48, 12);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1093399119);
                ComposerKt.sourceInformation($composer3, "155@7199L22");
                scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
            it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv2 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final CoroutineScope scope6 = wrapper$iv2.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume5 = $composer3.consume(localSoftwareKeyboardController2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SoftwareKeyboardController softKeyboardController2 = (SoftwareKeyboardController) objConsume5;
            ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = $composer3.consume(localView2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            view = (View) objConsume6;
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume7 = $composer3.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            context = (Context) objConsume7;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager2 = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume8 = $composer3.consume(localClipboardManager2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            clipboardManager = (ClipboardManager) objConsume8;
            viewModel3 = viewModel2;
            fileSizeMap$delegate = FlowExtKt.collectAsStateWithLifecycle(viewModel2.getFileSizeMapFlow(), MapsKt.emptyMap(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer3, 56, 14);
            sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, $composer3, 6, 14);
            $composer3.startReplaceGroup(1093399607);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SnackbarHostState();
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            hostState = (SnackbarHostState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093399670);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new DownloadedVideoInfo(), null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            currentVideoInfo$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093399761);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            isSelectEnabled$delegate = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093399837);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            showRemoveMultipleItemsDialog$delegate = (MutableState) value$iv4;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093399901);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            value$iv5 = $composer3.rememberedValue();
            if (value$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv5);
            }
            showExportDialog$delegate = (MutableState) value$iv5;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093399964);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            value$iv6 = $composer3.rememberedValue();
            if (value$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv6);
            }
            showImportDialog$delegate = (MutableState) value$iv6;
            $composer3.endReplaceGroup();
            final LazyListState lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
            VideoListViewModel.VideoListViewState videoListViewStateVideoListPage$lambda$2 = VideoListPage$lambda$0(viewState$delegate);
            $composer3.startReplaceGroup(1093401666);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv = $composer3.changed(videoListViewStateVideoListPage$lambda$2) | $composer3.changed(listVideoListPage$lambda$1);
            Object it$iv110 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv7 = SnapshotStateKt.mutableStateListOf();
            $composer3.updateRememberedValue(value$iv7);
            selectedItemIds = (SnapshotStateList) value$iv7;
            $composer3.endReplaceGroup();
            Boolean boolValueOf3 = Boolean.valueOf(VideoListPage$lambda$10(isSelectEnabled$delegate));
            $composer3.startReplaceGroup(1093401764);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv2 = $composer3.changed(selectedItemIds);
            Object it$iv111 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv8 = new VideoListPageKt$VideoListPage$1$1(selectedItemIds, isSelectEnabled$delegate, null);
            $composer3.updateRememberedValue(value$iv8);
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv8, $composer3, 64);
            int size5 = selectedItemIds.size();
            $composer3.startReplaceGroup(1093401904);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv3 = $composer3.changed(size5);
            Object it$iv112 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            $this$count$iv = listVideoListPage$lambda$1;
            if ($this$count$iv instanceof Collection) {
                count$iv = 0;
                while (r26.hasNext()) {
                    $this$count$iv = $this$count$iv;
                    info = (DownloadedVideoInfo) element$iv;
                    hostState = hostState;
                    if (selectedItemIds.contains(Integer.valueOf(info.getId()))) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (z) {
                        count$iv++;
                        if (count$iv < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                hostState2 = hostState;
            } else {
                count$iv = 0;
                while (r26.hasNext()) {
                    $this$count$iv = $this$count$iv;
                    info = (DownloadedVideoInfo) element$iv;
                    hostState = hostState;
                    if (selectedItemIds.contains(Integer.valueOf(info.getId()))) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (z) {
                        count$iv++;
                        if (count$iv < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                hostState2 = hostState;
            }
            value$iv9 = SnapshotIntStateKt.mutableIntStateOf(count$iv);
            $composer3.updateRememberedValue(value$iv9);
            selectedVideoCount = (MutableIntState) value$iv9;
            $composer3.endReplaceGroup();
            int size6 = selectedItemIds.size();
            $composer3.startReplaceGroup(1093402222);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv4 = $composer3.changed(size6);
            it$iv5 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            $this$count$iv2 = listVideoListPage$lambda$1;
            if ($this$count$iv2 instanceof Collection) {
                count$iv2 = 0;
                while (r25.hasNext()) {
                    $this$count$iv2 = $this$count$iv2;
                    info2 = (DownloadedVideoInfo) element$iv2;
                    it$iv5 = it$iv5;
                    if (selectedItemIds.contains(Integer.valueOf(info2.getId()))) {
                        selectedVideoCount = selectedVideoCount;
                        if (filterByType(info2, false, true)) {
                        }
                        if (!z2) {
                            count$iv2++;
                            if (count$iv2 < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                    } else {
                        selectedVideoCount = selectedVideoCount;
                    }
                    if (!z2) {
                        count$iv2++;
                        if (count$iv2 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                selectedVideoCount2 = selectedVideoCount;
            } else {
                count$iv2 = 0;
                while (r25.hasNext()) {
                    $this$count$iv2 = $this$count$iv2;
                    info2 = (DownloadedVideoInfo) element$iv2;
                    it$iv5 = it$iv5;
                    if (selectedItemIds.contains(Integer.valueOf(info2.getId()))) {
                        selectedVideoCount = selectedVideoCount;
                        if (filterByType(info2, false, true)) {
                        }
                        if (!z2) {
                            count$iv2++;
                            if (count$iv2 < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                    } else {
                        selectedVideoCount = selectedVideoCount;
                    }
                    if (!z2) {
                        count$iv2++;
                        if (count$iv2 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                selectedVideoCount2 = selectedVideoCount;
            }
            value$iv10 = SnapshotIntStateKt.mutableIntStateOf(count$iv2);
            $composer3.updateRememberedValue(value$iv10);
            final MutableIntState selectedAudioCount2 = (MutableIntState) value$iv10;
            $composer3.endReplaceGroup();
            int size7 = selectedItemIds.size();
            $composer3.startReplaceGroup(1093402543);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv5 = $composer3.changed(size7);
            Object it$iv113 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            value$iv11 = SnapshotStateKt.derivedStateOf(new Function0<Long>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$selectedFileSizeSum$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Long invoke() {
                    Iterable $this$fold$iv = selectedItemIds;
                    State<Map<Integer, Long>> state = fileSizeMap$delegate;
                    Long lValueOf = 0L;
                    for (Object element$iv4 : $this$fold$iv) {
                        int id = ((Number) element$iv4).intValue();
                        long acc = lValueOf.longValue();
                        Object obj = VideoListPageKt.VideoListPage$lambda$4(state).get(Integer.valueOf(id));
                        if (obj == null) {
                            obj = 0L;
                        }
                        lValueOf = Long.valueOf(acc + ((Number) obj).longValue());
                    }
                    return lValueOf;
                }
            });
            $composer3.updateRememberedValue(value$iv11);
            selectedFileSizeSum$delegate = (State) value$iv11;
            $composer3.endReplaceGroup();
            VideoListViewModel.VideoListViewState videoListViewStateVideoListPage$lambda$3 = VideoListPage$lambda$0(viewState$delegate);
            $composer3.startReplaceGroup(1093402775);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv6 = $composer3.changed(videoListViewStateVideoListPage$lambda$3) | $composer3.changed(listVideoListPage$lambda$1);
            it$iv6 = $composer3.rememberedValue();
            if (invalid$iv6) {
            }
            $this$count$iv3 = listVideoListPage$lambda$1;
            if ($this$count$iv3 instanceof Collection) {
                count$iv3 = 0;
                while (r27.hasNext()) {
                    $this$count$iv3 = $this$count$iv3;
                    it = (DownloadedVideoInfo) element$iv3;
                    it$iv6 = it$iv6;
                    selectedFileSizeSum$delegate = selectedFileSizeSum$delegate;
                    if (filterSort(it, VideoListPage$lambda$0(viewState$delegate), VideoListPage$lambda$3(filterSet$delegate))) {
                        count$iv3++;
                        if (count$iv3 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                selectedFileSizeSum$delegate2 = selectedFileSizeSum$delegate;
            } else {
                count$iv3 = 0;
                while (r27.hasNext()) {
                    $this$count$iv3 = $this$count$iv3;
                    it = (DownloadedVideoInfo) element$iv3;
                    it$iv6 = it$iv6;
                    selectedFileSizeSum$delegate = selectedFileSizeSum$delegate;
                    if (filterSort(it, VideoListPage$lambda$0(viewState$delegate), VideoListPage$lambda$3(filterSet$delegate))) {
                        count$iv3++;
                        if (count$iv3 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                selectedFileSizeSum$delegate2 = selectedFileSizeSum$delegate;
            }
            value$iv12 = SnapshotIntStateKt.mutableIntStateOf(count$iv3);
            $composer3.updateRememberedValue(value$iv12);
            final MutableIntState visibleItemCount2 = (MutableIntState) value$iv12;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093402925);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv7 = $composer3.changed(selectedItemIds) | $composer3.changed(visibleItemCount2);
            Object it$iv22 = $composer3.rememberedValue();
            if (invalid$iv7) {
            }
            value$iv13 = SnapshotStateKt.derivedStateOf(new Function0<ToggleableState>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$checkBoxState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ToggleableState invoke() {
                    if (selectedItemIds.isEmpty()) {
                        return ToggleableState.Off;
                    }
                    if (selectedItemIds.size() == visibleItemCount2.getIntValue() && (!selectedItemIds.isEmpty())) {
                        return ToggleableState.On;
                    }
                    return ToggleableState.Indeterminate;
                }
            });
            $composer3.updateRememberedValue(value$iv13);
            final State<? extends ToggleableState> checkBoxState$delegate2 = (State) value$iv13;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093403322);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv14);
            } else {
                value$iv14 = it$iv7;
            }
            showRemoveDialog$delegate = (MutableState) value$iv14;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1093403384);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv15);
            } else {
                value$iv15 = it$iv8;
            }
            showBottomSheet$delegate = (MutableState) value$iv15;
            $composer3.endReplaceGroup();
            if (VideoListPage$lambda$10(isSelectEnabled$delegate)) {
                z3 = true;
            } else {
                z3 = true;
            }
            BackHandlerKt.BackHandler(z3, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.2
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
                    if (VideoListPageKt.VideoListPage$lambda$10(isSelectEnabled$delegate)) {
                        VideoListPageKt.VideoListPage$lambda$11(isSelectEnabled$delegate, false);
                    } else {
                        viewModel3.toggleSearch(false);
                    }
                }
            }, $composer3, 0, 0);
            ModalBottomSheetValue targetValue2 = sheetState.getTargetValue();
            Boolean boolValueOf4 = Boolean.valueOf(VideoListPage$lambda$10(isSelectEnabled$delegate));
            $composer3.startReplaceGroup(1093403684);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoListPage.kt#9igjgp");
            invalid$iv8 = $composer3.changed(softKeyboardController2);
            Object it$iv23 = $composer3.rememberedValue();
            if (invalid$iv8) {
            }
            value$iv16 = new VideoListPageKt$VideoListPage$3$1(softKeyboardController2, showBottomSheet$delegate, isSelectEnabled$delegate, null);
            $composer3.updateRememberedValue(value$iv16);
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(targetValue2, boolValueOf4, (Function2) value$iv16, $composer3, 512);
            list = listVideoListPage$lambda$1;
            hostState3 = hostState2;
            selectedFileSizeSum$delegate3 = selectedFileSizeSum$delegate2;
            scope = scope6;
            final MutableIntState mutableIntState2 = selectedVideoCount2;
            $composer2 = $composer3;
            ScaffoldKt.m2282ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(-686184285, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.4
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
                    ComposerKt.sourceInformation($composer4, "C301@12263L115,305@12390L3571,294@12002L4006:VideoListPage.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-686184285, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:294)");
                        }
                        Function2<Composer, Integer, Unit> function2M7496getLambda1$app_debug = ComposableSingletons$VideoListPageKt.INSTANCE.m7496getLambda1$app_debug();
                        final Function0<Unit> function5 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7496getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-189786530, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.4.1
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
                                Object value$iv25;
                                ComposerKt.sourceInformation($composer5, "C302@12296L64,302@12285L75:VideoListPage.kt#861hqi");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-189786530, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous> (VideoListPage.kt:302)");
                                }
                                $composer5.startReplaceGroup(-705212166);
                                ComposerKt.sourceInformation($composer5, "CC(remember):VideoListPage.kt#9igjgp");
                                boolean invalid$iv9 = $composer5.changed(function5);
                                final Function0<Unit> function6 = function5;
                                Object it$iv24 = $composer5.rememberedValue();
                                if (invalid$iv9 || it$iv24 == Composer.INSTANCE.getEmpty()) {
                                    value$iv25 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$1$1$1
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
                                    $composer5.updateRememberedValue(value$iv25);
                                } else {
                                    value$iv25 = it$iv24;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv25, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(1137363271, true, new AnonymousClass2(fullVideoList$delegate, viewState$delegate, view, viewModel3, scope6, lazyListState2, visibleItemCount2, showExportDialog$delegate, showImportDialog$delegate), $composer4, 54), scrollBehavior, $composer4, 3462, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2, reason: invalid class name */
                /* JADX INFO: compiled from: VideoListPage.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                static final class AnonymousClass2 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ State<List<DownloadedVideoInfo>> $fullVideoList$delegate;
                    final /* synthetic */ LazyListState $lazyListState;
                    final /* synthetic */ CoroutineScope $scope;
                    final /* synthetic */ MutableState<Boolean> $showExportDialog$delegate;
                    final /* synthetic */ MutableState<Boolean> $showImportDialog$delegate;
                    final /* synthetic */ View $view;
                    final /* synthetic */ VideoListViewModel $viewModel;
                    final /* synthetic */ State<VideoListViewModel.VideoListViewState> $viewState$delegate;
                    final /* synthetic */ MutableIntState $visibleItemCount;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass2(State<? extends List<DownloadedVideoInfo>> state, State<VideoListViewModel.VideoListViewState> state2, View view, VideoListViewModel videoListViewModel, CoroutineScope coroutineScope, LazyListState lazyListState, MutableIntState mutableIntState, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
                        super(3);
                        this.$fullVideoList$delegate = state;
                        this.$viewState$delegate = state2;
                        this.$view = view;
                        this.$viewModel = videoListViewModel;
                        this.$scope = coroutineScope;
                        this.$lazyListState = lazyListState;
                        this.$visibleItemCount = mutableIntState;
                        this.$showExportDialog$delegate = mutableState;
                        this.$showImportDialog$delegate = mutableState2;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope LargeTopAppBar, Composer $composer, int $changed) {
                        Function0<ComposeUiNode> function0;
                        Object value$iv;
                        Function0<ComposeUiNode> function1;
                        Object value$iv2;
                        Intrinsics.checkNotNullParameter(LargeTopAppBar, "$this$LargeTopAppBar");
                        ComposerKt.sourceInformation($composer, "C306@12412L3531:VideoListPage.kt#861hqi");
                        if (($changed & 81) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1137363271, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous> (VideoListPage.kt:306)");
                        }
                        State<List<DownloadedVideoInfo>> state = this.$fullVideoList$delegate;
                        State<VideoListViewModel.VideoListViewState> state2 = this.$viewState$delegate;
                        final View view = this.$view;
                        final VideoListViewModel videoListViewModel = this.$viewModel;
                        final CoroutineScope coroutineScope = this.$scope;
                        final LazyListState lazyListState = this.$lazyListState;
                        final MutableIntState mutableIntState = this.$visibleItemCount;
                        final MutableState<Boolean> mutableState = this.$showExportDialog$delegate;
                        final MutableState<Boolean> mutableState2 = this.$showImportDialog$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function0 = constructor;
                            $composer.createNode(function0);
                        } else {
                            function0 = constructor;
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
                        ComposerKt.sourceInformationMarkerStart($composer, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 756709549, "C328@13531L34,329@13590L2331:VideoListPage.kt#861hqi");
                        $composer.startReplaceGroup(756709549);
                        ComposerKt.sourceInformation($composer, "308@12504L960");
                        if (!VideoListPageKt.VideoListPage$lambda$1(state).isEmpty()) {
                            IconButtonKt.IconToggleButton(VideoListPageKt.VideoListPage$lambda$0(state2).isSearching(), new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$1
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
                                    HapticFeedback.INSTANCE.slightHapticFeedback(view);
                                    videoListViewModel.toggleSearch(it);
                                    if (it) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(lazyListState, null), 3, null);
                                    }
                                }

                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: VideoListPage.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$1$1", f = "VideoListPage.kt", i = {}, l = {316, 317}, m = "invokeSuspend", n = {}, s = {})
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ LazyListState $lazyListState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$lazyListState = lazyListState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$lazyListState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    /* JADX WARN: Code duplicated, block: B:13:0x0040 A[RETURN] */
                                    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        AnonymousClass1 anonymousClass1;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                anonymousClass1 = this;
                                                anonymousClass1.label = 1;
                                                if (DelayKt.delay(50L, anonymousClass1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                anonymousClass1.label = 2;
                                                if (LazyListState.animateScrollToItem$default(anonymousClass1.$lazyListState, 0, 0, anonymousClass1, 2, null) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                return Unit.INSTANCE;
                                            case 1:
                                                anonymousClass1 = this;
                                                ResultKt.throwOnFailure($result);
                                                anonymousClass1.label = 2;
                                                if (LazyListState.animateScrollToItem$default(anonymousClass1.$lazyListState, 0, 0, anonymousClass1, 2, null) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                return Unit.INSTANCE;
                                            case 2:
                                                ResultKt.throwOnFailure($result);
                                                return Unit.INSTANCE;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                    }
                                }
                            }, Modifier.INSTANCE, false, null, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7498getLambda2$app_debug(), $composer, 1573248, 56);
                        }
                        $composer.endReplaceGroup();
                        $composer.startReplaceGroup(756710638);
                        ComposerKt.sourceInformation($composer, "CC(remember):VideoListPage.kt#9igjgp");
                        Object it$iv = $composer.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final MutableState<Boolean> expanded$delegate = (MutableState) value$iv;
                        $composer.endReplaceGroup();
                        Modifier modifier$iv2 = SizeKt.wrapContentSize$default(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd(), false, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function1 = constructor2;
                            $composer.createNode(function1);
                        } else {
                            function1 = constructor2;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i4 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -1667302567, "C332@13754L19,332@13733L403,342@14283L20,342@14305L1589,340@14165L1729:VideoListPage.kt#861hqi");
                        $composer.startReplaceGroup(-1667302546);
                        ComposerKt.sourceInformation($composer, "CC(remember):VideoListPage.kt#9igjgp");
                        Object value$iv3 = $composer.rememberedValue();
                        if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$1$1
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
                                    VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(expanded$delegate, true);
                                }
                            };
                            $composer.updateRememberedValue(value$iv3);
                        }
                        $composer.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv3, null, false, null, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7499getLambda3$app_debug(), $composer, 196614, 30);
                        boolean zInvoke$lambda$6$lambda$1 = invoke$lambda$6$lambda$1(expanded$delegate);
                        $composer.startReplaceGroup(-1667302017);
                        ComposerKt.sourceInformation($composer, "CC(remember):VideoListPage.kt#9igjgp");
                        Object it$iv2 = $composer.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$2$1
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
                                    VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(expanded$delegate, false);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer.endReplaceGroup();
                        AndroidMenu_androidKt.m1666DropdownMenuIlH_yew(zInvoke$lambda$6$lambda$1, (Function0) value$iv2, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1754886808, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                invoke(columnScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope DropdownMenu, Composer $composer2, int $changed2) {
                                Object value$iv4;
                                Object value$iv5;
                                Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                                ComposerKt.sourceInformation($composer2, "C365@15703L160,357@15203L661:VideoListPage.kt#861hqi");
                                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1754886808, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:343)");
                                    }
                                    $composer2.startReplaceGroup(-524873256);
                                    ComposerKt.sourceInformation($composer2, "352@14963L172,344@14412L724");
                                    if (mutableIntState.getIntValue() > 0) {
                                        Function2<Composer, Integer, Unit> function2M7500getLambda4$app_debug = ComposableSingletons$VideoListPageKt.INSTANCE.m7500getLambda4$app_debug();
                                        $composer2.startReplaceGroup(-524872632);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):VideoListPage.kt#9igjgp");
                                        final MutableState<Boolean> mutableState3 = mutableState;
                                        final MutableState<Boolean> mutableState4 = expanded$delegate;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$3$1$1
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
                                                    VideoListPageKt.VideoListPage$lambda$17(mutableState3, true);
                                                    VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(mutableState4, false);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv5);
                                        } else {
                                            value$iv5 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        AndroidMenu_androidKt.DropdownMenuItem(function2M7500getLambda4$app_debug, (Function0) value$iv5, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7501getLambda5$app_debug(), null, false, null, null, null, $composer2, 3126, 500);
                                    }
                                    $composer2.endReplaceGroup();
                                    Function2<Composer, Integer, Unit> function2M7502getLambda6$app_debug = ComposableSingletons$VideoListPageKt.INSTANCE.m7502getLambda6$app_debug();
                                    $composer2.startReplaceGroup(-524871892);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):VideoListPage.kt#9igjgp");
                                    final MutableState<Boolean> mutableState5 = mutableState2;
                                    final MutableState<Boolean> mutableState6 = expanded$delegate;
                                    Object it$iv4 = $composer2.rememberedValue();
                                    if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                        value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$4$2$1$2$3$2$1
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
                                                VideoListPageKt.VideoListPage$lambda$20(mutableState5, true);
                                                VideoListPageKt.AnonymousClass4.AnonymousClass2.invoke$lambda$6$lambda$2(mutableState6, false);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv4);
                                    } else {
                                        value$iv4 = it$iv4;
                                    }
                                    $composer2.endReplaceGroup();
                                    AndroidMenu_androidKt.DropdownMenuItem(function2M7502getLambda6$app_debug, (Function0) value$iv4, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7503getLambda7$app_debug(), null, false, null, null, null, $composer2, 3126, 500);
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

                    private static final boolean invoke$lambda$6$lambda$1(MutableState<Boolean> mutableState) {
                        MutableState<Boolean> $this$getValue$iv = mutableState;
                        return $this$getValue$iv.getValue().booleanValue();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$6$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                        mutableState.setValue(Boolean.valueOf(value));
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-2134191132, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5
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
                    ComposerKt.sourceInformation($composer4, "C380@16222L2170,376@16046L2346:VideoListPage.kt#861hqi");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2134191132, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:376)");
                        }
                        boolean zVideoListPage$lambda$10 = VideoListPageKt.VideoListPage$lambda$10(isSelectEnabled$delegate);
                        EnterTransition enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        ExitTransition exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        final MutableIntState mutableIntState3 = mutableIntState2;
                        final MutableIntState mutableIntState4 = selectedAudioCount2;
                        final SnapshotStateList<Integer> snapshotStateList = selectedItemIds;
                        final State<? extends ToggleableState> state = checkBoxState$delegate2;
                        final View view2 = view;
                        final List<DownloadedVideoInfo> list3 = list;
                        final State<VideoListViewModel.VideoListViewState> state2 = viewState$delegate;
                        final State<? extends Set<String>> state3 = filterSet$delegate;
                        final MutableState<Boolean> mutableState3 = showRemoveMultipleItemsDialog$delegate;
                        AnimatedVisibilityKt.AnimatedVisibility(zVideoListPage$lambda$10, (Modifier) null, enterTransitionPlus, exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(-1648453444, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1
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
                                ComposerKt.sourceInformation($composer5, "C383@16312L2066,381@16240L2138:VideoListPage.kt#861hqi");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1648453444, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous> (VideoListPage.kt:381)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                final MutableIntState mutableIntState5 = mutableIntState3;
                                final MutableIntState mutableIntState6 = mutableIntState4;
                                final SnapshotStateList<Integer> snapshotStateList2 = snapshotStateList;
                                final State<? extends ToggleableState> state4 = state;
                                final View view3 = view2;
                                final List<DownloadedVideoInfo> list4 = list3;
                                final State<VideoListViewModel.VideoListViewState> state5 = state2;
                                final State<? extends Set<String>> state6 = state3;
                                final MutableState<Boolean> mutableState4 = mutableState3;
                                AppBarKt.m1667BottomAppBar1oL4kX8(companion, 0L, 0L, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(-1315134284, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1.1
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
                                        Object value$iv25;
                                        Intrinsics.checkNotNullParameter(BottomAppBar, "$this$BottomAppBar");
                                        ComposerKt.sourceInformation($composer6, "C384@16354L35,386@16482L95,385@16410L1014,*408@17538L47,412@17780L10,406@17445L378,414@17844L516:VideoListPage.kt#861hqi");
                                        int $dirty4 = $changed4;
                                        if (($changed4 & 14) == 0) {
                                            $dirty4 |= $composer6.changed(BottomAppBar) ? 4 : 2;
                                        }
                                        int $dirty5 = $dirty4;
                                        if (($dirty5 & 91) == 18 && $composer6.getSkipping()) {
                                            $composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1315134284, $dirty5, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:384)");
                                        }
                                        final String selectAllText = StringResources_androidKt.stringResource(R.string.select_all, $composer6, 0);
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        $composer6.startReplaceGroup(756713589);
                                        ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                        boolean invalid$iv9 = $composer6.changed(selectAllText);
                                        Object it$iv24 = $composer6.rememberedValue();
                                        if (invalid$iv9 || it$iv24 == Composer.INSTANCE.getEmpty()) {
                                            value$iv25 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$5$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                    SemanticsPropertiesKt.setContentDescription(semantics, selectAllText);
                                                }
                                            };
                                            $composer6.updateRememberedValue(value$iv25);
                                        } else {
                                            value$iv25 = it$iv24;
                                        }
                                        $composer6.endReplaceGroup();
                                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv25, 1, null);
                                        ToggleableState toggleableStateVideoListPage$lambda$34 = VideoListPageKt.VideoListPage$lambda$34(state4);
                                        final View view4 = view3;
                                        final SnapshotStateList<Integer> snapshotStateList3 = snapshotStateList2;
                                        final List<DownloadedVideoInfo> list5 = list4;
                                        final State<? extends ToggleableState> state7 = state4;
                                        final State<VideoListViewModel.VideoListViewState> state8 = state5;
                                        final State<? extends Set<String>> state9 = state6;
                                        CheckboxKt.TriStateCheckbox(toggleableStateVideoListPage$lambda$34, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1.1.2

                                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$5$1$1$2$WhenMappings */
                                            /* JADX INFO: compiled from: VideoListPage.kt */
                                            @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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
                                            public /* bridge */ /* synthetic */ Unit invoke() throws Throwable {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() throws Throwable {
                                                HapticFeedback.INSTANCE.slightHapticFeedback(view4);
                                                if (WhenMappings.$EnumSwitchMapping$0[VideoListPageKt.VideoListPage$lambda$34(state7).ordinal()] != 1) {
                                                    for (DownloadedVideoInfo item : list5) {
                                                        if (!snapshotStateList3.contains(Integer.valueOf(item.getId())) && VideoListPageKt.filterSort(item, VideoListPageKt.VideoListPage$lambda$0(state8), VideoListPageKt.VideoListPage$lambda$3(state9))) {
                                                            snapshotStateList3.add(Integer.valueOf(item.getId()));
                                                        }
                                                    }
                                                    return;
                                                }
                                                snapshotStateList3.clear();
                                            }
                                        }, modifierSemantics$default, false, null, null, $composer6, 0, 56);
                                        Modifier modifierWeight$default = RowScope.CC.weight$default(BottomAppBar, Modifier.INSTANCE, 1.0f, false, 2, null);
                                        String str2 = String.format(StringResources_androidKt.stringResource(R.string.multiselect_item_count, $composer6, 0), Arrays.copyOf(new Object[]{Integer.valueOf(mutableIntState5.getIntValue()), Integer.valueOf(mutableIntState6.getIntValue())}, 2));
                                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                                        TextKt.m2569Text4IGK_g(str2, modifierWeight$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer6, MaterialTheme.$stable).getLabelLarge(), $composer6, 0, 0, 65532);
                                        final View view5 = view3;
                                        final MutableState<Boolean> mutableState5 = mutableState4;
                                        IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.5.1.1.3
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
                                                VideoListPageKt.VideoListPage$lambda$14(mutableState5, true);
                                            }
                                        }, null, !snapshotStateList2.isEmpty(), null, null, ComposableSingletons$VideoListPageKt.INSTANCE.m7504getLambda8$app_debug(), $composer6, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer5, 54), $composer5, 1572870, 62);
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
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(712769317, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.6
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C430@18441L35:VideoListPage.kt#861hqi");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(712769317, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:430)");
                    }
                    SnackbarHostKt.SnackbarHost(hostState3, null, null, $composer4, 6, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2004580654, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) throws SVGParseException {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues innerPadding, Composer $composer4, int $changed2) throws SVGParseException {
                    Object value$iv25;
                    Function0<ComposeUiNode> function5;
                    Function0<ComposeUiNode> function6;
                    Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
                    ComposerKt.sourceInformation($composer4, "C454@19411L7,458@19561L27,459@19597L3603:VideoListPage.kt#861hqi");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changed(innerPadding) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2004580654, $dirty5, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:433)");
                        }
                        $composer4.startReplaceGroup(-777824088);
                        ComposerKt.sourceInformation($composer4, "434@18560L797");
                        if (VideoListPageKt.VideoListPage$lambda$1(fullVideoList$delegate).isEmpty()) {
                            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                                function5 = constructor;
                                $composer4.createNode(function5);
                            } else {
                                function5 = constructor;
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
                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            int i4 = ((6 >> 6) & 112) | 6;
                            BoxScope $this$invoke_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -705205814, "C437@18648L695:VideoListPage.kt#861hqi");
                            Modifier modifier$iv2 = $this$invoke_u24lambda_u241.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
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
                                function6 = constructor2;
                                $composer4.createNode(function6);
                            } else {
                                function6 = constructor2;
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
                            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i6 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 756715939, "C441@18832L224,447@19114L44,448@19206L10,449@19275L11,446@19077L248:VideoListPage.kt#861hqi");
                            AsyncImageImplKt.m7098SVGImagegl8XCv8(VideoStreamSVG.VideoStreamSVG, null, PaddingKt.m621paddingVpY3zN4(Modifier.INSTANCE, Dp.m6553constructorimpl(72), Dp.m6553constructorimpl(20)), null, null, null, null, 0.0f, null, 0, null, false, $composer4, 438, 0, 4088);
                            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.no_downloaded_media, $composer4, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 0, 0, 65530);
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
                        }
                        $composer4.endReplaceGroup();
                        ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = com.videshkarmakar.loop.ui.common.CompositionLocalsKt.getLocalWindowWidthState();
                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume9 = $composer4.consume(localWindowWidthState);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final int cellCount = WindowWidthSizeClass.m3491equalsimpl0(((WindowWidthSizeClass) objConsume9).getValue(), WindowWidthSizeClass.INSTANCE.m3500getExpandedY0FxcvE()) ? 2 : 1;
                        $composer4.startReplaceGroup(-777823046);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoListPage.kt#9igjgp");
                        boolean invalid$iv9 = $composer4.changed(cellCount);
                        Object it$iv24 = $composer4.rememberedValue();
                        if (invalid$iv9 || it$iv24 == Composer.INSTANCE.getEmpty()) {
                            value$iv25 = new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$span$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                                    return GridItemSpan.m734boximpl(m7506invokeBHJflc(lazyGridItemSpanScope));
                                }

                                /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
                                public final long m7506invokeBHJflc(LazyGridItemSpanScope it4) {
                                    Intrinsics.checkNotNullParameter(it4, "it");
                                    return LazyGridSpanKt.GridItemSpan(cellCount);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv25);
                        } else {
                            value$iv25 = it$iv24;
                        }
                        $composer4.endReplaceGroup();
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, innerPadding);
                        LazyListState lazyListState3 = lazyListState2;
                        final List<DownloadedVideoInfo> list3 = list;
                        final State<? extends List<DownloadedVideoInfo>> state = fullVideoList$delegate;
                        final State<VideoListViewModel.VideoListViewState> state2 = viewState$delegate;
                        final VideoListViewModel videoListViewModel3 = viewModel3;
                        final State<? extends Set<String>> state3 = filterSet$delegate;
                        final SnapshotStateList<Integer> snapshotStateList = selectedItemIds;
                        final State<? extends Map<Integer, Long>> state4 = fileSizeMap$delegate;
                        final MutableState<Boolean> mutableState3 = isSelectEnabled$delegate;
                        final View view2 = view;
                        final CoroutineScope coroutineScope2 = scope;
                        final MutableState<DownloadedVideoInfo> mutableState4 = currentVideoInfo$delegate;
                        final ModalBottomSheetState modalBottomSheetState = sheetState;
                        final MutableState<Boolean> mutableState5 = showBottomSheet$delegate;
                        LazyDslKt.LazyColumn(modifierPadding, lazyListState3, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2
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
                                if (!VideoListPageKt.VideoListPage$lambda$1(state).isEmpty()) {
                                    final State<VideoListViewModel.VideoListViewState> state5 = state2;
                                    final VideoListViewModel videoListViewModel4 = videoListViewModel3;
                                    final State<? extends Set<String>> state6 = state3;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-793036257, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2.1
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
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C465@19799L837:VideoListPage.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-793036257, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:465)");
                                                }
                                                final State<VideoListViewModel.VideoListViewState> state7 = state5;
                                                final VideoListViewModel videoListViewModel5 = videoListViewModel4;
                                                State<Set<String>> state8 = state6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                Modifier modifier$iv3 = Modifier.INSTANCE;
                                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer5);
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                                }
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                                ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1667296468, "C466@19884L513,466@19832L565,476@20422L192:VideoListPage.kt#861hqi");
                                                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u240, VideoListPageKt.VideoListPage$lambda$0(state7).isSearching(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1037365615, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                                        invoke(animatedVisibilityScope, composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer6, int $changed4) {
                                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                        ComposerKt.sourceInformation($composer6, "C472@20220L44,467@19914L457:VideoListPage.kt#861hqi");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1037365615, $changed4, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:467)");
                                                        }
                                                        SearchBarKt.LoopSearchBar(PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(8), 1, null), VideoListPageKt.VideoListPage$lambda$0(state7).getSearchText(), StringResources_androidKt.stringResource(R.string.search_in_downloads, $composer6, 0), new AnonymousClass1(videoListViewModel5), $composer6, 6, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }

                                                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$1$1$1$1, reason: invalid class name */
                                                    /* JADX INFO: compiled from: VideoListPage.kt */
                                                    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
                                                        AnonymousClass1(Object obj) {
                                                            super(1, obj, VideoListViewModel.class, "updateSearchText", "updateSearchText(Ljava/lang/String;)V", 0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                                            invoke2(str);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(String p0) {
                                                            Intrinsics.checkNotNullParameter(p0, "p0");
                                                            ((VideoListViewModel) this.receiver).updateSearchText(p0);
                                                        }
                                                    }
                                                }, $composer5, 54), $composer5, ((((0 >> 6) & 112) | 6) & 14) | 1572864, 30);
                                                Modifier materialized$iv$iv4 = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6553constructorimpl(8), 1, null);
                                                VideoListPageKt.VideoListPage$FilterChips(state7, videoListViewModel5, state8, materialized$iv$iv4, $composer5, 6, 0);
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
                                    }), 3, null);
                                }
                                Iterator<DownloadedVideoInfo> it4 = list3.iterator();
                                while (it4.hasNext()) {
                                    final DownloadedVideoInfo info3 = it4.next();
                                    Integer numValueOf = Integer.valueOf(info3.getId());
                                    Function0<Boolean> function7 = new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2.2
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            return Boolean.valueOf(StringsKt.contains$default((CharSequence) info3.getVideoPath(), (CharSequence) FileUtilKt.AUDIO_REGEX, false, 2, (Object) null));
                                        }
                                    };
                                    final State<VideoListViewModel.VideoListViewState> state7 = state2;
                                    final State<? extends Set<String>> state8 = state3;
                                    final SnapshotStateList<Integer> snapshotStateList2 = snapshotStateList;
                                    final State<? extends Map<Integer, Long>> state9 = state4;
                                    final MutableState<Boolean> mutableState6 = mutableState3;
                                    final View view3 = view2;
                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                    final MutableState<DownloadedVideoInfo> mutableState7 = mutableState4;
                                    final ModalBottomSheetState modalBottomSheetState2 = modalBottomSheetState;
                                    Iterator<DownloadedVideoInfo> it5 = it4;
                                    final MutableState<Boolean> mutableState8 = mutableState5;
                                    LazyColumn.item(numValueOf, function7, ComposableLambdaKt.composableLambdaInstance(-1214027848, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.7.2.3
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
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C*495@21205L1930,490@20900L2235:VideoListPage.kt#861hqi");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1214027848, $changed3, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:489)");
                                                }
                                                final DownloadedVideoInfo $this$invoke_u24lambda_u240 = info3;
                                                final DownloadedVideoInfo downloadedVideoInfo = info3;
                                                State<VideoListViewModel.VideoListViewState> state10 = state7;
                                                State<Set<String>> state11 = state8;
                                                final SnapshotStateList<Integer> snapshotStateList3 = snapshotStateList2;
                                                final State<? extends Map<Integer, Long>> state12 = state9;
                                                final MutableState<Boolean> mutableState9 = mutableState6;
                                                final View view4 = view3;
                                                final CoroutineScope coroutineScope4 = coroutineScope3;
                                                final MutableState<DownloadedVideoInfo> mutableState10 = mutableState7;
                                                final ModalBottomSheetState modalBottomSheetState3 = modalBottomSheetState2;
                                                final MutableState<Boolean> mutableState11 = mutableState8;
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                boolean zFilterSort = VideoListPageKt.filterSort(downloadedVideoInfo, VideoListPageKt.VideoListPage$lambda$0(state10), VideoListPageKt.VideoListPage$lambda$3(state11));
                                                ExitTransition exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                                                AnimatedVisibilityKt.AnimatedVisibility(zFilterSort, companion, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)), exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(-972331624, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1
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

                                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer6, int $changed4) {
                                                        Object value$iv26;
                                                        Object value$iv27;
                                                        Object value$iv28;
                                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                        ComposerKt.sourceInformation($composer6, "C504@21710L19,505@21776L32,506@21853L275,512@22172L264,516@22452L154,496@21235L1874:VideoListPage.kt#861hqi");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-972331624, $changed4, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoListPage.kt:496)");
                                                        }
                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                        String videoTitle = $this$invoke_u24lambda_u240.getVideoTitle();
                                                        String videoAuthor = $this$invoke_u24lambda_u240.getVideoAuthor();
                                                        String thumbnailUrl = $this$invoke_u24lambda_u240.getThumbnailUrl();
                                                        String videoPath = $this$invoke_u24lambda_u240.getVideoPath();
                                                        Object obj = VideoListPageKt.VideoListPage$lambda$4(state12).get(Integer.valueOf($this$invoke_u24lambda_u240.getId()));
                                                        if (obj == null) {
                                                            obj = 0L;
                                                        }
                                                        long jLongValue = ((Number) obj).longValue();
                                                        String videoUrl = $this$invoke_u24lambda_u240.getVideoUrl();
                                                        Modifier.Companion companion3 = companion2;
                                                        $composer6.startReplaceGroup(-524865885);
                                                        ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                        final MutableState<Boolean> mutableState12 = mutableState9;
                                                        Object it$iv25 = $composer6.rememberedValue();
                                                        if (it$iv25 == Composer.INSTANCE.getEmpty()) {
                                                            value$iv26 = new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$2$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Boolean invoke() {
                                                                    return Boolean.valueOf(VideoListPageKt.VideoListPage$lambda$10(mutableState12));
                                                                }
                                                            };
                                                            $composer6.updateRememberedValue(value$iv26);
                                                        } else {
                                                            value$iv26 = it$iv25;
                                                        }
                                                        Function0 function8 = (Function0) value$iv26;
                                                        $composer6.endReplaceGroup();
                                                        $composer6.startReplaceGroup(-524865819);
                                                        ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                        boolean invalid$iv10 = $composer6.changed(snapshotStateList3) | $composer6.changed($this$invoke_u24lambda_u240);
                                                        final SnapshotStateList<Integer> snapshotStateList4 = snapshotStateList3;
                                                        final DownloadedVideoInfo downloadedVideoInfo2 = $this$invoke_u24lambda_u240;
                                                        Object value$iv29 = $composer6.rememberedValue();
                                                        if (invalid$iv10 || value$iv29 == Composer.INSTANCE.getEmpty()) {
                                                            value$iv29 = (Function0) new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$3$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Boolean invoke() {
                                                                    return Boolean.valueOf(snapshotStateList4.contains(Integer.valueOf(downloadedVideoInfo2.getId())));
                                                                }
                                                            };
                                                            $composer6.updateRememberedValue(value$iv29);
                                                        }
                                                        Function0 function9 = (Function0) value$iv29;
                                                        $composer6.endReplaceGroup();
                                                        $composer6.startReplaceGroup(-524865742);
                                                        ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                        boolean invalid$iv11 = $composer6.changed(snapshotStateList3) | $composer6.changed($this$invoke_u24lambda_u240);
                                                        final SnapshotStateList<Integer> snapshotStateList5 = snapshotStateList3;
                                                        final DownloadedVideoInfo downloadedVideoInfo3 = $this$invoke_u24lambda_u240;
                                                        Object value$iv30 = $composer6.rememberedValue();
                                                        if (invalid$iv11 || value$iv30 == Composer.INSTANCE.getEmpty()) {
                                                            value$iv30 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$4$1
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
                                                                    if (snapshotStateList5.contains(Integer.valueOf(downloadedVideoInfo3.getId()))) {
                                                                        snapshotStateList5.remove(Integer.valueOf(downloadedVideoInfo3.getId()));
                                                                    } else {
                                                                        snapshotStateList5.add(Integer.valueOf(downloadedVideoInfo3.getId()));
                                                                    }
                                                                }
                                                            };
                                                            $composer6.updateRememberedValue(value$iv30);
                                                        }
                                                        Function0 function10 = (Function0) value$iv30;
                                                        $composer6.endReplaceGroup();
                                                        $composer6.startReplaceGroup(-524865423);
                                                        ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                        boolean invalid$iv12 = $composer6.changed($this$invoke_u24lambda_u240);
                                                        final DownloadedVideoInfo downloadedVideoInfo4 = $this$invoke_u24lambda_u240;
                                                        Object it$iv26 = $composer6.rememberedValue();
                                                        if (invalid$iv12 || it$iv26 == Composer.INSTANCE.getEmpty()) {
                                                            value$iv27 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$5$1
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
                                                                    Unit unit;
                                                                    FileUtil fileUtil = FileUtil.INSTANCE;
                                                                    String path$iv = downloadedVideoInfo4.getVideoPath();
                                                                    try {
                                                                        Result.Companion companion4 = Result.INSTANCE;
                                                                        Intent $this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv = FileUtil.INSTANCE.createIntentForOpeningFile(path$iv);
                                                                        if ($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv != null) {
                                                                            App.INSTANCE.getContext().startActivity($this$openFile_gIAlu_s_u24lambda_u242_u24lambda_u241$iv);
                                                                            unit = Unit.INSTANCE;
                                                                        } else {
                                                                            unit = null;
                                                                        }
                                                                        if (unit != null) {
                                                                            objM7557constructorimpl = Result.m7557constructorimpl(Unit.INSTANCE);
                                                                            if (Result.m7560exceptionOrNullimpl(objM7557constructorimpl) != null) {
                                                                                ToastUtil toastUtil = ToastUtil.INSTANCE;
                                                                                String string = App.INSTANCE.getContext().getString(R.string.file_unavailable);
                                                                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                                                toastUtil.makeToastSuspend(string);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        throw new Exception();
                                                                    } catch (Throwable th) {
                                                                        Result.Companion companion5 = Result.INSTANCE;
                                                                        objM7557constructorimpl = Result.m7557constructorimpl(ResultKt.createFailure(th));
                                                                    }
                                                                }
                                                            };
                                                            $composer6.updateRememberedValue(value$iv27);
                                                        } else {
                                                            value$iv27 = it$iv26;
                                                        }
                                                        Function0 function11 = (Function0) value$iv27;
                                                        $composer6.endReplaceGroup();
                                                        $composer6.startReplaceGroup(-524865143);
                                                        ComposerKt.sourceInformation($composer6, "CC(remember):VideoListPage.kt#9igjgp");
                                                        boolean invalid$iv13 = $composer6.changed(snapshotStateList3) | $composer6.changed($this$invoke_u24lambda_u240);
                                                        final SnapshotStateList<Integer> snapshotStateList6 = snapshotStateList3;
                                                        final DownloadedVideoInfo downloadedVideoInfo5 = $this$invoke_u24lambda_u240;
                                                        final MutableState<Boolean> mutableState13 = mutableState9;
                                                        Object it$iv27 = $composer6.rememberedValue();
                                                        if (invalid$iv13 || it$iv27 == Composer.INSTANCE.getEmpty()) {
                                                            value$iv28 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$6$1
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
                                                                    VideoListPageKt.VideoListPage$lambda$11(mutableState13, true);
                                                                    snapshotStateList6.add(Integer.valueOf(downloadedVideoInfo5.getId()));
                                                                }
                                                            };
                                                            $composer6.updateRememberedValue(value$iv28);
                                                        } else {
                                                            value$iv28 = it$iv27;
                                                        }
                                                        $composer6.endReplaceGroup();
                                                        final View view5 = view4;
                                                        final DownloadedVideoInfo downloadedVideoInfo6 = downloadedVideoInfo;
                                                        final CoroutineScope coroutineScope5 = coroutineScope4;
                                                        final MutableState<DownloadedVideoInfo> mutableState14 = mutableState10;
                                                        final ModalBottomSheetState modalBottomSheetState4 = modalBottomSheetState3;
                                                        final MutableState<Boolean> mutableState15 = mutableState11;
                                                        VideoListItemKt.MediaListItem(companion3, videoTitle, videoAuthor, thumbnailUrl, videoPath, videoUrl, jLongValue, function8, function9, function10, function11, (Function0) value$iv28, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1.7
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
                                                                mutableState14.setValue(downloadedVideoInfo6);
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(modalBottomSheetState4, mutableState15, null), 3, null);
                                                            }

                                                            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$7$1, reason: invalid class name */
                                                            /* JADX INFO: compiled from: VideoListPage.kt */
                                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                                            @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$7$2$3$1$1$7$1", f = "VideoListPage.kt", i = {}, l = {526, 527}, m = "invokeSuspend", n = {}, s = {})
                                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                                final /* synthetic */ MutableState<Boolean> $showBottomSheet$delegate;
                                                                int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                                                                    super(2, continuation);
                                                                    this.$sheetState = modalBottomSheetState;
                                                                    this.$showBottomSheet$delegate = mutableState;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new AnonymousClass1(this.$sheetState, this.$showBottomSheet$delegate, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                /* JADX WARN: Code duplicated, block: B:13:0x0041 A[RETURN] */
                                                                /* JADX WARN: Code duplicated, block: B:14:0x0042  */
                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object $result) {
                                                                    AnonymousClass1 anonymousClass1;
                                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    switch (this.label) {
                                                                        case 0:
                                                                            ResultKt.throwOnFailure($result);
                                                                            anonymousClass1 = this;
                                                                            VideoListPageKt.VideoListPage$lambda$40(anonymousClass1.$showBottomSheet$delegate, true);
                                                                            anonymousClass1.label = 1;
                                                                            if (DelayKt.delay(50L, anonymousClass1) == coroutine_suspended) {
                                                                                return coroutine_suspended;
                                                                            }
                                                                            anonymousClass1.label = 2;
                                                                            if (anonymousClass1.$sheetState.show(anonymousClass1) == coroutine_suspended) {
                                                                                return coroutine_suspended;
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        case 1:
                                                                            anonymousClass1 = this;
                                                                            ResultKt.throwOnFailure($result);
                                                                            anonymousClass1.label = 2;
                                                                            if (anonymousClass1.$sheetState.show(anonymousClass1) == coroutine_suspended) {
                                                                                return coroutine_suspended;
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        case 2:
                                                                            ResultKt.throwOnFailure($result);
                                                                            return Unit.INSTANCE;
                                                                        default:
                                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    }
                                                                }
                                                            }
                                                        }, $composer6, 12582918, 0, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, $composer5, 54), $composer5, 200112, 16);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }));
                                    it4 = it5;
                                }
                            }
                        }, $composer4, 0, 252);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, 805309872, 496);
            $composer2.startReplaceGroup(1093415135);
            ComposerKt.sourceInformation($composer2, "552@23660L27,543@23315L373");
            if (VideoListPage$lambda$39(showBottomSheet$delegate)) {
                l = VideoListPage$lambda$4(fileSizeMap$delegate).get(Integer.valueOf(VideoListPage$lambda$7(currentVideoInfo$delegate).getId()));
                if (l == null) {
                    isFileAvailable = true;
                } else {
                    isFileAvailable = false;
                }
                DownloadedVideoInfo downloadedVideoInfoVideoListPage$lambda$9 = VideoListPage$lambda$7(currentVideoInfo$delegate);
                scope = scope;
                Function0<Unit> function5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$8$1, reason: invalid class name */
                    /* JADX INFO: compiled from: VideoListPage.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$8$1", f = "VideoListPage.kt", i = {}, l = {549}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ModalBottomSheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$sheetState = modalBottomSheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$sheetState, continuation);
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
                                    this.label = 1;
                                    if (this.$sheetState.hide(this) == coroutine_suspended) {
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
                        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(sheetState, null), 3, null);
                        final MutableState<Boolean> mutableState3 = showBottomSheet$delegate;
                        jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.8.2
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
                            public final void invoke2(Throwable it4) {
                                VideoListPageKt.VideoListPage$lambda$40(mutableState3, false);
                            }
                        });
                    }
                };
                $composer2.startReplaceGroup(1093415580);
                str = "CC(remember):VideoListPage.kt#9igjgp";
                ComposerKt.sourceInformation($composer2, str);
                it$iv15 = $composer2.rememberedValue();
                if (it$iv15 == Composer.INSTANCE.getEmpty()) {
                    showRemoveDialog$delegate2 = showRemoveDialog$delegate;
                    value$iv24 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$9$1
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
                            VideoListPageKt.VideoListPage$lambda$37(showRemoveDialog$delegate2, true);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv24);
                } else {
                    showRemoveDialog$delegate2 = showRemoveDialog$delegate;
                    value$iv24 = it$iv15;
                }
                $composer2.endReplaceGroup();
                showBottomSheet$delegate2 = showBottomSheet$delegate;
                sheetState2 = sheetState;
                VideoDetailDrawerKt.VideoDetailDrawer(sheetState, downloadedVideoInfoVideoListPage$lambda$9, isFileAvailable, function5, (Function0) value$iv24, $composer2, ModalBottomSheetState.$stable | CpioConstants.C_ISBLK, 0);
            } else {
                showBottomSheet$delegate2 = showBottomSheet$delegate;
                showRemoveDialog$delegate2 = showRemoveDialog$delegate;
                str = "CC(remember):VideoListPage.kt#9igjgp";
                sheetState2 = sheetState;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1093415638);
            ComposerKt.sourceInformation($composer2, str);
            it$iv9 = $composer2.rememberedValue();
            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv17);
            } else {
                value$iv17 = it$iv9;
            }
            deleteFile$delegate = (MutableState) value$iv17;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1093415678);
            ComposerKt.sourceInformation($composer2, "561@23916L19,567@24160L56,558@23790L427");
            if (VideoListPage$lambda$36(showRemoveDialog$delegate2)) {
                DownloadedVideoInfo downloadedVideoInfoVideoListPage$lambda$10 = VideoListPage$lambda$7(currentVideoInfo$delegate);
                boolean zVideoListPage$lambda$45 = VideoListPage$lambda$44(deleteFile$delegate);
                $composer2.startReplaceGroup(1093415836);
                ComposerKt.sourceInformation($composer2, str);
                it$iv14 = $composer2.rememberedValue();
                if (it$iv14 == Composer.INSTANCE.getEmpty()) {
                    value$iv22 = (Function1) new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$10$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean it4) {
                            VideoListPageKt.VideoListPage$lambda$45(deleteFile$delegate, it4);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv22);
                } else {
                    value$iv22 = it$iv14;
                }
                Function1 function6 = (Function1) value$iv22;
                $composer2.endReplaceGroup();
                Function1<Boolean, Unit> function7 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean it4) {
                        viewModel3.deleteDownloadHistory(CollectionsKt.listOf(VideoListPageKt.VideoListPage$lambda$7(currentVideoInfo$delegate)), VideoListPageKt.VideoListPage$lambda$44(deleteFile$delegate));
                    }
                };
                $composer2.startReplaceGroup(1093416080);
                ComposerKt.sourceInformation($composer2, str);
                value$iv23 = $composer2.rememberedValue();
                if (value$iv23 == Composer.INSTANCE.getEmpty()) {
                    value$iv23 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$12$1
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
                            VideoListPageKt.VideoListPage$lambda$37(showRemoveDialog$delegate2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv23);
                }
                Function0 function8 = (Function0) value$iv23;
                $composer2.endReplaceGroup();
                viewModel4 = viewModel3;
                RemoveItemDialogKt.RemoveItemDialog(zVideoListPage$lambda$45, function6, downloadedVideoInfoVideoListPage$lambda$10, function7, function8, $composer2, 24624, 0);
            } else {
                viewModel4 = viewModel3;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1093416149);
            ComposerKt.sourceInformation($composer2, "574@24317L41,592@25252L408,603@25678L123,576@24498L736,573@24274L1537");
            if (VideoListPage$lambda$13(showRemoveMultipleItemsDialog$delegate)) {
                $composer2.startReplaceGroup(1093416237);
                ComposerKt.sourceInformation($composer2, str);
                it$iv13 = $composer2.rememberedValue();
                if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                    showRemoveMultipleItemsDialog$delegate2 = showRemoveMultipleItemsDialog$delegate;
                    value$iv21 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$13$1
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
                            VideoListPageKt.VideoListPage$lambda$14(showRemoveMultipleItemsDialog$delegate2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv21);
                } else {
                    showRemoveMultipleItemsDialog$delegate2 = showRemoveMultipleItemsDialog$delegate;
                    value$iv21 = it$iv13;
                }
                Function0 function9 = (Function0) value$iv21;
                $composer2.endReplaceGroup();
                final VideoListViewModel videoListViewModel3 = viewModel4;
                final MutableState<Boolean> mutableState3 = showRemoveMultipleItemsDialog$delegate2;
                selectedItemIds2 = selectedItemIds;
                selectedFileSizeSum$delegate4 = selectedFileSizeSum$delegate3;
                DialogsKt.m7162LoopDialogOix01E0(null, function9, ComposableLambdaKt.rememberComposableLambda(1269829965, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.14
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
                        ComposerKt.sourceInformation($composer4, "C593@25270L376:VideoListPage.kt#861hqi");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1269829965, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:593)");
                            }
                            final VideoListViewModel videoListViewModel4 = videoListViewModel3;
                            final List<DownloadedVideoInfo> list3 = list;
                            final SnapshotStateList<Integer> snapshotStateList = selectedItemIds;
                            final MutableState<Boolean> mutableState4 = deleteFile$delegate;
                            final MutableState<Boolean> mutableState5 = mutableState3;
                            final MutableState<Boolean> mutableState6 = isSelectEnabled$delegate;
                            ButtonsKt.ConfirmButton(null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.14.1
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
                                    VideoListViewModel videoListViewModel5 = videoListViewModel4;
                                    Iterable $this$filter$iv4 = list3;
                                    SnapshotStateList<Integer> snapshotStateList2 = snapshotStateList;
                                    Collection destination$iv$iv4 = new ArrayList();
                                    for (Object element$iv$iv3 : $this$filter$iv4) {
                                        DownloadedVideoInfo it4 = (DownloadedVideoInfo) element$iv$iv3;
                                        if (snapshotStateList2.contains(Integer.valueOf(it4.getId()))) {
                                            destination$iv$iv4.add(element$iv$iv3);
                                        }
                                    }
                                    videoListViewModel5.deleteDownloadHistory((List) destination$iv$iv4, VideoListPageKt.VideoListPage$lambda$44(mutableState4));
                                    VideoListPageKt.VideoListPage$lambda$14(mutableState5, false);
                                    VideoListPageKt.VideoListPage$lambda$11(mutableState6, false);
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
                }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(1462761166, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.15
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
                        Object value$iv25;
                        ComposerKt.sourceInformation($composer4, "C604@25710L77,604@25696L91:VideoListPage.kt#861hqi");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1462761166, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:604)");
                        }
                        $composer4.startReplaceGroup(-777816897);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoListPage.kt#9igjgp");
                        final MutableState<Boolean> mutableState4 = showRemoveMultipleItemsDialog$delegate2;
                        Object it$iv24 = $composer4.rememberedValue();
                        if (it$iv24 == Composer.INSTANCE.getEmpty()) {
                            value$iv25 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$15$1$1
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
                                    VideoListPageKt.VideoListPage$lambda$14(mutableState4, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv25);
                        } else {
                            value$iv25 = it$iv24;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv25, $composer4, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), ComposableSingletons$VideoListPageKt.INSTANCE.m7505getLambda9$app_debug(), ComposableSingletons$VideoListPageKt.INSTANCE.m7497getLambda10$app_debug(), ComposableLambdaKt.rememberComposableLambda(2041554769, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.16
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
                        Function0<ComposeUiNode> function10;
                        Object value$iv25;
                        ComposerKt.sourceInformation($composer4, "C577@24516L704:VideoListPage.kt#861hqi");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2041554769, $changed2, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.<anonymous> (VideoListPage.kt:577)");
                            }
                            SnapshotStateList<Integer> snapshotStateList = selectedItemIds2;
                            State<Long> state = selectedFileSizeSum$delegate4;
                            final MutableState<Boolean> mutableState4 = deleteFile$delegate;
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
                                function10 = constructor;
                                $composer4.createNode(function10);
                            } else {
                                function10 = constructor;
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
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i4 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -705199917, "C*582@24728L50,578@24545L338,588@25022L36,588@25086L16,590@25174L28,586@24904L298:VideoListPage.kt#861hqi");
                            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, 2, null);
                            String str2 = String.format(StringResources_androidKt.stringResource(R.string.delete_multiple_items_msg, $composer4, 0), Arrays.copyOf(new Object[]{Integer.valueOf(snapshotStateList.size())}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            TextKt.m2569Text4IGK_g(str2, modifierM622paddingVpY3zN4$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 48, 0, 131068);
                            Modifier modifierM622paddingVpY3zN4$default2 = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null);
                            String str3 = StringResources_androidKt.stringResource(R.string.delete_file, $composer4, 0) + " (" + TextUtilKt.toFileSizeText(Long.valueOf(VideoListPageKt.VideoListPage$lambda$30(state)), $composer4, 0) + ")";
                            boolean zVideoListPage$lambda$46 = VideoListPageKt.VideoListPage$lambda$44(mutableState4);
                            $composer4.startReplaceGroup(-705199288);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoListPage.kt#9igjgp");
                            Object it$iv24 = $composer4.rememberedValue();
                            if (it$iv24 == Composer.INSTANCE.getEmpty()) {
                                value$iv25 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$16$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean it4) {
                                        VideoListPageKt.VideoListPage$lambda$45(mutableState4, !VideoListPageKt.VideoListPage$lambda$44(mutableState4));
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv25);
                            } else {
                                value$iv25 = it$iv24;
                            }
                            $composer4.endReplaceGroup();
                            DialogItemsKt.CheckBoxItem(modifierM622paddingVpY3zN4$default2, str3, zVideoListPage$lambda$46, (Function1) value$iv25, $composer4, 3078, 0);
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
                }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797552, 0, 16257);
            } else {
                selectedFileSizeSum$delegate4 = selectedFileSizeSum$delegate3;
                selectedItemIds2 = selectedItemIds;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1093417763);
            ComposerKt.sourceInformation($composer2, str);
            it$iv10 = $composer2.rememberedValue();
            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                value$iv18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer2.updateRememberedValue(value$iv18);
            } else {
                value$iv18 = it$iv10;
            }
            backupString$delegate = (MutableState) value$iv18;
            $composer2.endReplaceGroup();
            exportLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.CreateDocument("text/plain"), new Function1<Uri, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$exportLauncher$1
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
                        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new VideoListPageKt$VideoListPage$exportLauncher$1$1$1(context, uri, backupString$delegate, showExportDialog$delegate, null), 2, null);
                    }
                }
            }, $composer2, 8);
            $composer2.startReplaceGroup(1093418334);
            ComposerKt.sourceInformation($composer2, "636@26708L28,635@26663L632");
            if (VideoListPage$lambda$16(showExportDialog$delegate)) {
                if (!selectedItemIds2.isEmpty()) {
                    destination$iv$iv2 = list;
                    destination$iv$iv3 = new ArrayList();
                    while (r18.hasNext()) {
                        it3 = (DownloadedVideoInfo) element$iv$iv;
                        Collection $this$filter$iv4 = destination$iv$iv2;
                        if (selectedItemIds2.contains(Integer.valueOf(it3.getId()))) {
                            destination$iv$iv3.add(element$iv$iv);
                        }
                        destination$iv$iv2 = $this$filter$iv4;
                    }
                    list2 = (List) destination$iv$iv3;
                    scope3 = scope;
                    selectedFileSizeSum$delegate5 = selectedFileSizeSum$delegate4;
                } else {
                    $this$filter$iv = list;
                    $i$f$filter = 0;
                    destination$iv$iv = new ArrayList();
                    while (r18.hasNext()) {
                        Iterable $this$filter$iv5 = $this$filter$iv;
                        int $i$f$filter3 = $i$f$filter;
                        it2 = (DownloadedVideoInfo) element$iv$iv2;
                        CoroutineScope scope7 = scope;
                        State selectedFileSizeSum$delegate7 = selectedFileSizeSum$delegate4;
                        if (filterSort(it2, VideoListPage$lambda$0(viewState$delegate), VideoListPage$lambda$3(filterSet$delegate))) {
                            destination$iv$iv.add(element$iv$iv2);
                        }
                        $this$filter$iv = $this$filter$iv5;
                        $i$f$filter = $i$f$filter3;
                        selectedFileSizeSum$delegate4 = selectedFileSizeSum$delegate7;
                        scope = scope7;
                    }
                    scope3 = scope;
                    selectedFileSizeSum$delegate5 = selectedFileSizeSum$delegate4;
                    list2 = (List) destination$iv$iv;
                }
                int size8 = list2.size();
                $composer2.startReplaceGroup(1093418628);
                ComposerKt.sourceInformation($composer2, str);
                it$iv12 = $composer2.rememberedValue();
                if (it$iv12 == Composer.INSTANCE.getEmpty()) {
                    value$iv20 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$17$1
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
                            VideoListPageKt.VideoListPage$lambda$17(showExportDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv20);
                } else {
                    value$iv20 = it$iv12;
                }
                $composer2.endReplaceGroup();
                context2 = context;
                scope2 = scope3;
                ExportImportDialogKt.ExportDialog(null, size8, (Function0) value$iv20, new Function2<BackupUtil.BackupType, BackupUtil.BackupDestination, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.18

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$18$WhenMappings */
                    /* JADX INFO: compiled from: VideoListPage.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[BackupUtil.BackupDestination.values().length];
                            try {
                                iArr[BackupUtil.BackupDestination.Clipboard.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[BackupUtil.BackupDestination.File.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(BackupUtil.BackupType backupType, BackupUtil.BackupDestination backupDestination) {
                        invoke2(backupType, backupDestination);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BackupUtil.BackupType type, BackupUtil.BackupDestination destination) {
                        Intrinsics.checkNotNullParameter(type, "type");
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        String it4 = VideoListPageKt.backupToString(list2, type);
                        ClipboardManager clipboardManager2 = clipboardManager;
                        ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher = exportLauncher;
                        Context context4 = context;
                        View view2 = view;
                        MutableState<String> mutableState4 = backupString$delegate;
                        MutableState<Boolean> mutableState5 = showExportDialog$delegate;
                        switch (WhenMappings.$EnumSwitchMapping$0[destination.ordinal()]) {
                            case 1:
                                clipboardManager2.setText(new AnnotatedString(it4, null, null, 6, null));
                                break;
                            case 2:
                                VideoListPageKt.VideoListPage$lambda$51(mutableState4, it4);
                                managedActivityResultLauncher.launch(BackupUtil.INSTANCE.getDownloadHistoryExportFilename(context4));
                                break;
                        }
                        HapticFeedback.INSTANCE.slightHapticFeedback(view2);
                        VideoListPageKt.VideoListPage$lambda$17(mutableState5, false);
                    }
                }, $composer2, 384, 1);
            } else {
                context2 = context;
                scope2 = scope;
            }
            $composer2.endReplaceGroup();
            context3 = context2;
            importLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.GetContent(), new Function1<Uri, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$importLauncher$1
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
                        VideoListViewModel videoListViewModel4 = viewModel4;
                        Context context4 = context3;
                        videoListViewModel4.importBackupFromUri(context4, uri, new VideoListPageKt$VideoListPage$importLauncher$1$1$1(videoListViewModel4, hostState3, context4, null));
                    }
                }
            }, $composer2, 8);
            if (VideoListPage$lambda$19(showImportDialog$delegate)) {
                $composer2.startReplaceGroup(1093419642);
                ComposerKt.sourceInformation($composer2, str);
                it$iv11 = $composer2.rememberedValue();
                if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                    showImportDialog$delegate2 = showImportDialog$delegate;
                    value$iv19 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$19$1
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
                            VideoListPageKt.VideoListPage$lambda$20(showImportDialog$delegate2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv19);
                } else {
                    showImportDialog$delegate2 = showImportDialog$delegate;
                    value$iv19 = it$iv11;
                }
                $composer2.endReplaceGroup();
                final CoroutineScope coroutineScope2 = scope2;
                final VideoListViewModel videoListViewModel4 = viewModel4;
                final MutableState<Boolean> mutableState4 = showImportDialog$delegate2;
                ExportImportDialogKt.ImportDialog(null, (Function0) value$iv19, new Function1<BackupUtil.BackupDestination, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.20
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$20$1, reason: invalid class name */
                    /* JADX INFO: compiled from: VideoListPage.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$20$1", f = "VideoListPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ClipboardManager $clipboardManager;
                        final /* synthetic */ Context $context;
                        final /* synthetic */ BackupUtil.BackupDestination $destination;
                        final /* synthetic */ SnackbarHostState $hostState;
                        final /* synthetic */ ManagedActivityResultLauncher<String, Uri> $importLauncher;
                        final /* synthetic */ VideoListViewModel $viewModel;
                        int label;

                        /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$20$1$WhenMappings */
                        /* JADX INFO: compiled from: VideoListPage.kt */
                        @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[BackupUtil.BackupDestination.values().length];
                                try {
                                    iArr[BackupUtil.BackupDestination.Clipboard.ordinal()] = 1;
                                } catch (NoSuchFieldError e) {
                                }
                                try {
                                    iArr[BackupUtil.BackupDestination.File.ordinal()] = 2;
                                } catch (NoSuchFieldError e2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(BackupUtil.BackupDestination backupDestination, ClipboardManager clipboardManager, ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher, VideoListViewModel videoListViewModel, SnackbarHostState snackbarHostState, Context context, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$destination = backupDestination;
                            this.$clipboardManager = clipboardManager;
                            this.$importLauncher = managedActivityResultLauncher;
                            this.$viewModel = videoListViewModel;
                            this.$hostState = snackbarHostState;
                            this.$context = context;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$destination, this.$clipboardManager, this.$importLauncher, this.$viewModel, this.$hostState, this.$context, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            String str;
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure(obj);
                                    switch (WhenMappings.$EnumSwitchMapping$0[this.$destination.ordinal()]) {
                                        case 1:
                                            AnnotatedString text = this.$clipboardManager.getText();
                                            if (text != null && (str = text.getText()) != null) {
                                                VideoListViewModel videoListViewModel = this.$viewModel;
                                                videoListViewModel.importBackupFromText(str, (Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object>) new VideoListPageKt$VideoListPage$20$1$1$1(videoListViewModel, this.$hostState, this.$context, null));
                                            }
                                            break;
                                        case 2:
                                            this.$importLauncher.launch("text/plain");
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BackupUtil.BackupDestination backupDestination) {
                        invoke2(backupDestination);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BackupUtil.BackupDestination destination) {
                        Intrinsics.checkNotNullParameter(destination, "destination");
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(destination, clipboardManager, importLauncher, videoListViewModel4, hostState3, context3, null), 3, null);
                        HapticFeedback.INSTANCE.slightHapticFeedback(view);
                        VideoListPageKt.VideoListPage$lambda$20(mutableState4, false);
                    }
                }, $composer2, 48, 1);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt.VideoListPage.21
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
                    VideoListPageKt.VideoListPage(viewModel4, onNavigateBack, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoListViewModel.VideoListViewState VideoListPage$lambda$0(State<VideoListViewModel.VideoListViewState> state) {
        Object thisObj$iv = state.getValue();
        return (VideoListViewModel.VideoListViewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<DownloadedVideoInfo> VideoListPage$lambda$1(State<? extends List<DownloadedVideoInfo>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    private static final List<DownloadedVideoInfo> VideoListPage$lambda$2(State<? extends List<DownloadedVideoInfo>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<String> VideoListPage$lambda$3(State<? extends Set<String>> state) {
        Object thisObj$iv = state.getValue();
        return (Set) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<Integer, Long> VideoListPage$lambda$4(State<? extends Map<Integer, Long>> state) {
        Object thisObj$iv = state.getValue();
        return (Map) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadedVideoInfo VideoListPage$lambda$7(MutableState<DownloadedVideoInfo> mutableState) {
        MutableState<DownloadedVideoInfo> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoListPage$lambda$10(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$11(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean VideoListPage$lambda$13(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$14(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean VideoListPage$lambda$16(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$17(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean VideoListPage$lambda$19(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$20(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$FilterChips(State<VideoListViewModel.VideoListViewState> state, final VideoListViewModel $viewModel, State<? extends Set<String>> state2, Modifier modifier, Composer $composer, int $changed, int i) {
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        $composer.startReplaceGroup(-1855212993);
        ComposerKt.sourceInformation($composer, "C(FilterChips)184@8266L21,182@8206L1498:VideoListPage.kt#861hqi");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1855212993, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.VideoListPage.FilterChips (VideoListPage.kt:181)");
        }
        Modifier modifier$iv = SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(modifier2, ScrollKt.rememberScrollState(0, $composer, 0, 1), false, null, false, 14, null));
        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            function0 = constructor;
            $composer.createNode(function0);
        } else {
            function0 = constructor;
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
        int i2 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, -326681257, "C100@5047L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        int i3 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 454667917, "C187@8349L1345:VideoListPage.kt#861hqi");
        Modifier modifier$iv2 = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 2, null);
        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
        int $changed$iv$iv2 = (6 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            function1 = constructor2;
            $composer.createNode(function1);
        } else {
            function1 = constructor2;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer);
        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
        }
        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
        int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, -326681257, "C100@5047L9:Row.kt#2w3rfo");
        int i5 = ((6 >> 6) & 112) | 6;
        RowScope $this$VideoListPage_u24FilterChips_u24lambda_u2422_u24lambda_u2421 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1141159692, "C191@8582L35,188@8419L217,197@8817L35,194@8654L217:VideoListPage.kt#861hqi");
        ChipsKt.VideoFilterChip(null, VideoListPage$lambda$0(state).getAudioFilter(), false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$FilterChips$1$1$1
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
                $viewModel.clickAudioFilter();
            }
        }, StringResources_androidKt.stringResource(R.string.audio, $composer, 0), null, $composer, 0, 37);
        ChipsKt.VideoFilterChip(null, VideoListPage$lambda$0(state).getVideoFilter(), false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$FilterChips$1$1$2
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
                $viewModel.clickVideoFilter();
            }
        }, StringResources_androidKt.stringResource(R.string.video, $composer, 0), null, $composer, 0, 37);
        $composer.startReplaceGroup(454668456);
        ComposerKt.sourceInformation($composer, "206@9246L11,200@8934L374,*209@9389L251");
        if (VideoListPage$lambda$3(state2).size() > 1) {
            Modifier modifierM651height3ABfNKs = SizeKt.m651height3ABfNKs(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(6), 0.0f, 2, null), Dp.m6553constructorimpl(24));
            float $this$dp$iv = Dp.m6553constructorimpl(1.0f);
            Modifier modifierAlign = $this$VideoListPage_u24FilterChips_u24lambda_u2422_u24lambda_u2421.align(SizeKt.m670width3ABfNKs(modifierM651height3ABfNKs, $this$dp$iv), Alignment.INSTANCE.getCenterVertically());
            long onSurface = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface();
            DividerKt.m1976VerticalDivider9IZ8Weo(modifierAlign, 0.0f, Color.m4041copywmQWz5c(onSurface, (14 & 1) != 0 ? Color.m4045getAlphaimpl(onSurface) : 0.3f, (14 & 2) != 0 ? Color.m4049getRedimpl(onSurface) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(onSurface) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(onSurface) : 0.0f), $composer, 0, 2);
            final int i6 = 0;
            int size = VideoListPage$lambda$3(state2).size();
            while (i6 < size) {
                ChipsKt.VideoFilterChip(null, VideoListPage$lambda$0(state).getActiveFilterIndex() == i6, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.VideoListPageKt$VideoListPage$FilterChips$1$1$3
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
                        $viewModel.clickExtractorFilter(i6);
                    }
                }, (String) CollectionsKt.elementAt(VideoListPage$lambda$3(state2), i6), null, $composer, 0, 37);
                i6++;
            }
        }
        $composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long VideoListPage$lambda$30(State<Long> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ToggleableState VideoListPage$lambda$34(State<? extends ToggleableState> state) {
        Object thisObj$iv = state.getValue();
        return (ToggleableState) thisObj$iv;
    }

    private static final boolean VideoListPage$lambda$36(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$37(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoListPage$lambda$39(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$40(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoListPage$lambda$44(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$45(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String VideoListPage$lambda$50(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoListPage$lambda$51(MutableState<String> mutableState, String value) {
        mutableState.setValue(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String backupToString(List<DownloadedVideoInfo> list, BackupUtil.BackupType type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return BackupUtil.INSTANCE.toJsonString(CollectionsKt.reversed(list));
            case 2:
                return BackupUtil.INSTANCE.toURLListString(list);
            default:
                throw new IllegalArgumentException();
        }
    }
}
