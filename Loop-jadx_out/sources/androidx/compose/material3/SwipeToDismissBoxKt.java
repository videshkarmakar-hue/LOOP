package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: SwipeToDismissBox.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\b2#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00190\bH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e"}, m195d2 = {"DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismissBox", "", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "backgroundContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "gesturesEnabled", "content", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSwipeToDismissBoxState", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwipeToDismissBoxKt {
    private static final float DismissVelocityThreshold = C1979Dp.m6801constructorimpl(125);

    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue initialValue, final Function1<? super SwipeToDismissBoxValue, Boolean> function1, final Function1<? super Float, Float> function2, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -246335487, "C(rememberSwipeToDismissBoxState)P(1)193@7587L19,195@7667L7,202@7881L102,196@7686L297:SwipeToDismissBox.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialValue = SwipeToDismissBoxValue.Settled;
        }
        if ((i & 2) != 0) {
            Function1 confirmValueChange = new Function1<SwipeToDismissBoxValue, Boolean>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt.rememberSwipeToDismissBoxState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SwipeToDismissBoxValue it) {
                    return true;
                }
            };
            function1 = confirmValueChange;
        }
        if ((i & 4) != 0) {
            function2 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold($composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-246335487, $changed, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:194)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        Object[] objArr = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver = SwipeToDismissBoxState.INSTANCE.Saver(function1, function2, density);
        ComposerKt.sourceInformationMarkerStart($composer, -1012846434, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean invalid$iv = (((($changed & 896) ^ 384) > 256 && $composer.changed(function2)) || ($changed & 384) == 256) | (((6 ^ ($changed & 14)) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4) | $composer.changed(density) | (((($changed & 112) ^ 48) > 32 && $composer.changed(function1)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<SwipeToDismissBoxState>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SwipeToDismissBoxState invoke() {
                    return new SwipeToDismissBoxState(initialValue, density, function1, function2);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return swipeToDismissBoxState;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0145  */
    /* JADX WARN: Code duplicated, block: B:104:0x0150  */
    /* JADX WARN: Code duplicated, block: B:107:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:110:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:114:0x0202  */
    /* JADX WARN: Code duplicated, block: B:118:0x0218 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:125:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:126:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:129:0x0322  */
    /* JADX WARN: Code duplicated, block: B:133:0x0338 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:138:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:141:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:142:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:145:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:146:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:149:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:153:0x03d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:157:0x045d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0469  */
    /* JADX WARN: Code duplicated, block: B:161:0x046f  */
    /* JADX WARN: Code duplicated, block: B:164:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:167:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:168:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:172:0x0529  */
    /* JADX WARN: Code duplicated, block: B:176:0x0535  */
    /* JADX WARN: Code duplicated, block: B:177:0x0556  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:84:0x0100  */
    /* JADX WARN: Code duplicated, block: B:86:0x0103  */
    /* JADX WARN: Code duplicated, block: B:88:0x0107  */
    /* JADX WARN: Code duplicated, block: B:90:0x010b  */
    /* JADX WARN: Code duplicated, block: B:91:0x010d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x0139  */
    /* JADX WARN: Code duplicated, block: B:98:0x013b  */
    public static final void SwipeToDismissBox(final SwipeToDismissBoxState state, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean enableDismissFromStartToEnd, boolean enableDismissFromEndToStart, boolean gesturesEnabled, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final boolean enableDismissFromStartToEnd2;
        final boolean enableDismissFromEndToStart2;
        boolean z;
        int i2;
        Modifier.Companion modifier3;
        boolean gesturesEnabled2;
        Object objConsume;
        final boolean isRtl;
        boolean z2;
        Modifier modifier4;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function0;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        int compositeKeyHash$iv$iv2;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> function1;
        Composer $this$Layout_u24lambda_u240$iv$iv2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean invalid$iv;
        Object value$iv;
        int compositeKeyHash$iv$iv3;
        Function0<ComposeUiNode> constructor3;
        Function0<ComposeUiNode> function2;
        Composer $this$Layout_u24lambda_u240$iv$iv3;
        boolean enableDismissFromStartToEnd3;
        boolean gesturesEnabled3;
        boolean enableDismissFromEndToStart3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer $composer2 = $composer.startRestartGroup(-402577235);
        ComposerKt.sourceInformation($composer2, "C(SwipeToDismissBox)P(6!1,5,3,2,4)231@9156L7,233@9192L1214:SwipeToDismissBox.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            enableDismissFromStartToEnd2 = enableDismissFromStartToEnd;
        } else if (($changed & 3072) == 0) {
            enableDismissFromStartToEnd2 = enableDismissFromStartToEnd;
            $dirty |= $composer2.changed(enableDismissFromStartToEnd2) ? 2048 : 1024;
        } else {
            enableDismissFromStartToEnd2 = enableDismissFromStartToEnd;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            enableDismissFromEndToStart2 = enableDismissFromEndToStart;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            enableDismissFromEndToStart2 = enableDismissFromEndToStart;
            $dirty |= $composer2.changed(enableDismissFromEndToStart2) ? 16384 : 8192;
        } else {
            enableDismissFromEndToStart2 = enableDismissFromEndToStart;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = gesturesEnabled;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            z = gesturesEnabled;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = gesturesEnabled;
        }
        if ((i & 64) == 0) {
            if (($changed & 1572864) == 0) {
                i2 = $composer2.changedInstance(function4) ? 1048576 : 524288;
            }
            if (($dirty & 599187) == 599186 || !$composer2.getSkipping()) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enableDismissFromStartToEnd2 = true;
                }
                if (i5 != 0) {
                    enableDismissFromEndToStart2 = true;
                }
                if (i6 != 0) {
                    gesturesEnabled2 = true;
                } else {
                    gesturesEnabled2 = z;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-402577235, $dirty, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:230)");
                }
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                objConsume = $composer2.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (objConsume == LayoutDirection.Rtl) {
                    isRtl = true;
                } else {
                    isRtl = false;
                }
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release = state.getAnchoredDraggableState$material3_release();
                Orientation orientation = Orientation.Horizontal;
                if (gesturesEnabled2 || state.getCurrentValue() != SwipeToDismissBoxValue.Settled) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                Modifier modifier$iv = AnchoredDraggableKt.anchoredDraggable(modifier3, anchoredDraggableState$material3_release, orientation, (16 & 4) != 0 ? true : z2, (16 & 8) != 0 ? false : false, (16 & 16) != 0 ? null : null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                int $changed$iv$iv = (384 << 3) & 112;
                modifier4 = modifier3;
                boolean gesturesEnabled4 = gesturesEnabled2;
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i8 = ((384 >> 6) & 112) | 6;
                BoxScope $this$SwipeToDismissBox_u24lambda_u242 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1536817569, "C242@9523L105,251@9822L568,246@9637L763:SwipeToDismissBox.kt#uh7d8r");
                Modifier modifierMatchParentSize = $this$SwipeToDismissBox_u24lambda_u242.matchParentSize(Modifier.INSTANCE);
                int $changed$iv = ($dirty << 6) & 7168;
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                int $changed$iv$iv2 = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifierMatchParentSize);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function1 = constructor2;
                    $composer2.createNode(function1);
                } else {
                    function1 = constructor2;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                function3.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier.Companion companion = Modifier.INSTANCE;
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release2 = state.getAnchoredDraggableState$material3_release();
                Orientation orientation2 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart($composer2, 1536817868, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                if (($dirty & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean zChanged = z3 | $composer2.changed(isRtl);
                if ((57344 & $dirty) == 16384) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z6 = zChanged | z4;
                if (($dirty & 14) == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                invalid$iv = z6 | z5;
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue> invoke(IntSize intSize, Constraints constraints) {
                            return m2675invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
                        public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2675invokeGpV2Q24(long size, long j) {
                            final float width = IntSize.m6975getWidthimpl(size);
                            final boolean z7 = enableDismissFromStartToEnd2;
                            final boolean z8 = isRtl;
                            final boolean z9 = enableDismissFromEndToStart2;
                            return TuplesKt.m202to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                                    invoke2(draggableAnchorsConfig);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                                    draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.Settled, 0.0f);
                                    if (z7) {
                                        draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.StartToEnd, z8 ? -width : width);
                                    }
                                    if (z9) {
                                        draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.EndToStart, z8 ? width : -width);
                                    }
                                }
                            }), state.getTargetValue());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifierDraggableAnchors = AnchoredDraggableKt.draggableAnchors(companion, anchoredDraggableState$material3_release2, orientation2, (Function2) value$iv);
                int $changed$iv2 = ($dirty >> 9) & 7168;
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
                int $changed$iv$iv3 = ($changed$iv2 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifierDraggableAnchors);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function2 = constructor3;
                    $composer2.createNode(function2);
                } else {
                    function2 = constructor3;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    enableDismissFromStartToEnd3 = enableDismissFromStartToEnd2;
                } else {
                    enableDismissFromStartToEnd3 = enableDismissFromStartToEnd2;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    function4.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    gesturesEnabled3 = gesturesEnabled4;
                    enableDismissFromEndToStart3 = enableDismissFromEndToStart2;
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv2 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                gesturesEnabled3 = gesturesEnabled4;
                enableDismissFromEndToStart3 = enableDismissFromEndToStart2;
            } else {
                $composer2.skipToGroupEnd();
                gesturesEnabled3 = z;
                modifier4 = modifier2;
                enableDismissFromStartToEnd3 = enableDismissFromStartToEnd2;
                enableDismissFromEndToStart3 = enableDismissFromEndToStart2;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier4;
                final boolean z7 = enableDismissFromStartToEnd3;
                final boolean z8 = enableDismissFromEndToStart3;
                final boolean z9 = gesturesEnabled3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt.SwipeToDismissBox.2
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
                        SwipeToDismissBoxKt.SwipeToDismissBox(state, function3, modifier5, z7, z8, z9, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 1572864;
        $dirty |= i2;
        if (($dirty & 599187) == 599186) {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enableDismissFromStartToEnd2 = true;
            }
            if (i5 != 0) {
                enableDismissFromEndToStart2 = true;
            }
            if (i6 != 0) {
                gesturesEnabled2 = true;
            } else {
                gesturesEnabled2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-402577235, $dirty, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:230)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            objConsume = $composer2.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (objConsume == LayoutDirection.Rtl) {
                isRtl = true;
            } else {
                isRtl = false;
            }
            AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release3 = state.getAnchoredDraggableState$material3_release();
            Orientation orientation3 = Orientation.Horizontal;
            if (gesturesEnabled2) {
                z2 = false;
            } else {
                z2 = false;
            }
            Modifier modifier$iv2 = AnchoredDraggableKt.anchoredDraggable(modifier3, anchoredDraggableState$material3_release3, orientation3, (16 & 4) != 0 ? true : z2, (16 & 8) != 0 ? false : false, (16 & 16) != 0 ? null : null);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, true);
            int $changed$iv$iv4 = (384 << 3) & 112;
            modifier4 = modifier3;
            boolean gesturesEnabled5 = gesturesEnabled2;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
            int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i13 = ((384 >> 6) & 112) | 6;
            BoxScope $this$SwipeToDismissBox_u24lambda_u243 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1536817569, "C242@9523L105,251@9822L568,246@9637L763:SwipeToDismissBox.kt#uh7d8r");
            Modifier modifierMatchParentSize2 = $this$SwipeToDismissBox_u24lambda_u243.matchParentSize(Modifier.INSTANCE);
            int $changed$iv3 = ($dirty << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer2, (($changed$iv3 >> 3) & 14) | (($changed$iv3 >> 3) & 112));
            int $changed$iv$iv5 = ($changed$iv3 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer2, modifierMatchParentSize2);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor2;
                $composer2.createNode(function1);
            } else {
                function1 = constructor2;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash5);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
            int i14 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv3 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release4 = state.getAnchoredDraggableState$material3_release();
            Orientation orientation4 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart($composer2, 1536817868, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            if (($dirty & 7168) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean zChanged2 = z3 | $composer2.changed(isRtl);
            if ((57344 & $dirty) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z10 = zChanged2 | z4;
            if (($dirty & 14) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            invalid$iv = z10 | z5;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue> invoke(IntSize intSize, Constraints constraints) {
                    return m2675invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
                public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2675invokeGpV2Q24(long size, long j) {
                    final float width = IntSize.m6975getWidthimpl(size);
                    final boolean z11 = enableDismissFromStartToEnd2;
                    final boolean z12 = isRtl;
                    final boolean z13 = enableDismissFromEndToStart2;
                    return TuplesKt.m202to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                            invoke2(draggableAnchorsConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.Settled, 0.0f);
                            if (z11) {
                                draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.StartToEnd, z12 ? -width : width);
                            }
                            if (z13) {
                                draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.EndToStart, z12 ? width : -width);
                            }
                        }
                    }), state.getTargetValue());
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierDraggableAnchors2 = AnchoredDraggableKt.draggableAnchors(companion2, anchoredDraggableState$material3_release4, orientation4, (Function2) value$iv);
            int $changed$iv4 = ($dirty >> 9) & 7168;
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer2, (($changed$iv4 >> 3) & 14) | (($changed$iv4 >> 3) & 112));
            int $changed$iv$iv6 = ($changed$iv4 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv6 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer2, modifierDraggableAnchors2);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor3;
                $composer2.createNode(function2);
            } else {
                function2 = constructor3;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                enableDismissFromStartToEnd3 = enableDismissFromStartToEnd2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                int i15 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv4 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                gesturesEnabled3 = gesturesEnabled5;
                enableDismissFromEndToStart3 = enableDismissFromEndToStart2;
            } else {
                enableDismissFromStartToEnd3 = enableDismissFromStartToEnd2;
            }
            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash6);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
            int i16 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            function4.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv4 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            gesturesEnabled3 = gesturesEnabled5;
            enableDismissFromEndToStart3 = enableDismissFromEndToStart2;
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enableDismissFromStartToEnd2 = true;
            }
            if (i5 != 0) {
                enableDismissFromEndToStart2 = true;
            }
            if (i6 != 0) {
                gesturesEnabled2 = true;
            } else {
                gesturesEnabled2 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-402577235, $dirty, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:230)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            objConsume = $composer2.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (objConsume == LayoutDirection.Rtl) {
                isRtl = true;
            } else {
                isRtl = false;
            }
            AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release5 = state.getAnchoredDraggableState$material3_release();
            Orientation orientation5 = Orientation.Horizontal;
            if (gesturesEnabled2) {
                z2 = false;
            } else {
                z2 = false;
            }
            Modifier modifier$iv3 = AnchoredDraggableKt.anchoredDraggable(modifier3, anchoredDraggableState$material3_release5, orientation5, (16 & 4) != 0 ? true : z2, (16 & 8) != 0 ? false : false, (16 & 16) != 0 ? null : null);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, true);
            int $changed$iv$iv7 = (384 << 3) & 112;
            modifier4 = modifier3;
            boolean gesturesEnabled6 = gesturesEnabled2;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv7 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash7);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
            int i17 = ($changed$iv$iv$iv7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i18 = ((384 >> 6) & 112) | 6;
            BoxScope $this$SwipeToDismissBox_u24lambda_u244 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1536817569, "C242@9523L105,251@9822L568,246@9637L763:SwipeToDismissBox.kt#uh7d8r");
            Modifier modifierMatchParentSize3 = $this$SwipeToDismissBox_u24lambda_u244.matchParentSize(Modifier.INSTANCE);
            int $changed$iv5 = ($dirty << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv5 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv8 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer2, (($changed$iv5 >> 3) & 14) | (($changed$iv5 >> 3) & 112));
            int $changed$iv$iv8 = ($changed$iv5 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv8 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer2, modifierMatchParentSize3);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor2;
                $composer2.createNode(function1);
            } else {
                function1 = constructor2;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash8);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
            int i19 = ($changed$iv$iv$iv8 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv5 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3_release6 = state.getAnchoredDraggableState$material3_release();
            Orientation orientation6 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart($composer2, 1536817868, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            if (($dirty & 7168) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean zChanged3 = z3 | $composer2.changed(isRtl);
            if ((57344 & $dirty) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z11 = zChanged3 | z4;
            if (($dirty & 14) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            invalid$iv = z11 | z5;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function2) new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue>>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<SwipeToDismissBoxValue>, ? extends SwipeToDismissBoxValue> invoke(IntSize intSize, Constraints constraints) {
                    return m2675invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-GpV2Q24, reason: not valid java name */
                public final Pair<DraggableAnchors<SwipeToDismissBoxValue>, SwipeToDismissBoxValue> m2675invokeGpV2Q24(long size, long j) {
                    final float width = IntSize.m6975getWidthimpl(size);
                    final boolean z12 = enableDismissFromStartToEnd2;
                    final boolean z13 = isRtl;
                    final boolean z14 = enableDismissFromEndToStart2;
                    return TuplesKt.m202to(AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$SwipeToDismissBox$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                            invoke2(draggableAnchorsConfig);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.Settled, 0.0f);
                            if (z12) {
                                draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.StartToEnd, z13 ? -width : width);
                            }
                            if (z14) {
                                draggableAnchorsConfig.m24at(SwipeToDismissBoxValue.EndToStart, z13 ? width : -width);
                            }
                        }
                    }), state.getTargetValue());
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierDraggableAnchors3 = AnchoredDraggableKt.draggableAnchors(companion3, anchoredDraggableState$material3_release6, orientation6, (Function2) value$iv);
            int $changed$iv6 = ($dirty >> 9) & 7168;
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv6 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv6 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv9 = RowKt.rowMeasurePolicy(horizontalArrangement$iv6, verticalAlignment$iv6, $composer2, (($changed$iv6 >> 3) & 14) | (($changed$iv6 >> 3) & 112));
            int $changed$iv$iv9 = ($changed$iv6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv9 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer2, modifierDraggableAnchors3);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor3;
                $composer2.createNode(function2);
            } else {
                function2 = constructor3;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                enableDismissFromStartToEnd3 = enableDismissFromStartToEnd2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                int i110 = ($changed$iv$iv$iv9 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv6 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                gesturesEnabled3 = gesturesEnabled6;
                enableDismissFromEndToStart3 = enableDismissFromEndToStart2;
            } else {
                enableDismissFromStartToEnd3 = enableDismissFromStartToEnd2;
            }
            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash9);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
            int i111 = ($changed$iv$iv$iv9 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            function4.invoke(RowScopeInstance.INSTANCE, $composer2, Integer.valueOf((($changed$iv6 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            gesturesEnabled3 = gesturesEnabled6;
            enableDismissFromEndToStart3 = enableDismissFromEndToStart2;
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z12 = enableDismissFromStartToEnd3;
            final boolean z13 = enableDismissFromEndToStart3;
            final boolean z14 = gesturesEnabled3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt.SwipeToDismissBox.2
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

                public final void invoke(Composer composer, int i112) {
                    SwipeToDismissBoxKt.SwipeToDismissBox(state, function3, modifier6, z12, z13, z14, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
