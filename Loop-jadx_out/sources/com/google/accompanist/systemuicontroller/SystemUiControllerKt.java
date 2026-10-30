package com.google.accompanist.systemuicontroller;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.window.DialogWindowProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUiController.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\fH\u0082\u0010\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m195d2 = {"BlackScrim", "Landroidx/compose/ui/graphics/Color;", "J", "BlackScrimmed", "Lkotlin/Function1;", "findWindow", "Landroid/view/Window;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/Window;", "rememberSystemUiController", "Lcom/google/accompanist/systemuicontroller/SystemUiController;", "window", "(Landroid/view/Window;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/systemuicontroller/SystemUiController;", "Landroid/content/Context;", "systemuicontroller_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SystemUiControllerKt {
    private static final long BlackScrim = ColorKt.Color$default(0.0f, 0.0f, 0.0f, 0.3f, null, 16, null);
    private static final Function1<Color, Color> BlackScrimmed = new Function1<Color, Color>() { // from class: com.google.accompanist.systemuicontroller.SystemUiControllerKt$BlackScrimmed$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Color invoke(Color color) {
            return Color.m4281boximpl(m7198invokel2rxGTc(color.m4301unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-l2rxGTc, reason: not valid java name */
        public final long m7198invokel2rxGTc(long original) {
            return ColorKt.m4336compositeOverOWjLjI(SystemUiControllerKt.BlackScrim, original);
        }
    };

    @Deprecated(message = "\naccompanist/systemuicontroller is deprecated and the API is no longer maintained. \nWe recommend going edge to edge using EdgeToEdge.enableEdgeToEdge in androidx.activity. \nFor more information please visit https://google.github.io/accompanist/systemuicontroller\n")
    public static final SystemUiController rememberSystemUiController(Window window, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(-715745933);
        if ((i & 1) != 0) {
            window = findWindow($composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-715745933, $changed, -1, "com.google.accompanist.systemuicontroller.rememberSystemUiController (SystemUiController.kt:201)");
        }
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd($composer);
        View view = (View) objConsume;
        $composer.startReplaceableGroup(-1044852491);
        boolean invalid$iv = $composer.changed(view) | $composer.changed(window);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new AndroidSystemUiController(view, window);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        AndroidSystemUiController androidSystemUiController = (AndroidSystemUiController) value$iv;
        $composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return androidSystemUiController;
    }

    private static final Window findWindow(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1009281237);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009281237, $changed, -1, "com.google.accompanist.systemuicontroller.findWindow (SystemUiController.kt:208)");
        }
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewParent parent = ((View) objConsume).getParent();
        DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
        Window window = dialogWindowProvider != null ? dialogWindowProvider.getWindow() : null;
        if (window == null) {
            ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localView2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Context context = ((View) objConsume2).getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            window = findWindow(context);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return window;
    }

    private static final Window findWindow(Context $this$findWindow) {
        while (!($this$findWindow instanceof Activity)) {
            if (!($this$findWindow instanceof ContextWrapper)) {
                return null;
            }
            Context baseContext = ((ContextWrapper) $this$findWindow).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            $this$findWindow = baseContext;
        }
        return ((Activity) $this$findWindow).getWindow();
    }
}
