package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.focus.FocusManager;
import androidx.compose.p001ui.focus.FocusRequester;
import androidx.compose.p001ui.focus.FocusState;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.hapticfeedback.HapticFeedback;
import androidx.compose.p001ui.input.key.KeyEvent;
import androidx.compose.p001ui.input.key.KeyInputModifierKt;
import androidx.compose.p001ui.input.pointer.PointerIconKt;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.layout.AlignmentLineKt;
import androidx.compose.p001ui.layout.HorizontalAlignmentLine;
import androidx.compose.p001ui.layout.IntrinsicMeasurable;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.SoftwareKeyboardController;
import androidx.compose.p001ui.platform.TextToolbar;
import androidx.compose.p001ui.platform.WindowInfo;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextRangeKt;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.input.CommitTextCommand;
import androidx.compose.p001ui.text.input.DeleteAllCommand;
import androidx.compose.p001ui.text.input.EditCommand;
import androidx.compose.p001ui.text.input.FinishComposingTextCommand;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.ImeOptions;
import androidx.compose.p001ui.text.input.OffsetMapping;
import androidx.compose.p001ui.text.input.PasswordVisualTransformation;
import androidx.compose.p001ui.text.input.TextFieldValue;
import androidx.compose.p001ui.text.input.TextInputService;
import androidx.compose.p001ui.text.input.TextInputSession;
import androidx.compose.p001ui.text.input.TransformedText;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.style.ResolvedTextDirection;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002\u001a0\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a2\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0080@¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0013X\u008a\u0084\u0002"}, m195d2 = {"CoreTextField", "", DownloadUtil.CookieScheme.VALUE, "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CoreTextFieldKt {
    /* JADX WARN: Code duplicated, block: B:338:0x080a A[PHI: r9
  0x080a: PHI (r9v36 'imeOptions' androidx.compose.ui.text.input.ImeOptions) = 
  (r9v28 'imeOptions' androidx.compose.ui.text.input.ImeOptions)
  (r9v37 'imeOptions' androidx.compose.ui.text.input.ImeOptions)
 binds: [B:337:0x0808, B:333:0x07ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:352:0x0876  */
    /* JADX WARN: Code duplicated, block: B:379:0x0959  */
    /* JADX WARN: Code duplicated, block: B:380:0x095b  */
    /* JADX WARN: Code duplicated, block: B:391:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:393:0x09e7  */
    /* JADX WARN: Code duplicated, block: B:394:0x09e9  */
    /* JADX WARN: Code duplicated, block: B:397:0x09f5  */
    /* JADX WARN: Code duplicated, block: B:398:0x09f7  */
    /* JADX WARN: Code duplicated, block: B:408:0x0a4b  */
    /* JADX WARN: Code duplicated, block: B:411:0x0a72  */
    /* JADX WARN: Code duplicated, block: B:412:0x0a74  */
    /* JADX WARN: Code duplicated, block: B:423:0x0ac9  */
    /* JADX WARN: Code duplicated, block: B:424:0x0acb  */
    /* JADX WARN: Code duplicated, block: B:427:0x0ade  */
    /* JADX WARN: Code duplicated, block: B:428:0x0ae0  */
    /* JADX WARN: Code duplicated, block: B:439:0x0b42  */
    /* JADX WARN: Code duplicated, block: B:440:0x0b44  */
    /* JADX WARN: Code duplicated, block: B:443:0x0b4c  */
    /* JADX WARN: Code duplicated, block: B:444:0x0b4e  */
    /* JADX WARN: Code duplicated, block: B:447:0x0b5d  */
    /* JADX WARN: Code duplicated, block: B:448:0x0b5f  */
    /* JADX WARN: Code duplicated, block: B:451:0x0b78  */
    /* JADX WARN: Code duplicated, block: B:454:0x0b81  */
    /* JADX WARN: Code duplicated, block: B:457:0x0b89 A[PHI: r15
  0x0b89: PHI (r15v34 'imeOptions' androidx.compose.ui.text.input.ImeOptions) = 
  (r15v29 'imeOptions' androidx.compose.ui.text.input.ImeOptions)
  (r15v35 'imeOptions' androidx.compose.ui.text.input.ImeOptions)
 binds: [B:456:0x0b87, B:452:0x0b7e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:458:0x0b8b  */
    /* JADX WARN: Code duplicated, block: B:461:0x0b99  */
    /* JADX WARN: Code duplicated, block: B:465:0x0ba6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:469:0x0bda A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:473:0x0be4  */
    /* JADX WARN: Code duplicated, block: B:476:0x0c0f  */
    /* JADX WARN: Code duplicated, block: B:480:0x0c1c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:484:0x0c4e  */
    /* JADX WARN: Code duplicated, block: B:485:0x0c51  */
    /* JADX WARN: Code duplicated, block: B:488:0x0c5d  */
    /* JADX WARN: Code duplicated, block: B:490:0x0c63  */
    /* JADX WARN: Code duplicated, block: B:496:0x0c7a  */
    /* JADX WARN: Code duplicated, block: B:500:0x0c8b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:504:0x0cc1  */
    /* JADX WARN: Code duplicated, block: B:505:0x0cc4  */
    /* JADX WARN: Code duplicated, block: B:508:0x0d4c  */
    /* JADX WARN: Code duplicated, block: B:517:0x0d64  */
    /* JADX WARN: Code duplicated, block: B:518:0x0d6d  */
    /* JADX WARN: Code duplicated, block: B:521:0x0dec  */
    public static final void CoreTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function2, MutableInteractionSource interactionSource, Brush cursorBrush, boolean softWrap, int maxLines, int minLines, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean enabled, boolean readOnly, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        ImeOptions imeOptions2;
        boolean enabled2;
        VisualTransformation visualTransformation2;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3M1172getLambda1$foundation_release;
        Brush cursorBrush2;
        boolean softWrap2;
        int minLines2;
        KeyboardActions keyboardActions2;
        TextStyle textStyle2;
        boolean readOnly2;
        Function1<? super TextLayoutResult, Unit> function4;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        int $dirty1;
        int maxLines2;
        ImeOptions imeOptions3;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        boolean enabled3;
        TextFieldScrollerPosition scrollerPosition;
        TransformedText transformedTextM1241applyCompositionDecoration72CqOWE;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        ImeOptions imeOptions4;
        boolean z;
        boolean invalid$iv;
        Object value$iv8;
        final boolean enabled4;
        boolean z2;
        int $dirty;
        boolean invalid$iv2;
        Object value$iv9;
        boolean invalid$iv3;
        Object value$iv10;
        boolean z3;
        boolean invalid$iv4;
        Object value$iv11;
        LegacyPlatformTextInputServiceAdapter legacyTextInputServiceAdapter;
        Modifier.Companion companionPointerInput;
        boolean z4;
        boolean invalid$iv5;
        Object value$iv12;
        boolean z5;
        boolean z6;
        boolean invalid$iv6;
        Object value$iv13;
        boolean z7;
        boolean z8;
        boolean z9;
        final ImeOptions imeOptions5;
        boolean z10;
        boolean invalid$iv7;
        Object value$iv14;
        boolean z11;
        boolean invalid$iv8;
        Object value$iv15;
        boolean z12;
        boolean invalid$iv9;
        Object value$iv16;
        boolean z13;
        boolean z14;
        ImeOptions imeOptions6;
        final boolean showHandleAndMagnifier;
        Modifier.Companion companionTextFieldMagnifier;
        final int maxLines3;
        boolean enabled5;
        MutableInteractionSource interactionSource3;
        VisualTransformation visualTransformation3;
        Modifier modifier3;
        Composer $composer2;
        boolean z15;
        boolean z16;
        boolean invalid$iv10;
        Object value$iv17;
        Composer $composer3 = $composer.startRestartGroup(-958708118);
        ComposerKt.sourceInformation($composer3, "C(CoreTextField)P(14,10,8,13,15,9,4!1,12,6,7,3,5,2,11)221@12375L29,222@12445L58,223@12549L72,228@12679L7,229@12740L7,230@12808L7,231@12873L7,232@12918L7,233@12987L7,241@13296L42,238@13203L135,244@13379L269,257@13953L21,258@13991L403,287@14793L26,290@14879L51,296@15182L7,297@15233L7,298@15290L7,302@15401L24,303@15459L37,310@15688L1487,351@17282L42,352@17350L897,352@17329L918,377@18318L28,378@18410L896,429@20722L349,443@21134L1473,479@22736L5576,618@28512L60,618@28486L86,622@28607L458,622@28578L487,672@30474L4765,672@30421L4818:CoreTextField.kt#423gt5");
        int $dirty2 = $changed;
        int $dirty3 = $changed1;
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
            $dirty2 |= $composer3.changed(textStyle) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(cursorBrush) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(softWrap) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty3 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty3 |= $composer3.changed(minLines) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty3 |= ((i & 2048) == 0 && $composer3.changed(imeOptions)) ? 32 : 16;
        }
        int i11 = i & 4096;
        if (i11 != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty3 |= $composer3.changed(keyboardActions) ? 256 : 128;
        }
        int i12 = i & 8192;
        if (i12 != 0) {
            $dirty3 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i13 = i & 16384;
        if (i13 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        int i14 = i & 32768;
        if (i14 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= $composer3.changedInstance(function3) ? 131072 : 65536;
        }
        if (($dirty2 & 306783379) == 306783378 && (74899 & $dirty3) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            textStyle2 = textStyle;
            visualTransformation3 = visualTransformation;
            function4 = function2;
            interactionSource3 = interactionSource;
            cursorBrush2 = cursorBrush;
            softWrap2 = softWrap;
            maxLines3 = maxLines;
            minLines2 = minLines;
            imeOptions6 = imeOptions;
            keyboardActions2 = keyboardActions;
            enabled5 = enabled;
            readOnly2 = readOnly;
            function3M1172getLambda1$foundation_release = function3;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                TextStyle textStyle3 = i3 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                VisualTransformation visualTransformation4 = i4 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                C07241 c07241 = i5 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                    }
                } : function2;
                MutableInteractionSource interactionSource4 = i6 != 0 ? null : interactionSource;
                SolidColor cursorBrush3 = i7 != 0 ? new SolidColor(Color.INSTANCE.m4327getUnspecified0d7_KjU(), null) : cursorBrush;
                boolean softWrap3 = i8 != 0 ? true : softWrap;
                int maxLines4 = i9 != 0 ? Integer.MAX_VALUE : maxLines;
                int minLines3 = i10 != 0 ? 1 : minLines;
                if ((i & 2048) != 0) {
                    imeOptions2 = ImeOptions.INSTANCE.getDefault();
                    $dirty3 &= -113;
                } else {
                    imeOptions2 = imeOptions;
                }
                KeyboardActions keyboardActions3 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                enabled2 = i12 != 0 ? true : enabled;
                boolean readOnly3 = i13 != 0 ? false : readOnly;
                if (i14 != 0) {
                    visualTransformation2 = visualTransformation4;
                    cursorBrush2 = cursorBrush3;
                    softWrap2 = softWrap3;
                    minLines2 = minLines3;
                    keyboardActions2 = keyboardActions3;
                    textStyle2 = textStyle3;
                    readOnly2 = readOnly3;
                    function3M1172getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m1172getLambda1$foundation_release();
                    function4 = c07241;
                    interactionSource2 = interactionSource4;
                    modifier2 = modifier4;
                    $dirty1 = $dirty3;
                    maxLines2 = maxLines4;
                    imeOptions3 = imeOptions2;
                } else {
                    visualTransformation2 = visualTransformation4;
                    function3M1172getLambda1$foundation_release = function3;
                    cursorBrush2 = cursorBrush3;
                    softWrap2 = softWrap3;
                    minLines2 = minLines3;
                    keyboardActions2 = keyboardActions3;
                    textStyle2 = textStyle3;
                    readOnly2 = readOnly3;
                    function4 = c07241;
                    interactionSource2 = interactionSource4;
                    modifier2 = modifier4;
                    $dirty1 = $dirty3;
                    maxLines2 = maxLines4;
                    imeOptions3 = imeOptions2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2048) != 0) {
                    $dirty3 &= -113;
                }
                modifier2 = modifier;
                textStyle2 = textStyle;
                visualTransformation2 = visualTransformation;
                function4 = function2;
                interactionSource2 = interactionSource;
                cursorBrush2 = cursorBrush;
                softWrap2 = softWrap;
                maxLines2 = maxLines;
                minLines2 = minLines;
                imeOptions3 = imeOptions;
                keyboardActions2 = keyboardActions;
                enabled2 = enabled;
                readOnly2 = readOnly;
                function3M1172getLambda1$foundation_release = function3;
                $dirty1 = $dirty3;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-958708118, $dirty2, $dirty1, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:220)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -55011856, "CC(remember):CoreTextField.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new FocusRequester();
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final FocusRequester focusRequester = (FocusRequester) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -55011786, "CC(remember):CoreTextField.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            LegacyPlatformTextInputServiceAdapter legacyTextInputServiceAdapter2 = (LegacyPlatformTextInputServiceAdapter) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -55011682, "CC(remember):CoreTextField.kt#9igjgp");
            Object value$iv18 = $composer3.rememberedValue();
            if (value$iv18 == Composer.INSTANCE.getEmpty()) {
                value$iv18 = new TextInputService(legacyTextInputServiceAdapter2);
                $composer3.updateRememberedValue(value$iv18);
            }
            final TextInputService textInputService = (TextInputService) value$iv18;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) objConsume;
            ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localFontFamilyResolver);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) objConsume2;
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer3.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            long selectionBackgroundColor = ((SelectionColors) objConsume3).getSelectionBackgroundColor();
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FocusManager focusManager = (FocusManager) objConsume4;
            ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
            Modifier modifier5 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume5 = $composer3.consume(localWindowInfo);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final WindowInfo windowInfo = (WindowInfo) objConsume5;
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = $composer3.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SoftwareKeyboardController keyboardController = (SoftwareKeyboardController) objConsume6;
            boolean singleLine = maxLines2 == 1 && !softWrap2 && imeOptions3.getSingleLine();
            final Orientation orientation = singleLine ? Orientation.Horizontal : Orientation.Vertical;
            int maxLines5 = maxLines2;
            Object[] objArr = {orientation};
            Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart($composer3, -55010935, "CC(remember):CoreTextField.kt#9igjgp");
            boolean invalid$iv11 = $composer3.changed(orientation);
            MutableInteractionSource interactionSource5 = interactionSource2;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv11 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldScrollerPosition invoke() {
                        return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextFieldScrollerPosition scrollerPosition2 = (TextFieldScrollerPosition) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv3, $composer3, 0, 4);
            ComposerKt.sourceInformationMarkerStart($composer3, -55010852, "CC(remember):CoreTextField.kt#9igjgp");
            boolean invalid$iv12 = (($dirty2 & 14) == 4) | (($dirty2 & 57344) == 16384);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv12 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                TransformedText transformed = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, value.getText());
                TextRange composition = value.getComposition();
                if (composition != null) {
                    scrollerPosition = scrollerPosition2;
                    long it = composition.getPackedValue();
                    enabled3 = enabled2;
                    transformedTextM1241applyCompositionDecoration72CqOWE = TextFieldDelegate.INSTANCE.m1241applyCompositionDecoration72CqOWE(it, transformed);
                    if (transformedTextM1241applyCompositionDecoration72CqOWE == null) {
                    }
                    value$iv4 = transformedTextM1241applyCompositionDecoration72CqOWE;
                    $composer3.updateRememberedValue(value$iv4);
                } else {
                    enabled3 = enabled2;
                    scrollerPosition = scrollerPosition2;
                }
                transformedTextM1241applyCompositionDecoration72CqOWE = transformed;
                value$iv4 = transformedTextM1241applyCompositionDecoration72CqOWE;
                $composer3.updateRememberedValue(value$iv4);
            } else {
                enabled3 = enabled2;
                value$iv4 = it$iv4;
                scrollerPosition = scrollerPosition2;
            }
            final TransformedText transformedText = (TransformedText) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            AnnotatedString visualText = transformedText.getText();
            final OffsetMapping offsetMapping = transformedText.getOffsetMapping();
            RecomposeScope scope = ComposablesKt.getCurrentRecomposeScope($composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -55010240, "CC(remember):CoreTextField.kt#9igjgp");
            boolean invalid$iv13 = $composer3.changed(keyboardController);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv13 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new LegacyTextFieldState(new TextDelegate(visualText, textStyle2, 0, 0, softWrap2, 0, density, fontFamilyResolver, null, 300, null), scope, keyboardController);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final LegacyTextFieldState state = (LegacyTextFieldState) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            state.m1199updatefnh65Uc(value.getText(), visualText, textStyle2, softWrap2, density, fontFamilyResolver, function1, keyboardActions2, focusManager, selectionBackgroundColor);
            state.getProcessor().reset(value, state.getInputSession());
            ComposerKt.sourceInformationMarkerStart($composer3, -55009438, "CC(remember):CoreTextField.kt#9igjgp");
            Object value$iv19 = $composer3.rememberedValue();
            if (value$iv19 == Composer.INSTANCE.getEmpty()) {
                value$iv19 = new UndoManager(0, 1, null);
                $composer3.updateRememberedValue(value$iv19);
            }
            UndoManager undoManager = (UndoManager) value$iv19;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            UndoManager.snapshotIfNeeded$default(undoManager, value, 0L, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -55009352, "CC(remember):CoreTextField.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = new TextFieldSelectionManager(undoManager);
                $composer3.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            final TextFieldSelectionManager manager = (TextFieldSelectionManager) value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            manager.setOffsetMapping$foundation_release(offsetMapping);
            manager.setVisualTransformation$foundation_release(visualTransformation2);
            manager.setOnValueChange$foundation_release(state.getOnValueChange());
            manager.setState$foundation_release(state);
            manager.setValue$foundation_release(value);
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume7 = $composer3.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            manager.setClipboardManager$foundation_release((ClipboardManager) objConsume7);
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume8 = $composer3.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            manager.setTextToolbar((TextToolbar) objConsume8);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume9 = $composer3.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            manager.setHapticFeedBack((HapticFeedback) objConsume9);
            manager.setFocusRequester(focusRequester);
            manager.setEditable(!readOnly2);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -55008772, "CC(remember):CoreTextField.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = BringIntoViewRequesterKt.BringIntoViewRequester();
                $composer3.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -55008543, "CC(remember):CoreTextField.kt#9igjgp");
            final VisualTransformation visualTransformation5 = visualTransformation2;
            boolean zChangedInstance = $composer3.changedInstance(state) | (($dirty1 & 7168) == 2048) | (($dirty1 & 57344) == 16384) | $composer3.changedInstance(textInputService) | (($dirty2 & 14) == 4);
            if ((($dirty1 & 112) ^ 48) > 32) {
                if ($composer3.changed(imeOptions4)) {
                    imeOptions4 = imeOptions3;
                    z = true;
                }
                invalid$iv = zChangedInstance | z | $composer3.changedInstance(offsetMapping) | $composer3.changedInstance(coroutineScope) | $composer3.changedInstance(bringIntoViewRequester) | $composer3.changedInstance(manager);
                Object it$iv8 = $composer3.rememberedValue();
                if (!invalid$iv || it$iv8 == Composer.INSTANCE.getEmpty()) {
                    final boolean z17 = enabled3;
                    final boolean z18 = readOnly2;
                    final ImeOptions imeOptions7 = imeOptions4;
                    value$iv8 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                            invoke2(focusState);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FocusState it2) {
                            TextLayoutResultProxy layoutResult;
                            if (state.getHasFocus() == it2.isFocused()) {
                                return;
                            }
                            state.setHasFocus(it2.isFocused());
                            if (!state.getHasFocus() || !z17 || z18) {
                                CoreTextFieldKt.endInputSession(state);
                            } else {
                                CoreTextFieldKt.startInputSession(textInputService, state, value, imeOptions7, offsetMapping);
                            }
                            if (it2.isFocused() && (layoutResult = state.getLayoutResult()) != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, value, state, layoutResult, offsetMapping, null), 3, null);
                            }
                            if (!it2.isFocused()) {
                                TextFieldSelectionManager.m1531deselect_kEHs6E$foundation_release$default(manager, null, 1, null);
                            }
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = it$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                enabled4 = enabled3;
                Modifier focusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion, enabled4, focusRequester, interactionSource5, (Function1) value$iv8);
                if (enabled4 || readOnly2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                State writeable$delegate = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z2), $composer3, 0);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -55006881, "CC(remember):CoreTextField.kt#9igjgp");
                $dirty = $dirty2;
                invalid$iv2 = (((($dirty1 & 112) ^ 48) <= 32 && $composer3.changed(imeOptions4)) || ($dirty1 & 48) == 32) | $composer3.changed(writeable$delegate) | $composer3.changedInstance(state) | $composer3.changedInstance(textInputService) | $composer3.changedInstance(manager);
                Object it$iv9 = $composer3.rememberedValue();
                if (!invalid$iv2 || it$iv9 == Composer.INSTANCE.getEmpty()) {
                    value$iv9 = new CoreTextFieldKt$CoreTextField$2$1(state, writeable$delegate, textInputService, manager, imeOptions4, null);
                    $composer3.updateRememberedValue(value$iv9);
                } else {
                    value$iv9 = it$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv9, $composer3, 6);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -55005913, "CC(remember):CoreTextField.kt#9igjgp");
                invalid$iv3 = $composer3.changedInstance(state);
                value$iv10 = $composer3.rememberedValue();
                if (!invalid$iv3 || value$iv10 == Composer.INSTANCE.getEmpty()) {
                    value$iv10 = (Function1) new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean it2) {
                            state.setInTouchMode(it2);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv10);
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierUpdateSelectionTouchMode = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) value$iv10);
                ComposerKt.sourceInformationMarkerStart($composer3, -55005821, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance2 = $composer3.changedInstance(state);
                if (($dirty1 & 57344) == 16384) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv4 = zChangedInstance2 | z3 | $composer3.changedInstance(offsetMapping) | $composer3.changedInstance(manager);
                Object it$iv10 = $composer3.rememberedValue();
                if (!invalid$iv4 || it$iv10 == Composer.INSTANCE.getEmpty()) {
                    final boolean z19 = readOnly2;
                    value$iv11 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m1173invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m1173invokek4lQ0M(long offset) {
                            CoreTextFieldKt.tapToFocus(state, focusRequester, !z19);
                            if (state.getHasFocus()) {
                                if (state.getHandleState() != HandleState.Selection) {
                                    TextLayoutResultProxy layoutResult = state.getLayoutResult();
                                    if (layoutResult != null) {
                                        LegacyTextFieldState legacyTextFieldState = state;
                                        TextFieldDelegate.INSTANCE.m1243setCursorOffsetULxng0E$foundation_release(offset, layoutResult, legacyTextFieldState.getProcessor(), offsetMapping, legacyTextFieldState.getOnValueChange());
                                        if (legacyTextFieldState.getTextDelegate().getText().length() > 0) {
                                            legacyTextFieldState.setHandleState(HandleState.Cursor);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                manager.m1535deselect_kEHs6E$foundation_release(Offset.m4038boximpl(offset));
                            }
                        }
                    };
                    $composer3.updateRememberedValue(value$iv11);
                } else {
                    value$iv11 = it$iv10;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(modifierUpdateSelectionTouchMode, interactionSource5, enabled4, (Function1) value$iv11), manager.getMouseSelectionObserver(), manager.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                $composer3.startReplaceGroup(-55004680);
                ComposerKt.sourceInformation($composer3, "407@19644L963");
                if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    Boolean boolValueOf = Boolean.valueOf(enabled4);
                    Boolean boolValueOf2 = Boolean.valueOf(readOnly2);
                    ComposerKt.sourceInformationMarkerStart($composer3, -55004587, "CC(remember):CoreTextField.kt#9igjgp");
                    if (($dirty1 & 7168) == 2048) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if (($dirty1 & 57344) == 16384) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean zChangedInstance3 = z16 | z15 | $composer3.changedInstance(state);
                    legacyTextInputServiceAdapter = legacyTextInputServiceAdapter2;
                    invalid$iv10 = zChangedInstance3 | $composer3.changedInstance(legacyTextInputServiceAdapter);
                    Object it$iv11 = $composer3.rememberedValue();
                    if (!invalid$iv10 || it$iv11 == Composer.INSTANCE.getEmpty()) {
                        value$iv17 = new CoreTextFieldKt$CoreTextField$pointerModifier$3$1(enabled4, readOnly2, state, focusRequester, legacyTextInputServiceAdapter, null);
                        $composer3.updateRememberedValue(value$iv17);
                    } else {
                        value$iv17 = it$iv11;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    companionPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion3, boolValueOf, boolValueOf2, (Function2) value$iv17);
                } else {
                    legacyTextInputServiceAdapter = legacyTextInputServiceAdapter2;
                    companionPointerInput = Modifier.INSTANCE;
                }
                $composer3.endReplaceGroup();
                Modifier pointerModifier = modifierPointerHoverIcon$default.then(companionPointerInput);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -55003509, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance4 = $composer3.changedInstance(state);
                if (($dirty & 14) == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                invalid$iv5 = zChangedInstance4 | z4 | $composer3.changedInstance(offsetMapping);
                Object it$iv12 = $composer3.rememberedValue();
                if (!invalid$iv5 || it$iv12 == Composer.INSTANCE.getEmpty()) {
                    value$iv12 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope $this$drawBehind) {
                            TextLayoutResultProxy layoutResult = state.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            TextFieldValue textFieldValue = value;
                            OffsetMapping offsetMapping2 = offsetMapping;
                            LegacyTextFieldState legacyTextFieldState = state;
                            Canvas canvas = $this$drawBehind.getDrawContext().getCanvas();
                            TextFieldDelegate.INSTANCE.draw$foundation_release(canvas, textFieldValue, offsetMapping2, layoutResult.getValue(), legacyTextFieldState.getSelectionPaint());
                        }
                    };
                    $composer3.updateRememberedValue(value$iv12);
                } else {
                    value$iv12 = it$iv12;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Modifier drawModifier = DrawModifierKt.drawBehind(companion4, (Function1) value$iv12);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -55003097, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance5 = $composer3.changedInstance(state);
                if (($dirty1 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChanged = zChangedInstance5 | z5 | $composer3.changed(windowInfo) | $composer3.changedInstance(manager);
                if (($dirty & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                invalid$iv6 = zChanged | z6 | $composer3.changedInstance(offsetMapping);
                Object it$iv13 = $composer3.rememberedValue();
                if (!invalid$iv6 || it$iv13 == Composer.INSTANCE.getEmpty()) {
                    value$iv13 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
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
                        public final void invoke2(LayoutCoordinates it2) {
                            state.setLayoutCoordinates(it2);
                            TextLayoutResultProxy layoutResult = state.getLayoutResult();
                            if (layoutResult != null) {
                                layoutResult.setInnerTextFieldCoordinates(it2);
                            }
                            if (enabled4) {
                                if (state.getHandleState() == HandleState.Selection) {
                                    if (state.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                        manager.showSelectionToolbar$foundation_release();
                                    } else {
                                        manager.hideSelectionToolbar$foundation_release();
                                    }
                                    state.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, true));
                                    state.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, false));
                                    state.setShowCursorHandle(TextRange.m6245getCollapsedimpl(value.getSelection()));
                                } else if (state.getHandleState() == HandleState.Cursor) {
                                    state.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, true));
                                }
                                CoreTextFieldKt.notifyFocusedRect(state, value, offsetMapping);
                                TextLayoutResultProxy layoutResult2 = state.getLayoutResult();
                                if (layoutResult2 != null) {
                                    LegacyTextFieldState legacyTextFieldState = state;
                                    TextFieldValue textFieldValue = value;
                                    OffsetMapping offsetMapping2 = offsetMapping;
                                    TextInputSession inputSession = legacyTextFieldState.getInputSession();
                                    if (inputSession != null && legacyTextFieldState.getHasFocus()) {
                                        TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue, offsetMapping2, layoutResult2);
                                    }
                                }
                            }
                        }
                    };
                    $composer3.updateRememberedValue(value$iv13);
                } else {
                    value$iv13 = it$iv13;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Modifier onPositionedModifier = OnGloballyPositionedModifierKt.onGloballyPositioned(companion5, (Function1) value$iv13);
                final boolean isPassword = visualTransformation5 instanceof PasswordVisualTransformation;
                Modifier.Companion companion6 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -55001495, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance6 = $composer3.changedInstance(transformedText);
                if (($dirty & 14) == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z20 = zChangedInstance6 | z7;
                if (($dirty1 & 7168) == 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                boolean zChanged2 = z20 | z8 | $composer3.changed(isPassword);
                if ((57344 & $dirty1) == 16384) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean zChangedInstance7 = zChanged2 | z9 | $composer3.changedInstance(state) | $composer3.changedInstance(offsetMapping) | $composer3.changedInstance(manager);
                if ((($dirty1 & 112) ^ 48) > 32) {
                    imeOptions5 = imeOptions4;
                    if (!$composer3.changed(imeOptions5)) {
                        z10 = true;
                    }
                    invalid$iv7 = zChangedInstance7 | z10;
                    Object it$iv14 = $composer3.rememberedValue();
                    if (!invalid$iv7 || it$iv14 == Composer.INSTANCE.getEmpty()) {
                        final boolean z21 = readOnly2;
                        final ImeOptions imeOptions8 = imeOptions5;
                        value$iv14 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
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
                            public final void invoke2(final SemanticsPropertyReceiver $this$semantics) {
                                SemanticsPropertiesKt.setEditableText($this$semantics, transformedText.getText());
                                SemanticsPropertiesKt.m6080setTextSelectionRangeFDrldGo($this$semantics, value.getSelection());
                                if (!enabled4) {
                                    SemanticsPropertiesKt.disabled($this$semantics);
                                }
                                if (isPassword) {
                                    SemanticsPropertiesKt.password($this$semantics);
                                }
                                if (enabled4 && !z21) {
                                    SemanticsPropertiesKt.editable($this$semantics);
                                }
                                final LegacyTextFieldState legacyTextFieldState = state;
                                SemanticsPropertiesKt.getTextLayoutResult$default($this$semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(List<TextLayoutResult> list) {
                                        boolean z22;
                                        if (legacyTextFieldState.getLayoutResult() != null) {
                                            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                                            Intrinsics.checkNotNull(layoutResult);
                                            list.add(layoutResult.getValue());
                                            z22 = true;
                                        } else {
                                            z22 = false;
                                        }
                                        return Boolean.valueOf(z22);
                                    }
                                }, 1, null);
                                final boolean z22 = z21;
                                final boolean z23 = enabled4;
                                final LegacyTextFieldState legacyTextFieldState2 = state;
                                SemanticsPropertiesKt.setText$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(AnnotatedString text) {
                                        Unit unit2;
                                        if (z22 || !z23) {
                                            return false;
                                        }
                                        TextInputSession session = legacyTextFieldState2.getInputSession();
                                        if (session != null) {
                                            LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState2;
                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState3.getProcessor(), legacyTextFieldState3.getOnValueChange(), session);
                                            unit2 = Unit.INSTANCE;
                                        } else {
                                            unit2 = null;
                                        }
                                        if (unit2 == null) {
                                            SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                            legacyTextFieldState2.getOnValueChange().invoke(new TextFieldValue(text.getText(), TextRangeKt.TextRange(text.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        }
                                        return true;
                                    }
                                }, 1, null);
                                final boolean z24 = z21;
                                final boolean z25 = enabled4;
                                final LegacyTextFieldState legacyTextFieldState3 = state;
                                final TextFieldValue textFieldValue = value;
                                SemanticsPropertiesKt.insertTextAtCursor$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(AnnotatedString text) {
                                        Unit unit2;
                                        if (z24 || !z25) {
                                            return false;
                                        }
                                        TextInputSession session = legacyTextFieldState3.getInputSession();
                                        if (session != null) {
                                            LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), session);
                                            unit2 = Unit.INSTANCE;
                                        } else {
                                            unit2 = null;
                                        }
                                        if (unit2 == null) {
                                            SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                            TextFieldValue textFieldValue2 = textFieldValue;
                                            LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState3;
                                            String newText = StringsKt.replaceRange((CharSequence) textFieldValue2.getText(), TextRange.m6251getStartimpl(textFieldValue2.getSelection()), TextRange.m6246getEndimpl(textFieldValue2.getSelection()), (CharSequence) text).toString();
                                            long newCursor = TextRangeKt.TextRange(TextRange.m6251getStartimpl(textFieldValue2.getSelection()) + text.length());
                                            legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(newText, newCursor, (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        }
                                        return true;
                                    }
                                }, 1, null);
                                final OffsetMapping offsetMapping2 = offsetMapping;
                                final boolean z26 = enabled4;
                                final TextFieldValue textFieldValue2 = value;
                                final TextFieldSelectionManager textFieldSelectionManager = manager;
                                final LegacyTextFieldState legacyTextFieldState4 = state;
                                SemanticsPropertiesKt.setSelection$default($this$semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                    }

                                    public final Boolean invoke(int selectionStart, int selectionEnd, boolean relativeToOriginalText) {
                                        int start;
                                        int end;
                                        if (relativeToOriginalText) {
                                            start = selectionStart;
                                        } else {
                                            start = offsetMapping2.transformedToOriginal(selectionStart);
                                        }
                                        if (relativeToOriginalText) {
                                            end = selectionEnd;
                                        } else {
                                            end = offsetMapping2.transformedToOriginal(selectionEnd);
                                        }
                                        boolean z27 = false;
                                        if (z26 && (start != TextRange.m6251getStartimpl(textFieldValue2.getSelection()) || end != TextRange.m6246getEndimpl(textFieldValue2.getSelection()))) {
                                            if (Math.min(start, end) >= 0 && Math.max(start, end) <= textFieldValue2.getText().length()) {
                                                if (!relativeToOriginalText && start != end) {
                                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager, false, 1, null);
                                                } else {
                                                    textFieldSelectionManager.exitSelectionMode$foundation_release();
                                                }
                                                legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(textFieldValue2.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                z27 = true;
                                            } else {
                                                textFieldSelectionManager.exitSelectionMode$foundation_release();
                                            }
                                        }
                                        return Boolean.valueOf(z27);
                                    }
                                }, 1, null);
                                int imeAction = imeOptions8.getImeAction();
                                final LegacyTextFieldState legacyTextFieldState5 = state;
                                final ImeOptions imeOptions9 = imeOptions8;
                                SemanticsPropertiesKt.m6076onImeAction9UiTYpY$default($this$semantics, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        legacyTextFieldState5.getOnImeActionPerformed().invoke(ImeAction.m6416boximpl(imeOptions9.getImeAction()));
                                        return true;
                                    }
                                }, 2, null);
                                final LegacyTextFieldState legacyTextFieldState6 = state;
                                final FocusRequester focusRequester2 = focusRequester;
                                final boolean z27 = z21;
                                SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        CoreTextFieldKt.tapToFocus(legacyTextFieldState6, focusRequester2, !z27);
                                        return true;
                                    }
                                }, 1, null);
                                final TextFieldSelectionManager textFieldSelectionManager2 = manager;
                                SemanticsPropertiesKt.onLongClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                        return true;
                                    }
                                }, 1, null);
                                if (!TextRange.m6245getCollapsedimpl(value.getSelection()) && !isPassword) {
                                    final TextFieldSelectionManager textFieldSelectionManager3 = manager;
                                    SemanticsPropertiesKt.copyText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager3, false, 1, null);
                                            return true;
                                        }
                                    }, 1, null);
                                    if (enabled4 && !z21) {
                                        final TextFieldSelectionManager textFieldSelectionManager4 = manager;
                                        SemanticsPropertiesKt.cutText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                textFieldSelectionManager4.cut$foundation_release();
                                                return true;
                                            }
                                        }, 1, null);
                                    }
                                }
                                if (enabled4 && !z21) {
                                    final TextFieldSelectionManager textFieldSelectionManager5 = manager;
                                    SemanticsPropertiesKt.pasteText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            textFieldSelectionManager5.paste$foundation_release();
                                            return true;
                                        }
                                    }, 1, null);
                                }
                            }
                        };
                        $composer3.updateRememberedValue(value$iv14);
                    } else {
                        value$iv14 = it$iv14;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier semanticsModifier = SemanticsModifierKt.semantics(companion6, true, (Function1) value$iv14);
                    if (enabled4 || readOnly2 || !windowInfo.isWindowFocused()) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    boolean showCursor = z11;
                    final Modifier cursorModifier = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping, cursorBrush2, showCursor);
                    ComposerKt.sourceInformationMarkerStart($composer3, -54995719, "CC(remember):CoreTextField.kt#9igjgp");
                    invalid$iv8 = $composer3.changedInstance(manager);
                    Object it$iv15 = $composer3.rememberedValue();
                    if (!invalid$iv8 || it$iv15 == Composer.INSTANCE.getEmpty()) {
                        value$iv15 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                                final TextFieldSelectionManager textFieldSelectionManager = manager;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                                    }
                                };
                            }
                        };
                        $composer3.updateRememberedValue(value$iv15);
                    } else {
                        value$iv15 = it$iv15;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.DisposableEffect(manager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv15, $composer3, 0);
                    ComposerKt.sourceInformationMarkerStart($composer3, -54995624, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean zChangedInstance8 = $composer3.changedInstance(state) | $composer3.changedInstance(textInputService);
                    if (($dirty & 14) == 4) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    invalid$iv9 = zChangedInstance8 | z12 | (((($dirty1 & 112) ^ 48) <= 32 && $composer3.changed(imeOptions5)) || ($dirty1 & 48) == 32);
                    Object it$iv16 = $composer3.rememberedValue();
                    if (!invalid$iv9 || it$iv16 == Composer.INSTANCE.getEmpty()) {
                        value$iv16 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                                if (state.getHasFocus()) {
                                    state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, value, state.getProcessor(), imeOptions5, state.getOnValueChange(), state.getOnImeActionPerformed()));
                                }
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        $composer3.updateRememberedValue(value$iv16);
                    } else {
                        value$iv16 = it$iv16;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv16, $composer3, ($dirty1 >> 3) & 14);
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    Function1<TextFieldValue, Unit> onValueChange = state.getOnValueChange();
                    boolean z22 = !readOnly2;
                    if (maxLines5 == 1) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = false;
                    imeOptions6 = imeOptions5;
                    Modifier textKeyInputModifier = TextFieldKeyInputKt.m1250textFieldKeyInput2WJ9YEU(companion7, state, manager, value, onValueChange, z22, z13, offsetMapping, undoManager, imeOptions5.getImeAction());
                    final TextFieldScrollerPosition scrollerPosition3 = scrollerPosition;
                    Modifier decorationBoxModifier = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5, legacyTextInputServiceAdapter).then(focusModifier), state, focusManager), state, manager).then(textKeyInputModifier), scrollerPosition3, interactionSource5, enabled4).then(pointerModifier).then(semanticsModifier), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates it2) {
                            TextLayoutResultProxy layoutResult = state.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            layoutResult.setDecorationBoxCoordinates(it2);
                        }
                    });
                    if (enabled4 && state.getHasFocus() && state.isInTouchMode() && windowInfo.isWindowFocused()) {
                        z14 = true;
                    }
                    showHandleAndMagnifier = z14;
                    if (showHandleAndMagnifier) {
                        companionTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, manager);
                    } else {
                        companionTextFieldMagnifier = Modifier.INSTANCE;
                    }
                    maxLines3 = maxLines5;
                    final Modifier magnifierModifier = companionTextFieldMagnifier;
                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function5 = function3M1172getLambda1$foundation_release;
                    final TextStyle textStyle4 = textStyle2;
                    final int i15 = minLines2;
                    enabled5 = enabled4;
                    interactionSource3 = interactionSource5;
                    visualTransformation3 = visualTransformation5;
                    modifier3 = modifier5;
                    final boolean z23 = readOnly2;
                    final Function1<? super TextLayoutResult, Unit> function6 = function4;
                    $composer2 = $composer3;
                    CoreTextFieldRootBox(decorationBoxModifier, manager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5
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
                            ComposerKt.sourceInformation($composer4, "C673@30498L4735,673@30484L4749:CoreTextField.kt#423gt5");
                            if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-374338080, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:673)");
                                }
                                Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function7 = function5;
                                final LegacyTextFieldState legacyTextFieldState = state;
                                final TextStyle textStyle5 = textStyle4;
                                final int i16 = i15;
                                final int i17 = maxLines3;
                                final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition3;
                                final TextFieldValue textFieldValue = value;
                                final VisualTransformation visualTransformation6 = visualTransformation5;
                                final Modifier modifier6 = cursorModifier;
                                final Modifier modifier7 = drawModifier;
                                final Modifier modifier8 = onPositionedModifier;
                                final Modifier modifier9 = magnifierModifier;
                                final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                                final TextFieldSelectionManager textFieldSelectionManager = manager;
                                final boolean z24 = showHandleAndMagnifier;
                                final boolean z25 = z23;
                                final Function1<TextLayoutResult, Unit> function8 = function6;
                                final OffsetMapping offsetMapping2 = offsetMapping;
                                final Density density2 = density;
                                function7.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1
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
                                        Object value$iv20;
                                        ComposerKt.sourceInformation($composer5, "C689@31352L22,698@31711L3512,698@31675L3548:CoreTextField.kt#423gt5");
                                        if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2032502107, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:676)");
                                            }
                                            Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m901heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState.m1197getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle5, i16, i17);
                                            TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                            TextFieldValue textFieldValue2 = textFieldValue;
                                            VisualTransformation visualTransformation7 = visualTransformation6;
                                            ComposerKt.sourceInformationMarkerStart($composer5, -531185709, "CC(remember):CoreTextField.kt#9igjgp");
                                            boolean invalid$iv14 = $composer5.changedInstance(legacyTextFieldState);
                                            final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                            Object it$iv17 = $composer5.rememberedValue();
                                            if (invalid$iv14 || it$iv17 == Composer.INSTANCE.getEmpty()) {
                                                value$iv20 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final TextLayoutResultProxy invoke() {
                                                        return legacyTextFieldState2.getLayoutResult();
                                                    }
                                                };
                                                $composer5.updateRememberedValue(value$iv20);
                                            } else {
                                                value$iv20 = it$iv17;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd($composer5);
                                            Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, (Function0) value$iv20).then(modifier6).then(modifier7), textStyle5).then(modifier8).then(modifier9), bringIntoViewRequester2);
                                            final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                            final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                            final boolean z26 = z24;
                                            final boolean z27 = z25;
                                            final Function1<TextLayoutResult, Unit> function9 = function8;
                                            final TextFieldValue textFieldValue3 = textFieldValue;
                                            final OffsetMapping offsetMapping3 = offsetMapping2;
                                            final Density density3 = density2;
                                            final int i18 = i17;
                                            SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                                /* JADX WARN: Code duplicated, block: B:35:0x0131  */
                                                public final void invoke(Composer $composer6, int $changed4) {
                                                    boolean z28;
                                                    ComposerKt.sourceInformation($composer6, "C699@31729L2880,754@34627L322,767@35151L40:CoreTextField.kt#423gt5");
                                                    if (($changed4 & 3) != 2 || !$composer6.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-363167407, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:699)");
                                                        }
                                                        final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                                        final Function1<TextLayoutResult, Unit> function10 = function9;
                                                        final TextFieldValue textFieldValue4 = textFieldValue3;
                                                        final OffsetMapping offsetMapping4 = offsetMapping3;
                                                        final Density density4 = density3;
                                                        final int i19 = i18;
                                                        MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                            @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                            public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                                return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                            }

                                                            @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                            public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                                return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                            }

                                                            @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                            public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                                return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i20);
                                                            }

                                                            @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                            /* JADX INFO: renamed from: measure-3p2s80s */
                                                            public MeasureResult mo285measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
                                                                Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                                LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
                                                                Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
                                                                Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
                                                                try {
                                                                    TextLayoutResultProxy prevProxy = legacyTextFieldState5.getLayoutResult();
                                                                    this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                                    TextLayoutResult prevResult = prevProxy != null ? prevProxy.getValue() : null;
                                                                    Triple<Integer, Integer, TextLayoutResult> tripleM1242layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1242layout_EkL_Y$foundation_release(legacyTextFieldState4.getTextDelegate(), constraints, $this$measure_u2d3p2s80s.getLayoutDirection(), prevResult);
                                                                    int width = tripleM1242layout_EkL_Y$foundation_release.component1().intValue();
                                                                    int height = tripleM1242layout_EkL_Y$foundation_release.component2().intValue();
                                                                    TextLayoutResult result = tripleM1242layout_EkL_Y$foundation_release.component3();
                                                                    if (!Intrinsics.areEqual(prevResult, result)) {
                                                                        legacyTextFieldState4.setLayoutResult(new TextLayoutResultProxy(result, null, prevProxy != null ? prevProxy.getDecorationBoxCoordinates() : null, 2, null));
                                                                        function10.invoke(result);
                                                                        CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState4, textFieldValue4, offsetMapping4);
                                                                    }
                                                                    LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState4;
                                                                    Density $this$measure_3p2s80s_u24lambda_u241 = density4;
                                                                    legacyTextFieldState6.m1198setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u241.mo564toDpu2uoSUM(i19 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                                    HorizontalAlignmentLine firstBaseline = AlignmentLineKt.getFirstBaseline();
                                                                    float $this$fastRoundToInt$iv = result.getFirstBaseline();
                                                                    HorizontalAlignmentLine lastBaseline = AlignmentLineKt.getLastBaseline();
                                                                    float $this$fastRoundToInt$iv2 = result.getLastBaseline();
                                                                    return $this$measure_u2d3p2s80s.layout(width, height, MapsKt.mapOf(TuplesKt.m202to(firstBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv))), TuplesKt.m202to(lastBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv2)))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                            invoke2(placementScope);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(Placeable.PlacementScope $this$layout) {
                                                                        }
                                                                    });
                                                                } catch (Throwable th) {
                                                                    this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                                    throw th;
                                                                }
                                                            }

                                                            @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                                                                legacyTextFieldState4.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                                return legacyTextFieldState4.getTextDelegate().getMaxIntrinsicWidth();
                                                            }
                                                        };
                                                        ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        Modifier modifier$iv = Modifier.INSTANCE;
                                                        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                        CompositionLocalMap localMap$iv = $composer6.getCurrentCompositionLocalMap();
                                                        Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        int $changed$iv$iv = ((0 << 6) & 896) | 6;
                                                        ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                        if (!($composer6.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        $composer6.startReusableNode();
                                                        if ($composer6.getInserting()) {
                                                            $composer6.createNode(constructor);
                                                        } else {
                                                            $composer6.useNode();
                                                        }
                                                        Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer6);
                                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                                                            $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                                                            $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
                                                        }
                                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                        int i20 = ($changed$iv$iv >> 6) & 14;
                                                        ComposerKt.sourceInformationMarkerStart($composer6, 1017248566, "C:CoreTextField.kt#423gt5");
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        $composer6.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                        if (legacyTextFieldState3.getHandleState() == HandleState.None || legacyTextFieldState3.getLayoutCoordinates() == null) {
                                                            z28 = false;
                                                        } else {
                                                            LayoutCoordinates layoutCoordinates = legacyTextFieldState3.getLayoutCoordinates();
                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                            if (layoutCoordinates.isAttached() && z26) {
                                                                z28 = true;
                                                            } else {
                                                                z28 = false;
                                                            }
                                                        }
                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z28, $composer6, 0);
                                                        if (legacyTextFieldState3.getHandleState() == HandleState.Cursor && !z27 && z26) {
                                                            CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager2, $composer6, 0);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    $composer6.skipToGroupEnd();
                                                }
                                            }, $composer5, 54), $composer5, 48, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }, $composer4, 54), $composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer2, 54), $composer2, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    imeOptions5 = imeOptions4;
                }
                if (($dirty1 & 48) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                invalid$iv7 = zChangedInstance7 | z10;
                Object it$iv17 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                final boolean z24 = readOnly2;
                final ImeOptions imeOptions9 = imeOptions5;
                value$iv14 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
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
                    public final void invoke2(final SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setEditableText($this$semantics, transformedText.getText());
                        SemanticsPropertiesKt.m6080setTextSelectionRangeFDrldGo($this$semantics, value.getSelection());
                        if (!enabled4) {
                            SemanticsPropertiesKt.disabled($this$semantics);
                        }
                        if (isPassword) {
                            SemanticsPropertiesKt.password($this$semantics);
                        }
                        if (enabled4 && !z24) {
                            SemanticsPropertiesKt.editable($this$semantics);
                        }
                        final LegacyTextFieldState legacyTextFieldState = state;
                        SemanticsPropertiesKt.getTextLayoutResult$default($this$semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(List<TextLayoutResult> list) {
                                boolean z25;
                                if (legacyTextFieldState.getLayoutResult() != null) {
                                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                                    Intrinsics.checkNotNull(layoutResult);
                                    list.add(layoutResult.getValue());
                                    z25 = true;
                                } else {
                                    z25 = false;
                                }
                                return Boolean.valueOf(z25);
                            }
                        }, 1, null);
                        final boolean z25 = z24;
                        final boolean z26 = enabled4;
                        final LegacyTextFieldState legacyTextFieldState2 = state;
                        SemanticsPropertiesKt.setText$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString text) {
                                Unit unit2;
                                if (z25 || !z26) {
                                    return false;
                                }
                                TextInputSession session = legacyTextFieldState2.getInputSession();
                                if (session != null) {
                                    LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState2;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState3.getProcessor(), legacyTextFieldState3.getOnValueChange(), session);
                                    unit2 = Unit.INSTANCE;
                                } else {
                                    unit2 = null;
                                }
                                if (unit2 == null) {
                                    SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                    legacyTextFieldState2.getOnValueChange().invoke(new TextFieldValue(text.getText(), TextRangeKt.TextRange(text.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return true;
                            }
                        }, 1, null);
                        final boolean z27 = z24;
                        final boolean z28 = enabled4;
                        final LegacyTextFieldState legacyTextFieldState3 = state;
                        final TextFieldValue textFieldValue = value;
                        SemanticsPropertiesKt.insertTextAtCursor$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString text) {
                                Unit unit2;
                                if (z27 || !z28) {
                                    return false;
                                }
                                TextInputSession session = legacyTextFieldState3.getInputSession();
                                if (session != null) {
                                    LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), session);
                                    unit2 = Unit.INSTANCE;
                                } else {
                                    unit2 = null;
                                }
                                if (unit2 == null) {
                                    SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState3;
                                    String newText = StringsKt.replaceRange((CharSequence) textFieldValue2.getText(), TextRange.m6251getStartimpl(textFieldValue2.getSelection()), TextRange.m6246getEndimpl(textFieldValue2.getSelection()), (CharSequence) text).toString();
                                    long newCursor = TextRangeKt.TextRange(TextRange.m6251getStartimpl(textFieldValue2.getSelection()) + text.length());
                                    legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(newText, newCursor, (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return true;
                            }
                        }, 1, null);
                        final OffsetMapping offsetMapping2 = offsetMapping;
                        final boolean z29 = enabled4;
                        final TextFieldValue textFieldValue2 = value;
                        final TextFieldSelectionManager textFieldSelectionManager = manager;
                        final LegacyTextFieldState legacyTextFieldState4 = state;
                        SemanticsPropertiesKt.setSelection$default($this$semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                            }

                            public final Boolean invoke(int selectionStart, int selectionEnd, boolean relativeToOriginalText) {
                                int start;
                                int end;
                                if (relativeToOriginalText) {
                                    start = selectionStart;
                                } else {
                                    start = offsetMapping2.transformedToOriginal(selectionStart);
                                }
                                if (relativeToOriginalText) {
                                    end = selectionEnd;
                                } else {
                                    end = offsetMapping2.transformedToOriginal(selectionEnd);
                                }
                                boolean z210 = false;
                                if (z29 && (start != TextRange.m6251getStartimpl(textFieldValue2.getSelection()) || end != TextRange.m6246getEndimpl(textFieldValue2.getSelection()))) {
                                    if (Math.min(start, end) >= 0 && Math.max(start, end) <= textFieldValue2.getText().length()) {
                                        if (!relativeToOriginalText && start != end) {
                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager, false, 1, null);
                                        } else {
                                            textFieldSelectionManager.exitSelectionMode$foundation_release();
                                        }
                                        legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(textFieldValue2.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        z210 = true;
                                    } else {
                                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                                    }
                                }
                                return Boolean.valueOf(z210);
                            }
                        }, 1, null);
                        int imeAction = imeOptions9.getImeAction();
                        final LegacyTextFieldState legacyTextFieldState5 = state;
                        final ImeOptions imeOptions10 = imeOptions9;
                        SemanticsPropertiesKt.m6076onImeAction9UiTYpY$default($this$semantics, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                legacyTextFieldState5.getOnImeActionPerformed().invoke(ImeAction.m6416boximpl(imeOptions10.getImeAction()));
                                return true;
                            }
                        }, 2, null);
                        final LegacyTextFieldState legacyTextFieldState6 = state;
                        final FocusRequester focusRequester2 = focusRequester;
                        final boolean z210 = z24;
                        SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                CoreTextFieldKt.tapToFocus(legacyTextFieldState6, focusRequester2, !z210);
                                return true;
                            }
                        }, 1, null);
                        final TextFieldSelectionManager textFieldSelectionManager2 = manager;
                        SemanticsPropertiesKt.onLongClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                return true;
                            }
                        }, 1, null);
                        if (!TextRange.m6245getCollapsedimpl(value.getSelection()) && !isPassword) {
                            final TextFieldSelectionManager textFieldSelectionManager3 = manager;
                            SemanticsPropertiesKt.copyText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager3, false, 1, null);
                                    return true;
                                }
                            }, 1, null);
                            if (enabled4 && !z24) {
                                final TextFieldSelectionManager textFieldSelectionManager4 = manager;
                                SemanticsPropertiesKt.cutText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        textFieldSelectionManager4.cut$foundation_release();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                        if (enabled4 && !z24) {
                            final TextFieldSelectionManager textFieldSelectionManager5 = manager;
                            SemanticsPropertiesKt.pasteText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    textFieldSelectionManager5.paste$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv14);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier semanticsModifier2 = SemanticsModifierKt.semantics(companion6, true, (Function1) value$iv14);
                if (enabled4) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                boolean showCursor2 = z11;
                final Modifier cursorModifier2 = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping, cursorBrush2, showCursor2);
                ComposerKt.sourceInformationMarkerStart($composer3, -54995719, "CC(remember):CoreTextField.kt#9igjgp");
                invalid$iv8 = $composer3.changedInstance(manager);
                Object it$iv18 = $composer3.rememberedValue();
                if (invalid$iv8) {
                }
                value$iv15 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final TextFieldSelectionManager textFieldSelectionManager = manager;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        };
                    }
                };
                $composer3.updateRememberedValue(value$iv15);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.DisposableEffect(manager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv15, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, -54995624, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance9 = $composer3.changedInstance(state) | $composer3.changedInstance(textInputService);
                if (($dirty & 14) == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                invalid$iv9 = zChangedInstance9 | z12 | (((($dirty1 & 112) ^ 48) <= 32 && $composer3.changed(imeOptions5)) || ($dirty1 & 48) == 32);
                Object it$iv19 = $composer3.rememberedValue();
                if (invalid$iv9) {
                }
                value$iv16 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        if (state.getHasFocus()) {
                            state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, value, state.getProcessor(), imeOptions5, state.getOnValueChange(), state.getOnImeActionPerformed()));
                        }
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                $composer3.updateRememberedValue(value$iv16);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv16, $composer3, ($dirty1 >> 3) & 14);
                Modifier.Companion companion8 = Modifier.INSTANCE;
                Function1<TextFieldValue, Unit> onValueChange2 = state.getOnValueChange();
                boolean z25 = !readOnly2;
                if (maxLines5 == 1) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = false;
                imeOptions6 = imeOptions5;
                Modifier textKeyInputModifier2 = TextFieldKeyInputKt.m1250textFieldKeyInput2WJ9YEU(companion8, state, manager, value, onValueChange2, z25, z13, offsetMapping, undoManager, imeOptions5.getImeAction());
                final TextFieldScrollerPosition scrollerPosition4 = scrollerPosition;
                Modifier decorationBoxModifier2 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5, legacyTextInputServiceAdapter).then(focusModifier), state, focusManager), state, manager).then(textKeyInputModifier2), scrollerPosition4, interactionSource5, enabled4).then(pointerModifier).then(semanticsModifier2), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it2) {
                        TextLayoutResultProxy layoutResult = state.getLayoutResult();
                        if (layoutResult == null) {
                            return;
                        }
                        layoutResult.setDecorationBoxCoordinates(it2);
                    }
                });
                if (enabled4) {
                    z14 = true;
                }
                showHandleAndMagnifier = z14;
                if (showHandleAndMagnifier) {
                    companionTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, manager);
                } else {
                    companionTextFieldMagnifier = Modifier.INSTANCE;
                }
                maxLines3 = maxLines5;
                final Modifier magnifierModifier2 = companionTextFieldMagnifier;
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function7 = function3M1172getLambda1$foundation_release;
                final TextStyle textStyle5 = textStyle2;
                final int i16 = minLines2;
                enabled5 = enabled4;
                interactionSource3 = interactionSource5;
                visualTransformation3 = visualTransformation5;
                modifier3 = modifier5;
                final boolean z26 = readOnly2;
                final Function1<? super TextLayoutResult, Unit> function8 = function4;
                $composer2 = $composer3;
                CoreTextFieldRootBox(decorationBoxModifier2, manager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5
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
                        ComposerKt.sourceInformation($composer4, "C673@30498L4735,673@30484L4749:CoreTextField.kt#423gt5");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-374338080, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:673)");
                            }
                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function9 = function7;
                            final LegacyTextFieldState legacyTextFieldState = state;
                            final TextStyle textStyle6 = textStyle5;
                            final int i17 = i16;
                            final int i18 = maxLines3;
                            final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition4;
                            final TextFieldValue textFieldValue = value;
                            final VisualTransformation visualTransformation6 = visualTransformation5;
                            final Modifier modifier6 = cursorModifier2;
                            final Modifier modifier7 = drawModifier;
                            final Modifier modifier8 = onPositionedModifier;
                            final Modifier modifier9 = magnifierModifier2;
                            final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                            final TextFieldSelectionManager textFieldSelectionManager = manager;
                            final boolean z27 = showHandleAndMagnifier;
                            final boolean z28 = z26;
                            final Function1<? super TextLayoutResult, Unit> function10 = function8;
                            final OffsetMapping offsetMapping2 = offsetMapping;
                            final Density density2 = density;
                            function9.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1
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
                                    Object value$iv20;
                                    ComposerKt.sourceInformation($composer5, "C689@31352L22,698@31711L3512,698@31675L3548:CoreTextField.kt#423gt5");
                                    if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2032502107, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:676)");
                                        }
                                        Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m901heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState.m1197getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i17, i18);
                                        TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                        TextFieldValue textFieldValue2 = textFieldValue;
                                        VisualTransformation visualTransformation7 = visualTransformation6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -531185709, "CC(remember):CoreTextField.kt#9igjgp");
                                        boolean invalid$iv14 = $composer5.changedInstance(legacyTextFieldState);
                                        final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                        Object it$iv110 = $composer5.rememberedValue();
                                        if (invalid$iv14 || it$iv110 == Composer.INSTANCE.getEmpty()) {
                                            value$iv20 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final TextLayoutResultProxy invoke() {
                                                    return legacyTextFieldState2.getLayoutResult();
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv20);
                                        } else {
                                            value$iv20 = it$iv110;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, (Function0) value$iv20).then(modifier6).then(modifier7), textStyle6).then(modifier8).then(modifier9), bringIntoViewRequester2);
                                        final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                        final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                        final boolean z29 = z27;
                                        final boolean z210 = z28;
                                        final Function1<? super TextLayoutResult, Unit> function11 = function10;
                                        final TextFieldValue textFieldValue3 = textFieldValue;
                                        final OffsetMapping offsetMapping3 = offsetMapping2;
                                        final Density density3 = density2;
                                        final int i19 = i18;
                                        SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                            /* JADX WARN: Code duplicated, block: B:35:0x0131  */
                                            public final void invoke(Composer $composer6, int $changed4) {
                                                boolean z211;
                                                ComposerKt.sourceInformation($composer6, "C699@31729L2880,754@34627L322,767@35151L40:CoreTextField.kt#423gt5");
                                                if (($changed4 & 3) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-363167407, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:699)");
                                                    }
                                                    final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                                    final Function1<? super TextLayoutResult, Unit> function12 = function11;
                                                    final TextFieldValue textFieldValue4 = textFieldValue3;
                                                    final OffsetMapping offsetMapping4 = offsetMapping3;
                                                    final Density density4 = density3;
                                                    final int i110 = i19;
                                                    MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                            return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                            return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                            return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i20);
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        /* JADX INFO: renamed from: measure-3p2s80s */
                                                        public MeasureResult mo285measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
                                                            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                            LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                            Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
                                                            Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
                                                            Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
                                                            try {
                                                                TextLayoutResultProxy prevProxy = legacyTextFieldState5.getLayoutResult();
                                                                this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                                TextLayoutResult prevResult = prevProxy != null ? prevProxy.getValue() : null;
                                                                Triple<Integer, Integer, TextLayoutResult> tripleM1242layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1242layout_EkL_Y$foundation_release(legacyTextFieldState4.getTextDelegate(), constraints, $this$measure_u2d3p2s80s.getLayoutDirection(), prevResult);
                                                                int width = tripleM1242layout_EkL_Y$foundation_release.component1().intValue();
                                                                int height = tripleM1242layout_EkL_Y$foundation_release.component2().intValue();
                                                                TextLayoutResult result = tripleM1242layout_EkL_Y$foundation_release.component3();
                                                                if (!Intrinsics.areEqual(prevResult, result)) {
                                                                    legacyTextFieldState4.setLayoutResult(new TextLayoutResultProxy(result, null, prevProxy != null ? prevProxy.getDecorationBoxCoordinates() : null, 2, null));
                                                                    function12.invoke(result);
                                                                    CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState4, textFieldValue4, offsetMapping4);
                                                                }
                                                                LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState4;
                                                                Density $this$measure_3p2s80s_u24lambda_u241 = density4;
                                                                legacyTextFieldState6.m1198setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u241.mo564toDpu2uoSUM(i110 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                                HorizontalAlignmentLine firstBaseline = AlignmentLineKt.getFirstBaseline();
                                                                float $this$fastRoundToInt$iv = result.getFirstBaseline();
                                                                HorizontalAlignmentLine lastBaseline = AlignmentLineKt.getLastBaseline();
                                                                float $this$fastRoundToInt$iv2 = result.getLastBaseline();
                                                                return $this$measure_u2d3p2s80s.layout(width, height, MapsKt.mapOf(TuplesKt.m202to(firstBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv))), TuplesKt.m202to(lastBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv2)))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                        invoke2(placementScope);
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                                                                    }
                                                                });
                                                            } catch (Throwable th) {
                                                                this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                                throw th;
                                                            }
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                                                            legacyTextFieldState4.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                            return legacyTextFieldState4.getTextDelegate().getMaxIntrinsicWidth();
                                                        }
                                                    };
                                                    ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    Modifier modifier$iv = Modifier.INSTANCE;
                                                    int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                    CompositionLocalMap localMap$iv = $composer6.getCurrentCompositionLocalMap();
                                                    Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    int $changed$iv$iv = ((0 << 6) & 896) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                    if (!($composer6.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer6.startReusableNode();
                                                    if ($composer6.getInserting()) {
                                                        $composer6.createNode(constructor);
                                                    } else {
                                                        $composer6.useNode();
                                                    }
                                                    Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer6);
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                                                        $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                                                        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
                                                    }
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                    int i20 = ($changed$iv$iv >> 6) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, 1017248566, "C:CoreTextField.kt#423gt5");
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    $composer6.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                    if (legacyTextFieldState3.getHandleState() == HandleState.None || legacyTextFieldState3.getLayoutCoordinates() == null) {
                                                        z211 = false;
                                                    } else {
                                                        LayoutCoordinates layoutCoordinates = legacyTextFieldState3.getLayoutCoordinates();
                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                        if (layoutCoordinates.isAttached() && z29) {
                                                            z211 = true;
                                                        } else {
                                                            z211 = false;
                                                        }
                                                    }
                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z211, $composer6, 0);
                                                    if (legacyTextFieldState3.getHandleState() == HandleState.Cursor && !z210 && z29) {
                                                        CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager2, $composer6, 0);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer6.skipToGroupEnd();
                                            }
                                        }, $composer5, 54), $composer5, 48, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54), $composer4, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                imeOptions4 = imeOptions3;
            }
            imeOptions4 = imeOptions3;
            if (($dirty1 & 48) == 32) {
                imeOptions4 = imeOptions3;
                z = true;
            } else {
                z = false;
            }
            invalid$iv = zChangedInstance | z | $composer3.changedInstance(offsetMapping) | $composer3.changedInstance(coroutineScope) | $composer3.changedInstance(bringIntoViewRequester) | $composer3.changedInstance(manager);
            Object it$iv20 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            final boolean z110 = enabled3;
            final boolean z111 = readOnly2;
            final ImeOptions imeOptions10 = imeOptions4;
            value$iv8 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState it2) {
                    TextLayoutResultProxy layoutResult;
                    if (state.getHasFocus() == it2.isFocused()) {
                        return;
                    }
                    state.setHasFocus(it2.isFocused());
                    if (!state.getHasFocus() || !z110 || z111) {
                        CoreTextFieldKt.endInputSession(state);
                    } else {
                        CoreTextFieldKt.startInputSession(textInputService, state, value, imeOptions10, offsetMapping);
                    }
                    if (it2.isFocused() && (layoutResult = state.getLayoutResult()) != null) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, value, state, layoutResult, offsetMapping, null), 3, null);
                    }
                    if (!it2.isFocused()) {
                        TextFieldSelectionManager.m1531deselect_kEHs6E$foundation_release$default(manager, null, 1, null);
                    }
                }
            };
            $composer3.updateRememberedValue(value$iv8);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            enabled4 = enabled3;
            Modifier focusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion, enabled4, focusRequester, interactionSource5, (Function1) value$iv8);
            if (enabled4) {
                z2 = false;
            } else {
                z2 = false;
            }
            State writeable$delegate2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z2), $composer3, 0);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -55006881, "CC(remember):CoreTextField.kt#9igjgp");
            $dirty = $dirty2;
            invalid$iv2 = (((($dirty1 & 112) ^ 48) <= 32 && $composer3.changed(imeOptions4)) || ($dirty1 & 48) == 32) | $composer3.changed(writeable$delegate2) | $composer3.changedInstance(state) | $composer3.changedInstance(textInputService) | $composer3.changedInstance(manager);
            Object it$iv21 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv9 = new CoreTextFieldKt$CoreTextField$2$1(state, writeable$delegate2, textInputService, manager, imeOptions4, null);
            $composer3.updateRememberedValue(value$iv9);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv9, $composer3, 6);
            Modifier.Companion companion9 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -55005913, "CC(remember):CoreTextField.kt#9igjgp");
            invalid$iv3 = $composer3.changedInstance(state);
            value$iv10 = $composer3.rememberedValue();
            if (!invalid$iv3) {
            }
            value$iv10 = (Function1) new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it2) {
                    state.setInTouchMode(it2);
                }
            };
            $composer3.updateRememberedValue(value$iv10);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierUpdateSelectionTouchMode2 = SelectionGesturesKt.updateSelectionTouchMode(companion9, (Function1) value$iv10);
            ComposerKt.sourceInformationMarkerStart($composer3, -55005821, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance10 = $composer3.changedInstance(state);
            if (($dirty1 & 57344) == 16384) {
                z3 = true;
            } else {
                z3 = false;
            }
            invalid$iv4 = zChangedInstance10 | z3 | $composer3.changedInstance(offsetMapping) | $composer3.changedInstance(manager);
            Object it$iv110 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            final boolean z112 = readOnly2;
            value$iv11 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m1173invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m1173invokek4lQ0M(long offset) {
                    CoreTextFieldKt.tapToFocus(state, focusRequester, !z112);
                    if (state.getHasFocus()) {
                        if (state.getHandleState() != HandleState.Selection) {
                            TextLayoutResultProxy layoutResult = state.getLayoutResult();
                            if (layoutResult != null) {
                                LegacyTextFieldState legacyTextFieldState = state;
                                TextFieldDelegate.INSTANCE.m1243setCursorOffsetULxng0E$foundation_release(offset, layoutResult, legacyTextFieldState.getProcessor(), offsetMapping, legacyTextFieldState.getOnValueChange());
                                if (legacyTextFieldState.getTextDelegate().getText().length() > 0) {
                                    legacyTextFieldState.setHandleState(HandleState.Cursor);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        manager.m1535deselect_kEHs6E$foundation_release(Offset.m4038boximpl(offset));
                    }
                }
            };
            $composer3.updateRememberedValue(value$iv11);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierPointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(modifierUpdateSelectionTouchMode2, interactionSource5, enabled4, (Function1) value$iv11), manager.getMouseSelectionObserver(), manager.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            $composer3.startReplaceGroup(-55004680);
            ComposerKt.sourceInformation($composer3, "407@19644L963");
            if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
                Modifier.Companion companion10 = Modifier.INSTANCE;
                Boolean boolValueOf3 = Boolean.valueOf(enabled4);
                Boolean boolValueOf4 = Boolean.valueOf(readOnly2);
                ComposerKt.sourceInformationMarkerStart($composer3, -55004587, "CC(remember):CoreTextField.kt#9igjgp");
                if (($dirty1 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (($dirty1 & 57344) == 16384) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean zChangedInstance11 = z16 | z15 | $composer3.changedInstance(state);
                legacyTextInputServiceAdapter = legacyTextInputServiceAdapter2;
                invalid$iv10 = zChangedInstance11 | $composer3.changedInstance(legacyTextInputServiceAdapter);
                Object it$iv111 = $composer3.rememberedValue();
                if (invalid$iv10) {
                }
                value$iv17 = new CoreTextFieldKt$CoreTextField$pointerModifier$3$1(enabled4, readOnly2, state, focusRequester, legacyTextInputServiceAdapter, null);
                $composer3.updateRememberedValue(value$iv17);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                companionPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion10, boolValueOf3, boolValueOf4, (Function2) value$iv17);
            } else {
                legacyTextInputServiceAdapter = legacyTextInputServiceAdapter2;
                companionPointerInput = Modifier.INSTANCE;
            }
            $composer3.endReplaceGroup();
            Modifier pointerModifier2 = modifierPointerHoverIcon$default2.then(companionPointerInput);
            Modifier.Companion companion11 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -55003509, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance12 = $composer3.changedInstance(state);
            if (($dirty & 14) == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            invalid$iv5 = zChangedInstance12 | z4 | $composer3.changedInstance(offsetMapping);
            Object it$iv112 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            value$iv12 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope $this$drawBehind) {
                    TextLayoutResultProxy layoutResult = state.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    TextFieldValue textFieldValue = value;
                    OffsetMapping offsetMapping2 = offsetMapping;
                    LegacyTextFieldState legacyTextFieldState = state;
                    Canvas canvas = $this$drawBehind.getDrawContext().getCanvas();
                    TextFieldDelegate.INSTANCE.draw$foundation_release(canvas, textFieldValue, offsetMapping2, layoutResult.getValue(), legacyTextFieldState.getSelectionPaint());
                }
            };
            $composer3.updateRememberedValue(value$iv12);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Modifier drawModifier2 = DrawModifierKt.drawBehind(companion11, (Function1) value$iv12);
            Modifier.Companion companion12 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -55003097, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance13 = $composer3.changedInstance(state);
            if (($dirty1 & 7168) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean zChanged3 = zChangedInstance13 | z5 | $composer3.changed(windowInfo) | $composer3.changedInstance(manager);
            if (($dirty & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            invalid$iv6 = zChanged3 | z6 | $composer3.changedInstance(offsetMapping);
            Object it$iv113 = $composer3.rememberedValue();
            if (invalid$iv6) {
            }
            value$iv13 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
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
                public final void invoke2(LayoutCoordinates it2) {
                    state.setLayoutCoordinates(it2);
                    TextLayoutResultProxy layoutResult = state.getLayoutResult();
                    if (layoutResult != null) {
                        layoutResult.setInnerTextFieldCoordinates(it2);
                    }
                    if (enabled4) {
                        if (state.getHandleState() == HandleState.Selection) {
                            if (state.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                manager.showSelectionToolbar$foundation_release();
                            } else {
                                manager.hideSelectionToolbar$foundation_release();
                            }
                            state.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, true));
                            state.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, false));
                            state.setShowCursorHandle(TextRange.m6245getCollapsedimpl(value.getSelection()));
                        } else if (state.getHandleState() == HandleState.Cursor) {
                            state.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(manager, true));
                        }
                        CoreTextFieldKt.notifyFocusedRect(state, value, offsetMapping);
                        TextLayoutResultProxy layoutResult2 = state.getLayoutResult();
                        if (layoutResult2 != null) {
                            LegacyTextFieldState legacyTextFieldState = state;
                            TextFieldValue textFieldValue = value;
                            OffsetMapping offsetMapping2 = offsetMapping;
                            TextInputSession inputSession = legacyTextFieldState.getInputSession();
                            if (inputSession != null && legacyTextFieldState.getHasFocus()) {
                                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue, offsetMapping2, layoutResult2);
                            }
                        }
                    }
                }
            };
            $composer3.updateRememberedValue(value$iv13);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Modifier onPositionedModifier2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion12, (Function1) value$iv13);
            final boolean isPassword2 = visualTransformation5 instanceof PasswordVisualTransformation;
            Modifier.Companion companion13 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -55001495, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance14 = $composer3.changedInstance(transformedText);
            if (($dirty & 14) == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean z27 = zChangedInstance14 | z7;
            if (($dirty1 & 7168) == 2048) {
                z8 = true;
            } else {
                z8 = false;
            }
            boolean zChanged4 = z27 | z8 | $composer3.changed(isPassword2);
            if ((57344 & $dirty1) == 16384) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean zChangedInstance15 = zChanged4 | z9 | $composer3.changedInstance(state) | $composer3.changedInstance(offsetMapping) | $composer3.changedInstance(manager);
            if ((($dirty1 & 112) ^ 48) > 32) {
                imeOptions5 = imeOptions4;
                if (!$composer3.changed(imeOptions5)) {
                    z10 = true;
                }
                invalid$iv7 = zChangedInstance15 | z10;
                Object it$iv114 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                final boolean z28 = readOnly2;
                final ImeOptions imeOptions11 = imeOptions5;
                value$iv14 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
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
                    public final void invoke2(final SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setEditableText($this$semantics, transformedText.getText());
                        SemanticsPropertiesKt.m6080setTextSelectionRangeFDrldGo($this$semantics, value.getSelection());
                        if (!enabled4) {
                            SemanticsPropertiesKt.disabled($this$semantics);
                        }
                        if (isPassword2) {
                            SemanticsPropertiesKt.password($this$semantics);
                        }
                        if (enabled4 && !z28) {
                            SemanticsPropertiesKt.editable($this$semantics);
                        }
                        final LegacyTextFieldState legacyTextFieldState = state;
                        SemanticsPropertiesKt.getTextLayoutResult$default($this$semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(List<TextLayoutResult> list) {
                                boolean z29;
                                if (legacyTextFieldState.getLayoutResult() != null) {
                                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                                    Intrinsics.checkNotNull(layoutResult);
                                    list.add(layoutResult.getValue());
                                    z29 = true;
                                } else {
                                    z29 = false;
                                }
                                return Boolean.valueOf(z29);
                            }
                        }, 1, null);
                        final boolean z29 = z28;
                        final boolean z210 = enabled4;
                        final LegacyTextFieldState legacyTextFieldState2 = state;
                        SemanticsPropertiesKt.setText$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString text) {
                                Unit unit3;
                                if (z29 || !z210) {
                                    return false;
                                }
                                TextInputSession session = legacyTextFieldState2.getInputSession();
                                if (session != null) {
                                    LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState2;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState3.getProcessor(), legacyTextFieldState3.getOnValueChange(), session);
                                    unit3 = Unit.INSTANCE;
                                } else {
                                    unit3 = null;
                                }
                                if (unit3 == null) {
                                    SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                    legacyTextFieldState2.getOnValueChange().invoke(new TextFieldValue(text.getText(), TextRangeKt.TextRange(text.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return true;
                            }
                        }, 1, null);
                        final boolean z211 = z28;
                        final boolean z212 = enabled4;
                        final LegacyTextFieldState legacyTextFieldState3 = state;
                        final TextFieldValue textFieldValue = value;
                        SemanticsPropertiesKt.insertTextAtCursor$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString text) {
                                Unit unit3;
                                if (z211 || !z212) {
                                    return false;
                                }
                                TextInputSession session = legacyTextFieldState3.getInputSession();
                                if (session != null) {
                                    LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), session);
                                    unit3 = Unit.INSTANCE;
                                } else {
                                    unit3 = null;
                                }
                                if (unit3 == null) {
                                    SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState3;
                                    String newText = StringsKt.replaceRange((CharSequence) textFieldValue2.getText(), TextRange.m6251getStartimpl(textFieldValue2.getSelection()), TextRange.m6246getEndimpl(textFieldValue2.getSelection()), (CharSequence) text).toString();
                                    long newCursor = TextRangeKt.TextRange(TextRange.m6251getStartimpl(textFieldValue2.getSelection()) + text.length());
                                    legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(newText, newCursor, (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return true;
                            }
                        }, 1, null);
                        final OffsetMapping offsetMapping2 = offsetMapping;
                        final boolean z213 = enabled4;
                        final TextFieldValue textFieldValue2 = value;
                        final TextFieldSelectionManager textFieldSelectionManager = manager;
                        final LegacyTextFieldState legacyTextFieldState4 = state;
                        SemanticsPropertiesKt.setSelection$default($this$semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                            }

                            public final Boolean invoke(int selectionStart, int selectionEnd, boolean relativeToOriginalText) {
                                int start;
                                int end;
                                if (relativeToOriginalText) {
                                    start = selectionStart;
                                } else {
                                    start = offsetMapping2.transformedToOriginal(selectionStart);
                                }
                                if (relativeToOriginalText) {
                                    end = selectionEnd;
                                } else {
                                    end = offsetMapping2.transformedToOriginal(selectionEnd);
                                }
                                boolean z214 = false;
                                if (z213 && (start != TextRange.m6251getStartimpl(textFieldValue2.getSelection()) || end != TextRange.m6246getEndimpl(textFieldValue2.getSelection()))) {
                                    if (Math.min(start, end) >= 0 && Math.max(start, end) <= textFieldValue2.getText().length()) {
                                        if (!relativeToOriginalText && start != end) {
                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager, false, 1, null);
                                        } else {
                                            textFieldSelectionManager.exitSelectionMode$foundation_release();
                                        }
                                        legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(textFieldValue2.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        z214 = true;
                                    } else {
                                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                                    }
                                }
                                return Boolean.valueOf(z214);
                            }
                        }, 1, null);
                        int imeAction = imeOptions11.getImeAction();
                        final LegacyTextFieldState legacyTextFieldState5 = state;
                        final ImeOptions imeOptions12 = imeOptions11;
                        SemanticsPropertiesKt.m6076onImeAction9UiTYpY$default($this$semantics, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                legacyTextFieldState5.getOnImeActionPerformed().invoke(ImeAction.m6416boximpl(imeOptions12.getImeAction()));
                                return true;
                            }
                        }, 2, null);
                        final LegacyTextFieldState legacyTextFieldState6 = state;
                        final FocusRequester focusRequester2 = focusRequester;
                        final boolean z214 = z28;
                        SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                CoreTextFieldKt.tapToFocus(legacyTextFieldState6, focusRequester2, !z214);
                                return true;
                            }
                        }, 1, null);
                        final TextFieldSelectionManager textFieldSelectionManager2 = manager;
                        SemanticsPropertiesKt.onLongClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                return true;
                            }
                        }, 1, null);
                        if (!TextRange.m6245getCollapsedimpl(value.getSelection()) && !isPassword2) {
                            final TextFieldSelectionManager textFieldSelectionManager3 = manager;
                            SemanticsPropertiesKt.copyText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager3, false, 1, null);
                                    return true;
                                }
                            }, 1, null);
                            if (enabled4 && !z28) {
                                final TextFieldSelectionManager textFieldSelectionManager4 = manager;
                                SemanticsPropertiesKt.cutText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        textFieldSelectionManager4.cut$foundation_release();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                        if (enabled4 && !z28) {
                            final TextFieldSelectionManager textFieldSelectionManager5 = manager;
                            SemanticsPropertiesKt.pasteText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    textFieldSelectionManager5.paste$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv14);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier semanticsModifier3 = SemanticsModifierKt.semantics(companion13, true, (Function1) value$iv14);
                if (enabled4) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                boolean showCursor3 = z11;
                final Modifier cursorModifier3 = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping, cursorBrush2, showCursor3);
                ComposerKt.sourceInformationMarkerStart($composer3, -54995719, "CC(remember):CoreTextField.kt#9igjgp");
                invalid$iv8 = $composer3.changedInstance(manager);
                Object it$iv115 = $composer3.rememberedValue();
                if (invalid$iv8) {
                }
                value$iv15 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final TextFieldSelectionManager textFieldSelectionManager = manager;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        };
                    }
                };
                $composer3.updateRememberedValue(value$iv15);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.DisposableEffect(manager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv15, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, -54995624, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance16 = $composer3.changedInstance(state) | $composer3.changedInstance(textInputService);
                if (($dirty & 14) == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                invalid$iv9 = zChangedInstance16 | z12 | (((($dirty1 & 112) ^ 48) <= 32 && $composer3.changed(imeOptions5)) || ($dirty1 & 48) == 32);
                Object it$iv116 = $composer3.rememberedValue();
                if (invalid$iv9) {
                }
                value$iv16 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        if (state.getHasFocus()) {
                            state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, value, state.getProcessor(), imeOptions5, state.getOnValueChange(), state.getOnImeActionPerformed()));
                        }
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                $composer3.updateRememberedValue(value$iv16);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv16, $composer3, ($dirty1 >> 3) & 14);
                Modifier.Companion companion14 = Modifier.INSTANCE;
                Function1<TextFieldValue, Unit> onValueChange3 = state.getOnValueChange();
                boolean z29 = !readOnly2;
                if (maxLines5 == 1) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = false;
                imeOptions6 = imeOptions5;
                Modifier textKeyInputModifier3 = TextFieldKeyInputKt.m1250textFieldKeyInput2WJ9YEU(companion14, state, manager, value, onValueChange3, z29, z13, offsetMapping, undoManager, imeOptions5.getImeAction());
                final TextFieldScrollerPosition scrollerPosition5 = scrollerPosition;
                Modifier decorationBoxModifier3 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5, legacyTextInputServiceAdapter).then(focusModifier2), state, focusManager), state, manager).then(textKeyInputModifier3), scrollerPosition5, interactionSource5, enabled4).then(pointerModifier2).then(semanticsModifier3), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it2) {
                        TextLayoutResultProxy layoutResult = state.getLayoutResult();
                        if (layoutResult == null) {
                            return;
                        }
                        layoutResult.setDecorationBoxCoordinates(it2);
                    }
                });
                if (enabled4) {
                    z14 = true;
                }
                showHandleAndMagnifier = z14;
                if (showHandleAndMagnifier) {
                    companionTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, manager);
                } else {
                    companionTextFieldMagnifier = Modifier.INSTANCE;
                }
                maxLines3 = maxLines5;
                final Modifier magnifierModifier3 = companionTextFieldMagnifier;
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function9 = function3M1172getLambda1$foundation_release;
                final TextStyle textStyle6 = textStyle2;
                final int i17 = minLines2;
                enabled5 = enabled4;
                interactionSource3 = interactionSource5;
                visualTransformation3 = visualTransformation5;
                modifier3 = modifier5;
                final boolean z210 = readOnly2;
                final Function1<? super TextLayoutResult, Unit> function10 = function4;
                $composer2 = $composer3;
                CoreTextFieldRootBox(decorationBoxModifier3, manager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5
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
                        ComposerKt.sourceInformation($composer4, "C673@30498L4735,673@30484L4749:CoreTextField.kt#423gt5");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-374338080, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:673)");
                            }
                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function11 = function9;
                            final LegacyTextFieldState legacyTextFieldState = state;
                            final TextStyle textStyle7 = textStyle6;
                            final int i18 = i17;
                            final int i19 = maxLines3;
                            final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition5;
                            final TextFieldValue textFieldValue = value;
                            final VisualTransformation visualTransformation6 = visualTransformation5;
                            final Modifier modifier6 = cursorModifier3;
                            final Modifier modifier7 = drawModifier2;
                            final Modifier modifier8 = onPositionedModifier2;
                            final Modifier modifier9 = magnifierModifier3;
                            final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                            final TextFieldSelectionManager textFieldSelectionManager = manager;
                            final boolean z211 = showHandleAndMagnifier;
                            final boolean z212 = z210;
                            final Function1<? super TextLayoutResult, Unit> function12 = function10;
                            final OffsetMapping offsetMapping2 = offsetMapping;
                            final Density density2 = density;
                            function11.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1
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
                                    Object value$iv20;
                                    ComposerKt.sourceInformation($composer5, "C689@31352L22,698@31711L3512,698@31675L3548:CoreTextField.kt#423gt5");
                                    if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2032502107, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:676)");
                                        }
                                        Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m901heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState.m1197getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle7, i18, i19);
                                        TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                        TextFieldValue textFieldValue2 = textFieldValue;
                                        VisualTransformation visualTransformation7 = visualTransformation6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -531185709, "CC(remember):CoreTextField.kt#9igjgp");
                                        boolean invalid$iv14 = $composer5.changedInstance(legacyTextFieldState);
                                        final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                        Object it$iv117 = $composer5.rememberedValue();
                                        if (invalid$iv14 || it$iv117 == Composer.INSTANCE.getEmpty()) {
                                            value$iv20 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final TextLayoutResultProxy invoke() {
                                                    return legacyTextFieldState2.getLayoutResult();
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv20);
                                        } else {
                                            value$iv20 = it$iv117;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, (Function0) value$iv20).then(modifier6).then(modifier7), textStyle7).then(modifier8).then(modifier9), bringIntoViewRequester2);
                                        final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                        final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                        final boolean z213 = z211;
                                        final boolean z214 = z212;
                                        final Function1<? super TextLayoutResult, Unit> function13 = function12;
                                        final TextFieldValue textFieldValue3 = textFieldValue;
                                        final OffsetMapping offsetMapping3 = offsetMapping2;
                                        final Density density3 = density2;
                                        final int i110 = i19;
                                        SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                            /* JADX WARN: Code duplicated, block: B:35:0x0131  */
                                            public final void invoke(Composer $composer6, int $changed4) {
                                                boolean z215;
                                                ComposerKt.sourceInformation($composer6, "C699@31729L2880,754@34627L322,767@35151L40:CoreTextField.kt#423gt5");
                                                if (($changed4 & 3) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-363167407, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:699)");
                                                    }
                                                    final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                                    final Function1<? super TextLayoutResult, Unit> function14 = function13;
                                                    final TextFieldValue textFieldValue4 = textFieldValue3;
                                                    final OffsetMapping offsetMapping4 = offsetMapping3;
                                                    final Density density4 = density3;
                                                    final int i111 = i110;
                                                    MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                            return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                            return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                            return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i20);
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        /* JADX INFO: renamed from: measure-3p2s80s */
                                                        public MeasureResult mo285measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
                                                            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                            LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                            Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
                                                            Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
                                                            Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
                                                            try {
                                                                TextLayoutResultProxy prevProxy = legacyTextFieldState5.getLayoutResult();
                                                                this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                                TextLayoutResult prevResult = prevProxy != null ? prevProxy.getValue() : null;
                                                                Triple<Integer, Integer, TextLayoutResult> tripleM1242layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1242layout_EkL_Y$foundation_release(legacyTextFieldState4.getTextDelegate(), constraints, $this$measure_u2d3p2s80s.getLayoutDirection(), prevResult);
                                                                int width = tripleM1242layout_EkL_Y$foundation_release.component1().intValue();
                                                                int height = tripleM1242layout_EkL_Y$foundation_release.component2().intValue();
                                                                TextLayoutResult result = tripleM1242layout_EkL_Y$foundation_release.component3();
                                                                if (!Intrinsics.areEqual(prevResult, result)) {
                                                                    legacyTextFieldState4.setLayoutResult(new TextLayoutResultProxy(result, null, prevProxy != null ? prevProxy.getDecorationBoxCoordinates() : null, 2, null));
                                                                    function14.invoke(result);
                                                                    CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState4, textFieldValue4, offsetMapping4);
                                                                }
                                                                LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState4;
                                                                Density $this$measure_3p2s80s_u24lambda_u241 = density4;
                                                                legacyTextFieldState6.m1198setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u241.mo564toDpu2uoSUM(i111 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                                HorizontalAlignmentLine firstBaseline = AlignmentLineKt.getFirstBaseline();
                                                                float $this$fastRoundToInt$iv = result.getFirstBaseline();
                                                                HorizontalAlignmentLine lastBaseline = AlignmentLineKt.getLastBaseline();
                                                                float $this$fastRoundToInt$iv2 = result.getLastBaseline();
                                                                return $this$measure_u2d3p2s80s.layout(width, height, MapsKt.mapOf(TuplesKt.m202to(firstBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv))), TuplesKt.m202to(lastBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv2)))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                        invoke2(placementScope);
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                                                                    }
                                                                });
                                                            } catch (Throwable th) {
                                                                this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                                throw th;
                                                            }
                                                        }

                                                        @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                        public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                                                            legacyTextFieldState4.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                            return legacyTextFieldState4.getTextDelegate().getMaxIntrinsicWidth();
                                                        }
                                                    };
                                                    ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    Modifier modifier$iv = Modifier.INSTANCE;
                                                    int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                    CompositionLocalMap localMap$iv = $composer6.getCurrentCompositionLocalMap();
                                                    Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    int $changed$iv$iv = ((0 << 6) & 896) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                    if (!($composer6.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer6.startReusableNode();
                                                    if ($composer6.getInserting()) {
                                                        $composer6.createNode(constructor);
                                                    } else {
                                                        $composer6.useNode();
                                                    }
                                                    Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer6);
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                                                        $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                                                        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
                                                    }
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                    int i20 = ($changed$iv$iv >> 6) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, 1017248566, "C:CoreTextField.kt#423gt5");
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    $composer6.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                    if (legacyTextFieldState3.getHandleState() == HandleState.None || legacyTextFieldState3.getLayoutCoordinates() == null) {
                                                        z215 = false;
                                                    } else {
                                                        LayoutCoordinates layoutCoordinates = legacyTextFieldState3.getLayoutCoordinates();
                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                        if (layoutCoordinates.isAttached() && z213) {
                                                            z215 = true;
                                                        } else {
                                                            z215 = false;
                                                        }
                                                    }
                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z215, $composer6, 0);
                                                    if (legacyTextFieldState3.getHandleState() == HandleState.Cursor && !z214 && z213) {
                                                        CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager2, $composer6, 0);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer6.skipToGroupEnd();
                                            }
                                        }, $composer5, 54), $composer5, 48, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54), $composer4, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                imeOptions5 = imeOptions4;
            }
            if (($dirty1 & 48) == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
            invalid$iv7 = zChangedInstance15 | z10;
            Object it$iv117 = $composer3.rememberedValue();
            if (invalid$iv7) {
            }
            final boolean z211 = readOnly2;
            final ImeOptions imeOptions12 = imeOptions5;
            value$iv14 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
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
                public final void invoke2(final SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.setEditableText($this$semantics, transformedText.getText());
                    SemanticsPropertiesKt.m6080setTextSelectionRangeFDrldGo($this$semantics, value.getSelection());
                    if (!enabled4) {
                        SemanticsPropertiesKt.disabled($this$semantics);
                    }
                    if (isPassword2) {
                        SemanticsPropertiesKt.password($this$semantics);
                    }
                    if (enabled4 && !z211) {
                        SemanticsPropertiesKt.editable($this$semantics);
                    }
                    final LegacyTextFieldState legacyTextFieldState = state;
                    SemanticsPropertiesKt.getTextLayoutResult$default($this$semantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(List<TextLayoutResult> list) {
                            boolean z212;
                            if (legacyTextFieldState.getLayoutResult() != null) {
                                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                                Intrinsics.checkNotNull(layoutResult);
                                list.add(layoutResult.getValue());
                                z212 = true;
                            } else {
                                z212 = false;
                            }
                            return Boolean.valueOf(z212);
                        }
                    }, 1, null);
                    final boolean z212 = z211;
                    final boolean z213 = enabled4;
                    final LegacyTextFieldState legacyTextFieldState2 = state;
                    SemanticsPropertiesKt.setText$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(AnnotatedString text) {
                            Unit unit3;
                            if (z212 || !z213) {
                                return false;
                            }
                            TextInputSession session = legacyTextFieldState2.getInputSession();
                            if (session != null) {
                                LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState2;
                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState3.getProcessor(), legacyTextFieldState3.getOnValueChange(), session);
                                unit3 = Unit.INSTANCE;
                            } else {
                                unit3 = null;
                            }
                            if (unit3 == null) {
                                SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                legacyTextFieldState2.getOnValueChange().invoke(new TextFieldValue(text.getText(), TextRangeKt.TextRange(text.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                            }
                            return true;
                        }
                    }, 1, null);
                    final boolean z214 = z211;
                    final boolean z215 = enabled4;
                    final LegacyTextFieldState legacyTextFieldState3 = state;
                    final TextFieldValue textFieldValue = value;
                    SemanticsPropertiesKt.insertTextAtCursor$default($this$semantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(AnnotatedString text) {
                            Unit unit3;
                            if (z214 || !z215) {
                                return false;
                            }
                            TextInputSession session = legacyTextFieldState3.getInputSession();
                            if (session != null) {
                                LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(text, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), session);
                                unit3 = Unit.INSTANCE;
                            } else {
                                unit3 = null;
                            }
                            if (unit3 == null) {
                                SemanticsPropertyReceiver semanticsPropertyReceiver = $this$semantics;
                                TextFieldValue textFieldValue2 = textFieldValue;
                                LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState3;
                                String newText = StringsKt.replaceRange((CharSequence) textFieldValue2.getText(), TextRange.m6251getStartimpl(textFieldValue2.getSelection()), TextRange.m6246getEndimpl(textFieldValue2.getSelection()), (CharSequence) text).toString();
                                long newCursor = TextRangeKt.TextRange(TextRange.m6251getStartimpl(textFieldValue2.getSelection()) + text.length());
                                legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(newText, newCursor, (TextRange) null, 4, (DefaultConstructorMarker) null));
                            }
                            return true;
                        }
                    }, 1, null);
                    final OffsetMapping offsetMapping2 = offsetMapping;
                    final boolean z216 = enabled4;
                    final TextFieldValue textFieldValue2 = value;
                    final TextFieldSelectionManager textFieldSelectionManager = manager;
                    final LegacyTextFieldState legacyTextFieldState4 = state;
                    SemanticsPropertiesKt.setSelection$default($this$semantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                            return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                        }

                        public final Boolean invoke(int selectionStart, int selectionEnd, boolean relativeToOriginalText) {
                            int start;
                            int end;
                            if (relativeToOriginalText) {
                                start = selectionStart;
                            } else {
                                start = offsetMapping2.transformedToOriginal(selectionStart);
                            }
                            if (relativeToOriginalText) {
                                end = selectionEnd;
                            } else {
                                end = offsetMapping2.transformedToOriginal(selectionEnd);
                            }
                            boolean z217 = false;
                            if (z216 && (start != TextRange.m6251getStartimpl(textFieldValue2.getSelection()) || end != TextRange.m6246getEndimpl(textFieldValue2.getSelection()))) {
                                if (Math.min(start, end) >= 0 && Math.max(start, end) <= textFieldValue2.getText().length()) {
                                    if (!relativeToOriginalText && start != end) {
                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager, false, 1, null);
                                    } else {
                                        textFieldSelectionManager.exitSelectionMode$foundation_release();
                                    }
                                    legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(textFieldValue2.getText(), TextRangeKt.TextRange(start, end), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    z217 = true;
                                } else {
                                    textFieldSelectionManager.exitSelectionMode$foundation_release();
                                }
                            }
                            return Boolean.valueOf(z217);
                        }
                    }, 1, null);
                    int imeAction = imeOptions12.getImeAction();
                    final LegacyTextFieldState legacyTextFieldState5 = state;
                    final ImeOptions imeOptions13 = imeOptions12;
                    SemanticsPropertiesKt.m6076onImeAction9UiTYpY$default($this$semantics, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            legacyTextFieldState5.getOnImeActionPerformed().invoke(ImeAction.m6416boximpl(imeOptions13.getImeAction()));
                            return true;
                        }
                    }, 2, null);
                    final LegacyTextFieldState legacyTextFieldState6 = state;
                    final FocusRequester focusRequester2 = focusRequester;
                    final boolean z217 = z211;
                    SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            CoreTextFieldKt.tapToFocus(legacyTextFieldState6, focusRequester2, !z217);
                            return true;
                        }
                    }, 1, null);
                    final TextFieldSelectionManager textFieldSelectionManager2 = manager;
                    SemanticsPropertiesKt.onLongClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                            return true;
                        }
                    }, 1, null);
                    if (!TextRange.m6245getCollapsedimpl(value.getSelection()) && !isPassword2) {
                        final TextFieldSelectionManager textFieldSelectionManager3 = manager;
                        SemanticsPropertiesKt.copyText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.copy$foundation_release$default(textFieldSelectionManager3, false, 1, null);
                                return true;
                            }
                        }, 1, null);
                        if (enabled4 && !z211) {
                            final TextFieldSelectionManager textFieldSelectionManager4 = manager;
                            SemanticsPropertiesKt.cutText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    textFieldSelectionManager4.cut$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                    if (enabled4 && !z211) {
                        final TextFieldSelectionManager textFieldSelectionManager5 = manager;
                        SemanticsPropertiesKt.pasteText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                textFieldSelectionManager5.paste$foundation_release();
                                return true;
                            }
                        }, 1, null);
                    }
                }
            };
            $composer3.updateRememberedValue(value$iv14);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier semanticsModifier4 = SemanticsModifierKt.semantics(companion13, true, (Function1) value$iv14);
            if (enabled4) {
                z11 = false;
            } else {
                z11 = false;
            }
            boolean showCursor4 = z11;
            final Modifier cursorModifier4 = TextFieldCursorKt.cursor(Modifier.INSTANCE, state, value, offsetMapping, cursorBrush2, showCursor4);
            ComposerKt.sourceInformationMarkerStart($composer3, -54995719, "CC(remember):CoreTextField.kt#9igjgp");
            invalid$iv8 = $composer3.changedInstance(manager);
            Object it$iv118 = $composer3.rememberedValue();
            if (invalid$iv8) {
            }
            value$iv15 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    final TextFieldSelectionManager textFieldSelectionManager = manager;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    };
                }
            };
            $composer3.updateRememberedValue(value$iv15);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(manager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv15, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -54995624, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance17 = $composer3.changedInstance(state) | $composer3.changedInstance(textInputService);
            if (($dirty & 14) == 4) {
                z12 = true;
            } else {
                z12 = false;
            }
            invalid$iv9 = zChangedInstance17 | z12 | (((($dirty1 & 112) ^ 48) <= 32 && $composer3.changed(imeOptions5)) || ($dirty1 & 48) == 32);
            Object it$iv119 = $composer3.rememberedValue();
            if (invalid$iv9) {
            }
            value$iv16 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    if (state.getHasFocus()) {
                        state.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, value, state.getProcessor(), imeOptions5, state.getOnValueChange(), state.getOnImeActionPerformed()));
                    }
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            };
            $composer3.updateRememberedValue(value$iv16);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv16, $composer3, ($dirty1 >> 3) & 14);
            Modifier.Companion companion15 = Modifier.INSTANCE;
            Function1<TextFieldValue, Unit> onValueChange4 = state.getOnValueChange();
            boolean z212 = !readOnly2;
            if (maxLines5 == 1) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = false;
            imeOptions6 = imeOptions5;
            Modifier textKeyInputModifier4 = TextFieldKeyInputKt.m1250textFieldKeyInput2WJ9YEU(companion15, state, manager, value, onValueChange4, z212, z13, offsetMapping, undoManager, imeOptions5.getImeAction());
            final TextFieldScrollerPosition scrollerPosition6 = scrollerPosition;
            Modifier decorationBoxModifier4 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5, legacyTextInputServiceAdapter).then(focusModifier2), state, focusManager), state, manager).then(textKeyInputModifier4), scrollerPosition6, interactionSource5, enabled4).then(pointerModifier2).then(semanticsModifier4), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates it2) {
                    TextLayoutResultProxy layoutResult = state.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    layoutResult.setDecorationBoxCoordinates(it2);
                }
            });
            if (enabled4) {
                z14 = true;
            }
            showHandleAndMagnifier = z14;
            if (showHandleAndMagnifier) {
                companionTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, manager);
            } else {
                companionTextFieldMagnifier = Modifier.INSTANCE;
            }
            maxLines3 = maxLines5;
            final Modifier magnifierModifier4 = companionTextFieldMagnifier;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function11 = function3M1172getLambda1$foundation_release;
            final TextStyle textStyle7 = textStyle2;
            final int i18 = minLines2;
            enabled5 = enabled4;
            interactionSource3 = interactionSource5;
            visualTransformation3 = visualTransformation5;
            modifier3 = modifier5;
            final boolean z213 = readOnly2;
            final Function1<? super TextLayoutResult, Unit> function12 = function4;
            $composer2 = $composer3;
            CoreTextFieldRootBox(decorationBoxModifier4, manager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5
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
                    ComposerKt.sourceInformation($composer4, "C673@30498L4735,673@30484L4749:CoreTextField.kt#423gt5");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-374338080, $changed2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:673)");
                        }
                        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function13 = function11;
                        final LegacyTextFieldState legacyTextFieldState = state;
                        final TextStyle textStyle8 = textStyle7;
                        final int i19 = i18;
                        final int i110 = maxLines3;
                        final TextFieldScrollerPosition textFieldScrollerPosition = scrollerPosition6;
                        final TextFieldValue textFieldValue = value;
                        final VisualTransformation visualTransformation6 = visualTransformation5;
                        final Modifier modifier6 = cursorModifier4;
                        final Modifier modifier7 = drawModifier2;
                        final Modifier modifier8 = onPositionedModifier2;
                        final Modifier modifier9 = magnifierModifier4;
                        final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                        final TextFieldSelectionManager textFieldSelectionManager = manager;
                        final boolean z214 = showHandleAndMagnifier;
                        final boolean z215 = z213;
                        final Function1<? super TextLayoutResult, Unit> function14 = function12;
                        final OffsetMapping offsetMapping2 = offsetMapping;
                        final Density density2 = density;
                        function13.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1
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
                                Object value$iv20;
                                ComposerKt.sourceInformation($composer5, "C689@31352L22,698@31711L3512,698@31675L3548:CoreTextField.kt#423gt5");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2032502107, $changed3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:676)");
                                    }
                                    Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m901heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState.m1197getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle8, i19, i110);
                                    TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    VisualTransformation visualTransformation7 = visualTransformation6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -531185709, "CC(remember):CoreTextField.kt#9igjgp");
                                    boolean invalid$iv14 = $composer5.changedInstance(legacyTextFieldState);
                                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                    Object it$iv1110 = $composer5.rememberedValue();
                                    if (invalid$iv14 || it$iv1110 == Composer.INSTANCE.getEmpty()) {
                                        value$iv20 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final TextLayoutResultProxy invoke() {
                                                return legacyTextFieldState2.getLayoutResult();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv20);
                                    } else {
                                        value$iv20 = it$iv1110;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    Modifier coreTextFieldModifier = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition2, textFieldValue2, visualTransformation7, (Function0) value$iv20).then(modifier6).then(modifier7), textStyle8).then(modifier8).then(modifier9), bringIntoViewRequester2);
                                    final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                    final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                    final boolean z216 = z214;
                                    final boolean z217 = z215;
                                    final Function1<? super TextLayoutResult, Unit> function15 = function14;
                                    final TextFieldValue textFieldValue3 = textFieldValue;
                                    final OffsetMapping offsetMapping3 = offsetMapping2;
                                    final Density density3 = density2;
                                    final int i111 = i110;
                                    SimpleLayoutKt.SimpleLayout(coreTextFieldModifier, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
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

                                        /* JADX WARN: Code duplicated, block: B:35:0x0131  */
                                        public final void invoke(Composer $composer6, int $changed4) {
                                            boolean z218;
                                            ComposerKt.sourceInformation($composer6, "C699@31729L2880,754@34627L322,767@35151L40:CoreTextField.kt#423gt5");
                                            if (($changed4 & 3) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-363167407, $changed4, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:699)");
                                                }
                                                final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState3;
                                                final Function1<? super TextLayoutResult, Unit> function16 = function15;
                                                final TextFieldValue textFieldValue4 = textFieldValue3;
                                                final OffsetMapping offsetMapping4 = offsetMapping3;
                                                final Density density4 = density3;
                                                final int i112 = i111;
                                                MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                    }

                                                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i20);
                                                    }

                                                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i20) {
                                                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i20);
                                                    }

                                                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                    /* JADX INFO: renamed from: measure-3p2s80s */
                                                    public MeasureResult mo285measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
                                                        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                                                        LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                        Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
                                                        Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
                                                        Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
                                                        try {
                                                            TextLayoutResultProxy prevProxy = legacyTextFieldState5.getLayoutResult();
                                                            this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                            TextLayoutResult prevResult = prevProxy != null ? prevProxy.getValue() : null;
                                                            Triple<Integer, Integer, TextLayoutResult> tripleM1242layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1242layout_EkL_Y$foundation_release(legacyTextFieldState4.getTextDelegate(), constraints, $this$measure_u2d3p2s80s.getLayoutDirection(), prevResult);
                                                            int width = tripleM1242layout_EkL_Y$foundation_release.component1().intValue();
                                                            int height = tripleM1242layout_EkL_Y$foundation_release.component2().intValue();
                                                            TextLayoutResult result = tripleM1242layout_EkL_Y$foundation_release.component3();
                                                            if (!Intrinsics.areEqual(prevResult, result)) {
                                                                legacyTextFieldState4.setLayoutResult(new TextLayoutResultProxy(result, null, prevProxy != null ? prevProxy.getDecorationBoxCoordinates() : null, 2, null));
                                                                function16.invoke(result);
                                                                CoreTextFieldKt.notifyFocusedRect(legacyTextFieldState4, textFieldValue4, offsetMapping4);
                                                            }
                                                            LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState4;
                                                            Density $this$measure_3p2s80s_u24lambda_u241 = density4;
                                                            legacyTextFieldState6.m1198setMinHeightForSingleLineField0680j_4($this$measure_3p2s80s_u24lambda_u241.mo564toDpu2uoSUM(i112 == 1 ? TextDelegateKt.ceilToIntPx(result.getLineBottom(0)) : 0));
                                                            HorizontalAlignmentLine firstBaseline = AlignmentLineKt.getFirstBaseline();
                                                            float $this$fastRoundToInt$iv = result.getFirstBaseline();
                                                            HorizontalAlignmentLine lastBaseline = AlignmentLineKt.getLastBaseline();
                                                            float $this$fastRoundToInt$iv2 = result.getLastBaseline();
                                                            return $this$measure_u2d3p2s80s.layout(width, height, MapsKt.mapOf(TuplesKt.m202to(firstBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv))), TuplesKt.m202to(lastBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv2)))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                    invoke2(placementScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(Placeable.PlacementScope $this$layout) {
                                                                }
                                                            });
                                                        } catch (Throwable th) {
                                                            this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                                            throw th;
                                                        }
                                                    }

                                                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                                                    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                                                        legacyTextFieldState4.getTextDelegate().layoutIntrinsics($this$maxIntrinsicWidth.getLayoutDirection());
                                                        return legacyTextFieldState4.getTextDelegate().getMaxIntrinsicWidth();
                                                    }
                                                };
                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                Modifier modifier$iv = Modifier.INSTANCE;
                                                int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                CompositionLocalMap localMap$iv = $composer6.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv = ((0 << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer6.startReusableNode();
                                                if ($composer6.getInserting()) {
                                                    $composer6.createNode(constructor);
                                                } else {
                                                    $composer6.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer6);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                                                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                                                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
                                                }
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i20 = ($changed$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer6, 1017248566, "C:CoreTextField.kt#423gt5");
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                $composer6.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                if (legacyTextFieldState3.getHandleState() == HandleState.None || legacyTextFieldState3.getLayoutCoordinates() == null) {
                                                    z218 = false;
                                                } else {
                                                    LayoutCoordinates layoutCoordinates = legacyTextFieldState3.getLayoutCoordinates();
                                                    Intrinsics.checkNotNull(layoutCoordinates);
                                                    if (layoutCoordinates.isAttached() && z216) {
                                                        z218 = true;
                                                    } else {
                                                        z218 = false;
                                                    }
                                                }
                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager3, z218, $composer6, 0);
                                                if (legacyTextFieldState3.getHandleState() == HandleState.Cursor && !z217 && z216) {
                                                    CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager2, $composer6, 0);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }, $composer5, 54), $composer5, 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final TextStyle textStyle8 = textStyle2;
            final VisualTransformation visualTransformation6 = visualTransformation3;
            final Function1<? super TextLayoutResult, Unit> function13 = function4;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Brush brush = cursorBrush2;
            final boolean z30 = softWrap2;
            final int i19 = maxLines3;
            final int i20 = minLines2;
            final ImeOptions imeOptions13 = imeOptions6;
            final KeyboardActions keyboardActions4 = keyboardActions2;
            final boolean z31 = enabled5;
            final boolean z32 = readOnly2;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function14 = function3M1172getLambda1$foundation_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.6
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
                    CoreTextFieldKt.CoreTextField(value, function1, modifier6, textStyle8, visualTransformation6, function13, mutableInteractionSource, brush, z30, i19, i20, imeOptions13, keyboardActions4, z31, z32, function14, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager manager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2 = $composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation($composer2, "C(CoreTextFieldRootBox)P(2,1)780@35397L95:CoreTextField.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(manager) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20551815, $dirty, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:779)");
            }
            int $changed$iv = ($dirty & 14) | 384;
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier);
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
            int i2 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1087266916, "C781@35453L33:CoreTextField.kt#423gt5");
            ComposerKt.sourceInformationMarkerStart($composer2, -1985516685, "CC(ContextMenuArea)P(1)29@1062L9:ContextMenu.android.kt#423gt5");
            function2.invoke($composer2, Integer.valueOf((((($dirty >> 3) & 14) | (($dirty >> 3) & 112)) >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextFieldRootBox.2
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
                    CoreTextFieldKt.CoreTextFieldRootBox(modifier, manager, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier $this$previewKeyEventToDeselectOnBack, final LegacyTextFieldState state, final TextFieldSelectionManager manager) {
        return KeyInputModifierKt.onPreviewKeyEvent($this$previewKeyEventToDeselectOnBack, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1175invokeZmokQxo(keyEvent.m5358unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1175invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (state.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1177cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1531deselect_kEHs6E$foundation_release$default(manager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(LegacyTextFieldState state, FocusRequester focusRequester, boolean allowKeyboard) {
        SoftwareKeyboardController keyboardController;
        if (!state.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!allowKeyboard || (keyboardController = state.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState state, TextFieldValue value, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        state.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, value, state.getProcessor(), imeOptions, state.getOnValueChange(), state.getOnImeActionPerformed()));
        notifyFocusedRect(state, value, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState state) {
        TextInputSession session = state.getInputSession();
        if (session != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(session, state.getProcessor(), state.getOnValueChange());
        }
        state.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester $this$bringSelectionEndIntoView, TextFieldValue value, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect selectionEndBounds;
        int selectionEndInTransformed = offsetMapping.originalToTransformed(TextRange.m6248getMaximpl(value.getSelection()));
        if (selectionEndInTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed);
        } else if (selectionEndInTransformed != 0) {
            selectionEndBounds = textLayoutResult.getBoundingBox(selectionEndInTransformed - 1);
        } else {
            long defaultSize = TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null);
            selectionEndBounds = new Rect(0.0f, 0.0f, 1.0f, IntSize.m6974getHeightimpl(defaultSize));
        }
        Object objBringIntoView = $this$bringSelectionEndIntoView.bringIntoView(selectionEndBounds, continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager manager, final boolean show, Composer $composer, final int $changed) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer $composer2 = $composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation($composer2, "C(SelectionToolbarAndHandles):CoreTextField.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(manager) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(show) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, $dirty, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1115)");
            }
            $composer2.startReplaceGroup(-498385849);
            ComposerKt.sourceInformation($composer2, "");
            if (show) {
                LegacyTextFieldState state = manager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = manager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult != null) {
                    TextLayoutResult it = textLayoutResult;
                    $composer2.startReplaceGroup(-671732075);
                    ComposerKt.sourceInformation($composer2, "1134@49862L202");
                    if (!TextRange.m6245getCollapsedimpl(manager.getValue$foundation_release().getSelection())) {
                        int startOffset = manager.getOffsetMapping().originalToTransformed(TextRange.m6251getStartimpl(manager.getValue$foundation_release().getSelection()));
                        int endOffset = manager.getOffsetMapping().originalToTransformed(TextRange.m6246getEndimpl(manager.getValue$foundation_release().getSelection()));
                        ResolvedTextDirection startDirection = it.getBidiRunDirection(startOffset);
                        ResolvedTextDirection endDirection = it.getBidiRunDirection(Math.max(endOffset - 1, 0));
                        $composer2.startReplaceGroup(-1230800948);
                        ComposerKt.sourceInformation($composer2, "1127@49539L203");
                        LegacyTextFieldState state3 = manager.getState();
                        if (state3 != null && state3.getShowSelectionHandleStart()) {
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, startDirection, manager, $composer2, (($dirty << 6) & 896) | 6);
                        }
                        $composer2.endReplaceGroup();
                        LegacyTextFieldState state4 = manager.getState();
                        if (state4 != null && state4.getShowSelectionHandleEnd()) {
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, endDirection, manager, $composer2, (($dirty << 6) & 896) | 6);
                        }
                    }
                    $composer2.endReplaceGroup();
                    LegacyTextFieldState textFieldState = manager.getState();
                    if (textFieldState != null) {
                        if (manager.isTextChanged$foundation_release()) {
                            textFieldState.setShowFloatingToolbar(false);
                        }
                        if (textFieldState.getHasFocus()) {
                            if (textFieldState.getShowFloatingToolbar()) {
                                manager.showSelectionToolbar$foundation_release();
                            } else {
                                manager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } else {
                manager.hideSelectionToolbar$foundation_release();
                Unit unit2 = Unit.INSTANCE;
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.SelectionToolbarAndHandles.2
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
                    CoreTextFieldKt.SelectionToolbarAndHandles(manager, show, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    public static final void TextFieldCursorHandle(final TextFieldSelectionManager manager, Composer $composer, final int $changed) {
        boolean z;
        Object value$iv;
        CoreTextFieldKt$TextFieldCursorHandle$1$1 value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation($composer2, "C(TextFieldCursorHandle)1160@50956L50,1161@51069L7,1165@51211L601,1177@51840L309,1162@51086L1073:CoreTextField.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(manager) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, $dirty2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1158)");
            }
            LegacyTextFieldState state = manager.getState();
            if (state != null && state.getShowCursorHandle()) {
                AnnotatedString transformedText$foundation_release = manager.getTransformedText$foundation_release();
                if (transformedText$foundation_release == null) {
                    z = false;
                } else {
                    if (transformedText$foundation_release.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1260634456, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean invalid$iv = $composer2.changed(manager);
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = manager.cursorDragObserver$foundation_release();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    TextDragObserver observer = (TextDragObserver) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    final long position = manager.m1537getCursorPositiontuRUvjQ$foundation_release((Density) objConsume);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1260634201, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changedInstance(observer) | $composer2.changedInstance(manager);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new CoreTextFieldKt$TextFieldCursorHandle$1$1(observer, manager, null);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1260633572, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean invalid$iv3 = $composer2.changed(position);
                    Object it$iv3 = $composer2.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1
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
                                $this$semantics.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, position, SelectionHandleAnchor.Middle, true, null));
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    AndroidCursorHandle_androidKt.m1149CursorHandlewy32l68(position, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) value$iv3, 1, null), 0L, $composer2, 0, 4);
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle.3
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
                    CoreTextFieldKt.TextFieldCursorHandle(manager, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(LegacyTextFieldState state, TextFieldValue value, OffsetMapping offsetMapping) {
        TextInputSession inputSession;
        LayoutCoordinates layoutCoordinates;
        Snapshot.Companion this_$iv = Snapshot.INSTANCE;
        Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
        Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
        try {
            TextLayoutResultProxy layoutResult = state.getLayoutResult();
            if (layoutResult != null && (inputSession = state.getInputSession()) != null && (layoutCoordinates = state.getLayoutCoordinates()) != null) {
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(value, state.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, state.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
        }
    }
}
