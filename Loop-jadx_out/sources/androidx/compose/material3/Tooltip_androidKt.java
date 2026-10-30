package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.AndroidPath_androidKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.LayoutCoordinatesKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Tooltip.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aq\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0095\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aH\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, m195d2 = {"PlainTooltip", "", "Landroidx/compose/material3/CaretScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretProperties", "Landroidx/compose/material3/CaretProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-Fg7CxbU", "(Landroidx/compose/material3/CaretScope;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CaretProperties;Landroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-KBW6s6s", "(Landroidx/compose/material3/CaretScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/CaretProperties;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "caretType", "Landroidx/compose/material3/CaretType;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-qFjXxE8", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/material3/CaretType;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JLandroidx/compose/material3/CaretProperties;Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Tooltip_androidKt {
    /* JADX INFO: renamed from: PlainTooltip-Fg7CxbU, reason: not valid java name */
    public static final void m2960PlainTooltipFg7CxbU(final CaretScope $this$PlainTooltip_u2dFg7CxbU, Modifier modifier, CaretProperties caretProperties, Shape shape, long contentColor, long containerColor, float tonalElevation, float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        long j;
        long containerColor2;
        float tonalElevation2;
        CaretProperties caretProperties2;
        Shape shape3;
        final long contentColor2;
        Modifier modifier2;
        int $dirty;
        float fM6801constructorimpl;
        Modifier drawCaretModifier;
        float shadowElevation2;
        float tonalElevation3;
        Modifier modifier3;
        CaretProperties caretProperties3;
        long containerColor3;
        long contentColor3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(419109811);
        ComposerKt.sourceInformation($composer2, "C(PlainTooltip)P(4!1,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)211@8147L26,214@8217L24,215@8287L26,93@3769L596,87@3578L787:Tooltip.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed($this$PlainTooltip_u2dFg7CxbU) : $composer2.changedInstance($this$PlainTooltip_u2dFg7CxbU) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(caretProperties) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 4) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 8) == 0) {
                j = contentColor;
                int i5 = $composer2.changed(j) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                j = contentColor;
            }
            $dirty2 |= i5;
        } else {
            j = contentColor;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            if ((i & 16) == 0) {
                containerColor2 = containerColor;
                int i6 = $composer2.changed(containerColor2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i6;
        } else {
            containerColor2 = containerColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 1572864) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty2 |= $composer2.changed(tonalElevation2) ? 1048576 : 524288;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(shadowElevation) ? 8388608 : 4194304;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty2) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            caretProperties3 = caretProperties;
            shadowElevation2 = shadowElevation;
            containerColor3 = containerColor2;
            shape3 = shape2;
            contentColor3 = j;
            tonalElevation3 = tonalElevation2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                caretProperties2 = i3 != 0 ? null : caretProperties;
                if ((i & 4) != 0) {
                    shape3 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape($composer2, 6);
                    $dirty2 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor($composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    contentColor2 = j;
                }
                if ((i & 16) != 0) {
                    containerColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor($composer2, 6);
                    $dirty2 &= -458753;
                }
                if (i7 != 0) {
                    tonalElevation2 = C1979Dp.m6801constructorimpl(0);
                }
                if (i8 != 0) {
                    $dirty = $dirty2;
                    fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    fM6801constructorimpl = shadowElevation;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 16) != 0) {
                    int i9 = $dirty2 & (-458753);
                    caretProperties2 = caretProperties;
                    fM6801constructorimpl = shadowElevation;
                    $dirty = i9;
                    shape3 = shape2;
                    contentColor2 = j;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    caretProperties2 = caretProperties;
                    $dirty = $dirty2;
                    shape3 = shape2;
                    contentColor2 = j;
                    fM6801constructorimpl = shadowElevation;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(419109811, $dirty, -1, "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:71)");
            }
            $composer2.startReplaceGroup(2067440433);
            ComposerKt.sourceInformation($composer2, "74@3123L7,75@3182L7,76@3221L313");
            if (caretProperties2 != null) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Density density = (Density) objConsume;
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer2.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Configuration configuration = (Configuration) objConsume2;
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 2067440601, "CC(remember):Tooltip.android.kt#9igjgp");
                boolean invalid$iv = ((((458752 & $dirty) ^ ProfileVerifier.CompilationStatus.f245xf2722a21) > 131072 && $composer2.changed(containerColor2)) || (196608 & $dirty) == 131072) | $composer2.changed(density) | $composer2.changedInstance(configuration) | (($dirty & 896) == 256);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    final long j2 = containerColor2;
                    final CaretProperties caretProperties4 = caretProperties2;
                    value$iv = new Function2<CacheDrawScope, LayoutCoordinates, DrawResult>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$drawCaretModifier$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final DrawResult invoke(CacheDrawScope $this$drawCaret, LayoutCoordinates anchorLayoutCoordinates) {
                            return Tooltip_androidKt.m2963drawCaretWithPathqFjXxE8($this$drawCaret, CaretType.Plain, density, configuration, j2, caretProperties4, anchorLayoutCoordinates);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                drawCaretModifier = $this$PlainTooltip_u2dFg7CxbU.drawCaret(companion, (Function2) value$iv).then(modifier2);
            } else {
                drawCaretModifier = modifier2;
            }
            $composer2.endReplaceGroup();
            SurfaceKt.m2666SurfaceT9BRK9s(drawCaretModifier, shape3, containerColor2, 0L, tonalElevation2, fM6801constructorimpl, null, ComposableLambdaKt.rememberComposableLambda(-705895688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C94@3779L580:Tooltip.android.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-705895688, $changed2, -1, "androidx.compose.material3.PlainTooltip.<anonymous> (Tooltip.android.kt:94)");
                    }
                    Modifier modifier$iv = PaddingKt.padding(SizeKt.m917sizeInqDBjuR0$default(Modifier.INSTANCE, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getPlainTooltipMaxWidth(), 0.0f, 8, null), TooltipKt.getPlainTooltipContentPadding());
                    long j3 = contentColor2;
                    Function2<Composer, Integer, Unit> function3 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
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
                        function0 = constructor;
                        $composer3.createNode(function0);
                    } else {
                        function0 = constructor;
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
                    int i11 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 64550359, "C103@4095L10,105@4168L181:Tooltip.android.kt#uh7d8r");
                    TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), PlainTooltipTokens.INSTANCE.getSupportingTextFont());
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(j3)), TextKt.getLocalTextStyle().provides(textStyle)}, function3, $composer3, 0);
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
            }, $composer2, 54), $composer2, (($dirty >> 6) & 112) | 12582912 | (($dirty >> 9) & 896) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shadowElevation2 = fM6801constructorimpl;
            tonalElevation3 = tonalElevation2;
            modifier3 = modifier2;
            caretProperties3 = caretProperties2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final CaretProperties caretProperties5 = caretProperties3;
            final Shape shape4 = shape3;
            final long j3 = contentColor3;
            final long j4 = containerColor3;
            final float f = tonalElevation3;
            final float f2 = shadowElevation2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2
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
                    Tooltip_androidKt.m2960PlainTooltipFg7CxbU($this$PlainTooltip_u2dFg7CxbU, modifier5, caretProperties5, shape4, j3, j4, f, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: RichTooltip-KBW6s6s, reason: not valid java name */
    public static final void m2961RichTooltipKBW6s6s(final CaretScope $this$RichTooltip_u2dKBW6s6s, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, CaretProperties caretProperties, Shape shape, RichTooltipColors colors, float tonalElevation, float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function5;
        CaretProperties caretProperties2;
        Shape shape2;
        Modifier.Companion modifier2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        CaretProperties caretProperties3;
        Shape shape3;
        final RichTooltipColors colors2;
        float tonalElevation2;
        float shadowElevation2;
        Function2<? super Composer, ? super Integer, Unit> function8;
        final long elevatedColor;
        Modifier drawCaretModifier;
        Modifier modifier3;
        float tonalElevation3;
        float shadowElevation3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        CaretProperties caretProperties4;
        Shape shape4;
        RichTooltipColors colors3;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(2117128312);
        ComposerKt.sourceInformation($composer2, "C(RichTooltip)P(3,7!2,5!1,8:c#ui.unit.Dp,4:c#ui.unit.Dp)252@9625L25,254@9700L19,*145@5701L7,147@5772L11,147@5784L95,177@6809L1866,166@6439L2236:Tooltip.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed($this$RichTooltip_u2dKBW6s6s) : $composer2.changedInstance($this$RichTooltip_u2dKBW6s6s) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 3072;
            function5 = function3;
        } else if (($changed & 3072) == 0) {
            function5 = function3;
            $dirty |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            caretProperties2 = caretProperties;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            caretProperties2 = caretProperties;
            $dirty |= $composer2.changed(caretProperties2) ? 16384 : 8192;
        } else {
            caretProperties2 = caretProperties;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i6 = $composer2.changed(shape2) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                shape2 = shape;
            }
            $dirty |= i6;
        } else {
            shape2 = shape;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= ((i & 32) == 0 && $composer2.changed(colors)) ? 1048576 : 524288;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(tonalElevation) ? 8388608 : 4194304;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(shadowElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 256) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 536870912 : 268435456;
        }
        if ((306783379 & $dirty) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function9 = function2;
            colors3 = colors;
            tonalElevation3 = tonalElevation;
            shadowElevation3 = shadowElevation;
            function10 = function5;
            shape4 = shape2;
            caretProperties4 = caretProperties2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function6 = i3 != 0 ? null : function2;
                function7 = i4 != 0 ? null : function5;
                caretProperties3 = i5 != 0 ? null : caretProperties2;
                if ((i & 16) != 0) {
                    shape3 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape($composer2, 6);
                    $dirty &= -458753;
                } else {
                    shape3 = shape2;
                }
                if ((i & 32) != 0) {
                    colors2 = TooltipDefaults.INSTANCE.richTooltipColors($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    colors2 = colors;
                }
                tonalElevation2 = i7 != 0 ? ElevationTokens.INSTANCE.m3273getLevel0D9Ej5fM() : tonalElevation;
                shadowElevation2 = i8 != 0 ? RichTooltipTokens.INSTANCE.m3571getContainerElevationD9Ej5fM() : shadowElevation;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 32) != 0) {
                    modifier2 = modifier;
                    function6 = function2;
                    colors2 = colors;
                    $dirty = (-3670017) & $dirty;
                    function7 = function5;
                    shape3 = shape2;
                    caretProperties3 = caretProperties2;
                    tonalElevation2 = tonalElevation;
                    shadowElevation2 = shadowElevation;
                } else {
                    modifier2 = modifier;
                    function6 = function2;
                    colors2 = colors;
                    shadowElevation2 = shadowElevation;
                    function7 = function5;
                    shape3 = shape2;
                    caretProperties3 = caretProperties2;
                    tonalElevation2 = tonalElevation;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2117128312, $dirty, -1, "androidx.compose.material3.RichTooltip (Tooltip.android.kt:144)");
            }
            ProvidableCompositionLocal<C1979Dp> localAbsoluteTonalElevation = SurfaceKt.getLocalAbsoluteTonalElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteTonalElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1979Dp) objConsume).m6815unboximpl();
            long elevatedColor2 = ColorSchemeKt.m2080applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme($composer2, 6), colors2.getContainerColor(), C1979Dp.m6801constructorimpl(arg0$iv + tonalElevation2), $composer2, 0);
            $composer2.startReplaceGroup(-1753607720);
            ComposerKt.sourceInformation($composer2, "153@5986L7,154@6045L7,155@6084L311");
            if (caretProperties3 != null) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Density density = (Density) objConsume2;
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer2.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Configuration configuration = (Configuration) objConsume3;
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -1753607552, "CC(remember):Tooltip.android.kt#9igjgp");
                Function2<? super Composer, ? super Integer, Unit> function11 = function6;
                elevatedColor = elevatedColor2;
                function8 = function11;
                boolean invalid$iv = $composer2.changed(density) | $composer2.changedInstance(configuration) | $composer2.changed(elevatedColor) | (($dirty & 57344) == 16384);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    final CaretProperties caretProperties5 = caretProperties3;
                    value$iv = new Function2<CacheDrawScope, LayoutCoordinates, DrawResult>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$drawCaretModifier$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final DrawResult invoke(CacheDrawScope $this$drawCaret, LayoutCoordinates anchorLayoutCoordinates) {
                            return Tooltip_androidKt.m2963drawCaretWithPathqFjXxE8($this$drawCaret, CaretType.Rich, density, configuration, elevatedColor, caretProperties5, anchorLayoutCoordinates);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                drawCaretModifier = $this$RichTooltip_u2dKBW6s6s.drawCaret(companion, (Function2) value$iv).then(modifier2);
            } else {
                function8 = function6;
                elevatedColor = elevatedColor2;
                drawCaretModifier = modifier2;
            }
            $composer2.endReplaceGroup();
            final Function2<? super Composer, ? super Integer, Unit> function12 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function13 = function7;
            modifier3 = modifier2;
            SurfaceKt.m2666SurfaceT9BRK9s(SizeKt.m917sizeInqDBjuR0$default(drawCaretModifier, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0.0f, 8, null), shape3, colors2.getContainerColor(), 0L, tonalElevation2, shadowElevation2, null, ComposableLambdaKt.rememberComposableLambda(-242200365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
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
                    Function0<ComposeUiNode> function0;
                    Function0<ComposeUiNode> function1;
                    Function0<ComposeUiNode> function14;
                    Function0<ComposeUiNode> function15;
                    ComposerKt.sourceInformation($composer3, "C179@6872L10,181@6989L10,183@7101L10,185@7169L1500:Tooltip.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-242200365, $changed2, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.android.kt:178)");
                        }
                        TextStyle actionLabelTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
                        TextStyle subheadTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
                        TextStyle supportingTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
                        Modifier modifier$iv = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                        Function2<Composer, Integer, Unit> function16 = function12;
                        Function2<Composer, Integer, Unit> function17 = function13;
                        RichTooltipColors richTooltipColors = colors2;
                        Function2<Composer, Integer, Unit> function18 = function4;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
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
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
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
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i10 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1216119310, "C199@7722L407:Tooltip.android.kt#uh7d8r");
                        $composer3.startReplaceGroup(-1216119303);
                        ComposerKt.sourceInformation($composer3, "*189@7313L382");
                        if (function16 != null) {
                            Modifier modifier$iv2 = AlignmentLineKt.m719paddingFromBaselineVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getHeightToSubheadFirstLine(), 0.0f, 2, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv2 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                function1 = constructor2;
                                $composer3.createNode(function1);
                            } else {
                                function1 = constructor2;
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i12 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -137019558, "C192@7450L227:Tooltip.android.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(richTooltipColors.getTitleContentColor())), TextKt.getLocalTextStyle().provides(subheadTextStyle)}, function16, $composer3, 0);
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
                        Modifier modifier$iv3 = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function16 != null, function17 != null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function14 = constructor3;
                            $composer3.createNode(function14);
                        } else {
                            function14 = constructor3;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i13 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int i14 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1307456895, "C205@7904L211:Tooltip.android.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(richTooltipColors.getContentColor())), TextKt.getLocalTextStyle().provides(supportingTextStyle)}, function18, $composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.startReplaceGroup(-8199501);
                        ComposerKt.sourceInformation($composer3, "*212@8172L473");
                        if (function17 != null) {
                            Modifier modifier$iv4 = PaddingKt.m872paddingqDBjuR0$default(SizeKt.m904requiredHeightInVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getActionLabelMinHeight(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.getActionLabelBottomPadding(), 7, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                            int $changed$iv$iv4 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                function15 = constructor4;
                                $composer3.createNode(function15);
                            } else {
                                function15 = constructor4;
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3795constructorimpl($composer3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                            int i15 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            int i16 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -137018613, "C217@8395L232:Tooltip.android.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(richTooltipColors.getActionContentColor())), TextKt.getLocalTextStyle().provides(actionLabelTextStyle)}, function17, $composer3, 0);
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
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 12) & 112) | 12582912 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            tonalElevation3 = tonalElevation2;
            shadowElevation3 = shadowElevation2;
            function9 = function12;
            caretProperties4 = caretProperties3;
            shape4 = shape3;
            colors3 = colors2;
            function10 = function13;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function14 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function10;
            final CaretProperties caretProperties6 = caretProperties4;
            final Shape shape5 = shape4;
            final RichTooltipColors richTooltipColors = colors3;
            final float f = tonalElevation3;
            final float f2 = shadowElevation3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$2
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
                    Tooltip_androidKt.m2961RichTooltipKBW6s6s($this$RichTooltip_u2dKBW6s6s, modifier4, function14, function15, caretProperties6, shape5, richTooltipColors, f, f2, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCaretWithPath-qFjXxE8, reason: not valid java name */
    public static final DrawResult m2963drawCaretWithPathqFjXxE8(CacheDrawScope $this$drawCaretWithPath_u2dqFjXxE8, CaretType caretType, Density density, Configuration configuration, final long containerColor, CaretProperties caretProperties, final LayoutCoordinates anchorLayoutCoordinates) {
        float anchorMidFromRightScreenEdge;
        long position;
        final Path path = AndroidPath_androidKt.Path();
        if (anchorLayoutCoordinates != null) {
            int caretHeightPx = density.mo561roundToPx0680j_4(caretProperties.m1989getCaretHeightD9Ej5fM());
            int caretWidthPx = density.mo561roundToPx0680j_4(caretProperties.m1990getCaretWidthD9Ej5fM());
            int $this$dp$iv = configuration.screenWidthDp;
            int screenWidthPx = density.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl($this$dp$iv));
            int tooltipAnchorSpacing = density.mo561roundToPx0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            Rect anchorBounds = LayoutCoordinatesKt.boundsInWindow(anchorLayoutCoordinates);
            float anchorLeft = anchorBounds.getLeft();
            float anchorRight = anchorBounds.getRight();
            float anchorTop = anchorBounds.getTop();
            float f = 2;
            float anchorMid = (anchorRight + anchorLeft) / f;
            float anchorWidth = anchorRight - anchorLeft;
            float tooltipWidth = Size.m4118getWidthimpl($this$drawCaretWithPath_u2dqFjXxE8.m3940getSizeNHjbRc());
            float tooltipHeight = Size.m4115getHeightimpl($this$drawCaretWithPath_u2dqFjXxE8.m3940getSizeNHjbRc());
            boolean isCaretTop = (anchorTop - tooltipHeight) - ((float) tooltipAnchorSpacing) < 0.0f;
            float caretY = isCaretTop ? 0.0f : tooltipHeight;
            if (caretType != CaretType.Plain) {
                anchorMidFromRightScreenEdge = caretY;
                long preferredPosition = OffsetKt.Offset(anchorMid - anchorLeft, anchorMidFromRightScreenEdge);
                if (anchorLeft + tooltipWidth > screenWidthPx) {
                    preferredPosition = OffsetKt.Offset(anchorMid - (anchorRight - tooltipWidth), anchorMidFromRightScreenEdge);
                    if (anchorRight - tooltipWidth < 0.0f) {
                        if ((anchorLeft - (tooltipWidth / f)) + (anchorWidth / f) <= 0.0f) {
                            preferredPosition = OffsetKt.Offset(anchorMid, anchorMidFromRightScreenEdge);
                        } else if (((tooltipWidth / f) + anchorRight) - (anchorWidth / f) >= screenWidthPx) {
                            float caretX = tooltipWidth - (screenWidthPx - anchorMid);
                            preferredPosition = OffsetKt.Offset(caretX, anchorMidFromRightScreenEdge);
                        } else {
                            preferredPosition = OffsetKt.Offset(tooltipWidth / f, anchorMidFromRightScreenEdge);
                        }
                    }
                }
                position = preferredPosition;
            } else if ((tooltipWidth / f) + anchorMid > screenWidthPx) {
                float caretX2 = tooltipWidth - (screenWidthPx - anchorMid);
                position = OffsetKt.Offset(caretX2, caretY);
                anchorMidFromRightScreenEdge = caretY;
            } else {
                anchorMidFromRightScreenEdge = caretY;
                float tooltipLeft = anchorLeft - ((Size.m4118getWidthimpl($this$drawCaretWithPath_u2dqFjXxE8.m3940getSizeNHjbRc()) / f) - (anchorWidth / f));
                float caretX3 = anchorMid - Math.max(tooltipLeft, 0.0f);
                position = OffsetKt.Offset(caretX3, anchorMidFromRightScreenEdge);
            }
            if (isCaretTop) {
                path.moveTo(Offset.m4049getXimpl(position), Offset.m4050getYimpl(position));
                path.lineTo(Offset.m4049getXimpl(position) + (caretWidthPx / 2), Offset.m4050getYimpl(position));
                path.lineTo(Offset.m4049getXimpl(position), Offset.m4050getYimpl(position) - caretHeightPx);
                path.lineTo(Offset.m4049getXimpl(position) - (caretWidthPx / 2), Offset.m4050getYimpl(position));
                path.close();
            } else {
                path.moveTo(Offset.m4049getXimpl(position), Offset.m4050getYimpl(position));
                path.lineTo(Offset.m4049getXimpl(position) + (caretWidthPx / 2), Offset.m4050getYimpl(position));
                path.lineTo(Offset.m4049getXimpl(position), Offset.m4050getYimpl(position) + caretHeightPx);
                path.lineTo(Offset.m4049getXimpl(position) - (caretWidthPx / 2), Offset.m4050getYimpl(position));
                path.close();
            }
        }
        return $this$drawCaretWithPath_u2dqFjXxE8.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$drawCaretWithPath$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$onDrawWithContent) {
                if (anchorLayoutCoordinates != null) {
                    $this$onDrawWithContent.drawContent();
                    DrawScope.CC.m4854drawPathLG529CI$default($this$onDrawWithContent, path, containerColor, 0.0f, null, null, 0, 60, null);
                }
            }
        });
    }
}
