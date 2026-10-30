package androidx.compose.foundation.text;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.hapticfeedback.HapticFeedback;
import androidx.compose.p001ui.input.pointer.PointerIconKt;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.TextToolbar;
import androidx.compose.p001ui.platform.WindowInfo;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.input.ImeOptions;
import androidx.compose.p001ui.text.input.TextFieldValue;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.style.ResolvedTextDirection;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÛ\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\b\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001aç\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\b\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\u0010/\u001aâ\u0001\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\b032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b032\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&23\b\u0002\u0010;\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\b<¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\b03¢\u0006\u0002\b<H\u0007¢\u0006\u0002\u0010>\u001aî\u0001\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\b032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010?\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&23\b\u0002\u0010;\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\b<¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\b03¢\u0006\u0002\b<H\u0007¢\u0006\u0002\u0010@\u001aâ\u0001\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u00020A2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\b032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b032\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&23\b\u0002\u0010;\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\b<¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\b03¢\u0006\u0002\b<H\u0007¢\u0006\u0002\u0010B\u001aî\u0001\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u00020A2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\b032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010?\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&23\b\u0002\u0010;\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\b<¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\b03¢\u0006\u0002\b<H\u0007¢\u0006\u0002\u0010C\u001a\u0015\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020FH\u0001¢\u0006\u0002\u0010G\u001a\u0015\u0010H\u001a\u00020\b2\u0006\u0010E\u001a\u00020FH\u0001¢\u0006\u0002\u0010G\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006I²\u0006\n\u0010J\u001a\u00020KX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020KX\u008a\u0084\u0002²\u0006\n\u0010M\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020AX\u008a\u008e\u0002"}, m195d2 = {"DefaultTextFieldDecorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "getDefaultTextFieldDecorator$annotations", "()V", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", DownloadUtil.CookieScheme.VALUE, "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "TextFieldCursorHandle", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "foundation_release", "startHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "endHandleState", "textFieldValueState", "lastTextValue"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
    private static final long MinTouchTargetSizeForHandles = DpKt.m6823DpSizeYgX7TsA(C1979Dp.m6801constructorimpl(40), C1979Dp.m6801constructorimpl(40));

    private static /* synthetic */ void getDefaultTextFieldDecorator$annotations() {
    }

    public static final void BasicTextField(final TextFieldState state, Modifier modifier, boolean enabled, boolean readOnly, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, TextFieldLineLimits lineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource interactionSource, Brush cursorBrush, OutputTransformation outputTransformation, TextFieldDecorator decorator, ScrollState scrollState, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        boolean readOnly2;
        InputTransformation inputTransformation2;
        Modifier modifier2;
        ScrollState scrollState2;
        boolean enabled2;
        int $dirty1;
        OutputTransformation outputTransformation2;
        TextFieldDecorator decorator2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        Brush cursorBrush2;
        MutableInteractionSource interactionSource2;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function3;
        TextFieldLineLimits lineLimits2;
        KeyboardActionHandler onKeyboardAction2;
        Modifier modifier3;
        boolean enabled3;
        TextStyle textStyle3;
        KeyboardOptions keyboardOptions3;
        KeyboardActionHandler onKeyboardAction3;
        TextFieldLineLimits lineLimits3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function4;
        MutableInteractionSource interactionSource3;
        Brush cursorBrush3;
        boolean readOnly3;
        InputTransformation inputTransformation3;
        Composer $composer2 = $composer.startRestartGroup(469439921);
        ComposerKt.sourceInformation($composer2, "C(BasicTextField)P(13,7,2,11,3,14,5,8,6,9,4!1,10)187@11151L21,191@11297L610:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty2 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(readOnly) ? 2048 : 1024;
        }
        int i6 = i & 16;
        int i7 = 8192;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(inputTransformation) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(onKeyboardAction) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(lineLimits) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty2 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 4 : 2;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty2 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty2 |= $composer2.changed(cursorBrush) ? 32 : 16;
        }
        int i15 = i & 4096;
        if (i15 != 0) {
            $dirty2 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty2 |= $composer2.changed(outputTransformation) ? 256 : 128;
        }
        int i16 = i & 8192;
        if (i16 != 0) {
            $dirty2 |= 3072;
            i2 = i16;
        } else {
            i2 = i16;
            if (($changed1 & 3072) == 0) {
                $dirty2 |= ($changed1 & 4096) == 0 ? $composer2.changed(decorator) : $composer2.changedInstance(decorator) ? 2048 : 1024;
            }
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16384) == 0 && $composer2.changed(scrollState)) {
                i7 = 16384;
            }
            $dirty2 |= i7;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly3 = readOnly;
            inputTransformation3 = inputTransformation;
            textStyle3 = textStyle;
            keyboardOptions3 = keyboardOptions;
            onKeyboardAction3 = onKeyboardAction;
            lineLimits3 = lineLimits;
            function4 = function2;
            interactionSource3 = interactionSource;
            cursorBrush3 = cursorBrush;
            outputTransformation2 = outputTransformation;
            decorator2 = decorator;
            scrollState2 = scrollState;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i4 != 0 ? true : enabled;
                readOnly2 = i5 != 0 ? false : readOnly;
                inputTransformation2 = i6 != 0 ? null : inputTransformation;
                TextStyle textStyle4 = i8 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                KeyboardOptions keyboardOptions4 = i9 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActionHandler onKeyboardAction4 = i10 != 0 ? null : onKeyboardAction;
                TextFieldLineLimits lineLimits4 = i11 != 0 ? TextFieldLineLimits.INSTANCE.getDefault() : lineLimits;
                Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function5 = i12 != 0 ? null : function2;
                MutableInteractionSource interactionSource4 = i13 != 0 ? null : interactionSource;
                SolidColor cursorBrush4 = i14 != 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : cursorBrush;
                OutputTransformation outputTransformation3 = i15 != 0 ? null : outputTransformation;
                TextFieldDecorator decorator3 = i2 != 0 ? null : decorator;
                Modifier modifier5 = modifier4;
                if ((i & 16384) != 0) {
                    KeyboardActionHandler onKeyboardAction5 = onKeyboardAction4;
                    boolean enabled5 = enabled4;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                    $dirty1 = (-57345) & $dirty2;
                    outputTransformation2 = outputTransformation3;
                    decorator2 = decorator3;
                    textStyle2 = textStyle4;
                    keyboardOptions2 = keyboardOptions4;
                    modifier2 = modifier5;
                    enabled2 = enabled5;
                    cursorBrush2 = cursorBrush4;
                    interactionSource2 = interactionSource4;
                    function3 = function5;
                    lineLimits2 = lineLimits4;
                    onKeyboardAction2 = onKeyboardAction5;
                } else {
                    KeyboardActionHandler onKeyboardAction6 = onKeyboardAction4;
                    modifier2 = modifier5;
                    scrollState2 = scrollState;
                    enabled2 = enabled4;
                    $dirty1 = $dirty2;
                    outputTransformation2 = outputTransformation3;
                    decorator2 = decorator3;
                    textStyle2 = textStyle4;
                    keyboardOptions2 = keyboardOptions4;
                    cursorBrush2 = cursorBrush4;
                    interactionSource2 = interactionSource4;
                    function3 = function5;
                    lineLimits2 = lineLimits4;
                    onKeyboardAction2 = onKeyboardAction6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16384) != 0) {
                    int i17 = (-57345) & $dirty2;
                    enabled2 = enabled;
                    readOnly2 = readOnly;
                    inputTransformation2 = inputTransformation;
                    textStyle2 = textStyle;
                    keyboardOptions2 = keyboardOptions;
                    onKeyboardAction2 = onKeyboardAction;
                    lineLimits2 = lineLimits;
                    function3 = function2;
                    interactionSource2 = interactionSource;
                    cursorBrush2 = cursorBrush;
                    outputTransformation2 = outputTransformation;
                    decorator2 = decorator;
                    scrollState2 = scrollState;
                    $dirty1 = i17;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    readOnly2 = readOnly;
                    inputTransformation2 = inputTransformation;
                    keyboardOptions2 = keyboardOptions;
                    onKeyboardAction2 = onKeyboardAction;
                    lineLimits2 = lineLimits;
                    function3 = function2;
                    interactionSource2 = interactionSource;
                    cursorBrush2 = cursorBrush;
                    outputTransformation2 = outputTransformation;
                    decorator2 = decorator;
                    scrollState2 = scrollState;
                    $dirty1 = $dirty2;
                    textStyle2 = textStyle;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(469439921, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:190)");
            }
            BasicTextField(state, modifier2, enabled2, readOnly2, inputTransformation2, textStyle2, keyboardOptions2, onKeyboardAction2, lineLimits2, function3, interactionSource2, cursorBrush2, (CodepointTransformation) null, outputTransformation2, decorator2, scrollState2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), ($dirty1 & 14) | 384 | ($dirty1 & 112) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (($dirty1 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            enabled3 = enabled2;
            textStyle3 = textStyle2;
            keyboardOptions3 = keyboardOptions2;
            onKeyboardAction3 = onKeyboardAction2;
            lineLimits3 = lineLimits2;
            function4 = function3;
            interactionSource3 = interactionSource2;
            cursorBrush3 = cursorBrush2;
            readOnly3 = readOnly2;
            inputTransformation3 = inputTransformation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z = enabled3;
            final boolean z2 = readOnly3;
            final InputTransformation inputTransformation4 = inputTransformation3;
            final TextStyle textStyle5 = textStyle3;
            final KeyboardOptions keyboardOptions5 = keyboardOptions3;
            final KeyboardActionHandler keyboardActionHandler = onKeyboardAction3;
            final TextFieldLineLimits textFieldLineLimits = lineLimits3;
            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function6 = function4;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Brush brush = cursorBrush3;
            final OutputTransformation outputTransformation4 = outputTransformation2;
            final TextFieldDecorator textFieldDecorator = decorator2;
            final ScrollState scrollState3 = scrollState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.1
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

                public final void invoke(Composer composer, int i18) {
                    BasicTextFieldKt.BasicTextField(state, modifier6, z, z2, inputTransformation4, textStyle5, keyboardOptions5, keyboardActionHandler, textFieldLineLimits, function6, mutableInteractionSource, brush, outputTransformation4, textFieldDecorator, scrollState3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void BasicTextField(final TextFieldState state, Modifier modifier, boolean enabled, boolean readOnly, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, TextFieldLineLimits lineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource interactionSource, Brush cursorBrush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator decorator, ScrollState scrollState, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        ScrollState scrollState2;
        Modifier.Companion modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActionHandler onKeyboardAction2;
        TextFieldLineLimits lineLimits2;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function3;
        MutableInteractionSource interactionSource2;
        SolidColor cursorBrush2;
        CodepointTransformation codepointTransformation2;
        TextFieldDecorator decorator2;
        int $dirty1;
        InputTransformation inputTransformation2;
        ScrollState scrollState3;
        OutputTransformation outputTransformation2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource interactionSource4;
        KeyboardActionHandler onKeyboardAction3;
        SingleLineCodepointTransformation singleLineCodepointTransformation;
        Object value$iv;
        CodepointTransformation codepointTransformation3;
        Object value$iv2;
        Object value$iv3;
        OutputTransformation outputTransformation3;
        Object value$iv4;
        Object value$iv5;
        InputTransformation inputTransformation3;
        Modifier modifier3;
        Function0<ComposeUiNode> function0;
        boolean enabled3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function4;
        Brush cursorBrush3;
        MutableInteractionSource interactionSource5;
        boolean readOnly3;
        ScrollState scrollState4;
        TextFieldLineLimits lineLimits3;
        TextFieldDecorator decorator3;
        Object value$iv6;
        Composer $composer2 = $composer.startRestartGroup(1570686673);
        ComposerKt.sourceInformation($composer2, "C(BasicTextField)P(14,8,3,12,4,15,6,9,7,10,5,1!1,11)237@13106L21,241@13279L7,242@13334L7,243@13379L7,249@13749L25,250@13823L25,253@13936L826,274@14960L48,276@15044L319,286@15416L7,287@15480L7,288@15534L7,289@15557L429,289@15546L440,302@16034L83,302@15992L125,342@17587L2774:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty2 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(readOnly) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(inputTransformation) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(onKeyboardAction) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(lineLimits) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty2 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 4 : 2;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty2 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty2 |= $composer2.changed(cursorBrush) ? 32 : 16;
        }
        int i15 = i & 4096;
        if (i15 != 0) {
            $dirty2 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty2 |= $composer2.changed(codepointTransformation) ? 256 : 128;
        }
        int i16 = i & 8192;
        if (i16 != 0) {
            $dirty2 |= 3072;
            i2 = i16;
        } else {
            i2 = i16;
            if (($changed1 & 3072) == 0) {
                $dirty2 |= $composer2.changed(outputTransformation) ? 2048 : 1024;
            }
        }
        int i17 = i & 16384;
        if (i17 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            i3 = i17;
        } else {
            i3 = i17;
            if (($changed1 & CpioConstants.C_ISBLK) == 0) {
                $dirty2 |= ($changed1 & 32768) == 0 ? $composer2.changed(decorator) : $composer2.changedInstance(decorator) ? 16384 : 8192;
            }
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            if ((i & 32768) == 0) {
                scrollState2 = scrollState;
                int i18 = $composer2.changed(scrollState2) ? 131072 : 65536;
                $dirty2 |= i18;
            } else {
                scrollState2 = scrollState;
            }
            $dirty2 |= i18;
        } else {
            scrollState2 = scrollState;
        }
        if (($dirty & 306783379) == 306783378 && (74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly3 = readOnly;
            inputTransformation3 = inputTransformation;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            onKeyboardAction3 = onKeyboardAction;
            lineLimits3 = lineLimits;
            function4 = function2;
            interactionSource5 = interactionSource;
            cursorBrush3 = cursorBrush;
            codepointTransformation3 = codepointTransformation;
            outputTransformation3 = outputTransformation;
            decorator3 = decorator;
            scrollState4 = scrollState2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i5 != 0 ? true : enabled;
                readOnly2 = i6 != 0 ? false : readOnly;
                InputTransformation inputTransformation4 = i7 != 0 ? null : inputTransformation;
                textStyle2 = i8 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                keyboardOptions2 = i9 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                onKeyboardAction2 = i10 != 0 ? null : onKeyboardAction;
                lineLimits2 = i11 != 0 ? TextFieldLineLimits.INSTANCE.getDefault() : lineLimits;
                function3 = i12 != 0 ? null : function2;
                interactionSource2 = i13 != 0 ? null : interactionSource;
                cursorBrush2 = i14 != 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : cursorBrush;
                codepointTransformation2 = i15 != 0 ? null : codepointTransformation;
                OutputTransformation outputTransformation4 = i2 != 0 ? null : outputTransformation;
                decorator2 = i3 != 0 ? null : decorator;
                if ((i & 32768) != 0) {
                    modifier2 = modifier2;
                    $dirty1 = $dirty2 & (-458753);
                    inputTransformation2 = inputTransformation4;
                    OutputTransformation outputTransformation5 = outputTransformation4;
                    scrollState3 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                    outputTransformation2 = outputTransformation5;
                } else {
                    $dirty1 = $dirty2;
                    inputTransformation2 = inputTransformation4;
                    OutputTransformation outputTransformation6 = outputTransformation4;
                    scrollState3 = scrollState2;
                    outputTransformation2 = outputTransformation6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32768) != 0) {
                    $dirty2 &= -458753;
                }
                modifier2 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle2 = textStyle;
                keyboardOptions2 = keyboardOptions;
                onKeyboardAction2 = onKeyboardAction;
                lineLimits2 = lineLimits;
                function3 = function2;
                interactionSource2 = interactionSource;
                cursorBrush2 = cursorBrush;
                codepointTransformation2 = codepointTransformation;
                decorator2 = decorator;
                $dirty1 = $dirty2;
                scrollState3 = scrollState2;
                inputTransformation2 = inputTransformation;
                outputTransformation2 = outputTransformation;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1570686673, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:240)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function5 = function3;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            final Brush cursorBrush4 = cursorBrush2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localWindowInfo);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            WindowInfo windowInfo = (WindowInfo) objConsume3;
            final boolean singleLine = Intrinsics.areEqual(lineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
            final TextFieldLineLimits lineLimits4 = lineLimits2;
            $composer2.startReplaceGroup(1483897781);
            ComposerKt.sourceInformation($composer2, "247@13584L39");
            if (interactionSource2 == null) {
                interactionSource3 = interactionSource2;
                ComposerKt.sourceInformationMarkerStart($composer2, 1483897802, "CC(remember):BasicTextField.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv6 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv6);
                } else {
                    value$iv6 = it$iv;
                }
                interactionSource4 = (MutableInteractionSource) value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource3 = interactionSource2;
                interactionSource4 = interactionSource3;
            }
            $composer2.endReplaceGroup();
            final Orientation orientation = singleLine ? Orientation.Horizontal : Orientation.Vertical;
            onKeyboardAction3 = onKeyboardAction2;
            final boolean isFocused = FocusInteractionKt.collectIsFocusedAsState(interactionSource4, $composer2, 0).getValue().booleanValue();
            final boolean isDragHovered = HoverInteractionKt.collectIsHoveredAsState(interactionSource4, $composer2, 0).getValue().booleanValue();
            final boolean isWindowFocused = windowInfo.isWindowFocused();
            ComposerKt.sourceInformationMarkerStart($composer2, 1483898154, "CC(remember):BasicTextField.kt#9igjgp");
            MutableInteractionSource interactionSource6 = interactionSource4;
            boolean invalid$iv = ((57344 & $dirty) == 16384) | (($dirty & 14) == 4) | (($dirty1 & 896) == 256) | (($dirty1 & 7168) == 2048);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                if (codepointTransformation2 == null) {
                    SingleLineCodepointTransformation singleLineCodepointTransformation2 = SingleLineCodepointTransformation.INSTANCE;
                    if (!singleLine) {
                        singleLineCodepointTransformation2 = null;
                    }
                    singleLineCodepointTransformation = singleLineCodepointTransformation2;
                } else {
                    singleLineCodepointTransformation = codepointTransformation2;
                }
                CodepointTransformation appliedCodepointTransformation = singleLineCodepointTransformation;
                value$iv = new TransformedTextFieldState(state, inputTransformation2, appliedCodepointTransformation, outputTransformation2);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv2;
            }
            final TransformedTextFieldState transformedState = (TransformedTextFieldState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1483899178, "CC(remember):BasicTextField.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(transformedState);
            codepointTransformation3 = codepointTransformation2;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new TextLayoutState();
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv3;
            }
            final TextLayoutState textLayoutState = (TextLayoutState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1483899262, "CC(remember):BasicTextField.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(transformedState);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new TextFieldSelectionState(transformedState, textLayoutState, density, enabled2, readOnly2, isFocused && isWindowFocused);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv4;
            }
            final TextFieldSelectionState textFieldSelectionState = (TextFieldSelectionState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            outputTransformation3 = outputTransformation2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer2.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final HapticFeedback currentHapticFeedback = (HapticFeedback) objConsume4;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume5 = $composer2.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ClipboardManager currentClipboardManager = (ClipboardManager) objConsume5;
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = $composer2.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final TextToolbar currentTextToolbar = (TextToolbar) objConsume6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1483899775, "CC(remember):BasicTextField.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changedInstance(textFieldSelectionState) | $composer2.changedInstance(currentHapticFeedback) | $composer2.changedInstance(currentClipboardManager) | $composer2.changedInstance(currentTextToolbar) | $composer2.changed(density) | (($dirty & 896) == 256) | (($dirty & 7168) == 2048);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                final boolean z = enabled2;
                final boolean z2 = readOnly2;
                value$iv4 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$2$1
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
                        textFieldSelectionState.update(currentHapticFeedback, currentClipboardManager, currentTextToolbar, density, z, z2);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv4, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1483900252, "CC(remember):BasicTextField.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changedInstance(textFieldSelectionState);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                textFieldSelectionState2.dispose();
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(textFieldSelectionState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv5, $composer2, 0);
            Modifier modifier4 = modifier2;
            inputTransformation3 = inputTransformation2;
            modifier3 = modifier4;
            Modifier decorationModifiers = PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable(FocusableKt.focusable(modifier4.then(new TextFieldDecoratorModifier(transformedState, textLayoutState, textFieldSelectionState, inputTransformation2, enabled2, readOnly2, keyboardOptions2, onKeyboardAction3, singleLine, interactionSource6)), enabled2, interactionSource6), scrollState3, orientation, (16 & 4) != 0 ? true : enabled2 && scrollState3.getMaxValue() > 0 && textFieldSelectionState.getDraggingHandle() == null, (16 & 8) != 0 ? false : ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection, orientation, false), (16 & 16) != 0 ? null : null, (16 & 32) != 0 ? null : interactionSource6), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, decorationModifiers);
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
            int i19 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i20 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 358827729, "C344@17752L2603,344@17741L2614:BasicTextField.kt#423gt5");
            TextFieldDecorator nonNullDecorator = decorator2 == null ? DefaultTextFieldDecorator : decorator2;
            final TextStyle textStyle3 = textStyle2;
            final boolean z3 = enabled2;
            final boolean z4 = readOnly2;
            final ScrollState scrollState5 = scrollState3;
            enabled3 = enabled2;
            nonNullDecorator.Decoration(ComposableLambdaKt.rememberComposableLambda(-289706194, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
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
                    int minLines;
                    int maxLines;
                    ComposerKt.sourceInformation($composer3, "C355@18073L2272:BasicTextField.kt#423gt5");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-289706194, $changed2, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:345)");
                        }
                        if (lineLimits4 instanceof TextFieldLineLimits.MultiLine) {
                            minLines = ((TextFieldLineLimits.MultiLine) lineLimits4).getMinHeightInLines();
                            maxLines = ((TextFieldLineLimits.MultiLine) lineLimits4).getMaxHeightInLines();
                        } else {
                            minLines = 1;
                            maxLines = 1;
                        }
                        Modifier modifierThen = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m901heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState.m1351getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle3, minLines, maxLines), textStyle3)).then(new TextFieldCoreModifier(isFocused && isWindowFocused, isDragHovered, textLayoutState, transformedState, textFieldSelectionState, cursorBrush4, z3 && !z4, scrollState5, orientation));
                        TextLayoutState textLayoutState2 = textLayoutState;
                        TransformedTextFieldState transformedTextFieldState = transformedState;
                        TextStyle textStyle4 = textStyle3;
                        boolean z5 = singleLine;
                        Function2<Density, Function0<TextLayoutResult>, Unit> function6 = function5;
                        boolean z6 = z3;
                        boolean z7 = isFocused;
                        boolean z8 = isWindowFocused;
                        TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                        boolean z9 = z4;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, true);
                        int $changed$iv$iv2 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifierThen);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int maxLines2 = $changed$iv$iv2 << 6;
                        int $changed$iv$iv$iv2 = (maxLines2 & 896) | 6;
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
                        int i21 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int i22 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1637808447, "C380@19236L600:BasicTextField.kt#423gt5");
                        BoxKt.Box(BringIntoViewRequesterKt.bringIntoViewRequester(Modifier.INSTANCE, textLayoutState2.getBringIntoViewRequester()).then(new TextFieldTextLayoutModifier(textLayoutState2, transformedTextFieldState, textStyle4, z5, function6)), $composer3, 0);
                        $composer3.startReplaceGroup(1593270538);
                        ComposerKt.sourceInformation($composer3, "397@19999L113,401@20174L117");
                        if (z6 && z7 && z8 && textFieldSelectionState2.isInTouchMode()) {
                            BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState2, $composer3, 0);
                            if (!z9) {
                                BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState2, $composer3, 0);
                            }
                        }
                        $composer3.endReplaceGroup();
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
            }, $composer2, 54), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function5;
            cursorBrush3 = cursorBrush4;
            interactionSource5 = interactionSource3;
            readOnly3 = readOnly2;
            scrollState4 = scrollState3;
            lineLimits3 = lineLimits4;
            decorator3 = decorator2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z5 = enabled3;
            final boolean z6 = readOnly3;
            final InputTransformation inputTransformation5 = inputTransformation3;
            final TextStyle textStyle4 = textStyle2;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActionHandler keyboardActionHandler = onKeyboardAction3;
            final TextFieldLineLimits textFieldLineLimits = lineLimits3;
            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function6 = function4;
            final MutableInteractionSource mutableInteractionSource = interactionSource5;
            final Brush brush = cursorBrush3;
            final CodepointTransformation codepointTransformation4 = codepointTransformation3;
            final OutputTransformation outputTransformation7 = outputTransformation3;
            final TextFieldDecorator textFieldDecorator = decorator3;
            final ScrollState scrollState6 = scrollState4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.5
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

                public final void invoke(Composer composer, int i21) {
                    BasicTextFieldKt.BasicTextField(state, modifier5, z5, z6, inputTransformation5, textStyle4, keyboardOptions3, keyboardActionHandler, textFieldLineLimits, function6, mutableInteractionSource, brush, codepointTransformation4, outputTransformation7, textFieldDecorator, scrollState6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionState selectionState, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(1991581797);
        ComposerKt.sourceInformation($composer2, "C(TextFieldCursorHandle)418@20686L327,426@21060L87,415@20556L665:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(selectionState) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1991581797, $dirty2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:412)");
            }
            final TextFieldHandleState cursorHandleState = selectionState.getCursorHandle();
            if (cursorHandleState.getVisible()) {
                long jM1379getPositionF1C5BW0 = cursorHandleState.m1379getPositionF1C5BW0();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -1260664726, "CC(remember):BasicTextField.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(cursorHandleState);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$1$1
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
                            $this$semantics.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, cursorHandleState.m1379getPositionF1C5BW0(), SelectionHandleAnchor.Middle, true, null));
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer2, -1260664352, "CC(remember):BasicTextField.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(selectionState);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new BasicTextFieldKt$TextFieldCursorHandle$2$1(selectionState, null);
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AndroidCursorHandle_androidKt.m1149CursorHandlewy32l68(jM1379getPositionF1C5BW0, SuspendingPointerInputFilterKt.pointerInput(modifierSemantics$default, selectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2), MinTouchTargetSizeForHandles, $composer2, 384, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.TextFieldCursorHandle.3
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
                    BasicTextFieldKt.TextFieldCursorHandle(selectionState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void TextFieldSelectionHandles(final TextFieldSelectionState selectionState, Composer $composer, final int $changed) {
        Object value$iv;
        Continuation continuation;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Continuation continuation2;
        BasicTextFieldKt$TextFieldSelectionHandles$2$1 value$iv6;
        Composer $composer2 = $composer.startRestartGroup(2025287684);
        ComposerKt.sourceInformation($composer2, "C(TextFieldSelectionHandles)439@21425L149,462@22303L150,469@22542L168,477@22918L87,468@22496L583:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(selectionState) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025287684, $dirty2, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:437)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1033811092, "CC(remember):BasicTextField.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$startHandleState$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldHandleState invoke() {
                        return selectionState.getSelectionHandleState$foundation_release(true, false);
                    }
                });
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            State startHandleState$delegate = (State) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(-1033810938);
            ComposerKt.sourceInformation($composer2, "446@21665L167,454@22043L86,445@21619L584");
            if (TextFieldSelectionHandles$lambda$11(startHandleState$delegate).getVisible()) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1033810852, "CC(remember):BasicTextField.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(selectionState);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo1150provideF1C5BW0() {
                            return selectionState.getSelectionHandleState$foundation_release(true, true).m1379getPositionF1C5BW0();
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                } else {
                    value$iv5 = it$iv2;
                }
                OffsetProvider offsetProvider = (OffsetProvider) value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ResolvedTextDirection direction = TextFieldSelectionHandles$lambda$11(startHandleState$delegate).getDirection();
                boolean handlesCrossed = TextFieldSelectionHandles$lambda$11(startHandleState$delegate).getHandlesCrossed();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -1033810474, "CC(remember):BasicTextField.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(selectionState);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    continuation2 = null;
                    value$iv6 = new BasicTextFieldKt$TextFieldSelectionHandles$2$1(selectionState, null);
                    $composer2.updateRememberedValue(value$iv6);
                } else {
                    value$iv6 = it$iv3;
                    continuation2 = null;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, selectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv6);
                continuation = continuation2;
                AndroidSelectionHandles_androidKt.m1458SelectionHandlepzduO1o(offsetProvider, true, direction, handlesCrossed, MinTouchTargetSizeForHandles, modifierPointerInput, $composer2, 24624, 0);
            } else {
                continuation = null;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer2, -1033810214, "CC(remember):BasicTextField.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$endHandleState$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldHandleState invoke() {
                        return selectionState.getSelectionHandleState$foundation_release(false, false);
                    }
                });
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv4;
            }
            State endHandleState$delegate = (State) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (TextFieldSelectionHandles$lambda$15(endHandleState$delegate).getVisible()) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1033809975, "CC(remember):BasicTextField.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changedInstance(selectionState);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo1150provideF1C5BW0() {
                            return selectionState.getSelectionHandleState$foundation_release(false, true).m1379getPositionF1C5BW0();
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv5;
                }
                OffsetProvider offsetProvider2 = (OffsetProvider) value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ResolvedTextDirection direction2 = TextFieldSelectionHandles$lambda$15(endHandleState$delegate).getDirection();
                boolean handlesCrossed2 = TextFieldSelectionHandles$lambda$15(endHandleState$delegate).getHandlesCrossed();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -1033809599, "CC(remember):BasicTextField.kt#9igjgp");
                boolean invalid$iv4 = $composer2.changedInstance(selectionState);
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new BasicTextFieldKt$TextFieldSelectionHandles$4$1(selectionState, continuation);
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AndroidSelectionHandles_androidKt.m1458SelectionHandlepzduO1o(offsetProvider2, false, direction2, handlesCrossed2, MinTouchTargetSizeForHandles, SuspendingPointerInputFilterKt.pointerInput(companion2, selectionState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4), $composer2, 24624, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.TextFieldSelectionHandles.5
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
                    BasicTextFieldKt.TextFieldSelectionHandles(selectionState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$11(State<TextFieldHandleState> state) {
        Object thisObj$iv = state.getValue();
        return (TextFieldHandleState) thisObj$iv;
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$15(State<TextFieldHandleState> state) {
        Object thisObj$iv = state.getValue();
        return (TextFieldHandleState) thisObj$iv;
    }

    public static final void BasicTextField(final String value, final Function1<? super String, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function2, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean enabled2;
        int maxLines2;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M1168getLambda1$foundation_release;
        Brush cursorBrush2;
        int maxLines3;
        Function1<? super TextLayoutResult, Unit> function4;
        MutableInteractionSource interactionSource2;
        boolean readOnly2;
        TextStyle textStyle2;
        Modifier modifier2;
        KeyboardActions keyboardActions2;
        int $dirty;
        VisualTransformation visualTransformation2;
        boolean singleLine2;
        KeyboardOptions keyboardOptions2;
        Object value$iv;
        Object value$iv2;
        boolean singleLine3;
        boolean enabled3;
        KeyboardActions keyboardActions3;
        KeyboardOptions keyboardOptions3;
        int minLines2;
        int maxLines4;
        boolean readOnly3;
        Modifier modifier3;
        TextStyle textStyle3;
        VisualTransformation visualTransformation3;
        Function1<? super TextLayoutResult, Unit> function5;
        Composer $composer2 = $composer.startRestartGroup(945255183);
        ComposerKt.sourceInformation($composer2, "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)612@31044L57,618@31397L216,618@31386L227,627@31934L41,631@32052L373,629@31981L1032:BasicTextField.kt#423gt5");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(readOnly) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changed(textStyle) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty2 |= ((i & 512) == 0 && $composer2.changed(maxLines)) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(minLines) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changed(visualTransformation) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i12 = i & 8192;
        if (i12 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer2.changed(interactionSource) ? 2048 : 1024;
        }
        int i13 = i & 16384;
        if (i13 != 0) {
            $dirty1 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty1 |= $composer2.changed(cursorBrush) ? 16384 : 8192;
        }
        int i14 = i & 32768;
        if (i14 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty1 |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        if (($dirty2 & 306783379) == 306783378 && (74899 & $dirty1) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly3 = readOnly;
            textStyle3 = textStyle;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            singleLine3 = singleLine;
            maxLines4 = maxLines;
            minLines2 = minLines;
            visualTransformation3 = visualTransformation;
            function5 = function2;
            interactionSource2 = interactionSource;
            cursorBrush2 = cursorBrush;
            function3M1168getLambda1$foundation_release = function3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                boolean readOnly4 = i4 != 0 ? false : readOnly;
                TextStyle textStyle4 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i8 != 0 ? false : singleLine;
                if ((i & 512) != 0) {
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                    $dirty2 &= -1879048193;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines3 = i9 != 0 ? 1 : minLines;
                VisualTransformation visualTransformation4 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                C07146 c07146 = i11 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.6
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                    }
                } : function2;
                MutableInteractionSource interactionSource3 = i12 != 0 ? null : interactionSource;
                SolidColor cursorBrush3 = i13 != 0 ? new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null) : cursorBrush;
                if (i14 != 0) {
                    cursorBrush2 = cursorBrush3;
                    function3M1168getLambda1$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m1168getLambda1$foundation_release();
                    maxLines3 = minLines3;
                    function4 = c07146;
                    interactionSource2 = interactionSource3;
                    readOnly2 = readOnly4;
                    textStyle2 = textStyle4;
                    modifier2 = modifier4;
                    keyboardActions2 = keyboardActions4;
                    $dirty = $dirty2;
                    visualTransformation2 = visualTransformation4;
                    singleLine2 = singleLine4;
                    keyboardOptions2 = keyboardOptions4;
                } else {
                    function3M1168getLambda1$foundation_release = function3;
                    cursorBrush2 = cursorBrush3;
                    maxLines3 = minLines3;
                    function4 = c07146;
                    interactionSource2 = interactionSource3;
                    readOnly2 = readOnly4;
                    textStyle2 = textStyle4;
                    modifier2 = modifier4;
                    keyboardActions2 = keyboardActions4;
                    $dirty = $dirty2;
                    visualTransformation2 = visualTransformation4;
                    singleLine2 = singleLine4;
                    keyboardOptions2 = keyboardOptions4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 512) != 0) {
                    $dirty2 &= -1879048193;
                }
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle2 = textStyle;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                maxLines3 = minLines;
                visualTransformation2 = visualTransformation;
                function4 = function2;
                interactionSource2 = interactionSource;
                cursorBrush2 = cursorBrush;
                function3M1168getLambda1$foundation_release = function3;
                $dirty = $dirty2;
                modifier2 = modifier;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945255183, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:609)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1483915262, "CC(remember):BasicTextField.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            int maxLines5 = maxLines2;
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(value, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState textFieldValueState$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final TextFieldValue textFieldValue = TextFieldValue.m6497copy3r_uNRQ$default(BasicTextField$lambda$19(textFieldValueState$delegate), value, 0L, (TextRange) null, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1483915615, "CC(remember):BasicTextField.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(textFieldValue);
            boolean enabled4 = enabled2;
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
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
                        if (TextRange.m6244equalsimpl0(textFieldValue.getSelection(), BasicTextFieldKt.BasicTextField$lambda$19(textFieldValueState$delegate).getSelection()) && Intrinsics.areEqual(textFieldValue.getComposition(), BasicTextFieldKt.BasicTextField$lambda$19(textFieldValueState$delegate).getComposition())) {
                            return;
                        }
                        textFieldValueState$delegate.setValue(textFieldValue);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.SideEffect((Function0) value$iv3, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1483916152, "CC(remember):BasicTextField.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 14) == 4;
            KeyboardActions keyboardActions5 = keyboardActions2;
            Object value$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                $composer2.updateRememberedValue(value$iv4);
            }
            final MutableState lastTextValue$delegate = (MutableState) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ImeOptions imeOptions$foundation_release = keyboardOptions2.toImeOptions$foundation_release(singleLine2);
            boolean z = !singleLine2;
            int i15 = singleLine2 ? 1 : maxLines3;
            int i16 = singleLine2 ? 1 : maxLines5;
            ComposerKt.sourceInformationMarkerStart($composer2, 1483916270, "CC(remember):BasicTextField.kt#9igjgp");
            KeyboardOptions keyboardOptions5 = keyboardOptions2;
            boolean invalid$iv3 = $composer2.changed(lastTextValue$delegate) | (($dirty & 112) == 32);
            boolean singleLine5 = singleLine2;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                        invoke2(textFieldValue2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue newTextFieldValueState) {
                        textFieldValueState$delegate.setValue(newTextFieldValueState);
                        boolean stringChangedSinceLastInvocation = !Intrinsics.areEqual(BasicTextFieldKt.BasicTextField$lambda$23(lastTextValue$delegate), newTextFieldValueState.getText());
                        lastTextValue$delegate.setValue(newTextFieldValueState.getText());
                        if (stringChangedSinceLastInvocation) {
                            function1.invoke(newTextFieldValueState.getText());
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) value$iv2, modifier2, textStyle2, visualTransformation2, function4, interactionSource2, cursorBrush2, z, i16, i15, imeOptions$foundation_release, keyboardActions5, enabled4, readOnly2, function3M1168getLambda1$foundation_release, $composer2, ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (29360128 & ($dirty1 << 9)), (($dirty >> 15) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty1), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            singleLine3 = singleLine5;
            enabled3 = enabled4;
            keyboardActions3 = keyboardActions5;
            keyboardOptions3 = keyboardOptions5;
            minLines2 = maxLines3;
            maxLines4 = maxLines5;
            readOnly3 = readOnly2;
            modifier3 = modifier2;
            textStyle3 = textStyle2;
            visualTransformation3 = visualTransformation2;
            function5 = function4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled3;
            final boolean z3 = readOnly3;
            final TextStyle textStyle5 = textStyle3;
            final KeyboardOptions keyboardOptions6 = keyboardOptions3;
            final KeyboardActions keyboardActions6 = keyboardActions3;
            final boolean z4 = singleLine3;
            final int i17 = maxLines4;
            final int i18 = minLines2;
            final VisualTransformation visualTransformation5 = visualTransformation3;
            final Function1<? super TextLayoutResult, Unit> function6 = function5;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final Brush brush = cursorBrush2;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function7 = function3M1168getLambda1$foundation_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.9
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

                public final void invoke(Composer composer, int i19) {
                    BasicTextFieldKt.BasicTextField(value, function1, modifier5, z2, z3, textStyle5, keyboardOptions6, keyboardActions6, z4, i17, i18, visualTransformation5, function6, mutableInteractionSource, brush, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$19(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$23(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void BasicTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function2, MutableInteractionSource interactionSource, Brush cursorBrush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier.Companion modifier2;
        int maxLines2;
        int $dirty;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M1169getLambda2$foundation_release;
        Brush cursorBrush2;
        int minLines2;
        KeyboardActions keyboardActions2;
        VisualTransformation visualTransformation2;
        Function1<? super TextLayoutResult, Unit> function4;
        MutableInteractionSource interactionSource2;
        boolean enabled2;
        int maxLines3;
        boolean readOnly2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        boolean enabled3;
        Object value$iv;
        Composer $composer2;
        boolean singleLine2;
        Composer $composer3 = $composer.startRestartGroup(1804514146);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)764@39846L90,762@39784L740:BasicTextField.kt#423gt5");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer3.changed(textStyle) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty2 |= ((i & 512) == 0 && $composer3.changed(maxLines)) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(minLines) ? 4 : 2;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changed(visualTransformation) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        int i12 = i & 8192;
        if (i12 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 2048 : 1024;
        }
        int i13 = i & 16384;
        if (i13 != 0) {
            $dirty1 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty1 |= $composer3.changed(cursorBrush) ? 16384 : 8192;
        }
        int i14 = i & 32768;
        if (i14 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty1 |= $composer3.changedInstance(function3) ? 131072 : 65536;
        }
        if (($dirty2 & 306783379) == 306783378 && (74899 & $dirty1) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines3 = maxLines;
            minLines2 = minLines;
            visualTransformation2 = visualTransformation;
            function4 = function2;
            interactionSource2 = interactionSource;
            cursorBrush2 = cursorBrush;
            function3M1169getLambda2$foundation_release = function3;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled;
                boolean readOnly3 = i4 != 0 ? false : readOnly;
                TextStyle textStyle3 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                KeyboardOptions keyboardOptions3 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine3 = i8 != 0 ? false : singleLine;
                if ((i & 512) != 0) {
                    maxLines2 = singleLine3 ? 1 : Integer.MAX_VALUE;
                    $dirty2 &= -1879048193;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines3 = i9 != 0 ? 1 : minLines;
                VisualTransformation visualTransformation3 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                C070710 c070710 = i11 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                    }
                } : function2;
                MutableInteractionSource interactionSource3 = i12 != 0 ? null : interactionSource;
                SolidColor cursorBrush3 = i13 != 0 ? new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null) : cursorBrush;
                if (i14 != 0) {
                    $dirty = $dirty2;
                    cursorBrush2 = cursorBrush3;
                    function3M1169getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m1169getLambda2$foundation_release();
                    minLines2 = minLines3;
                    keyboardActions2 = keyboardActions3;
                    visualTransformation2 = visualTransformation3;
                    function4 = c070710;
                    interactionSource2 = interactionSource3;
                    enabled2 = enabled4;
                    maxLines3 = maxLines2;
                    readOnly2 = readOnly3;
                    textStyle2 = textStyle3;
                    keyboardOptions2 = keyboardOptions3;
                    enabled3 = singleLine3;
                } else {
                    $dirty = $dirty2;
                    function3M1169getLambda2$foundation_release = function3;
                    cursorBrush2 = cursorBrush3;
                    minLines2 = minLines3;
                    keyboardActions2 = keyboardActions3;
                    visualTransformation2 = visualTransformation3;
                    function4 = c070710;
                    interactionSource2 = interactionSource3;
                    enabled2 = enabled4;
                    maxLines3 = maxLines2;
                    readOnly2 = readOnly3;
                    textStyle2 = textStyle3;
                    keyboardOptions2 = keyboardOptions3;
                    enabled3 = singleLine3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 512) != 0) {
                    $dirty2 &= -1879048193;
                }
                modifier2 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle2 = textStyle;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                enabled3 = singleLine;
                maxLines3 = maxLines;
                minLines2 = minLines;
                visualTransformation2 = visualTransformation;
                function4 = function2;
                interactionSource2 = interactionSource;
                cursorBrush2 = cursorBrush;
                function3M1169getLambda2$foundation_release = function3;
                $dirty = $dirty2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1804514146, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:761)");
            }
            ImeOptions imeOptions$foundation_release = keyboardOptions2.toImeOptions$foundation_release(enabled3);
            boolean z = !enabled3;
            int i15 = enabled3 ? 1 : minLines2;
            int i16 = enabled3 ? 1 : maxLines3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1483924064, "CC(remember):BasicTextField.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 112) == 32);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$11$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        if (!Intrinsics.areEqual(value, it)) {
                            function1.invoke(it);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int i17 = ($dirty & 14) | ($dirty & 896) | (($dirty >> 6) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (29360128 & ($dirty1 << 9));
            int i18 = (($dirty >> 15) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty1);
            int $dirty3 = i16;
            $composer2 = $composer3;
            int i19 = i15;
            singleLine2 = enabled3;
            CoreTextFieldKt.CoreTextField(value, (Function1) value$iv, modifier2, textStyle2, visualTransformation2, function4, interactionSource2, cursorBrush2, z, $dirty3, i19, imeOptions$foundation_release, keyboardActions2, enabled2, readOnly2, function3M1169getLambda2$foundation_release, $composer2, i17, i18, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z2 = enabled2;
            final boolean z3 = readOnly2;
            final TextStyle textStyle4 = textStyle2;
            final KeyboardOptions keyboardOptions4 = keyboardOptions2;
            final KeyboardActions keyboardActions4 = keyboardActions2;
            final boolean z4 = singleLine2;
            final int i20 = maxLines3;
            final int i21 = minLines2;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final Function1<? super TextLayoutResult, Unit> function5 = function4;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final Brush brush = cursorBrush2;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6 = function3M1169getLambda2$foundation_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.12
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

                public final void invoke(Composer composer, int i22) {
                    BasicTextFieldKt.BasicTextField(value, function1, modifier3, z2, z3, textStyle4, keyboardOptions4, keyboardActions4, z4, i20, i21, visualTransformation4, function5, mutableInteractionSource, brush, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, final int $changed, final int $changed1, final int i) {
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        MutableInteractionSource interactionSource2;
        boolean singleLine2;
        Modifier modifier2;
        int maxLines2;
        VisualTransformation visualTransformation2;
        Function1 onTextLayout2;
        MutableInteractionSource interactionSource3;
        Brush cursorBrush2;
        KeyboardActions keyboardActions2;
        Function3 decorationBox2;
        boolean enabled2;
        boolean readOnly2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation($composer2, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)801@41214L39,806@41454L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(readOnly) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(visualTransformation) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changedInstance(onTextLayout) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer2.changed(cursorBrush) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty1 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty1 |= $composer2.changedInstance(decorationBox) ? 16384 : 8192;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            interactionSource3 = interactionSource;
            cursorBrush2 = cursorBrush;
            decorationBox2 = decorationBox;
            $composer2 = $composer2;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            boolean enabled3 = i3 != 0 ? true : enabled;
            boolean readOnly3 = i4 != 0 ? false : readOnly;
            textStyle2 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
            keyboardOptions2 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
            KeyboardActions keyboardActions3 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
            boolean singleLine3 = i8 != 0 ? false : singleLine;
            int maxLines3 = i9 != 0 ? Integer.MAX_VALUE : maxLines;
            VisualTransformation visualTransformation3 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
            C070913 onTextLayout3 = i11 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.13
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                }
            } : onTextLayout;
            if (i12 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1483925432, "CC(remember):BasicTextField.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                interactionSource2 = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource2 = interactionSource;
            }
            SolidColor cursorBrush3 = i13 != 0 ? new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null) : cursorBrush;
            Function3 decorationBox3 = i14 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1170getLambda3$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454732590, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:805)");
            }
            BasicTextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly3, textStyle2, keyboardOptions2, keyboardActions3, singleLine3, maxLines3, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) onTextLayout3, interactionSource2, cursorBrush3, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox3, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (458752 & ($dirty1 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            singleLine2 = singleLine3;
            modifier2 = modifier3;
            maxLines2 = maxLines3;
            visualTransformation2 = visualTransformation3;
            onTextLayout2 = onTextLayout3;
            interactionSource3 = interactionSource2;
            cursorBrush2 = cursorBrush3;
            keyboardActions2 = keyboardActions3;
            decorationBox2 = decorationBox3;
            enabled2 = enabled3;
            readOnly2 = readOnly3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z = enabled2;
            final boolean z2 = readOnly2;
            final TextStyle textStyle3 = textStyle2;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions4 = keyboardActions2;
            final boolean z3 = singleLine2;
            final int i15 = maxLines2;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final Function1 function1 = onTextLayout2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Brush brush = cursorBrush2;
            final Function3 function3 = decorationBox2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.15
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

                public final void invoke(Composer composer, int i16) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier4, z, z2, textStyle3, keyboardOptions3, keyboardActions4, z3, i15, visualTransformation4, function1, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, final int $changed, final int $changed1, final int i) {
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        MutableInteractionSource interactionSource2;
        boolean singleLine2;
        Modifier modifier2;
        int maxLines2;
        VisualTransformation visualTransformation2;
        Function1 onTextLayout2;
        MutableInteractionSource interactionSource3;
        Brush cursorBrush2;
        KeyboardActions keyboardActions2;
        Function3 decorationBox2;
        boolean enabled2;
        boolean readOnly2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation($composer2, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)841@42739L39,846@42979L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onValueChange) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(readOnly) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(visualTransformation) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changedInstance(onTextLayout) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer2.changed(cursorBrush) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty1 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty1 |= $composer2.changedInstance(decorationBox) ? 16384 : 8192;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            interactionSource3 = interactionSource;
            cursorBrush2 = cursorBrush;
            decorationBox2 = decorationBox;
            $composer2 = $composer2;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            boolean enabled3 = i3 != 0 ? true : enabled;
            boolean readOnly3 = i4 != 0 ? false : readOnly;
            textStyle2 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
            keyboardOptions2 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
            KeyboardActions keyboardActions3 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
            boolean singleLine3 = i8 != 0 ? false : singleLine;
            int maxLines3 = i9 != 0 ? Integer.MAX_VALUE : maxLines;
            VisualTransformation visualTransformation3 = i10 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
            C071116 onTextLayout3 = i11 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.16
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                }
            } : onTextLayout;
            if (i12 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1483926957, "CC(remember):BasicTextField.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                interactionSource2 = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource2 = interactionSource;
            }
            SolidColor cursorBrush3 = i13 != 0 ? new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null) : cursorBrush;
            Function3 decorationBox3 = i14 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1171getLambda4$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-560482651, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:845)");
            }
            BasicTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly3, textStyle2, keyboardOptions2, keyboardActions3, singleLine3, maxLines3, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) onTextLayout3, interactionSource2, cursorBrush3, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox3, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (458752 & ($dirty1 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            singleLine2 = singleLine3;
            modifier2 = modifier3;
            maxLines2 = maxLines3;
            visualTransformation2 = visualTransformation3;
            onTextLayout2 = onTextLayout3;
            interactionSource3 = interactionSource2;
            cursorBrush2 = cursorBrush3;
            keyboardActions2 = keyboardActions3;
            decorationBox2 = decorationBox3;
            enabled2 = enabled3;
            readOnly2 = readOnly3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z = enabled2;
            final boolean z2 = readOnly2;
            final TextStyle textStyle3 = textStyle2;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions4 = keyboardActions2;
            final boolean z3 = singleLine2;
            final int i15 = maxLines2;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final Function1 function1 = onTextLayout2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Brush brush = cursorBrush2;
            final Function3 function3 = decorationBox2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.18
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

                public final void invoke(Composer composer, int i16) {
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier4, z, z2, textStyle3, keyboardOptions3, keyboardActions4, z3, i15, visualTransformation4, function1, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
