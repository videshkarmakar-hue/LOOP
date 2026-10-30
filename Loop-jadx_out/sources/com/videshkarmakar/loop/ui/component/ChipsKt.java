package com.videshkarmakar.loop.ui.component;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.InputChipDefaults;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.SelectableChipElevation;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.ui.theme.FixedAccentColors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Chips.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a^\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aN\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aC\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0018\u001aC\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u001c\u001aI\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0007¢\u0006\u0002\u0010 \u001a\u0081\u0001\u0010!\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\"2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\"2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001aK\u0010+\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"ButtonChip", "", "modifier", "Landroidx/compose/ui/Modifier;", "label", "", "enabled", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconColor", "Landroidx/compose/ui/graphics/Color;", "iconDescription", "onClick", "Lkotlin/Function0;", "ButtonChip-3f6hBDE", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLandroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FlatButtonChip", "labelColor", "FlatButtonChip-jB83MbM", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;JJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OutlinedButtonChip", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ShortcutChip", "text", "onRemove", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SingleChoiceChip", "selected", "leadingIcon", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;II)V", "SingleSelectChip", "Landroidx/compose/runtime/Composable;", "trailingIcon", "colors", "Landroidx/compose/material3/SelectableChipColors;", "elevation", "Landroidx/compose/material3/SelectableChipElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "VideoFilterChip", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ChipsKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0145  */
    /* JADX WARN: Code duplicated, block: B:103:0x0155  */
    /* JADX WARN: Code duplicated, block: B:104:0x015b  */
    /* JADX WARN: Code duplicated, block: B:107:0x0169  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:114:0x0204  */
    /* JADX WARN: Code duplicated, block: B:115:0x0225  */
    /* JADX WARN: Code duplicated, block: B:83:0x0109  */
    /* JADX WARN: Code duplicated, block: B:85:0x0113  */
    /* JADX WARN: Code duplicated, block: B:92:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0133  */
    /* JADX WARN: Code duplicated, block: B:94:0x0138  */
    /* JADX WARN: Code duplicated, block: B:96:0x013b  */
    /* JADX WARN: Code duplicated, block: B:98:0x013f  */
    /* JADX INFO: renamed from: ButtonChip-3f6hBDE, reason: not valid java name */
    public static final void m7105ButtonChip3f6hBDE(Modifier modifier, final String label, boolean enabled, ImageVector icon, long iconColor, String iconDescription, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        ImageVector icon2;
        long iconColor2;
        int i2;
        Modifier.Companion modifier3;
        final String iconDescription2;
        int $dirty;
        final ImageVector icon3;
        long iconColor3;
        Modifier modifier4;
        ImageVector icon4;
        long iconColor4;
        String iconDescription3;
        boolean enabled3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1323440464);
        ComposerKt.sourceInformation($composer2, "C(ButtonChip)P(5,4!2,2:c#ui.graphics.Color)42@1813L11,50@2076L61,49@2023L15,52@2188L221,46@1904L511:Chips.kt#g7nzpb");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
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
            $dirty2 |= $composer2.changed(label) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            enabled2 = enabled;
        } else if (($changed & 896) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            icon2 = icon;
        } else if (($changed & 7168) == 0) {
            icon2 = icon;
            $dirty2 |= $composer2.changed(icon2) ? 2048 : 1024;
        } else {
            icon2 = icon;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                iconColor2 = iconColor;
                int i6 = $composer2.changed(iconColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                iconColor2 = iconColor;
            }
            $dirty2 |= i6;
        } else {
            iconColor2 = iconColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(iconDescription) ? 131072 : 65536;
        }
        if ((i & 64) == 0) {
            if (($changed & 3670016) == 0) {
                i2 = $composer2.changedInstance(onClick) ? 1048576 : 524288;
            }
            if (($dirty2 & 2995931) == 599186 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    if (i3 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enabled2 = true;
                    }
                    if (i5 != 0) {
                        icon2 = null;
                    }
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                        iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                    }
                    if (i7 != 0) {
                        $dirty = $dirty2;
                        iconDescription2 = null;
                        icon3 = icon2;
                        iconColor3 = iconColor2;
                    } else {
                        iconDescription2 = iconDescription;
                        $dirty = $dirty2;
                        icon3 = icon2;
                        iconColor3 = iconColor2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 16) != 0) {
                        $dirty = $dirty2 & (-57345);
                        modifier3 = modifier2;
                        icon3 = icon2;
                        iconColor3 = iconColor2;
                        iconDescription2 = iconDescription;
                    } else {
                        $dirty = $dirty2;
                        modifier3 = modifier2;
                        icon3 = icon2;
                        iconColor3 = iconColor2;
                        iconDescription2 = iconDescription;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1323440464, $dirty, -1, "com.videshkarmakar.loop.ui.component.ButtonChip (Chips.kt:45)");
                }
                modifier4 = modifier3;
                ChipKt.ElevatedAssistChip(onClick, ComposableLambdaKt.rememberComposableLambda(212470813, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$1
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
                        ComposerKt.sourceInformation($composer3, "C49@2025L11:Chips.kt#g7nzpb");
                        if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(212470813, $changed2, -1, "com.videshkarmakar.loop.ui.component.ButtonChip.<anonymous> (Chips.kt:49)");
                        }
                        TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), PaddingKt.m622paddingVpY3zN4$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 2, null), enabled2, ComposableLambdaKt.rememberComposableLambda(-933940000, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$2
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
                        ComposerKt.sourceInformation($composer3, "C53@2220L179:Chips.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-933940000, $changed2, -1, "com.videshkarmakar.loop.ui.component.ButtonChip.<anonymous> (Chips.kt:53)");
                            }
                            if (icon3 != null) {
                                IconKt.m2044Iconww6aTOc(icon3, iconDescription2, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1690getIconSizeD9Ej5fM()), 0L, $composer3, 0, 8);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, AssistChipDefaults.INSTANCE.m1687elevatedAssistChipColorsoq7We08(0L, 0L, iconColor3, 0L, 0L, 0L, 0L, 0L, $composer2, (($dirty >> 6) & 896) | (AssistChipDefaults.$stable << 24), 251), (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 18) & 14) | 24624 | (($dirty << 3) & 7168), 0, 1888);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                icon4 = icon3;
                iconColor4 = iconColor3;
                iconDescription3 = iconDescription2;
                enabled3 = enabled2;
            } else {
                $composer2.skipToGroupEnd();
                iconDescription3 = iconDescription;
                modifier4 = modifier2;
                iconColor4 = iconColor2;
                icon4 = icon2;
                enabled3 = enabled2;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier4;
                final boolean z = enabled3;
                final ImageVector imageVector = icon4;
                final long j = iconColor4;
                final String str = iconDescription3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i8) {
                        ChipsKt.m7105ButtonChip3f6hBDE(modifier5, label, z, imageVector, j, str, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 1572864;
        $dirty2 |= i2;
        if (($dirty2 & 2995931) == 599186) {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    icon2 = null;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    iconDescription2 = null;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                } else {
                    iconDescription2 = iconDescription;
                    $dirty = $dirty2;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                }
            } else {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    icon2 = null;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    iconDescription2 = null;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                } else {
                    iconDescription2 = iconDescription;
                    $dirty = $dirty2;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1323440464, $dirty, -1, "com.videshkarmakar.loop.ui.component.ButtonChip (Chips.kt:45)");
            }
            modifier4 = modifier3;
            ChipKt.ElevatedAssistChip(onClick, ComposableLambdaKt.rememberComposableLambda(212470813, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$1
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
                    ComposerKt.sourceInformation($composer3, "C49@2025L11:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(212470813, $changed2, -1, "com.videshkarmakar.loop.ui.component.ButtonChip.<anonymous> (Chips.kt:49)");
                    }
                    TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), PaddingKt.m622paddingVpY3zN4$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 2, null), enabled2, ComposableLambdaKt.rememberComposableLambda(-933940000, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$2
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
                    ComposerKt.sourceInformation($composer3, "C53@2220L179:Chips.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-933940000, $changed2, -1, "com.videshkarmakar.loop.ui.component.ButtonChip.<anonymous> (Chips.kt:53)");
                        }
                        if (icon3 != null) {
                            IconKt.m2044Iconww6aTOc(icon3, iconDescription2, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1690getIconSizeD9Ej5fM()), 0L, $composer3, 0, 8);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, AssistChipDefaults.INSTANCE.m1687elevatedAssistChipColorsoq7We08(0L, 0L, iconColor3, 0L, 0L, 0L, 0L, 0L, $composer2, (($dirty >> 6) & 896) | (AssistChipDefaults.$stable << 24), 251), (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 18) & 14) | 24624 | (($dirty << 3) & 7168), 0, 1888);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            icon4 = icon3;
            iconColor4 = iconColor3;
            iconDescription3 = iconDescription2;
            enabled3 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    icon2 = null;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    iconDescription2 = null;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                } else {
                    iconDescription2 = iconDescription;
                    $dirty = $dirty2;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                }
            } else {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    icon2 = null;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    iconDescription2 = null;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                } else {
                    iconDescription2 = iconDescription;
                    $dirty = $dirty2;
                    icon3 = icon2;
                    iconColor3 = iconColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1323440464, $dirty, -1, "com.videshkarmakar.loop.ui.component.ButtonChip (Chips.kt:45)");
            }
            modifier4 = modifier3;
            ChipKt.ElevatedAssistChip(onClick, ComposableLambdaKt.rememberComposableLambda(212470813, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$1
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
                    ComposerKt.sourceInformation($composer3, "C49@2025L11:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(212470813, $changed2, -1, "com.videshkarmakar.loop.ui.component.ButtonChip.<anonymous> (Chips.kt:49)");
                    }
                    TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), PaddingKt.m622paddingVpY3zN4$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 2, null), enabled2, ComposableLambdaKt.rememberComposableLambda(-933940000, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$2
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
                    ComposerKt.sourceInformation($composer3, "C53@2220L179:Chips.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-933940000, $changed2, -1, "com.videshkarmakar.loop.ui.component.ButtonChip.<anonymous> (Chips.kt:53)");
                        }
                        if (icon3 != null) {
                            IconKt.m2044Iconww6aTOc(icon3, iconDescription2, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1690getIconSizeD9Ej5fM()), 0L, $composer3, 0, 8);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, AssistChipDefaults.INSTANCE.m1687elevatedAssistChipColorsoq7We08(0L, 0L, iconColor3, 0L, 0L, 0L, 0L, 0L, $composer2, (($dirty >> 6) & 896) | (AssistChipDefaults.$stable << 24), 251), (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 18) & 14) | 24624 | (($dirty << 3) & 7168), 0, 1888);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            icon4 = icon3;
            iconColor4 = iconColor3;
            iconDescription3 = iconDescription2;
            enabled3 = enabled2;
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z2 = enabled3;
            final ImageVector imageVector2 = icon4;
            final long j2 = iconColor4;
            final String str2 = iconDescription3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ButtonChip$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    ChipsKt.m7105ButtonChip3f6hBDE(modifier6, label, z2, imageVector2, j2, str2, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01df  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:71:0x00de  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0107  */
    /* JADX WARN: Code duplicated, block: B:85:0x010c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0111  */
    /* JADX WARN: Code duplicated, block: B:91:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x0134  */
    /* JADX WARN: Code duplicated, block: B:95:0x013f  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d2  */
    /* JADX INFO: renamed from: FlatButtonChip-jB83MbM, reason: not valid java name */
    public static final void m7106FlatButtonChipjB83MbM(Modifier modifier, final ImageVector icon, final String label, long iconColor, long labelColor, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long iconColor2;
        long labelColor2;
        int i2;
        Modifier.Companion modifier3;
        long labelColor3;
        Modifier modifier4;
        long iconColor3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1624031167);
        ComposerKt.sourceInformation($composer2, "C(FlatButtonChip)P(4!1,2,1:c#ui.graphics.Color,3:c#ui.graphics.Color)69@2606L11,70@2665L11,76@2885L11,75@2824L191,88@3272L22,82@3089L165,73@2720L575:Chips.kt#g7nzpb");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
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
            $dirty |= $composer2.changed(label) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                iconColor2 = iconColor;
                int i4 = $composer2.changed(iconColor2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                iconColor2 = iconColor;
            }
            $dirty |= i4;
        } else {
            iconColor2 = iconColor;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                labelColor2 = labelColor;
                int i5 = $composer2.changed(labelColor2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                labelColor2 = labelColor;
            }
            $dirty |= i5;
        } else {
            labelColor2 = labelColor;
        }
        if ((i & 32) == 0) {
            if ((458752 & $changed) == 0) {
                i2 = $composer2.changedInstance(onClick) ? 131072 : 65536;
            }
            if ((374491 & $dirty) == 74898 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    if (i3 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i & 8) != 0) {
                        $dirty &= -7169;
                        iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                    }
                    if ((i & 16) != 0) {
                        $dirty &= -57345;
                        labelColor3 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface();
                    } else {
                        labelColor3 = labelColor2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 8) != 0) {
                        $dirty &= -7169;
                    }
                    if ((i & 16) != 0) {
                        $dirty &= -57345;
                        modifier3 = modifier2;
                        labelColor3 = labelColor2;
                    } else {
                        modifier3 = modifier2;
                        labelColor3 = labelColor2;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1624031167, $dirty, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip (Chips.kt:72)");
                }
                ChipKt.AssistChip(onClick, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1748599874, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$1
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
                        ComposerKt.sourceInformation($composer3, "C88@3274L18:Chips.kt#g7nzpb");
                        if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1748599874, $changed2, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip.<anonymous> (Chips.kt:88)");
                        }
                        TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), PaddingKt.m622paddingVpY3zN4$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 2, null), false, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(561599003, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C83@3103L141:Chips.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(561599003, $changed2, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip.<anonymous> (Chips.kt:83)");
                            }
                            IconKt.m2044Iconww6aTOc(icon, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1690getIconSizeD9Ej5fM()), 0L, $composer3, 48, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, AssistChipDefaults.INSTANCE.m1685assistChipColorsoq7We08(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerLowest(), labelColor3, iconColor2, 0L, 0L, 0L, 0L, 0L, $composer2, (($dirty >> 9) & 112) | (($dirty >> 3) & 896) | (AssistChipDefaults.$stable << 24), 248), (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 15) & 14) | 805330992, 0, 1384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                iconColor3 = iconColor2;
            } else {
                $composer2.skipToGroupEnd();
                labelColor3 = labelColor2;
                modifier4 = modifier2;
                iconColor3 = iconColor2;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier4;
                final long j = iconColor3;
                final long j2 = labelColor3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$3
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
                        ChipsKt.m7106FlatButtonChipjB83MbM(modifier5, icon, label, j, j2, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        $dirty |= i2;
        if ((374491 & $dirty) == 74898) {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    labelColor3 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface();
                } else {
                    labelColor3 = labelColor2;
                }
            } else {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    labelColor3 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface();
                } else {
                    labelColor3 = labelColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1624031167, $dirty, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip (Chips.kt:72)");
            }
            ChipKt.AssistChip(onClick, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1748599874, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$1
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
                    ComposerKt.sourceInformation($composer3, "C88@3274L18:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1748599874, $changed2, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip.<anonymous> (Chips.kt:88)");
                    }
                    TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), PaddingKt.m622paddingVpY3zN4$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 2, null), false, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(561599003, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C83@3103L141:Chips.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(561599003, $changed2, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip.<anonymous> (Chips.kt:83)");
                        }
                        IconKt.m2044Iconww6aTOc(icon, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1690getIconSizeD9Ej5fM()), 0L, $composer3, 48, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, AssistChipDefaults.INSTANCE.m1685assistChipColorsoq7We08(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerLowest(), labelColor3, iconColor2, 0L, 0L, 0L, 0L, 0L, $composer2, (($dirty >> 9) & 112) | (($dirty >> 3) & 896) | (AssistChipDefaults.$stable << 24), 248), (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 15) & 14) | 805330992, 0, 1384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            iconColor3 = iconColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    labelColor3 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface();
                } else {
                    labelColor3 = labelColor2;
                }
            } else {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    iconColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    labelColor3 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface();
                } else {
                    labelColor3 = labelColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1624031167, $dirty, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip (Chips.kt:72)");
            }
            ChipKt.AssistChip(onClick, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1748599874, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$1
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
                    ComposerKt.sourceInformation($composer3, "C88@3274L18:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1748599874, $changed2, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip.<anonymous> (Chips.kt:88)");
                    }
                    TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), PaddingKt.m622paddingVpY3zN4$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 2, null), false, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(561599003, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C83@3103L141:Chips.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(561599003, $changed2, -1, "com.videshkarmakar.loop.ui.component.FlatButtonChip.<anonymous> (Chips.kt:83)");
                        }
                        IconKt.m2044Iconww6aTOc(icon, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1690getIconSizeD9Ej5fM()), 0L, $composer3, 48, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, AssistChipDefaults.INSTANCE.m1685assistChipColorsoq7We08(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerLowest(), labelColor3, iconColor2, 0L, 0L, 0L, 0L, 0L, $composer2, (($dirty >> 9) & 112) | (($dirty >> 3) & 896) | (AssistChipDefaults.$stable << 24), 248), (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 15) & 14) | 805330992, 0, 1384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            iconColor3 = iconColor2;
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final long j3 = iconColor3;
            final long j4 = labelColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$FlatButtonChip$3
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
                    ChipsKt.m7106FlatButtonChipjB83MbM(modifier6, icon, label, j3, j4, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void OutlinedButtonChip(Modifier modifier, ImageVector icon, final String label, Shape shape, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ImageVector icon2;
        Shape shape2;
        Modifier.Companion modifier3;
        int $dirty;
        final ImageVector icon3;
        Shape shape3;
        ImageVector icon4;
        Modifier modifier4;
        Shape shape4;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-92075951);
        ComposerKt.sourceInformation($composer2, "C(OutlinedButtonChip)P(2!2,4)97@3498L5,107@3801L22,100@3602L189,100@3537L302:Chips.kt#g7nzpb");
        int $dirty2 = $changed;
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            icon2 = icon;
        } else if (($changed & 112) == 0) {
            icon2 = icon;
            $dirty2 |= $composer2.changed(icon2) ? 32 : 16;
        } else {
            icon2 = icon;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(label) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(onClick) ? 16384 : 8192;
        }
        if ((46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape4 = shape2;
            icon4 = icon2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    icon2 = null;
                }
                if ((i & 8) != 0) {
                    shape3 = AssistChipDefaults.INSTANCE.getShape($composer2, AssistChipDefaults.$stable);
                    $dirty = $dirty2 & (-7169);
                    icon3 = icon2;
                } else {
                    $dirty = $dirty2;
                    icon3 = icon2;
                    shape3 = shape2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                icon3 = icon2;
                shape3 = shape2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92075951, $dirty, -1, "com.videshkarmakar.loop.ui.component.OutlinedButtonChip (Chips.kt:99)");
            }
            ChipKt.AssistChip(onClick, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1464271090, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.OutlinedButtonChip.1
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
                    ComposerKt.sourceInformation($composer3, "C107@3803L18:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1464271090, $changed2, -1, "com.videshkarmakar.loop.ui.component.OutlinedButtonChip.<anonymous> (Chips.kt:107)");
                    }
                    TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), modifier3, false, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-956839765, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.OutlinedButtonChip.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C*102@3636L139:Chips.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-956839765, $changed2, -1, "com.videshkarmakar.loop.ui.component.OutlinedButtonChip.<anonymous> (Chips.kt:101)");
                        }
                        ImageVector it = icon3;
                        if (it != null) {
                            IconKt.m2044Iconww6aTOc(it, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, AssistChipDefaults.INSTANCE.m1690getIconSizeD9Ej5fM()), 0L, $composer3, 48, 8);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, shape3, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 12) & 14) | 24624 | (($dirty << 6) & 896) | (($dirty << 9) & 3670016), 0, 1960);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            icon4 = icon3;
            modifier4 = modifier3;
            shape4 = shape3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final ImageVector imageVector = icon4;
            final Shape shape5 = shape4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.OutlinedButtonChip.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ChipsKt.OutlinedButtonChip(modifier5, imageVector, label, shape5, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void SingleChoiceChip(Modifier modifier, final boolean selected, boolean enabled, final Function0<Unit> onClick, final String label, ImageVector leadingIcon, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        ImageVector imageVector;
        Modifier modifier3;
        boolean enabled2;
        final ImageVector leadingIcon2;
        int $dirty;
        ImageVector leadingIcon3;
        Modifier modifier4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer3 = $composer.startRestartGroup(-454824475);
        ComposerKt.sourceInformation($composer3, "C(SingleChoiceChip)P(3,5!1,4)126@4290L6,127@4320L42,130@4386L346,121@4109L630:Chips.kt#g7nzpb");
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
            $dirty2 |= $composer3.changed(selected) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            z = enabled;
        } else if (($changed & 896) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(onClick) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(label) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                imageVector = leadingIcon;
                int i4 = $composer3.changed(imageVector) ? 131072 : 65536;
                $dirty2 |= i4;
            } else {
                imageVector = leadingIcon;
            }
            $dirty2 |= i4;
        } else {
            imageVector = leadingIcon;
        }
        if ((374491 & $dirty2) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            enabled2 = z;
            leadingIcon3 = imageVector;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled3 = i3 != 0 ? true : z;
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    modifier3 = modifier5;
                    enabled2 = enabled3;
                    leadingIcon2 = CheckKt.getCheck(Icons.Outlined.INSTANCE);
                } else {
                    modifier3 = modifier5;
                    enabled2 = enabled3;
                    leadingIcon2 = imageVector;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                modifier3 = modifier2;
                enabled2 = z;
                leadingIcon2 = imageVector;
                $dirty = $dirty2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454824475, $dirty, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceChip (Chips.kt:120)");
            }
            leadingIcon3 = leadingIcon2;
            modifier4 = modifier3;
            $composer2 = $composer3;
            ChipKt.FilterChip(selected, onClick, ComposableLambdaKt.rememberComposableLambda(-737333742, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.SingleChoiceChip.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C128@4334L18:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-737333742, $changed2, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceChip.<anonymous> (Chips.kt:128)");
                    }
                    TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), PaddingKt.m622paddingVpY3zN4$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 2, null), enabled2, ComposableLambdaKt.rememberComposableLambda(2104167087, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.SingleChoiceChip.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C131@4400L322:Chips.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2104167087, $changed2, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceChip.<anonymous> (Chips.kt:131)");
                        }
                        boolean z2 = selected;
                        final ImageVector imageVector2 = leadingIcon2;
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
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
                            $composer4.createNode(constructor);
                        } else {
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
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScope $this$invoke_u24lambda_u240 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1981989990, "C132@4461L247,132@4422L286:Chips.kt#g7nzpb");
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u240, z2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1103010547, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$SingleChoiceChip$2$1$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer5, int $changed3) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer5, "C133@4483L207:Chips.kt#g7nzpb");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1103010547, $changed3, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceChip.<anonymous>.<anonymous>.<anonymous> (Chips.kt:133)");
                                }
                                IconKt.m2044Iconww6aTOc(imageVector2, (String) null, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, FilterChipDefaults.INSTANCE.m2008getIconSizeD9Ej5fM()), 0L, $composer5, 48, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ((((0 >> 6) & 112) | 6) & 14) | 1572864, 30);
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
            }, $composer3, 54), null, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getLarge(), null, null, null, null, $composer2, (($dirty >> 3) & 14) | 196992 | (($dirty >> 6) & 112) | (($dirty << 6) & 57344), 0, 3904);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z2 = enabled2;
            final ImageVector imageVector2 = leadingIcon3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.SingleChoiceChip.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ChipsKt.SingleChoiceChip(modifier6, selected, z2, onClick, label, imageVector2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void VideoFilterChip(Modifier modifier, final boolean selected, boolean enabled, final Function0<Unit> onClick, final String label, ImageVector leadingIcon, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        final ImageVector leadingIcon2;
        boolean enabled2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer2 = $composer.startRestartGroup(-923358701);
        ComposerKt.sourceInformation($composer2, "C(VideoFilterChip)P(3,5!1,4)158@5148L42,161@5214L74,154@4989L305:Chips.kt#g7nzpb");
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
            $dirty |= $composer2.changed(selected) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = enabled;
        } else if (($changed & 896) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(onClick) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(label) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            leadingIcon2 = leadingIcon;
        } else if ((458752 & $changed) == 0) {
            leadingIcon2 = leadingIcon;
            $dirty |= $composer2.changed(leadingIcon2) ? 131072 : 65536;
        } else {
            leadingIcon2 = leadingIcon;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enabled2 = z;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            enabled2 = i3 != 0 ? true : z;
            if (i4 != 0) {
                leadingIcon2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-923358701, $dirty2, -1, "com.videshkarmakar.loop.ui.component.VideoFilterChip (Chips.kt:153)");
            }
            modifier3 = modifier4;
            ImageVector leadingIcon3 = leadingIcon2;
            ChipKt.FilterChip(selected, onClick, ComposableLambdaKt.rememberComposableLambda(314454086, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.VideoFilterChip.1
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
                    ComposerKt.sourceInformation($composer3, "C159@5162L18:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(314454086, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoFilterChip.<anonymous> (Chips.kt:159)");
                    }
                    TextKt.m2569Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), PaddingKt.m622paddingVpY3zN4$default(modifier4, Dp.m6553constructorimpl(4), 0.0f, 2, null), enabled2, ComposableLambdaKt.rememberComposableLambda(-1810641911, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.VideoFilterChip.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C*161@5235L49:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1810641911, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoFilterChip.<anonymous> (Chips.kt:161)");
                    }
                    ImageVector it = leadingIcon2;
                    if (it != null) {
                        IconKt.m2044Iconww6aTOc(it, (String) null, (Modifier) null, 0L, $composer3, 48, 12);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, null, null, null, null, null, $composer2, (($dirty2 >> 3) & 14) | 196992 | (($dirty2 >> 6) & 112) | (($dirty2 << 6) & 57344), 0, 4032);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            leadingIcon2 = leadingIcon3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled2;
            final ImageVector imageVector = leadingIcon2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.VideoFilterChip.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ChipsKt.VideoFilterChip(modifier5, selected, z2, onClick, label, imageVector, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void ShortcutChip(Modifier modifier, final String text, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0<Unit> function2;
        Function0<Unit> function3;
        Object value$iv;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-4992820);
        ComposerKt.sourceInformation($composer2, "C(ShortcutChip)P(!1,3)175@5586L21,176@5625L69,177@5719L575,173@5500L795:Chips.kt#g7nzpb");
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
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function2 = function0;
        } else if (($changed & 896) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function3 = function1;
        } else if (($changed & 7168) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function1;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            final Function0<Unit> function4 = i3 != 0 ? null : function2;
            final Function0<Unit> function5 = i4 != 0 ? null : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-4992820, $dirty, -1, "com.videshkarmakar.loop.ui.component.ShortcutChip (Chips.kt:172)");
            }
            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(modifier4, Dp.m6553constructorimpl(4), 0.0f, 2, null);
            $composer2.startReplaceGroup(2015114131);
            ComposerKt.sourceInformation($composer2, "CC(remember):Chips.kt#9igjgp");
            boolean invalid$iv = ($dirty & 896) == 256;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt$ShortcutChip$1$1
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
                        Function0<Unit> function6 = function4;
                        if (function6 != null) {
                            function6.invoke();
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            ChipKt.AssistChip((Function0<Unit>) value$iv, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1973397065, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.ShortcutChip.2
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
                    ComposerKt.sourceInformation($composer3, "C176@5627L65:Chips.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1973397065, $changed2, -1, "com.videshkarmakar.loop.ui.component.ShortcutChip.<anonymous> (Chips.kt:176)");
                    }
                    TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 3120, 120830);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), modifierM622paddingVpY3zN4$default, false, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-971249979, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.ShortcutChip.3
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
                    ComposerKt.sourceInformation($composer3, "C*179@5765L505:Chips.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-971249979, $changed2, -1, "com.videshkarmakar.loop.ui.component.ShortcutChip.<anonymous> (Chips.kt:178)");
                        }
                        if (function5 != null) {
                            IconButtonKt.IconButton(function5, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, InputChipDefaults.INSTANCE.m2057getIconSizeD9Ej5fM()), false, null, null, ComposableSingletons$ChipsKt.INSTANCE.m7107getLambda1$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, 196656, 0, 2008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            function2 = function4;
            function3 = function5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0<Unit> function6 = function2;
            final Function0<Unit> function7 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.ShortcutChip.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ChipsKt.ShortcutChip(modifier5, text, function6, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void SingleSelectChip(final boolean selected, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> label, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, SelectableChipColors colors, SelectableChipElevation elevation, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function3;
        SelectableChipColors selectableChipColors;
        SelectableChipElevation selectableChipElevation;
        MutableInteractionSource mutableInteractionSource;
        Modifier modifier2;
        boolean enabled2;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int $dirty;
        SelectableChipColors colors2;
        SelectableChipElevation elevation2;
        MutableInteractionSource interactionSource2;
        int $dirty2;
        SelectableChipElevation elevation3;
        Object value$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer $composer3 = $composer.startRestartGroup(2032751601);
        ComposerKt.sourceInformation($composer3, "C(SingleSelectChip)P(7,6,4,5,2,8)204@6656L12,205@6717L14,206@6786L14,207@6856L14,208@6911L11,209@6982L11,210@7040L11,203@6587L480,212@7130L21,213@7203L39,233@7848L6,215@7251L746:Chips.kt#g7nzpb");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changedInstance(label) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function2;
        } else if ((458752 & $changed) == 0) {
            function3 = function2;
            $dirty3 |= $composer3.changedInstance(function3) ? 131072 : 65536;
        } else {
            function3 = function2;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                selectableChipColors = colors;
                int i5 = $composer3.changed(selectableChipColors) ? 1048576 : 524288;
                $dirty3 |= i5;
            } else {
                selectableChipColors = colors;
            }
            $dirty3 |= i5;
        } else {
            selectableChipColors = colors;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0) {
                selectableChipElevation = elevation;
                int i6 = $composer3.changed(selectableChipElevation) ? 8388608 : 4194304;
                $dirty3 |= i6;
            } else {
                selectableChipElevation = elevation;
            }
            $dirty3 |= i6;
        } else {
            selectableChipElevation = elevation;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 234881024) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed(mutableInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            function4 = function3;
            colors2 = selectableChipColors;
            elevation3 = selectableChipElevation;
            interactionSource2 = mutableInteractionSource;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                function4 = i4 != 0 ? null : function3;
                if ((i & 64) != 0) {
                    $dirty = $dirty3 & (-3670017);
                    colors2 = FilterChipDefaults.INSTANCE.m2005filterChipColorsXqyqHi0(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerHighest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, 0L, 0L, 0L, FixedAccentColors.INSTANCE.getPrimaryFixed($composer3, 6), 0L, FixedAccentColors.INSTANCE.getOnPrimaryFixed($composer3, 6), FixedAccentColors.INSTANCE.getOnPrimaryFixed($composer3, 6), FixedAccentColors.INSTANCE.getOnPrimaryFixed($composer3, 6), $composer3, 0, FilterChipDefaults.$stable << 6, 376);
                } else {
                    $dirty = $dirty3;
                    colors2 = selectableChipColors;
                }
                if ((i & 128) != 0) {
                    elevation2 = FilterChipDefaults.INSTANCE.m2006filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, FilterChipDefaults.$stable << 18, 63);
                    $dirty &= -29360129;
                } else {
                    elevation2 = elevation;
                }
                if (i7 != 0) {
                    $composer3.startReplaceGroup(1507014662);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chips.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $dirty2 = $dirty;
                    elevation3 = elevation2;
                } else {
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    elevation3 = elevation2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty3 & (-29360129);
                    function4 = function3;
                    colors2 = selectableChipColors;
                    elevation3 = selectableChipElevation;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty3;
                    function4 = function3;
                    colors2 = selectableChipColors;
                    elevation3 = selectableChipElevation;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2032751601, $dirty2, -1, "com.videshkarmakar.loop.ui.component.SingleSelectChip (Chips.kt:214)");
            }
            $composer2 = $composer3;
            ChipKt.FilterChip(selected, onClick, label, modifier2, enabled2, ComposableSingletons$ChipsKt.INSTANCE.m7108getLambda2$app_debug(), function4, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraLarge(), colors2, elevation3, null, interactionSource2, $composer2, ($dirty2 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty2 << 3) & 3670016) | (($dirty2 << 6) & 234881024) | (($dirty2 << 6) & 1879048192), (($dirty2 >> 21) & 112) | 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z = enabled2;
            final Function2<? super Composer, ? super Integer, Unit> function5 = function4;
            final SelectableChipColors selectableChipColors2 = colors2;
            final SelectableChipElevation selectableChipElevation2 = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ChipsKt.SingleSelectChip.2
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
                    ChipsKt.SingleSelectChip(selected, onClick, label, modifier3, z, function5, selectableChipColors2, selectableChipElevation2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
