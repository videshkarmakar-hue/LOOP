package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import androidx.compose.p001ui.graphics.Matrix;
import androidx.compose.p001ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.input.EditCommand;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.ImeOptions;
import androidx.compose.p001ui.text.input.OffsetMapping;
import androidx.compose.p001ui.text.input.TextFieldValue;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u00020\u0007H\u0002JD\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 \u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00070\u0005J\u0018\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u00010%2\u0006\u00106\u001a\u00020%J.\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u000200R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 \u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006?"}, m195d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "view", "Landroid/view/View;", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "cursorAnchorInfoController", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "focusedRect", "Landroid/graphics/Rect;", "getFocusedRect$foundation_release", "()Landroid/graphics/Rect;", "setFocusedRect$foundation_release", "(Landroid/graphics/Rect;)V", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getView", "()Landroid/view/View;", "createInputConnection", "outAttributes", "Landroid/view/inputmethod/EditorInfo;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInputImmediately", "startInput", DownloadUtil.CookieScheme.VALUE, "updateState", "oldValue", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "decorationBoxBounds", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {
    public static final int $stable = 8;
    private final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    private Rect focusedRect;
    private final InputMethodManager inputMethodManager;
    private final View view;
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onEditCommand$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends EditCommand> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends EditCommand> list) {
        }
    };
    private Function1<? super ImeAction, Unit> onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onImeActionPerformed$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
            m1313invokeKlQnJC8(imeAction.getValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
        public final void m1313invokeKlQnJC8(int it) {
        }
    };
    private TextFieldValue state = new TextFieldValue("", TextRange.INSTANCE.m6256getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
    private ImeOptions imeOptions = ImeOptions.INSTANCE.getDefault();
    private List<WeakReference<RecordingInputConnection>> ics = new ArrayList();

    /* JADX INFO: renamed from: baseInputConnection$delegate, reason: from kotlin metadata */
    private final Lazy baseInputConnection = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<BaseInputConnection>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$baseInputConnection$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BaseInputConnection invoke() {
            return new BaseInputConnection(this.this$0.getView(), false);
        }
    });

    public LegacyTextInputMethodRequest(View view, Function1<? super Matrix, Unit> function1, InputMethodManager inputMethodManager) {
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(function1, this.inputMethodManager);
    }

    public final View getView() {
        return this.view;
    }

    public final TextFieldValue getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection.getValue();
    }

    /* JADX INFO: renamed from: getFocusedRect$foundation_release, reason: from getter */
    public final Rect getFocusedRect() {
        return this.focusedRect;
    }

    public final void setFocusedRect$foundation_release(Rect rect) {
        this.focusedRect = rect;
    }

    public final void startInput(TextFieldValue value, ImeOptions imeOptions, Function1<? super List<? extends EditCommand>, Unit> onEditCommand, Function1<? super ImeAction, Unit> onImeActionPerformed) {
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = onEditCommand;
        this.onImeActionPerformed = onImeActionPerformed;
    }

    @Override // androidx.compose.p001ui.platform.PlatformTextInputMethodRequest
    public RecordingInputConnection createInputConnection(EditorInfo outAttributes) {
        EditorInfo_androidKt.m1311updatepLxbY9I$default(outAttributes, this.state.getText(), this.state.getSelection(), this.imeOptions, null, 8, null);
        LegacyPlatformTextInputServiceAdapter_androidKt.updateWithEmojiCompat(outAttributes);
        RecordingInputConnection it = new RecordingInputConnection(this.state, new InputEventCallback2() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest.createInputConnection.1
            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onEditCommands(List<? extends EditCommand> editCommands) {
                LegacyTextInputMethodRequest.this.onEditCommand.invoke(editCommands);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            /* JADX INFO: renamed from: onImeAction-KlQnJC8 */
            public void mo1312onImeActionKlQnJC8(int imeAction) {
                LegacyTextInputMethodRequest.this.onImeActionPerformed.invoke(ImeAction.m6416boximpl(imeAction));
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onKeyEvent(KeyEvent event) {
                LegacyTextInputMethodRequest.this.getBaseInputConnection().sendKeyEvent(event);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onRequestCursorAnchorInfo(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
                LegacyTextInputMethodRequest.this.cursorAnchorInfoController.requestUpdate(immediate, monitor, includeInsertionMarker, includeCharacterBounds, includeEditorBounds, includeLineBounds);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onConnectionClosed(RecordingInputConnection inputConnection) {
                int size = LegacyTextInputMethodRequest.this.ics.size();
                for (int i = 0; i < size; i++) {
                    if (Intrinsics.areEqual(((WeakReference) LegacyTextInputMethodRequest.this.ics.get(i)).get(), inputConnection)) {
                        LegacyTextInputMethodRequest.this.ics.remove(i);
                        return;
                    }
                }
            }
        }, this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference<>(it));
        return it;
    }

    public final void updateState(TextFieldValue oldValue, TextFieldValue newValue) {
        boolean restartInput = false;
        boolean needUpdateSelection = (TextRange.m6244equalsimpl0(this.state.getSelection(), newValue.getSelection()) && Intrinsics.areEqual(this.state.getComposition(), newValue.getComposition())) ? false : true;
        this.state = newValue;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setTextFieldValue$foundation_release(newValue);
            }
        }
        this.cursorAnchorInfoController.invalidate();
        if (Intrinsics.areEqual(oldValue, newValue)) {
            if (needUpdateSelection) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                int iM6249getMinimpl = TextRange.m6249getMinimpl(newValue.getSelection());
                int iM6248getMaximpl = TextRange.m6248getMaximpl(newValue.getSelection());
                TextRange composition = this.state.getComposition();
                int iM6249getMinimpl2 = composition != null ? TextRange.m6249getMinimpl(composition.getPackedValue()) : -1;
                TextRange composition2 = this.state.getComposition();
                inputMethodManager.updateSelection(iM6249getMinimpl, iM6248getMaximpl, iM6249getMinimpl2, composition2 != null ? TextRange.m6248getMaximpl(composition2.getPackedValue()) : -1);
                return;
            }
            return;
        }
        if (oldValue != null && (!Intrinsics.areEqual(oldValue.getText(), newValue.getText()) || (TextRange.m6244equalsimpl0(oldValue.getSelection(), newValue.getSelection()) && !Intrinsics.areEqual(oldValue.getComposition(), newValue.getComposition())))) {
            restartInput = true;
        }
        if (restartInput) {
            restartInputImmediately();
            return;
        }
        int size2 = this.ics.size();
        for (int i2 = 0; i2 < size2; i2++) {
            RecordingInputConnection recordingInputConnection2 = this.ics.get(i2).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
            }
        }
    }

    public final void notifyFocusedRect(androidx.compose.p001ui.geometry.Rect rect) {
        Rect it;
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (this.ics.isEmpty() && (it = this.focusedRect) != null) {
            this.view.requestRectangleOnScreen(new Rect(it));
        }
    }

    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, androidx.compose.p001ui.geometry.Rect innerTextFieldBounds, androidx.compose.p001ui.geometry.Rect decorationBoxBounds) {
        this.cursorAnchorInfoController.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, innerTextFieldBounds, decorationBoxBounds);
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }
}
