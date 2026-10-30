package com.videshkarmakar.loop.p006ui.page.videolist;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* JADX INFO: loaded from: classes15.dex */
public final class VideoListViewModel_HiltModules {
    private VideoListViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @Binds
        @IntoMap
        @StringKey("com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel")
        public abstract ViewModel binds(VideoListViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        private KeyModule() {
        }

        @Provides
        @IntoSet
        public static String provide() {
            return "com.videshkarmakar.loop.ui.page.videolist.VideoListViewModel";
        }
    }
}
