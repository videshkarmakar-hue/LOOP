package androidx.compose.animation.core;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u000e\u000fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J,\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0001\u0010\n*\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\rH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m195d2 = {"Landroidx/compose/animation/core/KeyframesSpec;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedKeyframesSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframeEntity", "KeyframesSpecConfig", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {
    public static final int $stable = 0;
    private final KeyframesSpecConfig<T> config;

    public KeyframesSpec(KeyframesSpecConfig<T> keyframesSpecConfig) {
        this.config = keyframesSpecConfig;
    }

    public final KeyframesSpecConfig<T> getConfig() {
        return this.config;
    }

    /* JADX INFO: compiled from: AnimationSpec.kt */
    @Metadata(m194d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0006\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0096\u0004¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0004¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\u0004J\u001b\u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0087\u0004¨\u0006\u0018"}, m195d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "()V", "createEntityFor", DownloadUtil.CookieScheme.VALUE, "createEntityFor$animation_core_release", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "at", "timeStamp", "", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "using", "arcMode", "Landroidx/compose/animation/core/ArcMode;", JsonPOJOBuilder.DEFAULT_WITH_PREFIX, "", "easing", "Landroidx/compose/animation/core/Easing;", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class KeyframesSpecConfig<T> extends KeyframesSpecBaseConfig<T, KeyframeEntity<T>> {
        public static final int $stable = 0;

        public KeyframesSpecConfig() {
            super(null);
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public KeyframeEntity<T> createEntityFor$animation_core_release(T value) {
            return new KeyframeEntity<>(value, null, null, 6, null);
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        /* JADX INFO: renamed from: at */
        public KeyframeEntity<T> mo11at(T t, int timeStamp) {
            KeyframeEntity<T> keyframeEntity = new KeyframeEntity<>(t, null, null, 6, null);
            getKeyframes$animation_core_release().set(timeStamp, keyframeEntity);
            return keyframeEntity;
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public KeyframeEntity<T> atFraction(T t, float fraction) {
            float $this$fastRoundToInt$iv = getDurationMillis() * fraction;
            return mo11at((Object) t, Math.round($this$fastRoundToInt$iv));
        }

        @Deprecated(message = "Use version that returns an instance of the entity so it can be re-used in other keyframe builders.", replaceWith = @ReplaceWith(expression = "this using easing", imports = {}))
        public final void with(KeyframeEntity<T> keyframeEntity, Easing easing) {
            keyframeEntity.setEasing$animation_core_release(easing);
        }

        public final KeyframeEntity<T> using(KeyframeEntity<T> keyframeEntity, ArcMode arcMode) {
            keyframeEntity.setArcMode$animation_core_release(arcMode);
            return keyframeEntity;
        }
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedKeyframesSpec<V> vectorize(TwoWayConverter<T, V> converter) {
        IntObjectMap this_$iv;
        int $i$f$forEach;
        int[] k$iv;
        Object[] v$iv;
        MutableIntList timestamps = new MutableIntList(this.config.getKeyframes$animation_core_release().get_size() + 2);
        MutableIntObjectMap timeToInfoMap = new MutableIntObjectMap(this.config.getKeyframes$animation_core_release().get_size());
        IntObjectMap this_$iv2 = this.config.getKeyframes$animation_core_release();
        int $i$f$forEach2 = 0;
        int[] k$iv2 = this_$iv2.keys;
        Object[] v$iv2 = this_$iv2.values;
        long[] m$iv$iv = this_$iv2.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                long slot$iv$iv2 = slot$iv$iv;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    this_$iv = this_$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    k$iv = k$iv2;
                    v$iv = v$iv2;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv2 & 255;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            int key = k$iv2[index$iv$iv];
                            KeyframeEntity value = (KeyframeEntity) v$iv2[index$iv$iv];
                            timestamps.add(key);
                            timeToInfoMap.set(key, new VectorizedKeyframeSpecElementInfo(converter.getConvertToVector().invoke(value.getValue$animation_core_release()), value.getEasing(), value.getArcMode()));
                        }
                        slot$iv$iv2 >>= 8;
                        j$iv$iv++;
                        this_$iv2 = this_$iv2;
                        $i$f$forEach2 = $i$f$forEach2;
                        k$iv2 = k$iv2;
                        v$iv2 = v$iv2;
                    }
                    this_$iv = this_$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    k$iv = k$iv2;
                    v$iv = v$iv2;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv2 = this_$iv;
                $i$f$forEach2 = $i$f$forEach;
                k$iv2 = k$iv;
                v$iv2 = v$iv;
            }
        }
        if (!this.config.getKeyframes$animation_core_release().contains(0)) {
            timestamps.add(0, 0);
        }
        if (!this.config.getKeyframes$animation_core_release().contains(this.config.getDurationMillis())) {
            timestamps.add(this.config.getDurationMillis());
        }
        timestamps.sort();
        return new VectorizedKeyframesSpec<>(timestamps, timeToInfoMap, this.config.getDurationMillis(), this.config.getDelayMillis(), EasingKt.getLinearEasing(), ArcMode.Companion.ArcLinear.INSTANCE);
    }

    /* JADX INFO: compiled from: AnimationSpec.kt */
    @Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, m195d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/KeyframeBaseEntity;", DownloadUtil.CookieScheme.VALUE, "easing", "Landroidx/compose/animation/core/Easing;", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;Landroidx/compose/animation/core/ArcMode;)V", "getArcMode$animation_core_release", "()Landroidx/compose/animation/core/ArcMode;", "setArcMode$animation_core_release", "(Landroidx/compose/animation/core/ArcMode;)V", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class KeyframeEntity<T> extends KeyframeBaseEntity<T> {
        public static final int $stable = 8;
        private ArcMode arcMode;

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, ArcMode.Companion.ArcLinear arcLinear, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? EasingKt.getLinearEasing() : easing, (i & 4) != 0 ? ArcMode.Companion.ArcLinear.INSTANCE : arcLinear);
        }

        /* JADX INFO: renamed from: getArcMode$animation_core_release, reason: from getter */
        public final ArcMode getArcMode() {
            return this.arcMode;
        }

        public final void setArcMode$animation_core_release(ArcMode arcMode) {
            this.arcMode = arcMode;
        }

        public KeyframeEntity(T t, Easing easing, ArcMode arcMode) {
            super(t, easing, null);
            this.arcMode = arcMode;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            return (other instanceof KeyframeEntity) && Intrinsics.areEqual(((KeyframeEntity) other).getValue$animation_core_release(), getValue$animation_core_release()) && Intrinsics.areEqual(((KeyframeEntity) other).getEasing(), getEasing()) && Intrinsics.areEqual(((KeyframeEntity) other).arcMode, this.arcMode);
        }

        public int hashCode() {
            T value$animation_core_release = getValue$animation_core_release();
            int result = value$animation_core_release != null ? value$animation_core_release.hashCode() : 0;
            return (((result * 31) + this.arcMode.hashCode()) * 31) + getEasing().hashCode();
        }
    }
}
