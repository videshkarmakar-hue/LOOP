package com.videshkarmakar.loop.p006ui.page.download;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes15.dex */
public final class DownloadViewModel_Factory implements Factory<DownloadViewModel> {
    @Override // javax.inject.Provider
    public DownloadViewModel get() {
        return newInstance();
    }

    public static DownloadViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DownloadViewModel newInstance() {
        return new DownloadViewModel();
    }

    private static final class InstanceHolder {
        private static final DownloadViewModel_Factory INSTANCE = new DownloadViewModel_Factory();

        private InstanceHolder() {
        }
    }
}
