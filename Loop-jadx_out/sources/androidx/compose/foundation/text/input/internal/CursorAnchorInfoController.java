package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.p001ui.graphics.Matrix;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CursorAnchorInfoController.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoController;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "monitorScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/CoroutineScope;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "monitorEnabled", "monitorJob", "Lkotlinx/coroutines/Job;", "calculateCursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "requestUpdates", "", "immediate", "monitor", "cursorUpdateMode", "", "startOrStopMonitoring", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CursorAnchorInfoController {
    public static final int $stable = 8;
    private final ComposeInputMethodManager composeImm;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private boolean monitorEnabled;
    private Job monitorJob;
    private final CoroutineScope monitorScope;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    private final float[] matrix = Matrix.m4529constructorimpl$default(null, 1, null);
    private final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    public CursorAnchorInfoController(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, ComposeInputMethodManager composeImm, CoroutineScope monitorScope) {
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.composeImm = composeImm;
        this.monitorScope = monitorScope;
    }

    public final void requestUpdates(int cursorUpdateMode) {
        boolean includeCharacterBounds;
        boolean includeEditorBounds;
        boolean includeLineBounds;
        boolean immediate = (cursorUpdateMode & 1) != 0;
        boolean monitor = (cursorUpdateMode & 2) != 0;
        boolean includeInsertionMarker = true;
        boolean includeLineBounds2 = false;
        if (Build.VERSION.SDK_INT < 33) {
            includeCharacterBounds = true;
            includeEditorBounds = false;
            includeLineBounds = false;
        } else {
            includeInsertionMarker = (cursorUpdateMode & 16) != 0;
            boolean includeCharacterBounds2 = (cursorUpdateMode & 8) != 0;
            boolean includeEditorBounds2 = (cursorUpdateMode & 4) != 0;
            if (Build.VERSION.SDK_INT >= 34) {
                includeLineBounds2 = (cursorUpdateMode & 32) != 0;
            }
            if (!includeInsertionMarker && !includeCharacterBounds2 && !includeEditorBounds2 && !includeLineBounds2) {
                includeInsertionMarker = true;
                if (Build.VERSION.SDK_INT >= 34) {
                    includeCharacterBounds = true;
                    includeEditorBounds = true;
                    includeLineBounds = true;
                } else {
                    includeCharacterBounds = true;
                    includeEditorBounds = true;
                    includeLineBounds = includeLineBounds2;
                }
            } else {
                includeCharacterBounds = includeCharacterBounds2;
                includeEditorBounds = includeEditorBounds2;
                includeLineBounds = includeLineBounds2;
            }
        }
        requestUpdates(immediate, monitor, includeInsertionMarker, includeCharacterBounds, includeEditorBounds, includeLineBounds);
    }

    private final void requestUpdates(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        this.includeInsertionMarker = includeInsertionMarker;
        this.includeCharacterBounds = includeCharacterBounds;
        this.includeEditorBounds = includeEditorBounds;
        this.includeLineBounds = includeLineBounds;
        if (immediate) {
            this.hasPendingImmediateRequest = true;
            CursorAnchorInfo p0 = calculateCursorAnchorInfo();
            if (p0 != null) {
                this.composeImm.updateCursorAnchorInfo(p0);
            }
        }
        this.monitorEnabled = monitor;
        startOrStopMonitoring();
    }

    private final void startOrStopMonitoring() {
        if (this.monitorEnabled) {
            Job job = this.monitorJob;
            if (!(job != null && job.isActive())) {
                this.monitorJob = BuildersKt__Builders_commonKt.launch$default(this.monitorScope, null, CoroutineStart.UNDISPATCHED, new C07981(null), 1, null);
                return;
            }
            return;
        }
        Job job2 = this.monitorJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.monitorJob = null;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1 */
    /* JADX INFO: compiled from: CursorAnchorInfoController.android.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1", m210f = "CursorAnchorInfoController.android.kt", m211i = {}, m212l = {157}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C07981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07981(Continuation<? super C07981> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CursorAnchorInfoController.this.new C07981(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final CursorAnchorInfoController cursorAnchorInfoController = CursorAnchorInfoController.this;
                    Flow flowFilterNotNull = FlowKt.filterNotNull(FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0<CursorAnchorInfo>() { // from class: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController.startOrStopMonitoring.1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final CursorAnchorInfo invoke() {
                            return cursorAnchorInfoController.calculateCursorAnchorInfo();
                        }
                    }), 1));
                    final CursorAnchorInfoController cursorAnchorInfoController2 = CursorAnchorInfoController.this;
                    this.label = 1;
                    if (flowFilterNotNull.collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController.startOrStopMonitoring.1.2
                        public final Object emit(CursorAnchorInfo it, Continuation<? super Unit> continuation) {
                            cursorAnchorInfoController2.composeImm.updateCursorAnchorInfo(it);
                            return Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((CursorAnchorInfo) value, (Continuation<? super Unit>) $completion);
                        }
                    }, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final CursorAnchorInfo calculateCursorAnchorInfo() {
        LayoutCoordinates decorationBoxCoordinates;
        TextLayoutResult textLayoutResult;
        LayoutCoordinates coreCoordinates = this.textLayoutState.getCoreNodeCoordinates();
        if (coreCoordinates != null) {
            if (!coreCoordinates.isAttached()) {
                coreCoordinates = null;
            }
            if (coreCoordinates != null && (decorationBoxCoordinates = this.textLayoutState.getDecoratorNodeCoordinates()) != null) {
                if (!decorationBoxCoordinates.isAttached()) {
                    decorationBoxCoordinates = null;
                }
                if (decorationBoxCoordinates == null || (textLayoutResult = this.textLayoutState.getLayoutResult()) == null) {
                    return null;
                }
                TextFieldCharSequence text = this.textFieldState.getVisualText();
                Matrix.m4538resetimpl(this.matrix);
                coreCoordinates.mo5653transformToScreen58bKbWc(this.matrix);
                AndroidMatrixConversions_androidKt.m4161setFromEL8BTi8(this.androidMatrix, this.matrix);
                Rect innerTextFieldBounds = SelectionManagerKt.visibleBounds(coreCoordinates);
                Rect decorationBoxBounds = coreCoordinates.localBoundingBoxOf(decorationBoxCoordinates, false);
                return CursorAnchorInfoBuilder_androidKt.m1305buildvxqZcH0(this.builder, text, text.getSelection(), text.getComposition(), textLayoutResult, this.androidMatrix, innerTextFieldBounds, decorationBoxBounds, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds);
            }
            return null;
        }
        return null;
    }
}
