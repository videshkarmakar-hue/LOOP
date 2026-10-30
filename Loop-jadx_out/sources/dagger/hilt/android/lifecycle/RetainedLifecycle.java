package dagger.hilt.android.lifecycle;

/* JADX INFO: loaded from: classes18.dex */
public interface RetainedLifecycle {

    public interface OnClearedListener {
        void onCleared();
    }

    void addOnClearedListener(OnClearedListener listener);

    void removeOnClearedListener(OnClearedListener listener);
}
