package com.videshkarmakar.loop.ui.component;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridSpanKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.text.modifiers.LayoutUtilsKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.AudiotrackKt;
import androidx.compose.material.icons.rounded.QuestionMarkKt;
import androidx.compose.material.icons.rounded.VideocamKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.Format;
import com.videshkarmakar.loop.util.RequestedDownload;
import com.videshkarmakar.loop.util.TextUtilKt;
import com.videshkarmakar.loop.util.VideoInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: FormatItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u009b\u0001\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020$2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\t2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010-\u001a\r\u0010.\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001b\u001a9\u0010/\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u00102\u001a\r\u00103\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001b\u001a*\u00104\u001a\u00020\u0001*\u0002052\b\b\u0002\u0010\b\u001a\u00020$2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000106\u001a\u000e\u00107\u001a\u00020\u0013*\u0004\u0018\u00010\u0013H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00068²\u0006\n\u00109\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010;\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"FormatItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "formatInfo", "Lcom/videshkarmakar/loop/util/Format;", "duration", "", "selected", "", "outlineColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "onLongClick", "Lkotlin/Function0;", "onClick", "FormatItem-bogVsAg", "(Landroidx/compose/ui/Modifier;Lcom/videshkarmakar/loop/util/Format;DZJJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "title", "", "containsAudio", "containsVideo", "firstLineText", "secondLineText", "FormatItem-uPCbpMU", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZJJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "FormatItemPreview", "(Landroidx/compose/runtime/Composer;I)V", "FormatSubtitle", "text", "color", "FormatSubtitle-FNF3uiM", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "FormatVideoPreview", "author", "thumbnailUrl", "", "isSplittingVideo", "isClippingVideo", "isClippingAvailable", "isSplitByChapterAvailable", "onRename", "onOpenThumbnail", "onClippingToggled", "onSplittingToggled", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "PreviewFormat", "SuggestedFormatItem", "videoInfo", "Lcom/videshkarmakar/loop/util/VideoInfo;", "(Landroidx/compose/ui/Modifier;Lcom/videshkarmakar/loop/util/VideoInfo;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VideoInfoPreview", "FormatPreviewContent", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/Function1;", "toEmpty", "app_debug", "expanded", "animatedTitleColor", "animatedContainerColor", "animatedOutlineColor"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FormatItemKt {
    /* JADX WARN: Code duplicated, block: B:196:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:199:0x0408  */
    /* JADX WARN: Code duplicated, block: B:200:0x040e  */
    /* JADX WARN: Code duplicated, block: B:211:0x050d  */
    /* JADX WARN: Code duplicated, block: B:214:0x0519  */
    /* JADX WARN: Code duplicated, block: B:215:0x051f  */
    /* JADX WARN: Code duplicated, block: B:226:0x06df  */
    /* JADX WARN: Code duplicated, block: B:229:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:230:0x06f1  */
    /* JADX WARN: Code duplicated, block: B:233:0x0722  */
    /* JADX WARN: Code duplicated, block: B:236:0x0735  */
    /* JADX WARN: Code duplicated, block: B:237:0x0738  */
    /* JADX WARN: Code duplicated, block: B:241:0x085c  */
    /* JADX WARN: Code duplicated, block: B:244:0x08d6  */
    /* JADX WARN: Code duplicated, block: B:247:0x0927  */
    /* JADX WARN: Code duplicated, block: B:248:0x0938  */
    /* JADX WARN: Code duplicated, block: B:251:0x09a4  */
    /* JADX WARN: Code duplicated, block: B:254:0x09b0  */
    /* JADX WARN: Code duplicated, block: B:255:0x09b4  */
    /* JADX WARN: Code duplicated, block: B:258:0x09e2  */
    /* JADX WARN: Code duplicated, block: B:262:0x09f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:266:0x0a6a  */
    /* JADX WARN: Code duplicated, block: B:267:0x0a7a  */
    /* JADX WARN: Code duplicated, block: B:270:0x0ae3  */
    /* JADX WARN: Code duplicated, block: B:271:0x0af3  */
    /* JADX WARN: Code duplicated, block: B:274:0x0b73  */
    public static final void FormatVideoPreview(Modifier modifier, final String title, final String author, final String thumbnailUrl, final int duration, final boolean isSplittingVideo, final boolean isClippingVideo, boolean isClippingAvailable, boolean isSplitByChapterAvailable, Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        boolean isClippingAvailable2;
        boolean isSplitByChapterAvailable2;
        Function0<Unit> function4;
        Function0<Unit> function5;
        Function0<Unit> function6;
        Function0<Unit> function7;
        float f;
        Function0<ComposeUiNode> function8;
        int $dirty1;
        boolean propagateMinConstraints$iv;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function9;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        int compositeKeyHash$iv$iv2;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> function10;
        Composer $this$Layout_u24lambda_u240$iv$iv2;
        Composer $composer2;
        int compositeKeyHash$iv$iv3;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> constructor3;
        Function0<ComposeUiNode> function11;
        Composer $this$Layout_u24lambda_u240$iv$iv3;
        CompositionLocalMap localMap$iv$iv2;
        Modifier modifier2;
        Composer $composer3;
        Object it$iv;
        Object value$iv;
        final MutableState expanded$delegate;
        int compositeKeyHash$iv$iv4;
        Function0<ComposeUiNode> constructor4;
        Composer $this$Layout_u24lambda_u240$iv$iv4;
        Object value$iv2;
        Object it$iv2;
        Object value$iv3;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
        Composer $composer4 = $composer.startRestartGroup(2055331924);
        ComposerKt.sourceInformation($composer4, "C(FormatVideoPreview)P(6,12!1,11!1,5,3!2,9,8)83@3689L7,88@3824L4755:FormatItem.kt#g7nzpb");
        int $dirty = $changed;
        int $dirty2 = $changed1;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer4.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer4.changed(title) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer4.changed(author) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer4.changed(thumbnailUrl) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer4.changed(duration) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & $changed) == 0) {
            $dirty |= $composer4.changed(isSplittingVideo) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer4.changed(isClippingVideo) ? 1048576 : 524288;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty |= 12582912;
            z = isClippingAvailable;
        } else if (($changed & 29360128) == 0) {
            z = isClippingAvailable;
            $dirty |= $composer4.changed(z) ? 8388608 : 4194304;
        } else {
            z = isClippingAvailable;
        }
        int i4 = i & 256;
        if (i4 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer4.changed(isSplitByChapterAvailable) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i5 = i & 512;
        if (i5 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 536870912 : 268435456;
        }
        int i6 = i & 1024;
        if (i6 != 0) {
            $dirty2 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 4 : 2;
        }
        int i7 = i & 2048;
        if (i7 != 0) {
            $dirty2 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty2 |= $composer4.changedInstance(function2) ? 32 : 16;
        }
        int i8 = i & 4096;
        if (i8 != 0) {
            $dirty2 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty2 |= $composer4.changedInstance(function3) ? 256 : 128;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty2 & 731) == 146 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            modifier2 = modifier;
            isSplitByChapterAvailable2 = isSplitByChapterAvailable;
            function4 = function0;
            function5 = function1;
            function6 = function2;
            function7 = function3;
            $composer2 = $composer4;
            isClippingAvailable2 = z;
        } else {
            Modifier modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            isClippingAvailable2 = i3 != 0 ? false : z;
            isSplitByChapterAvailable2 = i4 != 0 ? false : isSplitByChapterAvailable;
            function4 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatVideoPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function0;
            function5 = i6 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatVideoPreview.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function1;
            function6 = i7 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatVideoPreview.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function2;
            function7 = i8 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatVideoPreview.4
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
                ComposerKt.traceEventStart(2055331924, $dirty, $dirty2, "com.videshkarmakar.loop.ui.component.FormatVideoPreview (FormatItem.kt:82)");
            }
            ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = CompositionLocalsKt.getLocalWindowWidthState();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer4.consume(localWindowWidthState);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            int value = ((WindowWidthSizeClass) objConsume).getValue();
            if (WindowWidthSizeClass.m3491equalsimpl0(value, WindowWidthSizeClass.INSTANCE.m3500getExpandedY0FxcvE())) {
                f = 0.25f;
            } else {
                f = WindowWidthSizeClass.m3491equalsimpl0(value, WindowWidthSizeClass.INSTANCE.m3501getMediumY0FxcvE()) ? 0.3f : 0.45f;
            }
            float imageWeight = f;
            Modifier modifier$iv = SizeKt.wrapContentHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getTop(), false);
            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                function8 = constructor5;
                $composer4.createNode(function8);
            } else {
                function8 = constructor5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3547constructorimpl($composer4);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv5.getInserting()) {
                $dirty1 = $dirty2;
                propagateMinConstraints$iv = false;
            } else {
                $dirty1 = $dirty2;
                propagateMinConstraints$iv = false;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i10 = ((6 >> 6) & 112) | 6;
                BoxScope $this$FormatVideoPreview_u24lambda_u249 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -1639924177, "C93@3967L2195,149@6187L34,150@6230L2341:FormatItem.kt#g7nzpb");
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    function9 = constructor;
                    $composer4.createNode(function9);
                } else {
                    function9 = constructor;
                    $composer4.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i12 = ((0 >> 6) & 112) | 6;
                RowScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u242 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -4769636, "C96@4043L1028,123@5085L1067:FormatItem.kt#g7nzpb");
                Modifier modifier$iv3 = RowScope.CC.weight$default($this$FormatVideoPreview_u24lambda_u249_u24lambda_u242, Modifier.INSTANCE, imageWeight, false, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    function10 = constructor2;
                    $composer4.createNode(function10);
                } else {
                    function10 = constructor2;
                    $composer4.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
                $composer2 = $composer4;
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i13 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i14 = ((0 >> 6) & 112) | 6;
                BoxScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u242_u24lambda_u240 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, 271223215, "C102@4295L85,100@4157L241,111@4659L6,112@4695L362,106@4415L642:FormatItem.kt#g7nzpb");
                VideoListItemKt.MediaImage(Modifier.INSTANCE, thumbnailUrl, false, StringResources_androidKt.stringResource(R.string.thumbnail, $composer4, 0), $composer4, (($dirty >> 6) & 112) | 390, 0);
                int $dirty3 = $dirty;
                Modifier modifierAlign = $this$FormatVideoPreview_u24lambda_u249_u24lambda_u242_u24lambda_u240.align(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(2)), Alignment.INSTANCE.getBottomEnd());
                long jM4069getBlack0d7_KjU = Color.INSTANCE.m4069getBlack0d7_KjU();
                SurfaceKt.m2418SurfaceT9BRK9s(modifierAlign, MaterialTheme.INSTANCE.getShapes($composer4, MaterialTheme.$stable).getExtraSmall(), Color.m4041copywmQWz5c(jM4069getBlack0d7_KjU, (14 & 1) != 0 ? Color.m4045getAlphaimpl(jM4069getBlack0d7_KjU) : 0.68f, (14 & 2) != 0 ? Color.m4049getRedimpl(jM4069getBlack0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(jM4069getBlack0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(jM4069getBlack0d7_KjU) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(332428063, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer5, int $changed2) {
                        ComposerKt.sourceInformation($composer5, "C117@4951L10,114@4782L257:FormatItem.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(332428063, $changed2, -1, "com.videshkarmakar.loop.ui.component.FormatVideoPreview.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatItem.kt:113)");
                            }
                            String durationText = TextUtilKt.toDurationText(duration);
                            TextKt.m2569Text4IGK_g(durationText, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4080getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getLabelSmall(), $composer5, 432, 0, 65528);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer5.skipToGroupEnd();
                    }
                }, $composer4, 54), $composer4, 12583296, 120);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv4 = RowScope.CC.weight$default($this$FormatVideoPreview_u24lambda_u249_u24lambda_u242, Modifier.INSTANCE, 1.0f - imageWeight, false, 2, null);
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv4 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    function11 = constructor3;
                    $composer4.createNode(function11);
                } else {
                    function11 = constructor3;
                    $composer4.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    localMap$iv$iv2 = localMap$iv$iv;
                } else {
                    localMap$iv$iv2 = localMap$iv$iv;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i15 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i16 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 271224304, "C132@5462L10,133@5527L11,127@5246L409:FormatItem.kt#g7nzpb");
                    modifier2 = modifier3;
                    TextKt.m2569Text4IGK_g(title, PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleSmall(), $composer4, (($dirty3 >> 3) & 14) | 48, 3120, 55288);
                    $composer4.startReplaceGroup(-4768007);
                    ComposerKt.sourceInformation($composer4, "142@5940L10,143@6004L11,137@5718L420");
                    if (!Intrinsics.areEqual(author, "playlist") || Intrinsics.areEqual(author, AbstractJsonLexerKt.NULL)) {
                        $composer3 = $composer4;
                    } else {
                        $composer3 = $composer4;
                        TextKt.m2569Text4IGK_g(author, PaddingKt.m624paddingqDBjuR0$default(PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(12), 0.0f, 2, null), 0.0f, Dp.m6553constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), $composer3, (($dirty3 >> 6) & 14) | 48, 3120, 55288);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
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
                    $composer4.startReplaceGroup(-1639921957);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                    it$iv = $composer4.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    expanded$delegate = (MutableState) value$iv;
                    $composer4.endReplaceGroup();
                    Modifier modifier$iv5 = $this$FormatVideoPreview_u24lambda_u249.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv5 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
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
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash5);
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                    int i17 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    int i18 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u248 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -4767361, "C154@6356L19,153@6318L356,168@6890L21,167@6838L20,169@6926L1635,164@6688L1873:FormatItem.kt#g7nzpb");
                    $composer4.startReplaceGroup(-4767323);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                    value$iv2 = $composer4.rememberedValue();
                    if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$1$1
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
                                FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, true);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                    }
                    $composer4.endReplaceGroup();
                    IconButtonKt.IconButton((Function0) value$iv2, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(36)), false, null, null, ComposableSingletons$FormatItemKt.INSTANCE.m7125getLambda1$app_debug(), $composer4, 196662, 28);
                    Modifier modifierAlign2 = $this$FormatVideoPreview_u24lambda_u249_u24lambda_u248.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
                    boolean zFormatVideoPreview$lambda$9$lambda$4 = FormatVideoPreview$lambda$9$lambda$4(expanded$delegate);
                    ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
                    $composer4.startReplaceGroup(-4766841);
                    ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                    it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$2$1
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
                                FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, false);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv2;
                    }
                    $composer4.endReplaceGroup();
                    final Function0<Unit> function12 = function4;
                    final Function0<Unit> function13 = function5;
                    final boolean z2 = isClippingAvailable2;
                    final Function0<Unit> function14 = function6;
                    final boolean z3 = isSplitByChapterAvailable2;
                    final Function0<Unit> function15 = function7;
                    AndroidMenu_androidKt.m1666DropdownMenuIlH_yew(zFormatVideoPreview$lambda$9$lambda$4, (Function0) value$iv3, modifierAlign2, 0L, scrollStateRememberScrollState, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1495670651, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                            invoke(columnScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope DropdownMenu, Composer $composer5, int $changed2) {
                            Object value$iv4;
                            Object value$iv5;
                            Object value$iv6;
                            Object value$iv7;
                            Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                            ComposerKt.sourceInformation($composer5, "C173@7159L99,170@6944L315,180@7495L106,177@7276L326,197@8407L121,194@8180L349:FormatItem.kt#g7nzpb");
                            if (($changed2 & 81) != 16 || !$composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1495670651, $changed2, -1, "com.videshkarmakar.loop.ui.component.FormatVideoPreview.<anonymous>.<anonymous>.<anonymous> (FormatItem.kt:170)");
                                }
                                Function2<Composer, Integer, Unit> function2M7133getLambda2$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7133getLambda2$app_debug();
                                $composer5.startReplaceGroup(271226217);
                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                boolean invalid$iv = $composer5.changed(function12);
                                final Function0<Unit> function16 = function12;
                                final MutableState<Boolean> mutableState = expanded$delegate;
                                Object it$iv3 = $composer5.rememberedValue();
                                if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$1$1
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
                                            function16.invoke();
                                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv4);
                                } else {
                                    value$iv4 = it$iv3;
                                }
                                $composer5.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(function2M7133getLambda2$app_debug, (Function0) value$iv4, null, ComposableSingletons$FormatItemKt.INSTANCE.m7134getLambda3$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                                Function2<Composer, Integer, Unit> function2M7135getLambda4$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7135getLambda4$app_debug();
                                $composer5.startReplaceGroup(271226553);
                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                boolean invalid$iv2 = $composer5.changed(function13);
                                final Function0<Unit> function17 = function13;
                                final MutableState<Boolean> mutableState2 = expanded$delegate;
                                Object it$iv4 = $composer5.rememberedValue();
                                if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                    value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$2$1
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
                                            function17.invoke();
                                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState2, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv5);
                                } else {
                                    value$iv5 = it$iv4;
                                }
                                $composer5.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(function2M7135getLambda4$app_debug, (Function0) value$iv5, null, ComposableSingletons$FormatItemKt.INSTANCE.m7136getLambda5$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                                $composer5.startReplaceGroup(271226677);
                                ComposerKt.sourceInformation($composer5, "188@7930L120,185@7707L344");
                                if (z2 && !isClippingVideo && !isSplittingVideo) {
                                    Function2<Composer, Integer, Unit> function2M7137getLambda6$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7137getLambda6$app_debug();
                                    $composer5.startReplaceGroup(271226988);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                    boolean invalid$iv3 = $composer5.changed(function14);
                                    final Function0<Unit> function18 = function14;
                                    final MutableState<Boolean> mutableState3 = expanded$delegate;
                                    Object it$iv5 = $composer5.rememberedValue();
                                    if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                        value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$3$1
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
                                                function18.invoke();
                                                FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState3, false);
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv7);
                                    } else {
                                        value$iv7 = it$iv5;
                                    }
                                    $composer5.endReplaceGroup();
                                    AndroidMenu_androidKt.DropdownMenuItem(function2M7137getLambda6$app_debug, (Function0) value$iv7, null, ComposableSingletons$FormatItemKt.INSTANCE.m7138getLambda7$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                                }
                                $composer5.endReplaceGroup();
                                if (z3 && !isClippingVideo && !isSplittingVideo) {
                                    Function2<Composer, Integer, Unit> function2M7139getLambda8$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7139getLambda8$app_debug();
                                    $composer5.startReplaceGroup(271227465);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                    boolean invalid$iv4 = $composer5.changed(function15);
                                    final Function0<Unit> function19 = function15;
                                    final MutableState<Boolean> mutableState4 = expanded$delegate;
                                    Object it$iv6 = $composer5.rememberedValue();
                                    if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                                        value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$4$1
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
                                                FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState4, false);
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv6);
                                    } else {
                                        value$iv6 = it$iv6;
                                    }
                                    $composer5.endReplaceGroup();
                                    AndroidMenu_androidKt.DropdownMenuItem(function2M7139getLambda8$app_debug, (Function0) value$iv6, null, ComposableSingletons$FormatItemKt.INSTANCE.m7140getLambda9$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer5.skipToGroupEnd();
                        }
                    }, $composer4, 54), $composer4, 48, 48, 2024);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i19 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i110 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 271224304, "C132@5462L10,133@5527L11,127@5246L409:FormatItem.kt#g7nzpb");
                modifier2 = modifier3;
                TextKt.m2569Text4IGK_g(title, PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleSmall(), $composer4, (($dirty3 >> 3) & 14) | 48, 3120, 55288);
                $composer4.startReplaceGroup(-4768007);
                ComposerKt.sourceInformation($composer4, "142@5940L10,143@6004L11,137@5718L420");
                if (Intrinsics.areEqual(author, "playlist")) {
                    $composer3 = $composer4;
                } else {
                    $composer3 = $composer4;
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
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
                $composer4.startReplaceGroup(-1639921957);
                ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer4.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                expanded$delegate = (MutableState) value$iv;
                $composer4.endReplaceGroup();
                Modifier modifier$iv6 = $this$FormatVideoPreview_u24lambda_u249.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                int $changed$iv$iv6 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                CompositionLocalMap localMap$iv$iv7 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
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
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash6);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                int i111 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i112 = ((0 >> 6) & 112) | 6;
                BoxScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u249 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -4767361, "C154@6356L19,153@6318L356,168@6890L21,167@6838L20,169@6926L1635,164@6688L1873:FormatItem.kt#g7nzpb");
                $composer4.startReplaceGroup(-4767323);
                ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                value$iv2 = $composer4.rememberedValue();
                if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$1$1
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
                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, true);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                }
                $composer4.endReplaceGroup();
                IconButtonKt.IconButton((Function0) value$iv2, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(36)), false, null, null, ComposableSingletons$FormatItemKt.INSTANCE.m7125getLambda1$app_debug(), $composer4, 196662, 28);
                Modifier modifierAlign3 = $this$FormatVideoPreview_u24lambda_u249_u24lambda_u249.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
                boolean zFormatVideoPreview$lambda$9$lambda$5 = FormatVideoPreview$lambda$9$lambda$4(expanded$delegate);
                ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
                $composer4.startReplaceGroup(-4766841);
                ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$2$1
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
                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, false);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv2;
                }
                $composer4.endReplaceGroup();
                final Function0<Unit> function16 = function4;
                final Function0<Unit> function17 = function5;
                final boolean z4 = isClippingAvailable2;
                final Function0<Unit> function18 = function6;
                final boolean z5 = isSplitByChapterAvailable2;
                final Function0<Unit> function19 = function7;
                AndroidMenu_androidKt.m1666DropdownMenuIlH_yew(zFormatVideoPreview$lambda$9$lambda$5, (Function0) value$iv3, modifierAlign3, 0L, scrollStateRememberScrollState2, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1495670651, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope DropdownMenu, Composer $composer5, int $changed2) {
                        Object value$iv4;
                        Object value$iv5;
                        Object value$iv6;
                        Object value$iv7;
                        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                        ComposerKt.sourceInformation($composer5, "C173@7159L99,170@6944L315,180@7495L106,177@7276L326,197@8407L121,194@8180L349:FormatItem.kt#g7nzpb");
                        if (($changed2 & 81) != 16 || !$composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1495670651, $changed2, -1, "com.videshkarmakar.loop.ui.component.FormatVideoPreview.<anonymous>.<anonymous>.<anonymous> (FormatItem.kt:170)");
                            }
                            Function2<Composer, Integer, Unit> function2M7133getLambda2$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7133getLambda2$app_debug();
                            $composer5.startReplaceGroup(271226217);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                            boolean invalid$iv = $composer5.changed(function16);
                            final Function0<Unit> function110 = function16;
                            final MutableState<Boolean> mutableState = expanded$delegate;
                            Object it$iv3 = $composer5.rememberedValue();
                            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$1$1
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
                                        function110.invoke();
                                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState, false);
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv3;
                            }
                            $composer5.endReplaceGroup();
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7133getLambda2$app_debug, (Function0) value$iv4, null, ComposableSingletons$FormatItemKt.INSTANCE.m7134getLambda3$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            Function2<Composer, Integer, Unit> function2M7135getLambda4$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7135getLambda4$app_debug();
                            $composer5.startReplaceGroup(271226553);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                            boolean invalid$iv2 = $composer5.changed(function17);
                            final Function0<Unit> function111 = function17;
                            final MutableState<Boolean> mutableState2 = expanded$delegate;
                            Object it$iv4 = $composer5.rememberedValue();
                            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$2$1
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
                                        function111.invoke();
                                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState2, false);
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv4;
                            }
                            $composer5.endReplaceGroup();
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7135getLambda4$app_debug, (Function0) value$iv5, null, ComposableSingletons$FormatItemKt.INSTANCE.m7136getLambda5$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            $composer5.startReplaceGroup(271226677);
                            ComposerKt.sourceInformation($composer5, "188@7930L120,185@7707L344");
                            if (z4 && !isClippingVideo && !isSplittingVideo) {
                                Function2<Composer, Integer, Unit> function2M7137getLambda6$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7137getLambda6$app_debug();
                                $composer5.startReplaceGroup(271226988);
                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                boolean invalid$iv3 = $composer5.changed(function18);
                                final Function0<Unit> function112 = function18;
                                final MutableState<Boolean> mutableState3 = expanded$delegate;
                                Object it$iv5 = $composer5.rememberedValue();
                                if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$3$1
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
                                            function112.invoke();
                                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState3, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv7);
                                } else {
                                    value$iv7 = it$iv5;
                                }
                                $composer5.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(function2M7137getLambda6$app_debug, (Function0) value$iv7, null, ComposableSingletons$FormatItemKt.INSTANCE.m7138getLambda7$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            }
                            $composer5.endReplaceGroup();
                            if (z5 && !isClippingVideo && !isSplittingVideo) {
                                Function2<Composer, Integer, Unit> function2M7139getLambda8$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7139getLambda8$app_debug();
                                $composer5.startReplaceGroup(271227465);
                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                boolean invalid$iv4 = $composer5.changed(function19);
                                final Function0<Unit> function113 = function19;
                                final MutableState<Boolean> mutableState4 = expanded$delegate;
                                Object it$iv6 = $composer5.rememberedValue();
                                if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                                    value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$4$1
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
                                            function113.invoke();
                                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState4, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv6);
                                } else {
                                    value$iv6 = it$iv6;
                                }
                                $composer5.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(function2M7139getLambda8$app_debug, (Function0) value$iv6, null, ComposableSingletons$FormatItemKt.INSTANCE.m7140getLambda9$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer5.skipToGroupEnd();
                    }
                }, $composer4, 54), $composer4, 48, 48, 2024);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
            $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i20 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i113 = ((6 >> 6) & 112) | 6;
            BoxScope $this$FormatVideoPreview_u24lambda_u2410 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1639924177, "C93@3967L2195,149@6187L34,150@6230L2341:FormatItem.kt#g7nzpb");
            Modifier modifier$iv7 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv7 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap localMap$iv$iv8 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer4, modifier$iv7);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                function9 = constructor;
                $composer4.createNode(function9);
            } else {
                function9 = constructor;
                $composer4.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer4);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash7);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
            int i114 = ($changed$iv$iv$iv7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i115 = ((0 >> 6) & 112) | 6;
            RowScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -4769636, "C96@4043L1028,123@5085L1067:FormatItem.kt#g7nzpb");
            Modifier modifier$iv8 = RowScope.CC.weight$default($this$FormatVideoPreview_u24lambda_u249_u24lambda_u243, Modifier.INSTANCE, imageWeight, false, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv5 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv8 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv5, false);
            int $changed$iv$iv8 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap localMap$iv$iv9 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer4, modifier$iv8);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                function10 = constructor2;
                $composer4.createNode(function10);
            } else {
                function10 = constructor2;
                $composer4.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer4);
            $composer2 = $composer4;
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash8);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
            int i116 = ($changed$iv$iv$iv8 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i117 = ((0 >> 6) & 112) | 6;
            BoxScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u242_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 271223215, "C102@4295L85,100@4157L241,111@4659L6,112@4695L362,106@4415L642:FormatItem.kt#g7nzpb");
            VideoListItemKt.MediaImage(Modifier.INSTANCE, thumbnailUrl, false, StringResources_androidKt.stringResource(R.string.thumbnail, $composer4, 0), $composer4, (($dirty >> 6) & 112) | 390, 0);
            int $dirty4 = $dirty;
            Modifier modifierAlign4 = $this$FormatVideoPreview_u24lambda_u249_u24lambda_u242_u24lambda_u241.align(PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(2)), Alignment.INSTANCE.getBottomEnd());
            long jM4069getBlack0d7_KjU2 = Color.INSTANCE.m4069getBlack0d7_KjU();
            SurfaceKt.m2418SurfaceT9BRK9s(modifierAlign4, MaterialTheme.INSTANCE.getShapes($composer4, MaterialTheme.$stable).getExtraSmall(), Color.m4041copywmQWz5c(jM4069getBlack0d7_KjU2, (14 & 1) != 0 ? Color.m4045getAlphaimpl(jM4069getBlack0d7_KjU2) : 0.68f, (14 & 2) != 0 ? Color.m4049getRedimpl(jM4069getBlack0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl(jM4069getBlack0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl(jM4069getBlack0d7_KjU2) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(332428063, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer5, int $changed2) {
                    ComposerKt.sourceInformation($composer5, "C117@4951L10,114@4782L257:FormatItem.kt#g7nzpb");
                    if (($changed2 & 11) != 2 || !$composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(332428063, $changed2, -1, "com.videshkarmakar.loop.ui.component.FormatVideoPreview.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FormatItem.kt:113)");
                        }
                        String durationText = TextUtilKt.toDurationText(duration);
                        TextKt.m2569Text4IGK_g(durationText, PaddingKt.m622paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6553constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4080getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getLabelSmall(), $composer5, 432, 0, 65528);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer5.skipToGroupEnd();
                }
            }, $composer4, 54), $composer4, 12583296, 120);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv9 = RowScope.CC.weight$default($this$FormatVideoPreview_u24lambda_u249_u24lambda_u243, Modifier.INSTANCE, 1.0f - imageWeight, false, 2, null);
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv9 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv9 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer4, modifier$iv9);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                function11 = constructor3;
                $composer4.createNode(function11);
            } else {
                function11 = constructor3;
                $composer4.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer4);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                localMap$iv$iv2 = localMap$iv$iv;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                int i118 = ($changed$iv$iv$iv9 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                int i119 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 271224304, "C132@5462L10,133@5527L11,127@5246L409:FormatItem.kt#g7nzpb");
                modifier2 = modifier3;
                TextKt.m2569Text4IGK_g(title, PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleSmall(), $composer4, (($dirty4 >> 3) & 14) | 48, 3120, 55288);
                $composer4.startReplaceGroup(-4768007);
                ComposerKt.sourceInformation($composer4, "142@5940L10,143@6004L11,137@5718L420");
                if (Intrinsics.areEqual(author, "playlist")) {
                    $composer3 = $composer4;
                } else {
                    $composer3 = $composer4;
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
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
                $composer4.startReplaceGroup(-1639921957);
                ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer4.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                expanded$delegate = (MutableState) value$iv;
                $composer4.endReplaceGroup();
                Modifier modifier$iv10 = $this$FormatVideoPreview_u24lambda_u2410.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv6 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv10 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv6, false);
                int $changed$iv$iv10 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                CompositionLocalMap localMap$iv$iv10 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv10 = ComposedModifierKt.materializeModifier($composer4, modifier$iv10);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv10 = (($changed$iv$iv10 << 6) & 896) | 6;
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
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash10);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv10, ComposeUiNode.INSTANCE.getSetModifier());
                int i1110 = ($changed$iv$iv$iv10 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i1111 = ((0 >> 6) & 112) | 6;
                BoxScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u2410 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -4767361, "C154@6356L19,153@6318L356,168@6890L21,167@6838L20,169@6926L1635,164@6688L1873:FormatItem.kt#g7nzpb");
                $composer4.startReplaceGroup(-4767323);
                ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                value$iv2 = $composer4.rememberedValue();
                if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$1$1
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
                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, true);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                }
                $composer4.endReplaceGroup();
                IconButtonKt.IconButton((Function0) value$iv2, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(36)), false, null, null, ComposableSingletons$FormatItemKt.INSTANCE.m7125getLambda1$app_debug(), $composer4, 196662, 28);
                Modifier modifierAlign5 = $this$FormatVideoPreview_u24lambda_u249_u24lambda_u2410.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
                boolean zFormatVideoPreview$lambda$9$lambda$6 = FormatVideoPreview$lambda$9$lambda$4(expanded$delegate);
                ScrollState scrollStateRememberScrollState3 = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
                $composer4.startReplaceGroup(-4766841);
                ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
                it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$2$1
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
                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, false);
                        }
                    };
                    $composer4.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv2;
                }
                $composer4.endReplaceGroup();
                final Function0<Unit> function110 = function4;
                final Function0<Unit> function111 = function5;
                final boolean z6 = isClippingAvailable2;
                final Function0<Unit> function112 = function6;
                final boolean z7 = isSplitByChapterAvailable2;
                final Function0<Unit> function113 = function7;
                AndroidMenu_androidKt.m1666DropdownMenuIlH_yew(zFormatVideoPreview$lambda$9$lambda$6, (Function0) value$iv3, modifierAlign5, 0L, scrollStateRememberScrollState3, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1495670651, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope DropdownMenu, Composer $composer5, int $changed2) {
                        Object value$iv4;
                        Object value$iv5;
                        Object value$iv6;
                        Object value$iv7;
                        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                        ComposerKt.sourceInformation($composer5, "C173@7159L99,170@6944L315,180@7495L106,177@7276L326,197@8407L121,194@8180L349:FormatItem.kt#g7nzpb");
                        if (($changed2 & 81) != 16 || !$composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1495670651, $changed2, -1, "com.videshkarmakar.loop.ui.component.FormatVideoPreview.<anonymous>.<anonymous>.<anonymous> (FormatItem.kt:170)");
                            }
                            Function2<Composer, Integer, Unit> function2M7133getLambda2$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7133getLambda2$app_debug();
                            $composer5.startReplaceGroup(271226217);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                            boolean invalid$iv = $composer5.changed(function110);
                            final Function0<Unit> function114 = function110;
                            final MutableState<Boolean> mutableState = expanded$delegate;
                            Object it$iv3 = $composer5.rememberedValue();
                            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$1$1
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
                                        function114.invoke();
                                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState, false);
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv3;
                            }
                            $composer5.endReplaceGroup();
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7133getLambda2$app_debug, (Function0) value$iv4, null, ComposableSingletons$FormatItemKt.INSTANCE.m7134getLambda3$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            Function2<Composer, Integer, Unit> function2M7135getLambda4$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7135getLambda4$app_debug();
                            $composer5.startReplaceGroup(271226553);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                            boolean invalid$iv2 = $composer5.changed(function111);
                            final Function0<Unit> function115 = function111;
                            final MutableState<Boolean> mutableState2 = expanded$delegate;
                            Object it$iv4 = $composer5.rememberedValue();
                            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$2$1
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
                                        function115.invoke();
                                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState2, false);
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv4;
                            }
                            $composer5.endReplaceGroup();
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7135getLambda4$app_debug, (Function0) value$iv5, null, ComposableSingletons$FormatItemKt.INSTANCE.m7136getLambda5$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            $composer5.startReplaceGroup(271226677);
                            ComposerKt.sourceInformation($composer5, "188@7930L120,185@7707L344");
                            if (z6 && !isClippingVideo && !isSplittingVideo) {
                                Function2<Composer, Integer, Unit> function2M7137getLambda6$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7137getLambda6$app_debug();
                                $composer5.startReplaceGroup(271226988);
                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                boolean invalid$iv3 = $composer5.changed(function112);
                                final Function0<Unit> function116 = function112;
                                final MutableState<Boolean> mutableState3 = expanded$delegate;
                                Object it$iv5 = $composer5.rememberedValue();
                                if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$3$1
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
                                            function116.invoke();
                                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState3, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv7);
                                } else {
                                    value$iv7 = it$iv5;
                                }
                                $composer5.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(function2M7137getLambda6$app_debug, (Function0) value$iv7, null, ComposableSingletons$FormatItemKt.INSTANCE.m7138getLambda7$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            }
                            $composer5.endReplaceGroup();
                            if (z7 && !isClippingVideo && !isSplittingVideo) {
                                Function2<Composer, Integer, Unit> function2M7139getLambda8$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7139getLambda8$app_debug();
                                $composer5.startReplaceGroup(271227465);
                                ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                                boolean invalid$iv4 = $composer5.changed(function113);
                                final Function0<Unit> function117 = function113;
                                final MutableState<Boolean> mutableState4 = expanded$delegate;
                                Object it$iv6 = $composer5.rememberedValue();
                                if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                                    value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$4$1
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
                                            function117.invoke();
                                            FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState4, false);
                                        }
                                    };
                                    $composer5.updateRememberedValue(value$iv6);
                                } else {
                                    value$iv6 = it$iv6;
                                }
                                $composer5.endReplaceGroup();
                                AndroidMenu_androidKt.DropdownMenuItem(function2M7139getLambda8$app_debug, (Function0) value$iv6, null, ComposableSingletons$FormatItemKt.INSTANCE.m7140getLambda9$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer5.skipToGroupEnd();
                    }
                }, $composer4, 54), $composer4, 48, 48, 2024);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                localMap$iv$iv2 = localMap$iv$iv;
            }
            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash9);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
            int i1112 = ($changed$iv$iv$iv9 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            int i1113 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 271224304, "C132@5462L10,133@5527L11,127@5246L409:FormatItem.kt#g7nzpb");
            modifier2 = modifier3;
            TextKt.m2569Text4IGK_g(title, PaddingKt.m622paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6553constructorimpl(12), 0.0f, 2, null), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleSmall(), $composer4, (($dirty4 >> 3) & 14) | 48, 3120, 55288);
            $composer4.startReplaceGroup(-4768007);
            ComposerKt.sourceInformation($composer4, "142@5940L10,143@6004L11,137@5718L420");
            if (Intrinsics.areEqual(author, "playlist")) {
                $composer3 = $composer4;
            } else {
                $composer3 = $composer4;
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            $composer4.startReplaceGroup(-1639921957);
            ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
            it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer4.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            expanded$delegate = (MutableState) value$iv;
            $composer4.endReplaceGroup();
            Modifier modifier$iv11 = $this$FormatVideoPreview_u24lambda_u2410.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv7 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv11 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv7, false);
            int $changed$iv$iv11 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap localMap$iv$iv11 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer4, modifier$iv11);
            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv11 = (($changed$iv$iv11 << 6) & 896) | 6;
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
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
            $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash11);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
            int i1114 = ($changed$iv$iv$iv11 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i1115 = ((0 >> 6) & 112) | 6;
            BoxScope $this$FormatVideoPreview_u24lambda_u249_u24lambda_u2411 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -4767361, "C154@6356L19,153@6318L356,168@6890L21,167@6838L20,169@6926L1635,164@6688L1873:FormatItem.kt#g7nzpb");
            $composer4.startReplaceGroup(-4767323);
            ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
            value$iv2 = $composer4.rememberedValue();
            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$1$1
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
                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, true);
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
            }
            $composer4.endReplaceGroup();
            IconButtonKt.IconButton((Function0) value$iv2, SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(36)), false, null, null, ComposableSingletons$FormatItemKt.INSTANCE.m7125getLambda1$app_debug(), $composer4, 196662, 28);
            Modifier modifierAlign6 = $this$FormatVideoPreview_u24lambda_u249_u24lambda_u2411.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd());
            boolean zFormatVideoPreview$lambda$9$lambda$7 = FormatVideoPreview$lambda$9$lambda$4(expanded$delegate);
            ScrollState scrollStateRememberScrollState4 = ScrollKt.rememberScrollState(0, $composer4, 0, 1);
            $composer4.startReplaceGroup(-4766841);
            ComposerKt.sourceInformation($composer4, "CC(remember):FormatItem.kt#9igjgp");
            it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function0) new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$2$1
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
                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(expanded$delegate, false);
                    }
                };
                $composer4.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv2;
            }
            $composer4.endReplaceGroup();
            final Function0<Unit> function114 = function4;
            final Function0<Unit> function115 = function5;
            final boolean z8 = isClippingAvailable2;
            final Function0<Unit> function116 = function6;
            final boolean z9 = isSplitByChapterAvailable2;
            final Function0<Unit> function117 = function7;
            AndroidMenu_androidKt.m1666DropdownMenuIlH_yew(zFormatVideoPreview$lambda$9$lambda$7, (Function0) value$iv3, modifierAlign6, 0L, scrollStateRememberScrollState4, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1495670651, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope DropdownMenu, Composer $composer5, int $changed2) {
                    Object value$iv4;
                    Object value$iv5;
                    Object value$iv6;
                    Object value$iv7;
                    Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                    ComposerKt.sourceInformation($composer5, "C173@7159L99,170@6944L315,180@7495L106,177@7276L326,197@8407L121,194@8180L349:FormatItem.kt#g7nzpb");
                    if (($changed2 & 81) != 16 || !$composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1495670651, $changed2, -1, "com.videshkarmakar.loop.ui.component.FormatVideoPreview.<anonymous>.<anonymous>.<anonymous> (FormatItem.kt:170)");
                        }
                        Function2<Composer, Integer, Unit> function2M7133getLambda2$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7133getLambda2$app_debug();
                        $composer5.startReplaceGroup(271226217);
                        ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                        boolean invalid$iv = $composer5.changed(function114);
                        final Function0<Unit> function118 = function114;
                        final MutableState<Boolean> mutableState = expanded$delegate;
                        Object it$iv3 = $composer5.rememberedValue();
                        if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$1$1
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
                                    function118.invoke();
                                    FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState, false);
                                }
                            };
                            $composer5.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv3;
                        }
                        $composer5.endReplaceGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(function2M7133getLambda2$app_debug, (Function0) value$iv4, null, ComposableSingletons$FormatItemKt.INSTANCE.m7134getLambda3$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                        Function2<Composer, Integer, Unit> function2M7135getLambda4$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7135getLambda4$app_debug();
                        $composer5.startReplaceGroup(271226553);
                        ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                        boolean invalid$iv2 = $composer5.changed(function115);
                        final Function0<Unit> function119 = function115;
                        final MutableState<Boolean> mutableState2 = expanded$delegate;
                        Object it$iv4 = $composer5.rememberedValue();
                        if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$2$1
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
                                    function119.invoke();
                                    FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState2, false);
                                }
                            };
                            $composer5.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv4;
                        }
                        $composer5.endReplaceGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(function2M7135getLambda4$app_debug, (Function0) value$iv5, null, ComposableSingletons$FormatItemKt.INSTANCE.m7136getLambda5$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                        $composer5.startReplaceGroup(271226677);
                        ComposerKt.sourceInformation($composer5, "188@7930L120,185@7707L344");
                        if (z8 && !isClippingVideo && !isSplittingVideo) {
                            Function2<Composer, Integer, Unit> function2M7137getLambda6$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7137getLambda6$app_debug();
                            $composer5.startReplaceGroup(271226988);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                            boolean invalid$iv3 = $composer5.changed(function116);
                            final Function0<Unit> function1110 = function116;
                            final MutableState<Boolean> mutableState3 = expanded$delegate;
                            Object it$iv5 = $composer5.rememberedValue();
                            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                value$iv7 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$3$1
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
                                        function1110.invoke();
                                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState3, false);
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv7);
                            } else {
                                value$iv7 = it$iv5;
                            }
                            $composer5.endReplaceGroup();
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7137getLambda6$app_debug, (Function0) value$iv7, null, ComposableSingletons$FormatItemKt.INSTANCE.m7138getLambda7$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                        }
                        $composer5.endReplaceGroup();
                        if (z9 && !isClippingVideo && !isSplittingVideo) {
                            Function2<Composer, Integer, Unit> function2M7139getLambda8$app_debug = ComposableSingletons$FormatItemKt.INSTANCE.m7139getLambda8$app_debug();
                            $composer5.startReplaceGroup(271227465);
                            ComposerKt.sourceInformation($composer5, "CC(remember):FormatItem.kt#9igjgp");
                            boolean invalid$iv4 = $composer5.changed(function117);
                            final Function0<Unit> function1111 = function117;
                            final MutableState<Boolean> mutableState4 = expanded$delegate;
                            Object it$iv6 = $composer5.rememberedValue();
                            if (invalid$iv4 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                                value$iv6 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatVideoPreview$5$2$3$4$1
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
                                        function1111.invoke();
                                        FormatItemKt.FormatVideoPreview$lambda$9$lambda$5(mutableState4, false);
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv6);
                            } else {
                                value$iv6 = it$iv6;
                            }
                            $composer5.endReplaceGroup();
                            AndroidMenu_androidKt.DropdownMenuItem(function2M7139getLambda8$app_debug, (Function0) value$iv6, null, ComposableSingletons$FormatItemKt.INSTANCE.m7140getLambda9$app_debug(), null, false, null, null, null, $composer5, 3078, 500);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer5.skipToGroupEnd();
                }
            }, $composer4, 54), $composer4, 48, 48, 2024);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
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
            final Modifier modifier4 = modifier2;
            final boolean z10 = isClippingAvailable2;
            final boolean z11 = isSplitByChapterAvailable2;
            final Function0<Unit> function20 = function4;
            final Function0<Unit> function21 = function5;
            final Function0<Unit> function22 = function6;
            final Function0<Unit> function23 = function7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatVideoPreview.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i21) {
                    FormatItemKt.FormatVideoPreview(modifier4, title, author, thumbnailUrl, duration, isSplittingVideo, isClippingVideo, z10, z11, function20, function21, function22, function23, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    private static final boolean FormatVideoPreview$lambda$9$lambda$4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FormatVideoPreview$lambda$9$lambda$5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public static final void VideoInfoPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(934202636);
        ComposerKt.sourceInformation($composer2, "C(VideoInfoPreview)212@8633L617:FormatItem.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(934202636, $changed, -1, "com.videshkarmakar.loop.ui.component.VideoInfoPreview (FormatItem.kt:211)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$FormatItemKt.INSTANCE.m7127getLambda11$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.VideoInfoPreview.1
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
                    FormatItemKt.VideoInfoPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void SuggestedFormatItem(Modifier modifier, final VideoInfo videoInfo, boolean selected, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean selected2;
        Function0<Unit> function1;
        boolean containsVideo;
        boolean containsAudio;
        String str;
        double dDoubleValue;
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Composer $composer2 = $composer.startRestartGroup(313954754);
        ComposerKt.sourceInformation($composer2, "C(SuggestedFormatItem)P(!1,3,2)254@10143L16,283@11002L282:FormatItem.kt#g7nzpb");
        if ((i & 1) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) == 0) {
            selected2 = selected;
        } else {
            selected2 = false;
        }
        if ((i & 8) == 0) {
            function1 = function0;
        } else {
            function1 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.SuggestedFormatItem.1
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(313954754, $changed, -1, "com.videshkarmakar.loop.ui.component.SuggestedFormatItem (FormatItem.kt:238)");
        }
        Iterable $this$map$iv = videoInfo.getRequestedFormats();
        if ($this$map$iv == null) {
            Iterable requestedDownloads = videoInfo.getRequestedDownloads();
            if (requestedDownloads != null) {
                Iterable $this$map$iv2 = requestedDownloads;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    RequestedDownload it = (RequestedDownload) item$iv$iv;
                    destination$iv$iv.add(it.toFormat());
                }
                $this$map$iv = (List) destination$iv$iv;
            } else {
                $this$map$iv = null;
            }
            if ($this$map$iv == null) {
                $this$map$iv = CollectionsKt.emptyList();
            }
        }
        Iterable iterable = $this$map$iv;
        Double duration = videoInfo.getDuration();
        double duration2 = duration != null ? duration.doubleValue() : 0.0d;
        Iterable $this$any$iv = iterable;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it2 = $this$any$iv.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object element$iv = it2.next();
                    Format it3 = (Format) element$iv;
                    if (toEmpty(it3.getVcodec()).length() > 0) {
                        containsVideo = true;
                        break;
                    }
                } else {
                    containsVideo = false;
                    break;
                }
            }
        } else {
            containsVideo = false;
        }
        Iterable $this$any$iv2 = iterable;
        if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
            Iterator it4 = $this$any$iv2.iterator();
            while (true) {
                if (it4.hasNext()) {
                    Object element$iv2 = it4.next();
                    Format it5 = (Format) element$iv2;
                    if (toEmpty(it5.getAcodec()).length() > 0) {
                        containsAudio = true;
                        break;
                    }
                } else {
                    containsAudio = false;
                    break;
                }
            }
        } else {
            containsAudio = false;
        }
        String title = CollectionsKt.joinToString$default(iterable, " + ", null, null, 0, null, new Function1<Format, CharSequence>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$SuggestedFormatItem$title$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Format it6) {
                Intrinsics.checkNotNullParameter(it6, "it");
                return String.valueOf(it6.getFormat());
            }
        }, 30, null);
        Iterable $this$fold$iv = iterable;
        double initial$iv = 0.0d;
        double accumulator$iv = 0.0d;
        for (Object element$iv3 : $this$fold$iv) {
            Format format = (Format) element$iv3;
            double acc = accumulator$iv;
            Double fileSize = format.getFileSize();
            if (fileSize == null && (fileSize = format.getFileSizeApprox()) == null) {
                Double tbr = format.getTbr();
                dDoubleValue = (tbr != null ? tbr.doubleValue() : 0.0d) * duration2 * ((double) 125);
            } else {
                dDoubleValue = fileSize.doubleValue();
            }
            accumulator$iv = acc + dDoubleValue;
            initial$iv = initial$iv;
        }
        double totalFileSize = accumulator$iv;
        String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(totalFileSize), $composer2, 0);
        Iterable $this$fold$iv2 = iterable;
        double accumulator$iv2 = 0.0d;
        for (Object element$iv4 : $this$fold$iv2) {
            double acc2 = accumulator$iv2;
            Double tbr2 = ((Format) element$iv4).getTbr();
            accumulator$iv2 = acc2 + (tbr2 != null ? tbr2.doubleValue() : 0.0d);
        }
        double totalTbr = accumulator$iv2;
        if (totalTbr <= 0.0d) {
            str = "";
        } else if (totalTbr < 1024.0d) {
            str = String.format("%.1f Kbps", Arrays.copyOf(new Object[]{Double.valueOf(totalTbr)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            str = String.format("%.2f Mbps", Arrays.copyOf(new Object[]{Double.valueOf(totalTbr / ((double) 1024.0f))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        String tbrText = str;
        String firstLineText = TextUtilKt.connectWithDelimiter(new String[]{fileSizeText, tbrText}, " ");
        String vcodecText = StringsKt.substringBefore$default(toEmpty(videoInfo.getVcodec()), ".", (String) null, 2, (Object) null);
        String acodecText = StringsKt.substringBefore$default(toEmpty(videoInfo.getAcodec()), ".", (String) null, 2, (Object) null);
        String $this$SuggestedFormatItem_u24lambda_u2415 = TextUtilKt.connectWithBlank(vcodecText, acodecText);
        if (!StringsKt.isBlank($this$SuggestedFormatItem_u24lambda_u2415)) {
            $this$SuggestedFormatItem_u24lambda_u2415 = "(" + $this$SuggestedFormatItem_u24lambda_u2415 + ")";
        }
        String codecText = $this$SuggestedFormatItem_u24lambda_u2415;
        String secondLineText = TextUtilKt.connectWithDelimiter(new String[]{videoInfo.getExt(), codecText}, " ").toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(secondLineText, "toUpperCase(...)");
        m7166FormatItemuPCbpMU(modifier2, title, containsAudio, containsVideo, firstLineText, secondLineText, selected2, 0L, 0L, null, function1, $composer2, ($changed & 14) | (($changed << 12) & 3670016), ($changed >> 9) & 14, 896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z = selected2;
            final Function0<Unit> function2 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.SuggestedFormatItem.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i2) {
                    FormatItemKt.SuggestedFormatItem(modifier3, videoInfo, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: FormatItem-bogVsAg, reason: not valid java name */
    public static final void m7165FormatItembogVsAg(Modifier modifier, final Format formatInfo, final double duration, boolean selected, long outlineColor, long containerColor, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        long j;
        Modifier.Companion modifier2;
        boolean selected2;
        long outlineColor2;
        long containerColor2;
        Function0<Unit> function2;
        FormatItemKt$FormatItem$1 formatItemKt$FormatItem$1;
        String str;
        Double dValueOf;
        Function0<Unit> function3;
        Function0<Unit> function4;
        Modifier modifier3;
        long containerColor3;
        boolean selected3;
        Intrinsics.checkNotNullParameter(formatInfo, "formatInfo");
        Composer $composer2 = $composer.startRestartGroup(-1086348924);
        ComposerKt.sourceInformation($composer2, "C(FormatItem)P(3,2,1,7,6:c#ui.graphics.Color,0:c#ui.graphics.Color,5)302@11469L11,303@11532L11,*328@12302L16,336@12523L475:FormatItem.kt#g7nzpb");
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
            $dirty |= $composer2.changed(formatInfo) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(duration) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = selected;
        } else if (($changed & 7168) == 0) {
            z = selected;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = selected;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                j = outlineColor;
                int i4 = $composer2.changed(j) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                j = outlineColor;
            }
            $dirty |= i4;
        } else {
            j = outlineColor;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= ((i & 32) == 0 && $composer2.changed(containerColor)) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            containerColor3 = containerColor;
            function4 = function0;
            function3 = function1;
            selected3 = z;
            outlineColor2 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                selected2 = i3 != 0 ? false : z;
                if ((i & 16) != 0) {
                    outlineColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                    $dirty &= -57345;
                } else {
                    outlineColor2 = j;
                }
                if ((i & 32) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimaryContainer();
                    $dirty &= -458753;
                } else {
                    containerColor2 = containerColor;
                }
                function2 = i5 != 0 ? null : function0;
                formatItemKt$FormatItem$1 = i6 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$1
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
                if ((i & 32) != 0) {
                    modifier2 = modifier;
                    function2 = function0;
                    $dirty &= -458753;
                    selected2 = z;
                    outlineColor2 = j;
                    containerColor2 = containerColor;
                    formatItemKt$FormatItem$1 = function1;
                } else {
                    modifier2 = modifier;
                    function2 = function0;
                    formatItemKt$FormatItem$1 = function1;
                    selected2 = z;
                    outlineColor2 = j;
                    containerColor2 = containerColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1086348924, $dirty, -1, "com.videshkarmakar.loop.ui.component.FormatItem (FormatItem.kt:306)");
            }
            Function0<Unit> function5 = formatItemKt$FormatItem$1;
            String vcodecText = StringsKt.substringBefore$default(toEmpty(formatInfo.getVcodec()), ".", (String) null, 2, (Object) null);
            Function0<Unit> function6 = function2;
            String acodecText = StringsKt.substringBefore$default(toEmpty(formatInfo.getAcodec()), ".", (String) null, 2, (Object) null);
            String $this$FormatItem_bogVsAg_u24lambda_u2417_u24lambda_u2416 = TextUtilKt.connectWithBlank(vcodecText, acodecText);
            if (!StringsKt.isBlank($this$FormatItem_bogVsAg_u24lambda_u2417_u24lambda_u2416)) {
                $this$FormatItem_bogVsAg_u24lambda_u2417_u24lambda_u2416 = "(" + $this$FormatItem_bogVsAg_u24lambda_u2417_u24lambda_u2416 + ")";
            }
            if (formatInfo.getTbr() == null) {
                str = "";
            } else if (formatInfo.getTbr().doubleValue() < 1024.0d) {
                String str2 = String.format("%.1f Kbps", Arrays.copyOf(new Object[]{formatInfo.getTbr()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                str = str2;
            } else {
                String str3 = String.format("%.2f Mbps", Arrays.copyOf(new Object[]{Double.valueOf(formatInfo.getTbr().doubleValue() / ((double) 1024.0f))}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                str = str3;
            }
            String tbrText = str;
            Double fileSize = formatInfo.getFileSize();
            if (fileSize == null && (fileSize = formatInfo.getFileSizeApprox()) == null) {
                Double tbr = formatInfo.getTbr();
                dValueOf = tbr != null ? Double.valueOf(tbr.doubleValue() * ((double) 125) * duration) : null;
            } else {
                dValueOf = fileSize;
            }
            Double fileSize2 = dValueOf;
            String fileSizeText = TextUtilKt.toFileSizeText(fileSize2, $composer2, 0);
            String firstLineText = TextUtilKt.connectWithDelimiter(new String[]{fileSizeText, tbrText}, " ");
            String secondLineText = TextUtilKt.connectWithDelimiter(new String[]{formatInfo.getExt(), $this$FormatItem_bogVsAg_u24lambda_u2417_u24lambda_u2416}, " ").toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(secondLineText, "toUpperCase(...)");
            m7166FormatItemuPCbpMU(modifier2, String.valueOf(formatInfo.getFormat()), acodecText.length() > 0, vcodecText.length() > 0, firstLineText, secondLineText, selected2, outlineColor2, containerColor2, function6, function5, $composer2, ($dirty & 14) | (($dirty << 9) & 3670016) | (($dirty << 9) & 29360128) | (($dirty << 9) & 234881024) | (1879048192 & ($dirty << 9)), ($dirty >> 21) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function5;
            function4 = function6;
            modifier3 = modifier2;
            containerColor3 = containerColor2;
            selected3 = selected2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = selected3;
            final long j2 = outlineColor2;
            final long j3 = containerColor3;
            final Function0<Unit> function7 = function4;
            final Function0<Unit> function8 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$3
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
                    FormatItemKt.m7165FormatItembogVsAg(modifier4, formatInfo, duration, z2, j2, j3, function7, function8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0132  */
    /* JADX WARN: Code duplicated, block: B:102:0x0139  */
    /* JADX WARN: Code duplicated, block: B:104:0x013f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0147  */
    /* JADX WARN: Code duplicated, block: B:107:0x014a  */
    /* JADX WARN: Code duplicated, block: B:109:0x014e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0154  */
    /* JADX WARN: Code duplicated, block: B:113:0x0159  */
    /* JADX WARN: Code duplicated, block: B:115:0x015d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x0168  */
    /* JADX WARN: Code duplicated, block: B:120:0x016d  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:141:0x01eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:143:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:146:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:148:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:149:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:151:0x0200  */
    /* JADX WARN: Code duplicated, block: B:152:0x0202  */
    /* JADX WARN: Code duplicated, block: B:154:0x0206  */
    /* JADX WARN: Code duplicated, block: B:155:0x0208  */
    /* JADX WARN: Code duplicated, block: B:158:0x020e  */
    /* JADX WARN: Code duplicated, block: B:159:0x021f  */
    /* JADX WARN: Code duplicated, block: B:162:0x0225  */
    /* JADX WARN: Code duplicated, block: B:163:0x0238  */
    /* JADX WARN: Code duplicated, block: B:165:0x023e  */
    /* JADX WARN: Code duplicated, block: B:166:0x0240  */
    /* JADX WARN: Code duplicated, block: B:168:0x0244  */
    /* JADX WARN: Code duplicated, block: B:169:0x025b  */
    /* JADX WARN: Code duplicated, block: B:172:0x0277  */
    /* JADX WARN: Code duplicated, block: B:175:0x028c  */
    /* JADX WARN: Code duplicated, block: B:176:0x028f  */
    /* JADX WARN: Code duplicated, block: B:179:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:180:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:183:0x030f  */
    /* JADX WARN: Code duplicated, block: B:184:0x0312  */
    /* JADX WARN: Code duplicated, block: B:187:0x0363  */
    /* JADX WARN: Code duplicated, block: B:188:0x0365  */
    /* JADX WARN: Code duplicated, block: B:191:0x0370  */
    /* JADX WARN: Code duplicated, block: B:195:0x037b  */
    /* JADX WARN: Code duplicated, block: B:198:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:199:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:202:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:206:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:209:0x048a  */
    /* JADX WARN: Code duplicated, block: B:212:0x0496  */
    /* JADX WARN: Code duplicated, block: B:213:0x049c  */
    /* JADX WARN: Code duplicated, block: B:216:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:219:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:220:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:224:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:227:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:228:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:231:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:234:0x0603  */
    /* JADX WARN: Code duplicated, block: B:235:0x0606  */
    /* JADX WARN: Code duplicated, block: B:239:0x0858  */
    /* JADX WARN: Code duplicated, block: B:242:0x0864  */
    /* JADX WARN: Code duplicated, block: B:243:0x0868  */
    /* JADX WARN: Code duplicated, block: B:246:0x0896  */
    /* JADX WARN: Code duplicated, block: B:250:0x08ac A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:254:0x0904  */
    /* JADX WARN: Code duplicated, block: B:255:0x0944  */
    /* JADX WARN: Code duplicated, block: B:258:0x095a  */
    /* JADX WARN: Code duplicated, block: B:261:0x09a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:265:0x0a17  */
    /* JADX WARN: Code duplicated, block: B:268:0x0a20  */
    /* JADX WARN: Code duplicated, block: B:270:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x0110  */
    /* JADX WARN: Code duplicated, block: B:90:0x0117  */
    /* JADX WARN: Code duplicated, block: B:98:0x012c  */
    /* JADX INFO: renamed from: FormatItem-uPCbpMU, reason: not valid java name */
    public static final void m7166FormatItemuPCbpMU(Modifier modifier, String title, boolean containsAudio, boolean containsVideo, final String firstLineText, final String secondLineText, boolean selected, long outlineColor, long containerColor, Function0<Unit> function0, Function0<Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        String str;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Modifier.Companion modifier3;
        String title2;
        boolean containsAudio2;
        boolean containsVideo2;
        boolean selected2;
        long outlineColor2;
        long containerColor2;
        Function0<Unit> function2;
        final Function0<Unit> function3;
        Function0<Unit> function4;
        String title3;
        boolean containsAudio3;
        boolean containsVideo3;
        boolean selected3;
        long outlineColor3;
        long containerColor3;
        Modifier modifier4;
        int $dirty;
        long onSurface;
        long surface;
        long outlineVariant;
        boolean invalid$iv;
        Object value$iv;
        boolean z2;
        boolean invalid$iv2;
        Object value$iv2;
        int compositeKeyHash$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function5;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        CompositionLocalMap localMap$iv$iv2;
        int $dirty1;
        MeasurePolicy measurePolicy$iv;
        int compositeKeyHash$iv$iv2;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> function6;
        Composer $this$Layout_u24lambda_u240$iv$iv2;
        MeasurePolicy measurePolicy$iv2;
        String str2;
        int $dirty2;
        Function0<Unit> function7;
        Composer $composer2;
        Modifier modifier5;
        int compositeKeyHash$iv$iv3;
        Function0<ComposeUiNode> constructor3;
        Composer $this$Layout_u24lambda_u240$iv$iv3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(firstLineText, "firstLineText");
        Intrinsics.checkNotNullParameter(secondLineText, "secondLineText");
        Composer $composer3 = $composer.startRestartGroup(-1753898537);
        ComposerKt.sourceInformation($composer3, "C(FormatItem)P(4,10,1,2,3,8,9,7:c#ui.graphics.Color,0:c#ui.graphics.Color,6)362@13355L11,363@13418L11,368@13551L150,373@13737L150,378@13921L169,384@14148L6,385@14204L13,389@14353L34,387@14268L13,392@14493L6,383@14096L2461:FormatItem.kt#g7nzpb");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        int i9 = i & 1;
        if (i9 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 2;
        if (i10 != 0) {
            $dirty3 |= 48;
            str = title;
        } else if (($changed & 112) == 0) {
            str = title;
            $dirty3 |= $composer3.changed(str) ? 32 : 16;
        } else {
            str = title;
        }
        int i11 = i & 4;
        if (i11 != 0) {
            $dirty3 |= 384;
            z = containsAudio;
        } else if (($changed & 896) == 0) {
            z = containsAudio;
            $dirty3 |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = containsAudio;
        }
        int i12 = i & 8;
        if (i12 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(containsVideo) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(firstLineText) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            if (($changed & 458752) == 0) {
                i2 = $composer3.changed(secondLineText) ? 131072 : 65536;
            }
            i3 = i & 64;
            if (i3 != 0) {
                $dirty3 |= 1572864;
            } else if (($changed & 3670016) != 0) {
                if ($composer3.changed(selected)) {
                    i4 = 1048576;
                } else {
                    i4 = 524288;
                }
                $dirty3 |= i4;
            }
            if (($changed & 29360128) != 0) {
                $dirty3 |= ((i & 128) == 0 || !$composer3.changed(outlineColor)) ? 4194304 : 8388608;
            }
            if ((234881024 & $changed) != 0) {
                $dirty3 |= ((i & 256) == 0 || !$composer3.changed(containerColor)) ? 33554432 : AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            }
            i5 = i & 512;
            if (i5 != 0) {
                $dirty3 |= 805306368;
            } else if (($changed & 1879048192) != 0) {
                if ($composer3.changedInstance(function0)) {
                    i6 = 536870912;
                } else {
                    i6 = 268435456;
                }
                $dirty3 |= i6;
            }
            i7 = i & 1024;
            if (i7 != 0) {
                $dirty4 |= 6;
            } else if (($changed1 & 14) != 0) {
                if ($composer3.changedInstance(function1)) {
                    i8 = 4;
                } else {
                    i8 = 2;
                }
                $dirty4 |= i8;
            }
            if (($dirty3 & 1533916891) != 306783378 && ($dirty4 & 11) == 2 && $composer3.getSkipping()) {
                $composer3.skipToGroupEnd();
                containsVideo3 = containsVideo;
                selected3 = selected;
                outlineColor3 = outlineColor;
                containerColor3 = containerColor;
                function4 = function0;
                function7 = function1;
                modifier5 = modifier2;
                title3 = str;
                containsAudio3 = z;
                $composer2 = $composer3;
            } else {
                $composer3.startDefaults();
                if (($changed & 1) != 0 || $composer3.getDefaultsInvalid()) {
                    if (i9 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        title2 = "247 - 1280x720 (720p)";
                    } else {
                        title2 = str;
                    }
                    if (i11 != 0) {
                        containsAudio2 = false;
                    } else {
                        containsAudio2 = z;
                    }
                    if (i12 != 0) {
                        containsVideo2 = false;
                    } else {
                        containsVideo2 = containsVideo;
                    }
                    if (i3 != 0) {
                        selected2 = false;
                    } else {
                        selected2 = selected;
                    }
                    if ((i & 128) != 0) {
                        outlineColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                        $dirty3 &= -29360129;
                    } else {
                        outlineColor2 = outlineColor;
                    }
                    if ((i & 256) != 0) {
                        containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer();
                        $dirty3 &= -234881025;
                    } else {
                        containerColor2 = containerColor;
                    }
                    if (i5 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i7 != 0) {
                        function4 = function2;
                        function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$4
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
                        containsAudio3 = containsAudio2;
                        containsVideo3 = containsVideo2;
                        selected3 = selected2;
                        outlineColor3 = outlineColor2;
                        containerColor3 = containerColor2;
                        modifier4 = modifier3;
                        $dirty = $dirty3;
                    } else {
                        function3 = function1;
                        function4 = function2;
                        title3 = title2;
                        containsAudio3 = containsAudio2;
                        containsVideo3 = containsVideo2;
                        selected3 = selected2;
                        outlineColor3 = outlineColor2;
                        containerColor3 = containerColor2;
                        modifier4 = modifier3;
                        $dirty = $dirty3;
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    if ((i & 128) != 0) {
                        $dirty3 &= -29360129;
                    }
                    if ((i & 256) != 0) {
                        containsVideo3 = containsVideo;
                        selected3 = selected;
                        outlineColor3 = outlineColor;
                        containerColor3 = containerColor;
                        function4 = function0;
                        title3 = str;
                        containsAudio3 = z;
                        function3 = function1;
                        $dirty = (-234881025) & $dirty3;
                        modifier4 = modifier2;
                    } else {
                        containsVideo3 = containsVideo;
                        selected3 = selected;
                        outlineColor3 = outlineColor;
                        containerColor3 = containerColor;
                        function4 = function0;
                        modifier4 = modifier2;
                        title3 = str;
                        containsAudio3 = z;
                        function3 = function1;
                        $dirty = $dirty3;
                    }
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1753898537, $dirty, $dirty4, "com.videshkarmakar.loop.ui.component.FormatItem (FormatItem.kt:366)");
                }
                $composer3.startReplaceGroup(216105109);
                ComposerKt.sourceInformation($composer3, "369@13626L11");
                if (selected3) {
                    onSurface = outlineColor3;
                } else {
                    onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
                }
                $composer3.endReplaceGroup();
                State<Color> stateM103animateColorAsStateeuL9pac = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(onSurface, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
                $composer3.startReplaceGroup(216105295);
                ComposerKt.sourceInformation($composer3, "374@13814L11");
                if (selected3) {
                    surface = containerColor3;
                } else {
                    surface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface();
                }
                $composer3.endReplaceGroup();
                State<Color> stateM103animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(surface, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
                $composer3.startReplaceGroup(216105493);
                ComposerKt.sourceInformation($composer3, "379@14010L11");
                if (selected3) {
                    outlineVariant = outlineColor3;
                } else {
                    outlineVariant = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutlineVariant();
                }
                $composer3.endReplaceGroup();
                State<Color> stateM103animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(outlineVariant, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
                Modifier modifierClip = ClipKt.clip(modifier4, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getMedium());
                $composer3.startReplaceGroup(216105733);
                ComposerKt.sourceInformation($composer3, "CC(remember):FormatItem.kt#9igjgp");
                if (($dirty4 & 14) == 4) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                Object it$iv = $composer3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$5$1
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
                Modifier modifierM869selectableXHw0xAI$default = SelectableKt.m869selectableXHw0xAI$default(modifierClip, selected3, false, null, (Function0) value$iv, 6, null);
                String strStringResource = StringResources_androidKt.stringResource(R.string.copy_link, $composer3, 0);
                $composer3.startReplaceGroup(216105797);
                ComposerKt.sourceInformation($composer3, "CC(remember):FormatItem.kt#9igjgp");
                if (($dirty4 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                invalid$iv2 = z2;
                Object it$iv2 = $composer3.rememberedValue();
                if (!invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$6$1
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
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer3.endReplaceGroup();
                Modifier modifier$iv = BackgroundKt.m206backgroundbw27NRU$default(BorderKt.m217borderxT4_qwU(ClickableKt.m242combinedClickablecJG_KMw(modifierM869selectableXHw0xAI$default, (36 & 1) != 0, (36 & 2) != 0 ? null : null, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : strStringResource, (36 & 16) != 0 ? null : function4, (36 & 32) != 0 ? null : null, (Function0) value$iv2), Dp.m6553constructorimpl(1), FormatItem_uPCbpMU$lambda$20(stateM103animateColorAsStateeuL9pac3), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getMedium()), FormatItem_uPCbpMU$lambda$19(stateM103animateColorAsStateeuL9pac2), null, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
                Modifier modifier6 = modifier4;
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    localMap$iv$iv2 = localMap$iv$iv;
                    $dirty1 = $dirty4;
                } else {
                    localMap$iv$iv2 = localMap$iv$iv;
                    $dirty1 = $dirty4;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i13 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    int i14 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$FormatItem_uPCbpMU_u24lambda_u2425 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -2090958564, "C397@14578L867,420@15454L1097:FormatItem.kt#g7nzpb");
                    Modifier modifier$iv2 = PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12));
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv2 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function6 = constructor2;
                        $composer3.createNode(function6);
                    } else {
                        function6 = constructor2;
                        $composer3.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        measurePolicy$iv2 = measurePolicy$iv;
                        str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    } else {
                        measurePolicy$iv2 = measurePolicy$iv;
                        str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i15 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i16 = ((390 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                        TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                        $dirty2 = $dirty;
                        function7 = function3;
                        $composer2 = $composer3;
                        modifier5 = modifier6;
                        TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                        TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv3 = $this$FormatItem_uPCbpMU_u24lambda_u2425.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                        compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                        $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer3);
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i17 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i18 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                        $composer3.startReplaceGroup(447256646);
                        ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                        if (containsVideo3) {
                            IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.startReplaceGroup(447256946);
                        ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                        if (containsAudio3) {
                            IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                        }
                        $composer3.endReplaceGroup();
                        $composer3.startReplaceGroup(-2090956929);
                        ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                        if (!containsVideo3 && !containsAudio3) {
                            IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i19 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    int i110 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                    TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                    $dirty2 = $dirty;
                    function7 = function3;
                    $composer2 = $composer3;
                    modifier5 = modifier6;
                    TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                    TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv4 = $this$FormatItem_uPCbpMU_u24lambda_u2425.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv4 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
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
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i111 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    int i112 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                    $composer3.startReplaceGroup(447256646);
                    ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                    if (containsVideo3) {
                        IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(447256946);
                    ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                    if (containsAudio3) {
                        IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-2090956929);
                    ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                    if (!containsVideo3) {
                        IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i113 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i114 = ((0 >> 6) & 112) | 6;
                BoxScope $this$FormatItem_uPCbpMU_u24lambda_u2426 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -2090958564, "C397@14578L867,420@15454L1097:FormatItem.kt#g7nzpb");
                Modifier modifier$iv5 = PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12));
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv5 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function6 = constructor2;
                    $composer3.createNode(function6);
                } else {
                    function6 = constructor2;
                    $composer3.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    measurePolicy$iv2 = measurePolicy$iv;
                    str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                    int i115 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    int i116 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                    TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                    $dirty2 = $dirty;
                    function7 = function3;
                    $composer2 = $composer3;
                    modifier5 = modifier6;
                    TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                    TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv6 = $this$FormatItem_uPCbpMU_u24lambda_u2426.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv6 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv7 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
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
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash6);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                    int i117 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    int i118 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                    $composer3.startReplaceGroup(447256646);
                    ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                    if (containsVideo3) {
                        IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(447256946);
                    ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                    if (containsAudio3) {
                        IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-2090956929);
                    ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                    if (!containsVideo3) {
                        IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    measurePolicy$iv2 = measurePolicy$iv;
                    str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash5);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                int i119 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                int i1110 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                $dirty2 = $dirty;
                function7 = function3;
                $composer2 = $composer3;
                modifier5 = modifier6;
                TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv7 = $this$FormatItem_uPCbpMU_u24lambda_u2426.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv7 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
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
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash7);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                int i1111 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                int i1112 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                $composer3.startReplaceGroup(447256646);
                ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                if (containsVideo3) {
                    IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(447256946);
                ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                if (containsAudio3) {
                    IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2090956929);
                ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                if (!containsVideo3) {
                    IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier7 = modifier5;
                final String str3 = title3;
                final boolean z3 = containsAudio3;
                final boolean z4 = containsVideo3;
                final boolean z5 = selected3;
                final long j = outlineColor3;
                final long j2 = containerColor3;
                final Function0<Unit> function8 = function4;
                final Function0<Unit> function9 = function7;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i20) {
                        FormatItemKt.m7166FormatItemuPCbpMU(modifier7, str3, z3, z4, firstLineText, secondLineText, z5, j, j2, function8, function9, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                    }
                });
            }
        }
        i2 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        $dirty3 |= i2;
        i3 = i & 64;
        if (i3 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) != 0) {
            if ($composer3.changed(selected)) {
                i4 = 1048576;
            } else {
                i4 = 524288;
            }
            $dirty3 |= i4;
        }
        if (($changed & 29360128) != 0) {
            $dirty3 |= ((i & 128) == 0 || !$composer3.changed(outlineColor)) ? 4194304 : 8388608;
        }
        if ((234881024 & $changed) != 0) {
            $dirty3 |= ((i & 256) == 0 || !$composer3.changed(containerColor)) ? 33554432 : AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        i5 = i & 512;
        if (i5 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) != 0) {
            if ($composer3.changedInstance(function0)) {
                i6 = 536870912;
            } else {
                i6 = 268435456;
            }
            $dirty3 |= i6;
        }
        i7 = i & 1024;
        if (i7 != 0) {
            $dirty4 |= 6;
        } else if (($changed1 & 14) != 0) {
            if ($composer3.changedInstance(function1)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            $dirty4 |= i8;
        }
        if (($dirty3 & 1533916891) != 306783378) {
            $composer3.startDefaults();
            if (($changed & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    title2 = "247 - 1280x720 (720p)";
                } else {
                    title2 = str;
                }
                if (i11 != 0) {
                    containsAudio2 = false;
                } else {
                    containsAudio2 = z;
                }
                if (i12 != 0) {
                    containsVideo2 = false;
                } else {
                    containsVideo2 = containsVideo;
                }
                if (i3 != 0) {
                    selected2 = false;
                } else {
                    selected2 = selected;
                }
                if ((i & 128) != 0) {
                    outlineColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                    $dirty3 &= -29360129;
                } else {
                    outlineColor2 = outlineColor;
                }
                if ((i & 256) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer();
                    $dirty3 &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if (i5 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i7 != 0) {
                    function4 = function2;
                    function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$4
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
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                } else {
                    function3 = function1;
                    function4 = function2;
                    title3 = title2;
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    title2 = "247 - 1280x720 (720p)";
                } else {
                    title2 = str;
                }
                if (i11 != 0) {
                    containsAudio2 = false;
                } else {
                    containsAudio2 = z;
                }
                if (i12 != 0) {
                    containsVideo2 = false;
                } else {
                    containsVideo2 = containsVideo;
                }
                if (i3 != 0) {
                    selected2 = false;
                } else {
                    selected2 = selected;
                }
                if ((i & 128) != 0) {
                    outlineColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                    $dirty3 &= -29360129;
                } else {
                    outlineColor2 = outlineColor;
                }
                if ((i & 256) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer();
                    $dirty3 &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if (i5 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i7 != 0) {
                    function4 = function2;
                    function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$4
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
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                } else {
                    function3 = function1;
                    function4 = function2;
                    title3 = title2;
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1753898537, $dirty, $dirty4, "com.videshkarmakar.loop.ui.component.FormatItem (FormatItem.kt:366)");
            }
            $composer3.startReplaceGroup(216105109);
            ComposerKt.sourceInformation($composer3, "369@13626L11");
            if (selected3) {
                onSurface = outlineColor3;
            } else {
                onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
            }
            $composer3.endReplaceGroup();
            State<Color> stateM103animateColorAsStateeuL9pac4 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(onSurface, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
            $composer3.startReplaceGroup(216105295);
            ComposerKt.sourceInformation($composer3, "374@13814L11");
            if (selected3) {
                surface = containerColor3;
            } else {
                surface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface();
            }
            $composer3.endReplaceGroup();
            State<Color> stateM103animateColorAsStateeuL9pac5 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(surface, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
            $composer3.startReplaceGroup(216105493);
            ComposerKt.sourceInformation($composer3, "379@14010L11");
            if (selected3) {
                outlineVariant = outlineColor3;
            } else {
                outlineVariant = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutlineVariant();
            }
            $composer3.endReplaceGroup();
            State<Color> stateM103animateColorAsStateeuL9pac6 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(outlineVariant, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
            Modifier modifierClip2 = ClipKt.clip(modifier4, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getMedium());
            $composer3.startReplaceGroup(216105733);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatItem.kt#9igjgp");
            if (($dirty4 & 14) == 4) {
                invalid$iv = true;
            } else {
                invalid$iv = false;
            }
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$5$1
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
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$5$1
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
            }
            $composer3.endReplaceGroup();
            Modifier modifierM869selectableXHw0xAI$default2 = SelectableKt.m869selectableXHw0xAI$default(modifierClip2, selected3, false, null, (Function0) value$iv, 6, null);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.copy_link, $composer3, 0);
            $composer3.startReplaceGroup(216105797);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatItem.kt#9igjgp");
            if (($dirty4 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            invalid$iv2 = z2;
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2) {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$6$1
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
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$6$1
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
                $composer3.updateRememberedValue(value$iv2);
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv8 = BackgroundKt.m206backgroundbw27NRU$default(BorderKt.m217borderxT4_qwU(ClickableKt.m242combinedClickablecJG_KMw(modifierM869selectableXHw0xAI$default2, (36 & 1) != 0, (36 & 2) != 0 ? null : null, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : strStringResource2, (36 & 16) != 0 ? null : function4, (36 & 32) != 0 ? null : null, (Function0) value$iv2), Dp.m6553constructorimpl(1), FormatItem_uPCbpMU$lambda$20(stateM103animateColorAsStateeuL9pac6), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getMedium()), FormatItem_uPCbpMU$lambda$19(stateM103animateColorAsStateeuL9pac5), null, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv8 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv8 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer3, modifier$iv8);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
            Modifier modifier8 = modifier4;
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv2 = localMap$iv$iv;
                $dirty1 = $dirty4;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                int i1113 = ($changed$iv$iv$iv8 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i1114 = ((0 >> 6) & 112) | 6;
                BoxScope $this$FormatItem_uPCbpMU_u24lambda_u2427 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -2090958564, "C397@14578L867,420@15454L1097:FormatItem.kt#g7nzpb");
                Modifier modifier$iv9 = PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12));
                Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv9 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv9 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer3, modifier$iv9);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function6 = constructor2;
                    $composer3.createNode(function6);
                } else {
                    function6 = constructor2;
                    $composer3.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    measurePolicy$iv2 = measurePolicy$iv;
                    str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1115 = ($changed$iv$iv$iv9 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    int i1116 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                    TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac4), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                    $dirty2 = $dirty;
                    function7 = function3;
                    $composer2 = $composer3;
                    modifier5 = modifier8;
                    TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                    TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv10 = $this$FormatItem_uPCbpMU_u24lambda_u2427.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv5 = Alignment.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv9 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv10 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv10 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv10 = ComposedModifierKt.materializeModifier($composer3, modifier$iv10);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv10 = (($changed$iv$iv10 << 6) & 896) | 6;
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
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash10);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv10, ComposeUiNode.INSTANCE.getSetModifier());
                    int i1117 = ($changed$iv$iv$iv10 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    int i1118 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                    $composer3.startReplaceGroup(447256646);
                    ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                    if (containsVideo3) {
                        IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(447256946);
                    ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                    if (containsAudio3) {
                        IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-2090956929);
                    ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                    if (!containsVideo3) {
                        IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    measurePolicy$iv2 = measurePolicy$iv;
                    str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash9);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                int i1119 = ($changed$iv$iv$iv9 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                int i11110 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac4), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                $dirty2 = $dirty;
                function7 = function3;
                $composer2 = $composer3;
                modifier5 = modifier8;
                TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv11 = $this$FormatItem_uPCbpMU_u24lambda_u2427.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv6 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv6 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv10 = RowKt.rowMeasurePolicy(horizontalArrangement$iv6, verticalAlignment$iv6, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv11 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv11 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer3, modifier$iv11);
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
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash11);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
                int i11111 = ($changed$iv$iv$iv11 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                int i11112 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                $composer3.startReplaceGroup(447256646);
                ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                if (containsVideo3) {
                    IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(447256946);
                ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                if (containsAudio3) {
                    IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2090956929);
                ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                if (!containsVideo3) {
                    IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                localMap$iv$iv2 = localMap$iv$iv;
                $dirty1 = $dirty4;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash8);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
            int i11113 = ($changed$iv$iv$iv8 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i11114 = ((0 >> 6) & 112) | 6;
            BoxScope $this$FormatItem_uPCbpMU_u24lambda_u2428 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -2090958564, "C397@14578L867,420@15454L1097:FormatItem.kt#g7nzpb");
            Modifier modifier$iv12 = PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12));
            Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
            measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv12 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv12 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv12 = ComposedModifierKt.materializeModifier($composer3, modifier$iv12);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv12 = (($changed$iv$iv12 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function6 = constructor2;
                $composer3.createNode(function6);
            } else {
                function6 = constructor2;
                $composer3.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                measurePolicy$iv2 = measurePolicy$iv;
                str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv12, ComposeUiNode.INSTANCE.getSetModifier());
                int i11115 = ($changed$iv$iv$iv12 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                int i11116 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac4), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                $dirty2 = $dirty;
                function7 = function3;
                $composer2 = $composer3;
                modifier5 = modifier8;
                TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv13 = $this$FormatItem_uPCbpMU_u24lambda_u2428.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv7 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv7 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv11 = RowKt.rowMeasurePolicy(horizontalArrangement$iv7, verticalAlignment$iv7, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv13 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv13 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv13 = ComposedModifierKt.materializeModifier($composer3, modifier$iv13);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv13 = (($changed$iv$iv13 << 6) & 896) | 6;
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
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash13);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv13, ComposeUiNode.INSTANCE.getSetModifier());
                int i11117 = ($changed$iv$iv$iv13 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                int i11118 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                $composer3.startReplaceGroup(447256646);
                ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                if (containsVideo3) {
                    IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(447256946);
                ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                if (containsAudio3) {
                    IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2090956929);
                ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                if (!containsVideo3) {
                    IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                measurePolicy$iv2 = measurePolicy$iv;
                str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash12);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv12, ComposeUiNode.INSTANCE.getSetModifier());
            int i11119 = ($changed$iv$iv$iv12 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
            int i111110 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
            TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac4), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
            $dirty2 = $dirty;
            function7 = function3;
            $composer2 = $composer3;
            modifier5 = modifier8;
            TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
            TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv14 = $this$FormatItem_uPCbpMU_u24lambda_u2428.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv8 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv8 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv12 = RowKt.rowMeasurePolicy(horizontalArrangement$iv8, verticalAlignment$iv8, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv14 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv14 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv14 = ComposedModifierKt.materializeModifier($composer3, modifier$iv14);
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
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash14);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv14, ComposeUiNode.INSTANCE.getSetModifier());
            int i111111 = ($changed$iv$iv$iv14 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
            int i111112 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
            $composer3.startReplaceGroup(447256646);
            ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
            if (containsVideo3) {
                IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(447256946);
            ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
            if (containsAudio3) {
                IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2090956929);
            ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
            if (!containsVideo3) {
                IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.startDefaults();
            if (($changed & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    title2 = "247 - 1280x720 (720p)";
                } else {
                    title2 = str;
                }
                if (i11 != 0) {
                    containsAudio2 = false;
                } else {
                    containsAudio2 = z;
                }
                if (i12 != 0) {
                    containsVideo2 = false;
                } else {
                    containsVideo2 = containsVideo;
                }
                if (i3 != 0) {
                    selected2 = false;
                } else {
                    selected2 = selected;
                }
                if ((i & 128) != 0) {
                    outlineColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                    $dirty3 &= -29360129;
                } else {
                    outlineColor2 = outlineColor;
                }
                if ((i & 256) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer();
                    $dirty3 &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if (i5 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i7 != 0) {
                    function4 = function2;
                    function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$4
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
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                } else {
                    function3 = function1;
                    function4 = function2;
                    title3 = title2;
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    title2 = "247 - 1280x720 (720p)";
                } else {
                    title2 = str;
                }
                if (i11 != 0) {
                    containsAudio2 = false;
                } else {
                    containsAudio2 = z;
                }
                if (i12 != 0) {
                    containsVideo2 = false;
                } else {
                    containsVideo2 = containsVideo;
                }
                if (i3 != 0) {
                    selected2 = false;
                } else {
                    selected2 = selected;
                }
                if ((i & 128) != 0) {
                    outlineColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                    $dirty3 &= -29360129;
                } else {
                    outlineColor2 = outlineColor;
                }
                if ((i & 256) != 0) {
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer();
                    $dirty3 &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if (i5 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i7 != 0) {
                    function4 = function2;
                    function3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$4
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
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                } else {
                    function3 = function1;
                    function4 = function2;
                    title3 = title2;
                    containsAudio3 = containsAudio2;
                    containsVideo3 = containsVideo2;
                    selected3 = selected2;
                    outlineColor3 = outlineColor2;
                    containerColor3 = containerColor2;
                    modifier4 = modifier3;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1753898537, $dirty, $dirty4, "com.videshkarmakar.loop.ui.component.FormatItem (FormatItem.kt:366)");
            }
            $composer3.startReplaceGroup(216105109);
            ComposerKt.sourceInformation($composer3, "369@13626L11");
            if (selected3) {
                onSurface = outlineColor3;
            } else {
                onSurface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface();
            }
            $composer3.endReplaceGroup();
            State<Color> stateM103animateColorAsStateeuL9pac7 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(onSurface, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
            $composer3.startReplaceGroup(216105295);
            ComposerKt.sourceInformation($composer3, "374@13814L11");
            if (selected3) {
                surface = containerColor3;
            } else {
                surface = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface();
            }
            $composer3.endReplaceGroup();
            State<Color> stateM103animateColorAsStateeuL9pac8 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(surface, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
            $composer3.startReplaceGroup(216105493);
            ComposerKt.sourceInformation($composer3, "379@14010L11");
            if (selected3) {
                outlineVariant = outlineColor3;
            } else {
                outlineVariant = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutlineVariant();
            }
            $composer3.endReplaceGroup();
            State<Color> stateM103animateColorAsStateeuL9pac9 = SingleValueAnimationKt.m103animateColorAsStateeuL9pac(outlineVariant, AnimationSpecKt.tween$default(100, 0, null, 6, null), "", null, $composer3, 432, 8);
            Modifier modifierClip3 = ClipKt.clip(modifier4, MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getMedium());
            $composer3.startReplaceGroup(216105733);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatItem.kt#9igjgp");
            if (($dirty4 & 14) == 4) {
                invalid$iv = true;
            } else {
                invalid$iv = false;
            }
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$5$1
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
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$5$1
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
            }
            $composer3.endReplaceGroup();
            Modifier modifierM869selectableXHw0xAI$default3 = SelectableKt.m869selectableXHw0xAI$default(modifierClip3, selected3, false, null, (Function0) value$iv, 6, null);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.copy_link, $composer3, 0);
            $composer3.startReplaceGroup(216105797);
            ComposerKt.sourceInformation($composer3, "CC(remember):FormatItem.kt#9igjgp");
            if (($dirty4 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            invalid$iv2 = z2;
            Object it$iv6 = $composer3.rememberedValue();
            if (invalid$iv2) {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$6$1
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
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$6$1
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
                $composer3.updateRememberedValue(value$iv2);
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv15 = BackgroundKt.m206backgroundbw27NRU$default(BorderKt.m217borderxT4_qwU(ClickableKt.m242combinedClickablecJG_KMw(modifierM869selectableXHw0xAI$default3, (36 & 1) != 0, (36 & 2) != 0 ? null : null, (36 & 4) != 0 ? null : null, (36 & 8) != 0 ? null : strStringResource3, (36 & 16) != 0 ? null : function4, (36 & 32) != 0 ? null : null, (Function0) value$iv2), Dp.m6553constructorimpl(1), FormatItem_uPCbpMU$lambda$20(stateM103animateColorAsStateeuL9pac9), MaterialTheme.INSTANCE.getShapes($composer3, MaterialTheme.$stable).getMedium()), FormatItem_uPCbpMU$lambda$19(stateM103animateColorAsStateeuL9pac8), null, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv13 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv15 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv15 = ComposedModifierKt.materializeModifier($composer3, modifier$iv15);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv15 = (($changed$iv$iv15 << 6) & 896) | 6;
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
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer3);
            Modifier modifier9 = modifier4;
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                localMap$iv$iv2 = localMap$iv$iv;
                $dirty1 = $dirty4;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv15, ComposeUiNode.INSTANCE.getSetModifier());
                int i111113 = ($changed$iv$iv$iv15 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i111114 = ((0 >> 6) & 112) | 6;
                BoxScope $this$FormatItem_uPCbpMU_u24lambda_u2429 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -2090958564, "C397@14578L867,420@15454L1097:FormatItem.kt#g7nzpb");
                Modifier modifier$iv16 = PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12));
                Alignment.Horizontal horizontalAlignment$iv5 = Alignment.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv5 = Arrangement.INSTANCE.getTop();
                measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv5, horizontalAlignment$iv5, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv16 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv15 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv16 = ComposedModifierKt.materializeModifier($composer3, modifier$iv16);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv16 = (($changed$iv$iv16 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function6 = constructor2;
                    $composer3.createNode(function6);
                } else {
                    function6 = constructor2;
                    $composer3.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash16 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    measurePolicy$iv2 = measurePolicy$iv;
                    str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv16, ComposeUiNode.INSTANCE.getSetModifier());
                    int i111115 = ($changed$iv$iv$iv16 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                    int i111116 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                    TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac7), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                    $dirty2 = $dirty;
                    function7 = function3;
                    $composer2 = $composer3;
                    modifier5 = modifier9;
                    TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                    TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv17 = $this$FormatItem_uPCbpMU_u24lambda_u2429.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv9 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv9 = Alignment.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv14 = RowKt.rowMeasurePolicy(horizontalArrangement$iv9, verticalAlignment$iv9, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv17 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv16 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv17 = ComposedModifierKt.materializeModifier($composer3, modifier$iv17);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv17 = (($changed$iv$iv17 << 6) & 896) | 6;
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
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash17 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash17);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv17, ComposeUiNode.INSTANCE.getSetModifier());
                    int i111117 = ($changed$iv$iv$iv17 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                    int i111118 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                    $composer3.startReplaceGroup(447256646);
                    ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                    if (containsVideo3) {
                        IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(447256946);
                    ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                    if (containsAudio3) {
                        IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-2090956929);
                    ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                    if (!containsVideo3) {
                        IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    measurePolicy$iv2 = measurePolicy$iv;
                    str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash16);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv16, ComposeUiNode.INSTANCE.getSetModifier());
                int i111119 = ($changed$iv$iv$iv16 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                int i1111110 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac7), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                $dirty2 = $dirty;
                function7 = function3;
                $composer2 = $composer3;
                modifier5 = modifier9;
                TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv18 = $this$FormatItem_uPCbpMU_u24lambda_u2429.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv10 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv10 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv15 = RowKt.rowMeasurePolicy(horizontalArrangement$iv10, verticalAlignment$iv10, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv18 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv17 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv18 = ComposedModifierKt.materializeModifier($composer3, modifier$iv18);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv18 = (($changed$iv$iv18 << 6) & 896) | 6;
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
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash18 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash18);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv18, ComposeUiNode.INSTANCE.getSetModifier());
                int i1111111 = ($changed$iv$iv$iv18 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance10 = RowScopeInstance.INSTANCE;
                int i1111112 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                $composer3.startReplaceGroup(447256646);
                ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                if (containsVideo3) {
                    IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(447256946);
                ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                if (containsAudio3) {
                    IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2090956929);
                ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                if (!containsVideo3) {
                    IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                localMap$iv$iv2 = localMap$iv$iv;
                $dirty1 = $dirty4;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash15);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv15, ComposeUiNode.INSTANCE.getSetModifier());
            int i1111113 = ($changed$iv$iv$iv15 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int i1111114 = ((0 >> 6) & 112) | 6;
            BoxScope $this$FormatItem_uPCbpMU_u24lambda_u24210 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -2090958564, "C397@14578L867,420@15454L1097:FormatItem.kt#g7nzpb");
            Modifier modifier$iv19 = PaddingKt.m620padding3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(12));
            Alignment.Horizontal horizontalAlignment$iv6 = Alignment.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv6 = Arrangement.INSTANCE.getTop();
            measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv6, horizontalAlignment$iv6, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv19 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv18 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv19 = ComposedModifierKt.materializeModifier($composer3, modifier$iv19);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv19 = (($changed$iv$iv19 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function6 = constructor2;
                $composer3.createNode(function6);
            } else {
                function6 = constructor2;
                $composer3.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer3);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash19 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                measurePolicy$iv2 = measurePolicy$iv;
                str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv19, ComposeUiNode.INSTANCE.getSetModifier());
                int i1111115 = ($changed$iv$iv$iv19 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                int i1111116 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
                TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac7), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
                $dirty2 = $dirty;
                function7 = function3;
                $composer2 = $composer3;
                modifier5 = modifier9;
                TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
                TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv110 = $this$FormatItem_uPCbpMU_u24lambda_u24210.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv11 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv11 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv16 = RowKt.rowMeasurePolicy(horizontalArrangement$iv11, verticalAlignment$iv11, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv110 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv19 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv110 = ComposedModifierKt.materializeModifier($composer3, modifier$iv110);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv110 = (($changed$iv$iv110 << 6) & 896) | 6;
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
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash110 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash110);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv110, ComposeUiNode.INSTANCE.getSetModifier());
                int i1111117 = ($changed$iv$iv$iv110 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance11 = RowScopeInstance.INSTANCE;
                int i1111118 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
                $composer3.startReplaceGroup(447256646);
                ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
                if (containsVideo3) {
                    IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(447256946);
                ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
                if (containsAudio3) {
                    IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-2090956929);
                ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
                if (!containsVideo3) {
                    IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                measurePolicy$iv2 = measurePolicy$iv;
                str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash19);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv19, ComposeUiNode.INSTANCE.getSetModifier());
            int i1111119 = ($changed$iv$iv$iv19 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
            int i11111110 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 447255698, "C400@14737L10,398@14663L243,408@15002L10,410@15121L11,406@14920L250,415@15267L10,417@15386L11,413@15184L251:FormatItem.kt#g7nzpb");
            TextKt.m2569Text4IGK_g(title3, (Modifier) null, FormatItem_uPCbpMU$lambda$18(stateM103animateColorAsStateeuL9pac7), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6459getClipgIe3tQ8(), false, 2, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer3, ($dirty >> 3) & 14, 27696, 38906);
            $dirty2 = $dirty;
            function7 = function3;
            $composer2 = $composer3;
            modifier5 = modifier9;
            TextKt.m2569Text4IGK_g(firstLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(6), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty >> 12) & 14) | 48, 3072, 57336);
            TextKt.m2569Text4IGK_g(secondLineText, PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6553constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer3, (($dirty2 >> 15) & 14) | 48, 3072, 57336);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv111 = $this$FormatItem_uPCbpMU_u24lambda_u24210.align(PaddingKt.m624paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6553constructorimpl(6), Dp.m6553constructorimpl(6), 3, null), Alignment.INSTANCE.getBottomEnd());
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv12 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv12 = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv17 = RowKt.rowMeasurePolicy(horizontalArrangement$iv12, verticalAlignment$iv12, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv111 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str2);
            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv110 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv111 = ComposedModifierKt.materializeModifier($composer3, modifier$iv111);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv111 = (($changed$iv$iv111 << 6) & 896) | 6;
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
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash111 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
            }
            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash111);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv111, ComposeUiNode.INSTANCE.getSetModifier());
            int i11111111 = ($changed$iv$iv$iv111 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance12 = RowScopeInstance.INSTANCE;
            int i11111112 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 447256646, "C:FormatItem.kt#g7nzpb");
            $composer3.startReplaceGroup(447256646);
            ComposerKt.sourceInformation($composer3, "429@15792L35,426@15646L252");
            if (containsVideo3) {
                IconKt.m2044Iconww6aTOc(VideocamKt.getVideocam(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.video, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(447256946);
            ComposerKt.sourceInformation($composer3, "436@16094L35,433@15946L254");
            if (containsAudio3) {
                IconKt.m2044Iconww6aTOc(AudiotrackKt.getAudiotrack(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.audio, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-2090956929);
            ComposerKt.sourceInformation($composer3, "443@16419L37,440@16269L258");
            if (!containsVideo3) {
                IconKt.m2044Iconww6aTOc(QuestionMarkKt.getQuestionMark(Icons.Rounded.INSTANCE), StringResources_androidKt.stringResource(R.string.unknown, $composer3, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(16)), outlineColor3, $composer3, (($dirty2 >> 12) & 7168) | 384, 0);
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
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier10 = modifier5;
            final String str4 = title3;
            final boolean z6 = containsAudio3;
            final boolean z7 = containsVideo3;
            final boolean z8 = selected3;
            final long j3 = outlineColor3;
            final long j4 = containerColor3;
            final Function0<Unit> function10 = function4;
            final Function0<Unit> function11 = function7;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatItem$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i20) {
                    FormatItemKt.m7166FormatItemuPCbpMU(modifier10, str4, z6, z7, firstLineText, secondLineText, z8, j3, j4, function10, function11, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    private static final long FormatItem_uPCbpMU$lambda$18(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4053unboximpl();
    }

    private static final long FormatItem_uPCbpMU$lambda$19(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4053unboximpl();
    }

    private static final long FormatItem_uPCbpMU$lambda$20(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4053unboximpl();
    }

    public static final void PreviewFormat(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(953722768);
        ComposerKt.sourceInformation($composer2, "C(PreviewFormat)458@16766L21,458@16734L643:FormatItem.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(953722768, $changed, -1, "com.videshkarmakar.loop.ui.component.PreviewFormat (FormatItem.kt:457)");
            }
            MaterialThemeKt.MaterialTheme(DarkThemeKt.isSystemInDarkTheme($composer2, 0) ? ColorSchemeKt.m1836darkColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null) : ColorSchemeKt.m1840lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null), null, null, ComposableSingletons$FormatItemKt.INSTANCE.m7128getLambda12$app_debug(), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.PreviewFormat.1
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
                    FormatItemKt.PreviewFormat(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static /* synthetic */ void FormatPreviewContent$default(LazyGridScope lazyGridScope, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int it) {
                }
            };
        }
        FormatPreviewContent(lazyGridScope, i, function1);
    }

    public static final void FormatPreviewContent(LazyGridScope $this$FormatPreviewContent, final int selected, final Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter($this$FormatPreviewContent, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        LazyGridScope.CC.item$default($this$FormatPreviewContent, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return GridItemSpan.m734boximpl(m7169invokeBHJflc(lazyGridItemSpanScope));
            }

            /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
            public final long m7169invokeBHJflc(LazyGridItemSpanScope item) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
            }
        }, null, ComposableSingletons$FormatItemKt.INSTANCE.m7129getLambda13$app_debug(), 5, null);
        LazyGridScope.CC.item$default($this$FormatPreviewContent, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return GridItemSpan.m734boximpl(m7170invokeBHJflc(lazyGridItemSpanScope));
            }

            /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
            public final long m7170invokeBHJflc(LazyGridItemSpanScope item) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-1942930244, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                invoke(lazyGridItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation($composer, "C490@18009L14,484@17766L257:FormatItem.kt#g7nzpb");
                if (($changed & 81) == 16 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1942930244, $changed, -1, "com.videshkarmakar.loop.ui.component.FormatPreviewContent.<anonymous> (FormatItem.kt:484)");
                }
                boolean z = selected == 1;
                $composer.startReplaceGroup(1015518149);
                ComposerKt.sourceInformation($composer, "CC(remember):FormatItem.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onClick);
                final Function1<Integer, Unit> function1 = onClick;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatPreviewContent$4$1$1
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
                            function1.invoke(1);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                FormatItemKt.m7166FormatItemuPCbpMU(null, null, true, true, "? MB + 16.00 MB, (? + 200) Kbps", "MKV (Unknown + OPUS)", z, 0L, 0L, null, (Function0) value$iv, $composer, 224640, 0, 899);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 5, null);
        LazyGridScope.CC.item$default($this$FormatPreviewContent, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return GridItemSpan.m734boximpl(m7171invokeBHJflc(lazyGridItemSpanScope));
            }

            /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
            public final long m7171invokeBHJflc(LazyGridItemSpanScope item) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
            }
        }, null, ComposableSingletons$FormatItemKt.INSTANCE.m7130getLambda14$app_debug(), 5, null);
        for (final int i = 0; i < 2; i++) {
            LazyGridScope.CC.item$default($this$FormatPreviewContent, null, null, null, ComposableLambdaKt.composableLambdaInstance(110746599, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                    invoke(lazyGridItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
                    Object value$iv;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation($composer, "C506@18505L11,507@18574L11,512@18779L14,504@18406L387:FormatItem.kt#g7nzpb");
                    if (($changed & 81) == 16 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(110746599, $changed, -1, "com.videshkarmakar.loop.ui.component.FormatPreviewContent.<anonymous> (FormatItem.kt:504)");
                    }
                    boolean z = selected == i;
                    long tertiary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getTertiary();
                    long tertiaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getTertiaryContainer();
                    $composer.startReplaceGroup(1015518919);
                    ComposerKt.sourceInformation($composer, "CC(remember):FormatItem.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(onClick) | $composer.changed(i);
                    final Function1<Integer, Unit> function1 = onClick;
                    final int i2 = i;
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatPreviewContent$6$1$1
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
                                function1.invoke(Integer.valueOf(i2));
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    FormatItemKt.m7166FormatItemuPCbpMU(null, null, true, false, "", "OPUS (OPUS)", z, tertiary, tertiaryContainer, null, (Function0) value$iv, $composer, 224640, 0, 515);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 7, null);
        }
        LazyGridScope.CC.item$default($this$FormatPreviewContent, null, null, null, ComposableLambdaKt.composableLambdaInstance(1069864766, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                invoke(lazyGridItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(item, "$this$item");
                ComposerKt.sourceInformation($composer, "C518@18920L11,519@18985L11,524@19176L14,516@18829L361:FormatItem.kt#g7nzpb");
                if (($changed & 81) == 16 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1069864766, $changed, -1, "com.videshkarmakar.loop.ui.component.FormatPreviewContent.<anonymous> (FormatItem.kt:516)");
                }
                boolean z = selected == 2;
                long tertiary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getTertiary();
                long tertiaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getTertiaryContainer();
                $composer.startReplaceGroup(1015519316);
                ComposerKt.sourceInformation($composer, "CC(remember):FormatItem.kt#9igjgp");
                boolean invalid$iv = $composer.changed(onClick);
                final Function1<Integer, Unit> function1 = onClick;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatPreviewContent$7$1$1
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
                            function1.invoke(2);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                FormatItemKt.m7166FormatItemuPCbpMU(null, null, true, false, "", "Unknown (Unknown)", z, tertiary, tertiaryContainer, null, (Function0) value$iv, $composer, 224640, 0, 515);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 7, null);
        LazyGridScope.CC.item$default($this$FormatPreviewContent, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.8
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return GridItemSpan.m734boximpl(m7172invokeBHJflc(lazyGridItemSpanScope));
            }

            /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
            public final long m7172invokeBHJflc(LazyGridItemSpanScope item) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
            }
        }, null, ComposableSingletons$FormatItemKt.INSTANCE.m7131getLambda15$app_debug(), 5, null);
        for (final int i2 = 0; i2 < 3; i2++) {
            LazyGridScope.CC.item$default($this$FormatPreviewContent, null, null, null, ComposableLambdaKt.composableLambdaInstance(712414366, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                    invoke(lazyGridItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
                    Object value$iv;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation($composer, "C541@19753L14,535@19509L258:FormatItem.kt#g7nzpb");
                    if (($changed & 81) == 16 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(712414366, $changed, -1, "com.videshkarmakar.loop.ui.component.FormatPreviewContent.<anonymous> (FormatItem.kt:535)");
                    }
                    boolean z = selected == i2;
                    $composer.startReplaceGroup(1015519893);
                    ComposerKt.sourceInformation($composer, "CC(remember):FormatItem.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(onClick) | $composer.changed(i2);
                    final Function1<Integer, Unit> function1 = onClick;
                    final int i3 = i2;
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatPreviewContent$9$1$1
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
                                function1.invoke(Integer.valueOf(i3));
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    FormatItemKt.m7166FormatItemuPCbpMU(null, null, false, true, "69.00MB 745.7Kbps", "MP4 (AVC1)", z, 0L, 0L, null, (Function0) value$iv, $composer, 224640, 0, 899);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 7, null);
        }
        LazyGridScope.CC.item$default($this$FormatPreviewContent, null, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.10
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return GridItemSpan.m734boximpl(m7168invokeBHJflc(lazyGridItemSpanScope));
            }

            /* JADX INFO: renamed from: invoke-BHJ-flc, reason: not valid java name */
            public final long m7168invokeBHJflc(LazyGridItemSpanScope item) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                return LazyGridSpanKt.GridItemSpan(item.getMaxLineSpan());
            }
        }, null, ComposableSingletons$FormatItemKt.INSTANCE.m7132getLambda16$app_debug(), 5, null);
        for (final int i3 = 0; i3 < 4; i3++) {
            LazyGridScope.CC.item$default($this$FormatPreviewContent, null, null, null, ComposableLambdaKt.composableLambdaInstance(71328223, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatPreviewContent.11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                    invoke(lazyGridItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyGridItemScope item, Composer $composer, int $changed) {
                    Object value$iv;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation($composer, "C556@20247L11,557@20317L11,562@20511L14,554@20148L377:FormatItem.kt#g7nzpb");
                    if (($changed & 81) == 16 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(71328223, $changed, -1, "com.videshkarmakar.loop.ui.component.FormatPreviewContent.<anonymous> (FormatItem.kt:554)");
                    }
                    boolean z = selected == i3;
                    long secondary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSecondary();
                    long secondaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSecondaryContainer();
                    $composer.startReplaceGroup(1015520651);
                    ComposerKt.sourceInformation($composer, "CC(remember):FormatItem.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(onClick) | $composer.changed(i3);
                    final Function1<Integer, Unit> function1 = onClick;
                    final int i4 = i3;
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatPreviewContent$11$1$1
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
                                function1.invoke(Integer.valueOf(i4));
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    FormatItemKt.m7166FormatItemuPCbpMU(null, null, true, true, "", "", z, secondary, secondaryContainer, null, (Function0) value$iv, $composer, 224640, 0, 515);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 7, null);
        }
    }

    /* JADX INFO: renamed from: FormatSubtitle-FNF3uiM, reason: not valid java name */
    public static final void m7167FormatSubtitleFNF3uiM(Modifier modifier, final String text, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        int $dirty;
        Modifier modifier3;
        long color2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-660976587);
        ComposerKt.sourceInformation($composer3, "C(FormatSubtitle)P(1,2,0:c#ui.graphics.Color)571@20663L11,577@20801L10,573@20692L136:FormatItem.kt#g7nzpb");
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
                j = color;
                int i3 = $composer3.changed(j) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                j = color;
            }
            $dirty2 |= i3;
        } else {
            j = color;
        }
        if (($dirty2 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            color2 = j;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    modifier3 = modifier4;
                    color2 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    color2 = j;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                color2 = j;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-660976587, $dirty, -1, "com.videshkarmakar.loop.ui.component.FormatSubtitle (FormatItem.kt:572)");
            }
            $composer2 = $composer3;
            TextKt.m2569Text4IGK_g(text, modifier3, color2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleSmall(), $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & 112) | ($dirty & 896), 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j2 = color2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt$FormatSubtitle$1
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
                    FormatItemKt.m7167FormatSubtitleFNF3uiM(modifier5, text, j2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void FormatItemPreview(Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(658562479);
        ComposerKt.sourceInformation($composer3, "C(FormatItemPreview)584@20883L50:FormatItem.kt#g7nzpb");
        if ($changed != 0 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(658562479, $changed, -1, "com.videshkarmakar.loop.ui.component.FormatItemPreview (FormatItem.kt:583)");
            }
            $composer2 = $composer3;
            m7165FormatItembogVsAg(null, new Format((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, LayoutUtilsKt.BigConstraintValue, (DefaultConstructorMarker) null), 20.0d, false, 0L, 0L, null, null, $composer3, 384, 249);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.FormatItemKt.FormatItemPreview.1
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
                    FormatItemKt.FormatItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final String toEmpty(String $this$toEmpty) {
        return ($this$toEmpty == null || $this$toEmpty.equals("none")) ? "" : $this$toEmpty;
    }
}
