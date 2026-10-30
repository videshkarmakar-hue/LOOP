package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.focus.FocusRequester;
import androidx.compose.p001ui.focus.FocusRequesterModifierKt;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p001ui.input.pointer.PointerEventPass;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.LayoutCoordinatesKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.node.Ref;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0013X\u008a\u008e\u0002"}, m195d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release", "width", "menuHeight"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExposedDropdownMenu_androidKt {
    public static final void ExposedDropdownMenuBox(final boolean expanded, final Function1<? super Boolean, Unit> function1, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Modifier modifier3;
        Object value$iv7;
        Function0<ComposeUiNode> function0;
        Object value$iv8;
        Object value$iv9;
        Composer $composer2 = $composer.startRestartGroup(-617870381);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenuBox)P(1,3,2)96@4191L7,97@4224L7,98@4249L33,99@4305L33,101@4439L37,103@4494L488,116@5008L29,119@5086L289,130@5419L31,131@5476L38,118@5043L550,137@5610L59,137@5599L70,141@5698L418,141@5675L441:ExposedDropdownMenu.android.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617870381, $dirty2, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:95)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) objConsume;
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view = (View) objConsume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 60346360, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableIntState width$delegate = (MutableIntState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 60346416, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableIntState menuHeight$delegate = (MutableIntState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final int verticalMarginInPx = density.mo561roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            ComposerKt.sourceInformationMarkerStart($composer2, 60346550, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Ref();
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final Ref coordinates = (Ref) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int iExposedDropdownMenuBox$lambda$4 = ExposedDropdownMenuBox$lambda$4(menuHeight$delegate);
            int iExposedDropdownMenuBox$lambda$1 = ExposedDropdownMenuBox$lambda$1(width$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, 60346605, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(iExposedDropdownMenuBox$lambda$4) | $composer2.changed(density) | $composer2.changed(iExposedDropdownMenuBox$lambda$1);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier $this$exposedDropdownSize, boolean matchTextFieldWidth) {
                        Density $this$exposedDropdownSize_u24lambda_u241 = density;
                        MutableIntState mutableIntState = menuHeight$delegate;
                        MutableIntState mutableIntState2 = width$delegate;
                        Modifier it = SizeKt.m901heightInVpY3zN4$default($this$exposedDropdownSize, 0.0f, $this$exposedDropdownSize_u24lambda_u241.mo564toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4(mutableIntState)), 1, null);
                        if (matchTextFieldWidth) {
                            return SizeKt.m918width3ABfNKs(it, $this$exposedDropdownSize_u24lambda_u241.mo564toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1(mutableIntState2)));
                        }
                        return it;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 scope = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 60347119, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final FocusRequester focusRequester = (FocusRequester) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 60347197, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(coordinates) | $composer2.changedInstance(view) | $composer2.changed(verticalMarginInPx);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        width$delegate.setIntValue(IntSize.m6975getWidthimpl(it.mo5646getSizeYbymL2g()));
                        coordinates.setValue(it);
                        View rootView = view.getRootView();
                        LayoutCoordinates value = coordinates.getValue();
                        int i3 = verticalMarginInPx;
                        final MutableIntState mutableIntState = menuHeight$delegate;
                        ExposedDropdownMenu_androidKt.updateHeight(rootView, value, i3, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int newHeight) {
                                mutableIntState.setIntValue(newHeight);
                            }
                        });
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) value$iv6);
            ComposerKt.sourceInformationMarkerStart($composer2, 60347530, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            modifier3 = modifier4;
            boolean invalid$iv3 = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32);
            Object it$iv7 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        function1.invoke(Boolean.valueOf(!expanded));
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = FocusRequesterModifierKt.focusRequester(expandable(modifierOnGloballyPositioned, (Function0) value$iv7, Strings_androidKt.m1808getString4foXLRw(Strings.INSTANCE.m1804getExposedDropdownMenuUdPEhr4(), $composer2, 6)), focusRequester);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1560854724, "C134@5578L9:ExposedDropdownMenu.android.kt#jmzs0o");
            function3.invoke(scope, $composer2, Integer.valueOf(($dirty2 >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 60347721, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv4 = ($dirty2 & 14) == 4;
            Object it$iv8 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv8 = new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1
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
                        if (expanded) {
                            focusRequester.requestFocus();
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv8);
            } else {
                value$iv8 = it$iv8;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv8, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 60347809, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changedInstance(view) | $composer2.changedInstance(coordinates) | $composer2.changed(verticalMarginInPx);
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv9 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        View view2 = view;
                        final View view3 = view;
                        final Ref<LayoutCoordinates> ref = coordinates;
                        final int i5 = verticalMarginInPx;
                        final MutableIntState mutableIntState = menuHeight$delegate;
                        final OnGlobalLayoutListener listener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1$listener$1
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
                                View rootView = view3.getRootView();
                                LayoutCoordinates value = ref.getValue();
                                int i6 = i5;
                                final MutableIntState mutableIntState2 = mutableIntState;
                                ExposedDropdownMenu_androidKt.updateHeight(rootView, value, i6, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1$listener$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int newHeight) {
                                        mutableIntState2.setIntValue(newHeight);
                                    }
                                });
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                listener.dispose();
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv9);
            } else {
                value$iv9 = it$iv9;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(view, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv9, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox.6
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
                    ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(expanded, function1, modifier5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableIntState $width$delegate) {
        MutableIntState $this$getValue$iv = $width$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableIntState $menuHeight$delegate) {
        MutableIntState $this$getValue$iv = $menuHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1 */
    /* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1", m210f = "ExposedDropdownMenu.android.kt", m211i = {}, m212l = {520}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C10281 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onExpandedChange;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10281(Function0<Unit> function0, Continuation<? super C10281> continuation) {
            super(2, continuation);
            this.$onExpandedChange = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10281 c10281 = new C10281(this.$onExpandedChange, continuation);
            c10281.L$0 = obj;
            return c10281;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C10281) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1$1", m210f = "ExposedDropdownMenu.android.kt", m211i = {0}, m212l = {523, 524}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture"}, m215s = {"L$0"})
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $onExpandedChange;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onExpandedChange = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onExpandedChange, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:13:0x0050 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:14:0x0051  */
            /* JADX WARN: Code duplicated, block: B:17:0x0057  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                AwaitPointerEventScope $this$awaitEachGesture;
                Object objWaitForUpOrCancellation;
                PointerInputChange upEvent;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        $this$awaitEachGesture = (AwaitPointerEventScope) anonymousClass1.L$0;
                        anonymousClass1.L$0 = $this$awaitEachGesture;
                        anonymousClass1.label = 1;
                        if (TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture, false, PointerEventPass.Initial, anonymousClass1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$awaitEachGesture, PointerEventPass.Initial, anonymousClass1);
                        if (objWaitForUpOrCancellation == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objWaitForUpOrCancellation;
                        upEvent = (PointerInputChange) $result;
                        if (upEvent != null) {
                            anonymousClass1.$onExpandedChange.invoke();
                        }
                        return Unit.INSTANCE;
                    case 1:
                        anonymousClass1 = this;
                        $this$awaitEachGesture = (AwaitPointerEventScope) anonymousClass1.L$0;
                        ResultKt.throwOnFailure($result);
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                        objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$awaitEachGesture, PointerEventPass.Initial, anonymousClass1);
                        if (objWaitForUpOrCancellation == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objWaitForUpOrCancellation;
                        upEvent = (PointerInputChange) $result;
                        if (upEvent != null) {
                            anonymousClass1.$onExpandedChange.invoke();
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        upEvent = (PointerInputChange) $result;
                        if (upEvent != null) {
                            anonymousClass1.$onExpandedChange.invoke();
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture($this$pointerInput, new AnonymousClass1(this.$onExpandedChange, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private static final Modifier expandable(Modifier $this$expandable, final Function0<Unit> function0, final String menuLabel) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput($this$expandable, function0, new C10281(function0, null)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt.expandable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                SemanticsPropertiesKt.setContentDescription($this$semantics, menuLabel);
                final Function0<Unit> function1 = function0;
                SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt.expandable.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        function1.invoke();
                        return true;
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1<? super Integer, Unit> function1) {
        if (coordinates == null) {
            return;
        }
        Rect it = new Rect();
        view.getWindowVisibleDisplayFrame(it);
        float heightAbove = LayoutCoordinatesKt.boundsInWindow(coordinates).getTop() - it.top;
        float heightBelow = (it.bottom - it.top) - LayoutCoordinatesKt.boundsInWindow(coordinates).getBottom();
        function1.invoke(Integer.valueOf(((int) Math.max(heightAbove, heightBelow)) - verticalMarginInPx));
    }
}
