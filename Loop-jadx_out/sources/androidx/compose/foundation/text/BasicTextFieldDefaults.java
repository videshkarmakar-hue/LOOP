package androidx.compose.foundation.text;

import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m195d2 = {"Landroidx/compose/foundation/text/BasicTextFieldDefaults;", "", "()V", "CursorBrush", "Landroidx/compose/ui/graphics/SolidColor;", "getCursorBrush", "()Landroidx/compose/ui/graphics/SolidColor;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class BasicTextFieldDefaults {
    public static final BasicTextFieldDefaults INSTANCE = new BasicTextFieldDefaults();
    private static final SolidColor CursorBrush = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);

    private BasicTextFieldDefaults() {
    }

    public final SolidColor getCursorBrush() {
        return CursorBrush;
    }
}
