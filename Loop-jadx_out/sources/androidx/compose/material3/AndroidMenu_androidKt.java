package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.TransformOrigin;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpKt;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.window.AndroidPopup_androidKt;
import androidx.compose.p001ui.window.PopupProperties;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AndroidMenu.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0090\u0001\u0010\"\u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0002\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, m195d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidMenu_androidKt {
    /* JADX INFO: renamed from: DropdownMenu-IlH_yew, reason: not valid java name */
    public static final void m1914DropdownMenuIlH_yew(final boolean expanded, final Function0<Unit> function0, Modifier modifier, long offset, ScrollState scrollState, PopupProperties properties, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PopupProperties properties2;
        long offset2;
        ScrollState scrollState2;
        Shape shape2;
        long containerColor2;
        BorderStroke border2;
        int $dirty;
        float shadowElevation2;
        long containerColor3;
        float tonalElevation2;
        ScrollState scrollState3;
        boolean z;
        Object value$iv;
        Object value$iv2;
        ScrollState scrollState4;
        PopupProperties properties3;
        float shadowElevation3;
        float tonalElevation3;
        long containerColor4;
        long offset3;
        Modifier modifier3;
        Shape shape3;
        BorderStroke border3;
        Composer $composer2 = $composer.startRestartGroup(1431928300);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenu)P(3,6,4,5:c#ui.unit.DpOffset,8,7,10,1:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp)100@5311L21,102@5435L5,103@5483L14,109@5719L42,113@5906L51,114@5993L7,115@6037L281,128@6489L494,124@6328L655:AndroidMenu.android.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(offset) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= ((i & 16) == 0 && $composer2.changed(scrollState)) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            properties2 = properties;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            properties2 = properties;
            $dirty2 |= $composer2.changed(properties2) ? 131072 : 65536;
        } else {
            properties2 = properties;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(shape)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(containerColor)) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(tonalElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changed(shadowElevation) ? 536870912 : 268435456;
        }
        int i7 = i & 1024;
        if (i7 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(border) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if (($dirty2 & 306783379) == 306783378 && ($dirty1 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            offset3 = offset;
            scrollState4 = scrollState;
            shape3 = shape;
            containerColor4 = containerColor;
            tonalElevation3 = tonalElevation;
            shadowElevation3 = shadowElevation;
            border3 = border;
            modifier3 = modifier2;
            properties3 = properties2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                offset2 = i3 != 0 ? DpKt.m6822DpOffsetYgX7TsA(C1979Dp.m6801constructorimpl(0), C1979Dp.m6801constructorimpl(0)) : offset;
                if ((i & 16) != 0) {
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                    $dirty2 &= -57345;
                } else {
                    scrollState2 = scrollState;
                }
                PopupProperties properties4 = i4 != 0 ? new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null) : properties2;
                if ((i & 64) != 0) {
                    shape2 = MenuDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    shape2 = shape;
                }
                if ((i & 128) != 0) {
                    containerColor2 = MenuDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty2 &= -29360129;
                } else {
                    containerColor2 = containerColor;
                }
                float tonalElevation4 = i5 != 0 ? MenuDefaults.INSTANCE.m2360getTonalElevationD9Ej5fM() : tonalElevation;
                float shadowElevation4 = i6 != 0 ? MenuDefaults.INSTANCE.m2359getShadowElevationD9Ej5fM() : shadowElevation;
                if (i7 != 0) {
                    $dirty = $dirty2;
                    shadowElevation2 = shadowElevation4;
                    border2 = null;
                    properties2 = properties4;
                    containerColor3 = containerColor2;
                    modifier2 = modifier4;
                    tonalElevation2 = tonalElevation4;
                    scrollState3 = scrollState2;
                } else {
                    border2 = border;
                    $dirty = $dirty2;
                    shadowElevation2 = shadowElevation4;
                    properties2 = properties4;
                    containerColor3 = containerColor2;
                    modifier2 = modifier4;
                    tonalElevation2 = tonalElevation4;
                    scrollState3 = scrollState2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    int i8 = (-29360129) & $dirty2;
                    offset2 = offset;
                    shape2 = shape;
                    containerColor3 = containerColor;
                    tonalElevation2 = tonalElevation;
                    shadowElevation2 = shadowElevation;
                    border2 = border;
                    $dirty = i8;
                    scrollState3 = scrollState;
                } else {
                    offset2 = offset;
                    scrollState3 = scrollState;
                    shape2 = shape;
                    containerColor3 = containerColor;
                    shadowElevation2 = shadowElevation;
                    border2 = border;
                    $dirty = $dirty2;
                    tonalElevation2 = tonalElevation;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1431928300, $dirty, $dirty1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:108)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 463007300, "CC(remember):AndroidMenu.android.kt#9igjgp");
            Object value$iv3 = $composer2.rememberedValue();
            if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                z = false;
                value$iv3 = new MutableTransitionState(false);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                z = false;
            }
            final MutableTransitionState expandedState = (MutableTransitionState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            expandedState.setTargetState$animation_core_release(Boolean.valueOf(expanded));
            if (((Boolean) expandedState.getCurrentState()).booleanValue() || ((Boolean) expandedState.getTargetState()).booleanValue()) {
                ComposerKt.sourceInformationMarkerStart($composer2, 463007487, "CC(remember):AndroidMenu.android.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m4677boximpl(TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ()), null, 2, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                final MutableState transformOriginState = (MutableState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density = (Density) objConsume;
                ComposerKt.sourceInformationMarkerStart($composer2, 463007618, "CC(remember):AndroidMenu.android.kt#9igjgp");
                if (($dirty & 7168) == 2048) {
                    z = true;
                }
                boolean invalid$iv = z | $composer2.changed(density);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new DropdownMenuPositionProvider(offset2, density, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                            invoke2(intRect, intRect2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IntRect parentBounds, IntRect menuBounds) {
                            transformOriginState.setValue(TransformOrigin.m4677boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
                        }
                    }, 4, null);
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                DropdownMenuPositionProvider popupPositionProvider = (DropdownMenuPositionProvider) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Modifier modifier5 = modifier2;
                final ScrollState scrollState5 = scrollState3;
                final Shape shape4 = shape2;
                final long j = containerColor3;
                final float f = tonalElevation2;
                final float f2 = shadowElevation2;
                final BorderStroke borderStroke = border2;
                AndroidPopup_androidKt.Popup(popupPositionProvider, function0, properties2, ComposableLambdaKt.rememberComposableLambda(2126968933, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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
                        ComposerKt.sourceInformation($composer3, "C129@6503L470:AndroidMenu.android.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2126968933, $changed2, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:129)");
                            }
                            MenuKt.m2373DropdownMenuContentQj0Zi0g(modifier5, expandedState, transformOriginState, scrollState5, shape4, j, f, f2, borderStroke, function3, $composer3, (MutableTransitionState.$stable << 3) | 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, ($dirty & 112) | 3072 | (($dirty >> 9) & 896), 0);
            } else {
                shadowElevation2 = shadowElevation2;
                properties2 = properties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scrollState4 = scrollState3;
            properties3 = properties2;
            shadowElevation3 = shadowElevation2;
            tonalElevation3 = tonalElevation2;
            containerColor4 = containerColor3;
            offset3 = offset2;
            modifier3 = modifier2;
            shape3 = shape2;
            border3 = border2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final long j2 = offset3;
            final ScrollState scrollState6 = scrollState4;
            final PopupProperties popupProperties = properties3;
            final Shape shape5 = shape3;
            final long j3 = containerColor4;
            final float f3 = tonalElevation3;
            final float f4 = shadowElevation3;
            final BorderStroke borderStroke2 = border3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
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

                public final void invoke(Composer composer, int i9) {
                    AndroidMenu_androidKt.m1914DropdownMenuIlH_yew(expanded, function0, modifier6, j2, scrollState6, popupProperties, shape5, j3, f3, f4, borderStroke2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with parameters for shape, color, elevation, and border.", replaceWith = @ReplaceWith(expression = "DropdownMenu(\n    expanded = expanded,\n    onDismissRequest = onDismissRequest,\n    modifier = modifier,\n    offset = offset,\n    scrollState = scrollState,\n    properties = properties,\n    shape = MenuDefaults.shape,\n    containerColor = MenuDefaults.containerColor,\n    tonalElevation = MenuDefaults.TonalElevation,\n    shadowElevation = MenuDefaults.ShadowElevation,\n    border = null,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    public static final /* synthetic */ void m1912DropdownMenu4kj_NE(final boolean expanded, final Function0 onDismissRequest, Modifier modifier, long offset, ScrollState scrollState, PopupProperties properties, final Function3 content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long offset2;
        ScrollState scrollState2;
        PopupProperties popupProperties;
        Modifier.Companion modifier3;
        PopupProperties properties2;
        Modifier modifier4;
        PopupProperties properties3;
        long offset3;
        ScrollState scrollState3;
        Composer $composer2 = $composer.startRestartGroup(-1137929566);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)172@8089L21,182@8444L5,183@8485L14,175@8233L413:AndroidMenu.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onDismissRequest) ? 32 : 16;
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
            offset2 = offset;
        } else if (($changed & 3072) == 0) {
            offset2 = offset;
            $dirty |= $composer2.changed(offset2) ? 2048 : 1024;
        } else {
            offset2 = offset;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                scrollState2 = scrollState;
                int i4 = $composer2.changed(scrollState2) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                scrollState2 = scrollState;
            }
            $dirty |= i4;
        } else {
            scrollState2 = scrollState;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            popupProperties = properties;
        } else if ((196608 & $changed) == 0) {
            popupProperties = properties;
            $dirty |= $composer2.changed(popupProperties) ? 131072 : 65536;
        } else {
            popupProperties = properties;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 1048576 : 524288;
        }
        if ((599187 & $dirty) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            scrollState3 = scrollState2;
            properties3 = popupProperties;
            offset3 = offset2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    offset2 = DpKt.m6822DpOffsetYgX7TsA(C1979Dp.m6801constructorimpl(0), C1979Dp.m6801constructorimpl(0));
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                }
                properties2 = i5 != 0 ? new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null) : popupProperties;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier3 = modifier2;
                properties2 = popupProperties;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1137929566, $dirty, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:175)");
            }
            m1914DropdownMenuIlH_yew(expanded, onDismissRequest, modifier3, offset2, scrollState2, properties2, MenuDefaults.INSTANCE.getShape($composer2, 6), MenuDefaults.INSTANCE.getContainerColor($composer2, 6), MenuDefaults.INSTANCE.m2360getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m2359getShadowElevationD9Ej5fM(), null, content, $composer2, ($dirty & 14) | 905969664 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), (($dirty >> 15) & 112) | 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            properties3 = properties2;
            offset3 = offset2;
            scrollState3 = scrollState2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j = offset3;
            final ScrollState scrollState4 = scrollState3;
            final PopupProperties popupProperties2 = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$3
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

                public final void invoke(Composer composer, int i6) {
                    AndroidMenu_androidKt.m1912DropdownMenu4kj_NE(expanded, onDismissRequest, modifier5, j, scrollState4, popupProperties2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final /* synthetic */ void m1913DropdownMenuILWXrKs(final boolean expanded, final Function0 onDismissRequest, Modifier modifier, long offset, PopupProperties properties, final Function3 content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        PopupProperties popupProperties;
        Modifier modifier3;
        long offset2;
        PopupProperties properties2;
        Composer $composer2 = $composer.startRestartGroup(354826666);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)212@9452L21,207@9308L219:AndroidMenu.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onDismissRequest) ? 32 : 16;
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
            j = offset;
        } else if (($changed & 3072) == 0) {
            j = offset;
            $dirty |= $composer2.changed(j) ? 2048 : 1024;
        } else {
            j = offset;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            popupProperties = properties;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            popupProperties = properties;
            $dirty |= $composer2.changed(popupProperties) ? 16384 : 8192;
        } else {
            popupProperties = properties;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            properties2 = popupProperties;
            offset2 = j;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            long offset3 = i3 != 0 ? DpKt.m6822DpOffsetYgX7TsA(C1979Dp.m6801constructorimpl(0), C1979Dp.m6801constructorimpl(0)) : j;
            PopupProperties properties3 = i4 != 0 ? new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null) : popupProperties;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(354826666, $dirty, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:207)");
            }
            m1914DropdownMenuIlH_yew(expanded, onDismissRequest, modifier4, offset3, ScrollKt.rememberScrollState(0, $composer2, 0, 1), properties3, null, 0L, 0.0f, 0.0f, null, content, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 3) & 458752), ($dirty >> 12) & 112, 1984);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            offset2 = offset3;
            properties2 = properties3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j2 = offset2;
            final PopupProperties popupProperties2 = properties2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$4
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

                public final void invoke(Composer composer, int i5) {
                    AndroidMenu_androidKt.m1913DropdownMenuILWXrKs(expanded, onDismissRequest, modifier5, j2, popupProperties2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, boolean enabled, MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        boolean z;
        MenuItemColors menuItemColors;
        Modifier.Companion modifier2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Function2<? super Composer, ? super Integer, Unit> function6;
        boolean enabled2;
        MenuItemColors colors2;
        MutableInteractionSource interactionSource2;
        int $dirty;
        PaddingValues contentPadding2;
        MenuItemColors colors3;
        MenuItemColors colors4;
        PaddingValues contentPadding3;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        boolean enabled3;
        Composer $composer2 = $composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenuItem)P(7,6,5,4,8,2)253@11498L12,257@11658L319:AndroidMenu.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = enabled;
        } else if ((196608 & $changed) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = enabled;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                menuItemColors = colors;
                int i6 = $composer2.changed(menuItemColors) ? 1048576 : 524288;
                $dirty2 |= i6;
            } else {
                menuItemColors = colors;
            }
            $dirty2 |= i6;
        } else {
            menuItemColors = colors;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(contentPadding) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            contentPadding3 = contentPadding;
            interactionSource3 = interactionSource;
            enabled3 = z;
            colors4 = menuItemColors;
            function7 = function3;
            function8 = function4;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function5 = i3 != 0 ? null : function3;
                function6 = i4 != 0 ? null : function4;
                enabled2 = i5 != 0 ? true : z;
                if ((i & 64) != 0) {
                    colors2 = MenuDefaults.INSTANCE.itemColors($composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    colors2 = menuItemColors;
                }
                PaddingValues contentPadding4 = i7 != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : contentPadding;
                if (i8 != 0) {
                    interactionSource2 = null;
                    $dirty = $dirty2;
                    contentPadding2 = contentPadding4;
                    colors3 = colors2;
                } else {
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    contentPadding2 = contentPadding4;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    int i9 = $dirty2 & (-3670017);
                    modifier2 = modifier;
                    function5 = function3;
                    function6 = function4;
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = i9;
                    enabled2 = z;
                    colors3 = menuItemColors;
                } else {
                    modifier2 = modifier;
                    function5 = function3;
                    function6 = function4;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    enabled2 = z;
                    colors3 = menuItemColors;
                    contentPadding2 = contentPadding;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1826340448, $dirty, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:256)");
            }
            MenuKt.DropdownMenuItemContent(function2, function0, modifier2, function5, function6, enabled2, colors3, contentPadding2, interactionSource2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            contentPadding3 = contentPadding2;
            modifier3 = modifier2;
            interactionSource3 = interactionSource2;
            function7 = function5;
            function8 = function6;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function8;
            final boolean z2 = enabled3;
            final MenuItemColors menuItemColors2 = colors4;
            final PaddingValues paddingValues = contentPadding3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt.DropdownMenuItem.1
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

                public final void invoke(Composer composer, int i10) {
                    AndroidMenu_androidKt.DropdownMenuItem(function2, function0, modifier4, function9, function10, z2, menuItemColors2, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
