package androidx.hilt.navigation.compose;

import android.content.Context;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.hilt.navigation.HiltViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt__ViewModel_androidKt;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiltViewModel.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a$\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\b¨\u0006\t"}, m195d2 = {"createHiltViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/compose/runtime/Composer;I)Landroidx/lifecycle/ViewModelProvider$Factory;", "hiltViewModel", "VM", "Landroidx/lifecycle/ViewModel;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "hilt-navigation-compose_release"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HiltViewModelKt {
    public static final /* synthetic */ <VM extends ViewModel> VM hiltViewModel(ViewModelStoreOwner viewModelStoreOwner, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-550968255);
        ComposerKt.sourceInformation(composer, "C(hiltViewModel)*42@1777L7,46@1895L47,47@1954L49:HiltViewModel.kt#9mcars");
        if ((i2 & 1) != 0) {
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 8);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            viewModelStoreOwner = current;
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = createHiltViewModelFactory(viewModelStoreOwner, composer, 8);
        composer.startReplaceableGroup(564614654);
        ComposerKt.sourceInformation(composer, "C(viewModel)P(2,1)*41@1904L7,46@2077L60:ViewModel.kt#3tja67");
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) ViewModelKt__ViewModel_androidKt.viewModel(ViewModel.class, viewModelStoreOwner, null, factoryCreateHiltViewModelFactory, composer, ((520 << 3) & 896) | 4168, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return vm;
    }

    public static final ViewModelProvider.Factory createHiltViewModelFactory(ViewModelStoreOwner viewModelStoreOwner, Composer $composer, int $changed) {
        ViewModelProvider.Factory factoryCreate;
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        $composer.startReplaceableGroup(1770922558);
        ComposerKt.sourceInformation($composer, "C(createHiltViewModelFactory)56@2256L7:HiltViewModel.kt#9mcars");
        if (viewModelStoreOwner instanceof NavBackStackEntry) {
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer);
            factoryCreate = HiltViewModelFactory.create((Context) objConsume, (NavBackStackEntry) viewModelStoreOwner);
        } else {
            factoryCreate = null;
        }
        $composer.endReplaceableGroup();
        return factoryCreate;
    }
}
