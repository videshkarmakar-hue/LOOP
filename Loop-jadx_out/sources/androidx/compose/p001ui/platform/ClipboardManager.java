package androidx.compose.p001ui.platform;

import androidx.compose.p001ui.text.AnnotatedString;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ClipboardManager.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/platform/ClipboardManager;", "", "nativeClipboard", "Landroid/content/ClipboardManager;", "Landroidx/compose/ui/platform/NativeClipboard;", "getNativeClipboard", "()Landroid/content/ClipboardManager;", "getClip", "Landroidx/compose/ui/platform/ClipEntry;", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "hasText", "", "setClip", "", "clipEntry", "setText", "annotatedString", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface ClipboardManager {
    ClipEntry getClip();

    android.content.ClipboardManager getNativeClipboard();

    AnnotatedString getText();

    boolean hasText();

    void setClip(ClipEntry clipEntry);

    void setText(AnnotatedString annotatedString);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ClipboardManager$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ClipboardManager.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$hasText(ClipboardManager _this) {
            AnnotatedString text = _this.getText();
            if (text != null) {
                return text.length() > 0;
            }
            return false;
        }

        public static ClipEntry $default$getClip(ClipboardManager _this) {
            return null;
        }

        public static void $default$setClip(ClipboardManager _this, ClipEntry clipEntry) {
        }

        public static android.content.ClipboardManager $default$getNativeClipboard(ClipboardManager _this) {
            throw new UnsupportedOperationException("This platform does not offer a native Clipboard");
        }
    }
}
