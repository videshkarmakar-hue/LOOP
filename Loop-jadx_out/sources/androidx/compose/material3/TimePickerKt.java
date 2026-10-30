package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarLocale_jvmKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TouchExplorationStateProvider_androidKt;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.ZIndexModifierKt;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.focus.FocusRequester;
import androidx.compose.p001ui.focus.FocusRequesterModifierKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.graphics.BlendMode;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.input.key.KeyEvent;
import androidx.compose.p001ui.input.key.KeyEvent_androidKt;
import androidx.compose.p001ui.input.key.KeyInputModifierKt;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.LayoutCoordinatesKt;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.KeyboardType;
import androidx.compose.p001ui.text.input.PlatformImeOptions;
import androidx.compose.p001ui.text.input.TextFieldValue;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.LineHeightStyle;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpOffset;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000²\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\u001a7\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00190\u001e¢\u0006\u0002\b\u001fH\u0003ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001d\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u0010+\u001a-\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u0010.\u001a\u0015\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u00100\u001a\u001d\u00101\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u00104\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a=\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0003¢\u0006\u0002\u0010<\u001a)\u0010=\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010>\u001a%\u0010?\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010@\u001a8\u0010A\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010B\u001a\u00020CH\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001ab\u0010F\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00190I2\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a:\u0010R\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001aQ\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020:2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010%\u001a\u00020&2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00190I¢\u0006\u0002\b\u001f¢\u0006\u0002\bZH\u0003¢\u0006\u0002\u0010[\u001a\u001d\u0010\\\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010]\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u0010^\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a\u0018\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0002\u001a(\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007H\u0002\u001a*\u0010g\u001a\u00020h2\u0006\u0010J\u001a\u00020K2\u0006\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a+\u0010m\u001a\u00020$2\b\b\u0002\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020\u00072\b\b\u0002\u0010i\u001a\u00020*H\u0007¢\u0006\u0002\u0010p\u001a]\u0010q\u001a\u00020\u00192\u0006\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020G2\u0006\u0010r\u001a\u00020G2\u0006\u0010s\u001a\u00020\u00072!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bu\u0012\b\bv\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00190IH\u0002ø\u0001\u0000¢\u0006\u0004\bw\u0010x\u001a$\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0z2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\tH\u0002\u001a\u001c\u0010}\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0014\u0010~\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010~\u001a\u00020*H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u007f²\u0006\u000b\u0010\u0080\u0001\u001a\u00020*X\u008a\u0084\u0002²\u0006\u000b\u0010\u0081\u0001\u001a\u00020GX\u008a\u008e\u0002²\u0006\u000b\u0010\u0082\u0001\u001a\u00020GX\u008a\u008e\u0002²\u0006\f\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u008a\u008e\u0002"}, m195d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "", "", "FullCircle", "", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "Landroidx/compose/material3/TimePickerState;", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", DownloadUtil.CookieScheme.VALUE, "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/Selection;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-lxUZ_iY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-uXwN82Y", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "is24Hour", "number", "numberContentDescription-YKJpE6Y", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "initialHour", "initialMinute", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-gIWD5Rc", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "valuesForAnimation", "Lkotlin/Pair;", "current", "new", "drawSelector", "visible", "material3_release", "touchExplorationServicesEnabled", "hourValue", "minuteValue", "center", "Landroidx/compose/ui/geometry/Offset;"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TimePickerKt {
    private static final List<Integer> ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float OuterCircleSizeRadius = C1979Dp.m6801constructorimpl(HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS);
    private static final float InnerCircleRadius = C1979Dp.m6801constructorimpl(69);
    private static final float ClockDisplayBottomMargin = C1979Dp.m6801constructorimpl(36);
    private static final float ClockFaceBottomMargin = C1979Dp.m6801constructorimpl(24);
    private static final float DisplaySeparatorWidth = C1979Dp.m6801constructorimpl(24);
    private static final float SupportLabelTop = C1979Dp.m6801constructorimpl(7);
    private static final float TimeInputBottomPadding = C1979Dp.m6801constructorimpl(24);
    private static final float MaxDistance = C1979Dp.m6801constructorimpl(74);
    private static final float MinimumInteractiveSize = C1979Dp.m6801constructorimpl(48);
    private static final List<Integer> Minutes = CollectionsKt.listOf((Object[]) new Integer[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55});
    private static final List<Integer> Hours = CollectionsKt.listOf((Object[]) new Integer[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});

    /* JADX INFO: renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    public static final void m2844TimePickermT9BvqQ(final TimePickerState state, Modifier modifier, TimePickerColors colors, int layoutType, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TimePickerColors timePickerColors;
        int layoutType2;
        Modifier.Companion modifier3;
        TimePickerColors colors2;
        Modifier modifier4;
        TimePickerColors colors3;
        int layoutType3;
        Composer $composer2 = $composer.startRestartGroup(-619286452);
        ComposerKt.sourceInformation($composer2, "C(TimePicker)P(3,2!,1:c#material3.TimePickerLayoutType)211@11283L8,212@11351L12,214@11412L23:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                timePickerColors = colors;
                int i3 = $composer2.changed(timePickerColors) ? 256 : 128;
                $dirty |= i3;
            } else {
                timePickerColors = colors;
            }
            $dirty |= i3;
        } else {
            timePickerColors = colors;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                layoutType2 = layoutType;
                int i4 = $composer2.changed(layoutType2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                layoutType2 = layoutType;
            }
            $dirty |= i4;
        } else {
            layoutType2 = layoutType;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            colors3 = timePickerColors;
            layoutType3 = layoutType2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    colors2 = TimePickerDefaults.INSTANCE.colors($composer2, 6);
                    $dirty &= -897;
                } else {
                    colors2 = timePickerColors;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    layoutType2 = TimePickerDefaults.INSTANCE.m2842layoutTypesDNSZnc($composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
                colors2 = timePickerColors;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619286452, $dirty, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:213)");
            }
            State<Boolean> state2 = TouchExplorationStateProvider_androidKt.touchExplorationState($composer2, 0);
            if (TimePickerLayoutType.m2858equalsimpl0(layoutType2, TimePickerLayoutType.INSTANCE.m2863getVerticalQJTpgSE())) {
                $composer2.startReplaceGroup(1318082766);
                ComposerKt.sourceInformation($composer2, "217@11500L184");
                VerticalTimePicker(state, modifier3, colors2, !TimePicker_mT9BvqQ$lambda$0(state2), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1318082972);
                ComposerKt.sourceInformation($composer2, "224@11706L186");
                HorizontalTimePicker(state, modifier3, colors2, !TimePicker_mT9BvqQ$lambda$0(state2), $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            colors3 = colors2;
            layoutType3 = layoutType2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final TimePickerColors timePickerColors2 = colors3;
            final int i5 = layoutType3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePicker$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    TimePickerKt.m2844TimePickermT9BvqQ(state, modifier5, timePickerColors2, i5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    public static final void TimeInput(final TimePickerState state, Modifier modifier, TimePickerColors colors, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-760850373);
        ComposerKt.sourceInformation($composer2, "C(TimeInput)P(2,1)253@12782L8,255@12800L38:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ((i & 4) == 0 && $composer2.changed(colors)) ? 256 : 128;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    colors = TimePickerDefaults.INSTANCE.colors($composer2, 6);
                    $dirty &= -897;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-760850373, $dirty, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:254)");
            }
            TimeInputImpl(modifier, colors, state, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            final TimePickerColors timePickerColors = colors;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.TimeInput.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    TimePickerKt.TimeInput(state, modifier2, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final TimePickerState rememberTimePickerState(int initialHour, int initialMinute, boolean is24Hour, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1237715277, "C(rememberTimePickerState)561@28146L14,564@28239L133,562@28183L189:TimePicker.kt#uh7d8r");
        final int initialHour2 = (i & 1) != 0 ? 0 : initialHour;
        final int initialMinute2 = (i & 2) != 0 ? 0 : initialMinute;
        final boolean is24Hour2 = (i & 4) != 0 ? TimeFormat_androidKt.is24HourFormat($composer, 0) : is24Hour;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, $changed, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:562)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerState, ?> Saver = TimePickerState.INSTANCE.Saver();
        ComposerKt.sourceInformationMarkerStart($composer, 1737741033, "CC(remember):TimePicker.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(initialHour2)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialMinute2)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(is24Hour2)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<TimePickerState>() { // from class: androidx.compose.material3.TimePickerKt$rememberTimePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TimePickerState invoke() {
                    return new TimePickerState(initialHour2, initialMinute2, is24Hour2);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        TimePickerState timePickerState = (TimePickerState) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return timePickerState;
    }

    public static final void VerticalTimePicker(final TimePickerState state, Modifier modifier, TimePickerColors colors, final boolean autoSwitchToMinute, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TimePickerColors colors2;
        Modifier.Companion modifier3;
        Function0<ComposeUiNode> function0;
        Modifier modifier4;
        TimePickerColors colors3;
        Composer $composer2 = $composer.startRestartGroup(310683247);
        ComposerKt.sourceInformation($composer2, "C(VerticalTimePicker)P(3,2,1)787@35670L8,790@35720L379:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                int i3 = $composer2.changed(colors2) ? 256 : 128;
                $dirty |= i3;
            } else {
                colors2 = colors;
            }
            $dirty |= i3;
        } else {
            colors2 = colors;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(autoSwitchToMinute) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            colors3 = colors2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    colors2 = TimePickerDefaults.INSTANCE.colors($composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(310683247, $dirty, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:789)");
            }
            Modifier modifier$iv = SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalTimePicker.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.setTraversalGroup($this$semantics, true);
                }
            }, 1, null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 37443019, "C794@35870L35,795@35914L60,796@35983L44,797@36036L57:TimePicker.kt#uh7d8r");
            VerticalClockDisplay(state, colors2, $composer2, ($dirty & 14) | (($dirty >> 3) & 112));
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, ClockDisplayBottomMargin), $composer2, 6);
            ClockFace(state, colors2, autoSwitchToMinute, $composer2, ($dirty & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896));
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, ClockFaceBottomMargin), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final TimePickerColors timePickerColors = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalTimePicker.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    TimePickerKt.VerticalTimePicker(state, modifier6, timePickerColors, autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void HorizontalTimePicker(final TimePickerState state, Modifier modifier, TimePickerColors colors, final boolean autoSwitchToMinute, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TimePickerColors colors2;
        Modifier.Companion modifier3;
        Function0<ComposeUiNode> function0;
        Modifier modifier4;
        TimePickerColors colors3;
        Composer $composer2 = $composer.startRestartGroup(5079681);
        ComposerKt.sourceInformation($composer2, "C(HorizontalTimePicker)P(3,2,1)805@36263L8,808@36313L309:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                int i3 = $composer2.changed(colors2) ? 256 : 128;
                $dirty |= i3;
            } else {
                colors2 = colors;
            }
            $dirty |= i3;
        } else {
            colors2 = colors;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(autoSwitchToMinute) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            colors3 = colors2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    colors2 = TimePickerDefaults.INSTANCE.colors($composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(5079681, $dirty, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:807)");
            }
            Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(modifier3, 0.0f, 0.0f, 0.0f, ClockFaceBottomMargin, 7, null);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            Modifier modifier5 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -321629079, "C812@36458L37,813@36504L59,814@36572L44:TimePicker.kt#uh7d8r");
            HorizontalClockDisplay(state, colors2, $composer2, ($dirty & 14) | (($dirty >> 3) & 112));
            SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, ClockDisplayBottomMargin), $composer2, 6);
            ClockFace(state, colors2, autoSwitchToMinute, $composer2, ($dirty & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final TimePickerColors timePickerColors = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.HorizontalTimePicker.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    TimePickerKt.HorizontalTimePicker(state, modifier6, timePickerColors, autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimeInputImpl(final Modifier modifier, final TimePickerColors colors, final TimePickerState state, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Composer $composer3 = $composer.startRestartGroup(-475657989);
        ComposerKt.sourceInformation($composer3, "C(TimeInputImpl)P(1)824@36824L104,824@36772L156,827@37004L96,827@36952L148,830@37105L4224:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(colors) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(state) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, $dirty2, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:823)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart($composer3, 565122910, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(state.getHourForDisplay$material3_release(), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final MutableState hourValue$delegate = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv, $composer3, 0, 4);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart($composer3, 565123090, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(state.getMinute(), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final MutableState minuteValue$delegate = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (String) null, (Function0) value$iv2, $composer3, 0, 4);
            $composer2 = $composer3;
            Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, null);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1230437859, "C834@37268L10,844@37700L3198,840@37479L3419:TimePicker.kt#uh7d8r");
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont());
            TextStyle textStyle = textStyleFromToken.m6277copyp1EtxEg((16777213 & 1) != 0 ? textStyleFromToken.spanStyle.m6199getColor0d7_KjU() : colors.m2840timeSelectorContentColorvNxB06k$material3_release(true), (16777213 & 2) != 0 ? textStyleFromToken.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyleFromToken.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyleFromToken.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyleFromToken.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyleFromToken.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyleFromToken.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyleFromToken.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyleFromToken.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyleFromToken.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyleFromToken.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyleFromToken.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyleFromToken.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyleFromToken.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyleFromToken.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyleFromToken.paragraphStyle.getTextAlign() : TextAlign.INSTANCE.m6658getCentere0LSkKk(), (16777213 & 65536) != 0 ? textStyleFromToken.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyleFromToken.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyleFromToken.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyleFromToken.platformStyle : null, (16777213 & 1048576) != 0 ? textStyleFromToken.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyleFromToken.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? textStyleFromToken.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyleFromToken.paragraphStyle.getTextMotion() : null);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(textStyle), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(1306700887, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv3;
                    Object value$iv4;
                    Object value$iv5;
                    Object value$iv6;
                    Object value$iv7;
                    ComposerKt.sourceInformation($composer4, "C845@37714L3174:TimePicker.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1306700887, $changed2, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:845)");
                        }
                        final MutableState<TextFieldValue> mutableState = hourValue$delegate;
                        final TimePickerState timePickerState = state;
                        TimePickerColors timePickerColors = colors;
                        final MutableState<TextFieldValue> mutableState2 = minuteValue$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv2 = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(constructor2);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 406460881, "C848@37833L443,860@38353L385,875@39075L82,846@37736L1478,880@39231L193,888@39545L408,901@40033L363,916@40735L82,886@39441L1433:TimePicker.kt#uh7d8r");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 406460978, "CC(remember):TimePicker.kt#9igjgp");
                        boolean invalid$iv3 = $composer4.changed(mutableState) | $composer4.changed(timePickerState);
                        Object value$iv8 = $composer4.rememberedValue();
                        if (invalid$iv3 || value$iv8 == Composer.INSTANCE.getEmpty()) {
                            value$iv8 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m2853invokeZmokQxo(keyEvent.m5358unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                public final Boolean m2853invokeZmokQxo(android.view.KeyEvent event) {
                                    int iM5371getUtf16CodePointZmokQxo = KeyEvent_androidKt.m5371getUtf16CodePointZmokQxo(event);
                                    boolean switchFocus = (48 <= iM5371getUtf16CodePointZmokQxo && iM5371getUtf16CodePointZmokQxo < 58) && TextRange.m6251getStartimpl(TimePickerKt.TimeInputImpl$lambda$5(mutableState).getSelection()) == 2 && TimePickerKt.TimeInputImpl$lambda$5(mutableState).getText().length() == 2;
                                    if (switchFocus) {
                                        timePickerState.m2868setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2599getMinuteJiIwxys());
                                    }
                                    return false;
                                }
                            };
                            $composer4.updateRememberedValue(value$iv8);
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion, (Function1) value$iv8);
                        TextFieldValue textFieldValueTimeInputImpl$lambda$5 = TimePickerKt.TimeInputImpl$lambda$5(mutableState);
                        ComposerKt.sourceInformationMarkerStart($composer4, 406461498, "CC(remember):TimePicker.kt#9igjgp");
                        boolean invalid$iv4 = $composer4.changed(timePickerState) | $composer4.changed(mutableState);
                        Object it$iv3 = $composer4.rememberedValue();
                        if (invalid$iv4 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue newValue) {
                                    int iM2598getHourJiIwxys = Selection.INSTANCE.m2598getHourJiIwxys();
                                    TimePickerState timePickerState2 = timePickerState;
                                    TextFieldValue textFieldValueTimeInputImpl$lambda$6 = TimePickerKt.TimeInputImpl$lambda$5(mutableState);
                                    int i5 = timePickerState.getIs24hour() ? 23 : 12;
                                    final MutableState<TextFieldValue> mutableState3 = mutableState;
                                    TimePickerKt.m2852timeInputOnChangegIWD5Rc(iM2598getHourJiIwxys, timePickerState2, newValue, textFieldValueTimeInputImpl$lambda$6, i5, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                            invoke2(textFieldValue);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextFieldValue it) {
                                            mutableState3.setValue(it);
                                        }
                                    });
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        Function1 function2 = (Function1) value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        int iM2598getHourJiIwxys = Selection.INSTANCE.m2598getHourJiIwxys();
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6489getNumberPjHm6EE(), ImeAction.INSTANCE.m6435getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 406462220, "CC(remember):TimePicker.kt#9igjgp");
                        boolean invalid$iv5 = $composer4.changed(timePickerState);
                        Object it$iv4 = $composer4.rememberedValue();
                        if (invalid$iv5 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$3$1
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
                                    timePickerState.m2868setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2599getMinuteJiIwxys());
                                }
                            };
                            $composer4.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        TimePickerKt.m2845TimePickerTextFieldlxUZ_iY(modifierOnKeyEvent, textFieldValueTimeInputImpl$lambda$5, function2, timePickerState, iM2598getHourJiIwxys, keyboardOptions, new KeyboardActions(null, null, (Function1) value$iv4, null, null, null, 59, null), timePickerColors, $composer4, CpioConstants.C_ISBLK, 0);
                        TimePickerKt.DisplaySeparator(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimePickerKt.DisplaySeparatorWidth, TimeInputTokens.INSTANCE.m3633getPeriodSelectorContainerHeightD9Ej5fM()), $composer4, 6);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 406462690, "CC(remember):TimePicker.kt#9igjgp");
                        boolean invalid$iv6 = $composer4.changed(mutableState2) | $composer4.changed(timePickerState);
                        Object it$iv5 = $composer4.rememberedValue();
                        if (invalid$iv6 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m2854invokeZmokQxo(keyEvent.m5358unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                public final Boolean m2854invokeZmokQxo(android.view.KeyEvent event) {
                                    boolean switchFocus = KeyEvent_androidKt.m5371getUtf16CodePointZmokQxo(event) == 0 && TextRange.m6251getStartimpl(TimePickerKt.TimeInputImpl$lambda$8(mutableState2).getSelection()) == 0;
                                    if (switchFocus) {
                                        timePickerState.m2868setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2598getHourJiIwxys());
                                    }
                                    return Boolean.valueOf(switchFocus);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifierOnPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(companion2, (Function1) value$iv5);
                        TextFieldValue textFieldValueTimeInputImpl$lambda$8 = TimePickerKt.TimeInputImpl$lambda$8(mutableState2);
                        ComposerKt.sourceInformationMarkerStart($composer4, 406463178, "CC(remember):TimePicker.kt#9igjgp");
                        boolean invalid$iv7 = $composer4.changed(timePickerState) | $composer4.changed(mutableState2);
                        Object it$iv6 = $composer4.rememberedValue();
                        if (invalid$iv7 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                            value$iv6 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue newValue) {
                                    int iM2599getMinuteJiIwxys = Selection.INSTANCE.m2599getMinuteJiIwxys();
                                    TimePickerState timePickerState2 = timePickerState;
                                    TextFieldValue textFieldValueTimeInputImpl$lambda$9 = TimePickerKt.TimeInputImpl$lambda$8(mutableState2);
                                    final MutableState<TextFieldValue> mutableState3 = mutableState2;
                                    TimePickerKt.m2852timeInputOnChangegIWD5Rc(iM2599getMinuteJiIwxys, timePickerState2, newValue, textFieldValueTimeInputImpl$lambda$9, 59, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                            invoke2(textFieldValue);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextFieldValue it) {
                                            mutableState3.setValue(it);
                                        }
                                    });
                                }
                            };
                            $composer4.updateRememberedValue(value$iv6);
                        } else {
                            value$iv6 = it$iv6;
                        }
                        Function1 function3 = (Function1) value$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        int iM2599getMinuteJiIwxys = Selection.INSTANCE.m2599getMinuteJiIwxys();
                        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6489getNumberPjHm6EE(), ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 406463880, "CC(remember):TimePicker.kt#9igjgp");
                        boolean invalid$iv8 = $composer4.changed(timePickerState);
                        Object it$iv7 = $composer4.rememberedValue();
                        if (invalid$iv8 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                            value$iv7 = new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$6$1
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
                                    timePickerState.m2868setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2599getMinuteJiIwxys());
                                }
                            };
                            $composer4.updateRememberedValue(value$iv7);
                        } else {
                            value$iv7 = it$iv7;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        TimePickerKt.m2845TimePickerTextFieldlxUZ_iY(modifierOnPreviewKeyEvent, textFieldValueTimeInputImpl$lambda$8, function3, timePickerState, iM2599getMinuteJiIwxys, keyboardOptions2, new KeyboardActions(null, null, (Function1) value$iv7, null, null, null, 59, null), timePickerColors, $composer4, CpioConstants.C_ISBLK, 0);
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
            }, $composer2, 54), $composer2, 48);
            $composer2.startReplaceGroup(565126994);
            ComposerKt.sourceInformation($composer2, "925@40943L370");
            if (!state.getIs24hour()) {
                Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1645129605, "C926@41011L288:TimePicker.kt#uh7d8r");
                VerticalPeriodToggle(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3634getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3633getPeriodSelectorContainerHeightD9Ej5fM()), state, colors, $composer2, (($dirty2 >> 3) & 112) | 6 | (($dirty2 << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.TimeInputImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    TimePickerKt.TimeInputImpl(modifier, colors, state, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$5(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$8(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalClockDisplay(final TimePickerState state, final TimePickerColors colors, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Composer $composer2 = $composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation($composer2, "C(HorizontalClockDisplay)P(1)941@41436L554:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(colors) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, $dirty, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:940)");
            }
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -385982627, "C942@41495L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(state, colors, $composer2, ($dirty & 14) | ($dirty & 112));
            $composer2.startReplaceGroup(-552391449);
            ComposerKt.sourceInformation($composer2, "944@41573L401");
            if (!state.getIs24hour()) {
                Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 34973977, "C945@41650L310:TimePicker.kt#uh7d8r");
                HorizontalPeriodToggle(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3645getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3644getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), state, colors, $composer2, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.HorizontalClockDisplay.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    TimePickerKt.HorizontalClockDisplay(state, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalClockDisplay(final TimePickerState state, final TimePickerColors colors, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Composer $composer2 = $composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation($composer2, "C(VerticalClockDisplay)P(1)960@42095L549:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(colors) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, $dirty, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:959)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1085485597, "C961@42153L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(state, colors, $composer2, ($dirty & 14) | ($dirty & 112));
            $composer2.startReplaceGroup(952915111);
            ComposerKt.sourceInformation($composer2, "963@42231L397");
            if (!state.getIs24hour()) {
                Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1130518821, "C964@42310L304:TimePicker.kt#uh7d8r");
                VerticalPeriodToggle(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3648getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3647getPeriodSelectorVerticalContainerHeightD9Ej5fM()), state, colors, $composer2, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalClockDisplay.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    TimePickerKt.VerticalClockDisplay(state, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockDisplayNumbers(final TimePickerState state, final TimePickerColors colors, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation($composer2, "C(ClockDisplayNumbers)P(1)983@42830L10,986@43007L921,982@42758L1170:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(colors) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, $dirty, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:981)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont())), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(-477913269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.1
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
                    ComposerKt.sourceInformation($composer3, "C987@43017L905:TimePicker.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-477913269, $changed2, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:987)");
                        }
                        TimePickerState timePickerState = state;
                        TimePickerColors timePickerColors = colors;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 94471722, "C988@43035L338,998@43386L181,1004@43580L332:TimePicker.kt#uh7d8r");
                        TimePickerKt.m2846TimeSelectoruXwN82Y(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3651getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3650getTimeSelectorContainerHeightD9Ej5fM()), timePickerState.getHourForDisplay$material3_release(), timePickerState, Selection.INSTANCE.m2598getHourJiIwxys(), timePickerColors, $composer3, 3078);
                        TimePickerKt.DisplaySeparator(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimePickerKt.DisplaySeparatorWidth, TimePickerTokens.INSTANCE.m3647getPeriodSelectorVerticalContainerHeightD9Ej5fM()), $composer3, 6);
                        TimePickerKt.m2846TimeSelectoruXwN82Y(SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3651getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3650getTimeSelectorContainerHeightD9Ej5fM()), timePickerState.getMinute(), timePickerState, Selection.INSTANCE.m2599getMinuteJiIwxys(), timePickerColors, $composer3, 3078);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
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
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.ClockDisplayNumbers(state, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalPeriodToggle(final Modifier modifier, final TimePickerState state, final TimePickerColors colors, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation($composer2, "C(HorizontalPeriodToggle)P(1,2)1024@44090L958,1051@45095L5,1053@45126L206:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(colors) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, $dirty2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1023)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 759556958, "CC(remember):TimePicker.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1
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
                    public final MeasureResult mo285measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> list, long constraints) {
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = list.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "Spacer")) {
                                Measurable spacer = (Measurable) item$iv$iv;
                                final Placeable spacerPlaceable = spacer.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : $this$MeasurePolicy.mo561roundToPx0680j_4(TimePickerTokens.INSTANCE.m3646getPeriodSelectorOutlineWidthD9Ej5fM()), (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
                                List target$iv = new ArrayList(list.size());
                                int index$iv$iv2 = 0;
                                int size2 = list.size();
                                while (index$iv$iv2 < size2) {
                                    Measurable measurable = list.get(index$iv$iv2);
                                    Measurable it2 = measurable;
                                    Measurable spacer2 = spacer;
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "Spacer")) {
                                        target$iv.add(measurable);
                                    }
                                    index$iv$iv2++;
                                    spacer = spacer2;
                                }
                                List $this$fastMap$iv = target$iv;
                                List target$iv2 = new ArrayList($this$fastMap$iv.size());
                                List $this$fastForEach$iv$iv = $this$fastMap$iv;
                                int $i$f$fastForEach = 0;
                                int index$iv$iv3 = 0;
                                int size3 = $this$fastForEach$iv$iv.size();
                                while (index$iv$iv3 < size3) {
                                    Measurable item = (Measurable) $this$fastForEach$iv$iv.get(index$iv$iv3);
                                    target$iv2.add(item.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : Constraints.m6744getMaxWidthimpl(constraints) / 2, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0)));
                                    index$iv$iv3++;
                                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv;
                                    $i$f$fastForEach = $i$f$fastForEach;
                                }
                                final List items = target$iv2;
                                return MeasureScope.CC.layout$default($this$MeasurePolicy, Constraints.m6744getMaxWidthimpl(constraints), Constraints.m6743getMaxHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        Placeable.PlacementScope.place$default($this$layout, items.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, items.get(1), items.get(0).getWidth(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, spacerPlaceable, items.get(0).getWidth() - (spacerPlaceable.getWidth() / 2), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), $composer2, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape shape = (CornerBasedShape) value;
            PeriodToggleImpl(modifier, state, colors, measurePolicy, ShapesKt.start(shape), ShapesKt.end(shape), $composer2, ($dirty2 & 14) | 3072 | ($dirty2 & 112) | ($dirty2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.HorizontalPeriodToggle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.HorizontalPeriodToggle(modifier, state, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalPeriodToggle(final Modifier modifier, final TimePickerState state, final TimePickerColors colors, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation($composer2, "C(VerticalPeriodToggle)P(1,2)1069@45492L965,1096@46504L5,1098@46535L207:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(colors) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, $dirty2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1068)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2030103034, "CC(remember):TimePicker.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1
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
                    public final MeasureResult mo285measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> list, long constraints) {
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = list.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "Spacer")) {
                                Measurable spacer = (Measurable) item$iv$iv;
                                final Placeable spacerPlaceable = spacer.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : $this$MeasurePolicy.mo561roundToPx0680j_4(TimePickerTokens.INSTANCE.m3646getPeriodSelectorOutlineWidthD9Ej5fM())));
                                List target$iv = new ArrayList(list.size());
                                int index$iv$iv2 = 0;
                                int size2 = list.size();
                                while (index$iv$iv2 < size2) {
                                    Measurable measurable = list.get(index$iv$iv2);
                                    Measurable it2 = measurable;
                                    Measurable spacer2 = spacer;
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "Spacer")) {
                                        target$iv.add(measurable);
                                    }
                                    index$iv$iv2++;
                                    spacer = spacer2;
                                }
                                List $this$fastMap$iv = target$iv;
                                List target$iv2 = new ArrayList($this$fastMap$iv.size());
                                List $this$fastForEach$iv$iv = $this$fastMap$iv;
                                int $i$f$fastForEach = 0;
                                int index$iv$iv3 = 0;
                                int size3 = $this$fastForEach$iv$iv.size();
                                while (index$iv$iv3 < size3) {
                                    Measurable item = (Measurable) $this$fastForEach$iv$iv.get(index$iv$iv3);
                                    target$iv2.add(item.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : Constraints.m6743getMaxHeightimpl(constraints) / 2)));
                                    index$iv$iv3++;
                                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv;
                                    $i$f$fastForEach = $i$f$fastForEach;
                                }
                                final List items = target$iv2;
                                return MeasureScope.CC.layout$default($this$MeasurePolicy, Constraints.m6744getMaxWidthimpl(constraints), Constraints.m6743getMaxHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        Placeable.PlacementScope.place$default($this$layout, items.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, items.get(1), 0, items.get(0).getHeight(), 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, spacerPlaceable, 0, items.get(0).getHeight() - (spacerPlaceable.getHeight() / 2), 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), $composer2, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape shape = (CornerBasedShape) value;
            PeriodToggleImpl(modifier, state, colors, measurePolicy, ShapesKt.top(shape), ShapesKt.bottom(shape), $composer2, ($dirty2 & 14) | 3072 | ($dirty2 & 112) | ($dirty2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalPeriodToggle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.VerticalPeriodToggle(modifier, state, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PeriodToggleImpl(final Modifier modifier, final TimePickerState state, final TimePickerColors colors, final MeasurePolicy measurePolicy, final Shape startShape, final Shape endShape, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(1374241901);
        ComposerKt.sourceInformation($composer2, "C(PeriodToggleImpl)P(3,5!1,2,4)1122@47135L5,1123@47190L41,1126@47295L116,1124@47236L1158:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(colors) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(measurePolicy) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(startShape) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(endShape) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374241901, $dirty2, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1116)");
            }
            BorderStroke borderStroke = BorderStrokeKt.m481BorderStrokecXLIe8U(TimePickerTokens.INSTANCE.m3646getPeriodSelectorOutlineWidthD9Ej5fM(), colors.getPeriodSelectorBorderColor());
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), $composer2, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape shape = (CornerBasedShape) value;
            Strings.Companion companion = Strings.INSTANCE;
            final String contentDescription = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_period_toggle_description), $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -2008453209, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(contentDescription);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
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
                        SemanticsPropertiesKt.setTraversalGroup($this$semantics, true);
                        SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierBorder = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(modifier, false, (Function1) value$iv3, 1, null)), borderStroke, shape);
            int $changed$iv = ($dirty2 >> 3) & 896;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifierBorder);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1654478558, "C1137@47699L35,1134@47573L267,1140@47853L240,1151@48245L34,1147@48106L272:TimePicker.kt#uh7d8r");
            boolean z = !state.isAfternoonToggle$material3_release();
            ComposerKt.sourceInformationMarkerStart($composer2, 1654478684, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 112) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
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
                        state.setAfternoonToggle$material3_release(false);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ToggleItem(z, startShape, (Function0) value$iv, colors, ComposableSingletons$TimePickerKt.INSTANCE.m2141getLambda1$material3_release(), $composer2, (($dirty2 >> 9) & 112) | CpioConstants.C_ISBLK | (($dirty2 << 3) & 7168));
            SpacerKt.Spacer(BackgroundKt.m454backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.INSTANCE, "Spacer"), SeparatorZIndex), 0.0f, 1, null), colors.getPeriodSelectorBorderColor(), null, 2, null), $composer2, 0);
            boolean zIsAfternoonToggle$material3_release = state.isAfternoonToggle$material3_release();
            ComposerKt.sourceInformationMarkerStart($composer2, 1654479230, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 112) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
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
                        state.setAfternoonToggle$material3_release(true);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ToggleItem(zIsAfternoonToggle$material3_release, endShape, (Function0) value$iv2, colors, ComposableSingletons$TimePickerKt.INSTANCE.m2142getLambda2$material3_release(), $composer2, (($dirty2 >> 12) & 112) | CpioConstants.C_ISBLK | (($dirty2 << 3) & 7168));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.PeriodToggleImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i2) {
                    TimePickerKt.PeriodToggleImpl(modifier, state, colors, measurePolicy, startShape, endShape, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ToggleItem(final boolean checked, final Shape shape, final Function0<Unit> function0, final TimePickerColors colors, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1937408098);
        ComposerKt.sourceInformation($composer2, "C(ToggleItem)P(!1,4,3)1173@48855L22,1178@49034L112,1169@48720L432:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(checked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(shape) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, $dirty, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1165)");
            }
            long contentColor = colors.m2838periodSelectorContentColorvNxB06k$material3_release(checked);
            long containerColor = colors.m2837periodSelectorContainerColorvNxB06k$material3_release(checked);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, checked ? 0.0f : 1.0f), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 526523757, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$1$1
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
                        SemanticsPropertiesKt.setSelected($this$semantics, checked);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (Function1) value$iv, 1, null), false, shape, ButtonDefaults.INSTANCE.m1970textButtonColorsro_MJ88(containerColor, contentColor, 0L, 0L, $composer2, CpioConstants.C_ISBLK, 12), null, null, PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0)), null, function3, $composer2, (($dirty >> 6) & 14) | 12582912 | (($dirty << 6) & 7168) | (($dirty << 15) & 1879048192), 356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ToggleItem.2
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

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.ToggleItem(checked, shape, function0, colors, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisplaySeparator(final Modifier modifier, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2 = $composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation($composer2, "C(DisplaySeparator)1187@49250L7,1195@49469L241:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, $dirty, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1186)");
            }
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextStyle textStyle = (TextStyle) objConsume;
            TextStyle style = textStyle.m6277copyp1EtxEg((16777213 & 1) != 0 ? textStyle.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : TextAlign.INSTANCE.m6658getCentere0LSkKk(), (16777213 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyle.platformStyle : null, (16777213 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m6635getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m6647getBothEVpEnUU(), null), (16777213 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
            Modifier modifier$iv = SemanticsModifierKt.clearAndSetSemantics(modifier, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                }
            });
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -617587345, "C1201@49662L5,1199@49588L116:TimePicker.kt#uh7d8r");
            TextKt.m2817Text4IGK_g(":", (Modifier) null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), $composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, style, $composer2, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    TimePickerKt.DisplaySeparator(modifier, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TimeSelector-uXwN82Y, reason: not valid java name */
    public static final void m2846TimeSelectoruXwN82Y(final Modifier modifier, final int value, final TimePickerState state, final int selection, final TimePickerColors colors, Composer $composer, final int $changed) {
        int iM3017constructorimpl;
        Object value$iv$iv;
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(21099367);
        ComposerKt.sourceInformation($composer2, "C(TimeSelector)P(1,4,3,2:c#material3.Selection)1217@50005L176,1227@50333L24,1230@50447L124,1243@50876L5,1234@50591L211,1245@50921L497,1228@50362L1056:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(value) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(state) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(selection) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(colors) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(21099367, $dirty2, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1215)");
            }
            boolean selected = Selection.m2594equalsimpl0(state.m2865getSelectionJiIwxys$material3_release(), selection);
            if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                Strings.Companion companion = Strings.INSTANCE;
                iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_selection);
            } else {
                Strings.Companion companion2 = Strings.INSTANCE;
                iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_selection);
            }
            final String selectorContentDescription = Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl, $composer2, 0);
            long containerColor = colors.m2839timeSelectorContainerColorvNxB06k$material3_release(selected);
            final long contentColor = colors.m2840timeSelectorContentColorvNxB06k$material3_release(selected);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -633371712, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(selectorContentDescription);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$1$1
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
                        SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6066getRadioButtono7Vup1c());
                        SemanticsPropertiesKt.setContentDescription($this$semantics, selectorContentDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (Function1) value$iv);
            Shape value2 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -633371568, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 7168) == 2048) | (($dirty2 & 896) == 256) | $composer2.changedInstance(scope);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$2$1
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
                        if (!Selection.m2594equalsimpl0(selection, state.m2865getSelectionJiIwxys$material3_release())) {
                            state.m2868setSelectioniHAOin8$material3_release(selection);
                            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C15841(state, null), 3, null);
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$TimeSelector$2$1$1 */
                    /* JADX INFO: compiled from: TimePicker.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.TimePickerKt$TimeSelector$2$1$1", m210f = "TimePicker.kt", m211i = {}, m212l = {1239}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C15841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ TimePickerState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C15841(TimePickerState timePickerState, Continuation<? super C15841> continuation) {
                            super(2, continuation);
                            this.$state = timePickerState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C15841(this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C15841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$state.animateToCurrent$material3_release(this) == coroutine_suspended) {
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
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SurfaceKt.m2667Surfaced85dljk(selected, (Function0<Unit>) value$iv2, modifierSemantics, false, value2, containerColor, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1338709103, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3
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
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "C1247@50973L152,1253@51135L277:TimePicker.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1338709103, $changed2, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1246)");
                    }
                    final String valueContentDescription = TimePickerKt.m2851numberContentDescriptionYKJpE6Y(selection, state.getIs24hour(), value, $composer3, 0);
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                    int i = value;
                    long j = contentColor;
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (48 << 3) & 112;
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
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i3 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 992583273, "C1255@51242L48,1254@51190L212:TimePicker.kt#uh7d8r");
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 992583325, "CC(remember):TimePicker.kt#9igjgp");
                    boolean invalid$iv3 = $composer3.changed(valueContentDescription);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1
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
                                SemanticsPropertiesKt.setContentDescription($this$semantics, valueContentDescription);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TextKt.m2817Text4IGK_g(CalendarLocale_jvmKt.toLocalString$default(i, 2, 0, false, 6, null), SemanticsModifierKt.semantics$default(companion3, false, (Function1) value$iv3, 1, null), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131064);
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
            }, $composer2, 54), $composer2, 0, 48, 1992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.m2846TimeSelectoruXwN82Y(modifier, value, state, selection, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void ClockFace(final TimePickerState state, final TimePickerColors colors, final boolean autoSwitchToMinute, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1525091100);
        ComposerKt.sourceInformation($composer2, "C(ClockFace)P(2,1)1368@54770L2125,1361@54440L2455:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(colors) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(autoSwitchToMinute) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1525091100, $dirty2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1360)");
            }
            CrossfadeKt.Crossfade(state.getValues$material3_release(), SemanticsModifierKt.semantics$default(SizeKt.m913size3ABfNKs(BackgroundKt.m453backgroundbw27NRU(Modifier.INSTANCE, colors.getClockDialColor(), RoundedCornerShapeKt.getCircleShape()), TimePickerTokens.INSTANCE.m3639getClockDialContainerSizeD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.selectableGroup($this$semantics);
                }
            }, 1, null), AnimationSpecKt.tween$default(350, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1628166511, true, new Function3<List<? extends Integer>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list, Composer composer, Integer num) {
                    invoke((List<Integer>) list, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final List<Integer> list, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C1375@55052L1837,1369@54790L2099:TimePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1628166511, $changed2, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1369)");
                    }
                    Modifier modifierDrawSelector = TimePickerKt.drawSelector(SizeKt.m913size3ABfNKs(Modifier.INSTANCE.then(new ClockDialModifier(state, autoSwitchToMinute)), TimePickerTokens.INSTANCE.m3639getClockDialContainerSizeD9Ej5fM()), state, colors);
                    float f = TimePickerKt.OuterCircleSizeRadius;
                    final TimePickerColors timePickerColors = colors;
                    final TimePickerState timePickerState = state;
                    final boolean z = autoSwitchToMinute;
                    TimePickerKt.m2843CircularLayoutuFdPcIQ(modifierDrawSelector, f, ComposableLambdaKt.rememberComposableLambda(-1385633737, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed3) {
                            ComposerKt.sourceInformation($composer4, "C1378@55185L1694,1376@55066L1813:TimePicker.kt#uh7d8r");
                            if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1385633737, $changed3, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1376)");
                                }
                                ProvidedValue<Color> providedValueProvides = ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(timePickerColors.m2821clockDialContentColorvNxB06k$material3_release(false)));
                                final List<Integer> list2 = list;
                                final TimePickerState timePickerState2 = timePickerState;
                                final boolean z2 = z;
                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-2018362505, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer5, int $changed4) {
                                        int outerValue;
                                        ComposerKt.sourceInformation($composer5, "C1402@56263L584,1396@55923L924:TimePicker.kt#uh7d8r");
                                        if (($changed4 & 3) != 2 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2018362505, $changed4, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1379)");
                                            }
                                            $composer5.startReplaceGroup(-504291970);
                                            ComposerKt.sourceInformation($composer5, "*1386@55550L88,1385@55485L323");
                                            int size = list2.size();
                                            TimePickerState timePickerState3 = timePickerState2;
                                            List<Integer> list3 = list2;
                                            boolean z3 = z2;
                                            for (int i = 0; i < size; i++) {
                                                final int index = i;
                                                if (!timePickerState3.getIs24hour() || Selection.m2594equalsimpl0(timePickerState3.m2865getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2599getMinuteJiIwxys())) {
                                                    outerValue = list3.get(index).intValue();
                                                } else {
                                                    outerValue = list3.get(index).intValue() % 12;
                                                }
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1916850054, "CC(remember):TimePicker.kt#9igjgp");
                                                boolean invalid$iv = $composer5.changed(index);
                                                Object value$iv = $composer5.rememberedValue();
                                                if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                                                    value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$2$1$1$1$1$1
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
                                                            SemanticsPropertiesKt.setTraversalIndex($this$semantics, index);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv, 1, null), timePickerState3, outerValue, z3, $composer5, 0);
                                            }
                                            $composer5.endReplaceGroup();
                                            if (Selection.m2594equalsimpl0(timePickerState2.m2865getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2598getHourJiIwxys()) && timePickerState2.getIs24hour()) {
                                                Modifier modifierM453backgroundbw27NRU = BackgroundKt.m453backgroundbw27NRU(SizeKt.m913size3ABfNKs(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m3639getClockDialContainerSizeD9Ej5fM()), Color.INSTANCE.m4326getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                                float f2 = TimePickerKt.InnerCircleRadius;
                                                final TimePickerState timePickerState4 = timePickerState2;
                                                final boolean z4 = z2;
                                                TimePickerKt.m2843CircularLayoutuFdPcIQ(modifierM453backgroundbw27NRU, f2, ComposableLambdaKt.rememberComposableLambda(-448649404, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                        invoke(composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer $composer6, int $changed5) {
                                                        Object value$iv2;
                                                        ComposerKt.sourceInformation($composer6, "C*1406@56488L109,1405@56415L384:TimePicker.kt#uh7d8r");
                                                        if (($changed5 & 3) != 2 || !$composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-448649404, $changed5, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1403)");
                                                            }
                                                            int size2 = TimePickerKt.ExtraHours.size();
                                                            TimePickerState timePickerState5 = timePickerState4;
                                                            boolean z5 = z4;
                                                            for (int i2 = 0; i2 < size2; i2++) {
                                                                final int index2 = i2;
                                                                int innerValue = ((Number) TimePickerKt.ExtraHours.get(index2)).intValue();
                                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart($composer6, -1469916091, "CC(remember):TimePicker.kt#9igjgp");
                                                                boolean invalid$iv2 = $composer6.changed(index2);
                                                                Object it$iv = $composer6.rememberedValue();
                                                                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                                                                    value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$2$1$1$2$1$1$1
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
                                                                            SemanticsPropertiesKt.setTraversalIndex($this$semantics, 12 + index2);
                                                                        }
                                                                    };
                                                                    $composer6.updateRememberedValue(value$iv2);
                                                                } else {
                                                                    value$iv2 = it$iv;
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                                TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv2, 1, null), timePickerState5, innerValue, z5, $composer6, 0);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        $composer6.skipToGroupEnd();
                                                    }
                                                }, $composer5, 54), $composer5, 432, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54), $composer3, 432, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, CpioConstants.C_ISBLK, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.ClockFace(state, colors, autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier drawSelector(Modifier $this$drawSelector, final TimePickerState state, final TimePickerColors colors) {
        return DrawModifierKt.drawWithContent($this$drawSelector, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt.drawSelector.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$drawWithContent) {
                long selectorOffsetPx = OffsetKt.Offset($this$drawWithContent.mo567toPx0680j_4(DpOffset.m6862getXD9Ej5fM(state.m2866getSelectorPosRKDOV3M$material3_release())), $this$drawWithContent.mo567toPx0680j_4(DpOffset.m6864getYD9Ej5fM(state.m2866getSelectorPosRKDOV3M$material3_release())));
                float f = 2;
                float selectorRadius = $this$drawWithContent.mo567toPx0680j_4(TimePickerTokens.INSTANCE.m3641getClockDialSelectorHandleContainerSizeD9Ej5fM()) / f;
                long selectorColor = colors.getSelectorColor();
                DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$drawWithContent, Color.INSTANCE.m4317getBlack0d7_KjU(), selectorRadius, selectorOffsetPx, 0.0f, null, null, BlendMode.INSTANCE.m4206getClear0nO6VwU(), 56, null);
                $this$drawWithContent.drawContent();
                DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$drawWithContent, selectorColor, selectorRadius, selectorOffsetPx, 0.0f, null, null, BlendMode.INSTANCE.m4234getXor0nO6VwU(), 56, null);
                float strokeWidth = $this$drawWithContent.mo567toPx0680j_4(TimePickerTokens.INSTANCE.m3642getClockDialSelectorTrackContainerWidthD9Ej5fM());
                long lineLength = Offset.m4053minusMKHz9U(selectorOffsetPx, OffsetKt.Offset(((float) Math.cos(state.getCurrentAngle$material3_release().getValue().floatValue())) * selectorRadius, ((float) Math.sin(state.getCurrentAngle$material3_release().getValue().floatValue())) * selectorRadius));
                DrawScope.CC.m4850drawLineNGM6Ib0$default($this$drawWithContent, selectorColor, androidx.compose.p001ui.geometry.SizeKt.m4128getCenteruvyYCjk($this$drawWithContent.mo4773getSizeNHjbRc()), lineLength, strokeWidth, 0, null, 0.0f, null, BlendMode.INSTANCE.m4233getSrcOver0nO6VwU(), 240, null);
                DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$drawWithContent, selectorColor, $this$drawWithContent.mo567toPx0680j_4(TimePickerTokens.INSTANCE.m3640getClockDialSelectorCenterContainerSizeD9Ej5fM()) / f, androidx.compose.p001ui.geometry.SizeKt.m4128getCenteruvyYCjk($this$drawWithContent.mo4773getSizeNHjbRc()), 0.0f, null, null, 0, 120, null);
                DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$drawWithContent, colors.m2821clockDialContentColorvNxB06k$material3_release(true), selectorRadius, selectorOffsetPx, 0.0f, null, null, BlendMode.INSTANCE.m4216getDstOver0nO6VwU(), 56, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText(final Modifier modifier, final TimePickerState state, final int value, final boolean autoSwitchToMinute, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv$iv;
        int i;
        Object value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-1420123631);
        ComposerKt.sourceInformation($composer2, "C(ClockText)P(1,2,3)1489@58789L10,*1490@58870L7,1491@58920L40,1492@58977L24,1494@59039L142,1512@59595L39,1514@59708L223,1507@59394L758:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(value) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(autoSwitchToMinute) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1420123631, $dirty2, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1488)");
            }
            TextStyle style = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), TimePickerTokens.INSTANCE.getClockDialLabelTextFont());
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$ClockText_u24lambda_u2426 = (Density) objConsume;
            final float maxDist = $this$ClockText_u24lambda_u2426.mo567toPx0680j_4(MaxDistance);
            ComposerKt.sourceInformationMarkerStart($composer2, -1652987568, "CC(remember):TimePicker.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4038boximpl(Offset.INSTANCE.m4065getZeroF1C5BW0()), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState center$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final String text = m2851numberContentDescriptionYKJpE6Y(state.m2865getSelectionJiIwxys$material3_release(), state.getIs24hour(), value, $composer2, $dirty2 & 896);
            String text2 = CalendarLocale_jvmKt.toLocalString$default(value, 0, 0, false, 7, null);
            boolean selected = Selection.m2594equalsimpl0(state.m2865getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2599getMinuteJiIwxys()) ? Intrinsics.areEqual(CalendarLocale_jvmKt.toLocalString$default(state.getMinute(), 0, 0, false, 7, null), text2) : Intrinsics.areEqual(CalendarLocale_jvmKt.toLocalString$default(state.getHour(), 0, 0, false, 7, null), text2);
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), MinimumInteractiveSize);
            ComposerKt.sourceInformationMarkerStart($composer2, -1652986893, "CC(remember):TimePicker.kt#9igjgp");
            Object value$iv4 = $composer2.rememberedValue();
            if (value$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        TimePickerKt.ClockText$lambda$29(center$delegate, LayoutCoordinatesKt.boundsInParent(it).m4079getCenterF1C5BW0());
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierFocusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM913size3ABfNKs, (Function1) value$iv4), false, null, 3, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1652986780, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32) | $composer2.changed(maxDist) | (($dirty2 & 7168) == 2048) | $composer2.changed(selected);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                i = 0;
                final boolean z = selected;
                value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1
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
                        final CoroutineScope coroutineScope = scope;
                        final TimePickerState timePickerState = state;
                        final float f = maxDist;
                        final boolean z2 = autoSwitchToMinute;
                        final MutableState<Offset> mutableState = center$delegate;
                        SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: TimePicker.kt */
                            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(m209c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1", m210f = "TimePicker.kt", m211i = {}, m212l = {1517}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ boolean $autoSwitchToMinute;
                                final /* synthetic */ MutableState<Offset> $center$delegate;
                                final /* synthetic */ float $maxDist;
                                final /* synthetic */ TimePickerState $state;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(TimePickerState timePickerState, float f, boolean z, MutableState<Offset> mutableState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$state = timePickerState;
                                    this.$maxDist = f;
                                    this.$autoSwitchToMinute = z;
                                    this.$center$delegate = mutableState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object $result) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            this.label = 1;
                                            if (this.$state.onTap$material3_release(Offset.m4049getXimpl(TimePickerKt.ClockText$lambda$28(this.$center$delegate)), Offset.m4050getYimpl(TimePickerKt.ClockText$lambda$28(this.$center$delegate)), this.$maxDist, this.$autoSwitchToMinute, this) == coroutine_suspended) {
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

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(timePickerState, f, z2, mutableState, null), 3, null);
                                return true;
                            }
                        }, 1, null);
                        SemanticsPropertiesKt.setSelected($this$semantics, z);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
                i = 0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierFocusable$default, true, (Function1) value$iv2);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, i);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierSemantics);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 859632501, "C1523@60007L76,1522@59948L198:TimePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 859632560, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(r11);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$3$1$1
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
                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        SemanticsPropertiesKt.setContentDescription($this$clearAndSetSemantics, text);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextKt.m2817Text4IGK_g(text2, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) value$iv3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, style, $composer2, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockText.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i4) {
                    TimePickerKt.ClockText(modifier, state, value, autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$28(MutableState<Offset> mutableState) {
        MutableState<Offset> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText$lambda$29(MutableState<Offset> mutableState, long value) {
        mutableState.setValue(Offset.m4038boximpl(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: timeInputOnChange-gIWD5Rc, reason: not valid java name */
    public static final void m2852timeInputOnChangegIWD5Rc(int selection, TimePickerState state, TextFieldValue value, TextFieldValue prevValue, int max, Function1<? super TextFieldValue, Unit> function1) {
        int newValue;
        TextFieldValue textFieldValueM6497copy3r_uNRQ$default;
        if (Intrinsics.areEqual(value.getText(), prevValue.getText())) {
            function1.invoke(value);
            return;
        }
        if (value.getText().length() == 0) {
            if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                state.setHour$material3_release(0);
            } else {
                state.setMinute$material3_release(0);
            }
            function1.invoke(TextFieldValue.m6497copy3r_uNRQ$default(value, "", 0L, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            if (value.getText().length() == 3 && TextRange.m6251getStartimpl(value.getSelection()) == 1) {
                newValue = CharsKt.digitToInt(value.getText().charAt(0));
            } else {
                newValue = Integer.parseInt(value.getText());
            }
            if (newValue <= max) {
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                    state.setHour$material3_release(newValue);
                    if (newValue > 1 && !state.getIs24hour()) {
                        state.m2868setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2599getMinuteJiIwxys());
                    }
                } else {
                    state.setMinute$material3_release(newValue);
                }
                if (value.getText().length() <= 2) {
                    textFieldValueM6497copy3r_uNRQ$default = value;
                } else {
                    textFieldValueM6497copy3r_uNRQ$default = TextFieldValue.m6497copy3r_uNRQ$default(value, String.valueOf(value.getText().charAt(0)), 0L, (TextRange) null, 6, (Object) null);
                }
                function1.invoke(textFieldValueM6497copy3r_uNRQ$default);
            }
        } catch (NumberFormatException e) {
        } catch (IllegalArgumentException e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x0150  */
    /* JADX WARN: Code duplicated, block: B:103:0x015b  */
    /* JADX WARN: Code duplicated, block: B:106:0x017d  */
    /* JADX WARN: Code duplicated, block: B:107:0x018a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0284  */
    /* JADX WARN: Code duplicated, block: B:113:0x0290  */
    /* JADX WARN: Code duplicated, block: B:114:0x0296  */
    /* JADX WARN: Code duplicated, block: B:117:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:120:0x02da  */
    /* JADX WARN: Code duplicated, block: B:121:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:125:0x0330  */
    /* JADX WARN: Code duplicated, block: B:127:0x0352  */
    /* JADX WARN: Code duplicated, block: B:128:0x0357  */
    /* JADX WARN: Code duplicated, block: B:130:0x039f  */
    /* JADX WARN: Code duplicated, block: B:133:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:134:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:137:0x0447  */
    /* JADX WARN: Code duplicated, block: B:140:0x0453  */
    /* JADX WARN: Code duplicated, block: B:141:0x0459  */
    /* JADX WARN: Code duplicated, block: B:144:0x048a  */
    /* JADX WARN: Code duplicated, block: B:148:0x04a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:152:0x0523  */
    /* JADX WARN: Code duplicated, block: B:156:0x0534 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:160:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:161:0x06c4  */
    /* JADX WARN: Code duplicated, block: B:164:0x0746  */
    /* JADX WARN: Code duplicated, block: B:165:0x0748  */
    /* JADX WARN: Code duplicated, block: B:169:0x0752  */
    /* JADX WARN: Code duplicated, block: B:172:0x075d  */
    /* JADX WARN: Code duplicated, block: B:176:0x076a  */
    /* JADX WARN: Code duplicated, block: B:179:0x078b  */
    /* JADX WARN: Code duplicated, block: B:183:0x0796  */
    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x010e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0117  */
    /* JADX WARN: Code duplicated, block: B:95:0x011b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    /* JADX WARN: Code duplicated, block: B:99:0x012c  */
    /* JADX INFO: renamed from: TimePickerTextField-lxUZ_iY, reason: not valid java name */
    public static final void m2845TimePickerTextFieldlxUZ_iY(final Modifier modifier, final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, final TimePickerState state, final int selection, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, final TimePickerColors colors, Composer $composer, final int $changed, final int i) {
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        int i2;
        int $dirty;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        Object it$iv;
        Object value$iv;
        Object it$iv2;
        Object value$iv2;
        FocusRequester focusRequester;
        boolean selected;
        MeasurePolicy measurePolicy$iv;
        int compositeKeyHash$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function0;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        CompositionLocalMap localMap$iv$iv2;
        MeasurePolicy measurePolicy$iv2;
        FocusRequester focusRequester2;
        Composer $composer2;
        Composer $composer$iv;
        int i3;
        int iM3017constructorimpl;
        Composer $composer3;
        int compositeKeyHash$iv$iv2;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> function2;
        Composer $this$Layout_u24lambda_u240$iv$iv2;
        FocusRequester focusRequester3;
        boolean invalid$iv;
        Object value$iv3;
        int iM3017constructorimpl2;
        Composer $composer4;
        boolean z;
        boolean invalid$iv2;
        Object value$iv4;
        int minute;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer $composer5 = $composer.startRestartGroup(-367523658);
        ComposerKt.sourceInformation($composer5, "C(TimePickerTextField)P(3,7,4,6,5:c#material3.Selection,2,1)1595@61963L39,1596@62028L29,1597@62110L227,1603@62390L3266,1687@65694L103,1687@65662L135:TimePicker.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer5.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer5.changed(value) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer5.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer5.changed(state) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer5.changed(selection) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            keyboardOptions2 = keyboardOptions;
        } else if ((196608 & $changed) == 0) {
            keyboardOptions2 = keyboardOptions;
            $dirty2 |= $composer5.changed(keyboardOptions2) ? 131072 : 65536;
        } else {
            keyboardOptions2 = keyboardOptions;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 1572864;
            keyboardActions2 = keyboardActions;
        } else if (($changed & 1572864) == 0) {
            keyboardActions2 = keyboardActions;
            $dirty2 |= $composer5.changed(keyboardActions2) ? 1048576 : 524288;
        } else {
            keyboardActions2 = keyboardActions;
        }
        if ((i & 128) == 0) {
            if ((12582912 & $changed) == 0) {
                i2 = $composer5.changed(colors) ? 8388608 : 4194304;
            }
            $dirty = $dirty2;
            if ((4793491 & $dirty) == 4793490 || !$composer5.getSkipping()) {
                if (i4 != 0) {
                    keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions2;
                }
                if (i5 != 0) {
                    keyboardActions3 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions3 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367523658, $dirty, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1594)");
                }
                ComposerKt.sourceInformationMarkerStart($composer5, -525714852, "CC(remember):TimePicker.kt#9igjgp");
                it$iv = $composer5.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer5.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                final MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerStart($composer5, -525714787, "CC(remember):TimePicker.kt#9igjgp");
                it$iv2 = $composer5.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new FocusRequester();
                    $composer5.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                focusRequester = (FocusRequester) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                final TextFieldColors textFieldColors = OutlinedTextFieldDefaults.INSTANCE.m2464colors0hiis_0(colors.m2840timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, colors.m2839timeSelectorContainerColorvNxB06k$material3_release(true), colors.m2839timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer5, 0, 0, 0, 0, 3072, 2147483598, UnixStat.PERM_MASK);
                selected = Selection.m2594equalsimpl0(selection, state.m2865getSelectionJiIwxys$material3_release());
                int $changed$iv = $dirty & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer5);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    localMap$iv$iv2 = localMap$iv$iv;
                    measurePolicy$iv2 = measurePolicy$iv;
                } else {
                    localMap$iv$iv2 = localMap$iv$iv;
                    measurePolicy$iv2 = measurePolicy$iv;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i6 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i7 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, 896158926, "C1614@62822L202,1622@63034L2039,1673@65227L206,1680@65500L5,1682@65558L10,1669@65083L567:TimePicker.kt#uh7d8r");
                    $composer5.startReplaceGroup(896158926);
                    ComposerKt.sourceInformation($composer5, "1605@62457L320");
                    if (selected) {
                        focusRequester2 = focusRequester;
                        $composer2 = $composer5;
                        $composer$iv = $composer5;
                        i3 = 0;
                    } else {
                        Modifier modifierM915sizeVpY3zN4 = SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                        if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                            minute = state.getHourForDisplay$material3_release();
                        } else {
                            minute = state.getMinute();
                        }
                        i3 = 0;
                        focusRequester2 = focusRequester;
                        $composer2 = $composer5;
                        $composer$iv = $composer5;
                        m2846TimeSelectoruXwN82Y(modifierM915sizeVpY3zN4, minute, state, selection, colors, $composer2, (($dirty >> 3) & 896) | 6 | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344));
                    }
                    $composer2.endReplaceGroup();
                    if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2599getMinuteJiIwxys())) {
                        Strings.Companion companion = Strings.INSTANCE;
                        iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_text_field);
                    } else {
                        Strings.Companion companion2 = Strings.INSTANCE;
                        iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_text_field);
                    }
                    $composer3 = $composer2;
                    final String contentDescription = Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl, $composer3, i3);
                    Modifier modifier$iv = visible(Modifier.INSTANCE, selected);
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv2 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function2 = constructor2;
                        $composer3.createNode(function2);
                    } else {
                        function2 = constructor2;
                        $composer3.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i9 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1694927237, "C1629@63370L92,1635@63664L7,1641@63933L11,1642@63997L11,1646@64145L918,1623@63080L1983:TimePicker.kt#uh7d8r");
                    focusRequester3 = focusRequester2;
                    Modifier modifierM915sizeVpY3zN5 = SizeKt.m915sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3), TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart($composer3, -1694926947, "CC(remember):TimePicker.kt#9igjgp");
                    invalid$iv = $composer3.changed(contentDescription);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (!invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
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
                                SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM915sizeVpY3zN5, false, (Function1) value$iv3, 1, null);
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    BasicTextFieldKt.BasicTextField(value, function1, modifierSemantics$default, true, false, (TextStyle) objConsume, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, interactionSource, Brush.Companion.m4249verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.m202to(Float.valueOf(0.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(1.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2133555260, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer6, int $changed2) {
                            ComposerKt.sourceInformation($composer6, "C1656@64625L406,1647@64189L860:TimePicker.kt#uh7d8r");
                            int $dirty3 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty3 |= $composer6.changedInstance(function3) ? 4 : 2;
                            }
                            int $dirty4 = $dirty3;
                            if (($dirty4 & 19) == 18 && $composer6.getSkipping()) {
                                $composer6.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2133555260, $dirty4, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1647)");
                            }
                            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                            String text = value.getText();
                            VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                            PaddingValues paddingValuesM861PaddingValues0680j_4 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                            MutableInteractionSource mutableInteractionSource = interactionSource;
                            TextFieldColors textFieldColors2 = textFieldColors;
                            final MutableInteractionSource mutableInteractionSource2 = interactionSource;
                            final TextFieldColors textFieldColors3 = textFieldColors;
                            outlinedTextFieldDefaults.DecorationBox(text, function3, true, true, none, mutableInteractionSource, false, null, null, null, null, null, null, null, textFieldColors2, paddingValuesM861PaddingValues0680j_4, ComposableLambdaKt.rememberComposableLambda(-968963953, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer7, int $changed3) {
                                    ComposerKt.sourceInformation($composer7, "C1661@64923L5,1657@64677L332:TimePicker.kt#uh7d8r");
                                    if (($changed3 & 3) == 2 && $composer7.getSkipping()) {
                                        $composer7.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-968963953, $changed3, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1657)");
                                    }
                                    OutlinedTextFieldDefaults.INSTANCE.m2463ContainerBoxnbWgWpA(true, false, mutableInteractionSource2, textFieldColors3, ShapesKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), $composer7, 6), 0.0f, 0.0f, $composer7, 12583350, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer6, 54), $composer6, (($dirty4 << 3) & 112) | 224640, 14352384, 16320);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 100666368 | (($dirty >> 3) & 112) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128), 199680, 7696);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m829offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, SupportLabelTop, 1, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        }
                    });
                    if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                        Strings.Companion companion3 = Strings.INSTANCE;
                        iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour);
                    } else {
                        Strings.Companion companion4 = Strings.INSTANCE;
                        iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute);
                    }
                    TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl2, $composer3, 0), modifierClearAndSetSemantics, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), $composer3, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont()), $composer3, 0, 0, 65528);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Selection selectionM2591boximpl = Selection.m2591boximpl(state.m2865getSelectionJiIwxys$material3_release());
                    $composer4 = $composer5;
                    ComposerKt.sourceInformationMarkerStart($composer4, -525711121, "CC(remember):TimePicker.kt#9igjgp");
                    if (($dirty & 7168) == 2048) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z | ((57344 & $dirty) == 16384);
                    Object it$iv4 = $composer4.rememberedValue();
                    if (!invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                        $composer4.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EffectsKt.LaunchedEffect(selectionM2591boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer4, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions2 = keyboardOptions3;
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i10 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i11 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, 896158926, "C1614@62822L202,1622@63034L2039,1673@65227L206,1680@65500L5,1682@65558L10,1669@65083L567:TimePicker.kt#uh7d8r");
                $composer5.startReplaceGroup(896158926);
                ComposerKt.sourceInformation($composer5, "1605@62457L320");
                if (selected) {
                    Modifier modifierM915sizeVpY3zN6 = SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                        minute = state.getHourForDisplay$material3_release();
                    } else {
                        minute = state.getMinute();
                    }
                    i3 = 0;
                    focusRequester2 = focusRequester;
                    $composer2 = $composer5;
                    $composer$iv = $composer5;
                    m2846TimeSelectoruXwN82Y(modifierM915sizeVpY3zN6, minute, state, selection, colors, $composer2, (($dirty >> 3) & 896) | 6 | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344));
                } else {
                    focusRequester2 = focusRequester;
                    $composer2 = $composer5;
                    $composer$iv = $composer5;
                    i3 = 0;
                }
                $composer2.endReplaceGroup();
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2599getMinuteJiIwxys())) {
                    Strings.Companion companion5 = Strings.INSTANCE;
                    iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_text_field);
                } else {
                    Strings.Companion companion6 = Strings.INSTANCE;
                    iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_text_field);
                }
                $composer3 = $composer2;
                final String contentDescription2 = Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl, $composer3, i3);
                Modifier modifier$iv2 = visible(Modifier.INSTANCE, selected);
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function2 = constructor2;
                    $composer3.createNode(function2);
                } else {
                    function2 = constructor2;
                    $composer3.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i13 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1694927237, "C1629@63370L92,1635@63664L7,1641@63933L11,1642@63997L11,1646@64145L918,1623@63080L1983:TimePicker.kt#uh7d8r");
                focusRequester3 = focusRequester2;
                Modifier modifierM915sizeVpY3zN7 = SizeKt.m915sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3), TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart($composer3, -1694926947, "CC(remember):TimePicker.kt#9igjgp");
                invalid$iv = $composer3.changed(contentDescription2);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
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
                        SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription2);
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierM915sizeVpY3zN7, false, (Function1) value$iv3, 1, null);
                ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localTextStyle2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BasicTextFieldKt.BasicTextField(value, function1, modifierSemantics$default2, true, false, (TextStyle) objConsume2, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, interactionSource, Brush.Companion.m4249verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.m202to(Float.valueOf(0.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(1.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2133555260, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer6, int $changed2) {
                        ComposerKt.sourceInformation($composer6, "C1656@64625L406,1647@64189L860:TimePicker.kt#uh7d8r");
                        int $dirty3 = $changed2;
                        if (($changed2 & 6) == 0) {
                            $dirty3 |= $composer6.changedInstance(function3) ? 4 : 2;
                        }
                        int $dirty4 = $dirty3;
                        if (($dirty4 & 19) == 18 && $composer6.getSkipping()) {
                            $composer6.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2133555260, $dirty4, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1647)");
                        }
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        String text = value.getText();
                        VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                        PaddingValues paddingValuesM861PaddingValues0680j_4 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                        MutableInteractionSource mutableInteractionSource = interactionSource;
                        TextFieldColors textFieldColors2 = textFieldColors;
                        final MutableInteractionSource mutableInteractionSource2 = interactionSource;
                        final TextFieldColors textFieldColors3 = textFieldColors;
                        outlinedTextFieldDefaults.DecorationBox(text, function3, true, true, none, mutableInteractionSource, false, null, null, null, null, null, null, null, textFieldColors2, paddingValuesM861PaddingValues0680j_4, ComposableLambdaKt.rememberComposableLambda(-968963953, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer7, int $changed3) {
                                ComposerKt.sourceInformation($composer7, "C1661@64923L5,1657@64677L332:TimePicker.kt#uh7d8r");
                                if (($changed3 & 3) == 2 && $composer7.getSkipping()) {
                                    $composer7.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-968963953, $changed3, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1657)");
                                }
                                OutlinedTextFieldDefaults.INSTANCE.m2463ContainerBoxnbWgWpA(true, false, mutableInteractionSource2, textFieldColors3, ShapesKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), $composer7, 6), 0.0f, 0.0f, $composer7, 12583350, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer6, 54), $composer6, (($dirty4 << 3) & 112) | 224640, 14352384, 16320);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 100666368 | (($dirty >> 3) & 112) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128), 199680, 7696);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierClearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m829offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, SupportLabelTop, 1, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                    }
                });
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                    Strings.Companion companion7 = Strings.INSTANCE;
                    iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour);
                } else {
                    Strings.Companion companion8 = Strings.INSTANCE;
                    iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute);
                }
                TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl2, $composer3, 0), modifierClearAndSetSemantics2, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), $composer3, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont()), $composer3, 0, 0, 65528);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Selection selectionM2591boximpl2 = Selection.m2591boximpl(state.m2865getSelectionJiIwxys$material3_release());
                $composer4 = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer4, -525711121, "CC(remember):TimePicker.kt#9igjgp");
                if (($dirty & 7168) == 2048) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv2 = z | ((57344 & $dirty) == 16384);
                Object it$iv6 = $composer4.rememberedValue();
                if (invalid$iv2) {
                    value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                    $composer4.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                    $composer4.updateRememberedValue(value$iv4);
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(selectionM2591boximpl2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer4, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions2 = keyboardOptions3;
            } else {
                $composer5.skipToGroupEnd();
                keyboardActions3 = keyboardActions2;
                $composer4 = $composer5;
            }
            scopeUpdateScopeEndRestartGroup = $composer4.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final KeyboardOptions keyboardOptions4 = keyboardOptions2;
                final KeyboardActions keyboardActions4 = keyboardActions3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$3
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

                    public final void invoke(Composer composer, int i14) {
                        TimePickerKt.m2845TimePickerTextFieldlxUZ_iY(modifier, value, function1, state, selection, keyboardOptions4, keyboardActions4, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 12582912;
        $dirty2 |= i2;
        $dirty = $dirty2;
        if ((4793491 & $dirty) == 4793490) {
            if (i4 != 0) {
                keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
            } else {
                keyboardOptions3 = keyboardOptions2;
            }
            if (i5 != 0) {
                keyboardActions3 = KeyboardActions.INSTANCE.getDefault();
            } else {
                keyboardActions3 = keyboardActions2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-367523658, $dirty, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1594)");
            }
            ComposerKt.sourceInformationMarkerStart($composer5, -525714852, "CC(remember):TimePicker.kt#9igjgp");
            it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer5.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableInteractionSource interactionSource2 = (MutableInteractionSource) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, -525714787, "CC(remember):TimePicker.kt#9igjgp");
            it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new FocusRequester();
                $composer5.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            focusRequester = (FocusRequester) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final TextFieldColors textFieldColors2 = OutlinedTextFieldDefaults.INSTANCE.m2464colors0hiis_0(colors.m2840timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, colors.m2839timeSelectorContainerColorvNxB06k$material3_release(true), colors.m2839timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer5, 0, 0, 0, 0, 3072, 2147483598, UnixStat.PERM_MASK);
            selected = Selection.m2594equalsimpl0(selection, state.m2865getSelectionJiIwxys$material3_release());
            int $changed$iv2 = $dirty & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
            measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
            int $changed$iv$iv4 = ($changed$iv2 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
            localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer5);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv2 = localMap$iv$iv;
                measurePolicy$iv2 = measurePolicy$iv;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i14 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                int i15 = (($changed$iv2 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, 896158926, "C1614@62822L202,1622@63034L2039,1673@65227L206,1680@65500L5,1682@65558L10,1669@65083L567:TimePicker.kt#uh7d8r");
                $composer5.startReplaceGroup(896158926);
                ComposerKt.sourceInformation($composer5, "1605@62457L320");
                if (selected) {
                    Modifier modifierM915sizeVpY3zN8 = SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                        minute = state.getHourForDisplay$material3_release();
                    } else {
                        minute = state.getMinute();
                    }
                    i3 = 0;
                    focusRequester2 = focusRequester;
                    $composer2 = $composer5;
                    $composer$iv = $composer5;
                    m2846TimeSelectoruXwN82Y(modifierM915sizeVpY3zN8, minute, state, selection, colors, $composer2, (($dirty >> 3) & 896) | 6 | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344));
                } else {
                    focusRequester2 = focusRequester;
                    $composer2 = $composer5;
                    $composer$iv = $composer5;
                    i3 = 0;
                }
                $composer2.endReplaceGroup();
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2599getMinuteJiIwxys())) {
                    Strings.Companion companion9 = Strings.INSTANCE;
                    iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_text_field);
                } else {
                    Strings.Companion companion10 = Strings.INSTANCE;
                    iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_text_field);
                }
                $composer3 = $composer2;
                final String contentDescription3 = Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl, $composer3, i3);
                Modifier modifier$iv3 = visible(Modifier.INSTANCE, selected);
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv5 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function2 = constructor2;
                    $composer3.createNode(function2);
                } else {
                    function2 = constructor2;
                    $composer3.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash5);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                int i16 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                int i17 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1694927237, "C1629@63370L92,1635@63664L7,1641@63933L11,1642@63997L11,1646@64145L918,1623@63080L1983:TimePicker.kt#uh7d8r");
                focusRequester3 = focusRequester2;
                Modifier modifierM915sizeVpY3zN9 = SizeKt.m915sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3), TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart($composer3, -1694926947, "CC(remember):TimePicker.kt#9igjgp");
                invalid$iv = $composer3.changed(contentDescription3);
                Object it$iv7 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
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
                        SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription3);
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierM915sizeVpY3zN9, false, (Function1) value$iv3, 1, null);
                ProvidableCompositionLocal<TextStyle> localTextStyle3 = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer3.consume(localTextStyle3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BasicTextFieldKt.BasicTextField(value, function1, modifierSemantics$default3, true, false, (TextStyle) objConsume3, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, interactionSource2, Brush.Companion.m4249verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.m202to(Float.valueOf(0.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(1.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2133555260, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer6, int $changed2) {
                        ComposerKt.sourceInformation($composer6, "C1656@64625L406,1647@64189L860:TimePicker.kt#uh7d8r");
                        int $dirty3 = $changed2;
                        if (($changed2 & 6) == 0) {
                            $dirty3 |= $composer6.changedInstance(function3) ? 4 : 2;
                        }
                        int $dirty4 = $dirty3;
                        if (($dirty4 & 19) == 18 && $composer6.getSkipping()) {
                            $composer6.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2133555260, $dirty4, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1647)");
                        }
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        String text = value.getText();
                        VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                        PaddingValues paddingValuesM861PaddingValues0680j_4 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                        MutableInteractionSource mutableInteractionSource = interactionSource2;
                        TextFieldColors textFieldColors3 = textFieldColors2;
                        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
                        final TextFieldColors textFieldColors4 = textFieldColors2;
                        outlinedTextFieldDefaults.DecorationBox(text, function3, true, true, none, mutableInteractionSource, false, null, null, null, null, null, null, null, textFieldColors3, paddingValuesM861PaddingValues0680j_4, ComposableLambdaKt.rememberComposableLambda(-968963953, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer7, int $changed3) {
                                ComposerKt.sourceInformation($composer7, "C1661@64923L5,1657@64677L332:TimePicker.kt#uh7d8r");
                                if (($changed3 & 3) == 2 && $composer7.getSkipping()) {
                                    $composer7.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-968963953, $changed3, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1657)");
                                }
                                OutlinedTextFieldDefaults.INSTANCE.m2463ContainerBoxnbWgWpA(true, false, mutableInteractionSource2, textFieldColors4, ShapesKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), $composer7, 6), 0.0f, 0.0f, $composer7, 12583350, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer6, 54), $composer6, (($dirty4 << 3) & 112) | 224640, 14352384, 16320);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 100666368 | (($dirty >> 3) & 112) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128), 199680, 7696);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierClearAndSetSemantics3 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m829offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, SupportLabelTop, 1, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                    }
                });
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                    Strings.Companion companion11 = Strings.INSTANCE;
                    iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour);
                } else {
                    Strings.Companion companion12 = Strings.INSTANCE;
                    iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute);
                }
                TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl2, $composer3, 0), modifierClearAndSetSemantics3, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), $composer3, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont()), $composer3, 0, 0, 65528);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Selection selectionM2591boximpl3 = Selection.m2591boximpl(state.m2865getSelectionJiIwxys$material3_release());
                $composer4 = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer4, -525711121, "CC(remember):TimePicker.kt#9igjgp");
                if (($dirty & 7168) == 2048) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv2 = z | ((57344 & $dirty) == 16384);
                Object it$iv8 = $composer4.rememberedValue();
                if (invalid$iv2) {
                    value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                    $composer4.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                    $composer4.updateRememberedValue(value$iv4);
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(selectionM2591boximpl3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer4, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions2 = keyboardOptions3;
            } else {
                localMap$iv$iv2 = localMap$iv$iv;
                measurePolicy$iv2 = measurePolicy$iv;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
            int i18 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            int i19 = (($changed$iv2 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, 896158926, "C1614@62822L202,1622@63034L2039,1673@65227L206,1680@65500L5,1682@65558L10,1669@65083L567:TimePicker.kt#uh7d8r");
            $composer5.startReplaceGroup(896158926);
            ComposerKt.sourceInformation($composer5, "1605@62457L320");
            if (selected) {
                Modifier modifierM915sizeVpY3zN10 = SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                    minute = state.getHourForDisplay$material3_release();
                } else {
                    minute = state.getMinute();
                }
                i3 = 0;
                focusRequester2 = focusRequester;
                $composer2 = $composer5;
                $composer$iv = $composer5;
                m2846TimeSelectoruXwN82Y(modifierM915sizeVpY3zN10, minute, state, selection, colors, $composer2, (($dirty >> 3) & 896) | 6 | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344));
            } else {
                focusRequester2 = focusRequester;
                $composer2 = $composer5;
                $composer$iv = $composer5;
                i3 = 0;
            }
            $composer2.endReplaceGroup();
            if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2599getMinuteJiIwxys())) {
                Strings.Companion companion13 = Strings.INSTANCE;
                iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_text_field);
            } else {
                Strings.Companion companion14 = Strings.INSTANCE;
                iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_text_field);
            }
            $composer3 = $composer2;
            final String contentDescription4 = Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl, $composer3, i3);
            Modifier modifier$iv4 = visible(Modifier.INSTANCE, selected);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
            int $changed$iv$iv6 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function2 = constructor2;
                $composer3.createNode(function2);
            } else {
                function2 = constructor2;
                $composer3.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
            int i110 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            int i111 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1694927237, "C1629@63370L92,1635@63664L7,1641@63933L11,1642@63997L11,1646@64145L918,1623@63080L1983:TimePicker.kt#uh7d8r");
            focusRequester3 = focusRequester2;
            Modifier modifierM915sizeVpY3zN11 = SizeKt.m915sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3), TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart($composer3, -1694926947, "CC(remember):TimePicker.kt#9igjgp");
            invalid$iv = $composer3.changed(contentDescription4);
            Object it$iv9 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
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
                    SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription4);
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierM915sizeVpY3zN11, false, (Function1) value$iv3, 1, null);
            ProvidableCompositionLocal<TextStyle> localTextStyle4 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer3.consume(localTextStyle4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BasicTextFieldKt.BasicTextField(value, function1, modifierSemantics$default4, true, false, (TextStyle) objConsume4, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, interactionSource2, Brush.Companion.m4249verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.m202to(Float.valueOf(0.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(1.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2133555260, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer6, int $changed2) {
                    ComposerKt.sourceInformation($composer6, "C1656@64625L406,1647@64189L860:TimePicker.kt#uh7d8r");
                    int $dirty3 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty3 |= $composer6.changedInstance(function3) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 19) == 18 && $composer6.getSkipping()) {
                        $composer6.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2133555260, $dirty4, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1647)");
                    }
                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                    String text = value.getText();
                    VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                    PaddingValues paddingValuesM861PaddingValues0680j_4 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                    MutableInteractionSource mutableInteractionSource = interactionSource2;
                    TextFieldColors textFieldColors3 = textFieldColors2;
                    final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
                    final TextFieldColors textFieldColors4 = textFieldColors2;
                    outlinedTextFieldDefaults.DecorationBox(text, function3, true, true, none, mutableInteractionSource, false, null, null, null, null, null, null, null, textFieldColors3, paddingValuesM861PaddingValues0680j_4, ComposableLambdaKt.rememberComposableLambda(-968963953, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer7, int $changed3) {
                            ComposerKt.sourceInformation($composer7, "C1661@64923L5,1657@64677L332:TimePicker.kt#uh7d8r");
                            if (($changed3 & 3) == 2 && $composer7.getSkipping()) {
                                $composer7.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-968963953, $changed3, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1657)");
                            }
                            OutlinedTextFieldDefaults.INSTANCE.m2463ContainerBoxnbWgWpA(true, false, mutableInteractionSource2, textFieldColors4, ShapesKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), $composer7, 6), 0.0f, 0.0f, $composer7, 12583350, 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer6, 54), $composer6, (($dirty4 << 3) & 112) | 224640, 14352384, 16320);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 100666368 | (($dirty >> 3) & 112) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128), 199680, 7696);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierClearAndSetSemantics4 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m829offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, SupportLabelTop, 1, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                }
            });
            if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                Strings.Companion companion15 = Strings.INSTANCE;
                iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour);
            } else {
                Strings.Companion companion16 = Strings.INSTANCE;
                iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute);
            }
            TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl2, $composer3, 0), modifierClearAndSetSemantics4, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), $composer3, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont()), $composer3, 0, 0, 65528);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Selection selectionM2591boximpl4 = Selection.m2591boximpl(state.m2865getSelectionJiIwxys$material3_release());
            $composer4 = $composer5;
            ComposerKt.sourceInformationMarkerStart($composer4, -525711121, "CC(remember):TimePicker.kt#9igjgp");
            if (($dirty & 7168) == 2048) {
                z = true;
            } else {
                z = false;
            }
            invalid$iv2 = z | ((57344 & $dirty) == 16384);
            Object it$iv10 = $composer4.rememberedValue();
            if (invalid$iv2) {
                value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                $composer4.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                $composer4.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(selectionM2591boximpl4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer4, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions2 = keyboardOptions3;
        } else {
            if (i4 != 0) {
                keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
            } else {
                keyboardOptions3 = keyboardOptions2;
            }
            if (i5 != 0) {
                keyboardActions3 = KeyboardActions.INSTANCE.getDefault();
            } else {
                keyboardActions3 = keyboardActions2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-367523658, $dirty, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1594)");
            }
            ComposerKt.sourceInformationMarkerStart($composer5, -525714852, "CC(remember):TimePicker.kt#9igjgp");
            it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer5.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableInteractionSource interactionSource3 = (MutableInteractionSource) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, -525714787, "CC(remember):TimePicker.kt#9igjgp");
            it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new FocusRequester();
                $composer5.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            focusRequester = (FocusRequester) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final TextFieldColors textFieldColors3 = OutlinedTextFieldDefaults.INSTANCE.m2464colors0hiis_0(colors.m2840timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, colors.m2839timeSelectorContainerColorvNxB06k$material3_release(true), colors.m2839timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer5, 0, 0, 0, 0, 3072, 2147483598, UnixStat.PERM_MASK);
            selected = Selection.m2594equalsimpl0(selection, state.m2865getSelectionJiIwxys$material3_release());
            int $changed$iv3 = $dirty & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
            measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer5, (($changed$iv3 >> 3) & 14) | (($changed$iv3 >> 3) & 112));
            int $changed$iv$iv7 = ($changed$iv3 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
            localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer5, modifier);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer5);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv2 = localMap$iv$iv;
                measurePolicy$iv2 = measurePolicy$iv;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                int i112 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                int i113 = (($changed$iv3 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, 896158926, "C1614@62822L202,1622@63034L2039,1673@65227L206,1680@65500L5,1682@65558L10,1669@65083L567:TimePicker.kt#uh7d8r");
                $composer5.startReplaceGroup(896158926);
                ComposerKt.sourceInformation($composer5, "1605@62457L320");
                if (selected) {
                    Modifier modifierM915sizeVpY3zN12 = SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                        minute = state.getHourForDisplay$material3_release();
                    } else {
                        minute = state.getMinute();
                    }
                    i3 = 0;
                    focusRequester2 = focusRequester;
                    $composer2 = $composer5;
                    $composer$iv = $composer5;
                    m2846TimeSelectoruXwN82Y(modifierM915sizeVpY3zN12, minute, state, selection, colors, $composer2, (($dirty >> 3) & 896) | 6 | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344));
                } else {
                    focusRequester2 = focusRequester;
                    $composer2 = $composer5;
                    $composer$iv = $composer5;
                    i3 = 0;
                }
                $composer2.endReplaceGroup();
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2599getMinuteJiIwxys())) {
                    Strings.Companion companion17 = Strings.INSTANCE;
                    iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_text_field);
                } else {
                    Strings.Companion companion18 = Strings.INSTANCE;
                    iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_text_field);
                }
                $composer3 = $composer2;
                final String contentDescription5 = Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl, $composer3, i3);
                Modifier modifier$iv5 = visible(Modifier.INSTANCE, selected);
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv5 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv5, false);
                int $changed$iv$iv8 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv7 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function2 = constructor2;
                    $composer3.createNode(function2);
                } else {
                    function2 = constructor2;
                    $composer3.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash8);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                int i114 = ($changed$iv$iv$iv8 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                int i115 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1694927237, "C1629@63370L92,1635@63664L7,1641@63933L11,1642@63997L11,1646@64145L918,1623@63080L1983:TimePicker.kt#uh7d8r");
                focusRequester3 = focusRequester2;
                Modifier modifierM915sizeVpY3zN13 = SizeKt.m915sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3), TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart($composer3, -1694926947, "CC(remember):TimePicker.kt#9igjgp");
                invalid$iv = $composer3.changed(contentDescription5);
                Object it$iv11 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
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
                        SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription5);
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifierM915sizeVpY3zN13, false, (Function1) value$iv3, 1, null);
                ProvidableCompositionLocal<TextStyle> localTextStyle5 = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume5 = $composer3.consume(localTextStyle5);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BasicTextFieldKt.BasicTextField(value, function1, modifierSemantics$default5, true, false, (TextStyle) objConsume5, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, Brush.Companion.m4249verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.m202to(Float.valueOf(0.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(1.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2133555260, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer6, int $changed2) {
                        ComposerKt.sourceInformation($composer6, "C1656@64625L406,1647@64189L860:TimePicker.kt#uh7d8r");
                        int $dirty3 = $changed2;
                        if (($changed2 & 6) == 0) {
                            $dirty3 |= $composer6.changedInstance(function3) ? 4 : 2;
                        }
                        int $dirty4 = $dirty3;
                        if (($dirty4 & 19) == 18 && $composer6.getSkipping()) {
                            $composer6.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2133555260, $dirty4, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1647)");
                        }
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        String text = value.getText();
                        VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                        PaddingValues paddingValuesM861PaddingValues0680j_4 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                        MutableInteractionSource mutableInteractionSource = interactionSource3;
                        TextFieldColors textFieldColors4 = textFieldColors3;
                        final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
                        final TextFieldColors textFieldColors5 = textFieldColors3;
                        outlinedTextFieldDefaults.DecorationBox(text, function3, true, true, none, mutableInteractionSource, false, null, null, null, null, null, null, null, textFieldColors4, paddingValuesM861PaddingValues0680j_4, ComposableLambdaKt.rememberComposableLambda(-968963953, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer7, int $changed3) {
                                ComposerKt.sourceInformation($composer7, "C1661@64923L5,1657@64677L332:TimePicker.kt#uh7d8r");
                                if (($changed3 & 3) == 2 && $composer7.getSkipping()) {
                                    $composer7.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-968963953, $changed3, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1657)");
                                }
                                OutlinedTextFieldDefaults.INSTANCE.m2463ContainerBoxnbWgWpA(true, false, mutableInteractionSource2, textFieldColors5, ShapesKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), $composer7, 6), 0.0f, 0.0f, $composer7, 12583350, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer6, 54), $composer6, (($dirty4 << 3) & 112) | 224640, 14352384, 16320);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 100666368 | (($dirty >> 3) & 112) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128), 199680, 7696);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierClearAndSetSemantics5 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m829offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, SupportLabelTop, 1, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                    }
                });
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                    Strings.Companion companion19 = Strings.INSTANCE;
                    iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour);
                } else {
                    Strings.Companion companion110 = Strings.INSTANCE;
                    iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute);
                }
                TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl2, $composer3, 0), modifierClearAndSetSemantics5, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), $composer3, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont()), $composer3, 0, 0, 65528);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Selection selectionM2591boximpl5 = Selection.m2591boximpl(state.m2865getSelectionJiIwxys$material3_release());
                $composer4 = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer4, -525711121, "CC(remember):TimePicker.kt#9igjgp");
                if (($dirty & 7168) == 2048) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv2 = z | ((57344 & $dirty) == 16384);
                Object it$iv12 = $composer4.rememberedValue();
                if (invalid$iv2) {
                    value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                    $composer4.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                    $composer4.updateRememberedValue(value$iv4);
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(selectionM2591boximpl5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer4, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions2 = keyboardOptions3;
            } else {
                localMap$iv$iv2 = localMap$iv$iv;
                measurePolicy$iv2 = measurePolicy$iv;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash7);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
            int i116 = ($changed$iv$iv$iv7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
            int i117 = (($changed$iv3 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, 896158926, "C1614@62822L202,1622@63034L2039,1673@65227L206,1680@65500L5,1682@65558L10,1669@65083L567:TimePicker.kt#uh7d8r");
            $composer5.startReplaceGroup(896158926);
            ComposerKt.sourceInformation($composer5, "1605@62457L320");
            if (selected) {
                Modifier modifierM915sizeVpY3zN14 = SizeKt.m915sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
                if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                    minute = state.getHourForDisplay$material3_release();
                } else {
                    minute = state.getMinute();
                }
                i3 = 0;
                focusRequester2 = focusRequester;
                $composer2 = $composer5;
                $composer$iv = $composer5;
                m2846TimeSelectoruXwN82Y(modifierM915sizeVpY3zN14, minute, state, selection, colors, $composer2, (($dirty >> 3) & 896) | 6 | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344));
            } else {
                focusRequester2 = focusRequester;
                $composer2 = $composer5;
                $composer$iv = $composer5;
                i3 = 0;
            }
            $composer2.endReplaceGroup();
            if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2599getMinuteJiIwxys())) {
                Strings.Companion companion111 = Strings.INSTANCE;
                iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_text_field);
            } else {
                Strings.Companion companion112 = Strings.INSTANCE;
                iM3017constructorimpl = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_text_field);
            }
            $composer3 = $composer2;
            final String contentDescription6 = Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl, $composer3, i3);
            Modifier modifier$iv6 = visible(Modifier.INSTANCE, selected);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv6 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv8 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv6, false);
            int $changed$iv$iv9 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv8 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function2 = constructor2;
                $composer3.createNode(function2);
            } else {
                function2 = constructor2;
                $composer3.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash9);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
            int i118 = ($changed$iv$iv$iv9 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            int i119 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1694927237, "C1629@63370L92,1635@63664L7,1641@63933L11,1642@63997L11,1646@64145L918,1623@63080L1983:TimePicker.kt#uh7d8r");
            focusRequester3 = focusRequester2;
            Modifier modifierM915sizeVpY3zN15 = SizeKt.m915sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3), TimeInputTokens.INSTANCE.m3637getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3636getTimeFieldContainerHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart($composer3, -1694926947, "CC(remember):TimePicker.kt#9igjgp");
            invalid$iv = $composer3.changed(contentDescription6);
            Object it$iv13 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$1$1
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
                    SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription6);
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifierM915sizeVpY3zN15, false, (Function1) value$iv3, 1, null);
            ProvidableCompositionLocal<TextStyle> localTextStyle6 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = $composer3.consume(localTextStyle6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BasicTextFieldKt.BasicTextField(value, function1, modifierSemantics$default6, true, false, (TextStyle) objConsume6, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, Brush.Companion.m4249verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.m202to(Float.valueOf(0.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(0.1f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getPrimary())), TuplesKt.m202to(Float.valueOf(0.9f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU())), TuplesKt.m202to(Float.valueOf(1.0f), Color.m4281boximpl(Color.INSTANCE.m4326getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2133555260, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer6, int $changed2) {
                    ComposerKt.sourceInformation($composer6, "C1656@64625L406,1647@64189L860:TimePicker.kt#uh7d8r");
                    int $dirty3 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty3 |= $composer6.changedInstance(function3) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 19) == 18 && $composer6.getSkipping()) {
                        $composer6.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2133555260, $dirty4, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1647)");
                    }
                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                    String text = value.getText();
                    VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                    PaddingValues paddingValuesM861PaddingValues0680j_4 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                    MutableInteractionSource mutableInteractionSource = interactionSource3;
                    TextFieldColors textFieldColors4 = textFieldColors3;
                    final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
                    final TextFieldColors textFieldColors5 = textFieldColors3;
                    outlinedTextFieldDefaults.DecorationBox(text, function3, true, true, none, mutableInteractionSource, false, null, null, null, null, null, null, null, textFieldColors4, paddingValuesM861PaddingValues0680j_4, ComposableLambdaKt.rememberComposableLambda(-968963953, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$1$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer7, int $changed3) {
                            ComposerKt.sourceInformation($composer7, "C1661@64923L5,1657@64677L332:TimePicker.kt#uh7d8r");
                            if (($changed3 & 3) == 2 && $composer7.getSkipping()) {
                                $composer7.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-968963953, $changed3, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1657)");
                            }
                            OutlinedTextFieldDefaults.INSTANCE.m2463ContainerBoxnbWgWpA(true, false, mutableInteractionSource2, textFieldColors5, ShapesKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), $composer7, 6), 0.0f, 0.0f, $composer7, 12583350, 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer6, 54), $composer6, (($dirty4 << 3) & 112) | 224640, 14352384, 16320);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, (($dirty >> 3) & 14) | 100666368 | (($dirty >> 3) & 112) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128), 199680, 7696);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierClearAndSetSemantics6 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m829offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, SupportLabelTop, 1, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                }
            });
            if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2598getHourJiIwxys())) {
                Strings.Companion companion113 = Strings.INSTANCE;
                iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour);
            } else {
                Strings.Companion companion114 = Strings.INSTANCE;
                iM3017constructorimpl2 = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute);
            }
            TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(iM3017constructorimpl2, $composer3, 0), modifierClearAndSetSemantics6, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), $composer3, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont()), $composer3, 0, 0, 65528);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Selection selectionM2591boximpl6 = Selection.m2591boximpl(state.m2865getSelectionJiIwxys$material3_release());
            $composer4 = $composer5;
            ComposerKt.sourceInformationMarkerStart($composer4, -525711121, "CC(remember):TimePicker.kt#9igjgp");
            if (($dirty & 7168) == 2048) {
                z = true;
            } else {
                z = false;
            }
            invalid$iv2 = z | ((57344 & $dirty) == 16384);
            Object it$iv14 = $composer4.rememberedValue();
            if (invalid$iv2) {
                value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                $composer4.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = new TimePickerKt$TimePickerTextField$2$1(state, selection, focusRequester3, null);
                $composer4.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(selectionM2591boximpl6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer4, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions2 = keyboardOptions3;
        }
        scopeUpdateScopeEndRestartGroup = $composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final KeyboardOptions keyboardOptions5 = keyboardOptions2;
            final KeyboardActions keyboardActions5 = keyboardActions3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePickerTextField$3
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

                public final void invoke(Composer composer, int i120) {
                    TimePickerKt.m2845TimePickerTextFieldlxUZ_iY(modifier, value, function1, state, selection, keyboardOptions5, keyboardActions5, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularLayout-uFdPcIQ, reason: not valid java name */
    public static final void m2843CircularLayoutuFdPcIQ(Modifier modifier, final float radius, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1548175696);
        ComposerKt.sourceInformation($composer2, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1703@66056L1642,1701@65995L1703:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(radius) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, $dirty2, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1700)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1651958844, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1
                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, final long constraints) {
                        Object it$iv2;
                        Object it$iv3;
                        final float radiusPx = $this$Layout.mo567toPx0680j_4(radius);
                        long itemConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
                        List target$iv = new ArrayList(list.size());
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Measurable measurable = list.get(index$iv$iv);
                            Measurable it = measurable;
                            if ((LayoutIdKt.getLayoutId(it) == LayoutId.Selector || LayoutIdKt.getLayoutId(it) == LayoutId.InnerCircle) ? false : true) {
                                target$iv.add(measurable);
                            }
                        }
                        List $this$fastMap$iv = target$iv;
                        List target$iv2 = new ArrayList($this$fastMap$iv.size());
                        int size2 = $this$fastMap$iv.size();
                        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv2);
                            Measurable measurable2 = (Measurable) item$iv$iv;
                            target$iv2.add(measurable2.mo5644measureBRTryo0(itemConstraints));
                        }
                        final List placeables = target$iv2;
                        List<? extends Measurable> list2 = list;
                        int index$iv$iv3 = 0;
                        int size3 = list2.size();
                        while (true) {
                            if (index$iv$iv3 < size3) {
                                Object item$iv$iv2 = list2.get(index$iv$iv3);
                                it$iv2 = item$iv$iv2;
                                Measurable it2 = (Measurable) it$iv2;
                                List<? extends Measurable> list3 = list2;
                                if (LayoutIdKt.getLayoutId(it2) == LayoutId.Selector) {
                                    break;
                                }
                                index$iv$iv3++;
                                list2 = list3;
                            } else {
                                it$iv2 = null;
                                break;
                            }
                        }
                        Measurable selectorMeasurable = (Measurable) it$iv2;
                        List<? extends Measurable> list4 = list;
                        int $i$f$fastFirstOrNull = 0;
                        int index$iv$iv4 = 0;
                        int size4 = list4.size();
                        while (true) {
                            if (index$iv$iv4 < size4) {
                                Object item$iv$iv3 = list4.get(index$iv$iv4);
                                it$iv3 = item$iv$iv3;
                                Measurable it3 = (Measurable) it$iv3;
                                List<? extends Measurable> list5 = list4;
                                int $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                if (LayoutIdKt.getLayoutId(it3) == LayoutId.InnerCircle) {
                                    break;
                                }
                                index$iv$iv4++;
                                list4 = list5;
                                $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                            } else {
                                it$iv3 = null;
                                break;
                            }
                        }
                        Measurable innerMeasurable = (Measurable) it$iv3;
                        final float theta = 6.2831855f / placeables.size();
                        final Placeable selectorPlaceable = selectorMeasurable != null ? selectorMeasurable.mo5644measureBRTryo0(itemConstraints) : null;
                        final Placeable innerCirclePlaceable = innerMeasurable != null ? innerMeasurable.mo5644measureBRTryo0(itemConstraints) : null;
                        return MeasureScope.CC.layout$default($this$Layout, Constraints.m6746getMinWidthimpl(constraints), Constraints.m6745getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                Placeable placeable = selectorPlaceable;
                                if (placeable != null) {
                                    Placeable.PlacementScope.place$default($this$layout, placeable, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list6 = placeables;
                                long j = constraints;
                                float f = radiusPx;
                                float f2 = theta;
                                int index$iv = 0;
                                int size5 = list6.size();
                                while (index$iv < size5) {
                                    Object item$iv = list6.get(index$iv);
                                    Placeable it4 = (Placeable) item$iv;
                                    int i3 = index$iv;
                                    int centerOffsetX = (Constraints.m6744getMaxWidthimpl(j) / 2) - (it4.getWidth() / 2);
                                    int centerOffsetY = (Constraints.m6743getMaxHeightimpl(j) / 2) - (it4.getHeight() / 2);
                                    double d = f;
                                    List<Placeable> list7 = list6;
                                    double offsetX = (Math.cos(((double) (i3 * f2)) - 1.5707963267948966d) * d) + ((double) centerOffsetX);
                                    double offsetY = ((double) centerOffsetY) + (d * Math.sin(((double) (i3 * f2)) - 1.5707963267948966d));
                                    Placeable.PlacementScope.place$default($this$layout, it4, MathKt.roundToInt(offsetX), MathKt.roundToInt(offsetY), 0.0f, 4, null);
                                    index$iv++;
                                    list6 = list7;
                                    j = j;
                                    f = f;
                                }
                                Placeable placeable2 = innerCirclePlaceable;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.place$default($this$layout, placeable2, (Constraints.m6746getMinWidthimpl(constraints) - innerCirclePlaceable.getWidth()) / 2, (Constraints.m6745getMinHeightimpl(constraints) - innerCirclePlaceable.getHeight()) / 2, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Modifier modifier5 = modifier4;
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$2
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

                public final void invoke(Composer composer, int i3) {
                    TimePickerKt.m2843CircularLayoutuFdPcIQ(modifier6, radius, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: numberContentDescription-YKJpE6Y, reason: not valid java name */
    public static final String m2851numberContentDescriptionYKJpE6Y(int selection, boolean is24Hour, int number, Composer $composer, int $changed) {
        int id;
        ComposerKt.sourceInformationMarkerStart($composer, 1826155772, "C(numberContentDescription)P(2:c#material3.Selection)1754@68073L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1826155772, $changed, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1745)");
        }
        if (Selection.m2594equalsimpl0(selection, Selection.INSTANCE.m2599getMinuteJiIwxys())) {
            Strings.Companion companion = Strings.INSTANCE;
            id = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_minute_suffix);
        } else if (is24Hour) {
            Strings.Companion companion2 = Strings.INSTANCE;
            id = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_24h_suffix);
        } else {
            Strings.Companion companion3 = Strings.INSTANCE;
            id = Strings.m3017constructorimpl(C1459R.string.m3c_time_picker_hour_suffix);
        }
        String strM3087getStringqBjtwXw = Strings_androidKt.m3087getStringqBjtwXw(id, new Object[]{Integer.valueOf(number)}, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return strM3087getStringqBjtwXw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Float, Float> valuesForAnimation(float current, float f) {
        float start = current;
        float end = f;
        if (Math.abs(start - end) <= 3.141592653589793d) {
            return new Pair<>(Float.valueOf(start), Float.valueOf(end));
        }
        if (start > 3.141592653589793d && end < 3.141592653589793d) {
            end += FullCircle;
        } else if (start < 3.141592653589793d && end > 3.141592653589793d) {
            start += FullCircle;
        }
        return new Pair<>(Float.valueOf(start), Float.valueOf(end));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dist(float x1, float y1, int x2, int y2) {
        float x = x2 - x1;
        float y = y2 - y1;
        return (float) Math.hypot(x, y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float atan(float y, float x) {
        float ret = ((float) Math.atan2(y, x)) - 1.5707964f;
        return ret < 0.0f ? FullCircle + ret : ret;
    }

    static {
        List<Integer> list = Hours;
        List target$iv = new ArrayList(list.size());
        int size = list.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = list.get(index$iv$iv);
            int it = ((Number) item$iv$iv).intValue();
            target$iv.add(Integer.valueOf((it % 12) + 12));
        }
        List $this$fastMap$iv = target$iv;
        ExtraHours = $this$fastMap$iv;
        PeriodToggleMargin = C1979Dp.m6801constructorimpl(12);
    }

    private static final Modifier visible(Modifier $this$visible, final boolean visible) {
        return $this$visible.then(new VisibleModifier(visible, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("visible");
                $this$null.getProperties().set("visible", Boolean.valueOf(visible));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}
