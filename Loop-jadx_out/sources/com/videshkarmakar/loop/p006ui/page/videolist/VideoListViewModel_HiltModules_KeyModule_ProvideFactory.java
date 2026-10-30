package com.videshkarmakar.loop.p006ui.page.videolist;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes15.dex */
public final class VideoListViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    @Override // javax.inject.Provider
    public String get() {
        return provide();
    }

    public static VideoListViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(VideoListViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        private static final VideoListViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new VideoListViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
