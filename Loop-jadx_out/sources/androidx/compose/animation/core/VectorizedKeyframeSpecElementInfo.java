package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, m195d2 = {"Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "", "vectorValue", "easing", "Landroidx/compose/animation/core/Easing;", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/Easing;Landroidx/compose/animation/core/ArcMode;)V", "getArcMode", "()Landroidx/compose/animation/core/ArcMode;", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getVectorValue", "()Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/AnimationVector;", "component1", "component2", "component3", "copy", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/Easing;Landroidx/compose/animation/core/ArcMode;)Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "equals", "", "other", "hashCode", "", "toString", "", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class VectorizedKeyframeSpecElementInfo<V extends AnimationVector> {
    public static final int $stable = 0;
    private final ArcMode arcMode;
    private final Easing easing;
    private final V vectorValue;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VectorizedKeyframeSpecElementInfo copy$default(VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo, AnimationVector animationVector, Easing easing, ArcMode arcMode, int i, Object obj) {
        if ((i & 1) != 0) {
            animationVector = vectorizedKeyframeSpecElementInfo.vectorValue;
        }
        if ((i & 2) != 0) {
            easing = vectorizedKeyframeSpecElementInfo.easing;
        }
        if ((i & 4) != 0) {
            arcMode = vectorizedKeyframeSpecElementInfo.arcMode;
        }
        return vectorizedKeyframeSpecElementInfo.copy(animationVector, easing, arcMode);
    }

    public final V component1() {
        return this.vectorValue;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Easing getEasing() {
        return this.easing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ArcMode getArcMode() {
        return this.arcMode;
    }

    public final VectorizedKeyframeSpecElementInfo<V> copy(V vectorValue, Easing easing, ArcMode arcMode) {
        return new VectorizedKeyframeSpecElementInfo<>(vectorValue, easing, arcMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VectorizedKeyframeSpecElementInfo)) {
            return false;
        }
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) other;
        return Intrinsics.areEqual(this.vectorValue, vectorizedKeyframeSpecElementInfo.vectorValue) && Intrinsics.areEqual(this.easing, vectorizedKeyframeSpecElementInfo.easing) && Intrinsics.areEqual(this.arcMode, vectorizedKeyframeSpecElementInfo.arcMode);
    }

    public int hashCode() {
        return (((this.vectorValue.hashCode() * 31) + this.easing.hashCode()) * 31) + this.arcMode.hashCode();
    }

    public String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.vectorValue + ", easing=" + this.easing + ", arcMode=" + this.arcMode + ')';
    }

    public VectorizedKeyframeSpecElementInfo(V v, Easing easing, ArcMode arcMode) {
        this.vectorValue = v;
        this.easing = easing;
        this.arcMode = arcMode;
    }

    public final V getVectorValue() {
        return this.vectorValue;
    }

    public final Easing getEasing() {
        return this.easing;
    }

    public final ArcMode getArcMode() {
        return this.arcMode;
    }
}
