package com.google.accompanist.web;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WebView.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/web is deprecated and the API is no longer maintained. \nWe recommend forking the implementation and customising it to your needs. \nFor more information please visit https://google.github.io/accompanist/web\n")
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m195d2 = {"Lcom/google/accompanist/web/LoadingState;", "", "()V", "Finished", "Initializing", "Loading", "Lcom/google/accompanist/web/LoadingState$Finished;", "Lcom/google/accompanist/web/LoadingState$Initializing;", "Lcom/google/accompanist/web/LoadingState$Loading;", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class LoadingState {
    public static final int $stable = 0;

    public /* synthetic */ LoadingState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LoadingState() {
    }

    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/google/accompanist/web/LoadingState$Initializing;", "Lcom/google/accompanist/web/LoadingState;", "()V", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Initializing extends LoadingState {
        public static final int $stable = 0;
        public static final Initializing INSTANCE = new Initializing();

        private Initializing() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m195d2 = {"Lcom/google/accompanist/web/LoadingState$Loading;", "Lcom/google/accompanist/web/LoadingState;", NotificationCompat.CATEGORY_PROGRESS, "", "(F)V", "getProgress", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Loading extends LoadingState {
        public static final int $stable = 0;
        private final float progress;

        public static /* synthetic */ Loading copy$default(Loading loading, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = loading.progress;
            }
            return loading.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getProgress() {
            return this.progress;
        }

        public final Loading copy(float progress) {
            return new Loading(progress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loading) && Float.compare(this.progress, ((Loading) other).progress) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.progress);
        }

        public String toString() {
            return "Loading(progress=" + this.progress + ')';
        }

        public Loading(float progress) {
            super(null);
            this.progress = progress;
        }

        public final float getProgress() {
            return this.progress;
        }
    }

    /* JADX INFO: compiled from: WebView.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Lcom/google/accompanist/web/LoadingState$Finished;", "Lcom/google/accompanist/web/LoadingState;", "()V", "web_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Finished extends LoadingState {
        public static final int $stable = 0;
        public static final Finished INSTANCE = new Finished();

        private Finished() {
            super(null);
        }
    }
}
