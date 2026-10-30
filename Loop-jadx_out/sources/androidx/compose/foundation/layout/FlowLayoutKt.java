package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntList;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.IntrinsicMeasurable;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: FlowLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000Ô\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001ag\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001ag\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u001b2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010!\u001a5\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a\u0095\u0001\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00102\u001a[\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00106\u001aS\u00107\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002\u001a\u0090\u0001\u00109\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\b\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002\u001a%\u0010:\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010;\u001a5\u0010<\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010=\u001a\\\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0000ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a\u001c\u0010M\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010,\u001a\u00020\u000fH\u0000\u001a\u001c\u0010P\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010.\u001a\u00020\u000fH\u0000\u001a<\u0010Q\u001a\u00020(*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020R2\u0014\u0010S\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010T\u0012\u0004\u0012\u00020\u00070\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001aT\u0010W\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020?0[2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u000204H\u0000ø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a\u001e\u0010`\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, m195d2 = {"CROSS_AXIS_ALIGNMENT_START", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_START", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "getCROSS_AXIS_ALIGNMENT_TOP", "FlowColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowRowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "mainAxisSizes", "", "crossAxisSizes", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "crossAxisMin", "isHorizontal", "", "mainAxisMin", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", "items", "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "foundation-layout_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.INSTANCE.vertical$foundation_layout_release(Alignment.INSTANCE.getTop());
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout_release(Alignment.INSTANCE.getStart());

    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInEachRow, int maxLines, FlowRowOverflow overflow, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Arrangement.Horizontal horizontal;
        Arrangement.Vertical vertical;
        int maxItemsInEachRow2;
        int maxLines2;
        FlowRowOverflow overflow2;
        Arrangement.Horizontal horizontalArrangement2;
        Arrangement.Vertical verticalArrangement2;
        Object value$iv;
        int $i$f$cache;
        FlowLayoutOverflowState overflowState;
        Object value$iv2;
        Object value$iv$iv;
        Modifier modifier2;
        Function0<ComposeUiNode> function0;
        FlowRowOverflow overflow3;
        Composer $composer2 = $composer.startRestartGroup(437853230);
        ComposerKt.sourceInformation($composer2, "C(FlowRow)P(4,1,6,2,3,5)93@4089L65,96@4179L166,103@4391L261,110@4658L105:FlowLayout.kt#2w3rfo");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            horizontal = horizontalArrangement;
        } else if (($changed & 48) == 0) {
            horizontal = horizontalArrangement;
            $dirty |= $composer2.changed(horizontal) ? 32 : 16;
        } else {
            horizontal = horizontalArrangement;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            vertical = verticalArrangement;
        } else if (($changed & 384) == 0) {
            vertical = verticalArrangement;
            $dirty |= $composer2.changed(vertical) ? 256 : 128;
        } else {
            vertical = verticalArrangement;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            maxItemsInEachRow2 = maxItemsInEachRow;
        } else if (($changed & 3072) == 0) {
            maxItemsInEachRow2 = maxItemsInEachRow;
            $dirty |= $composer2.changed(maxItemsInEachRow2) ? 2048 : 1024;
        } else {
            maxItemsInEachRow2 = maxItemsInEachRow;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            maxLines2 = maxLines;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            maxLines2 = maxLines;
            $dirty |= $composer2.changed(maxLines2) ? 16384 : 8192;
        } else {
            maxLines2 = maxLines;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            overflow2 = overflow;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 131072 : 65536;
        } else {
            overflow2 = overflow;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            horizontalArrangement2 = horizontal;
            verticalArrangement2 = vertical;
            overflow3 = overflow2;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            horizontalArrangement2 = i3 != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
            verticalArrangement2 = i4 != 0 ? Arrangement.INSTANCE.getTop() : vertical;
            if (i5 != 0) {
                maxItemsInEachRow2 = Integer.MAX_VALUE;
            }
            if (i6 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            }
            if (i7 != 0) {
                overflow2 = FlowRowOverflow.INSTANCE.getClip();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(437853230, $dirty, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:92)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1786439465, "CC(remember):FlowLayout.kt#9igjgp");
            boolean invalid$iv = ($dirty & 458752) == 131072;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = overflow2.createOverflowState$foundation_layout_release();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            FlowLayoutOverflowState overflowState2 = (FlowLayoutOverflowState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $dirty2 = $dirty;
            MultiContentMeasurePolicy measurePolicy = rowMeasurementMultiContentHelper(horizontalArrangement2, verticalArrangement2, maxItemsInEachRow2, maxLines2, overflowState2, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168));
            ComposerKt.sourceInformationMarkerStart($composer2, -1786439163, "CC(remember):FlowLayout.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 3670016) == 1048576) | (($dirty2 & 458752) == 131072);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                List mutableList = new ArrayList();
                $i$f$cache = 1;
                mutableList.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
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
                        ComposerKt.sourceInformation($composer3, "C105@4547L9:FlowLayout.kt#2w3rfo");
                        if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-139531073, $changed2, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:105)");
                        }
                        function3.invoke(FlowRowScopeInstance.INSTANCE, $composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                overflowState = overflowState2;
                overflow2.addOverflowComposables$foundation_layout_release(overflowState, mutableList);
                value$iv2 = mutableList;
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
                overflowState = overflowState2;
                $i$f$cache = 1;
            }
            List list = (List) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = ($dirty2 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(list);
            ComposerKt.sourceInformationMarkerStart($composer2, 1376093675, "CC(remember):Layout.kt#9igjgp");
            if (((($changed$iv & 896) ^ 384) <= 256 || !$composer2.changed(measurePolicy)) && ($changed$iv & 384) != 256) {
                $i$f$cache = 0;
            }
            Object it$iv$iv = $composer2.rememberedValue();
            if ($i$f$cache != 0 || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv = $changed$iv & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier3);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            modifier2 = modifier3;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke($composer2, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            overflow3 = overflow2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Arrangement.Horizontal horizontal2 = horizontalArrangement2;
            final Arrangement.Vertical vertical2 = verticalArrangement2;
            final int i8 = maxItemsInEachRow2;
            final int i9 = maxLines2;
            final FlowRowOverflow flowRowOverflow = overflow3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.FlowRow.1
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

                public final void invoke(Composer composer, int i10) {
                    FlowLayoutKt.FlowRow(modifier4, horizontal2, vertical2, i8, i9, flowRowOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInEachColumn, int maxLines, FlowColumnOverflow overflow, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Arrangement.Vertical vertical;
        Arrangement.Horizontal horizontal;
        int maxItemsInEachColumn2;
        int maxLines2;
        FlowColumnOverflow overflow2;
        Arrangement.Vertical verticalArrangement2;
        Arrangement.Horizontal horizontalArrangement2;
        Object value$iv;
        int $i$f$cache;
        FlowLayoutOverflowState overflowState;
        Object value$iv2;
        Object value$iv$iv;
        Modifier modifier2;
        Function0<ComposeUiNode> function0;
        FlowColumnOverflow overflow3;
        Composer $composer2 = $composer.startRestartGroup(-1704849416);
        ComposerKt.sourceInformation($composer2, "C(FlowColumn)P(4,6,1,2,3,5)157@6483L65,160@6573L172,167@6791L264,173@7060L105:FlowLayout.kt#2w3rfo");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            vertical = verticalArrangement;
        } else if (($changed & 48) == 0) {
            vertical = verticalArrangement;
            $dirty |= $composer2.changed(vertical) ? 32 : 16;
        } else {
            vertical = verticalArrangement;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            horizontal = horizontalArrangement;
        } else if (($changed & 384) == 0) {
            horizontal = horizontalArrangement;
            $dirty |= $composer2.changed(horizontal) ? 256 : 128;
        } else {
            horizontal = horizontalArrangement;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            maxItemsInEachColumn2 = maxItemsInEachColumn;
        } else if (($changed & 3072) == 0) {
            maxItemsInEachColumn2 = maxItemsInEachColumn;
            $dirty |= $composer2.changed(maxItemsInEachColumn2) ? 2048 : 1024;
        } else {
            maxItemsInEachColumn2 = maxItemsInEachColumn;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            maxLines2 = maxLines;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            maxLines2 = maxLines;
            $dirty |= $composer2.changed(maxLines2) ? 16384 : 8192;
        } else {
            maxLines2 = maxLines;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            overflow2 = overflow;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 131072 : 65536;
        } else {
            overflow2 = overflow;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            verticalArrangement2 = vertical;
            horizontalArrangement2 = horizontal;
            overflow3 = overflow2;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            verticalArrangement2 = i3 != 0 ? Arrangement.INSTANCE.getTop() : vertical;
            horizontalArrangement2 = i4 != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
            if (i5 != 0) {
                maxItemsInEachColumn2 = Integer.MAX_VALUE;
            }
            if (i6 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            }
            if (i7 != 0) {
                overflow2 = FlowColumnOverflow.INSTANCE.getClip();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1704849416, $dirty, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:156)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1434364347, "CC(remember):FlowLayout.kt#9igjgp");
            boolean invalid$iv = ($dirty & 458752) == 131072;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = overflow2.createOverflowState$foundation_layout_release();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            FlowLayoutOverflowState overflowState2 = (FlowLayoutOverflowState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $dirty2 = $dirty;
            MultiContentMeasurePolicy measurePolicy = columnMeasurementMultiContentHelper(verticalArrangement2, horizontalArrangement2, maxItemsInEachColumn2, maxLines2, overflowState2, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168));
            ComposerKt.sourceInformationMarkerStart($composer2, -1434364039, "CC(remember):FlowLayout.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 3670016) == 1048576) | (($dirty2 & 458752) == 131072);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                List mutableList = new ArrayList();
                $i$f$cache = 1;
                mutableList.add(ComposableLambdaKt.composableLambdaInstance(985886665, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowColumn$list$1$1
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
                        ComposerKt.sourceInformation($composer3, "C169@6950L9:FlowLayout.kt#2w3rfo");
                        if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(985886665, $changed2, -1, "androidx.compose.foundation.layout.FlowColumn.<anonymous>.<anonymous> (FlowLayout.kt:169)");
                        }
                        function3.invoke(FlowColumnScopeInstance.INSTANCE, $composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                overflowState = overflowState2;
                overflow2.addOverflowComposables$foundation_layout_release(overflowState, mutableList);
                value$iv2 = mutableList;
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
                overflowState = overflowState2;
                $i$f$cache = 1;
            }
            List list = (List) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = ($dirty2 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(list);
            ComposerKt.sourceInformationMarkerStart($composer2, 1376093675, "CC(remember):Layout.kt#9igjgp");
            if (((($changed$iv & 896) ^ 384) <= 256 || !$composer2.changed(measurePolicy)) && ($changed$iv & 384) != 256) {
                $i$f$cache = 0;
            }
            Object it$iv$iv = $composer2.rememberedValue();
            if ($i$f$cache != 0 || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv = $changed$iv & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier3);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            modifier2 = modifier3;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke($composer2, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            overflow3 = overflow2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Arrangement.Vertical vertical2 = verticalArrangement2;
            final Arrangement.Horizontal horizontal2 = horizontalArrangement2;
            final int i8 = maxItemsInEachColumn2;
            final int i9 = maxLines2;
            final FlowColumnOverflow flowColumnOverflow = overflow3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.FlowColumn.1
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

                public final void invoke(Composer composer, int i10) {
                    FlowLayoutKt.FlowColumn(modifier4, vertical2, horizontal2, i8, i9, flowColumnOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        ComposerKt.sourceInformationMarkerStart($composer, 1479255111, "C(rowMeasurementHelper)P(!1,2)380@13086L883:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, $changed, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:379)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -2430844, "CC(remember):FlowLayout.kt#9igjgp");
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
        boolean z4 = z | z2;
        if ((($changed & 896) ^ 384) <= 256 || !$composer.changed(maxItemsInMainAxis)) {
            z3 = ($changed & 384) == 256;
        }
        boolean invalid$iv = z4 | z3;
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            final MultiContentMeasurePolicy measurePolicy = new FlowMeasurePolicy(true, horizontalArrangement, verticalArrangement, horizontalArrangement.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, verticalArrangement.getSpacing(), maxItemsInMainAxis, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout_release(), null);
            value$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
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
                public final MeasureResult mo285measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> list, long constraints) {
                    MultiContentMeasurePolicy $this$measure_3p2s80s_u24lambda_u240 = measurePolicy;
                    return $this$measure_3p2s80s_u24lambda_u240.mo816measure3p2s80s($this$MeasurePolicy, CollectionsKt.listOf(list), constraints);
                }
            };
            $composer.updateRememberedValue(value$iv);
        }
        MeasurePolicy measurePolicy2 = (MeasurePolicy) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return measurePolicy2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0089  */
    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflowState, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ComposerKt.sourceInformationMarkerStart($composer, -2134502475, "C(rowMeasurementMultiContentHelper)P(!1,4)414@14301L649:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2134502475, $changed, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:413)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1686581795, "CC(remember):FlowLayout.kt#9igjgp");
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
        boolean z5 = z | z2;
        if ((($changed & 896) ^ 384) > 256 && $composer.changed(maxItemsInMainAxis)) {
            z3 = true;
        } else if (($changed & 384) == 256) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z6 = z5 | z3;
        if ((($changed & 7168) ^ 3072) <= 2048 || !$composer.changed(maxLines)) {
            z4 = ($changed & 3072) == 2048;
        }
        boolean invalid$iv = z6 | z4 | $composer.changed(overflowState);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new FlowMeasurePolicy(true, horizontalArrangement, verticalArrangement, horizontalArrangement.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, verticalArrangement.getSpacing(), maxItemsInMainAxis, maxLines, overflowState, null);
            $composer.updateRememberedValue(value$iv);
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return flowMeasurePolicy;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        ComposerKt.sourceInformationMarkerStart($composer, -2013098357, "C(columnMeasurementHelper)P(2)443@15212L856:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, $changed, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:442)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1880377054, "CC(remember):FlowLayout.kt#9igjgp");
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
        boolean z4 = z | z2;
        if ((($changed & 896) ^ 384) <= 256 || !$composer.changed(maxItemsInMainAxis)) {
            z3 = ($changed & 384) == 256;
        }
        boolean invalid$iv = z4 | z3;
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy measurePolicy = new FlowMeasurePolicy(false, horizontalArrangement, verticalArrangement, verticalArrangement.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontalArrangement.getSpacing(), maxItemsInMainAxis, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout_release(), null);
            value$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
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
                public final MeasureResult mo285measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> list, long constraints) {
                    FlowMeasurePolicy $this$measure_3p2s80s_u24lambda_u240 = measurePolicy;
                    return $this$measure_3p2s80s_u24lambda_u240.mo816measure3p2s80s($this$MeasurePolicy, CollectionsKt.listOf(list), constraints);
                }
            };
            $composer.updateRememberedValue(value$iv);
        }
        MeasurePolicy measurePolicy2 = (MeasurePolicy) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return measurePolicy2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0089  */
    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflowState, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ComposerKt.sourceInformationMarkerStart($composer, 748776953, "C(columnMeasurementMultiContentHelper)P(4)475@16365L652:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(748776953, $changed, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:474)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1117653635, "CC(remember):FlowLayout.kt#9igjgp");
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
        boolean z5 = z | z2;
        if ((($changed & 896) ^ 384) > 256 && $composer.changed(maxItemsInMainAxis)) {
            z3 = true;
        } else if (($changed & 384) == 256) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z6 = z5 | z3;
        if ((($changed & 7168) ^ 3072) <= 2048 || !$composer.changed(maxLines)) {
            z4 = ($changed & 3072) == 2048;
        }
        boolean invalid$iv = z6 | z4 | $composer.changed(overflowState);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new FlowMeasurePolicy(false, horizontalArrangement, verticalArrangement, verticalArrangement.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontalArrangement.getSpacing(), maxItemsInMainAxis, maxLines, overflowState, null);
            $composer.updateRememberedValue(value$iv);
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return flowMeasurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int crossAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        int fixedSpace = 0;
        int currentFixedSpace = 0;
        int lastBreak = 0;
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            IntrinsicMeasurable child = (IntrinsicMeasurable) item$iv;
            int index = index$iv;
            int size2 = function3.invoke(child, Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue() + mainAxisSpacing;
            if ((index + 1) - lastBreak == maxItemsInMainAxis || index + 1 == list.size()) {
                lastBreak = index;
                fixedSpace = Math.max(fixedSpace, (currentFixedSpace + size2) - mainAxisSpacing);
                currentFixedSpace = 0;
            } else {
                currentFixedSpace += size2;
            }
        }
        return fixedSpace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v5, types: [kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.collections.IntIterator] */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function4, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int[] mainAxisSizes = new int[size];
        for (int i = 0; i < size; i++) {
            mainAxisSizes[i] = 0;
        }
        int size2 = list.size();
        int[] crossAxisSizes = new int[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            crossAxisSizes[i2] = 0;
        }
        int size3 = list.size();
        for (int index = 0; index < size3; index++) {
            IntrinsicMeasurable child = list.get(index);
            int mainAxisItemSize = function3.invoke(child, Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue();
            mainAxisSizes[index] = mainAxisItemSize;
            crossAxisSizes[index] = function4.invoke(child, Integer.valueOf(index), Integer.valueOf(mainAxisItemSize)).intValue();
        }
        int maxItemsThatCanBeShown = Integer.MAX_VALUE;
        if (maxLines != Integer.MAX_VALUE && maxItemsInMainAxis != Integer.MAX_VALUE) {
            maxItemsThatCanBeShown = maxItemsInMainAxis * maxLines;
        }
        boolean mustHaveEllipsis = (maxItemsThatCanBeShown >= list.size() || !(overflow.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandIndicator || overflow.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? maxItemsThatCanBeShown >= list.size() && maxLines >= overflow.getMinLinesToShowCollapse$foundation_layout_release() && overflow.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator : true;
        int maxItemsThatCanBeShown2 = Math.min(maxItemsThatCanBeShown - (mustHaveEllipsis ? 1 : 0), list.size());
        int $this$minIntrinsicMainAxisSize_u24lambda_u249 = ArraysKt.sum(mainAxisSizes);
        int maxMainAxisSize = $this$minIntrinsicMainAxisSize_u24lambda_u249 + ((list.size() - 1) * mainAxisSpacing);
        int mainAxisUsed = maxMainAxisSize;
        if (crossAxisSizes.length == 0) {
            throw new NoSuchElementException();
        }
        int crossAxisUsed = crossAxisSizes[0];
        ?? it = new IntRange(1, ArraysKt.getLastIndex(crossAxisSizes)).iterator();
        while (it.hasNext()) {
            int it2 = crossAxisSizes[it.nextInt()];
            if (crossAxisUsed < it2) {
                crossAxisUsed = it2;
            }
        }
        if (mainAxisSizes.length == 0) {
            throw new NoSuchElementException();
        }
        int low = mainAxisSizes[0];
        ?? it3 = new IntRange(1, ArraysKt.getLastIndex(mainAxisSizes)).iterator();
        while (it3.hasNext()) {
            int it4 = mainAxisSizes[it3.nextInt()];
            if (low < it4) {
                low = it4;
            }
        }
        int low2 = low;
        int crossAxisUsed2 = crossAxisUsed;
        int high = maxMainAxisSize;
        while (low2 <= high) {
            if (crossAxisUsed2 == crossAxisAvailable) {
                return mainAxisUsed;
            }
            int mid = (low2 + high) / 2;
            mainAxisUsed = mid;
            int high2 = high;
            int low3 = low2;
            maxItemsThatCanBeShown2 = maxItemsThatCanBeShown2;
            long pair = intrinsicCrossAxisSize(list, mainAxisSizes, crossAxisSizes, mainAxisUsed, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
            crossAxisUsed2 = IntIntPair.m275getFirstimpl(pair);
            int itemShown = IntIntPair.m276getSecondimpl(pair);
            if (crossAxisUsed2 > crossAxisAvailable || itemShown < maxItemsThatCanBeShown2) {
                low2 = mid + 1;
                if (low2 > high2) {
                    return low2;
                }
                high = high2;
            } else {
                if (crossAxisUsed2 >= crossAxisAvailable) {
                    return mainAxisUsed;
                }
                high = mid - 1;
                low2 = low3;
            }
        }
        return mainAxisUsed;
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, final int[] mainAxisSizes, final int[] crossAxisSizes, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        return intrinsicCrossAxisSize(list, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.intrinsicCrossAxisSize.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$intrinsicCrossAxisSize, int index, int i) {
                return Integer.valueOf(mainAxisSizes[index]);
            }
        }, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.intrinsicCrossAxisSize.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$intrinsicCrossAxisSize, int index, int i) {
                return Integer.valueOf(crossAxisSizes[index]);
            }
        }, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function4, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        int nextMainAxisSize;
        List<? extends IntrinsicMeasurable> list2 = list;
        if (list.isEmpty()) {
            return IntIntPair.m271constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks buildingBlocks = new FlowLayoutBuildingBlocks(maxItemsInMainAxis, overflow, OrientationIndependentConstraints.m835constructorimpl(0, mainAxisAvailable, 0, Integer.MAX_VALUE), maxLines, mainAxisSpacing, crossAxisSpacing, null);
        IntrinsicMeasurable nextChild = (IntrinsicMeasurable) CollectionsKt.getOrNull(list2, 0);
        int nextCrossAxisSize = nextChild != null ? function4.invoke(nextChild, 0, Integer.valueOf(mainAxisAvailable)).intValue() : 0;
        int nextMainAxisSize2 = nextChild != null ? function3.invoke(nextChild, 0, Integer.valueOf(nextCrossAxisSize)).intValue() : 0;
        int remaining = mainAxisAvailable;
        int currentCrossAxisSize = 0;
        int totalCrossAxisSize = 0;
        int lastBreak = 0;
        int lineIndex = 0;
        if (buildingBlocks.m790getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m271constructorimpl(remaining, Integer.MAX_VALUE), nextChild == null ? null : IntIntPair.m268boximpl(IntIntPair.m271constructorimpl(nextMainAxisSize2, nextCrossAxisSize)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM795ellipsisSizeF35zmw$foundation_layout_release = overflow.m795ellipsisSizeF35zmw$foundation_layout_release(nextChild != null, 0, 0);
            int size = intIntPairM795ellipsisSizeF35zmw$foundation_layout_release != null ? IntIntPair.m276getSecondimpl(intIntPairM795ellipsisSizeF35zmw$foundation_layout_release.getPackedValue()) : 0;
            return IntIntPair.m271constructorimpl(size, 0);
        }
        int noOfItemsShown = 0;
        int size2 = list.size();
        int index = 0;
        while (index < size2) {
            int childCrossAxisSize = nextCrossAxisSize;
            int childMainAxisSize = nextMainAxisSize2;
            remaining -= childMainAxisSize;
            noOfItemsShown = index + 1;
            currentCrossAxisSize = Math.max(currentCrossAxisSize, childCrossAxisSize);
            IntrinsicMeasurable nextChild2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list2, index + 1);
            nextCrossAxisSize = nextChild2 != null ? function4.invoke(nextChild2, Integer.valueOf(index + 1), Integer.valueOf(mainAxisAvailable)).intValue() : 0;
            int nextMainAxisSize3 = nextChild2 != null ? function3.invoke(nextChild2, Integer.valueOf(index + 1), Integer.valueOf(nextCrossAxisSize)).intValue() + mainAxisSpacing : 0;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfo = buildingBlocks.m790getWrapInfoOpUlnko(index + 2 < list.size(), (index + 1) - lastBreak, IntIntPair.m271constructorimpl(remaining, Integer.MAX_VALUE), nextChild2 == null ? null : IntIntPair.m268boximpl(IntIntPair.m271constructorimpl(nextMainAxisSize3, nextCrossAxisSize)), lineIndex, totalCrossAxisSize, currentCrossAxisSize, false, false);
            if (wrapInfo.getIsLastItemInLine()) {
                totalCrossAxisSize += currentCrossAxisSize + crossAxisSpacing;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisWrapInfo = buildingBlocks.getWrapEllipsisInfo(wrapInfo, nextChild2 != null, lineIndex, totalCrossAxisSize, remaining, (index + 1) - lastBreak);
                currentCrossAxisSize = 0;
                remaining = mainAxisAvailable;
                lastBreak = index + 1;
                nextMainAxisSize3 -= mainAxisSpacing;
                lineIndex++;
                if (wrapInfo.getIsLastItemInContainer()) {
                    if (ellipsisWrapInfo != null) {
                        long it = ellipsisWrapInfo.getEllipsisSize();
                        if (!ellipsisWrapInfo.getPlaceEllipsisOnLastContentLine()) {
                            totalCrossAxisSize += IntIntPair.m276getSecondimpl(it) + crossAxisSpacing;
                        }
                    }
                    nextMainAxisSize = noOfItemsShown;
                    return IntIntPair.m271constructorimpl(totalCrossAxisSize - crossAxisSpacing, nextMainAxisSize);
                }
            }
            nextMainAxisSize2 = nextMainAxisSize3;
            index++;
            list2 = list;
        }
        nextMainAxisSize = noOfItemsShown;
        return IntIntPair.m271constructorimpl(totalCrossAxisSize - crossAxisSpacing, nextMainAxisSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m792breakDownItemsdi9J0FM(MeasureScope $this$breakDownItems_u2ddi9J0FM, FlowLineMeasurePolicy measurePolicy, Iterator<? extends Measurable> it, float mainAxisSpacingDp, float crossAxisSpacingDp, long constraints, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        int leftOverCrossAxis;
        int leftOver;
        FlowLineInfo lineInfo;
        final Ref.ObjectRef placeableItem;
        IntIntPair intIntPairM268boximpl;
        MutableIntObjectMap placeables;
        List measurables;
        int mainAxisTotalSize;
        int mainAxisSize;
        int crossAxisSize;
        long measureConstraints;
        IntIntPair intIntPairM268boximpl2;
        IntIntPair intIntPairM268boximpl3;
        MutableIntList endBreakLineList;
        MutableIntList crossAxisSizes;
        int mainAxisMax;
        int leftOverCrossAxis2;
        FlowLineMeasurePolicy flowLineMeasurePolicy = measurePolicy;
        MutableVector items = new MutableVector(new MeasureResult[16], 0);
        int mainAxisMax2 = Constraints.m6744getMaxWidthimpl(constraints);
        int iM6746getMinWidthimpl = Constraints.m6746getMinWidthimpl(constraints);
        int iM6743getMaxHeightimpl = Constraints.m6743getMaxHeightimpl(constraints);
        MutableIntObjectMap placeables2 = IntObjectMapKt.mutableIntObjectMapOf();
        List measurables2 = new ArrayList();
        int spacing = (int) Math.ceil($this$breakDownItems_u2ddi9J0FM.mo567toPx0680j_4(mainAxisSpacingDp));
        int crossAxisSpacing = (int) Math.ceil($this$breakDownItems_u2ddi9J0FM.mo567toPx0680j_4(crossAxisSpacingDp));
        long subsetConstraints = OrientationIndependentConstraints.m835constructorimpl(0, mainAxisMax2, 0, iM6743getMaxHeightimpl);
        List measurables3 = measurables2;
        long measureConstraints2 = OrientationIndependentConstraints.m850toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m838copyyUG9Ft0(subsetConstraints, (10 & 1) != 0 ? Constraints.m6746getMinWidthimpl(subsetConstraints) : 0, (10 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(subsetConstraints) : 0, (10 & 4) != 0 ? Constraints.m6745getMinHeightimpl(subsetConstraints) : 0, (10 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(subsetConstraints) : 0), measurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        Ref.ObjectRef placeableItem2 = new Ref.ObjectRef();
        int lineIndex = 0;
        if (it instanceof ContextualFlowItemIterator) {
            leftOver = mainAxisMax2;
            leftOverCrossAxis = iM6743getMaxHeightimpl;
            lineInfo = new FlowLineInfo(0, 0, $this$breakDownItems_u2ddi9J0FM.mo564toDpu2uoSUM(leftOver), $this$breakDownItems_u2ddi9J0FM.mo564toDpu2uoSUM(leftOverCrossAxis), null);
        } else {
            leftOverCrossAxis = iM6743getMaxHeightimpl;
            leftOver = mainAxisMax2;
            lineInfo = null;
        }
        boolean $this$breakDownItems_di9J0FM_u24lambda_u2413 = it.hasNext();
        Measurable measurableSafeNext = !$this$breakDownItems_di9J0FM_u24lambda_u2413 ? null : safeNext(it, lineInfo);
        if (measurableSafeNext != null) {
            placeableItem = placeableItem2;
            intIntPairM268boximpl = IntIntPair.m268boximpl(m793measureAndCacherqJ1uqs(measurableSafeNext, flowLineMeasurePolicy, measureConstraints2, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable placeable) {
                    placeableItem.element = placeable;
                }
            }));
        } else {
            placeableItem = placeableItem2;
            intIntPairM268boximpl = null;
        }
        IntIntPair intIntPair = intIntPairM268boximpl;
        Integer nextMainAxisSize = intIntPair != null ? Integer.valueOf(IntIntPair.m275getFirstimpl(intIntPair.getPackedValue())) : null;
        Integer nextCrossAxisSize = intIntPair != null ? Integer.valueOf(IntIntPair.m276getSecondimpl(intIntPair.getPackedValue())) : null;
        int crossAxisMax = iM6743getMaxHeightimpl;
        MutableIntList endBreakLineList2 = new MutableIntList(0, 1, null);
        MutableIntList crossAxisSizes2 = new MutableIntList(0, 1, null);
        FlowLineInfo lineInfo2 = lineInfo;
        FlowLayoutBuildingBlocks buildingBlocks = new FlowLayoutBuildingBlocks(maxItemsInMainAxis, overflow, constraints, maxLines, spacing, crossAxisSpacing, null);
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = null;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo = buildingBlocks.m790getWrapInfoOpUlnko(it.hasNext(), 0, IntIntPair.m271constructorimpl(leftOver, leftOverCrossAxis), intIntPair, 0, 0, 0, false, false);
        if (wrapInfo.getIsLastItemInContainer()) {
            wrapEllipsisInfo = buildingBlocks.getWrapEllipsisInfo(wrapInfo, intIntPair != null, -1, 0, leftOver, 0);
        }
        int leftOverCrossAxis3 = leftOverCrossAxis;
        int currentLineMainAxisSize = 0;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2 = wrapEllipsisInfo;
        int leftOverCrossAxis4 = 0;
        MutableIntList endBreakLineList3 = endBreakLineList2;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo2 = wrapInfo;
        int currentLineCrossAxisSize = 0;
        int startBreakLineIndex = 0;
        int crossAxisTotalSize = 0;
        int startBreakLineIndex2 = leftOver;
        Measurable measurable = measurableSafeNext;
        MutableIntList crossAxisSizes3 = crossAxisSizes2;
        int currentLineMainAxisSize2 = iM6746getMinWidthimpl;
        Integer nextMainAxisSize2 = nextMainAxisSize;
        while (!wrapInfo2.getIsLastItemInContainer() && measurable != null) {
            Intrinsics.checkNotNull(nextMainAxisSize2);
            int itemMainAxisSize = nextMainAxisSize2.intValue();
            Intrinsics.checkNotNull(nextCrossAxisSize);
            int mainAxisMax3 = mainAxisMax2;
            int mainAxisTotalSize2 = currentLineMainAxisSize2;
            int mainAxisTotalSize3 = currentLineMainAxisSize + itemMainAxisSize;
            currentLineCrossAxisSize = Math.max(currentLineCrossAxisSize, nextCrossAxisSize.intValue());
            int itemCrossAxisSize = startBreakLineIndex2 - itemMainAxisSize;
            int currentLineMainAxisSize3 = mainAxisTotalSize3;
            int currentLineMainAxisSize4 = leftOverCrossAxis4 + 1;
            long measureConstraints3 = measureConstraints2;
            overflow.setItemShown$foundation_layout_release(currentLineMainAxisSize4);
            List measurables4 = measurables3;
            measurables4.add(measurable);
            placeables2.set(leftOverCrossAxis4, placeableItem.element);
            int nextIndexInLine = (leftOverCrossAxis4 + 1) - startBreakLineIndex;
            boolean willFitLine = nextIndexInLine < maxItemsInMainAxis;
            if (lineInfo2 != null) {
                lineInfo2.m803update4j6BHR0$foundation_layout_release(willFitLine ? lineIndex : lineIndex + 1, willFitLine ? nextIndexInLine : 0, $this$breakDownItems_u2ddi9J0FM.mo564toDpu2uoSUM(willFitLine ? RangesKt.coerceAtLeast(itemCrossAxisSize - spacing, 0) : mainAxisMax3), $this$breakDownItems_u2ddi9J0FM.mo564toDpu2uoSUM(willFitLine ? leftOverCrossAxis3 : RangesKt.coerceAtLeast((leftOverCrossAxis3 - currentLineCrossAxisSize) - crossAxisSpacing, 0)));
            } else {
                crossAxisSpacing = crossAxisSpacing;
                measurables4 = measurables4;
                placeables2 = placeables2;
                crossAxisSizes3 = crossAxisSizes3;
            }
            boolean $this$breakDownItems_di9J0FM_u24lambda_u2415 = it.hasNext();
            Measurable measurableSafeNext2 = !$this$breakDownItems_di9J0FM_u24lambda_u2415 ? null : safeNext(it, lineInfo2);
            placeableItem.element = null;
            if (measurableSafeNext2 != null) {
                measureConstraints = measureConstraints3;
                intIntPairM268boximpl2 = IntIntPair.m268boximpl(m793measureAndCacherqJ1uqs(measurableSafeNext2, flowLineMeasurePolicy, measureConstraints, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                        invoke2(placeable);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable placeable) {
                        placeableItem.element = placeable;
                    }
                }));
            } else {
                measureConstraints = measureConstraints3;
                intIntPairM268boximpl2 = null;
            }
            Integer nextMainAxisSize3 = intIntPairM268boximpl2 != null ? Integer.valueOf(IntIntPair.m275getFirstimpl(intIntPairM268boximpl2.getPackedValue()) + spacing) : null;
            nextCrossAxisSize = intIntPairM268boximpl2 != null ? Integer.valueOf(IntIntPair.m276getSecondimpl(intIntPairM268boximpl2.getPackedValue())) : null;
            boolean zHasNext = it.hasNext();
            int leftOverCrossAxis5 = leftOverCrossAxis3;
            long jM271constructorimpl = IntIntPair.m271constructorimpl(itemCrossAxisSize, leftOverCrossAxis5);
            if (intIntPairM268boximpl2 == null) {
                intIntPairM268boximpl3 = null;
            } else {
                Intrinsics.checkNotNull(nextMainAxisSize3);
                int leftOverCrossAxis6 = nextMainAxisSize3.intValue();
                Intrinsics.checkNotNull(nextCrossAxisSize);
                intIntPairM268boximpl3 = IntIntPair.m268boximpl(IntIntPair.m271constructorimpl(leftOverCrossAxis6, nextCrossAxisSize.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo wrapInfo3 = buildingBlocks.m790getWrapInfoOpUlnko(zHasNext, nextIndexInLine, jM271constructorimpl, intIntPairM268boximpl3, lineIndex, crossAxisTotalSize, currentLineCrossAxisSize, false, false);
            if (wrapInfo3.getIsLastItemInLine()) {
                mainAxisMax = mainAxisMax3;
                int mainAxisTotalSize4 = Math.min(Math.max(mainAxisTotalSize2, currentLineMainAxisSize3), mainAxisMax);
                int crossAxisTotalSize2 = crossAxisTotalSize + currentLineCrossAxisSize;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = buildingBlocks.getWrapEllipsisInfo(wrapInfo3, intIntPairM268boximpl2 != null, lineIndex, crossAxisTotalSize2, itemCrossAxisSize, (leftOverCrossAxis4 + 1) - startBreakLineIndex);
                crossAxisSizes = crossAxisSizes3;
                crossAxisSizes.add(currentLineCrossAxisSize);
                leftOverCrossAxis2 = (crossAxisMax - crossAxisTotalSize2) - crossAxisSpacing;
                int startBreakLineIndex3 = leftOverCrossAxis4 + 1;
                int mainAxisTotalSize5 = leftOverCrossAxis4 + 1;
                endBreakLineList = endBreakLineList3;
                endBreakLineList.add(mainAxisTotalSize5);
                currentLineCrossAxisSize = 0;
                nextMainAxisSize3 = nextMainAxisSize3 != null ? Integer.valueOf(nextMainAxisSize3.intValue() - spacing) : null;
                lineIndex++;
                currentLineMainAxisSize3 = 0;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
                startBreakLineIndex = startBreakLineIndex3;
                currentLineMainAxisSize2 = mainAxisTotalSize4;
                crossAxisTotalSize = crossAxisTotalSize2 + crossAxisSpacing;
                startBreakLineIndex2 = mainAxisMax;
            } else {
                currentLineMainAxisSize2 = mainAxisTotalSize2;
                endBreakLineList = endBreakLineList3;
                crossAxisSizes = crossAxisSizes3;
                mainAxisMax = mainAxisMax3;
                startBreakLineIndex2 = itemCrossAxisSize;
                leftOverCrossAxis2 = leftOverCrossAxis5;
            }
            leftOverCrossAxis4++;
            endBreakLineList3 = endBreakLineList;
            wrapInfo2 = wrapInfo3;
            crossAxisSizes3 = crossAxisSizes;
            measureConstraints2 = measureConstraints;
            mainAxisMax2 = mainAxisMax;
            leftOverCrossAxis3 = leftOverCrossAxis2;
            placeableItem = placeableItem;
            currentLineMainAxisSize = currentLineMainAxisSize3;
            placeables2 = placeables2;
            measurables3 = measurables4;
            crossAxisSpacing = crossAxisSpacing;
            nextMainAxisSize2 = nextMainAxisSize3;
            measurable = measurableSafeNext2;
        }
        int crossAxisSpacing2 = crossAxisSpacing;
        Object measurable2 = measurable;
        MutableIntObjectMap placeables3 = placeables2;
        Ref.ObjectRef placeableItem3 = placeableItem;
        List measurables5 = measurables3;
        MutableIntList endBreakLineList4 = endBreakLineList3;
        long j = measureConstraints2;
        int mainAxisMax4 = mainAxisMax2;
        MutableIntList crossAxisSizes4 = crossAxisSizes3;
        if (wrapEllipsisInfo2 != null) {
            FlowLayoutBuildingBlocks.WrapEllipsisInfo it2 = wrapEllipsisInfo2;
            measurables = measurables5;
            measurables.add(it2.getEllipsis());
            placeables = placeables3;
            placeables.set(measurables.size() - 1, it2.getPlaceable());
            int mainAxisTotalSize6 = endBreakLineList4._size;
            int lineIndex2 = mainAxisTotalSize6 - 1;
            if (it2.getPlaceEllipsisOnLastContentLine()) {
                int lastIndex = endBreakLineList4.getSize() - 1;
                int lastLineCrossAxis = crossAxisSizes4.get(lineIndex2);
                crossAxisSizes4.set(lineIndex2, Math.max(lastLineCrossAxis, IntIntPair.m276getSecondimpl(it2.getEllipsisSize())));
                endBreakLineList4.set(lastIndex, endBreakLineList4.last() + 1);
            } else {
                crossAxisSizes4.add(IntIntPair.m276getSecondimpl(it2.getEllipsisSize()));
                endBreakLineList4.add(endBreakLineList4.last() + 1);
            }
        } else {
            spacing = spacing;
            placeables = placeables3;
            measurables = measurables5;
        }
        int size = measurables.size();
        Placeable[] placeableArr = new Placeable[size];
        for (int i = 0; i < size; i++) {
            placeableArr[i] = placeables.get(i);
        }
        long measureConstraints4 = j;
        int size2 = endBreakLineList4.getSize();
        int[] crossAxisOffsets = new int[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            crossAxisOffsets[i2] = 0;
        }
        int size3 = endBreakLineList4.getSize();
        int[] crossAxisSizesArray = new int[size3];
        for (int i3 = 0; i3 < size3; i3++) {
            crossAxisSizesArray[i3] = 0;
        }
        MutableIntList this_$iv = endBreakLineList4;
        int[] content$iv = this_$iv.content;
        int mainAxisTotalSize7 = this_$iv._size;
        int crossAxisTotalSize3 = 0;
        int startIndex = 0;
        int startIndex2 = 0;
        int i$iv = currentLineMainAxisSize2;
        while (startIndex2 < mainAxisTotalSize7) {
            int endIndex = content$iv[startIndex2];
            int currentLineIndex = startIndex2;
            int crossAxisSize2 = crossAxisSizes4.get(currentLineIndex);
            int i$iv2 = startIndex2;
            int crossAxisSpacing3 = crossAxisSpacing2;
            int mainAxisTotalSize8 = i$iv;
            Object measurable3 = measurable2;
            int i4 = mainAxisTotalSize7;
            int index = leftOverCrossAxis4;
            long measureConstraints5 = measureConstraints4;
            int[] content$iv2 = content$iv;
            MutableIntList crossAxisSizes5 = crossAxisSizes4;
            List measurables6 = measurables;
            MutableIntObjectMap placeables4 = placeables;
            FlowLineInfo lineInfo3 = lineInfo2;
            int crossAxisMax2 = crossAxisMax;
            IntList this_$iv2 = this_$iv;
            int mainAxisMax5 = mainAxisMax4;
            MutableVector items2 = items;
            Ref.ObjectRef placeableItem4 = placeableItem3;
            MeasureResult result = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy, i$iv, Constraints.m6745getMinHeightimpl(subsetConstraints), Constraints.m6744getMaxWidthimpl(subsetConstraints), crossAxisSize2, spacing, $this$breakDownItems_u2ddi9J0FM, measurables, placeableArr, startIndex, endIndex, crossAxisOffsets, currentLineIndex);
            if (measurePolicy.isHorizontal()) {
                mainAxisSize = result.getWidth();
                crossAxisSize = result.getHeight();
            } else {
                mainAxisSize = result.getHeight();
                crossAxisSize = result.getWidth();
            }
            crossAxisSizesArray[currentLineIndex] = crossAxisSize;
            crossAxisTotalSize3 += crossAxisSize;
            int mainAxisTotalSize9 = Math.max(mainAxisTotalSize8, mainAxisSize);
            items2.add(result);
            startIndex = endIndex;
            startIndex2 = i$iv2 + 1;
            flowLineMeasurePolicy = measurePolicy;
            i$iv = mainAxisTotalSize9;
            this_$iv = this_$iv2;
            content$iv = content$iv2;
            placeableItem3 = placeableItem4;
            mainAxisTotalSize7 = i4;
            leftOverCrossAxis4 = index;
            measurables = measurables6;
            measureConstraints4 = measureConstraints5;
            measurable2 = measurable3;
            crossAxisSizes4 = crossAxisSizes5;
            placeables = placeables4;
            crossAxisMax = crossAxisMax2;
            lineInfo2 = lineInfo3;
            mainAxisMax4 = mainAxisMax5;
            items = items2;
            crossAxisSpacing2 = crossAxisSpacing3;
        }
        int mainAxisTotalSize10 = i$iv;
        MutableVector items3 = items;
        if (!items3.isEmpty()) {
            mainAxisTotalSize = mainAxisTotalSize10;
        } else {
            mainAxisTotalSize = 0;
            crossAxisTotalSize3 = 0;
        }
        return m794placeHelperBmaY500($this$breakDownItems_u2ddi9J0FM, constraints, mainAxisTotalSize, crossAxisTotalSize3, crossAxisSizesArray, items3, measurePolicy, crossAxisOffsets);
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo info) {
        Measurable next;
        try {
            if (it instanceof ContextualFlowItemIterator) {
                Intrinsics.checkNotNull(info);
                next = ((ContextualFlowItemIterator) it).getNext$foundation_layout_release(info);
            } else {
                next = it.next();
            }
            return next;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static final int mainAxisMin(IntrinsicMeasurable $this$mainAxisMin, boolean isHorizontal, int crossAxisSize) {
        if (isHorizontal) {
            return $this$mainAxisMin.minIntrinsicWidth(crossAxisSize);
        }
        return $this$mainAxisMin.minIntrinsicHeight(crossAxisSize);
    }

    public static final int crossAxisMin(IntrinsicMeasurable $this$crossAxisMin, boolean isHorizontal, int mainAxisSize) {
        if (isHorizontal) {
            return $this$crossAxisMin.minIntrinsicHeight(mainAxisSize);
        }
        return $this$crossAxisMin.minIntrinsicWidth(mainAxisSize);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    /* JADX INFO: renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m793measureAndCacherqJ1uqs(Measurable $this$measureAndCache_u2drqJ1uqs, FlowLineMeasurePolicy measurePolicy, long constraints, Function1<? super Placeable, Unit> function1) {
        FlowLayoutData flowLayoutData;
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData($this$measureAndCache_u2drqJ1uqs)) == 0.0f) {
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData($this$measureAndCache_u2drqJ1uqs);
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) == null) {
                Placeable placeable = $this$measureAndCache_u2drqJ1uqs.mo5644measureBRTryo0(constraints);
                function1.invoke(placeable);
                int mainAxis = measurePolicy.mainAxisSize(placeable);
                int crossAxis = measurePolicy.crossAxisSize(placeable);
                return IntIntPair.m271constructorimpl(mainAxis, crossAxis);
            }
        }
        int mainAxis2 = mainAxisMin($this$measureAndCache_u2drqJ1uqs, measurePolicy.isHorizontal(), Integer.MAX_VALUE);
        int crossAxis2 = crossAxisMin($this$measureAndCache_u2drqJ1uqs, measurePolicy.isHorizontal(), mainAxis2);
        return IntIntPair.m271constructorimpl(mainAxis2, crossAxis2);
    }

    /* JADX INFO: renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m794placeHelperBmaY500(MeasureScope $this$placeHelper_u2dBmaY500, long constraints, int mainAxisTotalSize, int crossAxisTotalSize, int[] crossAxisSizes, final MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy measureHelper, int[] outPosition) {
        int totalCrossAxisSize;
        int layoutWidth;
        int layoutHeight;
        boolean isHorizontal = measureHelper.isHorizontal();
        Arrangement.Vertical verticalArrangement = measureHelper.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = measureHelper.getHorizontalArrangement();
        if (isHorizontal) {
            if (verticalArrangement == null) {
                throw new IllegalArgumentException("null verticalArrangement".toString());
            }
            int totalCrossAxisSpacing = $this$placeHelper_u2dBmaY500.mo561roundToPx0680j_4(verticalArrangement.getSpacing()) * (mutableVector.getSize() - 1);
            int totalCrossAxisSize2 = RangesKt.coerceIn(crossAxisTotalSize + totalCrossAxisSpacing, Constraints.m6745getMinHeightimpl(constraints), Constraints.m6743getMaxHeightimpl(constraints));
            verticalArrangement.arrange($this$placeHelper_u2dBmaY500, totalCrossAxisSize2, crossAxisSizes, outPosition);
            totalCrossAxisSize = totalCrossAxisSize2;
        } else {
            if (horizontalArrangement == null) {
                throw new IllegalArgumentException("null horizontalArrangement".toString());
            }
            int totalCrossAxisSpacing2 = $this$placeHelper_u2dBmaY500.mo561roundToPx0680j_4(horizontalArrangement.getSpacing()) * (mutableVector.getSize() - 1);
            totalCrossAxisSize = RangesKt.coerceIn(crossAxisTotalSize + totalCrossAxisSpacing2, Constraints.m6745getMinHeightimpl(constraints), Constraints.m6743getMaxHeightimpl(constraints));
            horizontalArrangement.arrange($this$placeHelper_u2dBmaY500, totalCrossAxisSize, crossAxisSizes, $this$placeHelper_u2dBmaY500.getLayoutDirection(), outPosition);
        }
        int finalMainAxisTotalSize = RangesKt.coerceIn(mainAxisTotalSize, Constraints.m6746getMinWidthimpl(constraints), Constraints.m6744getMaxWidthimpl(constraints));
        if (isHorizontal) {
            int layoutHeight2 = totalCrossAxisSize;
            layoutWidth = finalMainAxisTotalSize;
            layoutHeight = layoutHeight2;
        } else {
            int layoutWidth2 = totalCrossAxisSize;
            layoutWidth = layoutWidth2;
            layoutHeight = finalMainAxisTotalSize;
        }
        return MeasureScope.CC.layout$default($this$placeHelper_u2dBmaY500, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$placeHelper$5
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
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                MutableVector<MeasureResult> mutableVector2 = mutableVector;
                int size$iv = mutableVector2.getSize();
                if (size$iv <= 0) {
                    return;
                }
                int i$iv = 0;
                Object[] content$iv = mutableVector2.getContent();
                do {
                    MeasureResult measureResult = (MeasureResult) content$iv[i$iv];
                    measureResult.placeChildren();
                    i$iv++;
                } while (i$iv < size$iv);
            }
        }, 4, null);
    }
}
