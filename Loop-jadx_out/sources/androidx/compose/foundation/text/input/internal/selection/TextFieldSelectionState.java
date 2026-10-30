package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.RectKt;
import androidx.compose.p001ui.hapticfeedback.HapticFeedback;
import androidx.compose.p001ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.platform.ClipEntry;
import androidx.compose.p001ui.platform.ClipMetadata;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.TextToolbar;
import androidx.compose.p001ui.platform.TextToolbarStatus;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextRangeKt;
import androidx.compose.p001ui.text.style.ResolvedTextDirection;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: TextFieldSelectionState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0006\u0010]\u001a\u00020^J\u0010\u0010_\u001a\u00020^2\b\b\u0002\u0010`\u001a\u00020\tJ\u0006\u0010a\u001a\u00020^J\u0006\u0010b\u001a\u00020^J\u0006\u0010c\u001a\u00020^J\b\u0010d\u001a\u00020\u001eH\u0002J\u001d\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hJ\u001d\u0010i\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\t2\u0006\u0010j\u001a\u00020\tH\u0000¢\u0006\u0002\bkJ<\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u0002092\u0006\u0010o\u001a\u0002092\b\u0010p\u001a\u0004\u0018\u00010m2\u0006\u0010f\u001a\u00020\t2\u0006\u0010q\u001a\u00020rH\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010tJ\b\u0010u\u001a\u00020^H\u0002J\b\u0010v\u001a\u00020^H\u0002J\u000e\u0010w\u001a\u00020^H\u0086@¢\u0006\u0002\u0010xJ\u000e\u0010y\u001a\u00020^H\u0082@¢\u0006\u0002\u0010xJ\u000e\u0010z\u001a\u00020^H\u0082@¢\u0006\u0002\u0010xJ\u0006\u0010{\u001a\u00020^J\b\u0010|\u001a\u00020^H\u0002J\u001b\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0012\u0010\u0081\u0001\u001a\u00020^2\u0007\u0010\u0082\u0001\u001a\u00020\u001eH\u0002J7\u0010\u0083\u0001\u001a\u00020^2\u0006\u0010/\u001a\u0002002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020U2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ%\u0010\u0084\u0001\u001a\u00020^2\u0007\u0010\u0085\u0001\u001a\u00020#2\u0007\u0010\u0086\u0001\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001JO\u0010\u0089\u0001\u001a\u00020m2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u0002092\u0007\u0010\u008d\u0001\u001a\u0002092\u0006\u0010f\u001a\u00020\t2\u0006\u0010q\u001a\u00020r2\t\b\u0002\u0010\u008e\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u000f\u0010\u0091\u0001\u001a\u00020^2\u0006\u0010W\u001a\u00020VJ\u0015\u0010\u0092\u0001\u001a\u00020^*\u00030\u0093\u0001H\u0086@¢\u0006\u0003\u0010\u0094\u0001J\u0015\u0010\u0095\u0001\u001a\u00020^*\u00030\u0093\u0001H\u0082@¢\u0006\u0003\u0010\u0094\u0001J\u001d\u0010\u0096\u0001\u001a\u00020^*\u00030\u0093\u00012\u0006\u0010f\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010\u0097\u0001J$\u0010\u0098\u0001\u001a\u00020^*\u00030\u0093\u00012\r\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020^0BH\u0086@¢\u0006\u0003\u0010\u009a\u0001J?\u0010\u009b\u0001\u001a\u00020^*\u00030\u0093\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\r\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020^0B2\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020^0BH\u0086@¢\u0006\u0003\u0010\u009f\u0001J\u0015\u0010 \u0001\u001a\u00020^*\u00030\u0093\u0001H\u0086@¢\u0006\u0003\u0010\u0094\u0001J\u001d\u0010¡\u0001\u001a\u00020^*\u00030\u0093\u00012\u0006\u0010f\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010\u0097\u0001R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\u00020\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b.\u0010\u0012R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b1\u00102R+\u00103\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010*\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u00102R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010<\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b@\u0010*\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010?R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR+\u0010H\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010*\u001a\u0004\bI\u0010\u001b\"\u0004\bJ\u00102R1\u0010L\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bO\u0010*\u001a\u0004\bM\u0010\u0012\"\u0004\bN\u0010?R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010W\u001a\u00020V2\u0006\u0010\"\u001a\u00020V8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010*\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¢\u0001"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentContentVisibleOffset", "Landroidx/compose/ui/geometry/Offset;", "getCurrentContentVisibleOffset-F1C5BW0", "()J", "cursorHandle", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getCursorHandle", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "cursorHandle$delegate", "Landroidx/compose/runtime/State;", "cursorHandleInBounds", "getCursorHandleInBounds", "()Z", "cursorHandleInBounds$delegate", "cursorRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorRect", "()Landroidx/compose/ui/geometry/Rect;", "cursorRect$delegate", "<set-?>", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/runtime/MutableState;", "editable", "getEditable", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "receiveContentConfiguration", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "()Lkotlin/jvm/functions/Function0;", "setReceiveContentConfiguration", "(Lkotlin/jvm/functions/Function0;)V", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startContentVisibleOffset", "getStartContentVisibleOffset-F1C5BW0", "setStartContentVisibleOffset-k-4lQ0M", "startContentVisibleOffset$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "includePosition", "getSelectionHandleState$foundation_release", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "markStartContentVisibleOffset", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "pasteAsPlainText", "placeCursorAtNearestOffset", "offset", "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "showTextToolbar", "contentRect", "update", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "updateSelection-QNhciaU", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldLongPressAndAfterDrag", "requestFocus", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private Density density;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private PressInteraction.Press pressInteraction;
    private SelectionLayout previousSelectionLayout;
    private boolean readOnly;
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;

    /* JADX INFO: renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);

    /* JADX INFO: renamed from: startContentVisibleOffset$delegate, reason: from kotlin metadata */
    private final MutableState startContentVisibleOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4038boximpl(Offset.INSTANCE.m4064getUnspecifiedF1C5BW0()), null, 2, null);

    /* JADX INFO: renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState rawHandleDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4038boximpl(Offset.INSTANCE.m4064getUnspecifiedF1C5BW0()), null, 2, null);

    /* JADX INFO: renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
    private int previousRawDragOffset = -1;

    /* JADX INFO: renamed from: cursorHandle$delegate, reason: from kotlin metadata */
    private final State cursorHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextFieldHandleState invoke() {
            TextFieldCharSequence text = this.this$0.textFieldState.getVisualText();
            boolean z = false;
            if (this.this$0.getShowCursorHandle() && TextRange.m6245getCollapsedimpl(text.getSelection())) {
                if ((text.length() > 0) && (this.this$0.getDraggingHandle() == Handle.Cursor || this.this$0.getCursorHandleInBounds())) {
                    z = true;
                }
            }
            boolean visible = z;
            return !visible ? TextFieldHandleState.INSTANCE.getHidden() : new TextFieldHandleState(true, this.this$0.getCursorRect().m4076getBottomCenterF1C5BW0(), ResolvedTextDirection.Ltr, false, null);
        }
    });

    /* JADX INFO: renamed from: cursorHandleInBounds$delegate, reason: from kotlin metadata */
    private final State cursorHandleInBounds = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleInBounds$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Rect rectVisibleBounds;
            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
            TextFieldSelectionState textFieldSelectionState = this.this$0;
            Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
            Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
            try {
                long position = textFieldSelectionState.getCursorRect().m4076getBottomCenterF1C5BW0();
                this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                LayoutCoordinates textLayoutCoordinates = this.this$0.getTextLayoutCoordinates();
                return Boolean.valueOf((textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? false : SelectionManagerKt.m1516containsInclusiveUv8p0NA(rectVisibleBounds, position));
            } catch (Throwable th) {
                this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                throw th;
            }
        }
    });

    /* JADX INFO: renamed from: cursorRect$delegate, reason: from kotlin metadata */
    private final State cursorRect = SnapshotStateKt.derivedStateOf(new Function0<Rect>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorRect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Rect invoke() {
            float cursorCenterX;
            TextLayoutResult layoutResult = this.this$0.textLayoutState.getLayoutResult();
            if (layoutResult == null) {
                return Rect.INSTANCE.getZero();
            }
            TextFieldCharSequence value = this.this$0.textFieldState.getVisualText();
            if (!TextRange.m6245getCollapsedimpl(value.getSelection())) {
                return Rect.INSTANCE.getZero();
            }
            Rect cursorRect = layoutResult.getCursorRect(TextRange.m6251getStartimpl(value.getSelection()));
            Density $this$invoke_u24lambda_u240 = this.this$0.density;
            float cursorWidth = $this$invoke_u24lambda_u240.mo567toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
            if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
                cursorCenterX = cursorRect.getLeft() + (cursorWidth / 2);
            } else {
                cursorCenterX = cursorRect.getRight() - (cursorWidth / 2);
            }
            float f = 2;
            float coercedCursorCenterX = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(cursorCenterX, IntSize.m6975getWidthimpl(layoutResult.getSize()) - (cursorWidth / f)), cursorWidth / f);
            return new Rect(coercedCursorCenterX - (cursorWidth / f), cursorRect.getTop(), (cursorWidth / f) + coercedCursorCenterX, cursorRect.getBottom());
        }
    });

    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m210f = "TextFieldSelectionState.kt", m211i = {0, 0, 0}, m212l = {601}, m213m = "detectCursorHandleDragGestures", m214n = {"this", "cursorDragStart", "cursorDragDelta"}, m215s = {"L$0", "L$1", "L$2"})
    static final class C08441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C08441(Continuation<? super C08441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectCursorHandleDragGestures(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m210f = "TextFieldSelectionState.kt", m211i = {0, 0, 0, 0}, m212l = {836}, m213m = "detectSelectionHandleDragGestures", m214n = {"this", "dragBeginPosition", "dragTotalDistance", "handle"}, m215s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C08491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C08491(Continuation<? super C08491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectSelectionHandleDragGestures(null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", m210f = "TextFieldSelectionState.kt", m211i = {0}, m212l = {389}, m213m = "observeChanges", m214n = {"this"}, m215s = {"L$0"})
    static final class C08641 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08641(Continuation<? super C08641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.observeChanges(this);
        }
    }

    public TextFieldSelectionState(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, Density density, boolean enabled, boolean readOnly, boolean isFocused) {
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isFocused = isFocused;
    }

    /* JADX INFO: renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInTouchMode(boolean z) {
        MutableState $this$setValue$iv = this.isInTouchMode;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isInTouchMode() {
        State $this$getValue$iv = this.isInTouchMode;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final void setReceiveContentConfiguration(Function0<? extends ReceiveContentConfiguration> function0) {
        this.receiveContentConfiguration = function0;
    }

    /* JADX INFO: renamed from: getStartContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1397getStartContentVisibleOffsetF1C5BW0() {
        State $this$getValue$iv = this.startContentVisibleOffset;
        return ((Offset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* JADX INFO: renamed from: setStartContentVisibleOffset-k-4lQ0M, reason: not valid java name */
    private final void m1401setStartContentVisibleOffsetk4lQ0M(long j) {
        MutableState $this$setValue$iv = this.startContentVisibleOffset;
        $this$setValue$iv.setValue(Offset.m4038boximpl(j));
    }

    /* JADX INFO: renamed from: getCurrentContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1394getCurrentContentVisibleOffsetF1C5BW0() {
        Rect rectVisibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return (textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m4064getUnspecifiedF1C5BW0() : rectVisibleBounds.m4084getTopLeftF1C5BW0();
    }

    /* JADX INFO: renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m1396getRawHandleDragPositionF1C5BW0() {
        State $this$getValue$iv = this.rawHandleDragPosition;
        return ((Offset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* JADX INFO: renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m1400setRawHandleDragPositionk4lQ0M(long j) {
        MutableState $this$setValue$iv = this.rawHandleDragPosition;
        $this$setValue$iv.setValue(Offset.m4038boximpl(j));
    }

    /* JADX INFO: renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m1404getHandleDragPositionF1C5BW0() {
        if (OffsetKt.m4070isUnspecifiedk4lQ0M(m1396getRawHandleDragPositionF1C5BW0())) {
            return Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        }
        if (OffsetKt.m4070isUnspecifiedk4lQ0M(m1397getStartContentVisibleOffsetF1C5BW0())) {
            return TextLayoutStateKt.m1357fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1396getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m4053minusMKHz9U(Offset.m4054plusMKHz9U(m1396getRawHandleDragPositionF1C5BW0(), m1394getCurrentContentVisibleOffsetF1C5BW0()), m1397getStartContentVisibleOffsetF1C5BW0());
    }

    public final Handle getDraggingHandle() {
        State $this$getValue$iv = this.draggingHandle;
        return (Handle) $this$getValue$iv.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        MutableState $this$setValue$iv = this.draggingHandle;
        $this$setValue$iv.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShowCursorHandle() {
        State $this$getValue$iv = this.showCursorHandle;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        MutableState $this$setValue$iv = this.showCursorHandle;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextToolbarState getTextToolbarState() {
        State $this$getValue$iv = this.textToolbarState;
        return (TextToolbarState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        MutableState $this$setValue$iv = this.textToolbarState;
        $this$setValue$iv.setValue(textToolbarState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates it = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (it == null || !it.isAttached()) {
            return null;
        }
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    public final TextFieldHandleState getCursorHandle() {
        State $this$getValue$iv = this.cursorHandle;
        return (TextFieldHandleState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getCursorHandleInBounds() {
        State $this$getValue$iv = this.cursorHandleInBounds;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final Rect getCursorRect() {
        State $this$getValue$iv = this.cursorRect;
        return (Rect) $this$getValue$iv.getValue();
    }

    public final void update(HapticFeedback hapticFeedBack, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean enabled, boolean readOnly) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboardManager = clipboardManager;
        this.textToolbar = textToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C08432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08432(PointerInputScope pointerInputScope, Continuation<? super C08432> continuation) {
            super(2, continuation);
            this.$this_cursorHandleGestures = pointerInputScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08432 c08432 = TextFieldSelectionState.this.new C08432(this.$this_cursorHandleGestures, continuation);
            c08432.L$0 = obj;
            return c08432;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C08432) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {335}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_cursorHandleGestures, continuation);
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
                        if (this.this$0.detectTouchMode(this.$this_cursorHandleGestures, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(this.$this_cursorHandleGestures, TextFieldSelectionState.this, null), 1, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {338}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$this_cursorHandleGestures, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectCursorHandleDragGestures(this.$this_cursorHandleGestures, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {341}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$this_cursorHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$this_cursorHandleGestures, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                        final TextFieldSelectionState textFieldSelectionState = this.this$0;
                        Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.cursorHandleGestures.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m1406invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m1406invokek4lQ0M(long it) {
                                TextToolbarState textToolbarState;
                                TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                                if (textFieldSelectionState.getTextToolbarState() == TextToolbarState.Cursor) {
                                    textToolbarState = TextToolbarState.None;
                                } else {
                                    textToolbarState = TextToolbarState.Cursor;
                                }
                                textFieldSelectionState2.setTextToolbarState(textToolbarState);
                            }
                        };
                        this.label = 1;
                        if (TapGestureDetectorKt.detectTapGestures(pointerInputScope, (7 & 1) != 0 ? null : null, (7 & 2) != 0 ? null : null, (7 & 4) != 0 ? TapGestureDetectorKt.NoPressGesture : null, (7 & 8) != 0 ? null : function1, this) == coroutine_suspended) {
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

    public final Object cursorHandleGestures(PointerInputScope $this$cursorHandleGestures, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C08432($this$cursorHandleGestures, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C08712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08712(PointerInputScope pointerInputScope, boolean z, Continuation<? super C08712> continuation) {
            super(2, continuation);
            this.$this_selectionHandleGestures = pointerInputScope;
            this.$isStartHandle = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08712 c08712 = TextFieldSelectionState.this.new C08712(this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            c08712.L$0 = obj;
            return c08712;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C08712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {357}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_selectionHandleGestures, continuation);
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
                        if (this.this$0.detectTouchMode(this.$this_selectionHandleGestures, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionState.this, this.$this_selectionHandleGestures, null), 1, null);
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_selectionHandleGestures, TextFieldSelectionState.this, this.$isStartHandle, null), 1, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(TextFieldSelectionState.this, this.$this_selectionHandleGestures, this.$isStartHandle, null), 1, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {360}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, boolean z, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_selectionHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_selectionHandleGestures, this.this$0, this.$isStartHandle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                        final TextFieldSelectionState textFieldSelectionState = this.this$0;
                        final boolean z = this.$isStartHandle;
                        TapOnPosition tapOnPosition = new TapOnPosition() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.1
                            @Override // androidx.compose.foundation.text.input.internal.selection.TapOnPosition
                            /* JADX INFO: renamed from: onEvent-k-4lQ0M */
                            public final void mo1375onEventk4lQ0M(long it) {
                                Handle handle;
                                textFieldSelectionState.markStartContentVisibleOffset();
                                TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                                if (z) {
                                    handle = Handle.SelectionStart;
                                } else {
                                    handle = Handle.SelectionEnd;
                                }
                                textFieldSelectionState2.m1405updateHandleDraggingUv8p0NA(handle, SelectionHandlesKt.m1479getAdjustedCoordinatesk4lQ0M(textFieldSelectionState.m1395getHandlePositiontuRUvjQ(z)));
                            }
                        };
                        final TextFieldSelectionState textFieldSelectionState2 = this.this$0;
                        this.label = 1;
                        if (PressDownGestureKt.detectPressDownGesture(pointerInputScope, tapOnPosition, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.2
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
                                textFieldSelectionState2.clearHandleDragging();
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

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {378}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, boolean z, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectSelectionHandleDragGestures(this.$this_selectionHandleGestures, this.$isStartHandle, this) == coroutine_suspended) {
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

    public final Object selectionHandleGestures(PointerInputScope $this$selectionHandleGestures, boolean isStartHandle, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C08712($this$selectionHandleGestures, isStartHandle, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object observeChanges(Continuation<? super Unit> continuation) throws Throwable {
        C08641 c08641;
        Throwable th;
        TextFieldSelectionState textFieldSelectionState;
        if (continuation instanceof C08641) {
            c08641 = (C08641) continuation;
            if ((c08641.label & Integer.MIN_VALUE) != 0) {
                c08641.label -= Integer.MIN_VALUE;
            } else {
                c08641 = new C08641(continuation);
            }
        } else {
            c08641 = new C08641(continuation);
        }
        C08641 c08642 = c08641;
        Object $result = c08642.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c08642.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    C08652 c08652 = new C08652(null);
                    c08642.L$0 = this;
                    c08642.label = 1;
                    if (CoroutineScopeKt.coroutineScope(c08652, c08642) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    textFieldSelectionState = this;
                    textFieldSelectionState.setShowCursorHandle(false);
                    if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                        textFieldSelectionState.hideTextToolbar();
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    textFieldSelectionState = this;
                    textFieldSelectionState.setShowCursorHandle(false);
                    if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                        textFieldSelectionState.hideTextToolbar();
                    }
                    throw th;
                }
            case 1:
                textFieldSelectionState = (TextFieldSelectionState) c08642.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    textFieldSelectionState.setShowCursorHandle(false);
                    if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                        textFieldSelectionState.hideTextToolbar();
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    textFieldSelectionState.setShowCursorHandle(false);
                    if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                        textFieldSelectionState.hideTextToolbar();
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C08652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C08652(Continuation<? super C08652> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08652 c08652 = TextFieldSelectionState.this.new C08652(continuation);
            c08652.L$0 = obj;
            return c08652;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C08652) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$1", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {390}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
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
                        if (this.this$0.observeTextChanges(this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass1(TextFieldSelectionState.this, null), 3, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass2(TextFieldSelectionState.this, null), 3, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldSelectionState.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$2", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {391}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.observeTextToolbarVisibility(this) == coroutine_suspended) {
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

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2", m210f = "TextFieldSelectionState.kt", m211i = {0}, m212l = {HttpStatusCodesKt.HTTP_MISDIRECTED_REQUEST}, m213m = "invokeSuspend", m214n = {"$this$awaitPointerEventScope"}, m215s = {"L$0"})
    static final class C08632 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C08632(Continuation<? super C08632> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08632 c08632 = TextFieldSelectionState.this.new C08632(continuation);
            c08632.L$0 = obj;
            return c08632;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C08632) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0038 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:11:0x0039  */
        /* JADX WARN: Code duplicated, block: B:14:0x0049  */
        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:12:0x003f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:15:0x004b
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                switch(r1) {
                    case 0: goto L20;
                    case 1: goto L13;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L13:
                r1 = r8
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.throwOnFailure(r9)
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                goto L3f
            L20:
                kotlin.ResultKt.throwOnFailure(r9)
                r1 = r8
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p001ui.input.pointer.AwaitPointerEventScope) r3
            L28:
                androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.p001ui.input.pointer.PointerEventPass.Initial
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.L$0 = r3
                r1.label = r2
                java.lang.Object r4 = r3.awaitPointerEvent(r4, r5)
                if (r4 != r0) goto L39
                return r0
            L39:
                r7 = r0
                r0 = r9
                r9 = r4
                r4 = r3
                r3 = r1
                r1 = r7
            L3f:
                androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.p001ui.input.pointer.PointerEvent) r9
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r5 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                boolean r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r9)
                if (r6 != 0) goto L4b
                r9 = 1
                goto L4c
            L4b:
                r9 = 0
            L4c:
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$setInTouchMode(r5, r9)
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L28
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.C08632.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object detectTouchMode(PointerInputScope $this$detectTouchMode, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = $this$detectTouchMode.awaitPointerEventScope(new C08632(null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    public final Object detectTextFieldTapGestures(PointerInputScope $this$detectTextFieldTapGestures, MutableInteractionSource interactionSource, final Function0<Unit> function0, final Function0<Unit> function1, Continuation<? super Unit> continuation) {
        Object objDetectTapAndDoubleTap = TapAndDoubleTapGestureKt.detectTapAndDoubleTap($this$detectTextFieldTapGestures, new TapOnPosition() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.2
            @Override // androidx.compose.foundation.text.input.internal.selection.TapOnPosition
            /* JADX INFO: renamed from: onEvent-k-4lQ0M */
            public final void mo1375onEventk4lQ0M(long offset) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                if (this.getEditable() && this.getIsFocused()) {
                    function1.invoke();
                    if (this.textFieldState.getVisualText().length() > 0) {
                        this.setShowCursorHandle(true);
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    long coercedOffset = this.textLayoutState.m1350coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(offset);
                    this.m1399placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m1357fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, coercedOffset));
                }
            }
        }, new TapOnPosition() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3
            @Override // androidx.compose.foundation.text.input.internal.selection.TapOnPosition
            /* JADX INFO: renamed from: onEvent-k-4lQ0M */
            public final void mo1375onEventk4lQ0M(long offset) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDoubleTapTextField";
                    }
                });
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                int index = TextLayoutState.m1349getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, offset, false, 2, null);
                long newSelection = TextFieldSelectionState.m1403updateSelectionQNhciaU$default(TextFieldSelectionState.this, TextFieldCharSequenceKt.m1286TextFieldCharSequence3r_uNRQ$default(TextFieldSelectionState.this.textFieldState.getVisualText(), TextRange.INSTANCE.m6256getZerod9O1mEE(), null, 4, null), index, index, false, SelectionAdjustment.INSTANCE.getWord(), false, 32, null);
                TextFieldSelectionState.this.textFieldState.m1368selectCharsIn5zctL8(newSelection);
            }
        }, new C08614(interactionSource, this, null), continuation);
        return objDetectTapAndDoubleTap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapAndDoubleTap : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$4 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$4", m210f = "TextFieldSelectionState.kt", m211i = {}, m212l = {478}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C08614 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08614(MutableInteractionSource mutableInteractionSource, TextFieldSelectionState textFieldSelectionState, Continuation<? super C08614> continuation) {
            super(3, continuation);
            this.$interactionSource = mutableInteractionSource;
            this.this$0 = textFieldSelectionState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m1413invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m1413invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            C08614 c08614 = new C08614(this.$interactionSource, this.this$0, continuation);
            c08614.L$0 = pressGestureScope;
            c08614.J$0 = j;
            return c08614.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C08614 c08614;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PressGestureScope $this$detectTapAndDoubleTap = (PressGestureScope) this.L$0;
                    long offset = this.J$0;
                    MutableInteractionSource interactionSource = this.$interactionSource;
                    if (interactionSource != null) {
                        TextFieldSelectionState$detectTextFieldTapGestures$4$1$1 textFieldSelectionState$detectTextFieldTapGestures$4$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$4$1$1($this$detectTapAndDoubleTap, this.this$0, offset, interactionSource, null);
                        this.label = 1;
                        if (CoroutineScopeKt.coroutineScope(textFieldSelectionState$detectTextFieldTapGestures$4$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c08614 = this;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c08614 = this;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeCursorAtNearestOffset-k-4lQ0M, reason: not valid java name */
    public final boolean m1399placeCursorAtNearestOffsetk4lQ0M(long offset) {
        int index;
        IndexTransformationType type$iv;
        int iM6251getStartimpl;
        SelectionWedgeAffinity selectionWedgeAffinity;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (index = layoutResult.m6223getOffsetForPositionk4lQ0M(offset)) == -1) {
            return false;
        }
        SelectionWedgeAffinity selectionWedgeAffinity2 = null;
        TransformedTextFieldState $this$getIndexTransformationType$iv = this.textFieldState;
        long untransformed$iv = $this$getIndexTransformationType$iv.m1363mapFromTransformedjx7JFs(index);
        long retransformed$iv = $this$getIndexTransformationType$iv.m1366mapToTransformedGEjPoXI(untransformed$iv);
        if (TextRange.m6245getCollapsedimpl(untransformed$iv) && TextRange.m6245getCollapsedimpl(retransformed$iv)) {
            type$iv = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6245getCollapsedimpl(untransformed$iv) && !TextRange.m6245getCollapsedimpl(retransformed$iv)) {
            type$iv = IndexTransformationType.Replacement;
        } else if (TextRange.m6245getCollapsedimpl(untransformed$iv) && !TextRange.m6245getCollapsedimpl(retransformed$iv)) {
            type$iv = IndexTransformationType.Insertion;
        } else {
            type$iv = IndexTransformationType.Deletion;
        }
        IndexTransformationType type = type$iv;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                iM6251getStartimpl = TextRange.m6251getStartimpl(untransformed$iv);
                break;
            case 2:
                iM6251getStartimpl = TextRange.m6251getStartimpl(untransformed$iv);
                break;
            case 3:
                Rect wedgeStartCursorRect = layoutResult.getCursorRect(TextRange.m6251getStartimpl(retransformed$iv));
                Rect wedgeEndCursorRect = layoutResult.getCursorRect(TextRange.m6246getEndimpl(retransformed$iv));
                if (MathUtilsKt.m1315findClosestRect9KIMszo(offset, wedgeStartCursorRect, wedgeEndCursorRect) < 0) {
                    selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
                } else {
                    selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
                }
                selectionWedgeAffinity2 = selectionWedgeAffinity;
                iM6251getStartimpl = TextRange.m6251getStartimpl(untransformed$iv);
                break;
            case 4:
                Rect wedgeStartCursorRect2 = layoutResult.getCursorRect(TextRange.m6251getStartimpl(retransformed$iv));
                Rect wedgeEndCursorRect2 = layoutResult.getCursorRect(TextRange.m6246getEndimpl(retransformed$iv));
                if (MathUtilsKt.m1315findClosestRect9KIMszo(offset, wedgeStartCursorRect2, wedgeEndCursorRect2) < 0) {
                    iM6251getStartimpl = TextRange.m6251getStartimpl(untransformed$iv);
                } else {
                    iM6251getStartimpl = TextRange.m6246getEndimpl(untransformed$iv);
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int untransformedCursor = iM6251getStartimpl;
        long untransformedCursorRange = TextRangeKt.TextRange(untransformedCursor);
        if (TextRange.m6244equalsimpl0(untransformedCursorRange, this.textFieldState.getUntransformedText().getSelection()) && (selectionWedgeAffinity2 == null || Intrinsics.areEqual(selectionWedgeAffinity2, this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m1369selectUntransformedCharsIn5zctL8(untransformedCursorRange);
        if (selectionWedgeAffinity2 != null) {
            SelectionWedgeAffinity it = selectionWedgeAffinity2;
            this.textFieldState.setSelectionWedgeAffinity(it);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object detectCursorHandleDragGestures(PointerInputScope $this$detectCursorHandleDragGestures, Continuation<? super Unit> continuation) throws Throwable {
        C08441 c08441;
        Ref.LongRef cursorDragStart;
        TextFieldSelectionState textFieldSelectionState;
        Ref.LongRef cursorDragStart2;
        if (continuation instanceof C08441) {
            c08441 = (C08441) continuation;
            if ((c08441.label & Integer.MIN_VALUE) != 0) {
                c08441.label -= Integer.MIN_VALUE;
            } else {
                c08441 = new C08441(continuation);
            }
        } else {
            c08441 = new C08441(continuation);
        }
        C08441 c08442 = c08441;
        Object $result = c08442.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c08442.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Ref.LongRef cursorDragStart3 = new Ref.LongRef();
                cursorDragStart3.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                final Ref.LongRef cursorDragDelta = new Ref.LongRef();
                cursorDragDelta.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                try {
                    Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m1407invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m1407invokek4lQ0M(long it) {
                            cursorDragStart3.element = SelectionHandlesKt.m1479getAdjustedCoordinatesk4lQ0M(this.getCursorRect().m4076getBottomCenterF1C5BW0());
                            cursorDragDelta.element = Offset.INSTANCE.m4065getZeroF1C5BW0();
                            this.setInTouchMode(true);
                            this.markStartContentVisibleOffset();
                            this.m1405updateHandleDraggingUv8p0NA(Handle.Cursor, cursorDragStart3.element);
                        }
                    };
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.3
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
                            TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(cursorDragStart3, cursorDragDelta, this);
                        }
                    };
                    Function0<Unit> function2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.4
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
                            TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(cursorDragStart3, cursorDragDelta, this);
                        }
                    };
                    Function2<PointerInputChange, Offset, Unit> function3 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                            m1408invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m1408invokeUv8p0NA(PointerInputChange change, long dragAmount) {
                            cursorDragDelta.element = Offset.m4054plusMKHz9U(cursorDragDelta.element, dragAmount);
                            this.m1405updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.m4054plusMKHz9U(cursorDragStart3.element, cursorDragDelta.element));
                            if (this.m1399placeCursorAtNearestOffsetk4lQ0M(this.m1404getHandleDragPositionF1C5BW0())) {
                                change.consume();
                                HapticFeedback hapticFeedback = this.hapticFeedBack;
                                if (hapticFeedback != null) {
                                    hapticFeedback.mo5032performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5041getTextHandleMove5zf0vsI());
                                }
                            }
                        }
                    };
                    c08442.L$0 = this;
                    c08442.L$1 = cursorDragStart3;
                    c08442.L$2 = cursorDragDelta;
                    c08442.label = 1;
                    if (DragGestureDetectorKt.detectDragGestures($this$detectCursorHandleDragGestures, function1, function0, function2, function3, c08442) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cursorDragStart = cursorDragStart3;
                    textFieldSelectionState = this;
                    cursorDragStart2 = cursorDragDelta;
                    detectCursorHandleDragGestures$onDragStop(cursorDragStart, cursorDragStart2, textFieldSelectionState);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    cursorDragStart = cursorDragStart3;
                    textFieldSelectionState = this;
                    cursorDragStart2 = cursorDragDelta;
                    detectCursorHandleDragGestures$onDragStop(cursorDragStart, cursorDragStart2, textFieldSelectionState);
                    throw th;
                }
            case 1:
                cursorDragStart2 = (Ref.LongRef) c08442.L$2;
                cursorDragStart = (Ref.LongRef) c08442.L$1;
                textFieldSelectionState = (TextFieldSelectionState) c08442.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    detectCursorHandleDragGestures$onDragStop(cursorDragStart, cursorDragStart2, textFieldSelectionState);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    detectCursorHandleDragGestures$onDragStop(cursorDragStart, cursorDragStart2, textFieldSelectionState);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef cursorDragStart, Ref.LongRef cursorDragDelta, TextFieldSelectionState this$0) {
        if (OffsetKt.m4068isSpecifiedk4lQ0M(cursorDragStart.element)) {
            cursorDragStart.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
            cursorDragDelta.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
            this$0.clearHandleDragging();
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [T, androidx.compose.foundation.text.Handle] */
    public final Object detectTextFieldLongPressAndAfterDrag(PointerInputScope $this$detectTextFieldLongPressAndAfterDrag, final Function0<Unit> function0, Continuation<? super Unit> continuation) {
        final Ref.IntRef dragBeginOffsetInText = new Ref.IntRef();
        dragBeginOffsetInText.element = -1;
        final Ref.LongRef dragBeginPosition = new Ref.LongRef();
        dragBeginPosition.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        final Ref.LongRef dragTotalDistance = new Ref.LongRef();
        dragTotalDistance.element = Offset.INSTANCE.m4065getZeroF1C5BW0();
        final Ref.ObjectRef actingHandle = new Ref.ObjectRef();
        actingHandle.element = Handle.SelectionEnd;
        Object objDetectDragGesturesAfterLongPress = DragGestureDetectorKt.detectDragGesturesAfterLongPress($this$detectTextFieldLongPressAndAfterDrag, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m1411invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m1411invokek4lQ0M(final long dragStartOffset) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDragStart after longPress " + ((Object) Offset.m4057toStringimpl(dragStartOffset));
                    }
                });
                function0.invoke();
                this.m1405updateHandleDraggingUv8p0NA(actingHandle.element, dragStartOffset);
                dragBeginPosition.element = dragStartOffset;
                dragTotalDistance.element = Offset.INSTANCE.m4065getZeroF1C5BW0();
                this.previousRawDragOffset = -1;
                if (!this.textLayoutState.m1353isPositionOnTextk4lQ0M(dragStartOffset)) {
                    int offset = TextLayoutState.m1349getOffsetForPosition3MmeM6k$default(this.textLayoutState, dragStartOffset, false, 2, null);
                    HapticFeedback hapticFeedback = this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo5032performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5041getTextHandleMove5zf0vsI());
                    }
                    this.textFieldState.placeCursorBeforeCharAt(offset);
                    this.setShowCursorHandle(true);
                    this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                if (this.textFieldState.getVisualText().length() == 0) {
                    return;
                }
                int offset2 = TextLayoutState.m1349getOffsetForPosition3MmeM6k$default(this.textLayoutState, dragStartOffset, false, 2, null);
                long newSelection = TextFieldSelectionState.m1403updateSelectionQNhciaU$default(this, TextFieldCharSequenceKt.m1286TextFieldCharSequence3r_uNRQ$default(this.textFieldState.getVisualText(), TextRange.INSTANCE.m6256getZerod9O1mEE(), null, 4, null), offset2, offset2, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, 32, null);
                this.textFieldState.m1368selectCharsIn5zctL8(newSelection);
                this.updateTextToolbarState(TextToolbarState.Selection);
                dragBeginOffsetInText.element = TextRange.m6251getStartimpl(newSelection);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.3
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
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$3(dragBeginPosition, this, dragBeginOffsetInText, dragTotalDistance);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.4
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
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$3(dragBeginPosition, this, dragBeginOffsetInText, dragTotalDistance);
            }
        }, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                m1412invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
            public final void m1412invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                int iIntValue;
                int iM1352getOffsetForPosition3MmeM6k;
                SelectionAdjustment word;
                T t;
                if (TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                    return;
                }
                dragTotalDistance.element = Offset.m4054plusMKHz9U(dragTotalDistance.element, j);
                final long jM4054plusMKHz9U = Offset.m4054plusMKHz9U(dragBeginPosition.element, dragTotalDistance.element);
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDrag after longPress " + ((Object) Offset.m4057toStringimpl(jM4054plusMKHz9U));
                    }
                });
                if (dragBeginOffsetInText.element < 0 && !TextFieldSelectionState.this.textLayoutState.m1353isPositionOnTextk4lQ0M(jM4054plusMKHz9U)) {
                    iIntValue = TextLayoutState.m1349getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, dragBeginPosition.element, false, 2, null);
                    iM1352getOffsetForPosition3MmeM6k = TextLayoutState.m1349getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, jM4054plusMKHz9U, false, 2, null);
                    if (iIntValue == iM1352getOffsetForPosition3MmeM6k) {
                        word = SelectionAdjustment.INSTANCE.getNone();
                    } else {
                        word = SelectionAdjustment.INSTANCE.getWord();
                    }
                } else {
                    Integer numValueOf = Integer.valueOf(dragBeginOffsetInText.element);
                    if (!(numValueOf.intValue() >= 0)) {
                        numValueOf = null;
                    }
                    iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1352getOffsetForPosition3MmeM6k(dragBeginPosition.element, false);
                    iM1352getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1352getOffsetForPosition3MmeM6k(jM4054plusMKHz9U, false);
                    if (dragBeginOffsetInText.element < 0 && iIntValue == iM1352getOffsetForPosition3MmeM6k) {
                        return;
                    } else {
                        word = SelectionAdjustment.INSTANCE.getWord();
                    }
                }
                long selection = TextFieldSelectionState.this.textFieldState.getVisualText().getSelection();
                long jM1402updateSelectionQNhciaU = TextFieldSelectionState.this.m1402updateSelectionQNhciaU(TextFieldSelectionState.this.textFieldState.getVisualText(), iIntValue, iM1352getOffsetForPosition3MmeM6k, false, word, false);
                if (TextRange.m6250getReversedimpl(jM1402updateSelectionQNhciaU)) {
                    jM1402updateSelectionQNhciaU = TextFieldSelectionStateKt.m1415reverse5zctL8(jM1402updateSelectionQNhciaU);
                }
                if (dragBeginOffsetInText.element == -1 && !TextRange.m6245getCollapsedimpl(jM1402updateSelectionQNhciaU)) {
                    dragBeginOffsetInText.element = TextRange.m6251getStartimpl(jM1402updateSelectionQNhciaU);
                }
                if (!TextRange.m6244equalsimpl0(jM1402updateSelectionQNhciaU, selection)) {
                    Ref.ObjectRef<Handle> objectRef = actingHandle;
                    if (TextRange.m6251getStartimpl(jM1402updateSelectionQNhciaU) != TextRange.m6251getStartimpl(selection) && TextRange.m6246getEndimpl(jM1402updateSelectionQNhciaU) == TextRange.m6246getEndimpl(selection)) {
                        t = Handle.SelectionStart;
                    } else if ((TextRange.m6251getStartimpl(jM1402updateSelectionQNhciaU) == TextRange.m6251getStartimpl(selection) && TextRange.m6246getEndimpl(jM1402updateSelectionQNhciaU) != TextRange.m6246getEndimpl(selection)) || (TextRange.m6251getStartimpl(jM1402updateSelectionQNhciaU) + TextRange.m6246getEndimpl(jM1402updateSelectionQNhciaU)) / 2.0f > (TextRange.m6251getStartimpl(selection) + TextRange.m6246getEndimpl(selection)) / 2.0f) {
                        t = Handle.SelectionEnd;
                    } else {
                        t = Handle.SelectionStart;
                    }
                    objectRef.element = t;
                }
                if (TextRange.m6245getCollapsedimpl(selection) || !TextRange.m6245getCollapsedimpl(jM1402updateSelectionQNhciaU)) {
                    TextFieldSelectionState.this.textFieldState.m1368selectCharsIn5zctL8(jM1402updateSelectionQNhciaU);
                }
                TextFieldSelectionState.this.m1405updateHandleDraggingUv8p0NA(actingHandle.element, jM4054plusMKHz9U);
            }
        }, continuation);
        return objDetectDragGesturesAfterLongPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGesturesAfterLongPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectTextFieldLongPressAndAfterDrag$onDragStop$3(Ref.LongRef dragBeginPosition, TextFieldSelectionState this$0, Ref.IntRef dragBeginOffsetInText, Ref.LongRef dragTotalDistance) {
        if (OffsetKt.m4068isSpecifiedk4lQ0M(dragBeginPosition.element)) {
            this$0.clearHandleDragging();
            dragBeginOffsetInText.element = -1;
            dragBeginPosition.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
            dragTotalDistance.element = Offset.INSTANCE.m4065getZeroF1C5BW0();
            this$0.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:47:0x0111  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object detectSelectionHandleDragGestures(PointerInputScope pointerInputScope, boolean isStartHandle, Continuation<? super Unit> continuation) throws Throwable {
        C08491 c08491;
        final Handle handle;
        TextFieldSelectionState textFieldSelectionState;
        Ref.LongRef dragTotalDistance;
        Ref.LongRef dragBeginPosition;
        if (continuation instanceof C08491) {
            c08491 = (C08491) continuation;
            if ((c08491.label & Integer.MIN_VALUE) != 0) {
                c08491.label -= Integer.MIN_VALUE;
            } else {
                c08491 = new C08491(continuation);
            }
        } else {
            c08491 = new C08491(continuation);
        }
        Object $result = c08491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c08491.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Ref.LongRef dragBeginPosition2 = new Ref.LongRef();
                dragBeginPosition2.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                final Ref.LongRef dragTotalDistance2 = new Ref.LongRef();
                dragTotalDistance2.element = Offset.INSTANCE.m4065getZeroF1C5BW0();
                Handle handle2 = isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd;
                try {
                    final boolean z = isStartHandle;
                    final Handle handle3 = handle2;
                    Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m1409invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m1409invokek4lQ0M(long it) {
                            dragBeginPosition2.element = SelectionHandlesKt.m1479getAdjustedCoordinatesk4lQ0M(this.m1395getHandlePositiontuRUvjQ(z));
                            this.m1405updateHandleDraggingUv8p0NA(handle3, dragBeginPosition2.element);
                            dragTotalDistance2.element = Offset.INSTANCE.m4065getZeroF1C5BW0();
                            this.previousRawDragOffset = -1;
                        }
                    };
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.3
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
                            TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$4(dragBeginPosition2, this, dragTotalDistance2);
                        }
                    };
                    Function0<Unit> function2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.4
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
                            TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$4(dragBeginPosition2, this, dragTotalDistance2);
                        }
                    };
                    final boolean z2 = isStartHandle;
                    final Handle handle4 = handle2;
                    Function2<PointerInputChange, Offset, Unit> function3 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                            m1410invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m1410invokeUv8p0NA(PointerInputChange pointerInputChange, long delta) {
                            int startOffset;
                            int endOffset;
                            dragTotalDistance2.element = Offset.m4054plusMKHz9U(dragTotalDistance2.element, delta);
                            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            this.m1405updateHandleDraggingUv8p0NA(handle4, Offset.m4054plusMKHz9U(dragBeginPosition2.element, dragTotalDistance2.element));
                            if (!z2) {
                                startOffset = TextRange.m6251getStartimpl(this.textFieldState.getVisualText().getSelection());
                            } else {
                                startOffset = layoutResult.m6223getOffsetForPositionk4lQ0M(this.m1404getHandleDragPositionF1C5BW0());
                            }
                            if (z2) {
                                endOffset = TextRange.m6246getEndimpl(this.textFieldState.getVisualText().getSelection());
                            } else {
                                endOffset = layoutResult.m6223getOffsetForPositionk4lQ0M(this.m1404getHandleDragPositionF1C5BW0());
                            }
                            long prevSelection = this.textFieldState.getVisualText().getSelection();
                            long newSelection = TextFieldSelectionState.m1403updateSelectionQNhciaU$default(this, this.textFieldState.getVisualText(), startOffset, endOffset, z2, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, 32, null);
                            if (TextRange.m6245getCollapsedimpl(prevSelection) || !TextRange.m6245getCollapsedimpl(newSelection)) {
                                this.textFieldState.m1368selectCharsIn5zctL8(newSelection);
                            }
                        }
                    };
                    c08491.L$0 = this;
                    c08491.L$1 = dragBeginPosition2;
                    c08491.L$2 = dragTotalDistance2;
                    c08491.L$3 = handle2;
                    c08491.label = 1;
                    Handle handle5 = handle2;
                    try {
                        if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function2, function3, c08491) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        handle = handle5;
                        textFieldSelectionState = this;
                        dragTotalDistance = dragTotalDistance2;
                        dragBeginPosition = dragBeginPosition2;
                        TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                            }
                        });
                        if (textFieldSelectionState.getDraggingHandle() == handle) {
                            detectSelectionHandleDragGestures$onDragStop$4(dragBeginPosition, textFieldSelectionState, dragTotalDistance);
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        handle = handle5;
                        textFieldSelectionState = this;
                        dragTotalDistance = dragTotalDistance2;
                        dragBeginPosition = dragBeginPosition2;
                        TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                            }
                        });
                        if (textFieldSelectionState.getDraggingHandle() == handle) {
                            detectSelectionHandleDragGestures$onDragStop$4(dragBeginPosition, textFieldSelectionState, dragTotalDistance);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    handle = handle2;
                    textFieldSelectionState = this;
                    dragTotalDistance = dragTotalDistance2;
                    dragBeginPosition = dragBeginPosition2;
                }
                break;
            case 1:
                handle = (Handle) c08491.L$3;
                dragTotalDistance = (Ref.LongRef) c08491.L$2;
                dragBeginPosition = (Ref.LongRef) c08491.L$1;
                textFieldSelectionState = (TextFieldSelectionState) c08491.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                        }
                    });
                    if (textFieldSelectionState.getDraggingHandle() == handle) {
                        detectSelectionHandleDragGestures$onDragStop$4(dragBeginPosition, textFieldSelectionState, dragTotalDistance);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                        }
                    });
                    if (textFieldSelectionState.getDraggingHandle() == handle) {
                        detectSelectionHandleDragGestures$onDragStop$4(dragBeginPosition, textFieldSelectionState, dragTotalDistance);
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$4(Ref.LongRef dragBeginPosition, TextFieldSelectionState this$0, Ref.LongRef dragTotalDistance) {
        if (OffsetKt.m4068isSpecifiedk4lQ0M(dragBeginPosition.element)) {
            this$0.clearHandleDragging();
            dragBeginPosition.element = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
            dragTotalDistance.element = Offset.INSTANCE.m4065getZeroF1C5BW0();
            this$0.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$3 */
    /* JADX INFO: compiled from: TextFieldSelectionState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C08673 extends FunctionReferenceImpl implements Function2<TextFieldCharSequence, CharSequence, Boolean> {
        public static final C08673 INSTANCE = new C08673();

        C08673() {
            super(2, TextFieldCharSequence.class, "contentEquals", "contentEquals(Ljava/lang/CharSequence;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(TextFieldCharSequence p0, CharSequence p1) {
            return Boolean.valueOf(p0.contentEquals(p1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextChanges.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldCharSequence invoke() {
                return TextFieldSelectionState.this.textFieldState.getVisualText();
            }
        }), C08673.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextChanges.4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((TextFieldCharSequence) value, (Continuation<? super Unit>) $completion);
            }

            public final Object emit(TextFieldCharSequence it, Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new Function0<Rect>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                Rect visibleBounds;
                boolean isCollapsed = TextRange.m6245getCollapsedimpl(TextFieldSelectionState.this.textFieldState.getVisualText().getSelection());
                boolean textToolbarStateVisible = (isCollapsed && TextFieldSelectionState.this.getTextToolbarState() == TextToolbarState.Cursor) || (!isCollapsed && TextFieldSelectionState.this.getTextToolbarState() == TextToolbarState.Selection);
                boolean textToolbarVisible = textToolbarStateVisible && TextFieldSelectionState.this.getDraggingHandle() == null && TextFieldSelectionState.this.isInTouchMode();
                if (textToolbarVisible) {
                    LayoutCoordinates textLayoutCoordinates = TextFieldSelectionState.this.getTextLayoutCoordinates();
                    Rect visibleBounds2 = textLayoutCoordinates != null ? SelectionManagerKt.visibleBounds(textLayoutCoordinates) : null;
                    if (visibleBounds2 != null) {
                        LayoutCoordinates textLayoutCoordinates2 = TextFieldSelectionState.this.getTextLayoutCoordinates();
                        Offset visibleBoundsTopLeftInRoot = textLayoutCoordinates2 != null ? Offset.m4038boximpl(textLayoutCoordinates2.mo5648localToRootMKHz9U(visibleBounds2.m4084getTopLeftF1C5BW0())) : null;
                        Intrinsics.checkNotNull(visibleBoundsTopLeftInRoot);
                        Rect visibleBoundsInRoot = RectKt.m4089Recttz77jQw(visibleBoundsTopLeftInRoot.getPackedValue(), visibleBounds2.m4082getSizeNHjbRc());
                        Rect it = TextFieldSelectionState.this.getContentRect();
                        Rect rect = visibleBoundsInRoot.overlaps(it) ? it : null;
                        if (rect == null || (visibleBounds = rect.intersect(visibleBoundsInRoot)) == null) {
                            return Rect.INSTANCE.getZero();
                        }
                        return visibleBounds;
                    }
                    return Rect.INSTANCE.getZero();
                }
                return Rect.INSTANCE.getZero();
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((Rect) value, (Continuation<? super Unit>) $completion);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                if (Intrinsics.areEqual(rect, Rect.INSTANCE.getZero())) {
                    TextFieldSelectionState.this.hideTextToolbar();
                } else {
                    TextFieldSelectionState.this.showTextToolbar(rect);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float startTop;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence text = this.textFieldState.getVisualText();
        if (TextRange.m6245getCollapsedimpl(text.getSelection())) {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            long topLeft = textLayoutCoordinates != null ? textLayoutCoordinates.mo5648localToRootMKHz9U(getCursorRect().m4084getTopLeftF1C5BW0()) : Offset.INSTANCE.m4065getZeroF1C5BW0();
            return RectKt.m4089Recttz77jQw(topLeft, getCursorRect().m4082getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long startOffset = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo5648localToRootMKHz9U(m1395getHandlePositiontuRUvjQ(true)) : Offset.INSTANCE.m4065getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long endOffset = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo5648localToRootMKHz9U(m1395getHandlePositiontuRUvjQ(false)) : Offset.INSTANCE.m4065getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float endTop = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            startTop = Offset.m4050getYimpl(textLayoutCoordinates4.mo5648localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m6251getStartimpl(text.getSelection()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            startTop = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            endTop = Offset.m4050getYimpl(textLayoutCoordinates5.mo5648localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m6246getEndimpl(text.getSelection()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m4049getXimpl(startOffset), Offset.m4049getXimpl(endOffset)), Math.min(startTop, endTop), Math.max(Offset.m4049getXimpl(startOffset), Offset.m4049getXimpl(endOffset)), Math.max(Offset.m4050getYimpl(startOffset), Offset.m4050getYimpl(endOffset)));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    public final TextFieldHandleState getSelectionHandleState$foundation_release(boolean isStartHandle, boolean includePosition) {
        boolean visible;
        long coercedPosition;
        Rect it;
        boolean zM1516containsInclusiveUv8p0NA;
        Rect rectVisibleBounds;
        Handle handle = isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        if (TextRange.m6245getCollapsedimpl(selection)) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long position = m1395getHandlePositiontuRUvjQ(isStartHandle);
        if (getDraggingHandle() == handle) {
            visible = true;
        } else {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates != null && (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) != null) {
                zM1516containsInclusiveUv8p0NA = SelectionManagerKt.m1516containsInclusiveUv8p0NA(rectVisibleBounds, position);
            } else {
                zM1516containsInclusiveUv8p0NA = false;
            }
            if (zM1516containsInclusiveUv8p0NA) {
                visible = true;
            } else {
                visible = false;
            }
        }
        if (!visible) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        int directionOffset = isStartHandle ? TextRange.m6251getStartimpl(selection) : Math.max(TextRange.m6246getEndimpl(selection) - 1, 0);
        ResolvedTextDirection direction = layoutResult.getBidiRunDirection(directionOffset);
        boolean handlesCrossed = TextRange.m6250getReversedimpl(selection);
        if (includePosition) {
            LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
            if (textLayoutCoordinates2 != null && (it = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) != null) {
                coercedPosition = TextLayoutStateKt.m1356coerceIn3MmeM6k(position, it);
            } else {
                coercedPosition = position;
            }
        } else {
            coercedPosition = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        }
        return new TextFieldHandleState(true, coercedPosition, direction, handlesCrossed, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m1395getHandlePositiontuRUvjQ(boolean isStartHandle) {
        int offset;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        if (isStartHandle) {
            offset = TextRange.m6251getStartimpl(selection);
        } else {
            offset = TextRange.m6246getEndimpl(selection);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, offset, isStartHandle, TextRange.m6250getReversedimpl(selection));
    }

    /* JADX INFO: renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m1405updateHandleDraggingUv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        m1400setRawHandleDragPositionk4lQ0M(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        Rect rectVisibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        m1401setStartContentVisibleOffsetk4lQ0M((textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m4064getUnspecifiedF1C5BW0() : rectVisibleBounds.m4084getTopLeftF1C5BW0());
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m1400setRawHandleDragPositionk4lQ0M(Offset.INSTANCE.m4064getUnspecifiedF1C5BW0());
        m1401setStartContentVisibleOffsetk4lQ0M(Offset.INSTANCE.m4064getUnspecifiedF1C5BW0());
    }

    public final void cut() {
        TextFieldCharSequence text = this.textFieldState.getVisualText();
        if (TextRange.m6245getCollapsedimpl(text.getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        this.textFieldState.deleteSelectedText();
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionState.copy(z);
    }

    public final void copy(boolean cancelSelection) {
        TextFieldCharSequence text = this.textFieldState.getVisualText();
        if (TextRange.m6245getCollapsedimpl(text.getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        if (cancelSelection) {
            this.textFieldState.collapseSelectionToMax();
        }
    }

    public final void paste() {
        ReceiveContentConfiguration receiveContentConfiguration;
        ClipEntry clipEntry;
        ClipEntry clipEntry2;
        String clipboardText;
        Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
        if (function0 == null || (receiveContentConfiguration = function0.invoke()) == null) {
            pasteAsPlainText();
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (clipEntry = clipboardManager.getClip()) == null) {
            pasteAsPlainText();
            return;
        }
        ClipMetadata clipMetadata = clipEntry.getClipMetadata();
        TransferableContent remaining = receiveContentConfiguration.getReceiveContentListener().onReceive(new TransferableContent(clipEntry, clipMetadata, TransferableContent.Source.INSTANCE.m554getClipboardkB6V9T0(), null, 8, null));
        if (remaining != null && (clipEntry2 = remaining.getClipEntry()) != null && (clipboardText = TransferableContent_androidKt.readPlainText(clipEntry2)) != null) {
            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, clipboardText, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
        }
    }

    private final void pasteAsPlainText() {
        AnnotatedString text;
        String clipboardText;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null || (clipboardText = text.getText()) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, clipboardText, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    public final void showTextToolbar(Rect contentRect) {
        boolean canPasteContent;
        long selection = this.textFieldState.getVisualText().getSelection();
        Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
        boolean canPaste = true;
        if ((function0 != null ? function0.invoke() : null) == null) {
            canPasteContent = false;
        } else {
            ClipboardManager clipboardManager = this.clipboardManager;
            if ((clipboardManager != null ? clipboardManager.getClip() : null) != null) {
                canPasteContent = true;
            } else {
                canPasteContent = false;
            }
        }
        ClipboardManager clipboardManager2 = this.clipboardManager;
        boolean canPasteText = clipboardManager2 != null && clipboardManager2.hasText();
        if (!getEditable() || (!canPasteContent && !canPasteText)) {
            canPaste = false;
        }
        Function0<Unit> function1 = canPaste ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$paste$1
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
                this.this$0.paste();
                this.this$0.updateTextToolbarState(TextToolbarState.None);
            }
        } : null;
        Function0<Unit> function2 = !TextRange.m6245getCollapsedimpl(selection) ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$copy$1
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
                TextFieldSelectionState.copy$default(this.this$0, false, 1, null);
                this.this$0.updateTextToolbarState(TextToolbarState.None);
            }
        } : null;
        Function0<Unit> function3 = (TextRange.m6245getCollapsedimpl(selection) || !getEditable()) ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$cut$1
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
                this.this$0.cut();
                this.this$0.updateTextToolbarState(TextToolbarState.None);
            }
        };
        Function0<Unit> function4 = TextRange.m6247getLengthimpl(selection) != this.textFieldState.getVisualText().length() ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$selectAll$1
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
                this.this$0.textFieldState.selectAll();
                this.this$0.updateTextToolbarState(TextToolbarState.Selection);
            }
        } : null;
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar != null) {
            textToolbar.showMenu(contentRect, function2, function1, function3, function4);
        }
    }

    public final void deselect() {
        if (!TextRange.m6245getCollapsedimpl(this.textFieldState.getVisualText().getSelection())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* JADX INFO: renamed from: updateSelection-QNhciaU$default, reason: not valid java name */
    static /* synthetic */ long m1403updateSelectionQNhciaU$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, int i3, Object obj) {
        return textFieldSelectionState.m1402updateSelectionQNhciaU(textFieldCharSequence, i, i2, z, selectionAdjustment, (i3 & 32) != 0 ? false : z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateSelection-QNhciaU, reason: not valid java name */
    public final long m1402updateSelectionQNhciaU(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed) {
        TextRange textRangeM6239boximpl = TextRange.m6239boximpl(textFieldCharSequence.getSelection());
        long it = textRangeM6239boximpl.getPackedValue();
        boolean z = false;
        if (!(allowPreviousSelectionCollapsed || !TextRange.m6245getCollapsedimpl(it))) {
            textRangeM6239boximpl = null;
        }
        long newSelection = m1398getTextFieldSelectionqeG_v_k(startOffset, endOffset, textRangeM6239boximpl, isStartHandle, adjustment);
        if (TextRange.m6244equalsimpl0(newSelection, textFieldCharSequence.getSelection())) {
            return newSelection;
        }
        if (TextRange.m6250getReversedimpl(newSelection) != TextRange.m6250getReversedimpl(textFieldCharSequence.getSelection())) {
            long $this$updateSelection_QNhciaU_u24lambda_u248 = TextRangeKt.TextRange(TextRange.m6246getEndimpl(newSelection), TextRange.m6251getStartimpl(newSelection));
            if (TextRange.m6244equalsimpl0($this$updateSelection_QNhciaU_u24lambda_u248, textFieldCharSequence.getSelection())) {
                z = true;
            }
        }
        boolean onlyChangeIsReversed = z;
        if (isInTouchMode() && !onlyChangeIsReversed) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo5032performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5041getTextHandleMove5zf0vsI());
            }
        }
        return newSelection;
    }

    /* JADX INFO: renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m1398getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m6256getZerod9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout selectionLayout = SelectionLayoutKt.m1482getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m6256getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !selectionLayout.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long result = adjustment.adjust(selectionLayout).m1470toTextRanged9O1mEE();
        this.previousSelectionLayout = selectionLayout;
        this.previousRawDragOffset = isStartHandle ? rawStartOffset : rawEndOffset;
        return result;
    }
}
