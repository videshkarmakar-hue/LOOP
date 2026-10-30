package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.hapticfeedback.HapticFeedback;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p001ui.platform.ClipboardManager;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.TextToolbar;
import androidx.compose.p001ui.text.style.ResolvedTextDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectionContainer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002"}, m195d2 = {"DisableSelection", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SelectionContainerKt {
    public static final void SelectionContainer(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1075498320);
        ComposerKt.sourceInformation($composer2, "C(SelectionContainer)P(1)43@1784L45,47@1942L38,44@1834L180:SelectionContainer.kt#eksfi3");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1075498320, $dirty2, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:42)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -525719494, "CC(remember):SelectionContainer.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState selection$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Selection selectionSelectionContainer$lambda$1 = SelectionContainer$lambda$1(selection$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -525719336, "CC(remember):SelectionContainer.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Selection selection) {
                        invoke2(selection);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Selection it) {
                        selection$delegate.setValue(it);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SelectionContainer(modifier, selectionSelectionContainer$lambda$1, (Function1) value$iv2, function2, $composer2, ($dirty2 & 14) | 384 | (($dirty2 << 6) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.2
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
                    SelectionContainerKt.SelectionContainer(modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        MutableState<Selection> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final void DisableSelection(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(336063542);
        ComposerKt.sourceInformation($composer2, "C(DisableSelection)62@2305L104:SelectionContainer.kt#eksfi3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, $dirty, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:61)");
            }
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), function2, $composer2, ($dirty << 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.DisableSelection.1
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
                    SelectionContainerKt.DisableSelection(function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void SelectionContainer(Modifier modifier, final Selection selection, final Function1<? super Selection, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        Modifier modifier3;
        int $dirty;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(2078139907);
        ComposerKt.sourceInformation($composer2, "C(SelectionContainer)P(1,3,2)85@3010L95,89@3125L44,91@3220L7,92@3281L7,93@3332L7,97@3429L2085,143@5546L106,143@5520L132:SelectionContainer.kt#eksfi3");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(selection) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            $dirty = $dirty3;
        } else {
            final Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, $dirty3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:84)");
            }
            SelectionRegistrarImpl registrarImpl = (SelectionRegistrarImpl) RememberSaveableKt.m3889rememberSaveable(new Object[0], (Saver) SelectionRegistrarImpl.INSTANCE.getSaver(), (String) null, (Function0) new Function0<SelectionRegistrarImpl>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$registrarImpl$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SelectionRegistrarImpl invoke() {
                    return new SelectionRegistrarImpl();
                }
            }, $composer2, 3072, 4);
            ComposerKt.sourceInformationMarkerStart($composer2, -525718153, "CC(remember):SelectionContainer.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SelectionManager(registrarImpl);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final SelectionManager manager = (SelectionManager) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            manager.setHapticFeedBack((HapticFeedback) objConsume);
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            manager.setClipboardManager((ClipboardManager) objConsume2);
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            manager.setTextToolbar((TextToolbar) objConsume3);
            manager.setOnSelectionChange(function1);
            manager.setSelection(selection);
            ComposerKt.sourceInformationMarkerStart($composer2, 605522716, "CC(ContextMenuArea)P(1)37@1206L9:ContextMenu.android.kt#423gt5");
            int i3 = (0 >> 3) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1279221227, "C98@3537L1971,98@3464L2044:SelectionContainer.kt#eksfi3");
            modifier3 = modifier4;
            $dirty = $dirty3;
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(registrarImpl), ComposableLambdaKt.rememberComposableLambda(935424596, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1
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
                    ComposerKt.sourceInformation($composer3, "C101@3745L1753,101@3688L1810:SelectionContainer.kt#eksfi3");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(935424596, $changed2, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:101)");
                        }
                        Modifier modifierThen = modifier4.then(manager.getModifier());
                        final Function2<Composer, Integer, Unit> function3 = function2;
                        final SelectionManager selectionManager = manager;
                        SimpleLayoutKt.SimpleLayout(modifierThen, ComposableLambdaKt.rememberComposableLambda(1375295262, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1.1
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
                                Selection it;
                                Object value$iv3;
                                Object value$iv4;
                                ResolvedTextDirection direction;
                                SelectionContainerKt$SelectionContainer$3$1$1$1$1$1$1 value$iv5;
                                ComposerKt.sourceInformation($composer4, "C102@3763L10:SelectionContainer.kt#eksfi3");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1375295262, $changed3, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:102)");
                                    }
                                    function3.invoke($composer4, 0);
                                    if (selectionManager.isInTouchMode() && selectionManager.getHasFocus() && !selectionManager.isTriviallyCollapsedSelection$foundation_release() && (it = selectionManager.getSelection()) != null) {
                                        final SelectionManager selectionManager2 = selectionManager;
                                        $composer4.startReplaceGroup(-228851230);
                                        ComposerKt.sourceInformation($composer4, "*109@4103L129,113@4299L361,132@5268L119,127@4923L495");
                                        List $this$fastForEach$iv = CollectionsKt.listOf((Object[]) new Boolean[]{true, false});
                                        int index$iv = 0;
                                        for (int size = $this$fastForEach$iv.size(); index$iv < size; size = size) {
                                            Object item$iv = $this$fastForEach$iv.get(index$iv);
                                            boolean isStartHandle = ((Boolean) item$iv).booleanValue();
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1853882898, "CC(remember):SelectionContainer.kt#9igjgp");
                                            boolean invalid$iv = $composer4.changed(isStartHandle);
                                            Object it$iv2 = $composer4.rememberedValue();
                                            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                value$iv3 = selectionManager2.handleDragObserver(isStartHandle);
                                                $composer4.updateRememberedValue(value$iv3);
                                            } else {
                                                value$iv3 = it$iv2;
                                            }
                                            TextDragObserver observer = (TextDragObserver) value$iv3;
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1853882702, "CC(remember):SelectionContainer.kt#9igjgp");
                                            boolean invalid$iv2 = $composer4.changed(isStartHandle);
                                            Object it$iv3 = $composer4.rememberedValue();
                                            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                                value$iv4 = isStartHandle ? (Function0) new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Offset invoke() {
                                                        return Offset.m4038boximpl(m1472invokeF1C5BW0());
                                                    }

                                                    /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
                                                    public final long m1472invokeF1C5BW0() {
                                                        Offset offsetM1508getStartHandlePosition_m7T9E = selectionManager2.m1508getStartHandlePosition_m7T9E();
                                                        return offsetM1508getStartHandlePosition_m7T9E != null ? offsetM1508getStartHandlePosition_m7T9E.getPackedValue() : Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                                                    }
                                                } : (Function0) new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Offset invoke() {
                                                        return Offset.m4038boximpl(m1473invokeF1C5BW0());
                                                    }

                                                    /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
                                                    public final long m1473invokeF1C5BW0() {
                                                        Offset offsetM1507getEndHandlePosition_m7T9E = selectionManager2.m1507getEndHandlePosition_m7T9E();
                                                        return offsetM1507getEndHandlePosition_m7T9E != null ? offsetM1507getEndHandlePosition_m7T9E.getPackedValue() : Offset.INSTANCE.m4064getUnspecifiedF1C5BW0();
                                                    }
                                                };
                                                $composer4.updateRememberedValue(value$iv4);
                                            } else {
                                                value$iv4 = it$iv3;
                                            }
                                            Function0 positionProvider = (Function0) value$iv4;
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            if (isStartHandle) {
                                                direction = it.getStart().getDirection();
                                            } else {
                                                direction = it.getEnd().getDirection();
                                            }
                                            C0898xf8ffea21 c0898xf8ffea21 = new C0898xf8ffea21(positionProvider);
                                            boolean handlesCrossed = it.getHandlesCrossed();
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1853881733, "CC(remember):SelectionContainer.kt#9igjgp");
                                            boolean invalid$iv3 = $composer4.changedInstance(observer);
                                            int index$iv2 = index$iv;
                                            Object it$iv4 = $composer4.rememberedValue();
                                            if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                                value$iv5 = new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1$1(observer, null);
                                                $composer4.updateRememberedValue(value$iv5);
                                            } else {
                                                value$iv5 = it$iv4;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            AndroidSelectionHandles_androidKt.m1458SelectionHandlepzduO1o(c0898xf8ffea21, isStartHandle, direction, handlesCrossed, 0L, SuspendingPointerInputFilterKt.pointerInput(companion, observer, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv5), $composer4, 0, 16);
                                            index$iv = index$iv2 + 1;
                                            $this$fastForEach$iv = $this$fastForEach$iv;
                                        }
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
                        }, $composer3, 54), $composer3, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 48);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -525715732, "CC(remember):SelectionContainer.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(manager);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final SelectionManager selectionManager = manager;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                selectionManager.onRelease();
                                selectionManager.setHasFocus(false);
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(manager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.5
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
                    SelectionContainerKt.SelectionContainer(modifier5, selection, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
