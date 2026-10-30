package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.ArraySet;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSet;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.LongSparseArrayKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: AndroidContentCaptureManager.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002~\u007fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010>\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b?\u0010@J\u001a\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010E\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CH\u0002J\u0016\u0010F\u001a\u00020\u000e2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010H\u001a\u00020\u000eH\u0002J\b\u0010I\u001a\u00020\u000eH\u0002J\b\u0010J\u001a\u00020\u000eH\u0002J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u000209H\u0002J\r\u0010M\u001a\u00020\u000eH\u0000¢\u0006\u0002\bNJ-\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u000e\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0UH\u0001¢\u0006\u0002\bWJ\r\u0010X\u001a\u00020\u000eH\u0000¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020\u000e2\u0006\u0010L\u001a\u000209H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020\u000eH\u0000¢\u0006\u0002\b]J\r\u0010^\u001a\u00020\u000eH\u0000¢\u0006\u0002\b_J\u0010\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010d\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020fH\u0016J%\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00002\u000e\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0kH\u0001¢\u0006\u0002\bmJ\u0018\u0010n\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u000205H\u0002J\u0018\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020C2\u0006\u0010t\u001a\u00020uH\u0002J\u0018\u0010v\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u000205H\u0002J\b\u0010w\u001a\u00020\u000eH\u0002J\u0010\u0010x\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\u0010\u0010z\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\b\u0010{\u001a\u00020\u000eH\u0002J\u0010\u0010|\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020pH\u0002J\u000e\u0010}\u001a\u0004\u0018\u00010\u0011*\u00020pH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u00158@X\u0080\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010/R\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006\u0080\u0001"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "onContentCaptureSession", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function0;)V", "SendRecurringContentCaptureEventsIntervalMillis", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "bufferedAppearedNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "bufferedDisappearedNodes", "Landroidx/collection/MutableIntSet;", "checkingForSemanticsChanges", "", "contentCaptureChangeChecker", "Ljava/lang/Runnable;", "contentCaptureSession", "getContentCaptureSession$ui_release$annotations", "()V", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui_release", "()Landroidx/collection/IntObjectMap;", "setCurrentSemanticsNodes$ui_release", "(Landroidx/collection/IntObjectMap;)V", "currentSemanticsNodesInvalidated", "currentSemanticsNodesSnapshotTimestampMillis", "handler", "Landroid/os/Handler;", "getHandler$ui_release", "()Landroid/os/Handler;", "isEnabled", "isEnabled$ui_release$annotations", "isEnabled$ui_release", "()Z", "getOnContentCaptureSession", "()Lkotlin/jvm/functions/Function0;", "setOnContentCaptureSession", "(Lkotlin/jvm/functions/Function0;)V", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "translateStatus", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferContentCaptureViewAppeared", "virtualId", "", "viewStructure", "bufferContentCaptureViewDisappeared", "checkForContentCapturePropertyChanges", "newSemanticsNodes", "clearTranslatedText", "hideTranslatedText", "notifyContentCaptureChanges", "notifySubtreeStateChangeIfNeeded", "layoutNode", "onClearTranslation", "onClearTranslation$ui_release", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onCreateVirtualViewTranslationRequests$ui_release", "onHideTranslation", "onHideTranslation$ui_release", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "onShowTranslation", "onShowTranslation$ui_release", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "onVirtualViewTranslationResponses", "contentCaptureManager", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onVirtualViewTranslationResponses$ui_release", "sendContentCaptureStructureChangeEvents", "newNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "oldNode", "sendContentCaptureTextUpdateEvent", "id", "newText", "", "sendSemanticsStructureChangeEvents", "showTranslatedText", "updateBuffersOnAppeared", "node", "updateBuffersOnDisappeared", "updateSemanticsCopy", "updateTranslationOnAppeared", "toViewStructure", "TranslateStatus", "ViewTranslationHelperMethods", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidContentCaptureManager implements ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    public static final int $stable = 8;
    private final MutableIntObjectMap<ViewStructureCompat> bufferedAppearedNodes;
    private final MutableIntSet bufferedDisappearedNodes;
    private boolean checkingForSemanticsChanges;
    private ContentCaptureSessionCompat contentCaptureSession;
    private long currentSemanticsNodesSnapshotTimestampMillis;
    private Function0<? extends ContentCaptureSessionCompat> onContentCaptureSession;
    private SemanticsNodeCopy previousSemanticsRoot;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AndroidComposeView view;
    private long SendRecurringContentCaptureEventsIntervalMillis = 100;
    private TranslateStatus translateStatus = TranslateStatus.SHOW_ORIGINAL;
    private boolean currentSemanticsNodesInvalidated = true;
    private final Channel<Unit> boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
    private final Runnable contentCaptureChangeChecker = new Runnable() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AndroidContentCaptureManager.contentCaptureChangeChecker$lambda$0(this.f$0);
        }
    };

    /* JADX INFO: compiled from: AndroidContentCaptureManager.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private enum TranslateStatus {
        SHOW_ORIGINAL,
        SHOW_TRANSLATED
    }

    public static /* synthetic */ void getContentCaptureSession$ui_release$annotations() {
    }

    public static /* synthetic */ void isEnabled$ui_release$annotations() {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    public AndroidContentCaptureManager(AndroidComposeView view, Function0<? extends ContentCaptureSessionCompat> function0) {
        this.view = view;
        this.onContentCaptureSession = function0;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.bufferedAppearedNodes = new MutableIntObjectMap<>(i, i2, defaultConstructorMarker);
        this.bufferedDisappearedNodes = new MutableIntSet(i, i2, defaultConstructorMarker);
        this.subtreeChangedLayoutNodes = new ArraySet<>(i, i2, defaultConstructorMarker);
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public final Function0<ContentCaptureSessionCompat> getOnContentCaptureSession() {
        return this.onContentCaptureSession;
    }

    public final void setOnContentCaptureSession(Function0<? extends ContentCaptureSessionCompat> function0) {
        this.onContentCaptureSession = function0;
    }

    /* JADX INFO: renamed from: getContentCaptureSession$ui_release, reason: from getter */
    public final ContentCaptureSessionCompat getContentCaptureSession() {
        return this.contentCaptureSession;
    }

    public final void setContentCaptureSession$ui_release(ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.contentCaptureSession = contentCaptureSessionCompat;
    }

    /* JADX INFO: renamed from: getHandler$ui_release, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    public final void setCurrentSemanticsNodes$ui_release(IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap) {
        this.currentSemanticsNodes = intObjectMap;
    }

    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }
        return this.currentSemanticsNodes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager this$0) {
        if (this$0.isEnabled$ui_release()) {
            Owner.CC.measureAndLayout$default(this$0.view, false, 1, null);
            this$0.sendSemanticsStructureChangeEvents(this$0.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this$0.previousSemanticsRoot);
            this$0.sendContentCaptureStructureChangeEvents(this$0.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this$0.previousSemanticsRoot);
            this$0.checkForContentCapturePropertyChanges(this$0.getCurrentSemanticsNodes$ui_release());
            this$0.updateSemanticsCopy();
            this$0.checkingForSemanticsChanges = false;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = null;
    }

    public final boolean isEnabled$ui_release() {
        return ContentCaptureManager.INSTANCE.isEnabled() && this.contentCaptureSession != null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        this.contentCaptureSession = this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0062 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:26:0x0071 A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:24:0x0069, B:26:0x0071, B:28:0x007a, B:29:0x007d, B:31:0x0081, B:32:0x008a), top: B:46:0x0069 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x007a A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:24:0x0069, B:26:0x0071, B:28:0x007a, B:29:0x007d, B:31:0x0081, B:32:0x008a), top: B:46:0x0069 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0081 A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:24:0x0069, B:26:0x0071, B:28:0x007a, B:29:0x007d, B:31:0x0081, B:32:0x008a), top: B:46:0x0069 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x009f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009f -> B:20:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            r0.<init>(r9, r10)
        L19:
            r10 = r0
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r3 = 1
            switch(r2) {
                case 0: goto L4b;
                case 1: goto L3b;
                case 2: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L2e:
            java.lang.Object r2 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r10.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r4 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Throwable -> Lb3
            goto La3
        L3b:
            java.lang.Object r2 = r10.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r10.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r4 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Throwable -> Lb3
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r0
            goto L69
        L4b:
            kotlin.ResultKt.throwOnFailure(r0)
            r4 = r9
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r2 = r4.boundsUpdateChannel     // Catch: java.lang.Throwable -> Lb3
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lb3
        L56:
            r10.L$0 = r4     // Catch: java.lang.Throwable -> Lb3
            r10.L$1 = r2     // Catch: java.lang.Throwable -> Lb3
            r10.label = r3     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r5 = r2.hasNext(r10)     // Catch: java.lang.Throwable -> Lb3
            if (r5 != r1) goto L63
            return r1
        L63:
            r8 = r1
            r1 = r0
            r0 = r5
            r5 = r4
            r4 = r2
            r2 = r8
        L69:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> Lad
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> Lad
            if (r0 == 0) goto La4
            r4.next()     // Catch: java.lang.Throwable -> Lad
            boolean r0 = r5.isEnabled$ui_release()     // Catch: java.lang.Throwable -> Lad
            if (r0 == 0) goto L7d
            r5.notifyContentCaptureChanges()     // Catch: java.lang.Throwable -> Lad
        L7d:
            boolean r0 = r5.checkingForSemanticsChanges     // Catch: java.lang.Throwable -> Lad
            if (r0 != 0) goto L8a
            r5.checkingForSemanticsChanges = r3     // Catch: java.lang.Throwable -> Lad
            android.os.Handler r0 = r5.handler     // Catch: java.lang.Throwable -> Lad
            java.lang.Runnable r6 = r5.contentCaptureChangeChecker     // Catch: java.lang.Throwable -> Lad
            r0.post(r6)     // Catch: java.lang.Throwable -> Lad
        L8a:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r5.subtreeChangedLayoutNodes     // Catch: java.lang.Throwable -> Lad
            r0.clear()     // Catch: java.lang.Throwable -> Lad
            long r6 = r5.SendRecurringContentCaptureEventsIntervalMillis     // Catch: java.lang.Throwable -> Lad
            r10.L$0 = r5     // Catch: java.lang.Throwable -> Lad
            r10.L$1 = r4     // Catch: java.lang.Throwable -> Lad
            r0 = 2
            r10.label = r0     // Catch: java.lang.Throwable -> Lad
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r6, r10)     // Catch: java.lang.Throwable -> Lad
            if (r0 != r2) goto L9f
            return r2
        L9f:
            r0 = r1
            r1 = r2
            r2 = r4
            r4 = r5
        La3:
            goto L56
        La4:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r5.subtreeChangedLayoutNodes
            r0.clear()
            r0 = r5
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        Lad:
            r0 = move-exception
            r4 = r5
            r8 = r1
            r1 = r0
            r0 = r8
            goto Lb4
        Lb3:
            r1 = move-exception
        Lb4:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r2 = r4.subtreeChangedLayoutNodes
            r2.clear()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.contentCaptureChangeChecker);
        }
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeStateChangeIfNeeded(layoutNode);
        }
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        MutableIntSet newChildren;
        MutableIntSet newChildren2 = new MutableIntSet(0, 1, null);
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = replacedChildren$ui_release.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes$ui_release().contains(child.getId())) {
                if (!oldNode.getChildren().contains(child.getId())) {
                    notifySubtreeStateChangeIfNeeded(newNode.getLayoutNode());
                    return;
                }
                newChildren2.add(child.getId());
            }
        }
        IntSet this_$iv = oldNode.getChildren();
        int[] k$iv = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    newChildren = newChildren2;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            if (!newChildren2.contains(k$iv[index$iv$iv])) {
                                notifySubtreeStateChangeIfNeeded(newNode.getLayoutNode());
                                return;
                            }
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        newChildren2 = newChildren2;
                    }
                    newChildren = newChildren2;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                newChildren2 = newChildren;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = replacedChildren$ui_release2.get(index$iv2);
            SemanticsNode child2 = (SemanticsNode) item$iv2;
            if (getCurrentSemanticsNodes$ui_release().contains(child2.getId())) {
                Object value$iv = this.previousSemanticsNodes.get(child2.getId());
                if (value$iv != null) {
                    SemanticsNodeCopy prevNode = (SemanticsNodeCopy) value$iv;
                    sendSemanticsStructureChangeEvents(child2, prevNode);
                } else {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    private final void sendContentCaptureStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        IntObjectMap this_$iv;
        IntObjectMap this_$iv2;
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = replacedChildren$ui_release.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes$ui_release().contains(child.getId()) && !oldNode.getChildren().contains(child.getId())) {
                updateBuffersOnAppeared(child);
            }
        }
        IntObjectMap this_$iv3 = this.previousSemanticsNodes;
        int[] k$iv = this_$iv3.keys;
        long[] m$iv$iv = this_$iv3.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    this_$iv = this_$iv3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            this_$iv2 = this_$iv3;
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            int key = k$iv[index$iv$iv];
                            this_$iv2 = this_$iv3;
                            if (!getCurrentSemanticsNodes$ui_release().contains(key)) {
                                bufferContentCaptureViewDisappeared(key);
                            }
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        this_$iv3 = this_$iv2;
                    }
                    this_$iv = this_$iv3;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv3 = this_$iv;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = replacedChildren$ui_release2.get(index$iv2);
            SemanticsNode child2 = (SemanticsNode) item$iv2;
            if (getCurrentSemanticsNodes$ui_release().contains(child2.getId()) && this.previousSemanticsNodes.contains(child2.getId())) {
                Object value$iv = this.previousSemanticsNodes.get(child2.getId());
                if (value$iv != null) {
                    SemanticsNodeCopy prevNodeCopy = (SemanticsNodeCopy) value$iv;
                    sendContentCaptureStructureChangeEvents(child2, prevNodeCopy);
                } else {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap;
        int $i$f$forEachKey;
        int[] k$iv;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap3;
        int $i$f$forEachKey2;
        int[] k$iv2;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap4;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap5 = newSemanticsNodes;
        int $i$f$forEachKey3 = 0;
        int[] k$iv3 = intObjectMap5.keys;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap6 = intObjectMap5;
        long[] m$iv$iv = intObjectMap6.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                intObjectMap = intObjectMap5;
                $i$f$forEachKey = $i$f$forEachKey3;
                k$iv = k$iv3;
                intObjectMap2 = intObjectMap6;
            } else {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                int j$iv$iv = 0;
                while (j$iv$iv < bitCount$iv$iv) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    if (!(value$iv$iv$iv < 128)) {
                        intObjectMap3 = intObjectMap5;
                        $i$f$forEachKey2 = $i$f$forEachKey3;
                        k$iv2 = k$iv3;
                        intObjectMap4 = intObjectMap6;
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        int id = k$iv3[index$iv$iv];
                        intObjectMap3 = intObjectMap5;
                        IntObjectMap this_$iv = this.previousSemanticsNodes;
                        SemanticsNodeCopy oldNode = this_$iv.get(id);
                        $i$f$forEachKey2 = $i$f$forEachKey3;
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = newSemanticsNodes.get(id);
                        SemanticsNode newNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                        if (newNode != null) {
                            if (oldNode == null) {
                                Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = newNode.getUnmergedConfig().iterator();
                                while (it.hasNext()) {
                                    k$iv3 = k$iv3;
                                    if (Intrinsics.areEqual(it.next().getKey(), SemanticsProperties.INSTANCE.getText())) {
                                        List list = (List) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                                        sendContentCaptureTextUpdateEvent(newNode.getId(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null));
                                        intObjectMap6 = intObjectMap6;
                                    }
                                }
                                k$iv2 = k$iv3;
                                intObjectMap4 = intObjectMap6;
                            } else {
                                k$iv2 = k$iv3;
                                intObjectMap4 = intObjectMap6;
                                Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it2 = newNode.getUnmergedConfig().iterator();
                                while (it2.hasNext()) {
                                    it2 = it2;
                                    if (Intrinsics.areEqual(it2.next().getKey(), SemanticsProperties.INSTANCE.getText())) {
                                        List list2 = (List) SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                                        AnnotatedString oldText = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list2) : null;
                                        SemanticsNodeCopy oldNode2 = oldNode;
                                        List list3 = (List) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                                        AnnotatedString newText = list3 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list3) : null;
                                        if (Intrinsics.areEqual(oldText, newText)) {
                                            oldNode = oldNode2;
                                        } else {
                                            sendContentCaptureTextUpdateEvent(newNode.getId(), String.valueOf(newText));
                                            oldNode = oldNode2;
                                        }
                                    }
                                }
                            }
                        } else {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                    }
                    slot$iv$iv >>= 8;
                    j$iv$iv++;
                    intObjectMap5 = intObjectMap3;
                    $i$f$forEachKey3 = $i$f$forEachKey2;
                    intObjectMap6 = intObjectMap4;
                    k$iv3 = k$iv2;
                }
                intObjectMap = intObjectMap5;
                $i$f$forEachKey = $i$f$forEachKey3;
                k$iv = k$iv3;
                intObjectMap2 = intObjectMap6;
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            }
            i$iv$iv++;
            intObjectMap5 = intObjectMap;
            $i$f$forEachKey3 = $i$f$forEachKey;
            intObjectMap6 = intObjectMap2;
            k$iv3 = k$iv;
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int id, String newText) {
        ContentCaptureSessionCompat session;
        if (Build.VERSION.SDK_INT >= 29 && (session = this.contentCaptureSession) != null) {
            AutofillId autofillId = session.newAutofillId(id);
            if (autofillId != null) {
                session.notifyViewTextChanged(autofillId, newText);
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void updateSemanticsCopy() {
        int[] k$iv;
        Object[] v$iv;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap;
        int $i$f$forEachIndexed;
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        int $i$f$forEach = 0;
        int[] k$iv2 = currentSemanticsNodes$ui_release.keys;
        Object[] v$iv2 = currentSemanticsNodes$ui_release.values;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2 = currentSemanticsNodes$ui_release;
        int $i$f$forEachIndexed2 = 0;
        long[] m$iv$iv = intObjectMap2.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap3 = currentSemanticsNodes$ui_release;
                int $i$f$forEach2 = $i$f$forEach;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    k$iv = k$iv2;
                    v$iv = v$iv2;
                    intObjectMap = intObjectMap2;
                    $i$f$forEachIndexed = $i$f$forEachIndexed2;
                } else {
                    int i = 8;
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            int key = k$iv2[index$iv$iv];
                            SemanticsNodeWithAdjustedBounds value = (SemanticsNodeWithAdjustedBounds) v$iv2[index$iv$iv];
                            this.previousSemanticsNodes.set(key, new SemanticsNodeCopy(value.getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
                        }
                        i = 8;
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        k$iv2 = k$iv2;
                        v$iv2 = v$iv2;
                        intObjectMap2 = intObjectMap2;
                        $i$f$forEachIndexed2 = $i$f$forEachIndexed2;
                    }
                    k$iv = k$iv2;
                    v$iv = v$iv2;
                    intObjectMap = intObjectMap2;
                    $i$f$forEachIndexed = $i$f$forEachIndexed2;
                    if (bitCount$iv$iv != i) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                currentSemanticsNodes$ui_release = intObjectMap3;
                $i$f$forEach = $i$f$forEach2;
                k$iv2 = k$iv;
                v$iv2 = v$iv;
                intObjectMap2 = intObjectMap;
                $i$f$forEachIndexed2 = $i$f$forEachIndexed;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    private final void notifySubtreeStateChangeIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo9059trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode $this$toViewStructure) {
        AutofillIdCompat rootAutofillId;
        AutofillId parentAutofillId;
        String it;
        ContentCaptureSessionCompat session = this.contentCaptureSession;
        if (session == null || Build.VERSION.SDK_INT < 29 || (rootAutofillId = ViewCompatShims.getAutofillId(this.view)) == null) {
            return null;
        }
        SemanticsNode parentNode = $this$toViewStructure.getParent();
        if (parentNode != null) {
            parentAutofillId = session.newAutofillId(parentNode.getId());
            if (parentAutofillId == null) {
                return null;
            }
        } else {
            parentAutofillId = rootAutofillId.toAutofillId();
        }
        ViewStructureCompat structure = session.newVirtualViewStructure(parentAutofillId, $this$toViewStructure.getId());
        if (structure == null) {
            return null;
        }
        SemanticsConfiguration configuration = $this$toViewStructure.getUnmergedConfig();
        if (configuration.contains(SemanticsProperties.INSTANCE.getPassword())) {
            return null;
        }
        Bundle extras = structure.getExtras();
        if (extras != null) {
            extras.putLong("android.view.contentcapture.EventTimestamp", this.currentSemanticsNodesSnapshotTimestampMillis);
        }
        String it2 = (String) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getTestTag());
        if (it2 != null) {
            structure.setId($this$toViewStructure.getId(), null, null, it2);
        }
        List it3 = (List) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getText());
        if (it3 != null) {
            structure.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextClassName);
            structure.setText(ListUtilsKt.fastJoinToString$default(it3, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 62, null));
        }
        AnnotatedString it4 = (AnnotatedString) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getEditableText());
        if (it4 != null) {
            structure.setClassName(AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
            structure.setText(it4);
        }
        List it5 = (List) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getContentDescription());
        if (it5 != null) {
            structure.setContentDescription(ListUtilsKt.fastJoinToString$default(it5, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 62, null));
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(configuration, SemanticsProperties.INSTANCE.getRole());
        if (role != null && (it = SemanticsUtils_androidKt.m5785toLegacyClassNameV4PA4sw(role.getValue())) != null) {
            structure.setClassName(it);
        }
        TextLayoutResult it6 = SemanticsUtils_androidKt.getTextLayoutResult(configuration);
        if (it6 != null) {
            TextLayoutInput input = it6.getLayoutInput();
            float px = TextUnit.m6750getValueimpl(input.getStyle().m6034getFontSizeXSAIIZE()) * input.getDensity().getDensity() * input.getDensity().getFontScale();
            structure.setTextStyle(px, 0, 0, 0);
        }
        Rect $this$toViewStructure_u24lambda_u2419 = $this$toViewStructure.getBoundsInParent$ui_release();
        structure.setDimens((int) $this$toViewStructure_u24lambda_u2419.getLeft(), (int) $this$toViewStructure_u24lambda_u2419.getTop(), 0, 0, (int) $this$toViewStructure_u24lambda_u2419.getWidth(), (int) $this$toViewStructure_u24lambda_u2419.getHeight());
        return structure;
    }

    private final void bufferContentCaptureViewAppeared(int virtualId, ViewStructureCompat viewStructure) {
        if (viewStructure == null) {
            return;
        }
        if (this.bufferedDisappearedNodes.contains(virtualId)) {
            this.bufferedDisappearedNodes.remove(virtualId);
        } else {
            this.bufferedAppearedNodes.set(virtualId, viewStructure);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int virtualId) {
        if (this.bufferedAppearedNodes.containsKey(virtualId)) {
            this.bufferedAppearedNodes.remove(virtualId);
        } else {
            this.bufferedDisappearedNodes.add(virtualId);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x008b A[LOOP:0: B:12:0x0037->B:26:0x008b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x0094 A[EDGE_INSN: B:62:0x0094->B:29:0x0094 BREAK  A[LOOP:0: B:12:0x0037->B:26:0x008b], SYNTHETIC] */
    private final void notifyContentCaptureChanges() {
        ContentCaptureSessionCompat session = this.contentCaptureSession;
        if (session == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        char c = 7;
        if (this.bufferedAppearedNodes.isNotEmpty()) {
            List $this$fastMap$iv = new ArrayList();
            IntObjectMap this_$iv = this.bufferedAppearedNodes;
            Object[] v$iv = this_$iv.values;
            IntObjectMap this_$iv$iv = this_$iv;
            long[] m$iv$iv = this_$iv$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 <= lastIndex$iv$iv) {
                while (true) {
                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                    IntObjectMap this_$iv$iv2 = this_$iv$iv;
                    if ((((~slot$iv$iv) << c) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                            break;
                        } else {
                            i$iv$iv++;
                            this_$iv$iv = this_$iv$iv2;
                            c = 7;
                        }
                    } else {
                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                        for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                            long value$iv$iv$iv = slot$iv$iv & 255;
                            int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                            if ($i$f$isFull != 0) {
                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                ViewStructureCompat it = (ViewStructureCompat) v$iv[index$iv$iv];
                                $this$fastMap$iv.add(it);
                            }
                            slot$iv$iv >>= 8;
                        }
                        if (bitCount$iv$iv != 8) {
                            break;
                        }
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                        }
                        i$iv$iv++;
                        this_$iv$iv = this_$iv$iv2;
                        c = 7;
                    }
                }
            }
            List target$iv = new ArrayList($this$fastMap$iv.size());
            int size = $this$fastMap$iv.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size; index$iv$iv2++) {
                Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv2);
                ViewStructureCompat it2 = (ViewStructureCompat) item$iv$iv;
                target$iv.add(it2.toViewStructure());
            }
            session.notifyViewsAppeared(target$iv);
            this.bufferedAppearedNodes.clear();
        }
        if (this.bufferedDisappearedNodes.isNotEmpty()) {
            List $this$fastMap$iv2 = new ArrayList();
            int i = 0;
            IntSet this_$iv2 = this.bufferedDisappearedNodes;
            int[] k$iv = this_$iv2.elements;
            IntSet this_$iv$iv3 = this_$iv2;
            int $i$f$forEachIndex = 0;
            long[] m$iv$iv2 = this_$iv$iv3.metadata;
            int lastIndex$iv$iv2 = m$iv$iv2.length - 2;
            int i$iv$iv2 = 0;
            if (0 <= lastIndex$iv$iv2) {
                while (true) {
                    long slot$iv$iv2 = m$iv$iv2[i$iv$iv2];
                    int i2 = i;
                    IntSet this_$iv3 = this_$iv2;
                    IntSet this_$iv$iv4 = this_$iv$iv3;
                    int $i$f$forEachIndex2 = $i$f$forEachIndex;
                    long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L);
                    if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                        int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                        for (int j$iv$iv2 = 0; j$iv$iv2 < bitCount$iv$iv2; j$iv$iv2++) {
                            long value$iv$iv$iv2 = slot$iv$iv2 & 255;
                            int $i$f$isFull2 = value$iv$iv$iv2 < 128 ? 1 : 0;
                            if ($i$f$isFull2 != 0) {
                                int index$iv$iv3 = (i$iv$iv2 << 3) + j$iv$iv2;
                                int it3 = k$iv[index$iv$iv3];
                                $this$fastMap$iv2.add(Integer.valueOf(it3));
                            }
                            slot$iv$iv2 >>= 8;
                        }
                        if (bitCount$iv$iv2 != 8) {
                            break;
                        }
                    }
                    if (i$iv$iv2 == lastIndex$iv$iv2) {
                        break;
                    }
                    i$iv$iv2++;
                    this_$iv$iv3 = this_$iv$iv4;
                    $i$f$forEachIndex = $i$f$forEachIndex2;
                    i = i2;
                    this_$iv2 = this_$iv3;
                }
            }
            List target$iv2 = new ArrayList($this$fastMap$iv2.size());
            int size2 = $this$fastMap$iv2.size();
            for (int index$iv$iv4 = 0; index$iv$iv4 < size2; index$iv$iv4++) {
                Object item$iv$iv2 = $this$fastMap$iv2.get(index$iv$iv4);
                int it4 = ((Number) item$iv$iv2).intValue();
                target$iv2.add(Long.valueOf(it4));
            }
            session.notifyViewsDisappeared(CollectionsKt.toLongArray(target$iv2));
            this.bufferedDisappearedNodes.clear();
        }
    }

    private final void updateBuffersOnAppeared(SemanticsNode node) {
        if (!isEnabled$ui_release()) {
            return;
        }
        updateTranslationOnAppeared(node);
        bufferContentCaptureViewAppeared(node.getId(), toViewStructure(node));
        List<SemanticsNode> replacedChildren$ui_release = node.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = replacedChildren$ui_release.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            updateBuffersOnAppeared(child);
        }
    }

    private final void updateBuffersOnDisappeared(SemanticsNode node) {
        if (!isEnabled$ui_release()) {
            return;
        }
        bufferContentCaptureViewDisappeared(node.getId());
        List<SemanticsNode> replacedChildren$ui_release = node.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = replacedChildren$ui_release.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            updateBuffersOnDisappeared(child);
        }
    }

    private final void updateTranslationOnAppeared(SemanticsNode node) {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        Function1 function2;
        SemanticsConfiguration config = node.getUnmergedConfig();
        Boolean isShowingTextSubstitution = (Boolean) SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        if (this.translateStatus == TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual((Object) isShowingTextSubstitution, (Object) true)) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(config, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if (accessibilityAction2 != null && (function2 = (Function1) accessibilityAction2.getAction()) != null) {
                return;
            }
            return;
        }
        if (this.translateStatus == TranslateStatus.SHOW_TRANSLATED && Intrinsics.areEqual((Object) isShowingTextSubstitution, (Object) false) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(config, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
        }
    }

    public final void onShowTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    public final void onHideTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    public final void onClearTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    private final void showTranslatedText() {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap;
        int $i$f$forEachValue;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2;
        int $i$f$forEachValue2;
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        int $i$f$forEachValue3 = 0;
        Object[] v$iv = currentSemanticsNodes$ui_release.values;
        long[] m$iv$iv = currentSemanticsNodes$ui_release.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                intObjectMap = currentSemanticsNodes$ui_release;
                $i$f$forEachValue = $i$f$forEachValue3;
            } else {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                int j$iv$iv = 0;
                while (j$iv$iv < bitCount$iv$iv) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    if (!(value$iv$iv$iv < 128)) {
                        intObjectMap2 = currentSemanticsNodes$ui_release;
                        $i$f$forEachValue2 = $i$f$forEachValue3;
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        SemanticsNodeWithAdjustedBounds node = (SemanticsNodeWithAdjustedBounds) v$iv[index$iv$iv];
                        SemanticsConfiguration config = node.getSemanticsNode().getUnmergedConfig();
                        intObjectMap2 = currentSemanticsNodes$ui_release;
                        $i$f$forEachValue2 = $i$f$forEachValue3;
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), (Object) false) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(config, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    slot$iv$iv >>= 8;
                    j$iv$iv++;
                    $i$f$forEachValue3 = $i$f$forEachValue2;
                    currentSemanticsNodes$ui_release = intObjectMap2;
                }
                intObjectMap = currentSemanticsNodes$ui_release;
                $i$f$forEachValue = $i$f$forEachValue3;
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            }
            i$iv$iv++;
            $i$f$forEachValue3 = $i$f$forEachValue;
            currentSemanticsNodes$ui_release = intObjectMap;
        }
    }

    private final void hideTranslatedText() {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap;
        int $i$f$forEachValue;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2;
        int $i$f$forEachValue2;
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        int $i$f$forEachValue3 = 0;
        Object[] v$iv = currentSemanticsNodes$ui_release.values;
        long[] m$iv$iv = currentSemanticsNodes$ui_release.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                intObjectMap = currentSemanticsNodes$ui_release;
                $i$f$forEachValue = $i$f$forEachValue3;
            } else {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                int j$iv$iv = 0;
                while (j$iv$iv < bitCount$iv$iv) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    if (!(value$iv$iv$iv < 128)) {
                        intObjectMap2 = currentSemanticsNodes$ui_release;
                        $i$f$forEachValue2 = $i$f$forEachValue3;
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        SemanticsNodeWithAdjustedBounds node = (SemanticsNodeWithAdjustedBounds) v$iv[index$iv$iv];
                        SemanticsConfiguration config = node.getSemanticsNode().getUnmergedConfig();
                        intObjectMap2 = currentSemanticsNodes$ui_release;
                        $i$f$forEachValue2 = $i$f$forEachValue3;
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), (Object) true) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(config, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    slot$iv$iv >>= 8;
                    j$iv$iv++;
                    $i$f$forEachValue3 = $i$f$forEachValue2;
                    currentSemanticsNodes$ui_release = intObjectMap2;
                }
                intObjectMap = currentSemanticsNodes$ui_release;
                $i$f$forEachValue = $i$f$forEachValue3;
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            }
            i$iv$iv++;
            $i$f$forEachValue3 = $i$f$forEachValue;
            currentSemanticsNodes$ui_release = intObjectMap;
        }
    }

    private final void clearTranslatedText() {
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2;
        AccessibilityAction accessibilityAction;
        Function0 function0;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] v$iv = currentSemanticsNodes$ui_release.values;
        long[] m$iv$iv = currentSemanticsNodes$ui_release.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                intObjectMap = currentSemanticsNodes$ui_release;
            } else {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                int j$iv$iv = 0;
                while (j$iv$iv < bitCount$iv$iv) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    if (!(value$iv$iv$iv < 128)) {
                        intObjectMap2 = currentSemanticsNodes$ui_release;
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        SemanticsNodeWithAdjustedBounds node = (SemanticsNodeWithAdjustedBounds) v$iv[index$iv$iv];
                        SemanticsConfiguration config = node.getSemanticsNode().getUnmergedConfig();
                        intObjectMap2 = currentSemanticsNodes$ui_release;
                        if (SemanticsConfigurationKt.getOrNull(config, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(config, SemanticsActions.INSTANCE.getClearTextSubstitution())) != null && (function0 = (Function0) accessibilityAction.getAction()) != null) {
                        }
                    }
                    slot$iv$iv >>= 8;
                    j$iv$iv++;
                    currentSemanticsNodes$ui_release = intObjectMap2;
                }
                intObjectMap = currentSemanticsNodes$ui_release;
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            }
            i$iv$iv++;
            currentSemanticsNodes$ui_release = intObjectMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AndroidContentCaptureManager.android.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0007J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods;", "", "()V", "doTranslation", "", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class ViewTranslationHelperMethods {
        public static final ViewTranslationHelperMethods INSTANCE = new ViewTranslationHelperMethods();

        private ViewTranslationHelperMethods() {
        }

        public final void onCreateVirtualViewTranslationRequests(AndroidContentCaptureManager contentCaptureManager, long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
            SemanticsNode node;
            String strFastJoinToString$default;
            for (long element$iv : virtualIds) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) element$iv);
                if (semanticsNodeWithAdjustedBounds != null && (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
                    ViewTranslationRequest.Builder requestBuilder = new ViewTranslationRequest.Builder(contentCaptureManager.getView().getAutofillId(), node.getId());
                    List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                    if (list != null && (strFastJoinToString$default = ListUtilsKt.fastJoinToString$default(list, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 62, null)) != null) {
                        AnnotatedString text = new AnnotatedString(strFastJoinToString$default, null, null, 6, null);
                        requestBuilder.setValue("android:text", TranslationRequestValue.forText(text));
                        requestsCollector.accept(requestBuilder.build());
                    }
                }
            }
        }

        public final void onVirtualViewTranslationResponses(final AndroidContentCaptureManager contentCaptureManager, final LongSparseArray<ViewTranslationResponse> response) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                doTranslation(contentCaptureManager, response);
            } else {
                contentCaptureManager.getView().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$1(contentCaptureManager, response);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager $contentCaptureManager, LongSparseArray $response) {
            INSTANCE.doTranslation($contentCaptureManager, $response);
        }

        private final void doTranslation(AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
            TranslationResponseValue value;
            CharSequence it;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            SemanticsNode semanticsNode;
            AccessibilityAction accessibilityAction;
            Function1 function1;
            LongIterator longIteratorKeyIterator = LongSparseArrayKt.keyIterator(response);
            while (longIteratorKeyIterator.hasNext()) {
                long key = longIteratorKeyIterator.nextLong();
                ViewTranslationResponse viewTranslationResponse = response.get(key);
                if (viewTranslationResponse != null && (value = viewTranslationResponse.getValue("android:text")) != null && (it = value.getText()) != null && (semanticsNodeWithAdjustedBounds = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) key)) != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                }
            }
        }
    }

    public final void onCreateVirtualViewTranslationRequests$ui_release(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, virtualIds, supportedFormats, requestsCollector);
    }

    public final void onVirtualViewTranslationResponses$ui_release(AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
        ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(contentCaptureManager, response);
    }
}
