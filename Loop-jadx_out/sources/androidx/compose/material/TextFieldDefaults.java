package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jä\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ:\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bW\u0010XJä\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\b^\u0010QJ:\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b`\u0010XJ:\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bb\u0010XJJ\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u0019\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, m195d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", DownloadUtil.CookieScheme.VALUE, "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = C1979Dp.m6801constructorimpl(56);
    private static final float MinWidth = C1979Dp.m6801constructorimpl(280);
    private static final float UnfocusedBorderThickness = C1979Dp.m6801constructorimpl(1);
    private static final float FocusedBorderThickness = C1979Dp.m6801constructorimpl(2);

    private TextFieldDefaults() {
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1849getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1850getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1117199624, "C233@8406L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:233)");
        }
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return cornerBasedShapeCopy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1899109048, "C242@8708L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:242)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return small;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1851getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1848getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1843indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) == 0) {
            f3 = f;
        } else {
            f3 = FocusedBorderThickness;
        }
        if ((i & 32) == 0) {
            f4 = f2;
        } else {
            f4 = UnfocusedBorderThickness;
        }
        return textFieldDefaults.m1852indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m1852indicatorLinegv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, final float focusedIndicatorLineThickness, final float unfocusedIndicatorLineThickness) {
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
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
                $this$null.setName("indicatorLine");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("isError", Boolean.valueOf(isError));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("colors", colors);
                $this$null.getProperties().set("focusedIndicatorLineThickness", C1979Dp.m6799boximpl(focusedIndicatorLineThickness));
                $this$null.getProperties().set("unfocusedIndicatorLineThickness", C1979Dp.m6799boximpl(unfocusedIndicatorLineThickness));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                $composer.startReplaceGroup(1398930845);
                ComposerKt.sourceInformation($composer, "C299@11110L217:TextFieldDefaults.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1398930845, $changed, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:299)");
                }
                State stroke = TextFieldDefaultsKt.m1859animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness, $composer, 0);
                Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) stroke.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return modifierDrawIndicatorLine;
            }
        });
    }

    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    public final void m1847BorderBoxnbWgWpA(final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        int $dirty;
        Shape shape3;
        float focusedBorderThickness3;
        float unfocusedBorderThickness2;
        float unfocusedBorderThickness3;
        float unfocusedBorderThickness4;
        Shape shape4;
        Composer $composer2 = $composer.startRestartGroup(943754022);
        ComposerKt.sourceInformation($composer2, "C(BorderBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)332@12464L22,336@12648L203,344@12860L47:TextFieldDefaults.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i2 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i2;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                focusedBorderThickness2 = focusedBorderThickness;
                int i3 = $composer2.changed(focusedBorderThickness2) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            $dirty2 |= i3;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                f = unfocusedBorderThickness;
                int i4 = $composer2.changed(f) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                f = unfocusedBorderThickness;
            }
            $dirty2 |= i4;
        } else {
            f = unfocusedBorderThickness;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(this) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape4 = shape2;
            unfocusedBorderThickness4 = focusedBorderThickness2;
            unfocusedBorderThickness3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 16) != 0) {
                    shape2 = getOutlinedTextFieldShape($composer2, ($dirty2 >> 21) & 14);
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    focusedBorderThickness2 = FocusedBorderThickness;
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = UnfocusedBorderThickness;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943754022, $dirty, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:335)");
            }
            Shape shape5 = shape3;
            State borderStroke = TextFieldDefaultsKt.m1859animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness3, unfocusedBorderThickness2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) borderStroke.getValue(), shape5), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            unfocusedBorderThickness3 = unfocusedBorderThickness2;
            unfocusedBorderThickness4 = focusedBorderThickness3;
            shape4 = shape5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Shape shape6 = shape4;
            final float f2 = unfocusedBorderThickness4;
            final float f3 = unfocusedBorderThickness3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$BorderBox$1
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
                    this.$tmp0_rcvr.m1847BorderBoxnbWgWpA(enabled, isError, interactionSource, colors, shape6, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1845textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1856textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1856textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m864PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1846textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1857textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1857textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m864PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1844outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1854outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1854outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m864PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1855textFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 231892599, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)395@14784L7,395@14815L7,396@14888L8,397@14946L6,398@15039L6,399@15103L6,401@15182L6,401@15223L4,403@15297L6,404@15449L8,405@15511L6,407@15585L6,408@15714L8,411@15843L6,412@15974L8,413@16039L6,415@16114L6,415@16155L4,416@16213L6,416@16248L6,417@16331L8,418@16389L6,419@16451L6,419@16486L6,420@16572L8:TextFieldDefaults.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            long j = textColor2;
            disabledTextColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) != 0) {
            long jM1626getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            backgroundColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU) : 0.0f);
        } else {
            backgroundColor2 = backgroundColor;
        }
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1627getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU();
            focusedIndicatorColor2 = Color.m4289copywmQWz5c(jM1627getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1627getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1627getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1627getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1627getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 64) != 0) {
            long jM1626getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            unfocusedIndicatorColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU2) : 0.42f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU2) : 0.0f);
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i & 128) != 0) {
            long j2 = unfocusedIndicatorColor2;
            disabledIndicatorColor2 = Color.m4289copywmQWz5c(j2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j2) : 0.0f);
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorIndicatorColor;
        if ((i & 512) != 0) {
            long jM1626getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU3) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long j3 = leadingIconColor2;
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1626getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU4) : 0.54f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU4) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long j4 = trailingIconColor2;
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(j4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            long jM1627getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m4289copywmQWz5c(jM1627getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1627getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1627getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1627getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1627getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            long jM1626getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU5) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long j5 = unfocusedLabelColor2;
            disabledLabelColor2 = Color.m4289copywmQWz5c(j5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j5) : 0.0f);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            long jM1626getOnSurface0d7_KjU6 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            placeholderColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU6) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU6) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            long j6 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(j6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j6) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j6) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:422)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor2, errorIndicatorColor2, disabledIndicatorColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultTextFieldColors;
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1853outlinedTextFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 1762667317, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)453@18100L7,453@18131L7,454@18204L8,456@18310L6,457@18374L6,459@18450L6,459@18491L4,461@18562L6,461@18605L8,462@18700L8,463@18759L6,465@18833L6,466@18962L8,469@19091L6,470@19222L8,471@19287L6,473@19362L6,473@19403L4,474@19461L6,474@19496L6,475@19579L8,476@19637L6,477@19699L6,477@19734L6,478@19820L8:TextFieldDefaults.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM4301unboximpl = ((Color) objConsume).m4301unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            long j = textColor2;
            disabledTextColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long backgroundColor2 = (i & 4) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : backgroundColor;
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1627getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU();
            focusedBorderColor2 = Color.m4289copywmQWz5c(jM1627getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1627getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1627getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1627getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1627getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 64) != 0) {
            long jM1626getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            unfocusedBorderColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU) : 0.0f);
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i & 128) != 0) {
            long j2 = unfocusedBorderColor2;
            disabledBorderColor2 = Color.m4289copywmQWz5c(j2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j2) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorBorderColor;
        if ((i & 512) != 0) {
            long jM1626getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU2) : 0.54f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU2) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long j3 = leadingIconColor2;
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(j3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1626getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU3) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long j4 = trailingIconColor2;
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(j4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            long jM1627getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1627getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m4289copywmQWz5c(jM1627getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1627getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1627getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1627getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1627getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            long jM1626getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU4) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU4) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long j5 = unfocusedLabelColor2;
            disabledLabelColor2 = Color.m4289copywmQWz5c(j5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j5) : 0.0f);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1621getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            long jM1626getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1626getOnSurface0d7_KjU();
            placeholderColor2 = Color.m4289copywmQWz5c(jM1626getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM1626getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(jM1626getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM1626getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM1626getOnSurface0d7_KjU5) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            long j6 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(j6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j6) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4297getRedimpl(j6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j6) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:480)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor2, errorBorderColor2, disabledBorderColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultTextFieldColors;
    }

    public final void TextFieldDecorationBox(final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean enabled, final boolean singleLine, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, TextFieldColors colors, PaddingValues contentPadding, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function2<? super Composer, ? super Integer, Unit> function7;
        boolean isError2;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        TextFieldColors colors2;
        PaddingValues contentPadding2;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        boolean isError3;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        TextFieldColors colors3;
        PaddingValues contentPadding3;
        Composer $composer2 = $composer.startRestartGroup(1171040065);
        ComposerKt.sourceInformation($composer2, "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)572@25709L17,580@25943L569:TextFieldDefaults.kt#jmzs0o");
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
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(singleLine) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty |= 1572864;
            z = isError;
        } else if (($changed & 1572864) == 0) {
            z = isError;
            $dirty |= $composer2.changed(z) ? 1048576 : 524288;
        } else {
            z = isError;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty |= 12582912;
            function7 = function3;
        } else if (($changed & 12582912) == 0) {
            function7 = function3;
            $dirty |= $composer2.changedInstance(function7) ? 8388608 : 4194304;
        } else {
            function7 = function3;
        }
        int i4 = i & 256;
        if (i4 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i5 = i & 512;
        if (i5 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 536870912 : 268435456;
        }
        int i6 = i & 1024;
        if (i6 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function6) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= ((i & 2048) == 0 && $composer2.changed(colors)) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty1 |= ((i & 4096) == 0 && $composer2.changed(contentPadding)) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer2.changed(this) ? 2048 : 1024;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function15 = function4;
            function12 = function5;
            function13 = function6;
            colors3 = colors;
            contentPadding3 = contentPadding;
            isError3 = z;
            function14 = function7;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                isError2 = i2 != 0 ? false : z;
                function8 = i3 != 0 ? null : function7;
                function9 = i4 != 0 ? null : function4;
                function10 = i5 != 0 ? null : function5;
                function11 = i6 != 0 ? null : function6;
                if ((i & 2048) != 0) {
                    colors2 = m1855textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, ($dirty1 >> 6) & 112, 2097151);
                    $dirty1 &= -113;
                } else {
                    colors2 = colors;
                }
                if ((i & 4096) != 0) {
                    contentPadding2 = function8 == null ? m1846textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m1845textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    $dirty1 &= -897;
                } else {
                    contentPadding2 = contentPadding;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2048) != 0) {
                    $dirty1 &= -113;
                }
                if ((i & 4096) != 0) {
                    function11 = function6;
                    colors2 = colors;
                    $dirty1 &= -897;
                    isError2 = z;
                    function8 = function7;
                    function9 = function4;
                    function10 = function5;
                    contentPadding2 = contentPadding;
                } else {
                    function10 = function5;
                    function11 = function6;
                    colors2 = colors;
                    isError2 = z;
                    function8 = function7;
                    function9 = function4;
                    contentPadding2 = contentPadding;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1171040065, $dirty, $dirty1, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:579)");
            }
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, function2, visualTransformation, function8, function9, function10, function11, singleLine, enabled, isError2, interactionSource, contentPadding2, colors2, null, $composer2, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty1 << 21) & 29360128) | (($dirty << 15) & 234881024) | (($dirty << 21) & 1879048192), (($dirty >> 18) & 14) | (($dirty >> 12) & 112) | ($dirty1 & 896) | (($dirty1 << 6) & 7168), 16384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function12 = function10;
            function13 = function11;
            isError3 = isError2;
            function14 = function8;
            function15 = function9;
            colors3 = colors2;
            contentPadding3 = contentPadding2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = isError3;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function14;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function15;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function13;
            final TextFieldColors textFieldColors = colors3;
            final PaddingValues paddingValues = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox.1
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

                public final void invoke(Composer composer, int i7) {
                    TextFieldDefaults.this.TextFieldDecorationBox(value, function2, enabled, singleLine, visualTransformation, interactionSource, z2, function16, function17, function18, function19, textFieldColors, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public final void OutlinedTextFieldDecorationBox(final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean enabled, final boolean singleLine, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> function7, Composer $composer, final int $changed, final int $changed1, final int i) {
        final TextFieldColors colors2;
        PaddingValues contentPadding2;
        Function2<? super Composer, ? super Integer, Unit> function8;
        PaddingValues contentPadding3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        boolean isError2;
        TextFieldColors colors3;
        int $dirty1;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1280721485);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)664@31042L25,666@31178L78,670@31273L600:TextFieldDefaults.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty2 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(enabled) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer3.changed(interactionSource) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(isError) ? 1048576 : 524288;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i4 = i & 256;
        if (i4 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i5 = i & 512;
        if (i5 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? 536870912 : 268435456;
        }
        int i6 = i & 1024;
        if (i6 != 0) {
            $dirty2 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(function6) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty2 |= ((i & 2048) == 0 && $composer3.changed(colors)) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty2 |= ((i & 4096) == 0 && $composer3.changed(contentPadding)) ? 256 : 128;
        }
        int i7 = i & 8192;
        if (i7 != 0) {
            $dirty2 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function7) ? 2048 : 1024;
        }
        if ((i & 16384) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changed(this) ? 16384 : 8192;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty2 & 9363) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            isError2 = isError;
            function11 = function3;
            function8 = function4;
            function9 = function5;
            function10 = function6;
            colors3 = colors;
            contentPadding3 = contentPadding;
            function2RememberComposableLambda = function7;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                final boolean isError3 = i2 != 0 ? false : isError;
                Function2<? super Composer, ? super Integer, Unit> function12 = i3 != 0 ? null : function3;
                Function2<? super Composer, ? super Integer, Unit> function13 = i4 != 0 ? null : function4;
                Function2<? super Composer, ? super Integer, Unit> function14 = i5 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function15 = i6 != 0 ? null : function6;
                if ((i & 2048) != 0) {
                    colors2 = m1853outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 0, ($dirty2 >> 9) & 112, 2097151);
                    $dirty2 &= -113;
                } else {
                    colors2 = colors;
                }
                Function2<? super Composer, ? super Integer, Unit> function16 = function13;
                if ((i & 4096) != 0) {
                    contentPadding2 = m1844outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    $dirty2 &= -897;
                } else {
                    contentPadding2 = contentPadding;
                }
                if (i7 != 0) {
                    function8 = function16;
                    contentPadding3 = contentPadding2;
                    function9 = function14;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1261916269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.1
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
                            ComposerKt.sourceInformation($composer4, "C667@31192L54:TextFieldDefaults.kt#jmzs0o");
                            if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1261916269, $changed2, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:667)");
                            }
                            TextFieldDefaults.INSTANCE.m1847BorderBoxnbWgWpA(enabled, isError3, interactionSource, colors2, null, 0.0f, 0.0f, $composer4, 12582912, 112);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                    function10 = function15;
                    function11 = function12;
                    isError2 = isError3;
                    colors3 = colors2;
                    $dirty1 = $dirty2;
                } else {
                    function8 = function16;
                    contentPadding3 = contentPadding2;
                    function9 = function14;
                    function2RememberComposableLambda = function7;
                    function10 = function15;
                    function11 = function12;
                    isError2 = isError3;
                    colors3 = colors2;
                    $dirty1 = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2048) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4096) != 0) {
                    isError2 = isError;
                    function11 = function3;
                    function8 = function4;
                    function9 = function5;
                    function10 = function6;
                    colors3 = colors;
                    contentPadding3 = contentPadding;
                    function2RememberComposableLambda = function7;
                    $dirty1 = $dirty2 & (-897);
                } else {
                    isError2 = isError;
                    function11 = function3;
                    function8 = function4;
                    function9 = function5;
                    function10 = function6;
                    colors3 = colors;
                    contentPadding3 = contentPadding;
                    function2RememberComposableLambda = function7;
                    $dirty1 = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1280721485, $dirty, $dirty1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:669)");
            }
            $composer2 = $composer3;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, function2, visualTransformation, function11, function8, function9, function10, singleLine, enabled, isError2, interactionSource, contentPadding3, colors3, function2RememberComposableLambda, $composer2, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty1 << 21) & 29360128) | (($dirty << 15) & 234881024) | (($dirty << 21) & 1879048192), (($dirty >> 18) & 14) | (($dirty >> 12) & 112) | ($dirty1 & 896) | (($dirty1 << 6) & 7168) | (57344 & ($dirty1 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z = isError2;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function20 = function10;
            final TextFieldColors textFieldColors = colors3;
            final PaddingValues paddingValues = contentPadding3;
            final Function2<? super Composer, ? super Integer, Unit> function21 = function2RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.2
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
                    TextFieldDefaults.this.OutlinedTextFieldDecorationBox(value, function2, enabled, singleLine, visualTransformation, interactionSource, z, function17, function18, function19, function20, textFieldColors, paddingValues, function21, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
