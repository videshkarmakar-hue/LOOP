package androidx.compose.p001ui.platform;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/platform/InspectableValue;", "", "inspectableElements", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "nameFallback", "", "getNameFallback", "()Ljava/lang/String;", "valueOverride", "getValueOverride", "()Ljava/lang/Object;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface InspectableValue {
    Sequence<ValueElement> getInspectableElements();

    String getNameFallback();

    Object getValueOverride();

    /* JADX INFO: renamed from: androidx.compose.ui.platform.InspectableValue$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: InspectableValue.kt */
    public final /* synthetic */ class CC {
        public static Sequence $default$getInspectableElements(InspectableValue _this) {
            return SequencesKt.emptySequence();
        }

        public static String $default$getNameFallback(InspectableValue _this) {
            return null;
        }

        public static Object $default$getValueOverride(InspectableValue _this) {
            return null;
        }
    }

    /* JADX INFO: compiled from: InspectableValue.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static Sequence<ValueElement> getInspectableElements(InspectableValue $this) {
            return CC.$default$getInspectableElements($this);
        }

        @Deprecated
        public static String getNameFallback(InspectableValue $this) {
            return CC.$default$getNameFallback($this);
        }

        @Deprecated
        public static Object getValueOverride(InspectableValue $this) {
            return CC.$default$getValueOverride($this);
        }
    }
}
