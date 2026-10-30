package androidx.compose.ui.node;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectFloatMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LookaheadDelegate.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001bB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010<\u001a\u00020=2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010>\u001a\u000202H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH&J\u0017\u0010C\u001a\u00020=2\b\u0010D\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0002\bEJ\u0010\u0010C\u001a\u00020=2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020\u00002\u0006\u0010>\u001a\u000202H\u0002J\u0016\u0010I\u001a\u00020J2\u0006\u0010>\u001a\u0002022\u0006\u0010K\u001a\u00020JJ\u0011\u0010L\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0086\u0002J\u0010\u0010M\u001a\u00020=2\u0006\u0010>\u001a\u000202H\u0002J`\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u00020@2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020@0R2\u0019\u0010S\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020=\u0018\u00010T¢\u0006\u0002\bU2\u0017\u0010V\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020=0T¢\u0006\u0002\bUH\u0016J&\u0010W\u001a\u00020=2\u001c\u0010X\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001f04j\b\u0012\u0004\u0012\u00020\u001f`503H\u0002J\u0016\u0010Y\u001a\u00020=2\u0006\u0010>\u001a\u0002022\u0006\u0010Z\u001a\u00020JJ\u0016\u0010[\u001a\u00020=2\u0006\u0010>\u001a\u0002022\u0006\u0010Z\u001a\u00020JJ\r\u0010\\\u001a\u00020=H ¢\u0006\u0002\b]J\f\u0010^\u001a\u00020=*\u00020_H\u0004J\u0014\u0010`\u001a\u00020\u0012*\u00020\u001f2\u0006\u0010a\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001aR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X \u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\fR\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\u00020-X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b.\u0010/R2\u00100\u001a&\u0012\u0004\u0012\u000202\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001f04j\b\u0012\u0004\u0012\u00020\u001f`503\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u00109\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006c"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "()V", "_rulerScope", "Landroidx/compose/ui/layout/RulerScope;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "isLookingAhead$annotations", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "(Z)V", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "parent", "getParent", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/node/WeakReference;", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/layout/RulerScope;", "rulerValues", "Landroidx/collection/MutableObjectFloatMap;", "rulerValuesCache", "addRulerReader", "", "ruler", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "captureRulers", "result", "captureRulers$ui_release", "placeableResult", "Landroidx/compose/ui/node/PlaceableResult;", "findAncestorRulerDefiner", "findRulerValue", "", "defaultValue", "get", "invalidateChildrenOfDefiningRuler", "layout", "width", "height", "alignmentLines", "", "rulers", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "notifyRulerValueChange", "layoutNodes", "provideRelativeRulerValue", DownloadUtil.CookieScheme.VALUE, "provideRulerValue", "replace", "replace$ui_release", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLayoutNodeAncestor", "ancestor", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode {
    public static final int $stable = 0;
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlaceableResult placeableResult) {
            invoke2(placeableResult);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlaceableResult result) {
            if (result.isValidOwnerScope()) {
                result.getPlaceable().captureRulers(result);
            }
        }
    };
    private RulerScope _rulerScope;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private MutableObjectFloatMap<Ruler> rulerValues;
    private MutableObjectFloatMap<Ruler> rulerValuesCache;

    public static /* synthetic */ void isLookingAhead$annotations() {
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long getPosition();

    @Override // androidx.compose.ui.layout.MeasureScope
    public /* synthetic */ MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return MeasureScope.CC.$default$layout(this, i, i2, map, function1);
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo312roundToPxR2X_6o(long j) {
        return Density.CC.m6517$default$roundToPxR2X_6o(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo313roundToPx0680j_4(float f) {
        return Density.CC.m6518$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo314toDpGaN1DYA(long j) {
        return FontScaling.CC.m6662$default$toDpGaN1DYA(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo315toDpu2uoSUM(float f) {
        return Density.CC.m6519$default$toDpu2uoSUM(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo316toDpu2uoSUM(int i) {
        return Density.CC.m6520$default$toDpu2uoSUM((Density) this, i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo317toDpSizekrfVVM(long j) {
        return Density.CC.m6521$default$toDpSizekrfVVM(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo318toPxR2X_6o(long j) {
        return Density.CC.m6522$default$toPxR2X_6o(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo319toPx0680j_4(float f) {
        return Density.CC.m6523$default$toPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo320toSizeXkaWNTQ(long j) {
        return Density.CC.m6524$default$toSizeXkaWNTQ(this, j);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo321toSp0xMU5do(float f) {
        return FontScaling.CC.m6663$default$toSp0xMU5do(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo322toSpkPz2Gy4(float f) {
        return Density.CC.m6525$default$toSpkPz2Gy4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo323toSpkPz2Gy4(int i) {
        return Density.CC.m6526$default$toSpkPz2Gy4((Density) this, i);
    }

    public final RulerScope getRulerScope() {
        RulerScope rulerScope = this._rulerScope;
        return rulerScope == null ? new RulerScope() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$rulerScope$1
            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: roundToPx--R2X_6o */
            public /* synthetic */ int mo312roundToPxR2X_6o(long j) {
                return Density.CC.m6517$default$roundToPxR2X_6o(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: roundToPx-0680j_4 */
            public /* synthetic */ int mo313roundToPx0680j_4(float f) {
                return Density.CC.m6518$default$roundToPx0680j_4(this, f);
            }

            @Override // androidx.compose.ui.unit.FontScaling
            /* JADX INFO: renamed from: toDp-GaN1DYA */
            public /* synthetic */ float mo314toDpGaN1DYA(long j) {
                return FontScaling.CC.m6662$default$toDpGaN1DYA(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toDp-u2uoSUM */
            public /* synthetic */ float mo315toDpu2uoSUM(float f) {
                return Density.CC.m6519$default$toDpu2uoSUM(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toDp-u2uoSUM */
            public /* synthetic */ float mo316toDpu2uoSUM(int i) {
                return Density.CC.m6520$default$toDpu2uoSUM((Density) this, i);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toDpSize-k-rfVVM */
            public /* synthetic */ long mo317toDpSizekrfVVM(long j) {
                return Density.CC.m6521$default$toDpSizekrfVVM(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toPx--R2X_6o */
            public /* synthetic */ float mo318toPxR2X_6o(long j) {
                return Density.CC.m6522$default$toPxR2X_6o(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toPx-0680j_4 */
            public /* synthetic */ float mo319toPx0680j_4(float f) {
                return Density.CC.m6523$default$toPx0680j_4(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            public /* synthetic */ Rect toRect(DpRect dpRect) {
                return Density.CC.$default$toRect(this, dpRect);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toSize-XkaWNTQ */
            public /* synthetic */ long mo320toSizeXkaWNTQ(long j) {
                return Density.CC.m6524$default$toSizeXkaWNTQ(this, j);
            }

            @Override // androidx.compose.ui.unit.FontScaling
            /* JADX INFO: renamed from: toSp-0xMU5do */
            public /* synthetic */ long mo321toSp0xMU5do(float f) {
                return FontScaling.CC.m6663$default$toSp0xMU5do(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toSp-kPz2Gy4 */
            public /* synthetic */ long mo322toSpkPz2Gy4(float f) {
                return Density.CC.m6525$default$toSpkPz2Gy4(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            /* JADX INFO: renamed from: toSp-kPz2Gy4 */
            public /* synthetic */ long mo323toSpkPz2Gy4(int i) {
                return Density.CC.m6526$default$toSpkPz2Gy4((Density) this, i);
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public LayoutCoordinates getCoordinates() {
                this.this$0.getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
                return this.this$0.getCoordinates();
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public void provides(Ruler $this$provides, float value) {
                this.this$0.provideRulerValue($this$provides, value);
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public void providesRelative(VerticalRuler $this$providesRelative, float value) {
                this.this$0.provideRelativeRulerValue($this$providesRelative, value);
            }

            @Override // androidx.compose.ui.unit.Density
            public float getDensity() {
                return this.this$0.getDensity();
            }

            @Override // androidx.compose.ui.unit.FontScaling
            public float getFontScale() {
                return this.this$0.getFontScale();
            }
        } : rulerScope;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int measuredPosition;
        int iM6686getYimpl;
        if (!getHasMeasureResult() || (measuredPosition = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            iM6686getYimpl = IntOffset.m6685getXimpl(getApparentToRealOffset());
        } else {
            iM6686getYimpl = IntOffset.m6686getYimpl(getApparentToRealOffset());
        }
        return iM6686getYimpl + measuredPosition;
    }

    /* JADX INFO: renamed from: isShallowPlacing$ui_release, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    /* JADX INFO: renamed from: isPlacingForAlignment$ui_release, reason: from getter */
    public final boolean getIsPlacingForAlignment() {
        return this.isPlacingForAlignment;
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    protected final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator $this$invalidateAlignmentLinesFromPositionChange) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped = $this$invalidateAlignmentLinesFromPositionChange.getWrapped();
        if (!Intrinsics.areEqual(wrapped != null ? wrapped.getLayoutNode() : null, $this$invalidateAlignmentLinesFromPositionChange.getLayoutNode())) {
            $this$invalidateAlignmentLinesFromPositionChange.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = $this$invalidateAlignmentLinesFromPositionChange.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    public final float findRulerValue(Ruler ruler, float defaultValue) {
        if (this.isPlacingForAlignment) {
            return defaultValue;
        }
        LookaheadCapablePlaceable p = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = p.rulerValues;
            float rulerValue = mutableObjectFloatMap != null ? mutableObjectFloatMap.getOrDefault(ruler, Float.NaN) : Float.NaN;
            if (!Float.isNaN(rulerValue)) {
                p.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui_release(rulerValue, p.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = p.getParent();
            if (parent == null) {
                p.addRulerReader(getLayoutNode(), ruler);
                return defaultValue;
            }
            p = parent;
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00da  */
    private final void addRulerReader(LayoutNode layoutNode, Ruler ruler) {
        int $i$f$removeIf;
        int $i$f$removeIf2;
        ScatterMap this_$iv;
        int $i$f$forEachValue;
        Object[] v$iv;
        ScatterMap this_$iv$iv;
        ScatterMap this_$iv2;
        int $i$f$forEachValue2;
        Object[] v$iv2;
        ScatterMap this_$iv$iv2;
        long[] m$iv$iv;
        ScatterSet this_$iv$iv3;
        long[] m$iv$iv2;
        ScatterSet this_$iv$iv4;
        boolean z;
        boolean z2;
        ScatterMap scatterMap = this.rulerReaders;
        char c = 7;
        long j = -9187201950435737472L;
        if (scatterMap != null) {
            ScatterMap this_$iv3 = scatterMap;
            int $i$f$forEachValue3 = 0;
            Object[] v$iv3 = this_$iv3.values;
            ScatterMap this_$iv$iv5 = this_$iv3;
            long[] m$iv$iv3 = this_$iv$iv5.metadata;
            int lastIndex$iv$iv = m$iv$iv3.length - 2;
            int i$iv$iv = 0;
            if (0 <= lastIndex$iv$iv) {
                while (true) {
                    long slot$iv$iv = m$iv$iv3[i$iv$iv];
                    int lastIndex$iv$iv2 = lastIndex$iv$iv;
                    if ((((~slot$iv$iv) << c) & slot$iv$iv & j) == j) {
                        this_$iv = this_$iv3;
                        $i$f$forEachValue = $i$f$forEachValue3;
                        v$iv = v$iv3;
                        this_$iv$iv = this_$iv$iv5;
                    } else {
                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv2)) >>> 31);
                        int j$iv$iv = 0;
                        while (j$iv$iv < bitCount$iv$iv) {
                            long value$iv$iv$iv = slot$iv$iv & 255;
                            int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                            if ($i$f$isFull == 0) {
                                this_$iv2 = this_$iv3;
                                $i$f$forEachValue2 = $i$f$forEachValue3;
                                v$iv2 = v$iv3;
                                this_$iv$iv2 = this_$iv$iv5;
                            } else {
                                int i = 0;
                                MutableScatterSet set = (MutableScatterSet) v$iv3[(i$iv$iv << 3) + j$iv$iv];
                                Object[] elements$iv = set.elements;
                                MutableScatterSet this_$iv$iv6 = set;
                                this_$iv2 = this_$iv3;
                                long[] m$iv$iv4 = this_$iv$iv6.metadata;
                                int lastIndex$iv$iv3 = m$iv$iv4.length - 2;
                                int i$iv$iv2 = 0;
                                if (0 <= lastIndex$iv$iv3) {
                                    while (true) {
                                        long slot$iv$iv2 = m$iv$iv4[i$iv$iv2];
                                        int i2 = i;
                                        $i$f$forEachValue2 = $i$f$forEachValue3;
                                        v$iv2 = v$iv3;
                                        this_$iv$iv2 = this_$iv$iv5;
                                        long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L);
                                        if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                                            m$iv$iv = m$iv$iv4;
                                            this_$iv$iv3 = this_$iv$iv6;
                                        } else {
                                            int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv3)) >>> 31);
                                            int j$iv$iv2 = 0;
                                            while (j$iv$iv2 < bitCount$iv$iv2) {
                                                long value$iv$iv$iv2 = slot$iv$iv2 & 255;
                                                int $i$f$isFull2 = value$iv$iv$iv2 < 128 ? 1 : 0;
                                                if ($i$f$isFull2 == 0) {
                                                    m$iv$iv2 = m$iv$iv4;
                                                    this_$iv$iv4 = this_$iv$iv6;
                                                } else {
                                                    int index$iv$iv = (i$iv$iv2 << 3) + j$iv$iv2;
                                                    WeakReference it = (WeakReference) elements$iv[index$iv$iv];
                                                    LayoutNode layoutNode2 = (LayoutNode) it.get();
                                                    if (layoutNode2 != null) {
                                                        m$iv$iv2 = m$iv$iv4;
                                                        boolean zIsAttached = layoutNode2.isAttached();
                                                        this_$iv$iv4 = this_$iv$iv6;
                                                        z = true;
                                                        z2 = zIsAttached;
                                                        if (z2 ^ z) {
                                                            set.removeElementAt(index$iv$iv);
                                                        }
                                                    } else {
                                                        m$iv$iv2 = m$iv$iv4;
                                                        this_$iv$iv4 = this_$iv$iv6;
                                                        z = true;
                                                    }
                                                    if (z2 ^ z) {
                                                        set.removeElementAt(index$iv$iv);
                                                    }
                                                }
                                                slot$iv$iv2 >>= 8;
                                                j$iv$iv2++;
                                                this_$iv$iv6 = this_$iv$iv4;
                                                m$iv$iv4 = m$iv$iv2;
                                            }
                                            m$iv$iv = m$iv$iv4;
                                            this_$iv$iv3 = this_$iv$iv6;
                                            if (bitCount$iv$iv2 != 8) {
                                                break;
                                            }
                                        }
                                        if (i$iv$iv2 == lastIndex$iv$iv3) {
                                            break;
                                        }
                                        i$iv$iv2++;
                                        v$iv3 = v$iv2;
                                        this_$iv$iv5 = this_$iv$iv2;
                                        $i$f$forEachValue3 = $i$f$forEachValue2;
                                        i = i2;
                                        this_$iv$iv6 = this_$iv$iv3;
                                        m$iv$iv4 = m$iv$iv;
                                    }
                                } else {
                                    $i$f$forEachValue2 = $i$f$forEachValue3;
                                    v$iv2 = v$iv3;
                                    this_$iv$iv2 = this_$iv$iv5;
                                }
                            }
                            slot$iv$iv >>= 8;
                            j$iv$iv++;
                            this_$iv3 = this_$iv2;
                            v$iv3 = v$iv2;
                            this_$iv$iv5 = this_$iv$iv2;
                            $i$f$forEachValue3 = $i$f$forEachValue2;
                        }
                        this_$iv = this_$iv3;
                        $i$f$forEachValue = $i$f$forEachValue3;
                        v$iv = v$iv3;
                        this_$iv$iv = this_$iv$iv5;
                        if (bitCount$iv$iv != 8) {
                            break;
                        }
                    }
                    lastIndex$iv$iv = lastIndex$iv$iv2;
                    if (i$iv$iv == lastIndex$iv$iv) {
                        break;
                    }
                    i$iv$iv++;
                    this_$iv3 = this_$iv;
                    v$iv3 = v$iv;
                    this_$iv$iv5 = this_$iv$iv;
                    $i$f$forEachValue3 = $i$f$forEachValue;
                    c = 7;
                    j = -9187201950435737472L;
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> this_$iv$iv7 = this.rulerReaders;
        if (this_$iv$iv7 != null) {
            int $i$f$removeIf3 = 0;
            long[] m$iv$iv5 = this_$iv$iv7.metadata;
            int lastIndex$iv$iv4 = m$iv$iv5.length - 2;
            int i$iv$iv3 = 0;
            if (0 <= lastIndex$iv$iv4) {
                while (true) {
                    long slot$iv$iv3 = m$iv$iv5[i$iv$iv3];
                    long $this$maskEmptyOrDeleted$iv$iv$iv2 = ((~slot$iv$iv3) << 7) & slot$iv$iv3 & (-9187201950435737472L);
                    if ($this$maskEmptyOrDeleted$iv$iv$iv2 == -9187201950435737472L) {
                        $i$f$removeIf = $i$f$removeIf3;
                    } else {
                        int bitCount$iv$iv3 = 8 - ((~(i$iv$iv3 - lastIndex$iv$iv4)) >>> 31);
                        int j$iv$iv3 = 0;
                        while (j$iv$iv3 < bitCount$iv$iv3) {
                            long value$iv$iv$iv3 = slot$iv$iv3 & 255;
                            int $i$f$isFull3 = value$iv$iv$iv3 < 128 ? 1 : 0;
                            if ($i$f$isFull3 == 0) {
                                $i$f$removeIf2 = $i$f$removeIf3;
                            } else {
                                int index$iv$iv2 = (i$iv$iv3 << 3) + j$iv$iv3;
                                Object obj = this_$iv$iv7.keys[index$iv$iv2];
                                $i$f$removeIf2 = $i$f$removeIf3;
                                MutableScatterSet value = (MutableScatterSet) this_$iv$iv7.values[index$iv$iv2];
                                if (value.isEmpty()) {
                                    this_$iv$iv7.removeValueAt(index$iv$iv2);
                                }
                            }
                            slot$iv$iv3 >>= 8;
                            j$iv$iv3++;
                            $i$f$removeIf3 = $i$f$removeIf2;
                        }
                        $i$f$removeIf = $i$f$removeIf3;
                        if (bitCount$iv$iv3 != 8) {
                            break;
                        }
                    }
                    if (i$iv$iv3 == lastIndex$iv$iv4) {
                        break;
                    }
                    i$iv$iv3++;
                    $i$f$removeIf3 = $i$f$removeIf;
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (mutableScatterMap == null) {
            mutableScatterMap = new MutableScatterMap<>(0, 1, defaultConstructorMarker);
            this.rulerReaders = mutableScatterMap;
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2 = mutableScatterMap;
        Object obj2 = mutableScatterMap2.get(ruler);
        if (obj2 == null) {
            MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet = new MutableScatterSet<>(0, 1, null);
            mutableScatterMap2.set(ruler, mutableScatterSet);
            obj2 = mutableScatterSet;
        }
        Object it$iv = obj2;
        ((MutableScatterSet) it$iv).plusAssign(new WeakReference<>(layoutNode));
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable p = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = p.rulerValues;
            boolean z = false;
            if (mutableObjectFloatMap != null && mutableObjectFloatMap.contains(ruler)) {
                z = true;
            }
            if (z) {
                return p;
            }
            LookaheadCapablePlaceable parent = p.getParent();
            if (parent == null) {
                return p;
            }
            p = parent;
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode $this$isLayoutNodeAncestor, LayoutNode ancestor) {
        if ($this$isLayoutNodeAncestor == ancestor) {
            return true;
        }
        LayoutNode parent$ui_release = $this$isLayoutNodeAncestor.getParent$ui_release();
        if (parent$ui_release != null) {
            return isLayoutNodeAncestor(parent$ui_release, ancestor);
        }
        return false;
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        LookaheadCapablePlaceable definer = findAncestorRulerDefiner(ruler);
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = definer.rulerReaders;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetRemove = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (mutableScatterSetRemove != null) {
            notifyRulerValueChange(mutableScatterSetRemove);
        }
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        boolean value$iv$iv = (width & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & height) == 0;
        if (!value$iv$iv) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            /* JADX INFO: renamed from: getWidth, reason: from getter */
            public int get$width() {
                return width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* JADX INFO: renamed from: getHeight, reason: from getter */
            public int get$height() {
                return height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                placementBlock.invoke(this.getPlacementScope());
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0075 A[LOOP:0: B:9:0x0023->B:22:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x007e A[EDGE_INSN: B:34:0x007e->B:26:0x007e BREAK  A[LOOP:0: B:9:0x0023->B:22:0x0075], SYNTHETIC] */
    public final void captureRulers$ui_release(MeasureResult result) {
        if (result != null) {
            captureRulers(new PlaceableResult(result, this));
            return;
        }
        ScatterMap scatterMap = this.rulerReaders;
        if (scatterMap != null) {
            ScatterMap this_$iv = scatterMap;
            Object[] v$iv = this_$iv.values;
            long[] m$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 <= lastIndex$iv$iv) {
                while (true) {
                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                    ScatterMap this_$iv2 = this_$iv;
                    if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                            break;
                        } else {
                            i$iv$iv++;
                            this_$iv = this_$iv2;
                        }
                    } else {
                        int i = 8;
                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                        for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                            long value$iv$iv$iv = 255 & slot$iv$iv;
                            if (value$iv$iv$iv < 128) {
                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                notifyRulerValueChange((MutableScatterSet) v$iv[index$iv$iv]);
                            }
                            i = 8;
                            slot$iv$iv >>= 8;
                        }
                        if (bitCount$iv$iv != i) {
                            break;
                        }
                        if (i$iv$iv != lastIndex$iv$iv) {
                            break;
                        }
                        i$iv$iv++;
                        this_$iv = this_$iv2;
                    }
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap != null) {
            mutableScatterMap.clear();
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap != null) {
            mutableObjectFloatMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:106:0x0089 A[EDGE_INSN: B:106:0x0089->B:27:0x0089 BREAK  A[LOOP:0: B:10:0x002c->B:24:0x0080], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0080 A[LOOP:0: B:10:0x002c->B:24:0x0080, LOOP_END] */
    public final void captureRulers(final PlaceableResult placeableResult) {
        int $i$f$forEachKey;
        int $i$f$forEachKey2;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap;
        ObjectFloatMap this_$iv;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2;
        ObjectFloatMap this_$iv2;
        OwnerSnapshotObserver snapshotObserver;
        if (this.isPlacingForAlignment) {
            return;
        }
        Function1<RulerScope, Unit> rulers = placeableResult.getResult().getRulers();
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap3 = this.rulerReaders;
        char c = 7;
        if (rulers == null) {
            if (mutableScatterMap3 != null) {
                MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> this_$iv3 = mutableScatterMap3;
                Object[] v$iv = this_$iv3.values;
                ScatterMap this_$iv$iv = this_$iv3;
                long[] m$iv$iv = this_$iv$iv.metadata;
                int lastIndex$iv$iv = m$iv$iv.length - 2;
                int i$iv$iv = 0;
                if (0 <= lastIndex$iv$iv) {
                    while (true) {
                        long slot$iv$iv = m$iv$iv[i$iv$iv];
                        ScatterMap this_$iv$iv2 = this_$iv$iv;
                        if ((((~slot$iv$iv) << c) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i$iv$iv != lastIndex$iv$iv) {
                                break;
                                break;
                            } else {
                                i$iv$iv++;
                                this_$iv$iv = this_$iv$iv2;
                                c = 7;
                            }
                        } else {
                            int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                            for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                                long value$iv$iv$iv = slot$iv$iv & 255;
                                int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                                if ($i$f$isFull != 0) {
                                    notifyRulerValueChange((MutableScatterSet) v$iv[(i$iv$iv << 3) + j$iv$iv]);
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
                            this_$iv$iv = this_$iv$iv2;
                            c = 7;
                        }
                    }
                }
                mutableScatterMap3.clear();
                return;
            }
            return;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValuesCache;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValuesCache = mutableObjectFloatMap;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap2 = this.rulerValues;
        if (mutableObjectFloatMap2 == null) {
            mutableObjectFloatMap2 = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap2;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap3 = mutableObjectFloatMap2;
        mutableObjectFloatMap.putAll(mutableObjectFloatMap3);
        mutableObjectFloatMap3.clear();
        Owner owner = getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(placeableResult, onCommitAffectingRuler, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulers.3
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
                    Function1<RulerScope, Unit> rulers2 = placeableResult.getResult().getRulers();
                    if (rulers2 != null) {
                        rulers2.invoke(this.getRulerScope());
                    }
                }
            });
        }
        if (mutableScatterMap3 != null) {
            ObjectFloatMap this_$iv4 = mutableObjectFloatMap;
            int $i$f$forEach = 0;
            Object[] k$iv = this_$iv4.keys;
            float[] v$iv2 = this_$iv4.values;
            long[] m$iv$iv2 = this_$iv4.metadata;
            int lastIndex$iv$iv2 = m$iv$iv2.length - 2;
            int i$iv$iv2 = 0;
            if (0 <= lastIndex$iv$iv2) {
                while (true) {
                    long slot$iv$iv2 = m$iv$iv2[i$iv$iv2];
                    int $i$f$forEach2 = $i$f$forEach;
                    Function1<RulerScope, Unit> function1 = rulers;
                    if ((((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L)) == -9187201950435737472L) {
                        mutableScatterMap = mutableScatterMap3;
                        this_$iv = this_$iv4;
                    } else {
                        int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                        int j$iv$iv2 = 0;
                        while (j$iv$iv2 < bitCount$iv$iv2) {
                            long value$iv$iv$iv2 = slot$iv$iv2 & 255;
                            int $i$f$isFull2 = value$iv$iv$iv2 < 128 ? 1 : 0;
                            if ($i$f$isFull2 == 0) {
                                mutableScatterMap2 = mutableScatterMap3;
                                this_$iv2 = this_$iv4;
                            } else {
                                int index$iv$iv = (i$iv$iv2 << 3) + j$iv$iv2;
                                Object obj = k$iv[index$iv$iv];
                                float oldValue = v$iv2[index$iv$iv];
                                Ruler ruler = (Ruler) obj;
                                this_$iv2 = this_$iv4;
                                float newValue = mutableObjectFloatMap3.getOrDefault(ruler, Float.NaN);
                                if (newValue == oldValue) {
                                    mutableScatterMap2 = mutableScatterMap3;
                                } else {
                                    mutableScatterMap2 = mutableScatterMap3;
                                    MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetRemove = mutableScatterMap3.remove(ruler);
                                    if (mutableScatterSetRemove != null) {
                                        notifyRulerValueChange(mutableScatterSetRemove);
                                    }
                                }
                            }
                            slot$iv$iv2 >>= 8;
                            j$iv$iv2++;
                            this_$iv4 = this_$iv2;
                            mutableScatterMap3 = mutableScatterMap2;
                        }
                        mutableScatterMap = mutableScatterMap3;
                        this_$iv = this_$iv4;
                        if (bitCount$iv$iv2 != 8) {
                            break;
                        }
                    }
                    if (i$iv$iv2 == lastIndex$iv$iv2) {
                        break;
                    }
                    i$iv$iv2++;
                    rulers = function1;
                    $i$f$forEach = $i$f$forEach2;
                    this_$iv4 = this_$iv;
                    mutableScatterMap3 = mutableScatterMap;
                }
            }
        }
        MutableObjectFloatMap<Ruler> this_$iv5 = mutableObjectFloatMap3;
        int $i$f$forEachKey3 = 0;
        Object[] k$iv2 = this_$iv5.keys;
        long[] m$iv$iv3 = this_$iv5.metadata;
        int lastIndex$iv$iv3 = m$iv$iv3.length - 2;
        int i$iv$iv3 = 0;
        if (0 <= lastIndex$iv$iv3) {
            while (true) {
                long slot$iv$iv3 = m$iv$iv3[i$iv$iv3];
                ObjectFloatMap this_$iv6 = this_$iv5;
                if ((((~slot$iv$iv3) << 7) & slot$iv$iv3 & (-9187201950435737472L)) == -9187201950435737472L) {
                    $i$f$forEachKey = $i$f$forEachKey3;
                } else {
                    int bitCount$iv$iv3 = 8 - ((~(i$iv$iv3 - lastIndex$iv$iv3)) >>> 31);
                    int j$iv$iv3 = 0;
                    while (j$iv$iv3 < bitCount$iv$iv3) {
                        long value$iv$iv$iv3 = slot$iv$iv3 & 255;
                        int $i$f$isFull3 = value$iv$iv$iv3 < 128 ? 1 : 0;
                        if ($i$f$isFull3 == 0) {
                            $i$f$forEachKey2 = $i$f$forEachKey3;
                        } else {
                            Ruler ruler2 = (Ruler) k$iv2[(i$iv$iv3 << 3) + j$iv$iv3];
                            if (mutableObjectFloatMap.contains(ruler2)) {
                                $i$f$forEachKey2 = $i$f$forEachKey3;
                            } else {
                                $i$f$forEachKey2 = $i$f$forEachKey3;
                                LookaheadCapablePlaceable parent = getParent();
                                if (parent != null) {
                                    parent.invalidateChildrenOfDefiningRuler(ruler2);
                                }
                            }
                        }
                        slot$iv$iv3 >>= 8;
                        j$iv$iv3++;
                        $i$f$forEachKey3 = $i$f$forEachKey2;
                    }
                    $i$f$forEachKey = $i$f$forEachKey3;
                    if (bitCount$iv$iv3 != 8) {
                        break;
                    }
                }
                if (i$iv$iv3 == lastIndex$iv$iv3) {
                    break;
                }
                i$iv$iv3++;
                this_$iv5 = this_$iv6;
                $i$f$forEachKey3 = $i$f$forEachKey;
            }
        }
        mutableObjectFloatMap.clear();
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> layoutNodes) {
        ScatterSet this_$iv;
        MutableScatterSet<WeakReference<LayoutNode>> this_$iv2 = layoutNodes;
        Object[] k$iv = this_$iv2.elements;
        long[] m$iv$iv = this_$iv2.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                this_$iv = this_$iv2;
            } else {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                int j$iv$iv = 0;
                while (j$iv$iv < bitCount$iv$iv) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    if (value$iv$iv$iv < 128) {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        WeakReference layoutNodeRef = (WeakReference) k$iv[index$iv$iv];
                        LayoutNode layoutNode = (LayoutNode) layoutNodeRef.get();
                        if (layoutNode != null) {
                            if (isLookingAhead()) {
                                layoutNode.requestLookaheadRelayout$ui_release(false);
                            } else {
                                layoutNode.requestRelayout$ui_release(false);
                            }
                        }
                    }
                    slot$iv$iv >>= 8;
                    j$iv$iv++;
                    this_$iv2 = this_$iv2;
                }
                this_$iv = this_$iv2;
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            }
            i$iv$iv++;
            this_$iv2 = this_$iv;
        }
    }

    public final void provideRulerValue(Ruler ruler, float value) {
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap;
        }
        mutableObjectFloatMap.set(ruler, value);
    }

    public final void provideRelativeRulerValue(Ruler ruler, float value) {
        float width;
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap;
        }
        if (getLayoutDirection() == LayoutDirection.Ltr) {
            width = value;
        } else {
            width = getWidth() - value;
        }
        mutableObjectFloatMap.set(ruler, width);
    }
}
