package com.videshkarmakar.loop.ui.component;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CancelKt;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.ErrorKt;
import androidx.compose.material.icons.outlined.ContentCopyKt;
import androidx.compose.material.icons.outlined.ErrorOutlineKt;
import androidx.compose.material.icons.outlined.RestartAltKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorDefaults;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.AsyncImageImplKt;
import com.videshkarmakar.loop.ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.ui.theme.ColorSchemeKt;
import com.videshkarmakar.loop.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: DownloadQueueItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\u001a\u0099\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u0010\u0017\u001aQ\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u0010 \u001a\r\u0010!\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\"\u001a\r\u0010#\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\"\"\u0013\u0010\u0000\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003¨\u0006$²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"greenTonalPalettes", "Landroidx/compose/ui/graphics/Color;", "getGreenTonalPalettes", "()J", "J", "CustomCommandTaskItem", "", "modifier", "Landroidx/compose/ui/Modifier;", NotificationCompat.CATEGORY_STATUS, "Lcom/videshkarmakar/loop/ui/component/TaskStatus;", NotificationCompat.CATEGORY_PROGRESS, "", "url", "", "templateName", "progressText", "onCopyLog", "Lkotlin/Function0;", "onCopyError", "onRestart", "onShowLog", "onCancel", "(Landroidx/compose/ui/Modifier;Lcom/videshkarmakar/loop/ui/component/TaskStatus;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "PlaylistItem", "selected", "", "imageModel", "", "title", "author", "onClick", "(Landroidx/compose/ui/Modifier;ZLjava/lang/Object;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PlaylistPreview", "(Landroidx/compose/runtime/Composer;I)V", "TaskItemPreview", "app_debug", "animatedProgress"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadQueueItemKt {
    private static final long greenTonalPalettes = Color.INSTANCE.m4074getGreen0d7_KjU();

    /* JADX INFO: compiled from: DownloadQueueItem.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskStatus.values().length];
            try {
                iArr[TaskStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TaskStatus.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TaskStatus.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TaskStatus.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void PlaylistPreview(Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1631148129);
        ComposerKt.sourceInformation($composer2, "C(PlaylistPreview)66@3081L34,67@3120L125:DownloadQueueItem.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1631148129, $changed, -1, "com.videshkarmakar.loop.ui.component.PlaylistPreview (DownloadQueueItem.kt:65)");
            }
            $composer2.startReplaceGroup(-428676320);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadQueueItem.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState selected$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 349766395, "C68@3157L82,68@3139L100:DownloadQueueItem.kt#g7nzpb");
            ThemeKt.PreviewThemeLight(ComposableLambdaKt.rememberComposableLambda(-1040130591, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$PlaylistPreview$1$1
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
                    ComposerKt.sourceInformation($composer3, "C69@3205L24,69@3171L58:DownloadQueueItem.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1040130591, $changed2, -1, "com.videshkarmakar.loop.ui.component.PlaylistPreview.<anonymous>.<anonymous> (DownloadQueueItem.kt:69)");
                        }
                        boolean zPlaylistPreview$lambda$1 = DownloadQueueItemKt.PlaylistPreview$lambda$1(selected$delegate);
                        $composer3.startReplaceGroup(-1606700706);
                        ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                        final MutableState<Boolean> mutableState = selected$delegate;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$PlaylistPreview$1$1$1$1
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
                                    DownloadQueueItemKt.PlaylistPreview$lambda$2(mutableState, !DownloadQueueItemKt.PlaylistPreview$lambda$1(mutableState));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        DownloadQueueItemKt.PlaylistItem(null, zPlaylistPreview$lambda$1, null, null, null, (Function0) value$iv2, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 29);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.PlaylistPreview.2
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
                    DownloadQueueItemKt.PlaylistPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaylistPreview$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlaylistPreview$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void PlaylistItem(Modifier modifier, boolean selected, Object imageModel, String title, String author, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        String title2;
        String author2;
        Function0<Unit> function1;
        Modifier.Companion modifier3;
        boolean selected2;
        Object imageModel2;
        int $dirty;
        String title3;
        String author3;
        final Function0<Unit> function2;
        Object value$iv;
        String title4;
        Modifier modifier4;
        boolean selected3;
        Object imageModel3;
        String author4;
        Composer $composer2 = $composer.startRestartGroup(-998887019);
        ComposerKt.sourceInformation($composer2, "C(PlaylistItem)P(2,4,1,5)87@3621L13,88@3642L1914,84@3522L2034:DownloadQueueItem.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            z = selected;
        } else if (($changed & 112) == 0) {
            z = selected;
            $dirty2 |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = selected;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                title2 = title;
                int i5 = $composer2.changed(title2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                title2 = title;
            }
            $dirty2 |= i5;
        } else {
            title2 = title;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                author2 = author;
                int i6 = $composer2.changed(author2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                author2 = author;
            }
            $dirty2 |= i6;
        } else {
            author2 = author;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function1 = function0;
        } else if (($changed & 458752) == 0) {
            function1 = function0;
            $dirty2 |= $composer2.changedInstance(function1) ? 131072 : 65536;
        } else {
            function1 = function0;
        }
        if (i4 == 4 && (374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            imageModel3 = imageModel;
            title4 = title2;
            author4 = author2;
            modifier4 = modifier2;
            selected3 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                selected2 = i3 != 0 ? false : z;
                if (i4 != 0) {
                    imageModel2 = Integer.valueOf(R.drawable.sample);
                    $dirty2 &= -897;
                } else {
                    imageModel2 = imageModel;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    title2 = StringsKt.repeat("sample title ", 5);
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    author2 = StringsKt.repeat("author sample ", 5);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    function2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.PlaylistItem.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                    title3 = title2;
                    author3 = author2;
                } else {
                    $dirty = $dirty2;
                    title3 = title2;
                    author3 = author2;
                    function2 = function1;
                }
            } else {
                $composer2.skipToGroupEnd();
                if (i4 != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                selected2 = z;
                title3 = title2;
                author3 = author2;
                function2 = function1;
                imageModel2 = imageModel;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-998887019, $dirty, -1, "com.videshkarmakar.loop.ui.component.PlaylistItem (DownloadQueueItem.kt:83)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            $composer2.startReplaceGroup(-1198845965);
            ComposerKt.sourceInformation($composer2, "CC(remember):DownloadQueueItem.kt#9igjgp");
            boolean invalid$iv = ($dirty & 458752) == 131072;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$PlaylistItem$2$1
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
                        function2.invoke();
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            final Modifier modifier5 = modifier3;
            final boolean z2 = selected2;
            final Object obj = imageModel2;
            final String str = title3;
            final String str2 = author3;
            SurfaceKt.m2418SurfaceT9BRK9s(SelectableKt.m869selectableXHw0xAI$default(modifierFillMaxWidth$default, selected2, false, null, (Function0) value$iv, 6, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(12123696, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.PlaylistItem.3
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
                    ComposerKt.sourceInformation($composer3, "C89@3652L1898:DownloadQueueItem.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(12123696, $changed2, -1, "com.videshkarmakar.loop.ui.component.PlaylistItem.<anonymous> (DownloadQueueItem.kt:89)");
                        }
                        Modifier modifier$iv = PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null), 0.0f, Dp.m6553constructorimpl(4), 1, null);
                        boolean z3 = z2;
                        Object obj2 = obj;
                        String str3 = str;
                        String str4 = str2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i9 = ((0 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u243 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1827348133, "C94@3787L214,103@4185L7,99@4014L631,114@4658L882:DownloadQueueItem.kt#g7nzpb");
                        CheckboxKt.Checkbox(z3, null, $this$invoke_u24lambda_u243.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, Dp.m6553constructorimpl(12), 0.0f, 10, null), Alignment.INSTANCE.getCenterVertically()), false, null, null, $composer3, 48, 56);
                        Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(4)), 0.0f, 0.0f, Dp.m6553constructorimpl(4), 0.0f, 11, null);
                        ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = CompositionLocalsKt.getLocalWindowWidthState();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer3.consume(localWindowWidthState);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv2 = RowScope.CC.weight$default($this$invoke_u24lambda_u243, modifierM624paddingqDBjuR0$default, WindowWidthSizeClass.m3491equalsimpl0(((WindowWidthSizeClass) objConsume).getValue(), WindowWidthSizeClass.INSTANCE.m3499getCompactY0FxcvE()) ? 2.0f : 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                            $composer3.createNode(constructor2);
                        } else {
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i11 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -216756897, "C107@4370L6,105@4270L361:DownloadQueueItem.kt#g7nzpb");
                        AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(obj2, null, AspectRatioKt.aspectRatio(ClipKt.clip(Modifier.INSTANCE, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getExtraSmall()), 1.7777778f, true), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, $composer3, 1572920, 0, 1976);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv3 = RowScope.CC.weight$default($this$invoke_u24lambda_u243, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(4), 1, null), 3.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor3);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -216756355, "C121@4894L10,122@4959L11,119@4812L274:DownloadQueueItem.kt#g7nzpb");
                        TextKt.m2569Text4IGK_g(str3, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                        $composer3.startReplaceGroup(-1827346809);
                        ComposerKt.sourceInformation($composer3, "*130@5293L10,131@5361L11,127@5137L370");
                        if (str4 != null) {
                            TextKt.m2569Text4IGK_g(str4, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, 48, 3120, 55288);
                            Unit unit = Unit.INSTANCE;
                            Unit unit2 = Unit.INSTANCE;
                        }
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
            title4 = title3;
            modifier4 = modifier3;
            selected3 = selected2;
            imageModel3 = imageModel2;
            author4 = author3;
            function1 = function2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z3 = selected3;
            final Object obj2 = imageModel3;
            final String str3 = title4;
            final String str4 = author4;
            final Function0<Unit> function3 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.PlaylistItem.4
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
                    DownloadQueueItemKt.PlaylistItem(modifier6, z3, obj2, str3, str4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void TaskItemPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1432095545);
        ComposerKt.sourceInformation($composer2, "C(TaskItemPreview)145@5609L590:DownloadQueueItem.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1432095545, $changed, -1, "com.videshkarmakar.loop.ui.component.TaskItemPreview (DownloadQueueItem.kt:144)");
            }
            ThemeKt.PreviewThemeLight(ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7123getLambda6$app_debug(), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.TaskItemPreview.1
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
                    DownloadQueueItemKt.TaskItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final long getGreenTonalPalettes() {
        return greenTonalPalettes;
    }

    public static final void CustomCommandTaskItem(Modifier modifier, TaskStatus status, float progress, String url, String templateName, String progressText, Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        TaskStatus status2;
        float progress2;
        String url2;
        String templateName2;
        String progressText2;
        Function0<Unit> function5;
        Function0<Unit> function6;
        Function0<Unit> function7;
        Function0<Unit> function8;
        final long accentColor;
        int i2;
        Function0<Unit> function9;
        Composer $composer2 = $composer.startRestartGroup(-1689576286);
        ComposerKt.sourceInformation($composer2, "C(CustomCommandTaskItem)P(!1,8,6,10,9,7,3,2,4,5)*191@7165L11,200@7482L11,203@7602L11,207@7684L325,217@8096L5,218@8113L6560,215@8018L6655:DownloadQueueItem.kt#g7nzpb");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(status) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(progress) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(url) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(templateName) ? 16384 : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(progressText) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 536870912 : 268435456;
        }
        int i12 = i & 1024;
        if (i12 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer2.changedInstance(function4) ? 4 : 2;
        }
        if (($dirty & 1533916881) == 306783376 && ($dirty1 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            status2 = status;
            progress2 = progress;
            url2 = url;
            templateName2 = templateName;
            progressText2 = progressText;
            function5 = function0;
            function9 = function1;
            function6 = function2;
            function7 = function3;
            function8 = function4;
        } else {
            modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
            status2 = i3 != 0 ? TaskStatus.ERROR : status;
            progress2 = i4 != 0 ? 0.85f : progress;
            url2 = i5 != 0 ? "https://www.example.com" : url;
            templateName2 = i6 != 0 ? "Template Example" : templateName;
            progressText2 = i7 != 0 ? "[sample] Extracting URL: https://www.example.com\n[sample] sample: Downloading webpage\n[sample] sample: Downloading android player API JSON\n[info] Available automatic captions for sample:[info] Available automatic captions for sample:" : progressText;
            function5 = i8 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.CustomCommandTaskItem.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function0;
            AnonymousClass2 anonymousClass2 = i9 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.CustomCommandTaskItem.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            function6 = i10 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.CustomCommandTaskItem.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            function7 = i11 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.CustomCommandTaskItem.4
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            function8 = i12 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.CustomCommandTaskItem.5
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1689576286, $dirty, $dirty1, "com.videshkarmakar.loop.ui.component.CustomCommandTaskItem (DownloadQueueItem.kt:188)");
            }
            ColorScheme greenScheme = ColorSchemeKt.getLoopColorScheme();
            ColorScheme $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u245 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable);
            switch (WhenMappings.$EnumSwitchMapping$0[status2.ordinal()]) {
                case 1:
                    accentColor = greenScheme.getPrimary();
                    break;
                case 2:
                    accentColor = $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u245.getOnSurfaceVariant();
                    break;
                case 3:
                    accentColor = $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u245.getPrimary();
                    break;
                case 4:
                    accentColor = $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u245.getError();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            ColorScheme $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u246 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable);
            long surfaceContainerLow = $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u246.getSurfaceContainerLow();
            long containerColor = Color.m4041copywmQWz5c(surfaceContainerLow, (14 & 1) != 0 ? Color.m4045getAlphaimpl(surfaceContainerLow) : 0.9f, (14 & 2) != 0 ? Color.m4049getRedimpl(surfaceContainerLow) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(surfaceContainerLow) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(surfaceContainerLow) : 0.0f);
            ColorScheme $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u247 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable);
            final long contentColor = $this$CustomCommandTaskItem_u24lambda_u248_u24lambda_u247.getOnSurfaceVariant();
            switch (WhenMappings.$EnumSwitchMapping$0[status2.ordinal()]) {
                case 1:
                    i2 = R.string.status_completed;
                    break;
                case 2:
                    i2 = R.string.status_canceled;
                    break;
                case 3:
                    i2 = R.string.status_downloading;
                    break;
                case 4:
                    i2 = R.string.status_error;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            StringResources_androidKt.stringResource(i2, $composer2, 0);
            final TaskStatus taskStatus = status2;
            final String str = progressText2;
            final float f = progress2;
            final Function0<Unit> function10 = function7;
            final String str2 = templateName2;
            final String str3 = url2;
            final Function0<Unit> function11 = function5;
            final Function0<Unit> function12 = anonymousClass2;
            final Function0<Unit> function13 = function8;
            final Function0<Unit> function14 = function6;
            SurfaceKt.m2418SurfaceT9BRK9s(null, CardDefaults.INSTANCE.getShape($composer2, CardDefaults.$stable), containerColor, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(177903869, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1

                /* JADX INFO: compiled from: DownloadQueueItem.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TaskStatus.values().length];
                        try {
                            iArr[TaskStatus.FINISHED.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[TaskStatus.CANCELED.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        try {
                            iArr[TaskStatus.RUNNING.ordinal()] = 3;
                        } catch (NoSuchFieldError e3) {
                        }
                        try {
                            iArr[TaskStatus.ERROR.ordinal()] = 4;
                        } catch (NoSuchFieldError e4) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:103:0x0968  */
                /* JADX WARN: Code duplicated, block: B:105:0x099a  */
                /* JADX WARN: Code duplicated, block: B:109:0x09a7 A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:114:0x09e0  */
                /* JADX WARN: Code duplicated, block: B:116:0x0a09  */
                /* JADX WARN: Code duplicated, block: B:120:0x0a16 A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:123:0x0a4d  */
                /* JADX WARN: Code duplicated, block: B:126:0x0a6e  */
                /* JADX WARN: Code duplicated, block: B:128:0x0a72  */
                /* JADX WARN: Code duplicated, block: B:130:0x0a97  */
                /* JADX WARN: Code duplicated, block: B:134:0x0aa2  */
                /* JADX WARN: Code duplicated, block: B:138:0x0afe  */
                /* JADX WARN: Code duplicated, block: B:141:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:28:0x01f1  */
                /* JADX WARN: Code duplicated, block: B:31:0x01fd  */
                /* JADX WARN: Code duplicated, block: B:32:0x0203  */
                /* JADX WARN: Code duplicated, block: B:35:0x0236  */
                /* JADX WARN: Code duplicated, block: B:38:0x0249  */
                /* JADX WARN: Code duplicated, block: B:39:0x024c  */
                /* JADX WARN: Code duplicated, block: B:43:0x02a6  */
                /* JADX WARN: Code duplicated, block: B:44:0x02c3  */
                /* JADX WARN: Code duplicated, block: B:45:0x0324  */
                /* JADX WARN: Code duplicated, block: B:47:0x035f  */
                /* JADX WARN: Code duplicated, block: B:48:0x03a6  */
                /* JADX WARN: Code duplicated, block: B:50:0x03f5  */
                /* JADX WARN: Code duplicated, block: B:51:0x044c  */
                /* JADX WARN: Code duplicated, block: B:54:0x0525  */
                /* JADX WARN: Code duplicated, block: B:57:0x0531  */
                /* JADX WARN: Code duplicated, block: B:58:0x0535  */
                /* JADX WARN: Code duplicated, block: B:61:0x0564  */
                /* JADX WARN: Code duplicated, block: B:64:0x0577  */
                /* JADX WARN: Code duplicated, block: B:65:0x057a  */
                /* JADX WARN: Code duplicated, block: B:69:0x06dd  */
                /* JADX WARN: Code duplicated, block: B:73:0x06e8  */
                /* JADX WARN: Code duplicated, block: B:76:0x07a8  */
                /* JADX WARN: Code duplicated, block: B:77:0x07b6  */
                /* JADX WARN: Code duplicated, block: B:80:0x0864  */
                /* JADX WARN: Code duplicated, block: B:83:0x0870  */
                /* JADX WARN: Code duplicated, block: B:84:0x0874  */
                /* JADX WARN: Code duplicated, block: B:87:0x089f  */
                /* JADX WARN: Code duplicated, block: B:91:0x08b3 A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:95:0x0922  */
                /* JADX WARN: Code duplicated, block: B:99:0x0930 A[ADDED_TO_REGION] */
                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function15;
                    MeasurePolicy measurePolicy$iv;
                    CompositionLocalMap localMap$iv$iv;
                    MeasurePolicy measurePolicy$iv2;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Function0<ComposeUiNode> function16;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    MeasurePolicy measurePolicy$iv3;
                    Function0<Unit> function17;
                    float f2;
                    State<Float> stateAnimateFloatAsState;
                    Modifier modifier$iv;
                    int compositeKeyHash$iv$iv2;
                    Function0<ComposeUiNode> constructor2;
                    Composer $this$Layout_u24lambda_u240$iv$iv2;
                    Modifier modifier$iv2;
                    Function0<ComposeUiNode> function18;
                    boolean invalid$iv;
                    Object value$iv;
                    long error;
                    int compositeKeyHash$iv$iv3;
                    Function0<ComposeUiNode> constructor3;
                    Composer $this$Layout_u24lambda_u240$iv$iv3;
                    boolean invalid$iv2;
                    Object value$iv2;
                    Composer $composer4;
                    Composer $composer5;
                    boolean invalid$iv3;
                    Object value$iv3;
                    boolean invalid$iv4;
                    Object value$iv4;
                    boolean invalid$iv5;
                    Object value$iv5;
                    ComposerKt.sourceInformation($composer3, "C219@8127L6536:DownloadQueueItem.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(177903869, $changed2, -1, "com.videshkarmakar.loop.ui.component.CustomCommandTaskItem.<anonymous>.<anonymous> (DownloadQueueItem.kt:219)");
                        }
                        Modifier modifier$iv3 = PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16));
                        TaskStatus taskStatus2 = taskStatus;
                        long j = contentColor;
                        String str4 = str;
                        long j2 = accentColor;
                        float f3 = f;
                        final Function0<Unit> function19 = function10;
                        String str5 = str2;
                        String str6 = str3;
                        Function0<Unit> function20 = function11;
                        final Function0<Unit> function21 = function12;
                        final Function0<Unit> function22 = function13;
                        final Function0<Unit> function23 = function14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function15 = constructor4;
                            $composer3.createNode(function15);
                        } else {
                            function15 = constructor4;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                            measurePolicy$iv = measurePolicy$iv4;
                            localMap$iv$iv = localMap$iv$iv2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i13 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i14 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -714344486, "C220@8188L4631,325@13050L10,320@12836L525,332@13420L21,332@13379L1270:DownloadQueueItem.kt#g7nzpb");
                            Modifier modifier$iv4 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            });
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv2 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                function16 = constructor;
                                $composer3.createNode(function16);
                            } else {
                                function16 = constructor;
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                                measurePolicy$iv3 = measurePolicy$iv2;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                }
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i15 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                int i16 = ((384 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u249_u24lambda_u243 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1510466117, "C282@11148L808,308@12332L11,309@12425L11,307@12255L224,306@12186L15,302@11977L824:DownloadQueueItem.kt#g7nzpb");
                                switch (WhenMappings.$EnumSwitchMapping$0[taskStatus2.ordinal()]) {
                                    case 1:
                                        function17 = function20;
                                        f2 = 0.0f;
                                        $composer3.startReplaceGroup(-1510466024);
                                        ComposerKt.sourceInformation($composer3, "232@8809L46,226@8473L412");
                                        IconKt.m2044Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_completed, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                        $composer3.endReplaceGroup();
                                        Unit unit = Unit.INSTANCE;
                                        break;
                                    case 2:
                                        function17 = function20;
                                        f2 = 0.0f;
                                        $composer3.startReplaceGroup(-1510465507);
                                        ComposerKt.sourceInformation($composer3, "243@9321L45,237@8990L406");
                                        IconKt.m2044Iconww6aTOc(CancelKt.getCancel(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_canceled, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                        $composer3.endReplaceGroup();
                                        Unit unit2 = Unit.INSTANCE;
                                        break;
                                    case 3:
                                        function17 = function20;
                                        f2 = 0.0f;
                                        $composer3.startReplaceGroup(-1510464997);
                                        ComposerKt.sourceInformation($composer3, "248@9524L202");
                                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                                        if (f3 < 0.0f) {
                                            $composer3.startReplaceGroup(-1510464513);
                                            ComposerKt.sourceInformation($composer3, "253@9805L301");
                                            ProgressIndicatorKt.m2240CircularProgressIndicatorLxG7B9w(SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 390, 24);
                                            $composer3.endReplaceGroup();
                                        } else {
                                            $composer3.startReplaceGroup(-1510464146);
                                            ComposerKt.sourceInformation($composer3, "260@10172L402");
                                            ProgressIndicatorKt.m2237CircularProgressIndicatorDUhRLBM(invoke$lambda$9$lambda$3$lambda$0(stateAnimateFloatAsState), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 3120, 48);
                                            $composer3.endReplaceGroup();
                                        }
                                        $composer3.endReplaceGroup();
                                        Unit unit3 = Unit.INSTANCE;
                                        break;
                                    case 4:
                                        $composer3.startReplaceGroup(-1510463821);
                                        ComposerKt.sourceInformation($composer3, "277@11006L42,271@10676L402");
                                        function17 = function20;
                                        f2 = 0.0f;
                                        IconKt.m2044Iconww6aTOc(ErrorKt.getError(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_error, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                        $composer3.endReplaceGroup();
                                        Unit unit4 = Unit.INSTANCE;
                                        break;
                                    default:
                                        function17 = function20;
                                        f2 = 0.0f;
                                        $composer3.startReplaceGroup(-1510463371);
                                        $composer3.endReplaceGroup();
                                        Unit unit5 = Unit.INSTANCE;
                                        break;
                                }
                                modifier$iv = RowScope.CC.weight$default($this$invoke_u24lambda_u249_u24lambda_u243, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), f2, 2, null), 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv3 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
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
                                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                                    modifier$iv2 = modifier$iv;
                                    function18 = constructor2;
                                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i17 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    int i18 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                                    TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                                    TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    $composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    Modifier modifierSemantics = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                        }
                                    });
                                    IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                                    $composer3.startReplaceGroup(-1510462311);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv = $composer3.changed(function19);
                                    Object it$iv = $composer3.rememberedValue();
                                    if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                                function19.invoke();
                                            }
                                        };
                                        $composer3.updateRememberedValue(value$iv);
                                    } else {
                                        value$iv = it$iv;
                                    }
                                    $composer3.endReplaceGroup();
                                    IconButtonKt.IconButton((Function0) value$iv, modifierSemantics, false, iconButtonColorsM2038iconButtonColorsro_MJ88, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    $composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    Modifier modifierM624paddingqDBjuR0$default = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                                    TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                                    TextStyle textStyleM6029copyp1EtxEg = bodySmall.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall.paragraphStyle.getTextMotion() : null);
                                    $composer3.startReplaceGroup(-714339534);
                                    ComposerKt.sourceInformation($composer3, "326@13186L11");
                                    if (taskStatus2 == TaskStatus.ERROR) {
                                        error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                    } else {
                                        error = j;
                                    }
                                    $composer3.endReplaceGroup();
                                    TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg, $composer3, 48, 27696, 38904);
                                    Modifier modifier$iv5 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                                    MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv4 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                                    CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer3.startReusableNode();
                                    if ($composer3.getInserting()) {
                                        $composer3.createNode(constructor3);
                                    } else {
                                        $composer3.useNode();
                                    }
                                    $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                                    }
                                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i19 = ($changed$iv$iv$iv4 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    int i20 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                                    ImageVector contentCopy = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                                    $composer3.startReplaceGroup(-1510460863);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    final Function0<Unit> function24 = function17;
                                    invalid$iv2 = $composer3.changed(function24);
                                    value$iv2 = $composer3.rememberedValue();
                                    if (!invalid$iv2 || value$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                                function24.invoke();
                                            }
                                        };
                                        $composer3.updateRememberedValue(value$iv2);
                                    }
                                    $composer3.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy, strStringResource, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                                    $composer3.startReplaceGroup(-1510460827);
                                    ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                                    if (taskStatus2 == TaskStatus.ERROR) {
                                        ImageVector errorOutline = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                                        long error2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                        $composer3.startReplaceGroup(-1510460507);
                                        ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                        invalid$iv5 = $composer3.changed(function21);
                                        Object it$iv2 = $composer3.rememberedValue();
                                        if (!invalid$iv5 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                                    function21.invoke();
                                                }
                                            };
                                            $composer3.updateRememberedValue(value$iv5);
                                        } else {
                                            value$iv5 = it$iv2;
                                        }
                                        $composer3.endReplaceGroup();
                                        ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline, strStringResource2, error2, 0L, (Function0) value$iv5, $composer3, 0, 17);
                                    }
                                    $composer3.endReplaceGroup();
                                    $composer3.startReplaceGroup(-1510460469);
                                    ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                                    if (taskStatus2 == TaskStatus.RUNNING) {
                                        ImageVector cancel = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                                        $composer3.startReplaceGroup(-1510460184);
                                        ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                        invalid$iv4 = $composer3.changed(function22);
                                        Object it$iv3 = $composer3.rememberedValue();
                                        if (!invalid$iv4 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                                    function22.invoke();
                                                }
                                            };
                                            $composer3.updateRememberedValue(value$iv4);
                                        } else {
                                            value$iv4 = it$iv3;
                                        }
                                        $composer3.endReplaceGroup();
                                        $composer4 = $composer3;
                                        ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel, strStringResource3, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                                    } else {
                                        $composer4 = $composer3;
                                    }
                                    $composer4.endReplaceGroup();
                                    $composer5 = $composer4;
                                    $composer5.startReplaceGroup(-714338326);
                                    ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                                    if (taskStatus2 != TaskStatus.CANCELED || taskStatus2 == TaskStatus.ERROR) {
                                        ImageVector restartAlt = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                        $composer5.startReplaceGroup(-1510459881);
                                        ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                        invalid$iv3 = $composer5.changed(function23);
                                        Object it$iv4 = $composer5.rememberedValue();
                                        if (!invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                    function23.invoke();
                                                }
                                            };
                                            $composer5.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv4;
                                        }
                                        $composer5.endReplaceGroup();
                                        ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt, strStringResource4, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                                    }
                                    $composer5.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
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
                                modifier$iv2 = modifier$iv;
                                function18 = constructor2;
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i110 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                int i111 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                                TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                                TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifierSemantics2 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    }
                                });
                                IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ89 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                                $composer3.startReplaceGroup(-1510462311);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv = $composer3.changed(function19);
                                Object it$iv5 = $composer3.rememberedValue();
                                if (!invalid$iv) {
                                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                            function19.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                            function19.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv);
                                }
                                $composer3.endReplaceGroup();
                                IconButtonKt.IconButton((Function0) value$iv, modifierSemantics2, false, iconButtonColorsM2038iconButtonColorsro_MJ89, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifierM624paddingqDBjuR0$default2 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                                TextStyle bodySmall2 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                                TextStyle textStyleM6029copyp1EtxEg2 = bodySmall2.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall2.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall2.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall2.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall2.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall2.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall2.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall2.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall2.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall2.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall2.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall2.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall2.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall2.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall2.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall2.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall2.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall2.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall2.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall2.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall2.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall2.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall2.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall2.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall2.paragraphStyle.getTextMotion() : null);
                                $composer3.startReplaceGroup(-714339534);
                                ComposerKt.sourceInformation($composer3, "326@13186L11");
                                if (taskStatus2 == TaskStatus.ERROR) {
                                    error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                } else {
                                    error = j;
                                }
                                $composer3.endReplaceGroup();
                                TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default2, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg2, $composer3, 48, 27696, 38904);
                                Modifier modifier$iv6 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv5 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                                CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
                                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer3.startReusableNode();
                                if ($composer3.getInserting()) {
                                    $composer3.createNode(constructor3);
                                } else {
                                    $composer3.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                                }
                                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash5);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                                int i112 = ($changed$iv$iv$iv5 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                int i21 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                                ImageVector contentCopy2 = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                                String strStringResource5 = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                                $composer3.startReplaceGroup(-1510460863);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                final Function0<Unit> function25 = function17;
                                invalid$iv2 = $composer3.changed(function25);
                                value$iv2 = $composer3.rememberedValue();
                                if (!invalid$iv2) {
                                }
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                        function25.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv2);
                                $composer3.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy2, strStringResource5, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                                $composer3.startReplaceGroup(-1510460827);
                                ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                                if (taskStatus2 == TaskStatus.ERROR) {
                                    ImageVector errorOutline2 = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                                    String strStringResource6 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                                    long error3 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                    $composer3.startReplaceGroup(-1510460507);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv5 = $composer3.changed(function21);
                                    Object it$iv6 = $composer3.rememberedValue();
                                    if (!invalid$iv5) {
                                    }
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                            function21.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv5);
                                    $composer3.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline2, strStringResource6, error3, 0L, (Function0) value$iv5, $composer3, 0, 17);
                                }
                                $composer3.endReplaceGroup();
                                $composer3.startReplaceGroup(-1510460469);
                                ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                                if (taskStatus2 == TaskStatus.RUNNING) {
                                    ImageVector cancel2 = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                                    String strStringResource7 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                                    $composer3.startReplaceGroup(-1510460184);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv4 = $composer3.changed(function22);
                                    Object it$iv7 = $composer3.rememberedValue();
                                    if (!invalid$iv4) {
                                    }
                                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                            function22.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv4);
                                    $composer3.endReplaceGroup();
                                    $composer4 = $composer3;
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel2, strStringResource7, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                                } else {
                                    $composer4 = $composer3;
                                }
                                $composer4.endReplaceGroup();
                                $composer5 = $composer4;
                                $composer5.startReplaceGroup(-714338326);
                                ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                                if (taskStatus2 != TaskStatus.CANCELED) {
                                    ImageVector restartAlt2 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                    String strStringResource8 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                    $composer5.startReplaceGroup(-1510459881);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv3 = $composer5.changed(function23);
                                    Object it$iv8 = $composer5.rememberedValue();
                                    if (!invalid$iv3) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    }
                                    $composer5.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt2, strStringResource8, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                                } else {
                                    ImageVector restartAlt3 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                    String strStringResource9 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                    $composer5.startReplaceGroup(-1510459881);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv3 = $composer5.changed(function23);
                                    Object it$iv9 = $composer5.rememberedValue();
                                    if (!invalid$iv3) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    }
                                    $composer5.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt3, strStringResource9, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                                }
                                $composer5.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
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
                            measurePolicy$iv3 = measurePolicy$iv2;
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i113 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            int i114 = ((384 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u249_u24lambda_u244 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1510466117, "C282@11148L808,308@12332L11,309@12425L11,307@12255L224,306@12186L15,302@11977L824:DownloadQueueItem.kt#g7nzpb");
                            switch (WhenMappings.$EnumSwitchMapping$0[taskStatus2.ordinal()]) {
                                case 1:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510466024);
                                    ComposerKt.sourceInformation($composer3, "232@8809L46,226@8473L412");
                                    IconKt.m2044Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_completed, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                    $composer3.endReplaceGroup();
                                    Unit unit6 = Unit.INSTANCE;
                                    break;
                                case 2:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510465507);
                                    ComposerKt.sourceInformation($composer3, "243@9321L45,237@8990L406");
                                    IconKt.m2044Iconww6aTOc(CancelKt.getCancel(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_canceled, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                    $composer3.endReplaceGroup();
                                    Unit unit7 = Unit.INSTANCE;
                                    break;
                                case 3:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510464997);
                                    ComposerKt.sourceInformation($composer3, "248@9524L202");
                                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                                    if (f3 < 0.0f) {
                                        $composer3.startReplaceGroup(-1510464513);
                                        ComposerKt.sourceInformation($composer3, "253@9805L301");
                                        ProgressIndicatorKt.m2240CircularProgressIndicatorLxG7B9w(SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 390, 24);
                                        $composer3.endReplaceGroup();
                                    } else {
                                        $composer3.startReplaceGroup(-1510464146);
                                        ComposerKt.sourceInformation($composer3, "260@10172L402");
                                        ProgressIndicatorKt.m2237CircularProgressIndicatorDUhRLBM(invoke$lambda$9$lambda$3$lambda$0(stateAnimateFloatAsState), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 3120, 48);
                                        $composer3.endReplaceGroup();
                                    }
                                    $composer3.endReplaceGroup();
                                    Unit unit8 = Unit.INSTANCE;
                                    break;
                                case 4:
                                    $composer3.startReplaceGroup(-1510463821);
                                    ComposerKt.sourceInformation($composer3, "277@11006L42,271@10676L402");
                                    function17 = function20;
                                    f2 = 0.0f;
                                    IconKt.m2044Iconww6aTOc(ErrorKt.getError(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_error, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                    $composer3.endReplaceGroup();
                                    Unit unit9 = Unit.INSTANCE;
                                    break;
                                default:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510463371);
                                    $composer3.endReplaceGroup();
                                    Unit unit10 = Unit.INSTANCE;
                                    break;
                            }
                            modifier$iv = RowScope.CC.weight$default($this$invoke_u24lambda_u249_u24lambda_u244, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), f2, 2, null), 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv8 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv6 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv7 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
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
                            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                                modifier$iv2 = modifier$iv;
                                function18 = constructor2;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                }
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                                int i115 = ($changed$iv$iv$iv6 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                                int i116 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                                TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                                TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifierSemantics3 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    }
                                });
                                IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ810 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                                $composer3.startReplaceGroup(-1510462311);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv = $composer3.changed(function19);
                                Object it$iv10 = $composer3.rememberedValue();
                                if (!invalid$iv) {
                                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                            function19.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                            function19.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv);
                                }
                                $composer3.endReplaceGroup();
                                IconButtonKt.IconButton((Function0) value$iv, modifierSemantics3, false, iconButtonColorsM2038iconButtonColorsro_MJ810, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifierM624paddingqDBjuR0$default3 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                                TextStyle bodySmall3 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                                TextStyle textStyleM6029copyp1EtxEg3 = bodySmall3.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall3.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall3.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall3.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall3.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall3.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall3.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall3.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall3.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall3.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall3.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall3.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall3.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall3.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall3.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall3.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall3.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall3.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall3.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall3.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall3.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall3.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall3.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall3.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall3.paragraphStyle.getTextMotion() : null);
                                $composer3.startReplaceGroup(-714339534);
                                ComposerKt.sourceInformation($composer3, "326@13186L11");
                                if (taskStatus2 == TaskStatus.ERROR) {
                                    error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                } else {
                                    error = j;
                                }
                                $composer3.endReplaceGroup();
                                TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default3, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg3, $composer3, 48, 27696, 38904);
                                Modifier modifier$iv7 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv9 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv7 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                                CompositionLocalMap localMap$iv$iv8 = $composer3.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer3, modifier$iv7);
                                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer3.startReusableNode();
                                if ($composer3.getInserting()) {
                                    $composer3.createNode(constructor3);
                                } else {
                                    $composer3.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                                }
                                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash7);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                                int i117 = ($changed$iv$iv$iv7 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                                int i22 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                                ImageVector contentCopy3 = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                                String strStringResource10 = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                                $composer3.startReplaceGroup(-1510460863);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                final Function0<Unit> function26 = function17;
                                invalid$iv2 = $composer3.changed(function26);
                                value$iv2 = $composer3.rememberedValue();
                                if (!invalid$iv2) {
                                }
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                        function26.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv2);
                                $composer3.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy3, strStringResource10, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                                $composer3.startReplaceGroup(-1510460827);
                                ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                                if (taskStatus2 == TaskStatus.ERROR) {
                                    ImageVector errorOutline3 = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                                    String strStringResource11 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                                    long error4 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                    $composer3.startReplaceGroup(-1510460507);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv5 = $composer3.changed(function21);
                                    Object it$iv11 = $composer3.rememberedValue();
                                    if (!invalid$iv5) {
                                    }
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                            function21.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv5);
                                    $composer3.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline3, strStringResource11, error4, 0L, (Function0) value$iv5, $composer3, 0, 17);
                                }
                                $composer3.endReplaceGroup();
                                $composer3.startReplaceGroup(-1510460469);
                                ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                                if (taskStatus2 == TaskStatus.RUNNING) {
                                    ImageVector cancel3 = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                                    String strStringResource12 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                                    $composer3.startReplaceGroup(-1510460184);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv4 = $composer3.changed(function22);
                                    Object it$iv12 = $composer3.rememberedValue();
                                    if (!invalid$iv4) {
                                    }
                                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                            function22.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv4);
                                    $composer3.endReplaceGroup();
                                    $composer4 = $composer3;
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel3, strStringResource12, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                                } else {
                                    $composer4 = $composer3;
                                }
                                $composer4.endReplaceGroup();
                                $composer5 = $composer4;
                                $composer5.startReplaceGroup(-714338326);
                                ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                                if (taskStatus2 != TaskStatus.CANCELED) {
                                    ImageVector restartAlt4 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                    String strStringResource13 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                    $composer5.startReplaceGroup(-1510459881);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv3 = $composer5.changed(function23);
                                    Object it$iv13 = $composer5.rememberedValue();
                                    if (!invalid$iv3) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    }
                                    $composer5.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt4, strStringResource13, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                                } else {
                                    ImageVector restartAlt5 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                    String strStringResource14 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                    $composer5.startReplaceGroup(-1510459881);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv3 = $composer5.changed(function23);
                                    Object it$iv14 = $composer5.rememberedValue();
                                    if (!invalid$iv3) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    }
                                    $composer5.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt5, strStringResource14, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                                }
                                $composer5.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
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
                            modifier$iv2 = modifier$iv;
                            function18 = constructor2;
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                            int i118 = ($changed$iv$iv$iv6 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                            int i119 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                            TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                            TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifierSemantics4 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            });
                            IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ811 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                            $composer3.startReplaceGroup(-1510462311);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            invalid$iv = $composer3.changed(function19);
                            Object it$iv15 = $composer3.rememberedValue();
                            if (!invalid$iv) {
                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                        function19.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv);
                            } else {
                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                        function19.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv);
                            }
                            $composer3.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv, modifierSemantics4, false, iconButtonColorsM2038iconButtonColorsro_MJ811, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifierM624paddingqDBjuR0$default4 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                            TextStyle bodySmall4 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                            TextStyle textStyleM6029copyp1EtxEg4 = bodySmall4.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall4.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall4.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall4.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall4.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall4.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall4.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall4.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall4.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall4.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall4.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall4.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall4.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall4.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall4.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall4.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall4.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall4.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall4.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall4.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall4.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall4.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall4.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall4.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall4.paragraphStyle.getTextMotion() : null);
                            $composer3.startReplaceGroup(-714339534);
                            ComposerKt.sourceInformation($composer3, "326@13186L11");
                            if (taskStatus2 == TaskStatus.ERROR) {
                                error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                            } else {
                                error = j;
                            }
                            $composer3.endReplaceGroup();
                            TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default4, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg4, $composer3, 48, 27696, 38904);
                            Modifier modifier$iv8 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv5 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv10 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv8 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv9 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer3, modifier$iv8);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(constructor3);
                            } else {
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash8);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                            int i1110 = ($changed$iv$iv$iv8 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                            int i23 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                            ImageVector contentCopy4 = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                            String strStringResource15 = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                            $composer3.startReplaceGroup(-1510460863);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            final Function0<Unit> function27 = function17;
                            invalid$iv2 = $composer3.changed(function27);
                            value$iv2 = $composer3.rememberedValue();
                            if (!invalid$iv2) {
                            }
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                    function27.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                            $composer3.endReplaceGroup();
                            ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy4, strStringResource15, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                            $composer3.startReplaceGroup(-1510460827);
                            ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                            if (taskStatus2 == TaskStatus.ERROR) {
                                ImageVector errorOutline4 = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                                String strStringResource16 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                                long error5 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                $composer3.startReplaceGroup(-1510460507);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv5 = $composer3.changed(function21);
                                Object it$iv16 = $composer3.rememberedValue();
                                if (!invalid$iv5) {
                                }
                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                        function21.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv5);
                                $composer3.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline4, strStringResource16, error5, 0L, (Function0) value$iv5, $composer3, 0, 17);
                            }
                            $composer3.endReplaceGroup();
                            $composer3.startReplaceGroup(-1510460469);
                            ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                            if (taskStatus2 == TaskStatus.RUNNING) {
                                ImageVector cancel4 = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                                String strStringResource17 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                                $composer3.startReplaceGroup(-1510460184);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv4 = $composer3.changed(function22);
                                Object it$iv17 = $composer3.rememberedValue();
                                if (!invalid$iv4) {
                                }
                                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                        function22.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv4);
                                $composer3.endReplaceGroup();
                                $composer4 = $composer3;
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel4, strStringResource17, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                            } else {
                                $composer4 = $composer3;
                            }
                            $composer4.endReplaceGroup();
                            $composer5 = $composer4;
                            $composer5.startReplaceGroup(-714338326);
                            ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                            if (taskStatus2 != TaskStatus.CANCELED) {
                                ImageVector restartAlt6 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                String strStringResource18 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                $composer5.startReplaceGroup(-1510459881);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv3 = $composer5.changed(function23);
                                Object it$iv18 = $composer5.rememberedValue();
                                if (!invalid$iv3) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                }
                                $composer5.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt6, strStringResource18, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                            } else {
                                ImageVector restartAlt7 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                String strStringResource19 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                $composer5.startReplaceGroup(-1510459881);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv3 = $composer5.changed(function23);
                                Object it$iv19 = $composer5.rememberedValue();
                                if (!invalid$iv3) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                }
                                $composer5.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt7, strStringResource19, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                            }
                            $composer5.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer5);
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
                        measurePolicy$iv = measurePolicy$iv4;
                        localMap$iv$iv = localMap$iv$iv2;
                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i120 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                        int i121 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -714344486, "C220@8188L4631,325@13050L10,320@12836L525,332@13420L21,332@13379L1270:DownloadQueueItem.kt#g7nzpb");
                        Modifier modifier$iv9 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }
                        });
                        Alignment.Vertical verticalAlignment$iv6 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv6 = Arrangement.INSTANCE.getStart();
                        measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv6, verticalAlignment$iv6, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv9 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv10 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer3, modifier$iv9);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function16 = constructor;
                            $composer3.createNode(function16);
                        } else {
                            function16 = constructor;
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                            measurePolicy$iv3 = measurePolicy$iv2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                            int i1111 = ($changed$iv$iv$iv9 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            int i1112 = ((384 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u249_u24lambda_u245 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1510466117, "C282@11148L808,308@12332L11,309@12425L11,307@12255L224,306@12186L15,302@11977L824:DownloadQueueItem.kt#g7nzpb");
                            switch (WhenMappings.$EnumSwitchMapping$0[taskStatus2.ordinal()]) {
                                case 1:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510466024);
                                    ComposerKt.sourceInformation($composer3, "232@8809L46,226@8473L412");
                                    IconKt.m2044Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_completed, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                    $composer3.endReplaceGroup();
                                    Unit unit11 = Unit.INSTANCE;
                                    break;
                                case 2:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510465507);
                                    ComposerKt.sourceInformation($composer3, "243@9321L45,237@8990L406");
                                    IconKt.m2044Iconww6aTOc(CancelKt.getCancel(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_canceled, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                    $composer3.endReplaceGroup();
                                    Unit unit12 = Unit.INSTANCE;
                                    break;
                                case 3:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510464997);
                                    ComposerKt.sourceInformation($composer3, "248@9524L202");
                                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                                    if (f3 < 0.0f) {
                                        $composer3.startReplaceGroup(-1510464513);
                                        ComposerKt.sourceInformation($composer3, "253@9805L301");
                                        ProgressIndicatorKt.m2240CircularProgressIndicatorLxG7B9w(SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 390, 24);
                                        $composer3.endReplaceGroup();
                                    } else {
                                        $composer3.startReplaceGroup(-1510464146);
                                        ComposerKt.sourceInformation($composer3, "260@10172L402");
                                        ProgressIndicatorKt.m2237CircularProgressIndicatorDUhRLBM(invoke$lambda$9$lambda$3$lambda$0(stateAnimateFloatAsState), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 3120, 48);
                                        $composer3.endReplaceGroup();
                                    }
                                    $composer3.endReplaceGroup();
                                    Unit unit13 = Unit.INSTANCE;
                                    break;
                                case 4:
                                    $composer3.startReplaceGroup(-1510463821);
                                    ComposerKt.sourceInformation($composer3, "277@11006L42,271@10676L402");
                                    function17 = function20;
                                    f2 = 0.0f;
                                    IconKt.m2044Iconww6aTOc(ErrorKt.getError(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_error, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                    $composer3.endReplaceGroup();
                                    Unit unit14 = Unit.INSTANCE;
                                    break;
                                default:
                                    function17 = function20;
                                    f2 = 0.0f;
                                    $composer3.startReplaceGroup(-1510463371);
                                    $composer3.endReplaceGroup();
                                    Unit unit15 = Unit.INSTANCE;
                                    break;
                            }
                            modifier$iv = RowScope.CC.weight$default($this$invoke_u24lambda_u249_u24lambda_u245, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), f2, 2, null), 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv11 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv10 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv11 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv10 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv10 = (($changed$iv$iv10 << 6) & 896) | 6;
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
                            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                                modifier$iv2 = modifier$iv;
                                function18 = constructor2;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                }
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv10, ComposeUiNode.INSTANCE.getSetModifier());
                                int i1113 = ($changed$iv$iv$iv10 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                                int i1114 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                                TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                                TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifierSemantics5 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u245.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    }
                                });
                                IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ812 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                                $composer3.startReplaceGroup(-1510462311);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv = $composer3.changed(function19);
                                Object it$iv110 = $composer3.rememberedValue();
                                if (!invalid$iv) {
                                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                            function19.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                            function19.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv);
                                }
                                $composer3.endReplaceGroup();
                                IconButtonKt.IconButton((Function0) value$iv, modifierSemantics5, false, iconButtonColorsM2038iconButtonColorsro_MJ812, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier modifierM624paddingqDBjuR0$default5 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                                TextStyle bodySmall5 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                                TextStyle textStyleM6029copyp1EtxEg5 = bodySmall5.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall5.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall5.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall5.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall5.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall5.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall5.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall5.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall5.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall5.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall5.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall5.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall5.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall5.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall5.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall5.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall5.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall5.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall5.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall5.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall5.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall5.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall5.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall5.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall5.paragraphStyle.getTextMotion() : null);
                                $composer3.startReplaceGroup(-714339534);
                                ComposerKt.sourceInformation($composer3, "326@13186L11");
                                if (taskStatus2 == TaskStatus.ERROR) {
                                    error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                } else {
                                    error = j;
                                }
                                $composer3.endReplaceGroup();
                                TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default5, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg5, $composer3, 48, 27696, 38904);
                                Modifier modifier$iv10 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                Arrangement.Horizontal horizontalArrangement$iv7 = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical verticalAlignment$iv7 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv12 = RowKt.rowMeasurePolicy(horizontalArrangement$iv7, verticalAlignment$iv7, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv11 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                                CompositionLocalMap localMap$iv$iv12 = $composer3.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer3, modifier$iv10);
                                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv11 = (($changed$iv$iv11 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer3.startReusableNode();
                                if ($composer3.getInserting()) {
                                    $composer3.createNode(constructor3);
                                } else {
                                    $composer3.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                                }
                                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash11);
                                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
                                int i1115 = ($changed$iv$iv$iv11 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                                int i24 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                                ImageVector contentCopy5 = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                                String strStringResource110 = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                                $composer3.startReplaceGroup(-1510460863);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                final Function0<Unit> function28 = function17;
                                invalid$iv2 = $composer3.changed(function28);
                                value$iv2 = $composer3.rememberedValue();
                                if (!invalid$iv2) {
                                }
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                        function28.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv2);
                                $composer3.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy5, strStringResource110, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                                $composer3.startReplaceGroup(-1510460827);
                                ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                                if (taskStatus2 == TaskStatus.ERROR) {
                                    ImageVector errorOutline5 = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                                    String strStringResource111 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                                    long error6 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                    $composer3.startReplaceGroup(-1510460507);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv5 = $composer3.changed(function21);
                                    Object it$iv111 = $composer3.rememberedValue();
                                    if (!invalid$iv5) {
                                    }
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                            function21.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv5);
                                    $composer3.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline5, strStringResource111, error6, 0L, (Function0) value$iv5, $composer3, 0, 17);
                                }
                                $composer3.endReplaceGroup();
                                $composer3.startReplaceGroup(-1510460469);
                                ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                                if (taskStatus2 == TaskStatus.RUNNING) {
                                    ImageVector cancel5 = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                                    String strStringResource112 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                                    $composer3.startReplaceGroup(-1510460184);
                                    ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv4 = $composer3.changed(function22);
                                    Object it$iv112 = $composer3.rememberedValue();
                                    if (!invalid$iv4) {
                                    }
                                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                            function22.invoke();
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv4);
                                    $composer3.endReplaceGroup();
                                    $composer4 = $composer3;
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel5, strStringResource112, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                                } else {
                                    $composer4 = $composer3;
                                }
                                $composer4.endReplaceGroup();
                                $composer5 = $composer4;
                                $composer5.startReplaceGroup(-714338326);
                                ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                                if (taskStatus2 != TaskStatus.CANCELED) {
                                    ImageVector restartAlt8 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                    String strStringResource113 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                    $composer5.startReplaceGroup(-1510459881);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv3 = $composer5.changed(function23);
                                    Object it$iv113 = $composer5.rememberedValue();
                                    if (!invalid$iv3) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    }
                                    $composer5.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt8, strStringResource113, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                                } else {
                                    ImageVector restartAlt9 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                    String strStringResource114 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                    $composer5.startReplaceGroup(-1510459881);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                    invalid$iv3 = $composer5.changed(function23);
                                    Object it$iv114 = $composer5.rememberedValue();
                                    if (!invalid$iv3) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                                function23.invoke();
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    }
                                    $composer5.endReplaceGroup();
                                    ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt9, strStringResource114, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                                }
                                $composer5.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
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
                            modifier$iv2 = modifier$iv;
                            function18 = constructor2;
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash10);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv10, ComposeUiNode.INSTANCE.getSetModifier());
                            int i1116 = ($changed$iv$iv$iv10 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                            int i1117 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                            TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                            TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifierSemantics6 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u245.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            });
                            IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ813 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                            $composer3.startReplaceGroup(-1510462311);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            invalid$iv = $composer3.changed(function19);
                            Object it$iv115 = $composer3.rememberedValue();
                            if (!invalid$iv) {
                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                        function19.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv);
                            } else {
                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                        function19.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv);
                            }
                            $composer3.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv, modifierSemantics6, false, iconButtonColorsM2038iconButtonColorsro_MJ813, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifierM624paddingqDBjuR0$default6 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                            TextStyle bodySmall6 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                            TextStyle textStyleM6029copyp1EtxEg6 = bodySmall6.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall6.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall6.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall6.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall6.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall6.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall6.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall6.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall6.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall6.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall6.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall6.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall6.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall6.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall6.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall6.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall6.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall6.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall6.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall6.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall6.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall6.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall6.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall6.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall6.paragraphStyle.getTextMotion() : null);
                            $composer3.startReplaceGroup(-714339534);
                            ComposerKt.sourceInformation($composer3, "326@13186L11");
                            if (taskStatus2 == TaskStatus.ERROR) {
                                error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                            } else {
                                error = j;
                            }
                            $composer3.endReplaceGroup();
                            TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default6, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg6, $composer3, 48, 27696, 38904);
                            Modifier modifier$iv11 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv8 = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv8 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv13 = RowKt.rowMeasurePolicy(horizontalArrangement$iv8, verticalAlignment$iv8, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv12 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv13 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv12 = ComposedModifierKt.materializeModifier($composer3, modifier$iv11);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv12 = (($changed$iv$iv12 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(constructor3);
                            } else {
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash12);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv12, ComposeUiNode.INSTANCE.getSetModifier());
                            int i1118 = ($changed$iv$iv$iv12 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                            int i25 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                            ImageVector contentCopy6 = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                            String strStringResource115 = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                            $composer3.startReplaceGroup(-1510460863);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            final Function0<Unit> function29 = function17;
                            invalid$iv2 = $composer3.changed(function29);
                            value$iv2 = $composer3.rememberedValue();
                            if (!invalid$iv2) {
                            }
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                    function29.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                            $composer3.endReplaceGroup();
                            ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy6, strStringResource115, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                            $composer3.startReplaceGroup(-1510460827);
                            ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                            if (taskStatus2 == TaskStatus.ERROR) {
                                ImageVector errorOutline6 = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                                String strStringResource116 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                                long error7 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                $composer3.startReplaceGroup(-1510460507);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv5 = $composer3.changed(function21);
                                Object it$iv116 = $composer3.rememberedValue();
                                if (!invalid$iv5) {
                                }
                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                        function21.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv5);
                                $composer3.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline6, strStringResource116, error7, 0L, (Function0) value$iv5, $composer3, 0, 17);
                            }
                            $composer3.endReplaceGroup();
                            $composer3.startReplaceGroup(-1510460469);
                            ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                            if (taskStatus2 == TaskStatus.RUNNING) {
                                ImageVector cancel6 = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                                String strStringResource117 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                                $composer3.startReplaceGroup(-1510460184);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv4 = $composer3.changed(function22);
                                Object it$iv117 = $composer3.rememberedValue();
                                if (!invalid$iv4) {
                                }
                                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                        function22.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv4);
                                $composer3.endReplaceGroup();
                                $composer4 = $composer3;
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel6, strStringResource117, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                            } else {
                                $composer4 = $composer3;
                            }
                            $composer4.endReplaceGroup();
                            $composer5 = $composer4;
                            $composer5.startReplaceGroup(-714338326);
                            ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                            if (taskStatus2 != TaskStatus.CANCELED) {
                                ImageVector restartAlt10 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                String strStringResource118 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                $composer5.startReplaceGroup(-1510459881);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv3 = $composer5.changed(function23);
                                Object it$iv118 = $composer5.rememberedValue();
                                if (!invalid$iv3) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                }
                                $composer5.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt10, strStringResource118, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                            } else {
                                ImageVector restartAlt11 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                String strStringResource119 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                $composer5.startReplaceGroup(-1510459881);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv3 = $composer5.changed(function23);
                                Object it$iv119 = $composer5.rememberedValue();
                                if (!invalid$iv3) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                }
                                $composer5.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt11, strStringResource119, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                            }
                            $composer5.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer5);
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
                        measurePolicy$iv3 = measurePolicy$iv2;
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash9);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                        int i1119 = ($changed$iv$iv$iv9 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        int i11110 = ((384 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u249_u24lambda_u246 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1510466117, "C282@11148L808,308@12332L11,309@12425L11,307@12255L224,306@12186L15,302@11977L824:DownloadQueueItem.kt#g7nzpb");
                        switch (WhenMappings.$EnumSwitchMapping$0[taskStatus2.ordinal()]) {
                            case 1:
                                function17 = function20;
                                f2 = 0.0f;
                                $composer3.startReplaceGroup(-1510466024);
                                ComposerKt.sourceInformation($composer3, "232@8809L46,226@8473L412");
                                IconKt.m2044Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_completed, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                $composer3.endReplaceGroup();
                                Unit unit16 = Unit.INSTANCE;
                                break;
                            case 2:
                                function17 = function20;
                                f2 = 0.0f;
                                $composer3.startReplaceGroup(-1510465507);
                                ComposerKt.sourceInformation($composer3, "243@9321L45,237@8990L406");
                                IconKt.m2044Iconww6aTOc(CancelKt.getCancel(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_canceled, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                $composer3.endReplaceGroup();
                                Unit unit17 = Unit.INSTANCE;
                                break;
                            case 3:
                                function17 = function20;
                                f2 = 0.0f;
                                $composer3.startReplaceGroup(-1510464997);
                                ComposerKt.sourceInformation($composer3, "248@9524L202");
                                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f3, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, null, null, $composer3, 0, 28);
                                if (f3 < 0.0f) {
                                    $composer3.startReplaceGroup(-1510464513);
                                    ComposerKt.sourceInformation($composer3, "253@9805L301");
                                    ProgressIndicatorKt.m2240CircularProgressIndicatorLxG7B9w(SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 390, 24);
                                    $composer3.endReplaceGroup();
                                } else {
                                    $composer3.startReplaceGroup(-1510464146);
                                    ComposerKt.sourceInformation($composer3, "260@10172L402");
                                    ProgressIndicatorKt.m2237CircularProgressIndicatorDUhRLBM(invoke$lambda$9$lambda$3$lambda$0(stateAnimateFloatAsState), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, Dp.m6553constructorimpl(5), 0L, 0, $composer3, 3120, 48);
                                    $composer3.endReplaceGroup();
                                }
                                $composer3.endReplaceGroup();
                                Unit unit18 = Unit.INSTANCE;
                                break;
                            case 4:
                                $composer3.startReplaceGroup(-1510463821);
                                ComposerKt.sourceInformation($composer3, "277@11006L42,271@10676L402");
                                function17 = function20;
                                f2 = 0.0f;
                                IconKt.m2044Iconww6aTOc(ErrorKt.getError(Icons.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.status_error, $composer3, 0), SizeKt.m665size3ABfNKs(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), Dp.m6553constructorimpl(24)), j2, $composer3, 384, 0);
                                $composer3.endReplaceGroup();
                                Unit unit19 = Unit.INSTANCE;
                                break;
                            default:
                                function17 = function20;
                                f2 = 0.0f;
                                $composer3.startReplaceGroup(-1510463371);
                                $composer3.endReplaceGroup();
                                Unit unit110 = Unit.INSTANCE;
                                break;
                        }
                        modifier$iv = RowScope.CC.weight$default($this$invoke_u24lambda_u249_u24lambda_u246, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(8), f2, 2, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv5 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv5 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv14 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv5, horizontalAlignment$iv5, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv13 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv14 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv13 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv13 = (($changed$iv$iv13 << 6) & 896) | 6;
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
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                            modifier$iv2 = modifier$iv;
                            function18 = constructor2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            }
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv13, ComposeUiNode.INSTANCE.getSetModifier());
                            int i11111 = ($changed$iv$iv$iv13 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                            int i11112 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                            TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                            TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifierSemantics7 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u246.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                }
                            });
                            IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ814 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                            $composer3.startReplaceGroup(-1510462311);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            invalid$iv = $composer3.changed(function19);
                            Object it$iv1110 = $composer3.rememberedValue();
                            if (!invalid$iv) {
                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                        function19.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv);
                            } else {
                                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                        function19.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv);
                            }
                            $composer3.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv, modifierSemantics7, false, iconButtonColorsM2038iconButtonColorsro_MJ814, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifierM624paddingqDBjuR0$default7 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                            TextStyle bodySmall7 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                            TextStyle textStyleM6029copyp1EtxEg7 = bodySmall7.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall7.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall7.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall7.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall7.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall7.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall7.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall7.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall7.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall7.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall7.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall7.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall7.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall7.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall7.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall7.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall7.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall7.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall7.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall7.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall7.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall7.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall7.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall7.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall7.paragraphStyle.getTextMotion() : null);
                            $composer3.startReplaceGroup(-714339534);
                            ComposerKt.sourceInformation($composer3, "326@13186L11");
                            if (taskStatus2 == TaskStatus.ERROR) {
                                error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                            } else {
                                error = j;
                            }
                            $composer3.endReplaceGroup();
                            TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default7, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg7, $composer3, 48, 27696, 38904);
                            Modifier modifier$iv12 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv9 = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv9 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv15 = RowKt.rowMeasurePolicy(horizontalArrangement$iv9, verticalAlignment$iv9, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv14 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                            CompositionLocalMap localMap$iv$iv15 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv14 = ComposedModifierKt.materializeModifier($composer3, modifier$iv12);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv14 = (($changed$iv$iv14 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(constructor3);
                            } else {
                                $composer3.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash14);
                            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv14, ComposeUiNode.INSTANCE.getSetModifier());
                            int i11113 = ($changed$iv$iv$iv14 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                            int i26 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                            ImageVector contentCopy7 = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                            String strStringResource1110 = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                            $composer3.startReplaceGroup(-1510460863);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            final Function0<Unit> function210 = function17;
                            invalid$iv2 = $composer3.changed(function210);
                            value$iv2 = $composer3.rememberedValue();
                            if (!invalid$iv2) {
                            }
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                    function210.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                            $composer3.endReplaceGroup();
                            ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy7, strStringResource1110, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                            $composer3.startReplaceGroup(-1510460827);
                            ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                            if (taskStatus2 == TaskStatus.ERROR) {
                                ImageVector errorOutline7 = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                                String strStringResource1111 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                                long error8 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                                $composer3.startReplaceGroup(-1510460507);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv5 = $composer3.changed(function21);
                                Object it$iv1111 = $composer3.rememberedValue();
                                if (!invalid$iv5) {
                                }
                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                        function21.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv5);
                                $composer3.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline7, strStringResource1111, error8, 0L, (Function0) value$iv5, $composer3, 0, 17);
                            }
                            $composer3.endReplaceGroup();
                            $composer3.startReplaceGroup(-1510460469);
                            ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                            if (taskStatus2 == TaskStatus.RUNNING) {
                                ImageVector cancel7 = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                                String strStringResource1112 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                                $composer3.startReplaceGroup(-1510460184);
                                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv4 = $composer3.changed(function22);
                                Object it$iv1112 = $composer3.rememberedValue();
                                if (!invalid$iv4) {
                                }
                                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                        function22.invoke();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv4);
                                $composer3.endReplaceGroup();
                                $composer4 = $composer3;
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel7, strStringResource1112, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                            } else {
                                $composer4 = $composer3;
                            }
                            $composer4.endReplaceGroup();
                            $composer5 = $composer4;
                            $composer5.startReplaceGroup(-714338326);
                            ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                            if (taskStatus2 != TaskStatus.CANCELED) {
                                ImageVector restartAlt12 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                String strStringResource1113 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                $composer5.startReplaceGroup(-1510459881);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv3 = $composer5.changed(function23);
                                Object it$iv1113 = $composer5.rememberedValue();
                                if (!invalid$iv3) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                }
                                $composer5.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt12, strStringResource1113, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                            } else {
                                ImageVector restartAlt13 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                                String strStringResource1114 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                                $composer5.startReplaceGroup(-1510459881);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                                invalid$iv3 = $composer5.changed(function23);
                                Object it$iv1114 = $composer5.rememberedValue();
                                if (!invalid$iv3) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                            function23.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv3);
                                }
                                $composer5.endReplaceGroup();
                                ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt13, strStringResource1114, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                            }
                            $composer5.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer5);
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
                        modifier$iv2 = modifier$iv;
                        function18 = constructor2;
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash13);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv13, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11114 = ($changed$iv$iv$iv13 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                        int i11115 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1286036251, "C289@11438L10,287@11333L279,296@11733L10,294@11637L297:DownloadQueueItem.kt#g7nzpb");
                        TextKt.m2569Text4IGK_g(str5, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, 0, 3120, 55290);
                        TextKt.m2569Text4IGK_g(str6, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 3120, 55290);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierSemantics8 = SemanticsModifierKt.semantics($this$invoke_u24lambda_u249_u24lambda_u246.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            }
                        });
                        IconButtonColors iconButtonColorsM2038iconButtonColorsro_MJ815 = IconButtonDefaults.INSTANCE.m2038iconButtonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLowest(), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, 0L, $composer3, IconButtonDefaults.$stable << 12, 12);
                        $composer3.startReplaceGroup(-1510462311);
                        ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                        invalid$iv = $composer3.changed(function19);
                        Object it$iv1115 = $composer3.rememberedValue();
                        if (!invalid$iv) {
                            value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                    function19.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$2$3$1
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
                                    function19.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        }
                        $composer3.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv, modifierSemantics8, false, iconButtonColorsM2038iconButtonColorsro_MJ815, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7124getLambda7$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 20);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierM624paddingqDBjuR0$default8 = PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(8)), 0.0f, Dp.m6553constructorimpl(4), 0.0f, 0.0f, 13, null);
                        TextStyle bodySmall8 = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall();
                        TextStyle textStyleM6029copyp1EtxEg8 = bodySmall8.m6029copyp1EtxEg((16777213 & 1) != 0 ? bodySmall8.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? bodySmall8.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? bodySmall8.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? bodySmall8.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? bodySmall8.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? bodySmall8.spanStyle.getFontFamily() : FontFamily.INSTANCE.getMonospace(), (16777213 & 64) != 0 ? bodySmall8.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? bodySmall8.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? bodySmall8.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? bodySmall8.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? bodySmall8.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? bodySmall8.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? bodySmall8.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? bodySmall8.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? bodySmall8.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? bodySmall8.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? bodySmall8.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? bodySmall8.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? bodySmall8.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? bodySmall8.platformStyle : null, (16777213 & 1048576) != 0 ? bodySmall8.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? bodySmall8.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? bodySmall8.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? bodySmall8.paragraphStyle.getTextMotion() : null);
                        $composer3.startReplaceGroup(-714339534);
                        ComposerKt.sourceInformation($composer3, "326@13186L11");
                        if (taskStatus2 == TaskStatus.ERROR) {
                            error = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                        } else {
                            error = j;
                        }
                        $composer3.endReplaceGroup();
                        TextKt.m2569Text4IGK_g(str4, modifierM624paddingqDBjuR0$default8, error, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 3, 3, (Function1<? super TextLayoutResult, Unit>) null, textStyleM6029copyp1EtxEg8, $composer3, 48, 27696, 38904);
                        Modifier modifier$iv13 = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv10 = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv10 = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv16 = RowKt.rowMeasurePolicy(horizontalArrangement$iv10, verticalAlignment$iv10, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv15 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv16 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv15 = ComposedModifierKt.materializeModifier($composer3, modifier$iv13);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv15 = (($changed$iv$iv15 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor3);
                        } else {
                            $composer3.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash15);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv15, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11116 = ($changed$iv$iv$iv15 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                        int i27 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1510461031, "C335@13573L38,336@13634L15,333@13466L183:DownloadQueueItem.kt#g7nzpb");
                        ImageVector contentCopy8 = ContentCopyKt.getContentCopy(Icons.Outlined.INSTANCE);
                        String strStringResource1115 = StringResources_androidKt.stringResource(R.string.copy_log, $composer3, 0);
                        $composer3.startReplaceGroup(-1510460863);
                        ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                        final Function0<Unit> function211 = function17;
                        invalid$iv2 = $composer3.changed(function211);
                        value$iv2 = $composer3.rememberedValue();
                        if (!invalid$iv2) {
                        }
                        value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$1$1
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
                                function211.invoke();
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        $composer3.endReplaceGroup();
                        ChipsKt.m7106FlatButtonChipjB83MbM(null, contentCopy8, strStringResource1115, 0L, 0L, (Function0) value$iv2, $composer3, 0, 25);
                        $composer3.startReplaceGroup(-1510460827);
                        ComposerKt.sourceInformation($composer3, "340@13842L47,341@13945L11,342@13990L17,338@13726L281");
                        if (taskStatus2 == TaskStatus.ERROR) {
                            ImageVector errorOutline8 = ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE);
                            String strStringResource1116 = StringResources_androidKt.stringResource(R.string.copy_error_report, $composer3, 0);
                            long error9 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getError();
                            $composer3.startReplaceGroup(-1510460507);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            invalid$iv5 = $composer3.changed(function21);
                            Object it$iv1116 = $composer3.rememberedValue();
                            if (!invalid$iv5) {
                            }
                            value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$2$1
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
                                    function21.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv5);
                            $composer3.endReplaceGroup();
                            ChipsKt.m7106FlatButtonChipjB83MbM(null, errorOutline8, strStringResource1116, error9, 0L, (Function0) value$iv5, $composer3, 0, 17);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.startReplaceGroup(-1510460469);
                        ComposerKt.sourceInformation($composer3, "346@14196L36,348@14313L14,344@14086L241");
                        if (taskStatus2 == TaskStatus.RUNNING) {
                            ImageVector cancel8 = androidx.compose.material.icons.outlined.CancelKt.getCancel(Icons.Outlined.INSTANCE);
                            String strStringResource1117 = StringResources_androidKt.stringResource(R.string.cancel, $composer3, 0);
                            $composer3.startReplaceGroup(-1510460184);
                            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            invalid$iv4 = $composer3.changed(function22);
                            Object it$iv1117 = $composer3.rememberedValue();
                            if (!invalid$iv4) {
                            }
                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$3$1
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
                                    function22.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv4);
                            $composer3.endReplaceGroup();
                            $composer4 = $composer3;
                            ChipsKt.m7106FlatButtonChipjB83MbM(null, cancel8, strStringResource1117, j, 0L, (Function0) value$iv4, $composer4, 0, 17);
                        } else {
                            $composer4 = $composer3;
                        }
                        $composer4.endReplaceGroup();
                        $composer5 = $composer4;
                        $composer5.startReplaceGroup(-714338326);
                        ComposerKt.sourceInformation($composer5, "352@14551L37,353@14616L15,350@14437L194");
                        if (taskStatus2 != TaskStatus.CANCELED) {
                            ImageVector restartAlt14 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                            String strStringResource1118 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                            $composer5.startReplaceGroup(-1510459881);
                            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            invalid$iv3 = $composer5.changed(function23);
                            Object it$iv1118 = $composer5.rememberedValue();
                            if (!invalid$iv3) {
                                value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                        function23.invoke();
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                        function23.invoke();
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv3);
                            }
                            $composer5.endReplaceGroup();
                            ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt14, strStringResource1118, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                        } else {
                            ImageVector restartAlt15 = RestartAltKt.getRestartAlt(Icons.Outlined.INSTANCE);
                            String strStringResource1119 = StringResources_androidKt.stringResource(R.string.restart, $composer5, 0);
                            $composer5.startReplaceGroup(-1510459881);
                            ComposerKt.sourceInformation($composer5, "CC(remember):DownloadQueueItem.kt#9igjgp");
                            invalid$iv3 = $composer5.changed(function23);
                            Object it$iv1119 = $composer5.rememberedValue();
                            if (!invalid$iv3) {
                                value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                        function23.invoke();
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt$CustomCommandTaskItem$6$1$1$3$4$1
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
                                        function23.invoke();
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv3);
                            }
                            $composer5.endReplaceGroup();
                            ChipsKt.m7106FlatButtonChipjB83MbM(null, restartAlt15, strStringResource1119, 0L, 0L, (Function0) value$iv3, $composer5, 0, 25);
                        }
                        $composer5.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer5);
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

                private static final float invoke$lambda$9$lambda$3$lambda$0(State<Float> state) {
                    Object thisObj$iv = state.getValue();
                    return ((Number) thisObj$iv).floatValue();
                }
            }, $composer2, 54), $composer2, 12582912, 121);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function9 = anonymousClass2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final TaskStatus taskStatus2 = status2;
            final float f2 = progress2;
            final String str4 = url2;
            final String str5 = templateName2;
            final String str6 = progressText2;
            final Function0<Unit> function15 = function5;
            final Function0<Unit> function16 = function9;
            final Function0<Unit> function17 = function6;
            final Function0<Unit> function18 = function7;
            final Function0<Unit> function19 = function8;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DownloadQueueItemKt.CustomCommandTaskItem.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i13) {
                    DownloadQueueItemKt.CustomCommandTaskItem(modifier3, taskStatus2, f2, str4, str5, str6, function15, function16, function17, function18, function19, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
