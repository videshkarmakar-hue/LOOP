package com.videshkarmakar.loop.p006ui.page.settings.network;

import android.text.TextUtils;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderState;
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
import androidx.compose.p001ui.unit.DpKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.ButtonsKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.videshkarmakar.loop.util.TextUtilKt;
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
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: NetworkSettingDialogs.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\fX\u008a\u008e\u0002"}, m195d2 = {"ConcurrentDownloadDialog", "", "onDismissRequest", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ProxyConfigurationDialog", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "RateLimitDialog", "app_debug", "isError", "", "maxRate", "", "concurrentFragments", "", "count", "", "proxyUrl"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NetworkSettingDialogsKt {
    public static final void RateLimitDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(-979315266);
        ComposerKt.sourceInformation($composer3, "C(RateLimitDialog)53@2501L34,54@2555L76,57@2673L7,58@2750L7,92@4174L261,88@4084L72,61@2930L1136,59@2762L1674:NetworkSettingDialogs.kt#sffru");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-979315266, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.network.RateLimitDialog (NetworkSettingDialogs.kt:52)");
            }
            $composer3.startReplaceGroup(-884189974);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState isError$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-884189920);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.INSTANCE.getMaxDownloadRate(), null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState maxRate$delegate = (MutableState) value$iv2;
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
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.rememberComposableLambda(1989478006, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.RateLimitDialog.1
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
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer4, "C93@4198L231,93@4184L245:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1989478006, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.RateLimitDialog.<anonymous> (NetworkSettingDialogs.kt:93)");
                    }
                    $composer4.startReplaceGroup(-837104084);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    final MutableState<String> mutableState = maxRate$delegate;
                    final MutableState<Boolean> mutableState2 = isError$delegate;
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$RateLimitDialog$1$1$1
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
                                if (TextUtilKt.isNumberInRange(NetworkSettingDialogsKt.RateLimitDialog$lambda$4(mutableState), 1, DurationKt.NANOS_IN_MILLIS)) {
                                    PreferenceUtil.INSTANCE.encodeString(PreferenceUtilKt.MAX_RATE, NetworkSettingDialogsKt.RateLimitDialog$lambda$4(mutableState));
                                    function0.invoke();
                                } else {
                                    NetworkSettingDialogsKt.RateLimitDialog$lambda$2(mutableState2, true);
                                }
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.ConfirmButton(null, false, (Function0) value$iv3, $composer4, 0, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-1887600588, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.RateLimitDialog.2
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
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer4, "C89@4108L42,89@4094L56:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1887600588, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.RateLimitDialog.<anonymous> (NetworkSettingDialogs.kt:89)");
                    }
                    $composer4.startReplaceGroup(-837104174);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$RateLimitDialog$2$1$1
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
                        $composer4.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer4.endReplaceGroup();
                    ButtonsKt.DismissButton(null, (Function0) value$iv3, $composer4, 0, 1);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7596getLambda1$app_debug(), ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7599getLambda2$app_debug(), ComposableLambdaKt.rememberComposableLambda(886716113, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.RateLimitDialog.3
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
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer4, "C62@2940L1120:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(886716113, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.RateLimitDialog.<anonymous> (NetworkSettingDialogs.kt:62)");
                    }
                    final MutableState<Boolean> mutableState = isError$delegate;
                    final MutableState<String> mutableState2 = maxRate$delegate;
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
                    ComposerKt.sourceInformationMarkerStart($composer4, 1697993336, "C64@2983L40,65@3063L10,63@2961L136,81@3816L111,72@3328L352,67@3110L940:NetworkSettingDialogs.kt#sffru");
                    TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.rate_limit_desc, $composer4, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 0, 0, 65534);
                    Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, C1979Dp.m6801constructorimpl(12), 5, null);
                    boolean zRateLimitDialog$lambda$1 = NetworkSettingDialogsKt.RateLimitDialog$lambda$1(mutableState);
                    String strRateLimitDialog$lambda$4 = NetworkSettingDialogsKt.RateLimitDialog$lambda$4(mutableState2);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    $composer4.startReplaceGroup(1697994191);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    Object it$iv3 = $composer4.rememberedValue();
                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$RateLimitDialog$3$1$1$1
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
                                String $this$isDigitsOnly$iv = it;
                                if (TextUtils.isDigitsOnly($this$isDigitsOnly$iv)) {
                                    mutableState2.setValue(it);
                                }
                                NetworkSettingDialogsKt.RateLimitDialog$lambda$2(mutableState, false);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer4.endReplaceGroup();
                    OutlinedTextFieldKt.OutlinedTextField(strRateLimitDialog$lambda$4, (Function1<? super String, Unit>) value$iv3, modifierM872paddingqDBjuR0$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7600getLambda3$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7601getLambda4$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-942674604, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$RateLimitDialog$3$1$2
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
                            long onSurfaceVariant;
                            ComposerKt.sourceInformation($composer5, "C75@3494L10,73@3350L312:NetworkSettingDialogs.kt#sffru");
                            if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-942674604, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.RateLimitDialog.<anonymous>.<anonymous>.<anonymous> (NetworkSettingDialogs.kt:73)");
                                }
                                $composer5.startReplaceGroup(44970947);
                                ComposerKt.sourceInformation($composer5, "74@3400L38");
                                String strStringResource = NetworkSettingDialogsKt.RateLimitDialog$lambda$1(mutableState) ? StringResources_androidKt.stringResource(C3070R.string.invalid_input, $composer5, 0) : "";
                                $composer5.endReplaceGroup();
                                TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodySmall();
                                if (NetworkSettingDialogsKt.RateLimitDialog$lambda$1(mutableState)) {
                                    $composer5.startReplaceGroup(44971147);
                                    ComposerKt.sourceInformation($composer5, "76@3575L11");
                                    onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getError();
                                } else {
                                    $composer5.startReplaceGroup(44971184);
                                    ComposerKt.sourceInformation($composer5, "76@3612L11");
                                    onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOnSurfaceVariant();
                                }
                                $composer5.endReplaceGroup();
                                TextKt.m2817Text4IGK_g(strStringResource, (Modifier) null, onSurfaceVariant, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, bodySmall, $composer5, 0, 0, 65530);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54), zRateLimitDialog$lambda$1, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 806879664, 196992, 0, 8342968);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.RateLimitDialog.4
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
                    NetworkSettingDialogsKt.RateLimitDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RateLimitDialog$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RateLimitDialog$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RateLimitDialog$lambda$4(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void ConcurrentDownloadDialog(final Function0<Unit> onDismissRequest, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(1176043646);
        ComposerKt.sourceInformation($composer3, "C(ConcurrentDownloadDialog)110@4592L73,111@4683L151,123@5080L227,118@4921L133,133@5455L799,116@4839L1416:NetworkSettingDialogs.kt#sffru");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1176043646, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ConcurrentDownloadDialog (NetworkSettingDialogs.kt:109)");
            }
            $composer3.startReplaceGroup(-1341647967);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(PreferenceUtil.getConcurrentFragments$default(PreferenceUtil.INSTANCE, 0, 1, null));
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableFloatState concurrentFragments$delegate = (MutableFloatState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1341647876);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$ConcurrentDownloadDialog$count$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        return Integer.valueOf(NetworkSettingDialogsKt.ConcurrentDownloadDialog$lambda$7(concurrentFragments$delegate) <= 0.125f ? 1 : MathKt.roundToInt(NetworkSettingDialogsKt.ConcurrentDownloadDialog$lambda$7(concurrentFragments$delegate) * 3.0f) * 8);
                    }
                });
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final State count$delegate = (State) value$iv2;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-1046208826, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ConcurrentDownloadDialog.1
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
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer4, "C124@5115L110,124@5094L203:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1046208826, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ConcurrentDownloadDialog.<anonymous> (NetworkSettingDialogs.kt:124)");
                    }
                    $composer4.startReplaceGroup(144512589);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(onDismissRequest);
                    final Function0<Unit> function0 = onDismissRequest;
                    final State<Integer> state = count$delegate;
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$ConcurrentDownloadDialog$1$1$1
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
                                PreferenceUtil.INSTANCE.encodeInt(PreferenceUtilKt.CONCURRENT, NetworkSettingDialogsKt.ConcurrentDownloadDialog$lambda$10(state));
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    $composer4.endReplaceGroup();
                    ButtonKt.TextButton((Function0) value$iv3, null, false, null, null, null, null, null, null, ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7602getLambda5$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(850770632, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ConcurrentDownloadDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C119@4935L109:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(850770632, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ConcurrentDownloadDialog.<anonymous> (NetworkSettingDialogs.kt:119)");
                        }
                        ButtonKt.TextButton(onDismissRequest, null, false, null, null, null, null, null, null, ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7603getLambda6$app_debug(), $composer4, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7604getLambda7$app_debug(), ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7605getLambda8$app_debug(), ComposableLambdaKt.rememberComposableLambda(-598727477, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ConcurrentDownloadDialog.3
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
                    Object value$iv3;
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer4, "C134@5469L775:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-598727477, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ConcurrentDownloadDialog.<anonymous> (NetworkSettingDialogs.kt:134)");
                    }
                    State<Integer> state = count$delegate;
                    final MutableFloatState mutableFloatState = concurrentFragments$delegate;
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
                    ComposerKt.sourceInformationMarkerStart($composer4, 706293481, "C135@5518L39,136@5586L55,136@5574L68,138@5660L40,142@5811L28,145@5941L271,140@5718L512:NetworkSettingDialogs.kt#sffru");
                    $composer4.startReplaceGroup(706293505);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    Object it$iv3 = $composer4.rememberedValue();
                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = InteractionSourceKt.MutableInteractionSource();
                        $composer4.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv3;
                    }
                    final MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv3;
                    $composer4.endReplaceGroup();
                    TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.concurrent_download_num, new Object[]{Integer.valueOf(NetworkSettingDialogsKt.ConcurrentDownloadDialog$lambda$10(state))}, $composer4, 64), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(8)), $composer4, 6);
                    float fConcurrentDownloadDialog$lambda$7 = NetworkSettingDialogsKt.ConcurrentDownloadDialog$lambda$7(mutableFloatState);
                    ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    $composer4.startReplaceGroup(706293798);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    Object it$iv4 = $composer4.rememberedValue();
                    if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = (Function1) new Function1<Float, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$ConcurrentDownloadDialog$3$1$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                                invoke(f.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float it) {
                                mutableFloatState.setFloatValue(it);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv4;
                    }
                    $composer4.endReplaceGroup();
                    SliderKt.Slider(fConcurrentDownloadDialog$lambda$7, (Function1) value$iv4, null, false, null, null, null, 2, ComposableLambdaKt.rememberComposableLambda(70638333, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$ConcurrentDownloadDialog$3$1$2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer, Integer num) {
                            invoke(sliderState, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderState it, Composer $composer5, int $changed3) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposerKt.sourceInformation($composer5, "C146@5982L208:NetworkSettingDialogs.kt#sffru");
                            if (($changed3 & 81) == 16 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70638333, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.network.ConcurrentDownloadDialog.<anonymous>.<anonymous>.<anonymous> (NetworkSettingDialogs.kt:146)");
                            }
                            SliderDefaults.INSTANCE.m2622Thumb9LiSoMs(interactionSource, Modifier.INSTANCE, null, false, DpKt.m6823DpSizeYgX7TsA(C1979Dp.m6801constructorimpl(4), C1979Dp.m6801constructorimpl(32)), $composer5, 221238, 12);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), null, closedFloatingPointRangeRangeTo, $composer4, 113246256, 0, 636);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ConcurrentDownloadDialog.4
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
                    NetworkSettingDialogsKt.ConcurrentDownloadDialog(onDismissRequest, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ConcurrentDownloadDialog$lambda$7(MutableFloatState $concurrentFragments$delegate) {
        MutableFloatState $this$getValue$iv = $concurrentFragments$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ConcurrentDownloadDialog$lambda$10(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    public static final void ProxyConfigurationDialog(Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0<Unit> function1;
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(288836935);
        ComposerKt.sourceInformation($composer3, "C(ProxyConfigurationDialog)161@6364L62,188@7322L117,184@7232L72,166@6595L619,164@6431L1009:NetworkSettingDialogs.kt#sffru");
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
        if (($dirty2 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            final Function0<Unit> function2 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ProxyConfigurationDialog.1
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
                ComposerKt.traceEventStart(288836935, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ProxyConfigurationDialog (NetworkSettingDialogs.kt:160)");
            }
            $composer3.startReplaceGroup(1115350180);
            ComposerKt.sourceInformation($composer3, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.PROXY_URL, null, 1, null), null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState proxyUrl$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            Function0<Unit> function3 = function2;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(function3, ComposableLambdaKt.rememberComposableLambda(-1933415537, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ProxyConfigurationDialog.2
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
                    ComposerKt.sourceInformation($composer4, "C189@7346L87,189@7332L101:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1933415537, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ProxyConfigurationDialog.<anonymous> (NetworkSettingDialogs.kt:189)");
                    }
                    $composer4.startReplaceGroup(1358331547);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function2);
                    final Function0<Unit> function4 = function2;
                    final MutableState<String> mutableState = proxyUrl$delegate;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$ProxyConfigurationDialog$2$1$1
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
                                PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.PROXY_URL, NetworkSettingDialogsKt.ProxyConfigurationDialog$lambda$12(mutableState));
                                function4.invoke();
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
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-36436079, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ProxyConfigurationDialog.3
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
                    ComposerKt.sourceInformation($composer4, "C185@7256L42,185@7242L56:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36436079, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ProxyConfigurationDialog.<anonymous> (NetworkSettingDialogs.kt:185)");
                    }
                    $composer4.startReplaceGroup(1358331457);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function2);
                    final Function0<Unit> function4 = function2;
                    Object it$iv2 = $composer4.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$ProxyConfigurationDialog$3$1$1
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
            }, $composer3, 54), ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7606getLambda9$app_debug(), ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7597getLambda10$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1485934188, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ProxyConfigurationDialog.4
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
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C167@6605L603:NetworkSettingDialogs.kt#sffru");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1485934188, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.network.ProxyConfigurationDialog.<anonymous> (NetworkSettingDialogs.kt:167)");
                    }
                    final MutableState<String> mutableState = proxyUrl$delegate;
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
                        function4 = constructor;
                        $composer4.createNode(function4);
                    } else {
                        function4 = constructor;
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
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 61139052, "C169@6648L35,170@6723L10,168@6626L131,178@7052L53,172@6770L428:NetworkSettingDialogs.kt#sffru");
                    TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.proxy_desc, $composer4, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 0, 0, 65534);
                    Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1979Dp.m6801constructorimpl(16), 0.0f, C1979Dp.m6801constructorimpl(24), 5, null);
                    String strProxyConfigurationDialog$lambda$12 = NetworkSettingDialogsKt.ProxyConfigurationDialog$lambda$12(mutableState);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6433getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    $composer4.startReplaceGroup(61139478);
                    ComposerKt.sourceInformation($composer4, "CC(remember):NetworkSettingDialogs.kt#9igjgp");
                    Object it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt$ProxyConfigurationDialog$4$1$1$1
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
                        $composer4.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    OutlinedTextFieldKt.OutlinedTextField(strProxyConfigurationDialog$lambda$12, (Function1<? super String, Unit>) value$iv2, modifierM872paddingqDBjuR0$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$NetworkSettingDialogsKt.INSTANCE.m7598getLambda11$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer4, 1573296, ProfileVerifier.CompilationStatus.f245xf2722a21, 0, 8355768);
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
            function1 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.NetworkSettingDialogsKt.ProxyConfigurationDialog.5
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
                    NetworkSettingDialogsKt.ProxyConfigurationDialog(function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProxyConfigurationDialog$lambda$12(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }
}
