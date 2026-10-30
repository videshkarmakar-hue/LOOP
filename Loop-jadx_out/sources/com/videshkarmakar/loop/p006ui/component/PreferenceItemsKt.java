package com.videshkarmakar.loop.p006ui.component;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material.icons.outlined.InfoKt;
import androidx.compose.material.icons.outlined.ToggleOnKt;
import androidx.compose.material.icons.outlined.TranslateKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.p006ui.theme.ColorSchemeKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.p006ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.p009ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: PreferenceItems.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010\f\u001a3\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\u009f\u0001\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0002\b\u001e2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0002\b\u001e2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010 \u001aT\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(H\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\r\u0010+\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001aT\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(H\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010*\u001ay\u0010.\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010/\u001a?\u00100\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u00101\u001a\u00020\t2\b\b\u0002\u00102\u001a\u0002032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u00104\u001a8\u00105\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u0002032\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a[\u00108\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\u00122\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010;\u001a\r\u0010<\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a7\u0010=\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u00109\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010>\u001a\r\u0010?\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0016\u001au\u0010@\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\u00122\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010C\u001a\r\u0010D\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a=\u0010E\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010F\u001aX\u0010G\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010H\u001a\u00020&2\b\b\u0002\u0010I\u001a\u00020&2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a\u0087\u0001\u0010L\u001a\u00020\u00042\b\b\u0002\u0010M\u001a\u00020\u00062\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0014\b\u0002\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040S2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007¢\u0006\u0002\u0010T\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006U²\u0006\n\u0010V\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\tX\u008a\u008e\u0002"}, m195d2 = {"horizontal", "", "vertical", "CreditItem", "", "title", "", "license", "enabled", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferenceInfo", "modifier", "Landroidx/compose/ui/Modifier;", "text", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "applyPaddings", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZLandroidx/compose/runtime/Composer;II)V", "PreferenceInfoPreview", "(Landroidx/compose/runtime/Composer;I)V", "PreferenceItem", "description", "", "onLongClickLabel", "onLongClick", "onClickLabel", "leadingIcon", "Landroidx/compose/runtime/Composable;", "trailingIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferenceItemDescription", "maxLines", "style", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "PreferenceItemDescription-Ga5sM4s", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ILandroidx/compose/ui/text/TextStyle;ZJILandroidx/compose/runtime/Composer;II)V", "PreferenceItemPreview", "PreferenceItemTitle", "PreferenceItemTitle-Ga5sM4s", "PreferenceItemVariant", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferenceSingleChoiceItem", "selected", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferenceSubtitle", "PreferenceSubtitle-ww6aTOc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "PreferenceSwitch", "isChecked", "checkedIcon", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZZLandroidx/compose/ui/graphics/vector/ImageVector;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferenceSwitchPreview", "PreferenceSwitchWithContainer", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferenceSwitchWithContainerPreview", "PreferenceSwitchWithDivider", "isSwitchEnabled", "onChecked", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;ZZZLandroidx/compose/ui/graphics/vector/ImageVector;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferenceSwitchWithDividerPreview", "PreferencesCautionCard", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreferencesHintCard", "containerColor", "contentColor", "PreferencesHintCard-jB83MbM", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TemplateItem", "label", Route.TEMPLATE, "isMultiSelectEnabled", "checked", "onSelect", "onCheckedChange", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/String;ZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "b"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PreferenceItemsKt {
    private static final int horizontal = 8;
    private static final int vertical = 16;

    public static final void PreferenceItem(final String title, String description, Object icon, boolean enabled, String onLongClickLabel, Function0<Unit> function0, String onClickLabel, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        String description2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function0<Unit> function7;
        Object icon2;
        boolean enabled2;
        String onLongClickLabel2;
        Function0<Unit> function8;
        String onClickLabel2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(-758778356);
        ComposerKt.sourceInformation($composer2, "C(PreferenceItem)P(8!1,2!1,7,6,5!1,9)90@3835L2123,82@3573L2385:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(description) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(onLongClickLabel) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function4 = function0;
        } else if ((458752 & $changed) == 0) {
            function4 = function0;
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        } else {
            function4 = function0;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(onClickLabel) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 536870912 : 268435456;
        }
        if (i3 == 4 && (1533916891 & $dirty) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            icon2 = icon;
            enabled2 = enabled;
            onLongClickLabel2 = onLongClickLabel;
            onClickLabel2 = onClickLabel;
            function6 = function2;
            function5 = function3;
            function7 = function1;
            function8 = function4;
            description2 = description;
        } else {
            String description3 = i2 != 0 ? null : description;
            Object icon3 = i3 != 0 ? null : icon;
            boolean enabled3 = i4 != 0 ? true : enabled;
            String onLongClickLabel3 = i5 != 0 ? null : onLongClickLabel;
            Function0<Unit> function9 = i6 != 0 ? null : function4;
            String onClickLabel3 = i7 != 0 ? null : onClickLabel;
            Function2<? super Composer, ? super Integer, Unit> function10 = i8 != 0 ? null : function2;
            Function2<? super Composer, ? super Integer, Unit> function11 = i9 != 0 ? null : function3;
            C32451 c32451 = i10 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItem.1
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
                ComposerKt.traceEventStart(-758778356, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceItem (PreferenceItems.kt:81)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function12 = function10;
            final Object obj = icon3;
            final boolean z = enabled3;
            final Function2<? super Composer, ? super Integer, Unit> function13 = function11;
            final String str = description3;
            Function2<? super Composer, ? super Integer, Unit> function14 = function11;
            SurfaceKt.m2666SurfaceT9BRK9s(ClickableKt.m490combinedClickablecJG_KMw(Modifier.INSTANCE, (36 & 1) != 0 ? true : enabled3, (36 & 2) != 0 ? null : onClickLabel3, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : onLongClickLabel3, (36 & 16) != 0 ? null : function9, (36 & 32) != 0 ? null : null, c32451), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1651952529, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItem.2
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
                    Function0<ComposeUiNode> function15;
                    Function0<ComposeUiNode> function16;
                    ComposerKt.sourceInformation($composer3, "C91@3845L2107:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1651952529, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceItem.<anonymous> (PreferenceItems.kt:91)");
                        }
                        Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(16));
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function17 = function12;
                        Object obj2 = obj;
                        boolean z2 = z;
                        Function2<Composer, Integer, Unit> function18 = function13;
                        String str2 = title;
                        String str3 = str;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv = (390 << 3) & 112;
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
                            function15 = constructor;
                            $composer3.createNode(function15);
                        } else {
                            function15 = constructor;
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
                        int i11 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i12 = ((390 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u242 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -2086973637, "C123@5007L488:PreferenceItems.kt#g7nzpb");
                        $composer3.startReplaceGroup(-2086973624);
                        ComposerKt.sourceInformation($composer3, "97@4065L8");
                        if (function17 != null) {
                            function17.invoke($composer3, 0);
                        }
                        $composer3.endReplaceGroup();
                        if (obj2 instanceof ImageVector) {
                            $composer3.startReplaceGroup(-2086973532);
                            ComposerKt.sourceInformation($composer3, "107@4453L11,101@4157L368");
                            IconKt.m2292Iconww6aTOc((ImageVector) obj2, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ThemeKt.m7665applyOpacityDxMtmZc(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z2), $composer3, 432, 0);
                            $composer3.endReplaceGroup();
                        } else if (obj2 instanceof Painter) {
                            $composer3.startReplaceGroup(-2086973092);
                            ComposerKt.sourceInformation($composer3, "118@4889L11,112@4597L364");
                            IconKt.m2291Iconww6aTOc((Painter) obj2, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ThemeKt.m7665applyOpacityDxMtmZc(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z2), $composer3, 440, 0);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(-2086972696);
                            $composer3.endReplaceGroup();
                        }
                        Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(RowScope.CC.weight$default($this$invoke_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null), (obj2 == null && function17 == null) ? C1979Dp.m6801constructorimpl(12) : C1979Dp.m6801constructorimpl(0), 0.0f, 2, null), 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $i$f$Column);
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
                            function16 = constructor2;
                            $composer3.createNode(function16);
                        } else {
                            function16 = constructor2;
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
                        int i13 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i14 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -513576048, "C129@5256L52:PreferenceItems.kt#g7nzpb");
                        PreferenceItemsKt.m7311PreferenceItemTitleGa5sM4s(null, str2, 0, null, z2, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                        $composer3.startReplaceGroup(-2086972364);
                        ComposerKt.sourceInformation($composer3, "130@5359L122");
                        String str4 = str3;
                        if (!(str4 == null || str4.length() == 0)) {
                            PreferenceItemsKt.m7310PreferenceItemDescriptionGa5sM4s(null, str3, 0, null, z2, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.startReplaceGroup(-1622045736);
                        ComposerKt.sourceInformation($composer3, "*141@5794L11,136@5544L346,144@5920L8");
                        if (function18 != null) {
                            Modifier modifierAlign = $this$invoke_u24lambda_u242.align(PaddingKt.m870paddingVpY3zN4$default(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(32)), C1979Dp.m6801constructorimpl(8), 0.0f, 2, null), Alignment.INSTANCE.getCenterVertically());
                            long onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
                            DividerKt.m2224VerticalDivider9IZ8Weo(modifierAlign, C1979Dp.m6801constructorimpl(1), Color.m4289copywmQWz5c(onSurface, (14 & 1) != 0 ? Color.m4293getAlphaimpl(onSurface) : 0.3f, (14 & 2) != 0 ? Color.m4297getRedimpl(onSurface) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(onSurface) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(onSurface) : 0.0f), $composer3, 48, 0);
                            function18.invoke($composer3, 0);
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
            }, $composer2, 54), $composer2, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function14;
            description2 = description3;
            function6 = function10;
            function7 = c32451;
            icon2 = icon3;
            enabled2 = enabled3;
            onLongClickLabel2 = onLongClickLabel3;
            function8 = function9;
            onClickLabel2 = onClickLabel3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = description2;
            final Object obj2 = icon2;
            final boolean z2 = enabled2;
            final String str3 = onLongClickLabel2;
            final Function0<Unit> function15 = function8;
            final String str4 = onClickLabel2;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function6;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function5;
            final Function0<Unit> function18 = function7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItem.3
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
                    PreferenceItemsKt.PreferenceItem(title, str2, obj2, z2, str3, function15, str4, function16, function17, function18, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void PreferenceItemPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-436597004);
        ComposerKt.sourceInformation($composer2, "C(PreferenceItemPreview)154@6018L395:PreferenceItems.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-436597004, $changed, -1, "com.videshkarmakar.loop.ui.component.PreferenceItemPreview (PreferenceItems.kt:153)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$PreferenceItemsKt.INSTANCE.m7285getLambda2$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItemPreview.1
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
                    PreferenceItemsKt.PreferenceItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void PreferenceItemVariant(Modifier modifier, final String title, String description, ImageVector icon, boolean enabled, String onLongClickLabel, Function0<Unit> function0, String onClickLabel, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        String str;
        String onClickLabel2;
        Modifier modifier2;
        Function0<Unit> function2;
        String description2;
        ImageVector icon2;
        boolean enabled2;
        String onLongClickLabel2;
        Function0<Unit> function3;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(-1553947428);
        ComposerKt.sourceInformation($composer2, "C(PreferenceItemVariant)P(3,8!1,2!1,7,6,5)190@7050L1483,182@6788L1745:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(title) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(description) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(icon) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            z = enabled;
        } else if ((57344 & $changed) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 16384 : 8192;
        } else {
            z = enabled;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            str = onLongClickLabel;
        } else if ((458752 & $changed) == 0) {
            str = onLongClickLabel;
            $dirty |= $composer2.changed(str) ? 131072 : 65536;
        } else {
            str = onLongClickLabel;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(onClickLabel) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            icon2 = icon;
            function3 = function0;
            onClickLabel2 = onClickLabel;
            function2 = function1;
            enabled2 = z;
            onLongClickLabel2 = str;
            description2 = description;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            String description3 = i3 != 0 ? null : description;
            ImageVector icon3 = i4 != 0 ? null : icon;
            boolean enabled3 = i5 != 0 ? true : z;
            String onLongClickLabel3 = i6 != 0 ? null : str;
            C32491 c32491 = i7 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItemVariant.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function0;
            String onClickLabel3 = i8 != 0 ? null : onClickLabel;
            C32502 c32502 = i9 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItemVariant.2
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
                ComposerKt.traceEventStart(-1553947428, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceItemVariant (PreferenceItems.kt:181)");
            }
            final Modifier modifier4 = modifier3;
            final ImageVector imageVector = icon3;
            final boolean z2 = enabled3;
            final String str2 = description3;
            String onClickLabel4 = onClickLabel3;
            SurfaceKt.m2666SurfaceT9BRK9s(ClickableKt.m490combinedClickablecJG_KMw(Modifier.INSTANCE, (36 & 1) != 0 ? true : enabled3, (36 & 2) != 0 ? null : onClickLabel3, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : onLongClickLabel3, (36 & 16) != 0 ? null : c32491, (36 & 32) != 0 ? null : null, c32502), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1678692383, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItemVariant.3
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
                    Function0<ComposeUiNode> function4;
                    ComposerKt.sourceInformation($composer3, "C191@7060L1467:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1678692383, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceItemVariant.<anonymous> (PreferenceItems.kt:191)");
                        }
                        Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(16));
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        ImageVector imageVector2 = imageVector;
                        boolean z3 = z2;
                        String str3 = title;
                        String str4 = str2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
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
                        int i10 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i11 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u243 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1528749549, "C207@7654L863:PreferenceItems.kt#g7nzpb");
                        $composer3.startReplaceGroup(-1528749543);
                        ComposerKt.sourceInformation($composer3, "*204@7559L11,198@7287L340");
                        if (imageVector2 != null) {
                            IconKt.m2292Iconww6aTOc(imageVector2, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ThemeKt.m7665applyOpacityDxMtmZc(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z3), $composer3, 432, 0);
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m870paddingVpY3zN4$default(RowScope.CC.weight$default($this$invoke_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null), imageVector2 == null ? C1979Dp.m6801constructorimpl(12) : C1979Dp.m6801constructorimpl(0), 0.0f, 2, null), 0.0f, 0.0f, C1979Dp.m6801constructorimpl(8), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function4 = constructor2;
                            $composer3.createNode(function4);
                        } else {
                            function4 = constructor2;
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
                        int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 296047265, "C:PreferenceItems.kt#g7nzpb");
                        $composer3.startReplaceGroup(-1528748928);
                        ComposerKt.sourceInformation($composer3, "*217@8036L10,218@8092L11,214@7922L235");
                        MaterialTheme $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241 = MaterialTheme.INSTANCE;
                        TextKt.m2817Text4IGK_g(str3, (Modifier) null, ThemeKt.m7665applyOpacityDxMtmZc($this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), z3), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 3072, 57338);
                        $composer3.startReplaceGroup(296047563);
                        ComposerKt.sourceInformation($composer3, "222@8285L11,224@8441L10,220@8203L282");
                        if (str4 != 0) {
                            TextKt.m2817Text4IGK_g(str4, (Modifier) null, ThemeKt.m7665applyOpacityDxMtmZc($this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z3), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.endReplaceGroup();
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
            }, $composer2, 54), $composer2, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onClickLabel2 = onClickLabel4;
            modifier2 = modifier3;
            function2 = c32502;
            description2 = description3;
            icon2 = icon3;
            enabled2 = enabled3;
            onLongClickLabel2 = onLongClickLabel3;
            function3 = c32491;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final String str3 = description2;
            final ImageVector imageVector2 = icon2;
            final boolean z3 = enabled2;
            final String str4 = onLongClickLabel2;
            final Function0<Unit> function4 = function3;
            final String str5 = onClickLabel2;
            final Function0<Unit> function5 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceItemVariant.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    PreferenceItemsKt.PreferenceItemVariant(modifier5, title, str3, imageVector2, z3, str4, function4, str5, function5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void PreferenceSingleChoiceItem(Modifier modifier, final String text, final boolean selected, PaddingValues contentPadding, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        PaddingValues paddingValues;
        Modifier modifier3;
        PaddingValues contentPadding2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1032393110);
        ComposerKt.sourceInformation($composer2, "C(PreferenceSingleChoiceItem)P(1,4,3)245@8894L908,241@8778L1024:PreferenceItems.kt#g7nzpb");
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
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(selected) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            paddingValues = contentPadding;
        } else if (($changed & 7168) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer2.changed(paddingValues) ? 2048 : 1024;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(onClick) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            contentPadding2 = paddingValues;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            contentPadding2 = i3 != 0 ? PaddingKt.m862PaddingValuesYgX7TsA(C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(18)) : paddingValues;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1032393110, $dirty2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSingleChoiceItem (PreferenceItems.kt:240)");
            }
            final Modifier modifier4 = modifier3;
            final PaddingValues paddingValues2 = contentPadding2;
            SurfaceKt.m2666SurfaceT9BRK9s(SelectableKt.m1117selectableXHw0xAI$default(Modifier.INSTANCE, selected, false, null, onClick, 6, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(169080943, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSingleChoiceItem.1
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
                    Function0<ComposeUiNode> function0;
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C246@8904L892:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(169080943, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSingleChoiceItem.<anonymous> (PreferenceItems.kt:246)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), paddingValues2);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        boolean z = selected;
                        Function0<Unit> function2 = onClick;
                        String str = text;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
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
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i5 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -158883991, "C252@9099L462,265@9574L212:PreferenceItems.kt#g7nzpb");
                        Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null), C1979Dp.m6801constructorimpl(10), 0.0f, 0.0f, 0.0f, 14, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function1 = constructor2;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor2;
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
                        int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -423770846, "C260@9366L10,261@9454L11,257@9251L296:PreferenceItems.kt#g7nzpb");
                        TextStyle titleLarge = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleLarge();
                        TextKt.m2817Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, titleLarge.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleLarge.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleLarge.spanStyle.getFontSize() : TextUnitKt.getSp(20), (16777213 & 4) != 0 ? titleLarge.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleLarge.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleLarge.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleLarge.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleLarge.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleLarge.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleLarge.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleLarge.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleLarge.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleLarge.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleLarge.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleLarge.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleLarge.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleLarge.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleLarge.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleLarge.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleLarge.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleLarge.platformStyle : null, (16777213 & 1048576) != 0 ? titleLarge.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleLarge.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleLarge.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleLarge.paragraphStyle.getTextMotion() : null), $composer3, 0, 3120, 55290);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        RadioButtonKt.RadioButton(z, function2, SemanticsModifierKt.clearAndSetSemantics(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSingleChoiceItem$1$1$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                            }
                        }), false, null, null, $composer3, 0, 56);
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
            }, $composer2, 54), $composer2, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final PaddingValues paddingValues3 = contentPadding2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSingleChoiceItem.2
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
                    PreferenceItemsKt.PreferenceSingleChoiceItem(modifier5, text, selected, paddingValues3, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: PreferenceItemTitle-Ga5sM4s, reason: not valid java name */
    public static final void m7311PreferenceItemTitleGa5sM4s(Modifier modifier, final String text, int maxLines, TextStyle style, final boolean enabled, long color, int overflow, Composer $composer, final int $changed, final int i) {
        int maxLines2;
        TextStyle style2;
        long color2;
        int i2;
        Modifier modifier2;
        int maxLines3;
        TextStyle style3;
        long color3;
        int overflow2;
        int $dirty;
        long color4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-257325845);
        ComposerKt.sourceInformation($composer3, "C(PreferenceItemTitle)P(3,6,2,5,1,0:c#ui.graphics.Color,4:c#ui.text.style.TextOverflow)283@10023L11,286@10108L186:PreferenceItems.kt#g7nzpb");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(text) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            maxLines2 = maxLines;
        } else if (($changed & 896) == 0) {
            maxLines2 = maxLines;
            $dirty2 |= $composer3.changed(maxLines2) ? 256 : 128;
        } else {
            maxLines2 = maxLines;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            style2 = style;
        } else if (($changed & 7168) == 0) {
            style2 = style;
            $dirty2 |= $composer3.changed(style2) ? 2048 : 1024;
        } else {
            style2 = style;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                color2 = color;
                int i6 = $composer3.changed(color2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                color2 = color;
            }
            $dirty2 |= i6;
        } else {
            color2 = color;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            i2 = overflow;
        } else if (($changed & 3670016) == 0) {
            i2 = overflow;
            $dirty2 |= $composer3.changed(i2) ? 1048576 : 524288;
        } else {
            i2 = overflow;
        }
        if (($dirty2 & 2995931) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            maxLines3 = maxLines2;
            style3 = style2;
            color4 = color2;
            $composer2 = $composer3;
            overflow2 = i2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
                if (i4 != 0) {
                    maxLines2 = 2;
                }
                if (i5 != 0) {
                    style2 = TypeKt.getPreferenceTitle();
                }
                if ((i & 32) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnBackground();
                    $dirty2 &= -458753;
                }
                if (i7 != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    overflow2 = TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8();
                    maxLines3 = maxLines2;
                    style3 = style2;
                    color3 = color2;
                } else {
                    modifier2 = modifier3;
                    maxLines3 = maxLines2;
                    style3 = style2;
                    color3 = color2;
                    overflow2 = i2;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    modifier2 = modifier;
                    maxLines3 = maxLines2;
                    style3 = style2;
                    color3 = color2;
                    overflow2 = i2;
                    $dirty = $dirty2 & (-458753);
                } else {
                    modifier2 = modifier;
                    maxLines3 = maxLines2;
                    style3 = style2;
                    color3 = color2;
                    overflow2 = i2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-257325845, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceItemTitle (PreferenceItems.kt:285)");
            }
            color4 = color3;
            $composer2 = $composer3;
            TextKt.m2817Text4IGK_g(text, modifier2, ThemeKt.m7665applyOpacityDxMtmZc(color3, enabled), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, overflow2, false, maxLines3, 0, (Function1<? super TextLayoutResult, Unit>) null, style3, $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & 112), (($dirty >> 15) & 112) | (($dirty << 3) & 7168) | (($dirty << 9) & 3670016), 55288);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final int i8 = maxLines3;
            final TextStyle textStyle = style3;
            final long j = color4;
            final int i9 = overflow2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceItemTitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    PreferenceItemsKt.m7311PreferenceItemTitleGa5sM4s(modifier4, text, i8, textStyle, enabled, j, i9, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: PreferenceItemDescription-Ga5sM4s, reason: not valid java name */
    public static final void m7310PreferenceItemDescriptionGa5sM4s(Modifier modifier, final String text, int maxLines, TextStyle style, final boolean enabled, long color, int overflow, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int maxLines2;
        TextStyle style2;
        long color2;
        int overflow2;
        Modifier modifier3;
        int maxLines3;
        TextStyle style3;
        int overflow3;
        long color3;
        int $dirty;
        long color4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-647427641);
        ComposerKt.sourceInformation($composer3, "C(PreferenceItemDescription)P(3,6,2,5,1,0:c#ui.graphics.Color,4:c#ui.text.style.TextOverflow)301@10475L10,303@10553L11,306@10642L206:PreferenceItems.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(text) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            maxLines2 = maxLines;
        } else if (($changed & 896) == 0) {
            maxLines2 = maxLines;
            $dirty2 |= $composer3.changed(maxLines2) ? 256 : 128;
        } else {
            maxLines2 = maxLines;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                style2 = style;
                int i4 = $composer3.changed(style2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                style2 = style;
            }
            $dirty2 |= i4;
        } else {
            style2 = style;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                color2 = color;
                int i5 = $composer3.changed(color2) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                color2 = color;
            }
            $dirty2 |= i5;
        } else {
            color2 = color;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            overflow2 = overflow;
        } else if (($changed & 3670016) == 0) {
            overflow2 = overflow;
            $dirty2 |= $composer3.changed(overflow2) ? 1048576 : 524288;
        } else {
            overflow2 = overflow;
        }
        if (($dirty2 & 2995931) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            maxLines3 = maxLines2;
            style3 = style2;
            color4 = color2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    maxLines2 = Integer.MAX_VALUE;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    style2 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium();
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    color2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant();
                }
                if (i6 != 0) {
                    modifier3 = modifier4;
                    overflow3 = TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8();
                    maxLines3 = maxLines2;
                    style3 = style2;
                    color3 = color2;
                    $dirty = $dirty2;
                } else {
                    modifier3 = modifier4;
                    maxLines3 = maxLines2;
                    style3 = style2;
                    overflow3 = overflow2;
                    color3 = color2;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 32) != 0) {
                    modifier3 = modifier2;
                    maxLines3 = maxLines2;
                    style3 = style2;
                    overflow3 = overflow2;
                    color3 = color2;
                    $dirty = $dirty2 & (-458753);
                } else {
                    modifier3 = modifier2;
                    maxLines3 = maxLines2;
                    style3 = style2;
                    overflow3 = overflow2;
                    color3 = color2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-647427641, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceItemDescription (PreferenceItems.kt:305)");
            }
            color4 = color3;
            $composer2 = $composer3;
            TextKt.m2817Text4IGK_g(text, PaddingKt.m872paddingqDBjuR0$default(modifier3, 0.0f, C1979Dp.m6801constructorimpl(2), 0.0f, 0.0f, 13, null), ThemeKt.m7665applyOpacityDxMtmZc(color3, enabled), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, overflow3, false, maxLines3, 0, (Function1<? super TextLayoutResult, Unit>) null, style3, $composer2, ($dirty >> 3) & 14, (($dirty >> 15) & 112) | (($dirty << 3) & 7168) | (($dirty << 9) & 3670016), 55288);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            overflow2 = overflow3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final int i7 = maxLines3;
            final TextStyle textStyle = style3;
            final long j = color4;
            final int i8 = overflow2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceItemDescription$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    PreferenceItemsKt.m7310PreferenceItemDescriptionGa5sM4s(modifier5, text, i7, textStyle, enabled, j, i8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void PreferenceSwitchPreview(Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1637261077);
        ComposerKt.sourceInformation($composer2, "C(PreferenceSwitchPreview)319@10918L34,320@10967L229,320@10957L239:PreferenceItems.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1637261077, $changed, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchPreview (PreferenceItems.kt:318)");
            }
            $composer2.startReplaceGroup(1053421018);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState b$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            ThemeKt.LoopTheme(false, false, false, ComposableLambdaKt.rememberComposableLambda(932964542, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchPreview.1
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
                    ComposerKt.sourceInformation($composer3, "C326@11160L30,321@10977L213:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(932964542, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchPreview.<anonymous> (PreferenceItems.kt:321)");
                        }
                        ImageVector toggleOn = ToggleOnKt.getToggleOn(Icons.Outlined.INSTANCE);
                        boolean zPreferenceSwitchPreview$lambda$1 = PreferenceItemsKt.PreferenceSwitchPreview$lambda$1(b$delegate);
                        $composer3.startReplaceGroup(1389478637);
                        ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
                        final MutableState<Boolean> mutableState = b$delegate;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchPreview$1$1$1
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
                                    PreferenceItemsKt.PreferenceSwitchPreview$lambda$2(mutableState, !PreferenceItemsKt.PreferenceSwitchPreview$lambda$1(mutableState));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        PreferenceItemsKt.PreferenceSwitch("PreferenceSwitch", "Supporting text", toggleOn, false, zPreferenceSwitchPreview$lambda$1, null, (Function0) value$iv2, $composer3, 1572918, 40);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchPreview.2
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
                    PreferenceItemsKt.PreferenceSwitchPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PreferenceSwitchPreview$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreferenceSwitchPreview$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void PreferenceSwitchWithDividerPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-370000562);
        ComposerKt.sourceInformation($composer2, "C(PreferenceSwitchWithDividerPreview)335@11268L151:PreferenceItems.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-370000562, $changed, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchWithDividerPreview (PreferenceItems.kt:334)");
            }
            PreferenceSwitchWithDivider("PreferenceSwitch", "Supporting text", ToggleOnKt.getToggleOn(Icons.Outlined.INSTANCE), false, false, false, null, null, null, $composer2, 54, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithDividerPreview.1
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
                    PreferenceItemsKt.PreferenceSwitchWithDividerPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void PreferenceSwitch(final String title, String description, ImageVector icon, boolean enabled, boolean isChecked, ImageVector checkedIcon, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        String str;
        ImageVector imageVector;
        boolean enabled2;
        boolean isChecked2;
        ImageVector checkedIcon2;
        Function0<Unit> function1;
        String description2;
        int $dirty;
        ImageVector icon2;
        boolean enabled3;
        boolean isChecked3;
        final ImageVector checkedIcon3;
        final Function0<Unit> function2;
        ComposableLambda value$iv;
        Object value$iv2;
        Object value$iv3;
        String description3;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(328390689);
        ComposerKt.sourceInformation($composer2, "C(PreferenceSwitch)P(6,1,3,2,4)352@11739L329,366@12098L39,372@12337L7,371@12281L13,375@12412L1357,367@12142L1627:PreferenceItems.kt#g7nzpb");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            str = description;
        } else if (($changed & 112) == 0) {
            str = description;
            $dirty2 |= $composer2.changed(str) ? 32 : 16;
        } else {
            str = description;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            imageVector = icon;
        } else if (($changed & 896) == 0) {
            imageVector = icon;
            $dirty2 |= $composer2.changed(imageVector) ? 256 : 128;
        } else {
            imageVector = icon;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            isChecked2 = isChecked;
        } else if (($changed & 57344) == 0) {
            isChecked2 = isChecked;
            $dirty2 |= $composer2.changed(isChecked2) ? 16384 : 8192;
        } else {
            isChecked2 = isChecked;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                checkedIcon2 = checkedIcon;
                int i6 = $composer2.changed(checkedIcon2) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                checkedIcon2 = checkedIcon;
            }
            $dirty2 |= i6;
        } else {
            checkedIcon2 = checkedIcon;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            function1 = function0;
        } else if (($changed & 3670016) == 0) {
            function1 = function0;
            $dirty2 |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        } else {
            function1 = function0;
        }
        if (($dirty2 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            description3 = str;
            icon2 = imageVector;
            enabled3 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                String description4 = i2 != 0 ? null : str;
                ImageVector icon3 = i3 != 0 ? null : imageVector;
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    isChecked2 = true;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    checkedIcon2 = CheckKt.getCheck(Icons.Outlined.INSTANCE);
                }
                if (i7 != 0) {
                    description2 = description4;
                    $dirty = $dirty2;
                    icon2 = icon3;
                    enabled3 = enabled2;
                    isChecked3 = isChecked2;
                    checkedIcon3 = checkedIcon2;
                    function2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitch.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                } else {
                    description2 = description4;
                    $dirty = $dirty2;
                    icon2 = icon3;
                    enabled3 = enabled2;
                    isChecked3 = isChecked2;
                    checkedIcon3 = checkedIcon2;
                    function2 = function1;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                description2 = str;
                icon2 = imageVector;
                enabled3 = enabled2;
                isChecked3 = isChecked2;
                checkedIcon3 = checkedIcon2;
                function2 = function1;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(328390689, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitch (PreferenceItems.kt:351)");
            }
            $composer2.startReplaceGroup(-1158970497);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv = (57344 & $dirty) == 16384;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = isChecked3 ? ComposableLambdaKt.composableLambdaInstance(1311150678, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitch$thumbContent$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C355@11816L188:PreferenceItems.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1311150678, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitch.<anonymous>.<anonymous> (PreferenceItems.kt:355)");
                            }
                            IconKt.m2292Iconww6aTOc(checkedIcon3, (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, SwitchDefaults.INSTANCE.m2699getIconSizeD9Ej5fM()), 0L, $composer3, 48, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }) : null;
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final Function2 thumbContent = (Function2) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-1158970138);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv2;
            $composer2.endReplaceGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localIndication);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Indication indication = (Indication) objConsume;
            Modifier.Companion companion2 = companion;
            $composer2.startReplaceGroup(-1158969955);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 3670016) == 1048576;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitch$2$1
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
                        function2.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer2.endReplaceGroup();
            final ImageVector imageVector2 = icon2;
            final boolean z = isChecked3;
            final boolean z2 = enabled3;
            final String str2 = description2;
            ImageVector checkedIcon4 = checkedIcon3;
            Function0<Unit> function3 = function2;
            SurfaceKt.m2666SurfaceT9BRK9s(ToggleableKt.m1120toggleableO2vRcR0$default(companion2, isChecked3, interactionSource, indication, enabled3, null, (Function1) value$iv3, 16, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2017430118, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitch.3
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

                /* JADX WARN: Code duplicated, block: B:32:0x0191  */
                /* JADX WARN: Code duplicated, block: B:33:0x01a5  */
                /* JADX WARN: Code duplicated, block: B:36:0x0288  */
                /* JADX WARN: Code duplicated, block: B:39:0x0294  */
                /* JADX WARN: Code duplicated, block: B:40:0x029a  */
                /* JADX WARN: Code duplicated, block: B:55:0x0364  */
                /* JADX WARN: Code duplicated, block: B:57:0x0369  */
                /* JADX WARN: Code duplicated, block: B:60:0x03ea  */
                /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function4;
                    MeasurePolicy measurePolicy$iv;
                    int i8;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function5;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    String str3;
                    boolean z3;
                    ComposerKt.sourceInformation($composer3, "C376@12422L1341:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2017430118, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitch.<anonymous> (PreferenceItems.kt:376)");
                    }
                    Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(16)), imageVector2 == null ? C1979Dp.m6801constructorimpl(12) : C1979Dp.m6801constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                    ImageVector imageVector3 = imageVector2;
                    boolean z4 = z;
                    Function2<Composer, Integer, Unit> function6 = thumbContent;
                    boolean z5 = z2;
                    MutableInteractionSource mutableInteractionSource = interactionSource;
                    String str4 = title;
                    String str5 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function4 = constructor2;
                        $composer3.createNode(function4);
                    } else {
                        function4 = constructor2;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        measurePolicy$iv = measurePolicy$iv2;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i10 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u242 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1630751233, "C393@13092L344,403@13449L304:PreferenceItems.kt#g7nzpb");
                        $composer3.startReplaceGroup(-1630751227);
                        ComposerKt.sourceInformation($composer3, "*390@12997L11,384@12725L340");
                        if (imageVector3 == null) {
                            i8 = 0;
                        } else {
                            i8 = 0;
                            IconKt.m2292Iconww6aTOc(imageVector3, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ThemeKt.m7665applyOpacityDxMtmZc(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z5), $composer3, 432, 0);
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifier$iv2 = RowScope.CC.weight$default($this$invoke_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null);
                        int $changed$iv = i8;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                        int $changed$iv$iv2 = ($changed$iv << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i12 = (($changed$iv >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 491933954, "C396@13179L90:PreferenceItems.kt#g7nzpb");
                        PreferenceItemsKt.m7311PreferenceItemTitleGa5sM4s(null, str4, 0, null, z5, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                        $composer3.startReplaceGroup(-1630750644);
                        ComposerKt.sourceInformation($composer3, "399@13320L102");
                        str3 = str5;
                        if (str3 != null || str3.length() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            PreferenceItemsKt.m7310PreferenceItemDescriptionGa5sM4s(null, str5, 0, null, z5, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SwitchKt.Switch(z4, null, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(20), 0.0f, C1979Dp.m6801constructorimpl(6), 0.0f, 10, null), function6, z5, null, mutableInteractionSource, $composer3, 1573296, 32);
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
                    measurePolicy$iv = measurePolicy$iv2;
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i13 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i14 = ((384 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u243 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1630751233, "C393@13092L344,403@13449L304:PreferenceItems.kt#g7nzpb");
                    $composer3.startReplaceGroup(-1630751227);
                    ComposerKt.sourceInformation($composer3, "*390@12997L11,384@12725L340");
                    if (imageVector3 == null) {
                        i8 = 0;
                    } else {
                        i8 = 0;
                        IconKt.m2292Iconww6aTOc(imageVector3, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ThemeKt.m7665applyOpacityDxMtmZc(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z5), $composer3, 432, 0);
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifier$iv3 = RowScope.CC.weight$default($this$invoke_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null);
                    int $changed$iv2 = i8;
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
                    int $changed$iv$iv3 = ($changed$iv2 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                    $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i15 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    int i16 = (($changed$iv2 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 491933954, "C396@13179L90:PreferenceItems.kt#g7nzpb");
                    PreferenceItemsKt.m7311PreferenceItemTitleGa5sM4s(null, str4, 0, null, z5, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                    $composer3.startReplaceGroup(-1630750644);
                    ComposerKt.sourceInformation($composer3, "399@13320L102");
                    str3 = str5;
                    if (str3 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        PreferenceItemsKt.m7310PreferenceItemDescriptionGa5sM4s(null, str5, 0, null, z5, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SwitchKt.Switch(z4, null, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(20), 0.0f, C1979Dp.m6801constructorimpl(6), 0.0f, 10, null), function6, z5, null, mutableInteractionSource, $composer3, 1573296, 32);
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
            }, $composer2, 54), $composer2, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkedIcon2 = checkedIcon4;
            function1 = function3;
            description3 = description2;
            isChecked2 = isChecked3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str3 = description3;
            final ImageVector imageVector3 = icon2;
            final boolean z3 = enabled3;
            final boolean z4 = isChecked2;
            final ImageVector imageVector4 = checkedIcon2;
            final Function0<Unit> function4 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitch.4
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
                    PreferenceItemsKt.PreferenceSwitch(title, str3, imageVector3, z3, z4, imageVector4, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void PreferenceSwitchWithDivider(final String title, String description, ImageVector icon, boolean enabled, boolean isSwitchEnabled, boolean isChecked, ImageVector checkedIcon, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean z2;
        ImageVector imageVector;
        String description2;
        ImageVector icon2;
        boolean enabled2;
        boolean isSwitchEnabled2;
        boolean isChecked2;
        final ImageVector checkedIcon2;
        C32631 c32631;
        C32642 c32642;
        ComposableLambda value$iv;
        Function0<Unit> function2;
        String description3;
        Function0<Unit> function3;
        ImageVector icon3;
        boolean enabled3;
        boolean isSwitchEnabled3;
        boolean isChecked3;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(110200258);
        ComposerKt.sourceInformation($composer2, "C(PreferenceSwitchWithDivider)P(8,1,3,2,5,4!1,7)428@14172L329,446@14644L43,448@14704L1728,442@14507L1925:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(description) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(icon) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                z = isSwitchEnabled;
                int i5 = $composer2.changed(z) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                z = isSwitchEnabled;
            }
            $dirty |= i5;
        } else {
            z = isSwitchEnabled;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z2 = isChecked;
        } else if (($changed & 458752) == 0) {
            z2 = isChecked;
            $dirty |= $composer2.changed(z2) ? 131072 : 65536;
        } else {
            z2 = isChecked;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                imageVector = checkedIcon;
                int i7 = $composer2.changed(imageVector) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                imageVector = checkedIcon;
            }
            $dirty |= i7;
        } else {
            imageVector = checkedIcon;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled3 = enabled;
            function2 = function0;
            function3 = function1;
            isSwitchEnabled3 = z;
            isChecked3 = z2;
            checkedIcon2 = imageVector;
            description3 = description;
            icon3 = icon;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                description2 = i2 != 0 ? null : description;
                icon2 = i3 != 0 ? null : icon;
                enabled2 = i4 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    isSwitchEnabled2 = enabled2;
                    $dirty &= -57345;
                } else {
                    isSwitchEnabled2 = z;
                }
                isChecked2 = i6 != 0 ? true : z2;
                if ((i & 64) != 0) {
                    checkedIcon2 = CheckKt.getCheck(Icons.Outlined.INSTANCE);
                    $dirty &= -3670017;
                } else {
                    checkedIcon2 = imageVector;
                }
                c32631 = i8 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithDivider.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function0;
                c32642 = i9 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithDivider.2
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function1;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 64) != 0) {
                    description2 = description;
                    icon2 = icon;
                    enabled2 = enabled;
                    c32642 = function1;
                    $dirty &= -3670017;
                    isSwitchEnabled2 = z;
                    isChecked2 = z2;
                    checkedIcon2 = imageVector;
                    c32631 = function0;
                } else {
                    description2 = description;
                    icon2 = icon;
                    enabled2 = enabled;
                    c32631 = function0;
                    c32642 = function1;
                    isSwitchEnabled2 = z;
                    isChecked2 = z2;
                    checkedIcon2 = imageVector;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(110200258, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchWithDivider (PreferenceItems.kt:427)");
            }
            $composer2.startReplaceGroup(1941784133);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty) == 131072;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = isChecked2 ? ComposableLambdaKt.composableLambdaInstance(827298733, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithDivider$thumbContent$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        ComposerKt.sourceInformation($composer3, "C431@14249L188:PreferenceItems.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(827298733, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchWithDivider.<anonymous>.<anonymous> (PreferenceItems.kt:431)");
                            }
                            IconKt.m2292Iconww6aTOc(checkedIcon2, (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, SwitchDefaults.INSTANCE.m2699getIconSizeD9Ej5fM()), 0L, $composer3, 48, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }) : null;
                $composer2.updateRememberedValue(value$iv);
            } else {
                checkedIcon2 = checkedIcon2;
                value$iv = it$iv;
            }
            final Function2 thumbContent = (Function2) value$iv;
            $composer2.endReplaceGroup();
            final ImageVector imageVector2 = icon2;
            final boolean z3 = isChecked2;
            final Function0<Unit> function4 = c32642;
            final boolean z4 = isSwitchEnabled2;
            final boolean z5 = enabled2;
            final String str = description2;
            Function0<Unit> function5 = c32631;
            SurfaceKt.m2666SurfaceT9BRK9s(ClickableKt.m487clickableXHw0xAI$default(Modifier.INSTANCE, enabled2, StringResources_androidKt.stringResource(C3070R.string.open_settings, $composer2, 0), null, c32631, 4, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1354476131, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithDivider.3
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

                /* JADX WARN: Code duplicated, block: B:51:0x0370  */
                /* JADX WARN: Code duplicated, block: B:53:0x0375  */
                /* JADX WARN: Code duplicated, block: B:60:0x0438  */
                /* JADX WARN: Code duplicated, block: B:67:0x0475  */
                /* JADX WARN: Code duplicated, block: B:70:0x04be  */
                /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function6;
                    Function0<ComposeUiNode> function7;
                    CompositionLocalMap localMap$iv$iv;
                    String str2;
                    boolean z6;
                    boolean invalid$iv2;
                    Object value$iv2;
                    boolean invalid$iv3;
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "C449@14714L1712:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1354476131, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchWithDivider.<anonymous> (PreferenceItems.kt:449)");
                    }
                    Modifier modifier$iv = IntrinsicKt.height(PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(16)), IntrinsicSize.Min);
                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                    ImageVector imageVector3 = imageVector2;
                    final String str3 = title;
                    boolean z7 = z3;
                    final Function0<Unit> function8 = function4;
                    Function2<Composer, Integer, Unit> function9 = thumbContent;
                    boolean z8 = z4;
                    boolean z9 = z5;
                    String str4 = str;
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function6 = constructor;
                        $composer3.createNode(function6);
                    } else {
                        function6 = constructor;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i10 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    int i11 = ((390 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u244 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1119340257, "C466@15359L326,481@15962L11,475@15698L318,488@16240L74,485@16108L15,483@16029L387:PreferenceItems.kt#g7nzpb");
                    $composer3.startReplaceGroup(-1119340251);
                    ComposerKt.sourceInformation($composer3, "*463@15264L11,457@14992L340");
                    if (imageVector3 != null) {
                        IconKt.m2292Iconww6aTOc(imageVector3, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ThemeKt.m7665applyOpacityDxMtmZc(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z9), $composer3, 432, 0);
                    }
                    r15.endReplaceGroup();
                    Modifier modifier$iv2 = RowScope.CC.weight$default($this$invoke_u24lambda_u244, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv2 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function7 = constructor2;
                        $composer3.createNode(function7);
                    } else {
                        function7 = constructor2;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        localMap$iv$iv = localMap$iv$iv3;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 364352674, "C469@15446L52:PreferenceItems.kt#g7nzpb");
                        PreferenceItemsKt.m7311PreferenceItemTitleGa5sM4s(null, r16, 0, null, z9, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                        $composer3.startReplaceGroup(-1119339706);
                        ComposerKt.sourceInformation($composer3, "470@15549L122");
                        str2 = str4;
                        if (str2 != null || str2.length() == 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (!z6) {
                            PreferenceItemsKt.m7310PreferenceItemDescriptionGa5sM4s(null, str4, 0, null, z9, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierM870paddingVpY3zN4$default = PaddingKt.m870paddingVpY3zN4$default(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(32)), C1979Dp.m6801constructorimpl(8), 0.0f, 2, null);
                        float $this$dp$iv = C1979Dp.m6801constructorimpl(1.0f);
                        Modifier modifierAlign = $this$invoke_u24lambda_u244.align(SizeKt.m918width3ABfNKs(modifierM870paddingVpY3zN4$default, $this$dp$iv), Alignment.INSTANCE.getCenterVertically());
                        long onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
                        DividerKt.m2224VerticalDivider9IZ8Weo(modifierAlign, 0.0f, Color.m4289copywmQWz5c(onSurface, (14 & 1) != 0 ? Color.m4293getAlphaimpl(onSurface) : 0.3f, (14 & 2) != 0 ? Color.m4297getRedimpl(onSurface) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(onSurface) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(onSurface) : 0.0f), $composer3, 0, 2);
                        Modifier modifierM870paddingVpY3zN4$default2 = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(6), 0.0f, 2, null);
                        $composer3.startReplaceGroup(-1119338981);
                        ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
                        invalid$iv2 = $composer3.changed(r16);
                        Object it$iv2 = $composer3.rememberedValue();
                        if (!invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithDivider$3$1$3$1
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
                                    SemanticsPropertiesKt.setContentDescription(semantics, str3);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM870paddingVpY3zN4$default2, false, (Function1) value$iv2, 1, null);
                        $composer3.startReplaceGroup(-1119339113);
                        ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
                        invalid$iv3 = $composer3.changed(function8);
                        Object it$iv3 = $composer3.rememberedValue();
                        if (!invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithDivider$3$1$4$1
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
                                    function8.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer3.endReplaceGroup();
                        SwitchKt.Switch(z7, (Function1) value$iv3, modifierSemantics$default, function9, z8, null, null, $composer3, 0, 96);
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
                    localMap$iv$iv = localMap$iv$iv3;
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i14 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    int i15 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 364352674, "C469@15446L52:PreferenceItems.kt#g7nzpb");
                    PreferenceItemsKt.m7311PreferenceItemTitleGa5sM4s(null, r16, 0, null, z9, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                    $composer3.startReplaceGroup(-1119339706);
                    ComposerKt.sourceInformation($composer3, "470@15549L122");
                    str2 = str4;
                    if (str2 != null) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (!z6) {
                        PreferenceItemsKt.m7310PreferenceItemDescriptionGa5sM4s(null, str4, 0, null, z9, 0L, 0, $composer3, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifierM870paddingVpY3zN4$default3 = PaddingKt.m870paddingVpY3zN4$default(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(32)), C1979Dp.m6801constructorimpl(8), 0.0f, 2, null);
                    float $this$dp$iv2 = C1979Dp.m6801constructorimpl(1.0f);
                    Modifier modifierAlign2 = $this$invoke_u24lambda_u244.align(SizeKt.m918width3ABfNKs(modifierM870paddingVpY3zN4$default3, $this$dp$iv2), Alignment.INSTANCE.getCenterVertically());
                    long onSurface2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
                    DividerKt.m2224VerticalDivider9IZ8Weo(modifierAlign2, 0.0f, Color.m4289copywmQWz5c(onSurface2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(onSurface2) : 0.3f, (14 & 2) != 0 ? Color.m4297getRedimpl(onSurface2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(onSurface2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(onSurface2) : 0.0f), $composer3, 0, 2);
                    Modifier modifierM870paddingVpY3zN4$default4 = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(6), 0.0f, 2, null);
                    $composer3.startReplaceGroup(-1119338981);
                    ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
                    invalid$iv2 = $composer3.changed(r16);
                    Object it$iv4 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithDivider$3$1$3$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str3);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithDivider$3$1$3$1
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
                                SemanticsPropertiesKt.setContentDescription(semantics, str3);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceGroup();
                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierM870paddingVpY3zN4$default4, false, (Function1) value$iv2, 1, null);
                    $composer3.startReplaceGroup(-1119339113);
                    ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
                    invalid$iv3 = $composer3.changed(function8);
                    Object it$iv5 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                        value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithDivider$3$1$4$1
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
                                function8.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithDivider$3$1$4$1
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
                                function8.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                    }
                    $composer3.endReplaceGroup();
                    SwitchKt.Switch(z7, (Function1) value$iv3, modifierSemantics$default2, function9, z8, null, null, $composer3, 0, 96);
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
            }, $composer2, 54), $composer2, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function2 = function5;
            description3 = description2;
            function3 = c32642;
            icon3 = icon2;
            enabled3 = enabled2;
            isSwitchEnabled3 = isSwitchEnabled2;
            isChecked3 = isChecked2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = description3;
            final ImageVector imageVector3 = icon3;
            final boolean z6 = enabled3;
            final boolean z7 = isSwitchEnabled3;
            final boolean z8 = isChecked3;
            final ImageVector imageVector4 = checkedIcon2;
            final Function0<Unit> function6 = function2;
            final Function0<Unit> function7 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithDivider.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    PreferenceItemsKt.PreferenceSwitchWithDivider(title, str2, imageVector3, z6, z7, z8, imageVector4, function6, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x039f  */
    /* JADX WARN: Code duplicated, block: B:103:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:106:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:109:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:110:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:114:0x050b  */
    /* JADX WARN: Code duplicated, block: B:115:0x055a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0599  */
    /* JADX WARN: Code duplicated, block: B:91:0x027e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0283  */
    /* JADX WARN: Code duplicated, block: B:95:0x0303  */
    /* JADX WARN: Code duplicated, block: B:96:0x030e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0393  */
    public static final void PreferencesCautionCard(final String title, String description, ImageVector icon, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        String str;
        ImageVector imageVector;
        Function0<Unit> function1;
        String description2;
        ImageVector icon2;
        Object value$iv;
        Function0<ComposeUiNode> function2;
        float fM6801constructorimpl;
        MeasurePolicy measurePolicy$iv;
        int compositeKeyHash$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> constructor;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        MeasurePolicy measurePolicy$iv2;
        CompositionLocalMap localMap$iv$iv2;
        MaterialTheme $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-1831886133);
        ComposerKt.sourceInformation($composer3, "C(PreferencesCautionCard)P(3)510@16749L6,511@16806L11,511@16833L22,512@16880L13,506@16598L1566:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            str = description;
        } else if (($changed & 112) == 0) {
            str = description;
            $dirty |= $composer3.changed(str) ? 32 : 16;
        } else {
            str = description;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            imageVector = icon;
        } else if (($changed & 896) == 0) {
            imageVector = icon;
            $dirty |= $composer3.changed(imageVector) ? 256 : 128;
        } else {
            imageVector = icon;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function1 = function0;
        } else if (($changed & 7168) == 0) {
            function1 = function0;
            $dirty |= $composer3.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            description2 = str;
            icon2 = imageVector;
            $composer2 = $composer3;
        } else {
            description2 = i2 != 0 ? null : str;
            icon2 = i3 != 0 ? null : imageVector;
            final Function0<Unit> function3 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferencesCautionCard.1
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
                ComposerKt.traceEventStart(-1831886133, $dirty2, -1, "com.videshkarmakar.loop.ui.component.PreferencesCautionCard (PreferenceItems.kt:504)");
            }
            Modifier modifierM454backgroundbw27NRU$default = BackgroundKt.m454backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(12)), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraLarge()), ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getErrorContainer(), $composer3, 0), null, 2, null);
            $composer3.startReplaceGroup(1897408704);
            ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferencesCautionCard$2$1
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
                        function3.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(ClickableKt.m487clickableXHw0xAI$default(modifierM454backgroundbw27NRU$default, false, null, null, (Function0) value$iv, 7, null), C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                function2 = constructor2;
            } else {
                function2 = constructor2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i6 = ((384 >> 6) & 112) | 6;
                RowScope $this$PreferencesCautionCard_u24lambda_u2411 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1042582669, "C527@17372L786:PreferenceItems.kt#g7nzpb");
                $composer3.startReplaceGroup(-1042582663);
                ComposerKt.sourceInformation($composer3, "*523@17298L11,523@17316L22,517@17050L303");
                if (icon2 == null) {
                    IconKt.m2292Iconww6aTOc(icon2, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError(), $composer3, 0), $composer3, (($dirty2 >> 6) & 14) | 432, 0);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                $composer3.endReplaceGroup();
                Modifier modifierWeight$default = RowScope.CC.weight$default($this$PreferencesCautionCard_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null);
                if (icon2 == null) {
                    fM6801constructorimpl = C1979Dp.m6801constructorimpl(12);
                } else {
                    fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                }
                Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(modifierWeight$default, fM6801constructorimpl, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    measurePolicy$iv2 = measurePolicy$iv;
                    localMap$iv$iv2 = localMap$iv$iv;
                } else {
                    measurePolicy$iv2 = measurePolicy$iv;
                    localMap$iv$iv2 = localMap$iv$iv;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i8 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1528588773, "C:PreferenceItems.kt#g7nzpb");
                    $composer3.startReplaceGroup(-1042582150);
                    ComposerKt.sourceInformation($composer3, "*537@17686L10,538@17760L11,538@17789L22,534@17584L245");
                    $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249 = MaterialTheme.INSTANCE;
                    TextStyle titleLarge = $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getTitleLarge();
                    Function0<Unit> function4 = function3;
                    $composer2 = $composer3;
                    TextKt.m2817Text4IGK_g(title, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, titleLarge.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleLarge.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleLarge.spanStyle.getFontSize() : TextUnitKt.getSp(20), (16777213 & 4) != 0 ? titleLarge.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleLarge.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleLarge.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleLarge.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleLarge.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleLarge.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleLarge.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleLarge.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleLarge.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleLarge.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleLarge.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleLarge.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleLarge.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleLarge.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleLarge.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleLarge.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleLarge.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleLarge.platformStyle : null, (16777213 & 1048576) != 0 ? titleLarge.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleLarge.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleLarge.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleLarge.paragraphStyle.getTextMotion() : null), $composer3, $dirty2 & 14, 3072, 57338);
                    $composer3.startReplaceGroup(-1528588472);
                    ComposerKt.sourceInformation($composer3, "542@17945L11,542@17974L22,544@18094L10,540@17871L263");
                    if (description2 != null) {
                        TextKt.m2817Text4IGK_g(description2, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty2 >> 3) & 14, 3120, 55290);
                    }
                    $composer3.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function1 = function4;
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1528588773, "C:PreferenceItems.kt#g7nzpb");
                $composer3.startReplaceGroup(-1042582150);
                ComposerKt.sourceInformation($composer3, "*537@17686L10,538@17760L11,538@17789L22,534@17584L245");
                $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249 = MaterialTheme.INSTANCE;
                TextStyle titleLarge2 = $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getTitleLarge();
                Function0<Unit> function5 = function3;
                $composer2 = $composer3;
                TextKt.m2817Text4IGK_g(title, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, titleLarge2.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleLarge2.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleLarge2.spanStyle.getFontSize() : TextUnitKt.getSp(20), (16777213 & 4) != 0 ? titleLarge2.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleLarge2.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleLarge2.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleLarge2.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleLarge2.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleLarge2.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleLarge2.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleLarge2.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleLarge2.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleLarge2.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleLarge2.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleLarge2.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleLarge2.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleLarge2.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleLarge2.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleLarge2.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleLarge2.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleLarge2.platformStyle : null, (16777213 & 1048576) != 0 ? titleLarge2.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleLarge2.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleLarge2.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleLarge2.paragraphStyle.getTextMotion() : null), $composer3, $dirty2 & 14, 3072, 57338);
                $composer3.startReplaceGroup(-1528588472);
                ComposerKt.sourceInformation($composer3, "542@17945L11,542@17974L22,544@18094L10,540@17871L263");
                if (description2 != null) {
                    TextKt.m2817Text4IGK_g(description2, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty2 >> 3) & 14, 3120, 55290);
                }
                $composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function1 = function5;
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i11 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i12 = ((384 >> 6) & 112) | 6;
            RowScope $this$PreferencesCautionCard_u24lambda_u2412 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1042582669, "C527@17372L786:PreferenceItems.kt#g7nzpb");
            $composer3.startReplaceGroup(-1042582663);
            ComposerKt.sourceInformation($composer3, "*523@17298L11,523@17316L22,517@17050L303");
            if (icon2 == null) {
                IconKt.m2292Iconww6aTOc(icon2, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError(), $composer3, 0), $composer3, (($dirty2 >> 6) & 14) | 432, 0);
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            $composer3.endReplaceGroup();
            Modifier modifierWeight$default2 = RowScope.CC.weight$default($this$PreferencesCautionCard_u24lambda_u2412, Modifier.INSTANCE, 1.0f, false, 2, null);
            if (icon2 == null) {
                fM6801constructorimpl = C1979Dp.m6801constructorimpl(12);
            } else {
                fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
            }
            Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default(modifierWeight$default2, fM6801constructorimpl, 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
            measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                measurePolicy$iv2 = measurePolicy$iv;
                localMap$iv$iv2 = localMap$iv$iv;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i13 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                int i14 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1528588773, "C:PreferenceItems.kt#g7nzpb");
                $composer3.startReplaceGroup(-1042582150);
                ComposerKt.sourceInformation($composer3, "*537@17686L10,538@17760L11,538@17789L22,534@17584L245");
                $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249 = MaterialTheme.INSTANCE;
                TextStyle titleLarge3 = $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getTitleLarge();
                Function0<Unit> function6 = function3;
                $composer2 = $composer3;
                TextKt.m2817Text4IGK_g(title, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, titleLarge3.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleLarge3.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleLarge3.spanStyle.getFontSize() : TextUnitKt.getSp(20), (16777213 & 4) != 0 ? titleLarge3.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleLarge3.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleLarge3.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleLarge3.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleLarge3.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleLarge3.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleLarge3.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleLarge3.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleLarge3.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleLarge3.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleLarge3.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleLarge3.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleLarge3.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleLarge3.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleLarge3.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleLarge3.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleLarge3.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleLarge3.platformStyle : null, (16777213 & 1048576) != 0 ? titleLarge3.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleLarge3.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleLarge3.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleLarge3.paragraphStyle.getTextMotion() : null), $composer3, $dirty2 & 14, 3072, 57338);
                $composer3.startReplaceGroup(-1528588472);
                ComposerKt.sourceInformation($composer3, "542@17945L11,542@17974L22,544@18094L10,540@17871L263");
                if (description2 != null) {
                    TextKt.m2817Text4IGK_g(description2, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty2 >> 3) & 14, 3120, 55290);
                }
                $composer3.endReplaceGroup();
                Unit unit7 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function1 = function6;
            } else {
                measurePolicy$iv2 = measurePolicy$iv;
                localMap$iv$iv2 = localMap$iv$iv;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i15 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            int i16 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1528588773, "C:PreferenceItems.kt#g7nzpb");
            $composer3.startReplaceGroup(-1042582150);
            ComposerKt.sourceInformation($composer3, "*537@17686L10,538@17760L11,538@17789L22,534@17584L245");
            $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249 = MaterialTheme.INSTANCE;
            TextStyle titleLarge4 = $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getTitleLarge();
            Function0<Unit> function7 = function3;
            $composer2 = $composer3;
            TextKt.m2817Text4IGK_g(title, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, titleLarge4.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleLarge4.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleLarge4.spanStyle.getFontSize() : TextUnitKt.getSp(20), (16777213 & 4) != 0 ? titleLarge4.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleLarge4.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleLarge4.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleLarge4.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleLarge4.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleLarge4.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleLarge4.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleLarge4.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleLarge4.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleLarge4.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleLarge4.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleLarge4.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleLarge4.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleLarge4.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleLarge4.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleLarge4.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleLarge4.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleLarge4.platformStyle : null, (16777213 & 1048576) != 0 ? titleLarge4.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleLarge4.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleLarge4.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleLarge4.paragraphStyle.getTextMotion() : null), $composer3, $dirty2 & 14, 3072, 57338);
            $composer3.startReplaceGroup(-1528588472);
            ComposerKt.sourceInformation($composer3, "542@17945L11,542@17974L22,544@18094L10,540@17871L263");
            if (description2 != null) {
                TextKt.m2817Text4IGK_g(description2, (Modifier) null, ColorSchemeKt.m7646harmonizeWithPrimaryek8zF_U($this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getColorScheme($composer3, MaterialTheme.$stable).getOnErrorContainer(), $composer3, 0), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$PreferencesCautionCard_u24lambda_u2411_u24lambda_u2410_u24lambda_u249.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty2 >> 3) & 14, 3120, 55290);
            }
            $composer3.endReplaceGroup();
            Unit unit8 = Unit.INSTANCE;
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function7;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = description2;
            final ImageVector imageVector2 = icon2;
            final Function0<Unit> function8 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferencesCautionCard.4
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
                    PreferenceItemsKt.PreferencesCautionCard(title, str2, imageVector2, function8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: PreferencesHintCard-jB83MbM, reason: not valid java name */
    public static final void m7313PreferencesHintCardjB83MbM(String title, String description, ImageVector icon, long containerColor, long contentColor, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        String title2;
        String str;
        ImageVector icon2;
        long containerColor2;
        long contentColor2;
        final Function0<Unit> function1;
        String description2;
        Object value$iv;
        long containerColor3;
        Function0<ComposeUiNode> function2;
        ImageVector icon3;
        Function0<ComposeUiNode> function3;
        Function0<Unit> function4;
        String title3;
        String description3;
        long contentColor3;
        Composer $composer2 = $composer.startRestartGroup(-710511383);
        ComposerKt.sourceInformation($composer2, "C(PreferencesHintCard)P(5,2,3,0:c#ui.graphics.Color,1:c#ui.graphics.Color)558@18398L11,559@18470L11,566@18694L6,568@18776L13,562@18542L1396:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            if ((i & 1) == 0) {
                title2 = title;
                int i2 = $composer2.changed(title2) ? 4 : 2;
                $dirty |= i2;
            } else {
                title2 = title;
            }
            $dirty |= i2;
        } else {
            title2 = title;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                str = description;
                int i3 = $composer2.changed(str) ? 32 : 16;
                $dirty |= i3;
            } else {
                str = description;
            }
            $dirty |= i3;
        } else {
            str = description;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                icon2 = icon;
                int i4 = $composer2.changed(icon2) ? 256 : 128;
                $dirty |= i4;
            } else {
                icon2 = icon;
            }
            $dirty |= i4;
        } else {
            icon2 = icon;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function1 = function0;
        } else if (($changed & 458752) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 131072 : 65536;
        } else {
            function1 = function0;
        }
        if (($dirty & 374491) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            title3 = title2;
            description3 = str;
            icon3 = icon2;
            containerColor3 = containerColor2;
            function4 = function1;
            contentColor3 = contentColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    title2 = StringsKt.repeat("Title ", 2);
                    $dirty &= -15;
                }
                if ((i & 2) != 0) {
                    description2 = StringsKt.repeat("Description text ", 3);
                    $dirty &= -113;
                } else {
                    description2 = str;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    icon2 = TranslateKt.getTranslate(Icons.Outlined.INSTANCE);
                }
                if ((i & 8) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSecondaryContainer();
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSecondaryContainer();
                    $dirty &= -57345;
                }
                if (i7 != 0) {
                    function1 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferencesHintCard$1
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
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty &= -15;
                }
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                description2 = str;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-710511383, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferencesHintCard (PreferenceItems.kt:561)");
            }
            Modifier modifierM454backgroundbw27NRU$default = BackgroundKt.m454backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(12)), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getExtraLarge()), containerColor2, null, 2, null);
            $composer2.startReplaceGroup(780307798);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty) == 131072;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferencesHintCard$2$1
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
                        function1.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(ClickableKt.m487clickableXHw0xAI$default(modifierM454backgroundbw27NRU$default, false, null, null, (Function0) value$iv, 7, null), C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            containerColor3 = containerColor2;
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
                function2 = constructor;
                $composer2.createNode(function2);
            } else {
                function2 = constructor;
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
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i9 = ((384 >> 6) & 112) | 6;
            RowScope $this$PreferencesHintCard_jB83MbM_u24lambda_u2416 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 623739657, "C582@19225L707:PreferenceItems.kt#g7nzpb");
            $composer2.startReplaceGroup(623739663);
            ComposerKt.sourceInformation($composer2, "*573@18946L260");
            if (icon2 != null) {
                IconKt.m2292Iconww6aTOc(icon2, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), contentColor2, $composer2, (($dirty >> 6) & 14) | 432 | (($dirty >> 3) & 7168), 0);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            $composer2.endReplaceGroup();
            icon3 = icon2;
            Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(RowScope.CC.weight$default($this$PreferencesHintCard_jB83MbM_u24lambda_u2416, Modifier.INSTANCE, 1.0f, false, 2, null), icon2 == null ? C1979Dp.m6801constructorimpl(12) : C1979Dp.m6801constructorimpl(0), 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, $i$f$Column);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            Function0<Unit> function5 = function1;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function3 = constructor2;
                $composer2.createNode(function3);
            } else {
                function3 = constructor2;
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
            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i11 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1863004026, "C:PreferenceItems.kt#g7nzpb");
            $composer2.startReplaceGroup(623740133);
            ComposerKt.sourceInformation($composer2, "*591@19538L10,588@19436L206");
            MaterialTheme $this$PreferencesHintCard_jB83MbM_u24lambda_u2416_u24lambda_u2415_u24lambda_u2414 = MaterialTheme.INSTANCE;
            TextStyle titleLarge = $this$PreferencesHintCard_jB83MbM_u24lambda_u2416_u24lambda_u2415_u24lambda_u2414.getTypography($composer2, MaterialTheme.$stable).getTitleLarge();
            TextKt.m2817Text4IGK_g(title2, (Modifier) null, contentColor2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, titleLarge.m6277copyp1EtxEg((16777213 & 1) != 0 ? titleLarge.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleLarge.spanStyle.getFontSize() : TextUnitKt.getSp(20), (16777213 & 4) != 0 ? titleLarge.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleLarge.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleLarge.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleLarge.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleLarge.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleLarge.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleLarge.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleLarge.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleLarge.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleLarge.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleLarge.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleLarge.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleLarge.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleLarge.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleLarge.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleLarge.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleLarge.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleLarge.platformStyle : null, (16777213 & 1048576) != 0 ? titleLarge.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleLarge.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleLarge.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleLarge.paragraphStyle.getTextMotion() : null), $composer2, ($dirty & 14) | (($dirty >> 6) & 896), 3072, 57338);
            $composer2.startReplaceGroup(-1863003765);
            ComposerKt.sourceInformation($composer2, "598@19868L10,594@19684L224");
            if (description2 != null) {
                TextKt.m2817Text4IGK_g(description2, (Modifier) null, contentColor2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$PreferencesHintCard_jB83MbM_u24lambda_u2416_u24lambda_u2415_u24lambda_u2414.getTypography($composer2, MaterialTheme.$stable).getBodyMedium(), $composer2, (($dirty >> 3) & 14) | (($dirty >> 6) & 896), 3120, 55290);
            }
            $composer2.endReplaceGroup();
            Unit unit3 = Unit.INSTANCE;
            $composer2.endReplaceGroup();
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
            function4 = function5;
            title3 = title2;
            description3 = description2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = title3;
            final String str3 = description3;
            final ImageVector imageVector = icon3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final Function0<Unit> function6 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferencesHintCard$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    PreferenceItemsKt.m7313PreferencesHintCardjB83MbM(str2, str3, imageVector, j, j2, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreferenceSwitchWithContainerPreview(Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1970988406);
        ComposerKt.sourceInformation($composer2, "C(PreferenceSwitchWithContainerPreview)609@20161L34,610@20210L205,610@20200L215:PreferenceItems.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1970988406, $changed, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchWithContainerPreview (PreferenceItems.kt:608)");
            }
            $composer2.startReplaceGroup(-916167944);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState isChecked$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            ThemeKt.LoopTheme(false, false, false, ComposableLambdaKt.rememberComposableLambda(-1451338131, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithContainerPreview.1
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
                    ComposerKt.sourceInformation($composer3, "C614@20348L26,611@20220L189:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1451338131, $changed2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchWithContainerPreview.<anonymous> (PreferenceItems.kt:611)");
                        }
                        String strRepeat = StringsKt.repeat("Title ", 2);
                        boolean zPreferenceSwitchWithContainerPreview$lambda$18 = PreferenceItemsKt.PreferenceSwitchWithContainerPreview$lambda$18(isChecked$delegate);
                        $composer3.startReplaceGroup(117689172);
                        ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
                        final MutableState<Boolean> mutableState = isChecked$delegate;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithContainerPreview$1$1$1
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
                                    PreferenceItemsKt.PreferenceSwitchWithContainerPreview$lambda$19(mutableState, !PreferenceItemsKt.PreferenceSwitchWithContainerPreview$lambda$18(mutableState));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        PreferenceItemsKt.PreferenceSwitchWithContainer(strRepeat, null, zPreferenceSwitchWithContainerPreview$lambda$18, (Function0) value$iv2, $composer3, 3120, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithContainerPreview.2
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
                    PreferenceItemsKt.PreferenceSwitchWithContainerPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PreferenceSwitchWithContainerPreview$lambda$18(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreferenceSwitchWithContainerPreview$lambda$19(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0577  */
    public static final void PreferenceSwitchWithContainer(final String title, ImageVector icon, final boolean isChecked, final Function0<Unit> onClick, Composer $composer, final int $changed, final int i) {
        ImageVector imageVector;
        ImageVector icon2;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        CompositionLocalMap localMap$iv$iv;
        MeasurePolicy measurePolicy$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(1275362477);
        ComposerKt.sourceInformation($composer3, "C(PreferenceSwitchWithContainer)P(3)627@20619L338,641@20987L39,646@21183L6,648@21257L11,654@21507L7,652@21392L13,642@21031L1598:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            imageVector = icon;
        } else if (($changed & 112) == 0) {
            imageVector = icon;
            $dirty |= $composer3.changed(imageVector) ? 32 : 16;
        } else {
            imageVector = icon;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(isChecked) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(onClick) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            icon2 = imageVector;
            $composer2 = $composer3;
        } else {
            icon2 = i2 != 0 ? null : imageVector;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1275362477, $dirty2, -1, "com.videshkarmakar.loop.ui.component.PreferenceSwitchWithContainer (PreferenceItems.kt:626)");
            }
            $composer3.startReplaceGroup(-318836);
            ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = isChecked ? ComposableSingletons$PreferenceItemsKt.INSTANCE.m7286getLambda3$app_debug() : null;
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            Function2 thumbContent = (Function2) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-318468);
            ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv2;
            $composer3.endReplaceGroup();
            Modifier modifierM454backgroundbw27NRU$default = BackgroundKt.m454backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(12)), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraLarge()), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer(), null, 2, null);
            ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localIndication);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Indication indication = (Indication) objConsume;
            $composer3.startReplaceGroup(-318063);
            ComposerKt.sourceInformation($composer3, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 7168) == 2048;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSwitchWithContainer$1$1
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
                        onClick.invoke();
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(ToggleableKt.m1120toggleableO2vRcR0$default(modifierM454backgroundbw27NRU$default, isChecked, interactionSource, indication, false, null, (Function1) value$iv3, 24, null), C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(20));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$PreferenceSwitchWithContainer_u24lambda_u2425 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -70635713, "C669@21996L372,681@22377L246:PreferenceItems.kt#g7nzpb");
            $composer3.startReplaceGroup(-70635707);
            ComposerKt.sourceInformation($composer3, "*666@21933L11,660@21685L292");
            if (icon2 != null) {
                IconKt.m2292Iconww6aTOc(icon2, (String) null, SizeKt.m913size3ABfNKs(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 10, null), C1979Dp.m6801constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimaryContainer(), $composer3, (($dirty2 >> 3) & 14) | 432, 0);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(RowScope.CC.weight$default($this$PreferenceSwitchWithContainer_u24lambda_u2425, Modifier.INSTANCE, 1.0f, false, 2, null), icon2 == null ? C1979Dp.m6801constructorimpl(12) : C1979Dp.m6801constructorimpl(0), 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                localMap$iv$iv = localMap$iv$iv3;
                measurePolicy$iv = measurePolicy$iv3;
            } else {
                localMap$iv$iv = localMap$iv$iv3;
                measurePolicy$iv = measurePolicy$iv3;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -776712100, "C678@22314L11,674@22169L189:PreferenceItems.kt#g7nzpb");
                $composer2 = $composer3;
                TextKt.m2817Text4IGK_g(title, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TypeKt.getPreferenceTitle(), $composer3, $dirty2 & 14, 1575936, 57338);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SwitchKt.Switch(isChecked, null, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(6), 0.0f, 10, null), thumbContent, false, null, interactionSource, $composer3, (($dirty2 >> 6) & 14) | 1573296, 48);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -776712100, "C678@22314L11,674@22169L189:PreferenceItems.kt#g7nzpb");
            $composer2 = $composer3;
            TextKt.m2817Text4IGK_g(title, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TypeKt.getPreferenceTitle(), $composer3, $dirty2 & 14, 1575936, 57338);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SwitchKt.Switch(isChecked, null, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12), 0.0f, C1979Dp.m6801constructorimpl(6), 0.0f, 10, null), thumbContent, false, null, interactionSource, $composer3, (($dirty2 >> 6) & 14) | 1573296, 48);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            final ImageVector imageVector2 = icon2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceSwitchWithContainer.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    PreferenceItemsKt.PreferenceSwitchWithContainer(title, imageVector2, isChecked, onClick, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void CreditItem(final String title, String license, boolean enabled, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        String str;
        boolean z;
        Function0<Unit> function1;
        Object value$iv;
        String license2;
        boolean enabled2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(1926675934);
        ComposerKt.sourceInformation($composer2, "C(CreditItem)P(3,1)698@22814L13,698@22829L1083,698@22776L1136:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            str = license;
        } else if (($changed & 112) == 0) {
            str = license;
            $dirty |= $composer2.changed(str) ? 32 : 16;
        } else {
            str = license;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = enabled;
        } else if (($changed & 896) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            function1 = function0;
        } else if (($changed & 7168) == 0) {
            function1 = function0;
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            license2 = str;
            enabled2 = z;
        } else {
            final String license3 = i2 != 0 ? null : str;
            final boolean enabled3 = i3 != 0 ? true : z;
            final C32401 c32401 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.CreditItem.1
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
                ComposerKt.traceEventStart(1926675934, $dirty, -1, "com.videshkarmakar.loop.ui.component.CreditItem (PreferenceItems.kt:697)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            $composer2.startReplaceGroup(-1545764123);
            ComposerKt.sourceInformation($composer2, "CC(remember):PreferenceItems.kt#9igjgp");
            boolean invalid$iv = ($dirty & 7168) == 2048;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$CreditItem$2$1
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
                        c32401.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            SurfaceKt.m2666SurfaceT9BRK9s(ClickableKt.m487clickableXHw0xAI$default(companion, false, null, null, (Function0) value$iv, 7, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(104143843, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.CreditItem.3
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
                    Function0<ComposeUiNode> function2;
                    Function0<ComposeUiNode> function3;
                    Composer $composer4;
                    ComposerKt.sourceInformation($composer3, "C699@22839L1067:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(104143843, $changed2, -1, "com.videshkarmakar.loop.ui.component.CreditItem.<anonymous> (PreferenceItems.kt:699)");
                        }
                        Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(16));
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        boolean z2 = enabled3;
                        String str2 = title;
                        String it = license3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv = (390 << 3) & 112;
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
                            function2 = constructor;
                            $composer3.createNode(function2);
                        } else {
                            function2 = constructor;
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
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i6 = ((390 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u243 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 387791256, "C705@23055L841:PreferenceItems.kt#g7nzpb");
                        Modifier modifier$iv2 = PaddingKt.m870paddingVpY3zN4$default(RowScope.CC.weight$default($this$invoke_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null), C1979Dp.m6801constructorimpl(10), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $i$f$Column);
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
                            function3 = constructor2;
                            $composer3.createNode(function3);
                        } else {
                            function3 = constructor2;
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
                        int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i8 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -857983274, "C:PreferenceItems.kt#g7nzpb");
                        $composer3.startReplaceGroup(387791413);
                        ComposerKt.sourceInformation($composer3, "*714@23368L10,715@23424L11,711@23254L235");
                        MaterialTheme $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241 = MaterialTheme.INSTANCE;
                        TextKt.m2817Text4IGK_g(str2, (Modifier) null, ThemeKt.m7665applyOpacityDxMtmZc($this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), z2), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 3072, 57338);
                        $composer3.startReplaceGroup(-857982967);
                        ComposerKt.sourceInformation($composer3, "*720@23630L11,722@23794L10,718@23549L293");
                        if (it == null) {
                            $composer4 = $composer3;
                        } else {
                            $composer4 = $composer3;
                            TextKt.m2817Text4IGK_g(it, (Modifier) null, ThemeKt.m7665applyOpacityDxMtmZc($this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), z2), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer4, 0, 3120, 55290);
                        }
                        $composer4.endReplaceGroup();
                        $composer4.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
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
            }, $composer2, 54), $composer2, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            license2 = license3;
            enabled2 = enabled3;
            function1 = c32401;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str2 = license2;
            final boolean z2 = enabled2;
            final Function0<Unit> function2 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.CreditItem.4
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
                    PreferenceItemsKt.CreditItem(title, str2, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void TemplateItem(String label, String template, boolean selected, boolean isMultiSelectEnabled, boolean checked, Function0<Unit> function0, Function0<Unit> function1, Function1<? super Boolean, Unit> function2, Function0<Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean z2;
        Modifier modifierThen;
        Function1<? super Boolean, Unit> function4;
        String label2;
        Function0<Unit> function5;
        String template2;
        boolean selected2;
        boolean isMultiSelectEnabled2;
        boolean checked2;
        Function0<Unit> function6;
        Function0<Unit> function7;
        Composer $composer2 = $composer.startRestartGroup(1158683836);
        ComposerKt.sourceInformation($composer2, "C(TemplateItem)P(2,8,7,1!1,4,6)759@24820L2028,746@24302L2546:PreferenceItems.kt#g7nzpb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(label) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(template) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(selected) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            z = isMultiSelectEnabled;
        } else if (($changed & 7168) == 0) {
            z = isMultiSelectEnabled;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = isMultiSelectEnabled;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            z2 = checked;
        } else if ((57344 & $changed) == 0) {
            z2 = checked;
            $dirty |= $composer2.changed(z2) ? 16384 : 8192;
        } else {
            z2 = checked;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            label2 = label;
            selected2 = selected;
            function6 = function0;
            function7 = function1;
            function4 = function2;
            function5 = function3;
            $dirty = $dirty;
            isMultiSelectEnabled2 = z;
            checked2 = z2;
            template2 = template;
        } else {
            String label3 = i2 != 0 ? "" : label;
            String template3 = i3 != 0 ? null : template;
            boolean selected3 = i4 != 0 ? false : selected;
            boolean isMultiSelectEnabled3 = i5 != 0 ? false : z;
            boolean checked3 = i6 != 0 ? false : z2;
            C32701 c32701 = i7 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.TemplateItem.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function0;
            C32712 c32712 = i8 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.TemplateItem.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            C32723 c32723 = i9 != 0 ? new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.TemplateItem.3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it) {
                }
            } : function2;
            C32734 c32734 = i10 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.TemplateItem.4
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1158683836, $dirty, -1, "com.videshkarmakar.loop.ui.component.TemplateItem (PreferenceItems.kt:745)");
            }
            $composer2.startReplaceGroup(2099478329);
            ComposerKt.sourceInformation($composer2, "");
            Modifier.Companion $this$TemplateItem_u24lambda_u2427 = Modifier.INSTANCE;
            $composer2.startReplaceGroup(2099478347);
            ComposerKt.sourceInformation($composer2, "751@24504L29,753@24621L41");
            if (isMultiSelectEnabled3) {
                modifierThen = $this$TemplateItem_u24lambda_u2427.then(ToggleableKt.m1122toggleableXHw0xAI$default($this$TemplateItem_u24lambda_u2427, checked3, false, null, c32723, 6, null));
            } else {
                modifierThen = $this$TemplateItem_u24lambda_u2427.then(ClickableKt.m490combinedClickablecJG_KMw($this$TemplateItem_u24lambda_u2427, (36 & 1) != 0, (36 & 2) != 0 ? null : StringResources_androidKt.stringResource(C3070R.string.edit, $composer2, 0), (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : StringResources_androidKt.stringResource(C3070R.string.multiselect_mode, $composer2, 0), (36 & 16) != 0 ? null : c32734, (36 & 32) != 0 ? null : null, c32701));
            }
            $composer2.endReplaceGroup();
            $composer2.endReplaceGroup();
            final boolean z3 = isMultiSelectEnabled3;
            final boolean z4 = checked3;
            final Function1<? super Boolean, Unit> function8 = c32723;
            final String str = label3;
            final String str2 = template3;
            final boolean z5 = selected3;
            final Function0<Unit> function9 = c32712;
            SurfaceKt.m2666SurfaceT9BRK9s(modifierThen, null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-391480127, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.TemplateItem.6
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
                    Function0<ComposeUiNode> function10;
                    Function0<ComposeUiNode> function11;
                    ComposerKt.sourceInformation($composer3, "C760@24830L2010:PreferenceItems.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-391480127, $changed2, -1, "com.videshkarmakar.loop.ui.component.TemplateItem.<anonymous> (PreferenceItems.kt:760)");
                        }
                        Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(16));
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        boolean z6 = z3;
                        final boolean z7 = z4;
                        final Function1<Boolean, Unit> function12 = function8;
                        final String str3 = str;
                        String it = str2;
                        final boolean z8 = z5;
                        final Function0<Unit> function13 = function9;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv = (390 << 3) & 112;
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
                            function10 = constructor;
                            $composer3.createNode(function10);
                        } else {
                            function10 = constructor;
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
                        int i11 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int $changed3 = ((390 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u243 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 692964007, "C766@25074L218,766@25023L269,774@25306L798,798@26161L667,798@26119L709:PreferenceItems.kt#g7nzpb");
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u243, z6, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1809653251, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$TemplateItem$6$1$1
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

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed4) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer4, "C767@25092L186:PreferenceItems.kt#g7nzpb");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1809653251, $changed4, -1, "com.videshkarmakar.loop.ui.component.TemplateItem.<anonymous>.<anonymous>.<anonymous> (PreferenceItems.kt:767)");
                                }
                                CheckboxKt.Checkbox(z7, function12, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$TemplateItem$6$1$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                    }
                                }), false, null, null, $composer4, 0, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, ($changed3 & 14) | 1572864, 30);
                        Modifier modifier$iv2 = PaddingKt.m870paddingVpY3zN4$default(RowScope.CC.weight$default($this$invoke_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null), C1979Dp.m6801constructorimpl(10), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                            function11 = constructor2;
                            $composer3.createNode(function11);
                        } else {
                            function11 = constructor2;
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
                        int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1205423488, "C:PreferenceItems.kt#g7nzpb");
                        $composer3.startReplaceGroup(692964447);
                        ComposerKt.sourceInformation($composer3, "*783@25619L10,784@25675L11,780@25505L213");
                        MaterialTheme $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241 = MaterialTheme.INSTANCE;
                        TextKt.m2817Text4IGK_g(str3, (Modifier) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 3072, 57338);
                        $composer3.startReplaceGroup(-1205423202);
                        ComposerKt.sourceInformation($composer3, "*789@25860L11,791@26002L10,787@25779L271");
                        if (it != null) {
                            TextKt.m2817Text4IGK_g(it, (Modifier) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u243, !z6, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1696579316, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$TemplateItem$6$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer4, int $changed4) {
                                Object value$iv;
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer4, "C799@26179L634:PreferenceItems.kt#g7nzpb");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1696579316, $changed4, -1, "com.videshkarmakar.loop.ui.component.TemplateItem.<anonymous>.<anonymous>.<anonymous> (PreferenceItems.kt:799)");
                                }
                                final String str4 = str3;
                                boolean z9 = z8;
                                Function0<Unit> function14 = function13;
                                ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                Modifier modifier$iv3 = Modifier.INSTANCE;
                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv3 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    $composer4.createNode(constructor3);
                                } else {
                                    $composer4.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer4);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i14 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                int i15 = ((0 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer4, 968520199, "C805@26476L11,800@26205L361,809@26654L30,808@26587L208:PreferenceItems.kt#g7nzpb");
                                DividerKt.m2224VerticalDivider9IZ8Weo($this$invoke_u24lambda_u241.align(PaddingKt.m870paddingVpY3zN4$default(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(32)), C1979Dp.m6801constructorimpl(12), 0.0f, 2, null), Alignment.INSTANCE.getCenterVertically()), C1979Dp.m6801constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOutlineVariant(), $composer4, 48, 0);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                $composer4.startReplaceGroup(968520648);
                                ComposerKt.sourceInformation($composer4, "CC(remember):PreferenceItems.kt#9igjgp");
                                boolean invalid$iv = $composer4.changed(str4);
                                Object it$iv = $composer4.rememberedValue();
                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$TemplateItem$6$1$3$1$1$1
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
                                            SemanticsPropertiesKt.setContentDescription(semantics, str4);
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = it$iv;
                                }
                                $composer4.endReplaceGroup();
                                RadioButtonKt.RadioButton(z9, function14, SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv, 1, null), false, null, null, $composer4, 0, 56);
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
                        }, $composer3, 54), $composer3, ($changed3 & 14) | 1572864, 30);
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
            }, $composer2, 54), $composer2, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = c32723;
            label2 = label3;
            function5 = c32734;
            template2 = template3;
            selected2 = selected3;
            isMultiSelectEnabled2 = isMultiSelectEnabled3;
            checked2 = checked3;
            function6 = c32701;
            function7 = c32712;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str3 = label2;
            final String str4 = template2;
            final boolean z6 = selected2;
            final boolean z7 = isMultiSelectEnabled2;
            final boolean z8 = checked2;
            final Function0<Unit> function10 = function6;
            final Function0<Unit> function11 = function7;
            final Function1<? super Boolean, Unit> function12 = function4;
            final Function0<Unit> function13 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.TemplateItem.7
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
                    PreferenceItemsKt.TemplateItem(str3, str4, z6, z7, z8, function10, function11, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: PreferenceSubtitle-ww6aTOc, reason: not valid java name */
    public static final void m7312PreferenceSubtitleww6aTOc(Modifier modifier, PaddingValues contentPadding, final String text, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        PaddingValues paddingValues;
        long color2;
        int $dirty;
        Modifier modifier3;
        PaddingValues contentPadding2;
        long color3;
        Modifier modifier4;
        PaddingValues contentPadding3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(1139812487);
        ComposerKt.sourceInformation($composer3, "C(PreferenceSubtitle)P(2,1,3,0:c#ui.graphics.Color)830@27070L11,838@27273L10,832@27099L201:PreferenceItems.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            paddingValues = contentPadding;
        } else if (($changed & 112) == 0) {
            paddingValues = contentPadding;
            $dirty2 |= $composer3.changed(paddingValues) ? 32 : 16;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(text) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                color2 = color;
                int i4 = $composer3.changed(color2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                color2 = color;
            }
            $dirty2 |= i4;
        } else {
            color2 = color;
        }
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            contentPadding3 = paddingValues;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                PaddingValues contentPadding4 = i3 != 0 ? PaddingKt.m865PaddingValuesa9UjIt4$default(C1979Dp.m6801constructorimpl(20), C1979Dp.m6801constructorimpl(24), 0.0f, C1979Dp.m6801constructorimpl(12), 4, null) : paddingValues;
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    modifier3 = modifier5;
                    contentPadding2 = contentPadding4;
                    color3 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    contentPadding2 = contentPadding4;
                    color3 = color2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                contentPadding2 = paddingValues;
                color3 = color2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1139812487, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceSubtitle (PreferenceItems.kt:831)");
            }
            modifier4 = modifier3;
            contentPadding3 = contentPadding2;
            $composer2 = $composer3;
            TextKt.m2817Text4IGK_g(text, PaddingKt.padding(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), contentPadding2), color3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer2, (($dirty >> 6) & 14) | (($dirty >> 3) & 896), 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            color2 = color3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final PaddingValues paddingValues2 = contentPadding3;
            final long j = color2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt$PreferenceSubtitle$1
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
                    PreferenceItemsKt.m7312PreferenceSubtitleww6aTOc(modifier6, paddingValues2, text, j, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void PreferenceInfo(Modifier modifier, final String text, ImageVector icon, boolean applyPaddings, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ImageVector imageVector;
        boolean z;
        ImageVector icon2;
        int $dirty;
        Modifier modifier3;
        ImageVector icon3;
        boolean applyPaddings2;
        Composer $composer2;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-819726917);
        ComposerKt.sourceInformation($composer3, "C(PreferenceInfo)P(2,3,1)849@27476L455:PreferenceItems.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(text) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                imageVector = icon;
                int i3 = $composer3.changed(imageVector) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                imageVector = icon;
            }
            $dirty2 |= i3;
        } else {
            imageVector = icon;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            z = applyPaddings;
        } else if (($changed & 7168) == 0) {
            z = applyPaddings;
            $dirty2 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = applyPaddings;
        }
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            icon3 = imageVector;
            applyPaddings2 = z;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    icon2 = InfoKt.getInfo(Icons.Outlined.INSTANCE);
                    $dirty2 &= -897;
                } else {
                    icon2 = imageVector;
                }
                if (i4 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    icon3 = icon2;
                    applyPaddings2 = true;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    icon3 = icon2;
                    applyPaddings2 = z;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                icon3 = imageVector;
                applyPaddings2 = z;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819726917, $dirty, -1, "com.videshkarmakar.loop.ui.component.PreferenceInfo (PreferenceItems.kt:848)");
            }
            Modifier $this$PreferenceInfo_u24lambda_u2428 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
            Modifier modifier$iv = applyPaddings2 ? PaddingKt.m869paddingVpY3zN4($this$PreferenceInfo_u24lambda_u2428, C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(16)) : $this$PreferenceInfo_u24lambda_u2428;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1937616025, "C855@27662L104,861@27894L10,858@27775L150:PreferenceItems.kt#g7nzpb");
            IconKt.m2292Iconww6aTOc(icon3, (String) null, PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0L, $composer3, (($dirty >> 6) & 14) | 432, 8);
            $composer2 = $composer3;
            modifier4 = modifier3;
            TextKt.m2817Text4IGK_g(text, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, (($dirty >> 3) & 14) | 48, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            final Modifier modifier6 = modifier4;
            final ImageVector imageVector2 = icon3;
            final boolean z2 = applyPaddings2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceInfo.3
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
                    PreferenceItemsKt.PreferenceInfo(modifier6, text, imageVector2, z2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void PreferenceInfoPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1889061553);
        ComposerKt.sourceInformation($composer2, "C(PreferenceInfoPreview)869@28035L57,869@28013L80:PreferenceItems.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1889061553, $changed, -1, "com.videshkarmakar.loop.ui.component.PreferenceInfoPreview (PreferenceItems.kt:868)");
            }
            PreferenceInfo(null, StringResources_androidKt.stringResource(C3070R.string.custom_command_enabled_hint, $composer2, 0), null, false, $composer2, 0, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.PreferenceItemsKt.PreferenceInfoPreview.1
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
                    PreferenceItemsKt.PreferenceInfoPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
