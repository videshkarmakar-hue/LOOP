package androidx.compose.p001ui.modifier;

import androidx.compose.p001ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ModifierLocalProvider.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/modifier/ModifierLocalProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier$Element;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", DownloadUtil.CookieScheme.VALUE, "getValue", "()Ljava/lang/Object;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface ModifierLocalProvider<T> extends Modifier.Element {
    ProvidableModifierLocal<T> getKey();

    T getValue();

    /* JADX INFO: renamed from: androidx.compose.ui.modifier.ModifierLocalProvider$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ModifierLocalProvider.kt */
    public final /* synthetic */ class CC {
    }

    /* JADX INFO: compiled from: ModifierLocalProvider.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean all(ModifierLocalProvider<T> modifierLocalProvider, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$all(modifierLocalProvider, function1);
        }

        @Deprecated
        public static <T> boolean any(ModifierLocalProvider<T> modifierLocalProvider, Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.CC.$default$any(modifierLocalProvider, function1);
        }

        @Deprecated
        public static <T, R> R foldIn(ModifierLocalProvider<T> modifierLocalProvider, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) Modifier.Element.CC.$default$foldIn(modifierLocalProvider, r, function2);
        }

        @Deprecated
        public static <T, R> R foldOut(ModifierLocalProvider<T> modifierLocalProvider, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) Modifier.Element.CC.$default$foldOut(modifierLocalProvider, r, function2);
        }

        @Deprecated
        public static <T> Modifier then(ModifierLocalProvider<T> modifierLocalProvider, Modifier other) {
            return Modifier.CC.$default$then(modifierLocalProvider, other);
        }
    }
}
