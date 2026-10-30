package androidx.lifecycle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScopeKt;
import androidx.lifecycle.viewmodel.internal.Lock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m195d2 = {"viewModelScopeLock", "Landroidx/lifecycle/viewmodel/internal/Lock;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "lifecycle-viewmodel_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ViewModelKt {
    private static final Lock viewModelScopeLock = new Lock();

    public static final CoroutineScope getViewModelScope(ViewModel $this$viewModelScope) {
        CloseableCoroutineScope scope;
        Intrinsics.checkNotNullParameter($this$viewModelScope, "<this>");
        Lock this_$iv = viewModelScopeLock;
        synchronized (this_$iv) {
            scope = (CloseableCoroutineScope) $this$viewModelScope.getCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY);
            if (scope == null) {
                scope = CloseableCoroutineScopeKt.createViewModelScope();
                $this$viewModelScope.addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, scope);
            }
        }
        return scope;
    }
}
