package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidGraphicsLayer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00ad\u00012\u00020\u0001:\u0002\u00ad\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0082\u0001\u001a\u0002092\u0007\u0010\u0083\u0001\u001a\u00020\u0000H\u0002JE\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010p\u001a\u00020d2\u0018\u0010\u0085\u0001\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020907¢\u0006\u0002\b:ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\t\u0010\u0088\u0001\u001a\u000209H\u0002J\t\u0010\u0089\u0001\u001a\u000209H\u0002J\u000f\u0010\u008a\u0001\u001a\u000209H\u0000¢\u0006\u0003\b\u008b\u0001J$\u0010\u008c\u0001\u001a\u0002092\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\b\u0090\u0001J\t\u0010\u0091\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0092\u0001\u001a\u000209H\u0002J\t\u0010\u0093\u0001\u001a\u000209H\u0002J\u000f\u0010\u0094\u0001\u001a\u000209H\u0000¢\u0006\u0003\b\u0095\u0001J\t\u0010\u0096\u0001\u001a\u000209H\u0002J5\u0010\u0097\u0001\u001a\u0003H\u0098\u0001\"\u0005\b\u0000\u0010\u0098\u00012\u001b\u0010\u0085\u0001\u001a\u0016\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020d\u0012\u0005\u0012\u0003H\u0098\u00010\u0099\u0001H\u0082\b¢\u0006\u0003\u0010\u009a\u0001J\u0010\u0010\u009b\u0001\u001a\u0002092\u0007\u0010\u009c\u0001\u001a\u00020IJ%\u0010\u009d\u0001\u001a\u0002092\u0006\u0010x\u001a\u00020f2\u0006\u0010p\u001a\u00020dH\u0002ø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J'\u0010 \u0001\u001a\u0002092\b\b\u0002\u0010x\u001a\u00020f2\b\b\u0002\u0010p\u001a\u00020dø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010\u009f\u0001J2\u0010¢\u0001\u001a\u0002092\b\b\u0002\u0010x\u001a\u00020f2\b\b\u0002\u0010p\u001a\u00020d2\t\b\u0002\u0010£\u0001\u001a\u00020\bø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0011\u0010¦\u0001\u001a\u00030§\u0001H\u0086@¢\u0006\u0003\u0010¨\u0001J\u0013\u0010©\u0001\u001a\u0002092\b\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\u0012\u0010¬\u0001\u001a\u00020\u00162\u0007\u0010\u009c\u0001\u001a\u00020IH\u0002R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR,\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00178F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010#\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\u0012\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0007\u001a\u0004\u0018\u00010*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00101\u001a\u0002002\u0006\u0010\u0007\u001a\u0002008F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u00106\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020907¢\u0006\u0002\b:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010>\u001a\u00020\"2\u0006\u0010=\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010D\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bK\u0010\u0011R\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010O\u001a\u00020N2\u0006\u0010\u0007\u001a\u00020N@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\bP\u0010\u0011\"\u0004\bQ\u0010\u0013R(\u0010S\u001a\u0004\u0018\u00010R2\b\u0010\u0007\u001a\u0004\u0018\u00010R8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010\u000b\"\u0004\bZ\u0010\rR$\u0010[\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\\\u0010\u000b\"\u0004\b]\u0010\rR$\u0010^\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010\u000b\"\u0004\b`\u0010\rR\u0010\u0010a\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010c\u001a\u00020dX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010e\u001a\u00020fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R$\u0010g\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010\u000b\"\u0004\bi\u0010\rR$\u0010j\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010\u000b\"\u0004\bl\u0010\rR$\u0010m\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010\u000b\"\u0004\bo\u0010\rR,\u0010p\u001a\u00020d2\u0006\u0010\u0007\u001a\u00020d@@X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\bq\u0010\u0011\"\u0004\br\u0010\u0013R\u0010\u0010s\u001a\u0004\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010u\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\bv\u0010\u0011\"\u0004\bw\u0010\u0013R,\u0010x\u001a\u00020f2\u0006\u0010\u0007\u001a\u00020f@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\by\u0010\u0011\"\u0004\bz\u0010\u0013R$\u0010{\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010\u000b\"\u0004\b}\u0010\rR%\u0010~\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010\u000b\"\u0005\b\u0080\u0001\u0010\rR\u000f\u0010\u0081\u0001\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006®\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;Landroidx/compose/ui/graphics/layer/LayerManager;)V", DownloadUtil.CookieScheme.VALUE, "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "androidOutline", "Landroid/graphics/Outline;", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "clip", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "density", "Landroidx/compose/ui/unit/Density;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "<set-?>", "isReleased", "layerId", "", "getLayerId", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outlineDirty", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "ownerViewId", "getOwnerViewId", "parentLayerUsages", "", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "roundRectClipPath", "roundRectCornerRadius", "roundRectOutlineSize", "Landroidx/compose/ui/unit/IntSize;", "roundRectOutlineTopLeft", "Landroidx/compose/ui/unit/IntOffset;", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "size", "getSize-YbymL2g", "setSize-ozmzZPI$ui_graphics_release", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "topLeft", "getTopLeft-nOcc-ac", "setTopLeft--gyyYBs", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "usePathForClip", "addSubLayer", "graphicsLayer", "buildLayer", "block", "buildLayer-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "configureOutline", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "draw$ui_graphics_release", "obtainAndroidOutline", "onAddedToParentLayer", "onRemovedFromParentLayer", "release", "release$ui_graphics_release", "resetOutlineParams", "resolveOutlinePosition", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "setPathOutline", DownloadUtil.CookieScheme.PATH, "setPosition", "setPosition-VbeCjmY", "(JJ)V", "setRectOutline", "setRectOutline-VbeCjmY", "setRoundRectOutline", "cornerRadius", "setRoundRectOutline-1IyobKY", "(JJF)V", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "updatePathOutline", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GraphicsLayer {
    private static final LayerSnapshotImpl SnapshotImpl;
    private long ambientShadowColor;
    private Outline androidOutline;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private final LayerManager layerManager;
    private Path outlinePath;
    private int parentLayerUsages;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long size;
    private Paint softwareLayerPaint;
    private long spotShadowColor;
    private long topLeft;
    private boolean usePathForClip;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long UnsetOffset = IntOffsetKt.IntOffset(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final long UnsetSize = IntSizeKt.IntSize(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private Function1<? super DrawScope, Unit> drawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope $this$null) {
        }
    };
    private boolean outlineDirty = true;
    private long roundRectOutlineTopLeft = UnsetOffset;
    private long roundRectOutlineSize = UnsetSize;
    private final ChildLayerDependenciesTracker childDependenciesTracker = new ChildLayerDependenciesTracker();

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidGraphicsLayer.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.ui.graphics.layer.GraphicsLayer", f = "AndroidGraphicsLayer.android.kt", i = {}, l = {790}, m = "toImageBitmap", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphicsLayer.this.toImageBitmap(this);
        }
    }

    public static /* synthetic */ void getClip$annotations() {
    }

    public GraphicsLayer(GraphicsLayerImpl impl, LayerManager layerManager) {
        this.impl = impl;
        this.layerManager = layerManager;
        this.impl.setClip(false);
        this.topLeft = IntOffset.INSTANCE.m6695getZeronOccac();
        this.size = IntSize.INSTANCE.m6732getZeroYbymL2g();
        this.pivotOffset = Offset.INSTANCE.m3816getUnspecifiedF1C5BW0();
        this.ambientShadowColor = Color.INSTANCE.m4069getBlack0d7_KjU();
        this.spotShadowColor = Color.INSTANCE.m4069getBlack0d7_KjU();
    }

    /* JADX INFO: renamed from: isReleased, reason: from getter */
    public final boolean getIsReleased() {
        return this.isReleased;
    }

    /* JADX INFO: renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m4701getCompositingStrategyke2Ky5w() {
        return this.impl.getCompositingStrategy();
    }

    /* JADX INFO: renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m4708setCompositingStrategyWpw9cng(int value) {
        if (!CompositingStrategy.m4688equalsimpl0(this.impl.getCompositingStrategy(), value)) {
            this.impl.mo4724setCompositingStrategyWpw9cng(value);
        }
    }

    /* JADX INFO: renamed from: getTopLeft-nOcc-ac, reason: not valid java name and from getter */
    public final long getTopLeft() {
        return this.topLeft;
    }

    /* JADX INFO: renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m4714setTopLeftgyyYBs(long value) {
        if (!IntOffset.m6684equalsimpl0(this.topLeft, value)) {
            this.topLeft = value;
            m4695setPositionVbeCjmY(value, this.size);
        }
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-ozmzZPI$ui_graphics_release, reason: not valid java name */
    public final void m4712setSizeozmzZPI$ui_graphics_release(long value) {
        if (!IntSize.m6725equalsimpl0(this.size, value)) {
            this.size = value;
            m4695setPositionVbeCjmY(this.topLeft, value);
        }
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final void setAlpha(float value) {
        if (!(this.impl.getAlpha() == value)) {
            this.impl.setAlpha(value);
        }
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m4700getBlendMode0nO6VwU() {
        return this.impl.getBlendMode();
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m4707setBlendModes9anfk8(int value) {
        if (!BlendMode.m3954equalsimpl0(this.impl.getBlendMode(), value)) {
            this.impl.mo4723setBlendModes9anfk8(value);
        }
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    public final void setColorFilter(ColorFilter value) {
        if (!Intrinsics.areEqual(this.impl.getColorFilter(), value)) {
            this.impl.setColorFilter(value);
        }
    }

    /* JADX INFO: renamed from: getPivotOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getPivotOffset() {
        return this.pivotOffset;
    }

    /* JADX INFO: renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m4709setPivotOffsetk4lQ0M(long value) {
        if (!Offset.m3798equalsimpl0(this.pivotOffset, value)) {
            this.pivotOffset = value;
            this.impl.mo4725setPivotOffsetk4lQ0M(value);
        }
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final void setScaleX(float value) {
        if (!(this.impl.getScaleX() == value)) {
            this.impl.setScaleX(value);
        }
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final void setScaleY(float value) {
        if (!(this.impl.getScaleY() == value)) {
            this.impl.setScaleY(value);
        }
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final void setTranslationX(float value) {
        if (!(this.impl.getTranslationX() == value)) {
            this.impl.setTranslationX(value);
        }
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void setTranslationY(float value) {
        if (!(this.impl.getTranslationY() == value)) {
            this.impl.setTranslationY(value);
        }
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final void setShadowElevation(float value) {
        if (!(this.impl.getShadowElevation() == value)) {
            this.impl.setShadowElevation(value);
        }
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final void setRotationX(float value) {
        if (!(this.impl.getRotationX() == value)) {
            this.impl.setRotationX(value);
        }
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final void setRotationY(float value) {
        if (!(this.impl.getRotationY() == value)) {
            this.impl.setRotationY(value);
        }
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final void setRotationZ(float value) {
        if (!(this.impl.getRotationZ() == value)) {
            this.impl.setRotationZ(value);
        }
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final void setCameraDistance(float value) {
        if (!(this.impl.getCameraDistance() == value)) {
            this.impl.setCameraDistance(value);
        }
    }

    public final boolean getClip() {
        return this.impl.getClip();
    }

    public final void setClip(boolean value) {
        if (this.impl.getClip() != value) {
            this.impl.setClip(value);
        }
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final void setRenderEffect(RenderEffect value) {
        if (!Intrinsics.areEqual(this.impl.getRenderEffect(), value)) {
            this.impl.setRenderEffect(value);
        }
    }

    /* JADX INFO: renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m4695setPositionVbeCjmY(long topLeft, long size) {
        this.impl.mo4726setPositionVbeCjmY(topLeft, size);
        this.outlineDirty = true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00e6 A[LOOP:0: B:23:0x0095->B:36:0x00e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f0 A[EDGE_INSN: B:43:0x00f0->B:38:0x00f0 BREAK  A[LOOP:0: B:23:0x0095->B:36:0x00e6], SYNTHETIC] */
    /* JADX INFO: renamed from: buildLayer-mL-hObY, reason: not valid java name */
    public final GraphicsLayer m4698buildLayermLhObY(Density density, LayoutDirection layoutDirection, long size, Function1<? super DrawScope, Unit> block) {
        if (!IntSize.m6725equalsimpl0(this.size, size)) {
            m4695setPositionVbeCjmY(this.topLeft, size);
            m4712setSizeozmzZPI$ui_graphics_release(size);
        }
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = block;
        this.impl.setInvalidated(true);
        ChildLayerDependenciesTracker this_$iv = this.childDependenciesTracker;
        this_$iv.oldDependency = this_$iv.dependency;
        MutableScatterSet currentSet$iv = this_$iv.dependenciesSet;
        if (currentSet$iv != null && currentSet$iv.isNotEmpty()) {
            MutableScatterSet it$iv = this_$iv.oldDependenciesSet;
            if (it$iv == null) {
                it$iv = ScatterSetKt.mutableScatterSetOf();
                this_$iv.oldDependenciesSet = it$iv;
            }
            it$iv.addAll(currentSet$iv);
            currentSet$iv.clear();
        }
        this_$iv.trackingInProgress = true;
        this.impl.buildLayer(density, layoutDirection, this, this.drawBlock);
        this_$iv.trackingInProgress = false;
        GraphicsLayer it = this_$iv.oldDependency;
        if (it != null) {
            it.onRemovedFromParentLayer();
        }
        MutableScatterSet oldSet$iv = this_$iv.oldDependenciesSet;
        if (oldSet$iv != null && oldSet$iv.isNotEmpty()) {
            MutableScatterSet this_$iv$iv = oldSet$iv;
            Object[] k$iv$iv = this_$iv$iv.elements;
            long[] m$iv$iv$iv = this_$iv$iv.metadata;
            int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
            int i$iv$iv$iv = 0;
            if (0 <= lastIndex$iv$iv$iv) {
                while (true) {
                    long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                    long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv == -9187201950435737472L) {
                        if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                            break;
                            break;
                        }
                        i$iv$iv$iv++;
                    } else {
                        int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                        for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                            long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                            int $i$f$isFull = value$iv$iv$iv$iv < 128 ? 1 : 0;
                            if ($i$f$isFull != 0) {
                                int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                                ((GraphicsLayer) k$iv$iv[index$iv$iv$iv]).onRemovedFromParentLayer();
                            }
                            slot$iv$iv$iv >>= 8;
                        }
                        if (bitCount$iv$iv$iv != 8) {
                            break;
                        }
                        if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                            break;
                        }
                        i$iv$iv$iv++;
                    }
                }
            }
            oldSet$iv.clear();
        }
        return this;
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        float left = IntOffset.m6685getXimpl(this.topLeft);
        float top = IntOffset.m6686getYimpl(this.topLeft);
        float right = IntOffset.m6685getXimpl(this.topLeft) + IntSize.m6727getWidthimpl(this.size);
        float bottom = IntOffset.m6686getYimpl(this.topLeft) + IntSize.m6726getHeightimpl(this.size);
        float layerAlpha = getAlpha();
        ColorFilter layerColorFilter = getColorFilter();
        int layerBlendMode = m4700getBlendMode0nO6VwU();
        boolean useSaveLayer = layerAlpha < 1.0f || !BlendMode.m3954equalsimpl0(layerBlendMode, BlendMode.INSTANCE.m3985getSrcOver0nO6VwU()) || layerColorFilter != null || CompositingStrategy.m4688equalsimpl0(m4701getCompositingStrategyke2Ky5w(), CompositingStrategy.INSTANCE.m4694getOffscreenke2Ky5w());
        if (useSaveLayer) {
            Paint it = this.softwareLayerPaint;
            if (it == null) {
                it = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = it;
            }
            Paint it2 = it;
            it2.setAlpha(layerAlpha);
            it2.mo3921setBlendModes9anfk8(layerBlendMode);
            it2.setColorFilter(layerColorFilter);
            Paint paint = it;
            androidCanvas.saveLayer(left, top, right, bottom, paint.getInternalPaint());
        } else {
            androidCanvas.save();
        }
        androidCanvas.translate(left, top);
        androidCanvas.concat(this.impl.calculateMatrix());
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer parentLayer) {
        if (this.isReleased) {
            return;
        }
        if (OffsetKt.m3822isUnspecifiedk4lQ0M(this.pivotOffset)) {
            this.impl.mo4725setPivotOffsetk4lQ0M(OffsetKt.Offset(IntSize.m6727getWidthimpl(this.size) / 2.0f, IntSize.m6726getHeightimpl(this.size) / 2.0f));
        }
        configureOutline();
        boolean willClipPath = true;
        boolean useZ = getShadowElevation() > 0.0f;
        if (useZ) {
            canvas.enableZ();
        }
        Canvas androidCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean softwareRendered = !androidCanvas.isHardwareAccelerated();
        if (softwareRendered) {
            androidCanvas.save();
            transformCanvas(androidCanvas);
        }
        if (!this.usePathForClip && (!softwareRendered || !getClip())) {
            willClipPath = false;
        }
        if (willClipPath) {
            canvas.save();
            androidx.compose.ui.graphics.Outline tmpOutline = getOutline();
            if (tmpOutline instanceof androidx.compose.ui.graphics.Outline.Rectangle) {
                androidx.compose.ui.graphics.Canvas.CC.m4017clipRectmtrdDE$default(canvas, tmpOutline.getRect(), 0, 2, null);
            } else if (tmpOutline instanceof androidx.compose.ui.graphics.Outline.Rounded) {
                Path rRectPath = this.roundRectClipPath;
                if (rRectPath != null) {
                    rRectPath.rewind();
                } else {
                    rRectPath = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = rRectPath;
                }
                Path.CC.addRoundRect$default(rRectPath, ((androidx.compose.ui.graphics.Outline.Rounded) tmpOutline).getRoundRect(), null, 2, null);
                androidx.compose.ui.graphics.Canvas.CC.m4015clipPathmtrdDE$default(canvas, rRectPath, 0, 2, null);
            } else if (tmpOutline instanceof androidx.compose.ui.graphics.Outline.Generic) {
                androidx.compose.ui.graphics.Canvas.CC.m4015clipPathmtrdDE$default(canvas, ((androidx.compose.ui.graphics.Outline.Generic) tmpOutline).getPath(), 0, 2, null);
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        this.impl.draw(canvas);
        if (willClipPath) {
            canvas.restore();
        }
        if (useZ) {
            canvas.disableZ();
        }
        if (softwareRendered) {
            androidCanvas.restore();
        }
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void configureOutline() {
        long j;
        long j2;
        boolean shouldClip = getClip() || getShadowElevation() > 0.0f;
        if (this.outlineDirty) {
            Path tmpPath = this.outlinePath;
            if (tmpPath != null) {
                Outline androidOutline = updatePathOutline(tmpPath);
                androidOutline.setAlpha(getAlpha());
                this.impl.setOutline(androidOutline, shouldClip);
            } else {
                Outline $this$configureOutline_u24lambda_u248 = obtainAndroidOutline();
                long layerTopLeft$iv = this.topLeft;
                long layerSize$iv = this.size;
                long rRectTopLeft$iv = this.roundRectOutlineTopLeft;
                long rRectSize$iv = this.roundRectOutlineSize;
                long layerSize$iv2 = INSTANCE.m4715getUnsetOffsetnOccac();
                if (IntOffset.m6684equalsimpl0(rRectTopLeft$iv, layerSize$iv2)) {
                    j = layerTopLeft$iv;
                } else {
                    j = rRectTopLeft$iv;
                }
                long outlineTopLeft$iv = j;
                if (IntSize.m6725equalsimpl0(rRectSize$iv, INSTANCE.m4716getUnsetSizeYbymL2g())) {
                    j2 = layerSize$iv;
                } else {
                    j2 = rRectSize$iv;
                }
                long outlineSize$iv = j2;
                $this$configureOutline_u24lambda_u248.setRoundRect(IntOffset.m6685getXimpl(outlineTopLeft$iv), IntOffset.m6686getYimpl(outlineTopLeft$iv), IntOffset.m6685getXimpl(outlineTopLeft$iv) + IntSize.m6727getWidthimpl(outlineSize$iv), IntOffset.m6686getYimpl(outlineTopLeft$iv) + IntSize.m6726getHeightimpl(outlineSize$iv), this.roundRectCornerRadius);
                $this$configureOutline_u24lambda_u248.setAlpha(getAlpha());
                this.impl.setOutline($this$configureOutline_u24lambda_u248, shouldClip);
            }
            this.outlineDirty = false;
        }
    }

    private final <T> T resolveOutlinePosition(Function2<? super IntOffset, ? super IntSize, ? extends T> block) {
        long outlineTopLeft;
        long outlineSize;
        long layerTopLeft = this.topLeft;
        long layerSize = this.size;
        long rRectTopLeft = this.roundRectOutlineTopLeft;
        long rRectSize = this.roundRectOutlineSize;
        if (IntOffset.m6684equalsimpl0(rRectTopLeft, INSTANCE.m4715getUnsetOffsetnOccac())) {
            outlineTopLeft = layerTopLeft;
        } else {
            outlineTopLeft = rRectTopLeft;
        }
        if (IntSize.m6725equalsimpl0(rRectSize, INSTANCE.m4716getUnsetSizeYbymL2g())) {
            outlineSize = layerSize;
        } else {
            outlineSize = rRectSize;
        }
        return block.invoke(IntOffset.m6676boximpl(outlineTopLeft), IntSize.m6719boximpl(outlineSize));
    }

    private final Outline updatePathOutline(Path path) {
        Outline resultOutline = obtainAndroidOutline();
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            if (Build.VERSION.SDK_INT > 30) {
                OutlineVerificationHelper.INSTANCE.setPath(resultOutline, path);
            } else if (path instanceof AndroidPath) {
                resultOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            this.usePathForClip = !resultOutline.canClip();
        } else {
            Outline outline = this.androidOutline;
            if (outline != null) {
                outline.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
        }
        this.outlinePath = path;
        return resultOutline;
    }

    private final Outline obtainAndroidOutline() {
        Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        Outline it = new Outline();
        this.androidOutline = it;
        return it;
    }

    public final void release$ui_graphics_release() {
        if (!this.isReleased) {
            this.isReleased = true;
            discardContentIfReleasedAndHaveNoParentLayerUsages();
        }
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            this.layerManager.release(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x008a A[LOOP:0: B:9:0x0032->B:22:0x008a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x009c A[EDGE_INSN: B:30:0x009c->B:25:0x009c BREAK  A[LOOP:0: B:9:0x0032->B:22:0x008a], SYNTHETIC] */
    public final void discardDisplayList$ui_graphics_release() {
        ChildLayerDependenciesTracker this_$iv = this.childDependenciesTracker;
        int $i$f$removeDependencies = 0;
        GraphicsLayer it$iv = this_$iv.dependency;
        if (it$iv != null) {
            it$iv.onRemovedFromParentLayer();
            this_$iv.dependency = null;
        }
        MutableScatterSet it$iv2 = this_$iv.dependenciesSet;
        if (it$iv2 != null) {
            int i = 0;
            MutableScatterSet this_$iv$iv = it$iv2;
            Object[] k$iv$iv = this_$iv$iv.elements;
            long[] m$iv$iv$iv = this_$iv$iv.metadata;
            int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
            int i$iv$iv$iv = 0;
            if (0 <= lastIndex$iv$iv$iv) {
                while (true) {
                    long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                    ChildLayerDependenciesTracker this_$iv2 = this_$iv;
                    int $i$f$removeDependencies2 = $i$f$removeDependencies;
                    int i2 = i;
                    ScatterSet this_$iv$iv2 = this_$iv$iv;
                    long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv == -9187201950435737472L) {
                        if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                            break;
                            break;
                        }
                        i$iv$iv$iv++;
                        i = i2;
                        this_$iv$iv = this_$iv$iv2;
                        this_$iv = this_$iv2;
                        $i$f$removeDependencies = $i$f$removeDependencies2;
                    } else {
                        int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                        for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                            long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                            if (value$iv$iv$iv$iv < 128) {
                                int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                                GraphicsLayer it = (GraphicsLayer) k$iv$iv[index$iv$iv$iv];
                                it.onRemovedFromParentLayer();
                            }
                            slot$iv$iv$iv >>= 8;
                        }
                        if (bitCount$iv$iv$iv != 8) {
                            break;
                        }
                        if (i$iv$iv$iv != lastIndex$iv$iv$iv) {
                            break;
                        }
                        i$iv$iv$iv++;
                        i = i2;
                        this_$iv$iv = this_$iv$iv2;
                        this_$iv = this_$iv2;
                        $i$f$removeDependencies = $i$f$removeDependencies2;
                    }
                }
            }
            it$iv2.clear();
        }
        this.impl.discardDisplayList();
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        long outlineTopLeft$iv;
        long outlineSize$iv;
        androidx.compose.ui.graphics.Outline tmpOutline = this.internalOutline;
        Path tmpPath = this.outlinePath;
        if (tmpOutline != null) {
            return tmpOutline;
        }
        if (tmpPath != null) {
            androidx.compose.ui.graphics.Outline.Generic it = new androidx.compose.ui.graphics.Outline.Generic(tmpPath);
            this.internalOutline = it;
            return it;
        }
        long layerTopLeft$iv = this.topLeft;
        long layerSize$iv = this.size;
        long rRectTopLeft$iv = this.roundRectOutlineTopLeft;
        long rRectSize$iv = this.roundRectOutlineSize;
        if (IntOffset.m6684equalsimpl0(rRectTopLeft$iv, INSTANCE.m4715getUnsetOffsetnOccac())) {
            outlineTopLeft$iv = layerTopLeft$iv;
        } else {
            outlineTopLeft$iv = rRectTopLeft$iv;
        }
        if (IntSize.m6725equalsimpl0(rRectSize$iv, INSTANCE.m4716getUnsetSizeYbymL2g())) {
            outlineSize$iv = layerSize$iv;
        } else {
            outlineSize$iv = rRectSize$iv;
        }
        long outlineTopLeft = outlineTopLeft$iv;
        long outlineSize = outlineSize$iv;
        float left = IntOffset.m6685getXimpl(outlineTopLeft);
        float top = IntOffset.m6686getYimpl(outlineTopLeft);
        float right = IntSize.m6727getWidthimpl(outlineSize) + left;
        int $i$f$resolveOutlinePosition = IntSize.m6726getHeightimpl(outlineSize);
        float bottom = $i$f$resolveOutlinePosition + top;
        float cornerRadius = this.roundRectCornerRadius;
        androidx.compose.ui.graphics.Outline.Rectangle it2 = cornerRadius > 0.0f ? new androidx.compose.ui.graphics.Outline.Rounded(RoundRectKt.m3855RoundRectgG7oq9Y(left, top, right, bottom, CornerRadiusKt.CornerRadius$default(cornerRadius, 0.0f, 2, null))) : new androidx.compose.ui.graphics.Outline.Rectangle(new Rect(left, top, right, bottom));
        this.internalOutline = it2;
        return it2;
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = UnsetSize;
        this.roundRectOutlineTopLeft = UnsetOffset;
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
    }

    /* JADX INFO: renamed from: setRoundRectOutline-1IyobKY, reason: not valid java name */
    public final void m4711setRoundRectOutline1IyobKY(long topLeft, long size, float cornerRadius) {
        if (IntOffset.m6684equalsimpl0(this.roundRectOutlineTopLeft, topLeft) && IntSize.m6725equalsimpl0(this.roundRectOutlineSize, size)) {
            if (this.roundRectCornerRadius == cornerRadius) {
                return;
            }
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = topLeft;
        this.roundRectOutlineSize = size;
        this.roundRectCornerRadius = cornerRadius;
    }

    /* JADX INFO: renamed from: setRectOutline-VbeCjmY$default, reason: not valid java name */
    public static /* synthetic */ void m4696setRectOutlineVbeCjmY$default(GraphicsLayer graphicsLayer, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = INSTANCE.m4715getUnsetOffsetnOccac();
        }
        if ((i & 2) != 0) {
            j2 = INSTANCE.m4716getUnsetSizeYbymL2g();
        }
        graphicsLayer.m4710setRectOutlineVbeCjmY(j, j2);
    }

    /* JADX INFO: renamed from: setRectOutline-VbeCjmY, reason: not valid java name */
    public final void m4710setRectOutlineVbeCjmY(long topLeft, long size) {
        m4711setRoundRectOutline1IyobKY(topLeft, size, 0.0f);
    }

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m4706setAmbientShadowColor8_81llA(long value) {
        if (!Color.m4044equalsimpl0(this.ambientShadowColor, value)) {
            this.impl.mo4722setAmbientShadowColor8_81llA(value);
            this.ambientShadowColor = value;
        }
    }

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m4713setSpotShadowColor8_81llA(long value) {
        if (!Color.m4044equalsimpl0(this.spotShadowColor, value)) {
            this.impl.mo4727setSpotShadowColor8_81llA(value);
            this.spotShadowColor = value;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object toImageBitmap(Continuation<? super ImageBitmap> continuation) {
        AnonymousClass1 anonymousClass1;
        Object bitmap;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LayerSnapshotImpl layerSnapshotImpl = SnapshotImpl;
                anonymousClass2.label = 1;
                bitmap = layerSnapshotImpl.toBitmap(this, anonymousClass2);
                if (bitmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                bitmap = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return AndroidImageBitmap_androidKt.asImageBitmap((Bitmap) bitmap);
    }

    /* JADX INFO: compiled from: AndroidGraphicsLayer.android.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer$Companion;", "", "()V", "SnapshotImpl", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "UnsetOffset", "Landroidx/compose/ui/unit/IntOffset;", "getUnsetOffset-nOcc-ac", "()J", "J", "UnsetSize", "Landroidx/compose/ui/unit/IntSize;", "getUnsetSize-YbymL2g", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnsetOffset-nOcc-ac, reason: not valid java name */
        public final long m4715getUnsetOffsetnOccac() {
            return GraphicsLayer.UnsetOffset;
        }

        /* JADX INFO: renamed from: getUnsetSize-YbymL2g, reason: not valid java name */
        public final long m4716getUnsetSizeYbymL2g() {
            return GraphicsLayer.UnsetSize;
        }
    }

    static {
        LayerSnapshotV21 layerSnapshotV21;
        if (Build.VERSION.SDK_INT >= 28) {
            layerSnapshotV21 = LayerSnapshotV28.INSTANCE;
        } else if (Build.VERSION.SDK_INT >= 22 && SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable()) {
            layerSnapshotV21 = LayerSnapshotV22.INSTANCE;
        } else {
            layerSnapshotV21 = LayerSnapshotV21.INSTANCE;
        }
        SnapshotImpl = layerSnapshotV21;
    }
}
