package androidx.compose.material3.carousel;

import androidx.compose.foundation.pager.PageSize;
import androidx.compose.p001ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Carousel.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BO\u00128\u0010\u0002\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/material3/carousel/CarouselPageSize;", "Landroidx/compose/foundation/pager/PageSize;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "beforeContentPadding", "afterContentPadding", "(Lkotlin/jvm/functions/Function2;FF)V", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "getStrategy", "()Landroidx/compose/material3/carousel/Strategy;", "calculateMainAxisPageSize", "", "Landroidx/compose/ui/unit/Density;", "pageSpacing", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class CarouselPageSize implements PageSize {
    private final float afterContentPadding;
    private final float beforeContentPadding;
    private final Strategy strategy;

    public CarouselPageSize(Function2<? super Float, ? super Float, KeylineList> function2, float beforeContentPadding, float afterContentPadding) {
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        this.strategy = new Strategy(function2);
    }

    public final Strategy getStrategy() {
        return this.strategy;
    }

    @Override // androidx.compose.foundation.pager.PageSize
    public int calculateMainAxisPageSize(Density $this$calculateMainAxisPageSize, int availableSpace, int pageSpacing) {
        this.strategy.apply$material3_release(availableSpace, pageSpacing, this.beforeContentPadding, this.afterContentPadding);
        if (this.strategy.isValid()) {
            return MathKt.roundToInt(this.strategy.getItemMainAxisSize$material3_release());
        }
        return availableSpace;
    }
}
