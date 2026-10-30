package com.videshkarmakar.loop.p006ui.page.videolist;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes15.dex */
public final class VideoListViewModel_Factory implements Factory<VideoListViewModel> {
    @Override // javax.inject.Provider
    public VideoListViewModel get() {
        return newInstance();
    }

    public static VideoListViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VideoListViewModel newInstance() {
        return new VideoListViewModel();
    }

    private static final class InstanceHolder {
        private static final VideoListViewModel_Factory INSTANCE = new VideoListViewModel_Factory();

        private InstanceHolder() {
        }
    }
}
