package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: SnapshotIdSet.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J:\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002'\u0010\u0011\u001a#\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0012H\u0086\bJ\u001d\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m195d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long upperSet, long lowerSet, int lowerBound, int[] belowBound) {
        this.upperSet = upperSet;
        this.lowerSet = lowerSet;
        this.lowerBound = lowerBound;
        this.belowBound = belowBound;
    }

    public final boolean get(int bit) {
        int[] it;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            return ((1 << offset) & this.lowerSet) != 0;
        }
        if (offset >= 64 && offset < 128) {
            return ((1 << (offset + (-64))) & this.upperSet) != 0;
        }
        if (offset <= 0 && (it = this.belowBound) != null) {
            return SnapshotIdSetKt.binarySearch(it, bit) >= 0;
        }
        return false;
    }

    public final SnapshotIdSet set(int bit) {
        int[] intArray;
        int offset;
        long j;
        int offset2 = bit - this.lowerBound;
        long j2 = 1;
        long j3 = 0;
        if (offset2 >= 0 && offset2 < 64) {
            long mask = 1 << offset2;
            if ((this.lowerSet & mask) == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet | mask, this.lowerBound, this.belowBound);
            }
        } else if (offset2 >= 64 && offset2 < 128) {
            long mask2 = 1 << (offset2 - 64);
            if ((this.upperSet & mask2) == 0) {
                return new SnapshotIdSet(this.upperSet | mask2, this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset2 < 128) {
            int[] array = this.belowBound;
            if (array == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new int[]{bit});
            }
            int location = SnapshotIdSetKt.binarySearch(array, bit);
            if (location < 0) {
                int insertLocation = -(location + 1);
                int newSize = array.length + 1;
                int[] newBelowBound = new int[newSize];
                ArraysKt.copyInto(array, newBelowBound, 0, 0, insertLocation);
                ArraysKt.copyInto(array, newBelowBound, insertLocation + 1, insertLocation, newSize - 1);
                newBelowBound[insertLocation] = bit;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
            }
        } else if (!get(bit)) {
            long newUpperSet = this.upperSet;
            long newLowerSet = this.lowerSet;
            int newLowerBound = this.lowerBound;
            List list = null;
            int targetLowerBound = ((bit + 1) / 64) * 64;
            while (newLowerBound < targetLowerBound) {
                if (newLowerSet == j3) {
                    offset = offset2;
                    j = j2;
                } else {
                    if (list != null) {
                        offset = offset2;
                    } else {
                        List $this$set_u24lambda_u243 = new ArrayList();
                        int[] it = this.belowBound;
                        if (it == null) {
                            offset = offset2;
                        } else {
                            int length = it.length;
                            int i = 0;
                            while (i < length) {
                                int element$iv = it[i];
                                $this$set_u24lambda_u243.add(Integer.valueOf(element$iv));
                                i++;
                                offset2 = offset2;
                            }
                            offset = offset2;
                        }
                        list = $this$set_u24lambda_u243;
                    }
                    for (int offset3 = 0; offset3 < 64; offset3++) {
                        int bitOffset = offset3;
                        if ((newLowerSet & (1 << bitOffset)) != 0) {
                            list.add(Integer.valueOf(bitOffset + newLowerBound));
                        }
                    }
                    j = 1;
                }
                if (newUpperSet == 0) {
                    newLowerBound = targetLowerBound;
                    newLowerSet = 0;
                    break;
                }
                newLowerSet = newUpperSet;
                newUpperSet = 0;
                newLowerBound += 64;
                offset2 = offset;
                j3 = 0;
                j2 = j;
            }
            if (list == null || (intArray = CollectionsKt.toIntArray(list)) == null) {
                intArray = this.belowBound;
            }
            return new SnapshotIdSet(newUpperSet, newLowerSet, newLowerBound, intArray).set(bit);
        }
        return this;
    }

    public final SnapshotIdSet clear(int bit) {
        int[] array;
        int location;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            if ((this.lowerSet & mask) != 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet & (~mask), this.lowerBound, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            if ((this.upperSet & mask2) != 0) {
                return new SnapshotIdSet(this.upperSet & (~mask2), this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset < 0 && (array = this.belowBound) != null && (location = SnapshotIdSetKt.binarySearch(array, bit)) >= 0) {
            int newSize = array.length - 1;
            if (newSize == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] newBelowBound = new int[newSize];
            if (location > 0) {
                ArraysKt.copyInto(array, newBelowBound, 0, 0, location);
            }
            if (location < newSize) {
                ArraysKt.copyInto(array, newBelowBound, location, location + 1, newSize + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return EMPTY;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            SnapshotIdSet this_$iv = new SnapshotIdSet((~bits.upperSet) & this.upperSet, (~bits.lowerSet) & this.lowerSet, this.lowerBound, this.belowBound);
            return this_$iv;
        }
        Object accumulator$iv = this;
        int[] belowBound$iv$iv = bits.belowBound;
        if (belowBound$iv$iv != null) {
            for (int element$iv$iv : belowBound$iv$iv) {
                SnapshotIdSet previous = (SnapshotIdSet) accumulator$iv;
                accumulator$iv = previous.clear(element$iv$iv);
            }
        }
        long j = 1;
        if (bits.lowerSet != 0) {
            int index$iv$iv = 0;
            while (index$iv$iv < 64) {
                if ((bits.lowerSet & (j << index$iv$iv)) != 0) {
                    int element$iv = bits.lowerBound + index$iv$iv;
                    SnapshotIdSet previous2 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous2.clear(element$iv);
                }
                index$iv$iv++;
                j = 1;
            }
        }
        if (bits.upperSet != 0) {
            int index$iv$iv2 = 0;
            for (int i = 64; index$iv$iv2 < i; i = 64) {
                if ((bits.upperSet & (1 << index$iv$iv2)) != 0) {
                    int element$iv2 = index$iv$iv2 + 64 + bits.lowerBound;
                    SnapshotIdSet previous3 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous3.clear(element$iv2);
                }
                index$iv$iv2++;
            }
        }
        Object this_$iv$iv = accumulator$iv;
        SnapshotIdSet this_$iv2 = (SnapshotIdSet) this_$iv$iv;
        return this_$iv2;
    }

    public final SnapshotIdSet and(SnapshotIdSet bits) {
        if (!Intrinsics.areEqual(bits, EMPTY) && !Intrinsics.areEqual(this, EMPTY)) {
            if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
                long newUpper = this.upperSet & bits.upperSet;
                long newLower = this.lowerSet & bits.lowerSet;
                return (newUpper == 0 && newLower == 0 && this.belowBound == null) ? EMPTY : new SnapshotIdSet(this.upperSet & bits.upperSet, this.lowerSet & bits.lowerSet, this.lowerBound, this.belowBound);
            }
            int i = 0;
            if (this.belowBound == null) {
                SnapshotIdSet initial$iv = EMPTY;
                SnapshotIdSet snapshotIdSet = initial$iv;
                int[] belowBound$iv$iv = this.belowBound;
                if (belowBound$iv$iv != null) {
                    int length = belowBound$iv$iv.length;
                    while (i < length) {
                        int element$iv$iv = belowBound$iv$iv[i];
                        SnapshotIdSet previous = snapshotIdSet;
                        if (bits.get(element$iv$iv)) {
                            previous = previous.set(element$iv$iv);
                        }
                        snapshotIdSet = previous;
                        i++;
                    }
                }
                if (this.lowerSet != 0) {
                    int index$iv$iv = 0;
                    for (int i2 = 64; index$iv$iv < i2; i2 = 64) {
                        if ((this.lowerSet & (1 << index$iv$iv)) != 0) {
                            int element$iv = this.lowerBound + index$iv$iv;
                            SnapshotIdSet previous2 = snapshotIdSet;
                            if (bits.get(element$iv)) {
                                previous2 = previous2.set(element$iv);
                            }
                            snapshotIdSet = previous2;
                        }
                        index$iv$iv++;
                    }
                }
                if (this.upperSet == 0) {
                    return snapshotIdSet;
                }
                for (int index$iv$iv2 = 0; index$iv$iv2 < 64; index$iv$iv2++) {
                    if ((this.upperSet & (1 << index$iv$iv2)) != 0) {
                        int element$iv2 = index$iv$iv2 + 64 + this.lowerBound;
                        SnapshotIdSet previous3 = snapshotIdSet;
                        if (bits.get(element$iv2)) {
                            previous3 = previous3.set(element$iv2);
                        }
                        snapshotIdSet = previous3;
                    }
                }
                return snapshotIdSet;
            }
            SnapshotIdSet initial$iv2 = EMPTY;
            SnapshotIdSet snapshotIdSet2 = initial$iv2;
            int[] belowBound$iv$iv2 = bits.belowBound;
            if (belowBound$iv$iv2 != null) {
                int length2 = belowBound$iv$iv2.length;
                while (i < length2) {
                    int element$iv$iv2 = belowBound$iv$iv2[i];
                    SnapshotIdSet previous4 = snapshotIdSet2;
                    if (get(element$iv$iv2)) {
                        previous4 = previous4.set(element$iv$iv2);
                    }
                    snapshotIdSet2 = previous4;
                    i++;
                }
            }
            long j = 0;
            if (bits.lowerSet != 0) {
                int index$iv$iv3 = 0;
                while (index$iv$iv3 < 64) {
                    if ((bits.lowerSet & (1 << index$iv$iv3)) != j) {
                        int element$iv3 = bits.lowerBound + index$iv$iv3;
                        SnapshotIdSet previous5 = snapshotIdSet2;
                        if (get(element$iv3)) {
                            previous5 = previous5.set(element$iv3);
                        }
                        snapshotIdSet2 = previous5;
                    }
                    index$iv$iv3++;
                    j = 0;
                }
            }
            if (bits.upperSet == 0) {
                return snapshotIdSet2;
            }
            for (int index$iv$iv4 = 0; index$iv$iv4 < 64; index$iv$iv4++) {
                if ((bits.upperSet & (1 << index$iv$iv4)) != 0) {
                    int element$iv4 = index$iv$iv4 + 64 + bits.lowerBound;
                    SnapshotIdSet previous6 = snapshotIdSet2;
                    if (get(element$iv4)) {
                        previous6 = previous6.set(element$iv4);
                    }
                    snapshotIdSet2 = previous6;
                }
            }
            return snapshotIdSet2;
        }
        return EMPTY;
    }

    /* JADX INFO: renamed from: or */
    public final SnapshotIdSet m27or(SnapshotIdSet bits) {
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return bits;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            return new SnapshotIdSet(bits.upperSet | this.upperSet, bits.lowerSet | this.lowerSet, this.lowerBound, this.belowBound);
        }
        int i = 0;
        if (this.belowBound == null) {
            SnapshotIdSet this_$iv = bits;
            int[] belowBound$iv$iv = this.belowBound;
            if (belowBound$iv$iv != null) {
                int length = belowBound$iv$iv.length;
                while (i < length) {
                    int element$iv$iv = belowBound$iv$iv[i];
                    SnapshotIdSet previous = this_$iv;
                    this_$iv = previous.set(element$iv$iv);
                    i++;
                }
            }
            if (this.lowerSet != 0) {
                for (int index$iv$iv = 0; index$iv$iv < 64; index$iv$iv++) {
                    if ((this.lowerSet & (1 << index$iv$iv)) != 0) {
                        int element$iv = this.lowerBound + index$iv$iv;
                        SnapshotIdSet previous2 = this_$iv;
                        this_$iv = previous2.set(element$iv);
                    }
                }
            }
            if (this.upperSet != 0) {
                for (int index$iv$iv2 = 0; index$iv$iv2 < 64; index$iv$iv2++) {
                    if ((this.upperSet & (1 << index$iv$iv2)) != 0) {
                        int element$iv2 = index$iv$iv2 + 64 + this.lowerBound;
                        SnapshotIdSet previous3 = this_$iv;
                        this_$iv = previous3.set(element$iv2);
                    }
                }
            }
            return this_$iv;
        }
        Object accumulator$iv = this;
        int[] belowBound$iv$iv2 = bits.belowBound;
        if (belowBound$iv$iv2 != null) {
            int length2 = belowBound$iv$iv2.length;
            while (i < length2) {
                int element$iv$iv2 = belowBound$iv$iv2[i];
                SnapshotIdSet previous4 = (SnapshotIdSet) accumulator$iv;
                accumulator$iv = previous4.set(element$iv$iv2);
                i++;
            }
        }
        long j = 0;
        if (bits.lowerSet != 0) {
            int index$iv$iv3 = 0;
            while (index$iv$iv3 < 64) {
                if ((bits.lowerSet & (1 << index$iv$iv3)) != j) {
                    int element$iv3 = bits.lowerBound + index$iv$iv3;
                    SnapshotIdSet previous5 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous5.set(element$iv3);
                }
                index$iv$iv3++;
                j = 0;
            }
        }
        long j2 = 0;
        if (bits.upperSet != 0) {
            int index$iv$iv4 = 0;
            while (index$iv$iv4 < 64) {
                if ((bits.upperSet & (1 << index$iv$iv4)) != j2) {
                    int element$iv4 = index$iv$iv4 + 64 + bits.lowerBound;
                    SnapshotIdSet previous6 = (SnapshotIdSet) accumulator$iv;
                    accumulator$iv = previous6.set(element$iv4);
                }
                index$iv$iv4++;
                j2 = 0;
            }
        }
        return (SnapshotIdSet) accumulator$iv;
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1 */
    /* JADX INFO: compiled from: SnapshotIdSet.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", m210f = "SnapshotIdSet.kt", m211i = {0, 0, 1, 1, 2, 2}, m212l = {295, 300, HttpStatusCodesKt.HTTP_TEMP_REDIRECT}, m213m = "invokeSuspend", m214n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, m215s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
    static final class C17211 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C17211(Continuation<? super C17211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C17211 c17211 = SnapshotIdSet.this.new C17211(continuation);
            c17211.L$0 = obj;
            return c17211;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C17211) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0068  */
        /* JADX WARN: Code duplicated, block: B:15:0x0081 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x007f -> B:16:0x0082). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a2 -> B:28:0x00c4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c0 -> B:28:0x00c4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0104 -> B:41:0x0109). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0108 -> B:41:0x0109). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 282
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.C17211.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new C17211(null)).iterator();
    }

    public final SnapshotIdSet fastFold(SnapshotIdSet initial, Function2<? super SnapshotIdSet, ? super Integer, SnapshotIdSet> operation) {
        Object accumulator = initial;
        int[] belowBound$iv = this.belowBound;
        if (belowBound$iv != null) {
            for (int element$iv : belowBound$iv) {
                accumulator = operation.invoke(accumulator, Integer.valueOf(element$iv));
            }
        }
        if (this.lowerSet != 0) {
            for (int index$iv = 0; index$iv < 64; index$iv++) {
                if ((this.lowerSet & (1 << index$iv)) != 0) {
                    int element = this.lowerBound + index$iv;
                    accumulator = operation.invoke(accumulator, Integer.valueOf(element));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int index$iv2 = 0; index$iv2 < 64; index$iv2++) {
                if ((this.upperSet & (1 << index$iv2)) != 0) {
                    int element2 = index$iv2 + 64 + this.lowerBound;
                    accumulator = operation.invoke(accumulator, Integer.valueOf(element2));
                }
            }
        }
        return (SnapshotIdSet) accumulator;
    }

    public final void fastForEach(Function1<? super Integer, Unit> block) {
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            for (int element : belowBound) {
                block.invoke(Integer.valueOf(element));
            }
        }
        if (this.lowerSet != 0) {
            for (int index = 0; index < 64; index++) {
                if ((this.lowerSet & (1 << index)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + index));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int index2 = 0; index2 < 64; index2++) {
                if ((this.upperSet & (1 << index2)) != 0) {
                    block.invoke(Integer.valueOf(index2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int i) {
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            return belowBound[0];
        }
        if (this.lowerSet != 0) {
            return this.lowerBound + Long.numberOfTrailingZeros(this.lowerSet);
        }
        return this.upperSet != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(this.upperSet) : i;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append(super.toString()).append(" [");
        SnapshotIdSet $this$map$iv = this;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            int it = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(String.valueOf(it));
        }
        return sbAppend.append(ListUtilsKt.fastJoinToString$default((List) destination$iv$iv, null, null, null, 0, null, null, 63, null)).append(AbstractJsonLexerKt.END_LIST).toString();
    }

    /* JADX INFO: compiled from: SnapshotIdSet.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m195d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
