package androidx.compose.p001ui.layout;

import androidx.compose.p001ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: OnGloballyPositionedModifier.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "Landroidx/compose/ui/Modifier$Element;", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface OnGloballyPositionedModifier extends Modifier.Element {
    void onGloballyPositioned(LayoutCoordinates coordinates);

    /* JADX INFO: renamed from: androidx.compose.ui.layout.OnGloballyPositionedModifier$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: OnGloballyPositionedModifier.kt */
    public final /* synthetic */ class CC {
    }

    /* JADX INFO: compiled from: OnGloballyPositionedModifier.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(OnGloballyPositionedModifier $this, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all($this, function1);
        }

        @Deprecated
        public static boolean any(OnGloballyPositionedModifier $this, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any($this, function1);
        }

        @Deprecated
        public static <R> R foldIn(OnGloballyPositionedModifier onGloballyPositionedModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) Modifier.Element.CC.$default$foldIn(onGloballyPositionedModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(OnGloballyPositionedModifier onGloballyPositionedModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) Modifier.Element.CC.$default$foldOut(onGloballyPositionedModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(OnGloballyPositionedModifier $this, Modifier other) {
            return Modifier.CC.$default$then($this, other);
        }
    }
}
