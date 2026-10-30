package com.videshkarmakar.loop.p006ui.common;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.PreferenceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ext.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\f"}, m195d2 = {"booleanState", "Landroidx/compose/runtime/MutableState;", "", "", "getBooleanState", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableState;", "intState", "Landroidx/compose/runtime/MutableIntState;", "getIntState", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableIntState;", "stringState", "getStringState", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExtKt {
    public static final MutableState<Boolean> getBooleanState(String $this$booleanState, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter($this$booleanState, "<this>");
        $composer.startReplaceGroup(-2044908879);
        ComposerKt.sourceInformation($composer, "CC12@469L46:Ext.kt#x6o9ax");
        $composer.startReplaceGroup(-204592788);
        ComposerKt.sourceInformation($composer, "CC(remember):Ext.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, $this$booleanState, false, 1, null)), null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableState<Boolean> mutableState = (MutableState) value$iv;
        $composer.endReplaceGroup();
        $composer.endReplaceGroup();
        return mutableState;
    }

    public static final MutableState<String> getStringState(String $this$stringState, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter($this$stringState, "<this>");
        $composer.startReplaceGroup(275724887);
        ComposerKt.sourceInformation($composer, "CC16@579L45:Ext.kt#x6o9ax");
        $composer.startReplaceGroup(105103929);
        ComposerKt.sourceInformation($composer, "CC(remember):Ext.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, $this$stringState, null, 1, null), null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableState<String> mutableState = (MutableState) value$iv;
        $composer.endReplaceGroup();
        $composer.endReplaceGroup();
        return mutableState;
    }

    public static final MutableIntState getIntState(String $this$intState, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter($this$intState, "<this>");
        $composer.startReplaceGroup(1963460724);
        ComposerKt.sourceInformation($composer, "CC19@677L57:Ext.kt#x6o9ax");
        $composer.startReplaceGroup(302245525);
        ComposerKt.sourceInformation($composer, "CC(remember):Ext.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, $this$intState, 0, 1, null));
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableIntState mutableIntState = (MutableIntState) value$iv;
        $composer.endReplaceGroup();
        $composer.endReplaceGroup();
        return mutableIntState;
    }
}
