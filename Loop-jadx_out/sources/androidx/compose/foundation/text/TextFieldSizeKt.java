package androidx.compose.foundation.text;

import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.TextStyleKt;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontSynthesis;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002"}, m195d2 = {"textFieldMinSize", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "foundation_release", "typeface", ""}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldSizeKt {
    public static final Modifier textFieldMinSize(Modifier $this$textFieldMinSize, final TextStyle style) {
        return ComposedModifierKt.composed$default($this$textFieldMinSize, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                Object value$iv;
                Object value$iv2;
                Object value$iv3;
                $composer.startReplaceGroup(1582736677);
                ComposerKt.sourceInformation($composer, "C37@1534L7,38@1595L7,39@1650L7,41@1683L88,44@1792L312,53@2129L101,59@2348L483:TextFieldSize.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1582736677, $changed, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density density = (Density) objConsume;
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer.consume(localFontFamilyResolver);
                ComposerKt.sourceInformationMarkerEnd($composer);
                FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) objConsume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer);
                LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
                ComposerKt.sourceInformationMarkerStart($composer, 31601671, "CC(remember):TextFieldSize.kt#9igjgp");
                boolean invalid$iv = $composer.changed(style) | $composer.changed(layoutDirection);
                TextStyle textStyle = style;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                TextStyle resolvedStyle = (TextStyle) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 31601780, "CC(remember):TextFieldSize.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(fontFamilyResolver) | $composer.changed(resolvedStyle);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    FontFamily fontFamily = resolvedStyle.getFontFamily();
                    FontWeight fontWeight = resolvedStyle.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.INSTANCE.getNormal();
                    }
                    FontStyle fontStyleM6283getFontStyle4Lr2A7w = resolvedStyle.m6283getFontStyle4Lr2A7w();
                    int iM6367unboximpl = fontStyleM6283getFontStyle4Lr2A7w != null ? fontStyleM6283getFontStyle4Lr2A7w.m6367unboximpl() : FontStyle.INSTANCE.m6371getNormal_LCdwA();
                    FontSynthesis fontSynthesisM6284getFontSynthesisZQGJjVo = resolvedStyle.m6284getFontSynthesisZQGJjVo();
                    value$iv2 = fontFamilyResolver.mo6338resolveDPcqOEQ(fontFamily, fontWeight, iM6367unboximpl, fontSynthesisM6284getFontSynthesisZQGJjVo != null ? fontSynthesisM6284getFontSynthesisZQGJjVo.getValue() : FontSynthesis.INSTANCE.m6381getAllGVVA2EU());
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                State typeface$delegate = (State) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 31602117, "CC(remember):TextFieldSize.kt#9igjgp");
                TextStyle textStyle2 = style;
                Object value$iv4 = $composer.rememberedValue();
                if (value$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new TextFieldSize(layoutDirection, density, fontFamilyResolver, textStyle2, typeface$delegate.getValue());
                    $composer.updateRememberedValue(value$iv4);
                }
                final TextFieldSize minSizeState = (TextFieldSize) value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                minSizeState.update(layoutDirection, density, fontFamilyResolver, resolvedStyle, typeface$delegate.getValue());
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 31602336, "CC(remember):TextFieldSize.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance(minSizeState);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                            return m1261invoke3p2s80s(measureScope, measurable, constraints.getValue());
                        }

                        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m1261invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                            long minSize = minSizeState.getMinSize();
                            long childConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : RangesKt.coerceIn(IntSize.m6975getWidthimpl(minSize), Constraints.m6746getMinWidthimpl(constraints), Constraints.m6744getMaxWidthimpl(constraints)), (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : RangesKt.coerceIn(IntSize.m6974getHeightimpl(minSize), Constraints.m6745getMinHeightimpl(constraints), Constraints.m6743getMaxHeightimpl(constraints)), (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
                            final Placeable measured = measurable.mo5644measureBRTryo0(childConstraints);
                            return MeasureScope.CC.layout$default($this$layout, measured.getWidth(), measured.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                    Placeable.PlacementScope.placeRelative$default($this$layout2, measured, 0, 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifierLayout = LayoutModifierKt.layout(companion, (Function3) value$iv3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return modifierLayout;
            }
        }, 1, null);
    }
}
