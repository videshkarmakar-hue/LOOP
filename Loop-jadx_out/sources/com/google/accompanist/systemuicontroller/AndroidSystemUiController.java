package com.google.accompanist.systemuicontroller;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUiController.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J>\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J6\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0&H\u0016ø\u0001\u0000¢\u0006\u0004\b*\u0010+R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, m195d2 = {"Lcom/google/accompanist/systemuicontroller/AndroidSystemUiController;", "Lcom/google/accompanist/systemuicontroller/SystemUiController;", "view", "Landroid/view/View;", "window", "Landroid/view/Window;", "(Landroid/view/View;Landroid/view/Window;)V", DownloadUtil.CookieScheme.VALUE, "", "isNavigationBarContrastEnforced", "()Z", "setNavigationBarContrastEnforced", "(Z)V", "isNavigationBarVisible", "setNavigationBarVisible", "isStatusBarVisible", "setStatusBarVisible", "navigationBarDarkContentEnabled", "getNavigationBarDarkContentEnabled", "setNavigationBarDarkContentEnabled", "statusBarDarkContentEnabled", "getStatusBarDarkContentEnabled", "setStatusBarDarkContentEnabled", "", "systemBarsBehavior", "getSystemBarsBehavior", "()I", "setSystemBarsBehavior", "(I)V", "windowInsetsController", "Landroidx/core/view/WindowInsetsControllerCompat;", "setNavigationBarColor", "", "color", "Landroidx/compose/ui/graphics/Color;", "darkIcons", "navigationBarContrastEnforced", "transformColorForLightContent", "Lkotlin/Function1;", "setNavigationBarColor-Iv8Zu3U", "(JZZLkotlin/jvm/functions/Function1;)V", "setStatusBarColor", "setStatusBarColor-ek8zF_U", "(JZLkotlin/jvm/functions/Function1;)V", "systemuicontroller_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidSystemUiController implements SystemUiController {
    public static final int $stable = 0;
    private final View view;
    private final Window window;
    private final WindowInsetsControllerCompat windowInsetsController;

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ boolean getSystemBarsDarkContentEnabled() {
        return SystemUiController.CC.$default$getSystemBarsDarkContentEnabled(this);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ boolean isSystemBarsVisible() {
        return SystemUiController.CC.$default$isSystemBarsVisible(this);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* JADX INFO: renamed from: setSystemBarsColor-Iv8Zu3U, reason: not valid java name */
    public /* synthetic */ void mo7193setSystemBarsColorIv8Zu3U(long j, boolean z, boolean z2, Function1 function1) {
        SystemUiController.CC.m7194$default$setSystemBarsColorIv8Zu3U(this, j, z, z2, function1);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ void setSystemBarsDarkContentEnabled(boolean z) {
        SystemUiController.CC.$default$setSystemBarsDarkContentEnabled(this, z);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public /* synthetic */ void setSystemBarsVisible(boolean z) {
        SystemUiController.CC.$default$setSystemBarsVisible(this, z);
    }

    public AndroidSystemUiController(View view, Window window) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.window = window;
        Window it = this.window;
        this.windowInsetsController = it != null ? WindowCompat.getInsetsController(it, this.view) : null;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d  */
    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* JADX INFO: renamed from: setStatusBarColor-ek8zF_U, reason: not valid java name */
    public void mo7192setStatusBarColorek8zF_U(long color, boolean darkIcons, Function1<? super Color, Color> transformColorForLightContent) {
        long jM4301unboximpl;
        Intrinsics.checkNotNullParameter(transformColorForLightContent, "transformColorForLightContent");
        setStatusBarDarkContentEnabled(darkIcons);
        Window window = this.window;
        if (window != null) {
            if (darkIcons) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
                boolean z = false;
                if (windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightStatusBars()) {
                    z = true;
                }
                if (!z) {
                    jM4301unboximpl = transformColorForLightContent.invoke(Color.m4281boximpl(color)).m4301unboximpl();
                } else {
                    jM4301unboximpl = color;
                }
            } else {
                jM4301unboximpl = color;
            }
            window.setStatusBarColor(ColorKt.m4345toArgb8_81llA(jM4301unboximpl));
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* JADX INFO: renamed from: setNavigationBarColor-Iv8Zu3U, reason: not valid java name */
    public void mo7191setNavigationBarColorIv8Zu3U(long color, boolean darkIcons, boolean navigationBarContrastEnforced, Function1<? super Color, Color> transformColorForLightContent) {
        long jM4301unboximpl;
        Intrinsics.checkNotNullParameter(transformColorForLightContent, "transformColorForLightContent");
        setNavigationBarDarkContentEnabled(darkIcons);
        setNavigationBarContrastEnforced(navigationBarContrastEnforced);
        Window window = this.window;
        if (window != null) {
            if (darkIcons) {
                WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
                boolean z = false;
                if (windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightNavigationBars()) {
                    z = true;
                }
                if (!z) {
                    jM4301unboximpl = transformColorForLightContent.invoke(Color.m4281boximpl(color)).m4301unboximpl();
                } else {
                    jM4301unboximpl = color;
                }
            } else {
                jM4301unboximpl = color;
            }
            window.setNavigationBarColor(ColorKt.m4345toArgb8_81llA(jM4301unboximpl));
        }
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public int getSystemBarsBehavior() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat != null) {
            return windowInsetsControllerCompat.getSystemBarsBehavior();
        }
        return 0;
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setSystemBarsBehavior(int value) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setSystemBarsBehavior(value);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean isStatusBarVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        return rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.statusBars());
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setStatusBarVisible(boolean value) {
        if (value) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            if (windowInsetsControllerCompat != null) {
                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat2 = this.windowInsetsController;
        if (windowInsetsControllerCompat2 != null) {
            windowInsetsControllerCompat2.hide(WindowInsetsCompat.Type.statusBars());
        }
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean isNavigationBarVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        return rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.navigationBars());
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setNavigationBarVisible(boolean value) {
        if (value) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
            if (windowInsetsControllerCompat != null) {
                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.navigationBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat2 = this.windowInsetsController;
        if (windowInsetsControllerCompat2 != null) {
            windowInsetsControllerCompat2.hide(WindowInsetsCompat.Type.navigationBars());
        }
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean getStatusBarDarkContentEnabled() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        return windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightStatusBars();
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setStatusBarDarkContentEnabled(boolean value) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightStatusBars(value);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean getNavigationBarDarkContentEnabled() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        return windowInsetsControllerCompat != null && windowInsetsControllerCompat.isAppearanceLightNavigationBars();
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setNavigationBarDarkContentEnabled(boolean value) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(value);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public boolean isNavigationBarContrastEnforced() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        Window window = this.window;
        return window != null && window.isNavigationBarContrastEnforced();
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    public void setNavigationBarContrastEnforced(boolean value) {
        Window window;
        if (Build.VERSION.SDK_INT < 29 || (window = this.window) == null) {
            return;
        }
        window.setNavigationBarContrastEnforced(value);
    }
}
