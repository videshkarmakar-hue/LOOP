package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.activity.BackEventCompat;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.ZIndexModifierKt;
import androidx.compose.p001ui.focus.FocusChangedModifierKt;
import androidx.compose.p001ui.focus.FocusManager;
import androidx.compose.p001ui.focus.FocusRequester;
import androidx.compose.p001ui.focus.FocusRequesterModifierKt;
import androidx.compose.p001ui.focus.FocusState;
import androidx.compose.p001ui.geometry.CornerRadiusKt;
import androidx.compose.p001ui.geometry.RoundRectKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.Shadow;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.graphics.drawscope.DrawStyle;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.PlatformTextStyle;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontSynthesis;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.PlatformImeOptions;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.BaselineShift;
import androidx.compose.p001ui.text.style.LineHeightStyle;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextGeometricTransform;
import androidx.compose.p001ui.text.style.TextIndent;
import androidx.compose.p001ui.text.style.TextMotion;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: SearchBar.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000Æ\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0089\u0002\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001a2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020+0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020+0.2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020+0.2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002012\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u00112\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010C\u001a\u0018\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020+0.¢\u0006\u0002\b8¢\u0006\u0002\bEH\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a\u0093\u0002\u0010H\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001a2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020+0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020+0.2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020+0.2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002012\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u00112\b\b\u0002\u0010I\u001a\u00020J2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010C\u001a\u0018\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020+0.¢\u0006\u0002\b8¢\u0006\u0002\bEH\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a»\u0001\u0010M\u001a\u00020+2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020P0O2\u0006\u0010Q\u001a\u00020R2\u000e\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0T2\u000e\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0T2\b\b\u0002\u00103\u001a\u0002042\u0011\u0010W\u001a\r\u0012\u0004\u0012\u00020+07¢\u0006\u0002\b82\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u00112\b\b\u0002\u0010I\u001a\u00020J2\u001c\u0010C\u001a\u0018\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020+0.¢\u0006\u0002\b8¢\u0006\u0002\bEH\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001aÈ\u0001\u0010Z\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001a2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020+0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020+0.2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020+0.2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002012\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b82\b\b\u0002\u0010=\u001a\u00020[2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BH\u0001¢\u0006\u0002\u0010\\\u001a\u0094\u0001\u0010]\u001a\u00020+2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020P0O2\u0006\u0010Q\u001a\u00020R2\u000e\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0T2\u000e\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0T2\u0006\u00103\u001a\u0002042\u0006\u0010I\u001a\u00020J2\u0011\u0010W\u001a\r\u0012\u0004\u0012\u00020+07¢\u0006\u0002\b82\u0011\u0010^\u001a\r\u0012\u0004\u0012\u00020+07¢\u0006\u0002\b82\u0013\u0010C\u001a\u000f\u0012\u0004\u0012\u00020+\u0018\u000107¢\u0006\u0002\b8H\u0003¢\u0006\u0002\u0010_\u001a\"\u0010`\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0002\u001aD\u0010b\u001a\u00020\u00012\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00012\b\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010f\u001a\u00020g2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\bi\u0010j\u001aN\u0010k\u001a\u00020\u00012\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00012\b\u0010V\u001a\u0004\u0018\u00010U2\b\u0010S\u001a\u0004\u0018\u00010U2\u0006\u0010l\u001a\u00020\u00012\u0006\u0010m\u001a\u00020\u00012\u0006\u0010h\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010o\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0011X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0014\u0012\u0004\b\u001e\u0010\u001f\"\u0010\u0010 \u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0010\u0010!\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0016\u0010\"\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b#\u0010\u0013\"\u000e\u0010$\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010%\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0010\u0010&\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u000e\u0010'\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010(\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b)\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006p²\u0006\n\u0010q\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010r\u001a\u000201X\u008a\u0084\u0002"}, m195d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "AnimationPredictiveBackExitFloatSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "LayoutIdInputField", "", "LayoutIdSearchContent", "LayoutIdSurface", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMinScale", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "onQueryChange", "Lkotlin/Function1;", "onSearch", "active", "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "currentBackEvent", "inputField", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", NotificationCompat.CATEGORY_PROGRESS, "calculatePredictiveBackOffsetX", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "material3_release", "useFullScreenShape", "showContent"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedActiveTableMinHeight;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarCornerRadius;
    private static final float SearchBarIconOffsetX;
    private static final float SearchBarMaxWidth;
    private static final float SearchBarMinWidth;
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMaxOffsetY;
    private static final float SearchBarPredictiveBackMinMargin;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding;

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX INFO: renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    public static final void m2545SearchBarWuY5d9Q(final String query, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function2, final boolean active, final Function1<? super Boolean, Unit> function3, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Shape shape, SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function7, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Shape shape2;
        int $dirty1;
        SearchBarColors colors2;
        WindowInsets windowInsets2;
        MutableInteractionSource interactionSource2;
        SearchBarColors colors3;
        float tonalElevation2;
        float shadowElevation2;
        WindowInsets windowInsets3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Modifier modifier2;
        boolean enabled2;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Shape shape3;
        int $dirty2;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1001512593);
        ComposerKt.sourceInformation($composer3, "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)185@9472L15,186@9537L8,189@9718L12,193@9870L62,194@9961L43,195@10030L51,196@10109L51,198@10189L644,198@10166L667,215@10858L27,216@10930L1060,216@10890L1100,248@12241L578,242@11996L1026:SearchBar.android.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty3 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(query) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(active) ? 2048 : 1024;
        }
        int i2 = 8192;
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 16384 : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer3.changed(modifier) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty |= 1572864;
            z = enabled;
        } else if (($changed & 1572864) == 0) {
            z = enabled;
            $dirty |= $composer3.changed(z) ? 1048576 : 524288;
        } else {
            z = enabled;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty |= 12582912;
            function8 = function4;
        } else if (($changed & 12582912) == 0) {
            function8 = function4;
            $dirty |= $composer3.changedInstance(function8) ? 8388608 : 4194304;
        } else {
            function8 = function4;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function6) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty3 |= ((i & 1024) == 0 && $composer3.changed(shape)) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty3 |= ((i & 2048) == 0 && $composer3.changed(colors)) ? 32 : 16;
        }
        int i8 = i & 4096;
        if (i8 != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty3 |= $composer3.changed(tonalElevation) ? 256 : 128;
        }
        int i9 = i & 8192;
        if (i9 != 0) {
            $dirty3 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty3 |= $composer3.changed(shadowElevation) ? 2048 : 1024;
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16384) == 0 && $composer3.changed(windowInsets)) {
                i2 = 16384;
            }
            $dirty3 |= i2;
        }
        int i10 = i & 32768;
        if (i10 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= $composer3.changed(interactionSource) ? 131072 : 65536;
        }
        if ((i & 65536) != 0) {
            $dirty3 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty3 |= $composer3.changedInstance(function7) ? 1048576 : 524288;
        }
        if (($dirty & 306783379) == 306783378 && (599187 & $dirty3) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            function9 = function5;
            function11 = function6;
            shape3 = shape;
            colors3 = colors;
            tonalElevation2 = tonalElevation;
            shadowElevation2 = shadowElevation;
            windowInsets3 = windowInsets;
            interactionSource2 = interactionSource;
            enabled2 = z;
            function10 = function8;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i4 != 0 ? true : z;
                Function2<? super Composer, ? super Integer, Unit> function12 = i5 != 0 ? null : function8;
                Function2<? super Composer, ? super Integer, Unit> function13 = i6 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function14 = i7 != 0 ? null : function6;
                if ((i & 1024) != 0) {
                    $dirty1 = $dirty3 & (-15);
                    shape2 = SearchBarDefaults.INSTANCE.getInputFieldShape($composer3, 6);
                } else {
                    shape2 = shape;
                    $dirty1 = $dirty3;
                }
                if ((i & 2048) != 0) {
                    colors2 = SearchBarDefaults.INSTANCE.m2537colorsKlgxPg(0L, 0L, null, $composer3, 3072, 7);
                    $dirty1 &= -113;
                } else {
                    colors2 = colors;
                }
                float tonalElevation3 = i8 != 0 ? SearchBarDefaults.INSTANCE.m2541getTonalElevationD9Ej5fM() : tonalElevation;
                float shadowElevation3 = i9 != 0 ? SearchBarDefaults.INSTANCE.m2540getShadowElevationD9Ej5fM() : shadowElevation;
                if ((i & 16384) != 0) {
                    windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    $dirty1 &= -57345;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i10 != 0) {
                    colors3 = colors2;
                    tonalElevation2 = tonalElevation3;
                    shadowElevation2 = shadowElevation3;
                    windowInsets3 = windowInsets2;
                    interactionSource2 = null;
                    function9 = function13;
                    modifier2 = modifier3;
                    enabled2 = enabled3;
                    function10 = function12;
                    function11 = function14;
                    shape3 = shape2;
                    $dirty2 = $dirty1;
                } else {
                    interactionSource2 = interactionSource;
                    colors3 = colors2;
                    tonalElevation2 = tonalElevation3;
                    shadowElevation2 = shadowElevation3;
                    windowInsets3 = windowInsets2;
                    function9 = function13;
                    modifier2 = modifier3;
                    enabled2 = enabled3;
                    function10 = function12;
                    function11 = function14;
                    shape3 = shape2;
                    $dirty2 = $dirty1;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 1024) != 0) {
                    $dirty3 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty3 &= -113;
                }
                if ((i & 16384) != 0) {
                    $dirty3 &= -57345;
                }
                modifier2 = modifier;
                function9 = function5;
                function11 = function6;
                shape3 = shape;
                colors3 = colors;
                tonalElevation2 = tonalElevation;
                shadowElevation2 = shadowElevation;
                windowInsets3 = windowInsets;
                interactionSource2 = interactionSource;
                $dirty2 = $dirty3;
                enabled2 = z;
                function10 = function8;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1001512593, $dirty, $dirty2, "androidx.compose.material3.SearchBar (SearchBar.android.kt:192)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 851478726, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = AnimatableKt.Animatable$default(active ? 1.0f : 0.0f, 0.0f, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            Animatable animationProgress = (Animatable) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 851478817, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableFloatState finalBackProgress = (MutableFloatState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 851478886, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            MutableState firstBackEvent = (MutableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 851478965, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            MutableState currentBackEvent = (MutableState) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Boolean boolValueOf = Boolean.valueOf(active);
            ComposerKt.sourceInformationMarkerStart($composer3, 851479045, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(animationProgress) | (($dirty & 7168) == 2048);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new SearchBar_androidKt$SearchBar$1$1(animationProgress, active, finalBackProgress, firstBackEvent, currentBackEvent, null);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv5, $composer3, ($dirty >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 851479714, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = new MutatorMutex();
                $composer3.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            MutatorMutex mutatorMutex = (MutatorMutex) value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 851479786, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changedInstance(animationProgress) | ((57344 & $dirty) == 16384);
            Object it$iv7 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = new SearchBar_androidKt$SearchBar$2$1(mutatorMutex, finalBackProgress, animationProgress, function3, firstBackEvent, currentBackEvent, null);
                $composer3.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PredictiveBackHandlerKt.PredictiveBackHandler(active, (Function2) value$iv7, $composer3, ($dirty >> 9) & 14, 0);
            final boolean z2 = enabled2;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function11;
            int $dirty4 = $dirty2;
            final SearchBarColors searchBarColors = colors3;
            $composer2 = $composer3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            m2546SearchBarImplj1jLAyQ(animationProgress, finalBackProgress, firstBackEvent, currentBackEvent, modifier2, ComposableLambdaKt.rememberComposableLambda(-1957632308, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3
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
                    ComposerKt.sourceInformation($composer4, "C249@12255L554:SearchBar.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1957632308, $changed2, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:249)");
                        }
                        SearchBar_androidKt.SearchBarInputField(query, function1, function2, active, function3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z2, function15, function16, function17, searchBarColors.getInputFieldColors(), mutableInteractionSource, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), shape3, colors3, tonalElevation2, shadowElevation2, windowInsets3, function7, $composer2, 200112 | Animatable.$stable | (($dirty >> 3) & 57344) | (($dirty4 << 18) & 3670016) | (($dirty4 << 18) & 29360128) | (($dirty4 << 18) & 234881024) | (1879048192 & ($dirty4 << 18)), (($dirty4 >> 12) & 14) | (($dirty4 >> 15) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z3 = enabled2;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function20 = function11;
            final Shape shape4 = shape3;
            final SearchBarColors searchBarColors2 = colors3;
            final float f = tonalElevation2;
            final float f2 = shadowElevation2;
            final WindowInsets windowInsets4 = windowInsets3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                public final void invoke(Composer composer, int i11) {
                    SearchBar_androidKt.m2545SearchBarWuY5d9Q(query, function1, function2, active, function3, modifier4, z3, function18, function19, function20, shape4, searchBarColors2, f, f2, windowInsets4, mutableInteractionSource2, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    public static final void m2544DockedSearchBareWTbjVg(final String query, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function2, final boolean active, final Function1<? super Boolean, Unit> function3, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Shape shape, SearchBarColors colors, float tonalElevation, float shadowElevation, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function7, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function8;
        Shape shape2;
        int $dirty1;
        int $dirty;
        SearchBarColors colors2;
        MutableInteractionSource interactionSource2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        SearchBarColors colors3;
        float tonalElevation2;
        float shadowElevation2;
        Modifier modifier2;
        boolean enabled2;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Shape shape3;
        int $dirty2;
        int $dirty3;
        MutableInteractionSource mutableInteractionSource;
        Modifier modifier3;
        Object value$iv;
        Composer $composer2;
        Object value$iv2;
        Composer $composer3 = $composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation($composer3, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)332@16492L11,333@16553L8,345@17013L38,351@17233L1355,342@16919L1669,389@18624L37,389@18594L67:SearchBar.android.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty5 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer3.changed(query) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty4 |= $composer3.changed(active) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty4 |= $composer3.changedInstance(function3) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty4 |= $composer3.changed(enabled) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty4 |= 12582912;
            function8 = function4;
        } else if (($changed & 12582912) == 0) {
            function8 = function4;
            $dirty4 |= $composer3.changedInstance(function8) ? 8388608 : 4194304;
        } else {
            function8 = function4;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty4 |= $composer3.changedInstance(function5) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty4 |= $composer3.changedInstance(function6) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty5 |= ((i & 1024) == 0 && $composer3.changed(shape)) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty5 |= ((i & 2048) == 0 && $composer3.changed(colors)) ? 32 : 16;
        }
        int i7 = i & 4096;
        if (i7 != 0) {
            $dirty5 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty5 |= $composer3.changed(tonalElevation) ? 256 : 128;
        }
        int i8 = i & 8192;
        if (i8 != 0) {
            $dirty5 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty5 |= $composer3.changed(shadowElevation) ? 2048 : 1024;
        }
        int i9 = i & 16384;
        if (i9 != 0) {
            $dirty5 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty5 |= $composer3.changed(interactionSource) ? 16384 : 8192;
        }
        if ((i & 32768) != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty5 |= $composer3.changedInstance(function7) ? 131072 : 65536;
        }
        int $dirty6 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && (74899 & $dirty5) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled2 = enabled;
            function9 = function5;
            function11 = function6;
            shape3 = shape;
            colors3 = colors;
            tonalElevation2 = tonalElevation;
            shadowElevation2 = shadowElevation;
            interactionSource2 = interactionSource;
            function10 = function8;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i3 != 0 ? true : enabled;
                Function2<? super Composer, ? super Integer, Unit> function12 = i4 != 0 ? null : function8;
                Function2<? super Composer, ? super Integer, Unit> function13 = i5 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function14 = i6 != 0 ? null : function6;
                if ((i & 1024) != 0) {
                    shape2 = SearchBarDefaults.INSTANCE.getDockedShape($composer3, 6);
                    $dirty1 = $dirty5 & (-15);
                } else {
                    shape2 = shape;
                    $dirty1 = $dirty5;
                }
                if ((i & 2048) != 0) {
                    $dirty = $dirty6;
                    colors2 = SearchBarDefaults.INSTANCE.m2537colorsKlgxPg(0L, 0L, null, $composer3, 3072, 7);
                    $dirty1 &= -113;
                } else {
                    $dirty = $dirty6;
                    colors2 = colors;
                }
                float tonalElevation3 = i7 != 0 ? SearchBarDefaults.INSTANCE.m2541getTonalElevationD9Ej5fM() : tonalElevation;
                float shadowElevation3 = i8 != 0 ? SearchBarDefaults.INSTANCE.m2540getShadowElevationD9Ej5fM() : shadowElevation;
                if (i9 != 0) {
                    function9 = function13;
                    colors3 = colors2;
                    tonalElevation2 = tonalElevation3;
                    shadowElevation2 = shadowElevation3;
                    interactionSource2 = null;
                    modifier2 = modifier4;
                    enabled2 = enabled3;
                    function10 = function12;
                    function11 = function14;
                    shape3 = shape2;
                    $dirty2 = $dirty1;
                } else {
                    interactionSource2 = interactionSource;
                    function9 = function13;
                    colors3 = colors2;
                    tonalElevation2 = tonalElevation3;
                    shadowElevation2 = shadowElevation3;
                    modifier2 = modifier4;
                    enabled2 = enabled3;
                    function10 = function12;
                    function11 = function14;
                    shape3 = shape2;
                    $dirty2 = $dirty1;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 1024) != 0) {
                    $dirty5 &= -15;
                }
                if ((i & 2048) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    function9 = function5;
                    function11 = function6;
                    shape3 = shape;
                    colors3 = colors;
                    tonalElevation2 = tonalElevation;
                    shadowElevation2 = shadowElevation;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty6;
                    $dirty2 = $dirty5 & (-113);
                    function10 = function8;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    function9 = function5;
                    function11 = function6;
                    shape3 = shape;
                    colors3 = colors;
                    tonalElevation2 = tonalElevation;
                    shadowElevation2 = shadowElevation;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty6;
                    $dirty2 = $dirty5;
                    function10 = function8;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                $dirty3 = $dirty;
                ComposerKt.traceEventStart(1299054533, $dirty3, $dirty2, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:338)");
            } else {
                $dirty3 = $dirty;
            }
            $composer3.startReplaceGroup(-32073345);
            ComposerKt.sourceInformation($composer3, "340@16874L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer3, -32073324, "CC(remember):SearchBar.android.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                mutableInteractionSource = interactionSource2;
            }
            $composer3.endReplaceGroup();
            final MutableInteractionSource interactionSource3 = mutableInteractionSource;
            long containerColor = colors3.getContainerColor();
            long jM2082contentColorForek8zF_U = ColorSchemeKt.m2082contentColorForek8zF_U(colors3.getContainerColor(), $composer3, 0);
            Modifier modifierM918width3ABfNKs = SizeKt.m918width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
            final SearchBarColors searchBarColors = colors3;
            int $dirty7 = $dirty3;
            final boolean z = enabled2;
            int $dirty8 = $dirty2;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function10;
            modifier3 = modifier2;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function11;
            SurfaceKt.m2666SurfaceT9BRK9s(modifierM918width3ABfNKs, shape3, containerColor, jM2082contentColorForek8zF_U, tonalElevation2, shadowElevation2, null, ComposableLambdaKt.rememberComposableLambda(1088676554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1
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

                /* JADX WARN: Code duplicated, block: B:28:0x01f7  */
                /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
                public final void invoke(Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    CompositionLocalMap localMap$iv$iv;
                    MeasurePolicy measurePolicy$iv;
                    ComposerKt.sourceInformation($composer4, "C352@17243L1339:SearchBar.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1088676554, $changed2, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:352)");
                        }
                        final SearchBarColors searchBarColors2 = searchBarColors;
                        String str = query;
                        Function1<String, Unit> function18 = function1;
                        Function1<String, Unit> function19 = function2;
                        boolean z2 = active;
                        Function1<Boolean, Unit> function20 = function3;
                        boolean z3 = z;
                        Function2<Composer, Integer, Unit> function21 = function15;
                        Function2<Composer, Integer, Unit> function22 = function16;
                        Function2<Composer, Integer, Unit> function23 = function17;
                        MutableInteractionSource mutableInteractionSource2 = interactionSource3;
                        final Function3<ColumnScope, Composer, Integer, Unit> function24 = function7;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function0 = constructor;
                            $composer4.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                            localMap$iv$iv = localMap$iv$iv2;
                            measurePolicy$iv = measurePolicy$iv2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            }
                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i10 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1253283804, "C353@17264L554,372@17992L580,368@17832L740:SearchBar.android.kt#uh7d8r");
                            SearchBar_androidKt.SearchBarInputField(str, function18, function19, z2, function20, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z3, function21, function22, function23, searchBarColors2.getInputFieldColors(), mutableInteractionSource2, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0, 0);
                            AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u240, z2, (Modifier) null, SearchBar_androidKt.DockedEnterTransition, SearchBar_androidKt.DockedExitTransition, (String) null, ComposableLambdaKt.rememberComposableLambda(1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                    invoke(animatedVisibilityScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer5, int $changed3) {
                                    Object value$iv3;
                                    Object value$iv4;
                                    Function0<ComposeUiNode> function25;
                                    ComposerKt.sourceInformation($composer5, "C*373@18048L7,374@18106L115,377@18254L110,381@18382L176:SearchBar.android.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1804538904, $changed3, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:373)");
                                    }
                                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume = $composer5.consume(localConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    int $this$dp$iv = ((Configuration) objConsume).screenHeightDp;
                                    float screenHeight = C1979Dp.m6801constructorimpl($this$dp$iv);
                                    ComposerKt.sourceInformationMarkerStart($composer5, 747854663, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean invalid$iv = $composer5.changed(screenHeight);
                                    Object it$iv2 = $composer5.rememberedValue();
                                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        float other$iv = C1979Dp.m6801constructorimpl(screenHeight * 0.6666667f);
                                        value$iv3 = C1979Dp.m6799boximpl(other$iv);
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv2;
                                    }
                                    float maxHeight = ((C1979Dp) value$iv3).m6815unboximpl();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerStart($composer5, 747854811, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean invalid$iv2 = $composer5.changed(maxHeight);
                                    Object it$iv3 = $composer5.rememberedValue();
                                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv4 = C1979Dp.m6799boximpl(((C1979Dp) RangesKt.coerceAtMost(C1979Dp.m6799boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), C1979Dp.m6799boximpl(maxHeight))).m6815unboximpl());
                                        $composer5.updateRememberedValue(value$iv4);
                                    } else {
                                        value$iv4 = it$iv3;
                                    }
                                    float minHeight = ((C1979Dp) value$iv4).m6815unboximpl();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    Modifier modifier$iv2 = SizeKt.m900heightInVpY3zN4(Modifier.INSTANCE, minHeight, maxHeight);
                                    SearchBarColors searchBarColors3 = searchBarColors2;
                                    Function3<ColumnScope, Composer, Integer, Unit> function26 = function24;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv2 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        function25 = constructor2;
                                        $composer5.createNode(function25);
                                    } else {
                                        function25 = constructor2;
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer5);
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                    int $changed4 = ((0 >> 6) & 112) | 6;
                                    ColumnScope $this$invoke_u24lambda_u242 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 1001845582, "C382@18464L46,383@18531L9:SearchBar.android.kt#uh7d8r");
                                    DividerKt.m2223HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors3.getDividerColor(), $composer5, 0, 3);
                                    function26.invoke($this$invoke_u24lambda_u242, $composer5, Integer.valueOf($changed4 & 14));
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), $composer4, ((((0 >> 6) & 112) | 6) & 14) | 1600512, 18);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
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
                        localMap$iv$iv = localMap$iv$iv2;
                        measurePolicy$iv = measurePolicy$iv2;
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScope $this$invoke_u24lambda_u241 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1253283804, "C353@17264L554,372@17992L580,368@17832L740:SearchBar.android.kt#uh7d8r");
                        SearchBar_androidKt.SearchBarInputField(str, function18, function19, z2, function20, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z3, function21, function22, function23, searchBarColors2.getInputFieldColors(), mutableInteractionSource2, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 0, 0);
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u241, z2, (Modifier) null, SearchBar_androidKt.DockedEnterTransition, SearchBar_androidKt.DockedExitTransition, (String) null, ComposableLambdaKt.rememberComposableLambda(1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer5, int $changed3) {
                                Object value$iv3;
                                Object value$iv4;
                                Function0<ComposeUiNode> function25;
                                ComposerKt.sourceInformation($composer5, "C*373@18048L7,374@18106L115,377@18254L110,381@18382L176:SearchBar.android.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1804538904, $changed3, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:373)");
                                }
                                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume = $composer5.consume(localConfiguration);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                int $this$dp$iv = ((Configuration) objConsume).screenHeightDp;
                                float screenHeight = C1979Dp.m6801constructorimpl($this$dp$iv);
                                ComposerKt.sourceInformationMarkerStart($composer5, 747854663, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(screenHeight);
                                Object it$iv2 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    float other$iv = C1979Dp.m6801constructorimpl(screenHeight * 0.6666667f);
                                    value$iv3 = C1979Dp.m6799boximpl(other$iv);
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv2;
                                }
                                float maxHeight = ((C1979Dp) value$iv3).m6815unboximpl();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerStart($composer5, 747854811, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean invalid$iv2 = $composer5.changed(maxHeight);
                                Object it$iv3 = $composer5.rememberedValue();
                                if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv4 = C1979Dp.m6799boximpl(((C1979Dp) RangesKt.coerceAtMost(C1979Dp.m6799boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), C1979Dp.m6799boximpl(maxHeight))).m6815unboximpl());
                                    $composer5.updateRememberedValue(value$iv4);
                                } else {
                                    value$iv4 = it$iv3;
                                }
                                float minHeight = ((C1979Dp) value$iv4).m6815unboximpl();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                Modifier modifier$iv2 = SizeKt.m900heightInVpY3zN4(Modifier.INSTANCE, minHeight, maxHeight);
                                SearchBarColors searchBarColors3 = searchBarColors2;
                                Function3<ColumnScope, Composer, Integer, Unit> function26 = function24;
                                ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv2 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    function25 = constructor2;
                                    $composer5.createNode(function25);
                                } else {
                                    function25 = constructor2;
                                    $composer5.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer5);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                int $changed4 = ((0 >> 6) & 112) | 6;
                                ColumnScope $this$invoke_u24lambda_u242 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1001845582, "C382@18464L46,383@18531L9:SearchBar.android.kt#uh7d8r");
                                DividerKt.m2223HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors3.getDividerColor(), $composer5, 0, 3);
                                function26.invoke($this$invoke_u24lambda_u242, $composer5, Integer.valueOf($changed4 & 14));
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ((((0 >> 6) & 112) | 6) & 14) | 1600512, 18);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
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
            }, $composer3, 54), $composer3, (($dirty8 << 3) & 112) | 12582912 | (($dirty8 << 6) & 57344) | (($dirty8 << 6) & 458752), 64);
            ComposerKt.sourceInformationMarkerStart($composer3, -32071574, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv = ($dirty7 & 57344) == 16384;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        function3.invoke(false);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            BackHandlerKt.BackHandler(active, (Function0) value$iv, $composer2, ($dirty7 >> 9) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled2;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function20 = function11;
            final Shape shape4 = shape3;
            final SearchBarColors searchBarColors2 = colors3;
            final float f = tonalElevation2;
            final float f2 = shadowElevation2;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$3
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
                    SearchBar_androidKt.m2544DockedSearchBareWTbjVg(query, function1, function2, active, function3, modifier5, z2, function18, function19, function20, shape4, searchBarColors2, f, f2, mutableInteractionSource2, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void SearchBarInputField(final String query, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function2, final boolean active, final Function1<? super Boolean, Unit> function3, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, TextFieldColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        TextFieldColors colors2;
        MutableInteractionSource interactionSource2;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int $dirty1;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Modifier modifier2;
        TextFieldColors colors3;
        boolean enabled2;
        MutableInteractionSource mutableInteractionSource;
        Object value$iv;
        long textColor;
        final boolean enabled3;
        Object value$iv2;
        TextFieldColors colors4;
        Composer $composer2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer3 = $composer.startRestartGroup(496394889);
        ComposerKt.sourceInformation($composer3, "C(SearchBarInputField)P(10,7,8!1,6,5,2,9,4,11)407@19165L18,412@19392L29,413@19463L7,414@19497L34,415@19572L39,431@20178L42,432@20244L304,444@20639L7,447@20881L19,449@20986L940,421@19827L2105,472@21972L25,474@22079L292,474@22056L315:SearchBar.android.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty2 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(query) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(active) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer3.changed(modifier) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(enabled) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function4) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function6) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty2 |= ((i & 1024) == 0 && $composer3.changed(colors)) ? 4 : 2;
        }
        int i7 = i & 2048;
        if (i7 != 0) {
            $dirty2 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 32 : 16;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty2 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled3 = enabled;
            function9 = function4;
            function7 = function5;
            function8 = function6;
            colors4 = colors;
            interactionSource2 = interactionSource;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled;
                Function2<? super Composer, ? super Integer, Unit> function10 = i4 != 0 ? null : function4;
                Function2<? super Composer, ? super Integer, Unit> function11 = i5 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function12 = i6 != 0 ? null : function6;
                if ((i & 1024) != 0) {
                    colors2 = SearchBarDefaults.INSTANCE.m2543inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, CpioConstants.C_ISBLK, 16383);
                    $dirty2 &= -15;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    function7 = function11;
                    function8 = function12;
                    function9 = function10;
                    interactionSource2 = null;
                    modifier2 = modifier3;
                    colors3 = colors2;
                    enabled2 = enabled4;
                    $dirty1 = $dirty2;
                } else {
                    interactionSource2 = interactionSource;
                    function7 = function11;
                    $dirty1 = $dirty2;
                    function8 = function12;
                    function9 = function10;
                    modifier2 = modifier3;
                    colors3 = colors2;
                    enabled2 = enabled4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 1024) != 0) {
                    $dirty2 &= -15;
                }
                modifier2 = modifier;
                enabled2 = enabled;
                function9 = function4;
                function7 = function5;
                function8 = function6;
                colors3 = colors;
                interactionSource2 = interactionSource;
                $dirty1 = $dirty2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(496394889, $dirty, $dirty1, "androidx.compose.material3.SearchBarInputField (SearchBar.android.kt:409)");
            }
            $composer3.startReplaceGroup(462565938);
            ComposerKt.sourceInformation($composer3, "411@19327L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer3, 462565959, "CC(remember):SearchBar.android.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                mutableInteractionSource = interactionSource2;
            }
            $composer3.endReplaceGroup();
            final MutableInteractionSource interactionSource3 = mutableInteractionSource;
            ComposerKt.sourceInformationMarkerStart($composer3, 462566024, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv = new FocusRequester();
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv2;
            }
            final FocusRequester focusRequester = (FocusRequester) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FocusManager focusManager = (FocusManager) objConsume;
            Strings.Companion companion = Strings.INSTANCE;
            final String searchSemantics = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_search_bar_search), $composer3, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String suggestionsAvailableSemantics = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_suggestions_available), $composer3, 0);
            $composer3.startReplaceGroup(462566293);
            ComposerKt.sourceInformation($composer3, "*416@19647L7,417@19714L25");
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            long $this$takeOrElse_u2dDxMtmZc$iv = ((TextStyle) objConsume2).m6281getColor0d7_KjU();
            if (($this$takeOrElse_u2dDxMtmZc$iv != 16 ? 1 : 0) != 0) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                boolean focused = FocusInteractionKt.collectIsFocusedAsState(interactionSource3, $composer3, 0).getValue().booleanValue();
                textColor = colors3.m2785textColorXeAY9LY$material3_release(enabled2, false, focused);
            }
            $composer3.endReplaceGroup();
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(SizeKt.m917sizeInqDBjuR0$default(modifier2, SearchBarMinWidth, SearchBarDefaults.INSTANCE.m2539getInputFieldHeightD9Ej5fM(), SearchBarMaxWidth, 0.0f, 8, null), focusRequester);
            ComposerKt.sourceInformationMarkerStart($composer3, 462566810, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv = (57344 & $dirty) == 16384;
            enabled3 = enabled2;
            Object value$iv5 = $composer3.rememberedValue();
            if (invalid$iv || value$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState it) {
                        if (it.isFocused()) {
                            function3.invoke(true);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierOnFocusChanged = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester, (Function1) value$iv5);
            ComposerKt.sourceInformationMarkerStart($composer3, 462566876, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(searchSemantics) | (($dirty & 7168) == 2048) | $composer3.changed(suggestionsAvailableSemantics);
            Object value$iv6 = $composer3.rememberedValue();
            if (invalid$iv2 || value$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setContentDescription($this$semantics, searchSemantics);
                        if (active) {
                            SemanticsPropertiesKt.setStateDescription($this$semantics, suggestionsAvailableSemantics);
                        }
                        final FocusRequester focusRequester2 = focusRequester;
                        SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1.1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                focusRequester2.requestFocus();
                                return true;
                            }
                        }, 1, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierOnFocusChanged, false, (Function1) value$iv6, 1, null);
            ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localTextStyle2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextStyle textStyleMerge = ((TextStyle) objConsume3).merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            SolidColor solidColor = new SolidColor(colors3.m2735cursorColorvNxB06k$material3_release(false), null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6438getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 462567513, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv3 = (($dirty & 896) == 256) | (($dirty & 14) == 4);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope $this$$receiver) {
                        function2.invoke(query);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Function2<? super Composer, ? super Integer, Unit> function13 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function14 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function8;
            final TextFieldColors textFieldColors = colors3;
            int $dirty3 = $dirty;
            colors4 = colors3;
            BasicTextFieldKt.BasicTextField(query, function1, modifierSemantics$default, enabled3, false, textStyleMerge, keyboardOptions, new KeyboardActions(null, null, null, null, (Function1) value$iv2, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-951844929, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt.SearchBarInputField.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function16, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function16, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function16, Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C464@21740L15,450@21036L880:SearchBar.android.kt#uh7d8r");
                    int $dirty4 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty4 |= $composer4.changedInstance(function16) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 19) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951844929, $dirty5, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.android.kt:450)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = query;
                        boolean z = enabled3;
                        VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                        MutableInteractionSource mutableInteractionSource2 = interactionSource3;
                        Function2<Composer, Integer, Unit> function17 = function13;
                        final Function2<Composer, Integer, Unit> function18 = function14;
                        $composer4.startReplaceGroup(289230985);
                        ComposerKt.sourceInformation($composer4, "*458@21425L100");
                        ComposableLambda composableLambdaRememberComposableLambda = function18 == null ? null : ComposableLambdaKt.rememberComposableLambda(-1030845367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1$1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                Function0<ComposeUiNode> function0;
                                ComposerKt.sourceInformation($composer5, "C459@21447L60:SearchBar.android.kt#uh7d8r");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1030845367, $changed3, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:459)");
                                    }
                                    Modifier modifier$iv = OffsetKt.m829offsetVpY3zN4$default(Modifier.INSTANCE, SearchBar_androidKt.SearchBarIconOffsetX, 0.0f, 2, null);
                                    Function2<Composer, Integer, Unit> function19 = function18;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv = (6 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        function0 = constructor;
                                        $composer5.createNode(function0);
                                    } else {
                                        function0 = constructor;
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer5);
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i8 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i9 = ((6 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 643340868, "C459@21496L9:SearchBar.android.kt#uh7d8r");
                                    function19.invoke($composer5, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54);
                        $composer4.endReplaceGroup();
                        final Function2<Composer, Integer, Unit> function19 = function15;
                        $composer4.startReplaceGroup(289231151);
                        ComposerKt.sourceInformation($composer4, "*461@21592L102");
                        ComposableLambda composableLambdaRememberComposableLambda2 = function19 == null ? null : ComposableLambdaKt.rememberComposableLambda(-1558904811, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$2$1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                Function0<ComposeUiNode> function0;
                                ComposerKt.sourceInformation($composer5, "C462@21614L62:SearchBar.android.kt#uh7d8r");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1558904811, $changed3, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:462)");
                                    }
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    float arg0$iv = SearchBar_androidKt.SearchBarIconOffsetX;
                                    Modifier modifier$iv = OffsetKt.m829offsetVpY3zN4$default(companion3, C1979Dp.m6801constructorimpl(-arg0$iv), 0.0f, 2, null);
                                    Function2<Composer, Integer, Unit> function20 = function19;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        function0 = constructor;
                                        $composer5.createNode(function0);
                                    } else {
                                        function0 = constructor;
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer5);
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i8 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i9 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 643341036, "C462@21664L10:SearchBar.android.kt#uh7d8r");
                                    function20.invoke($composer5, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54);
                        $composer4.endReplaceGroup();
                        textFieldDefaults.DecorationBox(str, function16, z, true, none, mutableInteractionSource2, false, null, function17, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape($composer4, 6), textFieldColors, TextFieldDefaults.m2788contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m2129getLambda1$material3_release(), $composer4, (($dirty5 << 3) & 112) | 27648, 113246208, 14528);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, ($dirty & 14) | 102236160 | ($dirty & 112) | (($dirty >> 9) & 7168), ProfileVerifier.CompilationStatus.f245xf2722a21, 7696);
            $composer2 = $composer3;
            boolean isFocused = FocusInteractionKt.collectIsFocusedAsState(interactionSource3, $composer2, 0).getValue().booleanValue();
            boolean shouldClearFocus = !active && isFocused;
            Boolean boolValueOf = Boolean.valueOf(active);
            ComposerKt.sourceInformationMarkerStart($composer2, 462568711, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(shouldClearFocus) | $composer2.changedInstance(focusManager);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new SearchBar_androidKt$SearchBarInputField$5$1(shouldClearFocus, focusManager, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer2, ($dirty3 >> 9) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z = enabled3;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function8;
            final TextFieldColors textFieldColors2 = colors4;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt.SearchBarInputField.6
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
                    SearchBar_androidKt.SearchBarInputField(query, function1, function2, active, function3, modifier4, z, function16, function17, function18, textFieldColors2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: SearchBarImpl-j1jLAyQ, reason: not valid java name */
    public static final void m2546SearchBarImplj1jLAyQ(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState finalBackProgress, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Shape shape, SearchBarColors colors, float tonalElevation, float shadowElevation, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Shape shape2;
        SearchBarColors searchBarColors;
        float f;
        WindowInsets windowInsets2;
        Modifier modifier2;
        int $dirty;
        Shape shape3;
        SearchBarColors colors2;
        final SearchBarColors colors3;
        final float tonalElevation2;
        final float shadowElevation2;
        Shape shape4;
        int $dirty2;
        WindowInsets windowInsets3;
        int $dirty1;
        Shape defaultInputFieldShape;
        GenericShape value$iv;
        float shadowElevation3;
        Object value$iv2;
        float tonalElevation3;
        SearchBarColors colors4;
        Shape shape5;
        Composer $composer2 = $composer.startRestartGroup(-440333505);
        ComposerKt.sourceInformation($composer2, "C(SearchBarImpl)P(!1,4,5,3,7,6,9!1,10:c#ui.unit.Dp,8:c#ui.unit.Dp,11)679@32171L15,680@32236L8,683@32417L12,686@32515L7,688@32575L15,689@32642L15,690@32688L101,693@32814L578,707@33423L330,719@33778L99,731@34174L362:SearchBar.android.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= ($changed & 8) == 0 ? $composer2.changed(animatable) : $composer2.changedInstance(animatable) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(finalBackProgress) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changed(mutableState) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changed(mutableState2) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                shape2 = shape;
                int i3 = $composer2.changed(shape2) ? 1048576 : 524288;
                $dirty3 |= i3;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                searchBarColors = colors;
                int i4 = $composer2.changed(searchBarColors) ? 8388608 : 4194304;
                $dirty3 |= i4;
            } else {
                searchBarColors = colors;
            }
            $dirty3 |= i4;
        } else {
            searchBarColors = colors;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer2.changed(tonalElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty3 |= 805306368;
            f = shadowElevation;
        } else if (($changed & 805306368) == 0) {
            f = shadowElevation;
            $dirty3 |= $composer2.changed(f) ? 536870912 : 268435456;
        } else {
            f = shadowElevation;
        }
        if (($changed1 & 6) == 0) {
            if ((i & 1024) == 0) {
                windowInsets2 = windowInsets;
                int i7 = $composer2.changed(windowInsets2) ? 4 : 2;
                $dirty4 |= i7;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty4 |= i7;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 2048) != 0) {
            $dirty4 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        int $dirty5 = $dirty4;
        if ((306783379 & $dirty3) == 306783378 && ($dirty5 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            tonalElevation3 = tonalElevation;
            shape5 = shape2;
            colors4 = searchBarColors;
            windowInsets3 = windowInsets2;
            shadowElevation3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 64) != 0) {
                    $dirty = $dirty3 & (-3670017);
                    shape3 = SearchBarDefaults.INSTANCE.getInputFieldShape($composer2, 6);
                } else {
                    $dirty = $dirty3;
                    shape3 = shape2;
                }
                if ((i & 128) != 0) {
                    colors2 = SearchBarDefaults.INSTANCE.m2537colorsKlgxPg(0L, 0L, null, $composer2, 3072, 7);
                    $dirty &= -29360129;
                } else {
                    colors2 = colors;
                }
                float tonalElevation4 = i5 != 0 ? SearchBarDefaults.INSTANCE.m2541getTonalElevationD9Ej5fM() : tonalElevation;
                float shadowElevation4 = i6 != 0 ? SearchBarDefaults.INSTANCE.m2540getShadowElevationD9Ej5fM() : shadowElevation;
                if ((i & 1024) != 0) {
                    colors3 = colors2;
                    tonalElevation2 = tonalElevation4;
                    shape4 = shape3;
                    $dirty2 = $dirty;
                    windowInsets3 = SearchBarDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    shadowElevation2 = shadowElevation4;
                    $dirty1 = $dirty5 & (-15);
                } else {
                    colors3 = colors2;
                    tonalElevation2 = tonalElevation4;
                    shadowElevation2 = shadowElevation4;
                    shape4 = shape3;
                    $dirty2 = $dirty;
                    windowInsets3 = windowInsets;
                    $dirty1 = $dirty5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 1024) != 0) {
                    $dirty5 &= -15;
                }
                modifier2 = modifier;
                $dirty1 = $dirty5;
                $dirty2 = $dirty3;
                windowInsets3 = windowInsets2;
                shadowElevation2 = f;
                shape4 = shape2;
                colors3 = searchBarColors;
                tonalElevation2 = tonalElevation;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-440333505, $dirty2, $dirty1, "androidx.compose.material3.SearchBarImpl (SearchBar.android.kt:685)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) objConsume;
            Shape defaultInputFieldShape2 = SearchBarDefaults.INSTANCE.getInputFieldShape($composer2, 6);
            Shape defaultFullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape($composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1057814440, "CC(remember):SearchBar.android.kt#9igjgp");
            Object value$iv3 = $composer2.rememberedValue();
            if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$useFullScreenShape$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(animatable.getValue().floatValue() == 1.0f);
                    }
                });
                $composer2.updateRememberedValue(value$iv3);
            }
            State useFullScreenShape$delegate = (State) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean zSearchBarImpl_j1jLAyQ$lambda$17 = SearchBarImpl_j1jLAyQ$lambda$17(useFullScreenShape$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, 1057814566, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(zSearchBarImpl_j1jLAyQ$lambda$17) | ((((3670016 & $dirty2) ^ 1572864) > 1048576 && $composer2.changed(shape4)) || ($dirty2 & 1572864) == 1048576);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                if (Intrinsics.areEqual(shape4, defaultInputFieldShape2)) {
                    defaultInputFieldShape = defaultInputFieldShape2;
                    value$iv = new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$animatedShape$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Path path, Size size, LayoutDirection layoutDirection) {
                            m2551invoke12SF9DM(path, size.getPackedValue(), layoutDirection);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
                        public final void m2551invoke12SF9DM(Path $this$$receiver, long size, LayoutDirection layoutDirection) {
                            Density $this$invoke_12SF9DM_u24lambda_u240 = density;
                            Animatable<Float, AnimationVector1D> animatable2 = animatable;
                            float arg0$iv = SearchBar_androidKt.SearchBarCornerRadius;
                            float other$iv = 1 - animatable2.getValue().floatValue();
                            float radius = $this$invoke_12SF9DM_u24lambda_u240.mo567toPx0680j_4(C1979Dp.m6801constructorimpl(arg0$iv * other$iv));
                            Path.CC.addRoundRect$default($this$$receiver, RoundRectKt.m4104RoundRectsniSvfs(androidx.compose.p001ui.geometry.SizeKt.m4139toRectuvyYCjk(size), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null)), null, 2, null);
                        }
                    });
                } else {
                    defaultInputFieldShape = defaultInputFieldShape2;
                    value$iv = SearchBarImpl_j1jLAyQ$lambda$17(useFullScreenShape$delegate) ? defaultFullScreenShape : shape4;
                }
                $composer2.updateRememberedValue(value$iv);
            } else {
                defaultInputFieldShape = defaultInputFieldShape2;
                value$iv = it$iv;
            }
            final Shape animatedShape = (Shape) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            shadowElevation3 = shadowElevation2;
            Function2 surface = ComposableLambdaKt.rememberComposableLambda(-170534294, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$surface$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C712@33580L38,708@33433L314:SearchBar.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-170534294, $changed2, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:708)");
                        }
                        SurfaceKt.m2666SurfaceT9BRK9s(Modifier.INSTANCE, animatedShape, colors3.getContainerColor(), ColorSchemeKt.m2082contentColorForek8zF_U(colors3.getContainerColor(), $composer3, 0), tonalElevation2, shadowElevation2, null, ComposableSingletons$SearchBar_androidKt.INSTANCE.m2130getLambda2$material3_release(), $composer3, 12582918, 64);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            ComposerKt.sourceInformationMarkerStart($composer2, 1057815530, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$showContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(animatable.getValue().floatValue() > 0.0f);
                    }
                });
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            State showContent$delegate = (State) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(1057815682);
            ComposerKt.sourceInformation($composer2, "723@33957L195");
            Function2 wrappedContent = SearchBarImpl_j1jLAyQ$lambda$20(showContent$delegate) ? ComposableLambdaKt.rememberComposableLambda(147843820, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$wrappedContent$1
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
                    Object value$iv4;
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C724@34001L35,724@33971L171:SearchBar.android.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(147843820, $changed2, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:724)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1124611350, "CC(remember):SearchBar.android.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changedInstance(animatable);
                    final Animatable<Float, AnimationVector1D> animatable2 = animatable;
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$wrappedContent$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                invoke2(graphicsLayerScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                                $this$graphicsLayer.setAlpha(animatable2.getValue().floatValue());
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) value$iv4);
                    SearchBarColors searchBarColors2 = colors3;
                    Function3<ColumnScope, Composer, Integer, Unit> function4 = function3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
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
                    int i8 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScope $this$invoke_u24lambda_u241 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -637440062, "C725@34056L46,726@34119L9:SearchBar.android.kt#uh7d8r");
                    DividerKt.m2223HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors2.getDividerColor(), $composer3, 0, 3);
                    function4.invoke($this$invoke_u24lambda_u241, $composer3, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54) : null;
            $composer2.endReplaceGroup();
            tonalElevation3 = tonalElevation2;
            colors4 = colors3;
            shape5 = shape4;
            SearchBarLayout(animatable, finalBackProgress, mutableState, mutableState2, modifier2, windowInsets3, function2, surface, wrappedContent, $composer2, Animatable.$stable | 12582912 | ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty1 << 15) & 458752) | (($dirty2 << 3) & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Shape shape6 = shape5;
            final SearchBarColors searchBarColors2 = colors4;
            final float f2 = tonalElevation3;
            final float f3 = shadowElevation3;
            final WindowInsets windowInsets4 = windowInsets3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$1
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
                    SearchBar_androidKt.m2546SearchBarImplj1jLAyQ(animatable, finalBackProgress, mutableState, mutableState2, modifier3, function2, shape6, searchBarColors2, f2, f3, windowInsets4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$17(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$20(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchBarLayout(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState finalBackProgress, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, final Modifier modifier, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function5;
        Function0<ComposeUiNode> function6;
        Composer $composer2 = $composer.startRestartGroup(70029564);
        ComposerKt.sourceInformation($composer2, "C(SearchBarLayout)P(!1,3,4,2,6,8,5,7)760@35233L34,764@35375L112,781@36031L4393,761@35272L5152:SearchBar.android.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(animatable) : $composer2.changedInstance(animatable) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(finalBackProgress) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(mutableState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(mutableState2) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(windowInsets) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((38347923 & $dirty2) != 38347922 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70029564, $dirty2, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:756)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 948528079, "CC(remember):SearchBar.android.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MutableWindowInsets(null, 1, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableWindowInsets unconsumedInsets = (MutableWindowInsets) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierZIndex = ZIndexModifierKt.zIndex(modifier, 1.0f);
            ComposerKt.sourceInformationMarkerStart($composer2, 948528221, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty2) == 131072;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets2) {
                        invoke2(windowInsets2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WindowInsets consumedInsets) {
                        unconsumedInsets.setInsets(WindowInsetsKt.exclude(windowInsets, consumedInsets));
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex, (Function1) value$iv2), unconsumedInsets);
            ComposerKt.sourceInformationMarkerStart($composer2, 948528877, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer2.changedInstance(animatable))) | (($dirty2 & 7168) == 2048) | (($dirty2 & 112) == 32) | (($dirty2 & 896) == 256);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new MeasurePolicy() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1
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
                        Object it$iv3;
                        final Placeable contentPlaceable;
                        int i;
                        int iM6743getMaxHeightimpl;
                        final float animationProgress = animatable.getValue().floatValue();
                        List<? extends Measurable> list2 = list;
                        int $i$f$fastFirst = 0;
                        int index$iv$iv = 0;
                        int size = list2.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = list2.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            List<? extends Measurable> list3 = list2;
                            int $i$f$fastFirst2 = $i$f$fastFirst;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "InputField")) {
                                Measurable inputFieldMeasurable = (Measurable) item$iv$iv;
                                List<? extends Measurable> list4 = list;
                                int $i$f$fastFirst3 = 0;
                                int index$iv$iv2 = 0;
                                int size2 = list4.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = list4.get(index$iv$iv2);
                                    Measurable it2 = (Measurable) item$iv$iv2;
                                    List<? extends Measurable> list5 = list4;
                                    int $i$f$fastFirst4 = $i$f$fastFirst3;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "Surface")) {
                                        Measurable surfaceMeasurable = (Measurable) item$iv$iv2;
                                        List<? extends Measurable> list6 = list;
                                        int index$iv$iv3 = 0;
                                        int size3 = list6.size();
                                        while (true) {
                                            if (index$iv$iv3 >= size3) {
                                                it$iv3 = null;
                                                break;
                                            }
                                            it$iv3 = list6.get(index$iv$iv3);
                                            Measurable it3 = (Measurable) it$iv3;
                                            List<? extends Measurable> list7 = list6;
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "Content")) {
                                                break;
                                            }
                                            index$iv$iv3++;
                                            list6 = list7;
                                        }
                                        Measurable contentMeasurable = (Measurable) it$iv3;
                                        final int topPadding = unconsumedInsets.getTop($this$Layout) + $this$Layout.mo561roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding());
                                        int bottomPadding = $this$Layout.mo561roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding());
                                        int defaultStartWidth = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, inputFieldMeasurable.maxIntrinsicWidth(Constraints.m6743getMaxHeightimpl(constraints)));
                                        int defaultStartHeight = ConstraintsKt.m6760constrainHeightK40F9xA(constraints, inputFieldMeasurable.minIntrinsicHeight(Constraints.m6744getMaxWidthimpl(constraints)));
                                        int predictiveBackStartWidth = MathKt.roundToInt(Constraints.m6744getMaxWidthimpl(constraints) * 0.9f);
                                        int predictiveBackStartHeight = MathKt.roundToInt(Constraints.m6743getMaxHeightimpl(constraints) * 0.9f);
                                        final float predictiveBackMultiplier = SearchBar_androidKt.calculatePredictiveBackMultiplier(mutableState2.getValue(), animationProgress, finalBackProgress.getFloatValue());
                                        int startWidth = MathHelpersKt.lerp(defaultStartWidth, predictiveBackStartWidth, predictiveBackMultiplier);
                                        int predictiveBackStartWidth2 = topPadding + defaultStartHeight;
                                        int startHeight = MathHelpersKt.lerp(predictiveBackStartWidth2, predictiveBackStartHeight, predictiveBackMultiplier);
                                        int endWidth = Constraints.m6744getMaxWidthimpl(constraints);
                                        int endHeight = Constraints.m6743getMaxHeightimpl(constraints);
                                        int width = MathHelpersKt.lerp(startWidth, endWidth, animationProgress);
                                        final int height = MathHelpersKt.lerp(startHeight, endHeight, animationProgress);
                                        final int animatedTopPadding = MathHelpersKt.lerp(topPadding, 0, animationProgress);
                                        final int animatedBottomPadding = MathHelpersKt.lerp(0, bottomPadding, animationProgress);
                                        int defaultStartWidth2 = height - animatedTopPadding;
                                        final Placeable surfacePlaceable = surfaceMeasurable.mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(width, defaultStartWidth2));
                                        final Placeable inputFieldPlaceable = inputFieldMeasurable.mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(width, defaultStartHeight));
                                        if (contentMeasurable != null) {
                                            if (Constraints.m6739getHasBoundedHeightimpl(constraints)) {
                                                i = 0;
                                                iM6743getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m6743getMaxHeightimpl(constraints) - ((topPadding + defaultStartHeight) + bottomPadding), 0);
                                            } else {
                                                i = 0;
                                                iM6743getMaxHeightimpl = Constraints.m6743getMaxHeightimpl(constraints);
                                            }
                                            contentPlaceable = contentMeasurable.mo5644measureBRTryo0(ConstraintsKt.Constraints(width, width, i, iM6743getMaxHeightimpl));
                                        } else {
                                            contentPlaceable = null;
                                        }
                                        final MutableState<BackEventCompat> mutableState3 = mutableState2;
                                        final MutableState<BackEventCompat> mutableState4 = mutableState;
                                        return MeasureScope.CC.layout$default($this$Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1.1
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
                                                int minOffsetMargin = $this$Layout.mo561roundToPx0680j_4(SearchBar_androidKt.SearchBarPredictiveBackMinMargin);
                                                int predictiveBackOffsetX = SearchBar_androidKt.m2549calculatePredictiveBackOffsetXrOvwMX4(constraints, minOffsetMargin, mutableState3.getValue(), $this$Layout.getLayoutDirection(), animationProgress, predictiveBackMultiplier);
                                                int predictiveBackOffsetY = SearchBar_androidKt.m2550calculatePredictiveBackOffsetYdzo92Q0(constraints, minOffsetMargin, mutableState3.getValue(), mutableState4.getValue(), height, $this$Layout.mo561roundToPx0680j_4(SearchBar_androidKt.SearchBarPredictiveBackMaxOffsetY), predictiveBackMultiplier);
                                                Placeable.PlacementScope.placeRelative$default($this$layout, surfacePlaceable, predictiveBackOffsetX, predictiveBackOffsetY + animatedTopPadding, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default($this$layout, inputFieldPlaceable, predictiveBackOffsetX, predictiveBackOffsetY + topPadding, 0.0f, 4, null);
                                                Placeable placeable = contentPlaceable;
                                                if (placeable != null) {
                                                    Placeable.PlacementScope.placeRelative$default($this$layout, placeable, predictiveBackOffsetX, topPadding + predictiveBackOffsetY + inputFieldPlaceable.getHeight() + animatedBottomPadding, 0.0f, 4, null);
                                                }
                                            }
                                        }, 4, null);
                                    }
                                    index$iv$iv2++;
                                    $this$Layout = $this$Layout;
                                    constraints = constraints;
                                    list4 = list5;
                                    $i$f$fastFirst3 = $i$f$fastFirst4;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            index$iv$iv++;
                            list2 = list3;
                            $i$f$fastFirst = $i$f$fastFirst2;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifierConsumeWindowInsets);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -728460733, "C769@35572L113,772@35698L119:SearchBar.android.kt#uh7d8r");
            Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSurface);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor2;
                $composer2.createNode(function1);
            } else {
                function1 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2133333566, "C770@35662L9:SearchBar.android.kt#uh7d8r");
            function3.invoke($composer2, Integer.valueOf(($dirty2 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdInputField);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, true);
            int $changed$iv$iv3 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function5 = constructor3;
                $composer2.createNode(function5);
            } else {
                function5 = constructor3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i5 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2133333695, "C773@35791L12:SearchBar.android.kt#uh7d8r");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 18) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(948528685);
            ComposerKt.sourceInformation($composer2, "*776@35872L127");
            if (function4 != null) {
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSearchContent);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, true);
                int $changed$iv$iv4 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function6 = constructor4;
                    $composer2.createNode(function6);
                } else {
                    function6 = constructor4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                int i7 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -235523691, "C777@35972L9:SearchBar.android.kt#uh7d8r");
                function4.invoke($composer2, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt.SearchBarLayout.4
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
                    SearchBar_androidKt.SearchBarLayout(animatable, finalBackProgress, mutableState, mutableState2, modifier, windowInsets, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackMultiplier(BackEventCompat currentBackEvent, float progress, float finalBackProgress) {
        if (currentBackEvent == null) {
            return 0.0f;
        }
        if (Float.isNaN(finalBackProgress)) {
            return 1.0f;
        }
        if (finalBackProgress <= 0.0f) {
            return 0.0f;
        }
        return progress / finalBackProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculatePredictiveBackOffsetX-rOvwMX4, reason: not valid java name */
    public static final int m2549calculatePredictiveBackOffsetXrOvwMX4(long constraints, int minMargin, BackEventCompat currentBackEvent, LayoutDirection layoutDirection, float progress, float predictiveBackMultiplier) {
        if (currentBackEvent != null) {
            if (!(predictiveBackMultiplier == 0.0f)) {
                int directionMultiplier = currentBackEvent.getSwipeEdge() == 0 ? 1 : -1;
                int rtlMultiplier = layoutDirection == LayoutDirection.Ltr ? 1 : -1;
                float maxOffsetX = (Constraints.m6744getMaxWidthimpl(constraints) * SearchBarPredictiveBackMaxOffsetXRatio) - minMargin;
                float interpolatedOffsetX = (1 - progress) * maxOffsetX;
                return MathKt.roundToInt(interpolatedOffsetX * predictiveBackMultiplier * directionMultiplier * rtlMultiplier);
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculatePredictiveBackOffsetY-dzo92Q0, reason: not valid java name */
    public static final int m2550calculatePredictiveBackOffsetYdzo92Q0(long constraints, int minMargin, BackEventCompat currentBackEvent, BackEventCompat firstBackEvent, int height, int maxOffsetY, float predictiveBackMultiplier) {
        if (firstBackEvent != null && currentBackEvent != null) {
            if (!(predictiveBackMultiplier == 0.0f)) {
                int availableVerticalSpace = Math.max(0, ((Constraints.m6743getMaxHeightimpl(constraints) - height) / 2) - minMargin);
                int adjustedMaxOffsetY = Math.min(availableVerticalSpace, maxOffsetY);
                float yDelta = currentBackEvent.getTouchY() - firstBackEvent.getTouchY();
                float yProgress = Math.abs(yDelta) / Constraints.m6743getMaxHeightimpl(constraints);
                float directionMultiplier = Math.signum(yDelta);
                int interpolatedOffsetY = MathHelpersKt.lerp(0, adjustedMaxOffsetY, yProgress);
                return MathKt.roundToInt(interpolatedOffsetY * predictiveBackMultiplier * directionMultiplier);
            }
        }
        return 0;
    }

    static {
        float arg0$iv = SearchBarDefaults.INSTANCE.m2539getInputFieldHeightD9Ej5fM();
        SearchBarCornerRadius = C1979Dp.m6801constructorimpl(arg0$iv / 2);
        DockedActiveTableMinHeight = C1979Dp.m6801constructorimpl(240);
        SearchBarMinWidth = C1979Dp.m6801constructorimpl(360);
        SearchBarMaxWidth = C1979Dp.m6801constructorimpl(720);
        SearchBarVerticalPadding = C1979Dp.m6801constructorimpl(8);
        SearchBarIconOffsetX = C1979Dp.m6801constructorimpl(4);
        SearchBarPredictiveBackMinMargin = C1979Dp.m6801constructorimpl(8);
        SearchBarPredictiveBackMaxOffsetY = C1979Dp.m6801constructorimpl(24);
        AnimationEnterEasing = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationExitEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationEnterFloatSpec = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, AnimationEnterEasing);
        AnimationExitFloatSpec = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, AnimationExitEasing);
        AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(AnimationExitDurationMillis, 0, AnimationExitEasing, 2, null);
        AnimationEnterSizeSpec = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, AnimationEnterEasing);
        AnimationExitSizeSpec = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, AnimationExitEasing);
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(AnimationEnterFloatSpec, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(AnimationEnterSizeSpec, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(AnimationExitFloatSpec, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(AnimationExitSizeSpec, null, false, null, 14, null));
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }
}
