package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SegmentedButtonColors;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: SegementedButton.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0007¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EndSegmentedButtonShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StartSegmentedButtonShape", "SingleChoiceSegmentedButton", "", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "selected", "", "position", "Lcom/videshkarmakar/loop/ui/component/SegmentedButtonValues;", "enabled", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLcom/videshkarmakar/loop/ui/component/SegmentedButtonValues;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SegementedButtonKt {
    private static final RoundedCornerShape StartSegmentedButtonShape = RoundedCornerShapeKt.RoundedCornerShape$default(100, 0, 0, 100, 6, (Object) null);
    private static final RoundedCornerShape EndSegmentedButtonShape = RoundedCornerShapeKt.RoundedCornerShape$default(0, 100, 100, 0, 9, (Object) null);

    /* JADX WARN: Code duplicated, block: B:101:0x018a  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:109:0x0210  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x010b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x010d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0113  */
    /* JADX WARN: Code duplicated, block: B:86:0x0116  */
    /* JADX WARN: Code duplicated, block: B:88:0x011d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0121  */
    /* JADX WARN: Code duplicated, block: B:92:0x0129  */
    /* JADX WARN: Code duplicated, block: B:95:0x016e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0174  */
    /* JADX WARN: Code duplicated, block: B:98:0x017c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0182  */
    public static final void SingleChoiceSegmentedButton(final SingleChoiceSegmentedButtonRowScope $this$SingleChoiceSegmentedButton, Modifier modifier, final String text, final boolean selected, SegmentedButtonValues position, boolean enabled, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SegmentedButtonValues position2;
        boolean z;
        int i2;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        Shape rectangleShape;
        SegmentedButtonValues position3;
        Modifier modifier4;
        Composer $composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter($this$SingleChoiceSegmentedButton, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-57875230);
        ComposerKt.sourceInformation($composer3, "C(SingleChoiceSegmentedButton)P(1,5,4,3)29@1142L50,35@1438L33,25@966L505:SegementedButton.kt#g7nzpb");
        int $dirty2 = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed($this$SingleChoiceSegmentedButton) ? 4 : 2;
        }
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(text) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(selected) ? 2048 : 1024;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            position2 = position;
        } else if ((57344 & $changed) == 0) {
            position2 = position;
            $dirty2 |= $composer3.changed(position2) ? 16384 : 8192;
        } else {
            position2 = position;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = enabled;
        } else if (($changed & 458752) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 131072 : 65536;
        } else {
            z = enabled;
        }
        if ((i & 32) == 0) {
            if ((3670016 & $changed) == 0) {
                i2 = $composer3.changedInstance(onClick) ? 1048576 : 524288;
            }
            $dirty = $dirty2;
            if ((2995931 & $dirty) == 599186 || !$composer3.getSkipping()) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    position2 = SegmentedButtonValues.MIDDLE.INSTANCE;
                }
                if (i5 != 0) {
                    enabled2 = true;
                } else {
                    enabled2 = z;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-57875230, $dirty, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceSegmentedButton (SegementedButton.kt:24)");
                }
                Modifier modifierM651height3ABfNKs = SizeKt.m651height3ABfNKs(modifier3, Dp.m6553constructorimpl(36));
                SegmentedButtonColors segmentedButtonColorsM2323colorsXqyqHi0 = SegmentedButtonDefaults.INSTANCE.m2323colorsXqyqHi0(0L, 0L, 0L, Color.INSTANCE.m4078getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 3072, 384, 4087);
                if (Intrinsics.areEqual(position2, SegmentedButtonValues.END.INSTANCE)) {
                    rectangleShape = EndSegmentedButtonShape;
                } else if (Intrinsics.areEqual(position2, SegmentedButtonValues.MIDDLE.INSTANCE)) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    if (!Intrinsics.areEqual(position2, SegmentedButtonValues.START.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    rectangleShape = StartSegmentedButtonShape;
                }
                position3 = position2;
                modifier4 = modifier3;
                $composer2 = $composer3;
                SegmentedButtonKt.SegmentedButton($this$SingleChoiceSegmentedButton, selected, onClick, rectangleShape, modifierM651height3ABfNKs, enabled2, segmentedButtonColorsM2323colorsXqyqHi0, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.rememberComposableLambda(-1236729454, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SegementedButtonKt.SingleChoiceSegmentedButton.1
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
                        ComposerKt.sourceInformation($composer4, "C36@1448L17:SegementedButton.kt#g7nzpb");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1236729454, $changed2, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceSegmentedButton.<anonymous> (SegementedButton.kt:36)");
                        }
                        TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), $composer3, ($dirty & 14) | (($dirty >> 6) & 112) | (($dirty >> 12) & 896) | (458752 & $dirty), 6, 448);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier4 = modifier2;
                position3 = position2;
                enabled2 = z;
                $composer2 = $composer3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier4;
                final SegmentedButtonValues segmentedButtonValues = position3;
                final boolean z2 = enabled2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SegementedButtonKt.SingleChoiceSegmentedButton.2
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
                        SegementedButtonKt.SingleChoiceSegmentedButton($this$SingleChoiceSegmentedButton, modifier5, text, selected, segmentedButtonValues, z2, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 1572864;
        $dirty2 |= i2;
        $dirty = $dirty2;
        if ((2995931 & $dirty) == 599186) {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                position2 = SegmentedButtonValues.MIDDLE.INSTANCE;
            }
            if (i5 != 0) {
                enabled2 = true;
            } else {
                enabled2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-57875230, $dirty, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceSegmentedButton (SegementedButton.kt:24)");
            }
            Modifier modifierM651height3ABfNKs2 = SizeKt.m651height3ABfNKs(modifier3, Dp.m6553constructorimpl(36));
            SegmentedButtonColors segmentedButtonColorsM2323colorsXqyqHi1 = SegmentedButtonDefaults.INSTANCE.m2323colorsXqyqHi0(0L, 0L, 0L, Color.INSTANCE.m4078getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 3072, 384, 4087);
            if (Intrinsics.areEqual(position2, SegmentedButtonValues.END.INSTANCE)) {
                rectangleShape = EndSegmentedButtonShape;
            } else if (Intrinsics.areEqual(position2, SegmentedButtonValues.MIDDLE.INSTANCE)) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                if (!Intrinsics.areEqual(position2, SegmentedButtonValues.START.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                rectangleShape = StartSegmentedButtonShape;
            }
            position3 = position2;
            modifier4 = modifier3;
            $composer2 = $composer3;
            SegmentedButtonKt.SegmentedButton($this$SingleChoiceSegmentedButton, selected, onClick, rectangleShape, modifierM651height3ABfNKs2, enabled2, segmentedButtonColorsM2323colorsXqyqHi1, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.rememberComposableLambda(-1236729454, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SegementedButtonKt.SingleChoiceSegmentedButton.1
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
                    ComposerKt.sourceInformation($composer4, "C36@1448L17:SegementedButton.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1236729454, $changed2, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceSegmentedButton.<anonymous> (SegementedButton.kt:36)");
                    }
                    TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, ($dirty & 14) | (($dirty >> 6) & 112) | (($dirty >> 12) & 896) | (458752 & $dirty), 6, 448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                position2 = SegmentedButtonValues.MIDDLE.INSTANCE;
            }
            if (i5 != 0) {
                enabled2 = true;
            } else {
                enabled2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-57875230, $dirty, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceSegmentedButton (SegementedButton.kt:24)");
            }
            Modifier modifierM651height3ABfNKs3 = SizeKt.m651height3ABfNKs(modifier3, Dp.m6553constructorimpl(36));
            SegmentedButtonColors segmentedButtonColorsM2323colorsXqyqHi2 = SegmentedButtonDefaults.INSTANCE.m2323colorsXqyqHi0(0L, 0L, 0L, Color.INSTANCE.m4078getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 3072, 384, 4087);
            if (Intrinsics.areEqual(position2, SegmentedButtonValues.END.INSTANCE)) {
                rectangleShape = EndSegmentedButtonShape;
            } else if (Intrinsics.areEqual(position2, SegmentedButtonValues.MIDDLE.INSTANCE)) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                if (!Intrinsics.areEqual(position2, SegmentedButtonValues.START.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                rectangleShape = StartSegmentedButtonShape;
            }
            position3 = position2;
            modifier4 = modifier3;
            $composer2 = $composer3;
            SegmentedButtonKt.SegmentedButton($this$SingleChoiceSegmentedButton, selected, onClick, rectangleShape, modifierM651height3ABfNKs3, enabled2, segmentedButtonColorsM2323colorsXqyqHi2, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.rememberComposableLambda(-1236729454, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SegementedButtonKt.SingleChoiceSegmentedButton.1
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
                    ComposerKt.sourceInformation($composer4, "C36@1448L17:SegementedButton.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1236729454, $changed2, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceSegmentedButton.<anonymous> (SegementedButton.kt:36)");
                    }
                    TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, ($dirty & 14) | (($dirty >> 6) & 112) | (($dirty >> 12) & 896) | (458752 & $dirty), 6, 448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final SegmentedButtonValues segmentedButtonValues2 = position3;
            final boolean z3 = enabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SegementedButtonKt.SingleChoiceSegmentedButton.2
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
                    SegementedButtonKt.SingleChoiceSegmentedButton($this$SingleChoiceSegmentedButton, modifier6, text, selected, segmentedButtonValues2, z3, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
