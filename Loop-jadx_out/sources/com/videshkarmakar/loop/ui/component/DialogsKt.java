package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.google.accompanist.flowlayout.FlowKt;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.theme.FixedAccentColors;
import com.videshkarmakar.loop.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Dialogs.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\r\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a.\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001aQ\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 2\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0013\b\u0002\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00130 ¢\u0006\u0002\b\"H\u0007¢\u0006\u0002\u0010$\u001aá\u0001\u0010%\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 2\u0013\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u001b2\b\b\u0002\u0010+\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u000200H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a7\u00103\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u00192\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130 H\u0007¢\u0006\u0002\u00105\u001aÌ\u0001\u00106\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010 ¢\u0006\u0002\b\"2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u001b2\b\b\u0002\u0010+\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u000200H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"BottomButtonShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getBottomButtonShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "DialogHorizontalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DialogVerticalPadding", "IconPadding", "MiddleButtonShape", "getMiddleButtonShape", "TextPadding", "TitlePadding", "TopButtonShape", "getTopButtonShape", "ButtonVariantPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "DialogSubtitle", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "color", "Landroidx/compose/ui/graphics/Color;", "DialogSubtitle-FNF3uiM", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "HelpDialog", "onDismissRequest", "Lkotlin/Function0;", "dismissButton", "Landroidx/compose/runtime/Composable;", "confirmButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LoopDialog", "icon", "title", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "properties", "Landroidx/compose/ui/window/DialogProperties;", "LoopDialog-Oix01E0", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "LoopDialogButtonVariant", "onClick", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LoopDialogVariant", "buttons", "LoopDialogVariant-q4k6-nM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DialogsKt {
    private static final PaddingValues DialogVerticalPadding = PaddingKt.m615PaddingValuesYgX7TsA$default(0.0f, Dp.m6553constructorimpl(24), 1, null);
    private static final PaddingValues IconPadding = PaddingKt.m617PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(16), 7, null);
    private static final PaddingValues DialogHorizontalPadding = PaddingKt.m615PaddingValuesYgX7TsA$default(Dp.m6553constructorimpl(24), 0.0f, 2, null);
    private static final PaddingValues TitlePadding = PaddingKt.m617PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(16), 7, null);
    private static final PaddingValues TextPadding = PaddingKt.m617PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(24), 7, null);
    private static final float ButtonsMainAxisSpacing = Dp.m6553constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = Dp.m6553constructorimpl(12);
    private static final RoundedCornerShape TopButtonShape = RoundedCornerShapeKt.m899RoundedCornerShapea9UjIt4(Dp.m6553constructorimpl(12), Dp.m6553constructorimpl(12), Dp.m6553constructorimpl(4), Dp.m6553constructorimpl(4));
    private static final RoundedCornerShape MiddleButtonShape = RoundedCornerShapeKt.m898RoundedCornerShape0680j_4(Dp.m6553constructorimpl(4));
    private static final RoundedCornerShape BottomButtonShape = RoundedCornerShapeKt.m899RoundedCornerShapea9UjIt4(Dp.m6553constructorimpl(4), Dp.m6553constructorimpl(4), Dp.m6553constructorimpl(12), Dp.m6553constructorimpl(12));

    public static final void HelpDialog(final String text, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function1;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Function0<Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(2048308600);
        ComposerKt.sourceInformation($composer2, "C(HelpDialog)P(3,2,1)55@2515L85,61@2823L21,57@2610L319:Dialogs.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            function1 = function0;
        } else if (($changed & 112) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function4 = function2;
        } else if (($changed & 896) == 0) {
            function4 = function2;
            $dirty |= $composer2.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function5 = function3;
        } else if (($changed & 7168) == 0) {
            function5 = function3;
            $dirty |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function6 = function1;
            function2RememberComposableLambda = function5;
            function7 = function4;
        } else {
            final C08201 c08201 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt.HelpDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            Function2<? super Composer, ? super Integer, Unit> function8 = i3 != 0 ? null : function4;
            function2RememberComposableLambda = i4 != 0 ? ComposableLambdaKt.rememberComposableLambda(1214957246, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt.HelpDialog.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C55@2538L36,55@2576L22,55@2517L81:Dialogs.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1214957246, $changed2, -1, "com.videshkarmakar.loop.ui.component.HelpDialog.<anonymous> (Dialogs.kt:55)");
                    }
                    String strStringResource = StringResources_androidKt.stringResource(R.string.got_it, $composer3, 0);
                    $composer3.startReplaceGroup(1040416859);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Dialogs.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c08201);
                    final Function0<Unit> function9 = c08201;
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$HelpDialog$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function9.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.ConfirmButton(strStringResource, false, (Function0) value$iv, $composer3, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54) : function5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2048308600, $dirty, -1, "com.videshkarmakar.loop.ui.component.HelpDialog (Dialogs.kt:56)");
            }
            AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0(c08201, function2RememberComposableLambda, null, function8, ComposableSingletons$DialogsKt.INSTANCE.m7111getLambda1$app_debug(), ComposableSingletons$DialogsKt.INSTANCE.m7112getLambda2$app_debug(), ComposableLambdaKt.rememberComposableLambda(-243689461, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt.HelpDialog.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C61@2825L17:Dialogs.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-243689461, $changed2, -1, "com.videshkarmakar.loop.ui.component.HelpDialog.<anonymous> (Dialogs.kt:61)");
                    }
                    TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 3) & 14) | 1794048 | (($dirty >> 6) & 112) | (($dirty << 3) & 7168), 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = c08201;
            function7 = function8;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function9 = function6;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function11 = function2RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt.HelpDialog.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    DialogsKt.HelpDialog(text, function9, function10, function11, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: LoopDialog-Oix01E0, reason: not valid java name */
    public static final void m7162LoopDialogOix01E0(Modifier modifier, final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Shape shape2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        long containerColor2;
        long iconContentColor2;
        long titleContentColor2;
        long textContentColor2;
        float tonalElevation2;
        DialogProperties properties2;
        int $dirty;
        int $dirty1;
        Function2<? super Composer, ? super Integer, Unit> function10;
        long containerColor3;
        long iconContentColor3;
        long titleContentColor3;
        long textContentColor3;
        Function2<? super Composer, ? super Integer, Unit> function11;
        long containerColor4;
        float tonalElevation3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        DialogProperties properties3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Shape shape3;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer2 = $composer.startRestartGroup(640645279);
        ComposerKt.sourceInformation($composer2, "C(LoopDialog)P(5,6!1,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)77@3341L5,78@3396L14,79@3462L16,80@3531L17,81@3600L16,89@3871L3372,85@3741L3502:Dialogs.kt#g7nzpb");
        int $dirty2 = $changed;
        int $dirty3 = $changed1;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(onDismissRequest) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function7 = function5;
        } else if (($changed & 458752) == 0) {
            function7 = function5;
            $dirty2 |= $composer2.changedInstance(function7) ? 131072 : 65536;
        } else {
            function7 = function5;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            function8 = function6;
        } else if (($changed & 3670016) == 0) {
            function8 = function6;
            $dirty2 |= $composer2.changedInstance(function8) ? 1048576 : 524288;
        } else {
            function8 = function6;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                shape2 = shape;
                int i7 = $composer2.changed(shape2) ? 8388608 : 4194304;
                $dirty2 |= i7;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 234881024) == 0) {
            $dirty2 |= ((i & 256) == 0 && $composer2.changed(containerColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty2 |= ((i & 512) == 0 && $composer2.changed(iconContentColor)) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty3 |= ((i & 1024) == 0 && $composer2.changed(titleContentColor)) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty3 |= ((i & 2048) == 0 && $composer2.changed(textContentColor)) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            $dirty3 |= ((i & 4096) == 0 && $composer2.changed(tonalElevation)) ? 256 : 128;
        }
        int i8 = i & 8192;
        if (i8 != 0) {
            $dirty3 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty3 |= $composer2.changed(properties) ? 2048 : 1024;
        }
        if ((1533916891 & $dirty2) == 306783378 && ($dirty3 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function12 = function3;
            function11 = function4;
            containerColor4 = containerColor;
            iconContentColor3 = iconContentColor;
            titleContentColor3 = titleContentColor;
            textContentColor3 = textContentColor;
            tonalElevation3 = tonalElevation;
            properties3 = properties;
            modifier3 = modifier2;
            function13 = function7;
            function14 = function8;
            shape3 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                function9 = i3 != 0 ? null : function3;
                Function2<? super Composer, ? super Integer, Unit> function15 = i4 != 0 ? null : function4;
                if (i5 != 0) {
                    function7 = null;
                }
                if (i6 != 0) {
                    function8 = null;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape($composer2, AlertDialogDefaults.$stable);
                }
                if ((i & 256) != 0) {
                    containerColor2 = AlertDialogDefaults.INSTANCE.getContainerColor($composer2, AlertDialogDefaults.$stable);
                    $dirty2 &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 512) != 0) {
                    iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor($composer2, AlertDialogDefaults.$stable);
                    $dirty2 &= -1879048193;
                } else {
                    iconContentColor2 = iconContentColor;
                }
                if ((i & 1024) != 0) {
                    titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor($composer2, AlertDialogDefaults.$stable);
                    $dirty3 &= -15;
                } else {
                    titleContentColor2 = titleContentColor;
                }
                if ((i & 2048) != 0) {
                    textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor($composer2, AlertDialogDefaults.$stable);
                    $dirty3 &= -113;
                } else {
                    textContentColor2 = textContentColor;
                }
                if ((i & 4096) != 0) {
                    tonalElevation2 = AlertDialogDefaults.INSTANCE.m1660getTonalElevationD9Ej5fM();
                    $dirty3 &= -897;
                } else {
                    tonalElevation2 = tonalElevation;
                }
                if (i8 != 0) {
                    properties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    $dirty = $dirty2;
                    $dirty1 = $dirty3;
                    function10 = function15;
                    containerColor3 = containerColor2;
                    iconContentColor3 = iconContentColor2;
                    titleContentColor3 = titleContentColor2;
                    textContentColor3 = textContentColor2;
                    modifier2 = modifier4;
                } else {
                    properties2 = properties;
                    $dirty = $dirty2;
                    $dirty1 = $dirty3;
                    function10 = function15;
                    containerColor3 = containerColor2;
                    iconContentColor3 = iconContentColor2;
                    titleContentColor3 = titleContentColor2;
                    textContentColor3 = textContentColor2;
                    modifier2 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty2 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty3 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty3 &= -113;
                }
                if ((i & 4096) != 0) {
                    function9 = function3;
                    iconContentColor3 = iconContentColor;
                    titleContentColor3 = titleContentColor;
                    textContentColor3 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                    $dirty1 = $dirty3 & (-897);
                    $dirty = $dirty2;
                    function10 = function4;
                    containerColor3 = containerColor;
                } else {
                    function9 = function3;
                    function10 = function4;
                    iconContentColor3 = iconContentColor;
                    titleContentColor3 = titleContentColor;
                    textContentColor3 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                    $dirty = $dirty2;
                    $dirty1 = $dirty3;
                    containerColor3 = containerColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(640645279, $dirty, $dirty1, "com.videshkarmakar.loop.ui.component.LoopDialog (Dialogs.kt:84)");
            }
            final Modifier modifier5 = modifier2;
            final Shape shape4 = shape2;
            final long j = containerColor3;
            final float f = tonalElevation2;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function8;
            final long j2 = iconContentColor3;
            final long j3 = titleContentColor3;
            final long j4 = textContentColor3;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function9;
            Function2<? super Composer, ? super Integer, Unit> function20 = function10;
            long containerColor5 = containerColor3;
            AndroidAlertDialog_androidKt.BasicAlertDialog(onDismissRequest, modifier2, properties2, ComposableLambdaKt.rememberComposableLambda(1781983653, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C95@4041L3196,90@3881L3356:Dialogs.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1781983653, $changed2, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous> (Dialogs.kt:90)");
                        }
                        Modifier modifier6 = modifier5;
                        Shape shape5 = shape4;
                        long j5 = j;
                        float f2 = f;
                        final Function2<Composer, Integer, Unit> function21 = function16;
                        final Function2<Composer, Integer, Unit> function22 = function17;
                        final Function2<Composer, Integer, Unit> function23 = function18;
                        final long j6 = j2;
                        final long j7 = j3;
                        final long j8 = j4;
                        final Function2<Composer, Integer, Unit> function24 = function19;
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        SurfaceKt.m2418SurfaceT9BRK9s(modifier6, shape5, j5, 0L, f2, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1864342592, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                Function0<ComposeUiNode> function0;
                                Function0<ComposeUiNode> function1;
                                ComposerKt.sourceInformation($composer4, "C96@4055L3172:Dialogs.kt#g7nzpb");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1864342592, $changed3, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous> (Dialogs.kt:96)");
                                    }
                                    Modifier modifier$iv = PaddingKt.padding(Modifier.INSTANCE, DialogsKt.DialogVerticalPadding);
                                    final Function2<Composer, Integer, Unit> function26 = function21;
                                    final Function2<Composer, Integer, Unit> function27 = function22;
                                    final Function2<Composer, Integer, Unit> function28 = function23;
                                    long j9 = j6;
                                    long j10 = j7;
                                    long j11 = j8;
                                    final Function2<Composer, Integer, Unit> function29 = function24;
                                    final Function2<Composer, Integer, Unit> function30 = function25;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                    int $changed$iv$iv = (6 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function0 = constructor;
                                        $composer4.createNode(function0);
                                    } else {
                                        function0 = constructor;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i9 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                    int i10 = ((6 >> 6) & 112) | 6;
                                    final ColumnScope $this$invoke_u24lambda_u244 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -2088937204, "C150@6519L694:Dialogs.kt#g7nzpb");
                                    $composer4.startReplaceGroup(-2088937198);
                                    ComposerKt.sourceInformation($composer4, "*100@4264L367,100@4194L437");
                                    if (function26 != null) {
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(j9)), ComposableLambdaKt.rememberComposableLambda(1706656439, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer5, int $changed4) {
                                                Function0<ComposeUiNode> function31;
                                                ComposerKt.sourceInformation($composer5, "C101@4290L319:Dialogs.kt#g7nzpb");
                                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1706656439, $changed4, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:101)");
                                                    }
                                                    Modifier modifier$iv2 = $this$invoke_u24lambda_u244.align(PaddingKt.padding(PaddingKt.padding(Modifier.INSTANCE, DialogsKt.IconPadding), DialogsKt.DialogHorizontalPadding), Alignment.INSTANCE.getCenterHorizontally());
                                                    Function2<Composer, Integer, Unit> function32 = function26;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                    int $changed$iv$iv2 = (0 << 3) & 112;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                    CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                                                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                    if (!($composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer5.startReusableNode();
                                                    if ($composer5.getInserting()) {
                                                        function31 = constructor2;
                                                        $composer5.createNode(function31);
                                                    } else {
                                                        function31 = constructor2;
                                                        $composer5.useNode();
                                                    }
                                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer5);
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                                    }
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                                    int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    int i12 = ((0 >> 6) & 112) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -368048242, "C107@4577L6:Dialogs.kt#g7nzpb");
                                                    function32.invoke($composer5, 0);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    $composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                    }
                                    $composer4.endReplaceGroup();
                                    $composer4.startReplaceGroup(-2088936693);
                                    ComposerKt.sourceInformation($composer4, "*112@4770L1006,112@4699L1077");
                                    if (function27 != null) {
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(j10)), ComposableLambdaKt.rememberComposableLambda(-983020896, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1$1$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer5, int $changed4) {
                                                ComposerKt.sourceInformation($composer5, "C114@4854L10,115@4966L788,115@4938L816:Dialogs.kt#g7nzpb");
                                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-983020896, $changed4, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:113)");
                                                    }
                                                    TextStyle headlineSmall = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getHeadlineSmall();
                                                    TextStyle textStyle = headlineSmall.m6029copyp1EtxEg((16777213 & 1) != 0 ? headlineSmall.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? headlineSmall.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? headlineSmall.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? headlineSmall.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? headlineSmall.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? headlineSmall.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? headlineSmall.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? headlineSmall.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? headlineSmall.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? headlineSmall.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? headlineSmall.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? headlineSmall.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? headlineSmall.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? headlineSmall.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? headlineSmall.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? headlineSmall.paragraphStyle.getTextAlign() : TextAlign.INSTANCE.m6410getCentere0LSkKk(), (16777213 & 65536) != 0 ? headlineSmall.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? headlineSmall.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? headlineSmall.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? headlineSmall.platformStyle : null, (16777213 & 1048576) != 0 ? headlineSmall.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? headlineSmall.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? headlineSmall.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? headlineSmall.paragraphStyle.getTextMotion() : null);
                                                    final ColumnScope columnScope = $this$invoke_u24lambda_u244;
                                                    final Function2<Composer, Integer, Unit> function31 = function26;
                                                    final Function2<Composer, Integer, Unit> function32 = function27;
                                                    TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.rememberComposableLambda(2071043535, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1$1$1$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                            invoke(composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer $composer6, int $changed5) {
                                                            Alignment.Horizontal centerHorizontally;
                                                            Function0<ComposeUiNode> function33;
                                                            ComposerKt.sourceInformation($composer6, "C116@4996L732:Dialogs.kt#g7nzpb");
                                                            if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(2071043535, $changed5, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:116)");
                                                                }
                                                                ColumnScope columnScope2 = columnScope;
                                                                Modifier modifierPadding = PaddingKt.padding(PaddingKt.padding(Modifier.INSTANCE, DialogsKt.TitlePadding), DialogsKt.DialogHorizontalPadding);
                                                                if (function31 == null) {
                                                                    centerHorizontally = Alignment.INSTANCE.getStart();
                                                                } else {
                                                                    centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                                                }
                                                                Modifier modifier$iv2 = columnScope2.align(modifierPadding, centerHorizontally);
                                                                Function2<Composer, Integer, Unit> function34 = function32;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                                int $changed$iv$iv2 = (0 << 3) & 112;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                                CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                                                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                $composer6.startReusableNode();
                                                                if ($composer6.getInserting()) {
                                                                    function33 = constructor2;
                                                                    $composer6.createNode(function33);
                                                                } else {
                                                                    function33 = constructor2;
                                                                    $composer6.useNode();
                                                                }
                                                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer6);
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                                                }
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                                                int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                int i12 = ((0 >> 6) & 112) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1739918711, "C129@5691L7:Dialogs.kt#g7nzpb");
                                                                function34.invoke($composer6, 0);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                $composer6.endNode();
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            $composer6.skipToGroupEnd();
                                                        }
                                                    }, $composer5, 54), $composer5, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                    }
                                    $composer4.endReplaceGroup();
                                    $composer4.startReplaceGroup(-2088935549);
                                    ComposerKt.sourceInformation($composer4, "*135@5913L571,135@5843L641");
                                    if (function28 != null) {
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(j11)), ComposableLambdaKt.rememberComposableLambda(-1403139841, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1$1$1$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer5, int $changed4) {
                                                ComposerKt.sourceInformation($composer5, "C137@5997L10,138@6071L391,138@6043L419:Dialogs.kt#g7nzpb");
                                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1403139841, $changed4, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:136)");
                                                    }
                                                    TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium();
                                                    final ColumnScope columnScope = $this$invoke_u24lambda_u244;
                                                    final Function2<Composer, Integer, Unit> function31 = function28;
                                                    TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.rememberComposableLambda(1650924590, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1$1$1$3$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                            invoke(composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer $composer6, int $changed5) {
                                                            Function0<ComposeUiNode> function32;
                                                            ComposerKt.sourceInformation($composer6, "C139@6101L335:Dialogs.kt#g7nzpb");
                                                            if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1650924590, $changed5, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:139)");
                                                                }
                                                                Modifier modifier$iv2 = columnScope.align(PaddingKt.padding(columnScope.weight(Modifier.INSTANCE, 1.0f, false), DialogsKt.TextPadding), Alignment.INSTANCE.getStart());
                                                                Function2<Composer, Integer, Unit> function33 = function31;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                                int $changed$iv$iv2 = (0 << 3) & 112;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                                CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                                                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                $composer6.startReusableNode();
                                                                if ($composer6.getInserting()) {
                                                                    function32 = constructor2;
                                                                    $composer6.createNode(function32);
                                                                } else {
                                                                    function32 = constructor2;
                                                                    $composer6.useNode();
                                                                }
                                                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer6);
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                                                }
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                                                int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                int i12 = ((0 >> 6) & 112) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1739918002, "C145@6400L6:Dialogs.kt#g7nzpb");
                                                                function33.invoke($composer6, 0);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                $composer6.endNode();
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            $composer6.skipToGroupEnd();
                                                        }
                                                    }, $composer5, 54), $composer5, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                    }
                                    $composer4.endReplaceGroup();
                                    Modifier modifier$iv2 = PaddingKt.padding($this$invoke_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd()), DialogsKt.DialogHorizontalPadding);
                                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv2 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function1 = constructor2;
                                        $composer4.createNode(function1);
                                    } else {
                                        function1 = constructor2;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i12 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -164919777, "C156@6762L10,157@6840L355,157@6804L391:Dialogs.kt#g7nzpb");
                                    TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge();
                                    TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.rememberComposableLambda(1717695667, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1$1$1$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer5, int $changed4) {
                                            ComposerKt.sourceInformation($composer5, "C161@7042L131,158@6866L307:Dialogs.kt#g7nzpb");
                                            if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1717695667, $changed4, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:158)");
                                                }
                                                float f3 = DialogsKt.ButtonsMainAxisSpacing;
                                                float f4 = DialogsKt.ButtonsCrossAxisSpacing;
                                                final Function2<Composer, Integer, Unit> function31 = function29;
                                                final Function2<Composer, Integer, Unit> function32 = function30;
                                                FlowKt.m6941FlowRow07r0xoM(null, null, null, f3, null, f4, null, ComposableLambdaKt.rememberComposableLambda(656837753, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$1$1$1$4$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                        invoke(composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer $composer6, int $changed5) {
                                                        ComposerKt.sourceInformation($composer6, "C163@7139L8:Dialogs.kt#g7nzpb");
                                                        if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(656837753, $changed5, -1, "com.videshkarmakar.loop.ui.component.LoopDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:162)");
                                                            }
                                                            Function2<Composer, Integer, Unit> function33 = function31;
                                                            $composer6.startReplaceGroup(-368045732);
                                                            ComposerKt.sourceInformation($composer6, "162@7087L8");
                                                            if (function33 != null) {
                                                                function33.invoke($composer6, 0);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            $composer6.endReplaceGroup();
                                                            Function2<Composer, Integer, Unit> function34 = function32;
                                                            if (function34 != null) {
                                                                function34.invoke($composer6, 0);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        $composer6.skipToGroupEnd();
                                                    }
                                                }, $composer5, 54), $composer5, 12782592, 87);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }, $composer4, 54), $composer4, 48);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 12582912, LocationRequestCompat.QUALITY_LOW_POWER);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty1 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function11 = function20;
            containerColor4 = containerColor5;
            tonalElevation3 = tonalElevation2;
            function12 = function9;
            properties3 = properties2;
            modifier3 = modifier2;
            function13 = function7;
            function14 = function8;
            shape3 = shape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function21 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function22 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function14;
            final Shape shape5 = shape3;
            final long j5 = containerColor4;
            final long j6 = iconContentColor3;
            final long j7 = titleContentColor3;
            final long j8 = textContentColor3;
            final float f2 = tonalElevation3;
            final DialogProperties dialogProperties = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    DialogsKt.m7162LoopDialogOix01E0(modifier6, onDismissRequest, function2, function21, function22, function23, function24, shape5, j5, j6, j7, j8, f2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void LoopDialogButtonVariant(Modifier modifier, Shape shape, final String text, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        Modifier modifier3;
        Shape shape3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1274145472);
        ComposerKt.sourceInformation($composer3, "C(LoopDialogButtonVariant)P(!1,2,3)179@7411L493:Dialogs.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            shape2 = shape;
        } else if (($changed & 112) == 0) {
            shape2 = shape;
            $dirty |= $composer3.changed(shape2) ? 32 : 16;
        } else {
            shape2 = shape;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(text) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onClick) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            $composer2 = $composer3;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            shape3 = i3 != 0 ? MiddleButtonShape : shape2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1274145472, $dirty2, -1, "com.videshkarmakar.loop.ui.component.LoopDialogButtonVariant (Dialogs.kt:178)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$LoopDialogButtonVariant_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 479724714, "C185@7616L14,180@7427L253,192@7754L10,193@7815L16,190@7689L209:Dialogs.kt#g7nzpb");
            SurfaceKt.m2418SurfaceT9BRK9s(SizeKt.m651height3ABfNKs(SizeKt.fillMaxWidth$default(ClickableKt.m239clickableXHw0xAI$default(modifier3, false, null, null, onClick, 7, null), 0.0f, 1, null), Dp.m6553constructorimpl(48)), shape3, FixedAccentColors.INSTANCE.getSecondaryFixed($composer3, 6), 0L, 0.0f, 0.0f, null, ComposableSingletons$DialogsKt.INSTANCE.m7113getLambda3$app_debug(), $composer3, ($dirty2 & 112) | 12582912, 120);
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, $this$LoopDialogButtonVariant_u24lambda_u240.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), FixedAccentColors.INSTANCE.getOnSecondaryFixed($composer3, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer3, ($dirty2 >> 6) & 14, 0, 65528);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Shape shape4 = shape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt.LoopDialogButtonVariant.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    DialogsKt.LoopDialogButtonVariant(modifier4, shape4, text, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ButtonVariantPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(353082423);
        ComposerKt.sourceInformation($composer2, "C(ButtonVariantPreview)204@8094L1133:Dialogs.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(353082423, $changed, -1, "com.videshkarmakar.loop.ui.component.ButtonVariantPreview (Dialogs.kt:203)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$DialogsKt.INSTANCE.m7117getLambda7$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt.ButtonVariantPreview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DialogsKt.ButtonVariantPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final RoundedCornerShape getTopButtonShape() {
        return TopButtonShape;
    }

    public static final RoundedCornerShape getMiddleButtonShape() {
        return MiddleButtonShape;
    }

    public static final RoundedCornerShape getBottomButtonShape() {
        return BottomButtonShape;
    }

    /* JADX INFO: renamed from: LoopDialogVariant-q4k6-nM, reason: not valid java name */
    public static final void m7163LoopDialogVariantq4k6nM(final Function0<Unit> onDismissRequest, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Shape shape2;
        Modifier.Companion modifier3;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        long containerColor2;
        long iconContentColor2;
        long titleContentColor2;
        long textContentColor2;
        float tonalElevation2;
        DialogProperties properties2;
        float tonalElevation3;
        DialogProperties properties3;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        long iconContentColor3;
        long containerColor3;
        long titleContentColor3;
        long textContentColor3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Shape shape3;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer2 = $composer.startRestartGroup(-1459384790);
        ComposerKt.sourceInformation($composer2, "C(LoopDialogVariant)P(5,4!1,2,10,8,7,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.graphics.Color,9:c#ui.graphics.Color,12:c#ui.unit.Dp)265@9909L5,266@9958L11,267@10038L16,268@10107L17,269@10176L16,277@10442L2876,273@10317L3001:Dialogs.kt#g7nzpb");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function6 = function4;
        } else if (($changed & 57344) == 0) {
            function6 = function4;
            $dirty |= $composer2.changedInstance(function6) ? 16384 : 8192;
        } else {
            function6 = function4;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function7 = function5;
        } else if (($changed & 458752) == 0) {
            function7 = function5;
            $dirty |= $composer2.changedInstance(function7) ? 131072 : 65536;
        } else {
            function7 = function5;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                shape2 = shape;
                int i7 = $composer2.changed(shape2) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                shape2 = shape;
            }
            $dirty |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 29360128) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(containerColor)) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(iconContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty |= ((i & 512) == 0 && $composer2.changed(titleContentColor)) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty1 |= ((i & 1024) == 0 && $composer2.changed(textContentColor)) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty1 |= ((i & 2048) == 0 && $composer2.changed(tonalElevation)) ? 32 : 16;
        }
        int i8 = i & 4096;
        if (i8 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer2.changed(properties) ? 256 : 128;
        }
        if ((1533916891 & $dirty) == 306783378 && ($dirty1 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function12 = function2;
            function11 = function3;
            containerColor3 = containerColor;
            iconContentColor3 = iconContentColor;
            titleContentColor3 = titleContentColor;
            textContentColor3 = textContentColor;
            tonalElevation3 = tonalElevation;
            properties3 = properties;
            function10 = function6;
            function13 = function7;
            modifier4 = modifier2;
            shape3 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                function8 = i3 != 0 ? null : function2;
                function9 = i4 != 0 ? null : function3;
                if (i5 != 0) {
                    function6 = null;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape($composer2, AlertDialogDefaults.$stable);
                }
                if ((i & 128) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainer();
                    $dirty &= -29360129;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 256) != 0) {
                    iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor($composer2, AlertDialogDefaults.$stable);
                    $dirty &= -234881025;
                } else {
                    iconContentColor2 = iconContentColor;
                }
                if ((i & 512) != 0) {
                    titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor($composer2, AlertDialogDefaults.$stable);
                    $dirty &= -1879048193;
                } else {
                    titleContentColor2 = titleContentColor;
                }
                if ((i & 1024) != 0) {
                    textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor($composer2, AlertDialogDefaults.$stable);
                    $dirty1 &= -15;
                } else {
                    textContentColor2 = textContentColor;
                }
                if ((i & 2048) != 0) {
                    tonalElevation2 = AlertDialogDefaults.INSTANCE.m1660getTonalElevationD9Ej5fM();
                    $dirty1 &= -113;
                } else {
                    tonalElevation2 = tonalElevation;
                }
                properties2 = i8 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : properties;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty1 &= -15;
                }
                if ((i & 2048) != 0) {
                    function8 = function2;
                    containerColor2 = containerColor;
                    iconContentColor2 = iconContentColor;
                    titleContentColor2 = titleContentColor;
                    textContentColor2 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    $dirty1 &= -113;
                    modifier3 = modifier2;
                    function9 = function3;
                    properties2 = properties;
                } else {
                    function8 = function2;
                    containerColor2 = containerColor;
                    iconContentColor2 = iconContentColor;
                    titleContentColor2 = titleContentColor;
                    textContentColor2 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                    modifier3 = modifier2;
                    function9 = function3;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459384790, $dirty, $dirty1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant (Dialogs.kt:272)");
            }
            final Modifier modifier5 = modifier3;
            final Shape shape4 = shape2;
            final long j = containerColor2;
            final float f = tonalElevation2;
            final Function2<? super Composer, ? super Integer, Unit> function14 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function6;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function7;
            final long j2 = iconContentColor2;
            final long j3 = titleContentColor2;
            final long j4 = textContentColor2;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function8;
            Function2<Composer, Integer, Unit> function18 = new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C283@10612L2700,278@10452L2860:Dialogs.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(410488308, $changed2, -1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant.<anonymous> (Dialogs.kt:278)");
                        }
                        Modifier modifier6 = modifier5;
                        Shape shape5 = shape4;
                        long j5 = j;
                        float f2 = f;
                        final Function2<Composer, Integer, Unit> function19 = function14;
                        final Function2<Composer, Integer, Unit> function20 = function15;
                        final Function2<Composer, Integer, Unit> function21 = function16;
                        final long j6 = j2;
                        final long j7 = j3;
                        final long j8 = j4;
                        final Function2<Composer, Integer, Unit> function22 = function17;
                        SurfaceKt.m2418SurfaceT9BRK9s(modifier6, shape5, j5, 0L, f2, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1816261745, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                Function0<ComposeUiNode> function0;
                                final ColumnScope $this$invoke_u24lambda_u244;
                                ComposerKt.sourceInformation($composer4, "C284@10626L2676:Dialogs.kt#g7nzpb");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1816261745, $changed3, -1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant.<anonymous>.<anonymous> (Dialogs.kt:284)");
                                    }
                                    Modifier modifier$iv = PaddingKt.padding(Modifier.INSTANCE, DialogsKt.DialogVerticalPadding);
                                    final Function2<Composer, Integer, Unit> function23 = function19;
                                    final Function2<Composer, Integer, Unit> function24 = function20;
                                    final Function2<Composer, Integer, Unit> function25 = function21;
                                    long j9 = j6;
                                    long j10 = j7;
                                    long j11 = j8;
                                    Function2<Composer, Integer, Unit> function26 = function22;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                    int $changed$iv$iv = (6 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function0 = constructor;
                                        $composer4.createNode(function0);
                                    } else {
                                        function0 = constructor;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i9 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                    int i10 = ((6 >> 6) & 112) | 6;
                                    ColumnScope $this$invoke_u24lambda_u245 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1005016516, "C337@13062L226:Dialogs.kt#g7nzpb");
                                    $composer4.startReplaceGroup(1005016522);
                                    ComposerKt.sourceInformation($composer4, "*288@10835L367,288@10765L437");
                                    if (function23 == null) {
                                        $this$invoke_u24lambda_u244 = $this$invoke_u24lambda_u245;
                                    } else {
                                        $this$invoke_u24lambda_u244 = $this$invoke_u24lambda_u245;
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(j9)), ComposableLambdaKt.rememberComposableLambda(1613060358, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$1$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer5, int $changed4) {
                                                Function0<ComposeUiNode> function1;
                                                ComposerKt.sourceInformation($composer5, "C289@10861L319:Dialogs.kt#g7nzpb");
                                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1613060358, $changed4, -1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:289)");
                                                    }
                                                    Modifier modifier$iv2 = $this$invoke_u24lambda_u244.align(PaddingKt.padding(PaddingKt.padding(Modifier.INSTANCE, DialogsKt.IconPadding), DialogsKt.DialogHorizontalPadding), Alignment.INSTANCE.getCenterHorizontally());
                                                    Function2<Composer, Integer, Unit> function27 = function23;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                    int $changed$iv$iv2 = (0 << 3) & 112;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                    CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                                                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                    if (!($composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer5.startReusableNode();
                                                    if ($composer5.getInserting()) {
                                                        function1 = constructor2;
                                                        $composer5.createNode(function1);
                                                    } else {
                                                        function1 = constructor2;
                                                        $composer5.useNode();
                                                    }
                                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer5);
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                                    }
                                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                                    int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    int i12 = ((0 >> 6) & 112) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer5, 839532998, "C295@11148L6:Dialogs.kt#g7nzpb");
                                                    function27.invoke($composer5, 0);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    $composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                    }
                                    $composer4.endReplaceGroup();
                                    $composer4.startReplaceGroup(1005017027);
                                    ComposerKt.sourceInformation($composer4, "*300@11341L978,300@11270L1049");
                                    if (function24 != null) {
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(j10)), ComposableLambdaKt.rememberComposableLambda(1867192815, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$1$1$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer5, int $changed4) {
                                                ComposerKt.sourceInformation($composer5, "C301@11397L10,302@11509L788,302@11446L851:Dialogs.kt#g7nzpb");
                                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1867192815, $changed4, -1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:301)");
                                                    }
                                                    TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getHeadlineSmall();
                                                    TextStyle textStyleM6029copyp1EtxEg = textStyle.m6029copyp1EtxEg((16777213 & 1) != 0 ? textStyle.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : TextAlign.INSTANCE.m6410getCentere0LSkKk(), (16777213 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyle.platformStyle : null, (16777213 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
                                                    final ColumnScope columnScope = $this$invoke_u24lambda_u244;
                                                    final Function2<Composer, Integer, Unit> function27 = function23;
                                                    final Function2<Composer, Integer, Unit> function28 = function24;
                                                    TextKt.ProvideTextStyle(textStyleM6029copyp1EtxEg, ComposableLambdaKt.rememberComposableLambda(1708526622, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$1$1$1$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                            invoke(composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer $composer6, int $changed5) {
                                                            Alignment.Horizontal centerHorizontally;
                                                            Function0<ComposeUiNode> function1;
                                                            ComposerKt.sourceInformation($composer6, "C303@11539L732:Dialogs.kt#g7nzpb");
                                                            if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1708526622, $changed5, -1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:303)");
                                                                }
                                                                ColumnScope columnScope2 = columnScope;
                                                                Modifier modifierPadding = PaddingKt.padding(PaddingKt.padding(Modifier.INSTANCE, DialogsKt.TitlePadding), DialogsKt.DialogHorizontalPadding);
                                                                if (function27 == null) {
                                                                    centerHorizontally = Alignment.INSTANCE.getStart();
                                                                } else {
                                                                    centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                                                }
                                                                Modifier modifier$iv2 = columnScope2.align(modifierPadding, centerHorizontally);
                                                                Function2<Composer, Integer, Unit> function29 = function28;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                                int $changed$iv$iv2 = (0 << 3) & 112;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                                CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                                                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                $composer6.startReusableNode();
                                                                if ($composer6.getInserting()) {
                                                                    function1 = constructor2;
                                                                    $composer6.createNode(function1);
                                                                } else {
                                                                    function1 = constructor2;
                                                                    $composer6.useNode();
                                                                }
                                                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer6);
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                                                }
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                                                int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                int i12 = ((0 >> 6) & 112) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, 2017444133, "C316@12234L7:Dialogs.kt#g7nzpb");
                                                                function29.invoke($composer6, 0);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                $composer6.endNode();
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            $composer6.skipToGroupEnd();
                                                        }
                                                    }, $composer5, 54), $composer5, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                    }
                                    $composer4.endReplaceGroup();
                                    $composer4.startReplaceGroup(1005018143);
                                    ComposerKt.sourceInformation($composer4, "*322@12456L571,322@12386L641");
                                    if (function25 != null) {
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(j11)), ComposableLambdaKt.rememberComposableLambda(947414862, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$1$1$1$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer5, int $changed4) {
                                                ComposerKt.sourceInformation($composer5, "C324@12540L10,325@12614L391,325@12586L419:Dialogs.kt#g7nzpb");
                                                if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(947414862, $changed4, -1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:323)");
                                                    }
                                                    TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodyMedium();
                                                    final ColumnScope columnScope = $this$invoke_u24lambda_u244;
                                                    final Function2<Composer, Integer, Unit> function27 = function25;
                                                    TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.rememberComposableLambda(788748669, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$1$1$1$3$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                            invoke(composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer $composer6, int $changed5) {
                                                            Function0<ComposeUiNode> function1;
                                                            ComposerKt.sourceInformation($composer6, "C326@12644L335:Dialogs.kt#g7nzpb");
                                                            if (($changed5 & 11) != 2 || !$composer6.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(788748669, $changed5, -1, "com.videshkarmakar.loop.ui.component.LoopDialogVariant.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Dialogs.kt:326)");
                                                                }
                                                                Modifier modifier$iv2 = columnScope.align(PaddingKt.padding(columnScope.weight(Modifier.INSTANCE, 1.0f, false), DialogsKt.TextPadding), Alignment.INSTANCE.getStart());
                                                                Function2<Composer, Integer, Unit> function28 = function27;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                                int $changed$iv$iv2 = (0 << 3) & 112;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                                CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                                                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                $composer6.startReusableNode();
                                                                if ($composer6.getInserting()) {
                                                                    function1 = constructor2;
                                                                    $composer6.createNode(function1);
                                                                } else {
                                                                    function1 = constructor2;
                                                                    $composer6.useNode();
                                                                }
                                                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer6);
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                                                }
                                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                                                int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                int i12 = ((0 >> 6) & 112) | 6;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, 2017444842, "C332@12943L6:Dialogs.kt#g7nzpb");
                                                                function28.invoke($composer6, 0);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                $composer6.endNode();
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            $composer6.skipToGroupEnd();
                                                        }
                                                    }, $composer5, 54), $composer5, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer5.skipToGroupEnd();
                                            }
                                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                    }
                                    $composer4.endReplaceGroup();
                                    Arrangement.HorizontalOrVertical horizontalOrVerticalM496spacedBy0680j_4 = Arrangement.INSTANCE.m496spacedBy0680j_4(Dp.m6553constructorimpl(4));
                                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DialogsKt.DialogHorizontalPadding);
                                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM496spacedBy0680j_4, horizontalAlignment$iv2, $composer4, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                    int $changed$iv$iv2 = (54 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifierPadding);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $i$f$Column = $changed$iv$iv2 << 6;
                                    int $changed$iv$iv$iv2 = ($i$f$Column & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        $composer4.createNode(constructor2);
                                    } else {
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    int i12 = ((54 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1535092931, "C:Dialogs.kt#g7nzpb");
                                    $composer4.startReplaceGroup(1005019045);
                                    ComposerKt.sourceInformation($composer4, "341@13262L8");
                                    if (function26 != null) {
                                        function26.invoke($composer4, 0);
                                    }
                                    $composer4.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 12582912, LocationRequestCompat.QUALITY_LOW_POWER);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            };
            Function2<? super Composer, ? super Integer, Unit> function19 = function8;
            float tonalElevation4 = tonalElevation2;
            AndroidAlertDialog_androidKt.AlertDialog(onDismissRequest, modifier5, properties2, ComposableLambdaKt.rememberComposableLambda(410488308, true, function18, $composer2, 54), $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty1 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            tonalElevation3 = tonalElevation4;
            properties3 = properties2;
            function10 = function6;
            function11 = function9;
            iconContentColor3 = iconContentColor2;
            containerColor3 = containerColor2;
            titleContentColor3 = titleContentColor2;
            textContentColor3 = textContentColor2;
            function12 = function19;
            modifier4 = modifier3;
            function13 = function7;
            shape3 = shape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final Function2<? super Composer, ? super Integer, Unit> function20 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function21 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function22 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function13;
            final Shape shape5 = shape3;
            final long j5 = containerColor3;
            final long j6 = iconContentColor3;
            final long j7 = titleContentColor3;
            final long j8 = textContentColor3;
            final float f2 = tonalElevation3;
            final DialogProperties dialogProperties = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$LoopDialogVariant$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    DialogsKt.m7163LoopDialogVariantq4k6nM(onDismissRequest, modifier6, function20, function21, function22, function23, shape5, j5, j6, j7, j8, f2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: DialogSubtitle-FNF3uiM, reason: not valid java name */
    public static final void m7161DialogSubtitleFNF3uiM(Modifier modifier, final String text, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        int $dirty;
        Modifier modifier3;
        long color2;
        Modifier modifier4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(1423876821);
        ComposerKt.sourceInformation($composer3, "C(DialogSubtitle)P(1,2,0:c#ui.graphics.Color)352@13440L11,361@13696L10,354@13469L254:Dialogs.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(text) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                int i3 = $composer3.changed(j) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                j = color;
            }
            $dirty2 |= i3;
        } else {
            j = color;
        }
        if (($dirty2 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            color2 = j;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    modifier3 = modifier5;
                    color2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    color2 = j;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                color2 = j;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1423876821, $dirty, -1, "com.videshkarmakar.loop.ui.component.DialogSubtitle (Dialogs.kt:353)");
            }
            modifier4 = modifier3;
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(16), 0.0f, Dp.m6553constructorimpl(4), 5, null), color2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer2, (($dirty >> 3) & 14) | ($dirty & 896), 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final long j2 = color2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogsKt$DialogSubtitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    DialogsKt.m7161DialogSubtitleFNF3uiM(modifier6, text, j2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
