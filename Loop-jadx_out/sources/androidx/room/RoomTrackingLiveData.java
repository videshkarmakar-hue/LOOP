package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoomTrackingLiveData.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020,H\u0014R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010)\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014¨\u0006."}, m195d2 = {"Landroidx/room/RoomTrackingLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "database", "Landroidx/room/RoomDatabase;", "container", "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "computeFunction", "Ljava/util/concurrent/Callable;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;ZLjava/util/concurrent/Callable;[Ljava/lang/String;)V", "getComputeFunction", "()Ljava/util/concurrent/Callable;", "computing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getComputing", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getDatabase", "()Landroidx/room/RoomDatabase;", "getInTransaction", "()Z", "invalid", "getInvalid", "invalidationRunnable", "Ljava/lang/Runnable;", "getInvalidationRunnable", "()Ljava/lang/Runnable;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "queryExecutor", "Ljava/util/concurrent/Executor;", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "refreshRunnable", "getRefreshRunnable", "registeredObserver", "getRegisteredObserver", "onActive", "", "onInactive", "room-runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RoomTrackingLiveData<T> extends LiveData<T> {
    private final Callable<T> computeFunction;
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final Runnable invalidationRunnable;
    private final InvalidationTracker.Observer observer;
    private final Runnable refreshRunnable;
    private final AtomicBoolean registeredObserver;

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    public RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean inTransaction, Callable<T> computeFunction, final String[] tableNames) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.database = database;
        this.container = container;
        this.inTransaction = inTransaction;
        this.computeFunction = computeFunction;
        this.observer = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> tables) {
                Intrinsics.checkNotNullParameter(tables, "tables");
                ArchTaskExecutor.getInstance().executeOnMainThread(this.getInvalidationRunnable());
            }
        };
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                RoomTrackingLiveData.refreshRunnable$lambda$0(this.f$0);
            }
        };
        this.invalidationRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RoomTrackingLiveData.invalidationRunnable$lambda$1(this.f$0);
            }
        };
    }

    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0050 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void refreshRunnable$lambda$0(androidx.room.RoomTrackingLiveData r7) throws java.lang.Exception {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.registeredObserver
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L1b
            androidx.room.RoomDatabase r0 = r7.database
            androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r3 = r7.observer
            r0.addWeakObserver(r3)
        L1b:
            r0 = 0
        L1c:
            r0 = 0
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.computing
            boolean r3 = r3.compareAndSet(r1, r2)
            if (r3 == 0) goto L57
        L26:
            r3 = 0
        L27:
            java.util.concurrent.atomic.AtomicBoolean r4 = r7.invalid     // Catch: java.lang.Throwable -> L50
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch: java.lang.Throwable -> L50
            if (r4 == 0) goto L45
            r0 = 1
            java.util.concurrent.Callable<T> r4 = r7.computeFunction     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L50
            java.lang.Object r4 = r4.call()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L50
            r3 = r4
            goto L27
        L39:
            r2 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L50
            java.lang.String r5 = "Exception while computing database live data."
            r6 = r2
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch: java.lang.Throwable -> L50
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L50
            throw r4     // Catch: java.lang.Throwable -> L50
        L45:
            if (r0 == 0) goto L4a
            r7.postValue(r3)     // Catch: java.lang.Throwable -> L50
        L4a:
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.computing
            r3.set(r1)
            goto L57
        L50:
            r2 = move-exception
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.computing
            r3.set(r1)
            throw r2
        L57:
            if (r0 == 0) goto L61
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.invalid
            boolean r3 = r3.get()
            if (r3 != 0) goto L1c
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.refreshRunnable$lambda$0(androidx.room.RoomTrackingLiveData):void");
    }

    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(RoomTrackingLiveData this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isActive = this$0.hasActiveObservers();
        if (this$0.invalid.compareAndSet(false, true) && isActive) {
            this$0.getQueryExecutor().execute(this$0.refreshRunnable);
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.onInactive(this);
    }

    public final Executor getQueryExecutor() {
        if (this.inTransaction) {
            return this.database.getTransactionExecutor();
        }
        return this.database.getQueryExecutor();
    }
}
