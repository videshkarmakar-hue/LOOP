package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.OpenInNewKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Buttons.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a%\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\n\u001a?\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0010\u001a?\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0081\u0001\u0010\u0018\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010#¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0002\u0010'\u001aD\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020*H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aD\u0010-\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020*2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"ConfirmButton", "", "text", "", "enabled", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DismissButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FilledButtonWithIcon", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FilledTonalButtonWithIcon", "colors", "Landroidx/compose/material3/ButtonColors;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/material3/ButtonColors;Landroidx/compose/runtime/Composer;II)V", "LinkButton", "link", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "LongTapTextButton", "onClickLabel", "onLongClick", "onLongClickLabel", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButtonWithIcon", "contentColor", "Landroidx/compose/ui/graphics/Color;", "OutlinedButtonWithIcon-yrwZFoE", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "TextButtonWithIcon", "TextButtonWithIcon-uDo3WH8", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ButtonsKt {
    /* JADX INFO: renamed from: OutlinedButtonWithIcon-yrwZFoE, reason: not valid java name */
    public static final void m7103OutlinedButtonWithIconyrwZFoE(Modifier modifier, final Function0<Unit> onClick, final ImageVector icon, final String text, long contentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        int $dirty;
        Modifier modifier3;
        long contentColor2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(2051060);
        ComposerKt.sourceInformation($composer3, "C(OutlinedButtonWithIcon)P(2,3,1,4,0:c#ui.graphics.Color)47@2012L11,53@2214L49,55@2274L267,49@2040L501:Buttons.kt#g7nzpb");
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
            $dirty2 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(icon) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(text) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                j = contentColor;
                int i3 = $composer3.changed(j) ? 16384 : 8192;
                $dirty2 |= i3;
            } else {
                j = contentColor;
            }
            $dirty2 |= i3;
        } else {
            j = contentColor;
        }
        if ((46811 & $dirty2) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            contentColor2 = j;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    modifier3 = modifier4;
                    contentColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    contentColor2 = j;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                contentColor2 = j;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2051060, $dirty, -1, "com.videshkarmakar.loop.ui.component.OutlinedButtonWithIcon (Buttons.kt:48)");
            }
            $composer2 = $composer3;
            ButtonKt.OutlinedButton(onClick, modifier3, false, null, ButtonDefaults.INSTANCE.m1721outlinedButtonColorsro_MJ88(0L, contentColor2, 0L, 0L, $composer3, (($dirty >> 9) & 112) | (ButtonDefaults.$stable << 12), 13), null, null, ButtonDefaults.INSTANCE.getButtonWithIconContentPadding(), null, ComposableLambdaKt.rememberComposableLambda(-1887026878, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$OutlinedButtonWithIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope OutlinedButton, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                    ComposerKt.sourceInformation($composer4, "C56@2284L148,61@2441L94:Buttons.kt#g7nzpb");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1887026878, $changed2, -1, "com.videshkarmakar.loop.ui.component.OutlinedButtonWithIcon.<anonymous> (Buttons.kt:56)");
                        }
                        IconKt.m2044Iconww6aTOc(icon, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1717getIconSizeD9Ej5fM()), 0L, $composer4, 48, 8);
                        TextKt.m2569Text4IGK_g(text, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 48, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 805306368 | (($dirty << 3) & 112), 364);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j2 = contentColor2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$OutlinedButtonWithIcon$2
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
                    ButtonsKt.m7103OutlinedButtonWithIconyrwZFoE(modifier5, onClick, icon, text, j2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: TextButtonWithIcon-uDo3WH8, reason: not valid java name */
    public static final void m7104TextButtonWithIconuDo3WH8(Modifier modifier, final ImageVector icon, final String text, long contentColor, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long contentColor2;
        Modifier.Companion modifier3;
        Modifier modifier4;
        long contentColor3;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1952138793);
        ComposerKt.sourceInformation($composer2, "C(TextButtonWithIcon)P(2,1,4,0:c#ui.graphics.Color)73@2697L11,80@2921L45,82@2977L358,76@2751L584:Buttons.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(icon) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(text) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i3 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i3;
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(onClick) ? 16384 : 8192;
        }
        if ((46811 & $dirty) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            contentColor3 = contentColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    contentColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1952138793, $dirty, -1, "com.videshkarmakar.loop.ui.component.TextButtonWithIcon (Buttons.kt:75)");
            }
            ButtonKt.TextButton(onClick, modifier3, false, null, ButtonDefaults.INSTANCE.m1722textButtonColorsro_MJ88(0L, contentColor2, 0L, 0L, $composer2, (($dirty >> 6) & 112) | (ButtonDefaults.$stable << 12), 13), null, null, ButtonDefaults.INSTANCE.getButtonWithIconContentPadding(), null, ComposableLambdaKt.rememberComposableLambda(1727785082, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$TextButtonWithIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation($composer3, "C83@2987L341:Buttons.kt#g7nzpb");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1727785082, $changed2, -1, "com.videshkarmakar.loop.ui.component.TextButtonWithIcon.<anonymous> (Buttons.kt:83)");
                        }
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        ImageVector imageVector = icon;
                        String str = text;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i5 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -975675356, "C84@3053L146,89@3212L106:Buttons.kt#g7nzpb");
                        IconKt.m2044Iconww6aTOc(imageVector, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(18)), 0L, $composer3, 432, 8);
                        Modifier modifier$iv2 = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
                        TextKt.m2569Text4IGK_g(str, modifier$iv2, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 12) & 14) | 805306368 | (($dirty << 3) & 112), 364);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j = contentColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$TextButtonWithIcon$2
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
                    ButtonsKt.m7104TextButtonWithIconuDo3WH8(modifier5, icon, text, j, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FilledTonalButtonWithIcon(Modifier modifier, final Function0<Unit> onClick, final ImageVector icon, final String text, ButtonColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ButtonColors buttonColors;
        int $dirty;
        Modifier modifier3;
        ButtonColors colors2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(704819019);
        ComposerKt.sourceInformation($composer3, "C(FilledTonalButtonWithIcon)P(2,3,1,4)104@3525L25,112@3739L249,106@3560L428:Buttons.kt#g7nzpb");
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
            $dirty2 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(icon) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(text) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                buttonColors = colors;
                int i3 = $composer3.changed(buttonColors) ? 16384 : 8192;
                $dirty2 |= i3;
            } else {
                buttonColors = colors;
            }
            $dirty2 |= i3;
        } else {
            buttonColors = colors;
        }
        if ((46811 & $dirty2) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            colors2 = buttonColors;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    modifier3 = modifier4;
                    colors2 = ButtonDefaults.INSTANCE.filledTonalButtonColors($composer3, ButtonDefaults.$stable);
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    colors2 = buttonColors;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                colors2 = buttonColors;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(704819019, $dirty, -1, "com.videshkarmakar.loop.ui.component.FilledTonalButtonWithIcon (Buttons.kt:105)");
            }
            $composer2 = $composer3;
            ButtonKt.FilledTonalButton(onClick, modifier3, false, null, colors2, null, null, ButtonDefaults.INSTANCE.getButtonWithIconContentPadding(), null, ComposableLambdaKt.rememberComposableLambda(-2136622791, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.FilledTonalButtonWithIcon.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope FilledTonalButton, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
                    ComposerKt.sourceInformation($composer4, "C113@3749L130,118@3888L94:Buttons.kt#g7nzpb");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2136622791, $changed2, -1, "com.videshkarmakar.loop.ui.component.FilledTonalButtonWithIcon.<anonymous> (Buttons.kt:113)");
                        }
                        IconKt.m2044Iconww6aTOc(icon, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(18)), 0L, $composer4, 432, 8);
                        TextKt.m2569Text4IGK_g(text, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 48, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 805306368 | (($dirty << 3) & 112) | ($dirty & 57344), 364);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ButtonColors buttonColors2 = colors2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.FilledTonalButtonWithIcon.2
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
                    ButtonsKt.FilledTonalButtonWithIcon(modifier5, onClick, icon, text, buttonColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FilledButtonWithIcon(Modifier modifier, final ImageVector icon, final String text, boolean enabled, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        boolean enabled2;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(1645532945);
        ComposerKt.sourceInformation($composer2, "C(FilledButtonWithIcon)P(2,1,4)139@4338L249,133@4168L419:Buttons.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(icon) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(text) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(onClick) ? 16384 : 8192;
        }
        if ((46811 & $dirty) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = z;
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            boolean enabled3 = i3 != 0 ? true : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1645532945, $dirty, -1, "com.videshkarmakar.loop.ui.component.FilledButtonWithIcon (Buttons.kt:132)");
            }
            ButtonKt.Button(onClick, modifier4, enabled3, null, null, null, null, ButtonDefaults.INSTANCE.getButtonWithIconContentPadding(), null, ComposableLambdaKt.rememberComposableLambda(1652341025, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.FilledButtonWithIcon.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope Button, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    ComposerKt.sourceInformation($composer3, "C140@4348L130,145@4487L94:Buttons.kt#g7nzpb");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1652341025, $changed2, -1, "com.videshkarmakar.loop.ui.component.FilledButtonWithIcon.<anonymous> (Buttons.kt:140)");
                        }
                        IconKt.m2044Iconww6aTOc(icon, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(18)), 0L, $composer3, 432, 8);
                        TextKt.m2569Text4IGK_g(text, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 12) & 14) | 805306368 | (($dirty << 3) & 112) | (($dirty >> 3) & 896), 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            enabled2 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.FilledButtonWithIcon.2
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
                    ButtonsKt.FilledButtonWithIcon(modifier5, icon, text, z2, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void ConfirmButton(String text, boolean enabled, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        String text2;
        boolean z;
        int $dirty;
        final String text3;
        boolean enabled2;
        String text4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(1451206137);
        ComposerKt.sourceInformation($composer2, "C(ConfirmButton)P(2)154@4641L32,158@4785L26,158@4736L75:Buttons.kt#g7nzpb");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            if ((i & 1) == 0) {
                text2 = text;
                int i2 = $composer2.changed(text2) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                text2 = text;
            }
            $dirty2 |= i2;
        } else {
            text2 = text;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            z = enabled;
        } else if (($changed & 112) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = enabled;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changedInstance(onClick) ? 256 : 128;
        }
        if (($dirty2 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            text4 = text2;
            enabled2 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    text2 = StringResources_androidKt.stringResource(R.string.confirm, $composer2, 0);
                    $dirty2 &= -15;
                }
                if (i3 != 0) {
                    $dirty = $dirty2;
                    text3 = text2;
                    enabled2 = true;
                } else {
                    $dirty = $dirty2;
                    text3 = text2;
                    enabled2 = z;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                $dirty = $dirty2;
                text3 = text2;
                enabled2 = z;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1451206137, $dirty, -1, "com.videshkarmakar.loop.ui.component.ConfirmButton (Buttons.kt:157)");
            }
            text4 = text3;
            ButtonKt.TextButton(onClick, null, enabled2, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-866464356, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.ConfirmButton.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation($composer3, "C159@4795L10:Buttons.kt#g7nzpb");
                    if (($changed2 & 81) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-866464356, $changed2, -1, "com.videshkarmakar.loop.ui.component.ConfirmButton.<anonymous> (Buttons.kt:159)");
                    }
                    TextKt.m2569Text4IGK_g(text3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 805306368 | (($dirty << 3) & 896), HttpStatusCodesKt.HTTP_VARIANT_ALSO_NEGOTIATES);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str = text4;
            final boolean z2 = enabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.ConfirmButton.2
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
                    ButtonsKt.ConfirmButton(str, z2, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0089  */
    public static final void DismissButton(String text, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        final String text2;
        int $dirty;
        final String text3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-384101613);
        ComposerKt.sourceInformation($composer2, "C(DismissButton)P(1)164@4860L32,165@4951L26,165@4921L56:Buttons.kt#g7nzpb");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            if ((i & 1) == 0) {
                text2 = text;
                int i2 = $composer2.changed(text2) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                text2 = text;
            }
            $dirty2 |= i2;
        } else {
            text2 = text;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(onClick) ? 32 : 16;
        }
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty = $dirty2 & (-15);
                    text3 = text2;
                } else {
                    $dirty = $dirty2;
                    text3 = text2;
                }
            } else if ((i & 1) != 0) {
                $dirty = $dirty2 & (-15);
                text3 = StringResources_androidKt.stringResource(R.string.dismiss, $composer2, 0);
            } else {
                $dirty = $dirty2;
                text3 = text2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-384101613, $dirty, -1, "com.videshkarmakar.loop.ui.component.DismissButton (Buttons.kt:164)");
            }
            String text4 = text3;
            ButtonKt.TextButton(onClick, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-595751498, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.DismissButton.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation($composer3, "C166@4961L10:Buttons.kt#g7nzpb");
                    if (($changed2 & 81) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-595751498, $changed2, -1, "com.videshkarmakar.loop.ui.component.DismissButton.<anonymous> (Buttons.kt:166)");
                    }
                    TextKt.m2569Text4IGK_g(text3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            text2 = text4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.DismissButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    ButtonsKt.DismissButton(text2, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void LinkButton(Modifier modifier, String text, ImageVector icon, String link, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        ImageVector imageVector;
        String str2;
        Modifier.Companion modifier3;
        String text2;
        ImageVector icon2;
        final String link2;
        Modifier modifier4;
        String text3;
        ImageVector icon3;
        String link3;
        Composer $composer2 = $composer.startRestartGroup(375773231);
        ComposerKt.sourceInformation($composer2, "C(LinkButton)P(2,3)173@5063L36,177@5226L7,178@5238L143:Buttons.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                str = text;
                int i3 = $composer2.changed(str) ? 32 : 16;
                $dirty |= i3;
            } else {
                str = text;
            }
            $dirty |= i3;
        } else {
            str = text;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                imageVector = icon;
                int i4 = $composer2.changed(imageVector) ? 256 : 128;
                $dirty |= i4;
            } else {
                imageVector = icon;
            }
            $dirty |= i4;
        } else {
            imageVector = icon;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            str2 = link;
        } else if (($changed & 7168) == 0) {
            str2 = link;
            $dirty |= $composer2.changed(str2) ? 2048 : 1024;
        } else {
            str2 = link;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            icon3 = imageVector;
            link3 = str2;
            text3 = str;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    text2 = StringResources_androidKt.stringResource(R.string.yt_dlp_docs, $composer2, 0);
                    $dirty &= -113;
                } else {
                    text2 = str;
                }
                if ((i & 4) != 0) {
                    icon2 = OpenInNewKt.getOpenInNew(Icons.Outlined.INSTANCE);
                    $dirty &= -897;
                } else {
                    icon2 = imageVector;
                }
                link2 = i5 != 0 ? AdvancedSettingDialogsKt.ytdlpReference : str2;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                text2 = str;
                icon2 = imageVector;
                link2 = str2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(375773231, $dirty, -1, "com.videshkarmakar.loop.ui.component.LinkButton (Buttons.kt:176)");
            }
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final UriHandler uriHandler = (UriHandler) objConsume;
            m7104TextButtonWithIconuDo3WH8(modifier3, icon2, text2, 0L, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.LinkButton.1
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
                    uriHandler.openUri(link2);
                }
            }, $composer2, ($dirty & 14) | (($dirty >> 3) & 112) | (($dirty << 3) & 896), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            text3 = text2;
            icon3 = icon2;
            link3 = link2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final String str3 = text3;
            final ImageVector imageVector2 = icon3;
            final String str4 = link3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.LinkButton.2
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
                    ButtonsKt.LinkButton(modifier5, str3, imageVector2, str4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0150 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x0152  */
    /* JADX WARN: Code duplicated, block: B:105:0x0157  */
    /* JADX WARN: Code duplicated, block: B:108:0x015c  */
    /* JADX WARN: Code duplicated, block: B:111:0x016b  */
    /* JADX WARN: Code duplicated, block: B:112:0x016d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0173  */
    /* JADX WARN: Code duplicated, block: B:116:0x0180  */
    /* JADX WARN: Code duplicated, block: B:119:0x018e  */
    /* JADX WARN: Code duplicated, block: B:122:0x023b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0247  */
    /* JADX WARN: Code duplicated, block: B:126:0x024d  */
    /* JADX WARN: Code duplicated, block: B:129:0x027e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0294 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x032d  */
    /* JADX WARN: Code duplicated, block: B:140:0x0336  */
    /* JADX WARN: Code duplicated, block: B:141:0x035e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0122  */
    /* JADX WARN: Code duplicated, block: B:93:0x012f  */
    public static final void LongTapTextButton(final Function0<Unit> onClick, final String onClickLabel, final Function0<Unit> onLongClick, final String onLongClickLabel, Modifier modifier, Shape shape, BorderStroke border, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        PaddingValues contentPadding2;
        int i2;
        Modifier.Companion modifier3;
        BorderStroke border2;
        Modifier modifier4;
        BorderStroke border3;
        Shape shape3;
        int $dirty;
        final PaddingValues contentPadding3;
        Shape shape4;
        Modifier modifier5;
        Composer $composer2;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function0;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onClickLabel, "onClickLabel");
        Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
        Intrinsics.checkNotNullParameter(onLongClickLabel, "onLongClickLabel");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-103717020);
        ComposerKt.sourceInformation($composer3, "C(LongTapTextButton)P(4,5,6,7,3,8!1,2)194@5673L5,199@5881L11,200@5905L953:Buttons.kt#g7nzpb");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(onClickLabel) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changedInstance(onLongClick) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(onLongClickLabel) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            modifier2 = modifier;
        } else if ((57344 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i4 = $composer3.changed(shape2) ? 131072 : 65536;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0) {
                contentPadding2 = contentPadding;
                int i5 = $composer3.changed(contentPadding2) ? 8388608 : 4194304;
                $dirty2 |= i5;
            } else {
                contentPadding2 = contentPadding;
            }
            $dirty2 |= i5;
        } else {
            contentPadding2 = contentPadding;
        }
        if ((i & 256) == 0) {
            if ((234881024 & $changed) == 0) {
                i2 = $composer3.changedInstance(content) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
            }
            if ((189118171 & $dirty2) == 37823634 || !$composer3.getSkipping()) {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    if (i3 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i & 32) != 0) {
                        $dirty2 &= -458753;
                        shape2 = ButtonDefaults.INSTANCE.getShape($composer3, ButtonDefaults.$stable);
                    }
                    if ((i & 64) != 0) {
                        border2 = null;
                    } else {
                        border2 = border;
                    }
                    if ((i & 128) != 0) {
                        contentPadding2 = ButtonDefaults.INSTANCE.getButtonWithIconContentPadding();
                        modifier4 = modifier3;
                        border3 = border2;
                        shape3 = shape2;
                        $dirty = $dirty2 & (-29360129);
                    } else {
                        modifier4 = modifier3;
                        border3 = border2;
                        shape3 = shape2;
                        $dirty = $dirty2;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 32) != 0) {
                        $dirty2 &= -458753;
                    }
                    if ((i & 128) != 0) {
                        border3 = border;
                        modifier4 = modifier2;
                        shape3 = shape2;
                        $dirty = $dirty2 & (-29360129);
                    } else {
                        border3 = border;
                        modifier4 = modifier2;
                        shape3 = shape2;
                        $dirty = $dirty2;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-103717020, $dirty, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton (Buttons.kt:198)");
                }
                long contentColor = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                contentPadding3 = contentPadding2;
                shape4 = shape3;
                modifier5 = modifier4;
                Modifier modifier$iv = ClickableKt.m242combinedClickablecJG_KMw(ClipKt.clip(modifier4, shape3), (36 & 1) != 0, (36 & 2) != 0 ? null : onClickLabel, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : onLongClickLabel, (36 & 16) != 0 ? null : onLongClick, (36 & 32) != 0 ? null : null, onClick);
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function0 = constructor;
                    $composer2.createNode(function0);
                } else {
                    function0 = constructor;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i7 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 942533025, "C210@6267L585,210@6201L651:Buttons.kt#g7nzpb");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(contentColor)), ComposableLambdaKt.rememberComposableLambda(-1033950072, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$LongTapTextButton$1$1
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

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C211@6320L10,211@6343L499,211@6281L561:Buttons.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1033950072, $changed2, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton.<anonymous>.<anonymous> (Buttons.kt:211)");
                            }
                            TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge();
                            final PaddingValues paddingValues = contentPadding3;
                            final Function3<RowScope, Composer, Integer, Unit> function3 = content;
                            TextKt.ProvideTextStyle(labelLarge, ComposableLambdaKt.rememberComposableLambda(-1254265351, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$LongTapTextButton$1$1.1
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

                                public final void invoke(Composer $composer5, int $changed3) {
                                    ComposerKt.sourceInformation($composer5, "C212@6361L467:Buttons.kt#g7nzpb");
                                    if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1254265351, $changed3, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton.<anonymous>.<anonymous>.<anonymous> (Buttons.kt:212)");
                                        }
                                        Modifier modifier$iv2 = PaddingKt.padding(SizeKt.m649defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1720getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1719getMinHeightD9Ej5fM()), paddingValues);
                                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                        int $changed$iv$iv2 = (432 << 3) & 112;
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
                                            $composer5.createNode(constructor2);
                                        } else {
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
                                        int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                        function4.invoke(RowScopeInstance.INSTANCE, $composer5, Integer.valueOf(((432 >> 6) & 112) | 6));
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
                            }, $composer4, 54), $composer4, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                border3 = border;
                modifier5 = modifier2;
                shape4 = shape2;
                contentPadding3 = contentPadding2;
                $composer2 = $composer3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier5;
                final Shape shape5 = shape4;
                final BorderStroke borderStroke = border3;
                final PaddingValues paddingValues = contentPadding3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.LongTapTextButton.2
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

                    public final void invoke(Composer composer, int i8) {
                        ButtonsKt.LongTapTextButton(onClick, onClickLabel, onLongClick, onLongClickLabel, modifier6, shape5, borderStroke, paddingValues, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 100663296;
        $dirty2 |= i2;
        if ((189118171 & $dirty2) == 37823634) {
            $composer3.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    shape2 = ButtonDefaults.INSTANCE.getShape($composer3, ButtonDefaults.$stable);
                }
                if ((i & 64) != 0) {
                    border2 = null;
                } else {
                    border2 = border;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = ButtonDefaults.INSTANCE.getButtonWithIconContentPadding();
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2;
                }
            } else {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    shape2 = ButtonDefaults.INSTANCE.getShape($composer3, ButtonDefaults.$stable);
                }
                if ((i & 64) != 0) {
                    border2 = null;
                } else {
                    border2 = border;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = ButtonDefaults.INSTANCE.getButtonWithIconContentPadding();
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-103717020, $dirty, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton (Buttons.kt:198)");
            }
            long contentColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
            contentPadding3 = contentPadding2;
            shape4 = shape3;
            modifier5 = modifier4;
            Modifier modifier$iv2 = ClickableKt.m242combinedClickablecJG_KMw(ClipKt.clip(modifier4, shape3), (36 & 1) != 0, (36 & 2) != 0 ? null : onClickLabel, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : onLongClickLabel, (36 & 16) != 0 ? null : onLongClick, (36 & 32) != 0 ? null : null, onClick);
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 942533025, "C210@6267L585,210@6201L651:Buttons.kt#g7nzpb");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(contentColor2)), ComposableLambdaKt.rememberComposableLambda(-1033950072, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$LongTapTextButton$1$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C211@6320L10,211@6343L499,211@6281L561:Buttons.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1033950072, $changed2, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton.<anonymous>.<anonymous> (Buttons.kt:211)");
                        }
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge();
                        final PaddingValues paddingValues2 = contentPadding3;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                        TextKt.ProvideTextStyle(labelLarge, ComposableLambdaKt.rememberComposableLambda(-1254265351, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$LongTapTextButton$1$1.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C212@6361L467:Buttons.kt#g7nzpb");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1254265351, $changed3, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton.<anonymous>.<anonymous>.<anonymous> (Buttons.kt:212)");
                                    }
                                    Modifier modifier$iv3 = PaddingKt.padding(SizeKt.m649defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1720getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1719getMinHeightD9Ej5fM()), paddingValues2);
                                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                    int $changed$iv$iv3 = (432 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        $composer5.createNode(constructor2);
                                    } else {
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer5);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    function4.invoke(RowScopeInstance.INSTANCE, $composer5, Integer.valueOf(((432 >> 6) & 112) | 6));
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
                        }, $composer4, 54), $composer4, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    shape2 = ButtonDefaults.INSTANCE.getShape($composer3, ButtonDefaults.$stable);
                }
                if ((i & 64) != 0) {
                    border2 = null;
                } else {
                    border2 = border;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = ButtonDefaults.INSTANCE.getButtonWithIconContentPadding();
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2;
                }
            } else {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    shape2 = ButtonDefaults.INSTANCE.getShape($composer3, ButtonDefaults.$stable);
                }
                if ((i & 64) != 0) {
                    border2 = null;
                } else {
                    border2 = border;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = ButtonDefaults.INSTANCE.getButtonWithIconContentPadding();
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier4 = modifier3;
                    border3 = border2;
                    shape3 = shape2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-103717020, $dirty, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton (Buttons.kt:198)");
            }
            long contentColor3 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
            contentPadding3 = contentPadding2;
            shape4 = shape3;
            modifier5 = modifier4;
            Modifier modifier$iv3 = ClickableKt.m242combinedClickablecJG_KMw(ClipKt.clip(modifier4, shape3), (36 & 1) != 0, (36 & 2) != 0 ? null : onClickLabel, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : onLongClickLabel, (36 & 16) != 0 ? null : onLongClick, (36 & 32) != 0 ? null : null, onClick);
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            int i11 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 942533025, "C210@6267L585,210@6201L651:Buttons.kt#g7nzpb");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4033boximpl(contentColor3)), ComposableLambdaKt.rememberComposableLambda(-1033950072, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$LongTapTextButton$1$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C211@6320L10,211@6343L499,211@6281L561:Buttons.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1033950072, $changed2, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton.<anonymous>.<anonymous> (Buttons.kt:211)");
                        }
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge();
                        final PaddingValues paddingValues2 = contentPadding3;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
                        TextKt.ProvideTextStyle(labelLarge, ComposableLambdaKt.rememberComposableLambda(-1254265351, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt$LongTapTextButton$1$1.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C212@6361L467:Buttons.kt#g7nzpb");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1254265351, $changed3, -1, "com.videshkarmakar.loop.ui.component.LongTapTextButton.<anonymous>.<anonymous>.<anonymous> (Buttons.kt:212)");
                                    }
                                    Modifier modifier$iv4 = PaddingKt.padding(SizeKt.m649defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1720getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1719getMinHeightD9Ej5fM()), paddingValues2);
                                    Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                    int $changed$iv$iv4 = (432 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv4 = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv4);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        $composer5.createNode(constructor2);
                                    } else {
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer5);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash4);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    function4.invoke(RowScopeInstance.INSTANCE, $composer5, Integer.valueOf(((432 >> 6) & 112) | 6));
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
                        }, $composer4, 54), $composer4, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier5;
            final Shape shape6 = shape4;
            final BorderStroke borderStroke2 = border3;
            final PaddingValues paddingValues2 = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ButtonsKt.LongTapTextButton.2
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

                public final void invoke(Composer composer, int i12) {
                    ButtonsKt.LongTapTextButton(onClick, onClickLabel, onLongClick, onLongClickLabel, modifier7, shape6, borderStroke2, paddingValues2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
