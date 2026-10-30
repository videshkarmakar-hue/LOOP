package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0086\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0087\u0004¨\u0006("}, m195d2 = {"AnimatedContent", "", ExifInterface.LATITUDE_SOUTH, "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", "name", "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", JsonPOJOBuilder.DEFAULT_WITH_PREFIX, "animation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnimatedContentKt {
    public static final <S> void AnimatedContent(final S s, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment contentAlignment, String label, Function1<? super S, ? extends Object> function2, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) throws Throwable {
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function3;
        Alignment alignment;
        String label2;
        Function1<? super S, ? extends Object> function5;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function6;
        Alignment contentAlignment2;
        String label3;
        Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(2132720749);
        ComposerKt.sourceInformation($composer2, "C(AnimatedContent)P(5,4,6,1,3,2)139@7505L58,140@7579L136:AnimatedContent.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(s) : $composer2.changedInstance(s) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function3 = function1;
        } else if (($changed & 384) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            alignment = contentAlignment;
        } else if (($changed & 3072) == 0) {
            alignment = contentAlignment;
            $dirty |= $composer2.changed(alignment) ? 2048 : 1024;
        } else {
            alignment = contentAlignment;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            label2 = label;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 16384 : 8192;
        } else {
            label2 = label;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function5 = function2;
        } else if ((196608 & $changed) == 0) {
            function5 = function2;
            $dirty |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            function6 = function3;
            contentAlignment2 = alignment;
            label3 = label2;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            function6 = i3 != 0 ? new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.1
                @Override // kotlin.jvm.functions.Function1
                public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                    return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m320scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                }
            } : function3;
            contentAlignment2 = i4 != 0 ? Alignment.INSTANCE.getTopStart() : alignment;
            if (i5 != 0) {
                label2 = "AnimatedContent";
            }
            if (i6 != 0) {
                function5 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.2
                    @Override // kotlin.jvm.functions.Function1
                    public final S invoke(S s2) {
                        return s2;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2132720749, $dirty, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:138)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(s, label2, $composer2, ($dirty & 8) | ($dirty & 14) | (($dirty >> 9) & 112), 0);
            label3 = label2;
            AnimatedContent(transition, modifier3, function6, contentAlignment2, function5, function4, $composer2, ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function7 = function6;
            final Alignment alignment2 = contentAlignment2;
            final String str = label3;
            final Function1<? super S, ? extends Object> function8 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) throws Throwable {
                    AnimatedContentKt.AnimatedContent(s, modifier4, function7, alignment2, str, function8, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt.SizeTransform.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m284invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                }

                /* JADX INFO: renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m284invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean clip, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(clip, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition $this$togetherWith, ExitTransition exit) {
        return new ContentTransform($this$togetherWith, exit, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition $this$with, ExitTransition exit) {
        return new ContentTransform($this$with, exit, 0.0f, null, 12, null);
    }

    /* JADX WARN: Code duplicated, block: B:190:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:193:0x04df  */
    /* JADX WARN: Code duplicated, block: B:197:0x0512  */
    /* JADX WARN: Code duplicated, block: B:208:0x04e6 A[SYNTHETIC] */
    public static final <S> void AnimatedContent(final Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment contentAlignment, Function1<? super S, ? extends Object> function2, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) throws Throwable {
        Modifier modifier2;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function3;
        Alignment contentAlignment2;
        Function1<? super S, ? extends Object> function5;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        SnapshotStateList currentlyVisible;
        Modifier modifier3;
        AnimatedContentTransitionScopeImpl rootScope;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function6;
        Alignment contentAlignment3;
        MutableScatterMap contentMap;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function7;
        Object value$iv4;
        Object value$iv5;
        Function0<ComposeUiNode> function0;
        Modifier modifier4;
        SnapshotStateList $this$fastForEach$iv;
        int $i$f$fastForEach;
        int $changed$iv$iv;
        int index$iv;
        Alignment contentAlignment4;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function8;
        Function2 function9;
        Composer $composer2 = $composer.startRestartGroup(-114689412);
        ComposerKt.sourceInformation($composer2, "C(AnimatedContent)P(3,4,1,2)666@34062L7,667@34090L106,671@34284L51,672@34357L69,760@38912L58,761@39004L45,771@39323L52,762@39054L327:AnimatedContent.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(transition) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 384;
            function3 = function1;
        } else if (($changed & 384) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 3072;
            contentAlignment2 = contentAlignment;
        } else if (($changed & 3072) == 0) {
            contentAlignment2 = contentAlignment;
            $dirty |= $composer2.changed(contentAlignment2) ? 2048 : 1024;
        } else {
            contentAlignment2 = contentAlignment;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function5 = function2;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function5 = function2;
            $dirty |= $composer2.changedInstance(function5) ? 16384 : 8192;
        } else {
            function5 = function2;
        }
        if ((i & 16) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i3 != 0) {
                function3 = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.4
                    @Override // kotlin.jvm.functions.Function1
                    public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m320scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                    }
                };
            }
            if (i4 != 0) {
                contentAlignment2 = Alignment.INSTANCE.getTopStart();
            }
            if (i5 != 0) {
                function5 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.5
                    @Override // kotlin.jvm.functions.Function1
                    public final S invoke(S s) {
                        return s;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-114689412, $dirty2, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:665)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer2, -441511457, "CC(remember):AnimatedContent.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new AnimatedContentTransitionScopeImpl(transition, contentAlignment2, layoutDirection);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            AnimatedContentTransitionScopeImpl rootScope2 = (AnimatedContentTransitionScopeImpl) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -441511263, "CC(remember):AnimatedContent.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            SnapshotStateList currentlyVisible2 = (SnapshotStateList) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -441511190, "CC(remember):AnimatedContent.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 14) == 4;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = ScatterMapKt.mutableScatterMapOf();
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            MutableScatterMap contentMap2 = (MutableScatterMap) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (!currentlyVisible2.contains(transition.getCurrentState())) {
                currentlyVisible2.clear();
                currentlyVisible2.add(transition.getCurrentState());
            }
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                if (currentlyVisible2.size() != 1 || !Intrinsics.areEqual(currentlyVisible2.get(0), transition.getCurrentState())) {
                    currentlyVisible2.clear();
                    currentlyVisible2.add(transition.getCurrentState());
                }
                if (contentMap2.get_size() != 1 || contentMap2.containsKey(transition.getCurrentState())) {
                    contentMap2.clear();
                }
                rootScope2.setContentAlignment(contentAlignment2);
                rootScope2.setLayoutDirection$animation_release(layoutDirection);
            }
            if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && !currentlyVisible2.contains(transition.getTargetState())) {
                SnapshotStateList $this$indexOfFirst$iv = currentlyVisible2;
                int $i$f$indexOfFirst = 0;
                int index$iv2 = 0;
                Iterator it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        index$iv2 = -1;
                        break;
                    }
                    List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                    int $i$f$indexOfFirst2 = $i$f$indexOfFirst;
                    Object objInvoke = function5.invoke(it.next());
                    Object it2 = transition.getTargetState();
                    if (Intrinsics.areEqual(objInvoke, function5.invoke(it2))) {
                        break;
                    }
                    index$iv2++;
                    $i$f$indexOfFirst = $i$f$indexOfFirst2;
                    $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                }
                int id = index$iv2;
                if (id == -1) {
                    currentlyVisible2.add(transition.getTargetState());
                } else {
                    currentlyVisible2.set(id, transition.getTargetState());
                }
            }
            $composer2.startReplaceGroup(-441509456);
            ComposerKt.sourceInformation($composer2, "*708@36303L2565");
            if (contentMap2.containsKey(transition.getTargetState()) && contentMap2.containsKey(transition.getCurrentState())) {
                currentlyVisible = currentlyVisible2;
                modifier3 = modifier2;
                rootScope = rootScope2;
                function6 = function3;
                contentAlignment3 = contentAlignment2;
                contentMap = contentMap2;
            } else {
                contentMap2.clear();
                SnapshotStateList $this$fastForEach$iv2 = currentlyVisible2;
                int index$iv3 = 0;
                int size = $this$fastForEach$iv2.size();
                while (index$iv3 < size) {
                    final Object item$iv = $this$fastForEach$iv2.get(index$iv3);
                    Alignment contentAlignment5 = contentAlignment2;
                    MutableScatterMap contentMap3 = contentMap2;
                    final SnapshotStateList currentlyVisible3 = currentlyVisible2;
                    final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function10 = function3;
                    Modifier modifier5 = modifier2;
                    final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = rootScope2;
                    contentMap3.set(item$iv, ComposableLambdaKt.rememberComposableLambda(885640742, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
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

                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                         */
                        public final void invoke(Composer $composer3, int $changed2) {
                            ContentTransform value$iv6;
                            Object value$iv7;
                            Object value$iv8;
                            Object value$iv9;
                            Object value$iv10;
                            Object value$iv11;
                            ComposerKt.sourceInformation($composer3, "C709@36339L38,713@36553L323,720@36909L125,731@37478L328,727@37286L25,738@37942L233,743@38194L660,725@37217L1637:AnimatedContent.kt#xbi5r1");
                            if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(885640742, $changed2, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:709)");
                            }
                            ComposerKt.sourceInformationMarkerStart($composer3, -1739561366, "CC(remember):AnimatedContent.kt#9igjgp");
                            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function11 = function10;
                            Object obj = animatedContentTransitionScopeImpl;
                            Object it$iv4 = $composer3.rememberedValue();
                            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv6 = function11.invoke(obj);
                                $composer3.updateRememberedValue(value$iv6);
                            } else {
                                value$iv6 = it$iv4;
                            }
                            final ContentTransform specOnEnter = (ContentTransform) value$iv6;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            boolean zAreEqual = Intrinsics.areEqual(transition.getSegment().getTargetState(), item$iv);
                            ComposerKt.sourceInformationMarkerStart($composer3, -1739561152, "CC(remember):AnimatedContent.kt#9igjgp");
                            boolean invalid$iv4 = $composer3.changed(zAreEqual);
                            Transition<S> transition2 = transition;
                            S s = item$iv;
                            Function1<AnimatedContentTransitionScope<S>, ContentTransform> function12 = function10;
                            Object obj2 = animatedContentTransitionScopeImpl;
                            Object it$iv5 = $composer3.rememberedValue();
                            if (invalid$iv4 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                value$iv7 = Intrinsics.areEqual(transition2.getSegment().getTargetState(), s) ? ExitTransition.INSTANCE.getNone() : function12.invoke(obj2).getInitialContentExit();
                                $composer3.updateRememberedValue(value$iv7);
                            } else {
                                value$iv7 = it$iv5;
                            }
                            final ExitTransition exit = (ExitTransition) value$iv7;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, -1739560796, "CC(remember):AnimatedContent.kt#9igjgp");
                            S s2 = item$iv;
                            Transition<S> transition3 = transition;
                            Object it$iv6 = $composer3.rememberedValue();
                            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                                value$iv8 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(s2, transition3.getTargetState()));
                                $composer3.updateRememberedValue(value$iv8);
                            } else {
                                value$iv8 = it$iv6;
                            }
                            AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) value$iv8;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EnterTransition targetContentEnter = specOnEnter.getTargetContentEnter();
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1739560227, "CC(remember):AnimatedContent.kt#9igjgp");
                            boolean invalid$iv5 = $composer3.changedInstance(specOnEnter);
                            Object it$iv7 = $composer3.rememberedValue();
                            if (invalid$iv5 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                                value$iv9 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                        return m283invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                    }

                                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m283invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                        final Placeable placeable = measurable.mo5644measureBRTryo0(constraints);
                                        int width = placeable.getWidth();
                                        int height = placeable.getHeight();
                                        final ContentTransform contentTransform = specOnEnter;
                                        return MeasureScope.CC.layout$default($this$layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                $this$layout2.place(placeable, 0, 0, contentTransform.getTargetContentZIndex());
                                            }
                                        }, 4, null);
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv9);
                            } else {
                                value$iv9 = it$iv7;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifierLayout = LayoutModifierKt.layout(companion, (Function3) value$iv9);
                            childData.setTarget(Intrinsics.areEqual(item$iv, transition.getTargetState()));
                            Modifier modifierThen = modifierLayout.then(childData);
                            Transition<S> transition4 = transition;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1739560419, "CC(remember):AnimatedContent.kt#9igjgp");
                            boolean invalid$iv6 = $composer3.changedInstance(item$iv);
                            final S s3 = item$iv;
                            Object it$iv8 = $composer3.rememberedValue();
                            if (invalid$iv6 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                value$iv10 = (Function1) new Function1<S, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(S s4) {
                                        return Boolean.valueOf(Intrinsics.areEqual(s4, s3));
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv10);
                            } else {
                                value$iv10 = it$iv8;
                            }
                            Function1 function13 = (Function1) value$iv10;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, -1739559763, "CC(remember):AnimatedContent.kt#9igjgp");
                            boolean invalid$iv7 = $composer3.changed(exit);
                            Object it$iv9 = $composer3.rememberedValue();
                            if (invalid$iv7 || it$iv9 == Composer.INSTANCE.getEmpty()) {
                                value$iv11 = new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Boolean invoke(EnterExitState currentState, EnterExitState targetState) {
                                        return Boolean.valueOf(currentState == EnterExitState.PostExit && targetState == EnterExitState.PostExit && !exit.getData().getHold());
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv11);
                            } else {
                                value$iv11 = it$iv9;
                            }
                            Function2 function14 = (Function2) value$iv11;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            final SnapshotStateList<S> snapshotStateList = currentlyVisible3;
                            final S s4 = item$iv;
                            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                            final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function15 = function4;
                            AnimatedVisibilityKt.AnimatedEnterExitImpl(transition4, function13, modifierThen, targetContentEnter, exit, function14, null, ComposableLambdaKt.rememberComposableLambda(-616195562, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                 */
                                /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
                                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v25 boolean
                                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                    	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
                                    */
                                public final void invoke(androidx.compose.animation.AnimatedVisibilityScope r13, androidx.compose.runtime.Composer r14, int r15) {
                                    /*
                                        Method dump skipped, instruction units count: 233
                                        To view this dump add '--comments-level debug' option
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.C01725.invoke(androidx.compose.animation.AnimatedVisibilityScope, androidx.compose.runtime.Composer, int):void");
                                }
                            }, $composer3, 54), $composer3, 12582912, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54));
                    index$iv3++;
                    size = size;
                    contentMap2 = contentMap3;
                    $this$fastForEach$iv2 = $this$fastForEach$iv2;
                    currentlyVisible2 = currentlyVisible3;
                    modifier2 = modifier5;
                    rootScope2 = rootScope2;
                    function3 = function3;
                    contentAlignment2 = contentAlignment5;
                }
                currentlyVisible = currentlyVisible2;
                modifier3 = modifier2;
                rootScope = rootScope2;
                function6 = function3;
                contentAlignment3 = contentAlignment2;
                contentMap = contentMap2;
            }
            $composer2.endReplaceGroup();
            Transition.Segment<S> segment = transition.getSegment();
            ComposerKt.sourceInformationMarkerStart($composer2, -441506635, "CC(remember):AnimatedContent.kt#9igjgp");
            AnimatedContentTransitionScopeImpl rootScope3 = rootScope;
            boolean invalid$iv4 = $composer2.changed(segment) | $composer2.changed(rootScope3);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                function7 = function6;
                value$iv4 = function7.invoke(rootScope3);
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
                function7 = function6;
            }
            ContentTransform contentTransform = (ContentTransform) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier sizeModifier = rootScope3.createSizeAnimationModifier$animation_release(contentTransform, $composer2, 0);
            Modifier modifier6 = modifier3;
            Modifier modifierThen = modifier6.then(sizeModifier);
            ComposerKt.sourceInformationMarkerStart($composer2, -441506224, "CC(remember):AnimatedContent.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new AnimatedContentMeasurePolicy(rootScope3);
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv2 = ((384 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, animatedContentMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting()) {
                modifier4 = modifier6;
            } else {
                modifier4 = modifier6;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -740835268, "C:AnimatedContent.kt#xbi5r1");
                $composer2.startReplaceGroup(-441506388);
                ComposerKt.sourceInformation($composer2, "");
                $this$fastForEach$iv = currentlyVisible;
                $i$f$fastForEach = 0;
                $changed$iv$iv = $this$fastForEach$iv.size();
                index$iv = 0;
                while (index$iv < $changed$iv$iv) {
                    Object item$iv2 = $this$fastForEach$iv.get(index$iv);
                    List $this$fastForEach$iv3 = $this$fastForEach$iv;
                    int i7 = $changed$iv$iv;
                    int $i$f$fastForEach2 = $i$f$fastForEach;
                    $composer2.startMovableGroup(-1739558516, function5.invoke(item$iv2));
                    ComposerKt.sourceInformation($composer2, "767@39247L8");
                    function9 = (Function2) contentMap.get(item$iv2);
                    if (function9 == null) {
                        function9.invoke($composer2, 0);
                    }
                    $composer2.endMovableGroup();
                    index$iv++;
                    $changed$iv$iv = i7;
                    $this$fastForEach$iv = $this$fastForEach$iv3;
                    $i$f$fastForEach = $i$f$fastForEach2;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                contentAlignment4 = contentAlignment3;
                function8 = function7;
            }
            $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
            $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = ($changed$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -740835268, "C:AnimatedContent.kt#xbi5r1");
            $composer2.startReplaceGroup(-441506388);
            ComposerKt.sourceInformation($composer2, "");
            $this$fastForEach$iv = currentlyVisible;
            $i$f$fastForEach = 0;
            $changed$iv$iv = $this$fastForEach$iv.size();
            index$iv = 0;
            while (index$iv < $changed$iv$iv) {
                Object item$iv3 = $this$fastForEach$iv.get(index$iv);
                List $this$fastForEach$iv4 = $this$fastForEach$iv;
                int i9 = $changed$iv$iv;
                int $i$f$fastForEach3 = $i$f$fastForEach;
                $composer2.startMovableGroup(-1739558516, function5.invoke(item$iv3));
                ComposerKt.sourceInformation($composer2, "767@39247L8");
                function9 = (Function2) contentMap.get(item$iv3);
                if (function9 == null) {
                    function9.invoke($composer2, 0);
                }
                $composer2.endMovableGroup();
                index$iv++;
                $changed$iv$iv = i9;
                $this$fastForEach$iv = $this$fastForEach$iv4;
                $i$f$fastForEach = $i$f$fastForEach3;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentAlignment4 = contentAlignment3;
            function8 = function7;
        } else {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            function8 = function3;
            contentAlignment4 = contentAlignment2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier4;
            final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function11 = function8;
            final Alignment alignment = contentAlignment4;
            final Function1<? super S, ? extends Object> function12 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) throws Throwable {
                    AnimatedContentKt.AnimatedContent(transition, modifier7, function11, alignment, function12, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
