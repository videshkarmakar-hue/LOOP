package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.UriHandler;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.PointerIconCompat;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: SettingsPanel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001aI\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a/\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001b\u001a%\u0010\u001c\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010 \"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006!²\u0006\n\u0010\"\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002"}, m195d2 = {"HeaderShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "PressMillis", "", "RowShape", "TintMillis", "SettingsGroupDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SettingsNavRow", "title", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "selected", "", "onClick", "Lkotlin/Function0;", "badge", "Lcom/videshkarmakar/loop/ui/component/SettingsBadge;", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lcom/videshkarmakar/loop/ui/component/SettingsBadge;Landroidx/compose/runtime/Composer;II)V", "SettingsProfileHeader", "portraitUrl", "name", PreferenceUtilKt.SUBTITLE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SettingsSocialRow", "links", "", "Lcom/videshkarmakar/loop/ui/component/SettingsSocialLink;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_debug", "isPressed", "pressScale", "", "container", "Landroidx/compose/ui/graphics/Color;", "contentColor", "supportingColor"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SettingsPanelKt {
    private static final int PressMillis = 110;
    private static final int TintMillis = 180;
    private static final RoundedCornerShape RowShape = RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(12));
    private static final RoundedCornerShape HeaderShape = RoundedCornerShapeKt.getCircleShape();

    /* JADX WARN: Code duplicated, block: B:72:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:75:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:76:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:87:0x0487  */
    public static final void SettingsProfileHeader(final String portraitUrl, final String name, final String subtitle, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0<ComposeUiNode> function0;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> function1;
        Modifier modifier3;
        Composer $composer2;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        Intrinsics.checkNotNullParameter(portraitUrl, "portraitUrl");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Composer $composer3 = $composer.startRestartGroup(702213899);
        ComposerKt.sourceInformation($composer3, "C(SettingsProfileHeader)P(2,1,3)61@2510L1224:SettingsPanel.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(portraitUrl) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(name) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(subtitle) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 7168) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(702213899, $dirty2, -1, "com.videshkarmakar.loop.ui.component.SettingsProfileHeader (SettingsPanel.kt:60)");
            }
            Modifier modifier$iv = PaddingKt.m871paddingqDBjuR0(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), C1979Dp.m6801constructorimpl(20), C1979Dp.m6801constructorimpl(20), C1979Dp.m6801constructorimpl(20), C1979Dp.m6801constructorimpl(24));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
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
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                localMap$iv$iv = localMap$iv$iv2;
                function1 = function0;
            } else {
                localMap$iv$iv = localMap$iv$iv2;
                function1 = function0;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 775344668, "C72@2910L11,67@2721L267,76@2998L730:SettingsPanel.kt#g7nzpb");
                modifier3 = modifier4;
                $composer2 = $composer3;
                SingletonAsyncImageKt.m7151AsyncImage3HmZ8SU(portraitUrl, name, ClipKt.clip(BorderKt.m465borderxT4_qwU(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(52)), C1979Dp.m6801constructorimpl(2), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), HeaderShape), HeaderShape), null, null, null, null, 0.0f, null, 0, $composer3, ($dirty2 & 14) | ($dirty2 & 112), PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(14), 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i6 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1188072173, "C79@3136L10,81@3244L11,77@3063L296,85@3372L40,88@3502L10,89@3562L11,86@3425L293:SettingsPanel.kt#g7nzpb");
                TextKt.m2817Text4IGK_g(name, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, (($dirty2 >> 3) & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21, 3120, 55258);
                SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(2)), $composer3, 6);
                TextKt.m2817Text4IGK_g(subtitle, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, (($dirty2 >> 6) & 14) | 3072, 3120, 55282);
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 775344668, "C72@2910L11,67@2721L267,76@2998L730:SettingsPanel.kt#g7nzpb");
            modifier3 = modifier4;
            $composer2 = $composer3;
            SingletonAsyncImageKt.m7151AsyncImage3HmZ8SU(portraitUrl, name, ClipKt.clip(BorderKt.m465borderxT4_qwU(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(52)), C1979Dp.m6801constructorimpl(2), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), HeaderShape), HeaderShape), null, null, null, null, 0.0f, null, 0, $composer3, ($dirty2 & 14) | ($dirty2 & 112), PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(14), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i10 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1188072173, "C79@3136L10,81@3244L11,77@3063L296,85@3372L40,88@3502L10,89@3562L11,86@3425L293:SettingsPanel.kt#g7nzpb");
            TextKt.m2817Text4IGK_g(name, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, (($dirty2 >> 3) & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21, 3120, 55258);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(2)), $composer3, 6);
            TextKt.m2817Text4IGK_g(subtitle, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, (($dirty2 >> 6) & 14) | 3072, 3120, 55282);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt.SettingsProfileHeader.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i11) {
                    SettingsPanelKt.SettingsProfileHeader(portraitUrl, name, subtitle, modifier5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:138:0x04da  */
    /* JADX WARN: Code duplicated, block: B:142:0x0549  */
    /* JADX WARN: Code duplicated, block: B:144:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:147:0x05fd  */
    /* JADX WARN: Code duplicated, block: B:148:0x0601  */
    /* JADX WARN: Code duplicated, block: B:160:0x0741  */
    public static final void SettingsNavRow(final String title, final ImageVector icon, final boolean selected, final Function0<Unit> onClick, Modifier modifier, SettingsBadge badge, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SettingsBadge settingsBadge;
        SettingsBadge badge2;
        Object value$iv;
        long surface;
        long onSurface;
        long onSurfaceVariant;
        Object value$iv2;
        Object value$iv3;
        Alignment.Vertical verticalAlignment$iv;
        Function0<ComposeUiNode> function0;
        Modifier modifier3;
        FontWeight.Companion companion;
        FontWeight medium;
        Composer $composer2;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1669715992);
        ComposerKt.sourceInformation($composer3, "C(SettingsNavRow)P(5,1,4,3,2)119@4576L39,120@4655L25,122@4704L158,128@4885L332,138@5243L228,145@5500L257,156@5909L87,165@6187L13,152@5763L2121:SettingsPanel.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(icon) ? 32 : 16;
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
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            modifier2 = modifier;
        } else if ((57344 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            settingsBadge = badge;
        } else if ((458752 & $changed) == 0) {
            settingsBadge = badge;
            $dirty |= $composer3.changed(settingsBadge) ? 131072 : 65536;
        } else {
            settingsBadge = badge;
        }
        if ((374491 & $dirty) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            badge2 = settingsBadge;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            badge2 = i3 != 0 ? null : settingsBadge;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1669715992, $dirty, -1, "com.videshkarmakar.loop.ui.component.SettingsNavRow (SettingsPanel.kt:118)");
            }
            $composer3.startReplaceGroup(-1002988071);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsPanel.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv;
            $composer3.endReplaceGroup();
            State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, $composer3, 6);
            Modifier modifier5 = modifier4;
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(SettingsNavRow$lambda$3(stateCollectIsPressedAsState) ? 0.985f : 1.0f, AnimationSpecKt.tween$default(PressMillis, 0, null, 6, null), 0.0f, "settingsRowPress", null, $composer3, 3120, 20);
            if (selected) {
                $composer3.startReplaceGroup(-1002987662);
                ComposerKt.sourceInformation($composer3, "130@4973L11");
                surface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                $composer3.endReplaceGroup();
            } else if (SettingsNavRow$lambda$3(stateCollectIsPressedAsState)) {
                $composer3.startReplaceGroup(-1002987603);
                ComposerKt.sourceInformation($composer3, "131@5032L11");
                surface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerHigh();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1002987536);
                ComposerKt.sourceInformation($composer3, "132@5099L11");
                surface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface();
                $composer3.endReplaceGroup();
            }
            State<Color> stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(surface, AnimationSpecKt.tween$default(TintMillis, 0, null, 6, null), "settingsRowContainer", null, $composer3, 432, 8);
            if (selected) {
                $composer3.startReplaceGroup(-1002987321);
                ComposerKt.sourceInformation($composer3, "139@5314L11");
                onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimary();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1002987272);
                ComposerKt.sourceInformation($composer3, "140@5363L11");
                onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
                $composer3.endReplaceGroup();
            }
            State<Color> stateM351animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(onSurface, AnimationSpecKt.tween$default(TintMillis, 0, null, 6, null), "settingsRowContent", null, $composer3, 432, 8);
            if (selected) {
                $composer3.startReplaceGroup(-1002987054);
                ComposerKt.sourceInformation($composer3, "146@5571L11");
                long onPrimary = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimary();
                onSurfaceVariant = Color.m4289copywmQWz5c(onPrimary, (14 & 1) != 0 ? Color.m4293getAlphaimpl(onPrimary) : 0.7f, (14 & 2) != 0 ? Color.m4297getRedimpl(onPrimary) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(onPrimary) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(onPrimary) : 0.0f);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1002986996);
                ComposerKt.sourceInformation($composer3, "147@5639L11");
                onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant();
                $composer3.endReplaceGroup();
            }
            State<Color> stateM351animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(onSurfaceVariant, AnimationSpecKt.tween$default(TintMillis, 0, null, 6, null), "settingsRowSupporting", null, $composer3, 432, 8);
            Modifier modifierM869paddingVpY3zN4 = PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null), C1979Dp.m6801constructorimpl(20), C1979Dp.m6801constructorimpl(2));
            $composer3.startReplaceGroup(-1002986738);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsPanel.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(stateAnimateFloatAsState);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt$SettingsNavRow$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(SettingsPanelKt.SettingsNavRow$lambda$4(stateAnimateFloatAsState));
                        graphicsLayer.setScaleY(SettingsPanelKt.SettingsNavRow$lambda$4(stateAnimateFloatAsState));
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer3.endReplaceGroup();
            Modifier modifierM454backgroundbw27NRU$default = BackgroundKt.m454backgroundbw27NRU$default(ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM869paddingVpY3zN4, (Function1) value$iv2), RowShape), SettingsNavRow$lambda$5(stateM351animateColorAsStateeuL9pac), null, 2, null);
            $composer3.startReplaceGroup(-1002986460);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsPanel.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 7168) == 2048;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt$SettingsNavRow$2$1
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
                        onClick.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(ClickableKt.m484clickableO2vRcR0(modifierM454backgroundbw27NRU$default, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv3), C1979Dp.m6801constructorimpl(14), C1979Dp.m6801constructorimpl(13));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor2);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                verticalAlignment$iv = verticalAlignment$iv2;
                function0 = constructor2;
            } else {
                verticalAlignment$iv = verticalAlignment$iv2;
                function0 = constructor2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i5 = ((384 >> 6) & 112) | 6;
                RowScope $this$SettingsNavRow_u24lambda_u2412 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 78084438, "C169@6332L166,180@6687L10,175@6507L400:SettingsPanel.kt#g7nzpb");
                modifier3 = modifier5;
                IconKt.m2292Iconww6aTOc(icon, (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3), $composer3, (($dirty >> 3) & 14) | 432, 0);
                Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(RowScope.CC.weight$default($this$SettingsNavRow_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null), C1979Dp.m6801constructorimpl(14), 0.0f, C1979Dp.m6801constructorimpl(10), 0.0f, 10, null);
                TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium();
                companion = FontWeight.INSTANCE;
                if (selected) {
                    medium = companion.getSemiBold();
                } else {
                    medium = companion.getMedium();
                }
                $composer2 = $composer3;
                TextKt.m2817Text4IGK_g(title, modifierM872paddingqDBjuR0$default, SettingsNavRow$lambda$6(stateM351animateColorAsStateeuL9pac2), 0L, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium, $composer3, $dirty & 14, 3120, 55256);
                $composer3.startReplaceGroup(-1002985724);
                ComposerKt.sourceInformation($composer3, "*187@6946L922");
                if (badge2 != null) {
                    SettingsBadge b = badge2;
                    Modifier modifierClip = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(6)));
                    long jSettingsNavRow$lambda$7 = SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3);
                    Modifier modifierM869paddingVpY3zN5 = PaddingKt.m869paddingVpY3zN4(BackgroundKt.m454backgroundbw27NRU$default(modifierClip, Color.m4289copywmQWz5c(jSettingsNavRow$lambda$7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jSettingsNavRow$lambda$7) : 0.14f, (14 & 2) != 0 ? Color.m4297getRedimpl(jSettingsNavRow$lambda$7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jSettingsNavRow$lambda$7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jSettingsNavRow$lambda$7) : 0.0f), null, 2, null), C1979Dp.m6801constructorimpl(7), C1979Dp.m6801constructorimpl(3));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_4 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(4));
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM744spacedBy0680j_4, centerVertically, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv2 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifierM869paddingVpY3zN5);
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
                    $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    int i7 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1576315397, "C195@7337L208,203@7646L10,201@7562L292:SettingsPanel.kt#g7nzpb");
                    IconKt.m2292Iconww6aTOc(b.getIcon(), (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(11)), SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3), $composer3, 432, 0);
                    TextKt.m2817Text4IGK_g(b.getLabel(), (Modifier) null, SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 199680, 3072, 57298);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                $composer3.endReplaceGroup();
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i9 = ((384 >> 6) & 112) | 6;
            RowScope $this$SettingsNavRow_u24lambda_u2413 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 78084438, "C169@6332L166,180@6687L10,175@6507L400:SettingsPanel.kt#g7nzpb");
            modifier3 = modifier5;
            IconKt.m2292Iconww6aTOc(icon, (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3), $composer3, (($dirty >> 3) & 14) | 432, 0);
            Modifier modifierM872paddingqDBjuR0$default2 = PaddingKt.m872paddingqDBjuR0$default(RowScope.CC.weight$default($this$SettingsNavRow_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null), C1979Dp.m6801constructorimpl(14), 0.0f, C1979Dp.m6801constructorimpl(10), 0.0f, 10, null);
            TextStyle bodyMedium2 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium();
            companion = FontWeight.INSTANCE;
            if (selected) {
                medium = companion.getSemiBold();
            } else {
                medium = companion.getMedium();
            }
            $composer2 = $composer3;
            TextKt.m2817Text4IGK_g(title, modifierM872paddingqDBjuR0$default2, SettingsNavRow$lambda$6(stateM351animateColorAsStateeuL9pac2), 0L, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, bodyMedium2, $composer3, $dirty & 14, 3120, 55256);
            $composer3.startReplaceGroup(-1002985724);
            ComposerKt.sourceInformation($composer3, "*187@6946L922");
            if (badge2 != null) {
                SettingsBadge b2 = badge2;
                Modifier modifierClip2 = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(6)));
                long jSettingsNavRow$lambda$8 = SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3);
                Modifier modifierM869paddingVpY3zN6 = PaddingKt.m869paddingVpY3zN4(BackgroundKt.m454backgroundbw27NRU$default(modifierClip2, Color.m4289copywmQWz5c(jSettingsNavRow$lambda$8, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jSettingsNavRow$lambda$8) : 0.14f, (14 & 2) != 0 ? Color.m4297getRedimpl(jSettingsNavRow$lambda$8) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jSettingsNavRow$lambda$8) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jSettingsNavRow$lambda$8) : 0.0f), null, 2, null), C1979Dp.m6801constructorimpl(7), C1979Dp.m6801constructorimpl(3));
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_5 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(4));
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM744spacedBy0680j_5, centerVertically2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv3 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifierM869paddingVpY3zN6);
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                int i11 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1576315397, "C195@7337L208,203@7646L10,201@7562L292:SettingsPanel.kt#g7nzpb");
                IconKt.m2292Iconww6aTOc(b2.getIcon(), (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(11)), SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3), $composer3, 432, 0);
                TextKt.m2817Text4IGK_g(b2.getLabel(), (Modifier) null, SettingsNavRow$lambda$7(stateM351animateColorAsStateeuL9pac3), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 199680, 3072, 57298);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            $composer3.endReplaceGroup();
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
            final Modifier modifier6 = modifier3;
            final SettingsBadge settingsBadge2 = badge2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt.SettingsNavRow.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    SettingsPanelKt.SettingsNavRow(title, icon, selected, onClick, modifier6, settingsBadge2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean SettingsNavRow$lambda$3(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SettingsNavRow$lambda$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final long SettingsNavRow$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    private static final long SettingsNavRow$lambda$6(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    private static final long SettingsNavRow$lambda$7(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    public static final void SettingsGroupDivider(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-796550096);
        ComposerKt.sourceInformation($composer2, "C(SettingsGroupDivider)233@8488L11,228@8314L207:SettingsPanel.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-796550096, $dirty, -1, "com.videshkarmakar.loop.ui.component.SettingsGroupDivider (SettingsPanel.kt:227)");
            }
            BoxKt.Box(BackgroundKt.m454backgroundbw27NRU$default(SizeKt.m899height3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), C1979Dp.m6801constructorimpl(48), 0.0f, C1979Dp.m6801constructorimpl(20), 0.0f, 10, null), C1979Dp.m6801constructorimpl(1)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOutlineVariant(), null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt.SettingsGroupDivider.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    SettingsPanelKt.SettingsGroupDivider(modifier, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void SettingsSocialRow(final List<SettingsSocialLink> links, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier.Companion modifier2;
        Function0<ComposeUiNode> function0;
        Object value$iv;
        Object value$iv2;
        Function0<ComposeUiNode> function1;
        String str;
        Intrinsics.checkNotNullParameter(links, "links");
        Composer $composer2 = $composer.startRestartGroup(-2116655467);
        ComposerKt.sourceInformation($composer2, "C(SettingsSocialRow)248@8906L7,249@8918L1488:SettingsPanel.kt#g7nzpb");
        if ((i & 2) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2116655467, $changed, -1, "com.videshkarmakar.loop.ui.component.SettingsSocialRow (SettingsPanel.kt:247)");
        }
        ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer2.consume(localUriHandler);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        final UriHandler uriHandler = (UriHandler) objConsume;
        Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), C1979Dp.m6801constructorimpl(20), C1979Dp.m6801constructorimpl(4));
        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(10));
        int $changed$iv = 48;
        ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
        int $changed$iv$iv = (48 << 3) & 112;
        int $i$f$Layout = 0;
        String str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
        CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        String str3 = "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp";
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
        int i2 = ($changed$iv$iv$iv >> 6) & 14;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        int $changed2 = ((48 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer2, 1378676446, "C:SettingsPanel.kt#g7nzpb");
        $composer2.startReplaceGroup(-807909053);
        ComposerKt.sourceInformation($composer2, "*256@9174L39,257@9261L25,258@9317L184,267@9624L111,272@9821L11,264@9515L875");
        List<SettingsSocialLink> $this$forEach$iv = links;
        int $i$f$forEach = 0;
        for (Object element$iv : $this$forEach$iv) {
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            final SettingsSocialLink link = (SettingsSocialLink) element$iv;
            int $i$f$forEach2 = $i$f$forEach;
            $composer2.startReplaceGroup(1780034363);
            ComposerKt.sourceInformation($composer2, "CC(remember):SettingsPanel.kt#9igjgp");
            int $changed$iv2 = $changed$iv;
            Object it$iv = $composer2.rememberedValue();
            int i4 = i3;
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv;
            $composer2.endReplaceGroup();
            int $changed3 = $changed2;
            int $i$f$Layout2 = $i$f$Layout;
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(SettingsSocialRow$lambda$19$lambda$18$lambda$14(PressInteractionKt.collectIsPressedAsState(interactionSource, $composer2, 6)) ? 0.9f : 1.0f, AnimationSpecKt.tween$default(PressMillis, 0, null, 6, null), 0.0f, "socialPress", null, $composer2, 3120, 20);
            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(40));
            $composer2.startReplaceGroup(1780034813);
            ComposerKt.sourceInformation($composer2, "CC(remember):SettingsPanel.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(stateAnimateFloatAsState);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt$SettingsSocialRow$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(SettingsPanelKt.SettingsSocialRow$lambda$19$lambda$18$lambda$15(stateAnimateFloatAsState));
                        graphicsLayer.setScaleY(SettingsPanelKt.SettingsSocialRow$lambda$19$lambda$18$lambda$15(stateAnimateFloatAsState));
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv2 = ClickableKt.m484clickableO2vRcR0(BackgroundKt.m454backgroundbw27NRU$default(ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM913size3ABfNKs, (Function1) value$iv2), RoundedCornerShapeKt.getCircleShape()), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerHigh(), null, 2, null), interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt$SettingsSocialRow$1$1$2
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
                    uriHandler.openUri(link.getUrl());
                }
            });
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str2);
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            UriHandler uriHandler2 = uriHandler;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            String str4 = str2;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, str3);
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
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                str = str3;
            } else {
                str = str3;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1953448346, "C283@10330L11,279@10132L244:SettingsPanel.kt#g7nzpb");
                IconKt.m2292Iconww6aTOc(link.getIcon(), link.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), $composer2, 384, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $i$f$Layout = $i$f$Layout2;
                uriHandler = uriHandler2;
                $this$forEach$iv = $this$forEach$iv2;
                $i$f$forEach = $i$f$forEach2;
                $changed$iv = $changed$iv2;
                i3 = i4;
                str2 = str4;
                $changed2 = $changed3;
                str3 = str;
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1953448346, "C283@10330L11,279@10132L244:SettingsPanel.kt#g7nzpb");
            IconKt.m2292Iconww6aTOc(link.getIcon(), link.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), $composer2, 384, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $i$f$Layout = $i$f$Layout2;
            uriHandler = uriHandler2;
            $this$forEach$iv = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach2;
            $changed$iv = $changed$iv2;
            i3 = i4;
            str2 = str4;
            $changed2 = $changed3;
            str3 = str;
        }
        $composer2.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        $composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SettingsPanelKt.SettingsSocialRow.2
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
                    SettingsPanelKt.SettingsSocialRow(links, modifier2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean SettingsSocialRow$lambda$19$lambda$18$lambda$14(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SettingsSocialRow$lambda$19$lambda$18$lambda$15(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }
}
