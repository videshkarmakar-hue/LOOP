package androidx.compose.p001ui.layout;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ParentDataModifier.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/Modifier$Element;", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface ParentDataModifier extends Modifier.Element {
    Object modifyParentData(Density density, Object obj);

    /* JADX INFO: renamed from: androidx.compose.ui.layout.ParentDataModifier$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ParentDataModifier.kt */
    public final /* synthetic */ class CC {
    }

    /* JADX INFO: compiled from: ParentDataModifier.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(ParentDataModifier $this, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all($this, function1);
        }

        @Deprecated
        public static boolean any(ParentDataModifier $this, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any($this, function1);
        }

        @Deprecated
        public static <R> R foldIn(ParentDataModifier parentDataModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) Modifier.Element.CC.$default$foldIn(parentDataModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(ParentDataModifier parentDataModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) Modifier.Element.CC.$default$foldOut(parentDataModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(ParentDataModifier $this, Modifier other) {
            return Modifier.CC.$default$then($this, other);
        }
    }
}
