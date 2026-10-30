package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Snapshot.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J$\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\u0080\b¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,¨\u0006h"}, m195d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/collection/MutableScatterSet;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private MutableScatterSet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: getReadObserver$runtime_release */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public MutableSnapshot(int id, SnapshotIdSet invalid, Function1<Object, Unit> function1, Function1<Object, Unit> function2) {
        super(id, invalid, null);
        this.readObserver = function1;
        this.writeObserver = function2;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(function1, function2);
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            try {
                int newId = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = newId + 1;
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(newId);
                SnapshotIdSet currentInvalid = getInvalid();
                try {
                    setInvalid$runtime_release(currentInvalid.set(newId));
                    NestedMutableSnapshot nestedMutableSnapshot = new NestedMutableSnapshot(newId, SnapshotKt.addRange(currentInvalid, getId() + 1, newId), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null), SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release()), this);
                    if (!getApplied() && !getDisposed()) {
                        int previousId$iv = getId();
                        Object lock$iv$iv$iv = SnapshotKt.getLock();
                        synchronized (lock$iv$iv$iv) {
                            int i = SnapshotKt.nextSnapshotId;
                            SnapshotKt.nextSnapshotId = i + 1;
                            setId$runtime_release(i);
                            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                            Unit unit = Unit.INSTANCE;
                        }
                        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
                    }
                    return nestedMutableSnapshot;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x024b A[Catch: all -> 0x0295, LOOP:3: B:83:0x01ec->B:101:0x024b, LOOP_END, TryCatch #2 {all -> 0x0295, blocks: (B:94:0x0228, B:95:0x0234, B:101:0x024b, B:108:0x026b, B:110:0x026f, B:112:0x0278, B:114:0x0288), top: B:134:0x0228 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0256  */
    /* JADX WARN: Code duplicated, block: B:107:0x0267  */
    /* JADX WARN: Code duplicated, block: B:110:0x026f A[Catch: all -> 0x0295, TryCatch #2 {all -> 0x0295, blocks: (B:94:0x0228, B:95:0x0234, B:101:0x024b, B:108:0x026b, B:110:0x026f, B:112:0x0278, B:114:0x0288), top: B:134:0x0228 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0278 A[Catch: all -> 0x0295, LOOP:2: B:111:0x0276->B:112:0x0278, LOOP_END, TryCatch #2 {all -> 0x0295, blocks: (B:94:0x0228, B:95:0x0234, B:101:0x024b, B:108:0x026b, B:110:0x026f, B:112:0x0278, B:114:0x0288), top: B:134:0x0228 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x025f A[EDGE_INSN: B:148:0x025f->B:104:0x025f BREAK  A[LOOP:3: B:83:0x01ec->B:101:0x024b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x025f A[EDGE_INSN: B:149:0x025f->B:104:0x025f BREAK  A[LOOP:3: B:83:0x01ec->B:101:0x024b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x01d8 A[EDGE_INSN: B:153:0x01d8->B:80:0x01d8 BREAK  A[LOOP:5: B:54:0x0159->B:73:0x01b3], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x01d8 A[EDGE_INSN: B:154:0x01d8->B:80:0x01d8 BREAK  A[LOOP:5: B:54:0x0159->B:73:0x01b3], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00eb A[LOOP:0: B:36:0x00e9->B:37:0x00eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x0115 A[LOOP:1: B:43:0x0113->B:44:0x0115, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x012d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0159 A[Catch: all -> 0x01c5, LOOP:5: B:54:0x0159->B:73:0x01b3, LOOP_START, PHI: r3 r4 r7 r15
  0x0159: PHI (r3v3 java.util.Map<androidx.compose.runtime.snapshots.StateRecord, ? extends androidx.compose.runtime.snapshots.StateRecord>) = 
  (r3v1 java.util.Map<androidx.compose.runtime.snapshots.StateRecord, ? extends androidx.compose.runtime.snapshots.StateRecord>)
  (r3v8 java.util.Map<androidx.compose.runtime.snapshots.StateRecord, ? extends androidx.compose.runtime.snapshots.StateRecord>)
 binds: [B:53:0x0157, B:73:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x0159: PHI (r4v5 java.util.List) = (r4v3 java.util.List), (r4v6 java.util.List) binds: [B:53:0x0157, B:73:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x0159: PHI (r7v3 'modifiedSet' java.util.Set) = (r7v1 'modifiedSet' java.util.Set), (r7v4 'modifiedSet' java.util.Set) binds: [B:53:0x0157, B:73:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x0159: PHI (r15v1 'i$iv$iv' int) = (r15v0 'i$iv$iv' int), (r15v2 'i$iv$iv' int) binds: [B:53:0x0157, B:73:0x01b3] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x01c5, blocks: (B:52:0x013d, B:54:0x0159), top: B:136:0x013d }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0171  */
    /* JADX WARN: Code duplicated, block: B:59:0x017d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0188  */
    /* JADX WARN: Code duplicated, block: B:62:0x018a  */
    /* JADX WARN: Code duplicated, block: B:64:0x018d  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x01b3 A[LOOP:5: B:54:0x0159->B:73:0x01b3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ec A[Catch: all -> 0x0261, LOOP:3: B:83:0x01ec->B:101:0x024b, LOOP_START, PHI: r2 r3 r5 r6 r13
  0x01ec: PHI (r2v2 'modified' androidx.collection.MutableScatterSet) = (r2v0 'modified' androidx.collection.MutableScatterSet), (r2v5 'modified' androidx.collection.MutableScatterSet) binds: [B:82:0x01ea, B:101:0x024b] A[DONT_GENERATE, DONT_INLINE]
  0x01ec: PHI (r3v16 '$i$f$forEach' int) = (r3v15 '$i$f$forEach' int), (r3v18 '$i$f$forEach' int) binds: [B:82:0x01ea, B:101:0x024b] A[DONT_GENERATE, DONT_INLINE]
  0x01ec: PHI (r5v4 'globalModified' java.lang.Object) = (r5v2 'globalModified' java.lang.Object), (r5v9 'globalModified' java.lang.Object) binds: [B:82:0x01ea, B:101:0x024b] A[DONT_GENERATE, DONT_INLINE]
  0x01ec: PHI (r6v6 'this_$iv$iv' androidx.collection.ScatterSet) = (r6v5 'this_$iv$iv' androidx.collection.ScatterSet), (r6v7 'this_$iv$iv' androidx.collection.ScatterSet) binds: [B:82:0x01ea, B:101:0x024b] A[DONT_GENERATE, DONT_INLINE]
  0x01ec: PHI (r13v5 'i$iv$iv' int) = (r13v4 'i$iv$iv' int), (r13v6 'i$iv$iv' int) binds: [B:82:0x01ea, B:101:0x024b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0261, blocks: (B:81:0x01da, B:83:0x01ec), top: B:130:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0206  */
    /* JADX WARN: Code duplicated, block: B:88:0x0212  */
    /* JADX WARN: Code duplicated, block: B:90:0x021d  */
    /* JADX WARN: Code duplicated, block: B:91:0x021f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0222  */
    /* JADX WARN: Code duplicated, block: B:98:0x0242  */
    /* JADX WARN: Code duplicated, block: B:99:0x0243  */
    public SnapshotApplyResult apply() throws Throwable {
        Set modifiedSet;
        Object lock$iv$iv;
        Object[] k$iv;
        long[] m$iv$iv;
        int lastIndex$iv$iv;
        int i$iv$iv;
        long slot$iv$iv;
        Set set;
        Map<StateRecord, ? extends StateRecord> map;
        List list;
        int bitCount$iv$iv;
        int j$iv$iv;
        long value$iv$iv$iv;
        int $i$f$isFull;
        int $i$f$forEach;
        Object[] k$iv2;
        ScatterSet this_$iv$iv;
        long[] m$iv$iv2;
        int lastIndex$iv$iv2;
        int i$iv$iv2;
        long slot$iv$iv2;
        MutableScatterSet modified;
        int $i$f$forEach2;
        Object globalModified;
        ScatterSet this_$iv$iv2;
        long $this$maskEmptyOrDeleted$iv$iv$iv;
        int bitCount$iv$iv2;
        int j$iv$iv2;
        long value$iv$iv$iv2;
        int $i$f$isFull2;
        List<? extends StateObject> list2;
        int index$iv;
        int size;
        Set modifiedSet2;
        List $this$fastForEach$iv;
        int index$iv2;
        int size2;
        Set nonNullGlobalModified;
        List $this$fastForEach$iv2;
        int index$iv3;
        int size3;
        MutableScatterSet previousModified;
        MutableScatterSet modified2 = getModified$runtime_release();
        Map<StateRecord, ? extends StateRecord> mapOptimisticMerges = modified2 != null ? SnapshotKt.optimisticMerges((MutableSnapshot) SnapshotKt.currentGlobalSnapshot.get(), this, SnapshotKt.openSnapshots.clear(((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getId())) : null;
        List listEmptyList = CollectionsKt.emptyList();
        Object globalModified2 = null;
        Object lock$iv$iv2 = SnapshotKt.getLock();
        synchronized (lock$iv$iv2) {
            try {
                SnapshotKt.validateOpen(this);
                if (modified2 == null) {
                    closeLocked$runtime_release();
                    GlobalSnapshot previousGlobalSnapshot = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot, SnapshotKt.emptyLambda);
                    previousModified = previousGlobalSnapshot.getModified$runtime_release();
                    if (previousModified != null) {
                        listEmptyList = SnapshotKt.applyObservers;
                        globalModified2 = previousModified;
                    }
                    Unit unit = Unit.INSTANCE;
                    this.applied = true;
                    if (globalModified2 != null) {
                        nonNullGlobalModified = ScatterSetWrapperKt.wrapIntoSet((ScatterSet) globalModified2);
                        if (!nonNullGlobalModified.isEmpty()) {
                            $this$fastForEach$iv2 = listEmptyList;
                            size3 = $this$fastForEach$iv2.size();
                            for (index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                                Object item$iv = $this$fastForEach$iv2.get(index$iv3);
                                Function2 it = (Function2) item$iv;
                                it.invoke(nonNullGlobalModified, this);
                            }
                        }
                    }
                    if (modified2 != null) {
                        modifiedSet2 = ScatterSetWrapperKt.wrapIntoSet(modified2);
                        $this$fastForEach$iv = listEmptyList;
                        size2 = $this$fastForEach$iv.size();
                        for (index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                            Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                            Function2 it2 = (Function2) item$iv2;
                            it2.invoke(modifiedSet2, this);
                        }
                    }
                    modifiedSet = null;
                    lock$iv$iv = SnapshotKt.getLock();
                    synchronized (lock$iv$iv) {
                        releasePinnedSnapshotsForCloseLocked$runtime_release();
                        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                        if (globalModified2 != null) {
                            ScatterSet this_$iv = (ScatterSet) globalModified2;
                            k$iv = this_$iv.elements;
                            m$iv$iv = this_$iv.metadata;
                            lastIndex$iv$iv = m$iv$iv.length - 2;
                            i$iv$iv = 0;
                            if (0 <= lastIndex$iv$iv) {
                                while (true) {
                                    slot$iv$iv = m$iv$iv[i$iv$iv];
                                    set = modifiedSet;
                                    map = mapOptimisticMerges;
                                    list = listEmptyList;
                                    if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                                        if (i$iv$iv != lastIndex$iv$iv) {
                                            break;
                                            break;
                                        }
                                        i$iv$iv++;
                                        mapOptimisticMerges = map;
                                        listEmptyList = list;
                                        modifiedSet = set;
                                    } else {
                                        bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                                        for (j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                                            value$iv$iv$iv = slot$iv$iv & 255;
                                            if (value$iv$iv$iv < 128) {
                                                $i$f$isFull = 1;
                                            } else {
                                                $i$f$isFull = 0;
                                            }
                                            if ($i$f$isFull != 0) {
                                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                                StateObject it3 = (StateObject) k$iv[index$iv$iv];
                                                SnapshotKt.processForUnusedRecordsLocked(it3);
                                            }
                                            slot$iv$iv >>= 8;
                                        }
                                        if (bitCount$iv$iv == 8) {
                                            break;
                                            break;
                                        }
                                        if (i$iv$iv != lastIndex$iv$iv) {
                                            break;
                                            break;
                                        }
                                        i$iv$iv++;
                                        mapOptimisticMerges = map;
                                        listEmptyList = list;
                                        modifiedSet = set;
                                    }
                                    throw th;
                                }
                            }
                        }
                        if (modified2 != null) {
                            MutableScatterSet this_$iv2 = modified2;
                            $i$f$forEach = 0;
                            k$iv2 = this_$iv2.elements;
                            this_$iv$iv = this_$iv2;
                            m$iv$iv2 = this_$iv$iv.metadata;
                            lastIndex$iv$iv2 = m$iv$iv2.length - 2;
                            i$iv$iv2 = 0;
                            if (0 <= lastIndex$iv$iv2) {
                                while (true) {
                                    slot$iv$iv2 = m$iv$iv2[i$iv$iv2];
                                    modified = modified2;
                                    $i$f$forEach2 = $i$f$forEach;
                                    globalModified = globalModified2;
                                    this_$iv$iv2 = this_$iv$iv;
                                    $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L);
                                    if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                                        bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                                        for (j$iv$iv2 = 0; j$iv$iv2 < bitCount$iv$iv2; j$iv$iv2++) {
                                            value$iv$iv$iv2 = slot$iv$iv2 & 255;
                                            if (value$iv$iv$iv2 < 128) {
                                                $i$f$isFull2 = 1;
                                            } else {
                                                $i$f$isFull2 = 0;
                                            }
                                            if ($i$f$isFull2 != 0) {
                                                int index$iv$iv2 = (i$iv$iv2 << 3) + j$iv$iv2;
                                                StateObject it4 = (StateObject) k$iv2[index$iv$iv2];
                                                SnapshotKt.processForUnusedRecordsLocked(it4);
                                            }
                                            slot$iv$iv2 >>= 8;
                                        }
                                        if (bitCount$iv$iv2 == 8) {
                                            break;
                                            break;
                                        }
                                    }
                                    if (i$iv$iv2 != lastIndex$iv$iv2) {
                                        break;
                                        break;
                                    }
                                    i$iv$iv2++;
                                    globalModified2 = globalModified;
                                    this_$iv$iv = this_$iv$iv2;
                                    modified2 = modified;
                                    $i$f$forEach = $i$f$forEach2;
                                }
                            }
                        }
                        list2 = this.merged;
                        if (list2 != null) {
                            size = list2.size();
                            for (index$iv = 0; index$iv < size; index$iv++) {
                                Object item$iv3 = list2.get(index$iv);
                                StateObject it5 = (StateObject) item$iv3;
                                SnapshotKt.processForUnusedRecordsLocked(it5);
                            }
                        }
                        this.merged = null;
                        Unit unit2 = Unit.INSTANCE;
                        return SnapshotApplyResult.Success.INSTANCE;
                    }
                }
                try {
                    if (modified2.get_size() == 0) {
                        closeLocked$runtime_release();
                        GlobalSnapshot previousGlobalSnapshot2 = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                        SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot2, SnapshotKt.emptyLambda);
                        previousModified = previousGlobalSnapshot2.getModified$runtime_release();
                        if (previousModified != null && previousModified.isNotEmpty()) {
                            listEmptyList = SnapshotKt.applyObservers;
                            globalModified2 = previousModified;
                        }
                    } else {
                        GlobalSnapshot previousGlobalSnapshot3 = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                        SnapshotApplyResult result = innerApplyLocked$runtime_release(SnapshotKt.nextSnapshotId, mapOptimisticMerges, SnapshotKt.openSnapshots.clear(previousGlobalSnapshot3.getId()));
                        if (!Intrinsics.areEqual(result, SnapshotApplyResult.Success.INSTANCE)) {
                            return result;
                        }
                        closeLocked$runtime_release();
                        SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot3, SnapshotKt.emptyLambda);
                        Object previousModified2 = previousGlobalSnapshot3.getModified$runtime_release();
                        setModified(null);
                        previousGlobalSnapshot3.setModified(null);
                        listEmptyList = SnapshotKt.applyObservers;
                        globalModified2 = previousModified2;
                    }
                    try {
                        Unit unit3 = Unit.INSTANCE;
                        this.applied = true;
                        if (globalModified2 != null) {
                            nonNullGlobalModified = ScatterSetWrapperKt.wrapIntoSet((ScatterSet) globalModified2);
                            if (!nonNullGlobalModified.isEmpty()) {
                                $this$fastForEach$iv2 = listEmptyList;
                                size3 = $this$fastForEach$iv2.size();
                                while (index$iv3 < size3) {
                                    Object item$iv4 = $this$fastForEach$iv2.get(index$iv3);
                                    Function2 it6 = (Function2) item$iv4;
                                    it6.invoke(nonNullGlobalModified, this);
                                }
                            }
                        }
                        if (modified2 != null && modified2.isNotEmpty()) {
                            modifiedSet2 = ScatterSetWrapperKt.wrapIntoSet(modified2);
                            $this$fastForEach$iv = listEmptyList;
                            size2 = $this$fastForEach$iv.size();
                            while (index$iv2 < size2) {
                                Object item$iv5 = $this$fastForEach$iv.get(index$iv2);
                                Function2 it7 = (Function2) item$iv5;
                                it7.invoke(modifiedSet2, this);
                            }
                        }
                        modifiedSet = null;
                        lock$iv$iv = SnapshotKt.getLock();
                        synchronized (lock$iv$iv) {
                            try {
                                releasePinnedSnapshotsForCloseLocked$runtime_release();
                                SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                                if (globalModified2 != null) {
                                    try {
                                        ScatterSet this_$iv3 = (ScatterSet) globalModified2;
                                        k$iv = this_$iv3.elements;
                                        m$iv$iv = this_$iv3.metadata;
                                        lastIndex$iv$iv = m$iv$iv.length - 2;
                                        i$iv$iv = 0;
                                        if (0 <= lastIndex$iv$iv) {
                                            while (true) {
                                                slot$iv$iv = m$iv$iv[i$iv$iv];
                                                set = modifiedSet;
                                                map = mapOptimisticMerges;
                                                list = listEmptyList;
                                                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    if (i$iv$iv != lastIndex$iv$iv) {
                                                        break;
                                                        break;
                                                    }
                                                    i$iv$iv++;
                                                    mapOptimisticMerges = map;
                                                    listEmptyList = list;
                                                    modifiedSet = set;
                                                } else {
                                                    bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                                                    while (j$iv$iv < bitCount$iv$iv) {
                                                        value$iv$iv$iv = slot$iv$iv & 255;
                                                        if (value$iv$iv$iv < 128) {
                                                            $i$f$isFull = 1;
                                                        } else {
                                                            $i$f$isFull = 0;
                                                        }
                                                        if ($i$f$isFull != 0) {
                                                            int index$iv$iv3 = (i$iv$iv << 3) + j$iv$iv;
                                                            try {
                                                                StateObject it8 = (StateObject) k$iv[index$iv$iv3];
                                                                SnapshotKt.processForUnusedRecordsLocked(it8);
                                                            } catch (Throwable th) {
                                                                th = th;
                                                            }
                                                        }
                                                        slot$iv$iv >>= 8;
                                                    }
                                                    if (bitCount$iv$iv == 8) {
                                                        break;
                                                    }
                                                    if (i$iv$iv != lastIndex$iv$iv) {
                                                        break;
                                                    }
                                                    i$iv$iv++;
                                                    mapOptimisticMerges = map;
                                                    listEmptyList = list;
                                                    modifiedSet = set;
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                if (modified2 != null) {
                                    try {
                                        MutableScatterSet this_$iv4 = modified2;
                                        $i$f$forEach = 0;
                                        k$iv2 = this_$iv4.elements;
                                        this_$iv$iv = this_$iv4;
                                        m$iv$iv2 = this_$iv$iv.metadata;
                                        lastIndex$iv$iv2 = m$iv$iv2.length - 2;
                                        i$iv$iv2 = 0;
                                        if (0 <= lastIndex$iv$iv2) {
                                            while (true) {
                                                slot$iv$iv2 = m$iv$iv2[i$iv$iv2];
                                                modified = modified2;
                                                $i$f$forEach2 = $i$f$forEach;
                                                globalModified = globalModified2;
                                                this_$iv$iv2 = this_$iv$iv;
                                                $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L);
                                                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                                                    bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                                                    while (j$iv$iv2 < bitCount$iv$iv2) {
                                                        value$iv$iv$iv2 = slot$iv$iv2 & 255;
                                                        if (value$iv$iv$iv2 < 128) {
                                                            $i$f$isFull2 = 1;
                                                        } else {
                                                            $i$f$isFull2 = 0;
                                                        }
                                                        if ($i$f$isFull2 != 0) {
                                                            int index$iv$iv4 = (i$iv$iv2 << 3) + j$iv$iv2;
                                                            try {
                                                                StateObject it9 = (StateObject) k$iv2[index$iv$iv4];
                                                                SnapshotKt.processForUnusedRecordsLocked(it9);
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                            }
                                                        }
                                                        slot$iv$iv2 >>= 8;
                                                    }
                                                    if (bitCount$iv$iv2 == 8) {
                                                        break;
                                                    }
                                                }
                                                if (i$iv$iv2 != lastIndex$iv$iv2) {
                                                    break;
                                                }
                                                i$iv$iv2++;
                                                globalModified2 = globalModified;
                                                this_$iv$iv = this_$iv$iv2;
                                                modified2 = modified;
                                                $i$f$forEach = $i$f$forEach2;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                                list2 = this.merged;
                                if (list2 != null) {
                                    size = list2.size();
                                    while (index$iv < size) {
                                        Object item$iv6 = list2.get(index$iv);
                                        StateObject it10 = (StateObject) item$iv6;
                                        SnapshotKt.processForUnusedRecordsLocked(it10);
                                    }
                                }
                                this.merged = null;
                                Unit unit4 = Unit.INSTANCE;
                                return SnapshotApplyResult.Success.INSTANCE;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
            }
            throw th;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (!getDisposed()) {
            super.dispose();
            mo3891nestedDeactivated$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int previousId = getId();
        recordPrevious$runtime_release(getId());
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            int readonlyId = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = readonlyId + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(readonlyId);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(readonlyId, SnapshotKt.addRange(getInvalid(), previousId + 1, readonlyId), readObserver, this);
        }
        if (!getApplied() && !getDisposed()) {
            int previousId$iv = getId();
            Object lock$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv) {
                int i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
                setId$runtime_release(i);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public void mo3890nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public void mo3891nestedDeactivated$runtime_release(Snapshot snapshot) {
        boolean value$iv = this.snapshots > 0;
        if (!value$iv) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        this.snapshots--;
        if (this.snapshots == 0 && !this.applied) {
            abandon();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        boolean value$iv = !this.applied;
        if (value$iv) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
    }

    private final void validateNotAppliedOrPinned() {
        boolean z = true;
        if (this.applied) {
            MutableSnapshot this_$iv = this;
            if (!(((Snapshot) this_$iv).pinningTrackingHandle >= 0)) {
                z = false;
            }
        }
        boolean value$iv = z;
        if (value$iv) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
    }

    private final void abandon() {
        MutableScatterSet modified;
        MutableSnapshot mutableSnapshot = this;
        MutableScatterSet modified2 = getModified$runtime_release();
        if (modified2 != null) {
            validateNotApplied();
            mutableSnapshot.setModified(null);
            int id = getId();
            MutableScatterSet this_$iv = modified2;
            int $i$f$forEach = 0;
            Object[] k$iv = this_$iv.elements;
            long[] m$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 <= lastIndex$iv$iv) {
                while (true) {
                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                    ScatterSet this_$iv2 = this_$iv;
                    int $i$f$forEach2 = $i$f$forEach;
                    if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                        modified = modified2;
                    } else {
                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                        int j$iv$iv = 0;
                        while (j$iv$iv < bitCount$iv$iv) {
                            long value$iv$iv$iv = 255 & slot$iv$iv;
                            if (value$iv$iv$iv < 128) {
                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                StateObject state = (StateObject) k$iv[index$iv$iv];
                                StateRecord current = state.getFirstStateRecord();
                                while (current != null) {
                                    MutableScatterSet modified3 = modified2;
                                    if (current.getSnapshotId() == id || CollectionsKt.contains(mutableSnapshot.previousIds, Integer.valueOf(current.getSnapshotId()))) {
                                        current.setSnapshotId$runtime_release(0);
                                    }
                                    current = current.getNext();
                                    mutableSnapshot = this;
                                    modified2 = modified3;
                                }
                            }
                            slot$iv$iv >>= 8;
                            j$iv$iv++;
                            mutableSnapshot = this;
                            modified2 = modified2;
                        }
                        modified = modified2;
                        if (bitCount$iv$iv != 8) {
                            break;
                        }
                    }
                    if (i$iv$iv == lastIndex$iv$iv) {
                        break;
                    }
                    i$iv$iv++;
                    mutableSnapshot = this;
                    this_$iv = this_$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    modified2 = modified;
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    /* JADX WARN: Code duplicated, block: B:69:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:82:0x021b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0228 A[LOOP:3: B:83:0x0226->B:84:0x0228, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x023c  */
    /* JADX WARN: Code duplicated, block: B:88:0x023e  */
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        ArrayList arrayList;
        List list;
        ArrayList arrayList2;
        int index$iv;
        int size;
        List<? extends StateObject> list2;
        List<? extends StateObject> listPlus;
        List it;
        int size2;
        int index$iv2;
        StateObject state;
        StateRecord stateRecord;
        Object lock$iv$iv;
        SnapshotIdSet start;
        int $i$f$forEach;
        Object[] k$iv;
        long[] m$iv$iv;
        SnapshotIdSet start2;
        int $i$f$forEach2;
        Object[] k$iv2;
        long[] m$iv$iv2;
        StateRecord previous;
        StateRecord merged;
        List list3;
        List list4;
        ArrayList arrayList3;
        List list5 = null;
        SnapshotIdSet start3 = getInvalid().set(getId()).m27or(this.previousIds);
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        ArrayList arrayList4 = null;
        MutableScatterSet<StateObject> this_$iv = modified$runtime_release;
        int $i$f$forEach3 = 0;
        Object[] k$iv3 = this_$iv.elements;
        ScatterSet this_$iv$iv = this_$iv;
        int $i$f$forEachIndex = 0;
        long[] m$iv$iv3 = this_$iv$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv3.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv3[i$iv$iv];
                arrayList = arrayList4;
                ScatterSet this_$iv2 = this_$iv;
                ScatterSet this_$iv$iv2 = this_$iv$iv;
                int $i$f$forEachIndex2 = $i$f$forEachIndex;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    start = start3;
                    $i$f$forEach = $i$f$forEach3;
                    k$iv = k$iv3;
                    m$iv$iv = m$iv$iv3;
                    arrayList4 = arrayList;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        if (!(value$iv$iv$iv < 128)) {
                            start2 = start3;
                            $i$f$forEach2 = $i$f$forEach3;
                            k$iv2 = k$iv3;
                            m$iv$iv2 = m$iv$iv3;
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            StateObject state2 = (StateObject) k$iv3[index$iv$iv];
                            $i$f$forEach2 = $i$f$forEach3;
                            StateRecord first = state2.getFirstStateRecord();
                            k$iv2 = k$iv3;
                            StateRecord current = SnapshotKt.readable(first, snapshotId, invalidSnapshots);
                            if (current != null && (previous = SnapshotKt.readable(first, getId(), start3)) != null) {
                                start2 = start3;
                                if (Intrinsics.areEqual(current, previous)) {
                                    m$iv$iv2 = m$iv$iv3;
                                } else {
                                    m$iv$iv2 = m$iv$iv3;
                                    StateRecord applied = SnapshotKt.readable(first, getId(), getInvalid());
                                    if (applied == null) {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (optimisticMerges == null || (merged = optimisticMerges.get(current)) == null) {
                                        merged = state2.mergeRecords(previous, current, applied);
                                    }
                                    if (merged == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!Intrinsics.areEqual(merged, applied)) {
                                        if (Intrinsics.areEqual(merged, current)) {
                                            if (list5 == null) {
                                                List it2 = new ArrayList();
                                                list4 = it2;
                                                list5 = it2;
                                            } else {
                                                list4 = list5;
                                            }
                                            list5.add(TuplesKt.m202to(state2, current.create()));
                                            if (arrayList == null) {
                                                arrayList3 = new ArrayList();
                                                arrayList = arrayList3;
                                            } else {
                                                arrayList3 = arrayList;
                                            }
                                            arrayList3.add(state2);
                                            list5 = list4;
                                        } else {
                                            if (list5 == null) {
                                                List it3 = new ArrayList();
                                                list3 = it3;
                                                list5 = it3;
                                            } else {
                                                list3 = list5;
                                            }
                                            list5.add(!Intrinsics.areEqual(merged, previous) ? TuplesKt.m202to(state2, merged) : TuplesKt.m202to(state2, previous.create()));
                                            list5 = list3;
                                        }
                                    }
                                }
                            } else {
                                start2 = start3;
                                m$iv$iv2 = m$iv$iv3;
                            }
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        optimisticMerges = optimisticMerges;
                        $i$f$forEach3 = $i$f$forEach2;
                        k$iv3 = k$iv2;
                        start3 = start2;
                        m$iv$iv3 = m$iv$iv2;
                    }
                    start = start3;
                    $i$f$forEach = $i$f$forEach3;
                    k$iv = k$iv3;
                    m$iv$iv = m$iv$iv3;
                    if (bitCount$iv$iv != 8) {
                        list = list5;
                        break;
                    }
                    arrayList4 = arrayList;
                }
                if (i$iv$iv != lastIndex$iv$iv) {
                    i$iv$iv++;
                    this_$iv$iv = this_$iv$iv2;
                    $i$f$forEachIndex = $i$f$forEachIndex2;
                    this_$iv = this_$iv2;
                    $i$f$forEach3 = $i$f$forEach;
                    k$iv3 = k$iv;
                    start3 = start;
                    m$iv$iv3 = m$iv$iv;
                }
            }
            if (list != null) {
                it = list;
                advance$runtime_release();
                size2 = it.size();
                for (index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Object item$iv = it.get(index$iv2);
                    Pair merged2 = (Pair) item$iv;
                    state = (StateObject) merged2.component1();
                    stateRecord = (StateRecord) merged2.component2();
                    stateRecord.setSnapshotId$runtime_release(getId());
                    lock$iv$iv = SnapshotKt.getLock();
                    synchronized (lock$iv$iv) {
                        stateRecord.setNext$runtime_release(state.getFirstStateRecord());
                        state.prependStateRecord(stateRecord);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            if (arrayList != null) {
                arrayList2 = arrayList;
                size = arrayList2.size();
                for (index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv2 = arrayList2.get(index$iv);
                    modified$runtime_release.remove((StateObject) item$iv2);
                }
                list2 = this.merged;
                if (list2 == null) {
                    listPlus = arrayList2;
                } else {
                    listPlus = CollectionsKt.plus((Collection) list2, (Iterable) arrayList2);
                }
                this.merged = listPlus;
            }
            return SnapshotApplyResult.Success.INSTANCE;
        }
        list = list5;
        arrayList = arrayList4;
        if (list != null) {
            it = list;
            advance$runtime_release();
            size2 = it.size();
            while (index$iv2 < size2) {
                Object item$iv3 = it.get(index$iv2);
                Pair merged3 = (Pair) item$iv3;
                state = (StateObject) merged3.component1();
                stateRecord = (StateRecord) merged3.component2();
                stateRecord.setSnapshotId$runtime_release(getId());
                lock$iv$iv = SnapshotKt.getLock();
                synchronized (lock$iv$iv) {
                    stateRecord.setNext$runtime_release(state.getFirstStateRecord());
                    state.prependStateRecord(stateRecord);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
        if (arrayList != null) {
            arrayList2 = arrayList;
            size = arrayList2.size();
            while (index$iv < size) {
                Object item$iv4 = arrayList2.get(index$iv);
                modified$runtime_release.remove((StateObject) item$iv4);
            }
            list2 = this.merged;
            if (list2 == null) {
                listPlus = arrayList2;
            } else {
                listPlus = CollectionsKt.plus((Collection) list2, (Iterable) arrayList2);
            }
            this.merged = listPlus;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        recordPrevious$runtime_release(getId());
        T tInvoke = block.invoke();
        if (!getApplied() && !getDisposed()) {
            int previousId = getId();
            Object lock$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv) {
                try {
                    int i = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i + 1;
                    setId$runtime_release(i);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId + 1, getId()));
        }
        return tInvoke;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int previousId$iv = getId();
        Object lock$iv$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv$iv) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
            Unit unit2 = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), previousId$iv + 1, getId()));
    }

    public final void recordPrevious$runtime_release(int id) {
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        if (handles.length == 0) {
            return;
        }
        int[] pinned = this.previousPinnedSnapshots;
        this.previousPinnedSnapshots = pinned.length == 0 ? handles : ArraysKt.plus(pinned, handles);
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int index = 0; index < length; index++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[index]);
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots) {
        Object lock$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv) {
            this.previousIds = this.previousIds.m27or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo3892recordModified$runtime_release(StateObject state) {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = ScatterSetKt.mutableScatterSetOf();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: getWriteCount$runtime_release, reason: from getter */
    public int getWriteCount() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(MutableScatterSet<StateObject> mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    /* JADX INFO: renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        this.previousIds = snapshotIdSet;
    }

    /* JADX INFO: renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        this.previousPinnedSnapshots = iArr;
    }

    /* JADX INFO: renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    /* JADX INFO: compiled from: Snapshot.kt */
    @Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m195d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
