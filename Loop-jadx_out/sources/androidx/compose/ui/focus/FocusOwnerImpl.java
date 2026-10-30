package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FocusOwnerImpl.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001Bª\u0001\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012:\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000eH\u0016J2\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0016J:\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\f2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\n\u0010B\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010C\u001a\u00020\u0005H\u0002J\u001a\u0010D\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\b\u0010G\u001a\u00020\u0005H\u0016J$\u0010H\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0002\bIJ\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020MH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\"H\u0016J$\u0010N\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001a\u0010Q\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u00105J\u000e\u0010S\u001a\u0004\u0018\u00010T*\u00020UH\u0002J3\u0010V\u001a\u0004\u0018\u0001HW\"\n\b\u0000\u0010W\u0018\u0001*\u00020X*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0ZH\u0082\bø\u0001\u0000¢\u0006\u0004\b[\u0010\\Jg\u0010]\u001a\u00020\u0005\"\n\b\u0000\u0010W\u0018\u0001*\u00020U*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bø\u0001\u0000¢\u0006\u0004\ba\u0010bR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "onRequestFocusForOwner", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusDirection;", "Lkotlin/ParameterName;", "name", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "onMoveFocusInterop", "onClearFocusForOwner", "onFocusRectInterop", "onLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", "force", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "focusSearch", "focusedRect", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "invalidateOwnerFocusState", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "requestFocusForOwner", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "nearestAncestorIncludingSelf", ExifInterface.GPS_DIRECTION_TRUE, "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/ui/node/NodeKind;", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "traverseAncestorsIncludingSelf", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private final FocusInvalidationManager focusInvalidationManager;
    private MutableLongSet keysCurrentlyDown;
    private final Function0<Unit> onClearFocusForOwner;
    private final Function0<Rect> onFocusRectInterop;
    private final Function0<LayoutDirection> onLayoutDirection;
    private final Function1<FocusDirection, Boolean> onMoveFocusInterop;
    private final Function2<FocusDirection, Rect, Boolean> onRequestFocusForOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
    private final Modifier modifier = FocusPropertiesKt.focusProperties(Modifier.INSTANCE, new Function1<FocusProperties, Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
            invoke2(focusProperties);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FocusProperties $this$focusProperties) {
            $this$focusProperties.setCanFocus(false);
        }
    }).then(new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$2
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public FocusTargetNode create() {
            return this.this$0.getRootFocusNode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            $this$inspectableProperties.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.getRootFocusNode().hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }
    });

    /* JADX INFO: compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1, Function2<? super FocusDirection, ? super Rect, Boolean> function2, Function1<? super FocusDirection, Boolean> function3, Function0<Unit> function0, Function0<Rect> function4, Function0<? extends LayoutDirection> function5) {
        this.onRequestFocusForOwner = function2;
        this.onMoveFocusInterop = function3;
        this.onClearFocusForOwner = function0;
        this.onFocusRectInterop = function4;
        this.onLayoutDirection = function5;
        this.focusInvalidationManager = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
    }

    /* JADX INFO: renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: requestFocusForOwner-7o62pno */
    public boolean mo3733requestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.onRequestFocusForOwner.invoke(focusDirection, previouslyFocusedRect).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: takeFocus-aToIllA */
    public boolean mo3734takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        FocusTransactionManager $this$iv = getFocusTransactionManager();
        if ($this$iv.ongoingTransaction) {
            Boolean boolMo3732focusSearchULY8qGw = mo3732focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode it) {
                    Boolean boolM3752requestFocusMxy_nc0 = FocusTransactionsKt.m3752requestFocusMxy_nc0(it, focusDirection);
                    return Boolean.valueOf(boolM3752requestFocusMxy_nc0 != null ? boolM3752requestFocusMxy_nc0.booleanValue() : false);
                }
            });
            if (boolMo3732focusSearchULY8qGw != null) {
                return boolMo3732focusSearchULY8qGw.booleanValue();
            }
            return false;
        }
        try {
            $this$iv.beginTransaction();
            Boolean boolMo3732focusSearchULY8qGw2 = mo3732focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode it) {
                    Boolean boolM3752requestFocusMxy_nc0 = FocusTransactionsKt.m3752requestFocusMxy_nc0(it, focusDirection);
                    return Boolean.valueOf(boolM3752requestFocusMxy_nc0 != null ? boolM3752requestFocusMxy_nc0.booleanValue() : false);
                }
            });
            return boolMo3732focusSearchULY8qGw2 != null ? boolMo3732focusSearchULY8qGw2.booleanValue() : false;
        } finally {
            $this$iv.commitTransaction();
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionManager $this$iv = getFocusTransactionManager();
        if (!$this$iv.ongoingTransaction) {
            try {
                $this$iv.beginTransaction();
                FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
                return;
            } finally {
                $this$iv.commitTransaction();
            }
        }
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo3729clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m3721getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: clearFocus-I7lrPNg */
    public boolean mo3729clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean zClearFocus;
        FocusTransactionManager this_$iv = getFocusTransactionManager();
        FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        try {
            if (this_$iv.ongoingTransaction) {
                this_$iv.cancelTransaction();
            }
            this_$iv.beginTransaction();
            if (focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 != null) {
                MutableVector this_$iv$iv = this_$iv.cancellationListener;
                this_$iv$iv.add(focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1);
            }
            if (!force) {
                switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m3748performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        zClearFocus = false;
                        break;
                    default:
                        zClearFocus = FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents);
                        break;
                }
            } else {
                zClearFocus = FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents);
            }
            this_$iv.commitTransaction();
            boolean clearedFocusSuccessfully = zClearFocus;
            if (clearedFocusSuccessfully && clearOwnerFocus) {
                this.onClearFocusForOwner.invoke();
            }
            return clearedFocusSuccessfully;
        } catch (Throwable th) {
            this_$iv.commitTransaction();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusManager
    /* JADX INFO: renamed from: moveFocus-3ESFkO8 */
    public boolean mo3728moveFocus3ESFkO8(final int focusDirection) {
        final Ref.ObjectRef requestFocusSuccess = new Ref.ObjectRef();
        requestFocusSuccess.element = false;
        Boolean focusSearchSuccess = mo3732focusSearchULY8qGw(focusDirection, this.onFocusRectInterop.invoke(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode it) {
                requestFocusSuccess.element = FocusTransactionsKt.m3752requestFocusMxy_nc0(it, focusDirection);
                Boolean bool = requestFocusSuccess.element;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        if (focusSearchSuccess == null || requestFocusSuccess.element == 0) {
            return false;
        }
        if (Intrinsics.areEqual((Object) focusSearchSuccess, (Object) true) && Intrinsics.areEqual((Object) requestFocusSuccess.element, (Object) true)) {
            return true;
        }
        if (FocusOwnerImplKt.m3739is1dFocusSearch3ESFkO8(focusDirection)) {
            boolean clearFocus = mo3729clearFocusI7lrPNg(false, true, false, focusDirection);
            return clearFocus && mo3734takeFocusaToIllA(focusDirection, null);
        }
        return this.onMoveFocusInterop.invoke(FocusDirection.m3710boximpl(focusDirection)).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: focusSearch-ULY8qGw */
    public Boolean mo3732focusSearchULY8qGw(int focusDirection, Rect focusedRect, final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode source = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (source != null) {
            FocusRequester customDest = FocusTraversalKt.m3753customFocusSearchOMvw8(source, focusDirection, this.onLayoutDirection.invoke());
            if (Intrinsics.areEqual(customDest, FocusRequester.INSTANCE.getCancel())) {
                return null;
            }
            if (!Intrinsics.areEqual(customDest, FocusRequester.INSTANCE.getDefault())) {
                return Boolean.valueOf(customDest.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            source = null;
        }
        return FocusTraversalKt.m3754focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.onLayoutDirection.invoke(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode it) {
                boolean zBooleanValue;
                if (Intrinsics.areEqual(it, source)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(it, this.getRootFocusNode())) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    zBooleanValue = onFound.invoke(it).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo3731dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> onFocusedItem) {
        Object obj;
        Modifier.Node node;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int type$iv;
        NodeChain nodes;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int type$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        Object obj2;
        FocusTargetNode activeFocusTarget;
        NodeChain nodes2;
        FocusTargetNode activeFocusTarget2;
        Modifier.Node next$iv$iv$iv;
        DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
        int type$iv3;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int i;
        Modifier.Node focusedKeyInputNode;
        FocusOwnerImpl this_$iv;
        int i2;
        DelegatableNode $this$ancestors_u2d64DMado$iv$iv;
        NodeChain nodes3;
        int i3;
        DelegatableNode $this$ancestors_u2d64DMado$iv$iv2;
        int i4;
        int i5 = 1;
        if (!(!this.focusInvalidationManager.hasPendingInvalidation())) {
            throw new IllegalStateException("Dispatching key event while focus system is invalidated.".toString());
        }
        if (!m3738validateKeyEventZmokQxo(keyEvent)) {
            return false;
        }
        FocusTargetNode activeFocusTarget3 = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (activeFocusTarget3 == null || (node = lastLocalKeyInputNode(activeFocusTarget3)) == null) {
            if (activeFocusTarget3 != null) {
                FocusTargetNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv = activeFocusTarget3;
                int iM5628constructorimpl = NodeKind.m5628constructorimpl(8192);
                if (!$this$nearestAncestorIncludingSelf_u2d64DMado$iv.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node node$iv$iv$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv.getNode();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestorIncludingSelf_u2d64DMado$iv);
                loop10: while (true) {
                    if (layout$iv$iv$iv == null) {
                        obj2 = null;
                        break;
                    }
                    Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                    if ((head$iv$iv$iv.getAggregateChildKindSet() & iM5628constructorimpl) != 0) {
                        while (node$iv$iv$iv != null) {
                            if ((node$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) {
                                Modifier.Node it$iv$iv = node$iv$iv$iv;
                                MutableVector mutableVector = null;
                                Modifier.Node nodePop = it$iv$iv;
                                while (nodePop != null) {
                                    if (nodePop instanceof KeyInputModifierNode) {
                                        obj2 = nodePop;
                                        break loop10;
                                    }
                                    Modifier.Node this_$iv$iv$iv$iv = nodePop;
                                    if (((this_$iv$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                        int count$iv$iv$iv = 0;
                                        DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) nodePop;
                                        Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                        while (node$iv$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv$iv2 = node$iv$iv$iv$iv;
                                            if ((next$iv$iv$iv2.getKindSet() & iM5628constructorimpl) != 0) {
                                                count$iv$iv$iv++;
                                                if (count$iv$iv$iv == i5) {
                                                    nodePop = next$iv$iv$iv2;
                                                    activeFocusTarget3 = activeFocusTarget3;
                                                } else {
                                                    MutableVector mutableVector2 = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                                    Modifier.Node theNode$iv$iv$iv = nodePop;
                                                    if (theNode$iv$iv$iv != null) {
                                                        if (mutableVector2 != null) {
                                                            Boolean.valueOf(mutableVector2.add(theNode$iv$iv$iv));
                                                        }
                                                        nodePop = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        next$iv$iv$iv = next$iv$iv$iv2;
                                                        Boolean.valueOf(mutableVector2.add(next$iv$iv$iv));
                                                    } else {
                                                        next$iv$iv$iv = next$iv$iv$iv2;
                                                    }
                                                    mutableVector = mutableVector2;
                                                    count$iv$iv$iv = count$iv$iv$iv;
                                                }
                                            } else {
                                                activeFocusTarget3 = activeFocusTarget3;
                                            }
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                            activeFocusTarget3 = activeFocusTarget3;
                                            i5 = 1;
                                        }
                                        activeFocusTarget2 = activeFocusTarget3;
                                        if (count$iv$iv$iv == 1) {
                                            activeFocusTarget3 = activeFocusTarget2;
                                            i5 = 1;
                                        } else {
                                            nodePop = DelegatableNodeKt.pop(mutableVector);
                                            activeFocusTarget3 = activeFocusTarget2;
                                            i5 = 1;
                                        }
                                    } else {
                                        activeFocusTarget2 = activeFocusTarget3;
                                        nodePop = DelegatableNodeKt.pop(mutableVector);
                                        activeFocusTarget3 = activeFocusTarget2;
                                        i5 = 1;
                                    }
                                }
                            }
                            node$iv$iv$iv = node$iv$iv$iv.getParent();
                            activeFocusTarget3 = activeFocusTarget3;
                            i5 = 1;
                        }
                        activeFocusTarget = activeFocusTarget3;
                    } else {
                        activeFocusTarget = activeFocusTarget3;
                    }
                    layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes2 = layout$iv$iv$iv.getNodes()) == null) ? null : nodes2.getTail();
                    activeFocusTarget3 = activeFocusTarget;
                    i5 = 1;
                }
                KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) obj2;
                if (keyInputModifierNode != null) {
                    node = keyInputModifierNode.getNode();
                }
            }
            DelegatableNode $this$nearestAncestor_u2d64DMado$iv4 = this.rootFocusNode;
            int type$iv4 = NodeKind.m5628constructorimpl(8192);
            if (!$this$nearestAncestor_u2d64DMado$iv4.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node node$iv$iv$iv2 = $this$nearestAncestor_u2d64DMado$iv4.getNode().getParent();
            LayoutNode layout$iv$iv$iv2 = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv4);
            loop14: while (true) {
                if (layout$iv$iv$iv2 == null) {
                    obj = null;
                    break;
                }
                Modifier.Node head$iv$iv$iv2 = layout$iv$iv$iv2.getNodes().getHead();
                if ((head$iv$iv$iv2.getAggregateChildKindSet() & type$iv4) != 0) {
                    while (node$iv$iv$iv2 != null) {
                        if ((node$iv$iv$iv2.getKindSet() & type$iv4) != 0) {
                            Modifier.Node it$iv$iv2 = node$iv$iv$iv2;
                            MutableVector mutableVector3 = null;
                            Modifier.Node nodePop2 = it$iv$iv2;
                            while (nodePop2 != null) {
                                if (nodePop2 instanceof KeyInputModifierNode) {
                                    obj = nodePop2;
                                    break loop14;
                                }
                                Modifier.Node this_$iv$iv$iv$iv3 = nodePop2;
                                if (((this_$iv$iv$iv$iv3.getKindSet() & type$iv4) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                    int count$iv$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv$iv4 = (DelegatingNode) nodePop2;
                                    Modifier.Node node$iv$iv$iv$iv2 = this_$iv$iv$iv$iv4.getDelegate();
                                    while (node$iv$iv$iv$iv2 != null) {
                                        Modifier.Node next$iv$iv$iv3 = node$iv$iv$iv$iv2;
                                        if ((next$iv$iv$iv3.getKindSet() & type$iv4) != 0) {
                                            count$iv$iv$iv2++;
                                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                            if (count$iv$iv$iv2 == 1) {
                                                nodePop2 = next$iv$iv$iv3;
                                                type$iv4 = type$iv4;
                                            } else {
                                                MutableVector mutableVector4 = mutableVector3 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector3;
                                                Modifier.Node theNode$iv$iv$iv2 = nodePop2;
                                                if (theNode$iv$iv$iv2 != null) {
                                                    if (mutableVector4 != null) {
                                                        Boolean.valueOf(mutableVector4.add(theNode$iv$iv$iv2));
                                                    }
                                                    nodePop2 = null;
                                                }
                                                if (mutableVector4 != null) {
                                                    Boolean.valueOf(mutableVector4.add(next$iv$iv$iv3));
                                                }
                                                mutableVector3 = mutableVector4;
                                                count$iv$iv$iv2 = count$iv$iv$iv2;
                                            }
                                        } else {
                                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                            type$iv4 = type$iv4;
                                        }
                                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild();
                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                        type$iv4 = type$iv4;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                    type$iv2 = type$iv4;
                                    if (count$iv$iv$iv2 == 1) {
                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                        type$iv4 = type$iv2;
                                    } else {
                                        nodePop2 = DelegatableNodeKt.pop(mutableVector3);
                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                        type$iv4 = type$iv2;
                                    }
                                } else {
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                    type$iv2 = type$iv4;
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector3);
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv4 = type$iv2;
                                }
                            }
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getParent();
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv4;
                        type$iv4 = type$iv4;
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                    type$iv = type$iv4;
                } else {
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                    type$iv = type$iv4;
                }
                layout$iv$iv$iv2 = layout$iv$iv$iv2.getParent$ui_release();
                node$iv$iv$iv2 = (layout$iv$iv$iv2 == null || (nodes = layout$iv$iv$iv2.getNodes()) == null) ? null : nodes.getTail();
                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv4 = type$iv;
            }
            KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) obj;
            node = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
        }
        Modifier.Node focusedKeyInputNode2 = node;
        if (focusedKeyInputNode2 == null) {
            return false;
        }
        Modifier.Node $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = focusedKeyInputNode2;
        int type$iv5 = NodeKind.m5628constructorimpl(8192);
        FocusOwnerImpl this_$iv2 = this;
        int i6 = 0;
        DelegatableNode $this$ancestors_u2d64DMado$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
        List list = null;
        if (!$this$ancestors_u2d64DMado$iv$iv3.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv3.getNode().getParent();
        LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$ancestors_u2d64DMado$iv$iv3);
        while (layout$iv$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv$iv = layout$iv$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv$iv.getAggregateChildKindSet() & type$iv5) != 0) {
                while (node$iv$iv$iv$iv3 != null) {
                    if ((node$iv$iv$iv$iv3.getKindSet() & type$iv5) != 0) {
                        Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv3;
                        MutableVector mutableVector5 = null;
                        Modifier.Node focusedKeyInputNode3 = it$iv$iv$iv;
                        while (focusedKeyInputNode3 != null) {
                            this_$iv2 = this_$iv2;
                            if (focusedKeyInputNode3 instanceof KeyInputModifierNode) {
                                Modifier.Node node2 = focusedKeyInputNode3;
                                if (list == null) {
                                    Object result$iv$iv = new ArrayList();
                                    list = (List) result$iv$iv;
                                }
                                list.add(node2);
                                i3 = i6;
                                $this$ancestors_u2d64DMado$iv$iv2 = $this$ancestors_u2d64DMado$iv$iv3;
                            } else {
                                Modifier.Node this_$iv$iv$iv$iv$iv = focusedKeyInputNode3;
                                if (((this_$iv$iv$iv$iv$iv.getKindSet() & type$iv5) != 0) && (focusedKeyInputNode3 instanceof DelegatingNode)) {
                                    int count$iv$iv$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv$iv$iv2 = (DelegatingNode) focusedKeyInputNode3;
                                    Modifier.Node node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv$iv.getKindSet() & type$iv5) != 0) {
                                            count$iv$iv$iv$iv++;
                                            i4 = i6;
                                            if (count$iv$iv$iv$iv == 1) {
                                                focusedKeyInputNode3 = next$iv$iv$iv$iv;
                                                $this$ancestors_u2d64DMado$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv3;
                                            } else {
                                                MutableVector mutableVector6 = mutableVector5 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector5;
                                                Modifier.Node theNode$iv$iv$iv$iv = focusedKeyInputNode3;
                                                if (theNode$iv$iv$iv$iv != null) {
                                                    if (mutableVector6 != null) {
                                                        Boolean.valueOf(mutableVector6.add(theNode$iv$iv$iv$iv));
                                                    }
                                                    focusedKeyInputNode3 = null;
                                                }
                                                if (mutableVector6 != null) {
                                                    Boolean.valueOf(mutableVector6.add(next$iv$iv$iv$iv));
                                                }
                                                mutableVector5 = mutableVector6;
                                                count$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                            }
                                        } else {
                                            i4 = i6;
                                            $this$ancestors_u2d64DMado$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv3;
                                        }
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild();
                                        i6 = i4;
                                        $this$ancestors_u2d64DMado$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv3;
                                    }
                                    i3 = i6;
                                    $this$ancestors_u2d64DMado$iv$iv2 = $this$ancestors_u2d64DMado$iv$iv3;
                                    if (count$iv$iv$iv$iv == 1) {
                                        i6 = i3;
                                        $this$ancestors_u2d64DMado$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv2;
                                    }
                                } else {
                                    i3 = i6;
                                    $this$ancestors_u2d64DMado$iv$iv2 = $this$ancestors_u2d64DMado$iv$iv3;
                                }
                            }
                            focusedKeyInputNode3 = DelegatableNodeKt.pop(mutableVector5);
                            i6 = i3;
                            $this$ancestors_u2d64DMado$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv2;
                        }
                    }
                    node$iv$iv$iv$iv3 = node$iv$iv$iv$iv3.getParent();
                    focusedKeyInputNode2 = focusedKeyInputNode2;
                    this_$iv2 = this_$iv2;
                    i6 = i6;
                    $this$ancestors_u2d64DMado$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv3;
                }
                focusedKeyInputNode = focusedKeyInputNode2;
                this_$iv = this_$iv2;
                i2 = i6;
                $this$ancestors_u2d64DMado$iv$iv = $this$ancestors_u2d64DMado$iv$iv3;
            } else {
                focusedKeyInputNode = focusedKeyInputNode2;
                this_$iv = this_$iv2;
                i2 = i6;
                $this$ancestors_u2d64DMado$iv$iv = $this$ancestors_u2d64DMado$iv$iv3;
            }
            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv$iv3 = (layout$iv$iv$iv$iv == null || (nodes3 = layout$iv$iv$iv$iv.getNodes()) == null) ? null : nodes3.getTail();
            focusedKeyInputNode2 = focusedKeyInputNode;
            this_$iv2 = this_$iv;
            i6 = i2;
            $this$ancestors_u2d64DMado$iv$iv3 = $this$ancestors_u2d64DMado$iv$iv;
        }
        List ancestors$iv = list;
        if (ancestors$iv != null) {
            int size = ancestors$iv.size() - 1;
            if (size >= 0) {
                do {
                    int index$iv$iv = size;
                    size--;
                    Object item$iv$iv = ancestors$iv.get(index$iv$iv);
                    KeyInputModifierNode it = (KeyInputModifierNode) item$iv$iv;
                    if (it.mo180onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } while (size >= 0);
            }
            Unit unit = Unit.INSTANCE;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode();
        int i7 = 0;
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        while (nodePop3 != null) {
            if (nodePop3 instanceof KeyInputModifierNode) {
                KeyInputModifierNode it2 = (KeyInputModifierNode) nodePop3;
                if (it2.mo180onPreKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                i = i7;
            } else {
                Modifier.Node this_$iv$iv$iv = nodePop3;
                if (((this_$iv$iv$iv.getKindSet() & type$iv5) != 0) && (nodePop3 instanceof DelegatingNode)) {
                    int count$iv$iv = 0;
                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop3;
                    Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv2.getDelegate();
                    while (node$iv$iv$iv3 != null) {
                        Modifier.Node next$iv$iv = node$iv$iv$iv3;
                        if ((next$iv$iv.getKindSet() & type$iv5) != 0) {
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                                nodePop3 = next$iv$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                i7 = i7;
                            } else {
                                mutableVector7 = mutableVector7 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector7;
                                Modifier.Node theNode$iv$iv = nodePop3;
                                if (theNode$iv$iv != null) {
                                    if (mutableVector7 != null) {
                                        Boolean.valueOf(mutableVector7.add(theNode$iv$iv));
                                    }
                                    nodePop3 = null;
                                }
                                if (mutableVector7 != null) {
                                    Boolean.valueOf(mutableVector7.add(next$iv$iv));
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                            i7 = i7;
                        }
                        node$iv$iv$iv3 = node$iv$iv$iv3.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                        i7 = i7;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i = i7;
                    MutableVector mutableVector8 = mutableVector7;
                    if (count$iv$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                        i7 = i;
                        mutableVector7 = mutableVector8;
                    } else {
                        mutableVector7 = mutableVector8;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i = i7;
                }
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector7);
            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
            i7 = i;
        }
        if (onFocusedItem.invoke().booleanValue()) {
            return true;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode();
        MutableVector mutableVector9 = null;
        Modifier.Node nodePop4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        while (nodePop4 != null) {
            if (nodePop4 instanceof KeyInputModifierNode) {
                KeyInputModifierNode it3 = (KeyInputModifierNode) nodePop4;
                if (it3.mo178onKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                type$iv3 = type$iv5;
                $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop4;
                if (((this_$iv$iv$iv3.getKindSet() & type$iv5) != 0) && (nodePop4 instanceof DelegatingNode)) {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv4 = (DelegatingNode) nodePop4;
                    Modifier.Node node$iv$iv$iv4 = this_$iv$iv$iv4.getDelegate();
                    while (node$iv$iv$iv4 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv4;
                        if ((next$iv$iv2.getKindSet() & type$iv5) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == 1) {
                                nodePop4 = next$iv$iv2;
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                type$iv5 = type$iv5;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                            } else {
                                mutableVector9 = mutableVector9 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector9;
                                Modifier.Node theNode$iv$iv2 = nodePop4;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector9 != null) {
                                        Boolean.valueOf(mutableVector9.add(theNode$iv$iv2));
                                    }
                                    nodePop4 = null;
                                }
                                if (mutableVector9 != null) {
                                    Boolean.valueOf(mutableVector9.add(next$iv$iv2));
                                }
                            }
                        } else {
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                            type$iv5 = type$iv5;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                        }
                        node$iv$iv$iv4 = node$iv$iv$iv4.getChild();
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                        type$iv5 = type$iv5;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                    }
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                    type$iv3 = type$iv5;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                    if (count$iv$iv2 == 1) {
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                        type$iv5 = type$iv3;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                    }
                } else {
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                    type$iv3 = type$iv5;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                }
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector9);
            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
            type$iv5 = type$iv3;
            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        }
        if (ancestors$iv != null) {
            int size2 = ancestors$iv.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                Object item$iv$iv2 = ancestors$iv.get(index$iv$iv2);
                KeyInputModifierNode it4 = (KeyInputModifierNode) item$iv$iv2;
                if (it4.mo178onKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
        Unit unit3 = Unit.INSTANCE;
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo3730dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
        int type$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int i;
        int size;
        SoftKeyboardInterceptionModifierNode focusedSoftKeyboardInterceptionNode;
        FocusOwnerImpl this_$iv;
        int i2;
        NodeChain nodes;
        FocusOwnerImpl this_$iv2;
        int i3;
        FocusOwnerImpl this_$iv3;
        DelegatableNode delegatableNode;
        DelegatableNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
        NodeChain nodes2;
        DelegatableNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
        int i4 = 1;
        if (!(!this.focusInvalidationManager.hasPendingInvalidation())) {
            throw new IllegalStateException("Dispatching intercepted soft keyboard event while focus system is invalidated.".toString());
        }
        DelegatableNode delegatableNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (delegatableNodeFindActiveFocusNode != null) {
            DelegatableNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = delegatableNodeFindActiveFocusNode;
            int iM5628constructorimpl = NodeKind.m5628constructorimpl(131072);
            if (!$this$nearestAncestorIncludingSelf_u2d64DMado$iv3.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node node$iv$iv$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3.getNode();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestorIncludingSelf_u2d64DMado$iv3);
            loop0: while (true) {
                if (layout$iv$iv$iv == null) {
                    delegatableNode = null;
                    break;
                }
                Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                if ((head$iv$iv$iv.getAggregateChildKindSet() & iM5628constructorimpl) != 0) {
                    while (node$iv$iv$iv != null) {
                        if ((node$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) {
                            Modifier.Node it$iv$iv = node$iv$iv$iv;
                            MutableVector mutableVector = null;
                            Modifier.Node nodePop = it$iv$iv;
                            while (nodePop != null) {
                                if (nodePop instanceof SoftKeyboardInterceptionModifierNode) {
                                    delegatableNode = nodePop;
                                    break loop0;
                                }
                                Modifier.Node this_$iv$iv$iv$iv = nodePop;
                                if (((this_$iv$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    int count$iv$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) nodePop;
                                    Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) {
                                            count$iv$iv$iv++;
                                            if (count$iv$iv$iv == i4) {
                                                nodePop = next$iv$iv$iv;
                                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                            } else {
                                                MutableVector mutableVector2 = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                                Modifier.Node theNode$iv$iv$iv = nodePop;
                                                if (theNode$iv$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv$iv);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv$iv);
                                                }
                                                mutableVector = mutableVector2;
                                            }
                                        } else {
                                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                        i4 = 1;
                                    }
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv2 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                    if (count$iv$iv$iv == 1) {
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
                                        i4 = 1;
                                    } else {
                                        nodePop = DelegatableNodeKt.pop(mutableVector);
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
                                        i4 = 1;
                                    }
                                } else {
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv2 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                    nodePop = DelegatableNodeKt.pop(mutableVector);
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
                                    i4 = 1;
                                }
                            }
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent();
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                        i4 = 1;
                    }
                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                } else {
                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes2 = layout$iv$iv$iv.getNodes()) == null) ? null : nodes2.getTail();
                $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                i4 = 1;
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) delegatableNode;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        SoftKeyboardInterceptionModifierNode focusedSoftKeyboardInterceptionNode2 = softKeyboardInterceptionModifierNode;
        if (focusedSoftKeyboardInterceptionNode2 == null) {
            return false;
        }
        SoftKeyboardInterceptionModifierNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = focusedSoftKeyboardInterceptionNode2;
        int type$iv2 = NodeKind.m5628constructorimpl(131072);
        FocusOwnerImpl this_$iv4 = this;
        int i5 = 0;
        List list = null;
        if (!$this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode().getParent();
        LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2);
        while (layout$iv$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv$iv = layout$iv$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv$iv.getAggregateChildKindSet() & type$iv2) != 0) {
                while (node$iv$iv$iv$iv2 != null) {
                    if ((node$iv$iv$iv$iv2.getKindSet() & type$iv2) != 0) {
                        Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv2;
                        MutableVector mutableVector3 = null;
                        Modifier.Node nodePop2 = it$iv$iv$iv;
                        while (nodePop2 != null) {
                            focusedSoftKeyboardInterceptionNode2 = focusedSoftKeyboardInterceptionNode2;
                            if (nodePop2 instanceof SoftKeyboardInterceptionModifierNode) {
                                Modifier.Node node = nodePop2;
                                if (list == null) {
                                    Object result$iv$iv = new ArrayList();
                                    list = (List) result$iv$iv;
                                }
                                list.add(node);
                                this_$iv2 = this_$iv4;
                                i3 = i5;
                            } else {
                                Modifier.Node this_$iv$iv$iv$iv$iv = nodePop2;
                                if (((this_$iv$iv$iv$iv$iv.getKindSet() & type$iv2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                    int count$iv$iv$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv$iv$iv2 = (DelegatingNode) nodePop2;
                                    Modifier.Node node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv$iv.getKindSet() & type$iv2) != 0) {
                                            count$iv$iv$iv$iv++;
                                            this_$iv3 = this_$iv4;
                                            if (count$iv$iv$iv$iv == 1) {
                                                nodePop2 = next$iv$iv$iv$iv;
                                                i5 = i5;
                                            } else {
                                                MutableVector mutableVector4 = mutableVector3 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector3;
                                                Modifier.Node theNode$iv$iv$iv$iv = nodePop2;
                                                if (theNode$iv$iv$iv$iv != null) {
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(theNode$iv$iv$iv$iv);
                                                    }
                                                    nodePop2 = null;
                                                }
                                                if (mutableVector4 != null) {
                                                    mutableVector4.add(next$iv$iv$iv$iv);
                                                }
                                                mutableVector3 = mutableVector4;
                                                count$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                            }
                                        } else {
                                            this_$iv3 = this_$iv4;
                                            i5 = i5;
                                        }
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild();
                                        this_$iv4 = this_$iv3;
                                        i5 = i5;
                                    }
                                    this_$iv2 = this_$iv4;
                                    i3 = i5;
                                    if (count$iv$iv$iv$iv == 1) {
                                        this_$iv4 = this_$iv2;
                                        i5 = i3;
                                    }
                                } else {
                                    this_$iv2 = this_$iv4;
                                    i3 = i5;
                                }
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector3);
                            this_$iv4 = this_$iv2;
                            i5 = i3;
                        }
                    }
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getParent();
                    focusedSoftKeyboardInterceptionNode2 = focusedSoftKeyboardInterceptionNode2;
                    this_$iv4 = this_$iv4;
                    i5 = i5;
                }
                focusedSoftKeyboardInterceptionNode = focusedSoftKeyboardInterceptionNode2;
                this_$iv = this_$iv4;
                i2 = i5;
            } else {
                focusedSoftKeyboardInterceptionNode = focusedSoftKeyboardInterceptionNode2;
                this_$iv = this_$iv4;
                i2 = i5;
            }
            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv$iv2 = (layout$iv$iv$iv$iv == null || (nodes = layout$iv$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            focusedSoftKeyboardInterceptionNode2 = focusedSoftKeyboardInterceptionNode;
            this_$iv4 = this_$iv;
            i5 = i2;
        }
        List ancestors$iv = list;
        if (ancestors$iv != null && (size = ancestors$iv.size() - 1) >= 0) {
            do {
                int index$iv$iv = size;
                size--;
                Object item$iv$iv = ancestors$iv.get(index$iv$iv);
                SoftKeyboardInterceptionModifierNode it = (SoftKeyboardInterceptionModifierNode) item$iv$iv;
                if (it.mo4809onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
            } while (size >= 0);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode();
        int i6 = 0;
        MutableVector mutableVector5 = null;
        Modifier.Node nodePop3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        while (nodePop3 != null) {
            if (nodePop3 instanceof SoftKeyboardInterceptionModifierNode) {
                SoftKeyboardInterceptionModifierNode it2 = (SoftKeyboardInterceptionModifierNode) nodePop3;
                if (it2.mo4809onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                i = i6;
            } else {
                Modifier.Node this_$iv$iv$iv = nodePop3;
                if (((this_$iv$iv$iv.getKindSet() & type$iv2) != 0) && (nodePop3 instanceof DelegatingNode)) {
                    int count$iv$iv = 0;
                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop3;
                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv = node$iv$iv$iv2;
                        if ((next$iv$iv.getKindSet() & type$iv2) != 0) {
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                                nodePop3 = next$iv$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                i6 = i6;
                            } else {
                                mutableVector5 = mutableVector5 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector5;
                                Modifier.Node theNode$iv$iv = nodePop3;
                                if (theNode$iv$iv != null) {
                                    if (mutableVector5 != null) {
                                        mutableVector5.add(theNode$iv$iv);
                                    }
                                    nodePop3 = null;
                                }
                                if (mutableVector5 != null) {
                                    mutableVector5.add(next$iv$iv);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                            i6 = i6;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                        i6 = i6;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i = i6;
                    MutableVector mutableVector6 = mutableVector5;
                    if (count$iv$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                        i6 = i;
                        mutableVector5 = mutableVector6;
                    } else {
                        mutableVector5 = mutableVector6;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i = i6;
                }
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector5);
            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
            i6 = i;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode();
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        while (nodePop4 != null) {
            if (nodePop4 instanceof SoftKeyboardInterceptionModifierNode) {
                SoftKeyboardInterceptionModifierNode it3 = (SoftKeyboardInterceptionModifierNode) nodePop4;
                if (it3.mo4808onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                type$iv = type$iv2;
                $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop4;
                if (((this_$iv$iv$iv3.getKindSet() & type$iv2) != 0) && (nodePop4 instanceof DelegatingNode)) {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv4 = (DelegatingNode) nodePop4;
                    Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv4.getDelegate();
                    while (node$iv$iv$iv3 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv3;
                        if ((next$iv$iv2.getKindSet() & type$iv2) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == 1) {
                                nodePop4 = next$iv$iv2;
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                type$iv2 = type$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                            } else {
                                mutableVector7 = mutableVector7 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector7;
                                Modifier.Node theNode$iv$iv2 = nodePop4;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector7 != null) {
                                        mutableVector7.add(theNode$iv$iv2);
                                    }
                                    nodePop4 = null;
                                }
                                if (mutableVector7 != null) {
                                    mutableVector7.add(next$iv$iv2);
                                }
                            }
                        } else {
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                            type$iv2 = type$iv2;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                        }
                        node$iv$iv$iv3 = node$iv$iv$iv3.getChild();
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                        type$iv2 = type$iv2;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                    }
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                    type$iv = type$iv2;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                    if (count$iv$iv2 == 1) {
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                        type$iv2 = type$iv;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                    }
                } else {
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                    type$iv = type$iv2;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                }
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector7);
            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
            type$iv2 = type$iv;
            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        }
        if (ancestors$iv == null) {
            return false;
        }
        int size2 = ancestors$iv.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            Object item$iv$iv2 = ancestors$iv.get(index$iv$iv2);
            SoftKeyboardInterceptionModifierNode it4 = (SoftKeyboardInterceptionModifierNode) item$iv$iv2;
            if (it4.mo4808onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        RotaryInputModifierNode rotaryInputModifierNode;
        DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
        int type$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int i;
        int size;
        RotaryInputModifierNode focusedRotaryInputNode;
        FocusOwnerImpl this_$iv;
        int i2;
        NodeChain nodes;
        FocusOwnerImpl this_$iv2;
        int i3;
        FocusOwnerImpl this_$iv3;
        DelegatableNode delegatableNode;
        DelegatableNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
        NodeChain nodes2;
        DelegatableNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
        int i4 = 1;
        if (!(!this.focusInvalidationManager.hasPendingInvalidation())) {
            throw new IllegalStateException("Dispatching rotary event while focus system is invalidated.".toString());
        }
        DelegatableNode delegatableNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (delegatableNodeFindActiveFocusNode != null) {
            DelegatableNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = delegatableNodeFindActiveFocusNode;
            int iM5628constructorimpl = NodeKind.m5628constructorimpl(16384);
            if (!$this$nearestAncestorIncludingSelf_u2d64DMado$iv3.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node node$iv$iv$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3.getNode();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestorIncludingSelf_u2d64DMado$iv3);
            loop0: while (true) {
                if (layout$iv$iv$iv == null) {
                    delegatableNode = null;
                    break;
                }
                Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                if ((head$iv$iv$iv.getAggregateChildKindSet() & iM5628constructorimpl) != 0) {
                    while (node$iv$iv$iv != null) {
                        if ((node$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) {
                            Modifier.Node it$iv$iv = node$iv$iv$iv;
                            MutableVector mutableVector = null;
                            Modifier.Node nodePop = it$iv$iv;
                            while (nodePop != null) {
                                if (nodePop instanceof RotaryInputModifierNode) {
                                    delegatableNode = nodePop;
                                    break loop0;
                                }
                                Modifier.Node this_$iv$iv$iv$iv = nodePop;
                                if (((this_$iv$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    int count$iv$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) nodePop;
                                    Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv.getKindSet() & iM5628constructorimpl) != 0) {
                                            count$iv$iv$iv++;
                                            if (count$iv$iv$iv == i4) {
                                                nodePop = next$iv$iv$iv;
                                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                            } else {
                                                MutableVector mutableVector2 = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                                Modifier.Node theNode$iv$iv$iv = nodePop;
                                                if (theNode$iv$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv$iv);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv$iv);
                                                }
                                                mutableVector = mutableVector2;
                                            }
                                        } else {
                                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                        i4 = 1;
                                    }
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv2 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                    if (count$iv$iv$iv == 1) {
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
                                        i4 = 1;
                                    } else {
                                        nodePop = DelegatableNodeKt.pop(mutableVector);
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
                                        i4 = 1;
                                    }
                                } else {
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv2 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                                    nodePop = DelegatableNodeKt.pop(mutableVector);
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv2;
                                    i4 = 1;
                                }
                            }
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent();
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                        i4 = 1;
                    }
                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                } else {
                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv3;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes2 = layout$iv$iv$iv.getNodes()) == null) ? null : nodes2.getTail();
                $this$nearestAncestorIncludingSelf_u2d64DMado$iv3 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                i4 = 1;
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) delegatableNode;
        } else {
            rotaryInputModifierNode = null;
        }
        RotaryInputModifierNode focusedRotaryInputNode2 = rotaryInputModifierNode;
        if (focusedRotaryInputNode2 == null) {
            return false;
        }
        RotaryInputModifierNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = focusedRotaryInputNode2;
        int type$iv2 = NodeKind.m5628constructorimpl(16384);
        FocusOwnerImpl this_$iv4 = this;
        int i5 = 0;
        List list = null;
        if (!$this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode().getParent();
        LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2);
        while (layout$iv$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv$iv = layout$iv$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv$iv.getAggregateChildKindSet() & type$iv2) != 0) {
                while (node$iv$iv$iv$iv2 != null) {
                    if ((node$iv$iv$iv$iv2.getKindSet() & type$iv2) != 0) {
                        Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv2;
                        MutableVector mutableVector3 = null;
                        Modifier.Node nodePop2 = it$iv$iv$iv;
                        while (nodePop2 != null) {
                            focusedRotaryInputNode2 = focusedRotaryInputNode2;
                            if (nodePop2 instanceof RotaryInputModifierNode) {
                                Modifier.Node node = nodePop2;
                                if (list == null) {
                                    Object result$iv$iv = new ArrayList();
                                    list = (List) result$iv$iv;
                                }
                                list.add(node);
                                this_$iv2 = this_$iv4;
                                i3 = i5;
                            } else {
                                Modifier.Node this_$iv$iv$iv$iv$iv = nodePop2;
                                if (((this_$iv$iv$iv$iv$iv.getKindSet() & type$iv2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                    int count$iv$iv$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv$iv$iv2 = (DelegatingNode) nodePop2;
                                    Modifier.Node node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv$iv.getKindSet() & type$iv2) != 0) {
                                            count$iv$iv$iv$iv++;
                                            this_$iv3 = this_$iv4;
                                            if (count$iv$iv$iv$iv == 1) {
                                                nodePop2 = next$iv$iv$iv$iv;
                                                i5 = i5;
                                            } else {
                                                MutableVector mutableVector4 = mutableVector3 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector3;
                                                Modifier.Node theNode$iv$iv$iv$iv = nodePop2;
                                                if (theNode$iv$iv$iv$iv != null) {
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(theNode$iv$iv$iv$iv);
                                                    }
                                                    nodePop2 = null;
                                                }
                                                if (mutableVector4 != null) {
                                                    mutableVector4.add(next$iv$iv$iv$iv);
                                                }
                                                mutableVector3 = mutableVector4;
                                                count$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                            }
                                        } else {
                                            this_$iv3 = this_$iv4;
                                            i5 = i5;
                                        }
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild();
                                        this_$iv4 = this_$iv3;
                                        i5 = i5;
                                    }
                                    this_$iv2 = this_$iv4;
                                    i3 = i5;
                                    if (count$iv$iv$iv$iv == 1) {
                                        this_$iv4 = this_$iv2;
                                        i5 = i3;
                                    }
                                } else {
                                    this_$iv2 = this_$iv4;
                                    i3 = i5;
                                }
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector3);
                            this_$iv4 = this_$iv2;
                            i5 = i3;
                        }
                    }
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getParent();
                    focusedRotaryInputNode2 = focusedRotaryInputNode2;
                    this_$iv4 = this_$iv4;
                    i5 = i5;
                }
                focusedRotaryInputNode = focusedRotaryInputNode2;
                this_$iv = this_$iv4;
                i2 = i5;
            } else {
                focusedRotaryInputNode = focusedRotaryInputNode2;
                this_$iv = this_$iv4;
                i2 = i5;
            }
            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv$iv2 = (layout$iv$iv$iv$iv == null || (nodes = layout$iv$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            focusedRotaryInputNode2 = focusedRotaryInputNode;
            this_$iv4 = this_$iv;
            i5 = i2;
        }
        List ancestors$iv = list;
        if (ancestors$iv != null && (size = ancestors$iv.size() - 1) >= 0) {
            do {
                int index$iv$iv = size;
                size--;
                Object item$iv$iv = ancestors$iv.get(index$iv$iv);
                RotaryInputModifierNode it = (RotaryInputModifierNode) item$iv$iv;
                if (it.onPreRotaryScrollEvent(event)) {
                    return true;
                }
            } while (size >= 0);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode();
        int i6 = 0;
        MutableVector mutableVector5 = null;
        Modifier.Node nodePop3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        while (nodePop3 != null) {
            if (nodePop3 instanceof RotaryInputModifierNode) {
                RotaryInputModifierNode it2 = (RotaryInputModifierNode) nodePop3;
                if (it2.onPreRotaryScrollEvent(event)) {
                    return true;
                }
                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                i = i6;
            } else {
                Modifier.Node this_$iv$iv$iv = nodePop3;
                if (((this_$iv$iv$iv.getKindSet() & type$iv2) != 0) && (nodePop3 instanceof DelegatingNode)) {
                    int count$iv$iv = 0;
                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop3;
                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv = node$iv$iv$iv2;
                        if ((next$iv$iv.getKindSet() & type$iv2) != 0) {
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                                nodePop3 = next$iv$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                i6 = i6;
                            } else {
                                mutableVector5 = mutableVector5 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector5;
                                Modifier.Node theNode$iv$iv = nodePop3;
                                if (theNode$iv$iv != null) {
                                    if (mutableVector5 != null) {
                                        mutableVector5.add(theNode$iv$iv);
                                    }
                                    nodePop3 = null;
                                }
                                if (mutableVector5 != null) {
                                    mutableVector5.add(next$iv$iv);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                            i6 = i6;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                        i6 = i6;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i = i6;
                    MutableVector mutableVector6 = mutableVector5;
                    if (count$iv$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                        i6 = i;
                        mutableVector5 = mutableVector6;
                    } else {
                        mutableVector5 = mutableVector6;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                    i = i6;
                }
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector5);
            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
            i6 = i;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getNode();
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        while (nodePop4 != null) {
            if (nodePop4 instanceof RotaryInputModifierNode) {
                RotaryInputModifierNode it3 = (RotaryInputModifierNode) nodePop4;
                if (it3.onRotaryScrollEvent(event)) {
                    return true;
                }
                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                type$iv = type$iv2;
                $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop4;
                if (((this_$iv$iv$iv3.getKindSet() & type$iv2) != 0) && (nodePop4 instanceof DelegatingNode)) {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv4 = (DelegatingNode) nodePop4;
                    Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv4.getDelegate();
                    while (node$iv$iv$iv3 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv3;
                        if ((next$iv$iv2.getKindSet() & type$iv2) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == 1) {
                                nodePop4 = next$iv$iv2;
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                type$iv2 = type$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                            } else {
                                mutableVector7 = mutableVector7 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector7;
                                Modifier.Node theNode$iv$iv2 = nodePop4;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector7 != null) {
                                        mutableVector7.add(theNode$iv$iv2);
                                    }
                                    nodePop4 = null;
                                }
                                if (mutableVector7 != null) {
                                    mutableVector7.add(next$iv$iv2);
                                }
                            }
                        } else {
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                            type$iv2 = type$iv2;
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                        }
                        node$iv$iv$iv3 = node$iv$iv$iv3.getChild();
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                        type$iv2 = type$iv2;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                    }
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                    type$iv = type$iv2;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                    if (count$iv$iv2 == 1) {
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                        type$iv2 = type$iv;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                    }
                } else {
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                    type$iv = type$iv2;
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                }
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector7);
            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
            type$iv2 = type$iv;
            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        }
        if (ancestors$iv == null) {
            return false;
        }
        int size2 = ancestors$iv.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            Object item$iv$iv2 = ancestors$iv.get(index$iv$iv2);
            RotaryInputModifierNode it4 = (RotaryInputModifierNode) item$iv$iv2;
            if (it4.onRotaryScrollEvent(event)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOwnerFocusState() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    /* JADX INFO: renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m3737traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k, int type, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function2) {
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        int i2;
        int size;
        int i3;
        DelegatableNode $this$ancestors_u2d64DMado$iv;
        int i4;
        NodeChain nodes;
        int i5;
        DelegatableNode $this$ancestors_u2d64DMado$iv2;
        int i6;
        DelegatableNode $this$ancestors_u2d64DMado$iv3;
        int i7;
        int i8;
        function1 = function1;
        int i9 = 0;
        DelegatableNode $this$ancestors_u2d64DMado$iv4 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k;
        int i10 = 0;
        Object result$iv = null;
        if (!$this$ancestors_u2d64DMado$iv4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv = $this$ancestors_u2d64DMado$iv4.getNode().getParent();
        LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$ancestors_u2d64DMado$iv4);
        while (layout$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv.getAggregateChildKindSet() & type) != 0) {
                while (node$iv$iv$iv != null) {
                    if ((node$iv$iv$iv.getKindSet() & type) != 0) {
                        Modifier.Node it$iv$iv = node$iv$iv$iv;
                        Object stack$iv$iv$iv = null;
                        Modifier.Node this_$iv$iv$iv$iv = it$iv$iv;
                        while (this_$iv$iv$iv$iv != null) {
                            i9 = i9;
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (this_$iv$iv$iv$iv instanceof Object) {
                                Modifier.Node node = this_$iv$iv$iv$iv;
                                if (result$iv == null) {
                                    Object result$iv2 = new ArrayList();
                                    result$iv = (List) result$iv2;
                                }
                                $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv4;
                                ((List) result$iv).add(node);
                                i7 = i10;
                            } else {
                                $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv4;
                                if (((this_$iv$iv$iv$iv.getKindSet() & type) != 0) && (this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                    int count$iv$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) this_$iv$iv$iv$iv;
                                    Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv != null) {
                                        DelegatingNode this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv.getKindSet() & type) != 0) {
                                            count$iv$iv$iv++;
                                            i8 = i10;
                                            if (count$iv$iv$iv == 1) {
                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                result$iv = result$iv;
                                            } else {
                                                Object mutableVector = (MutableVector) stack$iv$iv$iv;
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                stack$iv$iv$iv = mutableVector;
                                                Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                if (theNode$iv$iv$iv != null) {
                                                    MutableVector mutableVector2 = (MutableVector) stack$iv$iv$iv;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv$iv);
                                                    }
                                                    this_$iv$iv$iv$iv = null;
                                                }
                                                MutableVector mutableVector3 = (MutableVector) stack$iv$iv$iv;
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv$iv);
                                                }
                                                count$iv$iv$iv = count$iv$iv$iv;
                                            }
                                        } else {
                                            i8 = i10;
                                            result$iv = result$iv;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        i10 = i8;
                                        result$iv = result$iv;
                                    }
                                    i7 = i10;
                                    Object result$iv3 = result$iv;
                                    if (count$iv$iv$iv == 1) {
                                        $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv3;
                                        i10 = i7;
                                        result$iv = result$iv3;
                                    } else {
                                        result$iv = result$iv3;
                                    }
                                } else {
                                    i7 = i10;
                                    result$iv = result$iv;
                                }
                            }
                            this_$iv$iv$iv$iv = DelegatableNodeKt.pop((MutableVector) stack$iv$iv$iv);
                            $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv3;
                            i10 = i7;
                        }
                        i5 = i9;
                        $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                        i6 = i10;
                    } else {
                        i5 = i9;
                        $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                        i6 = i10;
                    }
                    node$iv$iv$iv = node$iv$iv$iv.getParent();
                    i9 = i5;
                    $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv2;
                    i10 = i6;
                }
                i3 = i9;
                $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv4;
                i4 = i10;
            } else {
                i3 = i9;
                $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv4;
                i4 = i10;
            }
            layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            i9 = i3;
            $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv;
            i10 = i4;
        }
        List ancestors = (List) result$iv;
        if (ancestors != null && (size = ancestors.size() - 1) >= 0) {
            do {
                int index$iv = size;
                size--;
                Object item$iv = ancestors.get(index$iv);
                function1.invoke(item$iv);
            } while (size >= 0);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k.getNode();
        int i11 = 0;
        Object stack$iv = null;
        Modifier.Node node$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
        while (node$iv != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node$iv instanceof Object) {
                function1.invoke(node$iv);
                $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                i2 = i11;
            } else {
                Modifier.Node this_$iv$iv = node$iv;
                if (((this_$iv$iv.getKindSet() & type) != 0) && (node$iv instanceof DelegatingNode)) {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) node$iv;
                    Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if ((next$iv.getKindSet() & type) != 0) {
                            count$iv++;
                            if (count$iv == 1) {
                                node$iv = next$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                i11 = i11;
                            } else {
                                Object obj = (MutableVector) stack$iv;
                                if (obj == null) {
                                    Object mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    obj = mutableVector4;
                                }
                                stack$iv = obj;
                                Modifier.Node theNode$iv = node$iv;
                                if (theNode$iv != null) {
                                    MutableVector mutableVector5 = (MutableVector) stack$iv;
                                    if (mutableVector5 != null) {
                                        mutableVector5.add(theNode$iv);
                                    }
                                    node$iv = null;
                                }
                                MutableVector mutableVector6 = (MutableVector) stack$iv;
                                if (mutableVector6 != null) {
                                    mutableVector6.add(next$iv);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                            i11 = i11;
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                        i11 = i11;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    i2 = i11;
                    if (count$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                        i11 = i2;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    i2 = i11;
                }
            }
            node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
            $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv2;
            i11 = i2;
        }
        function0.invoke();
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k.getNode();
        int i12 = 0;
        Object stack$iv2 = null;
        Modifier.Node node$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv4;
        while (node$iv2 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node$iv2 instanceof Object) {
                function2.invoke(node$iv2);
                $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv4;
                i = i12;
            } else {
                Modifier.Node this_$iv$iv3 = node$iv2;
                if (((this_$iv$iv3.getKindSet() & type) != 0) && (node$iv2 instanceof DelegatingNode)) {
                    int count$iv2 = 0;
                    DelegatingNode this_$iv$iv4 = (DelegatingNode) node$iv2;
                    Modifier.Node node$iv$iv2 = this_$iv$iv4.getDelegate();
                    while (node$iv$iv2 != null) {
                        Modifier.Node next$iv2 = node$iv$iv2;
                        if ((next$iv2.getKindSet() & type) != 0) {
                            count$iv2++;
                            if (count$iv2 == 1) {
                                node$iv2 = next$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv4;
                                i12 = i12;
                            } else {
                                Object obj2 = (MutableVector) stack$iv2;
                                if (obj2 == null) {
                                    Object mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                    obj2 = mutableVector7;
                                }
                                stack$iv2 = obj2;
                                Modifier.Node theNode$iv2 = node$iv2;
                                if (theNode$iv2 != null) {
                                    MutableVector mutableVector8 = (MutableVector) stack$iv2;
                                    if (mutableVector8 != null) {
                                        mutableVector8.add(theNode$iv2);
                                    }
                                    node$iv2 = null;
                                }
                                MutableVector mutableVector9 = (MutableVector) stack$iv2;
                                if (mutableVector9 != null) {
                                    mutableVector9.add(next$iv2);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv4;
                            i12 = i12;
                        }
                        node$iv$iv2 = node$iv$iv2.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv4;
                        i12 = i12;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv4;
                    i = i12;
                    if (count$iv2 == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv;
                        i12 = i;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv4;
                    i = i12;
                }
            }
            node$iv2 = DelegatableNodeKt.pop((MutableVector) stack$iv2);
            $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv;
            i12 = i;
        }
        if (ancestors != null) {
            int size2 = ancestors.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = ancestors.get(index$iv2);
                function2.invoke(item$iv2);
            }
        }
    }

    /* JADX INFO: renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m3736nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        int i2;
        boolean z;
        DelegatableNode delegatableNode2;
        int i3;
        int i4;
        NodeChain nodes;
        DelegatableNode delegatableNode3;
        int i5;
        int i6;
        DelegatableNode delegatableNode4;
        int i7 = 0;
        boolean z2 = true;
        DelegatableNode delegatableNode5 = delegatableNode;
        int i8 = 0;
        int i9 = i;
        if (!delegatableNode5.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node = delegatableNode5.getNode();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode5);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i9) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i9) != 0) {
                        Object obj = null;
                        Modifier.Node nodePop = node;
                        while (nodePop != null) {
                            i7 = i7;
                            z2 = z2;
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                return (T) nodePop;
                            }
                            if (((nodePop.getKindSet() & i) != 0 ? 1 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                delegatableNode3 = delegatableNode5;
                                i5 = i8;
                                i6 = i9;
                                nodePop = DelegatableNodeKt.pop((MutableVector) obj);
                                delegatableNode5 = delegatableNode3;
                                i8 = i5;
                                i9 = i6;
                            } else {
                                int i10 = 0;
                                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                while (delegate != null) {
                                    Modifier.Node node2 = delegate;
                                    if ((node2.getKindSet() & i) != 0) {
                                        i10++;
                                        delegatableNode4 = delegatableNode5;
                                        if (i10 == 1) {
                                            nodePop = node2;
                                            i8 = i8;
                                            i9 = i9;
                                        } else {
                                            MutableVector mutableVector = (MutableVector) obj;
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            obj = mutableVector;
                                            Modifier.Node node3 = nodePop;
                                            if (node3 != null) {
                                                MutableVector mutableVector2 = (MutableVector) obj;
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node3);
                                                }
                                                nodePop = null;
                                            }
                                            MutableVector mutableVector3 = (MutableVector) obj;
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(node2);
                                            }
                                            i10 = i10;
                                        }
                                    } else {
                                        delegatableNode4 = delegatableNode5;
                                        i8 = i8;
                                        i9 = i9;
                                    }
                                    delegate = delegate.getChild();
                                    delegatableNode5 = delegatableNode4;
                                    i8 = i8;
                                    i9 = i9;
                                }
                                delegatableNode3 = delegatableNode5;
                                i5 = i8;
                                i6 = i9;
                                if (i10 == 1) {
                                    delegatableNode5 = delegatableNode3;
                                    i8 = i5;
                                    i9 = i6;
                                } else {
                                    nodePop = DelegatableNodeKt.pop((MutableVector) obj);
                                    delegatableNode5 = delegatableNode3;
                                    i8 = i5;
                                    i9 = i6;
                                }
                            }
                        }
                    }
                    node = node.getParent();
                    i7 = i7;
                    z2 = z2;
                    delegatableNode5 = delegatableNode5;
                    i8 = i8;
                    i9 = i9;
                }
                i2 = i7;
                z = z2;
                delegatableNode2 = delegatableNode5;
                i3 = i8;
                i4 = i9;
            } else {
                i2 = i7;
                z = z2;
                delegatableNode2 = delegatableNode5;
                i3 = i8;
                i4 = i9;
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            i7 = i2;
            z2 = z;
            delegatableNode5 = delegatableNode2;
            i8 = i3;
            i9 = i4;
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode $this$lastLocalKeyInputNode) {
        Modifier.Node node = null;
        int mask$iv = NodeKind.m5628constructorimpl(1024) | NodeKind.m5628constructorimpl(8192);
        boolean value$iv$iv = $this$lastLocalKeyInputNode.getNode().getIsAttached();
        if (!value$iv$iv) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node self$iv = $this$lastLocalKeyInputNode.getNode();
        if ((self$iv.getAggregateChildKindSet() & mask$iv) != 0) {
            for (Modifier.Node next$iv = self$iv.getChild(); next$iv != null; next$iv = next$iv.getChild()) {
                if ((next$iv.getKindSet() & mask$iv) != 0) {
                    Modifier.Node modifierNode = next$iv;
                    if ((modifierNode.getKindSet() & NodeKind.m5628constructorimpl(1024)) != 0) {
                        return node;
                    }
                    node = modifierNode;
                }
            }
        }
        return node;
    }

    /* JADX INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m3738validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long keyCode = KeyEvent_androidKt.m5121getKeyZmokQxo(keyEvent);
        int iM5122getTypeZmokQxo = KeyEvent_androidKt.m5122getTypeZmokQxo(keyEvent);
        if (KeyEventType.m5114equalsimpl0(iM5122getTypeZmokQxo, KeyEventType.INSTANCE.m5118getKeyDownCS__XNY())) {
            MutableLongSet it = this.keysCurrentlyDown;
            if (it == null) {
                it = new MutableLongSet(3);
                this.keysCurrentlyDown = it;
            }
            it.plusAssign(keyCode);
        } else if (KeyEventType.m5114equalsimpl0(iM5122getTypeZmokQxo, KeyEventType.INSTANCE.m5119getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (!(mutableLongSet != null && mutableLongSet.contains(keyCode))) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 != null) {
                mutableLongSet2.remove(keyCode);
            }
        }
        return true;
    }
}
