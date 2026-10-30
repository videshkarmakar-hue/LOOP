package androidx.compose.p001ui.platform;

import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.Owner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a;\u0010\u000b\u001a\u00020\f*\u00020\r2'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f¢\u0006\u0002\b\u0013H\u0086@¢\u0006\u0002\u0010\u0014\u001aE\u0010\u0015\u001a\u00020\f*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f¢\u0006\u0002\b\u0013H\u0082@¢\u0006\u0002\u0010\u0019\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m195d2 = {"LocalChainedPlatformTextInputInterceptor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "InterceptPlatformTextInput", "", "interceptor", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "establishTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interceptedTextInputSession", "Landroidx/compose/ui/node/Owner;", "chainedInterceptor", "session", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlatformTextInputModifierNodeKt {
    private static final ProvidableCompositionLocal<ChainedPlatformTextInputInterceptor> LocalChainedPlatformTextInputInterceptor = CompositionLocalKt.staticCompositionLocalOf(new Function0<ChainedPlatformTextInputInterceptor>() { // from class: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$LocalChainedPlatformTextInputInterceptor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChainedPlatformTextInputInterceptor invoke() {
            return null;
        }
    });

    /* JADX INFO: renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1 */
    /* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.platform.PlatformTextInputModifierNodeKt", m210f = "PlatformTextInputModifierNode.kt", m211i = {}, m212l = {139}, m213m = "establishTextInputSession", m214n = {}, m215s = {})
    static final class C18831 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C18831(Continuation<? super C18831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlatformTextInputModifierNodeKt.establishTextInputSession(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$interceptedTextInputSession$1 */
    /* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.platform.PlatformTextInputModifierNodeKt", m210f = "PlatformTextInputModifierNode.kt", m211i = {}, m212l = {190, 192}, m213m = "interceptedTextInputSession", m214n = {}, m215s = {})
    static final class C18841 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C18841(Continuation<? super C18841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlatformTextInputModifierNodeKt.interceptedTextInputSession(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object establishTextInputSession(PlatformTextInputModifierNode $this$establishTextInputSession, Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        C18831 c18831;
        if (continuation instanceof C18831) {
            c18831 = (C18831) continuation;
            if ((c18831.label & Integer.MIN_VALUE) != 0) {
                c18831.label -= Integer.MIN_VALUE;
            } else {
                c18831 = new C18831(continuation);
            }
        } else {
            c18831 = new C18831(continuation);
        }
        C18831 c18832 = c18831;
        Object $result = c18832.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c18832.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!$this$establishTextInputSession.getNode().getIsAttached()) {
                    throw new IllegalArgumentException("establishTextInputSession called from an unattached node".toString());
                }
                Owner owner = DelegatableNodeKt.requireOwner($this$establishTextInputSession);
                ChainedPlatformTextInputInterceptor handler = (ChainedPlatformTextInputInterceptor) DelegatableNodeKt.requireLayoutNode($this$establishTextInputSession).getCompositionLocalMap().get(LocalChainedPlatformTextInputInterceptor);
                c18832.label = 1;
                if (interceptedTextInputSession(owner, handler, function2, c18832) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }

    public static final void InterceptPlatformTextInput(final PlatformTextInputInterceptor interceptor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1315007550);
        ComposerKt.sourceInformation($composer2, "C(InterceptPlatformTextInput)P(1)159@7408L7,164@7795L89,172@8105L135:PlatformTextInputModifierNode.kt#itgzvw");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(interceptor) : $composer2.changedInstance(interceptor) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1315007550, $dirty, -1, "androidx.compose.ui.platform.InterceptPlatformTextInput (PlatformTextInputModifierNode.kt:158)");
            }
            ProvidableCompositionLocal<ChainedPlatformTextInputInterceptor> providableCompositionLocal = LocalChainedPlatformTextInputInterceptor;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ChainedPlatformTextInputInterceptor parent = (ChainedPlatformTextInputInterceptor) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer2, 1053277257, "CC(remember):PlatformTextInputModifierNode.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(parent);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new ChainedPlatformTextInputInterceptor(interceptor, parent);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ChainedPlatformTextInputInterceptor chainedInterceptor = (ChainedPlatformTextInputInterceptor) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            chainedInterceptor.updateInterceptor(interceptor);
            CompositionLocalKt.CompositionLocalProvider(LocalChainedPlatformTextInputInterceptor.provides(chainedInterceptor), function2, $composer2, ProvidedValue.$stable | ($dirty & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.InterceptPlatformTextInput.1
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

                public final void invoke(Composer composer, int i) {
                    PlatformTextInputModifierNodeKt.InterceptPlatformTextInput(interceptor, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object interceptedTextInputSession(Owner $this$interceptedTextInputSession, ChainedPlatformTextInputInterceptor chainedInterceptor, Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        C18841 c18841;
        if (continuation instanceof C18841) {
            c18841 = (C18841) continuation;
            if ((c18841.label & Integer.MIN_VALUE) != 0) {
                c18841.label -= Integer.MIN_VALUE;
            } else {
                c18841 = new C18841(continuation);
            }
        } else {
            c18841 = new C18841(continuation);
        }
        C18841 c18842 = c18841;
        Object $result = c18842.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c18842.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (chainedInterceptor == null) {
                    c18842.label = 1;
                    if ($this$interceptedTextInputSession.textInputSession(function2, c18842) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    throw new KotlinNothingValueException();
                }
                c18842.label = 2;
                if (chainedInterceptor.textInputSession($this$interceptedTextInputSession, function2, c18842) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw new KotlinNothingValueException();
            case 1:
                ResultKt.throwOnFailure($result);
                throw new KotlinNothingValueException();
            case 2:
                ResultKt.throwOnFailure($result);
                throw new KotlinNothingValueException();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
