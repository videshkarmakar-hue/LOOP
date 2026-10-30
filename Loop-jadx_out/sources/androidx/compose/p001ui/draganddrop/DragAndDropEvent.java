package androidx.compose.p001ui.draganddrop;

import android.view.DragEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: DragAndDrop.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m195d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "dragEvent", "Landroid/view/DragEvent;", "(Landroid/view/DragEvent;)V", "getDragEvent$ui_release", "()Landroid/view/DragEvent;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DragAndDropEvent {
    public static final int $stable = 8;
    private final DragEvent dragEvent;

    public DragAndDropEvent(DragEvent dragEvent) {
        this.dragEvent = dragEvent;
    }

    /* JADX INFO: renamed from: getDragEvent$ui_release, reason: from getter */
    public final DragEvent getDragEvent() {
        return this.dragEvent;
    }
}
