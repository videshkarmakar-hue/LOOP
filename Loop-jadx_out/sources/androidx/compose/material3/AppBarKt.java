package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.AlignmentLineKt;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.p001ui.unit.VelocityKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0083\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u008f\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001al\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001ax\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0007\u001a\u007f\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u008e\u0001\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u007f\u0010>\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0098\u0001\u0010>\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010?\u001a\u00020\u00012\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u007f\u0010B\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0098\u0001\u0010B\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010?\u001a\u00020\u00012\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010A\u001a\u0092\u0001\u0010D\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010;\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a\u007f\u0010K\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u008e\u0001\u0010K\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007ø\u0001\u0000¢\u0006\u0004\bL\u0010=\u001a£\u0001\u0010M\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u001c2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010S\u001a\u0002012\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020H2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001aµ\u0001\u0010]\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010E\u001a\u00020F2\u0006\u0010X\u001a\u00020\u00012\u0011\u0010^\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010_\u001a\u00020F2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010?\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a+\u0010b\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010c\u001a+\u0010d\u001a\u00020e2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010f\u001a>\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020e2\u0006\u0010j\u001a\u0002012\u000e\u0010k\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010l2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010nH\u0082@¢\u0006\u0002\u0010o\u001a>\u0010p\u001a\u00020h2\u0006\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u0002012\u000e\u0010k\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010l2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010nH\u0082@¢\u0006\u0002\u0010q\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006r²\u0006\n\u0010s\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020\u001cX\u008a\u0084\u0002"}, m195d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "scrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "expandedHeight", "CenterAlignedTopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "collapsedHeight", "LargeTopAppBar-oKE7A98", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumTopAppBar", "MediumTopAppBar-oKE7A98", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "SingleRowTopAppBar-cJHQLPU", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "TopAppBar-GHTll3U", "TopAppBarLayout", "scrolledOffset", "Landroidx/compose/material3/ScrolledOffset;", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ScrolledOffset;JJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "TwoRowsTopAppBar-nS6u9G4", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberBottomAppBarState", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settleAppBarBottom", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release", "colorTransitionFraction", "appBarContainerColor"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBar$1 */
    /* JADX INFO: compiled from: AppBar.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.AppBarKt", m210f = "AppBar.kt", m211i = {0, 0, 0, 1}, m212l = {2474, 2490}, m213m = "settleAppBar", m214n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, m215s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C12081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12081(Continuation<? super C12081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBar(null, 0.0f, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarKt$settleAppBarBottom$1 */
    /* JADX INFO: compiled from: AppBar.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.AppBarKt", m210f = "AppBar.kt", m211i = {0, 0, 0, 1}, m212l = {1774, 1790}, m213m = "settleAppBarBottom", m214n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, m215s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C12111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12111(Continuation<? super C12111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBarBottom(null, 0.0f, null, null, this);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TopAppBar with expandedHeight parameter")
    public static final /* synthetic */ void TopAppBar(final Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function2;
        Function3 actions2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Modifier.Companion modifier3;
        Function2 navigationIcon2;
        int $dirty;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Modifier modifier4;
        WindowInsets windowInsets4;
        Function2 navigationIcon3;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Function3 actions3;
        Composer $composer2 = $composer.startRestartGroup(1906353009);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(5,2,3!1,6)137@6792L12,138@6854L17,140@6929L270:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function2 = navigationIcon;
        } else if (($changed & 384) == 0) {
            function2 = navigationIcon;
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = navigationIcon;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            actions2 = actions;
        } else if (($changed & 3072) == 0) {
            actions2 = actions;
            $dirty2 |= $composer2.changedInstance(actions2) ? 2048 : 1024;
        } else {
            actions2 = actions;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer2.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer2.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            actions3 = actions2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
            navigationIcon3 = function2;
            windowInsets4 = windowInsets2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                navigationIcon2 = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2092getLambda1$material3_release() : function2;
                if (i4 != 0) {
                    actions2 = ComposableSingletons$AppBarKt.INSTANCE.m2102getLambda2$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.topAppBarColors($composer2, 6);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    scrollBehavior2 = null;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    int i8 = $dirty2 & (-458753);
                    navigationIcon2 = function2;
                    windowInsets3 = windowInsets2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = i8;
                    modifier3 = modifier2;
                    colors3 = colors2;
                } else {
                    modifier3 = modifier2;
                    navigationIcon2 = function2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1906353009, $dirty, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:140)");
            }
            m1923TopAppBarGHTll3U(title, modifier3, navigationIcon2, actions2, TopAppBarDefaults.INSTANCE.m2977getTopAppBarExpandedHeightD9Ej5fM(), windowInsets3, colors3, scrollBehavior2, $composer2, ($dirty & 14) | CpioConstants.C_ISBLK | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (29360128 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            windowInsets4 = windowInsets3;
            navigationIcon3 = navigationIcon2;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            actions3 = actions2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final Function2 function3 = navigationIcon3;
            final Function3 function4 = actions3;
            final WindowInsets windowInsets5 = windowInsets4;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.TopAppBar.1
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.TopAppBar(title, modifier5, function3, function4, windowInsets5, topAppBarColors, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: TopAppBar-GHTll3U, reason: not valid java name */
    public static final void m1923TopAppBarGHTll3U(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, float expandedHeight, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M2104getLambda4$material3_release;
        float expandedHeight2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        Modifier.Companion modifier2;
        Function2<? super Composer, ? super Integer, Unit> function2M2103getLambda3$material3_release;
        TopAppBarScrollBehavior scrollBehavior2;
        float expandedHeight3;
        TopAppBarColors colors3;
        int $dirty;
        WindowInsets windowInsets3;
        float expandedHeight4;
        WindowInsets windowInsets4;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function6;
        Composer $composer2 = $composer.startRestartGroup(226148675);
        ComposerKt.sourceInformation($composer2, "C(TopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)193@9790L12,194@9852L17,199@10026L10,196@9927L521:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M2104getLambda4$material3_release = function4;
        } else if (($changed & 3072) == 0) {
            function3M2104getLambda4$material3_release = function4;
            $dirty2 |= $composer2.changedInstance(function3M2104getLambda4$material3_release) ? 2048 : 1024;
        } else {
            function3M2104getLambda4$material3_release = function4;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            expandedHeight2 = expandedHeight;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            expandedHeight2 = expandedHeight;
            $dirty2 |= $composer2.changed(expandedHeight2) ? 16384 : 8192;
        } else {
            expandedHeight2 = expandedHeight;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer2.changed(windowInsets2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                int i7 = $composer2.changed(colors2) ? 1048576 : 524288;
                $dirty2 |= i7;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i7;
        } else {
            colors2 = colors;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(scrollBehavior) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            scrollBehavior3 = scrollBehavior;
            windowInsets4 = windowInsets2;
            colors4 = colors2;
            function6 = function3M2104getLambda4$material3_release;
            expandedHeight4 = expandedHeight2;
            function5 = function3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function2M2103getLambda3$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2103getLambda3$material3_release() : function3;
                if (i4 != 0) {
                    function3M2104getLambda4$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m2104getLambda4$material3_release();
                }
                if (i5 != 0) {
                    expandedHeight2 = TopAppBarDefaults.INSTANCE.m2977getTopAppBarExpandedHeightD9Ej5fM();
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                    colors2 = TopAppBarDefaults.INSTANCE.topAppBarColors($composer2, 6);
                }
                if (i8 != 0) {
                    scrollBehavior2 = null;
                    expandedHeight3 = expandedHeight2;
                    colors3 = colors2;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    expandedHeight3 = expandedHeight2;
                    colors3 = colors2;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    int i9 = (-3670017) & $dirty2;
                    modifier2 = modifier;
                    function2M2103getLambda3$material3_release = function3;
                    scrollBehavior2 = scrollBehavior;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    $dirty = i9;
                    expandedHeight3 = expandedHeight2;
                } else {
                    modifier2 = modifier;
                    function2M2103getLambda3$material3_release = function3;
                    scrollBehavior2 = scrollBehavior;
                    expandedHeight3 = expandedHeight2;
                    colors3 = colors2;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(226148675, $dirty, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:196)");
            }
            m1922SingleRowTopAppBarcJHQLPU(modifier2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function2M2103getLambda3$material3_release, function3M2104getLambda4$material3_release, (C1979Dp.m6806equalsimpl0(expandedHeight3, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) || C1979Dp.m6806equalsimpl0(expandedHeight3, C1979Dp.INSTANCE.m6820getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2977getTopAppBarExpandedHeightD9Ej5fM() : expandedHeight3, windowInsets3, colors3, scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 6) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            expandedHeight4 = expandedHeight3;
            windowInsets4 = windowInsets3;
            modifier3 = modifier2;
            function5 = function2M2103getLambda3$material3_release;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            function6 = function3M2104getLambda4$material3_release;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function8 = function6;
            final float f = expandedHeight4;
            final WindowInsets windowInsets5 = windowInsets4;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.TopAppBar.2
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

                public final void invoke(Composer composer, int i10) {
                    AppBarKt.m1923TopAppBarGHTll3U(function2, modifier4, function7, function8, f, windowInsets5, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter")
    public static final /* synthetic */ void CenterAlignedTopAppBar(final Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function2;
        Function3 actions2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Modifier.Companion modifier3;
        Function2 navigationIcon2;
        int $dirty;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Modifier modifier4;
        WindowInsets windowInsets4;
        Function2 navigationIcon3;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Function3 actions3;
        Composer $composer2 = $composer.startRestartGroup(-2139286460);
        ComposerKt.sourceInformation($composer2, "C(CenterAlignedTopAppBar)P(5,2,3!1,6)253@12785L12,254@12847L30,256@12935L283:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function2 = navigationIcon;
        } else if (($changed & 384) == 0) {
            function2 = navigationIcon;
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = navigationIcon;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            actions2 = actions;
        } else if (($changed & 3072) == 0) {
            actions2 = actions;
            $dirty2 |= $composer2.changedInstance(actions2) ? 2048 : 1024;
        } else {
            actions2 = actions;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer2.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer2.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            actions3 = actions2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
            navigationIcon3 = function2;
            windowInsets4 = windowInsets2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                navigationIcon2 = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2105getLambda5$material3_release() : function2;
                if (i4 != 0) {
                    actions2 = ComposableSingletons$AppBarKt.INSTANCE.m2106getLambda6$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.centerAlignedTopAppBarColors($composer2, 6);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    scrollBehavior2 = null;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    int i8 = $dirty2 & (-458753);
                    navigationIcon2 = function2;
                    windowInsets3 = windowInsets2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = i8;
                    modifier3 = modifier2;
                    colors3 = colors2;
                } else {
                    modifier3 = modifier2;
                    navigationIcon2 = function2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2139286460, $dirty, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:256)");
            }
            m1919CenterAlignedTopAppBarGHTll3U(title, modifier3, navigationIcon2, actions2, TopAppBarDefaults.INSTANCE.m2977getTopAppBarExpandedHeightD9Ej5fM(), windowInsets3, colors3, scrollBehavior2, $composer2, ($dirty & 14) | CpioConstants.C_ISBLK | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (29360128 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            windowInsets4 = windowInsets3;
            navigationIcon3 = navigationIcon2;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            actions3 = actions2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final Function2 function3 = navigationIcon3;
            final Function3 function4 = actions3;
            final WindowInsets windowInsets5 = windowInsets4;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar.1
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.CenterAlignedTopAppBar(title, modifier5, function3, function4, windowInsets5, topAppBarColors, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: CenterAlignedTopAppBar-GHTll3U, reason: not valid java name */
    public static final void m1919CenterAlignedTopAppBarGHTll3U(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, float expandedHeight, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M2108getLambda8$material3_release;
        float expandedHeight2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        Modifier.Companion modifier2;
        Function2<? super Composer, ? super Integer, Unit> function2M2107getLambda7$material3_release;
        TopAppBarScrollBehavior scrollBehavior2;
        float expandedHeight3;
        TopAppBarColors colors3;
        int $dirty;
        WindowInsets windowInsets3;
        float expandedHeight4;
        WindowInsets windowInsets4;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function6;
        Composer $composer2 = $composer.startRestartGroup(1952988048);
        ComposerKt.sourceInformation($composer2, "C(CenterAlignedTopAppBar)P(6,3,4!1,2:c#ui.unit.Dp,7)308@15831L12,309@15893L30,314@16080L10,311@15981L520:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function3M2108getLambda8$material3_release = function4;
        } else if (($changed & 3072) == 0) {
            function3M2108getLambda8$material3_release = function4;
            $dirty2 |= $composer2.changedInstance(function3M2108getLambda8$material3_release) ? 2048 : 1024;
        } else {
            function3M2108getLambda8$material3_release = function4;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            expandedHeight2 = expandedHeight;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            expandedHeight2 = expandedHeight;
            $dirty2 |= $composer2.changed(expandedHeight2) ? 16384 : 8192;
        } else {
            expandedHeight2 = expandedHeight;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer2.changed(windowInsets2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                int i7 = $composer2.changed(colors2) ? 1048576 : 524288;
                $dirty2 |= i7;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i7;
        } else {
            colors2 = colors;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(scrollBehavior) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            scrollBehavior3 = scrollBehavior;
            windowInsets4 = windowInsets2;
            colors4 = colors2;
            function6 = function3M2108getLambda8$material3_release;
            expandedHeight4 = expandedHeight2;
            function5 = function3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function2M2107getLambda7$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2107getLambda7$material3_release() : function3;
                if (i4 != 0) {
                    function3M2108getLambda8$material3_release = ComposableSingletons$AppBarKt.INSTANCE.m2108getLambda8$material3_release();
                }
                if (i5 != 0) {
                    expandedHeight2 = TopAppBarDefaults.INSTANCE.m2977getTopAppBarExpandedHeightD9Ej5fM();
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                    colors2 = TopAppBarDefaults.INSTANCE.centerAlignedTopAppBarColors($composer2, 6);
                }
                if (i8 != 0) {
                    scrollBehavior2 = null;
                    expandedHeight3 = expandedHeight2;
                    colors3 = colors2;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    expandedHeight3 = expandedHeight2;
                    colors3 = colors2;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    int i9 = (-3670017) & $dirty2;
                    modifier2 = modifier;
                    function2M2107getLambda7$material3_release = function3;
                    scrollBehavior2 = scrollBehavior;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    $dirty = i9;
                    expandedHeight3 = expandedHeight2;
                } else {
                    modifier2 = modifier;
                    function2M2107getLambda7$material3_release = function3;
                    scrollBehavior2 = scrollBehavior;
                    expandedHeight3 = expandedHeight2;
                    colors3 = colors2;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1952988048, $dirty, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:311)");
            }
            m1922SingleRowTopAppBarcJHQLPU(modifier2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function2M2107getLambda7$material3_release, function3M2108getLambda8$material3_release, (C1979Dp.m6806equalsimpl0(expandedHeight3, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) || C1979Dp.m6806equalsimpl0(expandedHeight3, C1979Dp.INSTANCE.m6820getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2977getTopAppBarExpandedHeightD9Ej5fM() : expandedHeight3, windowInsets3, colors3, scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024) | (($dirty << 6) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            expandedHeight4 = expandedHeight3;
            windowInsets4 = windowInsets3;
            modifier3 = modifier2;
            function5 = function2M2107getLambda7$material3_release;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            function6 = function3M2108getLambda8$material3_release;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function8 = function6;
            final float f = expandedHeight4;
            final WindowInsets windowInsets5 = windowInsets4;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar.2
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

                public final void invoke(Composer composer, int i10) {
                    AppBarKt.m1919CenterAlignedTopAppBarGHTll3U(function2, modifier4, function7, function8, f, windowInsets5, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final /* synthetic */ void MediumTopAppBar(final Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function2;
        Function3 actions2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Modifier.Companion modifier3;
        Function2 navigationIcon2;
        int $dirty;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Modifier modifier4;
        WindowInsets windowInsets4;
        Function2 navigationIcon3;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Function3 actions3;
        Composer $composer2 = $composer.startRestartGroup(1805417862);
        ComposerKt.sourceInformation($composer2, "C(MediumTopAppBar)P(5,2,3!1,6)370@18988L12,371@19050L23,373@19131L348:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function2 = navigationIcon;
        } else if (($changed & 384) == 0) {
            function2 = navigationIcon;
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = navigationIcon;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            actions2 = actions;
        } else if (($changed & 3072) == 0) {
            actions2 = actions;
            $dirty2 |= $composer2.changedInstance(actions2) ? 2048 : 1024;
        } else {
            actions2 = actions;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer2.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer2.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            actions3 = actions2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
            navigationIcon3 = function2;
            windowInsets4 = windowInsets2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                navigationIcon2 = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2109getLambda9$material3_release() : function2;
                if (i4 != 0) {
                    actions2 = ComposableSingletons$AppBarKt.INSTANCE.m2093getLambda10$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.mediumTopAppBarColors($composer2, 6);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    scrollBehavior2 = null;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    int i8 = $dirty2 & (-458753);
                    navigationIcon2 = function2;
                    windowInsets3 = windowInsets2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = i8;
                    modifier3 = modifier2;
                    colors3 = colors2;
                } else {
                    modifier3 = modifier2;
                    navigationIcon2 = function2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1805417862, $dirty, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:373)");
            }
            m1921MediumTopAppBaroKE7A98(title, modifier3, navigationIcon2, actions2, TopAppBarDefaults.INSTANCE.m2975getMediumAppBarCollapsedHeightD9Ej5fM(), TopAppBarDefaults.INSTANCE.m2976getMediumAppBarExpandedHeightD9Ej5fM(), windowInsets3, colors3, scrollBehavior2, $composer2, ($dirty & 14) | 221184 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            windowInsets4 = windowInsets3;
            navigationIcon3 = navigationIcon2;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            actions3 = actions2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final Function2 function3 = navigationIcon3;
            final Function3 function4 = actions3;
            final WindowInsets windowInsets5 = windowInsets4;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.MediumTopAppBar.1
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.MediumTopAppBar(title, modifier5, function3, function4, windowInsets5, topAppBarColors, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: MediumTopAppBar-oKE7A98, reason: not valid java name */
    public static final void m1921MediumTopAppBaroKE7A98(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5;
        float f;
        float f2;
        Modifier.Companion modifier2;
        Function2<? super Composer, ? super Integer, Unit> function2M2094getLambda11$material3_release;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M2095getLambda12$material3_release;
        float collapsedHeight2;
        float expandedHeight2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        int $dirty;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        float collapsedHeight3;
        float expandedHeight3;
        WindowInsets windowInsets3;
        Composer $composer2 = $composer.startRestartGroup(1879191686);
        ComposerKt.sourceInformation($composer2, "C(MediumTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)435@22813L12,436@22875L23,441@23053L10,442@23151L10,438@22956L863:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function5 = function4;
        } else if (($changed & 3072) == 0) {
            function5 = function4;
            $dirty2 |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function4;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            f = collapsedHeight;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            f = collapsedHeight;
            $dirty2 |= $composer2.changed(f) ? 16384 : 8192;
        } else {
            f = collapsedHeight;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f2 = expandedHeight;
        } else if ((196608 & $changed) == 0) {
            f2 = expandedHeight;
            $dirty2 |= $composer2.changed(f2) ? 131072 : 65536;
        } else {
            f2 = expandedHeight;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(windowInsets)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(colors)) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(scrollBehavior) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function6 = function3;
            windowInsets3 = windowInsets;
            colors4 = colors;
            scrollBehavior3 = scrollBehavior;
            collapsedHeight3 = f;
            expandedHeight3 = f2;
            modifier3 = modifier;
            function7 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function2M2094getLambda11$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2094getLambda11$material3_release() : function3;
                function3M2095getLambda12$material3_release = i4 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2095getLambda12$material3_release() : function5;
                collapsedHeight2 = i5 != 0 ? TopAppBarDefaults.INSTANCE.m2975getMediumAppBarCollapsedHeightD9Ej5fM() : f;
                expandedHeight2 = i6 != 0 ? TopAppBarDefaults.INSTANCE.m2976getMediumAppBarExpandedHeightD9Ej5fM() : f2;
                if ((i & 64) != 0) {
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i & 128) != 0) {
                    colors2 = TopAppBarDefaults.INSTANCE.mediumTopAppBarColors($composer2, 6);
                    $dirty2 &= -29360129;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    scrollBehavior2 = null;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    colors3 = colors2;
                    scrollBehavior2 = scrollBehavior;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    int i8 = (-29360129) & $dirty2;
                    modifier2 = modifier;
                    function2M2094getLambda11$material3_release = function3;
                    windowInsets2 = windowInsets;
                    scrollBehavior2 = scrollBehavior;
                    function3M2095getLambda12$material3_release = function5;
                    collapsedHeight2 = f;
                    expandedHeight2 = f2;
                    $dirty = i8;
                    colors3 = colors;
                } else {
                    modifier2 = modifier;
                    function2M2094getLambda11$material3_release = function3;
                    windowInsets2 = windowInsets;
                    colors3 = colors;
                    function3M2095getLambda12$material3_release = function5;
                    collapsedHeight2 = f;
                    expandedHeight2 = f2;
                    $dirty = $dirty2;
                    scrollBehavior2 = scrollBehavior;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1879191686, $dirty, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:438)");
            }
            m1925TwoRowsTopAppBarnS6u9G4(modifier2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function2M2094getLambda11$material3_release, function3M2095getLambda12$material3_release, (C1979Dp.m6806equalsimpl0(collapsedHeight2, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) || C1979Dp.m6806equalsimpl0(collapsedHeight2, C1979Dp.INSTANCE.m6820getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2975getMediumAppBarCollapsedHeightD9Ej5fM() : collapsedHeight2, (C1979Dp.m6806equalsimpl0(expandedHeight2, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) || C1979Dp.m6806equalsimpl0(expandedHeight2, C1979Dp.INSTANCE.m6820getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2976getMediumAppBarExpandedHeightD9Ej5fM() : expandedHeight2, windowInsets2, colors3, scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 12) & 57344) | (($dirty << 12) & 3670016) | (($dirty << 12) & 29360128), (($dirty >> 18) & 14) | (($dirty >> 18) & 112) | (($dirty >> 18) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            modifier3 = modifier2;
            function6 = function2M2094getLambda11$material3_release;
            function7 = function3M2095getLambda12$material3_release;
            collapsedHeight3 = collapsedHeight2;
            expandedHeight3 = expandedHeight2;
            windowInsets3 = windowInsets2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function9 = function7;
            final float f3 = collapsedHeight3;
            final float f4 = expandedHeight3;
            final WindowInsets windowInsets4 = windowInsets3;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.MediumTopAppBar.2
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.m1921MediumTopAppBaroKE7A98(function2, modifier4, function8, function9, f3, f4, windowInsets4, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters")
    public static final /* synthetic */ void LargeTopAppBar(final Function2 title, Modifier modifier, Function2 navigationIcon, Function3 actions, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function2;
        Function3 actions2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Modifier.Companion modifier3;
        Function2 navigationIcon2;
        int $dirty;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Modifier modifier4;
        WindowInsets windowInsets4;
        Function2 navigationIcon3;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Function3 actions3;
        Composer $composer2 = $composer.startRestartGroup(-474540752);
        ComposerKt.sourceInformation($composer2, "C(LargeTopAppBar)P(5,2,3!1,6)504@26297L12,505@26359L22,507@26439L345:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function2 = navigationIcon;
        } else if (($changed & 384) == 0) {
            function2 = navigationIcon;
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = navigationIcon;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            actions2 = actions;
        } else if (($changed & 3072) == 0) {
            actions2 = actions;
            $dirty2 |= $composer2.changedInstance(actions2) ? 2048 : 1024;
        } else {
            actions2 = actions;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer2.changed(windowInsets2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty2 |= $composer2.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            actions3 = actions2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
            navigationIcon3 = function2;
            windowInsets4 = windowInsets2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                navigationIcon2 = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2096getLambda13$material3_release() : function2;
                if (i4 != 0) {
                    actions2 = ComposableSingletons$AppBarKt.INSTANCE.m2097getLambda14$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.largeTopAppBarColors($composer2, 6);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    scrollBehavior2 = null;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    int i8 = $dirty2 & (-458753);
                    navigationIcon2 = function2;
                    windowInsets3 = windowInsets2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = i8;
                    modifier3 = modifier2;
                    colors3 = colors2;
                } else {
                    modifier3 = modifier2;
                    navigationIcon2 = function2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    $dirty = $dirty2;
                    windowInsets3 = windowInsets2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-474540752, $dirty, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:507)");
            }
            m1920LargeTopAppBaroKE7A98(title, modifier3, navigationIcon2, actions2, TopAppBarDefaults.INSTANCE.m2973getLargeAppBarCollapsedHeightD9Ej5fM(), TopAppBarDefaults.INSTANCE.m2974getLargeAppBarExpandedHeightD9Ej5fM(), windowInsets3, colors3, scrollBehavior2, $composer2, ($dirty & 14) | 221184 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            windowInsets4 = windowInsets3;
            navigationIcon3 = navigationIcon2;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            actions3 = actions2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final Function2 function3 = navigationIcon3;
            final Function3 function4 = actions3;
            final WindowInsets windowInsets5 = windowInsets4;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.LargeTopAppBar.1
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.LargeTopAppBar(title, modifier5, function3, function4, windowInsets5, topAppBarColors, topAppBarScrollBehavior2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: LargeTopAppBar-oKE7A98, reason: not valid java name */
    public static final void m1920LargeTopAppBaroKE7A98(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, float collapsedHeight, float expandedHeight, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5;
        float f;
        float f2;
        Modifier.Companion modifier2;
        Function2<? super Composer, ? super Integer, Unit> function2M2098getLambda15$material3_release;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3M2099getLambda16$material3_release;
        float collapsedHeight2;
        float expandedHeight2;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        int $dirty;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        TopAppBarColors colors4;
        TopAppBarScrollBehavior scrollBehavior3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        float collapsedHeight3;
        float expandedHeight3;
        WindowInsets windowInsets3;
        Composer $composer2 = $composer.startRestartGroup(-630005584);
        ComposerKt.sourceInformation($composer2, "C(LargeTopAppBar)P(7,4,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,8)569@30104L12,570@30166L22,574@30318L10,575@30415L10,572@30246L859:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            function5 = function4;
        } else if (($changed & 3072) == 0) {
            function5 = function4;
            $dirty2 |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function4;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            f = collapsedHeight;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            f = collapsedHeight;
            $dirty2 |= $composer2.changed(f) ? 16384 : 8192;
        } else {
            f = collapsedHeight;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f2 = expandedHeight;
        } else if ((196608 & $changed) == 0) {
            f2 = expandedHeight;
            $dirty2 |= $composer2.changed(f2) ? 131072 : 65536;
        } else {
            f2 = expandedHeight;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(windowInsets)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(colors)) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(scrollBehavior) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function6 = function3;
            windowInsets3 = windowInsets;
            colors4 = colors;
            scrollBehavior3 = scrollBehavior;
            collapsedHeight3 = f;
            expandedHeight3 = f2;
            modifier3 = modifier;
            function7 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function2M2098getLambda15$material3_release = i3 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2098getLambda15$material3_release() : function3;
                function3M2099getLambda16$material3_release = i4 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m2099getLambda16$material3_release() : function5;
                collapsedHeight2 = i5 != 0 ? TopAppBarDefaults.INSTANCE.m2973getLargeAppBarCollapsedHeightD9Ej5fM() : f;
                expandedHeight2 = i6 != 0 ? TopAppBarDefaults.INSTANCE.m2974getLargeAppBarExpandedHeightD9Ej5fM() : f2;
                if ((i & 64) != 0) {
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i & 128) != 0) {
                    colors2 = TopAppBarDefaults.INSTANCE.largeTopAppBarColors($composer2, 6);
                    $dirty2 &= -29360129;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    scrollBehavior2 = null;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    colors3 = colors2;
                    scrollBehavior2 = scrollBehavior;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    int i8 = (-29360129) & $dirty2;
                    modifier2 = modifier;
                    function2M2098getLambda15$material3_release = function3;
                    windowInsets2 = windowInsets;
                    scrollBehavior2 = scrollBehavior;
                    function3M2099getLambda16$material3_release = function5;
                    collapsedHeight2 = f;
                    expandedHeight2 = f2;
                    $dirty = i8;
                    colors3 = colors;
                } else {
                    modifier2 = modifier;
                    function2M2098getLambda15$material3_release = function3;
                    windowInsets2 = windowInsets;
                    colors3 = colors;
                    function3M2099getLambda16$material3_release = function5;
                    collapsedHeight2 = f;
                    expandedHeight2 = f2;
                    $dirty = $dirty2;
                    scrollBehavior2 = scrollBehavior;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-630005584, $dirty, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:572)");
            }
            m1925TwoRowsTopAppBarnS6u9G4(modifier2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function2M2098getLambda15$material3_release, function3M2099getLambda16$material3_release, (C1979Dp.m6806equalsimpl0(collapsedHeight2, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) || C1979Dp.m6806equalsimpl0(collapsedHeight2, C1979Dp.INSTANCE.m6820getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2973getLargeAppBarCollapsedHeightD9Ej5fM() : collapsedHeight2, (C1979Dp.m6806equalsimpl0(expandedHeight2, C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM()) || C1979Dp.m6806equalsimpl0(expandedHeight2, C1979Dp.INSTANCE.m6820getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2974getLargeAppBarExpandedHeightD9Ej5fM() : expandedHeight2, windowInsets2, colors3, scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 12) & 57344) | (($dirty << 12) & 3670016) | (($dirty << 12) & 29360128), (($dirty >> 18) & 14) | (($dirty >> 18) & 112) | (($dirty >> 18) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
            modifier3 = modifier2;
            function6 = function2M2098getLambda15$material3_release;
            function7 = function3M2099getLambda16$material3_release;
            collapsedHeight3 = collapsedHeight2;
            expandedHeight3 = expandedHeight2;
            windowInsets3 = windowInsets2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function9 = function7;
            final float f3 = collapsedHeight3;
            final float f4 = expandedHeight3;
            final WindowInsets windowInsets4 = windowInsets3;
            final TopAppBarColors topAppBarColors = colors4;
            final TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.LargeTopAppBar.2
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.m1920LargeTopAppBaroKE7A98(function2, modifier4, function8, function9, f3, f4, windowInsets4, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    public static final void m1916BottomAppBarSnr_uVM(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function4;
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        Modifier.Companion modifier2;
        PaddingValues contentPadding2;
        WindowInsets windowInsets2;
        int $dirty;
        float tonalElevation3;
        Modifier modifier3;
        float tonalElevation4;
        PaddingValues contentPadding3;
        WindowInsets windowInsets3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        long containerColor3;
        long contentColor3;
        Composer $composer2 = $composer.startRestartGroup(2141738945);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)632@33106L14,633@33148L31,636@33374L12,637@33392L315:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function4 = function2;
        } else if (($changed & 384) == 0) {
            function4 = function2;
            $dirty2 |= $composer2.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function2;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            tonalElevation2 = tonalElevation;
        } else if ((196608 & $changed) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty2 |= $composer2.changed(tonalElevation2) ? 131072 : 65536;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(contentPadding) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(windowInsets)) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            contentPadding3 = contentPadding;
            windowInsets3 = windowInsets;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            tonalElevation4 = tonalElevation2;
            function5 = function4;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    function4 = null;
                }
                if ((i & 8) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty2 >> 9) & 14);
                    $dirty2 &= -57345;
                }
                if (i6 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1940getContainerElevationD9Ej5fM();
                }
                contentPadding2 = i7 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : contentPadding;
                if ((i & 128) != 0) {
                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty = $dirty2 & (-29360129);
                    tonalElevation3 = tonalElevation2;
                } else {
                    windowInsets2 = windowInsets;
                    $dirty = $dirty2;
                    tonalElevation3 = tonalElevation2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                    $dirty = $dirty2 & (-29360129);
                    tonalElevation3 = tonalElevation2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                    $dirty = $dirty2;
                    tonalElevation3 = tonalElevation2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2141738945, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:637)");
            }
            m1918BottomAppBarqhFBPw4(function3, modifier2, function4, containerColor2, contentColor2, tonalElevation3, contentPadding2, windowInsets2, null, $composer2, ($dirty & 14) | 100663296 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            tonalElevation4 = tonalElevation3;
            contentPadding3 = contentPadding2;
            windowInsets3 = windowInsets2;
            function5 = function4;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function6 = function5;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final float f = tonalElevation4;
            final PaddingValues paddingValues = contentPadding3;
            final WindowInsets windowInsets4 = windowInsets3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$1
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

                public final void invoke(Composer composer, int i8) {
                    AppBarKt.m1916BottomAppBarSnr_uVM(function3, modifier4, function6, j, j2, f, paddingValues, windowInsets4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: BottomAppBar-qhFBPw4, reason: not valid java name */
    public static final void m1918BottomAppBarqhFBPw4(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, BottomAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        float f;
        Modifier.Companion modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        float tonalElevation2;
        PaddingValues contentPadding2;
        WindowInsets windowInsets2;
        BottomAppBarScrollBehavior scrollBehavior2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        BottomAppBarScrollBehavior scrollBehavior3;
        Modifier modifier3;
        float tonalElevation3;
        WindowInsets windowInsets3;
        long containerColor3;
        long contentColor3;
        PaddingValues contentPadding3;
        Composer $composer2 = $composer.startRestartGroup(-1044837119);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)694@36292L14,695@36334L31,698@36560L12,708@36888L550,700@36634L804:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = tonalElevation;
        } else if ((196608 & $changed) == 0) {
            f = tonalElevation;
            $dirty |= $composer2.changed(f) ? 131072 : 65536;
        } else {
            f = tonalElevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(contentPadding) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(windowInsets)) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(scrollBehavior) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function5 = function2;
            contentPadding3 = contentPadding;
            windowInsets3 = windowInsets;
            scrollBehavior3 = scrollBehavior;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            tonalElevation3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function4 = i3 != 0 ? null : function2;
                if ((i & 8) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                }
                tonalElevation2 = i6 != 0 ? BottomAppBarDefaults.INSTANCE.m1940getContainerElevationD9Ej5fM() : f;
                contentPadding2 = i7 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : contentPadding;
                if ((i & 128) != 0) {
                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty &= -29360129;
                } else {
                    windowInsets2 = windowInsets;
                }
                scrollBehavior2 = i8 != 0 ? null : scrollBehavior;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    function4 = function2;
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                    $dirty &= -29360129;
                    tonalElevation2 = f;
                    scrollBehavior2 = scrollBehavior;
                } else {
                    modifier2 = modifier;
                    function4 = function2;
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                    scrollBehavior2 = scrollBehavior;
                    tonalElevation2 = f;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1044837119, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:700)");
            }
            Function2<? super Composer, ? super Integer, Unit> function6 = function4;
            m1917BottomAppBare3WI5M(modifier2, containerColor2, contentColor2, tonalElevation2, contentPadding2, windowInsets2, scrollBehavior2, ComposableLambdaKt.rememberComposableLambda(1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope $this$BottomAppBar, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C709@36894L184,716@37127L303:AppBar.kt#uh7d8r");
                    int $dirty2 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty2 |= $composer3.changed($this$BottomAppBar) ? 4 : 2;
                    }
                    if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1566394874, $dirty2, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:709)");
                        }
                        Modifier modifier$iv = RowScope.CC.weight$default($this$BottomAppBar, Modifier.INSTANCE, 1.0f, false, 2, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function7 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        function7.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (function4 != null) {
                            Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, AppBarKt.FABVerticalPadding, AppBarKt.FABHorizontalPadding, 0.0f, 9, null);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            Function2<Composer, Integer, Unit> function8 = function4;
                            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv2 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(constructor2);
                            } else {
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i11 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1859789624, "C725@37398L22:AppBar.kt#uh7d8r");
                            function8.invoke($composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 12582912 | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (($dirty >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function6;
            scrollBehavior3 = scrollBehavior2;
            modifier3 = modifier2;
            tonalElevation3 = tonalElevation2;
            windowInsets3 = windowInsets2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            contentPadding3 = contentPadding2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final float f2 = tonalElevation3;
            final PaddingValues paddingValues = contentPadding3;
            final WindowInsets windowInsets4 = windowInsets3;
            final BottomAppBarScrollBehavior bottomAppBarScrollBehavior = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$3
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

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.m1918BottomAppBarqhFBPw4(function3, modifier4, function7, j, j2, f2, paddingValues, windowInsets4, bottomAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    public static final void m1915BottomAppBar1oL4kX8(Modifier modifier, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        PaddingValues contentPadding2;
        WindowInsets windowInsets2;
        Modifier.Companion modifier2;
        int $dirty;
        PaddingValues contentPadding3;
        WindowInsets windowInsets3;
        Modifier modifier3;
        PaddingValues contentPadding4;
        WindowInsets windowInsets4;
        long containerColor3;
        long contentColor3;
        float tonalElevation3;
        Composer $composer2 = $composer.startRestartGroup(-1391700845);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)759@39099L14,760@39141L31,763@39367L12,765@39430L266:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer2.changed(containerColor2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 3072) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty2 |= $composer2.changed(tonalElevation2) ? 2048 : 1024;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            contentPadding2 = contentPadding;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 16384 : 8192;
        } else {
            contentPadding2 = contentPadding;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                windowInsets2 = windowInsets;
                int i7 = $composer2.changed(windowInsets2) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty2 |= i7;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentColor3 = contentColor2;
            tonalElevation3 = tonalElevation2;
            contentPadding4 = contentPadding2;
            windowInsets4 = windowInsets2;
            modifier3 = modifier;
            containerColor3 = containerColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty2 >> 3) & 14);
                    $dirty2 &= -897;
                }
                if (i5 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1940getContainerElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    contentPadding2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                }
                if ((i & 32) != 0) {
                    windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty = $dirty2 & (-458753);
                    contentPadding3 = contentPadding2;
                } else {
                    $dirty = $dirty2;
                    contentPadding3 = contentPadding2;
                    windowInsets3 = windowInsets2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    contentPadding3 = contentPadding2;
                    windowInsets3 = windowInsets2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    contentPadding3 = contentPadding2;
                    windowInsets3 = windowInsets2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1391700845, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:765)");
            }
            m1917BottomAppBare3WI5M(modifier2, containerColor2, contentColor2, tonalElevation2, contentPadding3, windowInsets3, null, function3, $composer2, ($dirty & 14) | 1572864 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (29360128 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            contentPadding4 = contentPadding3;
            windowInsets4 = windowInsets3;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            tonalElevation3 = tonalElevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final float f = tonalElevation3;
            final PaddingValues paddingValues = contentPadding4;
            final WindowInsets windowInsets5 = windowInsets4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$4
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

                public final void invoke(Composer composer, int i8) {
                    AppBarKt.m1915BottomAppBar1oL4kX8(modifier4, j, j2, f, paddingValues, windowInsets5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: BottomAppBar-e-3WI5M, reason: not valid java name */
    public static final void m1917BottomAppBare3WI5M(Modifier modifier, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, BottomAppBarScrollBehavior scrollBehavior, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        PaddingValues contentPadding2;
        Modifier.Companion modifier2;
        final WindowInsets windowInsets2;
        final BottomAppBarScrollBehavior scrollBehavior2;
        int $dirty;
        final PaddingValues contentPadding3;
        Modifier.Companion appBarDragModifier;
        Object value$iv;
        Modifier modifier3;
        PaddingValues contentPadding4;
        WindowInsets windowInsets3;
        long containerColor3;
        long contentColor3;
        BottomAppBarScrollBehavior scrollBehavior3;
        float tonalElevation3;
        Object value$iv2;
        AppBarKt$BottomAppBar$appBarDragModifier$2$1 value$iv3;
        Composer $composer2 = $composer.startRestartGroup(422438773);
        ComposerKt.sourceInformation($composer2, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp,3,7,5)809@41706L14,810@41748L31,813@41974L12,845@43308L5,847@43363L577,860@43985L381,840@43041L1325:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer2.changed(containerColor2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 3072) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty2 |= $composer2.changed(tonalElevation2) ? 2048 : 1024;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            contentPadding2 = contentPadding;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 16384 : 8192;
        } else {
            contentPadding2 = contentPadding;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(windowInsets)) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(scrollBehavior) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            windowInsets3 = windowInsets;
            scrollBehavior3 = scrollBehavior;
            contentColor3 = contentColor2;
            tonalElevation3 = tonalElevation2;
            contentPadding4 = contentPadding2;
            containerColor3 = containerColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty2 >> 3) & 14);
                    $dirty2 &= -897;
                }
                if (i5 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1940getContainerElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    contentPadding2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                }
                if ((i & 32) != 0) {
                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty2 &= -458753;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i7 != 0) {
                    scrollBehavior2 = null;
                    $dirty = $dirty2;
                    contentPadding3 = contentPadding2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    $dirty = $dirty2;
                    contentPadding3 = contentPadding2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 32) != 0) {
                    windowInsets2 = windowInsets;
                    scrollBehavior2 = scrollBehavior;
                    $dirty = (-458753) & $dirty2;
                    contentPadding3 = contentPadding2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    scrollBehavior2 = scrollBehavior;
                    $dirty = $dirty2;
                    contentPadding3 = contentPadding2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(422438773, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:816)");
            }
            $composer2.startReplaceGroup(1291877193);
            ComposerKt.sourceInformation($composer2, "821@42394L83,821@42371L106,824@42507L261");
            if (scrollBehavior2 == null || scrollBehavior2.getIsPinned()) {
                appBarDragModifier = Modifier.INSTANCE;
            } else {
                Modifier.Companion companion = Modifier.INSTANCE;
                Orientation orientation = Orientation.Vertical;
                ComposerKt.sourceInformationMarkerStart($composer2, 1291877370, "CC(remember):AppBar.kt#9igjgp");
                boolean invalid$iv = ($dirty & 3670016) == 1048576;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float delta) {
                            BottomAppBarState state = scrollBehavior2.getState();
                            state.setHeightOffset(state.getHeightOffset() - delta);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) value$iv2, $composer2, 0);
                Modifier.Companion companion2 = companion;
                ComposerKt.sourceInformationMarkerStart($composer2, 1291877483, "CC(remember):AppBar.kt#9igjgp");
                boolean invalid$iv2 = ($dirty & 3670016) == 1048576;
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new AppBarKt$BottomAppBar$appBarDragModifier$2$1(scrollBehavior2, null);
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                appBarDragModifier = DraggableKt.draggable(companion2, draggableStateRememberDraggableState, orientation, (188 & 4) != 0, (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : false, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) value$iv3, (188 & 128) != 0 ? false : false);
            }
            $composer2.endReplaceGroup();
            Shape value = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1291878339, "CC(remember):AppBar.kt#9igjgp");
            boolean invalid$iv3 = (3670016 & $dirty) == 1048576;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1929invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m1929invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                        BottomAppBarState state;
                        BottomAppBarScrollBehavior bottomAppBarScrollBehavior = scrollBehavior2;
                        BottomAppBarState state2 = bottomAppBarScrollBehavior != null ? bottomAppBarScrollBehavior.getState() : null;
                        if (state2 != null) {
                            state2.setHeightOffsetLimit(-$this$layout.mo567toPx0680j_4(BottomAppBarTokens.INSTANCE.m3117getContainerHeightD9Ej5fM()));
                        }
                        final Placeable placeable = measurable.mo5644measureBRTryo0(constraints);
                        float height = placeable.getHeight();
                        BottomAppBarScrollBehavior bottomAppBarScrollBehavior2 = scrollBehavior2;
                        float height2 = height + ((bottomAppBarScrollBehavior2 == null || (state = bottomAppBarScrollBehavior2.getState()) == null) ? 0.0f : state.getHeightOffset());
                        return MeasureScope.CC.layout$default($this$layout, placeable.getWidth(), MathKt.roundToInt(height2), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                Placeable.PlacementScope.place$default($this$layout2, placeable, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            modifier3 = modifier2;
            contentPadding4 = contentPadding3;
            SurfaceKt.m2666SurfaceT9BRK9s(LayoutModifierKt.layout(modifier2, (Function3) value$iv).then(appBarDragModifier), value, containerColor2, contentColor2, tonalElevation2, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C861@43995L365:AppBar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1243053520, $changed2, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:861)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(SizeKt.m899height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets2), BottomAppBarTokens.INSTANCE.m3117getContainerHeightD9Ej5fM()), contentPadding3);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        function4.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty << 3) & 896) | 12582912 | (($dirty << 3) & 7168) | (57344 & ($dirty << 3)), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets3 = windowInsets2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            scrollBehavior3 = scrollBehavior2;
            tonalElevation3 = tonalElevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final float f = tonalElevation3;
            final PaddingValues paddingValues = contentPadding4;
            final WindowInsets windowInsets4 = windowInsets3;
            final BottomAppBarScrollBehavior bottomAppBarScrollBehavior = scrollBehavior3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$7
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

                public final void invoke(Composer composer, int i8) {
                    AppBarKt.m1917BottomAppBare3WI5M(modifier4, j, j2, f, paddingValues, windowInsets4, bottomAppBarScrollBehavior, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final TopAppBarState rememberTopAppBarState(final float initialHeightOffsetLimit, final float initialHeightOffset, final float initialContentOffset, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1801969826, "C(rememberTopAppBarState)P(2,1)1248@61280L145,1248@61233L192:AppBar.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialHeightOffsetLimit = -3.4028235E38f;
        }
        if ((i & 2) != 0) {
            initialHeightOffset = 0.0f;
        }
        if ((i & 4) != 0) {
            initialContentOffset = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, $changed, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1247)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart($composer, 1171254342, "CC(remember):AppBar.kt#9igjgp");
        boolean invalid$iv = (((($changed & 896) ^ 384) > 256 && $composer.changed(initialContentOffset)) || ($changed & 384) == 256) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialHeightOffsetLimit)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialHeightOffset)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<TopAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TopAppBarState invoke() {
                    return new TopAppBarState(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return topAppBarState;
    }

    public static final BottomAppBarState rememberBottomAppBarState(final float initialHeightOffsetLimit, final float initialHeightOffset, final float initialContentOffset, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1420874240, "C(rememberBottomAppBarState)P(2,1)1569@73909L148,1569@73859L198:AppBar.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialHeightOffsetLimit = -3.4028235E38f;
        }
        if ((i & 2) != 0) {
            initialHeightOffset = 0.0f;
        }
        if ((i & 4) != 0) {
            initialContentOffset = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420874240, $changed, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:1568)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomAppBarState, ?> saver = BottomAppBarState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart($composer, 647596625, "CC(remember):AppBar.kt#9igjgp");
        boolean invalid$iv = (((($changed & 896) ^ 384) > 256 && $composer.changed(initialContentOffset)) || ($changed & 384) == 256) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialHeightOffsetLimit)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialHeightOffset)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<BottomAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomAppBarState invoke() {
                    return AppBarKt.BottomAppBarState(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BottomAppBarState bottomAppBarState = (BottomAppBarState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return bottomAppBarState;
    }

    public static final BottomAppBarState BottomAppBarState(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset) {
        return new BottomAppBarStateImpl(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:40:0x0101  */
    /* JADX WARN: Code duplicated, block: B:43:0x0126 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0127  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object settleAppBarBottom(final BottomAppBarState state, float velocity, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        C12111 c12111;
        AnimationSpec<Float> animationSpec2;
        Ref.FloatRef remainingVelocity;
        final BottomAppBarState state2;
        BottomAppBarState state3;
        AnimationSpec<Float> animationSpec3;
        Ref.FloatRef remainingVelocity2;
        AnimationState animationStateAnimationState$default;
        float heightOffsetLimit;
        Float fBoxFloat;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        Ref.FloatRef remainingVelocity3;
        if (continuation instanceof C12111) {
            c12111 = (C12111) continuation;
            if ((c12111.label & Integer.MIN_VALUE) != 0) {
                c12111.label -= Integer.MIN_VALUE;
            } else {
                c12111 = new C12111(continuation);
            }
        } else {
            c12111 = new C12111(continuation);
        }
        C12111 c12112 = c12111;
        Object $result = c12112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c12112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (state.getCollapsedFraction() >= 0.01f) {
                    if (!(state.getCollapsedFraction() == 1.0f)) {
                        final Ref.FloatRef remainingVelocity4 = new Ref.FloatRef();
                        remainingVelocity4.element = velocity;
                        if (decayAnimationSpec != null && Math.abs(velocity) > 1.0f) {
                            final Ref.FloatRef lastValue = new Ref.FloatRef();
                            AnimationState animationStateAnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, velocity, 0L, 0L, false, 28, null);
                            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function2 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBarBottom.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    float delta = animationScope.getValue().floatValue() - lastValue.element;
                                    float initialHeightOffset = state.getHeightOffset();
                                    state.setHeightOffset(initialHeightOffset + delta);
                                    float consumed = Math.abs(initialHeightOffset - state.getHeightOffset());
                                    lastValue.element = animationScope.getValue().floatValue();
                                    remainingVelocity4.element = animationScope.getVelocity().floatValue();
                                    if (Math.abs(delta - consumed) > 0.5f) {
                                        animationScope.cancelAnimation();
                                    }
                                }
                            };
                            c12112.L$0 = state;
                            c12112.L$1 = animationSpec;
                            c12112.L$2 = remainingVelocity4;
                            c12112.label = 1;
                            if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default2, decayAnimationSpec, false, function2, c12112, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            state3 = state;
                            animationSpec3 = animationSpec;
                            remainingVelocity2 = remainingVelocity4;
                            remainingVelocity = remainingVelocity2;
                            state2 = state3;
                            animationSpec2 = animationSpec3;
                        } else {
                            animationSpec2 = animationSpec;
                            remainingVelocity = remainingVelocity4;
                            state2 = state;
                        }
                        if (animationSpec2 != null && state2.getHeightOffset() < 0.0f && state2.getHeightOffset() > state2.getHeightOffsetLimit()) {
                            animationStateAnimationState$default = AnimationStateKt.AnimationState$default(state2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                            if (state2.getCollapsedFraction() < 0.5f) {
                                heightOffsetLimit = 0.0f;
                            } else {
                                heightOffsetLimit = state2.getHeightOffsetLimit();
                            }
                            fBoxFloat = Boxing.boxFloat(heightOffsetLimit);
                            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBarBottom.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    state2.setHeightOffset(animationScope.getValue().floatValue());
                                }
                            };
                            c12112.L$0 = remainingVelocity;
                            c12112.L$1 = null;
                            c12112.L$2 = null;
                            c12112.label = 2;
                            if (SuspendAnimationKt.animateTo(animationStateAnimationState$default, fBoxFloat, (4 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec2, (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? SuspendAnimationKt.C02582.INSTANCE : function1, c12112) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            remainingVelocity3 = remainingVelocity;
                            remainingVelocity = remainingVelocity3;
                        }
                        return Velocity.m7033boximpl(VelocityKt.Velocity(0.0f, remainingVelocity.element));
                    }
                }
                return Velocity.m7033boximpl(Velocity.INSTANCE.m7053getZero9UxMQ8M());
            case 1:
                remainingVelocity2 = (Ref.FloatRef) c12112.L$2;
                animationSpec3 = (AnimationSpec) c12112.L$1;
                state3 = (BottomAppBarState) c12112.L$0;
                ResultKt.throwOnFailure($result);
                remainingVelocity = remainingVelocity2;
                state2 = state3;
                animationSpec2 = animationSpec3;
                if (animationSpec2 != null) {
                    animationStateAnimationState$default = AnimationStateKt.AnimationState$default(state2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    if (state2.getCollapsedFraction() < 0.5f) {
                        heightOffsetLimit = 0.0f;
                    } else {
                        heightOffsetLimit = state2.getHeightOffsetLimit();
                    }
                    fBoxFloat = Boxing.boxFloat(heightOffsetLimit);
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBarBottom.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            state2.setHeightOffset(animationScope.getValue().floatValue());
                        }
                    };
                    c12112.L$0 = remainingVelocity;
                    c12112.L$1 = null;
                    c12112.L$2 = null;
                    c12112.label = 2;
                    if (SuspendAnimationKt.animateTo(animationStateAnimationState$default, fBoxFloat, (4 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec2, (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? SuspendAnimationKt.C02582.INSTANCE : function1, c12112) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    remainingVelocity3 = remainingVelocity;
                    remainingVelocity = remainingVelocity3;
                }
                return Velocity.m7033boximpl(VelocityKt.Velocity(0.0f, remainingVelocity.element));
            case 2:
                remainingVelocity3 = (Ref.FloatRef) c12112.L$0;
                ResultKt.throwOnFailure($result);
                remainingVelocity = remainingVelocity3;
                return Velocity.m7033boximpl(VelocityKt.Velocity(0.0f, remainingVelocity.element));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        float arg0$iv = C1979Dp.m6801constructorimpl(16);
        float other$iv = C1979Dp.m6801constructorimpl(12);
        BottomAppBarHorizontalPadding = C1979Dp.m6801constructorimpl(arg0$iv - other$iv);
        float arg0$iv2 = C1979Dp.m6801constructorimpl(16);
        float other$iv2 = C1979Dp.m6801constructorimpl(12);
        BottomAppBarVerticalPadding = C1979Dp.m6801constructorimpl(arg0$iv2 - other$iv2);
        float arg0$iv3 = C1979Dp.m6801constructorimpl(16);
        float other$iv3 = BottomAppBarHorizontalPadding;
        FABHorizontalPadding = C1979Dp.m6801constructorimpl(arg0$iv3 - other$iv3);
        float arg0$iv4 = C1979Dp.m6801constructorimpl(12);
        float other$iv4 = BottomAppBarVerticalPadding;
        FABVerticalPadding = C1979Dp.m6801constructorimpl(arg0$iv4 - other$iv4);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = C1979Dp.m6801constructorimpl(24);
        LargeTitleBottomPadding = C1979Dp.m6801constructorimpl(28);
        TopAppBarHorizontalPadding = C1979Dp.m6801constructorimpl(4);
        float arg0$iv5 = C1979Dp.m6801constructorimpl(16);
        float other$iv5 = TopAppBarHorizontalPadding;
        TopAppBarTitleInset = C1979Dp.m6801constructorimpl(arg0$iv5 - other$iv5);
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:114:0x0150 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0152  */
    /* JADX WARN: Code duplicated, block: B:116:0x0158  */
    /* JADX WARN: Code duplicated, block: B:119:0x015f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0175  */
    /* JADX WARN: Code duplicated, block: B:124:0x017e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0181  */
    /* JADX WARN: Code duplicated, block: B:128:0x0187  */
    /* JADX WARN: Code duplicated, block: B:129:0x0189  */
    /* JADX WARN: Code duplicated, block: B:131:0x018c  */
    /* JADX WARN: Code duplicated, block: B:133:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x0222  */
    /* JADX WARN: Code duplicated, block: B:146:0x023a  */
    /* JADX WARN: Code duplicated, block: B:149:0x0297  */
    /* JADX WARN: Code duplicated, block: B:174:0x0335  */
    /* JADX WARN: Code duplicated, block: B:177:0x038e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0397  */
    /* JADX WARN: Code duplicated, block: B:181:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:183:0x03c4  */
    /* JADX INFO: renamed from: SingleRowTopAppBar-cJHQLPU, reason: not valid java name */
    public static final void m1922SingleRowTopAppBarcJHQLPU(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle titleTextStyle, final boolean centeredTitle, final Function2<? super Composer, ? super Integer, Unit> function3, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, final float expandedHeight, final WindowInsets windowInsets, final TopAppBarColors colors, final TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int i2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        boolean z;
        boolean z2;
        boolean invalid$iv;
        Object value$iv;
        Object it$iv;
        Object value$iv2;
        Modifier.Companion companionDraggable;
        Modifier modifier5;
        Composer $composer2;
        Object value$iv3;
        Object value$iv4;
        boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer $composer3 = $composer.startRestartGroup(-342194911);
        ComposerKt.sourceInformation($composer3, "C(SingleRowTopAppBar)P(4,7,8,1,5!1,3:c#ui.unit.Dp,9)*1836@84060L7,1839@84140L284,1839@84129L295,1851@84824L281,1858@85138L166,1864@85379L173,1896@86659L999,1896@86575L1083:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(titleTextStyle) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(centeredTitle) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer3.changedInstance(function4) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(expandedHeight) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(windowInsets) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(colors) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) == 0) {
            if ((805306368 & $changed) == 0) {
                i2 = $composer3.changed(scrollBehavior) ? 536870912 : 268435456;
            }
            $dirty = $dirty2;
            if ((306783379 & $dirty) == 306783378 || !$composer3.getSkipping()) {
                if (i3 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-342194911, $dirty, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1832)");
                }
                modifier4 = modifier3;
                if (!Float.isNaN(expandedHeight)) {
                    if (expandedHeight == Float.POSITIVE_INFINITY) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$SingleRowTopAppBar_cJHQLPU_u24lambda_u246 = (Density) objConsume;
                final float fCoerceAtLeast = RangesKt.coerceAtLeast($this$SingleRowTopAppBar_cJHQLPU_u24lambda_u246.mo567toPx0680j_4(expandedHeight), 0.0f);
                ComposerKt.sourceInformationMarkerStart($composer3, -1008340748, "CC(remember):AppBar.kt#9igjgp");
                if (($dirty & 1879048192) == 536870912) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                invalid$iv = z2 | $composer3.changed(fCoerceAtLeast);
                Object it$iv2 = $composer3.rememberedValue();
                if (!invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2$1
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
                            TopAppBarState state;
                            TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                            if (!Intrinsics.areEqual((topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? null : Float.valueOf(state.getHeightOffsetLimit()), -fCoerceAtLeast)) {
                                TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior;
                                TopAppBarState state2 = topAppBarScrollBehavior2 != null ? topAppBarScrollBehavior2.getState() : null;
                                if (state2 == null) {
                                    return;
                                }
                                state2.setHeightOffsetLimit(-fCoerceAtLeast);
                            }
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.SideEffect((Function0) value$iv, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, -1008340064, "CC(remember):AppBar.kt#9igjgp");
                it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            TopAppBarState state;
                            TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                            float overlappingFraction = (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction();
                            return Float.valueOf(overlappingFraction > 0.01f ? 1.0f : 0.0f);
                        }
                    });
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                State colorTransitionFraction$delegate = (State) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                State<Color> stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(colors.m2965containerColorvNxB06k$material3_release(SingleRowTopAppBar_cJHQLPU$lambda$9(colorTransitionFraction$delegate)), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, $composer3, 48, 12);
                Function2 actionsRow = ComposableLambdaKt.rememberComposableLambda(1370231018, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C1865@85389L157:AppBar.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1370231018, $changed2, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1865)");
                            }
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                            int $changed$iv$iv = (432 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(constructor);
                            } else {
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i4 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            function5.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54);
                $composer3.startReplaceGroup(-1008339213);
                ComposerKt.sourceInformation($composer3, "1876@85852L83,1876@85829L106,1879@85965L255");
                if (scrollBehavior != null || scrollBehavior.getIsPinned()) {
                    companionDraggable = Modifier.INSTANCE;
                } else {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Orientation orientation = Orientation.Vertical;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1008339036, "CC(remember):AppBar.kt#9igjgp");
                    boolean invalid$iv2 = ($dirty & 1879048192) == 536870912;
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                                invoke(f.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float delta) {
                                TopAppBarState state = scrollBehavior.getState();
                                state.setHeightOffset(state.getHeightOffset() + delta);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) value$iv3, $composer3, 0);
                    Modifier.Companion companion2 = companion;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1008338923, "CC(remember):AppBar.kt#9igjgp");
                    boolean invalid$iv3 = ($dirty & 1879048192) == 536870912;
                    Object it$iv4 = $composer3.rememberedValue();
                    if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = new AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1(scrollBehavior, null);
                        $composer3.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    companionDraggable = DraggableKt.draggable(companion2, draggableStateRememberDraggableState, orientation, (188 & 4) != 0, (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : false, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) value$iv4, (188 & 128) != 0 ? false : false);
                }
                $composer3.endReplaceGroup();
                Modifier appBarDragModifier = companionDraggable;
                modifier5 = modifier4;
                $composer2 = $composer3;
                SurfaceKt.m2666SurfaceT9BRK9s(modifier4.then(appBarDragModifier), null, SingleRowTopAppBar_cJHQLPU$lambda$10(stateM351animateColorAsStateeuL9pac), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1943739546, true, new AppBarKt$SingleRowTopAppBar$3(windowInsets, expandedHeight, scrollBehavior, colors, function2, titleTextStyle, centeredTitle, function3, actionsRow), $composer2, 54), $composer2, 12582912, 122);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                modifier5 = modifier2;
                $composer2 = $composer3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$4
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

                    public final void invoke(Composer composer, int i4) {
                        AppBarKt.m1922SingleRowTopAppBarcJHQLPU(modifier6, function2, titleTextStyle, centeredTitle, function3, function4, expandedHeight, windowInsets, colors, scrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 805306368;
        $dirty2 |= i2;
        $dirty = $dirty2;
        if ((306783379 & $dirty) == 306783378) {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-342194911, $dirty, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1832)");
            }
            modifier4 = modifier3;
            if (!Float.isNaN(expandedHeight)) {
                z = false;
            } else {
                if (expandedHeight == Float.POSITIVE_INFINITY) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (!z) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
            }
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$SingleRowTopAppBar_cJHQLPU_u24lambda_u247 = (Density) objConsume2;
            final float fCoerceAtLeast2 = RangesKt.coerceAtLeast($this$SingleRowTopAppBar_cJHQLPU_u24lambda_u247.mo567toPx0680j_4(expandedHeight), 0.0f);
            ComposerKt.sourceInformationMarkerStart($composer3, -1008340748, "CC(remember):AppBar.kt#9igjgp");
            if (($dirty & 1879048192) == 536870912) {
                z2 = true;
            } else {
                z2 = false;
            }
            invalid$iv = z2 | $composer3.changed(fCoerceAtLeast2);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2$1
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
                    TopAppBarState state;
                    TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                    if (!Intrinsics.areEqual((topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? null : Float.valueOf(state.getHeightOffsetLimit()), -fCoerceAtLeast2)) {
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior;
                        TopAppBarState state2 = topAppBarScrollBehavior2 != null ? topAppBarScrollBehavior2.getState() : null;
                        if (state2 == null) {
                            return;
                        }
                        state2.setHeightOffsetLimit(-fCoerceAtLeast2);
                    }
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.SideEffect((Function0) value$iv, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -1008340064, "CC(remember):AppBar.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        TopAppBarState state;
                        TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                        float overlappingFraction = (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction();
                        return Float.valueOf(overlappingFraction > 0.01f ? 1.0f : 0.0f);
                    }
                });
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            State colorTransitionFraction$delegate2 = (State) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State<Color> stateM351animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(colors.m2965containerColorvNxB06k$material3_release(SingleRowTopAppBar_cJHQLPU$lambda$9(colorTransitionFraction$delegate2)), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, $composer3, 48, 12);
            Function2 actionsRow2 = ComposableLambdaKt.rememberComposableLambda(1370231018, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1865@85389L157:AppBar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1370231018, $changed2, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1865)");
                        }
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(constructor);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        function5.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54);
            $composer3.startReplaceGroup(-1008339213);
            ComposerKt.sourceInformation($composer3, "1876@85852L83,1876@85829L106,1879@85965L255");
            if (scrollBehavior != null) {
                companionDraggable = Modifier.INSTANCE;
            } else {
                companionDraggable = Modifier.INSTANCE;
            }
            $composer3.endReplaceGroup();
            Modifier appBarDragModifier2 = companionDraggable;
            modifier5 = modifier4;
            $composer2 = $composer3;
            SurfaceKt.m2666SurfaceT9BRK9s(modifier4.then(appBarDragModifier2), null, SingleRowTopAppBar_cJHQLPU$lambda$10(stateM351animateColorAsStateeuL9pac2), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1943739546, true, new AppBarKt$SingleRowTopAppBar$3(windowInsets, expandedHeight, scrollBehavior, colors, function2, titleTextStyle, centeredTitle, function3, actionsRow2), $composer2, 54), $composer2, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-342194911, $dirty, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1832)");
            }
            modifier4 = modifier3;
            if (!Float.isNaN(expandedHeight)) {
                z = false;
            } else {
                if (expandedHeight == Float.POSITIVE_INFINITY) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (!z) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
            }
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$SingleRowTopAppBar_cJHQLPU_u24lambda_u248 = (Density) objConsume3;
            final float fCoerceAtLeast3 = RangesKt.coerceAtLeast($this$SingleRowTopAppBar_cJHQLPU_u24lambda_u248.mo567toPx0680j_4(expandedHeight), 0.0f);
            ComposerKt.sourceInformationMarkerStart($composer3, -1008340748, "CC(remember):AppBar.kt#9igjgp");
            if (($dirty & 1879048192) == 536870912) {
                z2 = true;
            } else {
                z2 = false;
            }
            invalid$iv = z2 | $composer3.changed(fCoerceAtLeast3);
            Object it$iv6 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2$1
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
                    TopAppBarState state;
                    TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                    if (!Intrinsics.areEqual((topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? null : Float.valueOf(state.getHeightOffsetLimit()), -fCoerceAtLeast3)) {
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior;
                        TopAppBarState state2 = topAppBarScrollBehavior2 != null ? topAppBarScrollBehavior2.getState() : null;
                        if (state2 == null) {
                            return;
                        }
                        state2.setHeightOffsetLimit(-fCoerceAtLeast3);
                    }
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.SideEffect((Function0) value$iv, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -1008340064, "CC(remember):AppBar.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        TopAppBarState state;
                        TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                        float overlappingFraction = (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction();
                        return Float.valueOf(overlappingFraction > 0.01f ? 1.0f : 0.0f);
                    }
                });
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            State colorTransitionFraction$delegate3 = (State) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State<Color> stateM351animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(colors.m2965containerColorvNxB06k$material3_release(SingleRowTopAppBar_cJHQLPU$lambda$9(colorTransitionFraction$delegate3)), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, $composer3, 48, 12);
            Function2 actionsRow3 = ComposableLambdaKt.rememberComposableLambda(1370231018, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1865@85389L157:AppBar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1370231018, $changed2, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1865)");
                        }
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(constructor);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        function5.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54);
            $composer3.startReplaceGroup(-1008339213);
            ComposerKt.sourceInformation($composer3, "1876@85852L83,1876@85829L106,1879@85965L255");
            if (scrollBehavior != null) {
                companionDraggable = Modifier.INSTANCE;
            } else {
                companionDraggable = Modifier.INSTANCE;
            }
            $composer3.endReplaceGroup();
            Modifier appBarDragModifier3 = companionDraggable;
            modifier5 = modifier4;
            $composer2 = $composer3;
            SurfaceKt.m2666SurfaceT9BRK9s(modifier4.then(appBarDragModifier3), null, SingleRowTopAppBar_cJHQLPU$lambda$10(stateM351animateColorAsStateeuL9pac3), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1943739546, true, new AppBarKt$SingleRowTopAppBar$3(windowInsets, expandedHeight, scrollBehavior, colors, function2, titleTextStyle, centeredTitle, function3, actionsRow3), $composer2, 54), $composer2, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$4
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

                public final void invoke(Composer composer, int i4) {
                    AppBarKt.m1922SingleRowTopAppBarcJHQLPU(modifier7, function2, titleTextStyle, centeredTitle, function3, function4, expandedHeight, windowInsets, colors, scrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final float SingleRowTopAppBar_cJHQLPU$lambda$9(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final long SingleRowTopAppBar_cJHQLPU$lambda$10(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:110:0x014e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0153  */
    /* JADX WARN: Code duplicated, block: B:113:0x0157  */
    /* JADX WARN: Code duplicated, block: B:115:0x015f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0162  */
    /* JADX WARN: Code duplicated, block: B:118:0x0167  */
    /* JADX WARN: Code duplicated, block: B:121:0x016d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0170  */
    /* JADX WARN: Code duplicated, block: B:124:0x0174  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0183  */
    /* JADX WARN: Code duplicated, block: B:132:0x0186  */
    /* JADX WARN: Code duplicated, block: B:134:0x018a  */
    /* JADX WARN: Code duplicated, block: B:136:0x0190  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:148:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:154:0x01da  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:160:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:161:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:163:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:165:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:167:0x0208  */
    /* JADX WARN: Code duplicated, block: B:168:0x020b  */
    /* JADX WARN: Code duplicated, block: B:171:0x0211  */
    /* JADX WARN: Code duplicated, block: B:172:0x0213  */
    /* JADX WARN: Code duplicated, block: B:174:0x0216  */
    /* JADX WARN: Code duplicated, block: B:176:0x021c  */
    /* JADX WARN: Code duplicated, block: B:177:0x021e  */
    /* JADX WARN: Code duplicated, block: B:179:0x0221  */
    /* JADX WARN: Code duplicated, block: B:181:0x027f  */
    /* JADX WARN: Code duplicated, block: B:182:0x0281  */
    /* JADX WARN: Code duplicated, block: B:185:0x029b  */
    /* JADX WARN: Code duplicated, block: B:189:0x02a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:193:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:196:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:199:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:200:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:202:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:203:0x0302  */
    /* JADX WARN: Code duplicated, block: B:206:0x0313  */
    /* JADX WARN: Code duplicated, block: B:232:0x03be  */
    /* JADX WARN: Code duplicated, block: B:235:0x041b  */
    /* JADX WARN: Code duplicated, block: B:239:0x0426  */
    /* JADX WARN: Code duplicated, block: B:240:0x045f  */
    /* JADX WARN: Code duplicated, block: B:242:0x0466  */
    /* JADX WARN: Code duplicated, block: B:244:0x0476  */
    /* JADX WARN: Code duplicated, block: B:246:0x0486  */
    /* JADX INFO: renamed from: TwoRowsTopAppBar-nS6u9G4, reason: not valid java name */
    public static final void m1925TwoRowsTopAppBarnS6u9G4(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle titleTextStyle, final float titleBottomPadding, final Function2<? super Composer, ? super Integer, Unit> function3, final TextStyle smallTitleTextStyle, final Function2<? super Composer, ? super Integer, Unit> function4, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5, final float collapsedHeight, final float expandedHeight, final WindowInsets windowInsets, final TopAppBarColors colors, final TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        Modifier.Companion modifier2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean invalid$iv;
        Object value$iv;
        float colorTransitionFraction;
        boolean hideTopRowSemantics;
        boolean hideBottomRowSemantics;
        int $dirty1;
        Modifier.Companion appBarDragModifier;
        Modifier modifier3;
        Object value$iv2;
        AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 value$iv3;
        TopAppBarState state;
        boolean z5;
        boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer $composer2 = $composer.startRestartGroup(1169193376);
        ComposerKt.sourceInformation($composer2, "C(TwoRowsTopAppBar)P(4,9,11,10:c#ui.unit.Dp,7,8,5!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp,12)*1954@88861L7,1962@89190L205,1962@89179L216,1977@90018L173,2011@91416L2231,2011@91332L2315:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty2 = $changed1;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(titleTextStyle) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(titleBottomPadding) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(smallTitleTextStyle) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(collapsedHeight) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) == 0) {
            if ((805306368 & $changed) == 0) {
                i2 = $composer2.changed(expandedHeight) ? 536870912 : 268435456;
            }
            if ((i & 1024) != 0) {
                $dirty2 |= 6;
            } else if (($changed1 & 6) != 0) {
                if ($composer2.changed(windowInsets)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                $dirty2 |= i3;
            }
            if ((i & 2048) != 0) {
                $dirty2 |= 48;
            } else if (($changed1 & 48) == 0) {
                $dirty2 |= $composer2.changed(colors) ? 32 : 16;
            }
            if ((i & 4096) != 0) {
                $dirty2 |= 384;
            } else if (($changed1 & 384) == 0) {
                $dirty2 |= $composer2.changed(scrollBehavior) ? 256 : 128;
            }
            if ((306783379 & $dirty) != 306783378 && ($dirty2 & 147) == 146 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
                modifier3 = modifier;
                $dirty1 = $dirty2;
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1169193376, $dirty, $dirty2, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1941)");
                }
                if (!Float.isNaN(collapsedHeight)) {
                    if (collapsedHeight == Float.POSITIVE_INFINITY) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (!z6) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
                }
                if (!Float.isNaN(expandedHeight)) {
                    if (expandedHeight == Float.POSITIVE_INFINITY) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
                }
                if (C1979Dp.m6800compareTo0680j_4(expandedHeight, collapsedHeight) >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    throw new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
                }
                final Ref.FloatRef expandedHeightPx = new Ref.FloatRef();
                final Ref.FloatRef collapsedHeightPx = new Ref.FloatRef();
                Ref.IntRef titleBottomPaddingPx = new Ref.IntRef();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416 = (Density) objConsume;
                expandedHeightPx.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416.mo567toPx0680j_4(expandedHeight);
                collapsedHeightPx.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416.mo567toPx0680j_4(collapsedHeight);
                titleBottomPaddingPx.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2416.mo561roundToPx0680j_4(titleBottomPadding);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -1609630207, "CC(remember):AppBar.kt#9igjgp");
                if (($dirty2 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                invalid$iv = z4 | $composer2.changed(collapsedHeightPx.element) | $composer2.changed(expandedHeightPx.element);
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$5$1
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
                            TopAppBarState state2;
                            TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                            if (!Intrinsics.areEqual((topAppBarScrollBehavior == null || (state2 = topAppBarScrollBehavior.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), collapsedHeightPx.element - expandedHeightPx.element)) {
                                TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior;
                                TopAppBarState state3 = topAppBarScrollBehavior2 != null ? topAppBarScrollBehavior2.getState() : null;
                                if (state3 == null) {
                                    return;
                                }
                                state3.setHeightOffsetLimit(collapsedHeightPx.element - expandedHeightPx.element);
                            }
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.SideEffect((Function0) value$iv, $composer2, 0);
                if (scrollBehavior != null || (state = scrollBehavior.getState()) == null) {
                    colorTransitionFraction = 0.0f;
                } else {
                    colorTransitionFraction = state.getCollapsedFraction();
                }
                long appBarContainerColor = colors.m2965containerColorvNxB06k$material3_release(colorTransitionFraction);
                Function2 actionsRow = ComposableLambdaKt.rememberComposableLambda(-89435287, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
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

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C1978@90028L157:AppBar.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-89435287, $changed2, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1978)");
                            }
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function6 = function5;
                            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                            int $changed$iv$iv = (432 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(constructor);
                            } else {
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i5 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            function6.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf(((432 >> 6) & 112) | 6));
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54);
                float topTitleAlpha = TopTitleAlphaEasing.transform(colorTransitionFraction);
                float bottomTitleAlpha = 1.0f - colorTransitionFraction;
                if (colorTransitionFraction < 0.5f) {
                    hideTopRowSemantics = true;
                } else {
                    hideTopRowSemantics = false;
                }
                if (hideTopRowSemantics) {
                    hideBottomRowSemantics = false;
                } else {
                    hideBottomRowSemantics = true;
                }
                $composer2.startReplaceGroup(-1609628662);
                ComposerKt.sourceInformation($composer2, "1995@90912L83,1995@90889L106,1998@91025L255");
                if (scrollBehavior != null || scrollBehavior.getIsPinned()) {
                    $dirty1 = $dirty2;
                    appBarDragModifier = Modifier.INSTANCE;
                } else {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Orientation orientation = Orientation.Vertical;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1609628485, "CC(remember):AppBar.kt#9igjgp");
                    boolean invalid$iv2 = ($dirty2 & 896) == 256;
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                                invoke(f.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float delta) {
                                TopAppBarState state2 = scrollBehavior.getState();
                                state2.setHeightOffset(state2.getHeightOffset() + delta);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) value$iv2, $composer2, 0);
                    Modifier.Companion companion2 = companion;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1609628372, "CC(remember):AppBar.kt#9igjgp");
                    boolean invalid$iv3 = ($dirty2 & 896) == 256;
                    Object it$iv3 = $composer2.rememberedValue();
                    if (invalid$iv3) {
                        $dirty1 = $dirty2;
                    } else {
                        $dirty1 = $dirty2;
                        if (it$iv3 != Composer.INSTANCE.getEmpty()) {
                            value$iv3 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        appBarDragModifier = DraggableKt.draggable(companion2, draggableStateRememberDraggableState, orientation, (188 & 4) != 0, (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : false, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) value$iv3, (188 & 128) != 0 ? false : false);
                    }
                    value$iv3 = new AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1(scrollBehavior, null);
                    $composer2.updateRememberedValue(value$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    appBarDragModifier = DraggableKt.draggable(companion2, draggableStateRememberDraggableState, orientation, (188 & 4) != 0, (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : false, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) value$iv3, (188 & 128) != 0 ? false : false);
                }
                $composer2.endReplaceGroup();
                SurfaceKt.m2666SurfaceT9BRK9s(modifier2.then(appBarDragModifier), null, appBarContainerColor, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1350062619, true, new AppBarKt$TwoRowsTopAppBar$6(windowInsets, collapsedHeight, colors, function3, smallTitleTextStyle, topTitleAlpha, hideTopRowSemantics, function4, actionsRow, expandedHeight, scrollBehavior, function2, titleTextStyle, bottomTitleAlpha, titleBottomPaddingPx, hideBottomRowSemantics), $composer2, 54), $composer2, 12582912, 122);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$7
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

                    public final void invoke(Composer composer, int i5) {
                        AppBarKt.m1925TwoRowsTopAppBarnS6u9G4(modifier4, function2, titleTextStyle, titleBottomPadding, function3, smallTitleTextStyle, function4, function5, collapsedHeight, expandedHeight, windowInsets, colors, scrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                    }
                });
            }
        }
        i2 = 805306368;
        $dirty |= i2;
        if ((i & 1024) != 0) {
            $dirty2 |= 6;
        } else if (($changed1 & 6) != 0) {
            if ($composer2.changed(windowInsets)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            $dirty2 |= i3;
        }
        if ((i & 2048) != 0) {
            $dirty2 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty2 |= $composer2.changed(colors) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty2 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty2 |= $composer2.changed(scrollBehavior) ? 256 : 128;
        }
        if ((306783379 & $dirty) != 306783378) {
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1169193376, $dirty, $dirty2, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1941)");
            }
            if (!Float.isNaN(collapsedHeight)) {
                z = false;
            } else {
                if (collapsedHeight == Float.POSITIVE_INFINITY) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!z6) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (!z) {
                throw new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
            }
            if (!Float.isNaN(expandedHeight)) {
                z2 = false;
            } else {
                if (expandedHeight == Float.POSITIVE_INFINITY) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
            }
            if (C1979Dp.m6800compareTo0680j_4(expandedHeight, collapsedHeight) >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                throw new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
            }
            final Ref.FloatRef expandedHeightPx2 = new Ref.FloatRef();
            final Ref.FloatRef collapsedHeightPx2 = new Ref.FloatRef();
            Ref.IntRef titleBottomPaddingPx2 = new Ref.IntRef();
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2417 = (Density) objConsume2;
            expandedHeightPx2.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2417.mo567toPx0680j_4(expandedHeight);
            collapsedHeightPx2.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2417.mo567toPx0680j_4(collapsedHeight);
            titleBottomPaddingPx2.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2417.mo561roundToPx0680j_4(titleBottomPadding);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1609630207, "CC(remember):AppBar.kt#9igjgp");
            if (($dirty2 & 896) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            invalid$iv = z4 | $composer2.changed(collapsedHeightPx2.element) | $composer2.changed(expandedHeightPx2.element);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$5$1
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
                    TopAppBarState state2;
                    TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                    if (!Intrinsics.areEqual((topAppBarScrollBehavior == null || (state2 = topAppBarScrollBehavior.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), collapsedHeightPx2.element - expandedHeightPx2.element)) {
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior;
                        TopAppBarState state3 = topAppBarScrollBehavior2 != null ? topAppBarScrollBehavior2.getState() : null;
                        if (state3 == null) {
                            return;
                        }
                        state3.setHeightOffsetLimit(collapsedHeightPx2.element - expandedHeightPx2.element);
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv, $composer2, 0);
            if (scrollBehavior != null) {
                colorTransitionFraction = 0.0f;
            } else {
                colorTransitionFraction = 0.0f;
            }
            long appBarContainerColor2 = colors.m2965containerColorvNxB06k$material3_release(colorTransitionFraction);
            Function2 actionsRow2 = ComposableLambdaKt.rememberComposableLambda(-89435287, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C1978@90028L157:AppBar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-89435287, $changed2, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1978)");
                        }
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function6 = function5;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        function6.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            float topTitleAlpha2 = TopTitleAlphaEasing.transform(colorTransitionFraction);
            float bottomTitleAlpha2 = 1.0f - colorTransitionFraction;
            if (colorTransitionFraction < 0.5f) {
                hideTopRowSemantics = true;
            } else {
                hideTopRowSemantics = false;
            }
            if (hideTopRowSemantics) {
                hideBottomRowSemantics = true;
            } else {
                hideBottomRowSemantics = false;
            }
            $composer2.startReplaceGroup(-1609628662);
            ComposerKt.sourceInformation($composer2, "1995@90912L83,1995@90889L106,1998@91025L255");
            if (scrollBehavior != null) {
                $dirty1 = $dirty2;
                appBarDragModifier = Modifier.INSTANCE;
            } else {
                $dirty1 = $dirty2;
                appBarDragModifier = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            SurfaceKt.m2666SurfaceT9BRK9s(modifier2.then(appBarDragModifier), null, appBarContainerColor2, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1350062619, true, new AppBarKt$TwoRowsTopAppBar$6(windowInsets, collapsedHeight, colors, function3, smallTitleTextStyle, topTitleAlpha2, hideTopRowSemantics, function4, actionsRow2, expandedHeight, scrollBehavior, function2, titleTextStyle, bottomTitleAlpha2, titleBottomPaddingPx2, hideBottomRowSemantics), $composer2, 54), $composer2, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1169193376, $dirty, $dirty2, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1941)");
            }
            if (!Float.isNaN(collapsedHeight)) {
                z = false;
            } else {
                if (collapsedHeight == Float.POSITIVE_INFINITY) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!z6) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (!z) {
                throw new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
            }
            if (!Float.isNaN(expandedHeight)) {
                z2 = false;
            } else {
                if (expandedHeight == Float.POSITIVE_INFINITY) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
            }
            if (C1979Dp.m6800compareTo0680j_4(expandedHeight, collapsedHeight) >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                throw new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
            }
            final Ref.FloatRef expandedHeightPx3 = new Ref.FloatRef();
            final Ref.FloatRef collapsedHeightPx3 = new Ref.FloatRef();
            Ref.IntRef titleBottomPaddingPx3 = new Ref.IntRef();
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2418 = (Density) objConsume3;
            expandedHeightPx3.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2418.mo567toPx0680j_4(expandedHeight);
            collapsedHeightPx3.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2418.mo567toPx0680j_4(collapsedHeight);
            titleBottomPaddingPx3.element = $this$TwoRowsTopAppBar_nS6u9G4_u24lambda_u2418.mo561roundToPx0680j_4(titleBottomPadding);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1609630207, "CC(remember):AppBar.kt#9igjgp");
            if (($dirty2 & 896) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            invalid$iv = z4 | $composer2.changed(collapsedHeightPx3.element) | $composer2.changed(expandedHeightPx3.element);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$5$1
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
                    TopAppBarState state2;
                    TopAppBarScrollBehavior topAppBarScrollBehavior = scrollBehavior;
                    if (!Intrinsics.areEqual((topAppBarScrollBehavior == null || (state2 = topAppBarScrollBehavior.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), collapsedHeightPx3.element - expandedHeightPx3.element)) {
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = scrollBehavior;
                        TopAppBarState state3 = topAppBarScrollBehavior2 != null ? topAppBarScrollBehavior2.getState() : null;
                        if (state3 == null) {
                            return;
                        }
                        state3.setHeightOffsetLimit(collapsedHeightPx3.element - expandedHeightPx3.element);
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv, $composer2, 0);
            if (scrollBehavior != null) {
                colorTransitionFraction = 0.0f;
            } else {
                colorTransitionFraction = 0.0f;
            }
            long appBarContainerColor3 = colors.m2965containerColorvNxB06k$material3_release(colorTransitionFraction);
            Function2 actionsRow3 = ComposableLambdaKt.rememberComposableLambda(-89435287, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C1978@90028L157:AppBar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-89435287, $changed2, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1978)");
                        }
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function6 = function5;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        function6.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            float topTitleAlpha3 = TopTitleAlphaEasing.transform(colorTransitionFraction);
            float bottomTitleAlpha3 = 1.0f - colorTransitionFraction;
            if (colorTransitionFraction < 0.5f) {
                hideTopRowSemantics = true;
            } else {
                hideTopRowSemantics = false;
            }
            if (hideTopRowSemantics) {
                hideBottomRowSemantics = true;
            } else {
                hideBottomRowSemantics = false;
            }
            $composer2.startReplaceGroup(-1609628662);
            ComposerKt.sourceInformation($composer2, "1995@90912L83,1995@90889L106,1998@91025L255");
            if (scrollBehavior != null) {
                $dirty1 = $dirty2;
                appBarDragModifier = Modifier.INSTANCE;
            } else {
                $dirty1 = $dirty2;
                appBarDragModifier = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            SurfaceKt.m2666SurfaceT9BRK9s(modifier2.then(appBarDragModifier), null, appBarContainerColor3, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1350062619, true, new AppBarKt$TwoRowsTopAppBar$6(windowInsets, collapsedHeight, colors, function3, smallTitleTextStyle, topTitleAlpha3, hideTopRowSemantics, function4, actionsRow3, expandedHeight, scrollBehavior, function2, titleTextStyle, bottomTitleAlpha3, titleBottomPaddingPx3, hideBottomRowSemantics), $composer2, 54), $composer2, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$7
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

                public final void invoke(Composer composer, int i5) {
                    AppBarKt.m1925TwoRowsTopAppBarnS6u9G4(modifier5, function2, titleTextStyle, titleBottomPadding, function3, smallTitleTextStyle, function4, function5, collapsedHeight, expandedHeight, windowInsets, colors, scrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    public static final void m1924TopAppBarLayoutkXwM9vE(final Modifier modifier, final ScrolledOffset scrolledOffset, final long navigationIconContentColor, final long titleContentColor, final long actionIconContentColor, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle titleTextStyle, final float titleAlpha, final Arrangement.Vertical titleVerticalArrangement, final Arrangement.Horizontal titleHorizontalArrangement, final int titleBottomPadding, final boolean hideTitleSemantics, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int $changed1) {
        int $dirty;
        MeasurePolicy value$iv;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Composer $composer2;
        Function0<ComposeUiNode> function5;
        Function0<ComposeUiNode> function6;
        Composer $composer3 = $composer.startRestartGroup(-742442296);
        ComposerKt.sourceInformation($composer3, "C(TopAppBarLayout)P(3,6,5:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,2,4)2139@97130L5283,2102@95816L6597:AppBar.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= ($changed & 64) == 0 ? $composer3.changed(scrolledOffset) : $composer3.changedInstance(scrolledOffset) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(navigationIconContentColor) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty = $dirty2 | ($composer3.changed(titleContentColor) ? 2048 : 1024);
        } else {
            $dirty = $dirty2;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changed(actionIconContentColor) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(titleTextStyle) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(titleAlpha) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(titleVerticalArrangement) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(titleHorizontalArrangement) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty;
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(titleBottomPadding) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changed(hideTitleSemantics) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function3) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer3.changedInstance(function4) ? 2048 : 1024;
        }
        if ((306783379 & $dirty3) != 306783378 || ($dirty1 & 1171) != 1170 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-742442296, $dirty3, $dirty1, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2101)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1019471740, "CC(remember):AppBar.kt#9igjgp");
            boolean invalid$iv = (($dirty3 & 112) == 32 || (($dirty3 & 64) != 0 && $composer3.changedInstance(scrolledOffset))) | ((1879048192 & $dirty3) == 536870912) | ((234881024 & $dirty3) == 67108864) | (($dirty1 & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1
                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(final MeasureScope $this$Layout, List<? extends Measurable> list, final long constraints) {
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = list.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "navigationIcon")) {
                                final Placeable navigationIconPlaceable = ((Measurable) item$iv$iv).mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
                                int size2 = list.size();
                                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                                    Object item$iv$iv2 = list.get(index$iv$iv2);
                                    Measurable it2 = (Measurable) item$iv$iv2;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "actionIcons")) {
                                        final Placeable actionIconsPlaceable = ((Measurable) item$iv$iv2).mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
                                        int maxTitleWidth = Constraints.m6744getMaxWidthimpl(constraints) == Integer.MAX_VALUE ? Constraints.m6744getMaxWidthimpl(constraints) : RangesKt.coerceAtLeast((Constraints.m6744getMaxWidthimpl(constraints) - navigationIconPlaceable.getWidth()) - actionIconsPlaceable.getWidth(), 0);
                                        int size3 = list.size();
                                        for (int index$iv$iv3 = 0; index$iv$iv3 < size3; index$iv$iv3++) {
                                            Object item$iv$iv3 = list.get(index$iv$iv3);
                                            Measurable it3 = (Measurable) item$iv$iv3;
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "title")) {
                                                final Placeable titlePlaceable = ((Measurable) item$iv$iv3).mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : maxTitleWidth, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
                                                final int titleBaseline = titlePlaceable.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? titlePlaceable.get(AlignmentLineKt.getLastBaseline()) : 0;
                                                float scrolledOffsetValue = scrolledOffset.offset();
                                                int heightOffset = Float.isNaN(scrolledOffsetValue) ? 0 : MathKt.roundToInt(scrolledOffsetValue);
                                                final int layoutHeight = Constraints.m6743getMaxHeightimpl(constraints) == Integer.MAX_VALUE ? Constraints.m6743getMaxHeightimpl(constraints) : Constraints.m6743getMaxHeightimpl(constraints) + heightOffset;
                                                int iM6744getMaxWidthimpl = Constraints.m6744getMaxWidthimpl(constraints);
                                                final Arrangement.Horizontal horizontal = titleHorizontalArrangement;
                                                final Arrangement.Vertical vertical = titleVerticalArrangement;
                                                final int i = titleBottomPadding;
                                                return MeasureScope.CC.layout$default($this$Layout, iM6744getMaxWidthimpl, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                        invoke2(placementScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                                                        int iMax;
                                                        int height;
                                                        int adjustedBottomPadding;
                                                        Placeable.PlacementScope.placeRelative$default($this$layout, navigationIconPlaceable, 0, (layoutHeight - navigationIconPlaceable.getHeight()) / 2, 0.0f, 4, null);
                                                        Placeable placeable = titlePlaceable;
                                                        Arrangement.Horizontal horizontal2 = horizontal;
                                                        if (Intrinsics.areEqual(horizontal2, Arrangement.INSTANCE.getCenter())) {
                                                            int baseX = (Constraints.m6744getMaxWidthimpl(constraints) - titlePlaceable.getWidth()) / 2;
                                                            if (baseX < navigationIconPlaceable.getWidth()) {
                                                                baseX += navigationIconPlaceable.getWidth() - baseX;
                                                            } else if (titlePlaceable.getWidth() + baseX > Constraints.m6744getMaxWidthimpl(constraints) - actionIconsPlaceable.getWidth()) {
                                                                baseX += (Constraints.m6744getMaxWidthimpl(constraints) - actionIconsPlaceable.getWidth()) - (titlePlaceable.getWidth() + baseX);
                                                            }
                                                            iMax = baseX;
                                                        } else if (!Intrinsics.areEqual(horizontal2, Arrangement.INSTANCE.getEnd())) {
                                                            iMax = Math.max($this$Layout.mo561roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), navigationIconPlaceable.getWidth());
                                                        } else {
                                                            iMax = (Constraints.m6744getMaxWidthimpl(constraints) - titlePlaceable.getWidth()) - actionIconsPlaceable.getWidth();
                                                        }
                                                        Arrangement.Vertical vertical2 = vertical;
                                                        if (Intrinsics.areEqual(vertical2, Arrangement.INSTANCE.getCenter())) {
                                                            height = (layoutHeight - titlePlaceable.getHeight()) / 2;
                                                        } else if (Intrinsics.areEqual(vertical2, Arrangement.INSTANCE.getBottom())) {
                                                            if (i == 0) {
                                                                height = layoutHeight - titlePlaceable.getHeight();
                                                            } else {
                                                                int paddingFromBottom = i - (titlePlaceable.getHeight() - titleBaseline);
                                                                int heightWithPadding = titlePlaceable.getHeight() + paddingFromBottom;
                                                                if (heightWithPadding > Constraints.m6743getMaxHeightimpl(constraints)) {
                                                                    adjustedBottomPadding = paddingFromBottom - (heightWithPadding - Constraints.m6743getMaxHeightimpl(constraints));
                                                                } else {
                                                                    adjustedBottomPadding = paddingFromBottom;
                                                                }
                                                                height = (layoutHeight - titlePlaceable.getHeight()) - Math.max(0, adjustedBottomPadding);
                                                            }
                                                        } else {
                                                            height = 0;
                                                        }
                                                        Placeable.PlacementScope.placeRelative$default($this$layout, placeable, iMax, height, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default($this$layout, actionIconsPlaceable, Constraints.m6744getMaxWidthimpl(constraints) - actionIconsPlaceable.getWidth(), (layoutHeight - actionIconsPlaceable.getHeight()) / 2, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int $changed$iv = ($dirty3 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer3, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -290498151, "C2104@95846L352,2114@96211L524,2127@96748L336:AppBar.kt#uh7d8r");
            Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "navigationIcon"), TopAppBarHorizontalPadding, 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function1 = constructor2;
                $composer3.createNode(function1);
            } else {
                function1 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            $composer2 = $composer3;
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1090246679, "C2109@96021L163:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(navigationIconContentColor)), function3, $composer3, ProvidedValue.$stable | (($dirty1 >> 3) & 112));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "title"), TopAppBarHorizontalPadding, 0.0f, 2, null);
            Modifier.Companion companionClearAndSetSemantics = Modifier.INSTANCE;
            if (hideTitleSemantics) {
                companionClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companionClearAndSetSemantics, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                    }
                });
            }
            Modifier modifier$iv2 = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default(modifierM870paddingVpY3zN4$default.then(companionClearAndSetSemantics), 0.0f, 0.0f, titleAlpha, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function5 = constructor3;
                $composer3.createNode(function5);
            } else {
                function5 = constructor3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1090246164, "C2121@96536L185:AppBar.kt#uh7d8r");
            ProvideContentColorTextStyleKt.m3015ProvideContentColorTextStyle3JVO9M(titleContentColor, titleTextStyle, function2, $composer3, (($dirty3 >> 9) & 14) | (($dirty3 >> 15) & 112) | (($dirty3 >> 9) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "actionIcons"), 0.0f, 0.0f, TopAppBarHorizontalPadding, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function6 = constructor4;
                $composer3.createNode(function6);
            } else {
                function6 = constructor4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i7 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1090245782, "C2132@96918L152:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(actionIconContentColor)), function4, $composer3, ProvidedValue.$stable | (($dirty1 >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$3
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

                public final void invoke(Composer composer, int i8) {
                    AppBarKt.m1924TopAppBarLayoutkXwM9vE(modifier, scrolledOffset, navigationIconContentColor, titleContentColor, actionIconContentColor, function2, titleTextStyle, titleAlpha, titleVerticalArrangement, titleHorizontalArrangement, titleBottomPadding, hideTitleSemantics, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:40:0x0101  */
    /* JADX WARN: Code duplicated, block: B:43:0x0126 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0127  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object settleAppBar(final TopAppBarState state, float velocity, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        C12081 c12081;
        AnimationSpec<Float> animationSpec2;
        Ref.FloatRef remainingVelocity;
        final TopAppBarState state2;
        TopAppBarState state3;
        AnimationSpec<Float> animationSpec3;
        Ref.FloatRef remainingVelocity2;
        AnimationState animationStateAnimationState$default;
        float heightOffsetLimit;
        Float fBoxFloat;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        Ref.FloatRef remainingVelocity3;
        if (continuation instanceof C12081) {
            c12081 = (C12081) continuation;
            if ((c12081.label & Integer.MIN_VALUE) != 0) {
                c12081.label -= Integer.MIN_VALUE;
            } else {
                c12081 = new C12081(continuation);
            }
        } else {
            c12081 = new C12081(continuation);
        }
        C12081 c12082 = c12081;
        Object $result = c12082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c12082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (state.getCollapsedFraction() >= 0.01f) {
                    if (!(state.getCollapsedFraction() == 1.0f)) {
                        final Ref.FloatRef remainingVelocity4 = new Ref.FloatRef();
                        remainingVelocity4.element = velocity;
                        if (decayAnimationSpec != null && Math.abs(velocity) > 1.0f) {
                            final Ref.FloatRef lastValue = new Ref.FloatRef();
                            AnimationState animationStateAnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, velocity, 0L, 0L, false, 28, null);
                            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function2 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBar.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    float delta = animationScope.getValue().floatValue() - lastValue.element;
                                    float initialHeightOffset = state.getHeightOffset();
                                    state.setHeightOffset(initialHeightOffset + delta);
                                    float consumed = Math.abs(initialHeightOffset - state.getHeightOffset());
                                    lastValue.element = animationScope.getValue().floatValue();
                                    remainingVelocity4.element = animationScope.getVelocity().floatValue();
                                    if (Math.abs(delta - consumed) > 0.5f) {
                                        animationScope.cancelAnimation();
                                    }
                                }
                            };
                            c12082.L$0 = state;
                            c12082.L$1 = animationSpec;
                            c12082.L$2 = remainingVelocity4;
                            c12082.label = 1;
                            if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default2, decayAnimationSpec, false, function2, c12082, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            state3 = state;
                            animationSpec3 = animationSpec;
                            remainingVelocity2 = remainingVelocity4;
                            remainingVelocity = remainingVelocity2;
                            state2 = state3;
                            animationSpec2 = animationSpec3;
                        } else {
                            animationSpec2 = animationSpec;
                            remainingVelocity = remainingVelocity4;
                            state2 = state;
                        }
                        if (animationSpec2 != null && state2.getHeightOffset() < 0.0f && state2.getHeightOffset() > state2.getHeightOffsetLimit()) {
                            animationStateAnimationState$default = AnimationStateKt.AnimationState$default(state2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                            if (state2.getCollapsedFraction() < 0.5f) {
                                heightOffsetLimit = 0.0f;
                            } else {
                                heightOffsetLimit = state2.getHeightOffsetLimit();
                            }
                            fBoxFloat = Boxing.boxFloat(heightOffsetLimit);
                            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBar.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    invoke2(animationScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                    state2.setHeightOffset(animationScope.getValue().floatValue());
                                }
                            };
                            c12082.L$0 = remainingVelocity;
                            c12082.L$1 = null;
                            c12082.L$2 = null;
                            c12082.label = 2;
                            if (SuspendAnimationKt.animateTo(animationStateAnimationState$default, fBoxFloat, (4 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec2, (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? SuspendAnimationKt.C02582.INSTANCE : function1, c12082) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            remainingVelocity3 = remainingVelocity;
                            remainingVelocity = remainingVelocity3;
                        }
                        return Velocity.m7033boximpl(VelocityKt.Velocity(0.0f, remainingVelocity.element));
                    }
                }
                return Velocity.m7033boximpl(Velocity.INSTANCE.m7053getZero9UxMQ8M());
            case 1:
                remainingVelocity2 = (Ref.FloatRef) c12082.L$2;
                animationSpec3 = (AnimationSpec) c12082.L$1;
                state3 = (TopAppBarState) c12082.L$0;
                ResultKt.throwOnFailure($result);
                remainingVelocity = remainingVelocity2;
                state2 = state3;
                animationSpec2 = animationSpec3;
                if (animationSpec2 != null) {
                    animationStateAnimationState$default = AnimationStateKt.AnimationState$default(state2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    if (state2.getCollapsedFraction() < 0.5f) {
                        heightOffsetLimit = 0.0f;
                    } else {
                        heightOffsetLimit = state2.getHeightOffsetLimit();
                    }
                    fBoxFloat = Boxing.boxFloat(heightOffsetLimit);
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt.settleAppBar.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            state2.setHeightOffset(animationScope.getValue().floatValue());
                        }
                    };
                    c12082.L$0 = remainingVelocity;
                    c12082.L$1 = null;
                    c12082.L$2 = null;
                    c12082.label = 2;
                    if (SuspendAnimationKt.animateTo(animationStateAnimationState$default, fBoxFloat, (4 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec2, (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? SuspendAnimationKt.C02582.INSTANCE : function1, c12082) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    remainingVelocity3 = remainingVelocity;
                    remainingVelocity = remainingVelocity3;
                }
                return Velocity.m7033boximpl(VelocityKt.Velocity(0.0f, remainingVelocity.element));
            case 2:
                remainingVelocity3 = (Ref.FloatRef) c12082.L$0;
                ResultKt.throwOnFailure($result);
                remainingVelocity = remainingVelocity3;
                return Velocity.m7033boximpl(VelocityKt.Velocity(0.0f, remainingVelocity.element));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }
}
