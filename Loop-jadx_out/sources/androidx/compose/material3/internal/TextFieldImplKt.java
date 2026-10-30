package androidx.compose.material3.internal;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.Typography;
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
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b42\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001¢\u0006\u0002\u0010I\u001a9\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u0012\u0010R\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u0012\u0010U\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u001c\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010A\u001a\u00020?2\u0006\u0010W\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007\"\u0016\u0010\u0011\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0016\u0010\u0013\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0019\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007\"\u000e\u0010\u001b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007\"\u000e\u0010\"\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010#\u001a\u00020$X\u0080\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006X"}, m195d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/material3/internal/TextFieldType;", DownloadUtil.CookieScheme.VALUE, "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String ContainerId = "Container";
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = C1979Dp.m6801constructorimpl(16);
    private static final float HorizontalIconPadding = C1979Dp.m6801constructorimpl(12);
    private static final float SupportingTopPadding = C1979Dp.m6801constructorimpl(4);
    private static final float PrefixSuffixTextPadding = C1979Dp.m6801constructorimpl(2);
    private static final float MinTextLineHeight = C1979Dp.m6801constructorimpl(24);
    private static final float MinFocusedLabelLineHeight = C1979Dp.m6801constructorimpl(16);
    private static final float MinSupportingTextLineHeight = C1979Dp.m6801constructorimpl(16);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m897defaultMinSizeVpY3zN4(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(48), C1979Dp.m6801constructorimpl(48));

    public static final void CommonDecorationBox(final TextFieldType type, final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, Function2<? super Composer, ? super Integer, Unit> function9, boolean singleLine, boolean enabled, boolean isError, final InteractionSource interactionSource, final PaddingValues contentPadding, final TextFieldColors colors, final Function2<? super Composer, ? super Integer, Unit> function10, Composer $composer, final int $changed, final int $changed1, final int i) {
        Object value$iv;
        InputPhase inputState;
        long j;
        long j2;
        Function2<? super Composer, ? super Integer, Unit> function11;
        boolean singleLine2;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        Function2<? super Composer, ? super Integer, Unit> function16;
        boolean enabled2;
        boolean isError2;
        Composer $composer2 = $composer.startRestartGroup(1514469103);
        ComposerKt.sourceInformation($composer2, "C(CommonDecorationBox)P(15,16,4,17,7,9,8,14,10,12,13,11,3,6,5,2)86@3460L105,90@3615L25,99@3934L10,*108@4373L10,111@4554L10,116@4757L6312,106@4277L6792:TextFieldImpl.kt#mqatfk");
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
            $dirty |= $composer2.changedInstance(function7) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function8) ? 536870912 : 268435456;
        }
        int i7 = i & 1024;
        if (i7 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function9) ? 4 : 2;
        }
        int i8 = i & 2048;
        if (i8 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changed(singleLine) ? 32 : 16;
        }
        int i9 = i & 4096;
        if (i9 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changed(enabled) ? 256 : 128;
        }
        int i10 = i & 8192;
        if (i10 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer2.changed(isError) ? 2048 : 1024;
        }
        if ((i & 16384) != 0) {
            $dirty1 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty1 |= $composer2.changed(interactionSource) ? 16384 : 8192;
        }
        if ((32768 & i) != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty1 |= $composer2.changed(contentPadding) ? 131072 : 65536;
        }
        if ((i & 65536) != 0) {
            $dirty1 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty1 |= $composer2.changed(colors) ? 1048576 : 524288;
        }
        if ((i & 131072) != 0) {
            $dirty1 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty1 |= $composer2.changedInstance(function10) ? 8388608 : 4194304;
        }
        if (($dirty & 306783379) == 306783378 && (4793491 & $dirty1) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function15 = function4;
            function16 = function5;
            function12 = function6;
            function13 = function7;
            function14 = function8;
            function11 = function9;
            singleLine2 = singleLine;
            enabled2 = enabled;
            isError2 = isError;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function17 = i2 != 0 ? null : function4;
            Function2<? super Composer, ? super Integer, Unit> function18 = i3 != 0 ? null : function5;
            Function2<? super Composer, ? super Integer, Unit> function19 = i4 != 0 ? null : function6;
            Function2<? super Composer, ? super Integer, Unit> function20 = i5 != 0 ? null : function7;
            Function2<? super Composer, ? super Integer, Unit> function21 = i6 != 0 ? null : function8;
            Function2<? super Composer, ? super Integer, Unit> function22 = i7 != 0 ? null : function9;
            boolean singleLine3 = i8 != 0 ? false : singleLine;
            boolean enabled3 = i9 != 0 ? true : enabled;
            boolean isError3 = i10 != 0 ? false : isError;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1514469103, $dirty, $dirty1, "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:85)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1790838654, "CC(remember):TextFieldImpl.kt#9igjgp");
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
            final boolean isFocused = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer2, ($dirty1 >> 12) & 14).getValue().booleanValue();
            if (isFocused) {
                inputState = InputPhase.Focused;
            } else {
                inputState = transformedText.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            long labelColor = colors.m2779labelColorXeAY9LY$material3_release(enabled3, isError3, isFocused);
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer2, 6);
            final TextStyle bodyLarge = typography.getBodyLarge();
            final TextStyle bodySmall = typography.getBodySmall();
            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
            final boolean singleLine4 = singleLine3;
            boolean shouldOverrideTextStyleColor = (Color.m4292equalsimpl0(bodyLarge.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU()) && !Color.m4292equalsimpl0(bodySmall.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU())) || (!Color.m4292equalsimpl0(bodyLarge.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU()) && Color.m4292equalsimpl0(bodySmall.m6281getColor0d7_KjU(), Color.INSTANCE.m4327getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            long $this$CommonDecorationBox_u24lambda_u242 = MaterialTheme.INSTANCE.getTypography($composer2, 6).getBodySmall().m6281getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                j = ($this$CommonDecorationBox_u24lambda_u242 > 16L ? 1 : ($this$CommonDecorationBox_u24lambda_u242 == 16L ? 0 : -1)) != 0 ? $this$CommonDecorationBox_u24lambda_u242 : labelColor;
            } else {
                j = $this$CommonDecorationBox_u24lambda_u242;
            }
            long $this$CommonDecorationBox_u24lambda_u244 = MaterialTheme.INSTANCE.getTypography($composer2, 6).getBodyLarge().m6281getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                j2 = ($this$CommonDecorationBox_u24lambda_u244 > 16L ? 1 : ($this$CommonDecorationBox_u24lambda_u244 == 16L ? 0 : -1)) != 0 ? $this$CommonDecorationBox_u24lambda_u244 : labelColor;
            } else {
                j2 = $this$CommonDecorationBox_u24lambda_u244;
            }
            final boolean z = enabled3;
            final boolean z2 = isError3;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function17;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function20;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function21;
            final Function2<? super Composer, ? super Integer, Unit> function27 = function18;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function19;
            final boolean z3 = shouldOverrideTextStyleColor;
            textFieldTransitionScope.m3091TransitionJy8F4Js(inputState, j, j2, labelColor, function3 != null, ComposableLambdaKt.rememberComposableLambda(675112220, true, new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox.3

                /* JADX INFO: renamed from: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
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
                    super(7);
                }

                @Override // kotlin.jvm.functions.Function7
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Float f3, Composer composer, Integer num) {
                    m3089invokeeopBjH0(f.floatValue(), color.m4301unboximpl(), color2.m4301unboximpl(), f2.floatValue(), f3.floatValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:60:0x010b  */
                /* JADX INFO: renamed from: invoke-eopBjH0, reason: not valid java name */
                public final void m3089invokeeopBjH0(final float labelProgress, final long labelTextStyleColor, final long labelContentColor, final float placeholderAlphaProgress, final float prefixSuffixAlphaProgress, Composer $composer3, int $changed2) {
                    int i11;
                    Function2 decoratedLabel;
                    Function3 decoratedPlaceholder;
                    Function2 decoratedPrefix;
                    Function2 decoratedSuffix;
                    Function2 decoratedSupporting;
                    Object value$iv2;
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color):TextFieldImpl.kt#mqatfk");
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
                    if (($changed2 & CpioConstants.C_ISBLK) == 0) {
                        $dirty2 |= $composer3.changed(prefixSuffixAlphaProgress) ? 16384 : 8192;
                    }
                    int $dirty3 = $dirty2;
                    if ((74899 & $dirty3) != 74898 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(675112220, $dirty3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:119)");
                        }
                        final Function2<Composer, Integer, Unit> function29 = function3;
                        $composer3.startReplaceGroup(-559254676);
                        ComposerKt.sourceInformation($composer3, "*120@4971L411");
                        if (function29 == null) {
                            decoratedLabel = null;
                            i11 = 54;
                        } else {
                            final boolean z4 = z3;
                            i11 = 54;
                            decoratedLabel = ComposableLambdaKt.rememberComposableLambda(1971413858, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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
                                    ComposerKt.sourceInformation($composer4, "C*122@5050L10,123@5106L10,128@5319L49:TextFieldImpl.kt#mqatfk");
                                    if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1971413858, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                    }
                                    TextStyle it = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography($composer4, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography($composer4, 6).getBodySmall(), labelProgress);
                                    TextStyle labelTextStyle = z4 ? it.m6277copyp1EtxEg((16777213 & 1) != 0 ? it.spanStyle.m6199getColor0d7_KjU() : labelTextStyleColor, (16777213 & 2) != 0 ? it.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? it.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? it.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? it.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? it.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? it.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? it.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? it.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? it.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? it.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? it.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? it.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? it.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? it.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? it.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? it.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? it.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? it.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? it.platformStyle : null, (16777213 & 1048576) != 0 ? it.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? it.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? it.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? it.paragraphStyle.getTextMotion() : null) : it;
                                    TextFieldImplKt.m3088DecorationKTwxG1Y(labelContentColor, labelTextStyle, function29, $composer4, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer3, 54);
                        }
                        $composer3.endReplaceGroup();
                        final long placeholderColor = colors.m2781placeholderColorXeAY9LY$material3_release(z, z2, isFocused);
                        $composer3.startReplaceGroup(-559253890);
                        ComposerKt.sourceInformation($composer3, "138@5844L371");
                        if (function24 == null) {
                            decoratedPlaceholder = null;
                        } else {
                            if ((transformedText.length() == 0) && placeholderAlphaProgress > 0.0f) {
                                final Function2<Composer, Integer, Unit> function30 = function24;
                                decoratedPlaceholder = ComposableLambdaKt.rememberComposableLambda(-943726450, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
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
                                        ComposerKt.sourceInformation($composer4, "C139@5878L319:TextFieldImpl.kt#mqatfk");
                                        int $dirty4 = $changed3;
                                        if (($changed3 & 6) == 0) {
                                            $dirty4 |= $composer4.changed(modifier) ? 4 : 2;
                                        }
                                        if (($dirty4 & 19) != 18 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-943726450, $dirty4, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:139)");
                                            }
                                            Modifier modifier$iv = AlphaKt.alpha(modifier, placeholderAlphaProgress);
                                            long j3 = placeholderColor;
                                            Function2<Composer, Integer, Unit> function31 = function30;
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
                                            int i12 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i13 = ((0 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1681742561, "C142@6078L10,140@5950L225:TextFieldImpl.kt#mqatfk");
                                            TextFieldImplKt.m3088DecorationKTwxG1Y(j3, MaterialTheme.INSTANCE.getTypography($composer4, 6).getBodyLarge(), function31, $composer4, 0, 0);
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
                                }, $composer3, i11);
                            } else {
                                decoratedPlaceholder = null;
                            }
                        }
                        $composer3.endReplaceGroup();
                        final long prefixColor = colors.m2782prefixColorXeAY9LY$material3_release(z, z2, isFocused);
                        $composer3.startReplaceGroup(-559253233);
                        ComposerKt.sourceInformation($composer3, "152@6468L325");
                        if (function25 != null && prefixSuffixAlphaProgress > 0.0f) {
                            final TextStyle textStyle = bodyLarge;
                            final Function2<Composer, Integer, Unit> function31 = function25;
                            decoratedPrefix = ComposableLambdaKt.rememberComposableLambda(1545469992, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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
                                    ComposerKt.sourceInformation($composer4, "C153@6490L285:TextFieldImpl.kt#mqatfk");
                                    if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1545469992, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:153)");
                                        }
                                        Modifier modifier$iv = AlphaKt.alpha(Modifier.INSTANCE, prefixSuffixAlphaProgress);
                                        long j3 = prefixColor;
                                        TextStyle textStyle2 = textStyle;
                                        Function2<Composer, Integer, Unit> function32 = function31;
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
                                        int i12 = ($changed$iv$iv$iv >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i13 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1681741948, "C154@6563L190:TextFieldImpl.kt#mqatfk");
                                        TextFieldImplKt.m3088DecorationKTwxG1Y(j3, textStyle2, function32, $composer4, 0, 0);
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
                            }, $composer3, i11);
                        } else {
                            decoratedPrefix = null;
                        }
                        $composer3.endReplaceGroup();
                        final long suffixColor = colors.m2783suffixColorXeAY9LY$material3_release(z, z2, isFocused);
                        $composer3.startReplaceGroup(-559252655);
                        ComposerKt.sourceInformation($composer3, "166@7046L325");
                        if (function26 != null && prefixSuffixAlphaProgress > 0.0f) {
                            final TextStyle textStyle2 = bodyLarge;
                            final Function2<Composer, Integer, Unit> function32 = function26;
                            decoratedSuffix = ComposableLambdaKt.rememberComposableLambda(-282209561, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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
                                    ComposerKt.sourceInformation($composer4, "C167@7068L285:TextFieldImpl.kt#mqatfk");
                                    if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-282209561, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:167)");
                                        }
                                        Modifier modifier$iv = AlphaKt.alpha(Modifier.INSTANCE, prefixSuffixAlphaProgress);
                                        long j3 = suffixColor;
                                        TextStyle textStyle3 = textStyle2;
                                        Function2<Composer, Integer, Unit> function33 = function32;
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
                                        int i12 = ($changed$iv$iv$iv >> 6) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i13 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1681741370, "C168@7141L190:TextFieldImpl.kt#mqatfk");
                                        TextFieldImplKt.m3088DecorationKTwxG1Y(j3, textStyle3, function33, $composer4, 0, 0);
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
                            }, $composer3, i11);
                        } else {
                            decoratedSuffix = null;
                        }
                        $composer3.endReplaceGroup();
                        final long leadingIconColor = colors.m2780leadingIconColorXeAY9LY$material3_release(z, z2, isFocused);
                        final Function2<Composer, Integer, Unit> function33 = function27;
                        $composer3.startReplaceGroup(-559252065);
                        ComposerKt.sourceInformation($composer3, "*179@7582L89");
                        Function2 decoratedLeading = function33 == null ? null : ComposableLambdaKt.rememberComposableLambda(-438108364, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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
                                ComposerKt.sourceInformation($composer4, "C180@7600L57:TextFieldImpl.kt#mqatfk");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-438108364, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:180)");
                                }
                                TextFieldImplKt.m3088DecorationKTwxG1Y(leadingIconColor, null, function33, $composer4, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, i11);
                        $composer3.endReplaceGroup();
                        final long trailingIconColor = colors.m2786trailingIconColorXeAY9LY$material3_release(z, z2, isFocused);
                        final Function2<Composer, Integer, Unit> function34 = function28;
                        $composer3.startReplaceGroup(-559251775);
                        ComposerKt.sourceInformation($composer3, "*186@7872L90");
                        Function2 decoratedTrailing = function34 == null ? null : ComposableLambdaKt.rememberComposableLambda(676265512, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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
                                ComposerKt.sourceInformation($composer4, "C187@7890L58:TextFieldImpl.kt#mqatfk");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(676265512, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:187)");
                                }
                                TextFieldImplKt.m3088DecorationKTwxG1Y(trailingIconColor, null, function34, $composer4, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54);
                        $composer3.endReplaceGroup();
                        final long supportingTextColor = colors.m2784supportingTextColorXeAY9LY$material3_release(z, z2, isFocused);
                        final Function2<Composer, Integer, Unit> function35 = function23;
                        $composer3.startReplaceGroup(-559251464);
                        ComposerKt.sourceInformation($composer3, "*194@8183L116");
                        if (function35 == null) {
                            decoratedSupporting = null;
                        } else {
                            final TextStyle textStyle3 = bodySmall;
                            decoratedSupporting = ComposableLambdaKt.rememberComposableLambda(1049307647, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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
                                    ComposerKt.sourceInformation($composer4, "C195@8201L84:TextFieldImpl.kt#mqatfk");
                                    if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1049307647, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:195)");
                                    }
                                    TextFieldImplKt.m3088DecorationKTwxG1Y(supportingTextColor, textStyle3, function35, $composer4, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer3, 54);
                        }
                        $composer3.endReplaceGroup();
                        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                            case 1:
                                $composer3.startReplaceGroup(-559251226);
                                ComposerKt.sourceInformation($composer3, "201@8433L191,208@8642L667");
                                final Function2<Composer, Integer, Unit> function36 = function10;
                                Function2 containerWithId = ComposableLambdaKt.rememberComposableLambda(-885193922, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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
                                        ComposerKt.sourceInformation($composer4, "C202@8455L151:TextFieldImpl.kt#mqatfk");
                                        if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-885193922, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:202)");
                                            }
                                            Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                            Function2<Composer, Integer, Unit> function37 = function36;
                                            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                                            int $changed$iv$iv = (390 << 3) & 112;
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
                                            int i12 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i13 = ((390 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1681739938, "C204@8573L11:TextFieldImpl.kt#mqatfk");
                                            function37.invoke($composer4, 0);
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
                                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, decoratedLabel, decoratedPlaceholder, decoratedLeading, decoratedTrailing, decoratedPrefix, decoratedSuffix, singleLine4, labelProgress, containerWithId, decoratedSupporting, contentPadding, $composer3, (($dirty3 << 27) & 1879048192) | 6, 6);
                                $composer3.endReplaceGroup();
                                break;
                            case 2:
                                $composer3.startReplaceGroup(-559250198);
                                ComposerKt.sourceInformation($composer3, "226@9431L38,227@9538L342,249@10439L420,238@9898L1141");
                                ComposerKt.sourceInformationMarkerStart($composer3, -559250186, "CC(remember):TextFieldImpl.kt#9igjgp");
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
                                final Function2<Composer, Integer, Unit> function37 = function10;
                                Function2 borderContainerWithId = ComposableLambdaKt.rememberComposableLambda(330951771, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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
                                        ComposerKt.sourceInformation($composer4, "C228@9560L302:TextFieldImpl.kt#mqatfk");
                                        if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(330951771, $changed3, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:228)");
                                            }
                                            Modifier modifier$iv = OutlinedTextFieldKt.m2474outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), labelSize.getValue().getPackedValue(), paddingValues);
                                            Function2<Composer, Integer, Unit> function38 = function37;
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
                                            int i12 = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i13 = ((384 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1681738682, "C234@9829L11:TextFieldImpl.kt#mqatfk");
                                            function38.invoke($composer4, 0);
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
                                Function2<Composer, Integer, Unit> function38 = function2;
                                boolean z5 = singleLine4;
                                ComposerKt.sourceInformationMarkerStart($composer3, -559249178, "CC(remember):TextFieldImpl.kt#9igjgp");
                                boolean invalid$iv2 = ($dirty3 & 14) == 4;
                                Object it$iv3 = $composer3.rememberedValue();
                                if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                            m3090invokeuvyYCjk(size.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
                                        public final void m3090invokeuvyYCjk(long it) {
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
                                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function38, decoratedPlaceholder, decoratedLabel, decoratedLeading, decoratedTrailing, decoratedPrefix, decoratedSuffix, z5, labelProgress, (Function1) value$iv3, borderContainerWithId, decoratedSupporting, contentPadding, $composer3, (($dirty3 << 27) & 1879048192) | 6, 48);
                                $composer3.endReplaceGroup();
                                break;
                            default:
                                $composer3.startReplaceGroup(-559248554);
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
            function11 = function23;
            singleLine2 = singleLine4;
            function12 = function19;
            function13 = function20;
            function14 = function21;
            function15 = function17;
            function16 = function18;
            enabled2 = enabled3;
            isError2 = isError3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function29 = function15;
            final Function2<? super Composer, ? super Integer, Unit> function30 = function16;
            final Function2<? super Composer, ? super Integer, Unit> function31 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function32 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function33 = function14;
            final Function2<? super Composer, ? super Integer, Unit> function34 = function11;
            final boolean z4 = singleLine2;
            final boolean z5 = enabled2;
            final boolean z6 = isError2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox.4
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
                    TextFieldImplKt.CommonDecorationBox(type, value, function2, visualTransformation, function3, function29, function30, function31, function32, function33, function34, z4, z5, z6, interactionSource, contentPadding, colors, function10, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Decoration-KTwxG1Y, reason: not valid java name */
    public static final void m3088DecorationKTwxG1Y(final long contentColor, TextStyle typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle;
        TextStyle typography2;
        Composer $composer2 = $composer.startRestartGroup(1208685580);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(1:c#ui.graphics.Color,2)276@11352L134:TextFieldImpl.kt#mqatfk");
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
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            typography2 = textStyle;
        } else {
            TextStyle typography3 = i2 != 0 ? null : textStyle;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1208685580, $dirty2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:275)");
            }
            Function2 contentWithColor = ComposableLambdaKt.rememberComposableLambda(712882250, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$contentWithColor$1
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
                    ComposerKt.sourceInformation($composer3, "C277@11362L118:TextFieldImpl.kt#mqatfk");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(712882250, $changed2, -1, "androidx.compose.material3.internal.Decoration.<anonymous> (TextFieldImpl.kt:277)");
                        }
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(contentColor)), function2, $composer3, ProvidedValue.$stable);
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
                $composer2.startReplaceGroup(-323039547);
                ComposerKt.sourceInformation($composer2, "283@11523L63");
                ProvideContentColorTextStyleKt.m3015ProvideContentColorTextStyle3JVO9M(contentColor, typography3, function2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896));
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-323039466);
                ComposerKt.sourceInformation($composer2, "285@11604L18");
                contentWithColor.invoke($composer2, 6);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TextStyle textStyle2 = typography2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$1
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
                    TextFieldImplKt.m3088DecorationKTwxG1Y(contentColor, textStyle2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier $this$defaultErrorSemantics, boolean isError, final String defaultErrorMessage) {
        return isError ? SemanticsModifierKt.semantics$default($this$defaultErrorSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt.defaultErrorSemantics.1
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

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
