package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.common.AsyncImageImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SponsorItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aW\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0013"}, d2 = {"SponsorItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "userName", "", "userLogin", "avatarUrl", "", "profileUrl", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SponsorItemPreview", "(Landroidx/compose/runtime/Composer;I)V", "gitHubAvatar", "gitHubProfile", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SponsorItemKt {
    public static final String gitHubAvatar(String userLogin) {
        Intrinsics.checkNotNullParameter(userLogin, "userLogin");
        return "https://github.com/" + userLogin + ".png";
    }

    public static final String gitHubProfile(String userLogin) {
        Intrinsics.checkNotNullParameter(userLogin, "userLogin");
        return "https://github.com/" + userLogin;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0320  */
    /* JADX WARN: Code duplicated, block: B:116:0x032c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0332  */
    /* JADX WARN: Code duplicated, block: B:120:0x0363  */
    /* JADX WARN: Code duplicated, block: B:123:0x0376  */
    /* JADX WARN: Code duplicated, block: B:124:0x0379  */
    /* JADX WARN: Code duplicated, block: B:128:0x047a  */
    /* JADX WARN: Code duplicated, block: B:131:0x0486  */
    /* JADX WARN: Code duplicated, block: B:132:0x048c  */
    /* JADX WARN: Code duplicated, block: B:135:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:138:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:139:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:143:0x0529  */
    /* JADX WARN: Code duplicated, block: B:144:0x0555  */
    /* JADX WARN: Code duplicated, block: B:147:0x0689  */
    public static final void SponsorItem(Modifier modifier, final String userName, final String userLogin, Object avatarUrl, String profileUrl, PaddingValues contentPadding, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        PaddingValues contentPadding2;
        Function0<Unit> function1;
        Object avatarUrl2;
        String profileUrl2;
        Modifier modifier3;
        Object avatarUrl3;
        String profileUrl3;
        PaddingValues contentPadding3;
        Function0<Unit> function2;
        int $dirty;
        Function0<ComposeUiNode> function3;
        MeasurePolicy measurePolicy$iv;
        Arrangement.Vertical verticalArrangement$iv;
        int compositeKeyHash$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function4;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        Arrangement.Vertical verticalArrangement$iv2;
        Modifier modifier$iv;
        int compositeKeyHash$iv$iv2;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> function5;
        Composer $this$Layout_u24lambda_u240$iv$iv2;
        CompositionLocalMap localMap$iv$iv2;
        Modifier modifier$iv2;
        Composer $composer$iv;
        Intrinsics.checkNotNullParameter(userLogin, "userLogin");
        Composer $composer2 = $composer.startRestartGroup(1907096160);
        ComposerKt.sourceInformation($composer2, "C(SponsorItem)P(2,6,5!1,4)35@1421L1522:SponsorItem.kt#g7nzpb");
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
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(userName) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(userLogin) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 1024;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            contentPadding2 = contentPadding;
        } else if ((458752 & $changed) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 131072 : 65536;
        } else {
            contentPadding2 = contentPadding;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 1572864;
            function1 = function0;
        } else if ((3670016 & $changed) == 0) {
            function1 = function0;
            $dirty2 |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        } else {
            function1 = function0;
        }
        if (i3 == 8 && (2954971 & $dirty2) == 590994 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            avatarUrl3 = avatarUrl;
            profileUrl3 = profileUrl;
            modifier3 = modifier2;
            contentPadding3 = contentPadding2;
            function2 = function1;
            $composer2 = $composer2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    avatarUrl2 = gitHubAvatar(userLogin);
                    $dirty2 &= -7169;
                } else {
                    avatarUrl2 = avatarUrl;
                }
                if ((i & 16) != 0) {
                    profileUrl2 = gitHubProfile(userLogin);
                    $dirty2 &= -57345;
                } else {
                    profileUrl2 = profileUrl;
                }
                if (i4 != 0) {
                    contentPadding2 = PaddingKt.m614PaddingValuesYgX7TsA(Dp.m6553constructorimpl(0), Dp.m6553constructorimpl(12));
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    avatarUrl3 = avatarUrl2;
                    profileUrl3 = profileUrl2;
                    function2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.SponsorItemKt.SponsorItem.1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    };
                    contentPadding3 = contentPadding2;
                } else {
                    modifier3 = modifier4;
                    avatarUrl3 = avatarUrl2;
                    profileUrl3 = profileUrl2;
                    contentPadding3 = contentPadding2;
                    function2 = function1;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if (i3 != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                avatarUrl3 = avatarUrl;
                profileUrl3 = profileUrl;
                modifier3 = modifier2;
                contentPadding3 = contentPadding2;
                function2 = function1;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1907096160, $dirty, -1, "com.videshkarmakar.loop.ui.component.SponsorItem (SponsorItem.kt:34)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.INSTANCE;
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor3);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                function3 = constructor3;
                measurePolicy$iv = measurePolicy$iv2;
            } else {
                function3 = constructor3;
                measurePolicy$iv = measurePolicy$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i7 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1832402815, "C39@1548L6,36@1440L1497:SponsorItem.kt#g7nzpb");
                Modifier modifier$iv4 = PaddingKt.m620padding3ABfNKs(ClickableKt.m239clickableXHw0xAI$default(ClipKt.clip(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getLarge()), false, null, null, function2, 7, null), Dp.m6553constructorimpl(4));
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv2, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function4 = constructor;
                    $composer2.createNode(function4);
                } else {
                    function4 = constructor;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    verticalArrangement$iv2 = verticalArrangement$iv;
                } else {
                    verticalArrangement$iv2 = verticalArrangement$iv;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    int i9 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 757103208, "C46@1766L311,55@2090L836:SponsorItem.kt#g7nzpb");
                    AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(avatarUrl3, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, true), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, $composer2, 1572920, 0, 1976);
                    modifier$iv = PaddingKt.padding(Modifier.INSTANCE, contentPadding3);
                    Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv3, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv3 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        function5 = constructor2;
                        $composer2.createNode(function5);
                    } else {
                        function5 = constructor2;
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        localMap$iv$iv2 = localMap$iv$iv;
                        modifier$iv2 = modifier$iv;
                    } else {
                        localMap$iv$iv2 = localMap$iv$iv;
                        modifier$iv2 = modifier$iv;
                        if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                        }
                        Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                        int i11 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
                        $composer2.startReplaceGroup(814500735);
                        ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
                        if (userName == null) {
                            $composer$iv = $composer2;
                        } else {
                            $composer$iv = $composer2;
                            TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                            Unit unit = Unit.INSTANCE;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        $composer$iv.endReplaceGroup();
                        Composer $composer3 = $composer$iv;
                        TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), $composer3, 0, 3120, 55290);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        r14.endNode();
                        ComposerKt.sourceInformationMarkerEnd(r14);
                        ComposerKt.sourceInformationMarkerEnd(r14);
                        ComposerKt.sourceInformationMarkerEnd(r14);
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
                    }
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    int i13 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
                    $composer2.startReplaceGroup(814500735);
                    ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
                    if (userName == null) {
                        $composer$iv = $composer2;
                    } else {
                        $composer$iv = $composer2;
                        TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    $composer$iv.endReplaceGroup();
                    Composer $composer4 = $composer$iv;
                    TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), $composer4, 0, 3120, 55290);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    r14.endNode();
                    ComposerKt.sourceInformationMarkerEnd(r14);
                    ComposerKt.sourceInformationMarkerEnd(r14);
                    ComposerKt.sourceInformationMarkerEnd(r14);
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
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i14 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                int i15 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 757103208, "C46@1766L311,55@2090L836:SponsorItem.kt#g7nzpb");
                AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(avatarUrl3, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, true), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, $composer2, 1572920, 0, 1976);
                modifier$iv = PaddingKt.padding(Modifier.INSTANCE, contentPadding3);
                Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv5 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv5, horizontalAlignment$iv4, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv4 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function5 = constructor2;
                    $composer2.createNode(function5);
                } else {
                    function5 = constructor2;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    localMap$iv$iv2 = localMap$iv$iv;
                    modifier$iv2 = modifier$iv;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i16 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                    int i17 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
                    $composer2.startReplaceGroup(814500735);
                    ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
                    if (userName == null) {
                        $composer$iv = $composer2;
                    } else {
                        $composer$iv = $composer2;
                        TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                        Unit unit5 = Unit.INSTANCE;
                        Unit unit6 = Unit.INSTANCE;
                    }
                    $composer$iv.endReplaceGroup();
                    Composer $composer5 = $composer$iv;
                    TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodySmall(), $composer5, 0, 3120, 55290);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    r14.endNode();
                    ComposerKt.sourceInformationMarkerEnd(r14);
                    ComposerKt.sourceInformationMarkerEnd(r14);
                    ComposerKt.sourceInformationMarkerEnd(r14);
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
                } else {
                    localMap$iv$iv2 = localMap$iv$iv;
                    modifier$iv2 = modifier$iv;
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash4);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i18 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                int i19 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
                $composer2.startReplaceGroup(814500735);
                ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
                if (userName == null) {
                    $composer$iv = $composer2;
                } else {
                    $composer$iv = $composer2;
                    TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                    Unit unit7 = Unit.INSTANCE;
                    Unit unit8 = Unit.INSTANCE;
                }
                $composer$iv.endReplaceGroup();
                Composer $composer6 = $composer$iv;
                TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer6, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer6, MaterialTheme.$stable).getBodySmall(), $composer6, 0, 3120, 55290);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                r14.endNode();
                ComposerKt.sourceInformationMarkerEnd(r14);
                ComposerKt.sourceInformationMarkerEnd(r14);
                ComposerKt.sourceInformationMarkerEnd(r14);
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
            }
            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i20 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
            int i21 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1832402815, "C39@1548L6,36@1440L1497:SponsorItem.kt#g7nzpb");
            Modifier modifier$iv5 = PaddingKt.m620padding3ABfNKs(ClickableKt.m239clickableXHw0xAI$default(ClipKt.clip(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes($composer2, MaterialTheme.$stable).getLarge()), false, null, null, function2, 7, null), Dp.m6553constructorimpl(4));
            Alignment.Horizontal horizontalAlignment$iv5 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv5, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv5 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function4 = constructor;
                $composer2.createNode(function4);
            } else {
                function4 = constructor;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                verticalArrangement$iv2 = verticalArrangement$iv;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                int i110 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                int i111 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 757103208, "C46@1766L311,55@2090L836:SponsorItem.kt#g7nzpb");
                AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(avatarUrl3, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, true), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, $composer2, 1572920, 0, 1976);
                modifier$iv = PaddingKt.padding(Modifier.INSTANCE, contentPadding3);
                Alignment.Horizontal horizontalAlignment$iv6 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv6 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv7 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv6, horizontalAlignment$iv6, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv6 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function5 = constructor2;
                    $composer2.createNode(function5);
                } else {
                    function5 = constructor2;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    localMap$iv$iv2 = localMap$iv$iv;
                    modifier$iv2 = modifier$iv;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                    int i112 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    int i113 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
                    $composer2.startReplaceGroup(814500735);
                    ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
                    if (userName == null) {
                        $composer$iv = $composer2;
                    } else {
                        $composer$iv = $composer2;
                        TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                        Unit unit9 = Unit.INSTANCE;
                        Unit unit10 = Unit.INSTANCE;
                    }
                    $composer$iv.endReplaceGroup();
                    Composer $composer7 = $composer$iv;
                    TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer7, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer7, MaterialTheme.$stable).getBodySmall(), $composer7, 0, 3120, 55290);
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    r14.endNode();
                    ComposerKt.sourceInformationMarkerEnd(r14);
                    ComposerKt.sourceInformationMarkerEnd(r14);
                    ComposerKt.sourceInformationMarkerEnd(r14);
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
                } else {
                    localMap$iv$iv2 = localMap$iv$iv;
                    modifier$iv2 = modifier$iv;
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                int i114 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                int i115 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
                $composer2.startReplaceGroup(814500735);
                ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
                if (userName == null) {
                    $composer$iv = $composer2;
                } else {
                    $composer$iv = $composer2;
                    TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                }
                $composer$iv.endReplaceGroup();
                Composer $composer8 = $composer$iv;
                TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer8, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer8, MaterialTheme.$stable).getBodySmall(), $composer8, 0, 3120, 55290);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                r14.endNode();
                ComposerKt.sourceInformationMarkerEnd(r14);
                ComposerKt.sourceInformationMarkerEnd(r14);
                ComposerKt.sourceInformationMarkerEnd(r14);
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
            } else {
                verticalArrangement$iv2 = verticalArrangement$iv;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash5);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
            int i116 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
            int i117 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 757103208, "C46@1766L311,55@2090L836:SponsorItem.kt#g7nzpb");
            AsyncImageImplKt.m7097AsyncImageImpl10Xjiaw(avatarUrl3, null, ClipKt.clip(AspectRatioKt.aspectRatio(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, true), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, $composer2, 1572920, 0, 1976);
            modifier$iv = PaddingKt.padding(Modifier.INSTANCE, contentPadding3);
            Alignment.Horizontal horizontalAlignment$iv7 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv7 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv8 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv7, horizontalAlignment$iv7, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv7 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function5 = constructor2;
                $composer2.createNode(function5);
            } else {
                function5 = constructor2;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                localMap$iv$iv2 = localMap$iv$iv;
                modifier$iv2 = modifier$iv;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                int i118 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                int i119 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
                $composer2.startReplaceGroup(814500735);
                ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
                if (userName == null) {
                    $composer$iv = $composer2;
                } else {
                    $composer$iv = $composer2;
                    TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                    Unit unit13 = Unit.INSTANCE;
                    Unit unit14 = Unit.INSTANCE;
                }
                $composer$iv.endReplaceGroup();
                Composer $composer9 = $composer$iv;
                TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer9, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer9, MaterialTheme.$stable).getBodySmall(), $composer9, 0, 3120, 55290);
                ComposerKt.sourceInformationMarkerEnd($composer9);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                r14.endNode();
                ComposerKt.sourceInformationMarkerEnd(r14);
                ComposerKt.sourceInformationMarkerEnd(r14);
                ComposerKt.sourceInformationMarkerEnd(r14);
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
            } else {
                localMap$iv$iv2 = localMap$iv$iv;
                modifier$iv2 = modifier$iv;
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash7);
            Updater.m3554setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
            int i1110 = ($changed$iv$iv$iv7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
            int i1111 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 814500725, "C71@2748L10,72@2812L11,68@2624L288:SponsorItem.kt#g7nzpb");
            $composer2.startReplaceGroup(814500735);
            ComposerKt.sourceInformation($composer2, "*63@2419L10,64@2488L11,60@2294L295");
            if (userName == null) {
                $composer$iv = $composer2;
            } else {
                $composer$iv = $composer2;
                TextKt.m2569Text4IGK_g(userName, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 0, 3120, 55290);
                Unit unit15 = Unit.INSTANCE;
                Unit unit16 = Unit.INSTANCE;
            }
            $composer$iv.endReplaceGroup();
            Composer $composer10 = $composer$iv;
            TextKt.m2569Text4IGK_g("@" + userLogin, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer10, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6460getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer10, MaterialTheme.$stable).getBodySmall(), $composer10, 0, 3120, 55290);
            ComposerKt.sourceInformationMarkerEnd($composer10);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            r14.endNode();
            ComposerKt.sourceInformationMarkerEnd(r14);
            ComposerKt.sourceInformationMarkerEnd(r14);
            ComposerKt.sourceInformationMarkerEnd(r14);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Object obj = avatarUrl3;
            final String str = profileUrl3;
            final PaddingValues paddingValues = contentPadding3;
            final Function0<Unit> function6 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SponsorItemKt.SponsorItem.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i22) {
                    SponsorItemKt.SponsorItem(modifier5, userName, userLogin, obj, str, paddingValues, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void SponsorItemPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1774579375);
        ComposerKt.sourceInformation($composer2, "C(SponsorItemPreview)85@3000L156:SponsorItem.kt#g7nzpb");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1774579375, $changed, -1, "com.videshkarmakar.loop.ui.component.SponsorItemPreview (SponsorItem.kt:84)");
            }
            SponsorItem(null, "junkfood", "JunkFood02", Integer.valueOf(R.drawable.sample1), "", null, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.component.SponsorItemKt.SponsorItemPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, $composer2, 1597872, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.SponsorItemKt.SponsorItemPreview.2
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
                    SponsorItemKt.SponsorItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
