package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: compiled from: VectorPainter.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010$\u001a\u0096\u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a \u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u0002012@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00100\u001a\u000201H\u0000ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u00192\u0006\u0010:\u001a\u00020\u0005H\u0000\u001a&\u0010;\u001a\u00020\u0003*\u00020<2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00030>¢\u0006\u0002\b?H\u0082\b\u001a&\u0010@\u001a\u00020\u001b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createVectorPainterFromImageVector", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "density", "Landroidx/compose/ui/unit/Density;", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "obtainViewportSize", "Landroidx/compose/ui/geometry/Size;", "defaultSize", "viewportWidth", "", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "rememberVectorPainter", "image", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "name", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createGroupComponent", "currentGroup", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* JADX INFO: renamed from: rememberVectorPainter-mlNsNFs, reason: not valid java name */
    public static final VectorPainter m4775rememberVectorPaintermlNsNFs(float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, String name, long tintColor, int tintBlendMode, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -964365210, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)86@3732L207:VectorPainter.kt#huu6hf");
        float viewportWidth2 = (i & 4) != 0 ? Float.NaN : viewportWidth;
        float viewportHeight2 = (i & 8) != 0 ? Float.NaN : viewportHeight;
        String name2 = (i & 16) != 0 ? RootGroupName : name;
        long tintColor2 = (i & 32) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : tintColor;
        int tintBlendMode2 = (i & 64) != 0 ? BlendMode.INSTANCE.m3983getSrcIn0nO6VwU() : tintBlendMode;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:86)");
        }
        VectorPainter vectorPainterM4776rememberVectorPaintervIP8VLU = m4776rememberVectorPaintervIP8VLU(defaultWidth, defaultHeight, viewportWidth2, viewportHeight2, name2, tintColor2, tintBlendMode2, false, function4, $composer, ($changed & 14) | 12582912 | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (($changed << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return vectorPainterM4776rememberVectorPaintervIP8VLU;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0222  */
    /* JADX WARN: Code duplicated, block: B:65:0x0173 A[PHI: r0
  0x0173: PHI (r0v16 float) = (r0v5 float), (r0v17 float) binds: [B:64:0x0171, B:60:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x018d  */
    /* JADX WARN: Code duplicated, block: B:76:0x018f  */
    /* JADX WARN: Code duplicated, block: B:79:0x019b  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a9 A[PHI: r11
  0x01a9: PHI (r11v13 kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
  (r11v11 kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
  (r11v14 kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
 binds: [B:84:0x01a7, B:80:0x01a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:94:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d7  */
    /* JADX INFO: renamed from: rememberVectorPainter-vIP8VLU, reason: not valid java name */
    public static final VectorPainter m4776rememberVectorPaintervIP8VLU(float f, float f2, float f3, float f4, String str, long j, int i, boolean z, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        Object objM4772createColorFilterxETnrds;
        float f5;
        boolean z2;
        boolean z3;
        final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function5;
        boolean z4;
        Composition composition;
        Composition Composition;
        Object obj;
        ComposerKt.sourceInformationMarkerStart(composer, 1068590786, "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)129@5517L7,132@5710L94:VectorPainter.kt#huu6hf");
        float f6 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f7 = (i3 & 8) != 0 ? Float.NaN : f4;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long jM4079getUnspecified0d7_KjU = (i3 & 32) != 0 ? Color.INSTANCE.m4079getUnspecified0d7_KjU() : j;
        int iM3983getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.INSTANCE.m3983getSrcIn0nO6VwU() : i;
        boolean z5 = (i3 & 128) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068590786, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:128)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM4773obtainSizePxVpY3zN4 = m4773obtainSizePxVpY3zN4((Density) objConsume, f, f2);
        boolean z6 = z5;
        final long jM4774obtainViewportSizePq9zytI = m4774obtainViewportSizePq9zytI(jM4773obtainSizePxVpY3zN4, f6, f7);
        ComposerKt.sourceInformationMarkerStart(composer, -1998937644, "CC(remember):VectorPainter.kt#9igjgp");
        float f8 = f7;
        boolean z7 = ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(jM4079getUnspecified0d7_KjU)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | ((((3670016 & i2) ^ 1572864) > 1048576 && composer.changed(iM3983getSrcIn0nO6VwU)) || (i2 & 1572864) == 1048576);
        Object objRememberedValue = composer.rememberedValue();
        if (z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objM4772createColorFilterxETnrds = m4772createColorFilterxETnrds(jM4079getUnspecified0d7_KjU, iM3983getSrcIn0nO6VwU);
            composer.updateRememberedValue(objM4772createColorFilterxETnrds);
        } else {
            objM4772createColorFilterxETnrds = objRememberedValue;
        }
        ColorFilter colorFilter = (ColorFilter) objM4772createColorFilterxETnrds;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(-1998937509);
        ComposerKt.sourceInformation(composer, "*135@5816L28,143@6122L28,144@6178L487");
        ComposerKt.sourceInformationMarkerStart(composer, -1998937538, "CC(remember):VectorPainter.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new VectorPainter(null, 1, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        float f9 = f6;
        m4770configureVectorPainterT4PVSW8(vectorPainter, jM4773obtainSizePxVpY3zN4, jM4774obtainViewportSizePq9zytI, str2, colorFilter, z6);
        CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -940667703, "CC(remember):VectorPainter.kt#9igjgp");
        if (((i2 & 896) ^ 384) > 256) {
            f5 = f9;
            if (composer.changed(f5)) {
                z2 = true;
            }
            if (((i2 & 7168) ^ 3072) <= 2048 && composer.changed(f8)) {
                z3 = true;
            } else if ((i2 & 3072) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z8 = z2 | z3;
            if (((234881024 & i2) ^ 100663296) > 67108864) {
                function5 = function4;
                if (!composer.changed(function5)) {
                }
                z4 = z | z8;
                Object objRememberedValue3 = composer.rememberedValue();
                if (!z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    composition = vectorPainter.getComposition();
                    if (composition != null || composition.getDisposed()) {
                        Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                    } else {
                        Composition = composition;
                    }
                    Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer, int $changed) {
                            ComposerKt.sourceInformation($composer, "C155@6584L40:VectorPainter.kt#huu6hf");
                            if (($changed & 3) == 2 && $composer.getSkipping()) {
                                $composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-824421385, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:155)");
                            }
                            function5.invoke(Float.valueOf(Size.m3870getWidthimpl(jM4774obtainViewportSizePq9zytI)), Float.valueOf(Size.m3867getHeightimpl(jM4774obtainViewportSizePq9zytI)), $composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    composer.updateRememberedValue(Composition);
                    obj = Composition;
                } else {
                    obj = objRememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                vectorPainter.setComposition$ui_release((Composition) obj);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return vectorPainter;
            }
            function5 = function4;
            boolean z9 = (100663296 & i2) == 67108864;
            z4 = z9 | z8;
            Object objRememberedValue4 = composer.rememberedValue();
            if (z4) {
                composition = vectorPainter.getComposition();
                if (composition != null) {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                } else {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                }
                Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C155@6584L40:VectorPainter.kt#huu6hf");
                        if (($changed & 3) == 2 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-824421385, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:155)");
                        }
                        function5.invoke(Float.valueOf(Size.m3870getWidthimpl(jM4774obtainViewportSizePq9zytI)), Float.valueOf(Size.m3867getHeightimpl(jM4774obtainViewportSizePq9zytI)), $composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composer.updateRememberedValue(Composition);
                obj = Composition;
            } else {
                composition = vectorPainter.getComposition();
                if (composition != null) {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                } else {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                }
                Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C155@6584L40:VectorPainter.kt#huu6hf");
                        if (($changed & 3) == 2 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-824421385, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:155)");
                        }
                        function5.invoke(Float.valueOf(Size.m3870getWidthimpl(jM4774obtainViewportSizePq9zytI)), Float.valueOf(Size.m3867getHeightimpl(jM4774obtainViewportSizePq9zytI)), $composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composer.updateRememberedValue(Composition);
                obj = Composition;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            vectorPainter.setComposition$ui_release((Composition) obj);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return vectorPainter;
        }
        f5 = f9;
        if ((i2 & 384) == 256) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (((i2 & 7168) ^ 3072) <= 2048) {
        }
        if ((i2 & 3072) == 2048) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z10 = z2 | z3;
        if (((234881024 & i2) ^ 100663296) > 67108864) {
            function5 = function4;
            if (!composer.changed(function5)) {
            }
            z4 = z9 | z10;
            Object objRememberedValue5 = composer.rememberedValue();
            if (z4) {
                composition = vectorPainter.getComposition();
                if (composition != null) {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                } else {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                }
                Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C155@6584L40:VectorPainter.kt#huu6hf");
                        if (($changed & 3) == 2 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-824421385, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:155)");
                        }
                        function5.invoke(Float.valueOf(Size.m3870getWidthimpl(jM4774obtainViewportSizePq9zytI)), Float.valueOf(Size.m3867getHeightimpl(jM4774obtainViewportSizePq9zytI)), $composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composer.updateRememberedValue(Composition);
                obj = Composition;
            } else {
                composition = vectorPainter.getComposition();
                if (composition != null) {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                } else {
                    Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
                }
                Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C155@6584L40:VectorPainter.kt#huu6hf");
                        if (($changed & 3) == 2 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-824421385, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:155)");
                        }
                        function5.invoke(Float.valueOf(Size.m3870getWidthimpl(jM4774obtainViewportSizePq9zytI)), Float.valueOf(Size.m3867getHeightimpl(jM4774obtainViewportSizePq9zytI)), $composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composer.updateRememberedValue(Composition);
                obj = Composition;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            vectorPainter.setComposition$ui_release((Composition) obj);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return vectorPainter;
        }
        function5 = function4;
        if ((100663296 & i2) == 67108864) {
        }
        z4 = z9 | z10;
        Object objRememberedValue6 = composer.rememberedValue();
        if (z4) {
            composition = vectorPainter.getComposition();
            if (composition != null) {
                Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
            } else {
                Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
            }
            Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C155@6584L40:VectorPainter.kt#huu6hf");
                    if (($changed & 3) == 2 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-824421385, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:155)");
                    }
                    function5.invoke(Float.valueOf(Size.m3870getWidthimpl(jM4774obtainViewportSizePq9zytI)), Float.valueOf(Size.m3867getHeightimpl(jM4774obtainViewportSizePq9zytI)), $composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            composer.updateRememberedValue(Composition);
            obj = Composition;
        } else {
            composition = vectorPainter.getComposition();
            if (composition != null) {
                Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
            } else {
                Composition = CompositionKt.Composition(new VectorApplier(vectorPainter.getVector().getRoot()), compositionContextRememberCompositionContext);
            }
            Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-824421385, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C155@6584L40:VectorPainter.kt#huu6hf");
                    if (($changed & 3) == 2 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-824421385, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:155)");
                    }
                    function5.invoke(Float.valueOf(Size.m3870getWidthimpl(jM4774obtainViewportSizePq9zytI)), Float.valueOf(Size.m3867getHeightimpl(jM4774obtainViewportSizePq9zytI)), $composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            composer.updateRememberedValue(Composition);
            obj = Composition;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        vectorPainter.setComposition$ui_release((Composition) obj);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vectorPainter;
    }

    public static final VectorPainter rememberVectorPainter(ImageVector image, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1413834416, "C(rememberVectorPainter)170@7032L7,172@7116L215:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:169)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) objConsume;
        float val1$iv = image.getGenId();
        float val2$iv = density.getDensity();
        long v1$iv = Float.floatToRawIntBits(val1$iv);
        long v2$iv = Float.floatToRawIntBits(val2$iv);
        long key = (v1$iv << 32) | (4294967295L & v2$iv);
        ComposerKt.sourceInformationMarkerStart($composer, -1998936238, "CC(remember):VectorPainter.kt#9igjgp");
        boolean invalid$iv = $composer.changed(key);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            GroupComponent $this$rememberVectorPainter_u24lambda_u245_u24lambda_u244 = new GroupComponent();
            createGroupComponent($this$rememberVectorPainter_u24lambda_u245_u24lambda_u244, image.getRoot());
            Unit unit = Unit.INSTANCE;
            value$iv = createVectorPainterFromImageVector(density, image, $this$rememberVectorPainter_u24lambda_u245_u24lambda_u244);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        VectorPainter vectorPainter = (VectorPainter) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return vectorPainter;
    }

    private static final void mirror(DrawScope $this$mirror, Function1<? super DrawScope, Unit> function1) throws Throwable {
        long pivot$iv = $this$mirror.mo4524getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$mirror.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4531getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        try {
            DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
            $this$scale_Fgt4K4Q_u24lambda_u242$iv.mo4538scale0AR0LA0(-1.0f, 1.0f, pivot$iv);
            try {
                function1.invoke($this$mirror);
                InlineMarker.finallyStart(1);
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv$iv.mo4532setSizeuvyYCjk(previousSize$iv$iv);
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                th = th;
                InlineMarker.finallyStart(1);
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv$iv.mo4532setSizeuvyYCjk(previousSize$iv$iv);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: obtainSizePx-VpY3zN4, reason: not valid java name */
    private static final long m4773obtainSizePxVpY3zN4(Density $this$obtainSizePx_u2dVpY3zN4, float defaultWidth, float defaultHeight) {
        return SizeKt.Size($this$obtainSizePx_u2dVpY3zN4.mo319toPx0680j_4(defaultWidth), $this$obtainSizePx_u2dVpY3zN4.mo319toPx0680j_4(defaultHeight));
    }

    /* JADX INFO: renamed from: obtainViewportSize-Pq9zytI, reason: not valid java name */
    private static final long m4774obtainViewportSizePq9zytI(long defaultSize, float viewportWidth, float viewportHeight) {
        return SizeKt.Size(Float.isNaN(viewportWidth) ? Size.m3870getWidthimpl(defaultSize) : viewportWidth, Float.isNaN(viewportHeight) ? Size.m3867getHeightimpl(defaultSize) : viewportHeight);
    }

    /* JADX INFO: renamed from: createColorFilter-xETnrds, reason: not valid java name */
    private static final ColorFilter m4772createColorFilterxETnrds(long tintColor, int tintBlendMode) {
        if (tintColor != 16) {
            return ColorFilter.INSTANCE.m4087tintxETnrds(tintColor, tintBlendMode);
        }
        return null;
    }

    /* JADX INFO: renamed from: configureVectorPainter-T4PVSW8$default, reason: not valid java name */
    public static /* synthetic */ VectorPainter m4771configureVectorPainterT4PVSW8$default(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z, int i, Object obj) {
        String str2;
        if ((i & 4) == 0) {
            str2 = str;
        } else {
            str2 = RootGroupName;
        }
        return m4770configureVectorPainterT4PVSW8(vectorPainter, j, j2, str2, colorFilter, (i & 16) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: configureVectorPainter-T4PVSW8, reason: not valid java name */
    public static final VectorPainter m4770configureVectorPainterT4PVSW8(VectorPainter $this$configureVectorPainter_u2dT4PVSW8, long defaultSize, long viewportSize, String name, ColorFilter intrinsicColorFilter, boolean autoMirror) {
        $this$configureVectorPainter_u2dT4PVSW8.m4768setSizeuvyYCjk$ui_release(defaultSize);
        $this$configureVectorPainter_u2dT4PVSW8.setAutoMirror$ui_release(autoMirror);
        $this$configureVectorPainter_u2dT4PVSW8.setIntrinsicColorFilter$ui_release(intrinsicColorFilter);
        $this$configureVectorPainter_u2dT4PVSW8.m4769setViewportSizeuvyYCjk$ui_release(viewportSize);
        $this$configureVectorPainter_u2dT4PVSW8.setName$ui_release(name);
        return $this$configureVectorPainter_u2dT4PVSW8;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density density, ImageVector imageVector, GroupComponent root) {
        long defaultSize = m4773obtainSizePxVpY3zN4(density, imageVector.getDefaultWidth(), imageVector.getDefaultHeight());
        long viewport = m4774obtainViewportSizePq9zytI(defaultSize, imageVector.getViewportWidth(), imageVector.getViewportHeight());
        return m4770configureVectorPainterT4PVSW8(new VectorPainter(root), defaultSize, viewport, imageVector.getName(), m4772createColorFilterxETnrds(imageVector.getTintColor(), imageVector.getTintBlendMode()), imageVector.getAutoMirror());
    }

    public static final GroupComponent createGroupComponent(GroupComponent $this$createGroupComponent, VectorGroup currentGroup) {
        int size = currentGroup.getSize();
        for (int index = 0; index < size; index++) {
            VectorNode vectorNode = currentGroup.get(index);
            if (vectorNode instanceof VectorPath) {
                PathComponent $this$createGroupComponent_u24lambda_u247 = new PathComponent();
                $this$createGroupComponent_u24lambda_u247.setPathData(((VectorPath) vectorNode).getPathData());
                $this$createGroupComponent_u24lambda_u247.m4754setPathFillTypeoQ8Xj4U(((VectorPath) vectorNode).getPathFillType());
                $this$createGroupComponent_u24lambda_u247.setName(((VectorPath) vectorNode).getName());
                $this$createGroupComponent_u24lambda_u247.setFill(((VectorPath) vectorNode).getFill());
                $this$createGroupComponent_u24lambda_u247.setFillAlpha(((VectorPath) vectorNode).getFillAlpha());
                $this$createGroupComponent_u24lambda_u247.setStroke(((VectorPath) vectorNode).getStroke());
                $this$createGroupComponent_u24lambda_u247.setStrokeAlpha(((VectorPath) vectorNode).getStrokeAlpha());
                $this$createGroupComponent_u24lambda_u247.setStrokeLineWidth(((VectorPath) vectorNode).getStrokeLineWidth());
                $this$createGroupComponent_u24lambda_u247.m4755setStrokeLineCapBeK7IIE(((VectorPath) vectorNode).getStrokeLineCap());
                $this$createGroupComponent_u24lambda_u247.m4756setStrokeLineJoinWw9F2mQ(((VectorPath) vectorNode).getStrokeLineJoin());
                $this$createGroupComponent_u24lambda_u247.setStrokeLineMiter(((VectorPath) vectorNode).getStrokeLineMiter());
                $this$createGroupComponent_u24lambda_u247.setTrimPathStart(((VectorPath) vectorNode).getTrimPathStart());
                $this$createGroupComponent_u24lambda_u247.setTrimPathEnd(((VectorPath) vectorNode).getTrimPathEnd());
                $this$createGroupComponent_u24lambda_u247.setTrimPathOffset(((VectorPath) vectorNode).getTrimPathOffset());
                $this$createGroupComponent.insertAt(index, $this$createGroupComponent_u24lambda_u247);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent $this$createGroupComponent_u24lambda_u248 = new GroupComponent();
                $this$createGroupComponent_u24lambda_u248.setName(((VectorGroup) vectorNode).getName());
                $this$createGroupComponent_u24lambda_u248.setRotation(((VectorGroup) vectorNode).getRotation());
                $this$createGroupComponent_u24lambda_u248.setScaleX(((VectorGroup) vectorNode).getScaleX());
                $this$createGroupComponent_u24lambda_u248.setScaleY(((VectorGroup) vectorNode).getScaleY());
                $this$createGroupComponent_u24lambda_u248.setTranslationX(((VectorGroup) vectorNode).getTranslationX());
                $this$createGroupComponent_u24lambda_u248.setTranslationY(((VectorGroup) vectorNode).getTranslationY());
                $this$createGroupComponent_u24lambda_u248.setPivotX(((VectorGroup) vectorNode).getPivotX());
                $this$createGroupComponent_u24lambda_u248.setPivotY(((VectorGroup) vectorNode).getPivotY());
                $this$createGroupComponent_u24lambda_u248.setClipPathData(((VectorGroup) vectorNode).getClipPathData());
                createGroupComponent($this$createGroupComponent_u24lambda_u248, (VectorGroup) vectorNode);
                $this$createGroupComponent.insertAt(index, $this$createGroupComponent_u24lambda_u248);
            }
        }
        return $this$createGroupComponent;
    }

    public static final void RenderVectorGroup(final VectorGroup group, Map<String, ? extends VectorConfig> map, Composer $composer, final int $changed, final int i) {
        Map<String, ? extends VectorConfig> map2;
        final Map<String, ? extends VectorConfig> map3;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-446179233);
        ComposerKt.sourceInformation($composer3, "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(group) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            map2 = map;
        } else if (($changed & 48) == 0) {
            map2 = map;
            $dirty |= $composer3.changedInstance(map2) ? 32 : 16;
        } else {
            map2 = map;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            map3 = map2;
            $composer2 = $composer3;
        } else {
            Map<String, ? extends VectorConfig> mapEmptyMap = i2 != 0 ? MapsKt.emptyMap() : map2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446179233, $dirty2, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:428)");
            }
            Iterator<VectorNode> it = group.iterator();
            while (it.hasNext()) {
                final VectorNode vectorNode = it.next();
                if (vectorNode instanceof VectorPath) {
                    $composer3.startReplaceGroup(-326281898);
                    ComposerKt.sourceInformation($composer3, "432@15973L1719");
                    VectorConfig vectorConfig = mapEmptyMap.get(((VectorPath) vectorNode).getName());
                    if (vectorConfig == null) {
                        vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                            @Override // androidx.compose.ui.graphics.vector.VectorConfig
                            public /* synthetic */ Object getOrDefault(VectorProperty vectorProperty, Object obj) {
                                return VectorConfig.CC.$default$getOrDefault(this, vectorProperty, obj);
                            }
                        };
                    }
                    VectorConfig config = vectorConfig;
                    Composer $composer4 = $composer3;
                    VectorComposeKt.m4760Path9cdaXJ4((List) config.getOrDefault(VectorProperty.PathData.INSTANCE, ((VectorPath) vectorNode).getPathData()), ((VectorPath) vectorNode).getPathFillType(), ((VectorPath) vectorNode).getName(), (Brush) config.getOrDefault(VectorProperty.Fill.INSTANCE, ((VectorPath) vectorNode).getFill()), ((Number) config.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getFillAlpha()))).floatValue(), (Brush) config.getOrDefault(VectorProperty.Stroke.INSTANCE, ((VectorPath) vectorNode).getStroke()), ((Number) config.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getStrokeAlpha()))).floatValue(), ((Number) config.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getStrokeLineWidth()))).floatValue(), ((VectorPath) vectorNode).getStrokeLineCap(), ((VectorPath) vectorNode).getStrokeLineJoin(), ((VectorPath) vectorNode).getStrokeLineMiter(), ((Number) config.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getTrimPathStart()))).floatValue(), ((Number) config.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getTrimPathEnd()))).floatValue(), ((Number) config.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getTrimPathOffset()))).floatValue(), $composer4, 0, 0, 0);
                    $composer4.endReplaceGroup();
                    mapEmptyMap = mapEmptyMap;
                    $composer3 = $composer4;
                    $dirty2 = $dirty2;
                    it = it;
                } else {
                    Iterator<VectorNode> it2 = it;
                    final Map<String, ? extends VectorConfig> map4 = mapEmptyMap;
                    int $dirty3 = $dirty2;
                    Composer $composer5 = $composer3;
                    if (vectorNode instanceof VectorGroup) {
                        $composer5.startReplaceGroup(-326280040);
                        ComposerKt.sourceInformation($composer5, "511@19111L88,477@17831L1368");
                        VectorConfig config2 = map4.get(((VectorGroup) vectorNode).getName());
                        if (config2 == null) {
                            config2 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                                @Override // androidx.compose.ui.graphics.vector.VectorConfig
                                public /* synthetic */ Object getOrDefault(VectorProperty vectorProperty, Object obj) {
                                    return VectorConfig.CC.$default$getOrDefault(this, vectorProperty, obj);
                                }
                            };
                        }
                        VectorComposeKt.Group(((VectorGroup) vectorNode).getName(), ((Number) config2.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getRotation()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getPivotX()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getPivotY()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getScaleX()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getScaleY()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getTranslationX()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode).getTranslationY()))).floatValue(), (List) config2.getOrDefault(VectorProperty.PathData.INSTANCE, ((VectorGroup) vectorNode).getClipPathData()), ComposableLambdaKt.rememberComposableLambda(1450046638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.1
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

                            public final void invoke(Composer $composer6, int $changed2) {
                                ComposerKt.sourceInformation($composer6, "C512@19129L56:VectorPainter.kt#huu6hf");
                                if (($changed2 & 3) == 2 && $composer6.getSkipping()) {
                                    $composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1450046638, $changed2, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:512)");
                                }
                                VectorPainterKt.RenderVectorGroup((VectorGroup) vectorNode, map4, $composer6, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer5, 54), $composer5, 805306368, 0);
                        $composer5.endReplaceGroup();
                        mapEmptyMap = map4;
                        $composer3 = $composer5;
                        $dirty2 = $dirty3;
                        it = it2;
                    } else {
                        $composer5.startReplaceGroup(-326278588);
                        $composer5.endReplaceGroup();
                        mapEmptyMap = map4;
                        $composer3 = $composer5;
                        $dirty2 = $dirty3;
                        it = it2;
                    }
                }
            }
            map3 = mapEmptyMap;
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup.2
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
                    VectorPainterKt.RenderVectorGroup(group, map3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
