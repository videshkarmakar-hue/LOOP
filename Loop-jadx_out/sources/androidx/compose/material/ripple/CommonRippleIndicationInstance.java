package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CommonRipple.kt */
/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(m194d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\u0010\fJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\f\u0010\u001d\u001a\u00020\u0015*\u00020\u001eH\u0016J\u001e\u0010\u001f\u001a\u00020\u0015*\u00020 2\u0006\u0010\u0007\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, m195d2 = {"Landroidx/compose/material/ripple/CommonRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "ripples", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "targetRadius", "", "addRipple", "", Route.INTERACTION, "scope", "Lkotlinx/coroutines/CoroutineScope;", "onAbandoned", "onForgotten", "onRemembered", "removeRipple", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawRipples-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;
    private final State<Color> color;
    private final float radius;
    private final State<RippleAlpha> rippleAlpha;
    private final SnapshotStateMap<PressInteraction.Press, RippleAnimation> ripples;
    private float targetRadius;

    public /* synthetic */ CommonRippleIndicationInstance(boolean z, float f, State state, State state2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state, state2);
    }

    private CommonRippleIndicationInstance(boolean bounded, float radius, State<Color> state, State<RippleAlpha> state2) {
        super(bounded, state2);
        this.bounded = bounded;
        this.radius = radius;
        this.color = state;
        this.rippleAlpha = state2;
        this.ripples = SnapshotStateKt.mutableStateMapOf();
        this.targetRadius = Float.NaN;
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(ContentDrawScope $this$drawIndication) {
        float fM1892getRippleEndRadiuscSwnlzA;
        float $this$isUnspecified$iv = this.radius;
        if (Float.isNaN($this$isUnspecified$iv)) {
            fM1892getRippleEndRadiuscSwnlzA = RippleAnimationKt.m1892getRippleEndRadiuscSwnlzA($this$drawIndication, this.bounded, $this$drawIndication.mo4773getSizeNHjbRc());
        } else {
            fM1892getRippleEndRadiuscSwnlzA = $this$drawIndication.mo567toPx0680j_4(this.radius);
        }
        this.targetRadius = fM1892getRippleEndRadiuscSwnlzA;
        long color = this.color.getValue().m4301unboximpl();
        $this$drawIndication.drawContent();
        m1897drawStateLayerH2RKhps($this$drawIndication, this.radius, color);
        m1890drawRipples4WTKRHQ($this$drawIndication, color);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction.Press interaction, CoroutineScope scope) {
        Map $this$forEach$iv = this.ripples;
        Iterator<Map.Entry<PressInteraction.Press, RippleAnimation>> it = $this$forEach$iv.entrySet().iterator();
        while (it.hasNext()) {
            RippleAnimation ripple = it.next().getValue();
            ripple.finish();
        }
        Offset origin = this.bounded ? Offset.m4038boximpl(interaction.getPressPosition()) : null;
        RippleAnimation rippleAnimation = new RippleAnimation(origin, this.targetRadius, this.bounded, null);
        this.ripples.put(interaction, rippleAnimation);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C11842(rippleAnimation, this, interaction, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2 */
    /* JADX INFO: compiled from: CommonRipple.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2", m210f = "CommonRipple.kt", m211i = {}, m212l = {153}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C11842 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressInteraction.Press $interaction;
        final /* synthetic */ RippleAnimation $rippleAnimation;
        int label;
        final /* synthetic */ CommonRippleIndicationInstance this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11842(RippleAnimation rippleAnimation, CommonRippleIndicationInstance commonRippleIndicationInstance, PressInteraction.Press press, Continuation<? super C11842> continuation) {
            super(2, continuation);
            this.$rippleAnimation = rippleAnimation;
            this.this$0 = commonRippleIndicationInstance;
            this.$interaction = press;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11842(this.$rippleAnimation, this.this$0, this.$interaction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11842) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Throwable th;
            C11842 c11842;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        this.label = 1;
                        if (this.$rippleAnimation.animate(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c11842 = this;
                        c11842.this$0.ripples.remove(c11842.$interaction);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        c11842 = this;
                        c11842.this$0.ripples.remove(c11842.$interaction);
                        throw th;
                    }
                case 1:
                    c11842 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        c11842.this$0.ripples.remove(c11842.$interaction);
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        c11842.this$0.ripples.remove(c11842.$interaction);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction.Press interaction) {
        RippleAnimation rippleAnimation = this.ripples.get(interaction);
        if (rippleAnimation != null) {
            rippleAnimation.finish();
        }
    }

    /* JADX INFO: renamed from: drawRipples-4WTKRHQ, reason: not valid java name */
    private final void m1890drawRipples4WTKRHQ(DrawScope $this$drawRipples_u2d4WTKRHQ, long color) {
        Map $this$forEach$iv = this.ripples;
        Iterator<Map.Entry<PressInteraction.Press, RippleAnimation>> it = $this$forEach$iv.entrySet().iterator();
        while (it.hasNext()) {
            RippleAnimation ripple = it.next().getValue();
            float alpha = this.rippleAlpha.getValue().getPressedAlpha();
            if (!(alpha == 0.0f)) {
                ripple.m1891draw4WTKRHQ($this$drawRipples_u2d4WTKRHQ, Color.m4289copywmQWz5c(color, (14 & 1) != 0 ? Color.m4293getAlphaimpl(color) : alpha, (14 & 2) != 0 ? Color.m4297getRedimpl(color) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(color) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(color) : 0.0f));
            }
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() throws Throwable {
        this.ripples.clear();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() throws Throwable {
        this.ripples.clear();
    }
}
