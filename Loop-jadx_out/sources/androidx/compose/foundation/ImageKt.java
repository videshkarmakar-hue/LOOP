package androidx.compose.foundation;

import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.draw.PainterModifierKt;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.FilterQuality;
import androidx.compose.p001ui.graphics.ImageBitmap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.painter.BitmapPainter;
import androidx.compose.p001ui.graphics.painter.BitmapPainterKt;
import androidx.compose.p001ui.graphics.painter.Painter;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.graphics.vector.VectorPainter;
import androidx.compose.p001ui.graphics.vector.VectorPainterKt;
import androidx.compose.p001ui.layout.ContentScale;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Image.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m195d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ImageKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap bitmap, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -2123228673, "C(Image)P(2,4,6!1,5)96@4585L177:Image.kt#71ulvw");
        Modifier.Companion modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment alignment2 = (i & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 32) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, $changed, -1, "androidx.compose.foundation.Image (Image.kt:95)");
        }
        m510Image5hnEew(bitmap, contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, FilterQuality.INSTANCE.m4391getLowfv9h1I(), $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX INFO: renamed from: Image-5h-nEew, reason: not valid java name */
    public static final void m510Image5hnEew(ImageBitmap bitmap, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, int filterQuality, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1396260732, "C(Image)P(2,4,7!1,5!,6:c#ui.graphics.FilterQuality)153@7224L73,154@7302L248:Image.kt#71ulvw");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment alignment2 = (i & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 32) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 64) != 0 ? null : colorFilter;
        int filterQuality2 = (i & 128) != 0 ? DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I() : filterQuality;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, $changed, -1, "androidx.compose.foundation.Image (Image.kt:152)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -816798505, "CC(remember):Image.kt#9igjgp");
        boolean invalid$iv = $composer.changed(bitmap);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = BitmapPainterKt.m4983BitmapPainterQZhYCtY(bitmap, (6 & 2) != 0 ? IntOffset.INSTANCE.m6943getZeronOccac() : 0L, (6 & 4) != 0 ? IntSizeKt.IntSize(bitmap.getWidth(), bitmap.getHeight()) : 0L, (6 & 8) != 0 ? FilterQuality.INSTANCE.m4391getLowfv9h1I() : filterQuality2);
            $composer.updateRememberedValue(value$iv);
        }
        BitmapPainter bitmapPainter = (BitmapPainter) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Image(bitmapPainter, contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, $composer, ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void Image(ImageVector imageVector, String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1595907091, "C(Image)P(5,3,6!1,4)198@9330L34,197@9309L237:Image.kt#71ulvw");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment alignment2 = (i & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale contentScale2 = (i & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float alpha2 = (i & 32) != 0 ? 1.0f : alpha;
        ColorFilter colorFilter2 = (i & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, $changed, -1, "androidx.compose.foundation.Image (Image.kt:197)");
        }
        Image(VectorPainterKt.rememberVectorPainter(imageVector, $composer, $changed & 14), contentDescription, modifier2, alignment2, contentScale2, alpha2, colorFilter2, $composer, VectorPainter.$stable | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0287  */
    public static final void Image(final Painter painter, final String contentDescription, Modifier modifier, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Alignment alignment2;
        ContentScale contentScale2;
        float f;
        Modifier.Companion semantics;
        Modifier modifier3;
        final Function0<ComposeUiNode> function0;
        ColorFilter colorFilter2;
        float alpha2;
        ColorFilter colorFilter3;
        Alignment alignment3;
        ContentScale contentScale3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1142754848);
        ComposerKt.sourceInformation($composer2, "C(Image)P(6,3,5!1,4)255@11931L329:Image.kt#71ulvw");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(painter) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(contentDescription) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            alignment2 = alignment;
        } else if (($changed & 3072) == 0) {
            alignment2 = alignment;
            $dirty |= $composer2.changed(alignment2) ? 2048 : 1024;
        } else {
            alignment2 = alignment;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            contentScale2 = contentScale;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            contentScale2 = contentScale;
            $dirty |= $composer2.changed(contentScale2) ? 16384 : 8192;
        } else {
            contentScale2 = contentScale;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = alpha;
        } else if ((196608 & $changed) == 0) {
            f = alpha;
            $dirty |= $composer2.changed(f) ? 131072 : 65536;
        } else {
            f = alpha;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(colorFilter) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            colorFilter3 = colorFilter;
            $dirty = $dirty;
            modifier3 = modifier2;
            alignment3 = alignment2;
            alpha2 = f;
            contentScale3 = contentScale2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                alignment2 = Alignment.INSTANCE.getCenter();
            }
            if (i4 != 0) {
                contentScale2 = ContentScale.INSTANCE.getFit();
            }
            float alpha3 = i5 != 0 ? 1.0f : f;
            ColorFilter colorFilter4 = i6 != 0 ? null : colorFilter;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1142754848, $dirty, -1, "androidx.compose.foundation.Image (Image.kt:243)");
            }
            $composer2.startReplaceGroup(-816794123);
            ComposerKt.sourceInformation($composer2, "245@11667L103");
            if (contentDescription != null) {
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -816794062, "CC(remember):Image.kt#9igjgp");
                boolean invalid$iv = ($dirty & 112) == 32;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$semantics$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                            SemanticsPropertiesKt.setContentDescription($this$semantics, contentDescription);
                            SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6065getImageo7Vup1c());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                semantics = SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv, 1, null);
            } else {
                $dirty = $dirty;
                semantics = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = PainterModifierKt.paint(ClipKt.clipToBounds(modifier4.then(semantics)), painter, (22 & 2) != 0, (22 & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment2, (22 & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale2, (22 & 16) != 0 ? 1.0f : alpha3, (22 & 32) != 0 ? null : colorFilter4);
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt.Image.1
                @Override // androidx.compose.p001ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                    return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i7);
                }

                @Override // androidx.compose.p001ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                    return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i7);
                }

                @Override // androidx.compose.p001ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                    return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i7);
                }

                @Override // androidx.compose.p001ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                    return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i7);
                }

                @Override // androidx.compose.p001ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo285measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                    return MeasureScope.CC.layout$default($this$Layout, Constraints.m6746getMinWidthimpl(constraints), Constraints.m6745getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt.Image.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope $this$layout) {
                        }
                    }, 4, null);
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            modifier3 = modifier4;
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            float alpha4 = alpha3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(new Function0<ComposeUiNode>() { // from class: androidx.compose.foundation.ImageKt$Image$$inlined$Layout$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final ComposeUiNode invoke() {
                        return function0.invoke();
                    }
                });
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u241$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u241$iv.getInserting()) {
                colorFilter2 = colorFilter4;
            } else {
                colorFilter2 = colorFilter4;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u241$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                }
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alpha2 = alpha4;
                colorFilter3 = colorFilter2;
                alignment3 = alignment2;
                contentScale3 = contentScale2;
            }
            $this$Layout_u24lambda_u241$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
            $this$Layout_u24lambda_u241$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            alpha2 = alpha4;
            colorFilter3 = colorFilter2;
            alignment3 = alignment2;
            contentScale3 = contentScale2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Alignment alignment4 = alignment3;
            final ContentScale contentScale4 = contentScale3;
            final float f2 = alpha2;
            final ColorFilter colorFilter5 = colorFilter3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.ImageKt.Image.2
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
                    ImageKt.Image(painter, contentDescription, modifier5, alignment4, contentScale4, f2, colorFilter5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
