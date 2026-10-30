package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.Outline;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.input.pointer.PointerIcon;
import androidx.compose.p001ui.input.pointer.PointerIconKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.UriHandler;
import androidx.compose.p001ui.semantics.CustomAccessibilityAction;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.LinkAnnotation;
import androidx.compose.p001ui.text.TextLayoutInput;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRangeKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.unit.IntRectKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextLinkScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020\u001a0 j\u0002`!H\u0002J\u001c\u0010\"\u001a\u0004\u0018\u00010#2\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020\u001a0 j\u0002`!H\u0002J\u001c\u0010$\u001a\u00020%*\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006)"}, m195d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "LinksComposables", "", "(Landroidx/compose/runtime/Composer;I)V", "handleLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "range", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/foundation/text/LinkRange;", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "textRange", "Landroidx/compose/ui/Modifier;", "start", "", "end", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextLinkScope {
    public static final int $stable = 0;
    private final AnnotatedString text;

    /* JADX INFO: renamed from: textLayoutResult$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public TextLinkScope(AnnotatedString text) {
        this.text = text;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextLayoutResult getTextLayoutResult() {
        State $this$getValue$iv = this.textLayoutResult;
        return (TextLayoutResult) $this$getValue$iv.getValue();
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        MutableState $this$setValue$iv = this.textLayoutResult;
        $this$setValue$iv.setValue(textLayoutResult);
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        return new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextLinkScope$shouldMeasureLinks$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextLayoutInput layoutInput;
                AnnotatedString text = this.this$0.getText();
                TextLayoutResult textLayoutResult = this.this$0.getTextLayoutResult();
                return Boolean.valueOf(Intrinsics.areEqual(text, (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : layoutInput.getText()));
            }
        };
    }

    private final Modifier textRange(Modifier $this$textRange, final int start, final int end) {
        return $this$textRange.then(new TextRangeLayoutModifier(new TextRangeScopeMeasurePolicy() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda0
            @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
            public final TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
                return TextLinkScope.textRange$lambda$0(this.f$0, start, end, textRangeLayoutMeasureScope);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult textRange$lambda$0(TextLinkScope this$0, int $start, int $end, TextRangeLayoutMeasureScope $this$$receiver) {
        TextLayoutResult layoutResult = this$0.getTextLayoutResult();
        if (layoutResult == null) {
            return $this$$receiver.layout(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$layoutResult$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ IntOffset invoke() {
                    return IntOffset.m6924boximpl(m1272invokenOccac());
                }

                /* JADX INFO: renamed from: invoke-nOcc-ac, reason: not valid java name */
                public final long m1272invokenOccac() {
                    return IntOffset.INSTANCE.m6943getZeronOccac();
                }
            });
        }
        final IntRect bounds = IntRectKt.roundToIntRect(layoutResult.getPathForRange($start, $end).getBounds());
        return $this$$receiver.layout(bounds.getWidth(), bounds.getHeight(), new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ IntOffset invoke() {
                return IntOffset.m6924boximpl(m1271invokenOccac());
            }

            /* JADX INFO: renamed from: invoke-nOcc-ac, reason: not valid java name */
            public final long m1271invokenOccac() {
                return bounds.m6961getTopLeftnOccac();
            }
        });
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> range) {
        final Path it = pathForRangeInRangeCoordinates(range);
        return it != null ? new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
            @Override // androidx.compose.p001ui.graphics.Shape
            /* JADX INFO: renamed from: createOutline-Pq9zytI */
            public Outline mo502createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                return new Outline.Generic(it);
            }
        } : null;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> range) {
        TextLayoutResult it;
        float xOffset;
        if (!getShouldMeasureLinks().invoke().booleanValue() || (it = getTextLayoutResult()) == null) {
            return null;
        }
        Path path = it.getPathForRange(range.getStart(), range.getEnd());
        Rect firstCharBoundingBox = it.getBoundingBox(range.getStart());
        Rect lastCharBoundingBox = it.getBoundingBox(range.getEnd() - 1);
        int rangeStartLine = it.getLineForOffset(range.getStart());
        int rangeEndLine = it.getLineForOffset(range.getEnd());
        if (rangeStartLine == rangeEndLine) {
            xOffset = Math.min(lastCharBoundingBox.getLeft(), firstCharBoundingBox.getLeft());
        } else {
            xOffset = 0.0f;
        }
        float yOffset = firstCharBoundingBox.getTop();
        path.mo4186translatek4lQ0M(Offset.m4058unaryMinusF1C5BW0(OffsetKt.Offset(xOffset, yOffset)));
        return path;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x011e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0121  */
    /* JADX WARN: Code duplicated, block: B:43:0x0145  */
    public final void LinksComposables(Composer $composer, final int $changed) {
        Modifier.Companion clipModifier;
        List<AnnotatedString.Range<LinkAnnotation>> list;
        boolean z;
        boolean invalid$iv;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1154651354);
        ComposerKt.sourceInformation($composer2, "C(LinksComposables)134@5839L7,135@5888L7,*144@6247L891,161@7262L82,141@6127L1232:TextLinkScope.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(this) ? 4 : 2;
        }
        if (($dirty & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154651354, $dirty, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:133)");
            }
            ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localIndication);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Indication indication = (Indication) objConsume;
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final UriHandler uriHandler = (UriHandler) objConsume2;
            List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = this.text.getLinkAnnotations(0, this.text.length());
            List<AnnotatedString.Range<LinkAnnotation>> list2 = linkAnnotations;
            int size = list2.size();
            int index$iv = 0;
            while (index$iv < size) {
                Object item$iv = list2.get(index$iv);
                final AnnotatedString.Range<LinkAnnotation> range = (AnnotatedString.Range) item$iv;
                Shape shape = shapeForRange(range);
                if (shape == null || (clipModifier = ClipKt.clip(Modifier.INSTANCE, shape)) == null) {
                    clipModifier = Modifier.INSTANCE;
                }
                Modifier modifierTextRange = textRange(clipModifier, range.getStart(), range.getEnd());
                ComposerKt.sourceInformationMarkerStart($composer2, -566158285, "CC(remember):TextLinkScope.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(range);
                Object value$iv2 = $composer2.rememberedValue();
                if (!invalid$iv2) {
                    list = linkAnnotations;
                    if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    List<AnnotatedString.Range<LinkAnnotation>> list3 = list2;
                    Modifier modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SemanticsModifierKt.semantics$default(modifierTextRange, false, (Function1) value$iv2, 1, null), PointerIcon.INSTANCE.getHand(), false, 2, null);
                    ComposerKt.sourceInformationMarkerStart($composer2, -566157270, "CC(remember):TextLinkScope.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv = z | $composer2.changed(range) | $composer2.changedInstance(uriHandler);
                    Object it$iv = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
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
                                this.this$0.handleLink(range.getItem(), uriHandler);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    BoxKt.Box(ClickableKt.m488combinedClickableXVZzFYc(modifierPointerHoverIcon$default, null, indication, (252 & 4) != 0, (252 & 8) != 0 ? null : null, (252 & 16) != 0 ? null : null, (252 & 32) != 0 ? null : null, (252 & 64) != 0 ? null : null, (252 & 128) != 0 ? null : null, (Function0) value$iv), $composer2, 0);
                    index$iv++;
                    size = size;
                    linkAnnotations = list;
                    list2 = list3;
                    $dirty = $dirty;
                } else {
                    list = linkAnnotations;
                }
                value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1$1
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
                        if (range.getItem() instanceof LinkAnnotation.Clickable) {
                            SemanticsPropertiesKt.setCustomActions($this$semantics, CollectionsKt.listOf(new CustomAccessibilityAction("", new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1$1.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return true;
                                }
                            })));
                            SemanticsPropertiesKt.m6080setTextSelectionRangeFDrldGo($this$semantics, TextRangeKt.TextRange(range.getStart(), range.getEnd()));
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                List<AnnotatedString.Range<LinkAnnotation>> list4 = list2;
                Modifier modifierPointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SemanticsModifierKt.semantics$default(modifierTextRange, false, (Function1) value$iv2, 1, null), PointerIcon.INSTANCE.getHand(), false, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer2, -566157270, "CC(remember):TextLinkScope.kt#9igjgp");
                if (($dirty & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv = z | $composer2.changed(range) | $composer2.changedInstance(uriHandler);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                    value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
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
                            this.this$0.handleLink(range.getItem(), uriHandler);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
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
                            this.this$0.handleLink(range.getItem(), uriHandler);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BoxKt.Box(ClickableKt.m488combinedClickableXVZzFYc(modifierPointerHoverIcon$default2, null, indication, (252 & 4) != 0, (252 & 8) != 0 ? null : null, (252 & 16) != 0 ? null : null, (252 & 32) != 0 ? null : null, (252 & 64) != 0 ? null : null, (252 & 128) != 0 ? null : null, (Function0) value$iv), $composer2, 0);
                index$iv++;
                size = size;
                linkAnnotations = list;
                list2 = list4;
                $dirty = $dirty;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope.LinksComposables.2
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
                    TextLinkScope.this.LinksComposables(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        if (link instanceof LinkAnnotation.Url) {
            try {
                uriHandler.openUri(((LinkAnnotation.Url) link).getUrl());
            } catch (IllegalArgumentException e) {
            }
        } else {
            boolean z = link instanceof LinkAnnotation.Clickable;
        }
    }
}
