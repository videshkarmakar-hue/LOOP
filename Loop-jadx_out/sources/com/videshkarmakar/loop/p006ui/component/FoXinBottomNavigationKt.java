package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.material.icons.filled.ReportKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.draw.ShadowKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.p006ui.theme.Neu;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FoXinBottomNavigation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0002X\u008a\u0084\u0002"}, m195d2 = {"PressSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "bottomNavItems", "", "Lcom/videshkarmakar/loop/ui/component/BottomNavItem;", "getBottomNavItems", "()Ljava/util/List;", "LoopBottomNavigation", "", "onNavigate", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_debug", "isPressed", "", "pressScale"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FoXinBottomNavigationKt {
    private static final List<BottomNavItem> bottomNavItems = CollectionsKt.listOf((Object[]) new BottomNavItem[]{new BottomNavItem(Route.HOME, "Home", HomeKt.getHome(Icons.Filled.INSTANCE)), new BottomNavItem(Route.CREATOR, "Creator", PersonKt.getPerson(Icons.Filled.INSTANCE)), new BottomNavItem(Route.REPORT_FEEDBACK, "Report", ReportKt.getReport(Icons.Filled.INSTANCE)), new BottomNavItem(Route.SETTINGS, "Settings", SettingsKt.getSettings(Icons.Filled.INSTANCE))});
    private static final TweenSpec<Float> PressSpec = AnimationSpecKt.tween$default(110, 0, null, 6, null);

    public static final List<BottomNavItem> getBottomNavItems() {
        return bottomNavItems;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0522  */
    /* JADX WARN: Code duplicated, block: B:101:0x0528  */
    /* JADX WARN: Code duplicated, block: B:104:0x0559  */
    /* JADX WARN: Code duplicated, block: B:107:0x056c  */
    /* JADX WARN: Code duplicated, block: B:108:0x056f  */
    /* JADX WARN: Code duplicated, block: B:113:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:52:0x029d  */
    /* JADX WARN: Code duplicated, block: B:55:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:56:0x02af  */
    /* JADX WARN: Code duplicated, block: B:59:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:62:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:63:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:68:0x035f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0390  */
    /* JADX WARN: Code duplicated, block: B:71:0x039f  */
    /* JADX WARN: Code duplicated, block: B:74:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:75:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:78:0x0419  */
    /* JADX WARN: Code duplicated, block: B:79:0x041b  */
    /* JADX WARN: Code duplicated, block: B:82:0x042c  */
    /* JADX WARN: Code duplicated, block: B:85:0x0437  */
    /* JADX WARN: Code duplicated, block: B:86:0x0439  */
    /* JADX WARN: Code duplicated, block: B:90:0x048e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0499  */
    /* JADX WARN: Code duplicated, block: B:97:0x0516  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void LoopBottomNavigation(final Function1<? super String, Unit> onNavigate, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0<ComposeUiNode> function0;
        MeasurePolicy measurePolicy$iv;
        Composer $composer2;
        Modifier materialized$iv$iv;
        MeasurePolicy measurePolicy$iv2;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> function1;
        Modifier materialized$iv$iv2;
        Function0<ComposeUiNode> constructor;
        Arrangement.Horizontal horizontalArrangement$iv;
        Function0<ComposeUiNode> function2;
        Function0<ComposeUiNode> function3;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        boolean propagateMinConstraints$iv;
        MeasurePolicy measurePolicy$iv3;
        int $changed$iv;
        Composer $composer$iv;
        RowScope $this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247;
        Composer $composer3;
        Iterable $this$forEach$iv;
        Composer $this$cache$iv;
        Object it$iv;
        Object value$iv;
        MutableInteractionSource interactionSource;
        float f;
        final State<Float> stateAnimateFloatAsState;
        boolean z;
        boolean invalid$iv;
        Object it$iv2;
        int $dirty;
        Object value$iv2;
        boolean invalid$iv2;
        Composer $this$cache$iv2;
        Object value$iv3;
        int compositeKeyHash$iv$iv2;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> function4;
        Composer $this$Layout_u24lambda_u240$iv$iv2;
        String str;
        Intrinsics.checkNotNullParameter(onNavigate, "onNavigate");
        Composer $composer4 = $composer.startRestartGroup(-855472821);
        ComposerKt.sourceInformation($composer4, "C(LoopBottomNavigation)P(1)71@3128L11,86@3632L11,73@3162L2654:FoXinBottomNavigation.kt#g7nzpb");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer4.changedInstance(onNavigate) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($dirty2 & 91) == 18 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-855472821, $dirty2, -1, "com.videshkarmakar.loop.ui.component.LoopBottomNavigation (FoXinBottomNavigation.kt:70)");
            }
            long contentColor = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant();
            Modifier modifierClip = ClipKt.clip(ShadowKt.m3954shadows4CzXII$default(SizeKt.m899height3ABfNKs(PaddingKt.m869paddingVpY3zN4(WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null)), C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(12)), C1979Dp.m6801constructorimpl(64)), C1979Dp.m6801constructorimpl(10), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(32)), false, Neu.INSTANCE.m7655getShadow0d7_KjU(), Neu.INSTANCE.m7655getShadow0d7_KjU(), 4, null), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(32)));
            long surface = MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurface();
            Modifier modifierM454backgroundbw27NRU$default = BackgroundKt.m454backgroundbw27NRU$default(modifierClip, Color.m4289copywmQWz5c(surface, (14 & 1) != 0 ? Color.m4293getAlphaimpl(surface) : 0.94f, (14 & 2) != 0 ? Color.m4297getRedimpl(surface) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(surface) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(surface) : 0.0f), null, 2, null);
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            Modifier modifier$iv = modifierM454backgroundbw27NRU$default;
            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            String str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str3 = "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                function0 = constructor3;
                $composer4.createNode(function0);
            } else {
                function0 = constructor3;
                $composer4.useNode();
            }
            Modifier modifier4 = modifier3;
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer4);
            Alignment contentAlignment$iv2 = contentAlignment$iv;
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                measurePolicy$iv = measurePolicy$iv4;
            } else {
                measurePolicy$iv = measurePolicy$iv4;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                $composer2 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer2, 861733351, "C89@3734L2076:FoXinBottomNavigation.kt#g7nzpb");
                materialized$iv$iv = materialized$iv$iv3;
                Modifier modifier$iv2 = SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(64));
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv2 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                function1 = function0;
                materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                horizontalArrangement$iv = horizontalArrangement$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function2 = constructor;
                    $composer2.createNode(function2);
                } else {
                    function2 = constructor;
                    $composer2.useNode();
                }
                function3 = function2;
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
                propagateMinConstraints$iv = false;
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    measurePolicy$iv3 = measurePolicy$iv2;
                } else {
                    measurePolicy$iv3 = measurePolicy$iv2;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    $changed$iv = ($changed$iv$iv$iv2 >> 6) & 14;
                    $composer$iv = $composer2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i5 = ((390 >> 6) & 112) | 6;
                    $this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247 = RowScopeInstance.INSTANCE;
                    $composer3 = $composer$iv;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1728801984, "C:FoXinBottomNavigation.kt#g7nzpb");
                    $composer3.startReplaceGroup(861733550);
                    ComposerKt.sourceInformation($composer3, "*96@3991L39,97@4082L25,98@4142L188,111@4664L26,115@4964L123,104@4348L1438");
                    $this$forEach$iv = bottomNavItems;
                    for (Object element$iv : $this$forEach$iv) {
                        final BottomNavItem item = (BottomNavItem) element$iv;
                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                        $composer3.startReplaceGroup(136002218);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                        $this$cache$iv = $composer3;
                        int $changed$iv2 = $changed$iv;
                        it$iv = $this$cache$iv.rememberedValue();
                        Composer $composer5 = $composer2;
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = InteractionSourceKt.MutableInteractionSource();
                            $this$cache$iv.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        interactionSource = (MutableInteractionSource) value$iv;
                        $composer3.endReplaceGroup();
                        Composer $composer$iv2 = $composer$iv;
                        if (LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$1(PressInteractionKt.collectIsPressedAsState(interactionSource, $composer3, 6))) {
                            f = 0.9f;
                        } else {
                            f = 1.0f;
                        }
                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, PressSpec, 0.0f, "navPress", null, $composer3, 3120, 20);
                        Modifier modifier$iv3 = modifier$iv;
                        Modifier materialized$iv$iv4 = materialized$iv$iv2;
                        Modifier modifierClip2 = ClipKt.clip(RowScope.CC.weight$default($this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(18)));
                        $composer3.startReplaceGroup(136002891);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                        if (($dirty2 & 14) == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        invalid$iv = z | $composer4.changed(item);
                        Composer $this$cache$iv3 = $composer3;
                        it$iv2 = $this$cache$iv3.rememberedValue();
                        if (invalid$iv) {
                            $dirty = $dirty2;
                        } else {
                            $dirty = $dirty2;
                            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = it$iv2;
                            }
                            $composer3.endReplaceGroup();
                            Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip2, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                            $composer3.startReplaceGroup(136003191);
                            ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                            invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                            $this$cache$iv2 = $composer3;
                            Object it$iv3 = $this$cache$iv2.rememberedValue();
                            if (!invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                        graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                        graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                    }
                                };
                                $this$cache$iv2.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv3;
                            }
                            $composer3.endReplaceGroup();
                            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default, (Function1) value$iv3);
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(center, centerHorizontally, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                            int $changed$iv$iv3 = (432 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                function4 = constructor2;
                                $composer3.createNode(function4);
                            } else {
                                function4 = constructor2;
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                                str = str2;
                            } else {
                                str = str2;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                                Composer $composer$iv3 = $composer3;
                                ComposerKt.sourceInformationMarkerStart($composer$iv3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int i7 = ((432 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer$iv3, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                                Composer $composer6 = $composer3;
                                IconKt.m2292Iconww6aTOc(item.getIcon(), item.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv3, 384, 0);
                                TextKt.m2817Text4IGK_g(item.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv3, 199680, 3072, 122834);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                $composer6.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                measurePolicy$iv = measurePolicy$iv;
                                function1 = function1;
                                $dirty2 = $dirty;
                                $this$forEach$iv = $this$forEach$iv2;
                                $changed$iv = $changed$iv2;
                                contentAlignment$iv2 = contentAlignment$iv2;
                                str2 = str;
                                materialized$iv$iv = materialized$iv$iv;
                                measurePolicy$iv3 = measurePolicy$iv3;
                                horizontalArrangement$iv = horizontalArrangement$iv;
                                function3 = function3;
                                $composer3 = $composer6;
                                propagateMinConstraints$iv = propagateMinConstraints$iv;
                                $composer2 = $composer5;
                                $composer$iv = $composer$iv2;
                                modifier$iv = modifier$iv3;
                                str3 = str3;
                                materialized$iv$iv2 = materialized$iv$iv4;
                            }
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                            Composer $composer$iv4 = $composer3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i9 = ((432 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv4, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                            Composer $composer7 = $composer3;
                            IconKt.m2292Iconww6aTOc(item.getIcon(), item.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv4, 384, 0);
                            TextKt.m2817Text4IGK_g(item.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv4, 199680, 3072, 122834);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                            $composer7.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            measurePolicy$iv = measurePolicy$iv;
                            function1 = function1;
                            $dirty2 = $dirty;
                            $this$forEach$iv = $this$forEach$iv2;
                            $changed$iv = $changed$iv2;
                            contentAlignment$iv2 = contentAlignment$iv2;
                            str2 = str;
                            materialized$iv$iv = materialized$iv$iv;
                            measurePolicy$iv3 = measurePolicy$iv3;
                            horizontalArrangement$iv = horizontalArrangement$iv;
                            function3 = function3;
                            $composer3 = $composer7;
                            propagateMinConstraints$iv = propagateMinConstraints$iv;
                            $composer2 = $composer5;
                            $composer$iv = $composer$iv2;
                            modifier$iv = modifier$iv3;
                            str3 = str3;
                            materialized$iv$iv2 = materialized$iv$iv4;
                        }
                        value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$1$1
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
                                onNavigate.invoke(item.getRoute());
                            }
                        };
                        $this$cache$iv3.updateRememberedValue(value$iv2);
                        $composer3.endReplaceGroup();
                        Modifier modifierM870paddingVpY3zN4$default2 = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip2, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                        $composer3.startReplaceGroup(136003191);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                        invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                        $this$cache$iv2 = $composer3;
                        Object it$iv4 = $this$cache$iv2.rememberedValue();
                        if (invalid$iv2) {
                            value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                    graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                    graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                    graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                    graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv3);
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default2, (Function1) value$iv3);
                        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv4 = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer2);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function4 = constructor2;
                            $composer3.createNode(function4);
                        } else {
                            function4 = constructor2;
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                            str = str2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                            Composer $composer$iv5 = $composer3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                            int i11 = ((432 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv5, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                            Composer $composer8 = $composer3;
                            IconKt.m2292Iconww6aTOc(item.getIcon(), item.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv5, 384, 0);
                            TextKt.m2817Text4IGK_g(item.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv5, 199680, 3072, 122834);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                            $composer8.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            measurePolicy$iv = measurePolicy$iv;
                            function1 = function1;
                            $dirty2 = $dirty;
                            $this$forEach$iv = $this$forEach$iv2;
                            $changed$iv = $changed$iv2;
                            contentAlignment$iv2 = contentAlignment$iv2;
                            str2 = str;
                            materialized$iv$iv = materialized$iv$iv;
                            measurePolicy$iv3 = measurePolicy$iv3;
                            horizontalArrangement$iv = horizontalArrangement$iv;
                            function3 = function3;
                            $composer3 = $composer8;
                            propagateMinConstraints$iv = propagateMinConstraints$iv;
                            $composer2 = $composer5;
                            $composer$iv = $composer$iv2;
                            modifier$iv = modifier$iv3;
                            str3 = str3;
                            materialized$iv$iv2 = materialized$iv$iv4;
                        } else {
                            str = str2;
                        }
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                        int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                        Composer $composer$iv6 = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv6, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                        int i13 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv6, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                        Composer $composer9 = $composer3;
                        IconKt.m2292Iconww6aTOc(item.getIcon(), item.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv6, 384, 0);
                        TextKt.m2817Text4IGK_g(item.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv6, 199680, 3072, 122834);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                        $composer9.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        measurePolicy$iv = measurePolicy$iv;
                        function1 = function1;
                        $dirty2 = $dirty;
                        $this$forEach$iv = $this$forEach$iv2;
                        $changed$iv = $changed$iv2;
                        contentAlignment$iv2 = contentAlignment$iv2;
                        str2 = str;
                        materialized$iv$iv = materialized$iv$iv;
                        measurePolicy$iv3 = measurePolicy$iv3;
                        horizontalArrangement$iv = horizontalArrangement$iv;
                        function3 = function3;
                        $composer3 = $composer9;
                        propagateMinConstraints$iv = propagateMinConstraints$iv;
                        $composer2 = $composer5;
                        $composer$iv = $composer$iv2;
                        modifier$iv = modifier$iv3;
                        str3 = str3;
                        materialized$iv$iv2 = materialized$iv$iv4;
                    }
                    Composer $composer10 = $composer3;
                    Composer $composer11 = $composer2;
                    $composer10.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer11.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer11);
                    ComposerKt.sourceInformationMarkerEnd($composer11);
                    ComposerKt.sourceInformationMarkerEnd($composer11);
                    ComposerKt.sourceInformationMarkerEnd($composer11);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                $changed$iv = ($changed$iv$iv$iv2 >> 6) & 14;
                $composer$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i14 = ((390 >> 6) & 112) | 6;
                $this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247 = RowScopeInstance.INSTANCE;
                $composer3 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, -1728801984, "C:FoXinBottomNavigation.kt#g7nzpb");
                $composer3.startReplaceGroup(861733550);
                ComposerKt.sourceInformation($composer3, "*96@3991L39,97@4082L25,98@4142L188,111@4664L26,115@4964L123,104@4348L1438");
                $this$forEach$iv = bottomNavItems;
                while (r78.hasNext()) {
                    final BottomNavItem item2 = (BottomNavItem) element$iv;
                    Iterable $this$forEach$iv3 = $this$forEach$iv;
                    $composer3.startReplaceGroup(136002218);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                    $this$cache$iv = $composer3;
                    int $changed$iv3 = $changed$iv;
                    it$iv = $this$cache$iv.rememberedValue();
                    Composer $composer12 = $composer2;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceGroup();
                    Composer $composer$iv7 = $composer$iv;
                    if (LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$1(PressInteractionKt.collectIsPressedAsState(interactionSource, $composer3, 6))) {
                        f = 0.9f;
                    } else {
                        f = 1.0f;
                    }
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, PressSpec, 0.0f, "navPress", null, $composer3, 3120, 20);
                    Modifier modifier$iv4 = modifier$iv;
                    Modifier materialized$iv$iv7 = materialized$iv$iv2;
                    Modifier modifierClip3 = ClipKt.clip(RowScope.CC.weight$default($this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(18)));
                    $composer3.startReplaceGroup(136002891);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                    if (($dirty2 & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv = z | $composer4.changed(item2);
                    Composer $this$cache$iv4 = $composer3;
                    it$iv2 = $this$cache$iv4.rememberedValue();
                    if (invalid$iv) {
                        $dirty = $dirty2;
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifierM870paddingVpY3zN4$default3 = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip3, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                        $composer3.startReplaceGroup(136003191);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                        invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                        $this$cache$iv2 = $composer3;
                        Object it$iv5 = $this$cache$iv2.rememberedValue();
                        if (invalid$iv2) {
                            value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                    graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                    graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                    graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                    graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv3);
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifierGraphicsLayer3 = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default3, (Function1) value$iv3);
                        Alignment.Horizontal centerHorizontally3 = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv7 = ColumnKt.columnMeasurePolicy(center3, centerHorizontally3, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv5 = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer3);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function4 = constructor2;
                            $composer3.createNode(function4);
                        } else {
                            function4 = constructor2;
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                            str = str2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                            int i15 = ($changed$iv$iv$iv5 >> 6) & 14;
                            Composer $composer$iv8 = $composer3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv8, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                            int i16 = ((432 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv8, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                            Composer $composer13 = $composer3;
                            IconKt.m2292Iconww6aTOc(item2.getIcon(), item2.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv8, 384, 0);
                            TextKt.m2817Text4IGK_g(item2.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv8, 199680, 3072, 122834);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                            $composer13.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer13);
                            ComposerKt.sourceInformationMarkerEnd($composer13);
                            ComposerKt.sourceInformationMarkerEnd($composer13);
                            measurePolicy$iv = measurePolicy$iv;
                            function1 = function1;
                            $dirty2 = $dirty;
                            $this$forEach$iv = $this$forEach$iv3;
                            $changed$iv = $changed$iv3;
                            contentAlignment$iv2 = contentAlignment$iv2;
                            str2 = str;
                            materialized$iv$iv = materialized$iv$iv;
                            measurePolicy$iv3 = measurePolicy$iv3;
                            horizontalArrangement$iv = horizontalArrangement$iv;
                            function3 = function3;
                            $composer3 = $composer13;
                            propagateMinConstraints$iv = propagateMinConstraints$iv;
                            $composer2 = $composer12;
                            $composer$iv = $composer$iv7;
                            modifier$iv = modifier$iv4;
                            str3 = str3;
                            materialized$iv$iv2 = materialized$iv$iv7;
                        } else {
                            str = str2;
                        }
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash5);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                        int i17 = ($changed$iv$iv$iv5 >> 6) & 14;
                        Composer $composer$iv9 = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv9, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                        int i18 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv9, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                        Composer $composer14 = $composer3;
                        IconKt.m2292Iconww6aTOc(item2.getIcon(), item2.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv9, 384, 0);
                        TextKt.m2817Text4IGK_g(item2.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv9, 199680, 3072, 122834);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv9);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv9);
                        $composer14.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer14);
                        ComposerKt.sourceInformationMarkerEnd($composer14);
                        ComposerKt.sourceInformationMarkerEnd($composer14);
                        measurePolicy$iv = measurePolicy$iv;
                        function1 = function1;
                        $dirty2 = $dirty;
                        $this$forEach$iv = $this$forEach$iv3;
                        $changed$iv = $changed$iv3;
                        contentAlignment$iv2 = contentAlignment$iv2;
                        str2 = str;
                        materialized$iv$iv = materialized$iv$iv;
                        measurePolicy$iv3 = measurePolicy$iv3;
                        horizontalArrangement$iv = horizontalArrangement$iv;
                        function3 = function3;
                        $composer3 = $composer14;
                        propagateMinConstraints$iv = propagateMinConstraints$iv;
                        $composer2 = $composer12;
                        $composer$iv = $composer$iv7;
                        modifier$iv = modifier$iv4;
                        str3 = str3;
                        materialized$iv$iv2 = materialized$iv$iv7;
                    } else {
                        $dirty = $dirty2;
                    }
                    value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$1$1
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
                            onNavigate.invoke(item2.getRoute());
                        }
                    };
                    $this$cache$iv4.updateRememberedValue(value$iv2);
                    $composer3.endReplaceGroup();
                    Modifier modifierM870paddingVpY3zN4$default4 = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip3, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                    $composer3.startReplaceGroup(136003191);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                    invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                    $this$cache$iv2 = $composer3;
                    Object it$iv6 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv3);
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifierGraphicsLayer4 = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default4, (Function1) value$iv3);
                    Alignment.Horizontal centerHorizontally4 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center4 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv8 = ColumnKt.columnMeasurePolicy(center4, centerHorizontally4, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv6 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer4);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function4 = constructor2;
                        $composer3.createNode(function4);
                    } else {
                        function4 = constructor2;
                        $composer3.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        str = str2;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                        int i19 = ($changed$iv$iv$iv6 >> 6) & 14;
                        Composer $composer$iv10 = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv10, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                        int i110 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv10, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                        Composer $composer15 = $composer3;
                        IconKt.m2292Iconww6aTOc(item2.getIcon(), item2.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv10, 384, 0);
                        TextKt.m2817Text4IGK_g(item2.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv10, 199680, 3072, 122834);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv10);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv10);
                        $composer15.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer15);
                        ComposerKt.sourceInformationMarkerEnd($composer15);
                        ComposerKt.sourceInformationMarkerEnd($composer15);
                        measurePolicy$iv = measurePolicy$iv;
                        function1 = function1;
                        $dirty2 = $dirty;
                        $this$forEach$iv = $this$forEach$iv3;
                        $changed$iv = $changed$iv3;
                        contentAlignment$iv2 = contentAlignment$iv2;
                        str2 = str;
                        materialized$iv$iv = materialized$iv$iv;
                        measurePolicy$iv3 = measurePolicy$iv3;
                        horizontalArrangement$iv = horizontalArrangement$iv;
                        function3 = function3;
                        $composer3 = $composer15;
                        propagateMinConstraints$iv = propagateMinConstraints$iv;
                        $composer2 = $composer12;
                        $composer$iv = $composer$iv7;
                        modifier$iv = modifier$iv4;
                        str3 = str3;
                        materialized$iv$iv2 = materialized$iv$iv7;
                    } else {
                        str = str2;
                    }
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                    int i111 = ($changed$iv$iv$iv6 >> 6) & 14;
                    Composer $composer$iv11 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv11, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                    int i112 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv11, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                    Composer $composer16 = $composer3;
                    IconKt.m2292Iconww6aTOc(item2.getIcon(), item2.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv11, 384, 0);
                    TextKt.m2817Text4IGK_g(item2.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv11, 199680, 3072, 122834);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv11);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv11);
                    $composer16.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer16);
                    ComposerKt.sourceInformationMarkerEnd($composer16);
                    ComposerKt.sourceInformationMarkerEnd($composer16);
                    measurePolicy$iv = measurePolicy$iv;
                    function1 = function1;
                    $dirty2 = $dirty;
                    $this$forEach$iv = $this$forEach$iv3;
                    $changed$iv = $changed$iv3;
                    contentAlignment$iv2 = contentAlignment$iv2;
                    str2 = str;
                    materialized$iv$iv = materialized$iv$iv;
                    measurePolicy$iv3 = measurePolicy$iv3;
                    horizontalArrangement$iv = horizontalArrangement$iv;
                    function3 = function3;
                    $composer3 = $composer16;
                    propagateMinConstraints$iv = propagateMinConstraints$iv;
                    $composer2 = $composer12;
                    $composer$iv = $composer$iv7;
                    modifier$iv = modifier$iv4;
                    str3 = str3;
                    materialized$iv$iv2 = materialized$iv$iv7;
                }
                Composer $composer17 = $composer3;
                Composer $composer18 = $composer2;
                $composer17.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer17);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer18.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer18);
                ComposerKt.sourceInformationMarkerEnd($composer18);
                ComposerKt.sourceInformationMarkerEnd($composer18);
                ComposerKt.sourceInformationMarkerEnd($composer18);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i20 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i21 = ((48 >> 6) & 112) | 6;
            $composer2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer2, 861733351, "C89@3734L2076:FoXinBottomNavigation.kt#g7nzpb");
            materialized$iv$iv = materialized$iv$iv3;
            Modifier modifier$iv5 = SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(64));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv2, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv7 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv7 = $composer2.getCurrentCompositionLocalMap();
            function1 = function0;
            materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
            horizontalArrangement$iv = horizontalArrangement$iv3;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor;
                $composer2.createNode(function2);
            } else {
                function2 = constructor;
                $composer2.useNode();
            }
            function3 = function2;
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            propagateMinConstraints$iv = false;
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                measurePolicy$iv3 = measurePolicy$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                $changed$iv = ($changed$iv$iv$iv7 >> 6) & 14;
                $composer$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i113 = ((390 >> 6) & 112) | 6;
                $this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247 = RowScopeInstance.INSTANCE;
                $composer3 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, -1728801984, "C:FoXinBottomNavigation.kt#g7nzpb");
                $composer3.startReplaceGroup(861733550);
                ComposerKt.sourceInformation($composer3, "*96@3991L39,97@4082L25,98@4142L188,111@4664L26,115@4964L123,104@4348L1438");
                $this$forEach$iv = bottomNavItems;
                while (r78.hasNext()) {
                    final BottomNavItem item3 = (BottomNavItem) element$iv;
                    Iterable $this$forEach$iv4 = $this$forEach$iv;
                    $composer3.startReplaceGroup(136002218);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                    $this$cache$iv = $composer3;
                    int $changed$iv4 = $changed$iv;
                    it$iv = $this$cache$iv.rememberedValue();
                    Composer $composer19 = $composer2;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceGroup();
                    Composer $composer$iv12 = $composer$iv;
                    if (LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$1(PressInteractionKt.collectIsPressedAsState(interactionSource, $composer3, 6))) {
                        f = 0.9f;
                    } else {
                        f = 1.0f;
                    }
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, PressSpec, 0.0f, "navPress", null, $composer3, 3120, 20);
                    Modifier modifier$iv6 = modifier$iv;
                    Modifier materialized$iv$iv10 = materialized$iv$iv2;
                    Modifier modifierClip4 = ClipKt.clip(RowScope.CC.weight$default($this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(18)));
                    $composer3.startReplaceGroup(136002891);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                    if (($dirty2 & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv = z | $composer4.changed(item3);
                    Composer $this$cache$iv5 = $composer3;
                    it$iv2 = $this$cache$iv5.rememberedValue();
                    if (invalid$iv) {
                        $dirty = $dirty2;
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifierM870paddingVpY3zN4$default5 = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip4, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                        $composer3.startReplaceGroup(136003191);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                        invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                        $this$cache$iv2 = $composer3;
                        Object it$iv7 = $this$cache$iv2.rememberedValue();
                        if (invalid$iv2) {
                            value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                    graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                    graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                    graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                    graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv3);
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifierGraphicsLayer5 = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default5, (Function1) value$iv3);
                        Alignment.Horizontal centerHorizontally5 = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center5 = Arrangement.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv9 = ColumnKt.columnMeasurePolicy(center5, centerHorizontally5, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv8 = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv8 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer5);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function4 = constructor2;
                            $composer3.createNode(function4);
                        } else {
                            function4 = constructor2;
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                            str = str2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
                            int i114 = ($changed$iv$iv$iv8 >> 6) & 14;
                            Composer $composer$iv13 = $composer3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv13, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                            int i115 = ((432 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv13, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                            Composer $composer110 = $composer3;
                            IconKt.m2292Iconww6aTOc(item3.getIcon(), item3.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv13, 384, 0);
                            TextKt.m2817Text4IGK_g(item3.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv13, 199680, 3072, 122834);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv13);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv13);
                            $composer110.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer110);
                            ComposerKt.sourceInformationMarkerEnd($composer110);
                            ComposerKt.sourceInformationMarkerEnd($composer110);
                            measurePolicy$iv = measurePolicy$iv;
                            function1 = function1;
                            $dirty2 = $dirty;
                            $this$forEach$iv = $this$forEach$iv4;
                            $changed$iv = $changed$iv4;
                            contentAlignment$iv2 = contentAlignment$iv2;
                            str2 = str;
                            materialized$iv$iv = materialized$iv$iv;
                            measurePolicy$iv3 = measurePolicy$iv3;
                            horizontalArrangement$iv = horizontalArrangement$iv;
                            function3 = function3;
                            $composer3 = $composer110;
                            propagateMinConstraints$iv = propagateMinConstraints$iv;
                            $composer2 = $composer19;
                            $composer$iv = $composer$iv12;
                            modifier$iv = modifier$iv6;
                            str3 = str3;
                            materialized$iv$iv2 = materialized$iv$iv10;
                        } else {
                            str = str2;
                        }
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash8);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
                        int i116 = ($changed$iv$iv$iv8 >> 6) & 14;
                        Composer $composer$iv14 = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv14, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                        int i117 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv14, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                        Composer $composer111 = $composer3;
                        IconKt.m2292Iconww6aTOc(item3.getIcon(), item3.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv14, 384, 0);
                        TextKt.m2817Text4IGK_g(item3.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv14, 199680, 3072, 122834);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv14);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv14);
                        $composer111.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer111);
                        ComposerKt.sourceInformationMarkerEnd($composer111);
                        ComposerKt.sourceInformationMarkerEnd($composer111);
                        measurePolicy$iv = measurePolicy$iv;
                        function1 = function1;
                        $dirty2 = $dirty;
                        $this$forEach$iv = $this$forEach$iv4;
                        $changed$iv = $changed$iv4;
                        contentAlignment$iv2 = contentAlignment$iv2;
                        str2 = str;
                        materialized$iv$iv = materialized$iv$iv;
                        measurePolicy$iv3 = measurePolicy$iv3;
                        horizontalArrangement$iv = horizontalArrangement$iv;
                        function3 = function3;
                        $composer3 = $composer111;
                        propagateMinConstraints$iv = propagateMinConstraints$iv;
                        $composer2 = $composer19;
                        $composer$iv = $composer$iv12;
                        modifier$iv = modifier$iv6;
                        str3 = str3;
                        materialized$iv$iv2 = materialized$iv$iv10;
                    } else {
                        $dirty = $dirty2;
                    }
                    value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$1$1
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
                            onNavigate.invoke(item3.getRoute());
                        }
                    };
                    $this$cache$iv5.updateRememberedValue(value$iv2);
                    $composer3.endReplaceGroup();
                    Modifier modifierM870paddingVpY3zN4$default6 = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip4, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                    $composer3.startReplaceGroup(136003191);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                    invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                    $this$cache$iv2 = $composer3;
                    Object it$iv8 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv3);
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifierGraphicsLayer6 = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default6, (Function1) value$iv3);
                    Alignment.Horizontal centerHorizontally6 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center6 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv10 = ColumnKt.columnMeasurePolicy(center6, centerHorizontally6, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv9 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv9 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv12 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer6);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function4 = constructor2;
                        $composer3.createNode(function4);
                    } else {
                        function4 = constructor2;
                        $composer3.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        str = str2;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv12, ComposeUiNode.INSTANCE.getSetModifier());
                        int i118 = ($changed$iv$iv$iv9 >> 6) & 14;
                        Composer $composer$iv15 = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv15, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                        int i119 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv15, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                        Composer $composer112 = $composer3;
                        IconKt.m2292Iconww6aTOc(item3.getIcon(), item3.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv15, 384, 0);
                        TextKt.m2817Text4IGK_g(item3.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv15, 199680, 3072, 122834);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv15);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv15);
                        $composer112.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer112);
                        ComposerKt.sourceInformationMarkerEnd($composer112);
                        ComposerKt.sourceInformationMarkerEnd($composer112);
                        measurePolicy$iv = measurePolicy$iv;
                        function1 = function1;
                        $dirty2 = $dirty;
                        $this$forEach$iv = $this$forEach$iv4;
                        $changed$iv = $changed$iv4;
                        contentAlignment$iv2 = contentAlignment$iv2;
                        str2 = str;
                        materialized$iv$iv = materialized$iv$iv;
                        measurePolicy$iv3 = measurePolicy$iv3;
                        horizontalArrangement$iv = horizontalArrangement$iv;
                        function3 = function3;
                        $composer3 = $composer112;
                        propagateMinConstraints$iv = propagateMinConstraints$iv;
                        $composer2 = $composer19;
                        $composer$iv = $composer$iv12;
                        modifier$iv = modifier$iv6;
                        str3 = str3;
                        materialized$iv$iv2 = materialized$iv$iv10;
                    } else {
                        str = str2;
                    }
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash9);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv12, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1110 = ($changed$iv$iv$iv9 >> 6) & 14;
                    Composer $composer$iv16 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv16, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                    int i1111 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv16, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                    Composer $composer113 = $composer3;
                    IconKt.m2292Iconww6aTOc(item3.getIcon(), item3.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv16, 384, 0);
                    TextKt.m2817Text4IGK_g(item3.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv16, 199680, 3072, 122834);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv16);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv16);
                    $composer113.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer113);
                    ComposerKt.sourceInformationMarkerEnd($composer113);
                    ComposerKt.sourceInformationMarkerEnd($composer113);
                    measurePolicy$iv = measurePolicy$iv;
                    function1 = function1;
                    $dirty2 = $dirty;
                    $this$forEach$iv = $this$forEach$iv4;
                    $changed$iv = $changed$iv4;
                    contentAlignment$iv2 = contentAlignment$iv2;
                    str2 = str;
                    materialized$iv$iv = materialized$iv$iv;
                    measurePolicy$iv3 = measurePolicy$iv3;
                    horizontalArrangement$iv = horizontalArrangement$iv;
                    function3 = function3;
                    $composer3 = $composer113;
                    propagateMinConstraints$iv = propagateMinConstraints$iv;
                    $composer2 = $composer19;
                    $composer$iv = $composer$iv12;
                    modifier$iv = modifier$iv6;
                    str3 = str3;
                    materialized$iv$iv2 = materialized$iv$iv10;
                }
                Composer $composer114 = $composer3;
                Composer $composer115 = $composer2;
                $composer114.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer114);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer115.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer115);
                ComposerKt.sourceInformationMarkerEnd($composer115);
                ComposerKt.sourceInformationMarkerEnd($composer115);
                ComposerKt.sourceInformationMarkerEnd($composer115);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            } else {
                measurePolicy$iv3 = measurePolicy$iv2;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash7);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            $changed$iv = ($changed$iv$iv$iv7 >> 6) & 14;
            $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i1112 = ((390 >> 6) & 112) | 6;
            $this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247 = RowScopeInstance.INSTANCE;
            $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1728801984, "C:FoXinBottomNavigation.kt#g7nzpb");
            $composer3.startReplaceGroup(861733550);
            ComposerKt.sourceInformation($composer3, "*96@3991L39,97@4082L25,98@4142L188,111@4664L26,115@4964L123,104@4348L1438");
            $this$forEach$iv = bottomNavItems;
            while (r78.hasNext()) {
                final BottomNavItem item4 = (BottomNavItem) element$iv;
                Iterable $this$forEach$iv5 = $this$forEach$iv;
                $composer3.startReplaceGroup(136002218);
                ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                $this$cache$iv = $composer3;
                int $changed$iv5 = $changed$iv;
                it$iv = $this$cache$iv.rememberedValue();
                Composer $composer116 = $composer2;
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                interactionSource = (MutableInteractionSource) value$iv;
                $composer3.endReplaceGroup();
                Composer $composer$iv17 = $composer$iv;
                if (LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$1(PressInteractionKt.collectIsPressedAsState(interactionSource, $composer3, 6))) {
                    f = 0.9f;
                } else {
                    f = 1.0f;
                }
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, PressSpec, 0.0f, "navPress", null, $composer3, 3120, 20);
                Modifier modifier$iv7 = modifier$iv;
                Modifier materialized$iv$iv13 = materialized$iv$iv2;
                Modifier modifierClip5 = ClipKt.clip(RowScope.CC.weight$default($this$LoopBottomNavigation_u24lambda_u248_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(18)));
                $composer3.startReplaceGroup(136002891);
                ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                if (($dirty2 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv = z | $composer4.changed(item4);
                Composer $this$cache$iv6 = $composer3;
                it$iv2 = $this$cache$iv6.rememberedValue();
                if (invalid$iv) {
                    $dirty = $dirty2;
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifierM870paddingVpY3zN4$default7 = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip5, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                    $composer3.startReplaceGroup(136003191);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                    invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                    $this$cache$iv2 = $composer3;
                    Object it$iv9 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                                graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                                graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv3);
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifierGraphicsLayer7 = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default7, (Function1) value$iv3);
                    Alignment.Horizontal centerHorizontally7 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center7 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv11 = ColumnKt.columnMeasurePolicy(center7, centerHorizontally7, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv10 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv10 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv14 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer7);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv10 = (($changed$iv$iv10 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function4 = constructor2;
                        $composer3.createNode(function4);
                    } else {
                        function4 = constructor2;
                        $composer3.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        str = str2;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv14, ComposeUiNode.INSTANCE.getSetModifier());
                        int i1113 = ($changed$iv$iv$iv10 >> 6) & 14;
                        Composer $composer$iv18 = $composer3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv18, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                        int i1114 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv18, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                        Composer $composer117 = $composer3;
                        IconKt.m2292Iconww6aTOc(item4.getIcon(), item4.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv18, 384, 0);
                        TextKt.m2817Text4IGK_g(item4.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv18, 199680, 3072, 122834);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv18);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv18);
                        $composer117.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer117);
                        ComposerKt.sourceInformationMarkerEnd($composer117);
                        ComposerKt.sourceInformationMarkerEnd($composer117);
                        measurePolicy$iv = measurePolicy$iv;
                        function1 = function1;
                        $dirty2 = $dirty;
                        $this$forEach$iv = $this$forEach$iv5;
                        $changed$iv = $changed$iv5;
                        contentAlignment$iv2 = contentAlignment$iv2;
                        str2 = str;
                        materialized$iv$iv = materialized$iv$iv;
                        measurePolicy$iv3 = measurePolicy$iv3;
                        horizontalArrangement$iv = horizontalArrangement$iv;
                        function3 = function3;
                        $composer3 = $composer117;
                        propagateMinConstraints$iv = propagateMinConstraints$iv;
                        $composer2 = $composer116;
                        $composer$iv = $composer$iv17;
                        modifier$iv = modifier$iv7;
                        str3 = str3;
                        materialized$iv$iv2 = materialized$iv$iv13;
                    } else {
                        str = str2;
                    }
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash10);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv14, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1115 = ($changed$iv$iv$iv10 >> 6) & 14;
                    Composer $composer$iv19 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv19, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
                    int i1116 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv19, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                    Composer $composer118 = $composer3;
                    IconKt.m2292Iconww6aTOc(item4.getIcon(), item4.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv19, 384, 0);
                    TextKt.m2817Text4IGK_g(item4.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv19, 199680, 3072, 122834);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv19);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv19);
                    $composer118.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer118);
                    ComposerKt.sourceInformationMarkerEnd($composer118);
                    ComposerKt.sourceInformationMarkerEnd($composer118);
                    measurePolicy$iv = measurePolicy$iv;
                    function1 = function1;
                    $dirty2 = $dirty;
                    $this$forEach$iv = $this$forEach$iv5;
                    $changed$iv = $changed$iv5;
                    contentAlignment$iv2 = contentAlignment$iv2;
                    str2 = str;
                    materialized$iv$iv = materialized$iv$iv;
                    measurePolicy$iv3 = measurePolicy$iv3;
                    horizontalArrangement$iv = horizontalArrangement$iv;
                    function3 = function3;
                    $composer3 = $composer118;
                    propagateMinConstraints$iv = propagateMinConstraints$iv;
                    $composer2 = $composer116;
                    $composer$iv = $composer$iv17;
                    modifier$iv = modifier$iv7;
                    str3 = str3;
                    materialized$iv$iv2 = materialized$iv$iv13;
                } else {
                    $dirty = $dirty2;
                }
                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$1$1
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
                        onNavigate.invoke(item4.getRoute());
                    }
                };
                $this$cache$iv6.updateRememberedValue(value$iv2);
                $composer3.endReplaceGroup();
                Modifier modifierM870paddingVpY3zN4$default8 = PaddingKt.m870paddingVpY3zN4$default(ClickableKt.m484clickableO2vRcR0(modifierClip5, interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, (Function0) value$iv2), 0.0f, C1979Dp.m6801constructorimpl(8), 1, null);
                $composer3.startReplaceGroup(136003191);
                ComposerKt.sourceInformation($composer3, "CC(remember):FoXinBottomNavigation.kt#9igjgp");
                invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                $this$cache$iv2 = $composer3;
                Object it$iv10 = $this$cache$iv2.rememberedValue();
                if (invalid$iv2) {
                    value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                            graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                        }
                    };
                    $this$cache$iv2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt$LoopBottomNavigation$1$1$1$2$1
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
                            graphicsLayer.setScaleX(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                            graphicsLayer.setScaleY(FoXinBottomNavigationKt.LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(stateAnimateFloatAsState));
                        }
                    };
                    $this$cache$iv2.updateRememberedValue(value$iv3);
                }
                $composer3.endReplaceGroup();
                Modifier modifierGraphicsLayer8 = GraphicsLayerModifierKt.graphicsLayer(modifierM870paddingVpY3zN4$default8, (Function1) value$iv3);
                Alignment.Horizontal centerHorizontally8 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center8 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv12 = ColumnKt.columnMeasurePolicy(center8, centerHorizontally8, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv11 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv11 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv15 = ComposedModifierKt.materializeModifier($composer3, modifierGraphicsLayer8);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv11 = (($changed$iv$iv11 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str3);
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function4 = constructor2;
                    $composer3.createNode(function4);
                } else {
                    function4 = constructor2;
                    $composer3.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    str = str2;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv15, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1117 = ($changed$iv$iv$iv11 >> 6) & 14;
                    Composer $composer$iv110 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv110, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
                    int i1118 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv110, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                    Composer $composer119 = $composer3;
                    IconKt.m2292Iconww6aTOc(item4.getIcon(), item4.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv110, 384, 0);
                    TextKt.m2817Text4IGK_g(item4.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv110, 199680, 3072, 122834);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv110);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv110);
                    $composer119.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer119);
                    ComposerKt.sourceInformationMarkerEnd($composer119);
                    ComposerKt.sourceInformationMarkerEnd($composer119);
                    measurePolicy$iv = measurePolicy$iv;
                    function1 = function1;
                    $dirty2 = $dirty;
                    $this$forEach$iv = $this$forEach$iv5;
                    $changed$iv = $changed$iv5;
                    contentAlignment$iv2 = contentAlignment$iv2;
                    str2 = str;
                    materialized$iv$iv = materialized$iv$iv;
                    measurePolicy$iv3 = measurePolicy$iv3;
                    horizontalArrangement$iv = horizontalArrangement$iv;
                    function3 = function3;
                    $composer3 = $composer119;
                    propagateMinConstraints$iv = propagateMinConstraints$iv;
                    $composer2 = $composer116;
                    $composer$iv = $composer$iv17;
                    modifier$iv = modifier$iv7;
                    str3 = str3;
                    materialized$iv$iv2 = materialized$iv$iv13;
                } else {
                    str = str2;
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash11);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv15, ComposeUiNode.INSTANCE.getSetModifier());
                int i1119 = ($changed$iv$iv$iv11 >> 6) & 14;
                Composer $composer$iv111 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv111, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance16 = ColumnScopeInstance.INSTANCE;
                int i11110 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv111, 644037954, "C122@5262L234,128@5517L251:FoXinBottomNavigation.kt#g7nzpb");
                Composer $composer1110 = $composer3;
                IconKt.m2292Iconww6aTOc(item4.getIcon(), item4.getLabel(), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), contentColor, $composer$iv111, 384, 0);
                TextKt.m2817Text4IGK_g(item4.getLabel(), (Modifier) null, contentColor, TextUnitKt.getSp(10), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv111, 199680, 3072, 122834);
                ComposerKt.sourceInformationMarkerEnd($composer$iv111);
                ComposerKt.sourceInformationMarkerEnd($composer$iv111);
                $composer1110.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer1110);
                ComposerKt.sourceInformationMarkerEnd($composer1110);
                ComposerKt.sourceInformationMarkerEnd($composer1110);
                measurePolicy$iv = measurePolicy$iv;
                function1 = function1;
                $dirty2 = $dirty;
                $this$forEach$iv = $this$forEach$iv5;
                $changed$iv = $changed$iv5;
                contentAlignment$iv2 = contentAlignment$iv2;
                str2 = str;
                materialized$iv$iv = materialized$iv$iv;
                measurePolicy$iv3 = measurePolicy$iv3;
                horizontalArrangement$iv = horizontalArrangement$iv;
                function3 = function3;
                $composer3 = $composer1110;
                propagateMinConstraints$iv = propagateMinConstraints$iv;
                $composer2 = $composer116;
                $composer$iv = $composer$iv17;
                modifier$iv = modifier$iv7;
                str3 = str3;
                materialized$iv$iv2 = materialized$iv$iv13;
            }
            Composer $composer1111 = $composer3;
            Composer $composer1112 = $composer2;
            $composer1111.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer1111);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer1112.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer1112);
            ComposerKt.sourceInformationMarkerEnd($composer1112);
            ComposerKt.sourceInformationMarkerEnd($composer1112);
            ComposerKt.sourceInformationMarkerEnd($composer1112);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FoXinBottomNavigationKt.LoopBottomNavigation.2
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

                public final void invoke(Composer composer, int i22) {
                    FoXinBottomNavigationKt.LoopBottomNavigation(onNavigate, modifier2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LoopBottomNavigation$lambda$8$lambda$7$lambda$6$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }
}
