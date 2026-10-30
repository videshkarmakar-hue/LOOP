package com.videshkarmakar.loop.ui.page.settings.format;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.modifiers.LayoutUtilsKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ArtTrackKt;
import androidx.compose.material.icons.outlined.AudioFileKt;
import androidx.compose.material.icons.outlined.ContentCutKt;
import androidx.compose.material.icons.outlined.CropKt;
import androidx.compose.material.icons.outlined.HighQualityKt;
import androidx.compose.material.icons.outlined.MovieKt;
import androidx.compose.material.icons.outlined.MusicNoteKt;
import androidx.compose.material.icons.outlined.SortKt;
import androidx.compose.material.icons.outlined.SpatialAudioOffKt;
import androidx.compose.material.icons.outlined.SubtitlesKt;
import androidx.compose.material.icons.outlined.SyncKt;
import androidx.compose.material.icons.outlined.VideoFileKt;
import androidx.compose.material.icons.outlined.VideoSettingsKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.ButtonsKt;
import com.videshkarmakar.loop.ui.component.IconButtonsKt;
import com.videshkarmakar.loop.ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.ui.component.TopAppBarKt;
import com.videshkarmakar.loop.util.DownloadUtil;
import com.videshkarmakar.loop.util.PreferenceStrings;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: DownloadFormatPreferences.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006²\u0006\n\u0010\u0007\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\t\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0019X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0019X\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"DownloadFormatPreferences", "", "onNavigateBack", "Lkotlin/Function0;", "navigateToSubtitlePage", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "audioSwitch", "", "isArtworkCroppingEnabled", "downloadSubtitle", "embedSubtitle", "remuxToMkv", "embedMetadata", "showAudioFormatDialog", "showAudioQualityDialog", "showAudioConvertDialog", "showVideoQualityDialog", "showVideoFormatDialog", "showFormatSorterDialog", "showVideoClipDialog", "videoFormat", "", "videoQuality", "convertFormat", "", "sortingFields", "audioFormat", "convertAudio", "isFormatSortingEnabled", "audioQuality", "isVideoClipEnabled", "isFormatSelectionEnabled", "mergeAudioStream", "showMergeAudioDialog", "isCustomCommandEnabled"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadFormatPreferencesKt {
    /* JADX WARN: Code duplicated, block: B:123:0x074c  */
    /* JADX WARN: Code duplicated, block: B:124:0x076d  */
    /* JADX WARN: Code duplicated, block: B:127:0x07ab  */
    /* JADX WARN: Code duplicated, block: B:128:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:131:0x080d  */
    /* JADX WARN: Code duplicated, block: B:132:0x082e  */
    /* JADX WARN: Code duplicated, block: B:135:0x085b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0874  */
    /* JADX WARN: Code duplicated, block: B:139:0x0947  */
    /* JADX WARN: Code duplicated, block: B:141:0x0964  */
    /* JADX WARN: Code duplicated, block: B:142:0x0974  */
    /* JADX WARN: Code duplicated, block: B:144:0x0983  */
    /* JADX WARN: Code duplicated, block: B:147:0x099b  */
    /* JADX WARN: Code duplicated, block: B:149:0x09b5  */
    /* JADX WARN: Code duplicated, block: B:150:0x09c9  */
    /* JADX WARN: Code duplicated, block: B:152:0x09dc  */
    /* JADX WARN: Code duplicated, block: B:155:0x09f6  */
    /* JADX WARN: Code duplicated, block: B:157:0x0a10  */
    /* JADX WARN: Code duplicated, block: B:158:0x0a22  */
    /* JADX WARN: Code duplicated, block: B:161:0x0a49  */
    /* JADX WARN: Code duplicated, block: B:162:0x0a5d  */
    /* JADX WARN: Code duplicated, block: B:164:0x0a70  */
    /* JADX WARN: Code duplicated, block: B:167:0x0a89  */
    /* JADX WARN: Code duplicated, block: B:169:0x0aa6  */
    /* JADX WARN: Code duplicated, block: B:170:0x0aba  */
    /* JADX WARN: Code duplicated, block: B:180:0x0b13  */
    /* JADX WARN: Code duplicated, block: B:183:0x0b2b  */
    /* JADX WARN: Code duplicated, block: B:185:0x0b48  */
    /* JADX WARN: Code duplicated, block: B:186:0x0b5c  */
    /* JADX WARN: Code duplicated, block: B:196:0x0bb6  */
    /* JADX WARN: Code duplicated, block: B:199:0x0bce  */
    /* JADX WARN: Code duplicated, block: B:209:0x0c2b  */
    /* JADX WARN: Code duplicated, block: B:210:0x0c3f  */
    /* JADX WARN: Code duplicated, block: B:220:0x0c9c  */
    /* JADX WARN: Code duplicated, block: B:223:0x0cb6  */
    /* JADX WARN: Code duplicated, block: B:225:0x0cd0  */
    /* JADX WARN: Code duplicated, block: B:226:0x0ce4  */
    /* JADX WARN: Code duplicated, block: B:228:0x0d46  */
    /* JADX WARN: Code duplicated, block: B:231:0x0d57  */
    /* JADX WARN: Code duplicated, block: B:233:0x0d70  */
    /* JADX WARN: Code duplicated, block: B:234:0x0d82  */
    /* JADX WARN: Code duplicated, block: B:236:0x0de4  */
    /* JADX WARN: Code duplicated, block: B:239:0x0dec  */
    public static final void DownloadFormatPreferences(final Function0<Unit> onNavigateBack, final Function0<Unit> navigateToSubtitlePage, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv$iv;
        Object obj;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        Object value$iv3;
        Object value$iv4;
        Object value$iv$iv5;
        Object value$iv$iv6;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Object value$iv$iv7;
        MutableState showAudioQualityDialog$delegate;
        Object value$iv8;
        Object value$iv$iv8;
        final MutableState isVideoClipEnabled$delegate;
        Object it$iv$iv;
        Object value$iv$iv9;
        Object it$iv$iv2;
        Object value$iv$iv10;
        final MutableState mergeAudioStream$delegate;
        Object it$iv;
        Object value$iv9;
        MutableState showMergeAudioDialog$delegate;
        MutableState showAudioQualityDialog$delegate2;
        Composer $composer2;
        String str;
        final MutableState showAudioFormatDialog$delegate;
        final MutableState isFormatSortingEnabled$delegate;
        final MutableState showAudioQualityDialog$delegate3;
        boolean z;
        final MutableIntState videoQuality$delegate;
        final MutableIntState videoFormat$delegate;
        final MutableState sortingFields$delegate;
        MutableState showFormatSorterDialog$delegate;
        Object it$iv2;
        final MutableState showMergeAudioDialog$delegate2;
        Object value$iv10;
        Object it$iv3;
        final MutableState showFormatSorterDialog$delegate2;
        Object value$iv11;
        boolean invalid$iv;
        Object value$iv12;
        Object it$iv4;
        final MutableState showFormatSorterDialog$delegate3;
        Object value$iv13;
        boolean invalid$iv2;
        Object value$iv14;
        Object it$iv5;
        final MutableState showVideoFormatDialog$delegate;
        Object value$iv15;
        boolean invalid$iv3;
        Object value$iv16;
        Object it$iv6;
        final MutableState convertFormat$delegate;
        Object value$iv17;
        boolean invalid$iv4;
        Object value$iv18;
        Object it$iv7;
        final MutableState showAudioConvertDialog$delegate;
        Object value$iv19;
        Object it$iv8;
        Object value$iv20;
        Object it$iv9;
        Object value$iv21;
        Object it$iv10;
        Object value$iv22;
        Intrinsics.checkNotNullParameter(onNavigateBack, "onNavigateBack");
        Intrinsics.checkNotNullParameter(navigateToSubtitlePage, "navigateToSubtitlePage");
        Composer $composer3 = $composer.startRestartGroup(1168714677);
        ComposerKt.sourceInformation($composer3, "C(DownloadFormatPreferences)P(1)75@3886L24,75@3853L92,78@3970L79,81@4086L78,84@4202L12,85@4255L12,86@4307L12,87@4360L12,89@4407L34,90@4476L34,91@4545L34,92@4614L34,93@4682L34,94@4751L34,95@4817L34,97@4889L8,98@4936L8,99@4970L68,100@5064L79,101@5167L90,102@5296L12,103@5358L12,104@5395L92,105@5529L12,106@5595L12,107@5661L12,108@5706L34,113@5877L373,126@6270L10433,110@5746L10958,397@19028L32,399@19157L223,406@19410L114,397@18997L844:DownloadFormatPreferences.kt#5yb39d");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onNavigateBack) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(navigateToSubtitlePage) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1168714677, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences (DownloadFormatPreferences.kt:73)");
            }
            final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.exitUntilCollapsedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer3, 0, 7), new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$scrollBehavior$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            }, null, null, $composer3, (TopAppBarDefaults.$stable << 12) | 48, 12);
            $composer3.startReplaceGroup(991604344);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object it$iv11 = $composer3.rememberedValue();
            if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.EXTRACT_AUDIO)), null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv11;
            }
            MutableState audioSwitch$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991604460);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object it$iv12 = $composer3.rememberedValue();
            if (it$iv12 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CROP_ARTWORK)), null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv12;
            }
            MutableState isArtworkCroppingEnabled$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv3 = $composer3.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SUBTITLE, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv3;
            }
            MutableState downloadSubtitle$delegate = (MutableState) value$iv$iv;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv4 = $composer3.rememberedValue();
            if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                obj = null;
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EMBED_SUBTITLE, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                obj = null;
                value$iv$iv2 = it$iv$iv4;
            }
            MutableState embedSubtitle$delegate = (MutableState) value$iv$iv2;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv5 = $composer3.rememberedValue();
            if (it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.MERGE_OUTPUT_MKV, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv5;
            }
            MutableState remuxToMkv$delegate = (MutableState) value$iv$iv3;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv6 = $composer3.rememberedValue();
            if (it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.EMBED_METADATA, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv6;
            }
            MutableState embedMetadata$delegate = (MutableState) value$iv$iv4;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991604781);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object it$iv13 = $composer3.rememberedValue();
            if (it$iv13 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv13;
            }
            MutableState showAudioFormatDialog$delegate2 = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991604850);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object it$iv14 = $composer3.rememberedValue();
            if (it$iv14 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv14;
            }
            MutableState showAudioQualityDialog$delegate4 = (MutableState) value$iv4;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991604919);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object value$iv23 = $composer3.rememberedValue();
            if (value$iv23 == Composer.INSTANCE.getEmpty()) {
                value$iv23 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv23);
            }
            MutableState showAudioConvertDialog$delegate2 = (MutableState) value$iv23;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991604988);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object value$iv24 = $composer3.rememberedValue();
            if (value$iv24 == Composer.INSTANCE.getEmpty()) {
                value$iv24 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv24);
            }
            MutableState showVideoQualityDialog$delegate = (MutableState) value$iv24;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991605056);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object value$iv25 = $composer3.rememberedValue();
            if (value$iv25 == Composer.INSTANCE.getEmpty()) {
                value$iv25 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv25);
            }
            MutableState showVideoFormatDialog$delegate2 = (MutableState) value$iv25;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991605125);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object value$iv26 = $composer3.rememberedValue();
            if (value$iv26 == Composer.INSTANCE.getEmpty()) {
                value$iv26 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv26);
            }
            MutableState showFormatSorterDialog$delegate4 = (MutableState) value$iv26;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991605191);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object value$iv27 = $composer3.rememberedValue();
            if (value$iv27 == Composer.INSTANCE.getEmpty()) {
                value$iv27 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv27);
            }
            MutableState showVideoClipDialog$delegate = (MutableState) value$iv27;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv7 = $composer3.rememberedValue();
            if (it$iv$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv5 = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.VIDEO_FORMAT, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv5);
            } else {
                value$iv$iv5 = it$iv$iv7;
            }
            MutableIntState videoFormat$delegate2 = (MutableIntState) value$iv$iv5;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1963460724);
            ComposerKt.sourceInformation($composer3, "CC19@677L57:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(302245525);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv8 = $composer3.rememberedValue();
            if (it$iv$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv6 = SnapshotIntStateKt.mutableIntStateOf(PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.VIDEO_QUALITY, 0, 1, null));
                $composer3.updateRememberedValue(value$iv$iv6);
            } else {
                value$iv$iv6 = it$iv$iv8;
            }
            MutableIntState videoQuality$delegate2 = (MutableIntState) value$iv$iv6;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991605344);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            Object it$iv15 = $composer3.rememberedValue();
            if (it$iv15 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceStrings.getAudioConvertDesc$default(PreferenceStrings.INSTANCE, 0, 1, null), null, 2, null);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv15;
            }
            MutableState convertFormat$delegate2 = (MutableState) value$iv5;
            $composer3.endReplaceGroup();
            boolean zDownloadFormatPreferences$lambda$28 = DownloadFormatPreferences$lambda$28(showFormatSorterDialog$delegate4);
            $composer3.startReplaceGroup(991605438);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changed(zDownloadFormatPreferences$lambda$28);
            Object it$iv16 = $composer3.rememberedValue();
            if (invalid$iv5 || it$iv16 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.SORTING_FIELDS, null, 1, null), null, 2, null);
                $composer3.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv16;
            }
            MutableState sortingFields$delegate2 = (MutableState) value$iv6;
            $composer3.endReplaceGroup();
            boolean zDownloadFormatPreferences$lambda$13 = DownloadFormatPreferences$lambda$13(showAudioFormatDialog$delegate2);
            $composer3.startReplaceGroup(991605541);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            boolean invalid$iv6 = $composer3.changed(zDownloadFormatPreferences$lambda$13);
            Object it$iv17 = $composer3.rememberedValue();
            if (invalid$iv6 || it$iv17 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceStrings.getAudioFormatDesc$default(PreferenceStrings.INSTANCE, 0, 1, null), null, 2, null);
                $composer3.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv17;
            }
            MutableState audioFormat$delegate = (MutableState) value$iv7;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object value$iv$iv11 = $composer3.rememberedValue();
            if (value$iv$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.AUDIO_CONVERT, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv11);
            }
            MutableState convertAudio$delegate = (MutableState) value$iv$iv11;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv9 = $composer3.rememberedValue();
            if (it$iv$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORMAT_SORTING, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv7);
            } else {
                value$iv$iv7 = it$iv$iv9;
            }
            MutableState isVideoClipEnabled$delegate2 = (MutableState) value$iv$iv7;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            boolean zDownloadFormatPreferences$lambda$16 = DownloadFormatPreferences$lambda$16(showAudioQualityDialog$delegate4);
            $composer3.startReplaceGroup(991605769);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            boolean invalid$iv7 = $composer3.changed(zDownloadFormatPreferences$lambda$16);
            Object it$iv18 = $composer3.rememberedValue();
            if (invalid$iv7) {
                showAudioQualityDialog$delegate = showAudioQualityDialog$delegate4;
            } else {
                showAudioQualityDialog$delegate = showAudioQualityDialog$delegate4;
                if (it$iv18 != Composer.INSTANCE.getEmpty()) {
                    value$iv8 = it$iv18;
                }
                MutableState audioQuality$delegate = (MutableState) value$iv8;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2044908879);
                ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
                $composer3.startReplaceGroup(-204592788);
                ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
                value$iv$iv8 = $composer3.rememberedValue();
                if (value$iv$iv8 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.VIDEO_CLIP, false, 1, null)), null, 2, null);
                    $composer3.updateRememberedValue(value$iv$iv8);
                }
                isVideoClipEnabled$delegate = (MutableState) value$iv$iv8;
                $composer3.endReplaceGroup();
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2044908879);
                ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
                $composer3.startReplaceGroup(-204592788);
                ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
                it$iv$iv = $composer3.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORMAT_SELECTION, false, 1, null)), null, 2, null);
                    $composer3.updateRememberedValue(value$iv$iv9);
                } else {
                    value$iv$iv9 = it$iv$iv;
                }
                MutableState isFormatSelectionEnabled$delegate = (MutableState) value$iv$iv9;
                $composer3.endReplaceGroup();
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2044908879);
                ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
                $composer3.startReplaceGroup(-204592788);
                ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
                it$iv$iv2 = $composer3.rememberedValue();
                if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.MERGE_MULTI_AUDIO_STREAM, false, 1, null)), null, 2, null);
                    $composer3.updateRememberedValue(value$iv$iv10);
                } else {
                    value$iv$iv10 = it$iv$iv2;
                }
                mergeAudioStream$delegate = (MutableState) value$iv$iv10;
                $composer3.endReplaceGroup();
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(991606080);
                ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer3.updateRememberedValue(value$iv9);
                } else {
                    value$iv9 = it$iv;
                }
                showMergeAudioDialog$delegate = (MutableState) value$iv9;
                $composer3.endReplaceGroup();
                Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(914682993, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.1
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
                        ComposerKt.sourceInformation($composer4, "C119@6094L99,114@5891L349:DownloadFormatPreferences.kt#5yb39d");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(914682993, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:114)");
                            }
                            Function2<Composer, Integer, Unit> function2M7351getLambda1$app_debug = ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7351getLambda1$app_debug();
                            final Function0<Unit> function0 = onNavigateBack;
                            TopAppBarKt.LargeTopAppBar(function2M7351getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-959186538, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.1.1
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
                                    Object value$iv28;
                                    ComposerKt.sourceInformation($composer5, "C120@6123L56,120@6112L67:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                        $composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-959186538, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:120)");
                                    }
                                    $composer5.startReplaceGroup(1600753571);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    boolean invalid$iv8 = $composer5.changed(function0);
                                    final Function0<Unit> function1 = function0;
                                    Object it$iv19 = $composer5.rememberedValue();
                                    if (invalid$iv8 || it$iv19 == Composer.INSTANCE.getEmpty()) {
                                        value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$1$1$1$1
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
                                        $composer5.updateRememberedValue(value$iv28);
                                    } else {
                                        value$iv28 = it$iv19;
                                    }
                                    $composer5.endReplaceGroup();
                                    IconButtonsKt.BackButton((Function0) value$iv28, $composer5, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer4, 54), null, scrollBehavior, $composer4, 390, 10);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54);
                showAudioQualityDialog$delegate2 = showAudioQualityDialog$delegate;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(audioFormat$delegate, isVideoClipEnabled$delegate2, audioQuality$delegate, convertAudio$delegate, embedMetadata$delegate, videoFormat$delegate2, videoQuality$delegate2, downloadSubtitle$delegate, embedSubtitle$delegate, remuxToMkv$delegate, navigateToSubtitlePage, isFormatSelectionEnabled$delegate, isVideoClipEnabled$delegate, mergeAudioStream$delegate, audioSwitch$delegate, showAudioFormatDialog$delegate2, showAudioQualityDialog$delegate2, convertFormat$delegate2, showAudioConvertDialog$delegate2, isArtworkCroppingEnabled$delegate, showVideoFormatDialog$delegate2, showVideoQualityDialog$delegate, showFormatSorterDialog$delegate4, showVideoClipDialog$delegate, showMergeAudioDialog$delegate);
                $composer2 = $composer3;
                ScaffoldKt.m2282ScaffoldTvnljyQ(modifierNestedScroll$default, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-16680762, true, anonymousClass2, $composer2, 54), $composer2, 805306416, 508);
                $composer2.startReplaceGroup(991617083);
                ComposerKt.sourceInformation($composer2, "333@16764L33,333@16746L51");
                if (DownloadFormatPreferences$lambda$13(showAudioFormatDialog$delegate2)) {
                    $composer2.startReplaceGroup(991617138);
                    str = "CC(remember):DownloadFormatPreferences.kt#9igjgp";
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv10 = $composer2.rememberedValue();
                    if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                        showAudioFormatDialog$delegate = showAudioFormatDialog$delegate2;
                        value$iv22 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$3$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$14(showAudioFormatDialog$delegate, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv22);
                    } else {
                        showAudioFormatDialog$delegate = showAudioFormatDialog$delegate2;
                        value$iv22 = it$iv10;
                    }
                    $composer2.endReplaceGroup();
                    FormatSettingDialogsKt.AudioFormatDialog((Function0) value$iv22, $composer2, 6);
                } else {
                    str = "CC(remember):DownloadFormatPreferences.kt#9igjgp";
                    showAudioFormatDialog$delegate = showAudioFormatDialog$delegate2;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991617182);
                ComposerKt.sourceInformation($composer2, "336@16865L34,336@16846L53");
                if (DownloadFormatPreferences$lambda$16(showAudioQualityDialog$delegate2)) {
                    $composer2.startReplaceGroup(991617239);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv9 = $composer2.rememberedValue();
                    if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                        isFormatSortingEnabled$delegate = showAudioQualityDialog$delegate2;
                        value$iv21 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$4$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$17(isFormatSortingEnabled$delegate, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv21);
                    } else {
                        isFormatSortingEnabled$delegate = showAudioQualityDialog$delegate2;
                        value$iv21 = it$iv9;
                    }
                    $composer2.endReplaceGroup();
                    FormatSettingDialogsKt.AudioQualityDialog((Function0) value$iv21, $composer2, 6);
                } else {
                    isFormatSortingEnabled$delegate = showAudioQualityDialog$delegate2;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991617284);
                ComposerKt.sourceInformation($composer2, "339@16989L34,339@17025L79,339@16948L156");
                if (DownloadFormatPreferences$lambda$19(showAudioConvertDialog$delegate2)) {
                    $composer2.startReplaceGroup(991617363);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv7 = $composer2.rememberedValue();
                    if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                        showAudioConvertDialog$delegate = showAudioConvertDialog$delegate2;
                        value$iv19 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$5$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$20(showAudioConvertDialog$delegate, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv19);
                    } else {
                        showAudioConvertDialog$delegate = showAudioConvertDialog$delegate2;
                        value$iv19 = it$iv7;
                    }
                    Function0 function0 = (Function0) value$iv19;
                    $composer2.endReplaceGroup();
                    $composer2.startReplaceGroup(991617399);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv8 = $composer2.rememberedValue();
                    if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                        showAudioQualityDialog$delegate3 = convertFormat$delegate2;
                        value$iv20 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$6$1
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
                                showAudioQualityDialog$delegate3.setValue(PreferenceStrings.getAudioConvertDesc$default(PreferenceStrings.INSTANCE, 0, 1, null));
                            }
                        };
                        $composer2.updateRememberedValue(value$iv20);
                    } else {
                        showAudioQualityDialog$delegate3 = convertFormat$delegate2;
                        value$iv20 = it$iv8;
                    }
                    $composer2.endReplaceGroup();
                    z = false;
                    FormatSettingDialogsKt.AudioConversionDialog(function0, (Function0) value$iv20, $composer2, 54, 0);
                } else {
                    showAudioQualityDialog$delegate3 = convertFormat$delegate2;
                    z = false;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991617489);
                ComposerKt.sourceInformation($composer2, "345@17232L34,345@17268L81,344@17153L196");
                if (DownloadFormatPreferences$lambda$22(showVideoQualityDialog$delegate)) {
                    int iDownloadFormatPreferences$lambda$35 = DownloadFormatPreferences$lambda$35(videoQuality$delegate2);
                    $composer2.startReplaceGroup(991617606);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv6 = $composer2.rememberedValue();
                    if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                        convertFormat$delegate = showVideoQualityDialog$delegate;
                        value$iv17 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$7$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$23(convertFormat$delegate, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv17);
                    } else {
                        convertFormat$delegate = showVideoQualityDialog$delegate;
                        value$iv17 = it$iv6;
                    }
                    Function0 function1 = (Function0) value$iv17;
                    $composer2.endReplaceGroup();
                    $composer2.startReplaceGroup(991617642);
                    ComposerKt.sourceInformation($composer2, str);
                    videoQuality$delegate = videoQuality$delegate2;
                    invalid$iv4 = $composer2.changed(videoQuality$delegate);
                    Object it$iv19 = $composer2.rememberedValue();
                    if (!invalid$iv4 || it$iv19 == Composer.INSTANCE.getEmpty()) {
                        value$iv18 = (Function1) new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$8$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int it) {
                                videoQuality$delegate.setIntValue(it);
                                PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.VIDEO_QUALITY, it);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv18);
                    } else {
                        value$iv18 = it$iv19;
                    }
                    $composer2.endReplaceGroup();
                    FormatSettingDialogsKt.VideoQualityDialog(iDownloadFormatPreferences$lambda$35, function1, (Function1) value$iv18, $composer2, 48, 0);
                } else {
                    videoQuality$delegate = videoQuality$delegate2;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991617734);
                ComposerKt.sourceInformation($composer2, "351@17471L53,353@17526L95,351@17397L224");
                if (DownloadFormatPreferences$lambda$25(showVideoFormatDialog$delegate2)) {
                    int iDownloadFormatPreferences$lambda$33 = DownloadFormatPreferences$lambda$33(videoFormat$delegate2);
                    $composer2.startReplaceGroup(991617845);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv5 = $composer2.rememberedValue();
                    if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                        showVideoFormatDialog$delegate = showVideoFormatDialog$delegate2;
                        value$iv15 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$9$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$26(showVideoFormatDialog$delegate, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv15);
                    } else {
                        showVideoFormatDialog$delegate = showVideoFormatDialog$delegate2;
                        value$iv15 = it$iv5;
                    }
                    Function0 function2 = (Function0) value$iv15;
                    $composer2.endReplaceGroup();
                    $composer2.startReplaceGroup(991617900);
                    ComposerKt.sourceInformation($composer2, str);
                    videoFormat$delegate = videoFormat$delegate2;
                    invalid$iv3 = $composer2.changed(videoFormat$delegate);
                    Object it$iv20 = $composer2.rememberedValue();
                    if (!invalid$iv3 || it$iv20 == Composer.INSTANCE.getEmpty()) {
                        value$iv16 = (Function1) new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$10$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int it) {
                                PreferenceUtil.INSTANCE.encodeInt(PreferenceUtilKt.VIDEO_FORMAT, it);
                                videoFormat$delegate.setIntValue(it);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv16);
                    } else {
                        value$iv16 = it$iv20;
                    }
                    $composer2.endReplaceGroup();
                    FormatSettingDialogsKt.VideoFormatDialog(iDownloadFormatPreferences$lambda$33, function2, (Function1) value$iv16, $composer2, 48, 0);
                } else {
                    videoFormat$delegate = videoFormat$delegate2;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991618006);
                ComposerKt.sourceInformation($composer2, "361@17750L99,364@17882L34,365@17962L109,359@17670L411");
                if (DownloadFormatPreferences$lambda$28(showFormatSorterDialog$delegate4)) {
                    String strDownloadFormatPreferences$lambda$41 = DownloadFormatPreferences$lambda$41(sortingFields$delegate2);
                    $composer2.startReplaceGroup(991618124);
                    ComposerKt.sourceInformation($composer2, str);
                    sortingFields$delegate = sortingFields$delegate2;
                    invalid$iv = $composer2.changed(sortingFields$delegate);
                    Object it$iv21 = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv21 == Composer.INSTANCE.getEmpty()) {
                        value$iv12 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$11$1
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
                                sortingFields$delegate.setValue(DownloadUtil.INSTANCE.toFormatSorter(new DownloadUtil.DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null)));
                            }
                        };
                        $composer2.updateRememberedValue(value$iv12);
                    } else {
                        value$iv12 = it$iv21;
                    }
                    Function0 function3 = (Function0) value$iv12;
                    $composer2.endReplaceGroup();
                    $composer2.startReplaceGroup(991618256);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv4 = $composer2.rememberedValue();
                    if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                        showFormatSorterDialog$delegate3 = showFormatSorterDialog$delegate4;
                        value$iv13 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$12$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$29(showFormatSorterDialog$delegate3, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv13);
                    } else {
                        showFormatSorterDialog$delegate3 = showFormatSorterDialog$delegate4;
                        value$iv13 = it$iv4;
                    }
                    Function0 function4 = (Function0) value$iv13;
                    $composer2.endReplaceGroup();
                    $composer2.startReplaceGroup(991618336);
                    ComposerKt.sourceInformation($composer2, str);
                    invalid$iv2 = $composer2.changed(sortingFields$delegate);
                    Object it$iv22 = $composer2.rememberedValue();
                    if (!invalid$iv2 || it$iv22 == Composer.INSTANCE.getEmpty()) {
                        value$iv14 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$13$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                invoke2(str2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                sortingFields$delegate.setValue(it);
                                PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.SORTING_FIELDS, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$41(sortingFields$delegate));
                            }
                        };
                        $composer2.updateRememberedValue(value$iv14);
                    } else {
                        value$iv14 = it$iv22;
                    }
                    $composer2.endReplaceGroup();
                    showFormatSorterDialog$delegate = showFormatSorterDialog$delegate3;
                    FormatSettingDialogsKt.FormatSortingDialog(strDownloadFormatPreferences$lambda$41, false, false, null, function3, function4, (Function1) value$iv14, $composer2, 196656, 12);
                } else {
                    sortingFields$delegate = sortingFields$delegate2;
                    showFormatSorterDialog$delegate = showFormatSorterDialog$delegate4;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991618466);
                ComposerKt.sourceInformation($composer2, "372@18158L31,374@18281L210,381@18521L113,372@18127L823");
                if (DownloadFormatPreferences$lambda$31(showVideoClipDialog$delegate)) {
                    $composer2.startReplaceGroup(991618532);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv3 = $composer2.rememberedValue();
                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                        showFormatSorterDialog$delegate2 = showVideoClipDialog$delegate;
                        value$iv11 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$14$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$32(showFormatSorterDialog$delegate2, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv11);
                    } else {
                        showFormatSorterDialog$delegate2 = showVideoClipDialog$delegate;
                        value$iv11 = it$iv3;
                    }
                    $composer2.endReplaceGroup();
                    AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0((Function0) value$iv11, ComposableLambdaKt.rememberComposableLambda(2022667782, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.15
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
                            Object value$iv28;
                            ComposerKt.sourceInformation($composer4, "C375@18313L164,375@18299L178:DownloadFormatPreferences.kt#5yb39d");
                            if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2022667782, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:375)");
                            }
                            $composer4.startReplaceGroup(754788256);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                            boolean invalid$iv8 = $composer4.changed(isVideoClipEnabled$delegate);
                            final MutableState<Boolean> mutableState = isVideoClipEnabled$delegate;
                            final MutableState<Boolean> mutableState2 = showFormatSorterDialog$delegate2;
                            Object it$iv23 = $composer4.rememberedValue();
                            if (invalid$iv8 || it$iv23 == Composer.INSTANCE.getEmpty()) {
                                value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$15$1$1
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
                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$52(mutableState, true);
                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.VIDEO_CLIP, true);
                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$32(mutableState2, false);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv28);
                            } else {
                                value$iv28 = it$iv23;
                            }
                            $composer4.endReplaceGroup();
                            ButtonsKt.ConfirmButton(null, false, (Function0) value$iv28, $composer4, 0, 3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(-1623706744, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.16
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
                            Object value$iv28;
                            ComposerKt.sourceInformation($composer4, "C382@18553L67,382@18539L81:DownloadFormatPreferences.kt#5yb39d");
                            if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1623706744, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:382)");
                            }
                            $composer4.startReplaceGroup(754788496);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                            final MutableState<Boolean> mutableState = showFormatSorterDialog$delegate2;
                            Object it$iv23 = $composer4.rememberedValue();
                            if (it$iv23 == Composer.INSTANCE.getEmpty()) {
                                value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$16$1$1
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
                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$32(mutableState, false);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv28);
                            } else {
                                value$iv28 = it$iv23;
                            }
                            $composer4.endReplaceGroup();
                            ButtonsKt.DismissButton(null, (Function0) value$iv28, $composer4, 48, 1);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7360getLambda7$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7361getLambda8$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7362getLambda9$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
                }
                $composer2.endReplaceGroup();
                if (DownloadFormatPreferences$lambda$58(showMergeAudioDialog$delegate)) {
                    $composer2.startReplaceGroup(991619402);
                    ComposerKt.sourceInformation($composer2, str);
                    it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        showMergeAudioDialog$delegate2 = showMergeAudioDialog$delegate;
                        value$iv10 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$17$1
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
                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$59(showMergeAudioDialog$delegate2, false);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv10);
                    } else {
                        showMergeAudioDialog$delegate2 = showMergeAudioDialog$delegate;
                        value$iv10 = it$iv2;
                    }
                    $composer2.endReplaceGroup();
                    AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0((Function0) value$iv10, ComposableLambdaKt.rememberComposableLambda(-395030619, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.18
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
                            Object value$iv28;
                            ComposerKt.sourceInformation($composer4, "C400@19189L177,400@19175L191:DownloadFormatPreferences.kt#5yb39d");
                            if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-395030619, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:400)");
                            }
                            $composer4.startReplaceGroup(754789132);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                            boolean invalid$iv8 = $composer4.changed(mergeAudioStream$delegate);
                            final MutableState<Boolean> mutableState = mergeAudioStream$delegate;
                            final MutableState<Boolean> mutableState2 = showMergeAudioDialog$delegate2;
                            Object it$iv23 = $composer4.rememberedValue();
                            if (invalid$iv8 || it$iv23 == Composer.INSTANCE.getEmpty()) {
                                value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$18$1$1
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
                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$56(mutableState, true);
                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.MERGE_MULTI_AUDIO_STREAM, true);
                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$59(mutableState2, false);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv28);
                            } else {
                                value$iv28 = it$iv23;
                            }
                            $composer4.endReplaceGroup();
                            ButtonsKt.ConfirmButton(null, false, (Function0) value$iv28, $composer4, 0, 3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(253562151, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.19
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
                            Object value$iv28;
                            ComposerKt.sourceInformation($composer4, "C407@19442L68,407@19428L82:DownloadFormatPreferences.kt#5yb39d");
                            if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(253562151, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:407)");
                            }
                            $composer4.startReplaceGroup(754789385);
                            ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                            final MutableState<Boolean> mutableState = showMergeAudioDialog$delegate2;
                            Object it$iv23 = $composer4.rememberedValue();
                            if (it$iv23 == Composer.INSTANCE.getEmpty()) {
                                value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$19$1$1
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
                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$59(mutableState, false);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv28);
                            } else {
                                value$iv28 = it$iv23;
                            }
                            $composer4.endReplaceGroup();
                            ButtonsKt.DismissButton(null, (Function0) value$iv28, $composer4, 48, 1);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7352getLambda10$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7353getLambda11$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7354getLambda12$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PreferenceStrings.getAudioQualityDesc$default(PreferenceStrings.INSTANCE, 0, 1, null), null, 2, null);
            $composer3.updateRememberedValue(value$iv8);
            MutableState audioQuality$delegate2 = (MutableState) value$iv8;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            value$iv$iv8 = $composer3.rememberedValue();
            if (value$iv$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.VIDEO_CLIP, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv8);
            }
            isVideoClipEnabled$delegate = (MutableState) value$iv$iv8;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.FORMAT_SELECTION, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv9);
            } else {
                value$iv$iv9 = it$iv$iv;
            }
            MutableState isFormatSelectionEnabled$delegate2 = (MutableState) value$iv$iv9;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer3, "CC12@469L46:Ext.kt#x6o9ax");
            $composer3.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer3, "CC(remember):Ext.kt#9igjgp");
            it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.MERGE_MULTI_AUDIO_STREAM, false, 1, null)), null, 2, null);
                $composer3.updateRememberedValue(value$iv$iv10);
            } else {
                value$iv$iv10 = it$iv$iv2;
            }
            mergeAudioStream$delegate = (MutableState) value$iv$iv10;
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(991606080);
            ComposerKt.sourceInformation($composer3, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv9);
            } else {
                value$iv9 = it$iv;
            }
            showMergeAudioDialog$delegate = (MutableState) value$iv9;
            $composer3.endReplaceGroup();
            Modifier modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollBehavior.getNestedScrollConnection(), null, 2, null);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(914682993, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.1
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
                    ComposerKt.sourceInformation($composer4, "C119@6094L99,114@5891L349:DownloadFormatPreferences.kt#5yb39d");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(914682993, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:114)");
                        }
                        Function2<Composer, Integer, Unit> function2M7351getLambda1$app_debug = ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7351getLambda1$app_debug();
                        final Function0<Unit> function5 = onNavigateBack;
                        TopAppBarKt.LargeTopAppBar(function2M7351getLambda1$app_debug, null, ComposableLambdaKt.rememberComposableLambda(-959186538, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.1.1
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
                                Object value$iv28;
                                ComposerKt.sourceInformation($composer5, "C120@6123L56,120@6112L67:DownloadFormatPreferences.kt#5yb39d");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-959186538, $changed3, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:120)");
                                }
                                $composer5.startReplaceGroup(1600753571);
                                ComposerKt.sourceInformation($composer5, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                boolean invalid$iv8 = $composer5.changed(function5);
                                final Function0<Unit> function6 = function5;
                                Object it$iv110 = $composer5.rememberedValue();
                                if (invalid$iv8 || it$iv110 == Composer.INSTANCE.getEmpty()) {
                                    value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$1$1$1$1
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
                                            function6.invoke();
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv28);
                                } else {
                                    value$iv28 = it$iv110;
                                }
                                $composer5.endReplaceGroup();
                                IconButtonsKt.BackButton((Function0) value$iv28, $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), null, scrollBehavior, $composer4, 390, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54);
            showAudioQualityDialog$delegate2 = showAudioQualityDialog$delegate;
            AnonymousClass2 anonymousClass3 = new AnonymousClass2(audioFormat$delegate, isVideoClipEnabled$delegate2, audioQuality$delegate2, convertAudio$delegate, embedMetadata$delegate, videoFormat$delegate2, videoQuality$delegate2, downloadSubtitle$delegate, embedSubtitle$delegate, remuxToMkv$delegate, navigateToSubtitlePage, isFormatSelectionEnabled$delegate2, isVideoClipEnabled$delegate, mergeAudioStream$delegate, audioSwitch$delegate, showAudioFormatDialog$delegate2, showAudioQualityDialog$delegate2, convertFormat$delegate2, showAudioConvertDialog$delegate2, isArtworkCroppingEnabled$delegate, showVideoFormatDialog$delegate2, showVideoQualityDialog$delegate, showFormatSorterDialog$delegate4, showVideoClipDialog$delegate, showMergeAudioDialog$delegate);
            $composer2 = $composer3;
            ScaffoldKt.m2282ScaffoldTvnljyQ(modifierNestedScroll$default2, composableLambdaRememberComposableLambda2, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-16680762, true, anonymousClass3, $composer2, 54), $composer2, 805306416, 508);
            $composer2.startReplaceGroup(991617083);
            ComposerKt.sourceInformation($composer2, "333@16764L33,333@16746L51");
            if (DownloadFormatPreferences$lambda$13(showAudioFormatDialog$delegate2)) {
                $composer2.startReplaceGroup(991617138);
                str = "CC(remember):DownloadFormatPreferences.kt#9igjgp";
                ComposerKt.sourceInformation($composer2, str);
                it$iv10 = $composer2.rememberedValue();
                if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                    showAudioFormatDialog$delegate = showAudioFormatDialog$delegate2;
                    value$iv22 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$3$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$14(showAudioFormatDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv22);
                } else {
                    showAudioFormatDialog$delegate = showAudioFormatDialog$delegate2;
                    value$iv22 = it$iv10;
                }
                $composer2.endReplaceGroup();
                FormatSettingDialogsKt.AudioFormatDialog((Function0) value$iv22, $composer2, 6);
            } else {
                str = "CC(remember):DownloadFormatPreferences.kt#9igjgp";
                showAudioFormatDialog$delegate = showAudioFormatDialog$delegate2;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(991617182);
            ComposerKt.sourceInformation($composer2, "336@16865L34,336@16846L53");
            if (DownloadFormatPreferences$lambda$16(showAudioQualityDialog$delegate2)) {
                $composer2.startReplaceGroup(991617239);
                ComposerKt.sourceInformation($composer2, str);
                it$iv9 = $composer2.rememberedValue();
                if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                    isFormatSortingEnabled$delegate = showAudioQualityDialog$delegate2;
                    value$iv21 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$4$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$17(isFormatSortingEnabled$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv21);
                } else {
                    isFormatSortingEnabled$delegate = showAudioQualityDialog$delegate2;
                    value$iv21 = it$iv9;
                }
                $composer2.endReplaceGroup();
                FormatSettingDialogsKt.AudioQualityDialog((Function0) value$iv21, $composer2, 6);
            } else {
                isFormatSortingEnabled$delegate = showAudioQualityDialog$delegate2;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(991617284);
            ComposerKt.sourceInformation($composer2, "339@16989L34,339@17025L79,339@16948L156");
            if (DownloadFormatPreferences$lambda$19(showAudioConvertDialog$delegate2)) {
                $composer2.startReplaceGroup(991617363);
                ComposerKt.sourceInformation($composer2, str);
                it$iv7 = $composer2.rememberedValue();
                if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                    showAudioConvertDialog$delegate = showAudioConvertDialog$delegate2;
                    value$iv19 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$5$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$20(showAudioConvertDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv19);
                } else {
                    showAudioConvertDialog$delegate = showAudioConvertDialog$delegate2;
                    value$iv19 = it$iv7;
                }
                Function0 function5 = (Function0) value$iv19;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991617399);
                ComposerKt.sourceInformation($composer2, str);
                it$iv8 = $composer2.rememberedValue();
                if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                    showAudioQualityDialog$delegate3 = convertFormat$delegate2;
                    value$iv20 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$6$1
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
                            showAudioQualityDialog$delegate3.setValue(PreferenceStrings.getAudioConvertDesc$default(PreferenceStrings.INSTANCE, 0, 1, null));
                        }
                    };
                    $composer2.updateRememberedValue(value$iv20);
                } else {
                    showAudioQualityDialog$delegate3 = convertFormat$delegate2;
                    value$iv20 = it$iv8;
                }
                $composer2.endReplaceGroup();
                z = false;
                FormatSettingDialogsKt.AudioConversionDialog(function5, (Function0) value$iv20, $composer2, 54, 0);
            } else {
                showAudioQualityDialog$delegate3 = convertFormat$delegate2;
                z = false;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(991617489);
            ComposerKt.sourceInformation($composer2, "345@17232L34,345@17268L81,344@17153L196");
            if (DownloadFormatPreferences$lambda$22(showVideoQualityDialog$delegate)) {
                int iDownloadFormatPreferences$lambda$36 = DownloadFormatPreferences$lambda$35(videoQuality$delegate2);
                $composer2.startReplaceGroup(991617606);
                ComposerKt.sourceInformation($composer2, str);
                it$iv6 = $composer2.rememberedValue();
                if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                    convertFormat$delegate = showVideoQualityDialog$delegate;
                    value$iv17 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$7$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$23(convertFormat$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv17);
                } else {
                    convertFormat$delegate = showVideoQualityDialog$delegate;
                    value$iv17 = it$iv6;
                }
                Function0 function6 = (Function0) value$iv17;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991617642);
                ComposerKt.sourceInformation($composer2, str);
                videoQuality$delegate = videoQuality$delegate2;
                invalid$iv4 = $composer2.changed(videoQuality$delegate);
                Object it$iv110 = $composer2.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv18 = (Function1) new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$8$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int it) {
                        videoQuality$delegate.setIntValue(it);
                        PreferenceUtil.INSTANCE.updateInt(PreferenceUtilKt.VIDEO_QUALITY, it);
                    }
                };
                $composer2.updateRememberedValue(value$iv18);
                $composer2.endReplaceGroup();
                FormatSettingDialogsKt.VideoQualityDialog(iDownloadFormatPreferences$lambda$36, function6, (Function1) value$iv18, $composer2, 48, 0);
            } else {
                videoQuality$delegate = videoQuality$delegate2;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(991617734);
            ComposerKt.sourceInformation($composer2, "351@17471L53,353@17526L95,351@17397L224");
            if (DownloadFormatPreferences$lambda$25(showVideoFormatDialog$delegate2)) {
                int iDownloadFormatPreferences$lambda$34 = DownloadFormatPreferences$lambda$33(videoFormat$delegate2);
                $composer2.startReplaceGroup(991617845);
                ComposerKt.sourceInformation($composer2, str);
                it$iv5 = $composer2.rememberedValue();
                if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                    showVideoFormatDialog$delegate = showVideoFormatDialog$delegate2;
                    value$iv15 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$9$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$26(showVideoFormatDialog$delegate, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv15);
                } else {
                    showVideoFormatDialog$delegate = showVideoFormatDialog$delegate2;
                    value$iv15 = it$iv5;
                }
                Function0 function7 = (Function0) value$iv15;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991617900);
                ComposerKt.sourceInformation($composer2, str);
                videoFormat$delegate = videoFormat$delegate2;
                invalid$iv3 = $composer2.changed(videoFormat$delegate);
                Object it$iv23 = $composer2.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv16 = (Function1) new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$10$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int it) {
                        PreferenceUtil.INSTANCE.encodeInt(PreferenceUtilKt.VIDEO_FORMAT, it);
                        videoFormat$delegate.setIntValue(it);
                    }
                };
                $composer2.updateRememberedValue(value$iv16);
                $composer2.endReplaceGroup();
                FormatSettingDialogsKt.VideoFormatDialog(iDownloadFormatPreferences$lambda$34, function7, (Function1) value$iv16, $composer2, 48, 0);
            } else {
                videoFormat$delegate = videoFormat$delegate2;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(991618006);
            ComposerKt.sourceInformation($composer2, "361@17750L99,364@17882L34,365@17962L109,359@17670L411");
            if (DownloadFormatPreferences$lambda$28(showFormatSorterDialog$delegate4)) {
                String strDownloadFormatPreferences$lambda$42 = DownloadFormatPreferences$lambda$41(sortingFields$delegate2);
                $composer2.startReplaceGroup(991618124);
                ComposerKt.sourceInformation($composer2, str);
                sortingFields$delegate = sortingFields$delegate2;
                invalid$iv = $composer2.changed(sortingFields$delegate);
                Object it$iv24 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                value$iv12 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$11$1
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
                        sortingFields$delegate.setValue(DownloadUtil.INSTANCE.toFormatSorter(new DownloadUtil.DownloadPreferences(false, false, false, false, false, null, false, false, false, null, false, false, 0, 0, false, null, false, false, 0, 0, false, false, null, 0, 0, null, 0, false, false, null, false, false, false, null, false, null, false, false, false, null, null, null, null, false, false, false, false, false, false, false, -1, LayoutUtilsKt.BigConstraintValue, null)));
                    }
                };
                $composer2.updateRememberedValue(value$iv12);
                Function0 function8 = (Function0) value$iv12;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991618256);
                ComposerKt.sourceInformation($composer2, str);
                it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                    showFormatSorterDialog$delegate3 = showFormatSorterDialog$delegate4;
                    value$iv13 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$12$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$29(showFormatSorterDialog$delegate3, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv13);
                } else {
                    showFormatSorterDialog$delegate3 = showFormatSorterDialog$delegate4;
                    value$iv13 = it$iv4;
                }
                Function0 function9 = (Function0) value$iv13;
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(991618336);
                ComposerKt.sourceInformation($composer2, str);
                invalid$iv2 = $composer2.changed(sortingFields$delegate);
                Object it$iv25 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                value$iv14 = (Function1) new Function1<String, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$13$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        sortingFields$delegate.setValue(it);
                        PreferenceUtil.INSTANCE.updateString(PreferenceUtilKt.SORTING_FIELDS, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$41(sortingFields$delegate));
                    }
                };
                $composer2.updateRememberedValue(value$iv14);
                $composer2.endReplaceGroup();
                showFormatSorterDialog$delegate = showFormatSorterDialog$delegate3;
                FormatSettingDialogsKt.FormatSortingDialog(strDownloadFormatPreferences$lambda$42, false, false, null, function8, function9, (Function1) value$iv14, $composer2, 196656, 12);
            } else {
                sortingFields$delegate = sortingFields$delegate2;
                showFormatSorterDialog$delegate = showFormatSorterDialog$delegate4;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(991618466);
            ComposerKt.sourceInformation($composer2, "372@18158L31,374@18281L210,381@18521L113,372@18127L823");
            if (DownloadFormatPreferences$lambda$31(showVideoClipDialog$delegate)) {
                $composer2.startReplaceGroup(991618532);
                ComposerKt.sourceInformation($composer2, str);
                it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                    showFormatSorterDialog$delegate2 = showVideoClipDialog$delegate;
                    value$iv11 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$14$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$32(showFormatSorterDialog$delegate2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv11);
                } else {
                    showFormatSorterDialog$delegate2 = showVideoClipDialog$delegate;
                    value$iv11 = it$iv3;
                }
                $composer2.endReplaceGroup();
                AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0((Function0) value$iv11, ComposableLambdaKt.rememberComposableLambda(2022667782, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.15
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
                        Object value$iv28;
                        ComposerKt.sourceInformation($composer4, "C375@18313L164,375@18299L178:DownloadFormatPreferences.kt#5yb39d");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2022667782, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:375)");
                        }
                        $composer4.startReplaceGroup(754788256);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                        boolean invalid$iv8 = $composer4.changed(isVideoClipEnabled$delegate);
                        final MutableState<Boolean> mutableState = isVideoClipEnabled$delegate;
                        final MutableState<Boolean> mutableState2 = showFormatSorterDialog$delegate2;
                        Object it$iv26 = $composer4.rememberedValue();
                        if (invalid$iv8 || it$iv26 == Composer.INSTANCE.getEmpty()) {
                            value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$15$1$1
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
                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$52(mutableState, true);
                                    PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.VIDEO_CLIP, true);
                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$32(mutableState2, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv28);
                        } else {
                            value$iv28 = it$iv26;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.ConfirmButton(null, false, (Function0) value$iv28, $composer4, 0, 3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(-1623706744, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.16
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
                        Object value$iv28;
                        ComposerKt.sourceInformation($composer4, "C382@18553L67,382@18539L81:DownloadFormatPreferences.kt#5yb39d");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1623706744, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:382)");
                        }
                        $composer4.startReplaceGroup(754788496);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                        final MutableState<Boolean> mutableState = showFormatSorterDialog$delegate2;
                        Object it$iv26 = $composer4.rememberedValue();
                        if (it$iv26 == Composer.INSTANCE.getEmpty()) {
                            value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$16$1$1
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
                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$32(mutableState, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv28);
                        } else {
                            value$iv28 = it$iv26;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv28, $composer4, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7360getLambda7$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7361getLambda8$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7362getLambda9$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
            }
            $composer2.endReplaceGroup();
            if (DownloadFormatPreferences$lambda$58(showMergeAudioDialog$delegate)) {
                $composer2.startReplaceGroup(991619402);
                ComposerKt.sourceInformation($composer2, str);
                it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    showMergeAudioDialog$delegate2 = showMergeAudioDialog$delegate;
                    value$iv10 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$17$1
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
                            DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$59(showMergeAudioDialog$delegate2, false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv10);
                } else {
                    showMergeAudioDialog$delegate2 = showMergeAudioDialog$delegate;
                    value$iv10 = it$iv2;
                }
                $composer2.endReplaceGroup();
                AndroidAlertDialog_androidKt.m1663AlertDialogOix01E0((Function0) value$iv10, ComposableLambdaKt.rememberComposableLambda(-395030619, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.18
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
                        Object value$iv28;
                        ComposerKt.sourceInformation($composer4, "C400@19189L177,400@19175L191:DownloadFormatPreferences.kt#5yb39d");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-395030619, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:400)");
                        }
                        $composer4.startReplaceGroup(754789132);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                        boolean invalid$iv8 = $composer4.changed(mergeAudioStream$delegate);
                        final MutableState<Boolean> mutableState = mergeAudioStream$delegate;
                        final MutableState<Boolean> mutableState2 = showMergeAudioDialog$delegate2;
                        Object it$iv26 = $composer4.rememberedValue();
                        if (invalid$iv8 || it$iv26 == Composer.INSTANCE.getEmpty()) {
                            value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$18$1$1
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
                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$56(mutableState, true);
                                    PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.MERGE_MULTI_AUDIO_STREAM, true);
                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$59(mutableState2, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv28);
                        } else {
                            value$iv28 = it$iv26;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.ConfirmButton(null, false, (Function0) value$iv28, $composer4, 0, 3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(253562151, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.19
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
                        Object value$iv28;
                        ComposerKt.sourceInformation($composer4, "C407@19442L68,407@19428L82:DownloadFormatPreferences.kt#5yb39d");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(253562151, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:407)");
                        }
                        $composer4.startReplaceGroup(754789385);
                        ComposerKt.sourceInformation($composer4, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                        final MutableState<Boolean> mutableState = showMergeAudioDialog$delegate2;
                        Object it$iv26 = $composer4.rememberedValue();
                        if (it$iv26 == Composer.INSTANCE.getEmpty()) {
                            value$iv28 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$19$1$1
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
                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$59(mutableState, false);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv28);
                        } else {
                            value$iv28 = it$iv26;
                        }
                        $composer4.endReplaceGroup();
                        ButtonsKt.DismissButton(null, (Function0) value$iv28, $composer4, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7352getLambda10$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7353getLambda11$app_debug(), ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7354getLambda12$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt.DownloadFormatPreferences.20
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
                    DownloadFormatPreferencesKt.DownloadFormatPreferences(onNavigateBack, navigateToSubtitlePage, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$6(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$7(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$8(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$9(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$10(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$11(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$13(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$14(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$16(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$17(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$19(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$20(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$22(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$23(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$25(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$26(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$28(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$29(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$31(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$32(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DownloadFormatPreferences$lambda$33(MutableIntState $videoFormat$delegate) {
        MutableIntState $this$getValue$iv = $videoFormat$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DownloadFormatPreferences$lambda$35(MutableIntState $videoQuality$delegate) {
        MutableIntState $this$getValue$iv = $videoQuality$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadFormatPreferences$lambda$38(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadFormatPreferences$lambda$41(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadFormatPreferences$lambda$44(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$45(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$46(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$47(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$48(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DownloadFormatPreferences$lambda$50(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$51(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$52(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$53(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$54(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DownloadFormatPreferences$lambda$55(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$56(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean DownloadFormatPreferences$lambda$58(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloadFormatPreferences$lambda$59(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFormatPreferences.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/layout/PaddingValues;", "invoke", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class AnonymousClass2 extends Lambda implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<String> $audioFormat$delegate;
        final /* synthetic */ MutableState<String> $audioQuality$delegate;
        final /* synthetic */ MutableState<Boolean> $audioSwitch$delegate;
        final /* synthetic */ MutableState<Boolean> $convertAudio$delegate;
        final /* synthetic */ MutableState<String> $convertFormat$delegate;
        final /* synthetic */ MutableState<Boolean> $downloadSubtitle$delegate;
        final /* synthetic */ MutableState<Boolean> $embedMetadata$delegate;
        final /* synthetic */ MutableState<Boolean> $embedSubtitle$delegate;
        final /* synthetic */ MutableState<Boolean> $isArtworkCroppingEnabled$delegate;
        final /* synthetic */ MutableState<Boolean> $isFormatSelectionEnabled$delegate;
        final /* synthetic */ MutableState<Boolean> $isFormatSortingEnabled$delegate;
        final /* synthetic */ MutableState<Boolean> $isVideoClipEnabled$delegate;
        final /* synthetic */ MutableState<Boolean> $mergeAudioStream$delegate;
        final /* synthetic */ Function0<Unit> $navigateToSubtitlePage;
        final /* synthetic */ MutableState<Boolean> $remuxToMkv$delegate;
        final /* synthetic */ MutableState<Boolean> $showAudioConvertDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showAudioFormatDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showAudioQualityDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showFormatSorterDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showMergeAudioDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showVideoClipDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showVideoFormatDialog$delegate;
        final /* synthetic */ MutableState<Boolean> $showVideoQualityDialog$delegate;
        final /* synthetic */ MutableIntState $videoFormat$delegate;
        final /* synthetic */ MutableIntState $videoQuality$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<String> mutableState3, MutableState<Boolean> mutableState4, MutableState<Boolean> mutableState5, MutableIntState mutableIntState, MutableIntState mutableIntState2, MutableState<Boolean> mutableState6, MutableState<Boolean> mutableState7, MutableState<Boolean> mutableState8, Function0<Unit> function0, MutableState<Boolean> mutableState9, MutableState<Boolean> mutableState10, MutableState<Boolean> mutableState11, MutableState<Boolean> mutableState12, MutableState<Boolean> mutableState13, MutableState<Boolean> mutableState14, MutableState<String> mutableState15, MutableState<Boolean> mutableState16, MutableState<Boolean> mutableState17, MutableState<Boolean> mutableState18, MutableState<Boolean> mutableState19, MutableState<Boolean> mutableState20, MutableState<Boolean> mutableState21, MutableState<Boolean> mutableState22) {
            super(3);
            this.$audioFormat$delegate = mutableState;
            this.$isFormatSortingEnabled$delegate = mutableState2;
            this.$audioQuality$delegate = mutableState3;
            this.$convertAudio$delegate = mutableState4;
            this.$embedMetadata$delegate = mutableState5;
            this.$videoFormat$delegate = mutableIntState;
            this.$videoQuality$delegate = mutableIntState2;
            this.$downloadSubtitle$delegate = mutableState6;
            this.$embedSubtitle$delegate = mutableState7;
            this.$remuxToMkv$delegate = mutableState8;
            this.$navigateToSubtitlePage = function0;
            this.$isFormatSelectionEnabled$delegate = mutableState9;
            this.$isVideoClipEnabled$delegate = mutableState10;
            this.$mergeAudioStream$delegate = mutableState11;
            this.$audioSwitch$delegate = mutableState12;
            this.$showAudioFormatDialog$delegate = mutableState13;
            this.$showAudioQualityDialog$delegate = mutableState14;
            this.$convertFormat$delegate = mutableState15;
            this.$showAudioConvertDialog$delegate = mutableState16;
            this.$isArtworkCroppingEnabled$delegate = mutableState17;
            this.$showVideoFormatDialog$delegate = mutableState18;
            this.$showVideoQualityDialog$delegate = mutableState19;
            this.$showFormatSorterDialog$delegate = mutableState20;
            this.$showVideoClipDialog$delegate = mutableState21;
            this.$showMergeAudioDialog$delegate = mutableState22;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
            MutableState<Boolean> $this$getValue$iv = mutableState;
            return $this$getValue$iv.getValue().booleanValue();
        }

        public final void invoke(PaddingValues it, Composer $composer, int $changed) {
            Object value$iv;
            Object value$iv2;
            Intrinsics.checkNotNullParameter(it, "it");
            ComposerKt.sourceInformation($composer, "C127@6314L134,132@6494L10199,132@6461L10232:DownloadFormatPreferences.kt#5yb39d");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed(it) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-16680762, $dirty2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous> (DownloadFormatPreferences.kt:127)");
                }
                $composer.startReplaceGroup(754776257);
                ComposerKt.sourceInformation($composer, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CUSTOM_COMMAND)), null, 2, null);
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                final MutableState isCustomCommandEnabled$delegate = (MutableState) value$iv;
                $composer.endReplaceGroup();
                Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, it);
                $composer.startReplaceGroup(754776437);
                ComposerKt.sourceInformation($composer, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                boolean invalid$iv = $composer.changed(this.$audioFormat$delegate) | $composer.changed(this.$isFormatSortingEnabled$delegate) | $composer.changed(this.$audioQuality$delegate) | $composer.changed(this.$convertAudio$delegate) | $composer.changed(this.$embedMetadata$delegate) | $composer.changed(this.$videoFormat$delegate) | $composer.changed(this.$videoQuality$delegate) | $composer.changed(this.$downloadSubtitle$delegate) | $composer.changed(this.$embedSubtitle$delegate) | $composer.changed(this.$remuxToMkv$delegate) | $composer.changed(this.$navigateToSubtitlePage) | $composer.changed(this.$isFormatSelectionEnabled$delegate) | $composer.changed(this.$isVideoClipEnabled$delegate) | $composer.changed(this.$mergeAudioStream$delegate);
                final MutableState<Boolean> mutableState = this.$audioSwitch$delegate;
                final MutableState<String> mutableState2 = this.$audioFormat$delegate;
                final MutableState<Boolean> mutableState3 = this.$isFormatSortingEnabled$delegate;
                final MutableState<Boolean> mutableState4 = this.$showAudioFormatDialog$delegate;
                final MutableState<String> mutableState5 = this.$audioQuality$delegate;
                final MutableState<Boolean> mutableState6 = this.$showAudioQualityDialog$delegate;
                final MutableState<Boolean> mutableState7 = this.$convertAudio$delegate;
                final MutableState<String> mutableState8 = this.$convertFormat$delegate;
                final MutableState<Boolean> mutableState9 = this.$showAudioConvertDialog$delegate;
                final MutableState<Boolean> mutableState10 = this.$embedMetadata$delegate;
                final MutableState<Boolean> mutableState11 = this.$isArtworkCroppingEnabled$delegate;
                final MutableIntState mutableIntState = this.$videoFormat$delegate;
                final MutableState<Boolean> mutableState12 = this.$showVideoFormatDialog$delegate;
                final MutableIntState mutableIntState2 = this.$videoQuality$delegate;
                final MutableState<Boolean> mutableState13 = this.$showVideoQualityDialog$delegate;
                final MutableState<Boolean> mutableState14 = this.$remuxToMkv$delegate;
                final MutableState<Boolean> mutableState15 = this.$downloadSubtitle$delegate;
                final MutableState<Boolean> mutableState16 = this.$embedSubtitle$delegate;
                final Function0<Unit> function0 = this.$navigateToSubtitlePage;
                final MutableState<Boolean> mutableState17 = this.$showFormatSorterDialog$delegate;
                final MutableState<Boolean> mutableState18 = this.$isFormatSelectionEnabled$delegate;
                final MutableState<Boolean> mutableState19 = this.$isVideoClipEnabled$delegate;
                final MutableState<Boolean> mutableState20 = this.$showVideoClipDialog$delegate;
                final MutableState<Boolean> mutableState21 = this.$mergeAudioStream$delegate;
                final MutableState<Boolean> mutableState22 = this.$showMergeAudioDialog$delegate;
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1
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
                            if (DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(isCustomCommandEnabled$delegate)) {
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7355getLambda2$app_debug(), 3, null);
                            }
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7356getLambda3$app_debug(), 3, null);
                            final MutableState<Boolean> mutableState23 = mutableState;
                            final MutableState<Boolean> mutableState24 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-660241071, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C140@6858L43,141@6941L105,147@7247L165,140@6833L580:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-660241071, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:140)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.extract_audio, $composer2, 0);
                                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.extract_audio_summary, $composer2, 0);
                                    ImageVector musicNote = MusicNoteKt.getMusicNote(Icons.Outlined.INSTANCE);
                                    boolean zDownloadFormatPreferences$lambda$1 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState23);
                                    boolean z = !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState24);
                                    $composer2.startReplaceGroup(-414529847);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState25 = mutableState23;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$1$1$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$2(mutableState25, !DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState25));
                                                PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.EXTRACT_AUDIO, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState25));
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, musicNote, z, zDownloadFormatPreferences$lambda$1, null, (Function0) value$iv3, $composer2, 1572864, 32);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<String> mutableState25 = mutableState2;
                            final MutableState<Boolean> mutableState26 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState27 = mutableState3;
                            final MutableState<Boolean> mutableState28 = mutableState4;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1399681426, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C153@7498L53,157@7781L32,153@7475L339:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1399681426, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:153)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.audio_format_preference, $composer2, 0);
                                    String strDownloadFormatPreferences$lambda$44 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$44(mutableState25);
                                    ImageVector audioFile = AudioFileKt.getAudioFile(Icons.Outlined.INSTANCE);
                                    boolean z = (DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState26) || DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$47(mutableState27)) ? false : true;
                                    $composer2.startReplaceGroup(-414529313);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState29 = mutableState28;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$2$1$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$14(mutableState29, true);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceItem(strStringResource, strDownloadFormatPreferences$lambda$44, audioFile, z, null, null, null, null, null, (Function0) value$iv3, $composer2, 805306368, 496);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<String> mutableState29 = mutableState5;
                            final MutableState<Boolean> mutableState30 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState31 = mutableState3;
                            final MutableState<Boolean> mutableState32 = mutableState6;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-835363373, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C161@7924L43,164@8114L33,160@7876L379:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-835363373, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:160)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.audio_quality, $composer2, 0);
                                        String strDownloadFormatPreferences$lambda$50 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$50(mutableState29);
                                        ImageVector highQuality = HighQualityKt.getHighQuality(Icons.Outlined.INSTANCE);
                                        boolean z = (DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState30) || DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$47(mutableState31)) ? false : true;
                                        $composer2.startReplaceGroup(-414528980);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                        final MutableState<Boolean> mutableState33 = mutableState32;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$3$1$1
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
                                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$17(mutableState33, true);
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceItem(strStringResource, strDownloadFormatPreferences$lambda$50, highQuality, z, null, null, null, null, null, (Function0) value$iv3, $composer2, 805306368, 496);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState33 = mutableState7;
                            final MutableState<String> mutableState34 = mutableState8;
                            final MutableState<Boolean> mutableState35 = mutableState;
                            final MutableState<Boolean> mutableState36 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState37 = mutableState9;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1224559124, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Object value$iv4;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C169@8353L45,173@8613L33,175@8734L154,169@8317L572:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1224559124, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:169)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.convert_audio_format, $composer2, 0);
                                    String strDownloadFormatPreferences$lambda$38 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$38(mutableState34);
                                    ImageVector sync = SyncKt.getSync(Icons.Outlined.INSTANCE);
                                    boolean z = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState35) && !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState36);
                                    boolean zDownloadFormatPreferences$lambda$45 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$45(mutableState33);
                                    $composer2.startReplaceGroup(-414528481);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState38 = mutableState37;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$4$1$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$20(mutableState38, true);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    Function0 function1 = (Function0) value$iv3;
                                    $composer2.endReplaceGroup();
                                    $composer2.startReplaceGroup(-414528360);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    boolean invalid$iv2 = $composer2.changed(mutableState33);
                                    final MutableState<Boolean> mutableState39 = mutableState33;
                                    Object it$iv4 = $composer2.rememberedValue();
                                    if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                        value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$4$2$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$46(mutableState39, !DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$45(mutableState39));
                                                PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.AUDIO_CONVERT, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$45(mutableState39));
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv4);
                                    } else {
                                        value$iv4 = it$iv4;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSwitchWithDivider(strStringResource, strDownloadFormatPreferences$lambda$38, sync, z, false, zDownloadFormatPreferences$lambda$45, null, function1, (Function0) value$iv4, $composer2, 12582912, 80);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState38 = mutableState10;
                            final MutableState<Boolean> mutableState39 = mutableState;
                            final MutableState<Boolean> mutableState40 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1010485675, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C181@8976L44,182@9060L103,188@9380L158,181@8951L588:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1010485675, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:181)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.embed_metadata, $composer2, 0);
                                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.embed_metadata_desc, $composer2, 0);
                                    boolean z = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState39) && !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState40);
                                    boolean zDownloadFormatPreferences$lambda$10 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$10(mutableState38);
                                    ImageVector artTrack = ArtTrackKt.getArtTrack(Icons.Outlined.INSTANCE);
                                    $composer2.startReplaceGroup(-414527714);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    boolean invalid$iv2 = $composer2.changed(mutableState38);
                                    final MutableState<Boolean> mutableState41 = mutableState38;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$5$1$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$11(mutableState41, !DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$10(mutableState41));
                                                PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.EMBED_METADATA, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$10(mutableState41));
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, artTrack, z, zDownloadFormatPreferences$lambda$10, null, (Function0) value$iv3, $composer2, 0, 32);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState41 = mutableState10;
                            final MutableState<Boolean> mutableState42 = mutableState;
                            final MutableState<Boolean> mutableState43 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState44 = mutableState11;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1049436822, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C195@9651L37,196@9728L42,200@9998L191,194@9601L588:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1049436822, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:194)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.crop_artwork, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.crop_artwork_desc, $composer2, 0);
                                        ImageVector crop = CropKt.getCrop(Icons.Outlined.INSTANCE);
                                        boolean z = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$10(mutableState41) && DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState42) && !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState43);
                                        boolean zDownloadFormatPreferences$lambda$4 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$4(mutableState44);
                                        $composer2.startReplaceGroup(-414527096);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                        final MutableState<Boolean> mutableState45 = mutableState44;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$6$1$1
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
                                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$5(mutableState45, !DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$4(mutableState45));
                                                    PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.CROP_ARTWORK, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$4(mutableState45));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, crop, z, zDownloadFormatPreferences$lambda$4, null, (Function0) value$iv3, $composer2, 1572864, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7357getLambda4$app_debug(), 3, null);
                            final MutableIntState mutableIntState3 = mutableIntState;
                            final MutableState<Boolean> mutableState45 = mutableState;
                            final MutableState<Boolean> mutableState46 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState47 = mutableState3;
                            final MutableState<Boolean> mutableState48 = mutableState12;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(874314520, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C210@10423L48,211@10529L32,214@10743L32,209@10375L400:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(874314520, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:209)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.video_format_preference, $composer2, 0);
                                    String videoFormatLabel = PreferenceStrings.INSTANCE.getVideoFormatLabel(DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$33(mutableIntState3), $composer2, 48, 0);
                                    ImageVector videoFile = VideoFileKt.getVideoFile(Icons.Outlined.INSTANCE);
                                    boolean z = (DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState45) || DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState46) || DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$47(mutableState47)) ? false : true;
                                    $composer2.startReplaceGroup(-414526351);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState49 = mutableState48;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$7$1$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$26(mutableState49, true);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceItem(strStringResource, videoFormatLabel, videoFile, z, null, null, null, null, null, (Function0) value$iv3, $composer2, 805306368, 496);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableIntState mutableIntState4 = mutableIntState2;
                            final MutableState<Boolean> mutableState49 = mutableState;
                            final MutableState<Boolean> mutableState50 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState51 = mutableState3;
                            final MutableState<Boolean> mutableState52 = mutableState13;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1360730279, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C218@10885L43,219@10986L40,222@11210L33,217@10837L406:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1360730279, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:217)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.video_quality, $composer2, 0);
                                    String videoResolutionDescComp = PreferenceStrings.INSTANCE.getVideoResolutionDescComp(DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$35(mutableIntState4), $composer2, 48, 0);
                                    ImageVector highQuality = HighQualityKt.getHighQuality(Icons.Outlined.INSTANCE);
                                    boolean z = (DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState49) || DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState50) || DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$47(mutableState51)) ? false : true;
                                    $composer2.startReplaceGroup(-414525884);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState53 = mutableState52;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$8$1$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$23(mutableState53, true);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceItem(strStringResource, videoResolutionDescComp, highQuality, z, null, null, null, null, null, (Function0) value$iv3, $composer2, 805306368, 496);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState53 = mutableState14;
                            final MutableState<Boolean> mutableState54 = mutableState15;
                            final MutableState<Boolean> mutableState55 = mutableState16;
                            final MutableState<Boolean> mutableState56 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState57 = mutableState;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(311485203, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.9
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C240@12223L49,241@12312L108,247@12711L151,239@12173L712:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(311485203, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:239)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.remux_container_mkv, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.remux_container_mkv_desc, $composer2, 0);
                                        boolean z = (DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$6(mutableState54) && DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$7(mutableState55)) || DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$8(mutableState53);
                                        ImageVector movie = MovieKt.getMovie(Icons.Outlined.INSTANCE);
                                        boolean z2 = ((DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$6(mutableState54) && DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$7(mutableState55)) || DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState56) || DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$1(mutableState57)) ? false : true;
                                        $composer2.startReplaceGroup(-414524383);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                        boolean invalid$iv2 = $composer2.changed(mutableState53);
                                        final MutableState<Boolean> mutableState58 = mutableState53;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$9$1$1
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
                                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$9(mutableState58, !DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$8(mutableState58));
                                                    PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.MERGE_OUTPUT_MKV, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$8(mutableState58));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, movie, z2, z, null, (Function0) value$iv3, $composer2, 0, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            if (DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$6(mutableState15) && DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$7(mutableState16)) {
                                LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7358getLambda5$app_debug(), 3, null);
                            }
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadFormatPreferencesKt.INSTANCE.m7359getLambda6$app_debug(), 3, null);
                            final Function0<Unit> function1 = function0;
                            final MutableState<Boolean> mutableState58 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(136362901, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.10
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C265@13358L38,268@13552L43,269@13619L28,264@13310L337:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(136362901, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:264)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.subtitle, $composer2, 0);
                                    ImageVector subtitles = SubtitlesKt.getSubtitles(Icons.Outlined.INSTANCE);
                                    boolean z = !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState58);
                                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.subtitle_desc, $composer2, 0);
                                    $composer2.startReplaceGroup(-414523475);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    boolean invalid$iv2 = $composer2.changed(function1);
                                    final Function0<Unit> function2 = function1;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$10$1$1
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
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceItem(strStringResource, strStringResource2, subtitles, z, null, null, null, null, null, (Function0) value$iv3, $composer2, 0, 496);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState59 = mutableState3;
                            final MutableState<Boolean> mutableState60 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState61 = mutableState17;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2098681898, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.11
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Object value$iv4;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C272@13745L44,274@13881L49,281@14308L33,277@14087L185,272@13709L633:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) == 16 && $composer2.getSkipping()) {
                                        $composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2098681898, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:272)");
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.format_sorting, $composer2, 0);
                                    ImageVector sort = SortKt.getSort(Icons.Outlined.INSTANCE);
                                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.format_sorting_desc, $composer2, 0);
                                    boolean z = !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState60);
                                    boolean zDownloadFormatPreferences$lambda$47 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$47(mutableState59);
                                    $composer2.startReplaceGroup(-414522786);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    final MutableState<Boolean> mutableState62 = mutableState61;
                                    Object it$iv3 = $composer2.rememberedValue();
                                    if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$11$1$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$29(mutableState62, true);
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv3;
                                    }
                                    Function0 function2 = (Function0) value$iv3;
                                    $composer2.endReplaceGroup();
                                    $composer2.startReplaceGroup(-414523007);
                                    ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                    boolean invalid$iv2 = $composer2.changed(mutableState59);
                                    final MutableState<Boolean> mutableState63 = mutableState59;
                                    Object it$iv4 = $composer2.rememberedValue();
                                    if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                        value$iv4 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$11$2$1
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
                                                DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$48(mutableState63, !DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$47(mutableState63));
                                                PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.FORMAT_SORTING, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$47(mutableState63));
                                            }
                                        };
                                        $composer2.updateRememberedValue(value$iv4);
                                    } else {
                                        value$iv4 = it$iv4;
                                    }
                                    $composer2.endReplaceGroup();
                                    PreferenceItemsKt.PreferenceSwitchWithDivider(strStringResource, strStringResource2, sort, z, false, zDownloadFormatPreferences$lambda$47, null, function2, (Function0) value$iv4, $composer2, 12582912, 80);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState62 = mutableState18;
                            final MutableState<Boolean> mutableState63 = isCustomCommandEnabled$delegate;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-38759401, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.12
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C285@14454L46,288@14660L51,290@14796L195,284@14404L587:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-38759401, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:284)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.format_selection, $composer2, 0);
                                        ImageVector videoSettings = VideoSettingsKt.getVideoSettings(Icons.Outlined.INSTANCE);
                                        boolean z = !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState63);
                                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.format_selection_desc, $composer2, 0);
                                        boolean zDownloadFormatPreferences$lambda$53 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$53(mutableState62);
                                        $composer2.startReplaceGroup(-414522298);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                        boolean invalid$iv2 = $composer2.changed(mutableState62);
                                        final MutableState<Boolean> mutableState64 = mutableState62;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$12$1$1
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
                                                    DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$54(mutableState64, !DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$53(mutableState64));
                                                    PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.FORMAT_SELECTION, DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$53(mutableState64));
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, videoSettings, z, zDownloadFormatPreferences$lambda$53, null, (Function0) value$iv3, $composer2, 0, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState64 = mutableState19;
                            final MutableState<Boolean> mutableState65 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState66 = mutableState18;
                            final MutableState<Boolean> mutableState67 = mutableState20;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2021163096, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.13
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C297@15103L40,298@15183L99,304@15506L271,296@15053L724:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2021163096, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:296)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.clip_video, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.clip_video_desc, $composer2, 0);
                                        ImageVector contentCut = ContentCutKt.getContentCut(Icons.Outlined.INSTANCE);
                                        boolean zDownloadFormatPreferences$lambda$51 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$51(mutableState64);
                                        boolean z = !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState65) && DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$53(mutableState66);
                                        $composer2.startReplaceGroup(-414521588);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                        boolean invalid$iv2 = $composer2.changed(mutableState64);
                                        final MutableState<Boolean> mutableState68 = mutableState64;
                                        final MutableState<Boolean> mutableState69 = mutableState67;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$13$1$1
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
                                                    if (!DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$51(mutableState68)) {
                                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$32(mutableState69, true);
                                                    } else {
                                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$52(mutableState68, false);
                                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.VIDEO_CLIP, false);
                                                    }
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, contentCut, z, zDownloadFormatPreferences$lambda$51, null, (Function0) value$iv3, $composer2, 0, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                            final MutableState<Boolean> mutableState68 = mutableState21;
                            final MutableState<Boolean> mutableState69 = isCustomCommandEnabled$delegate;
                            final MutableState<Boolean> mutableState70 = mutableState18;
                            final MutableState<Boolean> mutableState71 = mutableState22;
                            LazyListScope.CC.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-213881703, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1.14
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer $composer2, int $changed2) {
                                    Object value$iv3;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation($composer2, "C314@15889L47,315@15976L106,319@16211L341,313@15839L822:DownloadFormatPreferences.kt#5yb39d");
                                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-213881703, $changed2, -1, "com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferences.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DownloadFormatPreferences.kt:313)");
                                        }
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.merge_audiostream, $composer2, 0);
                                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.merge_audiostream_desc, $composer2, 0);
                                        boolean zDownloadFormatPreferences$lambda$55 = DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$55(mutableState68);
                                        ImageVector spatialAudioOff = SpatialAudioOffKt.getSpatialAudioOff(Icons.Outlined.INSTANCE);
                                        boolean z = !DownloadFormatPreferencesKt.AnonymousClass2.invoke$lambda$1(mutableState69) && DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$53(mutableState70);
                                        $composer2.startReplaceGroup(-414520883);
                                        ComposerKt.sourceInformation($composer2, "CC(remember):DownloadFormatPreferences.kt#9igjgp");
                                        boolean invalid$iv2 = $composer2.changed(mutableState68);
                                        final MutableState<Boolean> mutableState72 = mutableState68;
                                        final MutableState<Boolean> mutableState73 = mutableState71;
                                        Object it$iv3 = $composer2.rememberedValue();
                                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.format.DownloadFormatPreferencesKt$DownloadFormatPreferences$2$1$1$14$1$1
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
                                                    if (DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$55(mutableState72)) {
                                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$56(mutableState72, false);
                                                        PreferenceUtil.INSTANCE.updateBoolean(PreferenceUtilKt.MERGE_MULTI_AUDIO_STREAM, false);
                                                    } else {
                                                        DownloadFormatPreferencesKt.DownloadFormatPreferences$lambda$59(mutableState73, true);
                                                    }
                                                }
                                            };
                                            $composer2.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer2.endReplaceGroup();
                                        PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, spatialAudioOff, z, zDownloadFormatPreferences$lambda$55, null, (Function0) value$iv3, $composer2, 0, 32);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }), 3, null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, (Function1) value$iv2, $composer, 0, 254);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    }
}
