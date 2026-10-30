package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001aØ\u0002\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)\u001aÖ\u0002\u0010*\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020+2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00100\u001aâ\u0002\u0010*\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00101¨\u00062"}, d2 = {"AdjacentLabel", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "LoopAutoFocusTextField", DownloadUtil.CookieScheme.VALUE, "onValueChange", "Lkotlin/Function1;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentDescription", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;IIII)V", "LoopTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldKt {
    public static final void LoopTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, String contentDescription, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        boolean singleLine2;
        boolean readOnly2;
        TextStyle textStyle2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        int $dirty1;
        int $dirty2;
        int minLines2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        boolean enabled2;
        MutableInteractionSource interactionSource3;
        int maxLines2;
        TextFieldColors colors2;
        Shape shape3;
        int $dirty3;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        boolean singleLine3;
        Modifier modifier2;
        int $dirty;
        final String contentDescription2;
        int $dirty4;
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        String contentDescription3;
        Modifier modifier3;
        TextFieldColors colors3;
        Shape shape4;
        MutableInteractionSource interactionSource4;
        int maxLines3;
        boolean singleLine4;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Function2<? super Composer, ? super Integer, Unit> function17;
        Function2<? super Composer, ? super Integer, Unit> function18;
        Function2<? super Composer, ? super Integer, Unit> function19;
        Function2<? super Composer, ? super Integer, Unit> function20;
        Function2<? super Composer, ? super Integer, Unit> function21;
        Function2<? super Composer, ? super Integer, Unit> function22;
        TextStyle textStyle4;
        boolean enabled3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-167005630);
        ComposerKt.sourceInformation($composer3, "C(LoopTextField)P(22,12,11,2,15,20,1,7,13,8,21,14,18,19,4,23,6,5,17,9,10,3,16)41@1716L7,57@2508L39,58@2586L5,59@2641L169,68@2944L132,65@2819L924:TextField.kt#g7nzpb");
        int $dirty5 = $changed;
        int $dirty6 = $changed1;
        int $dirty7 = $changed2;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty5 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty5 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty5 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty5 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty5 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty5 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty5 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty5 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty5 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty5 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty5 |= $composer3.changed(contentDescription) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty5 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty5 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty5 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty5 |= $composer3.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty5 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty5 |= $composer3.changedInstance(function4) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty6 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty6 |= $composer3.changedInstance(function5) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty6 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty6 |= $composer3.changedInstance(function6) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty6 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty6 |= $composer3.changedInstance(function7) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty6 |= 3072;
            i2 = i13;
        } else {
            i2 = i13;
            if (($changed1 & 7168) == 0) {
                $dirty6 |= $composer3.changedInstance(function8) ? 2048 : 1024;
            }
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty6 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & 57344) == 0) {
            $dirty6 |= $composer3.changed(isError) ? 16384 : 8192;
        }
        int i15 = i & 32768;
        if (i15 != 0) {
            $dirty6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty6 |= $composer3.changed(visualTransformation) ? 131072 : 65536;
        }
        int i16 = i & 65536;
        if (i16 != 0) {
            $dirty6 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty6 |= $composer3.changed(keyboardOptions) ? 1048576 : 524288;
        }
        int i17 = i & 131072;
        if (i17 != 0) {
            $dirty6 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty6 |= $composer3.changed(keyboardActions) ? 8388608 : 4194304;
        }
        int i18 = i & 262144;
        if (i18 != 0) {
            $dirty6 |= 100663296;
            singleLine2 = singleLine;
        } else if (($changed1 & 234881024) == 0) {
            singleLine2 = singleLine;
            $dirty6 |= $composer3.changed(singleLine2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            singleLine2 = singleLine;
        }
        if (($changed1 & 1879048192) == 0) {
            $dirty6 |= ((i & 524288) == 0 && $composer3.changed(maxLines)) ? 536870912 : 268435456;
        }
        int i19 = i & 1048576;
        if (i19 != 0) {
            $dirty7 |= 6;
        } else if (($changed2 & 14) == 0) {
            $dirty7 |= $composer3.changed(minLines) ? 4 : 2;
        }
        int i20 = i & 2097152;
        if (i20 != 0) {
            $dirty7 |= 48;
        } else if (($changed2 & 112) == 0) {
            $dirty7 |= $composer3.changed(interactionSource) ? 32 : 16;
        }
        if (($changed2 & 896) == 0) {
            $dirty7 |= ((i & 4194304) == 0 && $composer3.changed(shape)) ? 256 : 128;
        }
        if (($changed2 & 7168) == 0) {
            $dirty7 |= ((i & 8388608) == 0 && $composer3.changed(colors)) ? 2048 : 1024;
        }
        if (($dirty5 & 1533916891) == 306783378 && (1533916891 & $dirty6) == 306783378 && ($dirty7 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly2 = readOnly;
            textStyle4 = textStyle;
            contentDescription3 = contentDescription;
            function22 = function2;
            function21 = function3;
            function20 = function4;
            function19 = function5;
            function18 = function6;
            function17 = function7;
            function16 = function8;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            maxLines3 = maxLines;
            minLines2 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            singleLine4 = singleLine2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i4 != 0 ? true : enabled;
                readOnly2 = i5 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                String contentDescription4 = i6 != 0 ? null : contentDescription;
                Function2<? super Composer, ? super Integer, Unit> function23 = i7 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function24 = i8 != 0 ? null : function3;
                Function2<? super Composer, ? super Integer, Unit> function25 = i9 != 0 ? null : function4;
                Function2<? super Composer, ? super Integer, Unit> function26 = i10 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function27 = i11 != 0 ? null : function6;
                Function2<? super Composer, ? super Integer, Unit> function28 = i12 != 0 ? null : function7;
                Function2<? super Composer, ? super Integer, Unit> function29 = i2 != 0 ? null : function8;
                isError2 = i14 != 0 ? false : isError;
                visualTransformation2 = i15 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i16 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i17 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                if (i18 != 0) {
                    singleLine2 = false;
                }
                if ((i & 524288) != 0) {
                    $dirty1 = $dirty6 & (-1879048193);
                    $dirty2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    $dirty1 = $dirty6;
                    $dirty2 = maxLines;
                }
                minLines2 = i19 != 0 ? 1 : minLines;
                if (i20 != 0) {
                    $composer3.startReplaceGroup(-1773406576);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceGroup();
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((i & 4194304) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty7 &= -897;
                } else {
                    shape2 = shape;
                }
                if ((i & 8388608) != 0) {
                    enabled2 = enabled4;
                    interactionSource3 = interactionSource2;
                    maxLines2 = $dirty2;
                    shape3 = shape2;
                    colors2 = TextFieldDefaults.INSTANCE.m2548colors0hiis_0(0L, 0L, 0L, 0L, Color.INSTANCE.m4078getTransparent0d7_KjU(), Color.INSTANCE.m4078getTransparent0d7_KjU(), Color.INSTANCE.m4078getTransparent0d7_KjU(), 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 1794048, 0, 0, 0, 3072, 2147483535, UnixStat.PERM_MASK);
                    $dirty3 = $dirty7 & (-7169);
                    textStyle3 = textStyle2;
                    function9 = function23;
                    function10 = function24;
                    function11 = function25;
                    function12 = function26;
                    function13 = function27;
                    function14 = function28;
                    function15 = function29;
                    singleLine3 = singleLine2;
                    modifier2 = modifier4;
                    $dirty = $dirty5;
                    contentDescription2 = contentDescription4;
                    $dirty4 = $dirty1;
                } else {
                    enabled2 = enabled4;
                    interactionSource3 = interactionSource2;
                    maxLines2 = $dirty2;
                    colors2 = colors;
                    shape3 = shape2;
                    $dirty3 = $dirty7;
                    textStyle3 = textStyle2;
                    function9 = function23;
                    function10 = function24;
                    function11 = function25;
                    function12 = function26;
                    function13 = function27;
                    function14 = function28;
                    function15 = function29;
                    singleLine3 = singleLine2;
                    modifier2 = modifier4;
                    $dirty = $dirty5;
                    contentDescription2 = contentDescription4;
                    $dirty4 = $dirty1;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty5 &= -458753;
                }
                if ((i & 524288) != 0) {
                    $dirty6 &= -1879048193;
                }
                if ((i & 4194304) != 0) {
                    $dirty7 &= -897;
                }
                if ((i & 8388608) != 0) {
                    $dirty7 &= -7169;
                }
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                contentDescription2 = contentDescription;
                function9 = function2;
                function10 = function3;
                function11 = function4;
                function12 = function5;
                function13 = function6;
                function14 = function7;
                function15 = function8;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                maxLines2 = maxLines;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty = $dirty5;
                $dirty4 = $dirty6;
                $dirty3 = $dirty7;
                singleLine3 = singleLine2;
                modifier2 = modifier;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-167005630, $dirty, $dirty4, "com.videshkarmakar.loop.ui.component.LoopTextField (TextField.kt:64)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            $composer3.startReplaceGroup(-1773406140);
            ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
            boolean invalid$iv = ($dirty & 3670016) == 1048576;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TextFieldKt$LoopTextField$2$1
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
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        if (contentDescription2 != null) {
                            SemanticsPropertiesKt.setContentDescription(semantics, contentDescription2);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            contentDescription3 = contentDescription2;
            modifier3 = modifier2;
            androidx.compose.material3.TextFieldKt.TextField(value, onValueChange, modifier2.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv2, 1, null)), enabled2, readOnly2, textStyle3, function9, function10, function11, function12, function13, function14, function15, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine3, maxLines2, minLines2, interactionSource3, shape3, colors2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty >> 3) & 234881024) | (($dirty4 << 27) & 1879048192), (($dirty4 >> 3) & 14) | (($dirty4 >> 3) & 112) | (($dirty4 >> 3) & 896) | (($dirty4 >> 3) & 7168) | (($dirty4 >> 3) & 57344) | (($dirty4 >> 3) & 458752) | (($dirty4 >> 3) & 3670016) | (($dirty4 >> 3) & 29360128) | (($dirty4 >> 3) & 234881024) | (($dirty3 << 27) & 1879048192), (($dirty3 >> 3) & 14) | (($dirty3 >> 3) & 112) | (($dirty3 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors2;
            shape4 = shape3;
            interactionSource4 = interactionSource3;
            maxLines3 = maxLines2;
            singleLine4 = singleLine3;
            function16 = function15;
            function17 = function14;
            function18 = function13;
            function19 = function12;
            function20 = function11;
            function21 = function10;
            function22 = function9;
            textStyle4 = textStyle3;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z = enabled3;
            final boolean z2 = readOnly2;
            final TextStyle textStyle5 = textStyle4;
            final String str = contentDescription3;
            final Function2<? super Composer, ? super Integer, Unit> function30 = function22;
            final Function2<? super Composer, ? super Integer, Unit> function31 = function21;
            final Function2<? super Composer, ? super Integer, Unit> function32 = function20;
            final Function2<? super Composer, ? super Integer, Unit> function33 = function19;
            final Function2<? super Composer, ? super Integer, Unit> function34 = function18;
            final Function2<? super Composer, ? super Integer, Unit> function35 = function17;
            final Function2<? super Composer, ? super Integer, Unit> function36 = function16;
            final boolean z3 = isError2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            final boolean z4 = singleLine4;
            final int i21 = maxLines3;
            final int i22 = minLines2;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Shape shape5 = shape4;
            final TextFieldColors textFieldColors = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TextFieldKt.LoopTextField.3
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

                public final void invoke(Composer composer, int i23) {
                    TextFieldKt.LoopTextField(value, onValueChange, modifier5, z, z2, textStyle5, str, function30, function31, function32, function33, function34, function35, function36, z3, visualTransformation3, keyboardOptions3, keyboardActions3, z4, i21, i22, mutableInteractionSource, shape5, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    public static final void LoopAutoFocusTextField(final String value, final Function1<? super String, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, String contentDescription, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean isError, VisualTransformation visualTransformation, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, FocusRequester focusRequester, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int minLines2;
        boolean readOnly2;
        TextStyle textStyle2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        boolean singleLine2;
        int $dirty1;
        int $dirty2;
        int minLines3;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        TextFieldColors colors2;
        boolean enabled2;
        MutableInteractionSource interactionSource3;
        int maxLines2;
        Shape shape3;
        TextFieldColors colors3;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        int $dirty3;
        Modifier modifier2;
        FocusRequester focusRequester2;
        int $dirty4;
        final String contentDescription2;
        int $dirty;
        Object value$iv;
        Object value$iv2;
        TextFieldKt$LoopAutoFocusTextField$3$1 value$iv3;
        Object value$iv4;
        Composer $composer2;
        FocusRequester focusRequester3;
        String contentDescription3;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-401509836);
        ComposerKt.sourceInformation($composer3, "C(LoopAutoFocusTextField)P(21,11,10,2,14,19,1,6,12,7,20,13,17,18,5,22,16,8,9,4,15)104@3981L7,118@4645L39,119@4723L5,121@4829L11,120@4778L346,128@5163L29,130@5239L7,132@5273L64,132@5252L85,141@5481L148,137@5343L1102:TextField.kt#g7nzpb");
        int $dirty5 = $changed;
        int $dirty6 = $changed1;
        int $dirty7 = $changed2;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty5 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty5 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty5 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty5 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty5 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty5 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty5 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty5 |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty5 |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty5 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty5 |= $composer3.changed(contentDescription) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty5 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty5 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty5 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty5 |= $composer3.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty5 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty5 |= $composer3.changedInstance(function4) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty6 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty6 |= $composer3.changedInstance(function5) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty6 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty6 |= $composer3.changedInstance(function6) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty6 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty6 |= $composer3.changedInstance(function7) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty6 |= 3072;
            i2 = i13;
        } else {
            i2 = i13;
            if (($changed1 & 7168) == 0) {
                $dirty6 |= $composer3.changedInstance(function8) ? 2048 : 1024;
            }
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty6 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & 57344) == 0) {
            $dirty6 |= $composer3.changed(isError) ? 16384 : 8192;
        }
        int i15 = i & 32768;
        if (i15 != 0) {
            $dirty6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty6 |= $composer3.changed(visualTransformation) ? 131072 : 65536;
        }
        int i16 = i & 65536;
        if (i16 != 0) {
            $dirty6 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty6 |= $composer3.changed(singleLine) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            $dirty6 |= ((i & 131072) == 0 && $composer3.changed(maxLines)) ? 8388608 : 4194304;
        }
        int i17 = i & 262144;
        if (i17 != 0) {
            $dirty6 |= 100663296;
            minLines2 = minLines;
        } else if (($changed1 & 234881024) == 0) {
            minLines2 = minLines;
            $dirty6 |= $composer3.changed(minLines2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            minLines2 = minLines;
        }
        int i18 = i & 524288;
        if (i18 != 0) {
            $dirty6 |= 805306368;
        } else if (($changed1 & 1879048192) == 0) {
            $dirty6 |= $composer3.changed(interactionSource) ? 536870912 : 268435456;
        }
        if (($changed2 & 14) == 0) {
            $dirty7 |= ((i & 1048576) == 0 && $composer3.changed(shape)) ? 4 : 2;
        }
        if (($changed2 & 112) == 0) {
            $dirty7 |= ((i & 2097152) == 0 && $composer3.changed(colors)) ? 32 : 16;
        }
        int i19 = i & 4194304;
        if (i19 != 0) {
            $dirty7 |= 384;
        } else if (($changed2 & 896) == 0) {
            $dirty7 |= $composer3.changed(focusRequester) ? 256 : 128;
        }
        if (($dirty5 & 1533916891) == 306783378 && (1533916891 & $dirty6) == 306783378 && ($dirty7 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle3 = textStyle;
            contentDescription3 = contentDescription;
            function9 = function2;
            function10 = function3;
            function11 = function4;
            function12 = function5;
            function13 = function6;
            function14 = function7;
            function15 = function8;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            interactionSource3 = interactionSource;
            shape3 = shape;
            colors3 = colors;
            focusRequester3 = focusRequester;
            $composer2 = $composer3;
            minLines3 = minLines2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i4 != 0 ? true : enabled;
                readOnly2 = i5 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty5 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                String contentDescription4 = i6 != 0 ? null : contentDescription;
                Function2<? super Composer, ? super Integer, Unit> function16 = i7 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function17 = i8 != 0 ? null : function3;
                Function2<? super Composer, ? super Integer, Unit> function18 = i9 != 0 ? null : function4;
                Function2<? super Composer, ? super Integer, Unit> function19 = i10 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function20 = i11 != 0 ? null : function6;
                Function2<? super Composer, ? super Integer, Unit> function21 = i12 != 0 ? null : function7;
                Function2<? super Composer, ? super Integer, Unit> function22 = i2 != 0 ? null : function8;
                isError2 = i14 != 0 ? false : isError;
                visualTransformation2 = i15 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                singleLine2 = i16 != 0 ? false : singleLine;
                if ((i & 131072) != 0) {
                    $dirty1 = $dirty6 & (-29360129);
                    $dirty2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                } else {
                    $dirty1 = $dirty6;
                    $dirty2 = maxLines;
                }
                minLines3 = i17 != 0 ? 1 : minLines2;
                if (i18 != 0) {
                    $composer3.startReplaceGroup(-1597669008);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv2;
                    $composer3.endReplaceGroup();
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((i & 1048576) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty7 &= -15;
                } else {
                    shape2 = shape;
                }
                if ((2097152 & i) != 0) {
                    colors2 = TextFieldDefaults.INSTANCE.m2548colors0hiis_0(0L, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, Color.INSTANCE.m4078getTransparent0d7_KjU(), Color.INSTANCE.m4078getTransparent0d7_KjU(), Color.INSTANCE.m4078getTransparent0d7_KjU(), 0L, 0L, 0L, null, Color.INSTANCE.m4078getTransparent0d7_KjU(), Color.INSTANCE.m4078getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 1794048, 432, 0, 0, 3072, 2147477389, UnixStat.PERM_MASK);
                    $dirty7 &= -113;
                } else {
                    colors2 = colors;
                }
                if (i19 != 0) {
                    $composer3.startReplaceGroup(-1597668490);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    TextFieldColors colors4 = colors2;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv = new FocusRequester();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    enabled2 = enabled3;
                    interactionSource3 = interactionSource2;
                    maxLines2 = $dirty2;
                    shape3 = shape2;
                    colors3 = colors4;
                    textStyle3 = textStyle2;
                    function9 = function16;
                    function10 = function17;
                    function11 = function18;
                    function12 = function19;
                    function13 = function20;
                    function14 = function21;
                    function15 = function22;
                    $dirty3 = $dirty1;
                    modifier2 = modifier4;
                    focusRequester2 = (FocusRequester) value$iv;
                    $dirty4 = $dirty7;
                    contentDescription2 = contentDescription4;
                    $dirty = $dirty5;
                } else {
                    enabled2 = enabled3;
                    interactionSource3 = interactionSource2;
                    maxLines2 = $dirty2;
                    shape3 = shape2;
                    colors3 = colors2;
                    textStyle3 = textStyle2;
                    function9 = function16;
                    function10 = function17;
                    function11 = function18;
                    function12 = function19;
                    function13 = function20;
                    function14 = function21;
                    function15 = function22;
                    $dirty3 = $dirty1;
                    modifier2 = modifier4;
                    focusRequester2 = focusRequester;
                    $dirty4 = $dirty7;
                    contentDescription2 = contentDescription4;
                    $dirty = $dirty5;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty5 &= -458753;
                }
                if ((i & 131072) != 0) {
                    $dirty6 &= -29360129;
                }
                if ((i & 1048576) != 0) {
                    $dirty7 &= -15;
                }
                if ((2097152 & i) != 0) {
                    $dirty7 &= -113;
                }
                modifier2 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                contentDescription2 = contentDescription;
                function9 = function2;
                function10 = function3;
                function11 = function4;
                function12 = function5;
                function13 = function6;
                function14 = function7;
                function15 = function8;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors3 = colors;
                focusRequester2 = focusRequester;
                $dirty = $dirty5;
                $dirty3 = $dirty6;
                $dirty4 = $dirty7;
                minLines3 = minLines2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-401509836, $dirty, $dirty3, "com.videshkarmakar.loop.ui.component.LoopAutoFocusTextField (TextField.kt:129)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final FocusManager focusManager = (FocusManager) objConsume2;
            Unit unit = Unit.INSTANCE;
            $composer3.startReplaceGroup(-1597668380);
            ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
            boolean invalid$iv = ($dirty4 & 896) == 256;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new TextFieldKt$LoopAutoFocusTextField$3$1(focusRequester2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, 70);
            Modifier.Companion companion = Modifier.INSTANCE;
            $composer3.startReplaceGroup(-1597668172);
            ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 3670016) == 1048576;
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TextFieldKt$LoopAutoFocusTextField$4$1
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
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        if (contentDescription2 != null) {
                            SemanticsPropertiesKt.setContentDescription(semantics, contentDescription2);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            focusRequester3 = focusRequester2;
            contentDescription3 = contentDescription2;
            modifier3 = modifier2;
            androidx.compose.material3.TextFieldKt.TextField(value, onValueChange, FocusRequesterModifierKt.focusRequester(modifier2.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv4, 1, null)), focusRequester2), enabled2, readOnly2, textStyle3, function9, function10, function11, function12, function13, function14, function15, isError2, visualTransformation2, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TextFieldKt.LoopAutoFocusTextField.5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                    invoke2(keyboardActionScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyboardActionScope $receiver) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    FocusManager.CC.clearFocus$default(focusManager, false, 1, null);
                }
            }, null, null, null, null, null, 62, null), singleLine2, maxLines2, minLines3, interactionSource3, shape3, colors3, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 7168) | ($dirty & 57344) | (458752 & $dirty) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty >> 3) & 234881024) | (($dirty3 << 27) & 1879048192), (($dirty3 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty3 >> 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 >> 3) & 7168) | (($dirty3 >> 3) & 57344) | (($dirty3 << 3) & 29360128) | (($dirty3 << 3) & 234881024) | (($dirty3 << 3) & 1879048192), (($dirty3 >> 27) & 14) | (($dirty4 << 3) & 112) | (($dirty4 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z = enabled2;
            final boolean z2 = readOnly2;
            final TextStyle textStyle4 = textStyle3;
            final String str = contentDescription3;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function27 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function14;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function15;
            final boolean z3 = isError2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final boolean z4 = singleLine2;
            final int i20 = maxLines2;
            final int i21 = minLines3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Shape shape4 = shape3;
            final TextFieldColors textFieldColors = colors3;
            final FocusRequester focusRequester4 = focusRequester3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TextFieldKt.LoopAutoFocusTextField.6
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
                    TextFieldKt.LoopAutoFocusTextField(value, onValueChange, modifier5, z, z2, textStyle4, str, function23, function24, function25, function26, function27, function28, function29, z3, visualTransformation3, z4, i20, i21, mutableInteractionSource, shape4, textFieldColors, focusRequester4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    public static final void LoopTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int maxLines2;
        TextStyle textStyle2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int minLines2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        MutableInteractionSource interactionSource3;
        TextFieldColors colors2;
        Shape shape3;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        boolean isError2;
        int maxLines3;
        int maxLines4;
        int $dirty1;
        int $dirty2;
        Object value$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(1240679234);
        ComposerKt.sourceInformation($composer3, "C(LoopTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)180@6729L7,195@7481L39,196@7559L5,197@7614L169,203@7792L471:TextField.kt#g7nzpb");
        int $dirty = $changed;
        int $dirty3 = $changed1;
        int $dirty4 = $changed2;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            $dirty |= ((i & 32) == 0 && $composer3.changed(textStyle)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty3 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(function6) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty3 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(function7) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty3 |= $composer3.changedInstance(function8) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty3 |= 3072;
            i2 = i13;
        } else {
            i2 = i13;
            if (($changed1 & 7168) == 0) {
                $dirty3 |= $composer3.changed(isError) ? 2048 : 1024;
            }
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed1 & 57344) == 0) {
            $dirty3 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
        }
        int i15 = i & 32768;
        if (i15 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty3 |= $composer3.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i16 = i & 65536;
        if (i16 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty3 |= $composer3.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i17 = i & 131072;
        if (i17 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty3 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0) {
                maxLines2 = maxLines;
                int i18 = $composer3.changed(maxLines2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty3 |= i18;
            } else {
                maxLines2 = maxLines;
            }
            $dirty3 |= i18;
        } else {
            maxLines2 = maxLines;
        }
        int i19 = i & 524288;
        if (i19 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed1 & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        int i20 = i & 1048576;
        if (i20 != 0) {
            $dirty4 |= 6;
        } else if (($changed2 & 14) == 0) {
            $dirty4 |= $composer3.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 112) == 0) {
            $dirty4 |= ((i & 2097152) == 0 && $composer3.changed(shape)) ? 32 : 16;
        }
        if (($changed2 & 896) == 0) {
            $dirty4 |= ((i & 4194304) == 0 && $composer3.changed(colors)) ? 256 : 128;
        }
        if (($dirty & 1533916891) == 306783378 && (1533916891 & $dirty3) == 306783378 && ($dirty4 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle3 = textStyle;
            function14 = function2;
            function9 = function3;
            function10 = function4;
            function11 = function5;
            function12 = function6;
            function13 = function7;
            function15 = function8;
            isError2 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            minLines2 = minLines;
            interactionSource3 = interactionSource;
            shape3 = shape;
            colors2 = colors;
            $composer2 = $composer3;
            maxLines3 = maxLines2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i4 != 0 ? true : enabled;
                boolean readOnly3 = i5 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                Function2<? super Composer, ? super Integer, Unit> function16 = i6 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function17 = i7 != 0 ? null : function3;
                Function2<? super Composer, ? super Integer, Unit> function18 = i8 != 0 ? null : function4;
                Function2<? super Composer, ? super Integer, Unit> function19 = i9 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function20 = i10 != 0 ? null : function6;
                Function2<? super Composer, ? super Integer, Unit> function21 = i11 != 0 ? null : function7;
                Function2<? super Composer, ? super Integer, Unit> function22 = i12 != 0 ? null : function8;
                boolean isError3 = i2 != 0 ? false : isError;
                visualTransformation2 = i14 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i15 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i16 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i17 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty3 &= -234881025;
                }
                minLines2 = i19 != 0 ? 1 : minLines;
                if (i20 != 0) {
                    $composer3.startReplaceGroup(-1773401603);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceGroup();
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((2097152 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty4 &= -113;
                } else {
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    modifier2 = modifier3;
                    enabled2 = enabled3;
                    readOnly2 = readOnly3;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    colors2 = TextFieldDefaults.INSTANCE.m2548colors0hiis_0(0L, 0L, 0L, 0L, Color.INSTANCE.m4078getTransparent0d7_KjU(), Color.INSTANCE.m4078getTransparent0d7_KjU(), Color.INSTANCE.m4078getTransparent0d7_KjU(), 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 1794048, 0, 0, 0, 3072, 2147483535, UnixStat.PERM_MASK);
                    textStyle3 = textStyle2;
                    function9 = function17;
                    function10 = function18;
                    function11 = function19;
                    function12 = function20;
                    function13 = function21;
                    function14 = function16;
                    function15 = function22;
                    isError2 = isError3;
                    maxLines3 = maxLines2;
                    maxLines4 = $dirty;
                    $dirty1 = $dirty3;
                    $dirty2 = $dirty4 & (-897);
                } else {
                    modifier2 = modifier3;
                    enabled2 = enabled3;
                    readOnly2 = readOnly3;
                    interactionSource3 = interactionSource2;
                    colors2 = colors;
                    shape3 = shape2;
                    textStyle3 = textStyle2;
                    function9 = function17;
                    function10 = function18;
                    function11 = function19;
                    function12 = function20;
                    function13 = function21;
                    function14 = function16;
                    function15 = function22;
                    isError2 = isError3;
                    maxLines3 = maxLines2;
                    maxLines4 = $dirty;
                    $dirty1 = $dirty3;
                    $dirty2 = $dirty4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty4 &= -113;
                }
                if ((i & 4194304) != 0) {
                    $dirty4 &= -897;
                }
                modifier2 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
                textStyle3 = textStyle;
                function14 = function2;
                function9 = function3;
                function10 = function4;
                function11 = function5;
                function12 = function6;
                function13 = function7;
                function15 = function8;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                minLines2 = minLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty1 = $dirty3;
                $dirty2 = $dirty4;
                maxLines3 = maxLines2;
                maxLines4 = $dirty;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1240679234, maxLines4, $dirty1, "com.videshkarmakar.loop.ui.component.LoopTextField (TextField.kt:202)");
            }
            $composer2 = $composer3;
            androidx.compose.material3.TextFieldKt.TextField(value, onValueChange, modifier2, enabled2, readOnly2, textStyle3, function14, function9, function10, function11, function12, function13, function15, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, interactionSource3, shape3, colors2, $composer2, (maxLines4 & 14) | (maxLines4 & 112) | (maxLines4 & 896) | (maxLines4 & 7168) | (maxLines4 & 57344) | (maxLines4 & 458752) | (maxLines4 & 3670016) | (maxLines4 & 29360128) | (maxLines4 & 234881024) | (maxLines4 & 1879048192), ($dirty1 & 14) | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | ($dirty1 & 57344) | ($dirty1 & 458752) | ($dirty1 & 3670016) | ($dirty1 & 29360128) | ($dirty1 & 234881024) | ($dirty1 & 1879048192), ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z = enabled2;
            final boolean z2 = readOnly2;
            final TextStyle textStyle4 = textStyle3;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function14;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function27 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function15;
            final boolean z3 = isError2;
            final VisualTransformation visualTransformation3 = visualTransformation2;
            final KeyboardOptions keyboardOptions3 = keyboardOptions2;
            final KeyboardActions keyboardActions3 = keyboardActions2;
            final boolean z4 = singleLine2;
            final int i21 = maxLines3;
            final int i22 = minLines2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Shape shape4 = shape3;
            final TextFieldColors textFieldColors = colors2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TextFieldKt.LoopTextField.5
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

                public final void invoke(Composer composer, int i23) {
                    TextFieldKt.LoopTextField(value, onValueChange, modifier4, z, z2, textStyle4, function23, function24, function25, function26, function27, function28, function29, z3, visualTransformation3, keyboardOptions3, keyboardActions3, z4, i21, i22, mutableInteractionSource, shape4, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    public static final void AdjacentLabel(Modifier modifier, final String text, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-827105454);
        ComposerKt.sourceInformation($composer3, "C(AdjacentLabel)235@8472L10,236@8524L11,232@8348L211:TextField.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            Modifier modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-827105454, $dirty2, -1, "com.videshkarmakar.loop.ui.component.AdjacentLabel (TextField.kt:231)");
            }
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, PaddingKt.m624paddingqDBjuR0$default(modifier3, Dp.m6553constructorimpl(4), 0.0f, 0.0f, Dp.m6553constructorimpl(12), 6, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer2, ($dirty2 >> 3) & 14, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.TextFieldKt.AdjacentLabel.1
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
                    TextFieldKt.AdjacentLabel(modifier2, text, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
