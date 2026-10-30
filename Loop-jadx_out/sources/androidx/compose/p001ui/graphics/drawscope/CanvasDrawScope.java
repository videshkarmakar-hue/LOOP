package androidx.compose.p001ui.graphics.drawscope;

import androidx.compose.p001ui.geometry.CornerRadius;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p001ui.graphics.BlendMode;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.FilterQuality;
import androidx.compose.p001ui.graphics.ImageBitmap;
import androidx.compose.p001ui.graphics.Paint;
import androidx.compose.p001ui.graphics.PaintingStyle;
import androidx.compose.p001ui.graphics.Path;
import androidx.compose.p001ui.graphics.PathEffect;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.StrokeJoin;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpRect;
import androidx.compose.p001ui.unit.FontScaling;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CanvasDrawScope.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002\u0092\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&JH\u0010\u0019\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*Jl\u0010+\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105Jj\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107JL\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090@¢\u0006\u0002\bAH\u0086\bø\u0001\u0000¢\u0006\u0004\bB\u0010CJf\u0010D\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJf\u0010D\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bM\u0010NJN\u0010O\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bR\u0010SJN\u0010O\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJF\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010I\u001a\u00020J2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ^\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0017ø\u0001\u0000¢\u0006\u0004\ba\u0010bJf\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\bc\u0010dJ`\u0010e\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ`\u0010e\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bj\u0010kJN\u0010l\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bm\u0010nJN\u0010l\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bo\u0010pJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bt\u0010uJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010'\u001a\u00020(2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\bv\u0010wJf\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\b}\u0010~Jg\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001JP\u0010\u0081\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0082\u0001\u0010nJP\u0010\u0081\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\b\u0083\u0001\u0010pJ[\u0010\u0084\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\b\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J[\u0010\u0084\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\t\u0010\u008b\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u008c\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020\u00112\u0007\u0010\u008e\u0001\u001a\u00020\u001dH\u0002J!\u0010\u008f\u0001\u001a\u00020(*\u00020(2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0093\u0001"}, m195d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "()V", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "strokePaint", "configurePaint", "brush", "Landroidx/compose/ui/graphics/Brush;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "strokeWidth", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "draw", "", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", DownloadUtil.CookieScheme.PATH, "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CanvasDrawScope implements DrawScope {
    private Paint fillPaint;
    private Paint strokePaint;
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1
        private GraphicsLayer graphicsLayer;
        private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public Canvas getCanvas() {
            return this.this$0.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public void setCanvas(Canvas value) {
            this.this$0.getDrawParams().setCanvas(value);
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo4779getSizeNHjbRc() {
            return this.this$0.getDrawParams().m4777getSizeNHjbRc();
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo4780setSizeuvyYCjk(long value) {
            this.this$0.getDrawParams().m4778setSizeuvyYCjk(value);
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public LayoutDirection getLayoutDirection() {
            return this.this$0.getDrawParams().getLayoutDirection();
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public void setLayoutDirection(LayoutDirection value) {
            this.this$0.getDrawParams().setLayoutDirection(value);
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public Density getDensity() {
            return this.this$0.getDrawParams().getDensity();
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public void setDensity(Density value) {
            this.this$0.getDrawParams().setDensity(value);
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // androidx.compose.p001ui.graphics.drawscope.DrawContext
        public void setGraphicsLayer(GraphicsLayer graphicsLayer) {
            this.graphicsLayer = graphicsLayer;
        }
    };

    public static /* synthetic */ void getDrawParams$annotations() {
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: buildLayer-JVtK1S4, reason: not valid java name */
    public /* synthetic */ GraphicsLayer mo4751buildLayerJVtK1S4(GraphicsLayer graphicsLayer, long j, Function1 function1) {
        return DrawScope.CC.m4820$default$buildLayerJVtK1S4(this, graphicsLayer, j, function1);
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public /* synthetic */ long mo4772getCenterF1C5BW0() {
        return DrawScope.CC.m4822$default$getCenterF1C5BW0(this);
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public /* synthetic */ long mo4773getSizeNHjbRc() {
        return DrawScope.CC.m4823$default$getSizeNHjbRc(this);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo560roundToPxR2X_6o(long j) {
        return Density.CC.m6765$default$roundToPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo561roundToPx0680j_4(float f) {
        return Density.CC.m6766$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo562toDpGaN1DYA(long j) {
        return FontScaling.CC.m6910$default$toDpGaN1DYA(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo563toDpu2uoSUM(float f) {
        return Density.CC.m6767$default$toDpu2uoSUM(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo564toDpu2uoSUM(int i) {
        return Density.CC.m6768$default$toDpu2uoSUM((Density) this, i);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo565toDpSizekrfVVM(long j) {
        return Density.CC.m6769$default$toDpSizekrfVVM(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo566toPxR2X_6o(long j) {
        return Density.CC.m6770$default$toPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo567toPx0680j_4(float f) {
        return Density.CC.m6771$default$toPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo568toSizeXkaWNTQ(long j) {
        return Density.CC.m6772$default$toSizeXkaWNTQ(this, j);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo569toSp0xMU5do(float f) {
        return FontScaling.CC.m6911$default$toSp0xMU5do(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo570toSpkPz2Gy4(float f) {
        return Density.CC.m6773$default$toSpkPz2Gy4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo571toSpkPz2Gy4(int i) {
        return Density.CC.m6774$default$toSpkPz2Gy4((Density) this, i);
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    @Override // androidx.compose.p001ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo4760drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4150drawLineWko1d7g(start, end, m4749configureStrokePaintho4zsrM$default(this, brush, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m4663getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo4761drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4150drawLineWko1d7g(start, end, m4747configureStrokePaintQ_0CZUI$default(this, color, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m4663getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo4768drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRect(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), m4745configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo4769drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRect(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), m4743configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo4759drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4148drawImaged4ec7I(image, topLeft, m4745configurePaintswdJneE$default(this, null, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* JADX INFO: renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void mo4757drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4149drawImageRectHPBpro0(image, srcOffset, srcSize, dstOffset, dstSize, m4745configurePaintswdJneE$default(this, null, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo4758drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.drawParams.getCanvas().mo4149drawImageRectHPBpro0(image, srcOffset, srcSize, dstOffset, dstSize, m4744configurePaintswdJneE(null, style, alpha, colorFilter, blendMode, filterQuality));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo4770drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), CornerRadius.m4024getXimpl(cornerRadius), CornerRadius.m4025getYimpl(cornerRadius), m4745configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo4771drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), CornerRadius.m4024getXimpl(cornerRadius), CornerRadius.m4025getYimpl(cornerRadius), m4743configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void mo4755drawCircleV9BoPsw(Brush brush, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4147drawCircle9KIMszo(center, radius, m4745configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo4756drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4147drawCircle9KIMszo(center, radius, m4743configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void mo4762drawOvalAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawOval(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), m4745configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void mo4763drawOvalnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawOval(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), m4743configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I, reason: not valid java name */
    public void mo4753drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawArc(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), startAngle, sweepAngle, useCenter, m4745configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo4754drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawArc(Offset.m4049getXimpl(topLeft), Offset.m4050getYimpl(topLeft), Offset.m4049getXimpl(topLeft) + Size.m4118getWidthimpl(size), Offset.m4050getYimpl(topLeft) + Size.m4115getHeightimpl(size), startAngle, sweepAngle, useCenter, m4743configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo4765drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, m4743configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo4764drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, m4745configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void mo4766drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4151drawPointsO7TthRY(pointMode, points, m4747configureStrokePaintQ_0CZUI$default(this, color, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m4663getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.p001ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void mo4767drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo4151drawPointsO7TthRY(pointMode, points, m4749configureStrokePaintho4zsrM$default(this, brush, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m4663getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    /* JADX INFO: renamed from: draw-yzxVdVo, reason: not valid java name */
    public final void m4752drawyzxVdVo(Density density, LayoutDirection layoutDirection, Canvas canvas, long size, Function1<? super DrawScope, Unit> block) {
        DrawParams drawParams = getDrawParams();
        Density prevDensity = drawParams.getDensity();
        LayoutDirection prevLayoutDirection = drawParams.getLayoutDirection();
        Canvas prevCanvas = drawParams.getCanvas();
        long prevSize = drawParams.getSize();
        DrawParams $this$draw_yzxVdVo_u24lambda_u240 = getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240.setDensity(density);
        $this$draw_yzxVdVo_u24lambda_u240.setLayoutDirection(layoutDirection);
        $this$draw_yzxVdVo_u24lambda_u240.setCanvas(canvas);
        $this$draw_yzxVdVo_u24lambda_u240.m4778setSizeuvyYCjk(size);
        canvas.save();
        block.invoke(this);
        canvas.restore();
        DrawParams $this$draw_yzxVdVo_u24lambda_u241 = getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241.setDensity(prevDensity);
        $this$draw_yzxVdVo_u24lambda_u241.setLayoutDirection(prevLayoutDirection);
        $this$draw_yzxVdVo_u24lambda_u241.setCanvas(prevCanvas);
        $this$draw_yzxVdVo_u24lambda_u241.m4778setSizeuvyYCjk(prevSize);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint == null) {
            Paint $this$obtainFillPaint_u24lambda_u242 = AndroidPaint_androidKt.Paint();
            $this$obtainFillPaint_u24lambda_u242.mo4174setStylek9PVt8s(PaintingStyle.INSTANCE.m4565getFillTiuSbCo());
            this.fillPaint = $this$obtainFillPaint_u24lambda_u242;
            return $this$obtainFillPaint_u24lambda_u242;
        }
        return paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint == null) {
            Paint $this$obtainStrokePaint_u24lambda_u244 = AndroidPaint_androidKt.Paint();
            $this$obtainStrokePaint_u24lambda_u244.mo4174setStylek9PVt8s(PaintingStyle.INSTANCE.m4566getStrokeTiuSbCo());
            this.strokePaint = $this$obtainStrokePaint_u24lambda_u244;
            return $this$obtainStrokePaint_u24lambda_u244;
        }
        return paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (drawStyle instanceof Stroke) {
            Paint $this$selectPaint_u24lambda_u246 = obtainStrokePaint();
            if (!($this$selectPaint_u24lambda_u246.getStrokeWidth() == ((Stroke) drawStyle).getWidth())) {
                $this$selectPaint_u24lambda_u246.setStrokeWidth(((Stroke) drawStyle).getWidth());
            }
            if (!StrokeCap.m4648equalsimpl0($this$selectPaint_u24lambda_u246.mo4166getStrokeCapKaPHkGw(), ((Stroke) drawStyle).getCap())) {
                $this$selectPaint_u24lambda_u246.mo4172setStrokeCapBeK7IIE(((Stroke) drawStyle).getCap());
            }
            if (!($this$selectPaint_u24lambda_u246.getStrokeMiterLimit() == ((Stroke) drawStyle).getMiter())) {
                $this$selectPaint_u24lambda_u246.setStrokeMiterLimit(((Stroke) drawStyle).getMiter());
            }
            if (!StrokeJoin.m4658equalsimpl0($this$selectPaint_u24lambda_u246.mo4167getStrokeJoinLxFBmk8(), ((Stroke) drawStyle).getJoin())) {
                $this$selectPaint_u24lambda_u246.mo4173setStrokeJoinWw9F2mQ(((Stroke) drawStyle).getJoin());
            }
            if (!Intrinsics.areEqual($this$selectPaint_u24lambda_u246.getPathEffect(), ((Stroke) drawStyle).getPathEffect())) {
                $this$selectPaint_u24lambda_u246.setPathEffect(((Stroke) drawStyle).getPathEffect());
                return $this$selectPaint_u24lambda_u246;
            }
            return $this$selectPaint_u24lambda_u246;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    static /* synthetic */ Paint m4745configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        int iM4862getDefaultFilterQualityfv9h1I;
        if ((i3 & 32) == 0) {
            iM4862getDefaultFilterQualityfv9h1I = i2;
        } else {
            iM4862getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m4744configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, iM4862getDefaultFilterQualityfv9h1I);
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m4744configurePaintswdJneE(Brush brush, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint $this$configurePaint_swdJneE_u24lambda_u247 = selectPaint(style);
        if (brush != null) {
            brush.mo4238applyToPq9zytI(mo4773getSizeNHjbRc(), $this$configurePaint_swdJneE_u24lambda_u247, alpha);
        } else {
            if ($this$configurePaint_swdJneE_u24lambda_u247.getInternalShader() != null) {
                $this$configurePaint_swdJneE_u24lambda_u247.setShader(null);
            }
            if (!Color.m4292equalsimpl0($this$configurePaint_swdJneE_u24lambda_u247.mo4164getColor0d7_KjU(), Color.INSTANCE.m4317getBlack0d7_KjU())) {
                $this$configurePaint_swdJneE_u24lambda_u247.mo4170setColor8_81llA(Color.INSTANCE.m4317getBlack0d7_KjU());
            }
            if (!($this$configurePaint_swdJneE_u24lambda_u247.getAlpha() == alpha)) {
                $this$configurePaint_swdJneE_u24lambda_u247.setAlpha(alpha);
            }
        }
        if (!Intrinsics.areEqual($this$configurePaint_swdJneE_u24lambda_u247.getInternalColorFilter(), colorFilter)) {
            $this$configurePaint_swdJneE_u24lambda_u247.setColorFilter(colorFilter);
        }
        if (!BlendMode.m4202equalsimpl0($this$configurePaint_swdJneE_u24lambda_u247.get_blendMode(), blendMode)) {
            $this$configurePaint_swdJneE_u24lambda_u247.mo4169setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m4386equalsimpl0($this$configurePaint_swdJneE_u24lambda_u247.mo4165getFilterQualityfv9h1I(), filterQuality)) {
            $this$configurePaint_swdJneE_u24lambda_u247.mo4171setFilterQualityvDHp3xo(filterQuality);
        }
        return $this$configurePaint_swdJneE_u24lambda_u247;
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    static /* synthetic */ Paint m4743configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        int iM4862getDefaultFilterQualityfv9h1I;
        if ((i3 & 32) == 0) {
            iM4862getDefaultFilterQualityfv9h1I = i2;
        } else {
            iM4862getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m4742configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, iM4862getDefaultFilterQualityfv9h1I);
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m4742configurePaint2qPWKa0(long color, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint $this$configurePaint_2qPWKa0_u24lambda_u248 = selectPaint(style);
        long targetColor = m4750modulate5vOe2sY(color, alpha);
        if (!Color.m4292equalsimpl0($this$configurePaint_2qPWKa0_u24lambda_u248.mo4164getColor0d7_KjU(), targetColor)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.mo4170setColor8_81llA(targetColor);
        }
        if ($this$configurePaint_2qPWKa0_u24lambda_u248.getInternalShader() != null) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.setShader(null);
        }
        if (!Intrinsics.areEqual($this$configurePaint_2qPWKa0_u24lambda_u248.getInternalColorFilter(), colorFilter)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.setColorFilter(colorFilter);
        }
        if (!BlendMode.m4202equalsimpl0($this$configurePaint_2qPWKa0_u24lambda_u248.get_blendMode(), blendMode)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.mo4169setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m4386equalsimpl0($this$configurePaint_2qPWKa0_u24lambda_u248.mo4165getFilterQualityfv9h1I(), filterQuality)) {
            $this$configurePaint_2qPWKa0_u24lambda_u248.mo4171setFilterQualityvDHp3xo(filterQuality);
        }
        return $this$configurePaint_2qPWKa0_u24lambda_u248;
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    static /* synthetic */ Paint m4747configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        int iM4862getDefaultFilterQualityfv9h1I;
        if ((i5 & 512) == 0) {
            iM4862getDefaultFilterQualityfv9h1I = i4;
        } else {
            iM4862getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m4746configureStrokePaintQ_0CZUI(j, f, f2, i, i2, pathEffect, f3, colorFilter, i3, iM4862getDefaultFilterQualityfv9h1I);
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m4746configureStrokePaintQ_0CZUI(long color, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint $this$configureStrokePaint_Q_0CZUI_u24lambda_u249 = obtainStrokePaint();
        long targetColor = m4750modulate5vOe2sY(color, alpha);
        if (!Color.m4292equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4164getColor0d7_KjU(), targetColor)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4170setColor8_81llA(targetColor);
        }
        if ($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getInternalShader() != null) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setShader(null);
        }
        if (!Intrinsics.areEqual($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getInternalColorFilter(), colorFilter)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setColorFilter(colorFilter);
        }
        if (!BlendMode.m4202equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.get_blendMode(), blendMode)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4169setBlendModes9anfk8(blendMode);
        }
        if (!($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getStrokeWidth() == strokeWidth)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setStrokeWidth(strokeWidth);
        }
        if (!($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getStrokeMiterLimit() == miter)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setStrokeMiterLimit(miter);
        }
        if (!StrokeCap.m4648equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4166getStrokeCapKaPHkGw(), cap)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4172setStrokeCapBeK7IIE(cap);
        }
        if (!StrokeJoin.m4658equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4167getStrokeJoinLxFBmk8(), join)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4173setStrokeJoinWw9F2mQ(join);
        }
        if (!Intrinsics.areEqual($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.getPathEffect(), pathEffect)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m4386equalsimpl0($this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4165getFilterQualityfv9h1I(), filterQuality)) {
            $this$configureStrokePaint_Q_0CZUI_u24lambda_u249.mo4171setFilterQualityvDHp3xo(filterQuality);
        }
        return $this$configureStrokePaint_Q_0CZUI_u24lambda_u249;
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    static /* synthetic */ Paint m4749configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        int iM4862getDefaultFilterQualityfv9h1I;
        if ((i5 & 512) == 0) {
            iM4862getDefaultFilterQualityfv9h1I = i4;
        } else {
            iM4862getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m4862getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m4748configureStrokePaintho4zsrM(brush, f, f2, i, i2, pathEffect, f3, colorFilter, i3, iM4862getDefaultFilterQualityfv9h1I);
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m4748configureStrokePaintho4zsrM(Brush brush, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint $this$configureStrokePaint_ho4zsrM_u24lambda_u2410 = obtainStrokePaint();
        if (brush != null) {
            brush.mo4238applyToPq9zytI(mo4773getSizeNHjbRc(), $this$configureStrokePaint_ho4zsrM_u24lambda_u2410, alpha);
        } else {
            if (!($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getAlpha() == alpha)) {
                $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setAlpha(alpha);
            }
        }
        if (!Intrinsics.areEqual($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getInternalColorFilter(), colorFilter)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setColorFilter(colorFilter);
        }
        if (!BlendMode.m4202equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.get_blendMode(), blendMode)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.mo4169setBlendModes9anfk8(blendMode);
        }
        if (!($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getStrokeWidth() == strokeWidth)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setStrokeWidth(strokeWidth);
        }
        if (!($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getStrokeMiterLimit() == miter)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setStrokeMiterLimit(miter);
        }
        if (!StrokeCap.m4648equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.mo4166getStrokeCapKaPHkGw(), cap)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.mo4172setStrokeCapBeK7IIE(cap);
        }
        if (!StrokeJoin.m4658equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.mo4167getStrokeJoinLxFBmk8(), join)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.mo4173setStrokeJoinWw9F2mQ(join);
        }
        if (!Intrinsics.areEqual($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.getPathEffect(), pathEffect)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m4386equalsimpl0($this$configureStrokePaint_ho4zsrM_u24lambda_u2410.mo4165getFilterQualityfv9h1I(), filterQuality)) {
            $this$configureStrokePaint_ho4zsrM_u24lambda_u2410.mo4171setFilterQualityvDHp3xo(filterQuality);
        }
        return $this$configureStrokePaint_ho4zsrM_u24lambda_u2410;
    }

    /* JADX INFO: renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m4750modulate5vOe2sY(long $this$modulate_u2d5vOe2sY, float alpha) {
        if (!(alpha == 1.0f)) {
            return Color.m4289copywmQWz5c($this$modulate_u2d5vOe2sY, (14 & 1) != 0 ? Color.m4293getAlphaimpl($this$modulate_u2d5vOe2sY) : Color.m4293getAlphaimpl($this$modulate_u2d5vOe2sY) * alpha, (14 & 2) != 0 ? Color.m4297getRedimpl($this$modulate_u2d5vOe2sY) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl($this$modulate_u2d5vOe2sY) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl($this$modulate_u2d5vOe2sY) : 0.0f);
        }
        return $this$modulate_u2d5vOe2sY;
    }

    /* JADX INFO: compiled from: CanvasDrawScope.kt */
    @Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0016\u0010\u001f\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u00020\tX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m195d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, canvas, j);
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss$default, reason: not valid java name */
        public static /* synthetic */ DrawParams m4774copyUg5Nnss$default(DrawParams drawParams, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                density = drawParams.density;
            }
            if ((i & 2) != 0) {
                layoutDirection = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection2 = layoutDirection;
            if ((i & 4) != 0) {
                canvas = drawParams.canvas;
            }
            Canvas canvas2 = canvas;
            if ((i & 8) != 0) {
                j = drawParams.size;
            }
            return drawParams.m4776copyUg5Nnss(density, layoutDirection2, canvas2, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Density getDensity() {
            return this.density;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Canvas getCanvas() {
            return this.canvas;
        }

        /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss, reason: not valid java name */
        public final DrawParams m4776copyUg5Nnss(Density density, LayoutDirection layoutDirection, Canvas canvas, long size) {
            return new DrawParams(density, layoutDirection, canvas, size, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) other;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m4114equalsimpl0(this.size, drawParams.size);
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m4119hashCodeimpl(this.size);
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m4122toStringimpl(this.size)) + ')';
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long size) {
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = size;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DrawContextKt.getDefaultDensity() : density, (i & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i & 4) != 0 ? new EmptyCanvas() : canvas, (i & 8) != 0 ? Size.INSTANCE.m4127getZeroNHjbRc() : j, null);
        }

        public final Density getDensity() {
            return this.density;
        }

        public final void setDensity(Density density) {
            this.density = density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(Canvas canvas) {
            this.canvas = canvas;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m4777getSizeNHjbRc() {
            return this.size;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m4778setSizeuvyYCjk(long j) {
            this.size = j;
        }
    }
}
