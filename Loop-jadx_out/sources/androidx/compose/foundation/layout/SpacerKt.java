package androidx.compose.foundation.layout;

import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Spacer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m195d2 = {"Spacer", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "foundation-layout_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SpacerKt {
    public static final void Spacer(Modifier modifier, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -72882467, "C(Spacer)39@1433L64:Spacer.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-72882467, $changed, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:38)");
        }
        SpacerMeasurePolicy spacerMeasurePolicy = SpacerMeasurePolicy.INSTANCE;
        int i = ($changed & 14) | 48;
        ComposerKt.sourceInformationMarkerStart($composer, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer, modifier);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart($composer, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(new Function0<ComposeUiNode>() { // from class: androidx.compose.foundation.layout.SpacerKt$Spacer$$inlined$Layout$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final ComposeUiNode invoke() {
                    return constructor.invoke();
                }
            });
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u241$iv = Updater.m3795constructorimpl($composer);
        Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, spacerMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if ($this$Layout_u24lambda_u241$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u241$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
            $this$Layout_u24lambda_u241$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
            $this$Layout_u24lambda_u241$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
        }
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }
}
