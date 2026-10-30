package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ScatterSetWrapper.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a1\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\nH\u0000¨\u0006\u000b"}, m195d2 = {"fastAny", "", "", "", "block", "Lkotlin/Function1;", "fastForEach", "", ExifInterface.GPS_DIRECTION_TRUE, "wrapIntoSet", "Landroidx/collection/ScatterSet;", "runtime_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScatterSetWrapperKt {
    public static final <T> Set<T> wrapIntoSet(ScatterSet<T> scatterSet) {
        return new ScatterSetWrapper(scatterSet);
    }

    public static final <T> void fastForEach(Set<? extends T> set, Function1<? super T, Unit> function1) {
        int $i$f$fastForEach = 0;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet<T> set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
            Object[] k$iv = set$runtime_release.elements;
            long[] m$iv$iv = set$runtime_release.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 > lastIndex$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                int $i$f$fastForEach2 = $i$f$fastForEach;
                ScatterSet<T> scatterSet = set$runtime_release;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i = 8;
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            function1.invoke(k$iv[index$iv$iv]);
                        }
                        i = 8;
                        slot$iv$iv >>= 8;
                    }
                    if (bitCount$iv$iv != i) {
                        return;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    return;
                }
                i$iv$iv++;
                $i$f$fastForEach = $i$f$fastForEach2;
                set$runtime_release = scatterSet;
            }
        } else {
            Set<? extends T> $this$forEach$iv = set;
            for (Object element$iv : $this$forEach$iv) {
                function1.invoke(element$iv);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0082 A[LOOP:0: B:6:0x0022->B:22:0x0082, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x008e A[SYNTHETIC] */
    public static final boolean fastAny(Set<? extends Object> set, Function1<Object, Boolean> function1) {
        int $i$f$fastAny = 0;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet this_$iv = ((ScatterSetWrapper) set).getSet$runtime_release();
            Object[] k$iv$iv = this_$iv.elements;
            long[] m$iv$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
            int i$iv$iv$iv = 0;
            if (0 <= lastIndex$iv$iv$iv) {
                while (true) {
                    long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                    int $i$f$fastAny2 = $i$f$fastAny;
                    ScatterSet this_$iv2 = this_$iv;
                    if ((((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                            i$iv$iv$iv++;
                            $i$f$fastAny = $i$f$fastAny2;
                            this_$iv = this_$iv2;
                        }
                    } else {
                        int i = 8;
                        int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                        for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                            long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                            int $i$f$isFull = value$iv$iv$iv$iv < 128 ? 1 : 0;
                            if ($i$f$isFull != 0) {
                                int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                                Object element$iv = k$iv$iv[index$iv$iv$iv];
                                if (function1.invoke(element$iv).booleanValue()) {
                                    return true;
                                }
                            }
                            i = 8;
                            slot$iv$iv$iv >>= 8;
                        }
                        if (bitCount$iv$iv$iv == i) {
                            if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                                i$iv$iv$iv++;
                                $i$f$fastAny = $i$f$fastAny2;
                                this_$iv = this_$iv2;
                            }
                        }
                    }
                }
            }
            return false;
        }
        Set<? extends Object> $this$any$iv = set;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv2 : $this$any$iv) {
            if (function1.invoke(element$iv2).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
