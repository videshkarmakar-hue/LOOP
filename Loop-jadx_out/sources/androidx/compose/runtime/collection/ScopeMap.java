package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScopeMap.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b0\u001aJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086\b¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020\u000e2#\b\u0004\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\bJ\u001b\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, m195d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "anyScopeOf", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "asMap", "", "", "clear", "contains", "element", "(Ljava/lang/Object;)Z", "forEachScopeOf", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", "set", DownloadUtil.CookieScheme.VALUE, "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScopeMap<Key, Scope> {
    public static final int $stable = 8;
    private final MutableScatterMap<Object, Object> map = ScatterMapKt.mutableScatterMapOf();

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.get_size();
    }

    public final void add(Key key, Scope scope) {
        MutableScatterSet mutableScatterSet;
        Object obj;
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = iFindInsertIndex < 0;
        Object obj2 = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj2 == null) {
            obj = scope;
        } else {
            if (obj2 instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) obj2).add(scope);
            } else if (obj2 != scope) {
                mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.add(obj2);
                mutableScatterSet.add(scope);
            }
            obj = obj2;
        }
        if (z) {
            obj = mutableScatterSet;
            int i = ~iFindInsertIndex;
            mutableScatterMap.keys[i] = key;
            mutableScatterMap.values[i] = obj;
            return;
        }
        obj = mutableScatterSet;
        mutableScatterMap.values[iFindInsertIndex] = obj;
    }

    public final void set(Key key, Scope value) {
        this.map.set(key, value);
    }

    public final boolean contains(Key element) {
        return this.map.containsKey(element);
    }

    public final void forEachScopeOf(Key key, Function1<? super Scope, Unit> block) {
        Object value = getMap().get(key);
        if (value != null) {
            if (value instanceof MutableScatterSet) {
                ScatterSet this_$iv = (MutableScatterSet) value;
                Object[] k$iv = this_$iv.elements;
                long[] m$iv$iv = this_$iv.metadata;
                int lastIndex$iv$iv = m$iv$iv.length - 2;
                int i$iv$iv = 0;
                if (0 > lastIndex$iv$iv) {
                    return;
                }
                while (true) {
                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                    ScatterSet this_$iv2 = this_$iv;
                    if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i = 8;
                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                        for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                            long value$iv$iv$iv = 255 & slot$iv$iv;
                            if (value$iv$iv$iv < 128) {
                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                block.invoke(k$iv[index$iv$iv]);
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
                    this_$iv = this_$iv2;
                }
            } else {
                block.invoke(value);
            }
        }
    }

    public final boolean anyScopeOf(Key key, Function1<? super Scope, Boolean> block) {
        Object value$iv = getMap().get(key);
        if (value$iv == null) {
            return false;
        }
        if (!(value$iv instanceof MutableScatterSet)) {
            return block.invoke(value$iv).booleanValue();
        }
        ScatterSet this_$iv$iv = (MutableScatterSet) value$iv;
        int $i$f$forEach = 0;
        Object[] k$iv$iv = this_$iv$iv.elements;
        long[] m$iv$iv$iv = this_$iv$iv.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
        int i$iv$iv$iv = 0;
        if (0 > lastIndex$iv$iv$iv) {
            return false;
        }
        while (true) {
            long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
            ScatterSet this_$iv$iv2 = this_$iv$iv;
            int $i$f$forEach2 = $i$f$forEach;
            long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                int i = 8;
                int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                    long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                    int $i$f$isFull = value$iv$iv$iv$iv < 128 ? 1 : 0;
                    if ($i$f$isFull != 0) {
                        int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                        Object it = k$iv$iv[index$iv$iv$iv];
                        if (block.invoke(it).booleanValue()) {
                            return true;
                        }
                    }
                    i = 8;
                    slot$iv$iv$iv >>= 8;
                }
                if (bitCount$iv$iv$iv != i) {
                    return false;
                }
            }
            if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                return false;
            }
            i$iv$iv$iv++;
            $i$f$forEach = $i$f$forEach2;
            this_$iv$iv = this_$iv$iv2;
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean remove(Key key, Scope scope) {
        Object value = this.map.get(key);
        if (value == null) {
            return false;
        }
        if (value instanceof MutableScatterSet) {
            MutableScatterSet set = (MutableScatterSet) value;
            boolean removed = set.remove(scope);
            if (removed && set.isEmpty()) {
                this.map.remove(key);
            }
            return removed;
        }
        if (!Intrinsics.areEqual(value, scope)) {
            return false;
        }
        this.map.remove(key);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ef A[LOOP:2: B:17:0x0090->B:34:0x00ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff A[EDGE_INSN: B:63:0x00ff->B:37:0x00ff BREAK  A[LOOP:2: B:17:0x0090->B:34:0x00ef], SYNTHETIC] */
    public final void removeScopeIf(Function1<? super Scope, Boolean> predicate) {
        int $i$f$removeScopeIf;
        int $i$f$removeIf;
        ScatterMap this_$iv$iv;
        int $i$f$forEachIndexed;
        long[] m$iv$iv;
        int lastIndex$iv$iv;
        int i$iv$iv;
        int lastIndex$iv$iv2;
        int i$iv$iv2;
        long $this$maskEmptyOrDeleted$iv$iv$iv;
        boolean zBooleanValue;
        int $i$f$removeScopeIf2 = 0;
        MutableScatterMap<Object, Object> map = getMap();
        int $i$f$removeIf2 = 0;
        MutableScatterMap<Object, Object> this_$iv$iv2 = map;
        int $i$f$forEachIndexed2 = 0;
        long[] m$iv$iv2 = this_$iv$iv2.metadata;
        int lastIndex$iv$iv3 = m$iv$iv2.length - 2;
        int i$iv$iv3 = 0;
        if (0 > lastIndex$iv$iv3) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv2[i$iv$iv3];
            long $this$maskEmptyOrDeleted$iv$iv$iv2 = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv2 == -9187201950435737472L) {
                $i$f$removeScopeIf = $i$f$removeScopeIf2;
                $i$f$removeIf = $i$f$removeIf2;
                this_$iv$iv = this_$iv$iv2;
                $i$f$forEachIndexed = $i$f$forEachIndexed2;
                m$iv$iv = m$iv$iv2;
                lastIndex$iv$iv = lastIndex$iv$iv3;
                i$iv$iv = i$iv$iv3;
            } else {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv3 - lastIndex$iv$iv3)) >>> 31);
                int j$iv$iv = 0;
                while (j$iv$iv < bitCount$iv$iv) {
                    long value$iv$iv$iv = slot$iv$iv & 255;
                    if (!(value$iv$iv$iv < 128)) {
                        $i$f$removeScopeIf2 = $i$f$removeScopeIf2;
                        $i$f$removeIf2 = $i$f$removeIf2;
                        this_$iv$iv2 = this_$iv$iv2;
                        $i$f$forEachIndexed2 = $i$f$forEachIndexed2;
                        m$iv$iv2 = m$iv$iv2;
                        lastIndex$iv$iv2 = lastIndex$iv$iv3;
                        i$iv$iv2 = i$iv$iv3;
                        $this$maskEmptyOrDeleted$iv$iv$iv = slot$iv$iv;
                    } else {
                        int index$iv$iv = (i$iv$iv3 << 3) + j$iv$iv;
                        Object obj = map.keys[index$iv$iv];
                        Object value = map.values[index$iv$iv];
                        if (value instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                            MutableScatterSet set = (MutableScatterSet) value;
                            Object[] elements$iv = set.elements;
                            long[] m$iv$iv3 = set.metadata;
                            int lastIndex$iv$iv4 = m$iv$iv3.length - 2;
                            int i$iv$iv4 = 0;
                            if (0 <= lastIndex$iv$iv4) {
                                while (true) {
                                    long slot$iv$iv2 = m$iv$iv3[i$iv$iv4];
                                    lastIndex$iv$iv2 = lastIndex$iv$iv3;
                                    i$iv$iv2 = i$iv$iv3;
                                    $this$maskEmptyOrDeleted$iv$iv$iv = slot$iv$iv;
                                    long $this$maskEmptyOrDeleted$iv$iv$iv3 = ((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L);
                                    if ($this$maskEmptyOrDeleted$iv$iv$iv3 == -9187201950435737472L) {
                                        if (i$iv$iv4 != lastIndex$iv$iv4) {
                                            break;
                                            break;
                                        }
                                        i$iv$iv4++;
                                        slot$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv;
                                        lastIndex$iv$iv3 = lastIndex$iv$iv2;
                                        i$iv$iv3 = i$iv$iv2;
                                    } else {
                                        int bitCount$iv$iv2 = 8 - ((~(i$iv$iv4 - lastIndex$iv$iv4)) >>> 31);
                                        for (int j$iv$iv2 = 0; j$iv$iv2 < bitCount$iv$iv2; j$iv$iv2++) {
                                            long value$iv$iv$iv2 = slot$iv$iv2 & 255;
                                            if (value$iv$iv$iv2 < 128) {
                                                int index$iv$iv2 = (i$iv$iv4 << 3) + j$iv$iv2;
                                                if (predicate.invoke(elements$iv[index$iv$iv2]).booleanValue()) {
                                                    set.removeElementAt(index$iv$iv2);
                                                }
                                            }
                                            slot$iv$iv2 >>= 8;
                                        }
                                        if (bitCount$iv$iv2 != 8) {
                                            break;
                                        }
                                        if (i$iv$iv4 != lastIndex$iv$iv4) {
                                            break;
                                        }
                                        i$iv$iv4++;
                                        slot$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv;
                                        lastIndex$iv$iv3 = lastIndex$iv$iv2;
                                        i$iv$iv3 = i$iv$iv2;
                                    }
                                }
                            } else {
                                lastIndex$iv$iv2 = lastIndex$iv$iv3;
                                i$iv$iv2 = i$iv$iv3;
                                $this$maskEmptyOrDeleted$iv$iv$iv = slot$iv$iv;
                            }
                            zBooleanValue = set.isEmpty();
                        } else {
                            lastIndex$iv$iv2 = lastIndex$iv$iv3;
                            i$iv$iv2 = i$iv$iv3;
                            $this$maskEmptyOrDeleted$iv$iv$iv = slot$iv$iv;
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                            zBooleanValue = predicate.invoke(value).booleanValue();
                        }
                        if (zBooleanValue) {
                            map.removeValueAt(index$iv$iv);
                        }
                    }
                    slot$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv >> 8;
                    j$iv$iv++;
                    $i$f$removeIf2 = $i$f$removeIf2;
                    $i$f$removeScopeIf2 = $i$f$removeScopeIf2;
                    this_$iv$iv2 = this_$iv$iv2;
                    $i$f$forEachIndexed2 = $i$f$forEachIndexed2;
                    m$iv$iv2 = m$iv$iv2;
                    lastIndex$iv$iv3 = lastIndex$iv$iv2;
                    i$iv$iv3 = i$iv$iv2;
                }
                $i$f$removeScopeIf = $i$f$removeScopeIf2;
                $i$f$removeIf = $i$f$removeIf2;
                this_$iv$iv = this_$iv$iv2;
                $i$f$forEachIndexed = $i$f$forEachIndexed2;
                m$iv$iv = m$iv$iv2;
                lastIndex$iv$iv = lastIndex$iv$iv3;
                i$iv$iv = i$iv$iv3;
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            lastIndex$iv$iv3 = lastIndex$iv$iv;
            int i$iv$iv5 = i$iv$iv;
            if (i$iv$iv5 == lastIndex$iv$iv3) {
                return;
            }
            i$iv$iv3 = i$iv$iv5 + 1;
            $i$f$removeIf2 = $i$f$removeIf;
            $i$f$removeScopeIf2 = $i$f$removeScopeIf;
            this_$iv$iv2 = this_$iv$iv;
            $i$f$forEachIndexed2 = $i$f$forEachIndexed;
            m$iv$iv2 = m$iv$iv;
        }
    }

    public final void removeScope(Scope scope) {
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        MutableScatterMap<Object, Object> this_$iv$iv = mutableScatterMap;
        long[] m$iv$iv = this_$iv$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    boolean zIsEmpty = false;
                    if (value$iv$iv$iv < 128) {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        Object obj = mutableScatterMap.keys[index$iv$iv];
                        Object value = mutableScatterMap.values[index$iv$iv];
                        if (value instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScope$lambda$3>");
                            MutableScatterSet set = (MutableScatterSet) value;
                            set.remove(scope);
                            zIsEmpty = set.isEmpty();
                        } else if (value == scope) {
                            zIsEmpty = true;
                        }
                        if (zIsEmpty) {
                            mutableScatterMap.removeValueAt(index$iv$iv);
                        }
                    }
                    slot$iv$iv >>= 8;
                }
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            } else {
                i$iv$iv++;
            }
        }
    }

    public final Map<Key, Set<Scope>> asMap() {
        int $i$f$forEach;
        Object[] k$iv;
        Object[] v$iv;
        Set setMutableSetOf;
        HashMap result = new HashMap();
        ScatterMap this_$iv = this.map;
        int $i$f$forEach2 = 0;
        Object[] k$iv2 = this_$iv.keys;
        Object[] v$iv2 = this_$iv.values;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                ScatterMap this_$iv2 = this_$iv;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    $i$f$forEach = $i$f$forEach2;
                    k$iv = k$iv2;
                    v$iv = v$iv2;
                } else {
                    int i = 8;
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            Object key = k$iv2[index$iv$iv];
                            Object value = v$iv2[index$iv$iv];
                            HashMap map = result;
                            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                            if (value instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4>");
                                MutableScatterSet set = (MutableScatterSet) value;
                                setMutableSetOf = set.asSet();
                            } else {
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                                setMutableSetOf = SetsKt.mutableSetOf(value);
                            }
                            map.put(key, setMutableSetOf);
                        }
                        i = 8;
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        $i$f$forEach2 = $i$f$forEach2;
                        k$iv2 = k$iv2;
                        v$iv2 = v$iv2;
                    }
                    $i$f$forEach = $i$f$forEach2;
                    k$iv = k$iv2;
                    v$iv = v$iv2;
                    if (bitCount$iv$iv != i) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv = this_$iv2;
                $i$f$forEach2 = $i$f$forEach;
                k$iv2 = k$iv;
                v$iv2 = v$iv;
            }
        }
        return result;
    }
}
