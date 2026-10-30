package androidx.compose.p001ui.graphics.drawscope;

import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.ClipOp;
import androidx.compose.p001ui.graphics.DegreesKt;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: compiled from: DrawScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001ab\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aP\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\\\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a!\u0010#\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\bH\u0086\b\u001a.\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001a:\u0010$\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001aF\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001aB\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aB\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b/\u0010,\u001aB\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00100\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u0010,\u001aJ\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a:\u00106\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001a?\u00107\u001a\u00020\u0001*\u00020\u00022\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, m195d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", DownloadUtil.CookieScheme.PATH, "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "draw", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-ymL40Pk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DrawScopeKt {
    public static final void inset(DrawScope $this$inset, float left, float top, float right, float bottom, Function1<? super DrawScope, Unit> function1) {
        $this$inset.getDrawContext().getTransform().inset(left, top, right, bottom);
        try {
            function1.invoke($this$inset);
        } finally {
            InlineMarker.finallyStart(1);
            $this$inset.getDrawContext().getTransform().inset(-left, -top, -right, -bottom);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void inset(DrawScope $this$inset, float inset, Function1<? super DrawScope, Unit> function1) {
        $this$inset.getDrawContext().getTransform().inset(inset, inset, inset, inset);
        try {
            function1.invoke($this$inset);
        } finally {
            InlineMarker.finallyStart(1);
            $this$inset.getDrawContext().getTransform().inset(-inset, -inset, -inset, -inset);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void inset$default(DrawScope $this$inset_u24default, float horizontal, float vertical, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = 0.0f;
        }
        if ((i & 2) != 0) {
            vertical = 0.0f;
        }
        $this$inset_u24default.getDrawContext().getTransform().inset(horizontal, vertical, horizontal, vertical);
        try {
            block.invoke($this$inset_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            $this$inset_u24default.getDrawContext().getTransform().inset(-horizontal, -vertical, -horizontal, -vertical);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void inset(DrawScope $this$inset, float horizontal, float vertical, Function1<? super DrawScope, Unit> function1) {
        $this$inset.getDrawContext().getTransform().inset(horizontal, vertical, horizontal, vertical);
        try {
            function1.invoke($this$inset);
        } finally {
            InlineMarker.finallyStart(1);
            $this$inset.getDrawContext().getTransform().inset(-horizontal, -vertical, -horizontal, -vertical);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void translate$default(DrawScope $this$translate_u24default, float left, float top, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            left = 0.0f;
        }
        if ((i & 2) != 0) {
            top = 0.0f;
        }
        $this$translate_u24default.getDrawContext().getTransform().translate(left, top);
        try {
            block.invoke($this$translate_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            $this$translate_u24default.getDrawContext().getTransform().translate(-left, -top);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void translate(DrawScope $this$translate, float left, float top, Function1<? super DrawScope, Unit> function1) {
        $this$translate.getDrawContext().getTransform().translate(left, top);
        try {
            function1.invoke($this$translate);
        } finally {
            InlineMarker.finallyStart(1);
            $this$translate.getDrawContext().getTransform().translate(-left, -top);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m4907rotateRg1IO4c$default(DrawScope $this$rotate_u2dRg1IO4c_u24default, float degrees, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = $this$rotate_u2dRg1IO4c_u24default.mo4772getCenterF1C5BW0();
        }
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$rotate_u2dRg1IO4c_u24default.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$rotate_Rg1IO4c_u24lambda_u240.mo4785rotateUv8p0NA(degrees, pivot);
            block.invoke($this$rotate_u2dRg1IO4c_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m4906rotateRg1IO4c(DrawScope $this$rotate_u2dRg1IO4c, float degrees, long pivot, Function1<? super DrawScope, Unit> function1) {
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$rotate_u2dRg1IO4c.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$rotate_Rg1IO4c_u24lambda_u240.mo4785rotateUv8p0NA(degrees, pivot);
            function1.invoke($this$rotate_u2dRg1IO4c);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m4909rotateRadRg1IO4c$default(DrawScope $this$rotateRad_u2dRg1IO4c_u24default, float radians, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = $this$rotateRad_u2dRg1IO4c_u24default.mo4772getCenterF1C5BW0();
        }
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$rotateRad_u2dRg1IO4c_u24default.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$rotateRad_Rg1IO4c_u24lambda_u241 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$rotateRad_Rg1IO4c_u24lambda_u241.mo4785rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
            block.invoke($this$rotateRad_u2dRg1IO4c_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m4908rotateRadRg1IO4c(DrawScope $this$rotateRad_u2dRg1IO4c, float radians, long pivot, Function1<? super DrawScope, Unit> function1) {
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$rotateRad_u2dRg1IO4c.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$rotateRad_Rg1IO4c_u24lambda_u241 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$rotateRad_Rg1IO4c_u24lambda_u241.mo4785rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
            function1.invoke($this$rotateRad_u2dRg1IO4c);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m4911scaleFgt4K4Q$default(DrawScope $this$scale_u2dFgt4K4Q_u24default, float scaleX, float scaleY, long pivot, Function1 block, int i, Object obj) {
        if ((i & 4) != 0) {
            pivot = $this$scale_u2dFgt4K4Q_u24default.mo4772getCenterF1C5BW0();
        }
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$scale_u2dFgt4K4Q_u24default.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$scale_Fgt4K4Q_u24lambda_u242.mo4786scale0AR0LA0(scaleX, scaleY, pivot);
            block.invoke($this$scale_u2dFgt4K4Q_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m4910scaleFgt4K4Q(DrawScope $this$scale_u2dFgt4K4Q, float scaleX, float scaleY, long pivot, Function1<? super DrawScope, Unit> function1) {
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$scale_u2dFgt4K4Q.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$scale_Fgt4K4Q_u24lambda_u242.mo4786scale0AR0LA0(scaleX, scaleY, pivot);
            function1.invoke($this$scale_u2dFgt4K4Q);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m4913scaleRg1IO4c$default(DrawScope $this$scale_u2dRg1IO4c_u24default, float scale, long pivot, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = $this$scale_u2dRg1IO4c_u24default.mo4772getCenterF1C5BW0();
        }
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$scale_u2dRg1IO4c_u24default.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$scale_Rg1IO4c_u24lambda_u243 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$scale_Rg1IO4c_u24lambda_u243.mo4786scale0AR0LA0(scale, scale, pivot);
            block.invoke($this$scale_u2dRg1IO4c_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m4912scaleRg1IO4c(DrawScope $this$scale_u2dRg1IO4c, float scale, long pivot, Function1<? super DrawScope, Unit> function1) {
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$scale_u2dRg1IO4c.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$scale_Rg1IO4c_u24lambda_u243 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$scale_Rg1IO4c_u24lambda_u243.mo4786scale0AR0LA0(scale, scale, pivot);
            function1.invoke($this$scale_u2dRg1IO4c);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m4902clipRectrOu3jXo$default(DrawScope $this$clipRect_u2drOu3jXo_u24default, float left, float top, float right, float bottom, int clipOp, Function1 block, int i, Object obj) throws Throwable {
        long previousSize$iv;
        float left2 = (i & 1) != 0 ? 0.0f : left;
        float top2 = (i & 2) != 0 ? 0.0f : top;
        float right2 = (i & 4) != 0 ? Size.m4118getWidthimpl($this$clipRect_u2drOu3jXo_u24default.mo4773getSizeNHjbRc()) : right;
        float bottom2 = (i & 8) != 0 ? Size.m4115getHeightimpl($this$clipRect_u2drOu3jXo_u24default.mo4773getSizeNHjbRc()) : bottom;
        int clipOp2 = (i & 16) != 0 ? ClipOp.INSTANCE.m4280getIntersectrtfAjoo() : clipOp;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$clipRect_u2drOu3jXo_u24default.getDrawContext();
        long previousSize$iv2 = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244 = $this$withTransform_u24lambda_u246$iv.getTransform();
            float f = left2;
            previousSize$iv = previousSize$iv2;
            try {
                $this$clipRect_rOu3jXo_u24lambda_u244.mo4782clipRectN_I0leg(f, top2, right2, bottom2, clipOp2);
                try {
                    block.invoke($this$clipRect_u2drOu3jXo_u24default);
                    InlineMarker.finallyStart(1);
                    $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
                    InlineMarker.finallyEnd(1);
                } catch (Throwable th) {
                    th = th;
                    InlineMarker.finallyStart(1);
                    $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            previousSize$iv = previousSize$iv2;
        }
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m4901clipRectrOu3jXo(DrawScope $this$clipRect_u2drOu3jXo, float left, float top, float right, float bottom, int clipOp, Function1<? super DrawScope, Unit> function1) throws Throwable {
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$clipRect_u2drOu3jXo.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$clipRect_rOu3jXo_u24lambda_u244.mo4782clipRectN_I0leg(left, top, right, bottom, clipOp);
            try {
                function1.invoke($this$clipRect_u2drOu3jXo);
                InlineMarker.finallyStart(1);
                $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                th = th;
                InlineMarker.finallyStart(1);
                $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m4900clipPathKD09W0M$default(DrawScope $this$clipPath_u2dKD09W0M_u24default, Path path, int clipOp, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            clipOp = ClipOp.INSTANCE.m4280getIntersectrtfAjoo();
        }
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$clipPath_u2dKD09W0M_u24default.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$clipPath_KD09W0M_u24lambda_u245 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$clipPath_KD09W0M_u24lambda_u245.mo4781clipPathmtrdDE(path, clipOp);
            block.invoke($this$clipPath_u2dKD09W0M_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m4899clipPathKD09W0M(DrawScope $this$clipPath_u2dKD09W0M, Path path, int clipOp, Function1<? super DrawScope, Unit> function1) {
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$clipPath_u2dKD09W0M.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        try {
            DrawTransform $this$clipPath_KD09W0M_u24lambda_u245 = $this$withTransform_u24lambda_u246$iv.getTransform();
            $this$clipPath_KD09W0M_u24lambda_u245.mo4781clipPathmtrdDE(path, clipOp);
            function1.invoke($this$clipPath_u2dKD09W0M);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv.mo4780setSizeuvyYCjk(previousSize$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void drawIntoCanvas(DrawScope $this$drawIntoCanvas, Function1<? super Canvas, Unit> function1) {
        function1.invoke($this$drawIntoCanvas.getDrawContext().getCanvas());
    }

    public static final void withTransform(DrawScope $this$withTransform, Function1<? super DrawTransform, Unit> function1, Function1<? super DrawScope, Unit> function2) {
        DrawContext $this$withTransform_u24lambda_u246 = $this$withTransform.getDrawContext();
        long previousSize = $this$withTransform_u24lambda_u246.mo4779getSizeNHjbRc();
        $this$withTransform_u24lambda_u246.getCanvas().save();
        try {
            function1.invoke($this$withTransform_u24lambda_u246.getTransform());
            function2.invoke($this$withTransform);
        } finally {
            InlineMarker.finallyStart(1);
            $this$withTransform_u24lambda_u246.getCanvas().restore();
            $this$withTransform_u24lambda_u246.mo4780setSizeuvyYCjk(previousSize);
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use a new overload accepting nullable GraphicsLayer")
    /* JADX INFO: renamed from: draw-GRGpd60, reason: not valid java name */
    public static final /* synthetic */ void m4903drawGRGpd60(DrawScope $this$draw_u2dGRGpd60, Density density, LayoutDirection layoutDirection, Canvas canvas, long size, Function1<? super DrawScope, Unit> function1) {
        Density prevDensity$iv = $this$draw_u2dGRGpd60.getDrawContext().getDensity();
        LayoutDirection prevLayoutDirection$iv = $this$draw_u2dGRGpd60.getDrawContext().getLayoutDirection();
        Canvas prevCanvas$iv = $this$draw_u2dGRGpd60.getDrawContext().getCanvas();
        long prevSize$iv = $this$draw_u2dGRGpd60.getDrawContext().mo4779getSizeNHjbRc();
        GraphicsLayer prevLayer$iv = $this$draw_u2dGRGpd60.getDrawContext().getGraphicsLayer();
        DrawContext $this$draw_ymL40Pk_u24lambda_u247$iv = $this$draw_u2dGRGpd60.getDrawContext();
        $this$draw_ymL40Pk_u24lambda_u247$iv.setDensity(density);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setLayoutDirection(layoutDirection);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setCanvas(canvas);
        $this$draw_ymL40Pk_u24lambda_u247$iv.mo4780setSizeuvyYCjk(size);
        $this$draw_ymL40Pk_u24lambda_u247$iv.setGraphicsLayer(null);
        canvas.save();
        try {
            function1.invoke($this$draw_u2dGRGpd60);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext $this$draw_ymL40Pk_u24lambda_u248$iv = $this$draw_u2dGRGpd60.getDrawContext();
            $this$draw_ymL40Pk_u24lambda_u248$iv.setDensity(prevDensity$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setLayoutDirection(prevLayoutDirection$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setCanvas(prevCanvas$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.mo4780setSizeuvyYCjk(prevSize$iv);
            $this$draw_ymL40Pk_u24lambda_u248$iv.setGraphicsLayer(prevLayer$iv);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: draw-ymL40Pk$default, reason: not valid java name */
    public static /* synthetic */ void m4905drawymL40Pk$default(DrawScope $this$draw_u2dymL40Pk_u24default, Density density, LayoutDirection layoutDirection, Canvas canvas, long size, GraphicsLayer graphicsLayer, Function1 block, int i, Object obj) {
        GraphicsLayer graphicsLayer2 = (i & 16) != 0 ? null : graphicsLayer;
        Density prevDensity = $this$draw_u2dymL40Pk_u24default.getDrawContext().getDensity();
        LayoutDirection prevLayoutDirection = $this$draw_u2dymL40Pk_u24default.getDrawContext().getLayoutDirection();
        Canvas prevCanvas = $this$draw_u2dymL40Pk_u24default.getDrawContext().getCanvas();
        long prevSize = $this$draw_u2dymL40Pk_u24default.getDrawContext().mo4779getSizeNHjbRc();
        GraphicsLayer prevLayer = $this$draw_u2dymL40Pk_u24default.getDrawContext().getGraphicsLayer();
        DrawContext $this$draw_ymL40Pk_u24lambda_u247 = $this$draw_u2dymL40Pk_u24default.getDrawContext();
        $this$draw_ymL40Pk_u24lambda_u247.setDensity(density);
        $this$draw_ymL40Pk_u24lambda_u247.setLayoutDirection(layoutDirection);
        $this$draw_ymL40Pk_u24lambda_u247.setCanvas(canvas);
        $this$draw_ymL40Pk_u24lambda_u247.mo4780setSizeuvyYCjk(size);
        $this$draw_ymL40Pk_u24lambda_u247.setGraphicsLayer(graphicsLayer2);
        canvas.save();
        try {
            block.invoke($this$draw_u2dymL40Pk_u24default);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext $this$draw_ymL40Pk_u24lambda_u248 = $this$draw_u2dymL40Pk_u24default.getDrawContext();
            $this$draw_ymL40Pk_u24lambda_u248.setDensity(prevDensity);
            $this$draw_ymL40Pk_u24lambda_u248.setLayoutDirection(prevLayoutDirection);
            $this$draw_ymL40Pk_u24lambda_u248.setCanvas(prevCanvas);
            $this$draw_ymL40Pk_u24lambda_u248.mo4780setSizeuvyYCjk(prevSize);
            $this$draw_ymL40Pk_u24lambda_u248.setGraphicsLayer(prevLayer);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: draw-ymL40Pk, reason: not valid java name */
    public static final void m4904drawymL40Pk(DrawScope $this$draw_u2dymL40Pk, Density density, LayoutDirection layoutDirection, Canvas canvas, long size, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1) {
        Density prevDensity = $this$draw_u2dymL40Pk.getDrawContext().getDensity();
        LayoutDirection prevLayoutDirection = $this$draw_u2dymL40Pk.getDrawContext().getLayoutDirection();
        Canvas prevCanvas = $this$draw_u2dymL40Pk.getDrawContext().getCanvas();
        long prevSize = $this$draw_u2dymL40Pk.getDrawContext().mo4779getSizeNHjbRc();
        GraphicsLayer prevLayer = $this$draw_u2dymL40Pk.getDrawContext().getGraphicsLayer();
        DrawContext $this$draw_ymL40Pk_u24lambda_u247 = $this$draw_u2dymL40Pk.getDrawContext();
        $this$draw_ymL40Pk_u24lambda_u247.setDensity(density);
        $this$draw_ymL40Pk_u24lambda_u247.setLayoutDirection(layoutDirection);
        $this$draw_ymL40Pk_u24lambda_u247.setCanvas(canvas);
        $this$draw_ymL40Pk_u24lambda_u247.mo4780setSizeuvyYCjk(size);
        $this$draw_ymL40Pk_u24lambda_u247.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke($this$draw_u2dymL40Pk);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext $this$draw_ymL40Pk_u24lambda_u248 = $this$draw_u2dymL40Pk.getDrawContext();
            $this$draw_ymL40Pk_u24lambda_u248.setDensity(prevDensity);
            $this$draw_ymL40Pk_u24lambda_u248.setLayoutDirection(prevLayoutDirection);
            $this$draw_ymL40Pk_u24lambda_u248.setCanvas(prevCanvas);
            $this$draw_ymL40Pk_u24lambda_u248.mo4780setSizeuvyYCjk(prevSize);
            $this$draw_ymL40Pk_u24lambda_u248.setGraphicsLayer(prevLayer);
            InlineMarker.finallyEnd(1);
        }
    }
}
