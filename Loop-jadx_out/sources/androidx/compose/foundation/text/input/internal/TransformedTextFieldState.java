package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextRangeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: TransformedTextFieldState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u0000 W2\u00020\u0001:\u0002WXB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0086@¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020!J,\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020+2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020!0-¢\u0006\u0002\b/H\u0086\bJ\u0013\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u000205ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00104\u001a\u0002052\u0006\u00109\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u0018\u0010<\u001a\u0002052\u0006\u00106\u001a\u000205ø\u0001\u0000¢\u0006\u0004\b=\u00108J\u001b\u0010<\u001a\u0002052\u0006\u00109\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010;J\u000e\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u000203J\u0006\u0010A\u001a\u00020!J\u000e\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DJ\"\u0010E\u001a\u00020!2\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020+2\b\b\u0002\u0010G\u001a\u00020HJ*\u0010I\u001a\u00020!2\u0006\u0010C\u001a\u00020D2\u0006\u00106\u001a\u0002052\b\b\u0002\u0010G\u001a\u00020Hø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u0006\u0010L\u001a\u00020!J\u0018\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u000205ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u0018\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u000205ø\u0001\u0000¢\u0006\u0004\bS\u0010PJ\b\u0010T\u001a\u00020UH\u0016J\u0006\u0010V\u001a\u00020!R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "codepointTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "outputText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOutputText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformedText", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "untransformedText", "getUntransformedText", "visualText", "getVisualText", "collapseSelectionToEnd", "", "collapseSelectionToMax", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSelectedText", "editUntransformedTextAsUser", "restartImeIfContentChanges", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "equals", "other", "hashCode", "", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "offset", "mapFromTransformed--jx7JFs", "(I)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "mapToTransformed--jx7JFs", "placeCursorBeforeCharAt", "transformedOffset", "redo", "replaceAll", "newText", "", "replaceSelectedText", "clearComposition", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "replaceText", "replaceText-Sb-Bc2M", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;)V", "selectAll", "selectCharsIn", "transformedRange", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "toString", "", "undo", "Companion", "TransformedText", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private final CodepointTransformation codepointTransformation;
    private final State<TransformedText> codepointTransformedText;
    private final InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    private final State<TransformedText> outputTransformedText;

    /* JADX INFO: renamed from: selectionWedgeAffinity$delegate, reason: from kotlin metadata */
    private final MutableState selectionWedgeAffinity;
    private final TextFieldState textFieldState;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 */
    /* JADX INFO: compiled from: TransformedTextFieldState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.text.input.internal.TransformedTextFieldState", m210f = "TransformedTextFieldState.kt", m211i = {0, 0}, m212l = {654}, m213m = "collectImeNotifications", m214n = {"this", "notifyImeListener"}, m215s = {"L$0", "L$1"})
    static final class C08361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08361(Continuation<? super C08361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformedTextFieldState.this.collectImeNotifications(null, this);
        }
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, outputTransformation, selectionWedgeAffinity);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, codepointTransformation, selectionWedgeAffinity);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
    private static final long m1360mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m1372mapFromTransformedxdX6G0(j, offsetMappingCalculator);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
    private static final long m1361mapToTransformedXGyztTk(long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.m1373mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
    }

    public TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation) {
        this.textFieldState = textFieldState;
        this.inputTransformation = inputTransformation;
        this.codepointTransformation = codepointTransformation;
        this.outputTransformation = outputTransformation;
        final OutputTransformation transformation = this.outputTransformation;
        this.outputTransformedText = transformation != null ? SnapshotStateKt.derivedStateOf(new Function0<TransformedText>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$outputTransformedText$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TransformedTextFieldState.TransformedText invoke() {
                return TransformedTextFieldState.Companion.calculateTransformedText(this.this$0.textFieldState.getValue$foundation_release(), transformation, this.this$0.getSelectionWedgeAffinity());
            }
        }) : null;
        final CodepointTransformation transformation2 = this.codepointTransformation;
        this.codepointTransformedText = transformation2 != null ? SnapshotStateKt.derivedStateOf(new Function0<TransformedText>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$codepointTransformedText$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TransformedTextFieldState.TransformedText invoke() {
                TextFieldCharSequence value$foundation_release;
                TransformedTextFieldState.TransformedText transformedText;
                TransformedTextFieldState.Companion companion = TransformedTextFieldState.Companion;
                State state = this.this$0.outputTransformedText;
                if (state == null || (transformedText = (TransformedTextFieldState.TransformedText) state.getValue()) == null || (value$foundation_release = transformedText.getText()) == null) {
                    value$foundation_release = this.this$0.textFieldState.getValue$foundation_release();
                }
                return companion.calculateTransformedText(value$foundation_release, transformation2, this.this$0.getSelectionWedgeAffinity());
            }
        }) : null;
        this.selectionWedgeAffinity = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), null, 2, null);
    }

    public /* synthetic */ TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, (i & 2) != 0 ? null : inputTransformation, (i & 4) != 0 ? null : codepointTransformation, (i & 8) != 0 ? null : outputTransformation);
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation_release();
    }

    public final TextFieldCharSequence getOutputText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.outputTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getUntransformedText() : text;
    }

    public final TextFieldCharSequence getVisualText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.codepointTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getOutputText() : text;
    }

    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        State $this$getValue$iv = this.selectionWedgeAffinity;
        return (SelectionWedgeAffinity) $this$getValue$iv.getValue();
    }

    public final void setSelectionWedgeAffinity(SelectionWedgeAffinity selectionWedgeAffinity) {
        MutableState $this$setValue$iv = this.selectionWedgeAffinity;
        $this$setValue$iv.setValue(selectionWedgeAffinity);
    }

    public final void placeCursorBeforeCharAt(int transformedOffset) {
        m1368selectCharsIn5zctL8(TextRangeKt.TextRange(transformedOffset));
    }

    /* JADX INFO: renamed from: selectCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1368selectCharsIn5zctL8(long transformedRange) {
        long untransformedRange = m1364mapFromTransformedGEjPoXI(transformedRange);
        m1369selectUntransformedCharsIn5zctL8(untransformedRange);
    }

    /* JADX INFO: renamed from: selectUntransformedCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1369selectUntransformedCharsIn5zctL8(long untransformedRange) {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$selectUntransformedCharsIn_5zc_tL8_u24lambda_u242 = $this$iv.getMainBuffer();
        $this$selectUntransformedCharsIn_5zc_tL8_u24lambda_u242.setSelection(TextRange.m6251getStartimpl(untransformedRange), TextRange.m6246getEndimpl(untransformedRange));
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior$iv);
        }
    }

    public final void replaceAll(CharSequence newText) {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$replaceAll_u24lambda_u243 = $this$iv.getMainBuffer();
        EditCommandKt.deleteAll($this$replaceAll_u24lambda_u243);
        EditCommandKt.commitText($this$replaceAll_u24lambda_u243, newText.toString(), 1);
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior$iv);
        }
    }

    public final void selectAll() {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$selectAll_u24lambda_u244 = $this$iv.getMainBuffer();
        $this$selectAll_u24lambda_u244.setSelection(0, $this$selectAll_u24lambda_u244.getLength());
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior$iv);
        }
    }

    public final void deleteSelectedText() {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.NeverMerge;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$deleteSelectedText_u24lambda_u245 = $this$iv.getMainBuffer();
        $this$deleteSelectedText_u24lambda_u245.delete(TextRange.m6249getMinimpl($this$deleteSelectedText_u24lambda_u245.m1308getSelectiond9O1mEE()), TextRange.m6248getMaximpl($this$deleteSelectedText_u24lambda_u245.m1308getSelectiond9O1mEE()));
        $this$deleteSelectedText_u24lambda_u245.setSelection(TextRange.m6249getMinimpl($this$deleteSelectedText_u24lambda_u245.m1308getSelectiond9O1mEE()), TextRange.m6249getMinimpl($this$deleteSelectedText_u24lambda_u245.m1308getSelectiond9O1mEE()));
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior$iv);
        }
    }

    /* JADX INFO: renamed from: replaceText-Sb-Bc2M$default, reason: not valid java name */
    public static /* synthetic */ void m1362replaceTextSbBc2M$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.m1367replaceTextSbBc2M(charSequence, j, textFieldEditUndoBehavior);
    }

    /* JADX INFO: renamed from: replaceText-Sb-Bc2M, reason: not valid java name */
    public final void m1367replaceTextSbBc2M(CharSequence newText, long range, TextFieldEditUndoBehavior undoBehavior) {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$replaceText_Sb_Bc2M_u24lambda_u246 = $this$iv.getMainBuffer();
        long selection = m1364mapFromTransformedGEjPoXI(range);
        $this$replaceText_Sb_Bc2M_u24lambda_u246.replace(TextRange.m6249getMinimpl(selection), TextRange.m6248getMaximpl(selection), newText);
        int cursor = TextRange.m6249getMinimpl(selection) + newText.length();
        $this$replaceText_Sb_Bc2M_u24lambda_u246.setSelection(cursor, cursor);
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior);
        }
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.replaceSelectedText(charSequence, z, textFieldEditUndoBehavior);
    }

    public final void replaceSelectedText(CharSequence newText, boolean clearComposition, TextFieldEditUndoBehavior undoBehavior) {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$replaceSelectedText_u24lambda_u247 = $this$iv.getMainBuffer();
        if (clearComposition) {
            $this$replaceSelectedText_u24lambda_u247.commitComposition();
        }
        long selection = $this$replaceSelectedText_u24lambda_u247.m1308getSelectiond9O1mEE();
        $this$replaceSelectedText_u24lambda_u247.replace(TextRange.m6249getMinimpl(selection), TextRange.m6248getMaximpl(selection), newText);
        int cursor = TextRange.m6249getMinimpl(selection) + newText.length();
        $this$replaceSelectedText_u24lambda_u247.setSelection(cursor, cursor);
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior);
        }
    }

    public final void collapseSelectionToMax() {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$collapseSelectionToMax_u24lambda_u248 = $this$iv.getMainBuffer();
        $this$collapseSelectionToMax_u24lambda_u248.setSelection(TextRange.m6248getMaximpl($this$collapseSelectionToMax_u24lambda_u248.m1308getSelectiond9O1mEE()), TextRange.m6248getMaximpl($this$collapseSelectionToMax_u24lambda_u248.m1308getSelectiond9O1mEE()));
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior$iv);
        }
    }

    public final void collapseSelectionToEnd() {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer $this$collapseSelectionToEnd_u24lambda_u249 = $this$iv.getMainBuffer();
        $this$collapseSelectionToEnd_u24lambda_u249.setSelection(TextRange.m6246getEndimpl($this$collapseSelectionToEnd_u24lambda_u249.m1308getSelectiond9O1mEE()), TextRange.m6246getEndimpl($this$collapseSelectionToEnd_u24lambda_u249.m1308getSelectiond9O1mEE()));
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, true, undoBehavior$iv);
        }
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState $this, boolean restartImeIfContentChanges, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            restartImeIfContentChanges = true;
        }
        TextFieldState $this$iv = $this.textFieldState;
        InputTransformation inputTransformation$iv = $this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        block.invoke($this$iv.getMainBuffer());
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, restartImeIfContentChanges, undoBehavior$iv);
        }
    }

    public final void editUntransformedTextAsUser(boolean restartImeIfContentChanges, Function1<? super EditingBuffer, Unit> block) {
        TextFieldState $this$iv = this.textFieldState;
        InputTransformation inputTransformation$iv = this.inputTransformation;
        TextFieldEditUndoBehavior undoBehavior$iv = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence previousValue$iv = $this$iv.getValue$foundation_release();
        $this$iv.getMainBuffer().getChangeTracker().clearChanges();
        block.invoke($this$iv.getMainBuffer());
        if ($this$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m6244equalsimpl0(previousValue$iv.getSelection(), $this$iv.getMainBuffer().m1308getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv.getComposition(), $this$iv.getMainBuffer().m1307getCompositionMzsxiRA())) {
            $this$iv.commitEditAsUser(previousValue$iv, inputTransformation$iv, restartImeIfContentChanges, undoBehavior$iv);
        }
    }

    /* JADX INFO: renamed from: mapToTransformed--jx7JFs, reason: not valid java name */
    public final long m1365mapToTransformedjx7JFs(int offset) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator visualMapping = null;
        OffsetMappingCalculator presentMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            visualMapping = value.getOffsetMapping();
        }
        long intermediateRange = presentMapping != null ? presentMapping.m1319mapFromSourcejx7JFs(offset) : TextRangeKt.TextRange(offset);
        if (visualMapping == null) {
            return intermediateRange;
        }
        OffsetMappingCalculator it = visualMapping;
        return Companion.m1373mapToTransformedXGyztTk(intermediateRange, it, getSelectionWedgeAffinity());
    }

    /* JADX INFO: renamed from: mapToTransformed-GEjPoXI, reason: not valid java name */
    public final long m1366mapToTransformedGEjPoXI(long range) {
        long intermediateRange;
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator visualMapping = null;
        OffsetMappingCalculator presentMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            visualMapping = value.getOffsetMapping();
        }
        if (presentMapping != null) {
            OffsetMappingCalculator it = presentMapping;
            intermediateRange = Companion.m1374mapToTransformedXGyztTk$default(Companion, range, it, null, 4, null);
        } else {
            intermediateRange = range;
        }
        if (visualMapping == null) {
            return intermediateRange;
        }
        OffsetMappingCalculator it2 = visualMapping;
        return Companion.m1373mapToTransformedXGyztTk(intermediateRange, it2, getSelectionWedgeAffinity());
    }

    /* JADX INFO: renamed from: mapFromTransformed--jx7JFs, reason: not valid java name */
    public final long m1363mapFromTransformedjx7JFs(int offset) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator visualMapping = null;
        OffsetMappingCalculator presentMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            visualMapping = value.getOffsetMapping();
        }
        long intermediateOffset = visualMapping != null ? visualMapping.m1318mapFromDestjx7JFs(offset) : TextRangeKt.TextRange(offset);
        if (presentMapping == null) {
            return intermediateOffset;
        }
        OffsetMappingCalculator it = presentMapping;
        return Companion.m1372mapFromTransformedxdX6G0(intermediateOffset, it);
    }

    /* JADX INFO: renamed from: mapFromTransformed-GEjPoXI, reason: not valid java name */
    public final long m1364mapFromTransformedGEjPoXI(long range) {
        long intermediateRange;
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator visualMapping = null;
        OffsetMappingCalculator presentMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            visualMapping = value.getOffsetMapping();
        }
        if (visualMapping == null) {
            intermediateRange = range;
        } else {
            OffsetMappingCalculator it = visualMapping;
            intermediateRange = Companion.m1372mapFromTransformedxdX6G0(range, it);
        }
        if (presentMapping == null) {
            return intermediateRange;
        }
        OffsetMappingCalculator it2 = presentMapping;
        return Companion.m1372mapFromTransformedxdX6G0(intermediateRange, it2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object collectImeNotifications(final TextFieldState.NotifyImeListener notifyImeListener, Continuation<?> continuation) {
        C08361 c08361;
        if (continuation instanceof C08361) {
            c08361 = (C08361) continuation;
            if ((c08361.label & Integer.MIN_VALUE) != 0) {
                c08361.label -= Integer.MIN_VALUE;
            } else {
                c08361 = new C08361(continuation);
            }
        } else {
            c08361 = new C08361(continuation);
        }
        C08361 c08362 = c08361;
        Object $result = c08362.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c08362.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c08362.L$0 = this;
                c08362.L$1 = notifyImeListener;
                c08362.label = 1;
                C08361 uCont$iv = c08362;
                CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                cancellable$iv.initCancellability();
                CancellableContinuationImpl continuation2 = cancellable$iv;
                this.textFieldState.addNotifyImeListener$foundation_release(notifyImeListener);
                continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
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
                    public final void invoke2(Throwable it) {
                        this.this$0.textFieldState.removeNotifyImeListener$foundation_release(notifyImeListener);
                    }
                });
                Object result = cancellable$iv.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c08362);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TransformedTextFieldState) && Intrinsics.areEqual(this.textFieldState, ((TransformedTextFieldState) other).textFieldState) && Intrinsics.areEqual(this.codepointTransformation, ((TransformedTextFieldState) other).codepointTransformation)) {
            return Intrinsics.areEqual(this.outputTransformation, ((TransformedTextFieldState) other).outputTransformation);
        }
        return false;
    }

    public int hashCode() {
        int result = this.textFieldState.hashCode();
        int i = result * 31;
        CodepointTransformation codepointTransformation = this.codepointTransformation;
        int result2 = i + (codepointTransformation != null ? codepointTransformation.hashCode() : 0);
        int result3 = result2 * 31;
        OutputTransformation outputTransformation = this.outputTransformation;
        return result3 + (outputTransformation != null ? outputTransformation.hashCode() : 0);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + ((Object) getOutputText()) + "\", visualText=\"" + ((Object) getVisualText()) + "\")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TransformedTextFieldState.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final /* data */ class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText transformedText, TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldCharSequence = transformedText.text;
            }
            if ((i & 2) != 0) {
                offsetMappingCalculator = transformedText.offsetMapping;
            }
            return transformedText.copy(textFieldCharSequence, offsetMappingCalculator);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TextFieldCharSequence getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence text, OffsetMappingCalculator offsetMapping) {
            return new TransformedText(text, offsetMapping);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransformedText)) {
                return false;
            }
            TransformedText transformedText = (TransformedText) other;
            return Intrinsics.areEqual(this.text, transformedText.text) && Intrinsics.areEqual(this.offsetMapping, transformedText.offsetMapping);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public TransformedText(TextFieldCharSequence text, OffsetMappingCalculator offsetMapping) {
            this.text = text;
            this.offsetMapping = offsetMapping;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TransformedTextFieldState.kt */
    @Metadata(m194d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "mapToTransformed", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class Companion {

        /* JADX INFO: compiled from: TransformedTextFieldState.kt */
        @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[WedgeAffinity.values().length];
                try {
                    iArr[WedgeAffinity.Start.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[WedgeAffinity.End.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, OutputTransformation outputTransformation, SelectionWedgeAffinity wedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            TextFieldBuffer buffer = new TextFieldBuffer(untransformedValue, null, null, offsetMappingCalculator, 6, null);
            outputTransformation.transformOutput(buffer);
            TextRange textRangeM6239boximpl = null;
            if (buffer.getChanges().getChangeCount() == 0) {
                return null;
            }
            long jM1373mapToTransformedXGyztTk = m1373mapToTransformedXGyztTk(untransformedValue.getSelection(), offsetMappingCalculator, wedgeAffinity);
            TextRange composition = untransformedValue.getComposition();
            if (composition != null) {
                long it = composition.getPackedValue();
                textRangeM6239boximpl = TextRange.m6239boximpl(TransformedTextFieldState.Companion.m1373mapToTransformedXGyztTk(it, offsetMappingCalculator, wedgeAffinity));
            }
            TextFieldCharSequence transformedTextWithSelection = buffer.m1280toTextFieldCharSequenceudt6zUU$foundation_release(jM1373mapToTransformedXGyztTk, textRangeM6239boximpl);
            return new TransformedText(transformedTextWithSelection, offsetMappingCalculator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, CodepointTransformation codepointTransformation, SelectionWedgeAffinity wedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence transformedText = CodepointTransformationKt.toVisualText(untransformedValue, codepointTransformation, offsetMappingCalculator);
            TextRange textRangeM6239boximpl = null;
            if (transformedText == untransformedValue) {
                return null;
            }
            long jM1373mapToTransformedXGyztTk = m1373mapToTransformedXGyztTk(untransformedValue.getSelection(), offsetMappingCalculator, wedgeAffinity);
            TextRange composition = untransformedValue.getComposition();
            if (composition != null) {
                long it = composition.getPackedValue();
                textRangeM6239boximpl = TextRange.m6239boximpl(TransformedTextFieldState.Companion.m1373mapToTransformedXGyztTk(it, offsetMappingCalculator, wedgeAffinity));
            }
            TextFieldCharSequence transformedTextWithSelection = TextFieldCharSequenceKt.m1285TextFieldCharSequence3r_uNRQ(transformedText, jM1373mapToTransformedXGyztTk, textRangeM6239boximpl);
            return new TransformedText(transformedTextWithSelection, offsetMappingCalculator);
        }

        /* JADX INFO: renamed from: mapToTransformed-XGyztTk$default, reason: not valid java name */
        static /* synthetic */ long m1374mapToTransformedXGyztTk$default(Companion companion, long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity, int i, Object obj) {
            if ((i & 4) != 0) {
                selectionWedgeAffinity = null;
            }
            return companion.m1373mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
        public final long m1373mapToTransformedXGyztTk(long range, OffsetMappingCalculator mapping, SelectionWedgeAffinity wedgeAffinity) {
            long transformedRange;
            long transformedStart = mapping.m1319mapFromSourcejx7JFs(TextRange.m6251getStartimpl(range));
            long transformedEnd = TextRange.m6245getCollapsedimpl(range) ? transformedStart : mapping.m1319mapFromSourcejx7JFs(TextRange.m6246getEndimpl(range));
            int transformedMin = Math.min(TextRange.m6249getMinimpl(transformedStart), TextRange.m6249getMinimpl(transformedEnd));
            int transformedMax = Math.max(TextRange.m6248getMaximpl(transformedStart), TextRange.m6248getMaximpl(transformedEnd));
            if (TextRange.m6250getReversedimpl(range)) {
                transformedRange = TextRangeKt.TextRange(transformedMax, transformedMin);
            } else {
                transformedRange = TextRangeKt.TextRange(transformedMin, transformedMax);
            }
            if (!TextRange.m6245getCollapsedimpl(range) || TextRange.m6245getCollapsedimpl(transformedRange)) {
                return transformedRange;
            }
            WedgeAffinity startAffinity = wedgeAffinity != null ? wedgeAffinity.getStartAffinity() : null;
            switch (startAffinity == null ? -1 : WhenMappings.$EnumSwitchMapping$0[startAffinity.ordinal()]) {
                case -1:
                    return transformedRange;
                case 0:
                default:
                    throw new NoWhenBranchMatchedException();
                case 1:
                    return TextRangeKt.TextRange(TextRange.m6251getStartimpl(transformedRange));
                case 2:
                    return TextRangeKt.TextRange(TextRange.m6246getEndimpl(transformedRange));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
        public final long m1372mapFromTransformedxdX6G0(long range, OffsetMappingCalculator mapping) {
            long untransformedStart = mapping.m1318mapFromDestjx7JFs(TextRange.m6251getStartimpl(range));
            long untransformedEnd = TextRange.m6245getCollapsedimpl(range) ? untransformedStart : mapping.m1318mapFromDestjx7JFs(TextRange.m6246getEndimpl(range));
            int untransformedMin = Math.min(TextRange.m6249getMinimpl(untransformedStart), TextRange.m6249getMinimpl(untransformedEnd));
            int untransformedMax = Math.max(TextRange.m6248getMaximpl(untransformedStart), TextRange.m6248getMaximpl(untransformedEnd));
            if (TextRange.m6250getReversedimpl(range)) {
                return TextRangeKt.TextRange(untransformedMax, untransformedMin);
            }
            return TextRangeKt.TextRange(untransformedMin, untransformedMax);
        }
    }
}
