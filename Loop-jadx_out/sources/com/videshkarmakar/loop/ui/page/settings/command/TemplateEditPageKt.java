package com.videshkarmakar.loop.ui.page.settings.command;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerDefaults;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.accompanist.flowlayout.FlowKt;
import com.google.accompanist.flowlayout.SizeMode;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.OptionShortcut;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.IconButtonsKt;
import com.videshkarmakar.loop.ui.component.TextFieldKt;
import com.videshkarmakar.loop.util.DatabaseUtil;
import com.videshkarmakar.loop.util.PreferenceUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TemplateEditPage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u008a\u0084\u0002"}, d2 = {"TemplateEditPage", "", "onDismissRequest", "Lkotlin/Function0;", "templateId", "", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/runtime/Composer;I)V", "app_debug", "templateText", "", "templateName", "isEditingShortcuts", "", "shortcuts", "", "Lcom/videshkarmakar/loop/database/objects/OptionShortcut;"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TemplateEditPageKt {
    public static final void TemplateEditPage(final Function0<Unit> onDismissRequest, final int templateId, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object next;
        final CommandTemplate commandTemplate;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Composer $composer2;
        Object value$iv4;
        CommandTemplate it;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(1937934856);
        ComposerKt.sourceInformation($composer3, "C(TemplateEditPage)67@3252L24,69@3321L22,*71@3415L16,74@3534L53,75@3612L49,76@3703L7,77@3780L7,78@3818L34,83@3989L1139,108@5130L4855,80@3858L6127,221@10032L30,221@10014L48:TemplateEditPage.kt#fk5gu5");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(templateId) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1937934856, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage (TemplateEditPage.kt:66)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(null, null, $composer3, TopAppBarDefaults.$stable << 6, 3);
            Iterator it2 = ((Iterable) SnapshotStateKt.collectAsState(PreferenceUtil.INSTANCE.getTemplateListStateFlow(), null, $composer3, 8, 1).getValue()).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    it = (CommandTemplate) next;
                }
            } while (!(it.getId() == templateId));
            CommandTemplate commandTemplate2 = (CommandTemplate) next;
            if (commandTemplate2 != null) {
                commandTemplate = commandTemplate2;
            } else {
                commandTemplate = new CommandTemplate(0, "", "");
            }
            $composer3.startReplaceGroup(-1365662704);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateEditPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(commandTemplate.getTemplate(), null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState templateText$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1365662626);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateEditPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(commandTemplate.getName(), null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState templateName$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.startReplaceGroup(-1365662420);
            ComposerKt.sourceInformation($composer3, "CC(remember):TemplateEditPage.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState isEditingShortcuts$delegate = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            ScaffoldKt.m2282ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null), ComposableLambdaKt.rememberComposableLambda(504554700, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt.TemplateEditPage.1
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
                    ComposerKt.sourceInformation($composer4, "C84@4021L249,89@4289L65,91@4366L705,84@4003L1115:TemplateEditPage.kt#fk5gu5");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(504554700, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous> (TemplateEditPage.kt:84)");
                        }
                        final int i = templateId;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(969559176, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt.TemplateEditPage.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C86@4072L77,87@4193L10,85@4039L217:TemplateEditPage.kt#fk5gu5");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(969559176, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous> (TemplateEditPage.kt:85)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(i <= 0 ? R.string.new_template : R.string.edit, $composer5, 0);
                                    TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getTitleMedium();
                                    TextKt.m2569Text4IGK_g(strStringResource, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, titleMedium.m6029copyp1EtxEg((16777213 & 1) != 0 ? titleMedium.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? titleMedium.spanStyle.getFontSize() : TextUnitKt.getSp(18), (16777213 & 4) != 0 ? titleMedium.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? titleMedium.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? titleMedium.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? titleMedium.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? titleMedium.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? titleMedium.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? titleMedium.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? titleMedium.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? titleMedium.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? titleMedium.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? titleMedium.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? titleMedium.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? titleMedium.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? titleMedium.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? titleMedium.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? titleMedium.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? titleMedium.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? titleMedium.platformStyle : null, (16777213 & 1048576) != 0 ? titleMedium.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? titleMedium.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? titleMedium.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? titleMedium.paragraphStyle.getTextMotion() : null), $composer5, 0, 0, 65534);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54);
                        final Function0<Unit> function0 = onDismissRequest;
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1575333958, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt.TemplateEditPage.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                Object value$iv5;
                                ComposerKt.sourceInformation($composer5, "C90@4318L22,90@4307L33:TemplateEditPage.kt#fk5gu5");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1575333958, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous> (TemplateEditPage.kt:90)");
                                }
                                $composer5.startReplaceGroup(-1853203486);
                                ComposerKt.sourceInformation($composer5, "CC(remember):TemplateEditPage.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function0);
                                final Function0<Unit> function1 = function0;
                                Object it$iv4 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$1$2$1$1
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
                                    $composer5.updateRememberedValue(value$iv5);
                                } else {
                                    value$iv5 = it$iv4;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv5, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54);
                        final MutableState<String> mutableState = templateName$delegate;
                        final CoroutineScope coroutineScope = scope;
                        final CommandTemplate commandTemplate3 = commandTemplate;
                        final Function0<Unit> function1 = onDismissRequest;
                        final MutableState<String> mutableState2 = templateText$delegate;
                        AppBarKt.m1675TopAppBarGHTll3U(composableLambdaRememberComposableLambda, null, composableLambdaRememberComposableLambda2, ComposableLambdaKt.rememberComposableLambda(-1597079171, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt.TemplateEditPage.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TopAppBar, Composer $composer5, int $changed3) {
                                Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                                ComposerKt.sourceInformation($composer5, "C92@4384L673:TemplateEditPage.kt#fk5gu5");
                                if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1597079171, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous> (TemplateEditPage.kt:92)");
                                }
                                Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(8), 0.0f, 11, null);
                                boolean z = TemplateEditPageKt.TemplateEditPage$lambda$5(mutableState).length() > 0;
                                final CoroutineScope coroutineScope2 = coroutineScope;
                                final CommandTemplate commandTemplate4 = commandTemplate3;
                                final Function0<Unit> function2 = function1;
                                final MutableState<String> mutableState3 = mutableState;
                                final MutableState<String> mutableState4 = mutableState2;
                                ButtonKt.TextButton(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt.TemplateEditPage.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$1$3$1$1, reason: invalid class name and collision with other inner class name */
                                    /* JADX INFO: compiled from: TemplateEditPage.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$1$3$1$1", f = "TemplateEditPage.kt", i = {}, l = {97, 98}, m = "invokeSuspend", n = {}, s = {})
                                    static final class C02131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ CommandTemplate $commandTemplate;
                                        final /* synthetic */ Function0<Unit> $onDismissRequest;
                                        final /* synthetic */ MutableState<String> $templateName$delegate;
                                        final /* synthetic */ MutableState<String> $templateText$delegate;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C02131(CommandTemplate commandTemplate, Function0<Unit> function0, MutableState<String> mutableState, MutableState<String> mutableState2, Continuation<? super C02131> continuation) {
                                            super(2, continuation);
                                            this.$commandTemplate = commandTemplate;
                                            this.$onDismissRequest = function0;
                                            this.$templateName$delegate = mutableState;
                                            this.$templateText$delegate = mutableState2;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C02131(this.$commandTemplate, this.$onDismissRequest, this.$templateName$delegate, this.$templateText$delegate, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C02131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object $result) {
                                            C02131 c02131;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    CommandTemplate $this$invokeSuspend_u24lambda_u240 = CommandTemplate.copy$default(this.$commandTemplate, 0, TemplateEditPageKt.TemplateEditPage$lambda$5(this.$templateName$delegate), TemplateEditPageKt.TemplateEditPage$lambda$2(this.$templateText$delegate), 1, null);
                                                    if ($this$invokeSuspend_u24lambda_u240.getId() == 0) {
                                                        DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                                                        this.label = 1;
                                                        if (databaseUtil.insertTemplate($this$invokeSuspend_u24lambda_u240, this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        c02131 = this;
                                                    } else {
                                                        DatabaseUtil databaseUtil2 = DatabaseUtil.INSTANCE;
                                                        this.label = 2;
                                                        if (databaseUtil2.updateTemplate($this$invokeSuspend_u24lambda_u240, this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        c02131 = this;
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    c02131.$onDismissRequest.invoke();
                                                    return Unit.INSTANCE;
                                                case 1:
                                                    c02131 = this;
                                                    ResultKt.throwOnFailure($result);
                                                    c02131.$onDismissRequest.invoke();
                                                    return Unit.INSTANCE;
                                                case 2:
                                                    c02131 = this;
                                                    ResultKt.throwOnFailure($result);
                                                    Unit unit2 = Unit.INSTANCE;
                                                    c02131.$onDismissRequest.invoke();
                                                    return Unit.INSTANCE;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C02131(commandTemplate4, function2, mutableState3, mutableState4, null), 3, null);
                                    }
                                }, modifierM624paddingqDBjuR0$default, z, null, null, null, null, null, null, ComposableSingletons$TemplateEditPageKt.INSTANCE.m7320getLambda1$app_debug(), $composer5, 805306416, 504);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), 0.0f, null, null, scrollBehavior, $composer4, 3462, 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-46834665, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt.TemplateEditPage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
                    invoke(paddingValues, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddings, Composer $composer4, int $changed2) {
                    Object value$iv5;
                    Intrinsics.checkNotNullParameter(paddings, "paddings");
                    ComposerKt.sourceInformation($composer4, "C111@5258L4721,109@5152L4827:TemplateEditPage.kt#fk5gu5");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(paddings) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-46834665, $dirty4, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous> (TemplateEditPage.kt:109)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddings);
                        PaddingValues paddingValuesM615PaddingValuesYgX7TsA$default = PaddingKt.m615PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null);
                        $composer4.startReplaceGroup(-1918412307);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TemplateEditPage.kt#9igjgp");
                        final MutableState<String> mutableState = templateName$delegate;
                        final MutableState<String> mutableState2 = templateText$delegate;
                        final MutableState<Boolean> mutableState3 = isEditingShortcuts$delegate;
                        Object it$iv4 = $composer4.rememberedValue();
                        if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1
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
                                    final MutableState<String> mutableState4 = mutableState;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(58286851, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1.1
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
                                            Function0<ComposeUiNode> function0;
                                            Object value$iv6;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C114@5314L39,116@5371L725:TemplateEditPage.kt#fk5gu5");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(58286851, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TemplateEditPage.kt:114)");
                                                }
                                                String description = StringResources_androidKt.stringResource(R.string.template_label, $composer5, 0);
                                                Modifier modifier$iv = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(24), 0.0f, 2, null);
                                                final MutableState<String> mutableState5 = mutableState4;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                                int $changed$iv$iv = (6 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer5.startReusableNode();
                                                if ($composer5.getInserting()) {
                                                    function0 = constructor;
                                                    $composer5.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer5.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                int i2 = ((6 >> 6) & 112) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2034890789, "C117@5438L174,127@5880L21,122@5633L445:TemplateEditPage.kt#fk5gu5");
                                                TextFieldKt.AdjacentLabel(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 0.0f, 0.0f, 13, null), description, $composer5, 6, 0);
                                                Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(24), 7, null);
                                                String strTemplateEditPage$lambda$5 = TemplateEditPageKt.TemplateEditPage$lambda$5(mutableState5);
                                                KeyboardActions keyboardActions = KeyboardActions.INSTANCE.getDefault();
                                                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6187getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                                                $composer5.startReplaceGroup(2034891231);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):TemplateEditPage.kt#9igjgp");
                                                Object it$iv5 = $composer5.rememberedValue();
                                                if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv6 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$1$1$1$1
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
                                                        public final void invoke2(String it3) {
                                                            Intrinsics.checkNotNullParameter(it3, "it");
                                                            mutableState5.setValue(it3);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv6);
                                                } else {
                                                    value$iv6 = it$iv5;
                                                }
                                                $composer5.endReplaceGroup();
                                                OutlinedTextFieldKt.OutlinedTextField(strTemplateEditPage$lambda$5, (Function1<? super String, Unit>) value$iv6, modifierM624paddingqDBjuR0$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, keyboardActions, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer5, 432, 1769472, 0, 8290296);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                $composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableState<String> mutableState5 = mutableState2;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(189517804, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1.2
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
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C135@6147L1650:TemplateEditPage.kt#fk5gu5");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(189517804, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TemplateEditPage.kt:135)");
                                                }
                                                Modifier modifier$iv = PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(24), 0.0f, 2, null);
                                                final MutableState<String> mutableState6 = mutableState5;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                                int $changed$iv$iv = (6 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer5.startReusableNode();
                                                if ($composer5.getInserting()) {
                                                    function0 = constructor;
                                                    $composer5.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer5.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                int i2 = ((6 >> 6) & 112) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2034891565, "C136@6232L48,137@6301L124,141@6486L7,141@6536L792,141@6446L882,157@7349L57,164@7731L11,158@7427L352:TemplateEditPage.kt#fk5gu5");
                                                String description = StringResources_androidKt.stringResource(R.string.custom_command_template, $composer5, 0);
                                                TextFieldKt.AdjacentLabel(Modifier.INSTANCE, description, $composer5, 6, 0);
                                                ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = $composer5.consume(localTextStyle);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                TextKt.ProvideTextStyle(((TextStyle) objConsume3).m6048mergedA7vx0o((16609105 & 1) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : 0L, (16609105 & 2) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 4) != 0 ? null : null, (16609105 & 8) != 0 ? null : null, (16609105 & 16) != 0 ? null : null, (16609105 & 32) != 0 ? null : FontFamily.INSTANCE.getMonospace(), (16609105 & 64) != 0 ? null : null, (16609105 & 128) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 256) != 0 ? null : null, (16609105 & 512) != 0 ? null : null, (16609105 & 1024) != 0 ? null : null, (16609105 & 2048) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : 0L, (16609105 & 4096) != 0 ? null : null, (16609105 & 8192) != 0 ? null : null, (16609105 & 16384) != 0 ? null : null, (16609105 & 32768) != 0 ? TextAlign.INSTANCE.m6416getUnspecifiede0LSkKk() : 0, (16609105 & 65536) != 0 ? TextDirection.INSTANCE.m6429getUnspecifieds_7Xco() : 0, (16609105 & 131072) != 0 ? TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE() : 0L, (16609105 & 262144) != 0 ? null : null, (16609105 & 524288) != 0 ? null : null, (16609105 & 1048576) != 0 ? LineBreak.INSTANCE.m6343getUnspecifiedrAG3T2k() : 0, (16609105 & 2097152) != 0 ? Hyphens.INSTANCE.m6322getUnspecifiedvmbZdU8() : 0, (16609105 & 4194304) != 0 ? null : null, (16609105 & 8388608) != 0 ? null : null), ComposableLambdaKt.rememberComposableLambda(-63328475, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$2$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                        invoke(composer, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer $composer6, int $changed4) {
                                                        Object value$iv6;
                                                        ComposerKt.sourceInformation($composer6, "C146@6851L21,147@6917L277,142@6562L744:TemplateEditPage.kt#fk5gu5");
                                                        if (($changed4 & 11) != 2 || !$composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-63328475, $changed4, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TemplateEditPage.kt:142)");
                                                            }
                                                            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                            String strTemplateEditPage$lambda$2 = TemplateEditPageKt.TemplateEditPage$lambda$2(mutableState6);
                                                            $composer6.startReplaceGroup(1891163467);
                                                            ComposerKt.sourceInformation($composer6, "CC(remember):TemplateEditPage.kt#9igjgp");
                                                            final MutableState<String> mutableState7 = mutableState6;
                                                            Object it$iv5 = $composer6.rememberedValue();
                                                            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                                                                value$iv6 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$2$1$1$1$1
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
                                                                    public final void invoke2(String it3) {
                                                                        Intrinsics.checkNotNullParameter(it3, "it");
                                                                        mutableState7.setValue(it3);
                                                                    }
                                                                };
                                                                $composer6.updateRememberedValue(value$iv6);
                                                            } else {
                                                                value$iv6 = it$iv5;
                                                            }
                                                            $composer6.endReplaceGroup();
                                                            final MutableState<String> mutableState8 = mutableState6;
                                                            OutlinedTextFieldKt.OutlinedTextField(strTemplateEditPage$lambda$2, (Function1<? super String, Unit>) value$iv6, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1001718642, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$2$1$1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                                    invoke(composer, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer $composer7, int $changed5) {
                                                                    Object value$iv7;
                                                                    Object value$iv8;
                                                                    ComposerKt.sourceInformation($composer7, "C:TemplateEditPage.kt#fk5gu5");
                                                                    if (($changed5 & 11) == 2 && $composer7.getSkipping()) {
                                                                        $composer7.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1001718642, $changed5, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TemplateEditPage.kt:148)");
                                                                    }
                                                                    if (TemplateEditPageKt.TemplateEditPage$lambda$2(mutableState8).length() == 0) {
                                                                        $composer7.startReplaceGroup(-700951572);
                                                                        ComposerKt.sourceInformation($composer7, "148@7004L89,148@6979L114");
                                                                        $composer7.startReplaceGroup(-700951547);
                                                                        ComposerKt.sourceInformation($composer7, "CC(remember):TemplateEditPage.kt#9igjgp");
                                                                        final MutableState<String> mutableState9 = mutableState8;
                                                                        Object it$iv6 = $composer7.rememberedValue();
                                                                        if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                                                                            value$iv8 = new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$2$1$1$2$1$1
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
                                                                                public final void invoke2(String it3) {
                                                                                    Intrinsics.checkNotNullParameter(it3, "it");
                                                                                    mutableState9.setValue(it3);
                                                                                }
                                                                            };
                                                                            $composer7.updateRememberedValue(value$iv8);
                                                                        } else {
                                                                            value$iv8 = it$iv6;
                                                                        }
                                                                        $composer7.endReplaceGroup();
                                                                        IconButtonsKt.PasteFromClipBoardButton((Function1) value$iv8, $composer7, 6, 0);
                                                                        $composer7.endReplaceGroup();
                                                                    } else {
                                                                        $composer7.startReplaceGroup(-700951420);
                                                                        ComposerKt.sourceInformation($composer7, "151@7143L21,151@7131L33");
                                                                        $composer7.startReplaceGroup(-700951408);
                                                                        ComposerKt.sourceInformation($composer7, "CC(remember):TemplateEditPage.kt#9igjgp");
                                                                        final MutableState<String> mutableState10 = mutableState8;
                                                                        Object it$iv7 = $composer7.rememberedValue();
                                                                        if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                                                                            value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$2$1$1$2$2$1
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
                                                                                    mutableState10.setValue("");
                                                                                }
                                                                            };
                                                                            $composer7.updateRememberedValue(value$iv7);
                                                                        } else {
                                                                            value$iv7 = it$iv7;
                                                                        }
                                                                        $composer7.endReplaceGroup();
                                                                        IconButtonsKt.ClearButton((Function0) value$iv7, $composer7, 6);
                                                                        $composer7.endReplaceGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, $composer6, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$TemplateEditPageKt.INSTANCE.m7321getLambda2$app_debug(), false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 12, 6, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer6, 805306800, 905970048, 0, 7597560);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        $composer6.skipToGroupEnd();
                                                    }
                                                }, $composer5, 54), $composer5, 48);
                                                ButtonsKt.LinkButton(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(12), 1, null), null, null, null, $composer5, 6, 14);
                                                DividerKt.m1975HorizontalDivider9IZ8Weo(ClipKt.clip(SizeKt.m665size3ABfNKs(PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6553constructorimpl(24), 7, null), DividerDefaults.INSTANCE.m1973getThicknessD9Ej5fM()), RoundedCornerShapeKt.getCircleShape()), 0.0f, MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOutlineVariant(), $composer5, 0, 2);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                $composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    final MutableState<Boolean> mutableState6 = mutableState3;
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1467590453, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1.3
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
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation($composer5, "C170@7848L957:TemplateEditPage.kt#fk5gu5");
                                            if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1467590453, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TemplateEditPage.kt:170)");
                                                }
                                                Modifier modifier$iv = PaddingKt.m624paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(24), 0.0f, Dp.m6553constructorimpl(16), 0.0f, 10, null);
                                                final MutableState<Boolean> mutableState7 = mutableState6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                                int $changed$iv$iv = (6 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer5.startReusableNode();
                                                if ($composer5.getInserting()) {
                                                    function0 = constructor;
                                                    $composer5.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer5.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer5);
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                                int i2 = ((6 >> 6) & 112) | 6;
                                                RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2034893385, "C176@8071L34,180@8301L10,181@8370L11,175@8034L378,187@8646L44,188@8745L11,185@8532L29,183@8433L354:TemplateEditPage.kt#fk5gu5");
                                                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.shortcuts, $composer5, 0), $this$invoke_u24lambda_u241.align(RowScope.CC.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null), Alignment.INSTANCE.getCenterVertically()), MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getTertiary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getLabelLarge(), $composer5, 0, 0, 65528);
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                ImageVector edit = EditKt.getEdit(Icons.Outlined.INSTANCE);
                                                String strStringResource = StringResources_androidKt.stringResource(R.string.edit_shortcuts, $composer5, 0);
                                                long tertiary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getTertiary();
                                                Modifier.Companion companion2 = companion;
                                                $composer5.startReplaceGroup(2034893883);
                                                ComposerKt.sourceInformation($composer5, "CC(remember):TemplateEditPage.kt#9igjgp");
                                                Object value$iv6 = $composer5.rememberedValue();
                                                if (value$iv6 == Composer.INSTANCE.getEmpty()) {
                                                    value$iv6 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$3$1$1$1
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
                                                            TemplateEditPageKt.TemplateEditPage$lambda$9(mutableState7, true);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv6);
                                                }
                                                $composer5.endReplaceGroup();
                                                ButtonsKt.m7104TextButtonWithIconuDo3WH8(companion2, edit, strStringResource, tertiary, (Function0) value$iv6, $composer5, 24582, 0);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                $composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), 3, null);
                                    LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1170268586, true, new AnonymousClass4(mutableState2)), 3, null);
                                }

                                /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$4, reason: invalid class name */
                                /* JADX INFO: compiled from: TemplateEditPage.kt */
                                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                static final class AnonymousClass4 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
                                    final /* synthetic */ MutableState<String> $templateText$delegate;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass4(MutableState<String> mutableState) {
                                        super(3);
                                        this.$templateText$delegate = mutableState;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                        invoke(lazyItemScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final List<OptionShortcut> invoke$lambda$0(State<? extends List<OptionShortcut>> state) {
                                        Object thisObj$iv = state.getValue();
                                        return (List) thisObj$iv;
                                    }

                                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation($composer, "C193@8900L27,197@9080L21,194@8944L1011:TemplateEditPage.kt#fk5gu5");
                                        int $dirty = $changed;
                                        if (($changed & 14) == 0) {
                                            $dirty |= $composer.changed(item) ? 4 : 2;
                                        }
                                        int $dirty2 = $dirty;
                                        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1170268586, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TemplateEditPage.kt:193)");
                                            }
                                            final State shortcuts$delegate = SnapshotStateKt.collectAsState(DatabaseUtil.INSTANCE.getShortcuts(), CollectionsKt.emptyList(), null, $composer, 56, 2);
                                            Modifier modifier$iv = ScrollKt.horizontalScroll$default(LazyItemScope.CC.fillParentMaxWidth$default(item, Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, null, false, 14, null);
                                            final MutableState<String> mutableState = this.$templateText$delegate;
                                            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                            if (!($composer.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer.startReusableNode();
                                            if ($composer.getInserting()) {
                                                function0 = constructor;
                                                $composer.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer);
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                            int i = ($changed$iv$iv$iv >> 6) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            int i2 = ((0 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer, 2034894494, "C205@9423L513,199@9143L793:TemplateEditPage.kt#fk5gu5");
                                            FlowKt.m6941FlowRow07r0xoM(SizeKt.m670width3ABfNKs(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), 0.0f, 2, null), Dp.m6553constructorimpl(500)), SizeMode.Expand, null, 0.0f, null, Dp.m6553constructorimpl(2), null, ComposableLambdaKt.rememberComposableLambda(986056122, true, 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01d1: INVOKE 
                                                  (wrap androidx.compose.ui.Modifier:0x01a2: INVOKE 
                                                  (wrap androidx.compose.ui.Modifier:0x0196: INVOKE 
                                                  (wrap androidx.compose.ui.Modifier$Companion:0x0182: SGET  A[WRAPPED] (LINE:201) androidx.compose.ui.Modifier.Companion androidx.compose.ui.Modifier$Companion)
                                                  (wrap float:0x018d: INVOKE (8 int) STATIC call: androidx.compose.ui.unit.Dp.constructor-impl(float):float A[MD:(float):float (m), WRAPPED] (LINE:202))
                                                  (0.0f float)
                                                  (2 int)
                                                  (null java.lang.Object)
                                                 STATIC call: androidx.compose.foundation.layout.PaddingKt.padding-VpY3zN4$default(androidx.compose.ui.Modifier, float, float, int, java.lang.Object):androidx.compose.ui.Modifier A[MD:(androidx.compose.ui.Modifier, float, float, int, java.lang.Object):androidx.compose.ui.Modifier (m), WRAPPED] (LINE:202))
                                                  (wrap float:0x019e: INVOKE (500 int) STATIC call: androidx.compose.ui.unit.Dp.constructor-impl(float):float A[MD:(float):float (m), WRAPPED] (LINE:265))
                                                 STATIC call: androidx.compose.foundation.layout.SizeKt.width-3ABfNKs(androidx.compose.ui.Modifier, float):androidx.compose.ui.Modifier A[MD:(androidx.compose.ui.Modifier, float):androidx.compose.ui.Modifier (m), WRAPPED] (LINE:203))
                                                  (wrap com.google.accompanist.flowlayout.SizeMode:0x01a6: SGET  A[WRAPPED] (LINE:204) com.google.accompanist.flowlayout.SizeMode.Expand com.google.accompanist.flowlayout.SizeMode)
                                                  (null com.google.accompanist.flowlayout.MainAxisAlignment)
                                                  (0.0f float)
                                                  (null com.google.accompanist.flowlayout.FlowCrossAxisAlignment)
                                                  (wrap float:0x01ab: INVOKE (2 int) STATIC call: androidx.compose.ui.unit.Dp.constructor-impl(float):float A[MD:(float):float (m), WRAPPED] (LINE:266))
                                                  (null com.google.accompanist.flowlayout.MainAxisAlignment)
                                                  (wrap androidx.compose.runtime.internal.ComposableLambda:0x01ba: INVOKE 
                                                  (986056122 int)
                                                  true
                                                  (wrap kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>:0x01b1: CONSTRUCTOR 
                                                  (r1v8 'shortcuts$delegate' androidx.compose.runtime.State A[D('shortcuts$delegate' androidx.compose.runtime.State), DONT_INLINE])
                                                  (r11v1 'mutableState' androidx.compose.runtime.MutableState<java.lang.String> A[DONT_INLINE])
                                                 A[MD:(androidx.compose.runtime.State<? extends java.util.List<com.videshkarmakar.loop.database.objects.OptionShortcut>>, androidx.compose.runtime.MutableState<java.lang.String>):void (m), WRAPPED] (LINE:206) call: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$4$1$1.<init>(androidx.compose.runtime.State, androidx.compose.runtime.MutableState):void type: CONSTRUCTOR)
                                                  (r44v0 '$composer' androidx.compose.runtime.Composer A[D('$composer' androidx.compose.runtime.Composer)])
                                                  (54 int)
                                                 STATIC call: androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(int, boolean, java.lang.Object, androidx.compose.runtime.Composer, int):androidx.compose.runtime.internal.ComposableLambda A[MD:(int, boolean, java.lang.Object, androidx.compose.runtime.Composer, int):androidx.compose.runtime.internal.ComposableLambda (m), WRAPPED] (LINE:206))
                                                  (r44v0 '$composer' androidx.compose.runtime.Composer A[D('$composer' androidx.compose.runtime.Composer)])
                                                  (12779574 int)
                                                  (92 int)
                                                 STATIC call: com.google.accompanist.flowlayout.FlowKt.FlowRow-07r0xoM(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void A[MD:(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, int, int):void (m)] (LINE:200) in method: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1.4.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void, file: classes13.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1$4$1$1, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	... 23 more
                                                */
                                            /*
                                                Method dump skipped, instruction units count: 501
                                                To view this dump add '--comments-level debug' option
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$2$1$1.AnonymousClass4.invoke(androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):void");
                                        }
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv4;
                            }
                            $composer4.endReplaceGroup();
                            LazyDslKt.LazyColumn(modifierPadding, null, paddingValuesM615PaddingValuesYgX7TsA$default, false, null, null, null, false, (Function1) value$iv5, $composer4, 100663680, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, 805306416, 508);
                if (TemplateEditPage$lambda$8(isEditingShortcuts$delegate)) {
                    $composer2.startReplaceGroup(-1365656206);
                    ComposerKt.sourceInformation($composer2, "CC(remember):TemplateEditPage.kt#9igjgp");
                    Object it$iv4 = $composer2.rememberedValue();
                    if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt$TemplateEditPage$3$1
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
                                TemplateEditPageKt.TemplateEditPage$lambda$9(isEditingShortcuts$delegate, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    $composer2.endReplaceGroup();
                    CommandTemplateDialogKt.OptionChipsDialog((Function0) value$iv4, $composer2, 6, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                $composer2 = $composer3;
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.TemplateEditPageKt.TemplateEditPage.4
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
                        TemplateEditPageKt.TemplateEditPage(onDismissRequest, templateId, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String TemplateEditPage$lambda$2(MutableState<String> mutableState) {
            MutableState<String> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String TemplateEditPage$lambda$5(MutableState<String> mutableState) {
            MutableState<String> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue();
        }

        private static final boolean TemplateEditPage$lambda$8(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void TemplateEditPage$lambda$9(MutableState<Boolean> mutableState, boolean value) {
            mutableState.setValue(Boolean.valueOf(value));
        }
    }
