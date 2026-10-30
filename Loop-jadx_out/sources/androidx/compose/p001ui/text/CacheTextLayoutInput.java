package androidx.compose.p001ui.text;

import androidx.compose.animation.C0176x19daea59;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextMeasurer.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, m195d2 = {"Landroidx/compose/ui/text/CacheTextLayoutInput;", "", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "(Landroidx/compose/ui/text/TextLayoutInput;)V", "getTextLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "equals", "", "other", "hashCode", "", "ui-text_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CacheTextLayoutInput {
    public static final int $stable = 0;
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(TextLayoutInput textLayoutInput) {
        this.textLayoutInput = textLayoutInput;
    }

    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput $this$hashCode_u24lambda_u240 = this.textLayoutInput;
        int result = $this$hashCode_u24lambda_u240.getText().hashCode();
        return (((((((((((((((((((result * 31) + $this$hashCode_u24lambda_u240.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release()) * 31) + $this$hashCode_u24lambda_u240.getPlaceholders().hashCode()) * 31) + $this$hashCode_u24lambda_u240.getMaxLines()) * 31) + C0176x19daea59.m9m($this$hashCode_u24lambda_u240.getSoftWrap())) * 31) + TextOverflow.m6701hashCodeimpl($this$hashCode_u24lambda_u240.getOverflow())) * 31) + $this$hashCode_u24lambda_u240.getDensity().hashCode()) * 31) + $this$hashCode_u24lambda_u240.getLayoutDirection().hashCode()) * 31) + $this$hashCode_u24lambda_u240.getFontFamilyResolver().hashCode()) * 31) + Constraints.m6744getMaxWidthimpl($this$hashCode_u24lambda_u240.getConstraints())) * 31) + Constraints.m6743getMaxHeightimpl($this$hashCode_u24lambda_u240.getConstraints());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput $this$equals_u24lambda_u241 = this.textLayoutInput;
        return Intrinsics.areEqual($this$equals_u24lambda_u241.getText(), ((CacheTextLayoutInput) other).textLayoutInput.getText()) && $this$equals_u24lambda_u241.getStyle().hasSameLayoutAffectingAttributes(((CacheTextLayoutInput) other).textLayoutInput.getStyle()) && Intrinsics.areEqual($this$equals_u24lambda_u241.getPlaceholders(), ((CacheTextLayoutInput) other).textLayoutInput.getPlaceholders()) && $this$equals_u24lambda_u241.getMaxLines() == ((CacheTextLayoutInput) other).textLayoutInput.getMaxLines() && $this$equals_u24lambda_u241.getSoftWrap() == ((CacheTextLayoutInput) other).textLayoutInput.getSoftWrap() && TextOverflow.m6700equalsimpl0($this$equals_u24lambda_u241.getOverflow(), ((CacheTextLayoutInput) other).textLayoutInput.getOverflow()) && Intrinsics.areEqual($this$equals_u24lambda_u241.getDensity(), ((CacheTextLayoutInput) other).textLayoutInput.getDensity()) && $this$equals_u24lambda_u241.getLayoutDirection() == ((CacheTextLayoutInput) other).textLayoutInput.getLayoutDirection() && $this$equals_u24lambda_u241.getFontFamilyResolver() == ((CacheTextLayoutInput) other).textLayoutInput.getFontFamilyResolver() && Constraints.m6744getMaxWidthimpl($this$equals_u24lambda_u241.getConstraints()) == Constraints.m6744getMaxWidthimpl(((CacheTextLayoutInput) other).textLayoutInput.getConstraints()) && Constraints.m6743getMaxHeightimpl($this$equals_u24lambda_u241.getConstraints()) == Constraints.m6743getMaxHeightimpl(((CacheTextLayoutInput) other).textLayoutInput.getConstraints());
    }
}
