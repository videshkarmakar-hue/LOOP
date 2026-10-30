package com.google.accompanist.systemuicontroller;

import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUiController.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/systemuicontroller is deprecated and the API is no longer maintained. \nWe recommend going edge to edge using Activity.enableEdgeToEdge in androidx.activity. \nFor more information please visit https://google.github.io/accompanist/systemuicontroller\n")
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001JD\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0$H&ø\u0001\u0000¢\u0006\u0004\b%\u0010&J:\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00032\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0$H&ø\u0001\u0000¢\u0006\u0004\b(\u0010)JD\u0010*\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0$H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0004\"\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\u00020\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0006ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, m195d2 = {"Lcom/google/accompanist/systemuicontroller/SystemUiController;", "", "isNavigationBarContrastEnforced", "", "()Z", "setNavigationBarContrastEnforced", "(Z)V", "isNavigationBarVisible", "setNavigationBarVisible", "isStatusBarVisible", "setStatusBarVisible", DownloadUtil.CookieScheme.VALUE, "isSystemBarsVisible", "setSystemBarsVisible", "navigationBarDarkContentEnabled", "getNavigationBarDarkContentEnabled", "setNavigationBarDarkContentEnabled", "statusBarDarkContentEnabled", "getStatusBarDarkContentEnabled", "setStatusBarDarkContentEnabled", "systemBarsBehavior", "", "getSystemBarsBehavior", "()I", "setSystemBarsBehavior", "(I)V", "systemBarsDarkContentEnabled", "getSystemBarsDarkContentEnabled", "setSystemBarsDarkContentEnabled", "setNavigationBarColor", "", "color", "Landroidx/compose/ui/graphics/Color;", "darkIcons", "navigationBarContrastEnforced", "transformColorForLightContent", "Lkotlin/Function1;", "setNavigationBarColor-Iv8Zu3U", "(JZZLkotlin/jvm/functions/Function1;)V", "setStatusBarColor", "setStatusBarColor-ek8zF_U", "(JZLkotlin/jvm/functions/Function1;)V", "setSystemBarsColor", "setSystemBarsColor-Iv8Zu3U", "systemuicontroller_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface SystemUiController {
    boolean getNavigationBarDarkContentEnabled();

    boolean getStatusBarDarkContentEnabled();

    int getSystemBarsBehavior();

    boolean getSystemBarsDarkContentEnabled();

    boolean isNavigationBarContrastEnforced();

    boolean isNavigationBarVisible();

    boolean isStatusBarVisible();

    boolean isSystemBarsVisible();

    /* JADX INFO: renamed from: setNavigationBarColor-Iv8Zu3U */
    void mo7191setNavigationBarColorIv8Zu3U(long color, boolean darkIcons, boolean navigationBarContrastEnforced, Function1<? super Color, Color> transformColorForLightContent);

    void setNavigationBarContrastEnforced(boolean z);

    void setNavigationBarDarkContentEnabled(boolean z);

    void setNavigationBarVisible(boolean z);

    /* JADX INFO: renamed from: setStatusBarColor-ek8zF_U */
    void mo7192setStatusBarColorek8zF_U(long color, boolean darkIcons, Function1<? super Color, Color> transformColorForLightContent);

    void setStatusBarDarkContentEnabled(boolean z);

    void setStatusBarVisible(boolean z);

    void setSystemBarsBehavior(int i);

    /* JADX INFO: renamed from: setSystemBarsColor-Iv8Zu3U */
    void mo7193setSystemBarsColorIv8Zu3U(long color, boolean darkIcons, boolean isNavigationBarContrastEnforced, Function1<? super Color, Color> transformColorForLightContent);

    void setSystemBarsDarkContentEnabled(boolean z);

    void setSystemBarsVisible(boolean z);

    /* JADX INFO: renamed from: com.google.accompanist.systemuicontroller.SystemUiController$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: SystemUiController.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$isSystemBarsVisible(SystemUiController _this) {
            return _this.isNavigationBarVisible() && _this.isStatusBarVisible();
        }

        public static void $default$setSystemBarsVisible(SystemUiController _this, boolean value) {
            _this.setStatusBarVisible(value);
            _this.setNavigationBarVisible(value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: setStatusBarColor-ek8zF_U$default, reason: not valid java name */
        public static /* synthetic */ void m7196setStatusBarColorek8zF_U$default(SystemUiController systemUiController, long j, boolean z, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusBarColor-ek8zF_U");
            }
            if ((i & 2) != 0) {
                z = ColorKt.m4343luminance8_81llA(j) > 0.5f;
            }
            if ((i & 4) != 0) {
                function1 = SystemUiControllerKt.BlackScrimmed;
            }
            systemUiController.mo7192setStatusBarColorek8zF_U(j, z, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: setNavigationBarColor-Iv8Zu3U$default, reason: not valid java name */
        public static /* synthetic */ void m7195setNavigationBarColorIv8Zu3U$default(SystemUiController systemUiController, long j, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            boolean z3;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationBarColor-Iv8Zu3U");
            }
            if ((i & 2) != 0) {
                z3 = ColorKt.m4343luminance8_81llA(j) > 0.5f;
            } else {
                z3 = z;
            }
            systemUiController.mo7191setNavigationBarColorIv8Zu3U(j, z3, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? SystemUiControllerKt.BlackScrimmed : function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: setSystemBarsColor-Iv8Zu3U$default, reason: not valid java name */
        public static /* synthetic */ void m7197setSystemBarsColorIv8Zu3U$default(SystemUiController systemUiController, long j, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            boolean z3;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSystemBarsColor-Iv8Zu3U");
            }
            if ((i & 2) != 0) {
                z3 = ColorKt.m4343luminance8_81llA(j) > 0.5f;
            } else {
                z3 = z;
            }
            systemUiController.mo7193setSystemBarsColorIv8Zu3U(j, z3, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? SystemUiControllerKt.BlackScrimmed : function1);
        }

        /* JADX INFO: renamed from: $default$setSystemBarsColor-Iv8Zu3U, reason: not valid java name */
        public static void m7194$default$setSystemBarsColorIv8Zu3U(SystemUiController _this, long color, boolean darkIcons, boolean isNavigationBarContrastEnforced, Function1 transformColorForLightContent) {
            Intrinsics.checkNotNullParameter(transformColorForLightContent, "transformColorForLightContent");
            _this.mo7192setStatusBarColorek8zF_U(color, darkIcons, transformColorForLightContent);
            _this.mo7191setNavigationBarColorIv8Zu3U(color, darkIcons, isNavigationBarContrastEnforced, transformColorForLightContent);
        }

        public static boolean $default$getSystemBarsDarkContentEnabled(SystemUiController _this) {
            return _this.getStatusBarDarkContentEnabled() && _this.getNavigationBarDarkContentEnabled();
        }

        public static void $default$setSystemBarsDarkContentEnabled(SystemUiController _this, boolean value) {
            _this.setStatusBarDarkContentEnabled(value);
            _this.setNavigationBarDarkContentEnabled(value);
        }
    }
}
