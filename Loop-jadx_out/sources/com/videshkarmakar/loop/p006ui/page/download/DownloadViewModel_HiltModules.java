package com.videshkarmakar.loop.p006ui.page.download;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* JADX INFO: loaded from: classes15.dex */
public final class DownloadViewModel_HiltModules {
    private DownloadViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @Binds
        @IntoMap
        @StringKey("com.videshkarmakar.loop.ui.page.download.DownloadViewModel")
        public abstract ViewModel binds(DownloadViewModel vm);

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
            return "com.videshkarmakar.loop.ui.page.download.DownloadViewModel";
        }
    }
}
