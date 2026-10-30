package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B9\b\u0016\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bBC\b\u0000\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0006H\u0002J \u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0002J-\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J-\u00108\u001a\u00028\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J%\u00109\u001a\u00020:2\u0006\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010;R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010#\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001aR\u001e\u0010$\u001a\u00020\u0006*\u00020\u00128BX\u0082\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006<"}, m195d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "timestamps", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "defaultEasing", "initialArcMode", "Landroidx/compose/animation/core/ArcMode;", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;Landroidx/compose/animation/core/ArcMode;)V", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "getDelayMillis", "()I", "getDurationMillis", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "modes", "", "posArray", "", "slopeArray", "times", "valueVector", "velocityVector", DownloadUtil.CookieScheme.VALUE, "getValue$annotations", "(Landroidx/compose/animation/core/ArcMode;)V", "getValue", "(Landroidx/compose/animation/core/ArcMode;)I", "findEntryForTimeMillis", "timeMillis", "getEasedTime", "", "getEasedTimeFromIndex", "index", "asFraction", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final ArcMode initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    private static /* synthetic */ void getValue$annotations(ArcMode arcMode) {
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedDurationBasedAnimationSpec.CC.$default$getDurationNanos(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedKeyframesSpec(IntList timestamps, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> intObjectMap, int durationMillis, int delayMillis, Easing defaultEasing, ArcMode initialArcMode) {
        this.timestamps = timestamps;
        this.keyframes = intObjectMap;
        this.durationMillis = durationMillis;
        this.delayMillis = delayMillis;
        this.defaultEasing = defaultEasing;
        this.initialArcMode = initialArcMode;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }

    public VectorizedKeyframesSpec(Map<Integer, ? extends Pair<? extends V, ? extends Easing>> map, int durationMillis, int delayMillis) {
        MutableIntList times = new MutableIntList(map.size() + 2);
        Iterator<Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            int t = it.next().getKey().intValue();
            times.add(t);
        }
        if (!map.containsKey(0)) {
            times.add(0, 0);
        }
        if (!map.containsKey(Integer.valueOf(durationMillis))) {
            times.add(durationMillis);
        }
        times.sort();
        MutableIntList mutableIntList = times;
        MutableIntObjectMap timeToInfoMap = new MutableIntObjectMap(0, 1, null);
        for (Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>> entry : map.entrySet()) {
            int time = entry.getKey().intValue();
            Pair<? extends V, ? extends Easing> value = entry.getValue();
            timeToInfoMap.set(time, new VectorizedKeyframeSpecElementInfo(value.getFirst(), value.getSecond(), ArcMode.Companion.ArcLinear.INSTANCE));
        }
        this(mutableIntList, timeToInfoMap, durationMillis, delayMillis, EasingKt.getLinearEasing(), ArcMode.Companion.ArcLinear.INSTANCE);
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        float[] fArr;
        ArcMode arcMode;
        boolean z = this.arcSpline != null;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialVelocity);
            int size = this.timestamps.getSize();
            float[] fArr2 = new float[size];
            for (int i = 0; i < size; i++) {
                fArr2[i] = this.timestamps.get(i) / 1000;
            }
            this.times = fArr2;
            int size2 = this.timestamps.getSize();
            int[] iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(this.timestamps.get(i2));
                if (vectorizedKeyframeSpecElementInfo == null || (arcMode = vectorizedKeyframeSpecElementInfo.getArcMode()) == null) {
                    arcMode = this.initialArcMode;
                }
                if (!Intrinsics.areEqual(arcMode, ArcMode.Companion.ArcLinear.INSTANCE)) {
                    z = true;
                }
                iArr[i2] = getValue(arcMode);
            }
            this.modes = iArr;
        }
        if (!z) {
            return;
        }
        float[] fArr3 = null;
        if (this.arcSpline != null) {
            V v = this.lastInitialValue;
            if (v == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                v = null;
            }
            if (Intrinsics.areEqual(v, initialValue)) {
                V v2 = this.lastTargetValue;
                if (v2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                    v2 = null;
                }
                if (Intrinsics.areEqual(v2, targetValue)) {
                    return;
                }
            }
        }
        this.lastInitialValue = initialValue;
        this.lastTargetValue = targetValue;
        int size3 = (initialValue.getSize() % 2) + initialValue.getSize();
        this.posArray = new float[size3];
        this.slopeArray = new float[size3];
        int size4 = this.timestamps.getSize();
        float[][] fArr4 = new float[size4][];
        for (int i3 = 0; i3 < size4; i3++) {
            int i4 = this.timestamps.get(i3);
            if (i4 == 0) {
                if (!this.keyframes.contains(i4)) {
                    fArr = new float[size3];
                    for (int i5 = 0; i5 < size3; i5++) {
                        fArr[i5] = initialValue.get$animation_core_release(i5);
                    }
                } else {
                    fArr = new float[size3];
                    VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i4);
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                    AnimationVector vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
                    for (int i6 = 0; i6 < size3; i6++) {
                        fArr[i6] = vectorValue.get$animation_core_release(i6);
                    }
                }
            } else if (i4 == getDurationMillis()) {
                if (!this.keyframes.contains(i4)) {
                    fArr = new float[size3];
                    for (int i7 = 0; i7 < size3; i7++) {
                        fArr[i7] = targetValue.get$animation_core_release(i7);
                    }
                } else {
                    fArr = new float[size3];
                    VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i4);
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
                    AnimationVector vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
                    for (int i8 = 0; i8 < size3; i8++) {
                        fArr[i8] = vectorValue2.get$animation_core_release(i8);
                    }
                }
            } else {
                fArr = new float[size3];
                VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo4 = this.keyframes.get(i4);
                Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo4);
                AnimationVector vectorValue3 = vectorizedKeyframeSpecElementInfo4.getVectorValue();
                for (int i9 = 0; i9 < size3; i9++) {
                    fArr[i9] = vectorValue3.get$animation_core_release(i9);
                }
            }
            fArr4[i3] = fArr;
        }
        int[] iArr2 = this.modes;
        if (iArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modes");
            iArr2 = null;
        }
        float[] fArr5 = this.times;
        if (fArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("times");
        } else {
            fArr3 = fArr5;
        }
        this.arcSpline = new ArcSpline(iArr2, fArr3, fArr4);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        AnimationVector vectorValue;
        AnimationVector vectorValue2;
        long j = playTimeNanos / AnimationKt.MillisToNanos;
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j);
        if (this.keyframes.contains(iClampPlayTime)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(iClampPlayTime);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo);
            return (V) vectorizedKeyframeSpecElementInfo.getVectorValue();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (iClampPlayTime <= 0) {
            return initialValue;
        }
        init(initialValue, targetValue, initialVelocity);
        if (this.arcSpline != null) {
            float easedTime = getEasedTime(iClampPlayTime);
            ArcSpline arcSpline = this.arcSpline;
            if (arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = null;
            }
            float[] fArr = this.posArray;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr = null;
            }
            arcSpline.getPos(easedTime, fArr);
            float[] fArr2 = this.posArray;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("posArray");
                fArr2 = null;
            }
            int length = fArr2.length;
            for (int i = 0; i < length; i++) {
                V v = this.valueVector;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                    v = null;
                }
                float[] fArr3 = this.posArray;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("posArray");
                    fArr3 = null;
                }
                v.set$animation_core_release(i, fArr3[i]);
            }
            V v2 = this.valueVector;
            if (v2 != null) {
                return v2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        int iFindEntryForTimeMillis = findEntryForTimeMillis(iClampPlayTime);
        float easedTimeFromIndex = getEasedTimeFromIndex(iFindEntryForTimeMillis, iClampPlayTime, true);
        int i2 = this.timestamps.get(iFindEntryForTimeMillis);
        if (this.keyframes.contains(i2)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo2 = this.keyframes.get(i2);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
            vectorValue = vectorizedKeyframeSpecElementInfo2.getVectorValue();
        } else {
            vectorValue = initialValue;
        }
        int i3 = this.timestamps.get(iFindEntryForTimeMillis + 1);
        if (this.keyframes.contains(i3)) {
            VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo3 = this.keyframes.get(i3);
            Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo3);
            vectorValue2 = vectorizedKeyframeSpecElementInfo3.getVectorValue();
        } else {
            vectorValue2 = targetValue;
        }
        int i4 = 0;
        V v3 = this.valueVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v3 = null;
        }
        int size = v3.getSize();
        while (i4 < size) {
            V v4 = this.valueVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v4 = null;
            }
            v4.set$animation_core_release(i4, VectorConvertersKt.lerp(vectorValue.get$animation_core_release(i4), vectorValue2.get$animation_core_release(i4), easedTimeFromIndex));
            i4++;
            j = j;
        }
        V v5 = this.valueVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        long playTimeMillis = playTimeNanos / AnimationKt.MillisToNanos;
        long clampedPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, playTimeMillis);
        if (clampedPlayTime < 0) {
            return initialVelocity;
        }
        init(initialValue, targetValue, initialVelocity);
        if (this.arcSpline != null) {
            float easedTime = getEasedTime((int) clampedPlayTime);
            ArcSpline arcSpline = this.arcSpline;
            if (arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = null;
            }
            float[] fArr = this.slopeArray;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr = null;
            }
            arcSpline.getSlope(easedTime, fArr);
            float[] fArr2 = this.slopeArray;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                fArr2 = null;
            }
            int length = fArr2.length;
            for (int i = 0; i < length; i++) {
                V v = this.velocityVector;
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                    v = null;
                }
                float[] fArr3 = this.slopeArray;
                if (fArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("slopeArray");
                    fArr3 = null;
                }
                v.set$animation_core_release(i, fArr3[i]);
            }
            V v2 = this.velocityVector;
            if (v2 != null) {
                return v2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        AnimationVector startNum = VectorizedAnimationSpecKt.getValueFromMillis(this, clampedPlayTime - 1, initialValue, targetValue, initialVelocity);
        AnimationVector endNum = VectorizedAnimationSpecKt.getValueFromMillis(this, clampedPlayTime, initialValue, targetValue, initialVelocity);
        int i2 = 0;
        int size = startNum.getSize();
        while (i2 < size) {
            V v3 = this.velocityVector;
            if (v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v3 = null;
            }
            AnimationVector startNum2 = startNum;
            v3.set$animation_core_release(i2, (startNum2.get$animation_core_release(i2) - endNum.get$animation_core_release(i2)) * 1000.0f);
            i2++;
            startNum = startNum2;
        }
        V v4 = this.velocityVector;
        if (v4 != null) {
            return v4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    private final float getEasedTime(int timeMillis) {
        int index = findEntryForTimeMillis(timeMillis);
        return getEasedTimeFromIndex(index, timeMillis, false);
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis, boolean asFraction) {
        Easing easing;
        IntList this_$iv = this.timestamps;
        if (index >= this_$iv._size - 1) {
            return timeMillis / 1000;
        }
        int timeMin = this.timestamps.get(index);
        int timeMax = this.timestamps.get(index + 1);
        if (timeMillis == timeMin) {
            return timeMin / 1000;
        }
        int timeRange = timeMax - timeMin;
        VectorizedKeyframeSpecElementInfo<V> vectorizedKeyframeSpecElementInfo = this.keyframes.get(timeMin);
        if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.getEasing()) == null) {
            easing = this.defaultEasing;
        }
        float rawFraction = (timeMillis - timeMin) / timeRange;
        float easedFraction = easing.transform(rawFraction);
        if (!asFraction) {
            return ((timeRange * easedFraction) + timeMin) / 1000;
        }
        return easedFraction;
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int index = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, null);
        return index < -1 ? -(index + 2) : index;
    }

    private final int getValue(ArcMode $this$value) {
        if (Intrinsics.areEqual($this$value, ArcMode.Companion.ArcAbove.INSTANCE)) {
            return 5;
        }
        if (Intrinsics.areEqual($this$value, ArcMode.Companion.ArcBelow.INSTANCE)) {
            return 4;
        }
        Intrinsics.areEqual($this$value, ArcMode.Companion.ArcLinear.INSTANCE);
        return 0;
    }
}
