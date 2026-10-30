package androidx.compose.p001ui.draganddrop;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: DragAndDrop.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, m195d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "", "onChanged", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "onDrop", "", "onEnded", "onEntered", "onExited", "onMoved", "onStarted", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface DragAndDropTarget {
    void onChanged(DragAndDropEvent event);

    boolean onDrop(DragAndDropEvent event);

    void onEnded(DragAndDropEvent event);

    void onEntered(DragAndDropEvent event);

    void onExited(DragAndDropEvent event);

    void onMoved(DragAndDropEvent event);

    void onStarted(DragAndDropEvent event);

    /* JADX INFO: renamed from: androidx.compose.ui.draganddrop.DragAndDropTarget$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: DragAndDrop.kt */
    public final /* synthetic */ class CC {
        public static void $default$onStarted(DragAndDropTarget _this, DragAndDropEvent event) {
        }

        public static void $default$onEntered(DragAndDropTarget _this, DragAndDropEvent event) {
        }

        public static void $default$onMoved(DragAndDropTarget _this, DragAndDropEvent event) {
        }

        public static void $default$onExited(DragAndDropTarget _this, DragAndDropEvent event) {
        }

        public static void $default$onChanged(DragAndDropTarget _this, DragAndDropEvent event) {
        }

        public static void $default$onEnded(DragAndDropTarget _this, DragAndDropEvent event) {
        }
    }
}
