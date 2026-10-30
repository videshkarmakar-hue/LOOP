package androidx.compose.material.ripple;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorProducer;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.node.DrawModifierNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: CommonRipple.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\f\u0010\u001d\u001a\u00020\u0013*\u00020\u001eH\u0016R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m195d2 = {"Landroidx/compose/material/ripple/CommonRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ripples", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "addRipple", "", Route.INTERACTION, "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", "", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "onDetach", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "material-ripple_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CommonRippleNode extends RippleNode {
    public static final int $stable = 8;
    private final MutableScatterMap<PressInteraction.Press, RippleAnimation> ripples;

    public /* synthetic */ CommonRippleNode(InteractionSource interactionSource, boolean z, float f, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z, f, colorProducer, function0);
    }

    private CommonRippleNode(InteractionSource interactionSource, boolean bounded, float radius, ColorProducer color, Function0<RippleAlpha> function0) {
        super(interactionSource, bounded, radius, color, function0, null);
        this.ripples = new MutableScatterMap<>(0, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x006c A[LOOP:0: B:4:0x0017->B:17:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x0078 A[EDGE_INSN: B:27:0x0078->B:20:0x0078 BREAK  A[LOOP:0: B:4:0x0017->B:17:0x006c], SYNTHETIC] */
    @Override // androidx.compose.material.ripple.RippleNode
    /* JADX INFO: renamed from: addRipple-12SF9DM */
    public void mo1888addRipple12SF9DM(PressInteraction.Press interaction, long size, float targetRadius) {
        ScatterMap this_$iv = this.ripples;
        int $i$f$forEach = 0;
        Object[] k$iv = this_$iv.keys;
        Object[] v$iv = this_$iv.values;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                ScatterMap this_$iv2 = this_$iv;
                int $i$f$forEach2 = $i$f$forEach;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i$iv$iv != lastIndex$iv$iv) {
                        break;
                        break;
                    } else {
                        i$iv$iv++;
                        this_$iv = this_$iv2;
                        $i$f$forEach = $i$f$forEach2;
                    }
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            Object obj = k$iv[index$iv$iv];
                            RippleAnimation ripple = (RippleAnimation) v$iv[index$iv$iv];
                            ripple.finish();
                        }
                        slot$iv$iv >>= 8;
                    }
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                    if (i$iv$iv != lastIndex$iv$iv) {
                        break;
                    }
                    i$iv$iv++;
                    this_$iv = this_$iv2;
                    $i$f$forEach = $i$f$forEach2;
                }
            }
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        Offset origin = getBounded() ? Offset.m4038boximpl(interaction.getPressPosition()) : null;
        RippleAnimation rippleAnimation = new RippleAnimation(origin, targetRadius, getBounded(), defaultConstructorMarker);
        this.ripples.set(interaction, rippleAnimation);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CommonRippleNode$addRipple$2(rippleAnimation, this, interaction, null), 3, null);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void removeRipple(PressInteraction.Press interaction) {
        RippleAnimation rippleAnimation = this.ripples.get(interaction);
        if (rippleAnimation != null) {
            rippleAnimation.finish();
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void drawRipples(DrawScope $this$drawRipples) {
        int i$iv$iv;
        int lastIndex$iv$iv;
        long[] m$iv$iv;
        ScatterMap this_$iv$iv;
        float alpha = getRippleAlpha().invoke().getPressedAlpha();
        if (!(alpha == 0.0f)) {
            ScatterMap this_$iv = this.ripples;
            Object[] k$iv = this_$iv.keys;
            Object[] v$iv = this_$iv.values;
            ScatterMap this_$iv$iv2 = this_$iv;
            long[] m$iv$iv2 = this_$iv$iv2.metadata;
            int lastIndex$iv$iv2 = m$iv$iv2.length - 2;
            if (0 > lastIndex$iv$iv2) {
                return;
            }
            int i$iv$iv2 = 0;
            while (true) {
                long slot$iv$iv = m$iv$iv2[i$iv$iv2];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                    long slot$iv$iv2 = slot$iv$iv;
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv2 & 255;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv2 << 3) + j$iv$iv;
                            Object obj = k$iv[index$iv$iv];
                            RippleAnimation ripple = (RippleAnimation) v$iv[index$iv$iv];
                            long j = m1900getRippleColor0d7_KjU();
                            ripple.m1891draw4WTKRHQ($this$drawRipples, Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : alpha, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f));
                        }
                        slot$iv$iv2 >>= 8;
                        j$iv$iv++;
                        this_$iv$iv2 = this_$iv$iv2;
                        m$iv$iv2 = m$iv$iv2;
                        i$iv$iv2 = i$iv$iv2;
                        lastIndex$iv$iv2 = lastIndex$iv$iv2;
                    }
                    i$iv$iv = i$iv$iv2;
                    lastIndex$iv$iv = lastIndex$iv$iv2;
                    m$iv$iv = m$iv$iv2;
                    this_$iv$iv = this_$iv$iv2;
                    if (bitCount$iv$iv != 8) {
                        return;
                    }
                } else {
                    i$iv$iv = i$iv$iv2;
                    lastIndex$iv$iv = lastIndex$iv$iv2;
                    m$iv$iv = m$iv$iv2;
                    this_$iv$iv = this_$iv$iv2;
                }
                int i$iv$iv3 = i$iv$iv;
                int lastIndex$iv$iv3 = lastIndex$iv$iv;
                if (i$iv$iv3 == lastIndex$iv$iv3) {
                    return;
                }
                i$iv$iv2 = i$iv$iv3 + 1;
                lastIndex$iv$iv2 = lastIndex$iv$iv3;
                this_$iv$iv2 = this_$iv$iv;
                m$iv$iv2 = m$iv$iv;
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.ripples.clear();
    }
}
