package com.videshkarmakar.loop.ui.page.settings.format;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.OpenInNewKt;
import androidx.compose.material.icons.outlined.SettingsSuggestKt;
import androidx.compose.material.icons.outlined.SyncKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenuDefaults;
import androidx.compose.material3.ExposedDropdownMenu_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.Route;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.ChipsKt;
import com.videshkarmakar.loop.ui.component.DialogItemsKt;
import com.videshkarmakar.loop.ui.component.DialogsKt;
import com.videshkarmakar.loop.ui.component.DividerKt;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.PreferenceStrings;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: FormatSettingDialogs.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a+\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\b\u001a\u001b\u0010\n\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\r\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001au\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0018\u001a\u001b\u0010\u0019\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u001a\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001aM\u0010\u001b\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0014H\u0003¢\u0006\u0002\u0010\u001e\u001a=\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040\u0014H\u0007¢\u0006\u0002\u0010\"\u001a=\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020!2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040\u0014H\u0007¢\u0006\u0002\u0010\"\u001a;\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u00112\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010+\u001a\u001d\u0010,\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010-\u001a;\u0010.\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u00112\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010+\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00060²\u0006\n\u00101\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020!X\u008a\u008e\u0002"}, d2 = {"sortingFormats", "", "subtitleOptions", "AudioConversionDialog", "", "onDismissRequest", "Lkotlin/Function0;", "onConfirm", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "AudioConversionQuickSettingsDialog", "AudioFormatDialog", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AudioQualityDialog", "AudioQuickSettingsDialog", "FormatSortingDialog", "fields", "showSwitch", "", "toggleableValue", "onSwitchChecked", "Lkotlin/Function1;", "onImport", "(Ljava/lang/String;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "FormatSortingDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "SubtitleConversionDialog", "SubtitleLanguageDialog", "SubtitleLanguageDialogImpl", "initialLanguages", "onReset", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "VideoFormatDialog", "videoFormatPreference", "", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "VideoQualityDialog", "videoQuality", "VideoQualityPreferenceChip", "modifier", "Landroidx/compose/ui/Modifier;", "videoQualityPreference", "enabled", "onClick", "(Landroidx/compose/ui/Modifier;IZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VideoQuickSettingsDialog", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VideoResolutionChip", "videoResolution", "app_debug", "audioQuality", "audioFormat", "expanded", "audioQualityText", "audioFormatText", "videoFormat", "videoFormatText", "convertAudio", "preference", "sortingFields", DownloadUtil.CookieScheme.VALUE, Route.LANGUAGES, "currentFormat"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FormatSettingDialogsKt {
    private static final String sortingFormats = "https://github.com/yt-dlp/yt-dlp#sorting-formats";
    private static final String subtitleOptions = "https://github.com/yt-dlp/yt-dlp#subtitle-options";

    public static final void AudioQuickSettingsDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-1525230169);
        ComposerKt.sourceInformation($composer3, "C(AudioQuickSettingsDialog)94@4737L8,95@4782L8,187@8507L194,183@8401L88,193@8710L287,176@8143L855:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1525230169, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog (FormatSettingDialogs.kt:93)");
            }
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_QUALITY, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableIntState audioQuality$delegate = (MutableIntState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_FORMAT, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            final MutableIntState audioFormat$delegate = (MutableIntState) value$iv$iv2;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-1679497745, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQuickSettingsDialog.1
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C188@8535L156,188@8521L170:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1679497745, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:188)");
                    }
                    $composer4.startReplaceGroup(1708377543);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(audioFormat$delegate) | $composer4.changed(audioQuality$delegate) | $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    final MutableIntState mutableIntState = audioFormat$delegate;
                    final MutableIntState mutableIntState2 = audioQuality$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$1$1$1
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
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.AUDIO_FORMAT, FormatSettingDialogsKt.AudioQuickSettingsDialog$lambda$2(mutableIntState));
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.AUDIO_QUALITY, FormatSettingDialogsKt.AudioQuickSettingsDialog$lambda$0(mutableIntState2));
                                function0.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-1252943247, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQuickSettingsDialog.2
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C184@8429L50,184@8415L64:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1252943247, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:184)");
                    }
                    $composer4.startReplaceGroup(1708377437);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$2$1$1
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
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7400getLambda5$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7401getLambda6$app_debug(), ComposableLambdaKt.rememberComposableLambda(1534372148, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQuickSettingsDialog.3
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C194@8737L250,194@8724L263:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1534372148, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:194)");
                    }
                    $composer4.startReplaceGroup(1708377745);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(audioFormat$delegate) | $composer4.changed(audioQuality$delegate);
                    final MutableIntState mutableIntState = audioFormat$delegate;
                    final MutableIntState mutableIntState2 = audioQuality$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                final MutableIntState mutableIntState3 = mutableIntState;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1126951368, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$3$1$1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C196@8782L24,197@8827L41:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1126951368, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:196)");
                                            }
                                            FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField(mutableIntState3, null, $composer5, 0, 1);
                                            SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12)), $composer5, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableIntState mutableIntState4 = mutableIntState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(490589567, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$3$1$1.2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C200@8930L25:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(490589567, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:200)");
                                            }
                                            FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField(mutableIntState4, null, $composer5, 0, 1);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, (Function1) value$iv, $composer4, 0, 255);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty2 & 14) | 1797168, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQuickSettingsDialog.4
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
                    FormatSettingDialogsKt.AudioQuickSettingsDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AudioQuickSettingsDialog$lambda$0(MutableIntState $audioQuality$delegate) {
        MutableIntState $this$getValue$iv = $audioQuality$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AudioQuickSettingsDialog$lambda$2(MutableIntState $audioFormat$delegate) {
        MutableIntState $this$getValue$iv = $audioFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AudioQuickSettingsDialog$audioQualitySelectField(final MutableIntState audioQuality$delegate, Modifier modifier, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        $composer.startReplaceGroup(1778348321);
        ComposerKt.sourceInformation($composer, "C(audioQualitySelectField)99@4897L34,100@4964L68,104@5130L24,104@5156L1304,102@5042L1418:FormatSettingDialogs.kt#5yb39d");
        final Modifier modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1778348321, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioQualitySelectField (FormatSettingDialogs.kt:98)");
        }
        $composer.startReplaceGroup(319196777);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState expanded$delegate = (MutableState) value$iv;
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(319196844);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceStrings.getAudioQualityDesc$default(PreferenceStrings.INSTANCE, 0, 1, null), null, 2, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final MutableState audioQualityText$delegate = (MutableState) value$iv2;
        $composer.endReplaceGroup();
        boolean zAudioQuickSettingsDialog$audioQualitySelectField$lambda$5 = AudioQuickSettingsDialog$audioQualitySelectField$lambda$5(expanded$delegate);
        $composer.startReplaceGroup(319197010);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioQualitySelectField$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                    FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField$lambda$6(expanded$delegate, !FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField$lambda$5(expanded$delegate));
                }
            };
            $composer.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        $composer.endReplaceGroup();
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAudioQuickSettingsDialog$audioQualitySelectField$lambda$5, (Function1) value$iv3, null, ComposableLambdaKt.rememberComposableLambda(-1305771573, true, new Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioQualitySelectField$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer, Integer num) {
                invoke(exposedDropdownMenuBoxScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer $composer2, int $changed2) {
                Object value$iv4;
                Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
                ComposerKt.sourceInformation($composer2, "C116@5668L25,113@5512L101,105@5170L616,120@5871L21,122@5967L20,122@5989L461,119@5799L651:FormatSettingDialogs.kt#5yb39d");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer2.changed(ExposedDropdownMenuBox) ? 4 : 2;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 91) == 18 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1305771573, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioQualitySelectField.<anonymous> (FormatSettingDialogs.kt:105)");
                }
                Modifier modifierMenuAnchor = ExposedDropdownMenuBox.menuAnchor(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null));
                String strAudioQuickSettingsDialog$audioQualitySelectField$lambda$8 = FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField$lambda$8(audioQualityText$delegate);
                TextFieldColors textFieldColorsM1983outlinedTextFieldColorsFD9MK7s = ExposedDropdownMenuDefaults.INSTANCE.m1983outlinedTextFieldColorsFD9MK7s(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 0, ExposedDropdownMenuDefaults.$stable << 27, Integer.MAX_VALUE, 255);
                AnonymousClass1 anonymousClass1 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioQualitySelectField$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                };
                Function2<Composer, Integer, Unit> function2M7363getLambda1$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7363getLambda1$app_debug();
                Function2<Composer, Integer, Unit> function2M7374getLambda2$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7374getLambda2$app_debug();
                final MutableState<Boolean> mutableState = expanded$delegate;
                OutlinedTextFieldKt.OutlinedTextField(strAudioQuickSettingsDialog$audioQualitySelectField$lambda$8, (Function1<? super String, Unit>) anonymousClass1, modifierMenuAnchor, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7363getLambda1$app_debug, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7374getLambda2$app_debug, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1935726644, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioQualitySelectField$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed3) {
                        ComposerKt.sourceInformation($composer3, "C114@5562L33:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1935726644, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioQualitySelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:114)");
                            }
                            ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField$lambda$5(mutableState), null, $composer3, ExposedDropdownMenuDefaults.$stable << 6, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM1983outlinedTextFieldColorsFD9MK7s, $composer2, 907567152, 0, 0, 4193448);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, null, false, 14, null);
                boolean zAudioQuickSettingsDialog$audioQualitySelectField$lambda$6 = FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField$lambda$5(expanded$delegate);
                $composer2.startReplaceGroup(2079779000);
                ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                final MutableState<Boolean> mutableState2 = expanded$delegate;
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioQualitySelectField$2$3$1
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
                            FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField$lambda$6(mutableState2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                $composer2.endReplaceGroup();
                final MutableIntState mutableIntState = audioQuality$delegate;
                final MutableState<String> mutableState3 = audioQualityText$delegate;
                final MutableState<Boolean> mutableState4 = expanded$delegate;
                ExposedDropdownMenuBox.m1982ExposedDropdownMenukbRbctU(zAudioQuickSettingsDialog$audioQualitySelectField$lambda$6, (Function0) value$iv4, modifierVerticalScroll$default, null, false, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1135177650, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioQualitySelectField$2.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope ExposedDropdownMenu, Composer $composer3, int $changed3) {
                        Object value$iv5;
                        Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
                        ComposerKt.sourceInformation($composer3, "C*125@6112L50,126@6198L237,124@6063L373:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1135177650, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioQualitySelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:123)");
                            }
                            for (final int i2 = 0; i2 < 5; i2++) {
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-877151012, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQuickSettingsDialog.audioQualitySelectField.2.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer4, int $changed4) {
                                        ComposerKt.sourceInformation($composer4, "C125@6114L46:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed4 & 11) == 2 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-877151012, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioQualitySelectField.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:125)");
                                        }
                                        TextKt.m2569Text4IGK_g(PreferenceStrings.INSTANCE.getAudioQualityDesc(i2), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer3, 54);
                                $composer3.startReplaceGroup(-1074129344);
                                ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                boolean invalid$iv = $composer3.changed(i2) | $composer3.changed(mutableIntState);
                                final MutableState<String> mutableState5 = mutableState3;
                                final MutableIntState mutableIntState2 = mutableIntState;
                                final MutableState<Boolean> mutableState6 = mutableState4;
                                Object it$iv5 = $composer3.rememberedValue();
                                if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioQualitySelectField$2$4$2$1
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
                                            mutableState5.setValue(PreferenceStrings.INSTANCE.getAudioQualityDesc(i2));
                                            mutableIntState2.setIntValue(i2);
                                            FormatSettingDialogsKt.AudioQuickSettingsDialog$audioQualitySelectField$lambda$6(mutableState6, false);
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv5);
                                } else {
                                    value$iv5 = it$iv5;
                                }
                                $composer3.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) value$iv5, null, null, null, false, null, null, null, $composer3, 6, 508);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 48, (ExposedDropdownMenuBoxScope.$stable << 6) | 48 | (($dirty2 << 6) & 896), 2040);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer, 54), $composer, 3120, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AudioQuickSettingsDialog$audioQualitySelectField$lambda$5(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AudioQuickSettingsDialog$audioQualitySelectField$lambda$6(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AudioQuickSettingsDialog$audioQualitySelectField$lambda$8(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AudioQuickSettingsDialog$audioFormatSelectField(final MutableIntState audioFormat$delegate, Modifier modifier, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        $composer.startReplaceGroup(-831320727);
        ComposerKt.sourceInformation($composer, "C(audioFormatSelectField)138@6572L34,139@6638L67,143@6803L24,143@6829L1301,141@6715L1415:FormatSettingDialogs.kt#5yb39d");
        final Modifier modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-831320727, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioFormatSelectField (FormatSettingDialogs.kt:137)");
        }
        $composer.startReplaceGroup(977485438);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState expanded$delegate = (MutableState) value$iv;
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(977485504);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceStrings.getAudioFormatDesc$default(PreferenceStrings.INSTANCE, 0, 1, null), null, 2, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final MutableState audioFormatText$delegate = (MutableState) value$iv2;
        $composer.endReplaceGroup();
        boolean zAudioQuickSettingsDialog$audioFormatSelectField$lambda$12 = AudioQuickSettingsDialog$audioFormatSelectField$lambda$12(expanded$delegate);
        $composer.startReplaceGroup(977485669);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioFormatSelectField$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                    FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField$lambda$13(expanded$delegate, !FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField$lambda$12(expanded$delegate));
                }
            };
            $composer.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        $composer.endReplaceGroup();
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAudioQuickSettingsDialog$audioFormatSelectField$lambda$12, (Function1) value$iv3, null, ComposableLambdaKt.rememberComposableLambda(-376619137, true, new Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioFormatSelectField$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer, Integer num) {
                invoke(exposedDropdownMenuBoxScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer $composer2, int $changed2) {
                Object value$iv4;
                Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
                ComposerKt.sourceInformation($composer2, "C155@7338L25,152@7182L101,144@6843L623,159@7551L21,161@7647L20,161@7669L451,158@7479L641:FormatSettingDialogs.kt#5yb39d");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer2.changed(ExposedDropdownMenuBox) ? 4 : 2;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 91) == 18 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-376619137, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioFormatSelectField.<anonymous> (FormatSettingDialogs.kt:144)");
                }
                Modifier modifierMenuAnchor = ExposedDropdownMenuBox.menuAnchor(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null));
                String strAudioQuickSettingsDialog$audioFormatSelectField$lambda$15 = FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField$lambda$15(audioFormatText$delegate);
                TextFieldColors textFieldColorsM1983outlinedTextFieldColorsFD9MK7s = ExposedDropdownMenuDefaults.INSTANCE.m1983outlinedTextFieldColorsFD9MK7s(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 0, ExposedDropdownMenuDefaults.$stable << 27, Integer.MAX_VALUE, 255);
                AnonymousClass1 anonymousClass1 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioFormatSelectField$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                };
                Function2<Composer, Integer, Unit> function2M7385getLambda3$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7385getLambda3$app_debug();
                Function2<Composer, Integer, Unit> function2M7396getLambda4$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7396getLambda4$app_debug();
                final MutableState<Boolean> mutableState = expanded$delegate;
                OutlinedTextFieldKt.OutlinedTextField(strAudioQuickSettingsDialog$audioFormatSelectField$lambda$15, (Function1<? super String, Unit>) anonymousClass1, modifierMenuAnchor, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7385getLambda3$app_debug, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7396getLambda4$app_debug, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(143587318, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioFormatSelectField$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed3) {
                        ComposerKt.sourceInformation($composer3, "C153@7232L33:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(143587318, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioFormatSelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:153)");
                            }
                            ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField$lambda$12(mutableState), null, $composer3, ExposedDropdownMenuDefaults.$stable << 6, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM1983outlinedTextFieldColorsFD9MK7s, $composer2, 907567152, 0, 0, 4193448);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, null, false, 14, null);
                boolean zAudioQuickSettingsDialog$audioFormatSelectField$lambda$13 = FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField$lambda$12(expanded$delegate);
                $composer2.startReplaceGroup(-1155556910);
                ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                final MutableState<Boolean> mutableState2 = expanded$delegate;
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioFormatSelectField$2$3$1
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
                            FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField$lambda$13(mutableState2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                $composer2.endReplaceGroup();
                final MutableIntState mutableIntState = audioFormat$delegate;
                final MutableState<String> mutableState3 = audioFormatText$delegate;
                final MutableState<Boolean> mutableState4 = expanded$delegate;
                ExposedDropdownMenuBox.m1982ExposedDropdownMenukbRbctU(zAudioQuickSettingsDialog$audioFormatSelectField$lambda$13, (Function0) value$iv4, modifierVerticalScroll$default, null, false, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1202400100, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioFormatSelectField$2.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope ExposedDropdownMenu, Composer $composer3, int $changed3) {
                        Object value$iv5;
                        Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
                        ComposerKt.sourceInformation($composer3, "C*164@7786L49,165@7871L234,163@7737L369:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1202400100, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioFormatSelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:162)");
                            }
                            for (final int i2 = 0; i2 < 3; i2++) {
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1022680654, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQuickSettingsDialog.audioFormatSelectField.2.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer4, int $changed4) {
                                        ComposerKt.sourceInformation($composer4, "C164@7788L45:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed4 & 11) == 2 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1022680654, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQuickSettingsDialog.audioFormatSelectField.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:164)");
                                        }
                                        TextKt.m2569Text4IGK_g(PreferenceStrings.INSTANCE.getAudioFormatDesc(i2), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer3, 54);
                                $composer3.startReplaceGroup(404047955);
                                ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                boolean invalid$iv = $composer3.changed(i2) | $composer3.changed(mutableIntState);
                                final MutableState<String> mutableState5 = mutableState3;
                                final MutableIntState mutableIntState2 = mutableIntState;
                                final MutableState<Boolean> mutableState6 = mutableState4;
                                Object it$iv5 = $composer3.rememberedValue();
                                if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQuickSettingsDialog$audioFormatSelectField$2$4$2$1
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
                                            mutableState5.setValue(PreferenceStrings.INSTANCE.getAudioFormatDesc(i2));
                                            mutableIntState2.setIntValue(i2);
                                            FormatSettingDialogsKt.AudioQuickSettingsDialog$audioFormatSelectField$lambda$13(mutableState6, false);
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv5);
                                } else {
                                    value$iv5 = it$iv5;
                                }
                                $composer3.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) value$iv5, null, null, null, false, null, null, null, $composer3, 6, 508);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 48, (ExposedDropdownMenuBoxScope.$stable << 6) | 48 | (($dirty2 << 6) & 896), 2040);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer, 54), $composer, 3120, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AudioQuickSettingsDialog$audioFormatSelectField$lambda$12(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AudioQuickSettingsDialog$audioFormatSelectField$lambda$13(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AudioQuickSettingsDialog$audioFormatSelectField$lambda$15(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void VideoQuickSettingsDialog(Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(286622946);
        ComposerKt.sourceInformation($composer3, "C(VideoQuickSettingsDialog)210@9162L8,211@9207L8,303@12961L197,299@12855L88,309@13167L290,292@12597L861:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function1 = function0;
        } else if (($changed & 14) == 0) {
            function1 = function0;
            $dirty |= $composer3.changedInstance(function1) ? 4 : 2;
        } else {
            function1 = function0;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQuickSettingsDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(286622946, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog (FormatSettingDialogs.kt:209)");
            }
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.VIDEO_QUALITY, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableIntState videoResolution$delegate = (MutableIntState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.VIDEO_FORMAT, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            final MutableIntState videoFormat$delegate = (MutableIntState) value$iv$iv2;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            Function0<Unit> function3 = function2;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0(function3, ComposableLambdaKt.rememberComposableLambda(132355370, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQuickSettingsDialog.2
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C304@12989L159,304@12975L173:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(132355370, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:304)");
                    }
                    $composer4.startReplaceGroup(-1692238894);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(videoFormat$delegate) | $composer4.changed(videoResolution$delegate) | $composer4.changed(function2);
                    final Function0<Unit> function4 = function2;
                    final MutableIntState mutableIntState = videoFormat$delegate;
                    final MutableIntState mutableIntState2 = videoResolution$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$2$1$1
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
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.VIDEO_FORMAT, FormatSettingDialogsKt.VideoQuickSettingsDialog$lambda$20(mutableIntState));
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.VIDEO_QUALITY, FormatSettingDialogsKt.VideoQuickSettingsDialog$lambda$18(mutableIntState2));
                                function4.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(558909868, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQuickSettingsDialog.3
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C300@12883L50,300@12869L64:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(558909868, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:300)");
                    }
                    $composer4.startReplaceGroup(-1692239000);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function2);
                    final Function0<Unit> function4 = function2;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$3$1$1
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
                                function4.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7365getLambda11$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7366getLambda12$app_debug(), ComposableLambdaKt.rememberComposableLambda(-948742033, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQuickSettingsDialog.4
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C310@13194L253,310@13181L266:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-948742033, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:310)");
                    }
                    $composer4.startReplaceGroup(-1692238689);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(videoFormat$delegate) | $composer4.changed(videoResolution$delegate);
                    final MutableIntState mutableIntState = videoFormat$delegate;
                    final MutableIntState mutableIntState2 = videoResolution$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                final MutableIntState mutableIntState3 = mutableIntState;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1356162813, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$4$1$1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C312@13239L24,313@13284L41:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1356162813, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:312)");
                                            }
                                            FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField(mutableIntState3, null, $composer5, 0, 1);
                                            SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12)), $composer5, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                                final MutableIntState mutableIntState4 = mutableIntState2;
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1992524614, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$4$1$1.2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C316@13387L28:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1992524614, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:316)");
                                            }
                                            FormatSettingDialogsKt.VideoQuickSettingsDialog$videoResolutionSelectField(mutableIntState4, null, $composer5, 0, 1);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer5.skipToGroupEnd();
                                    }
                                }), 3, null);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, (Function1) value$iv, $composer4, 0, 255);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty2 & 14) | 1797168, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function3;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQuickSettingsDialog.5
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
                    FormatSettingDialogsKt.VideoQuickSettingsDialog(function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoQuickSettingsDialog$lambda$18(MutableIntState $videoResolution$delegate) {
        MutableIntState $this$getValue$iv = $videoResolution$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoQuickSettingsDialog$lambda$20(MutableIntState $videoFormat$delegate) {
        MutableIntState $this$getValue$iv = $videoFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.String] */
    public static final void VideoQuickSettingsDialog$videoResolutionSelectField(final MutableIntState videoResolution$delegate, Modifier modifier, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        $composer.startReplaceGroup(-1246345154);
        ComposerKt.sourceInformation($composer, "C(videoResolutionSelectField)215@9325L34,220@9549L24,220@9575L1298,218@9461L1412:FormatSettingDialogs.kt#5yb39d");
        final Modifier modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1246345154, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoResolutionSelectField (FormatSettingDialogs.kt:214)");
        }
        $composer.startReplaceGroup(-1336710764);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState expanded$delegate = (MutableState) value$iv;
        $composer.endReplaceGroup();
        final Ref.ObjectRef videoResolutionText = new Ref.ObjectRef();
        videoResolutionText.element = PreferenceStrings.INSTANCE.getVideoResolutionDesc(VideoQuickSettingsDialog$lambda$18(videoResolution$delegate));
        boolean zVideoQuickSettingsDialog$videoResolutionSelectField$lambda$23 = VideoQuickSettingsDialog$videoResolutionSelectField$lambda$23(expanded$delegate);
        $composer.startReplaceGroup(-1336710540);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoResolutionSelectField$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                    FormatSettingDialogsKt.VideoQuickSettingsDialog$videoResolutionSelectField$lambda$24(expanded$delegate, !FormatSettingDialogsKt.VideoQuickSettingsDialog$videoResolutionSelectField$lambda$23(expanded$delegate));
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        $composer.endReplaceGroup();
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zVideoQuickSettingsDialog$videoResolutionSelectField$lambda$23, (Function1) value$iv2, null, ComposableLambdaKt.rememberComposableLambda(1973256020, true, new Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoResolutionSelectField$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer, Integer num) {
                invoke(exposedDropdownMenuBoxScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer $composer2, int $changed2) {
                Object value$iv3;
                Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
                ComposerKt.sourceInformation($composer2, "C232@10082L25,229@9926L101,221@9589L614,236@10288L21,238@10384L20,238@10406L457,235@10216L647:FormatSettingDialogs.kt#5yb39d");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer2.changed(ExposedDropdownMenuBox) ? 4 : 2;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 91) == 18 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1973256020, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoResolutionSelectField.<anonymous> (FormatSettingDialogs.kt:221)");
                }
                Modifier modifierMenuAnchor = ExposedDropdownMenuBox.menuAnchor(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null));
                String str = videoResolutionText.element;
                TextFieldColors textFieldColorsM1983outlinedTextFieldColorsFD9MK7s = ExposedDropdownMenuDefaults.INSTANCE.m1983outlinedTextFieldColorsFD9MK7s(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 0, ExposedDropdownMenuDefaults.$stable << 27, Integer.MAX_VALUE, 255);
                AnonymousClass1 anonymousClass1 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoResolutionSelectField$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                };
                Function2<Composer, Integer, Unit> function2M7402getLambda7$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7402getLambda7$app_debug();
                Function2<Composer, Integer, Unit> function2M7403getLambda8$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7403getLambda8$app_debug();
                final MutableState<Boolean> mutableState = expanded$delegate;
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) anonymousClass1, modifierMenuAnchor, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7402getLambda7$app_debug, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7403getLambda8$app_debug, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1401955403, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoResolutionSelectField$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed3) {
                        ComposerKt.sourceInformation($composer3, "C230@9976L33:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1401955403, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoResolutionSelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:230)");
                            }
                            ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(FormatSettingDialogsKt.VideoQuickSettingsDialog$videoResolutionSelectField$lambda$23(mutableState), null, $composer3, ExposedDropdownMenuDefaults.$stable << 6, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM1983outlinedTextFieldColorsFD9MK7s, $composer2, 907567152, 0, 0, 4193448);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, null, false, 14, null);
                boolean zVideoQuickSettingsDialog$videoResolutionSelectField$lambda$24 = FormatSettingDialogsKt.VideoQuickSettingsDialog$videoResolutionSelectField$lambda$23(expanded$delegate);
                $composer2.startReplaceGroup(729869656);
                ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                final MutableState<Boolean> mutableState2 = expanded$delegate;
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoResolutionSelectField$2$3$1
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
                            FormatSettingDialogsKt.VideoQuickSettingsDialog$videoResolutionSelectField$lambda$24(mutableState2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                $composer2.endReplaceGroup();
                final MutableIntState mutableIntState = videoResolution$delegate;
                final MutableState<Boolean> mutableState3 = expanded$delegate;
                ExposedDropdownMenuBox.m1982ExposedDropdownMenukbRbctU(zVideoQuickSettingsDialog$videoResolutionSelectField$lambda$24, (Function0) value$iv3, modifierVerticalScroll$default, null, false, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1104462351, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoResolutionSelectField$2.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope ExposedDropdownMenu, Composer $composer3, int $changed3) {
                        Object value$iv4;
                        Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
                        ComposerKt.sourceInformation($composer3, "C*241@10509L53,242@10598L250,240@10460L389:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1104462351, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoResolutionSelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:239)");
                            }
                            for (final int i2 = 0; i2 < 8; i2++) {
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2070617763, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQuickSettingsDialog.videoResolutionSelectField.2.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer4, int $changed4) {
                                        ComposerKt.sourceInformation($composer4, "C241@10511L49:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed4 & 11) == 2 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2070617763, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoResolutionSelectField.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:241)");
                                        }
                                        TextKt.m2569Text4IGK_g(PreferenceStrings.INSTANCE.getVideoResolutionDesc(i2), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer3, 54);
                                $composer3.startReplaceGroup(1271858255);
                                ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                boolean invalid$iv = $composer3.changed(mutableIntState) | $composer3.changed(i2);
                                final MutableIntState mutableIntState2 = mutableIntState;
                                final MutableState<Boolean> mutableState4 = mutableState3;
                                Object it$iv4 = $composer3.rememberedValue();
                                if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoResolutionSelectField$2$4$2$1
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
                                            mutableIntState2.setIntValue(i2);
                                            FormatSettingDialogsKt.VideoQuickSettingsDialog$videoResolutionSelectField$lambda$24(mutableState4, false);
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv4);
                                } else {
                                    value$iv4 = it$iv4;
                                }
                                $composer3.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) value$iv4, null, null, null, false, null, null, null, $composer3, 6, 508);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 48, (ExposedDropdownMenuBoxScope.$stable << 6) | 48 | (($dirty2 << 6) & 896), 2040);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer, 54), $composer, 3120, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoQuickSettingsDialog$videoResolutionSelectField$lambda$23(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoQuickSettingsDialog$videoResolutionSelectField$lambda$24(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoQuickSettingsDialog$videoFormatSelectField(final MutableIntState videoFormat$delegate, Modifier modifier, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        $composer.startReplaceGroup(-942199863);
        ComposerKt.sourceInformation($composer, "C(videoFormatSelectField)254@10985L34,255@11051L67,259@11216L24,259@11242L1342,257@11128L1456:FormatSettingDialogs.kt#5yb39d");
        final Modifier modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-942199863, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoFormatSelectField (FormatSettingDialogs.kt:253)");
        }
        $composer.startReplaceGroup(887831387);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState expanded$delegate = (MutableState) value$iv;
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(887831453);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceStrings.getVideoFormatDesc$default(PreferenceStrings.INSTANCE, 0, 1, null), null, 2, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        final MutableState videoFormatText$delegate = (MutableState) value$iv2;
        $composer.endReplaceGroup();
        boolean zVideoQuickSettingsDialog$videoFormatSelectField$lambda$27 = VideoQuickSettingsDialog$videoFormatSelectField$lambda$27(expanded$delegate);
        $composer.startReplaceGroup(887831618);
        ComposerKt.sourceInformation($composer, "CC(remember):FormatSettingDialogs.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoFormatSelectField$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                    FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField$lambda$28(expanded$delegate, !FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField$lambda$27(expanded$delegate));
                }
            };
            $composer.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        $composer.endReplaceGroup();
        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zVideoQuickSettingsDialog$videoFormatSelectField$lambda$27, (Function1) value$iv3, null, ComposableLambdaKt.rememberComposableLambda(-487498273, true, new Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoFormatSelectField$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer, Integer num) {
                invoke(exposedDropdownMenuBoxScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer $composer2, int $changed2) {
                Object value$iv4;
                Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
                ComposerKt.sourceInformation($composer2, "C271@11751L25,268@11595L101,260@11256L623,275@11964L21,277@12060L20,277@12082L492,274@11892L682:FormatSettingDialogs.kt#5yb39d");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer2.changed(ExposedDropdownMenuBox) ? 4 : 2;
                }
                int $dirty2 = $dirty;
                if (($dirty2 & 91) == 18 && $composer2.getSkipping()) {
                    $composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-487498273, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoFormatSelectField.<anonymous> (FormatSettingDialogs.kt:260)");
                }
                Modifier modifierMenuAnchor = ExposedDropdownMenuBox.menuAnchor(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null));
                String strVideoQuickSettingsDialog$videoFormatSelectField$lambda$30 = FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField$lambda$30(videoFormatText$delegate);
                TextFieldColors textFieldColorsM1983outlinedTextFieldColorsFD9MK7s = ExposedDropdownMenuDefaults.INSTANCE.m1983outlinedTextFieldColorsFD9MK7s(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 0, ExposedDropdownMenuDefaults.$stable << 27, Integer.MAX_VALUE, 255);
                AnonymousClass1 anonymousClass1 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoFormatSelectField$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                };
                Function2<Composer, Integer, Unit> function2M7404getLambda9$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7404getLambda9$app_debug();
                Function2<Composer, Integer, Unit> function2M7364getLambda10$app_debug = ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7364getLambda10$app_debug();
                final MutableState<Boolean> mutableState = expanded$delegate;
                OutlinedTextFieldKt.OutlinedTextField(strVideoQuickSettingsDialog$videoFormatSelectField$lambda$30, (Function1<? super String, Unit>) anonymousClass1, modifierMenuAnchor, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7404getLambda9$app_debug, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7364getLambda10$app_debug, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(32708182, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoFormatSelectField$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed3) {
                        ComposerKt.sourceInformation($composer3, "C269@11645L33:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(32708182, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoFormatSelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:269)");
                            }
                            ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField$lambda$27(mutableState), null, $composer3, ExposedDropdownMenuDefaults.$stable << 6, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM1983outlinedTextFieldColorsFD9MK7s, $composer2, 907567152, 0, 0, 4193448);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, null, false, 14, null);
                boolean zVideoQuickSettingsDialog$videoFormatSelectField$lambda$28 = FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField$lambda$27(expanded$delegate);
                $composer2.startReplaceGroup(1277372079);
                ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                final MutableState<Boolean> mutableState2 = expanded$delegate;
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoFormatSelectField$2$3$1
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
                            FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField$lambda$28(mutableState2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                $composer2.endReplaceGroup();
                final MutableIntState mutableIntState = videoFormat$delegate;
                final MutableState<String> mutableState3 = videoFormatText$delegate;
                final MutableState<Boolean> mutableState4 = expanded$delegate;
                ExposedDropdownMenuBox.m1982ExposedDropdownMenukbRbctU(zVideoQuickSettingsDialog$videoFormatSelectField$lambda$28, (Function0) value$iv4, modifierVerticalScroll$default, null, false, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1313279236, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoFormatSelectField$2.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope ExposedDropdownMenu, Composer $composer3, int $changed3) {
                        Object value$iv5;
                        Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
                        ComposerKt.sourceInformation($composer3, "C*280@12240L49,281@12325L234,279@12191L369:FormatSettingDialogs.kt#5yb39d");
                        if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1313279236, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoFormatSelectField.<anonymous>.<anonymous> (FormatSettingDialogs.kt:278)");
                            }
                            boolean z = true;
                            Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2}).iterator();
                            while (it.hasNext()) {
                                final int i2 = ((Number) it.next()).intValue();
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(911801518, z, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQuickSettingsDialog.videoFormatSelectField.2.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer4, int $changed4) {
                                        ComposerKt.sourceInformation($composer4, "C280@12242L45:FormatSettingDialogs.kt#5yb39d");
                                        if (($changed4 & 11) == 2 && $composer4.getSkipping()) {
                                            $composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(911801518, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQuickSettingsDialog.videoFormatSelectField.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:280)");
                                        }
                                        TextKt.m2569Text4IGK_g(PreferenceStrings.INSTANCE.getVideoFormatDesc(i2), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer3, 54);
                                $composer3.startReplaceGroup(1117545817);
                                ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                boolean invalid$iv = $composer3.changed(i2) | $composer3.changed(mutableIntState);
                                final MutableState<String> mutableState5 = mutableState3;
                                final MutableIntState mutableIntState2 = mutableIntState;
                                final MutableState<Boolean> mutableState6 = mutableState4;
                                Object it$iv5 = $composer3.rememberedValue();
                                if (invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQuickSettingsDialog$videoFormatSelectField$2$4$2$1
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
                                            mutableState5.setValue(PreferenceStrings.INSTANCE.getVideoFormatDesc(i2));
                                            mutableIntState2.setIntValue(i2);
                                            FormatSettingDialogsKt.VideoQuickSettingsDialog$videoFormatSelectField$lambda$28(mutableState6, false);
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv5);
                                } else {
                                    value$iv5 = it$iv5;
                                }
                                $composer3.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) value$iv5, null, null, null, false, null, null, null, $composer3, 6, 508);
                                z = true;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 48, (ExposedDropdownMenuBoxScope.$stable << 6) | 48 | (($dirty2 << 6) & 896), 2040);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer, 54), $composer, 3120, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoQuickSettingsDialog$videoFormatSelectField$lambda$27(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoQuickSettingsDialog$videoFormatSelectField$lambda$28(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String VideoQuickSettingsDialog$videoFormatSelectField$lambda$30(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void AudioConversionDialog(final Function0<Unit> onDismissRequest, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv;
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-1917169111);
        ComposerKt.sourceInformation($composer3, "C(AudioConversionDialog)P(1)328@13594L67,329@13700L12,340@14094L265,332@13798L133,348@14368L778,330@13717L1430:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            function1 = function0;
        } else if (($changed & 112) == 0) {
            function1 = function0;
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1917169111, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionDialog (FormatSettingDialogs.kt:327)");
            }
            $composer3.startReplaceGroup(2100708309);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(PreferenceUtil.INSTANCE.getAudioConvertFormat()), null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState audioFormat$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_CONVERT, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            Function0<Unit> function3 = function2;
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, onDismissRequest, ComposableLambdaKt.rememberComposableLambda(2095792708, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionDialog.2
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C341@14129L141,341@14108L241:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2095792708, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionDialog.<anonymous> (FormatSettingDialogs.kt:341)");
                    }
                    $composer4.startReplaceGroup(2034108301);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function2) | $composer4.changed(onDismissRequest);
                    final Function0<Unit> function4 = function2;
                    final Function0<Unit> function5 = onDismissRequest;
                    final MutableState<Integer> mutableState = audioFormat$delegate;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioConversionDialog$2$1$1
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
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.AUDIO_CONVERSION_FORMAT, FormatSettingDialogsKt.AudioConversionDialog$lambda$34(mutableState));
                                function4.invoke();
                                function5.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    ButtonKt.TextButton((Function0) value$iv2, null, false, null, null, null, null, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7367getLambda13$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-2006243387, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionDialog.3
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
                    ComposerKt.sourceInformation($composer4, "C333@13812L109:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2006243387, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionDialog.<anonymous> (FormatSettingDialogs.kt:333)");
                        }
                        ButtonKt.TextButton(onDismissRequest, null, false, null, null, null, null, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7368getLambda14$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7369getLambda15$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7370getLambda16$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1427449784, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionDialog.4
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
                    Function0<ComposeUiNode> function4;
                    ComposerKt.sourceInformation($composer4, "C349@14424L21,349@14382L754:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1427449784, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionDialog.<anonymous> (FormatSettingDialogs.kt:349)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                        final MutableState<Integer> mutableState = audioFormat$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function4 = constructor;
                            $composer4.createNode(function4);
                        } else {
                            function4 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1796432127, "C355@14682L50,356@14776L10,350@14466L348:FormatSettingDialogs.kt#5yb39d");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.convert_audio_format_desc, $composer4, 0), PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 48, 0, 65532);
                        $composer4.startReplaceGroup(2034109003);
                        ComposerKt.sourceInformation($composer4, "*363@15103L19,359@14887L235");
                        final int i5 = 0;
                        while (i5 < 2) {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            String audioConvertDesc = PreferenceStrings.INSTANCE.getAudioConvertDesc(i5);
                            boolean z = FormatSettingDialogsKt.AudioConversionDialog$lambda$34(mutableState) == i5;
                            $composer4.startReplaceGroup(1796432764);
                            ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                            boolean invalid$iv = $composer4.changed(i5);
                            Object value$iv2 = $composer4.rememberedValue();
                            if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioConversionDialog$4$1$1$1
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
                                        FormatSettingDialogsKt.AudioConversionDialog$lambda$35(mutableState, i5);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv2);
                            }
                            $composer4.endReplaceGroup();
                            DialogItemsKt.DialogSingleChoiceItem(companion, audioConvertDesc, z, (Function0) value$iv2, $composer4, 6, 0);
                            i5++;
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
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionDialog.5
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
                    FormatSettingDialogsKt.AudioConversionDialog(onDismissRequest, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AudioConversionDialog$lambda$34(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AudioConversionDialog$lambda$35(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    private static final boolean AudioConversionDialog$lambda$36(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    public static final void AudioConversionQuickSettingsDialog(final Function0<Unit> onDismissRequest, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv;
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-1913024067);
        ComposerKt.sourceInformation($composer3, "C(AudioConversionQuickSettingsDialog)P(1)373@15295L70,374@15404L12,383@15725L238,377@15502L60,391@15972L1116,375@15421L1668:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            function1 = function0;
        } else if (($changed & 112) == 0) {
            function1 = function0;
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionQuickSettingsDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1913024067, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionQuickSettingsDialog (FormatSettingDialogs.kt:372)");
            }
            $composer3.startReplaceGroup(1077582340);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.INSTANCE.getAudioConvertFormat());
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableIntState audioFormat$delegate = (MutableIntState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_CONVERT, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableState convertAudio$delegate = (MutableState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            Function0<Unit> function3 = function2;
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-1942821502, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionQuickSettingsDialog.2
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C384@15753L199,384@15739L213:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1942821502, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:384)");
                    }
                    $composer4.startReplaceGroup(-672833937);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(convertAudio$delegate) | $composer4.changed(function2) | $composer4.changed(onDismissRequest);
                    final Function0<Unit> function4 = function2;
                    final Function0<Unit> function5 = onDismissRequest;
                    final MutableState<Boolean> mutableState = convertAudio$delegate;
                    final MutableIntState mutableIntState = audioFormat$delegate;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioConversionQuickSettingsDialog$2$1$1
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
                                PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.AUDIO_CONVERT, FormatSettingDialogsKt.AudioConversionQuickSettingsDialog$lambda$41(mutableState));
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.AUDIO_CONVERSION_FORMAT, FormatSettingDialogsKt.AudioConversionQuickSettingsDialog$lambda$39(mutableIntState));
                                function4.invoke();
                                function5.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv2, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-1657685599, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionQuickSettingsDialog.3
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C378@15530L22,378@15516L36:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1657685599, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:378)");
                    }
                    $composer4.startReplaceGroup(-672834160);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function4 = onDismissRequest;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioConversionQuickSettingsDialog$3$1$1
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
                                function4.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv2, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7371getLambda17$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7372getLambda18$app_debug(), ComposableLambdaKt.rememberComposableLambda(-802277890, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionQuickSettingsDialog.4
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
                    Function0<ComposeUiNode> function4;
                    String str;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C392@16028L21,392@15986L1092:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-802277890, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioConversionQuickSettingsDialog.<anonymous> (FormatSettingDialogs.kt:392)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                        final MutableState<Boolean> mutableState = convertAudio$delegate;
                        final MutableIntState mutableIntState = audioFormat$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function4 = constructor;
                            $composer4.createNode(function4);
                        } else {
                            function4 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1947977523, "C398@16286L50,399@16380L10,393@16070L348,402@16486L41,404@16592L60,401@16435L217:FormatSettingDialogs.kt#5yb39d");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.convert_audio_format_desc, $composer4, 0), PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 48, 0, 65532);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.not_convert, $composer4, 0);
                        boolean z = !FormatSettingDialogsKt.AudioConversionQuickSettingsDialog$lambda$41(mutableState);
                        $composer4.startReplaceGroup(-1947977001);
                        String str2 = "CC(remember):FormatSettingDialogs.kt#9igjgp";
                        ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(mutableState);
                        Object value$iv3 = $composer4.rememberedValue();
                        if (invalid$iv || value$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioConversionQuickSettingsDialog$4$1$1$1
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
                                    FormatSettingDialogsKt.AudioConversionQuickSettingsDialog$lambda$42(mutableState, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                        }
                        $composer4.endReplaceGroup();
                        DialogItemsKt.DialogSingleChoiceItem(null, strStringResource, z, (Function0) value$iv3, $composer4, 0, 1);
                        $composer4.startReplaceGroup(-672833021);
                        ComposerKt.sourceInformation($composer4, "*412@16957L107,408@16725L339");
                        final int i5 = 0;
                        while (i5 < 2) {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            String audioConvertDesc = PreferenceStrings.INSTANCE.getAudioConvertDesc(i5);
                            boolean z2 = FormatSettingDialogsKt.AudioConversionQuickSettingsDialog$lambda$39(mutableIntState) == i5 && FormatSettingDialogsKt.AudioConversionQuickSettingsDialog$lambda$41(mutableState);
                            $composer4.startReplaceGroup(-1947976636);
                            ComposerKt.sourceInformation($composer4, str2);
                            boolean invalid$iv2 = $composer4.changed(i5) | $composer4.changed(mutableState);
                            Object it$iv2 = $composer4.rememberedValue();
                            if (!invalid$iv2) {
                                str = str2;
                                if (it$iv2 != Composer.INSTANCE.getEmpty()) {
                                    value$iv2 = it$iv2;
                                }
                                $composer4.endReplaceGroup();
                                DialogItemsKt.DialogSingleChoiceItem(companion, audioConvertDesc, z2, (Function0) value$iv2, $composer4, 6, 0);
                                i5++;
                                str2 = str;
                            } else {
                                str = str2;
                            }
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioConversionQuickSettingsDialog$4$1$2$1
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
                                    mutableIntState.setIntValue(i5);
                                    FormatSettingDialogsKt.AudioConversionQuickSettingsDialog$lambda$42(mutableState, true);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                            $composer4.endReplaceGroup();
                            DialogItemsKt.DialogSingleChoiceItem(companion, audioConvertDesc, z2, (Function0) value$iv2, $composer4, 6, 0);
                            i5++;
                            str2 = str;
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
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioConversionQuickSettingsDialog.5
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
                    FormatSettingDialogsKt.AudioConversionQuickSettingsDialog(onDismissRequest, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AudioConversionQuickSettingsDialog$lambda$39(MutableIntState $audioFormat$delegate) {
        MutableIntState $this$getValue$iv = $audioFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AudioConversionQuickSettingsDialog$lambda$41(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AudioConversionQuickSettingsDialog$lambda$42(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void VideoFormatDialog(int videoFormatPreference, Function0<Unit> function0, Function1<? super Integer, Unit> function1, Composer $composer, final int $changed, final int i) {
        int i2;
        Function0<Unit> function2;
        Function1<? super Integer, Unit> function3;
        Object value$iv;
        int videoFormatPreference2;
        Function0<Unit> function4;
        Composer $composer2 = $composer.startRestartGroup(553530259);
        ComposerKt.sourceInformation($composer2, "C(VideoFormatDialog)P(2,1)428@17292L53,441@17730L212,431@17431L136,448@17951L760,429@17350L1362:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            i2 = videoFormatPreference;
        } else if (($changed & 14) == 0) {
            i2 = videoFormatPreference;
            $dirty |= $composer2.changed(i2) ? 4 : 2;
        } else {
            i2 = videoFormatPreference;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            function2 = function0;
        } else if (($changed & 112) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = function0;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            function3 = function1;
        } else if (($changed & 896) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function4 = function2;
            videoFormatPreference2 = i2;
        } else {
            int videoFormatPreference3 = i3 != 0 ? 1 : i2;
            final C10211 c10211 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoFormatDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            final C10222 c10222 = i5 != 0 ? new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoFormatDialog.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int it) {
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(553530259, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoFormatDialog (FormatSettingDialogs.kt:427)");
            }
            $composer2.startReplaceGroup(-139808703);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotIntStateKt.mutableIntStateOf(videoFormatPreference3);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableIntState preference$delegate = (MutableIntState) value$iv;
            $composer2.endReplaceGroup();
            DialogsKt.m7162LoopDialogOix01E0(null, c10211, ComposableLambdaKt.rememberComposableLambda(271524782, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoFormatDialog.3
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C442@17765L88,442@17744L188:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(271524782, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoFormatDialog.<anonymous> (FormatSettingDialogs.kt:442)");
                    }
                    $composer3.startReplaceGroup(1795378363);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c10222) | $composer3.changed(c10211);
                    final Function1<Integer, Unit> function5 = c10222;
                    final Function0<Unit> function6 = c10211;
                    final MutableIntState mutableIntState = preference$delegate;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoFormatDialog$3$1$1
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
                                function5.invoke(Integer.valueOf(FormatSettingDialogsKt.VideoFormatDialog$lambda$44(mutableIntState)));
                                function6.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    ButtonKt.TextButton((Function0) value$iv2, null, false, null, null, null, null, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7373getLambda19$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(464455983, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoFormatDialog.4
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
                    ComposerKt.sourceInformation($composer3, "C433@17446L109:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(464455983, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoFormatDialog.<anonymous> (FormatSettingDialogs.kt:433)");
                        }
                        ButtonKt.TextButton(c10211, null, false, null, null, null, null, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7375getLambda20$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7376getLambda21$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7377getLambda22$app_debug(), ComposableLambdaKt.rememberComposableLambda(1043249586, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoFormatDialog.5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C449@17965L735:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1043249586, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoFormatDialog.<anonymous> (FormatSettingDialogs.kt:449)");
                    }
                    final MutableIntState mutableIntState = preference$delegate;
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
                    int i6 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i7 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1823211197, "C450@17990L19,451@18107L542,451@18026L623,463@18666L19:FormatSettingDialogs.kt#5yb39d");
                    DividerKt.m7164HorizontalDivideriJQMabo(null, 0L, $composer3, 0, 3);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    PaddingValues paddingValuesM615PaddingValuesYgX7TsA$default = PaddingKt.m615PaddingValuesYgX7TsA$default(0.0f, Dp.m6553constructorimpl(8), 1, null);
                    $composer3.startReplaceGroup(1823211314);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    Object it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoFormatDialog$5$1$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{1, 2}).iterator();
                                while (it.hasNext()) {
                                    final int i8 = ((Number) it.next()).intValue();
                                    final MutableIntState mutableIntState2 = mutableIntState;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-459503010, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoFormatDialog$5$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                            Object value$iv3;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer4, "C457@18388L22,458@18470L25,460@18587L18,455@18245L360:FormatSettingDialogs.kt#5yb39d");
                                            if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                                $composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-459503010, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoFormatDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:455)");
                                            }
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            String videoFormatLabel = PreferenceStrings.INSTANCE.getVideoFormatLabel(i8, $composer4, 48, 0);
                                            String videoFormatDescComp = PreferenceStrings.INSTANCE.getVideoFormatDescComp(i8, $composer4, 48, 0);
                                            boolean z = FormatSettingDialogsKt.VideoFormatDialog$lambda$44(mutableIntState2) == i8;
                                            $composer4.startReplaceGroup(1633491829);
                                            ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                            boolean invalid$iv = $composer4.changed(i8);
                                            final int i9 = i8;
                                            final MutableIntState mutableIntState3 = mutableIntState2;
                                            Object it$iv3 = $composer4.rememberedValue();
                                            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                                value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoFormatDialog$5$1$1$1$1$1$1
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
                                                        mutableIntState3.setIntValue(i9);
                                                    }
                                                };
                                                $composer4.updateRememberedValue(value$iv3);
                                            } else {
                                                value$iv3 = it$iv3;
                                            }
                                            $composer4.endReplaceGroup();
                                            DialogItemsKt.DialogSingleChoiceItemWithLabel(companion2, videoFormatLabel, videoFormatDescComp, z, (Function0) value$iv3, $composer4, 6, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), 3, null);
                                }
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    LazyDslKt.LazyColumn(companion, null, paddingValuesM615PaddingValuesYgX7TsA$default, false, null, null, null, false, (Function1) value$iv2, $composer3, 100663686, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    DividerKt.m7164HorizontalDivideriJQMabo(null, 0L, $composer3, 0, 3);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            videoFormatPreference2 = videoFormatPreference3;
            function4 = c10211;
            function3 = c10222;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int $dirty2 = videoFormatPreference2;
            final Function0<Unit> function5 = function4;
            final Function1<? super Integer, Unit> function6 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoFormatDialog.6
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

                public final void invoke(Composer composer, int i6) {
                    FormatSettingDialogsKt.VideoFormatDialog($dirty2, function5, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoFormatDialog$lambda$44(MutableIntState $preference$delegate) {
        MutableIntState $this$getValue$iv = $preference$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public static final void AudioFormatDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-1276957634);
        ComposerKt.sourceInformation($composer3, "C(AudioFormatDialog)472@18818L8,482@19208L140,475@18912L133,487@19357L761,473@18831L1288:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1276957634, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioFormatDialog (FormatSettingDialogs.kt:471)");
            }
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_FORMAT, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableIntState audioFormat$delegate = (MutableIntState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, onDismissRequest, ComposableLambdaKt.rememberComposableLambda(543987609, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioFormatDialog.1
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C483@19236L102,483@19222L116:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(543987609, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioFormatDialog.<anonymous> (FormatSettingDialogs.kt:483)");
                    }
                    $composer4.startReplaceGroup(836515711);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(audioFormat$delegate) | $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    final MutableIntState mutableIntState = audioFormat$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioFormatDialog$1$1$1
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
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.AUDIO_FORMAT, FormatSettingDialogsKt.AudioFormatDialog$lambda$46(mutableIntState));
                                function0.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-904019238, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioFormatDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C476@18926L109:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-904019238, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioFormatDialog.<anonymous> (FormatSettingDialogs.kt:476)");
                        }
                        ButtonKt.TextButton(onDismissRequest, null, false, null, null, null, null, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7378getLambda23$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7379getLambda24$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7380getLambda25$app_debug(), ComposableLambdaKt.rememberComposableLambda(-953072483, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioFormatDialog.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer4, "C488@19413L21,488@19371L737:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-953072483, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioFormatDialog.<anonymous> (FormatSettingDialogs.kt:488)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                        final MutableIntState mutableIntState = audioFormat$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function0 = constructor;
                            $composer4.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1931179525, "C494@19671L46,495@19761L10,489@19455L344:FormatSettingDialogs.kt#5yb39d");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.preferred_format_desc, $composer4, 0), PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 48, 0, 65532);
                        $composer4.startReplaceGroup(836516291);
                        ComposerKt.sourceInformation($composer4, "*502@20075L19,498@19860L234");
                        final int i3 = 0;
                        while (i3 < 3) {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            String audioFormatDesc = PreferenceStrings.INSTANCE.getAudioFormatDesc(i3);
                            boolean z = FormatSettingDialogsKt.AudioFormatDialog$lambda$46(mutableIntState) == i3;
                            $composer4.startReplaceGroup(-1931178905);
                            ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                            boolean invalid$iv = $composer4.changed(mutableIntState) | $composer4.changed(i3);
                            Object value$iv = $composer4.rememberedValue();
                            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioFormatDialog$3$1$1$1
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
                                        mutableIntState.setIntValue(i3);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv);
                            }
                            $composer4.endReplaceGroup();
                            DialogItemsKt.DialogSingleChoiceItem(companion, audioFormatDesc, z, (Function0) value$iv, $composer4, 6, 0);
                            i3++;
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
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioFormatDialog.4
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
                    FormatSettingDialogsKt.AudioFormatDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AudioFormatDialog$lambda$46(MutableIntState $audioFormat$delegate) {
        MutableIntState $this$getValue$iv = $audioFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public static final void AudioQualityDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-774415306);
        ComposerKt.sourceInformation($composer3, "C(AudioQualityDialog)509@20228L8,517@20537L142,512@20322L60,522@20688L773,510@20241L1221:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-774415306, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQualityDialog (FormatSettingDialogs.kt:508)");
            }
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_QUALITY, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableIntState audioQuality$delegate = (MutableIntState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-159687621, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQualityDialog.1
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C518@20565L104,518@20551L118:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-159687621, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQualityDialog.<anonymous> (FormatSettingDialogs.kt:518)");
                    }
                    $composer4.startReplaceGroup(-1433440810);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(audioQuality$delegate) | $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    final MutableIntState mutableIntState = audioQuality$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQualityDialog$1$1$1
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
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.AUDIO_QUALITY, FormatSettingDialogsKt.AudioQualityDialog$lambda$48(mutableIntState));
                                function0.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-2098226918, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQualityDialog.2
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C513@20350L22,513@20336L36:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2098226918, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQualityDialog.<anonymous> (FormatSettingDialogs.kt:513)");
                    }
                    $composer4.startReplaceGroup(-1433441025);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQualityDialog$2$1$1
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
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7381getLambda26$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7382getLambda27$app_debug(), ComposableLambdaKt.rememberComposableLambda(676089783, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQualityDialog.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer4, "C523@20744L21,523@20702L749:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(676089783, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.AudioQualityDialog.<anonymous> (FormatSettingDialogs.kt:523)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null);
                        final MutableIntState mutableIntState = audioQuality$delegate;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function0 = constructor;
                            $composer4.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 214513492, "C529@21002L43,530@21089L10,524@20786L341:FormatSettingDialogs.kt#5yb39d");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.audio_quality_desc, $composer4, 0), PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 48, 0, 65532);
                        $composer4.startReplaceGroup(-1433440231);
                        ComposerKt.sourceInformation($composer4, "*537@21417L20,533@21200L237");
                        final int i3 = 0;
                        while (i3 < 5) {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            String audioQualityDesc = PreferenceStrings.INSTANCE.getAudioQualityDesc(i3);
                            boolean z = FormatSettingDialogsKt.AudioQualityDialog$lambda$48(mutableIntState) == i3;
                            $composer4.startReplaceGroup(214514123);
                            ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                            boolean invalid$iv = $composer4.changed(mutableIntState) | $composer4.changed(i3);
                            Object value$iv = $composer4.rememberedValue();
                            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$AudioQualityDialog$3$1$1$1
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
                                        mutableIntState.setIntValue(i3);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv);
                            }
                            $composer4.endReplaceGroup();
                            DialogItemsKt.DialogSingleChoiceItem(companion, audioQualityDesc, z, (Function0) value$iv, $composer4, 6, 0);
                            i3++;
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
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.AudioQualityDialog.4
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
                    FormatSettingDialogsKt.AudioQualityDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AudioQualityDialog$lambda$48(MutableIntState $audioQuality$delegate) {
        MutableIntState $this$getValue$iv = $audioQuality$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public static final void FormatSortingDialog(final String fields, boolean showSwitch, boolean toggleableValue, Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Function0<Unit> function2, Function1<? super String, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean toggleableValue2;
        Function1<? super Boolean, Unit> function4;
        Function0<Unit> function5;
        final C10043 c10043;
        Object value$iv;
        boolean showSwitch2;
        Function1<? super Boolean, Unit> function6;
        Function0<Unit> function7;
        Function0<Unit> function8;
        Function1<? super String, Unit> function9;
        boolean toggleableValue3;
        Intrinsics.checkNotNullParameter(fields, "fields");
        Composer $composer2 = $composer.startRestartGroup(326647011);
        ComposerKt.sourceInformation($composer2, "C(FormatSortingDialog)P(!1,5,6,4,3,2)552@21775L55,562@22138L172,557@21916L60,567@22319L2302,555@21835L2787:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(fields) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            z = showSwitch;
        } else if (($changed & 112) == 0) {
            z = showSwitch;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = showSwitch;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            toggleableValue2 = toggleableValue;
        } else if (($changed & 896) == 0) {
            toggleableValue2 = toggleableValue;
            $dirty |= $composer2.changed(toggleableValue2) ? 256 : 128;
        } else {
            toggleableValue2 = toggleableValue;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function4 = function1;
        } else if (($changed & 7168) == 0) {
            function4 = function1;
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        } else {
            function4 = function1;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            function5 = function0;
        } else if ((57344 & $changed) == 0) {
            function5 = function0;
            $dirty |= $composer2.changedInstance(function5) ? 16384 : 8192;
        } else {
            function5 = function0;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            c10043 = function2;
        } else if (($changed & 458752) == 0) {
            c10043 = function2;
            $dirty |= $composer2.changedInstance(c10043) ? 131072 : 65536;
        } else {
            c10043 = function2;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function9 = function3;
            function8 = c10043;
            toggleableValue3 = toggleableValue2;
            function7 = function5;
            function6 = function4;
            showSwitch2 = z;
        } else {
            boolean showSwitch3 = i2 != 0 ? false : z;
            if (i3 != 0) {
                toggleableValue2 = false;
            }
            C10021 c10021 = i4 != 0 ? new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                }
            } : function4;
            C10032 c10032 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function5;
            if (i6 != 0) {
                c10043 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.3
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                };
            }
            final C10054 c10054 = i7 != 0 ? new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(326647011, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.format.FormatSortingDialog (FormatSettingDialogs.kt:551)");
            }
            $composer2.startReplaceGroup(-681486231);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fields, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState sortingFields$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            final boolean z2 = showSwitch3;
            final boolean z3 = toggleableValue2;
            final Function1<? super Boolean, Unit> function10 = c10021;
            final Function0<Unit> function11 = c10032;
            boolean showSwitch4 = showSwitch3;
            DialogsKt.m7162LoopDialogOix01E0(null, c10043, ComposableLambdaKt.rememberComposableLambda(-1547573464, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.5
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C563@22173L34,563@22209L91,563@22152L148:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1547573464, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.FormatSortingDialog.<anonymous> (FormatSettingDialogs.kt:563)");
                    }
                    String strStringResource = StringResources_androidKt.stringResource(R.string.save, $composer3, 0);
                    $composer3.startReplaceGroup(-369351364);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(c10054) | $composer3.changed(sortingFields$delegate) | $composer3.changed(c10043);
                    final Function1<String, Unit> function12 = c10054;
                    final Function0<Unit> function13 = c10043;
                    final MutableState<String> mutableState = sortingFields$delegate;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$FormatSortingDialog$5$1$1
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
                                function12.invoke(FormatSettingDialogsKt.FormatSortingDialog$lambda$51(mutableState));
                                function13.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.ConfirmButton(strStringResource, false, (Function0) value$iv2, $composer3, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1784191289, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.6
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C558@21944L22,558@21930L36:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1784191289, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.FormatSortingDialog.<anonymous> (FormatSettingDialogs.kt:558)");
                    }
                    $composer3.startReplaceGroup(-369351629);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(c10043);
                    final Function0<Unit> function12 = c10043;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$FormatSortingDialog$6$1$1
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
                                function12.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv2, $composer3, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7383getLambda28$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7384getLambda29$app_debug(), ComposableLambdaKt.rememberComposableLambda(1800922532, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.7
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
                    Function0<ComposeUiNode> function12;
                    Object value$iv2;
                    Function0<ComposeUiNode> function13;
                    Object value$iv3;
                    Composer $composer4;
                    ComposerKt.sourceInformation($composer3, "C569@22392L21,568@22333L2278:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1800922532, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.FormatSortingDialog.<anonymous> (FormatSettingDialogs.kt:568)");
                    }
                    Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                    final MutableState<String> mutableState = sortingFields$delegate;
                    boolean z4 = z2;
                    boolean z5 = z3;
                    Function1<Boolean, Unit> function14 = function10;
                    final Function0<Unit> function15 = function11;
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
                        function12 = constructor;
                        $composer3.createNode(function12);
                    } else {
                        function12 = constructor;
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
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i9 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1969076277, "C576@22663L44,577@22751L10,571@22447L342,582@22990L22,579@22806L399,586@23255L7,590@23419L21,587@23279L871:FormatSettingDialogs.kt#5yb39d");
                    TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.format_sorting_desc, $composer3, 0), PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge(), $composer3, 48, 0, 65532);
                    Modifier modifierM621paddingVpY3zN4 = PaddingKt.m621paddingVpY3zN4(Modifier.INSTANCE, Dp.m6553constructorimpl(24), Dp.m6553constructorimpl(8));
                    String strFormatSortingDialog$lambda$51 = FormatSettingDialogsKt.FormatSortingDialog$lambda$51(mutableState);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    $composer3.startReplaceGroup(-1969075734);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(mutableState);
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$FormatSortingDialog$7$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableState.setValue(it);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    OutlinedTextFieldKt.OutlinedTextField(strFormatSortingDialog$lambda$51, (Function1<? super String, Unit>) value$iv2, modifierM621paddingVpY3zN4, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7386getLambda30$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer3, 100663680, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 8355576);
                    ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localUriHandler);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    final UriHandler uriHandler = (UriHandler) objConsume;
                    Modifier modifier$iv2 = PaddingKt.m622paddingVpY3zN4$default(ScrollKt.horizontalScroll$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(16), 0.0f, 2, null), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null), Dp.m6553constructorimpl(8), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                    int $i$f$Row = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, $i$f$Row);
                    int $changed$iv$iv2 = (0 << 3) & 112;
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
                        function13 = constructor2;
                        $composer3.createNode(function13);
                    } else {
                        function13 = constructor2;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    int i11 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1183188011, "C595@23651L53,597@23790L58,593@23534L314,601@23921L36,600@23869L263:FormatSettingDialogs.kt#5yb39d");
                    Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null);
                    String strStringResource = StringResources_androidKt.stringResource(R.string.import_from_preferences, $composer3, 0);
                    ImageVector settingsSuggest = SettingsSuggestKt.getSettingsSuggest(Icons.Outlined.INSTANCE);
                    $composer3.startReplaceGroup(1183188267);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv3 = $composer3.changed(function15);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$FormatSortingDialog$7$1$2$1$1
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
                                function15.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer3.endReplaceGroup();
                    ChipsKt.OutlinedButtonChip(modifierM624paddingqDBjuR0$default, settingsSuggest, strStringResource, null, (Function0) value$iv3, $composer3, 6, 8);
                    ChipsKt.OutlinedButtonChip(null, OpenInNewKt.getOpenInNew(Icons.AutoMirrored.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.yt_dlp_docs, $composer3, 0), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$FormatSortingDialog$7$1$2$2
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
                            uriHandler.openUri("https://github.com/yt-dlp/yt-dlp#sorting-formats");
                        }
                    }, $composer3, 0, 9);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.startReplaceGroup(-369349406);
                    ComposerKt.sourceInformation($composer3, "608@24205L41,609@24267L66,611@24403L48,610@24354L225");
                    if (z4) {
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12)), $composer3, 6);
                        DividerKt.m7164HorizontalDivideriJQMabo(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(24), 0.0f, 2, null), 0L, $composer3, 6, 2);
                        $composer4 = $composer3;
                        DialogItemsKt.DialogSwitchItem(null, StringResources_androidKt.stringResource(R.string.use_format_sorting, $composer3, 0), z5, function14, $composer4, 0, 1);
                    } else {
                        $composer4 = $composer3;
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 12) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            showSwitch2 = showSwitch4;
            function6 = c10021;
            function7 = c10032;
            function8 = c10043;
            function9 = c10054;
            toggleableValue3 = toggleableValue2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z4 = showSwitch2;
            final boolean z5 = toggleableValue3;
            final Function1<? super Boolean, Unit> function12 = function6;
            final Function0<Unit> function13 = function7;
            final Function0<Unit> function14 = function8;
            final Function1<? super String, Unit> function15 = function9;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialog.8
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
                    FormatSettingDialogsKt.FormatSortingDialog(fields, z4, z5, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String FormatSortingDialog$lambda$51(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatSortingDialogPreview(Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1353848562);
        ComposerKt.sourceInformation($composer2, "C(FormatSortingDialogPreview)623@24707L34,628@24874L14,624@24746L143:FormatSettingDialogs.kt#5yb39d");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1353848562, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.format.FormatSortingDialogPreview (FormatSettingDialogs.kt:622)");
            }
            $composer2.startReplaceGroup(706592065);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState value$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            boolean zFormatSortingDialogPreview$lambda$54 = FormatSortingDialogPreview$lambda$54(value$delegate);
            $composer2.startReplaceGroup(706592232);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$FormatSortingDialogPreview$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean it) {
                        FormatSettingDialogsKt.FormatSortingDialogPreview$lambda$55(value$delegate, it);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            FormatSortingDialog("", true, zFormatSortingDialogPreview$lambda$54, (Function1) value$iv2, null, null, null, $composer2, 3126, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.FormatSortingDialogPreview.2
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
                    FormatSettingDialogsKt.FormatSortingDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final boolean FormatSortingDialogPreview$lambda$54(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatSortingDialogPreview$lambda$55(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void VideoQualityDialog(int videoQuality, Function0<Unit> function0, Function1<? super Integer, Unit> function1, Composer $composer, final int $changed, final int i) {
        int i2;
        Function0<Unit> function2;
        Function1<? super Integer, Unit> function3;
        Object value$iv;
        int videoQuality2;
        Function0<Unit> function4;
        Composer $composer2 = $composer.startRestartGroup(30707041);
        ComposerKt.sourceInformation($composer2, "C(VideoQualityDialog)P(2,1)637@25060L44,649@25487L217,641@25191L133,656@25713L946,639@25110L1550:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            i2 = videoQuality;
        } else if (($changed & 14) == 0) {
            i2 = videoQuality;
            $dirty |= $composer2.changed(i2) ? 4 : 2;
        } else {
            i2 = videoQuality;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            function2 = function0;
        } else if (($changed & 112) == 0) {
            function2 = function0;
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = function0;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            function3 = function1;
        } else if (($changed & 896) == 0) {
            function3 = function1;
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function4 = function2;
            videoQuality2 = i2;
        } else {
            int videoQuality3 = i3 != 0 ? 0 : i2;
            final C10271 c10271 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            final C10282 c10282 = i5 != 0 ? new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityDialog.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int it) {
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(30707041, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQualityDialog (FormatSettingDialogs.kt:636)");
            }
            $composer2.startReplaceGroup(-1120239319);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotIntStateKt.mutableIntStateOf(videoQuality3);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableIntState videoResolution$delegate = (MutableIntState) value$iv;
            $composer2.endReplaceGroup();
            DialogsKt.m7162LoopDialogOix01E0(null, c10271, ComposableLambdaKt.rememberComposableLambda(-121528154, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityDialog.3
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C650@25522L93,650@25501L193:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-121528154, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQualityDialog.<anonymous> (FormatSettingDialogs.kt:650)");
                    }
                    $composer3.startReplaceGroup(-1773419112);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(c10282) | $composer3.changed(c10271);
                    final Function1<Integer, Unit> function5 = c10282;
                    final Function0<Unit> function6 = c10271;
                    final MutableIntState mutableIntState = videoResolution$delegate;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQualityDialog$3$1$1
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
                                function5.invoke(Integer.valueOf(FormatSettingDialogsKt.VideoQualityDialog$lambda$58(mutableIntState)));
                                function6.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    ButtonKt.TextButton((Function0) value$iv2, null, false, null, null, null, null, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7387getLambda31$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(1564371781, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityDialog.4
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
                    ComposerKt.sourceInformation($composer3, "C642@25205L109:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1564371781, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQualityDialog.<anonymous> (FormatSettingDialogs.kt:642)");
                        }
                        ButtonKt.TextButton(c10271, null, false, null, null, null, null, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7388getLambda32$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7389getLambda33$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7390getLambda34$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1967863006, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityDialog.5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function5;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C657@25727L922:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1967863006, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQualityDialog.<anonymous> (FormatSettingDialogs.kt:657)");
                        }
                        final MutableIntState mutableIntState = videoResolution$delegate;
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
                            function5 = constructor;
                            $composer3.createNode(function5);
                        } else {
                            function5 = constructor;
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
                        int i6 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 636559265, "C663@25970L43,664@26057L10,658@25754L341,666@26125L510,666@26112L523:FormatSettingDialogs.kt#5yb39d");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.video_quality_desc, $composer3, 0), PaddingKt.m622paddingVpY3zN4$default(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(12), 7, null), Dp.m6553constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyLarge(), $composer3, 48, 0, 65532);
                        $composer3.startReplaceGroup(636559636);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                        Object it$iv2 = $composer3.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQualityDialog$5$1$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    for (final int i8 = 0; i8 < 8; i8++) {
                                        final MutableIntState mutableIntState2 = mutableIntState;
                                        LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1308553226, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQualityDialog$5$1$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                                invoke(lazyItemScope, composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope item, Composer $composer4, int $changed3) {
                                                Object value$iv3;
                                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                                ComposerKt.sourceInformation($composer4, "C673@26486L83,670@26284L285:FormatSettingDialogs.kt#5yb39d");
                                                if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1308553226, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQualityDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:670)");
                                                    }
                                                    String videoResolutionDesc = PreferenceStrings.INSTANCE.getVideoResolutionDesc(i8);
                                                    boolean z = FormatSettingDialogsKt.VideoQualityDialog$lambda$58(mutableIntState2) == i8;
                                                    $composer4.startReplaceGroup(-97504032);
                                                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                                    boolean invalid$iv = $composer4.changed(i8);
                                                    final int i9 = i8;
                                                    final MutableIntState mutableIntState3 = mutableIntState2;
                                                    Object it$iv3 = $composer4.rememberedValue();
                                                    if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$VideoQualityDialog$5$1$1$1$1$1$1
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
                                                                mutableIntState3.setIntValue(i9);
                                                            }
                                                        };
                                                        $composer4.updateRememberedValue(value$iv3);
                                                    } else {
                                                        value$iv3 = it$iv3;
                                                    }
                                                    $composer4.endReplaceGroup();
                                                    DialogItemsKt.DialogSingleChoiceItem(null, videoResolutionDesc, z, (Function0) value$iv3, $composer4, 0, 1);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer4.skipToGroupEnd();
                                            }
                                        }), 3, null);
                                    }
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, (Function1) value$iv2, $composer3, 100663296, 255);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            videoQuality2 = videoQuality3;
            function4 = c10271;
            function3 = c10282;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int $dirty2 = videoQuality2;
            final Function0<Unit> function5 = function4;
            final Function1<? super Integer, Unit> function6 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityDialog.6
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

                public final void invoke(Composer composer, int i6) {
                    FormatSettingDialogsKt.VideoQualityDialog($dirty2, function5, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int VideoQualityDialog$lambda$58(MutableIntState $videoResolution$delegate) {
        MutableIntState $this$getValue$iv = $videoResolution$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public static final void SubtitleLanguageDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer2 = $composer.startRestartGroup(-207062211);
        ComposerKt.sourceInformation($composer2, "C(SubtitleLanguageDialog)688@26949L11,692@27094L154,689@26965L350:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-207062211, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleLanguageDialog (FormatSettingDialogs.kt:687)");
            }
            $composer2.startReplaceGroup(275724887);
            ComposerKt.sourceInformation($composer2, "CC16@579L45:Ext.kt#x6o9ax");
            $composer2.startReplaceGroup(105103929);
            ComposerKt.sourceInformation($composer2, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE_LANGUAGE, null, 1, null), null, 2, null);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableState languages$delegate = (MutableState) value$iv$iv;
            $composer2.endReplaceGroup();
            $composer2.endReplaceGroup();
            String strSubtitleLanguageDialog$lambda$60 = SubtitleLanguageDialog$lambda$60(languages$delegate);
            $composer2.startReplaceGroup(711220111);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(languages$delegate);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleLanguageDialog$1$1
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
                        MutableState<String> mutableState = languages$delegate;
                        mutableState.setValue(PreferenceUtilKt.getStringDefault(PreferenceUtilKt.SUBTITLE_LANGUAGE));
                        PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.SUBTITLE_LANGUAGE, FormatSettingDialogsKt.SubtitleLanguageDialog$lambda$60(mutableState));
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            SubtitleLanguageDialogImpl(onDismissRequest, strSubtitleLanguageDialog$lambda$60, (Function0) value$iv, new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialog.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.SUBTITLE_LANGUAGE, it);
                }
            }, $composer2, ($dirty2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialog.3
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
                    FormatSettingDialogsKt.SubtitleLanguageDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SubtitleLanguageDialog$lambda$60(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SubtitleLanguageDialogImpl(Function0<Unit> function0, String initialLanguages, Function0<Unit> function1, Function1<? super String, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function3;
        String initialLanguages2;
        Function0<Unit> function4;
        Function1<? super String, Unit> function5;
        Object value$iv;
        Function0<Unit> function6;
        Composer $composer2 = $composer.startRestartGroup(1553271879);
        ComposerKt.sourceInformation($composer2, "C(SubtitleLanguageDialogImpl)P(2!1,3)711@27560L63,712@27661L7,760@29771L127,765@29916L90,717@27876L1877,713@27673L2334:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function3 = function0;
        } else if (($changed & 14) == 0) {
            function3 = function0;
            $dirty |= $composer2.changedInstance(function3) ? 4 : 2;
        } else {
            function3 = function0;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            initialLanguages2 = initialLanguages;
        } else if (($changed & 112) == 0) {
            initialLanguages2 = initialLanguages;
            $dirty |= $composer2.changed(initialLanguages2) ? 32 : 16;
        } else {
            initialLanguages2 = initialLanguages;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function4 = function1;
        } else if (($changed & 896) == 0) {
            function4 = function1;
            $dirty |= $composer2.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function1;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            function5 = function2;
        } else if (($changed & 7168) == 0) {
            function5 = function2;
            $dirty |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function2;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function6 = function3;
        } else {
            final C10141 c10141 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialogImpl.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            String initialLanguages3 = i3 != 0 ? "en.*,.*-orig" : initialLanguages2;
            final C10152 c10152 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialogImpl.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function4;
            final C10163 c10163 = i5 != 0 ? new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialogImpl.3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            } : function5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1553271879, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleLanguageDialogImpl (FormatSettingDialogs.kt:710)");
            }
            $composer2.startReplaceGroup(-1821717855);
            ComposerKt.sourceInformation($composer2, "CC(remember):FormatSettingDialogs.kt#9igjgp");
            boolean invalid$iv = ($dirty & 112) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialLanguages3, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState languages$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final UriHandler uriHandler = (UriHandler) objConsume;
            Function1<? super String, Unit> function7 = c10163;
            DialogsKt.m7162LoopDialogOix01E0(null, c10141, ComposableLambdaKt.rememberComposableLambda(447555106, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialogImpl.4
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C761@29801L87,761@29785L103:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(447555106, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleLanguageDialogImpl.<anonymous> (FormatSettingDialogs.kt:761)");
                    }
                    $composer3.startReplaceGroup(-1758058493);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(c10163) | $composer3.changed(languages$delegate) | $composer3.changed(c10141);
                    final Function1<String, Unit> function8 = c10163;
                    final Function0<Unit> function9 = c10141;
                    final MutableState<String> mutableState = languages$delegate;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleLanguageDialogImpl$4$1$1
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
                                function8.invoke(FormatSettingDialogsKt.SubtitleLanguageDialogImpl$lambda$64(mutableState));
                                function9.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv2, $composer3, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1375632157, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialogImpl.5
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C766@29946L50,766@29930L66:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1375632157, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleLanguageDialogImpl.<anonymous> (FormatSettingDialogs.kt:766)");
                    }
                    $composer3.startReplaceGroup(-1758058348);
                    ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(c10141);
                    final Function0<Unit> function8 = c10141;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleLanguageDialogImpl$5$1$1
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
                                function8.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer3.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv2, $composer3, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7391getLambda35$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7392getLambda36$app_debug(), ComposableLambdaKt.rememberComposableLambda(1744740646, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialogImpl.6
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
                    Function0<ComposeUiNode> function8;
                    Function0<ComposeUiNode> function9;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C718@27890L1853:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1744740646, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleLanguageDialogImpl.<anonymous> (FormatSettingDialogs.kt:718)");
                        }
                        final MutableState<String> mutableState = languages$delegate;
                        final Function0<Unit> function10 = c10152;
                        final UriHandler uriHandler2 = uriHandler;
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
                            function8 = constructor;
                            $composer3.createNode(function8);
                        } else {
                            function8 = constructor;
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
                        int i6 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1091210184, "C720@27950L52,719@27917L172,723@28106L41,724@28204L7,724@28254L559,724@28164L649,737@28830L40,742@29028L21,739@28888L841:FormatSettingDialogs.kt#5yb39d");
                        TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.subtitle_language_desc, $composer3, 0), PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(24), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 48, 0, 131068);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), $composer3, 6);
                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = $composer3.consume(localTextStyle);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        TextKt.ProvideTextStyle(((TextStyle) objConsume2).m6048mergedA7vx0o((16609105 & 1) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : 0L, (16609105 & 2) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 4) != 0 ? null : null, (16609105 & 8) != 0 ? null : null, (16609105 & 16) != 0 ? null : null, (16609105 & 32) != 0 ? null : FontFamily.INSTANCE.getMonospace(), (16609105 & 64) != 0 ? null : null, (16609105 & 128) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 256) != 0 ? null : null, (16609105 & 512) != 0 ? null : null, (16609105 & 1024) != 0 ? null : null, (16609105 & 2048) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : 0L, (16609105 & 4096) != 0 ? null : null, (16609105 & 8192) != 0 ? null : null, (16609105 & 16384) != 0 ? null : null, (16609105 & 32768) != 0 ? TextAlign.INSTANCE.m6416getUnspecifiede0LSkKk() : 0, (16609105 & 65536) != 0 ? TextDirection.INSTANCE.m6429getUnspecifieds_7Xco() : 0, (16609105 & 131072) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 262144) != 0 ? null : null, (16609105 & 524288) != 0 ? null : null, (16609105 & 1048576) != 0 ? LineBreak.INSTANCE.m6343getUnspecifiedrAG3T2k() : 0, (16609105 & 2097152) != 0 ? Hyphens.INSTANCE.m6322getUnspecifiedvmbZdU8() : 0, (16609105 & 4194304) != 0 ? null : null, (16609105 & 8388608) != 0 ? null : null), ComposableLambdaKt.rememberComposableLambda(-1418336755, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleLanguageDialogImpl$6$1$1
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
                                Object value$iv3;
                                ComposerKt.sourceInformation($composer4, "C730@28524L18,725@28276L519:FormatSettingDialogs.kt#5yb39d");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1418336755, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleLanguageDialogImpl.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:725)");
                                    }
                                    Modifier modifierM622paddingVpY3zN4$default = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, 2, null);
                                    String strSubtitleLanguageDialogImpl$lambda$64 = FormatSettingDialogsKt.SubtitleLanguageDialogImpl$lambda$64(mutableState);
                                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6185getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                                    $composer4.startReplaceGroup(1333415880);
                                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                    boolean invalid$iv2 = $composer4.changed(mutableState);
                                    final MutableState<String> mutableState2 = mutableState;
                                    Object it$iv2 = $composer4.rememberedValue();
                                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleLanguageDialogImpl$6$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                                invoke2(str);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(String it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                mutableState2.setValue(it);
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv2;
                                    }
                                    $composer4.endReplaceGroup();
                                    OutlinedTextFieldKt.OutlinedTextField(strSubtitleLanguageDialogImpl$lambda$64, (Function1<? super String, Unit>) value$iv3, modifierM622paddingVpY3zN4$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7393getLambda37$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1573248, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 8355768);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 48);
                        SpacerKt.Spacer(SizeKt.m651height3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), $composer3, 6);
                        Modifier modifier$iv2 = PaddingKt.m622paddingVpY3zN4$default(ScrollKt.horizontalScroll$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(16), 0.0f, 2, null), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null), Dp.m6553constructorimpl(8), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv2 = (0 << 3) & 112;
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
                            function9 = constructor2;
                            $composer3.createNode(function9);
                        } else {
                            function9 = constructor2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i9 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1333416499, "C747@29260L35,749@29370L57,745@29143L284,753@29500L36,752@29448L263:FormatSettingDialogs.kt#5yb39d");
                        Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.reset, $composer3, 0);
                        ImageVector sync = SyncKt.getSync(Icons.Outlined.INSTANCE);
                        $composer3.startReplaceGroup(1333416726);
                        ComposerKt.sourceInformation($composer3, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(function10);
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleLanguageDialogImpl$6$1$2$1$1
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
                                    function10.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        ChipsKt.OutlinedButtonChip(modifierM624paddingqDBjuR0$default, sync, strStringResource, null, (Function0) value$iv2, $composer3, 6, 8);
                        ChipsKt.OutlinedButtonChip(null, OpenInNewKt.getOpenInNew(Icons.AutoMirrored.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.yt_dlp_docs, $composer3, 0), null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleLanguageDialogImpl$6$1$2$2
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
                                uriHandler2.openUri("https://github.com/yt-dlp/yt-dlp#sorting-formats");
                            }
                        }, $composer3, 0, 9);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
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
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function7;
            function6 = c10141;
            initialLanguages2 = initialLanguages3;
            function4 = c10152;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function8 = function6;
            final String str = initialLanguages2;
            final Function0<Unit> function9 = function4;
            final Function1<? super String, Unit> function10 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleLanguageDialogImpl.7
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

                public final void invoke(Composer composer, int i6) {
                    FormatSettingDialogsKt.SubtitleLanguageDialogImpl(function8, str, function9, function10, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SubtitleLanguageDialogImpl$lambda$64(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void SubtitleConversionDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-1637548805);
        ComposerKt.sourceInformation($composer3, "C(SubtitleConversionDialog)774@30126L8,775@30203L126,780@30347L52,788@30634L877,775@30139L1373:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1637548805, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleConversionDialog (FormatSettingDialogs.kt:773)");
            }
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CONVERT_SUBTITLE, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableIntState currentFormat$delegate = (MutableIntState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            DialogsKt.m7162LoopDialogOix01E0(null, onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-1064819392, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleConversionDialog.1
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C776@30227L96,776@30213L110:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1064819392, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleConversionDialog.<anonymous> (FormatSettingDialogs.kt:776)");
                    }
                    $composer4.startReplaceGroup(-1202549841);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(currentFormat$delegate) | $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    final MutableIntState mutableIntState = currentFormat$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleConversionDialog$1$1$1
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
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.CONVERT_SUBTITLE, FormatSettingDialogsKt.SubtitleConversionDialog$lambda$66(mutableIntState));
                                function0.invoke();
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(812449503, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleConversionDialog.2
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C781@30371L22,781@30357L36:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(812449503, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleConversionDialog.<anonymous> (FormatSettingDialogs.kt:781)");
                    }
                    $composer4.startReplaceGroup(-1202549697);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleConversionDialog$2$1$1
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
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7394getLambda38$app_debug(), ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7395getLambda39$app_debug(), ComposableLambdaKt.rememberComposableLambda(-2145678404, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleConversionDialog.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C789@30659L842,789@30648L853:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2145678404, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleConversionDialog.<anonymous> (FormatSettingDialogs.kt:789)");
                    }
                    $composer4.startReplaceGroup(-1202549409);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(currentFormat$delegate);
                    final MutableIntState mutableIntState = currentFormat$delegate;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleConversionDialog$3$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7397getLambda40$app_debug(), 3, null);
                                for (final int format = 0; format < 5; format++) {
                                    final MutableIntState mutableIntState2 = mutableIntState;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1045670342, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleConversionDialog$3$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                            invoke(lazyItemScope, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer $composer5, int $changed3) {
                                            Object value$iv2;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C804@31369L78,801@31166L281:FormatSettingDialogs.kt#5yb39d");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1045670342, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.SubtitleConversionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatSettingDialogs.kt:801)");
                                                }
                                                String subtitleConversionFormat = PreferenceStrings.INSTANCE.getSubtitleConversionFormat(format);
                                                boolean z = FormatSettingDialogsKt.SubtitleConversionDialog$lambda$66(mutableIntState2) == format;
                                                $composer5.startReplaceGroup(555400200);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatSettingDialogs.kt#9igjgp");
                                                boolean invalid$iv2 = $composer5.changed(mutableIntState2) | $composer5.changed(format);
                                                final int i = format;
                                                final MutableIntState mutableIntState3 = mutableIntState2;
                                                Object it$iv2 = $composer5.rememberedValue();
                                                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt$SubtitleConversionDialog$3$1$1$1$1$1
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
                                                            mutableIntState3.setIntValue(i);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv2);
                                                } else {
                                                    value$iv2 = it$iv2;
                                                }
                                                $composer5.endReplaceGroup();
                                                DialogItemsKt.DialogSingleChoiceItem(null, subtitleConversionFormat, z, (Function0) value$iv2, $composer5, 0, 1);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                }
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceGroup();
                    LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, (Function1) value$iv, $composer4, 0, 255);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 << 3) & 112) | 1797504, 0, 16257);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.SubtitleConversionDialog.4
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
                    FormatSettingDialogsKt.SubtitleConversionDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SubtitleConversionDialog$lambda$66(MutableIntState $currentFormat$delegate) {
        MutableIntState $this$getValue$iv = $currentFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public static final void VideoQualityPreferenceChip(Modifier modifier, int videoQualityPreference, boolean enabled, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int i2;
        Function0<Unit> function1;
        Modifier modifier3;
        int videoQualityPreference2;
        boolean enabled2;
        Function0<Unit> function2;
        Composer $composer2 = $composer.startRestartGroup(1462945080);
        ComposerKt.sourceInformation($composer2, "C(VideoQualityPreferenceChip)P(1,3)824@31818L128,821@31726L461:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            i2 = videoQualityPreference;
        } else if (($changed & 112) == 0) {
            i2 = videoQualityPreference;
            $dirty |= $composer2.changed(i2) ? 32 : 16;
        } else {
            i2 = videoQualityPreference;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            function1 = function0;
        } else if (($changed & 7168) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        if (($dirty & 5211) == 1042 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = enabled;
            modifier3 = modifier2;
            function2 = function1;
            videoQualityPreference2 = i2;
        } else {
            Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
            final int videoQualityPreference3 = i4 != 0 ? 1 : i2;
            boolean enabled3 = (i & 4) != 0 ? true : enabled;
            C10331 c10331 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityPreferenceChip.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1462945080, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQualityPreferenceChip (FormatSettingDialogs.kt:820)");
            }
            ChipKt.ElevatedAssistChip(c10331, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2038011931, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityPreferenceChip.2
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
                    ComposerKt.sourceInformation($composer3, "C826@31879L43,825@31832L104:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2038011931, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoQualityPreferenceChip.<anonymous> (FormatSettingDialogs.kt:825)");
                        }
                        TextKt.m2569Text4IGK_g(PreferenceStrings.INSTANCE.getVideoFormatLabel(videoQualityPreference3, $composer3, 48, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), modifier4, false, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7398getLambda41$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 9) & 14) | 24624 | (($dirty << 6) & 896), 0, 2024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            videoQualityPreference2 = videoQualityPreference3;
            enabled2 = enabled3;
            function2 = c10331;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final int i6 = videoQualityPreference2;
            final boolean z = enabled2;
            final Function0<Unit> function3 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoQualityPreferenceChip.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    FormatSettingDialogsKt.VideoQualityPreferenceChip(modifier5, i6, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void VideoResolutionChip(Modifier modifier, int videoResolution, boolean enabled, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int i2;
        Function0<Unit> function1;
        Modifier modifier3;
        int videoResolution2;
        boolean enabled2;
        Function0<Unit> function2;
        Composer $composer2 = $composer.startRestartGroup(-299168820);
        ComposerKt.sourceInformation($composer2, "C(VideoResolutionChip)P(1,3)849@32460L128,846@32368L461:FormatSettingDialogs.kt#5yb39d");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            i2 = videoResolution;
        } else if (($changed & 112) == 0) {
            i2 = videoResolution;
            $dirty |= $composer2.changed(i2) ? 32 : 16;
        } else {
            i2 = videoResolution;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            function1 = function0;
        } else if (($changed & 7168) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        if (($dirty & 5211) == 1042 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = enabled;
            modifier3 = modifier2;
            function2 = function1;
            videoResolution2 = i2;
        } else {
            Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
            final int videoResolution3 = i4 != 0 ? 0 : i2;
            boolean enabled3 = (i & 4) != 0 ? true : enabled;
            C10411 c10411 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoResolutionChip.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-299168820, $dirty, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoResolutionChip (FormatSettingDialogs.kt:845)");
            }
            ChipKt.ElevatedAssistChip(c10411, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2089066049, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoResolutionChip.2
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
                    ComposerKt.sourceInformation($composer3, "C851@32521L43,850@32474L104:FormatSettingDialogs.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2089066049, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.VideoResolutionChip.<anonymous> (FormatSettingDialogs.kt:850)");
                        }
                        TextKt.m2569Text4IGK_g(PreferenceStrings.INSTANCE.getVideoResolutionDescComp(videoResolution3, $composer3, 48, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), modifier4, false, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FormatSettingDialogsKt.INSTANCE.m7399getLambda42$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, (ChipColors) null, (ChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, $composer2, (($dirty >> 9) & 14) | 24624 | (($dirty << 6) & 896), 0, 2024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            videoResolution2 = videoResolution3;
            enabled2 = enabled3;
            function2 = c10411;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final int i6 = videoResolution2;
            final boolean z = enabled2;
            final Function0<Unit> function3 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.FormatSettingDialogsKt.VideoResolutionChip.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    FormatSettingDialogsKt.VideoResolutionChip(modifier5, i6, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
