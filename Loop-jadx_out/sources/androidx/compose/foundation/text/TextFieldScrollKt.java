package androidx.compose.foundation.text;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.LayoutModifier;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.input.TextFieldValue;
import androidx.compose.p001ui.text.input.TransformedText;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: TextFieldScroll.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a4\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000\u001a*\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0000¨\u0006\u001b"}, m195d2 = {"getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "", "textFieldWidth", "textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "textFieldScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldScrollKt {

    /* JADX INFO: compiled from: TextFieldScroll.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z);
    }

    public static final Modifier textFieldScrollable(Modifier $this$textFieldScrollable, final TextFieldScrollerPosition scrollerPosition, final MutableInteractionSource interactionSource, final boolean enabled) {
        return ComposedModifierKt.composed($this$textFieldScrollable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("textFieldScrollable");
                $this$null.getProperties().set("scrollerPosition", scrollerPosition);
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Code duplicated, block: B:38:0x00e7  */
            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                Object value$iv;
                Object value$iv2;
                boolean z;
                $composer.startReplaceGroup(805428266);
                ComposerKt.sourceInformation($composer, "C68@2918L7,70@3087L388,70@3063L412,83@3627L352:TextFieldScroll.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(805428266, $changed, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:68)");
                }
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer);
                boolean rtl = objConsume == LayoutDirection.Rtl;
                boolean reverseDirection = scrollerPosition.getOrientation() == Orientation.Vertical || !rtl;
                ComposerKt.sourceInformationMarkerStart($composer, 994171971, "CC(remember):TextFieldScroll.kt#9igjgp");
                boolean invalid$iv = $composer.changed(scrollerPosition);
                final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<Float, Float>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Float invoke(Float f) {
                            return invoke(f.floatValue());
                        }

                        public final Float invoke(float delta) {
                            float consumedDelta;
                            float newOffset = textFieldScrollerPosition.getOffset() + delta;
                            if (newOffset > textFieldScrollerPosition.getMaximum()) {
                                consumedDelta = textFieldScrollerPosition.getMaximum() - textFieldScrollerPosition.getOffset();
                            } else {
                                consumedDelta = newOffset < 0.0f ? -textFieldScrollerPosition.getOffset() : delta;
                            }
                            TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                            textFieldScrollerPosition2.setOffset(textFieldScrollerPosition2.getOffset() + consumedDelta);
                            return Float.valueOf(consumedDelta);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                final ScrollableState scrollableState = ScrollableStateKt.rememberScrollableState((Function1) value$iv, $composer, 0);
                ComposerKt.sourceInformationMarkerStart($composer, 994172511, "CC(remember):TextFieldScroll.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(scrollableState) | $composer.changed(scrollerPosition);
                final TextFieldScrollerPosition textFieldScrollerPosition2 = scrollerPosition;
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new ScrollableState(textFieldScrollerPosition2) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1

                        /* JADX INFO: renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
                        private final State canScrollBackward;

                        /* JADX INFO: renamed from: canScrollForward$delegate, reason: from kotlin metadata */
                        private final State canScrollForward;

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public float dispatchRawDelta(float delta) {
                            return this.$$delegate_0.dispatchRawDelta(delta);
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean isLastScrollBackward() {
                            return this.$$delegate_0.isLastScrollBackward();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean isLastScrollForward() {
                            return this.$$delegate_0.isLastScrollForward();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean isScrollInProgress() {
                            return this.$$delegate_0.isScrollInProgress();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
                            return this.$$delegate_0.scroll(mutatePriority, function2, continuation);
                        }

                        {
                            this.canScrollForward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollForward$2
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(textFieldScrollerPosition2.getOffset() < textFieldScrollerPosition2.getMaximum());
                                }
                            });
                            this.canScrollBackward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollBackward$2
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(textFieldScrollerPosition2.getOffset() > 0.0f);
                                }
                            });
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getCanScrollForward() {
                            State $this$getValue$iv = this.canScrollForward;
                            return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getCanScrollBackward() {
                            State $this$getValue$iv = this.canScrollBackward;
                            return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                C0777x4ee6fee2 wrappedScrollableState = (C0777x4ee6fee2) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier.Companion companion = Modifier.INSTANCE;
                Orientation orientation = scrollerPosition.getOrientation();
                if (enabled) {
                    if (scrollerPosition.getMaximum() == 0.0f) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
                Modifier scroll = ScrollableKt.scrollable(companion, wrappedScrollableState, orientation, (16 & 4) != 0 ? true : z, (16 & 8) != 0 ? false : reverseDirection, (16 & 16) != 0 ? null : null, (16 & 32) != 0 ? null : interactionSource);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return scroll;
            }
        });
    }

    public static final Modifier textFieldScroll(Modifier $this$textFieldScroll, TextFieldScrollerPosition scrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Function0<TextLayoutResultProxy> function0) {
        LayoutModifier layout;
        Orientation orientation = scrollerPosition.getOrientation();
        int cursorOffset = scrollerPosition.m1256getOffsetToFollow5zctL8(textFieldValue.getSelection());
        scrollerPosition.m1258setPreviousSelection5zctL8(textFieldValue.getSelection());
        TransformedText transformedText = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getText());
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                layout = new VerticalScrollLayoutModifier(scrollerPosition, cursorOffset, transformedText, function0);
                break;
            case 2:
                layout = new HorizontalScrollLayoutModifier(scrollerPosition, cursorOffset, transformedText, function0);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return ClipKt.clipToBounds($this$textFieldScroll).then(layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density $this$getCursorRectInScroller, int cursorOffset, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean rtl, int textFieldWidth) {
        float cursorLeft;
        float cursorRight;
        Rect cursorRect;
        Rect cursorRect2 = (textLayoutResult == null || (cursorRect = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(cursorOffset))) == null) ? Rect.INSTANCE.getZero() : cursorRect;
        int thickness = $this$getCursorRectInScroller.mo561roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (rtl) {
            cursorLeft = (textFieldWidth - cursorRect2.getLeft()) - thickness;
        } else {
            cursorLeft = cursorRect2.getLeft();
        }
        if (rtl) {
            cursorRight = textFieldWidth - cursorRect2.getLeft();
        } else {
            cursorRight = cursorRect2.getLeft() + thickness;
        }
        return Rect.copy$default(cursorRect2, cursorLeft, 0.0f, cursorRight, 0.0f, 10, null);
    }
}
