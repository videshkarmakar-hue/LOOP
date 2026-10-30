package com.videshkarmakar.loop.p006ui.page;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowForwardKt;
import androidx.compose.material.icons.filled.CameraAltKt;
import androidx.compose.material.icons.filled.FacebookKt;
import androidx.compose.material.icons.filled.LanguageKt;
import androidx.compose.material.icons.filled.MusicNoteKt;
import androidx.compose.material.icons.filled.OpenInNewKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.UriHandler;
import androidx.compose.p001ui.res.PainterResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.theme.Neu;
import com.videshkarmakar.loop.p006ui.theme.NeuMorphismKt;
import com.videshkarmakar.loop.p006ui.theme.TypeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WelcomeScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001b\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0003¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0003¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0007¢\u0006\u0002\u0010\n\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0011H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0002X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0002X\u008a\u0084\u0002"}, m195d2 = {"RowPressSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "socialLinks", "", "Lcom/videshkarmakar/loop/ui/page/SocialLink;", "ContinueButton", "", "onClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SocialLinkRow", "link", "(Lcom/videshkarmakar/loop/ui/page/SocialLink;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WelcomeScreen", "onContinue", "displayHost", "", "app_debug", "isPressed", "", "pressScale"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WelcomeScreenKt {
    private static final List<SocialLink> socialLinks = CollectionsKt.listOf((Object[]) new SocialLink[]{new SocialLink("Website", "https://videshkarmakar.carrd.co/", LanguageKt.getLanguage(Icons.Filled.INSTANCE)), new SocialLink("Spotify", "https://open.spotify.com/artist/2eJEzi0mzJB60zVJf0OjWP", MusicNoteKt.getMusicNote(Icons.Filled.INSTANCE)), new SocialLink("Instagram", "https://www.instagram.com/code.red_videsh/", CameraAltKt.getCameraAlt(Icons.Filled.INSTANCE)), new SocialLink("YouTube", "https://www.youtube.com/@videshkarmakar2000", PlayArrowKt.getPlayArrow(Icons.Filled.INSTANCE)), new SocialLink("Facebook", "https://www.facebook.com/gfx.videsh", FacebookKt.getFacebook(Icons.Filled.INSTANCE))});
    private static final TweenSpec<Float> RowPressSpec = AnimationSpecKt.tween$default(120, 0, null, 6, null);

    private static final String displayHost(String $this$displayHost) {
        return StringsKt.removePrefix(StringsKt.removePrefix($this$displayHost, (CharSequence) "https://"), (CharSequence) "www.");
    }

    public static final void WelcomeScreen(final Function0<Unit> onContinue, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Composer $composer2;
        Function0<ComposeUiNode> function2;
        int $changed$iv;
        Intrinsics.checkNotNullParameter(onContinue, "onContinue");
        Composer $composer3 = $composer.startRestartGroup(-1231586653);
        ComposerKt.sourceInformation($composer3, "C(WelcomeScreen)109@4332L7,114@4446L11,115@4498L21,111@4345L4380:WelcomeScreen.kt#hmxj0r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(onContinue) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1231586653, $dirty, -1, "com.videshkarmakar.loop.ui.page.WelcomeScreen (WelcomeScreen.kt:108)");
            }
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final UriHandler uriHandler = (UriHandler) objConsume;
            Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(ScrollKt.verticalScroll$default(BackgroundKt.m454backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getBackground(), null, 2, null), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null), C1979Dp.m6801constructorimpl(28), C1979Dp.m6801constructorimpl(40));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1699006470, "C119@4656L41,122@4736L55,121@4707L351,131@5068L41,135@5186L10,137@5288L11,133@5119L203,140@5332L40,144@5486L10,145@5543L11,142@5382L241,149@5633L41,158@5932L11,162@6083L11,152@5715L1602,197@7327L41,208@7824L11,203@7651L920,230@8581L41,232@8632L36,234@8678L41:WelcomeScreen.kt#hmxj0r");
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(12)), $composer3, 6);
            ImageKt.Image(PainterResources_androidKt.painterResource(C3070R.drawable.ic_onboarding_app_icon, $composer3, 0), "LOOP app icon", ClipKt.clip(PaddingKt.m868padding3ABfNKs(NeuMorphismKt.m7662neuRaisedwkf6fSU(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(LocationRequestCompat.QUALITY_LOW_POWER)), C1979Dp.m6801constructorimpl(28), (4 & 2) != 0 ? C1979Dp.m6801constructorimpl(8) : C1979Dp.m6801constructorimpl(8), (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? Neu.INSTANCE.m7647getBase0d7_KjU() : 0L), C1979Dp.m6801constructorimpl(16)), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(16))), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, 56, 120);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(24)), $composer3, 6);
            TextKt.m2817Text4IGK_g("LOOP", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, (FontWeight) null, TypeKt.getMilkerFontFamily(), 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getDisplaySmall(), $composer3, 1572870, 0, 65466);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(6)), $composer3, 6);
            TextKt.m2817Text4IGK_g("Every Day, Every Download, Every Content.", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(TextAlign.INSTANCE.m6658getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 6, 0, 65018);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(32)), $composer3, 6);
            Modifier modifier$iv2 = PaddingKt.m868padding3ABfNKs(BorderKt.m465borderxT4_qwU(NeuMorphismKt.m7662neuRaisedwkf6fSU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(24), (4 & 2) != 0 ? C1979Dp.m6801constructorimpl(8) : C1979Dp.m6801constructorimpl(6), (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? Neu.INSTANCE.m7647getBase0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceContainerLow()), C1979Dp.m6801constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutlineVariant(), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(24))), C1979Dp.m6801constructorimpl(22));
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
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
                function1 = constructor2;
                $composer3.createNode(function1);
            } else {
                function1 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            $composer2 = $composer3;
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1566293910, "C169@6336L56,168@6303L271,176@6588L41,180@6740L10,182@6852L11,178@6643L290,186@6947L41,190@7122L10,191@7183L11,188@7002L305:WelcomeScreen.kt#hmxj0r");
            ImageKt.Image(PainterResources_androidKt.painterResource(C3070R.drawable.ic_onboarding_developer, $composer3, 0), "Developer portrait", ClipKt.clip(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(72)), RoundedCornerShapeKt.getCircleShape()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, 56, 120);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(14)), $composer3, 6);
            TextKt.m2817Text4IGK_g("Crafted by VIDESH KARMAKAR", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(TextAlign.INSTANCE.m6658getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 196614, 0, 64986);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(10)), $composer3, 6);
            TextKt.m2817Text4IGK_g("Thanks for Supporting My Project “LOOP”", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6651boximpl(TextAlign.INSTANCE.m6658getCentere0LSkKk()), TextUnitKt.getSp(21), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 6, 6, 63994);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(28)), $composer3, 6);
            Modifier modifier$iv3 = ClipKt.clip(BorderKt.m465borderxT4_qwU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutlineVariant(), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(22))), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(22)));
            int $changed$iv2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                function2 = constructor3;
                $composer3.createNode(function2);
            } else {
                function2 = constructor3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1566295604, "C:WelcomeScreen.kt#hmxj0r");
            $composer3.startReplaceGroup(1699009823);
            ComposerKt.sourceInformation($composer3, "*223@8419L128");
            Iterable $this$forEachIndexed$iv = socialLinks;
            int $i$f$forEachIndexed = 0;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                final SocialLink link = (SocialLink) item$iv;
                int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
                $composer3.startReplaceGroup(1566295664);
                ComposerKt.sourceInformation($composer3, "220@8335L11,215@8094L290");
                if (index$iv > 0) {
                    $changed$iv = 0;
                    BoxKt.Box(BackgroundKt.m454backgroundbw27NRU$default(SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(62), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null), C1979Dp.m6801constructorimpl(1)), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOutlineVariant(), null, 2, null), $composer3, 0);
                } else {
                    $changed$iv = 0;
                }
                $composer3.endReplaceGroup();
                SocialLinkRow(link, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeScreenKt$WelcomeScreen$1$2$1$1
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
                        uriHandler.openUri(link.getUrl());
                    }
                }, $composer3, $changed$iv);
                compositeKeyHash$iv$iv3 = compositeKeyHash$iv$iv3;
                materialized$iv$iv3 = materialized$iv$iv3;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                $i$f$forEachIndexed = $i$f$forEachIndexed2;
                $changed$iv2 = $changed$iv2;
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(36)), $composer3, 6);
            ContinueButton(onContinue, $composer3, $dirty & 14);
            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(20)), $composer3, 6);
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
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeScreenKt.WelcomeScreen.2
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
                    WelcomeScreenKt.WelcomeScreen(onContinue, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SocialLinkRow(final SocialLink link, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function2;
        Function0<ComposeUiNode> function3;
        Composer $composer2 = $composer.startRestartGroup(1384433053);
        ComposerKt.sourceInformation($composer2, "C(SocialLinkRow)240@8836L39,241@8915L25,242@8963L150,251@9207L87,248@9119L1786:WelcomeScreen.kt#hmxj0r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(link) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1384433053, $dirty2, -1, "com.videshkarmakar.loop.ui.page.SocialLinkRow (WelcomeScreen.kt:239)");
            }
            $composer2.startReplaceGroup(46120308);
            ComposerKt.sourceInformation($composer2, "CC(remember):WelcomeScreen.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv;
            $composer2.endReplaceGroup();
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(SocialLinkRow$lambda$5(PressInteractionKt.collectIsPressedAsState(interactionSource, $composer2, 6)) ? 0.985f : 1.0f, RowPressSpec, 0.0f, "socialRowPress", null, $composer2, 3120, 20);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            $composer2.startReplaceGroup(46120679);
            ComposerKt.sourceInformation($composer2, "CC(remember):WelcomeScreen.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(stateAnimateFloatAsState);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeScreenKt$SocialLinkRow$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(WelcomeScreenKt.SocialLinkRow$lambda$6(stateAnimateFloatAsState));
                        graphicsLayer.setScaleY(WelcomeScreenKt.SocialLinkRow$lambda$6(stateAnimateFloatAsState));
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.m869paddingVpY3zN4(ClickableKt.m484clickableO2vRcR0(GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxWidth$default, (Function1) value$iv2), interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, function0), C1979Dp.m6801constructorimpl(16), C1979Dp.m6801constructorimpl(14));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
                function1 = constructor;
                $composer2.createNode(function1);
            } else {
                function1 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$SocialLinkRow_u24lambda_u2410 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 32889477, "C263@9588L478,278@10076L602,300@10816L11,297@10688L211:WelcomeScreen.kt#hmxj0r");
            Modifier modifier$iv2 = ClipKt.clip(NeuMorphismKt.m7657neuInsetFgKr3fQ(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(34)), C1979Dp.m6801constructorimpl(11), (12 & 2) != 0 ? C1979Dp.m6801constructorimpl(6) : C1979Dp.m6801constructorimpl(3), (12 & 4) != 0 ? Neu.INSTANCE.m7650getInsetFill0d7_KjU() : 0L, (12 & 8) != 0), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(11)));
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function2 = constructor2;
                $composer2.createNode(function2);
            } else {
                function2 = constructor2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -306656224, "C273@9965L11,270@9838L218:WelcomeScreen.kt#hmxj0r");
            IconKt.m2292Iconww6aTOc(link.getIcon(), (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(17)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), $composer2, 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default(RowScope.CC.weight$default($this$SocialLinkRow_u24lambda_u2410, Modifier.INSTANCE, 1.0f, false, 2, null), C1979Dp.m6801constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function3 = constructor3;
                $composer2.createNode(function3);
            } else {
                function3 = constructor3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -306655854, "C285@10287L10,286@10347L11,283@10208L174,290@10486L10,291@10546L11,288@10395L273:WelcomeScreen.kt#hmxj0r");
            TextKt.m2817Text4IGK_g(link.getLabel(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodyLarge(), $composer2, 0, 0, 65530);
            TextKt.m2817Text4IGK_g(displayHost(link.getUrl()), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6708getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodySmall(), $composer2, 0, 3120, 55290);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.m2292Iconww6aTOc(OpenInNewKt.getOpenInNew(Icons.Filled.INSTANCE), (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(16)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), $composer2, 432, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeScreenKt.SocialLinkRow.3
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
                    WelcomeScreenKt.SocialLinkRow(link, function0, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final boolean SocialLinkRow$lambda$5(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SocialLinkRow$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ContinueButton(final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Modifier modifierM465borderxT4_qwU;
        Function0<ComposeUiNode> function1;
        Composer $composer2 = $composer.startRestartGroup(1216056348);
        ComposerKt.sourceInformation($composer2, "C(ContinueButton)308@10999L39,309@11078L25,310@11126L148,320@11395L87,316@11280L1857:WelcomeScreen.kt#hmxj0r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1216056348, $dirty2, -1, "com.videshkarmakar.loop.ui.page.ContinueButton (WelcomeScreen.kt:307)");
            }
            $composer2.startReplaceGroup(-162933797);
            ComposerKt.sourceInformation($composer2, "CC(remember):WelcomeScreen.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableInteractionSource interactionSource = (MutableInteractionSource) value$iv;
            $composer2.endReplaceGroup();
            State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, $composer2, 6);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(ContinueButton$lambda$12(stateCollectIsPressedAsState) ? 0.97f : 1.0f, RowPressSpec, 0.0f, "continuePress", null, $composer2, 3120, 20);
            Modifier modifierM899height3ABfNKs = SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1979Dp.m6801constructorimpl(54));
            $composer2.startReplaceGroup(-162933401);
            ComposerKt.sourceInformation($composer2, "CC(remember):WelcomeScreen.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(stateAnimateFloatAsState);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeScreenKt$ContinueButton$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.setScaleX(WelcomeScreenKt.ContinueButton$lambda$13(stateAnimateFloatAsState));
                        graphicsLayer.setScaleY(WelcomeScreenKt.ContinueButton$lambda$13(stateAnimateFloatAsState));
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierM899height3ABfNKs, (Function1) value$iv2);
            $composer2.startReplaceGroup(-162933278);
            ComposerKt.sourceInformation($composer2, "337@11999L11,341@12182L11");
            if (ContinueButton$lambda$12(stateCollectIsPressedAsState)) {
                modifierM465borderxT4_qwU = NeuMorphismKt.m7660neuPressedB2jEHPA(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18), C1979Dp.m6801constructorimpl(6), Neu.INSTANCE.m7650getInsetFill0d7_KjU());
            } else {
                modifierM465borderxT4_qwU = BorderKt.m465borderxT4_qwU(NeuMorphismKt.m7662neuRaisedwkf6fSU(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18), (4 & 2) != 0 ? C1979Dp.m6801constructorimpl(8) : C1979Dp.m6801constructorimpl(6), (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? Neu.INSTANCE.m7647getBase0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceContainerLow()), C1979Dp.m6801constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOutlineVariant(), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(18)));
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = ClickableKt.m484clickableO2vRcR0(ClipKt.clip(modifierGraphicsLayer.then(modifierM465borderxT4_qwU), RoundedCornerShapeKt.m1146RoundedCornerShape0680j_4(C1979Dp.m6801constructorimpl(18))), interactionSource, null, (8 & 4) != 0, (8 & 8) != 0 ? null : null, (8 & 16) != 0 ? null : null, function0);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
                function1 = constructor;
                $composer2.createNode(function1);
            } else {
                function1 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -222910854, "C357@12732L10,359@12836L11,355@12661L206,361@12876L39,365@13055L11,362@12924L207:WelcomeScreen.kt#hmxj0r");
            TextKt.m2817Text4IGK_g("Continue", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium(), $composer2, 196614, 0, 65498);
            SpacerKt.Spacer(SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(10)), $composer2, 6);
            IconKt.m2292Iconww6aTOc(ArrowForwardKt.getArrowForward(Icons.Filled.INSTANCE), (String) null, SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface(), $composer2, 432, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.WelcomeScreenKt.ContinueButton.3
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
                    WelcomeScreenKt.ContinueButton(function0, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final boolean ContinueButton$lambda$12(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ContinueButton$lambda$13(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }
}
