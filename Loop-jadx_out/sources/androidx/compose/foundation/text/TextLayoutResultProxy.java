package androidx.compose.foundation.text;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextLayoutResultProxy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010$J\u0016\u0010'\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010$R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, m195d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", DownloadUtil.CookieScheme.VALUE, "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "decorationBoxCoordinates", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setDecorationBoxCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getInnerTextFieldCoordinates", "setInnerTextFieldCoordinates", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getLineEnd", "", "lineIndex", "visibleEnd", "", "getLineForVerticalPosition", "vertical", "", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "translateDecorationToInnerCoordinates", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "(J)J", "translateInnerToDecorationCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextLayoutResultProxy {
    public static final int $stable = 8;
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult value, LayoutCoordinates innerTextFieldCoordinates, LayoutCoordinates decorationBoxCoordinates) {
        this.value = value;
        this.innerTextFieldCoordinates = innerTextFieldCoordinates;
        this.decorationBoxCoordinates = decorationBoxCoordinates;
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutResult, (i & 2) != 0 ? null : layoutCoordinates, (i & 4) != 0 ? null : layoutCoordinates2);
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m1264getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutResultProxy.m1265getOffsetForPosition3MmeM6k(j, z);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m1265getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        long coercedPosition = coerceInVisibleBounds ? m1263coercedInVisibleBoundsOfInputTextMKHz9U(position) : position;
        long relativePosition = m1267translateDecorationToInnerCoordinatesMKHz9U$foundation_release(coercedPosition);
        return this.value.m6223getOffsetForPositionk4lQ0M(relativePosition);
    }

    public final int getLineForVerticalPosition(float vertical) {
        long coercedPosition = m1263coercedInVisibleBoundsOfInputTextMKHz9U(OffsetKt.Offset(0.0f, vertical));
        float relativeVertical = Offset.m4050getYimpl(m1267translateDecorationToInnerCoordinatesMKHz9U$foundation_release(coercedPosition));
        return this.value.getLineForVerticalPosition(relativeVertical);
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy textLayoutResultProxy, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayoutResultProxy.getLineEnd(i, z);
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        return this.value.getLineEnd(lineIndex, visibleEnd);
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m1266isPositionOnTextk4lQ0M(long offset) {
        long visibleOffset = m1263coercedInVisibleBoundsOfInputTextMKHz9U(offset);
        long relativeOffset = m1267translateDecorationToInnerCoordinatesMKHz9U$foundation_release(visibleOffset);
        int line = this.value.getLineForVerticalPosition(Offset.m4050getYimpl(relativeOffset));
        return Offset.m4049getXimpl(relativeOffset) >= this.value.getLineLeft(line) && Offset.m4049getXimpl(relativeOffset) <= this.value.getLineRight(line);
    }

    /* JADX INFO: renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1267translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates it;
        LayoutCoordinates innerCoords = this.innerTextFieldCoordinates;
        if (innerCoords != null) {
            if (!innerCoords.isAttached()) {
                innerCoords = null;
            }
            if (innerCoords != null && (it = this.decorationBoxCoordinates) != null) {
                LayoutCoordinates layoutCoordinates = it.isAttached() ? it : null;
                if (layoutCoordinates != null) {
                    LayoutCoordinates decorationCoords = layoutCoordinates;
                    return innerCoords.mo5647localPositionOfR5De75A(decorationCoords, offset);
                }
            }
            return offset;
        }
        return offset;
    }

    /* JADX INFO: renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1268translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates it;
        LayoutCoordinates innerCoords = this.innerTextFieldCoordinates;
        if (innerCoords != null) {
            if (!innerCoords.isAttached()) {
                innerCoords = null;
            }
            if (innerCoords != null && (it = this.decorationBoxCoordinates) != null) {
                LayoutCoordinates layoutCoordinates = it.isAttached() ? it : null;
                if (layoutCoordinates != null) {
                    LayoutCoordinates decorationCoords = layoutCoordinates;
                    return decorationCoords.mo5647localPositionOfR5De75A(innerCoords, offset);
                }
            }
            return offset;
        }
        return offset;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    private final long m1263coercedInVisibleBoundsOfInputTextMKHz9U(long $this$coercedInVisibleBoundsOfInputText_u2dMK_u2dHz9U) {
        Rect zero;
        LayoutCoordinates innerTextFieldCoordinates = this.innerTextFieldCoordinates;
        if (innerTextFieldCoordinates != null) {
            if (innerTextFieldCoordinates.isAttached()) {
                LayoutCoordinates layoutCoordinates = this.decorationBoxCoordinates;
                zero = null;
                if (layoutCoordinates != null) {
                    zero = LayoutCoordinates.CC.localBoundingBoxOf$default(layoutCoordinates, innerTextFieldCoordinates, false, 2, null);
                }
            } else {
                zero = Rect.INSTANCE.getZero();
            }
            if (zero == null) {
                zero = Rect.INSTANCE.getZero();
            }
        } else {
            zero = Rect.INSTANCE.getZero();
        }
        Rect visibleInnerTextFieldRect = zero;
        return TextLayoutResultProxyKt.m1270coerceIn3MmeM6k($this$coercedInVisibleBoundsOfInputText_u2dMK_u2dHz9U, visibleInnerTextFieldRect);
    }
}
