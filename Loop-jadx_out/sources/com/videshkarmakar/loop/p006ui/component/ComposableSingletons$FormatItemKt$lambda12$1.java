package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: renamed from: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-12$1, reason: invalid class name */
/* JADX INFO: compiled from: FormatItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m195d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ComposableSingletons$FormatItemKt$lambda12$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$FormatItemKt$lambda12$1 INSTANCE = new ComposableSingletons$FormatItemKt$lambda12$1();

    ComposableSingletons$FormatItemKt$lambda12$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invoke$lambda$1(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformation($composer, "C459@16858L31,460@16906L465,460@16898L473:FormatItem.kt#g7nzpb");
        if (($changed & 11) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308099940, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-12.<anonymous> (FormatItem.kt:459)");
        }
        $composer.startReplaceGroup(1273433453);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatItem.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(-1, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState selected$delegate = (MutableState) value$iv;
        $composer.endReplaceGroup();
        SurfaceKt.m2666SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1148703575, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-12$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer2, int $changed2) {
                Function0<ComposeUiNode> function0;
                ComposerKt.sourceInformation($composer2, "C461@16920L441:FormatItem.kt#g7nzpb");
                if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1148703575, $changed2, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt.lambda-12.<anonymous>.<anonymous> (FormatItem.kt:461)");
                    }
                    final MutableState<Integer> mutableState = selected$delegate;
                    ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i2 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 722542549, "C467@17259L88,463@17024L323:FormatItem.kt#g7nzpb");
                    GridCells.Adaptive adaptive = new GridCells.Adaptive(C1979Dp.m6801constructorimpl(150), null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_4 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8));
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_5 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8));
                    $composer2.startReplaceGroup(722542784);
                    ComposerKt.sourceInformation($composer2, "CC(remember):FormatItem.kt#9igjgp");
                    Object value$iv2 = $composer2.rememberedValue();
                    if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<LazyGridScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-12$1$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyGridScope lazyGridScope) {
                                invoke2(lazyGridScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyGridScope LazyVerticalGrid) {
                                Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
                                int iInvoke$lambda$1 = ComposableSingletons$FormatItemKt$lambda12$1.invoke$lambda$1(mutableState);
                                final MutableState<Integer> mutableState2 = mutableState;
                                FormatItemKt.FormatPreviewContent(LazyVerticalGrid, iInvoke$lambda$1, new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$FormatItemKt$lambda-12$1$1$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int it) {
                                        ComposableSingletons$FormatItemKt$lambda12$1.invoke$lambda$2(mutableState2, it);
                                    }
                                });
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    $composer2.endReplaceGroup();
                    LazyGridDslKt.LazyVerticalGrid(adaptive, null, null, null, false, horizontalOrVerticalM744spacedBy0680j_4, horizontalOrVerticalM744spacedBy0680j_5, null, false, (Function1) value$iv2, $composer2, 807075840, HttpStatusCodesKt.HTTP_REQ_TOO_LONG);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }
        }, $composer, 54), $composer, 12582912, 127);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
