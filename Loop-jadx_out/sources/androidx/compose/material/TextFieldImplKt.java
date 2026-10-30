package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.AlphaKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.layout.IntrinsicMeasurable;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.LayoutIdParentData;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.TextStyleKt;
import androidx.compose.p001ui.text.input.TransformedText;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aT\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u001c\u0010I\u001a\u00020\b*\u00020\b2\u0006\u00100\u001a\u00020.2\u0006\u0010J\u001a\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006K"}, m195d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/material/TextFieldType;", DownloadUtil.CookieScheme.VALUE, "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = C1979Dp.m6801constructorimpl(16);
    private static final float HorizontalIconPadding = C1979Dp.m6801constructorimpl(12);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m897defaultMinSizeVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(48), C1979Dp.m6801constructorimpl(48));

    public static final void CommonDecorationBox(final TextFieldType type, final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, boolean singleLine, boolean enabled, boolean isError, final InteractionSource interactionSource, final PaddingValues contentPadding, final TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> function7, Composer $composer, final int $changed, final int $changed1, final int i) {
        Object value$iv;
        InputPhase inputState;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        boolean singleLine2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        boolean enabled2;
        boolean isError2;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Composer $composer2 = $composer.startRestartGroup(-712568069);
        ComposerKt.sourceInformation($composer2, "C(CommonDecorationBox)P(12,13,4,14,7,9,8,11,10,3,6,5,2,1)79@3096L105,83@3251L25,100@3861L10,117@4698L4070,107@4196L4572:TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(type) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(value) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function6) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(enabled) ? 536870912 : 268435456;
        }
        int i7 = i & 1024;
        if (i7 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(isError) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changed(interactionSource) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changed(contentPadding) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer2.changed(colors) ? 2048 : 1024;
        }
        int i8 = i & 16384;
        if (i8 != 0) {
            $dirty1 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty1 |= $composer2.changedInstance(function7) ? 16384 : 8192;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function10 = function4;
            function8 = function5;
            function9 = function6;
            singleLine2 = singleLine;
            enabled2 = enabled;
            isError2 = isError;
            function11 = function7;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function12 = i2 != 0 ? null : function4;
            Function2<? super Composer, ? super Integer, Unit> function13 = i3 != 0 ? null : function5;
            Function2<? super Composer, ? super Integer, Unit> function14 = i4 != 0 ? null : function6;
            boolean singleLine3 = i5 != 0 ? false : singleLine;
            final boolean enabled3 = i6 != 0 ? true : enabled;
            final boolean isError3 = i7 != 0 ? false : isError;
            Function2<? super Composer, ? super Integer, Unit> function15 = i8 != 0 ? null : function7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712568069, $dirty, $dirty1, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2129139758, "CC(remember):TextFieldImpl.kt#9igjgp");
            boolean invalid$iv = (($dirty & 7168) == 2048) | (($dirty & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final String transformedText = ((TransformedText) value$iv).getText().getText();
            boolean isFocused = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer2, ($dirty1 >> 3) & 14).getValue().booleanValue();
            if (isFocused) {
                inputState = InputPhase.Focused;
            } else {
                inputState = transformedText.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            Function3<InputPhase, Composer, Integer, Color> function16 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase, Composer composer, Integer num) {
                    return Color.m4281boximpl(m1863invokeXeAY9LY(inputPhase, composer, num.intValue()));
                }

                /* JADX INFO: renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m1863invokeXeAY9LY(InputPhase it, Composer $composer3, int $changed2) {
                    $composer3.startReplaceGroup(697243846);
                    ComposerKt.sourceInformation($composer3, "C91@3539L273:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(697243846, $changed2, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                    }
                    long jM4301unboximpl = colors.labelColor(enabled3, it == InputPhase.UnfocusedEmpty ? false : isError3, interactionSource, $composer3, 0).getValue().m4301unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return jM4301unboximpl;
                }
            };
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer2, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            function8 = function13;
            boolean shouldOverrideTextStyleColor = (Color.m4292equalsimpl0(subtitle1.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU()) && !Color.m4292equalsimpl0(caption.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU())) || (!Color.m4292equalsimpl0(subtitle1.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU()) && Color.m4292equalsimpl0(caption.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            $composer2.startReplaceGroup(2129140935);
            ComposerKt.sourceInformation($composer2, "*109@4292L10");
            long $this$CommonDecorationBox_u24lambda_u242 = MaterialTheme.INSTANCE.getTypography($composer2, 6).getCaption().m6281getColor0d7_KjU();
            $composer2.startReplaceGroup(2129140994);
            ComposerKt.sourceInformation($composer2, "*110@4384L22");
            if (shouldOverrideTextStyleColor) {
                long $this$takeOrElse_u2dDxMtmZc$iv = $this$CommonDecorationBox_u24lambda_u242;
                if (!($this$takeOrElse_u2dDxMtmZc$iv != 16)) {
                    $this$takeOrElse_u2dDxMtmZc$iv = function16.invoke(inputState, $composer2, 0).m4301unboximpl();
                }
                $this$CommonDecorationBox_u24lambda_u242 = $this$takeOrElse_u2dDxMtmZc$iv;
            }
            $composer2.endReplaceGroup();
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(2129141126);
            ComposerKt.sourceInformation($composer2, "*112@4483L10");
            long j = $this$CommonDecorationBox_u24lambda_u242;
            long $this$CommonDecorationBox_u24lambda_u244 = MaterialTheme.INSTANCE.getTypography($composer2, 6).getSubtitle1().m6281getColor0d7_KjU();
            $composer2.startReplaceGroup(2129141187);
            ComposerKt.sourceInformation($composer2, "*113@4577L22");
            if (shouldOverrideTextStyleColor) {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = $this$CommonDecorationBox_u24lambda_u244;
                if (($this$takeOrElse_u2dDxMtmZc$iv2 != 16 ? 1 : 0) == 0) {
                    $this$takeOrElse_u2dDxMtmZc$iv2 = function16.invoke(inputState, $composer2, 0).m4301unboximpl();
                }
                $this$CommonDecorationBox_u24lambda_u244 = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceGroup();
            $composer2.endReplaceGroup();
            final Function2<? super Composer, ? super Integer, Unit> function17 = function12;
            final boolean z = enabled3;
            final boolean z2 = isError3;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function14;
            final boolean z3 = singleLine3;
            final boolean z4 = shouldOverrideTextStyleColor;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function15;
            Function2<? super Composer, ? super Integer, Unit> function20 = function14;
            singleLine2 = singleLine3;
            textFieldTransitionScope.m1868TransitionDTcfvLk(inputState, j, $this$CommonDecorationBox_u24lambda_u244, function16, function3 != null, ComposableLambdaKt.rememberComposableLambda(341865432, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.3

                /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
                /* JADX INFO: compiled from: TextFieldImpl.kt */
                @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(6);
                }

                @Override // kotlin.jvm.functions.Function6
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer, Integer num) {
                    m1861invokeRIQooxk(f.floatValue(), color.m4301unboximpl(), color2.m4301unboximpl(), f2.floatValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:53:0x00e8  */
                /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
                public final void m1861invokeRIQooxk(final float labelProgress, final long labelTextStyleColor, final long labelContentColor, final float placeholderAlphaProgress, Composer $composer3, int $changed2) {
                    boolean z5;
                    int i9;
                    Function2 decoratedLabel;
                    Function3 decoratedPlaceholder;
                    Object value$iv2;
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)147@6120L53,154@6421L54:TextFieldImpl.kt#jmzs0o");
                    int $dirty2 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty2 |= $composer3.changed(labelProgress) ? 4 : 2;
                    }
                    if (($changed2 & 48) == 0) {
                        $dirty2 |= $composer3.changed(labelTextStyleColor) ? 32 : 16;
                    }
                    if (($changed2 & 384) == 0) {
                        $dirty2 |= $composer3.changed(labelContentColor) ? 256 : 128;
                    }
                    if (($changed2 & 3072) == 0) {
                        $dirty2 |= $composer3.changed(placeholderAlphaProgress) ? 2048 : 1024;
                    }
                    int $dirty3 = $dirty2;
                    if (($dirty3 & 9363) != 9362 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(341865432, $dirty3, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:119)");
                        }
                        final Function2<Composer, Integer, Unit> function21 = function3;
                        $composer3.startReplaceGroup(-1083199450);
                        ComposerKt.sourceInformation($composer3, "*120@4877L415");
                        if (function21 == null) {
                            decoratedLabel = null;
                            z5 = true;
                            i9 = 54;
                        } else {
                            final boolean z6 = z4;
                            z5 = true;
                            i9 = 54;
                            decoratedLabel = ComposableLambdaKt.rememberComposableLambda(362863774, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                public final void invoke(Composer $composer4, int $changed3) {
                                    ComposerKt.sourceInformation($composer4, "C*122@4956L10,123@5012L10,128@5223L55:TextFieldImpl.kt#jmzs0o");
                                    if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(362863774, $changed3, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                    }
                                    TextStyle it = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography($composer4, 6).getSubtitle1(), MaterialTheme.INSTANCE.getTypography($composer4, 6).getCaption(), labelProgress);
                                    TextStyle labelTextStyle = z6 ? it.m6277copyp1EtxEg((16777213 & 1) != 0 ? it.spanStyle.m6199getColor0d7_KjU() : labelTextStyleColor, (16777213 & 2) != 0 ? it.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? it.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? it.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? it.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? it.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? it.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? it.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? it.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? it.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? it.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? it.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? it.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? it.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? it.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? it.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? it.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? it.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? it.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? it.platformStyle : null, (16777213 & 1048576) != 0 ? it.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? it.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? it.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? it.paragraphStyle.getTextMotion() : null) : it;
                                    TextFieldImplKt.m1860DecorationeuL9pac(labelContentColor, labelTextStyle, null, function21, $composer4, 384, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer3, 54);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.startReplaceGroup(-1083198751);
                        ComposerKt.sourceInformation($composer3, "136@5663L393");
                        if (function17 == null) {
                            decoratedPlaceholder = null;
                        } else {
                            if ((transformedText.length() == 0) && placeholderAlphaProgress > 0.0f) {
                                final TextFieldColors textFieldColors = colors;
                                final boolean z7 = z;
                                final Function2<Composer, Integer, Unit> function22 = function17;
                                decoratedPlaceholder = ComposableLambdaKt.rememberComposableLambda(1120552650, z5, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                                        invoke(modifier, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Modifier modifier, Composer $composer4, int $changed3) {
                                        ComposerKt.sourceInformation($composer4, "C137@5697L341:TextFieldImpl.kt#jmzs0o");
                                        int $dirty4 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty4 |= $composer4.changed(modifier) ? 4 : 2;
                                        }
                                        if (($dirty4 & 19) != 18 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1120552650, $dirty4, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)");
                                            }
                                            Modifier modifier$iv = AlphaKt.alpha(modifier, placeholderAlphaProgress);
                                            TextFieldColors textFieldColors2 = textFieldColors;
                                            boolean z8 = z7;
                                            Function2<Composer, Integer, Unit> function23 = function22;
                                            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                            int $changed$iv$iv = (0 << 3) & 112;
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
                                            int i10 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1536681598, "C139@5831L25,140@5919L10,138@5769L247:TextFieldImpl.kt#jmzs0o");
                                            TextFieldImplKt.m1860DecorationeuL9pac(textFieldColors2.placeholderColor(z8, $composer4, 0).getValue().m4301unboximpl(), MaterialTheme.INSTANCE.getTypography($composer4, 6).getSubtitle1(), null, function23, $composer4, 0, 4);
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
                                }, $composer3, i9);
                            } else {
                                decoratedPlaceholder = null;
                            }
                        }
                        $composer3.endReplaceGroup();
                        final long leadingIconColor = colors.leadingIconColor(z, z2, interactionSource, $composer3, 0).getValue().m4301unboximpl();
                        final Function2<Composer, Integer, Unit> function23 = function8;
                        $composer3.startReplaceGroup(-1083198046);
                        ComposerKt.sourceInformation($composer3, "*149@6281L89");
                        Function2 decoratedLeading = function23 == null ? null : ComposableLambdaKt.rememberComposableLambda(1505327088, z5, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C150@6299L57:TextFieldImpl.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1505327088, $changed3, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:150)");
                                }
                                TextFieldImplKt.m1860DecorationeuL9pac(leadingIconColor, null, null, function23, $composer4, 0, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, i9);
                        $composer3.endReplaceGroup();
                        final long trailingIconColor = colors.trailingIconColor(z, z2, interactionSource, $composer3, 0).getValue().m4301unboximpl();
                        final Function2<Composer, Integer, Unit> function24 = function18;
                        $composer3.startReplaceGroup(-1083197742);
                        ComposerKt.sourceInformation($composer3, "*156@6585L90");
                        Function2 decoratedTrailing = function24 == null ? null : ComposableLambdaKt.rememberComposableLambda(-1894727196, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C157@6603L58:TextFieldImpl.kt#jmzs0o");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1894727196, $changed3, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:157)");
                                }
                                TextFieldImplKt.m1860DecorationeuL9pac(trailingIconColor, null, null, function24, $composer4, 0, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, i9);
                        $composer3.endReplaceGroup();
                        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                            case 1:
                                $composer3.startReplaceGroup(-1083197534);
                                ComposerKt.sourceInformation($composer3, "163@6763L472");
                                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, decoratedLabel, decoratedPlaceholder, decoratedLeading, decoratedTrailing, z3, labelProgress, contentPadding, $composer3, (($dirty3 << 21) & 29360128) | 6);
                                $composer3.endReplaceGroup();
                                break;
                            case 2:
                                $composer3.startReplaceGroup(-1083196952);
                                ComposerKt.sourceInformation($composer3, "177@7357L38,178@7453L286,195@8152L420,187@7757L981");
                                ComposerKt.sourceInformationMarkerStart($composer3, -1083196940, "CC(remember):TextFieldImpl.kt#9igjgp");
                                Object it$iv2 = $composer3.rememberedValue();
                                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m4106boximpl(Size.INSTANCE.m4127getZeroNHjbRc()), null, 2, null);
                                    $composer3.updateRememberedValue(value$iv2);
                                } else {
                                    value$iv2 = it$iv2;
                                }
                                final MutableState labelSize = (MutableState) value$iv2;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                final PaddingValues paddingValues = contentPadding;
                                final Function2<Composer, Integer, Unit> function25 = function19;
                                Function2 drawBorder = ComposableLambdaKt.rememberComposableLambda(139886979, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
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

                                    public final void invoke(Composer $composer4, int $changed3) {
                                        Function0<ComposeUiNode> function0;
                                        ComposerKt.sourceInformation($composer4, "C179@7475L246:TextFieldImpl.kt#jmzs0o");
                                        if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(139886979, $changed3, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:179)");
                                            }
                                            Modifier modifier$iv = OutlinedTextFieldKt.m1749outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, OutlinedTextFieldKt.BorderId), labelSize.getValue().getPackedValue(), paddingValues);
                                            Function2<Composer, Integer, Unit> function26 = function25;
                                            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                                            int $changed$iv$iv = (384 << 3) & 112;
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
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
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
                                            int i10 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((384 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1536679684, "C:TextFieldImpl.kt#jmzs0o");
                                            $composer4.startReplaceGroup(1661575907);
                                            ComposerKt.sourceInformation($composer4, "183@7691L8");
                                            if (function26 != null) {
                                                function26.invoke($composer4, 0);
                                            }
                                            $composer4.endReplaceGroup();
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
                                }, $composer3, 54);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                Function2<Composer, Integer, Unit> function26 = function2;
                                boolean z8 = z3;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1083196145, "CC(remember):TextFieldImpl.kt#9igjgp");
                                boolean invalid$iv2 = ($dirty3 & 14) == 4;
                                Object it$iv3 = $composer3.rememberedValue();
                                if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                            m1862invokeuvyYCjk(size.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                        public final void m1862invokeuvyYCjk(long it) {
                                            float labelWidth = Size.m4118getWidthimpl(it) * labelProgress;
                                            float labelHeight = Size.m4115getHeightimpl(it) * labelProgress;
                                            if (Size.m4118getWidthimpl(labelSize.getValue().getPackedValue()) == labelWidth) {
                                                if (Size.m4115getHeightimpl(labelSize.getValue().getPackedValue()) == labelHeight) {
                                                    return;
                                                }
                                            }
                                            labelSize.setValue(Size.m4106boximpl(androidx.compose.p001ui.geometry.SizeKt.Size(labelWidth, labelHeight)));
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv3;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function26, decoratedPlaceholder, decoratedLabel, decoratedLeading, decoratedTrailing, z8, labelProgress, (Function1) value$iv3, drawBorder, contentPadding, $composer3, (($dirty3 << 21) & 29360128) | 805306374, 0);
                                $composer3.endReplaceGroup();
                                break;
                            default:
                                $composer3.startReplaceGroup(-1083195535);
                                $composer3.endReplaceGroup();
                                break;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function9 = function20;
            enabled2 = enabled3;
            isError2 = isError3;
            function10 = function12;
            function11 = function15;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function21 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function22 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function9;
            final boolean z5 = singleLine2;
            final boolean z6 = enabled2;
            final boolean z7 = isError2;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function11;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.4
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
                    TextFieldImplKt.CommonDecorationBox(type, value, function2, visualTransformation, function3, function21, function22, function23, z5, z6, z7, interactionSource, contentPadding, colors, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m1860DecorationeuL9pac(final long contentColor, TextStyle typography, Float contentAlpha, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle;
        Float f;
        TextStyle typography2;
        Float contentAlpha2;
        Composer $composer2 = $composer.startRestartGroup(-399493340);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(2:c#ui.graphics.Color,3,1)224@9150L492:TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            textStyle = typography;
        } else if (($changed & 48) == 0) {
            textStyle = typography;
            $dirty |= $composer2.changed(textStyle) ? 32 : 16;
        } else {
            textStyle = typography;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            f = contentAlpha;
        } else if (($changed & 384) == 0) {
            f = contentAlpha;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = contentAlpha;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            typography2 = textStyle;
            contentAlpha2 = f;
        } else {
            TextStyle typography3 = i2 != 0 ? null : textStyle;
            final Float contentAlpha3 = i3 != 0 ? null : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, $dirty2, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:223)");
            }
            Function2 colorAndEmphasis = ComposableLambdaKt.rememberComposableLambda(494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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
                    ComposerKt.sourceInformation($composer3, "C225@9226L410,225@9160L476:TextFieldImpl.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(494684590, $changed2, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:225)");
                        }
                        ProvidedValue<Color> providedValueProvides = ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor));
                        final Float f2 = contentAlpha3;
                        final Function2<Composer, Integer, Unit> function3 = function2;
                        final long j = contentColor;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C:TextFieldImpl.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1132188434, $changed3, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:226)");
                                    }
                                    if (f2 != null) {
                                        $composer4.startReplaceGroup(-452622672);
                                        ComposerKt.sourceInformation($composer4, "227@9284L142");
                                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(f2), function3, $composer4, ProvidedValue.$stable);
                                        $composer4.endReplaceGroup();
                                    } else {
                                        $composer4.startReplaceGroup(-452622492);
                                        ComposerKt.sourceInformation($composer4, "232@9464L148");
                                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4293getAlphaimpl(j))), function3, $composer4, ProvidedValue.$stable);
                                        $composer4.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            if (typography3 != null) {
                $composer2.startReplaceGroup(-2009953423);
                ComposerKt.sourceInformation($composer2, "239@9671L46");
                TextKt.ProvideTextStyle(typography3, colorAndEmphasis, $composer2, (($dirty2 >> 3) & 14) | 48);
            } else {
                $composer2.startReplaceGroup(-2009953371);
                ComposerKt.sourceInformation($composer2, "239@9723L18");
                colorAndEmphasis.invoke($composer2, 6);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
            contentAlpha2 = contentAlpha3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TextStyle textStyle2 = typography2;
            final Float f2 = contentAlpha2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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
                    TextFieldImplKt.m1860DecorationeuL9pac(contentColor, textStyle2, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier $this$defaultErrorSemantics, boolean isError, final String defaultErrorMessage) {
        return isError ? SemanticsModifierKt.semantics$default($this$defaultErrorSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.defaultErrorSemantics.1
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
                SemanticsPropertiesKt.error($this$semantics, defaultErrorMessage);
            }
        }, 1, null) : $this$defaultErrorSemantics;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable $this$layoutId) {
        Object parentData = $this$layoutId.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
