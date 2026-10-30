package androidx.hilt.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiltNavBackStackEntry.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m193bv = {1, 0, 3}, m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0006¨\u0006\u0007"}, m195d2 = {"HiltViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "context", "Landroid/content/Context;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "create", "hilt-navigation_release"}, m196k = 2, m197mv = {1, 4, 2})
public final class HiltViewModelFactory {
    public static final ViewModelProvider.Factory create(Context context, NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Context ctx = context;
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                Activity activity = (Activity) ctx;
                ViewModelProvider.Factory factoryCreateInternal = dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.createInternal(activity, navBackStackEntry, navBackStackEntry.getArguments(), navBackStackEntry.getDefaultViewModelProviderFactory());
                Intrinsics.checkNotNullExpressionValue(factoryCreateInternal, "HiltViewModelFactory.cre…delProviderFactory,\n    )");
                return factoryCreateInternal;
            }
            Context baseContext = ((ContextWrapper) ctx).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "ctx.baseContext");
            ctx = baseContext;
        }
        throw new IllegalStateException("Expected an activity context for creating a HiltViewModelFactory for a NavBackStackEntry but instead found: " + ctx);
    }
}
