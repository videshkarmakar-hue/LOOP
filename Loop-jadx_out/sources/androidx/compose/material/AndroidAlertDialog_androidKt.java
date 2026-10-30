package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.window.AndroidDialog_androidKt;
import androidx.compose.p001ui.window.DialogProperties;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m195d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidAlertDialog_androidKt {
    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m1547AlertDialog6oU6zVQ(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function6;
        Shape shape2;
        long j;
        Modifier.Companion modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        CornerBasedShape shape3;
        long backgroundColor2;
        long contentColor2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int $dirty;
        DialogProperties properties2;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        DialogProperties properties3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        long backgroundColor3;
        Shape shape4;
        long contentColor3;
        Composer $composer2 = $composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,77@3743L444,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function6 = function4;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function6 = function4;
            $dirty2 |= $composer2.changedInstance(function6) ? 16384 : 8192;
        } else {
            function6 = function4;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                shape2 = shape;
                int i6 = $composer2.changed(shape2) ? 1048576 : 524288;
                $dirty2 |= i6;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i6;
        } else {
            shape2 = shape;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(backgroundColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            if ((i & 256) == 0) {
                j = contentColor;
                int i7 = $composer2.changed(j) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty2 |= i7;
            } else {
                j = contentColor;
            }
            $dirty2 |= i7;
        } else {
            j = contentColor;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changed(properties) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function10 = function3;
            function11 = function5;
            backgroundColor3 = backgroundColor;
            properties3 = properties;
            function12 = function6;
            contentColor3 = j;
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function7 = i3 != 0 ? null : function3;
                function8 = i4 != 0 ? null : function6;
                Function2<? super Composer, ? super Integer, Unit> function13 = i5 != 0 ? null : function5;
                if ((i & 64) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                    $dirty2 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 256) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 21) & 14);
                    $dirty2 &= -234881025;
                } else {
                    contentColor2 = j;
                }
                if (i8 != 0) {
                    $dirty = $dirty2;
                    properties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    function9 = function13;
                } else {
                    function9 = function13;
                    $dirty = $dirty2;
                    properties2 = properties;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    int i9 = $dirty2 & (-234881025);
                    modifier2 = modifier;
                    function7 = function3;
                    backgroundColor2 = backgroundColor;
                    properties2 = properties;
                    function8 = function6;
                    contentColor2 = j;
                    shape3 = shape2;
                    $dirty = i9;
                    function9 = function5;
                } else {
                    modifier2 = modifier;
                    function7 = function3;
                    function9 = function5;
                    backgroundColor2 = backgroundColor;
                    function8 = function6;
                    contentColor2 = j;
                    shape3 = shape2;
                    $dirty = $dirty2;
                    properties2 = properties;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:74)");
            }
            Function2<? super Composer, ? super Integer, Unit> function14 = function7;
            m1548AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C79@3846L331:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1849673151, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:79)");
                    }
                    Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(2));
                    final Function2<Composer, Integer, Unit> function15 = function7;
                    final Function2<Composer, Integer, Unit> function16 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function1 = constructor;
                        $composer3.createNode(function1);
                    } else {
                        function1 = constructor;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i10 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i11 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 350577093, "C83@4064L99,80@3937L226:AndroidAlertDialog.android.kt#jmzs0o");
                    AlertDialogKt.m1546AlertDialogFlowRowixp7dh8(C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(12), ComposableLambdaKt.rememberComposableLambda(1789213604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1$1$1
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

                        public final void invoke(Composer $composer4, int $changed3) {
                            ComposerKt.sourceInformation($composer4, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
                            if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1789213604, $changed3, -1, "androidx.compose.material.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:84)");
                                }
                                Function2<Composer, Integer, Unit> function17 = function15;
                                $composer4.startReplaceGroup(-1046483318);
                                ComposerKt.sourceInformation($composer4, "84@4101L8");
                                if (function17 != null) {
                                    function17.invoke($composer4, 0);
                                    Unit unit = Unit.INSTANCE;
                                }
                                $composer4.endReplaceGroup();
                                function16.invoke($composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54), $composer3, 438);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), modifier2, function8, function9, shape3, backgroundColor2, contentColor2, properties2, $composer2, ($dirty & 14) | 48 | ($dirty & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (234881024 & ($dirty >> 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function10 = function14;
            function11 = function9;
            properties3 = properties2;
            modifier3 = modifier2;
            function12 = function8;
            backgroundColor3 = backgroundColor2;
            shape4 = shape3;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function11;
            final Shape shape5 = shape4;
            final long j2 = backgroundColor3;
            final long j3 = contentColor3;
            final DialogProperties dialogProperties = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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
                    AndroidAlertDialog_androidKt.m1547AlertDialog6oU6zVQ(function0, function2, modifier4, function15, function16, function17, shape5, j2, j3, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m1548AlertDialogwqdebIU(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Function2<? super Composer, ? super Integer, Unit> function6;
        CornerBasedShape shape2;
        Modifier modifier2;
        int $dirty;
        DialogProperties properties2;
        Modifier modifier3;
        DialogProperties properties3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Shape shape3;
        long contentColor3;
        long backgroundColor3;
        Composer $composer2 = $composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,139@6420L275,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(shape)) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer2.changed(backgroundColor2) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer2.changed(contentColor2) ? 8388608 : 4194304;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(properties) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function7 = function3;
            function8 = function4;
            shape3 = shape;
            properties3 = properties;
            contentColor3 = contentColor2;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function5 = i3 != 0 ? null : function3;
                function6 = i4 != 0 ? null : function4;
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                    $dirty2 &= -458753;
                } else {
                    shape2 = shape;
                }
                if ((i & 64) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    properties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    properties2 = properties;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    int i8 = $dirty2 & (-29360129);
                    function5 = function3;
                    function6 = function4;
                    shape2 = shape;
                    properties2 = properties;
                    $dirty = i8;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    function5 = function3;
                    function6 = function4;
                    shape2 = shape;
                    $dirty = $dirty2;
                    properties2 = properties;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:135)");
            }
            final Modifier modifier5 = modifier2;
            final Function2<? super Composer, ? super Integer, Unit> function9 = function5;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function6;
            final Shape shape4 = shape2;
            final long j = backgroundColor2;
            final long j2 = contentColor2;
            Function2<Composer, Integer, Unit> function11 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                    ComposerKt.sourceInformation($composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1787418772, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                        }
                        AlertDialogKt.m1545AlertDialogContentWMdw5o4(function2, modifier5, function9, function10, shape4, j, j2, $composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            };
            Modifier modifier6 = modifier2;
            AndroidDialog_androidKt.Dialog(function0, properties2, ComposableLambdaKt.rememberComposableLambda(-1787418772, true, function11, $composer2, 54), $composer2, ($dirty & 14) | 384 | (($dirty >> 21) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            properties3 = properties2;
            function7 = function5;
            function8 = function6;
            shape3 = shape2;
            contentColor3 = contentColor2;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function12 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function13 = function8;
            final Shape shape5 = shape3;
            final long j3 = backgroundColor3;
            final long j4 = contentColor3;
            final DialogProperties dialogProperties = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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
                    AndroidAlertDialog_androidKt.m1548AlertDialogwqdebIU(function0, function2, modifier7, function12, function13, shape5, j3, j4, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
