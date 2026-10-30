package com.videshkarmakar.loop.p006ui.common;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.InspectionModeKt;
import androidx.compose.p001ui.res.PainterResources_androidKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.IntSize;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import coil.Coil;
import coil.compose.AsyncImageKt;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.kyant.monet.MonetKt;
import com.kyant.monet.TonalPalettes;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.SVGStringKt;
import com.videshkarmakar.loop.util.DarkThemePreference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AsyncImageImpl.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(m194d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a\u009a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a¤\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!²\u0006\n\u0010\"\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002"}, m195d2 = {"AsyncImageImpl", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "isPreview", "", "AsyncImageImpl-10Xjiaw", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "SVGImage", "SVGString", "tonalPalettes", "Lcom/kyant/monet/TonalPalettes;", "isDarkTheme", "SVGImage-gl8XCv8", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILcom/kyant/monet/TonalPalettes;ZLandroidx/compose/runtime/Composer;III)V", "app_debug", "size", "Landroidx/compose/ui/unit/IntSize;", "pi", "Landroid/graphics/drawable/PictureDrawable;"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AsyncImageImplKt {
    /* JADX INFO: renamed from: SVGImage-gl8XCv8, reason: not valid java name */
    public static final void m7234SVGImagegl8XCv8(final String SVGString, final String contentDescription, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, TonalPalettes tonalPalettes, boolean isDarkTheme, Composer $composer, final int $changed, final int $changed1, final int i) throws SVGParseException {
        Modifier modifier2;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function3;
        Alignment alignment2;
        Modifier.Companion modifier3;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform;
        Function1<? super AsyncImagePainter.State, Unit> function4;
        Alignment alignment3;
        ContentScale contentScale2;
        float alpha2;
        int filterQuality2;
        TonalPalettes tonalPalettes2;
        ColorFilter colorFilter2;
        int $dirty;
        TonalPalettes tonalPalettes3;
        int $dirty1;
        boolean isDarkTheme2;
        Object value$iv;
        final ContentScale contentScale3;
        final Alignment alignment4;
        Object value$iv2;
        Object value$iv3;
        Function0<ComposeUiNode> function0;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function5;
        Function1<? super AsyncImagePainter.State, Unit> function6;
        boolean isDarkTheme3;
        int $dirty2;
        ColorFilter colorFilter3;
        Intrinsics.checkNotNullParameter(SVGString, "SVGString");
        Composer $composer2 = $composer.startRestartGroup(-507411804);
        ComposerKt.sourceInformation($composer2, "C(SVGImage)P(!1,4,8,11,9!1,5!2,6:c#ui.graphics.FilterQuality,10)51@2203L7,52@2254L7,52@2262L13,55@2369L7,56@2444L41,58@2501L397,74@3042L115,70@2903L632:AsyncImageImpl.kt#x6o9ax");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(SVGString) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer2.changed(contentDescription) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                function3 = function1;
                int i3 = $composer2.changedInstance(function3) ? 2048 : 1024;
                $dirty3 |= i3;
            } else {
                function3 = function1;
            }
            $dirty3 |= i3;
        } else {
            function3 = function1;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            alignment2 = alignment;
        } else if (($changed & 458752) == 0) {
            alignment2 = alignment;
            $dirty3 |= $composer2.changed(alignment2) ? 131072 : 65536;
        } else {
            alignment2 = alignment;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer2.changed(contentScale) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer2.changed(alpha) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer2.changed(colorFilter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            $dirty3 |= ((i & 512) == 0 && $composer2.changed(filterQuality)) ? 536870912 : 268435456;
        }
        if (($changed1 & 14) == 0) {
            $dirty4 |= ((i & 1024) == 0 && $composer2.changed(tonalPalettes)) ? 4 : 2;
        }
        if (($changed1 & 112) == 0) {
            $dirty4 |= ((i & 2048) == 0 && $composer2.changed(isDarkTheme)) ? 32 : 16;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty4 & 91) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function6 = function2;
            contentScale3 = contentScale;
            alpha2 = alpha;
            colorFilter3 = colorFilter;
            $dirty2 = filterQuality;
            tonalPalettes3 = tonalPalettes;
            isDarkTheme3 = isDarkTheme;
            alignment4 = alignment2;
            modifier3 = modifier2;
            function5 = function3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 8) != 0) {
                    defaultTransform = AsyncImagePainter.INSTANCE.getDefaultTransform();
                    $dirty3 &= -7169;
                } else {
                    defaultTransform = function3;
                }
                function4 = i4 != 0 ? null : function2;
                alignment3 = i5 != 0 ? Alignment.INSTANCE.getCenter() : alignment;
                contentScale2 = i6 != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
                alpha2 = i7 != 0 ? 1.0f : alpha;
                ColorFilter colorFilter4 = i8 != 0 ? null : colorFilter;
                if ((i & 512) != 0) {
                    filterQuality2 = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
                    $dirty3 &= -1879048193;
                } else {
                    filterQuality2 = filterQuality;
                }
                ColorFilter colorFilter5 = colorFilter4;
                if ((i & 1024) != 0) {
                    ProvidableCompositionLocal<TonalPalettes> localTonalPalettes = MonetKt.getLocalTonalPalettes();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localTonalPalettes);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    tonalPalettes2 = (TonalPalettes) objConsume;
                    $dirty4 &= -15;
                } else {
                    tonalPalettes2 = tonalPalettes;
                }
                if ((i & 2048) != 0) {
                    ProvidableCompositionLocal<DarkThemePreference> localDarkTheme = CompositionLocalsKt.getLocalDarkTheme();
                    TonalPalettes tonalPalettes4 = tonalPalettes2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localDarkTheme);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i9 = $dirty4 & (-113);
                    $dirty = $dirty3;
                    isDarkTheme2 = ((DarkThemePreference) objConsume2).isDarkTheme($composer2, 0);
                    $dirty1 = i9;
                    colorFilter2 = colorFilter5;
                    tonalPalettes3 = tonalPalettes4;
                } else {
                    TonalPalettes tonalPalettes5 = tonalPalettes2;
                    colorFilter2 = colorFilter5;
                    $dirty = $dirty3;
                    tonalPalettes3 = tonalPalettes5;
                    $dirty1 = $dirty4;
                    isDarkTheme2 = isDarkTheme;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 512) != 0) {
                    $dirty3 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty4 &= -15;
                }
                if ((i & 2048) != 0) {
                    int i10 = $dirty4 & (-113);
                    contentScale2 = contentScale;
                    alpha2 = alpha;
                    filterQuality2 = filterQuality;
                    isDarkTheme2 = isDarkTheme;
                    $dirty1 = i10;
                    $dirty = $dirty3;
                    modifier3 = modifier2;
                    defaultTransform = function3;
                    function4 = function2;
                    alignment3 = alignment;
                    colorFilter2 = colorFilter;
                    tonalPalettes3 = tonalPalettes;
                } else {
                    contentScale2 = contentScale;
                    alpha2 = alpha;
                    colorFilter2 = colorFilter;
                    filterQuality2 = filterQuality;
                    $dirty = $dirty3;
                    $dirty1 = $dirty4;
                    modifier3 = modifier2;
                    defaultTransform = function3;
                    function4 = function2;
                    alignment3 = alignment;
                    tonalPalettes3 = tonalPalettes;
                    isDarkTheme2 = isDarkTheme;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-507411804, $dirty, $dirty1, "com.videshkarmakar.loop.ui.common.SVGImage (AsyncImageImpl.kt:53)");
            }
            ProvidableCompositionLocal<WindowWidthSizeClass> localWindowWidthState = CompositionLocalsKt.getLocalWindowWidthState();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localWindowWidthState);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PaddingValues horizontalPadding = PaddingKt.m863PaddingValuesYgX7TsA$default(!WindowWidthSizeClass.m3739equalsimpl0(((WindowWidthSizeClass) objConsume3).getValue(), WindowWidthSizeClass.INSTANCE.m3747getCompactY0FxcvE()) ? C1979Dp.m6801constructorimpl(100) : C1979Dp.m6801constructorimpl(0), 0.0f, 2, null);
            $composer2.startReplaceGroup(1163945646);
            ComposerKt.sourceInformation($composer2, "CC(remember):AsyncImageImpl.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            final ColorFilter colorFilter6 = colorFilter2;
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6967boximpl(IntSize.INSTANCE.m6980getZeroYbymL2g()), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState size$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            ContentScale contentScale4 = contentScale2;
            long jSVGImage_gl8XCv8$lambda$1 = SVGImage_gl8XCv8$lambda$1(size$delegate);
            $composer2.startReplaceGroup(1163945703);
            ComposerKt.sourceInformation($composer2, "CC(remember):AsyncImageImpl.kt#9igjgp");
            contentScale3 = contentScale4;
            alignment4 = alignment3;
            boolean invalid$iv = (((($dirty1 & 14) ^ 6) > 4 && $composer2.changed(tonalPalettes3)) || ($dirty1 & 6) == 4) | (((($dirty1 & 112) ^ 48) > 32 && $composer2.changed(isDarkTheme2)) || ($dirty1 & 48) == 32) | $composer2.changed(jSVGImage_gl8XCv8$lambda$1);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                SVG fromString = SVG.getFromString(SVGStringKt.parseDynamicColor(SVGString, tonalPalettes3, isDarkTheme2));
                int iM6975getWidthimpl = IntSize.m6975getWidthimpl(SVGImage_gl8XCv8$lambda$1(size$delegate));
                int $i$f$cache = IntSize.m6974getHeightimpl(SVGImage_gl8XCv8$lambda$1(size$delegate));
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PictureDrawable(fromString.renderToPicture(iM6975getWidthimpl, $i$f$cache)), null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableState pi$delegate = (MutableState) value$iv2;
            $composer2.endReplaceGroup();
            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(PaddingKt.padding(modifier3, horizontalPadding), 1.38f, false, 2, null);
            $composer2.startReplaceGroup(1163946244);
            ComposerKt.sourceInformation($composer2, "CC(remember):AsyncImageImpl.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.videshkarmakar.loop.ui.common.AsyncImageImplKt$SVGImage$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (!IntSize.m6973equalsimpl0(it.mo5646getSizeYbymL2g(), IntSize.INSTANCE.m6980getZeroYbymL2g())) {
                            AsyncImageImplKt.SVGImage_gl8XCv8$lambda$2(size$delegate, it.mo5646getSizeYbymL2g());
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierAspectRatio$default, (Function1) value$iv3);
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
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
            int i11 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i12 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 890947754, "C80@3203L326,80@3175L354:AsyncImageImpl.kt#x6o9ax");
            final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function7 = defaultTransform;
            final Function1<? super AsyncImagePainter.State, Unit> function8 = function4;
            final float f = alpha2;
            final int i13 = filterQuality2;
            function5 = defaultTransform;
            CrossfadeKt.Crossfade(SVGImage_gl8XCv8$lambda$4(pi$delegate), (Modifier) null, (FiniteAnimationSpec<Float>) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1696062221, true, new Function3<PictureDrawable, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.common.AsyncImageImplKt$SVGImage$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PictureDrawable pictureDrawable, Composer composer, Integer num) {
                    invoke(pictureDrawable, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PictureDrawable it, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer3, "C81@3217L302:AsyncImageImpl.kt#x6o9ax");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1696062221, $changed2, -1, "com.videshkarmakar.loop.ui.common.SVGImage.<anonymous>.<anonymous> (AsyncImageImpl.kt:81)");
                    }
                    AsyncImageImplKt.m7233AsyncImageImpl10Xjiaw(it, contentDescription, Modifier.INSTANCE, function7, function8, alignment4, contentScale3, f, colorFilter6, i13, false, $composer3, 392, 0, 1024);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 24584, 14);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function4;
            isDarkTheme3 = isDarkTheme2;
            $dirty2 = filterQuality2;
            colorFilter3 = colorFilter6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function9 = function5;
            final Function1<? super AsyncImagePainter.State, Unit> function10 = function6;
            final Alignment alignment5 = alignment4;
            final ContentScale contentScale5 = contentScale3;
            final float f2 = alpha2;
            final ColorFilter colorFilter7 = colorFilter3;
            final int i14 = $dirty2;
            final TonalPalettes tonalPalettes6 = tonalPalettes3;
            final boolean z = isDarkTheme3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.common.AsyncImageImplKt$SVGImage$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws SVGParseException {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i15) throws SVGParseException {
                    AsyncImageImplKt.m7234SVGImagegl8XCv8(SVGString, contentDescription, modifier4, function9, function10, alignment5, contentScale5, f2, colorFilter7, i14, tonalPalettes6, z, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    private static final long SVGImage_gl8XCv8$lambda$1(MutableState<IntSize> mutableState) {
        MutableState<IntSize> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SVGImage_gl8XCv8$lambda$2(MutableState<IntSize> mutableState, long value) {
        mutableState.setValue(IntSize.m6967boximpl(value));
    }

    private static final PictureDrawable SVGImage_gl8XCv8$lambda$4(MutableState<PictureDrawable> mutableState) {
        MutableState<PictureDrawable> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: renamed from: AsyncImageImpl-10Xjiaw, reason: not valid java name */
    public static final void m7233AsyncImageImpl10Xjiaw(final Object model, final String contentDescription, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, boolean isPreview, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform;
        Function1<? super AsyncImagePainter.State, Unit> function3;
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha2;
        ColorFilter colorFilter2;
        int filterQuality2;
        int $dirty;
        boolean isPreview2;
        int $dirty1;
        Intrinsics.checkNotNullParameter(model, "model");
        Composer $composer2 = $composer.startRestartGroup(-788231107);
        ComposerKt.sourceInformation($composer2, "C(AsyncImageImpl)P(7,3,8,10,9!1,4!2,5:c#ui.graphics.FilterQuality)110@4099L7:AsyncImageImpl.kt#x6o9ax");
        int $dirty2 = $changed;
        if ((i & 4) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) == 0) {
            defaultTransform = function1;
        } else {
            $dirty2 &= -7169;
            defaultTransform = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        if ((i & 16) == 0) {
            function3 = function2;
        } else {
            function3 = null;
        }
        if ((i & 32) == 0) {
            alignment2 = alignment;
        } else {
            alignment2 = Alignment.INSTANCE.getCenter();
        }
        if ((i & 64) == 0) {
            contentScale2 = contentScale;
        } else {
            contentScale2 = ContentScale.INSTANCE.getFit();
        }
        if ((i & 128) == 0) {
            alpha2 = alpha;
        } else {
            alpha2 = 1.0f;
        }
        if ((i & 256) == 0) {
            colorFilter2 = colorFilter;
        } else {
            colorFilter2 = null;
        }
        if ((i & 512) == 0) {
            filterQuality2 = filterQuality;
            $dirty = $dirty2;
        } else {
            int filterQuality3 = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
            $dirty = $dirty2 & (-1879048193);
            filterQuality2 = filterQuality3;
        }
        if ((i & 1024) == 0) {
            isPreview2 = isPreview;
            $dirty1 = $changed1;
        } else {
            ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localInspectionMode);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean isPreview3 = ((Boolean) objConsume).booleanValue();
            int $dirty3 = $changed1 & (-15);
            isPreview2 = isPreview3;
            $dirty1 = $dirty3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-788231107, $dirty, $dirty1, "com.videshkarmakar.loop.ui.common.AsyncImageImpl (AsyncImageImpl.kt:111)");
        }
        if (isPreview2) {
            $composer2.startReplaceGroup(2045289948);
            ComposerKt.sourceInformation($composer2, "113@4155L34,112@4130L270");
            ImageKt.Image(PainterResources_androidKt.painterResource(C3070R.drawable.sample, $composer2, 0), contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, $composer2, (3670016 & ($dirty >> 6)) | (458752 & ($dirty >> 6)) | (57344 & ($dirty >> 6)) | ($dirty & 112) | 8 | ($dirty & 896) | (($dirty >> 6) & 7168), 0);
            $composer2.endReplaceGroup();
        } else {
            $composer2.startReplaceGroup(2045290241);
            ComposerKt.sourceInformation($composer2, "122@4485L7,*124@4615L7,121@4423L469");
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ImageRequest imageRequestBuild = new ImageRequest.Builder((Context) objConsume2).data(model).crossfade(true).build();
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Context $this$imageLoader$iv = (Context) objConsume3;
            AsyncImageKt.m7124AsyncImageMvsnxeU(imageRequestBuild, contentDescription, Coil.imageLoader($this$imageLoader$iv), modifier2, defaultTransform, function3, alignment2, contentScale2, alpha2, colorFilter2, filterQuality2, $composer2, (3670016 & ($dirty << 3)) | (458752 & ($dirty << 3)) | (57344 & ($dirty << 3)) | ($dirty & 112) | 520 | (($dirty << 3) & 7168) | (($dirty << 3) & 29360128) | (($dirty << 3) & 234881024) | (1879048192 & ($dirty << 3)), ($dirty >> 27) & 14, 0);
            $composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function4 = defaultTransform;
            final Function1<? super AsyncImagePainter.State, Unit> function5 = function3;
            final Alignment alignment3 = alignment2;
            final ContentScale contentScale3 = contentScale2;
            final float f = alpha2;
            final ColorFilter colorFilter3 = colorFilter2;
            final int i2 = filterQuality2;
            final boolean z = isPreview2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.common.AsyncImageImplKt$AsyncImageImpl$1
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
                    AsyncImageImplKt.m7233AsyncImageImpl10Xjiaw(model, contentDescription, modifier3, function4, function5, alignment3, contentScale3, f, colorFilter3, i2, z, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
