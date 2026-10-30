package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChildLayerDependenciesTracker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005J\u001d\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\bJ+\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0086\bR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "()V", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dependency", "oldDependenciesSet", "oldDependency", "trackingInProgress", "", "onDependencyAdded", "graphicsLayer", "removeDependencies", "", "block", "Lkotlin/Function1;", "withTracking", "onDependencyRemoved", "Lkotlin/Function0;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ChildLayerDependenciesTracker {
    private MutableScatterSet<GraphicsLayer> dependenciesSet;
    private GraphicsLayer dependency;
    private MutableScatterSet<GraphicsLayer> oldDependenciesSet;
    private GraphicsLayer oldDependency;
    private boolean trackingInProgress;

    /* JADX WARN: Code duplicated, block: B:32:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9 A[LOOP:0: B:20:0x0068->B:33:0x00b9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c7 A[EDGE_INSN: B:40:0x00c7->B:36:0x00c7 BREAK  A[LOOP:0: B:20:0x0068->B:33:0x00b9], SYNTHETIC] */
    public final void withTracking(Function1<? super GraphicsLayer, Unit> onDependencyRemoved, Function0<Unit> block) {
        this.oldDependency = this.dependency;
        MutableScatterSet currentSet = this.dependenciesSet;
        if (currentSet != null && currentSet.isNotEmpty()) {
            MutableScatterSet it = this.oldDependenciesSet;
            if (it == null) {
                it = ScatterSetKt.mutableScatterSetOf();
                this.oldDependenciesSet = it;
            }
            it.addAll(currentSet);
            currentSet.clear();
        }
        this.trackingInProgress = true;
        block.invoke();
        this.trackingInProgress = false;
        GraphicsLayer graphicsLayer = this.oldDependency;
        if (graphicsLayer != null) {
            onDependencyRemoved.invoke(graphicsLayer);
        }
        MutableScatterSet oldSet = this.oldDependenciesSet;
        if (oldSet != null) {
            int i = 0;
            if (oldSet.isNotEmpty()) {
                MutableScatterSet this_$iv = oldSet;
                Object[] k$iv = this_$iv.elements;
                long[] m$iv$iv = this_$iv.metadata;
                int lastIndex$iv$iv = m$iv$iv.length - 2;
                int i$iv$iv = 0;
                if (0 <= lastIndex$iv$iv) {
                    while (true) {
                        long slot$iv$iv = m$iv$iv[i$iv$iv];
                        int i2 = i;
                        ScatterSet this_$iv2 = this_$iv;
                        long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                        if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                            if (i$iv$iv != lastIndex$iv$iv) {
                                break;
                                break;
                            } else {
                                i$iv$iv++;
                                i = i2;
                                this_$iv = this_$iv2;
                            }
                        } else {
                            int i3 = 8;
                            int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                            for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                                long value$iv$iv$iv = slot$iv$iv & 255;
                                int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                                if ($i$f$isFull != 0) {
                                    int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                    onDependencyRemoved.invoke(k$iv[index$iv$iv]);
                                }
                                i3 = 8;
                                slot$iv$iv >>= 8;
                            }
                            if (bitCount$iv$iv != i3) {
                                break;
                            }
                            if (i$iv$iv != lastIndex$iv$iv) {
                                break;
                            }
                            i$iv$iv++;
                            i = i2;
                            this_$iv = this_$iv2;
                        }
                    }
                }
                oldSet.clear();
            }
        }
    }

    public final boolean onDependencyAdded(GraphicsLayer graphicsLayer) {
        boolean value$iv = this.trackingInProgress;
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
        }
        if (this.dependenciesSet != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSet = this.dependenciesSet;
            Intrinsics.checkNotNull(mutableScatterSet);
            mutableScatterSet.add(graphicsLayer);
        } else if (this.dependency != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            GraphicsLayer graphicsLayer2 = this.dependency;
            Intrinsics.checkNotNull(graphicsLayer2);
            mutableScatterSetMutableScatterSetOf.add(graphicsLayer2);
            mutableScatterSetMutableScatterSetOf.add(graphicsLayer);
            this.dependenciesSet = mutableScatterSetMutableScatterSetOf;
            this.dependency = null;
        } else {
            this.dependency = graphicsLayer;
        }
        if (this.oldDependenciesSet != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSet2 = this.oldDependenciesSet;
            Intrinsics.checkNotNull(mutableScatterSet2);
            return !mutableScatterSet2.remove(graphicsLayer);
        }
        if (this.oldDependency != graphicsLayer) {
            return true;
        }
        this.oldDependency = null;
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0083 A[LOOP:0: B:10:0x0031->B:23:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0093 A[EDGE_INSN: B:29:0x0093->B:26:0x0093 BREAK  A[LOOP:0: B:10:0x0031->B:23:0x0083], SYNTHETIC] */
    public final void removeDependencies(Function1<? super GraphicsLayer, Unit> block) {
        GraphicsLayer it = this.dependency;
        if (it != null) {
            block.invoke(it);
            this.dependency = null;
        }
        MutableScatterSet it2 = this.dependenciesSet;
        if (it2 != null) {
            int i = 0;
            MutableScatterSet this_$iv = it2;
            int $i$f$forEach = 0;
            Object[] k$iv = this_$iv.elements;
            long[] m$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 <= lastIndex$iv$iv) {
                while (true) {
                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                    int i2 = i;
                    ScatterSet this_$iv2 = this_$iv;
                    int $i$f$forEach2 = $i$f$forEach;
                    long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                    if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                            break;
                        }
                        i$iv$iv++;
                        $i$f$forEach = $i$f$forEach2;
                        i = i2;
                        this_$iv = this_$iv2;
                    } else {
                        int i3 = 8;
                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                        for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                            long value$iv$iv$iv = slot$iv$iv & 255;
                            if (value$iv$iv$iv < 128) {
                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                block.invoke(k$iv[index$iv$iv]);
                            }
                            i3 = 8;
                            slot$iv$iv >>= 8;
                        }
                        if (bitCount$iv$iv != i3) {
                            break;
                        }
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                        }
                        i$iv$iv++;
                        $i$f$forEach = $i$f$forEach2;
                        i = i2;
                        this_$iv = this_$iv2;
                    }
                }
            }
            it2.clear();
        }
    }
}
