package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a¦\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VectorComposeKt {
    public static final void Group(String name, float rotation, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> list, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        float f;
        float f2;
        float f3;
        String name2;
        float rotation2;
        float pivotX2;
        float pivotY2;
        float scaleX2;
        float scaleY2;
        float translationX2;
        float translationY2;
        List<? extends PathNode> emptyPath;
        String name3;
        float translationY3;
        float rotation3;
        float pivotX3;
        float pivotY3;
        float scaleX3;
        float scaleY3;
        float translationX3;
        List<? extends PathNode> list2;
        Composer $composer2 = $composer.startRestartGroup(-213417674);
        ComposerKt.sourceInformation($composer2, "C(Group)P(2,5,3,4,6,7,8,9)58@2500L585:VectorCompose.kt#huu6hf");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(name) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(rotation) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            f = pivotX;
        } else if (($changed & 384) == 0) {
            f = pivotX;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = pivotX;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            f2 = pivotY;
        } else if (($changed & 3072) == 0) {
            f2 = pivotY;
            $dirty |= $composer2.changed(f2) ? 2048 : 1024;
        } else {
            f2 = pivotY;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            f3 = scaleX;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            f3 = scaleX;
            $dirty |= $composer2.changed(f3) ? 16384 : 8192;
        } else {
            f3 = scaleX;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty |= $composer2.changed(scaleY) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(translationX) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(translationY) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changedInstance(list)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if ((306783379 & $dirty) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            name3 = name;
            rotation3 = rotation;
            scaleY3 = scaleY;
            translationX3 = translationX;
            translationY3 = translationY;
            list2 = list;
            pivotX3 = f;
            pivotY3 = f2;
            scaleX3 = f3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                name2 = i2 != 0 ? "" : name;
                rotation2 = i3 != 0 ? 0.0f : rotation;
                pivotX2 = i4 != 0 ? 0.0f : f;
                pivotY2 = i5 != 0 ? 0.0f : f2;
                scaleX2 = i6 != 0 ? 1.0f : f3;
                scaleY2 = i7 != 0 ? 1.0f : scaleY;
                translationX2 = i8 != 0 ? 0.0f : translationX;
                translationY2 = i9 != 0 ? 0.0f : translationY;
                if ((i & 256) != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    $dirty &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 256) != 0) {
                    name2 = name;
                    rotation2 = rotation;
                    scaleY2 = scaleY;
                    emptyPath = list;
                    $dirty &= -234881025;
                    pivotX2 = f;
                    pivotY2 = f2;
                    scaleX2 = f3;
                    translationX2 = translationX;
                    translationY2 = translationY;
                } else {
                    name2 = name;
                    rotation2 = rotation;
                    scaleY2 = scaleY;
                    translationY2 = translationY;
                    emptyPath = list;
                    pivotX2 = f;
                    pivotY2 = f2;
                    scaleX2 = f3;
                    translationX2 = translationX;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, $dirty, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
            }
            AnonymousClass1 anonymousClass1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GroupComponent invoke() {
                    return new GroupComponent();
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -548224868, "CC(ComposeNode)P(1,2)336@12606L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(anonymousClass1);
            } else {
                $composer2.useNode();
            }
            Composer $this$Group_u24lambda_u240 = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Group_u24lambda_u240, name2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str) {
                    invoke2(groupComponent, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent $this$set, String it) {
                    $this$set.setName(it);
                }
            });
            name3 = name2;
            Updater.m3554setimpl($this$Group_u24lambda_u240, Float.valueOf(rotation2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f4) {
                    invoke(groupComponent, f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent $this$set, float it) {
                    $this$set.setRotation(it);
                }
            });
            Updater.m3554setimpl($this$Group_u24lambda_u240, Float.valueOf(pivotX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f4) {
                    invoke(groupComponent, f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent $this$set, float it) {
                    $this$set.setPivotX(it);
                }
            });
            Updater.m3554setimpl($this$Group_u24lambda_u240, Float.valueOf(pivotY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f4) {
                    invoke(groupComponent, f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent $this$set, float it) {
                    $this$set.setPivotY(it);
                }
            });
            Updater.m3554setimpl($this$Group_u24lambda_u240, Float.valueOf(scaleX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f4) {
                    invoke(groupComponent, f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent $this$set, float it) {
                    $this$set.setScaleX(it);
                }
            });
            Updater.m3554setimpl($this$Group_u24lambda_u240, Float.valueOf(scaleY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f4) {
                    invoke(groupComponent, f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent $this$set, float it) {
                    $this$set.setScaleY(it);
                }
            });
            Updater.m3554setimpl($this$Group_u24lambda_u240, Float.valueOf(translationX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f4) {
                    invoke(groupComponent, f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent $this$set, float it) {
                    $this$set.setTranslationX(it);
                }
            });
            Updater.m3554setimpl($this$Group_u24lambda_u240, Float.valueOf(translationY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f4) {
                    invoke(groupComponent, f4.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent $this$set, float it) {
                    $this$set.setTranslationY(it);
                }
            });
            Updater.m3554setimpl($this$Group_u24lambda_u240, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list3) {
                    invoke2(groupComponent, list3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent $this$set, List<? extends PathNode> list3) {
                    $this$set.setClipPathData(list3);
                }
            });
            int i10 = (6 >> 6) & 14;
            float translationY4 = translationY2;
            ComposerKt.sourceInformationMarkerStart($composer2, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
            function2.invoke($composer2, Integer.valueOf(($dirty >> 27) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            translationY3 = translationY4;
            rotation3 = rotation2;
            pivotX3 = pivotX2;
            pivotY3 = pivotY2;
            scaleX3 = scaleX2;
            scaleY3 = scaleY2;
            translationX3 = translationX2;
            list2 = emptyPath;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final String str = name3;
            final float f4 = rotation3;
            final float f5 = pivotX3;
            final float f6 = pivotY3;
            final float f7 = scaleX3;
            final float f8 = scaleY3;
            final float f9 = translationX3;
            final float f10 = translationY3;
            final List<? extends PathNode> list3 = list2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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
                    VectorComposeKt.Group(str, f4, f5, f6, f7, f8, f9, f10, list3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m4760Path9cdaXJ4(final List<? extends PathNode> list, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset, Composer $composer, final int $changed, final int $changed1, final int i) {
        int pathFillType2;
        float trimPathOffset2;
        float trimPathEnd2;
        float strokeLineWidth2;
        int strokeLineCap2;
        int strokeLineJoin2;
        float strokeLineMiter2;
        float trimPathStart2;
        String name2;
        Brush fill2;
        float fillAlpha2;
        Brush stroke2;
        float strokeAlpha2;
        Composer $composer2 = $composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation($composer2, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)115@5068L876:VectorCompose.kt#huu6hf");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(pathFillType) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(name) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(fill) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(fillAlpha) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty |= $composer2.changed(stroke) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(strokeAlpha) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(strokeLineWidth) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(strokeLineCap) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(strokeLineJoin) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(strokeLineMiter) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changed(trimPathStart) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer2.changed(trimPathEnd) ? 256 : 128;
        }
        int i14 = i & 8192;
        if (i14 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer2.changed(trimPathOffset) ? 2048 : 1024;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            pathFillType2 = pathFillType;
            name2 = name;
            fill2 = fill;
            fillAlpha2 = fillAlpha;
            stroke2 = stroke;
            strokeAlpha2 = strokeAlpha;
            strokeLineWidth2 = strokeLineWidth;
            strokeLineCap2 = strokeLineCap;
            strokeLineJoin2 = strokeLineJoin;
            strokeLineMiter2 = strokeLineMiter;
            trimPathStart2 = trimPathStart;
            trimPathEnd2 = trimPathEnd;
            trimPathOffset2 = trimPathOffset;
        } else {
            int pathFillType3 = i2 != 0 ? VectorKt.getDefaultFillType() : pathFillType;
            String name3 = i3 != 0 ? "" : name;
            Brush fill3 = i4 != 0 ? null : fill;
            float fillAlpha3 = i5 != 0 ? 1.0f : fillAlpha;
            Brush stroke3 = i6 != 0 ? null : stroke;
            float strokeAlpha3 = i7 != 0 ? 1.0f : strokeAlpha;
            float strokeLineWidth3 = i8 != 0 ? 0.0f : strokeLineWidth;
            int strokeLineCap3 = i9 != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap;
            int strokeLineJoin3 = i10 != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin;
            float strokeLineMiter3 = i11 != 0 ? 4.0f : strokeLineMiter;
            float trimPathStart3 = i12 != 0 ? 0.0f : trimPathStart;
            float trimPathEnd3 = i13 != 0 ? 1.0f : trimPathEnd;
            float trimPathOffset3 = i14 != 0 ? 0.0f : trimPathOffset;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1478270750, $dirty, $dirty1, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:114)");
            }
            final Function0 factory$iv = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PathComponent invoke() {
                    return new PathComponent();
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 1886828752, "CC(ComposeNode):Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.graphics.vector.PathComponent, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final PathComponent invoke() {
                        return factory$iv.invoke();
                    }
                });
            } else {
                $composer2.useNode();
            }
            Composer $this$Path_9cdaXJ4_u24lambda_u242 = Updater.m3547constructorimpl($composer2);
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, name3, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str) {
                    invoke2(pathComponent, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PathComponent $this$set, String it) {
                    $this$set.setName(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list2) {
                    invoke2(pathComponent, list2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PathComponent $this$set, List<? extends PathNode> list2) {
                    $this$set.setPathData(list2);
                }
            });
            pathFillType2 = pathFillType3;
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, PathFillType.m4326boximpl(pathFillType3), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType4) {
                    m4762invokepweu1eQ(pathComponent, pathFillType4.getValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
                public final void m4762invokepweu1eQ(PathComponent $this$set, int it) {
                    $this$set.m4754setPathFillTypeoQ8Xj4U(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, fill3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush) {
                    invoke2(pathComponent, brush);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PathComponent $this$set, Brush it) {
                    $this$set.setFill(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(fillAlpha3), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                    invoke(pathComponent, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PathComponent $this$set, float it) {
                    $this$set.setFillAlpha(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, stroke3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush) {
                    invoke2(pathComponent, brush);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PathComponent $this$set, Brush it) {
                    $this$set.setStroke(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeAlpha3), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                    invoke(pathComponent, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PathComponent $this$set, float it) {
                    $this$set.setStrokeAlpha(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeLineWidth3), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                    invoke(pathComponent, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PathComponent $this$set, float it) {
                    $this$set.setStrokeLineWidth(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, StrokeJoin.m4407boximpl(strokeLineJoin3), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                    m4763invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-kLtJ_vA, reason: not valid java name */
                public final void m4763invokekLtJ_vA(PathComponent $this$set, int it) {
                    $this$set.m4756setStrokeLineJoinWw9F2mQ(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, StrokeCap.m4397boximpl(strokeLineCap3), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                    m4761invokeCSYIeUk(pathComponent, strokeCap.getValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-CSYIeUk, reason: not valid java name */
                public final void m4761invokeCSYIeUk(PathComponent $this$set, int it) {
                    $this$set.m4755setStrokeLineCapBeK7IIE(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(strokeLineMiter3), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                    invoke(pathComponent, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PathComponent $this$set, float it) {
                    $this$set.setStrokeLineMiter(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathStart3), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                    invoke(pathComponent, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PathComponent $this$set, float it) {
                    $this$set.setTrimPathStart(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathEnd3), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                    invoke(pathComponent, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PathComponent $this$set, float it) {
                    $this$set.setTrimPathEnd(it);
                }
            });
            Updater.m3554setimpl($this$Path_9cdaXJ4_u24lambda_u242, Float.valueOf(trimPathOffset3), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                    invoke(pathComponent, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PathComponent $this$set, float it) {
                    $this$set.setTrimPathOffset(it);
                }
            });
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            trimPathOffset2 = trimPathOffset3;
            trimPathEnd2 = trimPathEnd3;
            strokeLineWidth2 = strokeLineWidth3;
            strokeLineCap2 = strokeLineCap3;
            strokeLineJoin2 = strokeLineJoin3;
            strokeLineMiter2 = strokeLineMiter3;
            trimPathStart2 = trimPathStart3;
            name2 = name3;
            fill2 = fill3;
            fillAlpha2 = fillAlpha3;
            stroke2 = stroke3;
            strokeAlpha2 = strokeAlpha3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i15 = pathFillType2;
            final String str = name2;
            final Brush brush = fill2;
            final float f = fillAlpha2;
            final Brush brush2 = stroke2;
            final float f2 = strokeAlpha2;
            final float f3 = strokeLineWidth2;
            final int i16 = strokeLineCap2;
            final int i17 = strokeLineJoin2;
            final float f4 = strokeLineMiter2;
            final float f5 = trimPathStart2;
            final float f6 = trimPathEnd2;
            final float f7 = trimPathOffset2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
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

                public final void invoke(Composer composer, int i18) {
                    VectorComposeKt.m4760Path9cdaXJ4(list, i15, str, brush, f, brush2, f2, f3, i16, i17, f4, f5, f6, f7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
