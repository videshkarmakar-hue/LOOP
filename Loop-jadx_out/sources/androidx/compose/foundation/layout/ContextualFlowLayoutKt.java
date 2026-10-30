package androidx.compose.foundation.layout;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.SubcomposeLayoutKt;
import androidx.compose.p001ui.layout.SubcomposeMeasureScope;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ContextualFlowLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r21\u0010\u000e\u001a-\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0084\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u001921\u0010\u000e\u001a-\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u001b\u001a¥\u0001\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0002\b\u00140$2;\u0010&\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010)\u001a¥\u0001\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0002\b\u00140$2;\u0010&\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010+¨\u0006,"}, m195d2 = {"ContextualFlowColumn", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualColumnMeasureHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualRowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ContextualFlowLayoutKt {
    public static final void ContextualFlowRow(final int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, final Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        Arrangement.Horizontal start;
        Arrangement.Vertical top;
        int i6;
        Object objCreateOverflowState$foundation_layout_release;
        Object obj;
        ContextualFlowRowOverflow contextualFlowRowOverflow2;
        Modifier modifier2;
        int i7;
        int i8;
        Arrangement.Horizontal horizontal2;
        Arrangement.Vertical vertical2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-341770689);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContextualFlowRow)P(2,5,1,7,3,4,6)74@3434L65,77@3545L193,90@3961L267,82@3763L465,99@4233L90:ContextualFlowLayout.kt#2w3rfo");
        int i9 = i4;
        if ((i5 & 1) != 0) {
            i9 |= 6;
        } else if ((i4 & 6) == 0) {
            i9 |= composerStartRestartGroup.changed(i) ? 4 : 2;
        }
        int i10 = i5 & 2;
        if (i10 != 0) {
            i9 |= 48;
        } else if ((i4 & 48) == 0) {
            i9 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i11 = i5 & 4;
        if (i11 != 0) {
            i9 |= 384;
            start = horizontal;
        } else if ((i4 & 384) == 0) {
            start = horizontal;
            i9 |= composerStartRestartGroup.changed(start) ? 256 : 128;
        } else {
            start = horizontal;
        }
        int i12 = i5 & 8;
        if (i12 != 0) {
            i9 |= 3072;
            top = vertical;
        } else if ((i4 & 3072) == 0) {
            top = vertical;
            i9 |= composerStartRestartGroup.changed(top) ? 2048 : 1024;
        } else {
            top = vertical;
        }
        int i13 = i5 & 16;
        if (i13 != 0) {
            i9 |= CpioConstants.C_ISBLK;
            i6 = i2;
        } else if ((i4 & CpioConstants.C_ISBLK) == 0) {
            i6 = i2;
            i9 |= composerStartRestartGroup.changed(i6) ? 16384 : 8192;
        } else {
            i6 = i2;
        }
        int i14 = i5 & 32;
        if (i14 != 0) {
            i9 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if ((i4 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            i9 |= composerStartRestartGroup.changed(i3) ? 131072 : 65536;
        }
        int i15 = i5 & 64;
        if (i15 != 0) {
            i9 |= 1572864;
        } else if ((i4 & 1572864) == 0) {
            i9 |= composerStartRestartGroup.changed(contextualFlowRowOverflow) ? 1048576 : 524288;
        }
        if ((i5 & 128) != 0) {
            i9 |= 12582912;
        } else if ((i4 & 12582912) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((4793491 & i9) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            i8 = i3;
            contextualFlowRowOverflow2 = contextualFlowRowOverflow;
            vertical2 = top;
            i7 = i6;
            horizontal2 = start;
        } else {
            Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier;
            if (i11 != 0) {
                start = Arrangement.INSTANCE.getStart();
            }
            if (i12 != 0) {
                top = Arrangement.INSTANCE.getTop();
            }
            int i16 = i13 != 0 ? Integer.MAX_VALUE : i6;
            int i17 = i14 != 0 ? Integer.MAX_VALUE : i3;
            ContextualFlowRowOverflow clip = i15 != 0 ? ContextualFlowRowOverflow.INSTANCE.getClip() : contextualFlowRowOverflow;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-341770689, i9, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:73)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -514348999, "CC(remember):ContextualFlowLayout.kt#9igjgp");
            boolean z = (i9 & 3670016) == 1048576;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objCreateOverflowState$foundation_layout_release = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objCreateOverflowState$foundation_layout_release);
            } else {
                objCreateOverflowState$foundation_layout_release = objRememberedValue;
            }
            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objCreateOverflowState$foundation_layout_release;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -514348888, "CC(remember):ContextualFlowLayout.kt#9igjgp");
            boolean z2 = (3670016 & i9) == 1048576;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                ArrayList arrayList = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                composerStartRestartGroup.updateRememberedValue(arrayList);
                obj = arrayList;
            } else {
                obj = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ContextualFlowRowOverflow contextualFlowRowOverflow3 = clip;
            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualRowMeasurementHelper(start, top, i16, i17, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-8464804, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int index, FlowLineInfo info, Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C97@4208L14:ContextualFlowLayout.kt#2w3rfo");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8464804, $changed, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:91)");
                    }
                    ContextualFlowRowScopeImpl scope = new ContextualFlowRowScopeImpl(info.getLineIndex(), info.getPositionInLine(), info.getMaxMainAxisSize(), info.getMaxCrossAxisSize(), null);
                    function4.invoke(scope, Integer.valueOf(index), $composer, Integer.valueOf(($changed << 3) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 >> 6) & 14) | 12582912 | ((i9 >> 6) & 112) | ((i9 >> 6) & 896) | ((i9 >> 6) & 7168) | ((i9 << 15) & 458752)), composerStartRestartGroup, (i9 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contextualFlowRowOverflow2 = contextualFlowRowOverflow3;
            modifier2 = companion;
            i7 = i16;
            i8 = i17;
            horizontal2 = start;
            vertical2 = top;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Arrangement.Horizontal horizontal3 = horizontal2;
            final Arrangement.Vertical vertical3 = vertical2;
            final int i18 = i7;
            final int i19 = i8;
            final ContextualFlowRowOverflow contextualFlowRowOverflow4 = contextualFlowRowOverflow2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowRow.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    ContextualFlowLayoutKt.ContextualFlowRow(i, modifier3, horizontal3, vertical3, i18, i19, contextualFlowRowOverflow4, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    public static final void ContextualFlowColumn(final int i, Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i2, int i3, ContextualFlowColumnOverflow contextualFlowColumnOverflow, final Function4<? super ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        Arrangement.Vertical top;
        Arrangement.Horizontal start;
        int i6;
        Object objCreateOverflowState$foundation_layout_release;
        Object obj;
        ContextualFlowColumnOverflow contextualFlowColumnOverflow2;
        Modifier modifier2;
        int i7;
        int i8;
        Arrangement.Vertical vertical2;
        Arrangement.Horizontal horizontal2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-588476895);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContextualFlowColumn)P(2,5,7,1,3,4,6)149@6671L65,152@6782L193,165@7201L270,157@7000L471,175@7477L90:ContextualFlowLayout.kt#2w3rfo");
        int i9 = i4;
        if ((i5 & 1) != 0) {
            i9 |= 6;
        } else if ((i4 & 6) == 0) {
            i9 |= composerStartRestartGroup.changed(i) ? 4 : 2;
        }
        int i10 = i5 & 2;
        if (i10 != 0) {
            i9 |= 48;
        } else if ((i4 & 48) == 0) {
            i9 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i11 = i5 & 4;
        if (i11 != 0) {
            i9 |= 384;
            top = vertical;
        } else if ((i4 & 384) == 0) {
            top = vertical;
            i9 |= composerStartRestartGroup.changed(top) ? 256 : 128;
        } else {
            top = vertical;
        }
        int i12 = i5 & 8;
        if (i12 != 0) {
            i9 |= 3072;
            start = horizontal;
        } else if ((i4 & 3072) == 0) {
            start = horizontal;
            i9 |= composerStartRestartGroup.changed(start) ? 2048 : 1024;
        } else {
            start = horizontal;
        }
        int i13 = i5 & 16;
        if (i13 != 0) {
            i9 |= CpioConstants.C_ISBLK;
            i6 = i2;
        } else if ((i4 & CpioConstants.C_ISBLK) == 0) {
            i6 = i2;
            i9 |= composerStartRestartGroup.changed(i6) ? 16384 : 8192;
        } else {
            i6 = i2;
        }
        int i14 = i5 & 32;
        if (i14 != 0) {
            i9 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if ((i4 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            i9 |= composerStartRestartGroup.changed(i3) ? 131072 : 65536;
        }
        int i15 = i5 & 64;
        if (i15 != 0) {
            i9 |= 1572864;
        } else if ((i4 & 1572864) == 0) {
            i9 |= composerStartRestartGroup.changed(contextualFlowColumnOverflow) ? 1048576 : 524288;
        }
        if ((i5 & 128) != 0) {
            i9 |= 12582912;
        } else if ((i4 & 12582912) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((4793491 & i9) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            i8 = i3;
            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow;
            horizontal2 = start;
            i7 = i6;
            vertical2 = top;
        } else {
            Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier;
            if (i11 != 0) {
                top = Arrangement.INSTANCE.getTop();
            }
            if (i12 != 0) {
                start = Arrangement.INSTANCE.getStart();
            }
            int i16 = i13 != 0 ? Integer.MAX_VALUE : i6;
            int i17 = i14 != 0 ? Integer.MAX_VALUE : i3;
            ContextualFlowColumnOverflow clip = i15 != 0 ? ContextualFlowColumnOverflow.INSTANCE.getClip() : contextualFlowColumnOverflow;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-588476895, i9, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:148)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 935768944, "CC(remember):ContextualFlowLayout.kt#9igjgp");
            boolean z = (i9 & 3670016) == 1048576;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objCreateOverflowState$foundation_layout_release = clip.createOverflowState$foundation_layout_release();
                composerStartRestartGroup.updateRememberedValue(objCreateOverflowState$foundation_layout_release);
            } else {
                objCreateOverflowState$foundation_layout_release = objRememberedValue;
            }
            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objCreateOverflowState$foundation_layout_release;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 935769055, "CC(remember):ContextualFlowLayout.kt#9igjgp");
            boolean z2 = (3670016 & i9) == 1048576;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                ArrayList arrayList = new ArrayList();
                clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                composerStartRestartGroup.updateRememberedValue(arrayList);
                obj = arrayList;
            } else {
                obj = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ContextualFlowColumnOverflow contextualFlowColumnOverflow3 = clip;
            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualColumnMeasureHelper(top, start, i16, i17, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(302435318, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int index, FlowLineInfo info, Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C172@7451L14:ContextualFlowLayout.kt#2w3rfo");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(302435318, $changed, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:166)");
                    }
                    ContextualFlowColumnScopeImpl scope = new ContextualFlowColumnScopeImpl(info.getLineIndex(), info.getPositionInLine(), info.getMaxCrossAxisSize(), info.getMaxMainAxisSize(), null);
                    function4.invoke(scope, Integer.valueOf(index), $composer, Integer.valueOf(($changed << 3) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 >> 6) & 14) | 12582912 | ((i9 >> 6) & 112) | ((i9 >> 6) & 896) | ((i9 >> 6) & 7168) | ((i9 << 15) & 458752)), composerStartRestartGroup, (i9 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow3;
            modifier2 = companion;
            i7 = i16;
            i8 = i17;
            vertical2 = top;
            horizontal2 = start;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Arrangement.Vertical vertical3 = vertical2;
            final Arrangement.Horizontal horizontal3 = horizontal2;
            final int i18 = i7;
            final int i19 = i8;
            final ContextualFlowColumnOverflow contextualFlowColumnOverflow4 = contextualFlowColumnOverflow2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt.ContextualFlowColumn.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier3, vertical3, horizontal3, i18, i19, contextualFlowColumnOverflow4, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ca  */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflowState, int itemCount, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ComposerKt.sourceInformationMarkerStart($composer, -43351224, "C(contextualRowMeasurementHelper)P(1,7,3,4,6,2,5)343@13891L847:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43351224, $changed, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:342)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1145119064, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        if ((($changed & 14) ^ 6) > 4 && $composer.changed(horizontalArrangement)) {
            z = true;
        } else if (($changed & 6) == 4) {
            z = true;
        } else {
            z = false;
        }
        if ((($changed & 112) ^ 48) > 32 && $composer.changed(verticalArrangement)) {
            z2 = true;
        } else if (($changed & 48) == 32) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z7 = z | z2;
        if ((($changed & 896) ^ 384) > 256 && $composer.changed(maxItemsInMainAxis)) {
            z3 = true;
        } else if (($changed & 384) == 256) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z8 = z7 | z3;
        if ((($changed & 7168) ^ 3072) > 2048 && $composer.changed(maxLines)) {
            z4 = true;
        } else if (($changed & 3072) == 2048) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean zChanged = z8 | z4 | $composer.changed(overflowState);
        if (((458752 & $changed) ^ ProfileVerifier.CompilationStatus.f245xf2722a21) > 131072 && $composer.changed(itemCount)) {
            z5 = true;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 131072) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z9 = zChanged | z5;
        if (((29360128 & $changed) ^ 12582912) <= 8388608 || !$composer.changed(function4)) {
            z6 = ($changed & 12582912) == 8388608;
        }
        boolean invalid$iv = z9 | z6;
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new FlowMeasureLazyPolicy(true, horizontalArrangement, verticalArrangement, horizontalArrangement.getSpacing(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_TOP(), verticalArrangement.getSpacing(), itemCount, maxLines, maxItemsInMainAxis, overflowState, list, function4, null).getMeasurePolicy();
            $composer.updateRememberedValue(value$iv);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return function2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ca  */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflowState, int itemCount, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ComposerKt.sourceInformationMarkerStart($composer, 1009762916, "C(contextualColumnMeasureHelper)P(7,1,3,4,6,2,5)383@15228L850:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009762916, $changed, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:382)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1587835455, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        if ((($changed & 14) ^ 6) > 4 && $composer.changed(verticalArrangement)) {
            z = true;
        } else if (($changed & 6) == 4) {
            z = true;
        } else {
            z = false;
        }
        if ((($changed & 112) ^ 48) > 32 && $composer.changed(horizontalArrangement)) {
            z2 = true;
        } else if (($changed & 48) == 32) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z7 = z | z2;
        if ((($changed & 896) ^ 384) > 256 && $composer.changed(maxItemsInMainAxis)) {
            z3 = true;
        } else if (($changed & 384) == 256) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z8 = z7 | z3;
        if ((($changed & 7168) ^ 3072) > 2048 && $composer.changed(maxLines)) {
            z4 = true;
        } else if (($changed & 3072) == 2048) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean zChanged = z8 | z4 | $composer.changed(overflowState);
        if (((458752 & $changed) ^ ProfileVerifier.CompilationStatus.f245xf2722a21) > 131072 && $composer.changed(itemCount)) {
            z5 = true;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 131072) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z9 = zChanged | z5;
        if (((29360128 & $changed) ^ 12582912) <= 8388608 || !$composer.changed(function4)) {
            z6 = ($changed & 12582912) == 8388608;
        }
        boolean invalid$iv = z9 | z6;
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new FlowMeasureLazyPolicy(false, horizontalArrangement, verticalArrangement, verticalArrangement.getSpacing(), FlowLayoutKt.getCROSS_AXIS_ALIGNMENT_START(), horizontalArrangement.getSpacing(), itemCount, maxLines, maxItemsInMainAxis, overflowState, list, function4, null).getMeasurePolicy();
            $composer.updateRememberedValue(value$iv);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return function2;
    }
}
