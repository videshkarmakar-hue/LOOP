package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import androidx.compose.animation.C0176x19daea59;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.NotificationUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Strategy.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001AB?\u00128\u0010\u0002\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003¢\u0006\u0002\u0010\nJ-\u00100\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b1J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u00105\u001a\u00020\tH\u0001¢\u0006\u0002\b6J'\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u000203H\u0000¢\u0006\u0002\b;J\r\u0010<\u001a\u00020\tH\u0001¢\u0006\u0002\b=J\b\u0010>\u001a\u00020?H\u0016J\u0006\u0010@\u001a\u000203R\u001a\u0010\u000b\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\tX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R+\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR@\u0010\u0002\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\u001bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\u000e\u0010.\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000¨\u0006B"}, m195d2 = {"Landroidx/compose/material3/carousel/Strategy;", "", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "(Lkotlin/jvm/functions/Function2;)V", "afterContentPadding", "getAfterContentPadding$material3_release", "()F", "setAfterContentPadding$material3_release", "(F)V", "getAvailableSpace$material3_release", "setAvailableSpace$material3_release", "beforeContentPadding", "getBeforeContentPadding$material3_release", "setBeforeContentPadding$material3_release", "defaultKeylines", "getDefaultKeylines$material3_release", "()Landroidx/compose/material3/carousel/KeylineList;", "setDefaultKeylines$material3_release", "(Landroidx/compose/material3/carousel/KeylineList;)V", "endKeylineSteps", "", "getEndKeylineSteps$material3_release", "()Ljava/util/List;", "setEndKeylineSteps$material3_release", "(Ljava/util/List;)V", "endShiftDistance", "endShiftPoints", "Landroidx/collection/FloatList;", "<set-?>", "itemMainAxisSize", "getItemMainAxisSize$material3_release", "setItemMainAxisSize$material3_release", "itemMainAxisSize$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getItemSpacing$material3_release", "setItemSpacing$material3_release", "startKeylineSteps", "getStartKeylineSteps$material3_release", "setStartKeylineSteps$material3_release", "startShiftDistance", "startShiftPoints", "apply", "apply$material3_release", "equals", "", "other", "getEndKeylines", "getEndKeylines$material3_release", "getKeylineListForScrollOffset", "scrollOffset", "maxScrollOffset", "roundToNearestStep", "getKeylineListForScrollOffset$material3_release", "getStartKeylines", "getStartKeylines$material3_release", "hashCode", "", "isValid", "Companion", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Strategy {
    private float afterContentPadding;
    private float availableSpace;
    private float beforeContentPadding;
    public KeylineList defaultKeylines;
    public List<KeylineList> endKeylineSteps;
    private float endShiftDistance;
    private FloatList endShiftPoints;

    /* JADX INFO: renamed from: itemMainAxisSize$delegate, reason: from kotlin metadata */
    private final MutableFloatState itemMainAxisSize = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    private float itemSpacing;
    private final Function2<Float, Float, KeylineList> keylineList;
    public List<KeylineList> startKeylineSteps;
    private float startShiftDistance;
    private FloatList startShiftPoints;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public Strategy(Function2<? super Float, ? super Float, KeylineList> function2) {
        this.keylineList = function2;
    }

    public final KeylineList getDefaultKeylines$material3_release() {
        KeylineList keylineList = this.defaultKeylines;
        if (keylineList != null) {
            return keylineList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("defaultKeylines");
        return null;
    }

    public final void setDefaultKeylines$material3_release(KeylineList keylineList) {
        this.defaultKeylines = keylineList;
    }

    public final List<KeylineList> getStartKeylineSteps$material3_release() {
        List<KeylineList> list = this.startKeylineSteps;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startKeylineSteps");
        return null;
    }

    public final void setStartKeylineSteps$material3_release(List<KeylineList> list) {
        this.startKeylineSteps = list;
    }

    public final List<KeylineList> getEndKeylineSteps$material3_release() {
        List<KeylineList> list = this.endKeylineSteps;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endKeylineSteps");
        return null;
    }

    public final void setEndKeylineSteps$material3_release(List<KeylineList> list) {
        this.endKeylineSteps = list;
    }

    /* JADX INFO: renamed from: getAvailableSpace$material3_release, reason: from getter */
    public final float getAvailableSpace() {
        return this.availableSpace;
    }

    public final void setAvailableSpace$material3_release(float f) {
        this.availableSpace = f;
    }

    /* JADX INFO: renamed from: getItemSpacing$material3_release, reason: from getter */
    public final float getItemSpacing() {
        return this.itemSpacing;
    }

    public final void setItemSpacing$material3_release(float f) {
        this.itemSpacing = f;
    }

    /* JADX INFO: renamed from: getBeforeContentPadding$material3_release, reason: from getter */
    public final float getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final void setBeforeContentPadding$material3_release(float f) {
        this.beforeContentPadding = f;
    }

    /* JADX INFO: renamed from: getAfterContentPadding$material3_release, reason: from getter */
    public final float getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final void setAfterContentPadding$material3_release(float f) {
        this.afterContentPadding = f;
    }

    public final float getItemMainAxisSize$material3_release() {
        FloatState $this$getValue$iv = this.itemMainAxisSize;
        return $this$getValue$iv.getFloatValue();
    }

    public final void setItemMainAxisSize$material3_release(float f) {
        MutableFloatState $this$setValue$iv = this.itemMainAxisSize;
        $this$setValue$iv.setFloatValue(f);
    }

    public final boolean isValid() {
        return getItemMainAxisSize$material3_release() > 0.0f;
    }

    public final Strategy apply$material3_release(float availableSpace, float itemSpacing, float beforeContentPadding, float afterContentPadding) {
        if (this.availableSpace == availableSpace) {
            if (this.itemSpacing == itemSpacing) {
                return this;
            }
        }
        KeylineList keylineList = this.keylineList.invoke(Float.valueOf(availableSpace), Float.valueOf(itemSpacing));
        if (keylineList == null) {
            return this;
        }
        List<KeylineList> startKeylineSteps = INSTANCE.getStartKeylineSteps(keylineList, availableSpace, itemSpacing, beforeContentPadding);
        List<KeylineList> endKeylineSteps = INSTANCE.getEndKeylineSteps(keylineList, availableSpace, itemSpacing, afterContentPadding);
        float startShiftDistance = Math.max(((Keyline) CollectionsKt.first((List) CollectionsKt.last((List) startKeylineSteps))).getUnadjustedOffset() - ((Keyline) CollectionsKt.first((List) keylineList)).getUnadjustedOffset(), beforeContentPadding);
        float endShiftDistance = Math.max(((Keyline) CollectionsKt.last((List) keylineList)).getUnadjustedOffset() - ((Keyline) CollectionsKt.last((List) CollectionsKt.last((List) endKeylineSteps))).getUnadjustedOffset(), afterContentPadding);
        setDefaultKeylines$material3_release(keylineList);
        setDefaultKeylines$material3_release(keylineList);
        setStartKeylineSteps$material3_release(startKeylineSteps);
        setEndKeylineSteps$material3_release(endKeylineSteps);
        this.startShiftDistance = startShiftDistance;
        this.endShiftDistance = endShiftDistance;
        this.startShiftPoints = INSTANCE.getStepInterpolationPoints(startShiftDistance, startKeylineSteps, true);
        this.endShiftPoints = INSTANCE.getStepInterpolationPoints(endShiftDistance, endKeylineSteps, false);
        this.availableSpace = availableSpace;
        this.itemSpacing = itemSpacing;
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        setItemMainAxisSize$material3_release(getDefaultKeylines$material3_release().getFirstFocal().getSize());
        return this;
    }

    public static /* synthetic */ KeylineList getKeylineListForScrollOffset$material3_release$default(Strategy strategy, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return strategy.getKeylineListForScrollOffset$material3_release(f, f2, z);
    }

    public final KeylineList getKeylineListForScrollOffset$material3_release(float scrollOffset, float maxScrollOffset, boolean roundToNearestStep) {
        int roundedStepIndex;
        float positiveScrollOffset = Math.max(0.0f, scrollOffset);
        float startShiftOffset = this.startShiftDistance;
        float endShiftOffset = Math.max(0.0f, maxScrollOffset - this.endShiftDistance);
        boolean z = false;
        if (startShiftOffset <= positiveScrollOffset && positiveScrollOffset <= endShiftOffset) {
            z = true;
        }
        if (!z) {
            float interpolation = StrategyKt.lerp(1.0f, 0.0f, 0.0f, startShiftOffset, positiveScrollOffset);
            FloatList shiftPoints = this.startShiftPoints;
            FloatList floatList = null;
            if (shiftPoints == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startShiftPoints");
                shiftPoints = null;
            }
            List<KeylineList> startKeylineSteps$material3_release = getStartKeylineSteps$material3_release();
            if (positiveScrollOffset > endShiftOffset) {
                interpolation = StrategyKt.lerp(0.0f, 1.0f, endShiftOffset, maxScrollOffset, positiveScrollOffset);
                FloatList floatList2 = this.endShiftPoints;
                if (floatList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endShiftPoints");
                } else {
                    floatList = floatList2;
                }
                shiftPoints = floatList;
                startKeylineSteps$material3_release = getEndKeylineSteps$material3_release();
            }
            Companion.ShiftPointRange shiftPointRange = INSTANCE.getShiftPointRange(startKeylineSteps$material3_release.size(), shiftPoints, interpolation);
            if (roundToNearestStep) {
                if (MathKt.roundToInt(shiftPointRange.getSteppedInterpolation()) == 0) {
                    roundedStepIndex = shiftPointRange.getFromStepIndex();
                } else {
                    roundedStepIndex = shiftPointRange.getToStepIndex();
                }
                return startKeylineSteps$material3_release.get(roundedStepIndex);
            }
            int roundedStepIndex2 = shiftPointRange.getFromStepIndex();
            return KeylineListKt.lerp(startKeylineSteps$material3_release.get(roundedStepIndex2), startKeylineSteps$material3_release.get(shiftPointRange.getToStepIndex()), shiftPointRange.getSteppedInterpolation());
        }
        return getDefaultKeylines$material3_release();
    }

    public final KeylineList getEndKeylines$material3_release() {
        return (KeylineList) CollectionsKt.last((List) getEndKeylineSteps$material3_release());
    }

    public final KeylineList getStartKeylines$material3_release() {
        return (KeylineList) CollectionsKt.last((List) getStartKeylineSteps$material3_release());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Strategy)) {
            return false;
        }
        if (!isValid() && !((Strategy) other).isValid()) {
            return true;
        }
        if (isValid() != ((Strategy) other).isValid()) {
            return false;
        }
        if (!(this.availableSpace == ((Strategy) other).availableSpace)) {
            return false;
        }
        if (!(this.itemSpacing == ((Strategy) other).itemSpacing)) {
            return false;
        }
        if (!(this.beforeContentPadding == ((Strategy) other).beforeContentPadding)) {
            return false;
        }
        if (!(this.afterContentPadding == ((Strategy) other).afterContentPadding)) {
            return false;
        }
        if (!(getItemMainAxisSize$material3_release() == ((Strategy) other).getItemMainAxisSize$material3_release())) {
            return false;
        }
        if (!(this.startShiftDistance == ((Strategy) other).startShiftDistance)) {
            return false;
        }
        if (!(this.endShiftDistance == ((Strategy) other).endShiftDistance)) {
            return false;
        }
        FloatList floatList = this.startShiftPoints;
        FloatList floatList2 = null;
        if (floatList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startShiftPoints");
            floatList = null;
        }
        FloatList floatList3 = ((Strategy) other).startShiftPoints;
        if (floatList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startShiftPoints");
            floatList3 = null;
        }
        if (!Intrinsics.areEqual(floatList, floatList3)) {
            return false;
        }
        FloatList floatList4 = this.endShiftPoints;
        if (floatList4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endShiftPoints");
            floatList4 = null;
        }
        FloatList floatList5 = ((Strategy) other).endShiftPoints;
        if (floatList5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endShiftPoints");
        } else {
            floatList2 = floatList5;
        }
        return Intrinsics.areEqual(floatList4, floatList2) && Intrinsics.areEqual(getDefaultKeylines$material3_release(), ((Strategy) other).getDefaultKeylines$material3_release());
    }

    public int hashCode() {
        if (!isValid()) {
            return C0176x19daea59.m9m(isValid());
        }
        int result = C0176x19daea59.m9m(isValid());
        int result2 = ((((((((((((((result * 31) + Float.floatToIntBits(this.availableSpace)) * 31) + Float.floatToIntBits(this.itemSpacing)) * 31) + Float.floatToIntBits(this.beforeContentPadding)) * 31) + Float.floatToIntBits(this.afterContentPadding)) * 31) + Float.floatToIntBits(getItemMainAxisSize$material3_release())) * 31) + Float.floatToIntBits(this.startShiftDistance)) * 31) + Float.floatToIntBits(this.endShiftDistance)) * 31;
        FloatList floatList = this.startShiftPoints;
        FloatList floatList2 = null;
        if (floatList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startShiftPoints");
            floatList = null;
        }
        int result3 = (result2 + floatList.hashCode()) * 31;
        FloatList floatList3 = this.endShiftPoints;
        if (floatList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endShiftPoints");
        } else {
            floatList2 = floatList3;
        }
        return ((result3 + floatList2.hashCode()) * 31) + getDefaultKeylines$material3_release().hashCode();
    }

    /* JADX INFO: compiled from: Strategy.kt */
    @Metadata(m194d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J&\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J0\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 *\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002¨\u0006#"}, m195d2 = {"Landroidx/compose/material3/carousel/Strategy$Companion;", "", "()V", "createShiftedKeylineListForContentPadding", "Landroidx/compose/material3/carousel/KeylineList;", "from", "carouselMainAxisSize", "", "itemSpacing", "contentPadding", "getEndKeylineSteps", "", "defaultKeylines", "afterContentPadding", "getShiftPointRange", "Landroidx/compose/material3/carousel/Strategy$Companion$ShiftPointRange;", "stepsCount", "", "shiftPoint", "Landroidx/collection/FloatList;", "interpolation", "getStartKeylineSteps", "beforeContentPadding", "getStepInterpolationPoints", "totalShiftDistance", "steps", "isShiftingLeft", "", "moveKeylineAndCreateShiftedKeylineList", "srcIndex", "dstIndex", "move", "", "Landroidx/compose/material3/carousel/Keyline;", "ShiftPointRange", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<KeylineList> getStartKeylineSteps(KeylineList defaultKeylines, float carouselMainAxisSize, float itemSpacing, float beforeContentPadding) {
            List steps = new ArrayList();
            steps.add(defaultKeylines);
            if (defaultKeylines.isFirstFocalItemAtStartOfContainer()) {
                if (!(beforeContentPadding == 0.0f)) {
                    steps.add(createShiftedKeylineListForContentPadding(defaultKeylines, carouselMainAxisSize, itemSpacing, beforeContentPadding));
                }
                return steps;
            }
            int startIndex = defaultKeylines.getFirstNonAnchorIndex();
            int endIndex = defaultKeylines.getFirstFocalIndex();
            int numberOfSteps = endIndex - startIndex;
            if (numberOfSteps <= 0 && defaultKeylines.getFirstFocal().getCutoff() > 0.0f) {
                steps.add(moveKeylineAndCreateShiftedKeylineList(defaultKeylines, 0, 0, carouselMainAxisSize, itemSpacing));
                return steps;
            }
            for (int i = 0; i < numberOfSteps; i++) {
                KeylineList prevStep = (KeylineList) CollectionsKt.last(steps);
                int originalItemIndex = startIndex + i;
                int dstIndex = CollectionsKt.getLastIndex(defaultKeylines);
                if (originalItemIndex > 0) {
                    float originalNeighborBeforeSize = defaultKeylines.get(originalItemIndex - 1).getSize();
                    dstIndex = prevStep.firstIndexAfterFocalRangeWithSize(originalNeighborBeforeSize) - 1;
                }
                steps.add(moveKeylineAndCreateShiftedKeylineList(prevStep, defaultKeylines.getFirstNonAnchorIndex(), dstIndex, carouselMainAxisSize, itemSpacing));
            }
            if (!(beforeContentPadding == 0.0f)) {
                steps.set(CollectionsKt.getLastIndex(steps), createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last(steps), carouselMainAxisSize, itemSpacing, beforeContentPadding));
            }
            return steps;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<KeylineList> getEndKeylineSteps(KeylineList defaultKeylines, float carouselMainAxisSize, float itemSpacing, float afterContentPadding) {
            List steps = new ArrayList();
            steps.add(defaultKeylines);
            if (defaultKeylines.isLastFocalItemAtEndOfContainer(carouselMainAxisSize)) {
                if (!(afterContentPadding == 0.0f)) {
                    steps.add(createShiftedKeylineListForContentPadding(defaultKeylines, carouselMainAxisSize, itemSpacing, -afterContentPadding));
                }
                return steps;
            }
            int startIndex = defaultKeylines.getLastFocalIndex();
            int endIndex = defaultKeylines.getLastNonAnchorIndex();
            int numberOfSteps = endIndex - startIndex;
            if (numberOfSteps <= 0 && defaultKeylines.getLastFocal().getCutoff() > 0.0f) {
                steps.add(moveKeylineAndCreateShiftedKeylineList(defaultKeylines, 0, 0, carouselMainAxisSize, itemSpacing));
                return steps;
            }
            int i = 0;
            while (i < numberOfSteps) {
                KeylineList prevStep = (KeylineList) CollectionsKt.last(steps);
                int originalItemIndex = endIndex - i;
                int dstIndex = 0;
                if (originalItemIndex < CollectionsKt.getLastIndex(defaultKeylines)) {
                    float originalNeighborAfterSize = defaultKeylines.get(originalItemIndex + 1).getSize();
                    dstIndex = prevStep.lastIndexBeforeFocalRangeWithSize(originalNeighborAfterSize) + 1;
                }
                KeylineList keylines = moveKeylineAndCreateShiftedKeylineList(prevStep, defaultKeylines.getLastNonAnchorIndex(), dstIndex, carouselMainAxisSize, itemSpacing);
                steps.add(keylines);
                i++;
                numberOfSteps = numberOfSteps;
            }
            if (!(afterContentPadding == 0.0f)) {
                steps.set(CollectionsKt.getLastIndex(steps), createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last(steps), carouselMainAxisSize, itemSpacing, -afterContentPadding));
            }
            return steps;
        }

        private final KeylineList createShiftedKeylineListForContentPadding(final KeylineList from, float carouselMainAxisSize, float itemSpacing, float contentPadding) {
            KeylineList $this$fastFilter$iv = from;
            List target$iv = new ArrayList($this$fastFilter$iv.size());
            int size = $this$fastFilter$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Keyline keyline = $this$fastFilter$iv.get(index$iv$iv);
                Keyline it = keyline;
                if (!it.isAnchor()) {
                    target$iv.add(keyline);
                }
            }
            int numberOfNonAnchorKeylines = target$iv.size();
            final float sizeReduction = contentPadding / numberOfNonAnchorKeylines;
            List newKeylines = KeylineListKt.keylineListOf(carouselMainAxisSize, itemSpacing, from.getPivotIndex(), (from.getPivot().getOffset() + contentPadding) - (sizeReduction / 2.0f), new Function1<KeylineListScope, Unit>() { // from class: androidx.compose.material3.carousel.Strategy$Companion$createShiftedKeylineListForContentPadding$newKeylines$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeylineListScope keylineListScope) {
                    invoke2(keylineListScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeylineListScope $this$keylineListOf) {
                    List $this$fastForEach$iv = from;
                    float f = sizeReduction;
                    int size2 = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size2; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Keyline k = (Keyline) item$iv;
                        $this$keylineListOf.add(k.getSize() - Math.abs(f), k.isAnchor());
                    }
                }
            });
            List $this$fastMapIndexed$iv = newKeylines;
            ArrayList target$iv2 = new ArrayList($this$fastMapIndexed$iv.size());
            int index$iv$iv2 = 0;
            int size2 = $this$fastMapIndexed$iv.size();
            while (index$iv$iv2 < size2) {
                Object item$iv$iv = $this$fastMapIndexed$iv.get(index$iv$iv2);
                int index$iv = index$iv$iv2;
                Keyline k = (Keyline) item$iv$iv;
                target$iv2.add(Keyline.copy$default(k, 0.0f, 0.0f, from.get(index$iv).getUnadjustedOffset(), false, false, false, 0.0f, NotificationUtil.SERVICE_NOTIFICATION_ID, null));
                index$iv$iv2++;
                numberOfNonAnchorKeylines = numberOfNonAnchorKeylines;
                sizeReduction = sizeReduction;
            }
            return new KeylineList(target$iv2);
        }

        private final KeylineList moveKeylineAndCreateShiftedKeylineList(final KeylineList from, final int srcIndex, final int dstIndex, float carouselMainAxisSize, float itemSpacing) {
            int pivotDir = srcIndex > dstIndex ? 1 : -1;
            float pivotDelta = ((from.get(srcIndex).getSize() - from.get(srcIndex).getCutoff()) + itemSpacing) * pivotDir;
            int newPivotIndex = from.getPivotIndex() + pivotDir;
            float newPivotOffset = from.getPivot().getOffset() + pivotDelta;
            return KeylineListKt.keylineListOf(carouselMainAxisSize, itemSpacing, newPivotIndex, newPivotOffset, new Function1<KeylineListScope, Unit>() { // from class: androidx.compose.material3.carousel.Strategy$Companion$moveKeylineAndCreateShiftedKeylineList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeylineListScope keylineListScope) {
                    invoke2(keylineListScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeylineListScope $this$keylineListOf) {
                    List $this$fastForEach$iv = Strategy.INSTANCE.move(CollectionsKt.toMutableList((Collection) from), srcIndex, dstIndex);
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Keyline k = (Keyline) item$iv;
                        $this$keylineListOf.add(k.getSize(), k.isAnchor());
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FloatList getStepInterpolationPoints(float totalShiftDistance, List<KeylineList> steps, boolean isShiftingLeft) {
            float distanceShifted;
            MutableFloatList points = FloatListKt.mutableFloatListOf(0.0f);
            if (!(totalShiftDistance == 0.0f)) {
                Iterable $this$map$iv = RangesKt.until(1, steps.size());
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                Iterator<Integer> it = $this$map$iv.iterator();
                while (it.hasNext()) {
                    int item$iv$iv = ((IntIterator) it).nextInt();
                    KeylineList prevKeylines = steps.get(item$iv$iv - 1);
                    KeylineList currKeylines = steps.get(item$iv$iv);
                    if (isShiftingLeft) {
                        distanceShifted = ((Keyline) CollectionsKt.first((List) currKeylines)).getUnadjustedOffset() - ((Keyline) CollectionsKt.first((List) prevKeylines)).getUnadjustedOffset();
                    } else {
                        distanceShifted = ((Keyline) CollectionsKt.last((List) prevKeylines)).getUnadjustedOffset() - ((Keyline) CollectionsKt.last((List) currKeylines)).getUnadjustedOffset();
                    }
                    float stepPercentage = distanceShifted / totalShiftDistance;
                    float point = item$iv$iv == CollectionsKt.getLastIndex(steps) ? 1.0f : points.get(item$iv$iv - 1) + stepPercentage;
                    destination$iv$iv.add(Boolean.valueOf(points.add(point)));
                }
                return points;
            }
            return points;
        }

        /* JADX INFO: compiled from: Strategy.kt */
        @Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, m195d2 = {"Landroidx/compose/material3/carousel/Strategy$Companion$ShiftPointRange;", "", "fromStepIndex", "", "toStepIndex", "steppedInterpolation", "", "(IIF)V", "getFromStepIndex", "()I", "getSteppedInterpolation", "()F", "getToStepIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        private static final /* data */ class ShiftPointRange {
            private final int fromStepIndex;
            private final float steppedInterpolation;
            private final int toStepIndex;

            public static /* synthetic */ ShiftPointRange copy$default(ShiftPointRange shiftPointRange, int i, int i2, float f, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = shiftPointRange.fromStepIndex;
                }
                if ((i3 & 2) != 0) {
                    i2 = shiftPointRange.toStepIndex;
                }
                if ((i3 & 4) != 0) {
                    f = shiftPointRange.steppedInterpolation;
                }
                return shiftPointRange.copy(i, i2, f);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getFromStepIndex() {
                return this.fromStepIndex;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getToStepIndex() {
                return this.toStepIndex;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final float getSteppedInterpolation() {
                return this.steppedInterpolation;
            }

            public final ShiftPointRange copy(int fromStepIndex, int toStepIndex, float steppedInterpolation) {
                return new ShiftPointRange(fromStepIndex, toStepIndex, steppedInterpolation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShiftPointRange)) {
                    return false;
                }
                ShiftPointRange shiftPointRange = (ShiftPointRange) other;
                return this.fromStepIndex == shiftPointRange.fromStepIndex && this.toStepIndex == shiftPointRange.toStepIndex && Float.compare(this.steppedInterpolation, shiftPointRange.steppedInterpolation) == 0;
            }

            public int hashCode() {
                return (((this.fromStepIndex * 31) + this.toStepIndex) * 31) + Float.floatToIntBits(this.steppedInterpolation);
            }

            public String toString() {
                return "ShiftPointRange(fromStepIndex=" + this.fromStepIndex + ", toStepIndex=" + this.toStepIndex + ", steppedInterpolation=" + this.steppedInterpolation + ')';
            }

            public ShiftPointRange(int fromStepIndex, int toStepIndex, float steppedInterpolation) {
                this.fromStepIndex = fromStepIndex;
                this.toStepIndex = toStepIndex;
                this.steppedInterpolation = steppedInterpolation;
            }

            public final int getFromStepIndex() {
                return this.fromStepIndex;
            }

            public final int getToStepIndex() {
                return this.toStepIndex;
            }

            public final float getSteppedInterpolation() {
                return this.steppedInterpolation;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ShiftPointRange getShiftPointRange(int stepsCount, FloatList shiftPoint, float interpolation) {
            float lowerBounds = shiftPoint.get(0);
            Iterable $this$forEach$iv = RangesKt.until(1, stepsCount);
            Iterator<Integer> it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                int element$iv = ((IntIterator) it).nextInt();
                float upperBounds = shiftPoint.get(element$iv);
                if (interpolation <= upperBounds) {
                    return new ShiftPointRange(element$iv - 1, element$iv, StrategyKt.lerp(0.0f, 1.0f, lowerBounds, upperBounds, interpolation));
                }
                lowerBounds = upperBounds;
            }
            return new ShiftPointRange(0, 0, 0.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Keyline> move(List<Keyline> list, int srcIndex, int dstIndex) {
            Keyline keyline = list.get(srcIndex);
            list.remove(srcIndex);
            list.add(dstIndex, keyline);
            return list;
        }
    }
}
