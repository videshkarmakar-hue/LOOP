package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.collection.ArraySet;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSet;
import androidx.collection.IntSetKt;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ø\u00012\u00020\u0001:\u0010ö\u0001÷\u0001ø\u0001ù\u0001ú\u0001û\u0001ü\u0001ý\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010o\u001a\u00020!2\u0006\u0010p\u001a\u00020\u00122\u0006\u0010q\u001a\u00020*2\u0006\u0010r\u001a\u00020\u00062\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0010\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020%H\u0002J\u0010\u0010x\u001a\u00020!H\u0080@¢\u0006\u0004\by\u0010zJ:\u0010{\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010|\u001a\u00020\u00142\u0006\u0010}\u001a\u00020\u00122\u0006\u0010~\u001a\u00020\u007fH\u0002ø\u0001\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J,\u0010{\u001a\u00020\u00142\u0006\u0010|\u001a\u00020\u00142\u0006\u0010}\u001a\u00020\u00122\u0006\u0010~\u001a\u00020\u007fH\u0000ø\u0001\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\t\u0010\u0084\u0001\u001a\u00020!H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u0012H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020N2\u0006\u0010p\u001a\u00020\u00122\u0007\u0010\u0087\u0001\u001a\u00020\u0012H\u0003J\u0013\u0010\u0088\u0001\u001a\u0004\u0018\u00010*2\u0006\u0010p\u001a\u00020\u0012H\u0002JC\u0010\u0089\u0001\u001a\u00020N2\u0006\u0010p\u001a\u00020\u00122\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0003\u0010\u008e\u0001J\u0019\u0010\u008f\u0001\u001a\u00020\u00142\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0000¢\u0006\u0003\b\u0092\u0001JF\u0010\u0093\u0001\u001a\u00020!2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u001b\u0010\u0096\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0095\u00010\u0097\u0001j\n\u0012\u0005\u0012\u00030\u0095\u0001`\u0098\u00012\u0014\u0010\u0099\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0095\u00010,0=H\u0002J\u0013\u0010\u009a\u0001\u001a\u00020K2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\u0012\u0010\u009d\u0001\u001a\u00020\u00122\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020\u00122\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020\u00142\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002J\u0014\u0010 \u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002J\u0015\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002J\u0016\u0010£\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010w\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J \u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\t\u0010w\u001a\u0005\u0018\u00010\u0095\u00012\u0007\u0010¦\u0001\u001a\u00020\u0012H\u0002J#\u0010§\u0001\u001a\u00020\u00122\b\u0010¨\u0001\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030©\u0001H\u0001¢\u0006\u0003\b«\u0001J\u0011\u0010¬\u0001\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u0012H\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020\u00142\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002J\u0012\u0010®\u0001\u001a\u00020\u00142\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002J\u0012\u0010¯\u0001\u001a\u00020!2\u0007\u0010°\u0001\u001a\u00020hH\u0002J\u0018\u0010±\u0001\u001a\u00020!2\u0007\u0010°\u0001\u001a\u00020hH\u0000¢\u0006\u0003\b²\u0001J\u000f\u0010³\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b´\u0001J$\u0010µ\u0001\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u00122\u0007\u0010¶\u0001\u001a\u00020\u00122\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J$\u0010·\u0001\u001a\u00020!2\u0006\u0010p\u001a\u00020\u00122\u0007\u0010q\u001a\u00030¸\u00012\b\u0010¹\u0001\u001a\u00030\u0095\u0001H\u0002J!\u0010º\u0001\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020\u00122\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020a0/H\u0002J\u0011\u0010½\u0001\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u0012H\u0002J\u0012\u0010¾\u0001\u001a\u00020!2\u0007\u0010¿\u0001\u001a\u00020aH\u0002J'\u0010À\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0095\u00010Á\u0001j\n\u0012\u0005\u0012\u00030\u0095\u0001`Â\u00012\u0007\u0010Ã\u0001\u001a\u00020\u0014H\u0082\bJ\u0012\u0010Ä\u0001\u001a\u00020\u00122\u0007\u0010»\u0001\u001a\u00020\u0012H\u0002J\u001c\u0010Å\u0001\u001a\u00020!2\b\u0010Æ\u0001\u001a\u00030\u0095\u00012\u0007\u0010Ç\u0001\u001a\u00020\\H\u0002J\u0012\u0010È\u0001\u001a\u00020\u00142\u0007\u0010\u0090\u0001\u001a\u00020NH\u0002J@\u0010É\u0001\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u00122\u0007\u0010\u0087\u0001\u001a\u00020\u00122\u000b\b\u0002\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00122\u0011\b\u0002\u0010Ë\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/H\u0002¢\u0006\u0003\u0010Ì\u0001J&\u0010Í\u0001\u001a\u00020!2\u0007\u0010Î\u0001\u001a\u00020\u00122\u0007\u0010Ê\u0001\u001a\u00020\u00122\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010Ð\u0001\u001a\u00020!2\u0007\u0010Î\u0001\u001a\u00020\u0012H\u0002J\u0018\u0010Ñ\u0001\u001a\u00020!2\r\u0010Ò\u0001\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u001b\u0010Ó\u0001\u001a\u00020!2\u0007\u0010°\u0001\u001a\u00020h2\u0007\u0010Ô\u0001\u001a\u00020UH\u0002J\u0012\u0010Õ\u0001\u001a\u00020!2\u0007\u0010°\u0001\u001a\u00020hH\u0002J-\u0010Ö\u0001\u001a\u00020\u00142\u0007\u0010w\u001a\u00030\u0095\u00012\u0007\u0010×\u0001\u001a\u00020\u00122\u0007\u0010Ø\u0001\u001a\u00020\u00122\u0007\u0010Ù\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010Ú\u0001\u001a\u00020!2\u0007\u0010w\u001a\u00030\u0095\u00012\u0007\u0010q\u001a\u00030¸\u0001H\u0002J\u001b\u0010Û\u0001\u001a\u00020!2\u0007\u0010w\u001a\u00030\u0095\u00012\u0007\u0010q\u001a\u00030¸\u0001H\u0002J\u001b\u0010Ü\u0001\u001a\u00020!2\u0007\u0010w\u001a\u00030\u0095\u00012\u0007\u0010q\u001a\u00030¸\u0001H\u0002J\u001b\u0010Ý\u0001\u001a\u00020!2\u0007\u0010w\u001a\u00030\u0095\u00012\u0007\u0010q\u001a\u00030¸\u0001H\u0002J\t\u0010Þ\u0001\u001a\u00020!H\u0002JN\u0010ß\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010,2\u0007\u0010Ã\u0001\u001a\u00020\u00142\u001b\u0010à\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0095\u00010\u0097\u0001j\n\u0012\u0005\u0012\u00030\u0095\u0001`\u0098\u00012\u0016\b\u0002\u0010á\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0095\u00010,0=H\u0002J)\u0010â\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010,2\u0007\u0010Ã\u0001\u001a\u00020\u00142\u000e\u0010ã\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010,H\u0002J\"\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\n\u0010æ\u0001\u001a\u0005\u0018\u00010\u0095\u00012\b\u0010ç\u0001\u001a\u00030è\u0001H\u0002J-\u0010é\u0001\u001a\u00020\u00142\u0007\u0010w\u001a\u00030\u0095\u00012\u0007\u0010¦\u0001\u001a\u00020\u00122\u0007\u0010ê\u0001\u001a\u00020\u00142\u0007\u0010ë\u0001\u001a\u00020\u0014H\u0002J4\u0010ì\u0001\u001a\u0005\u0018\u0001Hí\u0001\"\t\b\u0000\u0010í\u0001*\u00020\u001e2\n\u0010\u008d\u0001\u001a\u0005\u0018\u0001Hí\u00012\t\b\u0001\u0010î\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0003\u0010ï\u0001J\u0011\u0010ð\u0001\u001a\u00020!2\u0006\u0010p\u001a\u00020\u0012H\u0002J\t\u0010ñ\u0001\u001a\u00020!H\u0002J\u0011\u0010ò\u0001\u001a\u0005\u0018\u00010¢\u0001*\u00030ó\u0001H\u0002J\u001a\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001*\u00030¢\u00012\u0007\u0010w\u001a\u00030\u0095\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010+\u001a&\u0012\f\u0012\n .*\u0004\u0018\u00010-0- .*\u0012\u0012\f\u0012\n .*\u0004\u0018\u00010-0-\u0018\u00010/0,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00120=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR \u0010B\u001a\b\u0012\u0004\u0012\u00020\u00120=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u0014\u0010E\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0017R\u0014\u0010G\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0017R\u001a\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0I0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010L\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00140M8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u00107\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020W0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010^\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010_R\u001a\u0010`\u001a\u000e\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020!0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020a0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020h0gX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006þ\u0001"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "ExtraDataTestTraversalAfterVal", "", "getExtraDataTestTraversalAfterVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalBeforeVal", "getExtraDataTestTraversalBeforeVal$ui_release", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui_release", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui_release", "(J)V", "accessibilityCursorPosition", "", DownloadUtil.CookieScheme.VALUE, "", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "currentSemanticsNodesInvalidated", "currentlyFocusedANI", "Landroid/view/accessibility/AccessibilityNodeInfo;", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release$annotations", "()V", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Landroidx/collection/MutableIntObjectMap;", "getIdToAfterMap$ui_release", "()Landroidx/collection/MutableIntObjectMap;", "setIdToAfterMap$ui_release", "(Landroidx/collection/MutableIntObjectMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabled$ui_release", "isTouchExplorationEnabled", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "getOnSendAccessibilityEvent$ui_release$annotations", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "pendingHorizontalScrollEvents", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "pendingVerticalScrollEvents", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scheduleScrollEventIfNeededLambda", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scrollObservationScopes", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendingFocusAffectingEvent", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsInScreen", "Landroid/graphics/Rect;", "node", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "eventType", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "geometryDepthFirstSearch", "currNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "geometryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "containerMapToChildren", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "getAccessibilitySelectionStart", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroidx/compose/ui/text/AnnotatedString;", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "isScreenReaderFocusable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "scheduleScrollEventIfNeeded", "scrollObservationScope", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "sendTypeViewScrolledAccessibilityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setIsCheckable", "setStateDescription", "setText", "setTraversalValues", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", ExifInterface.GPS_DIRECTION_TRUE, "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "toSpannableString", "Landroid/text/SpannableString;", "Api24Impl", "Api29Impl", "Companion", "ComposeAccessibilityNodeProvider", "LtrBoundsComparator", "PendingTextTraversedEvent", "RtlBoundsComparator", "TopBottomBoundsComparator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfo currentlyFocusedANI;
    private List<AccessibilityServiceInfo> enabledServices;
    private final android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    private final Handler handler;
    private MutableIntObjectMap<Integer> idToAfterMap;
    private MutableIntObjectMap<Integer> idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private AccessibilityNodeProviderCompat nodeProvider;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent it) {
            return Boolean.valueOf(this.this$0.getView().getParent().requestSendAccessibilityEvent(this.this$0.getView(), it));
        }
    };

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getHoveredVirtualViewId$ui_release$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView view) {
        this.view = view;
        Object systemService = this.view.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100L;
        this.enabledStateListener = new android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(this.f$0, z);
            }
        };
        this.touchExplorationStateListener = new android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener$lambda$1(this.f$0, z);
            }
        };
        this.enabledServices = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new ComposeAccessibilityNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntObjectMap<>(0, 1, null);
        this.idToAfterMap = new MutableIntObjectMap<>(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                android.view.accessibility.AccessibilityManager $this$onViewAttachedToWindow_u24lambda_u240 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                $this$onViewAttachedToWindow_u24lambda_u240.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                $this$onViewAttachedToWindow_u24lambda_u240.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
                android.view.accessibility.AccessibilityManager $this$onViewDetachedFromWindow_u24lambda_u241 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                $this$onViewDetachedFromWindow_u24lambda_u241.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                $this$onViewDetachedFromWindow_u24lambda_u241.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$50(this.f$0);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope it) {
                this.this$0.scheduleScrollEventIfNeeded(it);
            }
        };
    }

    /* JADX INFO: renamed from: getHoveredVirtualViewId$ui_release, reason: from getter */
    public final int getHoveredVirtualViewId() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui_release() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui_release(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    /* JADX INFO: renamed from: getAccessibilityForceEnabledForTesting$ui_release, reason: from getter */
    public final boolean getAccessibilityForceEnabledForTesting() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean value) {
        this.accessibilityForceEnabledForTesting = value;
        this.currentSemanticsNodesInvalidated = true;
    }

    /* JADX INFO: renamed from: getSendRecurringAccessibilityEventsIntervalMillis$ui_release, reason: from getter */
    public final long getSendRecurringAccessibilityEventsIntervalMillis() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui_release(long j) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean enabled) {
        List<AccessibilityServiceInfo> listEmptyList;
        if (enabled) {
            listEmptyList = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        this$0.enabledServices = listEmptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean it) {
        this$0.enabledServices = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    public final boolean isEnabled$ui_release() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        return this.accessibilityManager.isEnabled() && (this.enabledServices.isEmpty() ^ true);
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode node, int action, int granularity, int fromIndex, int toIndex, long traverseTime) {
            this.node = node;
            this.action = action;
            this.granularity = granularity;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.traverseTime = traverseTime;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            if (isEnabled$ui_release()) {
                setTraversalValues();
            }
        }
        return this.currentSemanticsNodes;
    }

    public final MutableIntObjectMap<Integer> getIdToBeforeMap$ui_release() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(MutableIntObjectMap<Integer> mutableIntObjectMap) {
        this.idToBeforeMap = mutableIntObjectMap;
    }

    public final MutableIntObjectMap<Integer> getIdToAfterMap$ui_release() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(MutableIntObjectMap<Integer> mutableIntObjectMap) {
        this.idToAfterMap = mutableIntObjectMap;
    }

    /* JADX INFO: renamed from: getExtraDataTestTraversalBeforeVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalBeforeVal() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    /* JADX INFO: renamed from: getExtraDataTestTraversalAfterVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalAfterVal() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    /* JADX INFO: renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m5726canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return false;
        }
        return m5725canScrollmoWRBKg(getCurrentSemanticsNodes(), vertical, direction, position);
    }

    /* JADX INFO: renamed from: canScroll-moWRBKg, reason: not valid java name */
    private final boolean m5725canScrollmoWRBKg(IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes, boolean vertical, int direction, long position) {
        SemanticsPropertyKey<ScrollAxisRange> horizontalScrollAxisRange;
        ScrollAxisRange scrollRange;
        if (Offset.m3798equalsimpl0(position, Offset.INSTANCE.m3816getUnspecifiedF1C5BW0()) || !Offset.m3804isValidimpl(position)) {
            return false;
        }
        if (vertical) {
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else {
            if (vertical) {
                throw new NoWhenBranchMatchedException();
            }
            horizontalScrollAxisRange = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        }
        boolean foundNode = false;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap = currentSemanticsNodes;
        Object[] v$iv = intObjectMap.values;
        long[] m$iv$iv = intObjectMap.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                boolean foundNode2 = foundNode;
                IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2 = intObjectMap;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    foundNode = foundNode2;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                        if ($i$f$isFull != 0) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            SemanticsNodeWithAdjustedBounds node = (SemanticsNodeWithAdjustedBounds) v$iv[index$iv$iv];
                            if (RectHelper_androidKt.toComposeRect(node.getAdjustedBounds()).m3827containsk4lQ0M(position) && (scrollRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getSemanticsNode().getUnmergedConfig(), horizontalScrollAxisRange)) != null) {
                                int actualDirection = scrollRange.getReverseScrolling() ? -direction : direction;
                                if (direction == 0 && scrollRange.getReverseScrolling()) {
                                    actualDirection = -1;
                                }
                                if (actualDirection < 0) {
                                    if (scrollRange.getValue().invoke().floatValue() > 0.0f) {
                                        foundNode2 = true;
                                    }
                                } else if (scrollRange.getValue().invoke().floatValue() < scrollRange.getMaxValue().invoke().floatValue()) {
                                    foundNode2 = true;
                                }
                            }
                        }
                        slot$iv$iv >>= 8;
                    }
                    if (bitCount$iv$iv != 8) {
                        return foundNode2;
                    }
                    foundNode = foundNode2;
                }
                if (i$iv$iv != lastIndex$iv$iv) {
                    i$iv$iv++;
                    intObjectMap = intObjectMap2;
                }
            }
        }
        return foundNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfo createNodeInfo(int virtualViewId) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycleRegistry;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) == null) ? null : lifecycleRegistry.getState()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null) {
            return null;
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (virtualViewId == -1) {
            ViewParent parentForAccessibility = this.view.getParentForAccessibility();
            accessibilityNodeInfoCompatObtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode parent = semanticsNode.getParent();
            Integer numValueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                if (iIntValue == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                    iIntValue = -1;
                }
                accessibilityNodeInfoCompatObtain.setParent(this.view, iIntValue);
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + virtualViewId + " has null parent");
                throw new KotlinNothingValueException();
            }
        }
        accessibilityNodeInfoCompatObtain.setSource(this.view, virtualViewId);
        accessibilityNodeInfoCompatObtain.setBoundsInScreen(boundsInScreen(semanticsNodeWithAdjustedBounds));
        populateAccessibilityNodeInfoProperties(virtualViewId, accessibilityNodeInfoCompatObtain, semanticsNode);
        return accessibilityNodeInfoCompatObtain.unwrap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds node) {
        Rect boundsInRoot = node.getAdjustedBounds();
        long topLeftInScreen = this.view.mo5345localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.left, boundsInRoot.top));
        long bottomRightInScreen = this.view.mo5345localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.right, boundsInRoot.bottom));
        return new Rect((int) Math.floor(Offset.m3801getXimpl(topLeftInScreen)), (int) Math.floor(Offset.m3802getYimpl(topLeftInScreen)), (int) Math.ceil(Offset.m3801getXimpl(bottomRightInScreen)), (int) Math.ceil(Offset.m3802getYimpl(bottomRightInScreen)));
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J<\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class TopBottomBoundsComparator implements Comparator<Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>> {
        public static final TopBottomBoundsComparator INSTANCE = new TopBottomBoundsComparator();

        private TopBottomBoundsComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair, Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair2) {
            return compare2((Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>) pair, (Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>) pair2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> a, Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> b) {
            int r = Float.compare(a.getFirst().getTop(), b.getFirst().getTop());
            return r != 0 ? r : Float.compare(a.getFirst().getBottom(), b.getFirst().getBottom());
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class LtrBoundsComparator implements Comparator<SemanticsNode> {
        public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator();

        private LtrBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a, SemanticsNode b) {
            androidx.compose.ui.geometry.Rect ab = a.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect bb = b.getBoundsInWindow();
            int r = Float.compare(ab.getLeft(), bb.getLeft());
            if (r != 0) {
                return r;
            }
            int r2 = Float.compare(ab.getTop(), bb.getTop());
            if (r2 != 0) {
                return r2;
            }
            int r3 = Float.compare(ab.getBottom(), bb.getBottom());
            return r3 != 0 ? r3 : Float.compare(ab.getRight(), bb.getRight());
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$RtlBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class RtlBoundsComparator implements Comparator<SemanticsNode> {
        public static final RtlBoundsComparator INSTANCE = new RtlBoundsComparator();

        private RtlBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a, SemanticsNode b) {
            androidx.compose.ui.geometry.Rect ab = a.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect bb = b.getBoundsInWindow();
            int r = Float.compare(bb.getRight(), ab.getRight());
            if (r != 0) {
                return r;
            }
            int r2 = Float.compare(ab.getTop(), bb.getTop());
            if (r2 != 0) {
                return r2;
            }
            int r3 = Float.compare(ab.getBottom(), bb.getBottom());
            return r3 != 0 ? r3 : Float.compare(bb.getLeft(), ab.getLeft());
        }
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean layoutIsRtl) {
        return new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(layoutIsRtl ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.INSTANCE.getZComparator$ui_release()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List sortByGeometryGroupings$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z, ArrayList arrayList, MutableIntObjectMap mutableIntObjectMap, int i, Object obj) {
        if ((i & 4) != 0) {
            mutableIntObjectMap = IntObjectMapKt.mutableIntObjectMapOf();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z, arrayList, mutableIntObjectMap);
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean layoutIsRtl, ArrayList<SemanticsNode> parentListToSort, MutableIntObjectMap<List<SemanticsNode>> containerChildrenMapping) {
        ArrayList rowGroupings = new ArrayList();
        int entryIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(parentListToSort);
        if (0 <= lastIndex) {
            while (true) {
                SemanticsNode currEntry = parentListToSort.get(entryIndex);
                if (entryIndex == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(rowGroupings, currEntry)) {
                    androidx.compose.ui.geometry.Rect newRect = currEntry.getBoundsInWindow();
                    rowGroupings.add(new Pair(newRect, CollectionsKt.mutableListOf(currEntry)));
                }
                if (entryIndex == lastIndex) {
                    break;
                }
                entryIndex++;
            }
        }
        CollectionsKt.sortWith(rowGroupings, TopBottomBoundsComparator.INSTANCE);
        ArrayList returnList = new ArrayList();
        ArrayList $this$fastForEach$iv = rowGroupings;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Pair row = (Pair) item$iv;
            CollectionsKt.sortWith((List) row.getSecond(), new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(layoutIsRtl ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.INSTANCE.getZComparator$ui_release())));
            returnList.addAll((Collection) row.getSecond());
        }
        final AnonymousClass2 anonymousClass2 = new Function2<SemanticsNode, SemanticsNode, Integer>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SemanticsNode a, SemanticsNode b) {
                return Integer.valueOf(Float.compare(((Number) a.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) b.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
        CollectionsKt.sortWith(returnList, new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings$lambda$7(anonymousClass2, obj, obj2);
            }
        });
        int i = 0;
        while (i <= CollectionsKt.getLastIndex(returnList)) {
            int currNodeId = ((SemanticsNode) returnList.get(i)).getId();
            List<SemanticsNode> list = containerChildrenMapping.get(currNodeId);
            if (list != null) {
                boolean containerIsScreenReaderFocusable = isScreenReaderFocusable((SemanticsNode) returnList.get(i));
                if (containerIsScreenReaderFocusable) {
                    i++;
                } else {
                    returnList.remove(i);
                }
                returnList.addAll(i, list);
                i += list.size();
            } else {
                i++;
            }
        }
        return returnList;
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(ArrayList<Pair<androidx.compose.ui.geometry.Rect, List<SemanticsNode>>> arrayList, SemanticsNode node) {
        float entryTopCoord = node.getBoundsInWindow().getTop();
        float entryBottomCoord = node.getBoundsInWindow().getBottom();
        boolean entryIsEmpty = entryTopCoord >= entryBottomCoord;
        int currIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (0 <= lastIndex) {
            while (true) {
                androidx.compose.ui.geometry.Rect currRect = arrayList.get(currIndex).getFirst();
                boolean groupIsEmpty = currRect.getTop() >= currRect.getBottom();
                boolean groupOverlapsEntry = (entryIsEmpty || groupIsEmpty || Math.max(entryTopCoord, currRect.getTop()) >= Math.min(entryBottomCoord, currRect.getBottom())) ? false : true;
                if (!groupOverlapsEntry) {
                    if (currIndex != lastIndex) {
                        currIndex++;
                    }
                } else {
                    androidx.compose.ui.geometry.Rect newRect = currRect.intersect(0.0f, entryTopCoord, Float.POSITIVE_INFINITY, entryBottomCoord);
                    arrayList.set(currIndex, new Pair<>(newRect, arrayList.get(currIndex).getSecond()));
                    arrayList.get(currIndex).getSecond().add(node);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortByGeometryGroupings$lambda$7(Function2 $tmp0, Object p0, Object p1) {
        return ((Number) $tmp0.invoke(p0, p1)).intValue();
    }

    private final void geometryDepthFirstSearch(SemanticsNode currNode, ArrayList<SemanticsNode> geometryList, MutableIntObjectMap<List<SemanticsNode>> containerMapToChildren) {
        boolean currRTL = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(currNode);
        boolean isTraversalGroup = ((Boolean) currNode.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$geometryDepthFirstSearch$isTraversalGroup$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).booleanValue();
        if ((isTraversalGroup || isScreenReaderFocusable(currNode)) && getCurrentSemanticsNodes().containsKey(currNode.getId())) {
            geometryList.add(currNode);
        }
        if (isTraversalGroup) {
            containerMapToChildren.set(currNode.getId(), subtreeSortedByGeometryGrouping(currRTL, CollectionsKt.toMutableList((Collection) currNode.getChildren())));
            return;
        }
        List<SemanticsNode> children = currNode.getChildren();
        int size = children.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = children.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            geometryDepthFirstSearch(child, geometryList, containerMapToChildren);
        }
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean layoutIsRtl, List<SemanticsNode> listToSort) {
        MutableIntObjectMap<List<SemanticsNode>> mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList<SemanticsNode> arrayList = new ArrayList<>();
        int size = listToSort.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = listToSort.get(index$iv);
            SemanticsNode node = (SemanticsNode) item$iv;
            geometryDepthFirstSearch(node, arrayList, mutableIntObjectMapMutableIntObjectMapOf);
        }
        return sortByGeometryGroupings(layoutIsRtl, arrayList, mutableIntObjectMapMutableIntObjectMapOf);
    }

    private final void setTraversalValues() {
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(-1);
        SemanticsNode hostSemanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(hostSemanticsNode);
        boolean hostLayoutIsRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(hostSemanticsNode);
        List<SemanticsNode> listSubtreeSortedByGeometryGrouping = subtreeSortedByGeometryGrouping(hostLayoutIsRtl, CollectionsKt.mutableListOf(hostSemanticsNode));
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex(listSubtreeSortedByGeometryGrouping);
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            int prevId = listSubtreeSortedByGeometryGrouping.get(i - 1).getId();
            int currId = listSubtreeSortedByGeometryGrouping.get(i).getId();
            this.idToBeforeMap.set(prevId, Integer.valueOf(currId));
            this.idToAfterMap.set(currId, Integer.valueOf(prevId));
            if (i == lastIndex) {
                return;
            } else {
                i++;
            }
        }
    }

    private final boolean isScreenReaderFocusable(SemanticsNode node) {
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
        String nodeContentDescriptionOrNull = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
        boolean isSpeakingNode = (nodeContentDescriptionOrNull == null && getInfoText(node) == null && getInfoStateDescriptionOrNull(node) == null && !getInfoIsCheckable(node)) ? false : true;
        return node.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || (node.isUnmergedLeafNode$ui_release() && isSpeakingNode);
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0382  */
    private final void populateAccessibilityNodeInfoProperties(int virtualViewId, AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        boolean isRadioButtonOrTab;
        info.setClassName(ClassName);
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            role.getValue();
            if (semanticsNode.getIsFake() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                if (Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5820getTabo7Vup1c())) {
                    info.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else if (Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5819getSwitcho7Vup1c())) {
                    info.setRoleDescription(this.view.getContext().getResources().getString(R.string.switch_role));
                } else {
                    String className = SemanticsUtils_androidKt.m5785toLegacyClassNameV4PA4sw(role.getValue());
                    if (!Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5817getImageo7Vup1c()) || semanticsNode.isUnmergedLeafNode$ui_release() || semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants()) {
                        info.setClassName(className);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText())) {
            info.setClassName(TextFieldClassName);
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getText())) {
            info.setClassName(TextClassName);
        }
        info.setPackageName(this.view.getContext().getPackageName());
        info.setImportantForAccessibility(SemanticsUtils_androidKt.isImportantForAccessibility(semanticsNode));
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = replacedChildren$ui_release.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes().contains(child.getId())) {
                AndroidViewHolder holder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(child.getLayoutNode());
                if (holder != null) {
                    info.addChild(holder);
                } else {
                    info.addChild(this.view, child.getId());
                }
            }
        }
        if (virtualViewId == this.focusedVirtualViewId) {
            info.setAccessibilityFocused(true);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            info.setAccessibilityFocused(false);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode, info);
        setContentInvalid(semanticsNode, info);
        setStateDescription(semanticsNode, info);
        setIsCheckable(semanticsNode, info);
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleState != null) {
            if (toggleState == ToggleableState.On) {
                info.setChecked(true);
            } else if (toggleState == ToggleableState.Off) {
                info.setChecked(false);
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it = bool.booleanValue();
            if (role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5820getTabo7Vup1c())) {
                info.setSelected(it);
            } else {
                info.setChecked(it);
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
            info.setContentDescription(list != null ? (String) CollectionsKt.firstOrNull(list) : null);
        }
        String testTag = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
        if (testTag != null) {
            boolean testTagsAsResourceId = false;
            for (SemanticsNode current = semanticsNode; current != null; current = current.getParent()) {
                if (current.getUnmergedConfig().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    testTagsAsResourceId = ((Boolean) current.getUnmergedConfig().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                    break;
                }
            }
            if (testTagsAsResourceId) {
                info.setViewIdResourceName(testTag);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            info.setHeading(true);
            Unit it2 = Unit.INSTANCE;
            Unit unit7 = Unit.INSTANCE;
        }
        info.setPassword(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
        info.setEditable(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditable()));
        Integer num = (Integer) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getMaxTextLength());
        info.setMaxTextLength(num != null ? num.intValue() : -1);
        info.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode));
        info.setFocusable(semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getFocused()));
        int i = 2;
        if (info.isFocusable()) {
            info.setFocused(((Boolean) semanticsNode.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (info.isFocused()) {
                info.addAction(2);
            } else {
                info.addAction(1);
            }
        }
        info.setVisibleToUser(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int it3 = liveRegionMode.getValue();
            if (LiveRegionMode.m5801equalsimpl0(it3, LiveRegionMode.INSTANCE.m5806getPolite0phEisY()) || !LiveRegionMode.m5801equalsimpl0(it3, LiveRegionMode.INSTANCE.m5805getAssertive0phEisY())) {
                i = 1;
            }
            info.setLiveRegion(i);
            Unit unit8 = Unit.INSTANCE;
            Unit unit9 = Unit.INSTANCE;
        }
        info.setClickable(false);
        AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
        if (it4 != null) {
            boolean isSelected = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            if (role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5820getTabo7Vup1c())) {
                isRadioButtonOrTab = true;
            } else if (role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5818getRadioButtono7Vup1c())) {
                isRadioButtonOrTab = true;
            } else {
                isRadioButtonOrTab = false;
            }
            info.setClickable(!isRadioButtonOrTab || (isRadioButtonOrTab && !isSelected));
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && info.isClickable()) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, it4.getLabel()));
            }
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        info.setLongClickable(false);
        AccessibilityAction it5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
        if (it5 != null) {
            info.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, it5.getLabel()));
            }
            Unit unit12 = Unit.INSTANCE;
            Unit unit13 = Unit.INSTANCE;
        }
        AccessibilityAction it6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
        if (it6 != null) {
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, it6.getLabel()));
            Unit unit14 = Unit.INSTANCE;
            Unit unit15 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction it7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
            if (it7 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, it7.getLabel()));
                Unit unit16 = Unit.INSTANCE;
                Unit unit17 = Unit.INSTANCE;
            }
            AccessibilityAction it8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnImeAction());
            if (it8 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionImeEnter, it8.getLabel()));
                Unit unit18 = Unit.INSTANCE;
                Unit unit19 = Unit.INSTANCE;
            }
            AccessibilityAction it9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
            if (it9 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, it9.getLabel()));
                Unit unit20 = Unit.INSTANCE;
                Unit unit21 = Unit.INSTANCE;
            }
            AccessibilityAction it10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
            if (it10 != null) {
                if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, it10.getLabel()));
                }
                Unit unit22 = Unit.INSTANCE;
                Unit unit23 = Unit.INSTANCE;
            }
        }
        String text = getIterableTextForAccessibility(semanticsNode);
        String str = text;
        if (!(str == null || str.length() == 0)) {
            info.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
            AccessibilityAction setSelectionAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetSelection());
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, setSelectionAction != null ? setSelectionAction.getLabel() : null));
            info.addAction(256);
            info.addAction(512);
            info.setMovementGranularities(11);
            List contentDescription = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
            List list2 = contentDescription;
            if ((list2 == null || list2.isEmpty()) && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode)) {
                info.setMovementGranularities(16 | info.getMovementGranularities() | 4);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            List extraDataKeys = new ArrayList();
            extraDataKeys.add(ExtraDataIdKey);
            CharSequence text2 = info.getText();
            if (!(text2 == null || text2.length() == 0) && semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                extraDataKeys.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag())) {
                extraDataKeys.add(ExtraDataTestTagKey);
            }
            AccessibilityNodeInfoVerificationHelperMethods.INSTANCE.setAvailableExtraData(info.unwrap(), extraDataKeys);
        }
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                info.setClassName("android.widget.SeekBar");
            } else {
                info.setClassName("android.widget.ProgressBar");
            }
            if (rangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getCurrent()));
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (rangeInfo.getCurrent() < RangesKt.coerceAtLeast(rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getRange().getStart().floatValue())) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (rangeInfo.getCurrent() > RangesKt.coerceAtMost(rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue())) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.addSetProgressAction(info, semanticsNode);
        }
        CollectionInfo_androidKt.setCollectionInfo(semanticsNode, info);
        CollectionInfo_androidKt.setCollectionItemInfo(semanticsNode, info);
        ScrollAxisRange xScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction scrollAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
        if (xScrollState != null && scrollAction != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.HorizontalScrollView");
            }
            if (xScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(xScrollState)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    info.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(xScrollState)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    info.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange yScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (yScrollState != null && scrollAction != null) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.ScrollView");
            }
            if (yScrollState.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(yScrollState)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(yScrollState)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(info, semanticsNode);
        }
        info.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction it11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
            if (it11 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, it11.getLabel()));
                Unit unit24 = Unit.INSTANCE;
                Unit unit25 = Unit.INSTANCE;
            }
            AccessibilityAction it12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
            if (it12 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, it12.getLabel()));
                Unit unit26 = Unit.INSTANCE;
                Unit unit27 = Unit.INSTANCE;
            }
            AccessibilityAction it13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
            if (it13 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, it13.getLabel()));
                Unit unit28 = Unit.INSTANCE;
                Unit unit29 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List customActions = (List) semanticsNode.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                if (customActions.size() >= AccessibilityActionsResourceIds.getSize()) {
                    throw new IllegalStateException("Can't have more than " + AccessibilityActionsResourceIds.getSize() + " custom actions for one widget");
                }
                SparseArrayCompat<CharSequence> sparseArrayCompat = new SparseArrayCompat<>(0, 1, null);
                MutableObjectIntMap<CharSequence> mutableObjectIntMapMutableObjectIntMapOf = ObjectIntMapKt.mutableObjectIntMapOf();
                if (this.labelToActionId.containsKey(virtualViewId)) {
                    MutableObjectIntMap<CharSequence> mutableObjectIntMap = this.labelToActionId.get(virtualViewId);
                    MutableIntList availableIds = new MutableIntList(0, 1, null);
                    IntList this_$iv = AccessibilityActionsResourceIds;
                    int[] content$iv = this_$iv.content;
                    int i$iv = 0;
                    for (int i2 = this_$iv._size; i$iv < i2; i2 = i2) {
                        availableIds.add(content$iv[i$iv]);
                        i$iv++;
                    }
                    List unassignedActions = new ArrayList();
                    List $this$fastForEach$iv = customActions;
                    int $i$f$fastForEach = 0;
                    int index$iv2 = 0;
                    int size2 = $this$fastForEach$iv.size();
                    while (index$iv2 < size2) {
                        Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                        List $this$fastForEach$iv2 = $this$fastForEach$iv;
                        CustomAccessibilityAction action = (CustomAccessibilityAction) item$iv2;
                        Intrinsics.checkNotNull(mutableObjectIntMap);
                        int $i$f$fastForEach2 = $i$f$fastForEach;
                        if (mutableObjectIntMap.contains(action.getLabel())) {
                            int actionId = mutableObjectIntMap.get(action.getLabel());
                            sparseArrayCompat.put(actionId, action.getLabel());
                            mutableObjectIntMapMutableObjectIntMapOf.set(action.getLabel(), actionId);
                            availableIds.remove(actionId);
                            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId, action.getLabel()));
                        } else {
                            unassignedActions.add(action);
                        }
                        index$iv2++;
                        $this$fastForEach$iv = $this$fastForEach$iv2;
                        $i$f$fastForEach = $i$f$fastForEach2;
                        scrollAction = scrollAction;
                        mutableObjectIntMap = mutableObjectIntMap;
                    }
                    List $this$fastForEachIndexed$iv = unassignedActions;
                    int index$iv3 = 0;
                    int size3 = $this$fastForEachIndexed$iv.size();
                    while (index$iv3 < size3) {
                        Object item$iv3 = $this$fastForEachIndexed$iv.get(index$iv3);
                        CustomAccessibilityAction action2 = (CustomAccessibilityAction) item$iv3;
                        int index = index$iv3;
                        List $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
                        int actionId2 = availableIds.get(index);
                        sparseArrayCompat.put(actionId2, action2.getLabel());
                        mutableObjectIntMapMutableObjectIntMapOf.set(action2.getLabel(), actionId2);
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId2, action2.getLabel()));
                        index$iv3++;
                        $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                        unassignedActions = unassignedActions;
                        availableIds = availableIds;
                    }
                } else {
                    List $this$fastForEachIndexed$iv3 = customActions;
                    int $i$f$fastForEachIndexed = 0;
                    int index$iv4 = 0;
                    int size4 = $this$fastForEachIndexed$iv3.size();
                    while (index$iv4 < size4) {
                        Object item$iv4 = $this$fastForEachIndexed$iv3.get(index$iv4);
                        CustomAccessibilityAction action3 = (CustomAccessibilityAction) item$iv4;
                        int index2 = index$iv4;
                        List customActions2 = customActions;
                        int actionId3 = AccessibilityActionsResourceIds.get(index2);
                        sparseArrayCompat.put(actionId3, action3.getLabel());
                        mutableObjectIntMapMutableObjectIntMapOf.set(action3.getLabel(), actionId3);
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionId3, action3.getLabel()));
                        index$iv4++;
                        customActions = customActions2;
                        $this$fastForEachIndexed$iv3 = $this$fastForEachIndexed$iv3;
                        $i$f$fastForEachIndexed = $i$f$fastForEachIndexed;
                    }
                }
                this.actionIdToLabel.put(virtualViewId, sparseArrayCompat);
                this.labelToActionId.put(virtualViewId, mutableObjectIntMapMutableObjectIntMapOf);
            }
        }
        info.setScreenReaderFocusable(isScreenReaderFocusable(semanticsNode));
        Integer beforeId = this.idToBeforeMap.get(virtualViewId);
        if (beforeId != null) {
            beforeId.intValue();
            View beforeView = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), beforeId.intValue());
            if (beforeView != null) {
                info.setTraversalBefore(beforeView);
            } else {
                info.setTraversalBefore(this.view, beforeId.intValue());
            }
            addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info.unwrap(), this.ExtraDataTestTraversalBeforeVal, null);
            Unit unit30 = Unit.INSTANCE;
            Unit unit31 = Unit.INSTANCE;
        }
        Integer afterId = this.idToAfterMap.get(virtualViewId);
        if (afterId != null) {
            afterId.intValue();
            View afterView = SemanticsUtils_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), afterId.intValue());
            if (afterView != null) {
                info.setTraversalAfter(afterView);
                addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info.unwrap(), this.ExtraDataTestTraversalAfterVal, null);
            }
            Unit unit32 = Unit.INSTANCE;
            Unit unit33 = Unit.INSTANCE;
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollForward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getMaxValue().invoke().floatValue() && !$this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() > 0.0f && $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() > 0.0f && !$this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getMaxValue().invoke().floatValue() && $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode node) {
        int iCoerceIn;
        Object string;
        Object stateDescription = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (toggleState != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[toggleState.ordinal()]) {
                case 1:
                    if ((role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5819getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.state_on);
                    }
                    break;
                case 2:
                    if ((role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5819getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.state_off);
                    }
                    break;
                case 3:
                    if (stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.indeterminate);
                    }
                    break;
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it = bool.booleanValue();
            if (!(role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5820getTabo7Vup1c())) && stateDescription == null) {
                if (it) {
                    string = this.view.getContext().getResources().getString(R.string.selected);
                } else {
                    string = this.view.getContext().getResources().getString(R.string.not_selected);
                }
                stateDescription = string;
            }
        }
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            if (rangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                if (stateDescription == null) {
                    ClosedFloatingPointRange<Float> range = rangeInfo.getRange();
                    float $this$fastCoerceIn$iv = ((range.getEndInclusive().floatValue() - range.getStart().floatValue()) > 0.0f ? 1 : ((range.getEndInclusive().floatValue() - range.getStart().floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (rangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue());
                    float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                    if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                        $this$fastCoerceAtLeast$iv$iv = 0.0f;
                    }
                    if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                        $this$fastCoerceAtLeast$iv$iv = 1.0f;
                    }
                    float progress = $this$fastCoerceAtLeast$iv$iv;
                    if (progress == 0.0f) {
                        iCoerceIn = 0;
                    } else {
                        iCoerceIn = 100;
                        if (!(progress == 1.0f)) {
                            float $this$fastRoundToInt$iv = 100 * progress;
                            iCoerceIn = RangesKt.coerceIn(Math.round($this$fastRoundToInt$iv), 1, 99);
                        }
                    }
                    int percent = iCoerceIn;
                    stateDescription = this.view.getContext().getResources().getString(R.string.template_percent, Integer.valueOf(percent));
                }
            } else if (stateDescription == null) {
                stateDescription = this.view.getContext().getResources().getString(R.string.in_progress);
            }
        }
        return (String) stateDescription;
    }

    private final void setStateDescription(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setStateDescription(getInfoStateDescriptionOrNull(node));
    }

    private final boolean getInfoIsCheckable(SemanticsNode node) {
        boolean isCheckable = false;
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (toggleState != null) {
            isCheckable = true;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool == null) {
            return isCheckable;
        }
        bool.booleanValue();
        if (!(role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5820getTabo7Vup1c()))) {
            return true;
        }
        return isCheckable;
    }

    private final void setIsCheckable(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setCheckable(getInfoIsCheckable(node));
    }

    private final AnnotatedString getInfoText(SemanticsNode node) {
        AnnotatedString editableTextToAssign = getTextForTextField(node.getUnmergedConfig());
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        AnnotatedString textToAssign = list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null;
        return editableTextToAssign == null ? textToAssign : editableTextToAssign;
    }

    private final SpannableString toSpannableString(AnnotatedString $this$toSpannableString, SemanticsNode node) {
        MutableLongObjectMap mutableLongObjectMap;
        CustomAccessibilityAction customAccessibilityAction;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        if ($this$toSpannableString.hasLinkAnnotations(0, $this$toSpannableString.length())) {
            MutableLongObjectMap rangesToCustomActions = LongObjectMapKt.mutableLongObjectMapOf();
            List<SemanticsNode> children = node.getChildren();
            int $i$f$fastForEach = 0;
            int index$iv = 0;
            int size = children.size();
            while (index$iv < size) {
                Object item$iv = children.get(index$iv);
                SemanticsNode childNode = (SemanticsNode) item$iv;
                SemanticsConfiguration config = childNode.getUnmergedConfig();
                if (config.contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                    long range = ((TextRange) config.get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                    List list = (List) SemanticsConfigurationKt.getOrNull(config, SemanticsActions.INSTANCE.getCustomActions());
                    Function0<Boolean> action = (list == null || (customAccessibilityAction = (CustomAccessibilityAction) CollectionsKt.firstOrNull(list)) == null) ? null : customAccessibilityAction.getAction();
                    if (action != null) {
                        final Function0<Boolean> function0 = action;
                        int val1$iv = TextRange.m6003getStartimpl(range);
                        int val2$iv = TextRange.m5998getEndimpl(range);
                        rangesToCustomActions.set((((long) val1$iv) << 32) | (((long) val2$iv) & 4294967295L), new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$toSpannableString$linkActions$1$1$1
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
                                function0.invoke();
                            }
                        });
                    }
                }
                index$iv++;
                size = size;
                children = children;
                $i$f$fastForEach = $i$f$fastForEach;
            }
            mutableLongObjectMap = rangesToCustomActions;
        } else {
            mutableLongObjectMap = null;
        }
        MutableLongObjectMap linkActions = mutableLongObjectMap;
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString($this$toSpannableString, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache, linkActions, node.getId()), 100000);
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        AnnotatedString infoText = getInfoText(node);
        info.setText(infoText != null ? toSpannableString(infoText, node) : null);
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.focusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        if (this.focusedVirtualViewId != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, this.focusedVirtualViewId, 65536, null, null, 12, null);
        }
        this.focusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent event = createEvent(virtualViewId, eventType);
        if (contentChangeType != null) {
            event.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            event.setContentDescription(ListUtilsKt.fastJoinToString$default(contentDescription, ",", null, null, 0, null, null, 62, null));
        }
        return sendEvent(event);
    }

    private final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabled$ui_release()) {
            return false;
        }
        if (event.getEventType() == 2048 || event.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(event).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        SemanticsNodeWithAdjustedBounds it;
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        event.setEnabled(true);
        event.setClassName(ClassName);
        event.setPackageName(this.view.getContext().getPackageName());
        event.setSource(this.view, virtualViewId);
        if (isEnabled$ui_release() && (it = getCurrentSemanticsNodes().get(virtualViewId)) != null) {
            event.setPassword(it.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
        }
        return event;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent $this$createTextSelectionChangedEvent_u24lambda_u2445 = createEvent(virtualViewId, 8192);
        if (fromIndex != null) {
            int it = fromIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2445.setFromIndex(it);
        }
        if (toIndex != null) {
            int it2 = toIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2445.setToIndex(it2);
        }
        if (itemCount != null) {
            int it3 = itemCount.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2445.setItemCount(it3);
        }
        if (text != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2445.getText().add(text);
        }
        return $this$createTextSelectionChangedEvent_u24lambda_u2445;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (isAccessibilityFocused(virtualViewId)) {
            this.focusedVirtualViewId = Integer.MIN_VALUE;
            this.currentlyFocusedANI = null;
            this.view.invalidate();
            sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performActionHelper(int virtualViewId, int action, Bundle arguments) {
        SemanticsNode node;
        Function0 function0;
        Function0 function1;
        Function0 function2;
        Function0 function3;
        Function2 function4;
        Function0 function5;
        Function0 function6;
        Function0 function7;
        Function0 function8;
        Function0 function9;
        Function1 function10;
        Function2 function11;
        SemanticsConfiguration unmergedConfig;
        SemanticsConfiguration unmergedConfig2;
        AccessibilityAction accessibilityAction;
        Function1 function12;
        Function0 function13;
        Function0 function14;
        Function0 function15;
        Function0 function16;
        Function0 function17;
        CharSequence label;
        List customActions;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return false;
        }
        switch (action) {
            case 64:
                return requestAccessibilityFocus(virtualViewId);
            case 128:
                return clearAccessibilityFocus(virtualViewId);
            case 256:
            case 512:
                if (arguments == null) {
                    return false;
                }
                int granularity = arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
                boolean extendSelection = arguments.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
                return traverseAtGranularity(node, granularity, action == 256, extendSelection);
            case 16384:
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
                if (accessibilityAction2 == null || (function0 = (Function0) accessibilityAction2.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function0.invoke()).booleanValue();
            case 131072:
                int start = arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT, -1) : -1;
                int end = arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT, -1) : -1;
                boolean success = setAccessibilitySelection(node, start, end, false);
                if (success) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), 0, null, null, 12, null);
                }
                return success;
            default:
                if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node)) {
                    return false;
                }
                Object obj = null;
                switch (action) {
                    case 1:
                        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getRequestFocus());
                        if (accessibilityAction3 == null || (function1 = (Function0) accessibilityAction3.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function1.invoke()).booleanValue();
                    case 2:
                        if (!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
                            return false;
                        }
                        this.view.getFocusOwner().mo3729clearFocusI7lrPNg(false, true, true, FocusDirection.INSTANCE.m3721getExitdhqQ8s());
                        return true;
                    case 16:
                        AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
                        if (accessibilityAction4 != null && (function2 = (Function0) accessibilityAction4.getAction()) != null) {
                            obj = (Boolean) function2.invoke();
                        }
                        Boolean bool = obj;
                        sendEventForVirtualView$default(this, virtualViewId, 1, null, null, 12, null);
                        if (bool != 0) {
                            return bool.booleanValue();
                        }
                        return false;
                    case 32:
                        AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
                        if (accessibilityAction5 == null || (function3 = (Function0) accessibilityAction5.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function3.invoke()).booleanValue();
                    case 4096:
                    case 8192:
                    case android.R.id.accessibilityActionScrollUp:
                    case android.R.id.accessibilityActionScrollLeft:
                    case android.R.id.accessibilityActionScrollDown:
                    case android.R.id.accessibilityActionScrollRight:
                        boolean scrollForward = action == 4096;
                        boolean scrollBackward = action == 8192;
                        boolean scrollLeft = action == 16908345;
                        boolean scrollRight = action == 16908347;
                        boolean scrollUp = action == 16908344;
                        boolean scrollDown = action == 16908346;
                        boolean scrollHorizontal = scrollLeft || scrollRight || scrollForward || scrollBackward;
                        boolean scrollVertical = scrollUp || scrollDown || scrollForward || scrollBackward;
                        if (scrollForward || scrollBackward) {
                            ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                            AccessibilityAction setProgressAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress());
                            if (rangeInfo != null && setProgressAction != null) {
                                float max = RangesKt.coerceAtLeast(rangeInfo.getRange().getEndInclusive().floatValue(), rangeInfo.getRange().getStart().floatValue());
                                float min = RangesKt.coerceAtMost(rangeInfo.getRange().getStart().floatValue(), rangeInfo.getRange().getEndInclusive().floatValue());
                                float increment = rangeInfo.getSteps() > 0 ? (max - min) / (rangeInfo.getSteps() + 1) : (max - min) / 20;
                                if (scrollBackward) {
                                    increment = -increment;
                                }
                                Function1 function18 = (Function1) setProgressAction.getAction();
                                if (function18 != null) {
                                    return ((Boolean) function18.invoke(Float.valueOf(rangeInfo.getCurrent() + increment))).booleanValue();
                                }
                                return false;
                            }
                        }
                        long fallbackViewport = LayoutCoordinatesKt.boundsInParent(node.getLayoutInfo().getCoordinates()).m3834getSizeNHjbRc();
                        Float activeViewPortForScroll = SemanticsUtils_androidKt.getScrollViewportLength(node.getUnmergedConfig());
                        AccessibilityAction scrollAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
                        if (scrollAction == null) {
                            return false;
                        }
                        ScrollAxisRange xScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                        if (xScrollState != null && scrollHorizontal) {
                            float amountToScroll = activeViewPortForScroll != null ? activeViewPortForScroll.floatValue() : Size.m3870getWidthimpl(fallbackViewport);
                            float amountToScroll2 = (scrollLeft || scrollBackward) ? -amountToScroll : amountToScroll;
                            if (xScrollState.getReverseScrolling()) {
                                amountToScroll2 = -amountToScroll2;
                            }
                            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(node) && (scrollLeft || scrollRight)) {
                                amountToScroll2 = -amountToScroll2;
                            }
                            if (performActionHelper$canScroll(xScrollState, amountToScroll2)) {
                                Function2 function19 = (Function2) scrollAction.getAction();
                                if (function19 != null) {
                                    return ((Boolean) function19.invoke(Float.valueOf(amountToScroll2), Float.valueOf(0.0f))).booleanValue();
                                }
                                return false;
                            }
                        }
                        ScrollAxisRange yScrollState = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                        if (yScrollState == null || !scrollVertical) {
                            return false;
                        }
                        float amountToScroll3 = activeViewPortForScroll != null ? activeViewPortForScroll.floatValue() : Size.m3867getHeightimpl(fallbackViewport);
                        if (scrollUp || scrollBackward) {
                            amountToScroll3 = -amountToScroll3;
                        }
                        if (yScrollState.getReverseScrolling()) {
                            amountToScroll3 = -amountToScroll3;
                        }
                        if (performActionHelper$canScroll(yScrollState, amountToScroll3) && (function4 = (Function2) scrollAction.getAction()) != null) {
                            return ((Boolean) function4.invoke(Float.valueOf(0.0f), Float.valueOf(amountToScroll3))).booleanValue();
                        }
                        return false;
                    case 32768:
                        AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
                        if (accessibilityAction6 == null || (function5 = (Function0) accessibilityAction6.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function5.invoke()).booleanValue();
                    case 65536:
                        AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
                        if (accessibilityAction7 == null || (function6 = (Function0) accessibilityAction7.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function6.invoke()).booleanValue();
                    case 262144:
                        AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
                        if (accessibilityAction8 == null || (function7 = (Function0) accessibilityAction8.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function7.invoke()).booleanValue();
                    case 524288:
                        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
                        if (accessibilityAction9 == null || (function8 = (Function0) accessibilityAction9.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function8.invoke()).booleanValue();
                    case 1048576:
                        AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
                        if (accessibilityAction10 == null || (function9 = (Function0) accessibilityAction10.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function9.invoke()).booleanValue();
                    case 2097152:
                        Object string = arguments != null ? arguments.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE) : null;
                        AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
                        if (accessibilityAction11 == null || (function10 = (Function1) accessibilityAction11.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function10.invoke(new AnnotatedString(string == null ? "" : string, null, null, 6, null))).booleanValue();
                    case android.R.id.accessibilityActionShowOnScreen:
                        SemanticsNode scrollableAncestor = node.getParent();
                        AccessibilityAction scrollAction2 = (scrollableAncestor == null || (unmergedConfig2 = scrollableAncestor.getUnmergedConfig()) == null) ? null : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig2, SemanticsActions.INSTANCE.getScrollBy());
                        while (scrollableAncestor != null && scrollAction2 == null) {
                            scrollableAncestor = scrollableAncestor.getParent();
                            scrollAction2 = (scrollableAncestor == null || (unmergedConfig = scrollableAncestor.getUnmergedConfig()) == null) ? null : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getScrollBy());
                        }
                        if (scrollableAncestor == null) {
                            return false;
                        }
                        androidx.compose.ui.geometry.Rect viewportInParent = LayoutCoordinatesKt.boundsInParent(scrollableAncestor.getLayoutInfo().getCoordinates());
                        LayoutCoordinates parentLayoutCoordinates = scrollableAncestor.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
                        long parentInRoot = parentLayoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(parentLayoutCoordinates) : Offset.INSTANCE.m3817getZeroF1C5BW0();
                        androidx.compose.ui.geometry.Rect viewport = viewportInParent.m3838translatek4lQ0M(parentInRoot);
                        androidx.compose.ui.geometry.Rect target = RectKt.m3841Recttz77jQw(node.m5822getPositionInRootF1C5BW0(), IntSizeKt.m6739toSizeozmzZPI(node.m5825getSizeYbymL2g()));
                        ScrollAxisRange xScrollState2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(scrollableAncestor.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                        ScrollAxisRange yScrollState2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(scrollableAncestor.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                        float dx = performActionHelper$scrollDelta(target.getLeft() - viewport.getLeft(), target.getRight() - viewport.getRight());
                        if (xScrollState2 != null && xScrollState2.getReverseScrolling()) {
                            dx = -dx;
                        }
                        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(node)) {
                            dx = -dx;
                        }
                        float dy = performActionHelper$scrollDelta(target.getTop() - viewport.getTop(), target.getBottom() - viewport.getBottom());
                        if (yScrollState2 != null && yScrollState2.getReverseScrolling()) {
                            dy = -dy;
                        }
                        if (scrollAction2 == null || (function11 = (Function2) scrollAction2.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function11.invoke(Float.valueOf(dx), Float.valueOf(dy))).booleanValue();
                    case android.R.id.accessibilityActionSetProgress:
                        if (arguments == null || !arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) == null || (function12 = (Function1) accessibilityAction.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function12.invoke(Float.valueOf(arguments.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)))).booleanValue();
                    case android.R.id.accessibilityActionPageUp:
                        AccessibilityAction pageAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                        if (pageAction == null || (function13 = (Function0) pageAction.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function13.invoke()).booleanValue();
                    case android.R.id.accessibilityActionPageDown:
                        AccessibilityAction pageAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                        if (pageAction2 == null || (function14 = (Function0) pageAction2.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function14.invoke()).booleanValue();
                    case android.R.id.accessibilityActionPageLeft:
                        AccessibilityAction pageAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                        if (pageAction3 == null || (function15 = (Function0) pageAction3.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function15.invoke()).booleanValue();
                    case android.R.id.accessibilityActionPageRight:
                        AccessibilityAction pageAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                        if (pageAction4 == null || (function16 = (Function0) pageAction4.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function16.invoke()).booleanValue();
                    case android.R.id.accessibilityActionImeEnter:
                        AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnImeAction());
                        if (accessibilityAction12 == null || (function17 = (Function0) accessibilityAction12.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function17.invoke()).booleanValue();
                    default:
                        SparseArrayCompat<CharSequence> sparseArrayCompat = this.actionIdToLabel.get(virtualViewId);
                        if (sparseArrayCompat == null || (label = sparseArrayCompat.get(action)) == null || (customActions = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions())) == null) {
                            return false;
                        }
                        int size = customActions.size();
                        for (int index$iv = 0; index$iv < size; index$iv++) {
                            Object item$iv = customActions.get(index$iv);
                            CustomAccessibilityAction customAction = (CustomAccessibilityAction) item$iv;
                            if (Intrinsics.areEqual(customAction.getLabel(), label)) {
                                return customAction.getAction().invoke().booleanValue();
                            }
                        }
                        return false;
                }
        }
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange $this$performActionHelper_u24canScroll, float amount) {
        return (amount < 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() > 0.0f) || (amount > 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() < $this$performActionHelper_u24canScroll.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float a, float b) {
        if (Math.signum(a) == Math.signum(b)) {
            return Math.abs(a) < Math.abs(b) ? a : b;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
        SemanticsNode node;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String text = getIterableTextForAccessibility(node);
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalBeforeVal)) {
            Integer num = this.idToBeforeMap.get(virtualViewId);
            if (num != null) {
                int it = num.intValue();
                info.getExtras().putInt(extraDataKey, it);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalAfterVal)) {
            Integer num2 = this.idToAfterMap.get(virtualViewId);
            if (num2 != null) {
                int it2 = num2.intValue();
                info.getExtras().putInt(extraDataKey, it2);
                return;
            }
            return;
        }
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int positionInfoStartIndex = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int positionInfoLength = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (positionInfoLength > 0 && positionInfoStartIndex >= 0) {
                if (positionInfoStartIndex < (text != null ? text.length() : Integer.MAX_VALUE)) {
                    TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(node.getUnmergedConfig());
                    if (textLayoutResult == null) {
                        return;
                    }
                    List boundingRects = new ArrayList();
                    for (int i = 0; i < positionInfoLength; i++) {
                        if (positionInfoStartIndex + i >= textLayoutResult.getLayoutInput().getText().length()) {
                            boundingRects.add(null);
                        } else {
                            androidx.compose.ui.geometry.Rect bounds = textLayoutResult.getBoundingBox(positionInfoStartIndex + i);
                            RectF boundsOnScreen = toScreenCoords(node, bounds);
                            boundingRects.add(boundsOnScreen);
                        }
                    }
                    List $this$toTypedArray$iv = boundingRects;
                    info.getExtras().putParcelableArray(extraDataKey, (Parcelable[]) $this$toTypedArray$iv.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
            return;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, ExtraDataTestTagKey)) {
            String testTag = (String) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
            if (testTag != null) {
                info.getExtras().putCharSequence(extraDataKey, testTag);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataIdKey)) {
            info.getExtras().putInt(extraDataKey, node.getId());
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, androidx.compose.ui.geometry.Rect bounds) {
        androidx.compose.ui.geometry.Rect visibleBounds;
        if (textNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect boundsInRoot = bounds.m3838translatek4lQ0M(textNode.m5822getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect textNodeBoundsInRoot = textNode.getBoundsInRoot();
        if (boundsInRoot.overlaps(textNodeBoundsInRoot)) {
            visibleBounds = boundsInRoot.intersect(textNodeBoundsInRoot);
        } else {
            visibleBounds = null;
        }
        if (visibleBounds == null) {
            return null;
        }
        long topLeftInScreen = this.view.mo5345localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getLeft(), visibleBounds.getTop()));
        long bottomRightInScreen = this.view.mo5345localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getRight(), visibleBounds.getBottom()));
        return new RectF(Offset.m3801getXimpl(topLeftInScreen), Offset.m3802getYimpl(topLeftInScreen), Offset.m3801getXimpl(bottomRightInScreen), Offset.m3802getYimpl(bottomRightInScreen));
    }

    public final boolean dispatchHoverEvent$ui_release(MotionEvent event) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 7:
            case 9:
                int virtualViewId = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
                boolean handled = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                updateHoveredVirtualView(virtualViewId);
                if (virtualViewId == Integer.MIN_VALUE) {
                    return handled;
                }
                return true;
            case 8:
            default:
                return false;
            case 10:
                if (this.hoveredVirtualViewId != Integer.MIN_VALUE) {
                    updateHoveredVirtualView(Integer.MIN_VALUE);
                    return true;
                }
                return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
        }
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        NodeChain nodes;
        Owner.CC.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitSemanticsEntities = new HitTestResult();
        LayoutNode.m5544hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(x, y), hitSemanticsEntities, false, false, 12, null);
        Modifier.Node node = (Modifier.Node) CollectionsKt.lastOrNull((List) hitSemanticsEntities);
        LayoutNode layoutNode = node != null ? DelegatableNodeKt.requireLayoutNode(node) : null;
        if (!((layoutNode == null || (nodes = layoutNode.getNodes()) == null || !nodes.m5591hasH91voCI$ui_release(NodeKind.m5628constructorimpl(8))) ? false : true)) {
            return Integer.MIN_VALUE;
        }
        SemanticsNode semanticsNode = SemanticsNodeKt.SemanticsNode(layoutNode, false);
        if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode)) {
            return Integer.MIN_VALUE;
        }
        AndroidViewHolder androidView = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode);
        if (androidView != null) {
            return Integer.MIN_VALUE;
        }
        int virtualViewId = semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
        return virtualViewId;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        if (this.hoveredVirtualViewId == virtualViewId) {
            return;
        }
        int previousVirtualViewId = this.hoveredVirtualViewId;
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, previousVirtualViewId, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        boolean z = true;
        if (!(size > 0)) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        int i = size;
        if (text != null && text.length() != 0) {
            z = false;
        }
        if (z || text.length() <= size) {
            return text;
        }
        if (Character.isHighSurrogate(text.charAt(size - 1)) && Character.isLowSurrogate(text.charAt(size))) {
            i = size - 1;
        }
        T t = (T) text.subSequence(0, i);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$50(AndroidComposeViewAccessibilityDelegateCompat this$0) {
        Owner.CC.measureAndLayout$default(this$0.view, false, 1, null);
        this$0.checkForSemanticsChanges();
        this$0.checkingForSemanticsChanges = false;
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0077 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0078  */
    /* JADX WARN: Code duplicated, block: B:26:0x0086 A[Catch: all -> 0x00eb, TryCatch #1 {all -> 0x00eb, blocks: (B:24:0x007e, B:26:0x0086, B:28:0x008f, B:30:0x0098, B:31:0x00ac, B:33:0x00b3, B:34:0x00bc), top: B:48:0x007e }] */
    /* JADX WARN: Code duplicated, block: B:28:0x008f A[Catch: all -> 0x00eb, TryCatch #1 {all -> 0x00eb, blocks: (B:24:0x007e, B:26:0x0086, B:28:0x008f, B:30:0x0098, B:31:0x00ac, B:33:0x00b3, B:34:0x00bc), top: B:48:0x007e }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0098 A[Catch: all -> 0x00eb, LOOP:0: B:29:0x0096->B:30:0x0098, LOOP_END, TryCatch #1 {all -> 0x00eb, blocks: (B:24:0x007e, B:26:0x0086, B:28:0x008f, B:30:0x0098, B:31:0x00ac, B:33:0x00b3, B:34:0x00bc), top: B:48:0x007e }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b3 A[Catch: all -> 0x00eb, TryCatch #1 {all -> 0x00eb, blocks: (B:24:0x007e, B:26:0x0086, B:28:0x008f, B:30:0x0098, B:31:0x00ac, B:33:0x00b3, B:34:0x00bc), top: B:48:0x007e }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00dd -> B:20:0x0069). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release()) {
            return;
        }
        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo9059trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (!layoutNode.isAttached() || this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            return;
        }
        int id = layoutNode.getSemanticsId();
        ScrollAxisRange pendingHorizontalScroll = this.pendingHorizontalScrollEvents.get(id);
        ScrollAxisRange pendingVerticalScroll = this.pendingVerticalScrollEvents.get(id);
        if (pendingHorizontalScroll == null && pendingVerticalScroll == null) {
            return;
        }
        AccessibilityEvent event = createEvent(id, 4096);
        if (pendingHorizontalScroll != null) {
            event.setScrollX((int) pendingHorizontalScroll.getValue().invoke().floatValue());
            event.setMaxScrollX((int) pendingHorizontalScroll.getMaxValue().invoke().floatValue());
        }
        if (pendingVerticalScroll != null) {
            event.setScrollY((int) pendingVerticalScroll.getValue().invoke().floatValue());
            event.setMaxScrollY((int) pendingVerticalScroll.getMaxValue().invoke().floatValue());
        }
        sendEvent(event);
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet subtreeChangedSemanticsNodesIds) {
        SemanticsConfiguration config;
        LayoutNode it;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int size = this.subtreeChangedLayoutNodes.size();
            for (int potentialAncestor = 0; potentialAncestor < size; potentialAncestor++) {
                if (SemanticsUtils_androidKt.isAncestorOf(this.subtreeChangedLayoutNodes.valueAt(potentialAncestor), layoutNode)) {
                    return;
                }
            }
            LayoutNode layoutNodeFindClosestParentNode = layoutNode.getNodes().m5591hasH91voCI$ui_release(NodeKind.m5628constructorimpl(8)) ? layoutNode : AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode it2) {
                    return Boolean.valueOf(it2.getNodes().m5591hasH91voCI$ui_release(NodeKind.m5628constructorimpl(8)));
                }
            });
            if (layoutNodeFindClosestParentNode == null || (config = layoutNodeFindClosestParentNode.getCollapsedSemantics$ui_release()) == null) {
                return;
            }
            if (!config.getIsMergingSemanticsOfDescendants() && (it = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNodeFindClosestParentNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode it2) {
                    SemanticsConfiguration collapsedSemantics$ui_release = it2.getCollapsedSemantics$ui_release();
                    boolean z = false;
                    if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsMergingSemanticsOfDescendants()) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            })) != null) {
                layoutNodeFindClosestParentNode = it;
            }
            if (layoutNodeFindClosestParentNode != null) {
                int id = layoutNodeFindClosestParentNode.getSemanticsId();
                if (subtreeChangedSemanticsNodesIds.add(id)) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 1, null, 8, null);
                }
            }
        }
    }

    private final void checkForSemanticsChanges() {
        if (isEnabled$ui_release()) {
            sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        }
        sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        int $i$f$forEach;
        int[] k$iv;
        Object[] v$iv;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap;
        IntSet this_$iv;
        IntSet this_$iv2;
        SemanticsConfiguration unmergedConfig;
        MutableIntSet toRemove = new MutableIntSet(0, 1, null);
        IntSet this_$iv3 = this.paneDisplayed;
        int[] k$iv2 = this_$iv3.elements;
        long[] m$iv$iv = this_$iv3.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        long j = 255;
        int i = 8;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    this_$iv = this_$iv3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv & j;
                        if (!(value$iv$iv$iv < 128)) {
                            this_$iv2 = this_$iv3;
                        } else {
                            int id = k$iv2[(i$iv$iv << 3) + j$iv$iv];
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(id);
                            SemanticsNode currentNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (currentNode != null) {
                                this_$iv2 = this_$iv3;
                                if (!currentNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                }
                            } else {
                                this_$iv2 = this_$iv3;
                            }
                            toRemove.add(id);
                            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(id);
                            sendPaneChangeEvents(id, 32, (semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null) ? null : (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle()));
                        }
                        i = 8;
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        this_$iv3 = this_$iv2;
                        j = 255;
                    }
                    this_$iv = this_$iv3;
                    if (bitCount$iv$iv != i) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv3 = this_$iv;
                i = 8;
                j = 255;
            }
        }
        this.paneDisplayed.removeAll(toRemove);
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = getCurrentSemanticsNodes();
        int $i$f$forEach2 = 0;
        int[] k$iv3 = currentSemanticsNodes.keys;
        Object[] v$iv2 = currentSemanticsNodes.values;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2 = currentSemanticsNodes;
        long[] m$iv$iv2 = intObjectMap2.metadata;
        int lastIndex$iv$iv2 = m$iv$iv2.length - 2;
        int i$iv$iv2 = 0;
        if (0 <= lastIndex$iv$iv2) {
            while (true) {
                long slot$iv$iv2 = m$iv$iv2[i$iv$iv2];
                MutableIntSet toRemove2 = toRemove;
                IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap3 = currentSemanticsNodes;
                if ((((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L)) == -9187201950435737472L) {
                    $i$f$forEach = $i$f$forEach2;
                    k$iv = k$iv3;
                    v$iv = v$iv2;
                    intObjectMap = intObjectMap2;
                } else {
                    int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                    int j$iv$iv2 = 0;
                    while (j$iv$iv2 < bitCount$iv$iv2) {
                        long value$iv$iv$iv2 = slot$iv$iv2 & 255;
                        int $i$f$isFull = value$iv$iv$iv2 < 128 ? 1 : 0;
                        if ($i$f$isFull != 0) {
                            int index$iv$iv = (i$iv$iv2 << 3) + j$iv$iv2;
                            int key = k$iv3[index$iv$iv];
                            SemanticsNodeWithAdjustedBounds value = (SemanticsNodeWithAdjustedBounds) v$iv2[index$iv$iv];
                            if (value.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle()) && this.paneDisplayed.add(key)) {
                                sendPaneChangeEvents(key, 16, (String) value.getSemanticsNode().getUnmergedConfig().get(SemanticsProperties.INSTANCE.getPaneTitle()));
                            }
                            this.previousSemanticsNodes.set(key, new SemanticsNodeCopy(value.getSemanticsNode(), getCurrentSemanticsNodes()));
                        }
                        slot$iv$iv2 >>= 8;
                        j$iv$iv2++;
                        v$iv2 = v$iv2;
                        $i$f$forEach2 = $i$f$forEach2;
                        k$iv3 = k$iv3;
                        intObjectMap2 = intObjectMap2;
                    }
                    $i$f$forEach = $i$f$forEach2;
                    k$iv = k$iv3;
                    v$iv = v$iv2;
                    intObjectMap = intObjectMap2;
                    if (bitCount$iv$iv2 != 8) {
                        break;
                    }
                }
                if (i$iv$iv2 == lastIndex$iv$iv2) {
                    break;
                }
                i$iv$iv2++;
                toRemove = toRemove2;
                currentSemanticsNodes = intObjectMap3;
                v$iv2 = v$iv;
                $i$f$forEach2 = $i$f$forEach;
                k$iv3 = k$iv;
                intObjectMap2 = intObjectMap;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    private final void sendSemanticsPropertyChangeEvents(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        int i$iv$iv;
        ArrayList oldScrollObservationScopes;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap;
        int $i$f$forEachKey;
        int[] k$iv;
        int lastIndex$iv$iv;
        int j$iv$iv;
        int bitCount$iv$iv;
        int i$iv$iv2;
        ArrayList oldScrollObservationScopes2;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap2;
        int $i$f$forEachKey2;
        int[] k$iv2;
        int lastIndex$iv$iv2;
        int j$iv$iv2;
        int bitCount$iv$iv2;
        int i$iv$iv3;
        ArrayList oldScrollObservationScopes3;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap3;
        int $i$f$forEachKey3;
        int[] k$iv3;
        int id;
        int lastIndex$iv$iv3;
        int endCount;
        AccessibilityEvent $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459;
        String text;
        boolean z;
        ArrayList oldScrollObservationScopes4 = new ArrayList(this.scrollObservationScopes);
        this.scrollObservationScopes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap4 = newSemanticsNodes;
        int $i$f$forEachKey4 = 0;
        int[] k$iv4 = intObjectMap4.keys;
        long[] m$iv$iv = intObjectMap4.metadata;
        int lastIndex$iv$iv4 = m$iv$iv.length - 2;
        if (0 > lastIndex$iv$iv4) {
            return;
        }
        int i$iv$iv4 = 0;
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv4];
            long slot$iv$iv2 = slot$iv$iv;
            if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                int bitCount$iv$iv3 = 8 - ((~(i$iv$iv4 - lastIndex$iv$iv4)) >>> 31);
                int j$iv$iv3 = 0;
                while (j$iv$iv3 < bitCount$iv$iv3) {
                    long value$iv$iv$iv = slot$iv$iv2 & 255;
                    if (value$iv$iv$iv < 128) {
                        int index$iv$iv = (i$iv$iv4 << 3) + j$iv$iv3;
                        int id2 = k$iv4[index$iv$iv];
                        SemanticsNodeCopy oldNode = this.previousSemanticsNodes.get(id2);
                        if (oldNode == null) {
                            j$iv$iv = j$iv$iv3;
                            bitCount$iv$iv = bitCount$iv$iv3;
                            i$iv$iv2 = i$iv$iv4;
                            oldScrollObservationScopes2 = oldScrollObservationScopes4;
                            intObjectMap2 = intObjectMap4;
                            $i$f$forEachKey2 = $i$f$forEachKey4;
                            k$iv2 = k$iv4;
                            lastIndex$iv$iv2 = lastIndex$iv$iv4;
                        } else {
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = newSemanticsNodes.get(id2);
                            SemanticsNode newNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (newNode == null) {
                                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                                throw new KotlinNothingValueException();
                            }
                            boolean propertyChanged = false;
                            for (Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry : newNode.getUnmergedConfig()) {
                                boolean newlyObservingScroll = (Intrinsics.areEqual(entry.getKey(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(entry.getKey(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) ? registerScrollingId(id2, oldScrollObservationScopes4) : false;
                                if (newlyObservingScroll || !Intrinsics.areEqual(entry.getValue(), SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), entry.getKey()))) {
                                    SemanticsPropertyKey<?> key = entry.getKey();
                                    if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getPaneTitle())) {
                                        Object value = entry.getValue();
                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                                        String paneTitle = (String) value;
                                        if (oldNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                            sendPaneChangeEvents(id2, 8, paneTitle);
                                            j$iv$iv2 = j$iv$iv3;
                                            bitCount$iv$iv2 = bitCount$iv$iv3;
                                            i$iv$iv3 = i$iv$iv4;
                                            oldScrollObservationScopes3 = oldScrollObservationScopes4;
                                            intObjectMap3 = intObjectMap4;
                                            $i$f$forEachKey3 = $i$f$forEachKey4;
                                            k$iv3 = k$iv4;
                                            id = id2;
                                            lastIndex$iv$iv3 = lastIndex$iv$iv4;
                                        } else {
                                            j$iv$iv2 = j$iv$iv3;
                                            bitCount$iv$iv2 = bitCount$iv$iv3;
                                            i$iv$iv3 = i$iv$iv4;
                                            oldScrollObservationScopes3 = oldScrollObservationScopes4;
                                            intObjectMap3 = intObjectMap4;
                                            $i$f$forEachKey3 = $i$f$forEachKey4;
                                            k$iv3 = k$iv4;
                                            id = id2;
                                            lastIndex$iv$iv3 = lastIndex$iv$iv4;
                                        }
                                    } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getStateDescription()) ? true : Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getToggleableState())) {
                                        int j$iv$iv4 = semanticsNodeIdToAccessibilityVirtualNodeId(id2);
                                        int id3 = id2;
                                        j$iv$iv2 = j$iv$iv3;
                                        bitCount$iv$iv2 = bitCount$iv$iv3;
                                        i$iv$iv3 = i$iv$iv4;
                                        oldScrollObservationScopes3 = oldScrollObservationScopes4;
                                        lastIndex$iv$iv3 = lastIndex$iv$iv4;
                                        sendEventForVirtualView$default(this, j$iv$iv4, 2048, 64, null, 8, null);
                                        intObjectMap3 = intObjectMap4;
                                        id = id3;
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id3), 2048, 0, null, 8, null);
                                        $i$f$forEachKey3 = $i$f$forEachKey4;
                                        k$iv3 = k$iv4;
                                    } else {
                                        j$iv$iv2 = j$iv$iv3;
                                        bitCount$iv$iv2 = bitCount$iv$iv3;
                                        i$iv$iv3 = i$iv$iv4;
                                        oldScrollObservationScopes3 = oldScrollObservationScopes4;
                                        intObjectMap3 = intObjectMap4;
                                        id = id2;
                                        lastIndex$iv$iv3 = lastIndex$iv$iv4;
                                        if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, null, 8, null);
                                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                                            $i$f$forEachKey3 = $i$f$forEachKey4;
                                            k$iv3 = k$iv4;
                                        } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getSelected())) {
                                            Role role = (Role) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
                                            if (!(role == null ? false : Role.m5810equalsimpl0(role.getValue(), Role.INSTANCE.m5820getTabo7Vup1c()))) {
                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 64, null, 8, null);
                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                                                $i$f$forEachKey3 = $i$f$forEachKey4;
                                                k$iv3 = k$iv4;
                                            } else if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true)) {
                                                AccessibilityEvent event = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), 4);
                                                SemanticsNode mergedNode = newNode.copyWithMergingEnabled$ui_release();
                                                List list = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                                String contentDescription = list != null ? ListUtilsKt.fastJoinToString$default(list, ",", null, null, 0, null, null, 62, null) : null;
                                                List list2 = (List) SemanticsConfigurationKt.getOrNull(mergedNode.getConfig(), SemanticsProperties.INSTANCE.getText());
                                                String text2 = list2 != null ? ListUtilsKt.fastJoinToString$default(list2, ",", null, null, 0, null, null, 62, null) : null;
                                                if (contentDescription != null) {
                                                    String it = contentDescription;
                                                    event.setContentDescription(it);
                                                    Unit unit = Unit.INSTANCE;
                                                    Unit unit2 = Unit.INSTANCE;
                                                }
                                                if (text2 != null) {
                                                    String it2 = text2;
                                                    Boolean.valueOf(event.getText().add(it2));
                                                }
                                                sendEvent(event);
                                                $i$f$forEachKey3 = $i$f$forEachKey4;
                                                k$iv3 = k$iv4;
                                            } else {
                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 0, null, 8, null);
                                                $i$f$forEachKey3 = $i$f$forEachKey4;
                                                k$iv3 = k$iv4;
                                            }
                                        } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getContentDescription())) {
                                            int iSemanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(id);
                                            Object value2 = entry.getValue();
                                            Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                            sendEventForVirtualView(iSemanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) value2);
                                            $i$f$forEachKey3 = $i$f$forEachKey4;
                                            k$iv3 = k$iv4;
                                        } else {
                                            String str = "";
                                            if (!Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getEditableText())) {
                                                $i$f$forEachKey3 = $i$f$forEachKey4;
                                                k$iv3 = k$iv4;
                                                if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                                    AnnotatedString textForTextField = getTextForTextField(newNode.getUnmergedConfig());
                                                    if (textForTextField != null && (text = textForTextField.getText()) != null) {
                                                        str = text;
                                                    }
                                                    String newText = str;
                                                    long textRange = ((TextRange) newNode.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                                                    sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), Integer.valueOf(TextRange.m6003getStartimpl(textRange)), Integer.valueOf(TextRange.m5998getEndimpl(textRange)), Integer.valueOf(newText.length()), trimToSize(newText, 100000)));
                                                    sendPendingTextTraversedAtGranularityEvent(newNode.getId());
                                                } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) ? true : Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                                                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                                                    ScrollObservationScope scope = SemanticsUtils_androidKt.findById(this.scrollObservationScopes, id);
                                                    Intrinsics.checkNotNull(scope);
                                                    scope.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                                    scope.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(newNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                                    scheduleScrollEventIfNeeded(scope);
                                                } else if (Intrinsics.areEqual(key, SemanticsProperties.INSTANCE.getFocused())) {
                                                    Object value3 = entry.getValue();
                                                    Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Boolean");
                                                    if (((Boolean) value3).booleanValue()) {
                                                        sendEvent(createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 8));
                                                    }
                                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(newNode.getId()), 2048, 0, null, 8, null);
                                                } else if (Intrinsics.areEqual(key, SemanticsActions.INSTANCE.getCustomActions())) {
                                                    List actions = (List) newNode.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                                                    List oldActions = (List) SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                                    if (oldActions != null) {
                                                        Set labels = new LinkedHashSet();
                                                        int size = actions.size();
                                                        for (int index$iv = 0; index$iv < size; index$iv++) {
                                                            Object item$iv = actions.get(index$iv);
                                                            CustomAccessibilityAction action = (CustomAccessibilityAction) item$iv;
                                                            labels.add(action.getLabel());
                                                        }
                                                        Set oldLabels = new LinkedHashSet();
                                                        int size2 = oldActions.size();
                                                        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                                                            Object item$iv2 = oldActions.get(index$iv2);
                                                            CustomAccessibilityAction action2 = (CustomAccessibilityAction) item$iv2;
                                                            oldLabels.add(action2.getLabel());
                                                        }
                                                        propertyChanged = (labels.containsAll(oldLabels) && oldLabels.containsAll(labels)) ? false : true;
                                                        lastIndex$iv$iv4 = lastIndex$iv$iv3;
                                                        id2 = id;
                                                        j$iv$iv3 = j$iv$iv2;
                                                        $i$f$forEachKey4 = $i$f$forEachKey3;
                                                        oldScrollObservationScopes4 = oldScrollObservationScopes3;
                                                        intObjectMap4 = intObjectMap3;
                                                        k$iv4 = k$iv3;
                                                        bitCount$iv$iv3 = bitCount$iv$iv2;
                                                        i$iv$iv4 = i$iv$iv3;
                                                    } else if (!actions.isEmpty()) {
                                                        propertyChanged = true;
                                                        lastIndex$iv$iv4 = lastIndex$iv$iv3;
                                                        id2 = id;
                                                        j$iv$iv3 = j$iv$iv2;
                                                        $i$f$forEachKey4 = $i$f$forEachKey3;
                                                        oldScrollObservationScopes4 = oldScrollObservationScopes3;
                                                        intObjectMap4 = intObjectMap3;
                                                        k$iv4 = k$iv3;
                                                        bitCount$iv$iv3 = bitCount$iv$iv2;
                                                        i$iv$iv4 = i$iv$iv3;
                                                    }
                                                } else {
                                                    if (entry.getValue() instanceof AccessibilityAction) {
                                                        Object value4 = entry.getValue();
                                                        Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                                                        z = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) value4, SemanticsConfigurationKt.getOrNull(oldNode.getUnmergedConfig(), entry.getKey()));
                                                    } else {
                                                        z = true;
                                                    }
                                                    propertyChanged = z;
                                                    lastIndex$iv$iv4 = lastIndex$iv$iv3;
                                                    id2 = id;
                                                    j$iv$iv3 = j$iv$iv2;
                                                    $i$f$forEachKey4 = $i$f$forEachKey3;
                                                    oldScrollObservationScopes4 = oldScrollObservationScopes3;
                                                    intObjectMap4 = intObjectMap3;
                                                    k$iv4 = k$iv3;
                                                    bitCount$iv$iv3 = bitCount$iv$iv2;
                                                    i$iv$iv4 = i$iv$iv3;
                                                }
                                            } else if (newNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText())) {
                                                AnnotatedString textForTextField2 = getTextForTextField(oldNode.getUnmergedConfig());
                                                CharSequence oldText = textForTextField2 != null ? textForTextField2 : "";
                                                AnnotatedString textForTextField3 = getTextForTextField(newNode.getUnmergedConfig());
                                                CharSequence newText2 = textForTextField3 != null ? textForTextField3 : "";
                                                CharSequence trimmedNewText = trimToSize(newText2, 100000);
                                                int startCount = 0;
                                                int endCount2 = 0;
                                                int oldTextLen = oldText.length();
                                                int newTextLen = newText2.length();
                                                $i$f$forEachKey3 = $i$f$forEachKey4;
                                                int minLength = RangesKt.coerceAtMost(oldTextLen, newTextLen);
                                                while (true) {
                                                    if (startCount >= minLength) {
                                                        endCount = endCount2;
                                                        k$iv3 = k$iv4;
                                                        break;
                                                    }
                                                    endCount = endCount2;
                                                    int endCount3 = oldText.charAt(startCount);
                                                    k$iv3 = k$iv4;
                                                    if (endCount3 != newText2.charAt(startCount)) {
                                                        break;
                                                    }
                                                    startCount++;
                                                    endCount2 = endCount;
                                                    k$iv4 = k$iv3;
                                                }
                                                int endCount4 = endCount;
                                                while (endCount4 < minLength - startCount) {
                                                    int minLength2 = minLength;
                                                    if (oldText.charAt((oldTextLen - 1) - endCount4) != newText2.charAt((newTextLen - 1) - endCount4)) {
                                                        break;
                                                    }
                                                    endCount4++;
                                                    minLength = minLength2;
                                                }
                                                int removedCount = (oldTextLen - endCount4) - startCount;
                                                int addedCount = (newTextLen - endCount4) - startCount;
                                                boolean oldNodeIsPassword = oldNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                boolean newNodeIsPassword = newNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                boolean oldNodeIsTextfield = oldNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText());
                                                boolean becamePasswordNode = oldNodeIsTextfield && !oldNodeIsPassword && newNodeIsPassword;
                                                boolean becameNotPasswordNode = oldNodeIsTextfield && oldNodeIsPassword && !newNodeIsPassword;
                                                if (becamePasswordNode || becameNotPasswordNode) {
                                                    $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459 = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), 0, 0, Integer.valueOf(newTextLen), trimmedNewText);
                                                } else {
                                                    $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459 = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(id), 16);
                                                    $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459.setFromIndex(startCount);
                                                    $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459.setRemovedCount(removedCount);
                                                    $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459.setAddedCount(addedCount);
                                                    $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459.setBeforeText(oldText);
                                                    $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459.getText().add(trimmedNewText);
                                                }
                                                AccessibilityEvent event2 = $this$sendSemanticsPropertyChangeEvents_u24lambda_u2462_u24lambda_u2459;
                                                event2.setClassName(TextFieldClassName);
                                                sendEvent(event2);
                                                if (becamePasswordNode || becameNotPasswordNode) {
                                                    long textRange2 = ((TextRange) newNode.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                                                    event2.setFromIndex(TextRange.m6003getStartimpl(textRange2));
                                                    event2.setToIndex(TextRange.m5998getEndimpl(textRange2));
                                                    sendEvent(event2);
                                                }
                                            } else {
                                                $i$f$forEachKey3 = $i$f$forEachKey4;
                                                k$iv3 = k$iv4;
                                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 2, null, 8, null);
                                            }
                                        }
                                    }
                                } else {
                                    j$iv$iv2 = j$iv$iv3;
                                    bitCount$iv$iv2 = bitCount$iv$iv3;
                                    i$iv$iv3 = i$iv$iv4;
                                    oldScrollObservationScopes3 = oldScrollObservationScopes4;
                                    intObjectMap3 = intObjectMap4;
                                    $i$f$forEachKey3 = $i$f$forEachKey4;
                                    k$iv3 = k$iv4;
                                    id = id2;
                                    lastIndex$iv$iv3 = lastIndex$iv$iv4;
                                }
                                lastIndex$iv$iv4 = lastIndex$iv$iv3;
                                id2 = id;
                                j$iv$iv3 = j$iv$iv2;
                                $i$f$forEachKey4 = $i$f$forEachKey3;
                                oldScrollObservationScopes4 = oldScrollObservationScopes3;
                                intObjectMap4 = intObjectMap3;
                                k$iv4 = k$iv3;
                                bitCount$iv$iv3 = bitCount$iv$iv2;
                                i$iv$iv4 = i$iv$iv3;
                            }
                            j$iv$iv = j$iv$iv3;
                            bitCount$iv$iv = bitCount$iv$iv3;
                            i$iv$iv2 = i$iv$iv4;
                            oldScrollObservationScopes2 = oldScrollObservationScopes4;
                            intObjectMap2 = intObjectMap4;
                            $i$f$forEachKey2 = $i$f$forEachKey4;
                            k$iv2 = k$iv4;
                            int id4 = id2;
                            lastIndex$iv$iv2 = lastIndex$iv$iv4;
                            if (!propertyChanged) {
                                propertyChanged = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(newNode, oldNode.getUnmergedConfig());
                            }
                            if (propertyChanged) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id4), 2048, 0, null, 8, null);
                            }
                        }
                    } else {
                        j$iv$iv = j$iv$iv3;
                        bitCount$iv$iv = bitCount$iv$iv3;
                        i$iv$iv2 = i$iv$iv4;
                        oldScrollObservationScopes2 = oldScrollObservationScopes4;
                        intObjectMap2 = intObjectMap4;
                        $i$f$forEachKey2 = $i$f$forEachKey4;
                        k$iv2 = k$iv4;
                        lastIndex$iv$iv2 = lastIndex$iv$iv4;
                    }
                    slot$iv$iv2 >>= 8;
                    j$iv$iv3 = j$iv$iv + 1;
                    lastIndex$iv$iv4 = lastIndex$iv$iv2;
                    $i$f$forEachKey4 = $i$f$forEachKey2;
                    oldScrollObservationScopes4 = oldScrollObservationScopes2;
                    intObjectMap4 = intObjectMap2;
                    k$iv4 = k$iv2;
                    bitCount$iv$iv3 = bitCount$iv$iv;
                    i$iv$iv4 = i$iv$iv2;
                }
                i$iv$iv = i$iv$iv4;
                oldScrollObservationScopes = oldScrollObservationScopes4;
                intObjectMap = intObjectMap4;
                $i$f$forEachKey = $i$f$forEachKey4;
                k$iv = k$iv4;
                lastIndex$iv$iv = lastIndex$iv$iv4;
                if (bitCount$iv$iv3 != 8) {
                    return;
                }
            } else {
                i$iv$iv = i$iv$iv4;
                oldScrollObservationScopes = oldScrollObservationScopes4;
                intObjectMap = intObjectMap4;
                $i$f$forEachKey = $i$f$forEachKey4;
                k$iv = k$iv4;
                lastIndex$iv$iv = lastIndex$iv$iv4;
            }
            int i$iv$iv5 = i$iv$iv;
            if (i$iv$iv5 == lastIndex$iv$iv) {
                return;
            }
            i$iv$iv4 = i$iv$iv5 + 1;
            lastIndex$iv$iv4 = lastIndex$iv$iv;
            $i$f$forEachKey4 = $i$f$forEachKey;
            oldScrollObservationScopes4 = oldScrollObservationScopes;
            intObjectMap4 = intObjectMap;
            k$iv4 = k$iv;
        }
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        ScrollObservationScope scrollObservationScope;
        boolean newlyObservingScroll = false;
        ScrollObservationScope oldScope = SemanticsUtils_androidKt.findById(oldScrollObservationScopes, id);
        if (oldScope != null) {
            scrollObservationScope = oldScope;
        } else {
            newlyObservingScroll = true;
            scrollObservationScope = new ScrollObservationScope(id, this.scrollObservationScopes, null, null, null, null);
        }
        ScrollObservationScope newScope = scrollObservationScope;
        this.scrollObservationScopes.add(newScope);
        return newlyObservingScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (!scrollObservationScope.isValidOwnerScope()) {
            return;
        }
        this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:22:0x0060  */
            /* JADX WARN: Code duplicated, block: B:24:0x0080  */
            /* JADX WARN: Code duplicated, block: B:27:0x008a A[Catch: IllegalStateException -> 0x0094, TRY_LEAVE, TryCatch #0 {IllegalStateException -> 0x0094, blocks: (B:25:0x0084, B:27:0x008a), top: B:50:0x0084 }] */
            /* JADX WARN: Code duplicated, block: B:40:0x00c1  */
            /* JADX WARN: Code duplicated, block: B:42:0x00ca  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                float deltaX;
                float deltaY;
                int scrollerId;
                SemanticsNodeWithAdjustedBounds it;
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
                SemanticsNode semanticsNode;
                LayoutNode layoutNode;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2;
                AccessibilityNodeInfo accessibilityNodeInfo;
                ScrollAxisRange newXState = scrollObservationScope.getHorizontalScrollAxisRange();
                ScrollAxisRange newYState = scrollObservationScope.getVerticalScrollAxisRange();
                Float oldXValue = scrollObservationScope.getOldXValue();
                Float oldYValue = scrollObservationScope.getOldYValue();
                if (newXState != null && oldXValue != null) {
                    deltaX = newXState.getValue().invoke().floatValue() - oldXValue.floatValue();
                } else {
                    deltaX = 0.0f;
                }
                if (newYState != null && oldYValue != null) {
                    deltaY = newYState.getValue().invoke().floatValue() - oldYValue.floatValue();
                } else {
                    deltaY = 0.0f;
                }
                if (!(deltaX == 0.0f)) {
                    scrollerId = this.semanticsNodeIdToAccessibilityVirtualNodeId(scrollObservationScope.getSemanticsNodeId());
                    it = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(this.focusedVirtualViewId);
                    if (it != null) {
                        androidComposeViewAccessibilityDelegateCompat2 = this;
                        try {
                            accessibilityNodeInfo = androidComposeViewAccessibilityDelegateCompat2.currentlyFocusedANI;
                            if (accessibilityNodeInfo != null) {
                                accessibilityNodeInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(it));
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException e) {
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                    this.getView().invalidate();
                    semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(scrollerId);
                    if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null && (layoutNode = semanticsNode.getLayoutNode()) != null) {
                        androidComposeViewAccessibilityDelegateCompat = this;
                        if (newXState != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingHorizontalScrollEvents.set(scrollerId, newXState);
                        }
                        if (newYState != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingVerticalScrollEvents.set(scrollerId, newYState);
                        }
                        androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                    }
                } else {
                    if (!(deltaY == 0.0f)) {
                        scrollerId = this.semanticsNodeIdToAccessibilityVirtualNodeId(scrollObservationScope.getSemanticsNodeId());
                        it = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(this.focusedVirtualViewId);
                        if (it != null) {
                            androidComposeViewAccessibilityDelegateCompat2 = this;
                            accessibilityNodeInfo = androidComposeViewAccessibilityDelegateCompat2.currentlyFocusedANI;
                            if (accessibilityNodeInfo != null) {
                                accessibilityNodeInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(it));
                                Unit unit3 = Unit.INSTANCE;
                            }
                        }
                        this.getView().invalidate();
                        semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(scrollerId);
                        if (semanticsNodeWithAdjustedBounds != null) {
                            androidComposeViewAccessibilityDelegateCompat = this;
                            if (newXState != null) {
                                androidComposeViewAccessibilityDelegateCompat.pendingHorizontalScrollEvents.set(scrollerId, newXState);
                            }
                            if (newYState != null) {
                                androidComposeViewAccessibilityDelegateCompat.pendingVerticalScrollEvents.set(scrollerId, newYState);
                            }
                            androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                        }
                    }
                }
                if (newXState != null) {
                    scrollObservationScope.setOldXValue(newXState.getValue().invoke());
                }
                if (newYState != null) {
                    scrollObservationScope.setOldYValue(newYState.getValue().invoke());
                }
            }
        });
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent event = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        event.setContentChangeTypes(contentChangeType);
        if (title != null) {
            event.getText().add(title);
        }
        sendEvent(event);
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        MutableIntSet newChildren;
        MutableIntSet newChildren2 = IntSetKt.mutableIntSetOf();
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = replacedChildren$ui_release.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes().contains(child.getId())) {
                if (!oldNode.getChildren().contains(child.getId())) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                    return;
                }
                newChildren2.add(child.getId());
            }
        }
        IntSet this_$iv = oldNode.getChildren();
        int $i$f$forEach = 0;
        int[] k$iv = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                IntSet this_$iv2 = this_$iv;
                int $i$f$forEach2 = $i$f$forEach;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    newChildren = newChildren2;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            if (!newChildren2.contains(k$iv[index$iv$iv])) {
                                notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                                return;
                            }
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        newChildren2 = newChildren2;
                    }
                    newChildren = newChildren2;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv = this_$iv2;
                $i$f$forEach = $i$f$forEach2;
                newChildren2 = newChildren;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = replacedChildren$ui_release2.get(index$iv2);
            SemanticsNode child2 = (SemanticsNode) item$iv2;
            if (getCurrentSemanticsNodes().contains(child2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(child2.getId());
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendAccessibilitySemanticsStructureChangeEvents(child2, semanticsNodeCopy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iterator;
        int selectionEnd;
        int selectionStart;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if ((str == null || str.length() == 0) || (iterator = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int current = getAccessibilitySelectionEnd(node);
        if (current == -1) {
            current = forward ? 0 : text.length();
        }
        int[] range = forward ? iterator.following(current) : iterator.preceding(current);
        if (range == null) {
            return false;
        }
        int segmentStart = range[0];
        int segmentEnd = range[1];
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            int selectionStart2 = getAccessibilitySelectionStart(node);
            if (selectionStart2 == -1) {
                selectionStart2 = forward ? segmentStart : segmentEnd;
            }
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionStart2;
        } else {
            selectionEnd = forward ? segmentEnd : segmentStart;
            int selectionStart3 = selectionEnd;
            selectionStart = selectionStart3;
        }
        int action = forward ? 256 : 512;
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, action, granularity, segmentStart, segmentEnd, SystemClock.uptimeMillis());
        setAccessibilitySelection(node, selectionStart, selectionEnd, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent it = this.pendingTextTraversedEvent;
        if (it != null) {
            if (semanticsNodeId != it.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - it.getTraverseTime() <= 1000) {
                AccessibilityEvent event = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(it.getNode().getId()), 131072);
                event.setFromIndex(it.getFromIndex());
                event.setToIndex(it.getToIndex());
                event.setAction(it.getAction());
                event.setMovementGranularity(it.getGranularity());
                event.getText().add(getIterableTextForAccessibility(it.getNode()));
                sendEvent(event);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String text;
        int i;
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node)) {
            Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
            }
            return false;
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (text = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start >= 0 && start == end && end <= text.length()) {
            i = start;
        } else {
            i = -1;
        }
        this.accessibilityCursorPosition = i;
        boolean nonEmptyText = text.length() > 0;
        AccessibilityEvent event = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(text.length()) : null, text);
        sendEvent(event);
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m6003getStartimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m5998getEndimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        AccessibilityIterators.AbstractTextSegmentIterator iterator;
        TextLayoutResult textLayoutResult;
        if (node == null) {
            return null;
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if (str == null || str.length() == 0) {
            return null;
        }
        switch (granularity) {
            case 1:
                iterator = AccessibilityIterators.CharacterTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
                iterator.initialize(text);
                break;
            case 2:
                iterator = AccessibilityIterators.WordTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
                iterator.initialize(text);
                break;
            case 4:
            case 16:
                if (!node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || (textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(node.getUnmergedConfig())) == null) {
                    return null;
                }
                if (granularity == 4) {
                    AccessibilityIterators.AbstractTextSegmentIterator iterator2 = AccessibilityIterators.LineTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.LineTextSegmentIterator) iterator2).initialize(text, textLayoutResult);
                    iterator = iterator2;
                } else {
                    AccessibilityIterators.AbstractTextSegmentIterator iterator3 = AccessibilityIterators.PageTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.PageTextSegmentIterator) iterator3).initialize(text, textLayoutResult, node);
                    iterator = iterator3;
                }
                break;
                break;
            case 8:
                iterator = AccessibilityIterators.ParagraphTextSegmentIterator.INSTANCE.getInstance();
                iterator.initialize(text);
                break;
            default:
                return null;
        }
        return iterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", null, null, 0, null, null, 62, null);
        }
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText())) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration $this$getTextForTextField) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull($this$getTextForTextField, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "findFocus", "focus", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProvider {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            AccessibilityNodeInfo nodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
            if (AndroidComposeViewAccessibilityDelegateCompat.this.sendingFocusAffectingEvent && virtualViewId == AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId) {
                AndroidComposeViewAccessibilityDelegateCompat.this.currentlyFocusedANI = nodeInfo;
            }
            return nodeInfo;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey, Bundle arguments) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int focus) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            AccessibilityAction it;
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, it.getLabel()));
            }
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                AccessibilityAction it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                if (it != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, it.getLabel()));
                }
                AccessibilityAction it2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                if (it2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, it2.getLabel()));
                }
                AccessibilityAction it3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                if (it3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, it3.getLabel()));
                }
                AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                if (it4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, it4.getLabel()));
                }
            }
        }
    }
}
