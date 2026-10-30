package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00017B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J)\u0010!\u001a\u00020\u00052!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0003J\b\u0010#\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\u0011\"\b\b\u0000\u0010%*\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001e\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010+\u001a\u00020\rH\u0007J?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010%*\u00020\u00012\u0006\u0010 \u001a\u0002H%2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\u001d\u00100\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0003H\u0082\bJ\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, m195d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "currentMapThreadId", "", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", ExifInterface.GPS_DIRECTION_TRUE, "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "removeScopeMapIf", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            invoke2(set, snapshot);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
            this.this$0.addChanges(set);
            if (this.this$0.drainChanges()) {
                this.this$0.sendNotifications();
            }
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
            invoke2(p1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object state) {
            if (!this.this$0.isPaused) {
                MutableVector mutableVector = this.this$0.observedScopeMaps;
                SnapshotStateObserver snapshotStateObserver = this.this$0;
                synchronized (mutableVector) {
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                    Intrinsics.checkNotNull(observedScopeMap);
                    observedScopeMap.recordRead(state);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean hasValues = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return hasValues;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size$iv$iv = mutableVector.getSize();
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = mutableVector.getContent();
                    do {
                        ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                        hasValues = scopeMap.recordInvalidation(setRemoveChanges) || hasValues;
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver.sendNotifications.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                do {
                    MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        if (!snapshotStateObserver.sendingNotifications) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                MutableVector this_$iv = snapshotStateObserver.observedScopeMaps;
                                int size$iv = this_$iv.getSize();
                                if (size$iv > 0) {
                                    int i$iv = 0;
                                    Object[] content$iv = this_$iv.getContent();
                                    do {
                                        ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv[i$iv];
                                        scopeMap.notifyInvalidatedScopes();
                                        i$iv++;
                                    } while (i$iv < size$iv);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } catch (Throwable th) {
                                snapshotStateObserver.sendingNotifications = false;
                                throw th;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } while (SnapshotStateObserver.this.drainChanges());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object old;
        Collection collectionPlus;
        do {
            old = this.pendingChanges.get();
            if (old == null) {
                collectionPlus = set;
            } else if (old instanceof Set) {
                collectionPlus = CollectionsKt.listOf((Object[]) new Set[]{old, set});
            } else {
                if (!(old instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                collectionPlus = CollectionsKt.plus((Collection) old, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(this.pendingChanges, old, collectionPlus));
    }

    private final Set<Object> removeChanges() {
        Object old;
        Set<Object> set;
        Object obj;
        do {
            old = this.pendingChanges.get();
            Object objSubList = null;
            if (old == null) {
                return null;
            }
            if (old instanceof Set) {
                set = (Set) old;
                obj = null;
            } else if (old instanceof List) {
                set = (Set) ((List) old).get(0);
                if (((List) old).size() == 2) {
                    objSubList = ((List) old).get(1);
                } else if (((List) old).size() > 2) {
                    objSubList = ((List) old).subList(1, ((List) old).size());
                }
                obj = objSubList;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m12m(this.pendingChanges, old, obj));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size$iv = mutableVector.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = mutableVector.getContent();
                    do {
                        block.invoke(content$iv[i$iv]);
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> block) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int gap$iv = 0;
                int size$iv = mutableVector.getSize();
                for (int i$iv = 0; i$iv < size$iv; i$iv++) {
                    if (block.invoke(mutableVector.getContent()[i$iv]).booleanValue()) {
                        gap$iv++;
                    } else if (gap$iv > 0) {
                        mutableVector.getContent()[i$iv - gap$iv] = mutableVector.getContent()[i$iv];
                    }
                }
                ArraysKt.fill(mutableVector.getContent(), (Object) null, size$iv - gap$iv, size$iv);
                mutableVector.setSize(size$iv - gap$iv);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap scopeMap;
        synchronized (this.observedScopeMaps) {
            scopeMap = ensureMap(onValueChangedForScope);
        }
        boolean oldPaused = this.isPaused;
        ObservedScopeMap oldMap = this.currentMap;
        long oldThreadId = this.currentMapThreadId;
        if (oldThreadId != -1) {
            boolean value$iv = oldThreadId == ActualJvm_jvmKt.currentThreadId();
            if (!value$iv) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + oldThreadId + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = scopeMap;
            this.currentMapThreadId = Thread.currentThread().getId();
            scopeMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = oldMap;
            this.isPaused = oldPaused;
            this.currentMapThreadId = oldThreadId;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        boolean oldPaused = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = oldPaused;
        }
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int gap$iv$iv = 0;
            int size$iv$iv = mutableVector.getSize();
            for (int i$iv$iv = 0; i$iv$iv < size$iv$iv; i$iv$iv++) {
                ObservedScopeMap it = mutableVector.getContent()[i$iv$iv];
                it.clearScopeObservations(scope);
                if (!it.hasScopeObservations()) {
                    gap$iv$iv++;
                } else if (gap$iv$iv > 0) {
                    mutableVector.getContent()[i$iv$iv - gap$iv$iv] = mutableVector.getContent()[i$iv$iv];
                }
            }
            ArraysKt.fill(mutableVector.getContent(), (Object) null, size$iv$iv - gap$iv$iv, size$iv$iv);
            mutableVector.setSize(size$iv$iv - gap$iv$iv);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int gap$iv$iv = 0;
            int size$iv$iv = mutableVector.getSize();
            for (int i$iv$iv = 0; i$iv$iv < size$iv$iv; i$iv$iv++) {
                ObservedScopeMap scopeMap = mutableVector.getContent()[i$iv$iv];
                scopeMap.removeScopeIf(predicate);
                if (!scopeMap.hasScopeObservations()) {
                    gap$iv$iv++;
                } else if (gap$iv$iv > 0) {
                    mutableVector.getContent()[i$iv$iv - gap$iv$iv] = mutableVector.getContent()[i$iv$iv];
                }
            }
            ArraysKt.fill(mutableVector.getContent(), (Object) null, size$iv$iv - gap$iv$iv, size$iv$iv);
            mutableVector.setSize(size$iv$iv - gap$iv$iv);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size$iv$iv = mutableVector.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = mutableVector.getContent();
                do {
                    ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                    scopeMap.clear();
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap item$iv;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size$iv = mutableVector.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            ObservedScopeMap[] content$iv = mutableVector.getContent();
            while (true) {
                item$iv = content$iv[i$iv];
                if (item$iv.getOnChanged() == onChanged) {
                    break;
                }
                i$iv++;
                if (i$iv >= size$iv) {
                    item$iv = null;
                    break;
                }
            }
        } else {
            item$iv = null;
            break;
        }
        ObservedScopeMap scopeMap = item$iv;
        if (scopeMap == null) {
            Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
            ObservedScopeMap map = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
            this.observedScopeMaps.add(map);
            return map;
        }
        return scopeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SnapshotStateObserver.kt */
    @Metadata(m194d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0004J0\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)J\u0014\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J.\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020$0\u0003J\u0012\u00105\u001a\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m195d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/collection/MutableScatterSet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "hasScopeObservations", "", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "changes", "", "recordRead", DownloadUtil.CookieScheme.VALUE, "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "rereadDerivedState", "derivedState", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final MutableScatterSet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;
        private final ScopeMap<Object, Object> valueToScopes = new ScopeMap<>();
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount--;
            }
        };
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
            int i = 0;
            int i2 = 1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.scopeToValues = new MutableScatterMap<>(i, i2, defaultConstructorMarker);
            this.invalidated = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final void recordRead(Object value) {
            Object scope = this.currentScope;
            Intrinsics.checkNotNull(scope);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(scope, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, scope, mutableObjectIntMap);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00bb A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:27:0x00bd A[LOOP:0: B:10:0x0041->B:27:0x00bd, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:40:0x00d7 A[EDGE_INSN: B:40:0x00d7->B:31:0x00d7 BREAK  A[LOOP:0: B:10:0x0041->B:27:0x00bd], SYNTHETIC] */
        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int previousToken = recordedValues.put(value, currentToken, -1);
            if ((value instanceof DerivedState) && previousToken != currentToken) {
                DerivedState.Record record = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, record.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = record.getDependencies();
                ScopeMap<Object, DerivedState<?>> scopeMap = this.dependencyToDerivedStates;
                scopeMap.removeScope(value);
                ObjectIntMap<StateObject> objectIntMap = dependencies;
                int $i$f$forEachKey = 0;
                Object[] k$iv = objectIntMap.keys;
                ObjectIntMap<StateObject> objectIntMap2 = objectIntMap;
                int $i$f$forEachIndexed = 0;
                long[] m$iv$iv = objectIntMap2.metadata;
                int lastIndex$iv$iv = m$iv$iv.length - 2;
                int i$iv$iv = 0;
                if (0 <= lastIndex$iv$iv) {
                    while (true) {
                        long slot$iv$iv = m$iv$iv[i$iv$iv];
                        ObjectIntMap<StateObject> objectIntMap3 = objectIntMap;
                        int $i$f$forEachKey2 = $i$f$forEachKey;
                        ObjectIntMap<StateObject> objectIntMap4 = objectIntMap2;
                        int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
                        long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                        if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                            if (i$iv$iv != lastIndex$iv$iv) {
                                break;
                                break;
                            }
                            i$iv$iv++;
                            objectIntMap2 = objectIntMap4;
                            $i$f$forEachIndexed = $i$f$forEachIndexed2;
                            objectIntMap = objectIntMap3;
                            $i$f$forEachKey = $i$f$forEachKey2;
                        } else {
                            int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                            for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                                long value$iv$iv$iv = slot$iv$iv & 255;
                                if (value$iv$iv$iv < 128) {
                                    int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                    StateObject dependency = (StateObject) k$iv[index$iv$iv];
                                    if (dependency instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        ((StateObjectImpl) dependency).m3907recordReadInh_f27i8$runtime_release(ReaderKind.m3894constructorimpl(2));
                                    }
                                    scopeMap.add(dependency, value);
                                }
                                slot$iv$iv >>= 8;
                            }
                            if (bitCount$iv$iv != 8) {
                                break;
                            }
                            if (i$iv$iv != lastIndex$iv$iv) {
                                break;
                            }
                            i$iv$iv++;
                            objectIntMap2 = objectIntMap4;
                            $i$f$forEachIndexed = $i$f$forEachIndexed2;
                            objectIntMap = objectIntMap3;
                            $i$f$forEachKey = $i$f$forEachKey2;
                        }
                    }
                }
            }
            if (previousToken == -1) {
                if (value instanceof StateObjectImpl) {
                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                    ((StateObjectImpl) value).m3907recordReadInh_f27i8$runtime_release(ReaderKind.m3894constructorimpl(2));
                }
                this.valueToScopes.add(value, currentScope);
            }
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            Object previousScope = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int previousToken = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver observer$iv = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(observer$iv);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj = this.currentScope;
                Intrinsics.checkNotNull(obj);
                clearObsoleteStateReads(obj);
                this.currentScope = previousScope;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = previousToken;
            } catch (Throwable th) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object scope) {
            int currentToken;
            int $i$f$removeIf;
            int $i$f$removeIf2;
            int currentToken2 = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            int $i$f$removeIf3 = 0;
            MutableObjectIntMap<Object> this_$iv$iv = mutableObjectIntMap;
            long[] m$iv$iv = this_$iv$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 > lastIndex$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    currentToken = currentToken2;
                    $i$f$removeIf = $i$f$removeIf3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            currentToken2 = currentToken2;
                            $i$f$removeIf2 = $i$f$removeIf3;
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            Object value = mutableObjectIntMap.keys[index$iv$iv];
                            $i$f$removeIf2 = $i$f$removeIf3;
                            int token = mutableObjectIntMap.values[index$iv$iv];
                            boolean z = token != currentToken2;
                            boolean willRemove = z;
                            if (willRemove) {
                                removeObservation(scope, value);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(index$iv$iv);
                            }
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        $i$f$removeIf3 = $i$f$removeIf2;
                        currentToken2 = currentToken2;
                    }
                    currentToken = currentToken2;
                    $i$f$removeIf = $i$f$removeIf3;
                    if (bitCount$iv$iv != 8) {
                        return;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    return;
                }
                i$iv$iv++;
                $i$f$removeIf3 = $i$f$removeIf;
                currentToken2 = currentToken;
            }
        }

        public final void clearScopeObservations(Object scope) {
            MutableObjectIntMap recordedValues = this.scopeToValues.remove(scope);
            if (recordedValues == null) {
                return;
            }
            MutableObjectIntMap this_$iv = recordedValues;
            Object[] k$iv = this_$iv.keys;
            int[] v$iv = this_$iv.values;
            long[] m$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 > lastIndex$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                MutableObjectIntMap recordedValues2 = recordedValues;
                ObjectIntMap this_$iv2 = this_$iv;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i = 8;
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            Object value = k$iv[index$iv$iv];
                            int i2 = v$iv[index$iv$iv];
                            removeObservation(scope, value);
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
                recordedValues = recordedValues2;
                this_$iv = this_$iv2;
            }
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00e6 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:31:0x00e8 A[LOOP:2: B:17:0x0090->B:31:0x00e8, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:60:0x010f A[EDGE_INSN: B:60:0x010f->B:36:0x010f BREAK  A[LOOP:2: B:17:0x0090->B:31:0x00e8], SYNTHETIC] */
        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            int $i$f$removeIf;
            ScatterMap this_$iv$iv;
            int $i$f$forEachIndexed;
            long[] m$iv$iv;
            int lastIndex$iv$iv;
            int i$iv$iv;
            int $i$f$removeIf2;
            ScatterMap this_$iv$iv2;
            int $i$f$forEachIndexed2;
            long[] m$iv$iv2;
            int lastIndex$iv$iv2;
            int i$iv$iv2;
            long slot$iv$iv;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int $i$f$removeIf3 = 0;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> this_$iv$iv3 = mutableScatterMap;
            int $i$f$forEachIndexed3 = 0;
            long[] m$iv$iv3 = this_$iv$iv3.metadata;
            int lastIndex$iv$iv3 = m$iv$iv3.length - 2;
            int i$iv$iv3 = 0;
            if (0 > lastIndex$iv$iv3) {
                return;
            }
            while (true) {
                long slot$iv$iv2 = m$iv$iv3[i$iv$iv3];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv3 - lastIndex$iv$iv3)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv2 & 255;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv3 << 3) + j$iv$iv;
                            Object scope = mutableScatterMap.keys[index$iv$iv];
                            ObjectIntMap valueSet = (MutableObjectIntMap) mutableScatterMap.values[index$iv$iv];
                            Boolean boolInvoke = predicate.invoke(scope);
                            boolean willRemove = boolInvoke.booleanValue();
                            if (!willRemove) {
                                $i$f$removeIf2 = $i$f$removeIf3;
                                this_$iv$iv2 = this_$iv$iv3;
                                $i$f$forEachIndexed2 = $i$f$forEachIndexed3;
                                m$iv$iv2 = m$iv$iv3;
                                lastIndex$iv$iv2 = lastIndex$iv$iv3;
                                i$iv$iv2 = i$iv$iv3;
                                slot$iv$iv = slot$iv$iv2;
                            } else {
                                $i$f$removeIf2 = $i$f$removeIf3;
                                ObjectIntMap this_$iv = valueSet;
                                this_$iv$iv2 = this_$iv$iv3;
                                Object[] k$iv = this_$iv.keys;
                                $i$f$forEachIndexed2 = $i$f$forEachIndexed3;
                                int[] v$iv = this_$iv.values;
                                m$iv$iv2 = m$iv$iv3;
                                long[] m$iv$iv4 = this_$iv.metadata;
                                int lastIndex$iv$iv4 = m$iv$iv4.length - 2;
                                int i$iv$iv4 = 0;
                                if (0 <= lastIndex$iv$iv4) {
                                    while (true) {
                                        long slot$iv$iv3 = m$iv$iv4[i$iv$iv4];
                                        long[] m$iv$iv5 = m$iv$iv4;
                                        lastIndex$iv$iv2 = lastIndex$iv$iv3;
                                        slot$iv$iv = slot$iv$iv2;
                                        i$iv$iv2 = i$iv$iv3;
                                        long $this$maskEmptyOrDeleted$iv$iv$iv2 = ((~slot$iv$iv3) << 7) & slot$iv$iv3 & (-9187201950435737472L);
                                        if ($this$maskEmptyOrDeleted$iv$iv$iv2 == -9187201950435737472L) {
                                            if (i$iv$iv4 != lastIndex$iv$iv4) {
                                                break;
                                                break;
                                            }
                                            i$iv$iv4++;
                                            i$iv$iv3 = i$iv$iv2;
                                            lastIndex$iv$iv3 = lastIndex$iv$iv2;
                                            m$iv$iv4 = m$iv$iv5;
                                            slot$iv$iv2 = slot$iv$iv;
                                        } else {
                                            int bitCount$iv$iv2 = 8 - ((~(i$iv$iv4 - lastIndex$iv$iv4)) >>> 31);
                                            for (int j$iv$iv2 = 0; j$iv$iv2 < bitCount$iv$iv2; j$iv$iv2++) {
                                                long value$iv$iv$iv2 = slot$iv$iv3 & 255;
                                                if (value$iv$iv$iv2 < 128) {
                                                    int index$iv$iv2 = (i$iv$iv4 << 3) + j$iv$iv2;
                                                    Object value = k$iv[index$iv$iv2];
                                                    int i = v$iv[index$iv$iv2];
                                                    removeObservation(scope, value);
                                                }
                                                slot$iv$iv3 >>= 8;
                                            }
                                            if (bitCount$iv$iv2 != 8) {
                                                break;
                                            }
                                            if (i$iv$iv4 != lastIndex$iv$iv4) {
                                                break;
                                            }
                                            i$iv$iv4++;
                                            i$iv$iv3 = i$iv$iv2;
                                            lastIndex$iv$iv3 = lastIndex$iv$iv2;
                                            m$iv$iv4 = m$iv$iv5;
                                            slot$iv$iv2 = slot$iv$iv;
                                        }
                                    }
                                } else {
                                    lastIndex$iv$iv2 = lastIndex$iv$iv3;
                                    i$iv$iv2 = i$iv$iv3;
                                    slot$iv$iv = slot$iv$iv2;
                                }
                            }
                            if (boolInvoke.booleanValue()) {
                                mutableScatterMap.removeValueAt(index$iv$iv);
                            }
                        } else {
                            $i$f$removeIf2 = $i$f$removeIf3;
                            this_$iv$iv2 = this_$iv$iv3;
                            $i$f$forEachIndexed2 = $i$f$forEachIndexed3;
                            m$iv$iv2 = m$iv$iv3;
                            lastIndex$iv$iv2 = lastIndex$iv$iv3;
                            i$iv$iv2 = i$iv$iv3;
                            slot$iv$iv = slot$iv$iv2;
                        }
                        j$iv$iv++;
                        slot$iv$iv2 = slot$iv$iv >> 8;
                        $i$f$removeIf3 = $i$f$removeIf2;
                        this_$iv$iv3 = this_$iv$iv2;
                        $i$f$forEachIndexed3 = $i$f$forEachIndexed2;
                        m$iv$iv3 = m$iv$iv2;
                        i$iv$iv3 = i$iv$iv2;
                        lastIndex$iv$iv3 = lastIndex$iv$iv2;
                    }
                    $i$f$removeIf = $i$f$removeIf3;
                    this_$iv$iv = this_$iv$iv3;
                    $i$f$forEachIndexed = $i$f$forEachIndexed3;
                    m$iv$iv = m$iv$iv3;
                    lastIndex$iv$iv = lastIndex$iv$iv3;
                    i$iv$iv = i$iv$iv3;
                    if (bitCount$iv$iv != 8) {
                        return;
                    }
                } else {
                    $i$f$removeIf = $i$f$removeIf3;
                    this_$iv$iv = this_$iv$iv3;
                    $i$f$forEachIndexed = $i$f$forEachIndexed3;
                    m$iv$iv = m$iv$iv3;
                    lastIndex$iv$iv = lastIndex$iv$iv3;
                    i$iv$iv = i$iv$iv3;
                }
                int i$iv$iv5 = i$iv$iv;
                lastIndex$iv$iv3 = lastIndex$iv$iv;
                if (i$iv$iv5 == lastIndex$iv$iv3) {
                    return;
                }
                i$iv$iv3 = i$iv$iv5 + 1;
                $i$f$removeIf3 = $i$f$removeIf;
                this_$iv$iv3 = this_$iv$iv;
                $i$f$forEachIndexed3 = $i$f$forEachIndexed;
                m$iv$iv3 = m$iv$iv;
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if ((value instanceof DerivedState) && !this.valueToScopes.contains(value)) {
                this.dependencyToDerivedStates.removeScope(value);
                this.recordedDerivedStateValues.remove(value);
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Code duplicated, block: B:174:0x0584  */
        /* JADX WARN: Code duplicated, block: B:176:0x058c  */
        /* JADX WARN: Code duplicated, block: B:178:0x0598  */
        /* JADX WARN: Code duplicated, block: B:180:0x059c  */
        /* JADX WARN: Code duplicated, block: B:182:0x05be A[LOOP:12: B:182:0x05be->B:233:0x0760, LOOP_START, PHI: r1 r2 r3 r4 r6 r7 r9 r10 r11 r12 r13 r14 r20
  0x05be: PHI (r1v21 'k$iv$iv' java.lang.Object[]) = (r1v18 'k$iv$iv' java.lang.Object[]), (r1v22 'k$iv$iv' java.lang.Object[]) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r2v26 'lastIndex$iv$iv$iv' int) = (r2v25 'lastIndex$iv$iv$iv' int), (r2v27 'lastIndex$iv$iv$iv' int) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r3v6 java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object>) = 
  (r3v1 java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object>)
  (r3v7 java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object>)
 binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r4v11 'm$iv$iv$iv' long[]) = (r4v10 'm$iv$iv$iv' long[]), (r4v12 'm$iv$iv$iv' long[]) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r6v33 'i$iv$iv$iv' int) = (r6v32 'i$iv$iv$iv' int), (r6v34 'i$iv$iv$iv' int) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r7v18 'element$iv$iv' java.lang.Object) = (r7v2 'element$iv$iv' java.lang.Object), (r7v19 'element$iv$iv' java.lang.Object) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r9v4 int) = (r9v1 int), (r9v7 int) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r10v5 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>>) = 
  (r10v1 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>>)
  (r10v6 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>>)
 binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r11v20 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>>) = 
  (r11v2 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>>)
  (r11v25 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>>)
 binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r12v7 '$i$f$forEachScopeOf' int) = (r12v1 '$i$f$forEachScopeOf' int), (r12v8 '$i$f$forEachScopeOf' int) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r13v5 'value$iv' java.lang.Object) = (r13v3 'value$iv' java.lang.Object), (r13v6 'value$iv' java.lang.Object) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r14v8 'this_$iv$iv' androidx.collection.ScatterSet) = (r14v7 'this_$iv$iv' androidx.collection.ScatterSet), (r14v9 'this_$iv$iv' androidx.collection.ScatterSet) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]
  0x05be: PHI (r20v19 'hasValues' boolean) = (r20v15 'hasValues' boolean), (r20v20 'hasValues' boolean) binds: [B:181:0x05bc, B:233:0x0760] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:184:0x05da  */
        /* JADX WARN: Code duplicated, block: B:186:0x05e6  */
        /* JADX WARN: Code duplicated, block: B:188:0x05f1  */
        /* JADX WARN: Code duplicated, block: B:189:0x05f3  */
        /* JADX WARN: Code duplicated, block: B:191:0x05f6  */
        /* JADX WARN: Code duplicated, block: B:193:0x0617  */
        /* JADX WARN: Code duplicated, block: B:196:0x0633  */
        /* JADX WARN: Code duplicated, block: B:198:0x0643  */
        /* JADX WARN: Code duplicated, block: B:200:0x0649  */
        /* JADX WARN: Code duplicated, block: B:202:0x066a A[LOOP:14: B:202:0x066a->B:216:0x06c4, LOOP_START, PHI: r2 r3 r12 r13 r14 r20
  0x066a: PHI (r2v32 'lastIndex$iv$iv$iv' int) = (r2v28 'lastIndex$iv$iv$iv' int), (r2v37 'lastIndex$iv$iv$iv' int) binds: [B:201:0x0668, B:216:0x06c4] A[DONT_GENERATE, DONT_INLINE]
  0x066a: PHI (r3v11 java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object>) = 
  (r3v8 java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object>)
  (r3v12 java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object>)
 binds: [B:201:0x0668, B:216:0x06c4] A[DONT_GENERATE, DONT_INLINE]
  0x066a: PHI (r12v12 'm$iv$iv$iv' long[]) = (r12v11 'm$iv$iv$iv' long[]), (r12v15 'm$iv$iv$iv' long[]) binds: [B:201:0x0668, B:216:0x06c4] A[DONT_GENERATE, DONT_INLINE]
  0x066a: PHI (r13v9 'value$iv' java.lang.Object) = (r13v7 'value$iv' java.lang.Object), (r13v10 'value$iv' java.lang.Object) binds: [B:201:0x0668, B:216:0x06c4] A[DONT_GENERATE, DONT_INLINE]
  0x066a: PHI (r14v13 'i$iv$iv$iv' int) = (r14v12 'i$iv$iv$iv' int), (r14v14 'i$iv$iv$iv' int) binds: [B:201:0x0668, B:216:0x06c4] A[DONT_GENERATE, DONT_INLINE]
  0x066a: PHI (r20v24 'hasValues' boolean) = (r20v21 'hasValues' boolean), (r20v25 'hasValues' boolean) binds: [B:201:0x0668, B:216:0x06c4] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:204:0x0686  */
        /* JADX WARN: Code duplicated, block: B:206:0x0692  */
        /* JADX WARN: Code duplicated, block: B:208:0x069d  */
        /* JADX WARN: Code duplicated, block: B:209:0x069f  */
        /* JADX WARN: Code duplicated, block: B:211:0x06a2  */
        /* JADX WARN: Code duplicated, block: B:215:0x06c2 A[DONT_INVERT, PHI: r20
  0x06c2: PHI (r20v25 'hasValues' boolean) = (r20v24 'hasValues' boolean), (r20v26 'hasValues' boolean) binds: [B:203:0x0684, B:214:0x06c0] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:216:0x06c4 A[LOOP:14: B:202:0x066a->B:216:0x06c4, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:217:0x06cf  */
        /* JADX WARN: Code duplicated, block: B:220:0x06da  */
        /* JADX WARN: Code duplicated, block: B:221:0x06f0  */
        /* JADX WARN: Code duplicated, block: B:223:0x0700  */
        /* JADX WARN: Code duplicated, block: B:225:0x0717  */
        /* JADX WARN: Code duplicated, block: B:230:0x074e  */
        /* JADX WARN: Code duplicated, block: B:233:0x0760 A[LOOP:12: B:182:0x05be->B:233:0x0760, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:234:0x0778  */
        /* JADX WARN: Code duplicated, block: B:237:0x0794  */
        /* JADX WARN: Code duplicated, block: B:239:0x07bb  */
        /* JADX WARN: Code duplicated, block: B:242:0x07cf  */
        /* JADX WARN: Code duplicated, block: B:244:0x07dc  */
        /* JADX WARN: Code duplicated, block: B:246:0x07e0  */
        /* JADX WARN: Code duplicated, block: B:248:0x07fa A[LOOP:18: B:248:0x07fa->B:265:0x085d, LOOP_START, PHI: r2 r4 r6 r7 r11 r12 r20
  0x07fa: PHI (r2v16 'm$iv$iv$iv' long[]) = (r2v15 'm$iv$iv$iv' long[]), (r2v17 'm$iv$iv$iv' long[]) binds: [B:247:0x07f8, B:265:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x07fa: PHI (r4v8 'i$iv$iv$iv' int) = (r4v7 'i$iv$iv$iv' int), (r4v9 'i$iv$iv$iv' int) binds: [B:247:0x07f8, B:265:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x07fa: PHI (r6v23 androidx.compose.runtime.SnapshotMutationPolicy<?>) = (r6v22 androidx.compose.runtime.SnapshotMutationPolicy<?>), (r6v26 androidx.compose.runtime.SnapshotMutationPolicy<?>) binds: [B:247:0x07f8, B:265:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x07fa: PHI (r7v12 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object>) = 
  (r7v11 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object>)
  (r7v13 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object>)
 binds: [B:247:0x07f8, B:265:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x07fa: PHI (r11v7 'this_$iv$iv' androidx.collection.ScatterSet) = (r11v6 'this_$iv$iv' androidx.collection.ScatterSet), (r11v12 'this_$iv$iv' androidx.collection.ScatterSet) binds: [B:247:0x07f8, B:265:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x07fa: PHI (r12v3 '$i$f$forEach' int) = (r12v2 '$i$f$forEach' int), (r12v4 '$i$f$forEach' int) binds: [B:247:0x07f8, B:265:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x07fa: PHI (r20v10 'hasValues' boolean) = (r20v7 'hasValues' boolean), (r20v11 'hasValues' boolean) binds: [B:247:0x07f8, B:265:0x085d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:250:0x0816  */
        /* JADX WARN: Code duplicated, block: B:252:0x0822  */
        /* JADX WARN: Code duplicated, block: B:254:0x082d  */
        /* JADX WARN: Code duplicated, block: B:255:0x082f  */
        /* JADX WARN: Code duplicated, block: B:257:0x0832  */
        /* JADX WARN: Code duplicated, block: B:258:0x0847  */
        /* JADX WARN: Code duplicated, block: B:263:0x0859  */
        /* JADX WARN: Code duplicated, block: B:265:0x085d A[LOOP:18: B:248:0x07fa->B:265:0x085d, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:266:0x086a  */
        /* JADX WARN: Code duplicated, block: B:269:0x0877  */
        /* JADX WARN: Code duplicated, block: B:270:0x088b  */
        /* JADX WARN: Code duplicated, block: B:272:0x0897  */
        /* JADX WARN: Code duplicated, block: B:274:0x08a8  */
        /* JADX WARN: Code duplicated, block: B:276:0x08bf  */
        /* JADX WARN: Code duplicated, block: B:279:0x08dc  */
        /* JADX WARN: Code duplicated, block: B:281:0x08e0  */
        /* JADX WARN: Code duplicated, block: B:283:0x08f4 A[LOOP:16: B:283:0x08f4->B:300:0x0959, LOOP_START, PHI: r1 r2 r6 r7 r14
  0x08f4: PHI (r1v4 'hasValues' boolean) = (r1v2 'hasValues' boolean), (r1v8 'hasValues' boolean) binds: [B:282:0x08f2, B:300:0x0959] A[DONT_GENERATE, DONT_INLINE]
  0x08f4: PHI (r2v6 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object>) = 
  (r2v4 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object>)
  (r2v7 androidx.compose.runtime.collection.ScopeMap<java.lang.Object, java.lang.Object>)
 binds: [B:282:0x08f2, B:300:0x0959] A[DONT_GENERATE, DONT_INLINE]
  0x08f4: PHI (r6v10 'this_$iv$iv' androidx.collection.ScatterSet) = (r6v8 'this_$iv$iv' androidx.collection.ScatterSet), (r6v16 'this_$iv$iv' androidx.collection.ScatterSet) binds: [B:282:0x08f2, B:300:0x0959] A[DONT_GENERATE, DONT_INLINE]
  0x08f4: PHI (r7v5 '$i$f$forEach' int) = (r7v4 '$i$f$forEach' int), (r7v6 '$i$f$forEach' int) binds: [B:282:0x08f2, B:300:0x0959] A[DONT_GENERATE, DONT_INLINE]
  0x08f4: PHI (r14v1 'i$iv$iv$iv' int) = (r14v0 'i$iv$iv$iv' int), (r14v2 'i$iv$iv$iv' int) binds: [B:282:0x08f2, B:300:0x0959] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:285:0x090f  */
        /* JADX WARN: Code duplicated, block: B:287:0x091b  */
        /* JADX WARN: Code duplicated, block: B:289:0x0926  */
        /* JADX WARN: Code duplicated, block: B:290:0x0928  */
        /* JADX WARN: Code duplicated, block: B:292:0x092b  */
        /* JADX WARN: Code duplicated, block: B:296:0x094b  */
        /* JADX WARN: Code duplicated, block: B:298:0x0951  */
        /* JADX WARN: Code duplicated, block: B:300:0x0959 A[LOOP:16: B:283:0x08f4->B:300:0x0959, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:301:0x0962  */
        /* JADX WARN: Code duplicated, block: B:304:0x0971  */
        /* JADX WARN: Code duplicated, block: B:305:0x0981  */
        /* JADX WARN: Code duplicated, block: B:336:0x0249 A[EDGE_INSN: B:336:0x0249->B:73:0x0249 BREAK  A[LOOP:4: B:49:0x018e->B:63:0x01e8], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:358:0x098b A[EDGE_INSN: B:358:0x098b->B:307:0x098b BREAK  A[LOOP:16: B:283:0x08f4->B:300:0x0959], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:359:0x0790 A[EDGE_INSN: B:359:0x0790->B:236:0x0790 BREAK  A[LOOP:12: B:182:0x05be->B:233:0x0760], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:360:0x078c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:366:0x0725 A[EDGE_INSN: B:366:0x0725->B:226:0x0725 BREAK  A[LOOP:14: B:202:0x066a->B:216:0x06c4], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:368:0x0725 A[EDGE_INSN: B:368:0x0725->B:226:0x0725 BREAK  A[LOOP:14: B:202:0x066a->B:216:0x06c4], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:371:0x06b7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:372:0x094e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:375:0x093e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:376:0x08a4 A[EDGE_INSN: B:376:0x08a4->B:273:0x08a4 BREAK  A[LOOP:18: B:248:0x07fa->B:265:0x085d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:377:0x08a4 A[EDGE_INSN: B:377:0x08a4->B:273:0x08a4 BREAK  A[LOOP:18: B:248:0x07fa->B:265:0x085d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:62:0x01e6 A[DONT_INVERT, PHI: r35
  0x01e6: PHI (r35v20 'hasValues' boolean) = (r35v19 'hasValues' boolean), (r35v21 'hasValues' boolean) binds: [B:50:0x01a8, B:61:0x01e4] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:63:0x01e8 A[LOOP:4: B:49:0x018e->B:63:0x01e8, LOOP_END] */
        public final boolean recordInvalidation(Set<? extends Object> changes) {
            ScopeMap<Object, DerivedState<?>> scopeMap;
            HashMap<DerivedState<?>, Object> map;
            ScopeMap<Object, Object> scopeMap2;
            Object value$iv;
            ScatterSet this_$iv$iv;
            int $i$f$forEach;
            Object[] k$iv$iv;
            long[] m$iv$iv$iv;
            int lastIndex$iv$iv$iv;
            int i$iv$iv$iv;
            long slot$iv$iv$iv;
            boolean hasValues;
            ScopeMap<Object, Object> scopeMap3;
            ScatterSet this_$iv$iv2;
            int $i$f$forEach2;
            long $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            int bitCount$iv$iv$iv;
            int j$iv$iv$iv;
            long value$iv$iv$iv$iv;
            int $i$f$isFull;
            ScopeMap<Object, DerivedState<?>> scopeMap4;
            int $i$f$forEachScopeOf;
            Object value$iv2;
            boolean hasValues2;
            DerivedState<?> derivedState;
            Object previousValue;
            SnapshotMutationPolicy<?> policy;
            ScopeMap<Object, Object> scopeMap5;
            Object value$iv3;
            ScatterSet this_$iv$iv3;
            int $i$f$forEach3;
            Object[] k$iv$iv2;
            long[] m$iv$iv$iv2;
            int lastIndex$iv$iv$iv2;
            int i$iv$iv$iv2;
            long slot$iv$iv$iv2;
            SnapshotMutationPolicy<?> snapshotMutationPolicy;
            ScopeMap<Object, Object> scopeMap6;
            ScatterSet this_$iv$iv4;
            int $i$f$forEach4;
            long $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            long[] m$iv$iv$iv3;
            int bitCount$iv$iv$iv2;
            int j$iv$iv$iv2;
            long value$iv$iv$iv$iv2;
            int $i$f$isFull2;
            ScatterSet this_$iv$iv5;
            boolean hasValues3;
            Object[] k$iv$iv3;
            long[] m$iv$iv$iv4;
            int lastIndex$iv$iv$iv3;
            int i$iv$iv$iv3;
            long slot$iv$iv$iv3;
            int i;
            ScopeMap<Object, DerivedState<?>> scopeMap7;
            int $i$f$forEachScopeOf2;
            long $this$maskEmptyOrDeleted$iv$iv$iv$iv3;
            Object[] k$iv$iv4;
            int lastIndex$iv$iv$iv4;
            long[] m$iv$iv$iv5;
            Object element$iv$iv;
            Object value$iv4;
            ScatterSet this_$iv$iv6;
            int bitCount$iv$iv$iv3;
            int j$iv$iv$iv3;
            long value$iv$iv$iv$iv3;
            int $i$f$isFull3;
            Object[] k$iv$iv5;
            int lastIndex$iv$iv$iv5;
            HashMap<DerivedState<?>, Object> map2;
            long[] m$iv$iv$iv6;
            Object element$iv$iv2;
            Object value$iv5;
            ScatterSet this_$iv$iv7;
            DerivedState<?> derivedState2;
            Object previousValue2;
            SnapshotMutationPolicy<?> policy2;
            Object value$iv6;
            Object[] k$iv$iv6;
            long[] m$iv$iv$iv7;
            int lastIndex$iv$iv$iv6;
            int i$iv$iv$iv4;
            long slot$iv$iv$iv4;
            long[] m$iv$iv$iv8;
            int bitCount$iv$iv$iv4;
            int j$iv$iv$iv4;
            long value$iv$iv$iv$iv4;
            int $i$f$isFull4;
            ScopeMap<Object, DerivedState<?>> scopeMap8;
            ScopeMap<Object, Object> scopeMap9;
            Set $this$fastForEach$iv;
            String str;
            int i$iv$iv$iv5;
            Object[] k$iv$iv7;
            int lastIndex$iv$iv$iv7;
            ScopeMap<Object, Object> scopeMap10;
            Set $this$fastForEach$iv2;
            int bitCount$iv$iv$iv5;
            int j$iv$iv$iv5;
            String str2;
            int i$iv$iv$iv6;
            Object[] k$iv$iv8;
            int lastIndex$iv$iv$iv8;
            boolean hasValues4;
            int $i$f$forEachScopeOf3;
            Object value$iv7;
            long[] m$iv$iv$iv9;
            HashMap<DerivedState<?>, Object> map3;
            Object value$iv8;
            Object[] k$iv$iv9;
            HashMap<DerivedState<?>, Object> map4;
            ScopeMap<Object, Object> scopeMap11;
            int j$iv$iv$iv6;
            String str3;
            int i$iv$iv$iv7;
            Object value$iv9;
            Object[] k$iv$iv10;
            boolean hasValues5 = false;
            ScopeMap<Object, DerivedState<?>> scopeMap12 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map5 = this.recordedDerivedStateValues;
            ScopeMap<Object, Object> scopeMap13 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            Set $this$fastForEach$iv3 = changes;
            int $i$f$fastForEach = 0;
            String str4 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            char c = 7;
            if ($this$fastForEach$iv3 instanceof ScatterSetWrapper) {
                ScatterSet this_$iv$iv8 = ((ScatterSetWrapper) $this$fastForEach$iv3).getSet$runtime_release();
                Object[] k$iv$iv11 = this_$iv$iv8.elements;
                ScatterSet this_$iv$iv$iv = this_$iv$iv8;
                long[] m$iv$iv$iv10 = this_$iv$iv$iv.metadata;
                int lastIndex$iv$iv$iv9 = m$iv$iv$iv10.length - 2;
                int i$iv$iv$iv8 = 0;
                if (0 <= lastIndex$iv$iv$iv9) {
                    while (true) {
                        long slot$iv$iv$iv5 = m$iv$iv$iv10[i$iv$iv$iv8];
                        int $i$f$fastForEach2 = $i$f$fastForEach;
                        ScatterSet this_$iv$iv9 = this_$iv$iv8;
                        ScatterSet this_$iv$iv$iv2 = this_$iv$iv$iv;
                        long[] m$iv$iv$iv11 = m$iv$iv$iv10;
                        long $this$maskEmptyOrDeleted$iv$iv$iv$iv4 = ((~slot$iv$iv$iv5) << c) & slot$iv$iv$iv5 & (-9187201950435737472L);
                        if ($this$maskEmptyOrDeleted$iv$iv$iv$iv4 != -9187201950435737472L) {
                            int bitCount$iv$iv$iv6 = 8 - ((~(i$iv$iv$iv8 - lastIndex$iv$iv$iv9)) >>> 31);
                            int j$iv$iv$iv7 = 0;
                            while (j$iv$iv$iv7 < bitCount$iv$iv$iv6) {
                                long value$iv$iv$iv$iv5 = slot$iv$iv$iv5 & 255;
                                int $i$f$isFull5 = value$iv$iv$iv$iv5 < 128 ? 1 : 0;
                                if ($i$f$isFull5 != 0) {
                                    int index$iv$iv$iv = (i$iv$iv$iv8 << 3) + j$iv$iv$iv7;
                                    Object value = k$iv$iv11[index$iv$iv$iv];
                                    boolean hasValues6 = hasValues5;
                                    if (value instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.INSTANCE;
                                        k$iv$iv8 = k$iv$iv11;
                                        if (!((StateObjectImpl) value).m3906isReadInh_f27i8$runtime_release(ReaderKind.m3894constructorimpl(2))) {
                                            scopeMap12 = scopeMap12;
                                            scopeMap10 = scopeMap13;
                                            $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                            bitCount$iv$iv$iv5 = bitCount$iv$iv$iv6;
                                            j$iv$iv$iv5 = j$iv$iv$iv7;
                                            str2 = str4;
                                            i$iv$iv$iv6 = i$iv$iv$iv8;
                                            lastIndex$iv$iv$iv8 = lastIndex$iv$iv$iv9;
                                            hasValues5 = hasValues6;
                                        }
                                    } else {
                                        k$iv$iv8 = k$iv$iv11;
                                    }
                                    if (!scopeMap12.contains(value) || (value$iv7 = scopeMap12.getMap().get(value)) == null) {
                                        scopeMap10 = scopeMap13;
                                        $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                        bitCount$iv$iv$iv5 = bitCount$iv$iv$iv6;
                                        j$iv$iv$iv5 = j$iv$iv$iv7;
                                        str2 = str4;
                                        i$iv$iv$iv6 = i$iv$iv$iv8;
                                        lastIndex$iv$iv$iv8 = lastIndex$iv$iv$iv9;
                                        hasValues5 = hasValues6;
                                    } else if (value$iv7 instanceof MutableScatterSet) {
                                        ScatterSet this_$iv$iv10 = (MutableScatterSet) value$iv7;
                                        Object[] k$iv$iv12 = this_$iv$iv10.elements;
                                        long[] m$iv$iv$iv12 = this_$iv$iv10.metadata;
                                        int lastIndex$iv$iv$iv10 = m$iv$iv$iv12.length - 2;
                                        int i$iv$iv$iv9 = 0;
                                        if (0 <= lastIndex$iv$iv$iv10) {
                                            while (true) {
                                                long slot$iv$iv$iv6 = m$iv$iv$iv12[i$iv$iv$iv9];
                                                long[] m$iv$iv$iv13 = m$iv$iv$iv12;
                                                lastIndex$iv$iv$iv8 = lastIndex$iv$iv$iv9;
                                                $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                                bitCount$iv$iv$iv5 = bitCount$iv$iv$iv6;
                                                if ((((~slot$iv$iv$iv6) << 7) & slot$iv$iv$iv6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int bitCount$iv$iv$iv7 = 8 - ((~(i$iv$iv$iv9 - lastIndex$iv$iv$iv10)) >>> 31);
                                                    int j$iv$iv$iv8 = 0;
                                                    while (j$iv$iv$iv8 < bitCount$iv$iv$iv7) {
                                                        long value$iv$iv$iv$iv6 = slot$iv$iv$iv6 & 255;
                                                        int $i$f$isFull6 = value$iv$iv$iv$iv6 < 128 ? 1 : 0;
                                                        if ($i$f$isFull6 != 0) {
                                                            int index$iv$iv$iv2 = (i$iv$iv$iv9 << 3) + j$iv$iv$iv8;
                                                            k$iv$iv10 = k$iv$iv12;
                                                            DerivedState<?> derivedState3 = (DerivedState) k$iv$iv12[index$iv$iv$iv2];
                                                            Intrinsics.checkNotNull(derivedState3, str4);
                                                            Object previousValue3 = map5.get(derivedState3);
                                                            SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                            if (policy3 == null) {
                                                                policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                            }
                                                            SnapshotMutationPolicy<?> snapshotMutationPolicy2 = policy3;
                                                            str3 = str4;
                                                            if (snapshotMutationPolicy2.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), previousValue3)) {
                                                                map4 = map5;
                                                                scopeMap11 = scopeMap13;
                                                                j$iv$iv$iv6 = j$iv$iv$iv7;
                                                                i$iv$iv$iv7 = i$iv$iv$iv8;
                                                                value$iv9 = value$iv7;
                                                                this.statesToReread.add(derivedState3);
                                                            } else {
                                                                Object value$iv10 = scopeMap13.getMap().get(derivedState3);
                                                                if (value$iv10 == null) {
                                                                    map4 = map5;
                                                                    scopeMap11 = scopeMap13;
                                                                    j$iv$iv$iv6 = j$iv$iv$iv7;
                                                                    i$iv$iv$iv7 = i$iv$iv$iv8;
                                                                    value$iv9 = value$iv7;
                                                                } else if (value$iv10 instanceof MutableScatterSet) {
                                                                    ScatterSet this_$iv$iv11 = (MutableScatterSet) value$iv10;
                                                                    Object[] k$iv$iv13 = this_$iv$iv11.elements;
                                                                    i$iv$iv$iv7 = i$iv$iv$iv8;
                                                                    long[] m$iv$iv$iv14 = this_$iv$iv11.metadata;
                                                                    int lastIndex$iv$iv$iv11 = m$iv$iv$iv14.length - 2;
                                                                    j$iv$iv$iv6 = j$iv$iv$iv7;
                                                                    int i$iv$iv$iv10 = 0;
                                                                    if (0 <= lastIndex$iv$iv$iv11) {
                                                                        while (true) {
                                                                            long slot$iv$iv$iv7 = m$iv$iv$iv14[i$iv$iv$iv10];
                                                                            map4 = map5;
                                                                            scopeMap11 = scopeMap13;
                                                                            long[] m$iv$iv$iv15 = m$iv$iv$iv14;
                                                                            value$iv9 = value$iv7;
                                                                            long $this$maskEmptyOrDeleted$iv$iv$iv$iv5 = ((~slot$iv$iv$iv7) << 7) & slot$iv$iv$iv7 & (-9187201950435737472L);
                                                                            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv5 == -9187201950435737472L) {
                                                                                if (i$iv$iv$iv10 != lastIndex$iv$iv$iv11) {
                                                                                    break;
                                                                                    break;
                                                                                }
                                                                                i$iv$iv$iv10++;
                                                                                value$iv7 = value$iv9;
                                                                                m$iv$iv$iv14 = m$iv$iv$iv15;
                                                                                map5 = map4;
                                                                                scopeMap13 = scopeMap11;
                                                                            } else {
                                                                                int bitCount$iv$iv$iv8 = 8 - ((~(i$iv$iv$iv10 - lastIndex$iv$iv$iv11)) >>> 31);
                                                                                for (int j$iv$iv$iv9 = 0; j$iv$iv$iv9 < bitCount$iv$iv$iv8; j$iv$iv$iv9++) {
                                                                                    long value$iv$iv$iv$iv7 = slot$iv$iv$iv7 & 255;
                                                                                    int $i$f$isFull7 = value$iv$iv$iv$iv7 < 128 ? 1 : 0;
                                                                                    if ($i$f$isFull7 != 0) {
                                                                                        int index$iv$iv$iv3 = (i$iv$iv$iv10 << 3) + j$iv$iv$iv9;
                                                                                        Object scope = k$iv$iv13[index$iv$iv$iv3];
                                                                                        mutableScatterSet.add(scope);
                                                                                        hasValues6 = true;
                                                                                    }
                                                                                    slot$iv$iv$iv7 >>= 8;
                                                                                }
                                                                                if (bitCount$iv$iv$iv8 != 8) {
                                                                                    break;
                                                                                }
                                                                                if (i$iv$iv$iv10 != lastIndex$iv$iv$iv11) {
                                                                                    break;
                                                                                }
                                                                                i$iv$iv$iv10++;
                                                                                value$iv7 = value$iv9;
                                                                                m$iv$iv$iv14 = m$iv$iv$iv15;
                                                                                map5 = map4;
                                                                                scopeMap13 = scopeMap11;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        map4 = map5;
                                                                        scopeMap11 = scopeMap13;
                                                                        value$iv9 = value$iv7;
                                                                    }
                                                                } else {
                                                                    map4 = map5;
                                                                    scopeMap11 = scopeMap13;
                                                                    j$iv$iv$iv6 = j$iv$iv$iv7;
                                                                    i$iv$iv$iv7 = i$iv$iv$iv8;
                                                                    value$iv9 = value$iv7;
                                                                    mutableScatterSet.add(value$iv10);
                                                                    hasValues6 = true;
                                                                }
                                                            }
                                                        } else {
                                                            map4 = map5;
                                                            scopeMap11 = scopeMap13;
                                                            j$iv$iv$iv6 = j$iv$iv$iv7;
                                                            str3 = str4;
                                                            i$iv$iv$iv7 = i$iv$iv$iv8;
                                                            value$iv9 = value$iv7;
                                                            k$iv$iv10 = k$iv$iv12;
                                                        }
                                                        slot$iv$iv$iv6 >>= 8;
                                                        j$iv$iv$iv8++;
                                                        k$iv$iv12 = k$iv$iv10;
                                                        str4 = str3;
                                                        i$iv$iv$iv8 = i$iv$iv$iv7;
                                                        j$iv$iv$iv7 = j$iv$iv$iv6;
                                                        value$iv7 = value$iv9;
                                                        map5 = map4;
                                                        scopeMap13 = scopeMap11;
                                                    }
                                                    map3 = map5;
                                                    scopeMap10 = scopeMap13;
                                                    j$iv$iv$iv5 = j$iv$iv$iv7;
                                                    str2 = str4;
                                                    i$iv$iv$iv6 = i$iv$iv$iv8;
                                                    value$iv8 = value$iv7;
                                                    k$iv$iv9 = k$iv$iv12;
                                                    if (bitCount$iv$iv$iv7 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    map3 = map5;
                                                    scopeMap10 = scopeMap13;
                                                    j$iv$iv$iv5 = j$iv$iv$iv7;
                                                    str2 = str4;
                                                    i$iv$iv$iv6 = i$iv$iv$iv8;
                                                    value$iv8 = value$iv7;
                                                    k$iv$iv9 = k$iv$iv12;
                                                }
                                                if (i$iv$iv$iv9 == lastIndex$iv$iv$iv10) {
                                                    break;
                                                }
                                                i$iv$iv$iv9++;
                                                $this$fastForEach$iv3 = $this$fastForEach$iv2;
                                                bitCount$iv$iv$iv6 = bitCount$iv$iv$iv5;
                                                lastIndex$iv$iv$iv9 = lastIndex$iv$iv$iv8;
                                                m$iv$iv$iv12 = m$iv$iv$iv13;
                                                k$iv$iv12 = k$iv$iv9;
                                                str4 = str2;
                                                i$iv$iv$iv8 = i$iv$iv$iv6;
                                                j$iv$iv$iv7 = j$iv$iv$iv5;
                                                value$iv7 = value$iv8;
                                                map5 = map3;
                                                scopeMap13 = scopeMap10;
                                            }
                                        } else {
                                            map3 = map5;
                                            scopeMap10 = scopeMap13;
                                            $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                            bitCount$iv$iv$iv5 = bitCount$iv$iv$iv6;
                                            j$iv$iv$iv5 = j$iv$iv$iv7;
                                            str2 = str4;
                                            i$iv$iv$iv6 = i$iv$iv$iv8;
                                            lastIndex$iv$iv$iv8 = lastIndex$iv$iv$iv9;
                                        }
                                        hasValues5 = hasValues6;
                                        map5 = map3;
                                    } else {
                                        scopeMap10 = scopeMap13;
                                        $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                        bitCount$iv$iv$iv5 = bitCount$iv$iv$iv6;
                                        j$iv$iv$iv5 = j$iv$iv$iv7;
                                        str2 = str4;
                                        i$iv$iv$iv6 = i$iv$iv$iv8;
                                        lastIndex$iv$iv$iv8 = lastIndex$iv$iv$iv9;
                                        DerivedState<?> derivedState4 = (DerivedState) value$iv7;
                                        Object previousValue4 = map5.get(derivedState4);
                                        SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                                        if (policy4 == null) {
                                            policy4 = SnapshotStateKt.structuralEqualityPolicy();
                                        }
                                        if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), previousValue4)) {
                                            this.statesToReread.add(derivedState4);
                                        } else {
                                            ScopeMap<Object, Object> scopeMap14 = scopeMap10;
                                            int $i$f$forEachScopeOf4 = 0;
                                            Object value$iv11 = scopeMap14.getMap().get(derivedState4);
                                            if (value$iv11 != null) {
                                                if (value$iv11 instanceof MutableScatterSet) {
                                                    ScatterSet this_$iv$iv12 = (MutableScatterSet) value$iv11;
                                                    int $i$f$forEach5 = 0;
                                                    Object[] k$iv$iv14 = this_$iv$iv12.elements;
                                                    long[] m$iv$iv$iv16 = this_$iv$iv12.metadata;
                                                    int lastIndex$iv$iv$iv12 = m$iv$iv$iv16.length - 2;
                                                    int i$iv$iv$iv11 = 0;
                                                    if (0 <= lastIndex$iv$iv$iv12) {
                                                        while (true) {
                                                            long slot$iv$iv$iv8 = m$iv$iv$iv16[i$iv$iv$iv11];
                                                            ScopeMap<Object, Object> scopeMap15 = scopeMap14;
                                                            int $i$f$forEachScopeOf5 = $i$f$forEachScopeOf4;
                                                            ScatterSet this_$iv$iv13 = this_$iv$iv12;
                                                            int $i$f$forEach6 = $i$f$forEach5;
                                                            long $this$maskEmptyOrDeleted$iv$iv$iv$iv6 = ((~slot$iv$iv$iv8) << 7) & slot$iv$iv$iv8 & (-9187201950435737472L);
                                                            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv6 != -9187201950435737472L) {
                                                                int bitCount$iv$iv$iv9 = 8 - ((~(i$iv$iv$iv11 - lastIndex$iv$iv$iv12)) >>> 31);
                                                                int j$iv$iv$iv10 = 0;
                                                                while (j$iv$iv$iv10 < bitCount$iv$iv$iv9) {
                                                                    long value$iv$iv$iv$iv8 = slot$iv$iv$iv8 & 255;
                                                                    int $i$f$isFull8 = value$iv$iv$iv$iv8 < 128 ? 1 : 0;
                                                                    if ($i$f$isFull8 != 0) {
                                                                        int index$iv$iv$iv4 = (i$iv$iv$iv11 << 3) + j$iv$iv$iv10;
                                                                        Object scope2 = k$iv$iv14[index$iv$iv$iv4];
                                                                        mutableScatterSet.add(scope2);
                                                                        hasValues6 = true;
                                                                    }
                                                                    slot$iv$iv$iv8 >>= 8;
                                                                    j$iv$iv$iv10++;
                                                                    m$iv$iv$iv16 = m$iv$iv$iv16;
                                                                }
                                                                m$iv$iv$iv9 = m$iv$iv$iv16;
                                                                if (bitCount$iv$iv$iv9 != 8) {
                                                                    break;
                                                                }
                                                            } else {
                                                                m$iv$iv$iv9 = m$iv$iv$iv16;
                                                            }
                                                            if (i$iv$iv$iv11 == lastIndex$iv$iv$iv12) {
                                                                break;
                                                            }
                                                            i$iv$iv$iv11++;
                                                            scopeMap14 = scopeMap15;
                                                            this_$iv$iv12 = this_$iv$iv13;
                                                            $i$f$forEach5 = $i$f$forEach6;
                                                            $i$f$forEachScopeOf4 = $i$f$forEachScopeOf5;
                                                            m$iv$iv$iv16 = m$iv$iv$iv9;
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(value$iv11);
                                                    hasValues6 = true;
                                                }
                                            }
                                        }
                                        hasValues5 = hasValues6;
                                    }
                                    ScopeMap<Object, Object> scopeMap16 = scopeMap10;
                                    int $i$f$forEachScopeOf6 = 0;
                                    Object value$iv12 = scopeMap16.getMap().get(value);
                                    if (value$iv12 != null) {
                                        if (value$iv12 instanceof MutableScatterSet) {
                                            ScatterSet this_$iv$iv14 = (MutableScatterSet) value$iv12;
                                            int $i$f$forEach7 = 0;
                                            Object[] k$iv$iv15 = this_$iv$iv14.elements;
                                            long[] m$iv$iv$iv17 = this_$iv$iv14.metadata;
                                            int lastIndex$iv$iv$iv13 = m$iv$iv$iv17.length - 2;
                                            int i$iv$iv$iv12 = 0;
                                            if (0 <= lastIndex$iv$iv$iv13) {
                                                while (true) {
                                                    long slot$iv$iv$iv9 = m$iv$iv$iv17[i$iv$iv$iv12];
                                                    hasValues4 = hasValues5;
                                                    ScopeMap<Object, Object> scopeMap17 = scopeMap16;
                                                    ScatterSet this_$iv$iv15 = this_$iv$iv14;
                                                    int $i$f$forEach8 = $i$f$forEach7;
                                                    long $this$maskEmptyOrDeleted$iv$iv$iv$iv7 = ((~slot$iv$iv$iv9) << 7) & slot$iv$iv$iv9 & (-9187201950435737472L);
                                                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv7 != -9187201950435737472L) {
                                                        int bitCount$iv$iv$iv10 = 8 - ((~(i$iv$iv$iv12 - lastIndex$iv$iv$iv13)) >>> 31);
                                                        int j$iv$iv$iv11 = 0;
                                                        while (j$iv$iv$iv11 < bitCount$iv$iv$iv10) {
                                                            long value$iv$iv$iv$iv9 = slot$iv$iv$iv9 & 255;
                                                            int $i$f$isFull9 = value$iv$iv$iv$iv9 < 128 ? 1 : 0;
                                                            if ($i$f$isFull9 != 0) {
                                                                int index$iv$iv$iv5 = (i$iv$iv$iv12 << 3) + j$iv$iv$iv11;
                                                                Object scope3 = k$iv$iv15[index$iv$iv$iv5];
                                                                mutableScatterSet.add(scope3);
                                                                hasValues4 = true;
                                                            }
                                                            slot$iv$iv$iv9 >>= 8;
                                                            j$iv$iv$iv11++;
                                                            $i$f$forEachScopeOf6 = $i$f$forEachScopeOf6;
                                                        }
                                                        $i$f$forEachScopeOf3 = $i$f$forEachScopeOf6;
                                                        if (bitCount$iv$iv$iv10 != 8) {
                                                            break;
                                                        }
                                                        hasValues5 = hasValues4;
                                                    } else {
                                                        $i$f$forEachScopeOf3 = $i$f$forEachScopeOf6;
                                                        hasValues5 = hasValues4;
                                                    }
                                                    if (i$iv$iv$iv12 != lastIndex$iv$iv$iv13) {
                                                        i$iv$iv$iv12++;
                                                        scopeMap16 = scopeMap17;
                                                        this_$iv$iv14 = this_$iv$iv15;
                                                        $i$f$forEach7 = $i$f$forEach8;
                                                        $i$f$forEachScopeOf6 = $i$f$forEachScopeOf3;
                                                    }
                                                }
                                                hasValues5 = hasValues4;
                                            }
                                            hasValues4 = hasValues5;
                                            hasValues5 = hasValues4;
                                        } else {
                                            mutableScatterSet.add(value$iv12);
                                            hasValues5 = true;
                                        }
                                    }
                                } else {
                                    scopeMap12 = scopeMap12;
                                    scopeMap10 = scopeMap13;
                                    $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                    bitCount$iv$iv$iv5 = bitCount$iv$iv$iv6;
                                    j$iv$iv$iv5 = j$iv$iv$iv7;
                                    str2 = str4;
                                    i$iv$iv$iv6 = i$iv$iv$iv8;
                                    k$iv$iv8 = k$iv$iv11;
                                    lastIndex$iv$iv$iv8 = lastIndex$iv$iv$iv9;
                                }
                                slot$iv$iv$iv5 >>= 8;
                                j$iv$iv$iv7 = j$iv$iv$iv5 + 1;
                                k$iv$iv11 = k$iv$iv8;
                                scopeMap12 = scopeMap12;
                                $this$fastForEach$iv3 = $this$fastForEach$iv2;
                                bitCount$iv$iv$iv6 = bitCount$iv$iv$iv5;
                                lastIndex$iv$iv$iv9 = lastIndex$iv$iv$iv8;
                                str4 = str2;
                                i$iv$iv$iv8 = i$iv$iv$iv6;
                                scopeMap13 = scopeMap10;
                            }
                            scopeMap8 = scopeMap12;
                            scopeMap9 = scopeMap13;
                            $this$fastForEach$iv = $this$fastForEach$iv3;
                            str = str4;
                            i$iv$iv$iv5 = i$iv$iv$iv8;
                            k$iv$iv7 = k$iv$iv11;
                            lastIndex$iv$iv$iv7 = lastIndex$iv$iv$iv9;
                            if (bitCount$iv$iv$iv6 != 8) {
                                break;
                            }
                        } else {
                            scopeMap8 = scopeMap12;
                            scopeMap9 = scopeMap13;
                            $this$fastForEach$iv = $this$fastForEach$iv3;
                            str = str4;
                            i$iv$iv$iv5 = i$iv$iv$iv8;
                            k$iv$iv7 = k$iv$iv11;
                            lastIndex$iv$iv$iv7 = lastIndex$iv$iv$iv9;
                        }
                        lastIndex$iv$iv$iv9 = lastIndex$iv$iv$iv7;
                        int i$iv$iv$iv13 = i$iv$iv$iv5;
                        if (i$iv$iv$iv13 == lastIndex$iv$iv$iv9) {
                            break;
                        }
                        i$iv$iv$iv8 = i$iv$iv$iv13 + 1;
                        this_$iv$iv$iv = this_$iv$iv$iv2;
                        m$iv$iv$iv10 = m$iv$iv$iv11;
                        $i$f$fastForEach = $i$f$fastForEach2;
                        this_$iv$iv8 = this_$iv$iv9;
                        k$iv$iv11 = k$iv$iv7;
                        scopeMap12 = scopeMap8;
                        $this$fastForEach$iv3 = $this$fastForEach$iv;
                        str4 = str;
                        scopeMap13 = scopeMap9;
                        c = 7;
                    }
                }
            } else {
                ScopeMap<Object, DerivedState<?>> scopeMap18 = scopeMap12;
                Set $this$forEach$iv$iv = $this$fastForEach$iv3;
                int $i$f$forEach9 = 0;
                Iterator it = $this$forEach$iv$iv.iterator();
                while (it.hasNext()) {
                    Object element$iv$iv3 = it.next();
                    int i2 = 0;
                    if (element$iv$iv3 instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                        if (((StateObjectImpl) element$iv$iv3).m3906isReadInh_f27i8$runtime_release(ReaderKind.m3894constructorimpl(2))) {
                            scopeMap = scopeMap18;
                            if (scopeMap.contains(element$iv$iv3)) {
                                scopeMap4 = scopeMap;
                                $i$f$forEachScopeOf = 0;
                                value$iv2 = scopeMap4.getMap().get(element$iv$iv3);
                                if (value$iv2 != null) {
                                    map = map5;
                                    scopeMap18 = scopeMap;
                                } else if (value$iv2 instanceof MutableScatterSet) {
                                    this_$iv$iv5 = (MutableScatterSet) value$iv2;
                                    hasValues3 = hasValues5;
                                    k$iv$iv3 = this_$iv$iv5.elements;
                                    m$iv$iv$iv4 = this_$iv$iv5.metadata;
                                    lastIndex$iv$iv$iv3 = m$iv$iv$iv4.length - 2;
                                    i$iv$iv$iv3 = 0;
                                    if (0 <= lastIndex$iv$iv$iv3) {
                                        while (true) {
                                            slot$iv$iv$iv3 = m$iv$iv$iv4[i$iv$iv$iv3];
                                            i = i2;
                                            scopeMap18 = scopeMap;
                                            scopeMap7 = scopeMap4;
                                            $i$f$forEachScopeOf2 = $i$f$forEachScopeOf;
                                            $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = ((~slot$iv$iv$iv3) << 7) & slot$iv$iv$iv3 & (-9187201950435737472L);
                                            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv3 != -9187201950435737472L) {
                                                bitCount$iv$iv$iv3 = 8 - ((~(i$iv$iv$iv3 - lastIndex$iv$iv$iv3)) >>> 31);
                                                j$iv$iv$iv3 = 0;
                                                while (j$iv$iv$iv3 < bitCount$iv$iv$iv3) {
                                                    value$iv$iv$iv$iv3 = slot$iv$iv$iv3 & 255;
                                                    if (value$iv$iv$iv$iv3 < 128) {
                                                        $i$f$isFull3 = 1;
                                                    } else {
                                                        $i$f$isFull3 = 0;
                                                    }
                                                    if ($i$f$isFull3 != 0) {
                                                        int index$iv$iv$iv6 = (i$iv$iv$iv3 << 3) + j$iv$iv$iv3;
                                                        k$iv$iv5 = k$iv$iv3;
                                                        derivedState2 = (DerivedState) k$iv$iv3[index$iv$iv$iv6];
                                                        m$iv$iv$iv6 = m$iv$iv$iv4;
                                                        Intrinsics.checkNotNull(derivedState2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                        previousValue2 = map5.get(derivedState2);
                                                        policy2 = derivedState2.getPolicy();
                                                        if (policy2 == null) {
                                                            policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                                        }
                                                        element$iv$iv2 = element$iv$iv3;
                                                        if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), previousValue2)) {
                                                            lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                            map2 = map5;
                                                            value$iv5 = value$iv2;
                                                            this_$iv$iv7 = this_$iv$iv5;
                                                            this.statesToReread.add(derivedState2);
                                                        } else {
                                                            value$iv6 = scopeMap13.getMap().get(derivedState2);
                                                            if (value$iv6 != null) {
                                                                lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                                map2 = map5;
                                                                value$iv5 = value$iv2;
                                                                this_$iv$iv7 = this_$iv$iv5;
                                                            } else if (value$iv6 instanceof MutableScatterSet) {
                                                                ScatterSet this_$iv$iv16 = (MutableScatterSet) value$iv6;
                                                                k$iv$iv6 = this_$iv$iv16.elements;
                                                                m$iv$iv$iv7 = this_$iv$iv16.metadata;
                                                                lastIndex$iv$iv$iv6 = m$iv$iv$iv7.length - 2;
                                                                this_$iv$iv7 = this_$iv$iv5;
                                                                i$iv$iv$iv4 = 0;
                                                                if (0 <= lastIndex$iv$iv$iv6) {
                                                                    while (true) {
                                                                        slot$iv$iv$iv4 = m$iv$iv$iv7[i$iv$iv$iv4];
                                                                        map2 = map5;
                                                                        m$iv$iv$iv8 = m$iv$iv$iv7;
                                                                        value$iv5 = value$iv2;
                                                                        lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                                        if ((((~slot$iv$iv$iv4) << 7) & slot$iv$iv$iv4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                            if (i$iv$iv$iv4 != lastIndex$iv$iv$iv6) {
                                                                                break;
                                                                                break;
                                                                            }
                                                                            i$iv$iv$iv4++;
                                                                            lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv5;
                                                                            value$iv2 = value$iv5;
                                                                            m$iv$iv$iv7 = m$iv$iv$iv8;
                                                                            map5 = map2;
                                                                        } else {
                                                                            bitCount$iv$iv$iv4 = 8 - ((~(i$iv$iv$iv4 - lastIndex$iv$iv$iv6)) >>> 31);
                                                                            for (j$iv$iv$iv4 = 0; j$iv$iv$iv4 < bitCount$iv$iv$iv4; j$iv$iv$iv4++) {
                                                                                value$iv$iv$iv$iv4 = slot$iv$iv$iv4 & 255;
                                                                                if (value$iv$iv$iv$iv4 < 128) {
                                                                                    $i$f$isFull4 = 1;
                                                                                } else {
                                                                                    $i$f$isFull4 = 0;
                                                                                }
                                                                                if ($i$f$isFull4 != 0) {
                                                                                    int index$iv$iv$iv7 = (i$iv$iv$iv4 << 3) + j$iv$iv$iv4;
                                                                                    Object scope4 = k$iv$iv6[index$iv$iv$iv7];
                                                                                    mutableScatterSet.add(scope4);
                                                                                    hasValues3 = true;
                                                                                }
                                                                                slot$iv$iv$iv4 >>= 8;
                                                                            }
                                                                            if (bitCount$iv$iv$iv4 == 8) {
                                                                                break;
                                                                            }
                                                                            if (i$iv$iv$iv4 != lastIndex$iv$iv$iv6) {
                                                                                break;
                                                                            }
                                                                            i$iv$iv$iv4++;
                                                                            lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv5;
                                                                            value$iv2 = value$iv5;
                                                                            m$iv$iv$iv7 = m$iv$iv$iv8;
                                                                            map5 = map2;
                                                                        }
                                                                    }
                                                                } else {
                                                                    lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                                    map2 = map5;
                                                                    value$iv5 = value$iv2;
                                                                }
                                                            } else {
                                                                lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                                map2 = map5;
                                                                value$iv5 = value$iv2;
                                                                this_$iv$iv7 = this_$iv$iv5;
                                                                mutableScatterSet.add(value$iv6);
                                                                hasValues3 = true;
                                                            }
                                                        }
                                                    } else {
                                                        k$iv$iv5 = k$iv$iv3;
                                                        lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                        map2 = map5;
                                                        m$iv$iv$iv6 = m$iv$iv$iv4;
                                                        element$iv$iv2 = element$iv$iv3;
                                                        value$iv5 = value$iv2;
                                                        this_$iv$iv7 = this_$iv$iv5;
                                                    }
                                                    slot$iv$iv$iv3 >>= 8;
                                                    j$iv$iv$iv3++;
                                                    k$iv$iv3 = k$iv$iv5;
                                                    m$iv$iv$iv4 = m$iv$iv$iv6;
                                                    element$iv$iv3 = element$iv$iv2;
                                                    this_$iv$iv5 = this_$iv$iv7;
                                                    lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv5;
                                                    value$iv2 = value$iv5;
                                                    map5 = map2;
                                                }
                                                k$iv$iv4 = k$iv$iv3;
                                                lastIndex$iv$iv$iv4 = lastIndex$iv$iv$iv3;
                                                map = map5;
                                                m$iv$iv$iv5 = m$iv$iv$iv4;
                                                element$iv$iv = element$iv$iv3;
                                                value$iv4 = value$iv2;
                                                this_$iv$iv6 = this_$iv$iv5;
                                                if (bitCount$iv$iv$iv3 == 8) {
                                                    break;
                                                }
                                            } else {
                                                k$iv$iv4 = k$iv$iv3;
                                                lastIndex$iv$iv$iv4 = lastIndex$iv$iv$iv3;
                                                map = map5;
                                                m$iv$iv$iv5 = m$iv$iv$iv4;
                                                element$iv$iv = element$iv$iv3;
                                                value$iv4 = value$iv2;
                                                this_$iv$iv6 = this_$iv$iv5;
                                            }
                                            lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv4;
                                            if (i$iv$iv$iv3 != lastIndex$iv$iv$iv3) {
                                                i$iv$iv$iv3++;
                                                i2 = i;
                                                scopeMap4 = scopeMap7;
                                                $i$f$forEachScopeOf = $i$f$forEachScopeOf2;
                                                k$iv$iv3 = k$iv$iv4;
                                                m$iv$iv$iv4 = m$iv$iv$iv5;
                                                element$iv$iv3 = element$iv$iv;
                                                scopeMap = scopeMap18;
                                                this_$iv$iv5 = this_$iv$iv6;
                                                value$iv2 = value$iv4;
                                                map5 = map;
                                            }
                                        }
                                        hasValues5 = hasValues3;
                                    } else {
                                        map = map5;
                                        scopeMap18 = scopeMap;
                                    }
                                    hasValues3 = hasValues3;
                                    hasValues5 = hasValues3;
                                } else {
                                    hasValues2 = hasValues5;
                                    scopeMap18 = scopeMap;
                                    derivedState = (DerivedState) value$iv2;
                                    previousValue = map5.get(derivedState);
                                    policy = derivedState.getPolicy();
                                    if (policy == null) {
                                        policy = SnapshotStateKt.structuralEqualityPolicy();
                                    }
                                    if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), previousValue)) {
                                        map = map5;
                                        this.statesToReread.add(derivedState);
                                    } else {
                                        scopeMap5 = scopeMap13;
                                        value$iv3 = scopeMap5.getMap().get(derivedState);
                                        if (value$iv3 != null) {
                                            map = map5;
                                        } else if (value$iv3 instanceof MutableScatterSet) {
                                            this_$iv$iv3 = (MutableScatterSet) value$iv3;
                                            $i$f$forEach3 = 0;
                                            k$iv$iv2 = this_$iv$iv3.elements;
                                            m$iv$iv$iv2 = this_$iv$iv3.metadata;
                                            map = map5;
                                            lastIndex$iv$iv$iv2 = m$iv$iv$iv2.length - 2;
                                            i$iv$iv$iv2 = 0;
                                            if (0 <= lastIndex$iv$iv$iv2) {
                                                while (true) {
                                                    slot$iv$iv$iv2 = m$iv$iv$iv2[i$iv$iv$iv2];
                                                    snapshotMutationPolicy = policy;
                                                    scopeMap6 = scopeMap5;
                                                    this_$iv$iv4 = this_$iv$iv3;
                                                    $i$f$forEach4 = $i$f$forEach3;
                                                    $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = ((~slot$iv$iv$iv2) << 7) & slot$iv$iv$iv2 & (-9187201950435737472L);
                                                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv2 != -9187201950435737472L) {
                                                        bitCount$iv$iv$iv2 = 8 - ((~(i$iv$iv$iv2 - lastIndex$iv$iv$iv2)) >>> 31);
                                                        j$iv$iv$iv2 = 0;
                                                        while (j$iv$iv$iv2 < bitCount$iv$iv$iv2) {
                                                            value$iv$iv$iv$iv2 = slot$iv$iv$iv2 & 255;
                                                            if (value$iv$iv$iv$iv2 < 128) {
                                                                $i$f$isFull2 = 1;
                                                            } else {
                                                                $i$f$isFull2 = 0;
                                                            }
                                                            if ($i$f$isFull2 != 0) {
                                                                int index$iv$iv$iv8 = (i$iv$iv$iv2 << 3) + j$iv$iv$iv2;
                                                                Object scope5 = k$iv$iv2[index$iv$iv$iv8];
                                                                mutableScatterSet.add(scope5);
                                                                hasValues2 = true;
                                                            }
                                                            slot$iv$iv$iv2 >>= 8;
                                                            j$iv$iv$iv2++;
                                                            m$iv$iv$iv2 = m$iv$iv$iv2;
                                                        }
                                                        m$iv$iv$iv3 = m$iv$iv$iv2;
                                                        if (bitCount$iv$iv$iv2 == 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        m$iv$iv$iv3 = m$iv$iv$iv2;
                                                    }
                                                    if (i$iv$iv$iv2 != lastIndex$iv$iv$iv2) {
                                                        break;
                                                    }
                                                    i$iv$iv$iv2++;
                                                    this_$iv$iv3 = this_$iv$iv4;
                                                    $i$f$forEach3 = $i$f$forEach4;
                                                    policy = snapshotMutationPolicy;
                                                    scopeMap5 = scopeMap6;
                                                    m$iv$iv$iv2 = m$iv$iv$iv3;
                                                }
                                            }
                                        } else {
                                            map = map5;
                                            mutableScatterSet.add(value$iv3);
                                            hasValues2 = true;
                                        }
                                    }
                                    hasValues5 = hasValues2;
                                }
                            } else {
                                map = map5;
                                scopeMap18 = scopeMap;
                            }
                            scopeMap2 = scopeMap13;
                            value$iv = scopeMap2.getMap().get(element$iv$iv3);
                            if (value$iv == null) {
                                if (value$iv instanceof MutableScatterSet) {
                                    this_$iv$iv = (MutableScatterSet) value$iv;
                                    $i$f$forEach = 0;
                                    k$iv$iv = this_$iv$iv.elements;
                                    m$iv$iv$iv = this_$iv$iv.metadata;
                                    lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
                                    i$iv$iv$iv = 0;
                                    if (0 <= lastIndex$iv$iv$iv) {
                                        while (true) {
                                            slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                                            hasValues = hasValues5;
                                            scopeMap3 = scopeMap2;
                                            this_$iv$iv2 = this_$iv$iv;
                                            $i$f$forEach2 = $i$f$forEach;
                                            $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                                            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                                                bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                                                for (j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                                                    value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                                                    if (value$iv$iv$iv$iv < 128) {
                                                        $i$f$isFull = 1;
                                                    } else {
                                                        $i$f$isFull = 0;
                                                    }
                                                    if ($i$f$isFull != 0) {
                                                        int index$iv$iv$iv9 = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                                                        Object scope6 = k$iv$iv[index$iv$iv$iv9];
                                                        mutableScatterSet.add(scope6);
                                                        hasValues = true;
                                                    }
                                                    slot$iv$iv$iv >>= 8;
                                                }
                                                if (bitCount$iv$iv$iv == 8) {
                                                    hasValues5 = hasValues;
                                                    break;
                                                }
                                                hasValues5 = hasValues;
                                            } else {
                                                hasValues5 = hasValues;
                                            }
                                            if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                                                break;
                                            }
                                            i$iv$iv$iv++;
                                            scopeMap2 = scopeMap3;
                                            this_$iv$iv = this_$iv$iv2;
                                            $i$f$forEach = $i$f$forEach2;
                                        }
                                    }
                                } else {
                                    mutableScatterSet.add(value$iv);
                                    hasValues5 = true;
                                }
                            }
                        } else {
                            $this$forEach$iv$iv = $this$forEach$iv$iv;
                            map = map5;
                            $i$f$forEach9 = $i$f$forEach9;
                            it = it;
                        }
                    } else {
                        scopeMap = scopeMap18;
                        if (scopeMap.contains(element$iv$iv3)) {
                            scopeMap4 = scopeMap;
                            $i$f$forEachScopeOf = 0;
                            value$iv2 = scopeMap4.getMap().get(element$iv$iv3);
                            if (value$iv2 != null) {
                                map = map5;
                                scopeMap18 = scopeMap;
                            } else if (value$iv2 instanceof MutableScatterSet) {
                                this_$iv$iv5 = (MutableScatterSet) value$iv2;
                                hasValues3 = hasValues5;
                                k$iv$iv3 = this_$iv$iv5.elements;
                                m$iv$iv$iv4 = this_$iv$iv5.metadata;
                                lastIndex$iv$iv$iv3 = m$iv$iv$iv4.length - 2;
                                i$iv$iv$iv3 = 0;
                                if (0 <= lastIndex$iv$iv$iv3) {
                                    while (true) {
                                        slot$iv$iv$iv3 = m$iv$iv$iv4[i$iv$iv$iv3];
                                        i = i2;
                                        scopeMap18 = scopeMap;
                                        scopeMap7 = scopeMap4;
                                        $i$f$forEachScopeOf2 = $i$f$forEachScopeOf;
                                        $this$maskEmptyOrDeleted$iv$iv$iv$iv3 = ((~slot$iv$iv$iv3) << 7) & slot$iv$iv$iv3 & (-9187201950435737472L);
                                        if ($this$maskEmptyOrDeleted$iv$iv$iv$iv3 != -9187201950435737472L) {
                                            bitCount$iv$iv$iv3 = 8 - ((~(i$iv$iv$iv3 - lastIndex$iv$iv$iv3)) >>> 31);
                                            j$iv$iv$iv3 = 0;
                                            while (j$iv$iv$iv3 < bitCount$iv$iv$iv3) {
                                                value$iv$iv$iv$iv3 = slot$iv$iv$iv3 & 255;
                                                if (value$iv$iv$iv$iv3 < 128) {
                                                    $i$f$isFull3 = 1;
                                                } else {
                                                    $i$f$isFull3 = 0;
                                                }
                                                if ($i$f$isFull3 != 0) {
                                                    int index$iv$iv$iv10 = (i$iv$iv$iv3 << 3) + j$iv$iv$iv3;
                                                    k$iv$iv5 = k$iv$iv3;
                                                    derivedState2 = (DerivedState) k$iv$iv3[index$iv$iv$iv10];
                                                    m$iv$iv$iv6 = m$iv$iv$iv4;
                                                    Intrinsics.checkNotNull(derivedState2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                    previousValue2 = map5.get(derivedState2);
                                                    policy2 = derivedState2.getPolicy();
                                                    if (policy2 == null) {
                                                        policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                                    }
                                                    element$iv$iv2 = element$iv$iv3;
                                                    if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), previousValue2)) {
                                                        value$iv6 = scopeMap13.getMap().get(derivedState2);
                                                        if (value$iv6 != null) {
                                                            lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                            map2 = map5;
                                                            value$iv5 = value$iv2;
                                                            this_$iv$iv7 = this_$iv$iv5;
                                                        } else if (value$iv6 instanceof MutableScatterSet) {
                                                            ScatterSet this_$iv$iv17 = (MutableScatterSet) value$iv6;
                                                            k$iv$iv6 = this_$iv$iv17.elements;
                                                            m$iv$iv$iv7 = this_$iv$iv17.metadata;
                                                            lastIndex$iv$iv$iv6 = m$iv$iv$iv7.length - 2;
                                                            this_$iv$iv7 = this_$iv$iv5;
                                                            i$iv$iv$iv4 = 0;
                                                            if (0 <= lastIndex$iv$iv$iv6) {
                                                                while (true) {
                                                                    slot$iv$iv$iv4 = m$iv$iv$iv7[i$iv$iv$iv4];
                                                                    map2 = map5;
                                                                    m$iv$iv$iv8 = m$iv$iv$iv7;
                                                                    value$iv5 = value$iv2;
                                                                    lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                                    if ((((~slot$iv$iv$iv4) << 7) & slot$iv$iv$iv4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        if (i$iv$iv$iv4 != lastIndex$iv$iv$iv6) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i$iv$iv$iv4++;
                                                                        lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv5;
                                                                        value$iv2 = value$iv5;
                                                                        m$iv$iv$iv7 = m$iv$iv$iv8;
                                                                        map5 = map2;
                                                                    } else {
                                                                        bitCount$iv$iv$iv4 = 8 - ((~(i$iv$iv$iv4 - lastIndex$iv$iv$iv6)) >>> 31);
                                                                        while (j$iv$iv$iv4 < bitCount$iv$iv$iv4) {
                                                                            value$iv$iv$iv$iv4 = slot$iv$iv$iv4 & 255;
                                                                            if (value$iv$iv$iv$iv4 < 128) {
                                                                                $i$f$isFull4 = 1;
                                                                            } else {
                                                                                $i$f$isFull4 = 0;
                                                                            }
                                                                            if ($i$f$isFull4 != 0) {
                                                                                int index$iv$iv$iv11 = (i$iv$iv$iv4 << 3) + j$iv$iv$iv4;
                                                                                Object scope7 = k$iv$iv6[index$iv$iv$iv11];
                                                                                mutableScatterSet.add(scope7);
                                                                                hasValues3 = true;
                                                                            }
                                                                            slot$iv$iv$iv4 >>= 8;
                                                                        }
                                                                        if (bitCount$iv$iv$iv4 == 8) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        if (i$iv$iv$iv4 != lastIndex$iv$iv$iv6) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i$iv$iv$iv4++;
                                                                        lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv5;
                                                                        value$iv2 = value$iv5;
                                                                        m$iv$iv$iv7 = m$iv$iv$iv8;
                                                                        map5 = map2;
                                                                    }
                                                                }
                                                            } else {
                                                                lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                                map2 = map5;
                                                                value$iv5 = value$iv2;
                                                            }
                                                        } else {
                                                            lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                            map2 = map5;
                                                            value$iv5 = value$iv2;
                                                            this_$iv$iv7 = this_$iv$iv5;
                                                            mutableScatterSet.add(value$iv6);
                                                            hasValues3 = true;
                                                        }
                                                    } else {
                                                        lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                        map2 = map5;
                                                        value$iv5 = value$iv2;
                                                        this_$iv$iv7 = this_$iv$iv5;
                                                        this.statesToReread.add(derivedState2);
                                                    }
                                                } else {
                                                    k$iv$iv5 = k$iv$iv3;
                                                    lastIndex$iv$iv$iv5 = lastIndex$iv$iv$iv3;
                                                    map2 = map5;
                                                    m$iv$iv$iv6 = m$iv$iv$iv4;
                                                    element$iv$iv2 = element$iv$iv3;
                                                    value$iv5 = value$iv2;
                                                    this_$iv$iv7 = this_$iv$iv5;
                                                }
                                                slot$iv$iv$iv3 >>= 8;
                                                j$iv$iv$iv3++;
                                                k$iv$iv3 = k$iv$iv5;
                                                m$iv$iv$iv4 = m$iv$iv$iv6;
                                                element$iv$iv3 = element$iv$iv2;
                                                this_$iv$iv5 = this_$iv$iv7;
                                                lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv5;
                                                value$iv2 = value$iv5;
                                                map5 = map2;
                                            }
                                            k$iv$iv4 = k$iv$iv3;
                                            lastIndex$iv$iv$iv4 = lastIndex$iv$iv$iv3;
                                            map = map5;
                                            m$iv$iv$iv5 = m$iv$iv$iv4;
                                            element$iv$iv = element$iv$iv3;
                                            value$iv4 = value$iv2;
                                            this_$iv$iv6 = this_$iv$iv5;
                                            if (bitCount$iv$iv$iv3 == 8) {
                                                break;
                                                break;
                                            }
                                        } else {
                                            k$iv$iv4 = k$iv$iv3;
                                            lastIndex$iv$iv$iv4 = lastIndex$iv$iv$iv3;
                                            map = map5;
                                            m$iv$iv$iv5 = m$iv$iv$iv4;
                                            element$iv$iv = element$iv$iv3;
                                            value$iv4 = value$iv2;
                                            this_$iv$iv6 = this_$iv$iv5;
                                        }
                                        lastIndex$iv$iv$iv3 = lastIndex$iv$iv$iv4;
                                        if (i$iv$iv$iv3 != lastIndex$iv$iv$iv3) {
                                            i$iv$iv$iv3++;
                                            i2 = i;
                                            scopeMap4 = scopeMap7;
                                            $i$f$forEachScopeOf = $i$f$forEachScopeOf2;
                                            k$iv$iv3 = k$iv$iv4;
                                            m$iv$iv$iv4 = m$iv$iv$iv5;
                                            element$iv$iv3 = element$iv$iv;
                                            scopeMap = scopeMap18;
                                            this_$iv$iv5 = this_$iv$iv6;
                                            value$iv2 = value$iv4;
                                            map5 = map;
                                        }
                                    }
                                    hasValues5 = hasValues3;
                                } else {
                                    map = map5;
                                    scopeMap18 = scopeMap;
                                }
                                hasValues3 = hasValues3;
                                hasValues5 = hasValues3;
                            } else {
                                hasValues2 = hasValues5;
                                scopeMap18 = scopeMap;
                                derivedState = (DerivedState) value$iv2;
                                previousValue = map5.get(derivedState);
                                policy = derivedState.getPolicy();
                                if (policy == null) {
                                    policy = SnapshotStateKt.structuralEqualityPolicy();
                                }
                                if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), previousValue)) {
                                    scopeMap5 = scopeMap13;
                                    value$iv3 = scopeMap5.getMap().get(derivedState);
                                    if (value$iv3 != null) {
                                        map = map5;
                                    } else if (value$iv3 instanceof MutableScatterSet) {
                                        this_$iv$iv3 = (MutableScatterSet) value$iv3;
                                        $i$f$forEach3 = 0;
                                        k$iv$iv2 = this_$iv$iv3.elements;
                                        m$iv$iv$iv2 = this_$iv$iv3.metadata;
                                        map = map5;
                                        lastIndex$iv$iv$iv2 = m$iv$iv$iv2.length - 2;
                                        i$iv$iv$iv2 = 0;
                                        if (0 <= lastIndex$iv$iv$iv2) {
                                            while (true) {
                                                slot$iv$iv$iv2 = m$iv$iv$iv2[i$iv$iv$iv2];
                                                snapshotMutationPolicy = policy;
                                                scopeMap6 = scopeMap5;
                                                this_$iv$iv4 = this_$iv$iv3;
                                                $i$f$forEach4 = $i$f$forEach3;
                                                $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = ((~slot$iv$iv$iv2) << 7) & slot$iv$iv$iv2 & (-9187201950435737472L);
                                                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv2 != -9187201950435737472L) {
                                                    bitCount$iv$iv$iv2 = 8 - ((~(i$iv$iv$iv2 - lastIndex$iv$iv$iv2)) >>> 31);
                                                    j$iv$iv$iv2 = 0;
                                                    while (j$iv$iv$iv2 < bitCount$iv$iv$iv2) {
                                                        value$iv$iv$iv$iv2 = slot$iv$iv$iv2 & 255;
                                                        if (value$iv$iv$iv$iv2 < 128) {
                                                            $i$f$isFull2 = 1;
                                                        } else {
                                                            $i$f$isFull2 = 0;
                                                        }
                                                        if ($i$f$isFull2 != 0) {
                                                            int index$iv$iv$iv12 = (i$iv$iv$iv2 << 3) + j$iv$iv$iv2;
                                                            Object scope8 = k$iv$iv2[index$iv$iv$iv12];
                                                            mutableScatterSet.add(scope8);
                                                            hasValues2 = true;
                                                        }
                                                        slot$iv$iv$iv2 >>= 8;
                                                        j$iv$iv$iv2++;
                                                        m$iv$iv$iv2 = m$iv$iv$iv2;
                                                    }
                                                    m$iv$iv$iv3 = m$iv$iv$iv2;
                                                    if (bitCount$iv$iv$iv2 == 8) {
                                                        break;
                                                        break;
                                                    }
                                                } else {
                                                    m$iv$iv$iv3 = m$iv$iv$iv2;
                                                }
                                                if (i$iv$iv$iv2 != lastIndex$iv$iv$iv2) {
                                                    break;
                                                    break;
                                                }
                                                i$iv$iv$iv2++;
                                                this_$iv$iv3 = this_$iv$iv4;
                                                $i$f$forEach3 = $i$f$forEach4;
                                                policy = snapshotMutationPolicy;
                                                scopeMap5 = scopeMap6;
                                                m$iv$iv$iv2 = m$iv$iv$iv3;
                                            }
                                        }
                                    } else {
                                        map = map5;
                                        mutableScatterSet.add(value$iv3);
                                        hasValues2 = true;
                                    }
                                } else {
                                    map = map5;
                                    this.statesToReread.add(derivedState);
                                }
                                hasValues5 = hasValues2;
                            }
                        } else {
                            map = map5;
                            scopeMap18 = scopeMap;
                        }
                        scopeMap2 = scopeMap13;
                        value$iv = scopeMap2.getMap().get(element$iv$iv3);
                        if (value$iv == null) {
                            if (value$iv instanceof MutableScatterSet) {
                                this_$iv$iv = (MutableScatterSet) value$iv;
                                $i$f$forEach = 0;
                                k$iv$iv = this_$iv$iv.elements;
                                m$iv$iv$iv = this_$iv$iv.metadata;
                                lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
                                i$iv$iv$iv = 0;
                                if (0 <= lastIndex$iv$iv$iv) {
                                    while (true) {
                                        slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                                        hasValues = hasValues5;
                                        scopeMap3 = scopeMap2;
                                        this_$iv$iv2 = this_$iv$iv;
                                        $i$f$forEach2 = $i$f$forEach;
                                        $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                                        if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                                            bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                                            while (j$iv$iv$iv < bitCount$iv$iv$iv) {
                                                value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                                                if (value$iv$iv$iv$iv < 128) {
                                                    $i$f$isFull = 1;
                                                } else {
                                                    $i$f$isFull = 0;
                                                }
                                                if ($i$f$isFull != 0) {
                                                    int index$iv$iv$iv13 = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                                                    Object scope9 = k$iv$iv[index$iv$iv$iv13];
                                                    mutableScatterSet.add(scope9);
                                                    hasValues = true;
                                                }
                                                slot$iv$iv$iv >>= 8;
                                            }
                                            if (bitCount$iv$iv$iv == 8) {
                                                hasValues5 = hasValues;
                                                break;
                                                break;
                                            }
                                            hasValues5 = hasValues;
                                        } else {
                                            hasValues5 = hasValues;
                                        }
                                        if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                                            break;
                                            break;
                                        }
                                        i$iv$iv$iv++;
                                        scopeMap2 = scopeMap3;
                                        this_$iv$iv = this_$iv$iv2;
                                        $i$f$forEach = $i$f$forEach2;
                                    }
                                }
                            } else {
                                mutableScatterSet.add(value$iv);
                                hasValues5 = true;
                            }
                        }
                    }
                    $i$f$forEach9 = $i$f$forEach9;
                    $this$forEach$iv$iv = $this$forEach$iv$iv;
                    it = it;
                    map5 = map;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                int size$iv = mutableVector.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = mutableVector.getContent();
                    do {
                        rereadDerivedState((DerivedState) content$iv[i$iv]);
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                this.statesToReread.clear();
            }
            return hasValues5;
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            ScatterSet this_$iv$iv;
            Object[] k$iv$iv;
            ScatterSet this_$iv$iv$iv;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int token = SnapshotKt.currentSnapshot().getId();
            ScopeMap<Object, Object> scopeMap = this.valueToScopes;
            int $i$f$forEachScopeOf = 0;
            Object value$iv = scopeMap.getMap().get(derivedState);
            if (value$iv == null) {
                return;
            }
            if (!(value$iv instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(value$iv);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(0, 1, null);
                    mutableScatterMap.set(value$iv, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, token, value$iv, mutableObjectIntMap2);
                return;
            }
            ScatterSet this_$iv$iv2 = (MutableScatterSet) value$iv;
            int $i$f$forEach = 0;
            Object[] k$iv$iv2 = this_$iv$iv2.elements;
            ScatterSet this_$iv$iv$iv2 = this_$iv$iv2;
            long[] m$iv$iv$iv = this_$iv$iv$iv2.metadata;
            int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
            int i$iv$iv$iv = 0;
            if (0 > lastIndex$iv$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                int $i$f$forEach2 = $i$f$forEach;
                ScopeMap<Object, Object> scopeMap2 = scopeMap;
                int $i$f$forEachScopeOf2 = $i$f$forEachScopeOf;
                if ((((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i = 8;
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    int j$iv$iv$iv = 0;
                    while (j$iv$iv$iv < bitCount$iv$iv$iv) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        int $i$f$isFull = value$iv$iv$iv$iv < 128 ? 1 : 0;
                        if ($i$f$isFull != 0) {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                            Object scope = k$iv$iv2[index$iv$iv$iv];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(scope);
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                                mutableScatterMap.set(scope, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, token, scope, mutableObjectIntMap);
                        } else {
                            this_$iv$iv2 = this_$iv$iv2;
                            k$iv$iv2 = k$iv$iv2;
                            this_$iv$iv$iv2 = this_$iv$iv$iv2;
                        }
                        i = 8;
                        slot$iv$iv$iv >>= 8;
                        j$iv$iv$iv++;
                        this_$iv$iv2 = this_$iv$iv2;
                        k$iv$iv2 = k$iv$iv2;
                        this_$iv$iv$iv2 = this_$iv$iv$iv2;
                    }
                    this_$iv$iv = this_$iv$iv2;
                    k$iv$iv = k$iv$iv2;
                    this_$iv$iv$iv = this_$iv$iv$iv2;
                    if (bitCount$iv$iv$iv != i) {
                        return;
                    }
                } else {
                    this_$iv$iv = this_$iv$iv2;
                    k$iv$iv = k$iv$iv2;
                    this_$iv$iv$iv = this_$iv$iv$iv2;
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    return;
                }
                i$iv$iv$iv++;
                scopeMap = scopeMap2;
                $i$f$forEachScopeOf = $i$f$forEachScopeOf2;
                $i$f$forEach = $i$f$forEach2;
                this_$iv$iv2 = this_$iv$iv;
                k$iv$iv2 = k$iv$iv;
                this_$iv$iv$iv2 = this_$iv$iv$iv;
            }
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0064 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x0066 A[LOOP:0: B:4:0x0018->B:17:0x0066, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:23:0x0072 A[EDGE_INSN: B:23:0x0072->B:20:0x0072 BREAK  A[LOOP:0: B:4:0x0018->B:17:0x0066], SYNTHETIC] */
        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            MutableScatterSet<Object> this_$iv = mutableScatterSet;
            Function1<Object, Unit> function1 = this.onChanged;
            Object[] k$iv = this_$iv.elements;
            ScatterSet this_$iv$iv = this_$iv;
            int $i$f$forEachIndex = 0;
            long[] m$iv$iv = this_$iv$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 <= lastIndex$iv$iv) {
                while (true) {
                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                    ScatterSet this_$iv$iv2 = this_$iv$iv;
                    int $i$f$forEachIndex2 = $i$f$forEachIndex;
                    if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                            break;
                        } else {
                            i$iv$iv++;
                            this_$iv$iv = this_$iv$iv2;
                            $i$f$forEachIndex = $i$f$forEachIndex2;
                        }
                    } else {
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
                            break;
                        }
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                        }
                        i$iv$iv++;
                        this_$iv$iv = this_$iv$iv2;
                        $i$f$forEachIndex = $i$f$forEachIndex2;
                    }
                }
            }
            mutableScatterSet.clear();
        }
    }
}
