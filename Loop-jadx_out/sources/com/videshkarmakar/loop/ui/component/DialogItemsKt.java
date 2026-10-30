package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: DialogItems.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001a5\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a?\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0018²\u0006\n\u0010\u0014\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"CheckBoxItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "checked", "", "onValueChange", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "DialogSingleChoiceItem", "selected", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DialogSingleChoiceItemWithLabel", "label", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DialogSwitchItem", DownloadUtil.CookieScheme.VALUE, "SingleChoiceItemPreview", "(Landroidx/compose/runtime/Composer;I)V", "SwitchItemPrev", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DialogItemsKt {
    public static final void DialogSingleChoiceItem(Modifier modifier, final String text, final boolean selected, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-656412227);
        ComposerKt.sourceInformation($composer3, "C(DialogSingleChoiceItem)P(!1,3,2)43@1714L652:DialogItems.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(selected) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onClick) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-656412227, $dirty2, -1, "com.videshkarmakar.loop.ui.component.DialogSingleChoiceItem (DialogItems.kt:42)");
            }
            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(SelectableKt.m869selectableXHw0xAI$default(modifier3, selected, true, null, onClick, 4, null), 0.0f, 1, null), Dp.m6553constructorimpl(12), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(start, centerVertically, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierM622paddingVpY3zN4$default);
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 908261778, "C55@2082L197,62@2329L7,62@2288L72:DialogItems.kt#g7nzpb");
            RadioButtonKt.RadioButton(selected, onClick, SemanticsModifierKt.clearAndSetSemantics(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$DialogSingleChoiceItem$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }
            }), false, null, null, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 112), 56);
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextStyle textStyle = (TextStyle) objConsume;
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle.m6029copyp1EtxEg((16777213 & 1) != 0 ? textStyle.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyle.spanStyle.getFontSize() : TextUnitKt.getSp(16), (16777213 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyle.platformStyle : null, (16777213 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null), $composer3, ($dirty2 >> 3) & 14, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt.DialogSingleChoiceItem.2
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
                    DialogItemsKt.DialogSingleChoiceItem(modifier4, text, selected, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void SingleChoiceItemPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1638931825);
        ComposerKt.sourceInformation($composer2, "C(SingleChoiceItemPreview)69@2427L483:DialogItems.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1638931825, $changed, -1, "com.videshkarmakar.loop.ui.component.SingleChoiceItemPreview (DialogItems.kt:68)");
            }
            SurfaceKt.m2418SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableSingletons$DialogItemsKt.INSTANCE.m7109getLambda1$app_debug(), $composer2, 12582912, 127);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt.SingleChoiceItemPreview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DialogItemsKt.SingleChoiceItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0453  */
    /* JADX WARN: Code duplicated, block: B:97:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:98:0x03d7  */
    public static final void DialogSingleChoiceItemWithLabel(Modifier modifier, final String text, final String label, final boolean selected, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer2;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer4 = $composer.startRestartGroup(1541287856);
        ComposerKt.sourceInformation($composer4, "C(DialogSingleChoiceItemWithLabel)P(1,4!1,3)98@3092L943:DialogItems.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer4.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer4.changed(label) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer4.changed(selected) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(onClick) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) == 9362 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer4;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1541287856, $dirty2, -1, "com.videshkarmakar.loop.ui.component.DialogSingleChoiceItemWithLabel (DialogItems.kt:97)");
            }
            Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SelectableKt.m869selectableXHw0xAI$default(modifier3, selected, true, null, onClick, 4, null), 0.0f, 1, null), Dp.m6553constructorimpl(8), 0.0f, Dp.m6553constructorimpl(16), 0.0f, 10, null), 0.0f, Dp.m6553constructorimpl(8), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(start, centerVertically, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifierM622paddingVpY3zN4$default);
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
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 919800437, "C111@3505L197,118@3711L318:DialogItems.kt#g7nzpb");
            RadioButtonKt.RadioButton(selected, onClick, SemanticsModifierKt.clearAndSetSemantics(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$DialogSingleChoiceItemWithLabel$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }
            }), false, null, null, $composer4, (($dirty2 >> 9) & 14) | (($dirty2 >> 9) & 112), 56);
            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(constructor2);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                localMap$iv$iv = localMap$iv$iv3;
            } else {
                localMap$iv$iv = localMap$iv$iv3;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -612300935, "C119@3772L10,119@3732L61:DialogItems.kt#g7nzpb");
                $composer2 = $composer4;
                TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, ($dirty2 >> 3) & 14, 0, 65534);
                $composer4.startReplaceGroup(919800745);
                ComposerKt.sourceInformation($composer4, "*123@3914L10,121@3835L170");
                if (label == null) {
                    $composer3 = $composer4;
                } else {
                    $composer3 = $composer4;
                    TextKt.m2569Text4IGK_g(label, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelMedium(), $composer3, 48, 0, 65532);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -612300935, "C119@3772L10,119@3732L61:DialogItems.kt#g7nzpb");
            $composer2 = $composer4;
            TextKt.m2569Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, ($dirty2 >> 3) & 14, 0, 65534);
            $composer4.startReplaceGroup(919800745);
            ComposerKt.sourceInformation($composer4, "*123@3914L10,121@3835L170");
            if (label == null) {
                $composer3 = $composer4;
            } else {
                $composer3 = $composer4;
                TextKt.m2569Text4IGK_g(label, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelMedium(), $composer3, 48, 0, 65532);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt.DialogSingleChoiceItemWithLabel.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    DialogItemsKt.DialogSingleChoiceItemWithLabel(modifier4, text, label, selected, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0253  */
    /* JADX WARN: Code duplicated, block: B:76:0x025f  */
    /* JADX WARN: Code duplicated, block: B:77:0x0263  */
    /* JADX WARN: Code duplicated, block: B:80:0x0291  */
    /* JADX WARN: Code duplicated, block: B:83:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:84:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:88:0x03b9  */
    public static final void CheckBoxItem(Modifier modifier, final String text, final boolean checked, final Function1<? super Boolean, Unit> onValueChange, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        MeasurePolicy measurePolicy$iv;
        MeasurePolicy measurePolicy$iv2;
        int compositeKeyHash$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> constructor;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        CompositionLocalMap localMap$iv$iv2;
        MeasurePolicy measurePolicy$iv3;
        Modifier modifier3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(626576176);
        ComposerKt.sourceInformation($composer3, "C(CheckBoxItem)P(1,3)138@4190L635:DialogItems.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(checked) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626576176, $dirty2, -1, "com.videshkarmakar.loop.ui.component.CheckBoxItem (DialogItems.kt:137)");
            }
            Modifier modifier$iv = ToggleableKt.m874toggleableXHw0xAI$default(SizeKt.fillMaxWidth$default(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 0.0f, 0.0f, 13, null), 0.0f, 1, null), checked, true, null, onValueChange, 4, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor2;
                $composer3.createNode(function0);
            } else {
                function0 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                function1 = function0;
                measurePolicy$iv = measurePolicy$iv4;
            } else {
                function1 = function0;
                measurePolicy$iv = measurePolicy$iv4;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -509384062, "C146@4420L398:DialogItems.kt#g7nzpb");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                int $changed$iv = ($dirty2 & 14) | 384;
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                int $changed$iv$iv2 = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    localMap$iv$iv2 = localMap$iv$iv;
                    measurePolicy$iv3 = measurePolicy$iv2;
                } else {
                    localMap$iv$iv2 = localMap$iv$iv;
                    measurePolicy$iv3 = measurePolicy$iv2;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    int i6 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1894219760, "C149@4529L153,154@4773L10,153@4695L113:DialogItems.kt#g7nzpb");
                    CheckboxKt.Checkbox(checked, onValueChange, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$CheckBoxItem$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }
                    }), false, null, null, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 112), 56);
                    modifier3 = modifier4;
                    $composer2 = $composer3;
                    TextKt.m2569Text4IGK_g(text, (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, (($dirty2 >> 3) & 14) | 48, 0, 65532);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                int i8 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1894219760, "C149@4529L153,154@4773L10,153@4695L113:DialogItems.kt#g7nzpb");
                CheckboxKt.Checkbox(checked, onValueChange, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$CheckBoxItem$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                    }
                }), false, null, null, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 112), 56);
                modifier3 = modifier4;
                $composer2 = $composer3;
                TextKt.m2569Text4IGK_g(text, (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, (($dirty2 >> 3) & 14) | 48, 0, 65532);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -509384062, "C146@4420L398:DialogItems.kt#g7nzpb");
            Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
            int $changed$iv2 = ($dirty2 & 14) | 384;
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
            int $changed$iv$iv3 = ($changed$iv2 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv2 = localMap$iv$iv;
                measurePolicy$iv3 = measurePolicy$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                int i12 = (($changed$iv2 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1894219760, "C149@4529L153,154@4773L10,153@4695L113:DialogItems.kt#g7nzpb");
                CheckboxKt.Checkbox(checked, onValueChange, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$CheckBoxItem$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                    }
                }), false, null, null, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 112), 56);
                modifier3 = modifier4;
                $composer2 = $composer3;
                TextKt.m2569Text4IGK_g(text, (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, (($dirty2 >> 3) & 14) | 48, 0, 65532);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                localMap$iv$iv2 = localMap$iv$iv;
                measurePolicy$iv3 = measurePolicy$iv2;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i13 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
            int i14 = (($changed$iv2 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1894219760, "C149@4529L153,154@4773L10,153@4695L113:DialogItems.kt#g7nzpb");
            CheckboxKt.Checkbox(checked, onValueChange, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$CheckBoxItem$1$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }
            }), false, null, null, $composer3, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 112), 56);
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, (($dirty2 >> 3) & 14) | 48, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt.CheckBoxItem.2
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

                public final void invoke(Composer composer, int i15) {
                    DialogItemsKt.CheckBoxItem(modifier5, text, checked, onValueChange, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x026a  */
    /* JADX WARN: Code duplicated, block: B:73:0x026c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0284  */
    /* JADX WARN: Code duplicated, block: B:82:0x0289  */
    /* JADX WARN: Code duplicated, block: B:87:0x030c  */
    public static final void DialogSwitchItem(Modifier modifier, final String text, final boolean value, final Function1<? super Boolean, Unit> onValueChange, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0<ComposeUiNode> function0;
        CompositionLocalMap localMap$iv$iv;
        Modifier modifier3;
        Composer $composer2;
        boolean z;
        boolean invalid$iv;
        final boolean z2;
        Object value$iv;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(637154857);
        ComposerKt.sourceInformation($composer3, "C(DialogSwitchItem)P(!1,2,3)168@4981L1293:DialogItems.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(value) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(637154857, $dirty2, -1, "com.videshkarmakar.loop.ui.component.DialogSwitchItem (DialogItems.kt:167)");
            }
            Function2<Composer, Integer, Unit> function2M7110getLambda2$app_debug = null;
            Modifier modifier$iv = PaddingKt.m621paddingVpY3zN4(ToggleableKt.m874toggleableXHw0xAI$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), value, false, null, onValueChange, 6, null), Dp.m6553constructorimpl(24), Dp.m6553constructorimpl(8));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv = localMap$iv$iv2;
            } else {
                localMap$iv$iv = localMap$iv$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i4 = ((384 >> 6) & 112) | 6;
                RowScope $this$DialogSwitchItem_u24lambda_u247 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1942313377, "C177@5307L10,175@5242L140,180@5437L377,194@5851L7,200@6034L233,195@5867L400:DialogItems.kt#g7nzpb");
                modifier3 = modifier4;
                $composer2 = $composer3;
                TextKt.m2569Text4IGK_g(text, RowScope.CC.weight$default($this$DialogSwitchItem_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer3, ($dirty2 >> 3) & 14, 0, 65532);
                $composer3.startReplaceGroup(-1942313182);
                ComposerKt.sourceInformation($composer3, "CC(remember):DialogItems.kt#9igjgp");
                if (($dirty2 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv = z;
                Object it$iv = $composer3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    z2 = value;
                    if (z2) {
                        function2M7110getLambda2$app_debug = ComposableSingletons$DialogItemsKt.INSTANCE.m7110getLambda2$app_debug();
                    }
                    value$iv = function2M7110getLambda2$app_debug;
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    z2 = value;
                    value$iv = it$iv;
                }
                final Function2 thumbContent = (Function2) value$iv;
                $composer3.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density = (Density) objConsume;
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalDensity().provides(DensityKt.Density(density.getDensity() * 0.8f, density.getFontScale())), ComposableLambdaKt.rememberComposableLambda(-1917983611, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$DialogSwitchItem$1$1
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
                        ComposerKt.sourceInformation($composer4, "C201@6048L209:DialogItems.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1917983611, $changed2, -1, "com.videshkarmakar.loop.ui.component.DialogSwitchItem.<anonymous>.<anonymous> (DialogItems.kt:201)");
                            }
                            SwitchKt.Switch(z2, onValueChange, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$DialogSwitchItem$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                }
                            }), thumbContent, false, null, null, $composer4, 0, 112);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$DialogSwitchItem_u24lambda_u248 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1942313377, "C177@5307L10,175@5242L140,180@5437L377,194@5851L7,200@6034L233,195@5867L400:DialogItems.kt#g7nzpb");
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, RowScope.CC.weight$default($this$DialogSwitchItem_u24lambda_u248, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer3, ($dirty2 >> 3) & 14, 0, 65532);
            $composer3.startReplaceGroup(-1942313182);
            ComposerKt.sourceInformation($composer3, "CC(remember):DialogItems.kt#9igjgp");
            if (($dirty2 & 896) == 256) {
                z = true;
            } else {
                z = false;
            }
            invalid$iv = z;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
                z2 = value;
                if (z2) {
                    function2M7110getLambda2$app_debug = ComposableSingletons$DialogItemsKt.INSTANCE.m7110getLambda2$app_debug();
                }
                value$iv = function2M7110getLambda2$app_debug;
                $composer3.updateRememberedValue(value$iv);
            } else {
                z2 = value;
                if (z2) {
                    function2M7110getLambda2$app_debug = ComposableSingletons$DialogItemsKt.INSTANCE.m7110getLambda2$app_debug();
                }
                value$iv = function2M7110getLambda2$app_debug;
                $composer3.updateRememberedValue(value$iv);
            }
            final Function2<? super Composer, ? super Integer, Unit> thumbContent2 = (Function2) value$iv;
            $composer3.endReplaceGroup();
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density2 = (Density) objConsume2;
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalDensity().provides(DensityKt.Density(density2.getDensity() * 0.8f, density2.getFontScale())), ComposableLambdaKt.rememberComposableLambda(-1917983611, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$DialogSwitchItem$1$1
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
                    ComposerKt.sourceInformation($composer4, "C201@6048L209:DialogItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1917983611, $changed2, -1, "com.videshkarmakar.loop.ui.component.DialogSwitchItem.<anonymous>.<anonymous> (DialogItems.kt:201)");
                        }
                        SwitchKt.Switch(z2, onValueChange, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$DialogSwitchItem$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                            }
                        }), thumbContent2, false, null, null, $composer4, 0, 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt.DialogSwitchItem.2
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

                public final void invoke(Composer composer, int i7) {
                    DialogItemsKt.DialogSwitchItem(modifier5, text, value, onValueChange, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchItemPrev(Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1789196261);
        ComposerKt.sourceInformation($composer2, "C(SwitchItemPrev)215@6347L34,216@6394L104,216@6386L112:DialogItems.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1789196261, $changed, -1, "com.videshkarmakar.loop.ui.component.SwitchItemPrev (DialogItems.kt:214)");
            }
            $composer2.startReplaceGroup(169230660);
            ComposerKt.sourceInformation($composer2, "CC(remember):DialogItems.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState value$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            SurfaceKt.m2418SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-13924736, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt.SwitchItemPrev.1
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C217@6458L34,217@6404L88:DialogItems.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-13924736, $changed2, -1, "com.videshkarmakar.loop.ui.component.SwitchItemPrev.<anonymous> (DialogItems.kt:217)");
                    }
                    boolean zSwitchItemPrev$lambda$9 = DialogItemsKt.SwitchItemPrev$lambda$9(value$delegate);
                    $composer3.startReplaceGroup(-2030086572);
                    ComposerKt.sourceInformation($composer3, "CC(remember):DialogItems.kt#9igjgp");
                    final MutableState<Boolean> mutableState = value$delegate;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt$SwitchItemPrev$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean it) {
                                DialogItemsKt.SwitchItemPrev$lambda$10(mutableState, it);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    DialogItemsKt.DialogSwitchItem(null, "Use cookies", zSwitchItemPrev$lambda$9, (Function1) value$iv2, $composer3, 3120, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 12582912, 127);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DialogItemsKt.SwitchItemPrev.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DialogItemsKt.SwitchItemPrev(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchItemPrev$lambda$10(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SwitchItemPrev$lambda$9(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }
}
