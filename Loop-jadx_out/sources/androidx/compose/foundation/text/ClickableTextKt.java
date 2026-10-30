package androidx.compose.foundation.text;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.MultiParagraph;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ClickableText.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m195d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onHover", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-03UYbkw", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "containsWithinBounds", "Landroidx/compose/ui/text/MultiParagraph;", "positionOffset", "Landroidx/compose/ui/geometry/Offset;", "containsWithinBounds-Uv8p0NA", "(Landroidx/compose/ui/text/MultiParagraph;J)Z", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ClickableTextKt {
    /* JADX WARN: Code duplicated, block: B:144:0x0260  */
    /* JADX INFO: renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    public static final void m1163ClickableText4YKlhWE(final AnnotatedString text, Modifier modifier, TextStyle style, boolean softWrap, int overflow, int maxLines, Function1<? super TextLayoutResult, Unit> function1, final Function1<? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TextStyle style2;
        boolean z;
        int overflow2;
        Modifier modifier3;
        Object value$iv;
        Modifier modifier4;
        boolean softWrap2;
        int maxLines2;
        Function1<? super TextLayoutResult, Unit> function3;
        TextStyle style3;
        Composer $composer2 = $composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation($composer2, "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)79@3637L52,80@3746L184,95@4151L76,88@3936L297:ClickableText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            style2 = style;
        } else if (($changed & 384) == 0) {
            style2 = style;
            $dirty |= $composer2.changed(style2) ? 256 : 128;
        } else {
            style2 = style;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            z = softWrap;
        } else if (($changed & 3072) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = softWrap;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            overflow2 = overflow;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            maxLines2 = maxLines;
            function3 = function1;
            modifier4 = modifier2;
            softWrap2 = z;
            style3 = style2;
        } else {
            Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            boolean softWrap3 = i4 != 0 ? true : z;
            int overflow3 = i5 != 0 ? TextOverflow.INSTANCE.m6707getClipgIe3tQ8() : overflow2;
            int maxLines3 = i6 != 0 ? Integer.MAX_VALUE : maxLines;
            final ClickableTextKt$ClickableText$1 clickableTextKt$ClickableText$1 = i7 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-246609449, $dirty, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 48324525, "CC(remember):ClickableText.kt#9igjgp");
            Object value$iv2 = $composer2.rememberedValue();
            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            final MutableState layoutResult = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 48324634, "CC(remember):ClickableText.kt#9igjgp");
            boolean invalid$iv = (29360128 & $dirty) == 8388608;
            ClickableTextKt$ClickableText$pressIndicator$1$1 value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new ClickableTextKt$ClickableText$pressIndicator$1$1(layoutResult, function2, null);
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier pressIndicator = SuspendingPointerInputFilterKt.pointerInput(companion, function2, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3);
            Modifier modifierThen = modifier5.then(pressIndicator);
            ComposerKt.sourceInformationMarkerStart($composer2, 48325039, "CC(remember):ClickableText.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 3670016) == 1048576;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv2) {
                modifier3 = modifier5;
            } else {
                modifier3 = modifier5;
                if (it$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BasicTextKt.m1156BasicTextRWo7tUw(text, modifierThen, style2, (Function1) value$iv, overflow3, softWrap3, maxLines3, 0, null, null, $composer2, ($dirty & 14) | ($dirty & 896) | (57344 & $dirty) | (458752 & ($dirty << 6)) | (($dirty << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                softWrap2 = softWrap3;
                overflow2 = overflow3;
                maxLines2 = maxLines3;
                function3 = clickableTextKt$ClickableText$1;
                style3 = style2;
            }
            value$iv = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                    layoutResult.setValue(it);
                    clickableTextKt$ClickableText$1.invoke(it);
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BasicTextKt.m1156BasicTextRWo7tUw(text, modifierThen, style2, (Function1) value$iv, overflow3, softWrap3, maxLines3, 0, null, null, $composer2, ($dirty & 14) | ($dirty & 896) | (57344 & $dirty) | (458752 & ($dirty << 6)) | (($dirty << 3) & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            softWrap2 = softWrap3;
            overflow2 = overflow3;
            maxLines2 = maxLines3;
            function3 = clickableTextKt$ClickableText$1;
            style3 = style2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final TextStyle textStyle = style3;
            final boolean z2 = softWrap2;
            final int i8 = overflow2;
            final int i9 = maxLines2;
            final Function1<? super TextLayoutResult, Unit> function4 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
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
                    ClickableTextKt.m1163ClickableText4YKlhWE(text, modifier6, textStyle, z2, i8, i9, function4, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:162:0x0309  */
    /* JADX INFO: renamed from: ClickableText-03UYbkw, reason: not valid java name */
    public static final void m1162ClickableText03UYbkw(final AnnotatedString text, final Function1<? super Integer, Unit> function1, Modifier modifier, TextStyle style, boolean softWrap, int overflow, int maxLines, Function1<? super TextLayoutResult, Unit> function2, final Function1<? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TextStyle style2;
        boolean z;
        boolean softWrap2;
        int overflow2;
        int maxLines2;
        final ClickableTextKt$ClickableText$4 clickableTextKt$ClickableText$4;
        Object value$iv$iv;
        int maxLines3;
        Object value$iv;
        Modifier modifier3;
        Modifier modifier4;
        Function1<? super TextLayoutResult, Unit> function4;
        boolean softWrap3;
        int overflow3;
        TextStyle style3;
        Composer $composer2 = $composer.startRestartGroup(1020774372);
        ComposerKt.sourceInformation($composer2, "C(ClickableText)P(8,3,1,7,6,5:c#ui.text.style.TextOverflow!1,4)156@7018L52,157@7096L24,164@7396L413,186@8036L76,179@7815L303:ClickableText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            style2 = style;
        } else if (($changed & 3072) == 0) {
            style2 = style;
            $dirty |= $composer2.changed(style2) ? 2048 : 1024;
        } else {
            style2 = style;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            z = softWrap;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 16384 : 8192;
        } else {
            z = softWrap;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(overflow) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((38347923 & $dirty2) != 38347922 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i3 != 0) {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i4 == 0) {
                softWrap2 = z;
            } else {
                softWrap2 = true;
            }
            if (i5 == 0) {
                overflow2 = overflow;
            } else {
                overflow2 = TextOverflow.INSTANCE.m6707getClipgIe3tQ8();
            }
            if (i6 == 0) {
                maxLines2 = maxLines;
            } else {
                maxLines2 = Integer.MAX_VALUE;
            }
            if (i7 == 0) {
                clickableTextKt$ClickableText$4 = function2;
            } else {
                clickableTextKt$ClickableText$4 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1020774372, $dirty2, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:155)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 48327906, "CC(remember):ClickableText.kt#9igjgp");
            Object value$iv2 = $composer2.rememberedValue();
            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            final MutableState layoutResult = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 48328284, "CC(remember):ClickableText.kt#9igjgp");
            maxLines3 = maxLines2;
            boolean invalid$iv = (($dirty2 & 112) == 32) | $composer2.changedInstance(coroutineScope) | ((234881024 & $dirty2) == 67108864);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new ClickableTextKt$ClickableText$pointerInputModifier$1$1(coroutineScope, function1, layoutResult, function3, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier pointerInputModifier = SuspendingPointerInputFilterKt.pointerInput(companion, function3, function1, (Function2) value$iv);
            Modifier modifierThen = modifier2.then(pointerInputModifier);
            ComposerKt.sourceInformationMarkerStart($composer2, 48328924, "CC(remember):ClickableText.kt#9igjgp");
            boolean invalid$iv2 = (29360128 & $dirty2) == 8388608;
            Object value$iv3 = $composer2.rememberedValue();
            if (!invalid$iv2) {
                modifier3 = modifier2;
                if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BasicTextKt.m1156BasicTextRWo7tUw(text, modifierThen, style2, (Function1) value$iv3, overflow2, softWrap2, maxLines3, 0, null, null, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 896) | (($dirty2 >> 3) & 57344) | (458752 & ($dirty2 << 3)) | (3670016 & $dirty2), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                function4 = clickableTextKt$ClickableText$4;
                softWrap3 = softWrap2;
                overflow3 = overflow2;
                style3 = style2;
            } else {
                modifier3 = modifier2;
            }
            value$iv3 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                    layoutResult.setValue(it);
                    clickableTextKt$ClickableText$4.invoke(it);
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BasicTextKt.m1156BasicTextRWo7tUw(text, modifierThen, style2, (Function1) value$iv3, overflow2, softWrap2, maxLines3, 0, null, null, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 896) | (($dirty2 >> 3) & 57344) | (458752 & ($dirty2 << 3)) | (3670016 & $dirty2), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            function4 = clickableTextKt$ClickableText$4;
            softWrap3 = softWrap2;
            overflow3 = overflow2;
            style3 = style2;
        } else {
            $composer2.skipToGroupEnd();
            overflow3 = overflow;
            maxLines3 = maxLines;
            function4 = function2;
            modifier4 = modifier2;
            softWrap3 = z;
            style3 = style2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final TextStyle textStyle = style3;
            final boolean z2 = softWrap3;
            final int i8 = overflow3;
            final int i9 = maxLines3;
            final Function1<? super TextLayoutResult, Unit> function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$6
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
                    ClickableTextKt.m1162ClickableText03UYbkw(text, function1, modifier5, textStyle, z2, i8, i9, function5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> mutableState, long positionOffset) {
        MultiParagraph it;
        TextLayoutResult value = mutableState.getValue();
        if (value == null || (it = value.getMultiParagraph()) == null) {
            return null;
        }
        if (!m1164containsWithinBoundsUv8p0NA(it, positionOffset)) {
            it = null;
        }
        if (it != null) {
            return Integer.valueOf(it.m6116getOffsetForPositionk4lQ0M(positionOffset));
        }
        return null;
    }

    /* JADX INFO: renamed from: containsWithinBounds-Uv8p0NA, reason: not valid java name */
    private static final boolean m1164containsWithinBoundsUv8p0NA(MultiParagraph $this$containsWithinBounds_u2dUv8p0NA, long positionOffset) {
        float x = Offset.m4049getXimpl(positionOffset);
        float y = Offset.m4050getYimpl(positionOffset);
        return x > 0.0f && y >= 0.0f && x <= $this$containsWithinBounds_u2dUv8p0NA.getWidth() && y <= $this$containsWithinBounds_u2dUv8p0NA.getHeight();
    }
}
