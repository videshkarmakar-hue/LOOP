package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: InputTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\f\u0010\b\u001a\u00020\t*\u00020\nH\u0017J\f\u0010\u000b\u001a\u00020\t*\u00020\fH&R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, m195d2 = {"Landroidx/compose/foundation/text/input/InputTransformation;", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions$annotations", "()V", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Companion", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface InputTransformation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver);

    KeyboardOptions getKeyboardOptions();

    void transformInput(TextFieldBuffer textFieldBuffer);

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.InputTransformation$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: InputTransformation.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = InputTransformation.INSTANCE;
        }

        public static /* synthetic */ void getKeyboardOptions$annotations() {
        }

        public static KeyboardOptions $default$getKeyboardOptions(InputTransformation _this) {
            return null;
        }

        public static void $default$applySemantics(InputTransformation _this, SemanticsPropertyReceiver $this$applySemantics) {
        }
    }

    /* JADX INFO: compiled from: InputTransformation.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0016¨\u0006\u0006"}, m195d2 = {"Landroidx/compose/foundation/text/input/InputTransformation$Companion;", "Landroidx/compose/foundation/text/input/InputTransformation;", "()V", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion implements InputTransformation {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Override // androidx.compose.foundation.text.input.InputTransformation
        public /* synthetic */ void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            CC.$default$applySemantics(this, semanticsPropertyReceiver);
        }

        @Override // androidx.compose.foundation.text.input.InputTransformation
        public /* synthetic */ KeyboardOptions getKeyboardOptions() {
            return CC.$default$getKeyboardOptions(this);
        }

        private Companion() {
        }

        @Override // androidx.compose.foundation.text.input.InputTransformation
        public void transformInput(TextFieldBuffer $this$transformInput) {
        }
    }
}
