package androidx.compose.p001ui.input.pointer;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.PointerInputModifierNode;
import androidx.compose.p001ui.platform.ViewConfiguration;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpRect;
import androidx.compose.p001ui.unit.FontScaling;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001GB.\u0012'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ=\u00103\u001a\u0002H4\"\u0004\b\u0000\u001042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u000206\u0012\n\u0012\b\u0012\u0004\u0012\u0002H40\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0096@¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;H\u0002J-\u0010<\u001a\u00020\b2\u0006\u0010:\u001a\u00020;2\u001a\u00105\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u0017R\u00020\u0000\u0012\u0004\u0012\u00020\b0=H\u0082\bJ\b\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\bH\u0016J\b\u0010@\u001a\u00020\bH\u0016J*\u0010A\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;2\u0006\u0010B\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\b\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0017R\u00020\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u0017R\u00020\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000Rh\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n2'\u0010&\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u000bR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\r8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b.\u0010\u001bR\u0014\u0010/\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, m195d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "pointerInputHandler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "lastPointerEvent", "pointerHandlers", DownloadUtil.CookieScheme.VALUE, "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "Lkotlin/jvm/functions/Function2;", "pointerInputJob", "Lkotlinx/coroutines/Job;", "size", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancelPointerInput", "onDensityChange", "onDetach", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onViewConfigurationChange", "resetPointerInputHandler", "PointerEventHandlerCoroutine", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {
    public static final int $stable = 0;
    private boolean interceptOutOfBoundsChildEvents;
    private PointerEvent lastPointerEvent;
    private Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler;
    private Job pointerInputJob;
    private PointerEvent currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
    private long boundsSize = IntSize.INSTANCE.m6980getZeroYbymL2g();

    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo560roundToPxR2X_6o(long j) {
        return Density.CC.m6765$default$roundToPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo561roundToPx0680j_4(float f) {
        return Density.CC.m6766$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo562toDpGaN1DYA(long j) {
        return FontScaling.CC.m6910$default$toDpGaN1DYA(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo563toDpu2uoSUM(float f) {
        return Density.CC.m6767$default$toDpu2uoSUM(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo564toDpu2uoSUM(int i) {
        return Density.CC.m6768$default$toDpu2uoSUM((Density) this, i);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo565toDpSizekrfVVM(long j) {
        return Density.CC.m6769$default$toDpSizekrfVVM(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo566toPxR2X_6o(long j) {
        return Density.CC.m6770$default$toPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo567toPx0680j_4(float f) {
        return Density.CC.m6771$default$toPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo568toSizeXkaWNTQ(long j) {
        return Density.CC.m6772$default$toSizeXkaWNTQ(this, j);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo569toSp0xMU5do(float f) {
        return FontScaling.CC.m6911$default$toSp0xMU5do(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo570toSpkPz2Gy4(float f) {
        return Density.CC.m6773$default$toSpkPz2Gy4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo571toSpkPz2Gy4(int i) {
        return Density.CC.m6774$default$toSpkPz2Gy4((Density) this, i);
    }

    public SuspendingPointerInputModifierNodeImpl(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.pointerInputHandler = function2;
    }

    @Override // androidx.compose.p001ui.input.pointer.SuspendingPointerInputModifierNode
    public Function2<PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        return this.pointerInputHandler;
    }

    @Override // androidx.compose.p001ui.input.pointer.SuspendingPointerInputModifierNode
    public void setPointerInputHandler(Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        resetPointerInputHandler();
        this.pointerInputHandler = function2;
    }

    @Override // androidx.compose.p001ui.unit.Density
    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getDensity();
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity().getFontScale();
    }

    @Override // androidx.compose.p001ui.input.pointer.PointerInputScope
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode(this).getViewConfiguration();
    }

    @Override // androidx.compose.p001ui.input.pointer.PointerInputScope
    /* JADX INFO: renamed from: getSize-YbymL2g, reason: from getter */
    public long getBoundsSize() {
        return this.boundsSize;
    }

    @Override // androidx.compose.p001ui.input.pointer.PointerInputScope
    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo558getExtendedTouchPaddingNHjbRc() {
        long minimumTouchTargetSize = mo568toSizeXkaWNTQ(getViewConfiguration().mo5799getMinimumTouchTargetSizeMYxV2XQ());
        long size = getBoundsSize();
        float horizontal = Math.max(0.0f, Size.m4118getWidthimpl(minimumTouchTargetSize) - IntSize.m6975getWidthimpl(size)) / 2.0f;
        float vertical = Math.max(0.0f, Size.m4115getHeightimpl(minimumTouchTargetSize) - IntSize.m6974getHeightimpl(size)) / 2.0f;
        return SizeKt.Size(horizontal, vertical);
    }

    @Override // androidx.compose.p001ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @Override // androidx.compose.p001ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetPointerInputHandler();
        super.onDetach();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public void onDensityChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public void onViewConfigurationChange() {
        resetPointerInputHandler();
    }

    @Override // androidx.compose.p001ui.input.pointer.SuspendingPointerInputModifierNode
    public void resetPointerInputHandler() {
        Job localJob = this.pointerInputJob;
        if (localJob != null) {
            localJob.cancel((CancellationException) new PointerInputResetException());
            this.pointerInputJob = null;
        }
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> block) {
        Object lock$iv = this.pointerHandlers;
        synchronized (lock$iv) {
            try {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
                mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                    int size$iv = mutableVector2.getSize();
                    if (size$iv > 0) {
                        int i$iv = 0;
                        Object[] content$iv = mutableVector2.getContent();
                        do {
                            block.invoke(content$iv[i$iv]);
                            i$iv++;
                        } while (i$iv < size$iv);
                    }
                    break;
                case 3:
                    MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                    int size$iv2 = mutableVector3.getSize();
                    if (size$iv2 > 0) {
                        int i$iv2 = size$iv2 - 1;
                        Object[] content$iv2 = mutableVector3.getContent();
                        do {
                            block.invoke(content$iv2[i$iv2]);
                            i$iv2--;
                        } while (i$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.dispatchingPointerHandlers.clear();
            InlineMarker.finallyEnd(1);
        }
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pass) {
        Object lock$iv$iv = this.pointerHandlers;
        synchronized (lock$iv$iv) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
        }
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[pass.ordinal()]) {
                case 1:
                case 2:
                    MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                    int size$iv$iv = mutableVector2.getSize();
                    if (size$iv$iv > 0) {
                        int i$iv$iv = 0;
                        Object[] content$iv$iv = mutableVector2.getContent();
                        do {
                            ((PointerEventHandlerCoroutine) content$iv$iv[i$iv$iv]).offerPointerEvent(pointerEvent, pass);
                            i$iv$iv++;
                        } while (i$iv$iv < size$iv$iv);
                    }
                    break;
                case 3:
                    MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                    int size$iv$iv2 = mutableVector3.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = size$iv$iv2 - 1;
                        Object[] content$iv$iv2 = mutableVector3.getContent();
                        do {
                            ((PointerEventHandlerCoroutine) content$iv$iv2[i$iv$iv2]).offerPointerEvent(pointerEvent, pass);
                            i$iv$iv2--;
                        } while (i$iv$iv2 >= 0);
                    }
                    break;
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo427onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        PointerEvent pointerEvent2;
        boolean z;
        this.boundsSize = bounds;
        if (pass != PointerEventPass.Initial) {
            pointerEvent2 = pointerEvent;
        } else {
            pointerEvent2 = pointerEvent;
            this.currentEvent = pointerEvent2;
        }
        if (this.pointerInputJob == null) {
            this.pointerInputJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
        }
        dispatchPointerEvent(pointerEvent, pass);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int index$iv$iv = 0;
        int size = changes.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = changes.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (!PointerEventKt.changedToUpIgnoreConsumed(it)) {
                    z = false;
                    break;
                }
                index$iv$iv++;
            } else {
                z = true;
                break;
            }
        }
        this.lastPointerEvent = z ^ true ? pointerEvent2 : null;
    }

    @Override // androidx.compose.p001ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        boolean z;
        PointerEvent lastEvent = this.lastPointerEvent;
        if (lastEvent == null) {
            return;
        }
        List<PointerInputChange> changes = lastEvent.getChanges();
        int index$iv$iv = 0;
        int size = changes.size();
        while (true) {
            z = true;
            if (index$iv$iv >= size) {
                break;
            }
            Object item$iv$iv = changes.get(index$iv$iv);
            PointerInputChange it = (PointerInputChange) item$iv$iv;
            if (!(true ^ it.getPressed())) {
                z = false;
                break;
            }
            index$iv$iv++;
        }
        if (z) {
            return;
        }
        List<PointerInputChange> changes2 = lastEvent.getChanges();
        List target$iv = new ArrayList(changes2.size());
        int size2 = changes2.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            Object item$iv$iv2 = changes2.get(index$iv$iv2);
            PointerInputChange old = (PointerInputChange) item$iv$iv2;
            long id = old.getId();
            long position = old.getPosition();
            List list = target$iv;
            list.add(new PointerInputChange(id, old.getUptimeMillis(), position, false, old.getPressure(), old.getUptimeMillis(), old.getPosition(), old.getPressed(), old.getPressed(), 0, 0L, 1536, (DefaultConstructorMarker) null));
        }
        List newChanges = target$iv;
        PointerEvent cancelEvent = new PointerEvent(newChanges);
        this.currentEvent = cancelEvent;
        dispatchPointerEvent(cancelEvent, PointerEventPass.Initial);
        dispatchPointerEvent(cancelEvent, PointerEventPass.Main);
        dispatchPointerEvent(cancelEvent, PointerEventPass.Final);
        this.lastPointerEvent = null;
    }

    @Override // androidx.compose.p001ui.input.pointer.PointerInputScope
    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        final PointerEventHandlerCoroutine handlerCoroutine = new PointerEventHandlerCoroutine(continuation2);
        Object lock$iv = this.pointerHandlers;
        synchronized (lock$iv) {
            MutableVector this_$iv = this.pointerHandlers;
            this_$iv.add(handlerCoroutine);
            Continuation<Unit> continuationCreateCoroutine = ContinuationKt.createCoroutine(function2, handlerCoroutine, handlerCoroutine);
            Result.Companion companion = Result.INSTANCE;
            continuationCreateCoroutine.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
            Unit unit = Unit.INSTANCE;
        }
        continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                handlerCoroutine.cancel(it);
            }
        });
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(m194d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bJ\u001b\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0002\u00100JE\u00101\u001a\u0002H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@¢\u0006\u0002\u00109JG\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H\u0096@¢\u0006\u0002\u00109J\u0017\u0010;\u001a\u00020<*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0017\u0010;\u001a\u00020<*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020=*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001a\u0010C\u001a\u00020=*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001a\u0010C\u001a\u00020=*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010HJ\u0017\u0010I\u001a\u00020J*\u00020\u0016H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u0012*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010GJ\u0017\u0010M\u001a\u00020\u0012*\u00020@H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u0017\u0010S\u001a\u00020\u0016*\u00020JH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010LJ\u0017\u0010U\u001a\u00020@*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020\u0012H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001a\u0010U\u001a\u00020@*\u00020<H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, m195d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", NotificationCompat.CATEGORY_EVENT, "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl $$delegate_0;
        private final Continuation<R> completion;
        private CancellableContinuation<? super PointerEvent> pointerAwaiter;
        private PointerEventPass awaitPass = PointerEventPass.Main;
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;

        @Override // androidx.compose.p001ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public int mo560roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo560roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public int mo561roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo561roundToPx0680j_4(f);
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public float mo562toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo562toDpGaN1DYA(j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo563toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo563toDpu2uoSUM(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public float mo564toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo564toDpu2uoSUM(i);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public long mo565toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo565toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public float mo566toPxR2X_6o(long j) {
            return this.$$delegate_0.mo566toPxR2X_6o(j);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public float mo567toPx0680j_4(float f) {
            return this.$$delegate_0.mo567toPx0680j_4(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public long mo568toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo568toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.p001ui.unit.FontScaling
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public long mo569toSp0xMU5do(float f) {
            return this.$$delegate_0.mo569toSp0xMU5do(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo570toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo570toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.p001ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public long mo571toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo571toSpkPz2Gy4(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(Continuation<? super R> continuation) {
            this.completion = continuation;
            this.$$delegate_0 = SuspendingPointerInputModifierNodeImpl.this;
        }

        @Override // androidx.compose.p001ui.input.pointer.AwaitPointerEventScope
        public PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.this.currentEvent;
        }

        @Override // androidx.compose.p001ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getSize-YbymL2g */
        public long mo5408getSizeYbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.this.boundsSize;
        }

        @Override // androidx.compose.p001ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        @Override // androidx.compose.p001ui.input.pointer.AwaitPointerEventScope
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo5407getExtendedTouchPaddingNHjbRc() {
            return SuspendingPointerInputModifierNodeImpl.this.mo558getExtendedTouchPaddingNHjbRc();
        }

        public final void offerPointerEvent(PointerEvent event, PointerEventPass pass) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (pass == this.awaitPass && (cancellableContinuation = this.pointerAwaiter) != null) {
                this.pointerAwaiter = null;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7693constructorimpl(event));
            }
        }

        public final void cancel(Throwable cause) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(cause);
            }
            this.pointerAwaiter = null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            Object lock$iv = SuspendingPointerInputModifierNodeImpl.this.pointerHandlers;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (lock$iv) {
                MutableVector this_$iv = suspendingPointerInputModifierNodeImpl.pointerHandlers;
                this_$iv.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(result);
        }

        @Override // androidx.compose.p001ui.input.pointer.AwaitPointerEventScope
        public Object awaitPointerEvent(PointerEventPass pass, Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellable$iv.initCancellability();
            CancellableContinuationImpl continuation2 = cancellable$iv;
            this.awaitPass = pass;
            this.pointerAwaiter = continuation2;
            Object result = cancellable$iv.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.p001ui.input.pointer.AwaitPointerEventScope
        public <T> Object withTimeoutOrNull(long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
            C1773x2677a771 c1773x2677a771;
            Object objWithTimeout;
            if (continuation instanceof C1773x2677a771) {
                c1773x2677a771 = (C1773x2677a771) continuation;
                if ((c1773x2677a771.label & Integer.MIN_VALUE) != 0) {
                    c1773x2677a771.label -= Integer.MIN_VALUE;
                } else {
                    c1773x2677a771 = new C1773x2677a771(this, continuation);
                }
            } else {
                c1773x2677a771 = new C1773x2677a771(this, continuation);
            }
            C1773x2677a771 c1773x2677a772 = c1773x2677a771;
            Object $result = c1773x2677a772.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (c1773x2677a772.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        c1773x2677a772.label = 1;
                        objWithTimeout = withTimeout(timeMillis, function2, c1773x2677a772);
                        if (objWithTimeout == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objWithTimeout = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return objWithTimeout;
            } catch (PointerEventTimeoutCancellationException e) {
                return null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.p001ui.input.pointer.AwaitPointerEventScope
        public <T> Object withTimeout(long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
            C1771x647a7347 c1771x647a7347;
            Job job;
            Job job2;
            Object objInvoke;
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            if (continuation instanceof C1771x647a7347) {
                c1771x647a7347 = (C1771x647a7347) continuation;
                if ((c1771x647a7347.label & Integer.MIN_VALUE) != 0) {
                    c1771x647a7347.label -= Integer.MIN_VALUE;
                } else {
                    c1771x647a7347 = new C1771x647a7347(this, continuation);
                }
            } else {
                c1771x647a7347 = new C1771x647a7347(this, continuation);
            }
            C1771x647a7347 c1771x647a7348 = c1771x647a7347;
            Object $result = c1771x647a7348.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c1771x647a7348.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (timeMillis <= 0 && (cancellableContinuation = this.pointerAwaiter) != null) {
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m7693constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(timeMillis))));
                    }
                    job = BuildersKt__Builders_commonKt.launch$default(SuspendingPointerInputModifierNodeImpl.this.getCoroutineScope(), null, null, new C1772xf3489d20(timeMillis, this, null), 3, null);
                    try {
                        c1771x647a7348.L$0 = job;
                        c1771x647a7348.label = 1;
                        objInvoke = function2.invoke(this, c1771x647a7348);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        job.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
                        return objInvoke;
                    } catch (Throwable th) {
                        th = th;
                        job2 = job;
                        job2.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
                        throw th;
                    }
                case 1:
                    job2 = (Job) c1771x647a7348.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        job = job2;
                        objInvoke = $result;
                        job.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
                        return objInvoke;
                    } catch (Throwable th2) {
                        th = th2;
                        job2.cancel((CancellationException) CancelTimeoutCancellationException.INSTANCE);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
