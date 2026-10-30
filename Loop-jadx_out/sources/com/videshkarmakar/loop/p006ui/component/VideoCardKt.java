package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorDefaults;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.common.AsyncImageImplKt;
import com.videshkarmakar.loop.p006ui.theme.ThemeKt;
import com.videshkarmakar.loop.util.TextUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: VideoCard.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u000fX\u008a\u0084\u0002"}, m195d2 = {"VideoCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "author", "thumbnailUrl", "", "showCancelButton", "", "onCancel", "Lkotlin/Function0;", "onClick", NotificationCompat.CATEGORY_PROGRESS, "", "fileSizeApprox", "", "duration", "", "isPreview", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FDIZLandroidx/compose/runtime/Composer;III)V", "VideoCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "progressAnimationValue"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VideoCardKt {
    public static final void VideoCard(Modifier modifier, String title, String author, Object thumbnailUrl, boolean showCancelButton, Function0<Unit> function0, Function0<Unit> function1, float progress, double fileSizeApprox, int duration, boolean isPreview, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        String title2;
        String author2;
        Object thumbnailUrl2;
        boolean showCancelButton2;
        C33041 c33041;
        C33052 c33052;
        float progress2;
        double fileSizeApprox2;
        boolean isPreview2;
        int $dirty;
        int $dirty2;
        Modifier modifier2;
        Modifier modifier3;
        String author3;
        boolean isPreview3;
        float progress3;
        Object thumbnailUrl3;
        Function0<Unit> function2;
        int duration2;
        double fileSizeApprox3;
        String title3;
        boolean showCancelButton3;
        Function0<Unit> function3;
        Composer $composer2 = $composer.startRestartGroup(-1687089336);
        ComposerKt.sourceInformation($composer2, "C(VideoCard)P(4,10!1,9,8,5,6,7,2)47@2058L48,48@2129L50,61@2569L6,62@2588L4036,58@2449L4175:VideoCard.kt#g7nzpb");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty3 |= ((i & 2) == 0 && $composer2.changed(title)) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty3 |= ((i & 4) == 0 && $composer2.changed(author)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty3 |= 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
            z = showCancelButton;
        } else if ((57344 & $changed) == 0) {
            z = showCancelButton;
            $dirty3 |= $composer2.changed(z) ? 16384 : 8192;
        } else {
            z = showCancelButton;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer2.changed(progress) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer2.changed(fileSizeApprox) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer2.changed(duration) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer2.changed(isPreview) ? 4 : 2;
        }
        if (i3 == 8 && (1533916891 & $dirty3) == 306783378 && ($dirty1 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            title3 = title;
            author3 = author;
            thumbnailUrl3 = thumbnailUrl;
            function3 = function0;
            function2 = function1;
            progress3 = progress;
            fileSizeApprox3 = fileSizeApprox;
            duration2 = duration;
            isPreview3 = isPreview;
            showCancelButton3 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    title2 = StringResources_androidKt.stringResource(C3070R.string.video_title_sample_text, $composer2, 0);
                    $dirty3 &= -113;
                } else {
                    title2 = title;
                }
                if ((i & 4) != 0) {
                    author2 = StringResources_androidKt.stringResource(C3070R.string.video_creator_sample_text, $composer2, 0);
                    $dirty3 &= -897;
                } else {
                    author2 = author;
                }
                thumbnailUrl2 = i3 != 0 ? "" : thumbnailUrl;
                showCancelButton2 = i4 != 0 ? false : z;
                c33041 = i5 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt.VideoCard.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function0;
                c33052 = i6 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt.VideoCard.2
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                } : function1;
                progress2 = i7 != 0 ? 90.0f : progress;
                fileSizeApprox2 = i8 != 0 ? 7.2351744E7d : fileSizeApprox;
                int duration3 = i9 != 0 ? 359 : duration;
                if (i10 != 0) {
                    isPreview2 = false;
                    $dirty = $dirty3;
                    $dirty2 = duration3;
                    modifier2 = modifier4;
                } else {
                    isPreview2 = isPreview;
                    $dirty = $dirty3;
                    $dirty2 = duration3;
                    modifier2 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty3 &= -113;
                }
                if ((i & 4) != 0) {
                    int i11 = $dirty3 & (-897);
                    title2 = title;
                    author2 = author;
                    thumbnailUrl2 = thumbnailUrl;
                    c33041 = function0;
                    progress2 = progress;
                    fileSizeApprox2 = fileSizeApprox;
                    $dirty2 = duration;
                    isPreview2 = isPreview;
                    $dirty = i11;
                    showCancelButton2 = z;
                    modifier2 = modifier;
                    c33052 = function1;
                } else {
                    modifier2 = modifier;
                    title2 = title;
                    author2 = author;
                    thumbnailUrl2 = thumbnailUrl;
                    c33041 = function0;
                    progress2 = progress;
                    fileSizeApprox2 = fileSizeApprox;
                    isPreview2 = isPreview;
                    $dirty = $dirty3;
                    showCancelButton2 = z;
                    c33052 = function1;
                    $dirty2 = duration;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1687089336, $dirty, $dirty1, "com.videshkarmakar.loop.ui.component.VideoCard (VideoCard.kt:57)");
            }
            modifier3 = modifier2;
            int duration4 = $dirty2;
            author3 = author2;
            CardKt.ElevatedCard(c33052, SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), false, MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getSmall(), null, null, null, ComposableLambdaKt.rememberComposableLambda(1232037382, true, new C33063(progress2, thumbnailUrl2, isPreview2, fileSizeApprox2, $dirty2, showCancelButton2, c33041, title2, author2), $composer2, 54), $composer2, (($dirty >> 18) & 14) | 12582912, 116);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isPreview3 = isPreview2;
            progress3 = progress2;
            thumbnailUrl3 = thumbnailUrl2;
            function2 = c33052;
            duration2 = duration4;
            fileSizeApprox3 = fileSizeApprox2;
            title3 = title2;
            showCancelButton3 = showCancelButton2;
            function3 = c33041;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str = title3;
            final String str2 = author3;
            final Object obj = thumbnailUrl3;
            final boolean z2 = showCancelButton3;
            final Function0<Unit> function4 = function3;
            final Function0<Unit> function5 = function2;
            final float f = progress3;
            final double d = fileSizeApprox3;
            final int i12 = duration2;
            final boolean z3 = isPreview3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt.VideoCard.4
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
                    VideoCardKt.VideoCard(modifier5, str, str2, obj, z2, function4, function5, f, d, i12, z3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3 */
    /* JADX INFO: compiled from: VideoCard.kt */
    @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/ColumnScope;", "invoke", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C33063 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ String $author;
        final /* synthetic */ int $duration;
        final /* synthetic */ double $fileSizeApprox;
        final /* synthetic */ boolean $isPreview;
        final /* synthetic */ Function0<Unit> $onCancel;
        final /* synthetic */ float $progress;
        final /* synthetic */ boolean $showCancelButton;
        final /* synthetic */ Object $thumbnailUrl;
        final /* synthetic */ String $title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C33063(float f, Object obj, boolean z, double d, int i, boolean z2, Function0<Unit> function0, String str, String str2) {
            super(3);
            this.$progress = f;
            this.$thumbnailUrl = obj;
            this.$isPreview = z;
            this.$fileSizeApprox = d;
            this.$duration = i;
            this.$showCancelButton = z2;
            this.$onCancel = function0;
            this.$title = str;
            this.$author = str2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:28:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:31:0x01d6  */
        /* JADX WARN: Code duplicated, block: B:32:0x01dc  */
        /* JADX WARN: Code duplicated, block: B:35:0x020f  */
        /* JADX WARN: Code duplicated, block: B:38:0x0222  */
        /* JADX WARN: Code duplicated, block: B:39:0x0225  */
        /* JADX WARN: Code duplicated, block: B:43:0x03ab  */
        /* JADX WARN: Code duplicated, block: B:46:0x03b7  */
        /* JADX WARN: Code duplicated, block: B:47:0x03bd  */
        /* JADX WARN: Code duplicated, block: B:50:0x03f0  */
        /* JADX WARN: Code duplicated, block: B:54:0x0406 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:58:0x0535  */
        /* JADX WARN: Code duplicated, block: B:61:0x0541  */
        /* JADX WARN: Code duplicated, block: B:62:0x0545  */
        /* JADX WARN: Code duplicated, block: B:65:0x0573  */
        /* JADX WARN: Code duplicated, block: B:69:0x0589 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:73:0x06ad  */
        /* JADX WARN: Code duplicated, block: B:74:0x06d7  */
        /* JADX WARN: Code duplicated, block: B:76:0x06fb  */
        /* JADX WARN: Code duplicated, block: B:80:0x0706  */
        /* JADX WARN: Code duplicated, block: B:84:0x075c  */
        /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
        public final void invoke(ColumnScope ElevatedCard, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            MeasurePolicy measurePolicy$iv;
            String str;
            int compositeKeyHash$iv$iv;
            Function0<ComposeUiNode> constructor;
            Function0<ComposeUiNode> function1;
            Composer $this$Layout_u24lambda_u240$iv$iv;
            boolean propagateMinConstraints$iv;
            int compositeKeyHash$iv$iv2;
            Function0<ComposeUiNode> constructor2;
            Function0<ComposeUiNode> function2;
            Composer $this$Layout_u24lambda_u240$iv$iv2;
            int compositeKeyHash$iv$iv3;
            Function0<ComposeUiNode> constructor3;
            Composer $this$Layout_u24lambda_u240$iv$iv3;
            final State<Float> stateAnimateFloatAsState;
            boolean invalid$iv;
            Object value$iv;
            Intrinsics.checkNotNullParameter(ElevatedCard, "$this$ElevatedCard");
            ComposerKt.sourceInformation($composer, "C63@2598L4020:VideoCard.kt#g7nzpb");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1232037382, $changed, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous> (VideoCard.kt:63)");
                }
                float f = this.$progress;
                Object obj = this.$thumbnailUrl;
                final boolean z = this.$isPreview;
                final double d = this.$fileSizeApprox;
                final int i = this.$duration;
                boolean z2 = this.$showCancelButton;
                final Function0<Unit> function3 = this.$onCancel;
                String str2 = this.$title;
                String str3 = this.$author;
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.INSTANCE;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function0 = constructor4;
                    $composer.createNode(function0);
                } else {
                    function0 = constructor4;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3795constructorimpl($composer);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                    measurePolicy$iv = measurePolicy$iv2;
                    str = str2;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i3 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -1866079777, "C64@2619L2590,125@5223L787,146@6053L166:VideoCard.kt#g7nzpb");
                    Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv2 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        function1 = constructor;
                        $composer.createNode(function1);
                    } else {
                        function1 = constructor;
                        $composer.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        propagateMinConstraints$iv = false;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        int i5 = ((6 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u245_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer, 547524143, "C65@2716L545,65@2666L595,84@3523L6,85@3559L452,79@3279L732,96@4029L1166:VideoCard.kt#g7nzpb");
                        String str4 = str;
                        CrossfadeKt.Crossfade(obj, (Modifier) null, (FiniteAnimationSpec<Float>) null, "", ComposableLambdaKt.rememberComposableLambda(949400581, true, new Function3<Object, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Object p1, Composer composer, Integer num) {
                                invoke(p1, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Object it, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer2, "C71@3016L6,66@2738L505:VideoCard.kt#g7nzpb");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(949400581, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:66)");
                                }
                                AsyncImageImplKt.m7233AsyncImageImpl10Xjiaw(it, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z, $composer2, 1572920, 0, 952);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer, 54), $composer, 27656, 6);
                        Modifier modifierAlign = $this$invoke_u24lambda_u245_u24lambda_u241.align(PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                        long jM4317getBlack0d7_KjU = Color.INSTANCE.m4317getBlack0d7_KjU();
                        SurfaceKt.m2666SurfaceT9BRK9s(modifierAlign, MaterialTheme.INSTANCE.getShapes($composer, MaterialTheme.$stable).getExtraSmall(), Color.m4289copywmQWz5c(jM4317getBlack0d7_KjU, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4317getBlack0d7_KjU) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4317getBlack0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4317getBlack0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4317getBlack0d7_KjU) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1062377885, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer2, int $changed2) {
                                ComposerKt.sourceInformation($composer2, "C86@3615L16,91@3905L10,88@3717L276:VideoCard.kt#g7nzpb");
                                if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1062377885, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:86)");
                                    }
                                    String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d), $composer2, 0);
                                    String durationText = TextUtilKt.toDurationText(i);
                                    TextKt.m2817Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4328getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, 432, 0, 65528);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer2.skipToGroupEnd();
                            }
                        }, $composer, 54), $composer, 12583296, 120);
                        Modifier modifier$iv3 = $this$invoke_u24lambda_u245_u24lambda_u241.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function2 = constructor2;
                            $composer.createNode(function2);
                        } else {
                            function2 = constructor2;
                            $composer.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScope $this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer, -1916725613, "C103@4318L859,99@4141L1036:VideoCard.kt#g7nzpb");
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u240, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-368433456, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                                invoke(animatedVisibilityScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer2, int $changed2) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation($composer2, "C109@4657L11,108@4565L247,104@4344L810:VideoCard.kt#g7nzpb");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-368433456, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:104)");
                                }
                                Function0<Unit> function4 = function3;
                                Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(56));
                                IconButtonDefaults iconButtonDefaults = IconButtonDefaults.INSTANCE;
                                long surfaceContainerHighest = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerHighest();
                                IconButtonKt.FilledTonalIconButton(function4, modifierM913size3ABfNKs, false, null, iconButtonDefaults.m2284filledTonalIconButtonColorsro_MJ88(Color.m4289copywmQWz5c(surfaceContainerHighest, (14 & 1) != 0 ? Color.m4293getAlphaimpl(surfaceContainerHighest) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(surfaceContainerHighest) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(surfaceContainerHighest) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(surfaceContainerHighest) : 0.0f), 0L, 0L, 0L, $composer2, IconButtonDefaults.$stable << 12, 14), null, ComposableSingletons$VideoCardKt.INSTANCE.m7292getLambda1$app_debug(), $composer2, 1572912, 44);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer, 54), $composer, ((((0 >> 6) & 112) | 6) & 14) | 1600512, 18);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Modifier modifier$iv4 = PaddingKt.m868padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(12));
                        Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv4 = (390 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            $composer.createNode(constructor3);
                        } else {
                            $composer.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        int i8 = ((390 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 547526903, "C133@5508L10,131@5426L210,140@5797L10,141@5862L11,137@5653L343:VideoCard.kt#g7nzpb");
                        TextKt.m2817Text4IGK_g(str4, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 0, 3120, 55294);
                        TextKt.m2817Text4IGK_g(str3, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 48, 3120, 55288);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, "", null, $composer, 3072, 20);
                        if (f < 0.0f) {
                            $composer.startReplaceGroup(-1866076129);
                            ComposerKt.sourceInformation($composer, "151@6267L98");
                            ProgressIndicatorKt.m2497LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer, 6, 30);
                            $composer.endReplaceGroup();
                        } else {
                            $composer.startReplaceGroup(-1866075997);
                            ComposerKt.sourceInformation($composer, "156@6455L33,155@6399L209");
                            $composer.startReplaceGroup(-1866075941);
                            ComposerKt.sourceInformation($composer, "CC(remember):VideoCard.kt#9igjgp");
                            invalid$iv = $composer.changed(stateAnimateFloatAsState);
                            Object it$iv = $composer.rememberedValue();
                            if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(VideoCardKt.C33063.invoke$lambda$5$lambda$3(stateAnimateFloatAsState) / 100.0f);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            $composer.endReplaceGroup();
                            ProgressIndicatorKt.m2492LinearProgressIndicatorGJbTh5U((Function0) value$iv, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, null, $composer, 1572912, 60);
                            $composer.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    propagateMinConstraints$iv = false;
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    int i10 = ((6 >> 6) & 112) | 6;
                    BoxScope $this$invoke_u24lambda_u245_u24lambda_u242 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, 547524143, "C65@2716L545,65@2666L595,84@3523L6,85@3559L452,79@3279L732,96@4029L1166:VideoCard.kt#g7nzpb");
                    String str5 = str;
                    CrossfadeKt.Crossfade(obj, (Modifier) null, (FiniteAnimationSpec<Float>) null, "", ComposableLambdaKt.rememberComposableLambda(949400581, true, new Function3<Object, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Object p1, Composer composer, Integer num) {
                            invoke(p1, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Object it, Composer $composer2, int $changed2) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposerKt.sourceInformation($composer2, "C71@3016L6,66@2738L505:VideoCard.kt#g7nzpb");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(949400581, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:66)");
                            }
                            AsyncImageImplKt.m7233AsyncImageImpl10Xjiaw(it, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z, $composer2, 1572920, 0, 952);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), $composer, 27656, 6);
                    Modifier modifierAlign2 = $this$invoke_u24lambda_u245_u24lambda_u242.align(PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                    long jM4317getBlack0d7_KjU2 = Color.INSTANCE.m4317getBlack0d7_KjU();
                    SurfaceKt.m2666SurfaceT9BRK9s(modifierAlign2, MaterialTheme.INSTANCE.getShapes($composer, MaterialTheme.$stable).getExtraSmall(), Color.m4289copywmQWz5c(jM4317getBlack0d7_KjU2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4317getBlack0d7_KjU2) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4317getBlack0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4317getBlack0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4317getBlack0d7_KjU2) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1062377885, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C86@3615L16,91@3905L10,88@3717L276:VideoCard.kt#g7nzpb");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1062377885, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:86)");
                                }
                                String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d), $composer2, 0);
                                String durationText = TextUtilKt.toDurationText(i);
                                TextKt.m2817Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4328getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, 432, 0, 65528);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }, $composer, 54), $composer, 12583296, 120);
                    Modifier modifier$iv5 = $this$invoke_u24lambda_u245_u24lambda_u242.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv5 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        function2 = constructor2;
                        $composer.createNode(function2);
                    } else {
                        function2 = constructor2;
                        $composer.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash5);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                    int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScope $this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u241 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, -1916725613, "C103@4318L859,99@4141L1036:VideoCard.kt#g7nzpb");
                    AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u241, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-368433456, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                            invoke(animatedVisibilityScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer2, int $changed2) {
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            ComposerKt.sourceInformation($composer2, "C109@4657L11,108@4565L247,104@4344L810:VideoCard.kt#g7nzpb");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368433456, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:104)");
                            }
                            Function0<Unit> function4 = function3;
                            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(56));
                            IconButtonDefaults iconButtonDefaults = IconButtonDefaults.INSTANCE;
                            long surfaceContainerHighest = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerHighest();
                            IconButtonKt.FilledTonalIconButton(function4, modifierM913size3ABfNKs, false, null, iconButtonDefaults.m2284filledTonalIconButtonColorsro_MJ88(Color.m4289copywmQWz5c(surfaceContainerHighest, (14 & 1) != 0 ? Color.m4293getAlphaimpl(surfaceContainerHighest) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(surfaceContainerHighest) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(surfaceContainerHighest) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(surfaceContainerHighest) : 0.0f), 0L, 0L, 0L, $composer2, IconButtonDefaults.$stable << 12, 14), null, ComposableSingletons$VideoCardKt.INSTANCE.m7292getLambda1$app_debug(), $composer2, 1572912, 44);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), $composer, ((((0 >> 6) & 112) | 6) & 14) | 1600512, 18);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv6 = PaddingKt.m868padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(12));
                    Alignment.Horizontal horizontalAlignment$iv5 = Alignment.INSTANCE.getStart();
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv5 = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv7 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv5, horizontalAlignment$iv5, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv6 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv6 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifier$iv6);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        $composer.createNode(constructor3);
                    } else {
                        $composer.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash6);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                    int i12 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    int i13 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 547526903, "C133@5508L10,131@5426L210,140@5797L10,141@5862L11,137@5653L343:VideoCard.kt#g7nzpb");
                    TextKt.m2817Text4IGK_g(str5, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 0, 3120, 55294);
                    TextKt.m2817Text4IGK_g(str3, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 48, 3120, 55288);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, "", null, $composer, 3072, 20);
                    if (f < 0.0f) {
                        $composer.startReplaceGroup(-1866076129);
                        ComposerKt.sourceInformation($composer, "151@6267L98");
                        ProgressIndicatorKt.m2497LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer, 6, 30);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(-1866075997);
                        ComposerKt.sourceInformation($composer, "156@6455L33,155@6399L209");
                        $composer.startReplaceGroup(-1866075941);
                        ComposerKt.sourceInformation($composer, "CC(remember):VideoCard.kt#9igjgp");
                        invalid$iv = $composer.changed(stateAnimateFloatAsState);
                        Object it$iv2 = $composer.rememberedValue();
                        if (!invalid$iv) {
                            value$iv = new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(VideoCardKt.C33063.invoke$lambda$5$lambda$3(stateAnimateFloatAsState) / 100.0f);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(VideoCardKt.C33063.invoke$lambda$5$lambda$3(stateAnimateFloatAsState) / 100.0f);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        }
                        $composer.endReplaceGroup();
                        ProgressIndicatorKt.m2492LinearProgressIndicatorGJbTh5U((Function0) value$iv, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, null, $composer, 1572912, 60);
                        $composer.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                measurePolicy$iv = measurePolicy$iv2;
                str = str2;
                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i14 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                int i15 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1866079777, "C64@2619L2590,125@5223L787,146@6053L166:VideoCard.kt#g7nzpb");
                Modifier modifier$iv7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv8 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv7 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv7 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer, modifier$iv7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor;
                    $composer.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    propagateMinConstraints$iv = false;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                    int i16 = ($changed$iv$iv$iv7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    int i17 = ((6 >> 6) & 112) | 6;
                    BoxScope $this$invoke_u24lambda_u245_u24lambda_u243 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, 547524143, "C65@2716L545,65@2666L595,84@3523L6,85@3559L452,79@3279L732,96@4029L1166:VideoCard.kt#g7nzpb");
                    String str6 = str;
                    CrossfadeKt.Crossfade(obj, (Modifier) null, (FiniteAnimationSpec<Float>) null, "", ComposableLambdaKt.rememberComposableLambda(949400581, true, new Function3<Object, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Object p1, Composer composer, Integer num) {
                            invoke(p1, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Object it, Composer $composer2, int $changed2) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposerKt.sourceInformation($composer2, "C71@3016L6,66@2738L505:VideoCard.kt#g7nzpb");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(949400581, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:66)");
                            }
                            AsyncImageImplKt.m7233AsyncImageImpl10Xjiaw(it, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z, $composer2, 1572920, 0, 952);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), $composer, 27656, 6);
                    Modifier modifierAlign3 = $this$invoke_u24lambda_u245_u24lambda_u243.align(PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                    long jM4317getBlack0d7_KjU3 = Color.INSTANCE.m4317getBlack0d7_KjU();
                    SurfaceKt.m2666SurfaceT9BRK9s(modifierAlign3, MaterialTheme.INSTANCE.getShapes($composer, MaterialTheme.$stable).getExtraSmall(), Color.m4289copywmQWz5c(jM4317getBlack0d7_KjU3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4317getBlack0d7_KjU3) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4317getBlack0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4317getBlack0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4317getBlack0d7_KjU3) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1062377885, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C86@3615L16,91@3905L10,88@3717L276:VideoCard.kt#g7nzpb");
                            if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1062377885, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:86)");
                                }
                                String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d), $composer2, 0);
                                String durationText = TextUtilKt.toDurationText(i);
                                TextKt.m2817Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4328getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, 432, 0, 65528);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }, $composer, 54), $composer, 12583296, 120);
                    Modifier modifier$iv8 = $this$invoke_u24lambda_u245_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv6 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv6 = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv9 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv6, horizontalAlignment$iv6, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv8 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv8 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer, modifier$iv8);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv8 = (($changed$iv$iv8 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        function2 = constructor2;
                        $composer.createNode(function2);
                    } else {
                        function2 = constructor2;
                        $composer.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash8);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                    int i18 = ($changed$iv$iv$iv8 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScope $this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u242 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, -1916725613, "C103@4318L859,99@4141L1036:VideoCard.kt#g7nzpb");
                    AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u242, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-368433456, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                            invoke(animatedVisibilityScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer2, int $changed2) {
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            ComposerKt.sourceInformation($composer2, "C109@4657L11,108@4565L247,104@4344L810:VideoCard.kt#g7nzpb");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-368433456, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:104)");
                            }
                            Function0<Unit> function4 = function3;
                            Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(56));
                            IconButtonDefaults iconButtonDefaults = IconButtonDefaults.INSTANCE;
                            long surfaceContainerHighest = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerHighest();
                            IconButtonKt.FilledTonalIconButton(function4, modifierM913size3ABfNKs, false, null, iconButtonDefaults.m2284filledTonalIconButtonColorsro_MJ88(Color.m4289copywmQWz5c(surfaceContainerHighest, (14 & 1) != 0 ? Color.m4293getAlphaimpl(surfaceContainerHighest) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(surfaceContainerHighest) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(surfaceContainerHighest) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(surfaceContainerHighest) : 0.0f), 0L, 0L, 0L, $composer2, IconButtonDefaults.$stable << 12, 14), null, ComposableSingletons$VideoCardKt.INSTANCE.m7292getLambda1$app_debug(), $composer2, 1572912, 44);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), $composer, ((((0 >> 6) & 112) | 6) & 14) | 1600512, 18);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv9 = PaddingKt.m868padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(12));
                    Alignment.Horizontal horizontalAlignment$iv7 = Alignment.INSTANCE.getStart();
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv7 = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv10 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv7, horizontalAlignment$iv7, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv9 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv9 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer, modifier$iv9);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv9 = (($changed$iv$iv9 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        $composer.createNode(constructor3);
                    } else {
                        $composer.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash9);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                    int i19 = ($changed$iv$iv$iv9 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    int i110 = ((390 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 547526903, "C133@5508L10,131@5426L210,140@5797L10,141@5862L11,137@5653L343:VideoCard.kt#g7nzpb");
                    TextKt.m2817Text4IGK_g(str6, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 0, 3120, 55294);
                    TextKt.m2817Text4IGK_g(str3, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 48, 3120, 55288);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, "", null, $composer, 3072, 20);
                    if (f < 0.0f) {
                        $composer.startReplaceGroup(-1866076129);
                        ComposerKt.sourceInformation($composer, "151@6267L98");
                        ProgressIndicatorKt.m2497LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer, 6, 30);
                        $composer.endReplaceGroup();
                    } else {
                        $composer.startReplaceGroup(-1866075997);
                        ComposerKt.sourceInformation($composer, "156@6455L33,155@6399L209");
                        $composer.startReplaceGroup(-1866075941);
                        ComposerKt.sourceInformation($composer, "CC(remember):VideoCard.kt#9igjgp");
                        invalid$iv = $composer.changed(stateAnimateFloatAsState);
                        Object it$iv3 = $composer.rememberedValue();
                        if (!invalid$iv) {
                            value$iv = new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(VideoCardKt.C33063.invoke$lambda$5$lambda$3(stateAnimateFloatAsState) / 100.0f);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(VideoCardKt.C33063.invoke$lambda$5$lambda$3(stateAnimateFloatAsState) / 100.0f);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        }
                        $composer.endReplaceGroup();
                        ProgressIndicatorKt.m2492LinearProgressIndicatorGJbTh5U((Function0) value$iv, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, null, $composer, 1572912, 60);
                        $composer.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                propagateMinConstraints$iv = false;
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash7);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                int i111 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                int i112 = ((6 >> 6) & 112) | 6;
                BoxScope $this$invoke_u24lambda_u245_u24lambda_u244 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 547524143, "C65@2716L545,65@2666L595,84@3523L6,85@3559L452,79@3279L732,96@4029L1166:VideoCard.kt#g7nzpb");
                String str7 = str;
                CrossfadeKt.Crossfade(obj, (Modifier) null, (FiniteAnimationSpec<Float>) null, "", ComposableLambdaKt.rememberComposableLambda(949400581, true, new Function3<Object, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Object p1, Composer composer, Integer num) {
                        invoke(p1, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Object it, Composer $composer2, int $changed2) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation($composer2, "C71@3016L6,66@2738L505:VideoCard.kt#g7nzpb");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(949400581, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:66)");
                        }
                        AsyncImageImplKt.m7233AsyncImageImpl10Xjiaw(it, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null), 0.0f, 1, null), 1.7777778f, true), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getSmall()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, z, $composer2, 1572920, 0, 952);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), $composer, 27656, 6);
                Modifier modifierAlign4 = $this$invoke_u24lambda_u245_u24lambda_u244.align(PaddingKt.m868padding3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4)), Alignment.INSTANCE.getBottomEnd());
                long jM4317getBlack0d7_KjU4 = Color.INSTANCE.m4317getBlack0d7_KjU();
                SurfaceKt.m2666SurfaceT9BRK9s(modifierAlign4, MaterialTheme.INSTANCE.getShapes($composer, MaterialTheme.$stable).getExtraSmall(), Color.m4289copywmQWz5c(jM4317getBlack0d7_KjU4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4317getBlack0d7_KjU4) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4317getBlack0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4317getBlack0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4317getBlack0d7_KjU4) : 0.0f), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1062377885, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C86@3615L16,91@3905L10,88@3717L276:VideoCard.kt#g7nzpb");
                        if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1062377885, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:86)");
                            }
                            String fileSizeText = TextUtilKt.toFileSizeText(Double.valueOf(d), $composer2, 0);
                            String durationText = TextUtilKt.toDurationText(i);
                            TextKt.m2817Text4IGK_g(fileSizeText + " · " + durationText, PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(4), 0.0f, 2, null), Color.INSTANCE.m4328getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, 432, 0, 65528);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }, $composer, 54), $composer, 12583296, 120);
                Modifier modifier$iv10 = $this$invoke_u24lambda_u245_u24lambda_u244.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv8 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv8 = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv11 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv8, horizontalAlignment$iv8, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv10 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv10 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv10 = ComposedModifierKt.materializeModifier($composer, modifier$iv10);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv10 = (($changed$iv$iv10 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function2 = constructor2;
                    $composer.createNode(function2);
                } else {
                    function2 = constructor2;
                    $composer.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash10);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv10, ComposeUiNode.INSTANCE.getSetModifier());
                int i113 = ($changed$iv$iv$iv10 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScope $this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u243 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -1916725613, "C103@4318L859,99@4141L1036:VideoCard.kt#g7nzpb");
                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u245_u24lambda_u241_u24lambda_u243, z2, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-368433456, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                        invoke(animatedVisibilityScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer2, int $changed2) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation($composer2, "C109@4657L11,108@4565L247,104@4344L810:VideoCard.kt#g7nzpb");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-368433456, $changed2, -1, "com.videshkarmakar.loop.ui.component.VideoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoCard.kt:104)");
                        }
                        Function0<Unit> function4 = function3;
                        Modifier modifierM913size3ABfNKs = SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(56));
                        IconButtonDefaults iconButtonDefaults = IconButtonDefaults.INSTANCE;
                        long surfaceContainerHighest = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerHighest();
                        IconButtonKt.FilledTonalIconButton(function4, modifierM913size3ABfNKs, false, null, iconButtonDefaults.m2284filledTonalIconButtonColorsro_MJ88(Color.m4289copywmQWz5c(surfaceContainerHighest, (14 & 1) != 0 ? Color.m4293getAlphaimpl(surfaceContainerHighest) : 0.68f, (14 & 2) != 0 ? Color.m4297getRedimpl(surfaceContainerHighest) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(surfaceContainerHighest) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(surfaceContainerHighest) : 0.0f), 0L, 0L, 0L, $composer2, IconButtonDefaults.$stable << 12, 14), null, ComposableSingletons$VideoCardKt.INSTANCE.m7292getLambda1$app_debug(), $composer2, 1572912, 44);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), $composer, ((((0 >> 6) & 112) | 6) & 14) | 1600512, 18);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv11 = PaddingKt.m868padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(12));
                Alignment.Horizontal horizontalAlignment$iv9 = Alignment.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv9 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv12 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv9, horizontalAlignment$iv9, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv11 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv11 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer, modifier$iv11);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv11 = (($changed$iv$iv11 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(constructor3);
                } else {
                    $composer.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                }
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash11);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
                int i114 = ($changed$iv$iv$iv11 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                int i115 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 547526903, "C133@5508L10,131@5426L210,140@5797L10,141@5862L11,137@5653L343:VideoCard.kt#g7nzpb");
                TextKt.m2817Text4IGK_g(str7, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 0, 3120, 55294);
                TextKt.m2817Text4IGK_g(str3, PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1979Dp.m6801constructorimpl(3), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 48, 3120, 55288);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, ProgressIndicatorDefaults.INSTANCE.getProgressAnimationSpec(), 0.0f, "", null, $composer, 3072, 20);
                if (f < 0.0f) {
                    $composer.startReplaceGroup(-1866076129);
                    ComposerKt.sourceInformation($composer, "151@6267L98");
                    ProgressIndicatorKt.m2497LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer, 6, 30);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-1866075997);
                    ComposerKt.sourceInformation($composer, "156@6455L33,155@6399L209");
                    $composer.startReplaceGroup(-1866075941);
                    ComposerKt.sourceInformation($composer, "CC(remember):VideoCard.kt#9igjgp");
                    invalid$iv = $composer.changed(stateAnimateFloatAsState);
                    Object it$iv4 = $composer.rememberedValue();
                    if (!invalid$iv) {
                        value$iv = new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(VideoCardKt.C33063.invoke$lambda$5$lambda$3(stateAnimateFloatAsState) / 100.0f);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = new Function0<Float>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt$VideoCard$3$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(VideoCardKt.C33063.invoke$lambda$5$lambda$3(stateAnimateFloatAsState) / 100.0f);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    }
                    $composer.endReplaceGroup();
                    ProgressIndicatorKt.m2492LinearProgressIndicatorGJbTh5U((Function0) value$iv, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, null, $composer, 1572912, 60);
                    $composer.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$5$lambda$3(State<Float> state) {
            Object thisObj$iv = state.getValue();
            return ((Number) thisObj$iv).floatValue();
        }
    }

    public static final void VideoCardPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-242539089);
        ComposerKt.sourceInformation($composer2, "C(VideoCardPreview)168@6749L55:VideoCard.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-242539089, $changed, -1, "com.videshkarmakar.loop.ui.component.VideoCardPreview (VideoCard.kt:167)");
            }
            ThemeKt.LoopTheme(false, false, false, ComposableSingletons$VideoCardKt.INSTANCE.m7293getLambda2$app_debug(), $composer2, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.VideoCardKt.VideoCardPreview.1
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
                    VideoCardKt.VideoCardPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
