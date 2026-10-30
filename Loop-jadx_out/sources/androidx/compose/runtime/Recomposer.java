package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ½\u00012\u00020\u0001:\n½\u0001¾\u0001¿\u0001À\u0001Á\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010c\u001a\u00020dH\u0002J\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020_H\u0082@¢\u0006\u0002\u0010hJ\u0006\u0010j\u001a\u00020_J\b\u0010k\u001a\u00020_H\u0002J\u0006\u0010l\u001a\u00020_J*\u0010m\u001a\u00020_2\u0006\u0010a\u001a\u00020\u00072\u0011\u0010n\u001a\r\u0012\u0004\u0012\u00020_0o¢\u0006\u0002\bpH\u0010¢\u0006\u0004\bq\u0010rJ:\u0010s\u001a\u0002Ht\"\u0004\b\u0000\u0010t2\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010U2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Ht0oH\u0082\b¢\u0006\u0002\u0010wJ\u0015\u0010x\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\bzJ\u0010\u0010{\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0002J\b\u0010|\u001a\u00020_H\u0002J\u0015\u0010}\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\b~J\u0016\u0010\u007f\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u00020_2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0010¢\u0006\u0003\b\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ \u0010\u0086\u0001\u001a\u00020_2\u0006\u0010y\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020#H\u0010¢\u0006\u0003\b\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0003\b\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020_J\u0011\u0010\u008c\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J.\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J#\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J0\u0010\u0090\u0001\u001a\u00020_2\r\u0010\u0091\u0001\u001a\b0\u0092\u0001j\u0003`\u0093\u00012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u0017H\u0002J\u001e\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u0007H\u0002JV\u0010\u0098\u0001\u001a\u00020_2D\u0010v\u001a@\b\u0001\u0012\u0005\u0012\u00030\u009a\u0001\u0012\u0017\u0012\u00150\u009b\u0001¢\u0006\u000f\b\u009c\u0001\u0012\n\b\u009d\u0001\u0012\u0005\b\b(\u009e\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020_0\u009f\u0001\u0012\u0006\u0012\u0004\u0018\u00010'0\u0099\u0001¢\u0006\u0003\b \u0001H\u0082@¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\u0017H\u0002J \u0010¢\u0001\u001a\u00020_2\u0014\u0010£\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020_0\u0097\u0001H\u0082\bJ\u0011\u0010¤\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u001f\u0010¥\u0001\u001a\u00020_2\u000e\u0010¦\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010*H\u0010¢\u0006\u0003\b¨\u0001J\u0017\u0010©\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\bª\u0001J\u0012\u0010«\u0001\u001a\u00020_2\u0007\u0010¬\u0001\u001a\u00020QH\u0002J\u0011\u0010\u00ad\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0017\u0010®\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b¯\u0001J\u000b\u0010°\u0001\u001a\u0004\u0018\u000109H\u0002J\u0007\u0010±\u0001\u001a\u00020_J\t\u0010²\u0001\u001a\u00020_H\u0002J$\u0010³\u0001\u001a\u00020_2\b\u0010\u009e\u0001\u001a\u00030\u009b\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0082@¢\u0006\u0003\u0010¶\u0001J\u000f\u0010·\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u0018\u0010¸\u0001\u001a\u00020_2\u0006\u0010L\u001a\u00020\u0003H\u0087@¢\u0006\u0003\u0010¹\u0001J\u0017\u0010º\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b»\u0001J.\u0010¼\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010'0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\f018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0019R\u0014\u0010>\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0019R\u0014\u0010@\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0019R\u0014\u0010B\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0019R\u0011\u0010D\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u000e\u0010H\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bM\u00105R\u0012\u0010N\u001a\u00060OR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0019R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020'0UX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010V\u001a\b\u0012\u0004\u0012\u00020\f0W8FX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010]\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Â\u0001"}, m195d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingCallByInformation", "", "getCollectingCallByInformation$runtime_release", "()Z", "collectingParameterInformation", "getCollectingParameterInformation$runtime_release", "collectingSourceInformation", "getCollectingSourceInformation$runtime_release", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "getKnownCompositions", "()Ljava/util/List;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "addKnownCompositionLocked", "composition", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "clearKnownCompositionsLocked", "close", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", ExifInterface.GPS_DIRECTION_TRUE, "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordFailedCompositionLocked", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "removeKnownCompositionLocked", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Recomposer extends CompositionContext {
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private long changeCount;
    private Throwable closeCause;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private CancellableContinuation<? super Unit> workContinuation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(false);
    private final BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
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
            CancellableContinuation cancellableContinuationDeriveStateLocked;
            Object lock$iv = this.this$0.stateLock;
            Recomposer recomposer = this.this$0;
            synchronized (lock$iv) {
                cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                    throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
                }
            }
            if (cancellableContinuationDeriveStateLocked != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationDeriveStateLocked.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
            }
        }
    });
    private final Object stateLock = new Object();
    private final List<ControlledComposition> _knownCompositions = new ArrayList();
    private MutableScatterSet<Object> snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
    private final MutableVector<ControlledComposition> compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
    private final List<ControlledComposition> compositionsAwaitingApply = new ArrayList();
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert = new ArrayList();
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved = new LinkedHashMap();
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable = new LinkedHashMap();
    private final MutableStateFlow<State> _state = StateFlowKt.MutableStateFlow(State.Inactive);

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m195d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1 */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.runtime.Recomposer", m210f = "Recomposer.kt", m211i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m212l = {912, 919}, m213m = "runFrameLoop", m214n = {"this", "parentFrameClock", "frameSignal", "toRecompose", "toApply", "this", "parentFrameClock", "frameSignal", "toRecompose", "toApply"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C16661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C16661(Continuation<? super C16661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.this.runFrameLoop(null, null, this);
        }
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    public Recomposer(CoroutineContext effectCoroutineContext) {
        CompletableJob $this$effectJob_u24lambda_u241 = JobKt.Job((Job) effectCoroutineContext.get(Job.INSTANCE));
        $this$effectJob_u24lambda_u241.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable throwable) {
                CancellationException cancellation = ExceptionsKt.CancellationException("Recomposer effect job completed", throwable);
                Object continuationToResume = null;
                Object lock$iv = this.this$0.stateLock;
                final Recomposer recomposer = this.this$0;
                synchronized (lock$iv) {
                    Job runnerJob = recomposer.runnerJob;
                    if (runnerJob != null) {
                        recomposer._state.setValue(Recomposer.State.ShuttingDown);
                        if (recomposer.isClosed) {
                            if (recomposer.workContinuation != null) {
                                continuationToResume = recomposer.workContinuation;
                            }
                        } else {
                            runnerJob.cancel(cancellation);
                        }
                        recomposer.workContinuation = null;
                        runnerJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
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
                            public final void invoke2(Throwable runnerJobCause) {
                                Object lock$iv2 = recomposer.stateLock;
                                Recomposer recomposer2 = recomposer;
                                Throwable $this$invoke_u24lambda_u243_u24lambda_u242 = throwable;
                                synchronized (lock$iv2) {
                                    if ($this$invoke_u24lambda_u243_u24lambda_u242 == null) {
                                        $this$invoke_u24lambda_u243_u24lambda_u242 = null;
                                    } else if (runnerJobCause != null) {
                                        Throwable it = (runnerJobCause instanceof CancellationException) ^ true ? runnerJobCause : null;
                                        if (it != null) {
                                            kotlin.ExceptionsKt.addSuppressed($this$invoke_u24lambda_u243_u24lambda_u242, it);
                                        }
                                    }
                                    recomposer2.closeCause = $this$invoke_u24lambda_u243_u24lambda_u242;
                                    recomposer2._state.setValue(Recomposer.State.ShutDown);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        });
                    } else {
                        recomposer.closeCause = cancellation;
                        recomposer._state.setValue(Recomposer.State.ShutDown);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (continuationToResume != null) {
                    Result.Companion companion = Result.INSTANCE;
                    ((Continuation) continuationToResume).resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = $this$effectJob_u24lambda_u241;
        this.effectCoroutineContext = effectCoroutineContext.plus(this.broadcastFrameClock).plus(this.effectJob);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> getKnownCompositions() {
        List list = this._knownCompositionsCache;
        if (list == null) {
            Recomposer $this$_get_knownCompositions__u24lambda_u240 = this;
            List<ControlledComposition> list2 = $this$_get_knownCompositions__u24lambda_u240._knownCompositions;
            ArrayList arrayListEmptyList = list2.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list2);
            $this$_get_knownCompositions__u24lambda_u240._knownCompositionsCache = arrayListEmptyList;
            return arrayListEmptyList;
        }
        return list;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State newState;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            newState = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            newState = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else if (this.compositionInvalidations.isNotEmpty() || this.snapshotInvalidations.isNotEmpty() || (!this.compositionsAwaitingApply.isEmpty()) || (!this.compositionValuesAwaitingInsert.isEmpty()) || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            newState = State.PendingWork;
        } else {
            newState = State.Idle;
        }
        this._state.setValue(newState);
        if (newState != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0032 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        boolean z2;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            z = !this.isClosed;
        }
        if (z) {
            return true;
        }
        for (Object element$iv : this.effectJob.getChildren()) {
            Job it = (Job) element$iv;
            if (it.isActive()) {
                z2 = true;
                if (z2) {
                    return true;
                }
                return false;
            }
        }
        z2 = false;
        if (z2) {
            return true;
        }
        return false;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, m195d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        public final void invalidateGroupsWithKey(int key) {
            List $this$fastMapNotNull$iv;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                $this$fastMapNotNull$iv = recomposer.getKnownCompositions();
            }
            List target$iv = new ArrayList($this$fastMapNotNull$iv.size());
            int size = $this$fastMapNotNull$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = $this$fastMapNotNull$iv.get(index$iv$iv);
                ControlledComposition it = (ControlledComposition) item$iv$iv;
                CompositionImpl compositionImpl = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (compositionImpl != null) {
                    target$iv.add(compositionImpl);
                }
            }
            List $this$fastForEach$iv = target$iv;
            int size2 = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                ((CompositionImpl) item$iv).invalidateGroupsWithKey(key);
            }
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List compositions;
            Object lock$iv = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (lock$iv) {
                compositions = recomposer.getKnownCompositions();
            }
            List target$iv = new ArrayList(compositions.size());
            int size = compositions.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = compositions.get(index$iv$iv);
                ControlledComposition it = (ControlledComposition) item$iv$iv;
                CompositionImpl compositionImpl = it instanceof CompositionImpl ? (CompositionImpl) it : null;
                if (compositionImpl != null) {
                    target$iv.add(compositionImpl);
                }
            }
            List $this$fastMap$iv = target$iv;
            List target$iv2 = new ArrayList($this$fastMap$iv.size());
            int size2 = $this$fastMap$iv.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                Object item$iv$iv2 = $this$fastMap$iv.get(index$iv$iv2);
                HotReloadable $this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246 = new HotReloadable((CompositionImpl) item$iv$iv2);
                $this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246.clearContent();
                target$iv2.add($this$saveStateAndDisposeForHotReload_u24lambda_u247_u24lambda_u246);
            }
            return target$iv2;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m195d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl composition) {
            this.composition = composition;
            this.composable = this.composition.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m3753getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m195d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean recoverable, Exception cause) {
            this.recoverable = recoverable;
            this.cause = cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Exception getCause() {
            return this.cause;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List<ControlledComposition> knownCompositions;
        boolean hasFrameWorkLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            int i = 1;
            this.snapshotInvalidations = new MutableScatterSet<>(0, i, null);
            Object lock$iv2 = this.stateLock;
            synchronized (lock$iv2) {
                knownCompositions = getKnownCompositions();
            }
            try {
                Recomposer $this$recordComposerModifications_u24lambda_u2410 = this;
                int size = knownCompositions.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = knownCompositions.get(index$iv);
                    ControlledComposition composition = (ControlledComposition) item$iv;
                    composition.recordModificationsOf(setWrapIntoSet);
                    if ($this$recordComposerModifications_u24lambda_u2410._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                this.snapshotInvalidations = new MutableScatterSet<>(0, i, null);
                Object lock$iv3 = this.stateLock;
                synchronized (lock$iv3) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(setWrapIntoSet);
                    throw th;
                }
            }
        }
    }

    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
        int i = 1;
        if (!setWrapIntoSet.isEmpty()) {
            List $this$fastForEach$iv = getKnownCompositions();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                ControlledComposition composition = (ControlledComposition) item$iv;
                composition.recordModificationsOf(setWrapIntoSet);
            }
            this.snapshotInvalidations = new MutableScatterSet(0, i, null);
        }
        MutableVector this_$iv = this.compositionInvalidations;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                onEachInvalidComposition.invoke(content$iv[i$iv]);
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            Throwable it = this.closeCause;
            if (it != null) {
                throw it;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2 */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", m210f = "Recomposer.kt", m211i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m212l = {565, 576}, m213m = "invokeSuspend", m214n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, m215s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    static final class C16682 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        C16682(Continuation<? super C16682> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
            C16682 c16682 = Recomposer.this.new C16682(continuation);
            c16682.L$0 = monotonicFrameClock;
            return c16682.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:13:0x00ec A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:17:0x0103  */
        /* JADX WARN: Code duplicated, block: B:19:0x0154 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x0155  */
        /* JADX WARN: Code duplicated, block: B:22:0x0166  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0155 -> B:21:0x015c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0166 -> B:9:0x00c5). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instruction units count: 394
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C16682.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:28:0x00a8 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:29:0x00aa A[Catch: all -> 0x01ae, LOOP:1: B:14:0x0056->B:29:0x00aa, LOOP_END, TryCatch #2 {all -> 0x01ae, blocks: (B:25:0x008b, B:26:0x009f, B:32:0x00b8, B:34:0x00cf, B:36:0x00e0, B:38:0x00ee, B:43:0x00fe, B:44:0x0111, B:48:0x011d, B:50:0x0123, B:52:0x013d, B:54:0x014f, B:56:0x015b, B:61:0x016b, B:62:0x0186, B:68:0x0199, B:71:0x01a5, B:29:0x00aa), top: B:84:0x008b }] */
        /* JADX WARN: Code duplicated, block: B:47:0x011b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:48:0x011d A[Catch: all -> 0x01ae, LOOP:3: B:34:0x00cf->B:48:0x011d, LOOP_END, TryCatch #2 {all -> 0x01ae, blocks: (B:25:0x008b, B:26:0x009f, B:32:0x00b8, B:34:0x00cf, B:36:0x00e0, B:38:0x00ee, B:43:0x00fe, B:44:0x0111, B:48:0x011d, B:50:0x0123, B:52:0x013d, B:54:0x014f, B:56:0x015b, B:61:0x016b, B:62:0x0186, B:68:0x0199, B:71:0x01a5, B:29:0x00aa), top: B:84:0x008b }] */
        /* JADX WARN: Code duplicated, block: B:88:0x00b8 A[EDGE_INSN: B:88:0x00b8->B:32:0x00b8 BREAK  A[LOOP:1: B:14:0x0056->B:29:0x00aa], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:93:0x0123 A[EDGE_INSN: B:93:0x0123->B:50:0x0123 BREAK  A[LOOP:3: B:34:0x00cf->B:48:0x011d], SYNTHETIC] */
        public static final void invokeSuspend$clearRecompositionState(Recomposer this$0, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) throws Throwable {
            long slot$iv$iv;
            Object lock$iv = this$0.stateLock;
            int $i$f$synchronized = 0;
            synchronized (lock$iv) {
                try {
                    list.clear();
                    list2.clear();
                    int size = list3.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        try {
                            Object item$iv = list3.get(index$iv);
                            ControlledComposition it = (ControlledComposition) item$iv;
                            it.abandonChanges();
                            this$0.recordFailedCompositionLocked(it);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    list3.clear();
                    MutableScatterSet<ControlledComposition> this_$iv = mutableScatterSet;
                    Object[] k$iv = this_$iv.elements;
                    long[] m$iv$iv = this_$iv.metadata;
                    int lastIndex$iv$iv = m$iv$iv.length - 2;
                    int i$iv$iv = 0;
                    long j = 255;
                    if (0 <= lastIndex$iv$iv) {
                        while (true) {
                            long slot$iv$iv2 = m$iv$iv[i$iv$iv];
                            int $i$f$synchronized2 = $i$f$synchronized;
                            ScatterSet this_$iv2 = this_$iv;
                            if ((((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i$iv$iv != lastIndex$iv$iv) {
                                    break;
                                    break;
                                }
                                i$iv$iv++;
                                $i$f$synchronized = $i$f$synchronized2;
                                this_$iv = this_$iv2;
                                j = 255;
                            } else {
                                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                                int j$iv$iv = 0;
                                while (j$iv$iv < bitCount$iv$iv) {
                                    long value$iv$iv$iv = slot$iv$iv2 & j;
                                    if (value$iv$iv$iv < 128) {
                                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                        try {
                                            ControlledComposition it2 = (ControlledComposition) k$iv[index$iv$iv];
                                            it2.abandonChanges();
                                            this$0.recordFailedCompositionLocked(it2);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    }
                                    slot$iv$iv2 >>= 8;
                                    j$iv$iv++;
                                    j = 255;
                                }
                                if (bitCount$iv$iv != 8) {
                                    break;
                                }
                                if (i$iv$iv != lastIndex$iv$iv) {
                                    break;
                                }
                                i$iv$iv++;
                                $i$f$synchronized = $i$f$synchronized2;
                                this_$iv = this_$iv2;
                                j = 255;
                            }
                        }
                    }
                    mutableScatterSet.clear();
                    MutableScatterSet<ControlledComposition> this_$iv3 = mutableScatterSet2;
                    Object[] k$iv2 = this_$iv3.elements;
                    long[] m$iv$iv2 = this_$iv3.metadata;
                    int lastIndex$iv$iv2 = m$iv$iv2.length - 2;
                    int i$iv$iv2 = 0;
                    if (0 <= lastIndex$iv$iv2) {
                        while (true) {
                            long slot$iv$iv3 = m$iv$iv2[i$iv$iv2];
                            if ((((~slot$iv$iv3) << 7) & slot$iv$iv3 & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i$iv$iv2 != lastIndex$iv$iv2) {
                                    break;
                                    break;
                                }
                                i$iv$iv2++;
                            } else {
                                int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                                for (int j$iv$iv2 = 0; j$iv$iv2 < bitCount$iv$iv2; j$iv$iv2++) {
                                    long value$iv$iv$iv2 = slot$iv$iv & 255;
                                    int $i$f$isFull = value$iv$iv$iv2 < 128 ? 1 : 0;
                                    if ($i$f$isFull != 0) {
                                        slot$iv$iv = slot$iv$iv3;
                                        slot$iv$iv = slot$iv$iv3;
                                        int index$iv$iv2 = (i$iv$iv2 << 3) + j$iv$iv2;
                                        ((ControlledComposition) k$iv2[index$iv$iv2]).changesApplied();
                                    } else {
                                        slot$iv$iv = slot$iv$iv3;
                                        slot$iv$iv = slot$iv$iv3;
                                    }
                                    slot$iv$iv >>= 8;
                                }
                                slot$iv$iv = slot$iv$iv3;
                                if (bitCount$iv$iv2 != 8) {
                                    break;
                                } else if (i$iv$iv2 != lastIndex$iv$iv2) {
                                    break;
                                } else {
                                    i$iv$iv2++;
                                }
                            }
                        }
                    }
                    mutableScatterSet2.clear();
                    mutableScatterSet3.clear();
                    MutableScatterSet<ControlledComposition> this_$iv4 = mutableScatterSet4;
                    int $i$f$forEach = 0;
                    Object[] k$iv3 = this_$iv4.elements;
                    long[] m$iv$iv3 = this_$iv4.metadata;
                    int lastIndex$iv$iv3 = m$iv$iv3.length - 2;
                    int i$iv$iv3 = 0;
                    if (0 <= lastIndex$iv$iv3) {
                        while (true) {
                            long slot$iv$iv4 = m$iv$iv3[i$iv$iv3];
                            ScatterSet this_$iv5 = this_$iv4;
                            int $i$f$forEach2 = $i$f$forEach;
                            if ((((~slot$iv$iv4) << 7) & slot$iv$iv4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int bitCount$iv$iv3 = 8 - ((~(i$iv$iv3 - lastIndex$iv$iv3)) >>> 31);
                                for (int j$iv$iv3 = 0; j$iv$iv3 < bitCount$iv$iv3; j$iv$iv3++) {
                                    long value$iv$iv$iv3 = slot$iv$iv4 & 255;
                                    int $i$f$isFull2 = value$iv$iv$iv3 < 128 ? 1 : 0;
                                    if ($i$f$isFull2 != 0) {
                                        int index$iv$iv3 = (i$iv$iv3 << 3) + j$iv$iv3;
                                        ControlledComposition it3 = (ControlledComposition) k$iv3[index$iv$iv3];
                                        it3.abandonChanges();
                                        this$0.recordFailedCompositionLocked(it3);
                                    }
                                    slot$iv$iv4 >>= 8;
                                }
                                if (bitCount$iv$iv3 != 8) {
                                    break;
                                }
                            }
                            if (i$iv$iv3 == lastIndex$iv$iv3) {
                                break;
                            }
                            i$iv$iv3++;
                            this_$iv4 = this_$iv5;
                            $i$f$forEach = $i$f$forEach2;
                        }
                    }
                    mutableScatterSet4.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer this$0) {
            list.clear();
            Object lock$iv = this$0.stateLock;
            synchronized (lock$iv) {
                List $this$fastForEach$iv = this$0.compositionValuesAwaitingInsert;
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    MovableContentStateReference it = (MovableContentStateReference) item$iv;
                    list.add(it);
                }
                this$0.compositionValuesAwaitingInsert.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) throws Throwable {
        Object objRecompositionRunner = recompositionRunner(new C16682(null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception e, ControlledComposition failedInitialComposition, boolean recoverable) throws Exception {
        int i = 0;
        if (_hotReloadEnabled.get().booleanValue() && !(e instanceof ComposeRuntimeError)) {
            Object lock$iv = this.stateLock;
            synchronized (lock$iv) {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    recordFailedCompositionLocked(failedInitialComposition);
                }
                deriveStateLocked();
            }
            return;
        }
        Object lock$iv2 = this.stateLock;
        synchronized (lock$iv2) {
            RecomposerErrorState errorState = this.errorState;
            if (errorState == null) {
                this.errorState = new RecomposerErrorState(false, e);
                Unit unit = Unit.INSTANCE;
            } else {
                throw errorState.getCause();
            }
        }
        throw e;
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.remove(composition);
        this._knownCompositionsCache = null;
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState error;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            error = this.errorState;
            if (error != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (!list.isEmpty()) {
            try {
                ControlledComposition composition = (ControlledComposition) CollectionsKt.removeLast(list);
                if (composition instanceof CompositionImpl) {
                    composition.invalidateAll();
                    composition.setContent(((CompositionImpl) composition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        int size = list.size();
                        for (int index$iv = 0; index$iv < size; index$iv++) {
                            Object item$iv = list.get(index$iv);
                            ControlledComposition it = (ControlledComposition) item$iv;
                            recordFailedCompositionLocked(it);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                throw th;
            }
        }
        if (!list.isEmpty()) {
            Object lock$iv2 = this.stateLock;
            synchronized (lock$iv2) {
                int size2 = list.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Object item$iv2 = list.get(index$iv2);
                    ControlledComposition it2 = (ControlledComposition) item$iv2;
                    recordFailedCompositionLocked(it2);
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        ArrayList arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(composition)) {
            arrayList.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", m210f = "Recomposer.kt", m211i = {0, 0, 0, 1}, m212l = {881, 901, 902}, m213m = "invokeSuspend", m214n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, m215s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C16692 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16692(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super C16692> continuation) {
            super(3, continuation);
            this.$recomposeCoroutineContext = coroutineContext;
            this.this$0 = recomposer;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
            C16692 c16692 = new C16692(this.$recomposeCoroutineContext, this.this$0, continuation);
            c16692.L$0 = coroutineScope;
            c16692.L$1 = monotonicFrameClock;
            return c16692.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0158  */
        /* JADX WARN: Code duplicated, block: B:41:0x018e A[LOOP:1: B:33:0x014b->B:41:0x018e, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:80:0x019b A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00f0 -> B:23:0x00f1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 552
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C16692.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext recomposeCoroutineContext, Continuation<? super Unit> continuation) throws Throwable {
        Object objRecompositionRunner = recompositionRunner(new C16692(recomposeCoroutineContext, this, null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x008c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x008d  */
    /* JADX WARN: Code duplicated, block: B:21:0x00ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00ae -> B:15:0x0076). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r9, androidx.compose.runtime.ProduceFrameSignal r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.runtime.Recomposer.C16661
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer.C16661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r11)
        L19:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            switch(r2) {
                case 0: goto L64;
                case 1: goto L4c;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2d:
            java.lang.Object r9 = r11.L$4
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r11.L$3
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r11.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r3 = r11.L$1
            androidx.compose.runtime.MonotonicFrameClock r3 = (androidx.compose.runtime.MonotonicFrameClock) r3
            java.lang.Object r4 = r11.L$0
            androidx.compose.runtime.Recomposer r4 = (androidx.compose.runtime.Recomposer) r4
            kotlin.ResultKt.throwOnFailure(r0)
            r7 = r4
            r4 = r9
            r9 = r3
            r3 = r10
            r10 = r2
            r2 = r7
            goto Lb4
        L4c:
            java.lang.Object r9 = r11.L$4
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r11.L$3
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r11.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r3 = r11.L$1
            androidx.compose.runtime.MonotonicFrameClock r3 = (androidx.compose.runtime.MonotonicFrameClock) r3
            java.lang.Object r4 = r11.L$0
            androidx.compose.runtime.Recomposer r4 = (androidx.compose.runtime.Recomposer) r4
            kotlin.ResultKt.throwOnFailure(r0)
            goto L93
        L64:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L76:
            java.lang.Object r5 = r2.stateLock
            r11.L$0 = r2
            r11.L$1 = r9
            r11.L$2 = r10
            r11.L$3 = r3
            r11.L$4 = r4
            r6 = 1
            r11.label = r6
            java.lang.Object r5 = r10.awaitFrameRequest(r5, r11)
            if (r5 != r1) goto L8d
            return r1
        L8d:
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r2
            r2 = r10
            r10 = r7
        L93:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r5 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r5.<init>()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r11.L$0 = r4
            r11.L$1 = r3
            r11.L$2 = r2
            r11.L$3 = r10
            r11.L$4 = r9
            r6 = 2
            r11.label = r6
            java.lang.Object r5 = r3.withFrameNanos(r5, r11)
            if (r5 != r1) goto Lae
            return r1
        Lae:
            r7 = r4
            r4 = r9
            r9 = r3
            r3 = r10
            r10 = r2
            r2 = r7
        Lb4:
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            z = this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuation;
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl co = cancellable$iv;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (!getHasSchedulingWork()) {
                this.workContinuation = co;
                cancellableContinuation = null;
            } else {
                cancellableContinuation = co;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2 */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", m210f = "Recomposer.kt", m211i = {0, 0}, m212l = {1044}, m213m = "invokeSuspend", m214n = {"callingJob", "unregisterApplyObserver"}, m215s = {"L$0", "L$1"})
    static final class C16652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C16652(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super C16652> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16652 c16652 = Recomposer.this.new C16652(this.$block, this.$parentFrameClock, continuation);
            c16652.L$0 = obj;
            return c16652;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16652) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:29:0x00af A[Catch: all -> 0x00c5, TryCatch #1 {, blocks: (B:27:0x00a9, B:29:0x00af, B:30:0x00b2), top: B:57:0x00a9 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:47:0x00e4 A[Catch: all -> 0x00f7, TryCatch #2 {, blocks: (B:45:0x00de, B:47:0x00e4, B:48:0x00e7), top: B:59:0x00de }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Job callingJob;
            Throwable th;
            C16652 c16652;
            ObserverHandle unregisterApplyObserver;
            List $this$fastForEach$iv;
            Object lock$iv;
            Recomposer recomposer;
            Object lock$iv2;
            Recomposer recomposer2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
                    callingJob = JobKt.getJob($this$withContext.getCoroutineContext());
                    Recomposer.this.registerRunnerJob(callingJob);
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    final Recomposer recomposer3 = Recomposer.this;
                    ObserverHandle unregisterApplyObserver2 = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) throws Throwable {
                            invoke2(set, snapshot);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Set<? extends Object> set, Snapshot snapshot) throws Throwable {
                            CancellableContinuation cancellableContinuationDeriveStateLocked;
                            int $i$f$fastForEach;
                            int $i$f$fastForEach2;
                            Object lock$iv3 = recomposer3.stateLock;
                            Recomposer recomposer4 = recomposer3;
                            int $i$f$synchronized = 0;
                            synchronized (lock$iv3) {
                                int i = 0;
                                try {
                                    if (((Recomposer.State) recomposer4._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                                        int $i$f$fastForEach3 = 0;
                                        try {
                                            if (set instanceof ScatterSetWrapper) {
                                                ScatterSet this_$iv$iv = ((ScatterSetWrapper) set).getSet$runtime_release();
                                                int $i$f$forEach = 0;
                                                Object[] k$iv$iv = this_$iv$iv.elements;
                                                long[] m$iv$iv$iv = this_$iv$iv.metadata;
                                                int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
                                                int i$iv$iv$iv = 0;
                                                if (0 <= lastIndex$iv$iv$iv) {
                                                    while (true) {
                                                        long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                                                        int $i$f$forEach2 = $i$f$forEach;
                                                        int $i$f$synchronized2 = $i$f$synchronized;
                                                        int i2 = i;
                                                        if ((((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                                                            int j$iv$iv$iv = 0;
                                                            while (j$iv$iv$iv < bitCount$iv$iv$iv) {
                                                                long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                                                                if (value$iv$iv$iv$iv < 128) {
                                                                    int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                                                                    Object it = k$iv$iv[index$iv$iv$iv];
                                                                    if (it instanceof StateObjectImpl) {
                                                                        ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                                                        $i$f$fastForEach2 = $i$f$fastForEach3;
                                                                        int $i$f$fastForEach4 = ReaderKind.m3894constructorimpl(1);
                                                                        if (!((StateObjectImpl) it).m3906isReadInh_f27i8$runtime_release($i$f$fastForEach4)) {
                                                                        }
                                                                    } else {
                                                                        $i$f$fastForEach2 = $i$f$fastForEach3;
                                                                    }
                                                                    recomposer4.snapshotInvalidations.add(it);
                                                                } else {
                                                                    $i$f$fastForEach2 = $i$f$fastForEach3;
                                                                }
                                                                slot$iv$iv$iv >>= 8;
                                                                j$iv$iv$iv++;
                                                                $i$f$fastForEach3 = $i$f$fastForEach2;
                                                            }
                                                            $i$f$fastForEach = $i$f$fastForEach3;
                                                            if (bitCount$iv$iv$iv != 8) {
                                                                break;
                                                            }
                                                        } else {
                                                            $i$f$fastForEach = $i$f$fastForEach3;
                                                        }
                                                        if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                                                            break;
                                                        }
                                                        i$iv$iv$iv++;
                                                        $i$f$synchronized = $i$f$synchronized2;
                                                        i = i2;
                                                        $i$f$forEach = $i$f$forEach2;
                                                        $i$f$fastForEach3 = $i$f$fastForEach;
                                                    }
                                                }
                                            } else {
                                                Set<? extends Object> $this$forEach$iv$iv = set;
                                                for (Object element$iv$iv : $this$forEach$iv$iv) {
                                                    if (element$iv$iv instanceof StateObjectImpl) {
                                                        ReaderKind.Companion companion3 = ReaderKind.INSTANCE;
                                                        if (!((StateObjectImpl) element$iv$iv).m3906isReadInh_f27i8$runtime_release(ReaderKind.m3894constructorimpl(1))) {
                                                        }
                                                    }
                                                    recomposer4.snapshotInvalidations.add(element$iv$iv);
                                                }
                                            }
                                            cancellableContinuationDeriveStateLocked = recomposer4.deriveStateLocked();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    } else {
                                        cancellableContinuationDeriveStateLocked = null;
                                    }
                                    if (cancellableContinuationDeriveStateLocked != null) {
                                        Result.Companion companion4 = Result.INSTANCE;
                                        cancellableContinuationDeriveStateLocked.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                    });
                    Recomposer.INSTANCE.addRunning(Recomposer.this.recomposerInfo);
                    try {
                        Object lock$iv3 = Recomposer.this.stateLock;
                        Recomposer recomposer4 = Recomposer.this;
                        synchronized (lock$iv3) {
                            $this$fastForEach$iv = recomposer4.getKnownCompositions();
                        }
                        int size = $this$fastForEach$iv.size();
                        for (int index$iv = 0; index$iv < size; index$iv++) {
                            Object item$iv = $this$fastForEach$iv.get(index$iv);
                            ControlledComposition it = (ControlledComposition) item$iv;
                            it.invalidateAll();
                        }
                        this.L$0 = callingJob;
                        this.L$1 = unregisterApplyObserver2;
                        this.label = 1;
                        if (CoroutineScopeKt.coroutineScope(new AnonymousClass3(this.$block, this.$parentFrameClock, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c16652 = this;
                        unregisterApplyObserver = unregisterApplyObserver2;
                        unregisterApplyObserver.dispose();
                        lock$iv2 = Recomposer.this.stateLock;
                        recomposer2 = Recomposer.this;
                        synchronized (lock$iv2) {
                            if (recomposer2.runnerJob == callingJob) {
                                recomposer2.runnerJob = null;
                            }
                            recomposer2.deriveStateLocked();
                        }
                        Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        c16652 = this;
                        unregisterApplyObserver = unregisterApplyObserver2;
                        unregisterApplyObserver.dispose();
                        lock$iv = Recomposer.this.stateLock;
                        recomposer = Recomposer.this;
                        synchronized (lock$iv) {
                            if (recomposer.runnerJob == callingJob) {
                                recomposer.runnerJob = null;
                            }
                            recomposer.deriveStateLocked();
                            Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                            throw th;
                        }
                    }
                case 1:
                    c16652 = this;
                    unregisterApplyObserver = (ObserverHandle) c16652.L$1;
                    callingJob = (Job) c16652.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        unregisterApplyObserver.dispose();
                        lock$iv2 = Recomposer.this.stateLock;
                        recomposer2 = Recomposer.this;
                        synchronized (lock$iv2) {
                            if (recomposer2.runnerJob == callingJob) {
                                recomposer2.runnerJob = null;
                            }
                            recomposer2.deriveStateLocked();
                            Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                            return Unit.INSTANCE;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        unregisterApplyObserver.dispose();
                        lock$iv = Recomposer.this.stateLock;
                        recomposer = Recomposer.this;
                        synchronized (lock$iv) {
                            if (recomposer.runnerJob == callingJob) {
                                recomposer.runnerJob = null;
                            }
                            recomposer.deriveStateLocked();
                        }
                        Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Recomposer.kt */
        @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", m210f = "Recomposer.kt", m211i = {}, m212l = {1045}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$block = function3;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                        Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                        MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                        this.label = 1;
                        if (function3.invoke($this$coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) throws Throwable {
        MonotonicFrameClock parentFrameClock = MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext());
        Object objWithContext = BuildersKt.withContext(this.broadcastFrameClock, new C16652(function3, parentFrameClock, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void cancel() {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            Object lock$iv = this.stateLock;
            synchronized (lock$iv) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$join$2 */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.runtime.Recomposer$join$2", m210f = "Recomposer.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C16632 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C16632(Continuation<? super C16632> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16632 c16632 = new C16632(continuation);
            c16632.L$0 = obj;
            return c16632;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Boolean> continuation) {
            return ((C16632) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    State it = (State) this.L$0;
                    return Boxing.boxBoolean(it == State.ShutDown);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object objFirst = FlowKt.first(getCurrentState(), new C16632(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) throws Exception {
        boolean composerWasComposing = composition.isComposing();
        try {
            MutableSnapshot snapshot$iv = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                MutableSnapshot this_$iv$iv = snapshot$iv;
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    applyAndCheck(snapshot$iv);
                    if (!composerWasComposing) {
                        Snapshot.INSTANCE.notifyObjectsInitialized();
                    }
                    Object lock$iv = this.stateLock;
                    synchronized (lock$iv) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !getKnownCompositions().contains(composition)) {
                            addKnownCompositionLocked(composition);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (!composerWasComposing) {
                                Snapshot.INSTANCE.notifyObjectsInitialized();
                            }
                        } catch (Exception e) {
                            processCompositionError$default(this, e, null, false, 6, null);
                        }
                    } catch (Exception e2) {
                        processCompositionError(e2, composition, true);
                    }
                } catch (Throwable th) {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            } catch (Throwable th2) {
                applyAndCheck(snapshot$iv);
                throw th2;
            }
        } catch (Exception e3) {
            processCompositionError(e3, composition, true);
        }
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) throws Throwable {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int index$iv$iv = 0;
            int size = list.size();
            while (true) {
                if (index$iv$iv < size) {
                    Object item$iv$iv = list.get(index$iv$iv);
                    MovableContentStateReference it = (MovableContentStateReference) item$iv$iv;
                    if (Intrinsics.areEqual(it.getComposition(), composition)) {
                        z = true;
                        break;
                    }
                    index$iv$iv++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                Unit unit = Unit.INSTANCE;
                List toInsert = new ArrayList();
                performInitialMovableContentInserts$fillToInsert(toInsert, this, composition);
                while (!toInsert.isEmpty()) {
                    performInsertValues(toInsert, null);
                    performInitialMovableContentInserts$fillToInsert(toInsert, this, composition);
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer this$0, ControlledComposition $composition) {
        list.clear();
        Object lock$iv = this$0.stateLock;
        synchronized (lock$iv) {
            Iterator<MovableContentStateReference> it = this$0.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference value = it.next();
                if (Intrinsics.areEqual(value.getComposition(), $composition)) {
                    list.add(value);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        if (!composition.isComposing() && !composition.getDisposed()) {
            Set<ControlledComposition> set = this.compositionsRemoved;
            boolean z = true;
            if (!(set != null && set.contains(composition))) {
                MutableSnapshot snapshot$iv = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
                try {
                    MutableSnapshot this_$iv$iv = snapshot$iv;
                    Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                    if (modifiedValues == null) {
                        z = false;
                    } else {
                        try {
                            if (!modifiedValues.isNotEmpty()) {
                                z = false;
                            }
                        } catch (Throwable th) {
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            throw th;
                        }
                    }
                    if (z) {
                        composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
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
                                ScatterSet this_$iv = modifiedValues;
                                ControlledComposition controlledComposition = composition;
                                Object[] k$iv = this_$iv.elements;
                                long[] m$iv$iv = this_$iv.metadata;
                                int lastIndex$iv$iv = m$iv$iv.length - 2;
                                int i$iv$iv = 0;
                                if (0 > lastIndex$iv$iv) {
                                    return;
                                }
                                while (true) {
                                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                                    ScatterSet this_$iv2 = this_$iv;
                                    if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i = 8;
                                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                                        for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                                            long value$iv$iv$iv = 255 & slot$iv$iv;
                                            if (value$iv$iv$iv < 128) {
                                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                                Object it = k$iv[index$iv$iv];
                                                controlledComposition.recordWriteOf(it);
                                            }
                                            i = 8;
                                            slot$iv$iv >>= 8;
                                        }
                                        if (bitCount$iv$iv != i) {
                                            return;
                                        }
                                    }
                                    if (i$iv$iv == lastIndex$iv$iv) {
                                        return;
                                    }
                                    i$iv$iv++;
                                    this_$iv = this_$iv2;
                                }
                            }
                        });
                    }
                    boolean zRecompose = composition.recompose();
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    applyAndCheck(snapshot$iv);
                    if (zRecompose) {
                        return composition;
                    }
                    return null;
                } catch (Throwable th2) {
                    applyAndCheck(snapshot$iv);
                    throw th2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00fe, code lost:
    
        r4.insertMovableContent(r1);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0106, code lost:
    
        r8.restoreCurrent(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x010a, code lost:
    
        applyAndCheck(r7);
        r0 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0132, code lost:
    
        applyAndCheck(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0135, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<androidx.compose.runtime.ControlledComposition> performInsertValues(java.util.List<androidx.compose.runtime.MovableContentStateReference> r30, androidx.collection.MutableScatterSet<java.lang.Object> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInsertValues(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() throws Throwable {
        ArrayList unusedValues;
        Object lock$iv = this.stateLock;
        int $i$f$synchronized = 0;
        synchronized (lock$iv) {
            int i = 0;
            try {
                try {
                    if (!this.compositionValuesRemoved.isEmpty()) {
                        List references = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                        this.compositionValuesRemoved.clear();
                        ArrayList target$iv = new ArrayList(references.size());
                        int index$iv$iv = 0;
                        int size = references.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = references.get(index$iv$iv);
                            MovableContentStateReference it = (MovableContentStateReference) item$iv$iv;
                            int i2 = i;
                            int $i$f$synchronized2 = $i$f$synchronized;
                            target$iv.add(TuplesKt.m202to(it, this.compositionValueStatesAvailable.get(it)));
                            index$iv$iv++;
                            i = i2;
                            $i$f$synchronized = $i$f$synchronized2;
                        }
                        unusedValues = target$iv;
                        this.compositionValueStatesAvailable.clear();
                    } else {
                        unusedValues = CollectionsKt.emptyList();
                    }
                    List $this$fastForEach$iv = unusedValues;
                    int size2 = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size2; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Pair pair = (Pair) item$iv;
                        MovableContentStateReference reference = (MovableContentStateReference) pair.component1();
                        MovableContentState state = (MovableContentState) pair.component2();
                        if (state != null) {
                            reference.getComposition().disposeUnusedMovableContent(state);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.readObserverOf.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object value) {
                composition.recordReadOf(value);
            }
        };
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.writeObserverOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object value) {
                composition.recordWriteOf(value);
                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                if (mutableScatterSet != null) {
                    mutableScatterSet.add(value);
                }
            }
        };
    }

    private final <T> T composing(ControlledComposition composition, MutableScatterSet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot snapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            MutableSnapshot this_$iv = snapshot;
            Snapshot previous$iv = this_$iv.makeCurrent();
            try {
                T tInvoke = block.invoke();
                InlineMarker.finallyStart(1);
                this_$iv.restoreCurrent(previous$iv);
                InlineMarker.finallyEnd(1);
                InlineMarker.finallyStart(1);
                applyAndCheck(snapshot);
                return tInvoke;
            } finally {
                InlineMarker.finallyStart(1);
                this_$iv.restoreCurrent(previous$iv);
                InlineMarker.finallyEnd(1);
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            applyAndCheck(snapshot);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            SnapshotApplyResult applyResult = snapshot.apply();
            if (applyResult instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
            snapshot.dispose();
        } catch (Throwable th) {
            snapshot.dispose();
            throw th;
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            z = true;
            if (!this.snapshotInvalidations.isNotEmpty() && !this.compositionInvalidations.isNotEmpty() && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty()) && !getHasBroadcastFrameClockAwaitersLocked()) {
                z = false;
            }
        }
        return z;
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2 */
    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/Recomposer$State;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.runtime.Recomposer$awaitIdle$2", m210f = "Recomposer.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C16622 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C16622(Continuation<? super C16622> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16622 c16622 = new C16622(continuation);
            c16622.L$0 = obj;
            return c16622;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation<? super Boolean> continuation) {
            return ((C16622) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    State it = (State) this.L$0;
                    return Boxing.boxBoolean(it.compareTo(State.Idle) > 0);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new C16622(null)), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final void pauseCompositionFrameClock() {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingSourceInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition composition) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.snapshotInvalidations.add(scope);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.compositionValuesAwaitingInsert.add(reference);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference reference) {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data) {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            LinkedHashSet linkedHashSet = this.compositionsRemoved;
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                this.compositionsRemoved = linkedHashSet;
            }
            linkedHashSet.add(composition);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState movableContentStateRemove;
        Object lock$iv = this.stateLock;
        synchronized (lock$iv) {
            movableContentStateRemove = this.compositionValueStatesAvailable.remove(reference);
        }
        return movableContentStateRemove;
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    @Metadata(m194d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, m195d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", DownloadUtil.CookieScheme.VALUE, "setHotReloadEnabled$runtime_release", "runtime_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet persistentSetAdd;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = old.add(info);
                if (old == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(old, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet old;
            PersistentSet persistentSetRemove;
            do {
                old = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = old.remove(info);
                if (old == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(old, persistentSetRemove));
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$flatMap$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv;
                Iterable list$iv$iv = it.saveStateAndDisposeForHotReload();
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List) destination$iv$iv;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object token) {
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$forEach$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv : $this$forEach$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv;
                it.resetErrorState();
            }
            Intrinsics.checkNotNull(token, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List holders = (List) token;
            int size = holders.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = holders.get(index$iv);
                HotReloadable it2 = (HotReloadable) item$iv;
                it2.resetContent();
            }
            int size2 = holders.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = holders.get(index$iv2);
                HotReloadable it3 = (HotReloadable) item$iv2;
                it3.recompose();
            }
            Iterable $this$forEach$iv2 = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv2 : $this$forEach$iv2) {
                RecomposerInfoImpl it4 = (RecomposerInfoImpl) element$iv2;
                it4.retryFailedCompositions();
            }
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer._hotReloadEnabled.set(true);
            Iterable $this$forEach$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            for (Object element$iv : $this$forEach$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv;
                RecomposerErrorInfo currentError = it.getCurrentError();
                boolean z = false;
                if (currentError != null && !currentError.getRecoverable()) {
                    z = true;
                }
                if (!z) {
                    it.resetErrorState();
                    it.invalidateGroupsWithKey(key);
                    it.retryFailedCompositions();
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable $this$mapNotNull$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv$iv;
                RecomposerErrorInfo currentError = it.getCurrentError();
                if (currentError != null) {
                    destination$iv$iv.add(currentError);
                }
            }
            return (List) destination$iv$iv;
        }

        public final void clearErrors$runtime_release() {
            Iterable $this$mapNotNull$iv = (Iterable) Recomposer._runningRecomposers.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                RecomposerInfoImpl it = (RecomposerInfoImpl) element$iv$iv$iv;
                RecomposerErrorState recomposerErrorStateResetErrorState = it.resetErrorState();
                if (recomposerErrorStateResetErrorState != null) {
                    destination$iv$iv.add(recomposerErrorStateResetErrorState);
                }
            }
        }
    }
}
