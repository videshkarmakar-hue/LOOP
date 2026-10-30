package com.videshkarmakar.loop.p006ui.page.settings.general;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.focus.FocusManager;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.SoftwareKeyboardController;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.ImeAction;
import androidx.compose.p001ui.text.input.PlatformImeOptions;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.caverock.androidsvg.SVGParser;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.p006ui.component.ChipsKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AdvancedSettingDialogs.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0007¢\u0006\u0002\u0010\u000b\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u0002X\u008a\u008e\u0002"}, m195d2 = {"sponsorBlockCategories", "", "", "getSponsorBlockCategories", "()Ljava/util/List;", "sponsorBlockReference", "ytdlpReference", "SponsorBlockDialog", "", "onDismissRequest", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "categories"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AdvancedSettingDialogsKt {
    private static final List<String> sponsorBlockCategories = CollectionsKt.listOf((Object[]) new String[]{"sponsor", "intro", "outro", "selfpromo", "preview", "filler", Route.INTERACTION, "music_offtopic"});
    public static final String sponsorBlockReference = "https://github.com/yt-dlp/yt-dlp#sponsorblock-options";
    public static final String ytdlpReference = "https://github.com/yt-dlp/yt-dlp#usage-and-options";

    public static final List<String> getSponsorBlockCategories() {
        return sponsorBlockCategories;
    }

    public static final void SponsorBlockDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(529071548);
        ComposerKt.sourceInformation($composer3, "C(SponsorBlockDialog)53@2187L83,56@2312L7,57@2389L7,103@4236L149,99@4146L72,61@2575L1553,59@2402L1984:AdvancedSettingDialogs.kt#wlpkv4");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(529071548, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.general.SponsorBlockDialog (AdvancedSettingDialogs.kt:52)");
            }
            $composer3.startReplaceGroup(1784815938);
            ComposerKt.sourceInformation($composer3, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.INSTANCE.getSponsorBlockCategories(), null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState categories$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-452586892, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt.SponsorBlockDialog.1
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
                    ComposerKt.sourceInformation($composer4, "C104@4260L119,104@4246L133:AdvancedSettingDialogs.kt#wlpkv4");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-452586892, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.SponsorBlockDialog.<anonymous> (AdvancedSettingDialogs.kt:104)");
                    }
                    $composer4.startReplaceGroup(1755238652);
                    ComposerKt.sourceInformation($composer4, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    final MutableState<String> mutableState = categories$delegate;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$1$1$1
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
                                PreferenceUtil.INSTANCE.encodeString(PreferenceUtilKt.SPONSORBLOCK_CATEGORIES, AdvancedSettingDialogsKt.SponsorBlockDialog$lambda$1(mutableState));
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
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-41976526, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt.SponsorBlockDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C100@4170L42,100@4156L56:AdvancedSettingDialogs.kt#wlpkv4");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-41976526, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.SponsorBlockDialog.<anonymous> (AdvancedSettingDialogs.kt:100)");
                    }
                    $composer4.startReplaceGroup(1755238562);
                    ComposerKt.sourceInformation($composer4, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$2$1$1
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
            }, $composer3, 54), ComposableSingletons$AdvancedSettingDialogsKt.INSTANCE.m7548getLambda1$app_debug(), ComposableSingletons$AdvancedSettingDialogsKt.INSTANCE.m7549getLambda2$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1573544625, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt.SponsorBlockDialog.3
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
                    Function0<ComposeUiNode> function0;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C62@2585L1537:AdvancedSettingDialogs.kt#wlpkv4");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1573544625, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.general.SponsorBlockDialog.<anonymous> (AdvancedSettingDialogs.kt:62)");
                    }
                    final MutableState<String> mutableState = categories$delegate;
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
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
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i2 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1719666855, "C64@2628L53,65@2721L10,63@2606L149,73@3070L19,67@2768L415,76@3256L803,76@3196L863,97@4072L40:AdvancedSettingDialogs.kt#wlpkv4");
                    TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.sponsorblock_categories_desc, $composer4, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 0, 0, 65534);
                    Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, C1979Dp.m6801constructorimpl(12), 5, null);
                    String strSponsorBlockDialog$lambda$1 = AdvancedSettingDialogsKt.SponsorBlockDialog$lambda$1(mutableState);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    $composer4.startReplaceGroup(1719667319);
                    ComposerKt.sourceInformation($composer4, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
                    Object value$iv3 = $composer4.rememberedValue();
                    if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$1$1
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
                        $composer4.updateRememberedValue(value$iv3);
                    }
                    $composer4.endReplaceGroup();
                    OutlinedTextFieldKt.OutlinedTextField(strSponsorBlockDialog$lambda$1, (Function1<? super String, Unit>) value$iv3, modifierM872paddingqDBjuR0$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AdvancedSettingDialogsKt.INSTANCE.m7550getLambda3$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1573296, ProfileVerifier.CompilationStatus.f245xf2722a21, 0, 8355768);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_4 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8));
                    $composer4.startReplaceGroup(1719667505);
                    ComposerKt.sourceInformation($composer4, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
                    Object it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$2$1
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
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                final MutableState<String> mutableState2 = mutableState;
                                LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(304444987, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$2$1.1
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
                                        Object value$iv4;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C78@3339L70,78@3301L108:AdvancedSettingDialogs.kt#wlpkv4");
                                        if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(304444987, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.general.SponsorBlockDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdvancedSettingDialogs.kt:78)");
                                        }
                                        $composer5.startReplaceGroup(206949607);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
                                        final MutableState<String> mutableState3 = mutableState2;
                                        Object it$iv3 = $composer5.rememberedValue();
                                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$2$1$1$1$1
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
                                                    mutableState3.setValue("default");
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv4);
                                        } else {
                                            value$iv4 = it$iv3;
                                        }
                                        $composer5.endReplaceGroup();
                                        ChipsKt.OutlinedButtonChip(null, null, "default", null, (Function0) value$iv4, $composer5, 24960, 11);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 3, null);
                                final MutableState<String> mutableState3 = mutableState;
                                LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1085501874, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$2$1.2
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
                                        Object value$iv4;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer5, "C83@3505L66,83@3471L100:AdvancedSettingDialogs.kt#wlpkv4");
                                        if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                            $composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1085501874, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.general.SponsorBlockDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdvancedSettingDialogs.kt:83)");
                                        }
                                        $composer5.startReplaceGroup(206949773);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
                                        final MutableState<String> mutableState4 = mutableState3;
                                        Object it$iv3 = $composer5.rememberedValue();
                                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$2$1$2$1$1
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
                                                    mutableState4.setValue(SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL);
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv4);
                                        } else {
                                            value$iv4 = it$iv3;
                                        }
                                        $composer5.endReplaceGroup();
                                        ChipsKt.OutlinedButtonChip(null, null, SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, null, (Function0) value$iv4, $composer5, 24960, 11);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 3, null);
                                Iterable $this$forEach$iv = AdvancedSettingDialogsKt.getSponsorBlockCategories();
                                final MutableState<String> mutableState4 = mutableState;
                                for (Object element$iv : $this$forEach$iv) {
                                    final String it = (String) element$iv;
                                    if (!StringsKt.contains$default((CharSequence) AdvancedSettingDialogsKt.SponsorBlockDialog$lambda$1(mutableState4), (CharSequence) it, false, 2, (Object) null)) {
                                        LazyListScope.CC.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(878967214, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$2$1$3$1
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
                                                Object value$iv4;
                                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                                ComposerKt.sourceInformation($composer5, "C89@3751L254,89@3720L285:AdvancedSettingDialogs.kt#wlpkv4");
                                                if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                                    $composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(878967214, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.general.SponsorBlockDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdvancedSettingDialogs.kt:89)");
                                                }
                                                String str = it;
                                                $composer5.startReplaceGroup(-1472207196);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):AdvancedSettingDialogs.kt#9igjgp");
                                                boolean invalid$iv = $composer5.changed(it);
                                                final String str2 = it;
                                                final MutableState<String> mutableState5 = mutableState4;
                                                Object it$iv3 = $composer5.rememberedValue();
                                                if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt$SponsorBlockDialog$3$1$2$1$3$1$1$1
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
                                                            mutableState5.setValue(new Regex("(all)|(default)").replace(AdvancedSettingDialogsKt.SponsorBlockDialog$lambda$1(mutableState5), ""));
                                                            mutableState5.setValue(AdvancedSettingDialogsKt.SponsorBlockDialog$lambda$1(mutableState5) + "," + str2);
                                                            mutableState5.setValue(StringsKt.removePrefix(AdvancedSettingDialogsKt.SponsorBlockDialog$lambda$1(mutableState5), (CharSequence) ","));
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv4);
                                                } else {
                                                    value$iv4 = it$iv3;
                                                }
                                                $composer5.endReplaceGroup();
                                                ChipsKt.OutlinedButtonChip(null, null, str, null, (Function0) value$iv4, $composer5, 0, 11);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), 3, null);
                                    }
                                }
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    LazyDslKt.LazyRow(null, null, null, false, horizontalOrVerticalM744spacedBy0680j_4, null, null, false, (Function1) value$iv2, $composer4, 100687872, 239);
                    ButtonsKt.LinkButton(null, null, null, AdvancedSettingDialogsKt.sponsorBlockReference, $composer4, 3072, 7);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.AdvancedSettingDialogsKt.SponsorBlockDialog.4
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
                    AdvancedSettingDialogsKt.SponsorBlockDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SponsorBlockDialog$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
