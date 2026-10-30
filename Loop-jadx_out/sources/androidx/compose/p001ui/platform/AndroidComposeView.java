package androidx.compose.p001ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.SessionMutex;
import androidx.compose.p001ui.autofill.AndroidAutofill;
import androidx.compose.p001ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.p001ui.autofill.Autofill;
import androidx.compose.p001ui.autofill.AutofillCallback;
import androidx.compose.p001ui.autofill.AutofillTree;
import androidx.compose.p001ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.p001ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.p001ui.draganddrop.DragAndDropManager;
import androidx.compose.p001ui.draganddrop.DragAndDropTransferData;
import androidx.compose.p001ui.focus.FocusDirection;
import androidx.compose.p001ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.p001ui.focus.FocusOwner;
import androidx.compose.p001ui.focus.FocusOwnerImpl;
import androidx.compose.p001ui.focus.FocusOwnerImplKt;
import androidx.compose.p001ui.focus.FocusTargetNode;
import androidx.compose.p001ui.focus.FocusTransactionsKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.p001ui.graphics.CanvasHolder;
import androidx.compose.p001ui.graphics.GraphicsContext;
import androidx.compose.p001ui.graphics.Matrix;
import androidx.compose.p001ui.graphics.RectHelper_androidKt;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.hapticfeedback.HapticFeedback;
import androidx.compose.p001ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.p001ui.input.InputMode;
import androidx.compose.p001ui.input.InputModeManager;
import androidx.compose.p001ui.input.InputModeManagerImpl;
import androidx.compose.p001ui.input.key.Key;
import androidx.compose.p001ui.input.key.KeyEvent;
import androidx.compose.p001ui.input.key.KeyEventType;
import androidx.compose.p001ui.input.key.KeyEvent_androidKt;
import androidx.compose.p001ui.input.key.KeyInputModifierKt;
import androidx.compose.p001ui.input.pointer.MotionEventAdapter;
import androidx.compose.p001ui.input.pointer.PointerIcon;
import androidx.compose.p001ui.input.pointer.PointerIconService;
import androidx.compose.p001ui.input.pointer.PointerInputEvent;
import androidx.compose.p001ui.input.pointer.PointerInputEventData;
import androidx.compose.p001ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.p001ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.p001ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.p001ui.input.pointer.PositionCalculator;
import androidx.compose.p001ui.input.pointer.ProcessResult;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.p001ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.p001ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p001ui.internal.InlineClassHelperKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.layout.PlaceableKt;
import androidx.compose.p001ui.layout.RootMeasurePolicy;
import androidx.compose.p001ui.modifier.ModifierLocalManager;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.LayoutNodeDrawScope;
import androidx.compose.p001ui.node.MeasureAndLayoutDelegate;
import androidx.compose.p001ui.node.NestedVectorStack;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.p001ui.node.OwnedLayer;
import androidx.compose.p001ui.node.Owner;
import androidx.compose.p001ui.node.OwnerSnapshotObserver;
import androidx.compose.p001ui.node.PointerInputModifierNode;
import androidx.compose.p001ui.node.RootForTest;
import androidx.compose.p001ui.scrollcapture.ScrollCapture;
import androidx.compose.p001ui.semantics.EmptySemanticsElement;
import androidx.compose.p001ui.semantics.SemanticsNodeKt;
import androidx.compose.p001ui.semantics.SemanticsOwner;
import androidx.compose.p001ui.text.font.Font;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.p001ui.text.input.TextInputService;
import androidx.compose.p001ui.text.input.TextInputServiceAndroid;
import androidx.compose.p001ui.unit.AndroidDensity_androidKt;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DensityKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.viewinterop.AndroidViewHolder;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0082\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b*\u0002½\u0001\b\u0000\u0018\u0000 ù\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004ù\u0003ú\u0003B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0090\u0002\u001a\u0002062\b\u0010÷\u0001\u001a\u00030\u0091\u00022\b\u0010\u0092\u0002\u001a\u00030À\u0001J&\u0010\u0093\u0002\u001a\u0002062\u0007\u0010\u0094\u0002\u001a\u00020G2\b\u0010\u0095\u0002\u001a\u00030\u0096\u00022\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J\u0015\u0010\u0099\u0002\u001a\u0002062\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010ø\u0001H\u0016J!\u0010\u0099\u0002\u001a\u0002062\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010ø\u00012\n\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009c\u0002H\u0016J\u001e\u0010\u0099\u0002\u001a\u0002062\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010ø\u00012\u0007\u0010\u009d\u0002\u001a\u00020GH\u0016J*\u0010\u0099\u0002\u001a\u0002062\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010ø\u00012\u0007\u0010\u009d\u0002\u001a\u00020G2\n\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009c\u0002H\u0016J'\u0010\u0099\u0002\u001a\u0002062\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010ø\u00012\u0007\u0010\u009e\u0002\u001a\u00020G2\u0007\u0010\u009f\u0002\u001a\u00020GH\u0016J\u0019\u0010#\u001a\u0002062\u000f\u0010 \u0002\u001a\n\u0012\u0005\u0012\u00030¢\u00020¡\u0002H\u0016J\t\u0010£\u0002\u001a\u00020mH\u0002J\u0010\u0010¤\u0002\u001a\u000206H\u0086@¢\u0006\u0003\u0010¥\u0002J\u0010\u0010¦\u0002\u001a\u000206H\u0086@¢\u0006\u0003\u0010¥\u0002J \u0010§\u0002\u001a\u00030\u008a\u00012\b\u0010¨\u0002\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b©\u0002\u0010ª\u0002J \u0010«\u0002\u001a\u00030\u008a\u00012\b\u0010¬\u0002\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u00ad\u0002\u0010ª\u0002J\u0012\u0010®\u0002\u001a\u00020m2\u0007\u0010¯\u0002\u001a\u00020GH\u0016J\u0012\u0010°\u0002\u001a\u00020m2\u0007\u0010¯\u0002\u001a\u00020GH\u0016J\u0012\u0010±\u0002\u001a\u0002062\u0007\u0010²\u0002\u001a\u00020\u0001H\u0002J\"\u0010³\u0002\u001a\u00030´\u00022\u0007\u0010µ\u0002\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¶\u0002\u0010·\u0002J:\u0010¸\u0002\u001a\u00020Q2\u0014\u0010¹\u0002\u001a\u000f\u0012\u0005\u0012\u00030º\u0002\u0012\u0004\u0012\u000206042\r\u0010»\u0002\u001a\b\u0012\u0004\u0012\u0002060Z2\n\u0010¼\u0002\u001a\u0005\u0018\u00010½\u0002H\u0016J\u0013\u0010¾\u0002\u001a\u0002062\b\u0010¿\u0002\u001a\u00030À\u0002H\u0014J\u0013\u0010Á\u0002\u001a\u00020m2\b\u0010Â\u0002\u001a\u00030¹\u0001H\u0016J\u0013\u0010Ã\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030¹\u0001H\u0016J\u0013\u0010Å\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030Æ\u0002H\u0016J\u0013\u0010Ç\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030Æ\u0002H\u0016J\u0013\u0010È\u0002\u001a\u00020m2\b\u0010Â\u0002\u001a\u00030¹\u0001H\u0016J\u001b\u0010É\u0002\u001a\u0002062\b\u0010÷\u0001\u001a\u00030\u0091\u00022\b\u0010¿\u0002\u001a\u00030À\u0002J\u0015\u0010Ê\u0002\u001a\u0005\u0018\u00010ø\u00012\u0007\u0010¯\u0002\u001a\u00020GH\u0002J\u001f\u0010Ë\u0002\u001a\u0005\u0018\u00010ø\u00012\u0007\u0010Ì\u0002\u001a\u00020G2\b\u0010Í\u0002\u001a\u00030ø\u0001H\u0002J\u0013\u0010Î\u0002\u001a\u0005\u0018\u00010ø\u00012\u0007\u0010Ì\u0002\u001a\u00020GJ!\u0010Ï\u0002\u001a\u0005\u0018\u00010ø\u00012\n\u0010Ð\u0002\u001a\u0005\u0018\u00010ø\u00012\u0007\u0010¯\u0002\u001a\u00020GH\u0016J\t\u0010Ñ\u0002\u001a\u000206H\u0016J\u001c\u0010Ò\u0002\u001a\u0002062\b\u0010\u0092\u0002\u001a\u00030À\u00012\u0007\u0010Ó\u0002\u001a\u00020mH\u0016J\"\u0010Ô\u0002\u001a\u0005\u0018\u00010Õ\u00022\b\u0010Ö\u0002\u001a\u00030×\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bØ\u0002\u0010Ù\u0002J\u0013\u0010Ú\u0002\u001a\u0002062\b\u0010Û\u0002\u001a\u00030Ü\u0002H\u0016J#\u0010Ý\u0002\u001a\u00030Þ\u00022\b\u0010Â\u0002\u001a\u00030¹\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bß\u0002\u0010à\u0002J\u0013\u0010á\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030¹\u0001H\u0002J\u001d\u0010â\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030¹\u00012\b\u0010ã\u0002\u001a\u00030¹\u0001H\u0002J\t\u0010ä\u0002\u001a\u000206H\u0016J\u0013\u0010å\u0002\u001a\u0002062\b\u0010æ\u0002\u001a\u00030À\u0001H\u0002J\u0013\u0010ç\u0002\u001a\u0002062\b\u0010æ\u0002\u001a\u00030À\u0001H\u0002J\u0013\u0010è\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030¹\u0001H\u0002J\u0013\u0010é\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030¹\u0001H\u0002J\u0013\u0010ê\u0002\u001a\u00020m2\b\u0010Â\u0002\u001a\u00030¹\u0001H\u0002J\u0013\u0010ë\u0002\u001a\u00020m2\b\u0010Ä\u0002\u001a\u00030¹\u0001H\u0002J \u0010ì\u0002\u001a\u00030\u008a\u00012\b\u0010¬\u0002\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bí\u0002\u0010ª\u0002J\u001f\u0010ì\u0002\u001a\u0002062\b\u0010î\u0002\u001a\u00030ñ\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bï\u0002\u0010ð\u0002J)\u0010ñ\u0002\u001a\u0002062\b\u0010\u0092\u0002\u001a\u00030À\u00012\b\u0010ò\u0002\u001a\u00030«\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bó\u0002\u0010ô\u0002J\u0012\u0010ñ\u0002\u001a\u0002062\u0007\u0010õ\u0002\u001a\u00020mH\u0016J\t\u0010ö\u0002\u001a\u000206H\u0016J!\u0010÷\u0002\u001a\u0002062\u0007\u0010ø\u0002\u001a\u00020Q2\u0007\u0010ù\u0002\u001a\u00020mH\u0000¢\u0006\u0003\bú\u0002J\u0013\u0010û\u0002\u001a\u0002062\b\u0010æ\u0002\u001a\u00030À\u0001H\u0016J\t\u0010ü\u0002\u001a\u000206H\u0014J\t\u0010ý\u0002\u001a\u00020mH\u0016J\t\u0010þ\u0002\u001a\u000206H\u0002J\u0012\u0010ÿ\u0002\u001a\u0002062\u0007\u0010\u0080\u0003\u001a\u000205H\u0014J\u0016\u0010\u0081\u0003\u001a\u0005\u0018\u00010\u0082\u00032\b\u0010\u0083\u0003\u001a\u00030\u0084\u0003H\u0016J0\u0010\u0085\u0003\u001a\u0002062\b\u0010\u0086\u0003\u001a\u00030\u0087\u00032\b\u0010\u0088\u0003\u001a\u00030ô\u00012\u0011\u0010\u0089\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008b\u00030\u008a\u0003H\u0017J\u0013\u0010\u008c\u0003\u001a\u0002062\b\u0010æ\u0002\u001a\u00030À\u0001H\u0016J\t\u0010\u008d\u0003\u001a\u000206H\u0014J\u0013\u0010\u008e\u0003\u001a\u0002062\b\u0010¿\u0002\u001a\u00030À\u0002H\u0014J\t\u0010\u008f\u0003\u001a\u000206H\u0016J\f\u0010\u0090\u0003\u001a\u0005\u0018\u00010\u0091\u0003H\u0002J'\u0010\u0092\u0003\u001a\u0002062\u0007\u0010\u0093\u0003\u001a\u00020m2\u0007\u0010¯\u0002\u001a\u00020G2\n\u0010\u0094\u0003\u001a\u0005\u0018\u00010Ü\u0002H\u0014J6\u0010\u0095\u0003\u001a\u0002062\u0007\u0010\u0096\u0003\u001a\u00020m2\u0007\u0010\u0097\u0003\u001a\u00020G2\u0007\u0010\u0098\u0003\u001a\u00020G2\u0007\u0010\u0099\u0003\u001a\u00020G2\u0007\u0010\u009a\u0003\u001a\u00020GH\u0014J\u0013\u0010\u009b\u0003\u001a\u0002062\b\u0010\u0092\u0002\u001a\u00030À\u0001H\u0016J\u001b\u0010\u009c\u0003\u001a\u0002062\u0007\u0010\u009d\u0003\u001a\u00020G2\u0007\u0010\u009e\u0003\u001a\u00020GH\u0014J\u001f\u0010\u009f\u0003\u001a\u00020m2\b\u0010 \u0003\u001a\u00030Õ\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\b¡\u0003\u0010¢\u0003J\u001e\u0010£\u0003\u001a\u0002062\n\u0010¤\u0003\u001a\u0005\u0018\u00010¥\u00032\u0007\u0010¦\u0003\u001a\u00020GH\u0016J*\u0010§\u0003\u001a\u00020m2\n\u0010 \u0003\u001a\u0005\u0018\u00010Õ\u00022\n\u0010\u0094\u0003\u001a\u0005\u0018\u00010\u0091\u0003H\u0002ø\u0001\u0000¢\u0006\u0003\b¨\u0003J.\u0010©\u0003\u001a\u0002062\b\u0010\u0092\u0002\u001a\u00030À\u00012\u0007\u0010Ó\u0002\u001a\u00020m2\u0007\u0010ª\u0003\u001a\u00020m2\u0007\u0010«\u0003\u001a\u00020mH\u0016J%\u0010¬\u0003\u001a\u0002062\b\u0010\u0092\u0002\u001a\u00030À\u00012\u0007\u0010Ó\u0002\u001a\u00020m2\u0007\u0010ª\u0003\u001a\u00020mH\u0016J\u0013\u0010\u00ad\u0003\u001a\u0002062\b\u0010®\u0003\u001a\u00030¯\u0003H\u0016J\u0012\u0010°\u0003\u001a\u0002062\u0007\u0010\u0095\u0001\u001a\u00020GH\u0016J.\u0010±\u0003\u001a\u0002062\b\u0010²\u0003\u001a\u00030Ü\u00022\b\u0010³\u0003\u001a\u00030´\u00032\u000f\u0010µ\u0003\u001a\n\u0012\u0005\u0012\u00030¶\u00030\u008a\u0003H\u0016J\t\u0010·\u0003\u001a\u000206H\u0016J\u001c\u0010¸\u0003\u001a\u0002062\u0011\u0010¹\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010»\u00030º\u0003H\u0017J\u0012\u0010¼\u0003\u001a\u0002062\u0007\u0010½\u0003\u001a\u00020mH\u0016J+\u0010¾\u0003\u001a\u00030´\u00022\u0007\u0010¿\u0003\u001a\u00020G2\u0007\u0010\u009a\u0003\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÀ\u0003\u0010Á\u0003J\t\u0010Â\u0003\u001a\u000206H\u0002J\u0013\u0010Â\u0003\u001a\u0002062\b\u0010Â\u0002\u001a\u00030¹\u0001H\u0002J\t\u0010Ã\u0003\u001a\u000206H\u0002J\u0018\u0010Ä\u0003\u001a\u00020m2\u0007\u0010ø\u0002\u001a\u00020QH\u0000¢\u0006\u0003\bÅ\u0003J\u0018\u0010Æ\u0003\u001a\u0002062\r\u0010Ç\u0003\u001a\b\u0012\u0004\u0012\u0002060ZH\u0016J\u0013\u0010È\u0003\u001a\u0002062\b\u0010Ç\u0003\u001a\u00030É\u0003H\u0016J\u0011\u0010Ê\u0003\u001a\u0002062\b\u0010÷\u0001\u001a\u00030\u0091\u0002J\u0007\u0010Ë\u0003\u001a\u000206J\u001e\u0010Ì\u0003\u001a\u00020m2\u0007\u0010¯\u0002\u001a\u00020G2\n\u0010\u0094\u0003\u001a\u0005\u0018\u00010Ü\u0002H\u0016J\u0013\u0010Í\u0003\u001a\u0002062\b\u0010\u0092\u0002\u001a\u00030À\u0001H\u0016J\u0017\u0010«\u0003\u001a\u0002062\f\b\u0002\u0010Î\u0003\u001a\u0005\u0018\u00010À\u0001H\u0002J \u0010Ï\u0003\u001a\u00030\u008a\u00012\b\u0010Ð\u0003\u001a\u00030\u008a\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÑ\u0003\u0010ª\u0002J\u001f\u0010Ò\u0003\u001a\u00020m2\b\u0010Ö\u0002\u001a\u00030×\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bÓ\u0003\u0010Ô\u0003J#\u0010Õ\u0003\u001a\u00030Þ\u00022\b\u0010Â\u0002\u001a\u00030¹\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÖ\u0003\u0010à\u0002J1\u0010×\u0003\u001a\u0002062\b\u0010Â\u0002\u001a\u00030¹\u00012\u0007\u0010Ø\u0003\u001a\u00020G2\b\u0010Ù\u0003\u001a\u00030\u008c\u00012\t\b\u0002\u0010Ú\u0003\u001a\u00020mH\u0002J\u0013\u0010Û\u0003\u001a\u0002062\b\u0010Ü\u0003\u001a\u00030\u008c\u0001H\u0016J\u001c\u0010Ý\u0003\u001a\u0002062\u0013\u0010Þ\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020604J\t\u0010ß\u0003\u001a\u00020mH\u0016JE\u0010à\u0003\u001a\u00020m2\b\u0010á\u0003\u001a\u00030â\u00032\b\u0010ã\u0003\u001a\u00030ä\u00032\u001a\u0010å\u0003\u001a\u0015\u0012\u0005\u0012\u00030æ\u0003\u0012\u0004\u0012\u00020604¢\u0006\u0003\bç\u0003H\u0002ø\u0001\u0000¢\u0006\u0006\bè\u0003\u0010é\u0003JA\u0010ê\u0003\u001a\u00030ë\u00032.\u0010ì\u0003\u001a)\b\u0001\u0012\u0005\u0012\u00030î\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u00030ë\u00030ï\u0003\u0012\u0007\u0012\u0005\u0018\u00010ð\u00030í\u0003¢\u0006\u0003\bç\u0003H\u0096@¢\u0006\u0003\u0010ñ\u0003J\t\u0010ò\u0003\u001a\u000206H\u0002J\u000e\u0010ó\u0003\u001a\u00020m*\u00030À\u0001H\u0002J\u001b\u0010ô\u0003\u001a\u00020G*\u00030´\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\bõ\u0003\u0010ö\u0003J\u001b\u0010÷\u0003\u001a\u00020G*\u00030´\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\bø\u0003\u0010ö\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\b\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u00020H2\u0006\u0010\u0011\u001a\u00020H8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010\u0019\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020SX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010Z0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020\\X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R+\u0010`\u001a\u00020_2\u0006\u0010\u0011\u001a\u00020_8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010\u0019\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010f\u001a\u00020g8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\u00020qX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0014\u0010s\u001a\u00020tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020xX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0014\u0010{\u001a\u00020m8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u000e\u0010~\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u007f\u001a\u00030\u0080\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u000f\u0010\u0083\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0084\u0001\u001a\u00020m8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010}R\u000f\u0010\u0085\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR+\u0010\u008b\u0001\u001a\u00030\u008c\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u008d\u0001\u0010i\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0016\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010\u0095\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0011\u001a\u00030\u0094\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u009a\u0001\u0010\u0019\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0010\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u009f\u0001\u001a\u00030 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¡\u0001\u001a\u00030\u008c\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u008f\u0001R\u0018\u0010£\u0001\u001a\u00030¤\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0010\u0010§\u0001\u001a\u00030¨\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001d\u0010¬\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u00ad\u0001\u001a\u00030®\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010±\u0001\u001a\u00030²\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001R\u0010\u0010µ\u0001\u001a\u00030¶\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010·\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010º\u0001\u001a\u00030\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010»\u0001\u001a\b\u0012\u0004\u0012\u0002060ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010¼\u0001\u001a\u00030½\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¾\u0001R\u0018\u0010¿\u0001\u001a\u00030À\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0018\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0010\u0010Ç\u0001\u001a\u00030\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010È\u0001\u001a\u00030É\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ê\u0001\u001a\u00030Ë\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ì\u0001\u001a\u00030Í\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0010\u0010Ð\u0001\u001a\u00030Ñ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ò\u0001\u001a\u00030Ó\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÔ\u0001\u0010Õ\u0001R%\u0010Ö\u0001\u001a\u00020mX\u0096\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b×\u0001\u0010i\u001a\u0005\bØ\u0001\u0010}\"\u0006\bÙ\u0001\u0010Ú\u0001R\u0018\u0010Û\u0001\u001a\u00030Ü\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\u0018\u0010ß\u0001\u001a\u00030à\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010â\u0001R\u000f\u0010ã\u0001\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010ä\u0001\u001a\u00030å\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bæ\u0001\u0010ç\u0001R \u0010è\u0001\u001a\n\u0012\u0005\u0012\u00030ê\u00010é\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ë\u0001R\u0018\u0010ì\u0001\u001a\u00030í\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bî\u0001\u0010ï\u0001R\u0019\u0010ð\u0001\u001a\u00030ñ\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ò\u0001R\u0010\u0010ó\u0001\u001a\u00030ô\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010õ\u0001\u001a\u00030ö\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010÷\u0001\u001a\u00030ø\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bù\u0001\u0010ú\u0001R\u0018\u0010û\u0001\u001a\u00030ü\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bý\u0001\u0010þ\u0001R\u0012\u0010ÿ\u0001\u001a\u0005\u0018\u00010\u0080\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0081\u0002\u001a\u00030ñ\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ò\u0001R!\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u0084\u0002\u0010\u0085\u0002\u001a\u0005\b\u0083\u0002\u0010\u0015R\u000f\u0010\u0086\u0002\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0087\u0002\u001a\u00030\u0088\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R\u0018\u0010\u008b\u0002\u001a\u00030\u008a\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010rR\u0019\u0010\u008c\u0002\u001a\u00030ñ\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010ò\u0001R\u001b\u0010\u008d\u0002\u001a\u00020G*\u0002058BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006û\u0003"}, m195d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", DownloadUtil.CookieScheme.VALUE, "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rotaryInputModifier", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesAccessibilityEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesContentCaptureEventLoop", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "explicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "motionEvent", "dispatchHoverEvent", NotificationCompat.CATEGORY_EVENT, "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchTouchEvent", "drawAndroidView", "findNextNonChildView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "focusSearch", "focused", "forceAccessibilityForTesting", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "localTransform", "localToScreen-58bKbWc", "([F)V", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onClearFocusForOwner", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFetchFocusRect", "Landroidx/compose/ui/geometry/Rect;", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMoveFocusInChildren", "focusDirection", "onMoveFocusInChildren-3ESFkO8", "(I)Z", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestFocusForOwner", "onRequestFocusForOwner-7o62pno", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Landroid/view/ScrollCaptureTarget;", "onSemanticsChange", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestFocus", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setAccessibilityEventBatchIntervalMillis", "accessibilityInterval", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "textInputSession", "", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "Companion", "ViewTreeOwners", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    private static final int MaximumLayerCacheSize = 10;
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;

    /* JADX INFO: renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState _viewTreeOwners;
    private final WindowInfoImpl _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;

    /* JADX INFO: renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;
    private final List<OwnedLayer> dirtyLayers;
    private final DragAndDropManager dragAndDropManager;
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;

    /* JADX INFO: renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* JADX INFO: renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final Modifier rotaryInputModifier;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final AtomicReference<SessionMutex.Session<T>> textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* JADX INFO: renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 */
    /* JADX INFO: compiled from: AndroidComposeView.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.platform.AndroidComposeView", m210f = "AndroidComposeView.android.kt", m211i = {}, m212l = {582}, m213m = "textInputSession", m214n = {}, m215s = {})
    static final class C18331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C18331(Continuation<? super C18331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidComposeView.this.textInputSession(null, this);
        }
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v58, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        this.lastDownPointerPosition = Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
        this.superclassInitComplete = true;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.sharedDrawScope = new LayoutNodeDrawScope(null, 1, 0 == true ? 1 : 0);
        this.density = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        this.semanticsModifier = EmptySemanticsElement.INSTANCE;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object value) {
                ((AndroidComposeView) this.receiver).setLayoutDirection((LayoutDirection) value);
            }
        });
        this.dragAndDropModifierOnDragListener = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = this.dragAndDropModifierOnDragListener;
        this._windowInfo = new WindowInfoImpl();
        this.keyInputModifier = KeyInputModifierKt.onKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m5969invokeZmokQxo(keyEvent.m5358unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m5969invokeZmokQxo(android.view.KeyEvent keyEvent) {
                final FocusDirection focusDirection = this.this$0.mo5931getFocusDirectionP8AzH3I(keyEvent);
                if (focusDirection != null && KeyEventType.m5362equalsimpl0(KeyEvent_androidKt.m5370getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5366getKeyDownCS__XNY())) {
                    Rect focusedRect = this.this$0.onFetchFocusRect();
                    Boolean boolMo3980focusSearchULY8qGw = this.this$0.getFocusOwner().mo3980focusSearchULY8qGw(focusDirection.getValue(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(FocusTargetNode it) {
                            Boolean boolM4000requestFocusMxy_nc0 = FocusTransactionsKt.m4000requestFocusMxy_nc0(it, focusDirection.getValue());
                            return Boolean.valueOf(boolM4000requestFocusMxy_nc0 != null ? boolM4000requestFocusMxy_nc0.booleanValue() : true);
                        }
                    });
                    boolean focusWasMovedOrCancelled = boolMo3980focusSearchULY8qGw != null ? boolMo3980focusSearchULY8qGw.booleanValue() : true;
                    if (focusWasMovedOrCancelled) {
                        return true;
                    }
                    if (!FocusOwnerImplKt.m3987is1dFocusSearch3ESFkO8(focusDirection.getValue())) {
                        return false;
                    }
                    Integer numM3975toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m3975toAndroidFocusDirection3ESFkO8(focusDirection.getValue());
                    if (numM3975toAndroidFocusDirection3ESFkO8 == null) {
                        throw new IllegalStateException("Invalid focus direction".toString());
                    }
                    int androidDirection = numM3975toAndroidFocusDirection3ESFkO8.intValue();
                    android.graphics.Rect androidRect = focusedRect != null ? RectHelper_androidKt.toAndroidRect(focusedRect) : null;
                    if (androidRect == null) {
                        throw new IllegalStateException("Invalid rect".toString());
                    }
                    View nextView = this.this$0.findNextNonChildView(androidDirection);
                    if (!(!Intrinsics.areEqual(nextView, this.this$0))) {
                        nextView = null;
                    }
                    if (nextView != null && FocusInteropUtils_androidKt.requestInteropFocus(nextView, Integer.valueOf(androidDirection), androidRect)) {
                        return true;
                    }
                    boolean clearedFocusSuccessfully = this.this$0.getFocusOwner().mo3977clearFocusI7lrPNg(false, true, false, focusDirection.getValue());
                    if (!clearedFocusSuccessfully) {
                        return true;
                    }
                    Boolean boolMo3980focusSearchULY8qGw2 = this.this$0.getFocusOwner().mo3980focusSearchULY8qGw(focusDirection.getValue(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(FocusTargetNode it) {
                            Boolean boolM4000requestFocusMxy_nc0 = FocusTransactionsKt.m4000requestFocusMxy_nc0(it, focusDirection.getValue());
                            return Boolean.valueOf(boolM4000requestFocusMxy_nc0 != null ? boolM4000requestFocusMxy_nc0.booleanValue() : true);
                        }
                    });
                    return Boolean.valueOf(boolMo3980focusSearchULY8qGw2 != null ? boolMo3980focusSearchULY8qGw2.booleanValue() : true);
                }
                return false;
            }
        });
        this.rotaryInputModifier = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.INSTANCE, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent it) {
                return false;
            }
        });
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(Modifier.INSTANCE.then(this.semanticsModifier).then(this.rotaryInputModifier).then(this.keyInputModifier).then(getFocusOwner().getModifier()).then(this.dragAndDropModifierOnDragListener.getModifier()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        this.composeAccessibilityDelegate = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration it) {
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.viewConfiguration = new AndroidViewConfiguration(ViewConfiguration.get(context));
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        this.tmpMatrix = Matrix.m4529constructorimpl$default(null, 1, null);
        this.viewToWindowMatrix = Matrix.m4529constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m4529constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.INSTANCE.m4063getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                return this.this$0.get_viewTreeOwners();
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.touchModeChangeListener$lambda$6(this.f$0, z);
            }
        };
        this.legacyTextInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(this.legacyTextInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m3911constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, null, 2, null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m5052getTouchaOaMEAU() : InputMode.INSTANCE.m5051getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m5965invokeiuPiT84(inputMode.getValue());
            }

            /* JADX INFO: renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m5965invokeiuPiT84(int it) {
                boolean zRequestFocusFromTouch;
                if (InputMode.m5047equalsimpl0(it, InputMode.INSTANCE.m5052getTouchaOaMEAU())) {
                    zRequestFocusFromTouch = this.this$0.isInTouchMode();
                } else if (InputMode.m5047equalsimpl0(it, InputMode.INSTANCE.m5051getKeyboardaOaMEAU())) {
                    zRequestFocusFromTouch = this.this$0.isInTouchMode() ? this.this$0.requestFocusFromTouch() : true;
                } else {
                    zRequestFocusFromTouch = false;
                }
                return Boolean.valueOf(zRequestFocusFromTouch);
            }
        }, objArr2 == true ? 1 : 0);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                int newAction;
                this.this$0.removeCallbacks(this);
                MotionEvent lastMotionEvent = this.this$0.previousMotionEvent;
                if (lastMotionEvent != null) {
                    boolean z = false;
                    boolean wasMouseEvent = lastMotionEvent.getToolType(0) == 3;
                    int action = lastMotionEvent.getActionMasked();
                    if (wasMouseEvent) {
                        if (action != 10 && action != 1) {
                            z = true;
                        }
                    } else if (action != 1) {
                        z = true;
                    }
                    boolean resend = z;
                    if (resend) {
                        switch (action) {
                            case 7:
                            case 9:
                                newAction = 7;
                                break;
                            case 8:
                            default:
                                newAction = 2;
                                break;
                        }
                        this.this$0.sendSimulatedEvent(lastMotionEvent, newAction, this.this$0.relayoutTime, false);
                    }
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$8(this.f$0);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
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
                MotionEvent lastEvent = this.this$0.previousMotionEvent;
                if (lastEvent != null) {
                    switch (lastEvent.getActionMasked()) {
                        case 7:
                        case 9:
                            this.this$0.relayoutTime = SystemClock.uptimeMillis();
                            this.this$0.post(this.this$0.resendMotionEventRunnable);
                            break;
                    }
                }
            }
        };
        this.matrixToWindow = Build.VERSION.SDK_INT < 29 ? new CalculateMatrixToWindowApi21(this.tmpMatrix, objArr == true ? 1 : 0) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, this.composeAccessibilityDelegate);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(this.dragAndDropModifierOnDragListener);
        getRoot().attach$ui_release(this);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentIcon = PointerIcon.INSTANCE.getDefault();

            @Override // androidx.compose.p001ui.input.pointer.PointerIconService
            /* JADX INFO: renamed from: getIcon, reason: from getter */
            public PointerIcon getCurrentIcon() {
                return this.currentIcon;
            }

            @Override // androidx.compose.p001ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon value) {
                this.currentIcon = value == null ? PointerIcon.INSTANCE.getDefault() : value;
                if (Build.VERSION.SDK_INT >= 24) {
                    AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this.this$0, this.currentIcon);
                }
            }
        };
    }

    @Override // androidx.compose.p001ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.p001ui.platform.ViewRootForTest
    public View getView() {
        return this;
    }

    private void setDensity(Density density) {
        MutableState $this$setValue$iv = this.density;
        $this$setValue$iv.setValue(density);
    }

    @Override // androidx.compose.p001ui.node.Owner, androidx.compose.p001ui.node.RootForTest
    public Density getDensity() {
        State $this$getValue$iv = this.density;
        return (Density) $this$getValue$iv.getValue();
    }

    @Override // androidx.compose.p001ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public void setCoroutineContext(CoroutineContext value) {
        DelegatableNode delegatableNode;
        DelegatableNode $this$visitSubtree_u2d6rFNWt0$iv;
        DelegatableNode delegatableNode2;
        DelegatableNode $this$visitSubtree_u2d6rFNWt0$iv2;
        this.coroutineContext = value;
        DelegatableNode head = getRoot().getNodes().getHead();
        if (head instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) head).resetPointerInputHandler();
        }
        DelegatableNode $this$visitSubtree_u2d6rFNWt0$iv3 = head;
        int iM5876constructorimpl = NodeKind.m5876constructorimpl(16);
        boolean value$iv$iv$iv = $this$visitSubtree_u2d6rFNWt0$iv3.getNode().getIsAttached();
        if (!value$iv$iv$iv) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        Modifier.Node node$iv$iv = $this$visitSubtree_u2d6rFNWt0$iv3.getNode().getChild();
        LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitSubtree_u2d6rFNWt0$iv3);
        NestedVectorStack nodes$iv$iv = new NestedVectorStack();
        while (layout$iv$iv != null) {
            Modifier.Node node$iv$iv2 = node$iv$iv == null ? layout$iv$iv.getNodes().getHead() : node$iv$iv;
            if ((node$iv$iv2.getAggregateChildKindSet() & iM5876constructorimpl) != 0) {
                while (node$iv$iv2 != null) {
                    if ((node$iv$iv2.getKindSet() & iM5876constructorimpl) != 0) {
                        Modifier.Node it$iv = node$iv$iv2;
                        MutableVector mutableVector = null;
                        Modifier.Node nodePop = it$iv;
                        while (nodePop != null) {
                            if (nodePop instanceof PointerInputModifierNode) {
                                PointerInputModifierNode it = (PointerInputModifierNode) nodePop;
                                delegatableNode2 = head;
                                if (it instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) it).resetPointerInputHandler();
                                }
                                $this$visitSubtree_u2d6rFNWt0$iv2 = $this$visitSubtree_u2d6rFNWt0$iv3;
                            } else {
                                delegatableNode2 = head;
                                Modifier.Node this_$iv$iv$iv = nodePop;
                                int kindSet = this_$iv$iv$iv.getKindSet() & iM5876constructorimpl;
                                int i = 1;
                                if ((kindSet != 0 ? 1 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                    $this$visitSubtree_u2d6rFNWt0$iv2 = $this$visitSubtree_u2d6rFNWt0$iv3;
                                } else {
                                    int count$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if ((next$iv$iv.getKindSet() & iM5876constructorimpl) != 0) {
                                            count$iv$iv++;
                                            if (count$iv$iv == i) {
                                                nodePop = next$iv$iv;
                                                $this$visitSubtree_u2d6rFNWt0$iv3 = $this$visitSubtree_u2d6rFNWt0$iv3;
                                            } else {
                                                MutableVector mutableVector2 = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                                Modifier.Node theNode$iv$iv = nodePop;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv);
                                                }
                                                mutableVector = mutableVector2;
                                                count$iv$iv = count$iv$iv;
                                            }
                                        } else {
                                            $this$visitSubtree_u2d6rFNWt0$iv3 = $this$visitSubtree_u2d6rFNWt0$iv3;
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        $this$visitSubtree_u2d6rFNWt0$iv3 = $this$visitSubtree_u2d6rFNWt0$iv3;
                                        i = 1;
                                    }
                                    $this$visitSubtree_u2d6rFNWt0$iv2 = $this$visitSubtree_u2d6rFNWt0$iv3;
                                    if (count$iv$iv == 1) {
                                        head = delegatableNode2;
                                        $this$visitSubtree_u2d6rFNWt0$iv3 = $this$visitSubtree_u2d6rFNWt0$iv2;
                                    }
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                            head = delegatableNode2;
                            $this$visitSubtree_u2d6rFNWt0$iv3 = $this$visitSubtree_u2d6rFNWt0$iv2;
                        }
                    }
                    node$iv$iv2 = node$iv$iv2.getChild();
                    head = head;
                    $this$visitSubtree_u2d6rFNWt0$iv3 = $this$visitSubtree_u2d6rFNWt0$iv3;
                }
                delegatableNode = head;
                $this$visitSubtree_u2d6rFNWt0$iv = $this$visitSubtree_u2d6rFNWt0$iv3;
            } else {
                delegatableNode = head;
                $this$visitSubtree_u2d6rFNWt0$iv = $this$visitSubtree_u2d6rFNWt0$iv3;
            }
            node$iv$iv = null;
            nodes$iv$iv.push(layout$iv$iv.get_children$ui_release());
            layout$iv$iv = nodes$iv$iv.isNotEmpty() ? (LayoutNode) nodes$iv$iv.pop() : null;
            head = delegatableNode;
            $this$visitSubtree_u2d6rFNWt0$iv3 = $this$visitSubtree_u2d6rFNWt0$iv;
        }
    }

    @Override // androidx.compose.p001ui.node.Owner
    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onMoveFocusInChildren-3ESFkO8, reason: not valid java name */
    public final boolean m5960onMoveFocusInChildren3ESFkO8(int focusDirection) {
        View viewFindNextFocusFromRect;
        if (FocusDirection.m3961equalsimpl0(focusDirection, FocusDirection.INSTANCE.m3968getEnterdhqQ8s()) || FocusDirection.m3961equalsimpl0(focusDirection, FocusDirection.INSTANCE.m3969getExitdhqQ8s())) {
            return false;
        }
        Integer numM3975toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m3975toAndroidFocusDirection3ESFkO8(focusDirection);
        if (numM3975toAndroidFocusDirection3ESFkO8 == null) {
            throw new IllegalStateException("Invalid focus direction".toString());
        }
        int direction = numM3975toAndroidFocusDirection3ESFkO8.intValue();
        Rect rectOnFetchFocusRect = onFetchFocusRect();
        android.graphics.Rect focusedRect = rectOnFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(rectOnFetchFocusRect) : null;
        FocusFinder it = FocusFinder.getInstance();
        if (focusedRect == null) {
            viewFindNextFocusFromRect = it.findNextFocus(this, findFocus(), direction);
        } else {
            viewFindNextFocusFromRect = it.findNextFocusFromRect(this, focusedRect, direction);
        }
        View nextView = viewFindNextFocusFromRect;
        if (nextView != null) {
            return FocusInteropUtils_androidKt.requestInteropFocus(nextView, Integer.valueOf(direction), focusedRect);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect onFetchFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return FocusInteropUtils_androidKt.calculateBoundingRect(viewFindFocus);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findNextNonChildView(int direction) {
        AndroidComposeView currentView = this;
        while (currentView != null) {
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            currentView = focusFinder.findNextFocus((ViewGroup) rootView, currentView, direction);
            if (currentView != null && !AndroidComposeView_androidKt.containsDescendant(this, currentView)) {
                return currentView;
            }
        }
        return null;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @Override // androidx.compose.p001ui.node.RootForTest
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    /* JADX INFO: renamed from: getContentCaptureManager$ui_release, reason: from getter */
    public final AndroidContentCaptureManager getContentCaptureManager() {
        return this.contentCaptureManager;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            this._androidViewsHandler = new AndroidViewsHandler(getContext());
            addView(this._androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler);
        return androidViewsHandler;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.p001ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.p001ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    /* JADX INFO: renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeOwners get_viewTreeOwners() {
        State $this$getValue$iv = this._viewTreeOwners;
        return (ViewTreeOwners) $this$getValue$iv.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        MutableState $this$setValue$iv = this._viewTreeOwners;
        $this$setValue$iv.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        State $this$getValue$iv = this.viewTreeOwners;
        return (ViewTreeOwners) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$6(AndroidComposeView this$0, boolean touchMode) {
        InputModeManagerImpl inputModeManagerImpl = this$0._inputModeManager;
        InputMode.Companion companion = InputMode.INSTANCE;
        inputModeManagerImpl.m5055setInputModeiuPiT84(touchMode ? companion.m5052getTouchaOaMEAU() : companion.m5051getKeyboardaOaMEAU());
    }

    @Override // androidx.compose.p001ui.node.Owner, androidx.compose.p001ui.node.RootForTest
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.p001ui.node.Owner
    public Object textInputSession(Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        C18331 c18331;
        if (continuation instanceof C18331) {
            c18331 = (C18331) continuation;
            if ((c18331.label & Integer.MIN_VALUE) != 0) {
                c18331.label -= Integer.MIN_VALUE;
            } else {
                c18331 = new C18331(continuation);
            }
        } else {
            c18331 = new C18331(continuation);
        }
        C18331 c18332 = c18331;
        Object $result = c18332.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c18332.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AtomicReference<SessionMutex.Session<T>> atomicReference = this.textInputSessionMutex;
                Function1<CoroutineScope, AndroidPlatformTextInputSession> function1 = new Function1<CoroutineScope, AndroidPlatformTextInputSession>() { // from class: androidx.compose.ui.platform.AndroidComposeView.textInputSession.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AndroidPlatformTextInputSession invoke(CoroutineScope it) {
                        return new AndroidPlatformTextInputSession(AndroidComposeView.this, AndroidComposeView.this.getTextInputService(), it);
                    }
                };
                c18332.label = 1;
                if (SessionMutex.m3918withSessionCancellingPreviousimpl(atomicReference, function1, function2, c18332) == coroutine_suspended) {
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

    @Override // androidx.compose.p001ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        MutableState $this$setValue$iv = this.fontFamilyResolver;
        $this$setValue$iv.setValue(resolver);
    }

    @Override // androidx.compose.p001ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        State $this$getValue$iv = this.fontFamilyResolver;
        return (FontFamily.Resolver) $this$getValue$iv.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration $this$fontWeightAdjustmentCompat) {
        if (Build.VERSION.SDK_INT >= 31) {
            return $this$fontWeightAdjustmentCompat.fontWeightAdjustment;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        MutableState $this$setValue$iv = this.layoutDirection;
        $this$setValue$iv.setValue(layoutDirection);
    }

    @Override // android.view.View, android.view.ViewParent, androidx.compose.p001ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        State $this$getValue$iv = this.layoutDirection;
        return (LayoutDirection) $this$getValue$iv.getValue();
    }

    @Override // androidx.compose.p001ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$8(AndroidComposeView this$0) {
        this$0.hoverExitReceived = false;
        MotionEvent lastEvent = this$0.previousMotionEvent;
        Intrinsics.checkNotNull(lastEvent);
        if (!(lastEvent.getActionMasked() == 10)) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        this$0.m5963sendMotionEvent8iAsVTc(lastEvent);
    }

    @Override // android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        Unit unit;
        Rect $this$getFocusedRect_u24lambda_u249 = onFetchFocusRect();
        if ($this$getFocusedRect_u24lambda_u249 != null) {
            float $this$fastRoundToInt$iv = $this$getFocusedRect_u24lambda_u249.getLeft();
            rect.left = Math.round($this$fastRoundToInt$iv);
            float $this$fastRoundToInt$iv2 = $this$getFocusedRect_u24lambda_u249.getTop();
            rect.top = Math.round($this$fastRoundToInt$iv2);
            float $this$fastRoundToInt$iv3 = $this$getFocusedRect_u24lambda_u249.getRight();
            rect.right = Math.round($this$fastRoundToInt$iv3);
            float $this$fastRoundToInt$iv4 = $this$getFocusedRect_u24lambda_u249.getBottom();
            rect.bottom = Math.round($this$fastRoundToInt$iv4);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(android.graphics.Rect localVisibleRect, Point windowOffset, Consumer<ScrollCaptureTarget> targets) {
        if (Build.VERSION.SDK_INT >= 31) {
            ScrollCapture.INSTANCE.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), targets);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        if (focused != null) {
            Rect focusedBounds = FocusInteropUtils_androidKt.calculateBoundingRect(focused);
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
            int focusDirection2 = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m3967getDowndhqQ8s();
            if (Intrinsics.areEqual((Object) getFocusOwner().mo3980focusSearchULY8qGw(focusDirection2, focusedBounds, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.focusSearch.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode it) {
                    return true;
                }
            }), (Object) true)) {
                return this;
            }
        }
        return super.focusSearch(focused, direction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        if (isInTouchMode()) {
            return false;
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
        final int focusDirection2 = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m3968getEnterdhqQ8s();
        Boolean boolMo3980focusSearchULY8qGw = getFocusOwner().mo3980focusSearchULY8qGw(focusDirection2, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.requestFocus.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode it) {
                Boolean boolM4000requestFocusMxy_nc0 = FocusTransactionsKt.m4000requestFocusMxy_nc0(it, focusDirection2);
                return Boolean.valueOf(boolM4000requestFocusMxy_nc0 != null ? boolM4000requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (boolMo3980focusSearchULY8qGw != null) {
            return boolMo3980focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onRequestFocusForOwner-7o62pno, reason: not valid java name */
    public final boolean m5961onRequestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        Integer numM3975toAndroidFocusDirection3ESFkO8;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (numM3975toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m3975toAndroidFocusDirection3ESFkO8(focusDirection.getValue())) == null) ? 130 : numM3975toAndroidFocusDirection3ESFkO8.intValue(), previouslyFocusedRect != null ? RectHelper_androidKt.toAndroidRect(previouslyFocusedRect) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClearFocusForOwner() {
        if (isFocused() || hasFocus()) {
            super.clearFocus();
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (!gainFocus && !hasFocus()) {
            getFocusOwner().releaseFocus();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean newShowLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && getShowLayoutBounds() != (newShowLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            setShowLayoutBounds(newShowLayoutBounds);
            invalidateDescendants();
        }
    }

    @Override // androidx.compose.p001ui.node.RootForTest
    /* JADX INFO: renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo5933sendKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        return getFocusOwner().mo3978dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || FocusOwner.CC.m3983dispatchKeyEventYhN2O0w$default(getFocusOwner(), keyEvent, null, 2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final android.view.KeyEvent event) {
        if (isFocused()) {
            this._windowInfo.m6044setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5574constructorimpl(event.getMetaState()));
            return FocusOwner.CC.m3983dispatchKeyEventYhN2O0w$default(getFocusOwner(), KeyEvent.m5353constructorimpl(event), null, 2, null) || super.dispatchKeyEvent(event);
        }
        return getFocusOwner().mo3979dispatchKeyEventYhN2O0w(KeyEvent.m5353constructorimpl(event), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.dispatchKeyEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(AndroidComposeView.super.dispatchKeyEvent(event));
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        return (isFocused() && getFocusOwner().mo3978dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m5353constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // androidx.compose.p001ui.node.RootForTest
    public void forceAccessibilityForTesting() {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui_release(true);
    }

    @Override // androidx.compose.p001ui.node.RootForTest
    public void setAccessibilityEventBatchIntervalMillis(long accessibilityInterval) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(accessibilityInterval);
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void onAttach(LayoutNode node) {
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void onDetach(LayoutNode node) {
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler childAndroidViews = this._androidViewsHandler;
        if (childAndroidViews != null) {
            clearChildInvalidObservations(childAndroidViews);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0<Unit> function0 = this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startDrag-12SF9DM, reason: not valid java name */
    public final boolean m5964startDrag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources $this$startDrag_12SF9DM_u24lambda_u2411 = getContext().getResources();
        Density density = DensityKt.Density($this$startDrag_12SF9DM_u24lambda_u2411.getDisplayMetrics().density, $this$startDrag_12SF9DM_u24lambda_u2411.getConfiguration().fontScale);
        ComposeDragShadowBuilder shadowBuilder = new ComposeDragShadowBuilder(density, decorationSize, drawDragDecoration, null);
        if (Build.VERSION.SDK_INT >= 24) {
            return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, transferData, shadowBuilder);
        }
        return startDrag(transferData.getClipData(), shadowBuilder, transferData.getLocalState(), transferData.getFlags());
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof AndroidComposeView) {
                ((AndroidComposeView) child).onEndApplyChanges();
            } else if (child instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        Integer num;
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal())) {
            Integer num2 = this.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().get(virtualViewId);
            if (num2 != null) {
                int it = num2.intValue();
                info.getExtras().putInt(extraDataKey, it);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal()) && (num = this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().get(virtualViewId)) != null) {
            int it2 = num.intValue();
            info.getExtras().putInt(extraDataKey, it2);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        addView(child, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        Intrinsics.checkNotNull(child);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        ViewGroup.LayoutParams it = generateDefaultLayoutParams();
        it.width = width;
        it.height = height;
        Unit unit = Unit.INSTANCE;
        addView(child, -1, it);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView.addAndroidView.1
            /* JADX WARN: Code duplicated, block: B:13:0x0042  */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(host, info);
                if (AndroidComposeView.this.composeAccessibilityDelegate.isEnabled$ui_release()) {
                    info.setVisibleToUser(false);
                }
                LayoutNode layoutNodeFindClosestParentNode = SemanticsNodeKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode it) {
                        return Boolean.valueOf(it.getNodes().m5839hasH91voCI$ui_release(NodeKind.m5876constructorimpl(8)));
                    }
                });
                Integer parentId = layoutNodeFindClosestParentNode != null ? Integer.valueOf(layoutNodeFindClosestParentNode.getSemanticsId()) : null;
                if (parentId != null) {
                    if (parentId.intValue() == AndroidComposeView.this.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                        parentId = -1;
                    }
                } else {
                    parentId = -1;
                }
                info.setParent(this, parentId.intValue());
                int semanticsId = layoutNode.getSemanticsId();
                Integer beforeId = AndroidComposeView.this.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().get(semanticsId);
                if (beforeId != null) {
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    AndroidComposeView androidComposeView2 = this;
                    int it = beforeId.intValue();
                    View beforeView = SemanticsUtils_androidKt.semanticsIdToView(androidComposeView.getAndroidViewsHandler$ui_release(), beforeId.intValue());
                    if (beforeView != null) {
                        info.setTraversalBefore(beforeView);
                    } else {
                        info.setTraversalBefore(androidComposeView2, it);
                    }
                    androidComposeView.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, info.unwrap(), androidComposeView.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal());
                }
                Integer afterId = AndroidComposeView.this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().get(semanticsId);
                if (afterId != null) {
                    AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                    AndroidComposeView androidComposeView4 = this;
                    int it2 = afterId.intValue();
                    View afterView = SemanticsUtils_androidKt.semanticsIdToView(androidComposeView3.getAndroidViewsHandler$ui_release(), afterId.intValue());
                    if (afterView != null) {
                        info.setTraversalAfter(afterView);
                    } else {
                        info.setTraversalAfter(androidComposeView4, it2);
                    }
                    androidComposeView3.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, info.unwrap(), androidComposeView3.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal());
                }
            }
        });
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView.removeAndroidView.1
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
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                view.setImportantForAccessibility(0);
            }
        });
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (nodeToRemeasure != null) {
                LayoutNode node = nodeToRemeasure;
                while (node != null && node.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(node)) {
                    node = node.getParent$ui_release();
                }
                if (node == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode $this$childSizeCanAffectParentSize) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui_release = $this$childSizeCanAffectParentSize.getParent$ui_release();
        return parent$ui_release != null && !parent$ui_release.getHasFixedInnerContentConstraints$ui_release();
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0<Unit> function0;
        if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() && !this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            return;
        }
        Trace.beginSection("AndroidOwner:measureAndLayout");
        if (!sendPointerUpdate) {
            function0 = null;
        } else {
            try {
                function0 = this.resendMotionEventOnLayout;
            } finally {
                Trace.endSection();
            }
        }
        boolean rootNodeResized = this.measureAndLayoutDelegate.measureAndLayout(function0);
        if (rootNodeResized) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
        Unit unit = Unit.INSTANCE;
    }

    @Override // androidx.compose.p001ui.node.Owner
    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw */
    public void mo5932measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m5832measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.p001ui.node.RootForTest
    public void measureAndLayoutForTest() {
        Owner.CC.measureAndLayout$default(this, false, 1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws Throwable {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long $this$component2_u2dVKZWuLQ$iv = m5958convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int minWidth = (int) ULong.m7867constructorimpl($this$component2_u2dVKZWuLQ$iv >>> 32);
            int maxWidth = (int) ULong.m7867constructorimpl($this$component2_u2dVKZWuLQ$iv & 4294967295L);
            try {
                long $this$component2_u2dVKZWuLQ$iv2 = m5958convertMeasureSpecI7RO_PI(heightMeasureSpec);
                int minHeight = (int) ULong.m7867constructorimpl($this$component2_u2dVKZWuLQ$iv2 >>> 32);
                int maxHeight = (int) ULong.m7867constructorimpl(4294967295L & $this$component2_u2dVKZWuLQ$iv2);
                long constraints = ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight);
                if (this.onMeasureConstraints == null) {
                    this.onMeasureConstraints = Constraints.m6732boximpl(constraints);
                    this.wasMeasuredWithMultipleConstraints = false;
                } else {
                    Constraints constraints2 = this.onMeasureConstraints;
                    if (!(constraints2 != null ? Constraints.m6737equalsimpl0(constraints2.getValue(), constraints) : false)) {
                        this.wasMeasuredWithMultipleConstraints = true;
                    }
                }
                this.measureAndLayoutDelegate.m5833updateRootConstraintsBRTryo0(constraints);
                this.measureAndLayoutDelegate.measureOnly();
                setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
                if (this._androidViewsHandler != null) {
                    getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), BasicMeasure.EXACTLY));
                }
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: component1-VKZWuLQ, reason: not valid java name */
    private final int m5956component1VKZWuLQ(long $this$component1_u2dVKZWuLQ) {
        return (int) ULong.m7867constructorimpl($this$component1_u2dVKZWuLQ >>> 32);
    }

    /* JADX INFO: renamed from: component2-VKZWuLQ, reason: not valid java name */
    private final int m5957component2VKZWuLQ(long $this$component2_u2dVKZWuLQ) {
        return (int) ULong.m7867constructorimpl(4294967295L & $this$component2_u2dVKZWuLQ);
    }

    /* JADX INFO: renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m5962packZIaKswc(int a, int b) {
        return ULong.m7867constructorimpl(ULong.m7867constructorimpl(ULong.m7867constructorimpl(a) << 32) | ULong.m7867constructorimpl(b));
    }

    /* JADX INFO: renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m5958convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case Integer.MIN_VALUE:
                return m5962packZIaKswc(0, size);
            case 0:
                return m5962packZIaKswc(0, Integer.MAX_VALUE);
            case BasicMeasure.EXACTLY /* 1073741824 */:
                return m5962packZIaKswc(size, size);
            default:
                throw new IllegalStateException();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) throws Throwable {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionCacheAndDispatch() {
        boolean positionChanged = false;
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int iM6933getXimpl = IntOffset.m6933getXimpl(j);
        int globalY = IntOffset.m6934getYimpl(j);
        if (iM6933getXimpl != this.tmpPositionArray[0] || globalY != this.tmpPositionArray[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(this.tmpPositionArray[0], this.tmpPositionArray[1]);
            if (iM6933getXimpl != Integer.MAX_VALUE && globalY != Integer.MAX_VALUE) {
                positionChanged = true;
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(positionChanged);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // androidx.compose.p001ui.node.Owner
    public OwnedLayer createLayer(Function1<? super androidx.compose.p001ui.graphics.Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer) {
        ViewLayerContainer viewLayerContainer;
        if (explicitLayer != null) {
            return new GraphicsLayerOwnerLayer(explicitLayer, this, drawBlock, invalidateParentLayer);
        }
        OwnedLayer layer = this.layerCache.pop();
        if (layer != null) {
            layer.reuseLayer(drawBlock, invalidateParentLayer);
            return layer;
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT >= 23 && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable th) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.INSTANCE.getHasRetrievedMethod()) {
                ViewLayer.INSTANCE.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
                viewLayerContainer = new DrawChildContainer(getContext());
            } else {
                viewLayerContainer = new ViewLayerContainer(getContext());
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(this.viewLayersContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        boolean cacheValue = this.viewLayersContainer == null || ViewLayer.INSTANCE.getShouldUseDispatchDraw() || Build.VERSION.SDK_INT >= 23 || this.layerCache.getSize() < 10;
        if (cacheValue) {
            this.layerCache.push(layer);
        }
        return cacheValue;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release(layoutNode);
    }

    @Override // androidx.compose.p001ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.p001ui.node.Owner
    /* JADX INFO: renamed from: getFocusDirection-P8AzH3I */
    public FocusDirection mo5931getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        long jM5369getKeyZmokQxo = KeyEvent_androidKt.m5369getKeyZmokQxo(keyEvent);
        if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5297getTabEK5gGoQ())) {
            return FocusDirection.m3958boximpl(KeyEvent_androidKt.m5375isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m3972getPreviousdhqQ8s() : FocusDirection.INSTANCE.m3971getNextdhqQ8s());
        }
        if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5138getDirectionRightEK5gGoQ())) {
            return FocusDirection.m3958boximpl(FocusDirection.INSTANCE.m3973getRightdhqQ8s());
        }
        if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5137getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m3958boximpl(FocusDirection.INSTANCE.m3970getLeftdhqQ8s());
        }
        if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5139getDirectionUpEK5gGoQ()) ? true : Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5250getPageUpEK5gGoQ())) {
            return FocusDirection.m3958boximpl(FocusDirection.INSTANCE.m3974getUpdhqQ8s());
        }
        if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5134getDirectionDownEK5gGoQ()) ? true : Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5249getPageDownEK5gGoQ())) {
            return FocusDirection.m3958boximpl(FocusDirection.INSTANCE.m3967getDowndhqQ8s());
        }
        if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5133getDirectionCenterEK5gGoQ()) ? true : Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5147getEnterEK5gGoQ()) ? true : Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5239getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m3958boximpl(FocusDirection.INSTANCE.m3968getEnterdhqQ8s());
        }
        if (Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5076getBackEK5gGoQ()) ? true : Key.m5061equalsimpl0(jM5369getKeyZmokQxo, Key.INSTANCE.m5150getEscapeEK5gGoQ())) {
            return FocusDirection.m3958boximpl(FocusDirection.INSTANCE.m3969getExitdhqQ8s());
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws Throwable {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.CC.measureAndLayout$default(this, false, 1, null);
        Snapshot.INSTANCE.sendApplyNotifications();
        this.isDrawingContent = true;
        CanvasHolder this_$iv = this.canvasHolder;
        Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
        this_$iv.getAndroidCanvas().setInternalCanvas(canvas);
        androidx.compose.p001ui.graphics.Canvas $this$dispatchDraw_u24lambda_u2418 = this_$iv.getAndroidCanvas();
        getRoot().draw$ui_release($this$dispatchDraw_u24lambda_u2418, null);
        this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                OwnedLayer layer = this.dirtyLayers.get(i);
                layer.updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int saveCount = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(saveCount);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        if (this.postponedDirtyLayers != null) {
            List<OwnedLayer> list = this.postponedDirtyLayers;
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        if (!isDirty) {
            if (!this.isDrawingContent) {
                this.dirtyLayers.remove(layer);
                List<OwnedLayer> list = this.postponedDirtyLayers;
                if (list != null) {
                    list.remove(layer);
                    return;
                }
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        ArrayList arrayList = this.postponedDirtyLayers;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.postponedDirtyLayers = arrayList;
        }
        arrayList.add(layer);
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = callback;
        }
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) throws Throwable {
        Object objBoundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object objBoundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return objBoundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBoundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size$iv$iv = mutableVector.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = mutableVector.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            invalidateLayoutNodeMeasurement(it);
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size$iv$iv = mutableVector.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = mutableVector.getContent();
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            invalidateLayers(it);
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    @Override // androidx.compose.p001ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        LifecycleOwner lifecycleOwner2;
        Lifecycle lifecycle;
        AndroidAutofill it;
        super.onAttachedToWindow();
        this._windowInfo.setWindowFocused(hasWindowFocus());
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (it = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(it);
        }
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners oldViewTreeOwners = getViewTreeOwners();
        boolean resetViewTreeOwner = oldViewTreeOwners == null || !(lifecycleOwner3 == null || savedStateRegistryOwner == null || (lifecycleOwner3 == oldViewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == oldViewTreeOwners.getLifecycleOwner()));
        Lifecycle lifecycle2 = null;
        if (resetViewTreeOwner) {
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (oldViewTreeOwners != null && (lifecycleOwner2 = oldViewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner2.getLifecycleRegistry()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner3.getLifecycleRegistry().addObserver(this);
            ViewTreeOwners viewTreeOwners = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m5055setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m5052getTouchaOaMEAU() : InputMode.INSTANCE.m5051getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
        if (viewTreeOwners2 != null && (lifecycleOwner = viewTreeOwners2.getLifecycleOwner()) != null) {
            lifecycle2 = lifecycleOwner.getLifecycleRegistry();
        }
        if (lifecycle2 != null) {
            lifecycle2.addObserver(this);
            lifecycle2.addObserver(this.contentCaptureManager);
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(this);
                return;
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill it;
        LifecycleOwner lifecycleOwner;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle = (viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null) ? null : lifecycleOwner.getLifecycleRegistry();
        if (lifecycle != null) {
            lifecycle.removeObserver(this.contentCaptureManager);
            lifecycle.removeObserver(this);
            if (autofillSupported() && (it = this._autofill) != null) {
                AutofillCallback.INSTANCE.unregister(it);
            }
            getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
            getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
            getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
            if (Build.VERSION.SDK_INT >= 31) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
                return;
            }
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || structure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        this.contentCaptureManager.onVirtualViewTranslationResponses$ui_release(this.contentCaptureManager, response);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
                return super.dispatchGenericMotionEvent(motionEvent);
            }
            return motionEvent.isFromSource(4194304) ? handleRotaryEvent(motionEvent) : ProcessResult.m5600getDispatchedToAPointerInputModifierimpl(m5959handleMotionEvent8iAsVTc(motionEvent));
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent lastEvent = this.previousMotionEvent;
            Intrinsics.checkNotNull(lastEvent);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, lastEvent)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int processResult = m5959handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m5599getAnyMovementConsumedimpl(processResult)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m5600getDispatchedToAPointerInputModifierimpl(processResult);
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        ViewConfiguration config = ViewConfiguration.get(getContext());
        float axisValue = -event.getAxisValue(26);
        RotaryScrollEvent rotaryEvent = new RotaryScrollEvent(axisValue * ViewConfigurationCompat.getScaledVerticalScrollFactor(config, getContext()), axisValue * ViewConfigurationCompat.getScaledHorizontalScrollFactor(config, getContext()), event.getEventTime(), event.getDeviceId());
        return getFocusOwner().dispatchRotaryEvent(rotaryEvent);
    }

    /* JADX INFO: renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m5959handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        int i;
        boolean previousAndCurrentCoordinatesDoNotMatch;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int action = motionEvent.getActionMasked();
                MotionEvent lastEvent = this.previousMotionEvent;
                boolean wasMouseEvent = lastEvent != null && lastEvent.getToolType(0) == 3;
                if (lastEvent == null || !hasChangedDevices(motionEvent, lastEvent)) {
                    i = 3;
                } else if (!isDevicePressEvent(lastEvent)) {
                    if (lastEvent.getActionMasked() == 10 || !wasMouseEvent) {
                        i = 3;
                    } else {
                        i = 3;
                        sendSimulatedEvent$default(this, lastEvent, 10, lastEvent.getEventTime(), false, 8, null);
                    }
                } else {
                    this.pointerInputEventProcessor.processCancel();
                    i = 3;
                }
                boolean isMouseEvent = motionEvent.getToolType(0) == i;
                if (!wasMouseEvent && isMouseEvent && action != i && action != 9 && isInBounds(motionEvent)) {
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (r8 != 0) {
                    lastEvent.recycle();
                }
                MotionEvent motionEvent2 = this.previousMotionEvent;
                if (motionEvent2 != null && motionEvent2.getAction() == 10) {
                    MotionEvent motionEvent3 = this.previousMotionEvent;
                    int previousEventDefaultPointerId = motionEvent3 != null ? motionEvent3.getPointerId(0) : -1;
                    if (motionEvent.getAction() == 9 && motionEvent.getHistorySize() == 0) {
                        if (previousEventDefaultPointerId >= 0) {
                            this.motionEventAdapter.endStream(previousEventDefaultPointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent4 = this.previousMotionEvent;
                        float previousX = motionEvent4 != null ? motionEvent4.getX() : Float.NaN;
                        MotionEvent motionEvent5 = this.previousMotionEvent;
                        float previousY = motionEvent5 != null ? motionEvent5.getY() : Float.NaN;
                        float currentX = motionEvent.getX();
                        float currentY = motionEvent.getY();
                        if (previousX == currentX) {
                            previousAndCurrentCoordinatesDoNotMatch = !((previousY > currentY ? 1 : (previousY == currentY ? 0 : -1)) == 0);
                        }
                        MotionEvent motionEvent6 = this.previousMotionEvent;
                        long previousEventTime = motionEvent6 != null ? motionEvent6.getEventTime() : -1L;
                        boolean previousAndCurrentEventTimesDoNotMatch = previousEventTime != motionEvent.getEventTime();
                        boolean previousHoverEventWasNotSyntheticallyProducedFromADownEvent = previousAndCurrentCoordinatesDoNotMatch || previousAndCurrentEventTimesDoNotMatch;
                        if (previousHoverEventWasNotSyntheticallyProducedFromADownEvent) {
                            if (previousEventDefaultPointerId >= 0) {
                                this.motionEventAdapter.endStream(previousEventDefaultPointerId);
                            }
                            this.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                        }
                    }
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int iM5963sendMotionEvent8iAsVTc = m5963sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                this.forceUseMatrixCache = false;
                return iM5963sendMotionEvent8iAsVTc;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            this.forceUseMatrixCache = false;
            throw th2;
        }
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        if (event.getButtonState() != 0) {
            return true;
        }
        switch (event.getActionMasked()) {
            case 0:
            case 2:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m5963sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        Object item$iv;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m6044setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5574constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent pointerInputEvent = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (pointerInputEvent == null) {
            this.pointerInputEventProcessor.processCancel();
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size() - 1;
        if (size < 0) {
            item$iv = null;
            break;
        }
        while (true) {
            int index$iv = size;
            size--;
            item$iv = pointers.get(index$iv);
            PointerInputEventData it = (PointerInputEventData) item$iv;
            if (it.getDown()) {
                break;
            }
            if (size < 0) {
                item$iv = null;
                break;
            }
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) item$iv;
        if (pointerInputEventData != null) {
            long it2 = pointerInputEventData.m5527getPositionF1C5BW0();
            this.lastDownPointerPosition = it2;
        }
        int result = this.pointerInputEventProcessor.m5532processBIzXfog(pointerInputEvent, this, isInBounds(motionEvent));
        int action = motionEvent.getActionMasked();
        if ((action != 0 && action != 5) || ProcessResult.m5600getDispatchedToAPointerInputModifierimpl(result)) {
            return result;
        }
        this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return result;
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, (i2 & 8) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        long downTime;
        int actionIndex = -1;
        switch (motionEvent.getActionMasked()) {
            case 1:
                switch (action) {
                    case 9:
                    case 10:
                        break;
                    default:
                        actionIndex = 0;
                        break;
                }
                break;
            case 6:
                actionIndex = motionEvent.getActionIndex();
                break;
        }
        int upIndex = actionIndex;
        int pointerCount = motionEvent.getPointerCount() - (upIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerProperties = new MotionEvent.PointerProperties[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            pointerProperties[i] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoords = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerCoords[i2] = new MotionEvent.PointerCoords();
        }
        int i3 = 0;
        while (i3 < pointerCount) {
            int sourceIndex = ((upIndex < 0 || i3 < upIndex) ? 0 : 1) + i3;
            motionEvent.getPointerProperties(sourceIndex, pointerProperties[i3]);
            MotionEvent.PointerCoords coords = pointerCoords[i3];
            motionEvent.getPointerCoords(sourceIndex, coords);
            long localPosition = OffsetKt.Offset(coords.x, coords.y);
            long screenPosition = mo5593localToScreenMKHz9U(localPosition);
            coords.x = Offset.m4049getXimpl(screenPosition);
            coords.y = Offset.m4050getYimpl(screenPosition);
            i3++;
        }
        int buttonState = forceHover ? 0 : motionEvent.getButtonState();
        if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
            downTime = eventTime;
        } else {
            downTime = motionEvent.getDownTime();
        }
        MotionEvent event = MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerProperties, pointerCoords, motionEvent.getMetaState(), buttonState, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        PointerInputEvent pointerInputEvent = this.motionEventAdapter.convertToPointerInputEvent$ui_release(event, this);
        Intrinsics.checkNotNull(pointerInputEvent);
        this.pointerInputEventProcessor.m5532processBIzXfog(pointerInputEvent, this, true);
        event.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.m5974canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.m5974canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (0.0f <= x && x <= ((float) getWidth())) {
            if (0.0f <= y && y <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.p001ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public long mo5593localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long local = Matrix.m4535mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m4049getXimpl(local) + Offset.m4049getXimpl(this.windowPosition), Offset.m4050getYimpl(local) + Offset.m4050getYimpl(this.windowPosition));
    }

    @Override // androidx.compose.p001ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: localToScreen-58bKbWc */
    public void mo5592localToScreen58bKbWc(float[] localTransform) {
        recalculateWindowPosition();
        Matrix.m4546timesAssign58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m5979preTranslatecG2Xzmc(localTransform, Offset.m4049getXimpl(this.windowPosition), Offset.m4050getYimpl(this.windowPosition), this.tmpMatrix);
    }

    @Override // androidx.compose.p001ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo5594screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        float x = Offset.m4049getXimpl(positionOnScreen) - Offset.m4049getXimpl(this.windowPosition);
        float y = Offset.m4050getYimpl(positionOnScreen) - Offset.m4050getYimpl(this.windowPosition);
        return Matrix.m4535mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(x, y));
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long animationTime = AnimationUtils.currentAnimationTimeMillis();
            if (animationTime != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = animationTime;
                recalculateWindowViewTransforms();
                ViewParent viewParent = getParent();
                AndroidComposeView view = this;
                while (viewParent instanceof ViewGroup) {
                    view = (View) viewParent;
                    viewParent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                float screenX = this.tmpPositionArray[0];
                float screenY = this.tmpPositionArray[1];
                view.getLocationInWindow(this.tmpPositionArray);
                float windowX = this.tmpPositionArray[0];
                float windowY = this.tmpPositionArray[1];
                this.windowPosition = OffsetKt.Offset(screenX - windowX, screenY - windowY);
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long positionInWindow = Matrix.m4535mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m4049getXimpl(positionInWindow), motionEvent.getRawY() - Offset.m4050getYimpl(positionInWindow));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo5980calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m6006invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession parentSession = (AndroidPlatformTextInputSession) SessionMutex.m3915getCurrentSessionimpl(this.textInputSessionMutex);
        if (parentSession == null) {
            return this.legacyTextInputServiceAndroid.getEditorHasFocus();
        }
        return parentSession.isReadyForConnection();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        AndroidPlatformTextInputSession parentSession = (AndroidPlatformTextInputSession) SessionMutex.m3915getCurrentSessionimpl(this.textInputSessionMutex);
        if (parentSession == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(outAttrs);
        }
        return parentSession.createInputConnection(outAttrs);
    }

    @Override // androidx.compose.p001ui.node.Owner
    /* JADX INFO: renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo5929calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m4535mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.p001ui.node.Owner
    /* JADX INFO: renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo5930calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m4535mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection2 = FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection);
            if (layoutDirection2 == null) {
                layoutDirection2 = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
        switch (event.getActionMasked()) {
            case 7:
                if (!isPositionChanged(event)) {
                    return false;
                }
                break;
            case 10:
                if (isInBounds(event)) {
                    if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                        return false;
                    }
                    MotionEvent motionEvent = this.previousMotionEvent;
                    if (motionEvent != null) {
                        motionEvent.recycle();
                    }
                    this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                    this.hoverExitReceived = true;
                    postDelayed(this.sendHoverExitEvent, 8L);
                    return false;
                }
                break;
        }
        int result = m5959handleMotionEvent8iAsVTc(event);
        return ProcessResult.m5600getDispatchedToAPointerInputModifierimpl(result);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    private final boolean isBadMotionEvent(MotionEvent event) {
        boolean eventInvalid;
        boolean z;
        float x = event.getX();
        if ((Float.isInfinite(x) || Float.isNaN(x)) ? false : true) {
            float y = event.getY();
            if ((Float.isInfinite(y) || Float.isNaN(y)) ? false : true) {
                float rawX = event.getRawX();
                if ((Float.isInfinite(rawX) || Float.isNaN(rawX)) ? false : true) {
                    float rawY = event.getRawY();
                    if ((Float.isInfinite(rawY) || Float.isNaN(rawY)) ? false : true) {
                        eventInvalid = false;
                    } else {
                        eventInvalid = true;
                    }
                } else {
                    eventInvalid = true;
                }
            } else {
                eventInvalid = true;
            }
        } else {
            eventInvalid = true;
        }
        if (!eventInvalid) {
            int pointerCount = event.getPointerCount();
            for (int index = 1; index < pointerCount; index++) {
                float x2 = event.getX(index);
                if ((Float.isInfinite(x2) || Float.isNaN(x2)) ? false : true) {
                    float y2 = event.getY(index);
                    if (!((Float.isInfinite(y2) || Float.isNaN(y2)) ? false : true) || (Build.VERSION.SDK_INT >= 29 && !MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(event, index))) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = true;
                }
                eventInvalid = z;
                if (eventInvalid) {
                    break;
                }
            }
        }
        return eventInvalid;
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent lastEvent;
        if (event.getPointerCount() != 1 || (lastEvent = this.previousMotionEvent) == null || lastEvent.getPointerCount() != event.getPointerCount()) {
            return true;
        }
        if (event.getRawX() == lastEvent.getRawX()) {
            return !((event.getRawY() > lastEvent.getRawY() ? 1 : (event.getRawY() == lastEvent.getRawY() ? 0 : -1)) == 0);
        }
        return true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT < 29) {
            Method getAccessibilityViewIdMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("getAccessibilityViewId", new Class[0]);
            getAccessibilityViewIdMethod.setAccessible(true);
            if (Intrinsics.areEqual(getAccessibilityViewIdMethod.invoke(currentView, new Object[0]), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                int childCount = ((ViewGroup) currentView).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View foundView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, ((ViewGroup) currentView).getChildAt(i));
                    if (foundView != null) {
                        return foundView;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // androidx.compose.p001ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) throws IllegalAccessException, InvocationTargetException {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method findViewByAccessibilityIdTraversalMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                findViewByAccessibilityIdTraversalMethod.setAccessible(true);
                Object objInvoke = findViewByAccessibilityIdTraversalMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (objInvoke instanceof View) {
                    return (View) objInvoke;
                }
                return null;
            }
            return findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    @Override // androidx.compose.p001ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycleRegistry()) == null) ? null : lifecycle.getState()) == Lifecycle.State.RESUMED;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: compiled from: AndroidComposeView.android.kt */
    @Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object objInvoke = method != null ? method.invoke(null, "debug.layout", false) : null;
                Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: AndroidComposeView.android.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m195d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }
}
