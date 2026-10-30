package com.google.accompanist.flowlayout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001am\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001as\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001as\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018*\u001a\b\u0007\u0010\u001b\"\u00020\t2\u00020\tB\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m195d2 = {"Flow", "", "modifier", "Landroidx/compose/ui/Modifier;", "orientation", "Lcom/google/accompanist/flowlayout/LayoutOrientation;", "mainAxisSize", "Lcom/google/accompanist/flowlayout/SizeMode;", "mainAxisAlignment", "Lcom/google/accompanist/flowlayout/MainAxisAlignment;", "Lcom/google/accompanist/flowlayout/FlowMainAxisAlignment;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Lcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;", "crossAxisSpacing", "lastLineMainAxisAlignment", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Flow-F4y8cZ0", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/LayoutOrientation;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FlowColumn", "FlowColumn-07r0xoM", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "FlowRow-07r0xoM", "FlowMainAxisAlignment", "Lkotlin/Deprecated;", "message", "\naccompanist/FlowMainAxisAlignment is deprecated.\nFor more migration information, please visit https://google.github.io/accompanist/flowlayout/\n", "flowlayout_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FlowKt {
    @Deprecated(message = "\naccompanist/FlowMainAxisAlignment is deprecated.\nFor more migration information, please visit https://google.github.io/accompanist/flowlayout/\n")
    public static /* synthetic */ void FlowMainAxisAlignment$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:104:0x016a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x016c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0171  */
    /* JADX WARN: Code duplicated, block: B:108:0x0175  */
    /* JADX WARN: Code duplicated, block: B:110:0x017a  */
    /* JADX WARN: Code duplicated, block: B:112:0x017f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0189  */
    /* JADX WARN: Code duplicated, block: B:116:0x018e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0196  */
    /* JADX WARN: Code duplicated, block: B:120:0x019c  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:124:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:127:0x021e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0227  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x012e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0138  */
    @Deprecated(message = "\naccompanist/FlowRow is deprecated.\nFor more migration information, please visit https://google.github.io/accompanist/flowlayout/\n", replaceWith = @ReplaceWith(expression = "FlowRow", imports = {"androidx.compose.foundation.layout.FlowRow", "androidx.compose.ui.Modifier"}))
    /* JADX INFO: renamed from: FlowRow-07r0xoM, reason: not valid java name */
    public static final void m7167FlowRow07r0xoM(Modifier modifier, SizeMode mainAxisSize, MainAxisAlignment mainAxisAlignment, float mainAxisSpacing, FlowCrossAxisAlignment crossAxisAlignment, float crossAxisSpacing, MainAxisAlignment lastLineMainAxisAlignment, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        SizeMode mainAxisSize2;
        MainAxisAlignment mainAxisAlignment2;
        float mainAxisSpacing2;
        FlowCrossAxisAlignment crossAxisAlignment2;
        int i2;
        Modifier.Companion modifier2;
        float crossAxisSpacing2;
        MainAxisAlignment lastLineMainAxisAlignment2;
        int $dirty;
        float crossAxisSpacing3;
        SizeMode mainAxisSize3;
        MainAxisAlignment mainAxisAlignment3;
        float mainAxisSpacing3;
        FlowCrossAxisAlignment crossAxisAlignment3;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-137566119);
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            mainAxisSize2 = mainAxisSize;
        } else if (($changed & 112) == 0) {
            mainAxisSize2 = mainAxisSize;
            $dirty2 |= $composer2.changed(mainAxisSize2) ? 32 : 16;
        } else {
            mainAxisSize2 = mainAxisSize;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            mainAxisAlignment2 = mainAxisAlignment;
        } else if (($changed & 896) == 0) {
            mainAxisAlignment2 = mainAxisAlignment;
            $dirty2 |= $composer2.changed(mainAxisAlignment2) ? 256 : 128;
        } else {
            mainAxisAlignment2 = mainAxisAlignment;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            mainAxisSpacing2 = mainAxisSpacing;
        } else if (($changed & 7168) == 0) {
            mainAxisSpacing2 = mainAxisSpacing;
            $dirty2 |= $composer2.changed(mainAxisSpacing2) ? 2048 : 1024;
        } else {
            mainAxisSpacing2 = mainAxisSpacing;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            crossAxisAlignment2 = crossAxisAlignment;
        } else if (($changed & 57344) == 0) {
            crossAxisAlignment2 = crossAxisAlignment;
            $dirty2 |= $composer2.changed(crossAxisAlignment2) ? 16384 : 8192;
        } else {
            crossAxisAlignment2 = crossAxisAlignment;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(crossAxisSpacing) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(lastLineMainAxisAlignment)) ? 1048576 : 524288;
        }
        if ((i & 128) == 0) {
            if (($changed & 29360128) == 0) {
                i2 = $composer2.changedInstance(content) ? 8388608 : 4194304;
            }
            if ((23967451 & $dirty2) == 4793490 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    if (i3 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        mainAxisSize2 = SizeMode.Wrap;
                    }
                    if (i5 != 0) {
                        mainAxisAlignment2 = MainAxisAlignment.Start;
                    }
                    if (i6 != 0) {
                        mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                    }
                    if (i7 != 0) {
                        crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                    }
                    if (i8 != 0) {
                        crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                    } else {
                        crossAxisSpacing2 = crossAxisSpacing;
                    }
                    if ((i & 64) != 0) {
                        $dirty = $dirty2 & (-3670017);
                        crossAxisSpacing3 = crossAxisSpacing2;
                        lastLineMainAxisAlignment2 = mainAxisAlignment2;
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier2;
                    } else {
                        lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                        $dirty = $dirty2;
                        crossAxisSpacing3 = crossAxisSpacing2;
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 64) != 0) {
                        crossAxisSpacing3 = crossAxisSpacing;
                        lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                        $dirty = $dirty2 & (-3670017);
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier;
                    } else {
                        crossAxisSpacing3 = crossAxisSpacing;
                        lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                        $dirty = $dirty2;
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-137566119, $dirty, -1, "com.google.accompanist.flowlayout.FlowRow (Flow.kt:68)");
                }
                m7165FlowF4y8cZ0(modifier3, LayoutOrientation.Horizontal, mainAxisSize3, mainAxisAlignment3, mainAxisSpacing3, crossAxisAlignment3, crossAxisSpacing3, lastLineMainAxisAlignment2, content, $composer2, ($dirty & 14) | 48 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (234881024 & ($dirty << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                crossAxisSpacing3 = crossAxisSpacing;
                lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                mainAxisSize3 = mainAxisSize2;
                mainAxisAlignment3 = mainAxisAlignment2;
                mainAxisSpacing3 = mainAxisSpacing2;
                crossAxisAlignment3 = crossAxisAlignment2;
                modifier3 = modifier;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                final SizeMode sizeMode = mainAxisSize3;
                final MainAxisAlignment mainAxisAlignment4 = mainAxisAlignment3;
                final float f = mainAxisSpacing3;
                final FlowCrossAxisAlignment flowCrossAxisAlignment = crossAxisAlignment3;
                final float f2 = crossAxisSpacing3;
                final MainAxisAlignment mainAxisAlignment5 = lastLineMainAxisAlignment2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.flowlayout.FlowKt$FlowRow$1
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
                        FlowKt.m7167FlowRow07r0xoM(modifier4, sizeMode, mainAxisAlignment4, f, flowCrossAxisAlignment, f2, mainAxisAlignment5, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 12582912;
        $dirty2 |= i2;
        if ((23967451 & $dirty2) == 4793490) {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            } else {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-137566119, $dirty, -1, "com.google.accompanist.flowlayout.FlowRow (Flow.kt:68)");
            }
            m7165FlowF4y8cZ0(modifier3, LayoutOrientation.Horizontal, mainAxisSize3, mainAxisAlignment3, mainAxisSpacing3, crossAxisAlignment3, crossAxisSpacing3, lastLineMainAxisAlignment2, content, $composer2, ($dirty & 14) | 48 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (234881024 & ($dirty << 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            } else {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-137566119, $dirty, -1, "com.google.accompanist.flowlayout.FlowRow (Flow.kt:68)");
            }
            m7165FlowF4y8cZ0(modifier3, LayoutOrientation.Horizontal, mainAxisSize3, mainAxisAlignment3, mainAxisSpacing3, crossAxisAlignment3, crossAxisSpacing3, lastLineMainAxisAlignment2, content, $composer2, ($dirty & 14) | 48 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (234881024 & ($dirty << 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final SizeMode sizeMode2 = mainAxisSize3;
            final MainAxisAlignment mainAxisAlignment6 = mainAxisAlignment3;
            final float f3 = mainAxisSpacing3;
            final FlowCrossAxisAlignment flowCrossAxisAlignment2 = crossAxisAlignment3;
            final float f4 = crossAxisSpacing3;
            final MainAxisAlignment mainAxisAlignment7 = lastLineMainAxisAlignment2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.flowlayout.FlowKt$FlowRow$1
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
                    FlowKt.m7167FlowRow07r0xoM(modifier5, sizeMode2, mainAxisAlignment6, f3, flowCrossAxisAlignment2, f4, mainAxisAlignment7, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x016a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x016c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0171  */
    /* JADX WARN: Code duplicated, block: B:108:0x0175  */
    /* JADX WARN: Code duplicated, block: B:110:0x017a  */
    /* JADX WARN: Code duplicated, block: B:112:0x017f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0189  */
    /* JADX WARN: Code duplicated, block: B:116:0x018e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0196  */
    /* JADX WARN: Code duplicated, block: B:120:0x019c  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:124:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:127:0x021e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0227  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x012e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0138  */
    @Deprecated(message = "\naccompanist/FlowColumn is deprecated.\nFor more migration information, please visit https://google.github.io/accompanist/flowlayout/\n", replaceWith = @ReplaceWith(expression = "FlowColumn", imports = {"androidx.compose.foundation.layout.FlowColumn", "androidx.compose.ui.Modifier"}))
    /* JADX INFO: renamed from: FlowColumn-07r0xoM, reason: not valid java name */
    public static final void m7166FlowColumn07r0xoM(Modifier modifier, SizeMode mainAxisSize, MainAxisAlignment mainAxisAlignment, float mainAxisSpacing, FlowCrossAxisAlignment crossAxisAlignment, float crossAxisSpacing, MainAxisAlignment lastLineMainAxisAlignment, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        SizeMode mainAxisSize2;
        MainAxisAlignment mainAxisAlignment2;
        float mainAxisSpacing2;
        FlowCrossAxisAlignment crossAxisAlignment2;
        int i2;
        Modifier.Companion modifier2;
        float crossAxisSpacing2;
        MainAxisAlignment lastLineMainAxisAlignment2;
        int $dirty;
        float crossAxisSpacing3;
        SizeMode mainAxisSize3;
        MainAxisAlignment mainAxisAlignment3;
        float mainAxisSpacing3;
        FlowCrossAxisAlignment crossAxisAlignment3;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(203669733);
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            mainAxisSize2 = mainAxisSize;
        } else if (($changed & 112) == 0) {
            mainAxisSize2 = mainAxisSize;
            $dirty2 |= $composer2.changed(mainAxisSize2) ? 32 : 16;
        } else {
            mainAxisSize2 = mainAxisSize;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            mainAxisAlignment2 = mainAxisAlignment;
        } else if (($changed & 896) == 0) {
            mainAxisAlignment2 = mainAxisAlignment;
            $dirty2 |= $composer2.changed(mainAxisAlignment2) ? 256 : 128;
        } else {
            mainAxisAlignment2 = mainAxisAlignment;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            mainAxisSpacing2 = mainAxisSpacing;
        } else if (($changed & 7168) == 0) {
            mainAxisSpacing2 = mainAxisSpacing;
            $dirty2 |= $composer2.changed(mainAxisSpacing2) ? 2048 : 1024;
        } else {
            mainAxisSpacing2 = mainAxisSpacing;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            crossAxisAlignment2 = crossAxisAlignment;
        } else if (($changed & 57344) == 0) {
            crossAxisAlignment2 = crossAxisAlignment;
            $dirty2 |= $composer2.changed(crossAxisAlignment2) ? 16384 : 8192;
        } else {
            crossAxisAlignment2 = crossAxisAlignment;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(crossAxisSpacing) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(lastLineMainAxisAlignment)) ? 1048576 : 524288;
        }
        if ((i & 128) == 0) {
            if (($changed & 29360128) == 0) {
                i2 = $composer2.changedInstance(content) ? 8388608 : 4194304;
            }
            if ((23967451 & $dirty2) == 4793490 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    if (i3 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        mainAxisSize2 = SizeMode.Wrap;
                    }
                    if (i5 != 0) {
                        mainAxisAlignment2 = MainAxisAlignment.Start;
                    }
                    if (i6 != 0) {
                        mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                    }
                    if (i7 != 0) {
                        crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                    }
                    if (i8 != 0) {
                        crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                    } else {
                        crossAxisSpacing2 = crossAxisSpacing;
                    }
                    if ((i & 64) != 0) {
                        $dirty = $dirty2 & (-3670017);
                        crossAxisSpacing3 = crossAxisSpacing2;
                        lastLineMainAxisAlignment2 = mainAxisAlignment2;
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier2;
                    } else {
                        lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                        $dirty = $dirty2;
                        crossAxisSpacing3 = crossAxisSpacing2;
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier2;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 64) != 0) {
                        crossAxisSpacing3 = crossAxisSpacing;
                        lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                        $dirty = $dirty2 & (-3670017);
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier;
                    } else {
                        crossAxisSpacing3 = crossAxisSpacing;
                        lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                        $dirty = $dirty2;
                        mainAxisSize3 = mainAxisSize2;
                        mainAxisAlignment3 = mainAxisAlignment2;
                        mainAxisSpacing3 = mainAxisSpacing2;
                        crossAxisAlignment3 = crossAxisAlignment2;
                        modifier3 = modifier;
                    }
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(203669733, $dirty, -1, "com.google.accompanist.flowlayout.FlowColumn (Flow.kt:117)");
                }
                m7165FlowF4y8cZ0(modifier3, LayoutOrientation.Vertical, mainAxisSize3, mainAxisAlignment3, mainAxisSpacing3, crossAxisAlignment3, crossAxisSpacing3, lastLineMainAxisAlignment2, content, $composer2, ($dirty & 14) | 48 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (234881024 & ($dirty << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                crossAxisSpacing3 = crossAxisSpacing;
                lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                mainAxisSize3 = mainAxisSize2;
                mainAxisAlignment3 = mainAxisAlignment2;
                mainAxisSpacing3 = mainAxisSpacing2;
                crossAxisAlignment3 = crossAxisAlignment2;
                modifier3 = modifier;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                final SizeMode sizeMode = mainAxisSize3;
                final MainAxisAlignment mainAxisAlignment4 = mainAxisAlignment3;
                final float f = mainAxisSpacing3;
                final FlowCrossAxisAlignment flowCrossAxisAlignment = crossAxisAlignment3;
                final float f2 = crossAxisSpacing3;
                final MainAxisAlignment mainAxisAlignment5 = lastLineMainAxisAlignment2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.flowlayout.FlowKt$FlowColumn$1
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
                        FlowKt.m7166FlowColumn07r0xoM(modifier4, sizeMode, mainAxisAlignment4, f, flowCrossAxisAlignment, f2, mainAxisAlignment5, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 12582912;
        $dirty2 |= i2;
        if ((23967451 & $dirty2) == 4793490) {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            } else {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(203669733, $dirty, -1, "com.google.accompanist.flowlayout.FlowColumn (Flow.kt:117)");
            }
            m7165FlowF4y8cZ0(modifier3, LayoutOrientation.Vertical, mainAxisSize3, mainAxisAlignment3, mainAxisSpacing3, crossAxisAlignment3, crossAxisSpacing3, lastLineMainAxisAlignment2, content, $composer2, ($dirty & 14) | 48 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (234881024 & ($dirty << 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            } else {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    mainAxisSize2 = SizeMode.Wrap;
                }
                if (i5 != 0) {
                    mainAxisAlignment2 = MainAxisAlignment.Start;
                }
                if (i6 != 0) {
                    mainAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i7 != 0) {
                    crossAxisAlignment2 = FlowCrossAxisAlignment.Start;
                }
                if (i8 != 0) {
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                } else {
                    crossAxisSpacing2 = crossAxisSpacing;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    crossAxisSpacing3 = crossAxisSpacing2;
                    lastLineMainAxisAlignment2 = mainAxisAlignment2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                } else {
                    lastLineMainAxisAlignment2 = lastLineMainAxisAlignment;
                    $dirty = $dirty2;
                    crossAxisSpacing3 = crossAxisSpacing2;
                    mainAxisSize3 = mainAxisSize2;
                    mainAxisAlignment3 = mainAxisAlignment2;
                    mainAxisSpacing3 = mainAxisSpacing2;
                    crossAxisAlignment3 = crossAxisAlignment2;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(203669733, $dirty, -1, "com.google.accompanist.flowlayout.FlowColumn (Flow.kt:117)");
            }
            m7165FlowF4y8cZ0(modifier3, LayoutOrientation.Vertical, mainAxisSize3, mainAxisAlignment3, mainAxisSpacing3, crossAxisAlignment3, crossAxisSpacing3, lastLineMainAxisAlignment2, content, $composer2, ($dirty & 14) | 48 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (234881024 & ($dirty << 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final SizeMode sizeMode2 = mainAxisSize3;
            final MainAxisAlignment mainAxisAlignment6 = mainAxisAlignment3;
            final float f3 = mainAxisSpacing3;
            final FlowCrossAxisAlignment flowCrossAxisAlignment2 = crossAxisAlignment3;
            final float f4 = crossAxisSpacing3;
            final MainAxisAlignment mainAxisAlignment7 = lastLineMainAxisAlignment2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.flowlayout.FlowKt$FlowColumn$1
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
                    FlowKt.m7166FlowColumn07r0xoM(modifier5, sizeMode2, mainAxisAlignment6, f3, flowCrossAxisAlignment2, f4, mainAxisAlignment7, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated(message = "\naccompanist/Flow is deprecated.\nFor more migration information, please visit https://google.github.io/accompanist/flowlayout/\n")
    /* JADX INFO: renamed from: Flow-F4y8cZ0, reason: not valid java name */
    public static final void m7165FlowF4y8cZ0(final Modifier modifier, final LayoutOrientation orientation, final SizeMode mainAxisSize, final MainAxisAlignment mainAxisAlignment, final float mainAxisSpacing, final FlowCrossAxisAlignment crossAxisAlignment, final float crossAxisSpacing, final MainAxisAlignment lastLineMainAxisAlignment, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object value$iv;
        int $dirty;
        Function0<ComposeUiNode> function0;
        Composer $composer2 = $composer.startRestartGroup(-1567419051);
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(orientation) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(mainAxisSize) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(mainAxisAlignment) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            $dirty2 |= $composer2.changed(mainAxisSpacing) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changed(crossAxisAlignment) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            $dirty2 |= $composer2.changed(crossAxisSpacing) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty2 |= $composer2.changed(lastLineMainAxisAlignment) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1567419051, $dirty2, -1, "com.google.accompanist.flowlayout.Flow (Flow.kt:183)");
            }
            $composer2.startReplaceableGroup(1107217839);
            boolean invalid$iv = (($dirty2 & 112) == 32) | ((57344 & $dirty2) == 16384) | (($dirty2 & 3670016) == 1048576) | (($dirty2 & 896) == 256) | (($dirty2 & 7168) == 2048) | (($dirty2 & 29360128) == 8388608) | ((458752 & $dirty2) == 131072);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: com.google.accompanist.flowlayout.FlowKt$Flow$1$1
                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(final MeasureScope $this$Layout, List<? extends Measurable> measurables, long outerConstraints) {
                        long jConstraints$default;
                        Ref.IntRef mainAxisSpace;
                        final int mainAxisLayoutSize;
                        int layoutWidth;
                        int layoutHeight;
                        Ref.IntRef currentCrossAxisSize;
                        Ref.IntRef currentMainAxisSize;
                        Ref.IntRef mainAxisSpace2;
                        MeasureScope Layout = $this$Layout;
                        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        final List sequences = new ArrayList();
                        final List crossAxisSizes = new ArrayList();
                        final List crossAxisPositions = new ArrayList();
                        Ref.IntRef mainAxisSpace3 = new Ref.IntRef();
                        Ref.IntRef crossAxisSpace = new Ref.IntRef();
                        List currentSequence = new ArrayList();
                        Ref.IntRef currentMainAxisSize2 = new Ref.IntRef();
                        Ref.IntRef currentCrossAxisSize2 = new Ref.IntRef();
                        OrientationIndependentConstraints constraints = new OrientationIndependentConstraints(outerConstraints, orientation, null);
                        if (orientation == LayoutOrientation.Horizontal) {
                            jConstraints$default = ConstraintsKt.Constraints$default(0, constraints.getMainAxisMax(), 0, 0, 13, null);
                        } else {
                            jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, constraints.getMainAxisMax(), 7, null);
                        }
                        long childConstraints = jConstraints$default;
                        for (Measurable measurable : measurables) {
                            Placeable placeable = measurable.mo5644measureBRTryo0(childConstraints);
                            long childConstraints2 = childConstraints;
                            if (measure_3p2s80s$canAddToCurrentSequence(currentSequence, currentMainAxisSize2, $this$Layout, mainAxisSpacing, constraints, orientation, placeable)) {
                                currentCrossAxisSize = currentCrossAxisSize2;
                                currentMainAxisSize = currentMainAxisSize2;
                                mainAxisSpace2 = mainAxisSpace3;
                            } else {
                                currentCrossAxisSize = currentCrossAxisSize2;
                                currentMainAxisSize = currentMainAxisSize2;
                                mainAxisSpace2 = mainAxisSpace3;
                                measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, crossAxisSpacing, currentSequence, crossAxisSizes, currentCrossAxisSize, crossAxisPositions, mainAxisSpace2, currentMainAxisSize);
                            }
                            if (!currentSequence.isEmpty()) {
                                currentMainAxisSize.element += Layout.mo561roundToPx0680j_4(mainAxisSpacing);
                            }
                            currentSequence.add(placeable);
                            currentMainAxisSize.element += FlowKt.Flow_F4y8cZ0$mainAxisSize(placeable, orientation);
                            currentCrossAxisSize.element = Math.max(currentCrossAxisSize.element, FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable, orientation));
                            currentMainAxisSize2 = currentMainAxisSize;
                            currentCrossAxisSize2 = currentCrossAxisSize;
                            currentSequence = currentSequence;
                            crossAxisSpace = crossAxisSpace;
                            Layout = Layout;
                            childConstraints = childConstraints2;
                            mainAxisSpace3 = mainAxisSpace2;
                            constraints = constraints;
                        }
                        OrientationIndependentConstraints constraints2 = constraints;
                        Ref.IntRef currentCrossAxisSize3 = currentCrossAxisSize2;
                        Ref.IntRef currentMainAxisSize3 = currentMainAxisSize2;
                        List currentSequence2 = currentSequence;
                        Ref.IntRef crossAxisSpace2 = crossAxisSpace;
                        Ref.IntRef mainAxisSpace4 = mainAxisSpace3;
                        if (!currentSequence2.isEmpty()) {
                            measure_3p2s80s$startNewSequence(sequences, crossAxisSpace2, $this$Layout, crossAxisSpacing, currentSequence2, crossAxisSizes, currentCrossAxisSize3, crossAxisPositions, mainAxisSpace4, currentMainAxisSize3);
                        }
                        if (constraints2.getMainAxisMax() != Integer.MAX_VALUE && mainAxisSize == SizeMode.Expand) {
                            mainAxisLayoutSize = constraints2.getMainAxisMax();
                            mainAxisSpace = mainAxisSpace4;
                        } else {
                            mainAxisSpace = mainAxisSpace4;
                            mainAxisLayoutSize = Math.max(mainAxisSpace.element, constraints2.getMainAxisMin());
                        }
                        int crossAxisLayoutSize = Math.max(crossAxisSpace2.element, constraints2.getCrossAxisMin());
                        if (orientation == LayoutOrientation.Horizontal) {
                            layoutWidth = mainAxisLayoutSize;
                        } else {
                            layoutWidth = crossAxisLayoutSize;
                        }
                        if (orientation == LayoutOrientation.Horizontal) {
                            layoutHeight = crossAxisLayoutSize;
                        } else {
                            layoutHeight = mainAxisLayoutSize;
                        }
                        final float f = mainAxisSpacing;
                        final MainAxisAlignment mainAxisAlignment2 = mainAxisAlignment;
                        final MainAxisAlignment mainAxisAlignment3 = lastLineMainAxisAlignment;
                        final LayoutOrientation layoutOrientation = orientation;
                        final FlowCrossAxisAlignment flowCrossAxisAlignment = crossAxisAlignment;
                        return MeasureScope.CC.layout$default($this$Layout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.google.accompanist.flowlayout.FlowKt$Flow$1$1.1

                            /* JADX INFO: renamed from: com.google.accompanist.flowlayout.FlowKt$Flow$1$1$1$WhenMappings */
                            /* JADX INFO: compiled from: Flow.kt */
                            @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[FlowCrossAxisAlignment.values().length];
                                    try {
                                        iArr[FlowCrossAxisAlignment.Start.ordinal()] = 1;
                                    } catch (NoSuchFieldError e) {
                                    }
                                    try {
                                        iArr[FlowCrossAxisAlignment.End.ordinal()] = 2;
                                    } catch (NoSuchFieldError e2) {
                                    }
                                    try {
                                        iArr[FlowCrossAxisAlignment.Center.ordinal()] = 3;
                                    } catch (NoSuchFieldError e3) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope layout) {
                                Arrangement.Vertical arrangement;
                                int crossAxis;
                                int i;
                                List<Integer> list;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Iterable $this$forEachIndexed$iv = sequences;
                                MeasureScope measureScope = $this$Layout;
                                float f2 = f;
                                List<List<Placeable>> list2 = sequences;
                                MainAxisAlignment mainAxisAlignment4 = mainAxisAlignment2;
                                MainAxisAlignment mainAxisAlignment5 = mainAxisAlignment3;
                                LayoutOrientation layoutOrientation2 = layoutOrientation;
                                int i2 = mainAxisLayoutSize;
                                FlowCrossAxisAlignment flowCrossAxisAlignment2 = flowCrossAxisAlignment;
                                List<Integer> list3 = crossAxisSizes;
                                List<Integer> list4 = crossAxisPositions;
                                int index$iv = 0;
                                for (Object item$iv : $this$forEachIndexed$iv) {
                                    int index$iv2 = index$iv + 1;
                                    if (index$iv < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    List placeables = (List) item$iv;
                                    int i3 = index$iv;
                                    int size = placeables.size();
                                    int[] childrenMainAxisSizes = new int[size];
                                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                    int i4 = 0;
                                    while (i4 < size) {
                                        int i5 = size;
                                        childrenMainAxisSizes[i4] = FlowKt.Flow_F4y8cZ0$mainAxisSize((Placeable) placeables.get(i4), layoutOrientation2) + (i4 < CollectionsKt.getLastIndex(placeables) ? measureScope.mo561roundToPx0680j_4(f2) : 0);
                                        i4++;
                                        size = i5;
                                    }
                                    if (i3 < CollectionsKt.getLastIndex(list2)) {
                                        arrangement = mainAxisAlignment4.getArrangement();
                                    } else {
                                        arrangement = mainAxisAlignment5.getArrangement();
                                    }
                                    int length = childrenMainAxisSizes.length;
                                    int[] mainAxisPositions = new int[length];
                                    float f3 = f2;
                                    for (int i6 = 0; i6 < length; i6++) {
                                        mainAxisPositions[i6] = 0;
                                    }
                                    Arrangement.Vertical $this$invoke_u24lambda_u242_u24lambda_u240 = arrangement;
                                    $this$invoke_u24lambda_u242_u24lambda_u240.arrange(measureScope, i2, childrenMainAxisSizes, mainAxisPositions);
                                    int index$iv3 = 0;
                                    for (Object item$iv2 : placeables) {
                                        int index$iv4 = index$iv3 + 1;
                                        if (index$iv3 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        int i7 = i2;
                                        Placeable placeable2 = (Placeable) item$iv2;
                                        int j = index$iv3;
                                        switch (WhenMappings.$EnumSwitchMapping$0[flowCrossAxisAlignment2.ordinal()]) {
                                            case 1:
                                                crossAxis = 0;
                                                break;
                                            case 2:
                                                crossAxis = list3.get(i3).intValue() - FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable2, layoutOrientation2);
                                                break;
                                            case 3:
                                                crossAxis = IntOffset.m6934getYimpl(Alignment.INSTANCE.getCenter().mo3908alignKFBX0sM(IntSize.INSTANCE.m6980getZeroYbymL2g(), IntSizeKt.IntSize(0, list3.get(i3).intValue() - FlowKt.Flow_F4y8cZ0$crossAxisSize(placeable2, layoutOrientation2)), LayoutDirection.Ltr));
                                                break;
                                            default:
                                                throw new NoWhenBranchMatchedException();
                                        }
                                        if (layoutOrientation2 == LayoutOrientation.Horizontal) {
                                            i = i3;
                                            Placeable.PlacementScope.place$default(layout, placeable2, mainAxisPositions[j], list4.get(i3).intValue() + crossAxis, 0.0f, 4, null);
                                            list = list4;
                                        } else {
                                            i = i3;
                                            List<Integer> list5 = list4;
                                            list = list5;
                                            Placeable.PlacementScope.place$default(layout, placeable2, list5.get(i).intValue() + crossAxis, mainAxisPositions[j], 0.0f, 4, null);
                                        }
                                        index$iv3 = index$iv4;
                                        i2 = i7;
                                        list3 = list3;
                                        flowCrossAxisAlignment2 = flowCrossAxisAlignment2;
                                        list4 = list;
                                        placeables = placeables;
                                        i3 = i;
                                    }
                                    index$iv = index$iv2;
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    f2 = f3;
                                }
                            }
                        }, 4, null);
                    }

                    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef currentMainAxisSize, MeasureScope $this_Layout, float $mainAxisSpacing, OrientationIndependentConstraints constraints, LayoutOrientation $orientation, Placeable placeable) {
                        return list.isEmpty() || (currentMainAxisSize.element + $this_Layout.mo561roundToPx0680j_4($mainAxisSpacing)) + FlowKt.Flow_F4y8cZ0$mainAxisSize(placeable, $orientation) <= constraints.getMainAxisMax();
                    }

                    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef crossAxisSpace, MeasureScope $this_Layout, float $crossAxisSpacing, List<Placeable> list2, List<Integer> list3, Ref.IntRef currentCrossAxisSize, List<Integer> list4, Ref.IntRef mainAxisSpace, Ref.IntRef currentMainAxisSize) {
                        if (!list.isEmpty()) {
                            crossAxisSpace.element += $this_Layout.mo561roundToPx0680j_4($crossAxisSpacing);
                        }
                        list.add(CollectionsKt.toList(list2));
                        list3.add(Integer.valueOf(currentCrossAxisSize.element));
                        list4.add(Integer.valueOf(crossAxisSpace.element));
                        crossAxisSpace.element += currentCrossAxisSize.element;
                        mainAxisSpace.element = Math.max(mainAxisSpace.element, currentMainAxisSize.element);
                        list2.clear();
                        currentMainAxisSize.element = 0;
                        currentCrossAxisSize.element = 0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            $composer2.endReplaceableGroup();
            int $changed$iv = (($dirty2 >> 24) & 14) | (($dirty2 << 3) & 112);
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            $dirty = $dirty2;
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            $dirty = $dirty2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.flowlayout.FlowKt$Flow$2
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

                public final void invoke(Composer composer, int i) {
                    FlowKt.m7165FlowF4y8cZ0(modifier, orientation, mainAxisSize, mainAxisAlignment, mainAxisSpacing, crossAxisAlignment, crossAxisSpacing, lastLineMainAxisAlignment, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$mainAxisSize(Placeable $this$Flow_F4y8cZ0_u24mainAxisSize, LayoutOrientation $orientation) {
        return $orientation == LayoutOrientation.Horizontal ? $this$Flow_F4y8cZ0_u24mainAxisSize.getWidth() : $this$Flow_F4y8cZ0_u24mainAxisSize.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$crossAxisSize(Placeable $this$Flow_F4y8cZ0_u24crossAxisSize, LayoutOrientation $orientation) {
        return $orientation == LayoutOrientation.Horizontal ? $this$Flow_F4y8cZ0_u24crossAxisSize.getHeight() : $this$Flow_F4y8cZ0_u24crossAxisSize.getWidth();
    }
}
