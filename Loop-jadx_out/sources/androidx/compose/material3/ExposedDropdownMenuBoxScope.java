package androidx.compose.material3;

import android.view.View;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.TransformOrigin;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.window.AndroidPopup_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JU\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012J¢\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0006H&J\f\u0010!\u001a\u00020\n*\u00020\nH&\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m195d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "()V", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "focusable", "matchTextFieldWidth", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "exposedDropdownSize", "menuAnchor", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    public abstract Modifier menuAnchor(Modifier modifier);

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX INFO: renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    public final void m2230ExposedDropdownMenukbRbctU(final boolean expanded, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, boolean focusable, boolean matchTextFieldWidth, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean matchTextFieldWidth2;
        Shape shape2;
        int $dirty;
        ScrollState scrollState2;
        boolean focusable2;
        Shape shape3;
        long containerColor2;
        float tonalElevation2;
        float shadowElevation2;
        BorderStroke border2;
        int $dirty2;
        Modifier modifier2;
        final BorderStroke border3;
        Object value$iv;
        Object value$iv2;
        Shape shape4;
        boolean matchTextFieldWidth3;
        float shadowElevation3;
        long containerColor3;
        boolean focusable3;
        ScrollState scrollState3;
        Modifier modifier3;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(366140493);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenu)P(3,7,6,8,4,5,10,1:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp)306@13958L21,309@14097L5,310@14149L14,318@14598L53,319@14681L7,320@14724L7,321@14775L10,330@15067L42,334@15266L51,335@15358L426,348@15978L38,349@16032L587,345@15798L821:ExposedDropdownMenu.android.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer2.changed(modifier) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty4 |= ((i & 8) == 0 && $composer2.changed(scrollState)) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty4 |= $composer2.changed(focusable) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            matchTextFieldWidth2 = matchTextFieldWidth;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            matchTextFieldWidth2 = matchTextFieldWidth;
            $dirty4 |= $composer2.changed(matchTextFieldWidth2) ? 131072 : 65536;
        } else {
            matchTextFieldWidth2 = matchTextFieldWidth;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                shape2 = shape;
                int i5 = $composer2.changed(shape2) ? 1048576 : 524288;
                $dirty4 |= i5;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                int i6 = $composer2.changed(containerColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i6;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i6;
        } else {
            $dirty = $dirty4;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(tonalElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        int i9 = 805306368;
        if (i8 != 0) {
            $dirty |= i9;
        } else if (($changed & 805306368) == 0) {
            i9 = $composer2.changed(shadowElevation) ? 536870912 : 268435456;
            $dirty |= i9;
        }
        int $dirty5 = $dirty;
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(border) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changed(this) ? 256 : 128;
        }
        if (($dirty5 & 306783379) == 306783378 && ($dirty1 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            scrollState3 = scrollState;
            focusable3 = focusable;
            containerColor3 = containerColor;
            tonalElevation2 = tonalElevation;
            shadowElevation3 = shadowElevation;
            border3 = border;
            matchTextFieldWidth3 = matchTextFieldWidth2;
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 8) != 0) {
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                    $dirty5 &= -7169;
                } else {
                    scrollState2 = scrollState;
                }
                focusable2 = i3 != 0 ? true : focusable;
                if (i4 != 0) {
                    matchTextFieldWidth2 = true;
                }
                if ((i & 64) != 0) {
                    shape3 = MenuDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty5 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i & 128) != 0) {
                    containerColor2 = MenuDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty5 &= -29360129;
                } else {
                    containerColor2 = containerColor;
                }
                tonalElevation2 = i7 != 0 ? MenuDefaults.INSTANCE.m2360getTonalElevationD9Ej5fM() : tonalElevation;
                shadowElevation2 = i8 != 0 ? MenuDefaults.INSTANCE.m2359getShadowElevationD9Ej5fM() : shadowElevation;
                if (i10 != 0) {
                    border2 = null;
                    $dirty2 = $dirty5;
                    modifier2 = modifier4;
                } else {
                    border2 = border;
                    $dirty2 = $dirty5;
                    modifier2 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty5 &= -7169;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty5 &= -29360129;
                }
                scrollState2 = scrollState;
                focusable2 = focusable;
                containerColor2 = containerColor;
                tonalElevation2 = tonalElevation;
                shadowElevation2 = shadowElevation;
                border2 = border;
                $dirty2 = $dirty5;
                shape3 = shape2;
                modifier2 = modifier;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(366140493, $dirty2, $dirty1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:315)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1950031310, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object value$iv3 = $composer2.rememberedValue();
            if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                $composer2.updateRememberedValue(value$iv3);
            }
            final MutableState keyboardSignalState = (MutableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            View view = (View) objConsume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) objConsume2;
            int topWindowInsets = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, $composer2, 6).getTop(density);
            $composer2.startReplaceGroup(1950031523);
            ComposerKt.sourceInformation($composer2, "324@14875L64,324@14839L100");
            if (expanded) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1950031587, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                Object value$iv4 = $composer2.rememberedValue();
                if (value$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1$1
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
                            keyboardSignalState.setValue(Unit.INSTANCE);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ExposedDropdownMenu_androidKt.SoftKeyboardListener(view, density, (Function0) value$iv4, $composer2, 384);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer2, 1950031779, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            Object value$iv5 = $composer2.rememberedValue();
            if (value$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new MutableTransitionState(false);
                $composer2.updateRememberedValue(value$iv5);
            }
            final MutableTransitionState expandedState = (MutableTransitionState) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            expandedState.setTargetState$animation_core_release(Boolean.valueOf(expanded));
            if (((Boolean) expandedState.getCurrentState()).booleanValue() || ((Boolean) expandedState.getTargetState()).booleanValue()) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1950031978, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                border3 = border2;
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m4677boximpl(TransformOrigin.INSTANCE.m4690getCenterSzJe1aQ()), null, 2, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                final MutableState transformOriginState = (MutableState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1950032070, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(density) | $composer2.changed(topWindowInsets);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new ExposedDropdownMenuPositionProvider(density, topWindowInsets, keyboardSignalState, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
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
                        public final void invoke2(IntRect anchorBounds, IntRect menuBounds) {
                            transformOriginState.setValue(TransformOrigin.m4677boximpl(MenuKt.calculateTransformOrigin(anchorBounds, menuBounds)));
                        }
                    }, 8, null);
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                ExposedDropdownMenuPositionProvider popupPositionProvider = (ExposedDropdownMenuPositionProvider) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Modifier modifier5 = modifier2;
                final boolean z = matchTextFieldWidth2;
                final ScrollState scrollState4 = scrollState2;
                final Shape shape5 = shape3;
                final long j = containerColor2;
                final float f = tonalElevation2;
                final float f2 = shadowElevation2;
                AndroidPopup_androidKt.Popup(popupPositionProvider, function0, ExposedDropdownMenuDefaults.INSTANCE.popupProperties$material3_release(focusable2, $composer2, (($dirty2 >> 12) & 14) | 48, 0), ComposableLambdaKt.rememberComposableLambda(-1191007939, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.2
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
                        ComposerKt.sourceInformation($composer3, "C350@16050L555:ExposedDropdownMenu.android.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1191007939, $changed2, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.android.kt:350)");
                            }
                            MenuKt.m2373DropdownMenuContentQj0Zi0g(ExposedDropdownMenuBoxScope.this.exposedDropdownSize(modifier5, z), expandedState, transformOriginState, scrollState4, shape5, j, f, f2, border3, function3, $composer3, (MutableTransitionState.$stable << 3) | 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54), $composer2, ($dirty2 & 112) | 3072, 0);
            } else {
                shadowElevation2 = shadowElevation2;
                tonalElevation2 = tonalElevation2;
                border3 = border2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            matchTextFieldWidth3 = matchTextFieldWidth2;
            shadowElevation3 = shadowElevation2;
            containerColor3 = containerColor2;
            focusable3 = focusable2;
            scrollState3 = scrollState2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final ScrollState scrollState5 = scrollState3;
            final boolean z2 = focusable3;
            final boolean z3 = matchTextFieldWidth3;
            final Shape shape6 = shape4;
            final long j2 = containerColor3;
            final float f3 = tonalElevation2;
            final float f4 = shadowElevation3;
            final BorderStroke borderStroke = border3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.3
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

                public final void invoke(Composer composer, int i11) {
                    ExposedDropdownMenuBoxScope.this.m2230ExposedDropdownMenukbRbctU(expanded, function0, modifier6, scrollState5, z2, z3, shape6, j2, f3, f4, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `focusable` and customization options parameters.")
    public final /* synthetic */ void ExposedDropdownMenu(final boolean expanded, final Function0 onDismissRequest, Modifier modifier, ScrollState scrollState, final Function3 content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ScrollState scrollState2;
        Modifier.Companion modifier3;
        Modifier modifier4;
        ScrollState scrollState3;
        Composer $composer2 = $composer.startRestartGroup(1729549851);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenu)P(1,3,2,4)376@17027L21,385@17361L5,386@17406L14,378@17111L476:ExposedDropdownMenu.android.kt#uh7d8r");
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
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                scrollState2 = scrollState;
                int i3 = $composer2.changed(scrollState2) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                scrollState2 = scrollState;
            }
            $dirty |= i3;
        } else {
            scrollState2 = scrollState;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(this) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            scrollState3 = scrollState2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1729549851, $dirty, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:378)");
            }
            m2230ExposedDropdownMenukbRbctU(expanded, onDismissRequest, modifier3, scrollState2, true, true, MenuDefaults.INSTANCE.getShape($composer2, 6), MenuDefaults.INSTANCE.getContainerColor($composer2, 6), MenuDefaults.INSTANCE.m2360getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m2359getShadowElevationD9Ej5fM(), null, content, $composer2, ($dirty & 14) | 906190848 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), (($dirty >> 9) & 112) | 6 | (($dirty >> 9) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            scrollState3 = scrollState2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final ScrollState scrollState4 = scrollState3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.4
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

                public final void invoke(Composer composer, int i4) {
                    ExposedDropdownMenuBoxScope.this.ExposedDropdownMenu(expanded, onDismissRequest, modifier5, scrollState4, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
