package com.videshkarmakar.loop.ui.page.download;

import android.text.TextUtils;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ArrowRightKt;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RangeSliderState;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.timepicker.TimeModel;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.DialogsKt;
import com.videshkarmakar.loop.ui.component.TextFieldKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: VideoSectionSlider.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aV\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0014\u001aQ\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00030\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0014\u001a;\u0010 \u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0007¢\u0006\u0002\u0010#\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\tX\u008a\u008e\u0002²\u0006\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"TAG", "", "CustomRangeSlider", "", "state", "Landroidx/compose/material3/RangeSliderState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "CustomRangeSlider-honKnco", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;JLandroidx/compose/runtime/Composer;II)V", "SliderPreview", "(Landroidx/compose/runtime/Composer;I)V", "VideoClipDialog", "onDismissRequest", "Lkotlin/Function0;", "initialValue", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "valueRange", "onConfirm", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "VideoClipDialogPreview", "VideoSelectionSlider", "onDurationClick", "onDiscard", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "convertToSecs", "", "min", "sec", "app_debug", "startText", "endText", "fromMin", "Landroidx/compose/ui/text/input/TextFieldValue;", "toMin", "fromSec", "toSec", "error", "shouldUpdate"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoSectionSliderKt {
    private static final String TAG = "VideoSectionSlider";

    /* JADX INFO: renamed from: CustomRangeSlider-honKnco, reason: not valid java name */
    public static final void m7269CustomRangeSliderhonKnco(final RangeSliderState state, Modifier modifier, boolean enabled, SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, long thumbSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        SliderColors colors2;
        MutableInteractionSource startInteractionSource2;
        MutableInteractionSource endInteractionSource2;
        long j;
        int $dirty;
        MutableInteractionSource startInteractionSource3;
        long thumbSize2;
        MutableInteractionSource endInteractionSource3;
        Modifier modifier3;
        final boolean enabled3;
        final SliderColors colors3;
        Object value$iv;
        Object value$iv2;
        SliderColors colors4;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-651065411);
        ComposerKt.sourceInformation($composer2, "C(CustomRangeSlider)P(5,3,1!1,4!,6:c#ui.unit.DpSize)66@2968L8,67@3033L39,68@3127L39,75@3407L367,86@3795L367,97@4180L157,71@3220L1118:VideoSectionSlider.kt#y3famj");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            enabled2 = enabled;
        } else if (($changed & 896) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                colors2 = colors;
                int i4 = $composer2.changed(colors2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i4;
        } else {
            colors2 = colors;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            startInteractionSource2 = startInteractionSource;
        } else if (($changed & 57344) == 0) {
            startInteractionSource2 = startInteractionSource;
            $dirty2 |= $composer2.changed(startInteractionSource2) ? 16384 : 8192;
        } else {
            startInteractionSource2 = startInteractionSource;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            endInteractionSource2 = endInteractionSource;
        } else if (($changed & 458752) == 0) {
            endInteractionSource2 = endInteractionSource;
            $dirty2 |= $composer2.changed(endInteractionSource2) ? 131072 : 65536;
        } else {
            endInteractionSource2 = endInteractionSource;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            j = thumbSize;
        } else if (($changed & 3670016) == 0) {
            j = thumbSize;
            $dirty2 |= $composer2.changed(j) ? 1048576 : 524288;
        } else {
            j = thumbSize;
        }
        if (($dirty2 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            colors4 = colors2;
            startInteractionSource3 = startInteractionSource2;
            thumbSize2 = j;
            endInteractionSource3 = endInteractionSource2;
            modifier3 = modifier2;
            enabled3 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    colors2 = SliderDefaults.INSTANCE.colors($composer2, 6);
                }
                if (i5 != 0) {
                    $composer2.startReplaceGroup(1744847247);
                    ComposerKt.sourceInformation($composer2, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    $composer2.endReplaceGroup();
                    startInteractionSource2 = (MutableInteractionSource) value$iv2;
                }
                if (i6 != 0) {
                    $composer2.startReplaceGroup(1744847341);
                    ComposerKt.sourceInformation($composer2, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv2;
                    }
                    $composer2.endReplaceGroup();
                    endInteractionSource2 = (MutableInteractionSource) value$iv;
                }
                if (i7 != 0) {
                    modifier3 = modifier4;
                    $dirty = $dirty2;
                    thumbSize2 = DpKt.m6575DpSizeYgX7TsA(Dp.m6553constructorimpl(4), Dp.m6553constructorimpl(24));
                    colors3 = colors2;
                    startInteractionSource3 = startInteractionSource2;
                    endInteractionSource3 = endInteractionSource2;
                    enabled3 = enabled2;
                } else {
                    $dirty = $dirty2;
                    startInteractionSource3 = startInteractionSource2;
                    thumbSize2 = j;
                    endInteractionSource3 = endInteractionSource2;
                    modifier3 = modifier4;
                    enabled3 = enabled2;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    startInteractionSource3 = startInteractionSource2;
                    thumbSize2 = j;
                    endInteractionSource3 = endInteractionSource2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    startInteractionSource3 = startInteractionSource2;
                    thumbSize2 = j;
                    endInteractionSource3 = endInteractionSource2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    colors3 = colors2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-651065411, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.CustomRangeSlider (VideoSectionSlider.kt:70)");
            }
            final MutableInteractionSource mutableInteractionSource = startInteractionSource3;
            final SliderColors sliderColors = colors3;
            final boolean z = enabled3;
            final long j2 = thumbSize2;
            colors4 = colors3;
            SliderKt.RangeSlider(state, modifier3, false, null, startInteractionSource3, endInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-958907043, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$CustomRangeSlider$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                    invoke(rangeSliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer3, "C76@3421L343:VideoSectionSlider.kt#y3famj");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-958907043, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.CustomRangeSlider.<anonymous> (VideoSectionSlider.kt:76)");
                        }
                        Modifier modifier$iv = Modifier.INSTANCE;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        SliderColors sliderColors2 = sliderColors;
                        boolean z2 = z;
                        long j3 = j2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (6 << 3) & 112;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        int i9 = ((6 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u240 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -559490048, "C77@3479L271:VideoSectionSlider.kt#y3famj");
                        SliderDefaults.INSTANCE.m2374Thumb9LiSoMs(mutableInteractionSource2, $this$invoke_u24lambda_u240.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), sliderColors2, z2, j3, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
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
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(1576700382, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$CustomRangeSlider$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                    invoke(rangeSliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState it, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer3, "C87@3809L343:VideoSectionSlider.kt#y3famj");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1576700382, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.CustomRangeSlider.<anonymous> (VideoSectionSlider.kt:87)");
                        }
                        Modifier modifier$iv = Modifier.INSTANCE;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        SliderColors sliderColors2 = sliderColors;
                        boolean z2 = z;
                        long j3 = j2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (6 << 3) & 112;
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
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        int i9 = ((6 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u240 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -559489660, "C88@3867L271:VideoSectionSlider.kt#y3famj");
                        SliderDefaults.INSTANCE.m2374Thumb9LiSoMs(mutableInteractionSource2, $this$invoke_u24lambda_u240.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), sliderColors2, z2, j3, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
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
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-182659489, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$CustomRangeSlider$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer, Integer num) {
                    invoke(rangeSliderState, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState sliderState, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(sliderState, "sliderState");
                    ComposerKt.sourceInformation($composer3, "C98@4224L103:VideoSectionSlider.kt#y3famj");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer3.changed(sliderState) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-182659489, $dirty4, -1, "com.videshkarmakar.loop.ui.page.download.CustomRangeSlider.<anonymous> (VideoSectionSlider.kt:98)");
                        }
                        SliderDefaults.INSTANCE.m2375TracknbWgWpA(sliderState, (Modifier) null, enabled3, colors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, 0.0f, 0.0f, $composer3, 12582912 | RangeSliderState.$stable | ($dirty4 & 14), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 114819072 | RangeSliderState.$stable | ($dirty & 14) | ($dirty & 112) | (57344 & $dirty) | (458752 & $dirty), 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled3;
            final SliderColors sliderColors2 = colors4;
            final MutableInteractionSource mutableInteractionSource2 = startInteractionSource3;
            final MutableInteractionSource mutableInteractionSource3 = endInteractionSource3;
            final long j3 = thumbSize2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$CustomRangeSlider$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    VideoSectionSliderKt.m7269CustomRangeSliderhonKnco(state, modifier5, z2, sliderColors2, mutableInteractionSource2, mutableInteractionSource3, j3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0486  */
    /* JADX WARN: Code duplicated, block: B:104:0x0492  */
    /* JADX WARN: Code duplicated, block: B:105:0x0496  */
    /* JADX WARN: Code duplicated, block: B:116:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:119:0x05db  */
    /* JADX WARN: Code duplicated, block: B:120:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:131:0x0789  */
    public static final void VideoSelectionSlider(Modifier modifier, final RangeSliderState state, final Function0<Unit> onDurationClick, final Function0<Unit> onDiscard, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        Object value$iv2;
        Function0<ComposeUiNode> function0;
        MeasurePolicy measurePolicy$iv;
        Function0<ComposeUiNode> function1;
        Modifier modifier3;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        int compositeKeyHash$iv$iv2;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> function2;
        Composer $this$Layout_u24lambda_u240$iv$iv2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onDurationClick, "onDurationClick");
        Intrinsics.checkNotNullParameter(onDiscard, "onDiscard");
        Composer $composer2 = $composer.startRestartGroup(847486148);
        ComposerKt.sourceInformation($composer2, "C(VideoSelectionSlider)P(!1,3,2)113@4570L117,116@4707L113,119@4825L1446:VideoSectionSlider.kt#y3famj");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(onDurationClick) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(onDiscard) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847486148, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.VideoSelectionSlider (VideoSectionSlider.kt:111)");
            }
            float activeRangeStart = state.getActiveRangeStart();
            $composer2.startReplaceGroup(747005253);
            ComposerKt.sourceInformation($composer2, "CC(remember):VideoSectionSlider.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(activeRangeStart);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextUtilKt.toDurationText(MathKt.roundToInt(state.getActiveRangeStart())), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState startText$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            float activeRangeEnd = state.getActiveRangeEnd();
            $composer2.startReplaceGroup(747005390);
            ComposerKt.sourceInformation($composer2, "CC(remember):VideoSectionSlider.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(activeRangeEnd);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextUtilKt.toDurationText(MathKt.roundToInt(state.getActiveRangeEnd())), null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableState endText$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            int $changed$iv = $dirty2 & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier4);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor3);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ColumnScope $this$VideoSelectionSlider_u24lambda_u249 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 2019336205, "C122@4865L277,131@5152L1113:VideoSectionSlider.kt#y3famj");
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor4;
                $composer2.createNode(function0);
            } else {
                function0 = constructor4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                measurePolicy$iv = measurePolicy$iv3;
                function1 = function0;
            } else {
                measurePolicy$iv = measurePolicy$iv3;
                function1 = function0;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i6 = ((390 >> 6) & 112) | 6;
                RowScope $this$VideoSelectionSlider_u24lambda_u249_u24lambda_u246 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -536055659, "C124@4968L164:VideoSectionSlider.kt#y3famj");
                modifier3 = modifier4;
                m7269CustomRangeSliderhonKnco(state, PaddingKt.m622paddingVpY3zN4$default(RowScope.CC.weight$default($this$VideoSelectionSlider_u24lambda_u249_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), false, null, null, null, 0L, $composer2, RangeSliderState.$stable | (($dirty2 >> 3) & 14), 124);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv2 = $this$VideoSelectionSlider_u24lambda_u249.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(16), 7, null), Alignment.INSTANCE.getEnd());
                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv3 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i8 = ((384 >> 6) & 112) | 6;
                RowScope $this$VideoSelectionSlider_u24lambda_u249_u24lambda_u248 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -536055275, "C142@5565L34,137@5352L598,153@5963L38,157@6140L37,158@6224L11,154@6014L241:VideoSectionSlider.kt#y3famj");
                Modifier modifier$iv3 = ClickableKt.m239clickableXHw0xAI$default(ClipKt.clip(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(40)), RoundedCornerShapeKt.getCircleShape()), false, StringResources_androidKt.stringResource(R.string.edit, $composer2, 0), null, onDurationClick, 5, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv4 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function2 = constructor2;
                    $composer2.createNode(function2);
                } else {
                    function2 = constructor2;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash4);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i10 = ((0 >> 6) & 112) | 6;
                BoxScope $this$VideoSelectionSlider_u24lambda_u249_u24lambda_u248_u24lambda_u247 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1835538916, "C147@5754L10,145@5654L282:VideoSectionSlider.kt#y3famj");
                TextKt.m2569Text4IGK_g(VideoSelectionSlider$lambda$3(startText$delegate) + " / " + VideoSelectionSlider$lambda$5(endText$delegate), PaddingKt.m622paddingVpY3zN4$default($this$VideoSelectionSlider_u24lambda_u249_u24lambda_u248_u24lambda_u247.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Dp.m6553constructorimpl(12), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelLarge(), $composer2, 0, 0, 65532);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SpacerKt.Spacer(RowScope.CC.weight$default($this$VideoSelectionSlider_u24lambda_u249_u24lambda_u248, Modifier.INSTANCE, 1.0f, false, 2, null), $composer2, 0);
                ButtonsKt.m7104TextButtonWithIconuDo3WH8(null, DeleteKt.getDelete(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.discard, $composer2, 0), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getError(), onDiscard, $composer2, ($dirty2 << 3) & 57344, 1);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
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
            }
            $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
            $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i12 = ((390 >> 6) & 112) | 6;
            RowScope $this$VideoSelectionSlider_u24lambda_u249_u24lambda_u247 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -536055659, "C124@4968L164:VideoSectionSlider.kt#y3famj");
            modifier3 = modifier4;
            m7269CustomRangeSliderhonKnco(state, PaddingKt.m622paddingVpY3zN4$default(RowScope.CC.weight$default($this$VideoSelectionSlider_u24lambda_u249_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), false, null, null, null, 0L, $composer2, RangeSliderState.$stable | (($dirty2 >> 3) & 14), 124);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv4 = $this$VideoSelectionSlider_u24lambda_u249.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(16), 7, null), Alignment.INSTANCE.getEnd());
            Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv5 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash5);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
            int i13 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i14 = ((384 >> 6) & 112) | 6;
            RowScope $this$VideoSelectionSlider_u24lambda_u249_u24lambda_u249 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -536055275, "C142@5565L34,137@5352L598,153@5963L38,157@6140L37,158@6224L11,154@6014L241:VideoSectionSlider.kt#y3famj");
            Modifier modifier$iv5 = ClickableKt.m239clickableXHw0xAI$default(ClipKt.clip(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(40)), RoundedCornerShapeKt.getCircleShape()), false, StringResources_androidKt.stringResource(R.string.edit, $composer2, 0), null, onDurationClick, 5, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv6 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv6 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor2;
                $composer2.createNode(function2);
            } else {
                function2 = constructor2;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
            int i15 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i16 = ((0 >> 6) & 112) | 6;
            BoxScope $this$VideoSelectionSlider_u24lambda_u249_u24lambda_u248_u24lambda_u248 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1835538916, "C147@5754L10,145@5654L282:VideoSectionSlider.kt#y3famj");
            TextKt.m2569Text4IGK_g(VideoSelectionSlider$lambda$3(startText$delegate) + " / " + VideoSelectionSlider$lambda$5(endText$delegate), PaddingKt.m622paddingVpY3zN4$default($this$VideoSelectionSlider_u24lambda_u249_u24lambda_u248_u24lambda_u248.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Dp.m6553constructorimpl(12), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelLarge(), $composer2, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(RowScope.CC.weight$default($this$VideoSelectionSlider_u24lambda_u249_u24lambda_u249, Modifier.INSTANCE, 1.0f, false, 2, null), $composer2, 0);
            ButtonsKt.m7104TextButtonWithIconuDo3WH8(null, DeleteKt.getDelete(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.discard, $composer2, 0), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getError(), onDiscard, $composer2, ($dirty2 << 3) & 57344, 1);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoSelectionSlider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i17) {
                    VideoSectionSliderKt.VideoSelectionSlider(modifier5, state, onDurationClick, onDiscard, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final String VideoSelectionSlider$lambda$3(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    private static final String VideoSelectionSlider$lambda$5(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void VideoClipDialog(final Function0<Unit> onDismissRequest, final ClosedFloatingPointRange<Float> initialValue, final ClosedFloatingPointRange<Float> valueRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> onConfirm, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(valueRange, "valueRange");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer $composer3 = $composer.startRestartGroup(897497530);
        ComposerKt.sourceInformation($composer3, "C(VideoClipDialog)P(2!1,3)171@6523L214,179@6755L221,187@6996L214,195@7228L221,205@7469L71,208@7606L40,209@7661L38,210@7723L36,211@7783L36,229@8481L30,230@8537L40,231@8594L5080,226@8283L5392:VideoSectionSlider.kt#y3famj");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(initialValue) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(valueRange) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onConfirm) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(897497530, $dirty2, -1, "com.videshkarmakar.loop.ui.page.download.VideoClipDialog (VideoSectionSlider.kt:170)");
            }
            $composer3.startReplaceGroup(67897707);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoSectionSlider.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(initialValue.getStart().floatValue()) / 60)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, TextRangeKt.TextRange(Integer.MAX_VALUE), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState fromMin$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(67897939);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoSectionSlider.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                String str2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(initialValue.getEndInclusive().floatValue()) / 60)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, TextRangeKt.TextRange(Integer.MAX_VALUE), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState toMin$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(67898180);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoSectionSlider.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                String str3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(initialValue.getStart().floatValue()) % 60)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str3, TextRangeKt.TextRange(Integer.MAX_VALUE), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState fromSec$delegate = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(67898412);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoSectionSlider.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                String str4 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(initialValue.getEndInclusive().floatValue()) % 60)}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str4, TextRangeKt.TextRange(Integer.MAX_VALUE), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final MutableState toSec$delegate = (MutableState) value$iv4;
            $composer3.endReplaceGroup();
            String text = VideoClipDialog$lambda$11(fromMin$delegate).getText();
            TextFieldValue textFieldValueVideoClipDialog$lambda$14 = VideoClipDialog$lambda$14(toMin$delegate);
            TextFieldValue textFieldValueVideoClipDialog$lambda$17 = VideoClipDialog$lambda$17(fromSec$delegate);
            TextFieldValue textFieldValueVideoClipDialog$lambda$20 = VideoClipDialog$lambda$20(toSec$delegate);
            $composer3.startReplaceGroup(67898653);
            ComposerKt.sourceInformation($composer3, "CC(remember):VideoSectionSlider.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(text) | $composer3.changed(textFieldValueVideoClipDialog$lambda$14) | $composer3.changed(textFieldValueVideoClipDialog$lambda$17) | $composer3.changed(textFieldValueVideoClipDialog$lambda$20);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableState error$delegate = (MutableState) value$iv5;
            $composer3.endReplaceGroup();
            final IntRange valueIntRange = TextUtilKt.toIntRange(valueRange);
            final String start = StringResources_androidKt.stringResource(R.string.clip_start, $composer3, 0);
            final String end = StringResources_androidKt.stringResource(R.string.clip_end, $composer3, 0);
            final String minute = "," + StringResources_androidKt.stringResource(R.string.minute, $composer3, 0);
            final String second = "," + StringResources_androidKt.stringResource(R.string.second, $composer3, 0);
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-2966593, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialog.1
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
                    ComposerKt.sourceInformation($composer4, "C229@8483L26:VideoSectionSlider.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2966593, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.VideoClipDialog.<anonymous> (VideoSectionSlider.kt:229)");
                    }
                    final IntRange intRange = valueIntRange;
                    final Function1<ClosedFloatingPointRange<Float>, Unit> function1 = onConfirm;
                    final Function0<Unit> function0 = onDismissRequest;
                    final MutableState<TextFieldValue> mutableState = fromMin$delegate;
                    final MutableState<TextFieldValue> mutableState2 = fromSec$delegate;
                    final MutableState<TextFieldValue> mutableState3 = toMin$delegate;
                    final MutableState<TextFieldValue> mutableState4 = toSec$delegate;
                    final MutableState<Boolean> mutableState5 = error$delegate;
                    ButtonsKt.ConfirmButton(null, false, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialog.1.1
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
                            VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function1, function0, mutableState, mutableState2, mutableState3, mutableState4, mutableState5);
                        }
                    }, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(758914718, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialog.2
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
                    Object value$iv6;
                    ComposerKt.sourceInformation($composer4, "C230@8553L22,230@8539L36:VideoSectionSlider.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(758914718, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.VideoClipDialog.<anonymous> (VideoSectionSlider.kt:230)");
                    }
                    $composer4.startReplaceGroup(-227890310);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    boolean invalid$iv2 = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    Object it$iv6 = $composer4.rememberedValue();
                    if (invalid$iv2 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                        value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$2$1$1
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
                        };
                        $composer4.updateRememberedValue(value$iv6);
                    } else {
                        value$iv6 = it$iv6;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv6, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$VideoSectionSliderKt.INSTANCE.m7253getLambda1$app_debug(), ComposableSingletons$VideoSectionSliderKt.INSTANCE.m7254getLambda2$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1250408645, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialog.3
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

                /* JADX WARN: Code duplicated, block: B:100:0x07fe  */
                /* JADX WARN: Code duplicated, block: B:101:0x0802  */
                /* JADX WARN: Code duplicated, block: B:104:0x0830  */
                /* JADX WARN: Code duplicated, block: B:108:0x0846 A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:112:0x08cc  */
                /* JADX WARN: Code duplicated, block: B:115:0x08d7  */
                /* JADX WARN: Code duplicated, block: B:116:0x08dd  */
                /* JADX WARN: Code duplicated, block: B:120:0x0945  */
                /* JADX WARN: Code duplicated, block: B:121:0x0959  */
                /* JADX WARN: Code duplicated, block: B:124:0x0a0d  */
                /* JADX WARN: Code duplicated, block: B:128:0x0a1a A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:132:0x0ac5  */
                /* JADX WARN: Code duplicated, block: B:133:0x0ad5  */
                /* JADX WARN: Code duplicated, block: B:136:0x0b5f  */
                /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:28:0x01e7  */
                /* JADX WARN: Code duplicated, block: B:31:0x01f3  */
                /* JADX WARN: Code duplicated, block: B:32:0x01f9  */
                /* JADX WARN: Code duplicated, block: B:35:0x022c  */
                /* JADX WARN: Code duplicated, block: B:38:0x023f  */
                /* JADX WARN: Code duplicated, block: B:39:0x0242  */
                /* JADX WARN: Code duplicated, block: B:43:0x0323  */
                /* JADX WARN: Code duplicated, block: B:46:0x032f  */
                /* JADX WARN: Code duplicated, block: B:47:0x0335  */
                /* JADX WARN: Code duplicated, block: B:50:0x0368  */
                /* JADX WARN: Code duplicated, block: B:54:0x037e A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:58:0x043d  */
                /* JADX WARN: Code duplicated, block: B:61:0x0449  */
                /* JADX WARN: Code duplicated, block: B:62:0x044f  */
                /* JADX WARN: Code duplicated, block: B:65:0x0482  */
                /* JADX WARN: Code duplicated, block: B:69:0x0498 A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:73:0x051c  */
                /* JADX WARN: Code duplicated, block: B:77:0x052c A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:81:0x0595  */
                /* JADX WARN: Code duplicated, block: B:82:0x05a5  */
                /* JADX WARN: Code duplicated, block: B:85:0x0657  */
                /* JADX WARN: Code duplicated, block: B:89:0x0664 A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:93:0x06c6  */
                /* JADX WARN: Code duplicated, block: B:94:0x06da  */
                /* JADX WARN: Code duplicated, block: B:97:0x07f2  */
                public final void invoke(Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    MeasurePolicy measurePolicy$iv;
                    MeasurePolicy measurePolicy$iv2;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function1;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    MeasurePolicy measurePolicy$iv3;
                    int compositeKeyHash$iv$iv2;
                    Function0<ComposeUiNode> constructor2;
                    Function0<ComposeUiNode> function2;
                    Composer $this$Layout_u24lambda_u240$iv$iv2;
                    int compositeKeyHash$iv$iv3;
                    Function0<ComposeUiNode> constructor3;
                    Function0<ComposeUiNode> function3;
                    Composer $this$Layout_u24lambda_u240$iv$iv3;
                    boolean invalid$iv2;
                    Object value$iv6;
                    Object it$iv6;
                    Object value$iv7;
                    boolean invalid$iv3;
                    Object value$iv8;
                    Object it$iv7;
                    final MutableState<TextFieldValue> mutableState;
                    Object value$iv9;
                    int compositeKeyHash$iv$iv4;
                    Modifier materialized$iv$iv;
                    Function0<ComposeUiNode> constructor4;
                    Composer $this$Layout_u24lambda_u240$iv$iv4;
                    boolean invalid$iv4;
                    Object it$iv8;
                    Modifier materialized$iv$iv2;
                    Object value$iv10;
                    Object it$iv9;
                    final MutableState<TextFieldValue> mutableState2;
                    Object value$iv11;
                    boolean invalid$iv5;
                    Object value$iv12;
                    Object it$iv10;
                    Object value$iv13;
                    ComposerKt.sourceInformation($composer4, "C232@8608L5056:VideoSectionSlider.kt#y3famj");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1250408645, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.VideoClipDialog.<anonymous> (VideoSectionSlider.kt:232)");
                    }
                    final String str5 = start;
                    final String str6 = minute;
                    final String str7 = second;
                    final MutableState<TextFieldValue> mutableState3 = fromMin$delegate;
                    final MutableState<Boolean> mutableState4 = error$delegate;
                    MutableState<TextFieldValue> mutableState5 = fromSec$delegate;
                    final String str8 = end;
                    MutableState<TextFieldValue> mutableState6 = toMin$delegate;
                    final MutableState<TextFieldValue> mutableState7 = toSec$delegate;
                    final IntRange intRange = valueIntRange;
                    final Function1<ClosedFloatingPointRange<Float>, Unit> function4 = onConfirm;
                    final Function0<Unit> function5 = onDismissRequest;
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function0 = constructor5;
                        $composer4.createNode(function0);
                    } else {
                        function0 = constructor5;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3547constructorimpl($composer4);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv5.getInserting()) {
                        measurePolicy$iv = measurePolicy$iv4;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -728359827, "C233@8635L5015:VideoSectionSlider.kt#y3famj");
                        Modifier modifier$iv2 = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv2 = (390 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function1 = constructor;
                            $composer4.createNode(function1);
                        } else {
                            function1 = constructor;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                            measurePolicy$iv3 = measurePolicy$iv2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            int i4 = ((390 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, 562078787, "C237@8816L2394,286@11231L155,290@11407L2225:VideoSectionSlider.kt#y3famj");
                            Modifier modifier$iv3 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 11, null);
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv3 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function2 = constructor2;
                                $composer4.createNode(function2);
                            } else {
                                function2 = constructor2;
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i6 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 918323873, "C242@9005L2183:VideoSectionSlider.kt#y3famj");
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Modifier modifier$iv4 = Modifier.INSTANCE;
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv4 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function3 = constructor3;
                                $composer4.createNode(function3);
                            } else {
                                function3 = constructor3;
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            int i8 = ((384 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u244 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1752954698, "C248@9303L115,252@9517L112,245@9141L864,265@10218L10,262@10034L235,270@10460L115,274@10674L112,267@10298L864:VideoSectionSlider.kt#y3famj");
                            Modifier modifierWeight$default = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u244, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer4.startReplaceGroup(1752954860);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            invalid$iv2 = $composer4.changed(str5) | $composer4.changed(str6);
                            value$iv6 = $composer4.rememberedValue();
                            if (!invalid$iv2 || value$iv6 == Composer.INSTANCE.getEmpty()) {
                                value$iv6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$1$1
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
                                        SemanticsPropertiesKt.setContentDescription(semantics, str5 + str6);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv6);
                            }
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierWeight$default, false, (Function1) value$iv6, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$11 = VideoSectionSliderKt.VideoClipDialog$lambda$11(mutableState3);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            boolean zVideoClipDialog$lambda$23 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(1752955074);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv6 = $composer4.rememberedValue();
                            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                                value$iv7 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$2$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState3.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv7);
                            } else {
                                value$iv7 = it$iv6;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$11, (Function1) value$iv7, modifierSemantics$default, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$23, null, keyboardOptions, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                            TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                            Modifier modifierWeight$default2 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u244, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer4.startReplaceGroup(1752956017);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            invalid$iv3 = $composer4.changed(str5) | $composer4.changed(str7);
                            Object it$iv11 = $composer4.rememberedValue();
                            if (!invalid$iv3 || it$iv11 == Composer.INSTANCE.getEmpty()) {
                                value$iv8 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$3$1
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
                                        SemanticsPropertiesKt.setContentDescription(semantics, str5 + str7);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv8);
                            } else {
                                value$iv8 = it$iv11;
                            }
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierWeight$default2, false, (Function1) value$iv8, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$18 = VideoSectionSliderKt.VideoClipDialog$lambda$17(mutableState5);
                            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            boolean zVideoClipDialog$lambda$24 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(1752956231);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv7 = $composer4.rememberedValue();
                            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                                mutableState = mutableState5;
                                value$iv9 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$4$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv9);
                            } else {
                                mutableState = mutableState5;
                                value$iv9 = it$iv7;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$18, (Function1) value$iv9, modifierSemantics$default2, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$24, null, keyboardOptions2, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            IconKt.m2044Iconww6aTOc(ArrowRightKt.getArrowRight(Icons.AutoMirrored.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer4, 48, 12);
                            Modifier modifier$iv5 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6553constructorimpl(6), 0.0f, 0.0f, 0.0f, 14, null);
                            Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv5 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                            materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(constructor4);
                            } else {
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer4);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash5);
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            int i10 = ((384 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, 918326535, "C299@11817L105,303@12011L102,296@11667L794,316@12658L10,313@12486L219,321@12880L105,325@13074L102,318@12730L880:VideoSectionSlider.kt#y3famj");
                            Modifier modifierWeight$default3 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer4.startReplaceGroup(918326685);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            invalid$iv4 = $composer4.changed(str8) | $composer4.changed(str6);
                            it$iv8 = $composer4.rememberedValue();
                            if (!invalid$iv4) {
                                materialized$iv$iv2 = materialized$iv$iv;
                                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                    value$iv10 = it$iv8;
                                }
                                $composer4.endReplaceGroup();
                                Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierWeight$default3, false, (Function1) value$iv10, 1, null);
                                TextFieldValue textFieldValueVideoClipDialog$lambda$15 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                                KeyboardOptions keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                                boolean zVideoClipDialog$lambda$25 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                                $composer4.startReplaceGroup(918326879);
                                ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                                it$iv9 = $composer4.rememberedValue();
                                if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                                    mutableState2 = mutableState6;
                                    value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            CharSequence $this$isDigitsOnly$iv = it.getText();
                                            if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                                return;
                                            }
                                            mutableState2.setValue(it);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv11);
                                } else {
                                    mutableState2 = mutableState6;
                                    value$iv11 = it$iv9;
                                }
                                $composer4.endReplaceGroup();
                                TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$15, (Function1) value$iv11, modifierSemantics$default3, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$25, null, keyboardOptions3, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                                TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                                Modifier modifierWeight$default4 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410, Modifier.INSTANCE, 1.0f, false, 2, null);
                                $composer4.startReplaceGroup(918327748);
                                ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                                invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                                Object it$iv12 = $composer4.rememberedValue();
                                if (!invalid$iv5 || it$iv12 == Composer.INSTANCE.getEmpty()) {
                                    value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                                            SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv12);
                                } else {
                                    value$iv12 = it$iv12;
                                }
                                $composer4.endReplaceGroup();
                                Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierWeight$default4, false, (Function1) value$iv12, 1, null);
                                TextFieldValue textFieldValueVideoClipDialog$lambda$21 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                                KeyboardOptions keyboardOptions4 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                                final MutableState<TextFieldValue> mutableState8 = mutableState;
                                KeyboardActions keyboardActions = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                                    public final void invoke2(KeyboardActionScope $receiver) {
                                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                        VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState8, mutableState2, mutableState7, mutableState4);
                                    }
                                }, null, null, null, null, null, 62, null);
                                boolean zVideoClipDialog$lambda$26 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                                $composer4.startReplaceGroup(918327942);
                                ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                                it$iv10 = $composer4.rememberedValue();
                                if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                                    value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            CharSequence $this$isDigitsOnly$iv = it.getText();
                                            if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                                return;
                                            }
                                            mutableState7.setValue(it);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv13);
                                } else {
                                    value$iv13 = it$iv10;
                                }
                                $composer4.endReplaceGroup();
                                TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$21, (Function1) value$iv13, modifierSemantics$default4, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$26, null, keyboardOptions4, keyboardActions, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            materialized$iv$iv2 = materialized$iv$iv;
                            value$iv10 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$1$1
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, str8 + str6);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv10);
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifierWeight$default3, false, (Function1) value$iv10, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$16 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                            KeyboardOptions keyboardOptions5 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            boolean zVideoClipDialog$lambda$27 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(918326879);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv9 = $composer4.rememberedValue();
                            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState6;
                                value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState2.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv11);
                            } else {
                                mutableState2 = mutableState6;
                                value$iv11 = it$iv9;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$16, (Function1) value$iv11, modifierSemantics$default5, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$27, null, keyboardOptions5, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                            TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                            Modifier modifierWeight$default5 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer4.startReplaceGroup(918327748);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                            Object it$iv13 = $composer4.rememberedValue();
                            if (invalid$iv5) {
                            }
                            value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv12);
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifierWeight$default5, false, (Function1) value$iv12, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$22 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                            KeyboardOptions keyboardOptions6 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            final MutableState<TextFieldValue> mutableState9 = mutableState;
                            KeyboardActions keyboardActions2 = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                                public final void invoke2(KeyboardActionScope $receiver) {
                                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                    VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState9, mutableState2, mutableState7, mutableState4);
                                }
                            }, null, null, null, null, null, 62, null);
                            boolean zVideoClipDialog$lambda$28 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(918327942);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv10 = $composer4.rememberedValue();
                            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                                value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState7.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv13);
                            } else {
                                value$iv13 = it$iv10;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$22, (Function1) value$iv13, modifierSemantics$default6, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$28, null, keyboardOptions6, keyboardActions2, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        measurePolicy$iv3 = measurePolicy$iv2;
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i12 = ((390 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u2412_u24lambda_u2412 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 562078787, "C237@8816L2394,286@11231L155,290@11407L2225:VideoSectionSlider.kt#y3famj");
                        Modifier modifier$iv6 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv8 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv6 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function2 = constructor2;
                            $composer4.createNode(function2);
                        } else {
                            function2 = constructor2;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                        int i13 = ($changed$iv$iv$iv6 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                        int i14 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 918323873, "C242@9005L2183:VideoSectionSlider.kt#y3famj");
                        Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv7 = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv9 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv7 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv7 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer4, modifier$iv7);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function3 = constructor3;
                            $composer4.createNode(function3);
                        } else {
                            function3 = constructor3;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash7);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                        int i15 = ($changed$iv$iv$iv7 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i16 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u245 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1752954698, "C248@9303L115,252@9517L112,245@9141L864,265@10218L10,262@10034L235,270@10460L115,274@10674L112,267@10298L864:VideoSectionSlider.kt#y3famj");
                        Modifier modifierWeight$default6 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u245, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(1752954860);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv2 = $composer4.changed(str5) | $composer4.changed(str6);
                        value$iv6 = $composer4.rememberedValue();
                        if (!invalid$iv2) {
                        }
                        value$iv6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$1$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str5 + str6);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv6);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifierWeight$default6, false, (Function1) value$iv6, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$12 = VideoSectionSliderKt.VideoClipDialog$lambda$11(mutableState3);
                        KeyboardOptions keyboardOptions7 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        boolean zVideoClipDialog$lambda$29 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(1752955074);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv6 = $composer4.rememberedValue();
                        if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                            value$iv7 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$2$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState3.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv7);
                        } else {
                            value$iv7 = it$iv6;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$12, (Function1) value$iv7, modifierSemantics$default7, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$29, null, keyboardOptions7, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                        TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                        Modifier modifierWeight$default7 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u245, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(1752956017);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv3 = $composer4.changed(str5) | $composer4.changed(str7);
                        Object it$iv14 = $composer4.rememberedValue();
                        if (invalid$iv3) {
                        }
                        value$iv8 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$3$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str5 + str7);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv8);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifierWeight$default7, false, (Function1) value$iv8, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$19 = VideoSectionSliderKt.VideoClipDialog$lambda$17(mutableState5);
                        KeyboardOptions keyboardOptions8 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        boolean zVideoClipDialog$lambda$210 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(1752956231);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv7 = $composer4.rememberedValue();
                        if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                            mutableState = mutableState5;
                            value$iv9 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$4$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv9);
                        } else {
                            mutableState = mutableState5;
                            value$iv9 = it$iv7;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$19, (Function1) value$iv9, modifierSemantics$default8, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$210, null, keyboardOptions8, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconKt.m2044Iconww6aTOc(ArrowRightKt.getArrowRight(Icons.AutoMirrored.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer4, 48, 12);
                        Modifier modifier$iv8 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6553constructorimpl(6), 0.0f, 0.0f, 0.0f, 14, null);
                        Alignment.Vertical verticalAlignment$iv5 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv10 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv8 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv8 = $composer4.getCurrentCompositionLocalMap();
                        materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv8);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(constructor4);
                        } else {
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash8);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i17 = ($changed$iv$iv$iv8 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i18 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2411 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 918326535, "C299@11817L105,303@12011L102,296@11667L794,316@12658L10,313@12486L219,321@12880L105,325@13074L102,318@12730L880:VideoSectionSlider.kt#y3famj");
                        Modifier modifierWeight$default8 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(918326685);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv4 = $composer4.changed(str8) | $composer4.changed(str6);
                        it$iv8 = $composer4.rememberedValue();
                        if (!invalid$iv4) {
                            materialized$iv$iv2 = materialized$iv$iv;
                            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                value$iv10 = it$iv8;
                            }
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifierWeight$default8, false, (Function1) value$iv10, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$110 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                            KeyboardOptions keyboardOptions9 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            boolean zVideoClipDialog$lambda$211 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(918326879);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv9 = $composer4.rememberedValue();
                            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState6;
                                value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState2.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv11);
                            } else {
                                mutableState2 = mutableState6;
                                value$iv11 = it$iv9;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$110, (Function1) value$iv11, modifierSemantics$default9, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$211, null, keyboardOptions9, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                            TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                            Modifier modifierWeight$default9 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer4.startReplaceGroup(918327748);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                            Object it$iv15 = $composer4.rememberedValue();
                            if (invalid$iv5) {
                            }
                            value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv12);
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(modifierWeight$default9, false, (Function1) value$iv12, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$23 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                            KeyboardOptions keyboardOptions10 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            final MutableState<TextFieldValue> mutableState10 = mutableState;
                            KeyboardActions keyboardActions3 = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                                public final void invoke2(KeyboardActionScope $receiver) {
                                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                    VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState10, mutableState2, mutableState7, mutableState4);
                                }
                            }, null, null, null, null, null, 62, null);
                            boolean zVideoClipDialog$lambda$212 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(918327942);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv10 = $composer4.rememberedValue();
                            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                                value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState7.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv13);
                            } else {
                                value$iv13 = it$iv10;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$23, (Function1) value$iv13, modifierSemantics$default10, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$212, null, keyboardOptions10, keyboardActions3, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        materialized$iv$iv2 = materialized$iv$iv;
                        value$iv10 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$1$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str8 + str6);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv10);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(modifierWeight$default8, false, (Function1) value$iv10, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$111 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                        KeyboardOptions keyboardOptions11 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        boolean zVideoClipDialog$lambda$213 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(918326879);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv9 = $composer4.rememberedValue();
                        if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                            mutableState2 = mutableState6;
                            value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState2.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv11);
                        } else {
                            mutableState2 = mutableState6;
                            value$iv11 = it$iv9;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$111, (Function1) value$iv11, modifierSemantics$default11, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$213, null, keyboardOptions11, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                        TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                        Modifier modifierWeight$default10 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(918327748);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                        Object it$iv16 = $composer4.rememberedValue();
                        if (invalid$iv5) {
                        }
                        value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv12);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(modifierWeight$default10, false, (Function1) value$iv12, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$24 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                        KeyboardOptions keyboardOptions12 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        final MutableState<TextFieldValue> mutableState11 = mutableState;
                        KeyboardActions keyboardActions4 = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                            public final void invoke2(KeyboardActionScope $receiver) {
                                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState11, mutableState2, mutableState7, mutableState4);
                            }
                        }, null, null, null, null, null, 62, null);
                        boolean zVideoClipDialog$lambda$214 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(918327942);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv10 = $composer4.rememberedValue();
                        if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                            value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState7.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv13);
                        } else {
                            value$iv13 = it$iv10;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$24, (Function1) value$iv13, modifierSemantics$default12, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$214, null, keyboardOptions12, keyboardActions4, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    measurePolicy$iv = measurePolicy$iv4;
                    $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
                    $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i19 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    int i20 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -728359827, "C233@8635L5015:VideoSectionSlider.kt#y3famj");
                    Modifier modifier$iv9 = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null);
                    Alignment.Vertical verticalAlignment$iv6 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv6 = Arrangement.INSTANCE.getStart();
                    measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv6, verticalAlignment$iv6, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv9 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv9 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer4, modifier$iv9);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function1 = constructor;
                        $composer4.createNode(function1);
                    } else {
                        function1 = constructor;
                        $composer4.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        measurePolicy$iv3 = measurePolicy$iv2;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                        int i110 = ($changed$iv$iv$iv9 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i111 = ((390 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u2412_u24lambda_u2413 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 562078787, "C237@8816L2394,286@11231L155,290@11407L2225:VideoSectionSlider.kt#y3famj");
                        Modifier modifier$iv10 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv11 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv10 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv10 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv10 = ComposedModifierKt.materializeModifier($composer4, modifier$iv10);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv10 = (($changed$iv$iv10 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function2 = constructor2;
                            $composer4.createNode(function2);
                        } else {
                            function2 = constructor2;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash10);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv10, ComposeUiNode.INSTANCE.getSetModifier());
                        int i112 = ($changed$iv$iv$iv10 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                        int i113 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 918323873, "C242@9005L2183:VideoSectionSlider.kt#y3famj");
                        Alignment.Vertical verticalAlignment$iv7 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv11 = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv7 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv12 = RowKt.rowMeasurePolicy(horizontalArrangement$iv7, verticalAlignment$iv7, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv11 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv11 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer4, modifier$iv11);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv11 = (($changed$iv$iv11 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function3 = constructor3;
                            $composer4.createNode(function3);
                        } else {
                            function3 = constructor3;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash11);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
                        int i114 = ($changed$iv$iv$iv11 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i115 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u246 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1752954698, "C248@9303L115,252@9517L112,245@9141L864,265@10218L10,262@10034L235,270@10460L115,274@10674L112,267@10298L864:VideoSectionSlider.kt#y3famj");
                        Modifier modifierWeight$default11 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(1752954860);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv2 = $composer4.changed(str5) | $composer4.changed(str6);
                        value$iv6 = $composer4.rememberedValue();
                        if (!invalid$iv2) {
                        }
                        value$iv6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$1$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str5 + str6);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv6);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(modifierWeight$default11, false, (Function1) value$iv6, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$13 = VideoSectionSliderKt.VideoClipDialog$lambda$11(mutableState3);
                        KeyboardOptions keyboardOptions13 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        boolean zVideoClipDialog$lambda$215 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(1752955074);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv6 = $composer4.rememberedValue();
                        if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                            value$iv7 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$2$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState3.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv7);
                        } else {
                            value$iv7 = it$iv6;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$13, (Function1) value$iv7, modifierSemantics$default13, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$215, null, keyboardOptions13, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                        TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                        Modifier modifierWeight$default12 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(1752956017);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv3 = $composer4.changed(str5) | $composer4.changed(str7);
                        Object it$iv17 = $composer4.rememberedValue();
                        if (invalid$iv3) {
                        }
                        value$iv8 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$3$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str5 + str7);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv8);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(modifierWeight$default12, false, (Function1) value$iv8, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$112 = VideoSectionSliderKt.VideoClipDialog$lambda$17(mutableState5);
                        KeyboardOptions keyboardOptions14 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        boolean zVideoClipDialog$lambda$216 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(1752956231);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv7 = $composer4.rememberedValue();
                        if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                            mutableState = mutableState5;
                            value$iv9 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$4$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv9);
                        } else {
                            mutableState = mutableState5;
                            value$iv9 = it$iv7;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$112, (Function1) value$iv9, modifierSemantics$default14, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$216, null, keyboardOptions14, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconKt.m2044Iconww6aTOc(ArrowRightKt.getArrowRight(Icons.AutoMirrored.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer4, 48, 12);
                        Modifier modifier$iv12 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6553constructorimpl(6), 0.0f, 0.0f, 0.0f, 14, null);
                        Alignment.Vertical verticalAlignment$iv8 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv8 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv13 = RowKt.rowMeasurePolicy(horizontalArrangement$iv8, verticalAlignment$iv8, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv12 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv12 = $composer4.getCurrentCompositionLocalMap();
                        materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv12);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv12 = (($changed$iv$iv12 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(constructor4);
                        } else {
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash12);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i116 = ($changed$iv$iv$iv12 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i117 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2412 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 918326535, "C299@11817L105,303@12011L102,296@11667L794,316@12658L10,313@12486L219,321@12880L105,325@13074L102,318@12730L880:VideoSectionSlider.kt#y3famj");
                        Modifier modifierWeight$default13 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(918326685);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv4 = $composer4.changed(str8) | $composer4.changed(str6);
                        it$iv8 = $composer4.rememberedValue();
                        if (!invalid$iv4) {
                            materialized$iv$iv2 = materialized$iv$iv;
                            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                                value$iv10 = it$iv8;
                            }
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(modifierWeight$default13, false, (Function1) value$iv10, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$113 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                            KeyboardOptions keyboardOptions15 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            boolean zVideoClipDialog$lambda$217 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(918326879);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv9 = $composer4.rememberedValue();
                            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState6;
                                value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState2.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv11);
                            } else {
                                mutableState2 = mutableState6;
                                value$iv11 = it$iv9;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$113, (Function1) value$iv11, modifierSemantics$default15, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$217, null, keyboardOptions15, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                            TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                            Modifier modifierWeight$default14 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer4.startReplaceGroup(918327748);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                            Object it$iv18 = $composer4.rememberedValue();
                            if (invalid$iv5) {
                            }
                            value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv12);
                            $composer4.endReplaceGroup();
                            Modifier modifierSemantics$default16 = SemanticsModifierKt.semantics$default(modifierWeight$default14, false, (Function1) value$iv12, 1, null);
                            TextFieldValue textFieldValueVideoClipDialog$lambda$25 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                            KeyboardOptions keyboardOptions16 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                            final MutableState<TextFieldValue> mutableState12 = mutableState;
                            KeyboardActions keyboardActions5 = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                                public final void invoke2(KeyboardActionScope $receiver) {
                                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                    VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState12, mutableState2, mutableState7, mutableState4);
                                }
                            }, null, null, null, null, null, 62, null);
                            boolean zVideoClipDialog$lambda$218 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                            $composer4.startReplaceGroup(918327942);
                            ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                            it$iv10 = $composer4.rememberedValue();
                            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                                value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        CharSequence $this$isDigitsOnly$iv = it.getText();
                                        if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                            return;
                                        }
                                        mutableState7.setValue(it);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv13);
                            } else {
                                value$iv13 = it$iv10;
                            }
                            $composer4.endReplaceGroup();
                            TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$25, (Function1) value$iv13, modifierSemantics$default16, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$218, null, keyboardOptions16, keyboardActions5, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        materialized$iv$iv2 = materialized$iv$iv;
                        value$iv10 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$1$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str8 + str6);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv10);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default17 = SemanticsModifierKt.semantics$default(modifierWeight$default13, false, (Function1) value$iv10, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$114 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                        KeyboardOptions keyboardOptions17 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        boolean zVideoClipDialog$lambda$219 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(918326879);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv9 = $composer4.rememberedValue();
                        if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                            mutableState2 = mutableState6;
                            value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState2.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv11);
                        } else {
                            mutableState2 = mutableState6;
                            value$iv11 = it$iv9;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$114, (Function1) value$iv11, modifierSemantics$default17, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$219, null, keyboardOptions17, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                        TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                        Modifier modifierWeight$default15 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(918327748);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                        Object it$iv19 = $composer4.rememberedValue();
                        if (invalid$iv5) {
                        }
                        value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv12);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default18 = SemanticsModifierKt.semantics$default(modifierWeight$default15, false, (Function1) value$iv12, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$26 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                        KeyboardOptions keyboardOptions18 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        final MutableState<TextFieldValue> mutableState13 = mutableState;
                        KeyboardActions keyboardActions6 = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                            public final void invoke2(KeyboardActionScope $receiver) {
                                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState13, mutableState2, mutableState7, mutableState4);
                            }
                        }, null, null, null, null, null, 62, null);
                        boolean zVideoClipDialog$lambda$2110 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(918327942);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv10 = $composer4.rememberedValue();
                        if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                            value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState7.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv13);
                        } else {
                            value$iv13 = it$iv10;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$26, (Function1) value$iv13, modifierSemantics$default18, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$2110, null, keyboardOptions18, keyboardActions6, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    measurePolicy$iv3 = measurePolicy$iv2;
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash9);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                    int i118 = ($changed$iv$iv$iv9 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i119 = ((390 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u2412_u24lambda_u2414 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, 562078787, "C237@8816L2394,286@11231L155,290@11407L2225:VideoSectionSlider.kt#y3famj");
                    Modifier modifier$iv13 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2414, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 11, null);
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv5 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv5 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv14 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv5, horizontalAlignment$iv5, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv13 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv13 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv12 = ComposedModifierKt.materializeModifier($composer4, modifier$iv13);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv13 = (($changed$iv$iv13 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function2 = constructor2;
                        $composer4.createNode(function2);
                    } else {
                        function2 = constructor2;
                        $composer4.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash13);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv12, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1110 = ($changed$iv$iv$iv13 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                    int i1111 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 918323873, "C242@9005L2183:VideoSectionSlider.kt#y3famj");
                    Alignment.Vertical verticalAlignment$iv9 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Modifier modifier$iv14 = Modifier.INSTANCE;
                    Arrangement.Horizontal horizontalArrangement$iv9 = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv15 = RowKt.rowMeasurePolicy(horizontalArrangement$iv9, verticalAlignment$iv9, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv14 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv14 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv13 = ComposedModifierKt.materializeModifier($composer4, modifier$iv14);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv14 = (($changed$iv$iv14 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function3 = constructor3;
                        $composer4.createNode(function3);
                    } else {
                        function3 = constructor3;
                        $composer4.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash14);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv13, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1112 = ($changed$iv$iv$iv14 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i1113 = ((384 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u247 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1752954698, "C248@9303L115,252@9517L112,245@9141L864,265@10218L10,262@10034L235,270@10460L115,274@10674L112,267@10298L864:VideoSectionSlider.kt#y3famj");
                    Modifier modifierWeight$default16 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null);
                    $composer4.startReplaceGroup(1752954860);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    invalid$iv2 = $composer4.changed(str5) | $composer4.changed(str6);
                    value$iv6 = $composer4.rememberedValue();
                    if (!invalid$iv2) {
                    }
                    value$iv6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$1$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, str5 + str6);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv6);
                    $composer4.endReplaceGroup();
                    Modifier modifierSemantics$default19 = SemanticsModifierKt.semantics$default(modifierWeight$default16, false, (Function1) value$iv6, 1, null);
                    TextFieldValue textFieldValueVideoClipDialog$lambda$115 = VideoSectionSliderKt.VideoClipDialog$lambda$11(mutableState3);
                    KeyboardOptions keyboardOptions19 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                    boolean zVideoClipDialog$lambda$2111 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                    $composer4.startReplaceGroup(1752955074);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    it$iv6 = $composer4.rememberedValue();
                    if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                        value$iv7 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$2$1
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
                                Intrinsics.checkNotNullParameter(it, "it");
                                CharSequence $this$isDigitsOnly$iv = it.getText();
                                if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                    return;
                                }
                                mutableState3.setValue(it);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv7);
                    } else {
                        value$iv7 = it$iv6;
                    }
                    $composer4.endReplaceGroup();
                    TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$115, (Function1) value$iv7, modifierSemantics$default19, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$2111, null, keyboardOptions19, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                    TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                    Modifier modifierWeight$default17 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u245_u24lambda_u247, Modifier.INSTANCE, 1.0f, false, 2, null);
                    $composer4.startReplaceGroup(1752956017);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    invalid$iv3 = $composer4.changed(str5) | $composer4.changed(str7);
                    Object it$iv110 = $composer4.rememberedValue();
                    if (invalid$iv3) {
                    }
                    value$iv8 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$3$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, str5 + str7);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv8);
                    $composer4.endReplaceGroup();
                    Modifier modifierSemantics$default110 = SemanticsModifierKt.semantics$default(modifierWeight$default17, false, (Function1) value$iv8, 1, null);
                    TextFieldValue textFieldValueVideoClipDialog$lambda$116 = VideoSectionSliderKt.VideoClipDialog$lambda$17(mutableState5);
                    KeyboardOptions keyboardOptions110 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                    boolean zVideoClipDialog$lambda$2112 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                    $composer4.startReplaceGroup(1752956231);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    it$iv7 = $composer4.rememberedValue();
                    if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                        mutableState = mutableState5;
                        value$iv9 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$1$1$4$1
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
                                Intrinsics.checkNotNullParameter(it, "it");
                                CharSequence $this$isDigitsOnly$iv = it.getText();
                                if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                    return;
                                }
                                mutableState.setValue(it);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv9);
                    } else {
                        mutableState = mutableState5;
                        value$iv9 = it$iv7;
                    }
                    $composer4.endReplaceGroup();
                    TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$116, (Function1) value$iv9, modifierSemantics$default110, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$2112, null, keyboardOptions110, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    IconKt.m2044Iconww6aTOc(ArrowRightKt.getArrowRight(Icons.AutoMirrored.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer4, 48, 12);
                    Modifier modifier$iv15 = PaddingKt.m624paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2414, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6553constructorimpl(6), 0.0f, 0.0f, 0.0f, 14, null);
                    Alignment.Vertical verticalAlignment$iv10 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv10 = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv16 = RowKt.rowMeasurePolicy(horizontalArrangement$iv10, verticalAlignment$iv10, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv15 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv15 = $composer4.getCurrentCompositionLocalMap();
                    materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv15);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv15 = (($changed$iv$iv15 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(constructor4);
                    } else {
                        $composer4.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer4);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                    $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash15);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1114 = ($changed$iv$iv$iv15 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i1115 = ((384 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2413 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, 918326535, "C299@11817L105,303@12011L102,296@11667L794,316@12658L10,313@12486L219,321@12880L105,325@13074L102,318@12730L880:VideoSectionSlider.kt#y3famj");
                    Modifier modifierWeight$default18 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null);
                    $composer4.startReplaceGroup(918326685);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    invalid$iv4 = $composer4.changed(str8) | $composer4.changed(str6);
                    it$iv8 = $composer4.rememberedValue();
                    if (!invalid$iv4) {
                        materialized$iv$iv2 = materialized$iv$iv;
                        if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                            value$iv10 = it$iv8;
                        }
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default111 = SemanticsModifierKt.semantics$default(modifierWeight$default18, false, (Function1) value$iv10, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$117 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                        KeyboardOptions keyboardOptions111 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        boolean zVideoClipDialog$lambda$2113 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(918326879);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv9 = $composer4.rememberedValue();
                        if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                            mutableState2 = mutableState6;
                            value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState2.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv11);
                        } else {
                            mutableState2 = mutableState6;
                            value$iv11 = it$iv9;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$117, (Function1) value$iv11, modifierSemantics$default111, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$2113, null, keyboardOptions111, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                        TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                        Modifier modifierWeight$default19 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer4.startReplaceGroup(918327748);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                        Object it$iv111 = $composer4.rememberedValue();
                        if (invalid$iv5) {
                        }
                        value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv12);
                        $composer4.endReplaceGroup();
                        Modifier modifierSemantics$default112 = SemanticsModifierKt.semantics$default(modifierWeight$default19, false, (Function1) value$iv12, 1, null);
                        TextFieldValue textFieldValueVideoClipDialog$lambda$27 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                        KeyboardOptions keyboardOptions112 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                        final MutableState<TextFieldValue> mutableState14 = mutableState;
                        KeyboardActions keyboardActions7 = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                            public final void invoke2(KeyboardActionScope $receiver) {
                                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState14, mutableState2, mutableState7, mutableState4);
                            }
                        }, null, null, null, null, null, 62, null);
                        boolean zVideoClipDialog$lambda$2114 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                        $composer4.startReplaceGroup(918327942);
                        ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                        it$iv10 = $composer4.rememberedValue();
                        if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                            value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    CharSequence $this$isDigitsOnly$iv = it.getText();
                                    if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                        return;
                                    }
                                    mutableState7.setValue(it);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv13);
                        } else {
                            value$iv13 = it$iv10;
                        }
                        $composer4.endReplaceGroup();
                        TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$27, (Function1) value$iv13, modifierSemantics$default112, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$2114, null, keyboardOptions112, keyboardActions7, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    materialized$iv$iv2 = materialized$iv$iv;
                    value$iv10 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$1$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, str8 + str6);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv10);
                    $composer4.endReplaceGroup();
                    Modifier modifierSemantics$default113 = SemanticsModifierKt.semantics$default(modifierWeight$default18, false, (Function1) value$iv10, 1, null);
                    TextFieldValue textFieldValueVideoClipDialog$lambda$118 = VideoSectionSliderKt.VideoClipDialog$lambda$14(mutableState6);
                    KeyboardOptions keyboardOptions113 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                    boolean zVideoClipDialog$lambda$2115 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                    $composer4.startReplaceGroup(918326879);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    it$iv9 = $composer4.rememberedValue();
                    if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                        mutableState2 = mutableState6;
                        value$iv11 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$2$1
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
                                Intrinsics.checkNotNullParameter(it, "it");
                                CharSequence $this$isDigitsOnly$iv = it.getText();
                                if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                    return;
                                }
                                mutableState2.setValue(it);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv11);
                    } else {
                        mutableState2 = mutableState6;
                        value$iv11 = it$iv9;
                    }
                    $composer4.endReplaceGroup();
                    TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$118, (Function1) value$iv11, modifierSemantics$default113, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$2115, null, keyboardOptions113, null, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8216568);
                    TextKt.m2569Text4IGK_g(":", PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelLarge(), $composer4, 54, 0, 65532);
                    Modifier modifierWeight$default110 = RowScope.CC.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null);
                    $composer4.startReplaceGroup(918327748);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    invalid$iv5 = $composer4.changed(str8) | $composer4.changed(str7);
                    Object it$iv112 = $composer4.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv12 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$3$1
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
                            SemanticsPropertiesKt.setContentDescription(semantics, str8 + str7);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv12);
                    $composer4.endReplaceGroup();
                    Modifier modifierSemantics$default114 = SemanticsModifierKt.semantics$default(modifierWeight$default110, false, (Function1) value$iv12, 1, null);
                    TextFieldValue textFieldValueVideoClipDialog$lambda$28 = VideoSectionSliderKt.VideoClipDialog$lambda$20(mutableState7);
                    KeyboardOptions keyboardOptions114 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6242getNumberPasswordPjHm6EE(), ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                    final MutableState<TextFieldValue> mutableState15 = mutableState;
                    KeyboardActions keyboardActions8 = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$4
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
                        public final void invoke2(KeyboardActionScope $receiver) {
                            Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                            VideoSectionSliderKt.VideoClipDialog$onDone(intRange, function4, function5, mutableState3, mutableState15, mutableState2, mutableState7, mutableState4);
                        }
                    }, null, null, null, null, null, 62, null);
                    boolean zVideoClipDialog$lambda$2116 = VideoSectionSliderKt.VideoClipDialog$lambda$23(mutableState4);
                    $composer4.startReplaceGroup(918327942);
                    ComposerKt.sourceInformation($composer4, "CC(remember):VideoSectionSlider.kt#9igjgp");
                    it$iv10 = $composer4.rememberedValue();
                    if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                        value$iv13 = new Function1<TextFieldValue, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$VideoClipDialog$3$1$1$2$5$1
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
                                Intrinsics.checkNotNullParameter(it, "it");
                                CharSequence $this$isDigitsOnly$iv = it.getText();
                                if (!TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                    return;
                                }
                                mutableState7.setValue(it);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv13);
                    } else {
                        value$iv13 = it$iv10;
                    }
                    $composer4.endReplaceGroup();
                    TextFieldKt.LoopTextField(textFieldValueVideoClipDialog$lambda$28, (Function1) value$iv13, modifierSemantics$default114, false, false, null, null, null, null, null, null, null, null, zVideoClipDialog$lambda$2116, null, keyboardOptions114, keyboardActions8, true, 0, 0, null, null, null, $composer4, 48, 12779520, 0, 8151032);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer3, (($dirty2 << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialog.4
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
                    VideoSectionSliderKt.VideoClipDialog(onDismissRequest, initialValue, valueRange, onConfirm, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue VideoClipDialog$lambda$11(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue VideoClipDialog$lambda$14(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue VideoClipDialog$lambda$17(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue VideoClipDialog$lambda$20(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoClipDialog$lambda$23(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    private static final void VideoClipDialog$lambda$24(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoClipDialog$onDone(IntRange valueIntRange, Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Function0<Unit> function0, MutableState<TextFieldValue> mutableState, MutableState<TextFieldValue> mutableState2, MutableState<TextFieldValue> mutableState3, MutableState<TextFieldValue> mutableState4, MutableState<Boolean> mutableState5) {
        int startTime = convertToSecs(VideoClipDialog$lambda$11(mutableState).getText(), VideoClipDialog$lambda$17(mutableState2).getText());
        int endTime = convertToSecs(VideoClipDialog$lambda$14(mutableState3).getText(), VideoClipDialog$lambda$20(mutableState4).getText());
        if (startTime != -1 && endTime != -1 && startTime < endTime && valueIntRange.contains(startTime) && valueIntRange.contains(endTime)) {
            function1.invoke(RangesKt.rangeTo(startTime, endTime));
            function0.invoke();
        } else {
            VideoClipDialog$lambda$24(mutableState5, true);
        }
    }

    public static final void VideoClipDialogPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(809961815);
        ComposerKt.sourceInformation($composer2, "C(VideoClipDialogPreview)345@13735L126:VideoSectionSlider.kt#y3famj");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(809961815, $changed, -1, "com.videshkarmakar.loop.ui.page.download.VideoClipDialogPreview (VideoSectionSlider.kt:344)");
            }
            VideoClipDialog(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialogPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, RangesKt.rangeTo(0.0f, 560.0f), RangesKt.rangeTo(0.0f, 660.0f), new Function1<ClosedFloatingPointRange<Float>, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialogPreview.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
                    invoke2(closedFloatingPointRange);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClosedFloatingPointRange<Float> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            }, $composer2, 3078);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.VideoClipDialogPreview.3
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
                    VideoSectionSliderKt.VideoClipDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void SliderPreview(Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(991344045);
        ComposerKt.sourceInformation($composer2, "C(SliderPreview)356@13990L59,359@14074L46,362@14137L288,372@14430L147,376@14592L175,376@14582L185:VideoSectionSlider.kt#y3famj");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(991344045, $changed, -1, "com.videshkarmakar.loop.ui.page.download.SliderPreview (VideoSectionSlider.kt:354)");
            }
            $composer2.startReplaceGroup(443827650);
            ComposerKt.sourceInformation($composer2, "CC(remember):VideoSectionSlider.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(RangesKt.rangeTo(0.0f, 3700), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState valueRange$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(443827734);
            ComposerKt.sourceInformation($composer2, "CC(remember):VideoSectionSlider.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState shouldUpdate$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(443827797);
            ComposerKt.sourceInformation($composer2, "CC(remember):VideoSectionSlider.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new RangeSliderState(SliderPreview$lambda$26(valueRange$delegate).getStart().floatValue(), SliderPreview$lambda$26(valueRange$delegate).getEndInclusive().floatValue(), 0, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$SliderPreview$state$1$1
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
                        VideoSectionSliderKt.SliderPreview$lambda$30(shouldUpdate$delegate, true);
                    }
                }, RangesKt.rangeTo(0.0f, 3700), 4, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final RangeSliderState state = (RangeSliderState) value$iv3;
            $composer2.endReplaceGroup();
            EffectsKt.DisposableEffect(Boolean.valueOf(SliderPreview$lambda$29(shouldUpdate$delegate)), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.SliderPreview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    VideoSectionSliderKt.SliderPreview$lambda$27(valueRange$delegate, RangesKt.rangeTo(state.getActiveRangeStart(), state.getActiveRangeEnd()));
                    final MutableState<Boolean> mutableState = shouldUpdate$delegate;
                    return new DisposableEffectResult() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$SliderPreview$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            VideoSectionSliderKt.SliderPreview$lambda$30(mutableState, false);
                        }
                    };
                }
            }, $composer2, 0);
            SurfaceKt.m2418SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1639710344, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.SliderPreview.2
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
                    ComposerKt.sourceInformation($composer3, "C377@14602L159:VideoSectionSlider.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1639710344, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.SliderPreview.<anonymous> (VideoSectionSlider.kt:377)");
                        }
                        RangeSliderState rangeSliderState = state;
                        MutableState<ClosedFloatingPointRange<Float>> mutableState = valueRange$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
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
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -996241667, "C378@14623L41,379@14677L73:VideoSectionSlider.kt#y3famj");
                        TextKt.m2569Text4IGK_g(String.valueOf(TextUtilKt.toIntRange(VideoSectionSliderKt.SliderPreview$lambda$26(mutableState))), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        Function0 factory$iv$iv$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$SliderPreview$2$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }
                        };
                        VideoSectionSliderKt.VideoSelectionSlider(null, rangeSliderState, factory$iv$iv$iv, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt$SliderPreview$2$1$2
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }
                        }, $composer3, (RangeSliderState.$stable << 3) | 3456, 1);
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
            }, $composer2, 54), $composer2, 12582912, 127);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.VideoSectionSliderKt.SliderPreview.3
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
                    VideoSectionSliderKt.SliderPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> SliderPreview$lambda$26(MutableState<ClosedFloatingPointRange<Float>> mutableState) {
        MutableState<ClosedFloatingPointRange<Float>> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SliderPreview$lambda$27(MutableState<ClosedFloatingPointRange<Float>> mutableState, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        mutableState.setValue(closedFloatingPointRange);
    }

    private static final boolean SliderPreview$lambda$29(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SliderPreview$lambda$30(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final int convertToSecs(String min, String sec) {
        if (TextUtilKt.isNumberInRange(sec, 0, 60) && TextUtilKt.isNumberInRange(min, 0, Integer.MAX_VALUE)) {
            return (Integer.parseInt(min) * 60) + Integer.parseInt(sec);
        }
        return -1;
    }
}
