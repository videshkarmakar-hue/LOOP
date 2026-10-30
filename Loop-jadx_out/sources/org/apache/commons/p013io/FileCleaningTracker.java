package org.apache.commons.p013io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class FileCleaningTracker {
    Thread reaper;

    /* JADX INFO: renamed from: q */
    ReferenceQueue<Object> f597q = new ReferenceQueue<>();
    final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet());
    final List<String> deleteFailures = Collections.synchronizedList(new ArrayList());
    volatile boolean exitWhenFinished = false;

    public void track(File file, Object marker) {
        track(file, marker, (FileDeleteStrategy) null);
    }

    public void track(File file, Object marker, FileDeleteStrategy deleteStrategy) {
        if (file == null) {
            throw new NullPointerException("The file must not be null");
        }
        addTracker(file.getPath(), marker, deleteStrategy);
    }

    public void track(String path, Object marker) {
        track(path, marker, (FileDeleteStrategy) null);
    }

    public void track(String path, Object marker, FileDeleteStrategy deleteStrategy) {
        if (path == null) {
            throw new NullPointerException("The path must not be null");
        }
        addTracker(path, marker, deleteStrategy);
    }

    private synchronized void addTracker(String path, Object marker, FileDeleteStrategy deleteStrategy) {
        if (this.exitWhenFinished) {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
        if (this.reaper == null) {
            this.reaper = new Reaper();
            this.reaper.start();
        }
        this.trackers.add(new Tracker(path, deleteStrategy, marker, this.f597q));
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public List<String> getDeleteFailures() {
        return this.deleteFailures;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0015 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void exitWhenFinished() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 1
            r2.exitWhenFinished = r0     // Catch: java.lang.Throwable -> L19
            java.lang.Thread r0 = r2.reaper     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L17
            java.lang.Thread r0 = r2.reaper     // Catch: java.lang.Throwable -> L19
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L19
            java.lang.Thread r1 = r2.reaper     // Catch: java.lang.Throwable -> L12
            r1.interrupt()     // Catch: java.lang.Throwable -> L12
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            goto L17
        L12:
            r1 = move-exception
        L13:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r1     // Catch: java.lang.Throwable -> L19
        L15:
            r1 = move-exception
            goto L13
        L17:
            monitor-exit(r2)
            return
        L19:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p013io.FileCleaningTracker.exitWhenFinished():void");
    }

    private final class Reaper extends Thread {
        Reaper() {
            super("File Reaper");
            setPriority(10);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (!FileCleaningTracker.this.exitWhenFinished || FileCleaningTracker.this.trackers.size() > 0) {
                    try {
                        Tracker tracker = (Tracker) FileCleaningTracker.this.f597q.remove();
                        FileCleaningTracker.this.trackers.remove(tracker);
                        if (!tracker.delete()) {
                            FileCleaningTracker.this.deleteFailures.add(tracker.getPath());
                        }
                        tracker.clear();
                    } catch (InterruptedException e) {
                    }
                } else {
                    return;
                }
            }
        }
    }

    private static final class Tracker extends PhantomReference<Object> {
        private final FileDeleteStrategy deleteStrategy;
        private final String path;

        Tracker(String path, FileDeleteStrategy deleteStrategy, Object marker, ReferenceQueue<? super Object> queue) {
            super(marker, queue);
            this.path = path;
            this.deleteStrategy = deleteStrategy == null ? FileDeleteStrategy.NORMAL : deleteStrategy;
        }

        public String getPath() {
            return this.path;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }
    }
}
