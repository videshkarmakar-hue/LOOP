package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p001ui.input.key.Key;
import androidx.compose.p001ui.input.key.KeyEvent_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyMapping.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m195d2 = {"platformDefaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getPlatformDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KeyMapping_androidKt {
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        /* JADX INFO: renamed from: map-ZmokQxo */
        public KeyCommand mo1178mapZmokQxo(KeyEvent event) {
            KeyCommand keyCommand = null;
            if (KeyEvent_androidKt.m5375isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m5372isAltPressedZmokQxo(event)) {
                long jM5369getKeyZmokQxo = KeyEvent_androidKt.m5369getKeyZmokQxo(event);
                if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, MappedKeys.INSTANCE.m1213getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, MappedKeys.INSTANCE.m1214getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, MappedKeys.INSTANCE.m1215getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, MappedKeys.INSTANCE.m1212getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyEvent_androidKt.m5372isAltPressedZmokQxo(event)) {
                long jM5369getKeyZmokQxo2 = KeyEvent_androidKt.m5369getKeyZmokQxo(event);
                if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo2, MappedKeys.INSTANCE.m1213getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo2, MappedKeys.INSTANCE.m1214getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo2, MappedKeys.INSTANCE.m1215getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo2, MappedKeys.INSTANCE.m1212getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo1178mapZmokQxo(event) : keyCommand;
        }
    };

    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
